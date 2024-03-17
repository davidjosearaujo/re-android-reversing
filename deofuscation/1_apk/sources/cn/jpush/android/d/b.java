package cn.jpush.android.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.x.e;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    public static CustomMessage a(Intent intent) {
        String stringExtra;
        CustomMessage customMessage;
        CustomMessage customMessage2 = null;
        try {
            stringExtra = intent.getStringExtra("msgid");
            customMessage = new CustomMessage();
        } catch (Throwable th) {
            th = th;
        }
        try {
            customMessage.messageId = stringExtra;
            customMessage.appId = intent.getStringExtra("appId");
            customMessage.senderId = intent.getStringExtra("senderId");
            String stringExtra2 = intent.getStringExtra("data");
            if (stringExtra2 != null) {
                JSONObject jSONObject = new JSONObject(stringExtra2);
                customMessage.message = jSONObject.optString("message", "");
                customMessage.contentType = jSONObject.optString("content_type", "");
                customMessage.title = jSONObject.optString("title", "");
                customMessage.extra = jSONObject.optString("extras", "");
            }
            if (JPushConstants.SDK_VERSION_CODE >= 387) {
                customMessage.platform = intent.getByteExtra(JThirdPlatFormInterface.KEY_PLATFORM, (byte) 0);
            }
            d.a(stringExtra, intent.getStringExtra("_j_data_"));
            return customMessage;
        } catch (Throwable th2) {
            th = th2;
            customMessage2 = customMessage;
            Logger.w("MessageHelper", "processMessage failed:" + th.getMessage());
            return customMessage2;
        }
    }

    private static cn.jpush.android.b.b a(d dVar) {
        try {
            cn.jpush.android.b.b a = cn.jpush.android.b.b.a(new JSONObject(dVar.h).optJSONObject("geofence"));
            if (a != null) {
                a.t = dVar;
                return a;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void a(Context context, int i, long j, long j2, String str) {
        JCoreHelper.sendData(context, JPushConstants.SDK_TYPE, 4, 3, j2, cn.jpush.android.z.c.a(0, (byte) i, j, str));
    }

    public static void a(Context context, int i, String str, String str2, String str3, long j, byte b) {
        if (!str2.equals(context.getPackageName())) {
            Logger.e("MessageHelper", "msg appId is not mine pkgname,appid:" + str2 + ",pkgname:" + context.getPackageName());
            return;
        }
        Logger.d("MessageHelper", "action:receivedPushMessage msgId = " + j);
        d b2 = d.b(str, str2, str3, j);
        if (b2 == null || c.a(context, b2.a()) || e.a(context, b2.c, b2.g)) {
            return;
        }
        b2.ae = b;
        cn.jpush.android.b.b a = a(b2);
        d a2 = d.a(context, b2);
        if (a != null && !TextUtils.isEmpty(a.a)) {
            cn.jpush.android.b.d.a(context).a(a);
        } else if (a2 == null) {
            a(context, b2);
        } else {
            a2.bn = 201;
            a2.av = i;
            cn.jpush.android.p.a.a().a(context, a2);
        }
    }

    public static void a(Context context, d dVar) {
        Logger.d("MessageHelper", "processBasicEntity type:" + dVar.e);
        int i = dVar.j ? dVar.i == 4 ? 3 : 1 : 2;
        dVar.e = i;
        if ((i & 2) != 0) {
            Logger.d("MessageHelper", "processBasicEntity user-defined message.");
            if (TextUtils.isEmpty(dVar.m) && TextUtils.isEmpty(dVar.p)) {
                Logger.ww("MessageHelper", "no message or extra send to user");
            } else {
                b(context, dVar);
            }
        }
        if ((dVar.e & 1) != 0) {
            Logger.d("MessageHelper", "processBasicEntity notification");
            if (cn.jpush.android.cache.a.d(context)) {
                Logger.i("MessageHelper", "Service is stoped, give up all the message");
                return;
            }
            dVar.a(context);
            if (cn.jpush.android.x.c.b(context)) {
                e.b(context, dVar.c);
                cn.jpush.android.x.c.a(context, dVar);
                return;
            }
            cn.jpush.android.helper.c.a(dVar.c, 986, context);
            Logger.ii("MessageHelper", "push is invalidPushTime，Intercept the message");
        }
    }

    public static void a(Context context, cn.jpush.android.z.d dVar) {
        String c = d.c(dVar.c());
        a(context, dVar.a(), dVar.b(), dVar.getRid(), c);
        long b = dVar.b();
        int a = dVar.a();
        String c2 = dVar.c();
        Logger.d("MessageHelper", "msgType = " + a + ", msgId = " + b + ", jdata = " + c);
        StringBuilder sb = new StringBuilder();
        sb.append("msgContent: \n");
        sb.append(c2);
        Logger.v("MessageHelper", sb.toString());
        Logger.d("MessageHelper", "msgContent size:" + c2.getBytes().length);
        LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(c2));
        try {
            String readLine = lineNumberReader.readLine();
            String readLine2 = lineNumberReader.readLine();
            if (readLine == null) {
                Logger.e("MessageHelper", "NO appId");
            } else if (readLine2 == null) {
                Logger.e("MessageHelper", "NO senderId");
            } else {
                int length = readLine.length() + readLine2.length() + 2;
                if (c2.length() <= length + 1) {
                    Logger.d("MessageHelper", "No msgContent");
                    return;
                }
                String substring = c2.substring(length);
                if (!readLine2.equals(JCoreHelper.getAppKey(context))) {
                    Logger.e("MessageHelper", "msg senderId is not mine appkey,senderId:" + readLine2 + ",appkey:" + JCoreHelper.getAppKey(context));
                    return;
                }
                Logger.v("MessageHelper", "Message Fields - appId:" + readLine + ", senderId:" + readLine2 + ", msgContent:" + substring + ", contentLen: " + substring.length());
                if (a != 0 && a != 2) {
                    if (a == 20) {
                        cn.jpush.android.aa.a.a(context, substring, 0, -1L);
                        return;
                    }
                    switch (a) {
                        case 100:
                        case 101:
                        case 103:
                        case 104:
                            break;
                        case 102:
                            a(context, substring, readLine, readLine2, b, (byte) 0);
                            return;
                        default:
                            Logger.ww("MessageHelper", "unkown msg type");
                            return;
                    }
                }
                a(context, a, substring, readLine, readLine2, b, (byte) 0);
            }
        } catch (Throwable th) {
            Logger.e("MessageHelper", "Parse msgContent failed", th);
        }
    }

    private static void a(Context context, String str, String str2, String str3, long j, byte b) {
        try {
            Logger.d("MessageHelper", "[processInAppMessage] received in-app message, msgId = " + j + ", appId: " + str2 + ", appKey: " + str3);
            d a = d.a(str, str2, str3, j);
            if (a == null) {
                return;
            }
            if (!str2.equals(context.getPackageName())) {
                Logger.e("MessageHelper", "[processInAppMessage] msg appId is not mine pkgname,appid:" + str2 + ",pkgname:" + context.getPackageName());
                cn.jpush.android.helper.c.a(a.c, 1282, context);
            } else if (c.a(context, a.a())) {
                cn.jpush.android.helper.c.a(a.c, 1309, context);
            } else if (cn.jpush.android.cache.a.d(context)) {
                Logger.i("MessageHelper", "Service is stopped, give up all the message");
                cn.jpush.android.helper.c.a(a.c, 1265, context);
            } else {
                a.bn = 200;
                cn.jpush.android.p.a.a().a(context, a);
            }
        } catch (Throwable th) {
            Logger.ww("MessageHelper", "[processInAppMessage] process in app message failed, error: " + th.getMessage());
        }
    }

    public static void b(Context context, d dVar) {
        try {
            String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
            if (TextUtils.isEmpty(messageReceiverClass)) {
                Logger.dd("MessageHelper", "not found user push message,use old action to user");
                Intent intent = new Intent(JPushInterface.ACTION_MESSAGE_RECEIVED);
                intent.putExtra(JPushInterface.EXTRA_APP_KEY, dVar.b);
                intent.putExtra(JPushInterface.EXTRA_MESSAGE, dVar.m);
                intent.putExtra(JPushInterface.EXTRA_CONTENT_TYPE, dVar.n);
                intent.putExtra(JPushInterface.EXTRA_TITLE, dVar.o);
                intent.putExtra(JPushInterface.EXTRA_EXTRA, dVar.p);
                intent.putExtra(JPushInterface.EXTRA_MSG_ID, dVar.c);
                if (JPushConstants.SDK_VERSION_CODE >= 387) {
                    intent.putExtra(JPushInterface.EXTRA_TYPE_PLATFORM, dVar.ae);
                }
                intent.addCategory(dVar.a);
                intent.setPackage(context.getPackageName());
                Locale locale = Locale.ENGLISH;
                context.sendBroadcast(intent, String.format(locale, "%s.permission.JPUSH_MESSAGE", dVar.a));
                Logger.i("MessageHelper", "Send broadcast to app: " + String.format(locale, "%s.permission.JPUSH_MESSAGE", dVar.a));
            } else {
                Intent intent2 = new Intent(context, Class.forName(messageReceiverClass));
                intent2.setAction(cn.jpush.android.ac.a.f(context, "custom_msg"));
                intent2.putExtra("data", dVar.h);
                intent2.putExtra("msgid", dVar.c);
                intent2.putExtra("appId", dVar.a);
                intent2.putExtra("senderId", dVar.b);
                intent2.putExtra(JThirdPlatFormInterface.KEY_PLATFORM, dVar.ae);
                intent2.putExtra("_j_data_", dVar.f);
                if (JPushConstants.getPushMessageReceiver(context) != null) {
                    JPushConstants.getPushMessageReceiver(context).onMessage(context, a(intent2));
                } else {
                    context.sendBroadcast(intent2);
                }
            }
            byte b = dVar.ae;
            if (b != 0) {
                cn.jpush.android.helper.c.a(dVar.c, "", b, 1106, context);
            } else {
                cn.jpush.android.helper.c.a(dVar.c, 1106, context);
            }
        } catch (Throwable th) {
            Logger.e("MessageHelper", "sendBroadcastToApp error:" + th.getMessage());
        }
    }
}
