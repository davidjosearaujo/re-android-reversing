package cn.jpush.android.r;

import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.u.d;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class i {
    private static int a(d.a aVar) {
        int d = aVar.d();
        int e = aVar.e();
        if (-1 == e && -1 == d) {
            return 3;
        }
        if (-1 == e) {
            return Build.VERSION.SDK_INT >= d ? 1 : 2;
        }
        int i = Build.VERSION.SDK_INT;
        return (d > i || i > e) ? 2 : 1;
    }

    private static int a(String str, d.a aVar) {
        String c = aVar.c();
        if (TextUtils.isEmpty(c)) {
            return 3;
        }
        return Pattern.matches(c, str) ? 1 : 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00aa, code lost:
        if (r9.size() == 1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x010e, code lost:
        if (r4.size() > 0) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static cn.jpush.android.u.d.a a(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.r.i.a(java.lang.String):cn.jpush.android.u.d$a");
    }

    private static void a(int i, String str, List<d.a> list, List<d.a> list2, List<d.a> list3) {
        Logger.d("InAppMatchesConfigUtils", "matches type:" + i + ",value:" + str);
        for (int i2 = 0; i2 < list.size(); i2++) {
            d.a aVar = list.get(i2);
            if (!TextUtils.isEmpty(aVar.f())) {
                int i3 = 4;
                if (i == 1) {
                    i3 = a(str, aVar);
                } else if (i == 2) {
                    i3 = a(aVar);
                } else if (i == 3) {
                    i3 = b(str, aVar);
                }
                if (i3 == 1) {
                    list2.add(aVar);
                } else if (i3 == 3) {
                    list3.add(aVar);
                }
            }
        }
    }

    private static int b(String str, d.a aVar) {
        String b = aVar.b();
        if (TextUtils.isEmpty(b)) {
            return 3;
        }
        return Pattern.matches(b, str) ? 1 : 2;
    }

    private static cn.jpush.android.u.d b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            cn.jpush.android.u.d dVar = new cn.jpush.android.u.d();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                d.a aVar = new d.a();
                int optInt = jSONObject.optInt("version", -1);
                String optString = jSONObject.optString("manufacturer", null);
                String optString2 = jSONObject.optString(DeviceRequestsHelper.DEVICE_INFO_MODEL, null);
                String optString3 = jSONObject.optString("rom", null);
                int optInt2 = jSONObject.optInt("android_min", -1);
                int optInt3 = jSONObject.optInt("android_max", -1);
                String optString4 = jSONObject.optString("file_path", null);
                aVar.a(optInt);
                aVar.a(optString);
                aVar.b(optString2);
                aVar.c(optString3);
                aVar.b(optInt2);
                aVar.c(optInt3);
                aVar.d(optString4);
                arrayList.add(aVar);
            }
            dVar.a(arrayList);
            return dVar;
        } catch (Throwable unused) {
            return null;
        }
    }
}
