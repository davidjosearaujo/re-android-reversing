package cn.jiguang.at;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.ar.c;
import cn.jiguang.ax.h;
import cn.jiguang.internal.JConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.huawei.hms.support.feature.result.CommonConstant;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    public static boolean a;
    public static int b;

    public static void a(Context context) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 38, null, null, new Object[0]);
    }

    public static void a(Context context, int i) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 57, null, null, Integer.valueOf(i));
    }

    public static void a(Context context, long j) {
        if (j > 0) {
            JCoreManager.onEvent(context, JConstants.SDK_TYPE, 37, null, null, Long.valueOf(j));
        }
    }

    public static void a(Context context, long j, String str, String str2) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 35, null, null, Long.valueOf(j), str, str2);
    }

    public static void a(Context context, Bundle bundle) {
        if (bundle != null) {
            a = bundle.getBoolean("foreground");
            int i = bundle.getInt("user_type");
            b = i;
            if (i == -1) {
                b = a ? 1 : 0;
            }
            c.c("JCoreManagerInternal", "changeForeGroundStat:" + a + ", userActiveType:" + b);
            if (a) {
                if (h.a().f() >= 120) {
                    h.a().i();
                }
                cn.jiguang.e.a.b().b(context);
            }
        }
    }

    public static void a(Context context, Object obj) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 39, null, null, obj);
    }

    public static void a(Context context, String str) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 36, null, null, str);
    }

    public static void a(Context context, String str, int i, int i2, long j, long j2, byte[] bArr) {
        a(context, str, i, i2, j, j2, bArr, true);
    }

    private static void a(Context context, String str, int i, int i2, long j, long j2, byte[] bArr, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("cmd", i);
        bundle.putInt("ver", i2);
        bundle.putLong("rid", j);
        bundle.putLong(com.alipay.sdk.data.a.Q, j2);
        bundle.putByteArray(SDKConstants.PARAM_A2U_BODY, bArr);
        JCoreManager.onEvent(context, str, z ? 17 : 16, null, bundle, new Object[0]);
    }

    public static void a(Context context, String str, long j) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 44, null, null, str, Long.valueOf(j));
    }

    public static void a(Runnable runnable, int i, int... iArr) {
        JCoreManager.onEvent(null, null, 83, null, null, runnable, Integer.valueOf(i));
    }

    public static void a(Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 78, null, null, runnable);
    }

    public static void a(String str) {
        JCoreManager.onEvent(null, null, 13, str, null, new Object[0]);
    }

    public static Map b(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 45, null, null, new Object[0]);
        if (onEvent instanceof Map) {
            return (Map) onEvent;
        }
        return null;
    }

    public static void b(Context context, int i) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 51, "", null, Integer.valueOf(i));
    }

    public static void b(Context context, String str, int i, int i2, long j, long j2, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putInt("cmd", i);
        bundle.putInt("ver", i2);
        bundle.putLong("rid", j);
        bundle.putLong(com.alipay.sdk.data.a.Q, 0L);
        bundle.putByteArray(SDKConstants.PARAM_A2U_BODY, bArr);
        bundle.putLong(CommonConstant.KEY_UID, j2);
        JCoreManager.onEvent(context, str, 59, null, bundle, new Object[0]);
    }

    public static void b(Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 75, null, null, runnable);
    }

    public static int c(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 47, null, null, new Object[0]);
        if (onEvent instanceof Integer) {
            return ((Integer) onEvent).intValue();
        }
        return 1;
    }

    public static void c(Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 77, null, null, runnable);
    }

    public static void d(Context context) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 48, null, null, new Object[0]);
    }

    public static void d(Runnable runnable, int... iArr) {
        JCoreManager.onEvent(null, null, 76, null, null, runnable);
    }
}
