package com.hunantv.mpdt.statistics.vip;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import com.hunantv.imgo.net.RequestParams;
import com.mgtv.json.JsonInterface;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class VipBuyEvent extends j.l.b.e.a {
    public static final String e = "first_load";
    public static final String f = "overrideUrl";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class a {
        public static final int a = 0;
        public static final int b = 1;
    }

    private VipBuyEvent(@NonNull Context context) {
        super(context);
    }

    @NonNull
    public static VipBuyEvent d(@NonNull Context context) {
        return new VipBuyEvent(context);
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("club.mgtv.com") || str.contains("lego.mgtv.com");
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        OuterJson outerJson = new OuterJson();
        outerJson.act = "cancel";
        outerJson.value = str;
        h(outerJson);
    }

    public void f(String str, String str2, boolean z) {
        if (e(str)) {
            OuterJson outerJson = new OuterJson();
            if (z) {
                outerJson.act = "load_url_fail";
            } else {
                outerJson.act = "load_url";
            }
            try {
                outerJson.value = URLEncoder.encode("0", "UTF-8");
                outerJson.load_url = URLEncoder.encode(str, "UTF-8");
                outerJson.msg = URLEncoder.encode(str2, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            h(outerJson);
        }
    }

    public void g(int i, String str, String str2, String str3, String str4, String str5) {
        OuterJson outerJson = new OuterJson();
        outerJson.act = "pullsdk";
        if (i != 0) {
            str5 = String.valueOf(i);
        }
        outerJson.value = str5;
        outerJson.msg = str;
        outerJson.pid = str2;
        outerJson.channel = str3;
        outerJson.payurl = str4;
        h(outerJson);
    }

    public void h(@Nullable OuterJson outerJson) {
        if (outerJson == null) {
            return;
        }
        try {
            RequestParams b = VipEventHelper.b(((j.l.b.e.a) this).c);
            Map<String, String> map = outerJson.toMap();
            for (String str : map.keySet()) {
                b.put(str, map.get(str));
            }
            ((j.l.b.e.a) this).a.b("https://vip.log.mgtv.com/buy_event.html", b);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class OuterJson implements JsonInterface {
        private static final long serialVersionUID = -7783613792803355373L;
        public String act;
        public String channel;
        public String load_url;
        public String msg;
        public String payurl;
        public String pid;
        public String source;
        public String value;

        public OuterJson encode() {
            this.msg = encode(this.msg);
            this.payurl = encode(this.payurl);
            return this;
        }

        @NonNull
        public Map<String, String> toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("act", this.act);
            hashMap.put(SDKConstants.PARAM_VALUE, this.value);
            hashMap.put("msg", this.msg);
            hashMap.put("pid", this.pid);
            hashMap.put("channel", this.channel);
            hashMap.put("payurl", this.payurl);
            hashMap.put(ShareConstants.FEED_SOURCE_PARAM, this.source);
            if (!TextUtils.isEmpty(this.load_url)) {
                hashMap.put("load_url", this.load_url);
            }
            return hashMap;
        }

        @Nullable
        private String encode(@Nullable String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }
    }
}
