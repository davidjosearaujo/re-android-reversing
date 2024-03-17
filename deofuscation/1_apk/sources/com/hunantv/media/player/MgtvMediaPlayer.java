package com.hunantv.media.player;

import a.a.a.a.d;
import a.a.a.a.n.a;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.a.a.f;
import c.a.a.a.h;
import c.a.a.a.k.c;
import c.a.a.a.p.b;
import c.a.a.a.p.d;
import c.a.a.a.p.e;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.fastjson.asm.Opcodes;
import com.alipay.sdk.app.PayTask;
import com.alipay.sdk.util.g;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.hunantv.imgo.log.MLog;
import com.hunantv.media.config.NetPlayConfig;
import com.hunantv.media.config.NetPlayConfigHelper;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.media.drm.MgtvDrmHelper;
import com.hunantv.media.drm.MgtvDrmParams;
import com.hunantv.media.global.Constants;
import com.hunantv.media.global.PlayerReferenceObserver;
import com.hunantv.media.p2p.IP2pTask;
import com.hunantv.media.p2p.P2pMgr;
import com.hunantv.media.player.IMgtvRenderView;
import com.hunantv.media.player.MgtvPlayerListener;
import com.hunantv.media.player.datasource.p2p.MGTVP2pDirectMediaDataSource;
import com.hunantv.media.player.flow.FlowReportProcessor;
import com.hunantv.media.player.flow.entity.FlowReportEntity;
import com.hunantv.media.player.helper.BuildHelper;
import com.hunantv.media.player.helper.MediaCodecHelp;
import com.hunantv.media.player.helper.MgtvPlayerSpatializer;
import com.hunantv.media.player.helper.MgtvPlayerSupporter;
import com.hunantv.media.player.libnative.FFmpegApi;
import com.hunantv.media.player.libnative.ImgoVsrApi;
import com.hunantv.media.player.libnative.ImgovsrDeviceInfo;
import com.hunantv.media.player.loader.ImgoLibLoader;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.player.pragma.PlayerConfig;
import com.hunantv.media.player.smooth.SmoothMediaSource;
import com.hunantv.media.player.statistic.FlowDataStatistic;
import com.hunantv.media.player.subtitle.SubtitleSource;
import com.hunantv.media.player.utils.CodeUtil;
import com.hunantv.media.player.utils.ExTicker;
import com.hunantv.media.player.utils.FileUtil;
import com.hunantv.media.player.utils.StringUtil;
import com.hunantv.media.player.utils.SyncStateMachine;
import com.hunantv.media.player.utils.SystemUtil;
import com.hunantv.media.player.utils.UrlUtil;
import com.hunantv.media.recoder.GifRecorder;
import com.hunantv.media.report.ReportParams;
import com.hunantv.media.utils.AudioUtil;
import com.hunantv.media.utils.KeyFrameInfoUtils;
import com.hunantv.media.utils.MgtvPlayerBroadcastObserver;
import com.hunantv.media.utils.NumericUtil;
import com.hunantv.media.widget.ISubtitle;
import com.hunantv.mpdt.data.EventClickData;
import com.mgtv.easydatasource.FlowReporter;
import com.mgtv.easydatasource.p2p.IP2pMgr;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgtvMediaPlayer implements SubtitleSource.SubtitleSourceHolder {
    public static final String BUNDLE_KEY_BOOLEAN_AUDIO_MODE = "BUNDLE_KEY_BOOLEAN_AUDIO_MODE";
    public static final String BUNDLE_KEY_BOOLEAN_ENABLE_REPORT = "BUNDLE_KEY_BOOLEAN_ENABLE_REPORT";
    public static final String BUNDLE_KEY_LOG_TAG_KEY = "BUNDLE_KEY_LOG_TAG_KEY";
    public static final int DATA_PROTOCOL_IMGOCUS = 0;
    public static final int DATA_PROTOCOL_IMGODS = 1;
    private static final String DEFAULT_CACHE_REPORT_TAG = "default";
    private static final boolean DEFAULT_HTTP_DNS_ENABLE = false;
    public static final int DNS_FAMILY_DEFAULT = 0;
    public static final int DNS_FAMILY_ONLY_IPV4 = 1;
    public static final int DNS_FAMILY_ONLY_IPV6 = 2;
    private static final String DNS_JAVA_HTTPDNS = "java_httpdns";
    private static final String DNS_JAVA_NORMAL = "java_normal";
    private static final String DNS_NATIVE = "native";
    public static final int ENABLE_PLAYER_MODE_LIVE = 1;
    public static final int ENABLE_PLAYER_MODE_LOOP = 2;
    public static final int ENABLE_PLAYER_MODE_NORMAL = 0;
    public static final int ENABLE_PLAYER_MODE_SMOOTH = 3;
    public static final String EXTRA_REPORT_PARAMS = "EXTRA_REPORT_PARAMS";
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
    public static final int ID_METHOD_GETCURRENTPOSITION = 0;
    public static final int ID_METHOD_RELEASE = 2;
    public static final int ID_METHOD_RESET = 1;
    public static final int ID_METHOD_SETPLAYSPEED = 3;
    public static final int INFO_EXTRA_BUFFER_ACCSEEK = 5;
    public static final int INFO_EXTRA_BUFFER_FIRST_LOAD = 0;
    public static final int INFO_EXTRA_BUFFER_LOOPSWITCH = 7;
    public static final int INFO_EXTRA_BUFFER_NET_BROKEN = 8;
    public static final int INFO_EXTRA_BUFFER_NORMAL = 1;
    public static final int INFO_EXTRA_BUFFER_SEEK = 2;
    public static final int INFO_EXTRA_BUFFER_SPEED = 3;
    public static final int INFO_EXTRA_BUFFER_STEP = 6;
    public static final int INFO_EXTRA_BUFFER_SWITCH = 4;
    public static final int INFO_EXTRA_BUFFER_VFIRST = 10;
    private static final int INVALID_ID = -1;
    private static final int INVALID_MS = -1;
    public static final int MEDIA_ERROR_IO = -1004;
    public static final int MEDIA_ERROR_MALFORMED = -1007;
    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    public static final int MEDIA_ERROR_TIMED_OUT = -110;
    public static final int MEDIA_ERROR_UNKNOWN = 1;
    public static final int MEDIA_ERROR_UNSUPPORTED = -1010;
    public static final int MEDIA_INFO_ACCURATE_SEEK_COMPLETE = 2804;
    public static final int MEDIA_INFO_ACODEC_RECONFIGURE = 2805;
    public static final int MEDIA_INFO_AUDIO_IS_EXIST = 10020;
    public static final int MEDIA_INFO_AUDIO_RENDERING_START = 4;
    public static final int MEDIA_INFO_AV_SYNC_ERROR = 2850;
    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_DATA_PROTOCOL = 2803;
    public static final int MEDIA_INFO_DECODER_HW_RESET_TO_SW = 503;
    public static final int MEDIA_INFO_DECODER_HW_TO_SW = 501;
    public static final int MEDIA_INFO_DECODER_HW_TO_SW_DATA = 504;
    public static final int MEDIA_INFO_DECODER_HW_TO_SW_HEVC = 506;
    public static final int MEDIA_INFO_DECODER_HW_TO_SW_INNER = 505;
    public static final int MEDIA_INFO_DECODER_SW_TO_HW = 502;
    public static final int MEDIA_INFO_DECODER_TYPE_CHANGED = 5;
    public static final int MEDIA_INFO_DL_BYTES_UPDATE = 8;
    public static final int MEDIA_INFO_DL_SPEED_UPDATE = 7;
    public static final int MEDIA_INFO_EXTERNAL_METADATA_UPDATE = 803;
    public static final int MEDIA_INFO_FILE_ENCODE_INFO = 2901;
    public static final int MEDIA_INFO_FILE_START_TIME = 2891;
    public static final int MEDIA_INFO_LOAD_DATA_STATUS = 10021;
    public static final int MEDIA_INFO_LOOPSEEK_POS_ZERO = 2892;
    public static final int MEDIA_INFO_MEDIACODEC_COLOR_FORMAT = 2900;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
    public static final int MEDIA_INFO_NETWORK_BANDWIDTH = 703;
    public static final int MEDIA_INFO_NONET_BUFFER_NOENOUGH = 2893;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_PLAYBACK_STATE_CHANGED = 2830;
    public static final int MEDIA_INFO_PREPARED_WATER_MARK_MS = 10030;
    public static final int MEDIA_INFO_PREPARE_WILL_PLAYING = 2820;
    public static final int MEDIA_INFO_RESET_RENDER_VIEW = 200001;
    public static final int MEDIA_INFO_SEI_SYS_TIMESTAMP = 2860;
    public static final int MEDIA_INFO_SPEED_RENDER_DISABLE = 10010;
    public static final int MEDIA_INFO_SPEED_RENDER_WARNING = 10011;
    public static final int MEDIA_INFO_STARTED_AS_NEXT = 2;
    public static final int MEDIA_INFO_STREAM_FORMAT_TYPE_EXTRA_FLV = 4;
    public static final int MEDIA_INFO_STREAM_FORMAT_TYPE_EXTRA_HLS = 1;
    public static final int MEDIA_INFO_STREAM_FORMAT_TYPE_EXTRA_MP4 = 3;
    public static final int MEDIA_INFO_STREAM_FORMAT_TYPE_EXTRA_OTHER = 0;
    public static final int MEDIA_INFO_STREAM_FORMAT_TYPE_EXTRA_TS = 2;
    public static final int MEDIA_INFO_STREAM_INFO_HLS_SEG_SIZE_INFO = 810;
    public static final int MEDIA_INFO_STREAM_TYPE = 2806;
    public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
    public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
    public static final int MEDIA_INFO_UNKNOWN = 1;
    public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
    public static final int MEDIA_INFO_VIDEO_DECODER_EXTRA_HW = 1;
    public static final int MEDIA_INFO_VIDEO_DECODER_EXTRA_SW = 0;
    public static final int MEDIA_INFO_VIDEO_DECODER_OPEN = 6;
    public static final int MEDIA_INFO_VIDEO_FPS = 2810;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    public static final int MEDIA_INFO_VIDEO_ROTATION_CHANGED = 10001;
    public static final int MEDIA_INFO_VIDEO_STREAM_CODEC_INFO = 2870;
    public static final int MEDIA_INFO_VIDEO_STREAM_TYPE = 2840;
    public static final int MEDIA_INFO_VIDEO_STREAM_TYPE_EXTRA_H264 = 0;
    public static final int MEDIA_INFO_VIDEO_STREAM_TYPE_EXTRA_H265 = 1;
    public static final int MEDIA_INFO_VIDEO_STREAM_TYPE_EXTRA_MPEG2 = 2;
    public static final int MEDIA_INFO_VIDEO_STREAM_TYPE_EXTRA_MPEG4 = 3;
    public static final int MEDIA_INFO_VIDEO_STREAM_TYPE_EXTRA_OTHER = 10;
    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    public static final int MEDIA_INFO_VSR_IS_OPEN = 10024;
    public static final int MEDIA_INFO_VSR_RUN_INFO = 2903;
    public static final int MEDIA_INFO_VV_BUFFER_PREPARED = 9;
    public static final int MEDIA_INFO_WANOS_AUDIO_DLOPEN = 10023;
    public static final int MEDIA_INFO_WANOS_AUDIO_EFFECT = 10022;
    public static final int MEDIA_INFO_WANOS_EFFECT_INFO = 2902;
    public static final String MEDIA_MIMETYPE_TEXT_SUBRIP = "application/x-subrip";
    public static final String MEDIA_MIMETYPE_TEXT_VTT = "text/vtt";
    public static final int MGTVMEDIA_ERROR_100001 = 100001;
    public static final int MGTVMEDIA_ERROR_100002 = 100002;
    public static final int MGTVMEDIA_ERROR_100003 = 100003;
    public static final int MGTVMEDIA_ERROR_100004 = 100004;
    public static final int MGTVMEDIA_ERROR_200001 = 200001;
    public static final int MGTVMEDIA_ERROR_200002 = 200002;
    public static final int MGTVMEDIA_ERROR_200003 = 200003;
    public static final int MGTVMEDIA_ERROR_300001 = 300001;
    public static final int MGTVMEDIA_ERROR_300002 = 300002;
    public static final int MGTVMEDIA_ERROR_300003 = 300003;
    public static final int MGTVMEDIA_ERROR_300004 = 300004;
    public static final int MGTVMEDIA_ERROR_400400 = 400400;
    public static final int MGTVMEDIA_ERROR_400401 = 400401;
    public static final int MGTVMEDIA_ERROR_400402 = 400402;
    public static final int MGTVMEDIA_ERROR_400403 = 400403;
    public static final int MGTVMEDIA_ERROR_400404 = 400404;
    public static final int MGTVMEDIA_ERROR_400407 = 400407;
    public static final int MGTVMEDIA_ERROR_400408 = 400408;
    public static final int MGTVMEDIA_ERROR_400410 = 400410;
    public static final int MGTVMEDIA_ERROR_400416 = 400416;
    public static final int MGTVMEDIA_ERROR_4004XX = 400499;
    public static final int MGTVMEDIA_ERROR_400500 = 400500;
    public static final int MGTVMEDIA_ERROR_400501 = 400501;
    public static final int MGTVMEDIA_ERROR_400502 = 400502;
    public static final int MGTVMEDIA_ERROR_400503 = 400503;
    public static final int MGTVMEDIA_ERROR_400504 = 400504;
    public static final int MGTVMEDIA_ERROR_4005XX = 400599;
    public static final int MGTVMEDIA_ERROR_400600 = 400600;
    public static final int MGTVMEDIA_ERROR_400601 = 400601;
    public static final int MGTVMEDIA_ERROR_400602 = 400602;
    public static final int MGTVMEDIA_ERROR_400802 = 400802;
    public static final int MGTVMEDIA_ERROR_400803 = 400803;
    public static final int MGTVMEDIA_ERROR_400804 = 400804;
    public static final int MGTVMEDIA_ERROR_500001 = 500001;
    public static final int MGTVMEDIA_ERROR_500002 = 500002;
    public static final int MGTVMEDIA_ERROR_500003 = 500003;
    public static final int MGTVMEDIA_ERROR_500004 = 500004;
    public static final int MGTVMEDIA_ERROR_500999 = 500999;
    public static final int MGTVMEDIA_ERROR_EXTRA_100701 = 100701;
    public static final int MGTVMEDIA_ERROR_EXTRA_100900 = 100900;
    public static final int MGTVMEDIA_ERROR_EXTRA_100903 = 100903;
    public static final int MGTVMEDIA_ERROR_EXTRA_100906 = 100906;
    public static final int MGTVMEDIA_ERROR_EXTRA_100907 = 100907;
    public static final int MGTVMEDIA_ERROR_EXTRA_400100 = 400100;
    public static final int MGTVMEDIA_ERROR_EXTRA_400198 = 400198;
    public static final int MGTVMEDIA_ERROR_EXTRA_400199 = 400199;
    public static final int MGTVMEDIA_ERROR_EXTRA_DRM_BASE = 400270;
    public static final int MGTVMEDIA_ERROR_EXTRA_DRM_INFO_LIST_INVALID = 400276;
    public static final int MGTVMEDIA_ERROR_EXTRA_DRM_INIT_ERROR = 400275;
    public static final int MGTVMEDIA_ERROR_EXTRA_DRM_INIT_INVALID = 400273;
    public static final int MGTVMEDIA_ERROR_EXTRA_DRM_INVALID_PARAMS = 400278;
    public static final int MGTVMEDIA_ERROR_EXTRA_DRM_INVALID_SESSION = 400272;
    public static final int MGTVMEDIA_ERROR_EXTRA_DRM_KEYID_INVALID = 400271;
    public static final int MGTVMEDIA_ERROR_EXTRA_DRM_LIB_LOAD_FAILED = 400299;
    public static final int MGTVMEDIA_ERROR_EXTRA_DRM_LICENSE_BASE = 402000;
    public static final int MGTVMEDIA_ERROR_EXTRA_DRM_LICENSE_URL_INVALID = 400277;
    public static final int MGTVMEDIA_ERROR_EXTRA_DRM_PROVISION_BASE = 401000;
    public static final int MGTVMEDIA_ERROR_VIDEO_DATA_AMCDECODER_FAILED = 100606;
    public static final int MGTVMEDIA_ERROR_VIDEO_DATA_FFDECODER_FAILED = 100607;
    public static final int MGTVMEDIA_ERROR_WHAT_200100 = 200100;
    public static final int MGTVMEDIA_EXTRA_ERROR_300400 = 300400;
    public static final int MGTVMEDIA_EXTRA_ERROR_3004XX = 300499;
    public static final int MGTVMEDIA_EXTRA_ERROR_300500 = 300500;
    public static final int MGTVMEDIA_EXTRA_ERROR_3005XX = 300599;
    public static final int MGTVMEDIA_EXTRA_ERROR_301400 = 301400;
    public static final int MGTVMEDIA_EXTRA_ERROR_3014XX = 301499;
    public static final int MGTVMEDIA_EXTRA_ERROR_301500 = 301500;
    public static final int MGTVMEDIA_EXTRA_ERROR_3015XX = 301599;
    public static final int MGTVMEDIA_WARNING_403_PRE_PLAY = 800403;
    public static final int MGTVMEDIA_WARNING_410_PRE_PLAY = 800410;
    public static final int MGTVMEDIA_WARNING_AV_SYNC_ERR = 800500;
    public static final int MGTVMEDIA_WARNING_AV_SYNC_SUM_ERR = 800501;
    public static final int MGTVMEDIA_WARNING_BACKUP_LOAD_SUCCESS = 800006;
    public static final int MGTVMEDIA_WARNING_BASE = 800000;
    public static final int MGTVMEDIA_WARNING_DNS_ABORT = 800102;
    public static final int MGTVMEDIA_WARNING_DNS_SYNC_IN_ASYNC = 800105;
    public static final int MGTVMEDIA_WARNING_DS_LOAD_ERROR = 800003;
    public static final int MGTVMEDIA_WARNING_ERROR_COMPLETION = 800009;
    public static final int MGTVMEDIA_WARNING_EXTRA_300301 = 800301;
    public static final int MGTVMEDIA_WARNING_HTTPDNS_REPORT_ERR = 800202;
    public static final int MGTVMEDIA_WARNING_HTTPDNS_REPORT_PV = 800200;
    public static final int MGTVMEDIA_WARNING_HTTPDNS_REPORT_SUC = 800201;
    public static final int MGTVMEDIA_WARNING_HTTP_ERROR_ERR = 800902;
    public static final int MGTVMEDIA_WARNING_HTTP_ERROR_PV = 800901;
    public static final int MGTVMEDIA_WARNING_INNER_RETRY_RENDER_START = 801012;
    public static final int MGTVMEDIA_WARNING_INVALID_THREAD = 800005;
    public static final int MGTVMEDIA_WARNING_IP_IS_LAN = 800101;
    public static final int MGTVMEDIA_WARNING_JAVA_OPENGL = 801001;
    public static final int MGTVMEDIA_WARNING_LEAVE_TIME_INVALID = 800010;
    public static final int MGTVMEDIA_WARNING_LIVE_IN_VOD = 800020;
    public static final int MGTVMEDIA_WARNING_LIVE_IN_VOD_COMPLETE = 800021;
    public static final int MGTVMEDIA_WARNING_LOCAL_100201 = 801201;
    public static final int MGTVMEDIA_WARNING_LOW_MEMORY = 800600;
    public static final int MGTVMEDIA_WARNING_P2P_TS_SKIP = 801011;
    public static final int MGTVMEDIA_WARNING_RENDER_DISABLE = 800008;
    public static final int MGTVMEDIA_WARNING_TARGET_ERROR = 801010;
    public static final int MGTVMEDIA_WARNING_TS_CACHE_SKIP = 800007;
    public static final int MGTVMEDIA_WARNING_TS_ERROR = 800905;
    public static final String MGTVPLAYER_VERSION = "MGTV_1.25.5";
    public static final int MGTV_LOG_DEBUG_BRIEF = 1;
    public static final int MGTV_LOG_DEBUG_DETAIL = 2;
    public static final int MGTV_LOG_DEBUG_NONE = 0;
    public static final int MGTV_LOG_LEVEL_DEBUG = 3;
    public static final int MGTV_LOG_LEVEL_DEFAULT = 1;
    public static final int MGTV_LOG_LEVEL_ERROR = 6;
    public static final int MGTV_LOG_LEVEL_FATAL = 7;
    public static final int MGTV_LOG_LEVEL_INFO = 4;
    public static final int MGTV_LOG_LEVEL_SILENT = 8;
    public static final int MGTV_LOG_LEVEL_UNKNOWN = 0;
    public static final int MGTV_LOG_LEVEL_VERBOSE = 2;
    public static final int MGTV_LOG_LEVEL_WARN = 5;
    public static final int MGTV_PROP_INT64_DECODER_PLAY_NOTIFY = 90003;
    private static final int NETWORK_RECONNECT_COUNT = 2;
    private static final int NETWORK_RECONNECT_COUNT_MAX_LIMIT = 6;
    private static final int OFFSET_MS = 5000;
    public static final int OPPO_FUNC_OSIE = 2;
    public static final int OPPO_FUNC_SR = 1;
    public static final int PLAYER_TYPE_CODECPLAYER = 2;
    public static final int PLAYER_TYPE_FFPLAYER = 1;
    public static final int PLAYER_TYPE_SYSTEM = 0;
    public static final int PREPARE_WILL_PLAYING_AUDIO_DECODED_START = 82005;
    public static final int PREPARE_WILL_PLAYING_COMPONENT_OPEN = 82003;
    public static final int PREPARE_WILL_PLAYING_FIND_STREAM_INFO = 82002;
    public static final int PREPARE_WILL_PLAYING_OPEN_INPUT = 82001;
    public static final int PREPARE_WILL_PLAYING_VIDEO_DECODED_START = 82004;
    private static final int PRE_BUFFER_DEFAULT = 1;
    private static final int PRE_BUFFER_LIMIT = 2;
    private static final int PRE_BUFFER_MAX_S = 5;
    private static final int PRE_BUFFER_UNLIMIT = 3;
    public static final int READ_DATASOURCE_TYPE_DATA_SOURCE = 3;
    public static final int READ_DATASOURCE_TYPE_NORMAL = 0;
    public static final int READ_DATASOURCE_TYPE_P2P_DIRECT = 2;
    public static final int READ_DATASOURCE_TYPE_PROXY = 1;
    public static final String REPORT_BROADCAST_ACTION = "mgtv.player.action.PLAYER_REPORT_EVENT";
    private static final int START_RECORD = 0;
    private static final int STOP_RECORD = 1;
    private static final String TAG = "MgtvMediaPlayer";
    public static final int TYPE_NORMAL_MEMORY_PLAY = 1;
    public static final int TYPE_NO_MEMORY_PLAY = 0;
    public static final int TYPE_QUICK_MEMORY_PLAY = 2;
    private static final String USER_MSG_FLAG_DEFAULT = "init";
    private static final String USER_MSG_FLAG_USE_CACHE = "usecache";
    private static final int WHAT_SMOOTHSOURCE_EX_ERROR = 400711;
    private static final int WHAT_SMOOTHSOURCE_FAIL = 400710;
    private int avdiffS;
    private int dfps;
    private String fstime;
    public String hdrInfo;
    private int imp4dh;
    public boolean isBackground;
    private boolean isExAudioEnable;
    private boolean isFlowReportEnable;
    private boolean isSpaceAudioSwitchOn;
    private boolean isUserAudioEnable;
    private boolean mAVSyncErrReported;
    private int mAVSyncErrSum;
    private boolean mAVSyncErrSumReported;
    private long mAVSyncStartTimestamp;
    private int mAccSeekKeyFrameInterval;
    private boolean mAccurateSeekEnable;
    private int mAddrinfoTimeoutMs;
    private AddrinfoType mAddrinfoType;
    private boolean mBackJavaDns;
    private ExTicker mBufferTick;
    private int mBufferTimeoutMs;
    @Nullable
    private Bundle mBundle;
    private boolean mCacheEable;
    private String mCacheM3u8Path;
    private Map<String, String> mCacheReplaceMap;
    private int mCacheReportLerr;
    private String mCacheReportTag;
    private volatile String[] mCacheTsPaths;
    private String mCodecName;
    private int mConnectTimeOutMs;
    private Context mContext;
    private String mCurrentDnsDsc;
    private DataSourceInfo mDataSourceInfo;
    private DataSourceType mDataSourceType;
    private boolean mDebug;
    public long mDlt;
    private Object mDnsLock;
    private int mDnsNoNetMaxRetry;
    private Object mDnsNoNetWaiter;
    private c mDnsThreadManager;
    private boolean mEnableDnsNoNetStrategy;
    private boolean mEnableImgoVsr;
    private boolean mEnableJAVAIPCacheMap;
    private boolean mEnableP2PHttpDns;
    private boolean mEnableReport;
    private int mErrorExtraCodeStore;
    private MgtvPlayerListener.OnErrorListener mErrorListener;
    private String mErrorUrl;
    private FlowDataStatistic mFlowDataStatistic;
    private boolean mForceHttpDns;
    private boolean mForceP2pHttpDns;
    private MgtvPlayerListener.OnFrameListener mFrameListener;
    private GifRecorder mGifRecorder;
    private volatile String mHDJSwitchUrl;
    private boolean mHttpDnsEnable;
    private boolean mHttpDnsNeedRetry;
    private Hw2SwType mHw2SwType;
    private Map<String, IPList> mIPCacheMap;
    private boolean mImgoMediaPlayerAudioMode;
    private boolean mInnerAutoRotateEnable;
    private FlowDataStatistic mInnerFlowDataStatistic;
    private int mIsAudioExist;
    private boolean mIsBuffering;
    private boolean mIsGetPositionCallback;
    private boolean mIsInitMp4Error;
    private boolean mIsInnerRetrying;
    private boolean mIsLive;
    private int mIsNativePausedLoadData;
    private boolean mIsP2pTSSkipReport;
    private boolean mIsVideoRendered;
    private int mIsVsrOpen;
    private boolean mIsWanosAudioEffectValid;
    private boolean mJavaDnsEnable;
    private a.d mJavaDnsType;
    private boolean mKeyframeSeekEnable;
    private int mLastDlSize;
    private int mLastDnsType;
    private String mLastErrorTypeCode;
    private String mLastHostErr;
    private String mLastHostIP;
    private String mLastIP;
    private int mLastIpCount;
    private int mLastIpIndex;
    private String[] mLastIps;
    private boolean mLastIsNetworkAvailableNNS;
    private String mLastP2pCdnIP;
    private int mLastPosition;
    private String mLastRequestUrl;
    private String mLastTcpErr;
    private String mLastTcpIP;
    public int mLastTsSkipErrExtra;
    public String mLastTsSkipErrFileName;
    private String mLastUri;
    private int mLastVideoHeight;
    private int mLastVideoWidth;
    private volatile boolean mLiveReopen;
    private int mLoadMaxRetryTime;
    @Nullable
    private String mLogTagKey;
    private boolean mLoopPlayerReset;
    private volatile String mLoopPlayerSwitchUrl;
    private AtomicInteger mLoopSourceKey;
    private FlowReportProcessor mMainFlowReportProcessor;
    private long mMainThreadID;
    private f mMediaPlayer;
    public NetPlayConfig mNetPlayConfig;
    private long mNetdSVCTimeMs;
    private boolean mNetworkChangeWhilePlaying;
    private MainNotifyHandler mNotifyHandler;
    private MgtvPlayerBroadcastObserver mObserver;
    private MgtvPlayerListener.OnAVPlayListener mOnAVPlayListener;
    private MgtvPlayerListener.OnBufferingTimeoutListener mOnBufferingTimeoutListener;
    private MgtvPlayerListener.OnCompletionListener mOnCompletionListener;
    private MgtvPlayerListener.OnErrorListener mOnErrorListener;
    private MgtvPlayerListener.OnFrameListener mOnFrameListener;
    private MgtvPlayerListener.OnGetFrameImageListener mOnGetFrameImageListener;
    private MgtvPlayerListener.OnInfoListener mOnInfoListener;
    private MgtvPlayerListener.OnInfoStringListener mOnInfoStringListener;
    private MgtvPlayerListener.OnLoadDataListener mOnLoadDataListener;
    private MgtvPlayerListener.OnPauseListener mOnPauseListener;
    private MgtvPlayerListener.OnPlayerEventListener mOnPlayerEventListener;
    private MgtvPlayerListener.OnPreparedListener mOnPreparedListener;
    private MgtvPlayerListener.OnRecordVideoListener mOnRecordVideoListener;
    private MgtvPlayerListener.OnSeekCompleteListener mOnSeekCompleteListener;
    private MgtvPlayerListener.OnSourceNetHandledListener mOnSourceNetHandledListener;
    private MgtvPlayerListener.OnStartListener mOnStartListener;
    private MgtvPlayerListener.OnSwitchSmoothSourceListener mOnSwitchSmoothSourceListener;
    private MgtvPlayerListener.OnSwitchSourceListener mOnSwitchSourceListener;
    private MgtvPlayerListener.OnWarningListener mOnWarningListener;
    private IP2pMgr.OnNotifyMsgListener mP2pNotify;
    private PlayStatus mPlayStatus;
    private ExTicker mPlayTicker;
    private float mPlaybackSpeed;
    private int mPlayerMode;
    private boolean mPlayerReset;
    private int mPlayerType;
    private boolean mPositionLoged;
    private int mPreBufferMaxS;
    private SyncStateMachine mPreBufferState;
    private int mPreBufferTimeoutMs;
    private long mPrepareAsyncTimeStampMs;
    private boolean mPrepared;
    private Prepared4StartMode mPrepared4StartMode;
    private int mRealEncodeType;
    private int mReceiveDataTimeOutMs;
    private float mRecordMaxPlaySpeed;
    private float mRecordVfps;
    private boolean mRenderDisableWarnSended;
    private RenderType mRenderType;
    private IMgtvRenderView mRenderView;
    private ReportParams mReportParams;
    private boolean mReportedTSLAN;
    private a.a.a.b.a mReporter;
    private a.a.a.b.a mReporterSL;
    private int mRetryLastErrorCode;
    private long mSeekStartMs;
    private SkipLoopFilterType mSkipLoopFilterType;
    public Map<String, byte[]> mSmoothKeyFrameMap;
    private d.n mSmoothSourceListener;
    private Map<Integer, SmoothMediaSource> mSmoothSourcesRecord;
    private boolean mSmoothUseP2pFailed;
    public long mSmt;
    private MgtvPlayerListener.OnSourceNetHandledListener mSourceNetListner;
    private int mSourceRetryCode;
    private int mSourceRetryCount;
    private boolean mSourceSwitching;
    private boolean mSourceSwitchingComplete;
    private int mStreamFormatType;
    private ISubtitle.SubtitleCallback mSubtitleCallback;
    private b mSubtitleController;
    private List<SubtitleSource> mSubtitleSources;
    private Object mSwitchSmoothSourceLocker;
    private volatile SmoothMediaSource mSwitchedSmoothSource;
    private boolean mSwitchingPrepared;
    private volatile SmoothMediaSource mSwitchingSmoothSource;
    private e mTimeProvider;
    private int mTsCacheSkipNum;
    private boolean mTsNotSkip;
    private int mVVbuft;
    private volatile int mVideoFrameClockNotifyMs;
    private volatile long mVideoFrameClockNotifyTimeEnd;
    private volatile long mVideoFrameClockNotifyTimeStart;
    private volatile int mVideoFrameClockNotifyType;
    private int mWeakBufferSpeedKB;
    private int mWeakBufferTimeoutMs;
    private int mWeakTimer;
    private String mWillOpenUrl;
    private String mcColorFormat;
    private MgtvPlayerSpatializer mgtvPlayerSpatializer;
    private int mpx;
    private MgtvPlayerListener.OnSpatializerInfoListener onSpatializerInfoListener;
    private Object p2pLocker;
    public HandlerThread ptsHandlerThread;
    public Set<MgtvPlayerListener.OnVideoPTSListener> ptsListeners;
    public Object ptsLocker;
    public WeakHandler ptsWeakHandler;
    private int rfps;
    private int rfpsLowCounter;
    private boolean rfpsLowFilterChanged;
    private int sfps;
    private AudioAttributes spaceAudioAttr;
    private int vfps;
    public String vsri;
    public String vsrnpuver;
    public String vsrver;
    public String vsrvkver;
    public int wadls;
    public String waev;

    /* renamed from: com.hunantv.media.player.MgtvMediaPlayer$28  reason: invalid class name */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static /* synthetic */ class AnonymousClass28 {
        public static final /* synthetic */ int[] $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$DataSourceType;
        public static final /* synthetic */ int[] $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$NativeSoType;
        public static final /* synthetic */ int[] $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$Prepared4StartMode;
        public static final /* synthetic */ int[] $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$RenderType;
        public static final /* synthetic */ int[] $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$SkipLoopFilterType;
        public static final /* synthetic */ int[] $SwitchMap$com$hunantv$media$player$dns$AsyncDns$DnsType;

        static {
            int[] iArr = new int[Prepared4StartMode.values().length];
            $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$Prepared4StartMode = iArr;
            try {
                iArr[Prepared4StartMode.MODE_PREPARED4START_DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$Prepared4StartMode[Prepared4StartMode.MODE_PREPARED4START_AUTOPLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$Prepared4StartMode[Prepared4StartMode.MODE_PREPARED4START_LOADDATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$Prepared4StartMode[Prepared4StartMode.MODE_PREPARED4START_LOADDATA_DISAV.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[NativeSoType.values().length];
            $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$NativeSoType = iArr2;
            try {
                iArr2[NativeSoType.TYPE_NATIVESO_IMGOFFMPEG.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$NativeSoType[NativeSoType.TYPE_NATIVESO_IMGOHELP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$NativeSoType[NativeSoType.TYPE_NATIVESO_IMGOMEDIAPLAYER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$NativeSoType[NativeSoType.TYPE_NATIVESO_IMGODS.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[RenderType.values().length];
            $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$RenderType = iArr3;
            try {
                iArr3[RenderType.OPENGL_ES.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$RenderType[RenderType.NATIVE_WINDOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr4 = new int[SkipLoopFilterType.values().length];
            $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$SkipLoopFilterType = iArr4;
            try {
                iArr4[SkipLoopFilterType.TYPE_SKIPLOOPFILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$SkipLoopFilterType[SkipLoopFilterType.TYPE_SKIPLOOPFILTER_NONREF.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$SkipLoopFilterType[SkipLoopFilterType.TYPE_SKIPLOOPFILTER_BIDIR.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$SkipLoopFilterType[SkipLoopFilterType.TYPE_SKIPLOOPFILTER_NONKEY.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$SkipLoopFilterType[SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr5 = new int[DataSourceType.values().length];
            $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$DataSourceType = iArr5;
            try {
                iArr5[DataSourceType.TYPE_DATASOUCE_IMGO.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$DataSourceType[DataSourceType.TYPE_DATASOUCE_DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            int[] iArr6 = new int[a.d.values().length];
            $SwitchMap$com$hunantv$media$player$dns$AsyncDns$DnsType = iArr6;
            try {
                iArr6[a.d.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$hunantv$media$player$dns$AsyncDns$DnsType[a.d.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum AddrinfoType {
        TYPE_ADDRINFO_DEFAULT,
        TYPE_ADDRINFO_THREAD,
        TYPE_ADDRINFO_ONE_BY_ONE,
        TYPE_DNS_CACHE
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class DataSourceInfo {
        public static final String FILE_FORMAT_FMP4 = "fmp4";
        public static final String H264 = "h264";
        public static final String H265 = "h265";
        public static final String INIT_VALUE = "init";
        public static final String MPEG2 = "mpeg2";
        public static final String MPEG4 = "mpeg4";
        public static final String OTHER = "other";
        private int audioChannel;
        private AudioChildInfo audioChildInfo;
        private String audioFormat;
        private String bitRate;
        private String fileFormat;
        private String videoFormat;
        private int videoHeight;
        private int videoWidth;

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class AudioChildInfo {
            private int bitdepth;
            private String bitrateMode;
            private String channels;
            private String codecname;
            private int drmFlag;
            private String fileEx;
            private String fileSize;
            private String licenseUrl = "";
            private int samplingrate;

            public int getBitdepth() {
                return this.bitdepth;
            }

            public String getBitrateMode() {
                return this.bitrateMode;
            }

            public String getChannels() {
                return this.channels;
            }

            public String getCodecname() {
                return this.codecname;
            }

            public int getDrmFlag() {
                return this.drmFlag;
            }

            public String getFileEx() {
                return this.fileEx;
            }

            public String getFileSize() {
                return this.fileSize;
            }

            public String getLicenseUrl() {
                return this.licenseUrl;
            }

            public int getSamplingrate() {
                return this.samplingrate;
            }

            public AudioChildInfo setBitdepth(int i) {
                this.bitdepth = i;
                return this;
            }

            public AudioChildInfo setBitrateMode(String str) {
                this.bitrateMode = str;
                return this;
            }

            public AudioChildInfo setChannels(String str) {
                this.channels = str;
                return this;
            }

            public AudioChildInfo setCodecname(String str) {
                this.codecname = str;
                return this;
            }

            public AudioChildInfo setDrmFlag(int i) {
                this.drmFlag = i;
                return this;
            }

            public AudioChildInfo setFileEx(String str) {
                this.fileEx = str;
                return this;
            }

            public AudioChildInfo setFileSize(String str) {
                this.fileSize = str;
                return this;
            }

            public AudioChildInfo setLicenseUrl(String str) {
                this.licenseUrl = str;
                return this;
            }

            public AudioChildInfo setSamplingrate(int i) {
                this.samplingrate = i;
                return this;
            }
        }

        public int getAudioChannel() {
            return this.audioChannel;
        }

        public AudioChildInfo getAudioChildInfo() {
            return this.audioChildInfo;
        }

        public String getAudioFormat() {
            return this.audioFormat;
        }

        public String getBitRate() {
            return this.bitRate;
        }

        public String getFileFormat() {
            return this.fileFormat;
        }

        public String getVideoFormat() {
            return this.videoFormat;
        }

        public int getVideoHeight() {
            return this.videoHeight;
        }

        public int getVideoWidth() {
            return this.videoWidth;
        }

        public DataSourceInfo setAudioChannel(int i) {
            this.audioChannel = i;
            return this;
        }

        public DataSourceInfo setAudioChildInfo(AudioChildInfo audioChildInfo) {
            this.audioChildInfo = audioChildInfo;
            return this;
        }

        public DataSourceInfo setAudioFormat(String str) {
            this.audioFormat = str;
            return this;
        }

        public DataSourceInfo setBitRate(String str) {
            this.bitRate = str;
            return this;
        }

        public DataSourceInfo setFileFormat(String str) {
            this.fileFormat = str;
            return this;
        }

        public DataSourceInfo setVideoFormat(String str) {
            if (str != null) {
                String lowerCase = str.toLowerCase();
                lowerCase.hashCode();
                lowerCase.hashCode();
                char c = 65535;
                switch (lowerCase.hashCode()) {
                    case 96974:
                        if (lowerCase.equals("avc")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3148040:
                        if (lowerCase.equals(H264)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 3148041:
                        if (lowerCase.equals(H265)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 3199082:
                        if (lowerCase.equals("hevc")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                    case 1:
                        str = H264;
                        break;
                    case 2:
                    case 3:
                        str = H265;
                        break;
                }
            }
            this.videoFormat = str;
            return this;
        }

        public DataSourceInfo setVideoHeight(int i) {
            this.videoHeight = i;
            return this;
        }

        public DataSourceInfo setVideoWidth(int i) {
            this.videoWidth = i;
            return this;
        }

        public String toString() {
            return "DataSourceInfo{videoFormat='" + this.videoFormat + "', bitRate='" + this.bitRate + "', fileFormat='" + this.fileFormat + "', videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", audioFormat='" + this.audioFormat + "'}";
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum DataSourceType {
        TYPE_DATASOUCE_DEFAULT,
        TYPE_DATASOUCE_IMGO
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum EncodeType {
        H264,
        H265,
        MPEG2,
        MPEG4,
        OTHER
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum Hw2SwType {
        NONE,
        HW_2_SW_RESET,
        HW_2_SW_DEFAULT,
        HW_2_SW_OTHER
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class IPList {
        public String hostName;
        public long startTimeMs;
        public int ttlMs;
        public List<String> srcList = new ArrayList();
        public List<String> nUseList = new ArrayList();
        public List<String> errList = new ArrayList();
        private boolean isIPValid = true;

        public IPList(String str, String[] strArr) {
            this.hostName = str;
            if (strArr != null && strArr.length > 0) {
                for (String str2 : strArr) {
                    if (c.a.a.a.k.d.b(str2)) {
                        this.srcList.add(str2);
                        this.nUseList.add(str2);
                    }
                }
            }
            this.startTimeMs = System.currentTimeMillis();
            this.ttlMs = 45000;
        }

        public static String formatIPList(List<String> list) {
            Iterator<String> it;
            String str = "";
            if (list != null && list.size() > 0) {
                while (list.iterator().hasNext()) {
                    str = str + it.next() + g.b;
                }
            }
            return str;
        }

        public static String formatIPList(String[] strArr) {
            String str = "";
            if (strArr != null && strArr.length > 0) {
                for (String str2 : strArr) {
                    str = str + str2 + g.b;
                }
            }
            return str;
        }

        public boolean checkTTL() {
            if (this.isIPValid) {
                long currentTimeMillis = System.currentTimeMillis() - this.startTimeMs;
                this.isIPValid = currentTimeMillis > 0 && currentTimeMillis < ((long) this.ttlMs);
            }
            return this.isIPValid;
        }

        public String toString() {
            return "nUseList:" + formatIPList(this.nUseList);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class ImgoAIQE {
        public int ImgoAIQE_def;
        public int ImgoAIQE_h;
        public int ImgoAIQE_w;

        public int getImgoAIQEDef() {
            return this.ImgoAIQE_def;
        }

        public int getImgoAIQEH() {
            return this.ImgoAIQE_h;
        }

        public int getImgoAIQEW() {
            return this.ImgoAIQE_w;
        }

        public ImgoAIQE setImgoAIQEDef(int i) {
            this.ImgoAIQE_def = i;
            return this;
        }

        public ImgoAIQE setImgoAIQEH(int i) {
            this.ImgoAIQE_h = i;
            return this;
        }

        public ImgoAIQE setImgoAIQEW(int i) {
            this.ImgoAIQE_w = i;
            return this;
        }

        public String toString() {
            return "ImgoAIQE{ImgoAIQE_w=" + this.ImgoAIQE_w + ", ImgoAIQE_h=" + this.ImgoAIQE_h + ", ImgoAIQE_def=" + this.ImgoAIQE_def + '}';
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class MainNotifyHandler extends Handler {
        public static final String BUNDLE_STR_INFO1 = "bundle_str_info1";
        public static final String BUNDLE_STR_INFO2 = "bundle_str_info2";
        public static final int MSG_HTTPDNS_REPORT_ERR = 2002;
        public static final int MSG_HTTPDNS_REPORT_PV = 2000;
        public static final int MSG_HTTPDNS_REPORT_SUC = 2001;
        public static final int MSG_IP_IS_LAN = 1002;
        private WeakReference<MgtvMediaPlayer> mWeakObj;

        public MainNotifyHandler(MgtvMediaPlayer mgtvMediaPlayer) {
            super(Looper.getMainLooper());
            this.mWeakObj = new WeakReference<>(mgtvMediaPlayer);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MgtvPlayerListener.OnWarningListener onWarningListener;
            String str;
            String valueOf;
            int i;
            MgtvMediaPlayer mgtvMediaPlayer = this.mWeakObj.get();
            if (mgtvMediaPlayer == null) {
                return;
            }
            Bundle data = message.getData();
            int i2 = message.what;
            if (i2 == 1002) {
                if (data == null || mgtvMediaPlayer.mOnWarningListener == null) {
                    return;
                }
                mgtvMediaPlayer.mOnWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_IP_IS_LAN, data.getString(BUNDLE_STR_INFO1), data.getString(BUNDLE_STR_INFO2), null);
                return;
            }
            switch (i2) {
                case MSG_HTTPDNS_REPORT_PV /* 2000 */:
                    if (mgtvMediaPlayer.mOnWarningListener != null) {
                        onWarningListener = mgtvMediaPlayer.mOnWarningListener;
                        str = message.arg1 + "";
                        valueOf = String.valueOf(message.obj);
                        i = MgtvMediaPlayer.MGTVMEDIA_WARNING_HTTPDNS_REPORT_PV;
                        break;
                    } else {
                        return;
                    }
                case 2001:
                    if (mgtvMediaPlayer.mOnWarningListener != null) {
                        onWarningListener = mgtvMediaPlayer.mOnWarningListener;
                        str = message.arg1 + "";
                        valueOf = String.valueOf(message.obj);
                        i = MgtvMediaPlayer.MGTVMEDIA_WARNING_HTTPDNS_REPORT_SUC;
                        break;
                    } else {
                        return;
                    }
                case 2002:
                    if (mgtvMediaPlayer.mOnWarningListener != null) {
                        onWarningListener = mgtvMediaPlayer.mOnWarningListener;
                        str = message.arg1 + "";
                        valueOf = String.valueOf(message.obj);
                        i = MgtvMediaPlayer.MGTVMEDIA_WARNING_HTTPDNS_REPORT_ERR;
                        break;
                    } else {
                        return;
                    }
                default:
                    return;
            }
            onWarningListener.onWarning(i, str, valueOf, null);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum NativeSoType {
        TYPE_NATIVESO_IMGOFFMPEG,
        TYPE_NATIVESO_IMGOHELP,
        TYPE_NATIVESO_IMGOMEDIAPLAYER,
        TYPE_NATIVESO_IMGODS
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum PlayStatus {
        ERROR,
        IDLE,
        PREPARING,
        PREPARED,
        PLAYING,
        PAUSED,
        COMPLETED
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class PlayerExtraInfo {
        public long bufsizeByte;
        public long buftimeMs;
        public long dlt;
        public String lastIP;
        public String playSessionID;
        public long smt;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum PlayerModeType {
        TYPE_PLAYER_MODE_NORMAL,
        TYPE_PLAYER_MODE_LIVE,
        TYPE_PLAYER_MODE_LOOP,
        TYPE_PLAYER_MODE_SMOOTH
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum Prepared4StartMode {
        MODE_PREPARED4START_DEFAULT,
        MODE_PREPARED4START_AUTOPLAY,
        MODE_PREPARED4START_LOADDATA,
        MODE_PREPARED4START_LOADDATA_DISAV
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum RenderType {
        NATIVE_WINDOW,
        OPENGL_ES
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum SkipLoopFilterType {
        TYPE_SKIPLOOPFILTER_NONE,
        TYPE_SKIPLOOPFILTER_NONREF,
        TYPE_SKIPLOOPFILTER_BIDIR,
        TYPE_SKIPLOOPFILTER_NONKEY,
        TYPE_SKIPLOOPFILTER_ALL
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class WeakHandler extends Handler {
        public static final int MSG_PTS = 256;
        private WeakReference<MgtvMediaPlayer> mWeakPlayer;

        public WeakHandler(Looper looper, MgtvMediaPlayer mgtvMediaPlayer) {
            super(looper);
            this.mWeakPlayer = new WeakReference<>(mgtvMediaPlayer);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MgtvMediaPlayer mgtvMediaPlayer = this.mWeakPlayer.get();
            if (mgtvMediaPlayer != null && message.what == 256) {
                MgtvPlayerListener.FrameClock frameClock = (MgtvPlayerListener.FrameClock) message.obj;
                synchronized (mgtvMediaPlayer.ptsLocker) {
                    for (MgtvPlayerListener.OnVideoPTSListener onVideoPTSListener : mgtvMediaPlayer.ptsListeners) {
                        onVideoPTSListener.onVideoPTS(frameClock);
                    }
                }
            }
        }
    }

    static {
        Thread thread = new Thread(new Runnable() { // from class: com.hunantv.media.player.MgtvMediaPlayer.1
            @Override // java.lang.Runnable
            public void run() {
                String str = MgtvMediaPlayer.TAG;
                DebugLog.i(str, "DeviceInfo======\nCputy:" + NetPlayConfigHelper.getCputy() + "\nOmxcn:" + NetPlayConfigHelper.getOmxcn() + "\nMod:" + NetPlayConfigHelper.getMod() + "\n======DeviceInfo");
                DebugLog.d(MgtvMediaPlayer.TAG, "async getH265Decoder & getH264Decoder in");
                MediaCodecHelp.getH265Decoder(true);
                MediaCodecHelp.getH264Decoder(true);
                MediaCodecHelp.getALLAV1Decoder(true);
                DebugLog.d(MgtvMediaPlayer.TAG, "async getH265Decoder & getH264Decoder out");
                MgtvDrmHelper.updateWidevineSupportMsg();
                String str2 = MgtvMediaPlayer.TAG;
                DebugLog.i(str2, "async updateWidevineSupportMsg " + MgtvDrmHelper.getWidevineSupportMsg());
            }
        });
        thread.setName("mgtvmp_jPreInfo");
        thread.start();
    }

    public MgtvMediaPlayer(int i, Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, OutOfMemoryError {
        this.mDebug = false;
        this.mPreBufferTimeoutMs = 1800000;
        this.mBufferTimeoutMs = 180000;
        this.mImgoMediaPlayerAudioMode = false;
        this.mAccurateSeekEnable = true;
        this.mAccSeekKeyFrameInterval = 1000;
        this.mKeyframeSeekEnable = false;
        this.mInnerAutoRotateEnable = false;
        this.mWeakBufferSpeedKB = 1;
        this.mWeakBufferTimeoutMs = 120000;
        this.mTsNotSkip = false;
        this.mLoadMaxRetryTime = 2;
        this.mPrepared = false;
        this.mIsBuffering = false;
        this.mErrorUrl = "";
        this.mLastRequestUrl = "";
        this.mLastDlSize = 0;
        this.mIsLive = false;
        this.mPlayerMode = 0;
        this.mLiveReopen = false;
        this.mLoopPlayerSwitchUrl = "";
        this.mHDJSwitchUrl = "";
        this.mDataSourceType = DataSourceType.TYPE_DATASOUCE_DEFAULT;
        this.mErrorExtraCodeStore = -1;
        this.mRecordVfps = 0.0f;
        this.mLastVideoWidth = 0;
        this.mLastVideoHeight = 0;
        this.mSkipLoopFilterType = SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mAddrinfoType = AddrinfoType.TYPE_ADDRINFO_DEFAULT;
        this.mAddrinfoTimeoutMs = 0;
        this.mPrepared4StartMode = Prepared4StartMode.MODE_PREPARED4START_DEFAULT;
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.2
            private boolean needInnerRetry(int i2, int i3) {
                return !MgtvMediaPlayer.this.mIsInnerRetrying && MgtvMediaPlayer.this.mMediaPlayer.b4() == 2 && i2 == 200003 && i3 == 100606;
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i2, int i3) {
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.i(logTag, "onError what:" + i2 + ",extra:" + i3 + ",netType:" + NetPlayConfig.getNetworkType());
                if (MgtvMediaPlayer.this.mGifRecorder != null) {
                    MgtvMediaPlayer.this.mGifRecorder.interrupt(101);
                }
                if (MgtvMediaPlayer.this.isDnsCacheEnable()) {
                    MgtvMediaPlayer.this.checkAndCleanDnsCache(i2, i3);
                }
                if (needInnerRetry(i2, i3)) {
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "onError needInnerRetry");
                    MgtvMediaPlayer.this.mIsInnerRetrying = true;
                    MgtvMediaPlayer.this.mRetryLastErrorCode = i3;
                    MgtvMediaPlayer.this.setPlayerReset(true);
                    if (MgtvMediaPlayer.this.mMediaPlayer.b0()) {
                        MgtvMediaPlayer.this.mMediaPlayer.v1(MgtvMediaPlayer.this.mMediaPlayer.t(), i2, i3, MgtvMediaPlayer.this.mMediaPlayer.b4());
                    } else {
                        MgtvMediaPlayer.this.mMediaPlayer.u1(MgtvMediaPlayer.this.mMediaPlayer.t(), i2, i3);
                    }
                    return true;
                }
                MgtvMediaPlayer.this.beforeThrowError(i2, i3);
                MgtvMediaPlayer.this.reportErrorWarning(i2, i3);
                if (i2 != 7000006) {
                    MgtvMediaPlayer.this.reportError(i2, i3, "");
                }
                MgtvMediaPlayer.this.stopTickers();
                MgtvMediaPlayer.this.mPlayStatus = PlayStatus.ERROR;
                MgtvMediaPlayer.this.mErrorExtraCodeStore = i3;
                if (MgtvMediaPlayer.this.mOnErrorListener != null) {
                    return MgtvMediaPlayer.this.mOnErrorListener.onError(i2, i3);
                }
                return true;
            }
        };
        this.mIsGetPositionCallback = false;
        this.mPlayStatus = PlayStatus.IDLE;
        this.mRenderType = RenderType.NATIVE_WINDOW;
        this.mPlayTicker = new ExTicker(1000).setTypeStr("play");
        this.mBufferTick = new ExTicker(1000).setTypeStr("buffer");
        this.mPlayerType = 2;
        this.mMainThreadID = -1L;
        this.mCacheReplaceMap = new LinkedHashMap();
        this.mIsInnerRetrying = false;
        this.mRetryLastErrorCode = 0;
        this.mRenderDisableWarnSended = false;
        this.mForceHttpDns = false;
        this.mHttpDnsNeedRetry = false;
        this.mJavaDnsEnable = false;
        this.mJavaDnsType = a.d.b;
        this.mHttpDnsEnable = false;
        this.mPlayerReset = true;
        this.mLoopPlayerReset = true;
        this.mLastUri = null;
        this.mLastHostErr = MLog.a.b;
        this.mLastTcpErr = MLog.a.b;
        this.mLastIpCount = 0;
        this.mLastIpIndex = -1;
        this.mLastDnsType = -1;
        this.mCurrentDnsDsc = "native";
        this.mEnableP2PHttpDns = false;
        this.mForceP2pHttpDns = false;
        this.mDnsThreadManager = new c().b(new c.c() { // from class: com.hunantv.media.player.MgtvMediaPlayer.3
            public void updateIPs(String str, List<String> list) {
                P2pMgr.YfAddBackupIps(str, list, MgtvMediaPlayer.this.mForceP2pHttpDns);
            }
        });
        this.mAVSyncErrReported = false;
        this.mAVSyncErrSumReported = false;
        this.mAVSyncErrSum = 0;
        this.mAVSyncStartTimestamp = 0L;
        this.mPrepareAsyncTimeStampMs = 0L;
        this.mPreBufferState = new SyncStateMachine(1);
        this.mPreBufferMaxS = 5;
        this.mIsAudioExist = -1;
        this.mIsVsrOpen = -1;
        this.mIsNativePausedLoadData = 0;
        this.mIsWanosAudioEffectValid = false;
        this.mLastPosition = 0;
        this.mPositionLoged = false;
        this.mRealEncodeType = -1;
        this.mStreamFormatType = -1;
        this.mNotifyHandler = new MainNotifyHandler(this);
        this.mWillOpenUrl = "";
        this.mReportedTSLAN = false;
        this.mDnsLock = new Object();
        this.mIsP2pTSSkipReport = false;
        this.mCodecName = "n";
        this.mVVbuft = -1;
        this.mEnableJAVAIPCacheMap = false;
        this.mIPCacheMap = new HashMap();
        this.mVideoFrameClockNotifyMs = -1;
        this.mVideoFrameClockNotifyType = -1;
        this.mVideoFrameClockNotifyTimeStart = -1L;
        this.mVideoFrameClockNotifyTimeEnd = -1L;
        this.mCacheReportTag = DEFAULT_CACHE_REPORT_TAG;
        this.mCacheReportLerr = 0;
        this.mEnableDnsNoNetStrategy = false;
        this.mDnsNoNetWaiter = new Object();
        this.mLastIsNetworkAvailableNNS = true;
        this.mDnsNoNetMaxRetry = 20;
        this.mLastTsSkipErrExtra = 0;
        this.fstime = "n/n";
        this.mcColorFormat = "n_n";
        this.isFlowReportEnable = false;
        this.vsri = "0|0_0|0_0";
        this.vsrver = "n";
        this.vsrvkver = "n";
        this.vsrnpuver = "n";
        this.mSourceNetListner = new MgtvPlayerListener.OnSourceNetHandledListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.4
            public static final int REPORT_HTTP_DNS_INTERRUPT = -2;
            public static final int REPORT_HTTP_DNS_PV = 0;
            private boolean mIsPauseLoad = false;

            private void checkErrorCode(int i2, int i3, Bundle bundle) {
                if (bundle == null) {
                    return;
                }
                int i4 = bundle.getInt("retry_counter");
                MgtvMediaPlayer.this.mSourceRetryCount = i4;
                MgtvMediaPlayer.this.mSourceRetryCode = i3;
                if (MgtvMediaPlayer.this.isDnsCacheEnable() && i4 >= 1 && MgtvMediaPlayer.this.checkAndCleanDnsCache(i2, i3)) {
                    MgtvMediaPlayer.this.mHttpDnsEnable = true;
                }
            }

            private boolean didHDJSwitch(Bundle bundle) {
                if (MgtvMediaPlayer.this.mHDJSwitchUrl.length() <= 0 || bundle == null) {
                    return false;
                }
                bundle.putString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_URL_STRING, MgtvMediaPlayer.this.mHDJSwitchUrl);
                bundle.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_IS_LAST_INT, 1);
                MgtvMediaPlayer.this.mHDJSwitchUrl = "";
                return true;
            }

            private void didHostAddr(Bundle bundle) {
                if (bundle == null) {
                    return;
                }
                int i2 = bundle.getInt("host_error");
                int i3 = bundle.getInt("host_family");
                String string = bundle.getString("host_hostname");
                String string2 = bundle.getString("host_ip");
                int i4 = bundle.getInt("host_port");
                int i5 = MgtvMediaPlayer.this.mLastDnsType = bundle.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_HOST_ARRR_DNS_TYPE_INT);
                DebugLog.d(MgtvMediaPlayer.this.getLogTag(), "callback didHostAddr error:" + i2 + ",family:" + i3 + ",hostname:" + string + ",ip_list:" + string2 + ",port:" + i4 + ",hostDnsType:" + i5);
                MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                StringBuilder sb = new StringBuilder();
                sb.append(i2);
                sb.append("");
                mgtvMediaPlayer.mLastHostErr = sb.toString();
                MgtvMediaPlayer.this.mLastIpIndex = 0;
                try {
                    String[] split = string2.split(g.b);
                    MgtvMediaPlayer.this.mLastIpCount = 0;
                    if (split != null) {
                        for (String str : split) {
                            if (c.a.a.a.k.d.b(str)) {
                                MgtvMediaPlayer.access$4108(MgtvMediaPlayer.this);
                            }
                        }
                    }
                    MgtvMediaPlayer.this.mLastIps = split;
                    if (!MgtvMediaPlayer.this.mEnableJAVAIPCacheMap || i2 != 0 || MgtvMediaPlayer.this.mIPCacheMap.containsKey(string) || split == null || split.length <= 0) {
                        return;
                    }
                    IPList iPList = new IPList(string, split);
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "callback ipcache didHostAddr put:" + string + "-" + IPList.formatIPList(iPList.nUseList));
                    MgtvMediaPlayer.this.mIPCacheMap.put(string, iPList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private boolean didLiveOpen(Bundle bundle) {
                if (bundle == null) {
                    return false;
                }
                return onLiveWillOpen(bundle);
            }

            private boolean didLiveReopen(Bundle bundle) {
                boolean z = MgtvMediaPlayer.this.mLiveReopen;
                if (MgtvMediaPlayer.this.mLiveReopen) {
                    MgtvMediaPlayer.this.mLiveReopen = false;
                }
                return z;
            }

            private boolean didLoopOpen(Bundle bundle) {
                if (bundle == null) {
                    return false;
                }
                return onLiveWillOpen(bundle);
            }

            private boolean didLoopReopen(Bundle bundle) {
                if (MgtvMediaPlayer.this.mLoopPlayerSwitchUrl.length() > 0) {
                    bundle.putString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_URL_STRING, MgtvMediaPlayer.this.mLoopPlayerSwitchUrl);
                    MgtvMediaPlayer.this.mLoopPlayerSwitchUrl = "";
                    return true;
                }
                return false;
            }

            private void didTcpOpen(Bundle bundle) {
                IPList iPList;
                if (bundle == null) {
                    return;
                }
                int i2 = bundle.getInt("port");
                int i3 = bundle.getInt("family");
                int i4 = bundle.getInt("error");
                String string = bundle.getString("ip");
                String string2 = bundle.getString("tcp_hostname");
                long j = bundle.getLong("switch_key");
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.i(logTag, "didTcpOpen switch_key:" + j);
                if (MgtvMediaPlayer.this.mMediaPlayer != null && MgtvMediaPlayer.this.mMediaPlayer.s() != null) {
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.i(logTag2, "didTcpOpen origin:" + MgtvMediaPlayer.this.mMediaPlayer.s());
                }
                String logTag3 = MgtvMediaPlayer.this.getLogTag();
                if (i4 != 0) {
                    DebugLog.e(logTag3, "chodison didTcpOpen port:" + i2 + ",family:" + i3 + ",error_code:" + i4 + ",ip:" + string + ",hostname:" + string2);
                } else {
                    DebugLog.i(logTag3, "chodison didTcpOpen port:" + i2 + ",family:" + i3 + ",ip:" + string + ",hostname:" + string2);
                }
                MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                mgtvMediaPlayer.mLastTcpErr = i4 + "";
                MgtvMediaPlayer.this.mLastTcpIP = string;
                MgtvMediaPlayer.access$2808(MgtvMediaPlayer.this);
                if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap) {
                    try {
                        if (!MgtvMediaPlayer.this.mIPCacheMap.containsKey(string2) || (iPList = (IPList) MgtvMediaPlayer.this.mIPCacheMap.get(string2)) == null) {
                            return;
                        }
                        String logTag4 = MgtvMediaPlayer.this.getLogTag();
                        DebugLog.i(logTag4, "callback ipcache didTcpOpen remove " + string + " from " + string2);
                        iPList.nUseList.remove(string);
                        String logTag5 = MgtvMediaPlayer.this.getLogTag();
                        DebugLog.i(logTag5, "callback ipcache didTcpOpen rest ip:" + IPList.formatIPList(iPList.nUseList));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            private boolean doNetHttpWillOpenFailed(int i2, int i3, Bundle bundle) {
                boolean z;
                List<String> list;
                String logTag;
                String str;
                checkErrorCode(i2, i3, bundle);
                MgtvMediaPlayer.this.mErrorUrl = UrlUtil.getValidUrl(bundle.getString("url"));
                int i4 = bundle.getInt("cur_dl_dize");
                if (isInitMp4(MgtvMediaPlayer.this.mErrorUrl)) {
                    MgtvMediaPlayer.this.mIsInitMp4Error = true;
                } else {
                    MgtvMediaPlayer.this.mIsInitMp4Error = false;
                }
                int i5 = bundle.getInt("retry_counter");
                if (UrlUtil.isFilePrefix(MgtvMediaPlayer.this.mErrorUrl) && !MgtvMediaPlayer.this.mCacheReplaceMap.isEmpty()) {
                    if (MgtvMediaPlayer.this.mOnWarningListener != null) {
                        MgtvPlayerListener.OnWarningListener onWarningListener = MgtvMediaPlayer.this.mOnWarningListener;
                        onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_TS_CACHE_SKIP, i3 + "", MgtvMediaPlayer.this.mErrorUrl, null);
                    }
                    String str2 = (String) MgtvMediaPlayer.this.mCacheReplaceMap.get(MgtvMediaPlayer.this.mErrorUrl);
                    if (str2 != null) {
                        MgtvMediaPlayer.access$7308(MgtvMediaPlayer.this);
                        MgtvMediaPlayer.this.mErrorUrl = str2;
                        bundle.putString("url", str2);
                        String logTag2 = MgtvMediaPlayer.this.getLogTag();
                        DebugLog.i(logTag2, "doNetHttpWillOpenFailed replace local_url to " + str2);
                    }
                }
                bundle.getString("player_hash");
                int i6 = bundle.getInt("io_type");
                c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed url:%s,iotype:%d, RetryCount:%d,error_code:%d-%d", new Object[]{MgtvMediaPlayer.this.mErrorUrl, Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3)});
                if (isENETUNREACHcode(i2, i3) || (MgtvMediaPlayer.this.mPrepared && isDnsError(i2, i3))) {
                    c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed network broken,RetryCount:%d,error_code:%d-%d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3)});
                    return true;
                }
                synchronized (MgtvMediaPlayer.this.mDnsNoNetWaiter) {
                    if (!isPlayerReset() && MgtvMediaPlayer.this.mEnableDnsNoNetStrategy && isDnsError(i2, i3)) {
                        boolean d = c.a.a.b.d.d.d(MgtvMediaPlayer.this.mContext);
                        if (!d) {
                            DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 1000 in");
                            try {
                                MgtvMediaPlayer.this.mDnsNoNetWaiter.wait(1000L);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            logTag = MgtvMediaPlayer.this.getLogTag();
                            str = "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 1000 out";
                            DebugLog.i(logTag, str);
                            z = true;
                        } else if (!d || MgtvMediaPlayer.this.mLastIsNetworkAvailableNNS) {
                            z = false;
                        } else {
                            DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 3000 in");
                            try {
                                MgtvMediaPlayer.this.mDnsNoNetWaiter.wait(PayTask.j);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            logTag = MgtvMediaPlayer.this.getLogTag();
                            str = "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 3000 out";
                            DebugLog.i(logTag, str);
                            z = true;
                        }
                        MgtvMediaPlayer.this.mLastIsNetworkAvailableNNS = d;
                    } else {
                        z = false;
                    }
                }
                String logTag3 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.i(logTag3, "doNetHttpWillOpenFailed mIsLive:" + MgtvMediaPlayer.this.mIsLive + ",mPlayerMode:" + MgtvMediaPlayer.this.mPlayerMode + ",mPrepared:" + MgtvMediaPlayer.this.mPrepared + ",mIsBuffering:" + MgtvMediaPlayer.this.mIsBuffering + ",mTsNotSkip:" + MgtvMediaPlayer.this.mTsNotSkip + ",mLoadMaxRetryTime:" + MgtvMediaPlayer.this.mLoadMaxRetryTime + ",mPlayStatus:" + MgtvMediaPlayer.this.mPlayStatus + ",lip:" + MgtvMediaPlayer.this.getLastIP());
                DebugLog.ifmt(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed %d-%d-%d-%d-%s", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i2), Integer.valueOf(i3), MgtvMediaPlayer.this.mErrorUrl);
                if ((!MgtvMediaPlayer.this.mIsLive || MgtvMediaPlayer.this.isVod()) && MgtvMediaPlayer.this.mPlayerMode != 1) {
                    if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap && (i3 == 100911 || i3 == 300021 || CodeUtil.isHttp4XX(i2, i3) || CodeUtil.isHttp5XX(i2, i3))) {
                        String hostName = UrlUtil.getHostName(UrlUtil.getValidHttpUrl(bundle.getString("url")));
                        if (!StringUtil.isEmpty(hostName) && !c.a.a.a.k.d.g(hostName) && MgtvMediaPlayer.this.mIPCacheMap.containsKey(hostName)) {
                            String logTag4 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag4, "callback ipcache will http contains host:" + hostName);
                            IPList iPList = (IPList) MgtvMediaPlayer.this.mIPCacheMap.get(hostName);
                            if (iPList != null && iPList.checkTTL() && (list = iPList.nUseList) != null && list.size() > 0) {
                                String logTag5 = MgtvMediaPlayer.this.getLogTag();
                                DebugLog.i(logTag5, "callback ipcache will http check ttl success." + iPList);
                                if (i5 >= 6) {
                                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "callback ipcache will http return false.not retry");
                                    reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                                    return false;
                                }
                                bundle.putString("user_msg", MgtvMediaPlayer.USER_MSG_FLAG_USE_CACHE);
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "callback ipcache will http return true.try to goto ip choose");
                                reportHttpErrorPV(i5, MgtvMediaPlayer.this.mErrorUrl, i3, "ipcache");
                                return true;
                            }
                        }
                    }
                    reportHttpErrorPV(i5, MgtvMediaPlayer.this.mErrorUrl, i3, MgtvMediaPlayer.DEFAULT_CACHE_REPORT_TAG);
                    if (z) {
                        if (i5 < MgtvMediaPlayer.this.mDnsNoNetMaxRetry) {
                            DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy retry cause by inDnsNetStrategy");
                            return true;
                        }
                        reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy skip retry cause by errorRetryCount >= mDnsNoNetMaxRetry");
                        return false;
                    } else if (!MgtvMediaPlayer.this.mPrepared) {
                        if (UrlUtil.isM3u8(MgtvMediaPlayer.this.mErrorUrl)) {
                            if (i5 >= 2) {
                                reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                                return false;
                            }
                            return true;
                        } else if (MgtvMediaPlayer.this.isSkipRetryCode(i2, i3) || !isInitMp4(MgtvMediaPlayer.this.mErrorUrl) || i4 <= 0 || i5 >= 10) {
                            if (MgtvMediaPlayer.this.isSkipRetryCode(i2, i3) || i5 >= MgtvMediaPlayer.this.mLoadMaxRetryTime) {
                                MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                                mgtvMediaPlayer.callbackTsSkip(mgtvMediaPlayer.mErrorUrl, i2, i3);
                                reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                                return false;
                            }
                            return true;
                        } else {
                            return true;
                        }
                    } else if (MgtvMediaPlayer.this.mTsNotSkip && MgtvMediaPlayer.this.isRendered()) {
                        return true;
                    }
                } else if (!MgtvMediaPlayer.this.mPrepared) {
                    if (UrlUtil.isM3u8(MgtvMediaPlayer.this.mErrorUrl)) {
                        return i5 < 2;
                    }
                    MgtvMediaPlayer mgtvMediaPlayer2 = MgtvMediaPlayer.this;
                    mgtvMediaPlayer2.callbackTsSkip(mgtvMediaPlayer2.mErrorUrl, i2, i3);
                    return false;
                } else if (MgtvMediaPlayer.this.mIsBuffering && MgtvMediaPlayer.this.isHLSPlayingUrl() && i5 >= 1) {
                    if (UrlUtil.isSegment(MgtvMediaPlayer.this.mErrorUrl)) {
                        MgtvMediaPlayer mgtvMediaPlayer3 = MgtvMediaPlayer.this;
                        mgtvMediaPlayer3.callbackTsSkip(mgtvMediaPlayer3.mErrorUrl, i2, i3);
                    }
                    return false;
                }
                if (MgtvMediaPlayer.this.isSkipRetryCode(i2, i3) || i5 >= 2) {
                    if (UrlUtil.isSegment(MgtvMediaPlayer.this.mErrorUrl)) {
                        MgtvMediaPlayer mgtvMediaPlayer4 = MgtvMediaPlayer.this;
                        mgtvMediaPlayer4.callbackTsSkip(mgtvMediaPlayer4.mErrorUrl, i2, i3);
                    }
                    reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                    return false;
                }
                return true;
            }

            private boolean doNewHttpWillOpen(Bundle bundle) {
                int i2 = bundle.getInt("error_type");
                int i3 = bundle.getInt("error_code");
                bundle.getInt("retry_counter");
                int i4 = bundle.getInt("reset_iplist");
                MgtvMediaPlayer.this.mLastDlSize = bundle.getInt("cur_dl_dize");
                bundle.putString("user_msg", "init");
                if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap && i4 == 1) {
                    MgtvMediaPlayer.this.clearIPCache();
                }
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag, "doNewHttpWillOpen in error_what:" + i2 + ",error_extra:" + i3 + ",reset_iplist:" + i4 + ",mLastDlSize:" + MgtvMediaPlayer.this.mLastDlSize);
                bundle.putInt("reset_iplist", 0);
                if (i3 == 0) {
                    MgtvMediaPlayer.this.mIsInitMp4Error = false;
                    if (i3 == 0 && MgtvMediaPlayer.this.mCacheEable) {
                        replaceUrlFromCache(bundle);
                    }
                    return false;
                }
                boolean doNetHttpWillOpenFailed = doNetHttpWillOpenFailed(i2, i3, bundle);
                String logTag2 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag2, "doNetHttpWillOpenFailed return " + doNetHttpWillOpenFailed + "," + i2 + "-" + i3 + "-" + MgtvMediaPlayer.this.mErrorUrl);
                return doNetHttpWillOpenFailed;
            }

            private boolean doWillGetEnv(Bundle bundle) {
                String string = bundle.getString("env_key");
                if (string == null || string.length() <= 0) {
                    return false;
                }
                bundle.putString("env_value", System.getenv(string));
                return true;
            }

            private boolean doWillHostAddr(Bundle bundle) {
                List<String> list;
                if (bundle == null) {
                    return false;
                }
                int i2 = bundle.getInt("addr_handle");
                String string = bundle.getString("player_hash");
                int i3 = bundle.getInt("retry_counter");
                String string2 = bundle.getString("user_msg");
                String string3 = bundle.getString("addr_hostname");
                long j = bundle.getLong("switch_key");
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag, "callback doWillHostAddr is_handle:" + i2 + ",hash:" + string + ",count_int:" + i3 + ",user_msg:" + string2 + ",hostname:" + string3 + ",switch_key:" + j);
                if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap && i2 != 1 && MgtvMediaPlayer.USER_MSG_FLAG_USE_CACHE.equals(string2) && !c.a.a.a.k.d.g(string3) && MgtvMediaPlayer.this.mIPCacheMap.containsKey(string3)) {
                    try {
                        IPList iPList = (IPList) MgtvMediaPlayer.this.mIPCacheMap.get(string3);
                        if (iPList != null && (list = iPList.nUseList) != null && list.size() > 0 && iPList.checkTTL()) {
                            String str = iPList.nUseList.get(0);
                            if (c.a.a.a.k.d.b(str)) {
                                String logTag2 = MgtvMediaPlayer.this.getLogTag();
                                DebugLog.i(logTag2, "callback ipcache doWillHostAddr put chooseip:" + str);
                                String formatIPList = IPList.formatIPList(iPList.nUseList);
                                if (!StringUtil.isEmpty(formatIPList)) {
                                    String logTag3 = MgtvMediaPlayer.this.getLogTag();
                                    DebugLog.d(logTag3, "callback ipcache doWillHostAddr put srcIPListStr:" + formatIPList);
                                    bundle.putString("addr_hostname", formatIPList);
                                }
                                bundle.putString("addr_ip", str);
                                bundle.putInt("addr_error", 0);
                                return false;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                String string4 = bundle.getString("addr_uri");
                if (c.a.a.a.k.d.f(string3)) {
                    String E = MgtvMediaPlayer.this.mReporter != null ? MgtvMediaPlayer.this.mReporter.E() : "0";
                    notifyIpIsLAN(E, "hostname_" + string3);
                }
                boolean g = c.a.a.a.k.d.g(string3);
                boolean d = c.a.a.b.d.d.d(MgtvMediaPlayer.this.mContext);
                String logTag4 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag4, "doWillHostAddr hostname:" + string3 + ",isIp:" + g);
                String logTag5 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag5, "doWillHostAddr is_handle=" + i2 + ",mBackJavaDns=" + MgtvMediaPlayer.this.mBackJavaDns + ",isIp=" + g + ",mForceHttpDns:" + MgtvMediaPlayer.this.mForceHttpDns);
                if ((MgtvMediaPlayer.this.mForceHttpDns && !g) || ((MgtvMediaPlayer.this.mJavaDnsEnable && !g) || (i2 == 1 && MgtvMediaPlayer.this.mBackJavaDns && !g))) {
                    if (d) {
                        MgtvMediaPlayer.this.mLastUri = string4;
                        domainResolve(string3, bundle, MgtvMediaPlayer.this.mForceHttpDns);
                    } else {
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "skip domainResolve cause net not available");
                    }
                    return MgtvMediaPlayer.this.mPlayerReset;
                }
                if (i2 == 1 && g) {
                    bundle.putString("addr_ip", string3);
                    bundle.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CTRL_ARRR_DNS_TYPE_INT, 0);
                    bundle.putInt("addr_error", 0);
                }
                return false;
            }

            private boolean doWillHttpOpen(Bundle bundle) {
                if (bundle != null) {
                    MgtvMediaPlayer.this.mLastRequestUrl = UrlUtil.getValidUrl(bundle.getString("url"));
                }
                if (MgtvMediaPlayer.this.mReportParams == null || !(MgtvMediaPlayer.this.mReportParams.getVideoType().equals(ReportParams.VideoType.AD_PRE) || MgtvMediaPlayer.this.mReportParams.getVideoType().equals(ReportParams.VideoType.AD_MID))) {
                    if (bundle != null) {
                        MgtvMediaPlayer.this.mWillOpenUrl = bundle.getString("url");
                    }
                    return doNewHttpWillOpen(bundle);
                }
                return onNormalHttpWillOpen(bundle);
            }

            private void domainResolve(String str, Bundle bundle, boolean z) {
                a.d c;
                int k;
                if (str == null || bundle == null) {
                    DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "skip domainResolve hostname or args is null");
                    return;
                }
                a aVar = new a();
                aVar.d(new a.c() { // from class: com.hunantv.media.player.MgtvMediaPlayer.4.1
                    public void onDnsFail(a aVar2) {
                    }

                    public void onDnsFinish(a aVar2) {
                        synchronized (MgtvMediaPlayer.this.mDnsLock) {
                            MgtvMediaPlayer.this.mDnsLock.notifyAll();
                        }
                    }

                    public void onDnsStart(a aVar2) {
                    }

                    public void onDnsSuc(a aVar2, String[] strArr) {
                    }
                });
                boolean resolveStrategy = resolveStrategy(aVar, str, bundle, z, MgtvMediaPlayer.this.mHttpDnsNeedRetry);
                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve use:" + resolveStrategy);
                if (resolveStrategy) {
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve use type:" + aVar.c());
                    notifyHttpDnsReport(aVar.c(), MainNotifyHandler.MSG_HTTPDNS_REPORT_PV, 0);
                }
                synchronized (MgtvMediaPlayer.this.mDnsLock) {
                    while (aVar.n() && !isJavaDnsInterrupt()) {
                        DebugLog.d(MgtvMediaPlayer.this.getLogTag(), "domainResolve wait in");
                        try {
                            MgtvMediaPlayer.this.mDnsLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                DebugLog.d(MgtvMediaPlayer.this.getLogTag(), "domainResolve wait out. resolving:" + aVar.n() + ",isJavaDnsInterrupt:" + isJavaDnsInterrupt());
                String[] c2 = c.a.a.a.k.d.c(aVar.m());
                aVar.o();
                String str2 = "costMs:" + aVar.i() + ";ips:" + com.hunantv.media.utils.StringUtil.formatArrayString(c2) + ";net:" + NetPlayConfig.getNetworkType() + g.b;
                String formatIPList = IPList.formatIPList(c2);
                String str3 = null;
                if (c2 != null && c2.length > 0) {
                    str3 = c2[0];
                }
                int i2 = AnonymousClass28.$SwitchMap$com$hunantv$media$player$dns$AsyncDns$DnsType[aVar.c().ordinal()] == 1 ? 4 : 5;
                if (!isJavaDnsInterrupt() && c.a.a.a.k.d.b(str3)) {
                    if (resolveStrategy) {
                        updateCurrentDnsDsc(aVar.c());
                        if (c.a.a.a.k.d.f(str3)) {
                            notifyHttpDnsReport(aVar.c(), 2001, 100, str2);
                        } else {
                            notifyHttpDnsReport(aVar.c(), 2001, 0, str2);
                        }
                    }
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve put iplist:" + formatIPList);
                    bundle.putString("addr_hostname", formatIPList);
                    if (c.a.a.a.k.d.b(str3)) {
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve put firstIP:" + str3);
                        bundle.putString("addr_ip", str3);
                    }
                    bundle.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CTRL_ARRR_DNS_TYPE_INT, i2);
                    bundle.putInt("addr_error", 0);
                    return;
                }
                if (resolveStrategy) {
                    if (isJavaDnsInterrupt() && aVar.k() == 0) {
                        c = aVar.c();
                        k = -2;
                    } else {
                        c = aVar.c();
                        k = aVar.k();
                    }
                    notifyHttpDnsReport(c, 2002, k, str2);
                    if (!isJavaDnsInterrupt()) {
                        int a = aVar.a((int) Opcodes.IFNONNULL);
                        if (aVar.k() != 0) {
                            a = aVar.k();
                        } else if (str3 != null && !c.a.a.a.k.d.g(str3)) {
                            a = aVar.a(107);
                        }
                        int i3 = -a;
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), aVar.c() + "resolve putInt error:" + i3);
                        bundle.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CTRL_ARRR_DNS_TYPE_INT, i2);
                        bundle.putInt("addr_error", i3);
                    }
                }
                MgtvMediaPlayer.this.mCurrentDnsDsc = "native";
            }

            private String findTsCachPath(String str, String[] strArr) {
                if (strArr == null) {
                    return null;
                }
                try {
                    String fileName = UrlUtil.getFileName(str);
                    for (String str2 : strArr) {
                        if (str2 != null && new File(str2).getName().equals(fileName)) {
                            return str2;
                        }
                    }
                } catch (Exception unused) {
                }
                return null;
            }

            private boolean isDnsError(int i2, int i3) {
                return i3 == 300600 || i2 == 400605 || MGTVP2pDirectMediaDataSource.isP2pDirectDnsError(i2, i3);
            }

            private boolean isENETUNREACHcode(int i2, int i3) {
                return i3 == 300005 || MGTVP2pDirectMediaDataSource.getShortErrorCode(i2, i3) == 101;
            }

            private boolean isInitMp4(String str) {
                return MgtvMediaPlayer.this.isHLSPlayingUrl() && UrlUtil.isSuffixUrl(str, ".mp4");
            }

            private boolean isJavaDnsInterrupt() {
                return isPlayerReset();
            }

            private boolean isPlayerReset() {
                return MgtvMediaPlayer.this.mPlayerReset || (MgtvMediaPlayer.this.mPlayerMode == 2 && MgtvMediaPlayer.this.mLoopPlayerReset);
            }

            private void notifyHttpDnsReport(a.d dVar, int i2, int i3) {
                notifyHttpDnsReport(dVar, i2, i3, "");
            }

            private void notifyHttpDnsReport(a.d dVar, int i2, int i3, String str) {
                if (dVar != a.d.b || MgtvMediaPlayer.this.mOnWarningListener == null) {
                    return;
                }
                notifyMessage(i2, i3, str);
            }

            private void notifyIpIsLAN(String str, String str2) {
                if (MgtvMediaPlayer.this.mOnWarningListener == null || MgtvMediaPlayer.this.mReportParams == null || MgtvMediaPlayer.this.mReportParams.getVideoType() != ReportParams.VideoType.VOD) {
                    return;
                }
                if (!MgtvMediaPlayer.this.mReportedTSLAN) {
                    notifyMessage(1002, str, str2 + "_suffix_" + UrlUtil.getSuffix(MgtvMediaPlayer.this.mWillOpenUrl));
                }
                if (UrlUtil.isM3u8(MgtvMediaPlayer.this.mWillOpenUrl)) {
                    return;
                }
                MgtvMediaPlayer.this.mReportedTSLAN = true;
            }

            private void notifyMessage(int i2, int i3, String str) {
                Message message = new Message();
                message.what = i2;
                message.arg1 = i3;
                message.obj = str;
                MgtvMediaPlayer.this.mNotifyHandler.sendMessage(message);
            }

            private void notifyMessage(int i2, String str, String str2) {
                Message message = new Message();
                message.what = i2;
                Bundle bundle = new Bundle();
                bundle.putString(MainNotifyHandler.BUNDLE_STR_INFO1, str);
                bundle.putString(MainNotifyHandler.BUNDLE_STR_INFO2, str2);
                message.setData(bundle);
                MgtvMediaPlayer.this.mNotifyHandler.sendMessage(message);
            }

            private boolean onLiveWillOpen(Bundle bundle) {
                int i2 = bundle.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_ERROR_WHAT_INT);
                int i3 = bundle.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_ERROR_EXTRA_INT);
                MgtvMediaPlayer.this.mLastRequestUrl = UrlUtil.getValidUrl(bundle.getString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_SRC_URL_STRING));
                if (i3 != 0) {
                    MgtvMediaPlayer.this.mErrorUrl = UrlUtil.getValidUrl(bundle.getString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_SRC_URL_STRING));
                    int i4 = bundle.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_COUNTER_INT);
                    int i5 = bundle.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_ERR_IO_TYPE_INT);
                    c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLiveWillOpen url:%s,iotype:%d, RetryCount:%d,error_code:%d-%d", new Object[]{MgtvMediaPlayer.this.mErrorUrl, Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3)});
                    if (isENETUNREACHcode(i2, i3) || (MgtvMediaPlayer.this.mPrepared && isDnsError(i2, i3))) {
                        c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLiveWillOpen network broken,RetryCount:%d,error_code:%d-%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3)});
                        return true;
                    }
                    DebugLog.ifmt(MgtvMediaPlayer.this.getLogTag(), "OnSourceNetHandledListener.CTRL_WILL_LIVE_OPEN %d-%d-%d-%d-%s", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), MgtvMediaPlayer.this.mErrorUrl);
                    return !MgtvMediaPlayer.this.isSkipRetryCode(i2, i3) && i4 < 2;
                }
                return false;
            }

            private boolean onLoopWillOpen(Bundle bundle) {
                int i2 = bundle.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_ERROR_WHAT_INT);
                int i3 = bundle.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_ERROR_EXTRA_INT);
                if (i3 != 0) {
                    MgtvMediaPlayer.this.mErrorUrl = UrlUtil.getValidUrl(bundle.getString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_SRC_URL_STRING));
                    int i4 = bundle.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_COUNTER_INT);
                    int i5 = bundle.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_ERR_IO_TYPE_INT);
                    c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLoopWillOpen url:%s,iotype:%d, RetryCount:%d,error_code:%d-%d", new Object[]{MgtvMediaPlayer.this.mErrorUrl, Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3)});
                    if (isENETUNREACHcode(i2, i3) || (MgtvMediaPlayer.this.mPrepared && isDnsError(i2, i3))) {
                        c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLoopWillOpen network broken,RetryCount:%d,error_code:%d-%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3)});
                        return true;
                    }
                    DebugLog.ifmt(MgtvMediaPlayer.this.getLogTag(), "OnSourceNetHandledListener.CTRL_WILL_LOOP_OPEN %d-%d-%d-%d-%s", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), MgtvMediaPlayer.this.mErrorUrl);
                    return !MgtvMediaPlayer.this.isSkipRetryCode(i2, i3) && i4 < 2;
                }
                return false;
            }

            /* JADX WARN: Code restructure failed: missing block: B:16:0x00b5, code lost:
                if (r14.this$0.mPrepared != false) goto L15;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private boolean onNormalHttpWillOpen(android.os.Bundle r15) {
                /*
                    Method dump skipped, instructions count: 329
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.player.MgtvMediaPlayer.AnonymousClass4.onNormalHttpWillOpen(android.os.Bundle):boolean");
            }

            private boolean replaceUrlFromCache(Bundle bundle) {
                String string = bundle.getString("url");
                if (!UrlUtil.isFilePrefix(string) && !UrlUtil.isLocal(string)) {
                    String str = null;
                    String fileName = UrlUtil.getFileName(string);
                    if (StringUtil.isEmpty(fileName)) {
                        return false;
                    }
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.d(logTag, "replaceUrlFromCache try to find replace cache:" + string);
                    if (UrlUtil.isM3u8(string)) {
                        String str2 = MgtvMediaPlayer.this.mCacheM3u8Path;
                        String fileName2 = UrlUtil.getFileName(str2);
                        if (!StringUtil.isEmpty(str2) && !StringUtil.isEmpty(fileName2) && fileName2.equals(fileName)) {
                            str = str2;
                        }
                    } else if (MgtvMediaPlayer.this.isHLSPlayingUrl() && UrlUtil.isSegment(string)) {
                        str = findTsCachPath(string, MgtvMediaPlayer.this.mCacheTsPaths);
                    }
                    if (FileUtil.exist(str)) {
                        String addLocalPrefix = UrlUtil.addLocalPrefix(str);
                        if (!StringUtil.isEmpty(addLocalPrefix)) {
                            String logTag2 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag2, "replaceUrlFromCache from " + string);
                            String logTag3 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag3, "replaceUrlFromCache to " + addLocalPrefix);
                            bundle.putString("url", addLocalPrefix);
                            if (UrlUtil.isM3u8(string)) {
                                String logTag4 = MgtvMediaPlayer.this.getLogTag();
                                DebugLog.d(logTag4, "replaceUrlFromCache put SRC_URL " + string);
                                bundle.putString("src_url", string);
                            }
                            MgtvMediaPlayer.this.mCacheReplaceMap.put(addLocalPrefix, string);
                            return true;
                        }
                    }
                }
                return false;
            }

            private void reportHttpErrorErr(int i2, String str) {
                if ((isInitMp4(str) || UrlUtil.isM3u8(str)) && MgtvMediaPlayer.this.mReportParams != null && MgtvMediaPlayer.this.mReportParams.getVideoType() == ReportParams.VideoType.VOD && MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.NO_PROXY && MgtvMediaPlayer.this.mOnWarningListener != null) {
                    String E = MgtvMediaPlayer.this.mReporter != null ? MgtvMediaPlayer.this.mReporter.E() : MLog.a.b;
                    MgtvPlayerListener.OnWarningListener onWarningListener = MgtvMediaPlayer.this.mOnWarningListener;
                    String str2 = i2 + Consts.DOT + MgtvMediaPlayer.this.mCacheReportLerr;
                    StringBuilder sb = new StringBuilder();
                    sb.append("psuuid_");
                    sb.append(E);
                    sb.append("_render_");
                    sb.append(MgtvMediaPlayer.this.isRendered() ? "1" : "0");
                    sb.append("_url_");
                    sb.append(str);
                    sb.append("_type_");
                    sb.append(MgtvMediaPlayer.this.mCacheReportTag);
                    onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_HTTP_ERROR_ERR, str2, sb.toString(), null);
                }
            }

            private void reportHttpErrorPV(int i2, String str, int i3, String str2) {
                if (i2 == 0) {
                    MgtvMediaPlayer.this.mCacheReportTag = MgtvMediaPlayer.DEFAULT_CACHE_REPORT_TAG;
                    MgtvMediaPlayer.this.mCacheReportLerr = 0;
                }
                if (i2 == 0) {
                    if ((isInitMp4(str) || UrlUtil.isM3u8(str)) && MgtvMediaPlayer.this.mReportParams != null && MgtvMediaPlayer.this.mReportParams.getVideoType() == ReportParams.VideoType.VOD && MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.NO_PROXY && MgtvMediaPlayer.this.mOnWarningListener != null) {
                        String E = MgtvMediaPlayer.this.mReporter != null ? MgtvMediaPlayer.this.mReporter.E() : MLog.a.b;
                        MgtvMediaPlayer.this.mCacheReportTag = str2;
                        MgtvMediaPlayer.this.mCacheReportLerr = i3;
                        MgtvPlayerListener.OnWarningListener onWarningListener = MgtvMediaPlayer.this.mOnWarningListener;
                        String str3 = i3 + "";
                        StringBuilder sb = new StringBuilder();
                        sb.append("psuuid_");
                        sb.append(E);
                        sb.append("_render_");
                        sb.append(MgtvMediaPlayer.this.isRendered() ? "1" : "0");
                        sb.append("_url_");
                        sb.append(str);
                        sb.append("_type_");
                        sb.append(str2);
                        onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_HTTP_ERROR_PV, str3, sb.toString(), null);
                    }
                }
            }

            private boolean resolveStrategy(@NonNull a aVar, @NonNull String str, Bundle bundle) {
                return resolveStrategy(aVar, str, bundle, false, false);
            }

            private boolean resolveStrategy(@NonNull a aVar, @NonNull String str, Bundle bundle, boolean z, boolean z2) {
                a.d dVar;
                String logTag;
                String str2;
                if (z || (bundle != null && bundle.getInt("addr_handle") == 1 && MgtvMediaPlayer.this.mBackJavaDns)) {
                    aVar.j(1);
                    dVar = a.d.b;
                } else {
                    if (MgtvMediaPlayer.this.isDnsCacheEnable()) {
                        if (MgtvMediaPlayer.this.mHttpDnsEnable) {
                            String a = StringUtil.isEmpty(MgtvMediaPlayer.this.mLastUri) ? null : c.a.a.a.k.e.a(MgtvMediaPlayer.this.mLastUri);
                            if (a != null && !a.trim().equals("")) {
                                logTag = MgtvMediaPlayer.this.getLogTag();
                                str2 = "resolveStrategy cache valid";
                            }
                        } else {
                            logTag = MgtvMediaPlayer.this.getLogTag();
                            str2 = "resolveStrategy cache valid and httpdns not open";
                        }
                        DebugLog.d(logTag, str2);
                        return false;
                    }
                    dVar = MgtvMediaPlayer.this.mJavaDnsType;
                }
                aVar.e(str, dVar, z2);
                return true;
            }

            private void updateCurrentDnsDsc(a.d dVar) {
                MgtvMediaPlayer mgtvMediaPlayer;
                String str;
                int i2 = AnonymousClass28.$SwitchMap$com$hunantv$media$player$dns$AsyncDns$DnsType[dVar.ordinal()];
                if (i2 == 1) {
                    mgtvMediaPlayer = MgtvMediaPlayer.this;
                    str = MgtvMediaPlayer.DNS_JAVA_NORMAL;
                } else if (i2 != 2) {
                    return;
                } else {
                    mgtvMediaPlayer = MgtvMediaPlayer.this;
                    str = MgtvMediaPlayer.DNS_JAVA_HTTPDNS;
                }
                mgtvMediaPlayer.mCurrentDnsDsc = str;
            }

            private void updateIp(String str) {
                String logTag;
                StringBuilder sb;
                String str2;
                if (MgtvMediaPlayer.this.mMediaPlayer == null || (!(MgtvMediaPlayer.this.mMediaPlayer.v() == 2 || MgtvMediaPlayer.this.mMediaPlayer.v() == 1) || MgtvMediaPlayer.this.mMediaPlayer.o4() == null)) {
                    if (MgtvMediaPlayer.this.mMediaPlayer == null || !((MgtvMediaPlayer.this.mMediaPlayer.v() == 2 || MgtvMediaPlayer.this.mMediaPlayer.v() == 1) && MgtvMediaPlayer.this.mMediaPlayer.o4() == null)) {
                        MgtvMediaPlayer.this.mLastIP = str;
                    } else {
                        MgtvMediaPlayer.this.mLastIP = "0.0.0.1";
                    }
                    logTag = MgtvMediaPlayer.this.getLogTag();
                    sb = new StringBuilder();
                    str2 = "didTcpOpen tcp_ip:";
                } else {
                    MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                    mgtvMediaPlayer.mLastIP = P2pMgr.getCdnIpFromP2PTask(mgtvMediaPlayer.mMediaPlayer.o4());
                    logTag = MgtvMediaPlayer.this.getLogTag();
                    sb = new StringBuilder();
                    str2 = "didTcpOpen p2p QueryTaskInfo cdnIp:";
                }
                sb.append(str2);
                sb.append(MgtvMediaPlayer.this.mLastIP);
                DebugLog.d(logTag, sb.toString());
            }

            private void willTcpOpen(Bundle bundle) {
                if (bundle == null) {
                    return;
                }
                String string = bundle.getString("tcp_hostname");
                String string2 = bundle.getString("ip");
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag, "callback willTcpOpen tcp_hostname:" + string + ",tcp_ip:" + string2);
                MgtvMediaPlayer.this.mLastHostIP = string2;
                updateIp(string2);
                if (string2 == null || string2.length() <= 1 || !c.a.a.a.k.d.f(string2)) {
                    return;
                }
                notifyIpIsLAN("1", MgtvMediaPlayer.this.getCurrentDnsDsc() + "_hostip_" + string2);
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSourceNetHandledListener
            public boolean onSourceNetCtrl(int i2, Bundle bundle) {
                IP2pTask o4;
                c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "OnSourceNetHandledListener.onSourceNetCtrl 0x%5x", new Object[]{Integer.valueOf(i2)});
                switch (i2) {
                    case 131073:
                        willTcpOpen(bundle);
                        break;
                    case 131074:
                        didTcpOpen(bundle);
                        break;
                    case 131075:
                        return doWillHttpOpen(bundle);
                    case 131077:
                        return didLiveOpen(bundle);
                    case 131078:
                        return doWillHostAddr(bundle);
                    case 131081:
                        return didLiveReopen(bundle);
                    case 131088:
                        return didLoopOpen(bundle);
                    case 131089:
                        return didLoopReopen(bundle);
                    case 131090:
                        return didHDJSwitch(bundle);
                    case 131104:
                        return doWillGetEnv(bundle);
                    case 131120:
                        if (MgtvMediaPlayer.this.mPreBufferState.isEnable() && MgtvMediaPlayer.this.mPreBufferState.getState() == 2) {
                            this.mIsPauseLoad = true;
                            return true;
                        } else if (MgtvMediaPlayer.this.isSourceSwitching() || MgtvMediaPlayer.this.mMediaPlayer == null || (!(MgtvMediaPlayer.this.mMediaPlayer.v() == 2 || MgtvMediaPlayer.this.mMediaPlayer.v() == 1) || (o4 = MgtvMediaPlayer.this.mMediaPlayer.o4()) == null || o4.getStatus() == 0)) {
                            if (this.mIsPauseLoad) {
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "CTRL_WILL_CHECK_PAUSE_LOAD will return false. will resume load");
                            }
                            this.mIsPauseLoad = false;
                            return false;
                        } else {
                            if (!this.mIsPauseLoad) {
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "CTRL_WILL_CHECK_PAUSE_LOAD will return true. will pause load");
                            }
                            this.mIsPauseLoad = true;
                            return true;
                        }
                    case 131184:
                        synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                            if (bundle == null) {
                                break;
                            } else if (bundle.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_NEED_RETRY_INT) == 1) {
                                if (MgtvMediaPlayer.this.mReporter != null) {
                                    MgtvMediaPlayer.this.mReporter.M();
                                }
                                int i3 = (int) bundle.getLong(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_RETRY_KEY_LONG);
                                SmoothMediaSource smoothMediaSource = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i3));
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth need_retry == 1 find:" + i3);
                                if (smoothMediaSource != null) {
                                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth need_retry == 1 , will retry use :" + smoothMediaSource.getUrl());
                                    bundle.putString("smooth_switch_url", smoothMediaSource.getUrl());
                                    if (smoothMediaSource.getReporter() != null) {
                                        smoothMediaSource.getReporter().H();
                                        if (MgtvMediaPlayer.this.mReportParams != null) {
                                            MgtvMediaPlayer.this.mReportParams.setPlaySessionId(smoothMediaSource.getReporter().E());
                                        }
                                    }
                                } else {
                                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth need_retry == 1, not found source");
                                }
                                bundle.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_NEED_RETRY_INT, 0);
                                return true;
                            } else {
                                int i4 = (int) bundle.getLong("smooth_switch_key");
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth CTRL_WILL_SMOOTH_SWITCH switch_key:" + i4);
                                SmoothMediaSource matchLastKeySource = MgtvMediaPlayer.this.matchLastKeySource(i4);
                                if (matchLastKeySource != null) {
                                    if (matchLastKeySource.isLastRetry() && MgtvMediaPlayer.this.mReportParams != null && (MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.ONLY_P2P || MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.P2P_DRM)) {
                                        SmoothMediaSource smoothMediaSource2 = new SmoothMediaSource(MgtvMediaPlayer.this.getPlayingOriginUrl());
                                        smoothMediaSource2.setReportParams(MgtvMediaPlayer.this.mReportParams);
                                        smoothMediaSource2.bind(MgtvMediaPlayer.this);
                                        smoothMediaSource2.setThrowErrorIfSwitchFailed(true);
                                        MgtvMediaPlayer.this.mSmoothSourcesRecord.put(Integer.valueOf(smoothMediaSource2.getKey()), smoothMediaSource2);
                                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth is last retry. will retry key:" + smoothMediaSource2.getKey());
                                        bundle.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_NEED_RETRY_INT, 1);
                                        bundle.putLong(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_RETRY_KEY_LONG, smoothMediaSource2.getKey());
                                    }
                                    if (!matchLastKeySource.isLastRetry()) {
                                        String string = bundle.getString("smooth_switch_url");
                                        bundle.putString("smooth_switch_url", string);
                                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth CTRL_WILL_SMOOTH_SWITCH switch_url:" + string);
                                        if (!StringUtil.isEmpty(string)) {
                                            int indexOf = string.indexOf(",mgtvjsource:");
                                            String substring = indexOf >= 0 ? string.substring(indexOf) : "";
                                            boolean onSwitchSmoothSourceWillUpdate = MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener != null ? MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener.onSwitchSmoothSourceWillUpdate(matchLastKeySource) : false;
                                            if (matchLastKeySource.getReadType() != 2 && onSwitchSmoothSourceWillUpdate && !StringUtil.isEmpty(matchLastKeySource.useUpdateUrl())) {
                                                String str = matchLastKeySource.useUpdateUrl() + substring;
                                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth CTRL_WILL_SMOOTH_SWITCH will update url:" + str);
                                                bundle.putString("smooth_switch_url", str);
                                            }
                                        }
                                    }
                                }
                                SmoothMediaSource smoothMediaSource3 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i4));
                                if (smoothMediaSource3 != null && smoothMediaSource3.getReporter() != null) {
                                    smoothMediaSource3.getReporter().H();
                                    if (MgtvMediaPlayer.this.mReportParams != null) {
                                        MgtvMediaPlayer.this.mReportParams.setPlaySessionId(smoothMediaSource3.getReporter().E());
                                    }
                                }
                                return true;
                            }
                        }
                        break;
                }
                return false;
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSourceNetHandledListener
            public void onSourceNetEvent(int i2, Bundle bundle) {
                if (i2 != 78338) {
                    return;
                }
                didHostAddr(bundle);
            }
        };
        this.mLogTagKey = "";
        this.mEnableReport = true;
        this.p2pLocker = new Object();
        this.mSeekStartMs = -1L;
        this.mHw2SwType = Hw2SwType.NONE;
        this.mPlaybackSpeed = 1.0f;
        this.mRecordMaxPlaySpeed = 1.0f;
        this.mFrameListener = new MgtvPlayerListener.OnFrameListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.22
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnFrameListener
            public void onVFrameClockCome(MgtvPlayerListener.FrameClock frameClock) {
                synchronized (MgtvMediaPlayer.this.ptsLocker) {
                    WeakHandler weakHandler = MgtvMediaPlayer.this.ptsWeakHandler;
                    if (weakHandler != null) {
                        weakHandler.removeMessages(256);
                        Message message = new Message();
                        message.what = 256;
                        message.obj = frameClock;
                        MgtvMediaPlayer.this.ptsWeakHandler.sendMessage(message);
                    }
                    if (MgtvMediaPlayer.this.mOnFrameListener != null) {
                        MgtvMediaPlayer.this.mOnFrameListener.onVFrameClockCome(frameClock);
                    }
                }
            }
        };
        this.mInnerFlowDataStatistic = new FlowDataStatistic();
        this.mEnableImgoVsr = false;
        this.mLoopSourceKey = new AtomicInteger(1);
        this.mSubtitleSources = new ArrayList();
        this.ptsHandlerThread = null;
        this.ptsWeakHandler = null;
        this.ptsListeners = new HashSet();
        this.ptsLocker = new Object();
        this.mSmoothSourceListener = new d.n() { // from class: com.hunantv.media.player.MgtvMediaPlayer.26
            public int lastSwitchingKey = -1;

            public void onSmoothSwitchSourceComplete(d dVar, int i2, int i3, String str) {
                SmoothMediaSource smoothMediaSource;
                synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.d(logTag, "onSmoothSwitchSourceComplete (type:" + i3 + ",key:" + i2 + ",msg:" + str + ")");
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSmoothSwitchSourceComplete current: ");
                    sb.append(MgtvMediaPlayer.this.getCurrentSmoothSourceKey());
                    DebugLog.i(logTag2, sb.toString());
                    for (Map.Entry entry : MgtvMediaPlayer.this.mSmoothSourcesRecord.entrySet()) {
                        if (((Integer) entry.getKey()).intValue() < i2 && (smoothMediaSource = (SmoothMediaSource) entry.getValue()) != null && !smoothMediaSource.isReleased()) {
                            smoothMediaSource.release();
                        }
                    }
                    MgtvMediaPlayer.this.mSmoothUseP2pFailed = false;
                    if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                        MgtvMediaPlayer.this.mMediaPlayer.k2(false);
                    }
                    SmoothMediaSource smoothMediaSource2 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i2));
                    if (smoothMediaSource2 != null) {
                        if (!StringUtil.isEmpty(smoothMediaSource2.getVfps())) {
                            MgtvMediaPlayer.this.mRecordVfps = Float.parseFloat(smoothMediaSource2.getVfps());
                        }
                        MgtvMediaPlayer.this.mLastVideoWidth = smoothMediaSource2.getVideoWidth();
                        MgtvMediaPlayer.this.mLastVideoHeight = smoothMediaSource2.getVideoHeight();
                        if (MgtvMediaPlayer.this.mReporter != null) {
                            MgtvMediaPlayer.this.mReporter.M();
                        }
                        MgtvMediaPlayer.this.mReporter = smoothMediaSource2.getReporter();
                        if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                            MgtvMediaPlayer.this.mMediaPlayer.o0(MgtvMediaPlayer.this.mReporter);
                            MgtvMediaPlayer.this.mMediaPlayer.A0(smoothMediaSource2.getReadType(), smoothMediaSource2.getUrl(), smoothMediaSource2.getPlayingUrl());
                            MgtvMediaPlayer.this.mMediaPlayer.N1(smoothMediaSource2.getEnableImgoAIQE());
                        }
                        if (MgtvMediaPlayer.this.mDataSourceInfo != null) {
                            MgtvMediaPlayer.this.mDataSourceInfo.setVideoFormat(smoothMediaSource2.getVideoFormat());
                            MgtvMediaPlayer.this.mDataSourceInfo.setAudioFormat(smoothMediaSource2.getAudioFormat());
                            MgtvMediaPlayer.this.mDataSourceInfo.setFileFormat(smoothMediaSource2.getFileFormat());
                        }
                        if (MgtvMediaPlayer.this.mReporter != null) {
                            MgtvMediaPlayer.this.mReportParams.deepCopy(smoothMediaSource2.getReportParams());
                            MgtvMediaPlayer.this.mReporter.n(MgtvMediaPlayer.this.mReportParams);
                            MgtvMediaPlayer.this.mReporter.N();
                        }
                        String keyFrameMapKey = MgtvMediaPlayer.this.getKeyFrameMapKey(smoothMediaSource2.getVid(), smoothMediaSource2.getDef());
                        if (MgtvMediaPlayer.this.mSmoothKeyFrameMap.containsKey(keyFrameMapKey)) {
                            String logTag3 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag3, "find smoothKeyFrameKey :" + keyFrameMapKey + " set to player");
                            byte[] bArr = MgtvMediaPlayer.this.mSmoothKeyFrameMap.get(keyFrameMapKey);
                            if (KeyFrameInfoUtils.isKeyFrameDataValid(bArr, smoothMediaSource2.videoFileHash) == 0) {
                                MgtvMediaPlayer.this.setKeyFrameInfoFileBuf(bArr);
                            }
                        }
                    }
                    SmoothMediaSource matchLastKeySource = MgtvMediaPlayer.this.matchLastKeySource(i2);
                    if (matchLastKeySource == null) {
                        DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "onSmoothSwitchSourceComplete matchKeySource failed");
                        return;
                    }
                    if (matchLastKeySource.getSwitchMod() == 1) {
                        MgtvMediaPlayer.this.mMediaPlayer.w2(true);
                    }
                    MgtvMediaPlayer.this.mSwitchedSmoothSource = matchLastKeySource;
                    MgtvMediaPlayer.this.mSourceSwitchingComplete = true;
                    MgtvMediaPlayer.this.mSourceSwitching = false;
                    if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                        MgtvMediaPlayer.this.mMainFlowReportProcessor = matchLastKeySource.getFlowReportProcessor();
                        MgtvMediaPlayer.this.mMediaPlayer.L0(matchLastKeySource.getP2pTask());
                        MgtvMediaPlayer.this.mMediaPlayer.j3(matchLastKeySource.getReadType());
                    }
                    MgtvMediaPlayer.this.mSmoothKeyFrameMap.clear();
                    if (MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener != null) {
                        MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener.onSwitchSmoothSourceSuccess(matchLastKeySource);
                    }
                }
            }

            public void onSmoothSwitchSourceFailed(d dVar, int i2, int i3, String str) {
                String[] split;
                synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.e(logTag, "onSmoothSwitchSourceFailed (type:" + i3 + ",key:" + i2 + ",msg:" + str + ")");
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSmoothSwitchSourceFailed current: ");
                    sb.append(MgtvMediaPlayer.this.getCurrentSmoothSourceKey());
                    DebugLog.e(logTag2, sb.toString());
                    int i4 = MgtvMediaPlayer.WHAT_SMOOTHSOURCE_FAIL;
                    int i5 = -1;
                    try {
                        if (!StringUtil.isEmpty(str) && (split = str.split("-")) != null && split.length >= 2) {
                            i4 = NumericUtil.parseInt(split[0]);
                            i5 = NumericUtil.parseInt(split[1]);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    SmoothMediaSource smoothMediaSource = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i2));
                    if (smoothMediaSource != null) {
                        if (smoothMediaSource.getReporter() != null) {
                            smoothMediaSource.getReporter().l(i4, i5, "");
                        }
                        if (MgtvMediaPlayer.this.mReportParams != null) {
                            String logTag3 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag3, "onSmoothSwitchSourceFailed mReportParams:" + MgtvMediaPlayer.this.mReportParams.getProxyType() + "-" + MgtvMediaPlayer.this.mReportParams.getP2ps());
                        }
                        if (smoothMediaSource.getReportParams() != null) {
                            String logTag4 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag4, "onSmoothSwitchSourceFailed currentSource.getReportParams():" + smoothMediaSource.getReportParams().getProxyType() + "-" + smoothMediaSource.getReportParams().getP2ps());
                        }
                        if (MgtvMediaPlayer.this.mReportParams != null && MgtvMediaPlayer.this.mReportParams.isP2p() && smoothMediaSource.getReportParams() != null && smoothMediaSource.getReportParams().isP2p()) {
                            MgtvMediaPlayer.this.mSmoothUseP2pFailed = true;
                            if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                                MgtvMediaPlayer.this.mMediaPlayer.k2(true);
                            }
                        }
                        if (smoothMediaSource.isThrowErrorIfSwitchFailed()) {
                            MgtvMediaPlayer.this.mErrorListener.onError(MgtvMediaPlayer.WHAT_SMOOTHSOURCE_EX_ERROR, i5);
                            return;
                        }
                    }
                    if (i3 == 1) {
                        MgtvMediaPlayer.this.mErrorListener.onError(i4, i5);
                        return;
                    }
                    SmoothMediaSource matchLastKeySource = MgtvMediaPlayer.this.matchLastKeySource(i2);
                    if (matchLastKeySource == null) {
                        DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "onSmoothSwitchSourceFailed matchKeySource failed");
                    } else {
                        MgtvMediaPlayer.this.notifySwitchSmoothSourceFail(matchLastKeySource, i4, i5);
                    }
                }
            }

            public void onSmoothSwitchSourceInfo(d dVar, int i2, int i3, String str) {
                synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.i(logTag, "onSmoothSwitchSourceInfo (event:" + i3 + ",key:" + i2 + ",msg:" + str + ")");
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSmoothSwitchSourceInfo current: ");
                    sb.append(MgtvMediaPlayer.this.getCurrentSmoothSourceKey());
                    DebugLog.i(logTag2, sb.toString());
                    SmoothMediaSource smoothMediaSource = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i2));
                    if (smoothMediaSource != null) {
                        if (i3 == 0) {
                            smoothMediaSource.s_event_0_timestamp = System.currentTimeMillis();
                        } else if (i3 == 11) {
                            smoothMediaSource.s_event_11_timestamp = System.currentTimeMillis();
                        } else if (i3 == 2) {
                            if (MgtvMediaPlayer.this.isFlowReportEnable) {
                                smoothMediaSource.genFlowReporter();
                            }
                            smoothMediaSource.s_event_2_timestamp = System.currentTimeMillis();
                        } else if (i3 == 3) {
                            if (MgtvMediaPlayer.this.isFlowReportEnable && MgtvMediaPlayer.this.mMainFlowReportProcessor != null) {
                                MgtvMediaPlayer.this.mMainFlowReportProcessor.stop();
                            }
                            for (Map.Entry entry : MgtvMediaPlayer.this.mSmoothSourcesRecord.entrySet()) {
                                if (((Integer) entry.getKey()).intValue() < smoothMediaSource.getKey()) {
                                    SmoothMediaSource smoothMediaSource2 = (SmoothMediaSource) entry.getValue();
                                    if (MgtvMediaPlayer.this.isFlowReportEnable && smoothMediaSource2 != null && smoothMediaSource2.getFlowReportProcessor() != null) {
                                        smoothMediaSource2.getFlowReportProcessor().stop();
                                    }
                                }
                            }
                            smoothMediaSource.s_event_3_timestamp = System.currentTimeMillis();
                        }
                    }
                    if (i3 != 3) {
                        if (MgtvMediaPlayer.this.matchLastKeySource(i2) == null) {
                            DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "onSmoothSwitchSourceInfo matchKeySource failed");
                            return;
                        }
                        if (i3 == 0) {
                            MgtvMediaPlayer.this.mSourceSwitching = true;
                        }
                        return;
                    }
                    SmoothMediaSource smoothMediaSource3 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(this.lastSwitchingKey));
                    if (smoothMediaSource3 != null && smoothMediaSource3.getReporter() != null) {
                        smoothMediaSource3.getReporter().M();
                    }
                    this.lastSwitchingKey = i2;
                    SmoothMediaSource smoothMediaSource4 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i2));
                    if (smoothMediaSource4 != null && MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener != null) {
                        MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener.onSwitchSmoothSourceInfo(smoothMediaSource4, i3);
                    }
                }
            }
        };
        this.mSmoothSourcesRecord = new HashMap();
        this.mSwitchSmoothSourceLocker = new Object();
        this.mSmoothUseP2pFailed = false;
        this.mSmoothKeyFrameMap = Collections.synchronizedMap(new HashMap());
        this.isBackground = false;
        this.isSpaceAudioSwitchOn = false;
        init(i, context);
    }

    public MgtvMediaPlayer(int i, Context context, Bundle bundle) throws UnsatisfiedLinkError, SecurityException, NullPointerException, OutOfMemoryError {
        this.mDebug = false;
        this.mPreBufferTimeoutMs = 1800000;
        this.mBufferTimeoutMs = 180000;
        this.mImgoMediaPlayerAudioMode = false;
        this.mAccurateSeekEnable = true;
        this.mAccSeekKeyFrameInterval = 1000;
        this.mKeyframeSeekEnable = false;
        this.mInnerAutoRotateEnable = false;
        this.mWeakBufferSpeedKB = 1;
        this.mWeakBufferTimeoutMs = 120000;
        this.mTsNotSkip = false;
        this.mLoadMaxRetryTime = 2;
        this.mPrepared = false;
        this.mIsBuffering = false;
        this.mErrorUrl = "";
        this.mLastRequestUrl = "";
        this.mLastDlSize = 0;
        this.mIsLive = false;
        this.mPlayerMode = 0;
        this.mLiveReopen = false;
        this.mLoopPlayerSwitchUrl = "";
        this.mHDJSwitchUrl = "";
        this.mDataSourceType = DataSourceType.TYPE_DATASOUCE_DEFAULT;
        this.mErrorExtraCodeStore = -1;
        this.mRecordVfps = 0.0f;
        this.mLastVideoWidth = 0;
        this.mLastVideoHeight = 0;
        this.mSkipLoopFilterType = SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mAddrinfoType = AddrinfoType.TYPE_ADDRINFO_DEFAULT;
        this.mAddrinfoTimeoutMs = 0;
        this.mPrepared4StartMode = Prepared4StartMode.MODE_PREPARED4START_DEFAULT;
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.2
            private boolean needInnerRetry(int i2, int i3) {
                return !MgtvMediaPlayer.this.mIsInnerRetrying && MgtvMediaPlayer.this.mMediaPlayer.b4() == 2 && i2 == 200003 && i3 == 100606;
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i2, int i3) {
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.i(logTag, "onError what:" + i2 + ",extra:" + i3 + ",netType:" + NetPlayConfig.getNetworkType());
                if (MgtvMediaPlayer.this.mGifRecorder != null) {
                    MgtvMediaPlayer.this.mGifRecorder.interrupt(101);
                }
                if (MgtvMediaPlayer.this.isDnsCacheEnable()) {
                    MgtvMediaPlayer.this.checkAndCleanDnsCache(i2, i3);
                }
                if (needInnerRetry(i2, i3)) {
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "onError needInnerRetry");
                    MgtvMediaPlayer.this.mIsInnerRetrying = true;
                    MgtvMediaPlayer.this.mRetryLastErrorCode = i3;
                    MgtvMediaPlayer.this.setPlayerReset(true);
                    if (MgtvMediaPlayer.this.mMediaPlayer.b0()) {
                        MgtvMediaPlayer.this.mMediaPlayer.v1(MgtvMediaPlayer.this.mMediaPlayer.t(), i2, i3, MgtvMediaPlayer.this.mMediaPlayer.b4());
                    } else {
                        MgtvMediaPlayer.this.mMediaPlayer.u1(MgtvMediaPlayer.this.mMediaPlayer.t(), i2, i3);
                    }
                    return true;
                }
                MgtvMediaPlayer.this.beforeThrowError(i2, i3);
                MgtvMediaPlayer.this.reportErrorWarning(i2, i3);
                if (i2 != 7000006) {
                    MgtvMediaPlayer.this.reportError(i2, i3, "");
                }
                MgtvMediaPlayer.this.stopTickers();
                MgtvMediaPlayer.this.mPlayStatus = PlayStatus.ERROR;
                MgtvMediaPlayer.this.mErrorExtraCodeStore = i3;
                if (MgtvMediaPlayer.this.mOnErrorListener != null) {
                    return MgtvMediaPlayer.this.mOnErrorListener.onError(i2, i3);
                }
                return true;
            }
        };
        this.mIsGetPositionCallback = false;
        this.mPlayStatus = PlayStatus.IDLE;
        this.mRenderType = RenderType.NATIVE_WINDOW;
        this.mPlayTicker = new ExTicker(1000).setTypeStr("play");
        this.mBufferTick = new ExTicker(1000).setTypeStr("buffer");
        this.mPlayerType = 2;
        this.mMainThreadID = -1L;
        this.mCacheReplaceMap = new LinkedHashMap();
        this.mIsInnerRetrying = false;
        this.mRetryLastErrorCode = 0;
        this.mRenderDisableWarnSended = false;
        this.mForceHttpDns = false;
        this.mHttpDnsNeedRetry = false;
        this.mJavaDnsEnable = false;
        this.mJavaDnsType = a.d.b;
        this.mHttpDnsEnable = false;
        this.mPlayerReset = true;
        this.mLoopPlayerReset = true;
        this.mLastUri = null;
        this.mLastHostErr = MLog.a.b;
        this.mLastTcpErr = MLog.a.b;
        this.mLastIpCount = 0;
        this.mLastIpIndex = -1;
        this.mLastDnsType = -1;
        this.mCurrentDnsDsc = "native";
        this.mEnableP2PHttpDns = false;
        this.mForceP2pHttpDns = false;
        this.mDnsThreadManager = new c().b(new c.c() { // from class: com.hunantv.media.player.MgtvMediaPlayer.3
            public void updateIPs(String str, List<String> list) {
                P2pMgr.YfAddBackupIps(str, list, MgtvMediaPlayer.this.mForceP2pHttpDns);
            }
        });
        this.mAVSyncErrReported = false;
        this.mAVSyncErrSumReported = false;
        this.mAVSyncErrSum = 0;
        this.mAVSyncStartTimestamp = 0L;
        this.mPrepareAsyncTimeStampMs = 0L;
        this.mPreBufferState = new SyncStateMachine(1);
        this.mPreBufferMaxS = 5;
        this.mIsAudioExist = -1;
        this.mIsVsrOpen = -1;
        this.mIsNativePausedLoadData = 0;
        this.mIsWanosAudioEffectValid = false;
        this.mLastPosition = 0;
        this.mPositionLoged = false;
        this.mRealEncodeType = -1;
        this.mStreamFormatType = -1;
        this.mNotifyHandler = new MainNotifyHandler(this);
        this.mWillOpenUrl = "";
        this.mReportedTSLAN = false;
        this.mDnsLock = new Object();
        this.mIsP2pTSSkipReport = false;
        this.mCodecName = "n";
        this.mVVbuft = -1;
        this.mEnableJAVAIPCacheMap = false;
        this.mIPCacheMap = new HashMap();
        this.mVideoFrameClockNotifyMs = -1;
        this.mVideoFrameClockNotifyType = -1;
        this.mVideoFrameClockNotifyTimeStart = -1L;
        this.mVideoFrameClockNotifyTimeEnd = -1L;
        this.mCacheReportTag = DEFAULT_CACHE_REPORT_TAG;
        this.mCacheReportLerr = 0;
        this.mEnableDnsNoNetStrategy = false;
        this.mDnsNoNetWaiter = new Object();
        this.mLastIsNetworkAvailableNNS = true;
        this.mDnsNoNetMaxRetry = 20;
        this.mLastTsSkipErrExtra = 0;
        this.fstime = "n/n";
        this.mcColorFormat = "n_n";
        this.isFlowReportEnable = false;
        this.vsri = "0|0_0|0_0";
        this.vsrver = "n";
        this.vsrvkver = "n";
        this.vsrnpuver = "n";
        this.mSourceNetListner = new MgtvPlayerListener.OnSourceNetHandledListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.4
            public static final int REPORT_HTTP_DNS_INTERRUPT = -2;
            public static final int REPORT_HTTP_DNS_PV = 0;
            private boolean mIsPauseLoad = false;

            private void checkErrorCode(int i2, int i3, Bundle bundle2) {
                if (bundle2 == null) {
                    return;
                }
                int i4 = bundle2.getInt("retry_counter");
                MgtvMediaPlayer.this.mSourceRetryCount = i4;
                MgtvMediaPlayer.this.mSourceRetryCode = i3;
                if (MgtvMediaPlayer.this.isDnsCacheEnable() && i4 >= 1 && MgtvMediaPlayer.this.checkAndCleanDnsCache(i2, i3)) {
                    MgtvMediaPlayer.this.mHttpDnsEnable = true;
                }
            }

            private boolean didHDJSwitch(Bundle bundle2) {
                if (MgtvMediaPlayer.this.mHDJSwitchUrl.length() <= 0 || bundle2 == null) {
                    return false;
                }
                bundle2.putString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_URL_STRING, MgtvMediaPlayer.this.mHDJSwitchUrl);
                bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_IS_LAST_INT, 1);
                MgtvMediaPlayer.this.mHDJSwitchUrl = "";
                return true;
            }

            private void didHostAddr(Bundle bundle2) {
                if (bundle2 == null) {
                    return;
                }
                int i2 = bundle2.getInt("host_error");
                int i3 = bundle2.getInt("host_family");
                String string = bundle2.getString("host_hostname");
                String string2 = bundle2.getString("host_ip");
                int i4 = bundle2.getInt("host_port");
                int i5 = MgtvMediaPlayer.this.mLastDnsType = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_HOST_ARRR_DNS_TYPE_INT);
                DebugLog.d(MgtvMediaPlayer.this.getLogTag(), "callback didHostAddr error:" + i2 + ",family:" + i3 + ",hostname:" + string + ",ip_list:" + string2 + ",port:" + i4 + ",hostDnsType:" + i5);
                MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                StringBuilder sb = new StringBuilder();
                sb.append(i2);
                sb.append("");
                mgtvMediaPlayer.mLastHostErr = sb.toString();
                MgtvMediaPlayer.this.mLastIpIndex = 0;
                try {
                    String[] split = string2.split(g.b);
                    MgtvMediaPlayer.this.mLastIpCount = 0;
                    if (split != null) {
                        for (String str : split) {
                            if (c.a.a.a.k.d.b(str)) {
                                MgtvMediaPlayer.access$4108(MgtvMediaPlayer.this);
                            }
                        }
                    }
                    MgtvMediaPlayer.this.mLastIps = split;
                    if (!MgtvMediaPlayer.this.mEnableJAVAIPCacheMap || i2 != 0 || MgtvMediaPlayer.this.mIPCacheMap.containsKey(string) || split == null || split.length <= 0) {
                        return;
                    }
                    IPList iPList = new IPList(string, split);
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "callback ipcache didHostAddr put:" + string + "-" + IPList.formatIPList(iPList.nUseList));
                    MgtvMediaPlayer.this.mIPCacheMap.put(string, iPList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private boolean didLiveOpen(Bundle bundle2) {
                if (bundle2 == null) {
                    return false;
                }
                return onLiveWillOpen(bundle2);
            }

            private boolean didLiveReopen(Bundle bundle2) {
                boolean z = MgtvMediaPlayer.this.mLiveReopen;
                if (MgtvMediaPlayer.this.mLiveReopen) {
                    MgtvMediaPlayer.this.mLiveReopen = false;
                }
                return z;
            }

            private boolean didLoopOpen(Bundle bundle2) {
                if (bundle2 == null) {
                    return false;
                }
                return onLiveWillOpen(bundle2);
            }

            private boolean didLoopReopen(Bundle bundle2) {
                if (MgtvMediaPlayer.this.mLoopPlayerSwitchUrl.length() > 0) {
                    bundle2.putString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_URL_STRING, MgtvMediaPlayer.this.mLoopPlayerSwitchUrl);
                    MgtvMediaPlayer.this.mLoopPlayerSwitchUrl = "";
                    return true;
                }
                return false;
            }

            private void didTcpOpen(Bundle bundle2) {
                IPList iPList;
                if (bundle2 == null) {
                    return;
                }
                int i2 = bundle2.getInt("port");
                int i3 = bundle2.getInt("family");
                int i4 = bundle2.getInt("error");
                String string = bundle2.getString("ip");
                String string2 = bundle2.getString("tcp_hostname");
                long j = bundle2.getLong("switch_key");
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.i(logTag, "didTcpOpen switch_key:" + j);
                if (MgtvMediaPlayer.this.mMediaPlayer != null && MgtvMediaPlayer.this.mMediaPlayer.s() != null) {
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.i(logTag2, "didTcpOpen origin:" + MgtvMediaPlayer.this.mMediaPlayer.s());
                }
                String logTag3 = MgtvMediaPlayer.this.getLogTag();
                if (i4 != 0) {
                    DebugLog.e(logTag3, "chodison didTcpOpen port:" + i2 + ",family:" + i3 + ",error_code:" + i4 + ",ip:" + string + ",hostname:" + string2);
                } else {
                    DebugLog.i(logTag3, "chodison didTcpOpen port:" + i2 + ",family:" + i3 + ",ip:" + string + ",hostname:" + string2);
                }
                MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                mgtvMediaPlayer.mLastTcpErr = i4 + "";
                MgtvMediaPlayer.this.mLastTcpIP = string;
                MgtvMediaPlayer.access$2808(MgtvMediaPlayer.this);
                if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap) {
                    try {
                        if (!MgtvMediaPlayer.this.mIPCacheMap.containsKey(string2) || (iPList = (IPList) MgtvMediaPlayer.this.mIPCacheMap.get(string2)) == null) {
                            return;
                        }
                        String logTag4 = MgtvMediaPlayer.this.getLogTag();
                        DebugLog.i(logTag4, "callback ipcache didTcpOpen remove " + string + " from " + string2);
                        iPList.nUseList.remove(string);
                        String logTag5 = MgtvMediaPlayer.this.getLogTag();
                        DebugLog.i(logTag5, "callback ipcache didTcpOpen rest ip:" + IPList.formatIPList(iPList.nUseList));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            private boolean doNetHttpWillOpenFailed(int i2, int i3, Bundle bundle2) {
                boolean z;
                List<String> list;
                String logTag;
                String str;
                checkErrorCode(i2, i3, bundle2);
                MgtvMediaPlayer.this.mErrorUrl = UrlUtil.getValidUrl(bundle2.getString("url"));
                int i4 = bundle2.getInt("cur_dl_dize");
                if (isInitMp4(MgtvMediaPlayer.this.mErrorUrl)) {
                    MgtvMediaPlayer.this.mIsInitMp4Error = true;
                } else {
                    MgtvMediaPlayer.this.mIsInitMp4Error = false;
                }
                int i5 = bundle2.getInt("retry_counter");
                if (UrlUtil.isFilePrefix(MgtvMediaPlayer.this.mErrorUrl) && !MgtvMediaPlayer.this.mCacheReplaceMap.isEmpty()) {
                    if (MgtvMediaPlayer.this.mOnWarningListener != null) {
                        MgtvPlayerListener.OnWarningListener onWarningListener = MgtvMediaPlayer.this.mOnWarningListener;
                        onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_TS_CACHE_SKIP, i3 + "", MgtvMediaPlayer.this.mErrorUrl, null);
                    }
                    String str2 = (String) MgtvMediaPlayer.this.mCacheReplaceMap.get(MgtvMediaPlayer.this.mErrorUrl);
                    if (str2 != null) {
                        MgtvMediaPlayer.access$7308(MgtvMediaPlayer.this);
                        MgtvMediaPlayer.this.mErrorUrl = str2;
                        bundle2.putString("url", str2);
                        String logTag2 = MgtvMediaPlayer.this.getLogTag();
                        DebugLog.i(logTag2, "doNetHttpWillOpenFailed replace local_url to " + str2);
                    }
                }
                bundle2.getString("player_hash");
                int i6 = bundle2.getInt("io_type");
                c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed url:%s,iotype:%d, RetryCount:%d,error_code:%d-%d", new Object[]{MgtvMediaPlayer.this.mErrorUrl, Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3)});
                if (isENETUNREACHcode(i2, i3) || (MgtvMediaPlayer.this.mPrepared && isDnsError(i2, i3))) {
                    c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed network broken,RetryCount:%d,error_code:%d-%d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3)});
                    return true;
                }
                synchronized (MgtvMediaPlayer.this.mDnsNoNetWaiter) {
                    if (!isPlayerReset() && MgtvMediaPlayer.this.mEnableDnsNoNetStrategy && isDnsError(i2, i3)) {
                        boolean d = c.a.a.b.d.d.d(MgtvMediaPlayer.this.mContext);
                        if (!d) {
                            DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 1000 in");
                            try {
                                MgtvMediaPlayer.this.mDnsNoNetWaiter.wait(1000L);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            logTag = MgtvMediaPlayer.this.getLogTag();
                            str = "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 1000 out";
                            DebugLog.i(logTag, str);
                            z = true;
                        } else if (!d || MgtvMediaPlayer.this.mLastIsNetworkAvailableNNS) {
                            z = false;
                        } else {
                            DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 3000 in");
                            try {
                                MgtvMediaPlayer.this.mDnsNoNetWaiter.wait(PayTask.j);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            logTag = MgtvMediaPlayer.this.getLogTag();
                            str = "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 3000 out";
                            DebugLog.i(logTag, str);
                            z = true;
                        }
                        MgtvMediaPlayer.this.mLastIsNetworkAvailableNNS = d;
                    } else {
                        z = false;
                    }
                }
                String logTag3 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.i(logTag3, "doNetHttpWillOpenFailed mIsLive:" + MgtvMediaPlayer.this.mIsLive + ",mPlayerMode:" + MgtvMediaPlayer.this.mPlayerMode + ",mPrepared:" + MgtvMediaPlayer.this.mPrepared + ",mIsBuffering:" + MgtvMediaPlayer.this.mIsBuffering + ",mTsNotSkip:" + MgtvMediaPlayer.this.mTsNotSkip + ",mLoadMaxRetryTime:" + MgtvMediaPlayer.this.mLoadMaxRetryTime + ",mPlayStatus:" + MgtvMediaPlayer.this.mPlayStatus + ",lip:" + MgtvMediaPlayer.this.getLastIP());
                DebugLog.ifmt(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed %d-%d-%d-%d-%s", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i2), Integer.valueOf(i3), MgtvMediaPlayer.this.mErrorUrl);
                if ((!MgtvMediaPlayer.this.mIsLive || MgtvMediaPlayer.this.isVod()) && MgtvMediaPlayer.this.mPlayerMode != 1) {
                    if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap && (i3 == 100911 || i3 == 300021 || CodeUtil.isHttp4XX(i2, i3) || CodeUtil.isHttp5XX(i2, i3))) {
                        String hostName = UrlUtil.getHostName(UrlUtil.getValidHttpUrl(bundle2.getString("url")));
                        if (!StringUtil.isEmpty(hostName) && !c.a.a.a.k.d.g(hostName) && MgtvMediaPlayer.this.mIPCacheMap.containsKey(hostName)) {
                            String logTag4 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag4, "callback ipcache will http contains host:" + hostName);
                            IPList iPList = (IPList) MgtvMediaPlayer.this.mIPCacheMap.get(hostName);
                            if (iPList != null && iPList.checkTTL() && (list = iPList.nUseList) != null && list.size() > 0) {
                                String logTag5 = MgtvMediaPlayer.this.getLogTag();
                                DebugLog.i(logTag5, "callback ipcache will http check ttl success." + iPList);
                                if (i5 >= 6) {
                                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "callback ipcache will http return false.not retry");
                                    reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                                    return false;
                                }
                                bundle2.putString("user_msg", MgtvMediaPlayer.USER_MSG_FLAG_USE_CACHE);
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "callback ipcache will http return true.try to goto ip choose");
                                reportHttpErrorPV(i5, MgtvMediaPlayer.this.mErrorUrl, i3, "ipcache");
                                return true;
                            }
                        }
                    }
                    reportHttpErrorPV(i5, MgtvMediaPlayer.this.mErrorUrl, i3, MgtvMediaPlayer.DEFAULT_CACHE_REPORT_TAG);
                    if (z) {
                        if (i5 < MgtvMediaPlayer.this.mDnsNoNetMaxRetry) {
                            DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy retry cause by inDnsNetStrategy");
                            return true;
                        }
                        reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy skip retry cause by errorRetryCount >= mDnsNoNetMaxRetry");
                        return false;
                    } else if (!MgtvMediaPlayer.this.mPrepared) {
                        if (UrlUtil.isM3u8(MgtvMediaPlayer.this.mErrorUrl)) {
                            if (i5 >= 2) {
                                reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                                return false;
                            }
                            return true;
                        } else if (MgtvMediaPlayer.this.isSkipRetryCode(i2, i3) || !isInitMp4(MgtvMediaPlayer.this.mErrorUrl) || i4 <= 0 || i5 >= 10) {
                            if (MgtvMediaPlayer.this.isSkipRetryCode(i2, i3) || i5 >= MgtvMediaPlayer.this.mLoadMaxRetryTime) {
                                MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                                mgtvMediaPlayer.callbackTsSkip(mgtvMediaPlayer.mErrorUrl, i2, i3);
                                reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                                return false;
                            }
                            return true;
                        } else {
                            return true;
                        }
                    } else if (MgtvMediaPlayer.this.mTsNotSkip && MgtvMediaPlayer.this.isRendered()) {
                        return true;
                    }
                } else if (!MgtvMediaPlayer.this.mPrepared) {
                    if (UrlUtil.isM3u8(MgtvMediaPlayer.this.mErrorUrl)) {
                        return i5 < 2;
                    }
                    MgtvMediaPlayer mgtvMediaPlayer2 = MgtvMediaPlayer.this;
                    mgtvMediaPlayer2.callbackTsSkip(mgtvMediaPlayer2.mErrorUrl, i2, i3);
                    return false;
                } else if (MgtvMediaPlayer.this.mIsBuffering && MgtvMediaPlayer.this.isHLSPlayingUrl() && i5 >= 1) {
                    if (UrlUtil.isSegment(MgtvMediaPlayer.this.mErrorUrl)) {
                        MgtvMediaPlayer mgtvMediaPlayer3 = MgtvMediaPlayer.this;
                        mgtvMediaPlayer3.callbackTsSkip(mgtvMediaPlayer3.mErrorUrl, i2, i3);
                    }
                    return false;
                }
                if (MgtvMediaPlayer.this.isSkipRetryCode(i2, i3) || i5 >= 2) {
                    if (UrlUtil.isSegment(MgtvMediaPlayer.this.mErrorUrl)) {
                        MgtvMediaPlayer mgtvMediaPlayer4 = MgtvMediaPlayer.this;
                        mgtvMediaPlayer4.callbackTsSkip(mgtvMediaPlayer4.mErrorUrl, i2, i3);
                    }
                    reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                    return false;
                }
                return true;
            }

            private boolean doNewHttpWillOpen(Bundle bundle2) {
                int i2 = bundle2.getInt("error_type");
                int i3 = bundle2.getInt("error_code");
                bundle2.getInt("retry_counter");
                int i4 = bundle2.getInt("reset_iplist");
                MgtvMediaPlayer.this.mLastDlSize = bundle2.getInt("cur_dl_dize");
                bundle2.putString("user_msg", "init");
                if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap && i4 == 1) {
                    MgtvMediaPlayer.this.clearIPCache();
                }
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag, "doNewHttpWillOpen in error_what:" + i2 + ",error_extra:" + i3 + ",reset_iplist:" + i4 + ",mLastDlSize:" + MgtvMediaPlayer.this.mLastDlSize);
                bundle2.putInt("reset_iplist", 0);
                if (i3 == 0) {
                    MgtvMediaPlayer.this.mIsInitMp4Error = false;
                    if (i3 == 0 && MgtvMediaPlayer.this.mCacheEable) {
                        replaceUrlFromCache(bundle2);
                    }
                    return false;
                }
                boolean doNetHttpWillOpenFailed = doNetHttpWillOpenFailed(i2, i3, bundle2);
                String logTag2 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag2, "doNetHttpWillOpenFailed return " + doNetHttpWillOpenFailed + "," + i2 + "-" + i3 + "-" + MgtvMediaPlayer.this.mErrorUrl);
                return doNetHttpWillOpenFailed;
            }

            private boolean doWillGetEnv(Bundle bundle2) {
                String string = bundle2.getString("env_key");
                if (string == null || string.length() <= 0) {
                    return false;
                }
                bundle2.putString("env_value", System.getenv(string));
                return true;
            }

            private boolean doWillHostAddr(Bundle bundle2) {
                List<String> list;
                if (bundle2 == null) {
                    return false;
                }
                int i2 = bundle2.getInt("addr_handle");
                String string = bundle2.getString("player_hash");
                int i3 = bundle2.getInt("retry_counter");
                String string2 = bundle2.getString("user_msg");
                String string3 = bundle2.getString("addr_hostname");
                long j = bundle2.getLong("switch_key");
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag, "callback doWillHostAddr is_handle:" + i2 + ",hash:" + string + ",count_int:" + i3 + ",user_msg:" + string2 + ",hostname:" + string3 + ",switch_key:" + j);
                if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap && i2 != 1 && MgtvMediaPlayer.USER_MSG_FLAG_USE_CACHE.equals(string2) && !c.a.a.a.k.d.g(string3) && MgtvMediaPlayer.this.mIPCacheMap.containsKey(string3)) {
                    try {
                        IPList iPList = (IPList) MgtvMediaPlayer.this.mIPCacheMap.get(string3);
                        if (iPList != null && (list = iPList.nUseList) != null && list.size() > 0 && iPList.checkTTL()) {
                            String str = iPList.nUseList.get(0);
                            if (c.a.a.a.k.d.b(str)) {
                                String logTag2 = MgtvMediaPlayer.this.getLogTag();
                                DebugLog.i(logTag2, "callback ipcache doWillHostAddr put chooseip:" + str);
                                String formatIPList = IPList.formatIPList(iPList.nUseList);
                                if (!StringUtil.isEmpty(formatIPList)) {
                                    String logTag3 = MgtvMediaPlayer.this.getLogTag();
                                    DebugLog.d(logTag3, "callback ipcache doWillHostAddr put srcIPListStr:" + formatIPList);
                                    bundle2.putString("addr_hostname", formatIPList);
                                }
                                bundle2.putString("addr_ip", str);
                                bundle2.putInt("addr_error", 0);
                                return false;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                String string4 = bundle2.getString("addr_uri");
                if (c.a.a.a.k.d.f(string3)) {
                    String E = MgtvMediaPlayer.this.mReporter != null ? MgtvMediaPlayer.this.mReporter.E() : "0";
                    notifyIpIsLAN(E, "hostname_" + string3);
                }
                boolean g = c.a.a.a.k.d.g(string3);
                boolean d = c.a.a.b.d.d.d(MgtvMediaPlayer.this.mContext);
                String logTag4 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag4, "doWillHostAddr hostname:" + string3 + ",isIp:" + g);
                String logTag5 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag5, "doWillHostAddr is_handle=" + i2 + ",mBackJavaDns=" + MgtvMediaPlayer.this.mBackJavaDns + ",isIp=" + g + ",mForceHttpDns:" + MgtvMediaPlayer.this.mForceHttpDns);
                if ((MgtvMediaPlayer.this.mForceHttpDns && !g) || ((MgtvMediaPlayer.this.mJavaDnsEnable && !g) || (i2 == 1 && MgtvMediaPlayer.this.mBackJavaDns && !g))) {
                    if (d) {
                        MgtvMediaPlayer.this.mLastUri = string4;
                        domainResolve(string3, bundle2, MgtvMediaPlayer.this.mForceHttpDns);
                    } else {
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "skip domainResolve cause net not available");
                    }
                    return MgtvMediaPlayer.this.mPlayerReset;
                }
                if (i2 == 1 && g) {
                    bundle2.putString("addr_ip", string3);
                    bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CTRL_ARRR_DNS_TYPE_INT, 0);
                    bundle2.putInt("addr_error", 0);
                }
                return false;
            }

            private boolean doWillHttpOpen(Bundle bundle2) {
                if (bundle2 != null) {
                    MgtvMediaPlayer.this.mLastRequestUrl = UrlUtil.getValidUrl(bundle2.getString("url"));
                }
                if (MgtvMediaPlayer.this.mReportParams == null || !(MgtvMediaPlayer.this.mReportParams.getVideoType().equals(ReportParams.VideoType.AD_PRE) || MgtvMediaPlayer.this.mReportParams.getVideoType().equals(ReportParams.VideoType.AD_MID))) {
                    if (bundle2 != null) {
                        MgtvMediaPlayer.this.mWillOpenUrl = bundle2.getString("url");
                    }
                    return doNewHttpWillOpen(bundle2);
                }
                return onNormalHttpWillOpen(bundle2);
            }

            private void domainResolve(String str, Bundle bundle2, boolean z) {
                a.d c;
                int k;
                if (str == null || bundle2 == null) {
                    DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "skip domainResolve hostname or args is null");
                    return;
                }
                a aVar = new a();
                aVar.d(new a.c() { // from class: com.hunantv.media.player.MgtvMediaPlayer.4.1
                    public void onDnsFail(a aVar2) {
                    }

                    public void onDnsFinish(a aVar2) {
                        synchronized (MgtvMediaPlayer.this.mDnsLock) {
                            MgtvMediaPlayer.this.mDnsLock.notifyAll();
                        }
                    }

                    public void onDnsStart(a aVar2) {
                    }

                    public void onDnsSuc(a aVar2, String[] strArr) {
                    }
                });
                boolean resolveStrategy = resolveStrategy(aVar, str, bundle2, z, MgtvMediaPlayer.this.mHttpDnsNeedRetry);
                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve use:" + resolveStrategy);
                if (resolveStrategy) {
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve use type:" + aVar.c());
                    notifyHttpDnsReport(aVar.c(), MainNotifyHandler.MSG_HTTPDNS_REPORT_PV, 0);
                }
                synchronized (MgtvMediaPlayer.this.mDnsLock) {
                    while (aVar.n() && !isJavaDnsInterrupt()) {
                        DebugLog.d(MgtvMediaPlayer.this.getLogTag(), "domainResolve wait in");
                        try {
                            MgtvMediaPlayer.this.mDnsLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                DebugLog.d(MgtvMediaPlayer.this.getLogTag(), "domainResolve wait out. resolving:" + aVar.n() + ",isJavaDnsInterrupt:" + isJavaDnsInterrupt());
                String[] c2 = c.a.a.a.k.d.c(aVar.m());
                aVar.o();
                String str2 = "costMs:" + aVar.i() + ";ips:" + com.hunantv.media.utils.StringUtil.formatArrayString(c2) + ";net:" + NetPlayConfig.getNetworkType() + g.b;
                String formatIPList = IPList.formatIPList(c2);
                String str3 = null;
                if (c2 != null && c2.length > 0) {
                    str3 = c2[0];
                }
                int i2 = AnonymousClass28.$SwitchMap$com$hunantv$media$player$dns$AsyncDns$DnsType[aVar.c().ordinal()] == 1 ? 4 : 5;
                if (!isJavaDnsInterrupt() && c.a.a.a.k.d.b(str3)) {
                    if (resolveStrategy) {
                        updateCurrentDnsDsc(aVar.c());
                        if (c.a.a.a.k.d.f(str3)) {
                            notifyHttpDnsReport(aVar.c(), 2001, 100, str2);
                        } else {
                            notifyHttpDnsReport(aVar.c(), 2001, 0, str2);
                        }
                    }
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve put iplist:" + formatIPList);
                    bundle2.putString("addr_hostname", formatIPList);
                    if (c.a.a.a.k.d.b(str3)) {
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve put firstIP:" + str3);
                        bundle2.putString("addr_ip", str3);
                    }
                    bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CTRL_ARRR_DNS_TYPE_INT, i2);
                    bundle2.putInt("addr_error", 0);
                    return;
                }
                if (resolveStrategy) {
                    if (isJavaDnsInterrupt() && aVar.k() == 0) {
                        c = aVar.c();
                        k = -2;
                    } else {
                        c = aVar.c();
                        k = aVar.k();
                    }
                    notifyHttpDnsReport(c, 2002, k, str2);
                    if (!isJavaDnsInterrupt()) {
                        int a = aVar.a((int) Opcodes.IFNONNULL);
                        if (aVar.k() != 0) {
                            a = aVar.k();
                        } else if (str3 != null && !c.a.a.a.k.d.g(str3)) {
                            a = aVar.a(107);
                        }
                        int i3 = -a;
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), aVar.c() + "resolve putInt error:" + i3);
                        bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CTRL_ARRR_DNS_TYPE_INT, i2);
                        bundle2.putInt("addr_error", i3);
                    }
                }
                MgtvMediaPlayer.this.mCurrentDnsDsc = "native";
            }

            private String findTsCachPath(String str, String[] strArr) {
                if (strArr == null) {
                    return null;
                }
                try {
                    String fileName = UrlUtil.getFileName(str);
                    for (String str2 : strArr) {
                        if (str2 != null && new File(str2).getName().equals(fileName)) {
                            return str2;
                        }
                    }
                } catch (Exception unused) {
                }
                return null;
            }

            private boolean isDnsError(int i2, int i3) {
                return i3 == 300600 || i2 == 400605 || MGTVP2pDirectMediaDataSource.isP2pDirectDnsError(i2, i3);
            }

            private boolean isENETUNREACHcode(int i2, int i3) {
                return i3 == 300005 || MGTVP2pDirectMediaDataSource.getShortErrorCode(i2, i3) == 101;
            }

            private boolean isInitMp4(String str) {
                return MgtvMediaPlayer.this.isHLSPlayingUrl() && UrlUtil.isSuffixUrl(str, ".mp4");
            }

            private boolean isJavaDnsInterrupt() {
                return isPlayerReset();
            }

            private boolean isPlayerReset() {
                return MgtvMediaPlayer.this.mPlayerReset || (MgtvMediaPlayer.this.mPlayerMode == 2 && MgtvMediaPlayer.this.mLoopPlayerReset);
            }

            private void notifyHttpDnsReport(a.d dVar, int i2, int i3) {
                notifyHttpDnsReport(dVar, i2, i3, "");
            }

            private void notifyHttpDnsReport(a.d dVar, int i2, int i3, String str) {
                if (dVar != a.d.b || MgtvMediaPlayer.this.mOnWarningListener == null) {
                    return;
                }
                notifyMessage(i2, i3, str);
            }

            private void notifyIpIsLAN(String str, String str2) {
                if (MgtvMediaPlayer.this.mOnWarningListener == null || MgtvMediaPlayer.this.mReportParams == null || MgtvMediaPlayer.this.mReportParams.getVideoType() != ReportParams.VideoType.VOD) {
                    return;
                }
                if (!MgtvMediaPlayer.this.mReportedTSLAN) {
                    notifyMessage(1002, str, str2 + "_suffix_" + UrlUtil.getSuffix(MgtvMediaPlayer.this.mWillOpenUrl));
                }
                if (UrlUtil.isM3u8(MgtvMediaPlayer.this.mWillOpenUrl)) {
                    return;
                }
                MgtvMediaPlayer.this.mReportedTSLAN = true;
            }

            private void notifyMessage(int i2, int i3, String str) {
                Message message = new Message();
                message.what = i2;
                message.arg1 = i3;
                message.obj = str;
                MgtvMediaPlayer.this.mNotifyHandler.sendMessage(message);
            }

            private void notifyMessage(int i2, String str, String str2) {
                Message message = new Message();
                message.what = i2;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MainNotifyHandler.BUNDLE_STR_INFO1, str);
                bundle2.putString(MainNotifyHandler.BUNDLE_STR_INFO2, str2);
                message.setData(bundle2);
                MgtvMediaPlayer.this.mNotifyHandler.sendMessage(message);
            }

            private boolean onLiveWillOpen(Bundle bundle2) {
                int i2 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_ERROR_WHAT_INT);
                int i3 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_ERROR_EXTRA_INT);
                MgtvMediaPlayer.this.mLastRequestUrl = UrlUtil.getValidUrl(bundle2.getString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_SRC_URL_STRING));
                if (i3 != 0) {
                    MgtvMediaPlayer.this.mErrorUrl = UrlUtil.getValidUrl(bundle2.getString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_SRC_URL_STRING));
                    int i4 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_COUNTER_INT);
                    int i5 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_ERR_IO_TYPE_INT);
                    c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLiveWillOpen url:%s,iotype:%d, RetryCount:%d,error_code:%d-%d", new Object[]{MgtvMediaPlayer.this.mErrorUrl, Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3)});
                    if (isENETUNREACHcode(i2, i3) || (MgtvMediaPlayer.this.mPrepared && isDnsError(i2, i3))) {
                        c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLiveWillOpen network broken,RetryCount:%d,error_code:%d-%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3)});
                        return true;
                    }
                    DebugLog.ifmt(MgtvMediaPlayer.this.getLogTag(), "OnSourceNetHandledListener.CTRL_WILL_LIVE_OPEN %d-%d-%d-%d-%s", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), MgtvMediaPlayer.this.mErrorUrl);
                    return !MgtvMediaPlayer.this.isSkipRetryCode(i2, i3) && i4 < 2;
                }
                return false;
            }

            private boolean onLoopWillOpen(Bundle bundle2) {
                int i2 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_ERROR_WHAT_INT);
                int i3 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_ERROR_EXTRA_INT);
                if (i3 != 0) {
                    MgtvMediaPlayer.this.mErrorUrl = UrlUtil.getValidUrl(bundle2.getString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_SRC_URL_STRING));
                    int i4 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_COUNTER_INT);
                    int i5 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_ERR_IO_TYPE_INT);
                    c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLoopWillOpen url:%s,iotype:%d, RetryCount:%d,error_code:%d-%d", new Object[]{MgtvMediaPlayer.this.mErrorUrl, Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3)});
                    if (isENETUNREACHcode(i2, i3) || (MgtvMediaPlayer.this.mPrepared && isDnsError(i2, i3))) {
                        c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLoopWillOpen network broken,RetryCount:%d,error_code:%d-%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3)});
                        return true;
                    }
                    DebugLog.ifmt(MgtvMediaPlayer.this.getLogTag(), "OnSourceNetHandledListener.CTRL_WILL_LOOP_OPEN %d-%d-%d-%d-%s", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), MgtvMediaPlayer.this.mErrorUrl);
                    return !MgtvMediaPlayer.this.isSkipRetryCode(i2, i3) && i4 < 2;
                }
                return false;
            }

            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private boolean onNormalHttpWillOpen(android.os.Bundle r15) {
                /*
                    Method dump skipped, instructions count: 329
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.player.MgtvMediaPlayer.AnonymousClass4.onNormalHttpWillOpen(android.os.Bundle):boolean");
            }

            private boolean replaceUrlFromCache(Bundle bundle2) {
                String string = bundle2.getString("url");
                if (!UrlUtil.isFilePrefix(string) && !UrlUtil.isLocal(string)) {
                    String str = null;
                    String fileName = UrlUtil.getFileName(string);
                    if (StringUtil.isEmpty(fileName)) {
                        return false;
                    }
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.d(logTag, "replaceUrlFromCache try to find replace cache:" + string);
                    if (UrlUtil.isM3u8(string)) {
                        String str2 = MgtvMediaPlayer.this.mCacheM3u8Path;
                        String fileName2 = UrlUtil.getFileName(str2);
                        if (!StringUtil.isEmpty(str2) && !StringUtil.isEmpty(fileName2) && fileName2.equals(fileName)) {
                            str = str2;
                        }
                    } else if (MgtvMediaPlayer.this.isHLSPlayingUrl() && UrlUtil.isSegment(string)) {
                        str = findTsCachPath(string, MgtvMediaPlayer.this.mCacheTsPaths);
                    }
                    if (FileUtil.exist(str)) {
                        String addLocalPrefix = UrlUtil.addLocalPrefix(str);
                        if (!StringUtil.isEmpty(addLocalPrefix)) {
                            String logTag2 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag2, "replaceUrlFromCache from " + string);
                            String logTag3 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag3, "replaceUrlFromCache to " + addLocalPrefix);
                            bundle2.putString("url", addLocalPrefix);
                            if (UrlUtil.isM3u8(string)) {
                                String logTag4 = MgtvMediaPlayer.this.getLogTag();
                                DebugLog.d(logTag4, "replaceUrlFromCache put SRC_URL " + string);
                                bundle2.putString("src_url", string);
                            }
                            MgtvMediaPlayer.this.mCacheReplaceMap.put(addLocalPrefix, string);
                            return true;
                        }
                    }
                }
                return false;
            }

            private void reportHttpErrorErr(int i2, String str) {
                if ((isInitMp4(str) || UrlUtil.isM3u8(str)) && MgtvMediaPlayer.this.mReportParams != null && MgtvMediaPlayer.this.mReportParams.getVideoType() == ReportParams.VideoType.VOD && MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.NO_PROXY && MgtvMediaPlayer.this.mOnWarningListener != null) {
                    String E = MgtvMediaPlayer.this.mReporter != null ? MgtvMediaPlayer.this.mReporter.E() : MLog.a.b;
                    MgtvPlayerListener.OnWarningListener onWarningListener = MgtvMediaPlayer.this.mOnWarningListener;
                    String str2 = i2 + Consts.DOT + MgtvMediaPlayer.this.mCacheReportLerr;
                    StringBuilder sb = new StringBuilder();
                    sb.append("psuuid_");
                    sb.append(E);
                    sb.append("_render_");
                    sb.append(MgtvMediaPlayer.this.isRendered() ? "1" : "0");
                    sb.append("_url_");
                    sb.append(str);
                    sb.append("_type_");
                    sb.append(MgtvMediaPlayer.this.mCacheReportTag);
                    onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_HTTP_ERROR_ERR, str2, sb.toString(), null);
                }
            }

            private void reportHttpErrorPV(int i2, String str, int i3, String str2) {
                if (i2 == 0) {
                    MgtvMediaPlayer.this.mCacheReportTag = MgtvMediaPlayer.DEFAULT_CACHE_REPORT_TAG;
                    MgtvMediaPlayer.this.mCacheReportLerr = 0;
                }
                if (i2 == 0) {
                    if ((isInitMp4(str) || UrlUtil.isM3u8(str)) && MgtvMediaPlayer.this.mReportParams != null && MgtvMediaPlayer.this.mReportParams.getVideoType() == ReportParams.VideoType.VOD && MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.NO_PROXY && MgtvMediaPlayer.this.mOnWarningListener != null) {
                        String E = MgtvMediaPlayer.this.mReporter != null ? MgtvMediaPlayer.this.mReporter.E() : MLog.a.b;
                        MgtvMediaPlayer.this.mCacheReportTag = str2;
                        MgtvMediaPlayer.this.mCacheReportLerr = i3;
                        MgtvPlayerListener.OnWarningListener onWarningListener = MgtvMediaPlayer.this.mOnWarningListener;
                        String str3 = i3 + "";
                        StringBuilder sb = new StringBuilder();
                        sb.append("psuuid_");
                        sb.append(E);
                        sb.append("_render_");
                        sb.append(MgtvMediaPlayer.this.isRendered() ? "1" : "0");
                        sb.append("_url_");
                        sb.append(str);
                        sb.append("_type_");
                        sb.append(str2);
                        onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_HTTP_ERROR_PV, str3, sb.toString(), null);
                    }
                }
            }

            private boolean resolveStrategy(@NonNull a aVar, @NonNull String str, Bundle bundle2) {
                return resolveStrategy(aVar, str, bundle2, false, false);
            }

            private boolean resolveStrategy(@NonNull a aVar, @NonNull String str, Bundle bundle2, boolean z, boolean z2) {
                a.d dVar;
                String logTag;
                String str2;
                if (z || (bundle2 != null && bundle2.getInt("addr_handle") == 1 && MgtvMediaPlayer.this.mBackJavaDns)) {
                    aVar.j(1);
                    dVar = a.d.b;
                } else {
                    if (MgtvMediaPlayer.this.isDnsCacheEnable()) {
                        if (MgtvMediaPlayer.this.mHttpDnsEnable) {
                            String a = StringUtil.isEmpty(MgtvMediaPlayer.this.mLastUri) ? null : c.a.a.a.k.e.a(MgtvMediaPlayer.this.mLastUri);
                            if (a != null && !a.trim().equals("")) {
                                logTag = MgtvMediaPlayer.this.getLogTag();
                                str2 = "resolveStrategy cache valid";
                            }
                        } else {
                            logTag = MgtvMediaPlayer.this.getLogTag();
                            str2 = "resolveStrategy cache valid and httpdns not open";
                        }
                        DebugLog.d(logTag, str2);
                        return false;
                    }
                    dVar = MgtvMediaPlayer.this.mJavaDnsType;
                }
                aVar.e(str, dVar, z2);
                return true;
            }

            private void updateCurrentDnsDsc(a.d dVar) {
                MgtvMediaPlayer mgtvMediaPlayer;
                String str;
                int i2 = AnonymousClass28.$SwitchMap$com$hunantv$media$player$dns$AsyncDns$DnsType[dVar.ordinal()];
                if (i2 == 1) {
                    mgtvMediaPlayer = MgtvMediaPlayer.this;
                    str = MgtvMediaPlayer.DNS_JAVA_NORMAL;
                } else if (i2 != 2) {
                    return;
                } else {
                    mgtvMediaPlayer = MgtvMediaPlayer.this;
                    str = MgtvMediaPlayer.DNS_JAVA_HTTPDNS;
                }
                mgtvMediaPlayer.mCurrentDnsDsc = str;
            }

            private void updateIp(String str) {
                String logTag;
                StringBuilder sb;
                String str2;
                if (MgtvMediaPlayer.this.mMediaPlayer == null || (!(MgtvMediaPlayer.this.mMediaPlayer.v() == 2 || MgtvMediaPlayer.this.mMediaPlayer.v() == 1) || MgtvMediaPlayer.this.mMediaPlayer.o4() == null)) {
                    if (MgtvMediaPlayer.this.mMediaPlayer == null || !((MgtvMediaPlayer.this.mMediaPlayer.v() == 2 || MgtvMediaPlayer.this.mMediaPlayer.v() == 1) && MgtvMediaPlayer.this.mMediaPlayer.o4() == null)) {
                        MgtvMediaPlayer.this.mLastIP = str;
                    } else {
                        MgtvMediaPlayer.this.mLastIP = "0.0.0.1";
                    }
                    logTag = MgtvMediaPlayer.this.getLogTag();
                    sb = new StringBuilder();
                    str2 = "didTcpOpen tcp_ip:";
                } else {
                    MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                    mgtvMediaPlayer.mLastIP = P2pMgr.getCdnIpFromP2PTask(mgtvMediaPlayer.mMediaPlayer.o4());
                    logTag = MgtvMediaPlayer.this.getLogTag();
                    sb = new StringBuilder();
                    str2 = "didTcpOpen p2p QueryTaskInfo cdnIp:";
                }
                sb.append(str2);
                sb.append(MgtvMediaPlayer.this.mLastIP);
                DebugLog.d(logTag, sb.toString());
            }

            private void willTcpOpen(Bundle bundle2) {
                if (bundle2 == null) {
                    return;
                }
                String string = bundle2.getString("tcp_hostname");
                String string2 = bundle2.getString("ip");
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag, "callback willTcpOpen tcp_hostname:" + string + ",tcp_ip:" + string2);
                MgtvMediaPlayer.this.mLastHostIP = string2;
                updateIp(string2);
                if (string2 == null || string2.length() <= 1 || !c.a.a.a.k.d.f(string2)) {
                    return;
                }
                notifyIpIsLAN("1", MgtvMediaPlayer.this.getCurrentDnsDsc() + "_hostip_" + string2);
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSourceNetHandledListener
            public boolean onSourceNetCtrl(int i2, Bundle bundle2) {
                IP2pTask o4;
                c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "OnSourceNetHandledListener.onSourceNetCtrl 0x%5x", new Object[]{Integer.valueOf(i2)});
                switch (i2) {
                    case 131073:
                        willTcpOpen(bundle2);
                        break;
                    case 131074:
                        didTcpOpen(bundle2);
                        break;
                    case 131075:
                        return doWillHttpOpen(bundle2);
                    case 131077:
                        return didLiveOpen(bundle2);
                    case 131078:
                        return doWillHostAddr(bundle2);
                    case 131081:
                        return didLiveReopen(bundle2);
                    case 131088:
                        return didLoopOpen(bundle2);
                    case 131089:
                        return didLoopReopen(bundle2);
                    case 131090:
                        return didHDJSwitch(bundle2);
                    case 131104:
                        return doWillGetEnv(bundle2);
                    case 131120:
                        if (MgtvMediaPlayer.this.mPreBufferState.isEnable() && MgtvMediaPlayer.this.mPreBufferState.getState() == 2) {
                            this.mIsPauseLoad = true;
                            return true;
                        } else if (MgtvMediaPlayer.this.isSourceSwitching() || MgtvMediaPlayer.this.mMediaPlayer == null || (!(MgtvMediaPlayer.this.mMediaPlayer.v() == 2 || MgtvMediaPlayer.this.mMediaPlayer.v() == 1) || (o4 = MgtvMediaPlayer.this.mMediaPlayer.o4()) == null || o4.getStatus() == 0)) {
                            if (this.mIsPauseLoad) {
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "CTRL_WILL_CHECK_PAUSE_LOAD will return false. will resume load");
                            }
                            this.mIsPauseLoad = false;
                            return false;
                        } else {
                            if (!this.mIsPauseLoad) {
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "CTRL_WILL_CHECK_PAUSE_LOAD will return true. will pause load");
                            }
                            this.mIsPauseLoad = true;
                            return true;
                        }
                    case 131184:
                        synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                            if (bundle2 == null) {
                                break;
                            } else if (bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_NEED_RETRY_INT) == 1) {
                                if (MgtvMediaPlayer.this.mReporter != null) {
                                    MgtvMediaPlayer.this.mReporter.M();
                                }
                                int i3 = (int) bundle2.getLong(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_RETRY_KEY_LONG);
                                SmoothMediaSource smoothMediaSource = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i3));
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth need_retry == 1 find:" + i3);
                                if (smoothMediaSource != null) {
                                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth need_retry == 1 , will retry use :" + smoothMediaSource.getUrl());
                                    bundle2.putString("smooth_switch_url", smoothMediaSource.getUrl());
                                    if (smoothMediaSource.getReporter() != null) {
                                        smoothMediaSource.getReporter().H();
                                        if (MgtvMediaPlayer.this.mReportParams != null) {
                                            MgtvMediaPlayer.this.mReportParams.setPlaySessionId(smoothMediaSource.getReporter().E());
                                        }
                                    }
                                } else {
                                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth need_retry == 1, not found source");
                                }
                                bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_NEED_RETRY_INT, 0);
                                return true;
                            } else {
                                int i4 = (int) bundle2.getLong("smooth_switch_key");
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth CTRL_WILL_SMOOTH_SWITCH switch_key:" + i4);
                                SmoothMediaSource matchLastKeySource = MgtvMediaPlayer.this.matchLastKeySource(i4);
                                if (matchLastKeySource != null) {
                                    if (matchLastKeySource.isLastRetry() && MgtvMediaPlayer.this.mReportParams != null && (MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.ONLY_P2P || MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.P2P_DRM)) {
                                        SmoothMediaSource smoothMediaSource2 = new SmoothMediaSource(MgtvMediaPlayer.this.getPlayingOriginUrl());
                                        smoothMediaSource2.setReportParams(MgtvMediaPlayer.this.mReportParams);
                                        smoothMediaSource2.bind(MgtvMediaPlayer.this);
                                        smoothMediaSource2.setThrowErrorIfSwitchFailed(true);
                                        MgtvMediaPlayer.this.mSmoothSourcesRecord.put(Integer.valueOf(smoothMediaSource2.getKey()), smoothMediaSource2);
                                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth is last retry. will retry key:" + smoothMediaSource2.getKey());
                                        bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_NEED_RETRY_INT, 1);
                                        bundle2.putLong(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_RETRY_KEY_LONG, smoothMediaSource2.getKey());
                                    }
                                    if (!matchLastKeySource.isLastRetry()) {
                                        String string = bundle2.getString("smooth_switch_url");
                                        bundle2.putString("smooth_switch_url", string);
                                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth CTRL_WILL_SMOOTH_SWITCH switch_url:" + string);
                                        if (!StringUtil.isEmpty(string)) {
                                            int indexOf = string.indexOf(",mgtvjsource:");
                                            String substring = indexOf >= 0 ? string.substring(indexOf) : "";
                                            boolean onSwitchSmoothSourceWillUpdate = MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener != null ? MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener.onSwitchSmoothSourceWillUpdate(matchLastKeySource) : false;
                                            if (matchLastKeySource.getReadType() != 2 && onSwitchSmoothSourceWillUpdate && !StringUtil.isEmpty(matchLastKeySource.useUpdateUrl())) {
                                                String str = matchLastKeySource.useUpdateUrl() + substring;
                                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth CTRL_WILL_SMOOTH_SWITCH will update url:" + str);
                                                bundle2.putString("smooth_switch_url", str);
                                            }
                                        }
                                    }
                                }
                                SmoothMediaSource smoothMediaSource3 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i4));
                                if (smoothMediaSource3 != null && smoothMediaSource3.getReporter() != null) {
                                    smoothMediaSource3.getReporter().H();
                                    if (MgtvMediaPlayer.this.mReportParams != null) {
                                        MgtvMediaPlayer.this.mReportParams.setPlaySessionId(smoothMediaSource3.getReporter().E());
                                    }
                                }
                                return true;
                            }
                        }
                        break;
                }
                return false;
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSourceNetHandledListener
            public void onSourceNetEvent(int i2, Bundle bundle2) {
                if (i2 != 78338) {
                    return;
                }
                didHostAddr(bundle2);
            }
        };
        this.mLogTagKey = "";
        this.mEnableReport = true;
        this.p2pLocker = new Object();
        this.mSeekStartMs = -1L;
        this.mHw2SwType = Hw2SwType.NONE;
        this.mPlaybackSpeed = 1.0f;
        this.mRecordMaxPlaySpeed = 1.0f;
        this.mFrameListener = new MgtvPlayerListener.OnFrameListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.22
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnFrameListener
            public void onVFrameClockCome(MgtvPlayerListener.FrameClock frameClock) {
                synchronized (MgtvMediaPlayer.this.ptsLocker) {
                    WeakHandler weakHandler = MgtvMediaPlayer.this.ptsWeakHandler;
                    if (weakHandler != null) {
                        weakHandler.removeMessages(256);
                        Message message = new Message();
                        message.what = 256;
                        message.obj = frameClock;
                        MgtvMediaPlayer.this.ptsWeakHandler.sendMessage(message);
                    }
                    if (MgtvMediaPlayer.this.mOnFrameListener != null) {
                        MgtvMediaPlayer.this.mOnFrameListener.onVFrameClockCome(frameClock);
                    }
                }
            }
        };
        this.mInnerFlowDataStatistic = new FlowDataStatistic();
        this.mEnableImgoVsr = false;
        this.mLoopSourceKey = new AtomicInteger(1);
        this.mSubtitleSources = new ArrayList();
        this.ptsHandlerThread = null;
        this.ptsWeakHandler = null;
        this.ptsListeners = new HashSet();
        this.ptsLocker = new Object();
        this.mSmoothSourceListener = new d.n() { // from class: com.hunantv.media.player.MgtvMediaPlayer.26
            public int lastSwitchingKey = -1;

            public void onSmoothSwitchSourceComplete(d dVar, int i2, int i3, String str) {
                SmoothMediaSource smoothMediaSource;
                synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.d(logTag, "onSmoothSwitchSourceComplete (type:" + i3 + ",key:" + i2 + ",msg:" + str + ")");
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSmoothSwitchSourceComplete current: ");
                    sb.append(MgtvMediaPlayer.this.getCurrentSmoothSourceKey());
                    DebugLog.i(logTag2, sb.toString());
                    for (Map.Entry entry : MgtvMediaPlayer.this.mSmoothSourcesRecord.entrySet()) {
                        if (((Integer) entry.getKey()).intValue() < i2 && (smoothMediaSource = (SmoothMediaSource) entry.getValue()) != null && !smoothMediaSource.isReleased()) {
                            smoothMediaSource.release();
                        }
                    }
                    MgtvMediaPlayer.this.mSmoothUseP2pFailed = false;
                    if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                        MgtvMediaPlayer.this.mMediaPlayer.k2(false);
                    }
                    SmoothMediaSource smoothMediaSource2 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i2));
                    if (smoothMediaSource2 != null) {
                        if (!StringUtil.isEmpty(smoothMediaSource2.getVfps())) {
                            MgtvMediaPlayer.this.mRecordVfps = Float.parseFloat(smoothMediaSource2.getVfps());
                        }
                        MgtvMediaPlayer.this.mLastVideoWidth = smoothMediaSource2.getVideoWidth();
                        MgtvMediaPlayer.this.mLastVideoHeight = smoothMediaSource2.getVideoHeight();
                        if (MgtvMediaPlayer.this.mReporter != null) {
                            MgtvMediaPlayer.this.mReporter.M();
                        }
                        MgtvMediaPlayer.this.mReporter = smoothMediaSource2.getReporter();
                        if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                            MgtvMediaPlayer.this.mMediaPlayer.o0(MgtvMediaPlayer.this.mReporter);
                            MgtvMediaPlayer.this.mMediaPlayer.A0(smoothMediaSource2.getReadType(), smoothMediaSource2.getUrl(), smoothMediaSource2.getPlayingUrl());
                            MgtvMediaPlayer.this.mMediaPlayer.N1(smoothMediaSource2.getEnableImgoAIQE());
                        }
                        if (MgtvMediaPlayer.this.mDataSourceInfo != null) {
                            MgtvMediaPlayer.this.mDataSourceInfo.setVideoFormat(smoothMediaSource2.getVideoFormat());
                            MgtvMediaPlayer.this.mDataSourceInfo.setAudioFormat(smoothMediaSource2.getAudioFormat());
                            MgtvMediaPlayer.this.mDataSourceInfo.setFileFormat(smoothMediaSource2.getFileFormat());
                        }
                        if (MgtvMediaPlayer.this.mReporter != null) {
                            MgtvMediaPlayer.this.mReportParams.deepCopy(smoothMediaSource2.getReportParams());
                            MgtvMediaPlayer.this.mReporter.n(MgtvMediaPlayer.this.mReportParams);
                            MgtvMediaPlayer.this.mReporter.N();
                        }
                        String keyFrameMapKey = MgtvMediaPlayer.this.getKeyFrameMapKey(smoothMediaSource2.getVid(), smoothMediaSource2.getDef());
                        if (MgtvMediaPlayer.this.mSmoothKeyFrameMap.containsKey(keyFrameMapKey)) {
                            String logTag3 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag3, "find smoothKeyFrameKey :" + keyFrameMapKey + " set to player");
                            byte[] bArr = MgtvMediaPlayer.this.mSmoothKeyFrameMap.get(keyFrameMapKey);
                            if (KeyFrameInfoUtils.isKeyFrameDataValid(bArr, smoothMediaSource2.videoFileHash) == 0) {
                                MgtvMediaPlayer.this.setKeyFrameInfoFileBuf(bArr);
                            }
                        }
                    }
                    SmoothMediaSource matchLastKeySource = MgtvMediaPlayer.this.matchLastKeySource(i2);
                    if (matchLastKeySource == null) {
                        DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "onSmoothSwitchSourceComplete matchKeySource failed");
                        return;
                    }
                    if (matchLastKeySource.getSwitchMod() == 1) {
                        MgtvMediaPlayer.this.mMediaPlayer.w2(true);
                    }
                    MgtvMediaPlayer.this.mSwitchedSmoothSource = matchLastKeySource;
                    MgtvMediaPlayer.this.mSourceSwitchingComplete = true;
                    MgtvMediaPlayer.this.mSourceSwitching = false;
                    if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                        MgtvMediaPlayer.this.mMainFlowReportProcessor = matchLastKeySource.getFlowReportProcessor();
                        MgtvMediaPlayer.this.mMediaPlayer.L0(matchLastKeySource.getP2pTask());
                        MgtvMediaPlayer.this.mMediaPlayer.j3(matchLastKeySource.getReadType());
                    }
                    MgtvMediaPlayer.this.mSmoothKeyFrameMap.clear();
                    if (MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener != null) {
                        MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener.onSwitchSmoothSourceSuccess(matchLastKeySource);
                    }
                }
            }

            public void onSmoothSwitchSourceFailed(d dVar, int i2, int i3, String str) {
                String[] split;
                synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.e(logTag, "onSmoothSwitchSourceFailed (type:" + i3 + ",key:" + i2 + ",msg:" + str + ")");
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSmoothSwitchSourceFailed current: ");
                    sb.append(MgtvMediaPlayer.this.getCurrentSmoothSourceKey());
                    DebugLog.e(logTag2, sb.toString());
                    int i4 = MgtvMediaPlayer.WHAT_SMOOTHSOURCE_FAIL;
                    int i5 = -1;
                    try {
                        if (!StringUtil.isEmpty(str) && (split = str.split("-")) != null && split.length >= 2) {
                            i4 = NumericUtil.parseInt(split[0]);
                            i5 = NumericUtil.parseInt(split[1]);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    SmoothMediaSource smoothMediaSource = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i2));
                    if (smoothMediaSource != null) {
                        if (smoothMediaSource.getReporter() != null) {
                            smoothMediaSource.getReporter().l(i4, i5, "");
                        }
                        if (MgtvMediaPlayer.this.mReportParams != null) {
                            String logTag3 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag3, "onSmoothSwitchSourceFailed mReportParams:" + MgtvMediaPlayer.this.mReportParams.getProxyType() + "-" + MgtvMediaPlayer.this.mReportParams.getP2ps());
                        }
                        if (smoothMediaSource.getReportParams() != null) {
                            String logTag4 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag4, "onSmoothSwitchSourceFailed currentSource.getReportParams():" + smoothMediaSource.getReportParams().getProxyType() + "-" + smoothMediaSource.getReportParams().getP2ps());
                        }
                        if (MgtvMediaPlayer.this.mReportParams != null && MgtvMediaPlayer.this.mReportParams.isP2p() && smoothMediaSource.getReportParams() != null && smoothMediaSource.getReportParams().isP2p()) {
                            MgtvMediaPlayer.this.mSmoothUseP2pFailed = true;
                            if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                                MgtvMediaPlayer.this.mMediaPlayer.k2(true);
                            }
                        }
                        if (smoothMediaSource.isThrowErrorIfSwitchFailed()) {
                            MgtvMediaPlayer.this.mErrorListener.onError(MgtvMediaPlayer.WHAT_SMOOTHSOURCE_EX_ERROR, i5);
                            return;
                        }
                    }
                    if (i3 == 1) {
                        MgtvMediaPlayer.this.mErrorListener.onError(i4, i5);
                        return;
                    }
                    SmoothMediaSource matchLastKeySource = MgtvMediaPlayer.this.matchLastKeySource(i2);
                    if (matchLastKeySource == null) {
                        DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "onSmoothSwitchSourceFailed matchKeySource failed");
                    } else {
                        MgtvMediaPlayer.this.notifySwitchSmoothSourceFail(matchLastKeySource, i4, i5);
                    }
                }
            }

            public void onSmoothSwitchSourceInfo(d dVar, int i2, int i3, String str) {
                synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.i(logTag, "onSmoothSwitchSourceInfo (event:" + i3 + ",key:" + i2 + ",msg:" + str + ")");
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSmoothSwitchSourceInfo current: ");
                    sb.append(MgtvMediaPlayer.this.getCurrentSmoothSourceKey());
                    DebugLog.i(logTag2, sb.toString());
                    SmoothMediaSource smoothMediaSource = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i2));
                    if (smoothMediaSource != null) {
                        if (i3 == 0) {
                            smoothMediaSource.s_event_0_timestamp = System.currentTimeMillis();
                        } else if (i3 == 11) {
                            smoothMediaSource.s_event_11_timestamp = System.currentTimeMillis();
                        } else if (i3 == 2) {
                            if (MgtvMediaPlayer.this.isFlowReportEnable) {
                                smoothMediaSource.genFlowReporter();
                            }
                            smoothMediaSource.s_event_2_timestamp = System.currentTimeMillis();
                        } else if (i3 == 3) {
                            if (MgtvMediaPlayer.this.isFlowReportEnable && MgtvMediaPlayer.this.mMainFlowReportProcessor != null) {
                                MgtvMediaPlayer.this.mMainFlowReportProcessor.stop();
                            }
                            for (Map.Entry entry : MgtvMediaPlayer.this.mSmoothSourcesRecord.entrySet()) {
                                if (((Integer) entry.getKey()).intValue() < smoothMediaSource.getKey()) {
                                    SmoothMediaSource smoothMediaSource2 = (SmoothMediaSource) entry.getValue();
                                    if (MgtvMediaPlayer.this.isFlowReportEnable && smoothMediaSource2 != null && smoothMediaSource2.getFlowReportProcessor() != null) {
                                        smoothMediaSource2.getFlowReportProcessor().stop();
                                    }
                                }
                            }
                            smoothMediaSource.s_event_3_timestamp = System.currentTimeMillis();
                        }
                    }
                    if (i3 != 3) {
                        if (MgtvMediaPlayer.this.matchLastKeySource(i2) == null) {
                            DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "onSmoothSwitchSourceInfo matchKeySource failed");
                            return;
                        }
                        if (i3 == 0) {
                            MgtvMediaPlayer.this.mSourceSwitching = true;
                        }
                        return;
                    }
                    SmoothMediaSource smoothMediaSource3 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(this.lastSwitchingKey));
                    if (smoothMediaSource3 != null && smoothMediaSource3.getReporter() != null) {
                        smoothMediaSource3.getReporter().M();
                    }
                    this.lastSwitchingKey = i2;
                    SmoothMediaSource smoothMediaSource4 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i2));
                    if (smoothMediaSource4 != null && MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener != null) {
                        MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener.onSwitchSmoothSourceInfo(smoothMediaSource4, i3);
                    }
                }
            }
        };
        this.mSmoothSourcesRecord = new HashMap();
        this.mSwitchSmoothSourceLocker = new Object();
        this.mSmoothUseP2pFailed = false;
        this.mSmoothKeyFrameMap = Collections.synchronizedMap(new HashMap());
        this.isBackground = false;
        this.isSpaceAudioSwitchOn = false;
        this.mBundle = bundle;
        extractBundleData();
        init(i, context);
    }

    public MgtvMediaPlayer(int i, Context context, boolean z) throws UnsatisfiedLinkError, SecurityException, NullPointerException {
        this.mDebug = false;
        this.mPreBufferTimeoutMs = 1800000;
        this.mBufferTimeoutMs = 180000;
        this.mImgoMediaPlayerAudioMode = false;
        this.mAccurateSeekEnable = true;
        this.mAccSeekKeyFrameInterval = 1000;
        this.mKeyframeSeekEnable = false;
        this.mInnerAutoRotateEnable = false;
        this.mWeakBufferSpeedKB = 1;
        this.mWeakBufferTimeoutMs = 120000;
        this.mTsNotSkip = false;
        this.mLoadMaxRetryTime = 2;
        this.mPrepared = false;
        this.mIsBuffering = false;
        this.mErrorUrl = "";
        this.mLastRequestUrl = "";
        this.mLastDlSize = 0;
        this.mIsLive = false;
        this.mPlayerMode = 0;
        this.mLiveReopen = false;
        this.mLoopPlayerSwitchUrl = "";
        this.mHDJSwitchUrl = "";
        this.mDataSourceType = DataSourceType.TYPE_DATASOUCE_DEFAULT;
        this.mErrorExtraCodeStore = -1;
        this.mRecordVfps = 0.0f;
        this.mLastVideoWidth = 0;
        this.mLastVideoHeight = 0;
        this.mSkipLoopFilterType = SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mAddrinfoType = AddrinfoType.TYPE_ADDRINFO_DEFAULT;
        this.mAddrinfoTimeoutMs = 0;
        this.mPrepared4StartMode = Prepared4StartMode.MODE_PREPARED4START_DEFAULT;
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.2
            private boolean needInnerRetry(int i2, int i3) {
                return !MgtvMediaPlayer.this.mIsInnerRetrying && MgtvMediaPlayer.this.mMediaPlayer.b4() == 2 && i2 == 200003 && i3 == 100606;
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i2, int i3) {
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.i(logTag, "onError what:" + i2 + ",extra:" + i3 + ",netType:" + NetPlayConfig.getNetworkType());
                if (MgtvMediaPlayer.this.mGifRecorder != null) {
                    MgtvMediaPlayer.this.mGifRecorder.interrupt(101);
                }
                if (MgtvMediaPlayer.this.isDnsCacheEnable()) {
                    MgtvMediaPlayer.this.checkAndCleanDnsCache(i2, i3);
                }
                if (needInnerRetry(i2, i3)) {
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "onError needInnerRetry");
                    MgtvMediaPlayer.this.mIsInnerRetrying = true;
                    MgtvMediaPlayer.this.mRetryLastErrorCode = i3;
                    MgtvMediaPlayer.this.setPlayerReset(true);
                    if (MgtvMediaPlayer.this.mMediaPlayer.b0()) {
                        MgtvMediaPlayer.this.mMediaPlayer.v1(MgtvMediaPlayer.this.mMediaPlayer.t(), i2, i3, MgtvMediaPlayer.this.mMediaPlayer.b4());
                    } else {
                        MgtvMediaPlayer.this.mMediaPlayer.u1(MgtvMediaPlayer.this.mMediaPlayer.t(), i2, i3);
                    }
                    return true;
                }
                MgtvMediaPlayer.this.beforeThrowError(i2, i3);
                MgtvMediaPlayer.this.reportErrorWarning(i2, i3);
                if (i2 != 7000006) {
                    MgtvMediaPlayer.this.reportError(i2, i3, "");
                }
                MgtvMediaPlayer.this.stopTickers();
                MgtvMediaPlayer.this.mPlayStatus = PlayStatus.ERROR;
                MgtvMediaPlayer.this.mErrorExtraCodeStore = i3;
                if (MgtvMediaPlayer.this.mOnErrorListener != null) {
                    return MgtvMediaPlayer.this.mOnErrorListener.onError(i2, i3);
                }
                return true;
            }
        };
        this.mIsGetPositionCallback = false;
        this.mPlayStatus = PlayStatus.IDLE;
        this.mRenderType = RenderType.NATIVE_WINDOW;
        this.mPlayTicker = new ExTicker(1000).setTypeStr("play");
        this.mBufferTick = new ExTicker(1000).setTypeStr("buffer");
        this.mPlayerType = 2;
        this.mMainThreadID = -1L;
        this.mCacheReplaceMap = new LinkedHashMap();
        this.mIsInnerRetrying = false;
        this.mRetryLastErrorCode = 0;
        this.mRenderDisableWarnSended = false;
        this.mForceHttpDns = false;
        this.mHttpDnsNeedRetry = false;
        this.mJavaDnsEnable = false;
        this.mJavaDnsType = a.d.b;
        this.mHttpDnsEnable = false;
        this.mPlayerReset = true;
        this.mLoopPlayerReset = true;
        this.mLastUri = null;
        this.mLastHostErr = MLog.a.b;
        this.mLastTcpErr = MLog.a.b;
        this.mLastIpCount = 0;
        this.mLastIpIndex = -1;
        this.mLastDnsType = -1;
        this.mCurrentDnsDsc = "native";
        this.mEnableP2PHttpDns = false;
        this.mForceP2pHttpDns = false;
        this.mDnsThreadManager = new c().b(new c.c() { // from class: com.hunantv.media.player.MgtvMediaPlayer.3
            public void updateIPs(String str, List<String> list) {
                P2pMgr.YfAddBackupIps(str, list, MgtvMediaPlayer.this.mForceP2pHttpDns);
            }
        });
        this.mAVSyncErrReported = false;
        this.mAVSyncErrSumReported = false;
        this.mAVSyncErrSum = 0;
        this.mAVSyncStartTimestamp = 0L;
        this.mPrepareAsyncTimeStampMs = 0L;
        this.mPreBufferState = new SyncStateMachine(1);
        this.mPreBufferMaxS = 5;
        this.mIsAudioExist = -1;
        this.mIsVsrOpen = -1;
        this.mIsNativePausedLoadData = 0;
        this.mIsWanosAudioEffectValid = false;
        this.mLastPosition = 0;
        this.mPositionLoged = false;
        this.mRealEncodeType = -1;
        this.mStreamFormatType = -1;
        this.mNotifyHandler = new MainNotifyHandler(this);
        this.mWillOpenUrl = "";
        this.mReportedTSLAN = false;
        this.mDnsLock = new Object();
        this.mIsP2pTSSkipReport = false;
        this.mCodecName = "n";
        this.mVVbuft = -1;
        this.mEnableJAVAIPCacheMap = false;
        this.mIPCacheMap = new HashMap();
        this.mVideoFrameClockNotifyMs = -1;
        this.mVideoFrameClockNotifyType = -1;
        this.mVideoFrameClockNotifyTimeStart = -1L;
        this.mVideoFrameClockNotifyTimeEnd = -1L;
        this.mCacheReportTag = DEFAULT_CACHE_REPORT_TAG;
        this.mCacheReportLerr = 0;
        this.mEnableDnsNoNetStrategy = false;
        this.mDnsNoNetWaiter = new Object();
        this.mLastIsNetworkAvailableNNS = true;
        this.mDnsNoNetMaxRetry = 20;
        this.mLastTsSkipErrExtra = 0;
        this.fstime = "n/n";
        this.mcColorFormat = "n_n";
        this.isFlowReportEnable = false;
        this.vsri = "0|0_0|0_0";
        this.vsrver = "n";
        this.vsrvkver = "n";
        this.vsrnpuver = "n";
        this.mSourceNetListner = new MgtvPlayerListener.OnSourceNetHandledListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.4
            public static final int REPORT_HTTP_DNS_INTERRUPT = -2;
            public static final int REPORT_HTTP_DNS_PV = 0;
            private boolean mIsPauseLoad = false;

            private void checkErrorCode(int i2, int i3, Bundle bundle2) {
                if (bundle2 == null) {
                    return;
                }
                int i4 = bundle2.getInt("retry_counter");
                MgtvMediaPlayer.this.mSourceRetryCount = i4;
                MgtvMediaPlayer.this.mSourceRetryCode = i3;
                if (MgtvMediaPlayer.this.isDnsCacheEnable() && i4 >= 1 && MgtvMediaPlayer.this.checkAndCleanDnsCache(i2, i3)) {
                    MgtvMediaPlayer.this.mHttpDnsEnable = true;
                }
            }

            private boolean didHDJSwitch(Bundle bundle2) {
                if (MgtvMediaPlayer.this.mHDJSwitchUrl.length() <= 0 || bundle2 == null) {
                    return false;
                }
                bundle2.putString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_URL_STRING, MgtvMediaPlayer.this.mHDJSwitchUrl);
                bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_IS_LAST_INT, 1);
                MgtvMediaPlayer.this.mHDJSwitchUrl = "";
                return true;
            }

            private void didHostAddr(Bundle bundle2) {
                if (bundle2 == null) {
                    return;
                }
                int i2 = bundle2.getInt("host_error");
                int i3 = bundle2.getInt("host_family");
                String string = bundle2.getString("host_hostname");
                String string2 = bundle2.getString("host_ip");
                int i4 = bundle2.getInt("host_port");
                int i5 = MgtvMediaPlayer.this.mLastDnsType = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_HOST_ARRR_DNS_TYPE_INT);
                DebugLog.d(MgtvMediaPlayer.this.getLogTag(), "callback didHostAddr error:" + i2 + ",family:" + i3 + ",hostname:" + string + ",ip_list:" + string2 + ",port:" + i4 + ",hostDnsType:" + i5);
                MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                StringBuilder sb = new StringBuilder();
                sb.append(i2);
                sb.append("");
                mgtvMediaPlayer.mLastHostErr = sb.toString();
                MgtvMediaPlayer.this.mLastIpIndex = 0;
                try {
                    String[] split = string2.split(g.b);
                    MgtvMediaPlayer.this.mLastIpCount = 0;
                    if (split != null) {
                        for (String str : split) {
                            if (c.a.a.a.k.d.b(str)) {
                                MgtvMediaPlayer.access$4108(MgtvMediaPlayer.this);
                            }
                        }
                    }
                    MgtvMediaPlayer.this.mLastIps = split;
                    if (!MgtvMediaPlayer.this.mEnableJAVAIPCacheMap || i2 != 0 || MgtvMediaPlayer.this.mIPCacheMap.containsKey(string) || split == null || split.length <= 0) {
                        return;
                    }
                    IPList iPList = new IPList(string, split);
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "callback ipcache didHostAddr put:" + string + "-" + IPList.formatIPList(iPList.nUseList));
                    MgtvMediaPlayer.this.mIPCacheMap.put(string, iPList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private boolean didLiveOpen(Bundle bundle2) {
                if (bundle2 == null) {
                    return false;
                }
                return onLiveWillOpen(bundle2);
            }

            private boolean didLiveReopen(Bundle bundle2) {
                boolean z2 = MgtvMediaPlayer.this.mLiveReopen;
                if (MgtvMediaPlayer.this.mLiveReopen) {
                    MgtvMediaPlayer.this.mLiveReopen = false;
                }
                return z2;
            }

            private boolean didLoopOpen(Bundle bundle2) {
                if (bundle2 == null) {
                    return false;
                }
                return onLiveWillOpen(bundle2);
            }

            private boolean didLoopReopen(Bundle bundle2) {
                if (MgtvMediaPlayer.this.mLoopPlayerSwitchUrl.length() > 0) {
                    bundle2.putString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_URL_STRING, MgtvMediaPlayer.this.mLoopPlayerSwitchUrl);
                    MgtvMediaPlayer.this.mLoopPlayerSwitchUrl = "";
                    return true;
                }
                return false;
            }

            private void didTcpOpen(Bundle bundle2) {
                IPList iPList;
                if (bundle2 == null) {
                    return;
                }
                int i2 = bundle2.getInt("port");
                int i3 = bundle2.getInt("family");
                int i4 = bundle2.getInt("error");
                String string = bundle2.getString("ip");
                String string2 = bundle2.getString("tcp_hostname");
                long j = bundle2.getLong("switch_key");
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.i(logTag, "didTcpOpen switch_key:" + j);
                if (MgtvMediaPlayer.this.mMediaPlayer != null && MgtvMediaPlayer.this.mMediaPlayer.s() != null) {
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.i(logTag2, "didTcpOpen origin:" + MgtvMediaPlayer.this.mMediaPlayer.s());
                }
                String logTag3 = MgtvMediaPlayer.this.getLogTag();
                if (i4 != 0) {
                    DebugLog.e(logTag3, "chodison didTcpOpen port:" + i2 + ",family:" + i3 + ",error_code:" + i4 + ",ip:" + string + ",hostname:" + string2);
                } else {
                    DebugLog.i(logTag3, "chodison didTcpOpen port:" + i2 + ",family:" + i3 + ",ip:" + string + ",hostname:" + string2);
                }
                MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                mgtvMediaPlayer.mLastTcpErr = i4 + "";
                MgtvMediaPlayer.this.mLastTcpIP = string;
                MgtvMediaPlayer.access$2808(MgtvMediaPlayer.this);
                if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap) {
                    try {
                        if (!MgtvMediaPlayer.this.mIPCacheMap.containsKey(string2) || (iPList = (IPList) MgtvMediaPlayer.this.mIPCacheMap.get(string2)) == null) {
                            return;
                        }
                        String logTag4 = MgtvMediaPlayer.this.getLogTag();
                        DebugLog.i(logTag4, "callback ipcache didTcpOpen remove " + string + " from " + string2);
                        iPList.nUseList.remove(string);
                        String logTag5 = MgtvMediaPlayer.this.getLogTag();
                        DebugLog.i(logTag5, "callback ipcache didTcpOpen rest ip:" + IPList.formatIPList(iPList.nUseList));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            private boolean doNetHttpWillOpenFailed(int i2, int i3, Bundle bundle2) {
                boolean z2;
                List<String> list;
                String logTag;
                String str;
                checkErrorCode(i2, i3, bundle2);
                MgtvMediaPlayer.this.mErrorUrl = UrlUtil.getValidUrl(bundle2.getString("url"));
                int i4 = bundle2.getInt("cur_dl_dize");
                if (isInitMp4(MgtvMediaPlayer.this.mErrorUrl)) {
                    MgtvMediaPlayer.this.mIsInitMp4Error = true;
                } else {
                    MgtvMediaPlayer.this.mIsInitMp4Error = false;
                }
                int i5 = bundle2.getInt("retry_counter");
                if (UrlUtil.isFilePrefix(MgtvMediaPlayer.this.mErrorUrl) && !MgtvMediaPlayer.this.mCacheReplaceMap.isEmpty()) {
                    if (MgtvMediaPlayer.this.mOnWarningListener != null) {
                        MgtvPlayerListener.OnWarningListener onWarningListener = MgtvMediaPlayer.this.mOnWarningListener;
                        onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_TS_CACHE_SKIP, i3 + "", MgtvMediaPlayer.this.mErrorUrl, null);
                    }
                    String str2 = (String) MgtvMediaPlayer.this.mCacheReplaceMap.get(MgtvMediaPlayer.this.mErrorUrl);
                    if (str2 != null) {
                        MgtvMediaPlayer.access$7308(MgtvMediaPlayer.this);
                        MgtvMediaPlayer.this.mErrorUrl = str2;
                        bundle2.putString("url", str2);
                        String logTag2 = MgtvMediaPlayer.this.getLogTag();
                        DebugLog.i(logTag2, "doNetHttpWillOpenFailed replace local_url to " + str2);
                    }
                }
                bundle2.getString("player_hash");
                int i6 = bundle2.getInt("io_type");
                c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed url:%s,iotype:%d, RetryCount:%d,error_code:%d-%d", new Object[]{MgtvMediaPlayer.this.mErrorUrl, Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3)});
                if (isENETUNREACHcode(i2, i3) || (MgtvMediaPlayer.this.mPrepared && isDnsError(i2, i3))) {
                    c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed network broken,RetryCount:%d,error_code:%d-%d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3)});
                    return true;
                }
                synchronized (MgtvMediaPlayer.this.mDnsNoNetWaiter) {
                    if (!isPlayerReset() && MgtvMediaPlayer.this.mEnableDnsNoNetStrategy && isDnsError(i2, i3)) {
                        boolean d = c.a.a.b.d.d.d(MgtvMediaPlayer.this.mContext);
                        if (!d) {
                            DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 1000 in");
                            try {
                                MgtvMediaPlayer.this.mDnsNoNetWaiter.wait(1000L);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            logTag = MgtvMediaPlayer.this.getLogTag();
                            str = "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 1000 out";
                            DebugLog.i(logTag, str);
                            z2 = true;
                        } else if (!d || MgtvMediaPlayer.this.mLastIsNetworkAvailableNNS) {
                            z2 = false;
                        } else {
                            DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 3000 in");
                            try {
                                MgtvMediaPlayer.this.mDnsNoNetWaiter.wait(PayTask.j);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            logTag = MgtvMediaPlayer.this.getLogTag();
                            str = "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 3000 out";
                            DebugLog.i(logTag, str);
                            z2 = true;
                        }
                        MgtvMediaPlayer.this.mLastIsNetworkAvailableNNS = d;
                    } else {
                        z2 = false;
                    }
                }
                String logTag3 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.i(logTag3, "doNetHttpWillOpenFailed mIsLive:" + MgtvMediaPlayer.this.mIsLive + ",mPlayerMode:" + MgtvMediaPlayer.this.mPlayerMode + ",mPrepared:" + MgtvMediaPlayer.this.mPrepared + ",mIsBuffering:" + MgtvMediaPlayer.this.mIsBuffering + ",mTsNotSkip:" + MgtvMediaPlayer.this.mTsNotSkip + ",mLoadMaxRetryTime:" + MgtvMediaPlayer.this.mLoadMaxRetryTime + ",mPlayStatus:" + MgtvMediaPlayer.this.mPlayStatus + ",lip:" + MgtvMediaPlayer.this.getLastIP());
                DebugLog.ifmt(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed %d-%d-%d-%d-%s", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i2), Integer.valueOf(i3), MgtvMediaPlayer.this.mErrorUrl);
                if ((!MgtvMediaPlayer.this.mIsLive || MgtvMediaPlayer.this.isVod()) && MgtvMediaPlayer.this.mPlayerMode != 1) {
                    if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap && (i3 == 100911 || i3 == 300021 || CodeUtil.isHttp4XX(i2, i3) || CodeUtil.isHttp5XX(i2, i3))) {
                        String hostName = UrlUtil.getHostName(UrlUtil.getValidHttpUrl(bundle2.getString("url")));
                        if (!StringUtil.isEmpty(hostName) && !c.a.a.a.k.d.g(hostName) && MgtvMediaPlayer.this.mIPCacheMap.containsKey(hostName)) {
                            String logTag4 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag4, "callback ipcache will http contains host:" + hostName);
                            IPList iPList = (IPList) MgtvMediaPlayer.this.mIPCacheMap.get(hostName);
                            if (iPList != null && iPList.checkTTL() && (list = iPList.nUseList) != null && list.size() > 0) {
                                String logTag5 = MgtvMediaPlayer.this.getLogTag();
                                DebugLog.i(logTag5, "callback ipcache will http check ttl success." + iPList);
                                if (i5 >= 6) {
                                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "callback ipcache will http return false.not retry");
                                    reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                                    return false;
                                }
                                bundle2.putString("user_msg", MgtvMediaPlayer.USER_MSG_FLAG_USE_CACHE);
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "callback ipcache will http return true.try to goto ip choose");
                                reportHttpErrorPV(i5, MgtvMediaPlayer.this.mErrorUrl, i3, "ipcache");
                                return true;
                            }
                        }
                    }
                    reportHttpErrorPV(i5, MgtvMediaPlayer.this.mErrorUrl, i3, MgtvMediaPlayer.DEFAULT_CACHE_REPORT_TAG);
                    if (z2) {
                        if (i5 < MgtvMediaPlayer.this.mDnsNoNetMaxRetry) {
                            DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy retry cause by inDnsNetStrategy");
                            return true;
                        }
                        reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy skip retry cause by errorRetryCount >= mDnsNoNetMaxRetry");
                        return false;
                    } else if (!MgtvMediaPlayer.this.mPrepared) {
                        if (UrlUtil.isM3u8(MgtvMediaPlayer.this.mErrorUrl)) {
                            if (i5 >= 2) {
                                reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                                return false;
                            }
                            return true;
                        } else if (MgtvMediaPlayer.this.isSkipRetryCode(i2, i3) || !isInitMp4(MgtvMediaPlayer.this.mErrorUrl) || i4 <= 0 || i5 >= 10) {
                            if (MgtvMediaPlayer.this.isSkipRetryCode(i2, i3) || i5 >= MgtvMediaPlayer.this.mLoadMaxRetryTime) {
                                MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                                mgtvMediaPlayer.callbackTsSkip(mgtvMediaPlayer.mErrorUrl, i2, i3);
                                reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                                return false;
                            }
                            return true;
                        } else {
                            return true;
                        }
                    } else if (MgtvMediaPlayer.this.mTsNotSkip && MgtvMediaPlayer.this.isRendered()) {
                        return true;
                    }
                } else if (!MgtvMediaPlayer.this.mPrepared) {
                    if (UrlUtil.isM3u8(MgtvMediaPlayer.this.mErrorUrl)) {
                        return i5 < 2;
                    }
                    MgtvMediaPlayer mgtvMediaPlayer2 = MgtvMediaPlayer.this;
                    mgtvMediaPlayer2.callbackTsSkip(mgtvMediaPlayer2.mErrorUrl, i2, i3);
                    return false;
                } else if (MgtvMediaPlayer.this.mIsBuffering && MgtvMediaPlayer.this.isHLSPlayingUrl() && i5 >= 1) {
                    if (UrlUtil.isSegment(MgtvMediaPlayer.this.mErrorUrl)) {
                        MgtvMediaPlayer mgtvMediaPlayer3 = MgtvMediaPlayer.this;
                        mgtvMediaPlayer3.callbackTsSkip(mgtvMediaPlayer3.mErrorUrl, i2, i3);
                    }
                    return false;
                }
                if (MgtvMediaPlayer.this.isSkipRetryCode(i2, i3) || i5 >= 2) {
                    if (UrlUtil.isSegment(MgtvMediaPlayer.this.mErrorUrl)) {
                        MgtvMediaPlayer mgtvMediaPlayer4 = MgtvMediaPlayer.this;
                        mgtvMediaPlayer4.callbackTsSkip(mgtvMediaPlayer4.mErrorUrl, i2, i3);
                    }
                    reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                    return false;
                }
                return true;
            }

            private boolean doNewHttpWillOpen(Bundle bundle2) {
                int i2 = bundle2.getInt("error_type");
                int i3 = bundle2.getInt("error_code");
                bundle2.getInt("retry_counter");
                int i4 = bundle2.getInt("reset_iplist");
                MgtvMediaPlayer.this.mLastDlSize = bundle2.getInt("cur_dl_dize");
                bundle2.putString("user_msg", "init");
                if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap && i4 == 1) {
                    MgtvMediaPlayer.this.clearIPCache();
                }
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag, "doNewHttpWillOpen in error_what:" + i2 + ",error_extra:" + i3 + ",reset_iplist:" + i4 + ",mLastDlSize:" + MgtvMediaPlayer.this.mLastDlSize);
                bundle2.putInt("reset_iplist", 0);
                if (i3 == 0) {
                    MgtvMediaPlayer.this.mIsInitMp4Error = false;
                    if (i3 == 0 && MgtvMediaPlayer.this.mCacheEable) {
                        replaceUrlFromCache(bundle2);
                    }
                    return false;
                }
                boolean doNetHttpWillOpenFailed = doNetHttpWillOpenFailed(i2, i3, bundle2);
                String logTag2 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag2, "doNetHttpWillOpenFailed return " + doNetHttpWillOpenFailed + "," + i2 + "-" + i3 + "-" + MgtvMediaPlayer.this.mErrorUrl);
                return doNetHttpWillOpenFailed;
            }

            private boolean doWillGetEnv(Bundle bundle2) {
                String string = bundle2.getString("env_key");
                if (string == null || string.length() <= 0) {
                    return false;
                }
                bundle2.putString("env_value", System.getenv(string));
                return true;
            }

            private boolean doWillHostAddr(Bundle bundle2) {
                List<String> list;
                if (bundle2 == null) {
                    return false;
                }
                int i2 = bundle2.getInt("addr_handle");
                String string = bundle2.getString("player_hash");
                int i3 = bundle2.getInt("retry_counter");
                String string2 = bundle2.getString("user_msg");
                String string3 = bundle2.getString("addr_hostname");
                long j = bundle2.getLong("switch_key");
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag, "callback doWillHostAddr is_handle:" + i2 + ",hash:" + string + ",count_int:" + i3 + ",user_msg:" + string2 + ",hostname:" + string3 + ",switch_key:" + j);
                if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap && i2 != 1 && MgtvMediaPlayer.USER_MSG_FLAG_USE_CACHE.equals(string2) && !c.a.a.a.k.d.g(string3) && MgtvMediaPlayer.this.mIPCacheMap.containsKey(string3)) {
                    try {
                        IPList iPList = (IPList) MgtvMediaPlayer.this.mIPCacheMap.get(string3);
                        if (iPList != null && (list = iPList.nUseList) != null && list.size() > 0 && iPList.checkTTL()) {
                            String str = iPList.nUseList.get(0);
                            if (c.a.a.a.k.d.b(str)) {
                                String logTag2 = MgtvMediaPlayer.this.getLogTag();
                                DebugLog.i(logTag2, "callback ipcache doWillHostAddr put chooseip:" + str);
                                String formatIPList = IPList.formatIPList(iPList.nUseList);
                                if (!StringUtil.isEmpty(formatIPList)) {
                                    String logTag3 = MgtvMediaPlayer.this.getLogTag();
                                    DebugLog.d(logTag3, "callback ipcache doWillHostAddr put srcIPListStr:" + formatIPList);
                                    bundle2.putString("addr_hostname", formatIPList);
                                }
                                bundle2.putString("addr_ip", str);
                                bundle2.putInt("addr_error", 0);
                                return false;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                String string4 = bundle2.getString("addr_uri");
                if (c.a.a.a.k.d.f(string3)) {
                    String E = MgtvMediaPlayer.this.mReporter != null ? MgtvMediaPlayer.this.mReporter.E() : "0";
                    notifyIpIsLAN(E, "hostname_" + string3);
                }
                boolean g = c.a.a.a.k.d.g(string3);
                boolean d = c.a.a.b.d.d.d(MgtvMediaPlayer.this.mContext);
                String logTag4 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag4, "doWillHostAddr hostname:" + string3 + ",isIp:" + g);
                String logTag5 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag5, "doWillHostAddr is_handle=" + i2 + ",mBackJavaDns=" + MgtvMediaPlayer.this.mBackJavaDns + ",isIp=" + g + ",mForceHttpDns:" + MgtvMediaPlayer.this.mForceHttpDns);
                if ((MgtvMediaPlayer.this.mForceHttpDns && !g) || ((MgtvMediaPlayer.this.mJavaDnsEnable && !g) || (i2 == 1 && MgtvMediaPlayer.this.mBackJavaDns && !g))) {
                    if (d) {
                        MgtvMediaPlayer.this.mLastUri = string4;
                        domainResolve(string3, bundle2, MgtvMediaPlayer.this.mForceHttpDns);
                    } else {
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "skip domainResolve cause net not available");
                    }
                    return MgtvMediaPlayer.this.mPlayerReset;
                }
                if (i2 == 1 && g) {
                    bundle2.putString("addr_ip", string3);
                    bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CTRL_ARRR_DNS_TYPE_INT, 0);
                    bundle2.putInt("addr_error", 0);
                }
                return false;
            }

            private boolean doWillHttpOpen(Bundle bundle2) {
                if (bundle2 != null) {
                    MgtvMediaPlayer.this.mLastRequestUrl = UrlUtil.getValidUrl(bundle2.getString("url"));
                }
                if (MgtvMediaPlayer.this.mReportParams == null || !(MgtvMediaPlayer.this.mReportParams.getVideoType().equals(ReportParams.VideoType.AD_PRE) || MgtvMediaPlayer.this.mReportParams.getVideoType().equals(ReportParams.VideoType.AD_MID))) {
                    if (bundle2 != null) {
                        MgtvMediaPlayer.this.mWillOpenUrl = bundle2.getString("url");
                    }
                    return doNewHttpWillOpen(bundle2);
                }
                return onNormalHttpWillOpen(bundle2);
            }

            private void domainResolve(String str, Bundle bundle2, boolean z2) {
                a.d c;
                int k;
                if (str == null || bundle2 == null) {
                    DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "skip domainResolve hostname or args is null");
                    return;
                }
                a aVar = new a();
                aVar.d(new a.c() { // from class: com.hunantv.media.player.MgtvMediaPlayer.4.1
                    public void onDnsFail(a aVar2) {
                    }

                    public void onDnsFinish(a aVar2) {
                        synchronized (MgtvMediaPlayer.this.mDnsLock) {
                            MgtvMediaPlayer.this.mDnsLock.notifyAll();
                        }
                    }

                    public void onDnsStart(a aVar2) {
                    }

                    public void onDnsSuc(a aVar2, String[] strArr) {
                    }
                });
                boolean resolveStrategy = resolveStrategy(aVar, str, bundle2, z2, MgtvMediaPlayer.this.mHttpDnsNeedRetry);
                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve use:" + resolveStrategy);
                if (resolveStrategy) {
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve use type:" + aVar.c());
                    notifyHttpDnsReport(aVar.c(), MainNotifyHandler.MSG_HTTPDNS_REPORT_PV, 0);
                }
                synchronized (MgtvMediaPlayer.this.mDnsLock) {
                    while (aVar.n() && !isJavaDnsInterrupt()) {
                        DebugLog.d(MgtvMediaPlayer.this.getLogTag(), "domainResolve wait in");
                        try {
                            MgtvMediaPlayer.this.mDnsLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                DebugLog.d(MgtvMediaPlayer.this.getLogTag(), "domainResolve wait out. resolving:" + aVar.n() + ",isJavaDnsInterrupt:" + isJavaDnsInterrupt());
                String[] c2 = c.a.a.a.k.d.c(aVar.m());
                aVar.o();
                String str2 = "costMs:" + aVar.i() + ";ips:" + com.hunantv.media.utils.StringUtil.formatArrayString(c2) + ";net:" + NetPlayConfig.getNetworkType() + g.b;
                String formatIPList = IPList.formatIPList(c2);
                String str3 = null;
                if (c2 != null && c2.length > 0) {
                    str3 = c2[0];
                }
                int i2 = AnonymousClass28.$SwitchMap$com$hunantv$media$player$dns$AsyncDns$DnsType[aVar.c().ordinal()] == 1 ? 4 : 5;
                if (!isJavaDnsInterrupt() && c.a.a.a.k.d.b(str3)) {
                    if (resolveStrategy) {
                        updateCurrentDnsDsc(aVar.c());
                        if (c.a.a.a.k.d.f(str3)) {
                            notifyHttpDnsReport(aVar.c(), 2001, 100, str2);
                        } else {
                            notifyHttpDnsReport(aVar.c(), 2001, 0, str2);
                        }
                    }
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve put iplist:" + formatIPList);
                    bundle2.putString("addr_hostname", formatIPList);
                    if (c.a.a.a.k.d.b(str3)) {
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve put firstIP:" + str3);
                        bundle2.putString("addr_ip", str3);
                    }
                    bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CTRL_ARRR_DNS_TYPE_INT, i2);
                    bundle2.putInt("addr_error", 0);
                    return;
                }
                if (resolveStrategy) {
                    if (isJavaDnsInterrupt() && aVar.k() == 0) {
                        c = aVar.c();
                        k = -2;
                    } else {
                        c = aVar.c();
                        k = aVar.k();
                    }
                    notifyHttpDnsReport(c, 2002, k, str2);
                    if (!isJavaDnsInterrupt()) {
                        int a = aVar.a((int) Opcodes.IFNONNULL);
                        if (aVar.k() != 0) {
                            a = aVar.k();
                        } else if (str3 != null && !c.a.a.a.k.d.g(str3)) {
                            a = aVar.a(107);
                        }
                        int i3 = -a;
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), aVar.c() + "resolve putInt error:" + i3);
                        bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CTRL_ARRR_DNS_TYPE_INT, i2);
                        bundle2.putInt("addr_error", i3);
                    }
                }
                MgtvMediaPlayer.this.mCurrentDnsDsc = "native";
            }

            private String findTsCachPath(String str, String[] strArr) {
                if (strArr == null) {
                    return null;
                }
                try {
                    String fileName = UrlUtil.getFileName(str);
                    for (String str2 : strArr) {
                        if (str2 != null && new File(str2).getName().equals(fileName)) {
                            return str2;
                        }
                    }
                } catch (Exception unused) {
                }
                return null;
            }

            private boolean isDnsError(int i2, int i3) {
                return i3 == 300600 || i2 == 400605 || MGTVP2pDirectMediaDataSource.isP2pDirectDnsError(i2, i3);
            }

            private boolean isENETUNREACHcode(int i2, int i3) {
                return i3 == 300005 || MGTVP2pDirectMediaDataSource.getShortErrorCode(i2, i3) == 101;
            }

            private boolean isInitMp4(String str) {
                return MgtvMediaPlayer.this.isHLSPlayingUrl() && UrlUtil.isSuffixUrl(str, ".mp4");
            }

            private boolean isJavaDnsInterrupt() {
                return isPlayerReset();
            }

            private boolean isPlayerReset() {
                return MgtvMediaPlayer.this.mPlayerReset || (MgtvMediaPlayer.this.mPlayerMode == 2 && MgtvMediaPlayer.this.mLoopPlayerReset);
            }

            private void notifyHttpDnsReport(a.d dVar, int i2, int i3) {
                notifyHttpDnsReport(dVar, i2, i3, "");
            }

            private void notifyHttpDnsReport(a.d dVar, int i2, int i3, String str) {
                if (dVar != a.d.b || MgtvMediaPlayer.this.mOnWarningListener == null) {
                    return;
                }
                notifyMessage(i2, i3, str);
            }

            private void notifyIpIsLAN(String str, String str2) {
                if (MgtvMediaPlayer.this.mOnWarningListener == null || MgtvMediaPlayer.this.mReportParams == null || MgtvMediaPlayer.this.mReportParams.getVideoType() != ReportParams.VideoType.VOD) {
                    return;
                }
                if (!MgtvMediaPlayer.this.mReportedTSLAN) {
                    notifyMessage(1002, str, str2 + "_suffix_" + UrlUtil.getSuffix(MgtvMediaPlayer.this.mWillOpenUrl));
                }
                if (UrlUtil.isM3u8(MgtvMediaPlayer.this.mWillOpenUrl)) {
                    return;
                }
                MgtvMediaPlayer.this.mReportedTSLAN = true;
            }

            private void notifyMessage(int i2, int i3, String str) {
                Message message = new Message();
                message.what = i2;
                message.arg1 = i3;
                message.obj = str;
                MgtvMediaPlayer.this.mNotifyHandler.sendMessage(message);
            }

            private void notifyMessage(int i2, String str, String str2) {
                Message message = new Message();
                message.what = i2;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MainNotifyHandler.BUNDLE_STR_INFO1, str);
                bundle2.putString(MainNotifyHandler.BUNDLE_STR_INFO2, str2);
                message.setData(bundle2);
                MgtvMediaPlayer.this.mNotifyHandler.sendMessage(message);
            }

            private boolean onLiveWillOpen(Bundle bundle2) {
                int i2 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_ERROR_WHAT_INT);
                int i3 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_ERROR_EXTRA_INT);
                MgtvMediaPlayer.this.mLastRequestUrl = UrlUtil.getValidUrl(bundle2.getString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_SRC_URL_STRING));
                if (i3 != 0) {
                    MgtvMediaPlayer.this.mErrorUrl = UrlUtil.getValidUrl(bundle2.getString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_SRC_URL_STRING));
                    int i4 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_COUNTER_INT);
                    int i5 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_ERR_IO_TYPE_INT);
                    c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLiveWillOpen url:%s,iotype:%d, RetryCount:%d,error_code:%d-%d", new Object[]{MgtvMediaPlayer.this.mErrorUrl, Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3)});
                    if (isENETUNREACHcode(i2, i3) || (MgtvMediaPlayer.this.mPrepared && isDnsError(i2, i3))) {
                        c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLiveWillOpen network broken,RetryCount:%d,error_code:%d-%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3)});
                        return true;
                    }
                    DebugLog.ifmt(MgtvMediaPlayer.this.getLogTag(), "OnSourceNetHandledListener.CTRL_WILL_LIVE_OPEN %d-%d-%d-%d-%s", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), MgtvMediaPlayer.this.mErrorUrl);
                    return !MgtvMediaPlayer.this.isSkipRetryCode(i2, i3) && i4 < 2;
                }
                return false;
            }

            private boolean onLoopWillOpen(Bundle bundle2) {
                int i2 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_ERROR_WHAT_INT);
                int i3 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_ERROR_EXTRA_INT);
                if (i3 != 0) {
                    MgtvMediaPlayer.this.mErrorUrl = UrlUtil.getValidUrl(bundle2.getString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_SRC_URL_STRING));
                    int i4 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_COUNTER_INT);
                    int i5 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_ERR_IO_TYPE_INT);
                    c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLoopWillOpen url:%s,iotype:%d, RetryCount:%d,error_code:%d-%d", new Object[]{MgtvMediaPlayer.this.mErrorUrl, Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3)});
                    if (isENETUNREACHcode(i2, i3) || (MgtvMediaPlayer.this.mPrepared && isDnsError(i2, i3))) {
                        c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLoopWillOpen network broken,RetryCount:%d,error_code:%d-%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3)});
                        return true;
                    }
                    DebugLog.ifmt(MgtvMediaPlayer.this.getLogTag(), "OnSourceNetHandledListener.CTRL_WILL_LOOP_OPEN %d-%d-%d-%d-%s", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), MgtvMediaPlayer.this.mErrorUrl);
                    return !MgtvMediaPlayer.this.isSkipRetryCode(i2, i3) && i4 < 2;
                }
                return false;
            }

            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private boolean onNormalHttpWillOpen(android.os.Bundle r15) {
                /*
                    Method dump skipped, instructions count: 329
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.player.MgtvMediaPlayer.AnonymousClass4.onNormalHttpWillOpen(android.os.Bundle):boolean");
            }

            private boolean replaceUrlFromCache(Bundle bundle2) {
                String string = bundle2.getString("url");
                if (!UrlUtil.isFilePrefix(string) && !UrlUtil.isLocal(string)) {
                    String str = null;
                    String fileName = UrlUtil.getFileName(string);
                    if (StringUtil.isEmpty(fileName)) {
                        return false;
                    }
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.d(logTag, "replaceUrlFromCache try to find replace cache:" + string);
                    if (UrlUtil.isM3u8(string)) {
                        String str2 = MgtvMediaPlayer.this.mCacheM3u8Path;
                        String fileName2 = UrlUtil.getFileName(str2);
                        if (!StringUtil.isEmpty(str2) && !StringUtil.isEmpty(fileName2) && fileName2.equals(fileName)) {
                            str = str2;
                        }
                    } else if (MgtvMediaPlayer.this.isHLSPlayingUrl() && UrlUtil.isSegment(string)) {
                        str = findTsCachPath(string, MgtvMediaPlayer.this.mCacheTsPaths);
                    }
                    if (FileUtil.exist(str)) {
                        String addLocalPrefix = UrlUtil.addLocalPrefix(str);
                        if (!StringUtil.isEmpty(addLocalPrefix)) {
                            String logTag2 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag2, "replaceUrlFromCache from " + string);
                            String logTag3 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag3, "replaceUrlFromCache to " + addLocalPrefix);
                            bundle2.putString("url", addLocalPrefix);
                            if (UrlUtil.isM3u8(string)) {
                                String logTag4 = MgtvMediaPlayer.this.getLogTag();
                                DebugLog.d(logTag4, "replaceUrlFromCache put SRC_URL " + string);
                                bundle2.putString("src_url", string);
                            }
                            MgtvMediaPlayer.this.mCacheReplaceMap.put(addLocalPrefix, string);
                            return true;
                        }
                    }
                }
                return false;
            }

            private void reportHttpErrorErr(int i2, String str) {
                if ((isInitMp4(str) || UrlUtil.isM3u8(str)) && MgtvMediaPlayer.this.mReportParams != null && MgtvMediaPlayer.this.mReportParams.getVideoType() == ReportParams.VideoType.VOD && MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.NO_PROXY && MgtvMediaPlayer.this.mOnWarningListener != null) {
                    String E = MgtvMediaPlayer.this.mReporter != null ? MgtvMediaPlayer.this.mReporter.E() : MLog.a.b;
                    MgtvPlayerListener.OnWarningListener onWarningListener = MgtvMediaPlayer.this.mOnWarningListener;
                    String str2 = i2 + Consts.DOT + MgtvMediaPlayer.this.mCacheReportLerr;
                    StringBuilder sb = new StringBuilder();
                    sb.append("psuuid_");
                    sb.append(E);
                    sb.append("_render_");
                    sb.append(MgtvMediaPlayer.this.isRendered() ? "1" : "0");
                    sb.append("_url_");
                    sb.append(str);
                    sb.append("_type_");
                    sb.append(MgtvMediaPlayer.this.mCacheReportTag);
                    onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_HTTP_ERROR_ERR, str2, sb.toString(), null);
                }
            }

            private void reportHttpErrorPV(int i2, String str, int i3, String str2) {
                if (i2 == 0) {
                    MgtvMediaPlayer.this.mCacheReportTag = MgtvMediaPlayer.DEFAULT_CACHE_REPORT_TAG;
                    MgtvMediaPlayer.this.mCacheReportLerr = 0;
                }
                if (i2 == 0) {
                    if ((isInitMp4(str) || UrlUtil.isM3u8(str)) && MgtvMediaPlayer.this.mReportParams != null && MgtvMediaPlayer.this.mReportParams.getVideoType() == ReportParams.VideoType.VOD && MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.NO_PROXY && MgtvMediaPlayer.this.mOnWarningListener != null) {
                        String E = MgtvMediaPlayer.this.mReporter != null ? MgtvMediaPlayer.this.mReporter.E() : MLog.a.b;
                        MgtvMediaPlayer.this.mCacheReportTag = str2;
                        MgtvMediaPlayer.this.mCacheReportLerr = i3;
                        MgtvPlayerListener.OnWarningListener onWarningListener = MgtvMediaPlayer.this.mOnWarningListener;
                        String str3 = i3 + "";
                        StringBuilder sb = new StringBuilder();
                        sb.append("psuuid_");
                        sb.append(E);
                        sb.append("_render_");
                        sb.append(MgtvMediaPlayer.this.isRendered() ? "1" : "0");
                        sb.append("_url_");
                        sb.append(str);
                        sb.append("_type_");
                        sb.append(str2);
                        onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_HTTP_ERROR_PV, str3, sb.toString(), null);
                    }
                }
            }

            private boolean resolveStrategy(@NonNull a aVar, @NonNull String str, Bundle bundle2) {
                return resolveStrategy(aVar, str, bundle2, false, false);
            }

            private boolean resolveStrategy(@NonNull a aVar, @NonNull String str, Bundle bundle2, boolean z2, boolean z22) {
                a.d dVar;
                String logTag;
                String str2;
                if (z2 || (bundle2 != null && bundle2.getInt("addr_handle") == 1 && MgtvMediaPlayer.this.mBackJavaDns)) {
                    aVar.j(1);
                    dVar = a.d.b;
                } else {
                    if (MgtvMediaPlayer.this.isDnsCacheEnable()) {
                        if (MgtvMediaPlayer.this.mHttpDnsEnable) {
                            String a = StringUtil.isEmpty(MgtvMediaPlayer.this.mLastUri) ? null : c.a.a.a.k.e.a(MgtvMediaPlayer.this.mLastUri);
                            if (a != null && !a.trim().equals("")) {
                                logTag = MgtvMediaPlayer.this.getLogTag();
                                str2 = "resolveStrategy cache valid";
                            }
                        } else {
                            logTag = MgtvMediaPlayer.this.getLogTag();
                            str2 = "resolveStrategy cache valid and httpdns not open";
                        }
                        DebugLog.d(logTag, str2);
                        return false;
                    }
                    dVar = MgtvMediaPlayer.this.mJavaDnsType;
                }
                aVar.e(str, dVar, z22);
                return true;
            }

            private void updateCurrentDnsDsc(a.d dVar) {
                MgtvMediaPlayer mgtvMediaPlayer;
                String str;
                int i2 = AnonymousClass28.$SwitchMap$com$hunantv$media$player$dns$AsyncDns$DnsType[dVar.ordinal()];
                if (i2 == 1) {
                    mgtvMediaPlayer = MgtvMediaPlayer.this;
                    str = MgtvMediaPlayer.DNS_JAVA_NORMAL;
                } else if (i2 != 2) {
                    return;
                } else {
                    mgtvMediaPlayer = MgtvMediaPlayer.this;
                    str = MgtvMediaPlayer.DNS_JAVA_HTTPDNS;
                }
                mgtvMediaPlayer.mCurrentDnsDsc = str;
            }

            private void updateIp(String str) {
                String logTag;
                StringBuilder sb;
                String str2;
                if (MgtvMediaPlayer.this.mMediaPlayer == null || (!(MgtvMediaPlayer.this.mMediaPlayer.v() == 2 || MgtvMediaPlayer.this.mMediaPlayer.v() == 1) || MgtvMediaPlayer.this.mMediaPlayer.o4() == null)) {
                    if (MgtvMediaPlayer.this.mMediaPlayer == null || !((MgtvMediaPlayer.this.mMediaPlayer.v() == 2 || MgtvMediaPlayer.this.mMediaPlayer.v() == 1) && MgtvMediaPlayer.this.mMediaPlayer.o4() == null)) {
                        MgtvMediaPlayer.this.mLastIP = str;
                    } else {
                        MgtvMediaPlayer.this.mLastIP = "0.0.0.1";
                    }
                    logTag = MgtvMediaPlayer.this.getLogTag();
                    sb = new StringBuilder();
                    str2 = "didTcpOpen tcp_ip:";
                } else {
                    MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                    mgtvMediaPlayer.mLastIP = P2pMgr.getCdnIpFromP2PTask(mgtvMediaPlayer.mMediaPlayer.o4());
                    logTag = MgtvMediaPlayer.this.getLogTag();
                    sb = new StringBuilder();
                    str2 = "didTcpOpen p2p QueryTaskInfo cdnIp:";
                }
                sb.append(str2);
                sb.append(MgtvMediaPlayer.this.mLastIP);
                DebugLog.d(logTag, sb.toString());
            }

            private void willTcpOpen(Bundle bundle2) {
                if (bundle2 == null) {
                    return;
                }
                String string = bundle2.getString("tcp_hostname");
                String string2 = bundle2.getString("ip");
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag, "callback willTcpOpen tcp_hostname:" + string + ",tcp_ip:" + string2);
                MgtvMediaPlayer.this.mLastHostIP = string2;
                updateIp(string2);
                if (string2 == null || string2.length() <= 1 || !c.a.a.a.k.d.f(string2)) {
                    return;
                }
                notifyIpIsLAN("1", MgtvMediaPlayer.this.getCurrentDnsDsc() + "_hostip_" + string2);
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSourceNetHandledListener
            public boolean onSourceNetCtrl(int i2, Bundle bundle2) {
                IP2pTask o4;
                c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "OnSourceNetHandledListener.onSourceNetCtrl 0x%5x", new Object[]{Integer.valueOf(i2)});
                switch (i2) {
                    case 131073:
                        willTcpOpen(bundle2);
                        break;
                    case 131074:
                        didTcpOpen(bundle2);
                        break;
                    case 131075:
                        return doWillHttpOpen(bundle2);
                    case 131077:
                        return didLiveOpen(bundle2);
                    case 131078:
                        return doWillHostAddr(bundle2);
                    case 131081:
                        return didLiveReopen(bundle2);
                    case 131088:
                        return didLoopOpen(bundle2);
                    case 131089:
                        return didLoopReopen(bundle2);
                    case 131090:
                        return didHDJSwitch(bundle2);
                    case 131104:
                        return doWillGetEnv(bundle2);
                    case 131120:
                        if (MgtvMediaPlayer.this.mPreBufferState.isEnable() && MgtvMediaPlayer.this.mPreBufferState.getState() == 2) {
                            this.mIsPauseLoad = true;
                            return true;
                        } else if (MgtvMediaPlayer.this.isSourceSwitching() || MgtvMediaPlayer.this.mMediaPlayer == null || (!(MgtvMediaPlayer.this.mMediaPlayer.v() == 2 || MgtvMediaPlayer.this.mMediaPlayer.v() == 1) || (o4 = MgtvMediaPlayer.this.mMediaPlayer.o4()) == null || o4.getStatus() == 0)) {
                            if (this.mIsPauseLoad) {
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "CTRL_WILL_CHECK_PAUSE_LOAD will return false. will resume load");
                            }
                            this.mIsPauseLoad = false;
                            return false;
                        } else {
                            if (!this.mIsPauseLoad) {
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "CTRL_WILL_CHECK_PAUSE_LOAD will return true. will pause load");
                            }
                            this.mIsPauseLoad = true;
                            return true;
                        }
                    case 131184:
                        synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                            if (bundle2 == null) {
                                break;
                            } else if (bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_NEED_RETRY_INT) == 1) {
                                if (MgtvMediaPlayer.this.mReporter != null) {
                                    MgtvMediaPlayer.this.mReporter.M();
                                }
                                int i3 = (int) bundle2.getLong(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_RETRY_KEY_LONG);
                                SmoothMediaSource smoothMediaSource = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i3));
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth need_retry == 1 find:" + i3);
                                if (smoothMediaSource != null) {
                                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth need_retry == 1 , will retry use :" + smoothMediaSource.getUrl());
                                    bundle2.putString("smooth_switch_url", smoothMediaSource.getUrl());
                                    if (smoothMediaSource.getReporter() != null) {
                                        smoothMediaSource.getReporter().H();
                                        if (MgtvMediaPlayer.this.mReportParams != null) {
                                            MgtvMediaPlayer.this.mReportParams.setPlaySessionId(smoothMediaSource.getReporter().E());
                                        }
                                    }
                                } else {
                                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth need_retry == 1, not found source");
                                }
                                bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_NEED_RETRY_INT, 0);
                                return true;
                            } else {
                                int i4 = (int) bundle2.getLong("smooth_switch_key");
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth CTRL_WILL_SMOOTH_SWITCH switch_key:" + i4);
                                SmoothMediaSource matchLastKeySource = MgtvMediaPlayer.this.matchLastKeySource(i4);
                                if (matchLastKeySource != null) {
                                    if (matchLastKeySource.isLastRetry() && MgtvMediaPlayer.this.mReportParams != null && (MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.ONLY_P2P || MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.P2P_DRM)) {
                                        SmoothMediaSource smoothMediaSource2 = new SmoothMediaSource(MgtvMediaPlayer.this.getPlayingOriginUrl());
                                        smoothMediaSource2.setReportParams(MgtvMediaPlayer.this.mReportParams);
                                        smoothMediaSource2.bind(MgtvMediaPlayer.this);
                                        smoothMediaSource2.setThrowErrorIfSwitchFailed(true);
                                        MgtvMediaPlayer.this.mSmoothSourcesRecord.put(Integer.valueOf(smoothMediaSource2.getKey()), smoothMediaSource2);
                                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth is last retry. will retry key:" + smoothMediaSource2.getKey());
                                        bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_NEED_RETRY_INT, 1);
                                        bundle2.putLong(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_RETRY_KEY_LONG, smoothMediaSource2.getKey());
                                    }
                                    if (!matchLastKeySource.isLastRetry()) {
                                        String string = bundle2.getString("smooth_switch_url");
                                        bundle2.putString("smooth_switch_url", string);
                                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth CTRL_WILL_SMOOTH_SWITCH switch_url:" + string);
                                        if (!StringUtil.isEmpty(string)) {
                                            int indexOf = string.indexOf(",mgtvjsource:");
                                            String substring = indexOf >= 0 ? string.substring(indexOf) : "";
                                            boolean onSwitchSmoothSourceWillUpdate = MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener != null ? MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener.onSwitchSmoothSourceWillUpdate(matchLastKeySource) : false;
                                            if (matchLastKeySource.getReadType() != 2 && onSwitchSmoothSourceWillUpdate && !StringUtil.isEmpty(matchLastKeySource.useUpdateUrl())) {
                                                String str = matchLastKeySource.useUpdateUrl() + substring;
                                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth CTRL_WILL_SMOOTH_SWITCH will update url:" + str);
                                                bundle2.putString("smooth_switch_url", str);
                                            }
                                        }
                                    }
                                }
                                SmoothMediaSource smoothMediaSource3 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i4));
                                if (smoothMediaSource3 != null && smoothMediaSource3.getReporter() != null) {
                                    smoothMediaSource3.getReporter().H();
                                    if (MgtvMediaPlayer.this.mReportParams != null) {
                                        MgtvMediaPlayer.this.mReportParams.setPlaySessionId(smoothMediaSource3.getReporter().E());
                                    }
                                }
                                return true;
                            }
                        }
                        break;
                }
                return false;
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSourceNetHandledListener
            public void onSourceNetEvent(int i2, Bundle bundle2) {
                if (i2 != 78338) {
                    return;
                }
                didHostAddr(bundle2);
            }
        };
        this.mLogTagKey = "";
        this.mEnableReport = true;
        this.p2pLocker = new Object();
        this.mSeekStartMs = -1L;
        this.mHw2SwType = Hw2SwType.NONE;
        this.mPlaybackSpeed = 1.0f;
        this.mRecordMaxPlaySpeed = 1.0f;
        this.mFrameListener = new MgtvPlayerListener.OnFrameListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.22
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnFrameListener
            public void onVFrameClockCome(MgtvPlayerListener.FrameClock frameClock) {
                synchronized (MgtvMediaPlayer.this.ptsLocker) {
                    WeakHandler weakHandler = MgtvMediaPlayer.this.ptsWeakHandler;
                    if (weakHandler != null) {
                        weakHandler.removeMessages(256);
                        Message message = new Message();
                        message.what = 256;
                        message.obj = frameClock;
                        MgtvMediaPlayer.this.ptsWeakHandler.sendMessage(message);
                    }
                    if (MgtvMediaPlayer.this.mOnFrameListener != null) {
                        MgtvMediaPlayer.this.mOnFrameListener.onVFrameClockCome(frameClock);
                    }
                }
            }
        };
        this.mInnerFlowDataStatistic = new FlowDataStatistic();
        this.mEnableImgoVsr = false;
        this.mLoopSourceKey = new AtomicInteger(1);
        this.mSubtitleSources = new ArrayList();
        this.ptsHandlerThread = null;
        this.ptsWeakHandler = null;
        this.ptsListeners = new HashSet();
        this.ptsLocker = new Object();
        this.mSmoothSourceListener = new d.n() { // from class: com.hunantv.media.player.MgtvMediaPlayer.26
            public int lastSwitchingKey = -1;

            public void onSmoothSwitchSourceComplete(d dVar, int i2, int i3, String str) {
                SmoothMediaSource smoothMediaSource;
                synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.d(logTag, "onSmoothSwitchSourceComplete (type:" + i3 + ",key:" + i2 + ",msg:" + str + ")");
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSmoothSwitchSourceComplete current: ");
                    sb.append(MgtvMediaPlayer.this.getCurrentSmoothSourceKey());
                    DebugLog.i(logTag2, sb.toString());
                    for (Map.Entry entry : MgtvMediaPlayer.this.mSmoothSourcesRecord.entrySet()) {
                        if (((Integer) entry.getKey()).intValue() < i2 && (smoothMediaSource = (SmoothMediaSource) entry.getValue()) != null && !smoothMediaSource.isReleased()) {
                            smoothMediaSource.release();
                        }
                    }
                    MgtvMediaPlayer.this.mSmoothUseP2pFailed = false;
                    if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                        MgtvMediaPlayer.this.mMediaPlayer.k2(false);
                    }
                    SmoothMediaSource smoothMediaSource2 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i2));
                    if (smoothMediaSource2 != null) {
                        if (!StringUtil.isEmpty(smoothMediaSource2.getVfps())) {
                            MgtvMediaPlayer.this.mRecordVfps = Float.parseFloat(smoothMediaSource2.getVfps());
                        }
                        MgtvMediaPlayer.this.mLastVideoWidth = smoothMediaSource2.getVideoWidth();
                        MgtvMediaPlayer.this.mLastVideoHeight = smoothMediaSource2.getVideoHeight();
                        if (MgtvMediaPlayer.this.mReporter != null) {
                            MgtvMediaPlayer.this.mReporter.M();
                        }
                        MgtvMediaPlayer.this.mReporter = smoothMediaSource2.getReporter();
                        if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                            MgtvMediaPlayer.this.mMediaPlayer.o0(MgtvMediaPlayer.this.mReporter);
                            MgtvMediaPlayer.this.mMediaPlayer.A0(smoothMediaSource2.getReadType(), smoothMediaSource2.getUrl(), smoothMediaSource2.getPlayingUrl());
                            MgtvMediaPlayer.this.mMediaPlayer.N1(smoothMediaSource2.getEnableImgoAIQE());
                        }
                        if (MgtvMediaPlayer.this.mDataSourceInfo != null) {
                            MgtvMediaPlayer.this.mDataSourceInfo.setVideoFormat(smoothMediaSource2.getVideoFormat());
                            MgtvMediaPlayer.this.mDataSourceInfo.setAudioFormat(smoothMediaSource2.getAudioFormat());
                            MgtvMediaPlayer.this.mDataSourceInfo.setFileFormat(smoothMediaSource2.getFileFormat());
                        }
                        if (MgtvMediaPlayer.this.mReporter != null) {
                            MgtvMediaPlayer.this.mReportParams.deepCopy(smoothMediaSource2.getReportParams());
                            MgtvMediaPlayer.this.mReporter.n(MgtvMediaPlayer.this.mReportParams);
                            MgtvMediaPlayer.this.mReporter.N();
                        }
                        String keyFrameMapKey = MgtvMediaPlayer.this.getKeyFrameMapKey(smoothMediaSource2.getVid(), smoothMediaSource2.getDef());
                        if (MgtvMediaPlayer.this.mSmoothKeyFrameMap.containsKey(keyFrameMapKey)) {
                            String logTag3 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag3, "find smoothKeyFrameKey :" + keyFrameMapKey + " set to player");
                            byte[] bArr = MgtvMediaPlayer.this.mSmoothKeyFrameMap.get(keyFrameMapKey);
                            if (KeyFrameInfoUtils.isKeyFrameDataValid(bArr, smoothMediaSource2.videoFileHash) == 0) {
                                MgtvMediaPlayer.this.setKeyFrameInfoFileBuf(bArr);
                            }
                        }
                    }
                    SmoothMediaSource matchLastKeySource = MgtvMediaPlayer.this.matchLastKeySource(i2);
                    if (matchLastKeySource == null) {
                        DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "onSmoothSwitchSourceComplete matchKeySource failed");
                        return;
                    }
                    if (matchLastKeySource.getSwitchMod() == 1) {
                        MgtvMediaPlayer.this.mMediaPlayer.w2(true);
                    }
                    MgtvMediaPlayer.this.mSwitchedSmoothSource = matchLastKeySource;
                    MgtvMediaPlayer.this.mSourceSwitchingComplete = true;
                    MgtvMediaPlayer.this.mSourceSwitching = false;
                    if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                        MgtvMediaPlayer.this.mMainFlowReportProcessor = matchLastKeySource.getFlowReportProcessor();
                        MgtvMediaPlayer.this.mMediaPlayer.L0(matchLastKeySource.getP2pTask());
                        MgtvMediaPlayer.this.mMediaPlayer.j3(matchLastKeySource.getReadType());
                    }
                    MgtvMediaPlayer.this.mSmoothKeyFrameMap.clear();
                    if (MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener != null) {
                        MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener.onSwitchSmoothSourceSuccess(matchLastKeySource);
                    }
                }
            }

            public void onSmoothSwitchSourceFailed(d dVar, int i2, int i3, String str) {
                String[] split;
                synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.e(logTag, "onSmoothSwitchSourceFailed (type:" + i3 + ",key:" + i2 + ",msg:" + str + ")");
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSmoothSwitchSourceFailed current: ");
                    sb.append(MgtvMediaPlayer.this.getCurrentSmoothSourceKey());
                    DebugLog.e(logTag2, sb.toString());
                    int i4 = MgtvMediaPlayer.WHAT_SMOOTHSOURCE_FAIL;
                    int i5 = -1;
                    try {
                        if (!StringUtil.isEmpty(str) && (split = str.split("-")) != null && split.length >= 2) {
                            i4 = NumericUtil.parseInt(split[0]);
                            i5 = NumericUtil.parseInt(split[1]);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    SmoothMediaSource smoothMediaSource = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i2));
                    if (smoothMediaSource != null) {
                        if (smoothMediaSource.getReporter() != null) {
                            smoothMediaSource.getReporter().l(i4, i5, "");
                        }
                        if (MgtvMediaPlayer.this.mReportParams != null) {
                            String logTag3 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag3, "onSmoothSwitchSourceFailed mReportParams:" + MgtvMediaPlayer.this.mReportParams.getProxyType() + "-" + MgtvMediaPlayer.this.mReportParams.getP2ps());
                        }
                        if (smoothMediaSource.getReportParams() != null) {
                            String logTag4 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag4, "onSmoothSwitchSourceFailed currentSource.getReportParams():" + smoothMediaSource.getReportParams().getProxyType() + "-" + smoothMediaSource.getReportParams().getP2ps());
                        }
                        if (MgtvMediaPlayer.this.mReportParams != null && MgtvMediaPlayer.this.mReportParams.isP2p() && smoothMediaSource.getReportParams() != null && smoothMediaSource.getReportParams().isP2p()) {
                            MgtvMediaPlayer.this.mSmoothUseP2pFailed = true;
                            if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                                MgtvMediaPlayer.this.mMediaPlayer.k2(true);
                            }
                        }
                        if (smoothMediaSource.isThrowErrorIfSwitchFailed()) {
                            MgtvMediaPlayer.this.mErrorListener.onError(MgtvMediaPlayer.WHAT_SMOOTHSOURCE_EX_ERROR, i5);
                            return;
                        }
                    }
                    if (i3 == 1) {
                        MgtvMediaPlayer.this.mErrorListener.onError(i4, i5);
                        return;
                    }
                    SmoothMediaSource matchLastKeySource = MgtvMediaPlayer.this.matchLastKeySource(i2);
                    if (matchLastKeySource == null) {
                        DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "onSmoothSwitchSourceFailed matchKeySource failed");
                    } else {
                        MgtvMediaPlayer.this.notifySwitchSmoothSourceFail(matchLastKeySource, i4, i5);
                    }
                }
            }

            public void onSmoothSwitchSourceInfo(d dVar, int i2, int i3, String str) {
                synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.i(logTag, "onSmoothSwitchSourceInfo (event:" + i3 + ",key:" + i2 + ",msg:" + str + ")");
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSmoothSwitchSourceInfo current: ");
                    sb.append(MgtvMediaPlayer.this.getCurrentSmoothSourceKey());
                    DebugLog.i(logTag2, sb.toString());
                    SmoothMediaSource smoothMediaSource = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i2));
                    if (smoothMediaSource != null) {
                        if (i3 == 0) {
                            smoothMediaSource.s_event_0_timestamp = System.currentTimeMillis();
                        } else if (i3 == 11) {
                            smoothMediaSource.s_event_11_timestamp = System.currentTimeMillis();
                        } else if (i3 == 2) {
                            if (MgtvMediaPlayer.this.isFlowReportEnable) {
                                smoothMediaSource.genFlowReporter();
                            }
                            smoothMediaSource.s_event_2_timestamp = System.currentTimeMillis();
                        } else if (i3 == 3) {
                            if (MgtvMediaPlayer.this.isFlowReportEnable && MgtvMediaPlayer.this.mMainFlowReportProcessor != null) {
                                MgtvMediaPlayer.this.mMainFlowReportProcessor.stop();
                            }
                            for (Map.Entry entry : MgtvMediaPlayer.this.mSmoothSourcesRecord.entrySet()) {
                                if (((Integer) entry.getKey()).intValue() < smoothMediaSource.getKey()) {
                                    SmoothMediaSource smoothMediaSource2 = (SmoothMediaSource) entry.getValue();
                                    if (MgtvMediaPlayer.this.isFlowReportEnable && smoothMediaSource2 != null && smoothMediaSource2.getFlowReportProcessor() != null) {
                                        smoothMediaSource2.getFlowReportProcessor().stop();
                                    }
                                }
                            }
                            smoothMediaSource.s_event_3_timestamp = System.currentTimeMillis();
                        }
                    }
                    if (i3 != 3) {
                        if (MgtvMediaPlayer.this.matchLastKeySource(i2) == null) {
                            DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "onSmoothSwitchSourceInfo matchKeySource failed");
                            return;
                        }
                        if (i3 == 0) {
                            MgtvMediaPlayer.this.mSourceSwitching = true;
                        }
                        return;
                    }
                    SmoothMediaSource smoothMediaSource3 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(this.lastSwitchingKey));
                    if (smoothMediaSource3 != null && smoothMediaSource3.getReporter() != null) {
                        smoothMediaSource3.getReporter().M();
                    }
                    this.lastSwitchingKey = i2;
                    SmoothMediaSource smoothMediaSource4 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i2));
                    if (smoothMediaSource4 != null && MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener != null) {
                        MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener.onSwitchSmoothSourceInfo(smoothMediaSource4, i3);
                    }
                }
            }
        };
        this.mSmoothSourcesRecord = new HashMap();
        this.mSwitchSmoothSourceLocker = new Object();
        this.mSmoothUseP2pFailed = false;
        this.mSmoothKeyFrameMap = Collections.synchronizedMap(new HashMap());
        this.isBackground = false;
        this.isSpaceAudioSwitchOn = false;
        init(i, context, z);
    }

    public MgtvMediaPlayer(int i, Context context, boolean z, int i2, Bundle bundle) throws UnsatisfiedLinkError, SecurityException, NullPointerException, OutOfMemoryError {
        this.mDebug = false;
        this.mPreBufferTimeoutMs = 1800000;
        this.mBufferTimeoutMs = 180000;
        this.mImgoMediaPlayerAudioMode = false;
        this.mAccurateSeekEnable = true;
        this.mAccSeekKeyFrameInterval = 1000;
        this.mKeyframeSeekEnable = false;
        this.mInnerAutoRotateEnable = false;
        this.mWeakBufferSpeedKB = 1;
        this.mWeakBufferTimeoutMs = 120000;
        this.mTsNotSkip = false;
        this.mLoadMaxRetryTime = 2;
        this.mPrepared = false;
        this.mIsBuffering = false;
        this.mErrorUrl = "";
        this.mLastRequestUrl = "";
        this.mLastDlSize = 0;
        this.mIsLive = false;
        this.mPlayerMode = 0;
        this.mLiveReopen = false;
        this.mLoopPlayerSwitchUrl = "";
        this.mHDJSwitchUrl = "";
        this.mDataSourceType = DataSourceType.TYPE_DATASOUCE_DEFAULT;
        this.mErrorExtraCodeStore = -1;
        this.mRecordVfps = 0.0f;
        this.mLastVideoWidth = 0;
        this.mLastVideoHeight = 0;
        this.mSkipLoopFilterType = SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mAddrinfoType = AddrinfoType.TYPE_ADDRINFO_DEFAULT;
        this.mAddrinfoTimeoutMs = 0;
        this.mPrepared4StartMode = Prepared4StartMode.MODE_PREPARED4START_DEFAULT;
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.2
            private boolean needInnerRetry(int i22, int i3) {
                return !MgtvMediaPlayer.this.mIsInnerRetrying && MgtvMediaPlayer.this.mMediaPlayer.b4() == 2 && i22 == 200003 && i3 == 100606;
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i22, int i3) {
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.i(logTag, "onError what:" + i22 + ",extra:" + i3 + ",netType:" + NetPlayConfig.getNetworkType());
                if (MgtvMediaPlayer.this.mGifRecorder != null) {
                    MgtvMediaPlayer.this.mGifRecorder.interrupt(101);
                }
                if (MgtvMediaPlayer.this.isDnsCacheEnable()) {
                    MgtvMediaPlayer.this.checkAndCleanDnsCache(i22, i3);
                }
                if (needInnerRetry(i22, i3)) {
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "onError needInnerRetry");
                    MgtvMediaPlayer.this.mIsInnerRetrying = true;
                    MgtvMediaPlayer.this.mRetryLastErrorCode = i3;
                    MgtvMediaPlayer.this.setPlayerReset(true);
                    if (MgtvMediaPlayer.this.mMediaPlayer.b0()) {
                        MgtvMediaPlayer.this.mMediaPlayer.v1(MgtvMediaPlayer.this.mMediaPlayer.t(), i22, i3, MgtvMediaPlayer.this.mMediaPlayer.b4());
                    } else {
                        MgtvMediaPlayer.this.mMediaPlayer.u1(MgtvMediaPlayer.this.mMediaPlayer.t(), i22, i3);
                    }
                    return true;
                }
                MgtvMediaPlayer.this.beforeThrowError(i22, i3);
                MgtvMediaPlayer.this.reportErrorWarning(i22, i3);
                if (i22 != 7000006) {
                    MgtvMediaPlayer.this.reportError(i22, i3, "");
                }
                MgtvMediaPlayer.this.stopTickers();
                MgtvMediaPlayer.this.mPlayStatus = PlayStatus.ERROR;
                MgtvMediaPlayer.this.mErrorExtraCodeStore = i3;
                if (MgtvMediaPlayer.this.mOnErrorListener != null) {
                    return MgtvMediaPlayer.this.mOnErrorListener.onError(i22, i3);
                }
                return true;
            }
        };
        this.mIsGetPositionCallback = false;
        this.mPlayStatus = PlayStatus.IDLE;
        this.mRenderType = RenderType.NATIVE_WINDOW;
        this.mPlayTicker = new ExTicker(1000).setTypeStr("play");
        this.mBufferTick = new ExTicker(1000).setTypeStr("buffer");
        this.mPlayerType = 2;
        this.mMainThreadID = -1L;
        this.mCacheReplaceMap = new LinkedHashMap();
        this.mIsInnerRetrying = false;
        this.mRetryLastErrorCode = 0;
        this.mRenderDisableWarnSended = false;
        this.mForceHttpDns = false;
        this.mHttpDnsNeedRetry = false;
        this.mJavaDnsEnable = false;
        this.mJavaDnsType = a.d.b;
        this.mHttpDnsEnable = false;
        this.mPlayerReset = true;
        this.mLoopPlayerReset = true;
        this.mLastUri = null;
        this.mLastHostErr = MLog.a.b;
        this.mLastTcpErr = MLog.a.b;
        this.mLastIpCount = 0;
        this.mLastIpIndex = -1;
        this.mLastDnsType = -1;
        this.mCurrentDnsDsc = "native";
        this.mEnableP2PHttpDns = false;
        this.mForceP2pHttpDns = false;
        this.mDnsThreadManager = new c().b(new c.c() { // from class: com.hunantv.media.player.MgtvMediaPlayer.3
            public void updateIPs(String str, List<String> list) {
                P2pMgr.YfAddBackupIps(str, list, MgtvMediaPlayer.this.mForceP2pHttpDns);
            }
        });
        this.mAVSyncErrReported = false;
        this.mAVSyncErrSumReported = false;
        this.mAVSyncErrSum = 0;
        this.mAVSyncStartTimestamp = 0L;
        this.mPrepareAsyncTimeStampMs = 0L;
        this.mPreBufferState = new SyncStateMachine(1);
        this.mPreBufferMaxS = 5;
        this.mIsAudioExist = -1;
        this.mIsVsrOpen = -1;
        this.mIsNativePausedLoadData = 0;
        this.mIsWanosAudioEffectValid = false;
        this.mLastPosition = 0;
        this.mPositionLoged = false;
        this.mRealEncodeType = -1;
        this.mStreamFormatType = -1;
        this.mNotifyHandler = new MainNotifyHandler(this);
        this.mWillOpenUrl = "";
        this.mReportedTSLAN = false;
        this.mDnsLock = new Object();
        this.mIsP2pTSSkipReport = false;
        this.mCodecName = "n";
        this.mVVbuft = -1;
        this.mEnableJAVAIPCacheMap = false;
        this.mIPCacheMap = new HashMap();
        this.mVideoFrameClockNotifyMs = -1;
        this.mVideoFrameClockNotifyType = -1;
        this.mVideoFrameClockNotifyTimeStart = -1L;
        this.mVideoFrameClockNotifyTimeEnd = -1L;
        this.mCacheReportTag = DEFAULT_CACHE_REPORT_TAG;
        this.mCacheReportLerr = 0;
        this.mEnableDnsNoNetStrategy = false;
        this.mDnsNoNetWaiter = new Object();
        this.mLastIsNetworkAvailableNNS = true;
        this.mDnsNoNetMaxRetry = 20;
        this.mLastTsSkipErrExtra = 0;
        this.fstime = "n/n";
        this.mcColorFormat = "n_n";
        this.isFlowReportEnable = false;
        this.vsri = "0|0_0|0_0";
        this.vsrver = "n";
        this.vsrvkver = "n";
        this.vsrnpuver = "n";
        this.mSourceNetListner = new MgtvPlayerListener.OnSourceNetHandledListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.4
            public static final int REPORT_HTTP_DNS_INTERRUPT = -2;
            public static final int REPORT_HTTP_DNS_PV = 0;
            private boolean mIsPauseLoad = false;

            private void checkErrorCode(int i22, int i3, Bundle bundle2) {
                if (bundle2 == null) {
                    return;
                }
                int i4 = bundle2.getInt("retry_counter");
                MgtvMediaPlayer.this.mSourceRetryCount = i4;
                MgtvMediaPlayer.this.mSourceRetryCode = i3;
                if (MgtvMediaPlayer.this.isDnsCacheEnable() && i4 >= 1 && MgtvMediaPlayer.this.checkAndCleanDnsCache(i22, i3)) {
                    MgtvMediaPlayer.this.mHttpDnsEnable = true;
                }
            }

            private boolean didHDJSwitch(Bundle bundle2) {
                if (MgtvMediaPlayer.this.mHDJSwitchUrl.length() <= 0 || bundle2 == null) {
                    return false;
                }
                bundle2.putString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_URL_STRING, MgtvMediaPlayer.this.mHDJSwitchUrl);
                bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_IS_LAST_INT, 1);
                MgtvMediaPlayer.this.mHDJSwitchUrl = "";
                return true;
            }

            private void didHostAddr(Bundle bundle2) {
                if (bundle2 == null) {
                    return;
                }
                int i22 = bundle2.getInt("host_error");
                int i3 = bundle2.getInt("host_family");
                String string = bundle2.getString("host_hostname");
                String string2 = bundle2.getString("host_ip");
                int i4 = bundle2.getInt("host_port");
                int i5 = MgtvMediaPlayer.this.mLastDnsType = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_HOST_ARRR_DNS_TYPE_INT);
                DebugLog.d(MgtvMediaPlayer.this.getLogTag(), "callback didHostAddr error:" + i22 + ",family:" + i3 + ",hostname:" + string + ",ip_list:" + string2 + ",port:" + i4 + ",hostDnsType:" + i5);
                MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                StringBuilder sb = new StringBuilder();
                sb.append(i22);
                sb.append("");
                mgtvMediaPlayer.mLastHostErr = sb.toString();
                MgtvMediaPlayer.this.mLastIpIndex = 0;
                try {
                    String[] split = string2.split(g.b);
                    MgtvMediaPlayer.this.mLastIpCount = 0;
                    if (split != null) {
                        for (String str : split) {
                            if (c.a.a.a.k.d.b(str)) {
                                MgtvMediaPlayer.access$4108(MgtvMediaPlayer.this);
                            }
                        }
                    }
                    MgtvMediaPlayer.this.mLastIps = split;
                    if (!MgtvMediaPlayer.this.mEnableJAVAIPCacheMap || i22 != 0 || MgtvMediaPlayer.this.mIPCacheMap.containsKey(string) || split == null || split.length <= 0) {
                        return;
                    }
                    IPList iPList = new IPList(string, split);
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "callback ipcache didHostAddr put:" + string + "-" + IPList.formatIPList(iPList.nUseList));
                    MgtvMediaPlayer.this.mIPCacheMap.put(string, iPList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private boolean didLiveOpen(Bundle bundle2) {
                if (bundle2 == null) {
                    return false;
                }
                return onLiveWillOpen(bundle2);
            }

            private boolean didLiveReopen(Bundle bundle2) {
                boolean z2 = MgtvMediaPlayer.this.mLiveReopen;
                if (MgtvMediaPlayer.this.mLiveReopen) {
                    MgtvMediaPlayer.this.mLiveReopen = false;
                }
                return z2;
            }

            private boolean didLoopOpen(Bundle bundle2) {
                if (bundle2 == null) {
                    return false;
                }
                return onLiveWillOpen(bundle2);
            }

            private boolean didLoopReopen(Bundle bundle2) {
                if (MgtvMediaPlayer.this.mLoopPlayerSwitchUrl.length() > 0) {
                    bundle2.putString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_URL_STRING, MgtvMediaPlayer.this.mLoopPlayerSwitchUrl);
                    MgtvMediaPlayer.this.mLoopPlayerSwitchUrl = "";
                    return true;
                }
                return false;
            }

            private void didTcpOpen(Bundle bundle2) {
                IPList iPList;
                if (bundle2 == null) {
                    return;
                }
                int i22 = bundle2.getInt("port");
                int i3 = bundle2.getInt("family");
                int i4 = bundle2.getInt("error");
                String string = bundle2.getString("ip");
                String string2 = bundle2.getString("tcp_hostname");
                long j = bundle2.getLong("switch_key");
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.i(logTag, "didTcpOpen switch_key:" + j);
                if (MgtvMediaPlayer.this.mMediaPlayer != null && MgtvMediaPlayer.this.mMediaPlayer.s() != null) {
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.i(logTag2, "didTcpOpen origin:" + MgtvMediaPlayer.this.mMediaPlayer.s());
                }
                String logTag3 = MgtvMediaPlayer.this.getLogTag();
                if (i4 != 0) {
                    DebugLog.e(logTag3, "chodison didTcpOpen port:" + i22 + ",family:" + i3 + ",error_code:" + i4 + ",ip:" + string + ",hostname:" + string2);
                } else {
                    DebugLog.i(logTag3, "chodison didTcpOpen port:" + i22 + ",family:" + i3 + ",ip:" + string + ",hostname:" + string2);
                }
                MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                mgtvMediaPlayer.mLastTcpErr = i4 + "";
                MgtvMediaPlayer.this.mLastTcpIP = string;
                MgtvMediaPlayer.access$2808(MgtvMediaPlayer.this);
                if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap) {
                    try {
                        if (!MgtvMediaPlayer.this.mIPCacheMap.containsKey(string2) || (iPList = (IPList) MgtvMediaPlayer.this.mIPCacheMap.get(string2)) == null) {
                            return;
                        }
                        String logTag4 = MgtvMediaPlayer.this.getLogTag();
                        DebugLog.i(logTag4, "callback ipcache didTcpOpen remove " + string + " from " + string2);
                        iPList.nUseList.remove(string);
                        String logTag5 = MgtvMediaPlayer.this.getLogTag();
                        DebugLog.i(logTag5, "callback ipcache didTcpOpen rest ip:" + IPList.formatIPList(iPList.nUseList));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            private boolean doNetHttpWillOpenFailed(int i22, int i3, Bundle bundle2) {
                boolean z2;
                List<String> list;
                String logTag;
                String str;
                checkErrorCode(i22, i3, bundle2);
                MgtvMediaPlayer.this.mErrorUrl = UrlUtil.getValidUrl(bundle2.getString("url"));
                int i4 = bundle2.getInt("cur_dl_dize");
                if (isInitMp4(MgtvMediaPlayer.this.mErrorUrl)) {
                    MgtvMediaPlayer.this.mIsInitMp4Error = true;
                } else {
                    MgtvMediaPlayer.this.mIsInitMp4Error = false;
                }
                int i5 = bundle2.getInt("retry_counter");
                if (UrlUtil.isFilePrefix(MgtvMediaPlayer.this.mErrorUrl) && !MgtvMediaPlayer.this.mCacheReplaceMap.isEmpty()) {
                    if (MgtvMediaPlayer.this.mOnWarningListener != null) {
                        MgtvPlayerListener.OnWarningListener onWarningListener = MgtvMediaPlayer.this.mOnWarningListener;
                        onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_TS_CACHE_SKIP, i3 + "", MgtvMediaPlayer.this.mErrorUrl, null);
                    }
                    String str2 = (String) MgtvMediaPlayer.this.mCacheReplaceMap.get(MgtvMediaPlayer.this.mErrorUrl);
                    if (str2 != null) {
                        MgtvMediaPlayer.access$7308(MgtvMediaPlayer.this);
                        MgtvMediaPlayer.this.mErrorUrl = str2;
                        bundle2.putString("url", str2);
                        String logTag2 = MgtvMediaPlayer.this.getLogTag();
                        DebugLog.i(logTag2, "doNetHttpWillOpenFailed replace local_url to " + str2);
                    }
                }
                bundle2.getString("player_hash");
                int i6 = bundle2.getInt("io_type");
                c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed url:%s,iotype:%d, RetryCount:%d,error_code:%d-%d", new Object[]{MgtvMediaPlayer.this.mErrorUrl, Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i22), Integer.valueOf(i3)});
                if (isENETUNREACHcode(i22, i3) || (MgtvMediaPlayer.this.mPrepared && isDnsError(i22, i3))) {
                    c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed network broken,RetryCount:%d,error_code:%d-%d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i22), Integer.valueOf(i3)});
                    return true;
                }
                synchronized (MgtvMediaPlayer.this.mDnsNoNetWaiter) {
                    if (!isPlayerReset() && MgtvMediaPlayer.this.mEnableDnsNoNetStrategy && isDnsError(i22, i3)) {
                        boolean d = c.a.a.b.d.d.d(MgtvMediaPlayer.this.mContext);
                        if (!d) {
                            DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 1000 in");
                            try {
                                MgtvMediaPlayer.this.mDnsNoNetWaiter.wait(1000L);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            logTag = MgtvMediaPlayer.this.getLogTag();
                            str = "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 1000 out";
                            DebugLog.i(logTag, str);
                            z2 = true;
                        } else if (!d || MgtvMediaPlayer.this.mLastIsNetworkAvailableNNS) {
                            z2 = false;
                        } else {
                            DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 3000 in");
                            try {
                                MgtvMediaPlayer.this.mDnsNoNetWaiter.wait(PayTask.j);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            logTag = MgtvMediaPlayer.this.getLogTag();
                            str = "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 3000 out";
                            DebugLog.i(logTag, str);
                            z2 = true;
                        }
                        MgtvMediaPlayer.this.mLastIsNetworkAvailableNNS = d;
                    } else {
                        z2 = false;
                    }
                }
                String logTag3 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.i(logTag3, "doNetHttpWillOpenFailed mIsLive:" + MgtvMediaPlayer.this.mIsLive + ",mPlayerMode:" + MgtvMediaPlayer.this.mPlayerMode + ",mPrepared:" + MgtvMediaPlayer.this.mPrepared + ",mIsBuffering:" + MgtvMediaPlayer.this.mIsBuffering + ",mTsNotSkip:" + MgtvMediaPlayer.this.mTsNotSkip + ",mLoadMaxRetryTime:" + MgtvMediaPlayer.this.mLoadMaxRetryTime + ",mPlayStatus:" + MgtvMediaPlayer.this.mPlayStatus + ",lip:" + MgtvMediaPlayer.this.getLastIP());
                DebugLog.ifmt(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed %d-%d-%d-%d-%s", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i22), Integer.valueOf(i3), MgtvMediaPlayer.this.mErrorUrl);
                if ((!MgtvMediaPlayer.this.mIsLive || MgtvMediaPlayer.this.isVod()) && MgtvMediaPlayer.this.mPlayerMode != 1) {
                    if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap && (i3 == 100911 || i3 == 300021 || CodeUtil.isHttp4XX(i22, i3) || CodeUtil.isHttp5XX(i22, i3))) {
                        String hostName = UrlUtil.getHostName(UrlUtil.getValidHttpUrl(bundle2.getString("url")));
                        if (!StringUtil.isEmpty(hostName) && !c.a.a.a.k.d.g(hostName) && MgtvMediaPlayer.this.mIPCacheMap.containsKey(hostName)) {
                            String logTag4 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag4, "callback ipcache will http contains host:" + hostName);
                            IPList iPList = (IPList) MgtvMediaPlayer.this.mIPCacheMap.get(hostName);
                            if (iPList != null && iPList.checkTTL() && (list = iPList.nUseList) != null && list.size() > 0) {
                                String logTag5 = MgtvMediaPlayer.this.getLogTag();
                                DebugLog.i(logTag5, "callback ipcache will http check ttl success." + iPList);
                                if (i5 >= 6) {
                                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "callback ipcache will http return false.not retry");
                                    reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                                    return false;
                                }
                                bundle2.putString("user_msg", MgtvMediaPlayer.USER_MSG_FLAG_USE_CACHE);
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "callback ipcache will http return true.try to goto ip choose");
                                reportHttpErrorPV(i5, MgtvMediaPlayer.this.mErrorUrl, i3, "ipcache");
                                return true;
                            }
                        }
                    }
                    reportHttpErrorPV(i5, MgtvMediaPlayer.this.mErrorUrl, i3, MgtvMediaPlayer.DEFAULT_CACHE_REPORT_TAG);
                    if (z2) {
                        if (i5 < MgtvMediaPlayer.this.mDnsNoNetMaxRetry) {
                            DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy retry cause by inDnsNetStrategy");
                            return true;
                        }
                        reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy skip retry cause by errorRetryCount >= mDnsNoNetMaxRetry");
                        return false;
                    } else if (!MgtvMediaPlayer.this.mPrepared) {
                        if (UrlUtil.isM3u8(MgtvMediaPlayer.this.mErrorUrl)) {
                            if (i5 >= 2) {
                                reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                                return false;
                            }
                            return true;
                        } else if (MgtvMediaPlayer.this.isSkipRetryCode(i22, i3) || !isInitMp4(MgtvMediaPlayer.this.mErrorUrl) || i4 <= 0 || i5 >= 10) {
                            if (MgtvMediaPlayer.this.isSkipRetryCode(i22, i3) || i5 >= MgtvMediaPlayer.this.mLoadMaxRetryTime) {
                                MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                                mgtvMediaPlayer.callbackTsSkip(mgtvMediaPlayer.mErrorUrl, i22, i3);
                                reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                                return false;
                            }
                            return true;
                        } else {
                            return true;
                        }
                    } else if (MgtvMediaPlayer.this.mTsNotSkip && MgtvMediaPlayer.this.isRendered()) {
                        return true;
                    }
                } else if (!MgtvMediaPlayer.this.mPrepared) {
                    if (UrlUtil.isM3u8(MgtvMediaPlayer.this.mErrorUrl)) {
                        return i5 < 2;
                    }
                    MgtvMediaPlayer mgtvMediaPlayer2 = MgtvMediaPlayer.this;
                    mgtvMediaPlayer2.callbackTsSkip(mgtvMediaPlayer2.mErrorUrl, i22, i3);
                    return false;
                } else if (MgtvMediaPlayer.this.mIsBuffering && MgtvMediaPlayer.this.isHLSPlayingUrl() && i5 >= 1) {
                    if (UrlUtil.isSegment(MgtvMediaPlayer.this.mErrorUrl)) {
                        MgtvMediaPlayer mgtvMediaPlayer3 = MgtvMediaPlayer.this;
                        mgtvMediaPlayer3.callbackTsSkip(mgtvMediaPlayer3.mErrorUrl, i22, i3);
                    }
                    return false;
                }
                if (MgtvMediaPlayer.this.isSkipRetryCode(i22, i3) || i5 >= 2) {
                    if (UrlUtil.isSegment(MgtvMediaPlayer.this.mErrorUrl)) {
                        MgtvMediaPlayer mgtvMediaPlayer4 = MgtvMediaPlayer.this;
                        mgtvMediaPlayer4.callbackTsSkip(mgtvMediaPlayer4.mErrorUrl, i22, i3);
                    }
                    reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                    return false;
                }
                return true;
            }

            private boolean doNewHttpWillOpen(Bundle bundle2) {
                int i22 = bundle2.getInt("error_type");
                int i3 = bundle2.getInt("error_code");
                bundle2.getInt("retry_counter");
                int i4 = bundle2.getInt("reset_iplist");
                MgtvMediaPlayer.this.mLastDlSize = bundle2.getInt("cur_dl_dize");
                bundle2.putString("user_msg", "init");
                if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap && i4 == 1) {
                    MgtvMediaPlayer.this.clearIPCache();
                }
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag, "doNewHttpWillOpen in error_what:" + i22 + ",error_extra:" + i3 + ",reset_iplist:" + i4 + ",mLastDlSize:" + MgtvMediaPlayer.this.mLastDlSize);
                bundle2.putInt("reset_iplist", 0);
                if (i3 == 0) {
                    MgtvMediaPlayer.this.mIsInitMp4Error = false;
                    if (i3 == 0 && MgtvMediaPlayer.this.mCacheEable) {
                        replaceUrlFromCache(bundle2);
                    }
                    return false;
                }
                boolean doNetHttpWillOpenFailed = doNetHttpWillOpenFailed(i22, i3, bundle2);
                String logTag2 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag2, "doNetHttpWillOpenFailed return " + doNetHttpWillOpenFailed + "," + i22 + "-" + i3 + "-" + MgtvMediaPlayer.this.mErrorUrl);
                return doNetHttpWillOpenFailed;
            }

            private boolean doWillGetEnv(Bundle bundle2) {
                String string = bundle2.getString("env_key");
                if (string == null || string.length() <= 0) {
                    return false;
                }
                bundle2.putString("env_value", System.getenv(string));
                return true;
            }

            private boolean doWillHostAddr(Bundle bundle2) {
                List<String> list;
                if (bundle2 == null) {
                    return false;
                }
                int i22 = bundle2.getInt("addr_handle");
                String string = bundle2.getString("player_hash");
                int i3 = bundle2.getInt("retry_counter");
                String string2 = bundle2.getString("user_msg");
                String string3 = bundle2.getString("addr_hostname");
                long j = bundle2.getLong("switch_key");
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag, "callback doWillHostAddr is_handle:" + i22 + ",hash:" + string + ",count_int:" + i3 + ",user_msg:" + string2 + ",hostname:" + string3 + ",switch_key:" + j);
                if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap && i22 != 1 && MgtvMediaPlayer.USER_MSG_FLAG_USE_CACHE.equals(string2) && !c.a.a.a.k.d.g(string3) && MgtvMediaPlayer.this.mIPCacheMap.containsKey(string3)) {
                    try {
                        IPList iPList = (IPList) MgtvMediaPlayer.this.mIPCacheMap.get(string3);
                        if (iPList != null && (list = iPList.nUseList) != null && list.size() > 0 && iPList.checkTTL()) {
                            String str = iPList.nUseList.get(0);
                            if (c.a.a.a.k.d.b(str)) {
                                String logTag2 = MgtvMediaPlayer.this.getLogTag();
                                DebugLog.i(logTag2, "callback ipcache doWillHostAddr put chooseip:" + str);
                                String formatIPList = IPList.formatIPList(iPList.nUseList);
                                if (!StringUtil.isEmpty(formatIPList)) {
                                    String logTag3 = MgtvMediaPlayer.this.getLogTag();
                                    DebugLog.d(logTag3, "callback ipcache doWillHostAddr put srcIPListStr:" + formatIPList);
                                    bundle2.putString("addr_hostname", formatIPList);
                                }
                                bundle2.putString("addr_ip", str);
                                bundle2.putInt("addr_error", 0);
                                return false;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                String string4 = bundle2.getString("addr_uri");
                if (c.a.a.a.k.d.f(string3)) {
                    String E = MgtvMediaPlayer.this.mReporter != null ? MgtvMediaPlayer.this.mReporter.E() : "0";
                    notifyIpIsLAN(E, "hostname_" + string3);
                }
                boolean g = c.a.a.a.k.d.g(string3);
                boolean d = c.a.a.b.d.d.d(MgtvMediaPlayer.this.mContext);
                String logTag4 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag4, "doWillHostAddr hostname:" + string3 + ",isIp:" + g);
                String logTag5 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag5, "doWillHostAddr is_handle=" + i22 + ",mBackJavaDns=" + MgtvMediaPlayer.this.mBackJavaDns + ",isIp=" + g + ",mForceHttpDns:" + MgtvMediaPlayer.this.mForceHttpDns);
                if ((MgtvMediaPlayer.this.mForceHttpDns && !g) || ((MgtvMediaPlayer.this.mJavaDnsEnable && !g) || (i22 == 1 && MgtvMediaPlayer.this.mBackJavaDns && !g))) {
                    if (d) {
                        MgtvMediaPlayer.this.mLastUri = string4;
                        domainResolve(string3, bundle2, MgtvMediaPlayer.this.mForceHttpDns);
                    } else {
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "skip domainResolve cause net not available");
                    }
                    return MgtvMediaPlayer.this.mPlayerReset;
                }
                if (i22 == 1 && g) {
                    bundle2.putString("addr_ip", string3);
                    bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CTRL_ARRR_DNS_TYPE_INT, 0);
                    bundle2.putInt("addr_error", 0);
                }
                return false;
            }

            private boolean doWillHttpOpen(Bundle bundle2) {
                if (bundle2 != null) {
                    MgtvMediaPlayer.this.mLastRequestUrl = UrlUtil.getValidUrl(bundle2.getString("url"));
                }
                if (MgtvMediaPlayer.this.mReportParams == null || !(MgtvMediaPlayer.this.mReportParams.getVideoType().equals(ReportParams.VideoType.AD_PRE) || MgtvMediaPlayer.this.mReportParams.getVideoType().equals(ReportParams.VideoType.AD_MID))) {
                    if (bundle2 != null) {
                        MgtvMediaPlayer.this.mWillOpenUrl = bundle2.getString("url");
                    }
                    return doNewHttpWillOpen(bundle2);
                }
                return onNormalHttpWillOpen(bundle2);
            }

            private void domainResolve(String str, Bundle bundle2, boolean z2) {
                a.d c;
                int k;
                if (str == null || bundle2 == null) {
                    DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "skip domainResolve hostname or args is null");
                    return;
                }
                a aVar = new a();
                aVar.d(new a.c() { // from class: com.hunantv.media.player.MgtvMediaPlayer.4.1
                    public void onDnsFail(a aVar2) {
                    }

                    public void onDnsFinish(a aVar2) {
                        synchronized (MgtvMediaPlayer.this.mDnsLock) {
                            MgtvMediaPlayer.this.mDnsLock.notifyAll();
                        }
                    }

                    public void onDnsStart(a aVar2) {
                    }

                    public void onDnsSuc(a aVar2, String[] strArr) {
                    }
                });
                boolean resolveStrategy = resolveStrategy(aVar, str, bundle2, z2, MgtvMediaPlayer.this.mHttpDnsNeedRetry);
                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve use:" + resolveStrategy);
                if (resolveStrategy) {
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve use type:" + aVar.c());
                    notifyHttpDnsReport(aVar.c(), MainNotifyHandler.MSG_HTTPDNS_REPORT_PV, 0);
                }
                synchronized (MgtvMediaPlayer.this.mDnsLock) {
                    while (aVar.n() && !isJavaDnsInterrupt()) {
                        DebugLog.d(MgtvMediaPlayer.this.getLogTag(), "domainResolve wait in");
                        try {
                            MgtvMediaPlayer.this.mDnsLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                DebugLog.d(MgtvMediaPlayer.this.getLogTag(), "domainResolve wait out. resolving:" + aVar.n() + ",isJavaDnsInterrupt:" + isJavaDnsInterrupt());
                String[] c2 = c.a.a.a.k.d.c(aVar.m());
                aVar.o();
                String str2 = "costMs:" + aVar.i() + ";ips:" + com.hunantv.media.utils.StringUtil.formatArrayString(c2) + ";net:" + NetPlayConfig.getNetworkType() + g.b;
                String formatIPList = IPList.formatIPList(c2);
                String str3 = null;
                if (c2 != null && c2.length > 0) {
                    str3 = c2[0];
                }
                int i22 = AnonymousClass28.$SwitchMap$com$hunantv$media$player$dns$AsyncDns$DnsType[aVar.c().ordinal()] == 1 ? 4 : 5;
                if (!isJavaDnsInterrupt() && c.a.a.a.k.d.b(str3)) {
                    if (resolveStrategy) {
                        updateCurrentDnsDsc(aVar.c());
                        if (c.a.a.a.k.d.f(str3)) {
                            notifyHttpDnsReport(aVar.c(), 2001, 100, str2);
                        } else {
                            notifyHttpDnsReport(aVar.c(), 2001, 0, str2);
                        }
                    }
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve put iplist:" + formatIPList);
                    bundle2.putString("addr_hostname", formatIPList);
                    if (c.a.a.a.k.d.b(str3)) {
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve put firstIP:" + str3);
                        bundle2.putString("addr_ip", str3);
                    }
                    bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CTRL_ARRR_DNS_TYPE_INT, i22);
                    bundle2.putInt("addr_error", 0);
                    return;
                }
                if (resolveStrategy) {
                    if (isJavaDnsInterrupt() && aVar.k() == 0) {
                        c = aVar.c();
                        k = -2;
                    } else {
                        c = aVar.c();
                        k = aVar.k();
                    }
                    notifyHttpDnsReport(c, 2002, k, str2);
                    if (!isJavaDnsInterrupt()) {
                        int a = aVar.a((int) Opcodes.IFNONNULL);
                        if (aVar.k() != 0) {
                            a = aVar.k();
                        } else if (str3 != null && !c.a.a.a.k.d.g(str3)) {
                            a = aVar.a(107);
                        }
                        int i3 = -a;
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), aVar.c() + "resolve putInt error:" + i3);
                        bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CTRL_ARRR_DNS_TYPE_INT, i22);
                        bundle2.putInt("addr_error", i3);
                    }
                }
                MgtvMediaPlayer.this.mCurrentDnsDsc = "native";
            }

            private String findTsCachPath(String str, String[] strArr) {
                if (strArr == null) {
                    return null;
                }
                try {
                    String fileName = UrlUtil.getFileName(str);
                    for (String str2 : strArr) {
                        if (str2 != null && new File(str2).getName().equals(fileName)) {
                            return str2;
                        }
                    }
                } catch (Exception unused) {
                }
                return null;
            }

            private boolean isDnsError(int i22, int i3) {
                return i3 == 300600 || i22 == 400605 || MGTVP2pDirectMediaDataSource.isP2pDirectDnsError(i22, i3);
            }

            private boolean isENETUNREACHcode(int i22, int i3) {
                return i3 == 300005 || MGTVP2pDirectMediaDataSource.getShortErrorCode(i22, i3) == 101;
            }

            private boolean isInitMp4(String str) {
                return MgtvMediaPlayer.this.isHLSPlayingUrl() && UrlUtil.isSuffixUrl(str, ".mp4");
            }

            private boolean isJavaDnsInterrupt() {
                return isPlayerReset();
            }

            private boolean isPlayerReset() {
                return MgtvMediaPlayer.this.mPlayerReset || (MgtvMediaPlayer.this.mPlayerMode == 2 && MgtvMediaPlayer.this.mLoopPlayerReset);
            }

            private void notifyHttpDnsReport(a.d dVar, int i22, int i3) {
                notifyHttpDnsReport(dVar, i22, i3, "");
            }

            private void notifyHttpDnsReport(a.d dVar, int i22, int i3, String str) {
                if (dVar != a.d.b || MgtvMediaPlayer.this.mOnWarningListener == null) {
                    return;
                }
                notifyMessage(i22, i3, str);
            }

            private void notifyIpIsLAN(String str, String str2) {
                if (MgtvMediaPlayer.this.mOnWarningListener == null || MgtvMediaPlayer.this.mReportParams == null || MgtvMediaPlayer.this.mReportParams.getVideoType() != ReportParams.VideoType.VOD) {
                    return;
                }
                if (!MgtvMediaPlayer.this.mReportedTSLAN) {
                    notifyMessage(1002, str, str2 + "_suffix_" + UrlUtil.getSuffix(MgtvMediaPlayer.this.mWillOpenUrl));
                }
                if (UrlUtil.isM3u8(MgtvMediaPlayer.this.mWillOpenUrl)) {
                    return;
                }
                MgtvMediaPlayer.this.mReportedTSLAN = true;
            }

            private void notifyMessage(int i22, int i3, String str) {
                Message message = new Message();
                message.what = i22;
                message.arg1 = i3;
                message.obj = str;
                MgtvMediaPlayer.this.mNotifyHandler.sendMessage(message);
            }

            private void notifyMessage(int i22, String str, String str2) {
                Message message = new Message();
                message.what = i22;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MainNotifyHandler.BUNDLE_STR_INFO1, str);
                bundle2.putString(MainNotifyHandler.BUNDLE_STR_INFO2, str2);
                message.setData(bundle2);
                MgtvMediaPlayer.this.mNotifyHandler.sendMessage(message);
            }

            private boolean onLiveWillOpen(Bundle bundle2) {
                int i22 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_ERROR_WHAT_INT);
                int i3 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_ERROR_EXTRA_INT);
                MgtvMediaPlayer.this.mLastRequestUrl = UrlUtil.getValidUrl(bundle2.getString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_SRC_URL_STRING));
                if (i3 != 0) {
                    MgtvMediaPlayer.this.mErrorUrl = UrlUtil.getValidUrl(bundle2.getString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_SRC_URL_STRING));
                    int i4 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_COUNTER_INT);
                    int i5 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_ERR_IO_TYPE_INT);
                    c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLiveWillOpen url:%s,iotype:%d, RetryCount:%d,error_code:%d-%d", new Object[]{MgtvMediaPlayer.this.mErrorUrl, Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i22), Integer.valueOf(i3)});
                    if (isENETUNREACHcode(i22, i3) || (MgtvMediaPlayer.this.mPrepared && isDnsError(i22, i3))) {
                        c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLiveWillOpen network broken,RetryCount:%d,error_code:%d-%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i22), Integer.valueOf(i3)});
                        return true;
                    }
                    DebugLog.ifmt(MgtvMediaPlayer.this.getLogTag(), "OnSourceNetHandledListener.CTRL_WILL_LIVE_OPEN %d-%d-%d-%d-%s", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i22), Integer.valueOf(i3), MgtvMediaPlayer.this.mErrorUrl);
                    return !MgtvMediaPlayer.this.isSkipRetryCode(i22, i3) && i4 < 2;
                }
                return false;
            }

            private boolean onLoopWillOpen(Bundle bundle2) {
                int i22 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_ERROR_WHAT_INT);
                int i3 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_ERROR_EXTRA_INT);
                if (i3 != 0) {
                    MgtvMediaPlayer.this.mErrorUrl = UrlUtil.getValidUrl(bundle2.getString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_SRC_URL_STRING));
                    int i4 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_COUNTER_INT);
                    int i5 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_ERR_IO_TYPE_INT);
                    c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLoopWillOpen url:%s,iotype:%d, RetryCount:%d,error_code:%d-%d", new Object[]{MgtvMediaPlayer.this.mErrorUrl, Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i22), Integer.valueOf(i3)});
                    if (isENETUNREACHcode(i22, i3) || (MgtvMediaPlayer.this.mPrepared && isDnsError(i22, i3))) {
                        c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLoopWillOpen network broken,RetryCount:%d,error_code:%d-%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i22), Integer.valueOf(i3)});
                        return true;
                    }
                    DebugLog.ifmt(MgtvMediaPlayer.this.getLogTag(), "OnSourceNetHandledListener.CTRL_WILL_LOOP_OPEN %d-%d-%d-%d-%s", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i22), Integer.valueOf(i3), MgtvMediaPlayer.this.mErrorUrl);
                    return !MgtvMediaPlayer.this.isSkipRetryCode(i22, i3) && i4 < 2;
                }
                return false;
            }

            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private boolean onNormalHttpWillOpen(android.os.Bundle r15) {
                /*
                    Method dump skipped, instructions count: 329
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.player.MgtvMediaPlayer.AnonymousClass4.onNormalHttpWillOpen(android.os.Bundle):boolean");
            }

            private boolean replaceUrlFromCache(Bundle bundle2) {
                String string = bundle2.getString("url");
                if (!UrlUtil.isFilePrefix(string) && !UrlUtil.isLocal(string)) {
                    String str = null;
                    String fileName = UrlUtil.getFileName(string);
                    if (StringUtil.isEmpty(fileName)) {
                        return false;
                    }
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.d(logTag, "replaceUrlFromCache try to find replace cache:" + string);
                    if (UrlUtil.isM3u8(string)) {
                        String str2 = MgtvMediaPlayer.this.mCacheM3u8Path;
                        String fileName2 = UrlUtil.getFileName(str2);
                        if (!StringUtil.isEmpty(str2) && !StringUtil.isEmpty(fileName2) && fileName2.equals(fileName)) {
                            str = str2;
                        }
                    } else if (MgtvMediaPlayer.this.isHLSPlayingUrl() && UrlUtil.isSegment(string)) {
                        str = findTsCachPath(string, MgtvMediaPlayer.this.mCacheTsPaths);
                    }
                    if (FileUtil.exist(str)) {
                        String addLocalPrefix = UrlUtil.addLocalPrefix(str);
                        if (!StringUtil.isEmpty(addLocalPrefix)) {
                            String logTag2 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag2, "replaceUrlFromCache from " + string);
                            String logTag3 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag3, "replaceUrlFromCache to " + addLocalPrefix);
                            bundle2.putString("url", addLocalPrefix);
                            if (UrlUtil.isM3u8(string)) {
                                String logTag4 = MgtvMediaPlayer.this.getLogTag();
                                DebugLog.d(logTag4, "replaceUrlFromCache put SRC_URL " + string);
                                bundle2.putString("src_url", string);
                            }
                            MgtvMediaPlayer.this.mCacheReplaceMap.put(addLocalPrefix, string);
                            return true;
                        }
                    }
                }
                return false;
            }

            private void reportHttpErrorErr(int i22, String str) {
                if ((isInitMp4(str) || UrlUtil.isM3u8(str)) && MgtvMediaPlayer.this.mReportParams != null && MgtvMediaPlayer.this.mReportParams.getVideoType() == ReportParams.VideoType.VOD && MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.NO_PROXY && MgtvMediaPlayer.this.mOnWarningListener != null) {
                    String E = MgtvMediaPlayer.this.mReporter != null ? MgtvMediaPlayer.this.mReporter.E() : MLog.a.b;
                    MgtvPlayerListener.OnWarningListener onWarningListener = MgtvMediaPlayer.this.mOnWarningListener;
                    String str2 = i22 + Consts.DOT + MgtvMediaPlayer.this.mCacheReportLerr;
                    StringBuilder sb = new StringBuilder();
                    sb.append("psuuid_");
                    sb.append(E);
                    sb.append("_render_");
                    sb.append(MgtvMediaPlayer.this.isRendered() ? "1" : "0");
                    sb.append("_url_");
                    sb.append(str);
                    sb.append("_type_");
                    sb.append(MgtvMediaPlayer.this.mCacheReportTag);
                    onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_HTTP_ERROR_ERR, str2, sb.toString(), null);
                }
            }

            private void reportHttpErrorPV(int i22, String str, int i3, String str2) {
                if (i22 == 0) {
                    MgtvMediaPlayer.this.mCacheReportTag = MgtvMediaPlayer.DEFAULT_CACHE_REPORT_TAG;
                    MgtvMediaPlayer.this.mCacheReportLerr = 0;
                }
                if (i22 == 0) {
                    if ((isInitMp4(str) || UrlUtil.isM3u8(str)) && MgtvMediaPlayer.this.mReportParams != null && MgtvMediaPlayer.this.mReportParams.getVideoType() == ReportParams.VideoType.VOD && MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.NO_PROXY && MgtvMediaPlayer.this.mOnWarningListener != null) {
                        String E = MgtvMediaPlayer.this.mReporter != null ? MgtvMediaPlayer.this.mReporter.E() : MLog.a.b;
                        MgtvMediaPlayer.this.mCacheReportTag = str2;
                        MgtvMediaPlayer.this.mCacheReportLerr = i3;
                        MgtvPlayerListener.OnWarningListener onWarningListener = MgtvMediaPlayer.this.mOnWarningListener;
                        String str3 = i3 + "";
                        StringBuilder sb = new StringBuilder();
                        sb.append("psuuid_");
                        sb.append(E);
                        sb.append("_render_");
                        sb.append(MgtvMediaPlayer.this.isRendered() ? "1" : "0");
                        sb.append("_url_");
                        sb.append(str);
                        sb.append("_type_");
                        sb.append(str2);
                        onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_HTTP_ERROR_PV, str3, sb.toString(), null);
                    }
                }
            }

            private boolean resolveStrategy(@NonNull a aVar, @NonNull String str, Bundle bundle2) {
                return resolveStrategy(aVar, str, bundle2, false, false);
            }

            private boolean resolveStrategy(@NonNull a aVar, @NonNull String str, Bundle bundle2, boolean z2, boolean z22) {
                a.d dVar;
                String logTag;
                String str2;
                if (z2 || (bundle2 != null && bundle2.getInt("addr_handle") == 1 && MgtvMediaPlayer.this.mBackJavaDns)) {
                    aVar.j(1);
                    dVar = a.d.b;
                } else {
                    if (MgtvMediaPlayer.this.isDnsCacheEnable()) {
                        if (MgtvMediaPlayer.this.mHttpDnsEnable) {
                            String a = StringUtil.isEmpty(MgtvMediaPlayer.this.mLastUri) ? null : c.a.a.a.k.e.a(MgtvMediaPlayer.this.mLastUri);
                            if (a != null && !a.trim().equals("")) {
                                logTag = MgtvMediaPlayer.this.getLogTag();
                                str2 = "resolveStrategy cache valid";
                            }
                        } else {
                            logTag = MgtvMediaPlayer.this.getLogTag();
                            str2 = "resolveStrategy cache valid and httpdns not open";
                        }
                        DebugLog.d(logTag, str2);
                        return false;
                    }
                    dVar = MgtvMediaPlayer.this.mJavaDnsType;
                }
                aVar.e(str, dVar, z22);
                return true;
            }

            private void updateCurrentDnsDsc(a.d dVar) {
                MgtvMediaPlayer mgtvMediaPlayer;
                String str;
                int i22 = AnonymousClass28.$SwitchMap$com$hunantv$media$player$dns$AsyncDns$DnsType[dVar.ordinal()];
                if (i22 == 1) {
                    mgtvMediaPlayer = MgtvMediaPlayer.this;
                    str = MgtvMediaPlayer.DNS_JAVA_NORMAL;
                } else if (i22 != 2) {
                    return;
                } else {
                    mgtvMediaPlayer = MgtvMediaPlayer.this;
                    str = MgtvMediaPlayer.DNS_JAVA_HTTPDNS;
                }
                mgtvMediaPlayer.mCurrentDnsDsc = str;
            }

            private void updateIp(String str) {
                String logTag;
                StringBuilder sb;
                String str2;
                if (MgtvMediaPlayer.this.mMediaPlayer == null || (!(MgtvMediaPlayer.this.mMediaPlayer.v() == 2 || MgtvMediaPlayer.this.mMediaPlayer.v() == 1) || MgtvMediaPlayer.this.mMediaPlayer.o4() == null)) {
                    if (MgtvMediaPlayer.this.mMediaPlayer == null || !((MgtvMediaPlayer.this.mMediaPlayer.v() == 2 || MgtvMediaPlayer.this.mMediaPlayer.v() == 1) && MgtvMediaPlayer.this.mMediaPlayer.o4() == null)) {
                        MgtvMediaPlayer.this.mLastIP = str;
                    } else {
                        MgtvMediaPlayer.this.mLastIP = "0.0.0.1";
                    }
                    logTag = MgtvMediaPlayer.this.getLogTag();
                    sb = new StringBuilder();
                    str2 = "didTcpOpen tcp_ip:";
                } else {
                    MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                    mgtvMediaPlayer.mLastIP = P2pMgr.getCdnIpFromP2PTask(mgtvMediaPlayer.mMediaPlayer.o4());
                    logTag = MgtvMediaPlayer.this.getLogTag();
                    sb = new StringBuilder();
                    str2 = "didTcpOpen p2p QueryTaskInfo cdnIp:";
                }
                sb.append(str2);
                sb.append(MgtvMediaPlayer.this.mLastIP);
                DebugLog.d(logTag, sb.toString());
            }

            private void willTcpOpen(Bundle bundle2) {
                if (bundle2 == null) {
                    return;
                }
                String string = bundle2.getString("tcp_hostname");
                String string2 = bundle2.getString("ip");
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag, "callback willTcpOpen tcp_hostname:" + string + ",tcp_ip:" + string2);
                MgtvMediaPlayer.this.mLastHostIP = string2;
                updateIp(string2);
                if (string2 == null || string2.length() <= 1 || !c.a.a.a.k.d.f(string2)) {
                    return;
                }
                notifyIpIsLAN("1", MgtvMediaPlayer.this.getCurrentDnsDsc() + "_hostip_" + string2);
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSourceNetHandledListener
            public boolean onSourceNetCtrl(int i22, Bundle bundle2) {
                IP2pTask o4;
                c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "OnSourceNetHandledListener.onSourceNetCtrl 0x%5x", new Object[]{Integer.valueOf(i22)});
                switch (i22) {
                    case 131073:
                        willTcpOpen(bundle2);
                        break;
                    case 131074:
                        didTcpOpen(bundle2);
                        break;
                    case 131075:
                        return doWillHttpOpen(bundle2);
                    case 131077:
                        return didLiveOpen(bundle2);
                    case 131078:
                        return doWillHostAddr(bundle2);
                    case 131081:
                        return didLiveReopen(bundle2);
                    case 131088:
                        return didLoopOpen(bundle2);
                    case 131089:
                        return didLoopReopen(bundle2);
                    case 131090:
                        return didHDJSwitch(bundle2);
                    case 131104:
                        return doWillGetEnv(bundle2);
                    case 131120:
                        if (MgtvMediaPlayer.this.mPreBufferState.isEnable() && MgtvMediaPlayer.this.mPreBufferState.getState() == 2) {
                            this.mIsPauseLoad = true;
                            return true;
                        } else if (MgtvMediaPlayer.this.isSourceSwitching() || MgtvMediaPlayer.this.mMediaPlayer == null || (!(MgtvMediaPlayer.this.mMediaPlayer.v() == 2 || MgtvMediaPlayer.this.mMediaPlayer.v() == 1) || (o4 = MgtvMediaPlayer.this.mMediaPlayer.o4()) == null || o4.getStatus() == 0)) {
                            if (this.mIsPauseLoad) {
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "CTRL_WILL_CHECK_PAUSE_LOAD will return false. will resume load");
                            }
                            this.mIsPauseLoad = false;
                            return false;
                        } else {
                            if (!this.mIsPauseLoad) {
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "CTRL_WILL_CHECK_PAUSE_LOAD will return true. will pause load");
                            }
                            this.mIsPauseLoad = true;
                            return true;
                        }
                    case 131184:
                        synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                            if (bundle2 == null) {
                                break;
                            } else if (bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_NEED_RETRY_INT) == 1) {
                                if (MgtvMediaPlayer.this.mReporter != null) {
                                    MgtvMediaPlayer.this.mReporter.M();
                                }
                                int i3 = (int) bundle2.getLong(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_RETRY_KEY_LONG);
                                SmoothMediaSource smoothMediaSource = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i3));
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth need_retry == 1 find:" + i3);
                                if (smoothMediaSource != null) {
                                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth need_retry == 1 , will retry use :" + smoothMediaSource.getUrl());
                                    bundle2.putString("smooth_switch_url", smoothMediaSource.getUrl());
                                    if (smoothMediaSource.getReporter() != null) {
                                        smoothMediaSource.getReporter().H();
                                        if (MgtvMediaPlayer.this.mReportParams != null) {
                                            MgtvMediaPlayer.this.mReportParams.setPlaySessionId(smoothMediaSource.getReporter().E());
                                        }
                                    }
                                } else {
                                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth need_retry == 1, not found source");
                                }
                                bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_NEED_RETRY_INT, 0);
                                return true;
                            } else {
                                int i4 = (int) bundle2.getLong("smooth_switch_key");
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth CTRL_WILL_SMOOTH_SWITCH switch_key:" + i4);
                                SmoothMediaSource matchLastKeySource = MgtvMediaPlayer.this.matchLastKeySource(i4);
                                if (matchLastKeySource != null) {
                                    if (matchLastKeySource.isLastRetry() && MgtvMediaPlayer.this.mReportParams != null && (MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.ONLY_P2P || MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.P2P_DRM)) {
                                        SmoothMediaSource smoothMediaSource2 = new SmoothMediaSource(MgtvMediaPlayer.this.getPlayingOriginUrl());
                                        smoothMediaSource2.setReportParams(MgtvMediaPlayer.this.mReportParams);
                                        smoothMediaSource2.bind(MgtvMediaPlayer.this);
                                        smoothMediaSource2.setThrowErrorIfSwitchFailed(true);
                                        MgtvMediaPlayer.this.mSmoothSourcesRecord.put(Integer.valueOf(smoothMediaSource2.getKey()), smoothMediaSource2);
                                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth is last retry. will retry key:" + smoothMediaSource2.getKey());
                                        bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_NEED_RETRY_INT, 1);
                                        bundle2.putLong(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_RETRY_KEY_LONG, smoothMediaSource2.getKey());
                                    }
                                    if (!matchLastKeySource.isLastRetry()) {
                                        String string = bundle2.getString("smooth_switch_url");
                                        bundle2.putString("smooth_switch_url", string);
                                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth CTRL_WILL_SMOOTH_SWITCH switch_url:" + string);
                                        if (!StringUtil.isEmpty(string)) {
                                            int indexOf = string.indexOf(",mgtvjsource:");
                                            String substring = indexOf >= 0 ? string.substring(indexOf) : "";
                                            boolean onSwitchSmoothSourceWillUpdate = MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener != null ? MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener.onSwitchSmoothSourceWillUpdate(matchLastKeySource) : false;
                                            if (matchLastKeySource.getReadType() != 2 && onSwitchSmoothSourceWillUpdate && !StringUtil.isEmpty(matchLastKeySource.useUpdateUrl())) {
                                                String str = matchLastKeySource.useUpdateUrl() + substring;
                                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth CTRL_WILL_SMOOTH_SWITCH will update url:" + str);
                                                bundle2.putString("smooth_switch_url", str);
                                            }
                                        }
                                    }
                                }
                                SmoothMediaSource smoothMediaSource3 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i4));
                                if (smoothMediaSource3 != null && smoothMediaSource3.getReporter() != null) {
                                    smoothMediaSource3.getReporter().H();
                                    if (MgtvMediaPlayer.this.mReportParams != null) {
                                        MgtvMediaPlayer.this.mReportParams.setPlaySessionId(smoothMediaSource3.getReporter().E());
                                    }
                                }
                                return true;
                            }
                        }
                        break;
                }
                return false;
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSourceNetHandledListener
            public void onSourceNetEvent(int i22, Bundle bundle2) {
                if (i22 != 78338) {
                    return;
                }
                didHostAddr(bundle2);
            }
        };
        this.mLogTagKey = "";
        this.mEnableReport = true;
        this.p2pLocker = new Object();
        this.mSeekStartMs = -1L;
        this.mHw2SwType = Hw2SwType.NONE;
        this.mPlaybackSpeed = 1.0f;
        this.mRecordMaxPlaySpeed = 1.0f;
        this.mFrameListener = new MgtvPlayerListener.OnFrameListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.22
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnFrameListener
            public void onVFrameClockCome(MgtvPlayerListener.FrameClock frameClock) {
                synchronized (MgtvMediaPlayer.this.ptsLocker) {
                    WeakHandler weakHandler = MgtvMediaPlayer.this.ptsWeakHandler;
                    if (weakHandler != null) {
                        weakHandler.removeMessages(256);
                        Message message = new Message();
                        message.what = 256;
                        message.obj = frameClock;
                        MgtvMediaPlayer.this.ptsWeakHandler.sendMessage(message);
                    }
                    if (MgtvMediaPlayer.this.mOnFrameListener != null) {
                        MgtvMediaPlayer.this.mOnFrameListener.onVFrameClockCome(frameClock);
                    }
                }
            }
        };
        this.mInnerFlowDataStatistic = new FlowDataStatistic();
        this.mEnableImgoVsr = false;
        this.mLoopSourceKey = new AtomicInteger(1);
        this.mSubtitleSources = new ArrayList();
        this.ptsHandlerThread = null;
        this.ptsWeakHandler = null;
        this.ptsListeners = new HashSet();
        this.ptsLocker = new Object();
        this.mSmoothSourceListener = new d.n() { // from class: com.hunantv.media.player.MgtvMediaPlayer.26
            public int lastSwitchingKey = -1;

            public void onSmoothSwitchSourceComplete(d dVar, int i22, int i3, String str) {
                SmoothMediaSource smoothMediaSource;
                synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.d(logTag, "onSmoothSwitchSourceComplete (type:" + i3 + ",key:" + i22 + ",msg:" + str + ")");
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSmoothSwitchSourceComplete current: ");
                    sb.append(MgtvMediaPlayer.this.getCurrentSmoothSourceKey());
                    DebugLog.i(logTag2, sb.toString());
                    for (Map.Entry entry : MgtvMediaPlayer.this.mSmoothSourcesRecord.entrySet()) {
                        if (((Integer) entry.getKey()).intValue() < i22 && (smoothMediaSource = (SmoothMediaSource) entry.getValue()) != null && !smoothMediaSource.isReleased()) {
                            smoothMediaSource.release();
                        }
                    }
                    MgtvMediaPlayer.this.mSmoothUseP2pFailed = false;
                    if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                        MgtvMediaPlayer.this.mMediaPlayer.k2(false);
                    }
                    SmoothMediaSource smoothMediaSource2 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i22));
                    if (smoothMediaSource2 != null) {
                        if (!StringUtil.isEmpty(smoothMediaSource2.getVfps())) {
                            MgtvMediaPlayer.this.mRecordVfps = Float.parseFloat(smoothMediaSource2.getVfps());
                        }
                        MgtvMediaPlayer.this.mLastVideoWidth = smoothMediaSource2.getVideoWidth();
                        MgtvMediaPlayer.this.mLastVideoHeight = smoothMediaSource2.getVideoHeight();
                        if (MgtvMediaPlayer.this.mReporter != null) {
                            MgtvMediaPlayer.this.mReporter.M();
                        }
                        MgtvMediaPlayer.this.mReporter = smoothMediaSource2.getReporter();
                        if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                            MgtvMediaPlayer.this.mMediaPlayer.o0(MgtvMediaPlayer.this.mReporter);
                            MgtvMediaPlayer.this.mMediaPlayer.A0(smoothMediaSource2.getReadType(), smoothMediaSource2.getUrl(), smoothMediaSource2.getPlayingUrl());
                            MgtvMediaPlayer.this.mMediaPlayer.N1(smoothMediaSource2.getEnableImgoAIQE());
                        }
                        if (MgtvMediaPlayer.this.mDataSourceInfo != null) {
                            MgtvMediaPlayer.this.mDataSourceInfo.setVideoFormat(smoothMediaSource2.getVideoFormat());
                            MgtvMediaPlayer.this.mDataSourceInfo.setAudioFormat(smoothMediaSource2.getAudioFormat());
                            MgtvMediaPlayer.this.mDataSourceInfo.setFileFormat(smoothMediaSource2.getFileFormat());
                        }
                        if (MgtvMediaPlayer.this.mReporter != null) {
                            MgtvMediaPlayer.this.mReportParams.deepCopy(smoothMediaSource2.getReportParams());
                            MgtvMediaPlayer.this.mReporter.n(MgtvMediaPlayer.this.mReportParams);
                            MgtvMediaPlayer.this.mReporter.N();
                        }
                        String keyFrameMapKey = MgtvMediaPlayer.this.getKeyFrameMapKey(smoothMediaSource2.getVid(), smoothMediaSource2.getDef());
                        if (MgtvMediaPlayer.this.mSmoothKeyFrameMap.containsKey(keyFrameMapKey)) {
                            String logTag3 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag3, "find smoothKeyFrameKey :" + keyFrameMapKey + " set to player");
                            byte[] bArr = MgtvMediaPlayer.this.mSmoothKeyFrameMap.get(keyFrameMapKey);
                            if (KeyFrameInfoUtils.isKeyFrameDataValid(bArr, smoothMediaSource2.videoFileHash) == 0) {
                                MgtvMediaPlayer.this.setKeyFrameInfoFileBuf(bArr);
                            }
                        }
                    }
                    SmoothMediaSource matchLastKeySource = MgtvMediaPlayer.this.matchLastKeySource(i22);
                    if (matchLastKeySource == null) {
                        DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "onSmoothSwitchSourceComplete matchKeySource failed");
                        return;
                    }
                    if (matchLastKeySource.getSwitchMod() == 1) {
                        MgtvMediaPlayer.this.mMediaPlayer.w2(true);
                    }
                    MgtvMediaPlayer.this.mSwitchedSmoothSource = matchLastKeySource;
                    MgtvMediaPlayer.this.mSourceSwitchingComplete = true;
                    MgtvMediaPlayer.this.mSourceSwitching = false;
                    if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                        MgtvMediaPlayer.this.mMainFlowReportProcessor = matchLastKeySource.getFlowReportProcessor();
                        MgtvMediaPlayer.this.mMediaPlayer.L0(matchLastKeySource.getP2pTask());
                        MgtvMediaPlayer.this.mMediaPlayer.j3(matchLastKeySource.getReadType());
                    }
                    MgtvMediaPlayer.this.mSmoothKeyFrameMap.clear();
                    if (MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener != null) {
                        MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener.onSwitchSmoothSourceSuccess(matchLastKeySource);
                    }
                }
            }

            public void onSmoothSwitchSourceFailed(d dVar, int i22, int i3, String str) {
                String[] split;
                synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.e(logTag, "onSmoothSwitchSourceFailed (type:" + i3 + ",key:" + i22 + ",msg:" + str + ")");
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSmoothSwitchSourceFailed current: ");
                    sb.append(MgtvMediaPlayer.this.getCurrentSmoothSourceKey());
                    DebugLog.e(logTag2, sb.toString());
                    int i4 = MgtvMediaPlayer.WHAT_SMOOTHSOURCE_FAIL;
                    int i5 = -1;
                    try {
                        if (!StringUtil.isEmpty(str) && (split = str.split("-")) != null && split.length >= 2) {
                            i4 = NumericUtil.parseInt(split[0]);
                            i5 = NumericUtil.parseInt(split[1]);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    SmoothMediaSource smoothMediaSource = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i22));
                    if (smoothMediaSource != null) {
                        if (smoothMediaSource.getReporter() != null) {
                            smoothMediaSource.getReporter().l(i4, i5, "");
                        }
                        if (MgtvMediaPlayer.this.mReportParams != null) {
                            String logTag3 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag3, "onSmoothSwitchSourceFailed mReportParams:" + MgtvMediaPlayer.this.mReportParams.getProxyType() + "-" + MgtvMediaPlayer.this.mReportParams.getP2ps());
                        }
                        if (smoothMediaSource.getReportParams() != null) {
                            String logTag4 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag4, "onSmoothSwitchSourceFailed currentSource.getReportParams():" + smoothMediaSource.getReportParams().getProxyType() + "-" + smoothMediaSource.getReportParams().getP2ps());
                        }
                        if (MgtvMediaPlayer.this.mReportParams != null && MgtvMediaPlayer.this.mReportParams.isP2p() && smoothMediaSource.getReportParams() != null && smoothMediaSource.getReportParams().isP2p()) {
                            MgtvMediaPlayer.this.mSmoothUseP2pFailed = true;
                            if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                                MgtvMediaPlayer.this.mMediaPlayer.k2(true);
                            }
                        }
                        if (smoothMediaSource.isThrowErrorIfSwitchFailed()) {
                            MgtvMediaPlayer.this.mErrorListener.onError(MgtvMediaPlayer.WHAT_SMOOTHSOURCE_EX_ERROR, i5);
                            return;
                        }
                    }
                    if (i3 == 1) {
                        MgtvMediaPlayer.this.mErrorListener.onError(i4, i5);
                        return;
                    }
                    SmoothMediaSource matchLastKeySource = MgtvMediaPlayer.this.matchLastKeySource(i22);
                    if (matchLastKeySource == null) {
                        DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "onSmoothSwitchSourceFailed matchKeySource failed");
                    } else {
                        MgtvMediaPlayer.this.notifySwitchSmoothSourceFail(matchLastKeySource, i4, i5);
                    }
                }
            }

            public void onSmoothSwitchSourceInfo(d dVar, int i22, int i3, String str) {
                synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.i(logTag, "onSmoothSwitchSourceInfo (event:" + i3 + ",key:" + i22 + ",msg:" + str + ")");
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSmoothSwitchSourceInfo current: ");
                    sb.append(MgtvMediaPlayer.this.getCurrentSmoothSourceKey());
                    DebugLog.i(logTag2, sb.toString());
                    SmoothMediaSource smoothMediaSource = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i22));
                    if (smoothMediaSource != null) {
                        if (i3 == 0) {
                            smoothMediaSource.s_event_0_timestamp = System.currentTimeMillis();
                        } else if (i3 == 11) {
                            smoothMediaSource.s_event_11_timestamp = System.currentTimeMillis();
                        } else if (i3 == 2) {
                            if (MgtvMediaPlayer.this.isFlowReportEnable) {
                                smoothMediaSource.genFlowReporter();
                            }
                            smoothMediaSource.s_event_2_timestamp = System.currentTimeMillis();
                        } else if (i3 == 3) {
                            if (MgtvMediaPlayer.this.isFlowReportEnable && MgtvMediaPlayer.this.mMainFlowReportProcessor != null) {
                                MgtvMediaPlayer.this.mMainFlowReportProcessor.stop();
                            }
                            for (Map.Entry entry : MgtvMediaPlayer.this.mSmoothSourcesRecord.entrySet()) {
                                if (((Integer) entry.getKey()).intValue() < smoothMediaSource.getKey()) {
                                    SmoothMediaSource smoothMediaSource2 = (SmoothMediaSource) entry.getValue();
                                    if (MgtvMediaPlayer.this.isFlowReportEnable && smoothMediaSource2 != null && smoothMediaSource2.getFlowReportProcessor() != null) {
                                        smoothMediaSource2.getFlowReportProcessor().stop();
                                    }
                                }
                            }
                            smoothMediaSource.s_event_3_timestamp = System.currentTimeMillis();
                        }
                    }
                    if (i3 != 3) {
                        if (MgtvMediaPlayer.this.matchLastKeySource(i22) == null) {
                            DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "onSmoothSwitchSourceInfo matchKeySource failed");
                            return;
                        }
                        if (i3 == 0) {
                            MgtvMediaPlayer.this.mSourceSwitching = true;
                        }
                        return;
                    }
                    SmoothMediaSource smoothMediaSource3 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(this.lastSwitchingKey));
                    if (smoothMediaSource3 != null && smoothMediaSource3.getReporter() != null) {
                        smoothMediaSource3.getReporter().M();
                    }
                    this.lastSwitchingKey = i22;
                    SmoothMediaSource smoothMediaSource4 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i22));
                    if (smoothMediaSource4 != null && MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener != null) {
                        MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener.onSwitchSmoothSourceInfo(smoothMediaSource4, i3);
                    }
                }
            }
        };
        this.mSmoothSourcesRecord = new HashMap();
        this.mSwitchSmoothSourceLocker = new Object();
        this.mSmoothUseP2pFailed = false;
        this.mSmoothKeyFrameMap = Collections.synchronizedMap(new HashMap());
        this.isBackground = false;
        this.isSpaceAudioSwitchOn = false;
        this.mBundle = bundle;
        this.mPlayerMode = i2;
        extractBundleData();
        init(i, context, z);
    }

    public MgtvMediaPlayer(int i, Context context, boolean z, Bundle bundle) throws UnsatisfiedLinkError, SecurityException, NullPointerException, OutOfMemoryError {
        this.mDebug = false;
        this.mPreBufferTimeoutMs = 1800000;
        this.mBufferTimeoutMs = 180000;
        this.mImgoMediaPlayerAudioMode = false;
        this.mAccurateSeekEnable = true;
        this.mAccSeekKeyFrameInterval = 1000;
        this.mKeyframeSeekEnable = false;
        this.mInnerAutoRotateEnable = false;
        this.mWeakBufferSpeedKB = 1;
        this.mWeakBufferTimeoutMs = 120000;
        this.mTsNotSkip = false;
        this.mLoadMaxRetryTime = 2;
        this.mPrepared = false;
        this.mIsBuffering = false;
        this.mErrorUrl = "";
        this.mLastRequestUrl = "";
        this.mLastDlSize = 0;
        this.mIsLive = false;
        this.mPlayerMode = 0;
        this.mLiveReopen = false;
        this.mLoopPlayerSwitchUrl = "";
        this.mHDJSwitchUrl = "";
        this.mDataSourceType = DataSourceType.TYPE_DATASOUCE_DEFAULT;
        this.mErrorExtraCodeStore = -1;
        this.mRecordVfps = 0.0f;
        this.mLastVideoWidth = 0;
        this.mLastVideoHeight = 0;
        this.mSkipLoopFilterType = SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mAddrinfoType = AddrinfoType.TYPE_ADDRINFO_DEFAULT;
        this.mAddrinfoTimeoutMs = 0;
        this.mPrepared4StartMode = Prepared4StartMode.MODE_PREPARED4START_DEFAULT;
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.2
            private boolean needInnerRetry(int i22, int i3) {
                return !MgtvMediaPlayer.this.mIsInnerRetrying && MgtvMediaPlayer.this.mMediaPlayer.b4() == 2 && i22 == 200003 && i3 == 100606;
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i22, int i3) {
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.i(logTag, "onError what:" + i22 + ",extra:" + i3 + ",netType:" + NetPlayConfig.getNetworkType());
                if (MgtvMediaPlayer.this.mGifRecorder != null) {
                    MgtvMediaPlayer.this.mGifRecorder.interrupt(101);
                }
                if (MgtvMediaPlayer.this.isDnsCacheEnable()) {
                    MgtvMediaPlayer.this.checkAndCleanDnsCache(i22, i3);
                }
                if (needInnerRetry(i22, i3)) {
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "onError needInnerRetry");
                    MgtvMediaPlayer.this.mIsInnerRetrying = true;
                    MgtvMediaPlayer.this.mRetryLastErrorCode = i3;
                    MgtvMediaPlayer.this.setPlayerReset(true);
                    if (MgtvMediaPlayer.this.mMediaPlayer.b0()) {
                        MgtvMediaPlayer.this.mMediaPlayer.v1(MgtvMediaPlayer.this.mMediaPlayer.t(), i22, i3, MgtvMediaPlayer.this.mMediaPlayer.b4());
                    } else {
                        MgtvMediaPlayer.this.mMediaPlayer.u1(MgtvMediaPlayer.this.mMediaPlayer.t(), i22, i3);
                    }
                    return true;
                }
                MgtvMediaPlayer.this.beforeThrowError(i22, i3);
                MgtvMediaPlayer.this.reportErrorWarning(i22, i3);
                if (i22 != 7000006) {
                    MgtvMediaPlayer.this.reportError(i22, i3, "");
                }
                MgtvMediaPlayer.this.stopTickers();
                MgtvMediaPlayer.this.mPlayStatus = PlayStatus.ERROR;
                MgtvMediaPlayer.this.mErrorExtraCodeStore = i3;
                if (MgtvMediaPlayer.this.mOnErrorListener != null) {
                    return MgtvMediaPlayer.this.mOnErrorListener.onError(i22, i3);
                }
                return true;
            }
        };
        this.mIsGetPositionCallback = false;
        this.mPlayStatus = PlayStatus.IDLE;
        this.mRenderType = RenderType.NATIVE_WINDOW;
        this.mPlayTicker = new ExTicker(1000).setTypeStr("play");
        this.mBufferTick = new ExTicker(1000).setTypeStr("buffer");
        this.mPlayerType = 2;
        this.mMainThreadID = -1L;
        this.mCacheReplaceMap = new LinkedHashMap();
        this.mIsInnerRetrying = false;
        this.mRetryLastErrorCode = 0;
        this.mRenderDisableWarnSended = false;
        this.mForceHttpDns = false;
        this.mHttpDnsNeedRetry = false;
        this.mJavaDnsEnable = false;
        this.mJavaDnsType = a.d.b;
        this.mHttpDnsEnable = false;
        this.mPlayerReset = true;
        this.mLoopPlayerReset = true;
        this.mLastUri = null;
        this.mLastHostErr = MLog.a.b;
        this.mLastTcpErr = MLog.a.b;
        this.mLastIpCount = 0;
        this.mLastIpIndex = -1;
        this.mLastDnsType = -1;
        this.mCurrentDnsDsc = "native";
        this.mEnableP2PHttpDns = false;
        this.mForceP2pHttpDns = false;
        this.mDnsThreadManager = new c().b(new c.c() { // from class: com.hunantv.media.player.MgtvMediaPlayer.3
            public void updateIPs(String str, List<String> list) {
                P2pMgr.YfAddBackupIps(str, list, MgtvMediaPlayer.this.mForceP2pHttpDns);
            }
        });
        this.mAVSyncErrReported = false;
        this.mAVSyncErrSumReported = false;
        this.mAVSyncErrSum = 0;
        this.mAVSyncStartTimestamp = 0L;
        this.mPrepareAsyncTimeStampMs = 0L;
        this.mPreBufferState = new SyncStateMachine(1);
        this.mPreBufferMaxS = 5;
        this.mIsAudioExist = -1;
        this.mIsVsrOpen = -1;
        this.mIsNativePausedLoadData = 0;
        this.mIsWanosAudioEffectValid = false;
        this.mLastPosition = 0;
        this.mPositionLoged = false;
        this.mRealEncodeType = -1;
        this.mStreamFormatType = -1;
        this.mNotifyHandler = new MainNotifyHandler(this);
        this.mWillOpenUrl = "";
        this.mReportedTSLAN = false;
        this.mDnsLock = new Object();
        this.mIsP2pTSSkipReport = false;
        this.mCodecName = "n";
        this.mVVbuft = -1;
        this.mEnableJAVAIPCacheMap = false;
        this.mIPCacheMap = new HashMap();
        this.mVideoFrameClockNotifyMs = -1;
        this.mVideoFrameClockNotifyType = -1;
        this.mVideoFrameClockNotifyTimeStart = -1L;
        this.mVideoFrameClockNotifyTimeEnd = -1L;
        this.mCacheReportTag = DEFAULT_CACHE_REPORT_TAG;
        this.mCacheReportLerr = 0;
        this.mEnableDnsNoNetStrategy = false;
        this.mDnsNoNetWaiter = new Object();
        this.mLastIsNetworkAvailableNNS = true;
        this.mDnsNoNetMaxRetry = 20;
        this.mLastTsSkipErrExtra = 0;
        this.fstime = "n/n";
        this.mcColorFormat = "n_n";
        this.isFlowReportEnable = false;
        this.vsri = "0|0_0|0_0";
        this.vsrver = "n";
        this.vsrvkver = "n";
        this.vsrnpuver = "n";
        this.mSourceNetListner = new MgtvPlayerListener.OnSourceNetHandledListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.4
            public static final int REPORT_HTTP_DNS_INTERRUPT = -2;
            public static final int REPORT_HTTP_DNS_PV = 0;
            private boolean mIsPauseLoad = false;

            private void checkErrorCode(int i22, int i3, Bundle bundle2) {
                if (bundle2 == null) {
                    return;
                }
                int i4 = bundle2.getInt("retry_counter");
                MgtvMediaPlayer.this.mSourceRetryCount = i4;
                MgtvMediaPlayer.this.mSourceRetryCode = i3;
                if (MgtvMediaPlayer.this.isDnsCacheEnable() && i4 >= 1 && MgtvMediaPlayer.this.checkAndCleanDnsCache(i22, i3)) {
                    MgtvMediaPlayer.this.mHttpDnsEnable = true;
                }
            }

            private boolean didHDJSwitch(Bundle bundle2) {
                if (MgtvMediaPlayer.this.mHDJSwitchUrl.length() <= 0 || bundle2 == null) {
                    return false;
                }
                bundle2.putString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_URL_STRING, MgtvMediaPlayer.this.mHDJSwitchUrl);
                bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_IS_LAST_INT, 1);
                MgtvMediaPlayer.this.mHDJSwitchUrl = "";
                return true;
            }

            private void didHostAddr(Bundle bundle2) {
                if (bundle2 == null) {
                    return;
                }
                int i22 = bundle2.getInt("host_error");
                int i3 = bundle2.getInt("host_family");
                String string = bundle2.getString("host_hostname");
                String string2 = bundle2.getString("host_ip");
                int i4 = bundle2.getInt("host_port");
                int i5 = MgtvMediaPlayer.this.mLastDnsType = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_HOST_ARRR_DNS_TYPE_INT);
                DebugLog.d(MgtvMediaPlayer.this.getLogTag(), "callback didHostAddr error:" + i22 + ",family:" + i3 + ",hostname:" + string + ",ip_list:" + string2 + ",port:" + i4 + ",hostDnsType:" + i5);
                MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                StringBuilder sb = new StringBuilder();
                sb.append(i22);
                sb.append("");
                mgtvMediaPlayer.mLastHostErr = sb.toString();
                MgtvMediaPlayer.this.mLastIpIndex = 0;
                try {
                    String[] split = string2.split(g.b);
                    MgtvMediaPlayer.this.mLastIpCount = 0;
                    if (split != null) {
                        for (String str : split) {
                            if (c.a.a.a.k.d.b(str)) {
                                MgtvMediaPlayer.access$4108(MgtvMediaPlayer.this);
                            }
                        }
                    }
                    MgtvMediaPlayer.this.mLastIps = split;
                    if (!MgtvMediaPlayer.this.mEnableJAVAIPCacheMap || i22 != 0 || MgtvMediaPlayer.this.mIPCacheMap.containsKey(string) || split == null || split.length <= 0) {
                        return;
                    }
                    IPList iPList = new IPList(string, split);
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "callback ipcache didHostAddr put:" + string + "-" + IPList.formatIPList(iPList.nUseList));
                    MgtvMediaPlayer.this.mIPCacheMap.put(string, iPList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private boolean didLiveOpen(Bundle bundle2) {
                if (bundle2 == null) {
                    return false;
                }
                return onLiveWillOpen(bundle2);
            }

            private boolean didLiveReopen(Bundle bundle2) {
                boolean z2 = MgtvMediaPlayer.this.mLiveReopen;
                if (MgtvMediaPlayer.this.mLiveReopen) {
                    MgtvMediaPlayer.this.mLiveReopen = false;
                }
                return z2;
            }

            private boolean didLoopOpen(Bundle bundle2) {
                if (bundle2 == null) {
                    return false;
                }
                return onLiveWillOpen(bundle2);
            }

            private boolean didLoopReopen(Bundle bundle2) {
                if (MgtvMediaPlayer.this.mLoopPlayerSwitchUrl.length() > 0) {
                    bundle2.putString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_URL_STRING, MgtvMediaPlayer.this.mLoopPlayerSwitchUrl);
                    MgtvMediaPlayer.this.mLoopPlayerSwitchUrl = "";
                    return true;
                }
                return false;
            }

            private void didTcpOpen(Bundle bundle2) {
                IPList iPList;
                if (bundle2 == null) {
                    return;
                }
                int i22 = bundle2.getInt("port");
                int i3 = bundle2.getInt("family");
                int i4 = bundle2.getInt("error");
                String string = bundle2.getString("ip");
                String string2 = bundle2.getString("tcp_hostname");
                long j = bundle2.getLong("switch_key");
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.i(logTag, "didTcpOpen switch_key:" + j);
                if (MgtvMediaPlayer.this.mMediaPlayer != null && MgtvMediaPlayer.this.mMediaPlayer.s() != null) {
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.i(logTag2, "didTcpOpen origin:" + MgtvMediaPlayer.this.mMediaPlayer.s());
                }
                String logTag3 = MgtvMediaPlayer.this.getLogTag();
                if (i4 != 0) {
                    DebugLog.e(logTag3, "chodison didTcpOpen port:" + i22 + ",family:" + i3 + ",error_code:" + i4 + ",ip:" + string + ",hostname:" + string2);
                } else {
                    DebugLog.i(logTag3, "chodison didTcpOpen port:" + i22 + ",family:" + i3 + ",ip:" + string + ",hostname:" + string2);
                }
                MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                mgtvMediaPlayer.mLastTcpErr = i4 + "";
                MgtvMediaPlayer.this.mLastTcpIP = string;
                MgtvMediaPlayer.access$2808(MgtvMediaPlayer.this);
                if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap) {
                    try {
                        if (!MgtvMediaPlayer.this.mIPCacheMap.containsKey(string2) || (iPList = (IPList) MgtvMediaPlayer.this.mIPCacheMap.get(string2)) == null) {
                            return;
                        }
                        String logTag4 = MgtvMediaPlayer.this.getLogTag();
                        DebugLog.i(logTag4, "callback ipcache didTcpOpen remove " + string + " from " + string2);
                        iPList.nUseList.remove(string);
                        String logTag5 = MgtvMediaPlayer.this.getLogTag();
                        DebugLog.i(logTag5, "callback ipcache didTcpOpen rest ip:" + IPList.formatIPList(iPList.nUseList));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            private boolean doNetHttpWillOpenFailed(int i22, int i3, Bundle bundle2) {
                boolean z2;
                List<String> list;
                String logTag;
                String str;
                checkErrorCode(i22, i3, bundle2);
                MgtvMediaPlayer.this.mErrorUrl = UrlUtil.getValidUrl(bundle2.getString("url"));
                int i4 = bundle2.getInt("cur_dl_dize");
                if (isInitMp4(MgtvMediaPlayer.this.mErrorUrl)) {
                    MgtvMediaPlayer.this.mIsInitMp4Error = true;
                } else {
                    MgtvMediaPlayer.this.mIsInitMp4Error = false;
                }
                int i5 = bundle2.getInt("retry_counter");
                if (UrlUtil.isFilePrefix(MgtvMediaPlayer.this.mErrorUrl) && !MgtvMediaPlayer.this.mCacheReplaceMap.isEmpty()) {
                    if (MgtvMediaPlayer.this.mOnWarningListener != null) {
                        MgtvPlayerListener.OnWarningListener onWarningListener = MgtvMediaPlayer.this.mOnWarningListener;
                        onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_TS_CACHE_SKIP, i3 + "", MgtvMediaPlayer.this.mErrorUrl, null);
                    }
                    String str2 = (String) MgtvMediaPlayer.this.mCacheReplaceMap.get(MgtvMediaPlayer.this.mErrorUrl);
                    if (str2 != null) {
                        MgtvMediaPlayer.access$7308(MgtvMediaPlayer.this);
                        MgtvMediaPlayer.this.mErrorUrl = str2;
                        bundle2.putString("url", str2);
                        String logTag2 = MgtvMediaPlayer.this.getLogTag();
                        DebugLog.i(logTag2, "doNetHttpWillOpenFailed replace local_url to " + str2);
                    }
                }
                bundle2.getString("player_hash");
                int i6 = bundle2.getInt("io_type");
                c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed url:%s,iotype:%d, RetryCount:%d,error_code:%d-%d", new Object[]{MgtvMediaPlayer.this.mErrorUrl, Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i22), Integer.valueOf(i3)});
                if (isENETUNREACHcode(i22, i3) || (MgtvMediaPlayer.this.mPrepared && isDnsError(i22, i3))) {
                    c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed network broken,RetryCount:%d,error_code:%d-%d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i22), Integer.valueOf(i3)});
                    return true;
                }
                synchronized (MgtvMediaPlayer.this.mDnsNoNetWaiter) {
                    if (!isPlayerReset() && MgtvMediaPlayer.this.mEnableDnsNoNetStrategy && isDnsError(i22, i3)) {
                        boolean d = c.a.a.b.d.d.d(MgtvMediaPlayer.this.mContext);
                        if (!d) {
                            DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 1000 in");
                            try {
                                MgtvMediaPlayer.this.mDnsNoNetWaiter.wait(1000L);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            logTag = MgtvMediaPlayer.this.getLogTag();
                            str = "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 1000 out";
                            DebugLog.i(logTag, str);
                            z2 = true;
                        } else if (!d || MgtvMediaPlayer.this.mLastIsNetworkAvailableNNS) {
                            z2 = false;
                        } else {
                            DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 3000 in");
                            try {
                                MgtvMediaPlayer.this.mDnsNoNetWaiter.wait(PayTask.j);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            logTag = MgtvMediaPlayer.this.getLogTag();
                            str = "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 3000 out";
                            DebugLog.i(logTag, str);
                            z2 = true;
                        }
                        MgtvMediaPlayer.this.mLastIsNetworkAvailableNNS = d;
                    } else {
                        z2 = false;
                    }
                }
                String logTag3 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.i(logTag3, "doNetHttpWillOpenFailed mIsLive:" + MgtvMediaPlayer.this.mIsLive + ",mPlayerMode:" + MgtvMediaPlayer.this.mPlayerMode + ",mPrepared:" + MgtvMediaPlayer.this.mPrepared + ",mIsBuffering:" + MgtvMediaPlayer.this.mIsBuffering + ",mTsNotSkip:" + MgtvMediaPlayer.this.mTsNotSkip + ",mLoadMaxRetryTime:" + MgtvMediaPlayer.this.mLoadMaxRetryTime + ",mPlayStatus:" + MgtvMediaPlayer.this.mPlayStatus + ",lip:" + MgtvMediaPlayer.this.getLastIP());
                DebugLog.ifmt(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed %d-%d-%d-%d-%s", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i22), Integer.valueOf(i3), MgtvMediaPlayer.this.mErrorUrl);
                if ((!MgtvMediaPlayer.this.mIsLive || MgtvMediaPlayer.this.isVod()) && MgtvMediaPlayer.this.mPlayerMode != 1) {
                    if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap && (i3 == 100911 || i3 == 300021 || CodeUtil.isHttp4XX(i22, i3) || CodeUtil.isHttp5XX(i22, i3))) {
                        String hostName = UrlUtil.getHostName(UrlUtil.getValidHttpUrl(bundle2.getString("url")));
                        if (!StringUtil.isEmpty(hostName) && !c.a.a.a.k.d.g(hostName) && MgtvMediaPlayer.this.mIPCacheMap.containsKey(hostName)) {
                            String logTag4 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag4, "callback ipcache will http contains host:" + hostName);
                            IPList iPList = (IPList) MgtvMediaPlayer.this.mIPCacheMap.get(hostName);
                            if (iPList != null && iPList.checkTTL() && (list = iPList.nUseList) != null && list.size() > 0) {
                                String logTag5 = MgtvMediaPlayer.this.getLogTag();
                                DebugLog.i(logTag5, "callback ipcache will http check ttl success." + iPList);
                                if (i5 >= 6) {
                                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "callback ipcache will http return false.not retry");
                                    reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                                    return false;
                                }
                                bundle2.putString("user_msg", MgtvMediaPlayer.USER_MSG_FLAG_USE_CACHE);
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "callback ipcache will http return true.try to goto ip choose");
                                reportHttpErrorPV(i5, MgtvMediaPlayer.this.mErrorUrl, i3, "ipcache");
                                return true;
                            }
                        }
                    }
                    reportHttpErrorPV(i5, MgtvMediaPlayer.this.mErrorUrl, i3, MgtvMediaPlayer.DEFAULT_CACHE_REPORT_TAG);
                    if (z2) {
                        if (i5 < MgtvMediaPlayer.this.mDnsNoNetMaxRetry) {
                            DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy retry cause by inDnsNetStrategy");
                            return true;
                        }
                        reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy skip retry cause by errorRetryCount >= mDnsNoNetMaxRetry");
                        return false;
                    } else if (!MgtvMediaPlayer.this.mPrepared) {
                        if (UrlUtil.isM3u8(MgtvMediaPlayer.this.mErrorUrl)) {
                            if (i5 >= 2) {
                                reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                                return false;
                            }
                            return true;
                        } else if (MgtvMediaPlayer.this.isSkipRetryCode(i22, i3) || !isInitMp4(MgtvMediaPlayer.this.mErrorUrl) || i4 <= 0 || i5 >= 10) {
                            if (MgtvMediaPlayer.this.isSkipRetryCode(i22, i3) || i5 >= MgtvMediaPlayer.this.mLoadMaxRetryTime) {
                                MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                                mgtvMediaPlayer.callbackTsSkip(mgtvMediaPlayer.mErrorUrl, i22, i3);
                                reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                                return false;
                            }
                            return true;
                        } else {
                            return true;
                        }
                    } else if (MgtvMediaPlayer.this.mTsNotSkip && MgtvMediaPlayer.this.isRendered()) {
                        return true;
                    }
                } else if (!MgtvMediaPlayer.this.mPrepared) {
                    if (UrlUtil.isM3u8(MgtvMediaPlayer.this.mErrorUrl)) {
                        return i5 < 2;
                    }
                    MgtvMediaPlayer mgtvMediaPlayer2 = MgtvMediaPlayer.this;
                    mgtvMediaPlayer2.callbackTsSkip(mgtvMediaPlayer2.mErrorUrl, i22, i3);
                    return false;
                } else if (MgtvMediaPlayer.this.mIsBuffering && MgtvMediaPlayer.this.isHLSPlayingUrl() && i5 >= 1) {
                    if (UrlUtil.isSegment(MgtvMediaPlayer.this.mErrorUrl)) {
                        MgtvMediaPlayer mgtvMediaPlayer3 = MgtvMediaPlayer.this;
                        mgtvMediaPlayer3.callbackTsSkip(mgtvMediaPlayer3.mErrorUrl, i22, i3);
                    }
                    return false;
                }
                if (MgtvMediaPlayer.this.isSkipRetryCode(i22, i3) || i5 >= 2) {
                    if (UrlUtil.isSegment(MgtvMediaPlayer.this.mErrorUrl)) {
                        MgtvMediaPlayer mgtvMediaPlayer4 = MgtvMediaPlayer.this;
                        mgtvMediaPlayer4.callbackTsSkip(mgtvMediaPlayer4.mErrorUrl, i22, i3);
                    }
                    reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                    return false;
                }
                return true;
            }

            private boolean doNewHttpWillOpen(Bundle bundle2) {
                int i22 = bundle2.getInt("error_type");
                int i3 = bundle2.getInt("error_code");
                bundle2.getInt("retry_counter");
                int i4 = bundle2.getInt("reset_iplist");
                MgtvMediaPlayer.this.mLastDlSize = bundle2.getInt("cur_dl_dize");
                bundle2.putString("user_msg", "init");
                if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap && i4 == 1) {
                    MgtvMediaPlayer.this.clearIPCache();
                }
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag, "doNewHttpWillOpen in error_what:" + i22 + ",error_extra:" + i3 + ",reset_iplist:" + i4 + ",mLastDlSize:" + MgtvMediaPlayer.this.mLastDlSize);
                bundle2.putInt("reset_iplist", 0);
                if (i3 == 0) {
                    MgtvMediaPlayer.this.mIsInitMp4Error = false;
                    if (i3 == 0 && MgtvMediaPlayer.this.mCacheEable) {
                        replaceUrlFromCache(bundle2);
                    }
                    return false;
                }
                boolean doNetHttpWillOpenFailed = doNetHttpWillOpenFailed(i22, i3, bundle2);
                String logTag2 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag2, "doNetHttpWillOpenFailed return " + doNetHttpWillOpenFailed + "," + i22 + "-" + i3 + "-" + MgtvMediaPlayer.this.mErrorUrl);
                return doNetHttpWillOpenFailed;
            }

            private boolean doWillGetEnv(Bundle bundle2) {
                String string = bundle2.getString("env_key");
                if (string == null || string.length() <= 0) {
                    return false;
                }
                bundle2.putString("env_value", System.getenv(string));
                return true;
            }

            private boolean doWillHostAddr(Bundle bundle2) {
                List<String> list;
                if (bundle2 == null) {
                    return false;
                }
                int i22 = bundle2.getInt("addr_handle");
                String string = bundle2.getString("player_hash");
                int i3 = bundle2.getInt("retry_counter");
                String string2 = bundle2.getString("user_msg");
                String string3 = bundle2.getString("addr_hostname");
                long j = bundle2.getLong("switch_key");
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag, "callback doWillHostAddr is_handle:" + i22 + ",hash:" + string + ",count_int:" + i3 + ",user_msg:" + string2 + ",hostname:" + string3 + ",switch_key:" + j);
                if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap && i22 != 1 && MgtvMediaPlayer.USER_MSG_FLAG_USE_CACHE.equals(string2) && !c.a.a.a.k.d.g(string3) && MgtvMediaPlayer.this.mIPCacheMap.containsKey(string3)) {
                    try {
                        IPList iPList = (IPList) MgtvMediaPlayer.this.mIPCacheMap.get(string3);
                        if (iPList != null && (list = iPList.nUseList) != null && list.size() > 0 && iPList.checkTTL()) {
                            String str = iPList.nUseList.get(0);
                            if (c.a.a.a.k.d.b(str)) {
                                String logTag2 = MgtvMediaPlayer.this.getLogTag();
                                DebugLog.i(logTag2, "callback ipcache doWillHostAddr put chooseip:" + str);
                                String formatIPList = IPList.formatIPList(iPList.nUseList);
                                if (!StringUtil.isEmpty(formatIPList)) {
                                    String logTag3 = MgtvMediaPlayer.this.getLogTag();
                                    DebugLog.d(logTag3, "callback ipcache doWillHostAddr put srcIPListStr:" + formatIPList);
                                    bundle2.putString("addr_hostname", formatIPList);
                                }
                                bundle2.putString("addr_ip", str);
                                bundle2.putInt("addr_error", 0);
                                return false;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                String string4 = bundle2.getString("addr_uri");
                if (c.a.a.a.k.d.f(string3)) {
                    String E = MgtvMediaPlayer.this.mReporter != null ? MgtvMediaPlayer.this.mReporter.E() : "0";
                    notifyIpIsLAN(E, "hostname_" + string3);
                }
                boolean g = c.a.a.a.k.d.g(string3);
                boolean d = c.a.a.b.d.d.d(MgtvMediaPlayer.this.mContext);
                String logTag4 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag4, "doWillHostAddr hostname:" + string3 + ",isIp:" + g);
                String logTag5 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag5, "doWillHostAddr is_handle=" + i22 + ",mBackJavaDns=" + MgtvMediaPlayer.this.mBackJavaDns + ",isIp=" + g + ",mForceHttpDns:" + MgtvMediaPlayer.this.mForceHttpDns);
                if ((MgtvMediaPlayer.this.mForceHttpDns && !g) || ((MgtvMediaPlayer.this.mJavaDnsEnable && !g) || (i22 == 1 && MgtvMediaPlayer.this.mBackJavaDns && !g))) {
                    if (d) {
                        MgtvMediaPlayer.this.mLastUri = string4;
                        domainResolve(string3, bundle2, MgtvMediaPlayer.this.mForceHttpDns);
                    } else {
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "skip domainResolve cause net not available");
                    }
                    return MgtvMediaPlayer.this.mPlayerReset;
                }
                if (i22 == 1 && g) {
                    bundle2.putString("addr_ip", string3);
                    bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CTRL_ARRR_DNS_TYPE_INT, 0);
                    bundle2.putInt("addr_error", 0);
                }
                return false;
            }

            private boolean doWillHttpOpen(Bundle bundle2) {
                if (bundle2 != null) {
                    MgtvMediaPlayer.this.mLastRequestUrl = UrlUtil.getValidUrl(bundle2.getString("url"));
                }
                if (MgtvMediaPlayer.this.mReportParams == null || !(MgtvMediaPlayer.this.mReportParams.getVideoType().equals(ReportParams.VideoType.AD_PRE) || MgtvMediaPlayer.this.mReportParams.getVideoType().equals(ReportParams.VideoType.AD_MID))) {
                    if (bundle2 != null) {
                        MgtvMediaPlayer.this.mWillOpenUrl = bundle2.getString("url");
                    }
                    return doNewHttpWillOpen(bundle2);
                }
                return onNormalHttpWillOpen(bundle2);
            }

            private void domainResolve(String str, Bundle bundle2, boolean z2) {
                a.d c;
                int k;
                if (str == null || bundle2 == null) {
                    DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "skip domainResolve hostname or args is null");
                    return;
                }
                a aVar = new a();
                aVar.d(new a.c() { // from class: com.hunantv.media.player.MgtvMediaPlayer.4.1
                    public void onDnsFail(a aVar2) {
                    }

                    public void onDnsFinish(a aVar2) {
                        synchronized (MgtvMediaPlayer.this.mDnsLock) {
                            MgtvMediaPlayer.this.mDnsLock.notifyAll();
                        }
                    }

                    public void onDnsStart(a aVar2) {
                    }

                    public void onDnsSuc(a aVar2, String[] strArr) {
                    }
                });
                boolean resolveStrategy = resolveStrategy(aVar, str, bundle2, z2, MgtvMediaPlayer.this.mHttpDnsNeedRetry);
                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve use:" + resolveStrategy);
                if (resolveStrategy) {
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve use type:" + aVar.c());
                    notifyHttpDnsReport(aVar.c(), MainNotifyHandler.MSG_HTTPDNS_REPORT_PV, 0);
                }
                synchronized (MgtvMediaPlayer.this.mDnsLock) {
                    while (aVar.n() && !isJavaDnsInterrupt()) {
                        DebugLog.d(MgtvMediaPlayer.this.getLogTag(), "domainResolve wait in");
                        try {
                            MgtvMediaPlayer.this.mDnsLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                DebugLog.d(MgtvMediaPlayer.this.getLogTag(), "domainResolve wait out. resolving:" + aVar.n() + ",isJavaDnsInterrupt:" + isJavaDnsInterrupt());
                String[] c2 = c.a.a.a.k.d.c(aVar.m());
                aVar.o();
                String str2 = "costMs:" + aVar.i() + ";ips:" + com.hunantv.media.utils.StringUtil.formatArrayString(c2) + ";net:" + NetPlayConfig.getNetworkType() + g.b;
                String formatIPList = IPList.formatIPList(c2);
                String str3 = null;
                if (c2 != null && c2.length > 0) {
                    str3 = c2[0];
                }
                int i22 = AnonymousClass28.$SwitchMap$com$hunantv$media$player$dns$AsyncDns$DnsType[aVar.c().ordinal()] == 1 ? 4 : 5;
                if (!isJavaDnsInterrupt() && c.a.a.a.k.d.b(str3)) {
                    if (resolveStrategy) {
                        updateCurrentDnsDsc(aVar.c());
                        if (c.a.a.a.k.d.f(str3)) {
                            notifyHttpDnsReport(aVar.c(), 2001, 100, str2);
                        } else {
                            notifyHttpDnsReport(aVar.c(), 2001, 0, str2);
                        }
                    }
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve put iplist:" + formatIPList);
                    bundle2.putString("addr_hostname", formatIPList);
                    if (c.a.a.a.k.d.b(str3)) {
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve put firstIP:" + str3);
                        bundle2.putString("addr_ip", str3);
                    }
                    bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CTRL_ARRR_DNS_TYPE_INT, i22);
                    bundle2.putInt("addr_error", 0);
                    return;
                }
                if (resolveStrategy) {
                    if (isJavaDnsInterrupt() && aVar.k() == 0) {
                        c = aVar.c();
                        k = -2;
                    } else {
                        c = aVar.c();
                        k = aVar.k();
                    }
                    notifyHttpDnsReport(c, 2002, k, str2);
                    if (!isJavaDnsInterrupt()) {
                        int a = aVar.a((int) Opcodes.IFNONNULL);
                        if (aVar.k() != 0) {
                            a = aVar.k();
                        } else if (str3 != null && !c.a.a.a.k.d.g(str3)) {
                            a = aVar.a(107);
                        }
                        int i3 = -a;
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), aVar.c() + "resolve putInt error:" + i3);
                        bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CTRL_ARRR_DNS_TYPE_INT, i22);
                        bundle2.putInt("addr_error", i3);
                    }
                }
                MgtvMediaPlayer.this.mCurrentDnsDsc = "native";
            }

            private String findTsCachPath(String str, String[] strArr) {
                if (strArr == null) {
                    return null;
                }
                try {
                    String fileName = UrlUtil.getFileName(str);
                    for (String str2 : strArr) {
                        if (str2 != null && new File(str2).getName().equals(fileName)) {
                            return str2;
                        }
                    }
                } catch (Exception unused) {
                }
                return null;
            }

            private boolean isDnsError(int i22, int i3) {
                return i3 == 300600 || i22 == 400605 || MGTVP2pDirectMediaDataSource.isP2pDirectDnsError(i22, i3);
            }

            private boolean isENETUNREACHcode(int i22, int i3) {
                return i3 == 300005 || MGTVP2pDirectMediaDataSource.getShortErrorCode(i22, i3) == 101;
            }

            private boolean isInitMp4(String str) {
                return MgtvMediaPlayer.this.isHLSPlayingUrl() && UrlUtil.isSuffixUrl(str, ".mp4");
            }

            private boolean isJavaDnsInterrupt() {
                return isPlayerReset();
            }

            private boolean isPlayerReset() {
                return MgtvMediaPlayer.this.mPlayerReset || (MgtvMediaPlayer.this.mPlayerMode == 2 && MgtvMediaPlayer.this.mLoopPlayerReset);
            }

            private void notifyHttpDnsReport(a.d dVar, int i22, int i3) {
                notifyHttpDnsReport(dVar, i22, i3, "");
            }

            private void notifyHttpDnsReport(a.d dVar, int i22, int i3, String str) {
                if (dVar != a.d.b || MgtvMediaPlayer.this.mOnWarningListener == null) {
                    return;
                }
                notifyMessage(i22, i3, str);
            }

            private void notifyIpIsLAN(String str, String str2) {
                if (MgtvMediaPlayer.this.mOnWarningListener == null || MgtvMediaPlayer.this.mReportParams == null || MgtvMediaPlayer.this.mReportParams.getVideoType() != ReportParams.VideoType.VOD) {
                    return;
                }
                if (!MgtvMediaPlayer.this.mReportedTSLAN) {
                    notifyMessage(1002, str, str2 + "_suffix_" + UrlUtil.getSuffix(MgtvMediaPlayer.this.mWillOpenUrl));
                }
                if (UrlUtil.isM3u8(MgtvMediaPlayer.this.mWillOpenUrl)) {
                    return;
                }
                MgtvMediaPlayer.this.mReportedTSLAN = true;
            }

            private void notifyMessage(int i22, int i3, String str) {
                Message message = new Message();
                message.what = i22;
                message.arg1 = i3;
                message.obj = str;
                MgtvMediaPlayer.this.mNotifyHandler.sendMessage(message);
            }

            private void notifyMessage(int i22, String str, String str2) {
                Message message = new Message();
                message.what = i22;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MainNotifyHandler.BUNDLE_STR_INFO1, str);
                bundle2.putString(MainNotifyHandler.BUNDLE_STR_INFO2, str2);
                message.setData(bundle2);
                MgtvMediaPlayer.this.mNotifyHandler.sendMessage(message);
            }

            private boolean onLiveWillOpen(Bundle bundle2) {
                int i22 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_ERROR_WHAT_INT);
                int i3 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_ERROR_EXTRA_INT);
                MgtvMediaPlayer.this.mLastRequestUrl = UrlUtil.getValidUrl(bundle2.getString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_SRC_URL_STRING));
                if (i3 != 0) {
                    MgtvMediaPlayer.this.mErrorUrl = UrlUtil.getValidUrl(bundle2.getString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_SRC_URL_STRING));
                    int i4 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_COUNTER_INT);
                    int i5 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_ERR_IO_TYPE_INT);
                    c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLiveWillOpen url:%s,iotype:%d, RetryCount:%d,error_code:%d-%d", new Object[]{MgtvMediaPlayer.this.mErrorUrl, Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i22), Integer.valueOf(i3)});
                    if (isENETUNREACHcode(i22, i3) || (MgtvMediaPlayer.this.mPrepared && isDnsError(i22, i3))) {
                        c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLiveWillOpen network broken,RetryCount:%d,error_code:%d-%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i22), Integer.valueOf(i3)});
                        return true;
                    }
                    DebugLog.ifmt(MgtvMediaPlayer.this.getLogTag(), "OnSourceNetHandledListener.CTRL_WILL_LIVE_OPEN %d-%d-%d-%d-%s", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i22), Integer.valueOf(i3), MgtvMediaPlayer.this.mErrorUrl);
                    return !MgtvMediaPlayer.this.isSkipRetryCode(i22, i3) && i4 < 2;
                }
                return false;
            }

            private boolean onLoopWillOpen(Bundle bundle2) {
                int i22 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_ERROR_WHAT_INT);
                int i3 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_ERROR_EXTRA_INT);
                if (i3 != 0) {
                    MgtvMediaPlayer.this.mErrorUrl = UrlUtil.getValidUrl(bundle2.getString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_SRC_URL_STRING));
                    int i4 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_COUNTER_INT);
                    int i5 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_ERR_IO_TYPE_INT);
                    c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLoopWillOpen url:%s,iotype:%d, RetryCount:%d,error_code:%d-%d", new Object[]{MgtvMediaPlayer.this.mErrorUrl, Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i22), Integer.valueOf(i3)});
                    if (isENETUNREACHcode(i22, i3) || (MgtvMediaPlayer.this.mPrepared && isDnsError(i22, i3))) {
                        c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLoopWillOpen network broken,RetryCount:%d,error_code:%d-%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i22), Integer.valueOf(i3)});
                        return true;
                    }
                    DebugLog.ifmt(MgtvMediaPlayer.this.getLogTag(), "OnSourceNetHandledListener.CTRL_WILL_LOOP_OPEN %d-%d-%d-%d-%s", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i22), Integer.valueOf(i3), MgtvMediaPlayer.this.mErrorUrl);
                    return !MgtvMediaPlayer.this.isSkipRetryCode(i22, i3) && i4 < 2;
                }
                return false;
            }

            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private boolean onNormalHttpWillOpen(android.os.Bundle r15) {
                /*
                    Method dump skipped, instructions count: 329
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.player.MgtvMediaPlayer.AnonymousClass4.onNormalHttpWillOpen(android.os.Bundle):boolean");
            }

            private boolean replaceUrlFromCache(Bundle bundle2) {
                String string = bundle2.getString("url");
                if (!UrlUtil.isFilePrefix(string) && !UrlUtil.isLocal(string)) {
                    String str = null;
                    String fileName = UrlUtil.getFileName(string);
                    if (StringUtil.isEmpty(fileName)) {
                        return false;
                    }
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.d(logTag, "replaceUrlFromCache try to find replace cache:" + string);
                    if (UrlUtil.isM3u8(string)) {
                        String str2 = MgtvMediaPlayer.this.mCacheM3u8Path;
                        String fileName2 = UrlUtil.getFileName(str2);
                        if (!StringUtil.isEmpty(str2) && !StringUtil.isEmpty(fileName2) && fileName2.equals(fileName)) {
                            str = str2;
                        }
                    } else if (MgtvMediaPlayer.this.isHLSPlayingUrl() && UrlUtil.isSegment(string)) {
                        str = findTsCachPath(string, MgtvMediaPlayer.this.mCacheTsPaths);
                    }
                    if (FileUtil.exist(str)) {
                        String addLocalPrefix = UrlUtil.addLocalPrefix(str);
                        if (!StringUtil.isEmpty(addLocalPrefix)) {
                            String logTag2 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag2, "replaceUrlFromCache from " + string);
                            String logTag3 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag3, "replaceUrlFromCache to " + addLocalPrefix);
                            bundle2.putString("url", addLocalPrefix);
                            if (UrlUtil.isM3u8(string)) {
                                String logTag4 = MgtvMediaPlayer.this.getLogTag();
                                DebugLog.d(logTag4, "replaceUrlFromCache put SRC_URL " + string);
                                bundle2.putString("src_url", string);
                            }
                            MgtvMediaPlayer.this.mCacheReplaceMap.put(addLocalPrefix, string);
                            return true;
                        }
                    }
                }
                return false;
            }

            private void reportHttpErrorErr(int i22, String str) {
                if ((isInitMp4(str) || UrlUtil.isM3u8(str)) && MgtvMediaPlayer.this.mReportParams != null && MgtvMediaPlayer.this.mReportParams.getVideoType() == ReportParams.VideoType.VOD && MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.NO_PROXY && MgtvMediaPlayer.this.mOnWarningListener != null) {
                    String E = MgtvMediaPlayer.this.mReporter != null ? MgtvMediaPlayer.this.mReporter.E() : MLog.a.b;
                    MgtvPlayerListener.OnWarningListener onWarningListener = MgtvMediaPlayer.this.mOnWarningListener;
                    String str2 = i22 + Consts.DOT + MgtvMediaPlayer.this.mCacheReportLerr;
                    StringBuilder sb = new StringBuilder();
                    sb.append("psuuid_");
                    sb.append(E);
                    sb.append("_render_");
                    sb.append(MgtvMediaPlayer.this.isRendered() ? "1" : "0");
                    sb.append("_url_");
                    sb.append(str);
                    sb.append("_type_");
                    sb.append(MgtvMediaPlayer.this.mCacheReportTag);
                    onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_HTTP_ERROR_ERR, str2, sb.toString(), null);
                }
            }

            private void reportHttpErrorPV(int i22, String str, int i3, String str2) {
                if (i22 == 0) {
                    MgtvMediaPlayer.this.mCacheReportTag = MgtvMediaPlayer.DEFAULT_CACHE_REPORT_TAG;
                    MgtvMediaPlayer.this.mCacheReportLerr = 0;
                }
                if (i22 == 0) {
                    if ((isInitMp4(str) || UrlUtil.isM3u8(str)) && MgtvMediaPlayer.this.mReportParams != null && MgtvMediaPlayer.this.mReportParams.getVideoType() == ReportParams.VideoType.VOD && MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.NO_PROXY && MgtvMediaPlayer.this.mOnWarningListener != null) {
                        String E = MgtvMediaPlayer.this.mReporter != null ? MgtvMediaPlayer.this.mReporter.E() : MLog.a.b;
                        MgtvMediaPlayer.this.mCacheReportTag = str2;
                        MgtvMediaPlayer.this.mCacheReportLerr = i3;
                        MgtvPlayerListener.OnWarningListener onWarningListener = MgtvMediaPlayer.this.mOnWarningListener;
                        String str3 = i3 + "";
                        StringBuilder sb = new StringBuilder();
                        sb.append("psuuid_");
                        sb.append(E);
                        sb.append("_render_");
                        sb.append(MgtvMediaPlayer.this.isRendered() ? "1" : "0");
                        sb.append("_url_");
                        sb.append(str);
                        sb.append("_type_");
                        sb.append(str2);
                        onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_HTTP_ERROR_PV, str3, sb.toString(), null);
                    }
                }
            }

            private boolean resolveStrategy(@NonNull a aVar, @NonNull String str, Bundle bundle2) {
                return resolveStrategy(aVar, str, bundle2, false, false);
            }

            private boolean resolveStrategy(@NonNull a aVar, @NonNull String str, Bundle bundle2, boolean z2, boolean z22) {
                a.d dVar;
                String logTag;
                String str2;
                if (z2 || (bundle2 != null && bundle2.getInt("addr_handle") == 1 && MgtvMediaPlayer.this.mBackJavaDns)) {
                    aVar.j(1);
                    dVar = a.d.b;
                } else {
                    if (MgtvMediaPlayer.this.isDnsCacheEnable()) {
                        if (MgtvMediaPlayer.this.mHttpDnsEnable) {
                            String a = StringUtil.isEmpty(MgtvMediaPlayer.this.mLastUri) ? null : c.a.a.a.k.e.a(MgtvMediaPlayer.this.mLastUri);
                            if (a != null && !a.trim().equals("")) {
                                logTag = MgtvMediaPlayer.this.getLogTag();
                                str2 = "resolveStrategy cache valid";
                            }
                        } else {
                            logTag = MgtvMediaPlayer.this.getLogTag();
                            str2 = "resolveStrategy cache valid and httpdns not open";
                        }
                        DebugLog.d(logTag, str2);
                        return false;
                    }
                    dVar = MgtvMediaPlayer.this.mJavaDnsType;
                }
                aVar.e(str, dVar, z22);
                return true;
            }

            private void updateCurrentDnsDsc(a.d dVar) {
                MgtvMediaPlayer mgtvMediaPlayer;
                String str;
                int i22 = AnonymousClass28.$SwitchMap$com$hunantv$media$player$dns$AsyncDns$DnsType[dVar.ordinal()];
                if (i22 == 1) {
                    mgtvMediaPlayer = MgtvMediaPlayer.this;
                    str = MgtvMediaPlayer.DNS_JAVA_NORMAL;
                } else if (i22 != 2) {
                    return;
                } else {
                    mgtvMediaPlayer = MgtvMediaPlayer.this;
                    str = MgtvMediaPlayer.DNS_JAVA_HTTPDNS;
                }
                mgtvMediaPlayer.mCurrentDnsDsc = str;
            }

            private void updateIp(String str) {
                String logTag;
                StringBuilder sb;
                String str2;
                if (MgtvMediaPlayer.this.mMediaPlayer == null || (!(MgtvMediaPlayer.this.mMediaPlayer.v() == 2 || MgtvMediaPlayer.this.mMediaPlayer.v() == 1) || MgtvMediaPlayer.this.mMediaPlayer.o4() == null)) {
                    if (MgtvMediaPlayer.this.mMediaPlayer == null || !((MgtvMediaPlayer.this.mMediaPlayer.v() == 2 || MgtvMediaPlayer.this.mMediaPlayer.v() == 1) && MgtvMediaPlayer.this.mMediaPlayer.o4() == null)) {
                        MgtvMediaPlayer.this.mLastIP = str;
                    } else {
                        MgtvMediaPlayer.this.mLastIP = "0.0.0.1";
                    }
                    logTag = MgtvMediaPlayer.this.getLogTag();
                    sb = new StringBuilder();
                    str2 = "didTcpOpen tcp_ip:";
                } else {
                    MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                    mgtvMediaPlayer.mLastIP = P2pMgr.getCdnIpFromP2PTask(mgtvMediaPlayer.mMediaPlayer.o4());
                    logTag = MgtvMediaPlayer.this.getLogTag();
                    sb = new StringBuilder();
                    str2 = "didTcpOpen p2p QueryTaskInfo cdnIp:";
                }
                sb.append(str2);
                sb.append(MgtvMediaPlayer.this.mLastIP);
                DebugLog.d(logTag, sb.toString());
            }

            private void willTcpOpen(Bundle bundle2) {
                if (bundle2 == null) {
                    return;
                }
                String string = bundle2.getString("tcp_hostname");
                String string2 = bundle2.getString("ip");
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag, "callback willTcpOpen tcp_hostname:" + string + ",tcp_ip:" + string2);
                MgtvMediaPlayer.this.mLastHostIP = string2;
                updateIp(string2);
                if (string2 == null || string2.length() <= 1 || !c.a.a.a.k.d.f(string2)) {
                    return;
                }
                notifyIpIsLAN("1", MgtvMediaPlayer.this.getCurrentDnsDsc() + "_hostip_" + string2);
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSourceNetHandledListener
            public boolean onSourceNetCtrl(int i22, Bundle bundle2) {
                IP2pTask o4;
                c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "OnSourceNetHandledListener.onSourceNetCtrl 0x%5x", new Object[]{Integer.valueOf(i22)});
                switch (i22) {
                    case 131073:
                        willTcpOpen(bundle2);
                        break;
                    case 131074:
                        didTcpOpen(bundle2);
                        break;
                    case 131075:
                        return doWillHttpOpen(bundle2);
                    case 131077:
                        return didLiveOpen(bundle2);
                    case 131078:
                        return doWillHostAddr(bundle2);
                    case 131081:
                        return didLiveReopen(bundle2);
                    case 131088:
                        return didLoopOpen(bundle2);
                    case 131089:
                        return didLoopReopen(bundle2);
                    case 131090:
                        return didHDJSwitch(bundle2);
                    case 131104:
                        return doWillGetEnv(bundle2);
                    case 131120:
                        if (MgtvMediaPlayer.this.mPreBufferState.isEnable() && MgtvMediaPlayer.this.mPreBufferState.getState() == 2) {
                            this.mIsPauseLoad = true;
                            return true;
                        } else if (MgtvMediaPlayer.this.isSourceSwitching() || MgtvMediaPlayer.this.mMediaPlayer == null || (!(MgtvMediaPlayer.this.mMediaPlayer.v() == 2 || MgtvMediaPlayer.this.mMediaPlayer.v() == 1) || (o4 = MgtvMediaPlayer.this.mMediaPlayer.o4()) == null || o4.getStatus() == 0)) {
                            if (this.mIsPauseLoad) {
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "CTRL_WILL_CHECK_PAUSE_LOAD will return false. will resume load");
                            }
                            this.mIsPauseLoad = false;
                            return false;
                        } else {
                            if (!this.mIsPauseLoad) {
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "CTRL_WILL_CHECK_PAUSE_LOAD will return true. will pause load");
                            }
                            this.mIsPauseLoad = true;
                            return true;
                        }
                    case 131184:
                        synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                            if (bundle2 == null) {
                                break;
                            } else if (bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_NEED_RETRY_INT) == 1) {
                                if (MgtvMediaPlayer.this.mReporter != null) {
                                    MgtvMediaPlayer.this.mReporter.M();
                                }
                                int i3 = (int) bundle2.getLong(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_RETRY_KEY_LONG);
                                SmoothMediaSource smoothMediaSource = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i3));
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth need_retry == 1 find:" + i3);
                                if (smoothMediaSource != null) {
                                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth need_retry == 1 , will retry use :" + smoothMediaSource.getUrl());
                                    bundle2.putString("smooth_switch_url", smoothMediaSource.getUrl());
                                    if (smoothMediaSource.getReporter() != null) {
                                        smoothMediaSource.getReporter().H();
                                        if (MgtvMediaPlayer.this.mReportParams != null) {
                                            MgtvMediaPlayer.this.mReportParams.setPlaySessionId(smoothMediaSource.getReporter().E());
                                        }
                                    }
                                } else {
                                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth need_retry == 1, not found source");
                                }
                                bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_NEED_RETRY_INT, 0);
                                return true;
                            } else {
                                int i4 = (int) bundle2.getLong("smooth_switch_key");
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth CTRL_WILL_SMOOTH_SWITCH switch_key:" + i4);
                                SmoothMediaSource matchLastKeySource = MgtvMediaPlayer.this.matchLastKeySource(i4);
                                if (matchLastKeySource != null) {
                                    if (matchLastKeySource.isLastRetry() && MgtvMediaPlayer.this.mReportParams != null && (MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.ONLY_P2P || MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.P2P_DRM)) {
                                        SmoothMediaSource smoothMediaSource2 = new SmoothMediaSource(MgtvMediaPlayer.this.getPlayingOriginUrl());
                                        smoothMediaSource2.setReportParams(MgtvMediaPlayer.this.mReportParams);
                                        smoothMediaSource2.bind(MgtvMediaPlayer.this);
                                        smoothMediaSource2.setThrowErrorIfSwitchFailed(true);
                                        MgtvMediaPlayer.this.mSmoothSourcesRecord.put(Integer.valueOf(smoothMediaSource2.getKey()), smoothMediaSource2);
                                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth is last retry. will retry key:" + smoothMediaSource2.getKey());
                                        bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_NEED_RETRY_INT, 1);
                                        bundle2.putLong(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_RETRY_KEY_LONG, smoothMediaSource2.getKey());
                                    }
                                    if (!matchLastKeySource.isLastRetry()) {
                                        String string = bundle2.getString("smooth_switch_url");
                                        bundle2.putString("smooth_switch_url", string);
                                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth CTRL_WILL_SMOOTH_SWITCH switch_url:" + string);
                                        if (!StringUtil.isEmpty(string)) {
                                            int indexOf = string.indexOf(",mgtvjsource:");
                                            String substring = indexOf >= 0 ? string.substring(indexOf) : "";
                                            boolean onSwitchSmoothSourceWillUpdate = MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener != null ? MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener.onSwitchSmoothSourceWillUpdate(matchLastKeySource) : false;
                                            if (matchLastKeySource.getReadType() != 2 && onSwitchSmoothSourceWillUpdate && !StringUtil.isEmpty(matchLastKeySource.useUpdateUrl())) {
                                                String str = matchLastKeySource.useUpdateUrl() + substring;
                                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth CTRL_WILL_SMOOTH_SWITCH will update url:" + str);
                                                bundle2.putString("smooth_switch_url", str);
                                            }
                                        }
                                    }
                                }
                                SmoothMediaSource smoothMediaSource3 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i4));
                                if (smoothMediaSource3 != null && smoothMediaSource3.getReporter() != null) {
                                    smoothMediaSource3.getReporter().H();
                                    if (MgtvMediaPlayer.this.mReportParams != null) {
                                        MgtvMediaPlayer.this.mReportParams.setPlaySessionId(smoothMediaSource3.getReporter().E());
                                    }
                                }
                                return true;
                            }
                        }
                        break;
                }
                return false;
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSourceNetHandledListener
            public void onSourceNetEvent(int i22, Bundle bundle2) {
                if (i22 != 78338) {
                    return;
                }
                didHostAddr(bundle2);
            }
        };
        this.mLogTagKey = "";
        this.mEnableReport = true;
        this.p2pLocker = new Object();
        this.mSeekStartMs = -1L;
        this.mHw2SwType = Hw2SwType.NONE;
        this.mPlaybackSpeed = 1.0f;
        this.mRecordMaxPlaySpeed = 1.0f;
        this.mFrameListener = new MgtvPlayerListener.OnFrameListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.22
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnFrameListener
            public void onVFrameClockCome(MgtvPlayerListener.FrameClock frameClock) {
                synchronized (MgtvMediaPlayer.this.ptsLocker) {
                    WeakHandler weakHandler = MgtvMediaPlayer.this.ptsWeakHandler;
                    if (weakHandler != null) {
                        weakHandler.removeMessages(256);
                        Message message = new Message();
                        message.what = 256;
                        message.obj = frameClock;
                        MgtvMediaPlayer.this.ptsWeakHandler.sendMessage(message);
                    }
                    if (MgtvMediaPlayer.this.mOnFrameListener != null) {
                        MgtvMediaPlayer.this.mOnFrameListener.onVFrameClockCome(frameClock);
                    }
                }
            }
        };
        this.mInnerFlowDataStatistic = new FlowDataStatistic();
        this.mEnableImgoVsr = false;
        this.mLoopSourceKey = new AtomicInteger(1);
        this.mSubtitleSources = new ArrayList();
        this.ptsHandlerThread = null;
        this.ptsWeakHandler = null;
        this.ptsListeners = new HashSet();
        this.ptsLocker = new Object();
        this.mSmoothSourceListener = new d.n() { // from class: com.hunantv.media.player.MgtvMediaPlayer.26
            public int lastSwitchingKey = -1;

            public void onSmoothSwitchSourceComplete(d dVar, int i22, int i3, String str) {
                SmoothMediaSource smoothMediaSource;
                synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.d(logTag, "onSmoothSwitchSourceComplete (type:" + i3 + ",key:" + i22 + ",msg:" + str + ")");
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSmoothSwitchSourceComplete current: ");
                    sb.append(MgtvMediaPlayer.this.getCurrentSmoothSourceKey());
                    DebugLog.i(logTag2, sb.toString());
                    for (Map.Entry entry : MgtvMediaPlayer.this.mSmoothSourcesRecord.entrySet()) {
                        if (((Integer) entry.getKey()).intValue() < i22 && (smoothMediaSource = (SmoothMediaSource) entry.getValue()) != null && !smoothMediaSource.isReleased()) {
                            smoothMediaSource.release();
                        }
                    }
                    MgtvMediaPlayer.this.mSmoothUseP2pFailed = false;
                    if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                        MgtvMediaPlayer.this.mMediaPlayer.k2(false);
                    }
                    SmoothMediaSource smoothMediaSource2 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i22));
                    if (smoothMediaSource2 != null) {
                        if (!StringUtil.isEmpty(smoothMediaSource2.getVfps())) {
                            MgtvMediaPlayer.this.mRecordVfps = Float.parseFloat(smoothMediaSource2.getVfps());
                        }
                        MgtvMediaPlayer.this.mLastVideoWidth = smoothMediaSource2.getVideoWidth();
                        MgtvMediaPlayer.this.mLastVideoHeight = smoothMediaSource2.getVideoHeight();
                        if (MgtvMediaPlayer.this.mReporter != null) {
                            MgtvMediaPlayer.this.mReporter.M();
                        }
                        MgtvMediaPlayer.this.mReporter = smoothMediaSource2.getReporter();
                        if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                            MgtvMediaPlayer.this.mMediaPlayer.o0(MgtvMediaPlayer.this.mReporter);
                            MgtvMediaPlayer.this.mMediaPlayer.A0(smoothMediaSource2.getReadType(), smoothMediaSource2.getUrl(), smoothMediaSource2.getPlayingUrl());
                            MgtvMediaPlayer.this.mMediaPlayer.N1(smoothMediaSource2.getEnableImgoAIQE());
                        }
                        if (MgtvMediaPlayer.this.mDataSourceInfo != null) {
                            MgtvMediaPlayer.this.mDataSourceInfo.setVideoFormat(smoothMediaSource2.getVideoFormat());
                            MgtvMediaPlayer.this.mDataSourceInfo.setAudioFormat(smoothMediaSource2.getAudioFormat());
                            MgtvMediaPlayer.this.mDataSourceInfo.setFileFormat(smoothMediaSource2.getFileFormat());
                        }
                        if (MgtvMediaPlayer.this.mReporter != null) {
                            MgtvMediaPlayer.this.mReportParams.deepCopy(smoothMediaSource2.getReportParams());
                            MgtvMediaPlayer.this.mReporter.n(MgtvMediaPlayer.this.mReportParams);
                            MgtvMediaPlayer.this.mReporter.N();
                        }
                        String keyFrameMapKey = MgtvMediaPlayer.this.getKeyFrameMapKey(smoothMediaSource2.getVid(), smoothMediaSource2.getDef());
                        if (MgtvMediaPlayer.this.mSmoothKeyFrameMap.containsKey(keyFrameMapKey)) {
                            String logTag3 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag3, "find smoothKeyFrameKey :" + keyFrameMapKey + " set to player");
                            byte[] bArr = MgtvMediaPlayer.this.mSmoothKeyFrameMap.get(keyFrameMapKey);
                            if (KeyFrameInfoUtils.isKeyFrameDataValid(bArr, smoothMediaSource2.videoFileHash) == 0) {
                                MgtvMediaPlayer.this.setKeyFrameInfoFileBuf(bArr);
                            }
                        }
                    }
                    SmoothMediaSource matchLastKeySource = MgtvMediaPlayer.this.matchLastKeySource(i22);
                    if (matchLastKeySource == null) {
                        DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "onSmoothSwitchSourceComplete matchKeySource failed");
                        return;
                    }
                    if (matchLastKeySource.getSwitchMod() == 1) {
                        MgtvMediaPlayer.this.mMediaPlayer.w2(true);
                    }
                    MgtvMediaPlayer.this.mSwitchedSmoothSource = matchLastKeySource;
                    MgtvMediaPlayer.this.mSourceSwitchingComplete = true;
                    MgtvMediaPlayer.this.mSourceSwitching = false;
                    if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                        MgtvMediaPlayer.this.mMainFlowReportProcessor = matchLastKeySource.getFlowReportProcessor();
                        MgtvMediaPlayer.this.mMediaPlayer.L0(matchLastKeySource.getP2pTask());
                        MgtvMediaPlayer.this.mMediaPlayer.j3(matchLastKeySource.getReadType());
                    }
                    MgtvMediaPlayer.this.mSmoothKeyFrameMap.clear();
                    if (MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener != null) {
                        MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener.onSwitchSmoothSourceSuccess(matchLastKeySource);
                    }
                }
            }

            public void onSmoothSwitchSourceFailed(d dVar, int i22, int i3, String str) {
                String[] split;
                synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.e(logTag, "onSmoothSwitchSourceFailed (type:" + i3 + ",key:" + i22 + ",msg:" + str + ")");
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSmoothSwitchSourceFailed current: ");
                    sb.append(MgtvMediaPlayer.this.getCurrentSmoothSourceKey());
                    DebugLog.e(logTag2, sb.toString());
                    int i4 = MgtvMediaPlayer.WHAT_SMOOTHSOURCE_FAIL;
                    int i5 = -1;
                    try {
                        if (!StringUtil.isEmpty(str) && (split = str.split("-")) != null && split.length >= 2) {
                            i4 = NumericUtil.parseInt(split[0]);
                            i5 = NumericUtil.parseInt(split[1]);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    SmoothMediaSource smoothMediaSource = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i22));
                    if (smoothMediaSource != null) {
                        if (smoothMediaSource.getReporter() != null) {
                            smoothMediaSource.getReporter().l(i4, i5, "");
                        }
                        if (MgtvMediaPlayer.this.mReportParams != null) {
                            String logTag3 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag3, "onSmoothSwitchSourceFailed mReportParams:" + MgtvMediaPlayer.this.mReportParams.getProxyType() + "-" + MgtvMediaPlayer.this.mReportParams.getP2ps());
                        }
                        if (smoothMediaSource.getReportParams() != null) {
                            String logTag4 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag4, "onSmoothSwitchSourceFailed currentSource.getReportParams():" + smoothMediaSource.getReportParams().getProxyType() + "-" + smoothMediaSource.getReportParams().getP2ps());
                        }
                        if (MgtvMediaPlayer.this.mReportParams != null && MgtvMediaPlayer.this.mReportParams.isP2p() && smoothMediaSource.getReportParams() != null && smoothMediaSource.getReportParams().isP2p()) {
                            MgtvMediaPlayer.this.mSmoothUseP2pFailed = true;
                            if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                                MgtvMediaPlayer.this.mMediaPlayer.k2(true);
                            }
                        }
                        if (smoothMediaSource.isThrowErrorIfSwitchFailed()) {
                            MgtvMediaPlayer.this.mErrorListener.onError(MgtvMediaPlayer.WHAT_SMOOTHSOURCE_EX_ERROR, i5);
                            return;
                        }
                    }
                    if (i3 == 1) {
                        MgtvMediaPlayer.this.mErrorListener.onError(i4, i5);
                        return;
                    }
                    SmoothMediaSource matchLastKeySource = MgtvMediaPlayer.this.matchLastKeySource(i22);
                    if (matchLastKeySource == null) {
                        DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "onSmoothSwitchSourceFailed matchKeySource failed");
                    } else {
                        MgtvMediaPlayer.this.notifySwitchSmoothSourceFail(matchLastKeySource, i4, i5);
                    }
                }
            }

            public void onSmoothSwitchSourceInfo(d dVar, int i22, int i3, String str) {
                synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.i(logTag, "onSmoothSwitchSourceInfo (event:" + i3 + ",key:" + i22 + ",msg:" + str + ")");
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSmoothSwitchSourceInfo current: ");
                    sb.append(MgtvMediaPlayer.this.getCurrentSmoothSourceKey());
                    DebugLog.i(logTag2, sb.toString());
                    SmoothMediaSource smoothMediaSource = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i22));
                    if (smoothMediaSource != null) {
                        if (i3 == 0) {
                            smoothMediaSource.s_event_0_timestamp = System.currentTimeMillis();
                        } else if (i3 == 11) {
                            smoothMediaSource.s_event_11_timestamp = System.currentTimeMillis();
                        } else if (i3 == 2) {
                            if (MgtvMediaPlayer.this.isFlowReportEnable) {
                                smoothMediaSource.genFlowReporter();
                            }
                            smoothMediaSource.s_event_2_timestamp = System.currentTimeMillis();
                        } else if (i3 == 3) {
                            if (MgtvMediaPlayer.this.isFlowReportEnable && MgtvMediaPlayer.this.mMainFlowReportProcessor != null) {
                                MgtvMediaPlayer.this.mMainFlowReportProcessor.stop();
                            }
                            for (Map.Entry entry : MgtvMediaPlayer.this.mSmoothSourcesRecord.entrySet()) {
                                if (((Integer) entry.getKey()).intValue() < smoothMediaSource.getKey()) {
                                    SmoothMediaSource smoothMediaSource2 = (SmoothMediaSource) entry.getValue();
                                    if (MgtvMediaPlayer.this.isFlowReportEnable && smoothMediaSource2 != null && smoothMediaSource2.getFlowReportProcessor() != null) {
                                        smoothMediaSource2.getFlowReportProcessor().stop();
                                    }
                                }
                            }
                            smoothMediaSource.s_event_3_timestamp = System.currentTimeMillis();
                        }
                    }
                    if (i3 != 3) {
                        if (MgtvMediaPlayer.this.matchLastKeySource(i22) == null) {
                            DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "onSmoothSwitchSourceInfo matchKeySource failed");
                            return;
                        }
                        if (i3 == 0) {
                            MgtvMediaPlayer.this.mSourceSwitching = true;
                        }
                        return;
                    }
                    SmoothMediaSource smoothMediaSource3 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(this.lastSwitchingKey));
                    if (smoothMediaSource3 != null && smoothMediaSource3.getReporter() != null) {
                        smoothMediaSource3.getReporter().M();
                    }
                    this.lastSwitchingKey = i22;
                    SmoothMediaSource smoothMediaSource4 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i22));
                    if (smoothMediaSource4 != null && MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener != null) {
                        MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener.onSwitchSmoothSourceInfo(smoothMediaSource4, i3);
                    }
                }
            }
        };
        this.mSmoothSourcesRecord = new HashMap();
        this.mSwitchSmoothSourceLocker = new Object();
        this.mSmoothUseP2pFailed = false;
        this.mSmoothKeyFrameMap = Collections.synchronizedMap(new HashMap());
        this.isBackground = false;
        this.isSpaceAudioSwitchOn = false;
        this.mBundle = bundle;
        extractBundleData();
        init(i, context, z);
    }

    public MgtvMediaPlayer(Context context) throws UnsatisfiedLinkError, SecurityException, NullPointerException, OutOfMemoryError {
        this.mDebug = false;
        this.mPreBufferTimeoutMs = 1800000;
        this.mBufferTimeoutMs = 180000;
        this.mImgoMediaPlayerAudioMode = false;
        this.mAccurateSeekEnable = true;
        this.mAccSeekKeyFrameInterval = 1000;
        this.mKeyframeSeekEnable = false;
        this.mInnerAutoRotateEnable = false;
        this.mWeakBufferSpeedKB = 1;
        this.mWeakBufferTimeoutMs = 120000;
        this.mTsNotSkip = false;
        this.mLoadMaxRetryTime = 2;
        this.mPrepared = false;
        this.mIsBuffering = false;
        this.mErrorUrl = "";
        this.mLastRequestUrl = "";
        this.mLastDlSize = 0;
        this.mIsLive = false;
        this.mPlayerMode = 0;
        this.mLiveReopen = false;
        this.mLoopPlayerSwitchUrl = "";
        this.mHDJSwitchUrl = "";
        this.mDataSourceType = DataSourceType.TYPE_DATASOUCE_DEFAULT;
        this.mErrorExtraCodeStore = -1;
        this.mRecordVfps = 0.0f;
        this.mLastVideoWidth = 0;
        this.mLastVideoHeight = 0;
        this.mSkipLoopFilterType = SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mAddrinfoType = AddrinfoType.TYPE_ADDRINFO_DEFAULT;
        this.mAddrinfoTimeoutMs = 0;
        this.mPrepared4StartMode = Prepared4StartMode.MODE_PREPARED4START_DEFAULT;
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.2
            private boolean needInnerRetry(int i22, int i3) {
                return !MgtvMediaPlayer.this.mIsInnerRetrying && MgtvMediaPlayer.this.mMediaPlayer.b4() == 2 && i22 == 200003 && i3 == 100606;
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i22, int i3) {
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.i(logTag, "onError what:" + i22 + ",extra:" + i3 + ",netType:" + NetPlayConfig.getNetworkType());
                if (MgtvMediaPlayer.this.mGifRecorder != null) {
                    MgtvMediaPlayer.this.mGifRecorder.interrupt(101);
                }
                if (MgtvMediaPlayer.this.isDnsCacheEnable()) {
                    MgtvMediaPlayer.this.checkAndCleanDnsCache(i22, i3);
                }
                if (needInnerRetry(i22, i3)) {
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "onError needInnerRetry");
                    MgtvMediaPlayer.this.mIsInnerRetrying = true;
                    MgtvMediaPlayer.this.mRetryLastErrorCode = i3;
                    MgtvMediaPlayer.this.setPlayerReset(true);
                    if (MgtvMediaPlayer.this.mMediaPlayer.b0()) {
                        MgtvMediaPlayer.this.mMediaPlayer.v1(MgtvMediaPlayer.this.mMediaPlayer.t(), i22, i3, MgtvMediaPlayer.this.mMediaPlayer.b4());
                    } else {
                        MgtvMediaPlayer.this.mMediaPlayer.u1(MgtvMediaPlayer.this.mMediaPlayer.t(), i22, i3);
                    }
                    return true;
                }
                MgtvMediaPlayer.this.beforeThrowError(i22, i3);
                MgtvMediaPlayer.this.reportErrorWarning(i22, i3);
                if (i22 != 7000006) {
                    MgtvMediaPlayer.this.reportError(i22, i3, "");
                }
                MgtvMediaPlayer.this.stopTickers();
                MgtvMediaPlayer.this.mPlayStatus = PlayStatus.ERROR;
                MgtvMediaPlayer.this.mErrorExtraCodeStore = i3;
                if (MgtvMediaPlayer.this.mOnErrorListener != null) {
                    return MgtvMediaPlayer.this.mOnErrorListener.onError(i22, i3);
                }
                return true;
            }
        };
        this.mIsGetPositionCallback = false;
        this.mPlayStatus = PlayStatus.IDLE;
        this.mRenderType = RenderType.NATIVE_WINDOW;
        this.mPlayTicker = new ExTicker(1000).setTypeStr("play");
        this.mBufferTick = new ExTicker(1000).setTypeStr("buffer");
        this.mPlayerType = 2;
        this.mMainThreadID = -1L;
        this.mCacheReplaceMap = new LinkedHashMap();
        this.mIsInnerRetrying = false;
        this.mRetryLastErrorCode = 0;
        this.mRenderDisableWarnSended = false;
        this.mForceHttpDns = false;
        this.mHttpDnsNeedRetry = false;
        this.mJavaDnsEnable = false;
        this.mJavaDnsType = a.d.b;
        this.mHttpDnsEnable = false;
        this.mPlayerReset = true;
        this.mLoopPlayerReset = true;
        this.mLastUri = null;
        this.mLastHostErr = MLog.a.b;
        this.mLastTcpErr = MLog.a.b;
        this.mLastIpCount = 0;
        this.mLastIpIndex = -1;
        this.mLastDnsType = -1;
        this.mCurrentDnsDsc = "native";
        this.mEnableP2PHttpDns = false;
        this.mForceP2pHttpDns = false;
        this.mDnsThreadManager = new c().b(new c.c() { // from class: com.hunantv.media.player.MgtvMediaPlayer.3
            public void updateIPs(String str, List<String> list) {
                P2pMgr.YfAddBackupIps(str, list, MgtvMediaPlayer.this.mForceP2pHttpDns);
            }
        });
        this.mAVSyncErrReported = false;
        this.mAVSyncErrSumReported = false;
        this.mAVSyncErrSum = 0;
        this.mAVSyncStartTimestamp = 0L;
        this.mPrepareAsyncTimeStampMs = 0L;
        this.mPreBufferState = new SyncStateMachine(1);
        this.mPreBufferMaxS = 5;
        this.mIsAudioExist = -1;
        this.mIsVsrOpen = -1;
        this.mIsNativePausedLoadData = 0;
        this.mIsWanosAudioEffectValid = false;
        this.mLastPosition = 0;
        this.mPositionLoged = false;
        this.mRealEncodeType = -1;
        this.mStreamFormatType = -1;
        this.mNotifyHandler = new MainNotifyHandler(this);
        this.mWillOpenUrl = "";
        this.mReportedTSLAN = false;
        this.mDnsLock = new Object();
        this.mIsP2pTSSkipReport = false;
        this.mCodecName = "n";
        this.mVVbuft = -1;
        this.mEnableJAVAIPCacheMap = false;
        this.mIPCacheMap = new HashMap();
        this.mVideoFrameClockNotifyMs = -1;
        this.mVideoFrameClockNotifyType = -1;
        this.mVideoFrameClockNotifyTimeStart = -1L;
        this.mVideoFrameClockNotifyTimeEnd = -1L;
        this.mCacheReportTag = DEFAULT_CACHE_REPORT_TAG;
        this.mCacheReportLerr = 0;
        this.mEnableDnsNoNetStrategy = false;
        this.mDnsNoNetWaiter = new Object();
        this.mLastIsNetworkAvailableNNS = true;
        this.mDnsNoNetMaxRetry = 20;
        this.mLastTsSkipErrExtra = 0;
        this.fstime = "n/n";
        this.mcColorFormat = "n_n";
        this.isFlowReportEnable = false;
        this.vsri = "0|0_0|0_0";
        this.vsrver = "n";
        this.vsrvkver = "n";
        this.vsrnpuver = "n";
        this.mSourceNetListner = new MgtvPlayerListener.OnSourceNetHandledListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.4
            public static final int REPORT_HTTP_DNS_INTERRUPT = -2;
            public static final int REPORT_HTTP_DNS_PV = 0;
            private boolean mIsPauseLoad = false;

            private void checkErrorCode(int i22, int i3, Bundle bundle2) {
                if (bundle2 == null) {
                    return;
                }
                int i4 = bundle2.getInt("retry_counter");
                MgtvMediaPlayer.this.mSourceRetryCount = i4;
                MgtvMediaPlayer.this.mSourceRetryCode = i3;
                if (MgtvMediaPlayer.this.isDnsCacheEnable() && i4 >= 1 && MgtvMediaPlayer.this.checkAndCleanDnsCache(i22, i3)) {
                    MgtvMediaPlayer.this.mHttpDnsEnable = true;
                }
            }

            private boolean didHDJSwitch(Bundle bundle2) {
                if (MgtvMediaPlayer.this.mHDJSwitchUrl.length() <= 0 || bundle2 == null) {
                    return false;
                }
                bundle2.putString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_URL_STRING, MgtvMediaPlayer.this.mHDJSwitchUrl);
                bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_IS_LAST_INT, 1);
                MgtvMediaPlayer.this.mHDJSwitchUrl = "";
                return true;
            }

            private void didHostAddr(Bundle bundle2) {
                if (bundle2 == null) {
                    return;
                }
                int i22 = bundle2.getInt("host_error");
                int i3 = bundle2.getInt("host_family");
                String string = bundle2.getString("host_hostname");
                String string2 = bundle2.getString("host_ip");
                int i4 = bundle2.getInt("host_port");
                int i5 = MgtvMediaPlayer.this.mLastDnsType = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_HOST_ARRR_DNS_TYPE_INT);
                DebugLog.d(MgtvMediaPlayer.this.getLogTag(), "callback didHostAddr error:" + i22 + ",family:" + i3 + ",hostname:" + string + ",ip_list:" + string2 + ",port:" + i4 + ",hostDnsType:" + i5);
                MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                StringBuilder sb = new StringBuilder();
                sb.append(i22);
                sb.append("");
                mgtvMediaPlayer.mLastHostErr = sb.toString();
                MgtvMediaPlayer.this.mLastIpIndex = 0;
                try {
                    String[] split = string2.split(g.b);
                    MgtvMediaPlayer.this.mLastIpCount = 0;
                    if (split != null) {
                        for (String str : split) {
                            if (c.a.a.a.k.d.b(str)) {
                                MgtvMediaPlayer.access$4108(MgtvMediaPlayer.this);
                            }
                        }
                    }
                    MgtvMediaPlayer.this.mLastIps = split;
                    if (!MgtvMediaPlayer.this.mEnableJAVAIPCacheMap || i22 != 0 || MgtvMediaPlayer.this.mIPCacheMap.containsKey(string) || split == null || split.length <= 0) {
                        return;
                    }
                    IPList iPList = new IPList(string, split);
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "callback ipcache didHostAddr put:" + string + "-" + IPList.formatIPList(iPList.nUseList));
                    MgtvMediaPlayer.this.mIPCacheMap.put(string, iPList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private boolean didLiveOpen(Bundle bundle2) {
                if (bundle2 == null) {
                    return false;
                }
                return onLiveWillOpen(bundle2);
            }

            private boolean didLiveReopen(Bundle bundle2) {
                boolean z2 = MgtvMediaPlayer.this.mLiveReopen;
                if (MgtvMediaPlayer.this.mLiveReopen) {
                    MgtvMediaPlayer.this.mLiveReopen = false;
                }
                return z2;
            }

            private boolean didLoopOpen(Bundle bundle2) {
                if (bundle2 == null) {
                    return false;
                }
                return onLiveWillOpen(bundle2);
            }

            private boolean didLoopReopen(Bundle bundle2) {
                if (MgtvMediaPlayer.this.mLoopPlayerSwitchUrl.length() > 0) {
                    bundle2.putString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_URL_STRING, MgtvMediaPlayer.this.mLoopPlayerSwitchUrl);
                    MgtvMediaPlayer.this.mLoopPlayerSwitchUrl = "";
                    return true;
                }
                return false;
            }

            private void didTcpOpen(Bundle bundle2) {
                IPList iPList;
                if (bundle2 == null) {
                    return;
                }
                int i22 = bundle2.getInt("port");
                int i3 = bundle2.getInt("family");
                int i4 = bundle2.getInt("error");
                String string = bundle2.getString("ip");
                String string2 = bundle2.getString("tcp_hostname");
                long j = bundle2.getLong("switch_key");
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.i(logTag, "didTcpOpen switch_key:" + j);
                if (MgtvMediaPlayer.this.mMediaPlayer != null && MgtvMediaPlayer.this.mMediaPlayer.s() != null) {
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.i(logTag2, "didTcpOpen origin:" + MgtvMediaPlayer.this.mMediaPlayer.s());
                }
                String logTag3 = MgtvMediaPlayer.this.getLogTag();
                if (i4 != 0) {
                    DebugLog.e(logTag3, "chodison didTcpOpen port:" + i22 + ",family:" + i3 + ",error_code:" + i4 + ",ip:" + string + ",hostname:" + string2);
                } else {
                    DebugLog.i(logTag3, "chodison didTcpOpen port:" + i22 + ",family:" + i3 + ",ip:" + string + ",hostname:" + string2);
                }
                MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                mgtvMediaPlayer.mLastTcpErr = i4 + "";
                MgtvMediaPlayer.this.mLastTcpIP = string;
                MgtvMediaPlayer.access$2808(MgtvMediaPlayer.this);
                if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap) {
                    try {
                        if (!MgtvMediaPlayer.this.mIPCacheMap.containsKey(string2) || (iPList = (IPList) MgtvMediaPlayer.this.mIPCacheMap.get(string2)) == null) {
                            return;
                        }
                        String logTag4 = MgtvMediaPlayer.this.getLogTag();
                        DebugLog.i(logTag4, "callback ipcache didTcpOpen remove " + string + " from " + string2);
                        iPList.nUseList.remove(string);
                        String logTag5 = MgtvMediaPlayer.this.getLogTag();
                        DebugLog.i(logTag5, "callback ipcache didTcpOpen rest ip:" + IPList.formatIPList(iPList.nUseList));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            private boolean doNetHttpWillOpenFailed(int i22, int i3, Bundle bundle2) {
                boolean z2;
                List<String> list;
                String logTag;
                String str;
                checkErrorCode(i22, i3, bundle2);
                MgtvMediaPlayer.this.mErrorUrl = UrlUtil.getValidUrl(bundle2.getString("url"));
                int i4 = bundle2.getInt("cur_dl_dize");
                if (isInitMp4(MgtvMediaPlayer.this.mErrorUrl)) {
                    MgtvMediaPlayer.this.mIsInitMp4Error = true;
                } else {
                    MgtvMediaPlayer.this.mIsInitMp4Error = false;
                }
                int i5 = bundle2.getInt("retry_counter");
                if (UrlUtil.isFilePrefix(MgtvMediaPlayer.this.mErrorUrl) && !MgtvMediaPlayer.this.mCacheReplaceMap.isEmpty()) {
                    if (MgtvMediaPlayer.this.mOnWarningListener != null) {
                        MgtvPlayerListener.OnWarningListener onWarningListener = MgtvMediaPlayer.this.mOnWarningListener;
                        onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_TS_CACHE_SKIP, i3 + "", MgtvMediaPlayer.this.mErrorUrl, null);
                    }
                    String str2 = (String) MgtvMediaPlayer.this.mCacheReplaceMap.get(MgtvMediaPlayer.this.mErrorUrl);
                    if (str2 != null) {
                        MgtvMediaPlayer.access$7308(MgtvMediaPlayer.this);
                        MgtvMediaPlayer.this.mErrorUrl = str2;
                        bundle2.putString("url", str2);
                        String logTag2 = MgtvMediaPlayer.this.getLogTag();
                        DebugLog.i(logTag2, "doNetHttpWillOpenFailed replace local_url to " + str2);
                    }
                }
                bundle2.getString("player_hash");
                int i6 = bundle2.getInt("io_type");
                c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed url:%s,iotype:%d, RetryCount:%d,error_code:%d-%d", new Object[]{MgtvMediaPlayer.this.mErrorUrl, Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i22), Integer.valueOf(i3)});
                if (isENETUNREACHcode(i22, i3) || (MgtvMediaPlayer.this.mPrepared && isDnsError(i22, i3))) {
                    c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed network broken,RetryCount:%d,error_code:%d-%d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i22), Integer.valueOf(i3)});
                    return true;
                }
                synchronized (MgtvMediaPlayer.this.mDnsNoNetWaiter) {
                    if (!isPlayerReset() && MgtvMediaPlayer.this.mEnableDnsNoNetStrategy && isDnsError(i22, i3)) {
                        boolean d = c.a.a.b.d.d.d(MgtvMediaPlayer.this.mContext);
                        if (!d) {
                            DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 1000 in");
                            try {
                                MgtvMediaPlayer.this.mDnsNoNetWaiter.wait(1000L);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            logTag = MgtvMediaPlayer.this.getLogTag();
                            str = "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 1000 out";
                            DebugLog.i(logTag, str);
                            z2 = true;
                        } else if (!d || MgtvMediaPlayer.this.mLastIsNetworkAvailableNNS) {
                            z2 = false;
                        } else {
                            DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 3000 in");
                            try {
                                MgtvMediaPlayer.this.mDnsNoNetWaiter.wait(PayTask.j);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            logTag = MgtvMediaPlayer.this.getLogTag();
                            str = "doNetHttpWillOpenFailed DnsNetStrategy mDnsNoNetWaiter wait 3000 out";
                            DebugLog.i(logTag, str);
                            z2 = true;
                        }
                        MgtvMediaPlayer.this.mLastIsNetworkAvailableNNS = d;
                    } else {
                        z2 = false;
                    }
                }
                String logTag3 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.i(logTag3, "doNetHttpWillOpenFailed mIsLive:" + MgtvMediaPlayer.this.mIsLive + ",mPlayerMode:" + MgtvMediaPlayer.this.mPlayerMode + ",mPrepared:" + MgtvMediaPlayer.this.mPrepared + ",mIsBuffering:" + MgtvMediaPlayer.this.mIsBuffering + ",mTsNotSkip:" + MgtvMediaPlayer.this.mTsNotSkip + ",mLoadMaxRetryTime:" + MgtvMediaPlayer.this.mLoadMaxRetryTime + ",mPlayStatus:" + MgtvMediaPlayer.this.mPlayStatus + ",lip:" + MgtvMediaPlayer.this.getLastIP());
                DebugLog.ifmt(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed %d-%d-%d-%d-%s", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i22), Integer.valueOf(i3), MgtvMediaPlayer.this.mErrorUrl);
                if ((!MgtvMediaPlayer.this.mIsLive || MgtvMediaPlayer.this.isVod()) && MgtvMediaPlayer.this.mPlayerMode != 1) {
                    if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap && (i3 == 100911 || i3 == 300021 || CodeUtil.isHttp4XX(i22, i3) || CodeUtil.isHttp5XX(i22, i3))) {
                        String hostName = UrlUtil.getHostName(UrlUtil.getValidHttpUrl(bundle2.getString("url")));
                        if (!StringUtil.isEmpty(hostName) && !c.a.a.a.k.d.g(hostName) && MgtvMediaPlayer.this.mIPCacheMap.containsKey(hostName)) {
                            String logTag4 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag4, "callback ipcache will http contains host:" + hostName);
                            IPList iPList = (IPList) MgtvMediaPlayer.this.mIPCacheMap.get(hostName);
                            if (iPList != null && iPList.checkTTL() && (list = iPList.nUseList) != null && list.size() > 0) {
                                String logTag5 = MgtvMediaPlayer.this.getLogTag();
                                DebugLog.i(logTag5, "callback ipcache will http check ttl success." + iPList);
                                if (i5 >= 6) {
                                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "callback ipcache will http return false.not retry");
                                    reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                                    return false;
                                }
                                bundle2.putString("user_msg", MgtvMediaPlayer.USER_MSG_FLAG_USE_CACHE);
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "callback ipcache will http return true.try to goto ip choose");
                                reportHttpErrorPV(i5, MgtvMediaPlayer.this.mErrorUrl, i3, "ipcache");
                                return true;
                            }
                        }
                    }
                    reportHttpErrorPV(i5, MgtvMediaPlayer.this.mErrorUrl, i3, MgtvMediaPlayer.DEFAULT_CACHE_REPORT_TAG);
                    if (z2) {
                        if (i5 < MgtvMediaPlayer.this.mDnsNoNetMaxRetry) {
                            DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy retry cause by inDnsNetStrategy");
                            return true;
                        }
                        reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "doNetHttpWillOpenFailed DnsNetStrategy skip retry cause by errorRetryCount >= mDnsNoNetMaxRetry");
                        return false;
                    } else if (!MgtvMediaPlayer.this.mPrepared) {
                        if (UrlUtil.isM3u8(MgtvMediaPlayer.this.mErrorUrl)) {
                            if (i5 >= 2) {
                                reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                                return false;
                            }
                            return true;
                        } else if (MgtvMediaPlayer.this.isSkipRetryCode(i22, i3) || !isInitMp4(MgtvMediaPlayer.this.mErrorUrl) || i4 <= 0 || i5 >= 10) {
                            if (MgtvMediaPlayer.this.isSkipRetryCode(i22, i3) || i5 >= MgtvMediaPlayer.this.mLoadMaxRetryTime) {
                                MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                                mgtvMediaPlayer.callbackTsSkip(mgtvMediaPlayer.mErrorUrl, i22, i3);
                                reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                                return false;
                            }
                            return true;
                        } else {
                            return true;
                        }
                    } else if (MgtvMediaPlayer.this.mTsNotSkip && MgtvMediaPlayer.this.isRendered()) {
                        return true;
                    }
                } else if (!MgtvMediaPlayer.this.mPrepared) {
                    if (UrlUtil.isM3u8(MgtvMediaPlayer.this.mErrorUrl)) {
                        return i5 < 2;
                    }
                    MgtvMediaPlayer mgtvMediaPlayer2 = MgtvMediaPlayer.this;
                    mgtvMediaPlayer2.callbackTsSkip(mgtvMediaPlayer2.mErrorUrl, i22, i3);
                    return false;
                } else if (MgtvMediaPlayer.this.mIsBuffering && MgtvMediaPlayer.this.isHLSPlayingUrl() && i5 >= 1) {
                    if (UrlUtil.isSegment(MgtvMediaPlayer.this.mErrorUrl)) {
                        MgtvMediaPlayer mgtvMediaPlayer3 = MgtvMediaPlayer.this;
                        mgtvMediaPlayer3.callbackTsSkip(mgtvMediaPlayer3.mErrorUrl, i22, i3);
                    }
                    return false;
                }
                if (MgtvMediaPlayer.this.isSkipRetryCode(i22, i3) || i5 >= 2) {
                    if (UrlUtil.isSegment(MgtvMediaPlayer.this.mErrorUrl)) {
                        MgtvMediaPlayer mgtvMediaPlayer4 = MgtvMediaPlayer.this;
                        mgtvMediaPlayer4.callbackTsSkip(mgtvMediaPlayer4.mErrorUrl, i22, i3);
                    }
                    reportHttpErrorErr(i3, MgtvMediaPlayer.this.mErrorUrl);
                    return false;
                }
                return true;
            }

            private boolean doNewHttpWillOpen(Bundle bundle2) {
                int i22 = bundle2.getInt("error_type");
                int i3 = bundle2.getInt("error_code");
                bundle2.getInt("retry_counter");
                int i4 = bundle2.getInt("reset_iplist");
                MgtvMediaPlayer.this.mLastDlSize = bundle2.getInt("cur_dl_dize");
                bundle2.putString("user_msg", "init");
                if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap && i4 == 1) {
                    MgtvMediaPlayer.this.clearIPCache();
                }
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag, "doNewHttpWillOpen in error_what:" + i22 + ",error_extra:" + i3 + ",reset_iplist:" + i4 + ",mLastDlSize:" + MgtvMediaPlayer.this.mLastDlSize);
                bundle2.putInt("reset_iplist", 0);
                if (i3 == 0) {
                    MgtvMediaPlayer.this.mIsInitMp4Error = false;
                    if (i3 == 0 && MgtvMediaPlayer.this.mCacheEable) {
                        replaceUrlFromCache(bundle2);
                    }
                    return false;
                }
                boolean doNetHttpWillOpenFailed = doNetHttpWillOpenFailed(i22, i3, bundle2);
                String logTag2 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag2, "doNetHttpWillOpenFailed return " + doNetHttpWillOpenFailed + "," + i22 + "-" + i3 + "-" + MgtvMediaPlayer.this.mErrorUrl);
                return doNetHttpWillOpenFailed;
            }

            private boolean doWillGetEnv(Bundle bundle2) {
                String string = bundle2.getString("env_key");
                if (string == null || string.length() <= 0) {
                    return false;
                }
                bundle2.putString("env_value", System.getenv(string));
                return true;
            }

            private boolean doWillHostAddr(Bundle bundle2) {
                List<String> list;
                if (bundle2 == null) {
                    return false;
                }
                int i22 = bundle2.getInt("addr_handle");
                String string = bundle2.getString("player_hash");
                int i3 = bundle2.getInt("retry_counter");
                String string2 = bundle2.getString("user_msg");
                String string3 = bundle2.getString("addr_hostname");
                long j = bundle2.getLong("switch_key");
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag, "callback doWillHostAddr is_handle:" + i22 + ",hash:" + string + ",count_int:" + i3 + ",user_msg:" + string2 + ",hostname:" + string3 + ",switch_key:" + j);
                if (MgtvMediaPlayer.this.mEnableJAVAIPCacheMap && i22 != 1 && MgtvMediaPlayer.USER_MSG_FLAG_USE_CACHE.equals(string2) && !c.a.a.a.k.d.g(string3) && MgtvMediaPlayer.this.mIPCacheMap.containsKey(string3)) {
                    try {
                        IPList iPList = (IPList) MgtvMediaPlayer.this.mIPCacheMap.get(string3);
                        if (iPList != null && (list = iPList.nUseList) != null && list.size() > 0 && iPList.checkTTL()) {
                            String str = iPList.nUseList.get(0);
                            if (c.a.a.a.k.d.b(str)) {
                                String logTag2 = MgtvMediaPlayer.this.getLogTag();
                                DebugLog.i(logTag2, "callback ipcache doWillHostAddr put chooseip:" + str);
                                String formatIPList = IPList.formatIPList(iPList.nUseList);
                                if (!StringUtil.isEmpty(formatIPList)) {
                                    String logTag3 = MgtvMediaPlayer.this.getLogTag();
                                    DebugLog.d(logTag3, "callback ipcache doWillHostAddr put srcIPListStr:" + formatIPList);
                                    bundle2.putString("addr_hostname", formatIPList);
                                }
                                bundle2.putString("addr_ip", str);
                                bundle2.putInt("addr_error", 0);
                                return false;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                String string4 = bundle2.getString("addr_uri");
                if (c.a.a.a.k.d.f(string3)) {
                    String E = MgtvMediaPlayer.this.mReporter != null ? MgtvMediaPlayer.this.mReporter.E() : "0";
                    notifyIpIsLAN(E, "hostname_" + string3);
                }
                boolean g = c.a.a.a.k.d.g(string3);
                boolean d = c.a.a.b.d.d.d(MgtvMediaPlayer.this.mContext);
                String logTag4 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag4, "doWillHostAddr hostname:" + string3 + ",isIp:" + g);
                String logTag5 = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag5, "doWillHostAddr is_handle=" + i22 + ",mBackJavaDns=" + MgtvMediaPlayer.this.mBackJavaDns + ",isIp=" + g + ",mForceHttpDns:" + MgtvMediaPlayer.this.mForceHttpDns);
                if ((MgtvMediaPlayer.this.mForceHttpDns && !g) || ((MgtvMediaPlayer.this.mJavaDnsEnable && !g) || (i22 == 1 && MgtvMediaPlayer.this.mBackJavaDns && !g))) {
                    if (d) {
                        MgtvMediaPlayer.this.mLastUri = string4;
                        domainResolve(string3, bundle2, MgtvMediaPlayer.this.mForceHttpDns);
                    } else {
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "skip domainResolve cause net not available");
                    }
                    return MgtvMediaPlayer.this.mPlayerReset;
                }
                if (i22 == 1 && g) {
                    bundle2.putString("addr_ip", string3);
                    bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CTRL_ARRR_DNS_TYPE_INT, 0);
                    bundle2.putInt("addr_error", 0);
                }
                return false;
            }

            private boolean doWillHttpOpen(Bundle bundle2) {
                if (bundle2 != null) {
                    MgtvMediaPlayer.this.mLastRequestUrl = UrlUtil.getValidUrl(bundle2.getString("url"));
                }
                if (MgtvMediaPlayer.this.mReportParams == null || !(MgtvMediaPlayer.this.mReportParams.getVideoType().equals(ReportParams.VideoType.AD_PRE) || MgtvMediaPlayer.this.mReportParams.getVideoType().equals(ReportParams.VideoType.AD_MID))) {
                    if (bundle2 != null) {
                        MgtvMediaPlayer.this.mWillOpenUrl = bundle2.getString("url");
                    }
                    return doNewHttpWillOpen(bundle2);
                }
                return onNormalHttpWillOpen(bundle2);
            }

            private void domainResolve(String str, Bundle bundle2, boolean z2) {
                a.d c;
                int k;
                if (str == null || bundle2 == null) {
                    DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "skip domainResolve hostname or args is null");
                    return;
                }
                a aVar = new a();
                aVar.d(new a.c() { // from class: com.hunantv.media.player.MgtvMediaPlayer.4.1
                    public void onDnsFail(a aVar2) {
                    }

                    public void onDnsFinish(a aVar2) {
                        synchronized (MgtvMediaPlayer.this.mDnsLock) {
                            MgtvMediaPlayer.this.mDnsLock.notifyAll();
                        }
                    }

                    public void onDnsStart(a aVar2) {
                    }

                    public void onDnsSuc(a aVar2, String[] strArr) {
                    }
                });
                boolean resolveStrategy = resolveStrategy(aVar, str, bundle2, z2, MgtvMediaPlayer.this.mHttpDnsNeedRetry);
                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve use:" + resolveStrategy);
                if (resolveStrategy) {
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve use type:" + aVar.c());
                    notifyHttpDnsReport(aVar.c(), MainNotifyHandler.MSG_HTTPDNS_REPORT_PV, 0);
                }
                synchronized (MgtvMediaPlayer.this.mDnsLock) {
                    while (aVar.n() && !isJavaDnsInterrupt()) {
                        DebugLog.d(MgtvMediaPlayer.this.getLogTag(), "domainResolve wait in");
                        try {
                            MgtvMediaPlayer.this.mDnsLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                DebugLog.d(MgtvMediaPlayer.this.getLogTag(), "domainResolve wait out. resolving:" + aVar.n() + ",isJavaDnsInterrupt:" + isJavaDnsInterrupt());
                String[] c2 = c.a.a.a.k.d.c(aVar.m());
                aVar.o();
                String str2 = "costMs:" + aVar.i() + ";ips:" + com.hunantv.media.utils.StringUtil.formatArrayString(c2) + ";net:" + NetPlayConfig.getNetworkType() + g.b;
                String formatIPList = IPList.formatIPList(c2);
                String str3 = null;
                if (c2 != null && c2.length > 0) {
                    str3 = c2[0];
                }
                int i22 = AnonymousClass28.$SwitchMap$com$hunantv$media$player$dns$AsyncDns$DnsType[aVar.c().ordinal()] == 1 ? 4 : 5;
                if (!isJavaDnsInterrupt() && c.a.a.a.k.d.b(str3)) {
                    if (resolveStrategy) {
                        updateCurrentDnsDsc(aVar.c());
                        if (c.a.a.a.k.d.f(str3)) {
                            notifyHttpDnsReport(aVar.c(), 2001, 100, str2);
                        } else {
                            notifyHttpDnsReport(aVar.c(), 2001, 0, str2);
                        }
                    }
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve put iplist:" + formatIPList);
                    bundle2.putString("addr_hostname", formatIPList);
                    if (c.a.a.a.k.d.b(str3)) {
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "domainResolve put firstIP:" + str3);
                        bundle2.putString("addr_ip", str3);
                    }
                    bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CTRL_ARRR_DNS_TYPE_INT, i22);
                    bundle2.putInt("addr_error", 0);
                    return;
                }
                if (resolveStrategy) {
                    if (isJavaDnsInterrupt() && aVar.k() == 0) {
                        c = aVar.c();
                        k = -2;
                    } else {
                        c = aVar.c();
                        k = aVar.k();
                    }
                    notifyHttpDnsReport(c, 2002, k, str2);
                    if (!isJavaDnsInterrupt()) {
                        int a = aVar.a((int) Opcodes.IFNONNULL);
                        if (aVar.k() != 0) {
                            a = aVar.k();
                        } else if (str3 != null && !c.a.a.a.k.d.g(str3)) {
                            a = aVar.a(107);
                        }
                        int i3 = -a;
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), aVar.c() + "resolve putInt error:" + i3);
                        bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CTRL_ARRR_DNS_TYPE_INT, i22);
                        bundle2.putInt("addr_error", i3);
                    }
                }
                MgtvMediaPlayer.this.mCurrentDnsDsc = "native";
            }

            private String findTsCachPath(String str, String[] strArr) {
                if (strArr == null) {
                    return null;
                }
                try {
                    String fileName = UrlUtil.getFileName(str);
                    for (String str2 : strArr) {
                        if (str2 != null && new File(str2).getName().equals(fileName)) {
                            return str2;
                        }
                    }
                } catch (Exception unused) {
                }
                return null;
            }

            private boolean isDnsError(int i22, int i3) {
                return i3 == 300600 || i22 == 400605 || MGTVP2pDirectMediaDataSource.isP2pDirectDnsError(i22, i3);
            }

            private boolean isENETUNREACHcode(int i22, int i3) {
                return i3 == 300005 || MGTVP2pDirectMediaDataSource.getShortErrorCode(i22, i3) == 101;
            }

            private boolean isInitMp4(String str) {
                return MgtvMediaPlayer.this.isHLSPlayingUrl() && UrlUtil.isSuffixUrl(str, ".mp4");
            }

            private boolean isJavaDnsInterrupt() {
                return isPlayerReset();
            }

            private boolean isPlayerReset() {
                return MgtvMediaPlayer.this.mPlayerReset || (MgtvMediaPlayer.this.mPlayerMode == 2 && MgtvMediaPlayer.this.mLoopPlayerReset);
            }

            private void notifyHttpDnsReport(a.d dVar, int i22, int i3) {
                notifyHttpDnsReport(dVar, i22, i3, "");
            }

            private void notifyHttpDnsReport(a.d dVar, int i22, int i3, String str) {
                if (dVar != a.d.b || MgtvMediaPlayer.this.mOnWarningListener == null) {
                    return;
                }
                notifyMessage(i22, i3, str);
            }

            private void notifyIpIsLAN(String str, String str2) {
                if (MgtvMediaPlayer.this.mOnWarningListener == null || MgtvMediaPlayer.this.mReportParams == null || MgtvMediaPlayer.this.mReportParams.getVideoType() != ReportParams.VideoType.VOD) {
                    return;
                }
                if (!MgtvMediaPlayer.this.mReportedTSLAN) {
                    notifyMessage(1002, str, str2 + "_suffix_" + UrlUtil.getSuffix(MgtvMediaPlayer.this.mWillOpenUrl));
                }
                if (UrlUtil.isM3u8(MgtvMediaPlayer.this.mWillOpenUrl)) {
                    return;
                }
                MgtvMediaPlayer.this.mReportedTSLAN = true;
            }

            private void notifyMessage(int i22, int i3, String str) {
                Message message = new Message();
                message.what = i22;
                message.arg1 = i3;
                message.obj = str;
                MgtvMediaPlayer.this.mNotifyHandler.sendMessage(message);
            }

            private void notifyMessage(int i22, String str, String str2) {
                Message message = new Message();
                message.what = i22;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MainNotifyHandler.BUNDLE_STR_INFO1, str);
                bundle2.putString(MainNotifyHandler.BUNDLE_STR_INFO2, str2);
                message.setData(bundle2);
                MgtvMediaPlayer.this.mNotifyHandler.sendMessage(message);
            }

            private boolean onLiveWillOpen(Bundle bundle2) {
                int i22 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_ERROR_WHAT_INT);
                int i3 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_ERROR_EXTRA_INT);
                MgtvMediaPlayer.this.mLastRequestUrl = UrlUtil.getValidUrl(bundle2.getString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_SRC_URL_STRING));
                if (i3 != 0) {
                    MgtvMediaPlayer.this.mErrorUrl = UrlUtil.getValidUrl(bundle2.getString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_SRC_URL_STRING));
                    int i4 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_COUNTER_INT);
                    int i5 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LIVE_RETRY_ERR_IO_TYPE_INT);
                    c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLiveWillOpen url:%s,iotype:%d, RetryCount:%d,error_code:%d-%d", new Object[]{MgtvMediaPlayer.this.mErrorUrl, Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i22), Integer.valueOf(i3)});
                    if (isENETUNREACHcode(i22, i3) || (MgtvMediaPlayer.this.mPrepared && isDnsError(i22, i3))) {
                        c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLiveWillOpen network broken,RetryCount:%d,error_code:%d-%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i22), Integer.valueOf(i3)});
                        return true;
                    }
                    DebugLog.ifmt(MgtvMediaPlayer.this.getLogTag(), "OnSourceNetHandledListener.CTRL_WILL_LIVE_OPEN %d-%d-%d-%d-%s", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i22), Integer.valueOf(i3), MgtvMediaPlayer.this.mErrorUrl);
                    return !MgtvMediaPlayer.this.isSkipRetryCode(i22, i3) && i4 < 2;
                }
                return false;
            }

            private boolean onLoopWillOpen(Bundle bundle2) {
                int i22 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_ERROR_WHAT_INT);
                int i3 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_ERROR_EXTRA_INT);
                if (i3 != 0) {
                    MgtvMediaPlayer.this.mErrorUrl = UrlUtil.getValidUrl(bundle2.getString(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_SRC_URL_STRING));
                    int i4 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_COUNTER_INT);
                    int i5 = bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_CRTL_LOOP_RETRY_ERR_IO_TYPE_INT);
                    c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLoopWillOpen url:%s,iotype:%d, RetryCount:%d,error_code:%d-%d", new Object[]{MgtvMediaPlayer.this.mErrorUrl, Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i22), Integer.valueOf(i3)});
                    if (isENETUNREACHcode(i22, i3) || (MgtvMediaPlayer.this.mPrepared && isDnsError(i22, i3))) {
                        c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "onLoopWillOpen network broken,RetryCount:%d,error_code:%d-%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i22), Integer.valueOf(i3)});
                        return true;
                    }
                    DebugLog.ifmt(MgtvMediaPlayer.this.getLogTag(), "OnSourceNetHandledListener.CTRL_WILL_LOOP_OPEN %d-%d-%d-%d-%s", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i22), Integer.valueOf(i3), MgtvMediaPlayer.this.mErrorUrl);
                    return !MgtvMediaPlayer.this.isSkipRetryCode(i22, i3) && i4 < 2;
                }
                return false;
            }

            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private boolean onNormalHttpWillOpen(android.os.Bundle r15) {
                /*
                    Method dump skipped, instructions count: 329
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.player.MgtvMediaPlayer.AnonymousClass4.onNormalHttpWillOpen(android.os.Bundle):boolean");
            }

            private boolean replaceUrlFromCache(Bundle bundle2) {
                String string = bundle2.getString("url");
                if (!UrlUtil.isFilePrefix(string) && !UrlUtil.isLocal(string)) {
                    String str = null;
                    String fileName = UrlUtil.getFileName(string);
                    if (StringUtil.isEmpty(fileName)) {
                        return false;
                    }
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.d(logTag, "replaceUrlFromCache try to find replace cache:" + string);
                    if (UrlUtil.isM3u8(string)) {
                        String str2 = MgtvMediaPlayer.this.mCacheM3u8Path;
                        String fileName2 = UrlUtil.getFileName(str2);
                        if (!StringUtil.isEmpty(str2) && !StringUtil.isEmpty(fileName2) && fileName2.equals(fileName)) {
                            str = str2;
                        }
                    } else if (MgtvMediaPlayer.this.isHLSPlayingUrl() && UrlUtil.isSegment(string)) {
                        str = findTsCachPath(string, MgtvMediaPlayer.this.mCacheTsPaths);
                    }
                    if (FileUtil.exist(str)) {
                        String addLocalPrefix = UrlUtil.addLocalPrefix(str);
                        if (!StringUtil.isEmpty(addLocalPrefix)) {
                            String logTag2 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag2, "replaceUrlFromCache from " + string);
                            String logTag3 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag3, "replaceUrlFromCache to " + addLocalPrefix);
                            bundle2.putString("url", addLocalPrefix);
                            if (UrlUtil.isM3u8(string)) {
                                String logTag4 = MgtvMediaPlayer.this.getLogTag();
                                DebugLog.d(logTag4, "replaceUrlFromCache put SRC_URL " + string);
                                bundle2.putString("src_url", string);
                            }
                            MgtvMediaPlayer.this.mCacheReplaceMap.put(addLocalPrefix, string);
                            return true;
                        }
                    }
                }
                return false;
            }

            private void reportHttpErrorErr(int i22, String str) {
                if ((isInitMp4(str) || UrlUtil.isM3u8(str)) && MgtvMediaPlayer.this.mReportParams != null && MgtvMediaPlayer.this.mReportParams.getVideoType() == ReportParams.VideoType.VOD && MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.NO_PROXY && MgtvMediaPlayer.this.mOnWarningListener != null) {
                    String E = MgtvMediaPlayer.this.mReporter != null ? MgtvMediaPlayer.this.mReporter.E() : MLog.a.b;
                    MgtvPlayerListener.OnWarningListener onWarningListener = MgtvMediaPlayer.this.mOnWarningListener;
                    String str2 = i22 + Consts.DOT + MgtvMediaPlayer.this.mCacheReportLerr;
                    StringBuilder sb = new StringBuilder();
                    sb.append("psuuid_");
                    sb.append(E);
                    sb.append("_render_");
                    sb.append(MgtvMediaPlayer.this.isRendered() ? "1" : "0");
                    sb.append("_url_");
                    sb.append(str);
                    sb.append("_type_");
                    sb.append(MgtvMediaPlayer.this.mCacheReportTag);
                    onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_HTTP_ERROR_ERR, str2, sb.toString(), null);
                }
            }

            private void reportHttpErrorPV(int i22, String str, int i3, String str2) {
                if (i22 == 0) {
                    MgtvMediaPlayer.this.mCacheReportTag = MgtvMediaPlayer.DEFAULT_CACHE_REPORT_TAG;
                    MgtvMediaPlayer.this.mCacheReportLerr = 0;
                }
                if (i22 == 0) {
                    if ((isInitMp4(str) || UrlUtil.isM3u8(str)) && MgtvMediaPlayer.this.mReportParams != null && MgtvMediaPlayer.this.mReportParams.getVideoType() == ReportParams.VideoType.VOD && MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.NO_PROXY && MgtvMediaPlayer.this.mOnWarningListener != null) {
                        String E = MgtvMediaPlayer.this.mReporter != null ? MgtvMediaPlayer.this.mReporter.E() : MLog.a.b;
                        MgtvMediaPlayer.this.mCacheReportTag = str2;
                        MgtvMediaPlayer.this.mCacheReportLerr = i3;
                        MgtvPlayerListener.OnWarningListener onWarningListener = MgtvMediaPlayer.this.mOnWarningListener;
                        String str3 = i3 + "";
                        StringBuilder sb = new StringBuilder();
                        sb.append("psuuid_");
                        sb.append(E);
                        sb.append("_render_");
                        sb.append(MgtvMediaPlayer.this.isRendered() ? "1" : "0");
                        sb.append("_url_");
                        sb.append(str);
                        sb.append("_type_");
                        sb.append(str2);
                        onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_HTTP_ERROR_PV, str3, sb.toString(), null);
                    }
                }
            }

            private boolean resolveStrategy(@NonNull a aVar, @NonNull String str, Bundle bundle2) {
                return resolveStrategy(aVar, str, bundle2, false, false);
            }

            private boolean resolveStrategy(@NonNull a aVar, @NonNull String str, Bundle bundle2, boolean z2, boolean z22) {
                a.d dVar;
                String logTag;
                String str2;
                if (z2 || (bundle2 != null && bundle2.getInt("addr_handle") == 1 && MgtvMediaPlayer.this.mBackJavaDns)) {
                    aVar.j(1);
                    dVar = a.d.b;
                } else {
                    if (MgtvMediaPlayer.this.isDnsCacheEnable()) {
                        if (MgtvMediaPlayer.this.mHttpDnsEnable) {
                            String a = StringUtil.isEmpty(MgtvMediaPlayer.this.mLastUri) ? null : c.a.a.a.k.e.a(MgtvMediaPlayer.this.mLastUri);
                            if (a != null && !a.trim().equals("")) {
                                logTag = MgtvMediaPlayer.this.getLogTag();
                                str2 = "resolveStrategy cache valid";
                            }
                        } else {
                            logTag = MgtvMediaPlayer.this.getLogTag();
                            str2 = "resolveStrategy cache valid and httpdns not open";
                        }
                        DebugLog.d(logTag, str2);
                        return false;
                    }
                    dVar = MgtvMediaPlayer.this.mJavaDnsType;
                }
                aVar.e(str, dVar, z22);
                return true;
            }

            private void updateCurrentDnsDsc(a.d dVar) {
                MgtvMediaPlayer mgtvMediaPlayer;
                String str;
                int i22 = AnonymousClass28.$SwitchMap$com$hunantv$media$player$dns$AsyncDns$DnsType[dVar.ordinal()];
                if (i22 == 1) {
                    mgtvMediaPlayer = MgtvMediaPlayer.this;
                    str = MgtvMediaPlayer.DNS_JAVA_NORMAL;
                } else if (i22 != 2) {
                    return;
                } else {
                    mgtvMediaPlayer = MgtvMediaPlayer.this;
                    str = MgtvMediaPlayer.DNS_JAVA_HTTPDNS;
                }
                mgtvMediaPlayer.mCurrentDnsDsc = str;
            }

            private void updateIp(String str) {
                String logTag;
                StringBuilder sb;
                String str2;
                if (MgtvMediaPlayer.this.mMediaPlayer == null || (!(MgtvMediaPlayer.this.mMediaPlayer.v() == 2 || MgtvMediaPlayer.this.mMediaPlayer.v() == 1) || MgtvMediaPlayer.this.mMediaPlayer.o4() == null)) {
                    if (MgtvMediaPlayer.this.mMediaPlayer == null || !((MgtvMediaPlayer.this.mMediaPlayer.v() == 2 || MgtvMediaPlayer.this.mMediaPlayer.v() == 1) && MgtvMediaPlayer.this.mMediaPlayer.o4() == null)) {
                        MgtvMediaPlayer.this.mLastIP = str;
                    } else {
                        MgtvMediaPlayer.this.mLastIP = "0.0.0.1";
                    }
                    logTag = MgtvMediaPlayer.this.getLogTag();
                    sb = new StringBuilder();
                    str2 = "didTcpOpen tcp_ip:";
                } else {
                    MgtvMediaPlayer mgtvMediaPlayer = MgtvMediaPlayer.this;
                    mgtvMediaPlayer.mLastIP = P2pMgr.getCdnIpFromP2PTask(mgtvMediaPlayer.mMediaPlayer.o4());
                    logTag = MgtvMediaPlayer.this.getLogTag();
                    sb = new StringBuilder();
                    str2 = "didTcpOpen p2p QueryTaskInfo cdnIp:";
                }
                sb.append(str2);
                sb.append(MgtvMediaPlayer.this.mLastIP);
                DebugLog.d(logTag, sb.toString());
            }

            private void willTcpOpen(Bundle bundle2) {
                if (bundle2 == null) {
                    return;
                }
                String string = bundle2.getString("tcp_hostname");
                String string2 = bundle2.getString("ip");
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag, "callback willTcpOpen tcp_hostname:" + string + ",tcp_ip:" + string2);
                MgtvMediaPlayer.this.mLastHostIP = string2;
                updateIp(string2);
                if (string2 == null || string2.length() <= 1 || !c.a.a.a.k.d.f(string2)) {
                    return;
                }
                notifyIpIsLAN("1", MgtvMediaPlayer.this.getCurrentDnsDsc() + "_hostip_" + string2);
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSourceNetHandledListener
            public boolean onSourceNetCtrl(int i22, Bundle bundle2) {
                IP2pTask o4;
                c.a.a.b.d.b.b(MgtvMediaPlayer.this.getLogTag(), "OnSourceNetHandledListener.onSourceNetCtrl 0x%5x", new Object[]{Integer.valueOf(i22)});
                switch (i22) {
                    case 131073:
                        willTcpOpen(bundle2);
                        break;
                    case 131074:
                        didTcpOpen(bundle2);
                        break;
                    case 131075:
                        return doWillHttpOpen(bundle2);
                    case 131077:
                        return didLiveOpen(bundle2);
                    case 131078:
                        return doWillHostAddr(bundle2);
                    case 131081:
                        return didLiveReopen(bundle2);
                    case 131088:
                        return didLoopOpen(bundle2);
                    case 131089:
                        return didLoopReopen(bundle2);
                    case 131090:
                        return didHDJSwitch(bundle2);
                    case 131104:
                        return doWillGetEnv(bundle2);
                    case 131120:
                        if (MgtvMediaPlayer.this.mPreBufferState.isEnable() && MgtvMediaPlayer.this.mPreBufferState.getState() == 2) {
                            this.mIsPauseLoad = true;
                            return true;
                        } else if (MgtvMediaPlayer.this.isSourceSwitching() || MgtvMediaPlayer.this.mMediaPlayer == null || (!(MgtvMediaPlayer.this.mMediaPlayer.v() == 2 || MgtvMediaPlayer.this.mMediaPlayer.v() == 1) || (o4 = MgtvMediaPlayer.this.mMediaPlayer.o4()) == null || o4.getStatus() == 0)) {
                            if (this.mIsPauseLoad) {
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "CTRL_WILL_CHECK_PAUSE_LOAD will return false. will resume load");
                            }
                            this.mIsPauseLoad = false;
                            return false;
                        } else {
                            if (!this.mIsPauseLoad) {
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "CTRL_WILL_CHECK_PAUSE_LOAD will return true. will pause load");
                            }
                            this.mIsPauseLoad = true;
                            return true;
                        }
                    case 131184:
                        synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                            if (bundle2 == null) {
                                break;
                            } else if (bundle2.getInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_NEED_RETRY_INT) == 1) {
                                if (MgtvMediaPlayer.this.mReporter != null) {
                                    MgtvMediaPlayer.this.mReporter.M();
                                }
                                int i3 = (int) bundle2.getLong(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_RETRY_KEY_LONG);
                                SmoothMediaSource smoothMediaSource = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i3));
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth need_retry == 1 find:" + i3);
                                if (smoothMediaSource != null) {
                                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth need_retry == 1 , will retry use :" + smoothMediaSource.getUrl());
                                    bundle2.putString("smooth_switch_url", smoothMediaSource.getUrl());
                                    if (smoothMediaSource.getReporter() != null) {
                                        smoothMediaSource.getReporter().H();
                                        if (MgtvMediaPlayer.this.mReportParams != null) {
                                            MgtvMediaPlayer.this.mReportParams.setPlaySessionId(smoothMediaSource.getReporter().E());
                                        }
                                    }
                                } else {
                                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth need_retry == 1, not found source");
                                }
                                bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_NEED_RETRY_INT, 0);
                                return true;
                            } else {
                                int i4 = (int) bundle2.getLong("smooth_switch_key");
                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth CTRL_WILL_SMOOTH_SWITCH switch_key:" + i4);
                                SmoothMediaSource matchLastKeySource = MgtvMediaPlayer.this.matchLastKeySource(i4);
                                if (matchLastKeySource != null) {
                                    if (matchLastKeySource.isLastRetry() && MgtvMediaPlayer.this.mReportParams != null && (MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.ONLY_P2P || MgtvMediaPlayer.this.mReportParams.getProxyType() == ReportParams.ProxyType.P2P_DRM)) {
                                        SmoothMediaSource smoothMediaSource2 = new SmoothMediaSource(MgtvMediaPlayer.this.getPlayingOriginUrl());
                                        smoothMediaSource2.setReportParams(MgtvMediaPlayer.this.mReportParams);
                                        smoothMediaSource2.bind(MgtvMediaPlayer.this);
                                        smoothMediaSource2.setThrowErrorIfSwitchFailed(true);
                                        MgtvMediaPlayer.this.mSmoothSourcesRecord.put(Integer.valueOf(smoothMediaSource2.getKey()), smoothMediaSource2);
                                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth is last retry. will retry key:" + smoothMediaSource2.getKey());
                                        bundle2.putInt(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_NEED_RETRY_INT, 1);
                                        bundle2.putLong(MgtvPlayerListener.OnSourceNetHandledListener.ARG_SMOOTH_SWITCH_RETRY_KEY_LONG, smoothMediaSource2.getKey());
                                    }
                                    if (!matchLastKeySource.isLastRetry()) {
                                        String string = bundle2.getString("smooth_switch_url");
                                        bundle2.putString("smooth_switch_url", string);
                                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth CTRL_WILL_SMOOTH_SWITCH switch_url:" + string);
                                        if (!StringUtil.isEmpty(string)) {
                                            int indexOf = string.indexOf(",mgtvjsource:");
                                            String substring = indexOf >= 0 ? string.substring(indexOf) : "";
                                            boolean onSwitchSmoothSourceWillUpdate = MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener != null ? MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener.onSwitchSmoothSourceWillUpdate(matchLastKeySource) : false;
                                            if (matchLastKeySource.getReadType() != 2 && onSwitchSmoothSourceWillUpdate && !StringUtil.isEmpty(matchLastKeySource.useUpdateUrl())) {
                                                String str = matchLastKeySource.useUpdateUrl() + substring;
                                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "smooth CTRL_WILL_SMOOTH_SWITCH will update url:" + str);
                                                bundle2.putString("smooth_switch_url", str);
                                            }
                                        }
                                    }
                                }
                                SmoothMediaSource smoothMediaSource3 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i4));
                                if (smoothMediaSource3 != null && smoothMediaSource3.getReporter() != null) {
                                    smoothMediaSource3.getReporter().H();
                                    if (MgtvMediaPlayer.this.mReportParams != null) {
                                        MgtvMediaPlayer.this.mReportParams.setPlaySessionId(smoothMediaSource3.getReporter().E());
                                    }
                                }
                                return true;
                            }
                        }
                        break;
                }
                return false;
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSourceNetHandledListener
            public void onSourceNetEvent(int i22, Bundle bundle2) {
                if (i22 != 78338) {
                    return;
                }
                didHostAddr(bundle2);
            }
        };
        this.mLogTagKey = "";
        this.mEnableReport = true;
        this.p2pLocker = new Object();
        this.mSeekStartMs = -1L;
        this.mHw2SwType = Hw2SwType.NONE;
        this.mPlaybackSpeed = 1.0f;
        this.mRecordMaxPlaySpeed = 1.0f;
        this.mFrameListener = new MgtvPlayerListener.OnFrameListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.22
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnFrameListener
            public void onVFrameClockCome(MgtvPlayerListener.FrameClock frameClock) {
                synchronized (MgtvMediaPlayer.this.ptsLocker) {
                    WeakHandler weakHandler = MgtvMediaPlayer.this.ptsWeakHandler;
                    if (weakHandler != null) {
                        weakHandler.removeMessages(256);
                        Message message = new Message();
                        message.what = 256;
                        message.obj = frameClock;
                        MgtvMediaPlayer.this.ptsWeakHandler.sendMessage(message);
                    }
                    if (MgtvMediaPlayer.this.mOnFrameListener != null) {
                        MgtvMediaPlayer.this.mOnFrameListener.onVFrameClockCome(frameClock);
                    }
                }
            }
        };
        this.mInnerFlowDataStatistic = new FlowDataStatistic();
        this.mEnableImgoVsr = false;
        this.mLoopSourceKey = new AtomicInteger(1);
        this.mSubtitleSources = new ArrayList();
        this.ptsHandlerThread = null;
        this.ptsWeakHandler = null;
        this.ptsListeners = new HashSet();
        this.ptsLocker = new Object();
        this.mSmoothSourceListener = new d.n() { // from class: com.hunantv.media.player.MgtvMediaPlayer.26
            public int lastSwitchingKey = -1;

            public void onSmoothSwitchSourceComplete(d dVar, int i22, int i3, String str) {
                SmoothMediaSource smoothMediaSource;
                synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.d(logTag, "onSmoothSwitchSourceComplete (type:" + i3 + ",key:" + i22 + ",msg:" + str + ")");
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSmoothSwitchSourceComplete current: ");
                    sb.append(MgtvMediaPlayer.this.getCurrentSmoothSourceKey());
                    DebugLog.i(logTag2, sb.toString());
                    for (Map.Entry entry : MgtvMediaPlayer.this.mSmoothSourcesRecord.entrySet()) {
                        if (((Integer) entry.getKey()).intValue() < i22 && (smoothMediaSource = (SmoothMediaSource) entry.getValue()) != null && !smoothMediaSource.isReleased()) {
                            smoothMediaSource.release();
                        }
                    }
                    MgtvMediaPlayer.this.mSmoothUseP2pFailed = false;
                    if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                        MgtvMediaPlayer.this.mMediaPlayer.k2(false);
                    }
                    SmoothMediaSource smoothMediaSource2 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i22));
                    if (smoothMediaSource2 != null) {
                        if (!StringUtil.isEmpty(smoothMediaSource2.getVfps())) {
                            MgtvMediaPlayer.this.mRecordVfps = Float.parseFloat(smoothMediaSource2.getVfps());
                        }
                        MgtvMediaPlayer.this.mLastVideoWidth = smoothMediaSource2.getVideoWidth();
                        MgtvMediaPlayer.this.mLastVideoHeight = smoothMediaSource2.getVideoHeight();
                        if (MgtvMediaPlayer.this.mReporter != null) {
                            MgtvMediaPlayer.this.mReporter.M();
                        }
                        MgtvMediaPlayer.this.mReporter = smoothMediaSource2.getReporter();
                        if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                            MgtvMediaPlayer.this.mMediaPlayer.o0(MgtvMediaPlayer.this.mReporter);
                            MgtvMediaPlayer.this.mMediaPlayer.A0(smoothMediaSource2.getReadType(), smoothMediaSource2.getUrl(), smoothMediaSource2.getPlayingUrl());
                            MgtvMediaPlayer.this.mMediaPlayer.N1(smoothMediaSource2.getEnableImgoAIQE());
                        }
                        if (MgtvMediaPlayer.this.mDataSourceInfo != null) {
                            MgtvMediaPlayer.this.mDataSourceInfo.setVideoFormat(smoothMediaSource2.getVideoFormat());
                            MgtvMediaPlayer.this.mDataSourceInfo.setAudioFormat(smoothMediaSource2.getAudioFormat());
                            MgtvMediaPlayer.this.mDataSourceInfo.setFileFormat(smoothMediaSource2.getFileFormat());
                        }
                        if (MgtvMediaPlayer.this.mReporter != null) {
                            MgtvMediaPlayer.this.mReportParams.deepCopy(smoothMediaSource2.getReportParams());
                            MgtvMediaPlayer.this.mReporter.n(MgtvMediaPlayer.this.mReportParams);
                            MgtvMediaPlayer.this.mReporter.N();
                        }
                        String keyFrameMapKey = MgtvMediaPlayer.this.getKeyFrameMapKey(smoothMediaSource2.getVid(), smoothMediaSource2.getDef());
                        if (MgtvMediaPlayer.this.mSmoothKeyFrameMap.containsKey(keyFrameMapKey)) {
                            String logTag3 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag3, "find smoothKeyFrameKey :" + keyFrameMapKey + " set to player");
                            byte[] bArr = MgtvMediaPlayer.this.mSmoothKeyFrameMap.get(keyFrameMapKey);
                            if (KeyFrameInfoUtils.isKeyFrameDataValid(bArr, smoothMediaSource2.videoFileHash) == 0) {
                                MgtvMediaPlayer.this.setKeyFrameInfoFileBuf(bArr);
                            }
                        }
                    }
                    SmoothMediaSource matchLastKeySource = MgtvMediaPlayer.this.matchLastKeySource(i22);
                    if (matchLastKeySource == null) {
                        DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "onSmoothSwitchSourceComplete matchKeySource failed");
                        return;
                    }
                    if (matchLastKeySource.getSwitchMod() == 1) {
                        MgtvMediaPlayer.this.mMediaPlayer.w2(true);
                    }
                    MgtvMediaPlayer.this.mSwitchedSmoothSource = matchLastKeySource;
                    MgtvMediaPlayer.this.mSourceSwitchingComplete = true;
                    MgtvMediaPlayer.this.mSourceSwitching = false;
                    if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                        MgtvMediaPlayer.this.mMainFlowReportProcessor = matchLastKeySource.getFlowReportProcessor();
                        MgtvMediaPlayer.this.mMediaPlayer.L0(matchLastKeySource.getP2pTask());
                        MgtvMediaPlayer.this.mMediaPlayer.j3(matchLastKeySource.getReadType());
                    }
                    MgtvMediaPlayer.this.mSmoothKeyFrameMap.clear();
                    if (MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener != null) {
                        MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener.onSwitchSmoothSourceSuccess(matchLastKeySource);
                    }
                }
            }

            public void onSmoothSwitchSourceFailed(d dVar, int i22, int i3, String str) {
                String[] split;
                synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.e(logTag, "onSmoothSwitchSourceFailed (type:" + i3 + ",key:" + i22 + ",msg:" + str + ")");
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSmoothSwitchSourceFailed current: ");
                    sb.append(MgtvMediaPlayer.this.getCurrentSmoothSourceKey());
                    DebugLog.e(logTag2, sb.toString());
                    int i4 = MgtvMediaPlayer.WHAT_SMOOTHSOURCE_FAIL;
                    int i5 = -1;
                    try {
                        if (!StringUtil.isEmpty(str) && (split = str.split("-")) != null && split.length >= 2) {
                            i4 = NumericUtil.parseInt(split[0]);
                            i5 = NumericUtil.parseInt(split[1]);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    SmoothMediaSource smoothMediaSource = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i22));
                    if (smoothMediaSource != null) {
                        if (smoothMediaSource.getReporter() != null) {
                            smoothMediaSource.getReporter().l(i4, i5, "");
                        }
                        if (MgtvMediaPlayer.this.mReportParams != null) {
                            String logTag3 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag3, "onSmoothSwitchSourceFailed mReportParams:" + MgtvMediaPlayer.this.mReportParams.getProxyType() + "-" + MgtvMediaPlayer.this.mReportParams.getP2ps());
                        }
                        if (smoothMediaSource.getReportParams() != null) {
                            String logTag4 = MgtvMediaPlayer.this.getLogTag();
                            DebugLog.i(logTag4, "onSmoothSwitchSourceFailed currentSource.getReportParams():" + smoothMediaSource.getReportParams().getProxyType() + "-" + smoothMediaSource.getReportParams().getP2ps());
                        }
                        if (MgtvMediaPlayer.this.mReportParams != null && MgtvMediaPlayer.this.mReportParams.isP2p() && smoothMediaSource.getReportParams() != null && smoothMediaSource.getReportParams().isP2p()) {
                            MgtvMediaPlayer.this.mSmoothUseP2pFailed = true;
                            if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                                MgtvMediaPlayer.this.mMediaPlayer.k2(true);
                            }
                        }
                        if (smoothMediaSource.isThrowErrorIfSwitchFailed()) {
                            MgtvMediaPlayer.this.mErrorListener.onError(MgtvMediaPlayer.WHAT_SMOOTHSOURCE_EX_ERROR, i5);
                            return;
                        }
                    }
                    if (i3 == 1) {
                        MgtvMediaPlayer.this.mErrorListener.onError(i4, i5);
                        return;
                    }
                    SmoothMediaSource matchLastKeySource = MgtvMediaPlayer.this.matchLastKeySource(i22);
                    if (matchLastKeySource == null) {
                        DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "onSmoothSwitchSourceFailed matchKeySource failed");
                    } else {
                        MgtvMediaPlayer.this.notifySwitchSmoothSourceFail(matchLastKeySource, i4, i5);
                    }
                }
            }

            public void onSmoothSwitchSourceInfo(d dVar, int i22, int i3, String str) {
                synchronized (MgtvMediaPlayer.this.mSwitchSmoothSourceLocker) {
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.i(logTag, "onSmoothSwitchSourceInfo (event:" + i3 + ",key:" + i22 + ",msg:" + str + ")");
                    String logTag2 = MgtvMediaPlayer.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSmoothSwitchSourceInfo current: ");
                    sb.append(MgtvMediaPlayer.this.getCurrentSmoothSourceKey());
                    DebugLog.i(logTag2, sb.toString());
                    SmoothMediaSource smoothMediaSource = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i22));
                    if (smoothMediaSource != null) {
                        if (i3 == 0) {
                            smoothMediaSource.s_event_0_timestamp = System.currentTimeMillis();
                        } else if (i3 == 11) {
                            smoothMediaSource.s_event_11_timestamp = System.currentTimeMillis();
                        } else if (i3 == 2) {
                            if (MgtvMediaPlayer.this.isFlowReportEnable) {
                                smoothMediaSource.genFlowReporter();
                            }
                            smoothMediaSource.s_event_2_timestamp = System.currentTimeMillis();
                        } else if (i3 == 3) {
                            if (MgtvMediaPlayer.this.isFlowReportEnable && MgtvMediaPlayer.this.mMainFlowReportProcessor != null) {
                                MgtvMediaPlayer.this.mMainFlowReportProcessor.stop();
                            }
                            for (Map.Entry entry : MgtvMediaPlayer.this.mSmoothSourcesRecord.entrySet()) {
                                if (((Integer) entry.getKey()).intValue() < smoothMediaSource.getKey()) {
                                    SmoothMediaSource smoothMediaSource2 = (SmoothMediaSource) entry.getValue();
                                    if (MgtvMediaPlayer.this.isFlowReportEnable && smoothMediaSource2 != null && smoothMediaSource2.getFlowReportProcessor() != null) {
                                        smoothMediaSource2.getFlowReportProcessor().stop();
                                    }
                                }
                            }
                            smoothMediaSource.s_event_3_timestamp = System.currentTimeMillis();
                        }
                    }
                    if (i3 != 3) {
                        if (MgtvMediaPlayer.this.matchLastKeySource(i22) == null) {
                            DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "onSmoothSwitchSourceInfo matchKeySource failed");
                            return;
                        }
                        if (i3 == 0) {
                            MgtvMediaPlayer.this.mSourceSwitching = true;
                        }
                        return;
                    }
                    SmoothMediaSource smoothMediaSource3 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(this.lastSwitchingKey));
                    if (smoothMediaSource3 != null && smoothMediaSource3.getReporter() != null) {
                        smoothMediaSource3.getReporter().M();
                    }
                    this.lastSwitchingKey = i22;
                    SmoothMediaSource smoothMediaSource4 = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf(i22));
                    if (smoothMediaSource4 != null && MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener != null) {
                        MgtvMediaPlayer.this.mOnSwitchSmoothSourceListener.onSwitchSmoothSourceInfo(smoothMediaSource4, i3);
                    }
                }
            }
        };
        this.mSmoothSourcesRecord = new HashMap();
        this.mSwitchSmoothSourceLocker = new Object();
        this.mSmoothUseP2pFailed = false;
        this.mSmoothKeyFrameMap = Collections.synchronizedMap(new HashMap());
        this.isBackground = false;
        this.isSpaceAudioSwitchOn = false;
        this.mMediaPlayer = new f(2, context);
        initData(context);
        initConfig();
        initReporter(context);
        initListener();
        initSpaceAudio();
    }

    public static /* synthetic */ int access$10608(MgtvMediaPlayer mgtvMediaPlayer) {
        int i = mgtvMediaPlayer.mAVSyncErrSum;
        mgtvMediaPlayer.mAVSyncErrSum = i + 1;
        return i;
    }

    public static /* synthetic */ int access$13308(MgtvMediaPlayer mgtvMediaPlayer) {
        int i = mgtvMediaPlayer.rfpsLowCounter;
        mgtvMediaPlayer.rfpsLowCounter = i + 1;
        return i;
    }

    public static /* synthetic */ int access$2808(MgtvMediaPlayer mgtvMediaPlayer) {
        int i = mgtvMediaPlayer.mLastIpIndex;
        mgtvMediaPlayer.mLastIpIndex = i + 1;
        return i;
    }

    public static /* synthetic */ int access$4108(MgtvMediaPlayer mgtvMediaPlayer) {
        int i = mgtvMediaPlayer.mLastIpCount;
        mgtvMediaPlayer.mLastIpCount = i + 1;
        return i;
    }

    public static /* synthetic */ int access$7308(MgtvMediaPlayer mgtvMediaPlayer) {
        int i = mgtvMediaPlayer.mTsCacheSkipNum;
        mgtvMediaPlayer.mTsCacheSkipNum = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beforeThrowError(int i, int i2) {
        this.mLastErrorTypeCode = getErrorCodeType(isRendered(), i, i2);
        String logTag = getLogTag();
        DebugLog.d(logTag, "beforeThrowError mLastErrorTypeCode:" + this.mLastErrorTypeCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean callBufferingTimeout(int i, int i2, String str) {
        IP2pTask o4;
        beforeThrowError(i, i2);
        reportErrorWarning(i, i2);
        reportError(i, i2, str);
        this.mPlayStatus = PlayStatus.ERROR;
        if (this.mOnBufferingTimeoutListener != null) {
            f fVar = this.mMediaPlayer;
            if (fVar != null && fVar.v() == 2 && (o4 = this.mMediaPlayer.o4()) != null && o4.getStatus() != 0) {
                i2 = MGTVMEDIA_ERROR_EXTRA_100907;
            }
            return this.mOnBufferingTimeoutListener.onBufferingTimeout(i, i2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackRecordError(int i, int i2) {
        MgtvPlayerListener.OnRecordVideoListener onRecordVideoListener = this.mOnRecordVideoListener;
        if (onRecordVideoListener != null) {
            onRecordVideoListener.onRecordVideoErr(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackRecordInfo(int i, int i2) {
        MgtvPlayerListener.OnRecordVideoListener onRecordVideoListener = this.mOnRecordVideoListener;
        if (onRecordVideoListener != null) {
            onRecordVideoListener.onRecordVideoInfo(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackSpatializer() {
        if (this.mgtvPlayerSpatializer != null && getDataSourceInfo() != null && canEnableSpatializer(getDataSourceInfo().getAudioChannel(), getDataSourceInfo().getAudioFormat()) && this.mgtvPlayerSpatializer.isAvailable() && this.isSpaceAudioSwitchOn && this.onSpatializerInfoListener != null) {
            DebugLog.i(TAG, "[Spatializer] onSpatializerStateChanged callback : true");
            this.onSpatializerInfoListener.onSpatializerStateChanged(true);
        } else if (this.onSpatializerInfoListener != null) {
            DebugLog.i(TAG, "[Spatializer] onSpatializerStateChanged callback : false");
            this.onSpatializerInfoListener.onSpatializerStateChanged(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackTsSkip(String str, int i, int i2) {
        String str2;
        String str3;
        ReportParams reportParams = this.mReportParams;
        if (reportParams == null || reportParams.getVideoType() != ReportParams.VideoType.LOCAL) {
            this.mLastTsSkipErrExtra = i2;
            this.mLastTsSkipErrFileName = UrlUtil.getFileName(str);
            if (this.mOnWarningListener != null && isHLSPlayingUrl() && UrlUtil.isSegment(str)) {
                if (isRendered()) {
                    DebugLog.i(getLogTag(), "callbackTsSkip what:" + i + ",extra:" + i2);
                    this.mOnWarningListener.onTsSkip(str, i, i2);
                }
                if (this.mIsP2pTSSkipReport || !MGTVP2pDirectMediaDataSource.isNoTaskByHashError(i, i2)) {
                    return;
                }
                f fVar = this.mMediaPlayer;
                String str4 = MLog.a.b;
                if (fVar == null) {
                    str2 = "11";
                } else if (fVar.o4() != null) {
                    str2 = this.mMediaPlayer.o4().getStrHash();
                    str4 = P2pMgr.isTaskExistInt(this.mMediaPlayer.o4()) + "";
                    str3 = this.mMediaPlayer.o4().getStatus() + "";
                    this.mOnWarningListener.onWarning(MGTVMEDIA_WARNING_P2P_TS_SKIP, i2 + "", "hash_" + str2 + "_taskcode_" + str4 + "_taskStatus_" + str3 + "_errorUrl_" + str, null);
                    this.mIsP2pTSSkipReport = true;
                } else {
                    str2 = "22";
                }
                str3 = MLog.a.b;
                this.mOnWarningListener.onWarning(MGTVMEDIA_WARNING_P2P_TS_SKIP, i2 + "", "hash_" + str2 + "_taskcode_" + str4 + "_taskStatus_" + str3 + "_errorUrl_" + str, null);
                this.mIsP2pTSSkipReport = true;
            }
        }
    }

    private boolean canEnableSpatializer(int i, String str) {
        String str2 = TAG;
        DebugLog.i(str2, "[Spatializer] current cannel: " + i + "current audioStr ：" + str);
        MgtvPlayerSpatializer mgtvPlayerSpatializer = this.mgtvPlayerSpatializer;
        if (mgtvPlayerSpatializer == null || !mgtvPlayerSpatializer.isEnabled()) {
            return false;
        }
        return (i >= 4 || (!StringUtil.isEmpty(str) && "wanos".equalsIgnoreCase(str))) && this.mgtvPlayerSpatializer.isInnerSpatializationSupported();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkAndCleanDnsCache(int i, int i2) {
        if (i == 400602 || i == 100002 || i2 == 300600 || i2 == 100901 || i2 == 100910 || i2 == 100911 || i2 == 100701 || CodeUtil.isHttp4XX(i, i2) || CodeUtil.isHttp5XX(i, i2)) {
            String str = this.mLastUri;
            if (str == null || str.trim().equals("")) {
                return true;
            }
            c.a.a.a.k.e.b(this.mLastUri);
            return true;
        }
        return false;
    }

    private boolean checkInvalidThread(int i, String str) {
        String str2;
        long j = this.mMainThreadID;
        if (j == -1 || j == Thread.currentThread().getId()) {
            return false;
        }
        if (this.mOnWarningListener != null) {
            if (this.mReportParams != null) {
                str2 = "videotype:" + this.mReportParams.getVideoType().ordinal();
            } else {
                str2 = "";
            }
            String str3 = str2 + str + " invalid thread. MainThread:" + this.mMainThreadID + ",CurrentThread:" + Thread.currentThread().getId();
            if (i == 0) {
                if (this.mIsGetPositionCallback) {
                    return true;
                }
                this.mIsGetPositionCallback = true;
                DebugLog.i(getLogTag(), "checkInvalidThread " + i + str3);
                return true;
            }
            this.mOnWarningListener.onWarning(MGTVMEDIA_WARNING_INVALID_THREAD, i + "", str3, null);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIPCache() {
        Map<String, IPList> map = this.mIPCacheMap;
        if (map == null || map.isEmpty()) {
            return;
        }
        DebugLog.i(getLogTag(), "callback ipcache clear");
        this.mIPCacheMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doBufferTick(int i) {
        if (getCurDLSpeed() > this.mWeakBufferSpeedKB * 1024) {
            this.mWeakTimer = 0;
            doBufferTickNormalNet((i * this.mBufferTick.getTickTime()) / 1000);
            return;
        }
        int i2 = this.mWeakTimer + 1;
        this.mWeakTimer = i2;
        doBufferTickWeakNet((i2 * this.mBufferTick.getTickTime()) / 1000);
    }

    private void doBufferTickNormalNet(int i) {
        int i2;
        String logTag = getLogTag();
        DebugLog.d(logTag, "doBufferTickNormalNet s:" + i);
        if (isRendered()) {
            if (i < this.mBufferTimeoutMs / 1000) {
                return;
            }
            String logTag2 = getLogTag();
            DebugLog.d(logTag2, "doBufferTickNormalNet >= " + (this.mBufferTimeoutMs / 1000));
            i2 = MGTVMEDIA_ERROR_EXTRA_100903;
        } else if (i < this.mPreBufferTimeoutMs / 1000) {
            return;
        } else {
            String logTag3 = getLogTag();
            DebugLog.d(logTag3, "doBufferTickNormalNet >= " + (this.mPreBufferTimeoutMs / 1000));
            i2 = MGTVMEDIA_ERROR_EXTRA_100900;
        }
        callBufferingTimeout(MGTVMEDIA_ERROR_300004, i2, "");
    }

    private void doBufferTickWeakNet(int i) {
        String logTag;
        StringBuilder sb;
        int i2;
        String logTag2 = getLogTag();
        DebugLog.d(logTag2, "doBufferTickWeakNet s:" + i);
        if (isRendered()) {
            if (i < this.mWeakBufferTimeoutMs / 1000) {
                return;
            }
            logTag = getLogTag();
            sb = new StringBuilder();
            sb.append("mWeakBufferTimeoutS >= ");
            i2 = this.mWeakBufferTimeoutMs;
        } else if (i < this.mPreBufferTimeoutMs / 1000) {
            return;
        } else {
            logTag = getLogTag();
            sb = new StringBuilder();
            sb.append("doBufferTickWeakNet >= ");
            i2 = this.mPreBufferTimeoutMs;
        }
        sb.append(i2);
        DebugLog.d(logTag, sb.toString());
        callBufferingTimeout(MGTVMEDIA_ERROR_300004, MGTVMEDIA_ERROR_EXTRA_100906, "");
    }

    private void doReportPV() {
        a.a.a.b.a aVar = this.mReporter;
        if (aVar != null) {
            aVar.H();
            ReportParams reportParams = this.mReportParams;
            if (reportParams != null) {
                reportParams.setPlaySessionId(this.mReporter.E());
            }
        }
    }

    private void doReportSLPV() {
        a.a.a.b.a aVar = this.mReporterSL;
        if (aVar != null) {
            aVar.H();
            ReportParams reportParams = this.mReportParams;
            if (reportParams != null) {
                reportParams.setPlaySessionId(this.mReporter.E());
            }
        }
    }

    private void extractBundleData() {
        Bundle bundle = this.mBundle;
        if (bundle != null) {
            this.mLogTagKey = bundle.getString(BUNDLE_KEY_LOG_TAG_KEY);
            this.mImgoMediaPlayerAudioMode = this.mBundle.getBoolean(BUNDLE_KEY_BOOLEAN_AUDIO_MODE);
            this.mEnableReport = this.mBundle.getBoolean(BUNDLE_KEY_BOOLEAN_ENABLE_REPORT, true);
            DebugLog.i(getLogTag(), "extractBundleData bundle not null");
        }
        String logTag = getLogTag();
        DebugLog.i(logTag, "extractBundleData mLogTagKey:" + this.mLogTagKey + ",mImgoMediaPlayerAudioMode:" + this.mImgoMediaPlayerAudioMode + ",mEnableReport:" + this.mEnableReport);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentSmoothSourceKey() {
        if (this.mSwitchingSmoothSource != null) {
            return this.mSwitchingSmoothSource.getKey();
        }
        return -1;
    }

    private MgtvPlayerSupporter.CODECTYPE getCurrentSourceCodecType() {
        try {
            String codecName = getCodecName();
            String logTag = getLogTag();
            DebugLog.i(logTag, "getSourceCodecType:" + codecName);
            if (!StringUtil.isEmpty(codecName)) {
                String lowerCase = codecName.toLowerCase();
                if (!lowerCase.equals("hevc") && !lowerCase.equals(DataSourceInfo.H265)) {
                    if (!lowerCase.equals("avc") && !lowerCase.equals(DataSourceInfo.H264)) {
                        return MgtvPlayerSupporter.CODECTYPE.OTHER;
                    }
                    return MgtvPlayerSupporter.CODECTYPE.AVC;
                }
                return MgtvPlayerSupporter.CODECTYPE.HEVC;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MgtvPlayerSupporter.CODECTYPE.OTHER;
    }

    public static String getErrorCodeType(boolean z, int i, int i2) {
        String str;
        StringBuilder sb;
        String str2;
        if (z) {
            str = "4.";
            if (isTimeoutError(i, i2)) {
                sb = new StringBuilder();
                sb.append(str);
                sb.append(EventClickData.i.y0);
            } else {
                sb = new StringBuilder();
                sb.append(str);
                str2 = EventClickData.i.B0;
                sb.append(str2);
            }
        } else {
            str = "3.";
            if (isTimeoutError(i, i2)) {
                sb = new StringBuilder();
                sb.append(str);
                sb.append(EventClickData.i.y0);
            } else {
                sb = new StringBuilder();
                sb.append(str);
                str2 = "105";
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    public static String getH264Decoder() {
        return BuildHelper.isApi16_JellyBeanOrLater() ? MediaCodecHelp.getH264Decoder() : IntegrityManager.INTEGRITY_TYPE_NONE;
    }

    public static String getH265Decoder(boolean z) {
        return BuildHelper.isApi16_JellyBeanOrLater() ? MediaCodecHelp.getH265Decoder(z) : IntegrityManager.INTEGRITY_TYPE_NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getKeyFrameMapKey(String str, String str2) {
        return str + "_" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLogTag() {
        return "[" + this.mLogTagKey + "][" + getClass().getSimpleName() + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getNetSpeedStr() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(getCurDLSpeed() / 1000.0f) + "KB/S";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getResolution() {
        return getVideoWidth() + "x" + getVideoHeight();
    }

    private void init(int i, Context context) {
        i = (i < 0 || i > 2) ? 2 : 2;
        this.mMediaPlayer = new f(i, context, this.mBundle);
        this.mPlayerType = i;
        initData(context);
        initConfig();
        initReporter(context);
        initListener();
        initSpaceAudio();
    }

    private void init(int i, Context context, boolean z) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "init playerType:" + i + ", enableTexture:" + z);
        i = (i < 0 || i > 2) ? 2 : 2;
        int i2 = this.mPlayerMode;
        if (i2 < 0 || i2 > 2) {
            this.mPlayerMode = 0;
        }
        if (BuildHelper.isApi14_IceCreamSandwichOrLater()) {
            this.mMediaPlayer = new f(i, context, z, this.mPlayerMode, this.mBundle);
        } else {
            if (z) {
                DebugLog.e(getLogTag(), "it isn't supported under 4.0 for setting TextureView");
            }
            this.mMediaPlayer = new f(i, context, false, this.mPlayerMode, this.mBundle);
        }
        this.mPlayerType = i;
        initData(context);
        initConfig();
        initReporter(context);
        initListener();
        initSpaceAudio();
    }

    private void initConfig() {
        this.mMediaPlayer.N0(this);
        this.mMediaPlayer.j2(201507063, 2);
        if (this.mImgoMediaPlayerAudioMode) {
            this.mMediaPlayer.j2(201507067, 1);
        } else {
            this.mMediaPlayer.j2(201507067, 0);
        }
        this.mMediaPlayer.j2(2016060201, 1);
        this.mMediaPlayer.j2(2016060202, 1);
        setDataSourceType(this.mDataSourceType);
        setSkipLoopFilter(this.mSkipLoopFilterType);
        setAccurateSeekEnable(true);
        if (Constants.FOR_OTT) {
            setRenderType(RenderType.NATIVE_WINDOW);
            setNetAddrinfo(AddrinfoType.TYPE_ADDRINFO_DEFAULT, -1, true, a.d.a, true);
            if (this.mImgoMediaPlayerAudioMode) {
                setForceKeyframeSeekEnable(false);
            } else {
                setForceKeyframeSeekEnable(true);
            }
        } else {
            setRenderType(NetPlayConfig.isNativeOpenglEnable() ? RenderType.OPENGL_ES : RenderType.NATIVE_WINDOW);
        }
        this.isExAudioEnable = NetPlayConfig.isWanosAudioEnable();
    }

    private void initData(Context context) {
        String str;
        f fVar;
        this.mContext = context;
        if (c.a.a.b.d.g.s() || c.a.a.b.d.g.t()) {
            str = "" + SystemUtil.getHwEmuiAPILevel();
        } else {
            str = "0";
        }
        DebugLog.i(TAG, "DeviceInfo======\nmLogTagKey:" + this.mLogTagKey + "\nMF:" + c.a.a.b.d.g.i() + "\nMod:" + NetPlayConfigHelper.getMod() + "\nMfOSVersion:" + c.a.a.b.d.g.k() + "\nCpuMf:" + c.a.a.b.d.g.a() + "\nCputy:" + NetPlayConfigHelper.getCputy() + "\nCputyValid:" + c.a.a.b.d.g.g() + "\nsver:" + c.a.a.b.d.g.o() + "\nsdkv:" + c.a.a.b.d.g.q() + "\nHwEmuiAPILevel:" + str + "\n======DeviceInfo\nconfig/play======\napiversion:" + NetPlayConfigHelper.getApiVersion() + "\nplayer_support:" + NetPlayConfig.getPrst() + "\naddrinfo_type:" + NetPlayConfig.getAddrt() + "\n======config/play");
        StringBuilder sb = new StringBuilder();
        sb.append(hashCode());
        sb.append("");
        PlayerReferenceObserver.add(sb.toString(), "", getLogTag());
        String str2 = this.mLogTagKey;
        if (str2 != null && (fVar = this.mMediaPlayer) != null) {
            fVar.y0(2018042501, str2);
        }
        try {
            this.mMainThreadID = Thread.currentThread().getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MgtvPlayerBroadcastObserver mgtvPlayerBroadcastObserver = new MgtvPlayerBroadcastObserver(context);
        this.mObserver = mgtvPlayerBroadcastObserver;
        mgtvPlayerBroadcastObserver.setOnNetworkChangeListener(new MgtvPlayerBroadcastObserver.OnNetworkChangeListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.5
            @Override // com.hunantv.media.utils.MgtvPlayerBroadcastObserver.OnNetworkChangeListener
            public void onNetworkChanged(int i, int i2) {
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.i(logTag, "onNetworkChanged " + i + "->" + i2);
                FFmpegApi.remove_all_dns_cache();
                if (MgtvMediaPlayer.this.isPlaying()) {
                    MgtvMediaPlayer.this.mNetworkChangeWhilePlaying = true;
                }
                synchronized (MgtvMediaPlayer.this.mDnsNoNetWaiter) {
                    if (i2 != -1) {
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "onNetworkChanged DnsNetStrategy mDnsNoNetWaiter notifyAll");
                        MgtvMediaPlayer.this.mDnsNoNetWaiter.notifyAll();
                    }
                }
            }
        });
        this.mObserver.setOnHeadsetListener(new MgtvPlayerBroadcastObserver.OnHeadsetListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.6
            @Override // com.hunantv.media.utils.MgtvPlayerBroadcastObserver.OnHeadsetListener
            public void onHeadsetStateChange(int i) {
                MgtvMediaPlayer mgtvMediaPlayer;
                int i2 = 1;
                if (i == 0) {
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "耳机拔出");
                    if (NetPlayConfig.inHeadsetBlackList(NetPlayConfigHelper.getMod()) && AudioUtil.isWired(MgtvMediaPlayer.this.mContext)) {
                        return;
                    }
                    mgtvMediaPlayer = MgtvMediaPlayer.this;
                } else if (i != 1) {
                    return;
                } else {
                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "耳机插入");
                    mgtvMediaPlayer = MgtvMediaPlayer.this;
                    i2 = 4;
                }
                mgtvMediaPlayer.setWanosAudioEffectChoice(i2);
            }
        });
        this.mObserver.setOnBluetoothHeadsetListener(new MgtvPlayerBroadcastObserver.OnBluetoothHeadsetListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.7
            @Override // com.hunantv.media.utils.MgtvPlayerBroadcastObserver.OnBluetoothHeadsetListener
            public void onBluetoothHeadsetStateChange(int i) {
                MgtvMediaPlayer mgtvMediaPlayer;
                int i2;
                if (i == 0 || i == 2) {
                    if (i == 2) {
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "BluetoothHeadset connected");
                        mgtvMediaPlayer = MgtvMediaPlayer.this;
                        i2 = 4;
                    } else {
                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "BluetoothHeadset disconnected");
                        mgtvMediaPlayer = MgtvMediaPlayer.this;
                        i2 = 1;
                    }
                    mgtvMediaPlayer.setWanosAudioEffectChoice(i2);
                    if (MgtvMediaPlayer.this.mMediaPlayer != null) {
                        MgtvMediaPlayer.this.mMediaPlayer.O3();
                    }
                }
            }
        });
    }

    private void initListener() {
        f fVar = this.mMediaPlayer;
        if (fVar == null) {
            return;
        }
        fVar.X0(new MgtvPlayerListener.OnPreparedListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.8
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPreparedListener
            public void onPrepared() {
                if (MgtvMediaPlayer.this.mMainFlowReportProcessor != null) {
                    MgtvMediaPlayer.this.mMainFlowReportProcessor.setDuration(MgtvMediaPlayer.this.getDuration());
                }
                if (MgtvMediaPlayer.this.mIsInnerRetrying && MgtvMediaPlayer.this.mPrepared) {
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.i(logTag, "onPrepared mIsInnerRetrying:" + MgtvMediaPlayer.this.mIsInnerRetrying + ",mPrepared:" + MgtvMediaPlayer.this.mPrepared + ",isPlaying:" + MgtvMediaPlayer.this.isPlaying());
                    if (MgtvMediaPlayer.this.mPlayStatus == PlayStatus.PLAYING) {
                        MgtvMediaPlayer.this.start();
                        return;
                    }
                    return;
                }
                MgtvMediaPlayer.this.mPlayStatus = PlayStatus.PREPARED;
                MgtvMediaPlayer.this.mPrepared = true;
                if (MgtvMediaPlayer.this.mSubtitleController != null) {
                    MgtvMediaPlayer.this.mSubtitleController.r();
                }
                if (MgtvMediaPlayer.this.mOnPreparedListener != null) {
                    MgtvMediaPlayer.this.mOnPreparedListener.onPrepared();
                }
                if (MgtvMediaPlayer.this.mReportParams == null || MgtvMediaPlayer.this.mReportParams.getVideoType() != ReportParams.VideoType.VOD || !ImgoLibLoader.getInstance().isBackUpLoaderSuccess() || MgtvMediaPlayer.this.mOnWarningListener == null) {
                    return;
                }
                MgtvMediaPlayer.this.mOnWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_BACKUP_LOAD_SUCCESS, "0", ImgoLibLoader.getInstance().getBackUpLoaderSoMsg(), null);
                ImgoLibLoader.getInstance().setBackUpLoaderSuccess(false);
            }
        });
        this.mMediaPlayer.U0(new MgtvPlayerListener.OnInfoListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.9
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnInfoListener
            public boolean onInfo(int i, int i2) {
                MgtvMediaPlayer mgtvMediaPlayer;
                Hw2SwType hw2SwType;
                String str;
                ImgovsrDeviceInfo vsrDeviceinfo;
                MgtvMediaPlayer mgtvMediaPlayer2;
                String str2;
                if (i == 3) {
                    MgtvMediaPlayer.this.callbackSpatializer();
                    if (MgtvMediaPlayer.this.onRenderStart()) {
                        return false;
                    }
                } else if (i != 4) {
                    if (i == 5) {
                        if (i2 == 503) {
                            mgtvMediaPlayer = MgtvMediaPlayer.this;
                            hw2SwType = Hw2SwType.HW_2_SW_RESET;
                        } else if (i2 == 501 || i2 == 504 || i2 == 505 || i2 == 506) {
                            mgtvMediaPlayer = MgtvMediaPlayer.this;
                            hw2SwType = Hw2SwType.HW_2_SW_DEFAULT;
                        } else {
                            mgtvMediaPlayer = MgtvMediaPlayer.this;
                            hw2SwType = Hw2SwType.HW_2_SW_OTHER;
                        }
                        mgtvMediaPlayer.mHw2SwType = hw2SwType;
                    } else if (i != 701) {
                        if (i != 702) {
                            switch (i) {
                                case 801:
                                    i = 801;
                                    if (i2 != 1) {
                                        MgtvMediaPlayer.this.mIsLive = false;
                                        break;
                                    } else {
                                        MgtvMediaPlayer.this.mIsLive = true;
                                        if (MgtvMediaPlayer.this.mOnWarningListener != null && MgtvMediaPlayer.this.mReportParams != null && MgtvMediaPlayer.this.mReportParams.getVideoType() == ReportParams.VideoType.VOD) {
                                            if (MgtvMediaPlayer.this.mReportParams != null) {
                                                str = MgtvMediaPlayer.this.mReportParams.getP2ps() + "";
                                            } else {
                                                str = MLog.a.b;
                                            }
                                            MgtvMediaPlayer.this.mOnWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_LIVE_IN_VOD, str, "psuuid_" + MgtvMediaPlayer.this.mReporter.E(), null);
                                            break;
                                        }
                                    }
                                    break;
                                case MgtvMediaPlayer.MEDIA_INFO_STREAM_INFO_HLS_SEG_SIZE_INFO /* 810 */:
                                    DebugLog.d(MgtvMediaPlayer.this.getLogTag(), "MEDIA_INFO_STREAM_INFO_HLS_SEG_SIZE_INFO:" + i2);
                                    break;
                                case MgtvMediaPlayer.MEDIA_INFO_DATA_PROTOCOL /* 2803 */:
                                    MgtvMediaPlayer.this.mDataSourceType = i2 != 1 ? DataSourceType.TYPE_DATASOUCE_DEFAULT : DataSourceType.TYPE_DATASOUCE_IMGO;
                                    break;
                                case MgtvMediaPlayer.MEDIA_INFO_STREAM_TYPE /* 2806 */:
                                    DebugLog.w(MgtvMediaPlayer.this.getLogTag(), "stream format type extra:" + i2);
                                    MgtvMediaPlayer.this.mStreamFormatType = i2;
                                    break;
                                case MgtvMediaPlayer.MEDIA_INFO_PLAYBACK_STATE_CHANGED /* 2830 */:
                                    if (i2 != d.t.e.ordinal()) {
                                        if (i2 == d.t.f.ordinal() && MgtvMediaPlayer.this.mOnPauseListener != null) {
                                            DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "callback onPause threadId:" + Thread.currentThread().getId());
                                            MgtvMediaPlayer.this.mOnPauseListener.onPause();
                                            break;
                                        }
                                    } else if (MgtvMediaPlayer.this.mOnStartListener != null) {
                                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "callback onStart threadId:" + Thread.currentThread().getId());
                                        MgtvMediaPlayer.this.mOnStartListener.onStart();
                                        break;
                                    }
                                    break;
                                case MgtvMediaPlayer.MEDIA_INFO_VIDEO_STREAM_TYPE /* 2840 */:
                                    DebugLog.w(MgtvMediaPlayer.this.getLogTag(), "encode type extra:" + i2);
                                    MgtvMediaPlayer.this.mRealEncodeType = i2;
                                    break;
                                case MgtvMediaPlayer.MEDIA_INFO_AV_SYNC_ERROR /* 2850 */:
                                    if (MgtvMediaPlayer.this.mOnWarningListener != null) {
                                        MgtvMediaPlayer.this.updateFpsInfo();
                                        String str3 = i2 + "_" + (MgtvMediaPlayer.this.isHardware() ? 1 : 0) + "_" + MgtvMediaPlayer.this.getResolution() + "_" + MgtvMediaPlayer.this.getFpsMsg();
                                        if (!MgtvMediaPlayer.this.mAVSyncErrReported) {
                                            MgtvMediaPlayer.this.mOnWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_AV_SYNC_ERR, str3, "", null);
                                            MgtvMediaPlayer.this.mAVSyncStartTimestamp = System.currentTimeMillis();
                                            MgtvMediaPlayer.this.mAVSyncErrReported = true;
                                        }
                                        if (!MgtvMediaPlayer.this.mAVSyncErrSumReported) {
                                            MgtvMediaPlayer.access$10608(MgtvMediaPlayer.this);
                                            if (System.currentTimeMillis() - MgtvMediaPlayer.this.mAVSyncStartTimestamp >= 10000) {
                                                MgtvMediaPlayer.this.mOnWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_AV_SYNC_SUM_ERR, str3 + "_" + MgtvMediaPlayer.this.mAVSyncErrSum, "", null);
                                                MgtvMediaPlayer.this.mAVSyncErrSumReported = true;
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                case 2880:
                                    MgtvMediaPlayer.this.mpx = i2;
                                    return false;
                                case 2890:
                                    DebugLog.d(MgtvMediaPlayer.this.getLogTag(), "MEDIA_INFO_M3U8_EXIST_DATA:" + i2);
                                    MgtvMediaPlayer.this.imp4dh = i2;
                                    return false;
                                case MgtvMediaPlayer.MEDIA_INFO_SPEED_RENDER_DISABLE /* 10010 */:
                                    DebugLog.w(MgtvMediaPlayer.this.getLogTag(), "speed play error,will disable video render!");
                                    if (!MgtvMediaPlayer.this.mRenderDisableWarnSended && MgtvMediaPlayer.this.mOnWarningListener != null) {
                                        MgtvMediaPlayer.this.mRenderDisableWarnSended = true;
                                        MgtvMediaPlayer.this.mOnWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_RENDER_DISABLE, i2 + "", "", null);
                                        break;
                                    }
                                    break;
                                case MgtvMediaPlayer.MEDIA_INFO_PREPARED_WATER_MARK_MS /* 10030 */:
                                    DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "native prepared change water mark ms:" + i2);
                                    MgtvMediaPlayer.this.mVVbuft = i2 / 1000;
                                    return false;
                                default:
                                    switch (i) {
                                        case MgtvMediaPlayer.MEDIA_INFO_AUDIO_IS_EXIST /* 10020 */:
                                            DebugLog.w(MgtvMediaPlayer.this.getLogTag(), "audio stream is exist:" + i2);
                                            MgtvMediaPlayer.this.mIsAudioExist = i2;
                                            break;
                                        case MgtvMediaPlayer.MEDIA_INFO_LOAD_DATA_STATUS /* 10021 */:
                                            DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "native load data is paused:" + i2);
                                            MgtvMediaPlayer.this.mIsNativePausedLoadData = i2;
                                            if (i2 == 1 && MgtvMediaPlayer.this.mOnLoadDataListener != null) {
                                                MgtvMediaPlayer.this.mOnLoadDataListener.onAfterLoadDataPaused();
                                                break;
                                            }
                                            break;
                                        case MgtvMediaPlayer.MEDIA_INFO_WANOS_AUDIO_EFFECT /* 10022 */:
                                            DebugLog.w(MgtvMediaPlayer.this.getLogTag(), "wanos audio effect valid:" + i2);
                                            MgtvMediaPlayer.this.mIsWanosAudioEffectValid = i2 == 1;
                                            break;
                                        case MgtvMediaPlayer.MEDIA_INFO_WANOS_AUDIO_DLOPEN /* 10023 */:
                                            DebugLog.w(MgtvMediaPlayer.this.getLogTag(), "wanos dlopen status:" + i2);
                                            MgtvMediaPlayer.this.wadls = i2;
                                            break;
                                        case MgtvMediaPlayer.MEDIA_INFO_VSR_IS_OPEN /* 10024 */:
                                            DebugLog.w(MgtvMediaPlayer.this.getLogTag(), "vsr is open:" + i2);
                                            MgtvMediaPlayer.this.mIsVsrOpen = i2;
                                            if (MgtvMediaPlayer.this.mIsVsrOpen == 2 && (str2 = (mgtvMediaPlayer2 = MgtvMediaPlayer.this).vsri) != null) {
                                                mgtvMediaPlayer2.vsri = str2.replace("1|", "2|");
                                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "vsri change to value:" + MgtvMediaPlayer.this.vsri);
                                            }
                                            if (MgtvMediaPlayer.this.mEnableImgoVsr || NetPlayConfig.getPlayCheckVsrVulkan() > 0) {
                                                MgtvMediaPlayer.this.vsrver = ImgoVsrApi.imgovsr_get_version();
                                                if (!IntegrityManager.INTEGRITY_TYPE_NONE.equals(MgtvMediaPlayer.this.vsrver)) {
                                                    MgtvMediaPlayer.this.vsrvkver = ImgoVsrApi.imgovsr_get_vulkan_version();
                                                    MgtvMediaPlayer.this.vsrnpuver = ImgoVsrApi.imgovsr_get_npu_version();
                                                    ImgoVsrApi.updateVsrDeviceinfo();
                                                    if (ImgoVsrApi.getVsrDeviceinfo() != null) {
                                                        DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "chodison vsr_fp16_int8_feature:" + vsrDeviceinfo.vsr_fp16_int8_feature + ", vsr_api_version:" + vsrDeviceinfo.vsr_api_version);
                                                    }
                                                }
                                                DebugLog.i(MgtvMediaPlayer.this.getLogTag(), "chodison vsrver:" + MgtvMediaPlayer.this.vsrver + ", vsrvkver:" + MgtvMediaPlayer.this.vsrvkver + ", vsrnpuver:" + MgtvMediaPlayer.this.vsrnpuver);
                                                break;
                                            }
                                            break;
                                    }
                            }
                        } else if (MgtvMediaPlayer.this.onBufferEnd(String.valueOf(i2))) {
                            return false;
                        }
                    } else if (MgtvMediaPlayer.this.onBufferStart(String.valueOf(i2))) {
                        return false;
                    }
                } else if (MgtvMediaPlayer.this.mMediaPlayer.U()) {
                    MgtvMediaPlayer.this.callbackSpatializer();
                    if (MgtvMediaPlayer.this.onRenderStart()) {
                        return false;
                    }
                }
                if (MgtvMediaPlayer.this.mOnInfoListener != null) {
                    return MgtvMediaPlayer.this.mOnInfoListener.onInfo(i, i2);
                }
                return false;
            }
        });
        this.mMediaPlayer.V0(new MgtvPlayerListener.OnInfoStringListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.10
            /* JADX WARN: Removed duplicated region for block: B:100:0x027e  */
            /* JADX WARN: Removed duplicated region for block: B:94:0x024b  */
            /* JADX WARN: Removed duplicated region for block: B:97:0x0267  */
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnInfoStringListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onInfo(int r19, java.lang.String r20) {
                /*
                    Method dump skipped, instructions count: 672
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.player.MgtvMediaPlayer.AnonymousClass10.onInfo(int, java.lang.String):boolean");
            }
        });
        this.mMediaPlayer.S0(this.mErrorListener);
        this.mMediaPlayer.R0(new MgtvPlayerListener.OnCompletionListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.11
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnCompletionListener
            public void onCompletion(int i, int i2) {
                if (MgtvMediaPlayer.this.mGifRecorder != null) {
                    MgtvMediaPlayer.this.mGifRecorder.interrupt(102);
                }
                MgtvMediaPlayer.this.stopTickers();
                if (MgtvMediaPlayer.this.mReporter != null) {
                    MgtvMediaPlayer.this.mReporter.C(i, i2);
                }
                if (i != 0 && MgtvMediaPlayer.this.mReportParams != null && MgtvMediaPlayer.this.mReportParams.getVideoType() == ReportParams.VideoType.VOD && MgtvMediaPlayer.this.mOnWarningListener != null) {
                    MgtvPlayerListener.OnWarningListener onWarningListener = MgtvMediaPlayer.this.mOnWarningListener;
                    onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_ERROR_COMPLETION, i2 + "", "", null);
                }
                MgtvMediaPlayer.this.mPlayStatus = PlayStatus.COMPLETED;
                if (MgtvMediaPlayer.this.mOnCompletionListener != null) {
                    MgtvMediaPlayer.this.mOnCompletionListener.onCompletion(i, i2);
                }
            }
        });
        this.mMediaPlayer.Z0(new MgtvPlayerListener.OnSeekCompleteListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.12
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSeekCompleteListener
            public void onSeekComplete(int i, int i2) {
                if (MgtvMediaPlayer.this.mSeekStartMs > 0) {
                    String logTag = MgtvMediaPlayer.this.getLogTag();
                    DebugLog.i(logTag, "onSeekComplete cost:" + (System.currentTimeMillis() - MgtvMediaPlayer.this.mSeekStartMs) + " ms");
                }
                e eVar = MgtvMediaPlayer.this.mTimeProvider;
                if (eVar != null) {
                    eVar.onSeekComplete(i, i2);
                }
                if (MgtvMediaPlayer.this.mReporter != null) {
                    MgtvMediaPlayer.this.mReporter.K();
                }
                if (MgtvMediaPlayer.this.mOnSeekCompleteListener != null) {
                    MgtvMediaPlayer.this.mOnSeekCompleteListener.onSeekComplete(i, i2);
                }
            }
        });
        this.mMediaPlayer.c1(new MgtvPlayerListener.OnSwitchSourceListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.13
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceComplete(String str, int i, int i2) {
                if (MgtvMediaPlayer.this.mReporterSL != null) {
                    MgtvMediaPlayer.this.mReporterSL.N();
                    MgtvMediaPlayer.this.mSourceSwitchingComplete = true;
                    MgtvMediaPlayer.this.mSourceSwitching = false;
                    if (i == 0) {
                        if (MgtvMediaPlayer.this.mReportParams != null) {
                            MgtvMediaPlayer.this.mReportParams.setP2ps(MgtvMediaPlayer.this.mMediaPlayer.z());
                        }
                        if (MgtvMediaPlayer.this.mReporter != null) {
                            MgtvMediaPlayer.this.mReporter.G(MgtvMediaPlayer.this.mReporterSL.E());
                        }
                    }
                }
                if (MgtvMediaPlayer.this.mOnSwitchSourceListener != null) {
                    MgtvMediaPlayer.this.mOnSwitchSourceListener.onSwitchSourceComplete(str, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceFailed(String str, int i, int i2) {
                MgtvMediaPlayer.this.reportError(i, i2, "");
                if (MgtvMediaPlayer.this.mOnSwitchSourceListener != null) {
                    MgtvMediaPlayer.this.mOnSwitchSourceListener.onSwitchSourceFailed(str, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceInfo(String str, int i, int i2) {
                if (i == 2) {
                    MgtvMediaPlayer.this.mSwitchingPrepared = true;
                }
                if (MgtvMediaPlayer.this.mOnSwitchSourceListener != null) {
                    MgtvMediaPlayer.this.mOnSwitchSourceListener.onSwitchSourceInfo(str, i, i2);
                }
            }
        });
        this.mMediaPlayer.P0(new MgtvPlayerListener.OnBufferingTimeoutListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.14
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingTimeoutListener
            public boolean onBufferingTimeout(int i, int i2) {
                return MgtvMediaPlayer.this.callBufferingTimeout(i, i2, "");
            }
        });
        this.mMediaPlayer.b1(this.mSourceNetListner);
        this.mMediaPlayer.W0(new MgtvPlayerListener.OnPlayerEventListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.15
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPlayerEventListener
            public void onInfo(int i, int i2) {
                String logTag;
                StringBuilder sb;
                String str;
                if (i == 3) {
                    logTag = MgtvMediaPlayer.this.getLogTag();
                    sb = new StringBuilder();
                    str = "chodison player event oninfo MEDIA_INFO_VIDEO_RENDERING_START: t6:";
                } else if (i != 9) {
                    logTag = MgtvMediaPlayer.this.getLogTag();
                    sb = new StringBuilder();
                    sb.append("chodison player event oninfo what: ");
                    sb.append(i);
                    str = ",extra:";
                } else {
                    logTag = MgtvMediaPlayer.this.getLogTag();
                    sb = new StringBuilder();
                    str = "chodison player event oninfo MEDIA_INFO_VV_BUFFER_PREPARED: VVBT:";
                }
                sb.append(str);
                sb.append(i2);
                DebugLog.e(logTag, sb.toString());
                if (MgtvMediaPlayer.this.mOnPlayerEventListener != null) {
                    MgtvMediaPlayer.this.mOnPlayerEventListener.onInfo(i, i2);
                }
            }
        });
        this.mMediaPlayer.Y0(new MgtvPlayerListener.OnRecordVideoListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.16
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoErr(int i, int i2) {
                MgtvMediaPlayer.this.callbackRecordError(i, i2);
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoInfo(int i, int i2) {
                MgtvMediaPlayer.this.callbackRecordInfo(i, i2);
            }
        });
        this.mMediaPlayer.n0(this.mSmoothSourceListener);
        this.mMediaPlayer.T0(new MgtvPlayerListener.OnGetFrameImageListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.17
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnGetFrameImageListener
            public void onGetFrameImageInfo(int i, int i2, String str) {
                if (MgtvMediaPlayer.this.mOnGetFrameImageListener != null) {
                    MgtvMediaPlayer.this.mOnGetFrameImageListener.onGetFrameImageInfo(i, i2, str);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnGetFrameImageListener
            public void onGetFrameImageStatus(int i, int i2) {
                if (MgtvMediaPlayer.this.mOnGetFrameImageListener != null) {
                    MgtvMediaPlayer.this.mOnGetFrameImageListener.onGetFrameImageStatus(i, i2);
                }
            }
        });
        this.mMediaPlayer.a1(new MgtvPlayerListener.OnSourceFlowHandledListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.18
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSourceFlowHandledListener
            public void onSourceFlowInfoEvent(int i, Bundle bundle) {
                if (i != 78593 || bundle == null) {
                    return;
                }
                String string = bundle.getString(MgtvPlayerListener.OnSourceFlowHandledListener.ARG_FLOW_SWITCH_URL_STRING);
                long j = bundle.getLong(MgtvPlayerListener.OnSourceFlowHandledListener.ARG_FLOW_SWITCH_KEY_LONG);
                long j2 = bundle.getLong(MgtvPlayerListener.OnSourceFlowHandledListener.ARG_FLOW_SEG_INDEX_LONG);
                long j3 = bundle.getLong(MgtvPlayerListener.OnSourceFlowHandledListener.ARG_FLOW_SEG_NUMS_LONG);
                long j4 = bundle.getLong(MgtvPlayerListener.OnSourceFlowHandledListener.ARG_FLOW_SEG_STARTTIME_LONG);
                long j5 = bundle.getLong(MgtvPlayerListener.OnSourceFlowHandledListener.ARG_FLOW_SEG_DUR_LONG);
                long j6 = bundle.getLong(MgtvPlayerListener.OnSourceFlowHandledListener.ARG_FLOW_CUR_DL_SIZE_LONG);
                long j7 = bundle.getLong(MgtvPlayerListener.OnSourceFlowHandledListener.ARG_FLOW_FILE_SIZE_LONG);
                int i2 = bundle.getInt(MgtvPlayerListener.OnSourceFlowHandledListener.ARG_FLOW_STREAM_TYPE_INT);
                int i3 = bundle.getInt(MgtvPlayerListener.OnSourceFlowHandledListener.ARG_FLOW_ERROR_TYPE_INT);
                int i4 = bundle.getInt(MgtvPlayerListener.OnSourceFlowHandledListener.ARG_FLOW_ERROR_CODE_INT);
                DebugLog.ifmt(MgtvMediaPlayer.this.getLogTag(), "onSourceFlowInfoEvent: flow_stream_type:%d, flow_error_type:%d, flow_error_code:%d, flow_switch_key:%d, flow_seg_index:%d, flow_seg_nums:%d, flow_seg_starttime:%d, flow_seg_dur:%d, flow_cur_dl_size:%d, flow_file_size:%d, flow_swithc_url:%s ", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), string);
                FlowReportEntity flowReportEntity = new FlowReportEntity();
                flowReportEntity.url = string;
                flowReportEntity.file_size = j7;
                flowReportEntity.down_size = j6;
                flowReportEntity.error_type = i3;
                flowReportEntity.error_code = i4;
                flowReportEntity.file_dur = new DecimalFormat("0.000000").format(((float) j5) / 1000000.0f) + "";
                flowReportEntity.file_seq = j2 + "";
                if (MgtvMediaPlayer.this.isFlowReportEnable) {
                    FlowReportProcessor flowReportProcessor = MgtvMediaPlayer.this.mMainFlowReportProcessor;
                    SmoothMediaSource smoothMediaSource = (SmoothMediaSource) MgtvMediaPlayer.this.mSmoothSourcesRecord.get(Integer.valueOf((int) j));
                    if (smoothMediaSource != null) {
                        flowReportProcessor = smoothMediaSource.getFlowReportProcessor();
                    }
                    if (flowReportProcessor != null) {
                        flowReportProcessor.pushPlayerFlowInfo(flowReportEntity);
                    }
                }
            }
        });
        this.mPlayTicker.setHostLogTag(getLogTag());
        this.mPlayTicker.setCallback(new ExTicker.onTickListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.19
            @Override // com.hunantv.media.player.utils.ExTicker.onTickListener
            public void onTick(int i) {
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.d(logTag, "PlayTicker onTick: " + i + ",fps:" + MgtvMediaPlayer.this.getFpsMsg());
                if (MgtvMediaPlayer.this.mReporter != null) {
                    MgtvMediaPlayer.this.mReporter.k(i);
                }
            }
        });
        this.mPlayTicker.setExCallback(new ExTicker.OnExTickListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.20
            @Override // com.hunantv.media.player.utils.ExTicker.OnExTickListener
            public void onPlayOrPause(boolean z) {
                if (MgtvMediaPlayer.this.mRenderView != null) {
                    if (z) {
                        MgtvMediaPlayer.this.mRenderView.startFps();
                    } else {
                        MgtvMediaPlayer.this.mRenderView.stopFps();
                    }
                }
            }

            @Override // com.hunantv.media.player.utils.ExTicker.OnExTickListener
            public void onTick(int i, int i2) {
                if (i2 > 2) {
                    MgtvMediaPlayer.this.updateFpsInfo();
                    if (MgtvMediaPlayer.this.isRfpsLow()) {
                        MgtvMediaPlayer.access$13308(MgtvMediaPlayer.this);
                    } else {
                        MgtvMediaPlayer.this.rfpsLowCounter = 0;
                    }
                    if (MgtvMediaPlayer.this.rfpsLowCounter <= 5 || MgtvMediaPlayer.this.mRenderView == null || MgtvMediaPlayer.this.rfpsLowFilterChanged) {
                        return;
                    }
                    DebugLog.e(MgtvMediaPlayer.this.getLogTag(), "rfps too low change to normal filter");
                    MgtvMediaPlayer.this.rfpsLowFilterChanged = true;
                    MgtvMediaPlayer.this.mRenderView.setRenderFilter(0);
                }
            }
        });
        this.mBufferTick.setHostLogTag(getLogTag());
        this.mBufferTick.setCallback(new ExTicker.onTickListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.21
            @Override // com.hunantv.media.player.utils.ExTicker.onTickListener
            public void onTick(int i) {
                String logTag = MgtvMediaPlayer.this.getLogTag();
                DebugLog.i(logTag, "BufferTick onTick: " + i + ",getDLSpeed:" + MgtvMediaPlayer.this.getNetSpeedStr());
                MgtvMediaPlayer.this.doBufferTick(i);
            }
        });
    }

    private void initReporter(Context context) {
        if (this.mEnableReport) {
            this.mReporter = new a.a.a.b.a(context, this);
            this.mReporterSL = new a.a.a.b.a(context, this, true);
            f fVar = this.mMediaPlayer;
            if (fVar != null) {
                fVar.o0(this.mReporter);
            }
            f fVar2 = this.mMediaPlayer;
            if (fVar2 != null) {
                fVar2.C1(this.mReporterSL);
            }
        }
    }

    private void initSpaceAudio() {
        String str = TAG;
        DebugLog.i(str, "[Spatializer] this.hashCode() = " + hashCode());
        Context context = this.mContext;
        this.mgtvPlayerSpatializer = MgtvPlayerSpatializer.tryCreateInstance(context, hashCode() + "");
        if (Build.VERSION.SDK_INT < 33) {
            DebugLog.e(str, "[Spatializer] current api no support Spatializer!");
        }
        this.mgtvPlayerSpatializer.ensureInitialized(new MgtvPlayerListener.OnSpatializerInfoListener() { // from class: com.hunantv.media.player.MgtvMediaPlayer.27
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSpatializerInfoListener
            public void onSpatializerEnabledChanged(boolean z) {
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSpatializerInfoListener
            public void onSpatializerStateChanged(boolean z) {
                String str2 = MgtvMediaPlayer.TAG;
                DebugLog.i(str2, "[Spatializer] onSpatializerAvailableChanged :" + z);
                MgtvMediaPlayer.this.callbackSpatializer();
            }
        }, this.mNotifyHandler.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDnsCacheEnable() {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            return fVar.a0();
        }
        return false;
    }

    private boolean isInPlaybackState() {
        PlayStatus playStatus;
        return (this.mMediaPlayer == null || (playStatus = this.mPlayStatus) == PlayStatus.ERROR || playStatus == PlayStatus.IDLE || playStatus == PlayStatus.PREPARING) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSkipRetryCode(int i, int i2) {
        return CodeUtil.isHttp4XX(i, i2) || CodeUtil.isHttp5XX(i, i2) || !(isDnsCacheEnable() || this.mBackJavaDns || i2 != 100701);
    }

    public static boolean isTimeoutError(int i, int i2) {
        return a.a.a.b.a.A(i, i2);
    }

    private int legalPosition(int i) {
        if (i < 0) {
            return 0;
        }
        return (getDuration() <= 0 || i <= getDuration()) ? i : getDuration();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SmoothMediaSource matchLastKeySource(int i) {
        if (this.mSwitchingSmoothSource == null || this.mSwitchingSmoothSource.getKey() != i) {
            return null;
        }
        return this.mSwitchingSmoothSource;
    }

    private boolean matchSwitchedSmoothSource(String str) {
        return (this.mSwitchedSmoothSource == null || StringUtil.isEmpty(this.mSwitchedSmoothSource.getVid()) || StringUtil.isEmpty(this.mSwitchedSmoothSource.getDef()) || !str.equalsIgnoreCase(getKeyFrameMapKey(this.mSwitchedSmoothSource.getVid(), this.mSwitchedSmoothSource.getDef()))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySwitchSmoothSourceFail(SmoothMediaSource smoothMediaSource, int i, int i2) {
        String logTag = getLogTag();
        DebugLog.e(logTag, "notifySwitchSmoothSourceFail " + i + "-" + i2);
        MgtvPlayerListener.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = this.mOnSwitchSmoothSourceListener;
        if (onSwitchSmoothSourceListener != null) {
            onSwitchSmoothSourceListener.onSwitchSmoothSourceFail(smoothMediaSource, WHAT_SMOOTHSOURCE_FAIL, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onBufferEnd(String str) {
        DebugLog.i(getLogTag(), "onBufferEnd");
        e eVar = this.mTimeProvider;
        if (eVar != null) {
            eVar.q(false);
        }
        GifRecorder gifRecorder = this.mGifRecorder;
        if (gifRecorder != null) {
            gifRecorder.resume();
        }
        this.mWeakTimer = 0;
        this.mIsBuffering = false;
        this.mBufferTick.stop();
        if (isPlaying()) {
            this.mPlayTicker.resume();
        }
        a.a.a.b.a aVar = this.mReporter;
        if (aVar != null) {
            aVar.w(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onBufferStart(String str) {
        DebugLog.i(getLogTag(), "onBufferStart");
        e eVar = this.mTimeProvider;
        if (eVar != null) {
            eVar.q(true);
        }
        GifRecorder gifRecorder = this.mGifRecorder;
        if (gifRecorder != null) {
            gifRecorder.pause();
        }
        this.mIsBuffering = true;
        this.mPlayTicker.pause();
        if (!isLoadDataPaused() && !UrlUtil.isLocal(getPlayingUrl()) && !StringUtil.isEmpty(str) && !str.equals(String.valueOf(8))) {
            this.mBufferTick.start();
        }
        a.a.a.b.a aVar = this.mReporter;
        if (aVar != null) {
            aVar.z(str);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onRenderStart() {
        MgtvPlayerListener.OnWarningListener onWarningListener;
        if (isRendered()) {
            if (this.mIsInnerRetrying && (onWarningListener = this.mOnWarningListener) != null) {
                onWarningListener.onWarning(MGTVMEDIA_WARNING_INNER_RETRY_RENDER_START, getRetryLastErrorCode() + "", "", null);
            }
            return true;
        }
        this.mIsVideoRendered = true;
        this.mPlayTicker.start();
        a.a.a.b.a aVar = this.mReporter;
        if (aVar != null) {
            aVar.N();
            return false;
        }
        return false;
    }

    private void preLoopSeek(boolean z) {
        float playbackSpeed;
        if (this.mMediaPlayer.v() == 1 || this.mMediaPlayer.v() == 2) {
            if (z) {
                playbackSpeed = 30.0f;
            } else {
                playbackSpeed = getPlaybackSpeed();
                if (playbackSpeed <= 0.0f) {
                    playbackSpeed = 1.0f;
                }
            }
            P2pMgr.setPlaySpeed(playbackSpeed);
        }
    }

    private void preSeekTo(int i, boolean z) {
        this.mSeekStartMs = System.currentTimeMillis();
        if (this.mMediaPlayer.v() == 1 || this.mMediaPlayer.v() == 2) {
            P2pMgr.setPlayingTimepoint(this.mMediaPlayer.o4(), i, true);
        }
        if (this.mMediaPlayer.C3()) {
            return;
        }
        this.mpx = z ? 10 : 9;
    }

    private void printErrorMd5() {
        ReportParams reportParams = this.mReportParams;
        if (reportParams == null || !ReportParams.VideoType.LOCAL.equals(reportParams.getVideoType())) {
            return;
        }
        String logTag = getLogTag();
        DebugLog.e(logTag, "离线播放URL:" + getPlayingUrl());
        String logTag2 = getLogTag();
        DebugLog.e(logTag2, "离线播放md5:[status-remote][" + this.mReportParams.getLocalMd5() + "-" + this.mReportParams.getRemoteMd5() + "]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportError(int i, int i2, String str) {
        if (this.mSourceSwitching) {
            a.a.a.b.a aVar = this.mReporterSL;
            if (aVar != null) {
                aVar.l(i, i2, str);
            }
            this.mSourceSwitching = false;
            return;
        }
        printErrorMd5();
        a.a.a.b.a aVar2 = this.mReporter;
        if (aVar2 != null) {
            aVar2.l(i, i2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportErrorWarning(int i, int i2) {
        String[] split;
        String str;
        String str2;
        String str3;
        ReportParams reportParams;
        MgtvPlayerListener.OnWarningListener onWarningListener;
        String str4;
        String str5;
        int i3;
        if (this.mOnWarningListener == null) {
            return;
        }
        if (!isRendered() && (reportParams = this.mReportParams) != null) {
            long routerTimeStamp = reportParams.getRouterTimeStamp();
            if (routerTimeStamp > 0) {
                long j = this.mPrepareAsyncTimeStampMs;
                if (j > 0) {
                    int i4 = (int) ((j - routerTimeStamp) / 1000);
                    String E = this.mReporter.E();
                    int i5 = i4 / 1800;
                    if (CodeUtil.isHttp410(i, i2)) {
                        onWarningListener = this.mOnWarningListener;
                        str4 = E + Consts.DOT + i5;
                        str5 = "_prepareasync_" + this.mPrepareAsyncTimeStampMs + "_routerTimeMs_" + routerTimeStamp + "_duration_" + i4;
                        i3 = MGTVMEDIA_WARNING_410_PRE_PLAY;
                    } else if (CodeUtil.isHttp403(i, i2)) {
                        onWarningListener = this.mOnWarningListener;
                        str4 = E + Consts.DOT + i5;
                        str5 = "_prepareasync_" + this.mPrepareAsyncTimeStampMs + "_routerTimeMs_" + routerTimeStamp + "_duration_" + i4;
                        i3 = MGTVMEDIA_WARNING_403_PRE_PLAY;
                    }
                    onWarningListener.onWarning(i3, str4, str5, null);
                }
            }
        }
        if (i2 == 300301) {
            this.mOnWarningListener.onWarning(MGTVMEDIA_WARNING_EXTRA_300301, this.mReporter.E(), "", null);
        }
        if (i2 == 101905 || i2 == 100400 || i2 == 100401) {
            f fVar = this.mMediaPlayer;
            String H3 = fVar != null ? fVar.H3() : "";
            String str6 = (H3 == null || (split = H3.split("/")) == null || split.length <= 0) ? "" : split[0];
            this.mOnWarningListener.onWarning(MGTVMEDIA_WARNING_TS_ERROR, i2 + Consts.DOT + str6, H3, null);
        }
        ReportParams reportParams2 = this.mReportParams;
        if (reportParams2 != null && reportParams2.getVideoType() == ReportParams.VideoType.LOCAL && i2 == 100201) {
            this.mOnWarningListener.onWarning(MGTVMEDIA_WARNING_LOCAL_100201, "0", "url:" + getPlayingUrl(), null);
        }
        String hostName = UrlUtil.getHostName(getPlayingOriginUrl());
        ReportParams reportParams3 = this.mReportParams;
        Object obj = MLog.a.b;
        if (reportParams3 != null) {
            str = this.mReportParams.getP2ps() + "";
            str3 = this.mReportParams.getRetryIndex() + "";
            str2 = this.mReportParams.getProxyType().ordinal() + "";
        } else {
            str = MLog.a.b;
            str2 = str;
            str3 = str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("psuuid_");
        sb.append(this.mReporter.E());
        sb.append("_playsta_");
        sb.append(this.mPlayStatus);
        sb.append("_p2ps_");
        sb.append(str);
        sb.append("_rdst_");
        sb.append(getReadDataSourceType());
        sb.append("_p2psta_");
        if (this.mMediaPlayer.o4() != null) {
            obj = Integer.valueOf(this.mMediaPlayer.o4().getStatus());
        }
        sb.append(obj);
        sb.append("_pdsn_");
        sb.append(this.mIsNativePausedLoadData);
        sb.append("_pdsj_");
        sb.append(isLoadDataPaused());
        sb.append("_live_");
        sb.append(this.mIsLive);
        sb.append("_dsty_");
        sb.append(this.mDataSourceType);
        sb.append("_retry_");
        sb.append(str3);
        sb.append("_sr_");
        sb.append(this.mSourceRetryCount);
        sb.append("_err_");
        sb.append(UrlUtil.getFileName(this.mErrorUrl));
        sb.append("_last_");
        sb.append(UrlUtil.getFileName(this.mLastRequestUrl));
        sb.append("_cip_");
        sb.append(getLastIP());
        sb.append("_pcip_");
        sb.append(this.mLastP2pCdnIP);
        sb.append("_proxy_");
        sb.append(str2);
        sb.append("_v_");
        sb.append(PlayerConfig.getLibFullVersion());
        sb.append("_herr_");
        sb.append(this.mLastHostErr);
        sb.append("_terr_");
        sb.append(this.mLastTcpErr);
        sb.append("_hip_");
        sb.append(this.mLastHostIP);
        sb.append("_tip_");
        sb.append(this.mLastTcpIP);
        sb.append("_lhost_");
        sb.append(hostName);
        sb.append("_ipn_");
        sb.append(getLastIPCount());
        sb.append("_");
        sb.append(getLastIpArrayStr());
        sb.append("_ipt_");
        sb.append(getLastDnsType());
        String sb2 = sb.toString();
        this.mOnWarningListener.onWarning(MGTVMEDIA_WARNING_TARGET_ERROR, i + "_" + i2, sb2, null);
    }

    private void resetData() {
        this.spaceAudioAttr = null;
        this.isExAudioEnable = NetPlayConfig.isWanosAudioEnable();
        this.waev = null;
        this.mSeekStartMs = -1L;
        this.imp4dh = 0;
        this.mpx = 0;
        this.fstime = "n";
        this.mcColorFormat = "n_n";
        this.mLastTsSkipErrExtra = 0;
        this.mLastTsSkipErrFileName = null;
        this.mLastIsNetworkAvailableNNS = true;
        if (isRfpsLow() && this.rfpsLowFilterChanged) {
            DebugLog.e(getLogTag(), "resetData rfps too low, close opengl next time");
            h.h = true;
        }
        GifRecorder gifRecorder = this.mGifRecorder;
        if (gifRecorder != null) {
            gifRecorder.reset();
        }
        removeSubtitleSources();
        this.mIsGetPositionCallback = false;
        this.mSourceSwitching = false;
        this.mSourceSwitchingComplete = false;
        this.mPrepared = false;
        this.mErrorUrl = "";
        this.mLastRequestUrl = "";
        this.mIsBuffering = false;
        this.mIsLive = false;
        this.mWeakTimer = 0;
        this.mCacheM3u8Path = null;
        this.mCacheTsPaths = null;
        this.mCacheReplaceMap.clear();
        this.mTsCacheSkipNum = 0;
        this.mIsInnerRetrying = false;
        this.mRetryLastErrorCode = 0;
        this.mRenderDisableWarnSended = false;
        this.mRealEncodeType = -1;
        setPlayerReset(true);
        synchronized (this.mDnsLock) {
            this.mDnsLock.notifyAll();
        }
        this.mHttpDnsEnable = false;
        this.mLastUri = null;
        this.mCurrentDnsDsc = "native";
        this.mLastIP = null;
        this.mLastP2pCdnIP = null;
        this.mLastHostIP = null;
        this.mLastTcpIP = null;
        this.mLastHostErr = MLog.a.b;
        this.mLastTcpErr = MLog.a.b;
        this.mLastIpCount = 0;
        this.mLastIpIndex = -1;
        this.mLastDnsType = -1;
        this.mSourceRetryCount = 0;
        this.mSourceRetryCode = 0;
        this.mAVSyncErrReported = false;
        this.mAVSyncErrSumReported = false;
        this.mAVSyncErrSum = 0;
        this.mPrepareAsyncTimeStampMs = 0L;
        this.mReportedTSLAN = false;
        this.mIsAudioExist = -1;
        this.mIsP2pTSSkipReport = false;
        this.mIsInitMp4Error = false;
        this.mSmt = 0L;
        this.mDlt = 0L;
        this.mPlaybackSpeed = 1.0f;
        clearIPCache();
        this.mCodecName = "n";
        this.hdrInfo = "n";
        this.mVideoFrameClockNotifyMs = -1;
        MgtvPlayerBroadcastObserver mgtvPlayerBroadcastObserver = this.mObserver;
        if (mgtvPlayerBroadcastObserver != null) {
            mgtvPlayerBroadcastObserver.unregister();
        }
        this.mNetworkChangeWhilePlaying = false;
        this.mCacheReportTag = DEFAULT_CACHE_REPORT_TAG;
        this.mInnerFlowDataStatistic.reset();
        this.mPreBufferState.reset();
        this.avdiffS = 0;
        this.sfps = 0;
        this.vfps = 0;
        this.rfps = 0;
        this.rfpsLowCounter = 0;
        this.rfpsLowFilterChanged = false;
        this.mLastPosition = 0;
        this.mPositionLoged = false;
        this.mVVbuft = -1;
        this.mDnsThreadManager.f();
        synchronized (this.mDnsNoNetWaiter) {
            DebugLog.i(getLogTag(), "resetData DnsNetStrategy mDnsNoNetWaiter notifyAll");
            this.mDnsNoNetWaiter.notifyAll();
        }
        for (Map.Entry<Integer, SmoothMediaSource> entry : this.mSmoothSourcesRecord.entrySet()) {
            SmoothMediaSource value = entry.getValue();
            if (value != null && !value.isReleased()) {
                value.release();
            }
        }
    }

    private void resetDataAfter() {
        FlowReportProcessor flowReportProcessor;
        if (this.isFlowReportEnable && (flowReportProcessor = this.mMainFlowReportProcessor) != null) {
            flowReportProcessor.stop();
        }
        for (Map.Entry<Integer, SmoothMediaSource> entry : this.mSmoothSourcesRecord.entrySet()) {
            SmoothMediaSource value = entry.getValue();
            if (this.isFlowReportEnable && value != null && value.getFlowReportProcessor() != null) {
                value.getFlowReportProcessor().stop();
            }
        }
        synchronized (this.mSwitchSmoothSourceLocker) {
            this.mSwitchingSmoothSource = null;
            this.mSwitchedSmoothSource = null;
            this.mSmoothSourcesRecord.clear();
            this.mSmoothKeyFrameMap.clear();
            a.a.a.b.a aVar = new a.a.a.b.a(this.mContext, this);
            this.mReporter = aVar;
            f fVar = this.mMediaPlayer;
            if (fVar != null) {
                fVar.o0(aVar);
                this.mMediaPlayer.k2(false);
            }
            this.mSmoothUseP2pFailed = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendContent2Track(c.a.a.a.p.d dVar, SubtitleSource subtitleSource) {
        e eVar;
        Handler handler;
        if (subtitleSource == null || (eVar = this.mTimeProvider) == null || (handler = eVar.k) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(4, Pair.create(dVar, subtitleSource)));
    }

    private void setAsyncDns(boolean z, a.d dVar) {
        this.mJavaDnsEnable = z;
        this.mJavaDnsType = dVar;
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.o1(z, dVar);
        }
    }

    private void setAudioAttributes() {
        AudioAttributes audioAttributes;
        f fVar = this.mMediaPlayer;
        if (fVar == null || (audioAttributes = this.spaceAudioAttr) == null) {
            return;
        }
        fVar.E0(audioAttributes);
    }

    public static void setPlayerDebug(boolean z) {
        PlayerConfig.setPlayerDebug(z);
    }

    public static void setPlayerDebugLog(int i, int i2) {
        PlayerConfig.setPlayerDebugInfo(i);
        PlayerConfig.setPlayerDebugLogLevel(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayerReset(boolean z) {
        this.mPlayerReset = z;
        this.mLoopPlayerReset = z;
    }

    private synchronized void setSubtitleAnchor() {
        if (this.mSubtitleController == null) {
            b bVar = new b(this.mContext, this.mTimeProvider, new b.d() { // from class: com.hunantv.media.player.MgtvMediaPlayer.24
                public void onSubtitleTrackSelected(c.a.a.a.p.d dVar) {
                }
            });
            this.mSubtitleController = bVar;
            bVar.c(new b.c() { // from class: com.hunantv.media.player.MgtvMediaPlayer.25
                public Looper getSubtitleLooper() {
                    return Looper.getMainLooper();
                }

                public void setSubtitleWidget(d.d dVar) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopTickers() {
        this.mPlayTicker.stop();
        this.mBufferTick.stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFpsInfo() {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            this.avdiffS = (int) fVar.q2();
            this.sfps = this.mMediaPlayer.H();
            this.dfps = (int) this.mMediaPlayer.D();
            this.vfps = (int) this.mMediaPlayer.N();
            IMgtvRenderView iMgtvRenderView = this.mRenderView;
            if (iMgtvRenderView != null) {
                this.rfps = iMgtvRenderView.getFps();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
        if (r5 > r0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int validSeekPosition(int r5) {
        /*
            r4 = this;
            int r0 = r4.getDuration()
            com.hunantv.media.player.MgtvMediaPlayer$PlayStatus r1 = r4.mPlayStatus
            com.hunantv.media.player.MgtvMediaPlayer$PlayStatus r2 = com.hunantv.media.player.MgtvMediaPlayer.PlayStatus.PREPARED
            if (r1 != r2) goto L1e
            int r1 = r0 + (-1000)
            if (r5 < r1) goto L19
            java.lang.String r5 = r4.getLogTag()
            java.lang.String r0 = "validSeekPos seekTo failed, pos >=  duration - 1 * 1000, return -1"
            com.hunantv.media.player.pragma.DebugLog.i(r5, r0)
            r5 = -1
            return r5
        L19:
            int r0 = r0 + (-5000)
            if (r5 <= r0) goto L1e
            goto L1f
        L1e:
            r0 = r5
        L1f:
            java.lang.String r1 = r4.getLogTag()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "validSeekPos seekTo newMs:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = ",origMs:"
            r2.append(r3)
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            com.hunantv.media.player.pragma.DebugLog.i(r1, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.player.MgtvMediaPlayer.validSeekPosition(int):int");
    }

    public void addSubtitleSource(d.d dVar, final SubtitleSource subtitleSource) throws IllegalStateException {
        if (subtitleSource == null || !subtitleSource.isValid()) {
            DebugLog.e(TAG, "addSubtitleSource called with invalid source");
            ISubtitle.SubtitleCallback subtitleCallback = this.mSubtitleCallback;
            if (subtitleCallback != null) {
                subtitleCallback.onError(subtitleSource);
            }
        } else if (subtitleSource.isBinded()) {
        } else {
            subtitleSource.bindHolder(this);
            this.mSubtitleSources.add(subtitleSource);
            c.a.a.a.p.c.c(MessengerShareContentUtility.SUBTITLE, "addSubtitleSource in");
            getMediaTimeProvider();
            if (this.mSubtitleController == null) {
                setSubtitleAnchor();
            }
            c.a.a.a.p.d a = this.mSubtitleController.a(dVar, subtitleSource.getFormat());
            subtitleSource.setCallback(new SubtitleSource.SubtitleSourceCallback() { // from class: com.hunantv.media.player.MgtvMediaPlayer.23
                @Override // com.hunantv.media.player.subtitle.SubtitleSource.SubtitleSourceCallback
                public void onFailed(int i) {
                    if (MgtvMediaPlayer.this.mSubtitleCallback != null) {
                        MgtvMediaPlayer.this.mSubtitleCallback.onError(subtitleSource);
                    }
                }

                @Override // com.hunantv.media.player.subtitle.SubtitleSource.SubtitleSourceCallback
                public void onSuccess(c.a.a.a.p.d dVar2, SubtitleSource subtitleSource2) {
                    try {
                        MgtvMediaPlayer.this.sendContent2Track(dVar2, subtitleSource2);
                        if (MgtvMediaPlayer.this.mSubtitleController != null) {
                            MgtvMediaPlayer.this.mSubtitleController.r();
                        }
                        if (MgtvMediaPlayer.this.mSubtitleCallback != null) {
                            MgtvMediaPlayer.this.mSubtitleCallback.onSuccess(subtitleSource2);
                        }
                    } catch (Exception unused) {
                        if (MgtvMediaPlayer.this.mSubtitleCallback != null) {
                            MgtvMediaPlayer.this.mSubtitleCallback.onError(subtitleSource2);
                        }
                    }
                }
            });
            subtitleSource.readSource(a, subtitleSource);
        }
    }

    public void addVideoPTSListener(MgtvPlayerListener.OnVideoPTSListener onVideoPTSListener) {
        synchronized (this.ptsLocker) {
            if (onVideoPTSListener == null) {
                return;
            }
            if (this.ptsHandlerThread == null) {
                HandlerThread handlerThread = new HandlerThread("mgtvmp_jPts");
                this.ptsHandlerThread = handlerThread;
                handlerThread.start();
                if (this.ptsWeakHandler == null) {
                    this.ptsWeakHandler = new WeakHandler(this.ptsHandlerThread.getLooper(), this);
                }
            }
            this.ptsListeners.add(onVideoPTSListener);
        }
    }

    public void autoWanosAudioEffectChoice() {
        if (this.isExAudioEnable || this.isUserAudioEnable) {
            DebugLog.i(getLogTag(), "autoWanosAudioEffectChoice in");
            setWanosAudioEffectChoice(AudioUtil.isWired(getContext()) ? 4 : 1);
            DebugLog.i(getLogTag(), "autoWanosAudioEffectChoice out");
        }
    }

    public void bindDrmSession(IDrmSession iDrmSession) {
        this.mMediaPlayer.K0(iDrmSession);
    }

    public synchronized GifRecorder bindGifRecorder(GifRecorder gifRecorder) {
        GifRecorder gifRecorder2 = this.mGifRecorder;
        if (gifRecorder2 != null) {
            gifRecorder2.reset();
        }
        this.mGifRecorder = gifRecorder;
        gifRecorder.bindMediaPlayer(this);
        return this.mGifRecorder;
    }

    public void bindRenderView(IMgtvRenderView iMgtvRenderView) {
        this.mRenderView = iMgtvRenderView;
    }

    public boolean clearSurface(Surface surface) {
        return true;
    }

    public void clearVideoPTSListener() {
        synchronized (this.ptsLocker) {
            this.ptsListeners.clear();
        }
    }

    public void configDSMemoryKeepSize(int i, int i2) {
        String logTag = getLogTag();
        DebugLog.d(logTag, "configDSMemoryKeepSize, BW_SIZE_KB:" + i + ",FW_SIZE_KB:" + i2);
        if (i > 0) {
            this.mMediaPlayer.j2(2017122201, i);
        }
        if (i2 > 0) {
            this.mMediaPlayer.j2(2017122202, i2);
        }
    }

    public void configForceHW(boolean z) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.j2(2018051001, z ? 1 : 0);
        }
    }

    public void configLoadMaxRetryTime(int i) {
        String logTag = getLogTag();
        DebugLog.d(logTag, "configLoadMaxRetryTime " + i);
        if (i > 0) {
            this.mLoadMaxRetryTime = i;
        }
    }

    public void configTsNotSkip(boolean z) {
        String logTag = getLogTag();
        DebugLog.d(logTag, "configTsNotSkip " + z);
        this.mTsNotSkip = z;
    }

    public void configWeakBufferSpeed(int i) {
        String logTag = getLogTag();
        DebugLog.d(logTag, "configWeakBufferSpeed " + i);
        if (i > 0) {
            this.mWeakBufferSpeedKB = i;
        }
    }

    public void configWeakBufferTimeout(int i) {
        String logTag = getLogTag();
        DebugLog.d(logTag, "configWeakBufferTimeout " + i);
        if (i > 0) {
            this.mWeakBufferTimeoutMs = i;
        }
    }

    public void enableFramePTSNotify(boolean z) {
        this.mMediaPlayer.l1(z);
    }

    public void enableImgoAIQE(boolean z) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.Z1(z);
        }
    }

    public void enableImgoVSR(boolean z) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.Z1(z);
        }
    }

    public void enableJAVAIPCacheMap(boolean z) {
        this.mEnableJAVAIPCacheMap = z;
    }

    public void enableLiveLowLatency(boolean z) {
        setConfig(2021030401, z ? 1 : 0);
    }

    public void enableM3u8Cache(boolean z) {
        this.mCacheEable = z;
    }

    public void enableMgtvMediaCodec(boolean z) {
        f fVar;
        int i;
        if (z) {
            ReportParams reportParams = this.mReportParams;
            if (reportParams == null || reportParams.getVideoType() != ReportParams.VideoType.VOD || (fVar = this.mMediaPlayer) == null) {
                return;
            }
            i = 1;
        } else {
            fVar = this.mMediaPlayer;
            if (fVar == null) {
                return;
            }
            i = 0;
        }
        fVar.j2(2019053101, i);
    }

    public void enableOppoFunc(int i, boolean z) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.B0(i, z);
        }
    }

    public void enableP2PSmoothFailMode(boolean z) {
        this.mMediaPlayer.k2(z);
    }

    public void enableSpatializer(boolean z) {
        String str = TAG;
        DebugLog.i(str, "[Spatializer] enableSpatializer : " + z);
        MgtvPlayerSpatializer mgtvPlayerSpatializer = this.mgtvPlayerSpatializer;
        if (mgtvPlayerSpatializer == null) {
            return;
        }
        if (!mgtvPlayerSpatializer.isInnerSpatializationSupported()) {
            MgtvPlayerListener.OnSpatializerInfoListener onSpatializerInfoListener = this.onSpatializerInfoListener;
            if (onSpatializerInfoListener != null) {
                onSpatializerInfoListener.onSpatializerStateChanged(false);
                return;
            }
            return;
        }
        this.isSpaceAudioSwitchOn = z;
        DebugLog.i(str, "[Spatializer] isSpaceAudioSwitchOn : " + this.isSpaceAudioSwitchOn);
        this.spaceAudioAttr = (this.isSpaceAudioSwitchOn ? new AudioAttributes.Builder().setContentType(2).setUsage(1).setSpatializationBehavior(0) : new AudioAttributes.Builder().setContentType(2).setUsage(1).setSpatializationBehavior(1)).setIsContentSpatialized(false).build();
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.I2(this.isSpaceAudioSwitchOn);
        }
    }

    public void enableTsSkipError(boolean z) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.j2(2019050601, z ? 1 : 0);
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        PlayerReferenceObserver.remove(hashCode() + "");
        MgtvPlayerBroadcastObserver mgtvPlayerBroadcastObserver = this.mObserver;
        if (mgtvPlayerBroadcastObserver != null) {
            mgtvPlayerBroadcastObserver.unregister();
        }
    }

    public AddrinfoType getAddrinfoType() {
        return this.mAddrinfoType;
    }

    public String getAudioFormat() {
        DataSourceInfo dataSourceInfo = this.mDataSourceInfo;
        if (dataSourceInfo != null) {
            return dataSourceInfo.audioFormat;
        }
        return null;
    }

    public int getAvdiffS() {
        return this.avdiffS;
    }

    public int getBufferedPercentage() {
        return this.mMediaPlayer.M2();
    }

    public long getBufferedPositionMs() {
        return this.mMediaPlayer.X2();
    }

    public int getBufferingPercent() {
        return this.mMediaPlayer.g3();
    }

    public Map<String, String> getCacheReplaceMap() {
        return this.mCacheReplaceMap;
    }

    public String[] getCacheTsPaths() {
        return this.mCacheTsPaths;
    }

    public String getCodecName() {
        return this.mCodecName;
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getCurDLSpeed() {
        return this.mMediaPlayer.p3();
    }

    public String getCurrentAudioDecoderName() {
        return this.mMediaPlayer.B3();
    }

    public String getCurrentDnsDsc() {
        return this.mCurrentDnsDsc;
    }

    public String getCurrentDrmMetodName() {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            return fVar.E3();
        }
        return null;
    }

    public int getCurrentPosition() {
        try {
            if (checkInvalidThread(0, "getCurrentPosition")) {
                return 0;
            }
            return getCurrentPositionUnSafe();
        } catch (Exception e) {
            e.printStackTrace();
            DebugLog.e(getLogTag(), "getCurrentPosition Exception return 0");
            return 0;
        }
    }

    public int getCurrentPositionUnSafe() {
        int i;
        try {
            int J3 = this.mMediaPlayer.J3();
            if (this.mLastPosition > 0 && J3 == 0 && !this.mPositionLoged) {
                this.mPositionLoged = true;
                DebugLog.e(getLogTag(), "getCurrentPosition warning position mLastPosition:" + this.mLastPosition + ",position:" + J3 + " check it");
            }
            if (this.mPlayStatus == PlayStatus.ERROR && ((i = this.mErrorExtraCodeStore) == 100607 || i == 100606)) {
                J3 -= 5000;
            }
            int legalPosition = legalPosition(J3);
            this.mLastPosition = legalPosition;
            return legalPosition;
        } catch (Exception e) {
            e.printStackTrace();
            DebugLog.e(getLogTag(), "getCurrentPositionUnSafe Exception return 0");
            return 0;
        }
    }

    public String getCurrentVideoDecoderName() {
        return this.mMediaPlayer.N3();
    }

    public DataSourceInfo getDataSourceInfo() {
        return this.mDataSourceInfo;
    }

    public DataSourceType getDataSourceType() {
        return this.mDataSourceType;
    }

    public int getDataSourceTypeOrdinal() {
        return this.mDataSourceType.ordinal();
    }

    public int getDfps() {
        return this.dfps;
    }

    public IDrmSession getDrmSession() {
        return this.mMediaPlayer.T3();
    }

    public int getDuration() {
        if (this.mPlayerType != 0 || isInPlaybackState()) {
            return this.mMediaPlayer.V3();
        }
        return -1;
    }

    public String getErrorUrl() {
        return this.mErrorUrl;
    }

    public String getFileFormat() {
        DataSourceInfo dataSourceInfo = this.mDataSourceInfo;
        if (dataSourceInfo != null) {
            return dataSourceInfo.fileFormat;
        }
        return null;
    }

    public float getFileStartTimeFloatS() {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            return fVar.Y3();
        }
        return -1.0f;
    }

    public String getFpsMsg() {
        int i = (isVfpsLow() || isRfpsLow()) ? 1 : 0;
        return (getAvdiffS() + "_" + getSfps() + "_" + getDfps() + "_" + getVfps() + "_" + getRfps() + "_" + getPlaybackSpeed() + "_" + (isRfpsLowFilterChanged() ? 1 : 0) + "_" + i).replace("-", "_");
    }

    public String getFstime() {
        return this.fstime;
    }

    public String getHdrInfo() {
        return this.hdrInfo;
    }

    public Hw2SwType getHw2SwType() {
        return this.mHw2SwType;
    }

    public f getImgoMediaPlayer() {
        return this.mMediaPlayer;
    }

    public int getImp4dh() {
        return this.imp4dh;
    }

    public FlowDataStatistic getInnerFlowDataStatistic() {
        return this.mInnerFlowDataStatistic;
    }

    public MgtvPlayerListener.OnFrameListener getInnerFrameListener() {
        return this.mFrameListener;
    }

    public int getIsAudioExist() {
        return this.mIsAudioExist;
    }

    public int getLastDlSize() {
        return this.mLastDlSize;
    }

    public int getLastDnsType() {
        return this.mLastDnsType;
    }

    public String getLastErrorTypeCode() {
        return this.mLastErrorTypeCode;
    }

    public String getLastIP() {
        f fVar = this.mMediaPlayer;
        if (fVar != null && ((fVar.v() == 2 || this.mMediaPlayer.v() == 1) && this.mMediaPlayer.o4() != null)) {
            this.mLastIP = P2pMgr.getCdnIpFromP2PTask(this.mMediaPlayer.o4());
            String logTag = getLogTag();
            DebugLog.d(logTag, "getLastIP update cdnIp:" + this.mLastIP);
        }
        return this.mLastIP;
    }

    public int getLastIPCount() {
        return this.mLastIpCount;
    }

    public String getLastIpArrayStr() {
        String[] strArr = this.mLastIps;
        String str = "";
        if (strArr != null) {
            for (String str2 : strArr) {
                str = str + str2 + "_";
            }
        }
        return str;
    }

    public int getLastIpIndex() {
        return this.mLastIpIndex;
    }

    public String getLastRequestUrl() {
        return this.mLastRequestUrl;
    }

    public int getLastTsSkipErrExtra() {
        return this.mLastTsSkipErrExtra;
    }

    public String getLastTsSkipErrFileName() {
        return this.mLastTsSkipErrFileName;
    }

    public long getMaxDnsMs() {
        return this.mMediaPlayer.q4();
    }

    public long getMaxDnsType() {
        return this.mMediaPlayer.a();
    }

    public String getMediaCodecColorFormat() {
        return this.mcColorFormat;
    }

    public c.a.a.a.d getMediaInfo() {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            return fVar.d();
        }
        return null;
    }

    public c.a.a.a.l.a getMediaTimeProvider() {
        if (this.mTimeProvider == null) {
            this.mTimeProvider = new e(this);
        }
        this.mTimeProvider.g(this.mPlaybackSpeed);
        this.mTimeProvider.t(!isPlaying());
        boolean z = this.mIsBuffering;
        if (z) {
            this.mTimeProvider.q(z);
        }
        return this.mTimeProvider;
    }

    public int getMemoryPlayType() {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            return fVar.g();
        }
        return 0;
    }

    public int getMgtvFastMode() {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            return fVar.j();
        }
        return 0;
    }

    public int getMpx() {
        return this.mpx;
    }

    public long getNetdSVCTimeMs() {
        return this.mNetdSVCTimeMs;
    }

    public MgtvPlayerListener.OnAVPlayListener getOnAVPlayListener() {
        return this.mOnAVPlayListener;
    }

    public MgtvPlayerListener.OnFrameListener getOnFrameListener() {
        return this.mOnFrameListener;
    }

    public MgtvPlayerListener.OnPlayerEventListener getOnPlayerEventListener() {
        return this.mOnPlayerEventListener;
    }

    public ExTicker getPlayTicker() {
        return this.mPlayTicker;
    }

    public float getPlaybackSpeed() {
        return this.mMediaPlayer.m();
    }

    public PlayerExtraInfo getPlayerExtraInfo() {
        PlayerExtraInfo playerExtraInfo = new PlayerExtraInfo();
        a.a.a.b.a aVar = this.mReporter;
        if (aVar != null) {
            playerExtraInfo.playSessionID = aVar.E();
        }
        playerExtraInfo.lastIP = getLastIP();
        playerExtraInfo.smt = this.mSmt;
        playerExtraInfo.dlt = this.mDlt;
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            playerExtraInfo.buftimeMs = fVar.f2();
            playerExtraInfo.bufsizeByte = this.mMediaPlayer.T1();
        }
        return playerExtraInfo;
    }

    public float getPlayerFileStartTimeFloatS() {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            return fVar.p();
        }
        return -1.0f;
    }

    public int getPlayerMode() {
        return this.mPlayerMode;
    }

    public int getPlayerType() {
        return this.mPlayerType;
    }

    public String getPlayingOriginUrl() {
        return this.mMediaPlayer.s();
    }

    public String getPlayingUrl() {
        return this.mMediaPlayer.t();
    }

    public Prepared4StartMode getPrepared4StartMode() {
        return this.mPrepared4StartMode;
    }

    public float getPropertyFloat(int i, float f) {
        f fVar = this.mMediaPlayer;
        return fVar != null ? fVar.f0(i, f) : f;
    }

    public long getPropertyLong(int i, long j) {
        f fVar = this.mMediaPlayer;
        return fVar != null ? fVar.l0(i, j) : j;
    }

    public int getReadDataSourceType() {
        return this.mMediaPlayer.v();
    }

    public float getRecordMaxPlaySpeed() {
        return this.mRecordMaxPlaySpeed;
    }

    public RenderType getRenderType() {
        return this.mRenderType;
    }

    public ReportParams getReportParams() {
        return this.mReportParams;
    }

    public int getRetryLastErrorCode() {
        return this.mRetryLastErrorCode;
    }

    public int getRfps() {
        return this.rfps;
    }

    public int getSfps() {
        return this.sfps;
    }

    public Bitmap getSnapshot(int i, int i2) {
        return this.mMediaPlayer.p0(i, i2);
    }

    public int getSourceRetryCode() {
        return this.mSourceRetryCode;
    }

    public int getSourceRetryCount() {
        return this.mSourceRetryCount;
    }

    public int getSwitchP2ps() {
        return this.mMediaPlayer.z();
    }

    public int getTsCacheSkipNum() {
        return this.mTsCacheSkipNum;
    }

    public int getVVbuft() {
        return this.mVVbuft;
    }

    public int getVfps() {
        return this.vfps;
    }

    public long getVideoBitRate() {
        return this.mMediaPlayer.C2();
    }

    public int getVideoFPS() {
        return this.mMediaPlayer.H();
    }

    public String getVideoFormat() {
        DataSourceInfo dataSourceInfo = this.mDataSourceInfo;
        if (dataSourceInfo != null) {
            return dataSourceInfo.videoFormat;
        }
        return null;
    }

    public int getVideoFrameClockNotifyMs() {
        this.mVideoFrameClockNotifyType = 1;
        return this.mVideoFrameClockNotifyMs;
    }

    public int getVideoFrameClockNotifyType() {
        return this.mVideoFrameClockNotifyType;
    }

    public int getVideoHeight() {
        return this.mMediaPlayer.F();
    }

    public int getVideoSarDen() {
        return this.mMediaPlayer.J();
    }

    public int getVideoSarNum() {
        return this.mMediaPlayer.L();
    }

    public ReportParams.VideoType getVideoType() {
        ReportParams reportParams = this.mReportParams;
        return reportParams != null ? reportParams.getVideoType() : ReportParams.VideoType.NONE;
    }

    public int getVideoWidth() {
        return this.mMediaPlayer.P();
    }

    public int getWanosAudioEffectChoice() {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            return fVar.R();
        }
        return 0;
    }

    public long getmVideoFrameClockNotifyTimeEnd() {
        return this.mVideoFrameClockNotifyTimeEnd;
    }

    public long getmVideoFrameClockNotifyTimeStart() {
        return this.mVideoFrameClockNotifyTimeStart;
    }

    public boolean isBackground() {
        return this.isBackground;
    }

    public boolean isDebug() {
        return this.mDebug;
    }

    public boolean isEnableDnsNoNetStrategy() {
        return this.mEnableDnsNoNetStrategy;
    }

    public boolean isForceHttpDns() {
        return this.mForceHttpDns;
    }

    public boolean isHDR() {
        String[] split;
        try {
            String hdrInfo = getHdrInfo();
            String logTag = getLogTag();
            DebugLog.i(logTag, "isHDR hdrInfo" + hdrInfo);
            if (!StringUtil.isEmpty(hdrInfo) && (split = hdrInfo.split(CertificateUtil.DELIMITER)) != null && split.length >= 1) {
                if ("1".equalsIgnoreCase(split[0])) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isHLSPlayingUrl() {
        return this.mMediaPlayer.x1();
    }

    public boolean isHardware() {
        return this.mMediaPlayer.R1();
    }

    public boolean isHttpDnsNeedRetry() {
        return this.mHttpDnsNeedRetry;
    }

    public boolean isInitMp4Error() {
        return this.mIsInitMp4Error;
    }

    public boolean isLive() {
        return this.mIsLive;
    }

    public boolean isLoadDataPaused() {
        f fVar = this.mMediaPlayer;
        return (fVar == null || fVar.e0()) ? false : true;
    }

    public boolean isLoopSwitching() {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            return fVar.A2();
        }
        return false;
    }

    public boolean isMediaCodecSWRender() {
        return this.mMediaPlayer.V2();
    }

    public boolean isMgtvCore() {
        return this.mMediaPlayer.f3();
    }

    public boolean isNativePausedLoadData() {
        return this.mIsNativePausedLoadData == 1;
    }

    public boolean isNetworkChangeWhilePlaying() {
        return this.mNetworkChangeWhilePlaying;
    }

    public boolean isOppoExFunEnable() {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            return fVar.v3() || this.mMediaPlayer.n3();
        }
        return false;
    }

    public boolean isPlaying() {
        return this.mMediaPlayer.z3();
    }

    public boolean isRecording() {
        return this.mMediaPlayer.L3();
    }

    public boolean isRendered() {
        return this.mIsVideoRendered;
    }

    public boolean isRfpsLow() {
        return getSfps() > 15 && getRfps() > 0 && getRfps() < 12;
    }

    public boolean isRfpsLowFilterChanged() {
        return this.rfpsLowFilterChanged;
    }

    public boolean isSourceSwitching() {
        return this.mSourceSwitching;
    }

    public boolean isSourceSwitchingComplete() {
        return this.mSourceSwitchingComplete;
    }

    public boolean isSpaceAudioSwitchOn() {
        return this.isSpaceAudioSwitchOn;
    }

    public boolean isSupportAMCKeyFrameBackup() {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            return fVar.F3();
        }
        return true;
    }

    public boolean isSupportedSnapshot() {
        return this.mMediaPlayer.I3() && !isHDR();
    }

    public boolean isSwitchingPrepared() {
        return this.mSwitchingPrepared;
    }

    public boolean isVfpsLow() {
        return getSfps() > 15 && getVfps() > 0 && getVfps() < 15;
    }

    public boolean isVod() {
        ReportParams reportParams = this.mReportParams;
        return reportParams != null && reportParams.getVideoType() == ReportParams.VideoType.VOD;
    }

    public boolean isWanosAudioEffectValid() {
        return this.mIsWanosAudioEffectValid;
    }

    public void nativeCrashTest(NativeSoType nativeSoType) {
        int i = AnonymousClass28.$SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$NativeSoType[nativeSoType.ordinal()];
        int i2 = 3;
        if (i == 1) {
            i2 = 0;
        } else if (i == 2) {
            i2 = 1;
        } else if (i == 3) {
            i2 = 2;
        } else if (i != 4) {
            i2 = -1;
        }
        this.mMediaPlayer.X1(i2);
    }

    public void pause() throws IllegalStateException {
        Context context;
        DebugLog.i(getLogTag(), "pause player");
        if (this.mEnableDnsNoNetStrategy && (context = this.mContext) != null && !c.a.a.b.d.d.d(context)) {
            pauseLoadData();
        }
        this.mMediaPlayer.R3();
        this.mPlayTicker.pause();
        this.mBufferTick.pause();
        this.mPlayStatus = PlayStatus.PAUSED;
        GifRecorder gifRecorder = this.mGifRecorder;
        if (gifRecorder != null) {
            gifRecorder.pause();
        }
        e eVar = this.mTimeProvider;
        if (eVar != null) {
            eVar.t(true);
        }
    }

    public void pauseLoadData() {
        if (isLoadDataPaused()) {
            return;
        }
        this.mMediaPlayer.U3();
    }

    public void prepareAsync() throws IllegalStateException {
        ReportParams reportParams;
        DebugLog.i(getLogTag(), "prepareAsync in");
        this.mPlayStatus = PlayStatus.PREPARING;
        this.mIsVideoRendered = false;
        this.mPreBufferState.reset();
        if (isDnsCacheEnable() && (reportParams = this.mReportParams) != null && reportParams.getRetryIndex() >= 2 && this.mReportParams.getLastErrorCodeExtra() == 100701) {
            this.mHttpDnsEnable = true;
        }
        this.mPrepareAsyncTimeStampMs = System.currentTimeMillis();
        printErrorMd5();
        MgtvPlayerBroadcastObserver mgtvPlayerBroadcastObserver = this.mObserver;
        if (mgtvPlayerBroadcastObserver != null) {
            mgtvPlayerBroadcastObserver.register();
        }
        this.mInnerFlowDataStatistic.reset();
        FFmpegApi.remove_all_dns_cache();
        this.mMediaPlayer.X3();
        autoWanosAudioEffectChoice();
        DebugLog.i(getLogTag(), "prepareAsync out");
    }

    public void release() {
        DebugLog.i(getLogTag(), "release player");
        MgtvPlayerSpatializer mgtvPlayerSpatializer = this.mgtvPlayerSpatializer;
        if (mgtvPlayerSpatializer != null) {
            mgtvPlayerSpatializer.release(hashCode() + "");
        }
        a.a.a.b.a aVar = this.mReporter;
        if (aVar != null) {
            aVar.M();
            this.mReporter.u();
        }
        resetData();
        stopTickers();
        this.mIsVideoRendered = false;
        this.mPlayStatus = PlayStatus.IDLE;
        this.mErrorExtraCodeStore = -1;
        checkInvalidThread(2, "release");
        stop();
        this.mMediaPlayer.a4();
        synchronized (this.ptsLocker) {
            this.ptsListeners.clear();
            HandlerThread handlerThread = this.ptsHandlerThread;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                this.ptsHandlerThread = null;
            }
            WeakHandler weakHandler = this.ptsWeakHandler;
            if (weakHandler != null) {
                weakHandler.removeMessages(256);
                this.ptsWeakHandler = null;
            }
        }
        resetDataAfter();
    }

    public void removeSubtitleSources() {
        c.a.a.a.p.c.c(MessengerShareContentUtility.SUBTITLE, "removeSubtitleSources in");
        e eVar = this.mTimeProvider;
        if (eVar != null) {
            eVar.u();
        }
        List<SubtitleSource> list = this.mSubtitleSources;
        if (list != null && !list.isEmpty()) {
            for (SubtitleSource subtitleSource : this.mSubtitleSources) {
                subtitleSource.unBindHolder();
            }
            this.mSubtitleSources.clear();
        }
        b bVar = this.mSubtitleController;
        if (bVar != null) {
            bVar.q();
            this.mSubtitleController = null;
        }
        e eVar2 = this.mTimeProvider;
        if (eVar2 != null) {
            eVar2.f();
            this.mTimeProvider = null;
        }
    }

    public void removeVideoPTSListener(MgtvPlayerListener.OnVideoPTSListener onVideoPTSListener) {
        synchronized (this.ptsLocker) {
            if (onVideoPTSListener == null) {
                return;
            }
            this.ptsListeners.remove(onVideoPTSListener);
        }
    }

    public void reportEndWithError(int i, int i2) {
        a.a.a.b.a aVar = this.mReporter;
        if (aVar != null) {
            aVar.C(i, i2);
        }
    }

    public boolean reset() {
        DebugLog.i(getLogTag(), "reset player in");
        long currentTimeMillis = System.currentTimeMillis();
        a.a.a.b.a aVar = this.mReporter;
        if (aVar != null) {
            aVar.M();
        }
        resetData();
        stopTickers();
        this.mIsVideoRendered = false;
        this.mPlayStatus = PlayStatus.IDLE;
        this.mHw2SwType = Hw2SwType.NONE;
        this.mErrorExtraCodeStore = -1;
        checkInvalidThread(1, "reset");
        stop();
        boolean j4 = this.mMediaPlayer.j4();
        resetDataAfter();
        String logTag = getLogTag();
        DebugLog.i(logTag, "reset player out cost:" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return j4;
    }

    public void resetLoopDataImpl() {
        this.mSeekStartMs = -1L;
        this.imp4dh = 0;
        this.mpx = 0;
        this.fstime = "n";
        this.mcColorFormat = "n_n";
        this.mLastTsSkipErrExtra = 0;
        this.mLastTsSkipErrFileName = null;
        this.mLastIsNetworkAvailableNNS = true;
        GifRecorder gifRecorder = this.mGifRecorder;
        if (gifRecorder != null) {
            gifRecorder.reset();
        }
        this.mIsVideoRendered = false;
        this.mSourceSwitching = false;
        this.mSourceSwitchingComplete = false;
        this.mErrorUrl = "";
        this.mLastRequestUrl = "";
        this.mIsBuffering = false;
        this.mIsLive = false;
        this.mCacheM3u8Path = null;
        this.mCacheTsPaths = null;
        this.mCacheReplaceMap.clear();
        this.mTsCacheSkipNum = 0;
        this.mIsInnerRetrying = false;
        this.mRetryLastErrorCode = 0;
        this.mLoopPlayerReset = true;
        synchronized (this.mDnsLock) {
            this.mDnsLock.notifyAll();
        }
        this.mHttpDnsEnable = false;
        this.mLastUri = null;
        this.mCurrentDnsDsc = "native";
        this.mLastIP = null;
        this.mLastP2pCdnIP = null;
        this.mLastHostIP = null;
        this.mLastTcpIP = null;
        this.mLastHostErr = MLog.a.b;
        this.mLastTcpErr = MLog.a.b;
        this.mLastIpCount = 0;
        this.mLastIpIndex = -1;
        this.mLastDnsType = -1;
        this.mSourceRetryCount = 0;
        this.mSourceRetryCode = 0;
        this.mAVSyncErrReported = false;
        this.mAVSyncErrSumReported = false;
        this.mAVSyncErrSum = 0;
        this.mPrepareAsyncTimeStampMs = 0L;
        this.mReportedTSLAN = false;
        this.mIsAudioExist = -1;
        this.mIsInitMp4Error = false;
        this.mPlaybackSpeed = 1.0f;
        clearIPCache();
        this.mCodecName = "n";
        this.hdrInfo = "n";
        this.mVideoFrameClockNotifyMs = -1;
        this.mNetworkChangeWhilePlaying = false;
        this.mInnerFlowDataStatistic.reset();
        this.mLastPosition = 0;
        this.mPositionLoged = false;
        this.mVVbuft = -1;
        synchronized (this.mDnsNoNetWaiter) {
            DebugLog.i(getLogTag(), "resetLoopData DnsNetStrategy mDnsNoNetWaiter notifyAll");
            this.mDnsNoNetWaiter.notifyAll();
        }
    }

    public void resetLoopPlay() {
        resetLoopDataImpl();
        a.a.a.b.a aVar = this.mReporter;
        if (aVar != null) {
            aVar.M();
        }
    }

    public void resetSpatializerSwitchOn() {
        this.isSpaceAudioSwitchOn = false;
    }

    public void resumeLoadData() {
        if (isLoadDataPaused()) {
            MgtvPlayerListener.OnLoadDataListener onLoadDataListener = this.mOnLoadDataListener;
            if (onLoadDataListener != null) {
                onLoadDataListener.onBeforeLoadDataResume();
            }
            this.mMediaPlayer.c();
        }
    }

    public void seekTo(int i) throws IllegalStateException {
        preSeekTo(i, false);
        a.a.a.b.a aVar = this.mReporter;
        if (aVar != null) {
            aVar.L();
        }
        int validSeekPosition = validSeekPosition(i);
        if (validSeekPosition >= 0) {
            this.mMediaPlayer.i2(validSeekPosition);
        }
    }

    public void seekTo(int i, boolean z) throws IllegalStateException {
        seekTo(i, z, false);
    }

    public void seekTo(int i, boolean z, boolean z2) throws IllegalStateException {
        preSeekTo(i, z2);
        a.a.a.b.a aVar = this.mReporter;
        if (aVar != null) {
            aVar.L();
        }
        int validSeekPosition = validSeekPosition(i);
        if (validSeekPosition >= 0) {
            this.mMediaPlayer.K1(validSeekPosition, z);
        }
    }

    public void setAMCKeyFrameBackMode(int i) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.j2(2018091301, i);
        }
    }

    public void setAccSeekKeyFrameInterval(int i) {
        this.mAccSeekKeyFrameInterval = i;
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.j2(2017051801, i);
        }
    }

    public void setAccurateSeekEnable(boolean z) {
        this.mAccurateSeekEnable = z;
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.j2(2017031302, z ? 1 : 0);
        }
    }

    public void setAudioStreamType(int i) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "prepareAsync in. streamtype:" + i);
        this.mMediaPlayer.u2(i);
        DebugLog.i(getLogTag(), "prepareAsync out");
    }

    public void setBackground(boolean z) {
        FlowReportProcessor flowReportProcessor;
        this.isBackground = z;
        if (!z || (flowReportProcessor = this.mMainFlowReportProcessor) == null) {
            return;
        }
        flowReportProcessor.forceTrigger();
    }

    public void setConfig(int i, int i2) {
        this.mMediaPlayer.j2(i, i2);
    }

    public void setDataSource(MgtvPlayerDataSource mgtvPlayerDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        this.mSourceSwitching = false;
        this.mSourceSwitchingComplete = false;
        this.mHw2SwType = Hw2SwType.NONE;
        setPlayerReset(false);
        this.mMediaPlayer.j3(0);
        setDataSourceBefore("", null);
        this.mMediaPlayer.O0(mgtvPlayerDataSource);
        setAudioAttributes();
        doReportPV();
    }

    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mSourceSwitching = false;
        this.mSourceSwitchingComplete = false;
        this.mHw2SwType = Hw2SwType.NONE;
        setPlayerReset(false);
        this.mMediaPlayer.j3(0);
        String replaceUrlSftcNoP2p = FlowReportProcessor.replaceUrlSftcNoP2p(str, this.mReportParams);
        setDataSourceBefore(replaceUrlSftcNoP2p, null);
        this.mMediaPlayer.v2(replaceUrlSftcNoP2p);
        setAudioAttributes();
        doReportPV();
    }

    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int, boolean] */
    public void setDataSourceBefore(String str, IP2pTask iP2pTask) {
        ReportParams reportParams;
        FlowReportProcessor flowReportProcessor = this.mMainFlowReportProcessor;
        if (flowReportProcessor != null) {
            flowReportProcessor.stop();
        }
        ?? r0 = (!FlowReportProcessor.isEnable() || FlowReportProcessor.isInvalidVideoType(this.mReportParams)) ? 0 : 1;
        this.isFlowReportEnable = r0;
        this.mMediaPlayer.j2(2021031501, (int) r0);
        if (this.isFlowReportEnable && (reportParams = this.mReportParams) != null) {
            this.mMainFlowReportProcessor = new FlowReportProcessor(str, this.mReportParams.getVid(), NumericUtil.parseInt(this.mReportParams.getDef()), this.mReportParams.getVideoSession(), iP2pTask != null && (reportParams.getProxyType() == ReportParams.ProxyType.ONLY_P2P || this.mReportParams.getProxyType() == ReportParams.ProxyType.P2P_DRM), "main");
            return;
        }
        this.mMainFlowReportProcessor = null;
        String logTag = getLogTag();
        DebugLog.i(logTag, "no FlowReportProcessor. isFlowReportEnable:" + this.isFlowReportEnable);
        if (!this.isFlowReportEnable) {
            String logTag2 = getLogTag();
            DebugLog.i(logTag2, "no FlowReportProcessor. isInited:" + FlowReporter.isInited() + ",mode:" + NetPlayConfig.getFlowReportMode());
        }
        if (this.mReportParams == null) {
            DebugLog.i(getLogTag(), "no FlowReportProcessor. mReportParams is null.");
        }
    }

    public void setDataSourceInfo(DataSourceInfo dataSourceInfo) {
        this.mDataSourceInfo = dataSourceInfo;
        if (dataSourceInfo == null) {
            DebugLog.i(getLogTag(), "setDataSourceInfo null");
            return;
        }
        String logTag = getLogTag();
        DebugLog.i(logTag, "setDataSourceInfo VideoFormat:" + this.mDataSourceInfo.getVideoFormat() + "AudioFormat:" + this.mDataSourceInfo.getAudioFormat() + ",FileFormat:" + this.mDataSourceInfo.getFileFormat() + "VideoWidth:" + this.mDataSourceInfo.getVideoWidth() + ",VideoHeight:" + this.mDataSourceInfo.getVideoHeight() + ",bitRate:" + this.mDataSourceInfo.getBitRate());
        this.mLastVideoWidth = this.mDataSourceInfo.getVideoWidth();
        this.mLastVideoHeight = this.mDataSourceInfo.getVideoHeight();
    }

    public void setDataSourceType(DataSourceType dataSourceType) {
        f fVar;
        this.mDataSourceType = dataSourceType;
        int i = 1;
        if (AnonymousClass28.$SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$DataSourceType[dataSourceType.ordinal()] != 1) {
            fVar = this.mMediaPlayer;
            i = 0;
        } else {
            fVar = this.mMediaPlayer;
        }
        fVar.j2(2016070401, i);
        this.mMediaPlayer.j2(2016021705, i);
    }

    public void setDebug(boolean z) {
        this.mDebug = z;
    }

    public void setDisableAVDecoderStart(boolean z) {
        this.mMediaPlayer.j2(2020072201, z ? 1 : 0);
    }

    public void setDisplay(SurfaceHolder surfaceHolder) throws InvalidParameterException {
        this.mMediaPlayer.L1(surfaceHolder);
    }

    public void setDisplay(SurfaceHolder surfaceHolder, int i) throws InvalidParameterException {
        this.mMediaPlayer.J0(surfaceHolder, i);
    }

    public void setDnsFamilyType(int i) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.j2(2017061201, i);
        }
    }

    public void setDrmInfoList(List<MgtvDrmParams.DrmInfo> list) {
        this.mMediaPlayer.k1(list);
    }

    public void setDrmLicensePrepared() {
        this.mMediaPlayer.f();
    }

    public void setEnableDnsNoNetStrategy(boolean z) {
        this.mEnableDnsNoNetStrategy = z;
    }

    public void setEnableImgoVsr(boolean z) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            this.mEnableImgoVsr = z;
            fVar.j2(2022031001, z ? 1 : 0);
        }
    }

    public void setEnableMediacodecSWRender(boolean z) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.j2(2020072001, z ? 1 : 0);
        }
    }

    public void setEnablePlayerMode(PlayerModeType playerModeType) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            int i = playerModeType == PlayerModeType.TYPE_PLAYER_MODE_LIVE ? 1 : playerModeType == PlayerModeType.TYPE_PLAYER_MODE_LOOP ? 2 : playerModeType == PlayerModeType.TYPE_PLAYER_MODE_SMOOTH ? 3 : 0;
            this.mPlayerMode = i;
            fVar.j2(2018100801, i);
        }
    }

    public void setEnableVideoStartTime(boolean z) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.S2(z);
        }
    }

    public void setEnableWanosAudioEffect(boolean z) {
        this.isUserAudioEnable = z;
        if (z) {
            autoWanosAudioEffectChoice();
            return;
        }
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.y3(0);
        }
    }

    public void setFlowDataStatistic(FlowDataStatistic flowDataStatistic) {
        this.mFlowDataStatistic = flowDataStatistic;
    }

    public MgtvMediaPlayer setForceHttpDns(boolean z) {
        this.mForceHttpDns = z;
        return this;
    }

    public void setForceKeyframeSeekEnable(boolean z) {
        this.mKeyframeSeekEnable = z;
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.j2(2017080701, z ? 1 : 0);
        }
    }

    public void setFrameImageAtTime(String str, long j, long j2, int i, int i2, int i3) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "setFrameImageAtTime " + str + "-" + j + "-" + j2 + "-" + i + "-" + i2 + "-" + i3);
        this.mMediaPlayer.i1(str, j, j2, i, i2, i3);
    }

    public void setHlsCheckMD5(int i) {
        this.mMediaPlayer.j2(2019052701, i);
    }

    public MgtvMediaPlayer setHttpDnsNeedRetry(boolean z) {
        this.mHttpDnsNeedRetry = z;
        return this;
    }

    public void setInnerAutoRotateEnable(boolean z) {
        this.mInnerAutoRotateEnable = z;
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.j2(2018042401, z ? 1 : 0);
        }
    }

    public synchronized int setKeyFrameInfoFileBuf(byte[] bArr) {
        DebugLog.i(getLogTag(), "setKeyFrameInfoFileBuf success");
        return this.mMediaPlayer.k0(bArr);
    }

    public void setLastIP(String str) {
        this.mLastIP = str;
    }

    public void setLiveReopen() {
        if (this.mPlayerMode == 1) {
            this.mLiveReopen = true;
        }
    }

    public void setLiveStartIndex(int i) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.j2(2018091302, i);
        }
    }

    public void setLoopABPlay(boolean z, long j, long j2) {
        this.mMediaPlayer.n1(z, j, j2);
    }

    public void setLoopSeekPlay(boolean z, int i) {
        preLoopSeek(z);
        this.mMediaPlayer.m1(z, i);
    }

    public void setM3u8Caches(String str, String[] strArr) {
        DebugLog.i(getLogTag(), "setM3u8Caches m3u8:" + str);
        if (strArr != null && strArr.length > 0) {
            for (String str2 : strArr) {
                DebugLog.i(getLogTag(), "setM3u8Caches ts:" + str2);
            }
        }
        this.mCacheM3u8Path = str;
        this.mCacheTsPaths = strArr;
    }

    public void setMarkMediacodecSWRender(boolean z) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.j2(2020072002, z ? 1 : 0);
        }
    }

    public void setMediacodecRecreateformat(boolean z, boolean z2) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.p1(z, z2);
        }
    }

    public void setMgtvFastMode(int i) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.R2(i);
        }
    }

    public void setNETIsBroken(boolean z) {
        this.mMediaPlayer.c3(z);
    }

    public void setNetAddrinfo(AddrinfoType addrinfoType, int i, boolean z) {
        setNetAddrinfo(addrinfoType, i, z, a.d.a, false, false);
    }

    public void setNetAddrinfo(AddrinfoType addrinfoType, int i, boolean z, a.d dVar, boolean z2) {
        setNetAddrinfo(addrinfoType, i, z, dVar, z2, false);
    }

    public void setNetAddrinfo(AddrinfoType addrinfoType, int i, boolean z, a.d dVar, boolean z2, boolean z3) {
        this.mAddrinfoType = addrinfoType;
        this.mAddrinfoTimeoutMs = i;
        setAsyncDns(z, dVar);
        this.mBackJavaDns = z3;
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            if (this.mAddrinfoType != AddrinfoType.TYPE_DNS_CACHE) {
                fVar.j2(2018022701, 0);
            } else {
                fVar.j2(2018022701, 1);
                int i2 = this.mAddrinfoTimeoutMs;
                if (i2 > 0) {
                    this.mMediaPlayer.j2(2018022702, i2);
                }
            }
            this.mMediaPlayer.j2(2018110701, z2 ? 1 : 0);
        }
    }

    public void setNetPlayConfig(NetPlayConfig netPlayConfig) {
        this.mNetPlayConfig = netPlayConfig;
    }

    public void setNetdSVCTimeMs(long j) {
        this.mNetdSVCTimeMs = j;
    }

    public void setOnAVPlayListener(MgtvPlayerListener.OnAVPlayListener onAVPlayListener) {
        this.mOnAVPlayListener = onAVPlayListener;
    }

    public void setOnBufferingTimeoutListener(MgtvPlayerListener.OnBufferingTimeoutListener onBufferingTimeoutListener) {
        this.mOnBufferingTimeoutListener = onBufferingTimeoutListener;
    }

    public void setOnBufferingUpdateListener(MgtvPlayerListener.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mMediaPlayer.Q0(onBufferingUpdateListener);
    }

    public void setOnCompletionListener(MgtvPlayerListener.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(MgtvPlayerListener.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnFrameListener(MgtvPlayerListener.OnFrameListener onFrameListener) {
        this.mOnFrameListener = onFrameListener;
    }

    public void setOnGetFrameImageListener(MgtvPlayerListener.OnGetFrameImageListener onGetFrameImageListener) {
        this.mOnGetFrameImageListener = onGetFrameImageListener;
    }

    public void setOnInfoListener(MgtvPlayerListener.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setOnInfoStringListener(MgtvPlayerListener.OnInfoStringListener onInfoStringListener) {
        this.mOnInfoStringListener = onInfoStringListener;
    }

    public void setOnLoadDataListener(MgtvPlayerListener.OnLoadDataListener onLoadDataListener) {
        this.mOnLoadDataListener = onLoadDataListener;
    }

    public void setOnPauseListener(MgtvPlayerListener.OnPauseListener onPauseListener) {
        this.mOnPauseListener = onPauseListener;
    }

    public void setOnPlayerEventListener(MgtvPlayerListener.OnPlayerEventListener onPlayerEventListener) {
        this.mOnPlayerEventListener = onPlayerEventListener;
    }

    public void setOnPreparedListener(MgtvPlayerListener.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setOnRecordVideoListener(MgtvPlayerListener.OnRecordVideoListener onRecordVideoListener) {
        this.mOnRecordVideoListener = onRecordVideoListener;
    }

    public void setOnSeekCompleteListener(MgtvPlayerListener.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    public void setOnSourceNetHandledListener(MgtvPlayerListener.OnSourceNetHandledListener onSourceNetHandledListener) {
        this.mOnSourceNetHandledListener = onSourceNetHandledListener;
    }

    public void setOnStartListener(MgtvPlayerListener.OnStartListener onStartListener) {
        this.mOnStartListener = onStartListener;
    }

    public void setOnSwitchSmoothSourceListener(MgtvPlayerListener.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener) {
        this.mOnSwitchSmoothSourceListener = onSwitchSmoothSourceListener;
    }

    public void setOnSwitchSourceListener(MgtvPlayerListener.OnSwitchSourceListener onSwitchSourceListener) {
        this.mOnSwitchSourceListener = onSwitchSourceListener;
    }

    public void setOnVideoSizeChangedListener(MgtvPlayerListener.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mMediaPlayer.d1(onVideoSizeChangedListener);
    }

    public void setOnWarningListener(MgtvPlayerListener.OnWarningListener onWarningListener) {
        this.mOnWarningListener = onWarningListener;
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.e1(onWarningListener);
        }
    }

    public void setP2pDataSource(String str, @Nullable IP2pTask iP2pTask, @Nullable String str2, int i) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        this.mSourceSwitching = false;
        this.mSourceSwitchingComplete = false;
        this.mHw2SwType = Hw2SwType.NONE;
        setPlayerReset(false);
        if (this.mEnableP2PHttpDns) {
            this.mDnsThreadManager.g();
            this.mDnsThreadManager.e(this.mHttpDnsNeedRetry);
            this.mDnsThreadManager.d(UrlUtil.getHostName(str));
        }
        String replaceUrlSftcNoP2p = FlowReportProcessor.replaceUrlSftcNoP2p(str, this.mReportParams);
        String replaceUrlSftcNoP2p2 = FlowReportProcessor.replaceUrlSftcNoP2p(str2, this.mReportParams);
        setDataSourceBefore(replaceUrlSftcNoP2p, iP2pTask);
        this.mMediaPlayer.j1(replaceUrlSftcNoP2p, iP2pTask, replaceUrlSftcNoP2p2, i);
        doReportPV();
    }

    public void setP2pHttpDns(boolean z, boolean z2) {
        this.mEnableP2PHttpDns = z;
        this.mForceP2pHttpDns = z2;
    }

    public void setPlaybackSpeed(float f) {
        if (!checkInvalidThread(3, "setPlaybackSpeed") && f > 0.0f) {
            this.mPlaybackSpeed = f;
            e eVar = this.mTimeProvider;
            if (eVar != null) {
                eVar.g(f);
            }
            this.mMediaPlayer.w0(f);
            this.mRecordMaxPlaySpeed = Math.max(this.mRecordMaxPlaySpeed, f);
        }
    }

    public void setPlaybackStep() {
        if (!isHardware() || isSupportAMCKeyFrameBackup()) {
            this.mMediaPlayer.b3(0);
        }
    }

    public void setPlaybackStep(int i) {
        this.mMediaPlayer.b3(i);
    }

    public void setPlayerFileStartTimeFloatS(float f) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.I1(2019081201, f);
        }
    }

    public void setPlayerPrepareStartPosMs(int i) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.j2(2018112702, i);
        }
    }

    public void setPlayerSeekAtStartPosMs(int i) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.j2(2016032101, i);
        }
    }

    public void setPreBufferTimeoutMs(int i) {
        if (i > 0) {
            String logTag = getLogTag();
            DebugLog.i(logTag, "setPreBufferTimeoutMs:" + i);
            this.mPreBufferTimeoutMs = i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r5 != 4) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setPrepared4StartMode(com.hunantv.media.player.MgtvMediaPlayer.Prepared4StartMode r5) {
        /*
            r4 = this;
            r4.mPrepared4StartMode = r5
            int[] r0 = com.hunantv.media.player.MgtvMediaPlayer.AnonymousClass28.$SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$Prepared4StartMode
            int r5 = r5.ordinal()
            r5 = r0[r5]
            r0 = 2
            r1 = 1
            r2 = 0
            if (r5 == r1) goto L1a
            if (r5 == r0) goto L18
            r3 = 3
            if (r5 == r3) goto L1c
            r3 = 4
            if (r5 == r3) goto L1c
            goto L1a
        L18:
            r0 = 1
            goto L1b
        L1a:
            r0 = 0
        L1b:
            r1 = 0
        L1c:
            com.hunantv.media.player.utils.SyncStateMachine r5 = r4.mPreBufferState
            r5.setEnable(r1)
            c.a.a.a.f r5 = r4.mMediaPlayer
            r1 = 2017112301(0x783ab0ed, float:1.5146183E34)
            r5.j2(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.player.MgtvMediaPlayer.setPrepared4StartMode(com.hunantv.media.player.MgtvMediaPlayer$Prepared4StartMode):void");
    }

    public void setPropertyLong(int i, long j) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.J1(i, j);
        }
    }

    public void setReadDataSourceType(int i) {
        this.mMediaPlayer.j3(i);
    }

    public void setRenderType(RenderType renderType) {
        f fVar;
        this.mRenderType = renderType;
        int i = 1;
        if (AnonymousClass28.$SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$RenderType[renderType.ordinal()] != 1) {
            fVar = this.mMediaPlayer;
            i = 0;
        } else {
            fVar = this.mMediaPlayer;
        }
        fVar.j2(201507065, i);
    }

    public void setReportParams(ReportParams reportParams) {
        this.mReportParams = reportParams;
        String logTag = getLogTag();
        DebugLog.i(logTag, "setReportParams params:" + reportParams);
        a.a.a.b.a aVar = this.mReporter;
        if (aVar != null) {
            aVar.n(reportParams);
        }
        a.a.a.b.a aVar2 = this.mReporterSL;
        if (aVar2 != null) {
            aVar2.n(reportParams);
        }
        f fVar = this.mMediaPlayer;
        if (fVar != null && reportParams != null) {
            fVar.g1(String.valueOf(reportParams.getProxyType().ordinal()));
            if (!StringUtil.isEmpty(reportParams.getVfps())) {
                this.mRecordVfps = Float.parseFloat(reportParams.getVfps());
            }
        }
        f fVar2 = this.mMediaPlayer;
        if (fVar2 != null) {
            fVar2.f1(reportParams);
        }
        ReportParams reportParams2 = this.mReportParams;
        if (reportParams2 != null) {
            if (reportParams2.getVideoType().equals(ReportParams.VideoType.AD_PRE) || this.mReportParams.getVideoType().equals(ReportParams.VideoType.AD_MID)) {
                this.mWeakBufferTimeoutMs = 60000;
            }
        }
    }

    public void setScreenOnWhilePlaying(boolean z) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "setScreenOnWhilePlaying in. screenOn:" + z);
        this.mMediaPlayer.k3(z);
        DebugLog.i(getLogTag(), "setScreenOnWhilePlaying out.");
    }

    public void setSeekAutoStartAfterComplete(boolean z) {
        setConfig(2020080601, z ? 1 : 0);
    }

    public void setSkipLoopFilter(SkipLoopFilterType skipLoopFilterType) {
        f fVar;
        int i;
        this.mSkipLoopFilterType = skipLoopFilterType;
        int i2 = AnonymousClass28.$SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$SkipLoopFilterType[skipLoopFilterType.ordinal()];
        if (i2 == 1) {
            fVar = this.mMediaPlayer;
            i = 0;
        } else if (i2 == 2) {
            fVar = this.mMediaPlayer;
            i = 8;
        } else if (i2 == 3) {
            fVar = this.mMediaPlayer;
            i = 16;
        } else if (i2 == 4) {
            fVar = this.mMediaPlayer;
            i = 32;
        } else if (i2 != 5) {
            return;
        } else {
            fVar = this.mMediaPlayer;
            i = 48;
        }
        fVar.j2(2016021701, i);
    }

    public int setSmoothKeyFrameInfo(byte[] bArr, String str, String str2) {
        DebugLog.i(getLogTag(), "setSmoothKeyFrameInfoBuf in");
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || bArr == null || bArr.length <= 0) {
            DebugLog.i(getLogTag(), "setSmoothKeyFrameInfoBuf info error");
            return -1;
        }
        synchronized (this.mSwitchSmoothSourceLocker) {
            String keyFrameMapKey = getKeyFrameMapKey(str, str2);
            if (!matchSwitchedSmoothSource(keyFrameMapKey)) {
                String logTag = getLogTag();
                DebugLog.i(logTag, "setSmoothKeyFrameInfoBuf not matchSwitchedSmoothSource key:" + keyFrameMapKey + " put into map size:" + this.mSmoothKeyFrameMap.size());
                this.mSmoothKeyFrameMap.put(keyFrameMapKey, bArr);
                return 0;
            }
            String logTag2 = getLogTag();
            DebugLog.i(logTag2, "setSmoothKeyFrameInfoBuf matchSwitchedSmoothSource key:" + keyFrameMapKey);
            if (KeyFrameInfoUtils.isKeyFrameDataValid(bArr, this.mSwitchedSmoothSource.videoFileHash) != 0) {
                DebugLog.i(getLogTag(), "setSmoothKeyFrameInfoBuf isKeyFrameDataValid error");
                return -2;
            }
            int keyFrameInfoFileBuf = setKeyFrameInfoFileBuf(bArr);
            this.mSmoothKeyFrameMap.clear();
            return keyFrameInfoFileBuf;
        }
    }

    public void setSubtitleCallback(ISubtitle.SubtitleCallback subtitleCallback) {
        this.mSubtitleCallback = subtitleCallback;
    }

    @TargetApi(14)
    public void setSurface(Surface surface) {
        this.mMediaPlayer.G0(surface);
    }

    public void setSurfaceHolder(IMgtvRenderView.ISurfaceHolder iSurfaceHolder) throws InvalidParameterException {
        setSurfaceHolder(iSurfaceHolder, -1);
    }

    public void setSurfaceHolder(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i) throws InvalidParameterException {
        this.mMediaPlayer.M0(iSurfaceHolder, i);
    }

    public void setTimeout(int i, int i2, int i3) {
        if (i > 0) {
            this.mConnectTimeOutMs = i;
        }
        if (i2 > 0) {
            this.mReceiveDataTimeOutMs = i2;
        }
        if (i3 > 0) {
            this.mBufferTimeoutMs = i3;
        }
        int i4 = this.mConnectTimeOutMs;
        if (i4 > 0) {
            this.mMediaPlayer.j2(201507061, i4);
        }
        int i5 = this.mReceiveDataTimeOutMs;
        if (i5 > 0) {
            this.mMediaPlayer.j2(201507062, i5);
        }
    }

    public void setTsFlowTag(String str) {
        if (StringUtil.isEmpty(str)) {
            str = "";
        }
        ReportParams reportParams = this.mReportParams;
        if (reportParams != null) {
            reportParams.setFlowt(str);
        }
        this.mMediaPlayer.y0(2021031001, str);
    }

    public void setVideoFrameClockNotifyMs(int i) {
        this.mVideoFrameClockNotifyMs = i;
        if (i > 0) {
            this.mMediaPlayer.s3(i);
        }
    }

    public void setVideoFrameClockNotifyPts(long j, long j2) {
        this.mVideoFrameClockNotifyType = 2;
        this.mVideoFrameClockNotifyTimeStart = j;
        this.mVideoFrameClockNotifyTimeEnd = j2;
        this.mMediaPlayer.C0(j, j2);
    }

    public void setVolume(float f, float f2) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "setVolume leftVolume:" + f + ",rightVolume:" + f2);
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.x0(f, f2);
        }
    }

    public synchronized void setWanosAudioEffectChoice(int i) {
        if ((this.isExAudioEnable || this.isUserAudioEnable) && this.mMediaPlayer != null) {
            String logTag = getLogTag();
            DebugLog.i(logTag, "setWanosAudioEffectChoice value:" + i);
            this.mMediaPlayer.y3(i);
        }
    }

    public int setWanosAudioEffectConfig(byte[] bArr) {
        if (!Constants.FOR_OTT) {
            f fVar = this.mMediaPlayer;
            if (fVar == null) {
                return -999;
            }
            if (!this.isExAudioEnable && !fVar.U()) {
                return -999;
            }
            if (bArr != null) {
                String logTag = getLogTag();
                DebugLog.i(logTag, "setWanosAudioEffectConfig size:" + bArr.length);
                int A1 = this.mMediaPlayer.A1(bArr);
                autoWanosAudioEffectChoice();
                return A1;
            }
        } else if (this.mMediaPlayer == null) {
            return -999;
        } else {
            if (bArr != null) {
                String logTag2 = getLogTag();
                DebugLog.i(logTag2, "setWanosAudioEffectConfig size:" + bArr.length);
                return this.mMediaPlayer.A1(bArr);
            }
        }
        DebugLog.i(getLogTag(), "setWanosAudioEffectConfig null");
        return -999;
    }

    public void setWanosAudioEffectEnable(boolean z) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.t3(z);
        }
    }

    public void setonSpatializerInfoListener(MgtvPlayerListener.OnSpatializerInfoListener onSpatializerInfoListener) {
        this.onSpatializerInfoListener = onSpatializerInfoListener;
    }

    public void start() throws IllegalStateException {
        DebugLog.i(getLogTag(), "start player");
        this.mMediaPlayer.i();
        this.mPreBufferState.changeState(3);
        if (!this.mIsBuffering) {
            this.mPlayTicker.resume();
        }
        this.mBufferTick.resume();
        GifRecorder gifRecorder = this.mGifRecorder;
        if (gifRecorder != null) {
            gifRecorder.resume();
        }
        e eVar = this.mTimeProvider;
        if (eVar != null) {
            eVar.t(false);
        }
        this.mPlayStatus = PlayStatus.PLAYING;
    }

    public void startAVDecoder() {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            fVar.J1(90003, 1L);
        }
    }

    public void startRecVideo(String str) {
        int i;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            this.mMediaPlayer.H2(str);
        } catch (IOException unused) {
            i = 10001;
            callbackRecordError(i, 0);
        } catch (IllegalArgumentException unused2) {
            i = 10002;
            callbackRecordError(i, 0);
        } catch (IllegalStateException unused3) {
            i = 10003;
            callbackRecordError(i, 0);
        } catch (Exception unused4) {
            i = 10000;
            callbackRecordError(i, 0);
        }
    }

    public void stop() throws IllegalStateException {
        DebugLog.i(getLogTag(), "stop player");
        a.a.a.b.a aVar = this.mReporter;
        if (aVar != null) {
            aVar.M();
        }
        resetData();
        this.mIsVideoRendered = false;
        this.mMediaPlayer.l();
        stopTickers();
    }

    public void stopRecVideo() {
        int i;
        try {
            this.mMediaPlayer.o();
        } catch (IOException unused) {
            i = 10001;
            callbackRecordError(i, 1);
        } catch (IllegalArgumentException unused2) {
            i = 10002;
            callbackRecordError(i, 1);
        } catch (IllegalStateException unused3) {
            i = 10003;
            callbackRecordError(i, 1);
        } catch (Exception unused4) {
            i = 10000;
            callbackRecordError(i, 1);
        }
    }

    public boolean supportImgoAIQE(ImgoAIQE imgoAIQE) {
        f fVar = this.mMediaPlayer;
        if (fVar != null) {
            return fVar.q1(imgoAIQE.ImgoAIQE_w, imgoAIQE.ImgoAIQE_h, imgoAIQE.ImgoAIQE_def);
        }
        return false;
    }

    public float supportMaxSpeed(boolean z) {
        if (UrlUtil.isLocal(getPlayingOriginUrl())) {
            return 2.0f;
        }
        return MgtvPlayerSupporter.getMaxSpeedExt(this.mLastVideoWidth, this.mLastVideoHeight, this.mRecordVfps, getCurrentSourceCodecType(), z);
    }

    public void switchLoopSource(int i, String str, IP2pTask iP2pTask, String str2, int i2) {
        MgtvPlayerListener.OnErrorListener onErrorListener;
        int i3;
        if (this.mPlayerMode == 2) {
            try {
                doReportPV();
                String replaceUrlSftcNoP2p = FlowReportProcessor.replaceUrlSftcNoP2p(str, this.mReportParams);
                String replaceUrlSftcNoP2p2 = FlowReportProcessor.replaceUrlSftcNoP2p(str2, this.mReportParams);
                setDataSourceBefore(replaceUrlSftcNoP2p, iP2pTask);
                int g0 = this.mMediaPlayer.g0(i, replaceUrlSftcNoP2p, iP2pTask, replaceUrlSftcNoP2p2, this.mLoopSourceKey.incrementAndGet(), i2);
                if (g0 != 0) {
                    this.mErrorListener.onError(MGTVMEDIA_ERROR_WHAT_200100, Math.abs(g0) + MGTVMEDIA_ERROR_EXTRA_400100);
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
                onErrorListener = this.mErrorListener;
                i3 = MGTVMEDIA_ERROR_EXTRA_400198;
                onErrorListener.onError(MGTVMEDIA_ERROR_WHAT_200100, i3);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                onErrorListener = this.mErrorListener;
                i3 = MGTVMEDIA_ERROR_EXTRA_400199;
                onErrorListener.onError(MGTVMEDIA_ERROR_WHAT_200100, i3);
            }
        }
    }

    public void switchLoopSource(String str, int i) {
        switchLoopSource(0, str, null, null, i);
    }

    public void switchP2pVideoSource(int i, String str, IP2pTask iP2pTask, String str2, int i2, int i3, int i4) throws IOException, IllegalArgumentException, IllegalStateException {
        this.mMediaPlayer.z0(i, str, iP2pTask, str2, i2, i3, i4);
        this.mSourceSwitching = true;
        this.mSourceSwitchingComplete = false;
        this.mSwitchingPrepared = false;
        doReportSLPV();
    }

    public void switchSmoothSource(SmoothMediaSource smoothMediaSource) {
        synchronized (this.mSwitchSmoothSourceLocker) {
            if (smoothMediaSource == null) {
                DebugLog.e(getLogTag(), "switchSmoothSource is null");
                return;
            }
            smoothMediaSource.bind(this);
            String logTag = getLogTag();
            DebugLog.e(logTag, "switchSmoothSource key is:" + smoothMediaSource.getKey());
            int j0 = this.mMediaPlayer.j0(smoothMediaSource);
            if (j0 == 0) {
                this.mSourceSwitching = true;
                this.mSmoothSourcesRecord.put(Integer.valueOf(smoothMediaSource.getKey()), smoothMediaSource);
                this.mSwitchingSmoothSource = smoothMediaSource;
                this.mSourceSwitchingComplete = false;
                this.mSwitchingPrepared = false;
            } else {
                notifySwitchSmoothSourceFail(smoothMediaSource, WHAT_SMOOTHSOURCE_FAIL, j0);
            }
        }
    }

    public void switchVideoSource(String str, int i, int i2, int i3) throws IOException, IllegalArgumentException, IllegalStateException {
        this.mMediaPlayer.M1(str, i, i2, i3);
        this.mSourceSwitching = true;
        this.mSourceSwitchingComplete = false;
        this.mSwitchingPrepared = false;
        doReportSLPV();
    }
}
