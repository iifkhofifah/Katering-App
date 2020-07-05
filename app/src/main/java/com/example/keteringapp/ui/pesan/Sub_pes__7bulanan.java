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
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.keteringapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Sub_pes__7bulanan extends AppCompatActivity {
    TextView tvtgl;
    EditText ettgl,etnama,etnohp,etalamat;
    Button btn_plus;
    Button btn_min;
    Button Simpan;
    Spinner spnubulan;
    Integer valuejumlah = 0;
    TextView tv_angka;
    DatePickerDialog.OnDateSetListener setListener;
    private DatabaseReference databasegetpesbln;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        databasegetpesbln = FirebaseDatabase.getInstance().getReference("pembln");

        setContentView(R.layout.activity_sub_pes__7bulanan);
        tvtgl = findViewById(R.id.tv_tanggal);
        ettgl = findViewById(R.id.et_tanggal);
        etnama = findViewById(R.id.et_nama);
        etalamat = findViewById(R.id.et_alamat);
        etnohp = findViewById(R.id.et_wa);
        spnubulan = findViewById(R.id.pil_amblantar);
        btn_plus = findViewById(R.id.plus);
        btn_min = findViewById(R.id.min);
        tv_angka = findViewById(R.id.angka);
        Simpan = findViewById(R.id.simpan);

        if (savedInstanceState != null) {
            String nilaiSaved = savedInstanceState.getString("nilai");
            tv_angka.setText(nilaiSaved);
        }

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        tvtgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Sub_pes__7bulanan.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth
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
                        Sub_pes__7bulanan.this, new DatePickerDialog.OnDateSetListener() {
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
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuejumlah += 1;
                tv_angka.setText(valuejumlah.toString());
            }
        });
        btn_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valuejumlah > 1){
                    valuejumlah -= 1;
                    tv_angka.setText(valuejumlah.toString());
                }
            }
        });

        Simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getpesbln();
                String vNama = etnama.getText().toString();
                String vNohp = etnohp.getText().toString();
                String vAlamat = etalamat.getText().toString();
                String spNubulan = String.valueOf(spnubulan.getSelectedItem());
                String vTanggal = ettgl.getText().toString();
                String vPorsi = tv_angka.getText().toString();

                Intent veg = new Intent(Sub_pes__7bulanan.this, Value7bulanActivity.class);
                veg.putExtra("extraNama", vNama);
                veg.putExtra("extraNohp", vNohp);
                veg.putExtra("extraAlamat", vAlamat);
                veg.putExtra("extraNubulan", spNubulan);
                veg.putExtra("extraTanggal", vTanggal);
                veg.putExtra("extraPorsi", vPorsi);
                startActivity(veg);

            }
        });

    }

    private void getpesbln(){
        String Nama = etnama.getText().toString().trim();
        String Nohp = etnohp.getText().toString().trim();
        String Alamat = etalamat.getText().toString().trim();
        String Spinnerbln = spnubulan.getSelectedItem().toString();
        String Tanggal = ettgl.getText().toString().trim();
        String Porsi = tv_angka.getText().toString().trim();

        if(!TextUtils.isEmpty(Nama)){

            String id = databasegetpesbln.push().getKey();

            getpesbln pesbln = new getpesbln(id,Nama,Nohp,Alamat,Spinnerbln,Tanggal,Porsi);

            databasegetpesbln.child(id).setValue(pesbln);

            Toast.makeText(this, "Pemesanan Vegetarian", Toast.LENGTH_LONG).show();


        }else {
            Toast.makeText(this,"Anda Belum Mengisi Pemesanan", Toast.LENGTH_LONG).show();
        }
    }


}
