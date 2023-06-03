package jk.spotifinity;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
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
import android.widget.ScrollView;
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
	private String Username = "";
	private String Lunghezza = "";
	private String Finale = "";
	private boolean Limitato = false;
	private String disct = "";
	private String discm = "";
	private String discok = "";
	private String discc = "";
	
	private LinearLayout linear3;
	private ScrollView vscroll2;
	private ImageView imageview2;
	private TextView textview1;
	private LinearLayout linear7;
	private ProgressBar progressbar1;
	private MaterialButton materialbutton1;
	private LinearLayout linear4;
	private TextView textview26;
	private LinearLayout linear6;
	private LinearLayout linear13;
	private TextView textview27;
	private LinearLayout linear27;
	private LinearLayout linear23;
	private LinearLayout linear16;
	private LinearLayout linear30;
	private TextView textview33;
	private LinearLayout linear39;
	private MaterialButton materialbutton2;
	private Switch switch2;
	private TextView textview3;
	private LinearLayout linear14;
	private TextView textview16;
	private EditText edittext1;
	private TextView textview15;
	private LinearLayout linear15;
	private LinearLayout linear28;
	private TextView textview24;
	private LinearLayout linear33;
	private LinearLayout linear36;
	private TextView textview25;
	private LinearLayout linear29;
	private TextView textview31;
	private TextView textview28;
	private EditText edittext3;
	private LinearLayout linear37;
	private ImageView imageview3;
	private LinearLayout linear24;
	private TextView textview21;
	private MaterialButton materialbutton3;
	private TextView textview22;
	private LinearLayout linear35;
	private LinearLayout linear25;
	private TextView textview32;
	private TextView textview23;
	private LinearLayout linear17;
	private TextView textview17;
	private MaterialButton materialbutton4;
	private TextView textview18;
	private LinearLayout linear18;
	private LinearLayout linear31;
	private TextView textview29;
	private MaterialButton materialbutton5;
	private TextView textview30;
	private LinearLayout linear32;
	private TextView textview35;
	private TextView textview34;
	private MaterialButton materialbutton6;
	
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
	
	private SharedPreferences Lingua;
	
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
		vscroll2 = findViewById(R.id.vscroll2);
		imageview2 = findViewById(R.id.imageview2);
		textview1 = findViewById(R.id.textview1);
		linear7 = findViewById(R.id.linear7);
		progressbar1 = findViewById(R.id.progressbar1);
		materialbutton1 = findViewById(R.id.materialbutton1);
		linear4 = findViewById(R.id.linear4);
		textview26 = findViewById(R.id.textview26);
		linear6 = findViewById(R.id.linear6);
		linear13 = findViewById(R.id.linear13);
		textview27 = findViewById(R.id.textview27);
		linear27 = findViewById(R.id.linear27);
		linear23 = findViewById(R.id.linear23);
		linear16 = findViewById(R.id.linear16);
		linear30 = findViewById(R.id.linear30);
		textview33 = findViewById(R.id.textview33);
		linear39 = findViewById(R.id.linear39);
		materialbutton2 = findViewById(R.id.materialbutton2);
		switch2 = findViewById(R.id.switch2);
		textview3 = findViewById(R.id.textview3);
		linear14 = findViewById(R.id.linear14);
		textview16 = findViewById(R.id.textview16);
		edittext1 = findViewById(R.id.edittext1);
		textview15 = findViewById(R.id.textview15);
		linear15 = findViewById(R.id.linear15);
		linear28 = findViewById(R.id.linear28);
		textview24 = findViewById(R.id.textview24);
		linear33 = findViewById(R.id.linear33);
		linear36 = findViewById(R.id.linear36);
		textview25 = findViewById(R.id.textview25);
		linear29 = findViewById(R.id.linear29);
		textview31 = findViewById(R.id.textview31);
		textview28 = findViewById(R.id.textview28);
		edittext3 = findViewById(R.id.edittext3);
		linear37 = findViewById(R.id.linear37);
		imageview3 = findViewById(R.id.imageview3);
		linear24 = findViewById(R.id.linear24);
		textview21 = findViewById(R.id.textview21);
		materialbutton3 = findViewById(R.id.materialbutton3);
		textview22 = findViewById(R.id.textview22);
		linear35 = findViewById(R.id.linear35);
		linear25 = findViewById(R.id.linear25);
		textview32 = findViewById(R.id.textview32);
		textview23 = findViewById(R.id.textview23);
		linear17 = findViewById(R.id.linear17);
		textview17 = findViewById(R.id.textview17);
		materialbutton4 = findViewById(R.id.materialbutton4);
		textview18 = findViewById(R.id.textview18);
		linear18 = findViewById(R.id.linear18);
		linear31 = findViewById(R.id.linear31);
		textview29 = findViewById(R.id.textview29);
		materialbutton5 = findViewById(R.id.materialbutton5);
		textview30 = findViewById(R.id.textview30);
		linear32 = findViewById(R.id.linear32);
		textview35 = findViewById(R.id.textview35);
		textview34 = findViewById(R.id.textview34);
		materialbutton6 = findViewById(R.id.materialbutton6);
		warning = new AlertDialog.Builder(this);
		disconnessione = new AlertDialog.Builder(this);
		auth = FirebaseAuth.getInstance();
		Lingua = getSharedPreferences("lingua", Activity.MODE_PRIVATE);
		
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
							Username = edittext3.getText().toString();
							finish();
						}
					});
					warning.setNegativeButton("Ignora", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							finish();
						}
					});
					
					{
						final AlertDialog alert = warning.show();
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
				else {
					finish();
				}
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				progressbar1.setVisibility(View.VISIBLE);
				FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt", edittext1.getText().toString());
				FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt", edittext3.getText().toString());
				Percorso = edittext1.getText().toString();
				Username = edittext3.getText().toString();
				materialbutton1.setVisibility(View.INVISIBLE);
				progressbar1.setVisibility(View.INVISIBLE);
			}
		});
		
		linear23.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		linear16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		materialbutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				disconnessione.setTitle(disct);
				disconnessione.setMessage(discm);
				disconnessione.setPositiveButton(discok, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						FirebaseAuth.getInstance().signOut();
						FileUtil.deleteFile("storage/emulated/0/Android/data/jk.spotifinity/Account");
						intent.setClass(getApplicationContext(), BenvenutoActivity.class);
						startActivity(intent);
					}
				});
				disconnessione.setNegativeButton(discc, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				
				{
					final AlertDialog alert = disconnessione.show();
					DisplayMetrics screen = new DisplayMetrics();
					getWindowManager().getDefaultDisplay().getMetrics(screen);
					double dp = 10;
					double logicalDensity = screen.density;
					int px = (int) Math.ceil(dp * logicalDensity);
					alert.getWindow().getDecorView().setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#212121")));
						alert.getWindow().getDecorView().setPadding(8,8,8,8);
					alert.show();
					
					alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#1BA8F0"));
						alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#1BA8F0"));
						alert.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(Color.parseColor("#1BA8F0"));
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
		
		switch2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				switch2.startAnimation(fade_in);
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
		
		edittext3.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (_charSeq.contains(" @".replace(" ", ""))) {
					textview31.setVisibility(View.VISIBLE);
				}
				else {
					textview31.setVisibility(View.INVISIBLE);
				}
				if (_charSeq.length() > 16) {
					edittext3.setText(Finale);
				}
				else {
					Finale = _charSeq;
					textview28.setText(String.valueOf((long)(_charSeq.length())).concat("/16"));
				}
				if (_charSeq.length() > 16) {
					textview28.setTextColor(0xFFF44336);
				}
				else {
					if (_charSeq.length() > 10) {
						textview28.setTextColor(0xFFFFFFFF);
					}
					else {
						textview28.setTextColor(0xFF424242);
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
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext3.setText("");
				Finale = "";
				textview28.setText("0/16");
			}
		});
		
		materialbutton3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), LinguaActivity.class);
				startActivity(intent);
			}
		});
		
		materialbutton4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), SocialActivity.class);
				startActivity(intent);
			}
		});
		
		materialbutton5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.deleteFile("storage/emulated/0/Android/data/jk.spotifinity/skipUpdate");
				
				{
					DisplayMetrics screen = new DisplayMetrics();
					getWindowManager().getDefaultDisplay().getMetrics(screen);
					double dp = 10;
					double logicalDensity = screen.density;
					int px = (int) Math.ceil(dp * logicalDensity);
					Toast ImpostazioniActivityToast = Toast.makeText(ImpostazioniActivity.this, "Aggiornamenti automatici riattivati", 2000);
					View ImpostazioniActivityView = ImpostazioniActivityToast.getView();
					ImpostazioniActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
					
					
					TextView ImpostazioniActivityText = ImpostazioniActivityView.findViewById(android.R.id.message);
					ImpostazioniActivityText.setTextColor(Color.parseColor("#ffffff"));
					ImpostazioniActivityText.setShadowLayer(0,0,0,0);
					ImpostazioniActivityToast.show();
				}
				linear30.setVisibility(View.GONE);
			}
		});
		
		materialbutton6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), SuggerimentiActivity.class);
				startActivity(intent);
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
		
		{
			materialbutton2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2196F3")));
			materialbutton2.setRippleColor(ColorStateList.valueOf(Color.parseColor("#BBDEFB")));
			materialbutton2.setLetterSpacing(0);
			DisplayMetrics screen = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(screen);
			float logicalDensity = screen.density;
			int px = (int) Math.ceil(10 * logicalDensity);
			
			materialbutton2.setCornerRadius(px);
			materialbutton2.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()){
						case MotionEvent.ACTION_DOWN:{
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton2);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues(0.9f);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton2);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues(0.9f);
							scaleY.setDuration(100);
							scaleY.start();
							break;
						}
						case MotionEvent.ACTION_UP:{
							
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton2);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues((float)1);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton2);
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
		
		{
			materialbutton3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2196F3")));
			materialbutton3.setRippleColor(ColorStateList.valueOf(Color.parseColor("#BBDEFB")));
			materialbutton3.setLetterSpacing(0);
			DisplayMetrics screen = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(screen);
			float logicalDensity = screen.density;
			int px = (int) Math.ceil(10 * logicalDensity);
			
			materialbutton3.setCornerRadius(px);
			materialbutton3.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()){
						case MotionEvent.ACTION_DOWN:{
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton3);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues(0.9f);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton3);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues(0.9f);
							scaleY.setDuration(100);
							scaleY.start();
							break;
						}
						case MotionEvent.ACTION_UP:{
							
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton3);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues((float)1);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton3);
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
		
		{
			materialbutton4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2196F3")));
			materialbutton4.setRippleColor(ColorStateList.valueOf(Color.parseColor("#BBDEFB")));
			materialbutton4.setLetterSpacing(0);
			DisplayMetrics screen = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(screen);
			float logicalDensity = screen.density;
			int px = (int) Math.ceil(10 * logicalDensity);
			
			materialbutton4.setCornerRadius(px);
			materialbutton4.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()){
						case MotionEvent.ACTION_DOWN:{
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton4);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues(0.9f);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton4);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues(0.9f);
							scaleY.setDuration(100);
							scaleY.start();
							break;
						}
						case MotionEvent.ACTION_UP:{
							
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton4);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues((float)1);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton4);
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
		
		{
			materialbutton5.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2196F3")));
			materialbutton5.setRippleColor(ColorStateList.valueOf(Color.parseColor("#BBDEFB")));
			materialbutton5.setLetterSpacing(0);
			DisplayMetrics screen = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(screen);
			float logicalDensity = screen.density;
			int px = (int) Math.ceil(10 * logicalDensity);
			
			materialbutton5.setCornerRadius(px);
			materialbutton5.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()){
						case MotionEvent.ACTION_DOWN:{
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton5);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues(0.9f);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton5);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues(0.9f);
							scaleY.setDuration(100);
							scaleY.start();
							break;
						}
						case MotionEvent.ACTION_UP:{
							
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton5);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues((float)1);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton5);
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
		
		{
			materialbutton6.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2196F3")));
			materialbutton6.setRippleColor(ColorStateList.valueOf(Color.parseColor("#BBDEFB")));
			materialbutton6.setLetterSpacing(0);
			DisplayMetrics screen = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(screen);
			float logicalDensity = screen.density;
			int px = (int) Math.ceil(10 * logicalDensity);
			
			materialbutton6.setCornerRadius(px);
			materialbutton6.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()){
						case MotionEvent.ACTION_DOWN:{
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton6);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues(0.9f);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton6);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues(0.9f);
							scaleY.setDuration(100);
							scaleY.start();
							break;
						}
						case MotionEvent.ACTION_UP:{
							
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(materialbutton6);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues((float)1);
							scaleX.setDuration(100);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(materialbutton6);
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
		
		DisplayMetrics linear6Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear6Screen);
		double linear6DP = 10;
		double linear6LogicalDensity = linear6Screen.density;
		int linear6PX = (int) Math.ceil(linear6DP * linear6LogicalDensity);
		linear6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear6PX, (int)0));
		linear6.setElevation(0);
		linear6.setTranslationZ(0);
		
		DisplayMetrics linear13Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear13Screen);
		double linear13DP = 10;
		double linear13LogicalDensity = linear13Screen.density;
		int linear13PX = (int) Math.ceil(linear13DP * linear13LogicalDensity);
		linear13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear13PX, (int)0));
		linear13.setElevation(0);
		linear13.setTranslationZ(0);
		
		DisplayMetrics linear16Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear16Screen);
		double linear16DP = 10;
		double linear16LogicalDensity = linear16Screen.density;
		int linear16PX = (int) Math.ceil(linear16DP * linear16LogicalDensity);
		linear16.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear16PX, (int)0));
		linear16.setElevation(0);
		linear16.setTranslationZ(0);
		
		DisplayMetrics linear23Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear23Screen);
		double linear23DP = 10;
		double linear23LogicalDensity = linear23Screen.density;
		int linear23PX = (int) Math.ceil(linear23DP * linear23LogicalDensity);
		linear23.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear23PX, (int)0));
		linear23.setElevation(0);
		linear23.setTranslationZ(0);
		
		DisplayMetrics linear27Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear27Screen);
		double linear27DP = 10;
		double linear27LogicalDensity = linear27Screen.density;
		int linear27PX = (int) Math.ceil(linear27DP * linear27LogicalDensity);
		linear27.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear27PX, (int)0));
		linear27.setElevation(0);
		linear27.setTranslationZ(0);
		
		DisplayMetrics linear30Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear30Screen);
		double linear30DP = 10;
		double linear30LogicalDensity = linear30Screen.density;
		int linear30PX = (int) Math.ceil(linear30DP * linear30LogicalDensity);
		linear30.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear30PX, (int)0));
		linear30.setElevation(0);
		linear30.setTranslationZ(0);
		
		DisplayMetrics linear35Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear35Screen);
		double linear35DP = 10;
		double linear35LogicalDensity = linear35Screen.density;
		int linear35PX = (int) Math.ceil(linear35DP * linear35LogicalDensity);
		linear35.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#1BA8F0")); return this; } }.getIns((int)linear35PX, (int)0));
		linear35.setElevation(0);
		linear35.setTranslationZ(0);
		
		DisplayMetrics linear39Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear39Screen);
		double linear39DP = 10;
		double linear39LogicalDensity = linear39Screen.density;
		int linear39PX = (int) Math.ceil(linear39DP * linear39LogicalDensity);
		linear39.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear39PX, (int)0));
		linear39.setElevation(0);
		linear39.setTranslationZ(0);
		if (!FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni")) {
			FileUtil.makeDir("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni");
		}
		if (!FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua")) {
			FileUtil.makeDir("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua");
			FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt", "it");
		}
		textview23.setText(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt"));
	}
	
	@Override
	public void onStart() {
		super.onStart();
		_AggiornaLingua();
		if (FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/modSviluppatore")) {
			switch2.setChecked(true);
		}
		else {
			switch2.setChecked(false);
			textview33.setVisibility(View.GONE);
			linear39.setVisibility(View.GONE);
		}
		edittext1.setText(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt"));
		edittext3.setText(FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt"));
		progressbar1.setVisibility(View.INVISIBLE);
		materialbutton1.setVisibility(View.INVISIBLE);
		Percorso = FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt");
		Username = FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/username.txt");
		if (edittext1.getText().toString().equals("")) {
			FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/percorso.txt", "storage/emulated/0/Download");
			
			{
				DisplayMetrics screen = new DisplayMetrics();
				getWindowManager().getDefaultDisplay().getMetrics(screen);
				double dp = 10;
				double logicalDensity = screen.density;
				int px = (int) Math.ceil(dp * logicalDensity);
				Toast ImpostazioniActivityToast = Toast.makeText(ImpostazioniActivity.this, "Rilevato un problema ma ho risolto da solo!", 2000);
				View ImpostazioniActivityView = ImpostazioniActivityToast.getView();
				ImpostazioniActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
				
				
				TextView ImpostazioniActivityText = ImpostazioniActivityView.findViewById(android.R.id.message);
				ImpostazioniActivityText.setTextColor(Color.parseColor("#ffffff"));
				ImpostazioniActivityText.setShadowLayer(0,0,0,0);
				ImpostazioniActivityToast.show();
			}
		}
		textview28.setText(String.valueOf((long)(edittext3.getText().toString().length())).concat("/16"));
		if (edittext3.getText().toString().length() > 10) {
			textview28.setTextColor(0xFFFFFFFF);
		}
		else {
			textview28.setTextColor(0xFF616161);
		}
		if (edittext3.getText().toString().length() == 16) {
			textview28.setTextColor(0xFFF44336);
		}
		if (!FileUtil.isExistFile("storage/emulated/0/Android/data/jk.spotifinity/skipUpdate")) {
			linear30.setVisibility(View.GONE);
		}
		textview31.setVisibility(View.INVISIBLE);
		if (edittext3.getText().toString().contains(" @".replace(" ", ""))) {
			textview31.setVisibility(View.VISIBLE);
		}
		else {
			textview31.setVisibility(View.INVISIBLE);
		}
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
					finish();
				}
			});
			warning.setNegativeButton("Ignora", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					finish();
				}
			});
			
			{
				final AlertDialog alert = warning.show();
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
		else {
			finish();
		}
	}
	public void _AggiornaLingua() {
		if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("it")) {
			textview1.setText("Impostazioni");
			materialbutton1.setText("salva");
			textview26.setText("Mod");
			switch2.setText("Modalità sviluppatore");
			textview3.setText("Mostra quello che sta facendo l'app mentre stai installando la mod e mostra altre info avanzate come il link di installazione");
			textview15.setText("Percorso installazione APK");
			textview16.setText("Scegli dove installare il file APK. Non includere \"/\" alla fine o non funzionerà!");
			edittext1.setHint("Percorso d'installazione");
			textview27.setText("App");
			textview25.setText("Username");
			textview24.setText("Questo username viene mostrato nella home per darti il buongiorno.");
			textview31.setText("Non inserire la tua email!");
			edittext3.setHint("Username");
			textview22.setText("Cambia lingua app");
			textview21.setText("Scegli la lingua mostrata su quest'app");
			materialbutton3.setText("modifica lingua");
			textview18.setText("Social");
			textview17.setText("Scopri dove trovarci e ottenere supporto!");
			materialbutton4.setText("scoprici");
			textview30.setText("Riabilita aggiornamenti");
			textview29.setText("Sembra che hai scelto di disattivare gli aggiornamenti automatici.\nNessun problema, clicca qui sotto se le vuoi riattivare");
			textview23.setText("Italiano");
			materialbutton5.setText("riabilita");
			textview33.setText("Sviluppatore");
			textview35.setText("Suggerimenti");
			textview34.setText("Controlla tutti i suggerimenti saltabili");
			materialbutton6.setText("controlla suggerimenti");
			disct = "Disconnettiti";
			discm = "Vuoi davvero disconnetterti al tuo account?";
			discok = "Si";
			discc = "No";
		}
		else {
			if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("en")) {
				textview1.setText("Settings");
				materialbutton1.setText("save");
				textview26.setText("Mod");
				switch2.setText("Developer Mode");
				textview3.setText("Shows what the app is doing while you're installing the mod and shows other advanced info like the install link");
				textview15.setText("APK installation path");
				textview16.setText("Choose where to install the APK file. Don't include the \"/\" at the end or it won't work!");
				edittext1.setHint("Installation path");
				textview27.setText("App");
				textview25.setText("Username");
				textview24.setText("This username is shown on the home page to say good morning.");
				textview31.setText("Do not enter your email!");
				edittext3.setHint("Username");
				textview22.setText("Change app language");
				textview21.setText("Choose the language displayed on this app");
				materialbutton3.setText("change language");
				textview18.setText("Social");
				textview17.setText("Find out where to find us and get support!");
				materialbutton4.setText("discover us");
				textview30.setText("Re-enable updates");
				textview29.setText("It appears you have chosen to turn off automatic updates.\nNo problem, click below if you want to reactivate them");
				materialbutton5.setText("rehabilitate");
				textview23.setText("English");
				textview33.setText("Developer");
				textview35.setText("Suggestions");
				textview34.setText("Check all the skipable hints");
				materialbutton6.setText("check hints");
				disct = "Log out";
				discm = "Do you really want to log out of your account?";
				discok = "Yes";
				discc = "No";
			}
			else {
				if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("sq")) {
					textview1.setText("Cilësimet");
					materialbutton1.setText("ruai");
					textview26.setText("Mod");
					switch2.setText("Modaliteti i Zhvilluesit");
					textview3.setText("Tregon se çfarë po bën aplikacioni ndërsa jeni duke instaluar modalitetin dhe tregon informacione të tjera të avancuara si lidhjen e instalimit");
					textview15.setText("Rruga e instalimit të APK-së");
					textview16.setText("Zgjidhni ku të instaloni skedarin APK. Mos e përfshini \"/\" në fund ose nuk do të funksionojë!");
					edittext1.setHint("Rruga e instalimit");
					textview27.setText("Aplikacioni");
					textview25.setText("Emri i përdoruesit");
					textview24.setText("Ky emër përdoruesi shfaqet në faqen kryesore për të thënë mirëmëngjes.");
					textview31.setText("Mos shkruani emailin tuaj!");
					edittext3.setHint("emri i përdoruesit");
					textview22.setText("Ndrysho gjuhën e aplikacionit");
					textview21.setText("Zgjidhni gjuhën e shfaqur në këtë aplikacion");
					materialbutton3.setText("ndryshojnë gjuhën");
					textview18.setText("Sociale");
					textview17.setText("Zbuloni se ku të na gjeni dhe merrni mbështetje!");
					materialbutton4.setText("na zbuloni");
					textview30.setText("Ri-aktivizo përditësimet");
					textview29.setText("Duket se keni zgjedhur të çaktivizoni përditësimet automatike.\nNuk ka problem, klikoni më poshtë nëse dëshironi t'i riaktivizoni ato");
					materialbutton5.setText("rehabilitoj");
					materialbutton2.setText("shkyç");
					textview23.setText("Shqip");
					textview33.setText("Zhvilluesi");
					textview35.setText("Sugjerime");
					textview34.setText("Kontrolloni të gjitha sugjerimet që mund të kapërcehen");
					materialbutton6.setText("kontrolloni këshillat");
					disct = "Shkyç";
					discm = "Dëshironi vërtet të dilni nga llogaria juaj?";
					discok = "Po";
					discc = "Jo";
				}
				else {
					if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("ru")) {
						textview1.setText("Настройки");
						materialbutton1.setText("сохранять");
						textview26.setText("Мод");
						switch2.setText("Режим разработчика");
						textview3.setText("Показывает, что делает приложение, пока вы устанавливаете мод, и показывает другую дополнительную информацию, например ссылку для установки.");
						textview15.setText("Путь установки AПК");
						textview16.setText("Выберите, куда установить APK-файл. Не добавляйте «/» в конце, иначе это не сработает!");
						edittext1.setHint("Путь установки");
						textview27.setText("Приложение");
						textview25.setText("Имя пользователя");
						textview24.setText("Это имя пользователя отображается на главной странице, чтобы пожелать доброго утра.");
						textview31.setText("Не вводите свой адрес электронной почты!");
						edittext3.setHint("имя пользователя");
						textview22.setText("Изменить язык приложения");
						textview21.setText("Выберите язык, отображаемый в этом приложении");
						materialbutton3.setText("изменение языка");
						textview18.setText("Социальное");
						textview17.setText("Узнайте, где нас найти и получить поддержку!");
						materialbutton4.setText("откройте для себя нас");
						textview30.setText("Повторно включить обновления");
						textview29.setText("Похоже, вы решили отключить автоматические обновления.\nНет проблем, нажмите ниже, если вы хотите повторно активировать их");
						materialbutton5.setText("реабилитировать");
						materialbutton2.setText("выйти");
						textview23.setText("Русский");
						textview33.setText("Разработчик");
						textview35.setText("Предложения");
						textview34.setText("Проверьте все пропускаемые подсказки");
						materialbutton6.setText("проверить советы");
						disct = "Выйти";
						discm = "Вы действительно хотите выйти из своей учетной записи?";
						discok = "Да";
						discc = "Нет";
					}
					else {
						
					}
				}
			}
		}
	}
	
}