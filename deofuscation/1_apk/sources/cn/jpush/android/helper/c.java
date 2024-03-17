package cn.jpush.android.helper;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.JPushConstants;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    public static void a(Context context, int i, String str, JSONObject jSONObject) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        Logger.d("JPushReportHelper", "reportPushAnylysis code:" + i + ", msg:" + str + ", jsonExtra:" + jSONObject);
        Bundle bundle = new Bundle();
        bundle.putInt(JThirdPlatFormInterface.KEY_CODE, i);
        bundle.putString("msg", str);
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 87, null, bundle, jSONObject);
    }

    public static void a(Context context, String str, byte b, String str2) {
        if (!TextUtils.isEmpty(str)) {
            a(str, "", b, 1000, context, str2);
            return;
        }
        Logger.ee("JPushReportHelper", "The msgId is not valid - " + str);
    }

    public static void a(Context context, JSONObject jSONObject) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        Logger.d("JPushReportHelper", "action:reportOperation - content:" + jSONObject.toString());
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 14, null, null, jSONObject);
    }

    public static void a(String str, int i, Context context) {
        a(str, i, (String) null, context);
    }

    public static void a(String str, int i, String str2, Context context) {
        if (context == null) {
            Logger.d("JPushReportHelper", "context did not init, return");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("action:reportActionResult - messageId: " + str + ", code: " + i + "-" + f.a(i));
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append("， report content: " + str2);
        }
        String b = cn.jpush.android.d.d.b(str);
        if (!TextUtils.isEmpty(b)) {
            stringBuffer.append("， report jData:" + b);
        }
        Logger.d("JPushReportHelper", stringBuffer.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JThirdPlatFormInterface.KEY_MSG_ID, str);
            jSONObject.put("result", i);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("data", str2);
            }
            if (!TextUtils.isEmpty(b)) {
                jSONObject.put("_j_data_", b);
            }
            JSONObject fillBase = JCoreHelper.fillBase(context, jSONObject, "msg_status");
            if (fillBase != null) {
                fillBase.put("type", "msg_status");
                a(context, fillBase);
                return;
            }
            Logger.ww("JPushReportHelper", "report msg json is null, code: " + i);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, byte b, int i, Context context) {
        a(str, str2, b, i, context, null);
    }

    public static void a(String str, String str2, byte b, int i, Context context, String str3) {
        if (context == null) {
            Logger.d("JPushReportHelper", "context did not init, return");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("action:reportThirdSDKMsgActionResult - messageId: " + str + ", code: " + i);
        String b2 = cn.jpush.android.d.d.b(str);
        if (TextUtils.isEmpty(b2) && !TextUtils.isEmpty(str3)) {
            try {
                b2 = new JSONObject(str3).optString("_j_data_", "");
                Logger.d("JPushReportHelper", "get jdata from third push msg:" + b2);
            } catch (Throwable th) {
                Logger.d("JPushReportHelper", "get jdata from third push msg error:" + th.getMessage());
            }
        }
        if (!TextUtils.isEmpty(b2)) {
            stringBuffer.append("， report jData:" + b2);
        }
        Logger.d("JPushReportHelper", stringBuffer.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JThirdPlatFormInterface.KEY_MSG_ID, str);
            jSONObject.put("tmsg_id", str2);
            jSONObject.put("result", i);
            jSONObject.put(HianalyticsBaseData.SDK_TYPE, (int) b);
            if (!TextUtils.isEmpty(b2)) {
                jSONObject.put("_j_data_", b2);
            }
            JSONObject fillBase = JCoreHelper.fillBase(context, jSONObject, "third_msg_status");
            if (fillBase != null) {
                fillBase.put("type", "third_msg_status");
                a(context, fillBase);
                return;
            }
            Logger.ww("JPushReportHelper", "report third sdk msg json is null, code: " + i);
        } catch (Throwable unused) {
        }
    }
}
