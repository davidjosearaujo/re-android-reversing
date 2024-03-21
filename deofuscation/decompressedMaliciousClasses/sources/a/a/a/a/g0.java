package a.a.a.a;

import a.a.a.a.d0;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@TargetApi(16)
/* loaded from: /home/remnux/decompressedMalicious.dex */
class g0 {
    private static short[] $ = {6013, 5984, 5996, 5994, 6009, 5995, 1955, 1922, 1945, 1924, 1931, 1924, 1934, 1932, 1945, 1924, 1922, 1923, 1966, 1922, 1920, 1949, 1932, 1945, 1748, 1781, 1774, 1779, 1788, 1779, 1785, 1787, 1774, 1779, 1781, 1780, 1716, 1791, 1762, 1774, 1768, 1787, 1769, 1722, 1788, 1779, 1791, 1782, 1790, 1722, 1779, 1769, 1722, 1780, 1781, 1774, 1722, 1781, 1788, 1722, 1774, 1763, 1770, 1791, 1722, 1752, 1775, 1780, 1790, 1782, 1791, 7301, 7332, 7359, 7330, 7341, 7330, 7336, 7338, 7359, 7330, 7332, 7333, 7304, 7332, 7334, 7355, 7338, 7359, 1043, 1064, 1063, 1060, 1066, 1059, 1126, 1074, 1065, 1126, 1063, 1061, 1061, 1059, 1077, 1077, 1126, 1064, 1065, 1074, 1071, 1056, 1071, 1061, 1063, 1074, 1071, 1065, 1064, 1126, 1059, 1086, 1074, 1076, 1063, 1077, 6715, 6682, 6657, 6684, 6675, 6684, 6678, 6676, 6657, 6684, 6682, 6683, 6710, 6682, 6680, 6661, 6676, 6657, 9790, 9733, 9738, 9737, 9735, 9742, 9803, 9759, 9732, 9803, 9738, 9736, 9736, 9742, 9752, 9752, 9803, 9733, 9732, 9759, 9730, 9741, 9730, 9736, 9738, 9759, 9730, 9732, 9733, 9803, 9742, 9747, 9759, 9753, 9738, 9752, 3339, 3332, 3342, 3352, 3333, 3331, 3342, 3396, 3353, 3359, 3354, 3354, 3333, 3352, 3358, 3396, 3352, 3343, 3335, 3333, 3358, 3343, 3363, 3332, 3354, 3359, 3358, 3353, 1489, 1502, 1492, 1474, 1503, 1497, 1492, 1438, 1475, 1477, 1472, 1472, 1503, 1474, 1476, 1438, 1489, 1500, 1500, 1503, 1479, 1527, 1493, 1502, 1493, 1474, 1489, 1476, 1493, 1492, 1506, 1493, 1472, 1500, 1497, 1493, 1475};

