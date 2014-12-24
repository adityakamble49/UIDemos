package adityakamble49.uidemos.toast;

import adityakamble49.uidemos.R;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CustomToast extends ActionBarActivity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//Setting Up Action Bar
		ActionBar abActionBar = getSupportActionBar();
		abActionBar.setTitle(R.string.custom_toast);
		
		//Inflate View
		LayoutInflater liInflator = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		View vCustomToast= liInflator.inflate(R.layout.toast_custom_view, (ViewGroup)findViewById(R.id.V_RL_CustomToastRoot));
		TextView tv = (TextView) vCustomToast.findViewById(R.id.V_TV_CustomTOastMessage);
		tv.setText(R.string.custom_toast);
		
		//Custom Toast
		Toast tCustomToast  = new Toast(this);
		tCustomToast.setDuration(Toast.LENGTH_SHORT);
		tCustomToast.setView(vCustomToast);
		tCustomToast.show();
	
	}
}
