package com.example.keteringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailInfoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_info);


        // Initialize the views.
        TextView CateringTitle = findViewById(R.id.titleDetail);
        TextView descatering = findViewById(R.id.subTitleDetail);
        TextView Judulcatering = findViewById(R.id.titleDetail);
        ImageView CateringImage = findViewById(R.id.foodImageDetail);

        // Set the text from the Intent extra.
        CateringTitle.setText(getIntent().getStringExtra("title"));

        // Load the image using the Glide library and the Intent extra.
        Glide.with(this)
                .load(getIntent()
                        .getIntExtra("image_resource",0))
                .into(CateringImage);
        String Title = (Judulcatering.getText().toString());

        switch (Title){
            case "Catering Pesta":
                descatering.setText(R.string.des_catering_pesta);
                break;
            case "Catering Box":
                descatering.setText(R.string.des_catering_box);
                break;
            case "Catering Khusus":
                descatering.setText(R.string.des_catering_khusus);
                break;
            case "Catering Khusus Diet":
                descatering.setText(R.string.des_catering_khusus_diet);
                break;
            case "Catering Khusus Vegetarian":
                descatering.setText(R.string.des_catering_vegetarian);
                break;
            case "Catering Khusus Aqiqah":
                descatering.setText(R.string.des_catering_khusus_aqiqah);
                break;
            case "Catering Khusus 7 Bulanan":
                descatering.setText(R.string.des_catering_7bulanan);
                break;
            default:
                descatering.setText(R.string.des_catering_kue);
                break;
        }
    }
}
