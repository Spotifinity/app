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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.room.*;
import androidx.sqlite.db.*;
import androidx.sqlite.db.framework.*;
import com.google.android.material.button.*;
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
import java.util.HashMap;
import java.util.regex.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class PubblicaActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> mappaMod = new HashMap<>();
	private HashMap<String, Object> pastefy = new HashMap<>();
	private HashMap<String, Object> request = new HashMap<>();
	private HashMap<String, Object> headers = new HashMap<>();
	private boolean Generato = false;
	private String LinkContatoreCommenti = "";
	private HashMap<String, Object> mappa = new HashMap<>();
	
	private LinearLayout linear3;
	private ScrollView vscroll1;
	private ImageView imageview2;
	private TextView textview1;
	private LinearLayout linear5;
	private EditText edittext1;
	private EditText edittext2;
	private EditText edittext3;
	private CheckBox checkbox1;
	private CheckBox checkbox2;
	private EditText edittext4;
	private MaterialButton materialbutton2;
	private ProgressBar progressbar1;
	
	private RequestNetwork GitHub;
	private RequestNetwork.RequestListener _GitHub_request_listener;
	private DatabaseReference db = _firebase.getReference("mod");
	private ChildEventListener _db_child_listener;
	private Intent Generatore = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.pubblica);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear3 = findViewById(R.id.linear3);
		vscroll1 = findViewById(R.id.vscroll1);
		imageview2 = findViewById(R.id.imageview2);
		textview1 = findViewById(R.id.textview1);
		linear5 = findViewById(R.id.linear5);
		edittext1 = findViewById(R.id.edittext1);
		edittext2 = findViewById(R.id.edittext2);
		edittext3 = findViewById(R.id.edittext3);
		checkbox1 = findViewById(R.id.checkbox1);
		checkbox2 = findViewById(R.id.checkbox2);
		edittext4 = findViewById(R.id.edittext4);
		materialbutton2 = findViewById(R.id.materialbutton2);
		progressbar1 = findViewById(R.id.progressbar1);
		GitHub = new RequestNetwork(this);
		
		checkbox2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (checkbox2.isChecked()) {
					checkbox2.setChecked(false);
				}
				else {
					checkbox2.setChecked(true);
				}
				if (!checkbox2.isChecked()) {
					_Genera(edittext1.getText().toString());
					progressbar1.setVisibility(View.VISIBLE);
					progressbar1.setProgress((int)0);
					progressbar1.setMax((int)9);
				}
			}
		});
		
		materialbutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Generato) {
					progressbar1.setVisibility(View.VISIBLE);
					mappa = new HashMap<>();
					mappa.put("Link", edittext3.getText().toString());
					mappa.put("Versione", edittext1.getText().toString());
					mappa.put("Novità", edittext2.getText().toString());
					mappa.put("Commenti", edittext4.getText().toString());
					if (checkbox1.isChecked()) {
						pastefy = new HashMap<>();
						pastefy.put("content", edittext1.getText().toString());
						GitHub.setParams(pastefy, RequestNetworkController.REQUEST_BODY);
						pastefy = new HashMap<>();
						pastefy.put("Authorization", "Bearer e4xusKs4i2GXB1TnfhJtfCDLkJIJcLk3EB5KKVgVnJiAlygDhvDVHMREjW1y");
						GitHub.setHeaders(pastefy);
						GitHub.startRequestNetwork(RequestNetworkController.PUT, "https://pastefy.app/api/v2/paste/3DjQQQZG", "", _GitHub_request_listener);
					}
					db.push().updateChildren(mappa);
					
					{
						DisplayMetrics screen = new DisplayMetrics();
						getWindowManager().getDefaultDisplay().getMetrics(screen);
						double dp = 10;
						double logicalDensity = screen.density;
						int px = (int) Math.ceil(dp * logicalDensity);
						Toast PubblicaActivityToast = Toast.makeText(PubblicaActivity.this, "Versione pubblicata!", 2000);
						View PubblicaActivityView = PubblicaActivityToast.getView();
						PubblicaActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
						
						
						TextView PubblicaActivityText = PubblicaActivityView.findViewById(android.R.id.message);
						PubblicaActivityText.setTextColor(Color.parseColor("#ffffff"));
						PubblicaActivityText.setShadowLayer(0,0,0,0);
						PubblicaActivityToast.show();
					}
				}
				else {
					
					{
						DisplayMetrics screen = new DisplayMetrics();
						getWindowManager().getDefaultDisplay().getMetrics(screen);
						double dp = 10;
						double logicalDensity = screen.density;
						int px = (int) Math.ceil(dp * logicalDensity);
						Toast PubblicaActivityToast = Toast.makeText(PubblicaActivity.this, "Genera il contatore dei commenti prima!", 2000);
						View PubblicaActivityView = PubblicaActivityToast.getView();
						PubblicaActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
						
						
						TextView PubblicaActivityText = PubblicaActivityView.findViewById(android.R.id.message);
						PubblicaActivityText.setTextColor(Color.parseColor("#ffffff"));
						PubblicaActivityText.setShadowLayer(0,0,0,0);
						PubblicaActivityToast.show();
					}
				}
			}
		});
		
		_GitHub_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				Generato = true;
				progressbar1.setVisibility(View.INVISIBLE);
				checkbox2.setChecked(true);
				edittext4.setHintTextColor(0xFF616161);
				
				{
					DisplayMetrics screen = new DisplayMetrics();
					getWindowManager().getDefaultDisplay().getMetrics(screen);
					double dp = 10;
					double logicalDensity = screen.density;
					int px = (int) Math.ceil(dp * logicalDensity);
					Toast PubblicaActivityToast = Toast.makeText(PubblicaActivity.this, "Paste generato. Copia il link RAW e incollalo sulla casella apposita.", 2000);
					View PubblicaActivityView = PubblicaActivityToast.getView();
					PubblicaActivityView.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)px, Color.parseColor("#424242")));
					
					
					TextView PubblicaActivityText = PubblicaActivityView.findViewById(android.R.id.message);
					PubblicaActivityText.setTextColor(Color.parseColor("#ffffff"));
					PubblicaActivityText.setShadowLayer(0,0,0,0);
					PubblicaActivityToast.show();
				}
				Generatore.setAction(Intent.ACTION_VIEW);
				Generatore.setData(Uri.parse("https://pastefy.app/home"));
				startActivity(Generatore);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_db_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		db.addChildEventListener(_db_child_listener);
	}
	
	private void initializeLogic() {
		
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
		progressbar1.setVisibility(View.INVISIBLE);
	}
	
	public void _Genera(final String _versione) {
		request = new HashMap<>();
		headers = new HashMap<>();
		request.put("title", _versione);
		request.put("content", "0");
		headers.put("Authorization", "Bearer e4xusKs4i2GXB1TnfhJtfCDLkJIJcLk3EB5KKVgVnJiAlygDhvDVHMREjW1y");
		GitHub.setParams(request, RequestNetworkController.REQUEST_BODY);
		GitHub.setHeaders(headers);
		GitHub.startRequestNetwork(RequestNetworkController.POST, "https://pastefy.app/api/v2/paste", "", _GitHub_request_listener);
	}
	
}