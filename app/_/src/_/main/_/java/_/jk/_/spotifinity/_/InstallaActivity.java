package jk.spotifinity;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
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
import android.os.Vibrator;
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
import android.widget.ProgressBar;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class InstallaActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private String Version = "";
	private String errorMessage = "";
	TranslateAPI TA;
	private String tv8 = "";
	private String snacktext = "";
	private String snackbutton = "";
	private String at = "";
	private String am = "";
	private String aok = "";
	private String ac = "";
	
	private ArrayList<HashMap<String, Object>> lista = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear3;
	private LinearLayout linear5;
	private LinearLayout linear8;
	private ImageView imageview2;
	private TextView textview1;
	private LinearLayout linear6;
	private LinearLayout linear9;
	private LinearLayout linear12;
	private ProgressBar progressbar2;
	private TextView textview8;
	private TextView textview3;
	private MaterialButton materialbutton2;
	private MaterialButton materialbutton1;
	private TextView textview10;
	private LinearLayout linear7;
	private TextView textview6;
	private TextView textview7;
	private TextView textview2;
	private TextView textview4;
	
	private TimerTask check;
	private Intent intent = new Intent();
	private TimerTask wait;
	private Intent launchIntent = new Intent();
	private Vibrator finish;
	private AlertDialog.Builder avviso;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.installa);
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
		linear1 = findViewById(R.id.linear1);
		linear3 = findViewById(R.id.linear3);
		linear5 = findViewById(R.id.linear5);
		linear8 = findViewById(R.id.linear8);
		imageview2 = findViewById(R.id.imageview2);
		textview1 = findViewById(R.id.textview1);
		linear6 = findViewById(R.id.linear6);
		linear9 = findViewById(R.id.linear9);
		linear12 = findViewById(R.id.linear12);
		progressbar2 = findViewById(R.id.progressbar2);
		textview8 = findViewById(R.id.textview8);
		textview3 = findViewById(R.id.textview3);
		materialbutton2 = findViewById(R.id.materialbutton2);
		materialbutton1 = findViewById(R.id.materialbutton1);
		textview10 = findViewById(R.id.textview10);
		linear7 = findViewById(R.id.linear7);
		textview6 = findViewById(R.id.textview6);
		textview7 = findViewById(R.id.textview7);
		textview2 = findViewById(R.id.textview2);
		textview4 = findViewById(R.id.textview4);
		finish = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		avviso = new AlertDialog.Builder(this);
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.deleteFile("storage/emulated/0/Android/data/jk.spotifinity/mod.apk");
				finish();
			}
		});
		
		materialbutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				//this moblock crate APKBILDERBD
				//https://youtube.com/channel/UCU2ez8M6S1Zod1jFHifH__g
				
				final PRDownloaderConfig config = PRDownloaderConfig.newBuilder()
					.setDatabaseEnabled(true)
					.build();
				PRDownloader.initialize(InstallaActivity.this, config);
				
				materialbutton2.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						URLFile = textview4.getText().toString();
						dirPath = FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt").concat("/");
							if (Status.RUNNING == PRDownloader.getStatus(downloadId)) {
									PRDownloader.pause(downloadId);
									return;
							}
							materialbutton2.setEnabled(false);
							progressbar2.setIndeterminate(true);
							progressbar2.getIndeterminateDrawable().setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
							if (Status.PAUSED == PRDownloader.getStatus(downloadId)) {
									PRDownloader.resume(downloadId);
									return;
							}
							downloadId = PRDownloader.download(URLFile, dirPath, "mod.apk")
								.build()
								.setOnStartOrResumeListener(new OnStartOrResumeListener() {
										@Override
										public void onStartOrResume() {
												progressbar2.setIndeterminate(false);
												materialbutton2.setEnabled(true);
												materialbutton2.setText("Pause");
												imageview2.setEnabled(true);
										}
							})
							.setOnPauseListener(new OnPauseListener() {
									@Override
									public void onPause() {
											materialbutton2.setText("Resume");
									}
							})
							.setOnCancelListener(new OnCancelListener() {
									@Override
									public void onCancel() {
											materialbutton2.setText("Start");
											imageview2.setEnabled(false);
											progressbar2.setProgress(0);
											textview3.setText("");
											downloadId = 0;
											progressbar2.setIndeterminate(false);
									}
							})
							.setOnProgressListener(new OnProgressListener() {
									@Override
									public void onProgress(Progress progress) {
											long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
											progressbar2.setProgress((int) progressPercent);
											textview3.setText(Utilss.getProgressDisplayLine(progress.currentBytes, progress.totalBytes));
											progressbar2.setIndeterminate(false);
									}
							})
							.start(new OnDownloadListener() {
									@Override
									public void onDownloadComplete() {
											
											imageview2.setEnabled(false);
											materialbutton2.setText("Completed");
								
								if (!FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt").concat("/").endsWith("/")){
									downloadedFile = FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt").concat("/") + "/" + "mod.apk";
								} else {
									downloadedFile =  FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt").concat("/")+"mod.apk";
								}
								
								finish.vibrate((long)(100));
								com.google.android.material.snackbar.Snackbar.make(linear1, snacktext, com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction(snackbutton, new View.OnClickListener(){
									@Override
									public void onClick(View _view) {
										materialbutton1.setVisibility(View.GONE);
										textview10.setVisibility(View.GONE);
										intent.putExtra("ver", Version);
										intent.setClass(getApplicationContext(), ConfiguraActivity.class);
										startActivity(intent);
										String apkFile = FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt").concat("/mod.apk");
										    java.io.File file = new java.io.File(apkFile);
										    if(file.exists()) {
												        Intent intent = new Intent(Intent.ACTION_VIEW);
												        intent.setDataAndType(uriFromFile(getApplicationContext(), new java.io.File(apkFile)), "application/vnd.android.package-archive");
												        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
												        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
												        try {
														            getApplicationContext().startActivity(intent);
														        } catch (ActivityNotFoundException e) {
														            e.printStackTrace();
														            Log.e("TAG", "Error in opening the file!");
														        }
												    }else{
												        SketchwareUtil.showMessage(getApplicationContext(), "File not found!".concat("\n".concat("ملف غير موجود")));
												    }
									}
									
									
									Uri uriFromFile(Context context, java.io.File file) {
										    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
												        return androidx.core.content.FileProvider.getUriForFile(context,context.getApplicationContext().getPackageName() + ".provider", file); 
												    } else {
												        return Uri.fromFile(file);
												    }
									}
								}).show();
									}
									@Override
									public void onError(Error error) {
											materialbutton2.setText("Start");
											Toast.makeText(getApplicationContext(), "Some error occurred" + "1", Toast.LENGTH_SHORT).show();
											textview3.setText("");
											progressbar2.setProgress(0);
											downloadId = 0;
											imageview2.setEnabled(false);
											progressbar2.setIndeterminate(false);
											materialbutton2.setEnabled(true);
									}
							});
					}
				});
				
				imageview2.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View view) {
								PRDownloader.cancel(downloadId);
						}
				});
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				//this moblock crate APKBILDERBD
				//https://youtube.com/channel/UCU2ez8M6S1Zod1jFHifH__g
				
				final PRDownloaderConfig config = PRDownloaderConfig.newBuilder()
					.setDatabaseEnabled(true)
					.build();
				PRDownloader.initialize(InstallaActivity.this, config);
				
				materialbutton1.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						URLFile = textview4.getText().toString();
						dirPath = FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt").concat("/");
							if (Status.RUNNING == PRDownloader.getStatus(downloadId)) {
									PRDownloader.pause(downloadId);
									return;
							}
							materialbutton1.setEnabled(false);
							progressbar2.setIndeterminate(true);
							progressbar2.getIndeterminateDrawable().setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
							if (Status.PAUSED == PRDownloader.getStatus(downloadId)) {
									PRDownloader.resume(downloadId);
									return;
							}
							downloadId = PRDownloader.download(URLFile, dirPath, "mod.apk")
								.build()
								.setOnStartOrResumeListener(new OnStartOrResumeListener() {
										@Override
										public void onStartOrResume() {
												progressbar2.setIndeterminate(false);
												materialbutton1.setEnabled(true);
												materialbutton1.setText("Pause");
												imageview2.setEnabled(true);
										}
							})
							.setOnPauseListener(new OnPauseListener() {
									@Override
									public void onPause() {
											materialbutton1.setText("Resume");
									}
							})
							.setOnCancelListener(new OnCancelListener() {
									@Override
									public void onCancel() {
											materialbutton1.setText("Start");
											imageview2.setEnabled(false);
											progressbar2.setProgress(0);
											textview3.setText("");
											downloadId = 0;
											progressbar2.setIndeterminate(false);
									}
							})
							.setOnProgressListener(new OnProgressListener() {
									@Override
									public void onProgress(Progress progress) {
											long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
											progressbar2.setProgress((int) progressPercent);
											textview3.setText(Utilss.getProgressDisplayLine(progress.currentBytes, progress.totalBytes));
											progressbar2.setIndeterminate(false);
									}
							})
							.start(new OnDownloadListener() {
									@Override
									public void onDownloadComplete() {
											
											imageview2.setEnabled(false);
											materialbutton1.setText("Completed");
								
								if (!FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt").concat("/").endsWith("/")){
									downloadedFile = FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt").concat("/") + "/" + "mod.apk";
								} else {
									downloadedFile =  FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt").concat("/")+"mod.apk";
								}
								
								finish.vibrate((long)(100));
								textview10.setVisibility(View.GONE);
								FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/configurazione", "");
								FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/configurazioneVer", Version);
								if (!FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Verificato.txt")) {
									FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Verificato.txt", "");
								}
								intent.putExtra("ver", Version);
								intent.setClass(getApplicationContext(), ConfiguraActivity.class);
								startActivity(intent);
								String apkFile = FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt").concat("/mod.apk");
								    java.io.File file = new java.io.File(apkFile);
								    if(file.exists()) {
										        Intent intent = new Intent(Intent.ACTION_VIEW);
										        intent.setDataAndType(uriFromFile(getApplicationContext(), new java.io.File(apkFile)), "application/vnd.android.package-archive");
										        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
										        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
										        try {
												            getApplicationContext().startActivity(intent);
												        } catch (ActivityNotFoundException e) {
												            e.printStackTrace();
												            Log.e("TAG", "Error in opening the file!");
												        }
										    }else{
										        SketchwareUtil.showMessage(getApplicationContext(), "File not found!".concat("\n".concat("ملف غير موجود")));
										    }
							}
							
							
							Uri uriFromFile(Context context, java.io.File file) {
								    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
										        return androidx.core.content.FileProvider.getUriForFile(context,context.getApplicationContext().getPackageName() + ".provider", file); 
										    } else {
										        return Uri.fromFile(file);
										    }
									}
									@Override
									public void onError(Error error) {
											materialbutton1.setText("Start");
											Toast.makeText(getApplicationContext(), "Some error occurred" + "1", Toast.LENGTH_SHORT).show();
											textview3.setText("");
											progressbar2.setProgress(0);
											downloadId = 0;
											imageview2.setEnabled(false);
											progressbar2.setIndeterminate(false);
											materialbutton1.setEnabled(true);
									}
							});
					}
				});
				
				imageview2.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View view) {
								PRDownloader.cancel(downloadId);
						}
				});
			}
		});
		
		textview4.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				textview4.startAnimation(fade_in);
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", textview4.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "Copiato negli appunti");
				return true;
			}
		});
	}
	
	private void initializeLogic() {
		
		{
			materialbutton1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2196F3")));
			materialbutton1.setRippleColor(ColorStateList.valueOf(Color.parseColor("#BBDEFB")));
			materialbutton1.setLetterSpacing(0);
			DisplayMetrics screen = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(screen);
			float logicalDensity = screen.density;
			int px = (int) Math.ceil(10 * logicalDensity);
			
			materialbutton1.setCornerRadius(px);
			materialbutton1.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()){
						case MotionEvent.ACTION_DOWN:{
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton1);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues(0.9f);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton1);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues(0.9f);
							scaleY.setDuration(100);
							scaleY.start();
							break;
						}
						case MotionEvent.ACTION_UP:{
							
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton1);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues((float)1);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton1);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues((float)1);
							scaleY.setDuration(100);
							scaleY.start();
							
							break;
						}
					}
					return false;
				}
			});
		}
		
		{
			materialbutton2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2196F3")));
			materialbutton2.setRippleColor(ColorStateList.valueOf(Color.parseColor("#BBDEFB")));
			materialbutton2.setLetterSpacing(0);
			DisplayMetrics screen = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(screen);
			float logicalDensity = screen.density;
			int px = (int) Math.ceil(10 * logicalDensity);
			
			materialbutton2.setCornerRadius(px);
			materialbutton2.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()){
						case MotionEvent.ACTION_DOWN:{
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton2);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues(0.9f);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton2);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues(0.9f);
							scaleY.setDuration(100);
							scaleY.start();
							break;
						}
						case MotionEvent.ACTION_UP:{
							
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton2);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues((float)1);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton2);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues((float)1);
							scaleY.setDuration(100);
							scaleY.start();
							
							break;
						}
					}
					return false;
				}
			});
		}
		
		DisplayMetrics linear5Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear5Screen);
		double linear5DP = 10;
		double linear5LogicalDensity = linear5Screen.density;
		int linear5PX = (int) Math.ceil(linear5DP * linear5LogicalDensity);
		linear5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear5PX, (int)0));
		linear5.setElevation(0);
		linear5.setTranslationZ(0);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		_AggiornaLingua();
		FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/skipLoad", "");
		textview4.setText(getIntent().getStringExtra("link"));
		textview7.setText(getIntent().getStringExtra("novità"));
		textview8.setText(tv8.concat(getIntent().getStringExtra("ver")));
		Version = getIntent().getStringExtra("ver");
		if (!FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/modSviluppatore")) {
			linear7.setVisibility(View.GONE);
			materialbutton2.setVisibility(View.GONE);
		}
		if (!FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt") || FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt").equals("")) {
			FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt", "storage/emulated/0/Download");
		}
		if (FileUtil.isExistFile("storage/emulated/0/Android/data/com.spotify.music") && !FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Verificato.txt")) {
			avviso.setTitle(at);
			avviso.setMessage(am);
			avviso.setIcon(R.drawable.ic_report_problem_white);
			avviso.setPositiveButton(aok, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					Uri packageURI = Uri.parse("package:".concat("com.spotify.music")); Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI); startActivity(uninstallIntent);
				}
			});
			avviso.setNegativeButton(ac, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					
				}
			});
			
			{
				final AlertDialog alert = avviso.show();
				DisplayMetrics screen = new DisplayMetrics();
				getWindowManager().getDefaultDisplay().getMetrics(screen);
				double dp = 10;
				double logicalDensity = screen.density;
				int px = (int) Math.ceil(dp * logicalDensity);
				alert.getWindow().getDecorView().setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#212121")));
					alert.getWindow().getDecorView().setPadding(8,8,8,8);
				alert.show();
				
				alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#2196f3"));
					alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#2196f3"));
					alert.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(Color.parseColor("#2196f3"));
				alert.getWindow().setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
				alert.getWindow().getDecorView().setTranslationY(-20);
				TextView textT = (TextView)alert.getWindow().getDecorView().findViewById(android.R.id.message);
				Spannable text = new SpannableString(textT.getText().toString()); 
				text.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFF")), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE); 
				alert.setMessage(text);
				
				int titleId = getResources().getIdentifier( "alertTitle", "id", "android" ); 
				if (titleId > 0) 
				{ 
					TextView dialogTitle = (TextView) alert.getWindow().getDecorView().findViewById(titleId); 
					if (dialogTitle != null) 
					{
						Spannable title = new SpannableString(dialogTitle.getText().toString()); 
						title.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFF")), 0, title.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE); 
						alert.setTitle(title);
					} 
				}}
		}
	}
	
	@Override
	public void onBackPressed() {
		FileUtil.deleteFile("storage/emulated/0/Android/data/jk.spotifinity/mod.apk");
		finish();
	}
	
	@Override
	public void onStop() {
		super.onStop();
		FileUtil.deleteFile("storage/emulated/0/Android/data/jk.spotifinity/mod.apk");
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		FileUtil.deleteFile("storage/emulated/0/Android/data/jk.spotifinity/mod.apk");
	}
	public void _extra() {
	}
	private int downloadId;
	private static String dirPath;
	private String URLFile;
	private String nameFile;
	private String downloadedFile;
	public static final class Utilss {
		    private Utilss() {
			    }
		    public static String getRootDirPath(Context context) {
			        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
				           // java.io.File file = context.getExternalFilesDirs(context.getApplicationContext(), null)[0, ;
				           // return file.getAbsolutePath();
				            return context.getApplicationContext().getFilesDir().getAbsolutePath();
				        } else {
				            return context.getApplicationContext().getFilesDir().getAbsolutePath();
				        }
			    }
		    public static String getProgressDisplayLine(long currentBytes, long totalBytes) {
			        return getBytesToMBString(currentBytes) + "/" + getBytesToMBString(totalBytes);
			    }
		    private static String getBytesToMBString(long bytes){
			        return String.format(Locale.ENGLISH, "%.2fMb", bytes / (1024.00 * 1024.00));
			    }
	}
	
	
	public static class PRDownloader {
		    private PRDownloader() {
			    }
		    public static void initialize(Context context) {
			        initialize(context, PRDownloaderConfig.newBuilder().build());
			    }
		    public static void initialize(Context context, PRDownloaderConfig config) {
			        ComponentHolder.getInstance().init(context, config);
			        DownloadRequestQueue.initialize();
			    }
		    public static DownloadRequestBuilder download(String url, String dirPath, String fileName) {
			        return new DownloadRequestBuilder(url, dirPath, fileName);
			    }
		    public static void pause(int downloadId) {
			        DownloadRequestQueue.getInstance().pause(downloadId);
			    }
		    public static void resume(int downloadId) {
			        DownloadRequestQueue.getInstance().resume(downloadId);
			    }
		    public static void cancel(int downloadId) {
			        DownloadRequestQueue.getInstance().cancel(downloadId);
			    }
		    public static void cancel(Object tag) {
			        DownloadRequestQueue.getInstance().cancel(tag);
			    }
		    public static void cancelAll() {
			        DownloadRequestQueue.getInstance().cancelAll();
			    }
		    public static Status getStatus(int downloadId) {
			        return DownloadRequestQueue.getInstance().getStatus(downloadId);
			    }
		    public static void cleanUp(int days) {
			        Utils.deleteUnwantedModelsAndTempFiles(days);
			    }
		    public static void shutDown() {
			        Core.shutDown();
			    }
	}
	
	public static class Response {
		    private Error error;
		    private boolean isSuccessful;
		    private boolean isPaused;
		    private boolean isCancelled;
		    public Error getError() {
			        return error;
			    }
		    public void setError(Error error) {
			        this.error = error;
			    }
		    public boolean isSuccessful() {
			        return isSuccessful;
			    }
		    public void setSuccessful(boolean successful) {
			        isSuccessful = successful;
			    }
		    public boolean isPaused() {
			        return isPaused;
			    }
		    public void setPaused(boolean paused) {
			        isPaused = paused;
			    }
		    public boolean isCancelled() {
			        return isCancelled;
			    }
		    public void setCancelled(boolean cancelled) {
			        isCancelled = cancelled;
			    }
	}
	
	public static enum Status {
		    QUEUED,
		    RUNNING,
		    PAUSED,
		    COMPLETED,
		    CANCELLED,
		    UNKNOWN
	}
	
	public static class Progress implements java.io.Serializable {
		    public long currentBytes;
		    public long totalBytes;
		    public Progress(long currentBytes, long totalBytes) {
			        this.currentBytes = currentBytes;
			        this.totalBytes = totalBytes;
			    }
		    @Override
		    public String toString() {
			        return "Progress{" +
			                "currentBytes=" + currentBytes +
			                ", totalBytes=" + totalBytes +
			                '}';
			    }
	}
	
	public static enum Priority {
		    LOW,
		    MEDIUM,
		    HIGH,
		    IMMEDIATE
	}
	
	
	public static class PRDownloaderConfig {
		    private int readTimeout;
		    private int connectTimeout;
		    private String userAgent;
		    private HttpClient httpClient;
		    private boolean databaseEnabled;
		    private PRDownloaderConfig(Builder builder) {
			        this.readTimeout = builder.readTimeout;
			        this.connectTimeout = builder.connectTimeout;
			        this.userAgent = builder.userAgent;
			        this.httpClient = builder.httpClient;
			        this.databaseEnabled = builder.databaseEnabled;
			    }
		    public int getReadTimeout() {
			        return readTimeout;
			    }
		    public void setReadTimeout(int readTimeout) {
			        this.readTimeout = readTimeout;
			    }
		    public int getConnectTimeout() {
			        return connectTimeout;
			    }
		    public void setConnectTimeout(int connectTimeout) {
			        this.connectTimeout = connectTimeout;
			    }
		    public String getUserAgent() {
			        return userAgent;
			    }
		    public void setUserAgent(String userAgent) {
			        this.userAgent = userAgent;
			    }
		    public HttpClient getHttpClient() {
			        return httpClient;
			    }
		    public void setHttpClient(HttpClient httpClient) {
			        this.httpClient = httpClient;
			    }
		    public boolean isDatabaseEnabled() {
			        return databaseEnabled;
			    }
		    public void setDatabaseEnabled(boolean databaseEnabled) {
			        this.databaseEnabled = databaseEnabled;
			    }
		    public static Builder newBuilder() {
			        return new Builder();
			    }
		    public static class Builder {
			        int readTimeout = Constants.DEFAULT_READ_TIMEOUT_IN_MILLS;
			        int connectTimeout = Constants.DEFAULT_CONNECT_TIMEOUT_IN_MILLS;
			        String userAgent = Constants.DEFAULT_USER_AGENT;
			        HttpClient httpClient = new DefaultHttpClient();
			        boolean databaseEnabled = false;
			        public Builder setReadTimeout(int readTimeout) {
				            this.readTimeout = readTimeout;
				            return this;
				        }
			        public Builder setConnectTimeout(int connectTimeout) {
				            this.connectTimeout = connectTimeout;
				            return this;
				        }
			        public Builder setUserAgent(String userAgent) {
				            this.userAgent = userAgent;
				            return this;
				        }
			        public Builder setHttpClient(HttpClient httpClient) {
				            this.httpClient = httpClient;
				            return this;
				        }
			        public Builder setDatabaseEnabled(boolean databaseEnabled) {
				            this.databaseEnabled = databaseEnabled;
				            return this;
				        }
			        public PRDownloaderConfig build() {
				            return new PRDownloaderConfig(this);
				        }
			    }
	}
	
	
	public static final class Constants {
		    private Constants() {
			    }
		    public static final int UPDATE = 0x01;
		    public static final String RANGE = "Range";
		    public static final String ETAG = "ETag";
		    public static final String USER_AGENT = "User-Agent";
		    public static final String DEFAULT_USER_AGENT = "Gymkhana-Studio";
		    public static final int DEFAULT_READ_TIMEOUT_IN_MILLS = 20_000;
		    public static final int DEFAULT_CONNECT_TIMEOUT_IN_MILLS = 20_000;
		    public static final int HTTP_RANGE_NOT_SATISFIABLE = 416;
		    public static final int HTTP_TEMPORARY_REDIRECT = 307;
		    public static final int HTTP_PERMANENT_REDIRECT = 308;
	}
	
	public static class Error {
		    private boolean isServerError;
		    private boolean isConnectionError;
		    public boolean isServerError() {
			        return isServerError;
			    }
		    public void setServerError(boolean serverError) {
			        isServerError = serverError;
			    }
		    public boolean isConnectionError() {
			        return isConnectionError;
			    }
		    public void setConnectionError(boolean connectionError) {
			        isConnectionError = connectionError;
			    }
	}
	
	public static interface OnCancelListener {
		    void onCancel();
	}
	
	public static interface OnDownloadListener {
		    void onDownloadComplete();
		    void onError(Error error);
	}
	
	public static interface OnPauseListener {
		    void onPause();
	}
	
	public static interface OnProgressListener {
		    void onProgress(Progress progress);
	}
	
	public static interface OnStartOrResumeListener {
		    void onStartOrResume();
	}
	
	
	
	public static class ProgressHandler extends Handler {
		    private final OnProgressListener listener;
		    public ProgressHandler(OnProgressListener listener) {
			        super(Looper.getMainLooper());
			        this.listener = listener;
			    }
		    @Override
		    public void handleMessage(Message msg) {
			        switch (msg.what) {
				            case Constants.UPDATE:
				                if (listener != null) {
					                    final Progress progress = (Progress) msg.obj;
					                    listener.onProgress(progress);
					                }
				                break;
				            default:
				                super.handleMessage(msg);
				                break;
				        }
			    }
	}
	
	public static class DefaultHttpClient implements HttpClient {
		    private java.net.URLConnection connection;
		    public DefaultHttpClient() {
			    }
		    @SuppressWarnings("CloneDoesntCallSuperClone")
		    @Override
		    public HttpClient clone() {
			        return new DefaultHttpClient();
			    }
		    @Override
		    public void connect(DownloadRequest request) throws java.io.IOException {
			        connection = new java.net.URL(request.getUrl()).openConnection();
			        connection.setReadTimeout(request.getReadTimeout());
			        connection.setConnectTimeout(request.getConnectTimeout());
			        final String range = String.format(Locale.ENGLISH,
			                "bytes=%d-", request.getDownloadedBytes());
			        connection.addRequestProperty(Constants.RANGE, range);
			        connection.addRequestProperty(Constants.USER_AGENT, request.getUserAgent());
			        addHeaders(request);
			        connection.connect();
			    }
		    @Override
		    public int getResponseCode() throws java.io.IOException {
			        int responseCode = 0;
			        if (connection instanceof java.net.HttpURLConnection) {
				            responseCode = ((java.net.HttpURLConnection) connection).getResponseCode();
				        }
			        return responseCode;
			    }
		    @Override
		    public java.io.InputStream getInputStream() throws java.io.IOException {
			        return connection.getInputStream();
			    }
		    @Override
		    public long getContentLength() {
			        String length = connection.getHeaderField("Content-Length");
			        try {
				            return Long.parseLong(length);
				        } catch (NumberFormatException e) {
				            return -1;
				        }
			    }
		    @Override
		    public String getResponseHeader(String name) {
			        return connection.getHeaderField(name);
			    }
		    @Override
		    public void close() {
			    }
		    private void addHeaders(DownloadRequest request) {
			        final HashMap<String, List<String>> headers = request.getHeaders();
			        if (headers != null) {
				            Set<Map.Entry<String, List<String>>> entries = headers.entrySet();
				            for (Map.Entry<String, List<String>> entry : entries) {
					                String name = entry.getKey();
					                List<String> list = entry.getValue();
					                if (list != null) {
						                    for (String value : list) {
							                        connection.addRequestProperty(name, value);
							                    }
						                }
					            }
				        }
			    }
		
	}
	
	public static interface HttpClient extends Cloneable {
		    HttpClient clone();
		    void connect(DownloadRequest request) throws java.io.IOException;
		    int getResponseCode() throws java.io.IOException;
		    java.io.InputStream getInputStream() throws java.io.IOException;
		    long getContentLength();
		    String getResponseHeader(String name);
		    void close();
	}
	
	public static class DownloadRequest {
		    private Priority priority;
		    private Object tag;
		    private String url;
		    private String dirPath;
		    private String fileName;
		    private int sequenceNumber;
		    private java.util.concurrent.Future future;
		    private long downloadedBytes;
		    private long totalBytes;
		    private int readTimeout;
		    private int connectTimeout;
		    private String userAgent;
		    private OnProgressListener onProgressListener;
		    private OnDownloadListener onDownloadListener;
		    private OnStartOrResumeListener onStartOrResumeListener;
		    private OnPauseListener onPauseListener;
		    private OnCancelListener onCancelListener;
		    private int downloadId;
		    private HashMap<String, List<String>> headerMap;
		    private Status status;
		
		    DownloadRequest(DownloadRequestBuilder builder) {
			        this.url = builder.url;
			        this.dirPath = builder.dirPath;
			        this.fileName = builder.fileName;
			        this.headerMap = builder.headerMap;
			        this.priority = builder.priority;
			        this.tag = builder.tag;
			        this.readTimeout =
			                builder.readTimeout != 0 ?
			                        builder.readTimeout :
			                        getReadTimeoutFromConfig();
			        this.connectTimeout =
			                builder.connectTimeout != 0 ?
			                        builder.connectTimeout :
			                        getConnectTimeoutFromConfig();
			        this.userAgent = builder.userAgent;
			    }
		
		    public Priority getPriority() {
			        return priority;
			    }
		
		    public void setPriority(Priority priority) {
			        this.priority = priority;
			    }
		
		    public Object getTag() {
			        return tag;
			    }
		
		    public void setTag(Object tag) {
			        this.tag = tag;
			    }
		
		    public String getUrl() {
			        return url;
			    }
		
		    public void setUrl(String url) {
			        this.url = url;
			    }
		
		    public String getDirPath() {
			        return dirPath;
			    }
		
		    public void setDirPath(String dirPath) {
			        this.dirPath = dirPath;
			    }
		
		    public String getFileName() {
			        return fileName;
			    }
		
		    public void setFileName(String fileName) {
			        this.fileName = fileName;
			    }
		
		    public int getSequenceNumber() {
			        return sequenceNumber;
			    }
		
		    public void setSequenceNumber(int sequenceNumber) {
			        this.sequenceNumber = sequenceNumber;
			    }
		
		    public HashMap<String, List<String>> getHeaders() {
			        return headerMap;
			    }
		
		    public java.util.concurrent.Future getFuture() {
			        return future;
			    }
		
		    public void setFuture(java.util.concurrent.Future future) {
			        this.future = future;
			    }
		
		    public long getDownloadedBytes() {
			        return downloadedBytes;
			    }
		
		    public void setDownloadedBytes(long downloadedBytes) {
			        this.downloadedBytes = downloadedBytes;
			    }
		
		    public long getTotalBytes() {
			        return totalBytes;
			    }
		
		    public void setTotalBytes(long totalBytes) {
			        this.totalBytes = totalBytes;
			    }
		
		    public int getReadTimeout() {
			        return readTimeout;
			    }
		
		    public void setReadTimeout(int readTimeout) {
			        this.readTimeout = readTimeout;
			    }
		
		    public int getConnectTimeout() {
			        return connectTimeout;
			    }
		
		    public void setConnectTimeout(int connectTimeout) {
			        this.connectTimeout = connectTimeout;
			    }
		
		    public String getUserAgent() {
			        if (userAgent == null) {
				            userAgent = ComponentHolder.getInstance().getUserAgent();
				        }
			        return userAgent;
			    }
		
		    public void setUserAgent(String userAgent) {
			        this.userAgent = userAgent;
			    }
		
		    public int getDownloadId() {
			        return downloadId;
			    }
		
		    public void setDownloadId(int downloadId) {
			        this.downloadId = downloadId;
			    }
		
		    public Status getStatus() {
			        return status;
			    }
		
		    public void setStatus(Status status) {
			        this.status = status;
			    }
		
		    public OnProgressListener getOnProgressListener() {
			        return onProgressListener;
			    }
		
		    public DownloadRequest setOnStartOrResumeListener(OnStartOrResumeListener onStartOrResumeListener) {
			        this.onStartOrResumeListener = onStartOrResumeListener;
			        return this;
			    }
		
		    public DownloadRequest setOnProgressListener(OnProgressListener onProgressListener) {
			        this.onProgressListener = onProgressListener;
			        return this;
			    }
		
		    public DownloadRequest setOnPauseListener(OnPauseListener onPauseListener) {
			        this.onPauseListener = onPauseListener;
			        return this;
			    }
		
		    public DownloadRequest setOnCancelListener(OnCancelListener onCancelListener) {
			        this.onCancelListener = onCancelListener;
			        return this;
			    }
		
		    public int start(OnDownloadListener onDownloadListener) {
			        this.onDownloadListener = onDownloadListener;
			        downloadId = Utils.getUniqueId(url, dirPath, fileName);
			        DownloadRequestQueue.getInstance().addRequest(this);
			        return downloadId;
			    }
		
		    public Response executeSync() {
			        downloadId = Utils.getUniqueId(url, dirPath, fileName);
			        return new SynchronousCall(this).execute();
			    }
		
		    public void deliverError(final Error error) {
			        if (status != Status.CANCELLED) {
				            Core.getInstance().getExecutorSupplier().forMainThreadTasks()
				                    .execute(new Runnable() {
					                        public void run() {
						                            if (onDownloadListener != null) {
							                                onDownloadListener.onError(error);
							                            }
						                            finish();
						                        }
					                    });
				        }
			    }
		
		    public void deliverSuccess() {
			        if (status != Status.CANCELLED) {
				            setStatus(Status.COMPLETED);
				            Core.getInstance().getExecutorSupplier().forMainThreadTasks()
				                    .execute(new Runnable() {
					                        public void run() {
						                            if (onDownloadListener != null) {
							                                onDownloadListener.onDownloadComplete();
							                            }
						                            finish();
						                        }
					                    });
				        }
			    }
		
		    public void deliverStartEvent() {
			        if (status != Status.CANCELLED) {
				            Core.getInstance().getExecutorSupplier().forMainThreadTasks()
				                    .execute(new Runnable() {
					                        public void run() {
						                            if (onStartOrResumeListener != null) {
							                                onStartOrResumeListener.onStartOrResume();
							                            }
						                        }
					                    });
				        }
			    }
		
		    public void deliverPauseEvent() {
			        if (status != Status.CANCELLED) {
				            Core.getInstance().getExecutorSupplier().forMainThreadTasks()
				                    .execute(new Runnable() {
					                        public void run() {
						                            if (onPauseListener != null) {
							                                onPauseListener.onPause();
							                            }
						                        }
					                    });
				        }
			    }
		
		    private void deliverCancelEvent() {
			        Core.getInstance().getExecutorSupplier().forMainThreadTasks()
			                .execute(new Runnable() {
				                    public void run() {
					                        if (onCancelListener != null) {
						                            onCancelListener.onCancel();
						                        }
					                    }
				                });
			    }
		
		    public void cancel() {
			        status = Status.CANCELLED;
			        if (future != null) {
				            future.cancel(true);
				        }
			        deliverCancelEvent();
			        Utils.deleteTempFileAndDatabaseEntryInBackground(Utils.getTempPath(dirPath, fileName), downloadId);
			    }
		
		    private void finish() {
			        destroy();
			        DownloadRequestQueue.getInstance().finish(this);
			    }
		
		    private void destroy() {
			        this.onProgressListener = null;
			        this.onDownloadListener = null;
			        this.onStartOrResumeListener = null;
			        this.onPauseListener = null;
			        this.onCancelListener = null;
			    }
		
		    private int getReadTimeoutFromConfig() {
			        return ComponentHolder.getInstance().getReadTimeout();
			    }
		
		    private int getConnectTimeoutFromConfig() {
			        return ComponentHolder.getInstance().getConnectTimeout();
			    }
		
	}
	
	public static class DownloadRequestBuilder implements RequestBuilder {
		    String url;
		    String dirPath;
		    String fileName;
		    Priority priority = Priority.MEDIUM;
		    Object tag;
		    int readTimeout;
		    int connectTimeout;
		    String userAgent;
		    HashMap<String, List<String>> headerMap;
		    public DownloadRequestBuilder(String url, String dirPath, String fileName) {
			        this.url = url;
			        this.dirPath = dirPath;
			        this.fileName = fileName;
			    }
		    @Override
		    public DownloadRequestBuilder setHeader(String name, String value) {
			        if (headerMap == null) {
				            headerMap = new HashMap<>();
				        }
			        List<String> list = headerMap.get(name);
			        if (list == null) {
				            list = new ArrayList<>();
				            headerMap.put(name, list);
				        }
			        if (!list.contains(value)) {
				            list.add(value);
				        }
			        return this;
			    }
		    @Override
		    public DownloadRequestBuilder setPriority(Priority priority) {
			        this.priority = priority;
			        return this;
			    }
		    @Override
		    public DownloadRequestBuilder setTag(Object tag) {
			        this.tag = tag;
			        return this;
			    }
		    @Override
		    public DownloadRequestBuilder setReadTimeout(int readTimeout) {
			        this.readTimeout = readTimeout;
			        return this;
			    }
		    @Override
		    public DownloadRequestBuilder setConnectTimeout(int connectTimeout) {
			        this.connectTimeout = connectTimeout;
			        return this;
			    }
		    @Override
		    public DownloadRequestBuilder setUserAgent(String userAgent) {
			        this.userAgent = userAgent;
			        return this;
			    }
		    public DownloadRequest build() {
			        return new DownloadRequest(this);
			    }
	}
	
	public static interface RequestBuilder {
		    RequestBuilder setHeader(String name, String value);
		    RequestBuilder setPriority(Priority priority);
		    RequestBuilder setTag(Object tag);
		    RequestBuilder setReadTimeout(int readTimeout);
		    RequestBuilder setConnectTimeout(int connectTimeout);
		    RequestBuilder setUserAgent(String userAgent);
	}
	
	public static final class Utils {
		    private final static int MAX_REDIRECTION = 10;
		    private Utils() {
			    }
		    public static String getPath(String dirPath, String fileName) {
			        return dirPath + java.io.File.separator + fileName;
			    }
		    public static String getTempPath(String dirPath, String fileName) {
			        return getPath(dirPath, fileName) + ".temp";
			    }
		    public static void renameFileName(String oldPath, String newPath) throws java.io.IOException {
			        final java.io.File oldFile = new java.io.File(oldPath);
			        try {
				            final java.io.File newFile = new java.io.File(newPath);
				            if (newFile.exists()) {
					                if (!newFile.delete()) {
						                    throw new java.io.IOException("Deletion Failed");
						                }
					            }
				            if (!oldFile.renameTo(newFile)) {
					                throw new java.io.IOException("Rename Failed");
					            }
				        } finally {
				            if (oldFile.exists()) {
					                oldFile.delete();
					            }
				        }
			    }
		
		    public static void deleteTempFileAndDatabaseEntryInBackground(final String path, final int downloadId) {
			        Core.getInstance().getExecutorSupplier().forBackgroundTasks()
			                .execute(new Runnable() {
				                    @Override
				                    public void run() {
					                        ComponentHolder.getInstance().getDbHelper().remove(downloadId);
					                        java.io.File file = new java.io.File(path);
					                        if (file.exists()) {
						                            //noinspection ResultOfMethodCallIgnored
						                            file.delete();
						                        }
					                    }
				                });
			    }
		
		    public static void deleteUnwantedModelsAndTempFiles(final int days) {
			        Core.getInstance().getExecutorSupplier().forBackgroundTasks()
			                .execute(new Runnable() {
				                    @Override
				                    public void run() {
					                        List<DownloadModel> models = ComponentHolder.getInstance()
					                                .getDbHelper()
					                                .getUnwantedModels(days);
					                        if (models != null) {
						                            for (DownloadModel model : models) {
							                                final String tempPath = getTempPath(model.getDirPath(), model.getFileName());
							                                ComponentHolder.getInstance().getDbHelper().remove(model.getId());
							                                java.io.File file = new java.io.File(tempPath);
							                                if (file.exists()) {
								                                    file.delete();
								                                }
							                            }
						                        }
					                    }
				                });
			    }
		
		    public static int getUniqueId(String url, String dirPath, String fileName) {
			        String string = url + java.io.File.separator + dirPath + java.io.File.separator + fileName;
			        byte[]  hash;
			        try {
				            hash = java.security.MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
				        } catch (java.security.NoSuchAlgorithmException e) {
				            throw new RuntimeException("NoSuchAlgorithmException", e);
				        } catch (java.io.UnsupportedEncodingException e) {
				            throw new RuntimeException("UnsupportedEncodingException", e);
				        }
			        StringBuilder hex = new StringBuilder(hash.length * 2);
			
			        for (byte b : hash) {
				            if ((b & 0xFF) < 0x10) hex.append("0");
				            hex.append(Integer.toHexString(b & 0xFF));
				        }
			        return hex.toString().hashCode();
			
			    }
		    public static HttpClient getRedirectedConnectionIfAny(HttpClient httpClient,
		                                                          DownloadRequest request)
		            throws java.io.IOException, IllegalAccessException {
			        int redirectTimes = 0;
			        int code = httpClient.getResponseCode();
			        String location = httpClient.getResponseHeader("Location");
			        while (isRedirection(code)) {
				            if (location == null) {
					                throw new IllegalAccessException("Location is null");
					            }
				            httpClient.close();
				            request.setUrl(location);
				            httpClient = ComponentHolder.getInstance().getHttpClient();
				            httpClient.connect(request);
				            code = httpClient.getResponseCode();
				            location = httpClient.getResponseHeader("Location");
				            redirectTimes++;
				            if (redirectTimes >= MAX_REDIRECTION) {
					                throw new IllegalAccessException("Max redirection done");
					            }
				        }
			        return httpClient;
			    }
		    private static boolean isRedirection(int code) {
			        return code == java.net.HttpURLConnection.HTTP_MOVED_PERM
			                || code == java.net.HttpURLConnection.HTTP_MOVED_TEMP
			                || code == java.net.HttpURLConnection.HTTP_SEE_OTHER
			                || code == java.net.HttpURLConnection.HTTP_MULT_CHOICE
			                || code == Constants.HTTP_TEMPORARY_REDIRECT
			                || code == Constants.HTTP_PERMANENT_REDIRECT;
			    }
	}
	
	
	public static class Core {
		    private static Core instance = null;
		    private final ExecutorSupplier executorSupplier;
		    private Core() {
			        this.executorSupplier = new DefaultExecutorSupplier();
			    }
		    public static Core getInstance() {
			        if (instance == null) {
				            synchronized (Core.class) {
					                if (instance == null) {
						                    instance = new Core();
						                }
					            }
				        }
			        return instance;
			    }
		    public ExecutorSupplier getExecutorSupplier() {
			        return executorSupplier;
			    }
		    public static void shutDown() {
			        if (instance != null) {
				            instance = null;
				        }
			    }
	}
	
	
	public static class PriorityThreadFactory implements java.util.concurrent.ThreadFactory {
		    private final int mThreadPriority;
		    PriorityThreadFactory(int threadPriority) {
			        mThreadPriority = threadPriority;
			    }
		    @Override
		    public Thread newThread(final Runnable runnable) {
			        Runnable wrapperRunnable = new Runnable() {
				            @Override
				            public void run() {
					                try {
						                    android.os.Process.setThreadPriority(mThreadPriority);
						                } catch (Throwable ignored) {
						
						                }
					                runnable.run();
					            }
				        };
			        return new Thread(wrapperRunnable);
			    }
	}
	public static class MainThreadExecutor implements java.util.concurrent.Executor {
		    private final Handler handler = new Handler(Looper.getMainLooper());
		    @Override
		    public void execute(Runnable runnable) {
			        handler.post(runnable);
			    }
	}
	
	public static class DefaultExecutorSupplier implements ExecutorSupplier {
		    private static final int DEFAULT_MAX_NUM_THREADS = 2 * Runtime.getRuntime().availableProcessors() + 1;
		    private final DownloadExecutor networkExecutor;
		    private final java.util.concurrent.Executor backgroundExecutor;
		    private final java.util.concurrent.Executor mainThreadExecutor;
		    DefaultExecutorSupplier() {
			        java.util.concurrent.ThreadFactory backgroundPriorityThreadFactory = new PriorityThreadFactory(android.os.Process.THREAD_PRIORITY_BACKGROUND);
			        networkExecutor = new DownloadExecutor(DEFAULT_MAX_NUM_THREADS, backgroundPriorityThreadFactory);
			        backgroundExecutor = java.util.concurrent.Executors.newSingleThreadExecutor();
			        mainThreadExecutor = new MainThreadExecutor();
			    }
		    @Override
		    public DownloadExecutor forDownloadTasks() {
			        return networkExecutor;
			    }
		    @Override
		    public java.util.concurrent.Executor forBackgroundTasks() {
			        return backgroundExecutor;
			    }
		    @Override
		    public java.util.concurrent.Executor forMainThreadTasks() {
			        return mainThreadExecutor;
			    }
	}
	
	public static interface ExecutorSupplier {
		    DownloadExecutor forDownloadTasks();
		    java.util.concurrent.Executor forBackgroundTasks();
		    java.util.concurrent.Executor forMainThreadTasks();
	}
	
	
	public static class FileDownloadRandomAccessFile implements FileDownloadOutputStream {
		    private final java.io.BufferedOutputStream out;
		    private final java.io.FileDescriptor fd;
		    private final java.io.RandomAccessFile randomAccess;
		    private FileDownloadRandomAccessFile(java.io.File file) throws java.io.IOException {
			        randomAccess = new java.io.RandomAccessFile(file, "rw");
			        fd = randomAccess.getFD();
			        out = new java.io.BufferedOutputStream(new java.io.FileOutputStream(randomAccess.getFD()));
			    }
		    @Override
		    public void write(byte[]  b, int off, int len) throws java.io.IOException {
			        out.write(b, off, len);
			    }
		    @Override
		    public void flushAndSync() throws java.io.IOException {
			        out.flush();
			        fd.sync();
			    }
		    @Override
		    public void close() throws java.io.IOException {
			        out.close();
			        randomAccess.close();
			    }
		    @Override
		    public void seek(long offset) throws java.io.IOException {
			        randomAccess.seek(offset);
			    }
		    @Override
		    public void setLength(long totalBytes) throws java.io.IOException {
			        randomAccess.setLength(totalBytes);
			    }
		    public static FileDownloadOutputStream create(java.io.File file) throws java.io.IOException {
			        return new FileDownloadRandomAccessFile(file);
			    }
	}
	
	public static interface FileDownloadOutputStream {
		    void write(byte b[] , int off, int len) throws java.io.IOException;
		    void flushAndSync() throws java.io.IOException;
		    void close() throws java.io.IOException;
		    void seek(long offset) throws java.io.IOException, IllegalAccessException;
		    void setLength(final long newLength) throws java.io.IOException, IllegalAccessException;
	}
	public static class DownloadRunnable implements Runnable {
		    public final Priority priority;
		    public final int sequence;
		    public final DownloadRequest request;
		    DownloadRunnable(DownloadRequest request) {
			        this.request = request;
			        this.priority = request.getPriority();
			        this.sequence = request.getSequenceNumber();
			    }
		    @Override
		    public void run() {
			        request.setStatus(Status.RUNNING);
			        DownloadTask downloadTask = DownloadTask.create(request);
			        Response response = downloadTask.run();
			        if (response.isSuccessful()) {
				            request.deliverSuccess();
				        } else if (response.isPaused()) {
				            request.deliverPauseEvent();
				        } else if (response.getError() != null) {
				            request.deliverError(response.getError());
				        } else if (!response.isCancelled()) {
				            request.deliverError(new Error());
				        }
			    }
	}
	
	
	public static class SynchronousCall {
		    public final DownloadRequest request;
		    public SynchronousCall(DownloadRequest request) {
			        this.request = request;
			    }
		    public Response execute() {
			        DownloadTask downloadTask = DownloadTask.create(request);
			        return downloadTask.run();
			    }
	}
	
	public static class ComponentHolder {
		    private final static ComponentHolder INSTANCE = new ComponentHolder();
		    private int readTimeout;
		    private int connectTimeout;
		    private String userAgent;
		    private HttpClient httpClient;
		    private DbHelper dbHelper;
		    public static ComponentHolder getInstance() {
			        return INSTANCE;
			    }
		    public void init(Context context, PRDownloaderConfig config) {
			        this.readTimeout = config.getReadTimeout();
			        this.connectTimeout = config.getConnectTimeout();
			        this.userAgent = config.getUserAgent();
			        this.httpClient = config.getHttpClient();
			        this.dbHelper = config.isDatabaseEnabled() ? new AppDbHelper(context) : new NoOpsDbHelper();
			        if (config.isDatabaseEnabled()) {
				            PRDownloader.cleanUp(30);
				        }
			    }
		    public int getReadTimeout() {
			        if (readTimeout == 0) {
				            synchronized (ComponentHolder.class) {
					                if (readTimeout == 0) {
						                    readTimeout = Constants.DEFAULT_READ_TIMEOUT_IN_MILLS;
						                }
					            }
				        }
			        return readTimeout;
			    }
		    public int getConnectTimeout() {
			        if (connectTimeout == 0) {
				            synchronized (ComponentHolder.class) {
					                if (connectTimeout == 0) {
						                    connectTimeout = Constants.DEFAULT_CONNECT_TIMEOUT_IN_MILLS;
						                }
					            }
				        }
			        return connectTimeout;
			    }
		    public String getUserAgent() {
			        if (userAgent == null) {
				            synchronized (ComponentHolder.class) {
					                if (userAgent == null) {
						                    userAgent = Constants.DEFAULT_USER_AGENT;
						                }
					            }
				        }
			        return userAgent;
			    }
		    public DbHelper getDbHelper() {
			        if (dbHelper == null) {
				            synchronized (ComponentHolder.class) {
					                if (dbHelper == null) {
						                    dbHelper = new NoOpsDbHelper();
						                }
					            }
				        }
			        return dbHelper;
			    }
		    public HttpClient getHttpClient() {
			        if (httpClient == null) {
				            synchronized (ComponentHolder.class) {
					                if (httpClient == null) {
						                    httpClient = new DefaultHttpClient();
						                }
					            }
				        }
			        return httpClient.clone();
			    }
	}
	
	
	public static class DownloadTask {
		    private static final int BUFFER_SIZE = 1024 * 4;
		    private static final long TIME_GAP_FOR_SYNC = 2000;
		    private static final long MIN_BYTES_FOR_SYNC = 65536;
		    private final DownloadRequest request;
		    private ProgressHandler progressHandler;
		    private long lastSyncTime;
		    private long lastSyncBytes;
		    private java.io.InputStream inputStream;
		    private FileDownloadOutputStream outputStream;
		    private HttpClient httpClient;
		    private long totalBytes;
		    private int responseCode;
		    private String eTag;
		    private boolean isResumeSupported;
		    private String tempPath;
		    private DownloadTask(DownloadRequest request) {
			        this.request = request;
			    }
		    static DownloadTask create(DownloadRequest request) {
			        return new DownloadTask(request);
			    }
		    Response run() {
			        Response response = new Response();
			        if (request.getStatus() == Status.CANCELLED) {
				            response.setCancelled(true);
				            return response;
				        } else if (request.getStatus() == Status.PAUSED) {
				            response.setPaused(true);
				            return response;
				        }
			        try {
				            if (request.getOnProgressListener() != null) {
					                progressHandler = new ProgressHandler(request.getOnProgressListener());
					            }
				            tempPath = Utils.getTempPath(request.getDirPath(), request.getFileName());
				            java.io.File file = new java.io.File(tempPath);
				            DownloadModel model = getDownloadModelIfAlreadyPresentInDatabase();
				            if (model != null) {
					                if (file.exists()) {
						                    request.setTotalBytes(model.getTotalBytes());
						                    request.setDownloadedBytes(model.getDownloadedBytes());
						                } else {
						                    removeNoMoreNeededModelFromDatabase();
						                    request.setDownloadedBytes(0);
						                    request.setTotalBytes(0);
						                    model = null;
						                }
					            }
				            httpClient = ComponentHolder.getInstance().getHttpClient();
				            httpClient.connect(request);
				            if (request.getStatus() == Status.CANCELLED) {
					                response.setCancelled(true);
					                return response;
					            } else if (request.getStatus() == Status.PAUSED) {
					                response.setPaused(true);
					                return response;
					            }
				            httpClient = Utils.getRedirectedConnectionIfAny(httpClient, request);
				            responseCode = httpClient.getResponseCode();
				            eTag = httpClient.getResponseHeader(Constants.ETAG);
				            if (checkIfFreshStartRequiredAndStart(model)) {
					                model = null;
					            }
				            if (!isSuccessful()) {
					                Error error = new Error();
					                error.setServerError(true);
					                response.setError(error);
					                return response;
					            }
				            setResumeSupportedOrNot();
				            totalBytes = request.getTotalBytes();
				            if (!isResumeSupported) {
					                deleteTempFile();
					            }
				            if (totalBytes == 0) {
					                totalBytes = httpClient.getContentLength();
					                request.setTotalBytes(totalBytes);
					            }
				            if (isResumeSupported && model == null) {
					                createAndInsertNewModel();
					            }
				            if (request.getStatus() == Status.CANCELLED) {
					                response.setCancelled(true);
					                return response;
					            } else if (request.getStatus() == Status.PAUSED) {
					                response.setPaused(true);
					                return response;
					            }
				            request.deliverStartEvent();
				            inputStream = httpClient.getInputStream();
				            byte[]  buff = new byte[BUFFER_SIZE] ;
				            if (!file.exists()) {
					                if (file.getParentFile() != null && !file.getParentFile().exists()) {
						                    if (file.getParentFile().mkdirs()) {
							                        file.createNewFile();
							                    }
						                } else {
						                    file.createNewFile();
						                }
					            }
				            this.outputStream = FileDownloadRandomAccessFile.create(file);
				            if (isResumeSupported && request.getDownloadedBytes() != 0) {
					                outputStream.seek(request.getDownloadedBytes());
					            }
				            if (request.getStatus() == Status.CANCELLED) {
					                response.setCancelled(true);
					                return response;
					            } else if (request.getStatus() == Status.PAUSED) {
					                response.setPaused(true);
					                return response;
					            }
				            do {
					                final int byteCount = inputStream.read(buff, 0, BUFFER_SIZE);
					                if (byteCount == -1) {
						                    break;
						                }
					                outputStream.write(buff, 0, byteCount);
					                request.setDownloadedBytes(request.getDownloadedBytes() + byteCount);
					                sendProgress();
					                syncIfRequired(outputStream);
					                if (request.getStatus() == Status.CANCELLED) {
						                    response.setCancelled(true);
						                    return response;
						                } else if (request.getStatus() == Status.PAUSED) {
						                    sync(outputStream);
						                    response.setPaused(true);
						                    return response;
						                }
					            } while (true);
				            final String path = Utils.getPath(request.getDirPath(), request.getFileName());
				            Utils.renameFileName(tempPath, path);
				            response.setSuccessful(true);
				            if (isResumeSupported) {
					                removeNoMoreNeededModelFromDatabase();
					            }
				        } catch (java.io.IOException | IllegalAccessException e) {
				            if (!isResumeSupported) {
					                deleteTempFile();
					            }
				            Error error = new Error();
				            error.setConnectionError(true);
				            response.setError(error);
				        } finally {
				            closeAllSafely(outputStream);
				        }
			        return response;
			    }
		    private void deleteTempFile() {
			        java.io.File file = new java.io.File(tempPath);
			        if (file.exists()) {
				            file.delete();
				        }
			    }
		    private boolean isSuccessful() {
			        return responseCode >= java.net.HttpURLConnection.HTTP_OK
			                && responseCode < java.net.HttpURLConnection.HTTP_MULT_CHOICE;
			    }
		    private void setResumeSupportedOrNot() {
			        isResumeSupported = (responseCode == java.net.HttpURLConnection.HTTP_PARTIAL);
			    }
		    private boolean checkIfFreshStartRequiredAndStart(DownloadModel model) throws java.io.IOException,
		            IllegalAccessException {
			        if (responseCode == Constants.HTTP_RANGE_NOT_SATISFIABLE || isETagChanged(model)) {
				            if (model != null) {
					                removeNoMoreNeededModelFromDatabase();
					            }
				            deleteTempFile();
				            request.setDownloadedBytes(0);
				            request.setTotalBytes(0);
				            httpClient = ComponentHolder.getInstance().getHttpClient();
				            httpClient.connect(request);
				            httpClient = Utils.getRedirectedConnectionIfAny(httpClient, request);
				            responseCode = httpClient.getResponseCode();
				            return true;
				        }
			        return false;
			    }
		    private boolean isETagChanged(DownloadModel model) {
			        return !(eTag == null || model == null || model.getETag() == null)
			                && !model.getETag().equals(eTag);
			    }
		    private DownloadModel getDownloadModelIfAlreadyPresentInDatabase() {
			        return ComponentHolder.getInstance().getDbHelper().find(request.getDownloadId());
			    }
		    private void createAndInsertNewModel() {
			        DownloadModel model = new DownloadModel();
			        model.setId(request.getDownloadId());
			        model.setUrl(request.getUrl());
			        model.setETag(eTag);
			        model.setDirPath(request.getDirPath());
			        model.setFileName(request.getFileName());
			        model.setDownloadedBytes(request.getDownloadedBytes());
			        model.setTotalBytes(totalBytes);
			        model.setLastModifiedAt(System.currentTimeMillis());
			        ComponentHolder.getInstance().getDbHelper().insert(model);
			    }
		    private void removeNoMoreNeededModelFromDatabase() {
			        ComponentHolder.getInstance().getDbHelper().remove(request.getDownloadId());
			    }
		    private void sendProgress() {
			        if (request.getStatus() != Status.CANCELLED) {
				            if (progressHandler != null) {
					                progressHandler
					                        .obtainMessage(Constants.UPDATE,
					                                new Progress(request.getDownloadedBytes(),
					                                        totalBytes)).sendToTarget();
					            }
				        }
			    }
		    private void syncIfRequired(FileDownloadOutputStream outputStream) {
			        final long currentBytes = request.getDownloadedBytes();
			        final long currentTime = System.currentTimeMillis();
			        final long bytesDelta = currentBytes - lastSyncBytes;
			        final long timeDelta = currentTime - lastSyncTime;
			        if (bytesDelta > MIN_BYTES_FOR_SYNC && timeDelta > TIME_GAP_FOR_SYNC) {
				            sync(outputStream);
				            lastSyncBytes = currentBytes;
				            lastSyncTime = currentTime;
				        }
			    }
		    private void sync(FileDownloadOutputStream outputStream) {
			        boolean success;
			        try {
				            outputStream.flushAndSync();
				            success = true;
				        } catch (java.io.IOException e) {
				            success = false;
				            e.printStackTrace();
				        }
			        if (success && isResumeSupported) {
				            ComponentHolder.getInstance().getDbHelper()
				                    .updateProgress(request.getDownloadId(),
				                            request.getDownloadedBytes(),
				                            System.currentTimeMillis());
				        }
			    }
		    private void closeAllSafely(FileDownloadOutputStream outputStream) {
			        if (httpClient != null) {
				            try {
					                httpClient.close();
					            } catch (Exception e) {
					                e.printStackTrace();
					            }
				        }
			        if (inputStream != null) {
				            try {
					                inputStream.close();
					            } catch (java.io.IOException e) {
					                e.printStackTrace();
					            }
				        }
			        try {
				            if (outputStream != null) {
					                try {
						                    sync(outputStream);
						                } catch (Exception e) {
						                    e.printStackTrace();
						                }
					            }
				
				        } finally {
				            if (outputStream != null)
				                try {
					                    outputStream.close();
					                } catch (java.io.IOException e) {
					                    e.printStackTrace();
					                }
				        }
			    }
	}
	
	
	public static class DownloadRequestQueue {
		    private static DownloadRequestQueue instance;
		    private final Map<Integer, DownloadRequest> currentRequestMap;
		    private final java.util.concurrent.atomic.AtomicInteger sequenceGenerator;
		    private DownloadRequestQueue() {
			        currentRequestMap = new java.util.concurrent.ConcurrentHashMap<>();
			        sequenceGenerator = new java.util.concurrent.atomic.AtomicInteger();
			    }
		    public static void initialize() {
			        getInstance();
			    }
		    public static DownloadRequestQueue getInstance() {
			        if (instance == null) {
				            synchronized (DownloadRequestQueue.class) {
					                if (instance == null) {
						                    instance = new DownloadRequestQueue();
						                }
					            }
				        }
			        return instance;
			    }
		    private int getSequenceNumber() {
			        return sequenceGenerator.incrementAndGet();
			    }
		    public void pause(int downloadId) {
			        DownloadRequest request = currentRequestMap.get(downloadId);
			        if (request != null) {
				            request.setStatus(Status.PAUSED);
				        }
			    }
		    public void resume(int downloadId) {
			        DownloadRequest request = currentRequestMap.get(downloadId);
			        if (request != null) {
				            request.setStatus(Status.QUEUED);
				            request.setFuture(Core.getInstance()
				                    .getExecutorSupplier()
				                    .forDownloadTasks()
				                    .submit(new DownloadRunnable(request)));
				        }
			    }
		    private void cancelAndRemoveFromMap(DownloadRequest request) {
			        if (request != null) {
				            request.cancel();
				            currentRequestMap.remove(request.getDownloadId());
				        }
			    }
		    public void cancel(int downloadId) {
			        DownloadRequest request = currentRequestMap.get(downloadId);
			        cancelAndRemoveFromMap(request);
			    }
		    public void cancel(Object tag) {
			        for (Map.Entry<Integer, DownloadRequest> currentRequestMapEntry : currentRequestMap.entrySet()) {
				            DownloadRequest request = currentRequestMapEntry.getValue();
				            if (request.getTag() instanceof String && tag instanceof String) {
					                final String tempRequestTag = (String) request.getTag();
					                final String tempTag = (String) tag;
					                if (tempRequestTag.equals(tempTag)) {
						                    cancelAndRemoveFromMap(request);
						                }
					            } else if (request.getTag().equals(tag)) {
					                cancelAndRemoveFromMap(request);
					            }
				        }
			    }
		    public void cancelAll() {
			        for (Map.Entry<Integer, DownloadRequest> currentRequestMapEntry : currentRequestMap.entrySet()) {
				            DownloadRequest request = currentRequestMapEntry.getValue();
				            cancelAndRemoveFromMap(request);
				        }
			    }
		    public Status getStatus(int downloadId) {
			        DownloadRequest request = currentRequestMap.get(downloadId);
			        if (request != null) {
				            return request.getStatus();
				        }
			        return Status.UNKNOWN;
			    }
		    public void addRequest(DownloadRequest request) {
			        currentRequestMap.put(request.getDownloadId(), request);
			        request.setStatus(Status.QUEUED);
			        request.setSequenceNumber(getSequenceNumber());
			        request.setFuture(Core.getInstance()
			                .getExecutorSupplier()
			                .forDownloadTasks()
			                .submit(new DownloadRunnable(request)));
			    }
		    public void finish(DownloadRequest request) {
			        currentRequestMap.remove(request.getDownloadId());
			    }
	}
	
	
	public static class DownloadModel {
		    static final String ID = "id";
		    static final String URL = "url";
		    static final String ETAG = "etag";
		    static final String DIR_PATH = "dir_path";
		    static final String FILE_NAME = "file_name";
		    static final String TOTAL_BYTES = "total_bytes";
		    static final String DOWNLOADED_BYTES = "downloaded_bytes";
		    static final String LAST_MODIFIED_AT = "last_modified_at";
		    private int id;
		    private String url;
		    private String eTag;
		    private String dirPath;
		    private String fileName;
		    private long totalBytes;
		    private long downloadedBytes;
		    private long lastModifiedAt;
		    public int getId() {
			        return id;
			    }
		    public void setId(int id) {
			        this.id = id;
			    }
		    public String getUrl() {
			        return url;
			    }
		    public void setUrl(String url) {
			        this.url = url;
			    }
		    public String getETag() {
			        return eTag;
			    }
		    public void setETag(String eTag) {
			        this.eTag = eTag;
			    }
		    public String getDirPath() {
			        return dirPath;
			    }
		    public void setDirPath(String dirPath) {
			        this.dirPath = dirPath;
			    }
		    public String getFileName() {
			        return fileName;
			    }
		    public void setFileName(String fileName) {
			        this.fileName = fileName;
			    }
		    public long getTotalBytes() {
			        return totalBytes;
			    }
		    public void setTotalBytes(long totalBytes) {
			        this.totalBytes = totalBytes;
			    }
		    public long getDownloadedBytes() {
			        return downloadedBytes;
			    }
		    public void setDownloadedBytes(long downloadedBytes) {
			        this.downloadedBytes = downloadedBytes;
			    }
		    public long getLastModifiedAt() {
			        return lastModifiedAt;
			    }
		    public void setLastModifiedAt(long lastModifiedAt) {
			        this.lastModifiedAt = lastModifiedAt;
			    }
	}
	
	
	
	public static class AppDbHelper implements DbHelper {
		
		    public static final String TABLE_NAME = "prdownloader";
		    private final android.database.sqlite.SQLiteDatabase db;
		    public AppDbHelper(Context context) {
			        DatabaseOpenHelper databaseOpenHelper = new DatabaseOpenHelper(context);
			        db = databaseOpenHelper.getWritableDatabase();
			    }
		    @Override
		    public DownloadModel find(int id) {
			        android.database.Cursor cursor = null;
			        DownloadModel model = null;
			        try {
				            cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " +
				                    DownloadModel.ID + " = " + id, null);
				            if (cursor != null && cursor.moveToFirst()) {
					                model = new DownloadModel();
					                model.setId(id);
					                model.setUrl(cursor.getString(cursor.getColumnIndex(DownloadModel.URL)));
					                model.setETag(cursor.getString(cursor.getColumnIndex(DownloadModel.ETAG)));
					                model.setDirPath(cursor.getString(cursor.getColumnIndex(DownloadModel.DIR_PATH)));
					                model.setFileName(cursor.getString(cursor.getColumnIndex(DownloadModel.FILE_NAME)));
					                model.setTotalBytes(cursor.getLong(cursor.getColumnIndex(DownloadModel.TOTAL_BYTES)));
					                model.setDownloadedBytes(cursor.getLong(cursor.getColumnIndex(DownloadModel.DOWNLOADED_BYTES)));
					                model.setLastModifiedAt(cursor.getLong(cursor.getColumnIndex(DownloadModel.LAST_MODIFIED_AT)));
					            }
				        } catch (Exception e) {
				            e.printStackTrace();
				        } finally {
				            if (cursor != null) {
					                cursor.close();
					            }
				        }
			        return model;
			    }
		    @Override
		    public void insert(DownloadModel model) {
			        try {
				            ContentValues values = new ContentValues();
				            values.put(DownloadModel.ID, model.getId());
				            values.put(DownloadModel.URL, model.getUrl());
				            values.put(DownloadModel.ETAG, model.getETag());
				            values.put(DownloadModel.DIR_PATH, model.getDirPath());
				            values.put(DownloadModel.FILE_NAME, model.getFileName());
				            values.put(DownloadModel.TOTAL_BYTES, model.getTotalBytes());
				            values.put(DownloadModel.DOWNLOADED_BYTES, model.getDownloadedBytes());
				            values.put(DownloadModel.LAST_MODIFIED_AT, model.getLastModifiedAt());
				            db.insert(TABLE_NAME, null, values);
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
			    }
		    @Override
		    public void update(DownloadModel model) {
			        try {
				            ContentValues values = new ContentValues();
				            values.put(DownloadModel.URL, model.getUrl());
				            values.put(DownloadModel.ETAG, model.getETag());
				            values.put(DownloadModel.DIR_PATH, model.getDirPath());
				            values.put(DownloadModel.FILE_NAME, model.getFileName());
				            values.put(DownloadModel.TOTAL_BYTES, model.getTotalBytes());
				            values.put(DownloadModel.DOWNLOADED_BYTES, model.getDownloadedBytes());
				            values.put(DownloadModel.LAST_MODIFIED_AT, model.getLastModifiedAt());
				            db.update(TABLE_NAME, values, DownloadModel.ID + " = ? ",
				                    new String[] {String.valueOf(model.getId())});
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
			    }
		    @Override
		    public void updateProgress(int id, long downloadedBytes, long lastModifiedAt) {
			        try {
				            ContentValues values = new ContentValues();
				            values.put(DownloadModel.DOWNLOADED_BYTES, downloadedBytes);
				            values.put(DownloadModel.LAST_MODIFIED_AT, lastModifiedAt);
				            db.update(TABLE_NAME, values, DownloadModel.ID + " = ? ",
				                    new String[] {String.valueOf(id)});
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
			    }
		    @Override
		    public void remove(int id) {
			        try {
				            db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " +
				                    DownloadModel.ID + " = " + id);
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
			    }
		    @Override
		    public List<DownloadModel> getUnwantedModels(int days) {
			        List<DownloadModel> models = new ArrayList<>();
			        android.database.Cursor cursor = null;
			        try {
				            final long daysInMillis = days * 24 * 60 * 60 * 1000L;
				            final long beforeTimeInMillis = System.currentTimeMillis() - daysInMillis;
				            cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " +
				                    DownloadModel.LAST_MODIFIED_AT + " <= " + beforeTimeInMillis, null);
				            if (cursor != null && cursor.moveToFirst()) {
					                do {
						                    DownloadModel model = new DownloadModel();
						                    model.setId(cursor.getInt(cursor.getColumnIndex(DownloadModel.ID)));
						                    model.setUrl(cursor.getString(cursor.getColumnIndex(DownloadModel.URL)));
						                    model.setETag(cursor.getString(cursor.getColumnIndex(DownloadModel.ETAG)));
						                    model.setDirPath(cursor.getString(cursor.getColumnIndex(DownloadModel.DIR_PATH)));
						                    model.setFileName(cursor.getString(cursor.getColumnIndex(DownloadModel.FILE_NAME)));
						                    model.setTotalBytes(cursor.getLong(cursor.getColumnIndex(DownloadModel.TOTAL_BYTES)));
						                    model.setDownloadedBytes(cursor.getLong(cursor.getColumnIndex(DownloadModel.DOWNLOADED_BYTES)));
						                    model.setLastModifiedAt(cursor.getLong(cursor.getColumnIndex(DownloadModel.LAST_MODIFIED_AT)));
						                    models.add(model);
						                } while (cursor.moveToNext());
					            }
				        } catch (Exception e) {
				            e.printStackTrace();
				        } finally {
				            if (cursor != null) {
					                cursor.close();
					            }
				        }
			        return models;
			    }
		    @Override
		    public void clear() {
			        try {
				            db.delete(TABLE_NAME, null, null);
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
			    }
	}
	
	public static class DatabaseOpenHelper extends android.database.sqlite.SQLiteOpenHelper {
		    private static final String DATABASE_NAME = "prdownloader.db";
		    private static final int DATABASE_VERSION = 1;
		    DatabaseOpenHelper(Context context) {
			        super(context, DATABASE_NAME, null, DATABASE_VERSION);
			    }
		    @Override
		    public void onCreate(android.database.sqlite.SQLiteDatabase db) {
			        db.execSQL("CREATE TABLE IF NOT EXISTS " +
			                AppDbHelper.TABLE_NAME + "( " +
			                DownloadModel.ID + " INTEGER PRIMARY KEY, " +
			                DownloadModel.URL + " VARCHAR, " +
			                DownloadModel.ETAG + " VARCHAR, " +
			                DownloadModel.DIR_PATH + " VARCHAR, " +
			                DownloadModel.FILE_NAME + " VARCHAR, " +
			                DownloadModel.TOTAL_BYTES + " INTEGER, " +
			                DownloadModel.DOWNLOADED_BYTES + " INTEGER, " +
			                DownloadModel.LAST_MODIFIED_AT + " INTEGER " +
			                ")");
			    }
		    @Override
		    public void onUpgrade(android.database.sqlite.SQLiteDatabase db, int i, int i1) {
			    }
	}
	
	public static interface DbHelper {
		    DownloadModel find(int id);
		    void insert(DownloadModel model);
		    void update(DownloadModel model);
		    void updateProgress(int id, long downloadedBytes, long lastModifiedAt);
		    void remove(int id);
		    List<DownloadModel> getUnwantedModels(int days);
		    void clear();
	}
	
	
	public static class NoOpsDbHelper implements DbHelper {
		    public NoOpsDbHelper() {
			    }
		    @Override
		    public DownloadModel find(int id) {
			        return null;
			    }
		    @Override
		    public void insert(DownloadModel model) {
			    }
		    @Override
		    public void update(DownloadModel model) {
			    }
		    @Override
		    public void updateProgress(int id, long downloadedBytes, long lastModifiedAt) {
			    }
		    @Override
		    public void remove(int id) {
			    }
		    @Override
		    public List<DownloadModel> getUnwantedModels(int days) {
			        return null;
			    }
		    @Override
		    public void clear() {
			    }
	}
	
	public static class DownloadFutureTask extends java.util.concurrent.FutureTask<DownloadRunnable> implements Comparable<DownloadFutureTask> {
		    private final DownloadRunnable runnable;
		    DownloadFutureTask(DownloadRunnable downloadRunnable) {
			        super(downloadRunnable, null);
			        this.runnable = downloadRunnable;
			    }
		    @Override
		    public int compareTo(DownloadFutureTask other) {
			        Priority p1 = runnable.priority;
			        Priority p2 = other.runnable.priority;
			        return (p1 == p2 ? runnable.sequence - other.runnable.sequence : p2.ordinal() - p1.ordinal());
			    }
	}
	
	public static class DownloadExecutor extends java.util.concurrent.ThreadPoolExecutor {
		    DownloadExecutor(int maxNumThreads, java.util.concurrent.ThreadFactory threadFactory) {
			        super(maxNumThreads, maxNumThreads, 0, java.util.concurrent.TimeUnit.MILLISECONDS,
			                new java.util.concurrent.PriorityBlockingQueue<Runnable>(), threadFactory);
			    }
		    @Override
		    public java.util.concurrent.Future<?> submit(Runnable task) {
			        DownloadFutureTask futureTask = new DownloadFutureTask((DownloadRunnable) task);
			        execute(futureTask);
			        return futureTask;
			    }
	}
	
	{
		
	}
	
	
	public void _AggiornaLingua() {
		if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("it")) {
			textview1.setText("Installa");
			textview3.setText("Pronto per l'installazione");
			materialbutton1.setText("Inizia l'installazione");
			materialbutton2.setText("solo apk");
			textview10.setText("Clicca 2 volte per installare");
			textview2.setText("Link installazione:");
			textview6.setText("Registro cambiamenti");
			tv8 = "Versione ";
			snacktext = "APK installato con successo!";
			snackbutton = "Installa app";
			at = "Spotify già installato";
			am = "Ho rilevato che hai già installato Spotify sul tuo dispositivo. Per garantire la qualità della mod ti consiglio di disinstallare il Spotify attualmente installato e installare questa mod.";
			aok = "disinstalla";
			ac = "ignora";
		}
		else {
			if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("en")) {
				textview1.setText("Install");
				textview3.setText("Ready to install");
				materialbutton1.setText("Start installation");
				materialbutton2.setText("apk only");
				textview10.setText("Click 2 times to install");
				textview2.setText("Installation link:");
				textview6.setText("Change log");
				tv8 = "Version ";
				snacktext = "APK installed successfully!";
				snackbutton = "Install app";
				at = "Spotify already installed";
				am = "I have detected that you have already installed Spotify on your device. To ensure the quality of the mod I recommend you to uninstall the currently installed Spotify and install this mod.";
				aok = "uninstall";
				ac = "ignore";
			}
			else {
				if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("sq")) {
					textview1.setText("Instaloni");
					textview3.setText("Gati për instalim");
					materialbutton1.setText("Fillon instalimi");
					materialbutton2.setText("vetëm apk");
					textview10.setText("Klikoni 2 herë për ta instaluar");
					textview2.setText("Lidhjet e instalimit:");
					textview6.setText("Ndrysho regjistrin");
					tv8 = "Version ";
					snacktext = "APK u instalua me sukses!";
					snackbutton = "Instaloni aplikacione";
					at = "Spotify është instaluar tashmë";
					am = "Kam zbuluar që ju keni instaluar tashmë Spotify në pajisjen tuaj. Për të siguruar cilësinë e mod-it, ju rekomandoj të çinstaloni Spotify-in e instaluar aktualisht dhe të instaloni këtë mod.";
					aok = "çinstaloni";
					ac = "injorojnë";
				}
				else {
					if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("ru")) {
						textview1.setText("Установить");
						textview3.setText("Готов к установке");
						materialbutton1.setText("Установка начинается");
						materialbutton2.setText("только апк");
						textview10.setText("Нажмите 2 раза, чтобы установить");
						textview2.setText("Ссылки на установку:");
						textview6.setText("Журнал изменений");
						tv8 = "Версия ";
						snacktext = "АПК успешно установлен!";
						snackbutton = "Установить приложения";
						at = "Спотифай уже установлен";
						am = "Я обнаружил, что вы уже установили Spotify на свое устройство. Чтобы обеспечить качество мода, я рекомендую вам удалить установленный в данный момент Spotify и установить этот мод.";
						aok = "удалить";
						ac = "игнорировать";
					}
					else {
						
					}
				}
			}
		}
	}
	
}