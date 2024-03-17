package cn.jiguang.g;

import cn.jiguang.internal.JConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a<T> {
    public static String a = "cn.jiguang.sdk.share.profile";
    public static String b = "cn.jpush.preferences.v2";
    public String c;
    public String d;
    public T e;
    public boolean f;
    public boolean g;

    public a(String str, String str2, T t) {
        this.c = str;
        this.d = str2;
        if (t == null) {
            throw new IllegalArgumentException("default value can not be null");
        }
        this.e = t;
    }

    public static a<Boolean> A() {
        return new a<>("cn.jpush.android.user.profile", "is_tcp_close", Boolean.FALSE);
    }

    public static a<Integer> B() {
        return new a("cn.jpush.android.user.profile", "jpush_register_code", -1).U();
    }

    public static a<String> C() {
        return new a<>(b, "device_config_appkey", "");
    }

    public static a<String> D() {
        return new a<>(b, "i_new", "");
    }

    public static a<String> E() {
        return new a<>(b, "push_udid", "");
    }

    public static a<String> F() {
        return new a<>(b, "last_connection_type", "");
    }

    public static a<String> G() {
        return new a(b, "sis_report_history", "").V();
    }

    public static a<Long> H() {
        return new a<>("cn.jpush.preferences.v2.rid", "next_rid", -1L);
    }

    public static a<Integer> I() {
        return new a<>("cn.jpush.preferences.v2.rid", "seq_id", -1);
    }

    public static a<String> J() {
        return new a("cn.jiguang.sdk.address", "ips_in_last_good_sis", "").V();
    }

    public static a<String> K() {
        return new a("cn.jiguang.sdk.address", "ssl_ips_in_last_good_sis", "").V();
    }

    public static a<Boolean> L() {
        return new a<>("cn.jiguang.sdk.address", "udp_data_report", Boolean.FALSE);
    }

    public static a<Long> M() {
        return new a<>("cn.jiguang.sdk.address", "sis_last_update", 0L);
    }

    public static a<Long> N() {
        return new a<>("cn.jiguang.sdk.address", "last_sis_report_time", 0L);
    }

    public static a<String> O() {
        return new a("cn.jiguang.sdk.address", "default_sis_ips", "").V();
    }

    public static a<String> P() {
        return new a("cn.jiguang.sdk.address", "default_conn", "").V();
    }

    public static a<String> Q() {
        return new a("cn.jiguang.sdk.address", "default_conn_srv", "").V();
    }

    public static a<String> R() {
        return (a<T>) new a("cn.jiguang.sdk.address", "tcp_report", "").U().V();
    }

    public static a<String> S() {
        return new a<>("PrefsFile", SDKConstants.PARAM_KEY, "");
    }

    public static a<Integer> T() {
        return new a<>("WakeViolation", "violation_count", 0);
    }

    private a<T> U() {
        this.f = true;
        return this;
    }

    private a<T> V() {
        this.g = true;
        return this;
    }

    public static a<String> a() {
        return new a("cn.jpush.android.user.profile", "devcie_id_generated", "").U();
    }

    public static a<String> a(String str) {
        return new a<>("cn.jpush.android.user.profile", "sdk_version_" + str, "");
    }

    public static a<String> a(boolean z) {
        return (a<T>) new a("cn.jiguang.sdk.address", z ? "default_https_report" : "default_http_report", "").U().V();
    }

    public static a<Boolean> b() {
        return new a<>("cn.jpush.android.user.profile", "upload_crash", Boolean.TRUE);
    }

    public static a<String> b(String str) {
        return new a("cn.jiguang.sdk.address", "dns_" + str, "").V();
    }

    public static a<String> b(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("last_good_sis_address");
        sb.append(z ? "_V4" : "_V6");
        return new a("cn.jiguang.sdk.address", sb.toString(), "").V();
    }

    public static a<Long> c() {
        return new a("cn.jiguang.sdk.user.profile", "key_uid", 0L).U();
    }

    public static a<Long> c(String str) {
        return new a<>("cn.jiguang.sdk.address", "dns_last_update_" + str, 0L);
    }

    public static a<String> c(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("last_good_conn");
        sb.append(z ? "_V4" : "_V6");
        return new a("cn.jiguang.sdk.address", sb.toString(), "").V();
    }

    public static a<String> d() {
        return new a("cn.jiguang.sdk.user.profile", "key_rid", "").U();
    }

    public static a<String> d(String str) {
        return new a("cn.jiguang.sdk.address", "srv_" + str, "").V();
    }

    public static a<String> d(boolean z) {
        return (a<T>) new a("cn.jiguang.sdk.address", z ? "default_https_report" : "default_http_report", "").U().V();
    }

    public static a<String> e() {
        return new a("cn.jiguang.sdk.user.profile", "key_pwd", "").U();
    }

    public static a<Long> e(String str) {
        return new a<>("cn.jiguang.sdk.address", "srv_last_update_" + str, 0L);
    }

    public static a<Integer> f() {
        return new a("cn.jiguang.sdk.user.profile", "idc", -1).U();
    }

    public static a<String> f(String str) {
        return new a("IpInfos", str, "").V();
    }

    public static a<Long> g() {
        return new a<>("cn.jiguang.sdk.user.profile", "login_local_time", -1L);
    }

    public static a<Integer> g(String str) {
        return new a<>("netinfo", str, 0);
    }

    public static a<Long> h() {
        return new a<>("cn.jiguang.sdk.user.profile", "login_server_time", -1L);
    }

    public static a<String> i() {
        return new a(a, "key_share_process_uuid", "").U();
    }

    public static a<Long> j() {
        return new a(a, "key_share_process_uuid_creattime", -1L).U();
    }

    public static a<Integer> k() {
        return new a(a, "sp_state", -1).U();
    }

    public static a<String> l() {
        return new a<>("cn.jiguang.sdk.user.set.profile", "option_channel", "");
    }

    public static a<String> m() {
        return new a<>("cn.jiguang.sdk.user.set.profile", "analytics_account_id", "");
    }

    public static a<Boolean> n() {
        return new a<>("cn.jiguang.sdk.user.set.profile", "is_ups_register", Boolean.TRUE);
    }

    public static a<Long> o() {
        return new a<>("Push_Page_Config", "css", 0L);
    }

    public static a<Long> p() {
        return new a<>("Push_Page_Config", "cse", 0L);
    }

    public static a<Long> q() {
        return new a<>("Push_Page_Config", "last_pause", -1L);
    }

    public static a<String> r() {
        return new a<>("Push_Page_Config", SDKAnalyticsEvents.PARAMETER_SESSION_ID, "");
    }

    public static a<String> s() {
        return new a("cn.jiguang.sdk.report", "report_urls", "").V();
    }

    public static a<String> t() {
        return new a("cn.jiguang.sdk.report", "report_sis_urls", "").V();
    }

    public static a<Long> u() {
        return new a<>("cn.jiguang.sdk.report", "last_update_report_urls", 0L);
    }

    public static a<Long> v() {
        return new a<>("cn.jiguang.sdk.report", "report_urls_ttl_millis", Long.valueOf((long) JConstants.HOUR));
    }

    public static a<String> w() {
        return new a(b, HianalyticsBaseData.SDK_VERSION, "").U();
    }

    public static a<Long> x() {
        return new a<>(b, "first_init", 0L);
    }

    public static a<Long> y() {
        return new a<>(b, "lbs_delay", 0L);
    }

    public static a<Boolean> z() {
        return new a<>(b, "jcore_lbs_enable", Boolean.TRUE);
    }

    public a<T> a(T t) {
        this.e = t;
        return this;
    }

    public a<T> h(String str) {
        this.c = str;
        return this;
    }

    public a<T> i(String str) {
        this.d = str;
        return this;
    }
}
