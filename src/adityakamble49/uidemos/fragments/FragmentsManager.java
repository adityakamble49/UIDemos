package adityakamble49.uidemos.fragments;

import adityakamble49.uidemos.HomeActivity;
import adityakamble49.uidemos.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class FragmentsManager extends ActionBarActivity{
	
	
	Fragment fg;
	FragmentManager fm;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Setting Up ActionBar
		ActionBar abActionBar = getSupportActionBar();
		abActionBar.setTitle("Fragments");
		abActionBar.setDisplayHomeAsUpEnabled(true);
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		MenuInflater minflator = getMenuInflater();
		minflator.inflate(R.menu.fragments_manager, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		fm = getSupportFragmentManager();
		
		switch(item.getItemId()){
	
		
		case android.R.id.home:
			
				finish();
			
			break;
		
		
		case R.id.menu_one:
			
			fg = new AlbumsFragment();
			fm.beginTransaction().replace(android.R.id.content, fg).commit();
			
			break;
			
		case R.id.menu_two:
			
			fg = new ArtistsFragment();
			fm.beginTransaction().replace(android.R.id.content, fg).commit();
			
			break;
			
		case R.id.menu_three:
			
			fg = new SongsListFragment();
			fm.beginTransaction().replace(android.R.id.content, fg).commit();
			
			break;
		
		}
		
		return true;
	}

}
