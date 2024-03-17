package com.hunantv.media.config;

import c.a.a.b.d.g;
import com.alipay.sdk.widget.c;
import com.hunantv.media.player.helper.MediaCodecHelp;
import com.hunantv.media.player.utils.StringUtil;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class NetPlayConfigHelper {
    public static String getApiVersion() {
        return c.d;
    }

    public static String getCputy() {
        try {
            return StringUtil.removeSpace(StringUtil.safeToLowerCase(g.c()));
        } catch (Exception e) {
            e.printStackTrace();
            return "err";
        }
    }

    public static String getMod() {
        try {
            return StringUtil.removeSpace(g.m());
        } catch (Exception e) {
            e.printStackTrace();
            return "err";
        }
    }

    public static String getOmxcn() {
        try {
            String h265Decoder = MediaCodecHelp.getH265Decoder(false);
            if (h265Decoder == null) {
                h265Decoder = "un";
            }
            return StringUtil.removeSpace(h265Decoder);
        } catch (Exception e) {
            e.printStackTrace();
            return "err";
        }
    }
}
