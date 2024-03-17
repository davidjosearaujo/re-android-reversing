package com.hunantv.oversea.push.repository.xiaomi;

import android.content.Context;
import android.util.Log;
import com.hunantv.oversea.push.domain.entity.PushMsgEntity;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import j.l.c.v.e.b;
import j.l.c.v.f.a;
import j.l.c.v.f.c;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class XMPushMsgReceiver extends PushMessageReceiver {
    private static final String a = "XMPushMsgReceiver";

    private String a(String[] strArr) {
        if (strArr != null) {
            String str = " ";
            for (String str2 : strArr) {
                str = str + str2 + " ";
            }
            return str;
        }
        return " ";
    }

    private b b() {
        return new b(a.c(12));
    }

    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        if (miPushCommandMessage == null) {
            return;
        }
        Log.i(a, "onCommandResult is called. " + miPushCommandMessage.toString());
    }

    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        if (miPushMessage == null) {
            return;
        }
        Log.i(a, "onNotificationMessageArrived is called. " + miPushMessage.toString());
        c.c().f(new PushMsgEntity("", miPushMessage.getMessageId(), "", "", "", 12, 12, miPushMessage.getContent()));
    }

    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        if (miPushMessage == null) {
            return;
        }
        Log.i(a, "onNotificationMessageClicked is called. " + miPushMessage.toString());
        b().f(new PushMsgEntity("", miPushMessage.getMessageId(), "", "", "", 12, 12, miPushMessage.getContent()), context);
    }

    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        if (miPushMessage == null) {
            return;
        }
        Log.i(a, "onReceivePassThroughMessage is called. " + miPushMessage.toString());
        b().e(new PushMsgEntity("", miPushMessage.getMessageId(), miPushMessage.getContent(), "", "", 12, 12, ""));
    }

    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        if (miPushCommandMessage == null) {
            return;
        }
        Log.i(a, "onReceiveRegisterResult is called. " + miPushCommandMessage.toString());
        String command = miPushCommandMessage.getCommand();
        List commandArguments = miPushCommandMessage.getCommandArguments();
        String str = (commandArguments == null || commandArguments.size() <= 0) ? null : (String) commandArguments.get(0);
        if ("register".equals(command) && miPushCommandMessage.getResultCode() == 0) {
            b().g(new PushMsgEntity("", "", "", "", str, 12, 12, ""));
        }
    }

    public void onRequirePermissions(Context context, String[] strArr) {
        super.onRequirePermissions(context, strArr);
        Log.e(a, "onRequirePermissions is called. need permission" + a(strArr));
    }
}
