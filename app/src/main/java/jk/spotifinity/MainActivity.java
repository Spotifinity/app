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
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private double info = 0;
	
	private LinearLayout linear3;
	private ImageView imageview1;
	
	private Intent intent = new Intent();
	private AlertDialog.Builder dialog;
	private AlertDialog.Builder dialog2;
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
	
	private AlertDialog.Builder accedi;
	private RequestNetwork updater;
	private RequestNetwork.RequestListener _updater_request_listener;
	private RequestNetwork version;
	private RequestNetwork.RequestListener _version_request_listener;
	private RequestNetwork poll;
	private RequestNetwork.RequestListener _poll_request_listener;
	private RequestNetwork pollNome;
	private RequestNetwork.RequestListener _pollNome_request_listener;
	private RequestNetwork pollLink;
	private RequestNetwork.RequestListener _pollLink_request_listener;
	private Intent configurazione = new Intent();
	private TimerTask starter;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
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
		imageview1 = findViewById(R.id.imageview1);
		dialog = new AlertDialog.Builder(this);
		dialog2 = new AlertDialog.Builder(this);
		auth = FirebaseAuth.getInstance();
		accedi = new AlertDialog.Builder(this);
		updater = new RequestNetwork(this);
		version = new RequestNetwork(this);
		poll = new RequestNetwork(this);
		pollNome = new RequestNetwork(this);
		pollLink = new RequestNetwork(this);
		
		imageview1.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				
				return true;
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		_updater_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				intent.putExtra("updater", _response);
				info++;
				
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_version_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				intent.putExtra("version", _response);
				info++;
				
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_poll_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				intent.putExtra("poll", _response);
				info++;
				
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_pollNome_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				intent.putExtra("pollNome", _response);
				info++;
				
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_pollLink_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				intent.putExtra("pollLink", _response);
				info++;
				
				
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
				if (_success) {
					
					if (!FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity")) {
						FileUtil.makeDir("storage/emulated/0/Android/data/jk.spotifinity");
						FileUtil.makeDir("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni");
					}
					starter = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									if (info == 5) {
										starter.cancel();
										intent.setClass(getApplicationContext(), HomeActivity.class);
										startActivity(intent);
									}
								}
							});
						}
					};
					_timer.scheduleAtFixedRate(starter, (int)(1), (int)(250));
				}
				else {
					
					if (_errorMessage.equals("The user account has been disabled by an administrator.")) {
						intent.putExtra("ban", "0");
						intent.setClass(getApplicationContext(), BannatoActivity.class);
						startActivity(intent);
					}
					if (_errorMessage.equals("There is no user record corresponding to this identifier. The user may have been deleted.")) {
						intent.putExtra("ban", "1");
						intent.setClass(getApplicationContext(), BannatoActivity.class);
						startActivity(intent);
					}
					accedi.setTitle("Errore");
					if (_errorMessage.equals("The user account has been disabled by an administrator.")) {
						accedi.setMessage("Il tuo account Spotifinity e stato sospeso.");
					}
					else {
						if (_errorMessage.equals("There is no user record corresponding to this identifier. The user may have been deleted.")) {
							accedi.setMessage("Il tuo account Spotifinity e stato eliminato e non puoi più creare nuovi account.");
							FileUtil.writeFile("storage/emulated/0/Android/data/.bans/Spotifinity", "");
						}
						else {
							accedi.setMessage(_errorMessage);
						}
					}
					accedi.setPositiveButton("esci", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							FirebaseAuth.getInstance().signOut();
							FileUtil.deleteFile("storage/emulated/0/Android/data/jk.spotifinity/Account");
							FileUtil.deleteFile("storage/emulated/0/Android/data/jk.spotifinity/skipWelcome");
							intent.setClass(getApplicationContext(), BenvenutoActivity.class);
							startActivity(intent);
						}
					});
					accedi.setNegativeButton("supporto", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							intent.setClass(getApplicationContext(), SocialActivity.class);
							startActivity(intent);
						}
					});
					
					{
						final AlertDialog alert = accedi.show();
						DisplayMetrics screen = new DisplayMetrics();
						getWindowManager().getDefaultDisplay().getMetrics(screen);
						double dp = 10;
						double logicalDensity = screen.density;
						int px = (int) Math.ceil(dp * logicalDensity);
						alert.getWindow().getDecorView().setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#242424")));
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
		
		if (FileUtil.isExistFile("storage/emulated/0/Android/data/.bans/Spotifinity")) {
			intent.putExtra("ban", "1");
			intent.setClass(getApplicationContext(), BannatoActivity.class);
			startActivity(intent);
		}
		else {
			updater.startRequestNetwork(RequestNetworkController.GET, "https://pastefy.app/V64UVdii/raw", "", _updater_request_listener);
			version.startRequestNetwork(RequestNetworkController.GET, "https://pastefy.app/3DjQQQZG/raw", "", _version_request_listener);
			poll.startRequestNetwork(RequestNetworkController.GET, "https://pastefy.app/AoC5b38b/raw", "", _poll_request_listener);
			pollNome.startRequestNetwork(RequestNetworkController.GET, "https://pastefy.app/NaUiBndI/raw", "", _pollNome_request_listener);
			pollLink.startRequestNetwork(RequestNetworkController.GET, "https://pastefy.app/45ITHFZO/raw", "", _pollLink_request_listener);
			dialog = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
			dialog2 = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
			accedi = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
			if (!FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity")) {
				FileUtil.makeDir("storage/emulated/0/Android/data/jk.spotifinity");
			}
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (FileUtil.isExistFile("storage/emulated/0/Android/data/.bans/Spotifinity")) {
			intent.putExtra("ban", "1");
			intent.setClass(getApplicationContext(), BannatoActivity.class);
			startActivity(intent);
		}
		else {
			if (FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Account")) {
				FirebaseAuth.getInstance().signOut();
				auth.signInWithEmailAndPassword(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Account/email"), FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Account/password")).addOnCompleteListener(MainActivity.this, _auth_sign_in_listener);
			}
			else {
				intent.setClass(getApplicationContext(), BenvenutoActivity.class);
				startActivity(intent);
			}
		}
	}
	public void _ApriApp(final String _app) {
		Intent launchIntent = getPackageManager().getLaunchIntentForPackage(_app);  { startActivity(launchIntent);}
	}
	
}