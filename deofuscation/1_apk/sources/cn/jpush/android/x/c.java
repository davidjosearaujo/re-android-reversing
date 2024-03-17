package cn.jpush.android.x;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.api.PushNotificationBuilder;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JNotifyActivity;
import cn.jpush.android.service.JPushMessageReceiver;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import cn.jpush.android.x.a;
import cn.jpush.android.x.f;
import com.alibaba.fastjson.asm.Label;
import com.facebook.common.util.UriUtil;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginStatusClient;
import com.facebook.share.internal.ShareConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.hunantv.media.player.MgtvMediaPlayer;
import java.io.File;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;
import java.util.zip.Adler32;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    private static Boolean a;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a extends cn.jpush.android.ac.e {
        private Context a;
        private cn.jpush.android.d.d b;

        public a(Context context, cn.jpush.android.d.d dVar) {
            this.a = context;
            this.b = dVar;
            this.f = "NotificationHelper#NotifyAction";
        }

        public static void a(Context context, cn.jpush.android.d.d dVar) {
            c.q(context, dVar);
            int i = dVar.Z;
            if (i != 0 && i != 4) {
                c.p(context, dVar);
                return;
            }
            cn.jpush.android.helper.c.a(dVar.c, 995, context);
            c.b(context, dVar);
        }

        @Override // cn.jpush.android.ac.e
        public void a() {
            try {
                long b = cn.jpush.android.ac.b.b(this.b.ar);
                long b2 = cn.jpush.android.ac.b.b(this.b.as);
                if (b > 0 && b == b2) {
                    Logger.ww("NotificationHelper", "the beginTime == endTime,not deal this notification");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (b2 > 0) {
                    if (b2 < b) {
                        Logger.e("NotificationHelper", "illegal argument, endTime earlier than beginTime");
                        return;
                    } else if (b2 < currentTimeMillis) {
                        Logger.w("NotificationHelper", this.b.c + " already end");
                        cn.jpush.android.helper.c.a(this.b.c, 1034, this.a);
                        return;
                    }
                }
                if (b >= currentTimeMillis) {
                    f.a().a(this.a, new f.a(b, this.b, false));
                    cn.jpush.android.helper.c.a(this.b.c, 1035, this.a);
                } else if (c.l(this.a, this.b)) {
                } else {
                    a(this.a, this.b);
                    if (b2 > 0) {
                        f.a().a(this.a, new f.a(b2, c.a(this.b)));
                    }
                }
            } catch (Throwable th) {
                Logger.w("NotificationHelper", "run NotifyAction failed:" + th.getMessage());
            }
        }
    }

    private static int a(int i) {
        if (i != 0) {
            if (i != 1) {
                return i != 2 ? 1 : 32;
            }
            return 16;
        }
        return 1;
    }

    public static int a(cn.jpush.android.d.d dVar) {
        return a(TextUtils.isEmpty(dVar.g) ? dVar.c : dVar.g, 0);
    }

    public static int a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            Logger.d("NotificationHelper", "action:getNotificationID - empty messageId");
            return 0;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception unused) {
            Logger.w("NotificationHelper", "Ths msgId is not a integer");
            Adler32 adler32 = new Adler32();
            adler32.update(str.getBytes());
            int value = (int) adler32.getValue();
            return value < 0 ? Math.abs(value) : value;
        }
    }

    public static Notification a(Notification.Builder builder) {
        try {
            return Build.VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification();
        } catch (Throwable th) {
            Logger.ww("NotificationHelper", "Build notification error:" + th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.app.Notification a(android.content.Context r9, cn.jpush.android.d.d r10, android.widget.RemoteViews r11, boolean r12, cn.jpush.android.x.d r13, cn.jpush.android.x.d r14) {
        /*
            Method dump skipped, instructions count: 535
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.c.a(android.content.Context, cn.jpush.android.d.d, android.widget.RemoteViews, boolean, cn.jpush.android.x.d, cn.jpush.android.x.d):android.app.Notification");
    }

    public static Intent a(Context context, String str, cn.jpush.android.d.d dVar) {
        Intent intent = new Intent(str);
        intent.setClass(context, PushActivity.class);
        if (dVar != null) {
            intent.putExtra("msg_data", dVar.c());
        }
        if (!cn.jpush.android.ac.a.k(context) && Build.VERSION.SDK_INT >= 11) {
            intent.addFlags(32768);
        }
        return intent;
    }

    @TargetApi(23)
    private static Icon a(String str) {
        try {
            if (new File(str).exists()) {
                return Icon.createWithFilePath(str);
            }
            Logger.w("NotificationHelper", "icon file doesn't exist, path=" + str);
            return null;
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "createIcon err:" + th);
            return null;
        }
    }

    public static Uri a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (context.getResources().getIdentifier(str, "raw", context.getPackageName()) == 0) {
                Logger.d("NotificationHelper", "not found sound=" + str);
                return null;
            }
            Uri parse = Uri.parse("android.resource://" + context.getPackageName() + "/raw/" + str);
            StringBuilder sb = new StringBuilder();
            sb.append("found sound uri=");
            sb.append(parse);
            Logger.d("NotificationHelper", sb.toString());
            return parse;
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "find sound e:" + th);
            return null;
        }
    }

    private static PushNotificationBuilder a(Context context, NotificationMessage notificationMessage) {
        try {
            Class<?> cls = Class.forName("cn.jpush.android.support.JPushSupport");
            return (PushNotificationBuilder) cls.getDeclaredMethod("getNotificationBuilder", Context.class, NotificationMessage.class).invoke(cls, context, notificationMessage);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static cn.jpush.android.d.d a(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("msg_data");
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        return cn.jpush.android.d.d.a(stringExtra);
    }

    @TargetApi(11)
    public static d a(Context context, String str, int i) {
        d dVar = new d();
        Object b = b(context, str, i);
        if (b == null) {
            dVar.c(973);
            return dVar;
        }
        if (Build.VERSION.SDK_INT >= 23 && (b instanceof Icon)) {
            dVar.a(102);
            dVar.a(b);
        } else if (!(b instanceof Bitmap)) {
            dVar.c(973);
            return dVar;
        } else {
            dVar.a(100);
            dVar.a((Bitmap) b);
        }
        return dVar;
    }

    @TargetApi(11)
    public static d a(Context context, String str, String str2, String str3, String str4, String str5) {
        Icon a2;
        d dVar = new d();
        String str6 = "";
        int i = 0;
        try {
            if (TextUtils.isEmpty(str3)) {
                Logger.d("NotificationHelper", "[buildSmallIcon] smallIcon is empty");
            } else if (cn.jpush.android.ac.a.c(str3)) {
                str6 = d(JPushConstants.mApplicationContext, str3, 307200);
            } else {
                i = JPushConstants.mApplicationContext.getResources().getIdentifier(str3, "drawable", JPushConstants.mApplicationContext.getPackageName());
            }
        } catch (Throwable th) {
            Logger.d("NotificationHelper", "load small icon failed:" + th.getMessage());
        }
        if (!TextUtils.isEmpty(str6)) {
            try {
                Bitmap decodeFile = cn.jpush.android.ac.c.a(str6) ? BitmapFactory.decodeFile(str6) : null;
                if (decodeFile != null) {
                    Logger.d("NotificationHelper", "set small icon with path bitmap:" + decodeFile);
                    dVar.a(100);
                    dVar.a(decodeFile);
                    return dVar;
                }
                Logger.d("NotificationHelper", "not set small icon by bitmap");
                if (Build.VERSION.SDK_INT >= 23 && (a2 = a(str6)) != null) {
                    Logger.d("NotificationHelper", "set small icon success by path:" + str6);
                    dVar.a(102);
                    dVar.a(a2);
                    return dVar;
                }
            } catch (Throwable unused) {
                Logger.w("NotificationHelper", "resource not found with sdcard path");
            }
        }
        if (i != 0) {
            dVar.a(101);
            dVar.b(i);
            Logger.d("NotificationHelper", "set small icon success by resId:" + i + ",resName:" + str3);
            return dVar;
        } else if (TextUtils.isEmpty(str2) || str2.equals(context.getPackageName())) {
            int a3 = h.a(context);
            if (a3 == 0) {
                dVar.c(972);
                return dVar;
            }
            dVar.a(101);
            dVar.b(a3);
            Logger.d("NotificationHelper", "set small icon success by mine icon resId:" + a3);
            return dVar;
        } else {
            try {
                if (!cn.jpush.android.ac.a.a(context, str2, str5)) {
                    Logger.w("NotificationHelper", "targetApp ：" + str2 + " is not install,will give up notify the msg");
                    dVar.c(993);
                    return dVar;
                }
                Bitmap c = c(context, str2);
                if (c == null) {
                    Logger.w("NotificationHelper", "not found targetApp small icon bitmap,will give up notify the msg");
                    dVar.c(972);
                    return dVar;
                }
                dVar.a(100);
                dVar.a(c);
                Logger.d("NotificationHelper", "set small icon success by targetAppBitmap");
                return dVar;
            } catch (Throwable th2) {
                Logger.w("NotificationHelper", "set small icon by targetApp icon bitmap failed:" + th2.getMessage());
                dVar.c(972);
                return dVar;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:686:0x08cd, code lost:
        if (r2.length == 1) goto L212;
     */
    /* JADX WARN: Removed duplicated region for block: B:518:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:528:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:539:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:544:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:546:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:748:0x0a41  */
    /* JADX WARN: Removed duplicated region for block: B:768:0x0ab9  */
    /* JADX WARN: Removed duplicated region for block: B:783:0x0b2e  */
    /* JADX WARN: Removed duplicated region for block: B:784:0x0b30  */
    /* JADX WARN: Removed duplicated region for block: B:805:0x0ba8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:808:0x0bb2  */
    /* JADX WARN: Removed duplicated region for block: B:815:0x0bd3  */
    /* JADX WARN: Removed duplicated region for block: B:837:0x0c39  */
    /* JADX WARN: Removed duplicated region for block: B:840:0x0c48 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:841:0x0c49  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object a(android.content.Context r57, cn.jpush.android.d.d r58, cn.jpush.android.x.d r59, cn.jpush.android.x.d r60) {
        /*
            Method dump skipped, instructions count: 3242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.c.a(android.content.Context, cn.jpush.android.d.d, cn.jpush.android.x.d, cn.jpush.android.x.d):java.lang.Object");
    }

    public static void a(Notification notification, Context context, String str, String str2, PendingIntent pendingIntent) {
        try {
            Class.forName("android.app.Notification").getDeclaredMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification, context, str, str2, pendingIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Notification notification, a.C0022a c0022a) {
        if (c0022a != null) {
            try {
                if (Build.VERSION.SDK_INT < 16) {
                    notification.defaults = c0022a.e;
                    notification.sound = c0022a.g;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context) {
        while (true) {
            Integer valueOf = Integer.valueOf(g.a());
            if (valueOf.intValue() == 0) {
                return;
            }
            d(context, valueOf.intValue());
        }
    }

    public static void a(Context context, int i, int i2, String str) {
    }

    public static void a(Context context, int i, int i2, String str, Bundle bundle) {
        try {
            String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
            if (TextUtils.isEmpty(messageReceiverClass)) {
                return;
            }
            Intent intent = new Intent();
            intent.setClassName(context, messageReceiverClass);
            intent.setAction(cn.jpush.android.ac.a.f(context, "cmd_msg"));
            intent.putExtra("cmd", i);
            intent.putExtra(JThirdPlatFormInterface.KEY_CODE, i2);
            intent.putExtra("message", str);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            if (JPushConstants.getPushMessageReceiver(context) != null) {
                cn.jpush.android.helper.a.a(JPushConstants.getPushMessageReceiver(context), context, intent);
            } else {
                context.sendBroadcast(intent);
            }
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "sendCmdMsgToUser failed:" + th.getMessage());
        }
    }

    public static void a(Context context, int i, boolean z) {
        try {
            boolean z2 = true;
            if (d(context) != 1) {
                z2 = false;
            }
            Logger.d("NotificationHelper", "[checkNotificationSettings] new state:" + z2 + ",last state:" + a + ",soucre:" + i + ",isFocre:" + z);
            Boolean bool = a;
            if (bool != null && z2 == bool.booleanValue() && !z) {
                Logger.d("NotificationHelper", "[checkNotificationSettings] no change");
                return;
            }
            a = Boolean.valueOf(z2);
            JPushMessageReceiver pushMessageReceiver = JPushConstants.getPushMessageReceiver(context);
            if (pushMessageReceiver != null) {
                pushMessageReceiver.onNotificationSettingsCheck(context, a.booleanValue(), i);
                return;
            }
            Intent intent = new Intent(context, Class.forName(JPushConstants.getMessageReceiverClass(context)));
            intent.setAction("on_noti_settings_check");
            intent.putExtra("isOn", a);
            intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, i);
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "checkNotificationSettings e:" + th);
        }
    }

    public static void a(Context context, Notification.Builder builder, a.C0022a c0022a) {
        if (c0022a != null) {
            try {
                int i = Build.VERSION.SDK_INT;
                if (i >= 26 && c0022a.h) {
                    Logger.d("NotificationHelper", "setChannelId =" + c0022a.a);
                    e(context, c0022a.a);
                    builder.setChannelId(c0022a.a);
                }
                if (i >= 16) {
                    builder.setPriority(c0022a.c);
                    builder.setDefaults(c0022a.e);
                    builder.setSound(c0022a.g);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, cn.jpush.android.d.d dVar) {
        Logger.d("NotificationHelper", "[processMessage] pushEntity:" + dVar);
        if (dVar.aa == 0) {
            JCoreHelper.majorExecutor(context, JPushConstants.SDK_TYPE, new a(context, dVar));
            return;
        }
        Logger.d("NotificationHelper", "Unexpected: unknown show  mode - " + dVar.aa);
    }

    public static void a(Context context, Integer num, Notification notification) {
        if (num == null) {
            return;
        }
        Key<Integer> BadgeCurNum = Key.BadgeCurNum();
        int intValue = ((Integer) Sp.get(context, BadgeCurNum)).intValue();
        if (intValue < 0) {
            intValue = 0;
        }
        if (num.intValue() != 0) {
            if (num.intValue() + intValue < 0) {
                num = Integer.valueOf(-intValue);
            }
            intValue += num.intValue();
            Sp.set(context, BadgeCurNum.set(Integer.valueOf(intValue)));
        }
        Logger.d("NotificationHelper", "curNum：" + intValue + ",addNum:" + num);
        a(context, notification, num.intValue(), intValue);
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0154 A[Catch: all -> 0x0162, TryCatch #0 {all -> 0x0162, blocks: (B:77:0x0004, B:79:0x0013, B:81:0x0021, B:82:0x0024, B:84:0x0029, B:85:0x004b, B:88:0x0055, B:90:0x005d, B:134:0x014e, B:136:0x0154, B:137:0x0158, B:139:0x015e, B:91:0x006b, B:93:0x0072, B:94:0x0076, B:96:0x007e, B:97:0x0084, B:99:0x008c, B:100:0x0095, B:102:0x009b, B:103:0x00a4, B:105:0x00aa, B:106:0x00b3, B:108:0x00bb, B:109:0x00c4, B:113:0x00d0, B:114:0x00e2, B:115:0x00f2, B:117:0x00fa, B:118:0x0102, B:120:0x010a, B:121:0x0112, B:123:0x011a, B:124:0x0122, B:126:0x012a, B:127:0x0132, B:129:0x013a, B:130:0x0142, B:133:0x014b), top: B:144:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0158 A[Catch: all -> 0x0162, TryCatch #0 {all -> 0x0162, blocks: (B:77:0x0004, B:79:0x0013, B:81:0x0021, B:82:0x0024, B:84:0x0029, B:85:0x004b, B:88:0x0055, B:90:0x005d, B:134:0x014e, B:136:0x0154, B:137:0x0158, B:139:0x015e, B:91:0x006b, B:93:0x0072, B:94:0x0076, B:96:0x007e, B:97:0x0084, B:99:0x008c, B:100:0x0095, B:102:0x009b, B:103:0x00a4, B:105:0x00aa, B:106:0x00b3, B:108:0x00bb, B:109:0x00c4, B:113:0x00d0, B:114:0x00e2, B:115:0x00f2, B:117:0x00fa, B:118:0x0102, B:120:0x010a, B:121:0x0112, B:123:0x011a, B:124:0x0122, B:126:0x012a, B:127:0x0132, B:129:0x013a, B:130:0x0142, B:133:0x014b), top: B:144:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r5, java.lang.String r6, cn.jpush.android.d.d r7, android.content.Intent r8) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.c.a(android.content.Context, java.lang.String, cn.jpush.android.d.d, android.content.Intent):void");
    }

    private static boolean a() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
            if (!TextUtils.isEmpty(str)) {
                Logger.i("NotificationHelper", "get EMUI version is:" + str);
                return cn.jpush.android.ac.a.a(str.toLowerCase().replace("emotionui_", ""), "8.0") >= 0;
            }
        } catch (Throwable th) {
            Logger.e("NotificationHelper", " getEmuiVersion wrong error:" + th);
        }
        return false;
    }

    private static boolean a(Notification notification, int i) {
        if (notification != null) {
            try {
                Object obj = notification.getClass().getDeclaredField("extraNotification").get(notification);
                obj.getClass().getDeclaredMethod("setMessageCount", Integer.TYPE).invoke(obj, Integer.valueOf(i));
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean a(Context context, int i) {
        String str;
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                StatusBarNotification[] activeNotifications = ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).getActiveNotifications();
                Logger.d("NotificationHelper", "active size:" + activeNotifications.length);
                if (activeNotifications != null) {
                    int length = activeNotifications.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (activeNotifications[i2].getId() == i) {
                            z = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            if (z) {
                str = "show  notification success:" + i;
            } else {
                str = "show  notification maybe failed:" + i;
            }
            Logger.dd("NotificationHelper", str);
        } catch (Throwable th) {
            Logger.ww("NotificationHelper", "[checkNotficationShow] failed:" + th.getMessage());
        }
        return z;
    }

    @TargetApi(11)
    private static boolean a(Context context, Notification.Builder builder, d dVar, d dVar2) {
        boolean z;
        boolean z2;
        int a2 = dVar.a();
        if (a2 != 102 || Build.VERSION.SDK_INT < 23) {
            z = false;
        } else {
            builder.setSmallIcon((Icon) dVar.b());
            z = true;
        }
        if (!z && a2 == 100 && Build.VERSION.SDK_INT >= 23) {
            builder.setSmallIcon(Icon.createWithBitmap(dVar.c()));
            z = true;
        }
        if (!z && a2 == 101) {
            try {
                context.getResources().getDrawable(dVar.d());
                z2 = true;
            } catch (Throwable unused) {
                Logger.w("NotificationHelper", "resource not found with local app");
                z2 = false;
            }
            if (z2) {
                Logger.d("NotificationHelper", "set small icon by local resId:" + dVar.d());
                builder.setSmallIcon(Integer.valueOf(dVar.d()).intValue());
                z = true;
            }
        }
        if (z) {
            int a3 = dVar2.a();
            if (a3 == 102) {
                if (Build.VERSION.SDK_INT >= 23) {
                    builder.setLargeIcon((Icon) dVar2.b());
                }
            } else if (a3 == 100) {
                builder.setLargeIcon(dVar2.c());
            } else {
                Logger.d("NotificationHelper", "not set large icon");
            }
            return true;
        }
        return false;
    }

    public static boolean a(Context context, Notification notification, int i, int i2) {
        if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) {
            return a(notification, i);
        }
        if (!a()) {
            Logger.d("NotificationHelper", "not support");
            return false;
        } else if (i2 == 0 || i != 0) {
            return e(context, i2);
        } else {
            return false;
        }
    }

    public static boolean a(Context context, String str, cn.jpush.android.d.d dVar, NotificationMessage notificationMessage) {
        try {
        } catch (Throwable th) {
            Logger.ww("NotificationHelper", "check display foreground failed:" + th.getMessage());
        }
        if (Class.forName(str).getMethod("onNotifyMessageUnShow", Context.class, NotificationMessage.class) == null) {
            Logger.dd("NotificationHelper", "not found onNotifyMessageUnShow method");
            return false;
        }
        if (!TextUtils.isEmpty(dVar.F)) {
            if (dVar.F.equals("0")) {
                if (cn.jpush.android.ac.a.k(context)) {
                    Logger.dd("NotificationHelper", "displayForeground...");
                    a(context, "cn.jpush.android.intent.NOTIFICATION_UN_SHOW", dVar, (Intent) null);
                    cn.jpush.android.helper.c.a(dVar.c, 1060, context);
                    return true;
                }
            } else if (!((JPushMessageReceiver) Class.forName(str).newInstance()).isNeedShowNotification(context, notificationMessage, cn.jpush.android.ac.a.d(context))) {
                Logger.dd("NotificationHelper", "need not show notication by user");
                a(context, "cn.jpush.android.intent.NOTIFICATION_UN_SHOW", dVar, (Intent) null);
                cn.jpush.android.helper.c.a(dVar.c, 1061, context);
                return true;
            }
        }
        return false;
    }

    public static boolean a(Context context, String str, String str2) {
        boolean c;
        if (TextUtils.isEmpty(str)) {
            Logger.d("NotificationHelper", "link uri is empty");
            return false;
        }
        try {
            Logger.d("NotificationHelper", "url:" + str);
            if (str.startsWith(UriUtil.HTTP_SCHEME)) {
                c = f(context, str);
            } else {
                Logger.d("NotificationHelper", "jump intent:" + str);
                c = c(context, str, str2);
            }
            return c;
        } catch (Throwable th) {
            Logger.d("NotificationHelper", "[handleSSP] start fail uri error:" + th.getMessage());
            a(context, (int) MgtvMediaPlayer.MGTVMEDIA_ERROR_100002, 1, str + "---" + th.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2, String str3, int i) {
        Logger.d("NotificationHelper", "[handleWxMini] appid=" + str + ",originid=" + str2 + ",path=" + str3 + ", type=" + i);
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                Logger.d("NotificationHelper", "launchWXUsingPendingIntent");
                j.l.c.e0.a.a.d.a(context, 1, context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"), 201326592).send(context, 2, null, new PendingIntent.OnFinished() { // from class: cn.jpush.android.x.c.1
                    @Override // android.app.PendingIntent.OnFinished
                    public void onSendFinished(PendingIntent pendingIntent, Intent intent, int i2, String str4, Bundle bundle) {
                        Logger.d("NotificationHelper", "onSendFinished resultCode: " + i2 + ", resultData: " + str4);
                    }
                }, null);
            }
            try {
                ContentResolver contentResolver = context.getContentResolver();
                Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram");
                Cursor query = contentResolver.query(parse, null, null, new String[]{str, str2, str3, "" + i, ""}, null);
                if (query != null) {
                    query.close();
                }
                return true;
            } catch (Throwable th) {
                Logger.d("NotificationHelper", "[handleWxMini] open wx mini failed,e:" + th.getMessage());
                return false;
            }
        } catch (Throwable th2) {
            Logger.w("NotificationHelper", "launchWXUsingPendingIntent pendingIntent send failed: " + th2.getMessage());
            return false;
        }
    }

    public static Intent b(Context context, String str, cn.jpush.android.d.d dVar) {
        Intent intent = new Intent(str);
        intent.setClass(context, PopWinActivity.class);
        if (dVar != null) {
            intent.putExtra("msg_data", dVar.c());
        }
        return intent;
    }

    public static NotificationMessage b(Context context, Intent intent) {
        cn.jpush.android.d.d a2 = a(context, intent);
        NotificationMessage notificationMessage = new NotificationMessage();
        if (a2 != null) {
            notificationMessage = a2.b();
        }
        if (TextUtils.isEmpty(notificationMessage.appkey)) {
            notificationMessage.appkey = JCoreHelper.getAppKey(context);
        }
        return notificationMessage;
    }

    public static Object b(Context context, String str) {
        return b(context, str, 307200);
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00a0 A[Catch: all -> 0x00ef, TryCatch #1 {all -> 0x00ef, blocks: (B:72:0x0055, B:73:0x006f, B:82:0x00a0, B:85:0x00a8, B:86:0x00be, B:96:0x00e8, B:87:0x00c2, B:89:0x00c8, B:91:0x00ce, B:74:0x0073, B:76:0x0079, B:78:0x0084), top: B:105:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object b(android.content.Context r6, java.lang.String r7, int r8) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.c.b(android.content.Context, java.lang.String, int):java.lang.Object");
    }

    private static String b(Context context, String str, String str2) {
        if (!cn.jpush.android.ac.a.b(str)) {
            Logger.i("NotificationHelper", "The url is not a picture resources.");
            return "";
        }
        Logger.i("NotificationHelper", "The url is a picture resources.");
        String str3 = cn.jpush.android.ac.c.c(context, str2) + (str2 + cn.jpush.android.ac.a.a(str));
        Logger.i("NotificationHelper", "Big picture notification resource path: " + str3);
        byte[] a2 = cn.jpush.android.w.a.a(str, 5, (long) LoginStatusClient.DEFAULT_TOAST_DURATION_MS, 4);
        return (a2 == null || !cn.jpush.android.ac.c.a(str3, a2)) ? "" : str3;
    }

    public static void b(Context context, int i) {
        int a2;
        if (!g.b(i)) {
            g.a(i);
        }
        int i2 = cn.jpush.android.cache.a.i(context);
        Logger.d("NotificationHelper", "queueSize:" + g.b() + ", max num:" + i2);
        if (g.b() <= i2 || (a2 = g.a()) == 0) {
            return;
        }
        d(context, a2);
    }

    public static void b(Context context, int i, int i2, String str) {
        a(context, i, i2, str, (Bundle) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:356:0x03be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.content.Context r23, cn.jpush.android.d.d r24) {
        /*
            Method dump skipped, instructions count: 1000
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.c.b(android.content.Context, cn.jpush.android.d.d):void");
    }

    public static boolean b(Context context) {
        try {
            if (!cn.jpush.android.cache.a.f(context)) {
                Logger.ii("NotificationHelper", "Notification was disabled by JPushInterface.setPushTime !");
                return false;
            }
            String g = cn.jpush.android.cache.a.g(context);
            if (TextUtils.isEmpty(g)) {
                Logger.i("NotificationHelper", "no time limited");
                return true;
            }
            Logger.i("NotificationHelper", "push time is ：" + g);
            String[] split = g.split("_");
            String str = split[0];
            String str2 = split[1];
            char[] charArray = str.toCharArray();
            String[] split2 = str2.split("\\^");
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(7);
            int i2 = calendar.get(11);
            for (char c : charArray) {
                if (i == Integer.valueOf(String.valueOf(c)).intValue() + 1) {
                    int intValue = Integer.valueOf(split2[0]).intValue();
                    int intValue2 = Integer.valueOf(split2[1]).intValue();
                    if (i2 >= intValue && i2 <= intValue2) {
                        return true;
                    }
                }
            }
            Logger.ii("NotificationHelper", "Current time is out of the push time - " + g);
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    private static Intent c(Context context, String str, cn.jpush.android.d.d dVar) {
        Intent intent = new Intent(str);
        intent.setClass(context, JNotifyActivity.class);
        intent.setFlags(8388608);
        if (dVar != null) {
            intent.putExtra("msg_data", dVar.c());
        }
        return intent;
    }

    public static synchronized Bitmap c(Context context, String str) {
        synchronized (c.class) {
            try {
                PackageManager packageManager = context.getApplicationContext().getPackageManager();
                Drawable applicationIcon = packageManager.getApplicationIcon(packageManager.getApplicationInfo(str, 0));
                if (applicationIcon != null) {
                    if (Build.VERSION.SDK_INT < 26 || !(applicationIcon instanceof AdaptiveIconDrawable)) {
                        return ((BitmapDrawable) applicationIcon).getBitmap();
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(applicationIcon.getIntrinsicWidth(), applicationIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    applicationIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    applicationIcon.draw(canvas);
                    Logger.d("NotificationHelper", "adaptive-icon to bitmap");
                    return createBitmap;
                }
            } catch (Throwable th) {
                Logger.w("NotificationHelper", "getTargetAppBitmap failed:" + th.getMessage());
            }
            return null;
        }
    }

    public static String c(Context context, String str, int i) {
        if (!cn.jpush.android.ac.a.b(str)) {
            Logger.i("NotificationHelper", "The url is not a picture resources.");
            return "";
        }
        Logger.i("NotificationHelper", "The url is a picture resources.");
        String d = cn.jpush.android.ac.a.d(str);
        if (TextUtils.isEmpty(d)) {
            d = UUID.randomUUID().toString();
        }
        String str2 = cn.jpush.android.ac.c.c(context, "noti_res") + (d + cn.jpush.android.ac.a.a(str));
        Logger.i("NotificationHelper", "picture notification resource path: " + str2);
        if (!new File(str2).exists()) {
            byte[] a2 = cn.jpush.android.w.a.a(str, 2, i);
            return (a2 == null || !cn.jpush.android.ac.c.a(str2, a2)) ? "" : str2;
        }
        Logger.d("NotificationHelper", "need not download again with same url:" + str);
        return str2;
    }

    public static void c(Context context, int i) {
        if (i <= 0) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            Integer valueOf = Integer.valueOf(g.a());
            if (valueOf.intValue() != 0) {
                d(context, valueOf.intValue());
            }
        }
    }

    private static void c(Context context, Intent intent) {
        if ("com.mt.mtxx.mtxx".equals(context.getPackageName())) {
            intent.putExtra("infoProvider", "JPush");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:158:0x01a4, code lost:
        if (r0 == 4) goto L117;
     */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.content.Context r27, cn.jpush.android.d.d r28) {
        /*
            Method dump skipped, instructions count: 1011
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.c.c(android.content.Context, cn.jpush.android.d.d):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x00c5, code lost:
        if (r7 <= r2) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00b9, code lost:
        if (r8 <= 23) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x00bd, code lost:
        if (r8 < r6) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00c1, code lost:
        if (r7 >= r5) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.c.c(android.content.Context):boolean");
    }

    private static boolean c(Context context, String str, String str2) {
        try {
            Intent parseUri = Build.VERSION.SDK_INT >= 22 ? Intent.parseUri(str, 4) : Intent.parseUri(str, 0);
            parseUri.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            if (!TextUtils.isEmpty(str2)) {
                parseUri.setPackage(str2);
            }
            if (context.getPackageManager().resolveActivity(parseUri, 0) == null) {
                Logger.d("NotificationHelper", "deeplink is wrong, " + str);
                return false;
            }
            c(context, parseUri);
            j.l.c.e0.a.a.a.h(parseUri);
            context.startActivity(parseUri);
            a(context, (int) MgtvMediaPlayer.MGTVMEDIA_ERROR_100002, 0, str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public static int d(Context context) {
        StringBuilder sb;
        String str;
        if (JCoreHelper.checkSdkBanned(context).booleanValue()) {
            Logger.ww("NotificationHelper", "sdk is banned, call failed");
            return 0;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
                if (notificationManager != null) {
                    boolean areNotificationsEnabled = notificationManager.areNotificationsEnabled();
                    Logger.d("NotificationHelper", "from NotificationManager enable=" + areNotificationsEnabled);
                    return areNotificationsEnabled ? 1 : 0;
                }
                return -1;
            } catch (Throwable th) {
                th = th;
                sb = new StringBuilder();
                str = "isNotificationEnabled e:";
            }
        } else if (i < 19) {
            Logger.d("NotificationHelper", "below 19 return true");
            return 1;
        } else {
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i2 = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class<?> cls2 = Integer.TYPE;
                ?? r1 = ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i2), packageName)).intValue() == 0 ? 1 : 0;
                Logger.d("NotificationHelper", "from AppOpsManager enable=" + ((boolean) r1));
                return r1;
            } catch (Throwable th2) {
                th = th2;
                sb = new StringBuilder();
                str = "appOps check e:";
            }
        }
        sb.append(str);
        sb.append(th);
        Logger.w("NotificationHelper", sb.toString());
        return -1;
    }

    private static String d(Context context, String str, int i) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(JPushConstants.HTTP_PRE) || str.startsWith(JPushConstants.HTTPS_PRE)) {
            if (cn.jpush.android.ac.a.a()) {
                String c = c(context, str, i);
                if (!TextUtils.isEmpty(c)) {
                    return c;
                }
                str2 = "Get network picture failed.";
            } else {
                str2 = "SDCard is not mounted,need not download pic";
            }
            Logger.ww("NotificationHelper", str2);
            return null;
        }
        return null;
    }

    public static void d(Context context, int i) {
        try {
            Logger.d("NotificationHelper", "action:cleanNotification - notificationId:" + i);
            ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).cancel(i);
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "cancelNotification failed:" + th.getMessage());
        }
    }

    public static void d(Context context, cn.jpush.android.d.d dVar) {
        int i;
        int i2;
        int i3;
        Notification notification;
        int m = m(context, dVar);
        int identifier = context.getResources().getIdentifier(m == 3 ? "push_notification_middle" : m == 4 ? "push_notification_large" : "push_notification", "layout", context.getPackageName());
        Logger.d("NotificationHelper", "layoutId:" + identifier);
        if (identifier <= 0) {
            return;
        }
        int g = cn.jpush.android.helper.i.g();
        Logger.d("NotificationHelper", "use notification style :" + g);
        int identifier2 = context.getResources().getIdentifier("push_notification_style_default", "id", context.getPackageName());
        if (g != 0) {
            Resources resources = context.getResources();
            i = resources.getIdentifier("push_notification_style_" + g, "id", context.getPackageName());
            if (i <= 0) {
                Logger.ww("NotificationHelper", "not found push_notification_style_" + g + " in layout");
                return;
            }
        } else {
            i = 0;
        }
        int identifier3 = context.getResources().getIdentifier("push_notification_fb_content", "id", context.getPackageName());
        int identifier4 = context.getResources().getIdentifier("push_notification_main_layout", "id", context.getPackageName());
        int identifier5 = context.getResources().getIdentifier("push_notification_layout_lefttop", "id", context.getPackageName());
        int identifier6 = context.getResources().getIdentifier("push_notification_banner_img", "id", context.getPackageName());
        int identifier7 = context.getResources().getIdentifier("push_notification_header_expand", "id", context.getPackageName());
        int identifier8 = context.getResources().getIdentifier("jpush_ic_action_close", "drawable", context.getPackageName());
        int identifier9 = context.getResources().getIdentifier("jpush_ic_action_close2", "drawable", context.getPackageName());
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), identifier);
        remoteViews.setViewVisibility(identifier3, 8);
        if (m == 2 && cn.jpush.android.helper.i.c()) {
            remoteViews.setViewVisibility(identifier6, 0);
        } else if ((m == 3 || m == 4) && cn.jpush.android.helper.i.b()) {
            remoteViews.setViewVisibility(identifier4, 0);
            remoteViews.setViewVisibility(identifier5, 0);
        } else if (g == 0) {
            remoteViews.setViewVisibility(identifier2, 0);
        } else {
            remoteViews.setViewVisibility(i, 0);
        }
        try {
            i2 = new JSONObject(dVar.C).optInt("ssp_style");
        } catch (Throwable unused) {
            i2 = 0;
        }
        Logger.d("NotificationHelper", "showRealNotification ssp style:" + i2);
        if ((i2 & 8) != 0) {
            i3 = identifier7;
            remoteViews.setImageViewResource(i3, identifier8);
        } else {
            i3 = identifier7;
        }
        if ((i2 & 16) != 0) {
            remoteViews.setImageViewResource(i3, identifier9);
        }
        remoteViews.setOnClickPendingIntent(i3, b.a(context, a(dVar), "cn.jpush.android.action.fb_no_like", "", dVar));
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 11) {
            Notification.Builder builder = new Notification.Builder(context);
            builder.setContentTitle(dVar.t).setContentText(dVar.v).setTicker("").setSmallIcon(o(context, dVar)).setDefaults(0).setVibrate(new long[]{0}).setSound(null);
            if (i4 >= 17) {
                builder.setShowWhen(true);
            }
            builder.setContent(remoteViews);
            if (context.getApplicationInfo().targetSdkVersion >= 31 && i4 >= 24) {
                builder.setCustomBigContentView(remoteViews);
            }
            a.C0022a c0022a = new a.C0022a(dVar.E, "", dVar.A, 0, "fb_ssp");
            cn.jpush.android.x.a.a(context, c0022a);
            a(context, builder, c0022a);
            if (i4 >= 20) {
                if (cn.jpush.android.helper.i.f()) {
                    builder.setGroupSummary(true);
                    int nextInt = new Random(System.currentTimeMillis()).nextInt();
                    builder.setGroup("group" + nextInt);
                } else {
                    builder.setGroupSummary(false);
                    builder.setGroup("group");
                }
            }
            notification = a(builder);
        } else {
            notification = new Notification(h.a(context), dVar.v, System.currentTimeMillis());
            notification.contentView = remoteViews;
        }
        Intent b = dVar.U ? 2 == dVar.Z ? b(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar) : a(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar) : c(context, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar);
        if (notification != null) {
            notification.contentIntent = j.l.c.e0.a.a.d.a(context, (int) System.currentTimeMillis(), b, 1140850688);
            notification.deleteIntent = j.l.c.e0.a.a.d.a(context, (int) (System.currentTimeMillis() + 1), c(context, "cn.jpush.android.intent.NOTIFICATION_DISMISS", dVar), 1140850688);
            int a2 = a(dVar);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
            if (!cn.jpush.android.helper.i.f()) {
                notification.flags = 17;
            }
            if (notificationManager != null) {
                notificationManager.notify(a2, notification);
            }
        }
    }

    public static boolean d(Context context, String str) {
        boolean c;
        if (TextUtils.isEmpty(str)) {
            Logger.d("NotificationHelper", "link uri is empty");
            return false;
        }
        try {
            Logger.d("NotificationHelper", "url:" + str);
            if (str.startsWith(UriUtil.HTTP_SCHEME)) {
                c = f(context, str);
            } else {
                Logger.d("NotificationHelper", "jump intent:" + str);
                c = c(context, str, "");
            }
            return c;
        } catch (Throwable th) {
            Logger.d("NotificationHelper", "[handleSSP] start fail uri error:" + th.getMessage());
            a(context, (int) MgtvMediaPlayer.MGTVMEDIA_ERROR_100002, 1, str + "---" + th.getMessage());
            return false;
        }
    }

    public static void e(Context context, cn.jpush.android.d.d dVar) {
        if (dVar != null) {
            d(context, a(dVar));
        }
    }

    public static boolean e(Context context) {
        String str;
        int i;
        try {
            if (JCoreHelper.checkSdkBanned(context).booleanValue()) {
                Logger.ww("NotificationHelper", "sdk is banned, call failed");
                return false;
            }
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 26) {
                if (i2 >= 21) {
                    intent.putExtra("app_package", context.getPackageName());
                    str = "app_uid";
                    i = context.getApplicationInfo().uid;
                }
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                j.l.c.e0.a.a.a.h(intent);
                context.startActivity(intent);
                return true;
            }
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
            str = "android.provider.extra.CHANNEL_ID";
            i = context.getApplicationInfo().uid;
            intent.putExtra(str, i);
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            j.l.c.e0.a.a.a.h(intent);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static boolean e(Context context, int i) {
        try {
            Logger.d("NotificationHelper", "【setEMUIBadge】number：" + i);
            if (Build.VERSION.SDK_INT >= 11) {
                Bundle bundle = new Bundle();
                bundle.putString("package", context.getPackageName());
                bundle.putString("class", i(context));
                bundle.putInt("badgenumber", i);
                context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
                return true;
            }
            return false;
        } catch (Exception e) {
            Logger.e("NotificationHelper", "e: " + e);
            return false;
        }
    }

    private static boolean e(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT < 26 || TextUtils.isEmpty(str)) {
                return true;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
            NotificationChannel notificationChannel = notificationManager != null ? notificationManager.getNotificationChannel(str) : null;
            if (notificationChannel != null && notificationChannel.getImportance() != 0) {
                Logger.dd("NotificationHelper", str + " channel is opened,will use it");
                return true;
            }
            Logger.ww("NotificationHelper", str + " channel maybe closed,please check it");
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x017a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int f(android.content.Context r9, cn.jpush.android.d.d r10) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.c.f(android.content.Context, cn.jpush.android.d.d):int");
    }

    public static boolean f(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            j.l.c.e0.a.a.a.h(intent);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean f(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.d("NotificationHelper", "link uri is empty");
            return false;
        }
        Logger.d("NotificationHelper", "[openWebUri]:" + str);
        try {
        } catch (Throwable unused) {
            Logger.d("NotificationHelper", "start android default browser failed");
            try {
                Intent parseUri = Intent.parseUri(str, 0);
                parseUri.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                c(context, parseUri);
                j.l.c.e0.a.a.a.h(parseUri);
                context.startActivity(parseUri);
                a(context, (int) MgtvMediaPlayer.MGTVMEDIA_ERROR_100002, 0, str + "---by parse");
            } catch (Throwable th) {
                th.printStackTrace();
                Logger.d("NotificationHelper", "[openWebUri] start fail uri error:" + th.getMessage());
                a(context, (int) MgtvMediaPlayer.MGTVMEDIA_ERROR_100002, 1, str + "---" + th.getMessage());
                return false;
            }
        }
        if (!cn.jpush.android.ac.a.d(context, "com.android.browser")) {
            Logger.dd("NotificationHelper", "not found com.android.browser,user will choose other browser");
            throw new Throwable("not found com.android.browser,user will choose other browser");
        }
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setData(Uri.parse(str));
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
        c(context, intent);
        j.l.c.e0.a.a.a.h(intent);
        context.startActivity(intent);
        a(context, (int) MgtvMediaPlayer.MGTVMEDIA_ERROR_100002, 0, str + "---by default browser");
        return true;
    }

    public static void g(Context context) {
        int identifier;
        if (context == null) {
            Logger.ww("NotificationHelper", "context is null");
        } else if (!cn.jpush.android.ac.a.a(context, JNotifyActivity.class)) {
            Logger.ee("NotificationHelper", "AndroidManifest.xml missing required activity: " + JNotifyActivity.class.getCanonicalName());
        } else if (context.getResources().getIdentifier("push_notification", "layout", context.getPackageName()) <= 0) {
            Logger.e("NotificationHelper", "not exist file push_notification.xml, please check directory: res/layout/");
        } else {
            if (Build.VERSION.SDK_INT >= 29 && (identifier = context.getResources().getIdentifier("v21", "id", context.getPackageName())) <= 0) {
                Logger.ww("NotificationHelper", "device is night mode style, and v21ID = " + identifier + ", please check your layout-v21/push_notification.xml");
            }
            int identifier2 = context.getResources().getIdentifier("push_notification_large", "layout", context.getPackageName());
            if (identifier2 <= 0) {
                Logger.ww("NotificationHelper", "not exist file push_notification_large.xml, please check directory: res/layout/");
            }
            int identifier3 = context.getResources().getIdentifier("push_notification_middle", "layout", context.getPackageName());
            if (identifier3 <= 0) {
                Logger.ww("NotificationHelper", "not exist file push_notification_middle.xml, please check directory: res/layout/");
            }
            int identifier4 = context.getResources().getIdentifier("jpush_ic_action_cancle", "drawable", context.getPackageName());
            int identifier5 = context.getResources().getIdentifier("jpush_ic_action_close", "drawable", context.getPackageName());
            int identifier6 = context.getResources().getIdentifier("jpush_ic_action_close2", "drawable", context.getPackageName());
            if (identifier4 <= 0 || identifier5 <= 0 || identifier6 <= 0) {
                String str = "not exist file";
                if (identifier4 <= 0) {
                    str = "not exist file jpush_ic_action_cancle.png";
                }
                if (identifier5 <= 0) {
                    str = str + " jpush_ic_action_close.png";
                }
                if (identifier6 <= 0) {
                    str = str + " jpush_ic_action_close2.png";
                }
                Logger.ww("NotificationHelper", str + ", please check directory: res/drawable/");
            }
            int identifier7 = context.getResources().getIdentifier("push_notification_layout_lefttop", "id", context.getPackageName());
            if (identifier7 <= 0) {
                Logger.ww("NotificationHelper", "not find layout push_notification_layout_lefttop in push_notification.xml, please check the file: res/layout/push_notification.xml");
            }
            int a2 = cn.jpush.android.helper.i.a(context);
            if (identifier2 > 0 && identifier3 > 0 && identifier4 > 0 && identifier5 > 0 && identifier6 > 0 && identifier7 > 0) {
                Logger.dd("NotificationHelper", "ssp is integrated succeed, layoutVersion: " + a2);
                return;
            }
            Logger.e("NotificationHelper", "some ssp functions are limited, layoutVersion: " + a2);
        }
    }

    private static String h(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setPackage(context.getPackageName());
            intent.addCategory("android.intent.category.LAUNCHER");
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            if (resolveActivity == null) {
                resolveActivity = packageManager.resolveActivity(intent, 0);
            }
            if (resolveActivity != null) {
                return resolveActivity.activityInfo.name;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String i(Context context) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage != null && launchIntentForPackage.getComponent() != null) {
                return launchIntentForPackage.getComponent().getClassName();
            }
        } catch (Throwable unused) {
        }
        return h(context);
    }

    private static int j(Context context, cn.jpush.android.d.d dVar) {
        try {
            JSONObject jSONObject = new JSONObject(dVar.C);
            int optInt = jSONObject.optInt("ssp_msgcount_limit", 5);
            long optLong = jSONObject.optLong("ssp_msg_gap", 1800L);
            if (optInt > 0) {
                Logger.d("NotificationHelper", "setSSPLimitCount:" + optInt);
            }
            if (optLong > 0) {
                optLong *= 1000;
                Logger.d("NotificationHelper", "setSSPLimitInterval:" + optLong);
            }
            return cn.jpush.android.helper.i.a(context, optInt, optLong);
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "parse ssp notificationExtra of frequency failed, error:" + th.getMessage());
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:95:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00f0 A[Catch: all -> 0x0117, TryCatch #0 {all -> 0x0117, blocks: (B:59:0x0003, B:62:0x0026, B:64:0x002c, B:66:0x0032, B:69:0x003d, B:70:0x004a, B:72:0x004f, B:74:0x0090, B:76:0x0098, B:78:0x009e, B:80:0x00a4, B:82:0x00aa, B:84:0x00c4, B:86:0x00ca, B:89:0x00d3, B:93:0x00e0, B:96:0x00f0, B:97:0x00f8, B:98:0x0100, B:99:0x0108, B:100:0x0110), top: B:106:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean k(android.content.Context r12, cn.jpush.android.d.d r13) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.c.k(android.content.Context, cn.jpush.android.d.d):boolean");
    }

    public static boolean l(Context context, cn.jpush.android.d.d dVar) {
        try {
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "check same in-app show already error， err:" + th.getMessage());
        }
        if (context == null) {
            Logger.d("NotificationHelper", "[checkSameSSPAlreadyExists] context is null return false");
            return false;
        }
        if (!(!TextUtils.isEmpty(dVar.G) && dVar.P == 1001)) {
            Logger.d("NotificationHelper", "not ssp notification, need not check in-app content of showing recently.");
            return false;
        }
        String str = dVar.t;
        String str2 = dVar.v;
        String d = cn.jpush.android.ac.a.d(str + str2);
        if (!TextUtils.isEmpty(d)) {
            JSONObject jSONObject = new JSONObject(dVar.C);
            int optInt = jSONObject.optInt("ssp_in_app_gap", 180);
            if (jSONObject.optInt("ssp_filter_msg", 1) != 0) {
                if (optInt > 0) {
                    optInt *= 1000;
                    Logger.d("NotificationHelper", "ssp_in_app_gap: " + optInt);
                }
                int a2 = cn.jpush.android.helper.i.a(context, d, optInt);
                if (a2 == 1) {
                    Logger.w("NotificationHelper", "in-app message display recently, spp notification delay to show, delay time: " + (optInt / 1000) + "s");
                    long currentTimeMillis = System.currentTimeMillis() + ((long) optInt);
                    f.a().a(context, new f.a(currentTimeMillis, dVar, true));
                    long b = cn.jpush.android.ac.b.b(dVar.as);
                    if (b > 0 && b > currentTimeMillis) {
                        Logger.d("NotificationHelper", "delay to show ssp, and it will auto cancel by end time, showTime: " + currentTimeMillis + ", endTime: " + b);
                        f.a().a(context, new f.a(b, a(dVar)));
                    }
                    cn.jpush.android.helper.c.a(dVar.c, 1098, context);
                    return true;
                } else if (a2 == 2) {
                    Logger.d("NotificationHelper", "same content in-app message display recently, ssp notification not display");
                    cn.jpush.android.helper.c.a(dVar.c, 1097, context);
                    return true;
                }
            }
        }
        return false;
    }

    private static int m(Context context, cn.jpush.android.d.d dVar) {
        String str;
        if (dVar == null || context == null) {
            return 0;
        }
        int identifier = context.getResources().getIdentifier("push_notification", "layout", context.getPackageName());
        int identifier2 = context.getResources().getIdentifier("push_notification_large", "layout", context.getPackageName());
        int identifier3 = context.getResources().getIdentifier("push_notification_middle", "layout", context.getPackageName());
        int identifier4 = context.getResources().getIdentifier("push_notification_banner_img", "id", context.getPackageName());
        int g = cn.jpush.android.helper.i.g();
        if (g == 0) {
            str = "";
        } else {
            str = "style_" + g + "_";
        }
        int identifier5 = context.getResources().getIdentifier("push_notification_" + str + "banner_icon", "id", context.getPackageName());
        try {
            int optInt = new JSONObject(dVar.C).optInt("ssp_style");
            if ((optInt & 64) != 0) {
                if (!cn.jpush.android.helper.i.b() || identifier3 <= 0 || identifier5 <= 0) {
                    return 1;
                }
                Logger.d("NotificationHelper", "choseLayoutType : use middle layout");
                return 3;
            } else if ((optInt & 128) != 0) {
                if (!cn.jpush.android.helper.i.b() || identifier2 <= 0 || identifier5 <= 0) {
                    return 1;
                }
                Logger.d("NotificationHelper", "choseLayoutType : use large layout");
                return 4;
            } else if ((optInt & 32) == 0 || identifier <= 0 || identifier4 <= 0) {
                return 1;
            } else {
                Logger.d("NotificationHelper", "choseLayoutType : use banner layout");
                return 2;
            }
        } catch (Throwable unused) {
            return 1;
        }
    }

    private static boolean n(Context context, cn.jpush.android.d.d dVar) {
        boolean z = true;
        if (dVar != null) {
            try {
                if (new JSONObject(dVar.C).optInt("ssp_use_app_icon", 0) != 0) {
                    z = false;
                }
                Logger.d("NotificationHelper", "ssp use transparent icon: " + z + ", extras: " + dVar.C);
            } catch (Throwable unused) {
            }
        }
        return z;
    }

    private static int o(Context context, cn.jpush.android.d.d dVar) {
        if (n(context, dVar)) {
            return 17170445;
        }
        return h.a(context);
    }

    public static void p(Context context, cn.jpush.android.d.d dVar) {
        String str;
        boolean z;
        String str2 = dVar.c;
        String str3 = dVar.V;
        str = "";
        if (TextUtils.isEmpty(str3)) {
            Logger.w("NotificationHelper", "Show url is Empty! Give up to download!");
            z = false;
        } else {
            String a2 = cn.jpush.android.w.a.a(str3, 5, (long) LoginStatusClient.DEFAULT_TOAST_DURATION_MS);
            boolean isEmpty = TextUtils.isEmpty(a2);
            str = isEmpty ? "" : a2;
            z = !isEmpty;
        }
        String c = cn.jpush.android.ac.c.c(context, str2);
        if (!z) {
            Logger.w("NotificationHelper", "NOTE: failed to download html page. Give up this.");
            cn.jpush.android.helper.c.a(str2, 1014, context);
            cn.jpush.android.helper.c.a(str2, 1021, (String) null, context);
            return;
        }
        String str4 = c + str2 + ".html";
        String substring = str3.substring(0, str3.lastIndexOf("/") + 1);
        if (dVar.ab.isEmpty()) {
            dVar.X = dVar.V;
        } else if (!i.a(dVar.ab, context, substring, str2, true)) {
            Logger.d("NotificationHelper", "Loads rich push resources failed, webView will open url!");
            cn.jpush.android.helper.c.a(str2, 1014, context);
            b(context, dVar);
            return;
        } else {
            Logger.d("NotificationHelper", "Loads rich push resources succeed, webView will open cache!");
            if (!cn.jpush.android.ac.c.b(str4, str.replaceAll("img src=\"" + substring, "img src=\"" + c))) {
                cn.jpush.android.helper.c.a(str2, 1014, context);
                return;
            }
            dVar.X = "file://" + str4;
            cn.jpush.android.helper.c.a(str2, 995, context);
        }
        b(context, dVar);
    }

    public static void q(Context context, cn.jpush.android.d.d dVar) {
        String b;
        String str;
        String str2 = dVar.y;
        dVar.y = "";
        if (dVar.w != 3 || TextUtils.isEmpty(str2)) {
            return;
        }
        if (str2.startsWith(JPushConstants.HTTP_PRE) || str2.startsWith(JPushConstants.HTTPS_PRE)) {
            b = b(context, str2, dVar.c);
            if (TextUtils.isEmpty(b)) {
                str = "Get network picture failed, show basic notification only.";
                Logger.ww("NotificationHelper", str);
                return;
            }
            dVar.y = b;
        }
        b = cn.jpush.android.ac.c.d(context, str2);
        if (TextUtils.isEmpty(b)) {
            str = "Get developer picture failed, show basic notification only.";
            Logger.ww("NotificationHelper", str);
            return;
        }
        dVar.y = b;
    }
}
