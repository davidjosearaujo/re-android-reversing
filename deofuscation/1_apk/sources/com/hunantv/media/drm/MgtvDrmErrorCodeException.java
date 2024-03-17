package com.hunantv.media.drm;

import com.intertrust.wasabi.ErrorCodeException;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgtvDrmErrorCodeException extends Exception {
    private int errorCode;
    private ErrorCodeException exception;

    public MgtvDrmErrorCodeException(int i) {
        this.errorCode = -999;
        this.errorCode = i;
    }

    public MgtvDrmErrorCodeException(ErrorCodeException errorCodeException) {
        this.errorCode = -999;
        this.exception = errorCodeException;
    }

    public int getErrorCode() {
        ErrorCodeException errorCodeException = this.exception;
        return errorCodeException != null ? errorCodeException.getErrorCode() : this.errorCode;
    }
}
