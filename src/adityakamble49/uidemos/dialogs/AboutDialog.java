package adityakamble49.uidemos.dialogs;

import adityakamble49.uidemos.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class AboutDialog extends DialogFragment{

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle(R.string.about).setMessage(R.string.about_ui_demos).setIcon(R.drawable.ic_action_about);
		
		return builder.create();
	}
	
}
