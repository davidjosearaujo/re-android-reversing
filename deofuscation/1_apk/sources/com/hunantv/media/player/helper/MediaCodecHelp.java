package com.hunantv.media.player.helper;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import c.a.a.b.d.g;
import com.hunantv.media.config.NetPlayConfig;
import com.hunantv.media.player.MgtvMediaPlayer;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.player.utils.ArrayUtil;
import com.hunantv.media.player.utils.PreferencesUtil;
import com.hunantv.media.player.utils.StringUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MediaCodecHelp {
    public static String AMIME_AUDIO_AMR_NB = "audio/3gpp";
    public static String AMIME_AUDIO_AMR_WB = "audio/amr-wb";
    public static String AMIME_AUDIO_G711_ALAW = "audio/g711-alaw";
    public static String AMIME_AUDIO_G711_MLAW = "audio/g711-mlaw";
    public static String AMIME_AUDIO_MP3 = "audio/mpeg";
    public static String AMIME_AUDIO_RAW_AAC = "audio/mp4a-latm";
    public static String AMIME_AUDIO_VORBIS = "audio/vorbis";
    public static String AMIME_VIDEO_AV1 = "video/av01";
    public static String AMIME_VIDEO_AVC = "video/avc";
    public static String AMIME_VIDEO_H263 = "video/3gpp";
    public static String AMIME_VIDEO_HEVC = "video/hevc";
    public static String AMIME_VIDEO_MPEG4 = "video/mp4v-es";
    public static String AMIME_VIDEO_VP8 = "video/x-vnd.on2.vp8";
    public static String AMIME_VIDEO_VP9 = "video/x-vnd.on2.vp9";
    public static String FHD = "FHD";
    public static String FHD_100 = "FHD_100";
    public static String FHD_120 = "FHD_120";
    public static String FHD_15 = "FHD_15";
    public static String FHD_20 = "FHD_20";
    public static String FHD_24 = "FHD_24";
    public static String FHD_25 = "FHD_25";
    public static String FHD_30 = "FHD_30";
    public static String FHD_40 = "FHD_40";
    public static String FHD_50 = "FHD_50";
    public static String FHD_60 = "FHD_60";
    public static String FHD_70 = "FHD_70";
    public static String FHD_80 = "FHD_80";
    public static String FHD_90 = "FHD_90";
    public static String FHD_MAX = "FHD_120_OVER";
    public static String FHD_MIN = "FHD_15_BELOW";
    public static String HD = "HD";
    public static String SD = "SD";
    public static String SD_BELOW = "SD_BELOW";
    public static String SHD = "SHD";
    public static String UHD = "UHD";
    public static String UHD_100 = "UHD_100";
    public static String UHD_120 = "UHD_120";
    public static String UHD_15 = "UHD_15";
    public static String UHD_20 = "UHD_20";
    public static String UHD_24 = "UHD_24";
    public static String UHD_25 = "UHD_25";
    public static String UHD_30 = "UHD_30";
    public static String UHD_40 = "UHD_40";
    public static String UHD_50 = "UHD_50";
    public static String UHD_60 = "UHD_60";
    public static String UHD_70 = "UHD_70";
    public static String UHD_80 = "UHD_80";
    public static String UHD_90 = "UHD_90";
    public static String UHD_MAX = "UHD_120_OVER";
    public static String UHD_MIN = "UHD_15_BELOW";
    public static String UNKOWN = "UnKown";
    private static boolean isConvert = true;
    private static boolean isHardware = true;
    private static volatile String sAV1Decoder = null;
    private static volatile String sAVCDecoder = null;
    private static volatile String sHEVCDecoder = null;
    private static ScreenPerformance sScreenPerformance = null;
    public static String tag = "MediaCodecHelp";
    private static Map<String, Boolean> sMediaCodecMap = new HashMap();
    private static final String MEDIA_CODEC_XML_FILE = "/etc/media_codecs.xml";
    private static final String VENDOR_MEDIA_CODEC_XML_FILE = "/vendor/etc/media_codecs.xml";
    private static final String ODM_MEDIA_CODEC_XML_FILE = "/odm/etc/media_codecs.xml";
    private static final String[] sCodecFiles = {MEDIA_CODEC_XML_FILE, VENDOR_MEDIA_CODEC_XML_FILE, ODM_MEDIA_CODEC_XML_FILE};
    private static final String[] sH265BlackListMods = {"OPPO R9s Plus", "OPPO A83t", "V1809A", "ALP-AL00"};
    public static boolean sH265Enable = true;
    public static Set<String> sCreateCodecBlackList = Collections.synchronizedSet(new HashSet());
    public static Set<String> sFlushCodecBlackList = Collections.synchronizedSet(new HashSet());
    public static ArrayList<CodecPerformance> sDecodePerformanceList = new ArrayList<>();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class CodecPerformance {
        public volatile String codecName;
        public volatile String hdr = "";
        public volatile boolean hdr_support;
        public volatile String max_def;
        public volatile String max_def_fps;
        public volatile String max_fps_1080p;
        public volatile String max_fps_4k;
        public volatile String mimeType;
        public volatile String performance;
        public volatile boolean s4k;
        public volatile String shdrt;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class ScreenPerformance {
        public String srpf;
        public String srplh;
        public String srpll;
        public String sshdr;

        public String toString() {
            return "ScreenPerformance{srpf='" + this.srpf + "', srpll='" + this.srpll + "', srplh='" + this.srplh + "', sshdr='" + this.sshdr + "'}";
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum performanceLevel {
        SD,
        HD,
        FHD,
        UHD,
        UUHD
    }

    private static File findCodecXmlFile() {
        String[] strArr = sCodecFiles;
        if (strArr != null && strArr.length > 0) {
            try {
                for (String str : strArr) {
                    File file = new File(str);
                    if (file.exists()) {
                        return file;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00e1 A[Catch: all -> 0x00ef, TRY_LEAVE, TryCatch #5 {, blocks: (B:4:0x0003, B:6:0x000b, B:12:0x0021, B:55:0x00da, B:57:0x00e1, B:61:0x00eb, B:62:0x00ee), top: B:76:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized boolean findMediaCodec(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.player.helper.MediaCodecHelp.findMediaCodec(java.lang.String):boolean");
    }

    public static String getALLAV1Decoder(boolean z) {
        if (sAV1Decoder == null && z && BuildHelper.isApi29_LollipopOrLater()) {
            sAV1Decoder = getSelectALLCodecNameDecoder21orLater(AMIME_VIDEO_AV1);
        }
        return sAV1Decoder;
    }

    public static synchronized ArrayList<CodecPerformance> getCodecPerformanceList(boolean z) {
        ArrayList<CodecPerformance> arrayList;
        MediaCodecInfo[] mediaCodecInfoArr;
        int i;
        String sb;
        int i2;
        int i3;
        String[] supportedTypes;
        synchronized (MediaCodecHelp.class) {
            arrayList = new ArrayList<>();
            int i4 = Build.VERSION.SDK_INT;
            char c = 0;
            if (i4 >= 21) {
                try {
                    char c2 = 1;
                    MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
                    int length = codecInfos.length;
                    int i5 = 0;
                    while (i5 < length) {
                        MediaCodecInfo mediaCodecInfo = codecInfos[i5];
                        if (z == mediaCodecInfo.isEncoder()) {
                            String[] supportedTypes2 = mediaCodecInfo.getSupportedTypes();
                            int length2 = supportedTypes2.length;
                            int i6 = 0;
                            while (i6 < length2) {
                                String str = supportedTypes2[i6];
                                if (str.contains("video")) {
                                    CodecPerformance codecPerformance = new CodecPerformance();
                                    MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = mediaCodecInfo.getCapabilitiesForType(str).profileLevels;
                                    if (codecProfileLevelArr != null) {
                                        char[] cArr = new char[2];
                                        cArr[c] = '0';
                                        cArr[c2] = '0';
                                        int length3 = codecProfileLevelArr.length;
                                        int i7 = 0;
                                        while (true) {
                                            mediaCodecInfoArr = codecInfos;
                                            if (i7 >= length3) {
                                                break;
                                            }
                                            MediaCodecInfo.CodecProfileLevel codecProfileLevel = codecProfileLevelArr[i7];
                                            int i8 = length3;
                                            int i9 = length;
                                            if (!codecPerformance.hdr.contains("_HDR10_") && ((i3 = codecProfileLevel.profile) == 4096 || i3 == 4096)) {
                                                codecPerformance.hdr_support = true;
                                                codecPerformance.hdr += "_HDR10_";
                                                cArr[0] = '1';
                                            } else if (!codecPerformance.hdr.contains("_HDR10Plus_") && ((i2 = codecProfileLevel.profile) == 8192 || i2 == 8192)) {
                                                codecPerformance.hdr_support = true;
                                                codecPerformance.hdr += "_HDR10Plus_";
                                                cArr[1] = '1';
                                                i7++;
                                                codecInfos = mediaCodecInfoArr;
                                                length3 = i8;
                                                length = i9;
                                            }
                                            i7++;
                                            codecInfos = mediaCodecInfoArr;
                                            length3 = i8;
                                            length = i9;
                                        }
                                        i = length;
                                        codecPerformance.shdrt = String.valueOf(cArr);
                                    } else {
                                        mediaCodecInfoArr = codecInfos;
                                        i = length;
                                    }
                                    MediaCodecInfo.VideoCapabilities videoCapabilities = mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities();
                                    codecPerformance.codecName = mediaCodecInfo.getName();
                                    codecPerformance.mimeType = str;
                                    codecPerformance.performance = getPerformance(videoCapabilities);
                                    codecPerformance.max_fps_4k = ((int) getPerformanceByFrameRate(videoCapabilities, UHD)) + "";
                                    codecPerformance.max_fps_1080p = ((int) getPerformanceByFrameRate(videoCapabilities, FHD)) + "";
                                    if (isHardware) {
                                        String lowerCase = codecPerformance.codecName.toLowerCase();
                                        if (lowerCase.startsWith("c2") && !lowerCase.startsWith("c2.android") && !lowerCase.contains("secure")) {
                                            printAllFrameRates(lowerCase, videoCapabilities);
                                            Size maxResolution = getMaxResolution(videoCapabilities);
                                            if (maxResolution != null) {
                                                codecPerformance.max_def = maxResolution.getWidth() + "x" + maxResolution.getHeight();
                                                StringBuilder sb2 = new StringBuilder();
                                                sb2.append(videoCapabilities.getSupportedFrameRatesFor(maxResolution.getWidth(), maxResolution.getHeight()).getUpper().intValue());
                                                sb2.append("");
                                                sb = sb2.toString();
                                                codecPerformance.max_def_fps = sb;
                                            }
                                        } else if (lowerCase.startsWith("omx") && !lowerCase.startsWith("omx.google") && !lowerCase.contains("secure") && !lowerCase.startsWith("omx.ffmpeg")) {
                                            printAllFrameRates(lowerCase, videoCapabilities);
                                            Size maxResolution2 = getMaxResolution(videoCapabilities);
                                            if (maxResolution2 != null) {
                                                codecPerformance.max_def = maxResolution2.getWidth() + "x" + maxResolution2.getHeight();
                                                StringBuilder sb3 = new StringBuilder();
                                                sb3.append(videoCapabilities.getSupportedFrameRatesFor(maxResolution2.getWidth(), maxResolution2.getHeight()).getUpper().intValue());
                                                sb3.append("");
                                                sb = sb3.toString();
                                                codecPerformance.max_def_fps = sb;
                                            }
                                        }
                                    }
                                    arrayList.add(codecPerformance);
                                } else {
                                    mediaCodecInfoArr = codecInfos;
                                    i = length;
                                }
                                i6++;
                                codecInfos = mediaCodecInfoArr;
                                length = i;
                                c2 = 1;
                                c = 0;
                            }
                        }
                        i5++;
                        codecInfos = codecInfos;
                        length = length;
                        c2 = 1;
                        c = 0;
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    return arrayList;
                }
            } else if (i4 >= 16) {
                try {
                    int codecCount = MediaCodecList.getCodecCount();
                    for (int i10 = 0; i10 < codecCount; i10++) {
                        MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i10);
                        if (z != codecInfoAt.isEncoder()) {
                            for (String str2 : codecInfoAt.getSupportedTypes()) {
                                if (str2.contains("video")) {
                                    CodecPerformance codecPerformance2 = new CodecPerformance();
                                    codecPerformance2.codecName = codecInfoAt.getName();
                                    codecPerformance2.mimeType = str2;
                                    codecPerformance2.performance = UNKOWN;
                                    if (isHardware) {
                                        String lowerCase2 = codecPerformance2.codecName.toLowerCase();
                                        if (lowerCase2.startsWith("c2")) {
                                            if (!lowerCase2.startsWith("c2.google") && !lowerCase2.contains("secure")) {
                                            }
                                        }
                                        if (lowerCase2.startsWith("omx")) {
                                            if (!lowerCase2.startsWith("omx.google")) {
                                                if (lowerCase2.contains("secure")) {
                                                }
                                            }
                                        }
                                    }
                                    arrayList.add(codecPerformance2);
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public static synchronized ArrayList<CodecPerformance> getDecoderPerformanceList() {
        ArrayList<CodecPerformance> arrayList;
        synchronized (MediaCodecHelp.class) {
            if (sDecodePerformanceList.isEmpty()) {
                sDecodePerformanceList = getCodecPerformanceList(false);
            }
            arrayList = sDecodePerformanceList;
        }
        return arrayList;
    }

    public static String getH264Decoder() {
        return getH264Decoder(true);
    }

    public static String getH264Decoder(boolean z) {
        if (sAVCDecoder == null && z) {
            sAVCDecoder = BuildHelper.isApi21_LollipopOrLater() ? getSelectCodecDecoder21orLater(AMIME_VIDEO_AVC) : BuildHelper.isApi16_JellyBeanOrLater() ? getSelectCodecDecoder16orLater(AMIME_VIDEO_AVC) : null;
        }
        return sAVCDecoder;
    }

    public static String getH265Decoder() {
        return getH265Decoder(true);
    }

    public static String getH265Decoder(boolean z) {
        if (sHEVCDecoder == null && z) {
            sHEVCDecoder = BuildHelper.isApi21_LollipopOrLater() ? getSelectCodecDecoder21orLater(AMIME_VIDEO_HEVC) : BuildHelper.isApi16_JellyBeanOrLater() ? getSelectCodecDecoder16orLater(AMIME_VIDEO_HEVC) : null;
        }
        return sHEVCDecoder;
    }

    public static void getHardWareperformance(boolean z) {
        isHardware = z;
    }

    @RequiresApi(api = 21)
    private static int getMaxFps(MediaCodecInfo.VideoCapabilities videoCapabilities, Size size) {
        try {
            return videoCapabilities.getSupportedFrameRatesFor(size.getWidth(), size.getHeight()).getUpper().intValue() / 1000;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @RequiresApi(api = 21)
    private static Size getMaxResolution(MediaCodecInfo.VideoCapabilities videoCapabilities) {
        if (NetPlayConfig.is4KOpen() && videoCapabilities.isSizeSupported(7680, 4320)) {
            return new Size(7680, 4320);
        }
        if (NetPlayConfig.is4KOpen() && videoCapabilities.isSizeSupported(3840, 2160)) {
            return new Size(3840, 2160);
        }
        if (videoCapabilities.isSizeSupported(1920, 1080)) {
            return new Size(1920, 1080);
        }
        if (videoCapabilities.isSizeSupported(1280, 720)) {
            return new Size(1280, 720);
        }
        if (videoCapabilities.isSizeSupported(720, 480)) {
            return new Size(720, 480);
        }
        return null;
    }

    @RequiresApi(api = 21)
    private static String getPerformance(MediaCodecInfo.VideoCapabilities videoCapabilities) {
        String str;
        String performanceByResolution = getPerformanceByResolution(videoCapabilities);
        int performanceByFrameRate = (int) getPerformanceByFrameRate(videoCapabilities, performanceByResolution);
        if ("FHD".equalsIgnoreCase(performanceByResolution) || !videoCapabilities.isSizeSupported(1920, 1080)) {
            str = "";
        } else {
            double doubleValue = videoCapabilities.getSupportedFrameRatesFor(1920, 1080).getUpper().doubleValue();
            str = "FHD_" + ((int) doubleValue) + "_";
        }
        return performanceByResolution + "_" + performanceByFrameRate + "_" + str;
    }

    @RequiresApi(api = 21)
    private static double getPerformanceByFrameRate(MediaCodecInfo.VideoCapabilities videoCapabilities, String str) {
        int i;
        if (videoCapabilities == null || StringUtil.isEmpty(str)) {
            return 0.0d;
        }
        int i2 = 720;
        if (str.equals(SHD)) {
            i2 = 7680;
            i = 4320;
        } else if (str.equals(UHD)) {
            i2 = 3840;
            i = 2160;
        } else if (str.equals(FHD)) {
            i2 = 1920;
            i = 1080;
        } else if (str.equals(HD)) {
            i = 720;
            i2 = 1280;
        } else if (str.equals(SD)) {
            i = 480;
        } else {
            i = 0;
            i2 = 0;
        }
        if (i2 <= 0 || i <= 0) {
            return 0.0d;
        }
        try {
            if (videoCapabilities.isSizeSupported(i2, i)) {
                return videoCapabilities.getSupportedFrameRatesFor(i2, i).getUpper().doubleValue();
            }
            return 0.0d;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0d;
        }
    }

    @RequiresApi(api = 21)
    private static String getPerformanceByResolution(MediaCodecInfo.VideoCapabilities videoCapabilities) {
        return videoCapabilities.isSizeSupported(7680, 4320) ? SHD : videoCapabilities.isSizeSupported(3840, 2160) ? UHD : videoCapabilities.isSizeSupported(1920, 1080) ? FHD : videoCapabilities.isSizeSupported(1280, 720) ? HD : videoCapabilities.isSizeSupported(720, 480) ? SD : SD_BELOW;
    }

    public static synchronized ScreenPerformance getScreenPerformance(Context context) {
        ScreenPerformance screenPerformance;
        synchronized (MediaCodecHelp.class) {
            if (sScreenPerformance == null) {
                try {
                    sScreenPerformance = new ScreenPerformance();
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
                    int refreshRate = (int) defaultDisplay.getRefreshRate();
                    char[] cArr = {'0', '0', '0', '0'};
                    if (i >= 24) {
                        sScreenPerformance.srpll = ((int) (defaultDisplay.getHdrCapabilities().getDesiredMinLuminance() * 1000.0f)) + "";
                        sScreenPerformance.srplh = ((int) (defaultDisplay.getHdrCapabilities().getDesiredMaxLuminance() * 1000.0f)) + "";
                        int[] supportedHdrTypes = defaultDisplay.getHdrCapabilities().getSupportedHdrTypes();
                        if (supportedHdrTypes != null) {
                            for (int i4 : supportedHdrTypes) {
                                if (i4 == 1) {
                                    cArr[3] = '1';
                                } else if (i4 == 2) {
                                    cArr[0] = '1';
                                } else if (i4 == 3) {
                                    cArr[2] = '1';
                                } else if (i4 == 4) {
                                    cArr[1] = '1';
                                }
                            }
                        }
                        sScreenPerformance.sshdr = String.valueOf(cArr);
                    }
                    sScreenPerformance.srpf = i2 + "x" + i3 + "_" + refreshRate;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            screenPerformance = sScreenPerformance;
        }
        return screenPerformance;
    }

    @TargetApi(21)
    private static String getSelectALLCodecNameDecoder21orLater(String str) {
        MediaCodecInfo[] codecInfos;
        String[] supportedTypes;
        String str2 = null;
        try {
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
                if (!mediaCodecInfo.isEncoder()) {
                    for (String str3 : mediaCodecInfo.getSupportedTypes()) {
                        if (str3.equalsIgnoreCase(str)) {
                            DebugLog.i("ImgoPlayerLibJava", "getSelectALLCodecNameDecoder21orLater : " + mediaCodecInfo.getName() + ",type:" + str3);
                            if (str2 == null) {
                                str2 = "";
                            }
                            str2 = str2 + mediaCodecInfo.getName() + "_";
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2;
    }

    @TargetApi(16)
    private static MediaCodecInfo getSelectCodec(String str) {
        try {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i = 0; i < codecCount; i++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
                if (!codecInfoAt.isEncoder()) {
                    for (String str2 : codecInfoAt.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            DebugLog.i("ImgoPlayerLibJava", "SelectCodec : " + codecInfoAt.getName());
                            return codecInfoAt;
                        }
                    }
                    continue;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @TargetApi(16)
    private static String getSelectCodecDecoder16orLater(String str) {
        try {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i = 0; i < codecCount; i++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
                if (!codecInfoAt.isEncoder()) {
                    for (String str2 : codecInfoAt.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str) && !codecInfoAt.getName().startsWith("OMX.google.") && !codecInfoAt.getName().startsWith("c2.android.")) {
                            DebugLog.i("ImgoPlayerLibJava", "getSelectCodecDecoder16orLater : " + codecInfoAt.getName());
                            return codecInfoAt.getName();
                        }
                    }
                    continue;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @TargetApi(21)
    private static String getSelectCodecDecoder21orLater(String str) {
        MediaCodecInfo[] codecInfos;
        try {
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
                if (!mediaCodecInfo.isEncoder()) {
                    for (String str2 : mediaCodecInfo.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str) && !mediaCodecInfo.getName().startsWith("OMX.google.") && !mediaCodecInfo.getName().startsWith("c2.android.")) {
                            DebugLog.i("ImgoPlayerLibJava", "getSelectCodecDecoder21orLater : " + mediaCodecInfo.getName());
                            return mediaCodecInfo.getName();
                        }
                    }
                    continue;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getSupportHDST(Context context) {
        StringBuilder sb;
        String str;
        List<String> supportHardDecodeTypes = getSupportHardDecodeTypes(context);
        String str2 = "";
        for (int i = 0; i < supportHardDecodeTypes.size(); i++) {
            if (i == supportHardDecodeTypes.size() - 1) {
                sb = new StringBuilder();
                sb.append(str2);
                str = supportHardDecodeTypes.get(i);
            } else {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(supportHardDecodeTypes.get(i));
                str = ",";
            }
            sb.append(str);
            str2 = sb.toString();
        }
        return str2;
    }

    public static List<String> getSupportHardDecodeTypes(Context context) {
        ArrayList arrayList = new ArrayList();
        PreferencesUtil preferencesUtil = new PreferencesUtil(context);
        if (getH264Decoder() != null) {
            arrayList.add(MgtvMediaPlayer.DataSourceInfo.H264);
        }
        String h265Decoder = getH265Decoder();
        if (sH265Enable && BuildHelper.isApi21_LollipopOrLater() && h265Decoder != null && !inCreateCodecBlackList(h265Decoder) && !inH265BlackListMods(g.m()) && preferencesUtil.getBoolean(PreferencesUtil.PREKEY_MEDIACODEC_H265_SUPPORT, true)) {
            arrayList.add(MgtvMediaPlayer.DataSourceInfo.H265);
        }
        return arrayList;
    }

    public static boolean inCreateCodecBlackList(String str) {
        Set<String> set;
        try {
            if (StringUtil.isEmpty(str) || (set = sCreateCodecBlackList) == null) {
                return false;
            }
            return set.contains(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean inH265BlackListMods(String str) {
        return ArrayUtil.inArrayIgnoreCase(sH265BlackListMods, str);
    }

    public static boolean isH265InCreateCodecBlackList() {
        for (String str : sCreateCodecBlackList) {
            if (str != null && (str.toUpperCase().contains("HEVC") || str.toUpperCase().contains("H265"))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isIntelMediaCodec() {
        return findMediaCodec("OMX.Intel.");
    }

    public static boolean isMTKMediaCodec() {
        return findMediaCodec("OMX.MTK.");
    }

    @RequiresApi(api = 21)
    public static void printAllFrameRates(String str, MediaCodecInfo.VideoCapabilities videoCapabilities) {
        DebugLog.i("MediaCodecHelp", "codecName:" + str);
        printFrameRate(videoCapabilities, 7680, 4320);
        printFrameRate(videoCapabilities, 3840, 2160);
        printFrameRate(videoCapabilities, 1920, 1080);
        printFrameRate(videoCapabilities, 1280, 720);
        printFrameRate(videoCapabilities, 720, 480);
        DebugLog.i("MediaCodecHelp", "===================================");
    }

    @RequiresApi(api = 21)
    private static void printFrameRate(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        try {
            if (videoCapabilities.isSizeSupported(i, i2)) {
                double doubleValue = videoCapabilities.getSupportedFrameRatesFor(i, i2).getUpper().doubleValue();
                DebugLog.i("MediaCodecHelp", i + "_" + i2 + "max framerate:" + doubleValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
