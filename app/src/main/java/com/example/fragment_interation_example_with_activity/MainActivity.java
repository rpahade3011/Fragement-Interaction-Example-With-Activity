package com.example.fragment_interation_example_with_activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements FragmentListener {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "called onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "called onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "called onStop");
    }

    /**
     * Sets the interface listener when the fragment A is attached to its view
     * @param fragment Fragment - requires a fragment
     */
    @Override
    public void onAttachFragment(Fragment fragment) {
        // Checking the instance of FragmentA so that our listener should
        // receive the data in onDataReceived()
        if (fragment instanceof FragmentA) {
            FragmentA fragmentA = (FragmentA) fragment;
            fragmentA.setOnDataReceived(MainActivity.this);
        }
    }

    @Override
    public void onDataReceived(Object obj) {
        // Data is received from FragmentA to MainActivity and
        // sending this FragmentA data to FragmentB
        String data = (String) obj;
        Log.d(TAG, "Received data :: "
                + data + " :: from FragmentA to Activity");
        Log.d(TAG, "passing data to FragmentB");
        FragmentB fragmentB = (FragmentB) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentB);
        if (fragmentB != null) {
            fragmentB.updateTextField(data);
        }
    }
}
