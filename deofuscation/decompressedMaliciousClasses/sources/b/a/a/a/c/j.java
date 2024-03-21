package b.a.a.a.c;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import b.a.a.a.e.p0;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.util.e;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class j {
    private static short[] $ = {5984, 5996, 5998, 5933, 5988, 5996, 5996, 5988, 5999, 5990, 5933, 5986, 5997, 5991, 6001, 5996, 5994, 5991, 5933, 5988, 5998, 6000, 7259, 7263, 7251, 7246, 7257, 7267, 5321};

    /* renamed from: a */
    public static final int f124a = r.f130a;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static Intent f(Context context, int i, String str) {
        String $2 = $(0, 22, 5891);
        if (i == 1 || i == 2) {
            return (context == null || !e.b(context)) ? i.c($2, g(context, str)) : i.b();
        }
        if (i != 3) {
            return null;
        }
        return i.a($2);
    }

    private static String g(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append($(22, 28, 7228));
        sb.append(f124a);
        String $2 = $(28, 29, 5348);
        sb.append($2);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append($2);
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append($2);
        if (context != null) {
            try {
                sb.append(p0.b(context).b(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return sb.toString();
    }

    public PendingIntent a(Context context, int i, int i2) {
        return e(context, i, i2, null);
    }

    public String b(int i) {
        return r.a(i);
    }

    public int c(Context context) {
        int c = r.c(context);
        if (r.e(context, c)) {
            return 18;
        }
        return c;
    }

    public boolean d(int i) {
        return r.d(i);
    }

    public final PendingIntent e(Context context, int i, int i2, String str) {
        Intent f = f(context, i, str);
        if (f == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, f, 268435456);
    }
}
