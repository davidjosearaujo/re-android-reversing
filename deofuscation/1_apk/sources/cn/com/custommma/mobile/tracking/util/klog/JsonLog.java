package cn.com.custommma.mobile.tracking.util.klog;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class JsonLog {
    public static void printJson(String str, String str2, String str3) {
        String[] split;
        try {
            if (str2.startsWith("{")) {
                str2 = new JSONObject(str2).toString(4);
            } else if (str2.startsWith("[")) {
                str2 = new JSONArray(str2).toString(4);
            }
        } catch (JSONException unused) {
        }
        KLogUtil.printLine(str, true);
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        String str4 = KLog.LINE_SEPARATOR;
        sb.append(str4);
        sb.append(str2);
        for (String str5 : sb.toString().split(str4)) {
            Log.d(str, "║ " + str5);
        }
        KLogUtil.printLine(str, false);
    }
}
