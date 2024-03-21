package b.a.a.a.c;

import a.a.a.a.i;
import a.a.a.a.z;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import b.a.a.a.b;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.e0;
import com.google.android.gms.common.internal.y0;
import com.google.android.gms.common.internal.z0;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.g;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class c extends j {
    private static short[] $ = {3598, 3634, 3647, 3639, 3647, 3700, 3614, 3635, 3643, 3638, 3637, 3645, 3700, 3611, 3638, 3647, 3624, 3630, 531, 571, 571, 563, 568, 561, 533, 548, 573, 533, 546, 565, 573, 568, 565, 566, 573, 568, 573, 544, 557, 5321, 5357, 5367, 5367, 5357, 5354, 5347, 5284, 5366, 5345, 5367, 5355, 5352, 5361, 5360, 5357, 5355, 5354, 5284, 5346, 5355, 5366, 5284, 5319, 5355, 5354, 5354, 5345, 5351, 5360, 5357, 5355, 5354, 5334, 5345, 5367, 5361, 5352, 5360, 5290, 5334, 5313, 5335, 5323, 5320, 5329, 5328, 5325, 5323, 5322, 5339, 5334, 5313, 5333, 5329, 5325, 5334, 5313, 5312, 5290, 5284, 5319, 5349, 5352, 5352, 5284, 5315, 5355, 5355, 5347, 5352, 5345, 5317, 5364, 5357, 5317, 5362, 5349, 5357, 5352, 5349, 5350, 5357, 5352, 5357, 5360, 5373, 5287, 5367, 5356, 5355, 5363, 5313, 5366, 5366, 5355, 5366, 5322, 5355, 5360, 5357, 5346, 5357, 5351, 5349, 5360, 5357, 5355, 5354, 5292, 5319, 5355, 5354, 5360, 5345, 5372, 5360, 5288, 5284, 5319, 5355, 5354, 5354, 5345, 5351, 5360, 5357, 5355, 5354, 5334, 5345, 5367, 5361, 5352, 5360, 5293, 5284, 5357, 5354, 5367, 5360, 5345, 5349, 5344, 5290, 1716, 1717, 1710, 1715, 1724, 1715, 1721, 1723, 1710, 1715, 1717, 1716, 3138, 9087, 9047, 9047, 9055, 9044, 9053, 9064, 9044, 9049, 9025, 9067, 9053, 9034, 9038, 9041, 9051, 9053, 9035, 9085, 9034, 9034, 9047, 9034, 9084, 9041, 9049, 9044, 9047, 9055, 5829};

    /* renamed from: b */
    private static final c f117b = new c();

    @SuppressLint({"HandlerLeak"})
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public class a extends Handler {
        private static short[] $ = {19961, 19922, 19923, 19866, 19913, 19869, 19926, 19923, 19922, 19914, 19869, 19925, 19922, 19914, 19869, 19913, 19922, 19869, 19925, 19932, 19923, 19929, 19921, 19928, 19869, 19913, 19925, 19924, 19918, 19869, 19920, 19928, 19918, 19918, 19932, 19930, 19928, 19847, 19869, 27829, 27805, 27805, 27797, 27806, 27799, 27827, 27778, 27803, 27827, 27780, 27795, 27803, 27806, 27795, 27792, 27803, 27806, 27803, 27782, 27787};

        /* renamed from: a */
        private final Context f118a;

        private static String $(int i, int i2, int i3) {
            char[] cArr = new char[i2 - i];
            for (int i4 = 0; i4 < i2 - i; i4++) {
                cArr[i4] = (char) ($[i + i4] ^ i3);
            }
            return new String(cArr);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            c.this = r5;
            this.f118a = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append($(0, 39, 19901));
                sb.append(i);
                Log.w($(39, 60, 27890), sb.toString());
                return;
            }
            int c = c.this.c(this.f118a);
            if (c.this.d(c)) {
                c.this.l(this.f118a, c);
            }
        }
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    c() {
    }

    public static c j() {
        return f117b;
    }

    static Dialog m(Context context, int i, z0 z0Var, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ($(0, 18, 3674).equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(y0.d(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String f = y0.f(context, i);
        if (f != null) {
            builder.setPositiveButton(f, z0Var);
        }
        String b2 = y0.b(context, i);
        if (b2 != null) {
            builder.setTitle(b2);
        }
        return builder.create();
    }

    static void n(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof i) {
            e.W0(dialog, onCancelListener).V0(((i) activity).e(), str);
            return;
        }
        b.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    @TargetApi(20)
    private final void o(Context context, int i, String str, PendingIntent pendingIntent) {
        Notification notification;
        int i2;
        if (i == 18) {
            q(context);
        } else if (pendingIntent != null) {
            String c = y0.c(context, i);
            String e = y0.e(context, i);
            Resources resources = context.getResources();
            if (e.b(context)) {
                e0.c(g.d());
                notification = new Notification.Builder(context).setSmallIcon(context.getApplicationInfo().icon).setPriority(2).setAutoCancel(true).setContentTitle(c).setStyle(new Notification.BigTextStyle().bigText(e)).addAction(b.a.a.a.a.common_full_open_on_phone, resources.getString(b.common_open_on_phone), pendingIntent).build();
            } else {
                z.d dVar = new z.d(context);
                dVar.l(17301642);
                dVar.n(resources.getString(b.common_google_play_services_notification_ticker));
                dVar.o(System.currentTimeMillis());
                dVar.f(true);
                dVar.g(pendingIntent);
                dVar.i(c);
                dVar.h(e);
                dVar.k(true);
                z.c cVar = new z.c();
                cVar.c(e);
                dVar.m(cVar);
                notification = dVar.a();
            }
            if (i == 1 || i == 2 || i == 3) {
                i2 = 10436;
                r.f131b.set(false);
            } else {
                i2 = 39789;
            }
            ((NotificationManager) context.getSystemService($(184, 196, 1754))).notify(i2, notification);
        } else if (i == 6) {
            Log.w($(18, 39, 596), $(39, 184, 5252));
        }
    }

    @Override // b.a.a.a.c.j
    public PendingIntent a(Context context, int i, int i2) {
        return super.a(context, i, i2);
    }

    @Override // b.a.a.a.c.j
    public final String b(int i) {
        return super.b(i);
    }

    @Override // b.a.a.a.c.j
    public int c(Context context) {
        return super.c(context);
    }

    @Override // b.a.a.a.c.j
    public final boolean d(int i) {
        return super.d(i);
    }

    public Dialog h(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return m(activity, i, z0.a(activity, j.f(activity, i, $(196, 197, 3110)), i2), onCancelListener);
    }

    public PendingIntent i(Context context, a aVar) {
        return aVar.g() ? aVar.e() : a(context, aVar.c(), 0);
    }

    public boolean k(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog h = h(activity, i, i2, onCancelListener);
        if (h == null) {
            return false;
        }
        n(activity, h, $(197, 226, 9016), onCancelListener);
        return true;
    }

    public void l(Context context, int i) {
        o(context, i, null, e(context, i, 0, $(226, 227, 5803)));
    }

    public final boolean p(Context context, a aVar, int i) {
        PendingIntent i2 = i(context, aVar);
        if (i2 == null) {
            return false;
        }
        o(context, aVar.c(), null, GoogleApiActivity.a(context, i2, i));
        return true;
    }

    final void q(Context context) {
        new a(context).sendEmptyMessageDelayed(1, 120000);
    }
}
