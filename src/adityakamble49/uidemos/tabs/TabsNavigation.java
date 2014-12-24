package adityakamble49.uidemos.tabs;

import adityakamble49.uidemos.R;
import adityakamble49.uidemos.fragments.*;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class TabsNavigation extends ActionBarActivity {

	ListView lvUIList;
	ShareActionProvider sapShareProvider;
	ActionBar abActionBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		
		//Setting Up Action Bar
		abActionBar = getSupportActionBar();
		abActionBar.setTitle("Tabs Navigation");
		abActionBar.setDisplayHomeAsUpEnabled(true);
		abActionBar.setHomeButtonEnabled(true);
		abActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		
		Tab tbAlbums = abActionBar.newTab().setText("Albums")
				.setTabListener(new TabListenerCustom<AlbumsFragment>(this, "albums", AlbumsFragment.class));
		
		abActionBar.addTab(tbAlbums);
		
		Tab tbArtists = abActionBar.newTab().setText("Artists")
				.setTabListener(new TabListenerCustom<ArtistsFragment>(this, "artists", ArtistsFragment.class));
		
		abActionBar.addTab(tbArtists);
		
		Tab tbSongsList = abActionBar.newTab().setText("Songs List")
				.setTabListener(new TabListenerCustom<SongsListFragment>(this, "songs_list", SongsListFragment.class));
		
		abActionBar.addTab(tbSongsList);
		
		
	}

}
