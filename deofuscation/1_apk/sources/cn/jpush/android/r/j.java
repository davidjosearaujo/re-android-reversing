package cn.jpush.android.r;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import com.facebook.login.LoginStatusClient;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class j extends cn.jpush.android.ac.e {
    private Context a;
    private cn.jpush.android.d.d b;
    private b c;

    public j(Context context, cn.jpush.android.d.d dVar, b bVar) {
        this.a = context;
        this.b = dVar;
        this.c = bVar;
        this.f = "AdInAppHelper#Action";
    }

    private boolean a(Context context, cn.jpush.android.d.d dVar) {
        if (context == null || dVar == null) {
            Logger.d("InAppMessageAction", "[handleInAppMessage] context or pushEntity is null");
            if (dVar != null) {
                h.a(context, "handleInAppMessage", dVar.c);
            }
            return false;
        }
        Logger.d("InAppMessageAction", "[handleInAppMessage] message: type: " + dVar.aA + ", showType: " + dVar.aB + ", showPos: " + dVar.aC + ", checkIntentType: " + dVar.ba);
        try {
            int b = b(context, dVar);
            if (b != 0) {
                cn.jpush.android.helper.c.a(dVar.c, b, context);
                Logger.w("InAppMessageAction", "in-app message frequency is too frequently, drop it[msgID: " + dVar.c + "]");
                return false;
            } else if (c(context, dVar)) {
                return false;
            } else {
                if (!e(context, dVar)) {
                    Logger.w("InAppMessageAction", "wx mini program link, but some param not match, in-app not show");
                    Logger.ww("IN-AT", "bad params of wx mini link");
                    return false;
                } else if (!d(context, dVar)) {
                    Logger.ww("IN-AT", "bad params of d link");
                    return false;
                } else if (f(context, dVar) == null) {
                    Logger.ww("IN-AT", "dl tpl failed");
                    return false;
                } else {
                    cn.jpush.android.helper.c.a(dVar.c, 1263, context);
                    cn.jpush.android.p.a.a(context, "cn.jpush.android.intent.INAPP_MESSAGE_ARRIVED", dVar, true);
                    return true;
                }
            }
        } catch (Throwable th) {
            cn.jpush.android.helper.c.a(dVar.c, 1268, context);
            Logger.w("InAppMessageAction", "[handleInAppMessage] error. " + th.getMessage());
            return false;
        }
    }

    private static int b(Context context, cn.jpush.android.d.d dVar) {
        try {
            if (dVar == null || context == null) {
                Logger.w("InAppMessageAction", "unexcepted error param is null");
                return 1269;
            }
            int max = Math.max(dVar.aJ, 0);
            long max2 = Math.max(dVar.aK, 0L) * 1000;
            if (max > 0) {
                Logger.d("InAppMessageAction", "set in-app message LimitCount:" + max);
            }
            if (max2 > 0) {
                Logger.d("InAppMessageAction", "set in-app message LimitInterval:" + max2);
            }
            int a = h.a(context, max, max2);
            if (a != -2) {
                return a != -1 ? 0 : 1202;
            }
            return 1203;
        } catch (Throwable th) {
            Logger.w("InAppMessageAction", "parse in-app message notificationExtra failed, error:" + th.getMessage());
            return 1269;
        }
    }

    private static boolean c(Context context, cn.jpush.android.d.d dVar) {
        if (context != null && dVar != null) {
            try {
                if (dVar.aG == 1 && cn.jpush.android.p.a.a().c(context, 200)) {
                    Logger.dd("InAppMessageAction", "need not show in-app message by user");
                    cn.jpush.android.p.a.a(context, "cn.jpush.android.intent.IN_APP_MSG_UN_SHOW_INTERVAL", dVar, false);
                    cn.jpush.android.helper.c.a(dVar.c, 1206, context);
                    return true;
                }
            } catch (Throwable th) {
                Logger.w("InAppMessageAction", "check user intercept the message show error. " + th.getMessage());
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x00c9, code lost:
        cn.jpush.android.helper.Logger.d("InAppMessageAction", "deeplink is empty or not a http/https url, not show in-app message");
        cn.jpush.android.helper.c.a(r4, 1207, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x00d3, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x010a, code lost:
        cn.jpush.android.helper.Logger.w("InAppMessageAction", "targetPkgname:" + r6 + " not installed and failed type:" + r11 + ", not show in-app message");
        cn.jpush.android.helper.c.a(r4, 1208, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0131, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean d(android.content.Context r14, cn.jpush.android.d.d r15) {
        /*
            Method dump skipped, instructions count: 463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.r.j.d(android.content.Context, cn.jpush.android.d.d):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01ca A[Catch: all -> 0x020b, TryCatch #0 {all -> 0x020b, blocks: (B:102:0x000f, B:103:0x0030, B:105:0x0036, B:162:0x01cc, B:108:0x005d, B:110:0x0065, B:112:0x0070, B:115:0x00ae, B:117:0x00b4, B:119:0x00ba, B:122:0x00ca, B:124:0x00dd, B:127:0x00ef, B:129:0x0139, B:131:0x0145, B:133:0x014b, B:136:0x0153, B:138:0x0159, B:140:0x0166, B:142:0x016c, B:144:0x0179, B:146:0x0193, B:148:0x0199, B:151:0x01a0, B:155:0x01ad, B:157:0x01bb, B:159:0x01c3, B:161:0x01ca, B:163:0x01d5, B:167:0x01e4, B:169:0x0202), top: B:175:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x01c3 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v5, types: [int, boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean e(android.content.Context r22, cn.jpush.android.d.d r23) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.r.j.e(android.content.Context, cn.jpush.android.d.d):boolean");
    }

    private static cn.jpush.android.d.d f(Context context, cn.jpush.android.d.d dVar) {
        String str;
        String str2;
        boolean z;
        if (context == null || dVar == null) {
            Logger.w("InAppMessageAction", "unexpected param is null, context: " + context + ", pushEntity: " + dVar);
            if (dVar != null) {
                h.a(context, "handleH5Template", dVar.c);
            }
            return null;
        }
        String str3 = dVar.bc;
        String str4 = dVar.c;
        LinkedHashMap<String, cn.jpush.android.u.f> a = p.a(context);
        cn.jpush.android.u.f fVar = a.get(str3);
        str = "";
        if (fVar != null) {
            str2 = fVar.b;
            if (cn.jpush.android.ac.c.a(str2)) {
                dVar.aY = "file://" + str2;
                fVar.c = System.currentTimeMillis();
                boolean lastModified = new File(str2).setLastModified(fVar.c);
                cn.jpush.android.helper.c.a(str4, 1283, context);
                Logger.d("InAppMessageAction", "use cache template, templateId: " + str3 + ", webPagePath: " + str2 + ", totalTemplateCount: " + a.values().size() + ", update template file time: " + lastModified);
            } else {
                a.remove(str3);
                Logger.d("InAppMessageAction", "local config has template path, but the template file is not exist, will download again.");
                str2 = "";
            }
            p.a(context, a);
        } else {
            str2 = "";
        }
        String str5 = dVar.bd;
        if (TextUtils.isEmpty(str2)) {
            Logger.d("InAppMessageAction", "no local template cache, start download template, url: " + str5);
            if (TextUtils.isEmpty(str5)) {
                Logger.w("InAppMessageAction", "template url is Empty! Give up to download!");
                z = false;
            } else {
                String a2 = cn.jpush.android.w.a.a(str5, 5, (long) LoginStatusClient.DEFAULT_TOAST_DURATION_MS);
                boolean isEmpty = TextUtils.isEmpty(a2);
                str = isEmpty ? "" : a2;
                z = !isEmpty;
            }
            if (!z) {
                Logger.w("InAppMessageAction", "NOTE: failed to download html page. Give up this.");
                cn.jpush.android.helper.c.a(dVar.c, 1231, context);
                return null;
            }
            String str6 = cn.jpush.android.ac.c.a(context, "h5_tpls", 20) + str3 + ".html";
            Logger.d("InAppMessageAction", "download template success, will save to local of path: " + str6);
            if (cn.jpush.android.ac.c.b(str6, str)) {
                dVar.aY = "file://" + str6;
                Logger.d("InAppMessageAction", "cache h5 template to local success, templateId: " + str3 + ", path: " + dVar.aY);
                a.put(str3, cn.jpush.android.u.f.a(str3, str6, System.currentTimeMillis()));
                p.a(context, a);
                cn.jpush.android.helper.c.a(str4, 1273, context);
            } else {
                cn.jpush.android.helper.c.a(str4, 1233, context);
                dVar.aY = dVar.bd;
            }
        }
        if (dVar.bh.size() > 0 || !TextUtils.isEmpty(dVar.bm)) {
            String substring = str5.substring(0, str5.lastIndexOf("/") + 1);
            if (dVar.bh.size() > 0) {
                Logger.d("InAppMessageAction", "template has image resource, start download image to local, images: " + dVar.bh.toString());
                ArrayList<String> a3 = p.a(dVar.bh, context, substring, str4);
                if (a3 == null) {
                    cn.jpush.android.helper.c.a(str4, 1232, context);
                    Logger.w("InAppMessageAction", "Loads in-app message image resources failed, give up this in app!");
                    return null;
                }
                Logger.d("InAppMessageAction", "Loads in-app message image succeed, webView will open cache!");
                String str7 = dVar.bf;
                try {
                    JSONObject jSONObject = new JSONObject(str7);
                    int i = 0;
                    while (i < a3.size()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("in_pic_path");
                        int i2 = i + 1;
                        sb.append(i2);
                        jSONObject.put(sb.toString(), a3.get(i));
                        i = i2;
                    }
                    dVar.bf = jSONObject.toString();
                    Logger.d("InAppMessageAction", "http image resources replace local path, new templateData: " + dVar.bf);
                } catch (JSONException e) {
                    dVar.bf = str7;
                    cn.jpush.android.helper.c.a(str4, 1266, context);
                    Logger.w("InAppMessageAction", "replace template picture resource error, " + e.getMessage());
                }
            }
            if (!TextUtils.isEmpty(dVar.bm)) {
                Logger.d("InAppMessageAction", "template has image resource, start download image to local, icon: " + dVar.bm);
                ArrayList arrayList = new ArrayList();
                arrayList.add(dVar.bm);
                ArrayList<String> a4 = p.a(arrayList, context, substring, str4, false);
                if (a4 == null) {
                    cn.jpush.android.helper.c.a(str4, 1232, context);
                    Logger.w("InAppMessageAction", "Loads in-app message image icon resources failed, give up this in app!");
                    return null;
                }
                Logger.d("InAppMessageAction", "Loads in-app message image icon succeed, webView will open cache!");
                String str8 = dVar.bf;
                try {
                    JSONObject jSONObject2 = new JSONObject(str8);
                    for (int i3 = 0; i3 < a4.size(); i3++) {
                        jSONObject2.put("in_app_icon", a4.get(i3));
                    }
                    dVar.bf = jSONObject2.toString();
                    Logger.d("InAppMessageAction", "http image icon resources replace local path, new templateData: " + dVar.bf);
                } catch (JSONException e2) {
                    dVar.bf = str8;
                    cn.jpush.android.helper.c.a(str4, 1266, context);
                    Logger.w("InAppMessageAction", "replace template picture icon resource error, " + e2.getMessage());
                }
            }
        } else {
            Logger.d("InAppMessageAction", "template no image resource.");
        }
        return dVar;
    }

    @Override // cn.jpush.android.ac.e
    public void a() {
        b bVar;
        try {
            if (a(this.a, this.b) || (bVar = this.c) == null) {
                return;
            }
            bVar.a(this.a, this.b.bn, 0);
        } catch (Throwable th) {
            Logger.w("InAppMessageAction", "run InAppMessageAction failed:" + th.getMessage());
        }
    }
}
