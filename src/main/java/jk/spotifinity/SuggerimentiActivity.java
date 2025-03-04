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
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
import com.google.android.material.button.*;
import com.google.firebase.FirebaseApp;
import com.mannan.translateapi.*;
import com.tonyodev.fetch2.*;
import com.tonyodev.fetch2core.*;
import eightbitlab.com.blurview.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class SuggerimentiActivity extends AppCompatActivity {
	
	private LinearLayout linear3;
	private ScrollView vscroll1;
	private ImageView imageview2;
	private TextView textview1;
	private LinearLayout linear6;
	private TextView textview2;
	private LinearLayout linear7;
	private LinearLayout linear37;
	private LinearLayout linear53;
	private MaterialButton materialbutton1;
	private MaterialButton materialbutton2;
	private LinearLayout linear40;
	private TextView textview34;
	private LinearLayout linear39;
	private CheckBox psd;
	private LinearLayout linear54;
	private TextView textview43;
	private LinearLayout linear55;
	private CheckBox cium;
	
	private SharedPreferences saltabili;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.suggerimenti);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear3 = findViewById(R.id.linear3);
		vscroll1 = findViewById(R.id.vscroll1);
		imageview2 = findViewById(R.id.imageview2);
		textview1 = findViewById(R.id.textview1);
		linear6 = findViewById(R.id.linear6);
		textview2 = findViewById(R.id.textview2);
		linear7 = findViewById(R.id.linear7);
		linear37 = findViewById(R.id.linear37);
		linear53 = findViewById(R.id.linear53);
		materialbutton1 = findViewById(R.id.materialbutton1);
		materialbutton2 = findViewById(R.id.materialbutton2);
		linear40 = findViewById(R.id.linear40);
		textview34 = findViewById(R.id.textview34);
		linear39 = findViewById(R.id.linear39);
		psd = findViewById(R.id.psd);
		linear54 = findViewById(R.id.linear54);
		textview43 = findViewById(R.id.textview43);
		linear55 = findViewById(R.id.linear55);
		cium = findViewById(R.id.cium);
		saltabili = getSharedPreferences("saltabili", Activity.MODE_PRIVATE);
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				psd.setChecked(true);
				cium.setChecked(true);
				saltabili.edit().putString("Discord", "0").commit();
				saltabili.edit().putString("ComeInstallare", "0").commit();
			}
		});
		
		materialbutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				psd.setChecked(false);
				cium.setChecked(false);
				saltabili.edit().remove("Discord").commit();
				saltabili.edit().remove("ComeInstallare").commit();
			}
		});
		
		psd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					saltabili.edit().putString("Discord", "0").commit();
				}
				else {
					saltabili.edit().remove("Discord").commit();
				}
			}
		});
		
		cium.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					saltabili.edit().putString("ComeInstallare", "0").commit();
				}
				else {
					saltabili.edit().remove("ComeInstallare").commit();
				}
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
		
		{
			materialbutton2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2196F3")));
			materialbutton2.setRippleColor(ColorStateList.valueOf(Color.parseColor("#BBDEFB")));
			materialbutton2.setLetterSpacing(0);
			DisplayMetrics screen = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(screen);
			float logicalDensity = screen.density;
			int px = (int) Math.ceil(10 * logicalDensity);
			
			materialbutton2.setCornerRadius(px);
		}
		
		DisplayMetrics linear37Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear37Screen);
		double linear37DP = 10;
		double linear37LogicalDensity = linear37Screen.density;
		int linear37PX = (int) Math.ceil(linear37DP * linear37LogicalDensity);
		linear37.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear37PX, (int)0));
		linear37.setElevation(0);
		linear37.setTranslationZ(0);
		
		DisplayMetrics linear53Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear53Screen);
		double linear53DP = 10;
		double linear53LogicalDensity = linear53Screen.density;
		int linear53PX = (int) Math.ceil(linear53DP * linear53LogicalDensity);
		linear53.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear53PX, (int)0));
		linear53.setElevation(0);
		linear53.setTranslationZ(0);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (saltabili.contains("Discord")) {
			psd.setChecked(true);
		}
		if (saltabili.contains("ComeInstallare")) {
			cium.setChecked(true);
		}
	}
}