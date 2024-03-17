package com.hunantv.media.global;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.hunantv.media.config.NetPlayConfig;
import com.hunantv.media.player.helper.MediaCodecHelp;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.player.utils.Size;
import com.hunantv.media.utils.NumericUtil;
import java.util.ArrayList;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgtvPlayerCapabilities {
    private static AlphaCapabilities sAlphaCapabilities;
    public static ExDef sExDef = new ExDef();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class AlphaCapabilities {
        private Size h264MaxSize;
        private Size h265MaxSize;

        public AlphaCapabilities(ExDef exDef) {
            if (exDef != null) {
                try {
                    this.h264MaxSize = Size.parseSize(exDef.h264.sdr.max_def);
                    this.h265MaxSize = Size.parseSize(exDef.h265.sdr.max_def);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public Size getH264MaxSize() {
            return this.h264MaxSize;
        }

        public Size getH265MaxSize() {
            return this.h265MaxSize;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class ExDef {
        public H264 h264;
        public H265 h265;
        public String sceen_fps;
        public String sceen_size;
        public String screen_hdr_type;
        public String support = "1";
        public String support_wanos;

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class H264 {
            public String support = "0";
            public Sdr sdr = new Sdr();
            public Hdr hdr = new Hdr();

            public String toString() {
                return "H264{support='" + this.support + "', sdr=" + this.sdr + ", hdr=" + this.hdr + '}';
            }
        }

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class H265 {
            public String support = "0";
            public Sdr sdr = new Sdr();
            public Hdr hdr = new Hdr();

            public String toString() {
                return "H265{support='" + this.support + "', sdr=" + this.sdr + ", hdr=" + this.hdr + '}';
            }
        }

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class Hdr {
            public String support = "0";
            public String bit_depth = "10";
            public String max_def = "0x0";
            public String max_def_fps = "0";

            public String toString() {
                return "Hdr{support='" + this.support + "', bit_depth='" + this.bit_depth + "', max_def='" + this.max_def + "', max_def_fps='" + this.max_def_fps + "'}";
            }
        }

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class Sdr {
            public String max_def = "0x0";
            public String max_def_fps = "0";

            public String toString() {
                return "Sdr{max_def='" + this.max_def + "', max_def_fps='" + this.max_def_fps + "'}";
            }
        }

        public String toString() {
            return "ExDef{support='" + this.support + "', sceen_size='" + this.sceen_size + "', sceen_fps='" + this.sceen_fps + "', screen_hdr_type='" + this.screen_hdr_type + "', support_wanos='" + this.support_wanos + "', h264=" + this.h264 + ", h265=" + this.h265 + '}';
        }
    }

    public static synchronized void fillScreenInfo(Context context) {
        int[] supportedHdrTypes;
        synchronized (MgtvPlayerCapabilities.class) {
            if (context == null) {
                return;
            }
            ExDef exDef = sExDef;
            exDef.sceen_size = "0x0";
            exDef.sceen_fps = "0";
            exDef.screen_hdr_type = "0";
            exDef.support_wanos = NetPlayConfig.isWanosAudioInnerEnable() ? "1" : "0";
            try {
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                int i = Build.VERSION.SDK_INT;
                if (i >= 17) {
                    defaultDisplay.getRealMetrics(displayMetrics);
                } else {
                    defaultDisplay.getMetrics(displayMetrics);
                }
                int i2 = displayMetrics.widthPixels;
                int i3 = displayMetrics.heightPixels;
                sExDef.sceen_size = i2 + "x" + i3;
                sExDef.sceen_fps = ((int) defaultDisplay.getRefreshRate()) + "";
                if (i >= 24 && (supportedHdrTypes = defaultDisplay.getHdrCapabilities().getSupportedHdrTypes()) != null) {
                    for (int i4 : supportedHdrTypes) {
                        if (i4 == 2 || i4 == 4) {
                            sExDef.screen_hdr_type = "1";
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static int getAVC1080PMaxFps() {
        ArrayList<MediaCodecHelp.CodecPerformance> decoderPerformanceList = MediaCodecHelp.getDecoderPerformanceList();
        if (decoderPerformanceList != null) {
            for (int i = 0; i < decoderPerformanceList.size(); i++) {
                if (decoderPerformanceList.get(i).mimeType.equals(MediaCodecHelp.AMIME_VIDEO_AVC)) {
                    return NumericUtil.parseInt(decoderPerformanceList.get(i).max_fps_1080p);
                }
            }
        }
        return 0;
    }

    public static int getAVC4KMaxFps() {
        ArrayList<MediaCodecHelp.CodecPerformance> decoderPerformanceList = MediaCodecHelp.getDecoderPerformanceList();
        if (decoderPerformanceList != null) {
            for (int i = 0; i < decoderPerformanceList.size(); i++) {
                if (decoderPerformanceList.get(i).mimeType.equals(MediaCodecHelp.AMIME_VIDEO_AVC)) {
                    return NumericUtil.parseInt(decoderPerformanceList.get(i).max_fps_4k);
                }
            }
        }
        return 0;
    }

    public static synchronized AlphaCapabilities getAlphaCapabilities(Context context) {
        AlphaCapabilities alphaCapabilities;
        synchronized (MgtvPlayerCapabilities.class) {
            if (sAlphaCapabilities == null) {
                sAlphaCapabilities = new AlphaCapabilities(getExDef(context));
            }
            alphaCapabilities = sAlphaCapabilities;
        }
        return alphaCapabilities;
    }

    public static synchronized ExDef getExDef(Context context) {
        ExDef exDef;
        synchronized (MgtvPlayerCapabilities.class) {
            sExDef.support = NetPlayConfig.isExDefEnable() ? "1" : "0";
            ExDef exDef2 = sExDef;
            if (exDef2.sceen_size == null || exDef2.sceen_fps == null || exDef2.screen_hdr_type == null) {
                fillScreenInfo(context);
            }
            ExDef exDef3 = sExDef;
            if (exDef3.h264 == null) {
                exDef3.h264 = getH264Info();
            }
            ExDef exDef4 = sExDef;
            if (exDef4.h265 == null) {
                exDef4.h265 = getH265Info();
            }
            DebugLog.i("MgtvCore", "sExDef: " + sExDef.toString());
            exDef = sExDef;
        }
        return exDef;
    }

    public static synchronized ExDef.H264 getH264Info() {
        ExDef.H264 h264;
        synchronized (MgtvPlayerCapabilities.class) {
            h264 = new ExDef.H264();
            ArrayList<MediaCodecHelp.CodecPerformance> decoderPerformanceList = MediaCodecHelp.getDecoderPerformanceList();
            for (int i = 0; i < decoderPerformanceList.size(); i++) {
                if (decoderPerformanceList.get(i).mimeType.equals(MediaCodecHelp.AMIME_VIDEO_AVC)) {
                    h264.support = "1";
                    h264.sdr.max_def = decoderPerformanceList.get(i).max_def;
                    h264.sdr.max_def_fps = decoderPerformanceList.get(i).max_def_fps;
                    h264.hdr.support = (decoderPerformanceList.get(i).hdr_support && NetPlayConfig.isHdrOpen()) ? "1" : "0";
                    if ("1".equals(h264.hdr.support)) {
                        h264.hdr.max_def = decoderPerformanceList.get(i).max_def;
                        h264.hdr.max_def_fps = decoderPerformanceList.get(i).max_def_fps;
                    }
                }
            }
        }
        return h264;
    }

    public static synchronized ExDef.H265 getH265Info() {
        ExDef.H265 h265;
        synchronized (MgtvPlayerCapabilities.class) {
            h265 = new ExDef.H265();
            ArrayList<MediaCodecHelp.CodecPerformance> decoderPerformanceList = MediaCodecHelp.getDecoderPerformanceList();
            for (int i = 0; i < decoderPerformanceList.size(); i++) {
                if (decoderPerformanceList.get(i).mimeType.equals(MediaCodecHelp.AMIME_VIDEO_HEVC)) {
                    h265.support = "1";
                    h265.sdr.max_def = decoderPerformanceList.get(i).max_def;
                    h265.sdr.max_def_fps = decoderPerformanceList.get(i).max_def_fps;
                    h265.hdr.support = (decoderPerformanceList.get(i).hdr_support && NetPlayConfig.isHdrOpen()) ? "1" : "0";
                    if ("1".equals(h265.hdr.support)) {
                        h265.hdr.max_def = decoderPerformanceList.get(i).max_def;
                        h265.hdr.max_def_fps = decoderPerformanceList.get(i).max_def_fps;
                    }
                }
            }
        }
        return h265;
    }

    public static int getHEVC1080PMaxFps() {
        ArrayList<MediaCodecHelp.CodecPerformance> decoderPerformanceList = MediaCodecHelp.getDecoderPerformanceList();
        if (decoderPerformanceList != null) {
            for (int i = 0; i < decoderPerformanceList.size(); i++) {
                if (decoderPerformanceList.get(i).mimeType.equals(MediaCodecHelp.AMIME_VIDEO_HEVC)) {
                    return NumericUtil.parseInt(decoderPerformanceList.get(i).max_fps_1080p);
                }
            }
        }
        return 0;
    }

    public static int getHEVC4KMaxFps() {
        ArrayList<MediaCodecHelp.CodecPerformance> decoderPerformanceList = MediaCodecHelp.getDecoderPerformanceList();
        if (decoderPerformanceList != null) {
            for (int i = 0; i < decoderPerformanceList.size(); i++) {
                if (decoderPerformanceList.get(i).mimeType.equals(MediaCodecHelp.AMIME_VIDEO_HEVC)) {
                    return NumericUtil.parseInt(decoderPerformanceList.get(i).max_fps_4k);
                }
            }
        }
        return 0;
    }
}
