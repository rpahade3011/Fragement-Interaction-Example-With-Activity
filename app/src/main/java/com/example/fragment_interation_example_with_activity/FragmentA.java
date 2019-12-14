package com.example.fragment_interation_example_with_activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {

    private FragmentListener fragmentListener;
    private Button sendDataBtn = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View myFragmentAView = inflater.inflate(R.layout.fragment_a_layout,
                container, false);

        sendDataBtn = myFragmentAView.findViewById(R.id.buttonSendData);
        sendDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentListener != null) {
                    fragmentListener.onDataReceived("Hello from FragmentA");
                }
            }
        });

        return myFragmentAView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentListener = null;
    }

    /**
     * Sets the FragmentListener instance
     * @param listener FragmentListener
     */
    public void setOnDataReceived(FragmentListener listener) {
        fragmentListener = listener;
    }
}
