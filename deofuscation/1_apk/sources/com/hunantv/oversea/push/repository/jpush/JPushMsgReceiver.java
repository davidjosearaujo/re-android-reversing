package com.hunantv.oversea.push.repository.jpush;

import android.content.Context;
import android.content.Intent;
import cn.jpush.android.api.CmdMessage;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.service.JPushMessageReceiver;
import com.hunantv.oversea.push.domain.entity.PushMsgEntity;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.c.v.e.b;
import j.l.c.v.f.a;
import j.l.c.v.f.e.d;
import j.l.c.v.f.e.f;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class JPushMsgReceiver extends JPushMessageReceiver {
    private static final String a = "JPushMsgReceiver";
    private static final /* synthetic */ c.b b = null;
    private static final /* synthetic */ c.b c = null;
    private static final /* synthetic */ c.b d = null;
    private static final /* synthetic */ c.b e = null;
    private static final /* synthetic */ c.b f = null;

    static {
        a();
    }

    private static /* synthetic */ void a() {
        e eVar = new e("JPushMsgReceiver.java", JPushMsgReceiver.class);
        b = eVar.H("method-execution", eVar.E("1", "onMessage", "com.hunantv.oversea.push.repository.jpush.JPushMsgReceiver", "android.content.Context:cn.jpush.android.api.CustomMessage", "context:customMessage", "", "void"), 32);
        c = eVar.H("method-execution", eVar.E("1", "onNotifyMessageOpened", "com.hunantv.oversea.push.repository.jpush.JPushMsgReceiver", "android.content.Context:cn.jpush.android.api.NotificationMessage", "context:message", "", "void"), 50);
        d = eVar.H("method-execution", eVar.E("1", "onMultiActionClicked", "com.hunantv.oversea.push.repository.jpush.JPushMsgReceiver", "android.content.Context:android.content.Intent", "context:intent", "", "void"), 68);
        e = eVar.H("method-execution", eVar.E("1", "onNotifyMessageArrived", "com.hunantv.oversea.push.repository.jpush.JPushMsgReceiver", "android.content.Context:cn.jpush.android.api.NotificationMessage", "context:message", "", "void"), 90);
        f = eVar.H("method-execution", eVar.E("1", "onCommandResult", "com.hunantv.oversea.push.repository.jpush.JPushMsgReceiver", "android.content.Context:cn.jpush.android.api.CmdMessage", "context:cmdMessage", "", "void"), 132);
    }

    private b b() {
        return new b(a.c(2));
    }

    public static final /* synthetic */ void c(JPushMsgReceiver jPushMsgReceiver, Context context, CmdMessage cmdMessage, c cVar) {
        if (cmdMessage == null) {
            return;
        }
        j.l.a.n.m.a.i("0", a, "[onCommandResult] NotificationTemp " + cmdMessage.toString());
    }

    public static final /* synthetic */ void d(JPushMsgReceiver jPushMsgReceiver, Context context, CustomMessage customMessage, c cVar) {
        if (customMessage == null) {
            return;
        }
        j.l.a.n.m.a.i("0", a, "[onMessage] " + customMessage);
        jPushMsgReceiver.b().e(new PushMsgEntity("", customMessage.messageId, customMessage.message, customMessage.appId, "", 2, 2, ""));
    }

    public static final /* synthetic */ void f(JPushMsgReceiver jPushMsgReceiver, Context context, NotificationMessage notificationMessage, c cVar) {
        if (notificationMessage == null) {
            return;
        }
        j.l.a.n.m.a.i("0", a, "[onNotifyMessageArrived] NotificationTemp" + notificationMessage);
        j.l.c.v.f.c.c().f(new PushMsgEntity("", notificationMessage.msgId, "", "", "", 2, notificationMessage.platform, notificationMessage.notificationExtras));
    }

    public static final /* synthetic */ void g(JPushMsgReceiver jPushMsgReceiver, Context context, NotificationMessage notificationMessage, c cVar) {
        if (notificationMessage == null) {
            return;
        }
        j.l.a.n.m.a.i("0", a, "[NotificationTemp onNotifyMessageOpened] " + notificationMessage);
        jPushMsgReceiver.b().f(new PushMsgEntity("", notificationMessage.msgId, "", "", "", 2, notificationMessage.platform, notificationMessage.notificationExtras), context);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onCheckTagOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onCheckTagOperatorResult(context, jPushMessage);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    @WithTryCatchRuntime
    public void onCommandResult(Context context, CmdMessage cmdMessage) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new f(new Object[]{this, context, cmdMessage, e.x(f, this, this, context, cmdMessage)}).e(69648));
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onConnected(Context context, boolean z) {
        j.l.a.n.m.a.i("0", a, "[onConnected] " + z);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    @WithTryCatchRuntime
    public void onMessage(Context context, CustomMessage customMessage) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.v.f.e.b(new Object[]{this, context, customMessage, e.x(b, this, this, context, customMessage)}).e(69648));
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    @WithTryCatchRuntime
    public void onMultiActionClicked(Context context, Intent intent) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new d(new Object[]{this, context, intent, e.x(d, this, this, context, intent)}).e(69648));
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    @WithTryCatchRuntime
    public void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.v.f.e.e(new Object[]{this, context, notificationMessage, e.x(e, this, this, context, notificationMessage)}).e(69648));
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onNotifyMessageDismiss(Context context, NotificationMessage notificationMessage) {
        j.l.a.n.m.a.i("0", a, "[onNotifyMessageDismiss] " + notificationMessage);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    @WithTryCatchRuntime
    public void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.v.f.e.c(new Object[]{this, context, notificationMessage, e.x(c, this, this, context, notificationMessage)}).e(69648));
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onRegister(Context context, String str) {
        j.l.a.n.m.a.i("0", a, "[onRegister] NotificationTemp" + str);
        b().g(new PushMsgEntity("", "", "", "", str, 2, 2, ""));
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onTagOperatorResult(Context context, JPushMessage jPushMessage) {
        j.l.a.n.m.a.i("0", a, "NotificationTemp onTagOperatorResult ：" + jPushMessage);
        super.onTagOperatorResult(context, jPushMessage);
    }
}
