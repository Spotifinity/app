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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
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
	private double OraNoPunti = 0;
	private String tv4 = "";
	private String dt1 = "";
	private String dm = "";
	private String dok = "";
	private String dc = "";
	private String ds = "";
	private String azione = "";
	private String d2t = "";
	private String d2m = "";
	private String d2ok = "";
	private String d2c = "";
	private String tv15 = "";
	
	private LinearLayout linear3;
	private ScrollView vscroll1;
	private ImageView imageview1;
	private TextView textview17;
	private LinearLayout linear21;
	private LinearLayout linear18;
	private TextView textview7;
	private TextView textview23;
	private ImageView imageview4;
	private LinearLayout linear4;
	private LinearLayout linear34;
	private LinearLayout linear36;
	private LinearLayout linear33;
	private LinearLayout linear20;
	private LinearLayout linear19;
	private LinearLayout linear7;
	private LinearLayout linear12;
	private DigitalClock digitalclock1;
	private LinearLayout linear35;
	private TextView textview41;
	private MaterialButton materialbutton5;
	private ImageView imageview5;
	private TextView textview40;
	private LinearLayout linear39;
	private TextView textview43;
	private MaterialButton materialbutton6;
	private TextView textview42;
	private LinearLayout linear40;
	private ImageView imageview7;
	private TextView textview428;
	private TextView textview39;
	private TextView textview21;
	private TextView textview22;
	private MaterialButton materialbutton4;
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
	
	private Intent intent = new Intent();
	private AlertDialog.Builder dialog;
	private TimerTask wait;
	private Intent launchIntent = new Intent();
	private AlertDialog.Builder dialog2;
	private Intent sondaggio = new Intent();
	private Intent beta = new Intent();
	private Intent aggiorna = new Intent();
	private Intent easteregg = new Intent();
	private Calendar educazione = Calendar.getInstance();
	private AlertDialog.Builder chiudi;
	
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
		vscroll1 = findViewById(R.id.vscroll1);
		imageview1 = findViewById(R.id.imageview1);
		textview17 = findViewById(R.id.textview17);
		linear21 = findViewById(R.id.linear21);
		linear18 = findViewById(R.id.linear18);
		textview7 = findViewById(R.id.textview7);
		textview23 = findViewById(R.id.textview23);
		imageview4 = findViewById(R.id.imageview4);
		linear4 = findViewById(R.id.linear4);
		linear34 = findViewById(R.id.linear34);
		linear36 = findViewById(R.id.linear36);
		linear33 = findViewById(R.id.linear33);
		linear20 = findViewById(R.id.linear20);
		linear19 = findViewById(R.id.linear19);
		linear7 = findViewById(R.id.linear7);
		linear12 = findViewById(R.id.linear12);
		digitalclock1 = findViewById(R.id.digitalclock1);
		linear35 = findViewById(R.id.linear35);
		textview41 = findViewById(R.id.textview41);
		materialbutton5 = findViewById(R.id.materialbutton5);
		imageview5 = findViewById(R.id.imageview5);
		textview40 = findViewById(R.id.textview40);
		linear39 = findViewById(R.id.linear39);
		textview43 = findViewById(R.id.textview43);
		materialbutton6 = findViewById(R.id.materialbutton6);
		textview42 = findViewById(R.id.textview42);
		linear40 = findViewById(R.id.linear40);
		imageview7 = findViewById(R.id.imageview7);
		textview428 = findViewById(R.id.textview428);
		textview39 = findViewById(R.id.textview39);
		textview21 = findViewById(R.id.textview21);
		textview22 = findViewById(R.id.textview22);
		materialbutton4 = findViewById(R.id.materialbutton4);
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
		dialog = new AlertDialog.Builder(this);
		dialog2 = new AlertDialog.Builder(this);
		chiudi = new AlertDialog.Builder(this);
		
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
		
		linear36.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				
				return true;
			}
		});
		
		materialbutton5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ImpostazioniActivity.class);
				startActivity(intent);
			}
		});
		
		materialbutton6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				easteregg.setAction(Intent.ACTION_VIEW);
				easteregg.setData(Uri.parse("https://discord.gg/fkVXxPY27B"));
				startActivity(easteregg);
			}
		});
		
		imageview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Saltabili/")) {
					FileUtil.makeDir("storage/emulated/0/Android/data/jk.spotifinity/Saltabili/");
				}
				FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Saltabili/Discord.txt", "");
				linear36.setVisibility(View.GONE);
			}
		});
		
		materialbutton3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivity(sondaggio);
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), SelversioneActivity.class);
				intent.putExtra("ultima", textview5.getText().toString());
				startActivity(intent);
			}
		});
		
		materialbutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_ApriApp("com.spotify.music");
			}
		});
		
		imageview3.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				easteregg.setAction(Intent.ACTION_VIEW);
				easteregg.setData(Uri.parse("https://youtu.be/b80IxOODosg"));
				startActivity(easteregg);
				return true;
			}
		});
	}
	
	private void initializeLogic() {
		dialog = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		
		{
			materialbutton1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1BA8F0")));
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
			materialbutton2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1BA8F0")));
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
		
		{
			materialbutton3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1BA8F0")));
			materialbutton3.setRippleColor(ColorStateList.valueOf(Color.parseColor("#BBDEFB")));
			materialbutton3.setLetterSpacing(0);
			DisplayMetrics screen = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(screen);
			float logicalDensity = screen.density;
			int px = (int) Math.ceil(10 * logicalDensity);
			
			materialbutton3.setCornerRadius(px);
			materialbutton3.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()){
						case MotionEvent.ACTION_DOWN:{
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton3);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues(0.9f);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton3);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues(0.9f);
							scaleY.setDuration(100);
							scaleY.start();
							break;
						}
						case MotionEvent.ACTION_UP:{
							
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton3);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues((float)1);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton3);
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
			materialbutton4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1BA8F0")));
			materialbutton4.setRippleColor(ColorStateList.valueOf(Color.parseColor("#BBDEFB")));
			materialbutton4.setLetterSpacing(0);
			DisplayMetrics screen = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(screen);
			float logicalDensity = screen.density;
			int px = (int) Math.ceil(10 * logicalDensity);
			
			materialbutton4.setCornerRadius(px);
			materialbutton4.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()){
						case MotionEvent.ACTION_DOWN:{
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton4);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues(0.9f);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton4);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues(0.9f);
							scaleY.setDuration(100);
							scaleY.start();
							break;
						}
						case MotionEvent.ACTION_UP:{
							
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton4);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues((float)1);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton4);
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
			materialbutton5.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1BA8F0")));
			materialbutton5.setRippleColor(ColorStateList.valueOf(Color.parseColor("#BBDEFB")));
			materialbutton5.setLetterSpacing(0);
			DisplayMetrics screen = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(screen);
			float logicalDensity = screen.density;
			int px = (int) Math.ceil(10 * logicalDensity);
			
			materialbutton5.setCornerRadius(px);
			materialbutton5.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()){
						case MotionEvent.ACTION_DOWN:{
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton5);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues(0.9f);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton5);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues(0.9f);
							scaleY.setDuration(100);
							scaleY.start();
							break;
						}
						case MotionEvent.ACTION_UP:{
							
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton5);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues((float)1);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton5);
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
			materialbutton6.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2196F3")));
			materialbutton6.setRippleColor(ColorStateList.valueOf(Color.parseColor("#BBDEFB")));
			materialbutton6.setLetterSpacing(0);
			DisplayMetrics screen = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(screen);
			float logicalDensity = screen.density;
			int px = (int) Math.ceil(10 * logicalDensity);
			
			materialbutton6.setCornerRadius(px);
			materialbutton6.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()){
						case MotionEvent.ACTION_DOWN:{
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton6);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues(0.9f);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton6);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues(0.9f);
							scaleY.setDuration(100);
							scaleY.start();
							break;
						}
						case MotionEvent.ACTION_UP:{
							
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton6);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues((float)1);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton6);
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
		
		DisplayMetrics linear20Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear20Screen);
		double linear20DP = 10;
		double linear20LogicalDensity = linear20Screen.density;
		int linear20PX = (int) Math.ceil(linear20DP * linear20LogicalDensity);
		linear20.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#1BA8F0")); return this; } }.getIns((int)linear20PX, (int)0));
		linear20.setElevation(0);
		linear20.setTranslationZ(0);
		
		DisplayMetrics linear19Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear19Screen);
		double linear19DP = 10;
		double linear19LogicalDensity = linear19Screen.density;
		int linear19PX = (int) Math.ceil(linear19DP * linear19LogicalDensity);
		linear19.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear19PX, (int)0));
		linear19.setElevation(0);
		linear19.setTranslationZ(0);
		
		DisplayMetrics linear7Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear7Screen);
		double linear7DP = 10;
		double linear7LogicalDensity = linear7Screen.density;
		int linear7PX = (int) Math.ceil(linear7DP * linear7LogicalDensity);
		linear7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear7PX, (int)0));
		linear7.setElevation(0);
		linear7.setTranslationZ(0);
		
		DisplayMetrics linear12Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear12Screen);
		double linear12DP = 10;
		double linear12LogicalDensity = linear12Screen.density;
		int linear12PX = (int) Math.ceil(linear12DP * linear12LogicalDensity);
		linear12.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear12PX, (int)0));
		linear12.setElevation(0);
		linear12.setTranslationZ(0);
		
		DisplayMetrics linear8Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear8Screen);
		double linear8DP = 10;
		double linear8LogicalDensity = linear8Screen.density;
		int linear8PX = (int) Math.ceil(linear8DP * linear8LogicalDensity);
		linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#1BA8F0")); return this; } }.getIns((int)linear8PX, (int)0));
		linear8.setElevation(0);
		linear8.setTranslationZ(0);
		
		DisplayMetrics linear33Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear33Screen);
		double linear33DP = 10;
		double linear33LogicalDensity = linear33Screen.density;
		int linear33PX = (int) Math.ceil(linear33DP * linear33LogicalDensity);
		linear33.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear33PX, (int)0));
		linear33.setElevation(0);
		linear33.setTranslationZ(0);
		
		DisplayMetrics linear34Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear34Screen);
		double linear34DP = 10;
		double linear34LogicalDensity = linear34Screen.density;
		int linear34PX = (int) Math.ceil(linear34DP * linear34LogicalDensity);
		linear34.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#F57F17")); return this; } }.getIns((int)linear34PX, (int)0));
		linear34.setElevation(0);
		linear34.setTranslationZ(0);
		
		DisplayMetrics linear36Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear36Screen);
		double linear36DP = 10;
		double linear36LogicalDensity = linear36Screen.density;
		int linear36PX = (int) Math.ceil(linear36DP * linear36LogicalDensity);
		linear36.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#212121")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear36PX, (int)0));
		linear36.setElevation(0);
		linear36.setTranslationZ(0);
		linear20.setVisibility(View.GONE);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		_AggiornaLingua();
		FileUtil.deleteFile("storage/emulated/0/Android/data/jk.spotifinity/skipLoad");
		if (FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/configurazione")) {
			intent.setClass(getApplicationContext(), ConfiguraActivity.class);
			startActivity(intent);
		}
		if (!FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/modSviluppatore")) {
			linear21.setVisibility(View.INVISIBLE);
		}
		if (!FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/downloaded.txt").equals("Nessuna")) {
			textview15.setText(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/downloaded.txt"));
		}
		else {
			linear8.setVisibility(View.VISIBLE);
			textview4.setText(tv4);
			materialbutton2.setVisibility(View.GONE);
		}
		if (!(Double.parseDouble(getIntent().getStringExtra("updater")) == Double.parseDouble(textview23.getText().toString()))) {
			if (!FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/skipUpdate")) {
				dialog.setTitle(dt1.concat(getIntent().getStringExtra("updater").concat(")")));
				dialog.setMessage(dm);
				dialog.setIcon(R.drawable.ic_new_releases_white);
				dialog.setPositiveButton(dok, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						aggiorna.setAction(Intent.ACTION_VIEW);
						aggiorna.setData(Uri.parse("https://github.com/Spotifinity/app/releases"));
						startActivity(aggiorna);
					}
				});
				dialog.setNegativeButton(dc, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
						{
							DisplayMetrics screen = new DisplayMetrics();
							getWindowManager().getDefaultDisplay().getMetrics(screen);
							double dp = 10;
							double logicalDensity = screen.density;
							int px = (int) Math.ceil(dp * logicalDensity);
							Toast HomeActivityToast = Toast.makeText(HomeActivity.this, "Ignorato", 2000);
							View HomeActivityView = HomeActivityToast.getView();
							HomeActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
							
							
							TextView HomeActivityText = HomeActivityView.findViewById(android.R.id.message);
							HomeActivityText.setTextColor(Color.parseColor("#ffffff"));
							HomeActivityText.setShadowLayer(0,0,0,0);
							HomeActivityToast.show();
						}
					}
				});
				dialog.setNeutralButton(ds, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						dialog2.setTitle(d2t);
						dialog2.setMessage(d2m);
						dialog2.setIcon(R.drawable.ic_help_white);
						dialog2.setPositiveButton(d2ok, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/skipUpdate", "");
							}
						});
						dialog2.setNegativeButton(d2c, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						
						{
							final AlertDialog alert = dialog2.show();
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
				});
				
				{
					final AlertDialog alert = dialog.show();
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
			else {
				
				{
					DisplayMetrics screen = new DisplayMetrics();
					getWindowManager().getDefaultDisplay().getMetrics(screen);
					double dp = 10;
					double logicalDensity = screen.density;
					int px = (int) Math.ceil(dp * logicalDensity);
					Toast HomeActivityToast = Toast.makeText(HomeActivity.this, "Aggiornamento trovato però e stato saltato.", 2000);
					View HomeActivityView = HomeActivityToast.getView();
					HomeActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
					
					
					TextView HomeActivityText = HomeActivityView.findViewById(android.R.id.message);
					HomeActivityText.setTextColor(Color.parseColor("#ffffff"));
					HomeActivityText.setShadowLayer(0,0,0,0);
					HomeActivityToast.show();
				}
			}
		}
		if (getIntent().getStringExtra("poll").equals("0")) {
			linear19.setVisibility(View.GONE);
		}
		if (textview15.getText().toString().equals(tv15)) {
			textview4.setText(tv4);
			FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/downloaded.txt", tv15);
			textview15.setText(tv15);
		}
		textview20.setText(getIntent().getStringExtra("pollNome"));
		sondaggio.setAction(Intent.ACTION_VIEW);
		sondaggio.setData(Uri.parse(getIntent().getStringExtra("pollLink")));
		textview5.setText(getIntent().getStringExtra("version"));
		if (textview5.getText().toString().equals(textview15.getText().toString())) {
			linear8.setVisibility(View.GONE);
		}
		if (!(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").equals("") || !FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt"))) {
			linear34.setVisibility(View.GONE);
		}
		if (FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Saltabili/Discord.txt")) {
			linear36.setVisibility(View.GONE);
		}
	}
	
	@Override
	public void onBackPressed() {
		chiudi.setTitle("Chiudi app");
		chiudi.setMessage("Vuoi chiudere l'app?");
		chiudi.setIcon(R.drawable.ic_help_white);
		chiudi.setPositiveButton("Si", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				finishAffinity();
			}
		});
		chiudi.setNegativeButton("No", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		
		{
			final AlertDialog alert = chiudi.show();
			DisplayMetrics screen = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(screen);
			double dp = 10;
			double logicalDensity = screen.density;
			int px = (int) Math.ceil(dp * logicalDensity);
			alert.getWindow().getDecorView().setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
				alert.getWindow().getDecorView().setPadding(8,8,8,8);
			alert.show();
			
			alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#16DB63"));
				alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#16DB63"));
				alert.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(Color.parseColor("#16DB63"));
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
	public void _ApriApp(final String _app) {
		Intent launchIntent = getPackageManager().getLaunchIntentForPackage(_app);  { startActivity(launchIntent);}
	}
	
	
	public void _AggiornaLingua() {
		if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("it")) {
			_AggiornaLinguaBenvenuto("it");
			textview17.setText("Spotifinity");
			textview7.setText("Versione app:");
			textview40.setText("Imposta un username!");
			textview41.setText("Vai nelle impostazioni dell'app e imposta un username. Questo viene solamente visto per darti il buongiorno!");
			materialbutton5.setText("imposta username");
			
			
			
			textview18.setText("Sondaggio aperto");
			textview19.setText("Aiuta Spotifinity a migliorare il suo servizio rispondendo a un sondaggio cliccando il tasto qui sotto.");
			materialbutton3.setText("partecipa");
			textview2.setText("Ultima versione:");
			materialbutton1.setText("esplora versioni");
			textview16.setText("Installato");
			textview14.setText("Versione:");
			materialbutton2.setText("apri app");
			textview4.setText("Nuova versione, installala ora!");
			tv4 = "Mod ancora non installata, installala ora!";
			dt1 = "Nuova versione (";
			dm = "E stato rilevato una versione più recente di questa applicazione.\nVuoi andare sul sito di GitHub per scaricare l'ultima versione?";
			dok = "Aggiorna";
			dc = "Ignora";
			ds = "Salta";
			d2t = "Salta aggiornamento";
			d2m = "Vuoi veramente saltare questo e i futuri aggiornamenti di questa applicazione?";
			d2ok = "Si";
			d2c = "No";
			tv15 = "Nessuna";
		}
		else {
			if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("en")) {
				_AggiornaLinguaBenvenuto("en");
				linear36.setVisibility(View.GONE);
				textview17.setText("Spotifinity");
				textview7.setText("App version:");
				textview40.setText("Set a username!");
				textview41.setText("Go to the app settings and set a username. This is only seen to say good morning!");
				materialbutton5.setText("set username");
				
				
				
				textview18.setText("Survey opened");
				textview19.setText("Help Spotifinity improve its service by taking a survey by clicking the button below.");
				materialbutton3.setText("participate");
				textview2.setText("Latest version:");
				materialbutton1.setText("explore versions");
				textview16.setText("Installed");
				textview14.setText("Version:");
				materialbutton2.setText("open app");
				textview4.setText("New version, install it now!");
				tv4 = "Mod not installed yet, install it now!";
				dt1 = "New version (";
				dm = "A newer version of this application has been detected.\nDo you want to go to the GitHub site to download the latest version?";
				dok = "Update";
				dc = "Ignore";
				ds = "Skip";
				d2t = "Skip update";
				d2m = "Do you really want to skip this and future updates of this app?";
				d2ok = "Yes";
				d2c = "No";
				tv15 = "None";
			}
			else {
				if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("sq")) {
					_AggiornaLinguaBenvenuto("sq");
					linear36.setVisibility(View.GONE);
					textview17.setText("Spotifinity");
					textview7.setText("Versioni i aplikacionit:");
					textview40.setText("Vendosni një emër përdoruesi!");
					textview41.setText("Shkoni te cilësimet e aplikacionit dhe vendosni një emër përdoruesi. Kjo shihet vetëm për të thënë mirëmëngjes!");
					materialbutton5.setText("vendos emrin e përdoruesit");
					
					
					
					textview18.setText("Sondazhin hapur");
					textview19.setText("Ndihmoni Spotifinity të përmirësojë shërbimin e tij duke bërë një anketë duke klikuar butonin më poshtë.");
					materialbutton3.setText("marrin pjesë");
					textview2.setText("Versioni i fundit:");
					materialbutton1.setText("eksploroni versionet");
					textview16.setText("Instaluar");
					textview14.setText("Version:");
					materialbutton2.setText("hap aplikacionin");
					textview4.setText("Versioni i ri, instalojeni tani!");
					tv4 = "Mod nuk është instaluar ende, instalojeni tani!";
					dt1 = "Versioni i ri (";
					dm = "Është zbuluar një version më i ri i këtij aplikacioni.\nDëshironi të shkoni në faqen e GitHub për të shkarkuar versionin më të fundit?";
					dok = "Përditëso";
					dc = "Injoro";
					ds = "Kapërce";
					d2t = "Kapërce përditësimin";
					d2m = "Dëshiron vërtet të kapërcesh këtë dhe përditësimet e ardhshme të këtij aplikacioni?";
					d2ok = "Po";
					d2c = "Jo";
					tv15 = "Asnje";
				}
				else {
					if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("ru")) {
						_AggiornaLinguaBenvenuto("ru");
						linear36.setVisibility(View.GONE);
						textview17.setText("Спотифинити");
						textview40.setText("Установите имя пользователя!");
						textview41.setText("Зайдите в настройки приложения и задайте имя пользователя. Это видно только для того, чтобы пожелать доброго утра!");
						materialbutton5.setText("установить имя пользователя");
						
						
						
						textview18.setText("Открытый опрос");
						textview19.setText("Помогите Spotifinity улучшить свои услуги, приняв участие в опросе, нажав кнопку ниже.");
						materialbutton3.setText("участвовать");
						textview2.setText("Последняя версия:");
						materialbutton1.setText("исследовать версии");
						textview16.setText("Установлен");
						textview14.setText("Версия:");
						materialbutton2.setText("открыть приложение");
						textview7.setText("Версия приложения:");
						textview4.setText("Новая версия, установите ее прямо сейчас!");
						tv4 = "Мод еще не установлен, установите его прямо сейчас!";
						dt1 = "Новая версия (";
						dm = "Обнаружена более новая версия этого приложения.\nВы хотите перейти на сайт GitHub, чтобы загрузить последнюю версию?";
						dok = "Обновлять";
						dc = "Игнорировать";
						ds = "Пропускать";
						d2t = "Пропустить обновление";
						d2m = "Вы действительно хотите пропустить это и будущие обновления этого приложения?";
						d2ok = "Да";
						d2c = "Нет";
						tv15 = "Никто";
					}
					else {
						
					}
				}
			}
		}
	}
	
	
	public void _AggiornaLinguaBenvenuto(final String _lingua) {
		educazione = Calendar.getInstance();
		OraNoPunti = Double.parseDouble(new SimpleDateFormat("HH").format(educazione.getTime()));
		if (_lingua.equals("it")) {
			if (FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt")) {
				if ((OraNoPunti == 6) || ((OraNoPunti == 7) || ((OraNoPunti == 8) || ((OraNoPunti == 9) || ((OraNoPunti == 10) || ((OraNoPunti == 11) || (OraNoPunti == 12))))))) {
					textview428.setText("Buongiorno, ".concat(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").concat("!")));
				}
				else {
					if ((OraNoPunti == 14) || ((OraNoPunti == 15) || ((OraNoPunti == 16) || (OraNoPunti == 17)))) {
						textview428.setText("Buon pomeriggio, ".concat(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").concat("!")));
					}
					else {
						if ((OraNoPunti == 18) || ((OraNoPunti == 19) || (OraNoPunti == 20))) {
							textview428.setText("Buonasera, ".concat(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").concat("!")));
						}
						else {
							if ((OraNoPunti == 21) || ((OraNoPunti == 22) || ((OraNoPunti == 23) || ((OraNoPunti == 0) || ((OraNoPunti == 1) || ((OraNoPunti == 2) || ((OraNoPunti == 3) || ((OraNoPunti == 4) || (OraNoPunti == 5))))))))) {
								textview428.setText("Buonanotte, ".concat(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").concat("!")));
								textview39.setText("E sogni d'oro!");
							}
							else {
								textview428.setText("Benvenuto, ".concat(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").concat("!")));
							}
						}
					}
				}
			}
			else {
				textview428.setText("Benvenuto, utente!");
			}
		}
		else {
			if (_lingua.equals("en")) {
				if (FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt")) {
					textview39.setText("Buona giornata!");
					if ((OraNoPunti == 6) || ((OraNoPunti == 7) || ((OraNoPunti == 8) || ((OraNoPunti == 9) || ((OraNoPunti == 10) || ((OraNoPunti == 11) || (OraNoPunti == 12))))))) {
						textview428.setText("Good morning, ".concat(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").concat("!")));
					}
					else {
						if ((OraNoPunti == 14) || ((OraNoPunti == 15) || ((OraNoPunti == 16) || (OraNoPunti == 17)))) {
							textview428.setText("Good afternoon, ".concat(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").concat("!")));
						}
						else {
							if ((OraNoPunti == 18) || ((OraNoPunti == 19) || (OraNoPunti == 20))) {
								textview428.setText("Good evening, ".concat(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").concat("!")));
							}
							else {
								if ((OraNoPunti == 21) || ((OraNoPunti == 22) || ((OraNoPunti == 23) || ((OraNoPunti == 0) || ((OraNoPunti == 1) || ((OraNoPunti == 2) || ((OraNoPunti == 3) || ((OraNoPunti == 4) || (OraNoPunti == 5))))))))) {
									textview428.setText("Good night, ".concat(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").concat("!")));
									textview39.setText("And sweet dreams!");
								}
								else {
									textview428.setText("Welcome, ".concat(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").concat("!")));
								}
							}
						}
					}
				}
				else {
					textview428.setText("Welcome, user!");
				}
			}
			else {
				if (_lingua.equals("sq")) {
					if (FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt")) {
						if ((OraNoPunti == 6) || ((OraNoPunti == 7) || ((OraNoPunti == 8) || ((OraNoPunti == 9) || ((OraNoPunti == 10) || ((OraNoPunti == 11) || (OraNoPunti == 12))))))) {
							textview428.setText("Miremengjes, ".concat(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").concat("!")));
						}
						else {
							if ((OraNoPunti == 14) || ((OraNoPunti == 15) || ((OraNoPunti == 16) || (OraNoPunti == 17)))) {
								textview428.setText("Mirembrema, ".concat(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").concat("!")));
							}
							else {
								if ((OraNoPunti == 18) || ((OraNoPunti == 19) || (OraNoPunti == 20))) {
									textview428.setText("Mirembrema, ".concat(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").concat("!")));
								}
								else {
									if ((OraNoPunti == 21) || ((OraNoPunti == 22) || ((OraNoPunti == 23) || ((OraNoPunti == 0) || ((OraNoPunti == 1) || ((OraNoPunti == 2) || ((OraNoPunti == 3) || ((OraNoPunti == 4) || (OraNoPunti == 5))))))))) {
										textview428.setText("Naten e mire, ".concat(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").concat("!")));
										textview39.setText("Dhe ëndrrat e ëmbla!");
									}
									else {
										textview428.setText("Mirë se vini, ".concat(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").concat("!")));
									}
								}
							}
						}
					}
					else {
						textview428.setText("Mirësevini, përdorues!");
					}
				}
				else {
					if (_lingua.equals("ru")) {
						if (FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt")) {
							if ((OraNoPunti == 6) || ((OraNoPunti == 7) || ((OraNoPunti == 8) || ((OraNoPunti == 9) || ((OraNoPunti == 10) || ((OraNoPunti == 11) || (OraNoPunti == 12))))))) {
								textview428.setText("Доброе утро, ".concat(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").concat("!")));
							}
							else {
								if ((OraNoPunti == 14) || ((OraNoPunti == 15) || ((OraNoPunti == 16) || (OraNoPunti == 17)))) {
									textview428.setText("Добрый день, ".concat(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").concat("!")));
								}
								else {
									if ((OraNoPunti == 18) || ((OraNoPunti == 19) || (OraNoPunti == 20))) {
										textview428.setText("Добрый вечер, ".concat(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").concat("!")));
									}
									else {
										if ((OraNoPunti == 21) || ((OraNoPunti == 22) || ((OraNoPunti == 23) || ((OraNoPunti == 0) || ((OraNoPunti == 1) || ((OraNoPunti == 2) || ((OraNoPunti == 3) || ((OraNoPunti == 4) || (OraNoPunti == 5))))))))) {
											textview428.setText("Спокойной ночи, ".concat(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").concat("!")));
											textview39.setText("И сладких снов!");
										}
										else {
											textview428.setText("Добро пожаловать, ".concat(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt").concat("!")));
										}
									}
								}
							}
						}
						else {
							textview428.setText("Добро пожаловать, пользователь!");
						}
					}
					else {
						
					}
				}
			}
		}
	}
	
}