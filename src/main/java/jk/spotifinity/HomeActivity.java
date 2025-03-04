package jk.spotifinity;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.room.*;
import androidx.sqlite.db.*;
import androidx.sqlite.db.framework.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import com.google.android.material.button.*;
import com.google.firebase.FirebaseApp;
import com.mannan.translateapi.*;
import com.tonyodev.fetch2.*;
import com.tonyodev.fetch2core.*;
import eightbitlab.com.blurview.*;
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
	private HashMap<String, Object> req = new HashMap<>();
	private double OraNoPunti = 0;
	private String azione = "";
	
	private LinearLayout linear3;
	private ScrollView vscroll1;
	private BottomNavigationView bottomnavigation2;
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
	private LinearLayout linear41;
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
	private LinearLayout linear42;
	private TextView textview431;
	private ImageView imageview8;
	private TextView textview430;
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
	private ImageView imageview2;
	private TextView textview10;
	private TextView textview4;
	private TextView textview2;
	private TextView textview5;
	private LinearLayout linear13;
	private LinearLayout linear16;
	private ImageView imageview3;
	private TextView textview16;
	private TextView textview429;
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
	private SharedPreferences account;
	private SharedPreferences impostazioni;
	private SharedPreferences mod;
	private SharedPreferences updater;
	private SharedPreferences saltabili;
	private Calendar ora = Calendar.getInstance();
	private TimerTask permesso;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear3 = findViewById(R.id.linear3);
		vscroll1 = findViewById(R.id.vscroll1);
		bottomnavigation2 = findViewById(R.id.bottomnavigation2);
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
		linear41 = findViewById(R.id.linear41);
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
		linear42 = findViewById(R.id.linear42);
		textview431 = findViewById(R.id.textview431);
		imageview8 = findViewById(R.id.imageview8);
		textview430 = findViewById(R.id.textview430);
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
		imageview2 = findViewById(R.id.imageview2);
		textview10 = findViewById(R.id.textview10);
		textview4 = findViewById(R.id.textview4);
		textview2 = findViewById(R.id.textview2);
		textview5 = findViewById(R.id.textview5);
		linear13 = findViewById(R.id.linear13);
		linear16 = findViewById(R.id.linear16);
		imageview3 = findViewById(R.id.imageview3);
		textview16 = findViewById(R.id.textview16);
		textview429 = findViewById(R.id.textview429);
		textview14 = findViewById(R.id.textview14);
		textview15 = findViewById(R.id.textview15);
		dialog = new AlertDialog.Builder(this);
		dialog2 = new AlertDialog.Builder(this);
		chiudi = new AlertDialog.Builder(this);
		account = getSharedPreferences("account", Activity.MODE_PRIVATE);
		impostazioni = getSharedPreferences("impostazioni", Activity.MODE_PRIVATE);
		mod = getSharedPreferences("mod", Activity.MODE_PRIVATE);
		updater = getSharedPreferences("updater", Activity.MODE_PRIVATE);
		saltabili = getSharedPreferences("saltabili", Activity.MODE_PRIVATE);
		
		bottomnavigation2.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(MenuItem item) {
				final int _itemId = item.getItemId();
				if (_itemId == 1) {
					intent.setClass(getApplicationContext(), SelversioneActivity.class);
					intent.putExtra("ultima", textview5.getText().toString());
					startActivity(intent);
				}
				else {
					if (_itemId == 2) {
						intent.setClass(getApplicationContext(), TotcommentiActivity.class);
						startActivity(intent);
					}
					else {
						if (_itemId == 3) {
							intent.setClass(getApplicationContext(), ImpostazioniActivity.class);
							startActivity(intent);
						}
						else {
							
						}
					}
				}
				return true;
			}
		});
		
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
		
		linear41.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				requestPermissions(new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
				wait = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								if (Build.VERSION.SDK_INT >= 23) {
												if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == android.content.pm.PackageManager.PERMISSION_DENIED) {
														linear7.setEnabled(false);
												}
												else {
										bottomnavigation2.getMenu().add(0, 1, 0, "Versioni").setIcon(R.drawable.ic_description_white);
										linear41.setVisibility(View.GONE);
										linear7.setEnabled(true);
										wait.cancel();
												}
										}
										else {
									bottomnavigation2.getMenu().add(0, 1, 0, "Versioni").setIcon(R.drawable.ic_description_white);
									linear41.setVisibility(View.GONE);
									linear7.setEnabled(true);
									wait.cancel();
										}
							}
						});
					}
				};
				_timer.scheduleAtFixedRate(wait, (int)(500), (int)(250));
			}
		});
		
		linear7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), SelversioneActivity.class);
				intent.putExtra("ultima", textview5.getText().toString());
				startActivity(intent);
			}
		});
		
		linear12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_ApriApp("com.spotify.music");
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
				saltabili.edit().putString("Discord", "0").commit();
				linear36.setVisibility(View.GONE);
			}
		});
		
		materialbutton3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivity(sondaggio);
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
		
		int[][] states = new int[][] { 
			    new int[] { android.R.attr.state_checked }, 
			            new int[] {} }; 
		 int[] colors = new int[] { Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF") };
		ColorStateList iconColors = new ColorStateList(states, colors);
		bottomnavigation2.setItemTextColor(iconColors);
		bottomnavigation2.setItemIconTintList(iconColors);
		bottomnavigation2.setItemRippleColor(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
		bottomnavigation2.setBackgroundColor(Color.parseColor("#424242"));
		bottomnavigation2.setLabelVisibilityMode(BottomNavigationView.LABEL_VISIBILITY_LABELED);
		
		{
			materialbutton3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2196F3")));
			materialbutton3.setRippleColor(ColorStateList.valueOf(Color.parseColor("#BBDEFB")));
			materialbutton3.setLetterSpacing(0);
			DisplayMetrics screen = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(screen);
			float logicalDensity = screen.density;
			int px = (int) Math.ceil(10 * logicalDensity);
			
			materialbutton3.setCornerRadius(px);
		}
		
		{
			materialbutton4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2196F3")));
			materialbutton4.setRippleColor(ColorStateList.valueOf(Color.parseColor("#BBDEFB")));
			materialbutton4.setLetterSpacing(0);
			DisplayMetrics screen = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(screen);
			float logicalDensity = screen.density;
			int px = (int) Math.ceil(10 * logicalDensity);
			
			materialbutton4.setCornerRadius(px);
		}
		
		{
			materialbutton5.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2196F3")));
			materialbutton5.setRippleColor(ColorStateList.valueOf(Color.parseColor("#BBDEFB")));
			materialbutton5.setLetterSpacing(0);
			DisplayMetrics screen = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(screen);
			float logicalDensity = screen.density;
			int px = (int) Math.ceil(10 * logicalDensity);
			
			materialbutton5.setCornerRadius(px);
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
		}
		DisplayMetrics linear20Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear20Screen);
		double linear20DP = 10;
		double linear20LogicalDensity = linear20Screen.density;
		int linear20PX = (int) Math.ceil(linear20DP * linear20LogicalDensity);
		linear20.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#2196F3")); return this; } }.getIns((int)linear20PX, (int)0));
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
		android.graphics.drawable.GradientDrawable linear7GG = new android.graphics.drawable.GradientDrawable();
		linear7GG.setColor(Color.parseColor("#212121"));
		linear7GG.setCornerRadius((float)linear7PX);
		linear7GG.setStroke((int) 0,
		Color.parseColor("#000000"));
		android.graphics.drawable.RippleDrawable linear7RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#2196F3")}), linear7GG, null);
		linear7.setBackground(linear7RE);
		linear7.setElevation(0);
		linear7.setTranslationZ(0);
		
		DisplayMetrics linear12Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear12Screen);
		double linear12DP = 10;
		double linear12LogicalDensity = linear12Screen.density;
		int linear12PX = (int) Math.ceil(linear12DP * linear12LogicalDensity);
		android.graphics.drawable.GradientDrawable linear12GG = new android.graphics.drawable.GradientDrawable();
		linear12GG.setColor(Color.parseColor("#212121"));
		linear12GG.setCornerRadius((float)linear12PX);
		linear12GG.setStroke((int) 0,
		Color.parseColor("#000000"));
		android.graphics.drawable.RippleDrawable linear12RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#2196F3")}), linear12GG, null);
		linear12.setBackground(linear12RE);
		linear12.setElevation(0);
		linear12.setTranslationZ(0);
		DisplayMetrics linear8Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear8Screen);
		double linear8DP = 10;
		double linear8LogicalDensity = linear8Screen.density;
		int linear8PX = (int) Math.ceil(linear8DP * linear8LogicalDensity);
		linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#2196F3")); return this; } }.getIns((int)linear8PX, (int)0));
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
		linear34.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#FF9800")); return this; } }.getIns((int)linear34PX, (int)0));
		linear34.setElevation(0);
		linear34.setTranslationZ(0);
		
		DisplayMetrics linear36Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear36Screen);
		double linear36DP = 10;
		double linear36LogicalDensity = linear36Screen.density;
		int linear36PX = (int) Math.ceil(linear36DP * linear36LogicalDensity);
		linear36.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear36PX, (int)0));
		linear36.setElevation(0);
		linear36.setTranslationZ(0);
		
		DisplayMetrics linear41Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear41Screen);
		double linear41DP = 10;
		double linear41LogicalDensity = linear41Screen.density;
		int linear41PX = (int) Math.ceil(linear41DP * linear41LogicalDensity);
		android.graphics.drawable.GradientDrawable linear41GG = new android.graphics.drawable.GradientDrawable();
		linear41GG.setColor(Color.parseColor("#212121"));
		linear41GG.setCornerRadius((float)linear41PX);
		linear41GG.setStroke((int) 0,
		Color.parseColor("#000000"));
		android.graphics.drawable.RippleDrawable linear41RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#2196F3")}), linear41GG, null);
		linear41.setBackground(linear41RE);
		linear41.setElevation(0);
		linear41.setTranslationZ(0);
		bottomnavigation2.getMenu().add(0, 2, 0, "Commenti").setIcon(R.drawable.ic_comment_white);
		bottomnavigation2.getMenu().add(0, 3, 0, "Impostazioni").setIcon(R.drawable.ic_settings_white);
		linear20.setVisibility(View.GONE);
		if (Build.VERSION.SDK_INT >= 23) {
						if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == android.content.pm.PackageManager.PERMISSION_DENIED) {
								 
						}
						else {
				bottomnavigation2.getMenu().add(0, 1, 0, "Versioni").setIcon(R.drawable.ic_description_white);
						}
				}
				else {
			bottomnavigation2.getMenu().add(0, 1, 0, "Versioni").setIcon(R.drawable.ic_description_white);
				}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		account.edit().remove("skip").commit();
		if (account.contains("configura")) {
			intent.setClass(getApplicationContext(), ConfiguraActivity.class);
			startActivity(intent);
		}
		if (!impostazioni.contains("modSviluppatore")) {
			linear21.setVisibility(View.INVISIBLE);
		}
		if (!mod.getString("downloaded", "").equals("Nessuna")) {
			textview15.setText(mod.getString("downloaded", ""));
		}
		else {
			linear8.setVisibility(View.VISIBLE);
			textview4.setText("Mod ancora non installata, installala ora!");
		}
		if (!(Double.parseDouble(getIntent().getStringExtra("updater")) == Double.parseDouble(textview23.getText().toString()))) {
			if (!updater.contains("skip")) {
				dialog.setTitle("Nuova versione (".concat(getIntent().getStringExtra("updater").concat(")")));
				dialog.setMessage("E stato rilevato una versione più recente di questa applicazione.\nVuoi andare sul sito di GitHub per scaricare l'ultima versione?");
				dialog.setIcon(R.drawable.ic_new_releases_white);
				dialog.setPositiveButton("Aggiorna", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						aggiorna.setAction(Intent.ACTION_VIEW);
						aggiorna.setData(Uri.parse("https://github.com/Spotifinity/app/releases"));
						startActivity(aggiorna);
					}
				});
				dialog.setNegativeButton("Ignora", new DialogInterface.OnClickListener() {
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
				dialog.setNeutralButton("Salta", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						dialog2.setTitle("Salta aggiornamento");
						dialog2.setMessage("Vuoi veramente saltare questo e i futuri aggiornamenti di questa applicazione?");
						dialog2.setIcon(R.drawable.ic_help_white);
						dialog2.setPositiveButton("Si", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								updater.edit().putString("skip", "true").commit();
							}
						});
						dialog2.setNegativeButton("No", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						{
							DisplayMetrics screen = new DisplayMetrics();
							getWindowManager().getDefaultDisplay().getMetrics(screen);
							double dp = 10;
							double logicalDensity = screen.density;
							int px = (int) Math.ceil(dp * logicalDensity);
							Toast HomeActivityToast = Toast.makeText(HomeActivity.this, "dialog2", 2000);
							View HomeActivityView = HomeActivityToast.getView();
							HomeActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
							
							
							TextView HomeActivityText = HomeActivityView.findViewById(android.R.id.message);
							HomeActivityText.setTextColor(Color.parseColor("#ffffff"));
							HomeActivityText.setShadowLayer(0,0,0,0);
							HomeActivityToast.show();
						}
					}
				});
				if (linear20.getVisibility() == View.GONE) {
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
		if (textview15.getText().toString().equals("Nessuna")) {
			textview4.setText("Mod ancora non installata, installala ora!");
			mod.edit().putString("downloaded", "Nessuna").commit();
			textview15.setText("Nessuna");
			textview429.setVisibility(View.INVISIBLE);
			linear12.setEnabled(false);
		}
		textview20.setText(getIntent().getStringExtra("pollNome"));
		sondaggio.setAction(Intent.ACTION_VIEW);
		sondaggio.setData(Uri.parse(getIntent().getStringExtra("pollLink")));
		textview5.setText(getIntent().getStringExtra("version"));
		if (textview5.getText().toString().equals(textview15.getText().toString())) {
			linear8.setVisibility(View.GONE);
		}
		if (!(account.getString("username", "").equals("") || !account.contains("username"))) {
			linear34.setVisibility(View.GONE);
		}
		if (saltabili.contains("discord")) {
			linear36.setVisibility(View.GONE);
		}
		if (account.contains("username")) {
			Calendar c = Calendar.getInstance();
			int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
			if(timeOfDay >= 6 && timeOfDay < 12){
				textview428.setText("Buongiorno, ".concat(account.getString("username", "").concat("!")));
			}
			if(timeOfDay >= 13 && timeOfDay < 17){
				textview428.setText("Buon pomeriggio, ".concat(account.getString("username", "").concat("!")));
			}
			if(timeOfDay >= 18 && timeOfDay < 20){
				textview428.setText("Buonasera, ".concat(account.getString("username", "").concat("!")));
			}
			if(timeOfDay >= 21 && timeOfDay < 5){
				textview428.setText("Buonanotte, ".concat(account.getString("username", "").concat("!")));
				textview39.setText("E sogni d'oro!");
			}
		}
		else {
			textview428.setText("Benvenuto, utente!");
		}
		if ((OraNoPunti == 6) || ((OraNoPunti == 7) || ((OraNoPunti == 8) || ((OraNoPunti == 9) || ((OraNoPunti == 10) || ((OraNoPunti == 11) || (OraNoPunti == 12))))))) {
			
		}
		else {
			if ((OraNoPunti == 14) || ((OraNoPunti == 15) || ((OraNoPunti == 16) || (OraNoPunti == 17)))) {
				
			}
			else {
				if ((OraNoPunti == 18) || ((OraNoPunti == 19) || (OraNoPunti == 20))) {
					
				}
				else {
					if ((OraNoPunti == 21) || ((OraNoPunti == 22) || ((OraNoPunti == 23) || ((OraNoPunti == 0) || ((OraNoPunti == 1) || ((OraNoPunti == 2) || ((OraNoPunti == 3) || ((OraNoPunti == 4) || (OraNoPunti == 5))))))))) {
						
					}
					else {
						
					}
				}
			}
		}
		if (Build.VERSION.SDK_INT >= 23) {
						if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == android.content.pm.PackageManager.PERMISSION_DENIED) {
								linear7.setEnabled(false);
						}
						else {
				linear7.setEnabled(true);
				linear41.setVisibility(View.GONE);
						}
				}
				else {
			linear7.setEnabled(true);
			linear41.setVisibility(View.GONE);
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
	public void _ApriApp(final String _app) {
		Intent launchIntent = getPackageManager().getLaunchIntentForPackage(_app);  { startActivity(launchIntent);}
	}
	
}