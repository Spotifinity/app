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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
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
	private boolean Limitato = false;
	private String Finale = "";
	
	private LinearLayout linear3;
	private LinearLayout linear4;
	private ImageView imageview2;
	private TextView textview1;
	private LinearLayout linear12;
	private ProgressBar progressbar1;
	private TextView textview2;
	private LinearLayout linear13;
	private LinearLayout linear14;
	private EditText edittext1;
	private EditText edittext2;
	private LinearLayout linear9;
	private LinearLayout linear7;
	private MaterialButton materialbutton1;
	private TextView textview8;
	private TextView textview7;
	private EditText edittext3;
	private LinearLayout linear15;
	private ImageView imageview4;
	private TextView textview5;
	private TextView textview6;
	private LinearLayout linear10;
	private CheckBox checkbox3;
	private TextView textview4;
	private ImageView imageview3;
	private LinearLayout linear8;
	private CheckBox checkbox2;
	
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
	private AlertDialog.Builder info;
	private Intent discord = new Intent();
	
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
		linear12 = findViewById(R.id.linear12);
		progressbar1 = findViewById(R.id.progressbar1);
		textview2 = findViewById(R.id.textview2);
		linear13 = findViewById(R.id.linear13);
		linear14 = findViewById(R.id.linear14);
		edittext1 = findViewById(R.id.edittext1);
		edittext2 = findViewById(R.id.edittext2);
		linear9 = findViewById(R.id.linear9);
		linear7 = findViewById(R.id.linear7);
		materialbutton1 = findViewById(R.id.materialbutton1);
		textview8 = findViewById(R.id.textview8);
		textview7 = findViewById(R.id.textview7);
		edittext3 = findViewById(R.id.edittext3);
		linear15 = findViewById(R.id.linear15);
		imageview4 = findViewById(R.id.imageview4);
		textview5 = findViewById(R.id.textview5);
		textview6 = findViewById(R.id.textview6);
		linear10 = findViewById(R.id.linear10);
		checkbox3 = findViewById(R.id.checkbox3);
		textview4 = findViewById(R.id.textview4);
		imageview3 = findViewById(R.id.imageview3);
		linear8 = findViewById(R.id.linear8);
		checkbox2 = findViewById(R.id.checkbox2);
		auth = FirebaseAuth.getInstance();
		accedi = new AlertDialog.Builder(this);
		notifica = new RequestNetwork(this);
		info = new AlertDialog.Builder(this);
		
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
				edittext1.setHintTextColor(0xFFF44336);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
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
				textview6.setText(_charSeq);
				edittext2.setHintTextColor(0xFFF44336);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext1.getText().toString().equals("")) {
					edittext1.setHintTextColor(0xFFF44336);
				}
				else {
					if (edittext2.getText().toString().equals("")) {
						edittext2.setHintTextColor(0xFFF44336);
					}
					else {
						if (edittext3.getText().toString().equals("")) {
							edittext3.setHintTextColor(0xFFF44336);
						}
						else {
							progressbar1.setVisibility(View.VISIBLE);
							auth.createUserWithEmailAndPassword(edittext1.getText().toString(), edittext2.getText().toString()).addOnCompleteListener(RegistratiActivity.this, _auth_create_user_listener);
						}
					}
				}
			}
		});
		
		edittext3.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				edittext3.setHintTextColor(0xFFF44336);
				if (_charSeq.contains(" @".replace(" ", ""))) {
					textview8.setVisibility(View.VISIBLE);
				}
				else {
					textview8.setVisibility(View.INVISIBLE);
				}
				if (_charSeq.length() > 16) {
					edittext3.setText(Finale);
				}
				else {
					Finale = _charSeq;
					textview7.setText(String.valueOf((long)(_charSeq.length())).concat("/16"));
				}
				if (_charSeq.length() > 16) {
					textview7.setTextColor(0xFFF44336);
				}
				else {
					if (_charSeq.length() > 10) {
						textview7.setTextColor(0xFFFFFFFF);
					}
					else {
						textview7.setTextColor(0xFF424242);
					}
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext3.setText("");
				Finale = "";
				textview7.setText("0/16");
			}
		});
		
		checkbox3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				linear9.startAnimation(fade_in);
			}
		});
		
		checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					textview6.setVisibility(View.VISIBLE);
				}
				else {
					textview6.setVisibility(View.INVISIBLE);
				}
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				imageview3.startAnimation(fade_in);
				info.setTitle("Info sul messaggio di benvenuto");
				info.setMessage("Selezionando questa opzione accetterai di condividere il tuo username (".concat(edittext3.getText().toString().concat(") e di inviarlo come messaggio di benvenuto nel server Discord ufficiale Spotifinity.\nSe non accetterai questo questo username viene usato per darti il benvenuto sull'app.\nQuesto username può essere modificato nelle impostazioni.")));
				info.setIcon(R.drawable.ic_help_white);
				info.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				info.setNeutralButton("partecipa", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						discord.setAction(Intent.ACTION_VIEW);
						discord.setData(Uri.parse("https://discord.gg/fkVXxPY27B"));
						startActivity(discord);
						SketchwareUtil.showMessage(getApplicationContext(), "Grazie per esserti interessato/a per partecipare al server!");
					}
				});
				
				{
					final AlertDialog alert = info.show();
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
		});
		
		checkbox2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				linear7.startAnimation(fade_in);
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
					if (!FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni")) {
						FileUtil.makeDir("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni");
						FileUtil.makeDir("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua");
						FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/downloaded.txt", "Nessuna");
						FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt", "storage/emulated/0/Download");
						FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt", "it");
					}
					FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/downloaded.txt", "Nessuna");
					FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt", "storage/emulated/0/Download");
					FileUtil.makeDir("storage/emulated/0/Android/data/jk.spotifinity/Account");
					FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Account/email", edittext1.getText().toString());
					FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Account/password", edittext2.getText().toString());
					FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt", edittext3.getText().toString());
					if (checkbox2.isChecked()) {
						headers = new HashMap<>();
						body = new HashMap<>();
						headers.put("url", "https://discord.com/api/webhooks/1104802074476150914/IijGyOgRg8hoMKDhHuXvQn_u0vh-vjkvVIhdS7LOtqeJ6z7D4AAPo7YhVmMIL9vSs9II");
						body.put("content", "**".concat(edittext3.getText().toString()).concat("** si e registrato su Spotifinity!"));
						notifica.setHeaders(headers);
						notifica.setParams(body, RequestNetworkController.REQUEST_BODY);
						notifica.startRequestNetwork(RequestNetworkController.POST, "https://discord.com/api/webhooks/1104802074476150914/IijGyOgRg8hoMKDhHuXvQn_u0vh-vjkvVIhdS7LOtqeJ6z7D4AAPo7YhVmMIL9vSs9II", "", _notifica_request_listener);
					}
					headers = new HashMap<>();
					body = new HashMap<>();
					headers.put("url", "https://discord.com/api/webhooks/1108070617103728660/G9EoT--Dz_mo1DDRDqqk7Lk6ULp9gC8cEAQBQ5eRnorBFeC_X4ZXZbKY1dGjN_bXJGZx");
					body.put("content", edittext3.getText().toString().concat(" si e registrato su Spotifinity. La sua mail è ".concat(FirebaseAuth.getInstance().getCurrentUser().getEmail()).concat(" e il suo UID è ".concat(FirebaseAuth.getInstance().getCurrentUser().getUid().concat(".\n----------")))));
					notifica.setHeaders(headers);
					notifica.setParams(body, RequestNetworkController.REQUEST_BODY);
					notifica.startRequestNetwork(RequestNetworkController.POST, "https://discord.com/api/webhooks/1108070617103728660/G9EoT--Dz_mo1DDRDqqk7Lk6ULp9gC8cEAQBQ5eRnorBFeC_X4ZXZbKY1dGjN_bXJGZx", "", _notifica_request_listener);
					intent.setClass(getApplicationContext(), MainActivity.class);
					startActivity(intent);
				}
				else {
					progressbar1.setVisibility(View.INVISIBLE);
					accedi.setTitle("Errore");
					accedi.setIcon(R.drawable.ic_report_problem_white);
					if (_errorMessage.equals("The email address is already in use by another account.")) {
						accedi.setMessage("L'email che hai inserito e già stato associato a un account");
					}
					else {
						accedi.setMessage(_errorMessage);
					}
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
					
					{
						final AlertDialog alert = accedi.show();
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
		
		{
			materialbutton1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2196F3")));
			materialbutton1.setRippleColor(ColorStateList.valueOf(Color.parseColor("#BBDEFB")));
			materialbutton1.setLetterSpacing(0);
			DisplayMetrics screen = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(screen);
			float logicalDensity = screen.density;
			int px = (int) Math.ceil(10 * logicalDensity);
			
			materialbutton1.setCornerRadius(px);
			materialbutton1.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()){
						case MotionEvent.ACTION_DOWN:{
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton1);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues(0.9f);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton1);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues(0.9f);
							scaleY.setDuration(100);
							scaleY.start();
							break;
						}
						case MotionEvent.ACTION_UP:{
							
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton1);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues((float)1);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton1);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues((float)1);
							scaleY.setDuration(100);
							scaleY.start();
							
							break;
						}
					}
					return false;
				}
			});
		}
		
		DisplayMetrics linear9Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear9Screen);
		double linear9DP = 10;
		double linear9LogicalDensity = linear9Screen.density;
		int linear9PX = (int) Math.ceil(linear9DP * linear9LogicalDensity);
		linear9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear9PX, (int)0));
		linear9.setElevation(0);
		linear9.setTranslationZ(0);
		
		DisplayMetrics linear7Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear7Screen);
		double linear7DP = 10;
		double linear7LogicalDensity = linear7Screen.density;
		int linear7PX = (int) Math.ceil(linear7DP * linear7LogicalDensity);
		linear7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear7PX, (int)0));
		linear7.setElevation(0);
		linear7.setTranslationZ(0);
		textview6.setVisibility(View.INVISIBLE);
		progressbar1.setVisibility(View.INVISIBLE);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		Finale = "";
		textview8.setVisibility(View.INVISIBLE);
	}
}