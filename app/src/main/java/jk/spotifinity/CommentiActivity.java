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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.mannan.translateapi.*;
import com.tonyodev.fetch2.*;
import com.tonyodev.fetch2core.*;
import eightbitlab.com.blurview.*;
import java.io.*;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class CommentiActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> Commento = new HashMap<>();
	private double SecondiRimasti = 0;
	private boolean Verificato = false;
	private boolean Moderatore = false;
	private double Conta = 0;
	private HashMap<String, Object> request = new HashMap<>();
	private HashMap<String, Object> headers = new HashMap<>();
	private HashMap<String, Object> body = new HashMap<>();
	private boolean Suggeritore = false;
	
	private ArrayList<HashMap<String, Object>> lista = new ArrayList<>();
	private ArrayList<String> finale = new ArrayList<>();
	
	private LinearLayout linear3;
	private LinearLayout linear10;
	private ImageView imageview2;
	private TextView textview1;
	private LinearLayout linear35;
	private TextView textview32;
	private ListView listview2;
	private LinearLayout linear5;
	private LinearLayout linear9;
	private TextView textview3;
	private TextView textview33;
	private ImageView imageview4;
	private ImageView imageview5;
	private ImageView imageview6;
	private EditText edittext1;
	private TextView textview4;
	private ImageView imageview3;
	
	private DatabaseReference commenti = _firebase.getReference("commenti");
	private ChildEventListener _commenti_child_listener;
	private TimerTask Repeater;
	private RequestNetwork verifica;
	private RequestNetwork.RequestListener _verifica_request_listener;
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
	private Intent profilo = new Intent();
	private RequestNetwork mod;
	private RequestNetwork.RequestListener _mod_request_listener;
	private RequestNetwork conta;
	private RequestNetwork.RequestListener _conta_request_listener;
	private AlertDialog.Builder dialog;
	private AlertDialog.Builder elimina;
	private RequestNetwork notifica;
	private RequestNetwork.RequestListener _notifica_request_listener;
	private Notification notify;
	private AlertDialog.Builder admin;
	private RequestNetwork suggeritore;
	private RequestNetwork.RequestListener _suggeritore_request_listener;
	private SharedPreferences account;
	private Calendar ora = Calendar.getInstance();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.commenti);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear3 = findViewById(R.id.linear3);
		linear10 = findViewById(R.id.linear10);
		imageview2 = findViewById(R.id.imageview2);
		textview1 = findViewById(R.id.textview1);
		linear35 = findViewById(R.id.linear35);
		textview32 = findViewById(R.id.textview32);
		listview2 = findViewById(R.id.listview2);
		linear5 = findViewById(R.id.linear5);
		linear9 = findViewById(R.id.linear9);
		textview3 = findViewById(R.id.textview3);
		textview33 = findViewById(R.id.textview33);
		imageview4 = findViewById(R.id.imageview4);
		imageview5 = findViewById(R.id.imageview5);
		imageview6 = findViewById(R.id.imageview6);
		edittext1 = findViewById(R.id.edittext1);
		textview4 = findViewById(R.id.textview4);
		imageview3 = findViewById(R.id.imageview3);
		verifica = new RequestNetwork(this);
		auth = FirebaseAuth.getInstance();
		mod = new RequestNetwork(this);
		conta = new RequestNetwork(this);
		dialog = new AlertDialog.Builder(this);
		elimina = new AlertDialog.Builder(this);
		notifica = new RequestNetwork(this);
		admin = new AlertDialog.Builder(this);
		suggeritore = new RequestNetwork(this);
		account = getSharedPreferences("account", Activity.MODE_PRIVATE);
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		linear35.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
				{
					DisplayMetrics screen = new DisplayMetrics();
					getWindowManager().getDefaultDisplay().getMetrics(screen);
					double dp = 10;
					double logicalDensity = screen.density;
					int px = (int) Math.ceil(dp * logicalDensity);
					Toast CommentiActivityToast = Toast.makeText(CommentiActivity.this, "Questa è una funzione beta e potrebbe avere problemi", 2000);
					View CommentiActivityView = CommentiActivityToast.getView();
					CommentiActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#1BA8F0")));
					
					
					TextView CommentiActivityText = CommentiActivityView.findViewById(android.R.id.message);
					CommentiActivityText.setTextColor(Color.parseColor("#ffffff"));
					CommentiActivityText.setShadowLayer(0,0,0,0);
					CommentiActivityToast.show();
				}
			}
		});
		
		listview2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				
				return true;
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ora = Calendar.getInstance();
				if (edittext1.getText().toString().equals("")) {
					{
						DisplayMetrics screen = new DisplayMetrics();
						getWindowManager().getDefaultDisplay().getMetrics(screen);
						double dp = 10;
						double logicalDensity = screen.density;
						int px = (int) Math.ceil(dp * logicalDensity);
						Toast CommentiActivityToast = Toast.makeText(CommentiActivity.this, "Scrivi qualcosa!", 2000);
						View CommentiActivityView = CommentiActivityToast.getView();
						CommentiActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
						
						
						TextView CommentiActivityText = CommentiActivityView.findViewById(android.R.id.message);
						CommentiActivityText.setTextColor(Color.parseColor("#ffffff"));
						CommentiActivityText.setShadowLayer(0,0,0,0);
						CommentiActivityToast.show();
					}
				}
				else {
					Conta++;
					Commento = new HashMap<>();
					Commento.put("Creatore", account.getString("username", ""));
					Commento.put("Contenuto", edittext1.getText().toString());
					Commento.put("Versione", getIntent().getStringExtra("ver"));
					Commento.put("Email", FirebaseAuth.getInstance().getCurrentUser().getEmail());
					Commento.put("Data", new SimpleDateFormat("dd/MM/yyy HH:mm").format(ora.getTime()));
					if (Verificato) {
						Commento.put("Verificato", "true");
					}
					else {
						Commento.put("Verificato", "false");
					}
					if (Moderatore) {
						Commento.put("Moderatore", "true");
					}
					else {
						Commento.put("Moderatore", "false");
					}
					if (Suggeritore) {
						Commento.put("Suggeritore", "true");
					}
					else {
						Commento.put("Suggeritore", "false");
					}
					commenti.push().updateChildren(Commento);
					request = new HashMap<>();
					headers = new HashMap<>();
					request.put("content", String.valueOf((long)(Conta)));
					headers.put("Authorization", "Bearer e4xusKs4i2GXB1TnfhJtfCDLkJIJcLk3EB5KKVgVnJiAlygDhvDVHMREjW1y");
					conta.setParams(request, RequestNetworkController.REQUEST_BODY);
					conta.setHeaders(headers);
					conta.startRequestNetwork(RequestNetworkController.PUT, "https://pastefy.app/api/v2/paste/".concat(getIntent().getStringExtra("commenti")), "", _conta_request_listener);
					headers = new HashMap<>();
					body = new HashMap<>();
					headers.put("url", "https://discord.com/api/webhooks/1118663226972975164/TiESMCEW01Gvymj438RapundWL_jhOYkdyb9YYP2TTmNda0cDvNeIrfm_sThYhy-OjNV");
					body.put("content", "**<".concat(account.getString("username", "")).concat("> ").concat(getIntent().getStringExtra("ver")).concat("**\n> *").concat(edittext1.getText().toString()).concat("*"));
					notifica.setHeaders(headers);
					notifica.setParams(body, RequestNetworkController.REQUEST_BODY);
					_CooldownCommenti();
					{
						DisplayMetrics screen = new DisplayMetrics();
						getWindowManager().getDefaultDisplay().getMetrics(screen);
						double dp = 10;
						double logicalDensity = screen.density;
						int px = (int) Math.ceil(dp * logicalDensity);
						Toast CommentiActivityToast = Toast.makeText(CommentiActivity.this, "Commento pubblicato!", 2000);
						View CommentiActivityView = CommentiActivityToast.getView();
						CommentiActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
						
						
						TextView CommentiActivityText = CommentiActivityView.findViewById(android.R.id.message);
						CommentiActivityText.setTextColor(Color.parseColor("#ffffff"));
						CommentiActivityText.setShadowLayer(0,0,0,0);
						CommentiActivityToast.show();
					}
					notifica.startRequestNetwork(RequestNetworkController.POST, "https://discord.com/api/webhooks/1118663226972975164/TiESMCEW01Gvymj438RapundWL_jhOYkdyb9YYP2TTmNda0cDvNeIrfm_sThYhy-OjNV", "", _notifica_request_listener);
					edittext1.setText("");
				}
			}
		});
		
		_commenti_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				commenti.addListenerForSingleValueEvent(new ValueEventListener() {
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
						finale.add(_childKey);
						listview2.setAdapter(new Listview2Adapter(lista));
						((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
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
				commenti.addListenerForSingleValueEvent(new ValueEventListener() {
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
						listview2.setAdapter(new Listview2Adapter(lista));
						((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
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
				commenti.addListenerForSingleValueEvent(new ValueEventListener() {
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
						listview2.setAdapter(new Listview2Adapter(lista));
						((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
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
				
			}
		};
		commenti.addChildEventListener(_commenti_child_listener);
		
		_verifica_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				if (_response.contains(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
					Verificato = true;
					imageview4.setVisibility(View.VISIBLE);
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_mod_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				if (_response.contains(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
					Moderatore = true;
					imageview5.setVisibility(View.VISIBLE);
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_conta_request_listener = new RequestNetwork.RequestListener() {
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
		
		_suggeritore_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				if (_response.contains(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
					Suggeritore = true;
					imageview6.setVisibility(View.VISIBLE);
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
		
		DisplayMetrics linear35Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear35Screen);
		double linear35DP = 10;
		double linear35LogicalDensity = linear35Screen.density;
		int linear35PX = (int) Math.ceil(linear35DP * linear35LogicalDensity);
		linear35.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#1BA8F0")); return this; } }.getIns((int)linear35PX, (int)0));
		linear35.setElevation(0);
		linear35.setTranslationZ(0);
		listview2.setSelector(android.R.color.transparent);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		Verificato = false;
		Moderatore = false;
		Suggeritore = false;
		Conta = Double.parseDouble(getIntent().getStringExtra("conta"));
		textview33.setText(account.getString("username", ""));
		imageview4.setVisibility(View.INVISIBLE);
		imageview5.setVisibility(View.INVISIBLE);
		imageview6.setVisibility(View.INVISIBLE);
		textview4.setVisibility(View.INVISIBLE);
		verifica.startRequestNetwork(RequestNetworkController.GET, "https://pastefy.app/lhu3QpHD/raw", "", _verifica_request_listener);
		mod.startRequestNetwork(RequestNetworkController.GET, "https://pastefy.app/HwUawOyY/raw", "", _mod_request_listener);
		suggeritore.startRequestNetwork(RequestNetworkController.GET, "https://pastefy.app/5TJJYXe8/raw", "", _suggeritore_request_listener);
	}
	public void _CooldownCommenti() {
		SecondiRimasti = 10;
		imageview3.setVisibility(View.INVISIBLE);
		textview4.setVisibility(View.VISIBLE);
		Repeater = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						SecondiRimasti--;
						textview4.setText(String.valueOf((long)(SecondiRimasti)));
						if (SecondiRimasti == 0) {
							Repeater.cancel();
							imageview3.setVisibility(View.VISIBLE);
							textview4.setVisibility(View.INVISIBLE);
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(Repeater, (int)(50), (int)(1000));
	}
	
	public class Listview2Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.commento, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final ImageView imageview3 = _view.findViewById(R.id.imageview3);
			final ImageView imageview4 = _view.findViewById(R.id.imageview4);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			
			textview1.setText(lista.get((int)_position).get("Creatore").toString());
			textview3.setText(lista.get((int)_position).get("Contenuto").toString());
			textview4.setText(lista.get((int)_position).get("Data").toString());
			if (!lista.get((int)_position).get("Versione").toString().replace("_", ".").equals(getIntent().getStringExtra("ver"))) {
				linear1.setVisibility(View.GONE);
			}
			if (!lista.get((int)_position).get("Verificato").toString().equals("true")) {
				imageview1.setVisibility(View.GONE);
			}
			if (!lista.get((int)_position).get("Moderatore").toString().equals("true")) {
				imageview3.setVisibility(View.GONE);
			}
			if (!lista.get((int)_position).get("Suggeritore").toString().equals("true")) {
				imageview4.setVisibility(View.GONE);
			}
			if (lista.get((int)_position).get("Moderatore").toString().equals("true")) {
				
				DisplayMetrics linear1Screen = new DisplayMetrics();
				getWindowManager().getDefaultDisplay().getMetrics(linear1Screen);
				double linear1DP = 10;
				double linear1LogicalDensity = linear1Screen.density;
				int linear1PX = (int) Math.ceil(linear1DP * linear1LogicalDensity);
				android.graphics.drawable.GradientDrawable linear1GG = new android.graphics.drawable.GradientDrawable();
				linear1GG.setColor(Color.parseColor("#003A94"));
				linear1GG.setCornerRadius((float)linear1PX);
				linear1GG.setStroke((int) 0,
				Color.parseColor("#000000"));
				android.graphics.drawable.RippleDrawable linear1RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#2196F3")}), linear1GG, null);
				linear1.setBackground(linear1RE);
				linear1.setElevation(0);
				linear1.setTranslationZ(0);
				textview4.setTextColor(0xFF326CC6);
			}
			else {
				
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
			}
			textview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					profilo.setClass(getApplicationContext(), ProfiloActivity.class);
					profilo.putExtra("username", lista.get((int)_position).get("Creatore").toString());
					profilo.putExtra("email", lista.get((int)_position).get("Email").toString());
					if (lista.get((int)_position).get("Verificato").toString().equals("true")) {
						profilo.putExtra("verificato", "true");
					}
					else {
						profilo.putExtra("verificato", "false");
					}
					if (lista.get((int)_position).get("Moderatore").toString().equals("true")) {
						profilo.putExtra("mod", "true");
					}
					else {
						profilo.putExtra("mod", "false");
					}
					if (lista.get((int)_position).get("Suggeritore").toString().equals("true")) {
						profilo.putExtra("sug", "true");
					}
					else {
						profilo.putExtra("sug", "false");
					}
					startActivity(profilo);
				}
			});
			linear1.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					if (lista.get((int)_position).get("Email").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
						dialog.setTitle("Commento");
						dialog.setMessage(lista.get((int)_position).get("Contenuto").toString());
						dialog.setNegativeButton("elimina", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								elimina.setTitle("Elimina");
								elimina.setMessage("Vuoi eliminare questo commento?");
								elimina.setNeutralButton("si", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										commenti.child(finale.get((int)(_position))).removeValue();
										finale.remove((int)(_position));
										Conta--;
										request = new HashMap<>();
										headers = new HashMap<>();
										request.put("content", String.valueOf((long)(Conta)));
										headers.put("Authorization", "Bearer e4xusKs4i2GXB1TnfhJtfCDLkJIJcLk3EB5KKVgVnJiAlygDhvDVHMREjW1y");
										conta.setParams(request, RequestNetworkController.REQUEST_BODY);
										conta.setHeaders(headers);
										conta.startRequestNetwork(RequestNetworkController.PUT, "https://pastefy.app/api/v2/paste/".concat(getIntent().getStringExtra("commenti")), "", _conta_request_listener);
										
										{
											DisplayMetrics screen = new DisplayMetrics();
											getWindowManager().getDefaultDisplay().getMetrics(screen);
											double dp = 10;
											double logicalDensity = screen.density;
											int px = (int) Math.ceil(dp * logicalDensity);
											Toast CommentiActivityToast = Toast.makeText(CommentiActivity.this, "Commento eliminato!", 2000);
											View CommentiActivityView = CommentiActivityToast.getView();
											CommentiActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
											
											
											TextView CommentiActivityText = CommentiActivityView.findViewById(android.R.id.message);
											CommentiActivityText.setTextColor(Color.parseColor("#ffffff"));
											CommentiActivityText.setShadowLayer(0,0,0,0);
											CommentiActivityToast.show();
										}
									}
								});
								elimina.setNegativeButton("no", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										
									}
								});
								
								{
									final AlertDialog alert = elimina.show();
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
						if (Moderatore) {
							dialog.setNeutralButton("mod", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									admin.setTitle("Moderatore");
									admin.setMessage("Cosa vuoi fare con questo commento?");
									admin.setNegativeButton("elimina", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											commenti.child(finale.get((int)(_position))).removeValue();
											finale.remove((int)(_position));
											Conta--;
											request = new HashMap<>();
											headers = new HashMap<>();
											request.put("content", String.valueOf((long)(Conta)));
											headers.put("Authorization", "Bearer e4xusKs4i2GXB1TnfhJtfCDLkJIJcLk3EB5KKVgVnJiAlygDhvDVHMREjW1y");
											conta.setParams(request, RequestNetworkController.REQUEST_BODY);
											conta.setHeaders(headers);
											conta.startRequestNetwork(RequestNetworkController.PUT, "https://pastefy.app/api/v2/paste/".concat(getIntent().getStringExtra("commenti")), "", _conta_request_listener);
										}
									});
									
									{
										final AlertDialog alert = admin.show();
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
						}
						
						{
							final AlertDialog alert = dialog.show();
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
						if (Moderatore) {
							admin.setTitle("Moderatore");
							admin.setMessage("Cosa vuoi fare con questo commento?");
							admin.setNegativeButton("elimina", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									commenti.child(finale.get((int)(_position))).removeValue();
									finale.remove((int)(_position));
									Conta--;
									request = new HashMap<>();
									headers = new HashMap<>();
									request.put("content", String.valueOf((long)(Conta)));
									headers.put("Authorization", "Bearer e4xusKs4i2GXB1TnfhJtfCDLkJIJcLk3EB5KKVgVnJiAlygDhvDVHMREjW1y");
									conta.setParams(request, RequestNetworkController.REQUEST_BODY);
									conta.setHeaders(headers);
									conta.startRequestNetwork(RequestNetworkController.PUT, "https://pastefy.app/api/v2/paste/".concat(getIntent().getStringExtra("commenti")), "", _conta_request_listener);
								}
							});
							
							{
								final AlertDialog alert = admin.show();
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
					return true;
				}
			});
			imageview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					{
						DisplayMetrics screen = new DisplayMetrics();
						getWindowManager().getDefaultDisplay().getMetrics(screen);
						double dp = 10;
						double logicalDensity = screen.density;
						int px = (int) Math.ceil(dp * logicalDensity);
						Toast CommentiActivityToast = Toast.makeText(CommentiActivity.this, "Verificato", 2000);
						View CommentiActivityView = CommentiActivityToast.getView();
						CommentiActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
						
						
						TextView CommentiActivityText = CommentiActivityView.findViewById(android.R.id.message);
						CommentiActivityText.setTextColor(Color.parseColor("#ffffff"));
						CommentiActivityText.setShadowLayer(0,0,0,0);
						CommentiActivityToast.show();
					}
				}
			});
			imageview3.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					{
						DisplayMetrics screen = new DisplayMetrics();
						getWindowManager().getDefaultDisplay().getMetrics(screen);
						double dp = 10;
						double logicalDensity = screen.density;
						int px = (int) Math.ceil(dp * logicalDensity);
						Toast CommentiActivityToast = Toast.makeText(CommentiActivity.this, "Moderatore", 2000);
						View CommentiActivityView = CommentiActivityToast.getView();
						CommentiActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
						
						
						TextView CommentiActivityText = CommentiActivityView.findViewById(android.R.id.message);
						CommentiActivityText.setTextColor(Color.parseColor("#ffffff"));
						CommentiActivityText.setShadowLayer(0,0,0,0);
						CommentiActivityToast.show();
					}
				}
			});
			imageview4.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					{
						DisplayMetrics screen = new DisplayMetrics();
						getWindowManager().getDefaultDisplay().getMetrics(screen);
						double dp = 10;
						double logicalDensity = screen.density;
						int px = (int) Math.ceil(dp * logicalDensity);
						Toast CommentiActivityToast = Toast.makeText(CommentiActivity.this, "Suggeritore", 2000);
						View CommentiActivityView = CommentiActivityToast.getView();
						CommentiActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
						
						
						TextView CommentiActivityText = CommentiActivityView.findViewById(android.R.id.message);
						CommentiActivityText.setTextColor(Color.parseColor("#ffffff"));
						CommentiActivityText.setShadowLayer(0,0,0,0);
						CommentiActivityToast.show();
					}
				}
			});
			
			return _view;
		}
	}
}