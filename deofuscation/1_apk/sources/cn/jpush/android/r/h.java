package cn.jpush.android.r;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JNotifyActivity;
import cn.jpush.android.ui.PushActivity;
import com.alibaba.fastjson.asm.Label;
import com.facebook.common.util.UriUtil;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class h {
    private static long a;
    private static int b;
    private static Map<String, String> c = new HashMap();
    private static Map<String, String> d = new HashMap();

    /* JADX WARN: Removed duplicated region for block: B:64:0x002e A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:59:0x0024, B:64:0x002e, B:65:0x0030, B:67:0x003a, B:69:0x0040, B:75:0x006a, B:76:0x0070, B:78:0x0076, B:71:0x0048, B:80:0x009c), top: B:85:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x003a A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:59:0x0024, B:64:0x002e, B:65:0x0030, B:67:0x003a, B:69:0x0040, B:75:0x006a, B:76:0x0070, B:78:0x0076, B:71:0x0048, B:80:0x009c), top: B:85:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x009c A[Catch: all -> 0x0027, TRY_LEAVE, TryCatch #0 {all -> 0x0027, blocks: (B:59:0x0024, B:64:0x002e, B:65:0x0030, B:67:0x003a, B:69:0x0040, B:75:0x006a, B:76:0x0070, B:78:0x0076, B:71:0x0048, B:80:0x009c), top: B:85:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r10, int r11, long r12) {
        /*
            r0 = 0
            if (r10 != 0) goto L4
            return r0
        L4:
            r1 = 0
            java.lang.String r3 = cn.jpush.android.cache.a.p(r10)     // Catch: java.lang.Throwable -> L1e
            java.lang.String r4 = ","
            java.lang.String[] r3 = r3.split(r4)     // Catch: java.lang.Throwable -> L1e
            r4 = r3[r0]     // Catch: java.lang.Throwable -> L1e
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Throwable -> L1e
            r5 = 1
            r3 = r3[r5]     // Catch: java.lang.Throwable -> L1f
            long r5 = java.lang.Long.parseLong(r3)     // Catch: java.lang.Throwable -> L1f
            goto L20
        L1e:
            r4 = 0
        L1f:
            r5 = r1
        L20:
            java.lang.String r3 = "InAppHelper"
            if (r4 != 0) goto L2a
            int r4 = cn.jpush.android.r.h.b     // Catch: java.lang.Throwable -> L27
            goto L2a
        L27:
            r10 = move-exception
            goto Lab
        L2a:
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 != 0) goto L30
            long r5 = cn.jpush.android.r.h.a     // Catch: java.lang.Throwable -> L27
        L30:
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L27
            boolean r9 = cn.jpush.android.ac.b.a(r7, r5)     // Catch: java.lang.Throwable -> L27
            if (r9 == 0) goto L9c
            cn.jpush.android.r.h.b = r4     // Catch: java.lang.Throwable -> L27
            cn.jpush.android.r.h.a = r5     // Catch: java.lang.Throwable -> L27
            if (r11 != 0) goto L46
            java.lang.String r10 = "inApp count is 0, not limit count"
            cn.jpush.android.helper.Logger.d(r3, r10)     // Catch: java.lang.Throwable -> L27
            goto L66
        L46:
            if (r4 < r11) goto L66
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L27
            r10.<init>()     // Catch: java.lang.Throwable -> L27
            java.lang.String r12 = "inApp message count limit,inAppLastCount:"
            r10.append(r12)     // Catch: java.lang.Throwable -> L27
            r10.append(r4)     // Catch: java.lang.Throwable -> L27
            java.lang.String r12 = ",inAppLimitCount:"
            r10.append(r12)     // Catch: java.lang.Throwable -> L27
            r10.append(r11)     // Catch: java.lang.Throwable -> L27
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L27
            cn.jpush.android.helper.Logger.d(r3, r10)     // Catch: java.lang.Throwable -> L27
            r10 = -1
            return r10
        L66:
            int r10 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r10 != 0) goto L70
            java.lang.String r10 = "inApp interval is 0, not limit time"
            cn.jpush.android.helper.Logger.d(r3, r10)     // Catch: java.lang.Throwable -> L27
            goto Lc3
        L70:
            long r10 = r7 - r5
            int r1 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r1 > 0) goto Lc3
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L27
            r10.<init>()     // Catch: java.lang.Throwable -> L27
            java.lang.String r11 = "inApp message time limit,inAppLastTime:"
            r10.append(r11)     // Catch: java.lang.Throwable -> L27
            r10.append(r5)     // Catch: java.lang.Throwable -> L27
            java.lang.String r11 = ",currentTime:"
            r10.append(r11)     // Catch: java.lang.Throwable -> L27
            r10.append(r7)     // Catch: java.lang.Throwable -> L27
            java.lang.String r11 = ",inAppLimitInterval:"
            r10.append(r11)     // Catch: java.lang.Throwable -> L27
            r10.append(r12)     // Catch: java.lang.Throwable -> L27
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L27
            cn.jpush.android.helper.Logger.d(r3, r10)     // Catch: java.lang.Throwable -> L27
            r10 = -2
            return r10
        L9c:
            cn.jpush.android.r.h.b = r0     // Catch: java.lang.Throwable -> L27
            cn.jpush.android.r.h.a = r1     // Catch: java.lang.Throwable -> L27
            java.lang.String r11 = "is a new day,reset inAppState"
            cn.jpush.android.helper.Logger.d(r3, r11)     // Catch: java.lang.Throwable -> L27
            java.lang.String r11 = "0,0"
            cn.jpush.android.cache.a.h(r10, r11)     // Catch: java.lang.Throwable -> L27
            goto Lc3
        Lab:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "getSSPState error:"
            r11.append(r12)
            java.lang.String r10 = r10.getMessage()
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            cn.jpush.android.helper.Logger.w(r3, r10)
        Lc3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.r.h.a(android.content.Context, int, long):int");
    }

    private static String a() {
        Iterator<String> it = c.values().iterator();
        String next = it.hasNext() ? it.next() : "";
        if (TextUtils.isEmpty(next)) {
            Iterator<String> it2 = c.keySet().iterator();
            return it2.hasNext() ? it2.next() : next;
        }
        return next;
    }

    public static void a(Context context) {
        long j;
        if (context == null) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            int i = 0;
            try {
                String[] split = cn.jpush.android.cache.a.p(context).split(",");
                i = Integer.parseInt(split[0]);
                j = Long.parseLong(split[1]);
            } catch (Throwable unused) {
                j = 0;
            }
            if (i == 0) {
                i = b;
            }
            if (j == 0) {
                j = a;
            }
            int i2 = cn.jpush.android.ac.b.a(currentTimeMillis, j) ? 1 + i : 1;
            b = i2;
            a = currentTimeMillis;
            Logger.d("InAppHelper", "setInAppState inAppCount:" + i2 + ",inAppTime:" + currentTimeMillis);
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append(",");
            sb.append(currentTimeMillis);
            cn.jpush.android.cache.a.h(context, sb.toString());
        } catch (Throwable th) {
            Logger.w("InAppHelper", "setInAppLastState error:" + th.getMessage());
        }
    }

    private static void a(Context context, Intent intent) {
        if ("com.mt.mtxx.mtxx".equals(context.getPackageName())) {
            intent.putExtra("infoProvider", "JPush");
        }
    }

    public static void a(Context context, cn.jpush.android.d.d dVar) {
        try {
            String str = dVar.ay;
            String str2 = dVar.az;
            long currentTimeMillis = System.currentTimeMillis();
            String d2 = cn.jpush.android.ac.a.d(str + str2);
            Logger.d("InAppHelper", "in-app message contentMd5: " + d2);
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            cn.jpush.android.o.b.a(context, d2, currentTimeMillis);
        } catch (Throwable th) {
            Logger.w("InAppHelper", "setLatestInAppInfo failed, " + th.getMessage());
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("funName", str);
            }
            if (context == null) {
                context = JPushConstants.mApplicationContext;
            }
            cn.jpush.android.helper.c.a(str2, 1257, jSONObject.toString(), context);
        } catch (Throwable unused) {
        }
    }

    public static synchronized void a(String str, int i, boolean z) {
        synchronized (h.class) {
            if (TextUtils.isEmpty(str)) {
                Logger.w("InAppHelper", "[updateCurrentPage] pageName is null");
                return;
            }
            if (z) {
                if (i == 0 && !c.isEmpty()) {
                    d.putAll(c);
                }
                if (c.containsKey(str)) {
                    c.clear();
                }
                if (i == 1) {
                    c.put(str, d.get(str));
                }
            } else if (i == 1) {
                Iterator<String> it = c.keySet().iterator();
                if (it.hasNext()) {
                    c.put(it.next(), str);
                }
            } else {
                Iterator<String> it2 = c.keySet().iterator();
                if (it2.hasNext()) {
                    String next = it2.next();
                    if (str.equals(c.get(next))) {
                        c.put(next, "");
                    }
                }
            }
        }
    }

    private static boolean a(Context context, int i, String str, cn.jpush.android.d.d dVar) {
        if (TextUtils.isEmpty(str) || context == null) {
            Logger.d("InAppHelper", "link uri is empty, url: " + str + ", context: " + context);
            return false;
        }
        Logger.d("InAppHelper", "[openWebUri], urlOpenType: " + i + ", url: " + str);
        try {
            Intent intent = new Intent();
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            if (i != 0) {
                if (i == 1) {
                    if (!cn.jpush.android.ac.a.d(context, "com.android.browser")) {
                        Logger.dd("InAppHelper", "not found com.android.browser,user will choose other browser");
                        throw new Throwable("not found com.android.browser,user will choose other browser");
                    }
                    intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
                    intent.setData(Uri.parse(str));
                    intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
                    a(context, intent);
                }
            } else if (!f(context)) {
                Logger.ww("InAppHelper", "please check layout file jpush_webview_layout.xml!");
                throw new Throwable("not found layout file jpush_webview_layout.xml");
            } else {
                intent.setClass(context, PushActivity.class);
                if (dVar != null) {
                    dVar.V = str;
                    intent.putExtra(PushActivity.FROM_OTHER_WAY, true);
                    intent.putExtra("msg_data", dVar.c());
                }
                if (Build.VERSION.SDK_INT >= 11) {
                    intent.addFlags(Label.FORWARD_REFERENCE_TYPE_WIDE);
                }
            }
            j.l.c.e0.a.a.a.h(intent);
            context.startActivity(intent);
        } catch (Throwable th) {
            Logger.w("InAppHelper", "first open url failed, use browser open again. " + th.getMessage());
            try {
                try {
                    if (!cn.jpush.android.ac.a.d(context, "com.android.browser")) {
                        Logger.dd("InAppHelper", "not found com.android.browser,user will choose other browser");
                        throw new Throwable("not found com.android.browser,user will choose other browser");
                    }
                    Intent intent2 = new Intent();
                    intent2.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
                    intent2.setData(Uri.parse(str));
                    intent2.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    intent2.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
                    a(context, intent2);
                    j.l.c.e0.a.a.a.h(intent2);
                    context.startActivity(intent2);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    Logger.d("InAppHelper", "[openWebUri] start fail uri error:" + th2.getMessage());
                    return false;
                }
            } catch (Throwable unused) {
                Intent parseUri = Intent.parseUri(str, 0);
                parseUri.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                a(context, parseUri);
                j.l.c.e0.a.a.a.h(parseUri);
                context.startActivity(parseUri);
            }
        }
        return true;
    }

    public static boolean a(Context context, cn.jpush.android.u.e eVar) {
        String n;
        String n2;
        String n3;
        String n4;
        if (context == null || eVar == null) {
            Logger.w("InAppHelper", "deep link open with unexpected error, context: " + context + ", message: " + eVar);
            if (eVar != null) {
                a(context, "deepLinkOpen", eVar.n());
            }
            return false;
        } else if (TextUtils.isEmpty(eVar.b) && !eVar.s) {
            Logger.w("InAppHelper", "is not deep link in-app message");
            cn.jpush.android.helper.c.a(eVar.n(), 1293, context);
            return false;
        } else {
            try {
                if (eVar.m() == 2) {
                    Logger.d("InAppHelper", "open wechat mini program");
                    c(context, eVar);
                } else {
                    Logger.d("InAppHelper", "in-app open deeplink, targetPkg:" + eVar.e + ", forNewUser: " + eVar.g);
                    if (!TextUtils.isEmpty(eVar.e)) {
                        if (cn.jpush.android.ac.a.a(context, eVar.e, !eVar.g ? eVar.b : "")) {
                            Logger.d("InAppHelper", "p installed, targetPkgName: " + eVar.e);
                            if (eVar.g) {
                                Logger.w("InAppHelper", "link for new user, p installed not download");
                                cn.jpush.android.helper.c.a(eVar.n(), 1248, context);
                            } else if (b(context, eVar)) {
                                n4 = eVar.n();
                                cn.jpush.android.helper.c.a(n4, 1214, context);
                            } else {
                                n3 = eVar.n();
                                cn.jpush.android.helper.c.a(n3, 1215, context);
                            }
                        } else if (!eVar.g) {
                            cn.jpush.android.helper.c.a(eVar.n(), 1216, context);
                            Logger.d("InAppHelper", "app not installed,fail_handle_type:" + eVar.c + ",fail_handle_url:" + eVar.d);
                            if (eVar.c != 1) {
                                cn.jpush.android.helper.c.a(eVar.n(), 1301, context);
                            } else if (TextUtils.isEmpty(eVar.d)) {
                                Logger.w("InAppHelper", "fail_handle_url is empty");
                            } else {
                                eVar.b = eVar.d;
                                if (b(context, eVar)) {
                                    cn.jpush.android.helper.c.a(eVar.n(), 1217, context);
                                } else {
                                    cn.jpush.android.helper.c.a(eVar.n(), 1218, context);
                                }
                            }
                        } else if (d(context, eVar)) {
                            n2 = eVar.n();
                            cn.jpush.android.helper.c.a(n2, 1300, context);
                        } else {
                            n = eVar.n();
                            cn.jpush.android.helper.c.a(n, 1299, context);
                        }
                    } else if (eVar.g) {
                        if (d(context, eVar)) {
                            n2 = eVar.n();
                            cn.jpush.android.helper.c.a(n2, 1300, context);
                        } else {
                            n = eVar.n();
                            cn.jpush.android.helper.c.a(n, 1299, context);
                        }
                    } else if (b(context, eVar)) {
                        n4 = eVar.n();
                        cn.jpush.android.helper.c.a(n4, 1214, context);
                    } else {
                        n3 = eVar.n();
                        cn.jpush.android.helper.c.a(n3, 1215, context);
                    }
                }
                return true;
            } catch (Throwable th) {
                cn.jpush.android.helper.c.a(eVar.n(), 1294, context);
                Logger.w("InAppHelper", "url failed:" + th.getMessage());
                return false;
            }
        }
    }

    public static boolean a(Context context, String str) {
        if (context == null) {
            Logger.w("InAppHelper", "[checkInBlackList] context is null");
            return false;
        } else if (!cn.jpush.android.t.b.b(context)) {
            Logger.d("InAppHelper", "[checkInBlackList] request black list not completed");
            return true;
        } else {
            List<String> d2 = cn.jpush.android.t.b.d(context);
            if (d2 == null || d2.isEmpty()) {
                Logger.d("InAppHelper", "no blacklist and check whitelist");
                return !b(context, str);
            }
            return d2.contains(str);
        }
    }

    private static int b(Context context, String str, String str2) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    public static String b(Context context) {
        return cn.jpush.android.cache.a.q(context);
    }

    public static boolean b(Context context, cn.jpush.android.u.e eVar) {
        if (context == null || eVar == null) {
            return false;
        }
        try {
            return (TextUtils.isEmpty(eVar.b) || !eVar.b.startsWith(UriUtil.HTTP_SCHEME)) ? cn.jpush.android.x.c.a(context, eVar.b, eVar.e) : a(context, eVar.f, eVar.b, eVar.u());
        } catch (Throwable th) {
            Logger.w("InAppHelper", "open deeplink failed, error: " + th.getMessage());
            return false;
        }
    }

    private static boolean b(Context context, String str) {
        if (context == null) {
            Logger.w("InAppHelper", "[checkInWhiteList] context is null");
            return false;
        } else if (!cn.jpush.android.t.b.b(context)) {
            Logger.d("InAppHelper", "[checkInWhiteList] request black list not completed");
            return false;
        } else {
            List<String> c2 = cn.jpush.android.t.b.c(context);
            if (c2 == null || c2.isEmpty()) {
                return true;
            }
            return c2.contains(str);
        }
    }

    public static void c(Context context) {
        if (context == null) {
            Logger.ww("InAppHelper", "context is null");
        } else if (!cn.jpush.android.ac.a.a(context, JNotifyActivity.class)) {
            Logger.ee("InAppHelper", "AndroidManifest.xml missing required activity: " + JNotifyActivity.class.getCanonicalName());
        } else {
            if (!cn.jpush.android.ac.a.c(context)) {
                Logger.dd("InAppHelper", "no draw overlay permission");
            }
            boolean j = cn.jpush.android.ac.a.j(context);
            cn.jpush.android.o.b.c = j;
            if ((j ? cn.jpush.android.q.a.a(context) : -1) == 0) {
                Logger.dd("InAppHelper", "can install apk by system");
            } else {
                Logger.ww("InAppHelper", "not allowed install apk by system");
            }
            if (!f(context)) {
                Logger.ww("InAppHelper", "please check layout file jpush_webview_layout.xml, no this file can not open h5 in app");
            }
            Logger.dd("InAppHelper", "in app is integrated succeed~");
        }
    }

    private static void c(Context context, cn.jpush.android.u.e eVar) {
        int i;
        eVar.e = "com.tencent.mm";
        String n = eVar.n();
        if (cn.jpush.android.ac.a.a(context, eVar.e, "weixin://")) {
            i = !cn.jpush.android.x.c.a(context, eVar.o, eVar.p, eVar.r, eVar.q) ? 1213 : CommonConstant.RETCODE.NEED_UPDATE_STATICKIT;
        } else {
            Logger.d("InAppHelper", "wechat apk not install");
            i = 1221;
        }
        cn.jpush.android.helper.c.a(n, i, context);
    }

    public static boolean d(Context context) {
        Activity p;
        String canonicalName;
        if (!c.isEmpty()) {
            canonicalName = a();
        } else if (!g(context) || (p = cn.jpush.android.ac.a.p(context)) == null) {
            return false;
        } else {
            canonicalName = p.getClass().getCanonicalName();
            cn.jpush.android.p.a.a().a(context, canonicalName, 1, true);
        }
        return a(context, canonicalName);
    }

    private static boolean d(Context context, cn.jpush.android.u.e eVar) {
        Logger.d("InAppHelper", "google play not allowed");
        return false;
    }

    public static boolean e(Context context) {
        Activity p;
        String canonicalName;
        if (!c.isEmpty()) {
            canonicalName = a();
        } else if (!g(context) || (p = cn.jpush.android.ac.a.p(context)) == null) {
            return true;
        } else {
            canonicalName = p.getClass().getCanonicalName();
            cn.jpush.android.p.a.a().a(context, canonicalName, 1, true);
        }
        return b(context, canonicalName);
    }

    private static boolean f(Context context) {
        if (context != null) {
            return b(context, "jpush_webview_layout", "layout") > 0 && b(context, "actionbarLayoutId", "id") > 0 && b(context, "rlRichpushTitleBar", "id") > 0 && b(context, "tvRichpushTitle", "id") > 0 && b(context, "imgRichpushBtnBack", "id") > 0 && b(context, "pushPrograssBar", "id") > 0;
        }
        Logger.w("InAppHelper", "context is null");
        return false;
    }

    private static boolean g(Context context) {
        return context.getPackageName().equals(cn.jpush.android.ac.a.d(context));
    }
}
