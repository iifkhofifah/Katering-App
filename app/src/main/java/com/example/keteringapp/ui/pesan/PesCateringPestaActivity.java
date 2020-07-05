package com.example.keteringapp.ui.pesan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.keteringapp.R;

import java.util.Calendar;

public class PesCateringPestaActivity extends AppCompatActivity {
    TextView tvtgl;
    EditText ettgl,etnama,etnohp,etalamat;
    CheckBox cbp1,cbp2,cbp3,cbp4;
    Spinner sppras;
    Button Simpan;
    DatePickerDialog.OnDateSetListener setListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pes_catering_pesta);

        tvtgl = findViewById(R.id.tv_tanggal);
        ettgl = findViewById(R.id.et_tanggal);
        ettgl = findViewById(R.id.et_tanggal);
        etnama = findViewById(R.id.et_nama);
        etalamat = findViewById(R.id.et_alamat);
        etnohp = findViewById(R.id.et_wa);
        cbp1 = findViewById(R.id.siomay);
        cbp2 = findViewById(R.id.bakso);
        cbp3 = findViewById(R.id.icecream);
        cbp4 = findViewById(R.id.sopbuah);
        sppras = findViewById(R.id.pkt_pras);
        Simpan = findViewById(R.id.simpan);


        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        tvtgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        PesCateringPestaActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        , setListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                tvtgl.setText(date);
            }
        };
        ettgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        PesCateringPestaActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = day + "/" + month + "/" + year;
                        ettgl.setText(date);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        Simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vNama = etnama.getText().toString();
                String vNohp = etnohp.getText().toString();
                String vAlamat = etalamat.getText().toString();
                String Sppes = String.valueOf(sppras.getSelectedItem());
                String vTanggal = ettgl.getText().toString();
                String vPiltam = "";

                if (cbp1.isChecked()){
                    vPiltam += "Siomay \n";
                }
                if (cbp2.isChecked()){
                    vPiltam += "Bakso \n";
                }
                if (cbp3.isChecked()){
                    vPiltam += "Ice Cream \n";
                }
                if (cbp4.isChecked()){
                    vPiltam += "Sop Buah \n";
                }


                Intent Pesta = new Intent(PesCateringPestaActivity.this, ValuePestaActivity.class);
                Pesta.putExtra("extraNama", vNama);
                Pesta.putExtra("extraNohp", vNohp);
                Pesta.putExtra("extraAlamat", vAlamat);
                Pesta.putExtra("extraSppes", Sppes);
                Pesta.putExtra("extraTanggal", vTanggal);
                Pesta.putExtra("extraPiltam", vPiltam);

                startActivity(Pesta);
            }
        });



    }

}
