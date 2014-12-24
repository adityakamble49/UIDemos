package adityakamble49.uidemos.fragments;

import adityakamble49.uidemos.R;
import adityakamble49.uidemos.R.layout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ArtistsFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View vArtistFragment = inflater.inflate(R.layout.fragment_artists, container,false);
		return vArtistFragment;
		
	}

}
