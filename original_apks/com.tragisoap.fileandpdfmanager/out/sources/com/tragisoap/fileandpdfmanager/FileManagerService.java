package com.tragisoap.fileandpdfmanager;

import android.content.Intent;
import e5.m;
import f1.f;
import java.lang.reflect.InvocationTargetException;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class FileManagerService extends f {

    /* renamed from: j  reason: collision with root package name */
    public static final /* synthetic */ int f3513j = 0;

    @Override // f1.f
    public final void a() {
        try {
            m.a();
            try {
                m.e.invoke(null, this);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(268435456);
            startActivity(intent);
        }
    }
}
