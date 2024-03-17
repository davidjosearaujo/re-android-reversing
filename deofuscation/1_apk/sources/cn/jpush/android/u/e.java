package cn.jpush.android.u;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class e {
    private String A;
    private String B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private long H;
    private int I;
    private int J;
    private boolean K;
    private boolean L;
    private String M;
    private int N;
    private int O;
    private int P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private cn.jpush.android.d.d V;
    public String b;
    public int c;
    public String d;
    public String e;
    public int f;
    public boolean g;
    public String h;
    public String i;
    public String o;
    public String p;
    public int q;
    public String r;
    public int t;
    public long v;
    private String w;
    private String x;
    private String y;
    private String z;
    public int a = 60;
    public boolean j = true;
    public boolean k = false;
    public boolean l = true;
    public boolean m = true;
    public boolean n = true;
    public boolean s = false;
    public int u = 0;

    public e(cn.jpush.android.d.d dVar) {
        this.A = "";
        this.B = "";
        this.C = 0;
        this.D = 0;
        this.E = 1;
        this.F = 0;
        this.G = 5;
        this.H = 1800L;
        this.I = 0;
        this.J = 10;
        this.K = false;
        this.L = true;
        this.y = dVar.c;
        this.w = dVar.a;
        this.x = dVar.b;
        this.z = dVar.f;
        this.A = dVar.ay;
        this.B = dVar.az;
        this.C = dVar.aA;
        this.D = dVar.aF;
        this.E = dVar.aG;
        this.F = dVar.aH;
        this.G = dVar.aJ;
        this.H = dVar.aK;
        this.I = dVar.aL;
        this.J = dVar.aM;
        this.M = dVar.aY;
        this.N = dVar.aZ;
        this.O = dVar.bj;
        this.P = dVar.ba;
        this.Q = dVar.bb;
        this.R = dVar.bc;
        this.S = dVar.bd;
        this.T = dVar.bf;
        this.U = dVar.bg;
        this.K = dVar.aN != 0;
        this.L = dVar.aO != 0;
        this.b = dVar.K;
        this.V = dVar;
        dVar.q = 0;
        dVar.aa = 0;
        dVar.r = true;
    }

    public static e a(String str) {
        cn.jpush.android.d.d a;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("entity");
            if (TextUtils.isEmpty(optString) || (a = cn.jpush.android.d.d.a(optString)) == null) {
                return null;
            }
            e eVar = new e(a);
            eVar.a = jSONObject.optInt("webWidth");
            eVar.b = jSONObject.optString("deeplink");
            eVar.c = jSONObject.optInt("failedAction");
            eVar.d = jSONObject.optString("failedLink");
            eVar.e = jSONObject.optString("targetPkgName");
            eVar.f = jSONObject.optInt("urlOpenType");
            eVar.g = jSONObject.optBoolean("isForNewUser");
            eVar.h = jSONObject.optString("targetAppName");
            eVar.i = jSONObject.optString("targetAppIcon");
            eVar.j = jSONObject.optBoolean("isCanCancel");
            eVar.k = jSONObject.optBoolean("useRange");
            eVar.l = jSONObject.optBoolean("installBySys");
            eVar.m = jSONObject.optBoolean("failInstallByWeb");
            eVar.n = jSONObject.optBoolean("isPopGrantWin");
            eVar.o = jSONObject.optString("sspWxAppId");
            eVar.p = jSONObject.optString("sspWmOriginId");
            eVar.q = jSONObject.optInt("sspWmType");
            eVar.r = jSONObject.optString("sspWxPath");
            eVar.s = jSONObject.optBoolean("isWmDeepLink");
            eVar.t = jSONObject.optInt(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
            return eVar;
        } catch (Throwable unused) {
        }
        return null;
    }

    public int a(Context context, String str) {
        String str2;
        JSONObject optJSONObject;
        int i = 0;
        int i2 = 1302;
        try {
            JSONArray jSONArray = new JSONArray(this.V.bg);
            Logger.d("InAppMessage", "actionKey: " + str + ", parse intent action, actions: " + jSONArray.toString() + ", actionLen: " + jSONArray.length());
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    JSONObject optJSONObject2 = jSONArray.optJSONObject(i3);
                    if (optJSONObject2 != null && optJSONObject2.optString("ein_action_key", "").equals(str)) {
                        int optInt = optJSONObject2.optInt("ein_action_type", 0);
                        this.t = optInt;
                        boolean z = true;
                        if (optInt != 1) {
                            if (optInt == 2) {
                                try {
                                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("ein_wx_intent");
                                    if (optJSONObject3 != null) {
                                        this.o = optJSONObject3.optString("wx_app_id", "");
                                        this.p = optJSONObject3.optString("mini_originid", "");
                                        this.q = optJSONObject3.optInt("mini_type", 0);
                                        this.r = optJSONObject3.optString("mini_path", "");
                                        this.s = true;
                                        str2 = "wx intent param, sspWxAppId=" + this.o + ", sspWmOriginId=" + this.p + ", sspWmType=" + this.q + ", sspWmType=" + this.q;
                                        Logger.d("InAppMessage", str2);
                                    }
                                    i2 = 0;
                                } catch (Throwable th) {
                                    th = th;
                                    Logger.w("InAppMessage", "parse intent action by actionKey: " + str + " failed. " + th.getMessage());
                                    return i;
                                }
                            } else if (optInt != 3 && optInt != 4) {
                            }
                        }
                        JSONObject optJSONObject4 = optJSONObject2.optJSONObject("ein_intent");
                        this.g = optJSONObject2.optInt("ein_for_new_user", 0) != 0;
                        if (optJSONObject4 != null) {
                            this.d = optJSONObject4.optString("n_fail_handle_url", "");
                            this.b = optJSONObject4.optString("n_url", "");
                            this.c = optJSONObject4.optInt("n_fail_handle_type", 0);
                            this.e = optJSONObject4.optString("n_package_name", "");
                            this.f = optJSONObject4.optInt("n_url_open_type", 0);
                            if (this.g && (optJSONObject = optJSONObject2.optJSONObject("ein_extras")) != null) {
                                this.h = optJSONObject.optString("n_target_app_name");
                                this.i = optJSONObject.optString("n_target_app_icon");
                                this.j = optJSONObject.optInt("n_no_swipe_cancel", 0) == 0;
                                this.k = optJSONObject.optInt("n_use_range", 0) != 0;
                                this.l = optJSONObject.optInt("n_install_type", 0) == 0;
                                this.m = optJSONObject.optInt("n_fail_install_type", 0) == 0;
                                if (optJSONObject.optInt("n_pop_grant_win", 0) != 0) {
                                    z = false;
                                }
                                this.n = z;
                            }
                            str2 = "deeplink intent param, deeplink=" + this.b + ", failedLink=" + this.d + ", failedAction=" + this.c + ", targetPkgName=" + this.e + ", urlOpenType=" + this.f + ", isForNewUser= " + this.g + ", canCancel: " + this.j + ", installBySys: " + this.l + ", failInstallByWeb: " + this.m + ", popGrantWin: " + this.n;
                            Logger.d("InAppMessage", str2);
                        }
                        i2 = 0;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i = i2;
                }
            }
            return i2;
        } catch (Throwable th3) {
            th = th3;
            i = 1302;
        }
    }

    public boolean k() {
        return this.L;
    }

    public int l() {
        return this.a;
    }

    public int m() {
        return this.t;
    }

    public String n() {
        return this.y;
    }

    public int o() {
        return this.C;
    }

    public boolean p() {
        return this.D != 0;
    }

    public int q() {
        return this.J * 1000;
    }

    public String r() {
        return this.M;
    }

    public String s() {
        return this.T;
    }

    public boolean t() {
        return this.K;
    }

    public String toString() {
        return "InAppMessage{appId='" + this.w + "', senderId='" + this.x + "', messageId='" + this.y + "', inAppMsgTitle= '" + this.A + "', inAppMsgContentBody= '" + this.B + "', inAppMsgType= " + this.C + ", inAppMsgShowBackground= " + this.D + ", inAppMsgAllowIntercept= " + this.E + ", inAppMsgFilterMsg= " + this.F + ", inAppMsgCountLmt= " + this.G + ", inAppMsgGap= " + this.H + ", inAppMsgToUser= " + this.I + ", inAppMsgDelayDisplayTime= " + this.J + ", inAppWebPageUrl= '" + this.M + "', inAppProtocolVer= " + this.N + ", inAppSSPGap= " + this.O + ", inAppTplId= '" + this.R + "', inAppTplUrl= '" + this.S + "', inAppTplData= '" + this.T + "', webWidth=" + this.a + ", deeplink= '" + this.b + "', failedAction=" + this.c + ", failedLink= '" + this.d + "', targetPkgName= '" + this.e + "', urlOpenType=" + this.f + ", sspWxAppId= '" + this.o + "', sspWmOriginId= '" + this.p + "', sspWmType=" + this.q + ", sspWxPath= '" + this.r + "', isWmDeepLink=" + this.s + ", actionType=" + this.t + ", isForNewUser=" + this.g + ", targetAppName=" + this.g + ", targetAppIcon=" + this.g + ", isCanCancel=" + this.j + ", useRange=" + this.k + ", installBySys=" + this.l + ", failInstallByWeb=" + this.m + ", isPopGrantWin=" + this.n + '}';
    }

    public cn.jpush.android.d.d u() {
        return this.V;
    }

    public String v() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", this.w);
            jSONObject.put("senderId", this.x);
            jSONObject.put("messageId", this.y);
            jSONObject.put("inAppMsgTitle", this.A);
            jSONObject.put("inAppMsgContentBody", this.B);
            jSONObject.put("inAppMsgType", this.C);
            jSONObject.put("inAppMsgShowBackground", this.D);
            jSONObject.put("inAppMsgAllowIntercept", this.E);
            jSONObject.put("inAppMsgFilterMsg", this.F);
            jSONObject.put("inAppMsgCountLmt", this.G);
            jSONObject.put("inAppMsgGap", this.H);
            jSONObject.put("inAppMsgToUser", this.I);
            jSONObject.put("inAppMsgDelayDisplayTime", this.J);
            jSONObject.put("isReportPageName", this.K);
            jSONObject.put("isUseSysAlert", this.L);
            jSONObject.put("inAppWebPageUrl", this.M);
            jSONObject.put("inAppProtocolVer", this.N);
            jSONObject.put("inAppSSPGap", this.N);
            jSONObject.put("inAppCheckIntent", this.P);
            jSONObject.put("inAppTplContent", this.Q);
            jSONObject.put("inAppTplId", this.R);
            jSONObject.put("inAppTplUrl", this.S);
            jSONObject.put("inAppTplData", this.T);
            jSONObject.put("inAppIntentActions", this.U);
            jSONObject.put("webWidth", this.a);
            jSONObject.put("entity", this.V.c());
            jSONObject.put("deeplink", this.b);
            jSONObject.put("failedAction", this.c);
            jSONObject.put("failedLink", this.d);
            jSONObject.put("targetPkgName", this.e);
            jSONObject.put("urlOpenType", this.f);
            jSONObject.put("isForNewUser", this.g);
            jSONObject.put("targetAppName", this.h);
            jSONObject.put("targetAppIcon", this.i);
            jSONObject.put("isCanCancel", this.j);
            jSONObject.put("useRange", this.k);
            jSONObject.put("installBySys", this.l);
            jSONObject.put("failInstallByWeb", this.m);
            jSONObject.put("isPopGrantWin", this.n);
            jSONObject.put("sspWxAppId", this.o);
            jSONObject.put("sspWmOriginId", this.p);
            jSONObject.put("sspWmType", this.q);
            jSONObject.put("sspWxPath", this.r);
            jSONObject.put("isWmDeepLink", this.s);
            jSONObject.put(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, this.t);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
