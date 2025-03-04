package jk.spotifinity;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
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
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
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
import com.google.firebase.FirebaseApp;
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
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class TotcommentiActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private boolean Moderatore = false;
	private double Conta = 0;
	private HashMap<String, Object> request = new HashMap<>();
	private HashMap<String, Object> headers = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> lista = new ArrayList<>();
	private ArrayList<String> finale = new ArrayList<>();
	
	private LinearLayout linear3;
	private LinearLayout linear4;
	private ImageView imageview2;
	private TextView textview1;
	private ListView listview1;
	
	private DatabaseReference commenti = _firebase.getReference("commenti");
	private ChildEventListener _commenti_child_listener;
	private Intent profilo = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.totcommenti);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		imageview2 = findViewById(R.id.imageview2);
		textview1 = findViewById(R.id.textview1);
		listview1 = findViewById(R.id.listview1);
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
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
				
			}
		};
		commenti.addChildEventListener(_commenti_child_listener);
	}
	
	private void initializeLogic() {
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
				_view = _inflater.inflate(R.layout.commentodesc, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final ImageView imageview3 = _view.findViewById(R.id.imageview3);
			final ImageView imageview4 = _view.findViewById(R.id.imageview4);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			
			textview1.setText(lista.get((int)_position).get("Creatore").toString());
			textview3.setText(lista.get((int)_position).get("Contenuto").toString());
			textview5.setText(lista.get((int)_position).get("Versione").toString());
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
				linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)10, (int)10, 0xFF2196F3, 0xFF0D47A1));
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
					startActivity(profilo);
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
						Toast TotcommentiActivityToast = Toast.makeText(TotcommentiActivity.this, "Verificato", 2000);
						View TotcommentiActivityView = TotcommentiActivityToast.getView();
						TotcommentiActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
						
						
						TextView TotcommentiActivityText = TotcommentiActivityView.findViewById(android.R.id.message);
						TotcommentiActivityText.setTextColor(Color.parseColor("#ffffff"));
						TotcommentiActivityText.setShadowLayer(0,0,0,0);
						TotcommentiActivityToast.show();
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
						Toast TotcommentiActivityToast = Toast.makeText(TotcommentiActivity.this, "Moderatore", 2000);
						View TotcommentiActivityView = TotcommentiActivityToast.getView();
						TotcommentiActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
						
						
						TextView TotcommentiActivityText = TotcommentiActivityView.findViewById(android.R.id.message);
						TotcommentiActivityText.setTextColor(Color.parseColor("#ffffff"));
						TotcommentiActivityText.setShadowLayer(0,0,0,0);
						TotcommentiActivityToast.show();
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
						Toast TotcommentiActivityToast = Toast.makeText(TotcommentiActivity.this, "Suggeritore", 2000);
						View TotcommentiActivityView = TotcommentiActivityToast.getView();
						TotcommentiActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
						
						
						TextView TotcommentiActivityText = TotcommentiActivityView.findViewById(android.R.id.message);
						TotcommentiActivityText.setTextColor(Color.parseColor("#ffffff"));
						TotcommentiActivityText.setShadowLayer(0,0,0,0);
						TotcommentiActivityToast.show();
					}
				}
			});
			
			return _view;
		}
	}
}