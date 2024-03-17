package com.huawei.hms.support.api.push;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PushException extends RuntimeException {
    public static final String EXCEPTION_SEND_FAILED = "send message failed";

    public PushException() {
    }

    public PushException(String str, Throwable th) {
        super(str, th);
    }

    public PushException(String str) {
        super(str);
    }

    public PushException(Throwable th) {
        super(th);
    }
}
