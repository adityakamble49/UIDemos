package adityakamble49.uidemos.dialogs;

import adityakamble49.uidemos.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class SelectColourDialog extends DialogFragment {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle(R.string.select_colour).setItems(R.array.colours_list, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				switch(which){
				
				case 0:	Toast.makeText(getActivity(), "Red", Toast.LENGTH_SHORT).show();	break;
				case 1:	Toast.makeText(getActivity(), "Orange", Toast.LENGTH_SHORT).show();	break;
				case 2:	Toast.makeText(getActivity(), "Yellow", Toast.LENGTH_SHORT).show();	break;
				case 3:	Toast.makeText(getActivity(), "Green", Toast.LENGTH_SHORT).show();	break;
				case 4:	Toast.makeText(getActivity(), "Blue", Toast.LENGTH_SHORT).show();	break;
				case 5:	Toast.makeText(getActivity(), "Indigo", Toast.LENGTH_SHORT).show();	break;
				case 6:	Toast.makeText(getActivity(), "Violet", Toast.LENGTH_SHORT).show();	break;
				
				}
				
			}
		});
		
		return builder.create();
		
	}
}
