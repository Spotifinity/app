package jk.spotifinity;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
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
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.room.*;
import androidx.sqlite.db.*;
import androidx.sqlite.db.framework.*;
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

public class SocialActivity extends AppCompatActivity {
	
	private LinearLayout linear3;
	private LinearLayout linear4;
	private ImageView imageview2;
	private TextView textview1;
	private LinearLayout linear5;
	private LinearLayout linear8;
	private LinearLayout linear11;
	private LinearLayout linear14;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private TextView textview2;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private TextView textview3;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private TextView textview4;
	private LinearLayout linear15;
	private ImageView imageview3;
	private TextView textview5;
	
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.social);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		imageview2 = findViewById(R.id.imageview2);
		textview1 = findViewById(R.id.textview1);
		linear5 = findViewById(R.id.linear5);
		linear8 = findViewById(R.id.linear8);
		linear11 = findViewById(R.id.linear11);
		linear14 = findViewById(R.id.linear14);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		textview2 = findViewById(R.id.textview2);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		textview3 = findViewById(R.id.textview3);
		linear12 = findViewById(R.id.linear12);
		linear13 = findViewById(R.id.linear13);
		textview4 = findViewById(R.id.textview4);
		linear15 = findViewById(R.id.linear15);
		imageview3 = findViewById(R.id.imageview3);
		textview5 = findViewById(R.id.textview5);
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				imageview2.startAnimation(fade_in);
				finish();
			}
		});
		
		linear5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://discord.gg/fkVXxPY27B"));
				startActivity(intent);
			}
		});
		
		linear8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://t.me/spotifinity"));
				startActivity(intent);
			}
		});
		
		linear11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://chat.whatsapp.com/DvJIznEqk0kGMf8vrjm8Dv"));
				startActivity(intent);
			}
		});
		
		linear14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://www.tiktok.com/@spotifinityapp"));
				startActivity(intent);
			}
		});
	}
	
	private void initializeLogic() {
		
		DisplayMetrics linear5Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear5Screen);
		double linear5DP = 10;
		double linear5LogicalDensity = linear5Screen.density;
		int linear5PX = (int) Math.ceil(linear5DP * linear5LogicalDensity);
		android.graphics.drawable.GradientDrawable linear5GG = new android.graphics.drawable.GradientDrawable();
		linear5GG.setColor(Color.parseColor("#212121"));
		linear5GG.setCornerRadius((float)linear5PX);
		linear5GG.setStroke((int) 0,
		Color.parseColor("#000000"));
		android.graphics.drawable.RippleDrawable linear5RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#2196F3")}), linear5GG, null);
		linear5.setBackground(linear5RE);
		linear5.setElevation(0);
		linear5.setTranslationZ(0);
		
		DisplayMetrics linear8Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear8Screen);
		double linear8DP = 10;
		double linear8LogicalDensity = linear8Screen.density;
		int linear8PX = (int) Math.ceil(linear8DP * linear8LogicalDensity);
		android.graphics.drawable.GradientDrawable linear8GG = new android.graphics.drawable.GradientDrawable();
		linear8GG.setColor(Color.parseColor("#212121"));
		linear8GG.setCornerRadius((float)linear8PX);
		linear8GG.setStroke((int) 0,
		Color.parseColor("#000000"));
		android.graphics.drawable.RippleDrawable linear8RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#2196F3")}), linear8GG, null);
		linear8.setBackground(linear8RE);
		linear8.setElevation(0);
		linear8.setTranslationZ(0);
		
		DisplayMetrics linear11Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear11Screen);
		double linear11DP = 10;
		double linear11LogicalDensity = linear11Screen.density;
		int linear11PX = (int) Math.ceil(linear11DP * linear11LogicalDensity);
		android.graphics.drawable.GradientDrawable linear11GG = new android.graphics.drawable.GradientDrawable();
		linear11GG.setColor(Color.parseColor("#212121"));
		linear11GG.setCornerRadius((float)linear11PX);
		linear11GG.setStroke((int) 0,
		Color.parseColor("#000000"));
		android.graphics.drawable.RippleDrawable linear11RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#2196F3")}), linear11GG, null);
		linear11.setBackground(linear11RE);
		linear11.setElevation(0);
		linear11.setTranslationZ(0);
		
		DisplayMetrics linear14Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear14Screen);
		double linear14DP = 10;
		double linear14LogicalDensity = linear14Screen.density;
		int linear14PX = (int) Math.ceil(linear14DP * linear14LogicalDensity);
		android.graphics.drawable.GradientDrawable linear14GG = new android.graphics.drawable.GradientDrawable();
		linear14GG.setColor(Color.parseColor("#212121"));
		linear14GG.setCornerRadius((float)linear14PX);
		linear14GG.setStroke((int) 0,
		Color.parseColor("#000000"));
		android.graphics.drawable.RippleDrawable linear14RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#2196F3")}), linear14GG, null);
		linear14.setBackground(linear14RE);
		linear14.setElevation(0);
		linear14.setTranslationZ(0);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		
	}
}