package jk.spotifinity;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Context;
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
	
	private ArrayList<HashMap<String, Object>> lista = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear3;
	private LinearLayout linear5;
	private LinearLayout linear8;
	private ImageView imageview2;
	private TextView textview1;
	private LinearLayout linear6;
	private LinearLayout linear9;
	private TextView textview10;
	private TextView textview8;
	private TextView textview3;
	private ProgressBar progressbar2;
	private MaterialButton materialbutton1;
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
		textview10 = findViewById(R.id.textview10);
		textview8 = findViewById(R.id.textview8);
		textview3 = findViewById(R.id.textview3);
		progressbar2 = findViewById(R.id.progressbar2);
		materialbutton1 = findViewById(R.id.materialbutton1);
		linear7 = findViewById(R.id.linear7);
		textview6 = findViewById(R.id.textview6);
		textview7 = findViewById(R.id.textview7);
		textview2 = findViewById(R.id.textview2);
		textview4 = findViewById(R.id.textview4);
		finish = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.deleteFile("storage/emulated/0/Android/data/jk.spotifinity/mod.apk");
				finish();
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				materialbutton1.startAnimation(fade_in);
				
			}
		});
	}
	
	private void initializeLogic() {
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		textview6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		textview8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		textview10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		materialbutton1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		linear5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFF424242));
	}
	
	@Override
	public void onStart() {
		super.onStart();
		FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/skipLoad", "");
		textview4.setText(getIntent().getStringExtra("link"));
		textview7.setText(getIntent().getStringExtra("novità"));
		textview8.setText("Versione: ".concat(getIntent().getStringExtra("ver")));
		Version = getIntent().getStringExtra("ver");
		if (!FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/modSviluppatore")) {
			linear7.setVisibility(View.GONE);
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
	
}