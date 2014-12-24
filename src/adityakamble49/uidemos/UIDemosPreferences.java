package adityakamble49.uidemos;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class UIDemosPreferences extends PreferenceActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		addPreferencesFromResource(R.xml.uidemos_preferences);
	}
}
