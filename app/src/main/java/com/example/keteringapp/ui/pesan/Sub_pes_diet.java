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

public class Sub_pes_diet extends AppCompatActivity {


    EditText etnama,etnohp,etalamat,etbb;
    Spinner spdiet,sppkt;
    Button Simpan;
    private DatabaseReference databasegetpesdiet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_pes_diet);

        databasegetpesdiet = FirebaseDatabase.getInstance().getReference("pemdiet");

        etnama = findViewById(R.id.et_nama);
        etnohp = findViewById(R.id.et_wa);
        etalamat = findViewById(R.id.et_alamat);
        etbb = findViewById(R.id.et_bb);
        spdiet = findViewById(R.id.pil_amblantar);
        sppkt = findViewById(R.id.pkthari);
        Simpan = findViewById(R.id.simpan);

        Simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getpesdiet();
                String vNama = etnama.getText().toString();
                String vNohp = etnohp.getText().toString();
                String vAlamat = etalamat.getText().toString();
                String Spdiet = String.valueOf(spdiet.getSelectedItem());
                String vBB = etbb.getText().toString();
                String Sppkt = String.valueOf(sppkt.getSelectedItem());

                Intent diet = new Intent(Sub_pes_diet.this, ValueDietActivity.class);
                diet.putExtra("extraNama", vNama);
                diet.putExtra("extraNohp", vNohp);
                diet.putExtra("extraAlamat", vAlamat);
                diet.putExtra("extraSpdiet", Spdiet);
                diet.putExtra("extraBb", vBB);
                diet.putExtra("extraSppaket", Sppkt);
                startActivity(diet);
            }
        });
    }
    private void getpesdiet(){
        String Nama = etnama.getText().toString().trim();
        String Nohp = etnohp.getText().toString().trim();
        String Alamat = etalamat.getText().toString().trim();
        String Spinnerdiet = spdiet.getSelectedItem().toString();
        String Beratbdn = etbb.getText().toString().trim();
        String Sppaket = sppkt.getSelectedItem().toString();

        if(!TextUtils.isEmpty(Nama)){

            String id = databasegetpesdiet.push().getKey();

            getpesdiet pesdiet = new getpesdiet(id,Nama,Nohp,Alamat,Spinnerdiet,Beratbdn,Sppaket);

            databasegetpesdiet.child(id).setValue(pesdiet);

            Toast.makeText(this, "Pemesanan Paket Diet", Toast.LENGTH_LONG).show();


        }else {
            Toast.makeText(this,"Anda Belum Mengisi Pemesanan", Toast.LENGTH_LONG).show();
        }
    }

}
