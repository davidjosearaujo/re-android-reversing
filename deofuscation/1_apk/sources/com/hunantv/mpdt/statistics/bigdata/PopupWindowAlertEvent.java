package com.hunantv.mpdt.statistics.bigdata;

import android.content.Context;
import android.text.TextUtils;
import com.hunantv.imgo.net.RequestParams;
import com.hunantv.mpdt.data.EventClickData;
import com.mgtv.json.JsonInterface;
import j.l.a.b0.e;
import j.v.j.b;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PopupWindowAlertEvent extends j.l.b.e.a {

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class AlertValue implements JsonInterface {
        private static final long serialVersionUID = 7927864260130900532L;
        public String cpn;
        public int evt;

        public AlertValue(String str, int i) {
            this.cpn = str;
            this.evt = i;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a {
        public static final int a = 2;
        public static final int b = 3;
        public static final int c = 4;
    }

    public PopupWindowAlertEvent(Context context) {
        super(context);
    }

    public static PopupWindowAlertEvent c(Context context) {
        return new PopupWindowAlertEvent(context);
    }

    public String a() {
        return !e.W0() ? "https://aphone.v1.mgtv.com/dispatcher.do" : "https://hd-mobile-v1.log.mgtv.com/dispatcher.do";
    }

    public void d(String str, int i) {
        if (TextUtils.isEmpty(str) && i == 0) {
            return;
        }
        RequestParams createRequestParams = new EventClickData(EventClickData.a.v, "", b.e(new AlertValue(str, i), AlertValue.class)).createRequestParams();
        createRequestParams.put("bid", "2.1.8");
        ((j.l.b.e.a) this).a.n(a(), createRequestParams);
    }
}
