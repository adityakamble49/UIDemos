package adityakamble49.uidemos.viewpager;

import adityakamble49.uidemos.R;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar.Tab;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ViewPagerDemo extends ActionBarActivity{

	ActionBar abActionBar;
	ViewPager vpViewPager;
	CustomPageAdapter adCustomPage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_pager);
		
		//SettingUp ActionBar
		abActionBar = getSupportActionBar();
		abActionBar.setTitle(R.string.sViewPager);
		abActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		
		/*
		 * Setting Up FragmentStatePageAdapter
		 * This adapter used to attach fragment to view group.
		 */
		adCustomPage = new CustomPageAdapter(getSupportFragmentManager());
		
		/*
		 * SettingUp ViewPager
		 * get resource of view pager from view id
		 * set adapter to view pager so it can load fragments returned by getItem(int item) method from 
		 * FragmentStatePageAdapter
		 * set on page change listener to sync fragment page with ActionBar Tabs
		 */
		vpViewPager = (ViewPager) findViewById(R.id.V_VP_ViewPager);
		vpViewPager.setAdapter(adCustomPage);
		vpViewPager.setOnPageChangeListener( new ViewPager.SimpleOnPageChangeListener(){
			
			@Override
			public void onPageSelected(int position) {
				
					getSupportActionBar().setSelectedNavigationItem(position);
			}
				
		});
		
		
		//Setting Up ActionBar.TabListener
		ActionBar.TabListener tablistener = new TabListener() {
			
			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				
				
			}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				
				vpViewPager.setCurrentItem(tab.getPosition());
				
			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				
			}
		};
		
		//Adding ActionBar Tabs
		Tab tbAlbum = abActionBar.newTab().setText("Albums").setTabListener(tablistener);
		Tab tbArtist = abActionBar.newTab().setText("Artists").setTabListener(tablistener);
		Tab tbSongsList = abActionBar.newTab().setText("Songs List").setTabListener(tablistener);
		abActionBar.addTab(tbAlbum);
		abActionBar.addTab(tbArtist);
		abActionBar.addTab(tbSongsList);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.view_pager, menu);
		
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()){
		
		case android.R.id.home:
			
			finish();
			
			break;
		
		case R.id.menu_tab_toggle:
			
			if(abActionBar.getNavigationMode()==2){
				
					abActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
			}else{
				
				abActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
			}
			
			break;
			
		}
		
		return true;
	}
	
}
