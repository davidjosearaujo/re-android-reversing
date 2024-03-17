package cn.jpush.android.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.jiguang.ak.a;
import cn.jiguang.ap.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DActivity extends Activity {
    private static final String TAG = "DActivity";

    private void handleStart() {
        try {
            e.a(getApplicationContext(), getIntent() != null ? getIntent().getExtras() : null, 8);
        } catch (Throwable th) {
            a.a(TAG, "handle start error#" + th);
        }
        try {
            finish();
        } catch (Throwable th2) {
            a.a(TAG, "finish error#" + th2);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.a(TAG, "DActivity oncreate");
        handleStart();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a.a(TAG, "DActivity onNewIntent");
        handleStart();
    }
}
