package adityakamble49.uidemos.dropdown;

import adityakamble49.uidemos.R;
import adityakamble49.uidemos.fragments.AlbumsFragment;
import adityakamble49.uidemos.fragments.ArtistsFragment;
import adityakamble49.uidemos.fragments.SongsListFragment;
import adityakamble49.uidemos.fragments.VideosFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

public class DropDownNavigation extends ActionBarActivity {

	// View Object References
	private ActionBar actionBar;
	private SpinnerAdapter spinnerAdapter;
	private OnNavigationListener onNavigationListener;

	// object References

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setupActionBar();
		setupDropDownList();
	}

	// Action bar Setup
	private void setupActionBar() {

		actionBar = this.getSupportActionBar();
		actionBar.setTitle("Drop Down List");
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

	}

	// DropDownList Setup
	private void setupDropDownList() {
		
		spinnerAdapter = ArrayAdapter.createFromResource(this,
				R.array.media_types,
				R.layout.drawer_list_item);

		// Implementing OnNavigatopnListener
		onNavigationListener = new OnNavigationListener() {

			String[] monthNames = getResources().getStringArray(
					R.array.media_types);

			@Override
			public boolean onNavigationItemSelected(int position, long itemid) {

				FragmentTransaction ft = getSupportFragmentManager()
						.beginTransaction();
				Fragment fmFragment;

				switch (position) {

				case 0:
					fmFragment = new AlbumsFragment();
					ft.replace(android.R.id.content, fmFragment);
					break;
				case 1:
					fmFragment = new ArtistsFragment();
					ft.replace(android.R.id.content, fmFragment);
					break;
				case 2:
					fmFragment = new SongsListFragment();
					ft.replace(android.R.id.content, fmFragment);
					break;
				case 3:
					fmFragment = new VideosFragment();
					ft.replace(android.R.id.content, fmFragment);
					break;

				}

				ft.commit();
				
				return true;
			}
		};
		
		actionBar.setListNavigationCallbacks(spinnerAdapter,onNavigationListener);
	}

}
