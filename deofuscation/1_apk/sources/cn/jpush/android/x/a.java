package cn.jpush.android.x;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Locale;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {

    /* renamed from: cn.jpush.android.x.a$a */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class C0022a {
        public String a;
        public CharSequence b;
        public int c;
        public int d;
        public int e;
        public String f;
        public Uri g;
        public boolean h;

        public C0022a(String str, CharSequence charSequence, int i, int i2, String str2) {
            this.a = str;
            this.b = charSequence;
            this.c = i;
            this.e = i2;
            this.f = str2;
        }
    }

    private static int a(int i) {
        if (i != -2) {
            if (i != -1) {
                return (i == 1 || i == 2) ? 4 : 3;
            }
            return 2;
        }
        return 1;
    }

    private static NotificationChannel a(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 26 && !TextUtils.isEmpty(str)) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
                NotificationChannel notificationChannel = notificationManager != null ? notificationManager.getNotificationChannel(str) : null;
                if (notificationChannel != null) {
                    Logger.dd("ChannelHelper", "channel has created: " + str);
                    return notificationChannel;
                }
                Logger.dd("ChannelHelper", "not found channed id from user set,will use sdk default channel ID");
            }
        } catch (Throwable th) {
            Logger.e("ChannelHelper", "config channelID error,will use sdk default channel ID:" + th);
        }
        return null;
    }

    private static String a(Context context, int i) {
        boolean z;
        String str;
        String str2 = i != -2 ? i != -1 ? (i == 1 || i == 2) ? "HIGH" : MessengerShareContentUtility.PREVIEW_DEFAULT : "LOW" : "MIN";
        String str3 = "";
        try {
            String str4 = "jg_channel_name_p_" + str2.toLowerCase();
            int identifier = context.getResources().getIdentifier(str4, "string", context.getPackageName());
            if (identifier != 0) {
                str3 = context.getResources().getString(identifier);
                str = "found " + str3 + " from resource by name:" + str4;
            } else {
                str = "not found string value from resource by name:" + str4;
            }
            Logger.dd("ChannelHelper", str);
        } catch (Throwable th) {
            Logger.ww("ChannelHelper", "get resource channel ID failed:" + th.getMessage());
        }
        if (TextUtils.isEmpty(str3)) {
            try {
                z = Locale.getDefault().getLanguage().contains("zh");
            } catch (Throwable th2) {
                Logger.ww("ChannelHelper", "get language failed:" + th2.getMessage());
                z = true;
            }
            if (i == -2 || i == -1) {
                return z ? "不重要" : "LOW";
            } else if (i == 1 || i == 2) {
                return z ? "重要" : "HIGH";
            } else {
                return z ? "普通" : "NORMAL";
            }
        }
        return str3;
    }

    private static String a(Context context, int i, int i2) {
        int a = a(i);
        String str = "JPush_" + a + "_" + i2;
        String a2 = a(context, i);
        Logger.d("ChannelHelper", "channelId:" + str + ",channelName:" + a2);
        return a(context, str, a2, a, i2, null) ? str : "";
    }

    private static String a(C0022a c0022a) {
        String str = "JPush_" + c0022a.d + "_" + c0022a.e;
        if (c0022a.g != null) {
            return str + "_" + c0022a.f;
        }
        return str;
    }

    public static void a(Context context) {
        a(context, -1, 0);
        a(context, 0, 7);
    }

    public static void a(Context context, Notification.Builder builder, String str, CharSequence charSequence, int i, int i2, String str2) {
        C0022a c0022a = new C0022a(str, charSequence, i, i2, str2);
        a(context, c0022a);
        c.a(context, builder, c0022a);
    }

    public static void a(Context context, Notification notification, String str, CharSequence charSequence, int i, int i2, String str2) {
        C0022a c0022a = new C0022a(str, charSequence, i, i2, str2);
        a(context, c0022a);
        c.a(notification, c0022a);
    }

    public static void a(Context context, C0022a c0022a) {
        NotificationChannel a;
        NotificationChannel a2;
        if (c.c(context)) {
            Logger.d("ChannelHelper", "in silence push time,change defaults to 0");
            c0022a.a = "";
            c0022a.e = 0;
            c0022a.f = null;
        } else if (Build.VERSION.SDK_INT >= 26 && (a = a(context, c0022a.a)) != null) {
            c0022a.a = a.getId();
            c0022a.b = a.getName();
            int importance = a.getImportance();
            c0022a.d = importance;
            c0022a.c = b(importance);
            Uri sound = a.getSound();
            c0022a.g = sound;
            if (sound != null) {
                c0022a.f = sound.getPath();
            }
            c0022a.h = true;
            return;
        }
        int i = c0022a.c;
        if (i == -2 || i == -1) {
            c0022a.e = 0;
            c0022a.f = null;
        } else if (i >= 0 && c0022a.e == 0 && TextUtils.isEmpty(c0022a.f)) {
            c0022a.c = -1;
        }
        c0022a.e &= 7;
        if (c0022a.c == 2) {
            c0022a.c = 1;
        }
        int a3 = a(c0022a.c);
        c0022a.d = a3;
        c0022a.c = b(a3);
        Uri a4 = c.a(context, c0022a.f);
        c0022a.g = a4;
        if (a4 != null) {
            c0022a.e &= -2;
        } else {
            c0022a.f = null;
        }
        if (TextUtils.isEmpty(c0022a.a)) {
            String a5 = a(c0022a);
            c0022a.a = a5;
            if (Build.VERSION.SDK_INT >= 26 && (a2 = a(context, a5)) != null) {
                c0022a.a = a2.getId();
                c0022a.b = a2.getName();
                c0022a.h = true;
                return;
            }
        }
        if (TextUtils.isEmpty(c0022a.b)) {
            c0022a.b = ("KG_channel_normal".equals(c0022a.a) && "com.tencent.karaoke".equals(context.getPackageName())) ? "普通_K歌" : a(context, c0022a.c);
        }
        Logger.d("ChannelHelper", "create channelId:" + c0022a.a + ",channelName:" + ((Object) c0022a.b) + " soundUri:" + c0022a.g);
        c0022a.h = a(context, c0022a.a, c0022a.b, c0022a.d, c0022a.e, c0022a.g);
    }

    private static boolean a(Context context, String str, CharSequence charSequence, int i, int i2, Uri uri) {
        if (Build.VERSION.SDK_INT < 26 || context.getApplicationInfo().targetSdkVersion < 26) {
            Logger.d("ChannelHelper", "sdkversion < 26, no need use notificationChannel!");
            return false;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
            if (notificationManager == null) {
                Logger.ee("ChannelHelper", "NotificationManager is null!");
                return false;
            }
            Logger.dd("ChannelHelper", "prepare NotificationChannel, channelId=" + str + "");
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
            if (notificationChannel != null) {
                notificationChannel.setName(charSequence);
                notificationManager.createNotificationChannel(notificationChannel);
                return true;
            }
            NotificationChannel notificationChannel2 = new NotificationChannel(str, charSequence, i);
            if (Build.VERSION.SDK_INT < 28 || notificationManager.getNotificationChannelGroup("JIGUANG_CHANNEL_GROUP") == null) {
                notificationManager.createNotificationChannelGroup(new NotificationChannelGroup("JIGUANG_CHANNEL_GROUP", cn.jpush.android.ac.a.b(context)));
            }
            notificationChannel2.setGroup("JIGUANG_CHANNEL_GROUP");
            notificationChannel2.enableLights((i2 & 4) != 0);
            notificationChannel2.enableVibration((i2 & 2) != 0);
            if (uri != null) {
                notificationChannel2.setSound(uri, null);
            } else {
                if (!((i2 & 1) != 0)) {
                    notificationChannel2.setSound(null, null);
                }
            }
            notificationManager.createNotificationChannel(notificationChannel2);
            return true;
        } catch (Throwable th) {
            Logger.ee("ChannelHelper", "new NotificationChannel fail:" + th);
            return false;
        }
    }

    private static int b(int i) {
        if (i != 1) {
            if (i != 2) {
                return (i == 4 || i == 5) ? 1 : 0;
            }
            return -1;
        }
        return -2;
    }
}
