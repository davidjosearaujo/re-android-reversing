package com.huawei.android.hms.pps;

import android.content.Context;
import androidx.annotation.Keep;

@Keep
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AdvertisingIdClient {

    @Keep
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class Info {
        @Keep
        private final String advertisingId;
        @Keep
        private final boolean limitAdTrackingEnabled;

        @Keep
        public Info(String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z;
        }

        @Keep
        public final native String getId();

        @Keep
        public final native boolean isLimitAdTrackingEnabled();
    }

    @Keep
    public static native Info getAdvertisingIdInfo(Context context);

    @Keep
    private static native String getTag();
}
