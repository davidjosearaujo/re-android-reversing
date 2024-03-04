package androidx.compose.ui.platform;

import a6.i1;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: a */
    public static final LinkedHashMap f1182a = new LinkedHashMap();

    public static final d6.c0 a(Context context) {
        d6.c0 c0Var;
        LinkedHashMap linkedHashMap = f1182a;
        synchronized (linkedHashMap) {
            Object obj = linkedHashMap.get(context);
            if (obj == null) {
                ContentResolver contentResolver = context.getContentResolver();
                Uri uriFor = Settings.Global.getUriFor("animator_duration_scale");
                c6.b a7 = c6.h.a(-1, null, 6);
                d6.s sVar = new d6.s(new g0(contentResolver, uriFor, new h0(a7, Handler.createAsync(Looper.getMainLooper())), a7, context, null));
                i1 i1Var = new i1(null);
                g6.c cVar = a6.h0.f297a;
                obj = q2.a.P(sVar, new f6.c(i1Var.s(f6.m.f4172a)), new d6.b0(0L, Long.MAX_VALUE), Float.valueOf(Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f)));
                linkedHashMap.put(context, obj);
            }
            c0Var = (d6.c0) obj;
        }
        return c0Var;
    }
}
