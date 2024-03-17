package com.hunantv.oversea.push.repository.huawei;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import com.hunantv.oversea.push.domain.entity.PushMsgEntity;
import j.l.a.b0.f0;
import j.l.c.v.e.b;
import j.l.c.v.f.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class HWMsgService extends HmsMessageService {
    private static final String b = "HWMsgService";

    private b c() {
        return new b(a.c(13));
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageDelivered(String str, Exception exc) {
        super.onMessageDelivered(str, exc);
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        if (remoteMessage == null) {
            return;
        }
        try {
            Log.i(b, "onMessageReceived remoteMessage: " + remoteMessage);
            String data = remoteMessage.getData();
            if (TextUtils.isEmpty(data)) {
                return;
            }
            Log.i(b, "Message data payload: " + data);
            c().e(new PushMsgEntity("", "", data, "", "", 13, 13, ""));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onNewToken(String str) {
        super.onNewToken(str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            f0.y("PUSH_REG_TOKEN_HUAWEI", str);
            Log.i(b, "onNewToken: " + str + ",thread:" + Thread.currentThread().getName());
            c().g(new PushMsgEntity("", "", "", "", str, 13, 13, ""));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onTokenError(Exception exc) {
        super.onTokenError(exc);
        if (exc == null) {
            return;
        }
        Log.i(b, "onTokenError: " + exc.getMessage());
    }
}
