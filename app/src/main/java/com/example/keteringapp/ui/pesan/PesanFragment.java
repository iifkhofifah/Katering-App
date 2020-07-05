package com.example.keteringapp.ui.pesan;

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
import com.example.keteringapp.ui.menu.CateringBoxActivity;
import com.example.keteringapp.ui.menu.CateringKhususActivity;
import com.example.keteringapp.ui.menu.CateringKueActivity;
import com.example.keteringapp.ui.menu.CateringPestaActivity;

public class PesanFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pesan, container, false);

        ImageView img1 = (ImageView) view.findViewById(R.id.pes_pesta);
        ImageView img2 = (ImageView) view.findViewById(R.id.pes_box);
        ImageView img3 = (ImageView) view.findViewById(R.id.pes_khusus);
        ImageView img4 = (ImageView) view.findViewById(R.id.pes_kue);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(getActivity(), PesCateringPestaActivity.class);
                startActivity(e);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f = new Intent(getActivity(), PesCateringBoxActivity.class);
                startActivity(f);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g = new Intent(getActivity(), PesCateringKhususActivity.class);
                startActivity(g);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent h = new Intent(getActivity(), PesCateringKueActivity.class);
                startActivity(h);
            }
        });


        return view;
    }
}