package jk.spotifinity;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.pm.PackageManager;
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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class LinguaActivity extends AppCompatActivity {
	
	private LinearLayout linear3;
	private ScrollView vscroll2;
	private ImageView imageview2;
	private TextView textview1;
	private LinearLayout linear35;
	private TextView textview32;
	private LinearLayout linear5;
	private TextView textview2;
	private TextView textview33;
	private LinearLayout linear37;
	private LinearLayout linear50;
	private TextView textview43;
	private LinearLayout linear54;
	private LinearLayout linear58;
	private LinearLayout linear40;
	private LinearLayout linear41;
	private TextView textview34;
	private LinearLayout linear39;
	private CheckBox it;
	private ImageView imageview3;
	private TextView textview35;
	private LinearLayout linear51;
	private LinearLayout linear52;
	private TextView textview40;
	private LinearLayout linear53;
	private CheckBox en;
	private ImageView imageview6;
	private TextView textview41;
	private ImageView imageview7;
	private TextView textview42;
	private LinearLayout linear55;
	private LinearLayout linear62;
	private TextView textview44;
	private LinearLayout linear57;
	private CheckBox sq;
	private ImageView imageview10;
	private TextView textview48;
	private LinearLayout linear59;
	private LinearLayout linear63;
	private TextView textview46;
	private LinearLayout linear61;
	private CheckBox ru;
	private ImageView imageview12;
	private TextView textview50;
	private ImageView imageview13;
	private TextView textview51;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.lingua);
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
		linear35 = findViewById(R.id.linear35);
		textview32 = findViewById(R.id.textview32);
		linear5 = findViewById(R.id.linear5);
		textview2 = findViewById(R.id.textview2);
		textview33 = findViewById(R.id.textview33);
		linear37 = findViewById(R.id.linear37);
		linear50 = findViewById(R.id.linear50);
		textview43 = findViewById(R.id.textview43);
		linear54 = findViewById(R.id.linear54);
		linear58 = findViewById(R.id.linear58);
		linear40 = findViewById(R.id.linear40);
		linear41 = findViewById(R.id.linear41);
		textview34 = findViewById(R.id.textview34);
		linear39 = findViewById(R.id.linear39);
		it = findViewById(R.id.it);
		imageview3 = findViewById(R.id.imageview3);
		textview35 = findViewById(R.id.textview35);
		linear51 = findViewById(R.id.linear51);
		linear52 = findViewById(R.id.linear52);
		textview40 = findViewById(R.id.textview40);
		linear53 = findViewById(R.id.linear53);
		en = findViewById(R.id.en);
		imageview6 = findViewById(R.id.imageview6);
		textview41 = findViewById(R.id.textview41);
		imageview7 = findViewById(R.id.imageview7);
		textview42 = findViewById(R.id.textview42);
		linear55 = findViewById(R.id.linear55);
		linear62 = findViewById(R.id.linear62);
		textview44 = findViewById(R.id.textview44);
		linear57 = findViewById(R.id.linear57);
		sq = findViewById(R.id.sq);
		imageview10 = findViewById(R.id.imageview10);
		textview48 = findViewById(R.id.textview48);
		linear59 = findViewById(R.id.linear59);
		linear63 = findViewById(R.id.linear63);
		textview46 = findViewById(R.id.textview46);
		linear61 = findViewById(R.id.linear61);
		ru = findViewById(R.id.ru);
		imageview12 = findViewById(R.id.imageview12);
		textview50 = findViewById(R.id.textview50);
		imageview13 = findViewById(R.id.imageview13);
		textview51 = findViewById(R.id.textview51);
		
		it.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				it.setChecked(true);
			}
		});
		
		it.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt", "it");
				textview1.setText("Seleziona lingua");
				textview2.setText("Seleziona una lingua tra questi sotto. La lingua selezionata verrà visualizzata su tutta l'app.\nSe alcune stringe dell'app non sono tradotte vengono visualizzate in italiano.");
				textview35.setText("Lingua di default");
				textview33.setText("Predefinite");
				textview43.setText("Tutte le lingue");
				textview32.setText("BETA");
				en.setChecked(false);
				sq.setChecked(false);
				ru.setChecked(false);
			}
		});
		
		en.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				en.setChecked(true);
			}
		});
		
		en.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt", "en");
				textview1.setText("Select language");
				textview2.setText("Select a language from these below. The selected language will be displayed throughout the app.\nIf some app strings are not translated, they are displayed in Italian.");
				textview35.setText("Default language");
				textview33.setText("Defaults");
				textview43.setText("All languages");
				textview32.setText("BETA");
				it.setChecked(false);
				sq.setChecked(false);
				ru.setChecked(false);
			}
		});
		
		sq.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sq.setChecked(true);
			}
		});
		
		sq.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt", "sq");
				textview1.setText("Zgjidh gjuhen");
				textview2.setText("Zgjidhni një gjuhë nga këto më poshtë. Gjuha e zgjedhur do të shfaqet në të gjithë aplikacionin.\nNëse disa vargje aplikacionesh nuk përkthehen, ato shfaqen në italisht.");
				textview35.setText("Gjuha e parazgjedhur");
				textview33.setText("E paracaktuar");
				textview43.setText("Të gjitha gjuhët");
				textview32.setText("BETA");
				it.setChecked(false);
				en.setChecked(false);
				ru.setChecked(false);
			}
		});
		
		ru.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ru.setChecked(true);
			}
		});
		
		ru.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				FileUtil.writeFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt", "ru");
				textview1.setText("Выберите язык");
				textview2.setText("Выберите язык из списка ниже. Выбранный язык будет отображаться во всем приложении.\nЕсли некоторые строки приложения не переведены, они отображаются на итальянском языке.");
				textview35.setText("Язык по умолчанию");
				textview33.setText("По умолчанию");
				textview43.setText("Все языки");
				textview32.setText("БЕТА");
				en.setChecked(false);
				it.setChecked(false);
				sq.setChecked(false);
			}
		});
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
		
		DisplayMetrics linear41Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear41Screen);
		double linear41DP = 10;
		double linear41LogicalDensity = linear41Screen.density;
		int linear41PX = (int) Math.ceil(linear41DP * linear41LogicalDensity);
		linear41.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#1BA8F0")); return this; } }.getIns((int)linear41PX, (int)0));
		linear41.setElevation(0);
		linear41.setTranslationZ(0);
		
		DisplayMetrics linear37Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear37Screen);
		double linear37DP = 10;
		double linear37LogicalDensity = linear37Screen.density;
		int linear37PX = (int) Math.ceil(linear37DP * linear37LogicalDensity);
		linear37.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear37PX, (int)0));
		linear37.setElevation(0);
		linear37.setTranslationZ(0);
		
		DisplayMetrics linear50Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear50Screen);
		double linear50DP = 10;
		double linear50LogicalDensity = linear50Screen.density;
		int linear50PX = (int) Math.ceil(linear50DP * linear50LogicalDensity);
		linear50.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear50PX, (int)0));
		linear50.setElevation(0);
		linear50.setTranslationZ(0);
		
		DisplayMetrics linear54Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear54Screen);
		double linear54DP = 10;
		double linear54LogicalDensity = linear54Screen.density;
		int linear54PX = (int) Math.ceil(linear54DP * linear54LogicalDensity);
		linear54.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear54PX, (int)0));
		linear54.setElevation(0);
		linear54.setTranslationZ(0);
		
		DisplayMetrics linear58Screen = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(linear58Screen);
		double linear58DP = 10;
		double linear58LogicalDensity = linear58Screen.density;
		int linear58PX = (int) Math.ceil(linear58DP * linear58LogicalDensity);
		linear58.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setStroke(b, Color.parseColor("#000000")); this.setColor(Color.parseColor("#212121")); return this; } }.getIns((int)linear58PX, (int)0));
		linear58.setElevation(0);
		linear58.setTranslationZ(0);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		_AggiornaLingua();
		if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("it")) {
			it.setChecked(true);
		}
		else {
			if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("en")) {
				en.setChecked(true);
			}
			else {
				if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("sq")) {
					sq.setChecked(true);
				}
				else {
					if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("ru")) {
						ru.setChecked(true);
					}
					else {
						
					}
				}
			}
		}
	}
	public void _AggiornaLingua() {
		if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("it")) {
			textview1.setText("Seleziona lingua");
			textview2.setText("Seleziona una lingua tra questi sotto. La lingua selezionata verrà visualizzata su tutta l'app.\nSe alcune stringe dell'app non sono tradotte vengono visualizzate in italiano.");
			textview35.setText("Lingua di default");
			textview33.setText("Predefinite");
			textview43.setText("Tutte le lingue");
			textview32.setText("BETA");
		}
		else {
			if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("en")) {
				textview1.setText("Select language");
				textview2.setText("Select a language from these below. The selected language will be displayed throughout the app.\nIf some app strings are not translated, they are displayed in Italian.");
				textview35.setText("Default language");
				textview33.setText("Defaults");
				textview43.setText("All languages");
				textview32.setText("BETA");
			}
			else {
				if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("sq")) {
					textview1.setText("Zgjidh gjuhen");
					textview2.setText("Zgjidhni një gjuhë nga këto më poshtë. Gjuha e zgjedhur do të shfaqet në të gjithë aplikacionin.\nNëse disa vargje aplikacionesh nuk përkthehen, ato shfaqen në italisht.");
					textview35.setText("Gjuha e parazgjedhur");
					textview33.setText("E paracaktuar");
					textview43.setText("Të gjitha gjuhët");
					textview32.setText("BETA");
				}
				else {
					if (FileUtil.readFile("storage/emulated/0/Android/data/jk.spotifinity/Impostazioni/Lingua/sel.txt").equals("ru")) {
						textview1.setText("Выберите язык");
						textview2.setText("Выберите язык из списка ниже. Выбранный язык будет отображаться во всем приложении.\nЕсли некоторые строки приложения не переведены, они отображаются на итальянском языке.");
						textview35.setText("Язык по умолчанию");
						textview33.setText("По умолчанию");
						textview43.setText("Все языки");
						textview32.setText("БЕТА");
					}
					else {
						
					}
				}
			}
		}
	}
	
}