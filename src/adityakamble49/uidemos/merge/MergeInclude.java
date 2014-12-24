package adityakamble49.uidemos.merge;

import adityakamble49.uidemos.R;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

public class MergeInclude extends ActionBarActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.merge_includes);
		
		ActionBar abActionBar = getSupportActionBar();
		abActionBar.setTitle("Merge Include");
		abActionBar.setDisplayHomeAsUpEnabled(true);
		
	}

}
