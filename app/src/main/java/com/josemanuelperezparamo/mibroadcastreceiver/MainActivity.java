package com.josemanuelperezparamo.mibroadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtTel,txtTex;
    Button btnGuardar;
    public static Intent in = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTel = findViewById(R.id.txtTelefono);
        txtTex = findViewById(R.id.txtTexto);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                in.putExtra("tel",txtTel.getText().toString());
                in.putExtra("texto",txtTex.getText().toString());
            }
        });
    }
}