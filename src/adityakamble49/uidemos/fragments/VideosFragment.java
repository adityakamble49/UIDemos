package adityakamble49.uidemos.fragments;

import adityakamble49.uidemos.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class VideosFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View vVideosFragment = inflater.inflate(R.layout.fragment_videos, container, false);
		return vVideosFragment;
		
	}
}
