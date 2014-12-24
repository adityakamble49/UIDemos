package adityakamble49.uidemos.viewpager;

import adityakamble49.uidemos.fragments.AlbumsFragment;
import adityakamble49.uidemos.fragments.ArtistsFragment;
import adityakamble49.uidemos.fragments.SongsListFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class CustomPageAdapter extends FragmentStatePagerAdapter{

	Fragment fmAlbums,fmArtists,fmSongsList;
	
	public CustomPageAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int item_position) {
		
		if(item_position==0){
			
			if(fmAlbums==null){fmAlbums = new AlbumsFragment();}
			return fmAlbums;
		}
		
		if(item_position==1){
			
			if(fmArtists==null){fmArtists = new ArtistsFragment();}
			return fmArtists;
		}
		
		if(item_position==2){
			
			if(fmSongsList==null){fmSongsList = new SongsListFragment();}
			return fmSongsList;
		}
		
		return null;
	}

	@Override
	public int getCount() {
		
		return 3;
	}

}
