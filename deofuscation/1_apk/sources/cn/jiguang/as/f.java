package cn.jiguang.as;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.ax.i;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.n.c;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.facebook.internal.security.CertificateUtil;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huawei.hms.support.feature.result.CommonConstant;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class f {
    private static final String d = cn.jiguang.r.a.b(new byte[]{62, 82, 38, 113, 19, 93, 73, 85, 84, 2, 23, 92, 58, 34, 40, 115, 19, 47, 78, 84, 32, 3, 19, 40, 57, 83, 32, 114, 23, 93, 49, 82});
    private static String e = "";
    private static String f = "/v3/report";
    public static JSONObject a = null;
    public static boolean b = true;
    private static String g = "";
    public static boolean c = true;

    public static int a(Context context, Set<String> set, JSONObject jSONObject, File file, ReportCallBack reportCallBack) {
        Object obj;
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    if (!cn.jiguang.f.a.d(context)) {
                        cn.jiguang.ar.c.g("ReportUtils", "no network, give up upload");
                        d.a(file);
                        if (reportCallBack != null) {
                            reportCallBack.onFinish(-2);
                        }
                        return -2;
                    }
                    Pair<byte[], Integer> a2 = a(jSONObject.toString(), true, 2);
                    if (a2 != null && (obj = a2.first) != null && ((byte[]) obj).length != 0) {
                        byte[] bArr = (byte[]) obj;
                        int intValue = ((Integer) a2.second).intValue();
                        cn.jiguang.ar.c.c("ReportUtils", "will upload length=" + bArr.length);
                        if (a(set, bArr.length)) {
                            i.a().a(context, i.a().a(context, jSONObject, bArr, intValue, file, set, reportCallBack));
                            return 1;
                        }
                        int a3 = a(context, bArr, intValue, set);
                        if (a3 == 0) {
                            cn.jiguang.ar.c.c("ReportUtils", "http upload success json=" + cn.jiguang.f.d.a(jSONObject));
                            cn.jiguang.f.c.a(file);
                        }
                        if (a3 != 1) {
                            d.a(file);
                            if (reportCallBack != null) {
                                reportCallBack.onFinish(a3);
                            }
                        }
                        return a3;
                    }
                    cn.jiguang.ar.c.g("ReportUtils", "package body failed, give up upload");
                    d.a(file);
                    if (reportCallBack != null) {
                        reportCallBack.onFinish(-1);
                    }
                    return -1;
                }
            } catch (Throwable th) {
                try {
                    cn.jiguang.ar.c.g("ReportUtils", "upload failed, error:" + th);
                    d.a(file);
                    if (reportCallBack != null) {
                        reportCallBack.onFinish(-1);
                    }
                    return -1;
                } catch (Throwable th2) {
                    if (0 != 1) {
                        d.a(file);
                        if (reportCallBack != null) {
                            reportCallBack.onFinish(0);
                        }
                    }
                    throw th2;
                }
            }
        }
        cn.jiguang.ar.c.g("ReportUtils", "upload content is empty, do nothing");
        d.a(file);
        if (reportCallBack != null) {
            reportCallBack.onFinish(-1);
        }
        return -1;
    }

    private static int a(Context context, byte[] bArr, int i, Set<String> set) {
        g a2;
        String str;
        LinkedHashSet<String> a3 = a(context, set);
        if (a3 == null || a3.isEmpty()) {
            cn.jiguang.ar.c.g("ReportUtils", "can't get url, give up upload");
            return -2;
        }
        String str2 = " type=" + set;
        for (String str3 : a3) {
            if (TextUtils.isEmpty(str3)) {
                cn.jiguang.ar.c.g("ReportUtils", "can't get url, give up upload");
            } else if (Build.VERSION.SDK_INT < 28 || str3.startsWith(c.a.d)) {
                if (!str3.endsWith(f)) {
                    str3 = str3 + f;
                }
                String str4 = str3;
                cn.jiguang.ar.c.c("ReportUtils", "upload" + str2 + " to url:" + str4);
                int a4 = b.a(context, str4, bArr, i, 3, 1).a();
                if (a4 == -3) {
                    d.a(context, cn.jiguang.d.a.e(context));
                    return -2;
                }
                if (a4 == -1) {
                    str = "upload" + str2 + " error:" + a2.b();
                } else if (a4 == 0) {
                    return 0;
                } else {
                    str = "upload" + str2 + " failed";
                }
                cn.jiguang.ar.c.c("ReportUtils", str);
            } else {
                cn.jiguang.ar.c.g("ReportUtils", "won't use http at device since 28");
            }
        }
        return -1;
    }

    private static Pair<byte[], Integer> a(String str, boolean z, int i) {
        String str2;
        try {
            byte[] bytes = str.getBytes("UTF-8");
            if (z) {
                try {
                    bytes = cn.jiguang.f.i.a(bytes);
                } catch (IOException unused) {
                    return null;
                }
            }
            int a2 = cn.jiguang.bf.d.a();
            String a3 = cn.jiguang.bf.d.a(a2);
            if (i == 1) {
                str2 = "0102030405060708";
            } else if (i != 2) {
                return null;
            } else {
                str2 = "iop203040506aPk!";
            }
            return new Pair<>(cn.jiguang.bf.d.a(bytes, a3, str2, true), Integer.valueOf(a2));
        } catch (UnsupportedEncodingException | Exception unused2) {
            return null;
        }
    }

    private static String a() {
        return (!JCoreManager.isTestEnv() || TextUtils.isEmpty(g)) ? "stats.jpush.cn" : g;
    }

    public static String a(Context context, String str, String str2) {
        return a(context, str, str2, false);
    }

    public static String a(Context context, String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.c())).longValue();
        if (longValue == 0) {
            cn.jiguang.ar.c.c("ReportUtils", " miss uid,generate report token failed");
            return null;
        }
        String e2 = z ? d : cn.jiguang.f.g.e((String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.e()));
        String k = cn.jiguang.f.g.k(longValue + e2 + str);
        if (cn.jiguang.f.g.a(k)) {
            return null;
        }
        try {
            return Base64.encodeToString((longValue + CertificateUtil.DELIMITER + k + CertificateUtil.DELIMITER + str2).getBytes(), 10);
        } catch (Exception unused) {
            cn.jiguang.ar.c.i("getBasicAuthorization", "basic authorization encode failed");
            return null;
        }
    }

    public static String a(String str) {
        try {
            return cn.jiguang.bf.d.b(str, cn.jiguang.bf.a.a(), cn.jiguang.bf.a.a);
        } catch (Throwable unused) {
            cn.jiguang.ar.c.i("getBasicAuthorization", "basic authorization encode failed");
            return null;
        }
    }

    private static ArrayList<JSONArray> a(JSONArray jSONArray, int i, int i2) {
        ArrayList<JSONArray> arrayList = new ArrayList<>();
        if (jSONArray != null && jSONArray.length() != 0) {
            if (jSONArray.length() == 1) {
                arrayList.add(jSONArray);
                return arrayList;
            }
            JSONArray jSONArray2 = new JSONArray();
            int i3 = 0;
            int i4 = 0;
            for (int length = jSONArray.length() - 1; length >= 0; length--) {
                JSONObject optJSONObject = jSONArray.optJSONObject(length);
                try {
                    int b2 = cn.jiguang.f.d.b(optJSONObject);
                    if (b2 != 0) {
                        int i5 = i3 + b2;
                        if (i5 > i2) {
                            break;
                        }
                        int i6 = i4 + b2;
                        if (i6 > i) {
                            if (jSONArray2.length() > 0) {
                                arrayList.add(jSONArray2);
                            }
                            JSONArray jSONArray3 = new JSONArray();
                            try {
                                jSONArray3.put(optJSONObject);
                                jSONArray2 = jSONArray3;
                            } catch (Throwable th) {
                                th = th;
                                jSONArray2 = jSONArray3;
                                cn.jiguang.ar.c.g("ReportUtils", "partition exception:" + th);
                            }
                        } else {
                            jSONArray2.put(optJSONObject);
                            b2 = i6;
                        }
                        i4 = b2;
                        i3 = i5;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (jSONArray2.length() > 0) {
                arrayList.add(jSONArray2);
            }
        }
        return arrayList;
    }

    public static LinkedHashSet<String> a(Context context, Set<String> set) {
        String[] split;
        StringBuilder sb;
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        String a2 = a();
        if (!"stats.jpush.cn".equals(a2)) {
            linkedHashSet.add(a2);
            return linkedHashSet;
        }
        Set<String> b2 = a.a().b(context).b(set);
        if (b2 != null) {
            for (String str : b2) {
                if (!TextUtils.isEmpty(str)) {
                    linkedHashSet.add(str);
                }
            }
        }
        String str2 = c.a.d;
        if (!TextUtils.isEmpty(a2)) {
            linkedHashSet.add(str2 + a2);
        }
        String str3 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.a(true));
        if (!TextUtils.isEmpty(str3)) {
            for (String str4 : str3.split(",")) {
                if (!cn.jiguang.f.g.f(str4)) {
                    if (!cn.jiguang.f.g.g(str4)) {
                        sb = new StringBuilder();
                    } else if (!c) {
                        sb = new StringBuilder();
                    }
                    sb.append(str2);
                    sb.append(str4);
                    linkedHashSet.add(sb.toString());
                } else if (c) {
                    sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(str4);
                    linkedHashSet.add(sb.toString());
                }
            }
        }
        cn.jiguang.ar.c.c("ReportUtils", "types=" + set + " find urls=" + linkedHashSet);
        return linkedHashSet;
    }

    public static Set<String> a(JSONObject jSONObject) {
        return jSONObject == null ? new HashSet() : c(jSONObject.optJSONArray("content"));
    }

    public static JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, "a");
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.c())).longValue();
            if (longValue == 0) {
                cn.jiguang.ar.c.g("ReportUtils", "miss uid when wrap container info");
                return null;
            }
            jSONObject.put(CommonConstant.KEY_UID, longValue);
            String e2 = cn.jiguang.d.a.e(context);
            if (cn.jiguang.f.g.a(e2)) {
                cn.jiguang.ar.c.i("ReportUtils", "miss app_key when wrap container info");
                return null;
            }
            jSONObject.put(com.alipay.sdk.cons.b.h, e2);
            ActionManager.getInstance().wrapSdkVersionInfo(jSONObject);
            jSONObject.put("core_sdk_ver", cn.jiguang.a.a.b);
            String g2 = cn.jiguang.d.a.g(context);
            if (cn.jiguang.f.g.a(g2)) {
                cn.jiguang.ar.c.h("ReportUtils", "miss channel when wrap container info,but continue report...");
            } else {
                jSONObject.put("channel", g2);
            }
            Pair<String, Integer> c2 = cn.jiguang.c.b.c(context);
            if (c2 == null || cn.jiguang.f.g.a((String) c2.first)) {
                cn.jiguang.ar.c.h("ReportUtils", "miss app version when wrap container info,but continue report...");
            } else {
                jSONObject.put("app_version", c2.first);
            }
            return jSONObject;
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("ReportUtils", "wrapContainerInfo exception:" + th);
            return null;
        }
    }

    private static JSONObject a(JSONArray jSONArray, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("content", jSONArray);
        } catch (JSONException unused) {
        }
        cn.jiguang.f.d.a(jSONObject2, jSONObject);
        return jSONObject2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x007c, code lost:
        if (r10 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0080, code lost:
        if (r10 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0082, code lost:
        r10.onFinish(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0085, code lost:
        cn.jiguang.as.d.a(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0088, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r3, int r4, org.json.JSONObject r5, byte[] r6, int r7, java.io.File r8, java.util.Set<java.lang.String> r9, cn.jiguang.api.ReportCallBack r10) {
        /*
            java.lang.String r0 = "ReportUtils"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7f
            r1.<init>()     // Catch: java.lang.Throwable -> L7f
            java.lang.String r2 = "onTcpReportResult, types="
            r1.append(r2)     // Catch: java.lang.Throwable -> L7f
            r1.append(r9)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r2 = " code="
            r1.append(r2)     // Catch: java.lang.Throwable -> L7f
            r1.append(r4)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L7f
            cn.jiguang.ar.c.c(r0, r1)     // Catch: java.lang.Throwable -> L7f
            r1 = -3
            if (r4 == r1) goto L6f
            if (r4 == 0) goto L4d
            int r4 = a(r3, r6, r7, r9)     // Catch: java.lang.Throwable -> L7f
            if (r4 != 0) goto L7c
            boolean r3 = cn.jiguang.internal.JConstants.DEBUG_MODE     // Catch: java.lang.Throwable -> L7f
            if (r3 == 0) goto L49
            boolean r3 = cn.jiguang.internal.JConstants.INTERNAL_USE     // Catch: java.lang.Throwable -> L7f
            if (r3 == 0) goto L49
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7f
            r3.<init>()     // Catch: java.lang.Throwable -> L7f
            java.lang.String r6 = "http upload success, json="
            r3.append(r6)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r5 = cn.jiguang.f.d.a(r5)     // Catch: java.lang.Throwable -> L7f
            r3.append(r5)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L7f
            cn.jiguang.ar.c.c(r0, r3)     // Catch: java.lang.Throwable -> L7f
        L49:
            cn.jiguang.f.c.a(r8)     // Catch: java.lang.Throwable -> L7f
            goto L7c
        L4d:
            boolean r3 = cn.jiguang.internal.JConstants.DEBUG_MODE     // Catch: java.lang.Throwable -> L7f
            if (r3 == 0) goto L49
            boolean r3 = cn.jiguang.internal.JConstants.INTERNAL_USE     // Catch: java.lang.Throwable -> L7f
            if (r3 == 0) goto L49
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7f
            r3.<init>()     // Catch: java.lang.Throwable -> L7f
            java.lang.String r6 = "tcp upload success, json="
            r3.append(r6)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r5 = cn.jiguang.f.d.a(r5)     // Catch: java.lang.Throwable -> L7f
            r3.append(r5)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L7f
            cn.jiguang.ar.c.c(r0, r3)     // Catch: java.lang.Throwable -> L7f
            goto L49
        L6f:
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L7f
            r6 = 0
            java.lang.String r7 = cn.jiguang.d.a.e(r3)     // Catch: java.lang.Throwable -> L7f
            r5[r6] = r7     // Catch: java.lang.Throwable -> L7f
            cn.jiguang.as.d.a(r3, r5)     // Catch: java.lang.Throwable -> L7f
        L7c:
            if (r10 == 0) goto L85
            goto L82
        L7f:
            if (r10 == 0) goto L85
        L82:
            r10.onFinish(r4)
        L85:
            cn.jiguang.as.d.a(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.as.f.a(android.content.Context, int, org.json.JSONObject, byte[], int, java.io.File, java.util.Set, cn.jiguang.api.ReportCallBack):void");
    }

    public static void a(final Context context, final Object obj) {
        try {
            if (b(obj)) {
                cn.jiguang.be.d.a("UPLOAD_REPORT", new cn.jiguang.be.b("ReportUtils#report") { // from class: cn.jiguang.as.f.1
                    @Override // cn.jiguang.be.b
                    public void a() {
                        try {
                            JSONArray c2 = f.c(obj);
                            if (c2 != null) {
                                f.b(context, c2, f.c(c2));
                            } else {
                                cn.jiguang.ar.c.c("ReportUtils", "data" + obj + " is empty");
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
            } else {
                cn.jiguang.ar.c.c("ReportUtils", "data is invalid or empty");
            }
            d.b(context);
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("ReportUtils", "report e:" + th);
        }
    }

    public static void a(Context context, String str, Object obj) {
        try {
            cn.jiguang.ar.c.c("ReportUtils", "going to report data at push service");
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString(HianalyticsBaseData.SDK_TYPE, str);
            }
            if (b(obj)) {
                bundle.putString("report_data", obj.toString());
            }
            cn.jiguang.a.a.a(context, "a1", bundle);
        } catch (Throwable th) {
            try {
                cn.jiguang.ar.c.c("ReportUtils", "reportAtPushService", th);
            } catch (Throwable th2) {
                cn.jiguang.ar.c.c("ReportUtils", "reportAtPushService", th2);
            }
        }
    }

    public static void a(Context context, JSONObject jSONObject, ReportCallBack reportCallBack) {
        b(context, jSONObject, reportCallBack);
    }

    public static boolean a(Context context, String str, JSONObject jSONObject) {
        try {
            if (cn.jiguang.f.g.a(str)) {
                cn.jiguang.ar.c.c("ReportUtils", "file_name is null , give up save ");
                return false;
            } else if (context != null) {
                return cn.jiguang.f.c.b(cn.jiguang.f.c.a(context, str), jSONObject != null ? jSONObject.toString() : "");
            } else {
                cn.jiguang.ar.c.c("ReportUtils", "context is null , give up save " + str);
                return false;
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.c("ReportUtils", "writeLogFile e:" + th);
            return false;
        }
    }

    private static boolean a(Set<String> set, int i) {
        return b && i < 30680 && set != null && !set.contains("crash_log");
    }

    public static String b(String str) {
        try {
            return cn.jiguang.bf.d.b(str, cn.jiguang.bf.a.b(), cn.jiguang.bf.a.b);
        } catch (Throwable unused) {
            cn.jiguang.ar.c.i("getBasicAuthorization", "basic authorization encode failed");
            return null;
        }
    }

    private static String b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("type");
        }
        return null;
    }

    private static JSONArray b(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && optJSONObject.length() > 0) {
                jSONArray2.put(optJSONObject);
            }
        }
        return jSONArray2;
    }

    public static void b(Context context, JSONArray jSONArray, Set<String> set) {
        try {
            String a2 = a.a().a(context).a(set);
            JSONObject a3 = a(context);
            boolean z = a3 != null;
            StringBuilder sb = new StringBuilder();
            String str = File.separator;
            sb.append(str);
            sb.append(a2);
            sb.append(str);
            sb.append(z ? "tmp" : "nowrap");
            String sb2 = sb.toString();
            Iterator<JSONArray> it = a(jSONArray, 40960, 204800).iterator();
            while (it.hasNext()) {
                JSONObject a4 = a(it.next(), a3);
                File a5 = d.a(context, sb2, a4, z);
                cn.jiguang.ar.c.c("ReportUtils", "save report types=" + set + " at " + sb2 + File.separator + a5.getName());
                if (z) {
                    a(context, set, a4, a5, null);
                }
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.i("ReportUtils", "report exception:" + th);
        }
    }

    private static void b(Context context, JSONObject jSONObject, ReportCallBack reportCallBack) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() > 0) {
                    JSONObject a2 = a(context);
                    if (a2 == null) {
                        cn.jiguang.ar.c.i("ReportUtils", "wrap data failed");
                        if (reportCallBack != null) {
                            reportCallBack.onFinish(-1);
                        }
                    } else {
                        String b2 = b(jSONObject);
                        JSONObject a3 = a(new JSONArray().put(jSONObject), a2);
                        HashSet hashSet = new HashSet();
                        hashSet.add(b2);
                        cn.jiguang.ar.c.c("ReportUtils", "reportWithoutStore type=" + b2);
                        a(context, hashSet, a3, null, reportCallBack);
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.ar.c.i("ReportUtils", "reportWithoutStore exception:" + th);
            }
        }
        d.b(context);
    }

    private static boolean b(Object obj) {
        return obj instanceof String ? ((String) obj).length() > 2 : obj instanceof JSONObject ? ((JSONObject) obj).length() > 0 : (obj instanceof JSONArray) && b((JSONArray) obj).length() > 0;
    }

    public static Set<String> c(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String b2 = b(jSONArray.optJSONObject(i));
                if (b2 == null) {
                    b2 = "";
                }
                hashSet.add(b2);
            }
        }
        return hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x003d A[Catch: all -> 0x0044, TRY_LEAVE, TryCatch #0 {all -> 0x0044, blocks: (B:33:0x0001, B:46:0x0037, B:48:0x003d, B:39:0x0020, B:41:0x0024, B:42:0x002e, B:44:0x0032), top: B:55:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONArray c(java.lang.Object r3) {
        /*
            r0 = 0
            boolean r1 = r3 instanceof java.lang.String     // Catch: java.lang.Throwable -> L44
            if (r1 == 0) goto L20
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> Le
            r2 = r3
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> Le
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Le
            goto L37
        Le:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L36
            r1.<init>()     // Catch: java.lang.Throwable -> L36
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L36
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L36
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L36
            org.json.JSONArray r3 = r1.put(r2)     // Catch: java.lang.Throwable -> L36
            r1 = r3
            goto L37
        L20:
            boolean r1 = r3 instanceof org.json.JSONObject     // Catch: java.lang.Throwable -> L44
            if (r1 == 0) goto L2e
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L44
            r1.<init>()     // Catch: java.lang.Throwable -> L44
            org.json.JSONArray r1 = r1.put(r3)     // Catch: java.lang.Throwable -> L44
            goto L37
        L2e:
            boolean r1 = r3 instanceof org.json.JSONArray     // Catch: java.lang.Throwable -> L44
            if (r1 == 0) goto L36
            r1 = r3
            org.json.JSONArray r1 = (org.json.JSONArray) r1     // Catch: java.lang.Throwable -> L44
            goto L37
        L36:
            r1 = r0
        L37:
            org.json.JSONArray r3 = b(r1)     // Catch: java.lang.Throwable -> L44
            if (r3 == 0) goto L5b
            int r1 = r3.length()     // Catch: java.lang.Throwable -> L44
            if (r1 <= 0) goto L5b
            return r3
        L44:
            r3 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "adapt JSONArray e:"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            java.lang.String r1 = "ReportUtils"
            cn.jiguang.ar.c.g(r1, r3)
        L5b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.as.f.c(java.lang.Object):org.json.JSONArray");
    }
}
