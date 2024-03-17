package com.hunantv.media.player.libnative;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ImgoVsrApi {
    private static ImgovsrDeviceInfo imgovsrDeviceInfo;

    private static native boolean _imgovsr_is_supported();

    private static native ImgovsrDeviceInfo getDeviceinfoFromImgoVsrApi();

    public static ImgovsrDeviceInfo getVsrDeviceinfo() {
        return imgovsrDeviceInfo;
    }

    public static native String imgovsr_get_npu_version();

    public static native String imgovsr_get_version();

    public static native String imgovsr_get_vulkan_version();

    public static boolean imgovsr_is_supported() {
        return _imgovsr_is_supported();
    }

    public static void updateVsrDeviceinfo() {
        if (imgovsrDeviceInfo == null) {
            imgovsrDeviceInfo = getDeviceinfoFromImgoVsrApi();
        }
    }
}
