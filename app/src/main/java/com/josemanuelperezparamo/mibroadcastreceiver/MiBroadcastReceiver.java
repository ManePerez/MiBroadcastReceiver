package com.josemanuelperezparamo.mibroadcastreceiver;

import android.Manifest;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

public class MiBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        final String tel = MainActivity.in.getStringExtra("tel");
        final String texto = MainActivity.in.getStringExtra("texto");

        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(
                Service.TELEPHONY_SERVICE
        );

        telephonyManager.listen(new PhoneStateListener() {
            @Override
            public void onCallStateChanged(int state, String phoneNumber) {
                super.onCallStateChanged(state, phoneNumber);
                if (state == TelephonyManager.CALL_STATE_RINGING) {
                    if (phoneNumber.equals("+52" + tel)) {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(tel, null, texto, null, null);
                        Toast.makeText(context, "Mensaje envíado.", Toast.LENGTH_LONG).show();
                    } else if (phoneNumber.equals(tel)) {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(tel, null, texto, null, null);
                        Toast.makeText(context, "Mensaje envíado.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(context, "El número ingresado: " +
                                tel + "\nes diferente del número entrante: " +
                                phoneNumber, Toast.LENGTH_LONG).show();
                    }
                }
            }
        }, PhoneStateListener.LISTEN_CALL_STATE);
    }
}
