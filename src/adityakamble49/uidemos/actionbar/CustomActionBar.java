package adityakamble49.uidemos.actionbar;

import adityakamble49.uidemos.R;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class CustomActionBar extends ActionBarActivity {

	ActionBar abActionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		abActionBar = getSupportActionBar();
		abActionBar.setTitle(R.string.actionbar_custom);
		abActionBar.setSubtitle(R.string.sCustomActionBarSubtitle);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater miInflater = getMenuInflater();
		miInflater.inflate(R.menu.custom_actionbar, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {

		case R.id.menu_change_colour:

			SelectColourDialog();

			break;

		case R.id.menu_toggle:

			if (abActionBar.isShowing()) {

				abActionBar.hide();

			} else {

				abActionBar.show();
			}

		}

		return super.onOptionsItemSelected(item);
	}

	// My Methods
	public void SelectColourDialog() {

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.select_colour).setItems(R.array.colours_list,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						ChangeActionBarColour(which);

					}
				});

		builder.create();
		builder.show();

	}

	private void ChangeActionBarColour(int iColourID) {

		switch (iColourID) {

		case 0:
			abActionBar.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.actionbar_red_bg));
			break;
		case 1:
			abActionBar.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.actionbar_orange_bg));
			break;
		case 2:
			abActionBar.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.actionbar_yellow_bg));
			break;
		case 3:
			abActionBar.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.actionbar_green_bg));
			break;
		case 4:
			abActionBar.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.actionbar_blue_bg));
			break;
		case 5:
			abActionBar.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.actionbar_indigo_bg));
			break;
		case 6:
			abActionBar.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.actionbar_violet_bg));
			break;

		}

	}

}
