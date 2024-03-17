package com.hunantv.imgo.activity.inter.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.hunantv.oversea.login.compat.ImgoLoginDataProvider;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import j.l.a.b0.d;
import j.l.a.b0.o0;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    private static final String b = "WXEntryActivity";
    private IWXAPI a;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(2131558457);
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this, d.g("weixin.apk.key"), false);
        this.a = createWXAPI;
        createWXAPI.handleIntent(getIntent(), this);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.a.handleIntent(getIntent(), this);
    }

    public void onReq(BaseReq baseReq) {
    }

    public void onResp(BaseResp baseResp) {
        try {
            if (baseResp == null) {
                return;
            }
            try {
                if (baseResp.getType() == 1) {
                    if (baseResp.errCode == 0 && (baseResp instanceof SendAuth.Resp)) {
                        SendAuth.Resp resp = (SendAuth.Resp) baseResp;
                        String str = resp.code;
                        ImgoLoginDataProvider.t(str);
                        if (TextUtils.isEmpty(str)) {
                            o0.o(getString(2131886780, new Object[]{((BaseResp) resp).errStr, String.valueOf(((BaseResp) resp).errCode)}));
                        }
                    }
                } else {
                    baseResp.getType();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            finish();
        }
    }
}