    /* renamed from: a  reason: collision with root package name */
    private static final Object f15a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Field f16b;
    private static boolean c;

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class a implements y, x {
        private static short[] $ = {8034, 8045, 8039, 8049, 8044, 8042, 8039, 7981, 8048, 8054, 8051, 8051, 8044, 8049, 8055, 7981, 8047, 8044, 8032, 8034, 8047, 8012, 8045, 8047, 8058, 6002, 6013, 6007, 5985, 6012, 6010, 6007, 5949, 5984, 5990, 5987, 5987, 6012, 5985, 5991, 5949, 6004, 5985, 6012, 5990, 5987, 5976, 6006, 5994, 4007, 4008, 4002, 4020, 4009, 4015, 4002, 4072, 4021, 4019, 4022, 4022, 4009, 4020, 4018, 4072, 4015, 4021, 3969, 4020, 4009, 4019, 4022, 3989, 4019, 4011, 4011, 4007, 4020, 4031, 9883, 9876, 9886, 9864, 9877, 9875, 9886, 9940, 9865, 9871, 9866, 9866, 9877, 9864, 9870, 9940, 9871, 9865, 9887, 9897, 9875, 9886, 9887, 9913, 9874, 9883, 9876, 9876, 9887, 9878, 9372, 9363, 9369, 9359, 9362, 9364, 9369, 9427, 9358, 9352, 9357, 9357, 9362, 9359, 9353, 9427, 9358, 9362, 9359, 9353, 9398, 9368, 9348, 8085, 8090, 8080, 8070, 8091, 8093, 8080, 8154, 8071, 8065, 8068, 8068, 8091, 8070, 8064, 8154, 8085, 8087, 8064, 8093, 8091, 8090, 8113, 8076, 8064, 8070, 8085, 8071};

        /* renamed from: a  reason: collision with root package name */
        private Notification.Builder f17a;

        /* renamed from: b  reason: collision with root package name */
        private final Bundle f18b;
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

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            PendingIntent pendingIntent3;
            boolean z5 = false;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                pendingIntent3 = pendingIntent2;
                z5 = true;
            } else {
                pendingIntent3 = pendingIntent2;
            }
            this.f17a = deleteIntent.setFullScreenIntent(pendingIntent3, z5).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            Bundle bundle2 = new Bundle();
            this.f18b = bundle2;
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            if (z3) {
                this.f18b.putBoolean($(0, 25, 7939), true);
            }
            if (str != null) {
                this.f18b.putString($(25, 49, 5907), str);
                this.f18b.putBoolean(z4 ? $(49, 79, 4038) : $(79, 109, 9978), true);
            }
            if (str2 != null) {
                this.f18b.putString($(109, 132, 9469), str2);
            }
            this.d = remoteViews2;
            this.e = remoteViews3;
        }

        @Override // a.a.a.a.y
        public Notification.Builder a() {
            return this.f17a;
        }

        @Override // a.a.a.a.y
        public Notification b() {
            Notification build = this.f17a.build();
            Bundle e = g0.e(build);
            Bundle bundle = new Bundle(this.f18b);
            for (String str : this.f18b.keySet()) {
                if (e.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            e.putAll(bundle);
            SparseArray<Bundle> d = g0.d(this.c);
            if (d != null) {
                g0.e(build).putSparseParcelableArray($(132, 160, 8180), d);
            }
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
            this.c.add(g0.f(this.f17a, aVar));
        }
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a(y yVar, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(yVar.a()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    public static void b(y yVar, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        Notification.BigTextStyle bigText = new Notification.BigTextStyle(yVar.a()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }

    public static void c(y yVar, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(yVar.a()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator<CharSequence> it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine(it.next());
        }
    }

    public static SparseArray<Bundle> d(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle e(Notification notification) {
        String $2;
        String $3;
        synchronized (f15a) {
            if (c) {
                return null;
            }
            try {
                if (f16b == null) {
                    Field declaredField = Notification.class.getDeclaredField($(0, 6, 5912));
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e($(6, 24, 2029), $(24, 71, 1690));
                        c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f16b = declaredField;
                }
                Bundle bundle = (Bundle) f16b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f16b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                e = e;
                $2 = $(125, 143, 6773);
                $3 = $(143, 179, 9835);
                Log.e($2, $3, e);
                c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                e = e2;
                $2 = $(71, 89, 7371);
                $3 = $(89, 125, 1094);
                Log.e($2, $3, e);
                c = true;
                return null;
            }
        }
    }

    public static Bundle f(Notification.Builder builder, d0.a aVar) {
        builder.addAction(aVar.d(), aVar.f(), aVar.a());
        Bundle bundle = new Bundle(aVar.c());
        if (aVar.e() != null) {
            bundle.putParcelableArray($(179, 207, 3434), m0.b(aVar.e()));
        }
        bundle.putBoolean($(207, 244, 1456), aVar.b());
        return bundle;
    }
}
