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
import com.google.android.material.button.*;
import com.google.firebase.FirebaseApp;
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
import java.io.*;
import java.io.File;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class AggiungiActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private HashMap<String, Object> gitPath = new HashMap<>();
	private HashMap<String, Object> gitBody = new HashMap<>();
	private HashMap<String, Object> gitHeaders = new HashMap<>();
	private HashMap<String, Object> pastefy = new HashMap<>();
	private String LinkApk = "";
	private HashMap<String, Object> mappaMod = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> list = new ArrayList<>();
	private ArrayList<String> lista = new ArrayList<>();
	
	private LinearLayout linear3;
	private ScrollView vscroll1;
	private ImageView imageview2;
	private TextView textview1;
	private LinearLayout linear1;
	private EditText edittext1;
	private EditText edittext2;
	private MaterialButton materialbutton1;
	private TextView textview2;
	private LinearLayout linear4;
	private TextView textview4;
	private EditText edittext3;
	private CheckBox checkbox1;
	private MaterialButton materialbutton2;
	private ProgressBar progressbar1;
	private TextView textview3;
	private ProgressBar progressbar2;
	private MaterialButton materialbutton3;
	
	private RequestNetwork GitHub;
	private RequestNetwork.RequestListener _GitHub_request_listener;
	private StorageReference acio = _firebase_storage.getReference("mod");
	private OnCompleteListener<Uri> _acio_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _acio_download_success_listener;
	private OnSuccessListener _acio_delete_success_listener;
	private OnProgressListener _acio_upload_progress_listener;
	private OnProgressListener _acio_download_progress_listener;
	private OnFailureListener _acio_failure_listener;
	
	private Intent intent = new Intent();
	private AlertDialog.Builder elimina;
	private DatabaseReference db = _firebase.getReference("mod/");
	private ChildEventListener _db_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.aggiungi);
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
		vscroll1 = findViewById(R.id.vscroll1);
		imageview2 = findViewById(R.id.imageview2);
		textview1 = findViewById(R.id.textview1);
		linear1 = findViewById(R.id.linear1);
		edittext1 = findViewById(R.id.edittext1);
		edittext2 = findViewById(R.id.edittext2);
		materialbutton1 = findViewById(R.id.materialbutton1);
		textview2 = findViewById(R.id.textview2);
		linear4 = findViewById(R.id.linear4);
		textview4 = findViewById(R.id.textview4);
		edittext3 = findViewById(R.id.edittext3);
		checkbox1 = findViewById(R.id.checkbox1);
		materialbutton2 = findViewById(R.id.materialbutton2);
		progressbar1 = findViewById(R.id.progressbar1);
		textview3 = findViewById(R.id.textview3);
		progressbar2 = findViewById(R.id.progressbar2);
		materialbutton3 = findViewById(R.id.materialbutton3);
		GitHub = new RequestNetwork(this);
		elimina = new AlertDialog.Builder(this);
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				materialbutton1.startAnimation(fade_in);
				String apkFile = "storage/emulated/0/ExtractedApks/Spotify_com.spotify.music/Spotify_base.apk";
				    java.io.File file = new java.io.File(apkFile);
				    if(file.exists()) {
						        Intent intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(uriFromFile(getApplicationContext(), new java.io.File(apkFile)), "application/vnd.android.package-archive");
						        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
						        try {
								            getApplicationContext().startActivity(intent);
								        } catch (ActivityNotFoundException e) {
								            e.printStackTrace();
								            Log.e("TAG", "Error in opening the file!");
								        }
						    }else{
						        Toast.makeText(getApplicationContext(),"File not found !" + "ملف غير موجود",Toast.LENGTH_LONG).show();
						    }
			}
			
			
			Uri uriFromFile(Context context, java.io.File file) {
				    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
						        return androidx.core.content.FileProvider.getUriForFile(context,context.getApplicationContext().getPackageName() + ".provider", file); 
						    } else {
						        return Uri.fromFile(file);
						    }
			}
		});
		
		materialbutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				materialbutton2.startAnimation(fade_in);
				if (!edittext3.getText().toString().equals("")) {
					mappaMod = new HashMap<>();
					mappaMod.put("Versione", edittext1.getText().toString().replace(".", "_"));
					mappaMod.put("Novità", edittext2.getText().toString());
					mappaMod.put("Link", edittext3.getText().toString());
					db.push().updateChildren(mappaMod);
					if (checkbox1.isChecked()) {
						textview3.setText("Costruzione parametri...");
						pastefy = new HashMap<>();
						pastefy.put("content", edittext1.getText().toString());
						textview3.setText("Impostando le richieste...");
						GitHub.setParams(pastefy, RequestNetworkController.REQUEST_BODY);
						pastefy = new HashMap<>();
						pastefy.put("Authorization", "Bearer e4xusKs4i2GXB1TnfhJtfCDLkJIJcLk3EB5KKVgVnJiAlygDhvDVHMREjW1y");
						textview3.setText("Invio le richieste su GitHub...");
						GitHub.setHeaders(pastefy);
						GitHub.startRequestNetwork(RequestNetworkController.PUT, "https://pastefy.ga/api/v2/paste/3DjQQQZG", "", _GitHub_request_listener);
					}
					else {
						progressbar1.setVisibility(View.INVISIBLE);
						textview3.setText("Sono pronto capitano!");
						SketchwareUtil.showMessage(getApplicationContext(), "Fatto");
					}
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Genera il link prima!");
				}
			}
		});
		
		materialbutton3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
				fade_in.setDuration(300);
				fade_in.setFillAfter(true);
				materialbutton3.startAnimation(fade_in);
				acio.child("mod.apk").putFile(Uri.fromFile(new File("storage/emulated/0/ExtractedApks/Spotify_com.spotify.music/Spotify_base.apk"))).addOnFailureListener(_acio_failure_listener).addOnProgressListener(_acio_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return acio.child("mod.apk").getDownloadUrl();
					}}).addOnCompleteListener(_acio_upload_success_listener);
				textview3.setText("Generazione link...");
				progressbar2.setVisibility(View.VISIBLE);
			}
		});
		
		_GitHub_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				progressbar1.setVisibility(View.INVISIBLE);
				SketchwareUtil.showMessage(getApplicationContext(), "Finito");
				textview3.setText("Finito ");
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				SketchwareUtil.showMessage(getApplicationContext(), _message);
				progressbar1.setVisibility(View.INVISIBLE);
				textview3.setText("Finito con errori (GitHub: ".concat(_message.concat(")")));
			}
		};
		
		_acio_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				progressbar1.setProgress((int)_progressValue);
			}
		};
		
		_acio_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_acio_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				progressbar2.setVisibility(View.INVISIBLE);
				textview3.setText("Sono pronto capitano!");
				textview4.setVisibility(View.VISIBLE);
				edittext3.setText(_downloadUrl.replace(".", "_"));
				SketchwareUtil.showMessage(getApplicationContext(), "Link generato!");
			}
		};
		
		_acio_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_acio_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_acio_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_db_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				db.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						list = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								list.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						
						
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
				db.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						list = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								list.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						
						
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
				db.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						list = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								list.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						
						
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
		db.addChildEventListener(_db_child_listener);
	}
	
	private void initializeLogic() {
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		edittext1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		materialbutton1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		materialbutton2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		materialbutton3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		edittext1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extra_bold.ttf"), 0);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		edittext2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		progressbar2.setVisibility(View.INVISIBLE);
		textview4.setVisibility(View.INVISIBLE);
	}
	
}