package jk.spotifinity;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
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
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class ConfiguraActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private String lang = "";
	
	private LinearLayout linear1;
	private LinearLayout linear7;
	private LinearLayout linear11;
	private LinearLayout linear10;
	private MaterialButton materialbutton1;
	private TextView textview10;
	private TextView textview11;
	
	private TimerTask wait;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.configura);
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
		linear7 = findViewById(R.id.linear7);
		linear11 = findViewById(R.id.linear11);
		linear10 = findViewById(R.id.linear10);
		materialbutton1 = findViewById(R.id.materialbutton1);
		textview10 = findViewById(R.id.textview10);
		textview11 = findViewById(R.id.textview11);
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_ApriApp("com.spotify.music");
				wait = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								FileUtil.deleteFile("storage/emulated/0/Android/data/jk.spotifinity/configurazione");
								FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/downloaded.txt", FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/configurazioneVer"));
								
								{
									DisplayMetrics screen = new DisplayMetrics();
									getWindowManager().getDefaultDisplay().getMetrics(screen);
									double dp = 10;
									double logicalDensity = screen.density;
									int px = (int) Math.ceil(dp * logicalDensity);
									Toast ConfiguraActivityToast = Toast.makeText(ConfiguraActivity.this, "App configurata!", 2000);
									View ConfiguraActivityView = ConfiguraActivityToast.getView();
									ConfiguraActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
									
									
									TextView ConfiguraActivityText = ConfiguraActivityView.findViewById(android.R.id.message);
									ConfiguraActivityText.setTextColor(Color.parseColor("#ffffff"));
									ConfiguraActivityText.setShadowLayer(0,0,0,0);
									ConfiguraActivityToast.show();
								}
								finish();
							}
						});
					}
				};
				_timer.schedule(wait, (int)(3000));
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
		
		DisplayMetrics linear7Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear7Screen);
		double linear7DP = 10;
		double linear7LogicalDensity = linear7Screen.density;
		int linear7PX = (int) Math.ceil(linear7DP * linear7LogicalDensity);
		linear7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear7PX, (int)0));
		linear7.setElevation(0);
		linear7.setTranslationZ(0);
	}
	
	@Override
	public void onBackPressed() {
		
	}
	
	@Override
	public void onStart() {
		super.onStart();
		_AggiornaLingua();
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =ConfiguraActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF000000);
		}
		if (FileUtil.isExistFile("storage/emulated/0/Android/data/com.spotify.music") && FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/downloaded.txt").equals("")) {
			SketchwareUtil.showMessage(getApplicationContext(), "Ciao");
		}
	}
	public void _ApriApp(final String _app) {
		Intent launchIntent = getPackageManager().getLaunchIntentForPackage(_app);  { startActivity(launchIntent);}
	}
	
	
	public void _AggiornaLingua() {
		if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("it")) {
			textview10.setText("Configura l'app prima di continuare");
			textview11.setText("Sulla schermata che ti e apparso che ti chiede di installare Spotify clicca il tasto INSTALLA e poi, una volta finito, il tasto FINE non apri!\nPoi clicca il tasto qui sotto \"Completa congratulazione\".");
			materialbutton1.setText("completa configurazione");
			lang = "Nessuna";
		}
		else {
			if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("en")) {
				textview10.setText("Configure the app before continuing");
				textview11.setText("On the screen that appears asking you to install Spotify, click the INSTALL button and then, once finished, the END button does not open!\nThen click the button below \"Complete configuration\".");
				materialbutton1.setText("complete configuration");
				lang = "None";
			}
			else {
				if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("sq")) {
					textview10.setText("Konfiguro aplikacionin përpara se të vazhdosh");
					textview11.setText("Në ekranin që shfaqet duke ju kërkuar të instaloni Spotify, klikoni butonin INSTALL dhe më pas, pasi të keni mbaruar,kliko butoni FUND, jo HAPE!\nPastaj klikoni butonin më poshtë \"Mbaroi configurimi\".");
					materialbutton1.setText("Mbaroi configurimi");
					lang = "Asnje";
				}
				else {
					if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("ru")) {
						textview10.setText("Настройте приложение, прежде чем продолжить");
						textview11.setText("На появившемся экране с предложением установить Spotify нажмите кнопку «УСТАНОВИТЬ», а затем, после завершения, кнопка «КОНЕЦ» не открывается!\nЗатем нажмите кнопку ниже «полная конфигурация».");
						materialbutton1.setText("полная конфигурация");
						lang = "Никто";
					}
					else {
						
					}
				}
			}
		}
	}
	
}