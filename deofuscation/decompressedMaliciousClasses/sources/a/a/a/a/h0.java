package a.a.a.a;

import a.a.a.a.d0;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;
@TargetApi(19)
/* loaded from: /home/remnux/decompressedMalicious.dex */
class h0 {

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class a implements y, x {
        private static short[] $ = {2792, 2791, 2797, 2811, 2790, 2784, 2797, 2727, 2809, 2796, 2790, 2809, 2789, 2796, 8920, 8919, 8925, 8907, 8918, 8912, 8925, 8855, 8906, 8908, 8905, 8905, 8918, 8907, 8909, 8855, 8917, 8918, 8922, 8920, 8917, 8950, 8919, 8917, 8896, 7658, 7653, 7663, 7673, 7652, 7650, 7663, 7589, 7672, 7678, 7675, 7675, 7652, 7673, 7679, 7589, 7660, 7673, 7652, 7678, 7675, 7616, 7662, 7666, 3810, 3821, 3815, 3825, 3820, 3818, 3815, 3757, 3824, 3830, 3827, 3827, 3820, 3825, 3831, 3757, 3818, 3824, 3780, 3825, 3820, 3830, 3827, 3792, 3830, 3822, 3822, 3810, 3825, 3834, 8644, 8651, 8641, 8663, 8650, 8652, 8641, 8587, 8662, 8656, 8661, 8661, 8650, 8663, 8657, 8587, 8656, 8662, 8640, 8694, 8652, 8641, 8640, 8678, 8653, 8644, 8651, 8651, 8640, 8649, 6625, 6638, 6628, 6642, 6639, 6633, 6628, 6574, 6643, 6645, 6640, 6640, 6639, 6642, 6644, 6574, 6643, 6639, 6642, 6644, 6603, 6629, 6649, 60, 51, 57, 47, 50, 52, 57, 115, 46, 40, 45, 45, 50, 47, 41, 115, 60, 62, 41, 52, 50, 51, 24, 37, 41, 47, 60, 46};

        /* renamed from: a  reason: collision with root package name */
        private Notification.Builder f25a;

        /* renamed from: b  reason: collision with root package name */
        private Bundle f26b;
        private List<Bundle> c = new ArrayList();
        private RemoteViews d;
        private RemoteViews e;

        private static String $(int i, int i2, int i3) {
            char[] cArr = new char[i2 - i];
            for (int i4 = 0; i4 < i2 - i; i4++) {
                cArr[i4] = (char) ($[i + i4] ^ i3);
            }
            return new String(cArr);
        }

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            PendingIntent pendingIntent3;
            boolean z6 = false;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                pendingIntent3 = pendingIntent2;
                z6 = true;
            } else {
                pendingIntent3 = pendingIntent2;
            }
            this.f25a = deleteIntent.setFullScreenIntent(pendingIntent3, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
            Bundle bundle2 = new Bundle();
            this.f26b = bundle2;
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                this.f26b.putStringArray($(0, 14, 2697), (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            if (z4) {
                this.f26b.putBoolean($(14, 39, 8889), true);
            }
            if (str != null) {
                this.f26b.putString($(39, 63, 7563), str);
                this.f26b.putBoolean(z5 ? $(63, 93, 3715) : $(93, 123, 8613), true);
            }
            if (str2 != null) {
                this.f26b.putString($(123, 146, 6528), str2);
            }
            this.d = remoteViews2;
            this.e = remoteViews3;
        }

        @Override // a.a.a.a.y
        public Notification.Builder a() {
            return this.f25a;
        }

        @Override // a.a.a.a.y
        public Notification b() {
            SparseArray<Bundle> d = g0.d(this.c);
            if (d != null) {
                this.f26b.putSparseParcelableArray($(146, 174, 93), d);
            }
            this.f25a.setExtras(this.f26b);
            Notification build = this.f25a.build();
            RemoteViews remoteViews = this.d;
            if (remoteViews != null) {
                build.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.e;
            if (remoteViews2 != null) {
                build.bigContentView = remoteViews2;
            }
            return build;
        }

        @Override // a.a.a.a.x
        public void c(d0.a aVar) {
            this.c.add(g0.f(this.f25a, aVar));
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }
}
