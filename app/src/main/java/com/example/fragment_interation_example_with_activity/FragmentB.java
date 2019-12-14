package com.example.fragment_interation_example_with_activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {

    private TextView updateText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View myFragmentBView = inflater.inflate(R.layout.fragment_b_layout,
                container, false);
        updateText = myFragmentBView.findViewById(R.id.text_update);
        return myFragmentBView;
    }

    public void updateTextField(String newText) {
        updateText.setText(newText);
    }
}
