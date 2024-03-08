package androidx.compose.ui.platform;

import a6.h0;
import a6.i1;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import c6.b;
import c6.h;
import d6.b0;
import d6.c0;
import d6.s;
import f6.m;
import g6.c;
import java.util.LinkedHashMap;
import q2.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    public static final LinkedHashMap f1182a = new LinkedHashMap();

    public static final c0 a(Context context) {
        c0 c0Var;
        LinkedHashMap linkedHashMap = f1182a;
        synchronized (linkedHashMap) {
            Object obj = linkedHashMap.get(context);
            if (obj == null) {
                ContentResolver contentResolver = context.getContentResolver();
                Uri uriFor = Settings.Global.getUriFor("animator_duration_scale");
                b a7 = h.a(-1, null, 6);
                s sVar = new s(new g0(contentResolver, uriFor, new h0(a7, Handler.createAsync(Looper.getMainLooper())), a7, context, null));
                i1 i1Var = new i1(null);
                c cVar = h0.f297a;
                obj = a.P(sVar, new f6.c(i1Var.s(m.f4172a)), new b0(0, Long.MAX_VALUE), Float.valueOf(Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f)));
                linkedHashMap.put(context, obj);
            }
            c0Var = (c0) obj;
        }
        return c0Var;
    }
}
