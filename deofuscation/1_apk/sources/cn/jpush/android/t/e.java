package cn.jpush.android.t;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.r.h;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class e {
    private static e a;
    private int b = 1;
    private long c = 30000;
    private int d = 0;
    private long e = 0;
    private ConcurrentHashMap<Long, Integer> f = new ConcurrentHashMap<>();

    public static e a() {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e();
                }
            }
        }
        return a;
    }

    private void a(Context context, int i, int i2) {
        if (context == null) {
            try {
                context = JPushConstants.mApplicationContext;
            } catch (Throwable th) {
                Logger.w("InAppPullTaskHelper", "send pull result to user by broadcast, code: " + i2 + ", error: " + th.getMessage());
                return;
            }
        }
        if (context != null) {
            String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
            Intent intent = new Intent();
            if (TextUtils.isEmpty(messageReceiverClass)) {
                Logger.d("InAppPullTaskHelper", "not found messageReceiver");
            } else {
                intent = new Intent(context, Class.forName(messageReceiverClass));
                intent.setAction("in_app_pull_result");
                intent.putExtra("sequence", i);
                intent.putExtra(JThirdPlatFormInterface.KEY_CODE, i2);
            }
            context.sendBroadcast(intent);
        }
    }

    private void a(Context context, long j, int i) {
        if (this.f.size() > 0) {
            Integer remove = this.f.remove(Long.valueOf(j));
            Logger.d("InAppPullTaskHelper", "sequence:" + remove + ", code: " + i);
            if (remove == null) {
                Logger.d("InAppPullTaskHelper", "#unexcepted, do not find in app request cache");
                return;
            }
            if (i != 0) {
                switch (i) {
                    case JosStatusCodes.RTN_CODE_NO_SUPPORT_JOS /* 8001 */:
                        i = 6029;
                        break;
                    case JosStatusCodes.RNT_CODE_NO_JOS_INFO /* 8002 */:
                        i = 6030;
                        break;
                    case 8003:
                        i = 6032;
                        break;
                    case 8004:
                        i = 6033;
                        break;
                    case 8005:
                        i = 6034;
                        break;
                }
            } else {
                i = 6028;
            }
            a(context, remove.intValue(), i);
        }
    }

    public JPushMessage a(Context context, Intent intent) {
        JPushMessage jPushMessage = new JPushMessage();
        if (intent != null) {
            try {
                Logger.d("InAppPullTaskHelper", "[parseInAppResponse2JPushMessage] process: " + cn.jpush.android.ac.a.d(context));
                int intExtra = intent.getIntExtra("sequence", -1);
                int intExtra2 = intent.getIntExtra(JThirdPlatFormInterface.KEY_CODE, -1);
                jPushMessage.setSequence(intExtra);
                jPushMessage.setErrorCode(intExtra2);
            } catch (Throwable th) {
                Logger.w("InAppPullTaskHelper", "parese in app response to JPushMessage failed, error:" + th);
            }
        }
        return jPushMessage;
    }

    public void a(Context context, long j, int i, int i2, long j2) {
        try {
            if (i != JPushInterface.ErrorCode.TIMEOUT) {
                this.b = Math.max(i2, 0);
                this.c = Math.max(j2, 0L) * 1000;
                Logger.d("InAppPullTaskHelper", "[onPullInAppCallBack],reqId:" + j + ",code:" + i + ",reqLmtCount:" + this.b + ", reqTimeInterval:" + this.c);
            }
            a(context, j, i);
        } catch (Throwable th) {
            Logger.ww("InAppPullTaskHelper", "[onPullInAppCallBack] error:" + th);
        }
    }

    public synchronized void a(Context context, Bundle bundle) {
        int i;
        try {
        } catch (Throwable th) {
            Logger.w("InAppPullTaskHelper", "pull in app data in service process failed. " + th.getMessage());
        }
        if (bundle == null) {
            Logger.ww("InAppPullTaskHelper", "[pullInAppMessage] bundle is bull");
            return;
        }
        int i2 = bundle.getInt("sequence", 0);
        int i3 = bundle.getInt("type", 0);
        String string = bundle.getString("AdPositionKey", "");
        if (cn.jpush.android.cache.a.b(context) == 1) {
            a(context, i2, JPushInterface.ErrorCode.PUSH_STOPED);
        } else if (h.d(context)) {
            Logger.d("InAppPullTaskHelper", "can not pull in-message in black page");
            a(context, i2, 6035);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.e > this.c) {
                this.d = 0;
            }
            Logger.d("InAppPullTaskHelper", "[onPushServicePullInAppAction] process: " + cn.jpush.android.ac.a.d(context));
            if (this.d >= this.b) {
                Logger.w("InAppPullTaskHelper", "in app message request limit, limit code: " + this.b + ", hasReqCount: " + this.d + ", srvTimeInterval: " + this.c + ", reqTimeInterval: " + (currentTimeMillis - this.e));
                a(context, i2, 6031);
                return;
            }
            long a2 = cn.jpush.android.helper.g.a();
            String f = c.f(context);
            Logger.d("InAppPullTaskHelper", "start request in-app message, reqCount: " + this.b + ", reqTimeInterval: " + this.c + ", hasReqCount: " + this.d + ", cmd: 34, ver: 3, type: " + i3 + ", adPositionKey: " + string + ", devInfo: " + f);
            this.f.put(Long.valueOf(a2), Integer.valueOf(i2));
            JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, 34, 3, a2, 20000L, cn.jpush.android.z.c.a(i3, string, f));
            if (currentTimeMillis - this.e > this.c) {
                i = 1;
            } else {
                i = this.d + 1;
                this.d = i;
            }
            this.d = i;
            this.e = currentTimeMillis;
            Logger.d("InAppPullTaskHelper", "after user request count: " + this.d + ", userReqTime: " + this.e);
        }
    }
}
