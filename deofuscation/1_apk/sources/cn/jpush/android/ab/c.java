package cn.jpush.android.ab;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.ac.e;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.PushReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    private static c d;
    private List<JThirdPlatFormInterface> a = new ArrayList();
    private boolean c;
    private static Map<String, Byte> b = new HashMap();
    private static final Object e = new Object();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a {
        public String a;
        public int b;
        public String c;
        public byte d;

        public a() {
            c.this = r1;
        }

        public String toString() {
            return "ThirdMessage{msgid='" + this.a + "', notiId=" + this.b + ", content='" + this.c + "', platform=" + ((int) this.d) + '}';
        }
    }

    static {
        b.put("cn.jpush.android.thirdpush.meizu.MeizuPushManager", (byte) 3);
        b.put("cn.jpush.android.thirdpush.xiaomi.XMPushManager", (byte) 1);
        b.put("cn.jpush.android.thirdpush.huawei.HWPushManager", (byte) 2);
        b.put("cn.jpush.android.thirdpush.fcm.FCMPushManager", (byte) 8);
        b.put("cn.jpush.android.thridpush.oppo.OPushManager", (byte) 4);
        b.put("cn.jpush.android.thirdpush.vivo.VivoPushManager", (byte) 5);
        b.put(cn.jpush.android.asus.b.class.getName(), (byte) 6);
    }

    private c() {
    }

    public a a(Bundle bundle) {
        a aVar;
        if (bundle != null) {
            aVar = new a();
            aVar.c = bundle.getString("data");
            aVar.a = bundle.getString(JThirdPlatFormInterface.KEY_MSG_ID);
            aVar.b = bundle.getInt(JThirdPlatFormInterface.KEY_NOTI_ID, 0);
            aVar.d = bundle.getByte(JThirdPlatFormInterface.KEY_PLATFORM, (byte) -1).byteValue();
        } else {
            aVar = null;
        }
        Logger.d("ThirdPushManager", "parse third messgae:" + aVar);
        return aVar;
    }

    public static c a() {
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = new c();
                }
            }
        }
        return d;
    }

    private void a(Context context, JThirdPlatFormInterface jThirdPlatFormInterface) {
        if (jThirdPlatFormInterface == null || !jThirdPlatFormInterface.isNeedClearToken(context)) {
            return;
        }
        byte romType = jThirdPlatFormInterface.getRomType(context);
        Sp.set(context, Key.ThirdPush_RegUpload(romType).set(Boolean.FALSE));
        Sp.set(context, Key.ThirdPush_RegID(romType).set(null));
    }

    private void a(Context context, JThirdPlatFormInterface jThirdPlatFormInterface, String str) {
        Logger.d("ThirdPushManager", "sendBroadCastToUploadToken:" + str);
        String token = jThirdPlatFormInterface.getToken(context);
        if (!TextUtils.isEmpty(token)) {
            b(context, jThirdPlatFormInterface.getRomType(context), token);
            return;
        }
        try {
            Intent intent = new Intent(context, PushReceiver.class);
            intent.setAction(str);
            Bundle bundle = new Bundle();
            bundle.putString("sdktype", JPushConstants.SDK_TYPE);
            bundle.putByte(JThirdPlatFormInterface.KEY_PLATFORM, jThirdPlatFormInterface.getRomType(context));
            intent.putExtras(bundle);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            Logger.ww("ThirdPushManager", "send " + str + " failed:" + th);
        }
    }

    private void b(Context context, byte b2, String str) {
        Logger.ii("ThirdPushManager", "[uploadInService] regid:" + str + ",romtype:" + ((int) b2));
        a(context);
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
            if (jThirdPlatFormInterface.getRomType(context) == b2) {
                a(context, jThirdPlatFormInterface);
                c(context, b2, str);
            }
        }
    }

    private void c(Context context, byte b2, String str) {
        Logger.d("ThirdPushManager", "sendUpdateRegIDRequest, WhichPlatform:" + ((int) b2) + ",regID:" + str);
        Sp.set(context, Key.ThirdPush_RegUpload(b2).set(Boolean.FALSE));
        Sp.set(context, Key.ThirdPush_RegID(b2).set(str));
        cn.jpush.android.ab.a.a().a(context, b2, str);
    }

    private void j(Context context) {
        Object newInstance;
        Logger.d("ThirdPushManager", "[loadThirdPush]");
        for (Map.Entry<String, Byte> entry : b.entrySet()) {
            try {
                Class<?> cls = Class.forName(entry.getKey(), false, context.getClassLoader());
                if (cls != null && (newInstance = cls.newInstance()) != null && (newInstance instanceof JThirdPlatFormInterface)) {
                    ((JThirdPlatFormInterface) newInstance).init(context);
                    if (((JThirdPlatFormInterface) newInstance).isSupport(context)) {
                        this.a.add((JThirdPlatFormInterface) newInstance);
                    } else {
                        Byte value = entry.getValue();
                        Sp.set(context, Key.ThirdPush_RegID(value.byteValue()).set(null));
                        Sp.set(context, Key.ThirdPush_RegUpload(value.byteValue()).set(Boolean.FALSE));
                    }
                }
            } catch (Throwable th) {
                Byte value2 = entry.getValue();
                Sp.set(context, Key.ThirdPush_RegID(value2.byteValue()).set(null));
                Sp.set(context, Key.ThirdPush_RegUpload(value2.byteValue()).set(Boolean.FALSE));
                if ((th instanceof RuntimeException) && th.getMessage().contains("Please check") && JCoreManager.getDebugMode()) {
                    if (cn.jpush.android.m.a.c >= 238) {
                        JCoreHelper.futureExecutor(context, new e("ThirdPushManager#loadThirdPush") { // from class: cn.jpush.android.ab.c.1
                            {
                                c.this = this;
                            }

                            @Override // cn.jpush.android.ac.e
                            public void a() {
                                throw new RuntimeException(th);
                            }
                        });
                    } else {
                        new Thread(new Runnable() { // from class: cn.jpush.android.ab.c.2
                            {
                                c.this = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                throw new RuntimeException(th);
                            }
                        }).start();
                    }
                }
                Logger.w("ThirdPushManager", "loadThirdPush error:" + th.getMessage());
            }
        }
        if (Build.VERSION.SDK_INT < 26 || this.a.isEmpty()) {
            return;
        }
        cn.jpush.android.x.a.a(context);
    }

    public byte a(Context context, String str) {
        if (cn.jpush.android.m.a.a()) {
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
                byte romType = jThirdPlatFormInterface.getRomType(context);
                if (romType == 1) {
                    int nofiticationID = JThirdPlatFormInterface.getNofiticationID(str, romType);
                    Logger.d("ThirdPushManager", "clearThirdNotificaiton msgid:" + str + ",  romType:" + ((int) romType) + " , notificationId:" + nofiticationID);
                    jThirdPlatFormInterface.clearNotification(context, nofiticationID);
                    return romType;
                }
            }
            return (byte) -1;
        }
        return (byte) -1;
    }

    public synchronized void a(Context context) {
        if (this.c) {
            return;
        }
        if (context == null) {
            return;
        }
        j(context);
        this.c = true;
    }

    public void a(Context context, byte b2, String str) {
        if (cn.jpush.android.m.a.a()) {
            if (context == null) {
                context = JPushConstants.mApplicationContext;
            }
            if (context == null) {
                Logger.e("ThirdPushManager", "context was null");
                return;
            }
            Logger.ii("ThirdPushManager", "uploadRegID regid:" + str);
            a(context);
            Bundle bundle = new Bundle();
            bundle.putString(JThirdPlatFormInterface.KEY_TOKEN, str);
            bundle.putByte(JThirdPlatFormInterface.KEY_PLATFORM, b2);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "third_push_upload_regid", bundle);
        }
    }

    public void a(Context context, int i, String str) {
        try {
            Logger.dd("ThirdPushManager", "[callBackTokenToUser] platform:" + i + ",token:" + str);
            Bundle bundle = new Bundle();
            bundle.putInt(JThirdPlatFormInterface.KEY_PLATFORM, i);
            bundle.putString(JThirdPlatFormInterface.KEY_TOKEN, str);
            cn.jpush.android.x.c.a(context, 10000, 0, "", bundle);
        } catch (Throwable th) {
            Logger.ww("ThirdPushManager", "callBackTokenToUser failed:" + th.getMessage());
        }
    }

    public void a(Context context, Bundle bundle) {
        if (context == null) {
            context = JPushConstants.mApplicationContext;
        }
        if (context == null) {
            Logger.e("ThirdPushManager", "context was null");
        } else if (bundle == null) {
            Logger.ww("ThirdPushManager", "bundle is null");
        } else {
            b(context, bundle.getByte(JThirdPlatFormInterface.KEY_PLATFORM, (byte) 0).byteValue(), bundle.getString(JThirdPlatFormInterface.KEY_TOKEN));
        }
    }

    public void a(final Context context, final String str, final Bundle bundle) {
        try {
            Logger.dd("ThirdPushManager", "doAction,action:" + str + ",bundle:" + bundle + ",enable:" + cn.jpush.android.m.a.a());
            if (cn.jpush.android.m.a.a()) {
                JCoreHelper.majorExecutor(context, "ThirdPushManager", new e("ThirdPushManager#doAction") { // from class: cn.jpush.android.ab.c.3
                    {
                        c.this = this;
                    }

                    @Override // cn.jpush.android.ac.e
                    public void a() {
                        Bundle bundle2;
                        try {
                            if (!TextUtils.isEmpty(str)) {
                                if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_ARRIVED)) {
                                    a a2 = c.this.a(bundle);
                                    if (a2 != null) {
                                        b.a(context, a2.c, a2.a, a2.b, a2.d, 1);
                                    }
                                } else if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_CLCKED)) {
                                    a a3 = c.this.a(bundle);
                                    if (a3 != null) {
                                        b.a(context, a3.c, a3.a, a3.b, a3.d, 0);
                                    }
                                } else if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_UN_SHOW)) {
                                    a a4 = c.this.a(bundle);
                                    if (a4 != null) {
                                        b.a(context, a4.c, a4.a, a4.b, a4.d, 2);
                                    }
                                } else if (!str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_SHOW) && str.equals(JThirdPlatFormInterface.ACTION_REGISTER_TOKEN) && (bundle2 = bundle) != null) {
                                    c.this.a(context, bundle.getByte(JThirdPlatFormInterface.KEY_PLATFORM, (byte) -1).byteValue(), bundle2.getString(JThirdPlatFormInterface.KEY_TOKEN));
                                }
                            }
                        } catch (Throwable th) {
                            Logger.ww("ThirdPushManager", "doAction failed internal:" + th.getMessage());
                        }
                    }
                });
            }
        } catch (Throwable th) {
            Logger.ww("ThirdPushManager", "doAction failed:" + th.getMessage());
        }
    }

    public void b(Context context) {
        if (cn.jpush.android.m.a.a()) {
            a(context);
            if (cn.jpush.android.cache.a.d(context.getApplicationContext())) {
                Logger.d("ThirdPushManager", "push has close");
                return;
            }
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
                try {
                    jThirdPlatFormInterface.register(context);
                } catch (Throwable th) {
                    Logger.ww("ThirdPushManager", "Third push register failed#", th);
                }
            }
        }
    }

    public void b(Context context, Bundle bundle) {
        if (!cn.jpush.android.m.a.a()) {
            Logger.dd("ThirdPushManager", "[refreshToken] third disabled");
            return;
        }
        a(context);
        byte byteValue = bundle.getByte(JThirdPlatFormInterface.KEY_PLATFORM, (byte) -1).byteValue();
        if (byteValue <= 0) {
            Logger.w("ThirdPushManager", "refreshToken romtype is <= 0");
            return;
        }
        Logger.dd("ThirdPushManager", "[refreshToken] romType: " + ((int) byteValue));
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
            if (jThirdPlatFormInterface.getRomType(context) == byteValue) {
                String token = jThirdPlatFormInterface.getToken(context);
                if (TextUtils.isEmpty(token)) {
                    jThirdPlatFormInterface.register(context);
                } else {
                    a(context, byteValue, token);
                }
            }
        }
    }

    public void c(Context context) {
        if (cn.jpush.android.m.a.a()) {
            a(context);
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
                jThirdPlatFormInterface.resumePush(context);
            }
        }
    }

    public void d(Context context) {
        if (cn.jpush.android.m.a.a()) {
            a(context);
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
                jThirdPlatFormInterface.stopPush(context);
            }
        }
    }

    public byte e(Context context) {
        int i;
        byte b2 = 0;
        if (cn.jpush.android.m.a.a()) {
            a(context);
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
                byte romType = jThirdPlatFormInterface.getRomType(context);
                b2 = (byte) (b2 | romType);
                byte b3 = romType;
                String str = (String) Sp.get(context, Key.ThirdPush_RegID(b3));
                boolean booleanValue = ((Boolean) Sp.get(context, Key.ThirdPush_RegUpload(b3))).booleanValue();
                if (jThirdPlatFormInterface.getRomType(context) == 8) {
                    b2 = (byte) (b2 | 8);
                    if (booleanValue && !TextUtils.isEmpty(str)) {
                        i = b2 | 32;
                        b2 = (byte) i;
                    }
                } else {
                    if (jThirdPlatFormInterface.getRomType(context) == 2) {
                        b2 = (byte) (b2 | 64);
                    }
                    if (!booleanValue || TextUtils.isEmpty(str)) {
                        i = b2 | 128;
                        b2 = (byte) i;
                    }
                }
            }
            Logger.d("ThirdPushManager", "getRomType,romType:" + ((int) b2));
            return b2;
        }
        return (byte) 0;
    }

    public String f(Context context) {
        if (cn.jpush.android.m.a.a()) {
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
                if (jThirdPlatFormInterface.getRomType(context) != 8) {
                    return (String) Sp.get(context, Key.ThirdPush_RegID(jThirdPlatFormInterface.getRomType(context)));
                }
            }
            return null;
        }
        return null;
    }

    public void g(Context context) {
        try {
            List<JThirdPlatFormInterface> list = this.a;
            if (list != null && !list.isEmpty()) {
                for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
                    c(context, jThirdPlatFormInterface.getRomType(context), null);
                }
                return;
            }
            Map<String, Byte> map = b;
            if (map != null) {
                for (Byte b2 : map.values()) {
                    Sp.set(context, Key.ThirdPush_RegUpload(b2.byteValue()).set(Boolean.FALSE));
                    Sp.set(context, Key.ThirdPush_RegID(b2.byteValue()).set(null));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void h(Context context) {
        if (cn.jpush.android.m.a.a()) {
            if (context == null) {
                context = JPushConstants.mApplicationContext;
            }
            if (context == null) {
                Logger.e("ThirdPushManager", "context was null");
                return;
            }
            a(context);
            Logger.ii("ThirdPushManager", "uploadRegIdAfterLogin");
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
                a(context, jThirdPlatFormInterface, JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_REFRESSH_REGID);
            }
        }
    }

    public void i(Context context) {
        Logger.dd("ThirdPushManager", "reRegisterInPushReceiver");
        a(context);
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
            a(context, jThirdPlatFormInterface, JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_REFRESSH_REGID);
        }
    }
}
