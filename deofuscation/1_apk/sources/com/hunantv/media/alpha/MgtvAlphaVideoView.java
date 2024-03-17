package com.hunantv.media.alpha;

import a.a.a.a.n.a;
import a.a.a.a.p.c;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hunantv.media.alpha.AlphaRenderer;
import com.hunantv.media.alpha.MgtvAlphaAbstractVideoView;
import com.hunantv.media.config.NetPlayConfig;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.media.drm.MgtvDrmParams;
import com.hunantv.media.global.Constants;
import com.hunantv.media.p2p.IP2pTask;
import com.hunantv.media.player.IMgtvRenderView;
import com.hunantv.media.player.MgtvMediaPlayer;
import com.hunantv.media.player.MgtvPlayerDataSource;
import com.hunantv.media.player.MgtvPlayerListener;
import com.hunantv.media.player.loader.ImgoLibLoader;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.player.statistic.FlowDataStatistic;
import com.hunantv.media.player.subtitle.SubtitleSource;
import com.hunantv.media.player.utils.StringUtil;
import com.hunantv.media.player.utils.ThreadUtil;
import com.hunantv.media.recoder.GifRecorder;
import com.hunantv.media.report.ReportParams;
import com.hunantv.media.utils.MemoryUtil;
import com.hunantv.media.widget.ISubtitle;
import com.hunantv.media.widget.IVideoView;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.text.NumberFormat;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgtvAlphaVideoView extends MgtvAlphaAbstractVideoView {
    private static final int GL_CONTEXT_VERSION = 2;
    private static final String LOGMSG_PLAYER_CALLBACK = "VideoViewCallBack";
    public static final int MGTV_RENDER_NONE = 0;
    public static final int MGTV_RENDER_SURFACE_VIEW = 1;
    public static final int MGTV_RENDER_TEXTURE_VIEW = 2;
    private int fromBottom;
    private int fromLeft;
    private int fromRight;
    private int fromTop;
    private boolean isStretchScreen;
    private boolean mAccurateSeekEnable;
    private MgtvMediaPlayer.AddrinfoType mAddrInfoType;
    private int mAddrInfoTypeInt;
    private int mAspectRatio;
    private boolean mBackJavaDns;
    private int mBufferTimeoutMs;
    private MgtvPlayerListener.OnBufferingTimeoutListener mBufferingTimeoutListener;
    private MgtvPlayerListener.OnBufferingUpdateListener mBufferingUpdateListener;
    private boolean mCacheEnable;
    private String mCacheM3u8Path;
    private String[] mCacheTsPaths;
    private MgtvPlayerListener.OnCompletionListener mCompletionListener;
    private int mCurrentState;
    private int mDataCacheSizeKB;
    private boolean mEnableCoreStartPauseListen;
    private boolean mEnableDnsNoNetStrategy;
    private boolean mEnableHttpDnsRetry;
    private boolean mEnableJavaIPCache;
    private boolean mEnableLiveMode;
    private boolean mEnableMgtvMediaCodec;
    private boolean mEnableOpengl;
    private boolean mEnableP2pHttpDns;
    private boolean mEnableTsSkipError;
    private int mEnhanceQualityType;
    private MgtvPlayerListener.OnErrorListener mErrorListener;
    private String mErrorMsg;
    private FlowDataStatistic mFlowDataStatistic;
    private boolean mForceDecodeMode;
    private int mFromSurfaceDestroyPlayPosition;
    private boolean mFromSurfaceDestroyToPlay;
    private GifRecorder mGifRecorder;
    private boolean mHasSurfaceHolderDestroy;
    private int mHlsMD5CheckValue;
    private MgtvPlayerListener.OnInfoListener mInfoListener;
    private MgtvPlayerListener.OnInfoStringListener mInfoStringListener;
    private boolean mIsLive;
    private boolean mIsLiveConfig;
    private boolean mIsScreenOnWhilePlaying;
    private boolean mIsSecure;
    private a.d mJavaDnsType;
    private boolean mLastFrameRecovery;
    private volatile boolean mLastSurfaceDestroy;
    private float mLeftVolume;
    private int mLiveStartIndex;
    private MgtvPlayerListener.OnLoadDataListener mLoadDataListener;
    private int mLoadMaxRetryTime;
    private boolean mLogCallBackOpen;
    private boolean mMgtvMediaPlayerHardwareMode;
    private boolean mNativeDnsAsyncEnable;
    private long mNonSurfaceHolderPVTimestamp;
    private IVideoView.OnBufferingUpdateListener mOnBufferringUpdateListener;
    private IVideoView.OnChangeSourceListener mOnChangeSourceListener;
    private IVideoView.OnCompletionListener mOnCompletionListener;
    private IVideoView.OnErrorListener mOnErrorListener;
    private IVideoView.OnInfoListener mOnInfoListener;
    private IVideoView.OnLoadDataListener mOnLoadDataListener;
    private IVideoView.OnPauseListener mOnPauseListener;
    private IVideoView.OnPreparedListener mOnPreparedListener;
    private IVideoView.OnRecordListener mOnRecordListener;
    private IVideoView.OnSeekCompleteListener mOnSeekCompleteListener;
    private IVideoView.OnStartListener mOnStartListener;
    private IVideoView.OnUpdateStatusListener mOnUpdateStatusListener;
    private IVideoView.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private MgtvPlayerListener.OnWarningListener mOnWarningListener;
    private boolean mOpenAddrDefaultConfig;
    private boolean mOpenVideoWhenSurfaceCreate;
    private MgtvPlayerListener.OnPauseListener mPauseListener;
    private float mPlaySpeed;
    private MgtvPlayerListener.OnWarningListener mPlayerWarning;
    public MgtvPlayerListener.OnPreparedListener mPreparedListener;
    private int mReadDataSourceTypeConfig;
    private boolean mRebindTexture;
    private String mRecordFilePath;
    private MgtvPlayerListener.OnRecordVideoListener mRecordVideoListener;
    private boolean mReleasedByPauseLoadData;
    private IVideoView.RenderFilter mRenderFilter;
    private int mRenderType;
    private int mRenderViewType;
    private float mRightVolume;
    private MgtvPlayerListener.OnSeekCompleteListener mSeekCompleteListener;
    private int mSeekWhenPrepared;
    public MgtvPlayerListener.OnVideoSizeChangedListener mSizeChangedListener;
    private MgtvMediaPlayer.SkipLoopFilterType mSkipLoopFilterType;
    private long mStartLeaveTimestamp;
    private MgtvPlayerListener.OnStartListener mStartListener;
    private int mStartPosMs;
    private int mStreamKey;
    private Surface mSurface;
    private int mSurfaceHeight;
    private IVideoView.SurfaceHolderListener mSurfaceHolderListener;
    private int mSurfaceWidth;
    private MgtvPlayerListener.OnSwitchSourceListener mSwitchSourceListener;
    private int mTargetState;
    private AlphaRenderer mTransRender;
    private boolean mTsNotSkip;
    private boolean mUseSystemPlayer;
    private boolean mUserEnableCoreStartPauseListen;
    private int mVideoHeight;
    private int mVideoRotationDegree;
    private int mVideoWidth;
    private int mWeakBufferTimeoutMs;
    private int mWeakNetSpeed;
    private DisplayMetrics metrics;
    private int originalVideoHeight;
    private int originalVideoWidth;
    private boolean shouldGetVideoParams;

    /* renamed from: com.hunantv.media.alpha.MgtvAlphaVideoView$18  reason: invalid class name */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static /* synthetic */ class AnonymousClass18 {
        public static final /* synthetic */ int[] $SwitchMap$com$hunantv$media$widget$IVideoView$RenderFilter;

        static {
            int[] iArr = new int[IVideoView.RenderFilter.values().length];
            $SwitchMap$com$hunantv$media$widget$IVideoView$RenderFilter = iArr;
            try {
                iArr[IVideoView.RenderFilter.UNSHARP_EDGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$hunantv$media$widget$IVideoView$RenderFilter[IVideoView.RenderFilter.UNSHARP_EDGE_COMPARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$hunantv$media$widget$IVideoView$RenderFilter[IVideoView.RenderFilter.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum ResetResult {
        NONE,
        RESET_OK,
        RESET_ERR
    }

    public MgtvAlphaVideoView(Context context) {
        super(context);
        this.mSurface = null;
        this.mLastSurfaceDestroy = true;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mMgtvMediaPlayerHardwareMode = true;
        this.mForceDecodeMode = false;
        this.mFromSurfaceDestroyToPlay = false;
        this.mFromSurfaceDestroyPlayPosition = 0;
        this.mErrorMsg = "";
        this.mHasSurfaceHolderDestroy = false;
        this.mRenderViewType = 1;
        this.mLogCallBackOpen = true;
        this.mStreamKey = -1;
        this.mIsLive = false;
        this.mUseSystemPlayer = false;
        this.mAddrInfoType = MgtvMediaPlayer.AddrinfoType.TYPE_ADDRINFO_DEFAULT;
        this.mAddrInfoTypeInt = 0;
        this.mOpenAddrDefaultConfig = true;
        this.mJavaDnsType = a.d.a;
        this.mNativeDnsAsyncEnable = true;
        this.mBackJavaDns = false;
        this.mEnableHttpDnsRetry = false;
        this.mEnableDnsNoNetStrategy = true;
        this.mEnableP2pHttpDns = false;
        this.mHlsMD5CheckValue = 0;
        this.mEnableMgtvMediaCodec = false;
        this.mEnableJavaIPCache = false;
        this.mLastFrameRecovery = true;
        this.mWeakNetSpeed = 0;
        this.mWeakBufferTimeoutMs = 0;
        this.mTsNotSkip = false;
        this.mLoadMaxRetryTime = 0;
        this.mLeftVolume = -1.0f;
        this.mRightVolume = -1.0f;
        this.mUserEnableCoreStartPauseListen = false;
        this.mEnableCoreStartPauseListen = false;
        this.mIsScreenOnWhilePlaying = true;
        this.mPlaySpeed = 1.0f;
        this.mLiveStartIndex = 0;
        this.mIsSecure = false;
        this.mAspectRatio = -1;
        this.mRenderFilter = IVideoView.RenderFilter.NORMAL;
        this.mIsLiveConfig = false;
        this.mEnableLiveMode = false;
        this.mReadDataSourceTypeConfig = 0;
        this.mStartPosMs = 0;
        this.mFlowDataStatistic = new FlowDataStatistic();
        this.mSkipLoopFilterType = MgtvMediaPlayer.SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mSizeChangedListener = new MgtvPlayerListener.OnVideoSizeChangedListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i, int i2) {
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView.originalVideoWidth = mgtvAlphaVideoView.mVideoWidth = mgtvAlphaVideoView.getVideoWidth();
                MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView2.originalVideoHeight = mgtvAlphaVideoView2.mVideoHeight = mgtvAlphaVideoView2.mMediaPlayer.getVideoHeight();
                if (MgtvAlphaVideoView.this.mVideoWidth != 0 && MgtvAlphaVideoView.this.mVideoHeight != 0) {
                    MgtvAlphaVideoView mgtvAlphaVideoView3 = MgtvAlphaVideoView.this;
                    IAlphaRenderView iAlphaRenderView = mgtvAlphaVideoView3.mGLView;
                    if (iAlphaRenderView != null) {
                        iAlphaRenderView.setVideoSize(mgtvAlphaVideoView3.mVideoWidth, MgtvAlphaVideoView.this.mVideoHeight);
                    }
                    MgtvAlphaVideoView.this.requestLayout();
                }
                if (MgtvAlphaVideoView.this.mOnVideoSizeChangedListener != null) {
                    MgtvAlphaVideoView.this.mOnVideoSizeChangedListener.onVideoSizeChanged(i, i2);
                }
            }
        };
        this.mPreparedListener = new MgtvPlayerListener.OnPreparedListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.4
            /* JADX WARN: Code restructure failed: missing block: B:14:0x0092, code lost:
                if (r4.this$0.mTargetState == 3) goto L14;
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x009b, code lost:
                if (r4.this$0.mTargetState == 3) goto L14;
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x009d, code lost:
                r4.this$0.start();
             */
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPreparedListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPrepared() {
                /*
                    r4 = this;
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    r1 = 2
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$800(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r1 = r0.getVideoWidth()
                    int r1 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$402(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$302(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoHeight()
                    int r1 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$602(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$502(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r0)
                    r1 = 3
                    if (r0 == 0) goto L95
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r0)
                    if (r0 == 0) goto L95
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "video size: "
                    r0.append(r2)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r2)
                    r0.append(r2)
                    java.lang.String r2 = "/"
                    r0.append(r2)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r2)
                    r0.append(r2)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r2 = "@@@@"
                    com.hunantv.media.player.pragma.DebugLog.i(r2, r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.alpha.IAlphaRenderView r2 = r0.mGLView
                    if (r2 == 0) goto L70
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r3 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r3 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r3)
                    r2.setVideoSize(r0, r3)
                L70:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$900(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r2)
                    if (r0 != r2) goto La2
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1000(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r2)
                    if (r0 != r2) goto La2
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1100(r0)
                    if (r0 != r1) goto La2
                    goto L9d
                L95:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1100(r0)
                    if (r0 != r1) goto La2
                L9d:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    r0.start()
                La2:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1200(r0)
                    if (r0 == 0) goto Lb3
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1200(r0)
                    r0.onPrepared()
                Lb3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.alpha.MgtvAlphaVideoView.AnonymousClass4.onPrepared():void");
            }
        };
        this.mCompletionListener = new MgtvPlayerListener.OnCompletionListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.5
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnCompletionListener
            public void onCompletion(int i, int i2) {
                if (i != 0) {
                    MgtvAlphaVideoView.this.stopInner();
                }
                MgtvAlphaVideoView.this.changeCurrentState(5);
                MgtvAlphaVideoView.this.mTargetState = 5;
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "-------------on onCompletion what:" + i + ",extra:" + i2);
                if (MgtvAlphaVideoView.this.mOnCompletionListener != null) {
                    MgtvAlphaVideoView.this.mOnCompletionListener.onCompletion(i, i2);
                }
            }
        };
        this.mInfoListener = new MgtvPlayerListener.OnInfoListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.6
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnInfoListener
            public boolean onInfo(int i, int i2) {
                String logTag;
                StringBuilder sb;
                String str;
                String str2;
                StringBuilder sb2;
                String str3;
                if (i != 1) {
                    if (i == 2810) {
                        logTag = MgtvAlphaVideoView.this.getLogTag();
                        sb = new StringBuilder();
                        str = "video fps is ";
                    } else if (i == 2820) {
                        logTag = MgtvAlphaVideoView.this.getLogTag();
                        switch (i2) {
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_OPEN_INPUT /* 82001 */:
                                str2 = "prepare av data: open input steam";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_FIND_STREAM_INFO /* 82002 */:
                                str2 = "prepare av data: find steam info";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_COMPONENT_OPEN /* 82003 */:
                                str2 = "prepare av data: av stream component open";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_VIDEO_DECODED_START /* 82004 */:
                                str2 = "prepare av data: video decoded start";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_AUDIO_DECODED_START /* 82005 */:
                                str2 = "prepare av data: audio decoded start";
                                break;
                            default:
                                sb = new StringBuilder();
                                str = "prepare av data: ";
                                break;
                        }
                        DebugLog.w(logTag, str2);
                    } else if (i == 2830) {
                        String logTag2 = MgtvAlphaVideoView.this.getLogTag();
                        DebugLog.i(logTag2, "MEDIA_INFO_PLAYBACK_STATE_CHANGED:" + i2);
                        if (MgtvAlphaVideoView.this.mOnUpdateStatusListener != null) {
                            MgtvAlphaVideoView.this.mOnUpdateStatusListener.onUpdateStatus();
                        }
                    } else if (i == 10001) {
                        String logTag3 = MgtvAlphaVideoView.this.getLogTag();
                        DebugLog.w(logTag3, "video rotation changed,extra(degree) is " + i2);
                        MgtvAlphaVideoView.this.mVideoRotationDegree = i2;
                    } else if (i == 200001) {
                        MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                        if (i2 == 1) {
                            mgtvAlphaVideoView.mMgtvMediaPlayerHardwareMode = false;
                        } else {
                            mgtvAlphaVideoView.mMgtvMediaPlayerHardwareMode = true;
                        }
                        MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                        mgtvAlphaVideoView2.convertRender(mgtvAlphaVideoView2.mRenderViewType);
                    } else if (i == 3) {
                        DebugLog.w(MgtvAlphaVideoView.this.getLogTag(), "video decode succeeded, start rendering");
                        MgtvAlphaVideoView.this.onVideoRenderStart();
                        if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                            MgtvAlphaVideoView.this.mOnInfoListener.onInfo(900, i2);
                        }
                        return true;
                    } else if (i == 4) {
                        DebugLog.w(MgtvAlphaVideoView.this.getLogTag(), "audio decode succeeded, start rendering");
                        if (MgtvAlphaVideoView.this.isOnlyAudioMode()) {
                            if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                                MgtvAlphaVideoView.this.mOnInfoListener.onInfo(900, i2);
                            }
                            return true;
                        }
                    } else if (i != 5) {
                        if (i == 6) {
                            if (i2 == 0) {
                                MgtvAlphaVideoView.this.mMgtvMediaPlayerHardwareMode = false;
                            } else if (i2 == 1) {
                                MgtvAlphaVideoView.this.mMgtvMediaPlayerHardwareMode = true;
                            }
                            logTag = MgtvAlphaVideoView.this.getLogTag();
                            sb = new StringBuilder();
                            str = "video decoder open,extra is ";
                        } else if (i != 7) {
                            switch (i) {
                                case 700:
                                    String logTag4 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag4, "It's too complex for the decoder, extra is " + i2);
                                    i = 700;
                                    break;
                                case 701:
                                    String logTag5 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag5, "buffer start speed:" + MgtvAlphaVideoView.this.getDLSpeedFormat());
                                    i = 701;
                                    break;
                                case 702:
                                    String logTag6 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag6, "buffer end speed:" + MgtvAlphaVideoView.this.getDLSpeedFormat());
                                    i = 702;
                                    break;
                                default:
                                    switch (i) {
                                        case 800:
                                            String logTag7 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.e(logTag7, "Bad interleaving of media file, audio/video are not well-formed, extra is " + i2);
                                            i = 800;
                                            break;
                                        case 801:
                                            String logTag8 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.w(logTag8, "The stream not seekable status, extra is " + i2);
                                            i = 801;
                                            MgtvAlphaVideoView mgtvAlphaVideoView3 = MgtvAlphaVideoView.this;
                                            if (i2 == 1) {
                                                mgtvAlphaVideoView3.mIsLive = true;
                                                logTag = MgtvAlphaVideoView.this.getLogTag();
                                                str2 = "The stream is live stream,can not seekable ";
                                            } else {
                                                mgtvAlphaVideoView3.mIsLive = false;
                                                logTag = MgtvAlphaVideoView.this.getLogTag();
                                                str2 = "The stream is not live stream,can seekable ";
                                            }
                                            DebugLog.w(logTag, str2);
                                            break;
                                        case 802:
                                            String logTag9 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.w(logTag9, "A new set of metadata is available, extra is " + i2);
                                            i = 802;
                                            break;
                                        default:
                                            logTag = MgtvAlphaVideoView.this.getLogTag();
                                            switch (i) {
                                                case MgtvMediaPlayer.MEDIA_INFO_DATA_PROTOCOL /* 2803 */:
                                                    DebugLog.w(logTag, "data source type is " + i2);
                                                    MgtvAlphaVideoView mgtvAlphaVideoView4 = MgtvAlphaVideoView.this;
                                                    MgtvMediaPlayer mgtvMediaPlayer = mgtvAlphaVideoView4.mMediaPlayer;
                                                    if (mgtvMediaPlayer != null) {
                                                        mgtvAlphaVideoView4.mDataSourceType = mgtvMediaPlayer.getDataSourceType();
                                                        break;
                                                    }
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_ACCURATE_SEEK_COMPLETE /* 2804 */:
                                                    sb = new StringBuilder();
                                                    str = "accurate seek complete,time is ";
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_ACODEC_RECONFIGURE /* 2805 */:
                                                    sb = new StringBuilder();
                                                    str = "acodec reconfigure ret is ";
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_STREAM_TYPE /* 2806 */:
                                                    sb2 = new StringBuilder();
                                                    str3 = "stream format type is ";
                                                    sb2.append(str3);
                                                    sb2.append(i2);
                                                    DebugLog.d(logTag, sb2.toString());
                                                    break;
                                                default:
                                                    sb2 = new StringBuilder();
                                                    sb2.append("Unknown info code: ");
                                                    sb2.append(i);
                                                    str3 = ", extra is ";
                                                    sb2.append(str3);
                                                    sb2.append(i2);
                                                    DebugLog.d(logTag, sb2.toString());
                                                    break;
                                            }
                                    }
                            }
                        } else {
                            i = IVideoView.MEDIA_INFO_DOWNLOAD_SPEED;
                        }
                    }
                    sb.append(str);
                    sb.append(i2);
                    str2 = sb.toString();
                    DebugLog.w(logTag, str2);
                } else {
                    String logTag10 = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.w(logTag10, "Unknown info, extra is " + i2);
                    i = 1;
                }
                if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                    MgtvAlphaVideoView.this.mOnInfoListener.onInfo(i, i2);
                }
                return true;
            }
        };
        this.mInfoStringListener = new MgtvPlayerListener.OnInfoStringListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.7
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnInfoStringListener
            public boolean onInfo(int i, String str) {
                if (i == 2860) {
                    String logTag = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.i(logTag, "MEDIA_INFO_SEI_SYS_TIMESTAMP: " + str);
                    return false;
                }
                String logTag2 = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag2, "OnInfoStringListener what: " + i + ", extra is " + str);
                return false;
            }
        };
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.8
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i, int i2) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.w(logTag, "onError what:" + i + ",extra:" + i2);
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvAlphaVideoView.mMediaPlayer;
                if (mgtvMediaPlayer == null || i != 7000006) {
                    if (mgtvMediaPlayer != null && mgtvAlphaVideoView.mCurrentState != -1) {
                        MgtvAlphaVideoView.this.mMediaPlayer.stop();
                    }
                    MgtvAlphaVideoView.this.changeCurrentState(-1);
                    MgtvAlphaVideoView.this.mTargetState = -1;
                } else {
                    mgtvAlphaVideoView.releaseNoStatus();
                    MgtvAlphaVideoView.this.changeCurrentState(0);
                    MgtvAlphaVideoView.this.mTargetState = 0;
                }
                MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView2.mCurrentUri = null;
                mgtvAlphaVideoView2.mProxyUri = null;
                return mgtvAlphaVideoView2.mOnErrorListener != null && MgtvAlphaVideoView.this.mOnErrorListener.onError(i, i2);
            }
        };
        this.mSeekCompleteListener = new MgtvPlayerListener.OnSeekCompleteListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.9
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSeekCompleteListener
            public void onSeekComplete(int i, int i2) {
                if (MgtvAlphaVideoView.this.mOnSeekCompleteListener != null) {
                    String logTag = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.i(logTag, "onSeekComplete seekTargetTime:" + i + ",errorCode:" + i2);
                    MgtvAlphaVideoView.this.mOnSeekCompleteListener.onSeekComplete();
                }
            }
        };
        this.mBufferingUpdateListener = new MgtvPlayerListener.OnBufferingUpdateListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.10
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingUpdateListener
            public void onBufferingUpdate(int i) {
                if (MgtvAlphaVideoView.this.mOnBufferringUpdateListener != null) {
                    MgtvAlphaVideoView.this.mOnBufferringUpdateListener.onBufferingUpdate(i);
                }
            }
        };
        this.mBufferingTimeoutListener = new MgtvPlayerListener.OnBufferingTimeoutListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.11
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingTimeoutListener
            public boolean onBufferingTimeout(int i, int i2) {
                MgtvMediaPlayer mgtvMediaPlayer = MgtvAlphaVideoView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.stop();
                }
                MgtvAlphaVideoView.this.changeCurrentState(-1);
                MgtvAlphaVideoView.this.mTargetState = -1;
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView.mCurrentUri = null;
                mgtvAlphaVideoView.mProxyUri = null;
                if (mgtvAlphaVideoView.mOnErrorListener == null || MgtvAlphaVideoView.this.mOnErrorListener.onError(i, i2)) {
                }
                return true;
            }
        };
        this.mSwitchSourceListener = new MgtvPlayerListener.OnSwitchSourceListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.12
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceComplete(String str, int i, int i2) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceComplete url:" + str + ",type:" + i + ",time:" + i2);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceSuccess(str, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceFailed(String str, int i, int i2) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceFailed url:" + str + ",what:" + i + ",extra:" + i2);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceFailed(str, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceInfo(String str, int i, int i2) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceInfo url:" + str + ",event:" + i + ",time:" + i2);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceInfo(str, i, i2);
                }
            }
        };
        this.mPlayerWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.13
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i, int i2) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "onTsSkip tsUrl:" + str);
                if (MgtvAlphaVideoView.this.mOnWarningListener != null) {
                    MgtvAlphaVideoView.this.mOnWarningListener.onTsSkip(str, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i, String str, String str2, Object obj) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "player render warning:" + i + ",extra:" + str + ",msg:" + str2);
                if (MgtvAlphaVideoView.this.mOnWarningListener != null) {
                    MgtvAlphaVideoView.this.mOnWarningListener.onWarning(i, str, str2, obj);
                }
            }
        };
        this.mGifRecorder = new GifRecorder();
        this.mStartListener = new MgtvPlayerListener.OnStartListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.14
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnStartListener
            public void onStart() {
                DebugLog.d(MgtvAlphaVideoView.this.getLogTag(), "mgtvcore onStart");
                if (MgtvAlphaVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvAlphaVideoView.this.callbackOnStart();
                }
            }
        };
        this.mPauseListener = new MgtvPlayerListener.OnPauseListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.15
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPauseListener
            public void onPause() {
                DebugLog.d(MgtvAlphaVideoView.this.getLogTag(), "mgtvcore onPause");
                if (MgtvAlphaVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvAlphaVideoView.this.callbackOnPause();
                }
            }
        };
        this.mRecordVideoListener = new MgtvPlayerListener.OnRecordVideoListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.16
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoErr(int i, int i2) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onRecordVideoErr what:" + i + ",extra:" + i2);
                if (MgtvAlphaVideoView.this.mOnRecordListener != null) {
                    MgtvAlphaVideoView.this.mOnRecordListener.onRecordError(i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoInfo(int i, int i2) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "onRecordVideoInfo what:" + i + ",extra:" + i2);
                if (MgtvAlphaVideoView.this.mOnRecordListener != null) {
                    if (i == 20) {
                        MgtvAlphaVideoView.this.mOnRecordListener.onRecordStart(MgtvAlphaVideoView.this.mRecordFilePath);
                    } else if (i == 30) {
                        MgtvAlphaVideoView.this.mOnRecordListener.onRecordStop();
                    }
                    MgtvAlphaVideoView.this.mOnRecordListener.onRecordInfo(i, i2);
                }
            }
        };
        this.mLoadDataListener = new MgtvPlayerListener.OnLoadDataListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.17
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onAfterLoadDataPaused() {
                if (MgtvAlphaVideoView.this.mOnLoadDataListener != null) {
                    MgtvAlphaVideoView.this.mOnLoadDataListener.onAfterLoadDataPaused();
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onBeforeLoadDataResume() {
                if (MgtvAlphaVideoView.this.mOnLoadDataListener != null) {
                    MgtvAlphaVideoView.this.mOnLoadDataListener.onBeforeLoadDataResume();
                }
            }
        };
        initVideoView(context);
    }

    public MgtvAlphaVideoView(Context context, int i) {
        super(context);
        this.mSurface = null;
        this.mLastSurfaceDestroy = true;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mMgtvMediaPlayerHardwareMode = true;
        this.mForceDecodeMode = false;
        this.mFromSurfaceDestroyToPlay = false;
        this.mFromSurfaceDestroyPlayPosition = 0;
        this.mErrorMsg = "";
        this.mHasSurfaceHolderDestroy = false;
        this.mRenderViewType = 1;
        this.mLogCallBackOpen = true;
        this.mStreamKey = -1;
        this.mIsLive = false;
        this.mUseSystemPlayer = false;
        this.mAddrInfoType = MgtvMediaPlayer.AddrinfoType.TYPE_ADDRINFO_DEFAULT;
        this.mAddrInfoTypeInt = 0;
        this.mOpenAddrDefaultConfig = true;
        this.mJavaDnsType = a.d.a;
        this.mNativeDnsAsyncEnable = true;
        this.mBackJavaDns = false;
        this.mEnableHttpDnsRetry = false;
        this.mEnableDnsNoNetStrategy = true;
        this.mEnableP2pHttpDns = false;
        this.mHlsMD5CheckValue = 0;
        this.mEnableMgtvMediaCodec = false;
        this.mEnableJavaIPCache = false;
        this.mLastFrameRecovery = true;
        this.mWeakNetSpeed = 0;
        this.mWeakBufferTimeoutMs = 0;
        this.mTsNotSkip = false;
        this.mLoadMaxRetryTime = 0;
        this.mLeftVolume = -1.0f;
        this.mRightVolume = -1.0f;
        this.mUserEnableCoreStartPauseListen = false;
        this.mEnableCoreStartPauseListen = false;
        this.mIsScreenOnWhilePlaying = true;
        this.mPlaySpeed = 1.0f;
        this.mLiveStartIndex = 0;
        this.mIsSecure = false;
        this.mAspectRatio = -1;
        this.mRenderFilter = IVideoView.RenderFilter.NORMAL;
        this.mIsLiveConfig = false;
        this.mEnableLiveMode = false;
        this.mReadDataSourceTypeConfig = 0;
        this.mStartPosMs = 0;
        this.mFlowDataStatistic = new FlowDataStatistic();
        this.mSkipLoopFilterType = MgtvMediaPlayer.SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mSizeChangedListener = new MgtvPlayerListener.OnVideoSizeChangedListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i2, int i22) {
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView.originalVideoWidth = mgtvAlphaVideoView.mVideoWidth = mgtvAlphaVideoView.getVideoWidth();
                MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView2.originalVideoHeight = mgtvAlphaVideoView2.mVideoHeight = mgtvAlphaVideoView2.mMediaPlayer.getVideoHeight();
                if (MgtvAlphaVideoView.this.mVideoWidth != 0 && MgtvAlphaVideoView.this.mVideoHeight != 0) {
                    MgtvAlphaVideoView mgtvAlphaVideoView3 = MgtvAlphaVideoView.this;
                    IAlphaRenderView iAlphaRenderView = mgtvAlphaVideoView3.mGLView;
                    if (iAlphaRenderView != null) {
                        iAlphaRenderView.setVideoSize(mgtvAlphaVideoView3.mVideoWidth, MgtvAlphaVideoView.this.mVideoHeight);
                    }
                    MgtvAlphaVideoView.this.requestLayout();
                }
                if (MgtvAlphaVideoView.this.mOnVideoSizeChangedListener != null) {
                    MgtvAlphaVideoView.this.mOnVideoSizeChangedListener.onVideoSizeChanged(i2, i22);
                }
            }
        };
        this.mPreparedListener = new MgtvPlayerListener.OnPreparedListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPreparedListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPrepared() {
                /*
                    r4 = this;
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    r1 = 2
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$800(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r1 = r0.getVideoWidth()
                    int r1 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$402(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$302(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoHeight()
                    int r1 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$602(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$502(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r0)
                    r1 = 3
                    if (r0 == 0) goto L95
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r0)
                    if (r0 == 0) goto L95
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "video size: "
                    r0.append(r2)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r2)
                    r0.append(r2)
                    java.lang.String r2 = "/"
                    r0.append(r2)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r2)
                    r0.append(r2)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r2 = "@@@@"
                    com.hunantv.media.player.pragma.DebugLog.i(r2, r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.alpha.IAlphaRenderView r2 = r0.mGLView
                    if (r2 == 0) goto L70
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r3 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r3 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r3)
                    r2.setVideoSize(r0, r3)
                L70:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$900(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r2)
                    if (r0 != r2) goto La2
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1000(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r2)
                    if (r0 != r2) goto La2
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1100(r0)
                    if (r0 != r1) goto La2
                    goto L9d
                L95:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1100(r0)
                    if (r0 != r1) goto La2
                L9d:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    r0.start()
                La2:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1200(r0)
                    if (r0 == 0) goto Lb3
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1200(r0)
                    r0.onPrepared()
                Lb3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.alpha.MgtvAlphaVideoView.AnonymousClass4.onPrepared():void");
            }
        };
        this.mCompletionListener = new MgtvPlayerListener.OnCompletionListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.5
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnCompletionListener
            public void onCompletion(int i2, int i22) {
                if (i2 != 0) {
                    MgtvAlphaVideoView.this.stopInner();
                }
                MgtvAlphaVideoView.this.changeCurrentState(5);
                MgtvAlphaVideoView.this.mTargetState = 5;
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "-------------on onCompletion what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnCompletionListener != null) {
                    MgtvAlphaVideoView.this.mOnCompletionListener.onCompletion(i2, i22);
                }
            }
        };
        this.mInfoListener = new MgtvPlayerListener.OnInfoListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.6
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnInfoListener
            public boolean onInfo(int i2, int i22) {
                String logTag;
                StringBuilder sb;
                String str;
                String str2;
                StringBuilder sb2;
                String str3;
                if (i2 != 1) {
                    if (i2 == 2810) {
                        logTag = MgtvAlphaVideoView.this.getLogTag();
                        sb = new StringBuilder();
                        str = "video fps is ";
                    } else if (i2 == 2820) {
                        logTag = MgtvAlphaVideoView.this.getLogTag();
                        switch (i22) {
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_OPEN_INPUT /* 82001 */:
                                str2 = "prepare av data: open input steam";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_FIND_STREAM_INFO /* 82002 */:
                                str2 = "prepare av data: find steam info";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_COMPONENT_OPEN /* 82003 */:
                                str2 = "prepare av data: av stream component open";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_VIDEO_DECODED_START /* 82004 */:
                                str2 = "prepare av data: video decoded start";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_AUDIO_DECODED_START /* 82005 */:
                                str2 = "prepare av data: audio decoded start";
                                break;
                            default:
                                sb = new StringBuilder();
                                str = "prepare av data: ";
                                break;
                        }
                        DebugLog.w(logTag, str2);
                    } else if (i2 == 2830) {
                        String logTag2 = MgtvAlphaVideoView.this.getLogTag();
                        DebugLog.i(logTag2, "MEDIA_INFO_PLAYBACK_STATE_CHANGED:" + i22);
                        if (MgtvAlphaVideoView.this.mOnUpdateStatusListener != null) {
                            MgtvAlphaVideoView.this.mOnUpdateStatusListener.onUpdateStatus();
                        }
                    } else if (i2 == 10001) {
                        String logTag3 = MgtvAlphaVideoView.this.getLogTag();
                        DebugLog.w(logTag3, "video rotation changed,extra(degree) is " + i22);
                        MgtvAlphaVideoView.this.mVideoRotationDegree = i22;
                    } else if (i2 == 200001) {
                        MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                        if (i22 == 1) {
                            mgtvAlphaVideoView.mMgtvMediaPlayerHardwareMode = false;
                        } else {
                            mgtvAlphaVideoView.mMgtvMediaPlayerHardwareMode = true;
                        }
                        MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                        mgtvAlphaVideoView2.convertRender(mgtvAlphaVideoView2.mRenderViewType);
                    } else if (i2 == 3) {
                        DebugLog.w(MgtvAlphaVideoView.this.getLogTag(), "video decode succeeded, start rendering");
                        MgtvAlphaVideoView.this.onVideoRenderStart();
                        if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                            MgtvAlphaVideoView.this.mOnInfoListener.onInfo(900, i22);
                        }
                        return true;
                    } else if (i2 == 4) {
                        DebugLog.w(MgtvAlphaVideoView.this.getLogTag(), "audio decode succeeded, start rendering");
                        if (MgtvAlphaVideoView.this.isOnlyAudioMode()) {
                            if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                                MgtvAlphaVideoView.this.mOnInfoListener.onInfo(900, i22);
                            }
                            return true;
                        }
                    } else if (i2 != 5) {
                        if (i2 == 6) {
                            if (i22 == 0) {
                                MgtvAlphaVideoView.this.mMgtvMediaPlayerHardwareMode = false;
                            } else if (i22 == 1) {
                                MgtvAlphaVideoView.this.mMgtvMediaPlayerHardwareMode = true;
                            }
                            logTag = MgtvAlphaVideoView.this.getLogTag();
                            sb = new StringBuilder();
                            str = "video decoder open,extra is ";
                        } else if (i2 != 7) {
                            switch (i2) {
                                case 700:
                                    String logTag4 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag4, "It's too complex for the decoder, extra is " + i22);
                                    i2 = 700;
                                    break;
                                case 701:
                                    String logTag5 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag5, "buffer start speed:" + MgtvAlphaVideoView.this.getDLSpeedFormat());
                                    i2 = 701;
                                    break;
                                case 702:
                                    String logTag6 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag6, "buffer end speed:" + MgtvAlphaVideoView.this.getDLSpeedFormat());
                                    i2 = 702;
                                    break;
                                default:
                                    switch (i2) {
                                        case 800:
                                            String logTag7 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.e(logTag7, "Bad interleaving of media file, audio/video are not well-formed, extra is " + i22);
                                            i2 = 800;
                                            break;
                                        case 801:
                                            String logTag8 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.w(logTag8, "The stream not seekable status, extra is " + i22);
                                            i2 = 801;
                                            MgtvAlphaVideoView mgtvAlphaVideoView3 = MgtvAlphaVideoView.this;
                                            if (i22 == 1) {
                                                mgtvAlphaVideoView3.mIsLive = true;
                                                logTag = MgtvAlphaVideoView.this.getLogTag();
                                                str2 = "The stream is live stream,can not seekable ";
                                            } else {
                                                mgtvAlphaVideoView3.mIsLive = false;
                                                logTag = MgtvAlphaVideoView.this.getLogTag();
                                                str2 = "The stream is not live stream,can seekable ";
                                            }
                                            DebugLog.w(logTag, str2);
                                            break;
                                        case 802:
                                            String logTag9 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.w(logTag9, "A new set of metadata is available, extra is " + i22);
                                            i2 = 802;
                                            break;
                                        default:
                                            logTag = MgtvAlphaVideoView.this.getLogTag();
                                            switch (i2) {
                                                case MgtvMediaPlayer.MEDIA_INFO_DATA_PROTOCOL /* 2803 */:
                                                    DebugLog.w(logTag, "data source type is " + i22);
                                                    MgtvAlphaVideoView mgtvAlphaVideoView4 = MgtvAlphaVideoView.this;
                                                    MgtvMediaPlayer mgtvMediaPlayer = mgtvAlphaVideoView4.mMediaPlayer;
                                                    if (mgtvMediaPlayer != null) {
                                                        mgtvAlphaVideoView4.mDataSourceType = mgtvMediaPlayer.getDataSourceType();
                                                        break;
                                                    }
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_ACCURATE_SEEK_COMPLETE /* 2804 */:
                                                    sb = new StringBuilder();
                                                    str = "accurate seek complete,time is ";
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_ACODEC_RECONFIGURE /* 2805 */:
                                                    sb = new StringBuilder();
                                                    str = "acodec reconfigure ret is ";
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_STREAM_TYPE /* 2806 */:
                                                    sb2 = new StringBuilder();
                                                    str3 = "stream format type is ";
                                                    sb2.append(str3);
                                                    sb2.append(i22);
                                                    DebugLog.d(logTag, sb2.toString());
                                                    break;
                                                default:
                                                    sb2 = new StringBuilder();
                                                    sb2.append("Unknown info code: ");
                                                    sb2.append(i2);
                                                    str3 = ", extra is ";
                                                    sb2.append(str3);
                                                    sb2.append(i22);
                                                    DebugLog.d(logTag, sb2.toString());
                                                    break;
                                            }
                                    }
                            }
                        } else {
                            i2 = IVideoView.MEDIA_INFO_DOWNLOAD_SPEED;
                        }
                    }
                    sb.append(str);
                    sb.append(i22);
                    str2 = sb.toString();
                    DebugLog.w(logTag, str2);
                } else {
                    String logTag10 = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.w(logTag10, "Unknown info, extra is " + i22);
                    i2 = 1;
                }
                if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                    MgtvAlphaVideoView.this.mOnInfoListener.onInfo(i2, i22);
                }
                return true;
            }
        };
        this.mInfoStringListener = new MgtvPlayerListener.OnInfoStringListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.7
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnInfoStringListener
            public boolean onInfo(int i2, String str) {
                if (i2 == 2860) {
                    String logTag = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.i(logTag, "MEDIA_INFO_SEI_SYS_TIMESTAMP: " + str);
                    return false;
                }
                String logTag2 = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag2, "OnInfoStringListener what: " + i2 + ", extra is " + str);
                return false;
            }
        };
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.8
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.w(logTag, "onError what:" + i2 + ",extra:" + i22);
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvAlphaVideoView.mMediaPlayer;
                if (mgtvMediaPlayer == null || i2 != 7000006) {
                    if (mgtvMediaPlayer != null && mgtvAlphaVideoView.mCurrentState != -1) {
                        MgtvAlphaVideoView.this.mMediaPlayer.stop();
                    }
                    MgtvAlphaVideoView.this.changeCurrentState(-1);
                    MgtvAlphaVideoView.this.mTargetState = -1;
                } else {
                    mgtvAlphaVideoView.releaseNoStatus();
                    MgtvAlphaVideoView.this.changeCurrentState(0);
                    MgtvAlphaVideoView.this.mTargetState = 0;
                }
                MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView2.mCurrentUri = null;
                mgtvAlphaVideoView2.mProxyUri = null;
                return mgtvAlphaVideoView2.mOnErrorListener != null && MgtvAlphaVideoView.this.mOnErrorListener.onError(i2, i22);
            }
        };
        this.mSeekCompleteListener = new MgtvPlayerListener.OnSeekCompleteListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.9
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSeekCompleteListener
            public void onSeekComplete(int i2, int i22) {
                if (MgtvAlphaVideoView.this.mOnSeekCompleteListener != null) {
                    String logTag = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.i(logTag, "onSeekComplete seekTargetTime:" + i2 + ",errorCode:" + i22);
                    MgtvAlphaVideoView.this.mOnSeekCompleteListener.onSeekComplete();
                }
            }
        };
        this.mBufferingUpdateListener = new MgtvPlayerListener.OnBufferingUpdateListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.10
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingUpdateListener
            public void onBufferingUpdate(int i2) {
                if (MgtvAlphaVideoView.this.mOnBufferringUpdateListener != null) {
                    MgtvAlphaVideoView.this.mOnBufferringUpdateListener.onBufferingUpdate(i2);
                }
            }
        };
        this.mBufferingTimeoutListener = new MgtvPlayerListener.OnBufferingTimeoutListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.11
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingTimeoutListener
            public boolean onBufferingTimeout(int i2, int i22) {
                MgtvMediaPlayer mgtvMediaPlayer = MgtvAlphaVideoView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.stop();
                }
                MgtvAlphaVideoView.this.changeCurrentState(-1);
                MgtvAlphaVideoView.this.mTargetState = -1;
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView.mCurrentUri = null;
                mgtvAlphaVideoView.mProxyUri = null;
                if (mgtvAlphaVideoView.mOnErrorListener == null || MgtvAlphaVideoView.this.mOnErrorListener.onError(i2, i22)) {
                }
                return true;
            }
        };
        this.mSwitchSourceListener = new MgtvPlayerListener.OnSwitchSourceListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.12
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceComplete(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceComplete url:" + str + ",type:" + i2 + ",time:" + i22);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceSuccess(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceFailed(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceFailed url:" + str + ",what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceFailed(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceInfo(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceInfo url:" + str + ",event:" + i2 + ",time:" + i22);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceInfo(str, i2, i22);
                }
            }
        };
        this.mPlayerWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.13
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "onTsSkip tsUrl:" + str);
                if (MgtvAlphaVideoView.this.mOnWarningListener != null) {
                    MgtvAlphaVideoView.this.mOnWarningListener.onTsSkip(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "player render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvAlphaVideoView.this.mOnWarningListener != null) {
                    MgtvAlphaVideoView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mGifRecorder = new GifRecorder();
        this.mStartListener = new MgtvPlayerListener.OnStartListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.14
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnStartListener
            public void onStart() {
                DebugLog.d(MgtvAlphaVideoView.this.getLogTag(), "mgtvcore onStart");
                if (MgtvAlphaVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvAlphaVideoView.this.callbackOnStart();
                }
            }
        };
        this.mPauseListener = new MgtvPlayerListener.OnPauseListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.15
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPauseListener
            public void onPause() {
                DebugLog.d(MgtvAlphaVideoView.this.getLogTag(), "mgtvcore onPause");
                if (MgtvAlphaVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvAlphaVideoView.this.callbackOnPause();
                }
            }
        };
        this.mRecordVideoListener = new MgtvPlayerListener.OnRecordVideoListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.16
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoErr(int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onRecordVideoErr what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnRecordListener != null) {
                    MgtvAlphaVideoView.this.mOnRecordListener.onRecordError(i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoInfo(int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "onRecordVideoInfo what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnRecordListener != null) {
                    if (i2 == 20) {
                        MgtvAlphaVideoView.this.mOnRecordListener.onRecordStart(MgtvAlphaVideoView.this.mRecordFilePath);
                    } else if (i2 == 30) {
                        MgtvAlphaVideoView.this.mOnRecordListener.onRecordStop();
                    }
                    MgtvAlphaVideoView.this.mOnRecordListener.onRecordInfo(i2, i22);
                }
            }
        };
        this.mLoadDataListener = new MgtvPlayerListener.OnLoadDataListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.17
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onAfterLoadDataPaused() {
                if (MgtvAlphaVideoView.this.mOnLoadDataListener != null) {
                    MgtvAlphaVideoView.this.mOnLoadDataListener.onAfterLoadDataPaused();
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onBeforeLoadDataResume() {
                if (MgtvAlphaVideoView.this.mOnLoadDataListener != null) {
                    MgtvAlphaVideoView.this.mOnLoadDataListener.onBeforeLoadDataResume();
                }
            }
        };
        initVideoView(context, i);
    }

    public MgtvAlphaVideoView(Context context, int i, boolean z) {
        super(context);
        this.mSurface = null;
        this.mLastSurfaceDestroy = true;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mMgtvMediaPlayerHardwareMode = true;
        this.mForceDecodeMode = false;
        this.mFromSurfaceDestroyToPlay = false;
        this.mFromSurfaceDestroyPlayPosition = 0;
        this.mErrorMsg = "";
        this.mHasSurfaceHolderDestroy = false;
        this.mRenderViewType = 1;
        this.mLogCallBackOpen = true;
        this.mStreamKey = -1;
        this.mIsLive = false;
        this.mUseSystemPlayer = false;
        this.mAddrInfoType = MgtvMediaPlayer.AddrinfoType.TYPE_ADDRINFO_DEFAULT;
        this.mAddrInfoTypeInt = 0;
        this.mOpenAddrDefaultConfig = true;
        this.mJavaDnsType = a.d.a;
        this.mNativeDnsAsyncEnable = true;
        this.mBackJavaDns = false;
        this.mEnableHttpDnsRetry = false;
        this.mEnableDnsNoNetStrategy = true;
        this.mEnableP2pHttpDns = false;
        this.mHlsMD5CheckValue = 0;
        this.mEnableMgtvMediaCodec = false;
        this.mEnableJavaIPCache = false;
        this.mLastFrameRecovery = true;
        this.mWeakNetSpeed = 0;
        this.mWeakBufferTimeoutMs = 0;
        this.mTsNotSkip = false;
        this.mLoadMaxRetryTime = 0;
        this.mLeftVolume = -1.0f;
        this.mRightVolume = -1.0f;
        this.mUserEnableCoreStartPauseListen = false;
        this.mEnableCoreStartPauseListen = false;
        this.mIsScreenOnWhilePlaying = true;
        this.mPlaySpeed = 1.0f;
        this.mLiveStartIndex = 0;
        this.mIsSecure = false;
        this.mAspectRatio = -1;
        this.mRenderFilter = IVideoView.RenderFilter.NORMAL;
        this.mIsLiveConfig = false;
        this.mEnableLiveMode = false;
        this.mReadDataSourceTypeConfig = 0;
        this.mStartPosMs = 0;
        this.mFlowDataStatistic = new FlowDataStatistic();
        this.mSkipLoopFilterType = MgtvMediaPlayer.SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mSizeChangedListener = new MgtvPlayerListener.OnVideoSizeChangedListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i2, int i22) {
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView.originalVideoWidth = mgtvAlphaVideoView.mVideoWidth = mgtvAlphaVideoView.getVideoWidth();
                MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView2.originalVideoHeight = mgtvAlphaVideoView2.mVideoHeight = mgtvAlphaVideoView2.mMediaPlayer.getVideoHeight();
                if (MgtvAlphaVideoView.this.mVideoWidth != 0 && MgtvAlphaVideoView.this.mVideoHeight != 0) {
                    MgtvAlphaVideoView mgtvAlphaVideoView3 = MgtvAlphaVideoView.this;
                    IAlphaRenderView iAlphaRenderView = mgtvAlphaVideoView3.mGLView;
                    if (iAlphaRenderView != null) {
                        iAlphaRenderView.setVideoSize(mgtvAlphaVideoView3.mVideoWidth, MgtvAlphaVideoView.this.mVideoHeight);
                    }
                    MgtvAlphaVideoView.this.requestLayout();
                }
                if (MgtvAlphaVideoView.this.mOnVideoSizeChangedListener != null) {
                    MgtvAlphaVideoView.this.mOnVideoSizeChangedListener.onVideoSizeChanged(i2, i22);
                }
            }
        };
        this.mPreparedListener = new MgtvPlayerListener.OnPreparedListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPreparedListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPrepared() {
                /*
                    r4 = this;
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    r1 = 2
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$800(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r1 = r0.getVideoWidth()
                    int r1 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$402(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$302(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoHeight()
                    int r1 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$602(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$502(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r0)
                    r1 = 3
                    if (r0 == 0) goto L95
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r0)
                    if (r0 == 0) goto L95
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "video size: "
                    r0.append(r2)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r2)
                    r0.append(r2)
                    java.lang.String r2 = "/"
                    r0.append(r2)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r2)
                    r0.append(r2)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r2 = "@@@@"
                    com.hunantv.media.player.pragma.DebugLog.i(r2, r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.alpha.IAlphaRenderView r2 = r0.mGLView
                    if (r2 == 0) goto L70
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r3 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r3 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r3)
                    r2.setVideoSize(r0, r3)
                L70:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$900(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r2)
                    if (r0 != r2) goto La2
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1000(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r2)
                    if (r0 != r2) goto La2
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1100(r0)
                    if (r0 != r1) goto La2
                    goto L9d
                L95:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1100(r0)
                    if (r0 != r1) goto La2
                L9d:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    r0.start()
                La2:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1200(r0)
                    if (r0 == 0) goto Lb3
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1200(r0)
                    r0.onPrepared()
                Lb3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.alpha.MgtvAlphaVideoView.AnonymousClass4.onPrepared():void");
            }
        };
        this.mCompletionListener = new MgtvPlayerListener.OnCompletionListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.5
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnCompletionListener
            public void onCompletion(int i2, int i22) {
                if (i2 != 0) {
                    MgtvAlphaVideoView.this.stopInner();
                }
                MgtvAlphaVideoView.this.changeCurrentState(5);
                MgtvAlphaVideoView.this.mTargetState = 5;
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "-------------on onCompletion what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnCompletionListener != null) {
                    MgtvAlphaVideoView.this.mOnCompletionListener.onCompletion(i2, i22);
                }
            }
        };
        this.mInfoListener = new MgtvPlayerListener.OnInfoListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.6
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnInfoListener
            public boolean onInfo(int i2, int i22) {
                String logTag;
                StringBuilder sb;
                String str;
                String str2;
                StringBuilder sb2;
                String str3;
                if (i2 != 1) {
                    if (i2 == 2810) {
                        logTag = MgtvAlphaVideoView.this.getLogTag();
                        sb = new StringBuilder();
                        str = "video fps is ";
                    } else if (i2 == 2820) {
                        logTag = MgtvAlphaVideoView.this.getLogTag();
                        switch (i22) {
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_OPEN_INPUT /* 82001 */:
                                str2 = "prepare av data: open input steam";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_FIND_STREAM_INFO /* 82002 */:
                                str2 = "prepare av data: find steam info";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_COMPONENT_OPEN /* 82003 */:
                                str2 = "prepare av data: av stream component open";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_VIDEO_DECODED_START /* 82004 */:
                                str2 = "prepare av data: video decoded start";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_AUDIO_DECODED_START /* 82005 */:
                                str2 = "prepare av data: audio decoded start";
                                break;
                            default:
                                sb = new StringBuilder();
                                str = "prepare av data: ";
                                break;
                        }
                        DebugLog.w(logTag, str2);
                    } else if (i2 == 2830) {
                        String logTag2 = MgtvAlphaVideoView.this.getLogTag();
                        DebugLog.i(logTag2, "MEDIA_INFO_PLAYBACK_STATE_CHANGED:" + i22);
                        if (MgtvAlphaVideoView.this.mOnUpdateStatusListener != null) {
                            MgtvAlphaVideoView.this.mOnUpdateStatusListener.onUpdateStatus();
                        }
                    } else if (i2 == 10001) {
                        String logTag3 = MgtvAlphaVideoView.this.getLogTag();
                        DebugLog.w(logTag3, "video rotation changed,extra(degree) is " + i22);
                        MgtvAlphaVideoView.this.mVideoRotationDegree = i22;
                    } else if (i2 == 200001) {
                        MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                        if (i22 == 1) {
                            mgtvAlphaVideoView.mMgtvMediaPlayerHardwareMode = false;
                        } else {
                            mgtvAlphaVideoView.mMgtvMediaPlayerHardwareMode = true;
                        }
                        MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                        mgtvAlphaVideoView2.convertRender(mgtvAlphaVideoView2.mRenderViewType);
                    } else if (i2 == 3) {
                        DebugLog.w(MgtvAlphaVideoView.this.getLogTag(), "video decode succeeded, start rendering");
                        MgtvAlphaVideoView.this.onVideoRenderStart();
                        if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                            MgtvAlphaVideoView.this.mOnInfoListener.onInfo(900, i22);
                        }
                        return true;
                    } else if (i2 == 4) {
                        DebugLog.w(MgtvAlphaVideoView.this.getLogTag(), "audio decode succeeded, start rendering");
                        if (MgtvAlphaVideoView.this.isOnlyAudioMode()) {
                            if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                                MgtvAlphaVideoView.this.mOnInfoListener.onInfo(900, i22);
                            }
                            return true;
                        }
                    } else if (i2 != 5) {
                        if (i2 == 6) {
                            if (i22 == 0) {
                                MgtvAlphaVideoView.this.mMgtvMediaPlayerHardwareMode = false;
                            } else if (i22 == 1) {
                                MgtvAlphaVideoView.this.mMgtvMediaPlayerHardwareMode = true;
                            }
                            logTag = MgtvAlphaVideoView.this.getLogTag();
                            sb = new StringBuilder();
                            str = "video decoder open,extra is ";
                        } else if (i2 != 7) {
                            switch (i2) {
                                case 700:
                                    String logTag4 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag4, "It's too complex for the decoder, extra is " + i22);
                                    i2 = 700;
                                    break;
                                case 701:
                                    String logTag5 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag5, "buffer start speed:" + MgtvAlphaVideoView.this.getDLSpeedFormat());
                                    i2 = 701;
                                    break;
                                case 702:
                                    String logTag6 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag6, "buffer end speed:" + MgtvAlphaVideoView.this.getDLSpeedFormat());
                                    i2 = 702;
                                    break;
                                default:
                                    switch (i2) {
                                        case 800:
                                            String logTag7 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.e(logTag7, "Bad interleaving of media file, audio/video are not well-formed, extra is " + i22);
                                            i2 = 800;
                                            break;
                                        case 801:
                                            String logTag8 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.w(logTag8, "The stream not seekable status, extra is " + i22);
                                            i2 = 801;
                                            MgtvAlphaVideoView mgtvAlphaVideoView3 = MgtvAlphaVideoView.this;
                                            if (i22 == 1) {
                                                mgtvAlphaVideoView3.mIsLive = true;
                                                logTag = MgtvAlphaVideoView.this.getLogTag();
                                                str2 = "The stream is live stream,can not seekable ";
                                            } else {
                                                mgtvAlphaVideoView3.mIsLive = false;
                                                logTag = MgtvAlphaVideoView.this.getLogTag();
                                                str2 = "The stream is not live stream,can seekable ";
                                            }
                                            DebugLog.w(logTag, str2);
                                            break;
                                        case 802:
                                            String logTag9 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.w(logTag9, "A new set of metadata is available, extra is " + i22);
                                            i2 = 802;
                                            break;
                                        default:
                                            logTag = MgtvAlphaVideoView.this.getLogTag();
                                            switch (i2) {
                                                case MgtvMediaPlayer.MEDIA_INFO_DATA_PROTOCOL /* 2803 */:
                                                    DebugLog.w(logTag, "data source type is " + i22);
                                                    MgtvAlphaVideoView mgtvAlphaVideoView4 = MgtvAlphaVideoView.this;
                                                    MgtvMediaPlayer mgtvMediaPlayer = mgtvAlphaVideoView4.mMediaPlayer;
                                                    if (mgtvMediaPlayer != null) {
                                                        mgtvAlphaVideoView4.mDataSourceType = mgtvMediaPlayer.getDataSourceType();
                                                        break;
                                                    }
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_ACCURATE_SEEK_COMPLETE /* 2804 */:
                                                    sb = new StringBuilder();
                                                    str = "accurate seek complete,time is ";
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_ACODEC_RECONFIGURE /* 2805 */:
                                                    sb = new StringBuilder();
                                                    str = "acodec reconfigure ret is ";
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_STREAM_TYPE /* 2806 */:
                                                    sb2 = new StringBuilder();
                                                    str3 = "stream format type is ";
                                                    sb2.append(str3);
                                                    sb2.append(i22);
                                                    DebugLog.d(logTag, sb2.toString());
                                                    break;
                                                default:
                                                    sb2 = new StringBuilder();
                                                    sb2.append("Unknown info code: ");
                                                    sb2.append(i2);
                                                    str3 = ", extra is ";
                                                    sb2.append(str3);
                                                    sb2.append(i22);
                                                    DebugLog.d(logTag, sb2.toString());
                                                    break;
                                            }
                                    }
                            }
                        } else {
                            i2 = IVideoView.MEDIA_INFO_DOWNLOAD_SPEED;
                        }
                    }
                    sb.append(str);
                    sb.append(i22);
                    str2 = sb.toString();
                    DebugLog.w(logTag, str2);
                } else {
                    String logTag10 = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.w(logTag10, "Unknown info, extra is " + i22);
                    i2 = 1;
                }
                if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                    MgtvAlphaVideoView.this.mOnInfoListener.onInfo(i2, i22);
                }
                return true;
            }
        };
        this.mInfoStringListener = new MgtvPlayerListener.OnInfoStringListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.7
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnInfoStringListener
            public boolean onInfo(int i2, String str) {
                if (i2 == 2860) {
                    String logTag = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.i(logTag, "MEDIA_INFO_SEI_SYS_TIMESTAMP: " + str);
                    return false;
                }
                String logTag2 = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag2, "OnInfoStringListener what: " + i2 + ", extra is " + str);
                return false;
            }
        };
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.8
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.w(logTag, "onError what:" + i2 + ",extra:" + i22);
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvAlphaVideoView.mMediaPlayer;
                if (mgtvMediaPlayer == null || i2 != 7000006) {
                    if (mgtvMediaPlayer != null && mgtvAlphaVideoView.mCurrentState != -1) {
                        MgtvAlphaVideoView.this.mMediaPlayer.stop();
                    }
                    MgtvAlphaVideoView.this.changeCurrentState(-1);
                    MgtvAlphaVideoView.this.mTargetState = -1;
                } else {
                    mgtvAlphaVideoView.releaseNoStatus();
                    MgtvAlphaVideoView.this.changeCurrentState(0);
                    MgtvAlphaVideoView.this.mTargetState = 0;
                }
                MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView2.mCurrentUri = null;
                mgtvAlphaVideoView2.mProxyUri = null;
                return mgtvAlphaVideoView2.mOnErrorListener != null && MgtvAlphaVideoView.this.mOnErrorListener.onError(i2, i22);
            }
        };
        this.mSeekCompleteListener = new MgtvPlayerListener.OnSeekCompleteListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.9
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSeekCompleteListener
            public void onSeekComplete(int i2, int i22) {
                if (MgtvAlphaVideoView.this.mOnSeekCompleteListener != null) {
                    String logTag = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.i(logTag, "onSeekComplete seekTargetTime:" + i2 + ",errorCode:" + i22);
                    MgtvAlphaVideoView.this.mOnSeekCompleteListener.onSeekComplete();
                }
            }
        };
        this.mBufferingUpdateListener = new MgtvPlayerListener.OnBufferingUpdateListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.10
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingUpdateListener
            public void onBufferingUpdate(int i2) {
                if (MgtvAlphaVideoView.this.mOnBufferringUpdateListener != null) {
                    MgtvAlphaVideoView.this.mOnBufferringUpdateListener.onBufferingUpdate(i2);
                }
            }
        };
        this.mBufferingTimeoutListener = new MgtvPlayerListener.OnBufferingTimeoutListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.11
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingTimeoutListener
            public boolean onBufferingTimeout(int i2, int i22) {
                MgtvMediaPlayer mgtvMediaPlayer = MgtvAlphaVideoView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.stop();
                }
                MgtvAlphaVideoView.this.changeCurrentState(-1);
                MgtvAlphaVideoView.this.mTargetState = -1;
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView.mCurrentUri = null;
                mgtvAlphaVideoView.mProxyUri = null;
                if (mgtvAlphaVideoView.mOnErrorListener == null || MgtvAlphaVideoView.this.mOnErrorListener.onError(i2, i22)) {
                }
                return true;
            }
        };
        this.mSwitchSourceListener = new MgtvPlayerListener.OnSwitchSourceListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.12
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceComplete(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceComplete url:" + str + ",type:" + i2 + ",time:" + i22);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceSuccess(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceFailed(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceFailed url:" + str + ",what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceFailed(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceInfo(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceInfo url:" + str + ",event:" + i2 + ",time:" + i22);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceInfo(str, i2, i22);
                }
            }
        };
        this.mPlayerWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.13
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "onTsSkip tsUrl:" + str);
                if (MgtvAlphaVideoView.this.mOnWarningListener != null) {
                    MgtvAlphaVideoView.this.mOnWarningListener.onTsSkip(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "player render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvAlphaVideoView.this.mOnWarningListener != null) {
                    MgtvAlphaVideoView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mGifRecorder = new GifRecorder();
        this.mStartListener = new MgtvPlayerListener.OnStartListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.14
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnStartListener
            public void onStart() {
                DebugLog.d(MgtvAlphaVideoView.this.getLogTag(), "mgtvcore onStart");
                if (MgtvAlphaVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvAlphaVideoView.this.callbackOnStart();
                }
            }
        };
        this.mPauseListener = new MgtvPlayerListener.OnPauseListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.15
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPauseListener
            public void onPause() {
                DebugLog.d(MgtvAlphaVideoView.this.getLogTag(), "mgtvcore onPause");
                if (MgtvAlphaVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvAlphaVideoView.this.callbackOnPause();
                }
            }
        };
        this.mRecordVideoListener = new MgtvPlayerListener.OnRecordVideoListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.16
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoErr(int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onRecordVideoErr what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnRecordListener != null) {
                    MgtvAlphaVideoView.this.mOnRecordListener.onRecordError(i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoInfo(int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "onRecordVideoInfo what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnRecordListener != null) {
                    if (i2 == 20) {
                        MgtvAlphaVideoView.this.mOnRecordListener.onRecordStart(MgtvAlphaVideoView.this.mRecordFilePath);
                    } else if (i2 == 30) {
                        MgtvAlphaVideoView.this.mOnRecordListener.onRecordStop();
                    }
                    MgtvAlphaVideoView.this.mOnRecordListener.onRecordInfo(i2, i22);
                }
            }
        };
        this.mLoadDataListener = new MgtvPlayerListener.OnLoadDataListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.17
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onAfterLoadDataPaused() {
                if (MgtvAlphaVideoView.this.mOnLoadDataListener != null) {
                    MgtvAlphaVideoView.this.mOnLoadDataListener.onAfterLoadDataPaused();
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onBeforeLoadDataResume() {
                if (MgtvAlphaVideoView.this.mOnLoadDataListener != null) {
                    MgtvAlphaVideoView.this.mOnLoadDataListener.onBeforeLoadDataResume();
                }
            }
        };
        this.mEnableTexture = z;
        initVideoView(context, i);
    }

    public MgtvAlphaVideoView(Context context, int i, boolean z, boolean z2) {
        super(context);
        this.mSurface = null;
        this.mLastSurfaceDestroy = true;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mMgtvMediaPlayerHardwareMode = true;
        this.mForceDecodeMode = false;
        this.mFromSurfaceDestroyToPlay = false;
        this.mFromSurfaceDestroyPlayPosition = 0;
        this.mErrorMsg = "";
        this.mHasSurfaceHolderDestroy = false;
        this.mRenderViewType = 1;
        this.mLogCallBackOpen = true;
        this.mStreamKey = -1;
        this.mIsLive = false;
        this.mUseSystemPlayer = false;
        this.mAddrInfoType = MgtvMediaPlayer.AddrinfoType.TYPE_ADDRINFO_DEFAULT;
        this.mAddrInfoTypeInt = 0;
        this.mOpenAddrDefaultConfig = true;
        this.mJavaDnsType = a.d.a;
        this.mNativeDnsAsyncEnable = true;
        this.mBackJavaDns = false;
        this.mEnableHttpDnsRetry = false;
        this.mEnableDnsNoNetStrategy = true;
        this.mEnableP2pHttpDns = false;
        this.mHlsMD5CheckValue = 0;
        this.mEnableMgtvMediaCodec = false;
        this.mEnableJavaIPCache = false;
        this.mLastFrameRecovery = true;
        this.mWeakNetSpeed = 0;
        this.mWeakBufferTimeoutMs = 0;
        this.mTsNotSkip = false;
        this.mLoadMaxRetryTime = 0;
        this.mLeftVolume = -1.0f;
        this.mRightVolume = -1.0f;
        this.mUserEnableCoreStartPauseListen = false;
        this.mEnableCoreStartPauseListen = false;
        this.mIsScreenOnWhilePlaying = true;
        this.mPlaySpeed = 1.0f;
        this.mLiveStartIndex = 0;
        this.mIsSecure = false;
        this.mAspectRatio = -1;
        this.mRenderFilter = IVideoView.RenderFilter.NORMAL;
        this.mIsLiveConfig = false;
        this.mEnableLiveMode = false;
        this.mReadDataSourceTypeConfig = 0;
        this.mStartPosMs = 0;
        this.mFlowDataStatistic = new FlowDataStatistic();
        this.mSkipLoopFilterType = MgtvMediaPlayer.SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mSizeChangedListener = new MgtvPlayerListener.OnVideoSizeChangedListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i2, int i22) {
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView.originalVideoWidth = mgtvAlphaVideoView.mVideoWidth = mgtvAlphaVideoView.getVideoWidth();
                MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView2.originalVideoHeight = mgtvAlphaVideoView2.mVideoHeight = mgtvAlphaVideoView2.mMediaPlayer.getVideoHeight();
                if (MgtvAlphaVideoView.this.mVideoWidth != 0 && MgtvAlphaVideoView.this.mVideoHeight != 0) {
                    MgtvAlphaVideoView mgtvAlphaVideoView3 = MgtvAlphaVideoView.this;
                    IAlphaRenderView iAlphaRenderView = mgtvAlphaVideoView3.mGLView;
                    if (iAlphaRenderView != null) {
                        iAlphaRenderView.setVideoSize(mgtvAlphaVideoView3.mVideoWidth, MgtvAlphaVideoView.this.mVideoHeight);
                    }
                    MgtvAlphaVideoView.this.requestLayout();
                }
                if (MgtvAlphaVideoView.this.mOnVideoSizeChangedListener != null) {
                    MgtvAlphaVideoView.this.mOnVideoSizeChangedListener.onVideoSizeChanged(i2, i22);
                }
            }
        };
        this.mPreparedListener = new MgtvPlayerListener.OnPreparedListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPreparedListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPrepared() {
                /*
                    r4 = this;
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    r1 = 2
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$800(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r1 = r0.getVideoWidth()
                    int r1 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$402(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$302(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoHeight()
                    int r1 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$602(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$502(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r0)
                    r1 = 3
                    if (r0 == 0) goto L95
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r0)
                    if (r0 == 0) goto L95
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "video size: "
                    r0.append(r2)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r2)
                    r0.append(r2)
                    java.lang.String r2 = "/"
                    r0.append(r2)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r2)
                    r0.append(r2)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r2 = "@@@@"
                    com.hunantv.media.player.pragma.DebugLog.i(r2, r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.alpha.IAlphaRenderView r2 = r0.mGLView
                    if (r2 == 0) goto L70
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r3 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r3 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r3)
                    r2.setVideoSize(r0, r3)
                L70:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$900(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r2)
                    if (r0 != r2) goto La2
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1000(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r2)
                    if (r0 != r2) goto La2
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1100(r0)
                    if (r0 != r1) goto La2
                    goto L9d
                L95:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1100(r0)
                    if (r0 != r1) goto La2
                L9d:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    r0.start()
                La2:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1200(r0)
                    if (r0 == 0) goto Lb3
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1200(r0)
                    r0.onPrepared()
                Lb3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.alpha.MgtvAlphaVideoView.AnonymousClass4.onPrepared():void");
            }
        };
        this.mCompletionListener = new MgtvPlayerListener.OnCompletionListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.5
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnCompletionListener
            public void onCompletion(int i2, int i22) {
                if (i2 != 0) {
                    MgtvAlphaVideoView.this.stopInner();
                }
                MgtvAlphaVideoView.this.changeCurrentState(5);
                MgtvAlphaVideoView.this.mTargetState = 5;
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "-------------on onCompletion what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnCompletionListener != null) {
                    MgtvAlphaVideoView.this.mOnCompletionListener.onCompletion(i2, i22);
                }
            }
        };
        this.mInfoListener = new MgtvPlayerListener.OnInfoListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.6
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnInfoListener
            public boolean onInfo(int i2, int i22) {
                String logTag;
                StringBuilder sb;
                String str;
                String str2;
                StringBuilder sb2;
                String str3;
                if (i2 != 1) {
                    if (i2 == 2810) {
                        logTag = MgtvAlphaVideoView.this.getLogTag();
                        sb = new StringBuilder();
                        str = "video fps is ";
                    } else if (i2 == 2820) {
                        logTag = MgtvAlphaVideoView.this.getLogTag();
                        switch (i22) {
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_OPEN_INPUT /* 82001 */:
                                str2 = "prepare av data: open input steam";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_FIND_STREAM_INFO /* 82002 */:
                                str2 = "prepare av data: find steam info";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_COMPONENT_OPEN /* 82003 */:
                                str2 = "prepare av data: av stream component open";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_VIDEO_DECODED_START /* 82004 */:
                                str2 = "prepare av data: video decoded start";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_AUDIO_DECODED_START /* 82005 */:
                                str2 = "prepare av data: audio decoded start";
                                break;
                            default:
                                sb = new StringBuilder();
                                str = "prepare av data: ";
                                break;
                        }
                        DebugLog.w(logTag, str2);
                    } else if (i2 == 2830) {
                        String logTag2 = MgtvAlphaVideoView.this.getLogTag();
                        DebugLog.i(logTag2, "MEDIA_INFO_PLAYBACK_STATE_CHANGED:" + i22);
                        if (MgtvAlphaVideoView.this.mOnUpdateStatusListener != null) {
                            MgtvAlphaVideoView.this.mOnUpdateStatusListener.onUpdateStatus();
                        }
                    } else if (i2 == 10001) {
                        String logTag3 = MgtvAlphaVideoView.this.getLogTag();
                        DebugLog.w(logTag3, "video rotation changed,extra(degree) is " + i22);
                        MgtvAlphaVideoView.this.mVideoRotationDegree = i22;
                    } else if (i2 == 200001) {
                        MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                        if (i22 == 1) {
                            mgtvAlphaVideoView.mMgtvMediaPlayerHardwareMode = false;
                        } else {
                            mgtvAlphaVideoView.mMgtvMediaPlayerHardwareMode = true;
                        }
                        MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                        mgtvAlphaVideoView2.convertRender(mgtvAlphaVideoView2.mRenderViewType);
                    } else if (i2 == 3) {
                        DebugLog.w(MgtvAlphaVideoView.this.getLogTag(), "video decode succeeded, start rendering");
                        MgtvAlphaVideoView.this.onVideoRenderStart();
                        if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                            MgtvAlphaVideoView.this.mOnInfoListener.onInfo(900, i22);
                        }
                        return true;
                    } else if (i2 == 4) {
                        DebugLog.w(MgtvAlphaVideoView.this.getLogTag(), "audio decode succeeded, start rendering");
                        if (MgtvAlphaVideoView.this.isOnlyAudioMode()) {
                            if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                                MgtvAlphaVideoView.this.mOnInfoListener.onInfo(900, i22);
                            }
                            return true;
                        }
                    } else if (i2 != 5) {
                        if (i2 == 6) {
                            if (i22 == 0) {
                                MgtvAlphaVideoView.this.mMgtvMediaPlayerHardwareMode = false;
                            } else if (i22 == 1) {
                                MgtvAlphaVideoView.this.mMgtvMediaPlayerHardwareMode = true;
                            }
                            logTag = MgtvAlphaVideoView.this.getLogTag();
                            sb = new StringBuilder();
                            str = "video decoder open,extra is ";
                        } else if (i2 != 7) {
                            switch (i2) {
                                case 700:
                                    String logTag4 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag4, "It's too complex for the decoder, extra is " + i22);
                                    i2 = 700;
                                    break;
                                case 701:
                                    String logTag5 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag5, "buffer start speed:" + MgtvAlphaVideoView.this.getDLSpeedFormat());
                                    i2 = 701;
                                    break;
                                case 702:
                                    String logTag6 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag6, "buffer end speed:" + MgtvAlphaVideoView.this.getDLSpeedFormat());
                                    i2 = 702;
                                    break;
                                default:
                                    switch (i2) {
                                        case 800:
                                            String logTag7 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.e(logTag7, "Bad interleaving of media file, audio/video are not well-formed, extra is " + i22);
                                            i2 = 800;
                                            break;
                                        case 801:
                                            String logTag8 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.w(logTag8, "The stream not seekable status, extra is " + i22);
                                            i2 = 801;
                                            MgtvAlphaVideoView mgtvAlphaVideoView3 = MgtvAlphaVideoView.this;
                                            if (i22 == 1) {
                                                mgtvAlphaVideoView3.mIsLive = true;
                                                logTag = MgtvAlphaVideoView.this.getLogTag();
                                                str2 = "The stream is live stream,can not seekable ";
                                            } else {
                                                mgtvAlphaVideoView3.mIsLive = false;
                                                logTag = MgtvAlphaVideoView.this.getLogTag();
                                                str2 = "The stream is not live stream,can seekable ";
                                            }
                                            DebugLog.w(logTag, str2);
                                            break;
                                        case 802:
                                            String logTag9 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.w(logTag9, "A new set of metadata is available, extra is " + i22);
                                            i2 = 802;
                                            break;
                                        default:
                                            logTag = MgtvAlphaVideoView.this.getLogTag();
                                            switch (i2) {
                                                case MgtvMediaPlayer.MEDIA_INFO_DATA_PROTOCOL /* 2803 */:
                                                    DebugLog.w(logTag, "data source type is " + i22);
                                                    MgtvAlphaVideoView mgtvAlphaVideoView4 = MgtvAlphaVideoView.this;
                                                    MgtvMediaPlayer mgtvMediaPlayer = mgtvAlphaVideoView4.mMediaPlayer;
                                                    if (mgtvMediaPlayer != null) {
                                                        mgtvAlphaVideoView4.mDataSourceType = mgtvMediaPlayer.getDataSourceType();
                                                        break;
                                                    }
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_ACCURATE_SEEK_COMPLETE /* 2804 */:
                                                    sb = new StringBuilder();
                                                    str = "accurate seek complete,time is ";
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_ACODEC_RECONFIGURE /* 2805 */:
                                                    sb = new StringBuilder();
                                                    str = "acodec reconfigure ret is ";
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_STREAM_TYPE /* 2806 */:
                                                    sb2 = new StringBuilder();
                                                    str3 = "stream format type is ";
                                                    sb2.append(str3);
                                                    sb2.append(i22);
                                                    DebugLog.d(logTag, sb2.toString());
                                                    break;
                                                default:
                                                    sb2 = new StringBuilder();
                                                    sb2.append("Unknown info code: ");
                                                    sb2.append(i2);
                                                    str3 = ", extra is ";
                                                    sb2.append(str3);
                                                    sb2.append(i22);
                                                    DebugLog.d(logTag, sb2.toString());
                                                    break;
                                            }
                                    }
                            }
                        } else {
                            i2 = IVideoView.MEDIA_INFO_DOWNLOAD_SPEED;
                        }
                    }
                    sb.append(str);
                    sb.append(i22);
                    str2 = sb.toString();
                    DebugLog.w(logTag, str2);
                } else {
                    String logTag10 = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.w(logTag10, "Unknown info, extra is " + i22);
                    i2 = 1;
                }
                if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                    MgtvAlphaVideoView.this.mOnInfoListener.onInfo(i2, i22);
                }
                return true;
            }
        };
        this.mInfoStringListener = new MgtvPlayerListener.OnInfoStringListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.7
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnInfoStringListener
            public boolean onInfo(int i2, String str) {
                if (i2 == 2860) {
                    String logTag = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.i(logTag, "MEDIA_INFO_SEI_SYS_TIMESTAMP: " + str);
                    return false;
                }
                String logTag2 = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag2, "OnInfoStringListener what: " + i2 + ", extra is " + str);
                return false;
            }
        };
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.8
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.w(logTag, "onError what:" + i2 + ",extra:" + i22);
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvAlphaVideoView.mMediaPlayer;
                if (mgtvMediaPlayer == null || i2 != 7000006) {
                    if (mgtvMediaPlayer != null && mgtvAlphaVideoView.mCurrentState != -1) {
                        MgtvAlphaVideoView.this.mMediaPlayer.stop();
                    }
                    MgtvAlphaVideoView.this.changeCurrentState(-1);
                    MgtvAlphaVideoView.this.mTargetState = -1;
                } else {
                    mgtvAlphaVideoView.releaseNoStatus();
                    MgtvAlphaVideoView.this.changeCurrentState(0);
                    MgtvAlphaVideoView.this.mTargetState = 0;
                }
                MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView2.mCurrentUri = null;
                mgtvAlphaVideoView2.mProxyUri = null;
                return mgtvAlphaVideoView2.mOnErrorListener != null && MgtvAlphaVideoView.this.mOnErrorListener.onError(i2, i22);
            }
        };
        this.mSeekCompleteListener = new MgtvPlayerListener.OnSeekCompleteListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.9
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSeekCompleteListener
            public void onSeekComplete(int i2, int i22) {
                if (MgtvAlphaVideoView.this.mOnSeekCompleteListener != null) {
                    String logTag = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.i(logTag, "onSeekComplete seekTargetTime:" + i2 + ",errorCode:" + i22);
                    MgtvAlphaVideoView.this.mOnSeekCompleteListener.onSeekComplete();
                }
            }
        };
        this.mBufferingUpdateListener = new MgtvPlayerListener.OnBufferingUpdateListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.10
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingUpdateListener
            public void onBufferingUpdate(int i2) {
                if (MgtvAlphaVideoView.this.mOnBufferringUpdateListener != null) {
                    MgtvAlphaVideoView.this.mOnBufferringUpdateListener.onBufferingUpdate(i2);
                }
            }
        };
        this.mBufferingTimeoutListener = new MgtvPlayerListener.OnBufferingTimeoutListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.11
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingTimeoutListener
            public boolean onBufferingTimeout(int i2, int i22) {
                MgtvMediaPlayer mgtvMediaPlayer = MgtvAlphaVideoView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.stop();
                }
                MgtvAlphaVideoView.this.changeCurrentState(-1);
                MgtvAlphaVideoView.this.mTargetState = -1;
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView.mCurrentUri = null;
                mgtvAlphaVideoView.mProxyUri = null;
                if (mgtvAlphaVideoView.mOnErrorListener == null || MgtvAlphaVideoView.this.mOnErrorListener.onError(i2, i22)) {
                }
                return true;
            }
        };
        this.mSwitchSourceListener = new MgtvPlayerListener.OnSwitchSourceListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.12
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceComplete(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceComplete url:" + str + ",type:" + i2 + ",time:" + i22);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceSuccess(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceFailed(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceFailed url:" + str + ",what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceFailed(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceInfo(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceInfo url:" + str + ",event:" + i2 + ",time:" + i22);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceInfo(str, i2, i22);
                }
            }
        };
        this.mPlayerWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.13
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "onTsSkip tsUrl:" + str);
                if (MgtvAlphaVideoView.this.mOnWarningListener != null) {
                    MgtvAlphaVideoView.this.mOnWarningListener.onTsSkip(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "player render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvAlphaVideoView.this.mOnWarningListener != null) {
                    MgtvAlphaVideoView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mGifRecorder = new GifRecorder();
        this.mStartListener = new MgtvPlayerListener.OnStartListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.14
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnStartListener
            public void onStart() {
                DebugLog.d(MgtvAlphaVideoView.this.getLogTag(), "mgtvcore onStart");
                if (MgtvAlphaVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvAlphaVideoView.this.callbackOnStart();
                }
            }
        };
        this.mPauseListener = new MgtvPlayerListener.OnPauseListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.15
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPauseListener
            public void onPause() {
                DebugLog.d(MgtvAlphaVideoView.this.getLogTag(), "mgtvcore onPause");
                if (MgtvAlphaVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvAlphaVideoView.this.callbackOnPause();
                }
            }
        };
        this.mRecordVideoListener = new MgtvPlayerListener.OnRecordVideoListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.16
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoErr(int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onRecordVideoErr what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnRecordListener != null) {
                    MgtvAlphaVideoView.this.mOnRecordListener.onRecordError(i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoInfo(int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "onRecordVideoInfo what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnRecordListener != null) {
                    if (i2 == 20) {
                        MgtvAlphaVideoView.this.mOnRecordListener.onRecordStart(MgtvAlphaVideoView.this.mRecordFilePath);
                    } else if (i2 == 30) {
                        MgtvAlphaVideoView.this.mOnRecordListener.onRecordStop();
                    }
                    MgtvAlphaVideoView.this.mOnRecordListener.onRecordInfo(i2, i22);
                }
            }
        };
        this.mLoadDataListener = new MgtvPlayerListener.OnLoadDataListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.17
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onAfterLoadDataPaused() {
                if (MgtvAlphaVideoView.this.mOnLoadDataListener != null) {
                    MgtvAlphaVideoView.this.mOnLoadDataListener.onAfterLoadDataPaused();
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onBeforeLoadDataResume() {
                if (MgtvAlphaVideoView.this.mOnLoadDataListener != null) {
                    MgtvAlphaVideoView.this.mOnLoadDataListener.onBeforeLoadDataResume();
                }
            }
        };
        this.mEnableTexture = z;
        this.mEnableOpengl = z2;
        initVideoView(context, i);
    }

    public MgtvAlphaVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSurface = null;
        this.mLastSurfaceDestroy = true;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mMgtvMediaPlayerHardwareMode = true;
        this.mForceDecodeMode = false;
        this.mFromSurfaceDestroyToPlay = false;
        this.mFromSurfaceDestroyPlayPosition = 0;
        this.mErrorMsg = "";
        this.mHasSurfaceHolderDestroy = false;
        this.mRenderViewType = 1;
        this.mLogCallBackOpen = true;
        this.mStreamKey = -1;
        this.mIsLive = false;
        this.mUseSystemPlayer = false;
        this.mAddrInfoType = MgtvMediaPlayer.AddrinfoType.TYPE_ADDRINFO_DEFAULT;
        this.mAddrInfoTypeInt = 0;
        this.mOpenAddrDefaultConfig = true;
        this.mJavaDnsType = a.d.a;
        this.mNativeDnsAsyncEnable = true;
        this.mBackJavaDns = false;
        this.mEnableHttpDnsRetry = false;
        this.mEnableDnsNoNetStrategy = true;
        this.mEnableP2pHttpDns = false;
        this.mHlsMD5CheckValue = 0;
        this.mEnableMgtvMediaCodec = false;
        this.mEnableJavaIPCache = false;
        this.mLastFrameRecovery = true;
        this.mWeakNetSpeed = 0;
        this.mWeakBufferTimeoutMs = 0;
        this.mTsNotSkip = false;
        this.mLoadMaxRetryTime = 0;
        this.mLeftVolume = -1.0f;
        this.mRightVolume = -1.0f;
        this.mUserEnableCoreStartPauseListen = false;
        this.mEnableCoreStartPauseListen = false;
        this.mIsScreenOnWhilePlaying = true;
        this.mPlaySpeed = 1.0f;
        this.mLiveStartIndex = 0;
        this.mIsSecure = false;
        this.mAspectRatio = -1;
        this.mRenderFilter = IVideoView.RenderFilter.NORMAL;
        this.mIsLiveConfig = false;
        this.mEnableLiveMode = false;
        this.mReadDataSourceTypeConfig = 0;
        this.mStartPosMs = 0;
        this.mFlowDataStatistic = new FlowDataStatistic();
        this.mSkipLoopFilterType = MgtvMediaPlayer.SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mSizeChangedListener = new MgtvPlayerListener.OnVideoSizeChangedListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i2, int i22) {
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView.originalVideoWidth = mgtvAlphaVideoView.mVideoWidth = mgtvAlphaVideoView.getVideoWidth();
                MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView2.originalVideoHeight = mgtvAlphaVideoView2.mVideoHeight = mgtvAlphaVideoView2.mMediaPlayer.getVideoHeight();
                if (MgtvAlphaVideoView.this.mVideoWidth != 0 && MgtvAlphaVideoView.this.mVideoHeight != 0) {
                    MgtvAlphaVideoView mgtvAlphaVideoView3 = MgtvAlphaVideoView.this;
                    IAlphaRenderView iAlphaRenderView = mgtvAlphaVideoView3.mGLView;
                    if (iAlphaRenderView != null) {
                        iAlphaRenderView.setVideoSize(mgtvAlphaVideoView3.mVideoWidth, MgtvAlphaVideoView.this.mVideoHeight);
                    }
                    MgtvAlphaVideoView.this.requestLayout();
                }
                if (MgtvAlphaVideoView.this.mOnVideoSizeChangedListener != null) {
                    MgtvAlphaVideoView.this.mOnVideoSizeChangedListener.onVideoSizeChanged(i2, i22);
                }
            }
        };
        this.mPreparedListener = new MgtvPlayerListener.OnPreparedListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPreparedListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPrepared() {
                /*
                    r4 = this;
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    r1 = 2
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$800(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r1 = r0.getVideoWidth()
                    int r1 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$402(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$302(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoHeight()
                    int r1 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$602(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$502(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r0)
                    r1 = 3
                    if (r0 == 0) goto L95
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r0)
                    if (r0 == 0) goto L95
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "video size: "
                    r0.append(r2)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r2)
                    r0.append(r2)
                    java.lang.String r2 = "/"
                    r0.append(r2)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r2)
                    r0.append(r2)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r2 = "@@@@"
                    com.hunantv.media.player.pragma.DebugLog.i(r2, r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.alpha.IAlphaRenderView r2 = r0.mGLView
                    if (r2 == 0) goto L70
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r3 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r3 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r3)
                    r2.setVideoSize(r0, r3)
                L70:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$900(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r2)
                    if (r0 != r2) goto La2
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1000(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r2)
                    if (r0 != r2) goto La2
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1100(r0)
                    if (r0 != r1) goto La2
                    goto L9d
                L95:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1100(r0)
                    if (r0 != r1) goto La2
                L9d:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    r0.start()
                La2:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1200(r0)
                    if (r0 == 0) goto Lb3
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1200(r0)
                    r0.onPrepared()
                Lb3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.alpha.MgtvAlphaVideoView.AnonymousClass4.onPrepared():void");
            }
        };
        this.mCompletionListener = new MgtvPlayerListener.OnCompletionListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.5
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnCompletionListener
            public void onCompletion(int i2, int i22) {
                if (i2 != 0) {
                    MgtvAlphaVideoView.this.stopInner();
                }
                MgtvAlphaVideoView.this.changeCurrentState(5);
                MgtvAlphaVideoView.this.mTargetState = 5;
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "-------------on onCompletion what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnCompletionListener != null) {
                    MgtvAlphaVideoView.this.mOnCompletionListener.onCompletion(i2, i22);
                }
            }
        };
        this.mInfoListener = new MgtvPlayerListener.OnInfoListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.6
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnInfoListener
            public boolean onInfo(int i2, int i22) {
                String logTag;
                StringBuilder sb;
                String str;
                String str2;
                StringBuilder sb2;
                String str3;
                if (i2 != 1) {
                    if (i2 == 2810) {
                        logTag = MgtvAlphaVideoView.this.getLogTag();
                        sb = new StringBuilder();
                        str = "video fps is ";
                    } else if (i2 == 2820) {
                        logTag = MgtvAlphaVideoView.this.getLogTag();
                        switch (i22) {
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_OPEN_INPUT /* 82001 */:
                                str2 = "prepare av data: open input steam";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_FIND_STREAM_INFO /* 82002 */:
                                str2 = "prepare av data: find steam info";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_COMPONENT_OPEN /* 82003 */:
                                str2 = "prepare av data: av stream component open";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_VIDEO_DECODED_START /* 82004 */:
                                str2 = "prepare av data: video decoded start";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_AUDIO_DECODED_START /* 82005 */:
                                str2 = "prepare av data: audio decoded start";
                                break;
                            default:
                                sb = new StringBuilder();
                                str = "prepare av data: ";
                                break;
                        }
                        DebugLog.w(logTag, str2);
                    } else if (i2 == 2830) {
                        String logTag2 = MgtvAlphaVideoView.this.getLogTag();
                        DebugLog.i(logTag2, "MEDIA_INFO_PLAYBACK_STATE_CHANGED:" + i22);
                        if (MgtvAlphaVideoView.this.mOnUpdateStatusListener != null) {
                            MgtvAlphaVideoView.this.mOnUpdateStatusListener.onUpdateStatus();
                        }
                    } else if (i2 == 10001) {
                        String logTag3 = MgtvAlphaVideoView.this.getLogTag();
                        DebugLog.w(logTag3, "video rotation changed,extra(degree) is " + i22);
                        MgtvAlphaVideoView.this.mVideoRotationDegree = i22;
                    } else if (i2 == 200001) {
                        MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                        if (i22 == 1) {
                            mgtvAlphaVideoView.mMgtvMediaPlayerHardwareMode = false;
                        } else {
                            mgtvAlphaVideoView.mMgtvMediaPlayerHardwareMode = true;
                        }
                        MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                        mgtvAlphaVideoView2.convertRender(mgtvAlphaVideoView2.mRenderViewType);
                    } else if (i2 == 3) {
                        DebugLog.w(MgtvAlphaVideoView.this.getLogTag(), "video decode succeeded, start rendering");
                        MgtvAlphaVideoView.this.onVideoRenderStart();
                        if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                            MgtvAlphaVideoView.this.mOnInfoListener.onInfo(900, i22);
                        }
                        return true;
                    } else if (i2 == 4) {
                        DebugLog.w(MgtvAlphaVideoView.this.getLogTag(), "audio decode succeeded, start rendering");
                        if (MgtvAlphaVideoView.this.isOnlyAudioMode()) {
                            if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                                MgtvAlphaVideoView.this.mOnInfoListener.onInfo(900, i22);
                            }
                            return true;
                        }
                    } else if (i2 != 5) {
                        if (i2 == 6) {
                            if (i22 == 0) {
                                MgtvAlphaVideoView.this.mMgtvMediaPlayerHardwareMode = false;
                            } else if (i22 == 1) {
                                MgtvAlphaVideoView.this.mMgtvMediaPlayerHardwareMode = true;
                            }
                            logTag = MgtvAlphaVideoView.this.getLogTag();
                            sb = new StringBuilder();
                            str = "video decoder open,extra is ";
                        } else if (i2 != 7) {
                            switch (i2) {
                                case 700:
                                    String logTag4 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag4, "It's too complex for the decoder, extra is " + i22);
                                    i2 = 700;
                                    break;
                                case 701:
                                    String logTag5 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag5, "buffer start speed:" + MgtvAlphaVideoView.this.getDLSpeedFormat());
                                    i2 = 701;
                                    break;
                                case 702:
                                    String logTag6 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag6, "buffer end speed:" + MgtvAlphaVideoView.this.getDLSpeedFormat());
                                    i2 = 702;
                                    break;
                                default:
                                    switch (i2) {
                                        case 800:
                                            String logTag7 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.e(logTag7, "Bad interleaving of media file, audio/video are not well-formed, extra is " + i22);
                                            i2 = 800;
                                            break;
                                        case 801:
                                            String logTag8 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.w(logTag8, "The stream not seekable status, extra is " + i22);
                                            i2 = 801;
                                            MgtvAlphaVideoView mgtvAlphaVideoView3 = MgtvAlphaVideoView.this;
                                            if (i22 == 1) {
                                                mgtvAlphaVideoView3.mIsLive = true;
                                                logTag = MgtvAlphaVideoView.this.getLogTag();
                                                str2 = "The stream is live stream,can not seekable ";
                                            } else {
                                                mgtvAlphaVideoView3.mIsLive = false;
                                                logTag = MgtvAlphaVideoView.this.getLogTag();
                                                str2 = "The stream is not live stream,can seekable ";
                                            }
                                            DebugLog.w(logTag, str2);
                                            break;
                                        case 802:
                                            String logTag9 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.w(logTag9, "A new set of metadata is available, extra is " + i22);
                                            i2 = 802;
                                            break;
                                        default:
                                            logTag = MgtvAlphaVideoView.this.getLogTag();
                                            switch (i2) {
                                                case MgtvMediaPlayer.MEDIA_INFO_DATA_PROTOCOL /* 2803 */:
                                                    DebugLog.w(logTag, "data source type is " + i22);
                                                    MgtvAlphaVideoView mgtvAlphaVideoView4 = MgtvAlphaVideoView.this;
                                                    MgtvMediaPlayer mgtvMediaPlayer = mgtvAlphaVideoView4.mMediaPlayer;
                                                    if (mgtvMediaPlayer != null) {
                                                        mgtvAlphaVideoView4.mDataSourceType = mgtvMediaPlayer.getDataSourceType();
                                                        break;
                                                    }
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_ACCURATE_SEEK_COMPLETE /* 2804 */:
                                                    sb = new StringBuilder();
                                                    str = "accurate seek complete,time is ";
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_ACODEC_RECONFIGURE /* 2805 */:
                                                    sb = new StringBuilder();
                                                    str = "acodec reconfigure ret is ";
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_STREAM_TYPE /* 2806 */:
                                                    sb2 = new StringBuilder();
                                                    str3 = "stream format type is ";
                                                    sb2.append(str3);
                                                    sb2.append(i22);
                                                    DebugLog.d(logTag, sb2.toString());
                                                    break;
                                                default:
                                                    sb2 = new StringBuilder();
                                                    sb2.append("Unknown info code: ");
                                                    sb2.append(i2);
                                                    str3 = ", extra is ";
                                                    sb2.append(str3);
                                                    sb2.append(i22);
                                                    DebugLog.d(logTag, sb2.toString());
                                                    break;
                                            }
                                    }
                            }
                        } else {
                            i2 = IVideoView.MEDIA_INFO_DOWNLOAD_SPEED;
                        }
                    }
                    sb.append(str);
                    sb.append(i22);
                    str2 = sb.toString();
                    DebugLog.w(logTag, str2);
                } else {
                    String logTag10 = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.w(logTag10, "Unknown info, extra is " + i22);
                    i2 = 1;
                }
                if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                    MgtvAlphaVideoView.this.mOnInfoListener.onInfo(i2, i22);
                }
                return true;
            }
        };
        this.mInfoStringListener = new MgtvPlayerListener.OnInfoStringListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.7
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnInfoStringListener
            public boolean onInfo(int i2, String str) {
                if (i2 == 2860) {
                    String logTag = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.i(logTag, "MEDIA_INFO_SEI_SYS_TIMESTAMP: " + str);
                    return false;
                }
                String logTag2 = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag2, "OnInfoStringListener what: " + i2 + ", extra is " + str);
                return false;
            }
        };
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.8
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.w(logTag, "onError what:" + i2 + ",extra:" + i22);
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvAlphaVideoView.mMediaPlayer;
                if (mgtvMediaPlayer == null || i2 != 7000006) {
                    if (mgtvMediaPlayer != null && mgtvAlphaVideoView.mCurrentState != -1) {
                        MgtvAlphaVideoView.this.mMediaPlayer.stop();
                    }
                    MgtvAlphaVideoView.this.changeCurrentState(-1);
                    MgtvAlphaVideoView.this.mTargetState = -1;
                } else {
                    mgtvAlphaVideoView.releaseNoStatus();
                    MgtvAlphaVideoView.this.changeCurrentState(0);
                    MgtvAlphaVideoView.this.mTargetState = 0;
                }
                MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView2.mCurrentUri = null;
                mgtvAlphaVideoView2.mProxyUri = null;
                return mgtvAlphaVideoView2.mOnErrorListener != null && MgtvAlphaVideoView.this.mOnErrorListener.onError(i2, i22);
            }
        };
        this.mSeekCompleteListener = new MgtvPlayerListener.OnSeekCompleteListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.9
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSeekCompleteListener
            public void onSeekComplete(int i2, int i22) {
                if (MgtvAlphaVideoView.this.mOnSeekCompleteListener != null) {
                    String logTag = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.i(logTag, "onSeekComplete seekTargetTime:" + i2 + ",errorCode:" + i22);
                    MgtvAlphaVideoView.this.mOnSeekCompleteListener.onSeekComplete();
                }
            }
        };
        this.mBufferingUpdateListener = new MgtvPlayerListener.OnBufferingUpdateListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.10
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingUpdateListener
            public void onBufferingUpdate(int i2) {
                if (MgtvAlphaVideoView.this.mOnBufferringUpdateListener != null) {
                    MgtvAlphaVideoView.this.mOnBufferringUpdateListener.onBufferingUpdate(i2);
                }
            }
        };
        this.mBufferingTimeoutListener = new MgtvPlayerListener.OnBufferingTimeoutListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.11
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingTimeoutListener
            public boolean onBufferingTimeout(int i2, int i22) {
                MgtvMediaPlayer mgtvMediaPlayer = MgtvAlphaVideoView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.stop();
                }
                MgtvAlphaVideoView.this.changeCurrentState(-1);
                MgtvAlphaVideoView.this.mTargetState = -1;
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView.mCurrentUri = null;
                mgtvAlphaVideoView.mProxyUri = null;
                if (mgtvAlphaVideoView.mOnErrorListener == null || MgtvAlphaVideoView.this.mOnErrorListener.onError(i2, i22)) {
                }
                return true;
            }
        };
        this.mSwitchSourceListener = new MgtvPlayerListener.OnSwitchSourceListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.12
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceComplete(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceComplete url:" + str + ",type:" + i2 + ",time:" + i22);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceSuccess(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceFailed(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceFailed url:" + str + ",what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceFailed(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceInfo(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceInfo url:" + str + ",event:" + i2 + ",time:" + i22);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceInfo(str, i2, i22);
                }
            }
        };
        this.mPlayerWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.13
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "onTsSkip tsUrl:" + str);
                if (MgtvAlphaVideoView.this.mOnWarningListener != null) {
                    MgtvAlphaVideoView.this.mOnWarningListener.onTsSkip(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "player render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvAlphaVideoView.this.mOnWarningListener != null) {
                    MgtvAlphaVideoView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mGifRecorder = new GifRecorder();
        this.mStartListener = new MgtvPlayerListener.OnStartListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.14
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnStartListener
            public void onStart() {
                DebugLog.d(MgtvAlphaVideoView.this.getLogTag(), "mgtvcore onStart");
                if (MgtvAlphaVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvAlphaVideoView.this.callbackOnStart();
                }
            }
        };
        this.mPauseListener = new MgtvPlayerListener.OnPauseListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.15
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPauseListener
            public void onPause() {
                DebugLog.d(MgtvAlphaVideoView.this.getLogTag(), "mgtvcore onPause");
                if (MgtvAlphaVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvAlphaVideoView.this.callbackOnPause();
                }
            }
        };
        this.mRecordVideoListener = new MgtvPlayerListener.OnRecordVideoListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.16
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoErr(int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onRecordVideoErr what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnRecordListener != null) {
                    MgtvAlphaVideoView.this.mOnRecordListener.onRecordError(i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoInfo(int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "onRecordVideoInfo what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnRecordListener != null) {
                    if (i2 == 20) {
                        MgtvAlphaVideoView.this.mOnRecordListener.onRecordStart(MgtvAlphaVideoView.this.mRecordFilePath);
                    } else if (i2 == 30) {
                        MgtvAlphaVideoView.this.mOnRecordListener.onRecordStop();
                    }
                    MgtvAlphaVideoView.this.mOnRecordListener.onRecordInfo(i2, i22);
                }
            }
        };
        this.mLoadDataListener = new MgtvPlayerListener.OnLoadDataListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.17
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onAfterLoadDataPaused() {
                if (MgtvAlphaVideoView.this.mOnLoadDataListener != null) {
                    MgtvAlphaVideoView.this.mOnLoadDataListener.onAfterLoadDataPaused();
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onBeforeLoadDataResume() {
                if (MgtvAlphaVideoView.this.mOnLoadDataListener != null) {
                    MgtvAlphaVideoView.this.mOnLoadDataListener.onBeforeLoadDataResume();
                }
            }
        };
        initVideoView(context);
    }

    public MgtvAlphaVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSurface = null;
        this.mLastSurfaceDestroy = true;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mMgtvMediaPlayerHardwareMode = true;
        this.mForceDecodeMode = false;
        this.mFromSurfaceDestroyToPlay = false;
        this.mFromSurfaceDestroyPlayPosition = 0;
        this.mErrorMsg = "";
        this.mHasSurfaceHolderDestroy = false;
        this.mRenderViewType = 1;
        this.mLogCallBackOpen = true;
        this.mStreamKey = -1;
        this.mIsLive = false;
        this.mUseSystemPlayer = false;
        this.mAddrInfoType = MgtvMediaPlayer.AddrinfoType.TYPE_ADDRINFO_DEFAULT;
        this.mAddrInfoTypeInt = 0;
        this.mOpenAddrDefaultConfig = true;
        this.mJavaDnsType = a.d.a;
        this.mNativeDnsAsyncEnable = true;
        this.mBackJavaDns = false;
        this.mEnableHttpDnsRetry = false;
        this.mEnableDnsNoNetStrategy = true;
        this.mEnableP2pHttpDns = false;
        this.mHlsMD5CheckValue = 0;
        this.mEnableMgtvMediaCodec = false;
        this.mEnableJavaIPCache = false;
        this.mLastFrameRecovery = true;
        this.mWeakNetSpeed = 0;
        this.mWeakBufferTimeoutMs = 0;
        this.mTsNotSkip = false;
        this.mLoadMaxRetryTime = 0;
        this.mLeftVolume = -1.0f;
        this.mRightVolume = -1.0f;
        this.mUserEnableCoreStartPauseListen = false;
        this.mEnableCoreStartPauseListen = false;
        this.mIsScreenOnWhilePlaying = true;
        this.mPlaySpeed = 1.0f;
        this.mLiveStartIndex = 0;
        this.mIsSecure = false;
        this.mAspectRatio = -1;
        this.mRenderFilter = IVideoView.RenderFilter.NORMAL;
        this.mIsLiveConfig = false;
        this.mEnableLiveMode = false;
        this.mReadDataSourceTypeConfig = 0;
        this.mStartPosMs = 0;
        this.mFlowDataStatistic = new FlowDataStatistic();
        this.mSkipLoopFilterType = MgtvMediaPlayer.SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mSizeChangedListener = new MgtvPlayerListener.OnVideoSizeChangedListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i2, int i22) {
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView.originalVideoWidth = mgtvAlphaVideoView.mVideoWidth = mgtvAlphaVideoView.getVideoWidth();
                MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView2.originalVideoHeight = mgtvAlphaVideoView2.mVideoHeight = mgtvAlphaVideoView2.mMediaPlayer.getVideoHeight();
                if (MgtvAlphaVideoView.this.mVideoWidth != 0 && MgtvAlphaVideoView.this.mVideoHeight != 0) {
                    MgtvAlphaVideoView mgtvAlphaVideoView3 = MgtvAlphaVideoView.this;
                    IAlphaRenderView iAlphaRenderView = mgtvAlphaVideoView3.mGLView;
                    if (iAlphaRenderView != null) {
                        iAlphaRenderView.setVideoSize(mgtvAlphaVideoView3.mVideoWidth, MgtvAlphaVideoView.this.mVideoHeight);
                    }
                    MgtvAlphaVideoView.this.requestLayout();
                }
                if (MgtvAlphaVideoView.this.mOnVideoSizeChangedListener != null) {
                    MgtvAlphaVideoView.this.mOnVideoSizeChangedListener.onVideoSizeChanged(i2, i22);
                }
            }
        };
        this.mPreparedListener = new MgtvPlayerListener.OnPreparedListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPreparedListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPrepared() {
                /*
                    r4 = this;
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    r1 = 2
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$800(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r1 = r0.getVideoWidth()
                    int r1 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$402(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$302(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoHeight()
                    int r1 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$602(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$502(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r0)
                    r1 = 3
                    if (r0 == 0) goto L95
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r0)
                    if (r0 == 0) goto L95
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "video size: "
                    r0.append(r2)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r2)
                    r0.append(r2)
                    java.lang.String r2 = "/"
                    r0.append(r2)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r2)
                    r0.append(r2)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r2 = "@@@@"
                    com.hunantv.media.player.pragma.DebugLog.i(r2, r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.alpha.IAlphaRenderView r2 = r0.mGLView
                    if (r2 == 0) goto L70
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r3 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r3 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r3)
                    r2.setVideoSize(r0, r3)
                L70:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$900(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r2)
                    if (r0 != r2) goto La2
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1000(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r2)
                    if (r0 != r2) goto La2
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1100(r0)
                    if (r0 != r1) goto La2
                    goto L9d
                L95:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1100(r0)
                    if (r0 != r1) goto La2
                L9d:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    r0.start()
                La2:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1200(r0)
                    if (r0 == 0) goto Lb3
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1200(r0)
                    r0.onPrepared()
                Lb3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.alpha.MgtvAlphaVideoView.AnonymousClass4.onPrepared():void");
            }
        };
        this.mCompletionListener = new MgtvPlayerListener.OnCompletionListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.5
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnCompletionListener
            public void onCompletion(int i2, int i22) {
                if (i2 != 0) {
                    MgtvAlphaVideoView.this.stopInner();
                }
                MgtvAlphaVideoView.this.changeCurrentState(5);
                MgtvAlphaVideoView.this.mTargetState = 5;
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "-------------on onCompletion what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnCompletionListener != null) {
                    MgtvAlphaVideoView.this.mOnCompletionListener.onCompletion(i2, i22);
                }
            }
        };
        this.mInfoListener = new MgtvPlayerListener.OnInfoListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.6
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnInfoListener
            public boolean onInfo(int i2, int i22) {
                String logTag;
                StringBuilder sb;
                String str;
                String str2;
                StringBuilder sb2;
                String str3;
                if (i2 != 1) {
                    if (i2 == 2810) {
                        logTag = MgtvAlphaVideoView.this.getLogTag();
                        sb = new StringBuilder();
                        str = "video fps is ";
                    } else if (i2 == 2820) {
                        logTag = MgtvAlphaVideoView.this.getLogTag();
                        switch (i22) {
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_OPEN_INPUT /* 82001 */:
                                str2 = "prepare av data: open input steam";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_FIND_STREAM_INFO /* 82002 */:
                                str2 = "prepare av data: find steam info";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_COMPONENT_OPEN /* 82003 */:
                                str2 = "prepare av data: av stream component open";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_VIDEO_DECODED_START /* 82004 */:
                                str2 = "prepare av data: video decoded start";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_AUDIO_DECODED_START /* 82005 */:
                                str2 = "prepare av data: audio decoded start";
                                break;
                            default:
                                sb = new StringBuilder();
                                str = "prepare av data: ";
                                break;
                        }
                        DebugLog.w(logTag, str2);
                    } else if (i2 == 2830) {
                        String logTag2 = MgtvAlphaVideoView.this.getLogTag();
                        DebugLog.i(logTag2, "MEDIA_INFO_PLAYBACK_STATE_CHANGED:" + i22);
                        if (MgtvAlphaVideoView.this.mOnUpdateStatusListener != null) {
                            MgtvAlphaVideoView.this.mOnUpdateStatusListener.onUpdateStatus();
                        }
                    } else if (i2 == 10001) {
                        String logTag3 = MgtvAlphaVideoView.this.getLogTag();
                        DebugLog.w(logTag3, "video rotation changed,extra(degree) is " + i22);
                        MgtvAlphaVideoView.this.mVideoRotationDegree = i22;
                    } else if (i2 == 200001) {
                        MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                        if (i22 == 1) {
                            mgtvAlphaVideoView.mMgtvMediaPlayerHardwareMode = false;
                        } else {
                            mgtvAlphaVideoView.mMgtvMediaPlayerHardwareMode = true;
                        }
                        MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                        mgtvAlphaVideoView2.convertRender(mgtvAlphaVideoView2.mRenderViewType);
                    } else if (i2 == 3) {
                        DebugLog.w(MgtvAlphaVideoView.this.getLogTag(), "video decode succeeded, start rendering");
                        MgtvAlphaVideoView.this.onVideoRenderStart();
                        if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                            MgtvAlphaVideoView.this.mOnInfoListener.onInfo(900, i22);
                        }
                        return true;
                    } else if (i2 == 4) {
                        DebugLog.w(MgtvAlphaVideoView.this.getLogTag(), "audio decode succeeded, start rendering");
                        if (MgtvAlphaVideoView.this.isOnlyAudioMode()) {
                            if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                                MgtvAlphaVideoView.this.mOnInfoListener.onInfo(900, i22);
                            }
                            return true;
                        }
                    } else if (i2 != 5) {
                        if (i2 == 6) {
                            if (i22 == 0) {
                                MgtvAlphaVideoView.this.mMgtvMediaPlayerHardwareMode = false;
                            } else if (i22 == 1) {
                                MgtvAlphaVideoView.this.mMgtvMediaPlayerHardwareMode = true;
                            }
                            logTag = MgtvAlphaVideoView.this.getLogTag();
                            sb = new StringBuilder();
                            str = "video decoder open,extra is ";
                        } else if (i2 != 7) {
                            switch (i2) {
                                case 700:
                                    String logTag4 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag4, "It's too complex for the decoder, extra is " + i22);
                                    i2 = 700;
                                    break;
                                case 701:
                                    String logTag5 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag5, "buffer start speed:" + MgtvAlphaVideoView.this.getDLSpeedFormat());
                                    i2 = 701;
                                    break;
                                case 702:
                                    String logTag6 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag6, "buffer end speed:" + MgtvAlphaVideoView.this.getDLSpeedFormat());
                                    i2 = 702;
                                    break;
                                default:
                                    switch (i2) {
                                        case 800:
                                            String logTag7 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.e(logTag7, "Bad interleaving of media file, audio/video are not well-formed, extra is " + i22);
                                            i2 = 800;
                                            break;
                                        case 801:
                                            String logTag8 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.w(logTag8, "The stream not seekable status, extra is " + i22);
                                            i2 = 801;
                                            MgtvAlphaVideoView mgtvAlphaVideoView3 = MgtvAlphaVideoView.this;
                                            if (i22 == 1) {
                                                mgtvAlphaVideoView3.mIsLive = true;
                                                logTag = MgtvAlphaVideoView.this.getLogTag();
                                                str2 = "The stream is live stream,can not seekable ";
                                            } else {
                                                mgtvAlphaVideoView3.mIsLive = false;
                                                logTag = MgtvAlphaVideoView.this.getLogTag();
                                                str2 = "The stream is not live stream,can seekable ";
                                            }
                                            DebugLog.w(logTag, str2);
                                            break;
                                        case 802:
                                            String logTag9 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.w(logTag9, "A new set of metadata is available, extra is " + i22);
                                            i2 = 802;
                                            break;
                                        default:
                                            logTag = MgtvAlphaVideoView.this.getLogTag();
                                            switch (i2) {
                                                case MgtvMediaPlayer.MEDIA_INFO_DATA_PROTOCOL /* 2803 */:
                                                    DebugLog.w(logTag, "data source type is " + i22);
                                                    MgtvAlphaVideoView mgtvAlphaVideoView4 = MgtvAlphaVideoView.this;
                                                    MgtvMediaPlayer mgtvMediaPlayer = mgtvAlphaVideoView4.mMediaPlayer;
                                                    if (mgtvMediaPlayer != null) {
                                                        mgtvAlphaVideoView4.mDataSourceType = mgtvMediaPlayer.getDataSourceType();
                                                        break;
                                                    }
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_ACCURATE_SEEK_COMPLETE /* 2804 */:
                                                    sb = new StringBuilder();
                                                    str = "accurate seek complete,time is ";
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_ACODEC_RECONFIGURE /* 2805 */:
                                                    sb = new StringBuilder();
                                                    str = "acodec reconfigure ret is ";
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_STREAM_TYPE /* 2806 */:
                                                    sb2 = new StringBuilder();
                                                    str3 = "stream format type is ";
                                                    sb2.append(str3);
                                                    sb2.append(i22);
                                                    DebugLog.d(logTag, sb2.toString());
                                                    break;
                                                default:
                                                    sb2 = new StringBuilder();
                                                    sb2.append("Unknown info code: ");
                                                    sb2.append(i2);
                                                    str3 = ", extra is ";
                                                    sb2.append(str3);
                                                    sb2.append(i22);
                                                    DebugLog.d(logTag, sb2.toString());
                                                    break;
                                            }
                                    }
                            }
                        } else {
                            i2 = IVideoView.MEDIA_INFO_DOWNLOAD_SPEED;
                        }
                    }
                    sb.append(str);
                    sb.append(i22);
                    str2 = sb.toString();
                    DebugLog.w(logTag, str2);
                } else {
                    String logTag10 = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.w(logTag10, "Unknown info, extra is " + i22);
                    i2 = 1;
                }
                if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                    MgtvAlphaVideoView.this.mOnInfoListener.onInfo(i2, i22);
                }
                return true;
            }
        };
        this.mInfoStringListener = new MgtvPlayerListener.OnInfoStringListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.7
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnInfoStringListener
            public boolean onInfo(int i2, String str) {
                if (i2 == 2860) {
                    String logTag = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.i(logTag, "MEDIA_INFO_SEI_SYS_TIMESTAMP: " + str);
                    return false;
                }
                String logTag2 = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag2, "OnInfoStringListener what: " + i2 + ", extra is " + str);
                return false;
            }
        };
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.8
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.w(logTag, "onError what:" + i2 + ",extra:" + i22);
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvAlphaVideoView.mMediaPlayer;
                if (mgtvMediaPlayer == null || i2 != 7000006) {
                    if (mgtvMediaPlayer != null && mgtvAlphaVideoView.mCurrentState != -1) {
                        MgtvAlphaVideoView.this.mMediaPlayer.stop();
                    }
                    MgtvAlphaVideoView.this.changeCurrentState(-1);
                    MgtvAlphaVideoView.this.mTargetState = -1;
                } else {
                    mgtvAlphaVideoView.releaseNoStatus();
                    MgtvAlphaVideoView.this.changeCurrentState(0);
                    MgtvAlphaVideoView.this.mTargetState = 0;
                }
                MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView2.mCurrentUri = null;
                mgtvAlphaVideoView2.mProxyUri = null;
                return mgtvAlphaVideoView2.mOnErrorListener != null && MgtvAlphaVideoView.this.mOnErrorListener.onError(i2, i22);
            }
        };
        this.mSeekCompleteListener = new MgtvPlayerListener.OnSeekCompleteListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.9
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSeekCompleteListener
            public void onSeekComplete(int i2, int i22) {
                if (MgtvAlphaVideoView.this.mOnSeekCompleteListener != null) {
                    String logTag = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.i(logTag, "onSeekComplete seekTargetTime:" + i2 + ",errorCode:" + i22);
                    MgtvAlphaVideoView.this.mOnSeekCompleteListener.onSeekComplete();
                }
            }
        };
        this.mBufferingUpdateListener = new MgtvPlayerListener.OnBufferingUpdateListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.10
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingUpdateListener
            public void onBufferingUpdate(int i2) {
                if (MgtvAlphaVideoView.this.mOnBufferringUpdateListener != null) {
                    MgtvAlphaVideoView.this.mOnBufferringUpdateListener.onBufferingUpdate(i2);
                }
            }
        };
        this.mBufferingTimeoutListener = new MgtvPlayerListener.OnBufferingTimeoutListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.11
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingTimeoutListener
            public boolean onBufferingTimeout(int i2, int i22) {
                MgtvMediaPlayer mgtvMediaPlayer = MgtvAlphaVideoView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.stop();
                }
                MgtvAlphaVideoView.this.changeCurrentState(-1);
                MgtvAlphaVideoView.this.mTargetState = -1;
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView.mCurrentUri = null;
                mgtvAlphaVideoView.mProxyUri = null;
                if (mgtvAlphaVideoView.mOnErrorListener == null || MgtvAlphaVideoView.this.mOnErrorListener.onError(i2, i22)) {
                }
                return true;
            }
        };
        this.mSwitchSourceListener = new MgtvPlayerListener.OnSwitchSourceListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.12
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceComplete(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceComplete url:" + str + ",type:" + i2 + ",time:" + i22);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceSuccess(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceFailed(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceFailed url:" + str + ",what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceFailed(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceInfo(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceInfo url:" + str + ",event:" + i2 + ",time:" + i22);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceInfo(str, i2, i22);
                }
            }
        };
        this.mPlayerWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.13
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "onTsSkip tsUrl:" + str);
                if (MgtvAlphaVideoView.this.mOnWarningListener != null) {
                    MgtvAlphaVideoView.this.mOnWarningListener.onTsSkip(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "player render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvAlphaVideoView.this.mOnWarningListener != null) {
                    MgtvAlphaVideoView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mGifRecorder = new GifRecorder();
        this.mStartListener = new MgtvPlayerListener.OnStartListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.14
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnStartListener
            public void onStart() {
                DebugLog.d(MgtvAlphaVideoView.this.getLogTag(), "mgtvcore onStart");
                if (MgtvAlphaVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvAlphaVideoView.this.callbackOnStart();
                }
            }
        };
        this.mPauseListener = new MgtvPlayerListener.OnPauseListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.15
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPauseListener
            public void onPause() {
                DebugLog.d(MgtvAlphaVideoView.this.getLogTag(), "mgtvcore onPause");
                if (MgtvAlphaVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvAlphaVideoView.this.callbackOnPause();
                }
            }
        };
        this.mRecordVideoListener = new MgtvPlayerListener.OnRecordVideoListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.16
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoErr(int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onRecordVideoErr what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnRecordListener != null) {
                    MgtvAlphaVideoView.this.mOnRecordListener.onRecordError(i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoInfo(int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "onRecordVideoInfo what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnRecordListener != null) {
                    if (i2 == 20) {
                        MgtvAlphaVideoView.this.mOnRecordListener.onRecordStart(MgtvAlphaVideoView.this.mRecordFilePath);
                    } else if (i2 == 30) {
                        MgtvAlphaVideoView.this.mOnRecordListener.onRecordStop();
                    }
                    MgtvAlphaVideoView.this.mOnRecordListener.onRecordInfo(i2, i22);
                }
            }
        };
        this.mLoadDataListener = new MgtvPlayerListener.OnLoadDataListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.17
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onAfterLoadDataPaused() {
                if (MgtvAlphaVideoView.this.mOnLoadDataListener != null) {
                    MgtvAlphaVideoView.this.mOnLoadDataListener.onAfterLoadDataPaused();
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onBeforeLoadDataResume() {
                if (MgtvAlphaVideoView.this.mOnLoadDataListener != null) {
                    MgtvAlphaVideoView.this.mOnLoadDataListener.onBeforeLoadDataResume();
                }
            }
        };
        initVideoView(context);
    }

    public MgtvAlphaVideoView(Context context, IVideoView.Configuration configuration) {
        super(context, configuration);
        this.mSurface = null;
        this.mLastSurfaceDestroy = true;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mMgtvMediaPlayerHardwareMode = true;
        this.mForceDecodeMode = false;
        this.mFromSurfaceDestroyToPlay = false;
        this.mFromSurfaceDestroyPlayPosition = 0;
        this.mErrorMsg = "";
        this.mHasSurfaceHolderDestroy = false;
        this.mRenderViewType = 1;
        this.mLogCallBackOpen = true;
        this.mStreamKey = -1;
        this.mIsLive = false;
        this.mUseSystemPlayer = false;
        this.mAddrInfoType = MgtvMediaPlayer.AddrinfoType.TYPE_ADDRINFO_DEFAULT;
        this.mAddrInfoTypeInt = 0;
        this.mOpenAddrDefaultConfig = true;
        this.mJavaDnsType = a.d.a;
        this.mNativeDnsAsyncEnable = true;
        this.mBackJavaDns = false;
        this.mEnableHttpDnsRetry = false;
        this.mEnableDnsNoNetStrategy = true;
        this.mEnableP2pHttpDns = false;
        this.mHlsMD5CheckValue = 0;
        this.mEnableMgtvMediaCodec = false;
        this.mEnableJavaIPCache = false;
        this.mLastFrameRecovery = true;
        this.mWeakNetSpeed = 0;
        this.mWeakBufferTimeoutMs = 0;
        this.mTsNotSkip = false;
        this.mLoadMaxRetryTime = 0;
        this.mLeftVolume = -1.0f;
        this.mRightVolume = -1.0f;
        this.mUserEnableCoreStartPauseListen = false;
        this.mEnableCoreStartPauseListen = false;
        this.mIsScreenOnWhilePlaying = true;
        this.mPlaySpeed = 1.0f;
        this.mLiveStartIndex = 0;
        this.mIsSecure = false;
        this.mAspectRatio = -1;
        this.mRenderFilter = IVideoView.RenderFilter.NORMAL;
        this.mIsLiveConfig = false;
        this.mEnableLiveMode = false;
        this.mReadDataSourceTypeConfig = 0;
        this.mStartPosMs = 0;
        this.mFlowDataStatistic = new FlowDataStatistic();
        this.mSkipLoopFilterType = MgtvMediaPlayer.SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mSizeChangedListener = new MgtvPlayerListener.OnVideoSizeChangedListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i2, int i22) {
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView.originalVideoWidth = mgtvAlphaVideoView.mVideoWidth = mgtvAlphaVideoView.getVideoWidth();
                MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView2.originalVideoHeight = mgtvAlphaVideoView2.mVideoHeight = mgtvAlphaVideoView2.mMediaPlayer.getVideoHeight();
                if (MgtvAlphaVideoView.this.mVideoWidth != 0 && MgtvAlphaVideoView.this.mVideoHeight != 0) {
                    MgtvAlphaVideoView mgtvAlphaVideoView3 = MgtvAlphaVideoView.this;
                    IAlphaRenderView iAlphaRenderView = mgtvAlphaVideoView3.mGLView;
                    if (iAlphaRenderView != null) {
                        iAlphaRenderView.setVideoSize(mgtvAlphaVideoView3.mVideoWidth, MgtvAlphaVideoView.this.mVideoHeight);
                    }
                    MgtvAlphaVideoView.this.requestLayout();
                }
                if (MgtvAlphaVideoView.this.mOnVideoSizeChangedListener != null) {
                    MgtvAlphaVideoView.this.mOnVideoSizeChangedListener.onVideoSizeChanged(i2, i22);
                }
            }
        };
        this.mPreparedListener = new MgtvPlayerListener.OnPreparedListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPreparedListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPrepared() {
                /*
                    r4 = this;
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    r1 = 2
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$800(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r1 = r0.getVideoWidth()
                    int r1 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$402(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$302(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoHeight()
                    int r1 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$602(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView.access$502(r0, r1)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r0)
                    r1 = 3
                    if (r0 == 0) goto L95
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r0)
                    if (r0 == 0) goto L95
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "video size: "
                    r0.append(r2)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r2)
                    r0.append(r2)
                    java.lang.String r2 = "/"
                    r0.append(r2)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r2)
                    r0.append(r2)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r2 = "@@@@"
                    com.hunantv.media.player.pragma.DebugLog.i(r2, r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.alpha.IAlphaRenderView r2 = r0.mGLView
                    if (r2 == 0) goto L70
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r3 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r3 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r3)
                    r2.setVideoSize(r0, r3)
                L70:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$900(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$400(r2)
                    if (r0 != r2) goto La2
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1000(r0)
                    com.hunantv.media.alpha.MgtvAlphaVideoView r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r2 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$600(r2)
                    if (r0 != r2) goto La2
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1100(r0)
                    if (r0 != r1) goto La2
                    goto L9d
                L95:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    int r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1100(r0)
                    if (r0 != r1) goto La2
                L9d:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    r0.start()
                La2:
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1200(r0)
                    if (r0 == 0) goto Lb3
                    com.hunantv.media.alpha.MgtvAlphaVideoView r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.alpha.MgtvAlphaVideoView.access$1200(r0)
                    r0.onPrepared()
                Lb3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.alpha.MgtvAlphaVideoView.AnonymousClass4.onPrepared():void");
            }
        };
        this.mCompletionListener = new MgtvPlayerListener.OnCompletionListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.5
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnCompletionListener
            public void onCompletion(int i2, int i22) {
                if (i2 != 0) {
                    MgtvAlphaVideoView.this.stopInner();
                }
                MgtvAlphaVideoView.this.changeCurrentState(5);
                MgtvAlphaVideoView.this.mTargetState = 5;
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "-------------on onCompletion what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnCompletionListener != null) {
                    MgtvAlphaVideoView.this.mOnCompletionListener.onCompletion(i2, i22);
                }
            }
        };
        this.mInfoListener = new MgtvPlayerListener.OnInfoListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.6
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnInfoListener
            public boolean onInfo(int i2, int i22) {
                String logTag;
                StringBuilder sb;
                String str;
                String str2;
                StringBuilder sb2;
                String str3;
                if (i2 != 1) {
                    if (i2 == 2810) {
                        logTag = MgtvAlphaVideoView.this.getLogTag();
                        sb = new StringBuilder();
                        str = "video fps is ";
                    } else if (i2 == 2820) {
                        logTag = MgtvAlphaVideoView.this.getLogTag();
                        switch (i22) {
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_OPEN_INPUT /* 82001 */:
                                str2 = "prepare av data: open input steam";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_FIND_STREAM_INFO /* 82002 */:
                                str2 = "prepare av data: find steam info";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_COMPONENT_OPEN /* 82003 */:
                                str2 = "prepare av data: av stream component open";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_VIDEO_DECODED_START /* 82004 */:
                                str2 = "prepare av data: video decoded start";
                                break;
                            case MgtvMediaPlayer.PREPARE_WILL_PLAYING_AUDIO_DECODED_START /* 82005 */:
                                str2 = "prepare av data: audio decoded start";
                                break;
                            default:
                                sb = new StringBuilder();
                                str = "prepare av data: ";
                                break;
                        }
                        DebugLog.w(logTag, str2);
                    } else if (i2 == 2830) {
                        String logTag2 = MgtvAlphaVideoView.this.getLogTag();
                        DebugLog.i(logTag2, "MEDIA_INFO_PLAYBACK_STATE_CHANGED:" + i22);
                        if (MgtvAlphaVideoView.this.mOnUpdateStatusListener != null) {
                            MgtvAlphaVideoView.this.mOnUpdateStatusListener.onUpdateStatus();
                        }
                    } else if (i2 == 10001) {
                        String logTag3 = MgtvAlphaVideoView.this.getLogTag();
                        DebugLog.w(logTag3, "video rotation changed,extra(degree) is " + i22);
                        MgtvAlphaVideoView.this.mVideoRotationDegree = i22;
                    } else if (i2 == 200001) {
                        MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                        if (i22 == 1) {
                            mgtvAlphaVideoView.mMgtvMediaPlayerHardwareMode = false;
                        } else {
                            mgtvAlphaVideoView.mMgtvMediaPlayerHardwareMode = true;
                        }
                        MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                        mgtvAlphaVideoView2.convertRender(mgtvAlphaVideoView2.mRenderViewType);
                    } else if (i2 == 3) {
                        DebugLog.w(MgtvAlphaVideoView.this.getLogTag(), "video decode succeeded, start rendering");
                        MgtvAlphaVideoView.this.onVideoRenderStart();
                        if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                            MgtvAlphaVideoView.this.mOnInfoListener.onInfo(900, i22);
                        }
                        return true;
                    } else if (i2 == 4) {
                        DebugLog.w(MgtvAlphaVideoView.this.getLogTag(), "audio decode succeeded, start rendering");
                        if (MgtvAlphaVideoView.this.isOnlyAudioMode()) {
                            if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                                MgtvAlphaVideoView.this.mOnInfoListener.onInfo(900, i22);
                            }
                            return true;
                        }
                    } else if (i2 != 5) {
                        if (i2 == 6) {
                            if (i22 == 0) {
                                MgtvAlphaVideoView.this.mMgtvMediaPlayerHardwareMode = false;
                            } else if (i22 == 1) {
                                MgtvAlphaVideoView.this.mMgtvMediaPlayerHardwareMode = true;
                            }
                            logTag = MgtvAlphaVideoView.this.getLogTag();
                            sb = new StringBuilder();
                            str = "video decoder open,extra is ";
                        } else if (i2 != 7) {
                            switch (i2) {
                                case 700:
                                    String logTag4 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag4, "It's too complex for the decoder, extra is " + i22);
                                    i2 = 700;
                                    break;
                                case 701:
                                    String logTag5 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag5, "buffer start speed:" + MgtvAlphaVideoView.this.getDLSpeedFormat());
                                    i2 = 701;
                                    break;
                                case 702:
                                    String logTag6 = MgtvAlphaVideoView.this.getLogTag();
                                    DebugLog.w(logTag6, "buffer end speed:" + MgtvAlphaVideoView.this.getDLSpeedFormat());
                                    i2 = 702;
                                    break;
                                default:
                                    switch (i2) {
                                        case 800:
                                            String logTag7 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.e(logTag7, "Bad interleaving of media file, audio/video are not well-formed, extra is " + i22);
                                            i2 = 800;
                                            break;
                                        case 801:
                                            String logTag8 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.w(logTag8, "The stream not seekable status, extra is " + i22);
                                            i2 = 801;
                                            MgtvAlphaVideoView mgtvAlphaVideoView3 = MgtvAlphaVideoView.this;
                                            if (i22 == 1) {
                                                mgtvAlphaVideoView3.mIsLive = true;
                                                logTag = MgtvAlphaVideoView.this.getLogTag();
                                                str2 = "The stream is live stream,can not seekable ";
                                            } else {
                                                mgtvAlphaVideoView3.mIsLive = false;
                                                logTag = MgtvAlphaVideoView.this.getLogTag();
                                                str2 = "The stream is not live stream,can seekable ";
                                            }
                                            DebugLog.w(logTag, str2);
                                            break;
                                        case 802:
                                            String logTag9 = MgtvAlphaVideoView.this.getLogTag();
                                            DebugLog.w(logTag9, "A new set of metadata is available, extra is " + i22);
                                            i2 = 802;
                                            break;
                                        default:
                                            logTag = MgtvAlphaVideoView.this.getLogTag();
                                            switch (i2) {
                                                case MgtvMediaPlayer.MEDIA_INFO_DATA_PROTOCOL /* 2803 */:
                                                    DebugLog.w(logTag, "data source type is " + i22);
                                                    MgtvAlphaVideoView mgtvAlphaVideoView4 = MgtvAlphaVideoView.this;
                                                    MgtvMediaPlayer mgtvMediaPlayer = mgtvAlphaVideoView4.mMediaPlayer;
                                                    if (mgtvMediaPlayer != null) {
                                                        mgtvAlphaVideoView4.mDataSourceType = mgtvMediaPlayer.getDataSourceType();
                                                        break;
                                                    }
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_ACCURATE_SEEK_COMPLETE /* 2804 */:
                                                    sb = new StringBuilder();
                                                    str = "accurate seek complete,time is ";
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_ACODEC_RECONFIGURE /* 2805 */:
                                                    sb = new StringBuilder();
                                                    str = "acodec reconfigure ret is ";
                                                    break;
                                                case MgtvMediaPlayer.MEDIA_INFO_STREAM_TYPE /* 2806 */:
                                                    sb2 = new StringBuilder();
                                                    str3 = "stream format type is ";
                                                    sb2.append(str3);
                                                    sb2.append(i22);
                                                    DebugLog.d(logTag, sb2.toString());
                                                    break;
                                                default:
                                                    sb2 = new StringBuilder();
                                                    sb2.append("Unknown info code: ");
                                                    sb2.append(i2);
                                                    str3 = ", extra is ";
                                                    sb2.append(str3);
                                                    sb2.append(i22);
                                                    DebugLog.d(logTag, sb2.toString());
                                                    break;
                                            }
                                    }
                            }
                        } else {
                            i2 = IVideoView.MEDIA_INFO_DOWNLOAD_SPEED;
                        }
                    }
                    sb.append(str);
                    sb.append(i22);
                    str2 = sb.toString();
                    DebugLog.w(logTag, str2);
                } else {
                    String logTag10 = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.w(logTag10, "Unknown info, extra is " + i22);
                    i2 = 1;
                }
                if (MgtvAlphaVideoView.this.mOnInfoListener != null) {
                    MgtvAlphaVideoView.this.mOnInfoListener.onInfo(i2, i22);
                }
                return true;
            }
        };
        this.mInfoStringListener = new MgtvPlayerListener.OnInfoStringListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.7
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnInfoStringListener
            public boolean onInfo(int i2, String str) {
                if (i2 == 2860) {
                    String logTag = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.i(logTag, "MEDIA_INFO_SEI_SYS_TIMESTAMP: " + str);
                    return false;
                }
                String logTag2 = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag2, "OnInfoStringListener what: " + i2 + ", extra is " + str);
                return false;
            }
        };
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.8
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.w(logTag, "onError what:" + i2 + ",extra:" + i22);
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvAlphaVideoView.mMediaPlayer;
                if (mgtvMediaPlayer == null || i2 != 7000006) {
                    if (mgtvMediaPlayer != null && mgtvAlphaVideoView.mCurrentState != -1) {
                        MgtvAlphaVideoView.this.mMediaPlayer.stop();
                    }
                    MgtvAlphaVideoView.this.changeCurrentState(-1);
                    MgtvAlphaVideoView.this.mTargetState = -1;
                } else {
                    mgtvAlphaVideoView.releaseNoStatus();
                    MgtvAlphaVideoView.this.changeCurrentState(0);
                    MgtvAlphaVideoView.this.mTargetState = 0;
                }
                MgtvAlphaVideoView mgtvAlphaVideoView2 = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView2.mCurrentUri = null;
                mgtvAlphaVideoView2.mProxyUri = null;
                return mgtvAlphaVideoView2.mOnErrorListener != null && MgtvAlphaVideoView.this.mOnErrorListener.onError(i2, i22);
            }
        };
        this.mSeekCompleteListener = new MgtvPlayerListener.OnSeekCompleteListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.9
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSeekCompleteListener
            public void onSeekComplete(int i2, int i22) {
                if (MgtvAlphaVideoView.this.mOnSeekCompleteListener != null) {
                    String logTag = MgtvAlphaVideoView.this.getLogTag();
                    DebugLog.i(logTag, "onSeekComplete seekTargetTime:" + i2 + ",errorCode:" + i22);
                    MgtvAlphaVideoView.this.mOnSeekCompleteListener.onSeekComplete();
                }
            }
        };
        this.mBufferingUpdateListener = new MgtvPlayerListener.OnBufferingUpdateListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.10
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingUpdateListener
            public void onBufferingUpdate(int i2) {
                if (MgtvAlphaVideoView.this.mOnBufferringUpdateListener != null) {
                    MgtvAlphaVideoView.this.mOnBufferringUpdateListener.onBufferingUpdate(i2);
                }
            }
        };
        this.mBufferingTimeoutListener = new MgtvPlayerListener.OnBufferingTimeoutListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.11
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingTimeoutListener
            public boolean onBufferingTimeout(int i2, int i22) {
                MgtvMediaPlayer mgtvMediaPlayer = MgtvAlphaVideoView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.stop();
                }
                MgtvAlphaVideoView.this.changeCurrentState(-1);
                MgtvAlphaVideoView.this.mTargetState = -1;
                MgtvAlphaVideoView mgtvAlphaVideoView = MgtvAlphaVideoView.this;
                mgtvAlphaVideoView.mCurrentUri = null;
                mgtvAlphaVideoView.mProxyUri = null;
                if (mgtvAlphaVideoView.mOnErrorListener == null || MgtvAlphaVideoView.this.mOnErrorListener.onError(i2, i22)) {
                }
                return true;
            }
        };
        this.mSwitchSourceListener = new MgtvPlayerListener.OnSwitchSourceListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.12
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceComplete(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceComplete url:" + str + ",type:" + i2 + ",time:" + i22);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceSuccess(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceFailed(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceFailed url:" + str + ",what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceFailed(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceInfo(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceInfo url:" + str + ",event:" + i2 + ",time:" + i22);
                if (MgtvAlphaVideoView.this.mOnChangeSourceListener != null) {
                    MgtvAlphaVideoView.this.mOnChangeSourceListener.onChangeSourceInfo(str, i2, i22);
                }
            }
        };
        this.mPlayerWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.13
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "onTsSkip tsUrl:" + str);
                if (MgtvAlphaVideoView.this.mOnWarningListener != null) {
                    MgtvAlphaVideoView.this.mOnWarningListener.onTsSkip(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "player render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvAlphaVideoView.this.mOnWarningListener != null) {
                    MgtvAlphaVideoView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mGifRecorder = new GifRecorder();
        this.mStartListener = new MgtvPlayerListener.OnStartListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.14
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnStartListener
            public void onStart() {
                DebugLog.d(MgtvAlphaVideoView.this.getLogTag(), "mgtvcore onStart");
                if (MgtvAlphaVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvAlphaVideoView.this.callbackOnStart();
                }
            }
        };
        this.mPauseListener = new MgtvPlayerListener.OnPauseListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.15
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPauseListener
            public void onPause() {
                DebugLog.d(MgtvAlphaVideoView.this.getLogTag(), "mgtvcore onPause");
                if (MgtvAlphaVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvAlphaVideoView.this.callbackOnPause();
                }
            }
        };
        this.mRecordVideoListener = new MgtvPlayerListener.OnRecordVideoListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.16
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoErr(int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.e(logTag, "onRecordVideoErr what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnRecordListener != null) {
                    MgtvAlphaVideoView.this.mOnRecordListener.onRecordError(i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoInfo(int i2, int i22) {
                String logTag = MgtvAlphaVideoView.this.getLogTag();
                DebugLog.i(logTag, "onRecordVideoInfo what:" + i2 + ",extra:" + i22);
                if (MgtvAlphaVideoView.this.mOnRecordListener != null) {
                    if (i2 == 20) {
                        MgtvAlphaVideoView.this.mOnRecordListener.onRecordStart(MgtvAlphaVideoView.this.mRecordFilePath);
                    } else if (i2 == 30) {
                        MgtvAlphaVideoView.this.mOnRecordListener.onRecordStop();
                    }
                    MgtvAlphaVideoView.this.mOnRecordListener.onRecordInfo(i2, i22);
                }
            }
        };
        this.mLoadDataListener = new MgtvPlayerListener.OnLoadDataListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.17
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onAfterLoadDataPaused() {
                if (MgtvAlphaVideoView.this.mOnLoadDataListener != null) {
                    MgtvAlphaVideoView.this.mOnLoadDataListener.onAfterLoadDataPaused();
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onBeforeLoadDataResume() {
                if (MgtvAlphaVideoView.this.mOnLoadDataListener != null) {
                    MgtvAlphaVideoView.this.mOnLoadDataListener.onBeforeLoadDataResume();
                }
            }
        };
        if (configuration == null) {
            initVideoView(context);
            return;
        }
        this.mEnableTexture = configuration.enableTexture;
        this.mEnableOpengl = configuration.opengl;
        boolean z = configuration.isLiveMode;
        this.mIsLiveConfig = z;
        this.mEnableLiveMode = z;
        initVideoView(context, configuration.renderViewType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackOnPause() {
        changeCurrentState(4);
        IVideoView.OnPauseListener onPauseListener = this.mOnPauseListener;
        if (onPauseListener != null) {
            onPauseListener.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackOnStart() {
        changeCurrentState(3);
        IVideoView.OnStartListener onStartListener = this.mOnStartListener;
        if (onStartListener != null) {
            onStartListener.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeCurrentState(int i) {
        this.mCurrentState = i;
        String logTag = getLogTag();
        DebugLog.i(logTag, "changeCurrentState:" + i);
        IVideoView.OnUpdateStatusListener onUpdateStatusListener = this.mOnUpdateStatusListener;
        if (onUpdateStatusListener != null) {
            onUpdateStatusListener.onUpdateStatus();
        }
    }

    private void checkMemoryStatus(Context context) {
        ActivityManager.MemoryInfo memoryInfo;
        if (ImgoLibLoader.getInstance().isAllPlayerLibLoaded() || (memoryInfo = MemoryUtil.getMemoryInfo(context)) == null || !memoryInfo.lowMemory) {
            return;
        }
        this.mPlayerWarning.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_LOW_MEMORY, (memoryInfo.availMem >> 20) + "", "[" + memoryInfo.availMem + "-" + memoryInfo.lowMemory + "-" + memoryInfo.threshold + "]", null);
    }

    private void getFullScreenVideoParams() {
        int i = this.mVideoWidth;
        int i2 = this.mVideoHeight;
        float f = i / i2;
        DisplayMetrics displayMetrics = this.metrics;
        int i3 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        if (i3 / i4 < f) {
            int i5 = (i2 * i3) / i;
            int i6 = (i4 - i5) / 2;
            this.fromLeft = 0;
            this.fromTop = i6;
            this.fromRight = i3;
            i4 = i6 + i5;
        } else {
            int i7 = (i * i4) / i2;
            int i8 = (i3 - i7) / 2;
            this.fromLeft = i8;
            this.fromTop = 0;
            this.fromRight = i8 + i7;
        }
        this.fromBottom = i4;
        String logTag = getLogTag();
        DebugLog.i(logTag, "fromLeft:" + this.fromLeft + "/fromTop:" + this.fromTop + "/fromRight:" + this.fromRight + "/fromBottom:" + this.fromBottom);
    }

    public static String getVersion() {
        return MgtvMediaPlayer.MGTVPLAYER_VERSION;
    }

    private void initVideoView(Context context) {
        initVideoView(context, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initVideoView(Context context, int i) {
        this.mContext = context;
        this.metrics = context.getResources().getDisplayMetrics();
        this.mRenderViewType = i;
        if (i == 1) {
            this.mEnableTexture = false;
        }
        toggleRenders(i);
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        if (!Constants.FOR_OTT) {
            setFocusable(true);
            setFocusableInTouchMode(true);
            requestFocus();
        }
        if (context instanceof Activity) {
            ((Activity) context).setVolumeControlStream(3);
        }
        checkMemoryStatus(this.mContext);
        changeCurrentState(0);
        this.mTargetState = 0;
    }

    private boolean isInPlaybackState() {
        int i;
        return (this.mMediaPlayer == null || (i = this.mCurrentState) == -1 || i == 0 || i == 1) ? false : true;
    }

    private void openAudio() {
        this.mErrorMsg = "";
        if (this.mCurrentUri == null) {
            String logTag = getLogTag();
            DebugLog.e(logTag, "imgo openAudio: not ready for playback just yet, will try again later, mCurrentUri:" + this.mCurrentUri);
            return;
        }
        requestAudioFocus();
        release(false, true);
        try {
            Bundle bundle = new Bundle();
            bundle.putString(MgtvMediaPlayer.BUNDLE_KEY_LOG_TAG_KEY, getLogTagKey());
            bundle.putBoolean(MgtvMediaPlayer.BUNDLE_KEY_BOOLEAN_AUDIO_MODE, true);
            this.mMediaPlayer = new MgtvMediaPlayer(1, this.mContext, bundle);
            setLastMediaMode(1);
            this.mMediaPlayer.setConfig(201507067, 1);
            this.mMediaPlayer.setFlowDataStatistic(this.mFlowDataStatistic);
            FlowDataStatistic flowDataStatistic = this.mFlowDataStatistic;
            if (flowDataStatistic != null) {
                flowDataStatistic.setLogTag(getLogTag());
            }
            this.mMediaPlayer.setReportParams(this.mReportParams);
            configAudioImgoPlayer();
            super.initListener(this.mMediaPlayer);
            this.mMediaPlayer.setOnPreparedListener(this.mPreparedListener);
            this.mMediaPlayer.setOnStartListener(this.mStartListener);
            this.mMediaPlayer.setOnPauseListener(this.mPauseListener);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
            this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
            this.mMediaPlayer.setOnInfoListener(this.mInfoListener);
            this.mMediaPlayer.setOnInfoStringListener(this.mInfoStringListener);
            this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
            this.mMediaPlayer.setOnSeekCompleteListener(this.mSeekCompleteListener);
            this.mMediaPlayer.setOnBufferingTimeoutListener(this.mBufferingTimeoutListener);
            this.mMediaPlayer.setOnSwitchSourceListener(this.mSwitchSourceListener);
            this.mMediaPlayer.setOnWarningListener(this.mPlayerWarning);
            this.mMediaPlayer.setOnRecordVideoListener(this.mRecordVideoListener);
            this.mMediaPlayer.setOnLoadDataListener(this.mLoadDataListener);
            this.mFromSurfaceDestroyToPlay = false;
            this.mHasSurfaceHolderDestroy = false;
            if (this.mMainP2pTask == null && this.mProxyUri == null) {
                this.mMediaPlayer.setReadDataSourceType(0);
                this.mMediaPlayer.setDataSource(this.mCurrentUri.toString());
                this.mMediaPlayer.setSurface(this.mSurface);
                this.mMediaPlayer.setAudioStreamType(3);
                this.mMediaPlayer.setScreenOnWhilePlaying(this.mIsScreenOnWhilePlaying);
                this.mMediaPlayer.prepareAsync();
                changeCurrentState(1);
                DebugLog.i(getLogTag(), "openAudio is over");
            }
            MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
            String uri = this.mCurrentUri.toString();
            IP2pTask iP2pTask = this.mMainP2pTask;
            Uri uri2 = this.mProxyUri;
            mgtvMediaPlayer.setP2pDataSource(uri, iP2pTask, uri2 != null ? uri2.toString() : null, this.mStreamKey);
            this.mMediaPlayer.setSurface(this.mSurface);
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(this.mIsScreenOnWhilePlaying);
            this.mMediaPlayer.prepareAsync();
            changeCurrentState(1);
            DebugLog.i(getLogTag(), "openAudio is over");
        } catch (IOException e) {
            String logTag2 = getLogTag();
            DebugLog.w(logTag2, "Unable to open content: " + this.mCurrentUri);
            this.mErrorMsg = e.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_IO, 0);
        } catch (IllegalStateException e2) {
            String logTag3 = getLogTag();
            DebugLog.w(logTag3, "Unable to open content: " + this.mCurrentUri);
            this.mErrorMsg = e2.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_ILLEGAL_STATE, 0);
        } catch (NullPointerException e3) {
            String logTag4 = getLogTag();
            DebugLog.i(logTag4, "NullPointerException: " + this.mCurrentUri + ",details:" + e3.getMessage());
            this.mErrorMsg = e3.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_NULLPOINT, 0);
        } catch (SecurityException e4) {
            String logTag5 = getLogTag();
            DebugLog.i(logTag5, "SecurityException: " + this.mCurrentUri + ",details:" + e4.getMessage());
            this.mErrorMsg = e4.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SECURITY, 0);
        } catch (Exception e5) {
            String logTag6 = getLogTag();
            DebugLog.w(logTag6, "Unable to open content: " + this.mCurrentUri + ",details:" + e5.getMessage());
            this.mErrorMsg = e5.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_OPENVIDEO_FAILED, 0);
        } catch (c e6) {
            String logTag7 = getLogTag();
            DebugLog.e(logTag7, "LibLoaderError: " + this.mCurrentUri + "details:" + e6.getMessage() + ",extra:" + e6.a());
            this.mErrorMsg = e6.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_LIB_NOTLOAD, e6.a());
        } catch (InvalidParameterException e7) {
            String logTag8 = getLogTag();
            DebugLog.w(logTag8, "Unable to open content: " + this.mCurrentUri);
            this.mErrorMsg = e7.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SURFACE_FAILED, 3);
        } catch (IllegalArgumentException e8) {
            String logTag9 = getLogTag();
            DebugLog.w(logTag9, "Unable to open content: " + this.mCurrentUri + ",details:" + e8.getMessage());
            this.mErrorMsg = e8.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_ILLEGAL_ARGUMENT, 0);
        } catch (OutOfMemoryError e9) {
            String logTag10 = getLogTag();
            DebugLog.i(logTag10, "OutOfMemoryError: " + this.mCurrentUri + ",details:" + e9.getMessage());
            this.mErrorMsg = e9.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_OUTOFMEM, 0);
        } catch (UnsatisfiedLinkError e10) {
            String logTag11 = getLogTag();
            DebugLog.i(logTag11, "UnsatisfiedLinkError: " + this.mCurrentUri + ",details:" + e10.getMessage());
            this.mErrorMsg = e10.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_LIB_NOTLOAD, 0);
        } catch (Throwable th) {
            String logTag12 = getLogTag();
            DebugLog.i(logTag12, "Throwable: " + this.mCurrentUri + ",details:" + th.getMessage());
            this.mErrorMsg = th.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_OPENVIDEO_FAILED, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openVideo() {
        openVideo(this.mMgtvMediaPlayerHardwareMode);
    }

    private void openVideo(boolean z) {
        Surface surface;
        MgtvMediaPlayer mgtvMediaPlayer;
        MgtvMediaPlayer mgtvMediaPlayer2;
        this.mErrorMsg = "";
        release(false, true);
        if (this.mCurrentUri == null || (surface = this.mSurface) == null) {
            String logTag = getLogTag();
            DebugLog.e(logTag, "imgo openVideo: not ready for playback just yet, will try again later, mCurrentUri:" + this.mCurrentUri + ", mSurfaceHolder:" + this.mSurface);
            if (this.mCurrentUri == null || this.mSurface != null) {
                return;
            }
            this.mNonSurfaceHolderPVTimestamp = System.currentTimeMillis();
            this.mOpenVideoWhenSurfaceCreate = true;
        } else if (this.mGLView == null) {
            MgtvPlayerListener.OnErrorListener onErrorListener = this.mErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(IVideoView.MEDIA_ERROR_NULLPOINT, 0);
            }
            this.mErrorMsg = "openVideo renderView is null";
            DebugLog.e(getLogTag(), this.mErrorMsg);
        } else if (surface == null || !surface.isValid()) {
            MgtvPlayerListener.OnErrorListener onErrorListener2 = this.mErrorListener;
            if (onErrorListener2 != null) {
                onErrorListener2.onError(IVideoView.MEDIA_ERROR_SURFACE_FAILED, 0);
            }
            this.mErrorMsg = "openVideo surface is invalid";
            if (this.mSurface != null) {
                String logTag2 = getLogTag();
                DebugLog.e(logTag2, "openVideo surface is invalid " + this.mSurface);
            }
        } else {
            if (this.isRequestAudioFocus) {
                requestAudioFocus();
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putString(MgtvMediaPlayer.BUNDLE_KEY_LOG_TAG_KEY, getLogTagKey());
                boolean z2 = this.mIsLiveConfig;
                if (this.mUseSystemPlayer) {
                    mgtvMediaPlayer = new MgtvMediaPlayer(0, this.mContext, false, bundle);
                } else {
                    if (z) {
                        mgtvMediaPlayer2 = new MgtvMediaPlayer(2, this.mContext, this.mEnableTexture, z2 ? 1 : 0, bundle);
                    } else {
                        this.mEnableTexture = false;
                        mgtvMediaPlayer2 = new MgtvMediaPlayer(1, this.mContext, this.mEnableTexture, z2 ? 1 : 0, bundle);
                    }
                    mgtvMediaPlayer = mgtvMediaPlayer2;
                }
                this.mMediaPlayer = mgtvMediaPlayer;
                setLastMediaMode(0);
                this.mMediaPlayer.setFlowDataStatistic(this.mFlowDataStatistic);
                FlowDataStatistic flowDataStatistic = this.mFlowDataStatistic;
                if (flowDataStatistic != null) {
                    flowDataStatistic.setLogTag(getLogTag());
                }
                this.mMediaPlayer.setReportParams(this.mReportParams);
                configImgoPlayer();
                super.initListener(this.mMediaPlayer);
                this.mMediaPlayer.setOnPreparedListener(this.mPreparedListener);
                this.mMediaPlayer.setOnStartListener(this.mStartListener);
                this.mMediaPlayer.setOnPauseListener(this.mPauseListener);
                this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
                this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
                this.mMediaPlayer.setOnInfoListener(this.mInfoListener);
                this.mMediaPlayer.setOnInfoStringListener(this.mInfoStringListener);
                this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
                this.mMediaPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
                this.mMediaPlayer.setOnSeekCompleteListener(this.mSeekCompleteListener);
                this.mMediaPlayer.setOnBufferingTimeoutListener(this.mBufferingTimeoutListener);
                this.mMediaPlayer.setOnSwitchSourceListener(this.mSwitchSourceListener);
                this.mMediaPlayer.setOnWarningListener(this.mPlayerWarning);
                this.mMediaPlayer.setOnRecordVideoListener(this.mRecordVideoListener);
                this.mMediaPlayer.setOnLoadDataListener(this.mLoadDataListener);
                this.mFromSurfaceDestroyToPlay = false;
                this.mHasSurfaceHolderDestroy = false;
                if (this.mMainP2pTask == null && this.mProxyUri == null) {
                    this.mMediaPlayer.setReadDataSourceType(0);
                    this.mMediaPlayer.setDataSource(this.mCurrentUri.toString());
                    this.mMediaPlayer.setSurface(this.mSurface);
                    this.mMediaPlayer.setAudioStreamType(3);
                    this.mMediaPlayer.setScreenOnWhilePlaying(this.mIsScreenOnWhilePlaying);
                    this.mMediaPlayer.prepareAsync();
                    changeCurrentState(1);
                    DebugLog.i(getLogTag(), "openVideo is over");
                }
                MgtvMediaPlayer mgtvMediaPlayer3 = this.mMediaPlayer;
                String uri = this.mCurrentUri.toString();
                IP2pTask iP2pTask = this.mMainP2pTask;
                Uri uri2 = this.mProxyUri;
                mgtvMediaPlayer3.setP2pDataSource(uri, iP2pTask, uri2 != null ? uri2.toString() : null, this.mStreamKey);
                this.mMediaPlayer.setSurface(this.mSurface);
                this.mMediaPlayer.setAudioStreamType(3);
                this.mMediaPlayer.setScreenOnWhilePlaying(this.mIsScreenOnWhilePlaying);
                this.mMediaPlayer.prepareAsync();
                changeCurrentState(1);
                DebugLog.i(getLogTag(), "openVideo is over");
            } catch (IOException e) {
                String logTag3 = getLogTag();
                DebugLog.w(logTag3, "Unable to open content: " + this.mCurrentUri);
                this.mErrorMsg = e.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_IO, 0);
            } catch (IllegalStateException e2) {
                String logTag4 = getLogTag();
                DebugLog.w(logTag4, "Unable to open content: " + this.mCurrentUri);
                this.mErrorMsg = e2.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_ILLEGAL_STATE, 0);
            } catch (NullPointerException e3) {
                String logTag5 = getLogTag();
                DebugLog.i(logTag5, "NullPointerException: " + this.mCurrentUri + ",details:" + e3.getMessage());
                this.mErrorMsg = e3.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_NULLPOINT, 0);
            } catch (SecurityException e4) {
                String logTag6 = getLogTag();
                DebugLog.i(logTag6, "SecurityException: " + this.mCurrentUri + ",details:" + e4.getMessage());
                this.mErrorMsg = e4.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SECURITY, 0);
            } catch (c e5) {
                String logTag7 = getLogTag();
                DebugLog.e(logTag7, "LibLoaderError: " + this.mCurrentUri + "details:" + e5.getMessage() + ",extra:" + e5.a());
                this.mErrorMsg = e5.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_LIB_NOTLOAD, e5.a());
            } catch (OutOfMemoryError e6) {
                String logTag8 = getLogTag();
                DebugLog.i(logTag8, "OutOfMemoryError: " + this.mCurrentUri + ",details:" + e6.getMessage());
                this.mErrorMsg = e6.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_OUTOFMEM, 0);
            } catch (UnsatisfiedLinkError e7) {
                String logTag9 = getLogTag();
                DebugLog.i(logTag9, "UnsatisfiedLinkError: " + this.mCurrentUri + ",details:" + e7.getMessage());
                this.mErrorMsg = e7.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_LIB_NOTLOAD, 0);
            } catch (InvalidParameterException e8) {
                String logTag10 = getLogTag();
                DebugLog.w(logTag10, "Unable to open content: " + this.mCurrentUri);
                this.mErrorMsg = e8.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SURFACE_FAILED, 3);
            } catch (IllegalArgumentException e9) {
                String logTag11 = getLogTag();
                DebugLog.w(logTag11, "Unable to open content: " + this.mCurrentUri + ",details:" + e9.getMessage());
                this.mErrorMsg = e9.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_ILLEGAL_ARGUMENT, 0);
            } catch (Exception e10) {
                String logTag12 = getLogTag();
                DebugLog.w(logTag12, "Unable to open content: " + this.mCurrentUri + ",details:" + e10.getMessage());
                this.mErrorMsg = e10.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_OPENVIDEO_FAILED, 0);
            } catch (Throwable th) {
                String logTag13 = getLogTag();
                DebugLog.i(logTag13, "Throwable: " + this.mCurrentUri + ",details:" + th.getMessage());
                this.mErrorMsg = th.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_OPENVIDEO_FAILED, 1);
            }
        }
    }

    private void pauseInner() {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            DebugLog.i(getLogTag(), "pause play");
            this.mMediaPlayer.pause();
            if (this.mEnableCoreStartPauseListen) {
                return;
            }
            callbackOnPause();
        }
    }

    private void release(boolean z, MgtvAlphaAbstractVideoView.ReleaseReason releaseReason) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "release player.clear.cleartargetstate:" + z);
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            if (z) {
                mgtvMediaPlayer.stop();
            }
            resetDataBefore(releaseReason);
            releaseNoStatus();
            setLastMediaMode(0);
            changeCurrentState(0);
            if (z) {
                this.mTargetState = 0;
            }
            resetDataAfter(releaseReason);
        }
        if (releaseReason == MgtvAlphaAbstractVideoView.ReleaseReason.OUT) {
            abandonAudioFocus();
        }
    }

    private void release(boolean z, boolean z2) {
        release(z, z2 ? MgtvAlphaAbstractVideoView.ReleaseReason.DEFAULT_INNER : MgtvAlphaAbstractVideoView.ReleaseReason.OUT);
    }

    private ResetResult resetImpl(boolean z) {
        if (this.mMediaPlayer != null) {
            resetDataBefore(z ? MgtvAlphaAbstractVideoView.ReleaseReason.DEFAULT_INNER : MgtvAlphaAbstractVideoView.ReleaseReason.OUT);
            boolean reset = this.mMediaPlayer.reset();
            if (reset) {
                changeCurrentState(0);
                this.mTargetState = 0;
            }
            resetDataAfter(z ? MgtvAlphaAbstractVideoView.ReleaseReason.DEFAULT_INNER : MgtvAlphaAbstractVideoView.ReleaseReason.OUT);
            return reset ? ResetResult.RESET_OK : ResetResult.RESET_ERR;
        }
        return ResetResult.NONE;
    }

    private void setAudioURI(Uri uri) {
        this.mNonSurfaceHolderPVTimestamp = 0L;
        this.mCurrentUri = uri;
        this.mSeekWhenPrepared = 0;
        openAudio();
    }

    private void setRender(int i) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "setRender render:" + i);
        setRenderView(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setRenderView(int i) {
        int i2;
        int i3 = -1;
        if (this.mGLView != null) {
            MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
            if (mgtvMediaPlayer != null) {
                mgtvMediaPlayer.setSurfaceHolder(null);
            }
            View view = this.mGLView.getView();
            if (view != null) {
                DebugLog.i(getLogTag(), "setRenderView removeRenderView");
                i3 = indexOfChild(view);
                removeView(view);
            }
            this.mGLView = null;
        }
        this.mRenderType = 0;
        this.mEnhanceQualityType = 0;
        ReportParams reportParams = this.mReportParams;
        if (reportParams != null) {
            reportParams.setRenderType(0);
            this.mReportParams.setEnhanceQualityType(0);
        }
        this.mGLView = this.mRenderViewType == 1 ? new MgtvGLSurfaceView(getContext()) : new MgtvGLTextureView(getContext());
        IAlphaRenderView iAlphaRenderView = this.mGLView;
        if (iAlphaRenderView == null) {
            return;
        }
        iAlphaRenderView.setEGLContextClientVersion(2);
        this.mGLView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        int i4 = this.mVideoWidth;
        if (i4 > 0 && (i2 = this.mVideoHeight) > 0) {
            this.mGLView.setVideoSize(i4, i2);
        }
        View view2 = this.mGLView.getView();
        if (view2 != null) {
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            setSecureImpl(this.mIsSecure);
            DebugLog.i(getLogTag(), "setRenderView addRenderView");
            if (i3 >= 0) {
                addView(view2, i3);
            } else {
                addView(view2);
            }
        }
        if (this.mTransRender == null) {
            AlphaRenderer alphaRenderer = new AlphaRenderer();
            this.mTransRender = alphaRenderer;
            alphaRenderer.setOnSurfacePrepareListener(new AlphaRenderer.OnSurfacePrepareListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.1
                @Override // com.hunantv.media.alpha.AlphaRenderer.OnSurfacePrepareListener
                public void surfacePrepared(Surface surface) {
                    MgtvAlphaVideoView.this.mSurface = surface;
                    ThreadUtil.postOnUiThread(new Runnable() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MgtvAlphaVideoView.this.openVideo();
                        }
                    });
                }
            });
            this.mTransRender.setOnSurfaceErrorListener(new AlphaRenderer.OnSurfaceErrorListener() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.2
                @Override // com.hunantv.media.alpha.AlphaRenderer.OnSurfaceErrorListener
                public void surfaceError(final int i5, String str) {
                    ThreadUtil.postOnUiThread(new Runnable() { // from class: com.hunantv.media.alpha.MgtvAlphaVideoView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MgtvAlphaVideoView.this.stop();
                            MgtvAlphaVideoView.this.mErrorListener.onError(IVideoView.MEDIA_ERROR_OPENGL, i5);
                        }
                    });
                }
            });
        }
        IAlphaRenderView iAlphaRenderView2 = this.mGLView;
        if (iAlphaRenderView2 != null) {
            iAlphaRenderView2.setPreserveEGLContextOnPause(true);
            this.mGLView.setOpaque(false);
            this.mGLView.setRenderer(this.mTransRender);
        }
    }

    private void setSecureImpl(boolean z) {
        IAlphaRenderView iAlphaRenderView = this.mGLView;
        if (iAlphaRenderView == null || !(iAlphaRenderView.getView() instanceof GLSurfaceView) || Build.VERSION.SDK_INT < 17) {
            return;
        }
        String logTag = getLogTag();
        DebugLog.i(logTag, "setSecure " + z);
        ((GLSurfaceView) this.mGLView.getView()).setSecure(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setVideoURI(Uri uri) {
        this.mNonSurfaceHolderPVTimestamp = 0L;
        this.mCurrentUri = uri;
        this.mSeekWhenPrepared = 0;
        openVideo();
        requestLayout();
        invalidate();
    }

    private void updateDataCacheSizeKB() {
        MgtvMediaPlayer mgtvMediaPlayer;
        int i = this.mDataCacheSizeKB;
        if (i <= 0 || (mgtvMediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        mgtvMediaPlayer.configDSMemoryKeepSize(i, i);
    }

    private void updateSkipLoopFilter() {
        if (this.mMediaPlayer != null) {
            String logTag = getLogTag();
            DebugLog.i(logTag, "updateSkipLoopFilter:" + this.mSkipLoopFilterType);
            this.mMediaPlayer.setSkipLoopFilter(this.mSkipLoopFilterType);
        }
    }

    private void updateVodDefaultDnsType() {
        ReportParams reportParams;
        if (this.mOpenAddrDefaultConfig && (reportParams = this.mReportParams) != null && reportParams.getVideoType() == ReportParams.VideoType.VOD) {
            this.mAddrInfoType = MgtvMediaPlayer.AddrinfoType.TYPE_DNS_CACHE;
            this.mBackJavaDns = true;
            this.mPrepared4StartMode = MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_LOADDATA;
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void changeSourceAsync(IVideoView.MediaSource mediaSource, int i, int i2, int i3) {
        String str;
        IP2pTask iP2pTask;
        if (mediaSource == null) {
            IVideoView.OnChangeSourceListener onChangeSourceListener = this.mOnChangeSourceListener;
            if (onChangeSourceListener != null) {
                onChangeSourceListener.onChangeSourceFailed(null, IVideoView.MEDIA_ERROR_ILLEGAL_ARGUMENT, 0);
                return;
            }
            return;
        }
        int i4 = mediaSource.readType;
        String str2 = mediaSource.url;
        IP2pTask iP2pTask2 = mediaSource.p2pTask;
        String str3 = mediaSource.proxyUrl;
        if (this.mMediaPlayer != null) {
            if (i4 != 0) {
                if (iP2pTask2 == null) {
                    try {
                        if (StringUtil.isEmpty(str3)) {
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        IVideoView.OnChangeSourceListener onChangeSourceListener2 = this.mOnChangeSourceListener;
                        if (onChangeSourceListener2 != null) {
                            onChangeSourceListener2.onChangeSourceFailed(str2, IVideoView.MEDIA_ERROR_ILLEGAL_ARGUMENT, 0);
                            return;
                        }
                        return;
                    } catch (Exception unused) {
                        IVideoView.OnChangeSourceListener onChangeSourceListener3 = this.mOnChangeSourceListener;
                        if (onChangeSourceListener3 != null) {
                            onChangeSourceListener3.onChangeSourceFailed(str2, IVideoView.MEDIA_ERROR_OPENVIDEO_FAILED, 0);
                            return;
                        }
                        return;
                    }
                }
                iP2pTask = iP2pTask2;
                this.mMediaPlayer.switchP2pVideoSource(i4, str2, iP2pTask2, str3, i, i2, i3);
                str = str3;
                String logTag = getLogTag();
                DebugLog.i(logTag, "changeSourceAsync url:" + str2);
                String logTag2 = getLogTag();
                DebugLog.i(logTag2, "changeSourceAsync p2pTask:" + iP2pTask);
                String logTag3 = getLogTag();
                DebugLog.i(logTag3, "changeSourceAsync proxyUrl:" + str);
                String logTag4 = getLogTag();
                DebugLog.i(logTag4, "changeSourceAsync type:" + i + "src:" + i2 + ",dst:" + i3);
            }
            str = str3;
            iP2pTask = iP2pTask2;
            mediaSource.readType = 0;
            if (StringUtil.isEmpty(str2)) {
                IVideoView.OnChangeSourceListener onChangeSourceListener4 = this.mOnChangeSourceListener;
                if (onChangeSourceListener4 != null) {
                    onChangeSourceListener4.onChangeSourceFailed(str2, IVideoView.MEDIA_ERROR_ILLEGAL_ARGUMENT, 0);
                    return;
                }
                return;
            }
            this.mMediaPlayer.switchVideoSource(str2, i, i2, i3);
            String logTag5 = getLogTag();
            DebugLog.i(logTag5, "changeSourceAsync url:" + str2);
            String logTag22 = getLogTag();
            DebugLog.i(logTag22, "changeSourceAsync p2pTask:" + iP2pTask);
            String logTag32 = getLogTag();
            DebugLog.i(logTag32, "changeSourceAsync proxyUrl:" + str);
            String logTag42 = getLogTag();
            DebugLog.i(logTag42, "changeSourceAsync type:" + i + "src:" + i2 + ",dst:" + i3);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void changeSourceAsync(String str, int i, int i2, int i3) {
        changeSourceAsync(new IVideoView.MediaSource().setReadType(0).setUrl(str), i, i2, i3);
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void cleanUri() {
        DebugLog.i(getLogTag(), "cleanUri");
        this.mCurrentUri = null;
        this.mProxyUri = null;
    }

    @Override // com.hunantv.media.alpha.MgtvAlphaAbstractVideoView
    public void configAudioImgoPlayer() {
        MgtvMediaPlayer mgtvMediaPlayer;
        MgtvMediaPlayer.PlayerModeType playerModeType;
        super.configAudioImgoPlayer();
        this.mOpenVideoWhenSurfaceCreate = false;
        ReportParams reportParams = this.mReportParams;
        if (reportParams != null) {
            reportParams.setAddrInfoInt(this.mAddrInfoTypeInt);
        }
        if (this.mDnsFamilyType == 1) {
            updateVodDefaultDnsType();
        } else {
            setNetAddrinfo(0, -1);
        }
        MgtvMediaPlayer mgtvMediaPlayer2 = this.mMediaPlayer;
        if (mgtvMediaPlayer2 != null) {
            mgtvMediaPlayer2.setTimeout(this.mConnectTimeOut, this.mReciveDataTimeOut, this.mBufferTimeoutMs);
            this.mMediaPlayer.setDataSourceType(this.mDataSourceType);
            this.mMediaPlayer.setAccurateSeekEnable(true);
            this.mMediaPlayer.setNetAddrinfo(this.mAddrInfoType, this.mAddrInfoTimeoutMs, this.mJavaDnsEnable, this.mJavaDnsType, this.mNativeDnsAsyncEnable, this.mBackJavaDns);
            this.mMediaPlayer.configTsNotSkip(this.mTsNotSkip);
            int i = this.mLoadMaxRetryTime;
            if (i > 0) {
                this.mMediaPlayer.configLoadMaxRetryTime(i);
            }
            int i2 = this.mWeakNetSpeed;
            if (i2 > 0) {
                this.mMediaPlayer.configWeakBufferSpeed(i2);
            }
            int i3 = this.mWeakBufferTimeoutMs;
            if (i3 > 0) {
                this.mMediaPlayer.configWeakBufferTimeout(i3);
            }
            float f = this.mLeftVolume;
            if (f >= 0.0f) {
                float f2 = this.mRightVolume;
                if (f2 >= 0.0f) {
                    this.mMediaPlayer.setVolume(f, f2);
                }
            }
            if (this.mMediaPlayer.isMgtvCore() && this.mUserEnableCoreStartPauseListen) {
                this.mEnableCoreStartPauseListen = true;
            } else {
                this.mEnableCoreStartPauseListen = false;
            }
            this.mMediaPlayer.setPlaybackSpeed(this.mPlaySpeed);
            this.mMediaPlayer.setLiveStartIndex(this.mLiveStartIndex);
            if (this.mEnableLiveMode) {
                this.mLastFrameRecovery = false;
                mgtvMediaPlayer = this.mMediaPlayer;
                playerModeType = MgtvMediaPlayer.PlayerModeType.TYPE_PLAYER_MODE_LIVE;
            } else {
                mgtvMediaPlayer = this.mMediaPlayer;
                playerModeType = MgtvMediaPlayer.PlayerModeType.TYPE_PLAYER_MODE_NORMAL;
            }
            mgtvMediaPlayer.setEnablePlayerMode(playerModeType);
            int i4 = this.mStartPosMs;
            if (i4 > 0) {
                this.mMediaPlayer.setPlayerSeekAtStartPosMs(i4);
                String logTag = getLogTag();
                DebugLog.i(logTag, "configImgoPlayer mStartPosMs:" + this.mStartPosMs);
            }
            this.mMediaPlayer.enableTsSkipError(this.mEnableTsSkipError);
            this.mMediaPlayer.setHttpDnsNeedRetry(this.mEnableHttpDnsRetry);
            this.mMediaPlayer.setP2pHttpDns(this.mEnableP2pHttpDns, false);
            this.mMediaPlayer.setEnableDnsNoNetStrategy(this.mEnableDnsNoNetStrategy);
            String logTag2 = getLogTag();
            DebugLog.i(logTag2, "configImgoPlayer 1 mConnectTimeOut:" + this.mConnectTimeOut + ",mReciveDataTimeOut:" + this.mReciveDataTimeOut + ",mBufferTimeoutMs:" + this.mBufferTimeoutMs + ",mDataSourceType:" + this.mDataSourceType + ",mAccurateSeekEnable:" + this.mAccurateSeekEnable + ",mAddrInfoType:" + this.mAddrInfoType + ",mAddrInfoTimeoutMs:" + this.mAddrInfoTimeoutMs + ",mJavaDnsEnable:" + this.mJavaDnsEnable + ",mJavaDnsType:" + this.mJavaDnsType + ",mPlaySpeed:" + this.mPlaySpeed + ",mLiveStartIndex:" + this.mLiveStartIndex + ",mEnableLiveMode:" + this.mEnableLiveMode);
            String logTag3 = getLogTag();
            StringBuilder sb = new StringBuilder();
            sb.append("configImgoPlayer mReadDataSourceTypeConfig:");
            sb.append(this.mReadDataSourceTypeConfig);
            sb.append(",mNativeDnsAsyncEnable:");
            sb.append(this.mNativeDnsAsyncEnable);
            sb.append(",mEnableTsSkipError:");
            sb.append(this.mEnableTsSkipError);
            sb.append(",mHlsMD5CheckValue:");
            sb.append(this.mHlsMD5CheckValue);
            sb.append(",mEnableMgtvMediaCodec:");
            sb.append(this.mEnableMgtvMediaCodec);
            sb.append(",mEnableHttpDnsRetry:");
            sb.append(this.mEnableHttpDnsRetry);
            sb.append(",mEnableP2pHttpDns:");
            sb.append(this.mEnableP2pHttpDns);
            sb.append(",mEnableDnsNoNetStrategy:");
            sb.append(this.mEnableDnsNoNetStrategy);
            DebugLog.i(logTag3, sb.toString());
            int i5 = (this.mNonSurfaceHolderPVTimestamp > 0L ? 1 : (this.mNonSurfaceHolderPVTimestamp == 0L ? 0 : -1));
            MgtvMediaPlayer mgtvMediaPlayer3 = this.mMediaPlayer;
            if (i5 > 0) {
                mgtvMediaPlayer3.setNetdSVCTimeMs(System.currentTimeMillis() - this.mNonSurfaceHolderPVTimestamp);
            } else {
                mgtvMediaPlayer3.setNetdSVCTimeMs(0L);
            }
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void configDataCacheSizeKB(int i) {
        this.mDataCacheSizeKB = i;
        updateDataCacheSizeKB();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0238  */
    @Override // com.hunantv.media.alpha.MgtvAlphaAbstractVideoView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void configImgoPlayer() {
        /*
            Method dump skipped, instructions count: 572
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.alpha.MgtvAlphaVideoView.configImgoPlayer():void");
    }

    @Override // com.hunantv.media.alpha.MgtvAlphaAbstractVideoView, com.hunantv.media.widget.IVideoView
    public void configLoadMaxRetryTime(int i) {
        this.mLoadMaxRetryTime = i;
    }

    @Override // com.hunantv.media.alpha.MgtvAlphaAbstractVideoView, com.hunantv.media.widget.IVideoView
    public void configTsNotSkip(boolean z) {
        this.mTsNotSkip = z;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void configWeakBufferTimeout(int i) {
        this.mWeakBufferTimeoutMs = i;
    }

    @Override // com.hunantv.media.alpha.MgtvAlphaAbstractVideoView, com.hunantv.media.widget.IVideoView
    public void configWeakNetSpeed(int i) {
        this.mWeakNetSpeed = i;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void convertRender(int i) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "convertRender to " + i);
        try {
            release(true, true);
        } catch (Exception unused) {
        }
        toggleRenders(i);
    }

    @Override // com.hunantv.media.alpha.MgtvAlphaAbstractVideoView
    public void defaultNetAddr() {
        super.defaultNetAddr();
        if (this.mDnsFamilyType != 1) {
            this.mAddrInfoType = MgtvMediaPlayer.AddrinfoType.TYPE_ADDRINFO_DEFAULT;
            return;
        }
        this.mAddrInfoType = MgtvMediaPlayer.AddrinfoType.TYPE_ADDRINFO_DEFAULT;
        this.mOpenAddrDefaultConfig = true;
        updateVodDefaultDnsType();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableCoreStartPauseListen(boolean z) {
        this.mUserEnableCoreStartPauseListen = z;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableM3u8Cache(boolean z) {
        this.mCacheEnable = z;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableSpatializer(boolean z) {
    }

    @Override // com.hunantv.media.widget.ISubtitle
    public void enableSubtitle(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableTsSkipError(boolean z) {
        this.mEnableTsSkipError = z;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getAddrInfoTypeInt() {
        return this.mAddrInfoTypeInt;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public IDrmSession getBindDrmSession() {
        return null;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getBitRate() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return (int) mgtvMediaPlayer.getVideoBitRate();
        }
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public long getBufferedPositionMs() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.getBufferedPositionMs();
        }
        return 0L;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getBufferingPercentage() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getBufferingPercent();
        }
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getCurrentPosition() {
        int i;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer == null || (i = this.mCurrentState) == 0 || i == 1) {
            return 0;
        }
        return mgtvMediaPlayer.getCurrentPosition();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getCurrentPositionUnsafe() {
        int i;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer == null || (i = this.mCurrentState) == 0 || i == 1) {
            return 0;
        }
        return mgtvMediaPlayer.getCurrentPositionUnSafe();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getCurrentStatus() {
        return this.mCurrentState;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getDLSpeedB() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.getCurDLSpeed();
        }
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public String getDLSpeedFormat() {
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMaximumFractionDigits(1);
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        float curDLSpeed = mgtvMediaPlayer != null ? mgtvMediaPlayer.getCurDLSpeed() / 1000.0f : 0.0f;
        return numberInstance.format(curDLSpeed) + "KB/S";
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getDuration() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getDuration();
        }
        return -1;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public String getErrorUrl() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.getErrorUrl();
            return "";
        }
        return "";
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getFPS() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.getVideoFPS();
        }
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public FlowDataStatistic getFlowDataStatistic() {
        return this.mFlowDataStatistic;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public GifRecorder getGifRecorder() {
        return this.mGifRecorder;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public String getLastErrorTypeCode() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.getLastErrorTypeCode();
        }
        return null;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public String getLogTag() {
        return "[" + getLogTagKey() + "][" + getClass().getSimpleName() + "]";
    }

    @Override // com.hunantv.media.widget.IVideoView
    public String getLogTagKey() {
        String videoTypeName = ReportParams.getVideoTypeName(ReportParams.VideoType.NONE);
        ReportParams reportParams = this.mReportParams;
        if (reportParams != null) {
            videoTypeName = ReportParams.getVideoTypeName(reportParams.getVideoType());
        }
        String str = MgtvAlphaAbstractVideoView.sAutoNativeStack ? "STACK-" : "";
        return str + videoTypeName + "-" + hashCode() + "-" + getRenderViewName();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getMemoryPlayType() {
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getMgtvAudioEffectChoice() {
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public float getPlaybackSpeed() {
        return this.mPlaySpeed;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public MgtvMediaPlayer.PlayerExtraInfo getPlayerExtraInfo() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.getPlayerExtraInfo();
        }
        return null;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public String getPlayerVersion() {
        return getVersion();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getReadDataSourceType() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        return mgtvMediaPlayer != null ? mgtvMediaPlayer.getReadDataSourceType() : this.mReadDataSourceTypeConfig;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public IVideoView.RenderFilter getRenderFilter() {
        return this.mRenderFilter;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public View getRenderView() {
        return this.mGLView.getView();
    }

    public String getRenderViewName() {
        return this.mRenderViewType == 1 ? "surface" : "texture";
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getRenderViewType() {
        return this.mRenderViewType;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public ReportParams getReportParams() {
        return this.mReportParams;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public Bitmap getSnapshot(int i, int i2) {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.getSnapshot(i, i2);
        }
        return null;
    }

    @Override // com.hunantv.media.widget.ISubtitle
    @Nullable
    public SubtitleSource getSubtitleSource() {
        return null;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getTotalBuffering() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.getBufferedPercentage();
        }
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getVideoHeight() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getVideoWidth() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.getVideoWidth() / 2;
        }
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isAccurateSeekEnable() {
        return this.mAccurateSeekEnable;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isCompletion() {
        return this.mCurrentState == 5;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isDataLoadPaused() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.isLoadDataPaused();
        }
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isHardware() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.isHardware();
        }
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isImgoSourceModuleOpen() {
        return ImgoLibLoader.getInstance().isDsLibLoaded() && this.mDataSourceType == MgtvMediaPlayer.DataSourceType.TYPE_DATASOUCE_IMGO;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isMgtvAudioEffectValid() {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isPlaying() {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isPrepared() {
        return isInPlaybackState();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isRecording() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.isRecording();
        }
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isRendered() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.isRendered();
        }
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isSupportedSnapshot() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.isSupportedSnapshot();
        }
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isTsSkipErrorEnable() {
        return this.mEnableTsSkipError;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void nativeCrashTest(int i) {
        MgtvMediaPlayer.NativeSoType nativeSoType = i != 1 ? i != 2 ? i != 3 ? MgtvMediaPlayer.NativeSoType.TYPE_NATIVESO_IMGOFFMPEG : MgtvMediaPlayer.NativeSoType.TYPE_NATIVESO_IMGODS : MgtvMediaPlayer.NativeSoType.TYPE_NATIVESO_IMGOMEDIAPLAYER : MgtvMediaPlayer.NativeSoType.TYPE_NATIVESO_IMGOHELP;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.nativeCrashTest(nativeSoType);
        }
    }

    @Override // com.hunantv.media.alpha.MgtvAlphaAbstractVideoView, com.hunantv.media.widget.IVideoView
    public void openImgoDSModule(boolean z) {
        if (this.mDataSourceInfo != null) {
            String logTag = getLogTag();
            DebugLog.i(logTag, "openImgoDSModule fileFormat:" + this.mDataSourceInfo.getFileFormat());
        }
        this.mDataSourceType = z ? MgtvMediaPlayer.DataSourceType.TYPE_DATASOUCE_IMGO : MgtvMediaPlayer.DataSourceType.TYPE_DATASOUCE_DEFAULT;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void pause() {
        pauseInner();
        this.mTargetState = 4;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void pauseLoadData() {
        DebugLog.i(getLogTag(), "call pauseLoadData. waiting call native pauseLoadData");
        if (isPrepared()) {
            MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
            if (mgtvMediaPlayer != null) {
                mgtvMediaPlayer.pauseLoadData();
                return;
            }
            return;
        }
        DebugLog.i(getLogTag(), "called pauseLoadData before preapred. release player");
        try {
            ReportParams reportParams = this.mReportParams;
            if (reportParams != null) {
                reportParams.getEnd().setInnerRetry(true);
            }
            release(true, MgtvAlphaAbstractVideoView.ReleaseReason.PAUSE_DATA_BEFORE_PREPEAD);
        } catch (Exception unused) {
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void reBindTexture() {
    }

    @Override // com.hunantv.media.alpha.MgtvAlphaAbstractVideoView, com.hunantv.media.widget.IVideoView
    public void release() {
        super.release();
        release(true, false);
        afterRelease();
    }

    @Override // com.hunantv.media.widget.ISubtitle
    public void removeSubtitleSource() {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void reset() {
        resetImpl(false);
    }

    @Override // com.hunantv.media.alpha.MgtvAlphaAbstractVideoView
    public void resetDataBefore(MgtvAlphaAbstractVideoView.ReleaseReason releaseReason) {
        super.resetDataBefore(releaseReason);
        this.mIsLive = false;
        if (releaseReason == MgtvAlphaAbstractVideoView.ReleaseReason.OUT) {
            this.mStartLeaveTimestamp = 0L;
            this.mCacheM3u8Path = null;
            this.mCacheTsPaths = null;
            this.mStartPosMs = 0;
            FlowDataStatistic flowDataStatistic = this.mFlowDataStatistic;
            if (flowDataStatistic != null && flowDataStatistic.isBindPlayerLifecycle()) {
                this.mFlowDataStatistic.reset();
            }
            this.mNonSurfaceHolderPVTimestamp = 0L;
        }
        if (releaseReason == MgtvAlphaAbstractVideoView.ReleaseReason.PAUSE_DATA_BEFORE_PREPEAD) {
            this.mReleasedByPauseLoadData = true;
        } else {
            this.mReleasedByPauseLoadData = false;
        }
        this.mOpenVideoWhenSurfaceCreate = false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void resetRender() {
        if (Constants.FOR_OTT && this.mEnableTexture) {
            this.mHasSurfaceHolderDestroy = true;
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void resetVideoPath(String str) {
        resetVideoPath(str, null, null);
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void resetVideoPath(String str, IP2pTask iP2pTask, String str2) {
        this.mNonSurfaceHolderPVTimestamp = 0L;
        if (str == null) {
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_INVALID_URL, 12);
        } else {
            this.mCurrentUri = Uri.parse(str.trim());
        }
        this.mMainP2pTask = iP2pTask;
        if (StringUtil.isEmpty(str2)) {
            this.mProxyUri = null;
        } else {
            this.mProxyUri = Uri.parse(str2.trim());
        }
        if (this.mMediaPlayer == null || isOnlyAudioMode()) {
            setVideoPath(str, iP2pTask, str2);
            return;
        }
        if (Build.VERSION.SDK_INT <= 22) {
            DebugLog.i(getLogTag(), "resetVideoPath need rebindTexture");
            this.mRebindTexture = true;
        } else {
            this.mRebindTexture = false;
        }
        if (this.mHasSurfaceHolderDestroy) {
            convertRender(this.mRenderViewType);
            return;
        }
        this.mMediaPlayer.setSurfaceHolder(null);
        ResetResult resetImpl = resetImpl(true);
        if (resetImpl == ResetResult.NONE) {
            setVideoPath(str, iP2pTask, str2);
        } else if (resetImpl == ResetResult.RESET_ERR) {
        } else {
            if (this.mSurface == null) {
                this.mNonSurfaceHolderPVTimestamp = System.currentTimeMillis();
                this.mOpenVideoWhenSurfaceCreate = true;
                return;
            }
            try {
                String logTag = getLogTag();
                DebugLog.e(logTag, "------chodison----reprepare MgtvMediaPlayer mMgtvMediaPlayerHardwareMode:" + this.mMgtvMediaPlayerHardwareMode + " url:" + this.mCurrentUri.toString());
                this.mMediaPlayer.setReportParams(this.mReportParams);
                configImgoPlayer();
                this.mFromSurfaceDestroyToPlay = false;
                this.mHasSurfaceHolderDestroy = false;
                String logTag2 = getLogTag();
                DebugLog.i(logTag2, "resetVideoPath streamKey:" + this.mStreamKey);
                if (this.mMainP2pTask == null && this.mProxyUri == null) {
                    this.mMediaPlayer.setReadDataSourceType(0);
                    this.mMediaPlayer.setDataSource(this.mCurrentUri.toString());
                    this.mMediaPlayer.setSurface(this.mSurface);
                    this.mMediaPlayer.prepareAsync();
                    changeCurrentState(1);
                }
                MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
                String uri = this.mCurrentUri.toString();
                IP2pTask iP2pTask2 = this.mMainP2pTask;
                Uri uri2 = this.mProxyUri;
                mgtvMediaPlayer.setP2pDataSource(uri, iP2pTask2, uri2 != null ? uri2.toString() : null, this.mStreamKey);
                this.mMediaPlayer.setSurface(this.mSurface);
                this.mMediaPlayer.prepareAsync();
                changeCurrentState(1);
            } catch (InvalidParameterException e) {
                this.mErrorMsg = e.getMessage();
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SURFACE_FAILED, 2);
                e.printStackTrace();
            } catch (Exception e2) {
                this.mErrorMsg = e2.getMessage();
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SETSOURCE_FAILED, 0);
                e2.printStackTrace();
            }
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void resume() {
        openVideo();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void resumeLoadData() {
        DebugLog.i(getLogTag(), "call resumeLoadData. waiting call native resumeLoadData");
        if (!this.mReleasedByPauseLoadData) {
            MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
            if (mgtvMediaPlayer != null) {
                mgtvMediaPlayer.resumeLoadData();
                return;
            }
            return;
        }
        this.mReleasedByPauseLoadData = false;
        if (this.mCurrentUri == null) {
            DebugLog.i(getLogTag(), "call resumeLoadData. mCurrentUri == null waiting setVideoPath");
            return;
        }
        DebugLog.i(getLogTag(), "call resumeLoadData. player release by call pauseLoadData.reopen it");
        resume();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void seekTo(int i) {
        if (isInPlaybackState()) {
            if (i >= 0) {
                if (this.mFromSurfaceDestroyToPlay) {
                    this.mFromSurfaceDestroyPlayPosition = i;
                }
                this.mMediaPlayer.seekTo(i);
                if (this.mSeekAutoStartAfterCompleteEnable && this.mCurrentState == 5) {
                    callbackOnStart();
                }
            }
            i = 0;
        }
        this.mSeekWhenPrepared = i;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void seekTo(int i, boolean z) {
        seekTo(i, z, false);
    }

    public void seekTo(int i, boolean z, boolean z2) {
        if (isInPlaybackState()) {
            if (i >= 0) {
                if (this.mFromSurfaceDestroyToPlay) {
                    this.mFromSurfaceDestroyPlayPosition = i;
                }
                String logTag = getLogTag();
                DebugLog.i(logTag, "seekTo msec:" + i);
                this.mMediaPlayer.seekTo(i, z, z2);
                if (this.mSeekAutoStartAfterCompleteEnable && this.mCurrentState == 5) {
                    callbackOnStart();
                }
            }
            i = 0;
        }
        this.mSeekWhenPrepared = i;
    }

    @Override // com.hunantv.media.alpha.MgtvAlphaAbstractVideoView, com.hunantv.media.widget.IVideoView
    @Deprecated
    public void setAccurateSeekEnable(boolean z) {
        this.mAccurateSeekEnable = z;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setAspectRatio(int i) {
        this.mAspectRatio = i;
        IAlphaRenderView iAlphaRenderView = this.mGLView;
        if (iAlphaRenderView != null) {
            iAlphaRenderView.setAspectRatio(i);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setAudioPath(@NonNull String str) {
        this.mMainP2pTask = null;
        this.mProxyUri = null;
        if (StringUtil.isEmpty(str)) {
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_INVALID_URL, 11);
        } else {
            setAudioURI(Uri.parse(str.trim()));
        }
    }

    @Override // com.hunantv.media.alpha.MgtvAlphaAbstractVideoView, com.hunantv.media.widget.IVideoView
    public void setBufferTimeout(int i) {
        this.mBufferTimeoutMs = i;
    }

    @Override // com.hunantv.media.alpha.MgtvAlphaAbstractVideoView, com.hunantv.media.widget.IVideoView
    public void setDisplayFloatRect(IMgtvRenderView.FloatRect floatRect) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setDrmInfoList(List<MgtvDrmParams.DrmInfo> list) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setFlowDataStatistic(FlowDataStatistic flowDataStatistic) {
        this.mFlowDataStatistic = flowDataStatistic;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setForceDecodeMode(boolean z) {
        this.mForceDecodeMode = z;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setLastFrameRecovery(boolean z) {
        this.mLastFrameRecovery = z;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setLiveMode(boolean z) {
        this.mIsLiveConfig = z;
        this.mEnableLiveMode = z;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setLiveReopen() {
        MgtvMediaPlayer mgtvMediaPlayer;
        if (!this.mEnableLiveMode || (mgtvMediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        mgtvMediaPlayer.setLiveReopen();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setLiveStartIndex(int i) {
        this.mLiveStartIndex = i;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setM3u8Caches(String str, String[] strArr) {
        this.mCacheM3u8Path = str;
        this.mCacheTsPaths = strArr;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setM3u8Caches(str, strArr);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setMgtvAudioEffectChoice(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int setMgtvAudioEffectConfig(byte[] bArr) {
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setMgtvAudioEffectEnable(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setNETIsBroken(boolean z) {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setNETIsBroken(z);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setNetAddrinfo(int i, int i2) {
        setNetAddrinfo(i, i2, false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ca  */
    @Override // com.hunantv.media.widget.IVideoView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setNetAddrinfo(int r6, int r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.alpha.MgtvAlphaVideoView.setNetAddrinfo(int, int, boolean):void");
    }

    @Override // com.hunantv.media.alpha.MgtvAlphaAbstractVideoView, com.hunantv.media.widget.IVideoView
    public void setNetAddrinfo(String str, int i, boolean z) {
        super.setNetAddrinfo(str, i, z);
        int i2 = NetPlayConfig.sConfigFastMode;
        if (i2 != 0) {
            if (i2 == 9) {
                i2 = 0;
            }
            setMgtvFastMode(i2);
        }
        int i3 = NetPlayConfig.sConfigP2pHttpDns;
        if (i3 != 0) {
            this.mEnableP2pHttpDns = i3 != 9;
        }
        int i4 = NetPlayConfig.sConfigMgtvMediaCodec;
        if (i4 != 0) {
            this.mEnableMgtvMediaCodec = i4 != 9;
        }
        String logTag = getLogTag();
        DebugLog.i(logTag, "setNetAddrinfo mMgtvFastMode:" + this.mMgtvFastMode + ",mEnableP2pHttpDns:" + this.mEnableP2pHttpDns + ",mEnableMgtvMediaCodec:" + this.mEnableMgtvMediaCodec);
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnBufferingUpdateListener(IVideoView.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferringUpdateListener = onBufferingUpdateListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnChangeSourceListener(IVideoView.OnChangeSourceListener onChangeSourceListener) {
        this.mOnChangeSourceListener = onChangeSourceListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnCompletionListener(IVideoView.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnErrorListener(IVideoView.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnEventInfoListener(IVideoView.OnEventInfoListener onEventInfoListener) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnInfoListener(IVideoView.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnInfoStringListener(IVideoView.OnInfoStringListener onInfoStringListener) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnLoadDataListener(IVideoView.OnLoadDataListener onLoadDataListener) {
        this.mOnLoadDataListener = onLoadDataListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnPauseListener(IVideoView.OnPauseListener onPauseListener) {
        this.mOnPauseListener = onPauseListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnPreparedListener(IVideoView.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnRecordListener(IVideoView.OnRecordListener onRecordListener) {
        this.mOnRecordListener = onRecordListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnSeekCompleteListener(IVideoView.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnSpatializerInfoListener(IVideoView.OnSpatializerInfoListener onSpatializerInfoListener) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnStartListener(IVideoView.OnStartListener onStartListener) {
        this.mOnStartListener = onStartListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnUpdateStatusListener(IVideoView.OnUpdateStatusListener onUpdateStatusListener) {
        this.mOnUpdateStatusListener = onUpdateStatusListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnVideoSizeChangedListener(IVideoView.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnWarningListener(MgtvPlayerListener.OnWarningListener onWarningListener) {
        this.mOnWarningListener = onWarningListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setPlaybackSpeed(float f) {
        this.mPlaySpeed = f;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setPlaybackSpeed(f);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setPlayerDebug(boolean z) {
        MgtvMediaPlayer.setPlayerDebug(z);
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setPlayerHardwareMode(boolean z) {
        this.mMgtvMediaPlayerHardwareMode = z;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setReadDataSourceType(int i) {
        this.mReadDataSourceTypeConfig = i;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setRenderFilter(IVideoView.RenderFilter renderFilter) {
        this.mRenderFilter = renderFilter;
        int i = AnonymousClass18.$SwitchMap$com$hunantv$media$widget$IVideoView$RenderFilter[renderFilter.ordinal()];
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setRenderViewVisible(int i) {
        IAlphaRenderView iAlphaRenderView = this.mGLView;
        if (iAlphaRenderView != null) {
            iAlphaRenderView.setVisibility(i);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setReportParams(ReportParams reportParams) {
        this.mReportParams = reportParams;
        if (reportParams != null) {
            reportParams.setRenderType(this.mRenderType);
            this.mReportParams.setEnhanceQualityType(this.mEnhanceQualityType);
            this.mReportParams.setVideoType(ReportParams.VideoType.ALPHA_PLAY);
        }
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setReportParams(this.mReportParams);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setScreenOnWhilePlaying(boolean z) {
        this.mIsScreenOnWhilePlaying = z;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setSecure(boolean z) {
        this.mIsSecure = z;
        setSecureImpl(z);
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setSkipLoopFilter(MgtvMediaPlayer.SkipLoopFilterType skipLoopFilterType) {
        this.mSkipLoopFilterType = skipLoopFilterType;
        updateSkipLoopFilter();
    }

    @Override // com.hunantv.media.alpha.MgtvAlphaAbstractVideoView, com.hunantv.media.widget.IVideoView
    public void setSmoothSwitchMode(int i) {
        super.setSmoothSwitchMode(i);
        this.mSmoothModeSwitch = i != 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setStartPosMs(int i) {
        this.mStartPosMs = i;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setStreamKey(int i) {
        this.mStreamKey = i;
    }

    @Override // com.hunantv.media.widget.ISubtitle
    public void setSubtitleCallback(ISubtitle.SubtitleCallback subtitleCallback) {
    }

    @Override // com.hunantv.media.widget.ISubtitle
    public void setSubtitleSource(SubtitleSource subtitleSource) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setSurfaceHolderListener(IVideoView.SurfaceHolderListener surfaceHolderListener) {
        this.mSurfaceHolderListener = surfaceHolderListener;
    }

    @Override // com.hunantv.media.alpha.MgtvAlphaAbstractVideoView, com.hunantv.media.widget.IVideoView
    public void setTimeout(int i, int i2) {
        this.mConnectTimeOut = i;
        this.mReciveDataTimeOut = i2;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setVideoDataSource(MgtvPlayerDataSource mgtvPlayerDataSource) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setVideoPath(String str) {
        setVideoPath(str, null, null);
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setVideoPath(String str, IP2pTask iP2pTask, String str2) {
        boolean z;
        String logTag = getLogTag();
        DebugLog.i(logTag, "setVideoPath:" + str);
        if (!this.mEnableTexture || Build.VERSION.SDK_INT > 22) {
            z = false;
        } else {
            DebugLog.i(getLogTag(), "setVideoPath need rebindTexture");
            z = true;
        }
        this.mRebindTexture = z;
        this.mMainP2pTask = iP2pTask;
        this.mProxyUri = StringUtil.isEmpty(str2) ? null : Uri.parse(str2.trim());
        if (str == null) {
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_INVALID_URL, 11);
        } else {
            setVideoURI(Uri.parse(str.trim()));
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setVolume(float f, float f2) {
        this.mLeftVolume = f;
        this.mRightVolume = f2;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setVolume(f, f2);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setZOrderMediaOverlay(boolean z) {
        IAlphaRenderView iAlphaRenderView = this.mGLView;
        if (iAlphaRenderView == null || iAlphaRenderView.getView() == null || !(this.mGLView.getView() instanceof SurfaceView)) {
            return;
        }
        ((SurfaceView) this.mGLView.getView()).setZOrderMediaOverlay(z);
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void start() {
        if (isInPlaybackState()) {
            if (this.isRequestAudioFocus) {
                requestAudioFocus();
            }
            int i = this.mCurrentState;
            if (i != 3) {
                if (i == 5) {
                    DebugLog.e(getLogTag(), "play video direct after complete");
                }
                resumeLoadData();
                this.mMediaPlayer.start();
                DebugLog.i(getLogTag(), "start play");
                if (!this.mEnableCoreStartPauseListen) {
                    callbackOnStart();
                }
            }
        }
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null && mgtvMediaPlayer.isLoadDataPaused()) {
            this.mMediaPlayer.resumeLoadData();
            DebugLog.i(getLogTag(), "start:resumeLoadData");
        }
        this.mTargetState = 3;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void startRecord(String str) {
        this.mRecordFilePath = str;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.startRecVideo(str);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void stopRecord() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.stopRecVideo();
        }
    }

    public void toggleRenders(int i) {
        this.mRenderViewType = i;
        setRender(i);
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void useSystemPlayer(boolean z) {
        this.mUseSystemPlayer = z;
    }
}
