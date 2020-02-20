package com.josemanuelperezparamo.mibroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MiBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if(extras!=null){
            if(extras.getString("state").equals(TelephonyManager.EXTRA_STATE_RINGING)){
                String numero = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                String nume=MainActivity.in.getStringExtra("tel");
                String text=MainActivity.in.getStringExtra("texto");

                //Toast.makeText(context, "Te esta llamando: " + numero+" numero a bloquear: "+nume, Toast.LENGTH_LONG).show();
                if(numero.equals("+52"+nume)){
                    Toast.makeText(context, "SON IGUALES", Toast.LENGTH_LONG).show();
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(nume, null, text , null, null);
                }else if(numero.equals(nume)){
                    Toast.makeText(context, "SON IGUALES", Toast.LENGTH_LONG).show();
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(nume, null, text , null, null);
                }else{
                    Toast.makeText(context, "diferentes", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
