package adityakamble49.uidemos.tabs;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;

public class TabListenerCustom<T extends Fragment> implements ActionBar.TabListener{

	//Object References
	private Fragment fmFragment;
	private Activity avActivity;
	private String sTag;
	private Class<T> clClass;
	
	public TabListenerCustom(Activity avParentActivity , String sTag , Class<T> clClass) {
		
		this.avActivity = avParentActivity;
		this.sTag = sTag;
		this.clClass = clClass;
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		
		if(fmFragment == null){
			
			//Create Fragment and add to content
			fmFragment = Fragment.instantiate(avActivity, clClass.getName());
			ft.add(android.R.id.content,fmFragment,sTag);
			
			
		}else{
			
			//No need of Creation of Fragment , Just attach to view
			ft.attach(fmFragment);
		}
		
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		
		ft.detach(fmFragment);
		
	}
	
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		
	}
	
	
	

}
