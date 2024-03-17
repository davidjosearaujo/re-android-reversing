package com.alipay.sdk.app;

import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public enum c {
    SUCCEEDED(9000, "处理成功"),
    FAILED(OpenAuthTask.SYS_ERR, "系统繁忙，请稍后再试"),
    CANCELED(AuthCode.StatusCode.WAITING_CONNECT, "用户取消"),
    NETWORK_ERROR(AuthCode.StatusCode.AUTH_INFO_NOT_EXIST, "网络连接异常"),
    PARAMS_ERROR(OpenAuthTask.NOT_INSTALLED, "参数错误"),
    DOUBLE_REQUEST(OpenAuthTask.Duplex, "重复请求"),
    PAY_WAITTING(JosStatusCodes.RTN_CODE_COMMON_ERROR, "支付结果确认中");
    
    public int a;
    public String b;

    c(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public void a(int i) {
        this.a = i;
    }

    public int b() {
        return this.a;
    }

    public static c b(int i) {
        if (i != 4001) {
            if (i != 5000) {
                if (i != 8000) {
                    if (i != 9000) {
                        if (i != 6001) {
                            if (i != 6002) {
                                return FAILED;
                            }
                            return NETWORK_ERROR;
                        }
                        return CANCELED;
                    }
                    return SUCCEEDED;
                }
                return PAY_WAITTING;
            }
            return DOUBLE_REQUEST;
        }
        return PARAMS_ERROR;
    }

    public void a(String str) {
        this.b = str;
    }

    public String a() {
        return this.b;
    }
}
