package adityakamble49.uidemos.drawer;

import adityakamble49.uidemos.R;
import adityakamble49.uidemos.fragments.AlbumsFragment;
import adityakamble49.uidemos.fragments.ArtistsFragment;
import adityakamble49.uidemos.fragments.SongsListFragment;
import adityakamble49.uidemos.fragments.VideosFragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NavigationDrawer extends ActionBarActivity {

	// View Components
	DrawerLayout dlDrawerLayout;
	ListView lvDrawerList;
	Fragment fgFragment;
	FragmentManager fmManager;

	// Object References
	CharSequence sTitle, sDrawerTitle;
	String[] sDrawerItems = { "Albums", "Artists", "Songs List", "Videos" };
	ArrayAdapter<String> adDrawerAdapter;
	ActionBarDrawerToggle adtToogle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawer_layout);

		// Setup ActionBar
		ActionBar abActionBar = getSupportActionBar();
		abActionBar.setDisplayHomeAsUpEnabled(true);
		abActionBar.setHomeButtonEnabled(true);
		sTitle = sDrawerTitle = "Navigation Drawer";

		// Setup Drawer Layout
		dlDrawerLayout = (DrawerLayout) findViewById(R.id.V_DL_DrawerLayout);

		// Setting Up Drawer List
		lvDrawerList = (ListView) findViewById(R.id.V_LV_NavigationList);
		adDrawerAdapter = new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, sDrawerItems);
		lvDrawerList.setAdapter(adDrawerAdapter);
		lvDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		// Setting Up ActionBarDrawerToogle
		adtToogle = new ActionBarDrawerToggle(this, dlDrawerLayout,
				R.drawable.ic_drawer, R.string.sDrawerOpen,
				R.string.sDrawerClose) {

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				getSupportActionBar().setTitle(sDrawerTitle);
				supportInvalidateOptionsMenu();
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				getSupportActionBar().setTitle(sTitle);
				supportInvalidateOptionsMenu();
			}
		};

		// Set Created Toggle As Drawer Listener
		dlDrawerLayout.setDrawerListener(adtToogle);
		if (savedInstanceState == null) {

			selectItem(0);
		}

	}

	@Override
	public void setTitle(CharSequence title) {

		sTitle = title;
		getSupportActionBar().setTitle(sTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater miInflater = getMenuInflater();
		miInflater.inflate(R.menu.home, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {

		boolean bDrawerOpen = dlDrawerLayout.isDrawerOpen(lvDrawerList);
		menu.findItem(R.id.menu_about).setVisible(!bDrawerOpen);
		menu.findItem(R.id.menu_search).setVisible(!bDrawerOpen);
		menu.findItem(R.id.menu_settings).setVisible(!bDrawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (adtToogle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {

			selectItem(position);

		}

	}

	private void selectItem(int iPosition) {

		fmManager = getSupportFragmentManager();
		getSupportActionBar().setTitle(sDrawerItems[iPosition]);

		switch (iPosition) {

		case 0:

			fgFragment = new AlbumsFragment();
			fmManager.beginTransaction()
					.replace(R.id.V_FL_FrameCompoent, fgFragment).commit();

			break;

		case 1:

			fgFragment = new ArtistsFragment();
			fmManager.beginTransaction()
					.replace(R.id.V_FL_FrameCompoent, fgFragment).commit();

			break;

		case 2:

			fgFragment = new SongsListFragment();
			fmManager.beginTransaction()
					.replace(R.id.V_FL_FrameCompoent, fgFragment).commit();

			break;

		case 3:

			fgFragment = new VideosFragment();
			fmManager.beginTransaction()
					.replace(R.id.V_FL_FrameCompoent, fgFragment).commit();

			break;

		}

		lvDrawerList.setItemChecked(iPosition, true);
		setTitle(sDrawerItems[iPosition]);
		dlDrawerLayout.closeDrawer(lvDrawerList);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		adtToogle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		adtToogle.onConfigurationChanged(newConfig);
	}

}
