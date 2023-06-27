package jk.spotifinity;

import android.animation.*;
import android.app.*;
import android.content.*;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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
import java.util.regex.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class ProfiloActivity extends AppCompatActivity {
	
	private LinearLayout linear3;
	private LinearLayout linear4;
	private ImageView imageview2;
	private TextView textview1;
	private LinearLayout linear5;
	private TextView textview3;
	private TextView textview8;
	private LinearLayout linear6;
	private LinearLayout linear8;
	private LinearLayout linear10;
	private TextView textview2;
	private ImageView imageview3;
	private ImageView imageview6;
	private ImageView imageview7;
	private LinearLayout linear7;
	private TextView textview4;
	private ImageView imageview4;
	private TextView textview5;
	private LinearLayout linear9;
	private TextView textview6;
	private ImageView imageview5;
	private TextView textview7;
	private LinearLayout linear11;
	private TextView textview9;
	private ImageView imageview8;
	private TextView textview10;
	
	private RequestNetwork amm;
	private RequestNetwork.RequestListener _amm_request_listener;
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.profilo);
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
		textview3 = findViewById(R.id.textview3);
		textview8 = findViewById(R.id.textview8);
		linear6 = findViewById(R.id.linear6);
		linear8 = findViewById(R.id.linear8);
		linear10 = findViewById(R.id.linear10);
		textview2 = findViewById(R.id.textview2);
		imageview3 = findViewById(R.id.imageview3);
		imageview6 = findViewById(R.id.imageview6);
		imageview7 = findViewById(R.id.imageview7);
		linear7 = findViewById(R.id.linear7);
		textview4 = findViewById(R.id.textview4);
		imageview4 = findViewById(R.id.imageview4);
		textview5 = findViewById(R.id.textview5);
		linear9 = findViewById(R.id.linear9);
		textview6 = findViewById(R.id.textview6);
		imageview5 = findViewById(R.id.imageview5);
		textview7 = findViewById(R.id.textview7);
		linear11 = findViewById(R.id.linear11);
		textview9 = findViewById(R.id.textview9);
		imageview8 = findViewById(R.id.imageview8);
		textview10 = findViewById(R.id.textview10);
		amm = new RequestNetwork(this);
		auth = FirebaseAuth.getInstance();
		
		_amm_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				if (!FirebaseAuth.getInstance().getCurrentUser().getEmail().contains(_response)) {
					
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		
		DisplayMetrics linear6Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear6Screen);
		double linear6DP = 10;
		double linear6LogicalDensity = linear6Screen.density;
		int linear6PX = (int) Math.ceil(linear6DP * linear6LogicalDensity);
		linear6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear6PX, (int)0));
		linear6.setElevation(0);
		linear6.setTranslationZ(0);
		
		DisplayMetrics linear8Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear8Screen);
		double linear8DP = 10;
		double linear8LogicalDensity = linear8Screen.density;
		int linear8PX = (int) Math.ceil(linear8DP * linear8LogicalDensity);
		linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear8PX, (int)0));
		linear8.setElevation(0);
		linear8.setTranslationZ(0);
		
		DisplayMetrics linear10Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear10Screen);
		double linear10DP = 10;
		double linear10LogicalDensity = linear10Screen.density;
		int linear10PX = (int) Math.ceil(linear10DP * linear10LogicalDensity);
		linear10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear10PX, (int)0));
		linear10.setElevation(0);
		linear10.setTranslationZ(0);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		amm.startRequestNetwork(RequestNetworkController.GET, "https://pastefy.app/HwUawOyY/raw", "", _amm_request_listener);
		textview2.setText(getIntent().getStringExtra("username"));
		if (getIntent().getStringExtra("verificato").equals("false")) {
			imageview3.setVisibility(View.GONE);
			linear6.setVisibility(View.GONE);
		}
		if (getIntent().getStringExtra("mod").equals("false")) {
			imageview6.setVisibility(View.GONE);
			linear8.setVisibility(View.GONE);
		}
		if (getIntent().getStringExtra("sug").equals("false")) {
			imageview7.setVisibility(View.GONE);
			linear10.setVisibility(View.GONE);
		}
		if (!(getIntent().getStringExtra("verificato").equals("false") && getIntent().getStringExtra("mod").equals("false"))) {
			textview8.setVisibility(View.GONE);
		}
	}
}