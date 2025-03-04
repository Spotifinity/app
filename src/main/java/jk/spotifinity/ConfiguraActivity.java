package jk.spotifinity;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.SharedPreferences;
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
import eightbitlab.com.blurview.*;
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
	private SharedPreferences account;
	private SharedPreferences mod;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.configura);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear7 = findViewById(R.id.linear7);
		linear11 = findViewById(R.id.linear11);
		linear10 = findViewById(R.id.linear10);
		materialbutton1 = findViewById(R.id.materialbutton1);
		textview10 = findViewById(R.id.textview10);
		textview11 = findViewById(R.id.textview11);
		account = getSharedPreferences("account", Activity.MODE_PRIVATE);
		mod = getSharedPreferences("mod", Activity.MODE_PRIVATE);
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				account.edit().remove("configura").commit();
				mod.edit().putString("downloaded", account.getString("configuraVer", "")).commit();
				finish();
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
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =ConfiguraActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF000000);
		}
	}
	public void _ApriApp(final String _app) {
		Intent launchIntent = getPackageManager().getLaunchIntentForPackage(_app);  { startActivity(launchIntent);}
	}
	
}