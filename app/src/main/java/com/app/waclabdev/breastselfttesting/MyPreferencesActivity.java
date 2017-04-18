package com.app.waclabdev.breastselfttesting;

/**
 * Created by waclabdev on 14.04.17.
 */
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.widget.Toast;

// preferences saved in SharedPreferences
public class MyPreferencesActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
    }

    public static class MyPreferenceFragment extends PreferenceFragment
    {
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);

//            SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
//            Toast.makeText(getActivity(),sharedPrefs.getString("username", "N/A"), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPause() {
            super.onPause();
//            Toast.makeText(getActivity(),"You may need to restart app to make changes", Toast.LENGTH_LONG).show();
        }
    }

}