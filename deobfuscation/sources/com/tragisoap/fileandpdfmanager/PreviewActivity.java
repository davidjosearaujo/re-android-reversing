package com.tragisoap.fileandpdfmanager;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import f.d;
import f1.f;
import java.util.HashMap;

/* loaded from: classes.dex */
public class PreviewActivity extends d {
    @Override // androidx.fragment.app.q, androidx.activity.ComponentActivity, f1.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(2131492897);
        Intent intent = new Intent(this, PreviewActivity.class);
        int i7 = FileManagerService.f3513j;
        ComponentName componentName = new ComponentName(this, FileManagerService.class);
        synchronized (f.f4076h) {
            HashMap<ComponentName, f.d> hashMap = f.f4077i;
            f.d dVar = hashMap.get(componentName);
            if (dVar == null) {
                dVar = new f.c(this, componentName);
                hashMap.put(componentName, dVar);
            }
            dVar.b();
            dVar.a(intent);
        }
    }

    @Override // androidx.fragment.app.q, android.app.Activity
    public final void onResume() {
        super.onResume();
    }
}
