package com.huawei.hms.support.feature.result;

import android.text.TextUtils;
import com.huawei.hms.common.api.CommonStatusCodes;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class AbstractAuthResultCode extends CommonStatusCodes {
    public static final int RESULT_CODE_CANCELLED = 2012;
    public static final int RESULT_CODE_EXECUTING = 2013;
    public static final int RESULT_CODE_FAILED = 2014;
    public static final int SIGN_IN_JSONEXCEPTION = 2015;
    private static final Map<Integer, String> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(2012, "Auth canceled by subscriber");
        hashMap.put(2013, "Auth executing");
        hashMap.put(2014, "An unrecoverable auth failure occurred");
    }

    public static String getResultDescription(int i) {
        String str = a.get(Integer.valueOf(i));
        if (TextUtils.isEmpty(str)) {
            return "unknown status code: " + i;
        }
        return str;
    }
}
