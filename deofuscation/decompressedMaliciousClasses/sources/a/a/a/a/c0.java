package a.a.a.a;

import a.a.a.a.d0;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@TargetApi(24)
/* loaded from: /home/remnux/decompressedMalicious.dex */
class c0 {

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class a implements y, x {
        private static short[] $ = {3435, 3428, 3438, 3448, 3429, 3427, 3438, 3364, 3449, 3455, 3450, 3450, 3429, 3448, 3454, 3364, 3435, 3430, 3430, 3429, 3453, 3405, 3439, 3428, 3439, 3448, 3435, 3454, 3439, 3438, 3416, 3439, 3450, 3430, 3427, 3439, 3449};

        /* renamed from: a  reason: collision with root package name */
        private Notification.Builder f10a;

        private static String $(int i, int i2, int i3) {
            char[] cArr = new char[i2 - i];
            for (int i4 = 0; i4 < i2 - i; i4++) {
                cArr[i4] = (char) ($[i + i4] ^ i3);
            }
            return new String(cArr);
        }

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i5, int i6, Notification notification2, String str2, boolean z5, String str3, CharSequence[] charSequenceArr, RemoteViews remoteViews2, RemoteViews remoteViews3, RemoteViews remoteViews4) {
            PendingIntent pendingIntent3;
            boolean z6 = true;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                pendingIntent3 = pendingIntent2;
            } else {
                pendingIntent3 = pendingIntent2;
                z6 = false;
            }
            Notification.Builder remoteInputHistory = deleteIntent.setFullScreenIntent(pendingIntent3, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setExtras(bundle).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2).setRemoteInputHistory(charSequenceArr);
            this.f10a = remoteInputHistory;
            if (remoteViews2 != null) {
                remoteInputHistory.setCustomContentView(remoteViews2);
            }
            if (remoteViews3 != null) {
                this.f10a.setCustomBigContentView(remoteViews3);
            }
            if (remoteViews4 != null) {
                this.f10a.setCustomHeadsUpContentView(remoteViews4);
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.f10a.addPerson(it.next());
            }
        }

        @Override // a.a.a.a.y
        public Notification.Builder a() {
            return this.f10a;
        }

        @Override // a.a.a.a.y
        public Notification b() {
            return this.f10a.build();
        }

        @Override // a.a.a.a.x
        public void c(d0.a aVar) {
            Notification.Action.Builder builder = new Notification.Action.Builder(aVar.d(), aVar.f(), aVar.a());
            if (aVar.e() != null) {
                for (RemoteInput remoteInput : k0.a(aVar.e())) {
                    builder.addRemoteInput(remoteInput);
                }
            }
            Bundle bundle = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
            bundle.putBoolean($(0, 37, 3338), aVar.b());
            builder.addExtras(bundle);
            builder.setAllowGeneratedReplies(aVar.b());
            this.f10a.addAction(builder.build());
        }
    }

    public static void a(y yVar, CharSequence charSequence, CharSequence charSequence2, List<CharSequence> list, List<Long> list2, List<CharSequence> list3, List<String> list4, List<Uri> list5) {
        Notification.MessagingStyle conversationTitle = new Notification.MessagingStyle(charSequence).setConversationTitle(charSequence2);
        for (int i = 0; i < list.size(); i++) {
            Notification.MessagingStyle.Message message = new Notification.MessagingStyle.Message(list.get(i), list2.get(i).longValue(), list3.get(i));
            if (list4.get(i) != null) {
                message.setData(list4.get(i), list5.get(i));
            }
            conversationTitle.addMessage(message);
        }
        conversationTitle.setBuilder(yVar.a());
    }
}
