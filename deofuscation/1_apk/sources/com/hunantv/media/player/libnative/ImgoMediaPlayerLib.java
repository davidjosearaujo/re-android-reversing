package com.hunantv.media.player.libnative;

import a.a.a.a.d;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.Window;
import c.a.a.a.a;
import c.a.a.a.c;
import c.a.a.a.e;
import c.a.a.a.n.b;
import c.a.a.b.d.g;
import com.alibaba.fastjson.asm.Label;
import com.hunantv.media.config.NetPlayConfig;
import com.hunantv.media.drm.utils.MgtvDrmUtils;
import com.hunantv.media.player.MgtvMediaPlayer;
import com.hunantv.media.player.loader.ImgoLibLoader;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.player.pragma.PlayerConfig;
import com.hunantv.media.player.utils.PreferencesUtil;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class ImgoMediaPlayerLib extends a {
    public static final int FFP_PROPV_DECODER_AVCODEC = 1;
    public static final int FFP_PROPV_DECODER_MEDIACODEC = 2;
    public static final int FFP_PROPV_DECODER_UNKNOWN = 0;
    public static final int FFP_PROPV_DECODER_VIDEOTOOLBOX = 3;
    public static final int FFP_PROP_FLOAT_AUDIO_LATENCY = 10007;
    public static final int FFP_PROP_FLOAT_AVDELAY = 10004;
    public static final int FFP_PROP_FLOAT_AVDIFF = 10005;
    public static final int FFP_PROP_FLOAT_FILE_START_TIME = 10006;
    public static final int FFP_PROP_FLOAT_PLAYBACK_RATE = 10003;
    public static final int FFP_PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND = 10001;
    public static final int FFP_PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND = 10002;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_BACKWARDS = 20201;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_CAPACITY = 20203;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_FORWARDS = 20202;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_BYTES = 20008;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_DURATION = 20006;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_PACKETS = 20010;
    public static final int FFP_PROP_INT64_AUDIO_DECODER = 20004;
    public static final int FFP_PROP_INT64_AUDIO_TIMESTAMP_POS = 20421;
    public static final int FFP_PROP_INT64_AUDIO_TIMESTAMP_STATUS = 80021;
    public static final int FFP_PROP_INT64_AV_CACHED_BYTES = 20101;
    public static final int FFP_PROP_INT64_AV_CACHED_TIMEMS = 20102;
    public static final int FFP_PROP_INT64_BIT_RATE = 20100;
    public static final int FFP_PROP_INT64_CLOCK_NOTIFY = 80001;
    public static final int FFP_PROP_INT64_CLOCK_VPTS_NOTIFY_END = 80003;
    public static final int FFP_PROP_INT64_CLOCK_VPTS_NOTIFY_START = 80002;
    public static final int FFP_PROP_INT64_CRASH_TEST = 90001;
    public static final int FFP_PROP_INT64_DECODER_PLAY_NOTIFY = 90003;
    public static final int FFP_PROP_INT64_DRM_PREPEARED_STATUE = 20420;
    public static final int FFP_PROP_INT64_ENABLE_WANOS_AUDIO_EFFECT = 30003;
    public static final int FFP_PROP_INT64_FRAME_PTS_NOTIFY = 90002;
    public static final int FFP_PROP_INT64_GETFRAMETIME_DF = 20505;
    public static final int FFP_PROP_INT64_GETFRAMETIME_DROP_NUM = 20510;
    public static final int FFP_PROP_INT64_GETFRAMETIME_FIN = 20512;
    public static final int FFP_PROP_INT64_GETFRAMETIME_GEN_NUM = 20511;
    public static final int FFP_PROP_INT64_GETFRAMETIME_T1 = 20501;
    public static final int FFP_PROP_INT64_GETFRAMETIME_T2 = 20502;
    public static final int FFP_PROP_INT64_GETFRAMETIME_T3 = 20503;
    public static final int FFP_PROP_INT64_GETFRAMETIME_T4 = 20504;
    public static final int FFP_PROP_INT64_GETFRAMETIME_TD = 20506;
    public static final int FFP_PROP_INT64_GETFRAMETIME_TE = 20508;
    public static final int FFP_PROP_INT64_GETFRAMETIME_TF = 20509;
    public static final int FFP_PROP_INT64_GETFRAMETIME_TS = 20507;
    public static final int FFP_PROP_INT64_IS_CODEC_SW_RENDER = 80023;
    public static final int FFP_PROP_INT64_IS_SUPPORT_SNAPSHOT = 80022;
    public static final int FFP_PROP_INT64_LATEST_SEEK_LOAD_DURATION = 20300;
    public static final int FFP_PROP_INT64_LOOPAB_TARGET_POS = 80010;
    public static final int FFP_PROP_INT64_LOOP_SEEK = 80020;
    public static final int FFP_PROP_INT64_NET_BROKEN = 90012;
    public static final int FFP_PROP_INT64_OPPOOSIE_ENALBE = 90021;
    public static final int FFP_PROP_INT64_OPPOSR_ENALBE = 90020;
    public static final int FFP_PROP_INT64_P2P_SMOOTH_FAIL = 90010;
    public static final int FFP_PROP_INT64_SELECTED_AUDIO_STREAM = 20002;
    public static final int FFP_PROP_INT64_SELECTED_TIMEDTEXT_STREAM = 20011;
    public static final int FFP_PROP_INT64_SELECTED_VIDEO_STREAM = 20001;
    public static final int FFP_PROP_INT64_SMOOTH_ACCSEEK = 90011;
    public static final int FFP_PROP_INT64_STEP_PLAYBACK = 30001;
    public static final int FFP_PROP_INT64_TCP_SPEED = 20200;
    public static final int FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT = 20204;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_BYTES = 20007;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_DURATION = 20005;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_PACKETS = 20009;
    public static final int FFP_PROP_INT64_VIDEO_DECODER = 20003;
    public static final int FFP_PROP_INT64_VSRTIME_AVG = 20411;
    public static final int FFP_PROP_INT64_VSRTIME_COUNT = 20410;
    public static final int FFP_PROP_INT64_VSRTIME_MAX = 20413;
    public static final int FFP_PROP_INT64_VSRTIME_MIN = 20412;
    public static final int FFP_PROP_INT64_VSR_RUN_EANBLE = 90013;
    public static final int FFP_PROP_INT64_VVTTIME_DLPT = 20409;
    public static final int FFP_PROP_INT64_VVTTIME_T1 = 20401;
    public static final int FFP_PROP_INT64_VVTTIME_T2 = 20402;
    public static final int FFP_PROP_INT64_VVTTIME_T3 = 20403;
    public static final int FFP_PROP_INT64_VVTTIME_T4 = 20404;
    public static final int FFP_PROP_INT64_VVTTIME_T5 = 20405;
    public static final int FFP_PROP_INT64_VVTTIME_T6 = 20406;
    public static final int FFP_PROP_INT64_VVTTIME_VVBT = 20408;
    public static final int FFP_PROP_INT64_VVTTIME_VVT = 20407;
    public static final int FFP_PROP_INT64_WANOS_AUDIO_EFFECT = 30002;
    private static final int MEDIA_BUFFERING_TIMEOUT = 300;
    private static final int MEDIA_BUFFERING_UPDATE = 3;
    private static final int MEDIA_ERROR = 100;
    private static final int MEDIA_GET_FRAME_IMG_INFO = 701;
    private static final int MEDIA_GET_FRAME_IMG_STATUE = 700;
    private static final int MEDIA_INFO = 200;
    private static final int MEDIA_INFO_DRM = 210;
    private static final int MEDIA_INFO_STRING = 201;
    private static final int MEDIA_LOOPSWITCH_SOURCE_COMPLETE = 601;
    private static final int MEDIA_LOOPSWITCH_SOURCE_FAILED = 602;
    private static final int MEDIA_LOOPSWITCH_SOURCE_INFO = 600;
    private static final int MEDIA_NOP = 0;
    private static final int MEDIA_PLAYBACK_COMPLETE = 2;
    private static final int MEDIA_PREPARED = 1;
    private static final int MEDIA_RECORD_VIDEO_ERR = 501;
    private static final int MEDIA_RECORD_VIDEO_INFO = 500;
    private static final int MEDIA_SEEK_COMPLETE = 4;
    public static final int MEDIA_SET_VIDEO_DAR = 10002;
    public static final int MEDIA_SET_VIDEO_PAR = 10003;
    public static final int MEDIA_SET_VIDEO_SAR = 10001;
    private static final int MEDIA_SET_VIDEO_SIZE = 5;
    private static final int MEDIA_SMOOTH_SWITCH_SOURCE_COMPLETE = 604;
    private static final int MEDIA_SMOOTH_SWITCH_SOURCE_FAILED = 605;
    private static final int MEDIA_SMOOTH_SWITCH_SOURCE_INFO = 603;
    private static final int MEDIA_SWITCH_SOURCE_COMPLETE = 401;
    private static final int MEDIA_SWITCH_SOURCE_FAILED = 402;
    private static final int MEDIA_SWITCH_SOURCE_INFO = 400;
    private static final int MEDIA_TIMED_TEXT = 99;
    public static final int OPPO_FUNC_OSIE = 2;
    public static final int OPPO_FUNC_SR = 1;
    public static final int OPT_CATEGORY_CODEC = 2;
    public static final int OPT_CATEGORY_FORMAT = 1;
    public static final int OPT_CATEGORY_PLAYER = 4;
    public static final int OPT_CATEGORY_SWS = 3;
    public static final int SDL_FCC_RV16 = 909203026;
    public static final int SDL_FCC_RV32 = 842225234;
    public static final int SDL_FCC_YV12 = 842094169;
    public static final int SDL_FCC__OPENGLES = 1397050439;
    private static final String TAG = "ImgoMediaPlayerLib";
    private static volatile boolean mIsNativeInitialized = false;
    private static String mPackageName = "com.hunantv.imgo.activity";
    private int mBufferedPercent;
    private long mBufferedPositionMs;
    private Context mContext;
    private int mCurBufferingPercent;
    private String mCurrentRecFile;
    private String mDataSource;
    private EventHandler mEventHandler;
    private boolean mIsReleased;
    private int mListenerContext;
    private long mNativeMGTVMediaDataSource;
    private long mNativeMGTVSMediaDataSource;
    private long mNativeMediaDataSource;
    private long mNativeMediaPlayer;
    private int mNativeSurfaceTexture;
    private OnMediaCodecSelectListener mOnMediaCodecSelectListener;
    private OnNativeInvokeListener mOnNativeInvokeListener;
    private boolean mScreenOnWhilePlaying;
    private boolean mStayAwake;
    private SurfaceHolder mSurfaceHolder;
    private int mVideoDarDen;
    private int mVideoDarNum;
    private int mVideoHeight;
    private int mVideoParDen;
    private int mVideoParNum;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private PowerManager.WakeLock mWakeLock;
    private WeakReference<ImgoMediaPlayerLib> mWeakImgoPlayer;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class DefaultMediaCodecSelector implements OnMediaCodecSelectListener {
        public static DefaultMediaCodecSelector sInstance = new DefaultMediaCodecSelector();
        private boolean mIsAdaptive;

        @Override // com.hunantv.media.player.libnative.ImgoMediaPlayerLib.OnMediaCodecSelectListener
        @TargetApi(16)
        public boolean onCodecIsAdaptive(d dVar) {
            if (Build.VERSION.SDK_INT < 16) {
                return false;
            }
            DebugLog.i(dVar != null ? dVar.getLogTag() : ImgoMediaPlayerLib.TAG, this.mIsAdaptive ? String.format(Locale.US, "support adaptive", new Object[0]) : String.format(Locale.US, "not support adaptive", new Object[0]));
            return this.mIsAdaptive;
        }

        @Override // com.hunantv.media.player.libnative.ImgoMediaPlayerLib.OnMediaCodecSelectListener
        @TargetApi(16)
        public String onMediaCodecSelect(d dVar, String str, int i, int i2) {
            String[] supportedTypes;
            if (Build.VERSION.SDK_INT >= 16 && !TextUtils.isEmpty(str)) {
                String logTag = dVar != null ? dVar.getLogTag() : ImgoMediaPlayerLib.TAG;
                int i3 = 1;
                int i4 = 2;
                ImgoReportLog.ImgoLogReport(1, "11", logTag, String.format(Locale.US, "onSelectCodec: mime=%s, profile=%d, level=%d", str, Integer.valueOf(i), Integer.valueOf(i2)));
                ArrayList arrayList = new ArrayList();
                int codecCount = MediaCodecList.getCodecCount();
                int i5 = 0;
                while (i5 < codecCount) {
                    MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i5);
                    Locale locale = Locale.US;
                    Object[] objArr = new Object[i3];
                    objArr[0] = codecInfoAt.getName();
                    DebugLog.d(logTag, String.format(locale, "  found codec: %s", objArr));
                    if (!codecInfoAt.isEncoder() && (supportedTypes = codecInfoAt.getSupportedTypes()) != null) {
                        int length = supportedTypes.length;
                        int i6 = 0;
                        while (i6 < length) {
                            String str2 = supportedTypes[i6];
                            if (!TextUtils.isEmpty(str2)) {
                                Locale locale2 = Locale.US;
                                Object[] objArr2 = new Object[i3];
                                objArr2[0] = str2;
                                DebugLog.d(logTag, String.format(locale2, "    mime: %s", objArr2));
                                if (str2.equalsIgnoreCase(str)) {
                                    c b = c.b(codecInfoAt, str, i, i2);
                                    if (b != null) {
                                        arrayList.add(b);
                                        Object[] objArr3 = new Object[i4];
                                        objArr3[0] = codecInfoAt.getName();
                                        objArr3[1] = Integer.valueOf(b.b);
                                        DebugLog.i(logTag, String.format(locale2, "candidate codec: %s rank=%d", objArr3));
                                        b.e(str);
                                    }
                                    i6++;
                                    i3 = 1;
                                    i4 = 2;
                                }
                            }
                            i6++;
                            i3 = 1;
                            i4 = 2;
                        }
                    }
                    i5++;
                    i3 = 1;
                    i4 = 2;
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                c cVar = (c) arrayList.get(0);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c cVar2 = (c) it.next();
                    if (cVar2.b > cVar.b) {
                        cVar = cVar2;
                    }
                }
                if (cVar.b < c.n) {
                    DebugLog.i(logTag, String.format(Locale.US, "unaccetable codec: %s(%d)", cVar.a.getName(), Integer.valueOf(cVar.b)));
                    return null;
                }
                DebugLog.i(logTag, cVar.d ? String.format(Locale.US, "selected codec: %s rank=%d adaptive=1", cVar.a.getName(), Integer.valueOf(cVar.b)) : String.format(Locale.US, "selected codec: %s rank=%d adaptive=0", cVar.a.getName(), Integer.valueOf(cVar.b)));
                this.mIsAdaptive = cVar.d;
                return cVar.a.getName();
            }
            return null;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class EventHandler extends Handler {
        private final WeakReference<ImgoMediaPlayerLib> mWeakPlayer;

        public EventHandler(ImgoMediaPlayerLib imgoMediaPlayerLib, Looper looper) {
            super(looper);
            this.mWeakPlayer = new WeakReference<>(imgoMediaPlayerLib);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            int i;
            ImgoMediaPlayerLib imgoMediaPlayerLib = this.mWeakPlayer.get();
            if (imgoMediaPlayerLib != null) {
                if (imgoMediaPlayerLib.mNativeMediaPlayer != 0) {
                    int i2 = message.what;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            imgoMediaPlayerLib.notifyOnPrepared();
                            imgoMediaPlayerLib.maybeUpdateAudioTimestamp();
                            return;
                        }
                        if (i2 == 2) {
                            imgoMediaPlayerLib.notifyOnCompletion(message.arg1, message.arg2);
                            imgoMediaPlayerLib.stayAwake(false);
                            return;
                        }
                        if (i2 == 3) {
                            int i3 = message.arg2;
                            int i4 = i3 >= 0 ? i3 : 0;
                            int i5 = i4 < 100 ? i4 : 100;
                            if (imgoMediaPlayerLib.mCurBufferingPercent != i5 && imgoMediaPlayerLib.mCurBufferingPercent < i5) {
                                imgoMediaPlayerLib.mCurBufferingPercent = i5;
                            }
                            long j = message.arg1;
                            if (j < 0) {
                                j = 0;
                            }
                            long duration = imgoMediaPlayerLib.getDuration();
                            long j2 = duration > 0 ? (j * 100) / duration : 0L;
                            int i6 = (int) (j2 < 100 ? j2 : 100L);
                            imgoMediaPlayerLib.notifyOnBufferingUpdate(i6);
                            imgoMediaPlayerLib.mBufferedPercent = i6;
                            imgoMediaPlayerLib.mBufferedPositionMs = j;
                            return;
                        } else if (i2 == 4) {
                            imgoMediaPlayerLib.notifyOnSeekComplete(message.arg1, message.arg2);
                            return;
                        } else if (i2 == 5) {
                            imgoMediaPlayerLib.mVideoWidth = message.arg1;
                            imgoMediaPlayerLib.mVideoHeight = message.arg2;
                            imgoMediaPlayerLib.notifyOnVideoSizeChanged(imgoMediaPlayerLib.mVideoWidth, imgoMediaPlayerLib.mVideoHeight, imgoMediaPlayerLib.mVideoSarNum, imgoMediaPlayerLib.mVideoSarDen);
                            return;
                        } else if (i2 != 99) {
                            if (i2 == 100) {
                                DebugLog.e(imgoMediaPlayerLib.getLogTag(), "Error (" + message.arg1 + "," + message.arg2 + ")");
                                if (!imgoMediaPlayerLib.notifyOnError(message.arg1, message.arg2)) {
                                    imgoMediaPlayerLib.notifyOnCompletion(message.arg1, message.arg2);
                                }
                                imgoMediaPlayerLib.stayAwake(false);
                                return;
                            } else if (i2 == 200) {
                                int i7 = message.arg1;
                                if (i7 != 700 && i7 != 7 && i7 != 8) {
                                    DebugLog.d(imgoMediaPlayerLib.getLogTag(), "Info (" + message.arg1 + "," + message.arg2 + ")");
                                }
                                if (message.arg1 == 5) {
                                    int i8 = message.arg2;
                                    if (i8 == 1) {
                                        message.arg2 = 501;
                                    } else {
                                        if (i8 == 2) {
                                            i = MgtvMediaPlayer.MEDIA_INFO_DECODER_SW_TO_HW;
                                        } else if (i8 == 3) {
                                            i = MgtvMediaPlayer.MEDIA_INFO_DECODER_HW_TO_SW_DATA;
                                        } else if (i8 == 4) {
                                            i = MgtvMediaPlayer.MEDIA_INFO_DECODER_HW_TO_SW_INNER;
                                        } else if (i8 == 5) {
                                            i = MgtvMediaPlayer.MEDIA_INFO_DECODER_HW_TO_SW_HEVC;
                                        }
                                        message.arg2 = i;
                                    }
                                    DebugLog.i(imgoMediaPlayerLib.getLogTag(), "Info MEDIA_INFO_DECODER_TYPE_CHANGED(" + message.arg1 + "," + message.arg2 + ")");
                                }
                                if (message.arg1 == 701) {
                                    imgoMediaPlayerLib.mCurBufferingPercent = 0;
                                }
                                imgoMediaPlayerLib.notifyOnInfo(message.arg1, message.arg2);
                                return;
                            } else if (i2 == 201) {
                                imgoMediaPlayerLib.notifyOnInfoString(message.arg1, (String) message.obj);
                                return;
                            } else if (i2 == 210) {
                                int i9 = message.arg2;
                                if (i9 == 0) {
                                    byte[] bArr = (byte[]) message.obj;
                                    DebugLog.d(imgoMediaPlayerLib.getLogTag(), "MEDIA_INFO_DRM in" + bArr);
                                    imgoMediaPlayerLib.notifyOnDrmPsshMap(MgtvDrmUtils.parsePSSH(bArr));
                                    return;
                                } else if (i9 == 1) {
                                    imgoMediaPlayerLib.notifyOnMaskDrmInit((byte[]) message.obj);
                                    return;
                                } else {
                                    DebugLog.d(imgoMediaPlayerLib.getLogTag(), "MEDIA_INFO_DRM in not support yet. arg1=" + message.arg1);
                                    return;
                                }
                            } else if (i2 == 300) {
                                DebugLog.e(imgoMediaPlayerLib.getLogTag(), "Error (" + message.arg1 + "," + message.arg2 + ")");
                                imgoMediaPlayerLib.notifyOnBufferingTimeout(message.arg1, message.arg2);
                                imgoMediaPlayerLib.stayAwake(false);
                                return;
                            } else if (i2 == 500) {
                                DebugLog.d(imgoMediaPlayerLib.getLogTag(), "record video info (" + message.arg1 + "," + message.arg2 + ")");
                                imgoMediaPlayerLib.notifyOnRecordVideoInfo(message.arg1, message.arg2);
                                return;
                            } else if (i2 == 501) {
                                DebugLog.d(imgoMediaPlayerLib.getLogTag(), "record video error (" + message.arg1 + "," + message.arg2 + ")");
                                imgoMediaPlayerLib.notifyOnRecordVideoErr(message.arg1, message.arg2);
                                return;
                            } else if (i2 == 700) {
                                imgoMediaPlayerLib.notifyOnGetFrameImageStatus(message.arg1, message.arg2);
                                return;
                            } else if (i2 == 701) {
                                imgoMediaPlayerLib.notifyOnGetFrameImageInfo(message.arg1, message.arg2, (String) message.obj);
                                return;
                            } else {
                                switch (i2) {
                                    case 400:
                                        DebugLog.d(imgoMediaPlayerLib.getLogTag(), "switch video source info (" + message.arg1 + "," + message.arg2 + "," + message.obj + ")");
                                        imgoMediaPlayerLib.notifyOnSwitchSourceInfo((String) message.obj, message.arg1, message.arg2);
                                        return;
                                    case 401:
                                        DebugLog.d(imgoMediaPlayerLib.getLogTag(), "switch video source complete (" + message.arg1 + "," + message.arg2 + "," + message.obj + ")");
                                        imgoMediaPlayerLib.notifyOnSwitchSourceComplete((String) message.obj, message.arg1, message.arg2);
                                        return;
                                    case ImgoMediaPlayerLib.MEDIA_SWITCH_SOURCE_FAILED /* 402 */:
                                        DebugLog.d(imgoMediaPlayerLib.getLogTag(), "switch video source failed (" + message.arg1 + "," + message.arg2 + "," + message.obj + ")");
                                        imgoMediaPlayerLib.notifyOnSwitchSourceFailed((String) message.obj, message.arg1, message.arg2);
                                        return;
                                    default:
                                        switch (i2) {
                                            case ImgoMediaPlayerLib.MEDIA_LOOPSWITCH_SOURCE_INFO /* 600 */:
                                                DebugLog.d(imgoMediaPlayerLib.getLogTag(), "loop switch video source info (" + message.arg1 + "," + message.arg2 + "," + message.obj + ")");
                                                imgoMediaPlayerLib.notifyOnLoopSwitchSourceInfo((String) message.obj, message.arg1, message.arg2);
                                                return;
                                            case ImgoMediaPlayerLib.MEDIA_LOOPSWITCH_SOURCE_COMPLETE /* 601 */:
                                                DebugLog.d(imgoMediaPlayerLib.getLogTag(), "loop switch video source complete (" + message.arg1 + "," + message.arg2 + "," + message.obj + ")");
                                                imgoMediaPlayerLib.notifyOnLoopSwitchSourceComplete((String) message.obj, message.arg1, message.arg2);
                                                return;
                                            case ImgoMediaPlayerLib.MEDIA_LOOPSWITCH_SOURCE_FAILED /* 602 */:
                                                DebugLog.d(imgoMediaPlayerLib.getLogTag(), "loop switch video source fail (" + message.arg1 + "," + message.arg2 + "," + message.obj + ")");
                                                imgoMediaPlayerLib.notifyOnLoopSwitchSourceFail((String) message.obj, message.arg1, message.arg2);
                                                return;
                                            case ImgoMediaPlayerLib.MEDIA_SMOOTH_SWITCH_SOURCE_INFO /* 603 */:
                                                DebugLog.d(imgoMediaPlayerLib.getLogTag(), "smooth switch video source info (" + message.arg1 + "," + message.arg2 + "," + message.obj + ")");
                                                imgoMediaPlayerLib.notifyOnSmoothSwitchSourceInfo(message.arg1, message.arg2, (String) message.obj);
                                                return;
                                            case ImgoMediaPlayerLib.MEDIA_SMOOTH_SWITCH_SOURCE_COMPLETE /* 604 */:
                                                DebugLog.d(imgoMediaPlayerLib.getLogTag(), "smooth switch video source complete (" + message.arg1 + "," + message.arg2 + "," + message.obj + ")");
                                                imgoMediaPlayerLib.notifyOnSmoothSwitchSourceComplete(message.arg1, message.arg2, (String) message.obj);
                                                return;
                                            case ImgoMediaPlayerLib.MEDIA_SMOOTH_SWITCH_SOURCE_FAILED /* 605 */:
                                                DebugLog.d(imgoMediaPlayerLib.getLogTag(), "smooth switch video source failed (" + message.arg1 + "," + message.arg2 + "," + message.obj + ")");
                                                imgoMediaPlayerLib.notifyOnSmoothSwitchSourceFailed(message.arg1, message.arg2, (String) message.obj);
                                                return;
                                            default:
                                                switch (i2) {
                                                    case 10001:
                                                        imgoMediaPlayerLib.mVideoSarNum = message.arg1;
                                                        imgoMediaPlayerLib.mVideoSarDen = message.arg2;
                                                        imgoMediaPlayerLib.notifyOnVideoSizeChanged(imgoMediaPlayerLib.mVideoWidth, imgoMediaPlayerLib.mVideoHeight, imgoMediaPlayerLib.mVideoSarNum, imgoMediaPlayerLib.mVideoSarDen);
                                                        return;
                                                    case 10002:
                                                        imgoMediaPlayerLib.mVideoDarNum = message.arg1;
                                                        imgoMediaPlayerLib.mVideoDarDen = message.arg2;
                                                        return;
                                                    case 10003:
                                                        imgoMediaPlayerLib.mVideoParNum = message.arg1;
                                                        imgoMediaPlayerLib.mVideoParDen = message.arg2;
                                                        return;
                                                    default:
                                                        DebugLog.d(imgoMediaPlayerLib.getLogTag(), "Unknown message type " + message.what);
                                                        return;
                                                }
                                        }
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    return;
                }
            }
            String str2 = ImgoMediaPlayerLib.TAG;
            if (imgoMediaPlayerLib != null) {
                str = "ImgoMediaPlayerLib went away with unhandled events. mNativeMediaPlayer:" + imgoMediaPlayerLib.mNativeMediaPlayer;
            } else {
                str = "ImgoMediaPlayerLib went away with unhandled events. player is null";
            }
            DebugLog.w(str2, str);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnMediaCodecSelectListener {
        boolean onCodecIsAdaptive(d dVar);

        String onMediaCodecSelect(d dVar, String str, int i, int i2);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnNativeInvokeListener {
        public static final String ARG_COMPAR_PLAYER_HASH_STRING = "player_hash";
        public static final String ARG_COMPAR_RETRY_COUNTER_INT = "retry_counter";
        public static final String ARG_COMPAR_SWITCH_KEY_LONG = "switch_key";
        public static final String ARG_COMPAR_USER_MSG_STRING = "user_msg";
        public static final String ARG_CRTL_RESET_IPLIST_INT = "reset_iplist";
        public static final String ARG_CRTL_RETRY_COUNTER_INT = "retry_counter";
        public static final String ARG_CRTL_RETRY_CUR_DL_SIZE = "cur_dl_dize";
        public static final String ARG_CRTL_RETRY_ERROR_EXTRA_INT = "error_code";
        public static final String ARG_CRTL_RETRY_ERROR_WHAT_INT = "error_type";
        public static final String ARG_CRTL_RETRY_ERR_IO_TYPE_INT = "io_type";
        public static final String ARG_CRTL_RETRY_IS_LAST_INT = "is_last";
        public static final String ARG_CRTL_RETRY_SEGMENT_INDEX_INT = "segment_index";
        public static final String ARG_CRTL_RETRY_SRC_URL_STRING = "src_url";
        public static final String ARG_CRTL_RETRY_URL_STRING = "url";
        public static final String ARG_CTRL_ADDR_ERROR_INT = "addr_error";
        public static final String ARG_CTRL_ADDR_HANDLE_INT = "addr_handle";
        public static final String ARG_CTRL_ADDR_HOSTNAME_STRING = "addr_hostname";
        public static final String ARG_CTRL_ADDR_IP_STRING = "addr_ip";
        public static final String ARG_CTRL_ADDR_URI_STRING = "addr_uri";
        public static final String ARG_CTRL_GET_ENV_KEY = "env_key";
        public static final String ARG_CTRL_GET_ENV_VALUE = "env_value";
        public static final String ARG_EVENT_AVCODEC_DECORDER_AVNAME_STRING = "codec_name";
        public static final String ARG_EVENT_STREAM_INFO_AFRAME_COMING_CLOCK_STRING = "afame_coming_info";
        public static final String ARG_EVENT_STREAM_INFO_DNS_ABORT_INFO_STRING = "dns_abort_time";
        public static final String ARG_EVENT_STREAM_INFO_DNS_SYNC_BEGIN_STRING = "dns_cache_value";
        public static final String ARG_EVENT_STREAM_INFO_DRM_METHOD_NAME_STRING = "drm_method";
        public static final String ARG_EVENT_STREAM_INFO_EVENT_IO_TRAFFIC_AVCACHEDTIMEMS_INT = "av_cached_time_ms";
        public static final String ARG_EVENT_STREAM_INFO_EVENT_IO_TRAFFIC_DLBYTES_INT = "update_dl_bytes";
        public static final String ARG_EVENT_STREAM_INFO_HLS_SEG_SIZE_INFO_STRING = "seg_size_info";
        public static final String ARG_EVENT_STREAM_INFO_VFRAME_COMING_CLOCK_STRING = "vfame_coming_info";
        public static final String ARG_EVENT_TIME_CONSUME_LONG = "time_consume";
        public static final String ARG_HOST_ARRR_ERROR_INT = "host_error";
        public static final String ARG_HOST_ARRR_FAMILY_INT = "host_family";
        public static final String ARG_HOST_ARRR_HOSTNAME_STRING = "host_hostname";
        public static final String ARG_HOST_ARRR_IP_STRING = "host_ip";
        public static final String ARG_HOST_ARRR_PORT_INT = "host_port";
        public static final String ARG_HTTP_CODE_INT = "http_code";
        public static final String ARG_HTTP_ERROR_INT = "http_error";
        public static final String ARG_HTTP_FILESIZE_LONG = "http_filesize";
        public static final String ARG_HTTP_OFFSET_LONG = "http_offset";
        public static final String ARG_HTTP_URL_STRING = "http_url";
        public static final String ARG_PLAYER_EVENT_ARG1_INT = "event_arg1";
        public static final String ARG_PLAYER_EVENT_ARG2_INT = "event_arg2";
        public static final String ARG_PLAYER_EVENT_TYPE_INT = "event_type";
        public static final String ARG_SMOOTH_SWITCH_KEY_LONG = "smooth_switch_key";
        public static final String ARG_SMOOTH_SWITCH_STREAM_AUDIO_INT = "smooth_switch_stream_audio";
        public static final String ARG_SMOOTH_SWITCH_URL_STRING = "smooth_switch_url";
        public static final String ARG_SMOOTH_SWITCH_VID_INT = "smooth_switch_vid";
        public static final String ARG_TCP_ERROR_INT = "error";
        public static final String ARG_TCP_FAMILY_INT = "family";
        public static final String ARG_TCP_FD_INT = "fd";
        public static final String ARG_TCP_HOSTNAME_STRING = "tcp_hostname";
        public static final String ARG_TCP_IP_STRING = "ip";
        public static final String ARG_TCP_PORT_INT = "port";
        public static final int CTRL_DID_TCP_CLOSE = 131076;
        public static final int CTRL_DID_TCP_OPEN = 131074;
        public static final int CTRL_WILL_ADDRESS_BYNAME = 131078;
        public static final int CTRL_WILL_CHECK_PAUSE_LOAD = 131120;
        public static final int CTRL_WILL_CONCAT_RESOLVE_SEGMENT = 131079;
        public static final int CTRL_WILL_GET_ENV = 131104;
        public static final int CTRL_WILL_HDJ_URL_SWITCH = 131090;
        public static final int CTRL_WILL_HTTP_OPEN = 131075;
        public static final int CTRL_WILL_LIVE_OPEN = 131077;
        public static final int CTRL_WILL_LIVE_RESET = 131081;
        public static final int CTRL_WILL_LOOP_OPEN = 131088;
        public static final int CTRL_WILL_LOOP_RESET = 131089;
        public static final int CTRL_WILL_SMOOTH_SWITCH = 131184;
        public static final int CTRL_WILL_TCP_OPEN = 131073;
        public static final int EVENT_AVCODEC_DECORDER_AUDIO_NAME = 33;
        public static final int EVENT_AVCODEC_DECORDER_VIDEO_NAME = 32;
        public static final int EVENT_DID_HOST_ADDR = 78338;
        public static final int EVENT_DID_HTTP_CLOSE = 6;
        public static final int EVENT_DID_HTTP_OPEN = 2;
        public static final int EVENT_DID_HTTP_SEEK = 4;
        public static final int EVENT_FLOW_INFO_REPORT = 78593;
        public static final int EVENT_STREAM_INFO_AFRAME_COMING_CLOCK = 81;
        public static final int EVENT_STREAM_INFO_DNS_ABORT_INFO = 49;
        public static final int EVENT_STREAM_INFO_DNS_SYNC_BEGIN = 64;
        public static final int EVENT_STREAM_INFO_DRM_METHOD_NAME = 41;
        public static final int EVENT_STREAM_INFO_EVENT_IO_TRAFFIC = 74244;
        public static final int EVENT_STREAM_INFO_HLS_SEG_SIZE_INFO = 48;
        public static final int EVENT_STREAM_INFO_VFRAME_COMING_CLOCK = 80;
        public static final int EVENT_TIME_CONSUME_DNS_ANALYZE = 16;
        public static final int EVENT_TIME_CONSUME_FIND_STREAM = 19;
        public static final int EVENT_TIME_CONSUME_FIRST_BUFFER = 20;
        public static final int EVENT_TIME_CONSUME_HTTP_RESPONSE = 18;
        public static final int EVENT_TIME_CONSUME_PAUSE_NOTIFY = 22;
        public static final int EVENT_TIME_CONSUME_TCP_CONNECT = 17;
        public static final int EVENT_WILL_HOST_ADDR = 78337;
        public static final int EVENT_WILL_HTTP_CLOSE = 5;
        public static final int EVENT_WILL_HTTP_OPEN = 1;
        public static final int EVENT_WILL_HTTP_SEEK = 3;
        public static final int MEDIA_ERROR_ENETUNREACH = 300005;
        public static final int MEDIA_ERROR_HTTP_BAD_REQUEST_400 = 300400;
        public static final int MEDIA_ERROR_HTTP_OTHER_4XX = 300499;
        public static final int MEDIA_ERROR_HTTP_SERVER_INTERNAL_ERROR_500 = 300500;
        public static final int MEDIA_ERROR_HTTP_SERVER_OTHER_5XX = 300599;
        public static final int MEDIA_ERROR_TCP_HOSTNAME_RESOLVE_ERROR = 300600;
        public static final int PLAYER_EVENT_ONINFO = 131152;

        boolean onNativeInvoke(int i, Bundle bundle);
    }

    public ImgoMediaPlayerLib(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, OutOfMemoryError {
        this.mWakeLock = null;
        this.mIsReleased = false;
        initPlayer(context);
    }

    public ImgoMediaPlayerLib(Context context, Bundle bundle) {
        super(bundle);
        this.mWakeLock = null;
        this.mIsReleased = false;
        initPlayer(context);
    }

    private native String _getAudioCodecInfo();

    private static final native String _getColorFormatName(int i);

    private native int _getLoopCount();

    private native Bundle _getMediaMeta();

    private native int _getPicture32(int i, int i2, int[] iArr);

    private native float _getPropertyFloat(int i, float f);

    private native long _getPropertyLong(int i, long j);

    private static final native String _getSupportRecVideoformat();

    private native String _getVideoCodecInfo();

    private native int _isAbortRequest();

    private native boolean _isVideoRecording();

    private native int _loopswitchSource(IMGTVMediaDataSource iMGTVMediaDataSource, String str, int i, int i2, int i3) throws IllegalStateException, OutOfMemoryError;

    private native int _loopswitchSource(String str, int i, int i2, int i3) throws IllegalStateException, OutOfMemoryError;

    private native void _pause() throws IllegalStateException;

    private native void _pauseLoadData(int i);

    private native int _recordVideo(String str, int i) throws IOException, IllegalArgumentException, IllegalStateException;

    private native void _release();

    private native void _reset(Object obj);

    private native void _seekTo(long j) throws IllegalStateException;

    private native void _seekTo2(long j, int i) throws IllegalStateException;

    private native void _setDataSource(IMGTVMediaDataSource iMGTVMediaDataSource, int i) throws IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSource(String str, String[] strArr, String[] strArr2) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDataSourceFd(int i) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    private native void _setDrmLicensePrepared(int i);

    private native void _setDrmLicensePrepared(int i, MediaCrypto mediaCrypto);

    private native void _setFrameImageAtTime(String str, long j, long j2, int i, int i2, int i3);

    private native void _setLoopCount(int i);

    private native void _setOption(int i, String str, long j);

    private native void _setOption(int i, String str, String str2);

    private native void _setPropertyFloat(int i, float f);

    private native void _setPropertyLong(int i, long j);

    private native void _setPropertyLongab(int i, long j, long j2);

    private native void _setStreamSelected(int i, boolean z);

    private native int _setVideoKeyFrameInfo(byte[] bArr);

    private native void _setVideoSurface(Surface surface);

    private native void _setVideoSurfaceKey(Surface surface, int i);

    private native int _setWanosAudioEffectConfig(byte[] bArr);

    private native int _smoothswitchSource(IMGTVMediaDataSource iMGTVMediaDataSource, String str, int i, int i2, int i3, int i4, String str2) throws IllegalStateException, OutOfMemoryError;

    private native int _smoothswitchSource(String str, int i, int i2, int i3, int i4, String str2) throws IllegalStateException, OutOfMemoryError;

    private native void _start() throws IllegalStateException;

    private native void _stop() throws IllegalStateException;

    private native int _switchSource(IMGTVMediaDataSource iMGTVMediaDataSource, String str, int i, int i2, int i3) throws IOException, IllegalArgumentException, IllegalStateException;

    private native int _switchSource(String str, int i, int i2, int i3) throws IOException, IllegalArgumentException, IllegalStateException;

    public static void defaultValue(Context context) {
        PreferencesUtil preferencesUtil = new PreferencesUtil(context);
        preferencesUtil.removeKey(PreferencesUtil.PREKEY_MEDIACODEC_H264_SUPPORT_BASELINE);
        preferencesUtil.removeKey(PreferencesUtil.PREKEY_MEDIACODEC_H264_SUPPORT_MAIN);
        preferencesUtil.removeKey(PreferencesUtil.PREKEY_MEDIACODEC_H264_SUPPORT_HIGH);
        preferencesUtil.removeKey(PreferencesUtil.PREKEY_MEDIACODEC_H265_SUPPORT);
    }

    private void enableUpdateAudioTimestamp() {
        int i = (!NetPlayConfig.isAudioTimestampEnable() || Build.VERSION.SDK_INT < 19) ? 5 : 1;
        _setPropertyLong(FFP_PROP_INT64_AUDIO_TIMESTAMP_STATUS, i);
        String logTag = getLogTag();
        DebugLog.i(logTag, "enableUpdateAudioTimestamp:" + i);
    }

    private static String getAppPackageName() {
        return mPackageName;
    }

    public static String getColorFormatName(int i) {
        return _getColorFormatName(i);
    }

    public static String getDlopenStatus() {
        return native_getDlopenStatus();
    }

    public static String getSupportRecVideoformat() {
        return _getSupportRecVideoformat();
    }

    public static int getTinkerNumber() {
        return native_getTinkerNumber();
    }

    private static void initNativeOnce() {
        synchronized (ImgoMediaPlayerLib.class) {
            if (!mIsNativeInitialized) {
                native_init(PlayerConfig.use_report_level, PlayerConfig.use_log_level);
                mIsNativeInitialized = true;
            }
        }
    }

    private void initPlayer(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, OutOfMemoryError {
        EventHandler eventHandler;
        this.mContext = context;
        mPackageName = context.getPackageName();
        if (ImgoLibLoader.getInstance().syncTryLoadAllLibraries(context)) {
            defaultValue(context);
        }
        initNativeOnce();
        g.r(context);
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            eventHandler = new EventHandler(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == null) {
                this.mEventHandler = null;
                WeakReference<ImgoMediaPlayerLib> weakReference = new WeakReference<>(this);
                this.mWeakImgoPlayer = weakReference;
                native_setup(weakReference);
            }
            eventHandler = new EventHandler(this, mainLooper);
        }
        this.mEventHandler = eventHandler;
        WeakReference<ImgoMediaPlayerLib> weakReference2 = new WeakReference<>(this);
        this.mWeakImgoPlayer = weakReference2;
        native_setup(weakReference2);
    }

    private final native void native_finalize();

    private static final native String native_getDlopenStatus();

    private static final native int native_getTinkerNumber();

    private static final native void native_init(int i, int i2);

    private final native void native_message_loop(Object obj);

    private final native void native_setup(Object obj);

    private static boolean onCodecIsAdaptive(Object obj) {
        d dVar;
        if (obj == null || !(obj instanceof WeakReference) || (dVar = (ImgoMediaPlayerLib) ((WeakReference) obj).get()) == null) {
            return false;
        }
        OnMediaCodecSelectListener onMediaCodecSelectListener = ((ImgoMediaPlayerLib) dVar).mOnMediaCodecSelectListener;
        if (onMediaCodecSelectListener == null) {
            onMediaCodecSelectListener = DefaultMediaCodecSelector.sInstance;
        }
        return onMediaCodecSelectListener.onCodecIsAdaptive(dVar);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    private static boolean onNativeInvoke(java.lang.Object r2, int r3, android.os.Bundle r4) {
        /*
            if (r2 == 0) goto L60
            boolean r0 = r2 instanceof java.lang.ref.WeakReference
            if (r0 == 0) goto L60
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2
            java.lang.Object r2 = r2.get()
            com.hunantv.media.player.libnative.ImgoMediaPlayerLib r2 = (com.hunantv.media.player.libnative.ImgoMediaPlayerLib) r2
            if (r2 == 0) goto L58
            r0 = 32
            r1 = 0
            if (r3 == r0) goto L54
            r0 = 33
            if (r3 == r0) goto L54
            r0 = 48
            if (r3 == r0) goto L54
            r0 = 49
            if (r3 == r0) goto L54
            r0 = 80
            if (r3 == r0) goto L54
            r0 = 81
            if (r3 == r0) goto L54
            r0 = 78337(0x13201, float:1.09774E-40)
            if (r3 == r0) goto L50
            r0 = 78338(0x13202, float:1.09775E-40)
            if (r3 == r0) goto L50
            switch(r3) {
                case 1: goto L50;
                case 2: goto L50;
                case 3: goto L50;
                case 4: goto L50;
                case 5: goto L50;
                case 6: goto L50;
                default: goto L36;
            }
        L36:
            switch(r3) {
                case 16: goto L50;
                case 17: goto L50;
                case 18: goto L50;
                case 19: goto L50;
                case 20: goto L50;
                default: goto L39;
            }
        L39:
            switch(r3) {
                case 22: goto L50;
                case 41: goto L54;
                case 64: goto L54;
                case 74244: goto L54;
                case 78593: goto L47;
                case 131081: goto L4b;
                case 131104: goto L4b;
                case 131120: goto L4b;
                case 131152: goto L43;
                case 131184: goto L4b;
                default: goto L3c;
            }
        L3c:
            switch(r3) {
                case 131073: goto L4b;
                case 131074: goto L4b;
                case 131075: goto L4b;
                case 131076: goto L4b;
                case 131077: goto L4b;
                case 131078: goto L4b;
                case 131079: goto L4b;
                default: goto L3f;
            }
        L3f:
            switch(r3) {
                case 131088: goto L4b;
                case 131089: goto L4b;
                case 131090: goto L4b;
                default: goto L42;
            }
        L42:
            return r1
        L43:
            r2.notifyOnPlayerEvent(r3, r4)
            return r1
        L47:
            r2.notifyOnSourceFlowInfoEvent(r3, r4)
            return r1
        L4b:
            boolean r2 = r2.notifyOnSourceNetCtrl(r3, r4)
            return r2
        L50:
            r2.notifyOnSourceNetEvent(r3, r4)
            return r1
        L54:
            r2.notifyOnStreamInfoEvent(r3, r4)
            return r1
        L58:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "<null weakPlayer>.onNativeInvoke()"
            r2.<init>(r3)
            throw r2
        L60:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "<null weakThiz>.onNativeInvoke()"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.player.libnative.ImgoMediaPlayerLib.onNativeInvoke(java.lang.Object, int, android.os.Bundle):boolean");
    }

    private static String onSelectCodec(Object obj, String str, int i, int i2) {
        d dVar;
        if (obj == null || !(obj instanceof WeakReference) || (dVar = (ImgoMediaPlayerLib) ((WeakReference) obj).get()) == null) {
            return null;
        }
        OnMediaCodecSelectListener onMediaCodecSelectListener = ((ImgoMediaPlayerLib) dVar).mOnMediaCodecSelectListener;
        if (onMediaCodecSelectListener == null) {
            onMediaCodecSelectListener = DefaultMediaCodecSelector.sInstance;
        }
        return onMediaCodecSelectListener.onMediaCodecSelect(dVar, str, i, i2);
    }

    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        ImgoMediaPlayerLib imgoMediaPlayerLib;
        if (obj == null || (imgoMediaPlayerLib = (ImgoMediaPlayerLib) ((WeakReference) obj).get()) == null) {
            return;
        }
        if (i == 200 && i2 == 2) {
            imgoMediaPlayerLib.start();
        }
        if (i == 200 && i2 == 10002) {
            String logTag = imgoMediaPlayerLib.getLogTag();
            DebugLog.d(logTag, "obtainmsg Info (" + i2 + "," + i3 + ")");
        }
        EventHandler eventHandler = imgoMediaPlayerLib.mEventHandler;
        if (eventHandler != null) {
            imgoMediaPlayerLib.mEventHandler.sendMessage(eventHandler.obtainMessage(i, i2, i3, obj2));
        }
    }

    private void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException, IllegalArgumentException, IllegalStateException {
        setDataSource(fileDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Wakelock"})
    public void stayAwake(boolean z) {
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (z && !wakeLock.isHeld()) {
                this.mWakeLock.acquire();
            } else if (!z && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        }
        this.mStayAwake = z;
        updateSurfaceScreenOn();
    }

    private void updateSurfaceScreenOn() {
        Context context;
        Window window;
        try {
            boolean z = this.mScreenOnWhilePlaying && this.mStayAwake;
            String logTag = getLogTag();
            DebugLog.i(logTag, "updateSurfaceScreenOn " + z);
            SurfaceHolder surfaceHolder = this.mSurfaceHolder;
            if (surfaceHolder != null) {
                surfaceHolder.setKeepScreenOn(z);
            } else if (!z || (context = this.mContext) == null || !(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null) {
            } else {
                window.addFlags(128);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public native void _prepareAsync() throws IllegalStateException;

    public void deselectTrack(int i) {
        _setStreamSelected(i, false);
    }

    public void enableFramePTSNotify(boolean z) {
        _setPropertyLong(FFP_PROP_INT64_FRAME_PTS_NOTIFY, z ? 1L : 0L);
    }

    public void enableOppoFunc(int i, boolean z) {
        long j;
        int i2;
        if (i == 1) {
            j = z ? 1L : 0L;
            i2 = FFP_PROP_INT64_OPPOSR_ENALBE;
        } else if (i != 2) {
            return;
        } else {
            j = z ? 1L : 0L;
            i2 = FFP_PROP_INT64_OPPOOSIE_ENALBE;
        }
        _setPropertyLong(i2, j);
    }

    public void enableP2PSmoothFailMode(boolean z) {
        _setPropertyLong(FFP_PROP_INT64_P2P_SMOOTH_FAIL, z ? 1L : 0L);
    }

    public void enableSmoothAccSeek(boolean z) {
        _setPropertyLong(FFP_PROP_INT64_SMOOTH_ACCSEEK, z ? 1L : 0L);
    }

    public void finalize() throws Throwable {
        super/*java.lang.Object*/.finalize();
        String logTag = getLogTag();
        DebugLog.e(logTag, "finalize mIsReleased:" + this.mIsReleased);
    }

    public long getAVCachedBytes() {
        return _getPropertyLong(FFP_PROP_INT64_AV_CACHED_BYTES, 0L);
    }

    public long getAVCachedTimeMs() {
        return _getPropertyLong(FFP_PROP_INT64_AV_CACHED_TIMEMS, 0L);
    }

    public float getAVDelay() {
        return _getPropertyFloat(FFP_PROP_FLOAT_AVDELAY, 0.0f);
    }

    public float getAVDiff() {
        return _getPropertyFloat(FFP_PROP_FLOAT_AVDIFF, 0.0f);
    }

    public long getAsyncStatisticBufBackwards() {
        return _getPropertyLong(FFP_PROP_INT64_ASYNC_STATISTIC_BUF_BACKWARDS, 0L);
    }

    public long getAsyncStatisticBufCapacity() {
        return _getPropertyLong(FFP_PROP_INT64_ASYNC_STATISTIC_BUF_CAPACITY, 0L);
    }

    public long getAsyncStatisticBufForwards() {
        return _getPropertyLong(FFP_PROP_INT64_ASYNC_STATISTIC_BUF_FORWARDS, 0L);
    }

    public long getAudioCachedBytes() {
        return _getPropertyLong(FFP_PROP_INT64_AUDIO_CACHED_BYTES, 0L);
    }

    public long getAudioCachedDuration() {
        return _getPropertyLong(FFP_PROP_INT64_AUDIO_CACHED_DURATION, 0L);
    }

    public long getAudioCachedPackets() {
        return _getPropertyLong(FFP_PROP_INT64_AUDIO_CACHED_PACKETS, 0L);
    }

    public native int getAudioSessionId();

    public long getBitRate() {
        return _getPropertyLong(FFP_PROP_INT64_BIT_RATE, 0L);
    }

    public int getBufferedPercentage() {
        return this.mBufferedPercent;
    }

    public long getBufferedPositionMs() {
        return this.mBufferedPositionMs;
    }

    public int getBufferingPercent() {
        return this.mCurBufferingPercent;
    }

    public native long getCurrentPosition();

    public String getDataSource() {
        return this.mDataSource;
    }

    public long getDrmPreparedStatus() {
        return _getPropertyLong(FFP_PROP_INT64_DRM_PREPEARED_STATUE, 0L);
    }

    public native long getDuration();

    public float getFileStartTime() {
        return _getPropertyFloat(FFP_PROP_FLOAT_FILE_START_TIME, -1.0f);
    }

    public long getGenframetimeStatisticDecodeFirstFrame() {
        return _getPropertyLong(20505, -1L);
    }

    public long getGenframetimeStatisticDropFrameNum() {
        return _getPropertyLong(20510, -1L);
    }

    public long getGenframetimeStatisticGenFinishTotalTime() {
        return _getPropertyLong(20512, -1L);
    }

    public long getGenframetimeStatisticGenImageNum() {
        return _getPropertyLong(20511, -1L);
    }

    public long getGenframetimeStatisticT1() {
        return _getPropertyLong(20501, -1L);
    }

    public long getGenframetimeStatisticT2() {
        return _getPropertyLong(20502, -1L);
    }

    public long getGenframetimeStatisticT3() {
        return _getPropertyLong(20503, -1L);
    }

    public long getGenframetimeStatisticT4() {
        return _getPropertyLong(20504, -1L);
    }

    public long getGenframetimeStatisticTotalDecodeTime() {
        return _getPropertyLong(20506, -1L);
    }

    public long getGenframetimeStatisticTotalEncodeTime() {
        return _getPropertyLong(20508, -1L);
    }

    public long getGenframetimeStatisticTotalSaveFile() {
        return _getPropertyLong(20509, -1L);
    }

    public long getGenframetimeStatisticTotalScaleTime() {
        return _getPropertyLong(20507, -1L);
    }

    public c.a.a.a.d getMediaInfo() {
        c.a.a.a.d dVar = new c.a.a.a.d();
        dVar.a = "Imgoplayer";
        String _getVideoCodecInfo = _getVideoCodecInfo();
        if (!TextUtils.isEmpty(_getVideoCodecInfo)) {
            String[] split = _getVideoCodecInfo.split(",");
            if (split.length >= 2) {
                dVar.b = split[0];
                dVar.c = split[1];
            } else if (split.length >= 1) {
                dVar.b = split[0];
                dVar.c = "";
            }
        }
        String _getAudioCodecInfo = _getAudioCodecInfo();
        if (!TextUtils.isEmpty(_getAudioCodecInfo)) {
            String[] split2 = _getAudioCodecInfo.split(",");
            if (split2.length >= 2) {
                dVar.d = split2[0];
                dVar.e = split2[1];
            } else if (split2.length >= 1) {
                dVar.d = split2[0];
                dVar.e = "";
            }
        }
        try {
            dVar.f = e.d(_getMediaMeta());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return dVar;
    }

    public Bundle getMediaMeta() {
        return _getMediaMeta();
    }

    public long getPImgoVsrExeInfo(int i, long j) {
        return _getPropertyLong(i, j);
    }

    public int getPicture32(int i, int i2, int[] iArr) {
        return _getPicture32(i, i2, iArr);
    }

    public float getPlaybackSpeed() {
        return _getPropertyFloat(10003, 0.0f);
    }

    public float getPropertyFloat(int i, float f) {
        try {
            return _getPropertyFloat(i, f);
        } catch (Exception e) {
            e.printStackTrace();
            return f;
        } catch (Throwable th) {
            th.printStackTrace();
            return f;
        }
    }

    public long getPropertyLong(int i, long j) {
        try {
            return _getPropertyLong(i, j);
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        } catch (Throwable th) {
            th.printStackTrace();
            return j;
        }
    }

    public int getSelectedTrack(int i) {
        int i2;
        if (i == 1) {
            i2 = FFP_PROP_INT64_SELECTED_VIDEO_STREAM;
        } else if (i == 2) {
            i2 = FFP_PROP_INT64_SELECTED_AUDIO_STREAM;
        } else if (i != 3) {
            return -1;
        } else {
            i2 = FFP_PROP_INT64_SELECTED_TIMEDTEXT_STREAM;
        }
        return (int) _getPropertyLong(i2, -1L);
    }

    public long getTcpDownloadSpeed() {
        return _getPropertyLong(FFP_PROP_INT64_TCP_SPEED, 0L);
    }

    public b[] getTrackInfo() {
        e d;
        int i;
        Bundle mediaMeta = getMediaMeta();
        if (mediaMeta == null || (d = e.d(mediaMeta)) == null || d.f == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = d.f.iterator();
        while (it.hasNext()) {
            e.a aVar = (e.a) it.next();
            b bVar = new b(aVar);
            if (aVar.c.equalsIgnoreCase("video")) {
                i = 1;
            } else if (aVar.c.equalsIgnoreCase("audio")) {
                i = 2;
            } else if (aVar.c.equalsIgnoreCase("text")) {
                i = 3;
            } else {
                arrayList.add(bVar);
            }
            bVar.b(i);
            arrayList.add(bVar);
        }
        return (b[]) arrayList.toArray(new b[arrayList.size()]);
    }

    public long getTrafficStatisticByteCount() {
        return _getPropertyLong(FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT, 0L);
    }

    public long getVVTimeStatisticDLPT() {
        return _getPropertyLong(FFP_PROP_INT64_VVTTIME_DLPT, 0L);
    }

    public long getVVTimeStatisticT1() {
        return _getPropertyLong(FFP_PROP_INT64_VVTTIME_T1, 0L);
    }

    public long getVVTimeStatisticT2() {
        return _getPropertyLong(FFP_PROP_INT64_VVTTIME_T2, 0L);
    }

    public long getVVTimeStatisticT3() {
        return _getPropertyLong(FFP_PROP_INT64_VVTTIME_T3, 0L);
    }

    public long getVVTimeStatisticT4() {
        return _getPropertyLong(FFP_PROP_INT64_VVTTIME_T4, 0L);
    }

    public long getVVTimeStatisticT5() {
        return _getPropertyLong(FFP_PROP_INT64_VVTTIME_T5, 0L);
    }

    public long getVVTimeStatisticT6() {
        return _getPropertyLong(FFP_PROP_INT64_VVTTIME_T6, 0L);
    }

    public long getVVTimeStatisticVVBT() {
        return _getPropertyLong(FFP_PROP_INT64_VVTTIME_VVBT, 0L);
    }

    public long getVVTimeStatisticVVT() {
        return _getPropertyLong(FFP_PROP_INT64_VVTTIME_VVT, 0L);
    }

    public long getVideoCachedBytes() {
        return _getPropertyLong(FFP_PROP_INT64_VIDEO_CACHED_BYTES, 0L);
    }

    public long getVideoCachedDuration() {
        return _getPropertyLong(FFP_PROP_INT64_VIDEO_CACHED_DURATION, 0L);
    }

    public long getVideoCachedPackets() {
        return _getPropertyLong(FFP_PROP_INT64_VIDEO_CACHED_PACKETS, 0L);
    }

    public int getVideoDarDen() {
        return this.mVideoDarDen;
    }

    public int getVideoDarNum() {
        return this.mVideoDarNum;
    }

    public float getVideoDecodeFramesPerSecond() {
        return _getPropertyFloat(10001, 0.0f);
    }

    public int getVideoDecoder() {
        return (int) _getPropertyLong(FFP_PROP_INT64_VIDEO_DECODER, 0L);
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public float getVideoOutputFramesPerSecond() {
        return _getPropertyFloat(10002, 0.0f);
    }

    public int getVideoParDen() {
        return this.mVideoParDen;
    }

    public int getVideoParNum() {
        return this.mVideoParNum;
    }

    public int getVideoSarDen() {
        return this.mVideoSarDen;
    }

    public int getVideoSarNum() {
        return this.mVideoSarNum;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public int getWanosAudioEffectChoice() {
        return (int) _getPropertyLong(FFP_PROP_INT64_WANOS_AUDIO_EFFECT, -1L);
    }

    public boolean isAbortRequest() {
        return _isAbortRequest() == 1;
    }

    public boolean isLooping() {
        return _getLoopCount() != 1;
    }

    public boolean isMediaCodecSWRender() {
        return _getPropertyLong(FFP_PROP_INT64_IS_CODEC_SW_RENDER, 0L) == 1;
    }

    public boolean isPlayable() {
        return true;
    }

    public native boolean isPlaying();

    public boolean isSupportedSnapshot() {
        return _getPropertyLong(FFP_PROP_INT64_IS_SUPPORT_SNAPSHOT, 0L) == 1;
    }

    public boolean isVideoRecording() {
        return _isVideoRecording();
    }

    public int loopSwitchVideoSource(IMGTVMediaDataSource iMGTVMediaDataSource, String str, int i, int i2, int i3) throws IllegalStateException, OutOfMemoryError {
        return _loopswitchSource(iMGTVMediaDataSource, str, i, i2, i3);
    }

    public int loopSwitchVideoSource(String str, int i, int i2, int i3) throws IllegalStateException, OutOfMemoryError {
        return _loopswitchSource(str, i, i2, i3);
    }

    public void maybeUpdateAudioTimestamp() {
        enableUpdateAudioTimestamp();
    }

    public void nativeCrashTest(int i) {
        _setPropertyLong(FFP_PROP_INT64_CRASH_TEST, i);
    }

    public void pause() throws IllegalStateException {
        stayAwake(false);
        _pause();
    }

    public void pauseLoadData(boolean z) {
        _pauseLoadData(z ? 1 : 0);
    }

    public void prepareAsync() throws IllegalStateException {
        _prepareAsync();
    }

    public void release() {
        this.mIsReleased = true;
        this.mCurBufferingPercent = 0;
        this.mBufferedPercent = 0;
        this.mBufferedPositionMs = 0L;
        this.mCurrentRecFile = null;
        stayAwake(false);
        updateSurfaceScreenOn();
        resetListeners();
        try {
            _release();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void reset() throws OutOfMemoryError {
        this.mCurBufferingPercent = 0;
        this.mBufferedPercent = 0;
        this.mBufferedPositionMs = 0L;
        this.mCurrentRecFile = null;
        stayAwake(false);
        _reset(this.mWeakImgoPlayer);
        this.mEventHandler.removeCallbacksAndMessages(null);
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    public void resetListeners() {
        super.resetListeners();
        this.mOnMediaCodecSelectListener = null;
    }

    public void seekTo(long j) throws IllegalStateException {
        _seekTo(j);
    }

    public void seekTo(long j, int i) throws IllegalStateException {
        _seekTo2(j, i);
    }

    public void selectTrack(int i) {
        _setStreamSelected(i, true);
    }

    public void setAudioAttributes(AudioAttributes audioAttributes) throws IllegalArgumentException {
    }

    public void setAudioStreamType(int i) {
    }

    public native void setCrashRecordPath(String str);

    public void setDataSource(IMGTVMediaDataSource iMGTVMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException {
        _setDataSource(iMGTVMediaDataSource, 0);
    }

    public void setDataSource(IMGTVMediaDataSource iMGTVMediaDataSource, int i) throws IllegalArgumentException, SecurityException, IllegalStateException {
        _setDataSource(iMGTVMediaDataSource, i);
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException {
        _setDataSource(iMediaDataSource);
    }

    @TargetApi(13)
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        if (Build.VERSION.SDK_INT >= 12) {
            ParcelFileDescriptor dup = ParcelFileDescriptor.dup(fileDescriptor);
            try {
                _setDataSourceFd(dup.getFd());
                return;
            } finally {
                dup.close();
            }
        }
        try {
            Field declaredField = fileDescriptor.getClass().getDeclaredField("descriptor");
            declaredField.setAccessible(true);
            _setDataSourceFd(declaredField.getInt(fileDescriptor));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mCurBufferingPercent = 0;
        this.mBufferedPercent = 0;
        this.mBufferedPositionMs = 0L;
        this.mDataSource = str;
        _setDataSource(str, null, null);
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        _setVideoSurface(surfaceHolder != null ? surfaceHolder.getSurface() : null);
        updateSurfaceScreenOn();
    }

    public void setDisplay(SurfaceHolder surfaceHolder, int i) {
        this.mSurfaceHolder = surfaceHolder;
        _setVideoSurfaceKey(surfaceHolder != null ? surfaceHolder.getSurface() : null, i);
        updateSurfaceScreenOn();
    }

    public void setDrmLicensePrepared(int i) {
        _setDrmLicensePrepared(i);
    }

    public void setDrmLicensePrepared(MediaCrypto mediaCrypto) {
        _setDrmLicensePrepared(1, mediaCrypto);
    }

    public void setFrameImageAtTime(String str, long j, long j2, int i, int i2, int i3) {
        _setFrameImageAtTime(str, j, j2, i, i2, i3);
    }

    public void setKeepInBackground(boolean z) {
    }

    public int setKeyFrameInfoFileBuf(byte[] bArr) {
        try {
            return _setVideoKeyFrameInfo(bArr);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return -31;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -32;
        }
    }

    public void setLogEnabled(boolean z) {
    }

    public native void setLogReport(int i, int i2);

    public void setLoopABPlay(boolean z, long j, long j2) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "setLoopABPlay enable:" + z + ",aPos:" + j + ",bPos:" + j2);
        _setPropertyLongab(FFP_PROP_INT64_LOOPAB_TARGET_POS, z ? j : -1L, z ? j2 : -1L);
    }

    public void setLoopSeekPlay(boolean z, long j) {
        _setPropertyLongab(FFP_PROP_INT64_LOOP_SEEK, z ? 1L : 0L, j);
    }

    public void setLooping(boolean z) {
        int i = !z ? 1 : 0;
        setOption(4, "loop", i);
        _setLoopCount(i);
    }

    public void setNETIsBroken(boolean z) {
        _setPropertyLong(FFP_PROP_INT64_NET_BROKEN, z ? 1L : 0L);
    }

    public void setOnMediaCodecSelectListener(OnMediaCodecSelectListener onMediaCodecSelectListener) {
        this.mOnMediaCodecSelectListener = onMediaCodecSelectListener;
    }

    public void setOption(int i, String str, long j) {
        _setOption(i, str, j);
    }

    public void setOption(int i, String str, String str2) {
        _setOption(i, str, str2);
    }

    public void setPlaybackSpeed(float f) {
        _setPropertyFloat(10003, (f < 0.25f || f > 4.0f) ? 1.0f : 1.0f);
    }

    public void setPlaybackStep(int i) {
        _setPropertyLong(FFP_PROP_INT64_STEP_PLAYBACK, i);
    }

    public void setPropertyLong(int i, long j) {
        try {
            _setPropertyLong(i, j);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setScreenOnWhilePlaying(boolean z) {
        if (this.mScreenOnWhilePlaying != z) {
            if (z && this.mSurfaceHolder == null) {
                DebugLog.w(getLogTag(), "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = z;
            updateSurfaceScreenOn();
        }
    }

    public void setSurface(Surface surface) {
        if (this.mScreenOnWhilePlaying && surface != null) {
            DebugLog.w(getLogTag(), "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        this.mSurfaceHolder = null;
        _setVideoSurface(surface);
        updateSurfaceScreenOn();
    }

    public void setSurface(Surface surface, int i) {
        if (this.mScreenOnWhilePlaying && surface != null) {
            DebugLog.w(getLogTag(), "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        this.mSurfaceHolder = null;
        _setVideoSurfaceKey(surface, i);
        updateSurfaceScreenOn();
    }

    public void setVideoFrameTimeClockNotify(long j, long j2) {
        setVideoFrameTimePTSClockNotify(j, j2);
    }

    public void setVideoFrameTimeMsClockNotify(long j) {
        _setPropertyLong(FFP_PROP_INT64_CLOCK_NOTIFY, j);
    }

    public void setVideoFrameTimePTSClockNotify(long j, long j2) {
        _setPropertyLong(FFP_PROP_INT64_CLOCK_VPTS_NOTIFY_START, j);
        _setPropertyLong(FFP_PROP_INT64_CLOCK_VPTS_NOTIFY_END, j2);
    }

    public native void setVolume(float f, float f2);

    @SuppressLint({"Wakelock"})
    public void setWakeMode(Context context, int i) {
        boolean z;
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                z = true;
                this.mWakeLock.release();
            } else {
                z = false;
            }
            this.mWakeLock = null;
        } else {
            z = false;
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i | Label.FORWARD_REFERENCE_TYPE_WIDE, ImgoMediaPlayerLib.class.getName());
        this.mWakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        if (z) {
            this.mWakeLock.acquire();
        }
    }

    public void setWanosAudioEffectChoice(int i) {
        _setPropertyLong(FFP_PROP_INT64_WANOS_AUDIO_EFFECT, i);
    }

    public int setWanosAudioEffectConfig(byte[] bArr) {
        return _setWanosAudioEffectConfig(bArr);
    }

    public void setWanosAudioEffectEnable(boolean z) {
        _setPropertyLong(FFP_PROP_INT64_ENABLE_WANOS_AUDIO_EFFECT, z ? 1L : 0L);
    }

    public int smoothSwitchVideoSource(IMGTVMediaDataSource iMGTVMediaDataSource, String str, int i, int i2, int i3, int i4, String str2) throws IllegalStateException, OutOfMemoryError {
        String logTag = getLogTag();
        DebugLog.i(logTag, "smoothSwitchVideoSource " + iMGTVMediaDataSource + " key:" + i + ",switch_mod:" + i2 + ",is_smooth:" + i3 + ",arg:" + i4);
        return _smoothswitchSource(iMGTVMediaDataSource, str, i, i2, i3, i4, str2);
    }

    public int smoothSwitchVideoSource(String str, int i, int i2, int i3, int i4, String str2) throws IllegalStateException, OutOfMemoryError {
        String logTag = getLogTag();
        DebugLog.i(logTag, "smoothSwitchVideoSource key:" + i + ",switch_mod:" + i2 + ",is_smooth:" + i3 + ",arg:" + i4);
        return _smoothswitchSource(str, i, i2, i3, i4, str2);
    }

    public void start() throws IllegalStateException {
        stayAwake(true);
        _start();
    }

    public int startRecordVideo(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        int _recordVideo = _recordVideo(str, 1);
        if (_recordVideo == 0) {
            this.mCurrentRecFile = str;
        }
        return _recordVideo;
    }

    public void stop() throws IllegalStateException {
        this.mCurBufferingPercent = 0;
        this.mBufferedPercent = 0;
        this.mBufferedPositionMs = 0L;
        stayAwake(false);
        try {
            _stop();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public int stopRecordVideo() throws IOException, IllegalArgumentException, IllegalStateException {
        return _recordVideo(this.mCurrentRecFile, 0);
    }

    public void switchVideoSource(IMGTVMediaDataSource iMGTVMediaDataSource, String str, int i, int i2, int i3) throws IOException, IllegalArgumentException, IllegalStateException {
        int _switchSource = _switchSource(iMGTVMediaDataSource, str, i, i2, i3);
        if (_switchSource == -1) {
            throw new IllegalArgumentException("imgo data source obj is NULL or not enable imgods");
        }
        if (_switchSource == -4) {
            throw new IllegalStateException("player object VideoState is NULL");
        }
    }

    public void switchVideoSource(String str, int i, int i2, int i3) throws IOException, IllegalArgumentException, IllegalStateException {
        int _switchSource = _switchSource(str, i, i2, i3);
        if (_switchSource == -1) {
            throw new IllegalArgumentException("imgo data source obj is NULL or not enable imgods");
        }
        if (_switchSource == -4) {
            throw new IllegalStateException("player object VideoState is NULL");
        }
    }
}
