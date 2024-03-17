package cn.jpush.android.l;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import cn.jpush.android.aa.b;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.b.d;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.i;
import cn.jpush.android.local.JPushAction;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.local.JPushResponse;
import cn.jpush.android.local.ProxyActivityAction;
import cn.jpush.android.r.c;
import cn.jpush.android.service.JPushMessageReceiver;
import cn.jpush.android.t.e;
import cn.jpush.android.x.g;
import cn.jpush.android.z.f;
import com.alibaba.fastjson.asm.Label;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a extends JPushAction {
    private Boolean a;
    private Boolean b;
    private Context c;
    private c d;

    /* renamed from: cn.jpush.android.l.a$a  reason: collision with other inner class name */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class C0015a {
        private static String a(byte b) {
            switch (b) {
                case 0:
                case 7:
                default:
                    return "jpush";
                case 1:
                    return "xiaomi";
                case 2:
                    return "huawei";
                case 3:
                    return "meizu";
                case 4:
                    return "oppo";
                case 5:
                    return "vivo";
                case 6:
                    return "asus";
                case 8:
                    return "fcm";
            }
        }

        private static void a(int i, String str, Intent intent) {
            String str2;
            if (i == 1) {
                intent.setData(Uri.parse(str));
                return;
            }
            if (i == 2) {
                str2 = "JMessageExtra";
            } else if (i != 3) {
                return;
            } else {
                str2 = "asus_data";
            }
            intent.putExtra(str2, str);
        }

        private static void a(Context context, JSONObject jSONObject, byte b) {
            if (3 != b) {
                Bundle bundle = new Bundle();
                bundle.putByte(JThirdPlatFormInterface.KEY_PLATFORM, b);
                bundle.putString("data", jSONObject.toString());
                JThirdPlatFormInterface.doAction(context, JThirdPlatFormInterface.ACTION_NOTIFICATION_CLCKED, bundle);
            }
        }

        public static boolean a(Context context, int i, String str) {
            Logger.d("JPushActionImpl", "msg content is " + String.valueOf(str));
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                byte optInt = (byte) jSONObject.optInt("rom_type");
                Logger.d("JPushActionImpl", "通道：" + a(optInt));
                boolean has = jSONObject.has(JThirdPlatFormInterface.KEY_MSG_ID);
                boolean has2 = jSONObject.has("rom_type");
                boolean has3 = jSONObject.has("n_title");
                boolean has4 = jSONObject.has("n_content");
                Logger.d("JPushActionImpl", "hasMsgid:" + has);
                Logger.d("JPushActionImpl", "hasWhich:" + has2);
                Logger.d("JPushActionImpl", "hasTitle:" + has3);
                Logger.d("JPushActionImpl", "hasContent:" + has4);
                if (has && has2 && has3 && has4) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("n_intent");
                    jSONObject.remove("n_intent");
                    a(context, jSONObject, optInt);
                    if (optJSONObject == null) {
                        return false;
                    }
                    String optString = optJSONObject.optString("n_url", "");
                    Logger.d("JPushActionImpl", "n_url:" + optString);
                    String str2 = new String(Base64.decode(optString, 0));
                    Logger.d("JPushActionImpl", "url_intent:" + str2);
                    String jSONObject2 = jSONObject.toString();
                    Intent parseUri = Build.VERSION.SDK_INT >= 22 ? Intent.parseUri(str2, 4) : Intent.parseUri(str2, 0);
                    parseUri.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    a(i, jSONObject2, parseUri);
                    Logger.d("JPushActionImpl", "intentSend:" + parseUri);
                    j.l.c.e0.a.a.a.h(parseUri);
                    context.startActivity(parseUri);
                    return true;
                }
                Logger.d("JPushActionImpl", "参数缺失");
                return false;
            } catch (Throwable th) {
                Logger.w("JPushActionImpl", "parse notification error : " + th.getMessage());
                return false;
            }
        }

        public static boolean a(Context context, Intent intent) {
            int i;
            String str;
            Logger.d("JPushActionImpl", "用户点击打开了通知");
            if (intent.getData() != null) {
                str = intent.getData().toString();
                Logger.d("JPushActionImpl", "华为：" + str);
                i = 1;
            } else {
                i = 0;
                str = null;
            }
            if (TextUtils.isEmpty(str) && intent.getExtras() != null) {
                str = intent.getExtras().getString("JMessageExtra");
                Logger.d("JPushActionImpl", "fcm、oppo、vivo、华硕、小米：" + str);
                i = 2;
            }
            if (TextUtils.isEmpty(str) && intent.getExtras() != null) {
                str = intent.getExtras().getString("asus_data");
                Logger.d("JPushActionImpl", "asus_data：" + str);
                i = 3;
            }
            return a(context, i, str);
        }
    }

    private static JSONObject a(ByteBuffer byteBuffer) {
        try {
            byteBuffer.getLong();
            byte[] bArr = new byte[byteBuffer.getShort()];
            byteBuffer.get(bArr);
            String str = new String(bArr, "UTF-8");
            Logger.d("JPushActionImpl", "parseBundle2Json content: " + str);
            return new JSONObject(str);
        } catch (Exception e) {
            Logger.w("JPushActionImpl", "parseBundle2Json exception:" + e.getMessage());
            return null;
        }
    }

    private static void a(Context context, int i, long j) {
        if (i != 10) {
            if (i == 34) {
                e.a().a(context, j, JPushInterface.ErrorCode.TIMEOUT, 1, 30L);
                return;
            } else if (i == 37) {
                d.a(context).a(j, JPushInterface.ErrorCode.TIMEOUT, null);
                return;
            } else {
                switch (i) {
                    case 26:
                        cn.jpush.android.helper.d.a().a(context, j, JPushInterface.ErrorCode.TIMEOUT);
                        return;
                    case 27:
                        cn.jpush.android.ab.a.a().b(context, j);
                        return;
                    case 28:
                    case 29:
                        break;
                    default:
                        return;
                }
            }
        }
        cn.jpush.android.aa.a.a(context, b.a().a(j), JPushInterface.ErrorCode.TIMEOUT, j);
    }

    private static void a(Context context, Bundle bundle) {
        if (bundle == null) {
            Logger.w("JPushActionImpl", "[setMaxNotificationNum] bundle is bull");
            return;
        }
        int i = bundle.getInt("num");
        Logger.dd("JPushActionImpl", "action:setMaxNotificationNum :" + i);
        int b = g.b();
        Logger.v("JPushActionImpl", "number in queue: " + b);
        if (i < b) {
            int i2 = b - i;
            Logger.v("JPushActionImpl", "decreaseNotification:" + i2);
            cn.jpush.android.x.c.c(context, i2);
        }
        cn.jpush.android.cache.a.c(context, i);
    }

    private static void a(Context context, JPushResponse jPushResponse) {
        Logger.dd("JPushActionImpl", "action:handleMsg:" + jPushResponse);
        if (jPushResponse == null) {
            return;
        }
        int cmd = jPushResponse.getCmd();
        if (cmd == 3) {
            cn.jpush.android.z.d dVar = new cn.jpush.android.z.d(jPushResponse);
            if (cn.jpush.android.cache.a.d(context)) {
                Logger.d("JPushActionImpl", "JPush was stoped");
                if (dVar.a() != 20) {
                    return;
                }
            }
            cn.jpush.android.d.b.a(context, dVar);
            return;
        }
        if (cmd != 10) {
            if (cmd == 34) {
                cn.jpush.android.z.b bVar = new cn.jpush.android.z.b(jPushResponse);
                e.a().a(context, bVar.getRquestId(), bVar.a(), bVar.c(), bVar.b());
                return;
            } else if (cmd == 36) {
                d.a(context).a(new cn.jpush.android.n.b(jPushResponse));
                return;
            } else if (cmd == 37) {
                d.a(context).a(jPushResponse.getRquestId(), 0, new cn.jpush.android.n.d(jPushResponse));
                return;
            } else {
                switch (cmd) {
                    case 25:
                        JSONObject a = a(jPushResponse.getBody());
                        if (a != null) {
                            int optInt = a.optInt("cmd");
                            if (optInt == 56) {
                                d.a(context).a(a);
                                return;
                            } else if (optInt != 57) {
                                if (optInt == 59) {
                                    a(context, a);
                                    cn.jpush.android.p.a.a().a(context, a);
                                    return;
                                } else if (optInt == 60) {
                                    cn.jpush.android.x.c.a(context, 2, true);
                                    return;
                                } else if (optInt == 77) {
                                    cn.jpush.android.t.c.a().b(context, a);
                                    return;
                                } else if (optInt != 78) {
                                    Logger.d("JPushActionImpl", "Unknown command for ctrl");
                                    return;
                                } else {
                                    cn.jpush.android.t.c.a().a(context, a);
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        return;
                    case 26:
                        cn.jpush.android.z.a aVar = new cn.jpush.android.z.a(jPushResponse);
                        cn.jpush.android.helper.d.a().a(context, aVar.getRquestId(), aVar.a());
                        return;
                    case 27:
                        cn.jpush.android.z.a aVar2 = new cn.jpush.android.z.a(jPushResponse);
                        if (aVar2.a() == 0) {
                            cn.jpush.android.ab.a.a().a(context, jPushResponse.getRquestId());
                            return;
                        } else {
                            cn.jpush.android.ab.a.a().a(context, jPushResponse.getRquestId(), aVar2.a());
                            return;
                        }
                    case 28:
                    case 29:
                        break;
                    default:
                        Logger.w("JPushActionImpl", "Unknown command for parsing inbound.");
                        return;
                }
            }
        }
        cn.jpush.android.aa.a.a(context, new f(jPushResponse).a(), jPushResponse.getCmd() != 28 ? 2 : 1, jPushResponse.getRquestId());
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            String optString = jSONObject.getJSONObject("content").optString("ids");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            Logger.d("JPushActionImpl", "dealCancelNotification ids=" + optString);
            String[] split = optString.split(",");
            LinkedList linkedList = new LinkedList();
            for (String str : split) {
                if (!TextUtils.isEmpty(str)) {
                    if (cn.jpush.android.x.e.a(context, str)) {
                        int a = cn.jpush.android.x.c.a(str, 0);
                        Logger.d("JPushActionImpl", "message id:" + str + " is in local history ,try cancel notificationID : " + a);
                        if (cn.jpush.android.x.c.a(context, a)) {
                            cn.jpush.android.x.c.d(context, a);
                            cn.jpush.android.helper.c.a(split.length == 2 ? split[1] : str, 1068, context);
                        }
                    } else if (cn.jpush.android.x.e.a(context, str, null)) {
                        Logger.d("JPushActionImpl", "dealCancelNotification , do nothing ");
                    } else {
                        byte a2 = cn.jpush.android.ab.c.a().a(context, str);
                        Logger.d("JPushActionImpl", "message id:" + str + " may be ospush channel,try cancel by sdkType: " + ((int) a2));
                        if (a2 != -1) {
                            cn.jpush.android.helper.c.a(str, "", a2, 1069, context);
                        }
                    }
                    linkedList.add(str);
                }
            }
            cn.jpush.android.x.e.a(context, linkedList);
        } catch (Throwable th) {
            Logger.w("JPushActionImpl", "dealCancelNotification e:" + th);
        }
    }

    private boolean a(Context context) {
        Boolean bool = this.a;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null) {
            Logger.ww("JPushActionImpl", "context is null");
            return false;
        }
        this.c = context.getApplicationContext();
        Boolean valueOf = Boolean.valueOf(cn.jpush.android.ac.a.h(context));
        this.a = valueOf;
        if (valueOf.booleanValue()) {
            cn.jpush.android.o.b.a(context);
        }
        return this.a.booleanValue();
    }

    private void b(Context context) {
        Logger.d("JPushActionImpl", "serviceInit...");
        try {
            if (this.b != null) {
                return;
            }
            this.b = Boolean.TRUE;
            boolean z = JPushConstants.SUPPORT_DY;
            cn.jpush.android.x.c.a(context, 0, true);
            e(context);
            Logger.d("JPushActionImpl", "google:true");
            int i = cn.jpush.android.m.a.a != JPushConstants.SDK_VERSION_CODE ? 2 : 0;
            Logger.d("JPushActionImpl", "custom:1,dynamic:" + i);
            cn.jpush.android.x.f.a().a(context, null);
            JCoreHelper.reportSdkType(context, "push", 1, i, cn.jpush.android.m.a.a);
            if (JPushConstants.canGetLbsInBackGround(context)) {
                d.a(context).a();
            }
            d(context);
            c(context);
            cn.jpush.android.t.a.a().b(context);
        } catch (Throwable unused) {
        }
    }

    private static void b(Context context, Bundle bundle) {
        if (bundle == null) {
            Logger.w("JPushActionImpl", "[setSilenceTime] bundle is bull");
            return;
        }
        String string = bundle.getString(CrashHianalyticsData.TIME);
        Logger.dd("JPushActionImpl", "action:setSilenceTime pushTime:" + string);
        cn.jpush.android.cache.a.c(context, string);
    }

    private void c(Context context) {
        new cn.jpush.android.t.b().a(context);
    }

    private static void c(Context context, Bundle bundle) {
        if (bundle == null) {
            Logger.w("JPushActionImpl", "[setPushTime] bundle is bull");
            return;
        }
        cn.jpush.android.cache.a.b(context, true);
        String string = bundle.getString(CrashHianalyticsData.TIME);
        if (!Pattern.compile("([0-6]{0,7})_((([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3]))|(([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3])-)+(([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3])))").matcher(string).matches()) {
            Logger.ee("JPushActionImpl", "Invalid time format - " + string);
            return;
        }
        String g = cn.jpush.android.cache.a.g(context);
        if (string.equals(g)) {
            Logger.dd("JPushActionImpl", "Already SetPushTime, give up - " + g);
            return;
        }
        Logger.dd("JPushActionImpl", "action:setPushTime pushTime:" + string);
        cn.jpush.android.cache.a.b(context, string);
    }

    private void d(Context context) {
        try {
            Logger.d("JPushActionImpl", "google play not register ir");
        } catch (Throwable th) {
            Logger.w("JPushActionImpl", "register apk install receiver failed, " + th.getMessage());
        }
    }

    private void e(Context context) {
        try {
            Class.forName("cn.jpush.android.dy.JPushThirdDyManager").getDeclaredMethod("update", Context.class).invoke(null, context);
        } catch (Throwable unused) {
        }
    }

    @Override // cn.jpush.android.local.JPushAction
    public Object beforLogin(Context context, String str, int i, String str2) {
        String str3;
        a(context);
        if (context == null) {
            str3 = "context was null";
        } else if (!TextUtils.isEmpty(str2)) {
            if ("platformtype".equals(str2)) {
                if (i >= 16) {
                    return Byte.valueOf(cn.jpush.android.ab.c.a().e(context));
                }
            } else if ("platformregid".equals(str2)) {
                return cn.jpush.android.ab.c.a().f(context);
            }
            return null;
        } else {
            str3 = " filed name was empty";
        }
        Logger.e("JPushActionImpl", str3);
        return null;
    }

    @Override // cn.jpush.android.local.JPushAction
    public ProxyActivityAction getPopWinActivity(Context context) {
        return new cn.jpush.android.ui.b();
    }

    @Override // cn.jpush.android.local.JPushAction
    public ProxyActivityAction getPushActivity(Context context) {
        return new cn.jpush.android.ui.c();
    }

    @Override // cn.jpush.android.local.JPushAction
    public String getSdkVersion(String str) {
        return cn.jpush.android.m.a.b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:210:0x04ca, code lost:
        if (r2 == 2001) goto L278;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x04cc, code lost:
        if (r2 == 0) goto L278;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x04ce, code lost:
        if (r2 != 2002) goto L269;
     */
    @Override // cn.jpush.android.local.JPushAction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object handleAction(android.content.Context r19, java.lang.String r20, java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 2176
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.l.a.handleAction(android.content.Context, java.lang.String, java.lang.Object):java.lang.Object");
    }

    @Override // cn.jpush.android.local.JPushAction
    public void handleNotificationIntent(Context context, Intent intent) {
        cn.jpush.android.d.d a = cn.jpush.android.x.c.a(context, intent);
        Logger.i("JPushActionImpl", "handleNotificationIntent:" + a);
        if (a == null) {
            if (C0015a.a(context, intent)) {
                Logger.i("JPushActionImpl", "handleNotificationIntent handleOpenClick:true");
                return;
            }
            return;
        }
        if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction()) && a.l != 1) {
            byte b = a.ae;
            if (b == 0) {
                cn.jpush.android.helper.c.a(a.c, 1000, context);
            } else {
                cn.jpush.android.helper.c.a(context, a.c, b, (String) null);
            }
            int f = cn.jpush.android.x.c.f(context, a);
            Logger.d("JPushActionImpl", "is deep link:" + f);
            if (f == 2) {
                if (i.f()) {
                    cn.jpush.android.x.c.e(context, a);
                    return;
                }
                return;
            }
        }
        cn.jpush.android.x.c.a(context, intent.getAction(), a, intent);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onActivityLifeCallback(Activity activity, String str) {
        try {
            if (this.d == null) {
                this.d = new c();
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -1897185151:
                    if (str.equals("started")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1884319283:
                    if (str.equals("stopped")) {
                        c = 3;
                        break;
                    }
                    break;
                case -995321554:
                    if (str.equals("paused")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1097547223:
                    if (str.equals("resumed")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1986762265:
                    if (str.equals("destroyed")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                this.d.b(activity);
            } else if (c == 1) {
                this.d.c(activity);
                cn.jpush.android.k.a.d(activity);
            } else if (c == 2) {
                this.d.d(activity);
            } else if (c == 3) {
                this.d.e(activity);
            } else if (c != 4) {
            } else {
                this.d.f(activity);
            }
        } catch (Throwable th) {
            Logger.w("JPushActionImpl", "onActivityLifeCallback failed. " + th.getMessage());
        }
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onInAppMessageArrived(Context context, NotificationMessage notificationMessage) {
        cn.jpush.android.helper.a.a(context, notificationMessage, JPushInterface.ACTION_IN_APP_MSG_RECEIVED);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onInAppMessageClick(Context context, NotificationMessage notificationMessage) {
        cn.jpush.android.helper.a.a(context, notificationMessage, JPushInterface.ACTION_IN_APP_MSG_CLICK);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onJPushMessageReceive(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
        cn.jpush.android.helper.a.a().a(context.getApplicationContext(), jPushMessageReceiver, intent);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onMessage(Context context, CustomMessage customMessage) {
        cn.jpush.android.helper.a.a(context, customMessage);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onMultiAction(Context context, Intent intent) {
        cn.jpush.android.helper.a.a(context, intent);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage) {
        cn.jpush.android.helper.a.a(context, notificationMessage, JPushInterface.ACTION_NOTIFICATION_RECEIVED);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        cn.jpush.android.helper.a.a(context, notificationMessage, JPushInterface.ACTION_NOTIFICATION_OPENED);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void onTagAliasResponse(Context context, long j, int i, Intent intent) {
        cn.jpush.android.aa.c.a().a(context.getApplicationContext(), j, i, intent);
    }

    @Override // cn.jpush.android.local.JPushAction
    public void setAliasAndTags(Context context, String str, Set<String> set, CallBackParams callBackParams) {
        cn.jpush.android.aa.a.a(context, str, set, callBackParams);
    }
}
