package com.example.keteringapp.ui.pesan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.keteringapp.R;

public class PesCateringKhususActivity extends AppCompatActivity {

    private ImageView khusus1,khusus2,khusus3,khusus4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pes_catering_khusus);

        khusus1 = (ImageView) findViewById(R.id.img_khusus1);
        khusus2 = (ImageView) findViewById(R.id.img_khusus2);
        khusus3 = (ImageView) findViewById(R.id.img_khusus3);
        khusus4 = (ImageView) findViewById(R.id.img_khusus4);

        khusus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(PesCateringKhususActivity.this, Sub_pes_vegetarian.class);
                startActivity(a);
            }
        });
        khusus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(PesCateringKhususActivity.this, Sub_pes__7bulanan.class);
                startActivity(b);
            }
        });
        khusus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(PesCateringKhususActivity.this, Sub_pes_diet.class);
                startActivity(c);
            }
        });
        khusus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(PesCateringKhususActivity.this, Sub_pes__aqiqah.class);
                startActivity(d);
            }
        });


    }
}
