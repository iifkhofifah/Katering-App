package com.example.keteringapp.ui.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.keteringapp.R;

public class CateringPestaActivity extends AppCompatActivity {
    private String mshowPras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catering_pesta);
    }
    private void displayToast(String messege) {
        Toast.makeText(getApplicationContext(), messege,
                Toast.LENGTH_SHORT).show();
    }


    public void showPras1(View view) {
        mshowPras = getString(R.string.prasbiasa);
        displayToast(mshowPras);

    }

    public void showPras2(View view) {
        mshowPras = getString(R.string.prasveg);
        displayToast(mshowPras);
    }


}
