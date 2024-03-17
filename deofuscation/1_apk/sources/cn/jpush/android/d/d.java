package cn.jpush.android.d;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.ac.i;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.facebook.share.internal.ShareConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.LineNumberReader;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d implements Serializable {
    private static HashMap<String, String> bt = new HashMap<>();
    private static final long serialVersionUID = 8407025843324043625L;
    public int A;
    public String B;
    public String C;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public int L;
    public String M;
    public String N;
    public int P;
    public String Q;
    public String R;
    public int S;
    public String V;
    public String W;
    public String X;
    public int Y;
    public String a;
    public int aa;
    public Integer af;
    public String ag;
    public long ah;
    public String ai;
    public boolean aj;
    public boolean ak;
    public long al;
    public String ao;
    public String ap;
    public String aq;
    public String ar;
    public String as;
    public String at;
    public int au;
    public int av;
    public String b;
    public String bb;
    public int bn;
    public int bo;
    public boolean bp;
    public boolean bq;
    public String br;
    public String bs;
    public String c;
    public int d;
    public int e;
    public String f;
    public String g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public String m;
    public String n;
    public String o;
    public String p;
    public int q;
    public boolean r;
    public int s;
    public String t;
    public String u;
    public String v;
    public int w;
    public String x;
    public String y;
    public String z;
    public int l = 0;
    public int D = -1;
    public String E = "";
    public int O = 0;
    public boolean T = false;
    public boolean U = false;
    public int Z = 0;
    public ArrayList<String> ab = new ArrayList<>();
    public String ac = "";
    public String ad = "";
    public byte ae = 0;
    public double am = 200.0d;
    public double an = 200.0d;
    public String aw = "";
    public String ax = "";
    public String ay = "";
    public String az = "";
    public int aA = 1;
    public int aB = 2;
    public int aC = 0;
    public int aD = 0;
    public int aE = 0;
    public int aF = 0;
    public int aG = 1;
    public int aH = 0;
    public String aI = "";
    public int aJ = 0;
    public long aK = 0;
    public int aL = 0;
    public int aM = 10;
    public int aN = 0;
    public int aO = 1;
    public String aP = "#FFFFFFFF";
    public String aQ = "#FF000000";
    public String aR = "#FF000000";
    public int aS = 14;
    public int aT = 14;
    public int aU = 9;
    public int aV = 5;
    public float aW = 0.5f;
    public float aX = 0.5f;
    public String aY = "";
    public int aZ = 2;
    public int ba = 2;
    public String bc = "";
    public String bd = "";
    public float be = 0.6f;
    public String bf = "";
    public String bg = "";
    public ArrayList<String> bh = new ArrayList<>();
    public int bi = 0;
    public int bj = 180;
    public int bk = 0;
    public int bl = 0;
    public String bm = "";

    public static d a(Context context, d dVar) {
        try {
            JSONObject optJSONObject = new JSONObject(dVar.h).optJSONObject("inapp");
            if (optJSONObject == null) {
                return null;
            }
            dVar.a(context);
            dVar.ay = dVar.t;
            dVar.az = dVar.v;
            dVar.aM = optJSONObject.optInt("inapp_delay_display_time", 10);
            dVar.bd = optJSONObject.optString("inapp_h5_tpl_url", "");
            dVar.bo = optJSONObject.optInt("inapp_priority", 2);
            dVar.bp = optJSONObject.optInt("inapp_display_direct", 0) == 1;
            dVar.aC = optJSONObject.optInt("inapp_show_pos", 0);
            dVar.aV = optJSONObject.optInt("inapp_show_threshold_time", 5);
            String str = dVar.I;
            if (!TextUtils.isEmpty(str)) {
                dVar.bh.add(str);
            }
            dVar.at = optJSONObject.optString("inapp_end_time", "");
            dVar.au = optJSONObject.optInt("inapp_max_cache_numb", 10);
            dVar.aL = optJSONObject.optInt("inapp_msg_to_user", 1);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("in_title", dVar.ay);
            jSONObject.put("in_body_content", dVar.az);
            jSONObject.put("in_pic_path1", str);
            dVar.bf = jSONObject.toString();
            return dVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static d a(Context context, String str, String str2) {
        String str3;
        d dVar = new d();
        byte b = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("_jmsgid_");
            dVar.c = optString;
            if (optString.isEmpty()) {
                dVar.c = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID);
            }
            dVar.f = a(dVar.c, jSONObject);
            dVar.ae = (byte) jSONObject.optInt("rom_type");
            int optInt = jSONObject.optInt("show_type", -1);
            JSONObject optJSONObject = jSONObject.optJSONObject("m_content");
            if (optJSONObject != null) {
                dVar.v = optJSONObject.optString("n_content");
                dVar.t = optJSONObject.optString("n_title");
                dVar.C = optJSONObject.optString("n_extras");
                dVar.E = optJSONObject.optString("n_channel_id");
                dVar.F = optJSONObject.optString("n_display_foreground");
                dVar.D = optJSONObject.optInt("n_alert_type");
                dVar.A = optJSONObject.optInt("n_priority");
                dVar.F = optJSONObject.optString("n_display_foreground");
                dVar.aq = optJSONObject.optString("n_sound");
                dVar.s = optJSONObject.optInt("n_flag", 1);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("rich_content");
                if (optJSONObject2 != null) {
                    dVar.U = true;
                    dVar.a(optJSONObject2);
                    dVar.i = 3;
                } else {
                    dVar.i = 4;
                    dVar.Z = -1;
                }
            } else {
                dVar.v = jSONObject.optString("n_content");
                dVar.t = jSONObject.optString("n_title");
                dVar.C = jSONObject.optString("n_extras");
                dVar.E = jSONObject.optString("n_channel_id");
                dVar.F = jSONObject.optString("n_display_foreground");
                dVar.D = jSONObject.optInt("n_alert_type");
                dVar.A = jSONObject.optInt("n_priority");
                dVar.F = jSONObject.optString("n_display_foreground");
                dVar.ae = (byte) jSONObject.optInt("rom_type");
                dVar.aq = jSONObject.optString("n_sound");
            }
            if (optInt != -1) {
                dVar.i = optInt;
            }
            dVar.q = 0;
            dVar.r = true;
            dVar.a = context.getPackageName();
            return dVar;
        } catch (Throwable th) {
            Logger.e("PushEntity", "parseContent error:" + th);
            if (TextUtils.isEmpty(dVar.c)) {
                str3 = "NO MSGID";
            } else {
                str3 = dVar.c;
                b = dVar.ae;
            }
            cn.jpush.android.helper.c.a(str3, str2, b, 996, context);
            return null;
        }
    }

    public static d a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.a = jSONObject.optString("appId");
            dVar.b = jSONObject.optString("senderId");
            String optString = jSONObject.optString("messageId");
            dVar.c = optString;
            dVar.f = a(optString, jSONObject);
            dVar.d = jSONObject.optInt("notificationId");
            dVar.e = jSONObject.optInt("messageType");
            dVar.g = jSONObject.optString("overrideMessageId");
            dVar.i = jSONObject.optInt("messageVersion");
            dVar.j = jSONObject.optBoolean("notificationOnly");
            dVar.k = jSONObject.optInt("notificationBuilderId");
            dVar.l = jSONObject.optInt("notificationType");
            dVar.m = jSONObject.optString("message");
            dVar.n = jSONObject.optString("contentType");
            dVar.o = jSONObject.optString("title");
            dVar.p = jSONObject.optString("extras");
            dVar.q = jSONObject.optInt("type");
            dVar.r = jSONObject.optBoolean("isFullScreen");
            dVar.s = jSONObject.optInt("notificationRemoveMode");
            dVar.t = jSONObject.optString("notificationTitle");
            dVar.u = jSONObject.optString("notificationAppName");
            dVar.v = jSONObject.optString("notificationContent");
            dVar.w = jSONObject.optInt("notificationStyle");
            dVar.x = jSONObject.optString("notificationBigText");
            dVar.y = jSONObject.optString("notificationBigPicPath");
            dVar.z = jSONObject.optString("notificationInbox");
            dVar.A = jSONObject.optInt("notificationPriority");
            dVar.B = jSONObject.optString("notificationCategory");
            dVar.C = jSONObject.optString("notificationExtra");
            dVar.D = jSONObject.optInt("notificationAlertType");
            dVar.E = jSONObject.optString("notificationChannelId");
            dVar.F = jSONObject.optString("displayForeground");
            dVar.G = jSONObject.optString(ShareConstants.FEED_SOURCE_PARAM);
            dVar.H = jSONObject.optString("smallIcon");
            dVar.I = jSONObject.optString("largeIcon");
            dVar.J = jSONObject.optString("normalSmallIcon");
            dVar.K = jSONObject.optString("deeplink");
            dVar.L = jSONObject.optInt("failedAction");
            dVar.M = jSONObject.optString("failedLink");
            dVar.N = jSONObject.optString("targetPkgName");
            dVar.P = jSONObject.optInt("deeplinkBuilderId");
            dVar.U = jSONObject.optBoolean("isRichPush");
            dVar.V = jSONObject.optString("showUrl");
            dVar.W = jSONObject.optString("showTitle");
            dVar.X = jSONObject.optString("_webPagePath");
            dVar.Y = jSONObject.optInt("jumpMode");
            dVar.Z = jSONObject.optInt("richType");
            dVar.aa = jSONObject.optInt("showMode");
            String optString2 = jSONObject.optString("showResourceList");
            if (!TextUtils.isEmpty(optString2)) {
                dVar.ab = new ArrayList<>(Arrays.asList(optString2.split(",")));
            }
            dVar.ac = jSONObject.optString("fromNum");
            dVar.ad = jSONObject.optString("toNum");
            dVar.ae = (byte) jSONObject.optInt(JThirdPlatFormInterface.KEY_PLATFORM);
            if (jSONObject.has("badgeAddNum")) {
                dVar.af = Integer.valueOf(jSONObject.optInt("badgeAddNum"));
            }
            dVar.ag = jSONObject.optString("geofenceid");
            dVar.ah = jSONObject.optLong("radius");
            dVar.ai = jSONObject.optString("status");
            dVar.aj = jSONObject.optBoolean("repeat");
            dVar.ak = jSONObject.optBoolean("hasShow");
            dVar.al = jSONObject.optLong("expiration");
            dVar.am = jSONObject.optDouble("longitude");
            dVar.an = jSONObject.optDouble("latitude");
            dVar.ao = jSONObject.optString("lastGeoStatus");
            dVar.ap = jSONObject.optString("developerArg0");
            dVar.aq = jSONObject.optString(RemoteMessageConst.Notification.SOUND);
            dVar.ar = jSONObject.optString("showBeginTime");
            dVar.as = jSONObject.optString("showEndTime");
            dVar.T = jSONObject.optBoolean("isWmDeepLink");
            dVar.Q = jSONObject.optString("wxAppId");
            dVar.R = jSONObject.optString("miniOriginid");
            dVar.S = jSONObject.optInt("miniType");
            dVar.ax = jSONObject.optString("inAppMsgContent");
            dVar.aw = jSONObject.optString("inAppIntent");
            dVar.ay = jSONObject.optString("inAppMsgTitle");
            dVar.az = jSONObject.optString("inAppMsgContentBody");
            dVar.aA = jSONObject.optInt("inAppMsgType");
            dVar.aB = jSONObject.optInt("inAppMsgShowType");
            dVar.aC = jSONObject.optInt("inAppMsgShowPos");
            dVar.aD = jSONObject.optInt("inAppMsgShowAniAction");
            dVar.bk = jSONObject.optInt("inSupportNotifyAni");
            dVar.bl = jSONObject.optInt("inSupportVibration");
            dVar.bm = jSONObject.optString("inAppIcon");
            dVar.aE = jSONObject.optInt("inAppMsgDismissAniAction");
            dVar.aF = jSONObject.optInt("inAppMsgShowBackground");
            dVar.aG = jSONObject.optInt("inAppMsgAllowIntercept");
            dVar.aH = jSONObject.optInt("inAppMsgFilterMsg");
            dVar.aI = jSONObject.optString("inAppMsgPicPath");
            dVar.aJ = jSONObject.optInt("inAppMsgCountLmt");
            dVar.aK = jSONObject.optInt("inAppMsgGap");
            dVar.aL = jSONObject.optInt("inAppMsgToUser");
            dVar.aM = jSONObject.optInt("inAppMsgDelayDisplayTime");
            dVar.aN = jSONObject.optInt("inAppMsgReportPageName");
            dVar.aO = jSONObject.optInt("inAppUseSysAlert");
            dVar.aP = jSONObject.optString("inAppMsgBackgroundColor");
            dVar.aQ = jSONObject.optString("inAppMsgTitleColor");
            dVar.aR = jSONObject.optString("inAppMsgContentColor");
            dVar.aS = jSONObject.optInt("inAppMsgTitleSize");
            dVar.aT = jSONObject.optInt("inAppMsgContentSize");
            dVar.aU = jSONObject.optInt("inAppMsgCircularSize");
            dVar.aV = jSONObject.optInt("inAppMsgShowTime");
            dVar.aW = (float) jSONObject.optDouble("inAppMsgShowElapseTime");
            dVar.aX = (float) jSONObject.optDouble("inAppMsgDismissElapseTime");
            dVar.aY = jSONObject.optString("inAppWebPageUrl");
            dVar.aZ = jSONObject.optInt("inAppProtocolVer");
            dVar.bj = jSONObject.optInt("inAppSSPGap");
            dVar.ba = jSONObject.optInt("inAppCheckIntent");
            dVar.bb = jSONObject.optString("inAppTplContent");
            dVar.bc = jSONObject.optString("inAppTplId");
            dVar.bd = jSONObject.optString("inAppTplUrl");
            dVar.be = (float) jSONObject.optDouble("inAppMarginY");
            dVar.bf = jSONObject.optString("inAppTplData");
            dVar.bg = jSONObject.optString("inAppIntentActions");
            dVar.bn = jSONObject.optInt("inAppType");
            dVar.at = jSONObject.optString("notifyInAppEndTime");
            dVar.au = jSONObject.optInt("notifyInAppCacheNumb");
            dVar.av = jSONObject.optInt("notifyInAppMsgType");
            dVar.bo = jSONObject.optInt("inAppPriority");
            dVar.bp = jSONObject.optBoolean("inAppIsDisplayDirect");
            dVar.br = jSONObject.optString("inAppBlackConf");
            dVar.bs = jSONObject.optString("inAppAnimatorConf");
            dVar.bq = jSONObject.optBoolean("inAppFixed");
            String optString3 = jSONObject.optString("inAppShowResList");
            if (!TextUtils.isEmpty(optString3)) {
                dVar.bh = new ArrayList<>(Arrays.asList(optString3.split(",")));
            }
            return dVar;
        } catch (Throwable th) {
            Logger.w("PushEntity", "parseJSONString e:" + th);
            th.printStackTrace();
            return null;
        }
    }

    public static d a(String str, String str2, String str3, long j) {
        JSONObject optJSONObject;
        String str4 = "NO MSGID";
        d dVar = null;
        try {
            Logger.d("PushEntity", "parse in app message, data: " + str);
            JSONObject jSONObject = new JSONObject(str);
            d dVar2 = new d();
            String optString = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID, "");
            if (TextUtils.isEmpty(optString)) {
                optString = jSONObject.optString("ad_id", "");
            }
            if (TextUtils.isEmpty(optString)) {
                optString = jSONObject.optString("_jmsgid_", "");
            }
            if (TextUtils.isEmpty(optString)) {
                str4 = j + "";
            } else {
                str4 = optString;
            }
            dVar2.c = str4;
            dVar2.a = str2;
            dVar2.b = str3;
            dVar2.f = a(str4, jSONObject);
            dVar2.ax = jSONObject.optString("in_content");
            JSONObject jSONObject2 = new JSONObject(dVar2.ax);
            int i = 0;
            dVar2.aF = jSONObject2.optInt("in_show_background", 0);
            boolean z = true;
            dVar2.aG = jSONObject2.optInt("in_allow_intercept", 1);
            dVar2.aH = jSONObject2.optInt("in_filter_msg", 0);
            dVar2.aJ = jSONObject2.optInt("in_msgcount_limit", 5);
            dVar2.aK = jSONObject2.optLong("in_msg_gap", 1800L);
            dVar2.aL = jSONObject2.optInt("in_msg_to_user", 0);
            dVar2.aM = jSONObject2.optInt("in_delay_display_time", 10);
            dVar2.aN = jSONObject2.optInt("in_report_page_name", 0);
            dVar2.aO = jSONObject2.optInt("in_use_sys_alert", 1);
            dVar2.aZ = jSONObject2.optInt("in_protocol_ver", 0);
            dVar2.ba = jSONObject2.optInt("in_check_intent_action", 0);
            dVar2.bj = jSONObject2.optInt("in_ssp_gap", 180);
            dVar2.bg = jSONObject2.optString("in_intent_actions", "");
            dVar2.bb = jSONObject2.optString("in_template_content", "");
            dVar2.bo = jSONObject2.optInt("in_priority", 3);
            dVar2.bp = jSONObject2.optInt("in_display_direct", 0) == 1;
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("in_template_content");
            if (optJSONObject2 != null) {
                dVar2.aV = optJSONObject2.optInt("ein_show_threshold_time", 5);
                dVar2.aW = (float) optJSONObject2.optDouble("ein_toshow_threshold_time", 0.5d);
                dVar2.aX = (float) optJSONObject2.optDouble("ein_todismiss_threshold_time", 0.5d);
                int optInt = optJSONObject2.optInt("in_message_type", 1);
                dVar2.aA = optInt;
                if (jSONObject2.optInt("in_msg_fixed", optInt == 1 ? 0 : 1) == 0) {
                    z = false;
                }
                dVar2.bq = z;
                dVar2.bk = optJSONObject2.optInt("in_support_notify_ani", 0);
                dVar2.bl = optJSONObject2.optInt("in_support_vibration", 0);
                dVar2.aC = optJSONObject2.optInt("in_show_pos", 0);
                dVar2.aD = optJSONObject2.optInt("in_show_ani_action", 0);
                dVar2.aE = optJSONObject2.optInt("in_dismiss_ani_action", 0);
                dVar2.bc = optJSONObject2.optString("in_h5_template_id", "");
                dVar2.bd = optJSONObject2.optString("in_h5_template_url", "");
                dVar2.bf = optJSONObject2.optString("in_h5_template_data", "");
                dVar2.be = (float) optJSONObject2.optDouble("in_margin_y", 0.6000000238418579d);
                dVar2.aY = dVar2.bd;
                if (!TextUtils.isEmpty(dVar2.bf) && (optJSONObject = optJSONObject2.optJSONObject("in_h5_template_data")) != null) {
                    dVar2.ay = optJSONObject.optString("in_title", "");
                    dVar2.az = optJSONObject.optString("in_body_content", "");
                    dVar2.bi = optJSONObject.optInt("in_pic_count", 0);
                    while (i < dVar2.bi) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("in_pic_path");
                        i++;
                        sb.append(i);
                        String optString2 = optJSONObject.optString(sb.toString(), "");
                        if (!TextUtils.isEmpty(optString2)) {
                            dVar2.bh.add(optString2);
                        }
                    }
                    dVar2.bm = optJSONObject.optString("in_app_icon", "");
                }
                dVar = dVar2;
            } else {
                Logger.w("PushEntity", "in-app message in_template_content json content is null");
                Logger.ww("PushEntity", "in-msg tpl content is null");
            }
        } catch (Throwable th) {
            Logger.w("PushEntity", "parse in app message error, " + th.getMessage());
            Logger.ww("PushEntity", "parse in-msg failed");
        }
        cn.jpush.android.helper.c.a(str4, dVar != null ? 1205 : 1279, JPushConstants.mApplicationContext);
        return dVar;
    }

    private static String a(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                String optString = jSONObject.optString("_j_data_", "");
                Logger.d("PushEntity", "parse jdata:" + optString);
                a(str, optString);
                return optString;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static void a(String str, String str2) {
        if (bt == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        bt.put(str, str2);
    }

    private void a(JSONObject jSONObject) {
        this.U = true;
        this.V = jSONObject.optString("e_url", "").trim();
        this.W = jSONObject.optString("e_title", "").trim();
        if (!TextUtils.isEmpty(this.V) && !cn.jpush.android.ac.a.c(this.V)) {
            this.V = JPushConstants.HTTPS_PRE + this.V;
            Logger.i("PushEntity", "Add http to non-prefix url: " + this.V);
        }
        this.Z = jSONObject.optInt("e_rich_type", 0);
        this.Y = jSONObject.optInt("e_jump_mode", 0);
        this.aa = jSONObject.optInt("e_show", 0);
        int i = this.Z;
        if (3 == i || 2 == i || 1 == i) {
            this.ab = i.a(jSONObject.optJSONArray("e_eres"));
        }
        this.ac = jSONObject.optString("from_num", "");
        this.ad = jSONObject.optString("to_num", "");
    }

    public static d b(String str, String str2, String str3, long j) {
        JSONObject jSONObject;
        d dVar;
        d dVar2 = null;
        try {
            jSONObject = new JSONObject(str);
            dVar = new d();
        } catch (Throwable th) {
            th = th;
        }
        try {
            String optString = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID, "");
            if (TextUtils.isEmpty(optString)) {
                optString = jSONObject.optString("ad_id", "");
            }
            if (TextUtils.isEmpty(optString)) {
                optString = jSONObject.optString("_jmsgid_", "");
            }
            if (TextUtils.isEmpty(optString)) {
                optString = j + "";
            }
            Logger.d("PushEntity", "preParseOriginalMsgMessage msgId = " + optString);
            dVar.c = optString;
            dVar.a = str2;
            dVar.b = str3;
            dVar.f = a(optString, jSONObject);
            boolean z = true;
            if (jSONObject.optInt("n_only", 0) != 1) {
                z = false;
            }
            int optInt = z ? jSONObject.optInt("n_builder_id", 0) : 0;
            dVar.j = z;
            dVar.k = optInt;
            dVar.h = str;
            dVar.i = jSONObject.optInt("show_type", 3);
            dVar.l = jSONObject.optInt("notificaion_type", 0);
            dVar.g = jSONObject.optString("override_msg_id", "");
            dVar.m = jSONObject.optString("message", "");
            dVar.n = jSONObject.optString("content_type", "");
            dVar.o = jSONObject.optString("title", "");
            dVar.p = jSONObject.optString("extras", "");
            return dVar;
        } catch (Throwable th2) {
            th = th2;
            dVar2 = dVar;
            Logger.w("PushEntity", "processMessage failed:" + th.getMessage());
            return dVar2;
        }
    }

    public static String b(String str) {
        HashMap<String, String> hashMap = bt;
        return hashMap != null ? hashMap.get(str) : "";
    }

    public static String c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(str));
                String readLine = lineNumberReader.readLine();
                String readLine2 = lineNumberReader.readLine();
                if (readLine == null) {
                    Logger.e("PushEntity", "NO appId");
                    return null;
                } else if (readLine2 == null) {
                    Logger.e("PushEntity", "NO senderId");
                    return null;
                } else {
                    int length = readLine.length() + readLine2.length() + 2;
                    if (str.length() <= length + 1) {
                        Logger.d("PushEntity", "No msgContent");
                        return null;
                    }
                    String optString = new JSONObject(str.substring(length)).optString("_j_data_", "");
                    Logger.d("PushEntity", "get jdata from push msg:" + optString);
                    return optString;
                }
            } catch (Throwable th) {
                Logger.d("PushEntity", "get jdata from push msg error:" + th.getMessage());
                th.printStackTrace();
            }
        }
        return null;
    }

    public a a() {
        return new a(this);
    }

    public void a(Context context) {
        try {
            JSONObject optJSONObject = new JSONObject(this.h).optJSONObject("m_content");
            int optInt = optJSONObject.optInt("ad_t", 0);
            this.q = optInt;
            if (optInt != 0) {
                return;
            }
            this.r = optJSONObject.optInt("full_screen", 0) >= 1;
            this.s = optJSONObject.optInt("n_flag", 1);
            this.t = optJSONObject.optString("n_title", "");
            this.u = optJSONObject.optString("n_app_name", "");
            this.v = optJSONObject.optString("n_content", "");
            this.w = optJSONObject.optInt("n_style", 0);
            this.x = optJSONObject.optString("n_big_text", "");
            this.y = optJSONObject.optString("n_big_pic_path", "");
            this.z = optJSONObject.optString("n_inbox", "");
            this.C = optJSONObject.optString("n_extras", "");
            this.A = optJSONObject.optInt("n_priority", 0);
            this.B = optJSONObject.optString("n_category", "");
            this.D = optJSONObject.optInt("n_alert_type", -1);
            this.E = optJSONObject.optString("n_channel_id");
            this.F = optJSONObject.optString("n_display_foreground");
            this.H = optJSONObject.optString("n_small_icon", "");
            this.I = optJSONObject.optString("n_large_icon", "");
            this.G = optJSONObject.optString("n_source", "");
            this.J = optJSONObject.optString("n_small_icon_uri", "");
            this.aw = optJSONObject.optString("n_intent");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("n_intent");
            if (optJSONObject2 != null) {
                this.K = optJSONObject2.optString("n_url", "");
                this.L = optJSONObject2.optInt("n_fail_handle_type", 0);
                this.M = optJSONObject2.optString("n_fail_handle_url", "");
                this.N = optJSONObject2.optString("n_package_name", "");
                this.P = optJSONObject2.optInt("n_builder_id", 0);
                this.Q = optJSONObject2.optString("wx_app_id", "");
                this.R = optJSONObject2.optString("mini_originid", "");
                this.S = optJSONObject2.optInt("mini_type", 0);
            }
            if (TextUtils.isEmpty(this.t)) {
                Logger.dd("PushEntity", "Not found notificaiton title for developer mode. Use the application name.");
                this.t = cn.jpush.android.ac.a.b(context);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("ad_content");
            if (!optJSONObject.isNull("ad_content") && optJSONObject3 != null) {
                a(optJSONObject3);
            }
            if (optJSONObject.has("n_badge_add_num")) {
                this.af = Integer.valueOf(optJSONObject.optInt("n_badge_add_num"));
            } else {
                this.af = null;
            }
            this.aq = optJSONObject.optString("n_sound");
            this.ar = optJSONObject.optString("n_show_begin_time");
            this.as = optJSONObject.optString("n_show_end_time");
        } catch (Throwable th) {
            Logger.ww("PushEntity", "parse notification failed:" + th.getMessage());
        }
    }

    public NotificationMessage b() {
        NotificationMessage notificationMessage = new NotificationMessage();
        notificationMessage.appkey = this.b;
        notificationMessage.msgId = this.c;
        notificationMessage.notificationAlertType = this.D;
        notificationMessage.notificationBigPicPath = this.y;
        notificationMessage.notificationBigText = this.x;
        notificationMessage.notificationBuilderId = this.k;
        notificationMessage.notificationCategory = this.B;
        notificationMessage.notificationContent = this.v;
        notificationMessage.notificationExtras = this.C;
        notificationMessage.notificationId = this.d;
        notificationMessage.notificationInbox = this.z;
        notificationMessage.notificationLargeIcon = this.I;
        notificationMessage.notificationPriority = this.A;
        notificationMessage.notificationSmallIcon = this.H;
        notificationMessage.notificationStyle = this.w;
        notificationMessage.notificationTitle = this.t;
        notificationMessage.appId = this.a;
        notificationMessage.notificationType = this.l;
        notificationMessage.developerArg0 = this.ap;
        notificationMessage.notificationChannelId = this.E;
        notificationMessage.isRichPush = this.U;
        notificationMessage.richType = this.Z;
        notificationMessage._webPagePath = this.X;
        notificationMessage.showResourceList = this.ab;
        notificationMessage.platform = this.ae;
        try {
            notificationMessage.deeplink = this.K;
            notificationMessage.failedAction = this.L;
            notificationMessage.failedLink = this.M;
            notificationMessage.targetPkgName = this.N;
            notificationMessage.displayForeground = this.F;
            notificationMessage.sspWxAppId = this.Q;
            notificationMessage.sspWmOriginId = this.R;
            notificationMessage.sspWmType = this.S;
            notificationMessage.isWmDeepLink = this.T;
            notificationMessage.inAppMsgTitle = this.ay;
            notificationMessage.inAppMsgContentBody = this.az;
            notificationMessage.inAppMsgType = this.aA;
            notificationMessage.inAppMsgShowType = this.aB;
            notificationMessage.inAppMsgShowPos = this.aC;
            notificationMessage.inAppType = this.bn;
            if (JPushConstants.SDK_VERSION_CODE >= 408) {
                notificationMessage.notificationNormalSmallIcon = this.J;
            }
        } catch (Throwable th) {
            Logger.w("PushEntity", "pushEntry toNotificationMessage error" + th.getMessage());
        }
        return notificationMessage;
    }

    public String c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", this.a);
            jSONObject.put("senderId", this.b);
            jSONObject.put("messageId", this.c);
            jSONObject.put("_j_data_", this.f);
            jSONObject.put("notificationId", this.d);
            jSONObject.put("messageType", this.e);
            jSONObject.put("overrideMessageId", this.g);
            jSONObject.put("messageVersion", this.i);
            jSONObject.put("notificationOnly", this.j);
            jSONObject.put("notificationBuilderId", this.k);
            jSONObject.put("notificationType", this.l);
            jSONObject.put("message", this.m);
            jSONObject.put("contentType", this.n);
            jSONObject.put("title", this.o);
            jSONObject.put("extras", this.p);
            jSONObject.put("type", this.q);
            jSONObject.put("isFullScreen", this.r);
            jSONObject.put("notificationRemoveMode", this.s);
            jSONObject.put("notificationTitle", this.t);
            jSONObject.put("notificationAppName", this.u);
            jSONObject.put("notificationContent", this.v);
            jSONObject.put("notificationStyle", this.w);
            jSONObject.put("notificationBigText", this.x);
            jSONObject.put("notificationBigPicPath", this.y);
            jSONObject.put("notificationInbox", this.z);
            jSONObject.put("notificationPriority", this.A);
            jSONObject.put("notificationCategory", this.B);
            jSONObject.put("notificationExtra", this.C);
            jSONObject.put("notificationAlertType", this.D);
            jSONObject.put("notificationChannelId", this.E);
            jSONObject.put("displayForeground", this.F);
            jSONObject.put(ShareConstants.FEED_SOURCE_PARAM, this.G);
            jSONObject.put("smallIcon", this.H);
            jSONObject.put("largeIcon", this.I);
            jSONObject.put("normalSmallIcon", this.J);
            jSONObject.put("deeplink", this.K);
            jSONObject.put("failedAction", this.L);
            jSONObject.put("failedLink", this.M);
            jSONObject.put("targetPkgName", this.N);
            jSONObject.put("deeplinkBuilderId", this.P);
            jSONObject.put("isRichPush", this.U);
            jSONObject.put("showUrl", this.V);
            jSONObject.put("showTitle", this.W);
            jSONObject.put("_webPagePath", this.X);
            jSONObject.put("jumpMode", this.Y);
            jSONObject.put("richType", this.Z);
            jSONObject.put("showMode", this.aa);
            jSONObject.put("showResourceList", i.a(this.ab, ","));
            jSONObject.put("fromNum", this.ac);
            jSONObject.put("toNum", this.ad);
            jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, (int) this.ae);
            jSONObject.put("badgeAddNum", this.af);
            jSONObject.put("geofenceid", this.ag);
            jSONObject.put("radius", this.ah);
            jSONObject.put("status", this.ai);
            jSONObject.put("repeat", this.aj);
            jSONObject.put("hasShow", this.ak);
            jSONObject.put("expiration", this.al);
            jSONObject.put("longitude", this.am);
            jSONObject.put("latitude", this.an);
            jSONObject.put("lastGeoStatus", this.ao);
            jSONObject.put("developerArg0", this.ap);
            jSONObject.put(RemoteMessageConst.Notification.SOUND, this.aq);
            jSONObject.put("showBeginTime", this.ar);
            jSONObject.put("showEndTime", this.as);
            jSONObject.put("isWmDeepLink", this.T);
            jSONObject.put("wxAppId", this.Q);
            jSONObject.put("miniOriginid", this.R);
            jSONObject.put("miniType", this.S);
            jSONObject.put("inAppMsgContent", this.ax);
            jSONObject.put("inAppIntent", this.aw);
            jSONObject.put("inAppMsgTitle", this.ay);
            jSONObject.put("inAppMsgContentBody", this.az);
            jSONObject.put("inAppMsgType", this.aA);
            jSONObject.put("inAppMsgShowType", this.aB);
            jSONObject.put("inAppMsgShowPos", this.aC);
            jSONObject.put("inAppMsgShowAniAction", this.aD);
            jSONObject.put("inSupportNotifyAni", this.bk);
            jSONObject.put("inSupportVibration", this.bl);
            jSONObject.put("inAppIcon", this.bm);
            jSONObject.put("inAppMsgDismissAniAction", this.aE);
            jSONObject.put("inAppMsgShowBackground", this.aF);
            jSONObject.put("inAppMsgAllowIntercept", this.aG);
            jSONObject.put("inAppMsgFilterMsg", this.aH);
            jSONObject.put("inAppMsgPicPath", this.aI);
            jSONObject.put("inAppMsgCountLmt", this.aJ);
            jSONObject.put("inAppMsgGap", this.aK);
            jSONObject.put("inAppMsgToUser", this.aL);
            jSONObject.put("inAppMsgDelayDisplayTime", this.aM);
            jSONObject.put("inAppMsgReportPageName", this.aN);
            jSONObject.put("inAppUseSysAlert", this.aO);
            jSONObject.put("inAppMsgBackgroundColor", this.aP);
            jSONObject.put("inAppMsgTitleColor", this.aQ);
            jSONObject.put("inAppMsgContentColor", this.aR);
            jSONObject.put("inAppMsgTitleSize", this.aS);
            jSONObject.put("inAppMsgContentSize", this.aT);
            jSONObject.put("inAppMsgCircularSize", this.aU);
            jSONObject.put("inAppMsgShowTime", this.aV);
            jSONObject.put("inAppMsgShowElapseTime", this.aW);
            jSONObject.put("inAppMsgDismissElapseTime", this.aX);
            jSONObject.put("inAppWebPageUrl", this.aY);
            jSONObject.put("inAppProtocolVer", this.aZ);
            jSONObject.put("inAppSSPGap", this.bj);
            jSONObject.put("inAppCheckIntent", this.ba);
            jSONObject.put("inAppTplContent", this.bb);
            jSONObject.put("inAppTplId", this.bc);
            jSONObject.put("inAppTplUrl", this.bd);
            jSONObject.put("inAppMarginY", this.be);
            jSONObject.put("inAppTplData", this.bf);
            jSONObject.put("inAppIntentActions", this.bg);
            jSONObject.put("inAppShowResList", i.a(this.bh, ","));
            jSONObject.put("inAppType", this.bn);
            jSONObject.put("notifyInAppEndTime", this.at);
            jSONObject.put("notifyInAppCacheNumb", this.au);
            jSONObject.put("notifyInAppMsgType", this.av);
            jSONObject.put("inAppPriority", this.bo);
            jSONObject.put("inAppIsDisplayDirect", this.bp);
            jSONObject.put("inAppFixed", this.bq);
            jSONObject.put("inAppBlackConf", this.br);
            jSONObject.put("inAppAnimatorConf", this.bs);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String toString() {
        return "PushEntity{appId='" + this.a + "', senderId='" + this.b + "', messageId='" + this.c + "', jData='" + this.f + "', notificationId=" + this.d + ", messageType=" + this.e + ", overrideMessageId='" + this.g + "', originalMessage='" + this.h + "', messageVersion=" + this.i + ", notificationOnly=" + this.j + ", notificationBuilderId=" + this.k + ", notificationType=" + this.l + ", message='" + this.m + "', contentType='" + this.n + "', title='" + this.o + "', extras='" + this.p + "', type=" + this.q + ", isFullScreen=" + this.r + ", notificationRemoveMode=" + this.s + ", notificationTitle='" + this.t + "', notificationAppName='" + this.u + "', notificationContent='" + this.v + "', notificationStyle=" + this.w + ", notificationBigText='" + this.x + "', notificationBigPicPath='" + this.y + "', notificationInbox='" + this.z + "', notificationPriority=" + this.A + ", notificationCategory='" + this.B + "', notificationExtra='" + this.C + "', notificationAlertType=" + this.D + ", notificationChannelId='" + this.E + "', displayForeground='" + this.F + "', source='" + this.G + "', smallIcon='" + this.H + "', largeIcon='" + this.I + "', normalSmallIcon='" + this.J + "', deeplink='" + this.K + "', failedAction=" + this.L + ", failedLink='" + this.M + "', targetPkgName='" + this.N + "', deeplinkBuilderId=" + this.P + ", isRichPush=" + this.U + ", showUrl='" + this.V + "', showTitle='" + this.W + "', _webPagePath='" + this.X + "', jumpMode=" + this.Y + ", richType=" + this.Z + ", showMode=" + this.aa + ", showResourceList=" + this.ab + ", fromNum='" + this.ac + "', toNum='" + this.ad + "', platform=" + ((int) this.ae) + ", badgeAddNum=" + this.af + ", geofenceid='" + this.ag + "', radius=" + this.ah + ", status='" + this.ai + "', repeat=" + this.aj + ", hasShow=" + this.ak + ", expiration=" + this.al + ", longitude=" + this.am + ", latitude=" + this.an + ", lastGeoStatus='" + this.ao + "', developerArg0='" + this.ap + "', sound='" + this.aq + "', showBeginTime='" + this.ar + "', showEndTime='" + this.as + "', inAppMsgContent='" + this.ax + "', inAppIntent='" + this.aw + ", inAppWebPageUrl = '" + this.aY + "', inAppProtocolVer = '" + this.aZ + "', inAppSSPGap = '" + this.bj + "', inAppCheckIntent = '" + this.ba + "', inAppTplContent = '" + this.bb + "', inAppTplId = '" + this.bc + "', inAppTplUrl = '" + this.bd + "', inAppMarginY  = '" + this.be + "', inAppTplData = '" + this.bf + "', inAppIntentActions = '" + this.bg + "', inAppType= '" + this.bn + "', notifyInAppEndTime= '" + this.at + "', notifyInAppEndTime= '" + this.au + "', notifyInAppMsgType= '" + this.av + "', inAppPriority= '" + this.bo + "', inAppIsDisplayDirect= '" + this.bp + "', inAppFixed= '" + this.bq + "', inAppBlackConf= '" + this.br + "', inAppAnimatorConf= '" + this.bs + "'}";
    }
}
