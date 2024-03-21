package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class z0 implements DialogInterface.OnClickListener {
    private static short[] $ = {-31468, -31431, -31439, -31428, -31425, -31433, -31486, -31435, -31436, -31431, -31454, -31435, -31437, -31452, -27458, -27495, -27503, -27500, -27491, -27492, -27432, -27508, -27497, -27432, -27509, -27508, -27495, -27510, -27508, -27432, -27510, -27491, -27509, -27497, -27500, -27507, -27508, -27503, -27497, -27498, -27432, -27503, -27498, -27508, -27491, -27498, -27508};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static z0 a(Activity activity, Intent intent, int i) {
        return new a1(intent, activity, i);
    }

    protected abstract void b();

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            b();
        } catch (ActivityNotFoundException e) {
            Log.e($(0, 14, -31408), $(14, 47, -27400), e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
