package cn.jiguang.e;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import cn.jiguang.ar.c;
import cn.jiguang.ax.e;
import cn.jiguang.ax.h;
import cn.jiguang.ax.j;
import cn.jiguang.be.b;
import cn.jiguang.bf.d;
import cn.jiguang.f.g;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.service.DownloadProvider;
import com.alibaba.fastjson.asm.Label;
import com.alipay.sdk.util.f;
import com.facebook.GraphResponse;
import com.facebook.appevents.UserDataStore;
import java.io.File;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a extends b {
    private static final String b;
    private static final Object f;
    private static Boolean g;
    private static Boolean i;
    private static a k;
    public Context a;
    private int c;
    private long[] d;
    private String e;
    private volatile boolean j;
    private boolean l;

    /* renamed from: cn.jiguang.e.a$a */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class C0007a {
        private int b = -1;
        private String c;
        private long d;
        private String e;
        private String f;
        private int g;
        private long h;
        private String i;

        public C0007a() {
            a.this = r1;
        }

        public String toString() {
            return "ShareProcessBean{idc=" + this.b + ", uuid='" + this.c + "', uid=" + this.d + ", pkgname='" + this.e + "', appkey='" + this.f + "', sdkVersion=" + this.g + ", uuidCreateTime=" + this.h + ", deviceId=" + this.i + '}';
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(".jpush");
        String str = File.separator;
        sb.append(str);
        sb.append(".shareinfo");
        sb.append(str);
        b = sb.toString();
        f = new Object();
    }

    private a() {
        cn.jiguang.at.b.a("share_process_executor");
        this.h = "ShareProcessManager";
    }

    private static ActivityInfo a(String str, Context context) {
        String str2;
        try {
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.DownloadActivity");
            intent.addCategory(str);
            intent.setPackage(str);
            ActivityInfo activityInfo = context.getPackageManager().resolveActivity(intent, 0).activityInfo;
            if ((activityInfo instanceof ActivityInfo) && ((ComponentInfo) activityInfo).exported && ((ComponentInfo) activityInfo).enabled) {
                if (!"jpush.custom".equals(activityInfo.taskAffinity)) {
                    str2 = "download activity need config taskAffinity is jpush.custom";
                } else if (activityInfo.theme == 16973840) {
                    return activityInfo;
                } else {
                    str2 = "download activity theme must config as @android:style/Theme.Translucent.NoTitleBar";
                }
                c.c("ShareProcessManager", str2);
            }
        } catch (Throwable th) {
            c.g("ShareProcessManager", "check downloadActivity error:" + th.getMessage());
        }
        c.c("ShareProcessManager", "DownloadActivity is invalid in " + str);
        return null;
    }

    private C0007a a(String str) {
        Throwable th;
        C0007a c0007a;
        try {
        } catch (Throwable th2) {
            th = th2;
            c0007a = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        c0007a = new C0007a();
        try {
            long optLong = jSONObject.optLong("u");
            String optString = jSONObject.optString("ak");
            String optString2 = jSONObject.optString("pn");
            String optString3 = jSONObject.optString("ud");
            int optInt = jSONObject.optInt("idc", -1);
            int optInt2 = jSONObject.optInt(com.alipay.sdk.sys.a.q);
            long optLong2 = jSONObject.optLong("uct", -1L);
            String optString4 = jSONObject.optString("di");
            c0007a.d = optLong;
            c0007a.c = optString3;
            c0007a.f = optString;
            c0007a.b = optInt;
            c0007a.e = optString2;
            c0007a.g = optInt2;
            c0007a.h = optLong2;
            c0007a.i = optString4;
        } catch (Throwable th3) {
            th = th3;
            c.g("ShareProcessManager", "parse json to shareBean failed:" + th.getMessage());
            return c0007a;
        }
        return c0007a;
    }

    public static String a(Context context, Uri uri) {
        try {
        } catch (Throwable th) {
            c.g("ShareProcessManager", "parseUriFromProvider failed:" + th.getMessage());
        }
        if (uri == null) {
            return cn.jiguang.a.a.b;
        }
        String queryParameter = uri.getQueryParameter("kpgt");
        if (TextUtils.isEmpty(queryParameter)) {
            return cn.jiguang.a.a.b;
        }
        String b2 = d.b(queryParameter);
        if (TextUtils.isEmpty(b2)) {
            return "-6";
        }
        JSONObject jSONObject = new JSONObject(b2);
        String optString = jSONObject.optString("kta");
        c.c("ShareProcessManager", "action:" + optString);
        if (!TextUtils.isEmpty(optString)) {
            if (optString.equals("asai")) {
                return e(context);
            }
            if (optString.equals("asm")) {
                c.c("ShareProcessManager", "recv msg:" + jSONObject.toString());
                if (g(context) && ((Integer) cn.jiguang.g.b.a(context, cn.jiguang.g.a.k())).intValue() != 1) {
                    Bundle bundle = new Bundle();
                    bundle.putString("data", jSONObject.toString());
                    cn.jiguang.c.b.a(context, JConstants.SDK_TYPE, "asm", bundle);
                    return "0";
                }
                c.c("ShareProcessManager", "share process is closed!");
                return "-4";
            } else if (optString.equals("asmr")) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("data", jSONObject.toString());
                cn.jiguang.c.b.a(context, JConstants.SDK_TYPE, "asmr", bundle2);
            }
        }
        return cn.jiguang.a.a.b;
    }

    private String a(Context context, String str, String str2, HashMap<String, String> hashMap) {
        try {
            ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
            String str3 = str + ".DownloadProvider";
            if (!str3.startsWith("content://")) {
                str3 = "content://" + str3;
            }
            Uri parse = Uri.parse(str3);
            JSONObject jSONObject = new JSONObject();
            Uri.Builder buildUpon = parse.buildUpon();
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("kta", str2);
            }
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
            buildUpon.appendQueryParameter("kpgt", d.a(jSONObject.toString()));
            return contentResolver.getType(buildUpon.build());
        } catch (Throwable th) {
            c.g("ShareProcessManager", "callUriToDownloadProvider error:" + th.getMessage());
            return null;
        }
    }

    private static JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Throwable th) {
                c.g("ShareProcessManager", "mapToJSONObject error:" + th.getMessage());
            }
        }
        return jSONObject;
    }

    public static void a(Context context, String str) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            c.g("ShareProcessManager", "deletFileIfUninstall failed ,context is null or pkgname is empty");
            return;
        }
        try {
            if (cn.jiguang.f.a.c(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                File b2 = b(str);
                if (b2.exists()) {
                    b2.delete();
                    return;
                }
                str2 = "not found file in sdcard,filepath:" + b2.getAbsolutePath();
            } else {
                str2 = "no write sdcard permission when deletFileIfUninstall";
            }
            c.c("ShareProcessManager", str2);
        } catch (Throwable unused) {
        }
    }

    private boolean a(String str, ComponentInfo componentInfo) {
        if (componentInfo == null || !(componentInfo instanceof ProviderInfo)) {
            return false;
        }
        ProviderInfo providerInfo = (ProviderInfo) componentInfo;
        c.a("ShareProcessManager", "scan exported:" + providerInfo.exported + ",enable:" + providerInfo.enabled + ",authority:" + providerInfo.authority + ",process:" + providerInfo.processName);
        if (providerInfo.exported && providerInfo.enabled && !TextUtils.isEmpty(providerInfo.authority)) {
            if (TextUtils.equals(str + ".DownloadProvider", providerInfo.authority)) {
                return true;
            }
        }
        c.c("ShareProcessManager", "downloadprovider config error,exported:" + providerInfo.exported + ",enable:" + providerInfo.enabled + ",authority:" + providerInfo.authority + ",process:" + providerInfo.processName);
        return false;
    }

    private C0007a b(Context context, String str) {
        C0007a c;
        try {
            String a = a(context, str, "asai", null);
            c.c("ShareProcessManager", "get type from:" + str + ",info:" + a);
            if (a != null) {
                if (TextUtils.isEmpty(a) || a.length() <= 10) {
                    c.c("ShareProcessManager", "is not shareprocessbean info");
                    return null;
                }
                String b2 = d.b(a);
                if (TextUtils.isEmpty(b2)) {
                    c.c("ShareProcessManager", "decrypt error");
                    return null;
                }
                c.c("ShareProcessManager", "parse success:" + b2);
                c = a(b2);
            } else if (!f(context)) {
                return null;
            } else {
                c = c(context, str);
            }
            return c;
        } catch (Throwable th) {
            c.h("ShareProcessManager", "scanShareProcessBean error:" + th.getMessage());
            return null;
        }
    }

    public static a b() {
        if (k == null) {
            synchronized (f) {
                if (k == null) {
                    k = new a();
                }
            }
        }
        return k;
    }

    private static File b(String str) {
        String d = g.d(str);
        if (!TextUtils.isEmpty(d)) {
            str = d;
        }
        j.l.c.e0.a.a.b.a();
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        return new File(externalStorageDirectory, b + str);
    }

    private C0007a c(Context context, String str) {
        String str2;
        StringBuilder sb;
        String str3;
        if (JConstants.isAndroidQ(context, false, "do not get share info from SD")) {
            return null;
        }
        if (cn.jiguang.f.a.c(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            File b2 = b(str);
            String d = cn.jiguang.f.c.d(b2);
            if (TextUtils.isEmpty(d)) {
                c.c("ShareProcessManager", "read info is empty from :" + b2.getAbsolutePath());
                return null;
            }
            C0007a a = a(d.b(d));
            if (a == null) {
                sb = new StringBuilder();
                str3 = "parse share process bean with target app:";
            } else if (!cn.jiguang.f.a.h(context, a.e)) {
                c.c("ShareProcessManager", "found target app is uninsatll when scan sdcard,pkgname:" + a.e);
                a(context, a.e);
                return null;
            } else if (a(a.e, context) != null) {
                c.c("ShareProcessManager", "get share bean info from sdcard:" + a.toString());
                return a;
            } else {
                sb = new StringBuilder();
                str3 = "not config DownloadActivity in target app:";
            }
            sb.append(str3);
            sb.append(str);
            str2 = sb.toString();
        } else {
            str2 = "no read sdcard permission";
        }
        c.c("ShareProcessManager", str2);
        return null;
    }

    private static String c() {
        return "cn.jpush.android.intent.DaemonService";
    }

    private Set<C0007a> c(Context context) {
        int i2;
        List<ResolveInfo> queryIntentServices;
        HashSet hashSet = new HashSet();
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setAction(c());
            queryIntentServices = packageManager.queryIntentServices(intent, 0);
        } catch (Throwable th) {
            c.g("ShareProcessManager", "scanOtherApp error:" + th.getMessage());
        }
        if (queryIntentServices != null && queryIntentServices.size() != 0) {
            List<String> arrayList = new ArrayList();
            for (i2 = 0; i2 < queryIntentServices.size(); i2++) {
                ServiceInfo serviceInfo = queryIntentServices.get(i2).serviceInfo;
                String str = serviceInfo.name;
                String str2 = serviceInfo.packageName;
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !context.getPackageName().equals(str2) && a(str2, cn.jiguang.f.a.b(context, str2, DownloadProvider.class))) {
                    arrayList.add(str2);
                }
            }
            c.c("ShareProcessManager", "valid size:" + arrayList.size());
            Object a = e.a(context, "filter_pkg_list", arrayList);
            if (a instanceof List) {
                arrayList = (List) a;
            }
            c.c("ShareProcessManager", "valid end size:" + arrayList.size());
            for (String str3 : arrayList) {
                C0007a b2 = b(context, str3);
                c.c("ShareProcessManager", "scan share bean from:" + str3);
                if (b2 != null) {
                    hashSet.add(b2);
                }
            }
            c.c("ShareProcessManager", "end share bean list size:" + hashSet.size());
            return hashSet;
        }
        c.c("ShareProcessManager", "query service size is empty");
        return hashSet;
    }

    private void d(Context context) {
        try {
            if (JConstants.isAndroidQ(context, false, "do not save ShareInfo to SD")) {
                return;
            }
            if (cn.jiguang.f.a.c(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                File b2 = b(context.getPackageName());
                if (f(context)) {
                    String e = e(context);
                    c.c("ShareProcessManager", "save info to sdcard:" + b2.getAbsolutePath());
                    if (!TextUtils.isEmpty(e) && e.length() > 10) {
                        cn.jiguang.f.c.a(b2);
                        cn.jiguang.f.c.b(b2, e);
                    }
                } else {
                    cn.jiguang.f.c.a(b2);
                }
            } else {
                c.c("ShareProcessManager", "no write sdcard permission");
            }
        } catch (Throwable th) {
            c.g("ShareProcessManager", "saveShareInfoToSdCard failed:" + th.getMessage());
        }
    }

    private static String e(Context context) {
        long j;
        String str;
        if (context == null) {
            return "-1";
        }
        if (!g(context) || cn.jiguang.d.a.m(context) != 0) {
            c.c("ShareProcessManager", "[getTypeJson]share process is close by action");
            return "-4";
        } else if (!cn.jiguang.aq.c.a().a(context)) {
            c.c("ShareProcessManager", "getAttachJson,is not support jpush or jmessage ");
            return "-7";
        } else {
            int k2 = cn.jiguang.d.a.k(context);
            if (k2 < 0) {
                c.c("ShareProcessManager", "[getTypeJson]idc<0,need login to get it");
                return "-3";
            }
            long f2 = cn.jiguang.d.a.f(context);
            if (f2 <= 0) {
                c.c("ShareProcessManager", "[getTypeJson]uid<=0,need login to get it");
                return "-2";
            }
            Map map = (Map) cn.jiguang.d.a.j(context);
            if (map != null) {
                str = (String) map.get("uuid");
                j = ((Long) map.get(UserDataStore.CITY)).longValue();
            } else {
                j = -1;
                str = "";
            }
            String e = cn.jiguang.d.a.e(context);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("u", f2);
                jSONObject.put("p", cn.jiguang.d.a.i(context));
                jSONObject.put("ud", str);
                jSONObject.put("ak", e);
                jSONObject.put("idc", k2);
                jSONObject.put("pn", context.getPackageName());
                jSONObject.put(com.alipay.sdk.sys.a.q, cn.jiguang.a.a.c);
                jSONObject.put("uct", j);
                jSONObject.put("di", cn.jiguang.bf.b.a(context));
                return d.a(jSONObject.toString());
            } catch (JSONException unused) {
                c.c("ShareProcessManager", "[getTypeJson] to json error");
                return cn.jiguang.a.a.b;
            }
        }
    }

    private static boolean f(Context context) {
        Boolean bool = i;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            String str = Build.MANUFACTURER;
            String lowerCase = "Xiaomi".toLowerCase();
            if (!TextUtils.isEmpty(str) && TextUtils.equals(lowerCase, str.toLowerCase())) {
                c.c("ShareProcessManager", "xiaomi not use activity and sdcard");
                Boolean bool2 = Boolean.FALSE;
                i = bool2;
                return bool2.booleanValue();
            }
        } catch (Throwable th) {
            c.g("ShareProcessManager", "get MANUFACTURER failed - error:" + th.getMessage());
        }
        i = a(context.getPackageName(), context) != null ? Boolean.TRUE : Boolean.FALSE;
        return i.booleanValue();
    }

    private static boolean g(Context context) {
        Boolean bool = g;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null) {
            c.g("ShareProcessManager", "context is null");
            return true;
        }
        try {
            ProviderInfo b2 = cn.jiguang.f.a.b(context, context.getPackageName(), DownloadProvider.class);
            if (b2 == null) {
                c.c("ShareProcessManager", "not found download provider in manifest");
                Boolean bool2 = Boolean.FALSE;
                g = bool2;
                return bool2.booleanValue();
            }
            if (((ComponentInfo) b2).enabled && ((ComponentInfo) b2).exported && !TextUtils.isEmpty(b2.authority)) {
                Intent intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction("cn.jiguang.android.share.close");
                List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
                g = (queryIntentServices == null || queryIntentServices.isEmpty()) ? Boolean.TRUE : Boolean.FALSE;
                return g.booleanValue();
            }
            c.c("ShareProcessManager", "download provider config error,enable" + ((ComponentInfo) b2).enabled + ",exported:" + ((ComponentInfo) b2).exported + ",authority:" + b2.authority);
            Boolean bool3 = Boolean.FALSE;
            g = bool3;
            return bool3.booleanValue();
        } catch (Throwable th) {
            c.c("ShareProcessManager", "Get isShareProcessModeOpen error#:" + th.getMessage());
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x00ca A[Catch: all -> 0x02bf, TryCatch #1 {all -> 0x02bf, blocks: (B:101:0x0005, B:103:0x000d, B:105:0x0027, B:112:0x0091, B:114:0x0099, B:117:0x00a1, B:118:0x00c4, B:120:0x00ca, B:122:0x00d6, B:124:0x00de, B:127:0x00ef, B:128:0x00f3, B:130:0x00f9, B:134:0x0106, B:136:0x011a, B:138:0x0120, B:140:0x0175, B:142:0x0185, B:149:0x01d3, B:151:0x01df, B:152:0x01ec, B:146:0x0199, B:153:0x01f1, B:158:0x0237, B:159:0x023c, B:168:0x0275, B:162:0x0248, B:166:0x026d, B:163:0x0256, B:165:0x025e, B:167:0x0270, B:169:0x02b4, B:111:0x0057), top: B:182:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00f9 A[Catch: all -> 0x02bf, TRY_LEAVE, TryCatch #1 {all -> 0x02bf, blocks: (B:101:0x0005, B:103:0x000d, B:105:0x0027, B:112:0x0091, B:114:0x0099, B:117:0x00a1, B:118:0x00c4, B:120:0x00ca, B:122:0x00d6, B:124:0x00de, B:127:0x00ef, B:128:0x00f3, B:130:0x00f9, B:134:0x0106, B:136:0x011a, B:138:0x0120, B:140:0x0175, B:142:0x0185, B:149:0x01d3, B:151:0x01df, B:152:0x01ec, B:146:0x0199, B:153:0x01f1, B:158:0x0237, B:159:0x023c, B:168:0x0275, B:162:0x0248, B:166:0x026d, B:163:0x0256, B:165:0x025e, B:167:0x0270, B:169:0x02b4, B:111:0x0057), top: B:182:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0106 A[Catch: all -> 0x02bf, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x02bf, blocks: (B:101:0x0005, B:103:0x000d, B:105:0x0027, B:112:0x0091, B:114:0x0099, B:117:0x00a1, B:118:0x00c4, B:120:0x00ca, B:122:0x00d6, B:124:0x00de, B:127:0x00ef, B:128:0x00f3, B:130:0x00f9, B:134:0x0106, B:136:0x011a, B:138:0x0120, B:140:0x0175, B:142:0x0185, B:149:0x01d3, B:151:0x01df, B:152:0x01ec, B:146:0x0199, B:153:0x01f1, B:158:0x0237, B:159:0x023c, B:168:0x0275, B:162:0x0248, B:166:0x026d, B:163:0x0256, B:165:0x025e, B:167:0x0270, B:169:0x02b4, B:111:0x0057), top: B:182:0x0005 }] */
    @Override // cn.jiguang.be.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() {
        /*
            Method dump skipped, instructions count: 745
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.a.a():void");
    }

    public synchronized void a(Context context) {
        if (g(context) && cn.jiguang.at.b.c(context) == 0) {
            if (!cn.jiguang.aq.c.a().a(context)) {
                c.c("ShareProcessManager", "is not support jpush or jmessage ");
                return;
            }
            Object a = e.a(context, "getwakeenable", null);
            if ((a instanceof Boolean) && !((Boolean) a).booleanValue()) {
                c.c("ShareProcessManager", "wake disable,not scan share app");
                return;
            } else if (this.j) {
                c.c("ShareProcessManager", "isAttaching");
                return;
            } else {
                this.a = context;
                this.j = true;
                c.c("ShareProcessManager", "scanOtherApp...");
                this.c = 0;
                cn.jiguang.at.b.c(this, new int[0]);
                return;
            }
        }
        c.c("ShareProcessManager", "share process is close by action");
        a(context, context.getPackageName());
    }

    public void a(Context context, int i2) {
        c.c("ShareProcessManager", "requestTimeOut,cmd:" + i2 + ",isAttaching:" + this.j);
        if (i2 != 30 || this.j) {
            return;
        }
        this.c++;
        c.c("ShareProcessManager", "attachTimeoutTimes:" + this.c + ",requestUIDS:" + this.d + ",shareProcessUUID:" + this.e);
        if (this.c > 2) {
            c.c("ShareProcessManager", "attach too many times by once scan");
            return;
        }
        long[] jArr = this.d;
        if (jArr == null || jArr.length <= 0 || TextUtils.isEmpty(this.e)) {
            return;
        }
        c.c("ShareProcessManager", "will retry attach");
        cn.jiguang.at.b.a(context, JConstants.SDK_TYPE, 30, 0, j.b(), 0L, cn.jiguang.az.b.a(cn.jiguang.d.a.f(context), this.e, this.d));
    }

    public void a(Context context, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append("request");
        sb.append(i2 == 0 ? GraphResponse.SUCCESS_KEY : f.j);
        sb.append(",cmd:");
        sb.append(i3);
        sb.append(",code:");
        sb.append(i2);
        c.c("ShareProcessManager", sb.toString());
        if (i3 == 30 && i2 == 0) {
            this.c = 0;
        }
    }

    public void a(Context context, long j) {
        try {
            if (TextUtils.isEmpty(this.e)) {
                c.c("ShareProcessManager", "dettachUid error,shareUUID is empty");
                return;
            }
            c.c("ShareProcessManager", "dettach uid:" + j);
            cn.jiguang.at.b.a(context, JConstants.SDK_TYPE, 32, 0, j.b(), 0L, cn.jiguang.az.b.a(this.e, new long[]{j}));
        } catch (Throwable th) {
            c.c("ShareProcessManager", "dettach uid error:" + th.getMessage());
        }
    }

    public void a(Context context, long j, byte[] bArr) {
        String str;
        long j2;
        if (j == 0 || bArr == null) {
            return;
        }
        try {
            Pair<cn.jiguang.az.c, ByteBuffer> a = cn.jiguang.az.a.a(context, bArr, "");
            if (a != null && ((cn.jiguang.az.c) a.first).c == 3) {
                ByteBuffer byteBuffer = (ByteBuffer) a.second;
                byteBuffer.get();
                long j3 = byteBuffer.getLong();
                String a2 = cn.jiguang.az.b.a(byteBuffer);
                if (TextUtils.isEmpty(a2)) {
                    c.g("ShareProcessManager", "msgContent is empty");
                    return;
                }
                LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(a2));
                String readLine = lineNumberReader.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    c.i("ShareProcessManager", "appid is empty");
                    return;
                }
                String readLine2 = lineNumberReader.readLine();
                if (TextUtils.isEmpty(readLine2)) {
                    c.i("ShareProcessManager", "senderId is empty");
                    return;
                }
                if (g(context) && cn.jiguang.at.b.c(context) == 0) {
                    if (!cn.jiguang.f.a.h(context, readLine)) {
                        a(context, ((cn.jiguang.az.c) a.first).g);
                        c.c("ShareProcessManager", "app not installed:" + readLine);
                        a(context, readLine);
                        return;
                    }
                    String encodeToString = Base64.encodeToString(bArr, 10);
                    Long valueOf = Long.valueOf(((cn.jiguang.az.c) a.first).e);
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("ktm", encodeToString);
                    hashMap.put("ktp", d.a(cn.jiguang.d.a.f(context)));
                    hashMap.put("ktma", readLine2);
                    hashMap.put("mtmmi", j3 + "");
                    hashMap.put("ktmfp", context.getPackageName());
                    hashMap.put("ktmr", valueOf + "");
                    c.c("ShareProcessManager", "dispatch share msg,appkey:" + readLine2 + ",msgid:" + j3 + ",rid:" + valueOf);
                    String a3 = a(context, readLine, "asm", hashMap);
                    StringBuilder sb = new StringBuilder();
                    sb.append("dispatch result:");
                    sb.append(a3);
                    c.c("ShareProcessManager", sb.toString());
                    if (TextUtils.isEmpty(a3)) {
                        if (!f(context)) {
                            c.c("ShareProcessManager", "app can not use downloadActivity dispatch msg");
                            j2 = ((cn.jiguang.az.c) a.first).g;
                        } else if (!cn.jiguang.at.b.a && JConstants.isAndroidQ(context, false, "do not startActivity in BackGround")) {
                            this.l = true;
                            a(context, cn.jiguang.d.a.f(context));
                            return;
                        } else {
                            ActivityInfo a4 = a(readLine, context);
                            if (a4 != null) {
                                c.c("ShareProcessManager", "will try use downloadActivity");
                                JSONObject a5 = a(hashMap);
                                Intent intent = new Intent("asm");
                                intent.setComponent(new ComponentName(a4.packageName, a4.name));
                                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                                intent.addCategory(readLine);
                                intent.putExtra("data", a5.toString());
                                j.l.c.e0.a.a.a.h(intent);
                                context.startActivity(intent);
                            } else {
                                j2 = ((cn.jiguang.az.c) a.first).g;
                            }
                        }
                        a(context, j2);
                    } else if (a3.equals("-4")) {
                        j2 = ((cn.jiguang.az.c) a.first).g;
                        a(context, j2);
                    } else {
                        if (a3.equals("0")) {
                            str = "wait the msg reponse";
                        } else {
                            str = "provider is :" + a3 + ",app is less than jcore_v125";
                        }
                        c.c("ShareProcessManager", str);
                    }
                    lineNumberReader.close();
                    return;
                }
                a(context, cn.jiguang.d.a.f(context));
                c.c("ShareProcessManager", " share process is close,will not dispatch the msg and dettach mine uid");
                return;
            }
            c.c("ShareProcessManager", "share msg cmd is not 3");
        } catch (Throwable th) {
            c.g("ShareProcessManager", "dispatchMsg error:" + th.getMessage());
        }
    }

    public void a(Context context, Bundle bundle) {
        String str;
        try {
            c.c("ShareProcessManager", "doMsg");
            if (bundle != null) {
                String string = bundle.getString("data");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(string);
                c.c("ShareProcessManager", "doMsg json:" + jSONObject.toString());
                String optString = jSONObject.optString("ktm");
                String optString2 = jSONObject.optString("ktp");
                String optString3 = jSONObject.optString("mtmmi");
                String optString4 = jSONObject.optString("ktmfp");
                String optString5 = jSONObject.optString("ktma");
                String optString6 = jSONObject.optString("ktmr");
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4) || TextUtils.isEmpty(optString5)) {
                    return;
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("mtmmi", optString3);
                hashMap.put("ktmfp", optString4);
                hashMap.put("ktma", optString5);
                hashMap.put("ktmr", optString6);
                Pair<cn.jiguang.az.c, ByteBuffer> a = cn.jiguang.az.a.a(context, Base64.decode(optString, 10), optString2);
                if (a != null) {
                    hashMap.put("ktmu", ((cn.jiguang.az.c) a.first).g + "");
                    if (g(context) && cn.jiguang.at.b.c(context) == 0) {
                        if (((cn.jiguang.az.c) a.first).g != cn.jiguang.d.a.f(context)) {
                            c.c("ShareProcessManager", "this msg uid is :" + ((cn.jiguang.az.c) a.first).g + ",is not this app msg");
                            str = "1";
                            hashMap.put("asmrc", str);
                        } else {
                            hashMap.put("asmrc", "0");
                            cn.jiguang.ax.b.a().a(context, (cn.jiguang.az.c) a.first, (ByteBuffer) a.second);
                        }
                    }
                    c.c("ShareProcessManager", "share process is closed");
                    str = "3";
                    hashMap.put("asmrc", str);
                }
                a(context, optString4, "asmr", hashMap);
            }
        } catch (Throwable th) {
            c.c("ShareProcessManager", "doMsg error:" + th.getMessage());
        }
    }

    public void b(Context context) {
        if (this.l) {
            this.l = false;
            if (h.a().d()) {
                c.c("ShareProcessManager", "attach mine while app in foreground from background");
                cn.jiguang.at.b.a(context, JConstants.SDK_TYPE, 30, 0, j.b(), 0L, cn.jiguang.az.b.a(cn.jiguang.d.a.f(context), this.e, new long[]{cn.jiguang.d.a.f(context)}));
            }
        }
    }

    public void b(Context context, Bundle bundle) {
        try {
            String string = bundle.getString("data");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("mtmmi");
                String optString2 = jSONObject.optString("ktmfp");
                String optString3 = jSONObject.optString("ktma");
                String optString4 = jSONObject.optString("ktmr");
                String optString5 = jSONObject.optString("ktmu");
                String optString6 = jSONObject.optString("asmrc", "0");
                c.c("ShareProcessManager", "msg response,msgId:" + optString + ",fromPkg:" + optString2 + ",appKey:" + optString3 + ",rid:" + optString4 + ",uid:" + optString5 + ",responseCode:" + optString6);
                if (optString6.equals("0") && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                    c.c("ShareProcessManager", "response success,will send msg response to server");
                    cn.jiguang.at.b.b(context, JConstants.SDK_TYPE, 4, 2, j.b(), Long.parseLong(optString5), cn.jiguang.az.b.a(0, (byte) 0, Long.parseLong(optString), optString3));
                } else if (optString6.equals("1") && !TextUtils.isEmpty(optString5)) {
                    a(context, Long.parseLong(optString5));
                } else if (!optString6.equals("3") || TextUtils.isEmpty(optString5)) {
                    c.c("ShareProcessManager", "invalid msg response");
                } else {
                    a(context, Long.parseLong(optString5));
                    a(context, optString2);
                }
            }
        } catch (Throwable th) {
            c.g("ShareProcessManager", "doMsgResponse failed:" + th.getMessage());
        }
    }
}
