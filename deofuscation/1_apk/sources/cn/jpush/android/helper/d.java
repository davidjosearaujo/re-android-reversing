package cn.jpush.android.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.JPushConstants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    private static ConcurrentLinkedQueue<Long> a = new ConcurrentLinkedQueue<>();
    private static final Object c = new Object();
    private static d d;
    private ConcurrentHashMap<Long, a> b = new ConcurrentHashMap<>();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a {
        public int a;
        public String b;

        public a(int i, String str) {
            d.this = r1;
            this.a = i;
            this.b = str;
        }

        public String toString() {
            return "MobileBean{sequence=" + this.a + ", mobileNumber='" + this.b + "'}";
        }
    }

    private static int a(long j) {
        if (a.size() >= 3) {
            long longValue = j - a.element().longValue();
            if (longValue < 0) {
                a.clear();
                return 2;
            } else if (longValue <= 10000) {
                return 1;
            } else {
                while (a.size() >= 3) {
                    a.poll();
                }
            }
        }
        a.offer(Long.valueOf(j));
        return 0;
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (d == null) {
                synchronized (c) {
                    if (d == null) {
                        d = new d();
                    }
                }
            }
            dVar = d;
        }
        return dVar;
    }

    public JPushMessage a(Context context, Intent intent) {
        JPushMessage jPushMessage;
        Object th;
        int intExtra;
        int intExtra2;
        String stringExtra;
        if (intent != null) {
            try {
                intExtra = intent.getIntExtra("sequence", -1);
                intExtra2 = intent.getIntExtra(JThirdPlatFormInterface.KEY_CODE, -1);
                stringExtra = intent.getStringExtra("mobile");
                jPushMessage = new JPushMessage();
            } catch (Throwable th2) {
                jPushMessage = null;
                th = th2;
            }
            try {
                jPushMessage.setSequence(intExtra);
                jPushMessage.setErrorCode(intExtra2);
                jPushMessage.setMobileNumber(stringExtra);
            } catch (Throwable th3) {
                th = th3;
                Logger.w("MobileNumberHelper", "parese mobile number response to JPushMessage failed, error:" + th);
                return jPushMessage;
            }
            return jPushMessage;
        }
        return null;
    }

    public void a(Context context, int i, int i2, String str) {
        try {
            Logger.d("MobileNumberHelper", "Action - onResult,sequence:" + i + ",code:" + i2 + ",mobileNumber:" + str);
            String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
            Intent intent = new Intent();
            if (TextUtils.isEmpty(messageReceiverClass)) {
                Logger.d("MobileNumberHelper", "not found messageReceiver");
            } else {
                intent = new Intent(context, Class.forName(messageReceiverClass));
                intent.setAction("mobile_result");
                intent.putExtra("sequence", i);
                intent.putExtra(JThirdPlatFormInterface.KEY_CODE, i2);
                intent.putExtra("mobile", str);
            }
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            Logger.ww("MobileNumberHelper", "onResult error:" + th);
        }
    }

    public void a(Context context, int i, String str) {
        Logger.dd("MobileNumberHelper", "action - setMobileNubmer, sequence:" + i + ",mobileNumber:" + str);
        Bundle bundle = new Bundle();
        bundle.putInt("sequence", i);
        bundle.putString("mobile", str);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "set_mobile", bundle);
    }

    public void a(Context context, long j, int i) {
        if (this.b.size() != 0) {
            a remove = this.b.remove(Long.valueOf(j));
            Logger.d("MobileNumberHelper", "mobileBean:" + remove);
            if (remove == null) {
                Logger.d("MobileNumberHelper", "#unexcepted, do not find mobile number request cache");
                return;
            }
            if (i == 0) {
                cn.jpush.android.cache.a.a(context, remove.b);
            } else if (i == 11) {
                i = JPushInterface.ErrorCode.ERROR_CODE_INTERNEL_SERVER_ERROR;
            } else if (i == 10) {
                i = JPushInterface.ErrorCode.ERROR_CODE_INVALID_MOBILENUMBER;
            }
            a(context, remove.a, i, remove.b);
        }
    }

    public void a(Context context, Bundle bundle) {
        if (bundle == null) {
            Logger.ww("MobileNumberHelper", "[setMobileNum] bundle is bull");
            return;
        }
        int i = bundle.getInt("sequence", 0);
        String string = bundle.getString("mobile");
        String e = cn.jpush.android.cache.a.e(context);
        Logger.dd("MobileNumberHelper", "action:setMobileNum sequence:" + i + ",mobileNumber:" + string + ",lastMobileNumber:" + e);
        if (e != null && TextUtils.equals(string, e)) {
            Logger.dd("MobileNumberHelper", "already set this mobile number");
            a(context, i, JPushInterface.ErrorCode.SUCCESS, string);
        } else if (cn.jpush.android.cache.a.b(context) == 1) {
            a(context, i, JPushInterface.ErrorCode.PUSH_STOPED, string);
        } else {
            if (e != null) {
                cn.jpush.android.cache.a.a(context, (String) null);
            }
            int a2 = a(System.currentTimeMillis());
            if (a2 != 0) {
                Logger.w("MobileNumberHelper", a2 == 1 ? "set mobile number too soon,over 3 times in 10s" : "set mobile number failed,time shaft error，please try again");
                a(context, i, a2 == 1 ? JPushInterface.ErrorCode.INVOKE_TOO_SOON : JPushInterface.ErrorCode.INCORRECT_TIME, string);
                return;
            }
            int c2 = cn.jpush.android.ac.f.c(string);
            if (c2 == 0) {
                byte[] a3 = cn.jpush.android.z.c.a(string);
                long a4 = g.a();
                this.b.put(Long.valueOf(a4), new a(i, string));
                JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, 26, 1, a4, 0L, a3);
                return;
            }
            Logger.dd("MobileNumberHelper", "Invalid mobile number: " + string + ", will not set mobile number this time.");
            a(context, i, c2, string);
        }
    }
}
