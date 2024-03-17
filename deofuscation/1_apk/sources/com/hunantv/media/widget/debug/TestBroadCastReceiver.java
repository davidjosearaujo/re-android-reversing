package com.hunantv.media.widget.debug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.hunantv.media.player.pragma.DebugLog;
import java.util.HashMap;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class TestBroadCastReceiver extends BroadcastReceiver {
    public static final String TAG = "mgtvplayer_report";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        HashMap hashMap = (HashMap) intent.getSerializableExtra("EXTRA_REPORT_PARAMS");
        if (hashMap != null) {
            DebugLog.i(TAG, hashMap + "");
        }
    }
}
