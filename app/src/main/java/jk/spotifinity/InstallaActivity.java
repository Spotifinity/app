package jk.spotifinity;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
	private double Commenti = 0;
	private double Conta = 0;
	private double Clicks = 0;
	
	private ArrayList<HashMap<String, Object>> lista = new ArrayList<>();
	
	private LinearLayout linear3;
	private LinearLayout linear60;
	private LinearLayout linear1;
	private BottomNavigationView bottomnavigation2;
	private LinearLayout linear59;
	private ImageView imageview2;
	private TextView textview1;
	private ProgressBar progressbar1;
	private LinearLayout linear5;
	private LinearLayout linear8;
	private LinearLayout linear13;
	private TextView textview12;
	private LinearLayout linear6;
	private LinearLayout linear9;
	private LinearLayout linear12;
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
	private TextView textview11;
	private LinearLayout linear35;
	private TextView textview32;
	
	private TimerTask check;
	private Intent intent = new Intent();
	private TimerTask wait;
	private Intent launchIntent = new Intent();
	private Vibrator finish;
	private AlertDialog.Builder avviso;
	private Intent commenti = new Intent();
	private RequestNetwork contacommenti;
	private RequestNetwork.RequestListener _contacommenti_request_listener;
	private SharedPreferences impostazioni;
	private SharedPreferences account;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.installa);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
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
		linear60 = findViewById(R.id.linear60);
		linear1 = findViewById(R.id.linear1);
		bottomnavigation2 = findViewById(R.id.bottomnavigation2);
		linear59 = findViewById(R.id.linear59);
		imageview2 = findViewById(R.id.imageview2);
		textview1 = findViewById(R.id.textview1);
		progressbar1 = findViewById(R.id.progressbar1);
		linear5 = findViewById(R.id.linear5);
		linear8 = findViewById(R.id.linear8);
		linear13 = findViewById(R.id.linear13);
		textview12 = findViewById(R.id.textview12);
		linear6 = findViewById(R.id.linear6);
		linear9 = findViewById(R.id.linear9);
		linear12 = findViewById(R.id.linear12);
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
		textview11 = findViewById(R.id.textview11);
		linear35 = findViewById(R.id.linear35);
		textview32 = findViewById(R.id.textview32);
		finish = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		avviso = new AlertDialog.Builder(this);
		contacommenti = new RequestNetwork(this);
		impostazioni = getSharedPreferences("impostazioni", Activity.MODE_PRIVATE);
		account = getSharedPreferences("account", Activity.MODE_PRIVATE);
		
		bottomnavigation2.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(MenuItem item) {
				final int _itemId = item.getItemId();
				if (_itemId == 1) {
					commenti.setClass(getApplicationContext(), CommentiActivity.class);
					commenti.putExtra("ver", getIntent().getStringExtra("ver"));
					commenti.putExtra("commenti", getIntent().getStringExtra("commenti"));
					commenti.putExtra("conta", String.valueOf((long)(Conta)));
					startActivity(commenti);
				}
				else {
					
				}
				return true;
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		materialbutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				progressbar1.setVisibility(View.VISIBLE);
				
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				progressbar1.setVisibility(View.VISIBLE);
				if (!(Clicks == 0)) {
					Clicks--;
					materialbutton1.setText("inizia l'installazione (".concat(String.valueOf((long)(Clicks))).concat("×)"));
					if (Clicks == 0) {
						materialbutton1.setText("Caricamento...");
					}
				}
				
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
		
		linear35.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
				{
					DisplayMetrics screen = new DisplayMetrics();
					getWindowManager().getDefaultDisplay().getMetrics(screen);
					double dp = 10;
					double logicalDensity = screen.density;
					int px = (int) Math.ceil(dp * logicalDensity);
					Toast InstallaActivityToast = Toast.makeText(InstallaActivity.this, "Questa è una funzione beta e potrebbe avere problemi", 2000);
					View InstallaActivityView = InstallaActivityToast.getView();
					InstallaActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#1BA8F0")));
					
					
					TextView InstallaActivityText = InstallaActivityView.findViewById(android.R.id.message);
					InstallaActivityText.setTextColor(Color.parseColor("#ffffff"));
					InstallaActivityText.setShadowLayer(0,0,0,0);
					InstallaActivityToast.show();
				}
			}
		});
		
		_contacommenti_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				textview12.setText(_response.concat(" persone hanno commentato"));
				Conta = Double.parseDouble(_response);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
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
		
		DisplayMetrics linear35Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear35Screen);
		double linear35DP = 10;
		double linear35LogicalDensity = linear35Screen.density;
		int linear35PX = (int) Math.ceil(linear35DP * linear35LogicalDensity);
		linear35.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#2196F3")); return this; } }.getIns((int)linear35PX, (int)0));
		linear35.setElevation(0);
		linear35.setTranslationZ(0);
		
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
		
		DisplayMetrics linear5Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear5Screen);
		double linear5DP = 10;
		double linear5LogicalDensity = linear5Screen.density;
		int linear5PX = (int) Math.ceil(linear5DP * linear5LogicalDensity);
		linear5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear5PX, (int)0));
		linear5.setElevation(0);
		linear5.setTranslationZ(0);
		bottomnavigation2.getMenu().add(0, 1, 0, "Commenti").setIcon(R.drawable.ic_comment_white);
		Clicks = 2;
	}
	
	@Override
	public void onStart() {
		super.onStart();
		progressbar1.setVisibility(View.INVISIBLE);
		textview4.setText(getIntent().getStringExtra("link"));
		textview7.setText(getIntent().getStringExtra("novità"));
		textview8.setText("Versione ".concat(getIntent().getStringExtra("ver")));
		contacommenti.startRequestNetwork(RequestNetworkController.GET, "https://pastefy.app/".concat(getIntent().getStringExtra("commenti").concat("/raw")), "", _contacommenti_request_listener);
		Version = getIntent().getStringExtra("ver");
		if (getIntent().getStringExtra("commenti").equals("")) {
			textview12.setText("Commenti non disponibili per questa versione");
		}
		else {
			textview12.setText(String.valueOf((long)(Commenti)).concat(" persone hanno commentato"));
		}
		if (!impostazioni.contains("modSviluppatore")) {
			linear7.setVisibility(View.GONE);
			materialbutton2.setVisibility(View.GONE);
		}
		if (!impostazioni.contains("percorso") || FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt").equals("")) {
			impostazioni.edit().putString("percorso", "storage/emulated/0/Download").commit();
		}
		if (FileUtil.isExistFile("storage/emulated/0/Android/data/com.spotify.music") && !account.contains("verificato")) {
			avviso.setTitle("Spotify già installato");
			avviso.setMessage("Ho rilevato che hai già installato Spotify sul tuo dispositivo. Per garantire la qualità della mod ti consiglio di disinstallare il Spotify attualmente installato e installare questa mod.");
			avviso.setIcon(R.drawable.ic_report_problem_white);
			avviso.setPositiveButton("disinstalla", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					Uri packageURI = Uri.parse("package:".concat("com.spotify.music")); Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI); startActivity(uninstallIntent);
				}
			});
			avviso.setNegativeButton("ignora", new DialogInterface.OnClickListener() {
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
	public void _extra() {
		
	}
	
}