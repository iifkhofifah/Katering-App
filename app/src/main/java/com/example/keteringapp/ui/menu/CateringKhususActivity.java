package com.example.keteringapp.ui.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.keteringapp.R;

public class CateringKhususActivity extends AppCompatActivity {
    private String mshowKhusus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catering_khusus);
    }
    private void displayToast(String messege) {
        Toast.makeText(getApplicationContext(), messege,
                Toast.LENGTH_SHORT).show();
    }

    public void showKhusus1(View view) {
        mshowKhusus = getString(R.string.khuveg);
        displayToast(mshowKhusus);
    }

    public void showKhusus2(View view) {
        mshowKhusus = getString(R.string.khubln);
        displayToast(mshowKhusus);
    }

    public void showKhusus3(View view) {
        mshowKhusus = getString(R.string.khudiet);
        displayToast(mshowKhusus);
    }

    public void showKhusus4(View view) {
        mshowKhusus = getString(R.string.khuaqiqah);
        displayToast(mshowKhusus);
    }
}
