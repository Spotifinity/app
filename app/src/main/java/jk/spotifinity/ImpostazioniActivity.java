package jk.spotifinity;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
	private String wt = "";
	private String wm = "";
	private String wok = "";
	private String wc = "";
	
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
	private LinearLayout linear16;
	private LinearLayout linear30;
	private TextView textview33;
	private LinearLayout linear39;
	private TextView textview36;
	private LinearLayout linear41;
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
	private LinearLayout linear17;
	private TextView textview17;
	private TextView textview18;
	private LinearLayout linear18;
	private LinearLayout linear31;
	private TextView textview29;
	private MaterialButton materialbutton5;
	private TextView textview30;
	private LinearLayout linear32;
	private TextView textview35;
	private TextView textview34;
	private LinearLayout linear42;
	private TextView textview37;
	private TextView textview38;
	private LinearLayout linear43;
	private TextView textview39;
	
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
	private SharedPreferences impostazioni;
	private SharedPreferences account;
	private SharedPreferences updater;
	private RequestNetwork mod;
	private RequestNetwork.RequestListener _mod_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.impostazioni);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
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
		linear16 = findViewById(R.id.linear16);
		linear30 = findViewById(R.id.linear30);
		textview33 = findViewById(R.id.textview33);
		linear39 = findViewById(R.id.linear39);
		textview36 = findViewById(R.id.textview36);
		linear41 = findViewById(R.id.linear41);
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
		linear17 = findViewById(R.id.linear17);
		textview17 = findViewById(R.id.textview17);
		textview18 = findViewById(R.id.textview18);
		linear18 = findViewById(R.id.linear18);
		linear31 = findViewById(R.id.linear31);
		textview29 = findViewById(R.id.textview29);
		materialbutton5 = findViewById(R.id.materialbutton5);
		textview30 = findViewById(R.id.textview30);
		linear32 = findViewById(R.id.linear32);
		textview35 = findViewById(R.id.textview35);
		textview34 = findViewById(R.id.textview34);
		linear42 = findViewById(R.id.linear42);
		textview37 = findViewById(R.id.textview37);
		textview38 = findViewById(R.id.textview38);
		linear43 = findViewById(R.id.linear43);
		textview39 = findViewById(R.id.textview39);
		warning = new AlertDialog.Builder(this);
		disconnessione = new AlertDialog.Builder(this);
		auth = FirebaseAuth.getInstance();
		Lingua = getSharedPreferences("lingua", Activity.MODE_PRIVATE);
		impostazioni = getSharedPreferences("impostazioni", Activity.MODE_PRIVATE);
		account = getSharedPreferences("account", Activity.MODE_PRIVATE);
		updater = getSharedPreferences("updater", Activity.MODE_PRIVATE);
		mod = new RequestNetwork(this);
		
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
					warning.setPositiveButton("salva", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							progressbar1.setVisibility(View.VISIBLE);
							impostazioni.edit().putString("percorso", edittext1.getText().toString()).commit();
							account.edit().putString("username", edittext3.getText().toString()).commit();
							progressbar1.setVisibility(View.INVISIBLE);
							materialbutton1.setVisibility(View.INVISIBLE);
							Percorso = edittext1.getText().toString();
							Username = edittext3.getText().toString();
							finish();
						}
					});
					warning.setNegativeButton("ignora", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							finish();
						}
					});
					{
						DisplayMetrics screen = new DisplayMetrics();
						getWindowManager().getDefaultDisplay().getMetrics(screen);
						double dp = 10;
						double logicalDensity = screen.density;
						int px = (int) Math.ceil(dp * logicalDensity);
						Toast ImpostazioniActivityToast = Toast.makeText(ImpostazioniActivity.this, "warning", 2000);
						View ImpostazioniActivityView = ImpostazioniActivityToast.getView();
						ImpostazioniActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
						
						
						TextView ImpostazioniActivityText = ImpostazioniActivityView.findViewById(android.R.id.message);
						ImpostazioniActivityText.setTextColor(Color.parseColor("#ffffff"));
						ImpostazioniActivityText.setShadowLayer(0,0,0,0);
						ImpostazioniActivityToast.show();
					}
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
				impostazioni.edit().putString("percorso", edittext1.getText().toString()).commit();
				account.edit().putString("username", edittext3.getText().toString()).commit();
				Percorso = edittext1.getText().toString();
				Username = edittext3.getText().toString();
				materialbutton1.setVisibility(View.INVISIBLE);
				progressbar1.setVisibility(View.INVISIBLE);
			}
		});
		
		linear16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), SocialActivity.class);
				startActivity(intent);
			}
		});
		
		linear39.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), SuggerimentiActivity.class);
				startActivity(intent);
			}
		});
		
		linear41.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				auth.signInWithEmailAndPassword(textview39.getText().toString(), textview39.getText().toString()).addOnCompleteListener(ImpostazioniActivity.this, _auth_sign_in_listener);
			}
		});
		
		materialbutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				disconnessione.setTitle("Disconnettiti");
				disconnessione.setMessage("Vuoi davvero disconnetterti al tuo account?");
				disconnessione.setPositiveButton("si", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						FirebaseAuth.getInstance().signOut();
						account.edit().remove("email").commit();
						account.edit().remove("password").commit();
						account.edit().remove("username").commit();
						intent.setClass(getApplicationContext(), BenvenutoActivity.class);
						startActivity(intent);
					}
				});
				disconnessione.setNegativeButton("no", new DialogInterface.OnClickListener() {
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
		
		switch2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					impostazioni.edit().putString("modSviluppatore", "true").commit();
				}
				else {
					impostazioni.edit().remove("modSviluppatore").commit();
				}
			}
		});
		
		edittext1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
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
		
		edittext3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		edittext3.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				textview28.setText(String.valueOf((long)(_charSeq.length())).concat("/16"));
				if (!edittext3.getText().toString().equals(account.getString("username", ""))) {
					materialbutton1.setVisibility(View.VISIBLE);
				}
				if (_charSeq.contains(" @".replace(" ", ""))) {
					textview31.setVisibility(View.VISIBLE);
				}
				else {
					textview31.setVisibility(View.INVISIBLE);
				}
				if (_charSeq.length() == 16) {
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
		
		materialbutton5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				updater.edit().remove("skip").commit();
				linear30.setVisibility(View.GONE);
			}
		});
		
		_mod_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				if (!_response.contains(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
					textview36.setVisibility(View.GONE);
					linear41.setVisibility(View.GONE);
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
		
		{
			materialbutton5.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2196F3")));
			materialbutton5.setRippleColor(ColorStateList.valueOf(Color.parseColor("#BBDEFB")));
			materialbutton5.setLetterSpacing(0);
			DisplayMetrics screen = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(screen);
			float logicalDensity = screen.density;
			int px = (int) Math.ceil(10 * logicalDensity);
			
			materialbutton5.setCornerRadius(px);
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
		android.graphics.drawable.GradientDrawable linear16GG = new android.graphics.drawable.GradientDrawable();
		linear16GG.setColor(Color.parseColor("#212121"));
		linear16GG.setCornerRadius((float)linear16PX);
		linear16GG.setStroke((int) 0,
		Color.parseColor("#000000"));
		android.graphics.drawable.RippleDrawable linear16RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#2196F3")}), linear16GG, null);
		linear16.setBackground(linear16RE);
		linear16.setElevation(0);
		linear16.setTranslationZ(0);
		
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
		
		DisplayMetrics linear39Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear39Screen);
		double linear39DP = 10;
		double linear39LogicalDensity = linear39Screen.density;
		int linear39PX = (int) Math.ceil(linear39DP * linear39LogicalDensity);
		android.graphics.drawable.GradientDrawable linear39GG = new android.graphics.drawable.GradientDrawable();
		linear39GG.setColor(Color.parseColor("#212121"));
		linear39GG.setCornerRadius((float)linear39PX);
		linear39GG.setStroke((int) 0,
		Color.parseColor("#000000"));
		android.graphics.drawable.RippleDrawable linear39RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#2196F3")}), linear39GG, null);
		linear39.setBackground(linear39RE);
		linear39.setElevation(0);
		linear39.setTranslationZ(0);
		
		DisplayMetrics linear41Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear41Screen);
		double linear41DP = 10;
		double linear41LogicalDensity = linear41Screen.density;
		int linear41PX = (int) Math.ceil(linear41DP * linear41LogicalDensity);
		android.graphics.drawable.GradientDrawable linear41GG = new android.graphics.drawable.GradientDrawable();
		linear41GG.setColor(Color.parseColor("#212121"));
		linear41GG.setCornerRadius((float)linear41PX);
		linear41GG.setStroke((int) 0,
		Color.parseColor("#000000"));
		android.graphics.drawable.RippleDrawable linear41RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#2196F3")}), linear41GG, null);
		linear41.setBackground(linear41RE);
		linear41.setElevation(0);
		linear41.setTranslationZ(0);
		edittext3.setFilters(new InputFilter[]{new InputFilter.LengthFilter((int) 16)});
	}
	
	@Override
	public void onStart() {
		super.onStart();
		mod.startRequestNetwork(RequestNetworkController.GET, "https://pastefy.app/HwUawOyY/raw", "", _mod_request_listener);
		if (impostazioni.contains("modSviluppatore")) {
			switch2.setChecked(true);
		}
		else {
			switch2.setChecked(false);
			textview33.setVisibility(View.GONE);
			linear39.setVisibility(View.GONE);
		}
		edittext1.setText(impostazioni.getString("percorso", ""));
		edittext3.setText(account.getString("username", ""));
		progressbar1.setVisibility(View.INVISIBLE);
		materialbutton1.setVisibility(View.INVISIBLE);
		Percorso = impostazioni.getString("percorso", "");
		Username = account.getString("username", "");
		if (edittext1.getText().toString().equals("")) {
			impostazioni.edit().putString("percorso", "storage/emulated/0/Download").commit();
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
		if (!updater.contains("skip")) {
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
			warning.setPositiveButton("salva", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					progressbar1.setVisibility(View.VISIBLE);
					impostazioni.edit().putString("percorso", edittext1.getText().toString()).commit();
					account.edit().putString("username", edittext3.getText().toString()).commit();
					progressbar1.setVisibility(View.INVISIBLE);
					materialbutton1.setVisibility(View.INVISIBLE);
					Percorso = edittext1.getText().toString();
					finish();
				}
			});
			warning.setNegativeButton("ignora", new DialogInterface.OnClickListener() {
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
	public void _gsydy(final String _ciso, final String _us, final String _js, final String _jsus, final String _hss, final String _sis) {
		
	}
	
}