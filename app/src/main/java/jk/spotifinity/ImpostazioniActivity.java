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
import java.util.regex.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class ImpostazioniActivity extends AppCompatActivity {
	
	private String Percorso = "";
	
	private LinearLayout linear3;
	private LinearLayout linear4;
	private ImageView imageview2;
	private TextView textview1;
	private LinearLayout linear7;
	private ProgressBar progressbar1;
	private MaterialButton materialbutton1;
	private LinearLayout linear6;
	private LinearLayout linear13;
	private MaterialButton materialbutton2;
	private Switch switch2;
	private TextView textview3;
	private LinearLayout linear14;
	private TextView textview16;
	private EditText edittext1;
	private TextView textview15;
	private LinearLayout linear15;
	
	private Intent intent = new Intent();
	private AlertDialog.Builder warning;
	private AlertDialog.Builder disconnessione;
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
		setContentView(R.layout.impostazioni);
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
		linear7 = findViewById(R.id.linear7);
		progressbar1 = findViewById(R.id.progressbar1);
		materialbutton1 = findViewById(R.id.materialbutton1);
		linear6 = findViewById(R.id.linear6);
		linear13 = findViewById(R.id.linear13);
		materialbutton2 = findViewById(R.id.materialbutton2);
		switch2 = findViewById(R.id.switch2);
		textview3 = findViewById(R.id.textview3);
		linear14 = findViewById(R.id.linear14);
		textview16 = findViewById(R.id.textview16);
		edittext1 = findViewById(R.id.edittext1);
		textview15 = findViewById(R.id.textview15);
		linear15 = findViewById(R.id.linear15);
		warning = new AlertDialog.Builder(this);
		disconnessione = new AlertDialog.Builder(this);
		auth = FirebaseAuth.getInstance();
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				imageview2.startAnimation(fade_in);
				if (materialbutton1.getVisibility() == View.VISIBLE) {
					warning.setTitle("Non salvato");
					warning.setMessage("Hai modifiche apportate ma non ancora salvate. Vuoi salvare adesso?");
					warning.setPositiveButton("Salva", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							progressbar1.setVisibility(View.VISIBLE);
							FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt", edittext1.getText().toString());
							progressbar1.setVisibility(View.INVISIBLE);
							materialbutton1.setVisibility(View.INVISIBLE);
							Percorso = edittext1.getText().toString();
							SketchwareUtil.showMessage(getApplicationContext(), "Salvato con successo");
							finish();
						}
					});
					warning.setNegativeButton("Ignora", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							finish();
						}
					});
					warning.create().show();
				}
				else {
					finish();
				}
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
				FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt", edittext1.getText().toString());
				Percorso = edittext1.getText().toString();
				materialbutton1.setVisibility(View.INVISIBLE);
				progressbar1.setVisibility(View.INVISIBLE);
				SketchwareUtil.showMessage(getApplicationContext(), "Salvato con successo");
			}
		});
		
		materialbutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				materialbutton2.startAnimation(fade_in);
				disconnessione.setTitle("Disconnettiti");
				disconnessione.setMessage("Vuoi davvero disconnetterti al tuo account?");
				disconnessione.setPositiveButton("Si", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						FirebaseAuth.getInstance().signOut();
						FileUtil.deleteFile("storage/emulated/0/Android/data/jk.spotifinity/Account");
						intent.setClass(getApplicationContext(), BenvenutoActivity.class);
						startActivity(intent);
					}
				});
				disconnessione.setNegativeButton("no", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				disconnessione.create().show();
			}
		});
		
		switch2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				linear6.startAnimation(fade_in);
			}
		});
		
		switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/modSviluppatore", "");
				}
				else {
					FileUtil.deleteFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/modSviluppatore");
				}
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
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (_charSeq.equals(Percorso)) {
					materialbutton1.setVisibility(View.INVISIBLE);
				}
				else {
					materialbutton1.setVisibility(View.VISIBLE);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
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
		warning = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		disconnessione = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		if (!FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni")) {
			FileUtil.makeDir("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni");
		}
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		switch2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		materialbutton1.setVisibility(View.INVISIBLE);
		linear6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFF424242));
		linear13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFF424242));
		textview15.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		textview16.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		edittext1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		materialbutton1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		materialbutton2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/modSviluppatore")) {
			switch2.setChecked(true);
		}
		else {
			switch2.setChecked(false);
		}
		edittext1.setText(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt"));
		progressbar1.setVisibility(View.INVISIBLE);
		materialbutton1.setVisibility(View.INVISIBLE);
		Percorso = FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt");
	}
	
	@Override
	public void onBackPressed() {
		if (materialbutton1.getVisibility() == View.VISIBLE) {
			warning.setTitle("Non salvato");
			warning.setMessage("Hai modifiche apportate ma non ancora salvate. Vuoi salvare adesso?");
			warning.setPositiveButton("Salva", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					progressbar1.setVisibility(View.VISIBLE);
					FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt", edittext1.getText().toString());
					progressbar1.setVisibility(View.INVISIBLE);
					materialbutton1.setVisibility(View.INVISIBLE);
					Percorso = edittext1.getText().toString();
					SketchwareUtil.showMessage(getApplicationContext(), "Salvato con successo");
					finish();
				}
			});
			warning.setNegativeButton("Ignora", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					finish();
				}
			});
			warning.create().show();
		}
		else {
			finish();
		}
	}
}