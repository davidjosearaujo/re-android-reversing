package a.a.a.a;

import a.a.a.a.d0;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class b0 implements y, x {

    /* renamed from: a  reason: collision with root package name */
    private Notification.Builder f6a;

    /* renamed from: b  reason: collision with root package name */
    private Bundle f7b;
    private RemoteViews c;
    private RemoteViews d;
    private RemoteViews e;

    public b0(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i5, int i6, Notification notification2, String str2, boolean z5, String str3, RemoteViews remoteViews2, RemoteViews remoteViews3, RemoteViews remoteViews4) {
        PendingIntent pendingIntent3;
        boolean z6 = true;
        Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
        if ((notification.flags & 128) != 0) {
            pendingIntent3 = pendingIntent2;
        } else {
            pendingIntent3 = pendingIntent2;
            z6 = false;
        }
        this.f6a = deleteIntent.setFullScreenIntent(pendingIntent3, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2);
        Bundle bundle2 = new Bundle();
        this.f7b = bundle2;
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            this.f6a.addPerson(it.next());
        }
        this.c = remoteViews2;
        this.d = remoteViews3;
        this.e = remoteViews4;
    }

    @Override // a.a.a.a.y
    public Notification.Builder a() {
        return this.f6a;
    }

    @Override // a.a.a.a.y
    public Notification b() {
        this.f6a.setExtras(this.f7b);
        Notification build = this.f6a.build();
        RemoteViews remoteViews = this.c;
        if (remoteViews != null) {
            build.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.d;
        if (remoteViews2 != null) {
            build.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.e;
        if (remoteViews3 != null) {
            build.headsUpContentView = remoteViews3;
        }
        return build;
    }

    @Override // a.a.a.a.x
    public void c(d0.a aVar) {
        a0.a(this.f6a, aVar);
    }
}
