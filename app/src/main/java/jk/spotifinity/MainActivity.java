package jk.spotifinity;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.room.*;
import androidx.sqlite.db.*;
import androidx.sqlite.db.framework.*;
import com.tonyodev.fetch2.*;
import com.tonyodev.fetch2core.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class MainActivity extends AppCompatActivity {
	
	private LinearLayout linear3;
	private ImageView imageview1;
	
	private Intent intent = new Intent();
	private RequestNetwork updater;
	private RequestNetwork.RequestListener _updater_request_listener;
	private AlertDialog.Builder dialog;
	private AlertDialog.Builder dialog2;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear3 = findViewById(R.id.linear3);
		imageview1 = findViewById(R.id.imageview1);
		updater = new RequestNetwork(this);
		dialog = new AlertDialog.Builder(this);
		dialog2 = new AlertDialog.Builder(this);
		
		_updater_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				if (!(Double.parseDouble(_response) == 1)) {
					if (!FileUtil.isExistFile("storage/emulated/0/spotifinity/skipUpdate")) {
						dialog.setTitle("Nuovo aggiornamento");
						dialog.setMessage("E stato rilevato una versione più recente di questa applicazione.\nVuoi andare sul sito di GitHub per scaricare l'ultima versione?");
						dialog.setPositiveButton("Aggiorna", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								intent.setAction(Intent.ACTION_VIEW);
								intent.setData(Uri.parse("https://github.com/Chill-Paradise/Spotified/releases"));
								startActivity(intent);
							}
						});
						dialog.setNegativeButton("Ignora", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								SketchwareUtil.showMessage(getApplicationContext(), "Ignorato");
								if (FileUtil.isExistFile("/storage/emulated/0/spotifinity/skipWelcome")) {
									intent.setClass(getApplicationContext(), HomeActivity.class);
									startActivity(intent);
								}
								else {
									intent.setClass(getApplicationContext(), BenvenutoActivity.class);
									startActivity(intent);
								}
							}
						});
						dialog.setNeutralButton("Salta", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								dialog2.setTitle("Salta aggiornamento");
								dialog2.setMessage("Vuoi veramente saltare questo e i futuri aggiornamenti di questa applicazione?");
								dialog2.setPositiveButton("Si", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										FileUtil.writeFile("storage/emulated/0/spotifinity/skipUpdate", "");
										SketchwareUtil.showMessage(getApplicationContext(), "Saltato, da ora in poi non ti chiederò di aggiornare l'app");
										intent.setClass(getApplicationContext(), HomeActivity.class);
										startActivity(intent);
									}
								});
								dialog2.setNegativeButton("No", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										if (FileUtil.isExistFile("/storage/emulated/0/spotifinity/skipWelcome")) {
											intent.setClass(getApplicationContext(), HomeActivity.class);
											startActivity(intent);
										}
										else {
											intent.setClass(getApplicationContext(), BenvenutoActivity.class);
											startActivity(intent);
										}
									}
								});
								dialog2.create().show();
							}
						});
						dialog.create().show();
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Aggiornamento trovato però e stato saltato");
						intent.setClass(getApplicationContext(), HomeActivity.class);
						startActivity(intent);
					}
				}
				else {
					if (FileUtil.isExistFile("/storage/emulated/0/spotifinity/skipWelcome")) {
						intent.setClass(getApplicationContext(), HomeActivity.class);
						startActivity(intent);
					}
					else {
						intent.setClass(getApplicationContext(), BenvenutoActivity.class);
						startActivity(intent);
					}
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				SketchwareUtil.showMessage(getApplicationContext(), "Impossibile trovare aggiornamenti: ".concat(_message));
				if (FileUtil.isExistFile("/storage/emulated/0/spotified/skipWelcome")) {
					intent.setClass(getApplicationContext(), HomeActivity.class);
					startActivity(intent);
				}
				else {
					intent.setClass(getApplicationContext(), BenvenutoActivity.class);
					startActivity(intent);
				}
			}
		};
	}
	
	private void initializeLogic() {
		dialog = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		dialog2 = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		updater.startRequestNetwork(RequestNetworkController.GET, "https://raw.githubusercontent.com/Chill-Paradise/Spotified/main/info/ver.txt", "", _updater_request_listener);
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}