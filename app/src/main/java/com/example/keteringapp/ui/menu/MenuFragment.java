package com.example.keteringapp.ui.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.keteringapp.R;

public class MenuFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        ImageView img1 = (ImageView) view.findViewById(R.id.pesta);
        ImageView img2 = (ImageView) view.findViewById(R.id.box);
        ImageView img3 = (ImageView) view.findViewById(R.id.khusus);
        ImageView img4 = (ImageView) view.findViewById(R.id.kue);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getActivity(), CateringPestaActivity.class);
                startActivity(a);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getActivity(), CateringBoxActivity.class);
                startActivity(b);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(getActivity(), CateringKhususActivity.class);
                startActivity(c);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(getActivity(), CateringKueActivity.class);
                startActivity(d);
            }
        });

        return view;
    }
}