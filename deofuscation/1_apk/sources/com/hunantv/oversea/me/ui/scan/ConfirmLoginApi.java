package com.hunantv.oversea.me.ui.scan;

import android.os.Bundle;
import com.google.auto.service.AutoService;
import com.hunantv.oversea.me.ui.scan.ui.MeCaptureWebActivity;
import com.hunantv.oversea.xweb.BaseXWebActivity;
import com.hunantv.oversea.xweb.jsapi.BaseApi;
import com.hunantv.oversea.xweb.jsapi.IApi;
import j.l.c.i0.d0.b;
import j.l.c.i0.i0.h0;

@AutoService({IApi.class})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ConfirmLoginApi extends BaseApi {
    private void confirmLogin(String str, b bVar) {
        h0.b("ConfirmLoginApi", "confirmLogin() json = " + str);
        bVar.a("");
        BaseXWebActivity activity = getActivity();
        if (activity instanceof MeCaptureWebActivity) {
            ((MeCaptureWebActivity) activity).sendMessage(17);
        }
    }

    public String[] apis() {
        return new String[]{"confirmLogin"};
    }

    public void invoke(String str, String str2, b bVar, Bundle bundle) {
        str.hashCode();
        if (str.equals("confirmLogin")) {
            confirmLogin(str2, bVar);
        }
    }
}
