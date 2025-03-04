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
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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

public class TestaccessoActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private String ErroreFile = "";
	private String ErroreFirebase = "";
	private boolean TimerPassato = false;
	private String TimerErrore = "";
	private String rnErrore = "";
	
	private LinearLayout linear3;
	private LinearLayout linear5;
	private LinearLayout linear59;
	private ProgressBar progressbar1;
	private ImageView imageview2;
	private TextView textview1;
	private TextView textview2;
	private MaterialButton materialbutton1;
	private TextView textview3;
	private LinearLayout linear7;
	private LinearLayout linear53;
	private TextView textview45;
	private LinearLayout linear55;
	private LinearLayout linear57;
	private TextView textview4;
	private LinearLayout linear8;
	private TextView textview48;
	private CheckBox afs;
	private TextView textview44;
	private LinearLayout linear54;
	private TextView textview49;
	private CheckBox cf;
	private TextView textview46;
	private LinearLayout linear56;
	private TextView textview50;
	private CheckBox t;
	private TextView textview47;
	private LinearLayout linear58;
	private TextView textview51;
	private CheckBox rn;
	
	private FirebaseAuth test;
	private OnCompleteListener<AuthResult> _test_create_user_listener;
	private OnCompleteListener<AuthResult> _test_sign_in_listener;
	private OnCompleteListener<Void> _test_reset_password_listener;
	private OnCompleteListener<Void> test_updateEmailListener;
	private OnCompleteListener<Void> test_updatePasswordListener;
	private OnCompleteListener<Void> test_emailVerificationSentListener;
	private OnCompleteListener<Void> test_deleteUserListener;
	private OnCompleteListener<Void> test_updateProfileListener;
	private OnCompleteListener<AuthResult> test_phoneAuthListener;
	private OnCompleteListener<AuthResult> test_googleSignInListener;
	
	private TimerTask timertest;
	private RequestNetwork rntest;
	private RequestNetwork.RequestListener _rntest_request_listener;
	private TimerTask controllore;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.testaccesso);
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
		linear5 = findViewById(R.id.linear5);
		linear59 = findViewById(R.id.linear59);
		progressbar1 = findViewById(R.id.progressbar1);
		imageview2 = findViewById(R.id.imageview2);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		materialbutton1 = findViewById(R.id.materialbutton1);
		textview3 = findViewById(R.id.textview3);
		linear7 = findViewById(R.id.linear7);
		linear53 = findViewById(R.id.linear53);
		textview45 = findViewById(R.id.textview45);
		linear55 = findViewById(R.id.linear55);
		linear57 = findViewById(R.id.linear57);
		textview4 = findViewById(R.id.textview4);
		linear8 = findViewById(R.id.linear8);
		textview48 = findViewById(R.id.textview48);
		afs = findViewById(R.id.afs);
		textview44 = findViewById(R.id.textview44);
		linear54 = findViewById(R.id.linear54);
		textview49 = findViewById(R.id.textview49);
		cf = findViewById(R.id.cf);
		textview46 = findViewById(R.id.textview46);
		linear56 = findViewById(R.id.linear56);
		textview50 = findViewById(R.id.textview50);
		t = findViewById(R.id.t);
		textview47 = findViewById(R.id.textview47);
		linear58 = findViewById(R.id.linear58);
		textview51 = findViewById(R.id.textview51);
		rn = findViewById(R.id.rn);
		test = FirebaseAuth.getInstance();
		rntest = new RequestNetwork(this);
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				progressbar1.setVisibility(View.VISIBLE);
				afs.setChecked(false);
				cf.setChecked(false);
				t.setChecked(false);
				rn.setChecked(false);
				textview48.setText("");
				textview49.setText("");
				textview50.setText("");
				textview51.setText("");
				ErroreFile = "";
				ErroreFirebase = "";
				TimerErrore = "";
				rnErrore = "";
				TimerPassato = false;
				FirebaseAuth.getInstance().signOut();
				_testaccesso();
				controllore = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								if (progressbar1.getProgress() == 100) {
									controllore.cancel();
									FileUtil.deleteFile("storage/emulated/0/Android/data/jk.spotifinity/TestAccesso");
									textview48.setText(ErroreFile);
									textview49.setText(ErroreFirebase);
									textview50.setText(TimerErrore);
									textview51.setText(rnErrore);
									
									{
										DisplayMetrics screen = new DisplayMetrics();
										getWindowManager().getDefaultDisplay().getMetrics(screen);
										double dp = 10;
										double logicalDensity = screen.density;
										int px = (int) Math.ceil(dp * logicalDensity);
										Toast TestaccessoActivityToast = Toast.makeText(TestaccessoActivity.this, "Test di accesso completato", 2000);
										View TestaccessoActivityView = TestaccessoActivityToast.getView();
										TestaccessoActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
										
										
										TextView TestaccessoActivityText = TestaccessoActivityView.findViewById(android.R.id.message);
										TestaccessoActivityText.setTextColor(Color.parseColor("#ffffff"));
										TestaccessoActivityText.setShadowLayer(0,0,0,0);
										TestaccessoActivityToast.show();
									}
								}
							}
						});
					}
				};
				_timer.scheduleAtFixedRate(controllore, (int)(1000), (int)(250));
			}
		});
		
		afs.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (afs.isChecked()) {
					afs.setChecked(false);
				}
				else {
					afs.setChecked(true);
				}
			}
		});
		
		afs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				
			}
		});
		
		cf.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (cf.isChecked()) {
					cf.setChecked(false);
				}
				else {
					cf.setChecked(true);
				}
			}
		});
		
		cf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				
			}
		});
		
		t.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (t.isChecked()) {
					t.setChecked(false);
				}
				else {
					t.setChecked(true);
				}
			}
		});
		
		t.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				
			}
		});
		
		rn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (rn.isChecked()) {
					rn.setChecked(false);
				}
				else {
					rn.setChecked(true);
				}
			}
		});
		
		rn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				
			}
		});
		
		_rntest_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				if (_response.equals("Funziona!")) {
					rn.setChecked(true);
				}
				else {
					rnErrore = "Impossibile leggere la richiesta";
				}
				progressbar1.setProgress((int)100);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				rnErrore = "Impossibile inviare una richiesta";
				progressbar1.setProgress((int)100);
			}
		};
		
		test_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		test_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		test_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		test_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		test_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		test_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		test_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_test_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_test_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					cf.setChecked(true);
				}
				else {
					ErroreFirebase = "Impossibile accedere";
				}
			}
		};
		
		_test_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
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
		
		DisplayMetrics linear53Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear53Screen);
		double linear53DP = 10;
		double linear53LogicalDensity = linear53Screen.density;
		int linear53PX = (int) Math.ceil(linear53DP * linear53LogicalDensity);
		linear53.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear53PX, (int)0));
		linear53.setElevation(0);
		linear53.setTranslationZ(0);
		
		DisplayMetrics linear55Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear55Screen);
		double linear55DP = 10;
		double linear55LogicalDensity = linear55Screen.density;
		int linear55PX = (int) Math.ceil(linear55DP * linear55LogicalDensity);
		linear55.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear55PX, (int)0));
		linear55.setElevation(0);
		linear55.setTranslationZ(0);
		
		DisplayMetrics linear57Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear57Screen);
		double linear57DP = 10;
		double linear57LogicalDensity = linear57Screen.density;
		int linear57PX = (int) Math.ceil(linear57DP * linear57LogicalDensity);
		linear57.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear57PX, (int)0));
		linear57.setElevation(0);
		linear57.setTranslationZ(0);
		progressbar1.setVisibility(View.INVISIBLE);
	}
	
	public void _testaccesso() {
		progressbar1.setIndeterminate(false);
		progressbar1.setMax((int)100);
		progressbar1.setProgress((int)0);
		FileUtil.makeDir("storage/emulated/0/Android/data/jk.spotifinity/TestAccesso");
		FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/TestAccesso/file", "Funziona!");
		if (FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/TestAccesso")) {
			if (FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/TestAccesso/file")) {
				if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/TestAccesso/file").equals("Funziona!")) {
					afs.setChecked(true);
				}
				else {
					ErroreFile = "Impossibile leggere i file";
				}
			}
			else {
				ErroreFile = "Impossibile trovare i file";
			}
		}
		else {
			ErroreFile = "Impossibile trovare le cartelle";
		}
		progressbar1.setProgress((int)25);
		test.signInWithEmailAndPassword("testaccesso@gmail.com", "testaccesso").addOnCompleteListener(TestaccessoActivity.this, _test_sign_in_listener);
		progressbar1.setProgress((int)50);
		timertest = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						TimerPassato = true;
						t.setChecked(true);
					}
				});
			}
		};
		_timer.schedule(timertest, (int)(50));
		timertest = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (!TimerPassato) {
							TimerErrore = "Impossibile usare il timer";
						}
					}
				});
			}
		};
		_timer.schedule(timertest, (int)(125));
		progressbar1.setProgress((int)75);
		rntest.startRequestNetwork(RequestNetworkController.GET, "https://pastefy.app/gSghzLf0/raw", "", _rntest_request_listener);
	}
	
}