package adityakamble49.uidemos.list;

import java.util.ArrayList;

import adityakamble49.uidemos.R;
import adityakamble49.uidemos.adapters.CustomArrayAdapter;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.ListView;

public class CustomListView extends ActionBarActivity{

	ListView lvCustom;
	CustomArrayAdapter adCustom;
	String[] sColours;
	CustomListItem liCustomListItem;
	ArrayList<CustomListItem> alCustomListItem;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_custom_listview);
		
		//Setting Up Action Bar
		ActionBar abActionBar = getSupportActionBar();
		abActionBar.setTitle(R.string.custom_listview);
		
		//Get Data Sources
		sColours = getResources().getStringArray(R.array.colours_list);
		alCustomListItem = new ArrayList<CustomListItem>();
		for(int i=0; i<100; i++){
			
			liCustomListItem = new CustomListItem();
			liCustomListItem.setTextItem("Item "+i);
			liCustomListItem.setIconImage(R.drawable.red_circle);
			alCustomListItem.add(liCustomListItem);
		}
		
		lvCustom = (ListView) findViewById(R.id.V_LV_CustomListView);
		adCustom = new CustomArrayAdapter(this, R.layout.item_custom_list,alCustomListItem);
		lvCustom.setAdapter(adCustom);
	}
	
}
