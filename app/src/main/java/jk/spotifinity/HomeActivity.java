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
	private LinearLayout linear7;
	private LinearLayout linear12;
	private TextView textview9;
	private TextView textview7;
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
		linear7 = findViewById(R.id.linear7);
		linear12 = findViewById(R.id.linear12);
		textview9 = findViewById(R.id.textview9);
		textview7 = findViewById(R.id.textview7);
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
		
		textview9.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				textview9.startAnimation(fade_in);
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://discord.com/channels/1099806892416577538/1099829739000168488/1100693119395168367"));
				startActivity(intent);
				return true;
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				materialbutton1.startAnimation(fade_in);
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
				if (!(Double.parseDouble(_response) == 4)) {
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
	}
	
	private void initializeLogic() {
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
		textview9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		materialbutton1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		materialbutton2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFF05AF34));
		linear7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFF424242));
		linear12.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFF424242));
		if (FileUtil.isExistFile("storage/emulated/0/Android/data/com.spotify.music")) {
			textview15.setText(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/downloaded.txt"));
		}
		else {
			FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/downloaded.txt", "Nessuna");
			linear8.setVisibility(View.VISIBLE);
			textview4.setText("Mod ancora non installata, installala ora!");
			materialbutton2.setVisibility(View.GONE);
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		updater.startRequestNetwork(RequestNetworkController.GET, "https://raw.githubusercontent.com/Spotifinity/app/main/info/ver.txt", "", _updater_request_listener);
		version.startRequestNetwork(RequestNetworkController.GET, "https://pastefy.ga/3DjQQQZG/raw", "", _version_request_listener);
		if (!FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/modSviluppatore")) {
			textview7.setVisibility(View.GONE);
		}
	}
	public void _ApriApp(final String _app) {
		Intent launchIntent = getPackageManager().getLaunchIntentForPackage(_app);  { startActivity(launchIntent);}
	}
	
	
	public void _Traduci(final String _codice) {
		if (_codice.equals("it")) {
			TranslateAPI IT1 = new TranslateAPI(
							Language.AUTO_DETECT,
							Language.ITALIAN,
							textview9.getText().toString());
			TranslateAPI IT2 = new TranslateAPI(
							Language.AUTO_DETECT,
							Language.ITALIAN,
							textview7.getText().toString());
			TranslateAPI IT3 = new TranslateAPI(
							Language.AUTO_DETECT,
							Language.ITALIAN,
							materialbutton1.getText().toString());
			TranslateAPI IT4 = new TranslateAPI(
							Language.AUTO_DETECT,
							Language.ITALIAN,
							textview10.getText().toString());
			TranslateAPI IT5 = new TranslateAPI(
							Language.AUTO_DETECT,
							Language.ITALIAN,
							textview4.getText().toString());
			TranslateAPI IT6 = new TranslateAPI(
							Language.AUTO_DETECT,
							Language.ITALIAN,
							textview2.getText().toString());
			TranslateAPI IT8 = new TranslateAPI(
							Language.AUTO_DETECT,
							Language.ITALIAN,
							materialbutton2.getText().toString());
			TranslateAPI IT9 = new TranslateAPI(
							Language.AUTO_DETECT,
							Language.ITALIAN,
							textview16.getText().toString());
			TranslateAPI IT10 = new TranslateAPI(
							Language.AUTO_DETECT,
							Language.ITALIAN,
							textview14.getText().toString());
			TranslateAPI IT11 = new TranslateAPI(
							Language.AUTO_DETECT,
							Language.ITALIAN,
							textview15.getText().toString());
			IT1.setTranslateListener(new TranslateAPI.TranslateListener() {
										@Override
										public void onSuccess(String translatedText) {
								textview9.setText(translatedText);
										}
						
										@Override
										public void onFailure(String ErrorText) {
								 
										}
							});
			IT2.setTranslateListener(new TranslateAPI.TranslateListener() {
										@Override
										public void onSuccess(String translatedText) {
								textview7.setText(translatedText);
										}
						
										@Override
										public void onFailure(String ErrorText) {
								 
										}
							});
			IT3.setTranslateListener(new TranslateAPI.TranslateListener() {
										@Override
										public void onSuccess(String translatedText) {
								materialbutton1.setText(translatedText);
										}
						
										@Override
										public void onFailure(String ErrorText) {
								 
										}
							});
			IT4.setTranslateListener(new TranslateAPI.TranslateListener() {
										@Override
										public void onSuccess(String translatedText) {
								textview10.setText(translatedText);
										}
						
										@Override
										public void onFailure(String ErrorText) {
								 
										}
							});
			IT5.setTranslateListener(new TranslateAPI.TranslateListener() {
										@Override
										public void onSuccess(String translatedText) {
								textview4.setText(translatedText);
										}
						
										@Override
										public void onFailure(String ErrorText) {
								 
										}
							});
			IT6.setTranslateListener(new TranslateAPI.TranslateListener() {
										@Override
										public void onSuccess(String translatedText) {
								textview2.setText(translatedText);
										}
						
										@Override
										public void onFailure(String ErrorText) {
								 
										}
							});
			IT8.setTranslateListener(new TranslateAPI.TranslateListener() {
										@Override
										public void onSuccess(String translatedText) {
								materialbutton2.setText(translatedText);
										}
						
										@Override
										public void onFailure(String ErrorText) {
								 
										}
							});
			IT9.setTranslateListener(new TranslateAPI.TranslateListener() {
										@Override
										public void onSuccess(String translatedText) {
								textview16.setText(translatedText);
										}
						
										@Override
										public void onFailure(String ErrorText) {
								 
										}
							});
			IT10.setTranslateListener(new TranslateAPI.TranslateListener() {
										@Override
										public void onSuccess(String translatedText) {
								textview14.setText(translatedText);
										}
						
										@Override
										public void onFailure(String ErrorText) {
								 
										}
							});
			IT11.setTranslateListener(new TranslateAPI.TranslateListener() {
										@Override
										public void onSuccess(String translatedText) {
								textview15.setText(translatedText);
										}
						
										@Override
										public void onFailure(String ErrorText) {
								 
										}
							});
		}
		else {
			if (_codice.equals("sq")) {
				TranslateAPI IT1 = new TranslateAPI(
								Language.AUTO_DETECT,
								Language.ALBANIAN,
								textview9.getText().toString());
				TranslateAPI IT2 = new TranslateAPI(
								Language.AUTO_DETECT,
								Language.ALBANIAN,
								textview7.getText().toString());
				TranslateAPI IT3 = new TranslateAPI(
								Language.AUTO_DETECT,
								Language.ALBANIAN,
								materialbutton1.getText().toString());
				TranslateAPI IT4 = new TranslateAPI(
								Language.AUTO_DETECT,
								Language.ALBANIAN,
								textview10.getText().toString());
				TranslateAPI IT5 = new TranslateAPI(
								Language.AUTO_DETECT,
								Language.ALBANIAN,
								textview4.getText().toString());
				TranslateAPI IT6 = new TranslateAPI(
								Language.AUTO_DETECT,
								Language.ALBANIAN,
								textview2.getText().toString());
				TranslateAPI IT8 = new TranslateAPI(
								Language.AUTO_DETECT,
								Language.ALBANIAN,
								materialbutton2.getText().toString());
				TranslateAPI IT9 = new TranslateAPI(
								Language.AUTO_DETECT,
								Language.ALBANIAN,
								textview16.getText().toString());
				TranslateAPI IT10 = new TranslateAPI(
								Language.AUTO_DETECT,
								Language.ALBANIAN,
								textview14.getText().toString());
				TranslateAPI IT11 = new TranslateAPI(
								Language.AUTO_DETECT,
								Language.ALBANIAN,
								textview15.getText().toString());
				IT1.setTranslateListener(new TranslateAPI.TranslateListener() {
											@Override
											public void onSuccess(String translatedText) {
									textview9.setText(translatedText);
											}
							
											@Override
											public void onFailure(String ErrorText) {
									 
											}
								});
				IT2.setTranslateListener(new TranslateAPI.TranslateListener() {
											@Override
											public void onSuccess(String translatedText) {
									textview7.setText(translatedText);
											}
							
											@Override
											public void onFailure(String ErrorText) {
									 
											}
								});
				IT3.setTranslateListener(new TranslateAPI.TranslateListener() {
											@Override
											public void onSuccess(String translatedText) {
									materialbutton1.setText(translatedText);
											}
							
											@Override
											public void onFailure(String ErrorText) {
									 
											}
								});
				IT4.setTranslateListener(new TranslateAPI.TranslateListener() {
											@Override
											public void onSuccess(String translatedText) {
									textview10.setText(translatedText);
											}
							
											@Override
											public void onFailure(String ErrorText) {
									 
											}
								});
				IT5.setTranslateListener(new TranslateAPI.TranslateListener() {
											@Override
											public void onSuccess(String translatedText) {
									textview4.setText(translatedText);
											}
							
											@Override
											public void onFailure(String ErrorText) {
									 
											}
								});
				IT6.setTranslateListener(new TranslateAPI.TranslateListener() {
											@Override
											public void onSuccess(String translatedText) {
									textview2.setText(translatedText);
											}
							
											@Override
											public void onFailure(String ErrorText) {
									 
											}
								});
				IT8.setTranslateListener(new TranslateAPI.TranslateListener() {
											@Override
											public void onSuccess(String translatedText) {
									materialbutton2.setText(translatedText);
											}
							
											@Override
											public void onFailure(String ErrorText) {
									 
											}
								});
				IT9.setTranslateListener(new TranslateAPI.TranslateListener() {
											@Override
											public void onSuccess(String translatedText) {
									textview16.setText(translatedText);
											}
							
											@Override
											public void onFailure(String ErrorText) {
									 
											}
								});
				IT10.setTranslateListener(new TranslateAPI.TranslateListener() {
											@Override
											public void onSuccess(String translatedText) {
									textview14.setText(translatedText);
											}
							
											@Override
											public void onFailure(String ErrorText) {
									 
											}
								});
				IT11.setTranslateListener(new TranslateAPI.TranslateListener() {
											@Override
											public void onSuccess(String translatedText) {
									textview15.setText(translatedText);
											}
							
											@Override
											public void onFailure(String ErrorText) {
									 
											}
								});
			}
			else {
				if (_codice.equals("ru")) {
					TranslateAPI IT1 = new TranslateAPI(
									Language.AUTO_DETECT,
									Language.RUSSIAN,
									textview9.getText().toString());
					TranslateAPI IT2 = new TranslateAPI(
									Language.AUTO_DETECT,
									Language.RUSSIAN,
									textview7.getText().toString());
					TranslateAPI IT3 = new TranslateAPI(
									Language.AUTO_DETECT,
									Language.RUSSIAN,
									materialbutton1.getText().toString());
					TranslateAPI IT4 = new TranslateAPI(
									Language.AUTO_DETECT,
									Language.RUSSIAN,
									textview10.getText().toString());
					TranslateAPI IT5 = new TranslateAPI(
									Language.AUTO_DETECT,
									Language.RUSSIAN,
									textview4.getText().toString());
					TranslateAPI IT6 = new TranslateAPI(
									Language.AUTO_DETECT,
									Language.RUSSIAN,
									textview2.getText().toString());
					TranslateAPI IT8 = new TranslateAPI(
									Language.AUTO_DETECT,
									Language.RUSSIAN,
									materialbutton2.getText().toString());
					TranslateAPI IT9 = new TranslateAPI(
									Language.AUTO_DETECT,
									Language.RUSSIAN,
									textview16.getText().toString());
					TranslateAPI IT10 = new TranslateAPI(
									Language.AUTO_DETECT,
									Language.RUSSIAN,
									textview14.getText().toString());
					TranslateAPI IT11 = new TranslateAPI(
									Language.AUTO_DETECT,
									Language.RUSSIAN,
									textview15.getText().toString());
					IT1.setTranslateListener(new TranslateAPI.TranslateListener() {
												@Override
												public void onSuccess(String translatedText) {
										textview9.setText(translatedText);
												}
								
												@Override
												public void onFailure(String ErrorText) {
										 
												}
									});
					IT2.setTranslateListener(new TranslateAPI.TranslateListener() {
												@Override
												public void onSuccess(String translatedText) {
										textview7.setText(translatedText);
												}
								
												@Override
												public void onFailure(String ErrorText) {
										 
												}
									});
					IT3.setTranslateListener(new TranslateAPI.TranslateListener() {
												@Override
												public void onSuccess(String translatedText) {
										materialbutton1.setText(translatedText);
												}
								
												@Override
												public void onFailure(String ErrorText) {
										 
												}
									});
					IT4.setTranslateListener(new TranslateAPI.TranslateListener() {
												@Override
												public void onSuccess(String translatedText) {
										textview10.setText(translatedText);
												}
								
												@Override
												public void onFailure(String ErrorText) {
										 
												}
									});
					IT5.setTranslateListener(new TranslateAPI.TranslateListener() {
												@Override
												public void onSuccess(String translatedText) {
										textview4.setText(translatedText);
												}
								
												@Override
												public void onFailure(String ErrorText) {
										 
												}
									});
					IT6.setTranslateListener(new TranslateAPI.TranslateListener() {
												@Override
												public void onSuccess(String translatedText) {
										textview2.setText(translatedText);
												}
								
												@Override
												public void onFailure(String ErrorText) {
										 
												}
									});
					IT8.setTranslateListener(new TranslateAPI.TranslateListener() {
												@Override
												public void onSuccess(String translatedText) {
										materialbutton2.setText(translatedText);
												}
								
												@Override
												public void onFailure(String ErrorText) {
										 
												}
									});
					IT9.setTranslateListener(new TranslateAPI.TranslateListener() {
												@Override
												public void onSuccess(String translatedText) {
										textview16.setText(translatedText);
												}
								
												@Override
												public void onFailure(String ErrorText) {
										 
												}
									});
					IT10.setTranslateListener(new TranslateAPI.TranslateListener() {
												@Override
												public void onSuccess(String translatedText) {
										textview14.setText(translatedText);
												}
								
												@Override
												public void onFailure(String ErrorText) {
										 
												}
									});
					IT11.setTranslateListener(new TranslateAPI.TranslateListener() {
												@Override
												public void onSuccess(String translatedText) {
										textview15.setText(translatedText);
												}
								
												@Override
												public void onFailure(String ErrorText) {
										 
												}
									});
				}
				else {
					
				}
			}
		}
	}
	
}