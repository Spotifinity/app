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
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Switch;
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
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.regex.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class RegistratiActivity extends AppCompatActivity {
	
	private HashMap<String, Object> headers = new HashMap<>();
	private HashMap<String, Object> body = new HashMap<>();
	
	private LinearLayout linear3;
	private LinearLayout linear4;
	private ImageView imageview2;
	private TextView textview1;
	private TextView textview2;
	private EditText edittext3;
	private EditText edittext1;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private TextView textview3;
	private MaterialButton materialbutton1;
	private ProgressBar progressbar1;
	private EditText edittext2;
	private Switch switch1;
	
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
	
	private Intent intent = new Intent();
	private AlertDialog.Builder accedi;
	private RequestNetwork notifica;
	private RequestNetwork.RequestListener _notifica_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.registrati);
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
		linear4 = findViewById(R.id.linear4);
		imageview2 = findViewById(R.id.imageview2);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		edittext3 = findViewById(R.id.edittext3);
		edittext1 = findViewById(R.id.edittext1);
		linear5 = findViewById(R.id.linear5);
		linear6 = findViewById(R.id.linear6);
		textview3 = findViewById(R.id.textview3);
		materialbutton1 = findViewById(R.id.materialbutton1);
		progressbar1 = findViewById(R.id.progressbar1);
		edittext2 = findViewById(R.id.edittext2);
		switch1 = findViewById(R.id.switch1);
		auth = FirebaseAuth.getInstance();
		accedi = new AlertDialog.Builder(this);
		notifica = new RequestNetwork(this);
		
		edittext3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				edittext3.startAnimation(fade_in);
			}
		});
		
		edittext1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				edittext1.startAnimation(fade_in);
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				materialbutton1.startAnimation(fade_in);
				progressbar1.setVisibility(View.VISIBLE);
				auth.createUserWithEmailAndPassword(edittext1.getText().toString(), edittext2.getText().toString()).addOnCompleteListener(RegistratiActivity.this, _auth_create_user_listener);
			}
		});
		
		edittext2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				edittext2.startAnimation(fade_in);
			}
		});
		
		edittext2.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				textview3.setText(_charSeq);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		switch1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				switch1.startAnimation(fade_in);
			}
		});
		
		switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					textview3.setVisibility(View.VISIBLE);
				}
				else {
					textview3.setVisibility(View.INVISIBLE);
				}
			}
		});
		
		_notifica_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
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
				if (_success) {
					if (!FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity")) {
						FileUtil.makeDir("storage/emulated/0/Android/data/jk.spotifinity");
						FileUtil.makeDir("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni");
						FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/downloaded.txt", "Nessuna");
						FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt", "storage/emulated/0/Download");
					}
					FileUtil.makeDir("storage/emulated/0/Android/data/jk.spotifinity/Account");
					FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Account/email", edittext1.getText().toString());
					FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Account/password", edittext2.getText().toString());
					headers = new HashMap<>();
					body = new HashMap<>();
					headers.put("url", "https://discord.com/api/webhooks/1104802074476150914/IijGyOgRg8hoMKDhHuXvQn_u0vh-vjkvVIhdS7LOtqeJ6z7D4AAPo7YhVmMIL9vSs9II");
					body.put("content", "**".concat(edittext3.getText().toString()).concat("** si e registrato su Spotifinity!"));
					notifica.setHeaders(headers);
					notifica.setParams(body, RequestNetworkController.REQUEST_BODY);
					notifica.startRequestNetwork(RequestNetworkController.POST, "https://discord.com/api/webhooks/1104802074476150914/IijGyOgRg8hoMKDhHuXvQn_u0vh-vjkvVIhdS7LOtqeJ6z7D4AAPo7YhVmMIL9vSs9II", "", _notifica_request_listener);
					intent.setClass(getApplicationContext(), HomeActivity.class);
					startActivity(intent);
				}
				else {
					progressbar1.setVisibility(View.INVISIBLE);
					accedi.setTitle("Errore");
					accedi.setMessage(_errorMessage);
					accedi.setPositiveButton("chiudi", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					accedi.setNegativeButton("supporto", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							intent.setAction(Intent.ACTION_VIEW);
							intent.setData(Uri.parse("https://t.me/spotifinity"));
							startActivity(intent);
						}
					});
					accedi.create().show();
				}
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
		textview3.setVisibility(View.INVISIBLE);
		progressbar1.setVisibility(View.INVISIBLE);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		materialbutton1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		edittext1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		edittext2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		switch1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
	}
	
}