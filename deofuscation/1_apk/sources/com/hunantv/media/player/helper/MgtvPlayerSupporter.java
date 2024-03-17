package com.hunantv.media.player.helper;

import android.os.Build;
import com.hunantv.media.config.NetPlayConfig;
import com.hunantv.media.global.MgtvPlayerCapabilities;
import com.hunantv.media.player.pragma.DebugLog;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgtvPlayerSupporter {
    private static final String DEFAULT_MAX_SPEED = "2.0";
    public static final float DEFAULT_MAX_SPEED_FLOAT = 2.0f;
    private static final String TAG = "MgtvPlayerSupporter";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum CODECTYPE {
        HEVC,
        AVC,
        OTHER
    }

    private static String getDeviceSupportMaxSpeed() {
        if (NetPlayConfig.isHightSpeedEnable()) {
            int hEVC1080PMaxFps = MgtvPlayerCapabilities.getHEVC1080PMaxFps();
            int i = hEVC1080PMaxFps / 25;
            DebugLog.i(TAG, "[getDeviceSupportMaxSpeed]: hevc_1080p_fps=" + hEVC1080PMaxFps + ", hevc_1080p_max_speed:" + i + ", NetPlayConfig.getPlayMaxSpeedType=" + NetPlayConfig.getPlayMaxSpeedType());
            if (i < 3) {
                return DEFAULT_MAX_SPEED;
            }
            int playMaxSpeedType = NetPlayConfig.getPlayMaxSpeedType();
            if (playMaxSpeedType != 1) {
                if (playMaxSpeedType != 2) {
                    return DEFAULT_MAX_SPEED;
                }
                if (i >= 4) {
                    return "4.0";
                }
            }
            return "3.0";
        }
        return DEFAULT_MAX_SPEED;
    }

    private static float getDeviceSupportMaxSpeedExt(int i, int i2, float f, CODECTYPE codectype, boolean z) {
        DebugLog.i(TAG, "[getDeviceSupportMaxSpeedExt]: videoWidth :" + i + " videoHeight:" + i2 + " vfps:" + f + " codectype:" + codectype + " isAudio:" + z + " NetPlayConfig.isHightSpeedEnable:" + NetPlayConfig.isHightSpeedEnable() + " NetPlayConfig.getPlayMaxSpeedType:" + NetPlayConfig.getPlayMaxSpeedType());
        if (NetPlayConfig.isHightSpeedEnable()) {
            if (z) {
                int playMaxSpeedType = NetPlayConfig.getPlayMaxSpeedType();
                if (playMaxSpeedType != 1) {
                    return playMaxSpeedType != 2 ? 2.0f : 4.0f;
                }
                return 3.0f;
            } else if (f <= 0.0f) {
                return 2.0f;
            } else {
                CODECTYPE codectype2 = CODECTYPE.HEVC;
                if (codectype == codectype2 || codectype == CODECTYPE.AVC) {
                    float hEVC4KMaxFps = (Math.min(i, i2) > 1080 ? codectype == codectype2 ? MgtvPlayerCapabilities.getHEVC4KMaxFps() : MgtvPlayerCapabilities.getAVC4KMaxFps() : codectype == codectype2 ? MgtvPlayerCapabilities.getHEVC1080PMaxFps() : MgtvPlayerCapabilities.getAVC1080PMaxFps()) / f;
                    if (hEVC4KMaxFps < 3.0f) {
                        return 2.0f;
                    }
                    int playMaxSpeedType2 = NetPlayConfig.getPlayMaxSpeedType();
                    if (playMaxSpeedType2 != 1) {
                        if (playMaxSpeedType2 != 2) {
                            return 2.0f;
                        }
                        if (hEVC4KMaxFps >= 4.0f) {
                            return 4.0f;
                        }
                    }
                    return 3.0f;
                }
                return 2.0f;
            }
        }
        return 2.0f;
    }

    public static String getMaxSpeed() {
        if (Build.VERSION.SDK_INT < 24) {
            return DEFAULT_MAX_SPEED;
        }
        String deviceSupportMaxSpeed = getDeviceSupportMaxSpeed();
        DebugLog.i(TAG, "getMaxSpeed:" + deviceSupportMaxSpeed);
        return deviceSupportMaxSpeed;
    }

    public static float getMaxSpeedExt(int i, int i2, float f, CODECTYPE codectype, boolean z) {
        float deviceSupportMaxSpeedExt = Build.VERSION.SDK_INT >= 24 ? getDeviceSupportMaxSpeedExt(i, i2, f, codectype, z) : 2.0f;
        DebugLog.i(TAG, "chodison getMaxSpeedExt: maxSpeed :" + deviceSupportMaxSpeedExt);
        return deviceSupportMaxSpeedExt;
    }

    public static String getMinSpeed() {
        return Build.VERSION.SDK_INT >= 23 ? "0.25" : "0.5";
    }
}
