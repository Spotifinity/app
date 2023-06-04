package jk.spotifinity;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
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
import com.mannan.translateapi.*;
import com.tonyodev.fetch2.*;
import com.tonyodev.fetch2core.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class AggiungiActivity extends AppCompatActivity {
	
	private TextView textview1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.aggiungi);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		textview1 = findViewById(R.id.textview1);
	}
	
	private void initializeLogic() {
		
		getWindow().setStatusBarColor(Color.parseColor("#1976d2"));
		getWindow().setNavigationBarColor(Color.parseColor("#000000"));
		getSupportActionBar().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.parseColor("#2196f3")));
		getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.parseColor("#000000")));
		setTitle("Aggiungi");
		setTheme(android.R.style.Theme_Material);
	}
	
}