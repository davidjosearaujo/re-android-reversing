package cn.jpush.android.r;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.alibaba.fastjson.JSONStreamContext;
import com.facebook.login.LoginStatusClient;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class r extends k implements f {
    private b a;
    private int b;
    private g c;
    private cn.jpush.android.d.d d;
    private int e = 0;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a extends cn.jpush.android.ac.e {
        public Context a;
        public cn.jpush.android.d.d b;
        public b c;

        public a(Context context, cn.jpush.android.d.d dVar, b bVar) {
            this.a = context;
            this.b = dVar;
            this.c = bVar;
            this.f = "NotifyInAppMessageAction";
        }

        private boolean a(Context context, cn.jpush.android.d.d dVar) {
            try {
                if (context == null || dVar == null) {
                    Logger.w("NotificationInAppHelper", "unexpected nulrl param error, context is " + context + ", message is " + dVar);
                    return false;
                }
                Logger.d("NotificationInAppHelper", "handle notify message, messageType: " + dVar.av);
                if (a(dVar)) {
                    Logger.ww("NotificationInAppHelper", "notify inapp message expired");
                    cn.jpush.android.helper.c.a(dVar.c, 1603, context);
                    return false;
                } else if (b(context, dVar) != null) {
                    cn.jpush.android.p.a.a(context, "cn.jpush.android.intent.INAPP_MESSAGE_ARRIVED", dVar, true);
                    return true;
                } else {
                    Logger.ww("NotificationInAppHelper", "notify tpl dl failed");
                    return false;
                }
            } catch (Throwable th) {
                Logger.w("NotificationInAppHelper", "handle notify in-app message failed, " + th.getMessage());
                return false;
            }
        }

        private boolean a(cn.jpush.android.d.d dVar) {
            if (TextUtils.isEmpty(dVar.at)) {
                return false;
            }
            return System.currentTimeMillis() >= cn.jpush.android.ac.b.b(dVar.at);
        }

        private cn.jpush.android.d.d b(Context context, cn.jpush.android.d.d dVar) {
            String str;
            String str2;
            boolean z;
            try {
                String str3 = dVar.bc;
                if (TextUtils.isEmpty(str3)) {
                    str3 = cn.jpush.android.ac.a.d(dVar.bd);
                }
                String str4 = dVar.c;
                LinkedHashMap<String, cn.jpush.android.u.f> a = p.a(context);
                cn.jpush.android.u.f fVar = a.get(str3);
                str = "";
                if (fVar != null) {
                    str2 = fVar.b;
                    if (cn.jpush.android.ac.c.a(str2)) {
                        dVar.aY = "file://" + str2;
                        fVar.c = System.currentTimeMillis();
                        Logger.d("NotificationInAppHelper", "use cache template, templateId: " + str3 + ", webPagePath: " + str2 + ", totalTemplateCount: " + a.values().size() + ", update template file time: " + new File(str2).setLastModified(fVar.c));
                    } else {
                        a.remove(str3);
                        Logger.d("NotificationInAppHelper", "local config has template path, but the template file is not exist, will download again.");
                        str2 = "";
                    }
                    p.a(context, a);
                } else {
                    str2 = "";
                }
                String str5 = dVar.bd;
                int i = 0;
                if (TextUtils.isEmpty(str2)) {
                    Logger.d("NotificationInAppHelper", "no local template cache, start download template, url: " + str5);
                    if (TextUtils.isEmpty(str5)) {
                        Logger.w("NotificationInAppHelper", "template url is Empty! Give up to download!");
                        z = false;
                    } else {
                        String a2 = cn.jpush.android.w.a.a(str5, 5, (long) LoginStatusClient.DEFAULT_TOAST_DURATION_MS);
                        boolean isEmpty = TextUtils.isEmpty(a2);
                        str = isEmpty ? "" : a2;
                        z = !isEmpty;
                    }
                    if (!z) {
                        Logger.w("NotificationInAppHelper", "NOTE: failed to download html page. Give up this.");
                        return null;
                    }
                    String str6 = cn.jpush.android.ac.c.a(context, "h5_tpls", 20) + str3 + ".html";
                    Logger.d("NotificationInAppHelper", "download template success, will save to local of path: " + str6);
                    if (cn.jpush.android.ac.c.b(str6, str)) {
                        dVar.aY = "file://" + str6;
                        Logger.d("NotificationInAppHelper", "cache h5 template to local success, templateId: " + str3 + ", path: " + dVar.aY);
                        a.put(str3, cn.jpush.android.u.f.a(str3, str6, System.currentTimeMillis()));
                        p.a(context, a);
                    } else {
                        dVar.aY = dVar.bd;
                    }
                }
                if (dVar.bh.size() > 0) {
                    Logger.d("NotificationInAppHelper", "template has image resource, start download image to local, images: " + dVar.bh.toString());
                    ArrayList<String> a3 = p.a(dVar.bh, context, str5.substring(0, str5.lastIndexOf("/") + 1), str4);
                    if (a3 == null) {
                        Logger.w("NotificationInAppHelper", "Load notify in-app message image resources failed, give up this in app!");
                        return null;
                    }
                    Logger.d("NotificationInAppHelper", "Load notify in-app message image succeed, webView will open cache!");
                    JSONObject jSONObject = new JSONObject(dVar.bf);
                    while (i < a3.size()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("in_pic_path");
                        int i2 = i + 1;
                        sb.append(i2);
                        jSONObject.put(sb.toString(), a3.get(i));
                        i = i2;
                    }
                    dVar.bf = jSONObject.toString();
                    Logger.d("NotificationInAppHelper", "http image resources replace local path, new templateData: " + dVar.bf);
                } else {
                    Logger.d("NotificationInAppHelper", "template no image resource.");
                }
            } catch (Throwable unused) {
            }
            return dVar;
        }

        @Override // cn.jpush.android.ac.e
        public void a() {
            cn.jpush.android.d.d dVar;
            if (a(this.a, this.b) || (dVar = this.b) == null) {
                return;
            }
            if (!TextUtils.isEmpty(dVar.c)) {
                cn.jpush.android.helper.c.a(this.b.c, 1604, this.a);
            }
            if (this.b.av == 104) {
                Logger.d("NotificationInAppHelper", "in app handle failed, start handle notification");
                cn.jpush.android.d.b.a(this.a, this.b);
            }
            b bVar = this.c;
            if (bVar != null) {
                bVar.a(this.a, this.b.bn, 0);
            }
        }
    }

    public r(g gVar, b bVar) {
        this.a = bVar;
        this.c = gVar;
        gVar.a(201, this);
        this.b = 2;
    }

    private void b(Context context, cn.jpush.android.u.e eVar, int i) {
        if (eVar != null) {
            int i2 = eVar.u().bn;
            b bVar = this.a;
            if (bVar != null) {
                bVar.a(context, i2, i);
            }
            if (i != 1 && eVar.u().av == 104 && this.e != 2) {
                Logger.d("NotificationInAppHelper", "in app handle completed, start handle notification, state: " + i);
                f(context, eVar.u());
            }
        }
        this.e = i;
    }

    private boolean e(Context context, cn.jpush.android.d.d dVar) {
        String str;
        String str2;
        boolean z = false;
        if (context == null) {
            Logger.w("NotificationInAppHelper", "[openDeepLink] context is null");
            return false;
        } else if (dVar == null || TextUtils.isEmpty(dVar.K)) {
            Logger.d("NotificationInAppHelper", "is not deep link notification in app");
            return false;
        } else {
            try {
                Logger.d("NotificationInAppHelper", "open deeplink notification in app, targetPkg:" + dVar.N);
            } catch (Throwable th) {
                Logger.w("NotificationInAppHelper", "url failed:" + th.getMessage());
            }
            if (TextUtils.isEmpty(dVar.N)) {
                z = cn.jpush.android.x.c.a(context, dVar.K, dVar.N);
                if (z) {
                    str2 = dVar.c;
                    cn.jpush.android.helper.c.a(str2, 1605, context);
                    return z;
                }
                str = dVar.c;
                cn.jpush.android.helper.c.a(str, 1606, context);
                return z;
            } else if (cn.jpush.android.ac.a.a(context, dVar.N, dVar.K)) {
                z = h.b(context, new cn.jpush.android.u.e(dVar));
                if (z) {
                    str2 = dVar.c;
                    cn.jpush.android.helper.c.a(str2, 1605, context);
                    return z;
                }
                str = dVar.c;
                cn.jpush.android.helper.c.a(str, 1606, context);
                return z;
            } else {
                Logger.d("NotificationInAppHelper", "app not installed,fail_handle_type:" + dVar.L + ",fail_handle_url:" + dVar.M);
                int i = dVar.L;
                if (i == 0) {
                    Intent g = cn.jpush.android.ac.a.g(context);
                    if (g != null) {
                        j.l.c.e0.a.a.a.h(g);
                        context.startActivity(g);
                    }
                } else if (i == 1 || i == 2) {
                    if (TextUtils.isEmpty(dVar.M)) {
                        Logger.d("NotificationInAppHelper", "fail_handle_url is empty");
                    } else {
                        z = cn.jpush.android.x.c.d(context, dVar.M);
                        if (z) {
                            str2 = dVar.c;
                            cn.jpush.android.helper.c.a(str2, 1605, context);
                        } else {
                            str = dVar.c;
                            cn.jpush.android.helper.c.a(str, 1606, context);
                        }
                    }
                }
                return z;
            }
        }
    }

    private void f(Context context, cn.jpush.android.d.d dVar) {
        if (dVar != null) {
            Logger.d("NotificationInAppHelper", "notify in app, start handle notify message");
            Bundle bundle = new Bundle();
            bundle.putString("content", dVar.c());
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "in_app_notify_msg", bundle);
        }
    }

    @Override // cn.jpush.android.r.k
    public int a(Context context) {
        return this.b;
    }

    @Override // cn.jpush.android.r.f
    public Boolean a(Context context, int i, cn.jpush.android.u.e eVar, Object... objArr) {
        if (context == null) {
            Logger.w("NotificationInAppHelper", "unexpected error context is null, eventType: " + i);
        } else if (eVar != null) {
            try {
                String n = eVar.n();
                int i2 = eVar.u().bn;
                switch (i) {
                    case 1000:
                    case 1001:
                    case 1002:
                    case 1015:
                        if (i != 1015) {
                            cn.jpush.android.helper.c.a(n, 1604, context);
                        }
                        b(context, eVar, 0);
                        break;
                    case JSONStreamContext.PropertyValue /* 1003 */:
                    case JSONStreamContext.StartArray /* 1004 */:
                    case 1007:
                    case 1011:
                    case 1017:
                    case 1021:
                    case 1023:
                    case 1024:
                    case 1025:
                        break;
                    case JSONStreamContext.ArrayValue /* 1005 */:
                    case 1006:
                    case 1008:
                    case 1009:
                    case com.alipay.sdk.app.d.a /* 1010 */:
                    case 1013:
                    case 1018:
                    case 1020:
                        cn.jpush.android.helper.c.a(n, 1604, context);
                        break;
                    case 1012:
                        boolean a2 = cn.jpush.android.x.e.a(context, eVar.n(), "");
                        if (a2) {
                            cn.jpush.android.helper.c.a(n, 1602, context);
                        }
                        return Boolean.valueOf(a2);
                    case 1014:
                        cn.jpush.android.helper.c.a(n, 1600, context);
                        b(context, eVar, 2);
                        break;
                    case 1016:
                        cn.jpush.android.helper.c.a(n, 1602, context);
                        break;
                    case 1019:
                        cn.jpush.android.helper.c.a(n, 1601, context);
                        e(context, eVar.u());
                        break;
                    case 1022:
                        b bVar = this.a;
                        if (bVar != null) {
                            bVar.a(context, n, i2);
                            break;
                        }
                        break;
                    default:
                        Logger.d("NotificationInAppHelper", "onDisplayEvent default eventType: " + i);
                        break;
                }
            } catch (Throwable th) {
                Logger.w("NotificationInAppHelper", "onDisplayEvent error: " + th.getMessage());
            }
            return Boolean.TRUE;
        } else {
            Logger.ww("NotificationInAppHelper", "unexpected error message is null, eventType: " + i);
        }
        return Boolean.FALSE;
    }

    @Override // cn.jpush.android.r.k
    public void a(Context context, int i) {
        g gVar = this.c;
        if (gVar != null) {
            gVar.a(context, i);
        }
    }

    @Override // cn.jpush.android.r.k
    public void a(Context context, cn.jpush.android.d.d dVar) {
        if (cn.jpush.android.ac.a.k(context) && !h.d(context)) {
            this.d = dVar;
            this.b = dVar.bo;
            JCoreHelper.normalExecutor(context, JPushConstants.SDK_TYPE, new a(context, dVar, this.a));
            return;
        }
        Logger.dd("NotificationInAppHelper", "cache notify message in background or page in black list");
        b(context, dVar);
        b bVar = this.a;
        if (bVar != null) {
            bVar.a(context, dVar.bn, 0);
        }
    }

    @Override // cn.jpush.android.r.k
    public void a(Context context, cn.jpush.android.u.e eVar, int i) {
        g gVar = this.c;
        if (gVar != null) {
            gVar.a(context, eVar, i);
        }
    }

    @Override // cn.jpush.android.r.k
    public void a(cn.jpush.android.u.e eVar, int i, String str) {
        g gVar = this.c;
        if (gVar != null) {
            gVar.a(eVar, i, str);
        }
    }

    @Override // cn.jpush.android.r.k
    public cn.jpush.android.d.d b(Context context) {
        return s.b(context);
    }

    @Override // cn.jpush.android.r.k
    public void b(Context context, cn.jpush.android.d.d dVar) {
        if (dVar != null) {
            this.b = dVar.bo;
            s.a(context, dVar);
        }
    }

    @Override // cn.jpush.android.r.k
    public void c(Context context, String str) {
        g gVar = this.c;
        if (gVar != null) {
            gVar.c(context, str);
        }
    }

    @Override // cn.jpush.android.r.k
    public boolean c(Context context) {
        return s.a(context) > 0;
    }

    @Override // cn.jpush.android.r.k
    public boolean c(Context context, cn.jpush.android.d.d dVar) {
        g gVar = this.c;
        if (gVar != null) {
            this.d = dVar;
            return gVar.a(context, dVar);
        }
        return false;
    }

    @Override // cn.jpush.android.r.k
    public void d(Context context) {
        g gVar = this.c;
        if (gVar == null || this.e != 2) {
            return;
        }
        gVar.a(context);
    }

    @Override // cn.jpush.android.r.k
    public void d(Context context, cn.jpush.android.d.d dVar) {
        g gVar = this.c;
        if (gVar != null) {
            gVar.a(context, dVar.c, false, false);
        }
    }

    @Override // cn.jpush.android.r.k
    public void d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.w("NotificationInAppHelper", "unexpected param is null");
            return;
        }
        String[] split = str.split(",");
        for (String str2 : split) {
            if (!TextUtils.isEmpty(str2)) {
                if (s.a(context, str2)) {
                    if (split.length == 2) {
                        str2 = split[1];
                    }
                    cn.jpush.android.helper.c.a(str2, 1602, context);
                } else if (this.c != null) {
                    cn.jpush.android.d.d dVar = this.d;
                    this.c.a(context, str2, dVar != null && dVar.c.equals(str2), true);
                }
            }
        }
    }
}
