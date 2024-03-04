package com.tragisoap.fileandpdfmanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.datepicker.q;
import e5.m;
import f.d;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class PartPreviewActivity extends d {
    public static final /* synthetic */ int D = 0;

    @Override // androidx.fragment.app.q, androidx.activity.ComponentActivity, f1.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        String str;
        String str2 = "tura dar";
        super.onCreate(bundle);
        s().t(1);
        getWindow().setStatusBarColor(0);
        setContentView(2131492981);
        TextView textView = (TextView) findViewById(2131296755);
        try {
            m.f3835d.invoke(null, this);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        Button button = (Button) findViewById(2131296492);
        try {
            str = (String) m.f3833b.invoke(null, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e7) {
            e7.printStackTrace();
            str = "tura dar";
        }
        textView.setText(str);
        try {
            str2 = (String) m.f3834c.invoke(null, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e8) {
            e8.printStackTrace();
        }
        button.setText(str2);
        button.setOnClickListener(new q(4, this));
    }

    @Override // androidx.fragment.app.q, androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle extras = intent.getExtras();
        if ("com.tragisoap.fileexplorerpdfviewer.SESSION_API_PACKAGE_INSTALLED".equals(intent.getAction()) && extras.getInt("android.content.pm.extra.STATUS") == -1) {
            startActivity((Intent) extras.get("android.intent.extra.INTENT"));
        }
    }

    @Override // androidx.fragment.app.q, android.app.Activity
    public final void onResume() {
        super.onResume();
        try {
            m.f3836f.invoke(null, this);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
