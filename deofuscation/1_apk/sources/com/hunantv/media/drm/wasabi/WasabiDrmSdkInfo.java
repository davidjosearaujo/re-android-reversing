package com.hunantv.media.drm.wasabi;

import com.hunantv.media.drm.MgtvDrmErrorCodeException;
import com.intertrust.wasabi.ErrorCodeException;
import com.intertrust.wasabi.drm.SdkInfo;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class WasabiDrmSdkInfo {
    public static int getVersion() throws MgtvDrmErrorCodeException {
        try {
            return SdkInfo.get().getVersion();
        } catch (ErrorCodeException e) {
            throw new MgtvDrmErrorCodeException(e);
        }
    }

    public static String getVersionMsg() throws MgtvDrmErrorCodeException {
        try {
            return SdkInfo.get().toString();
        } catch (ErrorCodeException e) {
            throw new MgtvDrmErrorCodeException(e);
        }
    }
}
