package adityakamble49.uidemos.adapters;

import java.util.List;

import adityakamble49.uidemos.R;
import adityakamble49.uidemos.list.CustomListItem;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomArrayAdapter extends ArrayAdapter<CustomListItem>{

	
	Context context;
	int iCustomLayoutID;
	List<CustomListItem> ltDataSources;
	
	public CustomArrayAdapter(Context context, int resource, List<CustomListItem> objects) {
		super(context, resource, objects);
		
		this.context = context;
		iCustomLayoutID = resource;
		ltDataSources = objects;
		
	}
	
	private class ViewHolder{
		
		ImageView ivIconImage;
		TextView tvTextItem;
		
		public ViewHolder(View vSingleItem) {
			
			//Get TextView From That Single Layout
			ivIconImage = (ImageView) vSingleItem.findViewById(R.id.V_IV_IconImage);
			tvTextItem = (TextView) vSingleItem.findViewById(R.id.V_TV_TextItem);
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		//Create View References
		View vSingleItem = convertView;
		ViewHolder vhHolder = null;
		
		//Get Data Resources
		CustomListItem ciItem = ltDataSources.get(position);
		
		if(vSingleItem == null){
			
			//Get Single Item View
			LayoutInflater liInflator = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			vSingleItem= liInflator.inflate(iCustomLayoutID,null);
			vhHolder = new ViewHolder(vSingleItem);
			vSingleItem.setTag(vhHolder);
			
		}else{
			
			vhHolder = (ViewHolder) vSingleItem.getTag();
		}
		
		//Set Data Resources To Views
		vhHolder.tvTextItem.setText(ciItem.getTextItem());
		vhHolder.ivIconImage.setImageResource(ciItem.getIconImage());
		
		return vSingleItem;
	}

}
