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
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.mannan.translateapi.*;
import com.tonyodev.fetch2.*;
import com.tonyodev.fetch2core.*;
import eightbitlab.com.blurview.*;
import java.io.*;
import java.io.File;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class SelversioneActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private HashMap<String, Object> mod = new HashMap<>();
	private String link = "";
	private HashMap<String, Object> map = new HashMap<>();
	private HashMap<String, Object> aggiunto = new HashMap<>();
	private double Versione = 0;
	private boolean caricamento = false;
	private String at = "";
	private String am = "";
	private String aok = "";
	private String ac = "";
	
	private ArrayList<HashMap<String, Object>> lista = new ArrayList<>();
	private ArrayList<String> Aggiunto = new ArrayList<>();
	
	private LinearLayout linear3;
	private LinearLayout linear6;
	private BottomNavigationView bottomnavigation2;
	private ImageView imageview2;
	private TextView textview1;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private ProgressBar progressbar1;
	private LinearLayout linear36;
	private TextView textview3;
	private LinearLayout linear1;
	private TextView textview6;
	private ListView listview1;
	private LinearLayout linear39;
	private TextView textview43;
	private TextView textview42;
	private LinearLayout linear40;
	private ImageView imageview7;
	private TextView textview4;
	private TextView textview5;
	
	private AlertDialog.Builder scarica;
	private StorageReference download = _firebase_storage.getReference("mod");
	private OnCompleteListener<Uri> _download_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _download_download_success_listener;
	private OnSuccessListener _download_delete_success_listener;
	private OnProgressListener _download_upload_progress_listener;
	private OnProgressListener _download_download_progress_listener;
	private OnFailureListener _download_failure_listener;
	
	private Intent intent = new Intent();
	private Intent installa = new Intent();
	private AlertDialog.Builder elimina;
	private DatabaseReference ver = _firebase.getReference("mod");
	private ChildEventListener _ver_child_listener;
	private AlertDialog.Builder aggiungi;
	private Intent firebase = new Intent();
	private AlertDialog.Builder aiuto;
	private Intent installaUltimaVer = new Intent();
	private FirebaseAuth verification;
	private OnCompleteListener<AuthResult> _verification_create_user_listener;
	private OnCompleteListener<AuthResult> _verification_sign_in_listener;
	private OnCompleteListener<Void> _verification_reset_password_listener;
	private OnCompleteListener<Void> verification_updateEmailListener;
	private OnCompleteListener<Void> verification_updatePasswordListener;
	private OnCompleteListener<Void> verification_emailVerificationSentListener;
	private OnCompleteListener<Void> verification_deleteUserListener;
	private OnCompleteListener<Void> verification_updateProfileListener;
	private OnCompleteListener<AuthResult> verification_phoneAuthListener;
	private OnCompleteListener<AuthResult> verification_googleSignInListener;
	
	private RequestNetwork admin;
	private RequestNetwork.RequestListener _admin_request_listener;
	private SharedPreferences saltabili;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.selversione);
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
		linear6 = findViewById(R.id.linear6);
		bottomnavigation2 = findViewById(R.id.bottomnavigation2);
		imageview2 = findViewById(R.id.imageview2);
		textview1 = findViewById(R.id.textview1);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		progressbar1 = findViewById(R.id.progressbar1);
		linear36 = findViewById(R.id.linear36);
		textview3 = findViewById(R.id.textview3);
		linear1 = findViewById(R.id.linear1);
		textview6 = findViewById(R.id.textview6);
		listview1 = findViewById(R.id.listview1);
		linear39 = findViewById(R.id.linear39);
		textview43 = findViewById(R.id.textview43);
		textview42 = findViewById(R.id.textview42);
		linear40 = findViewById(R.id.linear40);
		imageview7 = findViewById(R.id.imageview7);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		scarica = new AlertDialog.Builder(this);
		elimina = new AlertDialog.Builder(this);
		aggiungi = new AlertDialog.Builder(this);
		aiuto = new AlertDialog.Builder(this);
		verification = FirebaseAuth.getInstance();
		admin = new RequestNetwork(this);
		saltabili = getSharedPreferences("saltabili", Activity.MODE_PRIVATE);
		
		bottomnavigation2.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(MenuItem item) {
				final int _itemId = item.getItemId();
				if (_itemId == 1) {
					if (linear5.getVisibility() == View.VISIBLE) {
						
						{
							DisplayMetrics screen = new DisplayMetrics();
							getWindowManager().getDefaultDisplay().getMetrics(screen);
							double dp = 10;
							double logicalDensity = screen.density;
							int px = (int) Math.ceil(dp * logicalDensity);
							Toast SelversioneActivityToast = Toast.makeText(SelversioneActivity.this, "Caricamento ultima versione...", 2000);
							View SelversioneActivityView = SelversioneActivityToast.getView();
							SelversioneActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
							
							
							TextView SelversioneActivityText = SelversioneActivityView.findViewById(android.R.id.message);
							SelversioneActivityText.setTextColor(Color.parseColor("#ffffff"));
							SelversioneActivityText.setShadowLayer(0,0,0,0);
							SelversioneActivityToast.show();
						}
					}
					else {
						startActivity(installaUltimaVer);
					}
				}
				else {
					if (_itemId == 2) {
						aiuto.setTitle("Aiuto");
						aiuto.setMessage("Per scaricare la mod semplicemente seleziona in questa lista la versione della mod da installare (la mod più recente e indicata) e clicca sul tasto \"Inizia l'installazione\".");
						aiuto.setIcon(R.drawable.ic_help_white);
						aiuto.setPositiveButton("ok", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						aiuto.setNegativeButton("supporto", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								intent.setClass(getApplicationContext(), SocialActivity.class);
								startActivity(intent);
							}
						});
						{
							final AlertDialog alert = aiuto.show();
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
						if (_itemId == 3) {
							intent.setClass(getApplicationContext(), PubblicaActivity.class);
							startActivity(intent);
						}
						else {
							
						}
					}
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
		
		linear5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
				{
					DisplayMetrics screen = new DisplayMetrics();
					getWindowManager().getDefaultDisplay().getMetrics(screen);
					double dp = 10;
					double logicalDensity = screen.density;
					int px = (int) Math.ceil(dp * logicalDensity);
					Toast SelversioneActivityToast = Toast.makeText(SelversioneActivity.this, "Connessione in corso...", 2000);
					View SelversioneActivityView = SelversioneActivityToast.getView();
					SelversioneActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
					
					
					TextView SelversioneActivityText = SelversioneActivityView.findViewById(android.R.id.message);
					SelversioneActivityText.setTextColor(Color.parseColor("#ffffff"));
					SelversioneActivityText.setShadowLayer(0,0,0,0);
					SelversioneActivityToast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL,0 ,100);
					SelversioneActivityToast.show();
				}
			}
		});
		
		linear1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (linear5.getVisibility() == View.VISIBLE) {
					{
						DisplayMetrics screen = new DisplayMetrics();
						getWindowManager().getDefaultDisplay().getMetrics(screen);
						double dp = 10;
						double logicalDensity = screen.density;
						int px = (int) Math.ceil(dp * logicalDensity);
						Toast SelversioneActivityToast = Toast.makeText(SelversioneActivity.this, "Caricamento in corso...", 2000);
						View SelversioneActivityView = SelversioneActivityToast.getView();
						SelversioneActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
						
						
						TextView SelversioneActivityText = SelversioneActivityView.findViewById(android.R.id.message);
						SelversioneActivityText.setTextColor(Color.parseColor("#ffffff"));
						SelversioneActivityText.setShadowLayer(0,0,0,0);
						SelversioneActivityToast.show();
					}
				}
				else {
					startActivity(installaUltimaVer);
				}
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				installa.setAction(Intent.ACTION_VIEW);
				installa.setClass(getApplicationContext(), InstallaActivity.class);
				installa.putExtra("link", lista.get((int)_position).get("Link").toString());
				installa.putExtra("novità", lista.get((int)_position).get("Novità").toString());
				installa.putExtra("ver", lista.get((int)_position).get("Versione").toString());
				startActivity(installa);
			}
		});
		
		imageview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				saltabili.edit().putString("ComeInstallare", "0").commit();
				linear36.setVisibility(View.GONE);
			}
		});
		
		_download_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_download_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_download_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_download_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_download_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				SketchwareUtil.showMessage(getApplicationContext(), "Eliminato");
			}
		};
		
		_download_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				SketchwareUtil.showMessage(getApplicationContext(), _message);
			}
		};
		
		_ver_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				ver.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						lista = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								lista.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(lista));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						Collections.reverse(lista);
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				ver.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						lista = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								lista.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(lista));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						Collections.reverse(lista);
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				ver.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						lista = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								lista.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(lista));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						Collections.reverse(lista);
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
			}
		};
		ver.addChildEventListener(_ver_child_listener);
		
		_admin_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				if (_response.contains(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
					bottomnavigation2.getMenu().add(0, 3, 0, "Pubblica").setIcon(R.drawable.ic_add_circle_white);
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		verification_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		verification_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		verification_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		verification_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		verification_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		verification_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		verification_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_verification_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_verification_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_verification_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		caricamento = true;
		
		DisplayMetrics linear1Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear1Screen);
		double linear1DP = 10;
		double linear1LogicalDensity = linear1Screen.density;
		int linear1PX = (int) Math.ceil(linear1DP * linear1LogicalDensity);
		android.graphics.drawable.GradientDrawable linear1GG = new android.graphics.drawable.GradientDrawable();
		linear1GG.setColor(Color.parseColor("#212121"));
		linear1GG.setCornerRadius((float)linear1PX);
		linear1GG.setStroke((int) 0,
		Color.parseColor("#000000"));
		android.graphics.drawable.RippleDrawable linear1RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#2196F3")}), linear1GG, null);
		linear1.setBackground(linear1RE);
		linear1.setElevation(0);
		linear1.setTranslationZ(0);
		
		DisplayMetrics linear36Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear36Screen);
		double linear36DP = 10;
		double linear36LogicalDensity = linear36Screen.density;
		int linear36PX = (int) Math.ceil(linear36DP * linear36LogicalDensity);
		linear36.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear36PX, (int)0));
		linear36.setElevation(0);
		linear36.setTranslationZ(0);
		listview1.setSelector(android.R.color.transparent);
		
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
		bottomnavigation2.getMenu().add(0, 1, 0, "Ultima ver").setIcon(R.drawable.ic_description_white);
		bottomnavigation2.getMenu().add(0, 2, 0, "Aiuto").setIcon(R.drawable.ic_help_white);
		admin.startRequestNetwork(RequestNetworkController.GET, "https://pastefy.app/HwUawOyY/raw", "", _admin_request_listener);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (saltabili.contains("ComeInstallare")) {
			linear36.setVisibility(View.GONE);
		}
	}
	public void _EndLoader() {
		linear5.setVisibility(View.INVISIBLE);
		caricamento = false;
	}
	
	
	public void _NascondiUltimaVersione() {
		textview3.setVisibility(View.GONE);
		linear1.setVisibility(View.GONE);
	}
	
	
	public void _Imposta(final String _versione, final String _link, final String _novita, final String _commenti) {
		textview4.setText(_versione);
		textview5.setText(_novita);
		installaUltimaVer.setClass(getApplicationContext(), InstallaActivity.class);
		installaUltimaVer.putExtra("link", _link);
		installaUltimaVer.putExtra("novità", _novita);
		installaUltimaVer.putExtra("ver", _versione);
		installaUltimaVer.putExtra("commenti", _commenti);
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.versioni, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			
			
			DisplayMetrics linear1Screen = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(linear1Screen);
			double linear1DP = 10;
			double linear1LogicalDensity = linear1Screen.density;
			int linear1PX = (int) Math.ceil(linear1DP * linear1LogicalDensity);
			android.graphics.drawable.GradientDrawable linear1GG = new android.graphics.drawable.GradientDrawable();
			linear1GG.setColor(Color.parseColor("#212121"));
			linear1GG.setCornerRadius((float)linear1PX);
			linear1GG.setStroke((int) 0,
			Color.parseColor("#000000"));
			android.graphics.drawable.RippleDrawable linear1RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#2196F3")}), linear1GG, null);
			linear1.setBackground(linear1RE);
			linear1.setElevation(0);
			linear1.setTranslationZ(0);
			
			DisplayMetrics linear2Screen = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(linear2Screen);
			double linear2DP = 10;
			double linear2LogicalDensity = linear2Screen.density;
			int linear2PX = (int) Math.ceil(linear2DP * linear2LogicalDensity);
			linear2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#1BA8F0")); return this; } }.getIns((int)linear2PX, (int)0));
			linear2.setElevation(0);
			linear2.setTranslationZ(0);
			_EndLoader();
			textview1.setText(lista.get((int)_position).get("Versione").toString());
			textview3.setText(lista.get((int)_position).get("Novità").toString());
			if (!lista.get((int)_position).get("Versione").toString().equals(getIntent().getStringExtra("ultima"))) {
				linear2.setVisibility(View.GONE);
			}
			if (linear2.getVisibility() == View.VISIBLE) {
				_Imposta(lista.get((int)_position).get("Versione").toString(), lista.get((int)_position).get("Link").toString(), lista.get((int)_position).get("Novità").toString(), lista.get((int)_position).get("Commenti").toString());
			}
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					installa.setAction(Intent.ACTION_VIEW);
					installa.setClass(getApplicationContext(), InstallaActivity.class);
					installa.putExtra("link", lista.get((int)_position).get("Link").toString());
					installa.putExtra("novità", lista.get((int)_position).get("Novità").toString());
					installa.putExtra("ver", lista.get((int)_position).get("Versione").toString());
					installa.putExtra("commenti", lista.get((int)_position).get("Commenti").toString());
					startActivity(installa);
				}
			});
			
			return _view;
		}
	}
}