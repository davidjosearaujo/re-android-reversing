package cn.jpush.android.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.CmdMessage;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JPushMessageReceiver;
import com.facebook.share.internal.ShareConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.hunantv.media.player.MgtvMediaPlayer;
import java.util.Locale;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    private static a a;

    /* renamed from: cn.jpush.android.helper.a$a  reason: collision with other inner class name */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class C0014a extends cn.jpush.android.ac.e {
        private Context b;
        private JPushMessageReceiver c;
        private Intent d;

        public C0014a(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
            this.b = context;
            this.c = jPushMessageReceiver;
            this.d = intent;
            this.f = "JMessageReceiverHelper#MessageReceiverRunable";
        }

        @Override // cn.jpush.android.ac.e
        public void a() {
            try {
                Intent intent = this.d;
                if (intent != null && this.c != null) {
                    String action = intent.getAction();
                    Logger.d("JMessageReceiverHelper", "do receiver action :" + action);
                    if (action == null) {
                        Logger.w("JMessageReceiverHelper", "unsupport action type");
                        return;
                    } else if (action.equals("cn.jpush.android.intent.RECEIVE_MESSAGE")) {
                        int intExtra = this.d.getIntExtra(RemoteMessageConst.MSGTYPE, -1);
                        JPushMessage jPushMessage = null;
                        if (1 == intExtra || 2 == intExtra) {
                            jPushMessage = cn.jpush.android.aa.c.a().a(this.b, this.d);
                        }
                        Logger.d("JMessageReceiverHelper", "messageType:" + intExtra + ",jPushMessage:" + jPushMessage);
                        if (jPushMessage == null) {
                            Logger.w("JMessageReceiverHelper", "parse tagalias message failed");
                            return;
                        } else if (intExtra == 1) {
                            if (jPushMessage.isTagCheckOperator()) {
                                this.c.onCheckTagOperatorResult(this.b, jPushMessage);
                                return;
                            } else {
                                this.c.onTagOperatorResult(this.b, jPushMessage);
                                return;
                            }
                        } else if (intExtra == 2) {
                            this.c.onAliasOperatorResult(this.b, jPushMessage);
                            return;
                        } else {
                            Logger.w("JMessageReceiverHelper", "unsupport message type");
                            return;
                        }
                    } else if (action.equals("mobile_result")) {
                        this.c.onMobileNumberOperatorResult(this.b, d.a().a(this.b, this.d));
                        return;
                    } else if (action.equals(cn.jpush.android.ac.a.f(this.b, "custom_msg"))) {
                        this.c.onMessage(this.b, cn.jpush.android.d.b.a(this.d));
                        return;
                    } else if (action.equals(cn.jpush.android.ac.a.f(this.b, "cmd_msg"))) {
                        a.a(this.c, this.b, this.d);
                        return;
                    } else if (action.equals("cn.jpush.android.intent.NOTIFICATION_ARRIVED")) {
                        this.c.onNotifyMessageArrived(this.b, cn.jpush.android.x.c.b(this.b, this.d));
                        return;
                    } else if (action.equals("cn.jpush.android.intent.NOTIFICATION_UN_SHOW")) {
                        try {
                            this.c.onNotifyMessageUnShow(this.b, cn.jpush.android.x.c.b(this.b, this.d));
                            return;
                        } catch (Throwable unused) {
                            return;
                        }
                    } else if (action.equals(JPushInterface.ACTION_NOTIFICATION_OPENED)) {
                        this.c.onNotifyMessageOpened(this.b, cn.jpush.android.x.c.b(this.b, this.d));
                        return;
                    } else if (action.equals("cn.jpush.android.intent.NOTIFICATION_DISMISS")) {
                        this.c.onNotifyMessageDismiss(this.b, cn.jpush.android.x.c.b(this.b, this.d));
                        return;
                    } else if (JPushInterface.ACTION_NOTIFICATION_CLICK_ACTION_PROXY.equals(this.d.getAction())) {
                        Intent intent2 = new Intent(JPushInterface.ACTION_NOTIFICATION_CLICK_ACTION);
                        if (this.d.getExtras() != null) {
                            intent2.putExtras(this.d.getExtras());
                        }
                        this.c.onMultiActionClicked(this.b, intent2);
                        return;
                    } else if ("on_noti_settings_check".equals(action)) {
                        this.c.onNotificationSettingsCheck(this.b, this.d.getBooleanExtra("isOn", false), this.d.getIntExtra(ShareConstants.FEED_SOURCE_PARAM, 0));
                        return;
                    } else if ("cn.jpush.android.intent.INAPP_MESSAGE_ARRIVED".equals(action)) {
                        cn.jpush.android.d.d a = cn.jpush.android.x.c.a(this.b, this.d);
                        if (a != null) {
                            String str = "entityContent - " + a.toString();
                        }
                        Logger.d("JMessageReceiverHelper", "[MessageReceiverRunable] in-app message onInAppMessageArrived");
                        cn.jpush.android.p.a.a().b(this.b, a);
                        cn.jpush.android.o.b.c(this.b);
                        return;
                    } else if ("cn.jpush.android.intent.NOTIFY_INAPP_CANCEL".equals(action)) {
                        cn.jpush.android.p.a.a().c(this.b, cn.jpush.android.x.c.a(this.b, this.d));
                        return;
                    } else if (action.equals("cn.jpush.android.intent.IN_APP_MSG_ARRIVED_INTERVAL")) {
                        this.c.onInAppMessageArrived(this.b, cn.jpush.android.x.c.b(this.b, this.d));
                        return;
                    } else if (action.equals("cn.jpush.android.intent.IN_APP_MSG_CLICK_INTERVAL")) {
                        this.c.onInAppMessageClick(this.b, cn.jpush.android.x.c.b(this.b, this.d));
                        return;
                    } else if (action.equals("cn.jpush.android.intent.IN_APP_MSG_DISMISS_INTERVAL")) {
                        this.c.onInAppMessageDismiss(this.b, cn.jpush.android.x.c.b(this.b, this.d));
                        return;
                    } else if (action.equals("cn.jpush.android.intent.IN_APP_MSG_UN_SHOW_INTERVAL")) {
                        this.c.onInAppMessageUnShow(this.b, cn.jpush.android.x.c.b(this.b, this.d));
                        return;
                    } else if (action.equals("in_app_pull_result")) {
                        this.c.onPullInAppResult(this.b, cn.jpush.android.t.e.a().a(this.b, this.d));
                        return;
                    } else if ("cn.jpush.android.intent.ACTION_SYNC_ACTIVITY_TASK_CNT".equals(action)) {
                        return;
                    } else {
                        if ("cn.jpush.android.intent.SYNC_BLACK_LIST".equals(action)) {
                            cn.jpush.android.d.d a2 = cn.jpush.android.x.c.a(this.b, this.d);
                            if (a2 != null) {
                                cn.jpush.android.t.b.a(this.b, a2.br);
                                return;
                            }
                            return;
                        } else if ("cn.jpush.android.intent.GEO_RECEIVED".equals(action)) {
                            String stringExtra = this.d.getStringExtra("geo");
                            if (TextUtils.isEmpty(stringExtra)) {
                                stringExtra = "";
                            }
                            this.c.onGeofenceReceived(this.b, stringExtra);
                            return;
                        } else if ("cn.jpush.android.intent.GEO_REGION".equals(action)) {
                            this.c.onGeofenceRegion(this.b, this.d.getStringExtra("geo"), this.d.getDoubleExtra("geoLng", 200.0d), this.d.getDoubleExtra("geoLat", 200.0d));
                            return;
                        } else if (!"cn.jpush.android.intent.SYNC_ANI_CONFIG".equals(action)) {
                            Logger.w("JMessageReceiverHelper", "unsupport action type");
                            return;
                        } else {
                            cn.jpush.android.d.d a3 = cn.jpush.android.x.c.a(this.b, this.d);
                            if (a3 != null) {
                                cn.jpush.android.t.a.a().a(this.b, a3.bs);
                                return;
                            }
                            return;
                        }
                    }
                }
                Logger.w("JMessageReceiverHelper", "intent or jPushMessageReceiver was null");
            } catch (Throwable th) {
                Logger.ww("JMessageReceiverHelper", "MessageReceiver run failed:" + th.getMessage());
            }
        }
    }

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public static void a(Context context, Intent intent) {
        try {
            Logger.i("JMessageReceiverHelper", "Click notification action with extra: " + intent.getExtras().getString(JPushInterface.EXTRA_NOTIFICATION_ACTION_EXTRA));
            Intent intent2 = new Intent(JPushInterface.ACTION_NOTIFICATION_CLICK_ACTION);
            intent2.putExtras(intent.getExtras());
            intent2.addCategory(context.getPackageName());
            intent2.setPackage(context.getPackageName());
            context.sendBroadcast(intent2, context.getPackageName() + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX);
        } catch (Throwable th) {
            Logger.ww("JMessageReceiverHelper", "Click notification sendBroadcast :" + th.getMessage());
        }
    }

    public static void a(Context context, CustomMessage customMessage) {
        if (context == null || customMessage == null) {
            Logger.dd("JMessageReceiverHelper", "Send custom message to app failed, param is invalid!");
            return;
        }
        Logger.dd("JMessageReceiverHelper", "not found user push message,use old action to user");
        Intent intent = new Intent(JPushInterface.ACTION_MESSAGE_RECEIVED);
        intent.putExtra(JPushInterface.EXTRA_APP_KEY, customMessage.senderId);
        intent.putExtra(JPushInterface.EXTRA_MESSAGE, customMessage.message);
        intent.putExtra(JPushInterface.EXTRA_CONTENT_TYPE, customMessage.contentType);
        intent.putExtra(JPushInterface.EXTRA_TITLE, customMessage.title);
        intent.putExtra(JPushInterface.EXTRA_EXTRA, customMessage.extra);
        intent.putExtra(JPushInterface.EXTRA_MSG_ID, customMessage.messageId);
        if (JPushConstants.SDK_VERSION_CODE >= 387) {
            intent.putExtra(JPushInterface.EXTRA_TYPE_PLATFORM, customMessage.platform);
        }
        intent.addCategory(customMessage.appId);
        intent.setPackage(context.getPackageName());
        Locale locale = Locale.ENGLISH;
        context.sendBroadcast(intent, String.format(locale, "%s.permission.JPUSH_MESSAGE", customMessage.appId));
        Logger.i("JMessageReceiverHelper", "Send broadcast to app: " + String.format(locale, "%s.permission.JPUSH_MESSAGE", customMessage.appId));
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d7 A[Catch: all -> 0x01c5, TryCatch #0 {all -> 0x01c5, blocks: (B:17:0x0047, B:19:0x0084, B:20:0x008b, B:22:0x0093, B:23:0x009a, B:25:0x009f, B:27:0x00a7, B:28:0x00ab, B:39:0x00d3, B:41:0x00d7, B:42:0x00ed, B:44:0x00f5, B:45:0x00fc, B:47:0x0104, B:48:0x010b, B:50:0x0113, B:51:0x011a, B:53:0x0122, B:54:0x0129, B:56:0x012d, B:60:0x0134, B:62:0x0138, B:64:0x013e, B:65:0x014b, B:67:0x014f, B:69:0x0155, B:70:0x0166, B:72:0x016c, B:74:0x017a, B:75:0x017e, B:77:0x0188, B:78:0x018b, B:79:0x018f, B:80:0x0198, B:81:0x01a1, B:29:0x00af, B:31:0x00b4, B:33:0x00bc, B:34:0x00c1, B:36:0x00c6, B:38:0x00ce), top: B:89:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f5 A[Catch: all -> 0x01c5, TryCatch #0 {all -> 0x01c5, blocks: (B:17:0x0047, B:19:0x0084, B:20:0x008b, B:22:0x0093, B:23:0x009a, B:25:0x009f, B:27:0x00a7, B:28:0x00ab, B:39:0x00d3, B:41:0x00d7, B:42:0x00ed, B:44:0x00f5, B:45:0x00fc, B:47:0x0104, B:48:0x010b, B:50:0x0113, B:51:0x011a, B:53:0x0122, B:54:0x0129, B:56:0x012d, B:60:0x0134, B:62:0x0138, B:64:0x013e, B:65:0x014b, B:67:0x014f, B:69:0x0155, B:70:0x0166, B:72:0x016c, B:74:0x017a, B:75:0x017e, B:77:0x0188, B:78:0x018b, B:79:0x018f, B:80:0x0198, B:81:0x01a1, B:29:0x00af, B:31:0x00b4, B:33:0x00bc, B:34:0x00c1, B:36:0x00c6, B:38:0x00ce), top: B:89:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0104 A[Catch: all -> 0x01c5, TryCatch #0 {all -> 0x01c5, blocks: (B:17:0x0047, B:19:0x0084, B:20:0x008b, B:22:0x0093, B:23:0x009a, B:25:0x009f, B:27:0x00a7, B:28:0x00ab, B:39:0x00d3, B:41:0x00d7, B:42:0x00ed, B:44:0x00f5, B:45:0x00fc, B:47:0x0104, B:48:0x010b, B:50:0x0113, B:51:0x011a, B:53:0x0122, B:54:0x0129, B:56:0x012d, B:60:0x0134, B:62:0x0138, B:64:0x013e, B:65:0x014b, B:67:0x014f, B:69:0x0155, B:70:0x0166, B:72:0x016c, B:74:0x017a, B:75:0x017e, B:77:0x0188, B:78:0x018b, B:79:0x018f, B:80:0x0198, B:81:0x01a1, B:29:0x00af, B:31:0x00b4, B:33:0x00bc, B:34:0x00c1, B:36:0x00c6, B:38:0x00ce), top: B:89:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0113 A[Catch: all -> 0x01c5, TryCatch #0 {all -> 0x01c5, blocks: (B:17:0x0047, B:19:0x0084, B:20:0x008b, B:22:0x0093, B:23:0x009a, B:25:0x009f, B:27:0x00a7, B:28:0x00ab, B:39:0x00d3, B:41:0x00d7, B:42:0x00ed, B:44:0x00f5, B:45:0x00fc, B:47:0x0104, B:48:0x010b, B:50:0x0113, B:51:0x011a, B:53:0x0122, B:54:0x0129, B:56:0x012d, B:60:0x0134, B:62:0x0138, B:64:0x013e, B:65:0x014b, B:67:0x014f, B:69:0x0155, B:70:0x0166, B:72:0x016c, B:74:0x017a, B:75:0x017e, B:77:0x0188, B:78:0x018b, B:79:0x018f, B:80:0x0198, B:81:0x01a1, B:29:0x00af, B:31:0x00b4, B:33:0x00bc, B:34:0x00c1, B:36:0x00c6, B:38:0x00ce), top: B:89:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0122 A[Catch: all -> 0x01c5, TryCatch #0 {all -> 0x01c5, blocks: (B:17:0x0047, B:19:0x0084, B:20:0x008b, B:22:0x0093, B:23:0x009a, B:25:0x009f, B:27:0x00a7, B:28:0x00ab, B:39:0x00d3, B:41:0x00d7, B:42:0x00ed, B:44:0x00f5, B:45:0x00fc, B:47:0x0104, B:48:0x010b, B:50:0x0113, B:51:0x011a, B:53:0x0122, B:54:0x0129, B:56:0x012d, B:60:0x0134, B:62:0x0138, B:64:0x013e, B:65:0x014b, B:67:0x014f, B:69:0x0155, B:70:0x0166, B:72:0x016c, B:74:0x017a, B:75:0x017e, B:77:0x0188, B:78:0x018b, B:79:0x018f, B:80:0x0198, B:81:0x01a1, B:29:0x00af, B:31:0x00b4, B:33:0x00bc, B:34:0x00c1, B:36:0x00c6, B:38:0x00ce), top: B:89:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012d A[Catch: all -> 0x01c5, TryCatch #0 {all -> 0x01c5, blocks: (B:17:0x0047, B:19:0x0084, B:20:0x008b, B:22:0x0093, B:23:0x009a, B:25:0x009f, B:27:0x00a7, B:28:0x00ab, B:39:0x00d3, B:41:0x00d7, B:42:0x00ed, B:44:0x00f5, B:45:0x00fc, B:47:0x0104, B:48:0x010b, B:50:0x0113, B:51:0x011a, B:53:0x0122, B:54:0x0129, B:56:0x012d, B:60:0x0134, B:62:0x0138, B:64:0x013e, B:65:0x014b, B:67:0x014f, B:69:0x0155, B:70:0x0166, B:72:0x016c, B:74:0x017a, B:75:0x017e, B:77:0x0188, B:78:0x018b, B:79:0x018f, B:80:0x0198, B:81:0x01a1, B:29:0x00af, B:31:0x00b4, B:33:0x00bc, B:34:0x00c1, B:36:0x00c6, B:38:0x00ce), top: B:89:0x0047 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r8, cn.jpush.android.api.NotificationMessage r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 506
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.helper.a.a(android.content.Context, cn.jpush.android.api.NotificationMessage, java.lang.String):void");
    }

    public static void a(JPushMessageReceiver jPushMessageReceiver, Context context, Intent intent) {
        CmdMessage cmdMessage;
        try {
            int intExtra = intent.getIntExtra(JThirdPlatFormInterface.KEY_CODE, -2);
            int intExtra2 = intent.getIntExtra("cmd", -2);
            String stringExtra = intent.getStringExtra("message");
            Logger.d("JMessageReceiverHelper", "[callCmdMessage] code:" + intExtra + ",cmd:" + intExtra2 + ",message:" + stringExtra);
            Bundle extras = intent.getExtras();
            if (intExtra2 == -1) {
                jPushMessageReceiver.onConnected(context, false);
                return;
            }
            if (intExtra2 == 0) {
                if (intExtra == 0) {
                    jPushMessageReceiver.onRegister(context, stringExtra);
                    return;
                }
                cmdMessage = new CmdMessage(intExtra2, intExtra, stringExtra, extras);
            } else if (intExtra2 == 1) {
                jPushMessageReceiver.onConnected(context, true);
                return;
            } else if (intExtra2 == 2001) {
                return;
            } else {
                if (intExtra2 != 10000) {
                    switch (intExtra2) {
                        case CommonConstant.RETCODE.SIGN_IN_PARAMS_ERROR /* 2003 */:
                        case 2004:
                        case 2005:
                        case 2006:
                        case CommonConstant.RETCODE.SIGN_IN_NETWORK_UNDER_CONTROLED /* 2007 */:
                            break;
                        default:
                            switch (intExtra2) {
                                case MgtvMediaPlayer.MGTVMEDIA_ERROR_100001 /* 100001 */:
                                case MgtvMediaPlayer.MGTVMEDIA_ERROR_100002 /* 100002 */:
                                case MgtvMediaPlayer.MGTVMEDIA_ERROR_100003 /* 100003 */:
                                case MgtvMediaPlayer.MGTVMEDIA_ERROR_100004 /* 100004 */:
                                case 100005:
                                    break;
                                default:
                                    Logger.dd("JMessageReceiverHelper", "unkown cmd:" + intExtra2);
                                    return;
                            }
                    }
                }
                cmdMessage = new CmdMessage(intExtra2, intExtra, stringExtra, extras);
            }
            jPushMessageReceiver.onCommandResult(context, cmdMessage);
        } catch (Throwable th) {
            Logger.e("JMessageReceiverHelper", "callCmdMessage failed:" + th.getMessage());
        }
    }

    public void a(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
        JCoreHelper.majorExecutor(context, "JMessageReceiverHelper", new C0014a(context, jPushMessageReceiver, intent));
    }
}
