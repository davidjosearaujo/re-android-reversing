package com.hunantv.mpdt.data;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.hunantv.imgo.net.RequestParams;
import j.l.a.a;
import java.net.URLEncoder;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class NewStartUpData extends NewCommonData {
    private static final long serialVersionUID = 6438779537043909522L;
    public String lob;
    public String mod;
    public String pix;

    public NewStartUpData() {
        DisplayMetrics displayMetrics = a.a().getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        this.pix = i2 + "," + i;
    }

    @Override // com.hunantv.mpdt.data.NewCommonData
    public RequestParams createBaseRequestParams() {
        RequestParams createBaseRequestParams = super.createBaseRequestParams();
        createBaseRequestParams.put("logtype", "st");
        createBaseRequestParams.put("mod", this.mod);
        createBaseRequestParams.put("pix", this.pix);
        createBaseRequestParams.put("lob", TextUtils.isEmpty(this.lob) ? "" : URLEncoder.encode(this.lob));
        createBaseRequestParams.put("bid", "30.1.3");
        return createBaseRequestParams;
    }

    public String getLob() {
        return this.lob;
    }

    public String getMod() {
        return this.mod;
    }

    public void setLob(String str) {
        this.lob = str;
    }

    public void setMod(String str) {
        this.mod = str;
    }
}
