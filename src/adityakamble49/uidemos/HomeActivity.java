package adityakamble49.uidemos;

import adityakamble49.uidemos.dialogs.AboutDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HomeActivity extends ActionBarActivity implements OnItemClickListener {

	//View Components
	ListView lvUIList;
	ArrayAdapter<String> adUIList;
	
	//UI List Data Resource
	String[] sUIList = {"ActionBar Custom","Fragments","ListView Custom","Merge Include",
			"Navigation Drawer","Tabs Navigation","Toast Custom","View Pager","Drop Down Navigation"};
	
	//Object References
	ShareActionProvider sapShareProvider;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		//Set Layout Transaction
		
		
		//Setting Up Action Bar
		ActionBar abActionBar = getSupportActionBar();
		abActionBar.setDisplayHomeAsUpEnabled(false);
		
		//Creating View Components
		lvUIList = (ListView) findViewById(R.id.V_LV_UIList);
		adUIList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sUIList);
		lvUIList.setAdapter(adUIList);
		lvUIList.setOnItemClickListener(this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.home, menu);
		
		//Setup ShareActionProvider
		/*MenuItem miShare = menu.findItem(R.id.menu_share);
		sapShareProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(miShare);
		sapShareProvider.setShareIntent(getDefaultShareIntent());
		*/
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()){
		
		case R.id.menu_about:
			
			DialogFragment dfAbout = new AboutDialog();
			dfAbout.show(getSupportFragmentManager(), "about_dialog");
			
			break;
		
		case R.id.menu_preferences:
			
			ActivityStarter("UIDemosPreferences");
			
			break;
			
		}
		
		return true;
	}

	//Listeners Methods
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		
		switch(position){
		

		case 0: ActivityStarter("actionbar.CustomActionBar");	break;
		case 1: ActivityStarter("fragments.FragmentsManager");	break;
		case 2: ActivityStarter("list.CustomListView");	break;
		case 3: ActivityStarter("merge.MergeInclude");	break;
		case 4: ActivityStarter("drawer.NavigationDrawer");	break;
		case 5: ActivityStarter("tabs.TabsNavigation");	break;
		case 6: ActivityStarter("toast.CustomToast");	break;
		case 7: ActivityStarter("viewpager.ViewPagerDemo");	break;
		case 8: ActivityStarter("dropdown.DropDownNavigation");	break;
		
		
		}
		
		
		
	}
	
	
	//Custom Methods
	private void ActivityStarter(String sActivityName){
		
		try{
			
			Intent itIntent = new Intent("adityakamble49.uidemos."+sActivityName);
			startActivity(itIntent);
			
		}catch(Exception e){
			
			Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	
	private Intent getDefaultShareIntent(){
		
		Intent itSend = new Intent(Intent.ACTION_SEND);
		itSend.setType("image/**");
		return itSend;
	}

}
