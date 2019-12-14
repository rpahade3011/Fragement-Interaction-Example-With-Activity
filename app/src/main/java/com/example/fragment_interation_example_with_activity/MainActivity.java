package com.example.fragment_interation_example_with_activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements FragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Rudraksh", "called onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Rudraksh", "called onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Rudraksh", "called onStop");
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof FragmentA) {
            FragmentA fragmentA = (FragmentA) fragment;
            fragmentA.setOnDataReceived(MainActivity.this);
        }
    }

    @Override
    public void onDataReceived(Object obj) {
        String data = (String) obj;
        Log.d("Rudraksh", "Received data :: "
                + data + " :: from FragmentA to Activity");
        Log.d("Rudraksh", "passing data to FragmentB");
        FragmentB fragmentB = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragmentB);
        if (fragmentB != null) {
            fragmentB.updateTextField(data);
        }
    }
}
