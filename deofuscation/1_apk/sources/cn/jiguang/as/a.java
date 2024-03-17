package cn.jiguang.as;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.analytics.page.PushSA;
import cn.jiguang.internal.JConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    private static volatile a c;
    private static final Object d = new Object();
    private long a;
    private Map<String, Set<String>> b = new HashMap();

    private a() {
    }

    public static a a() {
        if (c == null) {
            synchronized (d) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray optJSONArray = jSONObject.optJSONArray(next);
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            linkedHashSet.add(optJSONArray.getString(i));
                        }
                    }
                    hashMap.put(next, linkedHashSet);
                }
                if (hashMap.isEmpty()) {
                    return;
                }
                this.b = hashMap;
            } catch (JSONException unused) {
            }
        }
    }

    public a a(Context context) {
        try {
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.u())).longValue();
            long j = this.a;
            if (j == 0 || j != longValue) {
                this.a = longValue;
                String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.s());
                if (!TextUtils.isEmpty(str)) {
                    a(new JSONObject(str));
                }
            }
        } catch (Throwable unused) {
        }
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "normal";
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1245458676:
                if (str.equals(PushSA.REPORT_ACTIVE_LAUNCH)) {
                    c2 = 0;
                    break;
                }
                break;
            case -1177318867:
                if (str.equals("account")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1091230153:
                if (str.equals("android_awake_target2")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1051289244:
                if (str.equals("active_user")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals("normal")) {
                    c2 = 4;
                    break;
                }
                break;
            case -820729752:
                if (str.equals(PushSA.REPORT_ACTIVE_TERMINATE)) {
                    c2 = 5;
                    break;
                }
                break;
            case -693746763:
                if (str.equals("android_awake")) {
                    c2 = 6;
                    break;
                }
                break;
            case -295020531:
                if (str.equals("android_notification_state")) {
                    c2 = 7;
                    break;
                }
                break;
            case -31313123:
                if (str.equals("android_awake2")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 96275:
                if (str.equals("aa3")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 2986591:
                if (str.equals("aat3")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 93223301:
                if (str.equals("awake")) {
                    c2 = 11;
                    break;
                }
                break;
            case 907150721:
                if (str.equals("detach_account")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 1350272347:
                if (str.equals("android_awake_target")) {
                    c2 = '\r';
                    break;
                }
                break;
            case 1973539834:
                if (str.equals("identify_account")) {
                    c2 = 14;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 3:
            case 5:
                return "active_user";
            case 1:
            case '\f':
            case 14:
                return "account";
            case 2:
            case 6:
            case '\b':
            case '\t':
            case '\n':
            case 11:
            case '\r':
                return "awake";
            case 4:
                break;
            case 7:
                return "android_notification_state";
            default:
                if (this.b.containsKey(str)) {
                    return str;
                }
                break;
        }
        return "normal";
    }

    public String a(Set<String> set) {
        if (set != null) {
            try {
                if (!set.isEmpty()) {
                    String str = null;
                    for (String str2 : set) {
                        String a = a(str2);
                        if (str == null) {
                            str = a;
                        } else if (!str.equals(a)) {
                            cn.jiguang.ar.c.g("AddressGroupManager", "Report JSONArray belong more than one space, using normal-space");
                            return "normal";
                        }
                    }
                    return str;
                }
            } catch (Throwable unused) {
            }
        }
        return "normal";
    }

    public void a(Context context, JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("sis_ips");
        long j = JConstants.HOUR;
        try {
            long j2 = jSONObject.getLong(RemoteMessageConst.TTL);
            if (j2 >= 0) {
                j = j2;
            }
        } catch (JSONException unused) {
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("ips");
        cn.jiguang.g.a[] aVarArr = new cn.jiguang.g.a[4];
        aVarArr[0] = cn.jiguang.g.a.t().a((cn.jiguang.g.a<String>) optJSONArray.toString());
        aVarArr[1] = cn.jiguang.g.a.v().a((cn.jiguang.g.a<Long>) Long.valueOf(j * 1000));
        aVarArr[2] = cn.jiguang.g.a.u().a((cn.jiguang.g.a<Long>) Long.valueOf(System.currentTimeMillis()));
        aVarArr[3] = cn.jiguang.g.a.s().a((cn.jiguang.g.a<String>) (optJSONObject != null ? optJSONObject.toString() : ""));
        cn.jiguang.g.b.a(context, aVarArr);
        a(optJSONObject);
    }

    public a b(Context context) {
        boolean z;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            a(context);
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.v())).longValue();
            if (longValue < 0) {
                longValue = JConstants.HOUR;
            } else if (longValue < JConstants.MIN) {
                longValue = 60000;
            }
            if (longValue > 604800000) {
                longValue = 604800000;
            }
            SimpleDateFormat a = cn.jiguang.f.b.a("yyyy-MM-dd HH:mm:ss");
            cn.jiguang.ar.c.c("AddressGroupManager", "lastUpdateTime=" + a.format(new Date(this.a)) + " now=" + a.format(new Date(currentTimeMillis)) + " expire=" + (longValue / 1000));
            long j = this.a;
            if (j == 0 || j + longValue < currentTimeMillis) {
                cn.jiguang.ar.c.c("AddressGroupManager", "cache invalid, fetch new urls");
                Map<String, Set<String>> map = this.b;
                if (map != null && !map.isEmpty()) {
                    z = false;
                    e.a(context, z);
                }
                z = true;
                e.a(context, z);
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("AddressGroupManager", "refresh e" + th);
        }
        return this;
    }

    public Set<String> b(Set<String> set) {
        if (set != null && !set.isEmpty()) {
            Set<String> set2 = null;
            for (String str : set) {
                Set<String> set3 = this.b.get(a(str));
                if (set3 != null && !set3.isEmpty()) {
                    if (set2 == null) {
                        set2 = set3;
                    } else {
                        set2.retainAll(set3);
                    }
                    if (set2.isEmpty()) {
                    }
                }
            }
            return set2;
        }
        return this.b.get("normal");
    }
}
