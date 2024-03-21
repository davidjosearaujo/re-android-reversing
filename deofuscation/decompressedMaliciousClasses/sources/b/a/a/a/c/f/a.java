package b.a.a.a.c.f;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.util.b;
import java.util.Collections;
import java.util.List;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class a {
    private static short[] $ = {2819, 2863, 2862, 2862, 2853, 2851, 2868, 2857, 2863, 2862, 2836, 2866, 2849, 2851, 2859, 2853, 2866, 9196, 9177, 9177, 9160, 9152, 9181, 9177, 9160, 9161, 9101, 9177, 9154, 9101, 9167, 9156, 9155, 9161, 9101, 9177, 9154, 9101, 9164, 9101, 9182, 9160, 9183, 9179, 9156, 9166, 9160, 9101, 9156, 9155, 9101, 9164, 9101, 9214, 9209, 9186, 9213, 9213, 9192, 9193, 9101, 9181, 9164, 9166, 9158, 9164, 9162, 9160, 9091};

    /* renamed from: a  reason: collision with root package name */
    private static final Object f120a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f121b;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    private a() {
        List list = Collections.EMPTY_LIST;
    }

    @SuppressLint({"UntrackedBindService"})
    public static boolean a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        ComponentName component = intent.getComponent();
        if (!(component == null ? false : b.a(context, component.getPackageName()))) {
            return context.bindService(intent, serviceConnection, i);
        }
        Log.w($(0, 17, 2880), $(17, 69, 9133));
        return false;
    }

    public static a b() {
        if (f121b == null) {
            synchronized (f120a) {
                if (f121b == null) {
                    f121b = new a();
                }
            }
        }
        return f121b;
    }
}
