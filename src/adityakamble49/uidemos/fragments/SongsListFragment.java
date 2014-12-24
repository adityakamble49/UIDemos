package adityakamble49.uidemos.fragments;

import adityakamble49.uidemos.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SongsListFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View vSongsListFragment = inflater.inflate(R.layout.fragment_songslist, container,false);
		return vSongsListFragment;
		
	}

}
