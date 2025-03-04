package com.spotifinity;

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
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class AccediActivity extends AppCompatActivity {
	
	private boolean passwordVisibile = false;
	
	private LinearLayout linear2;
	private ScrollView vscroll1;
	private ImageView imageview2;
	private TextView textview1;
	private LinearLayout linear3;
	private TextView textview2;
	private LinearLayout linear10;
	private LinearLayout linear6;
	private MaterialButton materialbutton1;
	private MaterialButton materialbutton3;
	private TextView textview3;
	private MaterialButton materialbutton2;
	private TextView textview4;
	private TextView textview6;
	private EditText edittext1;
	private LinearLayout linear8;
	private EditText edittext4;
	private ImageView imageview3;
	private ImageView imageview4;
	
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
	
	private ProgressDialog progressDialog;
	private AlertDialog.Builder dialog;
	private Intent intent = new Intent();
	private SharedPreferences account;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.accedi);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear2 = findViewById(R.id.linear2);
		vscroll1 = findViewById(R.id.vscroll1);
		imageview2 = findViewById(R.id.imageview2);
		textview1 = findViewById(R.id.textview1);
		linear3 = findViewById(R.id.linear3);
		textview2 = findViewById(R.id.textview2);
		linear10 = findViewById(R.id.linear10);
		linear6 = findViewById(R.id.linear6);
		materialbutton1 = findViewById(R.id.materialbutton1);
		materialbutton3 = findViewById(R.id.materialbutton3);
		textview3 = findViewById(R.id.textview3);
		materialbutton2 = findViewById(R.id.materialbutton2);
		textview4 = findViewById(R.id.textview4);
		textview6 = findViewById(R.id.textview6);
		edittext1 = findViewById(R.id.edittext1);
		linear8 = findViewById(R.id.linear8);
		edittext4 = findViewById(R.id.edittext4);
		imageview3 = findViewById(R.id.imageview3);
		imageview4 = findViewById(R.id.imageview4);
		auth = FirebaseAuth.getInstance();
		dialog = new AlertDialog.Builder(this);
		account = getSharedPreferences("account", Activity.MODE_PRIVATE);
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!(edittext1.getText().toString().equals("") || edittext4.getText().toString().equals(""))) {
					auth.signInWithEmailAndPassword(edittext1.getText().toString(), edittext4.getText().toString()).addOnCompleteListener(AccediActivity.this, _auth_sign_in_listener);
					progressDialog = new ProgressDialog(AccediActivity.this);
					progressDialog.setTitle("Accedi");
					progressDialog.setMessage("Accesso in corso...");
					progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
					progressDialog.setCanceledOnTouchOutside(false);
					progressDialog.show();
				} else {
					dialog.setTitle("Campi mancanti");
					dialog.setMessage("Completa tutti i campi per continuare");
					dialog.setIcon(R.drawable.icon_cancel_round);
					dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialog.create().show();
				}
			}
		});
		
		materialbutton3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!edittext1.getText().toString().equals("")) {
					dialog.setTitle("Password dimenticata");
					dialog.setMessage("Verrà inviato una email di reimpostazione della password a ".concat(edittext1.getText().toString().concat(". Una volta ricevuto potrai modificare la password per il tuo account.")));
					dialog.setPositiveButton("Invia", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							progressDialog = new ProgressDialog(AccediActivity.this);
							progressDialog.setTitle("Password dimenticata");
							progressDialog.setMessage("Invio della email di reimpostazione password...");
							progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
							progressDialog.setCanceledOnTouchOutside(false);
							progressDialog.show();
							auth.sendPasswordResetEmail(edittext1.getText().toString()).addOnCompleteListener(_auth_reset_password_listener);
						}
					});
					dialog.create().show();
				} else {
					dialog.setTitle("Campi mancanti");
					dialog.setMessage("Inserisci una email per inviare una email di reimpostazione della password");
					dialog.setIcon(R.drawable.icon_cancel_round);
					dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialog.create().show();
				}
			}
		});
		
		materialbutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!(edittext1.getText().toString().equals("") || edittext4.getText().toString().equals(""))) {
					if ((edittext4.getText().toString().length() > 6) && (edittext4.getText().toString().length() < 32)) {
						auth.createUserWithEmailAndPassword(edittext1.getText().toString(), edittext4.getText().toString()).addOnCompleteListener(AccediActivity.this, _auth_create_user_listener);
						progressDialog = new ProgressDialog(AccediActivity.this);
						progressDialog.setTitle("Registrazione");
						progressDialog.setMessage("Creazione del tuo account in corso...");
						progressDialog.setCanceledOnTouchOutside(false);
						progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
						progressDialog.show();
					} else {
						dialog.setTitle("Lunghezza password non valida");
						dialog.setMessage("La password che hai inserito è troppo corta/lunga. La lunghezza deve essere minimo 6 caratteri e massimo 32 caratteri.");
						dialog.setIcon(R.drawable.icon_cancel_round);
						dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						dialog.create().show();
					}
				} else {
					dialog.setTitle("Campi mancanti");
					dialog.setMessage("Completa tutti i campi per continuare");
					dialog.setIcon(R.drawable.icon_cancel_round);
					dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialog.create().show();
				}
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext4.setText("");
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (passwordVisibile) {
					edittext4.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
					imageview4.setImageResource(R.drawable.icon_visibility_round);
					passwordVisibile = false;
				} else {
					edittext4.setTransformationMethod(android.text.method.HideReturnsTransformationMethod.getInstance());
					imageview4.setImageResource(R.drawable.icon_visibility_off_round);
					passwordVisibile = true;
				}
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
				progressDialog.dismiss();
				if (_success) {
					materialbutton2.setEnabled(false);
					FirebaseAuth auth = FirebaseAuth.getInstance();
					com.google.firebase.auth.FirebaseUser user = auth.getCurrentUser();
					
					user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() { @Override
						public void onComplete(@NonNull Task<Void> task) { if (task.isSuccessful()) {
								dialog.setTitle("Registazione");
								dialog.setMessage("Creazione dell'account completata. Per continuare, verifica la tua email cliccando sul link che abbiamo inviato a ".concat(edittext1.getText().toString().concat(".\nControlla anche la tua cartella di spam, oppure puoi reinviare una nuova email provando ad accedere.")));
								dialog.setIcon(R.drawable.icon_check_circle_round);
								dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										FirebaseAuth.getInstance().signOut();
									}
								});
								dialog.create().show();
							} else {
								dialog.setTitle("Registazione");
								dialog.setMessage("L'account è stato creato ma non è stato possibile inviare una email a ".concat(edittext1.getText().toString().concat(" per la verifica. Riprova accedendo al nuovo account e premendo il tasto \"Reinvia\".")));
								dialog.setIcon(R.drawable.icon_cancel_round);
								dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										FirebaseAuth.getInstance().signOut();
									}
								});
								dialog.create().show();
							}
						}});
				} else {
					dialog.setTitle("Registazione");
					dialog.setMessage("Qualcosa è andato storto e non è stato possibile creare un nuovo account. ".concat(_errorMessage));
					dialog.setIcon(R.drawable.icon_cancel_round);
					dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialog.create().show();
				}
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					progressDialog.dismiss();
					FirebaseAuth auth = FirebaseAuth.getInstance();
					com.google.firebase.auth.FirebaseUser user = auth.getCurrentUser();
					
					if (user.isEmailVerified()) {
						account.edit().putString("email", edittext1.getText().toString()).commit();
						account.edit().putString("password", edittext4.getText().toString()).commit();
						intent.setClass(getApplicationContext(), HomeActivity.class);
						startActivity(intent);
					} else {
						dialog.setTitle("Verifica email");
						dialog.setMessage("Verifica la tua email per continuare.");
						dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						dialog.setNegativeButton("Reinvia", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								FirebaseAuth auth = FirebaseAuth.getInstance();
								com.google.firebase.auth.FirebaseUser user = auth.getCurrentUser();
								
								user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() { @Override
									public void onComplete(@NonNull Task<Void> task) { if (task.isSuccessful()) {
											SketchwareUtil.showMessage(getApplicationContext(), "Email reinviato!");
										} else {
											SketchwareUtil.showMessage(getApplicationContext(), "Impossibile reinviare l'email!");
										}
									}});
							}
						});
						dialog.create().show();
					}
				} else {
					progressDialog.dismiss();
					dialog.setTitle("Errore");
					dialog.setMessage(_errorMessage);
					dialog.setIcon(R.drawable.icon_cancel_round);
					dialog.setPositiveButton("", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							edittext1.setText("");
							edittext4.setText("");
						}
					});
					dialog.create().show();
				}
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				progressDialog.dismiss();
				if (_success) {
					materialbutton3.setEnabled(false);
					dialog.setTitle("Password dimenticata");
					dialog.setIcon(R.drawable.icon_check_circle_round);
					dialog.setMessage("L'email di reimpostazione della password è stata inviata con successo! Controlla la tua posta e/o la cartella spam.");
					dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialog.create().show();
				} else {
					dialog.setTitle("Password dimenticata");
					dialog.setIcon(R.drawable.icon_cancel_round);
					dialog.setMessage("Non è stato possibile inviare l'email per reimpostare la password. Per favore, riprova.");
					dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialog.create().show();
				}
			}
		};
	}
	
	private void initializeLogic() {
		dialog = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		passwordVisibile = false;
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}