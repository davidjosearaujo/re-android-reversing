package com.hunantv.media.widget;

import a.a.a.a.n.a;
import a.a.a.a.p.c;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import c.a.a.a.o.f;
import com.hunantv.media.config.NetPlayConfig;
import com.hunantv.media.global.Constants;
import com.hunantv.media.p2p.IP2pTask;
import com.hunantv.media.player.IMgtvRenderView;
import com.hunantv.media.player.MgtvMediaPlayer;
import com.hunantv.media.player.MgtvPlayerListener;
import com.hunantv.media.player.MgtvRenderView;
import com.hunantv.media.player.loader.ImgoLibLoader;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.player.statistic.FlowDataStatistic;
import com.hunantv.media.player.utils.StringUtil;
import com.hunantv.media.recoder.GifRecorder;
import com.hunantv.media.report.ReportParams;
import com.hunantv.media.utils.MemoryUtil;
import com.hunantv.media.widget.IVideoView;
import com.hunantv.media.widget.MgtvAbstractVideoView;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.text.NumberFormat;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgtvAudioView extends MgtvAbstractVideoView {
    private static final String LOGMSG_PLAYER_CALLBACK = "VideoViewCallBack";
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
    private f.a mFilterCallback;
    private FlowDataStatistic mFlowDataStatistic;
    private boolean mForceDecodeMode;
    private int mFromSurfaceDestroyPlayPosition;
    private boolean mFromSurfaceDestroyToPlay;
    private GifRecorder mGifRecorder;
    private boolean mHasSurfaceHolderDestroy;
    private int mHlsMD5CheckValue;
    private MgtvPlayerListener.OnInfoListener mInfoListener;
    private boolean mIsLive;
    private boolean mIsLiveConfig;
    private boolean mIsScreenOnWhilePlaying;
    private boolean mIsSecure;
    private a.d mJavaDnsType;
    private boolean mLastFrameRecovery;
    private volatile boolean mLastSurfaceDestroy;
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
    private boolean mRebindTexture;
    private String mRecordFilePath;
    private MgtvPlayerListener.OnRecordVideoListener mRecordVideoListener;
    private boolean mReleasedByPauseLoadData;
    private IVideoView.RenderFilter mRenderFilter;
    private int mRenderType;
    private MgtvRenderView mRenderView;
    private MgtvPlayerListener.OnWarningListener mRenderWarning;
    public IMgtvRenderView.IRenderCallback mSHCallback;
    private MgtvPlayerListener.OnSeekCompleteListener mSeekCompleteListener;
    private int mSeekWhenPrepared;
    public MgtvPlayerListener.OnVideoSizeChangedListener mSizeChangedListener;
    private MgtvMediaPlayer.SkipLoopFilterType mSkipLoopFilterType;
    private long mStartLeaveTimestamp;
    private MgtvPlayerListener.OnStartListener mStartListener;
    private int mStartPosMs;
    private int mStreamKey;
    private int mSurfaceHeight;
    private IVideoView.SurfaceHolderListener mSurfaceHolderListener;
    private int mSurfaceWidth;
    private MgtvPlayerListener.OnSwitchSourceListener mSwitchSourceListener;
    private int mTargetState;
    private boolean mTsNotSkip;
    private boolean mUseSystemPlayer;
    private boolean mUserEnableCoreStartPauseListen;
    private int mVideoHeight;
    private int mVideoRotationDegree;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private int mWeakBufferTimeoutMs;
    private int mWeakNetSpeed;
    private DisplayMetrics metrics;
    private int originalVideoHeight;
    private int originalVideoWidth;
    private a.a.a.b.a reportErrWithoutMpManager;
    private boolean shouldGetVideoParams;

    /* renamed from: com.hunantv.media.widget.MgtvAudioView$18  reason: invalid class name */
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

    public MgtvAudioView(Context context) {
        super(context);
        this.mLastSurfaceDestroy = true;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mMgtvMediaPlayerHardwareMode = false;
        this.mForceDecodeMode = false;
        this.mFromSurfaceDestroyToPlay = false;
        this.mFromSurfaceDestroyPlayPosition = 0;
        this.mErrorMsg = "";
        this.mHasSurfaceHolderDestroy = false;
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
        this.mEnableMgtvMediaCodec = true;
        this.mEnableJavaIPCache = false;
        this.mLastFrameRecovery = true;
        this.mWeakNetSpeed = 0;
        this.mWeakBufferTimeoutMs = 0;
        this.mTsNotSkip = false;
        this.mLoadMaxRetryTime = 0;
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
        this.mStartPosMs = 0;
        this.mFlowDataStatistic = new FlowDataStatistic();
        this.mSkipLoopFilterType = MgtvMediaPlayer.SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mSHCallback = new IMgtvRenderView.IRenderCallback() { // from class: com.hunantv.media.widget.MgtvAudioView.1
            private void bindHolder(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i, int i2) {
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                if (mgtvAudioView.mMediaPlayer == null) {
                    mgtvAudioView.openVideo();
                    return;
                }
                if (!mgtvAudioView.mEnableMediacodecSW && mgtvAudioView.mHasSurfaceHolderDestroy && MgtvAudioView.this.mRebindTexture) {
                    MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                    if (mgtvAudioView2.mCurrentUri != null) {
                        mgtvAudioView2.setStartPosMs(mgtvAudioView2.mMediaPlayer.getCurrentPosition());
                        MgtvAudioView.this.openVideo();
                    }
                }
                if (!needOpenVideo()) {
                    MgtvAudioView.this.mMediaPlayer.setSurfaceHolder(iSurfaceHolder);
                    MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                    if (mgtvAudioView3.mCurrentUri != null) {
                        if (mgtvAudioView3.mFromSurfaceDestroyToPlay && MgtvAudioView.this.mMgtvMediaPlayerHardwareMode) {
                            MgtvAudioView.this.mFromSurfaceDestroyToPlay = false;
                            MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                            mgtvAudioView4.mMediaPlayer.seekTo(mgtvAudioView4.mFromSurfaceDestroyPlayPosition, false, true);
                            MgtvAudioView.this.mFromSurfaceDestroyPlayPosition = 0;
                        }
                        if (MgtvAudioView.this.mLastFrameRecovery && (!MgtvAudioView.this.isHardware() || MgtvAudioView.this.mLastSurfaceDestroy)) {
                            MgtvAudioView.this.mMediaPlayer.setPlaybackStep();
                        }
                    }
                    MgtvAudioView mgtvAudioView5 = MgtvAudioView.this;
                    mgtvAudioView5.mSizeChangedListener.onVideoSizeChanged(mgtvAudioView5.mMediaPlayer.getVideoWidth(), MgtvAudioView.this.mMediaPlayer.getVideoHeight());
                    MgtvAudioView.this.autoStartByStateAndSize(i, i2);
                    return;
                }
                MgtvAudioView.this.openVideo();
            }

            private boolean needOpenVideo() {
                return MgtvAudioView.this.mOpenVideoWhenSurfaceCreate && MgtvAudioView.this.mCurrentUri != null;
            }

            private void videoSurfaceChanged(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i, int i2, int i3) {
                if (MgtvAudioView.this.mRenderView == null || iSurfaceHolder.getRenderView() == MgtvAudioView.this.mRenderView.getRenderView()) {
                    MgtvAudioView.this.autoStartByStateAndSize(i2, i3);
                } else {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceChanged: unmatched render callback\n");
                }
            }

            private void videoSurfaceCreate(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i, int i2) {
                SurfaceHolder surfaceHolder;
                if (MgtvAudioView.this.mRenderView != null && iSurfaceHolder.getRenderView() != MgtvAudioView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "videoSurfaceCreate " + iSurfaceHolder);
                if (MgtvAudioView.this.mRenderView == null || MgtvAudioView.this.mRenderView.getRenderViewType() != 0 || ((surfaceHolder = MgtvAudioView.this.mSurfaceHolder.getSurfaceHolder()) != null && surfaceHolder.getSurface() != null && surfaceHolder.getSurface().isValid())) {
                    bindHolder(iSurfaceHolder, i, i2);
                    return;
                }
                MgtvAudioView.this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SURFACE_FAILED, 1);
                MgtvAudioView.this.mErrorMsg = "surfaceCreated surface is invalid";
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceChanged(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i, int i2, int i3) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface changed. threadId:" + Thread.currentThread().getId());
                if (!MgtvAudioView.this.isOnlyAudioMode() && !MgtvAudioView.this.mBackPlayEnable) {
                    videoSurfaceChanged(iSurfaceHolder, i, i2, i3);
                }
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceChanged();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceCreated(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i, int i2) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface create. threadId:" + Thread.currentThread().getId());
                if (MgtvAudioView.this.mStartLeaveTimestamp > 0) {
                    long currentTimeMillis = (System.currentTimeMillis() - MgtvAudioView.this.mStartLeaveTimestamp) / 1000;
                    if (currentTimeMillis > 540) {
                        if (MgtvAudioView.this.mOnWarningListener != null) {
                            MgtvPlayerListener.OnWarningListener onWarningListener = MgtvAudioView.this.mOnWarningListener;
                            onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_LEAVE_TIME_INVALID, MgtvAudioView.this.mCurrentState + "", "", null);
                        }
                        ReportParams reportParams = MgtvAudioView.this.mReportParams;
                        if (reportParams != null) {
                            reportParams.setLeaveTimeS(currentTimeMillis);
                        }
                    }
                }
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                mgtvAudioView.mSurfaceHolder = iSurfaceHolder;
                if (!mgtvAudioView.isOnlyAudioMode() && !MgtvAudioView.this.mBackPlayEnable) {
                    videoSurfaceCreate(iSurfaceHolder, i, i2);
                }
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceCreated();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceDestroyed(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, boolean z) {
                MgtvMediaPlayer mgtvMediaPlayer;
                MgtvAudioView mgtvAudioView;
                IMgtvRenderView.ISurfaceHolder iSurfaceHolder2;
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface destroy. threadId:" + Thread.currentThread().getId());
                MgtvAudioView.this.mLastSurfaceDestroy = z;
                if (MgtvAudioView.this.mRenderView != null && iSurfaceHolder.getRenderView() != MgtvAudioView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceDestroyed: unmatched render callback\n");
                    return;
                }
                String logTag2 = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag2, "onSurfaceDestroyed " + iSurfaceHolder);
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceDestroyed();
                }
                if (z && (iSurfaceHolder2 = MgtvAudioView.this.mSurfaceHolder) != null) {
                    iSurfaceHolder2.releaseSurface();
                }
                MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                mgtvAudioView2.mSurfaceHolder = null;
                if (!mgtvAudioView2.isOnlyAudioMode()) {
                    MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                    if (!mgtvAudioView3.mBackPlayEnable) {
                        mgtvAudioView3.videoSurfaceDestroyed();
                        mgtvAudioView = MgtvAudioView.this;
                        if (mgtvAudioView.mCurrentUri != null || mgtvAudioView.mCurrentState == -1 || MgtvAudioView.this.mCurrentState == 5) {
                            return;
                        }
                        MgtvAudioView.this.mStartLeaveTimestamp = System.currentTimeMillis();
                        return;
                    }
                }
                MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                if (mgtvAudioView4.mBackPlayEnable && (mgtvMediaPlayer = mgtvAudioView4.mMediaPlayer) != null) {
                    mgtvMediaPlayer.setSurfaceHolder(null);
                }
                mgtvAudioView = MgtvAudioView.this;
                if (mgtvAudioView.mCurrentUri != null) {
                }
            }
        };
        this.mFilterCallback = new f.a() { // from class: com.hunantv.media.widget.MgtvAudioView.2
            public void onInfo(int i, int i2, String str) {
                if (i == 1) {
                    MgtvAudioView.this.mRenderType = i2;
                    MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                    ReportParams reportParams = mgtvAudioView.mReportParams;
                    if (reportParams != null) {
                        reportParams.setRenderType(mgtvAudioView.mRenderType);
                    }
                } else if (i != 3) {
                } else {
                    MgtvAudioView.this.mEnhanceQualityType = i2;
                    MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                    ReportParams reportParams2 = mgtvAudioView2.mReportParams;
                    if (reportParams2 != null) {
                        reportParams2.setEnhanceQualityType(mgtvAudioView2.mEnhanceQualityType);
                    }
                }
            }
        };
        this.mRenderWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvAudioView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i, int i2) {
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i, String str, String str2, Object obj) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "opengl render warning:" + i + ",extra:" + str + ",msg:" + str2);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onWarning(i, str, str2, obj);
                }
            }
        };
        this.mSizeChangedListener = new MgtvPlayerListener.OnVideoSizeChangedListener() { // from class: com.hunantv.media.widget.MgtvAudioView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i, int i2) {
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                mgtvAudioView.originalVideoWidth = mgtvAudioView.mVideoWidth = mgtvAudioView.mMediaPlayer.getVideoWidth();
                MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                mgtvAudioView2.originalVideoHeight = mgtvAudioView2.mVideoHeight = mgtvAudioView2.mMediaPlayer.getVideoHeight();
                MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                mgtvAudioView3.mVideoSarNum = mgtvAudioView3.mMediaPlayer.getVideoSarNum();
                MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                mgtvAudioView4.mVideoSarDen = mgtvAudioView4.mMediaPlayer.getVideoSarDen();
                if (MgtvAudioView.this.mVideoWidth != 0 && MgtvAudioView.this.mVideoHeight != 0) {
                    if (MgtvAudioView.this.mRenderView != null) {
                        MgtvAudioView.this.mRenderView.setVideoSize(MgtvAudioView.this.mVideoWidth, MgtvAudioView.this.mVideoHeight);
                        if (MgtvAudioView.this.mVideoSarNum > 0 && MgtvAudioView.this.mVideoSarDen > 0) {
                            MgtvAudioView.this.mRenderView.setVideoSampleAspectRatio(MgtvAudioView.this.mVideoSarNum, MgtvAudioView.this.mVideoSarDen);
                        }
                    }
                    MgtvAudioView.this.requestLayout();
                }
                if (MgtvAudioView.this.mOnVideoSizeChangedListener != null) {
                    MgtvAudioView.this.mOnVideoSizeChangedListener.onVideoSizeChanged(i, i2);
                }
            }
        };
        this.mPreparedListener = new MgtvPlayerListener.OnPreparedListener() { // from class: com.hunantv.media.widget.MgtvAudioView.5
            /* JADX WARN: Code restructure failed: missing block: B:12:0x008e, code lost:
                if (r4.this$0.mRenderView.shouldWaitForResize() == false) goto L12;
             */
            /* JADX WARN: Code restructure failed: missing block: B:16:0x00aa, code lost:
                if (r4.this$0.mSurfaceHeight == r4.this$0.mVideoHeight) goto L12;
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x00b2, code lost:
                if (r4.this$0.mTargetState != 3) goto L14;
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x00bb, code lost:
                if (r4.this$0.mTargetState == 3) goto L20;
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x00bd, code lost:
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
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    r1 = 2
                    com.hunantv.media.widget.MgtvAudioView.access$2700(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoWidth()
                    int r1 = com.hunantv.media.widget.MgtvAudioView.access$2102(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView.access$2002(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoHeight()
                    int r1 = com.hunantv.media.widget.MgtvAudioView.access$2302(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView.access$2202(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2100(r0)
                    r1 = 3
                    if (r0 == 0) goto Lb5
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2300(r0)
                    if (r0 == 0) goto Lb5
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "video size: "
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    r0.append(r2)
                    java.lang.String r2 = "/"
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2300(r2)
                    r0.append(r2)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r2 = "@@@@"
                    com.hunantv.media.player.pragma.DebugLog.i(r2, r0)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    if (r0 == 0) goto L7c
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    com.hunantv.media.widget.MgtvAudioView r3 = com.hunantv.media.widget.MgtvAudioView.this
                    int r3 = com.hunantv.media.widget.MgtvAudioView.access$2300(r3)
                    r0.setVideoSize(r2, r3)
                L7c:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    if (r0 == 0) goto L90
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    boolean r0 = r0.shouldWaitForResize()
                    if (r0 == 0) goto Lac
                L90:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2800(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    if (r0 != r2) goto Lc2
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2900(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2300(r2)
                    if (r0 != r2) goto Lc2
                Lac:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$3000(r0)
                    if (r0 != r1) goto Lc2
                    goto Lbd
                Lb5:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$3000(r0)
                    if (r0 != r1) goto Lc2
                Lbd:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    r0.start()
                Lc2:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvAudioView.access$3100(r0)
                    if (r0 == 0) goto Ld3
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvAudioView.access$3100(r0)
                    r0.onPrepared()
                Ld3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvAudioView.AnonymousClass5.onPrepared():void");
            }
        };
        this.mCompletionListener = new MgtvPlayerListener.OnCompletionListener() { // from class: com.hunantv.media.widget.MgtvAudioView.6
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnCompletionListener
            public void onCompletion(int i, int i2) {
                if (i != 0) {
                    MgtvAudioView.this.stopInner();
                }
                MgtvAudioView.this.changeCurrentState(5);
                MgtvAudioView.this.mTargetState = 5;
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "-------------on onCompletion what:" + i + ",extra:" + i2);
                if (MgtvAudioView.this.mOnCompletionListener != null) {
                    MgtvAudioView.this.mOnCompletionListener.onCompletion(i, i2);
                }
            }
        };
        this.mInfoListener = new MgtvPlayerListener.OnInfoListener() { // from class: com.hunantv.media.widget.MgtvAudioView.7
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
                        logTag = MgtvAudioView.this.getLogTag();
                        sb = new StringBuilder();
                        str = "video fps is ";
                    } else if (i == 2820) {
                        logTag = MgtvAudioView.this.getLogTag();
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
                        String logTag2 = MgtvAudioView.this.getLogTag();
                        DebugLog.i(logTag2, "MEDIA_INFO_PLAYBACK_STATE_CHANGED:" + i2);
                        if (MgtvAudioView.this.mOnUpdateStatusListener != null) {
                            MgtvAudioView.this.mOnUpdateStatusListener.onUpdateStatus();
                        }
                    } else if (i == 10001) {
                        String logTag3 = MgtvAudioView.this.getLogTag();
                        DebugLog.w(logTag3, "video rotation changed,extra(degree) is " + i2);
                        MgtvAudioView.this.mVideoRotationDegree = i2;
                        if (MgtvAudioView.this.mRenderView != null) {
                            MgtvAudioView.this.mRenderView.setVideoRotation(MgtvAudioView.this.mVideoRotationDegree);
                        }
                    } else if (i == 200001) {
                        MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                        if (i2 == 1) {
                            mgtvAudioView.mMgtvMediaPlayerHardwareMode = false;
                        } else {
                            mgtvAudioView.mMgtvMediaPlayerHardwareMode = true;
                        }
                        MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                        mgtvAudioView2.convertRender(mgtvAudioView2.mRenderViewType);
                    } else if (i == 3) {
                        DebugLog.w(MgtvAudioView.this.getLogTag(), "video decode succeeded, start rendering");
                        MgtvAudioView.this.onVideoRenderStart();
                        if (MgtvAudioView.this.mOnInfoListener != null) {
                            MgtvAudioView.this.mOnInfoListener.onInfo(900, i2);
                        }
                        return true;
                    } else if (i == 4) {
                        DebugLog.w(MgtvAudioView.this.getLogTag(), "audio decode succeeded, start rendering");
                        if (MgtvAudioView.this.isOnlyAudioMode()) {
                            if (MgtvAudioView.this.mOnInfoListener != null) {
                                MgtvAudioView.this.mOnInfoListener.onInfo(900, i2);
                            }
                            return true;
                        }
                    } else if (i != 5) {
                        if (i == 6) {
                            if (i2 == 0) {
                                MgtvAudioView.this.mMgtvMediaPlayerHardwareMode = false;
                            } else if (i2 == 1) {
                                MgtvAudioView.this.mMgtvMediaPlayerHardwareMode = true;
                            }
                            logTag = MgtvAudioView.this.getLogTag();
                            sb = new StringBuilder();
                            str = "video decoder open,extra is ";
                        } else if (i != 7) {
                            switch (i) {
                                case 700:
                                    String logTag4 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag4, "It's too complex for the decoder, extra is " + i2);
                                    i = 700;
                                    break;
                                case 701:
                                    String logTag5 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag5, "buffer start speed:" + MgtvAudioView.this.getDLSpeedFormat());
                                    i = 701;
                                    break;
                                case 702:
                                    String logTag6 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag6, "buffer end speed:" + MgtvAudioView.this.getDLSpeedFormat());
                                    i = 702;
                                    break;
                                default:
                                    switch (i) {
                                        case 800:
                                            String logTag7 = MgtvAudioView.this.getLogTag();
                                            DebugLog.e(logTag7, "Bad interleaving of media file, audio/video are not well-formed, extra is " + i2);
                                            i = 800;
                                            break;
                                        case 801:
                                            String logTag8 = MgtvAudioView.this.getLogTag();
                                            DebugLog.w(logTag8, "The stream not seekable status, extra is " + i2);
                                            i = 801;
                                            MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                                            if (i2 == 1) {
                                                mgtvAudioView3.mIsLive = true;
                                                logTag = MgtvAudioView.this.getLogTag();
                                                str2 = "The stream is live stream,can not seekable ";
                                            } else {
                                                mgtvAudioView3.mIsLive = false;
                                                logTag = MgtvAudioView.this.getLogTag();
                                                str2 = "The stream is not live stream,can seekable ";
                                            }
                                            DebugLog.w(logTag, str2);
                                            break;
                                        case 802:
                                            String logTag9 = MgtvAudioView.this.getLogTag();
                                            DebugLog.w(logTag9, "A new set of metadata is available, extra is " + i2);
                                            i = 802;
                                            break;
                                        default:
                                            logTag = MgtvAudioView.this.getLogTag();
                                            switch (i) {
                                                case MgtvMediaPlayer.MEDIA_INFO_DATA_PROTOCOL /* 2803 */:
                                                    DebugLog.w(logTag, "data source type is " + i2);
                                                    MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                                                    MgtvMediaPlayer mgtvMediaPlayer = mgtvAudioView4.mMediaPlayer;
                                                    if (mgtvMediaPlayer != null) {
                                                        mgtvAudioView4.mDataSourceType = mgtvMediaPlayer.getDataSourceType();
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
                    String logTag10 = MgtvAudioView.this.getLogTag();
                    DebugLog.w(logTag10, "Unknown info, extra is " + i2);
                    i = 1;
                }
                if (MgtvAudioView.this.mOnInfoListener != null) {
                    MgtvAudioView.this.mOnInfoListener.onInfo(i, i2);
                }
                return true;
            }
        };
        this.reportErrWithoutMpManager = null;
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.widget.MgtvAudioView.8
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i, int i2) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.w(logTag, "onError what:" + i + ",extra:" + i2);
                if ((i == 7001004 || i == 7000001 || i == 7000002 || i == 7000003 || i == 7000004 || i == 7000005 || i == 7000006 || i == 7000009 || i == 7000010 || i == 7000011 || i == 7000012 || i == 7000013 || i == 7001999 || i == 7001998 || i == 7000110) && MgtvAudioView.this.reportErrWithoutMpManager != null) {
                    MgtvAudioView.this.reportErrWithoutMpManager.F(i, i2);
                }
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvAudioView.mMediaPlayer;
                if (mgtvMediaPlayer == null || i != 7000006) {
                    if (mgtvMediaPlayer != null && mgtvAudioView.mCurrentState != -1) {
                        MgtvAudioView.this.mMediaPlayer.stop();
                    }
                    MgtvAudioView.this.changeCurrentState(-1);
                    MgtvAudioView.this.mTargetState = -1;
                } else {
                    mgtvAudioView.releaseNoStatus();
                    MgtvAudioView.this.changeCurrentState(0);
                    MgtvAudioView.this.mTargetState = 0;
                }
                MgtvAudioView.this.cleanUri();
                return MgtvAudioView.this.mOnErrorListener != null && MgtvAudioView.this.mOnErrorListener.onError(i, i2);
            }
        };
        this.mSeekCompleteListener = new MgtvPlayerListener.OnSeekCompleteListener() { // from class: com.hunantv.media.widget.MgtvAudioView.9
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSeekCompleteListener
            public void onSeekComplete(int i, int i2) {
                if (MgtvAudioView.this.mOnSeekCompleteListener != null) {
                    String logTag = MgtvAudioView.this.getLogTag();
                    DebugLog.i(logTag, "onSeekComplete seekTargetTime:" + i + ",errorCode:" + i2);
                    MgtvAudioView.this.mOnSeekCompleteListener.onSeekComplete();
                }
            }
        };
        this.mBufferingUpdateListener = new MgtvPlayerListener.OnBufferingUpdateListener() { // from class: com.hunantv.media.widget.MgtvAudioView.10
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingUpdateListener
            public void onBufferingUpdate(int i) {
                if (MgtvAudioView.this.mOnBufferringUpdateListener != null) {
                    MgtvAudioView.this.mOnBufferringUpdateListener.onBufferingUpdate(i);
                }
            }
        };
        this.mBufferingTimeoutListener = new MgtvPlayerListener.OnBufferingTimeoutListener() { // from class: com.hunantv.media.widget.MgtvAudioView.11
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingTimeoutListener
            public boolean onBufferingTimeout(int i, int i2) {
                MgtvMediaPlayer mgtvMediaPlayer = MgtvAudioView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.stop();
                }
                MgtvAudioView.this.changeCurrentState(-1);
                MgtvAudioView.this.mTargetState = -1;
                MgtvAudioView.this.cleanUri();
                if (MgtvAudioView.this.mOnErrorListener == null || MgtvAudioView.this.mOnErrorListener.onError(i, i2)) {
                }
                return true;
            }
        };
        this.mSwitchSourceListener = new MgtvPlayerListener.OnSwitchSourceListener() { // from class: com.hunantv.media.widget.MgtvAudioView.12
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceComplete(String str, int i, int i2) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceComplete url:" + str + ",type:" + i + ",time:" + i2);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceSuccess(str, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceFailed(String str, int i, int i2) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceFailed url:" + str + ",what:" + i + ",extra:" + i2);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceFailed(str, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceInfo(String str, int i, int i2) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceInfo url:" + str + ",event:" + i + ",time:" + i2);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceInfo(str, i, i2);
                }
            }
        };
        this.mPlayerWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvAudioView.13
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i, int i2) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "onTsSkip tsUrl:" + str);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onTsSkip(str, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i, String str, String str2, Object obj) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "player render warning:" + i + ",extra:" + str + ",msg:" + str2);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onWarning(i, str, str2, obj);
                }
            }
        };
        this.mGifRecorder = new GifRecorder();
        this.mStartListener = new MgtvPlayerListener.OnStartListener() { // from class: com.hunantv.media.widget.MgtvAudioView.14
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnStartListener
            public void onStart() {
                DebugLog.d(MgtvAudioView.this.getLogTag(), "mgtvcore onStart");
                if (MgtvAudioView.this.mEnableCoreStartPauseListen) {
                    MgtvAudioView.this.callbackOnStart();
                }
            }
        };
        this.mPauseListener = new MgtvPlayerListener.OnPauseListener() { // from class: com.hunantv.media.widget.MgtvAudioView.15
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPauseListener
            public void onPause() {
                DebugLog.d(MgtvAudioView.this.getLogTag(), "mgtvcore onPause");
                if (MgtvAudioView.this.mEnableCoreStartPauseListen) {
                    MgtvAudioView.this.callbackOnPause();
                }
            }
        };
        this.mRecordVideoListener = new MgtvPlayerListener.OnRecordVideoListener() { // from class: com.hunantv.media.widget.MgtvAudioView.16
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoErr(int i, int i2) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onRecordVideoErr what:" + i + ",extra:" + i2);
                if (MgtvAudioView.this.mOnRecordListener != null) {
                    MgtvAudioView.this.mOnRecordListener.onRecordError(i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoInfo(int i, int i2) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "onRecordVideoInfo what:" + i + ",extra:" + i2);
                if (MgtvAudioView.this.mOnRecordListener != null) {
                    if (i == 20) {
                        MgtvAudioView.this.mOnRecordListener.onRecordStart(MgtvAudioView.this.mRecordFilePath);
                    } else if (i == 30) {
                        MgtvAudioView.this.mOnRecordListener.onRecordStop();
                    }
                    MgtvAudioView.this.mOnRecordListener.onRecordInfo(i, i2);
                }
            }
        };
        this.mLoadDataListener = new MgtvPlayerListener.OnLoadDataListener() { // from class: com.hunantv.media.widget.MgtvAudioView.17
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onAfterLoadDataPaused() {
                if (MgtvAudioView.this.mOnLoadDataListener != null) {
                    MgtvAudioView.this.mOnLoadDataListener.onAfterLoadDataPaused();
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onBeforeLoadDataResume() {
                if (MgtvAudioView.this.mOnLoadDataListener != null) {
                    MgtvAudioView.this.mOnLoadDataListener.onBeforeLoadDataResume();
                }
            }
        };
        initVideoView(context);
    }

    public MgtvAudioView(Context context, int i) {
        super(context);
        this.mLastSurfaceDestroy = true;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mMgtvMediaPlayerHardwareMode = false;
        this.mForceDecodeMode = false;
        this.mFromSurfaceDestroyToPlay = false;
        this.mFromSurfaceDestroyPlayPosition = 0;
        this.mErrorMsg = "";
        this.mHasSurfaceHolderDestroy = false;
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
        this.mEnableMgtvMediaCodec = true;
        this.mEnableJavaIPCache = false;
        this.mLastFrameRecovery = true;
        this.mWeakNetSpeed = 0;
        this.mWeakBufferTimeoutMs = 0;
        this.mTsNotSkip = false;
        this.mLoadMaxRetryTime = 0;
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
        this.mStartPosMs = 0;
        this.mFlowDataStatistic = new FlowDataStatistic();
        this.mSkipLoopFilterType = MgtvMediaPlayer.SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mSHCallback = new IMgtvRenderView.IRenderCallback() { // from class: com.hunantv.media.widget.MgtvAudioView.1
            private void bindHolder(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22) {
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                if (mgtvAudioView.mMediaPlayer == null) {
                    mgtvAudioView.openVideo();
                    return;
                }
                if (!mgtvAudioView.mEnableMediacodecSW && mgtvAudioView.mHasSurfaceHolderDestroy && MgtvAudioView.this.mRebindTexture) {
                    MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                    if (mgtvAudioView2.mCurrentUri != null) {
                        mgtvAudioView2.setStartPosMs(mgtvAudioView2.mMediaPlayer.getCurrentPosition());
                        MgtvAudioView.this.openVideo();
                    }
                }
                if (!needOpenVideo()) {
                    MgtvAudioView.this.mMediaPlayer.setSurfaceHolder(iSurfaceHolder);
                    MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                    if (mgtvAudioView3.mCurrentUri != null) {
                        if (mgtvAudioView3.mFromSurfaceDestroyToPlay && MgtvAudioView.this.mMgtvMediaPlayerHardwareMode) {
                            MgtvAudioView.this.mFromSurfaceDestroyToPlay = false;
                            MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                            mgtvAudioView4.mMediaPlayer.seekTo(mgtvAudioView4.mFromSurfaceDestroyPlayPosition, false, true);
                            MgtvAudioView.this.mFromSurfaceDestroyPlayPosition = 0;
                        }
                        if (MgtvAudioView.this.mLastFrameRecovery && (!MgtvAudioView.this.isHardware() || MgtvAudioView.this.mLastSurfaceDestroy)) {
                            MgtvAudioView.this.mMediaPlayer.setPlaybackStep();
                        }
                    }
                    MgtvAudioView mgtvAudioView5 = MgtvAudioView.this;
                    mgtvAudioView5.mSizeChangedListener.onVideoSizeChanged(mgtvAudioView5.mMediaPlayer.getVideoWidth(), MgtvAudioView.this.mMediaPlayer.getVideoHeight());
                    MgtvAudioView.this.autoStartByStateAndSize(i2, i22);
                    return;
                }
                MgtvAudioView.this.openVideo();
            }

            private boolean needOpenVideo() {
                return MgtvAudioView.this.mOpenVideoWhenSurfaceCreate && MgtvAudioView.this.mCurrentUri != null;
            }

            private void videoSurfaceChanged(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22, int i3) {
                if (MgtvAudioView.this.mRenderView == null || iSurfaceHolder.getRenderView() == MgtvAudioView.this.mRenderView.getRenderView()) {
                    MgtvAudioView.this.autoStartByStateAndSize(i22, i3);
                } else {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceChanged: unmatched render callback\n");
                }
            }

            private void videoSurfaceCreate(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22) {
                SurfaceHolder surfaceHolder;
                if (MgtvAudioView.this.mRenderView != null && iSurfaceHolder.getRenderView() != MgtvAudioView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "videoSurfaceCreate " + iSurfaceHolder);
                if (MgtvAudioView.this.mRenderView == null || MgtvAudioView.this.mRenderView.getRenderViewType() != 0 || ((surfaceHolder = MgtvAudioView.this.mSurfaceHolder.getSurfaceHolder()) != null && surfaceHolder.getSurface() != null && surfaceHolder.getSurface().isValid())) {
                    bindHolder(iSurfaceHolder, i2, i22);
                    return;
                }
                MgtvAudioView.this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SURFACE_FAILED, 1);
                MgtvAudioView.this.mErrorMsg = "surfaceCreated surface is invalid";
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceChanged(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22, int i3) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface changed. threadId:" + Thread.currentThread().getId());
                if (!MgtvAudioView.this.isOnlyAudioMode() && !MgtvAudioView.this.mBackPlayEnable) {
                    videoSurfaceChanged(iSurfaceHolder, i2, i22, i3);
                }
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceChanged();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceCreated(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface create. threadId:" + Thread.currentThread().getId());
                if (MgtvAudioView.this.mStartLeaveTimestamp > 0) {
                    long currentTimeMillis = (System.currentTimeMillis() - MgtvAudioView.this.mStartLeaveTimestamp) / 1000;
                    if (currentTimeMillis > 540) {
                        if (MgtvAudioView.this.mOnWarningListener != null) {
                            MgtvPlayerListener.OnWarningListener onWarningListener = MgtvAudioView.this.mOnWarningListener;
                            onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_LEAVE_TIME_INVALID, MgtvAudioView.this.mCurrentState + "", "", null);
                        }
                        ReportParams reportParams = MgtvAudioView.this.mReportParams;
                        if (reportParams != null) {
                            reportParams.setLeaveTimeS(currentTimeMillis);
                        }
                    }
                }
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                mgtvAudioView.mSurfaceHolder = iSurfaceHolder;
                if (!mgtvAudioView.isOnlyAudioMode() && !MgtvAudioView.this.mBackPlayEnable) {
                    videoSurfaceCreate(iSurfaceHolder, i2, i22);
                }
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceCreated();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceDestroyed(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, boolean z) {
                MgtvMediaPlayer mgtvMediaPlayer;
                MgtvAudioView mgtvAudioView;
                IMgtvRenderView.ISurfaceHolder iSurfaceHolder2;
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface destroy. threadId:" + Thread.currentThread().getId());
                MgtvAudioView.this.mLastSurfaceDestroy = z;
                if (MgtvAudioView.this.mRenderView != null && iSurfaceHolder.getRenderView() != MgtvAudioView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceDestroyed: unmatched render callback\n");
                    return;
                }
                String logTag2 = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag2, "onSurfaceDestroyed " + iSurfaceHolder);
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceDestroyed();
                }
                if (z && (iSurfaceHolder2 = MgtvAudioView.this.mSurfaceHolder) != null) {
                    iSurfaceHolder2.releaseSurface();
                }
                MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                mgtvAudioView2.mSurfaceHolder = null;
                if (!mgtvAudioView2.isOnlyAudioMode()) {
                    MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                    if (!mgtvAudioView3.mBackPlayEnable) {
                        mgtvAudioView3.videoSurfaceDestroyed();
                        mgtvAudioView = MgtvAudioView.this;
                        if (mgtvAudioView.mCurrentUri != null || mgtvAudioView.mCurrentState == -1 || MgtvAudioView.this.mCurrentState == 5) {
                            return;
                        }
                        MgtvAudioView.this.mStartLeaveTimestamp = System.currentTimeMillis();
                        return;
                    }
                }
                MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                if (mgtvAudioView4.mBackPlayEnable && (mgtvMediaPlayer = mgtvAudioView4.mMediaPlayer) != null) {
                    mgtvMediaPlayer.setSurfaceHolder(null);
                }
                mgtvAudioView = MgtvAudioView.this;
                if (mgtvAudioView.mCurrentUri != null) {
                }
            }
        };
        this.mFilterCallback = new f.a() { // from class: com.hunantv.media.widget.MgtvAudioView.2
            public void onInfo(int i2, int i22, String str) {
                if (i2 == 1) {
                    MgtvAudioView.this.mRenderType = i22;
                    MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                    ReportParams reportParams = mgtvAudioView.mReportParams;
                    if (reportParams != null) {
                        reportParams.setRenderType(mgtvAudioView.mRenderType);
                    }
                } else if (i2 != 3) {
                } else {
                    MgtvAudioView.this.mEnhanceQualityType = i22;
                    MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                    ReportParams reportParams2 = mgtvAudioView2.mReportParams;
                    if (reportParams2 != null) {
                        reportParams2.setEnhanceQualityType(mgtvAudioView2.mEnhanceQualityType);
                    }
                }
            }
        };
        this.mRenderWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvAudioView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "opengl render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mSizeChangedListener = new MgtvPlayerListener.OnVideoSizeChangedListener() { // from class: com.hunantv.media.widget.MgtvAudioView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i2, int i22) {
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                mgtvAudioView.originalVideoWidth = mgtvAudioView.mVideoWidth = mgtvAudioView.mMediaPlayer.getVideoWidth();
                MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                mgtvAudioView2.originalVideoHeight = mgtvAudioView2.mVideoHeight = mgtvAudioView2.mMediaPlayer.getVideoHeight();
                MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                mgtvAudioView3.mVideoSarNum = mgtvAudioView3.mMediaPlayer.getVideoSarNum();
                MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                mgtvAudioView4.mVideoSarDen = mgtvAudioView4.mMediaPlayer.getVideoSarDen();
                if (MgtvAudioView.this.mVideoWidth != 0 && MgtvAudioView.this.mVideoHeight != 0) {
                    if (MgtvAudioView.this.mRenderView != null) {
                        MgtvAudioView.this.mRenderView.setVideoSize(MgtvAudioView.this.mVideoWidth, MgtvAudioView.this.mVideoHeight);
                        if (MgtvAudioView.this.mVideoSarNum > 0 && MgtvAudioView.this.mVideoSarDen > 0) {
                            MgtvAudioView.this.mRenderView.setVideoSampleAspectRatio(MgtvAudioView.this.mVideoSarNum, MgtvAudioView.this.mVideoSarDen);
                        }
                    }
                    MgtvAudioView.this.requestLayout();
                }
                if (MgtvAudioView.this.mOnVideoSizeChangedListener != null) {
                    MgtvAudioView.this.mOnVideoSizeChangedListener.onVideoSizeChanged(i2, i22);
                }
            }
        };
        this.mPreparedListener = new MgtvPlayerListener.OnPreparedListener() { // from class: com.hunantv.media.widget.MgtvAudioView.5
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPreparedListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPrepared() {
                /*
                    r4 = this;
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    r1 = 2
                    com.hunantv.media.widget.MgtvAudioView.access$2700(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoWidth()
                    int r1 = com.hunantv.media.widget.MgtvAudioView.access$2102(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView.access$2002(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoHeight()
                    int r1 = com.hunantv.media.widget.MgtvAudioView.access$2302(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView.access$2202(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2100(r0)
                    r1 = 3
                    if (r0 == 0) goto Lb5
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2300(r0)
                    if (r0 == 0) goto Lb5
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "video size: "
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    r0.append(r2)
                    java.lang.String r2 = "/"
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2300(r2)
                    r0.append(r2)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r2 = "@@@@"
                    com.hunantv.media.player.pragma.DebugLog.i(r2, r0)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    if (r0 == 0) goto L7c
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    com.hunantv.media.widget.MgtvAudioView r3 = com.hunantv.media.widget.MgtvAudioView.this
                    int r3 = com.hunantv.media.widget.MgtvAudioView.access$2300(r3)
                    r0.setVideoSize(r2, r3)
                L7c:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    if (r0 == 0) goto L90
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    boolean r0 = r0.shouldWaitForResize()
                    if (r0 == 0) goto Lac
                L90:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2800(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    if (r0 != r2) goto Lc2
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2900(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2300(r2)
                    if (r0 != r2) goto Lc2
                Lac:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$3000(r0)
                    if (r0 != r1) goto Lc2
                    goto Lbd
                Lb5:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$3000(r0)
                    if (r0 != r1) goto Lc2
                Lbd:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    r0.start()
                Lc2:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvAudioView.access$3100(r0)
                    if (r0 == 0) goto Ld3
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvAudioView.access$3100(r0)
                    r0.onPrepared()
                Ld3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvAudioView.AnonymousClass5.onPrepared():void");
            }
        };
        this.mCompletionListener = new MgtvPlayerListener.OnCompletionListener() { // from class: com.hunantv.media.widget.MgtvAudioView.6
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnCompletionListener
            public void onCompletion(int i2, int i22) {
                if (i2 != 0) {
                    MgtvAudioView.this.stopInner();
                }
                MgtvAudioView.this.changeCurrentState(5);
                MgtvAudioView.this.mTargetState = 5;
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "-------------on onCompletion what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnCompletionListener != null) {
                    MgtvAudioView.this.mOnCompletionListener.onCompletion(i2, i22);
                }
            }
        };
        this.mInfoListener = new MgtvPlayerListener.OnInfoListener() { // from class: com.hunantv.media.widget.MgtvAudioView.7
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
                        logTag = MgtvAudioView.this.getLogTag();
                        sb = new StringBuilder();
                        str = "video fps is ";
                    } else if (i2 == 2820) {
                        logTag = MgtvAudioView.this.getLogTag();
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
                        String logTag2 = MgtvAudioView.this.getLogTag();
                        DebugLog.i(logTag2, "MEDIA_INFO_PLAYBACK_STATE_CHANGED:" + i22);
                        if (MgtvAudioView.this.mOnUpdateStatusListener != null) {
                            MgtvAudioView.this.mOnUpdateStatusListener.onUpdateStatus();
                        }
                    } else if (i2 == 10001) {
                        String logTag3 = MgtvAudioView.this.getLogTag();
                        DebugLog.w(logTag3, "video rotation changed,extra(degree) is " + i22);
                        MgtvAudioView.this.mVideoRotationDegree = i22;
                        if (MgtvAudioView.this.mRenderView != null) {
                            MgtvAudioView.this.mRenderView.setVideoRotation(MgtvAudioView.this.mVideoRotationDegree);
                        }
                    } else if (i2 == 200001) {
                        MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                        if (i22 == 1) {
                            mgtvAudioView.mMgtvMediaPlayerHardwareMode = false;
                        } else {
                            mgtvAudioView.mMgtvMediaPlayerHardwareMode = true;
                        }
                        MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                        mgtvAudioView2.convertRender(mgtvAudioView2.mRenderViewType);
                    } else if (i2 == 3) {
                        DebugLog.w(MgtvAudioView.this.getLogTag(), "video decode succeeded, start rendering");
                        MgtvAudioView.this.onVideoRenderStart();
                        if (MgtvAudioView.this.mOnInfoListener != null) {
                            MgtvAudioView.this.mOnInfoListener.onInfo(900, i22);
                        }
                        return true;
                    } else if (i2 == 4) {
                        DebugLog.w(MgtvAudioView.this.getLogTag(), "audio decode succeeded, start rendering");
                        if (MgtvAudioView.this.isOnlyAudioMode()) {
                            if (MgtvAudioView.this.mOnInfoListener != null) {
                                MgtvAudioView.this.mOnInfoListener.onInfo(900, i22);
                            }
                            return true;
                        }
                    } else if (i2 != 5) {
                        if (i2 == 6) {
                            if (i22 == 0) {
                                MgtvAudioView.this.mMgtvMediaPlayerHardwareMode = false;
                            } else if (i22 == 1) {
                                MgtvAudioView.this.mMgtvMediaPlayerHardwareMode = true;
                            }
                            logTag = MgtvAudioView.this.getLogTag();
                            sb = new StringBuilder();
                            str = "video decoder open,extra is ";
                        } else if (i2 != 7) {
                            switch (i2) {
                                case 700:
                                    String logTag4 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag4, "It's too complex for the decoder, extra is " + i22);
                                    i2 = 700;
                                    break;
                                case 701:
                                    String logTag5 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag5, "buffer start speed:" + MgtvAudioView.this.getDLSpeedFormat());
                                    i2 = 701;
                                    break;
                                case 702:
                                    String logTag6 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag6, "buffer end speed:" + MgtvAudioView.this.getDLSpeedFormat());
                                    i2 = 702;
                                    break;
                                default:
                                    switch (i2) {
                                        case 800:
                                            String logTag7 = MgtvAudioView.this.getLogTag();
                                            DebugLog.e(logTag7, "Bad interleaving of media file, audio/video are not well-formed, extra is " + i22);
                                            i2 = 800;
                                            break;
                                        case 801:
                                            String logTag8 = MgtvAudioView.this.getLogTag();
                                            DebugLog.w(logTag8, "The stream not seekable status, extra is " + i22);
                                            i2 = 801;
                                            MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                                            if (i22 == 1) {
                                                mgtvAudioView3.mIsLive = true;
                                                logTag = MgtvAudioView.this.getLogTag();
                                                str2 = "The stream is live stream,can not seekable ";
                                            } else {
                                                mgtvAudioView3.mIsLive = false;
                                                logTag = MgtvAudioView.this.getLogTag();
                                                str2 = "The stream is not live stream,can seekable ";
                                            }
                                            DebugLog.w(logTag, str2);
                                            break;
                                        case 802:
                                            String logTag9 = MgtvAudioView.this.getLogTag();
                                            DebugLog.w(logTag9, "A new set of metadata is available, extra is " + i22);
                                            i2 = 802;
                                            break;
                                        default:
                                            logTag = MgtvAudioView.this.getLogTag();
                                            switch (i2) {
                                                case MgtvMediaPlayer.MEDIA_INFO_DATA_PROTOCOL /* 2803 */:
                                                    DebugLog.w(logTag, "data source type is " + i22);
                                                    MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                                                    MgtvMediaPlayer mgtvMediaPlayer = mgtvAudioView4.mMediaPlayer;
                                                    if (mgtvMediaPlayer != null) {
                                                        mgtvAudioView4.mDataSourceType = mgtvMediaPlayer.getDataSourceType();
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
                    String logTag10 = MgtvAudioView.this.getLogTag();
                    DebugLog.w(logTag10, "Unknown info, extra is " + i22);
                    i2 = 1;
                }
                if (MgtvAudioView.this.mOnInfoListener != null) {
                    MgtvAudioView.this.mOnInfoListener.onInfo(i2, i22);
                }
                return true;
            }
        };
        this.reportErrWithoutMpManager = null;
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.widget.MgtvAudioView.8
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.w(logTag, "onError what:" + i2 + ",extra:" + i22);
                if ((i2 == 7001004 || i2 == 7000001 || i2 == 7000002 || i2 == 7000003 || i2 == 7000004 || i2 == 7000005 || i2 == 7000006 || i2 == 7000009 || i2 == 7000010 || i2 == 7000011 || i2 == 7000012 || i2 == 7000013 || i2 == 7001999 || i2 == 7001998 || i2 == 7000110) && MgtvAudioView.this.reportErrWithoutMpManager != null) {
                    MgtvAudioView.this.reportErrWithoutMpManager.F(i2, i22);
                }
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvAudioView.mMediaPlayer;
                if (mgtvMediaPlayer == null || i2 != 7000006) {
                    if (mgtvMediaPlayer != null && mgtvAudioView.mCurrentState != -1) {
                        MgtvAudioView.this.mMediaPlayer.stop();
                    }
                    MgtvAudioView.this.changeCurrentState(-1);
                    MgtvAudioView.this.mTargetState = -1;
                } else {
                    mgtvAudioView.releaseNoStatus();
                    MgtvAudioView.this.changeCurrentState(0);
                    MgtvAudioView.this.mTargetState = 0;
                }
                MgtvAudioView.this.cleanUri();
                return MgtvAudioView.this.mOnErrorListener != null && MgtvAudioView.this.mOnErrorListener.onError(i2, i22);
            }
        };
        this.mSeekCompleteListener = new MgtvPlayerListener.OnSeekCompleteListener() { // from class: com.hunantv.media.widget.MgtvAudioView.9
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSeekCompleteListener
            public void onSeekComplete(int i2, int i22) {
                if (MgtvAudioView.this.mOnSeekCompleteListener != null) {
                    String logTag = MgtvAudioView.this.getLogTag();
                    DebugLog.i(logTag, "onSeekComplete seekTargetTime:" + i2 + ",errorCode:" + i22);
                    MgtvAudioView.this.mOnSeekCompleteListener.onSeekComplete();
                }
            }
        };
        this.mBufferingUpdateListener = new MgtvPlayerListener.OnBufferingUpdateListener() { // from class: com.hunantv.media.widget.MgtvAudioView.10
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingUpdateListener
            public void onBufferingUpdate(int i2) {
                if (MgtvAudioView.this.mOnBufferringUpdateListener != null) {
                    MgtvAudioView.this.mOnBufferringUpdateListener.onBufferingUpdate(i2);
                }
            }
        };
        this.mBufferingTimeoutListener = new MgtvPlayerListener.OnBufferingTimeoutListener() { // from class: com.hunantv.media.widget.MgtvAudioView.11
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingTimeoutListener
            public boolean onBufferingTimeout(int i2, int i22) {
                MgtvMediaPlayer mgtvMediaPlayer = MgtvAudioView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.stop();
                }
                MgtvAudioView.this.changeCurrentState(-1);
                MgtvAudioView.this.mTargetState = -1;
                MgtvAudioView.this.cleanUri();
                if (MgtvAudioView.this.mOnErrorListener == null || MgtvAudioView.this.mOnErrorListener.onError(i2, i22)) {
                }
                return true;
            }
        };
        this.mSwitchSourceListener = new MgtvPlayerListener.OnSwitchSourceListener() { // from class: com.hunantv.media.widget.MgtvAudioView.12
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceComplete(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceComplete url:" + str + ",type:" + i2 + ",time:" + i22);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceSuccess(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceFailed(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceFailed url:" + str + ",what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceFailed(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceInfo(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceInfo url:" + str + ",event:" + i2 + ",time:" + i22);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceInfo(str, i2, i22);
                }
            }
        };
        this.mPlayerWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvAudioView.13
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "onTsSkip tsUrl:" + str);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onTsSkip(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "player render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mGifRecorder = new GifRecorder();
        this.mStartListener = new MgtvPlayerListener.OnStartListener() { // from class: com.hunantv.media.widget.MgtvAudioView.14
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnStartListener
            public void onStart() {
                DebugLog.d(MgtvAudioView.this.getLogTag(), "mgtvcore onStart");
                if (MgtvAudioView.this.mEnableCoreStartPauseListen) {
                    MgtvAudioView.this.callbackOnStart();
                }
            }
        };
        this.mPauseListener = new MgtvPlayerListener.OnPauseListener() { // from class: com.hunantv.media.widget.MgtvAudioView.15
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPauseListener
            public void onPause() {
                DebugLog.d(MgtvAudioView.this.getLogTag(), "mgtvcore onPause");
                if (MgtvAudioView.this.mEnableCoreStartPauseListen) {
                    MgtvAudioView.this.callbackOnPause();
                }
            }
        };
        this.mRecordVideoListener = new MgtvPlayerListener.OnRecordVideoListener() { // from class: com.hunantv.media.widget.MgtvAudioView.16
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoErr(int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onRecordVideoErr what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnRecordListener != null) {
                    MgtvAudioView.this.mOnRecordListener.onRecordError(i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoInfo(int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "onRecordVideoInfo what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnRecordListener != null) {
                    if (i2 == 20) {
                        MgtvAudioView.this.mOnRecordListener.onRecordStart(MgtvAudioView.this.mRecordFilePath);
                    } else if (i2 == 30) {
                        MgtvAudioView.this.mOnRecordListener.onRecordStop();
                    }
                    MgtvAudioView.this.mOnRecordListener.onRecordInfo(i2, i22);
                }
            }
        };
        this.mLoadDataListener = new MgtvPlayerListener.OnLoadDataListener() { // from class: com.hunantv.media.widget.MgtvAudioView.17
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onAfterLoadDataPaused() {
                if (MgtvAudioView.this.mOnLoadDataListener != null) {
                    MgtvAudioView.this.mOnLoadDataListener.onAfterLoadDataPaused();
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onBeforeLoadDataResume() {
                if (MgtvAudioView.this.mOnLoadDataListener != null) {
                    MgtvAudioView.this.mOnLoadDataListener.onBeforeLoadDataResume();
                }
            }
        };
        initVideoView(context, i);
    }

    public MgtvAudioView(Context context, int i, boolean z) {
        super(context);
        this.mLastSurfaceDestroy = true;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mMgtvMediaPlayerHardwareMode = false;
        this.mForceDecodeMode = false;
        this.mFromSurfaceDestroyToPlay = false;
        this.mFromSurfaceDestroyPlayPosition = 0;
        this.mErrorMsg = "";
        this.mHasSurfaceHolderDestroy = false;
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
        this.mEnableMgtvMediaCodec = true;
        this.mEnableJavaIPCache = false;
        this.mLastFrameRecovery = true;
        this.mWeakNetSpeed = 0;
        this.mWeakBufferTimeoutMs = 0;
        this.mTsNotSkip = false;
        this.mLoadMaxRetryTime = 0;
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
        this.mStartPosMs = 0;
        this.mFlowDataStatistic = new FlowDataStatistic();
        this.mSkipLoopFilterType = MgtvMediaPlayer.SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mSHCallback = new IMgtvRenderView.IRenderCallback() { // from class: com.hunantv.media.widget.MgtvAudioView.1
            private void bindHolder(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22) {
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                if (mgtvAudioView.mMediaPlayer == null) {
                    mgtvAudioView.openVideo();
                    return;
                }
                if (!mgtvAudioView.mEnableMediacodecSW && mgtvAudioView.mHasSurfaceHolderDestroy && MgtvAudioView.this.mRebindTexture) {
                    MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                    if (mgtvAudioView2.mCurrentUri != null) {
                        mgtvAudioView2.setStartPosMs(mgtvAudioView2.mMediaPlayer.getCurrentPosition());
                        MgtvAudioView.this.openVideo();
                    }
                }
                if (!needOpenVideo()) {
                    MgtvAudioView.this.mMediaPlayer.setSurfaceHolder(iSurfaceHolder);
                    MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                    if (mgtvAudioView3.mCurrentUri != null) {
                        if (mgtvAudioView3.mFromSurfaceDestroyToPlay && MgtvAudioView.this.mMgtvMediaPlayerHardwareMode) {
                            MgtvAudioView.this.mFromSurfaceDestroyToPlay = false;
                            MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                            mgtvAudioView4.mMediaPlayer.seekTo(mgtvAudioView4.mFromSurfaceDestroyPlayPosition, false, true);
                            MgtvAudioView.this.mFromSurfaceDestroyPlayPosition = 0;
                        }
                        if (MgtvAudioView.this.mLastFrameRecovery && (!MgtvAudioView.this.isHardware() || MgtvAudioView.this.mLastSurfaceDestroy)) {
                            MgtvAudioView.this.mMediaPlayer.setPlaybackStep();
                        }
                    }
                    MgtvAudioView mgtvAudioView5 = MgtvAudioView.this;
                    mgtvAudioView5.mSizeChangedListener.onVideoSizeChanged(mgtvAudioView5.mMediaPlayer.getVideoWidth(), MgtvAudioView.this.mMediaPlayer.getVideoHeight());
                    MgtvAudioView.this.autoStartByStateAndSize(i2, i22);
                    return;
                }
                MgtvAudioView.this.openVideo();
            }

            private boolean needOpenVideo() {
                return MgtvAudioView.this.mOpenVideoWhenSurfaceCreate && MgtvAudioView.this.mCurrentUri != null;
            }

            private void videoSurfaceChanged(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22, int i3) {
                if (MgtvAudioView.this.mRenderView == null || iSurfaceHolder.getRenderView() == MgtvAudioView.this.mRenderView.getRenderView()) {
                    MgtvAudioView.this.autoStartByStateAndSize(i22, i3);
                } else {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceChanged: unmatched render callback\n");
                }
            }

            private void videoSurfaceCreate(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22) {
                SurfaceHolder surfaceHolder;
                if (MgtvAudioView.this.mRenderView != null && iSurfaceHolder.getRenderView() != MgtvAudioView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "videoSurfaceCreate " + iSurfaceHolder);
                if (MgtvAudioView.this.mRenderView == null || MgtvAudioView.this.mRenderView.getRenderViewType() != 0 || ((surfaceHolder = MgtvAudioView.this.mSurfaceHolder.getSurfaceHolder()) != null && surfaceHolder.getSurface() != null && surfaceHolder.getSurface().isValid())) {
                    bindHolder(iSurfaceHolder, i2, i22);
                    return;
                }
                MgtvAudioView.this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SURFACE_FAILED, 1);
                MgtvAudioView.this.mErrorMsg = "surfaceCreated surface is invalid";
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceChanged(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22, int i3) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface changed. threadId:" + Thread.currentThread().getId());
                if (!MgtvAudioView.this.isOnlyAudioMode() && !MgtvAudioView.this.mBackPlayEnable) {
                    videoSurfaceChanged(iSurfaceHolder, i2, i22, i3);
                }
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceChanged();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceCreated(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface create. threadId:" + Thread.currentThread().getId());
                if (MgtvAudioView.this.mStartLeaveTimestamp > 0) {
                    long currentTimeMillis = (System.currentTimeMillis() - MgtvAudioView.this.mStartLeaveTimestamp) / 1000;
                    if (currentTimeMillis > 540) {
                        if (MgtvAudioView.this.mOnWarningListener != null) {
                            MgtvPlayerListener.OnWarningListener onWarningListener = MgtvAudioView.this.mOnWarningListener;
                            onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_LEAVE_TIME_INVALID, MgtvAudioView.this.mCurrentState + "", "", null);
                        }
                        ReportParams reportParams = MgtvAudioView.this.mReportParams;
                        if (reportParams != null) {
                            reportParams.setLeaveTimeS(currentTimeMillis);
                        }
                    }
                }
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                mgtvAudioView.mSurfaceHolder = iSurfaceHolder;
                if (!mgtvAudioView.isOnlyAudioMode() && !MgtvAudioView.this.mBackPlayEnable) {
                    videoSurfaceCreate(iSurfaceHolder, i2, i22);
                }
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceCreated();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceDestroyed(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, boolean z2) {
                MgtvMediaPlayer mgtvMediaPlayer;
                MgtvAudioView mgtvAudioView;
                IMgtvRenderView.ISurfaceHolder iSurfaceHolder2;
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface destroy. threadId:" + Thread.currentThread().getId());
                MgtvAudioView.this.mLastSurfaceDestroy = z2;
                if (MgtvAudioView.this.mRenderView != null && iSurfaceHolder.getRenderView() != MgtvAudioView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceDestroyed: unmatched render callback\n");
                    return;
                }
                String logTag2 = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag2, "onSurfaceDestroyed " + iSurfaceHolder);
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceDestroyed();
                }
                if (z2 && (iSurfaceHolder2 = MgtvAudioView.this.mSurfaceHolder) != null) {
                    iSurfaceHolder2.releaseSurface();
                }
                MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                mgtvAudioView2.mSurfaceHolder = null;
                if (!mgtvAudioView2.isOnlyAudioMode()) {
                    MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                    if (!mgtvAudioView3.mBackPlayEnable) {
                        mgtvAudioView3.videoSurfaceDestroyed();
                        mgtvAudioView = MgtvAudioView.this;
                        if (mgtvAudioView.mCurrentUri != null || mgtvAudioView.mCurrentState == -1 || MgtvAudioView.this.mCurrentState == 5) {
                            return;
                        }
                        MgtvAudioView.this.mStartLeaveTimestamp = System.currentTimeMillis();
                        return;
                    }
                }
                MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                if (mgtvAudioView4.mBackPlayEnable && (mgtvMediaPlayer = mgtvAudioView4.mMediaPlayer) != null) {
                    mgtvMediaPlayer.setSurfaceHolder(null);
                }
                mgtvAudioView = MgtvAudioView.this;
                if (mgtvAudioView.mCurrentUri != null) {
                }
            }
        };
        this.mFilterCallback = new f.a() { // from class: com.hunantv.media.widget.MgtvAudioView.2
            public void onInfo(int i2, int i22, String str) {
                if (i2 == 1) {
                    MgtvAudioView.this.mRenderType = i22;
                    MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                    ReportParams reportParams = mgtvAudioView.mReportParams;
                    if (reportParams != null) {
                        reportParams.setRenderType(mgtvAudioView.mRenderType);
                    }
                } else if (i2 != 3) {
                } else {
                    MgtvAudioView.this.mEnhanceQualityType = i22;
                    MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                    ReportParams reportParams2 = mgtvAudioView2.mReportParams;
                    if (reportParams2 != null) {
                        reportParams2.setEnhanceQualityType(mgtvAudioView2.mEnhanceQualityType);
                    }
                }
            }
        };
        this.mRenderWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvAudioView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "opengl render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mSizeChangedListener = new MgtvPlayerListener.OnVideoSizeChangedListener() { // from class: com.hunantv.media.widget.MgtvAudioView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i2, int i22) {
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                mgtvAudioView.originalVideoWidth = mgtvAudioView.mVideoWidth = mgtvAudioView.mMediaPlayer.getVideoWidth();
                MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                mgtvAudioView2.originalVideoHeight = mgtvAudioView2.mVideoHeight = mgtvAudioView2.mMediaPlayer.getVideoHeight();
                MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                mgtvAudioView3.mVideoSarNum = mgtvAudioView3.mMediaPlayer.getVideoSarNum();
                MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                mgtvAudioView4.mVideoSarDen = mgtvAudioView4.mMediaPlayer.getVideoSarDen();
                if (MgtvAudioView.this.mVideoWidth != 0 && MgtvAudioView.this.mVideoHeight != 0) {
                    if (MgtvAudioView.this.mRenderView != null) {
                        MgtvAudioView.this.mRenderView.setVideoSize(MgtvAudioView.this.mVideoWidth, MgtvAudioView.this.mVideoHeight);
                        if (MgtvAudioView.this.mVideoSarNum > 0 && MgtvAudioView.this.mVideoSarDen > 0) {
                            MgtvAudioView.this.mRenderView.setVideoSampleAspectRatio(MgtvAudioView.this.mVideoSarNum, MgtvAudioView.this.mVideoSarDen);
                        }
                    }
                    MgtvAudioView.this.requestLayout();
                }
                if (MgtvAudioView.this.mOnVideoSizeChangedListener != null) {
                    MgtvAudioView.this.mOnVideoSizeChangedListener.onVideoSizeChanged(i2, i22);
                }
            }
        };
        this.mPreparedListener = new MgtvPlayerListener.OnPreparedListener() { // from class: com.hunantv.media.widget.MgtvAudioView.5
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPreparedListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPrepared() {
                /*
                    r4 = this;
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    r1 = 2
                    com.hunantv.media.widget.MgtvAudioView.access$2700(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoWidth()
                    int r1 = com.hunantv.media.widget.MgtvAudioView.access$2102(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView.access$2002(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoHeight()
                    int r1 = com.hunantv.media.widget.MgtvAudioView.access$2302(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView.access$2202(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2100(r0)
                    r1 = 3
                    if (r0 == 0) goto Lb5
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2300(r0)
                    if (r0 == 0) goto Lb5
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "video size: "
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    r0.append(r2)
                    java.lang.String r2 = "/"
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2300(r2)
                    r0.append(r2)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r2 = "@@@@"
                    com.hunantv.media.player.pragma.DebugLog.i(r2, r0)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    if (r0 == 0) goto L7c
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    com.hunantv.media.widget.MgtvAudioView r3 = com.hunantv.media.widget.MgtvAudioView.this
                    int r3 = com.hunantv.media.widget.MgtvAudioView.access$2300(r3)
                    r0.setVideoSize(r2, r3)
                L7c:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    if (r0 == 0) goto L90
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    boolean r0 = r0.shouldWaitForResize()
                    if (r0 == 0) goto Lac
                L90:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2800(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    if (r0 != r2) goto Lc2
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2900(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2300(r2)
                    if (r0 != r2) goto Lc2
                Lac:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$3000(r0)
                    if (r0 != r1) goto Lc2
                    goto Lbd
                Lb5:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$3000(r0)
                    if (r0 != r1) goto Lc2
                Lbd:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    r0.start()
                Lc2:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvAudioView.access$3100(r0)
                    if (r0 == 0) goto Ld3
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvAudioView.access$3100(r0)
                    r0.onPrepared()
                Ld3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvAudioView.AnonymousClass5.onPrepared():void");
            }
        };
        this.mCompletionListener = new MgtvPlayerListener.OnCompletionListener() { // from class: com.hunantv.media.widget.MgtvAudioView.6
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnCompletionListener
            public void onCompletion(int i2, int i22) {
                if (i2 != 0) {
                    MgtvAudioView.this.stopInner();
                }
                MgtvAudioView.this.changeCurrentState(5);
                MgtvAudioView.this.mTargetState = 5;
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "-------------on onCompletion what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnCompletionListener != null) {
                    MgtvAudioView.this.mOnCompletionListener.onCompletion(i2, i22);
                }
            }
        };
        this.mInfoListener = new MgtvPlayerListener.OnInfoListener() { // from class: com.hunantv.media.widget.MgtvAudioView.7
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
                        logTag = MgtvAudioView.this.getLogTag();
                        sb = new StringBuilder();
                        str = "video fps is ";
                    } else if (i2 == 2820) {
                        logTag = MgtvAudioView.this.getLogTag();
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
                        String logTag2 = MgtvAudioView.this.getLogTag();
                        DebugLog.i(logTag2, "MEDIA_INFO_PLAYBACK_STATE_CHANGED:" + i22);
                        if (MgtvAudioView.this.mOnUpdateStatusListener != null) {
                            MgtvAudioView.this.mOnUpdateStatusListener.onUpdateStatus();
                        }
                    } else if (i2 == 10001) {
                        String logTag3 = MgtvAudioView.this.getLogTag();
                        DebugLog.w(logTag3, "video rotation changed,extra(degree) is " + i22);
                        MgtvAudioView.this.mVideoRotationDegree = i22;
                        if (MgtvAudioView.this.mRenderView != null) {
                            MgtvAudioView.this.mRenderView.setVideoRotation(MgtvAudioView.this.mVideoRotationDegree);
                        }
                    } else if (i2 == 200001) {
                        MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                        if (i22 == 1) {
                            mgtvAudioView.mMgtvMediaPlayerHardwareMode = false;
                        } else {
                            mgtvAudioView.mMgtvMediaPlayerHardwareMode = true;
                        }
                        MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                        mgtvAudioView2.convertRender(mgtvAudioView2.mRenderViewType);
                    } else if (i2 == 3) {
                        DebugLog.w(MgtvAudioView.this.getLogTag(), "video decode succeeded, start rendering");
                        MgtvAudioView.this.onVideoRenderStart();
                        if (MgtvAudioView.this.mOnInfoListener != null) {
                            MgtvAudioView.this.mOnInfoListener.onInfo(900, i22);
                        }
                        return true;
                    } else if (i2 == 4) {
                        DebugLog.w(MgtvAudioView.this.getLogTag(), "audio decode succeeded, start rendering");
                        if (MgtvAudioView.this.isOnlyAudioMode()) {
                            if (MgtvAudioView.this.mOnInfoListener != null) {
                                MgtvAudioView.this.mOnInfoListener.onInfo(900, i22);
                            }
                            return true;
                        }
                    } else if (i2 != 5) {
                        if (i2 == 6) {
                            if (i22 == 0) {
                                MgtvAudioView.this.mMgtvMediaPlayerHardwareMode = false;
                            } else if (i22 == 1) {
                                MgtvAudioView.this.mMgtvMediaPlayerHardwareMode = true;
                            }
                            logTag = MgtvAudioView.this.getLogTag();
                            sb = new StringBuilder();
                            str = "video decoder open,extra is ";
                        } else if (i2 != 7) {
                            switch (i2) {
                                case 700:
                                    String logTag4 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag4, "It's too complex for the decoder, extra is " + i22);
                                    i2 = 700;
                                    break;
                                case 701:
                                    String logTag5 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag5, "buffer start speed:" + MgtvAudioView.this.getDLSpeedFormat());
                                    i2 = 701;
                                    break;
                                case 702:
                                    String logTag6 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag6, "buffer end speed:" + MgtvAudioView.this.getDLSpeedFormat());
                                    i2 = 702;
                                    break;
                                default:
                                    switch (i2) {
                                        case 800:
                                            String logTag7 = MgtvAudioView.this.getLogTag();
                                            DebugLog.e(logTag7, "Bad interleaving of media file, audio/video are not well-formed, extra is " + i22);
                                            i2 = 800;
                                            break;
                                        case 801:
                                            String logTag8 = MgtvAudioView.this.getLogTag();
                                            DebugLog.w(logTag8, "The stream not seekable status, extra is " + i22);
                                            i2 = 801;
                                            MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                                            if (i22 == 1) {
                                                mgtvAudioView3.mIsLive = true;
                                                logTag = MgtvAudioView.this.getLogTag();
                                                str2 = "The stream is live stream,can not seekable ";
                                            } else {
                                                mgtvAudioView3.mIsLive = false;
                                                logTag = MgtvAudioView.this.getLogTag();
                                                str2 = "The stream is not live stream,can seekable ";
                                            }
                                            DebugLog.w(logTag, str2);
                                            break;
                                        case 802:
                                            String logTag9 = MgtvAudioView.this.getLogTag();
                                            DebugLog.w(logTag9, "A new set of metadata is available, extra is " + i22);
                                            i2 = 802;
                                            break;
                                        default:
                                            logTag = MgtvAudioView.this.getLogTag();
                                            switch (i2) {
                                                case MgtvMediaPlayer.MEDIA_INFO_DATA_PROTOCOL /* 2803 */:
                                                    DebugLog.w(logTag, "data source type is " + i22);
                                                    MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                                                    MgtvMediaPlayer mgtvMediaPlayer = mgtvAudioView4.mMediaPlayer;
                                                    if (mgtvMediaPlayer != null) {
                                                        mgtvAudioView4.mDataSourceType = mgtvMediaPlayer.getDataSourceType();
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
                    String logTag10 = MgtvAudioView.this.getLogTag();
                    DebugLog.w(logTag10, "Unknown info, extra is " + i22);
                    i2 = 1;
                }
                if (MgtvAudioView.this.mOnInfoListener != null) {
                    MgtvAudioView.this.mOnInfoListener.onInfo(i2, i22);
                }
                return true;
            }
        };
        this.reportErrWithoutMpManager = null;
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.widget.MgtvAudioView.8
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.w(logTag, "onError what:" + i2 + ",extra:" + i22);
                if ((i2 == 7001004 || i2 == 7000001 || i2 == 7000002 || i2 == 7000003 || i2 == 7000004 || i2 == 7000005 || i2 == 7000006 || i2 == 7000009 || i2 == 7000010 || i2 == 7000011 || i2 == 7000012 || i2 == 7000013 || i2 == 7001999 || i2 == 7001998 || i2 == 7000110) && MgtvAudioView.this.reportErrWithoutMpManager != null) {
                    MgtvAudioView.this.reportErrWithoutMpManager.F(i2, i22);
                }
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvAudioView.mMediaPlayer;
                if (mgtvMediaPlayer == null || i2 != 7000006) {
                    if (mgtvMediaPlayer != null && mgtvAudioView.mCurrentState != -1) {
                        MgtvAudioView.this.mMediaPlayer.stop();
                    }
                    MgtvAudioView.this.changeCurrentState(-1);
                    MgtvAudioView.this.mTargetState = -1;
                } else {
                    mgtvAudioView.releaseNoStatus();
                    MgtvAudioView.this.changeCurrentState(0);
                    MgtvAudioView.this.mTargetState = 0;
                }
                MgtvAudioView.this.cleanUri();
                return MgtvAudioView.this.mOnErrorListener != null && MgtvAudioView.this.mOnErrorListener.onError(i2, i22);
            }
        };
        this.mSeekCompleteListener = new MgtvPlayerListener.OnSeekCompleteListener() { // from class: com.hunantv.media.widget.MgtvAudioView.9
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSeekCompleteListener
            public void onSeekComplete(int i2, int i22) {
                if (MgtvAudioView.this.mOnSeekCompleteListener != null) {
                    String logTag = MgtvAudioView.this.getLogTag();
                    DebugLog.i(logTag, "onSeekComplete seekTargetTime:" + i2 + ",errorCode:" + i22);
                    MgtvAudioView.this.mOnSeekCompleteListener.onSeekComplete();
                }
            }
        };
        this.mBufferingUpdateListener = new MgtvPlayerListener.OnBufferingUpdateListener() { // from class: com.hunantv.media.widget.MgtvAudioView.10
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingUpdateListener
            public void onBufferingUpdate(int i2) {
                if (MgtvAudioView.this.mOnBufferringUpdateListener != null) {
                    MgtvAudioView.this.mOnBufferringUpdateListener.onBufferingUpdate(i2);
                }
            }
        };
        this.mBufferingTimeoutListener = new MgtvPlayerListener.OnBufferingTimeoutListener() { // from class: com.hunantv.media.widget.MgtvAudioView.11
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingTimeoutListener
            public boolean onBufferingTimeout(int i2, int i22) {
                MgtvMediaPlayer mgtvMediaPlayer = MgtvAudioView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.stop();
                }
                MgtvAudioView.this.changeCurrentState(-1);
                MgtvAudioView.this.mTargetState = -1;
                MgtvAudioView.this.cleanUri();
                if (MgtvAudioView.this.mOnErrorListener == null || MgtvAudioView.this.mOnErrorListener.onError(i2, i22)) {
                }
                return true;
            }
        };
        this.mSwitchSourceListener = new MgtvPlayerListener.OnSwitchSourceListener() { // from class: com.hunantv.media.widget.MgtvAudioView.12
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceComplete(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceComplete url:" + str + ",type:" + i2 + ",time:" + i22);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceSuccess(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceFailed(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceFailed url:" + str + ",what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceFailed(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceInfo(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceInfo url:" + str + ",event:" + i2 + ",time:" + i22);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceInfo(str, i2, i22);
                }
            }
        };
        this.mPlayerWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvAudioView.13
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "onTsSkip tsUrl:" + str);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onTsSkip(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "player render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mGifRecorder = new GifRecorder();
        this.mStartListener = new MgtvPlayerListener.OnStartListener() { // from class: com.hunantv.media.widget.MgtvAudioView.14
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnStartListener
            public void onStart() {
                DebugLog.d(MgtvAudioView.this.getLogTag(), "mgtvcore onStart");
                if (MgtvAudioView.this.mEnableCoreStartPauseListen) {
                    MgtvAudioView.this.callbackOnStart();
                }
            }
        };
        this.mPauseListener = new MgtvPlayerListener.OnPauseListener() { // from class: com.hunantv.media.widget.MgtvAudioView.15
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPauseListener
            public void onPause() {
                DebugLog.d(MgtvAudioView.this.getLogTag(), "mgtvcore onPause");
                if (MgtvAudioView.this.mEnableCoreStartPauseListen) {
                    MgtvAudioView.this.callbackOnPause();
                }
            }
        };
        this.mRecordVideoListener = new MgtvPlayerListener.OnRecordVideoListener() { // from class: com.hunantv.media.widget.MgtvAudioView.16
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoErr(int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onRecordVideoErr what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnRecordListener != null) {
                    MgtvAudioView.this.mOnRecordListener.onRecordError(i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoInfo(int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "onRecordVideoInfo what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnRecordListener != null) {
                    if (i2 == 20) {
                        MgtvAudioView.this.mOnRecordListener.onRecordStart(MgtvAudioView.this.mRecordFilePath);
                    } else if (i2 == 30) {
                        MgtvAudioView.this.mOnRecordListener.onRecordStop();
                    }
                    MgtvAudioView.this.mOnRecordListener.onRecordInfo(i2, i22);
                }
            }
        };
        this.mLoadDataListener = new MgtvPlayerListener.OnLoadDataListener() { // from class: com.hunantv.media.widget.MgtvAudioView.17
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onAfterLoadDataPaused() {
                if (MgtvAudioView.this.mOnLoadDataListener != null) {
                    MgtvAudioView.this.mOnLoadDataListener.onAfterLoadDataPaused();
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onBeforeLoadDataResume() {
                if (MgtvAudioView.this.mOnLoadDataListener != null) {
                    MgtvAudioView.this.mOnLoadDataListener.onBeforeLoadDataResume();
                }
            }
        };
        this.mEnableTexture = z;
        initVideoView(context, i);
    }

    public MgtvAudioView(Context context, int i, boolean z, boolean z2) {
        super(context);
        this.mLastSurfaceDestroy = true;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mMgtvMediaPlayerHardwareMode = false;
        this.mForceDecodeMode = false;
        this.mFromSurfaceDestroyToPlay = false;
        this.mFromSurfaceDestroyPlayPosition = 0;
        this.mErrorMsg = "";
        this.mHasSurfaceHolderDestroy = false;
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
        this.mEnableMgtvMediaCodec = true;
        this.mEnableJavaIPCache = false;
        this.mLastFrameRecovery = true;
        this.mWeakNetSpeed = 0;
        this.mWeakBufferTimeoutMs = 0;
        this.mTsNotSkip = false;
        this.mLoadMaxRetryTime = 0;
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
        this.mStartPosMs = 0;
        this.mFlowDataStatistic = new FlowDataStatistic();
        this.mSkipLoopFilterType = MgtvMediaPlayer.SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mSHCallback = new IMgtvRenderView.IRenderCallback() { // from class: com.hunantv.media.widget.MgtvAudioView.1
            private void bindHolder(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22) {
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                if (mgtvAudioView.mMediaPlayer == null) {
                    mgtvAudioView.openVideo();
                    return;
                }
                if (!mgtvAudioView.mEnableMediacodecSW && mgtvAudioView.mHasSurfaceHolderDestroy && MgtvAudioView.this.mRebindTexture) {
                    MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                    if (mgtvAudioView2.mCurrentUri != null) {
                        mgtvAudioView2.setStartPosMs(mgtvAudioView2.mMediaPlayer.getCurrentPosition());
                        MgtvAudioView.this.openVideo();
                    }
                }
                if (!needOpenVideo()) {
                    MgtvAudioView.this.mMediaPlayer.setSurfaceHolder(iSurfaceHolder);
                    MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                    if (mgtvAudioView3.mCurrentUri != null) {
                        if (mgtvAudioView3.mFromSurfaceDestroyToPlay && MgtvAudioView.this.mMgtvMediaPlayerHardwareMode) {
                            MgtvAudioView.this.mFromSurfaceDestroyToPlay = false;
                            MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                            mgtvAudioView4.mMediaPlayer.seekTo(mgtvAudioView4.mFromSurfaceDestroyPlayPosition, false, true);
                            MgtvAudioView.this.mFromSurfaceDestroyPlayPosition = 0;
                        }
                        if (MgtvAudioView.this.mLastFrameRecovery && (!MgtvAudioView.this.isHardware() || MgtvAudioView.this.mLastSurfaceDestroy)) {
                            MgtvAudioView.this.mMediaPlayer.setPlaybackStep();
                        }
                    }
                    MgtvAudioView mgtvAudioView5 = MgtvAudioView.this;
                    mgtvAudioView5.mSizeChangedListener.onVideoSizeChanged(mgtvAudioView5.mMediaPlayer.getVideoWidth(), MgtvAudioView.this.mMediaPlayer.getVideoHeight());
                    MgtvAudioView.this.autoStartByStateAndSize(i2, i22);
                    return;
                }
                MgtvAudioView.this.openVideo();
            }

            private boolean needOpenVideo() {
                return MgtvAudioView.this.mOpenVideoWhenSurfaceCreate && MgtvAudioView.this.mCurrentUri != null;
            }

            private void videoSurfaceChanged(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22, int i3) {
                if (MgtvAudioView.this.mRenderView == null || iSurfaceHolder.getRenderView() == MgtvAudioView.this.mRenderView.getRenderView()) {
                    MgtvAudioView.this.autoStartByStateAndSize(i22, i3);
                } else {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceChanged: unmatched render callback\n");
                }
            }

            private void videoSurfaceCreate(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22) {
                SurfaceHolder surfaceHolder;
                if (MgtvAudioView.this.mRenderView != null && iSurfaceHolder.getRenderView() != MgtvAudioView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "videoSurfaceCreate " + iSurfaceHolder);
                if (MgtvAudioView.this.mRenderView == null || MgtvAudioView.this.mRenderView.getRenderViewType() != 0 || ((surfaceHolder = MgtvAudioView.this.mSurfaceHolder.getSurfaceHolder()) != null && surfaceHolder.getSurface() != null && surfaceHolder.getSurface().isValid())) {
                    bindHolder(iSurfaceHolder, i2, i22);
                    return;
                }
                MgtvAudioView.this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SURFACE_FAILED, 1);
                MgtvAudioView.this.mErrorMsg = "surfaceCreated surface is invalid";
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceChanged(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22, int i3) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface changed. threadId:" + Thread.currentThread().getId());
                if (!MgtvAudioView.this.isOnlyAudioMode() && !MgtvAudioView.this.mBackPlayEnable) {
                    videoSurfaceChanged(iSurfaceHolder, i2, i22, i3);
                }
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceChanged();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceCreated(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface create. threadId:" + Thread.currentThread().getId());
                if (MgtvAudioView.this.mStartLeaveTimestamp > 0) {
                    long currentTimeMillis = (System.currentTimeMillis() - MgtvAudioView.this.mStartLeaveTimestamp) / 1000;
                    if (currentTimeMillis > 540) {
                        if (MgtvAudioView.this.mOnWarningListener != null) {
                            MgtvPlayerListener.OnWarningListener onWarningListener = MgtvAudioView.this.mOnWarningListener;
                            onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_LEAVE_TIME_INVALID, MgtvAudioView.this.mCurrentState + "", "", null);
                        }
                        ReportParams reportParams = MgtvAudioView.this.mReportParams;
                        if (reportParams != null) {
                            reportParams.setLeaveTimeS(currentTimeMillis);
                        }
                    }
                }
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                mgtvAudioView.mSurfaceHolder = iSurfaceHolder;
                if (!mgtvAudioView.isOnlyAudioMode() && !MgtvAudioView.this.mBackPlayEnable) {
                    videoSurfaceCreate(iSurfaceHolder, i2, i22);
                }
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceCreated();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceDestroyed(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, boolean z22) {
                MgtvMediaPlayer mgtvMediaPlayer;
                MgtvAudioView mgtvAudioView;
                IMgtvRenderView.ISurfaceHolder iSurfaceHolder2;
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface destroy. threadId:" + Thread.currentThread().getId());
                MgtvAudioView.this.mLastSurfaceDestroy = z22;
                if (MgtvAudioView.this.mRenderView != null && iSurfaceHolder.getRenderView() != MgtvAudioView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceDestroyed: unmatched render callback\n");
                    return;
                }
                String logTag2 = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag2, "onSurfaceDestroyed " + iSurfaceHolder);
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceDestroyed();
                }
                if (z22 && (iSurfaceHolder2 = MgtvAudioView.this.mSurfaceHolder) != null) {
                    iSurfaceHolder2.releaseSurface();
                }
                MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                mgtvAudioView2.mSurfaceHolder = null;
                if (!mgtvAudioView2.isOnlyAudioMode()) {
                    MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                    if (!mgtvAudioView3.mBackPlayEnable) {
                        mgtvAudioView3.videoSurfaceDestroyed();
                        mgtvAudioView = MgtvAudioView.this;
                        if (mgtvAudioView.mCurrentUri != null || mgtvAudioView.mCurrentState == -1 || MgtvAudioView.this.mCurrentState == 5) {
                            return;
                        }
                        MgtvAudioView.this.mStartLeaveTimestamp = System.currentTimeMillis();
                        return;
                    }
                }
                MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                if (mgtvAudioView4.mBackPlayEnable && (mgtvMediaPlayer = mgtvAudioView4.mMediaPlayer) != null) {
                    mgtvMediaPlayer.setSurfaceHolder(null);
                }
                mgtvAudioView = MgtvAudioView.this;
                if (mgtvAudioView.mCurrentUri != null) {
                }
            }
        };
        this.mFilterCallback = new f.a() { // from class: com.hunantv.media.widget.MgtvAudioView.2
            public void onInfo(int i2, int i22, String str) {
                if (i2 == 1) {
                    MgtvAudioView.this.mRenderType = i22;
                    MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                    ReportParams reportParams = mgtvAudioView.mReportParams;
                    if (reportParams != null) {
                        reportParams.setRenderType(mgtvAudioView.mRenderType);
                    }
                } else if (i2 != 3) {
                } else {
                    MgtvAudioView.this.mEnhanceQualityType = i22;
                    MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                    ReportParams reportParams2 = mgtvAudioView2.mReportParams;
                    if (reportParams2 != null) {
                        reportParams2.setEnhanceQualityType(mgtvAudioView2.mEnhanceQualityType);
                    }
                }
            }
        };
        this.mRenderWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvAudioView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "opengl render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mSizeChangedListener = new MgtvPlayerListener.OnVideoSizeChangedListener() { // from class: com.hunantv.media.widget.MgtvAudioView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i2, int i22) {
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                mgtvAudioView.originalVideoWidth = mgtvAudioView.mVideoWidth = mgtvAudioView.mMediaPlayer.getVideoWidth();
                MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                mgtvAudioView2.originalVideoHeight = mgtvAudioView2.mVideoHeight = mgtvAudioView2.mMediaPlayer.getVideoHeight();
                MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                mgtvAudioView3.mVideoSarNum = mgtvAudioView3.mMediaPlayer.getVideoSarNum();
                MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                mgtvAudioView4.mVideoSarDen = mgtvAudioView4.mMediaPlayer.getVideoSarDen();
                if (MgtvAudioView.this.mVideoWidth != 0 && MgtvAudioView.this.mVideoHeight != 0) {
                    if (MgtvAudioView.this.mRenderView != null) {
                        MgtvAudioView.this.mRenderView.setVideoSize(MgtvAudioView.this.mVideoWidth, MgtvAudioView.this.mVideoHeight);
                        if (MgtvAudioView.this.mVideoSarNum > 0 && MgtvAudioView.this.mVideoSarDen > 0) {
                            MgtvAudioView.this.mRenderView.setVideoSampleAspectRatio(MgtvAudioView.this.mVideoSarNum, MgtvAudioView.this.mVideoSarDen);
                        }
                    }
                    MgtvAudioView.this.requestLayout();
                }
                if (MgtvAudioView.this.mOnVideoSizeChangedListener != null) {
                    MgtvAudioView.this.mOnVideoSizeChangedListener.onVideoSizeChanged(i2, i22);
                }
            }
        };
        this.mPreparedListener = new MgtvPlayerListener.OnPreparedListener() { // from class: com.hunantv.media.widget.MgtvAudioView.5
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPreparedListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPrepared() {
                /*
                    r4 = this;
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    r1 = 2
                    com.hunantv.media.widget.MgtvAudioView.access$2700(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoWidth()
                    int r1 = com.hunantv.media.widget.MgtvAudioView.access$2102(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView.access$2002(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoHeight()
                    int r1 = com.hunantv.media.widget.MgtvAudioView.access$2302(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView.access$2202(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2100(r0)
                    r1 = 3
                    if (r0 == 0) goto Lb5
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2300(r0)
                    if (r0 == 0) goto Lb5
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "video size: "
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    r0.append(r2)
                    java.lang.String r2 = "/"
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2300(r2)
                    r0.append(r2)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r2 = "@@@@"
                    com.hunantv.media.player.pragma.DebugLog.i(r2, r0)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    if (r0 == 0) goto L7c
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    com.hunantv.media.widget.MgtvAudioView r3 = com.hunantv.media.widget.MgtvAudioView.this
                    int r3 = com.hunantv.media.widget.MgtvAudioView.access$2300(r3)
                    r0.setVideoSize(r2, r3)
                L7c:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    if (r0 == 0) goto L90
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    boolean r0 = r0.shouldWaitForResize()
                    if (r0 == 0) goto Lac
                L90:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2800(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    if (r0 != r2) goto Lc2
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2900(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2300(r2)
                    if (r0 != r2) goto Lc2
                Lac:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$3000(r0)
                    if (r0 != r1) goto Lc2
                    goto Lbd
                Lb5:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$3000(r0)
                    if (r0 != r1) goto Lc2
                Lbd:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    r0.start()
                Lc2:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvAudioView.access$3100(r0)
                    if (r0 == 0) goto Ld3
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvAudioView.access$3100(r0)
                    r0.onPrepared()
                Ld3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvAudioView.AnonymousClass5.onPrepared():void");
            }
        };
        this.mCompletionListener = new MgtvPlayerListener.OnCompletionListener() { // from class: com.hunantv.media.widget.MgtvAudioView.6
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnCompletionListener
            public void onCompletion(int i2, int i22) {
                if (i2 != 0) {
                    MgtvAudioView.this.stopInner();
                }
                MgtvAudioView.this.changeCurrentState(5);
                MgtvAudioView.this.mTargetState = 5;
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "-------------on onCompletion what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnCompletionListener != null) {
                    MgtvAudioView.this.mOnCompletionListener.onCompletion(i2, i22);
                }
            }
        };
        this.mInfoListener = new MgtvPlayerListener.OnInfoListener() { // from class: com.hunantv.media.widget.MgtvAudioView.7
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
                        logTag = MgtvAudioView.this.getLogTag();
                        sb = new StringBuilder();
                        str = "video fps is ";
                    } else if (i2 == 2820) {
                        logTag = MgtvAudioView.this.getLogTag();
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
                        String logTag2 = MgtvAudioView.this.getLogTag();
                        DebugLog.i(logTag2, "MEDIA_INFO_PLAYBACK_STATE_CHANGED:" + i22);
                        if (MgtvAudioView.this.mOnUpdateStatusListener != null) {
                            MgtvAudioView.this.mOnUpdateStatusListener.onUpdateStatus();
                        }
                    } else if (i2 == 10001) {
                        String logTag3 = MgtvAudioView.this.getLogTag();
                        DebugLog.w(logTag3, "video rotation changed,extra(degree) is " + i22);
                        MgtvAudioView.this.mVideoRotationDegree = i22;
                        if (MgtvAudioView.this.mRenderView != null) {
                            MgtvAudioView.this.mRenderView.setVideoRotation(MgtvAudioView.this.mVideoRotationDegree);
                        }
                    } else if (i2 == 200001) {
                        MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                        if (i22 == 1) {
                            mgtvAudioView.mMgtvMediaPlayerHardwareMode = false;
                        } else {
                            mgtvAudioView.mMgtvMediaPlayerHardwareMode = true;
                        }
                        MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                        mgtvAudioView2.convertRender(mgtvAudioView2.mRenderViewType);
                    } else if (i2 == 3) {
                        DebugLog.w(MgtvAudioView.this.getLogTag(), "video decode succeeded, start rendering");
                        MgtvAudioView.this.onVideoRenderStart();
                        if (MgtvAudioView.this.mOnInfoListener != null) {
                            MgtvAudioView.this.mOnInfoListener.onInfo(900, i22);
                        }
                        return true;
                    } else if (i2 == 4) {
                        DebugLog.w(MgtvAudioView.this.getLogTag(), "audio decode succeeded, start rendering");
                        if (MgtvAudioView.this.isOnlyAudioMode()) {
                            if (MgtvAudioView.this.mOnInfoListener != null) {
                                MgtvAudioView.this.mOnInfoListener.onInfo(900, i22);
                            }
                            return true;
                        }
                    } else if (i2 != 5) {
                        if (i2 == 6) {
                            if (i22 == 0) {
                                MgtvAudioView.this.mMgtvMediaPlayerHardwareMode = false;
                            } else if (i22 == 1) {
                                MgtvAudioView.this.mMgtvMediaPlayerHardwareMode = true;
                            }
                            logTag = MgtvAudioView.this.getLogTag();
                            sb = new StringBuilder();
                            str = "video decoder open,extra is ";
                        } else if (i2 != 7) {
                            switch (i2) {
                                case 700:
                                    String logTag4 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag4, "It's too complex for the decoder, extra is " + i22);
                                    i2 = 700;
                                    break;
                                case 701:
                                    String logTag5 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag5, "buffer start speed:" + MgtvAudioView.this.getDLSpeedFormat());
                                    i2 = 701;
                                    break;
                                case 702:
                                    String logTag6 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag6, "buffer end speed:" + MgtvAudioView.this.getDLSpeedFormat());
                                    i2 = 702;
                                    break;
                                default:
                                    switch (i2) {
                                        case 800:
                                            String logTag7 = MgtvAudioView.this.getLogTag();
                                            DebugLog.e(logTag7, "Bad interleaving of media file, audio/video are not well-formed, extra is " + i22);
                                            i2 = 800;
                                            break;
                                        case 801:
                                            String logTag8 = MgtvAudioView.this.getLogTag();
                                            DebugLog.w(logTag8, "The stream not seekable status, extra is " + i22);
                                            i2 = 801;
                                            MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                                            if (i22 == 1) {
                                                mgtvAudioView3.mIsLive = true;
                                                logTag = MgtvAudioView.this.getLogTag();
                                                str2 = "The stream is live stream,can not seekable ";
                                            } else {
                                                mgtvAudioView3.mIsLive = false;
                                                logTag = MgtvAudioView.this.getLogTag();
                                                str2 = "The stream is not live stream,can seekable ";
                                            }
                                            DebugLog.w(logTag, str2);
                                            break;
                                        case 802:
                                            String logTag9 = MgtvAudioView.this.getLogTag();
                                            DebugLog.w(logTag9, "A new set of metadata is available, extra is " + i22);
                                            i2 = 802;
                                            break;
                                        default:
                                            logTag = MgtvAudioView.this.getLogTag();
                                            switch (i2) {
                                                case MgtvMediaPlayer.MEDIA_INFO_DATA_PROTOCOL /* 2803 */:
                                                    DebugLog.w(logTag, "data source type is " + i22);
                                                    MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                                                    MgtvMediaPlayer mgtvMediaPlayer = mgtvAudioView4.mMediaPlayer;
                                                    if (mgtvMediaPlayer != null) {
                                                        mgtvAudioView4.mDataSourceType = mgtvMediaPlayer.getDataSourceType();
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
                    String logTag10 = MgtvAudioView.this.getLogTag();
                    DebugLog.w(logTag10, "Unknown info, extra is " + i22);
                    i2 = 1;
                }
                if (MgtvAudioView.this.mOnInfoListener != null) {
                    MgtvAudioView.this.mOnInfoListener.onInfo(i2, i22);
                }
                return true;
            }
        };
        this.reportErrWithoutMpManager = null;
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.widget.MgtvAudioView.8
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.w(logTag, "onError what:" + i2 + ",extra:" + i22);
                if ((i2 == 7001004 || i2 == 7000001 || i2 == 7000002 || i2 == 7000003 || i2 == 7000004 || i2 == 7000005 || i2 == 7000006 || i2 == 7000009 || i2 == 7000010 || i2 == 7000011 || i2 == 7000012 || i2 == 7000013 || i2 == 7001999 || i2 == 7001998 || i2 == 7000110) && MgtvAudioView.this.reportErrWithoutMpManager != null) {
                    MgtvAudioView.this.reportErrWithoutMpManager.F(i2, i22);
                }
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvAudioView.mMediaPlayer;
                if (mgtvMediaPlayer == null || i2 != 7000006) {
                    if (mgtvMediaPlayer != null && mgtvAudioView.mCurrentState != -1) {
                        MgtvAudioView.this.mMediaPlayer.stop();
                    }
                    MgtvAudioView.this.changeCurrentState(-1);
                    MgtvAudioView.this.mTargetState = -1;
                } else {
                    mgtvAudioView.releaseNoStatus();
                    MgtvAudioView.this.changeCurrentState(0);
                    MgtvAudioView.this.mTargetState = 0;
                }
                MgtvAudioView.this.cleanUri();
                return MgtvAudioView.this.mOnErrorListener != null && MgtvAudioView.this.mOnErrorListener.onError(i2, i22);
            }
        };
        this.mSeekCompleteListener = new MgtvPlayerListener.OnSeekCompleteListener() { // from class: com.hunantv.media.widget.MgtvAudioView.9
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSeekCompleteListener
            public void onSeekComplete(int i2, int i22) {
                if (MgtvAudioView.this.mOnSeekCompleteListener != null) {
                    String logTag = MgtvAudioView.this.getLogTag();
                    DebugLog.i(logTag, "onSeekComplete seekTargetTime:" + i2 + ",errorCode:" + i22);
                    MgtvAudioView.this.mOnSeekCompleteListener.onSeekComplete();
                }
            }
        };
        this.mBufferingUpdateListener = new MgtvPlayerListener.OnBufferingUpdateListener() { // from class: com.hunantv.media.widget.MgtvAudioView.10
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingUpdateListener
            public void onBufferingUpdate(int i2) {
                if (MgtvAudioView.this.mOnBufferringUpdateListener != null) {
                    MgtvAudioView.this.mOnBufferringUpdateListener.onBufferingUpdate(i2);
                }
            }
        };
        this.mBufferingTimeoutListener = new MgtvPlayerListener.OnBufferingTimeoutListener() { // from class: com.hunantv.media.widget.MgtvAudioView.11
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingTimeoutListener
            public boolean onBufferingTimeout(int i2, int i22) {
                MgtvMediaPlayer mgtvMediaPlayer = MgtvAudioView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.stop();
                }
                MgtvAudioView.this.changeCurrentState(-1);
                MgtvAudioView.this.mTargetState = -1;
                MgtvAudioView.this.cleanUri();
                if (MgtvAudioView.this.mOnErrorListener == null || MgtvAudioView.this.mOnErrorListener.onError(i2, i22)) {
                }
                return true;
            }
        };
        this.mSwitchSourceListener = new MgtvPlayerListener.OnSwitchSourceListener() { // from class: com.hunantv.media.widget.MgtvAudioView.12
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceComplete(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceComplete url:" + str + ",type:" + i2 + ",time:" + i22);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceSuccess(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceFailed(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceFailed url:" + str + ",what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceFailed(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceInfo(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceInfo url:" + str + ",event:" + i2 + ",time:" + i22);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceInfo(str, i2, i22);
                }
            }
        };
        this.mPlayerWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvAudioView.13
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "onTsSkip tsUrl:" + str);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onTsSkip(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "player render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mGifRecorder = new GifRecorder();
        this.mStartListener = new MgtvPlayerListener.OnStartListener() { // from class: com.hunantv.media.widget.MgtvAudioView.14
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnStartListener
            public void onStart() {
                DebugLog.d(MgtvAudioView.this.getLogTag(), "mgtvcore onStart");
                if (MgtvAudioView.this.mEnableCoreStartPauseListen) {
                    MgtvAudioView.this.callbackOnStart();
                }
            }
        };
        this.mPauseListener = new MgtvPlayerListener.OnPauseListener() { // from class: com.hunantv.media.widget.MgtvAudioView.15
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPauseListener
            public void onPause() {
                DebugLog.d(MgtvAudioView.this.getLogTag(), "mgtvcore onPause");
                if (MgtvAudioView.this.mEnableCoreStartPauseListen) {
                    MgtvAudioView.this.callbackOnPause();
                }
            }
        };
        this.mRecordVideoListener = new MgtvPlayerListener.OnRecordVideoListener() { // from class: com.hunantv.media.widget.MgtvAudioView.16
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoErr(int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onRecordVideoErr what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnRecordListener != null) {
                    MgtvAudioView.this.mOnRecordListener.onRecordError(i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoInfo(int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "onRecordVideoInfo what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnRecordListener != null) {
                    if (i2 == 20) {
                        MgtvAudioView.this.mOnRecordListener.onRecordStart(MgtvAudioView.this.mRecordFilePath);
                    } else if (i2 == 30) {
                        MgtvAudioView.this.mOnRecordListener.onRecordStop();
                    }
                    MgtvAudioView.this.mOnRecordListener.onRecordInfo(i2, i22);
                }
            }
        };
        this.mLoadDataListener = new MgtvPlayerListener.OnLoadDataListener() { // from class: com.hunantv.media.widget.MgtvAudioView.17
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onAfterLoadDataPaused() {
                if (MgtvAudioView.this.mOnLoadDataListener != null) {
                    MgtvAudioView.this.mOnLoadDataListener.onAfterLoadDataPaused();
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onBeforeLoadDataResume() {
                if (MgtvAudioView.this.mOnLoadDataListener != null) {
                    MgtvAudioView.this.mOnLoadDataListener.onBeforeLoadDataResume();
                }
            }
        };
        this.mEnableTexture = z;
        this.mEnableOpengl = z2;
        initVideoView(context, i);
    }

    public MgtvAudioView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastSurfaceDestroy = true;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mMgtvMediaPlayerHardwareMode = false;
        this.mForceDecodeMode = false;
        this.mFromSurfaceDestroyToPlay = false;
        this.mFromSurfaceDestroyPlayPosition = 0;
        this.mErrorMsg = "";
        this.mHasSurfaceHolderDestroy = false;
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
        this.mEnableMgtvMediaCodec = true;
        this.mEnableJavaIPCache = false;
        this.mLastFrameRecovery = true;
        this.mWeakNetSpeed = 0;
        this.mWeakBufferTimeoutMs = 0;
        this.mTsNotSkip = false;
        this.mLoadMaxRetryTime = 0;
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
        this.mStartPosMs = 0;
        this.mFlowDataStatistic = new FlowDataStatistic();
        this.mSkipLoopFilterType = MgtvMediaPlayer.SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mSHCallback = new IMgtvRenderView.IRenderCallback() { // from class: com.hunantv.media.widget.MgtvAudioView.1
            private void bindHolder(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22) {
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                if (mgtvAudioView.mMediaPlayer == null) {
                    mgtvAudioView.openVideo();
                    return;
                }
                if (!mgtvAudioView.mEnableMediacodecSW && mgtvAudioView.mHasSurfaceHolderDestroy && MgtvAudioView.this.mRebindTexture) {
                    MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                    if (mgtvAudioView2.mCurrentUri != null) {
                        mgtvAudioView2.setStartPosMs(mgtvAudioView2.mMediaPlayer.getCurrentPosition());
                        MgtvAudioView.this.openVideo();
                    }
                }
                if (!needOpenVideo()) {
                    MgtvAudioView.this.mMediaPlayer.setSurfaceHolder(iSurfaceHolder);
                    MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                    if (mgtvAudioView3.mCurrentUri != null) {
                        if (mgtvAudioView3.mFromSurfaceDestroyToPlay && MgtvAudioView.this.mMgtvMediaPlayerHardwareMode) {
                            MgtvAudioView.this.mFromSurfaceDestroyToPlay = false;
                            MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                            mgtvAudioView4.mMediaPlayer.seekTo(mgtvAudioView4.mFromSurfaceDestroyPlayPosition, false, true);
                            MgtvAudioView.this.mFromSurfaceDestroyPlayPosition = 0;
                        }
                        if (MgtvAudioView.this.mLastFrameRecovery && (!MgtvAudioView.this.isHardware() || MgtvAudioView.this.mLastSurfaceDestroy)) {
                            MgtvAudioView.this.mMediaPlayer.setPlaybackStep();
                        }
                    }
                    MgtvAudioView mgtvAudioView5 = MgtvAudioView.this;
                    mgtvAudioView5.mSizeChangedListener.onVideoSizeChanged(mgtvAudioView5.mMediaPlayer.getVideoWidth(), MgtvAudioView.this.mMediaPlayer.getVideoHeight());
                    MgtvAudioView.this.autoStartByStateAndSize(i2, i22);
                    return;
                }
                MgtvAudioView.this.openVideo();
            }

            private boolean needOpenVideo() {
                return MgtvAudioView.this.mOpenVideoWhenSurfaceCreate && MgtvAudioView.this.mCurrentUri != null;
            }

            private void videoSurfaceChanged(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22, int i3) {
                if (MgtvAudioView.this.mRenderView == null || iSurfaceHolder.getRenderView() == MgtvAudioView.this.mRenderView.getRenderView()) {
                    MgtvAudioView.this.autoStartByStateAndSize(i22, i3);
                } else {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceChanged: unmatched render callback\n");
                }
            }

            private void videoSurfaceCreate(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22) {
                SurfaceHolder surfaceHolder;
                if (MgtvAudioView.this.mRenderView != null && iSurfaceHolder.getRenderView() != MgtvAudioView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "videoSurfaceCreate " + iSurfaceHolder);
                if (MgtvAudioView.this.mRenderView == null || MgtvAudioView.this.mRenderView.getRenderViewType() != 0 || ((surfaceHolder = MgtvAudioView.this.mSurfaceHolder.getSurfaceHolder()) != null && surfaceHolder.getSurface() != null && surfaceHolder.getSurface().isValid())) {
                    bindHolder(iSurfaceHolder, i2, i22);
                    return;
                }
                MgtvAudioView.this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SURFACE_FAILED, 1);
                MgtvAudioView.this.mErrorMsg = "surfaceCreated surface is invalid";
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceChanged(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22, int i3) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface changed. threadId:" + Thread.currentThread().getId());
                if (!MgtvAudioView.this.isOnlyAudioMode() && !MgtvAudioView.this.mBackPlayEnable) {
                    videoSurfaceChanged(iSurfaceHolder, i2, i22, i3);
                }
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceChanged();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceCreated(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface create. threadId:" + Thread.currentThread().getId());
                if (MgtvAudioView.this.mStartLeaveTimestamp > 0) {
                    long currentTimeMillis = (System.currentTimeMillis() - MgtvAudioView.this.mStartLeaveTimestamp) / 1000;
                    if (currentTimeMillis > 540) {
                        if (MgtvAudioView.this.mOnWarningListener != null) {
                            MgtvPlayerListener.OnWarningListener onWarningListener = MgtvAudioView.this.mOnWarningListener;
                            onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_LEAVE_TIME_INVALID, MgtvAudioView.this.mCurrentState + "", "", null);
                        }
                        ReportParams reportParams = MgtvAudioView.this.mReportParams;
                        if (reportParams != null) {
                            reportParams.setLeaveTimeS(currentTimeMillis);
                        }
                    }
                }
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                mgtvAudioView.mSurfaceHolder = iSurfaceHolder;
                if (!mgtvAudioView.isOnlyAudioMode() && !MgtvAudioView.this.mBackPlayEnable) {
                    videoSurfaceCreate(iSurfaceHolder, i2, i22);
                }
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceCreated();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceDestroyed(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, boolean z22) {
                MgtvMediaPlayer mgtvMediaPlayer;
                MgtvAudioView mgtvAudioView;
                IMgtvRenderView.ISurfaceHolder iSurfaceHolder2;
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface destroy. threadId:" + Thread.currentThread().getId());
                MgtvAudioView.this.mLastSurfaceDestroy = z22;
                if (MgtvAudioView.this.mRenderView != null && iSurfaceHolder.getRenderView() != MgtvAudioView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceDestroyed: unmatched render callback\n");
                    return;
                }
                String logTag2 = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag2, "onSurfaceDestroyed " + iSurfaceHolder);
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceDestroyed();
                }
                if (z22 && (iSurfaceHolder2 = MgtvAudioView.this.mSurfaceHolder) != null) {
                    iSurfaceHolder2.releaseSurface();
                }
                MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                mgtvAudioView2.mSurfaceHolder = null;
                if (!mgtvAudioView2.isOnlyAudioMode()) {
                    MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                    if (!mgtvAudioView3.mBackPlayEnable) {
                        mgtvAudioView3.videoSurfaceDestroyed();
                        mgtvAudioView = MgtvAudioView.this;
                        if (mgtvAudioView.mCurrentUri != null || mgtvAudioView.mCurrentState == -1 || MgtvAudioView.this.mCurrentState == 5) {
                            return;
                        }
                        MgtvAudioView.this.mStartLeaveTimestamp = System.currentTimeMillis();
                        return;
                    }
                }
                MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                if (mgtvAudioView4.mBackPlayEnable && (mgtvMediaPlayer = mgtvAudioView4.mMediaPlayer) != null) {
                    mgtvMediaPlayer.setSurfaceHolder(null);
                }
                mgtvAudioView = MgtvAudioView.this;
                if (mgtvAudioView.mCurrentUri != null) {
                }
            }
        };
        this.mFilterCallback = new f.a() { // from class: com.hunantv.media.widget.MgtvAudioView.2
            public void onInfo(int i2, int i22, String str) {
                if (i2 == 1) {
                    MgtvAudioView.this.mRenderType = i22;
                    MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                    ReportParams reportParams = mgtvAudioView.mReportParams;
                    if (reportParams != null) {
                        reportParams.setRenderType(mgtvAudioView.mRenderType);
                    }
                } else if (i2 != 3) {
                } else {
                    MgtvAudioView.this.mEnhanceQualityType = i22;
                    MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                    ReportParams reportParams2 = mgtvAudioView2.mReportParams;
                    if (reportParams2 != null) {
                        reportParams2.setEnhanceQualityType(mgtvAudioView2.mEnhanceQualityType);
                    }
                }
            }
        };
        this.mRenderWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvAudioView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "opengl render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mSizeChangedListener = new MgtvPlayerListener.OnVideoSizeChangedListener() { // from class: com.hunantv.media.widget.MgtvAudioView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i2, int i22) {
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                mgtvAudioView.originalVideoWidth = mgtvAudioView.mVideoWidth = mgtvAudioView.mMediaPlayer.getVideoWidth();
                MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                mgtvAudioView2.originalVideoHeight = mgtvAudioView2.mVideoHeight = mgtvAudioView2.mMediaPlayer.getVideoHeight();
                MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                mgtvAudioView3.mVideoSarNum = mgtvAudioView3.mMediaPlayer.getVideoSarNum();
                MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                mgtvAudioView4.mVideoSarDen = mgtvAudioView4.mMediaPlayer.getVideoSarDen();
                if (MgtvAudioView.this.mVideoWidth != 0 && MgtvAudioView.this.mVideoHeight != 0) {
                    if (MgtvAudioView.this.mRenderView != null) {
                        MgtvAudioView.this.mRenderView.setVideoSize(MgtvAudioView.this.mVideoWidth, MgtvAudioView.this.mVideoHeight);
                        if (MgtvAudioView.this.mVideoSarNum > 0 && MgtvAudioView.this.mVideoSarDen > 0) {
                            MgtvAudioView.this.mRenderView.setVideoSampleAspectRatio(MgtvAudioView.this.mVideoSarNum, MgtvAudioView.this.mVideoSarDen);
                        }
                    }
                    MgtvAudioView.this.requestLayout();
                }
                if (MgtvAudioView.this.mOnVideoSizeChangedListener != null) {
                    MgtvAudioView.this.mOnVideoSizeChangedListener.onVideoSizeChanged(i2, i22);
                }
            }
        };
        this.mPreparedListener = new MgtvPlayerListener.OnPreparedListener() { // from class: com.hunantv.media.widget.MgtvAudioView.5
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPreparedListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPrepared() {
                /*
                    r4 = this;
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    r1 = 2
                    com.hunantv.media.widget.MgtvAudioView.access$2700(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoWidth()
                    int r1 = com.hunantv.media.widget.MgtvAudioView.access$2102(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView.access$2002(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoHeight()
                    int r1 = com.hunantv.media.widget.MgtvAudioView.access$2302(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView.access$2202(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2100(r0)
                    r1 = 3
                    if (r0 == 0) goto Lb5
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2300(r0)
                    if (r0 == 0) goto Lb5
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "video size: "
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    r0.append(r2)
                    java.lang.String r2 = "/"
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2300(r2)
                    r0.append(r2)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r2 = "@@@@"
                    com.hunantv.media.player.pragma.DebugLog.i(r2, r0)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    if (r0 == 0) goto L7c
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    com.hunantv.media.widget.MgtvAudioView r3 = com.hunantv.media.widget.MgtvAudioView.this
                    int r3 = com.hunantv.media.widget.MgtvAudioView.access$2300(r3)
                    r0.setVideoSize(r2, r3)
                L7c:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    if (r0 == 0) goto L90
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    boolean r0 = r0.shouldWaitForResize()
                    if (r0 == 0) goto Lac
                L90:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2800(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    if (r0 != r2) goto Lc2
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2900(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2300(r2)
                    if (r0 != r2) goto Lc2
                Lac:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$3000(r0)
                    if (r0 != r1) goto Lc2
                    goto Lbd
                Lb5:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$3000(r0)
                    if (r0 != r1) goto Lc2
                Lbd:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    r0.start()
                Lc2:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvAudioView.access$3100(r0)
                    if (r0 == 0) goto Ld3
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvAudioView.access$3100(r0)
                    r0.onPrepared()
                Ld3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvAudioView.AnonymousClass5.onPrepared():void");
            }
        };
        this.mCompletionListener = new MgtvPlayerListener.OnCompletionListener() { // from class: com.hunantv.media.widget.MgtvAudioView.6
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnCompletionListener
            public void onCompletion(int i2, int i22) {
                if (i2 != 0) {
                    MgtvAudioView.this.stopInner();
                }
                MgtvAudioView.this.changeCurrentState(5);
                MgtvAudioView.this.mTargetState = 5;
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "-------------on onCompletion what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnCompletionListener != null) {
                    MgtvAudioView.this.mOnCompletionListener.onCompletion(i2, i22);
                }
            }
        };
        this.mInfoListener = new MgtvPlayerListener.OnInfoListener() { // from class: com.hunantv.media.widget.MgtvAudioView.7
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
                        logTag = MgtvAudioView.this.getLogTag();
                        sb = new StringBuilder();
                        str = "video fps is ";
                    } else if (i2 == 2820) {
                        logTag = MgtvAudioView.this.getLogTag();
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
                        String logTag2 = MgtvAudioView.this.getLogTag();
                        DebugLog.i(logTag2, "MEDIA_INFO_PLAYBACK_STATE_CHANGED:" + i22);
                        if (MgtvAudioView.this.mOnUpdateStatusListener != null) {
                            MgtvAudioView.this.mOnUpdateStatusListener.onUpdateStatus();
                        }
                    } else if (i2 == 10001) {
                        String logTag3 = MgtvAudioView.this.getLogTag();
                        DebugLog.w(logTag3, "video rotation changed,extra(degree) is " + i22);
                        MgtvAudioView.this.mVideoRotationDegree = i22;
                        if (MgtvAudioView.this.mRenderView != null) {
                            MgtvAudioView.this.mRenderView.setVideoRotation(MgtvAudioView.this.mVideoRotationDegree);
                        }
                    } else if (i2 == 200001) {
                        MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                        if (i22 == 1) {
                            mgtvAudioView.mMgtvMediaPlayerHardwareMode = false;
                        } else {
                            mgtvAudioView.mMgtvMediaPlayerHardwareMode = true;
                        }
                        MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                        mgtvAudioView2.convertRender(mgtvAudioView2.mRenderViewType);
                    } else if (i2 == 3) {
                        DebugLog.w(MgtvAudioView.this.getLogTag(), "video decode succeeded, start rendering");
                        MgtvAudioView.this.onVideoRenderStart();
                        if (MgtvAudioView.this.mOnInfoListener != null) {
                            MgtvAudioView.this.mOnInfoListener.onInfo(900, i22);
                        }
                        return true;
                    } else if (i2 == 4) {
                        DebugLog.w(MgtvAudioView.this.getLogTag(), "audio decode succeeded, start rendering");
                        if (MgtvAudioView.this.isOnlyAudioMode()) {
                            if (MgtvAudioView.this.mOnInfoListener != null) {
                                MgtvAudioView.this.mOnInfoListener.onInfo(900, i22);
                            }
                            return true;
                        }
                    } else if (i2 != 5) {
                        if (i2 == 6) {
                            if (i22 == 0) {
                                MgtvAudioView.this.mMgtvMediaPlayerHardwareMode = false;
                            } else if (i22 == 1) {
                                MgtvAudioView.this.mMgtvMediaPlayerHardwareMode = true;
                            }
                            logTag = MgtvAudioView.this.getLogTag();
                            sb = new StringBuilder();
                            str = "video decoder open,extra is ";
                        } else if (i2 != 7) {
                            switch (i2) {
                                case 700:
                                    String logTag4 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag4, "It's too complex for the decoder, extra is " + i22);
                                    i2 = 700;
                                    break;
                                case 701:
                                    String logTag5 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag5, "buffer start speed:" + MgtvAudioView.this.getDLSpeedFormat());
                                    i2 = 701;
                                    break;
                                case 702:
                                    String logTag6 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag6, "buffer end speed:" + MgtvAudioView.this.getDLSpeedFormat());
                                    i2 = 702;
                                    break;
                                default:
                                    switch (i2) {
                                        case 800:
                                            String logTag7 = MgtvAudioView.this.getLogTag();
                                            DebugLog.e(logTag7, "Bad interleaving of media file, audio/video are not well-formed, extra is " + i22);
                                            i2 = 800;
                                            break;
                                        case 801:
                                            String logTag8 = MgtvAudioView.this.getLogTag();
                                            DebugLog.w(logTag8, "The stream not seekable status, extra is " + i22);
                                            i2 = 801;
                                            MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                                            if (i22 == 1) {
                                                mgtvAudioView3.mIsLive = true;
                                                logTag = MgtvAudioView.this.getLogTag();
                                                str2 = "The stream is live stream,can not seekable ";
                                            } else {
                                                mgtvAudioView3.mIsLive = false;
                                                logTag = MgtvAudioView.this.getLogTag();
                                                str2 = "The stream is not live stream,can seekable ";
                                            }
                                            DebugLog.w(logTag, str2);
                                            break;
                                        case 802:
                                            String logTag9 = MgtvAudioView.this.getLogTag();
                                            DebugLog.w(logTag9, "A new set of metadata is available, extra is " + i22);
                                            i2 = 802;
                                            break;
                                        default:
                                            logTag = MgtvAudioView.this.getLogTag();
                                            switch (i2) {
                                                case MgtvMediaPlayer.MEDIA_INFO_DATA_PROTOCOL /* 2803 */:
                                                    DebugLog.w(logTag, "data source type is " + i22);
                                                    MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                                                    MgtvMediaPlayer mgtvMediaPlayer = mgtvAudioView4.mMediaPlayer;
                                                    if (mgtvMediaPlayer != null) {
                                                        mgtvAudioView4.mDataSourceType = mgtvMediaPlayer.getDataSourceType();
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
                    String logTag10 = MgtvAudioView.this.getLogTag();
                    DebugLog.w(logTag10, "Unknown info, extra is " + i22);
                    i2 = 1;
                }
                if (MgtvAudioView.this.mOnInfoListener != null) {
                    MgtvAudioView.this.mOnInfoListener.onInfo(i2, i22);
                }
                return true;
            }
        };
        this.reportErrWithoutMpManager = null;
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.widget.MgtvAudioView.8
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.w(logTag, "onError what:" + i2 + ",extra:" + i22);
                if ((i2 == 7001004 || i2 == 7000001 || i2 == 7000002 || i2 == 7000003 || i2 == 7000004 || i2 == 7000005 || i2 == 7000006 || i2 == 7000009 || i2 == 7000010 || i2 == 7000011 || i2 == 7000012 || i2 == 7000013 || i2 == 7001999 || i2 == 7001998 || i2 == 7000110) && MgtvAudioView.this.reportErrWithoutMpManager != null) {
                    MgtvAudioView.this.reportErrWithoutMpManager.F(i2, i22);
                }
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvAudioView.mMediaPlayer;
                if (mgtvMediaPlayer == null || i2 != 7000006) {
                    if (mgtvMediaPlayer != null && mgtvAudioView.mCurrentState != -1) {
                        MgtvAudioView.this.mMediaPlayer.stop();
                    }
                    MgtvAudioView.this.changeCurrentState(-1);
                    MgtvAudioView.this.mTargetState = -1;
                } else {
                    mgtvAudioView.releaseNoStatus();
                    MgtvAudioView.this.changeCurrentState(0);
                    MgtvAudioView.this.mTargetState = 0;
                }
                MgtvAudioView.this.cleanUri();
                return MgtvAudioView.this.mOnErrorListener != null && MgtvAudioView.this.mOnErrorListener.onError(i2, i22);
            }
        };
        this.mSeekCompleteListener = new MgtvPlayerListener.OnSeekCompleteListener() { // from class: com.hunantv.media.widget.MgtvAudioView.9
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSeekCompleteListener
            public void onSeekComplete(int i2, int i22) {
                if (MgtvAudioView.this.mOnSeekCompleteListener != null) {
                    String logTag = MgtvAudioView.this.getLogTag();
                    DebugLog.i(logTag, "onSeekComplete seekTargetTime:" + i2 + ",errorCode:" + i22);
                    MgtvAudioView.this.mOnSeekCompleteListener.onSeekComplete();
                }
            }
        };
        this.mBufferingUpdateListener = new MgtvPlayerListener.OnBufferingUpdateListener() { // from class: com.hunantv.media.widget.MgtvAudioView.10
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingUpdateListener
            public void onBufferingUpdate(int i2) {
                if (MgtvAudioView.this.mOnBufferringUpdateListener != null) {
                    MgtvAudioView.this.mOnBufferringUpdateListener.onBufferingUpdate(i2);
                }
            }
        };
        this.mBufferingTimeoutListener = new MgtvPlayerListener.OnBufferingTimeoutListener() { // from class: com.hunantv.media.widget.MgtvAudioView.11
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingTimeoutListener
            public boolean onBufferingTimeout(int i2, int i22) {
                MgtvMediaPlayer mgtvMediaPlayer = MgtvAudioView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.stop();
                }
                MgtvAudioView.this.changeCurrentState(-1);
                MgtvAudioView.this.mTargetState = -1;
                MgtvAudioView.this.cleanUri();
                if (MgtvAudioView.this.mOnErrorListener == null || MgtvAudioView.this.mOnErrorListener.onError(i2, i22)) {
                }
                return true;
            }
        };
        this.mSwitchSourceListener = new MgtvPlayerListener.OnSwitchSourceListener() { // from class: com.hunantv.media.widget.MgtvAudioView.12
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceComplete(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceComplete url:" + str + ",type:" + i2 + ",time:" + i22);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceSuccess(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceFailed(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceFailed url:" + str + ",what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceFailed(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceInfo(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceInfo url:" + str + ",event:" + i2 + ",time:" + i22);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceInfo(str, i2, i22);
                }
            }
        };
        this.mPlayerWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvAudioView.13
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "onTsSkip tsUrl:" + str);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onTsSkip(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "player render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mGifRecorder = new GifRecorder();
        this.mStartListener = new MgtvPlayerListener.OnStartListener() { // from class: com.hunantv.media.widget.MgtvAudioView.14
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnStartListener
            public void onStart() {
                DebugLog.d(MgtvAudioView.this.getLogTag(), "mgtvcore onStart");
                if (MgtvAudioView.this.mEnableCoreStartPauseListen) {
                    MgtvAudioView.this.callbackOnStart();
                }
            }
        };
        this.mPauseListener = new MgtvPlayerListener.OnPauseListener() { // from class: com.hunantv.media.widget.MgtvAudioView.15
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPauseListener
            public void onPause() {
                DebugLog.d(MgtvAudioView.this.getLogTag(), "mgtvcore onPause");
                if (MgtvAudioView.this.mEnableCoreStartPauseListen) {
                    MgtvAudioView.this.callbackOnPause();
                }
            }
        };
        this.mRecordVideoListener = new MgtvPlayerListener.OnRecordVideoListener() { // from class: com.hunantv.media.widget.MgtvAudioView.16
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoErr(int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onRecordVideoErr what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnRecordListener != null) {
                    MgtvAudioView.this.mOnRecordListener.onRecordError(i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoInfo(int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "onRecordVideoInfo what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnRecordListener != null) {
                    if (i2 == 20) {
                        MgtvAudioView.this.mOnRecordListener.onRecordStart(MgtvAudioView.this.mRecordFilePath);
                    } else if (i2 == 30) {
                        MgtvAudioView.this.mOnRecordListener.onRecordStop();
                    }
                    MgtvAudioView.this.mOnRecordListener.onRecordInfo(i2, i22);
                }
            }
        };
        this.mLoadDataListener = new MgtvPlayerListener.OnLoadDataListener() { // from class: com.hunantv.media.widget.MgtvAudioView.17
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onAfterLoadDataPaused() {
                if (MgtvAudioView.this.mOnLoadDataListener != null) {
                    MgtvAudioView.this.mOnLoadDataListener.onAfterLoadDataPaused();
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onBeforeLoadDataResume() {
                if (MgtvAudioView.this.mOnLoadDataListener != null) {
                    MgtvAudioView.this.mOnLoadDataListener.onBeforeLoadDataResume();
                }
            }
        };
        initVideoView(context);
    }

    public MgtvAudioView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLastSurfaceDestroy = true;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mMgtvMediaPlayerHardwareMode = false;
        this.mForceDecodeMode = false;
        this.mFromSurfaceDestroyToPlay = false;
        this.mFromSurfaceDestroyPlayPosition = 0;
        this.mErrorMsg = "";
        this.mHasSurfaceHolderDestroy = false;
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
        this.mEnableMgtvMediaCodec = true;
        this.mEnableJavaIPCache = false;
        this.mLastFrameRecovery = true;
        this.mWeakNetSpeed = 0;
        this.mWeakBufferTimeoutMs = 0;
        this.mTsNotSkip = false;
        this.mLoadMaxRetryTime = 0;
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
        this.mStartPosMs = 0;
        this.mFlowDataStatistic = new FlowDataStatistic();
        this.mSkipLoopFilterType = MgtvMediaPlayer.SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mSHCallback = new IMgtvRenderView.IRenderCallback() { // from class: com.hunantv.media.widget.MgtvAudioView.1
            private void bindHolder(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22) {
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                if (mgtvAudioView.mMediaPlayer == null) {
                    mgtvAudioView.openVideo();
                    return;
                }
                if (!mgtvAudioView.mEnableMediacodecSW && mgtvAudioView.mHasSurfaceHolderDestroy && MgtvAudioView.this.mRebindTexture) {
                    MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                    if (mgtvAudioView2.mCurrentUri != null) {
                        mgtvAudioView2.setStartPosMs(mgtvAudioView2.mMediaPlayer.getCurrentPosition());
                        MgtvAudioView.this.openVideo();
                    }
                }
                if (!needOpenVideo()) {
                    MgtvAudioView.this.mMediaPlayer.setSurfaceHolder(iSurfaceHolder);
                    MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                    if (mgtvAudioView3.mCurrentUri != null) {
                        if (mgtvAudioView3.mFromSurfaceDestroyToPlay && MgtvAudioView.this.mMgtvMediaPlayerHardwareMode) {
                            MgtvAudioView.this.mFromSurfaceDestroyToPlay = false;
                            MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                            mgtvAudioView4.mMediaPlayer.seekTo(mgtvAudioView4.mFromSurfaceDestroyPlayPosition, false, true);
                            MgtvAudioView.this.mFromSurfaceDestroyPlayPosition = 0;
                        }
                        if (MgtvAudioView.this.mLastFrameRecovery && (!MgtvAudioView.this.isHardware() || MgtvAudioView.this.mLastSurfaceDestroy)) {
                            MgtvAudioView.this.mMediaPlayer.setPlaybackStep();
                        }
                    }
                    MgtvAudioView mgtvAudioView5 = MgtvAudioView.this;
                    mgtvAudioView5.mSizeChangedListener.onVideoSizeChanged(mgtvAudioView5.mMediaPlayer.getVideoWidth(), MgtvAudioView.this.mMediaPlayer.getVideoHeight());
                    MgtvAudioView.this.autoStartByStateAndSize(i2, i22);
                    return;
                }
                MgtvAudioView.this.openVideo();
            }

            private boolean needOpenVideo() {
                return MgtvAudioView.this.mOpenVideoWhenSurfaceCreate && MgtvAudioView.this.mCurrentUri != null;
            }

            private void videoSurfaceChanged(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22, int i3) {
                if (MgtvAudioView.this.mRenderView == null || iSurfaceHolder.getRenderView() == MgtvAudioView.this.mRenderView.getRenderView()) {
                    MgtvAudioView.this.autoStartByStateAndSize(i22, i3);
                } else {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceChanged: unmatched render callback\n");
                }
            }

            private void videoSurfaceCreate(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22) {
                SurfaceHolder surfaceHolder;
                if (MgtvAudioView.this.mRenderView != null && iSurfaceHolder.getRenderView() != MgtvAudioView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "videoSurfaceCreate " + iSurfaceHolder);
                if (MgtvAudioView.this.mRenderView == null || MgtvAudioView.this.mRenderView.getRenderViewType() != 0 || ((surfaceHolder = MgtvAudioView.this.mSurfaceHolder.getSurfaceHolder()) != null && surfaceHolder.getSurface() != null && surfaceHolder.getSurface().isValid())) {
                    bindHolder(iSurfaceHolder, i2, i22);
                    return;
                }
                MgtvAudioView.this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SURFACE_FAILED, 1);
                MgtvAudioView.this.mErrorMsg = "surfaceCreated surface is invalid";
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceChanged(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22, int i3) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface changed. threadId:" + Thread.currentThread().getId());
                if (!MgtvAudioView.this.isOnlyAudioMode() && !MgtvAudioView.this.mBackPlayEnable) {
                    videoSurfaceChanged(iSurfaceHolder, i2, i22, i3);
                }
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceChanged();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceCreated(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface create. threadId:" + Thread.currentThread().getId());
                if (MgtvAudioView.this.mStartLeaveTimestamp > 0) {
                    long currentTimeMillis = (System.currentTimeMillis() - MgtvAudioView.this.mStartLeaveTimestamp) / 1000;
                    if (currentTimeMillis > 540) {
                        if (MgtvAudioView.this.mOnWarningListener != null) {
                            MgtvPlayerListener.OnWarningListener onWarningListener = MgtvAudioView.this.mOnWarningListener;
                            onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_LEAVE_TIME_INVALID, MgtvAudioView.this.mCurrentState + "", "", null);
                        }
                        ReportParams reportParams = MgtvAudioView.this.mReportParams;
                        if (reportParams != null) {
                            reportParams.setLeaveTimeS(currentTimeMillis);
                        }
                    }
                }
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                mgtvAudioView.mSurfaceHolder = iSurfaceHolder;
                if (!mgtvAudioView.isOnlyAudioMode() && !MgtvAudioView.this.mBackPlayEnable) {
                    videoSurfaceCreate(iSurfaceHolder, i2, i22);
                }
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceCreated();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceDestroyed(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, boolean z22) {
                MgtvMediaPlayer mgtvMediaPlayer;
                MgtvAudioView mgtvAudioView;
                IMgtvRenderView.ISurfaceHolder iSurfaceHolder2;
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface destroy. threadId:" + Thread.currentThread().getId());
                MgtvAudioView.this.mLastSurfaceDestroy = z22;
                if (MgtvAudioView.this.mRenderView != null && iSurfaceHolder.getRenderView() != MgtvAudioView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceDestroyed: unmatched render callback\n");
                    return;
                }
                String logTag2 = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag2, "onSurfaceDestroyed " + iSurfaceHolder);
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceDestroyed();
                }
                if (z22 && (iSurfaceHolder2 = MgtvAudioView.this.mSurfaceHolder) != null) {
                    iSurfaceHolder2.releaseSurface();
                }
                MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                mgtvAudioView2.mSurfaceHolder = null;
                if (!mgtvAudioView2.isOnlyAudioMode()) {
                    MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                    if (!mgtvAudioView3.mBackPlayEnable) {
                        mgtvAudioView3.videoSurfaceDestroyed();
                        mgtvAudioView = MgtvAudioView.this;
                        if (mgtvAudioView.mCurrentUri != null || mgtvAudioView.mCurrentState == -1 || MgtvAudioView.this.mCurrentState == 5) {
                            return;
                        }
                        MgtvAudioView.this.mStartLeaveTimestamp = System.currentTimeMillis();
                        return;
                    }
                }
                MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                if (mgtvAudioView4.mBackPlayEnable && (mgtvMediaPlayer = mgtvAudioView4.mMediaPlayer) != null) {
                    mgtvMediaPlayer.setSurfaceHolder(null);
                }
                mgtvAudioView = MgtvAudioView.this;
                if (mgtvAudioView.mCurrentUri != null) {
                }
            }
        };
        this.mFilterCallback = new f.a() { // from class: com.hunantv.media.widget.MgtvAudioView.2
            public void onInfo(int i2, int i22, String str) {
                if (i2 == 1) {
                    MgtvAudioView.this.mRenderType = i22;
                    MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                    ReportParams reportParams = mgtvAudioView.mReportParams;
                    if (reportParams != null) {
                        reportParams.setRenderType(mgtvAudioView.mRenderType);
                    }
                } else if (i2 != 3) {
                } else {
                    MgtvAudioView.this.mEnhanceQualityType = i22;
                    MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                    ReportParams reportParams2 = mgtvAudioView2.mReportParams;
                    if (reportParams2 != null) {
                        reportParams2.setEnhanceQualityType(mgtvAudioView2.mEnhanceQualityType);
                    }
                }
            }
        };
        this.mRenderWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvAudioView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "opengl render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mSizeChangedListener = new MgtvPlayerListener.OnVideoSizeChangedListener() { // from class: com.hunantv.media.widget.MgtvAudioView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i2, int i22) {
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                mgtvAudioView.originalVideoWidth = mgtvAudioView.mVideoWidth = mgtvAudioView.mMediaPlayer.getVideoWidth();
                MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                mgtvAudioView2.originalVideoHeight = mgtvAudioView2.mVideoHeight = mgtvAudioView2.mMediaPlayer.getVideoHeight();
                MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                mgtvAudioView3.mVideoSarNum = mgtvAudioView3.mMediaPlayer.getVideoSarNum();
                MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                mgtvAudioView4.mVideoSarDen = mgtvAudioView4.mMediaPlayer.getVideoSarDen();
                if (MgtvAudioView.this.mVideoWidth != 0 && MgtvAudioView.this.mVideoHeight != 0) {
                    if (MgtvAudioView.this.mRenderView != null) {
                        MgtvAudioView.this.mRenderView.setVideoSize(MgtvAudioView.this.mVideoWidth, MgtvAudioView.this.mVideoHeight);
                        if (MgtvAudioView.this.mVideoSarNum > 0 && MgtvAudioView.this.mVideoSarDen > 0) {
                            MgtvAudioView.this.mRenderView.setVideoSampleAspectRatio(MgtvAudioView.this.mVideoSarNum, MgtvAudioView.this.mVideoSarDen);
                        }
                    }
                    MgtvAudioView.this.requestLayout();
                }
                if (MgtvAudioView.this.mOnVideoSizeChangedListener != null) {
                    MgtvAudioView.this.mOnVideoSizeChangedListener.onVideoSizeChanged(i2, i22);
                }
            }
        };
        this.mPreparedListener = new MgtvPlayerListener.OnPreparedListener() { // from class: com.hunantv.media.widget.MgtvAudioView.5
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPreparedListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPrepared() {
                /*
                    r4 = this;
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    r1 = 2
                    com.hunantv.media.widget.MgtvAudioView.access$2700(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoWidth()
                    int r1 = com.hunantv.media.widget.MgtvAudioView.access$2102(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView.access$2002(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoHeight()
                    int r1 = com.hunantv.media.widget.MgtvAudioView.access$2302(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView.access$2202(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2100(r0)
                    r1 = 3
                    if (r0 == 0) goto Lb5
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2300(r0)
                    if (r0 == 0) goto Lb5
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "video size: "
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    r0.append(r2)
                    java.lang.String r2 = "/"
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2300(r2)
                    r0.append(r2)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r2 = "@@@@"
                    com.hunantv.media.player.pragma.DebugLog.i(r2, r0)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    if (r0 == 0) goto L7c
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    com.hunantv.media.widget.MgtvAudioView r3 = com.hunantv.media.widget.MgtvAudioView.this
                    int r3 = com.hunantv.media.widget.MgtvAudioView.access$2300(r3)
                    r0.setVideoSize(r2, r3)
                L7c:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    if (r0 == 0) goto L90
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    boolean r0 = r0.shouldWaitForResize()
                    if (r0 == 0) goto Lac
                L90:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2800(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    if (r0 != r2) goto Lc2
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2900(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2300(r2)
                    if (r0 != r2) goto Lc2
                Lac:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$3000(r0)
                    if (r0 != r1) goto Lc2
                    goto Lbd
                Lb5:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$3000(r0)
                    if (r0 != r1) goto Lc2
                Lbd:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    r0.start()
                Lc2:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvAudioView.access$3100(r0)
                    if (r0 == 0) goto Ld3
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvAudioView.access$3100(r0)
                    r0.onPrepared()
                Ld3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvAudioView.AnonymousClass5.onPrepared():void");
            }
        };
        this.mCompletionListener = new MgtvPlayerListener.OnCompletionListener() { // from class: com.hunantv.media.widget.MgtvAudioView.6
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnCompletionListener
            public void onCompletion(int i2, int i22) {
                if (i2 != 0) {
                    MgtvAudioView.this.stopInner();
                }
                MgtvAudioView.this.changeCurrentState(5);
                MgtvAudioView.this.mTargetState = 5;
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "-------------on onCompletion what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnCompletionListener != null) {
                    MgtvAudioView.this.mOnCompletionListener.onCompletion(i2, i22);
                }
            }
        };
        this.mInfoListener = new MgtvPlayerListener.OnInfoListener() { // from class: com.hunantv.media.widget.MgtvAudioView.7
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
                        logTag = MgtvAudioView.this.getLogTag();
                        sb = new StringBuilder();
                        str = "video fps is ";
                    } else if (i2 == 2820) {
                        logTag = MgtvAudioView.this.getLogTag();
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
                        String logTag2 = MgtvAudioView.this.getLogTag();
                        DebugLog.i(logTag2, "MEDIA_INFO_PLAYBACK_STATE_CHANGED:" + i22);
                        if (MgtvAudioView.this.mOnUpdateStatusListener != null) {
                            MgtvAudioView.this.mOnUpdateStatusListener.onUpdateStatus();
                        }
                    } else if (i2 == 10001) {
                        String logTag3 = MgtvAudioView.this.getLogTag();
                        DebugLog.w(logTag3, "video rotation changed,extra(degree) is " + i22);
                        MgtvAudioView.this.mVideoRotationDegree = i22;
                        if (MgtvAudioView.this.mRenderView != null) {
                            MgtvAudioView.this.mRenderView.setVideoRotation(MgtvAudioView.this.mVideoRotationDegree);
                        }
                    } else if (i2 == 200001) {
                        MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                        if (i22 == 1) {
                            mgtvAudioView.mMgtvMediaPlayerHardwareMode = false;
                        } else {
                            mgtvAudioView.mMgtvMediaPlayerHardwareMode = true;
                        }
                        MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                        mgtvAudioView2.convertRender(mgtvAudioView2.mRenderViewType);
                    } else if (i2 == 3) {
                        DebugLog.w(MgtvAudioView.this.getLogTag(), "video decode succeeded, start rendering");
                        MgtvAudioView.this.onVideoRenderStart();
                        if (MgtvAudioView.this.mOnInfoListener != null) {
                            MgtvAudioView.this.mOnInfoListener.onInfo(900, i22);
                        }
                        return true;
                    } else if (i2 == 4) {
                        DebugLog.w(MgtvAudioView.this.getLogTag(), "audio decode succeeded, start rendering");
                        if (MgtvAudioView.this.isOnlyAudioMode()) {
                            if (MgtvAudioView.this.mOnInfoListener != null) {
                                MgtvAudioView.this.mOnInfoListener.onInfo(900, i22);
                            }
                            return true;
                        }
                    } else if (i2 != 5) {
                        if (i2 == 6) {
                            if (i22 == 0) {
                                MgtvAudioView.this.mMgtvMediaPlayerHardwareMode = false;
                            } else if (i22 == 1) {
                                MgtvAudioView.this.mMgtvMediaPlayerHardwareMode = true;
                            }
                            logTag = MgtvAudioView.this.getLogTag();
                            sb = new StringBuilder();
                            str = "video decoder open,extra is ";
                        } else if (i2 != 7) {
                            switch (i2) {
                                case 700:
                                    String logTag4 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag4, "It's too complex for the decoder, extra is " + i22);
                                    i2 = 700;
                                    break;
                                case 701:
                                    String logTag5 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag5, "buffer start speed:" + MgtvAudioView.this.getDLSpeedFormat());
                                    i2 = 701;
                                    break;
                                case 702:
                                    String logTag6 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag6, "buffer end speed:" + MgtvAudioView.this.getDLSpeedFormat());
                                    i2 = 702;
                                    break;
                                default:
                                    switch (i2) {
                                        case 800:
                                            String logTag7 = MgtvAudioView.this.getLogTag();
                                            DebugLog.e(logTag7, "Bad interleaving of media file, audio/video are not well-formed, extra is " + i22);
                                            i2 = 800;
                                            break;
                                        case 801:
                                            String logTag8 = MgtvAudioView.this.getLogTag();
                                            DebugLog.w(logTag8, "The stream not seekable status, extra is " + i22);
                                            i2 = 801;
                                            MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                                            if (i22 == 1) {
                                                mgtvAudioView3.mIsLive = true;
                                                logTag = MgtvAudioView.this.getLogTag();
                                                str2 = "The stream is live stream,can not seekable ";
                                            } else {
                                                mgtvAudioView3.mIsLive = false;
                                                logTag = MgtvAudioView.this.getLogTag();
                                                str2 = "The stream is not live stream,can seekable ";
                                            }
                                            DebugLog.w(logTag, str2);
                                            break;
                                        case 802:
                                            String logTag9 = MgtvAudioView.this.getLogTag();
                                            DebugLog.w(logTag9, "A new set of metadata is available, extra is " + i22);
                                            i2 = 802;
                                            break;
                                        default:
                                            logTag = MgtvAudioView.this.getLogTag();
                                            switch (i2) {
                                                case MgtvMediaPlayer.MEDIA_INFO_DATA_PROTOCOL /* 2803 */:
                                                    DebugLog.w(logTag, "data source type is " + i22);
                                                    MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                                                    MgtvMediaPlayer mgtvMediaPlayer = mgtvAudioView4.mMediaPlayer;
                                                    if (mgtvMediaPlayer != null) {
                                                        mgtvAudioView4.mDataSourceType = mgtvMediaPlayer.getDataSourceType();
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
                    String logTag10 = MgtvAudioView.this.getLogTag();
                    DebugLog.w(logTag10, "Unknown info, extra is " + i22);
                    i2 = 1;
                }
                if (MgtvAudioView.this.mOnInfoListener != null) {
                    MgtvAudioView.this.mOnInfoListener.onInfo(i2, i22);
                }
                return true;
            }
        };
        this.reportErrWithoutMpManager = null;
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.widget.MgtvAudioView.8
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.w(logTag, "onError what:" + i2 + ",extra:" + i22);
                if ((i2 == 7001004 || i2 == 7000001 || i2 == 7000002 || i2 == 7000003 || i2 == 7000004 || i2 == 7000005 || i2 == 7000006 || i2 == 7000009 || i2 == 7000010 || i2 == 7000011 || i2 == 7000012 || i2 == 7000013 || i2 == 7001999 || i2 == 7001998 || i2 == 7000110) && MgtvAudioView.this.reportErrWithoutMpManager != null) {
                    MgtvAudioView.this.reportErrWithoutMpManager.F(i2, i22);
                }
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvAudioView.mMediaPlayer;
                if (mgtvMediaPlayer == null || i2 != 7000006) {
                    if (mgtvMediaPlayer != null && mgtvAudioView.mCurrentState != -1) {
                        MgtvAudioView.this.mMediaPlayer.stop();
                    }
                    MgtvAudioView.this.changeCurrentState(-1);
                    MgtvAudioView.this.mTargetState = -1;
                } else {
                    mgtvAudioView.releaseNoStatus();
                    MgtvAudioView.this.changeCurrentState(0);
                    MgtvAudioView.this.mTargetState = 0;
                }
                MgtvAudioView.this.cleanUri();
                return MgtvAudioView.this.mOnErrorListener != null && MgtvAudioView.this.mOnErrorListener.onError(i2, i22);
            }
        };
        this.mSeekCompleteListener = new MgtvPlayerListener.OnSeekCompleteListener() { // from class: com.hunantv.media.widget.MgtvAudioView.9
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSeekCompleteListener
            public void onSeekComplete(int i2, int i22) {
                if (MgtvAudioView.this.mOnSeekCompleteListener != null) {
                    String logTag = MgtvAudioView.this.getLogTag();
                    DebugLog.i(logTag, "onSeekComplete seekTargetTime:" + i2 + ",errorCode:" + i22);
                    MgtvAudioView.this.mOnSeekCompleteListener.onSeekComplete();
                }
            }
        };
        this.mBufferingUpdateListener = new MgtvPlayerListener.OnBufferingUpdateListener() { // from class: com.hunantv.media.widget.MgtvAudioView.10
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingUpdateListener
            public void onBufferingUpdate(int i2) {
                if (MgtvAudioView.this.mOnBufferringUpdateListener != null) {
                    MgtvAudioView.this.mOnBufferringUpdateListener.onBufferingUpdate(i2);
                }
            }
        };
        this.mBufferingTimeoutListener = new MgtvPlayerListener.OnBufferingTimeoutListener() { // from class: com.hunantv.media.widget.MgtvAudioView.11
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingTimeoutListener
            public boolean onBufferingTimeout(int i2, int i22) {
                MgtvMediaPlayer mgtvMediaPlayer = MgtvAudioView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.stop();
                }
                MgtvAudioView.this.changeCurrentState(-1);
                MgtvAudioView.this.mTargetState = -1;
                MgtvAudioView.this.cleanUri();
                if (MgtvAudioView.this.mOnErrorListener == null || MgtvAudioView.this.mOnErrorListener.onError(i2, i22)) {
                }
                return true;
            }
        };
        this.mSwitchSourceListener = new MgtvPlayerListener.OnSwitchSourceListener() { // from class: com.hunantv.media.widget.MgtvAudioView.12
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceComplete(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceComplete url:" + str + ",type:" + i2 + ",time:" + i22);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceSuccess(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceFailed(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceFailed url:" + str + ",what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceFailed(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceInfo(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceInfo url:" + str + ",event:" + i2 + ",time:" + i22);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceInfo(str, i2, i22);
                }
            }
        };
        this.mPlayerWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvAudioView.13
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "onTsSkip tsUrl:" + str);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onTsSkip(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "player render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mGifRecorder = new GifRecorder();
        this.mStartListener = new MgtvPlayerListener.OnStartListener() { // from class: com.hunantv.media.widget.MgtvAudioView.14
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnStartListener
            public void onStart() {
                DebugLog.d(MgtvAudioView.this.getLogTag(), "mgtvcore onStart");
                if (MgtvAudioView.this.mEnableCoreStartPauseListen) {
                    MgtvAudioView.this.callbackOnStart();
                }
            }
        };
        this.mPauseListener = new MgtvPlayerListener.OnPauseListener() { // from class: com.hunantv.media.widget.MgtvAudioView.15
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPauseListener
            public void onPause() {
                DebugLog.d(MgtvAudioView.this.getLogTag(), "mgtvcore onPause");
                if (MgtvAudioView.this.mEnableCoreStartPauseListen) {
                    MgtvAudioView.this.callbackOnPause();
                }
            }
        };
        this.mRecordVideoListener = new MgtvPlayerListener.OnRecordVideoListener() { // from class: com.hunantv.media.widget.MgtvAudioView.16
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoErr(int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onRecordVideoErr what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnRecordListener != null) {
                    MgtvAudioView.this.mOnRecordListener.onRecordError(i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoInfo(int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "onRecordVideoInfo what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnRecordListener != null) {
                    if (i2 == 20) {
                        MgtvAudioView.this.mOnRecordListener.onRecordStart(MgtvAudioView.this.mRecordFilePath);
                    } else if (i2 == 30) {
                        MgtvAudioView.this.mOnRecordListener.onRecordStop();
                    }
                    MgtvAudioView.this.mOnRecordListener.onRecordInfo(i2, i22);
                }
            }
        };
        this.mLoadDataListener = new MgtvPlayerListener.OnLoadDataListener() { // from class: com.hunantv.media.widget.MgtvAudioView.17
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onAfterLoadDataPaused() {
                if (MgtvAudioView.this.mOnLoadDataListener != null) {
                    MgtvAudioView.this.mOnLoadDataListener.onAfterLoadDataPaused();
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onBeforeLoadDataResume() {
                if (MgtvAudioView.this.mOnLoadDataListener != null) {
                    MgtvAudioView.this.mOnLoadDataListener.onBeforeLoadDataResume();
                }
            }
        };
        initVideoView(context);
    }

    public MgtvAudioView(Context context, IVideoView.Configuration configuration) {
        super(context, configuration);
        this.mLastSurfaceDestroy = true;
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mMgtvMediaPlayerHardwareMode = false;
        this.mForceDecodeMode = false;
        this.mFromSurfaceDestroyToPlay = false;
        this.mFromSurfaceDestroyPlayPosition = 0;
        this.mErrorMsg = "";
        this.mHasSurfaceHolderDestroy = false;
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
        this.mEnableMgtvMediaCodec = true;
        this.mEnableJavaIPCache = false;
        this.mLastFrameRecovery = true;
        this.mWeakNetSpeed = 0;
        this.mWeakBufferTimeoutMs = 0;
        this.mTsNotSkip = false;
        this.mLoadMaxRetryTime = 0;
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
        this.mStartPosMs = 0;
        this.mFlowDataStatistic = new FlowDataStatistic();
        this.mSkipLoopFilterType = MgtvMediaPlayer.SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mSHCallback = new IMgtvRenderView.IRenderCallback() { // from class: com.hunantv.media.widget.MgtvAudioView.1
            private void bindHolder(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22) {
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                if (mgtvAudioView.mMediaPlayer == null) {
                    mgtvAudioView.openVideo();
                    return;
                }
                if (!mgtvAudioView.mEnableMediacodecSW && mgtvAudioView.mHasSurfaceHolderDestroy && MgtvAudioView.this.mRebindTexture) {
                    MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                    if (mgtvAudioView2.mCurrentUri != null) {
                        mgtvAudioView2.setStartPosMs(mgtvAudioView2.mMediaPlayer.getCurrentPosition());
                        MgtvAudioView.this.openVideo();
                    }
                }
                if (!needOpenVideo()) {
                    MgtvAudioView.this.mMediaPlayer.setSurfaceHolder(iSurfaceHolder);
                    MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                    if (mgtvAudioView3.mCurrentUri != null) {
                        if (mgtvAudioView3.mFromSurfaceDestroyToPlay && MgtvAudioView.this.mMgtvMediaPlayerHardwareMode) {
                            MgtvAudioView.this.mFromSurfaceDestroyToPlay = false;
                            MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                            mgtvAudioView4.mMediaPlayer.seekTo(mgtvAudioView4.mFromSurfaceDestroyPlayPosition, false, true);
                            MgtvAudioView.this.mFromSurfaceDestroyPlayPosition = 0;
                        }
                        if (MgtvAudioView.this.mLastFrameRecovery && (!MgtvAudioView.this.isHardware() || MgtvAudioView.this.mLastSurfaceDestroy)) {
                            MgtvAudioView.this.mMediaPlayer.setPlaybackStep();
                        }
                    }
                    MgtvAudioView mgtvAudioView5 = MgtvAudioView.this;
                    mgtvAudioView5.mSizeChangedListener.onVideoSizeChanged(mgtvAudioView5.mMediaPlayer.getVideoWidth(), MgtvAudioView.this.mMediaPlayer.getVideoHeight());
                    MgtvAudioView.this.autoStartByStateAndSize(i2, i22);
                    return;
                }
                MgtvAudioView.this.openVideo();
            }

            private boolean needOpenVideo() {
                return MgtvAudioView.this.mOpenVideoWhenSurfaceCreate && MgtvAudioView.this.mCurrentUri != null;
            }

            private void videoSurfaceChanged(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22, int i3) {
                if (MgtvAudioView.this.mRenderView == null || iSurfaceHolder.getRenderView() == MgtvAudioView.this.mRenderView.getRenderView()) {
                    MgtvAudioView.this.autoStartByStateAndSize(i22, i3);
                } else {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceChanged: unmatched render callback\n");
                }
            }

            private void videoSurfaceCreate(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22) {
                SurfaceHolder surfaceHolder;
                if (MgtvAudioView.this.mRenderView != null && iSurfaceHolder.getRenderView() != MgtvAudioView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "videoSurfaceCreate " + iSurfaceHolder);
                if (MgtvAudioView.this.mRenderView == null || MgtvAudioView.this.mRenderView.getRenderViewType() != 0 || ((surfaceHolder = MgtvAudioView.this.mSurfaceHolder.getSurfaceHolder()) != null && surfaceHolder.getSurface() != null && surfaceHolder.getSurface().isValid())) {
                    bindHolder(iSurfaceHolder, i2, i22);
                    return;
                }
                MgtvAudioView.this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SURFACE_FAILED, 1);
                MgtvAudioView.this.mErrorMsg = "surfaceCreated surface is invalid";
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceChanged(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22, int i3) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface changed. threadId:" + Thread.currentThread().getId());
                if (!MgtvAudioView.this.isOnlyAudioMode() && !MgtvAudioView.this.mBackPlayEnable) {
                    videoSurfaceChanged(iSurfaceHolder, i2, i22, i3);
                }
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceChanged();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceCreated(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface create. threadId:" + Thread.currentThread().getId());
                if (MgtvAudioView.this.mStartLeaveTimestamp > 0) {
                    long currentTimeMillis = (System.currentTimeMillis() - MgtvAudioView.this.mStartLeaveTimestamp) / 1000;
                    if (currentTimeMillis > 540) {
                        if (MgtvAudioView.this.mOnWarningListener != null) {
                            MgtvPlayerListener.OnWarningListener onWarningListener = MgtvAudioView.this.mOnWarningListener;
                            onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_LEAVE_TIME_INVALID, MgtvAudioView.this.mCurrentState + "", "", null);
                        }
                        ReportParams reportParams = MgtvAudioView.this.mReportParams;
                        if (reportParams != null) {
                            reportParams.setLeaveTimeS(currentTimeMillis);
                        }
                    }
                }
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                mgtvAudioView.mSurfaceHolder = iSurfaceHolder;
                if (!mgtvAudioView.isOnlyAudioMode() && !MgtvAudioView.this.mBackPlayEnable) {
                    videoSurfaceCreate(iSurfaceHolder, i2, i22);
                }
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceCreated();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceDestroyed(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, boolean z22) {
                MgtvMediaPlayer mgtvMediaPlayer;
                MgtvAudioView mgtvAudioView;
                IMgtvRenderView.ISurfaceHolder iSurfaceHolder2;
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "-----------surface destroy. threadId:" + Thread.currentThread().getId());
                MgtvAudioView.this.mLastSurfaceDestroy = z22;
                if (MgtvAudioView.this.mRenderView != null && iSurfaceHolder.getRenderView() != MgtvAudioView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvAudioView.this.getLogTag(), "onSurfaceDestroyed: unmatched render callback\n");
                    return;
                }
                String logTag2 = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag2, "onSurfaceDestroyed " + iSurfaceHolder);
                if (MgtvAudioView.this.mSurfaceHolderListener != null) {
                    MgtvAudioView.this.mSurfaceHolderListener.surfaceDestroyed();
                }
                if (z22 && (iSurfaceHolder2 = MgtvAudioView.this.mSurfaceHolder) != null) {
                    iSurfaceHolder2.releaseSurface();
                }
                MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                mgtvAudioView2.mSurfaceHolder = null;
                if (!mgtvAudioView2.isOnlyAudioMode()) {
                    MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                    if (!mgtvAudioView3.mBackPlayEnable) {
                        mgtvAudioView3.videoSurfaceDestroyed();
                        mgtvAudioView = MgtvAudioView.this;
                        if (mgtvAudioView.mCurrentUri != null || mgtvAudioView.mCurrentState == -1 || MgtvAudioView.this.mCurrentState == 5) {
                            return;
                        }
                        MgtvAudioView.this.mStartLeaveTimestamp = System.currentTimeMillis();
                        return;
                    }
                }
                MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                if (mgtvAudioView4.mBackPlayEnable && (mgtvMediaPlayer = mgtvAudioView4.mMediaPlayer) != null) {
                    mgtvMediaPlayer.setSurfaceHolder(null);
                }
                mgtvAudioView = MgtvAudioView.this;
                if (mgtvAudioView.mCurrentUri != null) {
                }
            }
        };
        this.mFilterCallback = new f.a() { // from class: com.hunantv.media.widget.MgtvAudioView.2
            public void onInfo(int i2, int i22, String str) {
                if (i2 == 1) {
                    MgtvAudioView.this.mRenderType = i22;
                    MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                    ReportParams reportParams = mgtvAudioView.mReportParams;
                    if (reportParams != null) {
                        reportParams.setRenderType(mgtvAudioView.mRenderType);
                    }
                } else if (i2 != 3) {
                } else {
                    MgtvAudioView.this.mEnhanceQualityType = i22;
                    MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                    ReportParams reportParams2 = mgtvAudioView2.mReportParams;
                    if (reportParams2 != null) {
                        reportParams2.setEnhanceQualityType(mgtvAudioView2.mEnhanceQualityType);
                    }
                }
            }
        };
        this.mRenderWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvAudioView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "opengl render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mSizeChangedListener = new MgtvPlayerListener.OnVideoSizeChangedListener() { // from class: com.hunantv.media.widget.MgtvAudioView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i2, int i22) {
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                mgtvAudioView.originalVideoWidth = mgtvAudioView.mVideoWidth = mgtvAudioView.mMediaPlayer.getVideoWidth();
                MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                mgtvAudioView2.originalVideoHeight = mgtvAudioView2.mVideoHeight = mgtvAudioView2.mMediaPlayer.getVideoHeight();
                MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                mgtvAudioView3.mVideoSarNum = mgtvAudioView3.mMediaPlayer.getVideoSarNum();
                MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                mgtvAudioView4.mVideoSarDen = mgtvAudioView4.mMediaPlayer.getVideoSarDen();
                if (MgtvAudioView.this.mVideoWidth != 0 && MgtvAudioView.this.mVideoHeight != 0) {
                    if (MgtvAudioView.this.mRenderView != null) {
                        MgtvAudioView.this.mRenderView.setVideoSize(MgtvAudioView.this.mVideoWidth, MgtvAudioView.this.mVideoHeight);
                        if (MgtvAudioView.this.mVideoSarNum > 0 && MgtvAudioView.this.mVideoSarDen > 0) {
                            MgtvAudioView.this.mRenderView.setVideoSampleAspectRatio(MgtvAudioView.this.mVideoSarNum, MgtvAudioView.this.mVideoSarDen);
                        }
                    }
                    MgtvAudioView.this.requestLayout();
                }
                if (MgtvAudioView.this.mOnVideoSizeChangedListener != null) {
                    MgtvAudioView.this.mOnVideoSizeChangedListener.onVideoSizeChanged(i2, i22);
                }
            }
        };
        this.mPreparedListener = new MgtvPlayerListener.OnPreparedListener() { // from class: com.hunantv.media.widget.MgtvAudioView.5
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPreparedListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPrepared() {
                /*
                    r4 = this;
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    r1 = 2
                    com.hunantv.media.widget.MgtvAudioView.access$2700(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoWidth()
                    int r1 = com.hunantv.media.widget.MgtvAudioView.access$2102(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView.access$2002(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoHeight()
                    int r1 = com.hunantv.media.widget.MgtvAudioView.access$2302(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView.access$2202(r0, r1)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2100(r0)
                    r1 = 3
                    if (r0 == 0) goto Lb5
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2300(r0)
                    if (r0 == 0) goto Lb5
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "video size: "
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    r0.append(r2)
                    java.lang.String r2 = "/"
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2300(r2)
                    r0.append(r2)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r2 = "@@@@"
                    com.hunantv.media.player.pragma.DebugLog.i(r2, r0)
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    if (r0 == 0) goto L7c
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    com.hunantv.media.widget.MgtvAudioView r3 = com.hunantv.media.widget.MgtvAudioView.this
                    int r3 = com.hunantv.media.widget.MgtvAudioView.access$2300(r3)
                    r0.setVideoSize(r2, r3)
                L7c:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    if (r0 == 0) goto L90
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.player.MgtvRenderView r0 = com.hunantv.media.widget.MgtvAudioView.access$100(r0)
                    boolean r0 = r0.shouldWaitForResize()
                    if (r0 == 0) goto Lac
                L90:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2800(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2100(r2)
                    if (r0 != r2) goto Lc2
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$2900(r0)
                    com.hunantv.media.widget.MgtvAudioView r2 = com.hunantv.media.widget.MgtvAudioView.this
                    int r2 = com.hunantv.media.widget.MgtvAudioView.access$2300(r2)
                    if (r0 != r2) goto Lc2
                Lac:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$3000(r0)
                    if (r0 != r1) goto Lc2
                    goto Lbd
                Lb5:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    int r0 = com.hunantv.media.widget.MgtvAudioView.access$3000(r0)
                    if (r0 != r1) goto Lc2
                Lbd:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    r0.start()
                Lc2:
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvAudioView.access$3100(r0)
                    if (r0 == 0) goto Ld3
                    com.hunantv.media.widget.MgtvAudioView r0 = com.hunantv.media.widget.MgtvAudioView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvAudioView.access$3100(r0)
                    r0.onPrepared()
                Ld3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvAudioView.AnonymousClass5.onPrepared():void");
            }
        };
        this.mCompletionListener = new MgtvPlayerListener.OnCompletionListener() { // from class: com.hunantv.media.widget.MgtvAudioView.6
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnCompletionListener
            public void onCompletion(int i2, int i22) {
                if (i2 != 0) {
                    MgtvAudioView.this.stopInner();
                }
                MgtvAudioView.this.changeCurrentState(5);
                MgtvAudioView.this.mTargetState = 5;
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "-------------on onCompletion what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnCompletionListener != null) {
                    MgtvAudioView.this.mOnCompletionListener.onCompletion(i2, i22);
                }
            }
        };
        this.mInfoListener = new MgtvPlayerListener.OnInfoListener() { // from class: com.hunantv.media.widget.MgtvAudioView.7
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
                        logTag = MgtvAudioView.this.getLogTag();
                        sb = new StringBuilder();
                        str = "video fps is ";
                    } else if (i2 == 2820) {
                        logTag = MgtvAudioView.this.getLogTag();
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
                        String logTag2 = MgtvAudioView.this.getLogTag();
                        DebugLog.i(logTag2, "MEDIA_INFO_PLAYBACK_STATE_CHANGED:" + i22);
                        if (MgtvAudioView.this.mOnUpdateStatusListener != null) {
                            MgtvAudioView.this.mOnUpdateStatusListener.onUpdateStatus();
                        }
                    } else if (i2 == 10001) {
                        String logTag3 = MgtvAudioView.this.getLogTag();
                        DebugLog.w(logTag3, "video rotation changed,extra(degree) is " + i22);
                        MgtvAudioView.this.mVideoRotationDegree = i22;
                        if (MgtvAudioView.this.mRenderView != null) {
                            MgtvAudioView.this.mRenderView.setVideoRotation(MgtvAudioView.this.mVideoRotationDegree);
                        }
                    } else if (i2 == 200001) {
                        MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                        if (i22 == 1) {
                            mgtvAudioView.mMgtvMediaPlayerHardwareMode = false;
                        } else {
                            mgtvAudioView.mMgtvMediaPlayerHardwareMode = true;
                        }
                        MgtvAudioView mgtvAudioView2 = MgtvAudioView.this;
                        mgtvAudioView2.convertRender(mgtvAudioView2.mRenderViewType);
                    } else if (i2 == 3) {
                        DebugLog.w(MgtvAudioView.this.getLogTag(), "video decode succeeded, start rendering");
                        MgtvAudioView.this.onVideoRenderStart();
                        if (MgtvAudioView.this.mOnInfoListener != null) {
                            MgtvAudioView.this.mOnInfoListener.onInfo(900, i22);
                        }
                        return true;
                    } else if (i2 == 4) {
                        DebugLog.w(MgtvAudioView.this.getLogTag(), "audio decode succeeded, start rendering");
                        if (MgtvAudioView.this.isOnlyAudioMode()) {
                            if (MgtvAudioView.this.mOnInfoListener != null) {
                                MgtvAudioView.this.mOnInfoListener.onInfo(900, i22);
                            }
                            return true;
                        }
                    } else if (i2 != 5) {
                        if (i2 == 6) {
                            if (i22 == 0) {
                                MgtvAudioView.this.mMgtvMediaPlayerHardwareMode = false;
                            } else if (i22 == 1) {
                                MgtvAudioView.this.mMgtvMediaPlayerHardwareMode = true;
                            }
                            logTag = MgtvAudioView.this.getLogTag();
                            sb = new StringBuilder();
                            str = "video decoder open,extra is ";
                        } else if (i2 != 7) {
                            switch (i2) {
                                case 700:
                                    String logTag4 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag4, "It's too complex for the decoder, extra is " + i22);
                                    i2 = 700;
                                    break;
                                case 701:
                                    String logTag5 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag5, "buffer start speed:" + MgtvAudioView.this.getDLSpeedFormat());
                                    i2 = 701;
                                    break;
                                case 702:
                                    String logTag6 = MgtvAudioView.this.getLogTag();
                                    DebugLog.w(logTag6, "buffer end speed:" + MgtvAudioView.this.getDLSpeedFormat());
                                    i2 = 702;
                                    break;
                                default:
                                    switch (i2) {
                                        case 800:
                                            String logTag7 = MgtvAudioView.this.getLogTag();
                                            DebugLog.e(logTag7, "Bad interleaving of media file, audio/video are not well-formed, extra is " + i22);
                                            i2 = 800;
                                            break;
                                        case 801:
                                            String logTag8 = MgtvAudioView.this.getLogTag();
                                            DebugLog.w(logTag8, "The stream not seekable status, extra is " + i22);
                                            i2 = 801;
                                            MgtvAudioView mgtvAudioView3 = MgtvAudioView.this;
                                            if (i22 == 1) {
                                                mgtvAudioView3.mIsLive = true;
                                                logTag = MgtvAudioView.this.getLogTag();
                                                str2 = "The stream is live stream,can not seekable ";
                                            } else {
                                                mgtvAudioView3.mIsLive = false;
                                                logTag = MgtvAudioView.this.getLogTag();
                                                str2 = "The stream is not live stream,can seekable ";
                                            }
                                            DebugLog.w(logTag, str2);
                                            break;
                                        case 802:
                                            String logTag9 = MgtvAudioView.this.getLogTag();
                                            DebugLog.w(logTag9, "A new set of metadata is available, extra is " + i22);
                                            i2 = 802;
                                            break;
                                        default:
                                            logTag = MgtvAudioView.this.getLogTag();
                                            switch (i2) {
                                                case MgtvMediaPlayer.MEDIA_INFO_DATA_PROTOCOL /* 2803 */:
                                                    DebugLog.w(logTag, "data source type is " + i22);
                                                    MgtvAudioView mgtvAudioView4 = MgtvAudioView.this;
                                                    MgtvMediaPlayer mgtvMediaPlayer = mgtvAudioView4.mMediaPlayer;
                                                    if (mgtvMediaPlayer != null) {
                                                        mgtvAudioView4.mDataSourceType = mgtvMediaPlayer.getDataSourceType();
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
                    String logTag10 = MgtvAudioView.this.getLogTag();
                    DebugLog.w(logTag10, "Unknown info, extra is " + i22);
                    i2 = 1;
                }
                if (MgtvAudioView.this.mOnInfoListener != null) {
                    MgtvAudioView.this.mOnInfoListener.onInfo(i2, i22);
                }
                return true;
            }
        };
        this.reportErrWithoutMpManager = null;
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.widget.MgtvAudioView.8
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.w(logTag, "onError what:" + i2 + ",extra:" + i22);
                if ((i2 == 7001004 || i2 == 7000001 || i2 == 7000002 || i2 == 7000003 || i2 == 7000004 || i2 == 7000005 || i2 == 7000006 || i2 == 7000009 || i2 == 7000010 || i2 == 7000011 || i2 == 7000012 || i2 == 7000013 || i2 == 7001999 || i2 == 7001998 || i2 == 7000110) && MgtvAudioView.this.reportErrWithoutMpManager != null) {
                    MgtvAudioView.this.reportErrWithoutMpManager.F(i2, i22);
                }
                MgtvAudioView mgtvAudioView = MgtvAudioView.this;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvAudioView.mMediaPlayer;
                if (mgtvMediaPlayer == null || i2 != 7000006) {
                    if (mgtvMediaPlayer != null && mgtvAudioView.mCurrentState != -1) {
                        MgtvAudioView.this.mMediaPlayer.stop();
                    }
                    MgtvAudioView.this.changeCurrentState(-1);
                    MgtvAudioView.this.mTargetState = -1;
                } else {
                    mgtvAudioView.releaseNoStatus();
                    MgtvAudioView.this.changeCurrentState(0);
                    MgtvAudioView.this.mTargetState = 0;
                }
                MgtvAudioView.this.cleanUri();
                return MgtvAudioView.this.mOnErrorListener != null && MgtvAudioView.this.mOnErrorListener.onError(i2, i22);
            }
        };
        this.mSeekCompleteListener = new MgtvPlayerListener.OnSeekCompleteListener() { // from class: com.hunantv.media.widget.MgtvAudioView.9
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSeekCompleteListener
            public void onSeekComplete(int i2, int i22) {
                if (MgtvAudioView.this.mOnSeekCompleteListener != null) {
                    String logTag = MgtvAudioView.this.getLogTag();
                    DebugLog.i(logTag, "onSeekComplete seekTargetTime:" + i2 + ",errorCode:" + i22);
                    MgtvAudioView.this.mOnSeekCompleteListener.onSeekComplete();
                }
            }
        };
        this.mBufferingUpdateListener = new MgtvPlayerListener.OnBufferingUpdateListener() { // from class: com.hunantv.media.widget.MgtvAudioView.10
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingUpdateListener
            public void onBufferingUpdate(int i2) {
                if (MgtvAudioView.this.mOnBufferringUpdateListener != null) {
                    MgtvAudioView.this.mOnBufferringUpdateListener.onBufferingUpdate(i2);
                }
            }
        };
        this.mBufferingTimeoutListener = new MgtvPlayerListener.OnBufferingTimeoutListener() { // from class: com.hunantv.media.widget.MgtvAudioView.11
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingTimeoutListener
            public boolean onBufferingTimeout(int i2, int i22) {
                MgtvMediaPlayer mgtvMediaPlayer = MgtvAudioView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.stop();
                }
                MgtvAudioView.this.changeCurrentState(-1);
                MgtvAudioView.this.mTargetState = -1;
                MgtvAudioView.this.cleanUri();
                if (MgtvAudioView.this.mOnErrorListener == null || MgtvAudioView.this.mOnErrorListener.onError(i2, i22)) {
                }
                return true;
            }
        };
        this.mSwitchSourceListener = new MgtvPlayerListener.OnSwitchSourceListener() { // from class: com.hunantv.media.widget.MgtvAudioView.12
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceComplete(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceComplete url:" + str + ",type:" + i2 + ",time:" + i22);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceSuccess(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceFailed(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceFailed url:" + str + ",what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceFailed(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceInfo(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceInfo url:" + str + ",event:" + i2 + ",time:" + i22);
                if (MgtvAudioView.this.mOnChangeSourceListener != null) {
                    MgtvAudioView.this.mOnChangeSourceListener.onChangeSourceInfo(str, i2, i22);
                }
            }
        };
        this.mPlayerWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvAudioView.13
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "onTsSkip tsUrl:" + str);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onTsSkip(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "player render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvAudioView.this.mOnWarningListener != null) {
                    MgtvAudioView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mGifRecorder = new GifRecorder();
        this.mStartListener = new MgtvPlayerListener.OnStartListener() { // from class: com.hunantv.media.widget.MgtvAudioView.14
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnStartListener
            public void onStart() {
                DebugLog.d(MgtvAudioView.this.getLogTag(), "mgtvcore onStart");
                if (MgtvAudioView.this.mEnableCoreStartPauseListen) {
                    MgtvAudioView.this.callbackOnStart();
                }
            }
        };
        this.mPauseListener = new MgtvPlayerListener.OnPauseListener() { // from class: com.hunantv.media.widget.MgtvAudioView.15
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPauseListener
            public void onPause() {
                DebugLog.d(MgtvAudioView.this.getLogTag(), "mgtvcore onPause");
                if (MgtvAudioView.this.mEnableCoreStartPauseListen) {
                    MgtvAudioView.this.callbackOnPause();
                }
            }
        };
        this.mRecordVideoListener = new MgtvPlayerListener.OnRecordVideoListener() { // from class: com.hunantv.media.widget.MgtvAudioView.16
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoErr(int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.e(logTag, "onRecordVideoErr what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnRecordListener != null) {
                    MgtvAudioView.this.mOnRecordListener.onRecordError(i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoInfo(int i2, int i22) {
                String logTag = MgtvAudioView.this.getLogTag();
                DebugLog.i(logTag, "onRecordVideoInfo what:" + i2 + ",extra:" + i22);
                if (MgtvAudioView.this.mOnRecordListener != null) {
                    if (i2 == 20) {
                        MgtvAudioView.this.mOnRecordListener.onRecordStart(MgtvAudioView.this.mRecordFilePath);
                    } else if (i2 == 30) {
                        MgtvAudioView.this.mOnRecordListener.onRecordStop();
                    }
                    MgtvAudioView.this.mOnRecordListener.onRecordInfo(i2, i22);
                }
            }
        };
        this.mLoadDataListener = new MgtvPlayerListener.OnLoadDataListener() { // from class: com.hunantv.media.widget.MgtvAudioView.17
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onAfterLoadDataPaused() {
                if (MgtvAudioView.this.mOnLoadDataListener != null) {
                    MgtvAudioView.this.mOnLoadDataListener.onAfterLoadDataPaused();
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onBeforeLoadDataResume() {
                if (MgtvAudioView.this.mOnLoadDataListener != null) {
                    MgtvAudioView.this.mOnLoadDataListener.onBeforeLoadDataResume();
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

    /* JADX WARN: Multi-variable type inference failed */
    private void addRenderView() {
        View view;
        MgtvRenderView mgtvRenderView = this.mRenderView;
        if (mgtvRenderView == null || (view = mgtvRenderView.getView()) == null) {
            return;
        }
        view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        setSecureImpl(this.mIsSecure);
        DebugLog.i(getLogTag(), "setRenderView addRenderView");
        addView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autoStartByStateAndSize(int i, int i2) {
        this.mSurfaceWidth = i;
        this.mSurfaceHeight = i2;
        boolean z = true;
        boolean z2 = this.mTargetState == 3;
        MgtvRenderView mgtvRenderView = this.mRenderView;
        if ((mgtvRenderView == null || mgtvRenderView.shouldWaitForResize()) && (this.mVideoWidth != i || this.mVideoHeight != i2)) {
            z = false;
        }
        if (this.mMediaPlayer != null && z2 && z) {
            int i3 = this.mSeekWhenPrepared;
            if (i3 != 0) {
                seekTo(i3, false);
                this.mSeekWhenPrepared = 0;
            }
            start();
        }
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
        initVideoView(context, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initVideoView(Context context, int i) {
        this.mContext = context;
        this.reportErrWithoutMpManager = new a.a.a.b.a(this.mContext, (MgtvMediaPlayer) null);
        this.metrics = this.mContext.getResources().getDisplayMetrics();
        this.mRenderViewType = i;
        this.mInitRenderViewType = i;
        if (i == 0) {
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
                this.mMediaPlayer.setSurfaceHolder(this.mSurfaceHolder);
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
            this.mMediaPlayer.setSurfaceHolder(this.mSurfaceHolder);
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(this.mIsScreenOnWhilePlaying);
            this.mMediaPlayer.prepareAsync();
            changeCurrentState(1);
            DebugLog.i(getLogTag(), "openAudio is over");
        } catch (c e) {
            String logTag2 = getLogTag();
            DebugLog.e(logTag2, "LibLoaderError: " + this.mCurrentUri + "details:" + e.getMessage() + ",extra:" + e.a());
            this.mErrorMsg = e.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_LIB_NOTLOAD, e.a());
        } catch (IOException e2) {
            String logTag3 = getLogTag();
            DebugLog.w(logTag3, "Unable to open content: " + this.mCurrentUri);
            this.mErrorMsg = e2.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_IO, 0);
        } catch (IllegalArgumentException e3) {
            String logTag4 = getLogTag();
            DebugLog.w(logTag4, "Unable to open content: " + this.mCurrentUri + ",details:" + e3.getMessage());
            this.mErrorMsg = e3.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_ILLEGAL_ARGUMENT, 0);
        } catch (IllegalStateException e4) {
            String logTag5 = getLogTag();
            DebugLog.w(logTag5, "Unable to open content: " + this.mCurrentUri);
            this.mErrorMsg = e4.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_ILLEGAL_STATE, 0);
        } catch (NullPointerException e5) {
            String logTag6 = getLogTag();
            DebugLog.i(logTag6, "NullPointerException: " + this.mCurrentUri + ",details:" + e5.getMessage());
            this.mErrorMsg = e5.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_NULLPOINT, 0);
        } catch (OutOfMemoryError e6) {
            String logTag7 = getLogTag();
            DebugLog.i(logTag7, "OutOfMemoryError: " + this.mCurrentUri + ",details:" + e6.getMessage());
            this.mErrorMsg = e6.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_OUTOFMEM, 0);
        } catch (SecurityException e7) {
            String logTag8 = getLogTag();
            DebugLog.i(logTag8, "SecurityException: " + this.mCurrentUri + ",details:" + e7.getMessage());
            this.mErrorMsg = e7.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SECURITY, 0);
        } catch (UnsatisfiedLinkError e8) {
            String logTag9 = getLogTag();
            DebugLog.i(logTag9, "UnsatisfiedLinkError: " + this.mCurrentUri + ",details:" + e8.getMessage());
            this.mErrorMsg = e8.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_LIB_NOTLOAD, 0);
        } catch (InvalidParameterException e9) {
            String logTag10 = getLogTag();
            DebugLog.w(logTag10, "Unable to open content: " + this.mCurrentUri);
            this.mErrorMsg = e9.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SURFACE_FAILED, 3);
        } catch (Exception e10) {
            String logTag11 = getLogTag();
            DebugLog.w(logTag11, "Unable to open content: " + this.mCurrentUri + ",details:" + e10.getMessage());
            this.mErrorMsg = e10.getMessage();
            changeCurrentState(-1);
            this.mTargetState = -1;
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_OPENVIDEO_FAILED, 0);
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
        MgtvMediaPlayer mgtvMediaPlayer;
        MgtvMediaPlayer mgtvMediaPlayer2;
        SurfaceHolder surfaceHolder;
        this.mErrorMsg = "";
        release(false, true);
        if (this.mCurrentUri == null || this.mSurfaceHolder == null) {
            String logTag = getLogTag();
            DebugLog.e(logTag, "imgo openVideo: not ready for playback just yet, will try again later, mCurrentUri:" + this.mCurrentUri + ", mSurfaceHolder:" + this.mSurfaceHolder);
            if (this.mCurrentUri == null || this.mSurfaceHolder != null) {
                return;
            }
            this.mNonSurfaceHolderPVTimestamp = System.currentTimeMillis();
            this.mOpenVideoWhenSurfaceCreate = true;
            return;
        }
        MgtvRenderView mgtvRenderView = this.mRenderView;
        if (mgtvRenderView == null) {
            MgtvPlayerListener.OnErrorListener onErrorListener = this.mErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(IVideoView.MEDIA_ERROR_NULLPOINT, 0);
            }
            this.mErrorMsg = "openVideo renderView is null";
            DebugLog.e(getLogTag(), this.mErrorMsg);
        } else if (mgtvRenderView.getRenderViewType() == 0 && ((surfaceHolder = this.mSurfaceHolder.getSurfaceHolder()) == null || surfaceHolder.getSurface() == null || !surfaceHolder.getSurface().isValid())) {
            MgtvPlayerListener.OnErrorListener onErrorListener2 = this.mErrorListener;
            if (onErrorListener2 != null) {
                onErrorListener2.onError(IVideoView.MEDIA_ERROR_SURFACE_FAILED, 0);
            }
            this.mErrorMsg = "openVideo surface is invalid";
            if (surfaceHolder != null) {
                String logTag2 = getLogTag();
                DebugLog.e(logTag2, "openVideo surface is invalid " + surfaceHolder.getSurface());
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
                        MgtvRenderView mgtvRenderView2 = this.mRenderView;
                        if (mgtvRenderView2 != null && mgtvRenderView2.getRenderViewType() == 0) {
                            this.mEnableTexture = false;
                        }
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
                if (this.mReadDataSourceTypeConfig != 3 || this.mDataSource == null) {
                    if (this.mMainP2pTask == null && this.mProxyUri == null) {
                        this.mMediaPlayer.setReadDataSourceType(0);
                        this.mMediaPlayer.setDataSource(this.mCurrentUri.toString());
                    }
                    MgtvMediaPlayer mgtvMediaPlayer3 = this.mMediaPlayer;
                    String uri = this.mCurrentUri.toString();
                    IP2pTask iP2pTask = this.mMainP2pTask;
                    Uri uri2 = this.mProxyUri;
                    mgtvMediaPlayer3.setP2pDataSource(uri, iP2pTask, uri2 != null ? uri2.toString() : null, this.mStreamKey);
                } else {
                    this.mMediaPlayer.setReadDataSourceType(3);
                    this.mMediaPlayer.setDataSource(this.mDataSource);
                    DebugLog.i(getLogTag(), "setDataSource READ_DATASOURCE_TYPE_DATA_SOURCE");
                }
                this.mMediaPlayer.setSurfaceHolder(this.mSurfaceHolder);
                this.mMediaPlayer.setAudioStreamType(3);
                this.mMediaPlayer.setScreenOnWhilePlaying(this.mIsScreenOnWhilePlaying);
                this.mMediaPlayer.prepareAsync();
                changeCurrentState(1);
                DebugLog.i(getLogTag(), "openVideo is over");
            } catch (InvalidParameterException e) {
                String logTag3 = getLogTag();
                DebugLog.w(logTag3, "Unable to open content: " + this.mCurrentUri);
                this.mErrorMsg = e.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SURFACE_FAILED, 3);
            } catch (IllegalArgumentException e2) {
                String logTag4 = getLogTag();
                DebugLog.w(logTag4, "Unable to open content: " + this.mCurrentUri + ",details:" + e2.getMessage());
                this.mErrorMsg = e2.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_ILLEGAL_ARGUMENT, 0);
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
            } catch (Exception e5) {
                String logTag7 = getLogTag();
                DebugLog.w(logTag7, "Unable to open content: " + this.mCurrentUri + ",details:" + e5.getMessage());
                this.mErrorMsg = e5.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_OPENVIDEO_FAILED, 0);
            } catch (c e6) {
                String logTag8 = getLogTag();
                DebugLog.e(logTag8, "LibLoaderError: " + this.mCurrentUri + "details:" + e6.getMessage() + ",extra:" + e6.a());
                this.mErrorMsg = e6.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_LIB_NOTLOAD, e6.a());
            } catch (IOException e7) {
                String logTag9 = getLogTag();
                DebugLog.w(logTag9, "Unable to open content: " + this.mCurrentUri);
                this.mErrorMsg = e7.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_IO, 0);
            } catch (IllegalStateException e8) {
                String logTag10 = getLogTag();
                DebugLog.w(logTag10, "Unable to open content: " + this.mCurrentUri);
                this.mErrorMsg = e8.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_ILLEGAL_STATE, 0);
            } catch (OutOfMemoryError e9) {
                String logTag11 = getLogTag();
                DebugLog.i(logTag11, "OutOfMemoryError: " + this.mCurrentUri + ",details:" + e9.getMessage());
                this.mErrorMsg = e9.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_OUTOFMEM, 0);
            } catch (UnsatisfiedLinkError e10) {
                String logTag12 = getLogTag();
                DebugLog.i(logTag12, "UnsatisfiedLinkError: " + this.mCurrentUri + ",details:" + e10.getMessage());
                this.mErrorMsg = e10.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_LIB_NOTLOAD, 0);
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
            try {
                this.mMediaPlayer.pause();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.mEnableCoreStartPauseListen) {
                return;
            }
            callbackOnPause();
        }
    }

    private void release(boolean z, MgtvAbstractVideoView.ReleaseReason releaseReason) {
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
        if (releaseReason == MgtvAbstractVideoView.ReleaseReason.OUT) {
            abandonAudioFocus();
        }
    }

    private void release(boolean z, boolean z2) {
        release(z, z2 ? MgtvAbstractVideoView.ReleaseReason.DEFAULT_INNER : MgtvAbstractVideoView.ReleaseReason.OUT);
    }

    private ResetResult resetImpl(boolean z) {
        if (this.mMediaPlayer != null) {
            resetDataBefore(z ? MgtvAbstractVideoView.ReleaseReason.DEFAULT_INNER : MgtvAbstractVideoView.ReleaseReason.OUT);
            boolean reset = this.mMediaPlayer.reset();
            if (reset) {
                changeCurrentState(0);
                this.mTargetState = 0;
            }
            resetDataAfter(z ? MgtvAbstractVideoView.ReleaseReason.DEFAULT_INNER : MgtvAbstractVideoView.ReleaseReason.OUT);
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
        MgtvMediaPlayer mgtvMediaPlayer;
        String logTag = getLogTag();
        DebugLog.i(logTag, "setRender render:" + i);
        if (i != 0 && i != 1) {
            String logTag2 = getLogTag();
            DebugLog.e(logTag2, "invalid render:" + i + ", change to surfaceview");
            i = 0;
            this.mRenderViewType = 0;
        } else if (i == 1 && (mgtvMediaPlayer = this.mMediaPlayer) != null && this.mCurrentUri != null) {
            mgtvMediaPlayer.setSurfaceHolder(this.mSurfaceHolder);
            MgtvRenderView mgtvRenderView = this.mRenderView;
            if (mgtvRenderView != null) {
                mgtvRenderView.setVideoSize(this.mMediaPlayer.getVideoWidth(), this.mMediaPlayer.getVideoHeight());
            }
        }
        setRenderView(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setRenderView(int i) {
        int i2;
        int i3;
        int i4 = -1;
        if (this.mRenderView != null) {
            MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
            if (mgtvMediaPlayer != null) {
                mgtvMediaPlayer.setSurfaceHolder(null);
            }
            View view = this.mRenderView.getView();
            if (view != null) {
                DebugLog.i(getLogTag(), "setRenderView removeRenderView");
                i4 = indexOfChild(view);
                removeView(view);
            }
            removeDecorateLayout();
            this.mRenderView.removeRenderCallback(this.mSHCallback);
            this.mRenderView.release();
            this.mRenderView = null;
        }
        this.mRenderType = 0;
        this.mEnhanceQualityType = 0;
        ReportParams reportParams = this.mReportParams;
        if (reportParams != null) {
            reportParams.setRenderType(0);
            this.mReportParams.setEnhanceQualityType(0);
        }
        MgtvRenderView mgtvRenderView = new MgtvRenderView(getContext(), i, this.mEnableOpengl, this.mRenderWarning, this.mFilterCallback);
        this.mRenderView = mgtvRenderView;
        MgtvMediaPlayer mgtvMediaPlayer2 = this.mMediaPlayer;
        if (mgtvMediaPlayer2 != null) {
            mgtvMediaPlayer2.bindRenderView(mgtvRenderView.getRenderView());
        }
        MgtvRenderView mgtvRenderView2 = this.mRenderView;
        if (mgtvRenderView2 == null) {
            return;
        }
        mgtvRenderView2.bind(this);
        this.mRenderView.setDisplayFloatRect(this.mDisplayFloatRect);
        setRenderFilter(this.mRenderFilter);
        this.mRenderView.addRenderCallback(this.mSHCallback);
        this.mRenderView.setVideoRotation(this.mVideoRotationDegree);
        this.mRenderView.setAntiShake(this.mAntiViewShake);
        int i5 = this.mAspectRatio;
        if (i5 > 0) {
            this.mRenderView.setAspectRatio(i5);
        }
        int i6 = this.mVideoWidth;
        if (i6 > 0 && (i3 = this.mVideoHeight) > 0) {
            this.mRenderView.setVideoSize(i6, i3);
        }
        int i7 = this.mVideoSarNum;
        if (i7 > 0 && (i2 = this.mVideoSarDen) > 0) {
            this.mRenderView.setVideoSampleAspectRatio(i7, i2);
        }
        View view2 = this.mRenderView.getView();
        if (view2 != null) {
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            setSecureImpl(this.mIsSecure);
            DebugLog.i(getLogTag(), "setRenderView addRenderView");
            if (i4 >= 0) {
                addView(view2, i4);
            } else {
                addView(view2);
            }
            addDecorateLayout();
        }
    }

    private void setSecureImpl(boolean z) {
        MgtvRenderView mgtvRenderView = this.mRenderView;
        if (mgtvRenderView == null || !(mgtvRenderView.getView() instanceof SurfaceView) || Build.VERSION.SDK_INT < 17) {
            return;
        }
        String logTag = getLogTag();
        DebugLog.i(logTag, "setSecure " + z);
        ((SurfaceView) this.mRenderView.getView()).setSecure(z);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
        if (r3.mMediaPlayer.isSupportAMCKeyFrameBackup() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
        if (r3.mMediaPlayer.isSupportAMCKeyFrameBackup() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
        r3.mFromSurfaceDestroyToPlay = true;
        r3.mFromSurfaceDestroyPlayPosition = r3.mMediaPlayer.getCurrentPosition();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void videoSurfaceDestroyed() {
        /*
            r3 = this;
            com.hunantv.media.player.MgtvMediaPlayer r0 = r3.mMediaPlayer
            if (r0 == 0) goto L7d
            r1 = 0
            r0.setSurfaceHolder(r1)
            boolean r0 = r3.isPrepared()
            r1 = 1
            if (r0 == 0) goto L6f
            com.hunantv.media.player.MgtvMediaPlayer r0 = r3.mMediaPlayer
            r0.isBackground()
            r3.pauseLoadData()
            boolean r0 = r3.mIsLive
            java.lang.String r2 = "-----------surface destroy to pause"
            if (r0 == 0) goto L2e
            java.lang.String r0 = r3.getLogTag()
            com.hunantv.media.player.pragma.DebugLog.e(r0, r2)
            r3.pauseInner()
            boolean r0 = r3.mEnableTexture
            if (r0 == 0) goto L7d
            r3.mHasSurfaceHolderDestroy = r1
            goto L7d
        L2e:
            java.lang.String r0 = r3.getLogTag()
            com.hunantv.media.player.pragma.DebugLog.e(r0, r2)
            com.hunantv.media.player.MgtvRenderView r0 = r3.mRenderView
            if (r0 == 0) goto L48
            int r0 = r0.getRenderViewType()
            if (r0 != 0) goto L48
            com.hunantv.media.player.MgtvMediaPlayer r0 = r3.mMediaPlayer
            boolean r0 = r0.isSupportAMCKeyFrameBackup()
            if (r0 != 0) goto L6b
            goto L61
        L48:
            com.hunantv.media.player.MgtvRenderView r0 = r3.mRenderView
            if (r0 == 0) goto L6b
            int r0 = r0.getRenderViewType()
            if (r0 != r1) goto L6b
            boolean r0 = r3.mEnableTexture
            if (r0 == 0) goto L59
            r3.mHasSurfaceHolderDestroy = r1
            goto L6b
        L59:
            com.hunantv.media.player.MgtvMediaPlayer r0 = r3.mMediaPlayer
            boolean r0 = r0.isSupportAMCKeyFrameBackup()
            if (r0 != 0) goto L6b
        L61:
            r3.mFromSurfaceDestroyToPlay = r1
            com.hunantv.media.player.MgtvMediaPlayer r0 = r3.mMediaPlayer
            int r0 = r0.getCurrentPosition()
            r3.mFromSurfaceDestroyPlayPosition = r0
        L6b:
            r3.pauseInner()
            goto L7d
        L6f:
            com.hunantv.media.report.ReportParams r0 = r3.mReportParams     // Catch: java.lang.Exception -> L7d
            if (r0 == 0) goto L7a
            com.hunantv.media.report.ReportParams$End r0 = r0.getEnd()     // Catch: java.lang.Exception -> L7d
            r0.setInnerRetry(r1)     // Catch: java.lang.Exception -> L7d
        L7a:
            r3.release(r1, r1)     // Catch: java.lang.Exception -> L7d
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvAudioView.videoSurfaceDestroyed():void");
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
        this.mDataSource = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01f6  */
    @Override // com.hunantv.media.widget.MgtvAbstractVideoView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void configAudioImgoPlayer() {
        /*
            Method dump skipped, instructions count: 506
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvAudioView.configAudioImgoPlayer():void");
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void configDataCacheSizeKB(int i) {
        this.mDataCacheSizeKB = i;
        updateDataCacheSizeKB();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0247  */
    @Override // com.hunantv.media.widget.MgtvAbstractVideoView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void configImgoPlayer() {
        /*
            Method dump skipped, instructions count: 587
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvAudioView.configImgoPlayer():void");
    }

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView, com.hunantv.media.widget.IVideoView
    public void configLoadMaxRetryTime(int i) {
        this.mLoadMaxRetryTime = i;
    }

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView, com.hunantv.media.widget.IVideoView
    public void configTsNotSkip(boolean z) {
        this.mTsNotSkip = z;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void configWeakBufferTimeout(int i) {
        this.mWeakBufferTimeoutMs = i;
    }

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView, com.hunantv.media.widget.IVideoView
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
        this.mInitRenderViewType = i;
        toggleRenders(i);
    }

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView
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
    public void enableTsSkipError(boolean z) {
        this.mEnableTsSkipError = z;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getAddrInfoTypeInt() {
        return this.mAddrInfoTypeInt;
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
        String str = MgtvAbstractVideoView.sAutoNativeStack ? "STACK-" : "";
        return str + videoTypeName + "-" + hashCode() + "-" + getRenderViewName();
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
    public IVideoView.RenderFilter getRenderFilter() {
        return this.mRenderFilter;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public View getRenderView() {
        MgtvRenderView mgtvRenderView = this.mRenderView;
        if (mgtvRenderView != null) {
            return mgtvRenderView.getView();
        }
        return null;
    }

    public String getRenderViewName() {
        return this.mRenderViewType == 0 ? "surface" : "texture";
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getRenderViewType() {
        return this.mRenderViewType;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public Bitmap getSnapshot(int i, int i2) {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.getSnapshot(i, i2);
        }
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
            return mgtvMediaPlayer.getVideoWidth();
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

    public boolean isStretchScreen() {
        return this.isStretchScreen;
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

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView, com.hunantv.media.widget.IVideoView
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
            release(true, MgtvAbstractVideoView.ReleaseReason.PAUSE_DATA_BEFORE_PREPEAD);
        } catch (Exception unused) {
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void reBindTexture() {
    }

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView, com.hunantv.media.widget.IVideoView
    public void release() {
        super.release();
        release(true, false);
        afterRelease();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void reset() {
        resetImpl(false);
    }

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView
    public void resetDataBefore(MgtvAbstractVideoView.ReleaseReason releaseReason) {
        super.resetDataBefore(releaseReason);
        this.mIsLive = false;
        MgtvRenderView mgtvRenderView = this.mRenderView;
        if (mgtvRenderView != null) {
            mgtvRenderView.reset();
        }
        if (releaseReason == MgtvAbstractVideoView.ReleaseReason.OUT) {
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
        if (releaseReason == MgtvAbstractVideoView.ReleaseReason.PAUSE_DATA_BEFORE_PREPEAD) {
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
        beforeOpenVideo();
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
        if (this.mSurfaceHolder == null) {
            String logTag = getLogTag();
            DebugLog.e(logTag, "resetVideoPath: not ready for playback just yet, will try again later, mCurrentUri:" + this.mCurrentUri + ", mSurfaceHolder:" + this.mSurfaceHolder);
            this.mNonSurfaceHolderPVTimestamp = System.currentTimeMillis();
            this.mOpenVideoWhenSurfaceCreate = true;
        } else if (this.mMediaPlayer == null || isOnlyAudioMode()) {
            setVideoPath(str, iP2pTask, str2);
        } else {
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
                if (this.mSurfaceHolder == null) {
                    this.mNonSurfaceHolderPVTimestamp = System.currentTimeMillis();
                    this.mOpenVideoWhenSurfaceCreate = true;
                    return;
                }
                try {
                    String logTag2 = getLogTag();
                    DebugLog.e(logTag2, "------chodison----reprepare MgtvMediaPlayer mMgtvMediaPlayerHardwareMode:" + this.mMgtvMediaPlayerHardwareMode + " url:" + this.mCurrentUri.toString());
                    this.mMediaPlayer.setReportParams(this.mReportParams);
                    configImgoPlayer();
                    this.mFromSurfaceDestroyToPlay = false;
                    this.mHasSurfaceHolderDestroy = false;
                    String logTag3 = getLogTag();
                    DebugLog.i(logTag3, "resetVideoPath streamKey:" + this.mStreamKey);
                    if (this.mMainP2pTask == null && this.mProxyUri == null) {
                        this.mMediaPlayer.setReadDataSourceType(0);
                        this.mMediaPlayer.setDataSource(this.mCurrentUri.toString());
                        this.mMediaPlayer.setSurfaceHolder(this.mSurfaceHolder);
                        this.mMediaPlayer.prepareAsync();
                        changeCurrentState(1);
                    }
                    MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
                    String uri = this.mCurrentUri.toString();
                    IP2pTask iP2pTask2 = this.mMainP2pTask;
                    Uri uri2 = this.mProxyUri;
                    mgtvMediaPlayer.setP2pDataSource(uri, iP2pTask2, uri2 != null ? uri2.toString() : null, this.mStreamKey);
                    this.mMediaPlayer.setSurfaceHolder(this.mSurfaceHolder);
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

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView, com.hunantv.media.widget.IVideoView
    @Deprecated
    public void setAccurateSeekEnable(boolean z) {
        this.mAccurateSeekEnable = z;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setAspectRatio(int i) {
        this.mAspectRatio = i;
        if (this.mRenderView != null) {
            String logTag = getLogTag();
            DebugLog.i(logTag, "setAspectRatio:" + i);
            this.mRenderView.setAspectRatio(i);
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

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView, com.hunantv.media.widget.IVideoView
    public void setBufferTimeout(int i) {
        this.mBufferTimeoutMs = i;
    }

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView, com.hunantv.media.widget.IVideoView
    public void setDisplayFloatRect(IMgtvRenderView.FloatRect floatRect) {
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
    public void setMgtvAudioEffectEnable(boolean z) {
        if (NetPlayConfig.isMgtvAudioEffectEnable()) {
            MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
            if (mgtvMediaPlayer != null) {
                if (z) {
                    mgtvMediaPlayer.setWanosAudioEffectEnable(true);
                }
                this.mMediaPlayer.setEnableWanosAudioEffect(z);
                return;
            }
            return;
        }
        String logTag = getLogTag();
        DebugLog.i(logTag, "netplayconfig is ：" + NetPlayConfig.isSpatializerEnable() + "———current mode : " + isOnlyAudioMode());
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
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvAudioView.setNetAddrinfo(int, int, boolean):void");
    }

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView, com.hunantv.media.widget.IVideoView
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
    public void setOnInfoListener(IVideoView.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
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
        String logTag = getLogTag();
        DebugLog.i(logTag, "setPlayerHardwareMode : " + z);
        this.mMgtvMediaPlayerHardwareMode = z;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setRenderFilter(IVideoView.RenderFilter renderFilter) {
        this.mRenderFilter = renderFilter;
        int i = AnonymousClass18.$SwitchMap$com$hunantv$media$widget$IVideoView$RenderFilter[renderFilter.ordinal()];
        int i2 = 2;
        if (i == 1) {
            i2 = 1;
        } else if (i != 2) {
            i2 = 0;
        }
        MgtvRenderView mgtvRenderView = this.mRenderView;
        if (mgtvRenderView != null) {
            mgtvRenderView.setRenderFilter(i2);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setRenderViewVisible(int i) {
        MgtvRenderView mgtvRenderView = this.mRenderView;
        if (mgtvRenderView == null || mgtvRenderView.getView() == null) {
            return;
        }
        this.mRenderView.getView().setVisibility(i);
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setReportParams(ReportParams reportParams) {
        this.mReportParams = reportParams;
        if (reportParams != null) {
            reportParams.setRenderType(this.mRenderType);
            this.mReportParams.setEnhanceQualityType(this.mEnhanceQualityType);
            this.mReportParams.setSvds(this.mVideoIntroduction);
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

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView, com.hunantv.media.widget.IVideoView
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

    /* JADX WARN: Multi-variable type inference failed */
    public void setStretchScreen() {
        if (this.shouldGetVideoParams) {
            DebugLog.i("@@@", "getFullScreenVideoParams");
            getFullScreenVideoParams();
            this.shouldGetVideoParams = false;
        }
        if (this.isStretchScreen) {
            this.mVideoWidth = this.originalVideoWidth;
            this.mVideoHeight = this.originalVideoHeight;
            layout(this.fromLeft, this.fromTop, this.fromRight, this.fromBottom);
            this.isStretchScreen = false;
        } else {
            DisplayMetrics displayMetrics = this.metrics;
            layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
            DisplayMetrics displayMetrics2 = this.metrics;
            this.mVideoWidth = displayMetrics2.widthPixels;
            this.mVideoHeight = displayMetrics2.heightPixels;
            this.isStretchScreen = true;
        }
        MgtvRenderView mgtvRenderView = this.mRenderView;
        if (mgtvRenderView != null) {
            mgtvRenderView.setVideoSize(this.mVideoWidth, this.mVideoHeight);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setSurfaceHolderListener(IVideoView.SurfaceHolderListener surfaceHolderListener) {
        this.mSurfaceHolderListener = surfaceHolderListener;
    }

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView, com.hunantv.media.widget.IVideoView
    public void setTimeout(int i, int i2) {
        this.mConnectTimeOut = i;
        this.mReciveDataTimeOut = i2;
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
        beforeOpenVideo();
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
    public void setZOrderMediaOverlay(boolean z) {
        MgtvRenderView mgtvRenderView = this.mRenderView;
        if (mgtvRenderView == null || mgtvRenderView.getView() == null || !(this.mRenderView.getView() instanceof SurfaceView)) {
            return;
        }
        ((SurfaceView) this.mRenderView.getView()).setZOrderMediaOverlay(z);
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

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView
    public void toggleRenders(int i) {
        super.toggleRenders(i);
        this.mSurfaceHolder = null;
        setRender(i);
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void useSystemPlayer(boolean z) {
        this.mUseSystemPlayer = z;
    }
}
