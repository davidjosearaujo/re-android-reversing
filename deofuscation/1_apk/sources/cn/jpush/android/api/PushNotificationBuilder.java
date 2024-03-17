package cn.jpush.android.api;

import android.app.Notification;
import android.content.Context;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface PushNotificationBuilder {
    Notification buildNotification(Context context, NotificationMessage notificationMessage);

    Notification buildNotification(Map<String, String> map);

    String getDeveloperArg0();
}
