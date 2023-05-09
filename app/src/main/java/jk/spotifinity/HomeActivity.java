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
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.google.android.material.button.*;
import com.google.firebase.FirebaseApp;
import com.mannan.translateapi.*;
import com.tonyodev.fetch2.*;
import com.tonyodev.fetch2core.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class HomeActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private String ciao = "";
	TranslateAPI IT1;
	TranslateAPI IT2;
	TranslateAPI IT3;
	TranslateAPI IT4;
	TranslateAPI IT5;
	TranslateAPI IT6;
	TranslateAPI IT7;
	TranslateAPI IT8;
	TranslateAPI IT9;
	TranslateAPI IT10;
	TranslateAPI IT11;
	private HashMap<String, Object> req = new HashMap<>();
	
	private LinearLayout linear3;
	private LinearLayout linear4;
	private ImageView imageview1;
	private TextView textview17;
	private LinearLayout linear18;
	private ImageView imageview4;
	private LinearLayout linear19;
	private LinearLayout linear7;
	private LinearLayout linear12;
	private TextView textview7;
	private TextView textview18;
	private TextView textview19;
	private TextView textview20;
	private MaterialButton materialbutton3;
	private LinearLayout linear11;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private MaterialButton materialbutton1;
	private ImageView imageview2;
	private TextView textview10;
	private TextView textview4;
	private TextView textview2;
	private TextView textview5;
	private LinearLayout linear13;
	private LinearLayout linear16;
	private MaterialButton materialbutton2;
	private ImageView imageview3;
	private TextView textview16;
	private TextView textview14;
	private TextView textview15;
	
	private RequestNetwork version;
	private RequestNetwork.RequestListener _version_request_listener;
	private Intent intent = new Intent();
	private AlertDialog.Builder dialog;
	private TimerTask wait;
	private Intent launchIntent = new Intent();
	private RequestNetwork updater;
	private RequestNetwork.RequestListener _updater_request_listener;
	private AlertDialog.Builder dialog2;
	private RequestNetwork poll;
	private RequestNetwork.RequestListener _poll_request_listener;
	private RequestNetwork pollNome;
	private RequestNetwork.RequestListener _pollNome_request_listener;
	private RequestNetwork pollLink;
	private RequestNetwork.RequestListener _pollLink_request_listener;
	private Intent sondaggio = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
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
		linear4 = findViewById(R.id.linear4);
		imageview1 = findViewById(R.id.imageview1);
		textview17 = findViewById(R.id.textview17);
		linear18 = findViewById(R.id.linear18);
		imageview4 = findViewById(R.id.imageview4);
		linear19 = findViewById(R.id.linear19);
		linear7 = findViewById(R.id.linear7);
		linear12 = findViewById(R.id.linear12);
		textview7 = findViewById(R.id.textview7);
		textview18 = findViewById(R.id.textview18);
		textview19 = findViewById(R.id.textview19);
		textview20 = findViewById(R.id.textview20);
		materialbutton3 = findViewById(R.id.materialbutton3);
		linear11 = findViewById(R.id.linear11);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		materialbutton1 = findViewById(R.id.materialbutton1);
		imageview2 = findViewById(R.id.imageview2);
		textview10 = findViewById(R.id.textview10);
		textview4 = findViewById(R.id.textview4);
		textview2 = findViewById(R.id.textview2);
		textview5 = findViewById(R.id.textview5);
		linear13 = findViewById(R.id.linear13);
		linear16 = findViewById(R.id.linear16);
		materialbutton2 = findViewById(R.id.materialbutton2);
		imageview3 = findViewById(R.id.imageview3);
		textview16 = findViewById(R.id.textview16);
		textview14 = findViewById(R.id.textview14);
		textview15 = findViewById(R.id.textview15);
		version = new RequestNetwork(this);
		dialog = new AlertDialog.Builder(this);
		updater = new RequestNetwork(this);
		dialog2 = new AlertDialog.Builder(this);
		poll = new RequestNetwork(this);
		pollNome = new RequestNetwork(this);
		pollLink = new RequestNetwork(this);
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				imageview4.startAnimation(fade_in);
				intent.setClass(getApplicationContext(), ImpostazioniActivity.class);
				startActivity(intent);
			}
		});
		
		materialbutton3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				materialbutton3.startAnimation(fade_in);
				startActivity(sondaggio);
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				materialbutton1.startAnimation(fade_in);
				intent.putExtra("ultima", textview5.getText().toString());
				intent.setClass(getApplicationContext(), SelversioneActivity.class);
				startActivity(intent);
			}
		});
		
		materialbutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				materialbutton2.startAnimation(fade_in);
				_ApriApp("com.spotify.music");
			}
		});
		
		_version_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				textview5.setText(_response);
				if (textview5.getText().toString().equals(textview15.getText().toString())) {
					linear8.setVisibility(View.GONE);
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				SketchwareUtil.showMessage(getApplicationContext(), "Impossibile ottenere ultima versione della mod: ".concat(_message));
			}
		};
		
		_updater_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				if (!(Double.parseDouble(_response) == 6)) {
					if (!FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/skipUpdate")) {
						dialog.setTitle("Nuovo aggiornamento");
						dialog.setMessage("E stato rilevato una versione più recente di questa applicazione.\nVuoi andare sul sito di GitHub per scaricare l'ultima versione?");
						dialog.setPositiveButton("Aggiorna", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								intent.setAction(Intent.ACTION_VIEW);
								intent.setData(Uri.parse("https://github.com/Spotifinity/app/releases"));
								startActivity(intent);
							}
						});
						dialog.setNegativeButton("Ignora", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								SketchwareUtil.showMessage(getApplicationContext(), "Ignorato");
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
										FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/skipUpdate", "");
										SketchwareUtil.showMessage(getApplicationContext(), "Saltato, da ora in poi non ti chiederò di aggiornare l'app");
									}
								});
								dialog2.setNegativeButton("No", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										
									}
								});
								dialog2.create().show();
							}
						});
						dialog.create().show();
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Aggiornamento trovato però e stato saltato");
					}
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				SketchwareUtil.showMessage(getApplicationContext(), "Impossibile trovare nuovi aggiornamenti!");
			}
		};
		
		_poll_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				if (_response.equals("0")) {
					linear19.setVisibility(View.GONE);
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_pollNome_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				textview20.setText(_response);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_pollLink_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				sondaggio.setAction(Intent.ACTION_VIEW);
				sondaggio.setData(Uri.parse(_response));
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		updater.startRequestNetwork(RequestNetworkController.GET, "https://pastefy.ga/V64UVdii/raw", "", _updater_request_listener);
		version.startRequestNetwork(RequestNetworkController.GET, "https://pastefy.ga/3DjQQQZG/raw", "", _version_request_listener);
		poll.startRequestNetwork(RequestNetworkController.GET, "https://pastefy.ga/AoC5b38b/raw", "", _poll_request_listener);
		pollNome.startRequestNetwork(RequestNetworkController.GET, "https://pastefy.ga/NaUiBndI/raw", "", _pollNome_request_listener);
		pollLink.startRequestNetwork(RequestNetworkController.GET, "https://pastefy.ga/45ITHFZO/raw", "", _pollLink_request_listener);
		dialog = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		textview10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		textview16.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		textview17.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		textview14.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		textview15.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		materialbutton1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		materialbutton2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		textview18.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		textview19.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		textview20.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		materialbutton3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFF05AF34));
		linear7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFF424242));
		linear12.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFF424242));
		linear19.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFF424242));
	}
	
	@Override
	public void onStart() {
		super.onStart();
		FileUtil.deleteFile("storage/emulated/0/Android/data/jk.spotifinity/skipLoad");
		if (!FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/modSviluppatore")) {
			textview7.setVisibility(View.GONE);
		}
		if (!FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/downloaded.txt").equals("Nessuna")) {
			textview15.setText(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/downloaded.txt"));
		}
		else {
			linear8.setVisibility(View.VISIBLE);
			textview4.setText("Mod ancora non installata, installala ora!");
			materialbutton2.setVisibility(View.GONE);
		}
	}
	public void _ApriApp(final String _app) {
		Intent launchIntent = getPackageManager().getLaunchIntentForPackage(_app);  { startActivity(launchIntent);}
	}
	
	
	public void _Traduci(final String _codice) {
		if (_codice.equals("it")) {
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		else {
			if (_codice.equals("sq")) {
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
			else {
				if (_codice.equals("ru")) {
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				}
				else {
					
				}
			}
		}
	}
	
}