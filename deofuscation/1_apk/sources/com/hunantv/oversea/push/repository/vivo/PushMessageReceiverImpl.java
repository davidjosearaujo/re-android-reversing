package com.hunantv.oversea.push.repository.vivo;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.hunantv.oversea.push.domain.entity.PushMsgEntity;
import com.hunantv.oversea.push.domain.entity.PushNotifyMsgEntity;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;
import j.l.c.v.e.b;
import j.l.c.v.f.a;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PushMessageReceiverImpl extends OpenClientPushMessageReceiver {
    private static final String a = "PushMessageReceiverImpl";

    private b a() {
        return new b(a.c(16));
    }

    public void onNotificationMessageClicked(Context context, UPSNotificationMessage uPSNotificationMessage) {
        if (uPSNotificationMessage == null || uPSNotificationMessage.getParams() == null) {
            return;
        }
        try {
            j.l.a.n.m.a.i("0", a, "onNotificationMessageClicked vivo push");
            Map params = uPSNotificationMessage.getParams();
            PushNotifyMsgEntity pushNotifyMsgEntity = new PushNotifyMsgEntity();
            pushNotifyMsgEntity.push_id = (String) params.get("push_id");
            pushNotifyMsgEntity.push_json = (String) params.get("push_json");
            pushNotifyMsgEntity.notification_type = "";
            String jSONString = JSON.toJSONString(pushNotifyMsgEntity);
            a().f(new PushMsgEntity("", uPSNotificationMessage.getMsgId() + "", "", "", "", 16, 16, jSONString), context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onReceiveRegId(Context context, String str) {
        a().g(new PushMsgEntity("", "", "", "", str, 16, 16, ""));
    }
}
