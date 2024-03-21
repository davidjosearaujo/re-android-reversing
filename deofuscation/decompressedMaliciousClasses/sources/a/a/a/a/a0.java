package a.a.a.a;

import a.a.a.a.d0;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;
@TargetApi(20)
/* loaded from: /home/remnux/decompressedMalicious.dex */
class a0 {
    private static short[] $ = {2323, 2332, 2326, 2304, 2333, 2331, 2326, 2396, 2305, 2311, 2306, 2306, 2333, 2304, 2310, 2396, 2323, 2334, 2334, 2333, 2309, 2357, 2327, 2332, 2327, 2304, 2323, 2310, 2327, 2326, 2336, 2327, 2306, 2334, 2331, 2327, 2305};

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class a implements y, x {
        private static short[] $ = {312, 311, 317, 299, 310, 304, 317, 375, 297, 316, 310, 297, 309, 316};

        /* renamed from: a  reason: collision with root package name */
        private Notification.Builder f0a;

        /* renamed from: b  reason: collision with root package name */
        private Bundle f1b;
        private RemoteViews c;
        private RemoteViews d;

        private static String $(int i, int i2, int i3) {
            char[] cArr = new char[i2 - i];
            for (int i4 = 0; i4 < i2 - i; i4++) {
                cArr[i4] = (char) ($[i + i4] ^ i3);
            }
            return new String(cArr);
        }

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            PendingIntent pendingIntent3;
            boolean z6 = true;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                pendingIntent3 = pendingIntent2;
            } else {
                pendingIntent3 = pendingIntent2;
                z6 = false;
            }
            this.f0a = deleteIntent.setFullScreenIntent(pendingIntent3, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str).setGroupSummary(z5).setSortKey(str2);
            Bundle bundle2 = new Bundle();
            this.f1b = bundle2;
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                this.f1b.putStringArray($(0, 14, 345), (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            this.c = remoteViews2;
            this.d = remoteViews3;
        }

        @Override // a.a.a.a.y
        public Notification.Builder a() {
            return this.f0a;
        }

        @Override // a.a.a.a.y
        public Notification b() {
            this.f0a.setExtras(this.f1b);
            Notification build = this.f0a.build();
            RemoteViews remoteViews = this.c;
            if (remoteViews != null) {
                build.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.d;
            if (remoteViews2 != null) {
                build.bigContentView = remoteViews2;
            }
            return build;
        }

        @Override // a.a.a.a.x
        public void c(d0.a aVar) {
            a0.a(this.f0a, aVar);
        }
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a(Notification.Builder builder, d0.a aVar) {
        Notification.Action.Builder builder2 = new Notification.Action.Builder(aVar.d(), aVar.f(), aVar.a());
        if (aVar.e() != null) {
            for (RemoteInput remoteInput : k0.a(aVar.e())) {
                builder2.addRemoteInput(remoteInput);
            }
        }
        Bundle bundle = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle.putBoolean($(0, 37, 2418), aVar.b());
        builder2.addExtras(bundle);
        builder.addAction(builder2.build());
    }
}
