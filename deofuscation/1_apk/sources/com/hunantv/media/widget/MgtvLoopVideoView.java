package com.hunantv.media.widget;

import a.a.a.a.c;
import a.a.a.a.n.a;
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
import com.hunantv.imgo.log.MLog;
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
public class MgtvLoopVideoView extends MgtvAbstractVideoView {
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
    private boolean mEnableLiveMode;
    private boolean mEnableMgtvMediaCodec;
    private boolean mEnableOpengl;
    private boolean mEnableTsSkipError;
    private int mEnhanceQualityType;
    private MgtvPlayerListener.OnErrorListener mErrorListener;
    private String mErrorMsg;
    private f.a mFilterCallback;
    private FlowDataStatistic mFlowDataStatistic;
    private boolean mForceDecodeMode;
    private int mFromSurfaceDestroyPlayPosition;
    public boolean mFromSurfaceDestroyToPlay;
    private GifRecorder mGifRecorder;
    public boolean mHasSurfaceHolderDestroy;
    private MgtvPlayerListener.OnInfoListener mInfoListener;
    private boolean mIsDataLoaderPaused;
    private boolean mIsLive;
    private boolean mIsLiveConfig;
    public boolean mIsLoopMode;
    private boolean mIsScreenOnWhilePlaying;
    private boolean mIsSecure;
    private a.d mJavaDnsType;
    private boolean mLastFrameRecovery;
    private volatile boolean mLastSurfaceDestroy;
    private int mLiveStartIndex;
    private MgtvPlayerListener.OnLoadDataListener mLoadDataListener;
    private int mLoadMaxRetryTime;
    private boolean mLogCallBackOpen;
    private IP2pTask mMainP2pTask;
    private boolean mMgtvMediaPlayerHardwareMode;
    private boolean mNativeDnsAsyncEnable;
    public boolean mNeedResetLoopPlay;
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
    private boolean mOpenVideoWhenSurfaceCreate;
    private MgtvPlayerListener.OnPauseListener mPauseListener;
    private float mPlaySpeed;
    private MgtvPlayerListener.OnWarningListener mPlayerWarning;
    public MgtvPlayerListener.OnPreparedListener mPreparedListener;
    private boolean mRebindTexture;
    private String mRecordFilePath;
    private MgtvPlayerListener.OnRecordVideoListener mRecordVideoListener;
    private IVideoView.RenderFilter mRenderFilter;
    private int mRenderType;
    private MgtvPlayerListener.OnWarningListener mRenderWarning;
    public IMgtvRenderView.IRenderCallback mSHCallback;
    private MgtvPlayerListener.OnSeekCompleteListener mSeekCompleteListener;
    private int mSeekWhenPrepared;
    public MgtvPlayerListener.OnVideoSizeChangedListener mSizeChangedListener;
    private MgtvMediaPlayer.SkipLoopFilterType mSkipLoopFilterType;
    private long mStartLeaveTimestamp;
    private MgtvPlayerListener.OnStartListener mStartListener;
    public int mStartPosMs;
    private int mStreamKey;
    private int mSurfaceHeight;
    private IVideoView.SurfaceHolderListener mSurfaceHolderListener;
    private int mSurfaceWidth;
    private MgtvPlayerListener.OnSwitchSourceListener mSwitchSourceListener;
    public boolean mTargetIsLoopMode;
    private int mTargetState;
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

    /* renamed from: com.hunantv.media.widget.MgtvLoopVideoView$18  reason: invalid class name */
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

    public MgtvLoopVideoView(Context context) {
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
        this.mIsDataLoaderPaused = false;
        this.mUseSystemPlayer = false;
        this.mAddrInfoType = MgtvMediaPlayer.AddrinfoType.TYPE_ADDRINFO_DEFAULT;
        this.mAddrInfoTypeInt = 0;
        this.mJavaDnsType = a.d.a;
        this.mNativeDnsAsyncEnable = true;
        this.mEnableMgtvMediaCodec = false;
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
        this.mTargetIsLoopMode = false;
        this.mIsLoopMode = false;
        this.mStartPosMs = 0;
        this.mNeedResetLoopPlay = false;
        this.mFlowDataStatistic = new FlowDataStatistic();
        this.mSkipLoopFilterType = MgtvMediaPlayer.SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mSHCallback = new IMgtvRenderView.IRenderCallback() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.1
            private void bindHolder(IMgtvRenderView.ISurfaceHolder iSurfaceHolder) {
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                if (mgtvLoopVideoView.mMediaPlayer == null) {
                    mgtvLoopVideoView.openVideo();
                    return;
                }
                if (mgtvLoopVideoView.mHasSurfaceHolderDestroy && mgtvLoopVideoView.mRebindTexture) {
                    MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                    if (mgtvLoopVideoView2.mCurrentUri != null) {
                        mgtvLoopVideoView2.setStartPosMs(mgtvLoopVideoView2.mMediaPlayer.getCurrentPosition());
                        MgtvLoopVideoView.this.openVideo();
                    }
                }
                if (!needOpenVideo()) {
                    MgtvLoopVideoView.this.mMediaPlayer.setSurfaceHolder(iSurfaceHolder);
                    MgtvLoopVideoView mgtvLoopVideoView3 = MgtvLoopVideoView.this;
                    if (mgtvLoopVideoView3.mNeedResetLoopPlay) {
                        mgtvLoopVideoView3.resetVideoPath();
                    } else if (!mgtvLoopVideoView3.mFromSurfaceDestroyToPlay || mgtvLoopVideoView3.mCurrentUri == null) {
                        if (mgtvLoopVideoView3.mLastFrameRecovery && (!MgtvLoopVideoView.this.isHardware() || MgtvLoopVideoView.this.mLastSurfaceDestroy)) {
                            MgtvLoopVideoView.this.mMediaPlayer.setPlaybackStep();
                        }
                    } else if (mgtvLoopVideoView3.mMgtvMediaPlayerHardwareMode) {
                        MgtvLoopVideoView mgtvLoopVideoView4 = MgtvLoopVideoView.this;
                        mgtvLoopVideoView4.mFromSurfaceDestroyToPlay = false;
                        if (!mgtvLoopVideoView4.mIsLoopMode) {
                            mgtvLoopVideoView4.mMediaPlayer.seekTo(mgtvLoopVideoView4.mFromSurfaceDestroyPlayPosition, false, true);
                        }
                        MgtvLoopVideoView.this.mFromSurfaceDestroyPlayPosition = 0;
                    }
                    MgtvLoopVideoView mgtvLoopVideoView5 = MgtvLoopVideoView.this;
                    mgtvLoopVideoView5.mSizeChangedListener.onVideoSizeChanged(mgtvLoopVideoView5.mMediaPlayer.getVideoWidth(), MgtvLoopVideoView.this.mMediaPlayer.getVideoHeight());
                    return;
                }
                MgtvLoopVideoView.this.openVideo();
            }

            private boolean needOpenVideo() {
                return MgtvLoopVideoView.this.mOpenVideoWhenSurfaceCreate && MgtvLoopVideoView.this.mCurrentUri != null;
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceChanged(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i, int i2, int i3) {
                DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "-----------surface changed");
                if (iSurfaceHolder.getRenderView() != MgtvLoopVideoView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                MgtvLoopVideoView.this.mSurfaceWidth = i2;
                MgtvLoopVideoView.this.mSurfaceHeight = i3;
                boolean z = true;
                boolean z2 = MgtvLoopVideoView.this.mTargetState == 3;
                if (MgtvLoopVideoView.this.mRenderView.shouldWaitForResize() && (MgtvLoopVideoView.this.mVideoWidth != i2 || MgtvLoopVideoView.this.mVideoHeight != i3)) {
                    z = false;
                }
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                if (mgtvLoopVideoView.mMediaPlayer != null && z2 && z) {
                    if (!mgtvLoopVideoView.mIsLoopMode && mgtvLoopVideoView.mSeekWhenPrepared != 0) {
                        MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                        mgtvLoopVideoView2.seekTo(mgtvLoopVideoView2.mSeekWhenPrepared, false);
                    }
                    MgtvLoopVideoView.this.start();
                }
                if (MgtvLoopVideoView.this.mSurfaceHolderListener != null) {
                    MgtvLoopVideoView.this.mSurfaceHolderListener.surfaceChanged();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceCreated(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i, int i2) {
                SurfaceHolder surfaceHolder;
                if (MgtvLoopVideoView.this.mStartLeaveTimestamp > 0) {
                    long currentTimeMillis = (System.currentTimeMillis() - MgtvLoopVideoView.this.mStartLeaveTimestamp) / 1000;
                    if (currentTimeMillis > 540) {
                        if (MgtvLoopVideoView.this.mOnWarningListener != null) {
                            MgtvPlayerListener.OnWarningListener onWarningListener = MgtvLoopVideoView.this.mOnWarningListener;
                            onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_LEAVE_TIME_INVALID, MgtvLoopVideoView.this.mCurrentState + "", "", null);
                        }
                        ReportParams reportParams = MgtvLoopVideoView.this.mReportParams;
                        if (reportParams != null) {
                            reportParams.setLeaveTimeS(currentTimeMillis);
                        }
                    }
                }
                DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "-----------surface create");
                MgtvMediaPlayer mgtvMediaPlayer = MgtvLoopVideoView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null && mgtvMediaPlayer.isLoadDataPaused()) {
                    DebugLog.i(MgtvLoopVideoView.this.getLogTag(), "bindHolder resumeLoadData");
                    MgtvLoopVideoView.this.mMediaPlayer.resumeLoadData();
                }
                if (iSurfaceHolder.getRenderView() != MgtvLoopVideoView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "onSurfaceCreated " + iSurfaceHolder);
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                mgtvLoopVideoView.mSurfaceHolder = iSurfaceHolder;
                if (mgtvLoopVideoView.mRenderView.getRenderViewType() == 0 && ((surfaceHolder = MgtvLoopVideoView.this.mSurfaceHolder.getSurfaceHolder()) == null || surfaceHolder.getSurface() == null || !surfaceHolder.getSurface().isValid())) {
                    MgtvLoopVideoView.this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SURFACE_FAILED, 1);
                    MgtvLoopVideoView.this.mErrorMsg = "surfaceCreated surface is invalid";
                } else {
                    bindHolder(iSurfaceHolder);
                }
                if (MgtvLoopVideoView.this.mSurfaceHolderListener != null) {
                    MgtvLoopVideoView.this.mSurfaceHolderListener.surfaceCreated();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceDestroyed(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, boolean z) {
                MgtvLoopVideoView.this.mLastSurfaceDestroy = z;
                if (iSurfaceHolder.getRenderView() != MgtvLoopVideoView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "onSurfaceDestroyed: unmatched render callback\n");
                    return;
                }
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "onSurfaceDestroyed " + iSurfaceHolder);
                if (MgtvLoopVideoView.this.mSurfaceHolderListener != null) {
                    MgtvLoopVideoView.this.mSurfaceHolderListener.surfaceDestroyed();
                }
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                mgtvLoopVideoView.mSurfaceHolder = null;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvLoopVideoView.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.setSurfaceHolder(null);
                    if (MgtvLoopVideoView.this.isPrepared()) {
                        MgtvLoopVideoView.this.pauseLoadData();
                        if (MgtvLoopVideoView.this.mIsLive) {
                            DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "-----------surface destroy to pause");
                        } else {
                            DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "-----------surface destroy to pause");
                            if (MgtvLoopVideoView.this.mRenderView.getRenderViewType() == 0) {
                                if (!MgtvLoopVideoView.this.mMediaPlayer.isSupportAMCKeyFrameBackup()) {
                                    MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                                    mgtvLoopVideoView2.mFromSurfaceDestroyToPlay = true;
                                    mgtvLoopVideoView2.mFromSurfaceDestroyPlayPosition = mgtvLoopVideoView2.mMediaPlayer.getCurrentPosition();
                                }
                            } else if (MgtvLoopVideoView.this.mRenderView.getRenderViewType() == 1) {
                                if (!MgtvLoopVideoView.this.isHardware()) {
                                    MgtvLoopVideoView.this.mFromSurfaceDestroyToPlay = true;
                                }
                                MgtvLoopVideoView mgtvLoopVideoView3 = MgtvLoopVideoView.this;
                                if (!mgtvLoopVideoView3.mIsLoopMode && mgtvLoopVideoView3.mEnableTexture) {
                                    mgtvLoopVideoView3.mHasSurfaceHolderDestroy = true;
                                }
                            }
                        }
                        MgtvLoopVideoView.this.pauseInner();
                    } else {
                        try {
                            ReportParams reportParams = MgtvLoopVideoView.this.mReportParams;
                            if (reportParams != null) {
                                reportParams.getEnd().setInnerRetry(true);
                            }
                            MgtvLoopVideoView.this.release(true, true);
                        } catch (Exception unused) {
                        }
                    }
                    MgtvLoopVideoView mgtvLoopVideoView4 = MgtvLoopVideoView.this;
                    if (mgtvLoopVideoView4.mCurrentUri == null || mgtvLoopVideoView4.mCurrentState == -1 || MgtvLoopVideoView.this.mCurrentState == 5) {
                        return;
                    }
                    MgtvLoopVideoView.this.mStartLeaveTimestamp = System.currentTimeMillis();
                }
            }
        };
        this.mFilterCallback = new f.a() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.2
            public void onInfo(int i, int i2, String str) {
                if (i == 1) {
                    MgtvLoopVideoView.this.mRenderType = i2;
                    MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                    ReportParams reportParams = mgtvLoopVideoView.mReportParams;
                    if (reportParams != null) {
                        reportParams.setRenderType(mgtvLoopVideoView.mRenderType);
                    }
                } else if (i != 3) {
                } else {
                    MgtvLoopVideoView.this.mEnhanceQualityType = i2;
                    MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                    ReportParams reportParams2 = mgtvLoopVideoView2.mReportParams;
                    if (reportParams2 != null) {
                        reportParams2.setEnhanceQualityType(mgtvLoopVideoView2.mEnhanceQualityType);
                    }
                }
            }
        };
        this.mRenderWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i, int i2) {
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i, String str, String str2, Object obj) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "opengl render warning:" + i + ",extra:" + str + ",msg:" + str2);
                if (MgtvLoopVideoView.this.mOnWarningListener != null) {
                    MgtvLoopVideoView.this.mOnWarningListener.onWarning(i, str, str2, obj);
                }
            }
        };
        this.mSizeChangedListener = new MgtvPlayerListener.OnVideoSizeChangedListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i, int i2) {
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                mgtvLoopVideoView.originalVideoWidth = mgtvLoopVideoView.mVideoWidth = mgtvLoopVideoView.mMediaPlayer.getVideoWidth();
                MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                mgtvLoopVideoView2.originalVideoHeight = mgtvLoopVideoView2.mVideoHeight = mgtvLoopVideoView2.mMediaPlayer.getVideoHeight();
                if (MgtvLoopVideoView.this.mVideoWidth != 0 && MgtvLoopVideoView.this.mVideoHeight != 0) {
                    MgtvLoopVideoView mgtvLoopVideoView3 = MgtvLoopVideoView.this;
                    MgtvRenderView mgtvRenderView = mgtvLoopVideoView3.mRenderView;
                    if (mgtvRenderView != null) {
                        mgtvRenderView.setVideoSize(mgtvLoopVideoView3.mVideoWidth, MgtvLoopVideoView.this.mVideoHeight);
                    }
                    MgtvLoopVideoView.this.requestLayout();
                }
                if (MgtvLoopVideoView.this.mOnVideoSizeChangedListener != null) {
                    MgtvLoopVideoView.this.mOnVideoSizeChangedListener.onVideoSizeChanged(i, i2);
                }
            }
        };
        this.mPreparedListener = new MgtvPlayerListener.OnPreparedListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.5
            /* JADX WARN: Code restructure failed: missing block: B:17:0x00a3, code lost:
                if (r4.this$0.mSurfaceHeight != r4.this$0.mVideoHeight) goto L17;
             */
            /* JADX WARN: Code restructure failed: missing block: B:19:0x00ab, code lost:
                if (r4.this$0.mTargetState != 3) goto L17;
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x00b4, code lost:
                if (r4.this$0.mTargetState == 3) goto L25;
             */
            /* JADX WARN: Code restructure failed: missing block: B:23:0x00b6, code lost:
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
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    r1 = 2
                    com.hunantv.media.widget.MgtvLoopVideoView.access$2800(r0, r1)
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoWidth()
                    int r1 = com.hunantv.media.widget.MgtvLoopVideoView.access$302(r0, r1)
                    com.hunantv.media.widget.MgtvLoopVideoView.access$2502(r0, r1)
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoHeight()
                    int r1 = com.hunantv.media.widget.MgtvLoopVideoView.access$402(r0, r1)
                    com.hunantv.media.widget.MgtvLoopVideoView.access$2602(r0, r1)
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$300(r0)
                    r1 = 3
                    if (r0 == 0) goto Lae
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$400(r0)
                    if (r0 == 0) goto Lae
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "video size: "
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvLoopVideoView r2 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r2 = com.hunantv.media.widget.MgtvLoopVideoView.access$300(r2)
                    r0.append(r2)
                    java.lang.String r2 = "/"
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvLoopVideoView r2 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r2 = com.hunantv.media.widget.MgtvLoopVideoView.access$400(r2)
                    r0.append(r2)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r2 = "@@@@"
                    com.hunantv.media.player.pragma.DebugLog.i(r2, r0)
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.player.MgtvRenderView r2 = r0.mRenderView
                    if (r2 == 0) goto L72
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$300(r0)
                    com.hunantv.media.widget.MgtvLoopVideoView r3 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r3 = com.hunantv.media.widget.MgtvLoopVideoView.access$400(r3)
                    r2.setVideoSize(r0, r3)
                L72:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$500(r0)
                    if (r0 == 0) goto L7f
                    com.hunantv.media.widget.MgtvLoopVideoView r2 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    r2.seekTo(r0)
                L7f:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.player.MgtvRenderView r0 = r0.mRenderView
                    boolean r0 = r0.shouldWaitForResize()
                    if (r0 == 0) goto La5
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$000(r0)
                    com.hunantv.media.widget.MgtvLoopVideoView r2 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r2 = com.hunantv.media.widget.MgtvLoopVideoView.access$300(r2)
                    if (r0 != r2) goto Lbb
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$100(r0)
                    com.hunantv.media.widget.MgtvLoopVideoView r2 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r2 = com.hunantv.media.widget.MgtvLoopVideoView.access$400(r2)
                    if (r0 != r2) goto Lbb
                La5:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$200(r0)
                    if (r0 != r1) goto Lbb
                    goto Lb6
                Lae:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$200(r0)
                    if (r0 != r1) goto Lbb
                Lb6:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    r0.start()
                Lbb:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$2900(r0)
                    if (r0 == 0) goto Lcc
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$2900(r0)
                    r0.onPrepared()
                Lcc:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvLoopVideoView.AnonymousClass5.onPrepared():void");
            }
        };
        this.mCompletionListener = new MgtvPlayerListener.OnCompletionListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.6
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnCompletionListener
            public void onCompletion(int i, int i2) {
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                if (i != 0) {
                    mgtvLoopVideoView.changeCurrentState(0);
                    MgtvLoopVideoView.this.mTargetState = 0;
                    MgtvLoopVideoView.this.stopInner();
                } else {
                    mgtvLoopVideoView.changeCurrentState(5);
                    MgtvLoopVideoView.this.mTargetState = 5;
                }
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "-------------on onCompletion what:" + i + ",extra:" + i2);
                if (MgtvLoopVideoView.this.mOnCompletionListener != null) {
                    MgtvLoopVideoView.this.mOnCompletionListener.onCompletion(i, i2);
                }
            }
        };
        this.mInfoListener = new MgtvPlayerListener.OnInfoListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.7
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
                        logTag = MgtvLoopVideoView.this.getLogTag();
                        sb = new StringBuilder();
                        str = "video fps is ";
                    } else if (i == 2820) {
                        logTag = MgtvLoopVideoView.this.getLogTag();
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
                        String logTag2 = MgtvLoopVideoView.this.getLogTag();
                        DebugLog.i(logTag2, "MEDIA_INFO_PLAYBACK_STATE_CHANGED:" + i2);
                        if (MgtvLoopVideoView.this.mOnUpdateStatusListener != null) {
                            MgtvLoopVideoView.this.mOnUpdateStatusListener.onUpdateStatus();
                        }
                    } else if (i == 10001) {
                        String logTag3 = MgtvLoopVideoView.this.getLogTag();
                        DebugLog.w(logTag3, "video rotation changed,extra(degree) is " + i2);
                        MgtvLoopVideoView.this.mVideoRotationDegree = i2;
                        MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                        MgtvRenderView mgtvRenderView = mgtvLoopVideoView.mRenderView;
                        if (mgtvRenderView != null) {
                            mgtvRenderView.setVideoRotation(mgtvLoopVideoView.mVideoRotationDegree);
                        }
                    } else if (i == 200001) {
                        MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                        if (i2 == 1) {
                            mgtvLoopVideoView2.mMgtvMediaPlayerHardwareMode = false;
                        } else {
                            mgtvLoopVideoView2.mMgtvMediaPlayerHardwareMode = true;
                        }
                        MgtvLoopVideoView mgtvLoopVideoView3 = MgtvLoopVideoView.this;
                        mgtvLoopVideoView3.convertRender(mgtvLoopVideoView3.mRenderViewType);
                    } else if (i == 3) {
                        DebugLog.w(MgtvLoopVideoView.this.getLogTag(), "msg coming: video decode succeeded");
                        MgtvLoopVideoView.this.onVideoRenderStart();
                        if (MgtvLoopVideoView.this.mOnInfoListener != null) {
                            DebugLog.i(MgtvLoopVideoView.this.getLogTag(), "video decode succeeded, start rendering");
                            MgtvLoopVideoView.this.mOnInfoListener.onInfo(900, i2);
                        }
                        return true;
                    } else {
                        if (i == 4) {
                            logTag = MgtvLoopVideoView.this.getLogTag();
                            str2 = "audio decode succeeded, start rendering";
                        } else if (i != 5) {
                            if (i == 6) {
                                if (i2 == 0) {
                                    MgtvLoopVideoView.this.mMgtvMediaPlayerHardwareMode = false;
                                } else if (i2 == 1) {
                                    MgtvLoopVideoView.this.mMgtvMediaPlayerHardwareMode = true;
                                }
                                logTag = MgtvLoopVideoView.this.getLogTag();
                                sb = new StringBuilder();
                                str = "video decoder open,extra is ";
                            } else if (i != 7) {
                                switch (i) {
                                    case 700:
                                        String logTag4 = MgtvLoopVideoView.this.getLogTag();
                                        DebugLog.w(logTag4, "It's too complex for the decoder, extra is " + i2);
                                        i = 700;
                                        break;
                                    case 701:
                                        String logTag5 = MgtvLoopVideoView.this.getLogTag();
                                        DebugLog.w(logTag5, "buffer start speed:" + MgtvLoopVideoView.this.getDLSpeedFormat());
                                        i = 701;
                                        break;
                                    case 702:
                                        String logTag6 = MgtvLoopVideoView.this.getLogTag();
                                        DebugLog.w(logTag6, "buffer end speed:" + MgtvLoopVideoView.this.getDLSpeedFormat());
                                        i = 702;
                                        break;
                                    default:
                                        switch (i) {
                                            case 800:
                                                String logTag7 = MgtvLoopVideoView.this.getLogTag();
                                                DebugLog.e(logTag7, "Bad interleaving of media file, audio/video are not well-formed, extra is " + i2);
                                                i = 800;
                                                break;
                                            case 801:
                                                String logTag8 = MgtvLoopVideoView.this.getLogTag();
                                                DebugLog.w(logTag8, "The stream not seekable status, extra is " + i2);
                                                i = 801;
                                                MgtvLoopVideoView mgtvLoopVideoView4 = MgtvLoopVideoView.this;
                                                if (i2 != 1) {
                                                    mgtvLoopVideoView4.mIsLive = false;
                                                    logTag = MgtvLoopVideoView.this.getLogTag();
                                                    str2 = "The stream is not live stream,can seekable ";
                                                    break;
                                                } else {
                                                    mgtvLoopVideoView4.mIsLive = true;
                                                    logTag = MgtvLoopVideoView.this.getLogTag();
                                                    str2 = "The stream is live stream,can not seekable ";
                                                    break;
                                                }
                                            case 802:
                                                String logTag9 = MgtvLoopVideoView.this.getLogTag();
                                                DebugLog.w(logTag9, "A new set of metadata is available, extra is " + i2);
                                                i = 802;
                                                break;
                                            default:
                                                logTag = MgtvLoopVideoView.this.getLogTag();
                                                switch (i) {
                                                    case MgtvMediaPlayer.MEDIA_INFO_DATA_PROTOCOL /* 2803 */:
                                                        DebugLog.w(logTag, "data source type is " + i2);
                                                        MgtvLoopVideoView mgtvLoopVideoView5 = MgtvLoopVideoView.this;
                                                        MgtvMediaPlayer mgtvMediaPlayer = mgtvLoopVideoView5.mMediaPlayer;
                                                        if (mgtvMediaPlayer != null) {
                                                            mgtvLoopVideoView5.mDataSourceType = mgtvMediaPlayer.getDataSourceType();
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
                        DebugLog.w(logTag, str2);
                    }
                    sb.append(str);
                    sb.append(i2);
                    str2 = sb.toString();
                    DebugLog.w(logTag, str2);
                } else {
                    String logTag10 = MgtvLoopVideoView.this.getLogTag();
                    DebugLog.w(logTag10, "Unknown info, extra is " + i2);
                    i = 1;
                }
                if (MgtvLoopVideoView.this.mOnInfoListener != null) {
                    MgtvLoopVideoView.this.mOnInfoListener.onInfo(i, i2);
                }
                return true;
            }
        };
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.8
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i, int i2) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.w(logTag, "onError what:" + i + ",extra:" + i2);
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvLoopVideoView.mMediaPlayer;
                if (mgtvMediaPlayer == null || i != 7000006) {
                    if (mgtvMediaPlayer != null && mgtvLoopVideoView.mCurrentState != -1) {
                        MgtvLoopVideoView.this.mMediaPlayer.stop();
                    }
                    MgtvLoopVideoView.this.changeCurrentState(-1);
                    MgtvLoopVideoView.this.mTargetState = -1;
                } else {
                    mgtvLoopVideoView.releaseNoStatus();
                    MgtvLoopVideoView.this.changeCurrentState(0);
                    MgtvLoopVideoView.this.mTargetState = 0;
                }
                MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                mgtvLoopVideoView2.mCurrentUri = null;
                mgtvLoopVideoView2.mProxyUri = null;
                return mgtvLoopVideoView2.mOnErrorListener != null && MgtvLoopVideoView.this.mOnErrorListener.onError(i, i2);
            }
        };
        this.mSeekCompleteListener = new MgtvPlayerListener.OnSeekCompleteListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.9
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSeekCompleteListener
            public void onSeekComplete(int i, int i2) {
                if (MgtvLoopVideoView.this.mOnSeekCompleteListener != null) {
                    String logTag = MgtvLoopVideoView.this.getLogTag();
                    DebugLog.i(logTag, "onSeekComplete seekTargetTime:" + i + ",errorCode:" + i2);
                    MgtvLoopVideoView.this.mOnSeekCompleteListener.onSeekComplete();
                }
            }
        };
        this.mBufferingUpdateListener = new MgtvPlayerListener.OnBufferingUpdateListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.10
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingUpdateListener
            public void onBufferingUpdate(int i) {
                if (MgtvLoopVideoView.this.mOnBufferringUpdateListener != null) {
                    MgtvLoopVideoView.this.mOnBufferringUpdateListener.onBufferingUpdate(i);
                }
            }
        };
        this.mBufferingTimeoutListener = new MgtvPlayerListener.OnBufferingTimeoutListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.11
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingTimeoutListener
            public boolean onBufferingTimeout(int i, int i2) {
                MgtvMediaPlayer mgtvMediaPlayer = MgtvLoopVideoView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.stop();
                }
                MgtvLoopVideoView.this.changeCurrentState(-1);
                MgtvLoopVideoView.this.mTargetState = -1;
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                mgtvLoopVideoView.mCurrentUri = null;
                mgtvLoopVideoView.mProxyUri = null;
                if (mgtvLoopVideoView.mOnErrorListener == null || MgtvLoopVideoView.this.mOnErrorListener.onError(i, i2)) {
                }
                return true;
            }
        };
        this.mSwitchSourceListener = new MgtvPlayerListener.OnSwitchSourceListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.12
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceComplete(String str, int i, int i2) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceComplete url:" + str + ",type:" + i + ",time:" + i2);
                if (MgtvLoopVideoView.this.mOnChangeSourceListener != null) {
                    MgtvLoopVideoView.this.mOnChangeSourceListener.onChangeSourceSuccess(str, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceFailed(String str, int i, int i2) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceFailed url:" + str + ",what:" + i + ",extra:" + i2);
                if (MgtvLoopVideoView.this.mOnChangeSourceListener != null) {
                    MgtvLoopVideoView.this.mOnChangeSourceListener.onChangeSourceFailed(str, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceInfo(String str, int i, int i2) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceInfo url:" + str + ",event:" + i + ",time:" + i2);
                if (MgtvLoopVideoView.this.mOnChangeSourceListener != null) {
                    MgtvLoopVideoView.this.mOnChangeSourceListener.onChangeSourceInfo(str, i, i2);
                }
            }
        };
        this.mPlayerWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.13
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i, int i2) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "onTsSkip tsUrl:" + str);
                if (MgtvLoopVideoView.this.mOnWarningListener != null) {
                    MgtvLoopVideoView.this.mOnWarningListener.onTsSkip(str, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i, String str, String str2, Object obj) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "player render warning:" + i + ",extra:" + str + ",msg:" + str2);
                if (MgtvLoopVideoView.this.mOnWarningListener != null) {
                    MgtvLoopVideoView.this.mOnWarningListener.onWarning(i, str, str2, obj);
                }
            }
        };
        this.mGifRecorder = new GifRecorder();
        this.mStartListener = new MgtvPlayerListener.OnStartListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.14
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnStartListener
            public void onStart() {
                DebugLog.d(MgtvLoopVideoView.this.getLogTag(), "mgtvcore onStart");
                if (MgtvLoopVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvLoopVideoView.this.callbackOnStart();
                }
            }
        };
        this.mPauseListener = new MgtvPlayerListener.OnPauseListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.15
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPauseListener
            public void onPause() {
                DebugLog.d(MgtvLoopVideoView.this.getLogTag(), "mgtvcore onPause");
                if (MgtvLoopVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvLoopVideoView.this.callbackOnPause();
                }
            }
        };
        this.mRecordVideoListener = new MgtvPlayerListener.OnRecordVideoListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.16
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoErr(int i, int i2) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.e(logTag, "onRecordVideoErr what:" + i + ",extra:" + i2);
                if (MgtvLoopVideoView.this.mOnRecordListener != null) {
                    MgtvLoopVideoView.this.mOnRecordListener.onRecordError(i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoInfo(int i, int i2) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "onRecordVideoInfo what:" + i + ",extra:" + i2);
                if (MgtvLoopVideoView.this.mOnRecordListener != null) {
                    if (i == 20) {
                        MgtvLoopVideoView.this.mOnRecordListener.onRecordStart(MgtvLoopVideoView.this.mRecordFilePath);
                    } else if (i == 30) {
                        MgtvLoopVideoView.this.mOnRecordListener.onRecordStop();
                    }
                    MgtvLoopVideoView.this.mOnRecordListener.onRecordInfo(i, i2);
                }
            }
        };
        this.mLoadDataListener = new MgtvPlayerListener.OnLoadDataListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.17
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onAfterLoadDataPaused() {
                if (MgtvLoopVideoView.this.mOnLoadDataListener != null) {
                    MgtvLoopVideoView.this.mOnLoadDataListener.onAfterLoadDataPaused();
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onBeforeLoadDataResume() {
                if (MgtvLoopVideoView.this.mOnLoadDataListener != null) {
                    MgtvLoopVideoView.this.mOnLoadDataListener.onBeforeLoadDataResume();
                }
            }
        };
        initVideoView(context);
    }

    public MgtvLoopVideoView(Context context, AttributeSet attributeSet) {
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
        this.mIsDataLoaderPaused = false;
        this.mUseSystemPlayer = false;
        this.mAddrInfoType = MgtvMediaPlayer.AddrinfoType.TYPE_ADDRINFO_DEFAULT;
        this.mAddrInfoTypeInt = 0;
        this.mJavaDnsType = a.d.a;
        this.mNativeDnsAsyncEnable = true;
        this.mEnableMgtvMediaCodec = false;
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
        this.mTargetIsLoopMode = false;
        this.mIsLoopMode = false;
        this.mStartPosMs = 0;
        this.mNeedResetLoopPlay = false;
        this.mFlowDataStatistic = new FlowDataStatistic();
        this.mSkipLoopFilterType = MgtvMediaPlayer.SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mSHCallback = new IMgtvRenderView.IRenderCallback() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.1
            private void bindHolder(IMgtvRenderView.ISurfaceHolder iSurfaceHolder) {
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                if (mgtvLoopVideoView.mMediaPlayer == null) {
                    mgtvLoopVideoView.openVideo();
                    return;
                }
                if (mgtvLoopVideoView.mHasSurfaceHolderDestroy && mgtvLoopVideoView.mRebindTexture) {
                    MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                    if (mgtvLoopVideoView2.mCurrentUri != null) {
                        mgtvLoopVideoView2.setStartPosMs(mgtvLoopVideoView2.mMediaPlayer.getCurrentPosition());
                        MgtvLoopVideoView.this.openVideo();
                    }
                }
                if (!needOpenVideo()) {
                    MgtvLoopVideoView.this.mMediaPlayer.setSurfaceHolder(iSurfaceHolder);
                    MgtvLoopVideoView mgtvLoopVideoView3 = MgtvLoopVideoView.this;
                    if (mgtvLoopVideoView3.mNeedResetLoopPlay) {
                        mgtvLoopVideoView3.resetVideoPath();
                    } else if (!mgtvLoopVideoView3.mFromSurfaceDestroyToPlay || mgtvLoopVideoView3.mCurrentUri == null) {
                        if (mgtvLoopVideoView3.mLastFrameRecovery && (!MgtvLoopVideoView.this.isHardware() || MgtvLoopVideoView.this.mLastSurfaceDestroy)) {
                            MgtvLoopVideoView.this.mMediaPlayer.setPlaybackStep();
                        }
                    } else if (mgtvLoopVideoView3.mMgtvMediaPlayerHardwareMode) {
                        MgtvLoopVideoView mgtvLoopVideoView4 = MgtvLoopVideoView.this;
                        mgtvLoopVideoView4.mFromSurfaceDestroyToPlay = false;
                        if (!mgtvLoopVideoView4.mIsLoopMode) {
                            mgtvLoopVideoView4.mMediaPlayer.seekTo(mgtvLoopVideoView4.mFromSurfaceDestroyPlayPosition, false, true);
                        }
                        MgtvLoopVideoView.this.mFromSurfaceDestroyPlayPosition = 0;
                    }
                    MgtvLoopVideoView mgtvLoopVideoView5 = MgtvLoopVideoView.this;
                    mgtvLoopVideoView5.mSizeChangedListener.onVideoSizeChanged(mgtvLoopVideoView5.mMediaPlayer.getVideoWidth(), MgtvLoopVideoView.this.mMediaPlayer.getVideoHeight());
                    return;
                }
                MgtvLoopVideoView.this.openVideo();
            }

            private boolean needOpenVideo() {
                return MgtvLoopVideoView.this.mOpenVideoWhenSurfaceCreate && MgtvLoopVideoView.this.mCurrentUri != null;
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceChanged(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i, int i2, int i3) {
                DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "-----------surface changed");
                if (iSurfaceHolder.getRenderView() != MgtvLoopVideoView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                MgtvLoopVideoView.this.mSurfaceWidth = i2;
                MgtvLoopVideoView.this.mSurfaceHeight = i3;
                boolean z = true;
                boolean z2 = MgtvLoopVideoView.this.mTargetState == 3;
                if (MgtvLoopVideoView.this.mRenderView.shouldWaitForResize() && (MgtvLoopVideoView.this.mVideoWidth != i2 || MgtvLoopVideoView.this.mVideoHeight != i3)) {
                    z = false;
                }
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                if (mgtvLoopVideoView.mMediaPlayer != null && z2 && z) {
                    if (!mgtvLoopVideoView.mIsLoopMode && mgtvLoopVideoView.mSeekWhenPrepared != 0) {
                        MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                        mgtvLoopVideoView2.seekTo(mgtvLoopVideoView2.mSeekWhenPrepared, false);
                    }
                    MgtvLoopVideoView.this.start();
                }
                if (MgtvLoopVideoView.this.mSurfaceHolderListener != null) {
                    MgtvLoopVideoView.this.mSurfaceHolderListener.surfaceChanged();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceCreated(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i, int i2) {
                SurfaceHolder surfaceHolder;
                if (MgtvLoopVideoView.this.mStartLeaveTimestamp > 0) {
                    long currentTimeMillis = (System.currentTimeMillis() - MgtvLoopVideoView.this.mStartLeaveTimestamp) / 1000;
                    if (currentTimeMillis > 540) {
                        if (MgtvLoopVideoView.this.mOnWarningListener != null) {
                            MgtvPlayerListener.OnWarningListener onWarningListener = MgtvLoopVideoView.this.mOnWarningListener;
                            onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_LEAVE_TIME_INVALID, MgtvLoopVideoView.this.mCurrentState + "", "", null);
                        }
                        ReportParams reportParams = MgtvLoopVideoView.this.mReportParams;
                        if (reportParams != null) {
                            reportParams.setLeaveTimeS(currentTimeMillis);
                        }
                    }
                }
                DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "-----------surface create");
                MgtvMediaPlayer mgtvMediaPlayer = MgtvLoopVideoView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null && mgtvMediaPlayer.isLoadDataPaused()) {
                    DebugLog.i(MgtvLoopVideoView.this.getLogTag(), "bindHolder resumeLoadData");
                    MgtvLoopVideoView.this.mMediaPlayer.resumeLoadData();
                }
                if (iSurfaceHolder.getRenderView() != MgtvLoopVideoView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "onSurfaceCreated " + iSurfaceHolder);
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                mgtvLoopVideoView.mSurfaceHolder = iSurfaceHolder;
                if (mgtvLoopVideoView.mRenderView.getRenderViewType() == 0 && ((surfaceHolder = MgtvLoopVideoView.this.mSurfaceHolder.getSurfaceHolder()) == null || surfaceHolder.getSurface() == null || !surfaceHolder.getSurface().isValid())) {
                    MgtvLoopVideoView.this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SURFACE_FAILED, 1);
                    MgtvLoopVideoView.this.mErrorMsg = "surfaceCreated surface is invalid";
                } else {
                    bindHolder(iSurfaceHolder);
                }
                if (MgtvLoopVideoView.this.mSurfaceHolderListener != null) {
                    MgtvLoopVideoView.this.mSurfaceHolderListener.surfaceCreated();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceDestroyed(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, boolean z) {
                MgtvLoopVideoView.this.mLastSurfaceDestroy = z;
                if (iSurfaceHolder.getRenderView() != MgtvLoopVideoView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "onSurfaceDestroyed: unmatched render callback\n");
                    return;
                }
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "onSurfaceDestroyed " + iSurfaceHolder);
                if (MgtvLoopVideoView.this.mSurfaceHolderListener != null) {
                    MgtvLoopVideoView.this.mSurfaceHolderListener.surfaceDestroyed();
                }
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                mgtvLoopVideoView.mSurfaceHolder = null;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvLoopVideoView.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.setSurfaceHolder(null);
                    if (MgtvLoopVideoView.this.isPrepared()) {
                        MgtvLoopVideoView.this.pauseLoadData();
                        if (MgtvLoopVideoView.this.mIsLive) {
                            DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "-----------surface destroy to pause");
                        } else {
                            DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "-----------surface destroy to pause");
                            if (MgtvLoopVideoView.this.mRenderView.getRenderViewType() == 0) {
                                if (!MgtvLoopVideoView.this.mMediaPlayer.isSupportAMCKeyFrameBackup()) {
                                    MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                                    mgtvLoopVideoView2.mFromSurfaceDestroyToPlay = true;
                                    mgtvLoopVideoView2.mFromSurfaceDestroyPlayPosition = mgtvLoopVideoView2.mMediaPlayer.getCurrentPosition();
                                }
                            } else if (MgtvLoopVideoView.this.mRenderView.getRenderViewType() == 1) {
                                if (!MgtvLoopVideoView.this.isHardware()) {
                                    MgtvLoopVideoView.this.mFromSurfaceDestroyToPlay = true;
                                }
                                MgtvLoopVideoView mgtvLoopVideoView3 = MgtvLoopVideoView.this;
                                if (!mgtvLoopVideoView3.mIsLoopMode && mgtvLoopVideoView3.mEnableTexture) {
                                    mgtvLoopVideoView3.mHasSurfaceHolderDestroy = true;
                                }
                            }
                        }
                        MgtvLoopVideoView.this.pauseInner();
                    } else {
                        try {
                            ReportParams reportParams = MgtvLoopVideoView.this.mReportParams;
                            if (reportParams != null) {
                                reportParams.getEnd().setInnerRetry(true);
                            }
                            MgtvLoopVideoView.this.release(true, true);
                        } catch (Exception unused) {
                        }
                    }
                    MgtvLoopVideoView mgtvLoopVideoView4 = MgtvLoopVideoView.this;
                    if (mgtvLoopVideoView4.mCurrentUri == null || mgtvLoopVideoView4.mCurrentState == -1 || MgtvLoopVideoView.this.mCurrentState == 5) {
                        return;
                    }
                    MgtvLoopVideoView.this.mStartLeaveTimestamp = System.currentTimeMillis();
                }
            }
        };
        this.mFilterCallback = new f.a() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.2
            public void onInfo(int i, int i2, String str) {
                if (i == 1) {
                    MgtvLoopVideoView.this.mRenderType = i2;
                    MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                    ReportParams reportParams = mgtvLoopVideoView.mReportParams;
                    if (reportParams != null) {
                        reportParams.setRenderType(mgtvLoopVideoView.mRenderType);
                    }
                } else if (i != 3) {
                } else {
                    MgtvLoopVideoView.this.mEnhanceQualityType = i2;
                    MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                    ReportParams reportParams2 = mgtvLoopVideoView2.mReportParams;
                    if (reportParams2 != null) {
                        reportParams2.setEnhanceQualityType(mgtvLoopVideoView2.mEnhanceQualityType);
                    }
                }
            }
        };
        this.mRenderWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i, int i2) {
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i, String str, String str2, Object obj) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "opengl render warning:" + i + ",extra:" + str + ",msg:" + str2);
                if (MgtvLoopVideoView.this.mOnWarningListener != null) {
                    MgtvLoopVideoView.this.mOnWarningListener.onWarning(i, str, str2, obj);
                }
            }
        };
        this.mSizeChangedListener = new MgtvPlayerListener.OnVideoSizeChangedListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i, int i2) {
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                mgtvLoopVideoView.originalVideoWidth = mgtvLoopVideoView.mVideoWidth = mgtvLoopVideoView.mMediaPlayer.getVideoWidth();
                MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                mgtvLoopVideoView2.originalVideoHeight = mgtvLoopVideoView2.mVideoHeight = mgtvLoopVideoView2.mMediaPlayer.getVideoHeight();
                if (MgtvLoopVideoView.this.mVideoWidth != 0 && MgtvLoopVideoView.this.mVideoHeight != 0) {
                    MgtvLoopVideoView mgtvLoopVideoView3 = MgtvLoopVideoView.this;
                    MgtvRenderView mgtvRenderView = mgtvLoopVideoView3.mRenderView;
                    if (mgtvRenderView != null) {
                        mgtvRenderView.setVideoSize(mgtvLoopVideoView3.mVideoWidth, MgtvLoopVideoView.this.mVideoHeight);
                    }
                    MgtvLoopVideoView.this.requestLayout();
                }
                if (MgtvLoopVideoView.this.mOnVideoSizeChangedListener != null) {
                    MgtvLoopVideoView.this.mOnVideoSizeChangedListener.onVideoSizeChanged(i, i2);
                }
            }
        };
        this.mPreparedListener = new MgtvPlayerListener.OnPreparedListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.5
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPreparedListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPrepared() {
                /*
                    r4 = this;
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    r1 = 2
                    com.hunantv.media.widget.MgtvLoopVideoView.access$2800(r0, r1)
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoWidth()
                    int r1 = com.hunantv.media.widget.MgtvLoopVideoView.access$302(r0, r1)
                    com.hunantv.media.widget.MgtvLoopVideoView.access$2502(r0, r1)
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoHeight()
                    int r1 = com.hunantv.media.widget.MgtvLoopVideoView.access$402(r0, r1)
                    com.hunantv.media.widget.MgtvLoopVideoView.access$2602(r0, r1)
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$300(r0)
                    r1 = 3
                    if (r0 == 0) goto Lae
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$400(r0)
                    if (r0 == 0) goto Lae
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "video size: "
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvLoopVideoView r2 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r2 = com.hunantv.media.widget.MgtvLoopVideoView.access$300(r2)
                    r0.append(r2)
                    java.lang.String r2 = "/"
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvLoopVideoView r2 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r2 = com.hunantv.media.widget.MgtvLoopVideoView.access$400(r2)
                    r0.append(r2)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r2 = "@@@@"
                    com.hunantv.media.player.pragma.DebugLog.i(r2, r0)
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.player.MgtvRenderView r2 = r0.mRenderView
                    if (r2 == 0) goto L72
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$300(r0)
                    com.hunantv.media.widget.MgtvLoopVideoView r3 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r3 = com.hunantv.media.widget.MgtvLoopVideoView.access$400(r3)
                    r2.setVideoSize(r0, r3)
                L72:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$500(r0)
                    if (r0 == 0) goto L7f
                    com.hunantv.media.widget.MgtvLoopVideoView r2 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    r2.seekTo(r0)
                L7f:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.player.MgtvRenderView r0 = r0.mRenderView
                    boolean r0 = r0.shouldWaitForResize()
                    if (r0 == 0) goto La5
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$000(r0)
                    com.hunantv.media.widget.MgtvLoopVideoView r2 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r2 = com.hunantv.media.widget.MgtvLoopVideoView.access$300(r2)
                    if (r0 != r2) goto Lbb
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$100(r0)
                    com.hunantv.media.widget.MgtvLoopVideoView r2 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r2 = com.hunantv.media.widget.MgtvLoopVideoView.access$400(r2)
                    if (r0 != r2) goto Lbb
                La5:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$200(r0)
                    if (r0 != r1) goto Lbb
                    goto Lb6
                Lae:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$200(r0)
                    if (r0 != r1) goto Lbb
                Lb6:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    r0.start()
                Lbb:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$2900(r0)
                    if (r0 == 0) goto Lcc
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$2900(r0)
                    r0.onPrepared()
                Lcc:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvLoopVideoView.AnonymousClass5.onPrepared():void");
            }
        };
        this.mCompletionListener = new MgtvPlayerListener.OnCompletionListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.6
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnCompletionListener
            public void onCompletion(int i, int i2) {
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                if (i != 0) {
                    mgtvLoopVideoView.changeCurrentState(0);
                    MgtvLoopVideoView.this.mTargetState = 0;
                    MgtvLoopVideoView.this.stopInner();
                } else {
                    mgtvLoopVideoView.changeCurrentState(5);
                    MgtvLoopVideoView.this.mTargetState = 5;
                }
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "-------------on onCompletion what:" + i + ",extra:" + i2);
                if (MgtvLoopVideoView.this.mOnCompletionListener != null) {
                    MgtvLoopVideoView.this.mOnCompletionListener.onCompletion(i, i2);
                }
            }
        };
        this.mInfoListener = new MgtvPlayerListener.OnInfoListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.7
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
                        logTag = MgtvLoopVideoView.this.getLogTag();
                        sb = new StringBuilder();
                        str = "video fps is ";
                    } else if (i == 2820) {
                        logTag = MgtvLoopVideoView.this.getLogTag();
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
                        String logTag2 = MgtvLoopVideoView.this.getLogTag();
                        DebugLog.i(logTag2, "MEDIA_INFO_PLAYBACK_STATE_CHANGED:" + i2);
                        if (MgtvLoopVideoView.this.mOnUpdateStatusListener != null) {
                            MgtvLoopVideoView.this.mOnUpdateStatusListener.onUpdateStatus();
                        }
                    } else if (i == 10001) {
                        String logTag3 = MgtvLoopVideoView.this.getLogTag();
                        DebugLog.w(logTag3, "video rotation changed,extra(degree) is " + i2);
                        MgtvLoopVideoView.this.mVideoRotationDegree = i2;
                        MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                        MgtvRenderView mgtvRenderView = mgtvLoopVideoView.mRenderView;
                        if (mgtvRenderView != null) {
                            mgtvRenderView.setVideoRotation(mgtvLoopVideoView.mVideoRotationDegree);
                        }
                    } else if (i == 200001) {
                        MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                        if (i2 == 1) {
                            mgtvLoopVideoView2.mMgtvMediaPlayerHardwareMode = false;
                        } else {
                            mgtvLoopVideoView2.mMgtvMediaPlayerHardwareMode = true;
                        }
                        MgtvLoopVideoView mgtvLoopVideoView3 = MgtvLoopVideoView.this;
                        mgtvLoopVideoView3.convertRender(mgtvLoopVideoView3.mRenderViewType);
                    } else if (i == 3) {
                        DebugLog.w(MgtvLoopVideoView.this.getLogTag(), "msg coming: video decode succeeded");
                        MgtvLoopVideoView.this.onVideoRenderStart();
                        if (MgtvLoopVideoView.this.mOnInfoListener != null) {
                            DebugLog.i(MgtvLoopVideoView.this.getLogTag(), "video decode succeeded, start rendering");
                            MgtvLoopVideoView.this.mOnInfoListener.onInfo(900, i2);
                        }
                        return true;
                    } else {
                        if (i == 4) {
                            logTag = MgtvLoopVideoView.this.getLogTag();
                            str2 = "audio decode succeeded, start rendering";
                        } else if (i != 5) {
                            if (i == 6) {
                                if (i2 == 0) {
                                    MgtvLoopVideoView.this.mMgtvMediaPlayerHardwareMode = false;
                                } else if (i2 == 1) {
                                    MgtvLoopVideoView.this.mMgtvMediaPlayerHardwareMode = true;
                                }
                                logTag = MgtvLoopVideoView.this.getLogTag();
                                sb = new StringBuilder();
                                str = "video decoder open,extra is ";
                            } else if (i != 7) {
                                switch (i) {
                                    case 700:
                                        String logTag4 = MgtvLoopVideoView.this.getLogTag();
                                        DebugLog.w(logTag4, "It's too complex for the decoder, extra is " + i2);
                                        i = 700;
                                        break;
                                    case 701:
                                        String logTag5 = MgtvLoopVideoView.this.getLogTag();
                                        DebugLog.w(logTag5, "buffer start speed:" + MgtvLoopVideoView.this.getDLSpeedFormat());
                                        i = 701;
                                        break;
                                    case 702:
                                        String logTag6 = MgtvLoopVideoView.this.getLogTag();
                                        DebugLog.w(logTag6, "buffer end speed:" + MgtvLoopVideoView.this.getDLSpeedFormat());
                                        i = 702;
                                        break;
                                    default:
                                        switch (i) {
                                            case 800:
                                                String logTag7 = MgtvLoopVideoView.this.getLogTag();
                                                DebugLog.e(logTag7, "Bad interleaving of media file, audio/video are not well-formed, extra is " + i2);
                                                i = 800;
                                                break;
                                            case 801:
                                                String logTag8 = MgtvLoopVideoView.this.getLogTag();
                                                DebugLog.w(logTag8, "The stream not seekable status, extra is " + i2);
                                                i = 801;
                                                MgtvLoopVideoView mgtvLoopVideoView4 = MgtvLoopVideoView.this;
                                                if (i2 != 1) {
                                                    mgtvLoopVideoView4.mIsLive = false;
                                                    logTag = MgtvLoopVideoView.this.getLogTag();
                                                    str2 = "The stream is not live stream,can seekable ";
                                                    break;
                                                } else {
                                                    mgtvLoopVideoView4.mIsLive = true;
                                                    logTag = MgtvLoopVideoView.this.getLogTag();
                                                    str2 = "The stream is live stream,can not seekable ";
                                                    break;
                                                }
                                            case 802:
                                                String logTag9 = MgtvLoopVideoView.this.getLogTag();
                                                DebugLog.w(logTag9, "A new set of metadata is available, extra is " + i2);
                                                i = 802;
                                                break;
                                            default:
                                                logTag = MgtvLoopVideoView.this.getLogTag();
                                                switch (i) {
                                                    case MgtvMediaPlayer.MEDIA_INFO_DATA_PROTOCOL /* 2803 */:
                                                        DebugLog.w(logTag, "data source type is " + i2);
                                                        MgtvLoopVideoView mgtvLoopVideoView5 = MgtvLoopVideoView.this;
                                                        MgtvMediaPlayer mgtvMediaPlayer = mgtvLoopVideoView5.mMediaPlayer;
                                                        if (mgtvMediaPlayer != null) {
                                                            mgtvLoopVideoView5.mDataSourceType = mgtvMediaPlayer.getDataSourceType();
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
                        DebugLog.w(logTag, str2);
                    }
                    sb.append(str);
                    sb.append(i2);
                    str2 = sb.toString();
                    DebugLog.w(logTag, str2);
                } else {
                    String logTag10 = MgtvLoopVideoView.this.getLogTag();
                    DebugLog.w(logTag10, "Unknown info, extra is " + i2);
                    i = 1;
                }
                if (MgtvLoopVideoView.this.mOnInfoListener != null) {
                    MgtvLoopVideoView.this.mOnInfoListener.onInfo(i, i2);
                }
                return true;
            }
        };
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.8
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i, int i2) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.w(logTag, "onError what:" + i + ",extra:" + i2);
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvLoopVideoView.mMediaPlayer;
                if (mgtvMediaPlayer == null || i != 7000006) {
                    if (mgtvMediaPlayer != null && mgtvLoopVideoView.mCurrentState != -1) {
                        MgtvLoopVideoView.this.mMediaPlayer.stop();
                    }
                    MgtvLoopVideoView.this.changeCurrentState(-1);
                    MgtvLoopVideoView.this.mTargetState = -1;
                } else {
                    mgtvLoopVideoView.releaseNoStatus();
                    MgtvLoopVideoView.this.changeCurrentState(0);
                    MgtvLoopVideoView.this.mTargetState = 0;
                }
                MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                mgtvLoopVideoView2.mCurrentUri = null;
                mgtvLoopVideoView2.mProxyUri = null;
                return mgtvLoopVideoView2.mOnErrorListener != null && MgtvLoopVideoView.this.mOnErrorListener.onError(i, i2);
            }
        };
        this.mSeekCompleteListener = new MgtvPlayerListener.OnSeekCompleteListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.9
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSeekCompleteListener
            public void onSeekComplete(int i, int i2) {
                if (MgtvLoopVideoView.this.mOnSeekCompleteListener != null) {
                    String logTag = MgtvLoopVideoView.this.getLogTag();
                    DebugLog.i(logTag, "onSeekComplete seekTargetTime:" + i + ",errorCode:" + i2);
                    MgtvLoopVideoView.this.mOnSeekCompleteListener.onSeekComplete();
                }
            }
        };
        this.mBufferingUpdateListener = new MgtvPlayerListener.OnBufferingUpdateListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.10
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingUpdateListener
            public void onBufferingUpdate(int i) {
                if (MgtvLoopVideoView.this.mOnBufferringUpdateListener != null) {
                    MgtvLoopVideoView.this.mOnBufferringUpdateListener.onBufferingUpdate(i);
                }
            }
        };
        this.mBufferingTimeoutListener = new MgtvPlayerListener.OnBufferingTimeoutListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.11
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingTimeoutListener
            public boolean onBufferingTimeout(int i, int i2) {
                MgtvMediaPlayer mgtvMediaPlayer = MgtvLoopVideoView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.stop();
                }
                MgtvLoopVideoView.this.changeCurrentState(-1);
                MgtvLoopVideoView.this.mTargetState = -1;
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                mgtvLoopVideoView.mCurrentUri = null;
                mgtvLoopVideoView.mProxyUri = null;
                if (mgtvLoopVideoView.mOnErrorListener == null || MgtvLoopVideoView.this.mOnErrorListener.onError(i, i2)) {
                }
                return true;
            }
        };
        this.mSwitchSourceListener = new MgtvPlayerListener.OnSwitchSourceListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.12
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceComplete(String str, int i, int i2) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceComplete url:" + str + ",type:" + i + ",time:" + i2);
                if (MgtvLoopVideoView.this.mOnChangeSourceListener != null) {
                    MgtvLoopVideoView.this.mOnChangeSourceListener.onChangeSourceSuccess(str, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceFailed(String str, int i, int i2) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceFailed url:" + str + ",what:" + i + ",extra:" + i2);
                if (MgtvLoopVideoView.this.mOnChangeSourceListener != null) {
                    MgtvLoopVideoView.this.mOnChangeSourceListener.onChangeSourceFailed(str, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceInfo(String str, int i, int i2) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceInfo url:" + str + ",event:" + i + ",time:" + i2);
                if (MgtvLoopVideoView.this.mOnChangeSourceListener != null) {
                    MgtvLoopVideoView.this.mOnChangeSourceListener.onChangeSourceInfo(str, i, i2);
                }
            }
        };
        this.mPlayerWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.13
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i, int i2) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "onTsSkip tsUrl:" + str);
                if (MgtvLoopVideoView.this.mOnWarningListener != null) {
                    MgtvLoopVideoView.this.mOnWarningListener.onTsSkip(str, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i, String str, String str2, Object obj) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "player render warning:" + i + ",extra:" + str + ",msg:" + str2);
                if (MgtvLoopVideoView.this.mOnWarningListener != null) {
                    MgtvLoopVideoView.this.mOnWarningListener.onWarning(i, str, str2, obj);
                }
            }
        };
        this.mGifRecorder = new GifRecorder();
        this.mStartListener = new MgtvPlayerListener.OnStartListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.14
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnStartListener
            public void onStart() {
                DebugLog.d(MgtvLoopVideoView.this.getLogTag(), "mgtvcore onStart");
                if (MgtvLoopVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvLoopVideoView.this.callbackOnStart();
                }
            }
        };
        this.mPauseListener = new MgtvPlayerListener.OnPauseListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.15
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPauseListener
            public void onPause() {
                DebugLog.d(MgtvLoopVideoView.this.getLogTag(), "mgtvcore onPause");
                if (MgtvLoopVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvLoopVideoView.this.callbackOnPause();
                }
            }
        };
        this.mRecordVideoListener = new MgtvPlayerListener.OnRecordVideoListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.16
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoErr(int i, int i2) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.e(logTag, "onRecordVideoErr what:" + i + ",extra:" + i2);
                if (MgtvLoopVideoView.this.mOnRecordListener != null) {
                    MgtvLoopVideoView.this.mOnRecordListener.onRecordError(i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoInfo(int i, int i2) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "onRecordVideoInfo what:" + i + ",extra:" + i2);
                if (MgtvLoopVideoView.this.mOnRecordListener != null) {
                    if (i == 20) {
                        MgtvLoopVideoView.this.mOnRecordListener.onRecordStart(MgtvLoopVideoView.this.mRecordFilePath);
                    } else if (i == 30) {
                        MgtvLoopVideoView.this.mOnRecordListener.onRecordStop();
                    }
                    MgtvLoopVideoView.this.mOnRecordListener.onRecordInfo(i, i2);
                }
            }
        };
        this.mLoadDataListener = new MgtvPlayerListener.OnLoadDataListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.17
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onAfterLoadDataPaused() {
                if (MgtvLoopVideoView.this.mOnLoadDataListener != null) {
                    MgtvLoopVideoView.this.mOnLoadDataListener.onAfterLoadDataPaused();
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onBeforeLoadDataResume() {
                if (MgtvLoopVideoView.this.mOnLoadDataListener != null) {
                    MgtvLoopVideoView.this.mOnLoadDataListener.onBeforeLoadDataResume();
                }
            }
        };
        initVideoView(context);
    }

    public MgtvLoopVideoView(Context context, AttributeSet attributeSet, int i) {
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
        this.mIsDataLoaderPaused = false;
        this.mUseSystemPlayer = false;
        this.mAddrInfoType = MgtvMediaPlayer.AddrinfoType.TYPE_ADDRINFO_DEFAULT;
        this.mAddrInfoTypeInt = 0;
        this.mJavaDnsType = a.d.a;
        this.mNativeDnsAsyncEnable = true;
        this.mEnableMgtvMediaCodec = false;
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
        this.mTargetIsLoopMode = false;
        this.mIsLoopMode = false;
        this.mStartPosMs = 0;
        this.mNeedResetLoopPlay = false;
        this.mFlowDataStatistic = new FlowDataStatistic();
        this.mSkipLoopFilterType = MgtvMediaPlayer.SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mSHCallback = new IMgtvRenderView.IRenderCallback() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.1
            private void bindHolder(IMgtvRenderView.ISurfaceHolder iSurfaceHolder) {
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                if (mgtvLoopVideoView.mMediaPlayer == null) {
                    mgtvLoopVideoView.openVideo();
                    return;
                }
                if (mgtvLoopVideoView.mHasSurfaceHolderDestroy && mgtvLoopVideoView.mRebindTexture) {
                    MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                    if (mgtvLoopVideoView2.mCurrentUri != null) {
                        mgtvLoopVideoView2.setStartPosMs(mgtvLoopVideoView2.mMediaPlayer.getCurrentPosition());
                        MgtvLoopVideoView.this.openVideo();
                    }
                }
                if (!needOpenVideo()) {
                    MgtvLoopVideoView.this.mMediaPlayer.setSurfaceHolder(iSurfaceHolder);
                    MgtvLoopVideoView mgtvLoopVideoView3 = MgtvLoopVideoView.this;
                    if (mgtvLoopVideoView3.mNeedResetLoopPlay) {
                        mgtvLoopVideoView3.resetVideoPath();
                    } else if (!mgtvLoopVideoView3.mFromSurfaceDestroyToPlay || mgtvLoopVideoView3.mCurrentUri == null) {
                        if (mgtvLoopVideoView3.mLastFrameRecovery && (!MgtvLoopVideoView.this.isHardware() || MgtvLoopVideoView.this.mLastSurfaceDestroy)) {
                            MgtvLoopVideoView.this.mMediaPlayer.setPlaybackStep();
                        }
                    } else if (mgtvLoopVideoView3.mMgtvMediaPlayerHardwareMode) {
                        MgtvLoopVideoView mgtvLoopVideoView4 = MgtvLoopVideoView.this;
                        mgtvLoopVideoView4.mFromSurfaceDestroyToPlay = false;
                        if (!mgtvLoopVideoView4.mIsLoopMode) {
                            mgtvLoopVideoView4.mMediaPlayer.seekTo(mgtvLoopVideoView4.mFromSurfaceDestroyPlayPosition, false, true);
                        }
                        MgtvLoopVideoView.this.mFromSurfaceDestroyPlayPosition = 0;
                    }
                    MgtvLoopVideoView mgtvLoopVideoView5 = MgtvLoopVideoView.this;
                    mgtvLoopVideoView5.mSizeChangedListener.onVideoSizeChanged(mgtvLoopVideoView5.mMediaPlayer.getVideoWidth(), MgtvLoopVideoView.this.mMediaPlayer.getVideoHeight());
                    return;
                }
                MgtvLoopVideoView.this.openVideo();
            }

            private boolean needOpenVideo() {
                return MgtvLoopVideoView.this.mOpenVideoWhenSurfaceCreate && MgtvLoopVideoView.this.mCurrentUri != null;
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceChanged(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22, int i3) {
                DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "-----------surface changed");
                if (iSurfaceHolder.getRenderView() != MgtvLoopVideoView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                MgtvLoopVideoView.this.mSurfaceWidth = i22;
                MgtvLoopVideoView.this.mSurfaceHeight = i3;
                boolean z = true;
                boolean z2 = MgtvLoopVideoView.this.mTargetState == 3;
                if (MgtvLoopVideoView.this.mRenderView.shouldWaitForResize() && (MgtvLoopVideoView.this.mVideoWidth != i22 || MgtvLoopVideoView.this.mVideoHeight != i3)) {
                    z = false;
                }
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                if (mgtvLoopVideoView.mMediaPlayer != null && z2 && z) {
                    if (!mgtvLoopVideoView.mIsLoopMode && mgtvLoopVideoView.mSeekWhenPrepared != 0) {
                        MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                        mgtvLoopVideoView2.seekTo(mgtvLoopVideoView2.mSeekWhenPrepared, false);
                    }
                    MgtvLoopVideoView.this.start();
                }
                if (MgtvLoopVideoView.this.mSurfaceHolderListener != null) {
                    MgtvLoopVideoView.this.mSurfaceHolderListener.surfaceChanged();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceCreated(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22) {
                SurfaceHolder surfaceHolder;
                if (MgtvLoopVideoView.this.mStartLeaveTimestamp > 0) {
                    long currentTimeMillis = (System.currentTimeMillis() - MgtvLoopVideoView.this.mStartLeaveTimestamp) / 1000;
                    if (currentTimeMillis > 540) {
                        if (MgtvLoopVideoView.this.mOnWarningListener != null) {
                            MgtvPlayerListener.OnWarningListener onWarningListener = MgtvLoopVideoView.this.mOnWarningListener;
                            onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_LEAVE_TIME_INVALID, MgtvLoopVideoView.this.mCurrentState + "", "", null);
                        }
                        ReportParams reportParams = MgtvLoopVideoView.this.mReportParams;
                        if (reportParams != null) {
                            reportParams.setLeaveTimeS(currentTimeMillis);
                        }
                    }
                }
                DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "-----------surface create");
                MgtvMediaPlayer mgtvMediaPlayer = MgtvLoopVideoView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null && mgtvMediaPlayer.isLoadDataPaused()) {
                    DebugLog.i(MgtvLoopVideoView.this.getLogTag(), "bindHolder resumeLoadData");
                    MgtvLoopVideoView.this.mMediaPlayer.resumeLoadData();
                }
                if (iSurfaceHolder.getRenderView() != MgtvLoopVideoView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "onSurfaceCreated " + iSurfaceHolder);
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                mgtvLoopVideoView.mSurfaceHolder = iSurfaceHolder;
                if (mgtvLoopVideoView.mRenderView.getRenderViewType() == 0 && ((surfaceHolder = MgtvLoopVideoView.this.mSurfaceHolder.getSurfaceHolder()) == null || surfaceHolder.getSurface() == null || !surfaceHolder.getSurface().isValid())) {
                    MgtvLoopVideoView.this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SURFACE_FAILED, 1);
                    MgtvLoopVideoView.this.mErrorMsg = "surfaceCreated surface is invalid";
                } else {
                    bindHolder(iSurfaceHolder);
                }
                if (MgtvLoopVideoView.this.mSurfaceHolderListener != null) {
                    MgtvLoopVideoView.this.mSurfaceHolderListener.surfaceCreated();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceDestroyed(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, boolean z) {
                MgtvLoopVideoView.this.mLastSurfaceDestroy = z;
                if (iSurfaceHolder.getRenderView() != MgtvLoopVideoView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "onSurfaceDestroyed: unmatched render callback\n");
                    return;
                }
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "onSurfaceDestroyed " + iSurfaceHolder);
                if (MgtvLoopVideoView.this.mSurfaceHolderListener != null) {
                    MgtvLoopVideoView.this.mSurfaceHolderListener.surfaceDestroyed();
                }
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                mgtvLoopVideoView.mSurfaceHolder = null;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvLoopVideoView.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.setSurfaceHolder(null);
                    if (MgtvLoopVideoView.this.isPrepared()) {
                        MgtvLoopVideoView.this.pauseLoadData();
                        if (MgtvLoopVideoView.this.mIsLive) {
                            DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "-----------surface destroy to pause");
                        } else {
                            DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "-----------surface destroy to pause");
                            if (MgtvLoopVideoView.this.mRenderView.getRenderViewType() == 0) {
                                if (!MgtvLoopVideoView.this.mMediaPlayer.isSupportAMCKeyFrameBackup()) {
                                    MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                                    mgtvLoopVideoView2.mFromSurfaceDestroyToPlay = true;
                                    mgtvLoopVideoView2.mFromSurfaceDestroyPlayPosition = mgtvLoopVideoView2.mMediaPlayer.getCurrentPosition();
                                }
                            } else if (MgtvLoopVideoView.this.mRenderView.getRenderViewType() == 1) {
                                if (!MgtvLoopVideoView.this.isHardware()) {
                                    MgtvLoopVideoView.this.mFromSurfaceDestroyToPlay = true;
                                }
                                MgtvLoopVideoView mgtvLoopVideoView3 = MgtvLoopVideoView.this;
                                if (!mgtvLoopVideoView3.mIsLoopMode && mgtvLoopVideoView3.mEnableTexture) {
                                    mgtvLoopVideoView3.mHasSurfaceHolderDestroy = true;
                                }
                            }
                        }
                        MgtvLoopVideoView.this.pauseInner();
                    } else {
                        try {
                            ReportParams reportParams = MgtvLoopVideoView.this.mReportParams;
                            if (reportParams != null) {
                                reportParams.getEnd().setInnerRetry(true);
                            }
                            MgtvLoopVideoView.this.release(true, true);
                        } catch (Exception unused) {
                        }
                    }
                    MgtvLoopVideoView mgtvLoopVideoView4 = MgtvLoopVideoView.this;
                    if (mgtvLoopVideoView4.mCurrentUri == null || mgtvLoopVideoView4.mCurrentState == -1 || MgtvLoopVideoView.this.mCurrentState == 5) {
                        return;
                    }
                    MgtvLoopVideoView.this.mStartLeaveTimestamp = System.currentTimeMillis();
                }
            }
        };
        this.mFilterCallback = new f.a() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.2
            public void onInfo(int i2, int i22, String str) {
                if (i2 == 1) {
                    MgtvLoopVideoView.this.mRenderType = i22;
                    MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                    ReportParams reportParams = mgtvLoopVideoView.mReportParams;
                    if (reportParams != null) {
                        reportParams.setRenderType(mgtvLoopVideoView.mRenderType);
                    }
                } else if (i2 != 3) {
                } else {
                    MgtvLoopVideoView.this.mEnhanceQualityType = i22;
                    MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                    ReportParams reportParams2 = mgtvLoopVideoView2.mReportParams;
                    if (reportParams2 != null) {
                        reportParams2.setEnhanceQualityType(mgtvLoopVideoView2.mEnhanceQualityType);
                    }
                }
            }
        };
        this.mRenderWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "opengl render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvLoopVideoView.this.mOnWarningListener != null) {
                    MgtvLoopVideoView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mSizeChangedListener = new MgtvPlayerListener.OnVideoSizeChangedListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i2, int i22) {
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                mgtvLoopVideoView.originalVideoWidth = mgtvLoopVideoView.mVideoWidth = mgtvLoopVideoView.mMediaPlayer.getVideoWidth();
                MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                mgtvLoopVideoView2.originalVideoHeight = mgtvLoopVideoView2.mVideoHeight = mgtvLoopVideoView2.mMediaPlayer.getVideoHeight();
                if (MgtvLoopVideoView.this.mVideoWidth != 0 && MgtvLoopVideoView.this.mVideoHeight != 0) {
                    MgtvLoopVideoView mgtvLoopVideoView3 = MgtvLoopVideoView.this;
                    MgtvRenderView mgtvRenderView = mgtvLoopVideoView3.mRenderView;
                    if (mgtvRenderView != null) {
                        mgtvRenderView.setVideoSize(mgtvLoopVideoView3.mVideoWidth, MgtvLoopVideoView.this.mVideoHeight);
                    }
                    MgtvLoopVideoView.this.requestLayout();
                }
                if (MgtvLoopVideoView.this.mOnVideoSizeChangedListener != null) {
                    MgtvLoopVideoView.this.mOnVideoSizeChangedListener.onVideoSizeChanged(i2, i22);
                }
            }
        };
        this.mPreparedListener = new MgtvPlayerListener.OnPreparedListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.5
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPreparedListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPrepared() {
                /*
                    r4 = this;
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    r1 = 2
                    com.hunantv.media.widget.MgtvLoopVideoView.access$2800(r0, r1)
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoWidth()
                    int r1 = com.hunantv.media.widget.MgtvLoopVideoView.access$302(r0, r1)
                    com.hunantv.media.widget.MgtvLoopVideoView.access$2502(r0, r1)
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoHeight()
                    int r1 = com.hunantv.media.widget.MgtvLoopVideoView.access$402(r0, r1)
                    com.hunantv.media.widget.MgtvLoopVideoView.access$2602(r0, r1)
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$300(r0)
                    r1 = 3
                    if (r0 == 0) goto Lae
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$400(r0)
                    if (r0 == 0) goto Lae
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "video size: "
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvLoopVideoView r2 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r2 = com.hunantv.media.widget.MgtvLoopVideoView.access$300(r2)
                    r0.append(r2)
                    java.lang.String r2 = "/"
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvLoopVideoView r2 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r2 = com.hunantv.media.widget.MgtvLoopVideoView.access$400(r2)
                    r0.append(r2)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r2 = "@@@@"
                    com.hunantv.media.player.pragma.DebugLog.i(r2, r0)
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.player.MgtvRenderView r2 = r0.mRenderView
                    if (r2 == 0) goto L72
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$300(r0)
                    com.hunantv.media.widget.MgtvLoopVideoView r3 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r3 = com.hunantv.media.widget.MgtvLoopVideoView.access$400(r3)
                    r2.setVideoSize(r0, r3)
                L72:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$500(r0)
                    if (r0 == 0) goto L7f
                    com.hunantv.media.widget.MgtvLoopVideoView r2 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    r2.seekTo(r0)
                L7f:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.player.MgtvRenderView r0 = r0.mRenderView
                    boolean r0 = r0.shouldWaitForResize()
                    if (r0 == 0) goto La5
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$000(r0)
                    com.hunantv.media.widget.MgtvLoopVideoView r2 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r2 = com.hunantv.media.widget.MgtvLoopVideoView.access$300(r2)
                    if (r0 != r2) goto Lbb
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$100(r0)
                    com.hunantv.media.widget.MgtvLoopVideoView r2 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r2 = com.hunantv.media.widget.MgtvLoopVideoView.access$400(r2)
                    if (r0 != r2) goto Lbb
                La5:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$200(r0)
                    if (r0 != r1) goto Lbb
                    goto Lb6
                Lae:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$200(r0)
                    if (r0 != r1) goto Lbb
                Lb6:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    r0.start()
                Lbb:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$2900(r0)
                    if (r0 == 0) goto Lcc
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$2900(r0)
                    r0.onPrepared()
                Lcc:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvLoopVideoView.AnonymousClass5.onPrepared():void");
            }
        };
        this.mCompletionListener = new MgtvPlayerListener.OnCompletionListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.6
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnCompletionListener
            public void onCompletion(int i2, int i22) {
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                if (i2 != 0) {
                    mgtvLoopVideoView.changeCurrentState(0);
                    MgtvLoopVideoView.this.mTargetState = 0;
                    MgtvLoopVideoView.this.stopInner();
                } else {
                    mgtvLoopVideoView.changeCurrentState(5);
                    MgtvLoopVideoView.this.mTargetState = 5;
                }
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "-------------on onCompletion what:" + i2 + ",extra:" + i22);
                if (MgtvLoopVideoView.this.mOnCompletionListener != null) {
                    MgtvLoopVideoView.this.mOnCompletionListener.onCompletion(i2, i22);
                }
            }
        };
        this.mInfoListener = new MgtvPlayerListener.OnInfoListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.7
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
                        logTag = MgtvLoopVideoView.this.getLogTag();
                        sb = new StringBuilder();
                        str = "video fps is ";
                    } else if (i2 == 2820) {
                        logTag = MgtvLoopVideoView.this.getLogTag();
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
                        String logTag2 = MgtvLoopVideoView.this.getLogTag();
                        DebugLog.i(logTag2, "MEDIA_INFO_PLAYBACK_STATE_CHANGED:" + i22);
                        if (MgtvLoopVideoView.this.mOnUpdateStatusListener != null) {
                            MgtvLoopVideoView.this.mOnUpdateStatusListener.onUpdateStatus();
                        }
                    } else if (i2 == 10001) {
                        String logTag3 = MgtvLoopVideoView.this.getLogTag();
                        DebugLog.w(logTag3, "video rotation changed,extra(degree) is " + i22);
                        MgtvLoopVideoView.this.mVideoRotationDegree = i22;
                        MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                        MgtvRenderView mgtvRenderView = mgtvLoopVideoView.mRenderView;
                        if (mgtvRenderView != null) {
                            mgtvRenderView.setVideoRotation(mgtvLoopVideoView.mVideoRotationDegree);
                        }
                    } else if (i2 == 200001) {
                        MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                        if (i22 == 1) {
                            mgtvLoopVideoView2.mMgtvMediaPlayerHardwareMode = false;
                        } else {
                            mgtvLoopVideoView2.mMgtvMediaPlayerHardwareMode = true;
                        }
                        MgtvLoopVideoView mgtvLoopVideoView3 = MgtvLoopVideoView.this;
                        mgtvLoopVideoView3.convertRender(mgtvLoopVideoView3.mRenderViewType);
                    } else if (i2 == 3) {
                        DebugLog.w(MgtvLoopVideoView.this.getLogTag(), "msg coming: video decode succeeded");
                        MgtvLoopVideoView.this.onVideoRenderStart();
                        if (MgtvLoopVideoView.this.mOnInfoListener != null) {
                            DebugLog.i(MgtvLoopVideoView.this.getLogTag(), "video decode succeeded, start rendering");
                            MgtvLoopVideoView.this.mOnInfoListener.onInfo(900, i22);
                        }
                        return true;
                    } else {
                        if (i2 == 4) {
                            logTag = MgtvLoopVideoView.this.getLogTag();
                            str2 = "audio decode succeeded, start rendering";
                        } else if (i2 != 5) {
                            if (i2 == 6) {
                                if (i22 == 0) {
                                    MgtvLoopVideoView.this.mMgtvMediaPlayerHardwareMode = false;
                                } else if (i22 == 1) {
                                    MgtvLoopVideoView.this.mMgtvMediaPlayerHardwareMode = true;
                                }
                                logTag = MgtvLoopVideoView.this.getLogTag();
                                sb = new StringBuilder();
                                str = "video decoder open,extra is ";
                            } else if (i2 != 7) {
                                switch (i2) {
                                    case 700:
                                        String logTag4 = MgtvLoopVideoView.this.getLogTag();
                                        DebugLog.w(logTag4, "It's too complex for the decoder, extra is " + i22);
                                        i2 = 700;
                                        break;
                                    case 701:
                                        String logTag5 = MgtvLoopVideoView.this.getLogTag();
                                        DebugLog.w(logTag5, "buffer start speed:" + MgtvLoopVideoView.this.getDLSpeedFormat());
                                        i2 = 701;
                                        break;
                                    case 702:
                                        String logTag6 = MgtvLoopVideoView.this.getLogTag();
                                        DebugLog.w(logTag6, "buffer end speed:" + MgtvLoopVideoView.this.getDLSpeedFormat());
                                        i2 = 702;
                                        break;
                                    default:
                                        switch (i2) {
                                            case 800:
                                                String logTag7 = MgtvLoopVideoView.this.getLogTag();
                                                DebugLog.e(logTag7, "Bad interleaving of media file, audio/video are not well-formed, extra is " + i22);
                                                i2 = 800;
                                                break;
                                            case 801:
                                                String logTag8 = MgtvLoopVideoView.this.getLogTag();
                                                DebugLog.w(logTag8, "The stream not seekable status, extra is " + i22);
                                                i2 = 801;
                                                MgtvLoopVideoView mgtvLoopVideoView4 = MgtvLoopVideoView.this;
                                                if (i22 != 1) {
                                                    mgtvLoopVideoView4.mIsLive = false;
                                                    logTag = MgtvLoopVideoView.this.getLogTag();
                                                    str2 = "The stream is not live stream,can seekable ";
                                                    break;
                                                } else {
                                                    mgtvLoopVideoView4.mIsLive = true;
                                                    logTag = MgtvLoopVideoView.this.getLogTag();
                                                    str2 = "The stream is live stream,can not seekable ";
                                                    break;
                                                }
                                            case 802:
                                                String logTag9 = MgtvLoopVideoView.this.getLogTag();
                                                DebugLog.w(logTag9, "A new set of metadata is available, extra is " + i22);
                                                i2 = 802;
                                                break;
                                            default:
                                                logTag = MgtvLoopVideoView.this.getLogTag();
                                                switch (i2) {
                                                    case MgtvMediaPlayer.MEDIA_INFO_DATA_PROTOCOL /* 2803 */:
                                                        DebugLog.w(logTag, "data source type is " + i22);
                                                        MgtvLoopVideoView mgtvLoopVideoView5 = MgtvLoopVideoView.this;
                                                        MgtvMediaPlayer mgtvMediaPlayer = mgtvLoopVideoView5.mMediaPlayer;
                                                        if (mgtvMediaPlayer != null) {
                                                            mgtvLoopVideoView5.mDataSourceType = mgtvMediaPlayer.getDataSourceType();
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
                        DebugLog.w(logTag, str2);
                    }
                    sb.append(str);
                    sb.append(i22);
                    str2 = sb.toString();
                    DebugLog.w(logTag, str2);
                } else {
                    String logTag10 = MgtvLoopVideoView.this.getLogTag();
                    DebugLog.w(logTag10, "Unknown info, extra is " + i22);
                    i2 = 1;
                }
                if (MgtvLoopVideoView.this.mOnInfoListener != null) {
                    MgtvLoopVideoView.this.mOnInfoListener.onInfo(i2, i22);
                }
                return true;
            }
        };
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.8
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i2, int i22) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.w(logTag, "onError what:" + i2 + ",extra:" + i22);
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvLoopVideoView.mMediaPlayer;
                if (mgtvMediaPlayer == null || i2 != 7000006) {
                    if (mgtvMediaPlayer != null && mgtvLoopVideoView.mCurrentState != -1) {
                        MgtvLoopVideoView.this.mMediaPlayer.stop();
                    }
                    MgtvLoopVideoView.this.changeCurrentState(-1);
                    MgtvLoopVideoView.this.mTargetState = -1;
                } else {
                    mgtvLoopVideoView.releaseNoStatus();
                    MgtvLoopVideoView.this.changeCurrentState(0);
                    MgtvLoopVideoView.this.mTargetState = 0;
                }
                MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                mgtvLoopVideoView2.mCurrentUri = null;
                mgtvLoopVideoView2.mProxyUri = null;
                return mgtvLoopVideoView2.mOnErrorListener != null && MgtvLoopVideoView.this.mOnErrorListener.onError(i2, i22);
            }
        };
        this.mSeekCompleteListener = new MgtvPlayerListener.OnSeekCompleteListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.9
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSeekCompleteListener
            public void onSeekComplete(int i2, int i22) {
                if (MgtvLoopVideoView.this.mOnSeekCompleteListener != null) {
                    String logTag = MgtvLoopVideoView.this.getLogTag();
                    DebugLog.i(logTag, "onSeekComplete seekTargetTime:" + i2 + ",errorCode:" + i22);
                    MgtvLoopVideoView.this.mOnSeekCompleteListener.onSeekComplete();
                }
            }
        };
        this.mBufferingUpdateListener = new MgtvPlayerListener.OnBufferingUpdateListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.10
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingUpdateListener
            public void onBufferingUpdate(int i2) {
                if (MgtvLoopVideoView.this.mOnBufferringUpdateListener != null) {
                    MgtvLoopVideoView.this.mOnBufferringUpdateListener.onBufferingUpdate(i2);
                }
            }
        };
        this.mBufferingTimeoutListener = new MgtvPlayerListener.OnBufferingTimeoutListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.11
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingTimeoutListener
            public boolean onBufferingTimeout(int i2, int i22) {
                MgtvMediaPlayer mgtvMediaPlayer = MgtvLoopVideoView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.stop();
                }
                MgtvLoopVideoView.this.changeCurrentState(-1);
                MgtvLoopVideoView.this.mTargetState = -1;
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                mgtvLoopVideoView.mCurrentUri = null;
                mgtvLoopVideoView.mProxyUri = null;
                if (mgtvLoopVideoView.mOnErrorListener == null || MgtvLoopVideoView.this.mOnErrorListener.onError(i2, i22)) {
                }
                return true;
            }
        };
        this.mSwitchSourceListener = new MgtvPlayerListener.OnSwitchSourceListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.12
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceComplete(String str, int i2, int i22) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceComplete url:" + str + ",type:" + i2 + ",time:" + i22);
                if (MgtvLoopVideoView.this.mOnChangeSourceListener != null) {
                    MgtvLoopVideoView.this.mOnChangeSourceListener.onChangeSourceSuccess(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceFailed(String str, int i2, int i22) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceFailed url:" + str + ",what:" + i2 + ",extra:" + i22);
                if (MgtvLoopVideoView.this.mOnChangeSourceListener != null) {
                    MgtvLoopVideoView.this.mOnChangeSourceListener.onChangeSourceFailed(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceInfo(String str, int i2, int i22) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceInfo url:" + str + ",event:" + i2 + ",time:" + i22);
                if (MgtvLoopVideoView.this.mOnChangeSourceListener != null) {
                    MgtvLoopVideoView.this.mOnChangeSourceListener.onChangeSourceInfo(str, i2, i22);
                }
            }
        };
        this.mPlayerWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.13
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "onTsSkip tsUrl:" + str);
                if (MgtvLoopVideoView.this.mOnWarningListener != null) {
                    MgtvLoopVideoView.this.mOnWarningListener.onTsSkip(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "player render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvLoopVideoView.this.mOnWarningListener != null) {
                    MgtvLoopVideoView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mGifRecorder = new GifRecorder();
        this.mStartListener = new MgtvPlayerListener.OnStartListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.14
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnStartListener
            public void onStart() {
                DebugLog.d(MgtvLoopVideoView.this.getLogTag(), "mgtvcore onStart");
                if (MgtvLoopVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvLoopVideoView.this.callbackOnStart();
                }
            }
        };
        this.mPauseListener = new MgtvPlayerListener.OnPauseListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.15
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPauseListener
            public void onPause() {
                DebugLog.d(MgtvLoopVideoView.this.getLogTag(), "mgtvcore onPause");
                if (MgtvLoopVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvLoopVideoView.this.callbackOnPause();
                }
            }
        };
        this.mRecordVideoListener = new MgtvPlayerListener.OnRecordVideoListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.16
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoErr(int i2, int i22) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.e(logTag, "onRecordVideoErr what:" + i2 + ",extra:" + i22);
                if (MgtvLoopVideoView.this.mOnRecordListener != null) {
                    MgtvLoopVideoView.this.mOnRecordListener.onRecordError(i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoInfo(int i2, int i22) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "onRecordVideoInfo what:" + i2 + ",extra:" + i22);
                if (MgtvLoopVideoView.this.mOnRecordListener != null) {
                    if (i2 == 20) {
                        MgtvLoopVideoView.this.mOnRecordListener.onRecordStart(MgtvLoopVideoView.this.mRecordFilePath);
                    } else if (i2 == 30) {
                        MgtvLoopVideoView.this.mOnRecordListener.onRecordStop();
                    }
                    MgtvLoopVideoView.this.mOnRecordListener.onRecordInfo(i2, i22);
                }
            }
        };
        this.mLoadDataListener = new MgtvPlayerListener.OnLoadDataListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.17
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onAfterLoadDataPaused() {
                if (MgtvLoopVideoView.this.mOnLoadDataListener != null) {
                    MgtvLoopVideoView.this.mOnLoadDataListener.onAfterLoadDataPaused();
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onBeforeLoadDataResume() {
                if (MgtvLoopVideoView.this.mOnLoadDataListener != null) {
                    MgtvLoopVideoView.this.mOnLoadDataListener.onBeforeLoadDataResume();
                }
            }
        };
        initVideoView(context);
    }

    public MgtvLoopVideoView(Context context, IVideoView.Configuration configuration) {
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
        this.mIsDataLoaderPaused = false;
        this.mUseSystemPlayer = false;
        this.mAddrInfoType = MgtvMediaPlayer.AddrinfoType.TYPE_ADDRINFO_DEFAULT;
        this.mAddrInfoTypeInt = 0;
        this.mJavaDnsType = a.d.a;
        this.mNativeDnsAsyncEnable = true;
        this.mEnableMgtvMediaCodec = false;
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
        this.mTargetIsLoopMode = false;
        this.mIsLoopMode = false;
        this.mStartPosMs = 0;
        this.mNeedResetLoopPlay = false;
        this.mFlowDataStatistic = new FlowDataStatistic();
        this.mSkipLoopFilterType = MgtvMediaPlayer.SkipLoopFilterType.TYPE_SKIPLOOPFILTER_ALL;
        this.mSHCallback = new IMgtvRenderView.IRenderCallback() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.1
            private void bindHolder(IMgtvRenderView.ISurfaceHolder iSurfaceHolder) {
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                if (mgtvLoopVideoView.mMediaPlayer == null) {
                    mgtvLoopVideoView.openVideo();
                    return;
                }
                if (mgtvLoopVideoView.mHasSurfaceHolderDestroy && mgtvLoopVideoView.mRebindTexture) {
                    MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                    if (mgtvLoopVideoView2.mCurrentUri != null) {
                        mgtvLoopVideoView2.setStartPosMs(mgtvLoopVideoView2.mMediaPlayer.getCurrentPosition());
                        MgtvLoopVideoView.this.openVideo();
                    }
                }
                if (!needOpenVideo()) {
                    MgtvLoopVideoView.this.mMediaPlayer.setSurfaceHolder(iSurfaceHolder);
                    MgtvLoopVideoView mgtvLoopVideoView3 = MgtvLoopVideoView.this;
                    if (mgtvLoopVideoView3.mNeedResetLoopPlay) {
                        mgtvLoopVideoView3.resetVideoPath();
                    } else if (!mgtvLoopVideoView3.mFromSurfaceDestroyToPlay || mgtvLoopVideoView3.mCurrentUri == null) {
                        if (mgtvLoopVideoView3.mLastFrameRecovery && (!MgtvLoopVideoView.this.isHardware() || MgtvLoopVideoView.this.mLastSurfaceDestroy)) {
                            MgtvLoopVideoView.this.mMediaPlayer.setPlaybackStep();
                        }
                    } else if (mgtvLoopVideoView3.mMgtvMediaPlayerHardwareMode) {
                        MgtvLoopVideoView mgtvLoopVideoView4 = MgtvLoopVideoView.this;
                        mgtvLoopVideoView4.mFromSurfaceDestroyToPlay = false;
                        if (!mgtvLoopVideoView4.mIsLoopMode) {
                            mgtvLoopVideoView4.mMediaPlayer.seekTo(mgtvLoopVideoView4.mFromSurfaceDestroyPlayPosition, false, true);
                        }
                        MgtvLoopVideoView.this.mFromSurfaceDestroyPlayPosition = 0;
                    }
                    MgtvLoopVideoView mgtvLoopVideoView5 = MgtvLoopVideoView.this;
                    mgtvLoopVideoView5.mSizeChangedListener.onVideoSizeChanged(mgtvLoopVideoView5.mMediaPlayer.getVideoWidth(), MgtvLoopVideoView.this.mMediaPlayer.getVideoHeight());
                    return;
                }
                MgtvLoopVideoView.this.openVideo();
            }

            private boolean needOpenVideo() {
                return MgtvLoopVideoView.this.mOpenVideoWhenSurfaceCreate && MgtvLoopVideoView.this.mCurrentUri != null;
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceChanged(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22, int i3) {
                DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "-----------surface changed");
                if (iSurfaceHolder.getRenderView() != MgtvLoopVideoView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                MgtvLoopVideoView.this.mSurfaceWidth = i22;
                MgtvLoopVideoView.this.mSurfaceHeight = i3;
                boolean z = true;
                boolean z2 = MgtvLoopVideoView.this.mTargetState == 3;
                if (MgtvLoopVideoView.this.mRenderView.shouldWaitForResize() && (MgtvLoopVideoView.this.mVideoWidth != i22 || MgtvLoopVideoView.this.mVideoHeight != i3)) {
                    z = false;
                }
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                if (mgtvLoopVideoView.mMediaPlayer != null && z2 && z) {
                    if (!mgtvLoopVideoView.mIsLoopMode && mgtvLoopVideoView.mSeekWhenPrepared != 0) {
                        MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                        mgtvLoopVideoView2.seekTo(mgtvLoopVideoView2.mSeekWhenPrepared, false);
                    }
                    MgtvLoopVideoView.this.start();
                }
                if (MgtvLoopVideoView.this.mSurfaceHolderListener != null) {
                    MgtvLoopVideoView.this.mSurfaceHolderListener.surfaceChanged();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceCreated(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i22) {
                SurfaceHolder surfaceHolder;
                if (MgtvLoopVideoView.this.mStartLeaveTimestamp > 0) {
                    long currentTimeMillis = (System.currentTimeMillis() - MgtvLoopVideoView.this.mStartLeaveTimestamp) / 1000;
                    if (currentTimeMillis > 540) {
                        if (MgtvLoopVideoView.this.mOnWarningListener != null) {
                            MgtvPlayerListener.OnWarningListener onWarningListener = MgtvLoopVideoView.this.mOnWarningListener;
                            onWarningListener.onWarning(MgtvMediaPlayer.MGTVMEDIA_WARNING_LEAVE_TIME_INVALID, MgtvLoopVideoView.this.mCurrentState + "", "", null);
                        }
                        ReportParams reportParams = MgtvLoopVideoView.this.mReportParams;
                        if (reportParams != null) {
                            reportParams.setLeaveTimeS(currentTimeMillis);
                        }
                    }
                }
                DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "-----------surface create");
                MgtvMediaPlayer mgtvMediaPlayer = MgtvLoopVideoView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null && mgtvMediaPlayer.isLoadDataPaused()) {
                    DebugLog.i(MgtvLoopVideoView.this.getLogTag(), "bindHolder resumeLoadData");
                    MgtvLoopVideoView.this.mMediaPlayer.resumeLoadData();
                }
                if (iSurfaceHolder.getRenderView() != MgtvLoopVideoView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "onSurfaceCreated " + iSurfaceHolder);
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                mgtvLoopVideoView.mSurfaceHolder = iSurfaceHolder;
                if (mgtvLoopVideoView.mRenderView.getRenderViewType() == 0 && ((surfaceHolder = MgtvLoopVideoView.this.mSurfaceHolder.getSurfaceHolder()) == null || surfaceHolder.getSurface() == null || !surfaceHolder.getSurface().isValid())) {
                    MgtvLoopVideoView.this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SURFACE_FAILED, 1);
                    MgtvLoopVideoView.this.mErrorMsg = "surfaceCreated surface is invalid";
                } else {
                    bindHolder(iSurfaceHolder);
                }
                if (MgtvLoopVideoView.this.mSurfaceHolderListener != null) {
                    MgtvLoopVideoView.this.mSurfaceHolderListener.surfaceCreated();
                }
            }

            @Override // com.hunantv.media.player.IMgtvRenderView.IRenderCallback
            public void onSurfaceDestroyed(IMgtvRenderView.ISurfaceHolder iSurfaceHolder, boolean z) {
                MgtvLoopVideoView.this.mLastSurfaceDestroy = z;
                if (iSurfaceHolder.getRenderView() != MgtvLoopVideoView.this.mRenderView.getRenderView()) {
                    DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "onSurfaceDestroyed: unmatched render callback\n");
                    return;
                }
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "onSurfaceDestroyed " + iSurfaceHolder);
                if (MgtvLoopVideoView.this.mSurfaceHolderListener != null) {
                    MgtvLoopVideoView.this.mSurfaceHolderListener.surfaceDestroyed();
                }
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                mgtvLoopVideoView.mSurfaceHolder = null;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvLoopVideoView.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.setSurfaceHolder(null);
                    if (MgtvLoopVideoView.this.isPrepared()) {
                        MgtvLoopVideoView.this.pauseLoadData();
                        if (MgtvLoopVideoView.this.mIsLive) {
                            DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "-----------surface destroy to pause");
                        } else {
                            DebugLog.e(MgtvLoopVideoView.this.getLogTag(), "-----------surface destroy to pause");
                            if (MgtvLoopVideoView.this.mRenderView.getRenderViewType() == 0) {
                                if (!MgtvLoopVideoView.this.mMediaPlayer.isSupportAMCKeyFrameBackup()) {
                                    MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                                    mgtvLoopVideoView2.mFromSurfaceDestroyToPlay = true;
                                    mgtvLoopVideoView2.mFromSurfaceDestroyPlayPosition = mgtvLoopVideoView2.mMediaPlayer.getCurrentPosition();
                                }
                            } else if (MgtvLoopVideoView.this.mRenderView.getRenderViewType() == 1) {
                                if (!MgtvLoopVideoView.this.isHardware()) {
                                    MgtvLoopVideoView.this.mFromSurfaceDestroyToPlay = true;
                                }
                                MgtvLoopVideoView mgtvLoopVideoView3 = MgtvLoopVideoView.this;
                                if (!mgtvLoopVideoView3.mIsLoopMode && mgtvLoopVideoView3.mEnableTexture) {
                                    mgtvLoopVideoView3.mHasSurfaceHolderDestroy = true;
                                }
                            }
                        }
                        MgtvLoopVideoView.this.pauseInner();
                    } else {
                        try {
                            ReportParams reportParams = MgtvLoopVideoView.this.mReportParams;
                            if (reportParams != null) {
                                reportParams.getEnd().setInnerRetry(true);
                            }
                            MgtvLoopVideoView.this.release(true, true);
                        } catch (Exception unused) {
                        }
                    }
                    MgtvLoopVideoView mgtvLoopVideoView4 = MgtvLoopVideoView.this;
                    if (mgtvLoopVideoView4.mCurrentUri == null || mgtvLoopVideoView4.mCurrentState == -1 || MgtvLoopVideoView.this.mCurrentState == 5) {
                        return;
                    }
                    MgtvLoopVideoView.this.mStartLeaveTimestamp = System.currentTimeMillis();
                }
            }
        };
        this.mFilterCallback = new f.a() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.2
            public void onInfo(int i2, int i22, String str) {
                if (i2 == 1) {
                    MgtvLoopVideoView.this.mRenderType = i22;
                    MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                    ReportParams reportParams = mgtvLoopVideoView.mReportParams;
                    if (reportParams != null) {
                        reportParams.setRenderType(mgtvLoopVideoView.mRenderType);
                    }
                } else if (i2 != 3) {
                } else {
                    MgtvLoopVideoView.this.mEnhanceQualityType = i22;
                    MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                    ReportParams reportParams2 = mgtvLoopVideoView2.mReportParams;
                    if (reportParams2 != null) {
                        reportParams2.setEnhanceQualityType(mgtvLoopVideoView2.mEnhanceQualityType);
                    }
                }
            }
        };
        this.mRenderWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "opengl render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvLoopVideoView.this.mOnWarningListener != null) {
                    MgtvLoopVideoView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mSizeChangedListener = new MgtvPlayerListener.OnVideoSizeChangedListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnVideoSizeChangedListener
            public void onVideoSizeChanged(int i2, int i22) {
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                mgtvLoopVideoView.originalVideoWidth = mgtvLoopVideoView.mVideoWidth = mgtvLoopVideoView.mMediaPlayer.getVideoWidth();
                MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                mgtvLoopVideoView2.originalVideoHeight = mgtvLoopVideoView2.mVideoHeight = mgtvLoopVideoView2.mMediaPlayer.getVideoHeight();
                if (MgtvLoopVideoView.this.mVideoWidth != 0 && MgtvLoopVideoView.this.mVideoHeight != 0) {
                    MgtvLoopVideoView mgtvLoopVideoView3 = MgtvLoopVideoView.this;
                    MgtvRenderView mgtvRenderView = mgtvLoopVideoView3.mRenderView;
                    if (mgtvRenderView != null) {
                        mgtvRenderView.setVideoSize(mgtvLoopVideoView3.mVideoWidth, MgtvLoopVideoView.this.mVideoHeight);
                    }
                    MgtvLoopVideoView.this.requestLayout();
                }
                if (MgtvLoopVideoView.this.mOnVideoSizeChangedListener != null) {
                    MgtvLoopVideoView.this.mOnVideoSizeChangedListener.onVideoSizeChanged(i2, i22);
                }
            }
        };
        this.mPreparedListener = new MgtvPlayerListener.OnPreparedListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.5
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPreparedListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPrepared() {
                /*
                    r4 = this;
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    r1 = 2
                    com.hunantv.media.widget.MgtvLoopVideoView.access$2800(r0, r1)
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoWidth()
                    int r1 = com.hunantv.media.widget.MgtvLoopVideoView.access$302(r0, r1)
                    com.hunantv.media.widget.MgtvLoopVideoView.access$2502(r0, r1)
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.player.MgtvMediaPlayer r1 = r0.mMediaPlayer
                    int r1 = r1.getVideoHeight()
                    int r1 = com.hunantv.media.widget.MgtvLoopVideoView.access$402(r0, r1)
                    com.hunantv.media.widget.MgtvLoopVideoView.access$2602(r0, r1)
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$300(r0)
                    r1 = 3
                    if (r0 == 0) goto Lae
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$400(r0)
                    if (r0 == 0) goto Lae
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "video size: "
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvLoopVideoView r2 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r2 = com.hunantv.media.widget.MgtvLoopVideoView.access$300(r2)
                    r0.append(r2)
                    java.lang.String r2 = "/"
                    r0.append(r2)
                    com.hunantv.media.widget.MgtvLoopVideoView r2 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r2 = com.hunantv.media.widget.MgtvLoopVideoView.access$400(r2)
                    r0.append(r2)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r2 = "@@@@"
                    com.hunantv.media.player.pragma.DebugLog.i(r2, r0)
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.player.MgtvRenderView r2 = r0.mRenderView
                    if (r2 == 0) goto L72
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$300(r0)
                    com.hunantv.media.widget.MgtvLoopVideoView r3 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r3 = com.hunantv.media.widget.MgtvLoopVideoView.access$400(r3)
                    r2.setVideoSize(r0, r3)
                L72:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$500(r0)
                    if (r0 == 0) goto L7f
                    com.hunantv.media.widget.MgtvLoopVideoView r2 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    r2.seekTo(r0)
                L7f:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.player.MgtvRenderView r0 = r0.mRenderView
                    boolean r0 = r0.shouldWaitForResize()
                    if (r0 == 0) goto La5
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$000(r0)
                    com.hunantv.media.widget.MgtvLoopVideoView r2 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r2 = com.hunantv.media.widget.MgtvLoopVideoView.access$300(r2)
                    if (r0 != r2) goto Lbb
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$100(r0)
                    com.hunantv.media.widget.MgtvLoopVideoView r2 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r2 = com.hunantv.media.widget.MgtvLoopVideoView.access$400(r2)
                    if (r0 != r2) goto Lbb
                La5:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$200(r0)
                    if (r0 != r1) goto Lbb
                    goto Lb6
                Lae:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    int r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$200(r0)
                    if (r0 != r1) goto Lbb
                Lb6:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    r0.start()
                Lbb:
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$2900(r0)
                    if (r0 == 0) goto Lcc
                    com.hunantv.media.widget.MgtvLoopVideoView r0 = com.hunantv.media.widget.MgtvLoopVideoView.this
                    com.hunantv.media.widget.IVideoView$OnPreparedListener r0 = com.hunantv.media.widget.MgtvLoopVideoView.access$2900(r0)
                    r0.onPrepared()
                Lcc:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvLoopVideoView.AnonymousClass5.onPrepared():void");
            }
        };
        this.mCompletionListener = new MgtvPlayerListener.OnCompletionListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.6
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnCompletionListener
            public void onCompletion(int i2, int i22) {
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                if (i2 != 0) {
                    mgtvLoopVideoView.changeCurrentState(0);
                    MgtvLoopVideoView.this.mTargetState = 0;
                    MgtvLoopVideoView.this.stopInner();
                } else {
                    mgtvLoopVideoView.changeCurrentState(5);
                    MgtvLoopVideoView.this.mTargetState = 5;
                }
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "-------------on onCompletion what:" + i2 + ",extra:" + i22);
                if (MgtvLoopVideoView.this.mOnCompletionListener != null) {
                    MgtvLoopVideoView.this.mOnCompletionListener.onCompletion(i2, i22);
                }
            }
        };
        this.mInfoListener = new MgtvPlayerListener.OnInfoListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.7
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
                        logTag = MgtvLoopVideoView.this.getLogTag();
                        sb = new StringBuilder();
                        str = "video fps is ";
                    } else if (i2 == 2820) {
                        logTag = MgtvLoopVideoView.this.getLogTag();
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
                        String logTag2 = MgtvLoopVideoView.this.getLogTag();
                        DebugLog.i(logTag2, "MEDIA_INFO_PLAYBACK_STATE_CHANGED:" + i22);
                        if (MgtvLoopVideoView.this.mOnUpdateStatusListener != null) {
                            MgtvLoopVideoView.this.mOnUpdateStatusListener.onUpdateStatus();
                        }
                    } else if (i2 == 10001) {
                        String logTag3 = MgtvLoopVideoView.this.getLogTag();
                        DebugLog.w(logTag3, "video rotation changed,extra(degree) is " + i22);
                        MgtvLoopVideoView.this.mVideoRotationDegree = i22;
                        MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                        MgtvRenderView mgtvRenderView = mgtvLoopVideoView.mRenderView;
                        if (mgtvRenderView != null) {
                            mgtvRenderView.setVideoRotation(mgtvLoopVideoView.mVideoRotationDegree);
                        }
                    } else if (i2 == 200001) {
                        MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                        if (i22 == 1) {
                            mgtvLoopVideoView2.mMgtvMediaPlayerHardwareMode = false;
                        } else {
                            mgtvLoopVideoView2.mMgtvMediaPlayerHardwareMode = true;
                        }
                        MgtvLoopVideoView mgtvLoopVideoView3 = MgtvLoopVideoView.this;
                        mgtvLoopVideoView3.convertRender(mgtvLoopVideoView3.mRenderViewType);
                    } else if (i2 == 3) {
                        DebugLog.w(MgtvLoopVideoView.this.getLogTag(), "msg coming: video decode succeeded");
                        MgtvLoopVideoView.this.onVideoRenderStart();
                        if (MgtvLoopVideoView.this.mOnInfoListener != null) {
                            DebugLog.i(MgtvLoopVideoView.this.getLogTag(), "video decode succeeded, start rendering");
                            MgtvLoopVideoView.this.mOnInfoListener.onInfo(900, i22);
                        }
                        return true;
                    } else {
                        if (i2 == 4) {
                            logTag = MgtvLoopVideoView.this.getLogTag();
                            str2 = "audio decode succeeded, start rendering";
                        } else if (i2 != 5) {
                            if (i2 == 6) {
                                if (i22 == 0) {
                                    MgtvLoopVideoView.this.mMgtvMediaPlayerHardwareMode = false;
                                } else if (i22 == 1) {
                                    MgtvLoopVideoView.this.mMgtvMediaPlayerHardwareMode = true;
                                }
                                logTag = MgtvLoopVideoView.this.getLogTag();
                                sb = new StringBuilder();
                                str = "video decoder open,extra is ";
                            } else if (i2 != 7) {
                                switch (i2) {
                                    case 700:
                                        String logTag4 = MgtvLoopVideoView.this.getLogTag();
                                        DebugLog.w(logTag4, "It's too complex for the decoder, extra is " + i22);
                                        i2 = 700;
                                        break;
                                    case 701:
                                        String logTag5 = MgtvLoopVideoView.this.getLogTag();
                                        DebugLog.w(logTag5, "buffer start speed:" + MgtvLoopVideoView.this.getDLSpeedFormat());
                                        i2 = 701;
                                        break;
                                    case 702:
                                        String logTag6 = MgtvLoopVideoView.this.getLogTag();
                                        DebugLog.w(logTag6, "buffer end speed:" + MgtvLoopVideoView.this.getDLSpeedFormat());
                                        i2 = 702;
                                        break;
                                    default:
                                        switch (i2) {
                                            case 800:
                                                String logTag7 = MgtvLoopVideoView.this.getLogTag();
                                                DebugLog.e(logTag7, "Bad interleaving of media file, audio/video are not well-formed, extra is " + i22);
                                                i2 = 800;
                                                break;
                                            case 801:
                                                String logTag8 = MgtvLoopVideoView.this.getLogTag();
                                                DebugLog.w(logTag8, "The stream not seekable status, extra is " + i22);
                                                i2 = 801;
                                                MgtvLoopVideoView mgtvLoopVideoView4 = MgtvLoopVideoView.this;
                                                if (i22 != 1) {
                                                    mgtvLoopVideoView4.mIsLive = false;
                                                    logTag = MgtvLoopVideoView.this.getLogTag();
                                                    str2 = "The stream is not live stream,can seekable ";
                                                    break;
                                                } else {
                                                    mgtvLoopVideoView4.mIsLive = true;
                                                    logTag = MgtvLoopVideoView.this.getLogTag();
                                                    str2 = "The stream is live stream,can not seekable ";
                                                    break;
                                                }
                                            case 802:
                                                String logTag9 = MgtvLoopVideoView.this.getLogTag();
                                                DebugLog.w(logTag9, "A new set of metadata is available, extra is " + i22);
                                                i2 = 802;
                                                break;
                                            default:
                                                logTag = MgtvLoopVideoView.this.getLogTag();
                                                switch (i2) {
                                                    case MgtvMediaPlayer.MEDIA_INFO_DATA_PROTOCOL /* 2803 */:
                                                        DebugLog.w(logTag, "data source type is " + i22);
                                                        MgtvLoopVideoView mgtvLoopVideoView5 = MgtvLoopVideoView.this;
                                                        MgtvMediaPlayer mgtvMediaPlayer = mgtvLoopVideoView5.mMediaPlayer;
                                                        if (mgtvMediaPlayer != null) {
                                                            mgtvLoopVideoView5.mDataSourceType = mgtvMediaPlayer.getDataSourceType();
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
                        DebugLog.w(logTag, str2);
                    }
                    sb.append(str);
                    sb.append(i22);
                    str2 = sb.toString();
                    DebugLog.w(logTag, str2);
                } else {
                    String logTag10 = MgtvLoopVideoView.this.getLogTag();
                    DebugLog.w(logTag10, "Unknown info, extra is " + i22);
                    i2 = 1;
                }
                if (MgtvLoopVideoView.this.mOnInfoListener != null) {
                    MgtvLoopVideoView.this.mOnInfoListener.onInfo(i2, i22);
                }
                return true;
            }
        };
        this.mErrorListener = new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.8
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i2, int i22) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.w(logTag, "onError what:" + i2 + ",extra:" + i22);
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                MgtvMediaPlayer mgtvMediaPlayer = mgtvLoopVideoView.mMediaPlayer;
                if (mgtvMediaPlayer == null || i2 != 7000006) {
                    if (mgtvMediaPlayer != null && mgtvLoopVideoView.mCurrentState != -1) {
                        MgtvLoopVideoView.this.mMediaPlayer.stop();
                    }
                    MgtvLoopVideoView.this.changeCurrentState(-1);
                    MgtvLoopVideoView.this.mTargetState = -1;
                } else {
                    mgtvLoopVideoView.releaseNoStatus();
                    MgtvLoopVideoView.this.changeCurrentState(0);
                    MgtvLoopVideoView.this.mTargetState = 0;
                }
                MgtvLoopVideoView mgtvLoopVideoView2 = MgtvLoopVideoView.this;
                mgtvLoopVideoView2.mCurrentUri = null;
                mgtvLoopVideoView2.mProxyUri = null;
                return mgtvLoopVideoView2.mOnErrorListener != null && MgtvLoopVideoView.this.mOnErrorListener.onError(i2, i22);
            }
        };
        this.mSeekCompleteListener = new MgtvPlayerListener.OnSeekCompleteListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.9
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSeekCompleteListener
            public void onSeekComplete(int i2, int i22) {
                if (MgtvLoopVideoView.this.mOnSeekCompleteListener != null) {
                    String logTag = MgtvLoopVideoView.this.getLogTag();
                    DebugLog.i(logTag, "onSeekComplete seekTargetTime:" + i2 + ",errorCode:" + i22);
                    MgtvLoopVideoView.this.mOnSeekCompleteListener.onSeekComplete();
                }
            }
        };
        this.mBufferingUpdateListener = new MgtvPlayerListener.OnBufferingUpdateListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.10
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingUpdateListener
            public void onBufferingUpdate(int i2) {
                if (MgtvLoopVideoView.this.mOnBufferringUpdateListener != null) {
                    MgtvLoopVideoView.this.mOnBufferringUpdateListener.onBufferingUpdate(i2);
                }
            }
        };
        this.mBufferingTimeoutListener = new MgtvPlayerListener.OnBufferingTimeoutListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.11
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnBufferingTimeoutListener
            public boolean onBufferingTimeout(int i2, int i22) {
                MgtvMediaPlayer mgtvMediaPlayer = MgtvLoopVideoView.this.mMediaPlayer;
                if (mgtvMediaPlayer != null) {
                    mgtvMediaPlayer.stop();
                }
                MgtvLoopVideoView.this.changeCurrentState(-1);
                MgtvLoopVideoView.this.mTargetState = -1;
                MgtvLoopVideoView mgtvLoopVideoView = MgtvLoopVideoView.this;
                mgtvLoopVideoView.mCurrentUri = null;
                mgtvLoopVideoView.mProxyUri = null;
                if (mgtvLoopVideoView.mOnErrorListener == null || MgtvLoopVideoView.this.mOnErrorListener.onError(i2, i22)) {
                }
                return true;
            }
        };
        this.mSwitchSourceListener = new MgtvPlayerListener.OnSwitchSourceListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.12
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceComplete(String str, int i2, int i22) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceComplete url:" + str + ",type:" + i2 + ",time:" + i22);
                if (MgtvLoopVideoView.this.mOnChangeSourceListener != null) {
                    MgtvLoopVideoView.this.mOnChangeSourceListener.onChangeSourceSuccess(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceFailed(String str, int i2, int i22) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceFailed url:" + str + ",what:" + i2 + ",extra:" + i22);
                if (MgtvLoopVideoView.this.mOnChangeSourceListener != null) {
                    MgtvLoopVideoView.this.mOnChangeSourceListener.onChangeSourceFailed(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSourceListener
            public void onSwitchSourceInfo(String str, int i2, int i22) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.e(logTag, "onSwitchSourceInfo url:" + str + ",event:" + i2 + ",time:" + i22);
                if (MgtvLoopVideoView.this.mOnChangeSourceListener != null) {
                    MgtvLoopVideoView.this.mOnChangeSourceListener.onChangeSourceInfo(str, i2, i22);
                }
            }
        };
        this.mPlayerWarning = new MgtvPlayerListener.OnWarningListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.13
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onTsSkip(String str, int i2, int i22) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "onTsSkip tsUrl:" + str);
                if (MgtvLoopVideoView.this.mOnWarningListener != null) {
                    MgtvLoopVideoView.this.mOnWarningListener.onTsSkip(str, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnWarningListener
            public void onWarning(int i2, String str, String str2, Object obj) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "player render warning:" + i2 + ",extra:" + str + ",msg:" + str2);
                if (MgtvLoopVideoView.this.mOnWarningListener != null) {
                    MgtvLoopVideoView.this.mOnWarningListener.onWarning(i2, str, str2, obj);
                }
            }
        };
        this.mGifRecorder = new GifRecorder();
        this.mStartListener = new MgtvPlayerListener.OnStartListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.14
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnStartListener
            public void onStart() {
                DebugLog.d(MgtvLoopVideoView.this.getLogTag(), "mgtvcore onStart");
                if (MgtvLoopVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvLoopVideoView.this.callbackOnStart();
                }
            }
        };
        this.mPauseListener = new MgtvPlayerListener.OnPauseListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.15
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPauseListener
            public void onPause() {
                DebugLog.d(MgtvLoopVideoView.this.getLogTag(), "mgtvcore onPause");
                if (MgtvLoopVideoView.this.mEnableCoreStartPauseListen) {
                    MgtvLoopVideoView.this.callbackOnPause();
                }
            }
        };
        this.mRecordVideoListener = new MgtvPlayerListener.OnRecordVideoListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.16
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoErr(int i2, int i22) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.e(logTag, "onRecordVideoErr what:" + i2 + ",extra:" + i22);
                if (MgtvLoopVideoView.this.mOnRecordListener != null) {
                    MgtvLoopVideoView.this.mOnRecordListener.onRecordError(i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnRecordVideoListener
            public void onRecordVideoInfo(int i2, int i22) {
                String logTag = MgtvLoopVideoView.this.getLogTag();
                DebugLog.i(logTag, "onRecordVideoInfo what:" + i2 + ",extra:" + i22);
                if (MgtvLoopVideoView.this.mOnRecordListener != null) {
                    if (i2 == 20) {
                        MgtvLoopVideoView.this.mOnRecordListener.onRecordStart(MgtvLoopVideoView.this.mRecordFilePath);
                    } else if (i2 == 30) {
                        MgtvLoopVideoView.this.mOnRecordListener.onRecordStop();
                    }
                    MgtvLoopVideoView.this.mOnRecordListener.onRecordInfo(i2, i22);
                }
            }
        };
        this.mLoadDataListener = new MgtvPlayerListener.OnLoadDataListener() { // from class: com.hunantv.media.widget.MgtvLoopVideoView.17
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onAfterLoadDataPaused() {
                if (MgtvLoopVideoView.this.mOnLoadDataListener != null) {
                    MgtvLoopVideoView.this.mOnLoadDataListener.onAfterLoadDataPaused();
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnLoadDataListener
            public void onBeforeLoadDataResume() {
                if (MgtvLoopVideoView.this.mOnLoadDataListener != null) {
                    MgtvLoopVideoView.this.mOnLoadDataListener.onBeforeLoadDataResume();
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
        this.mTargetIsLoopMode = configuration.isLoopMode;
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
        initVideoView(context, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initVideoView(Context context, int i) {
        this.mContext = context;
        this.metrics = context.getResources().getDisplayMetrics();
        this.mRenderViewType = i;
        this.mInitRenderViewType = i;
        if (i == 0) {
            this.mEnableTexture = false;
        }
        c cVar = new c(context);
        this.mFakeFrameView = cVar;
        addView(cVar, new FrameLayout.LayoutParams(-2, -2, 17));
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

    private boolean isInLoopValidState() {
        int i;
        return (this.mMediaPlayer == null || (i = this.mCurrentState) == -1 || i == 0) ? false : true;
    }

    private boolean isInPlaybackState() {
        int i;
        return (this.mMediaPlayer == null || (i = this.mCurrentState) == -1 || i == 0 || i == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openVideo() {
        openVideo(this.mMgtvMediaPlayerHardwareMode);
    }

    private void openVideo(boolean z) {
        MgtvMediaPlayer mgtvMediaPlayer;
        int i;
        MgtvMediaPlayer mgtvMediaPlayer2;
        SurfaceHolder surfaceHolder;
        this.mErrorMsg = "";
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
            release(false, true);
            try {
                Bundle bundle = new Bundle();
                bundle.putString(MgtvMediaPlayer.BUNDLE_KEY_LOG_TAG_KEY, getLogTagKey());
                if (this.mUseSystemPlayer) {
                    mgtvMediaPlayer = new MgtvMediaPlayer(0, this.mContext, false, bundle);
                } else {
                    if (this.mIsLiveConfig) {
                        i = 1;
                    } else if (this.mTargetIsLoopMode) {
                        this.mIsLoopMode = true;
                        i = 2;
                    } else {
                        i = 0;
                    }
                    if (!z) {
                        this.mEnableTexture = false;
                        mgtvMediaPlayer2 = new MgtvMediaPlayer(1, this.mContext, this.mEnableTexture, i, bundle);
                    } else if (this.mIsLoopMode) {
                        if (Build.VERSION.SDK_INT <= 22) {
                            this.mEnableTexture = false;
                        }
                        mgtvMediaPlayer2 = new MgtvMediaPlayer(2, this.mContext, this.mEnableTexture, i, bundle);
                    } else {
                        this.mEnableTexture = false;
                        mgtvMediaPlayer2 = new MgtvMediaPlayer(2, this.mContext, this.mEnableTexture, i, bundle);
                    }
                    mgtvMediaPlayer = mgtvMediaPlayer2;
                }
                this.mMediaPlayer = mgtvMediaPlayer;
                mgtvMediaPlayer.setFlowDataStatistic(this.mFlowDataStatistic);
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
            } catch (IllegalArgumentException e) {
                String logTag3 = getLogTag();
                DebugLog.w(logTag3, "Unable to open content: " + this.mCurrentUri + ",details:" + e.getMessage());
                this.mErrorMsg = e.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_ILLEGAL_ARGUMENT, 0);
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
            } catch (Exception e5) {
                String logTag7 = getLogTag();
                DebugLog.w(logTag7, "Unable to open content: " + this.mCurrentUri + ",details:" + e5.getMessage());
                this.mErrorMsg = e5.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_OPENVIDEO_FAILED, 0);
            } catch (a.a.a.a.p.c e6) {
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
            } catch (UnsatisfiedLinkError e8) {
                String logTag10 = getLogTag();
                DebugLog.i(logTag10, "UnsatisfiedLinkError: " + this.mCurrentUri + ",details:" + e8.getMessage());
                this.mErrorMsg = e8.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_LIB_NOTLOAD, 0);
            } catch (InvalidParameterException e9) {
                String logTag11 = getLogTag();
                DebugLog.w(logTag11, "Unable to open content: " + this.mCurrentUri);
                this.mErrorMsg = e9.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_SURFACE_FAILED, 3);
            } catch (Throwable th) {
                String logTag12 = getLogTag();
                DebugLog.i(logTag12, "Throwable: " + this.mCurrentUri + ",details:" + th.getMessage());
                this.mErrorMsg = th.getMessage();
                changeCurrentState(-1);
                this.mTargetState = -1;
                this.mErrorListener.onError(IVideoView.MEDIA_ERROR_OPENVIDEO_FAILED, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseInner() {
        if (isInPlaybackState() && (this.mMediaPlayer.isPlaying() || (isInLoopValidState() && this.mIsLoopMode && isCompletion()))) {
            DebugLog.i(getLogTag(), "pause play");
            this.mMediaPlayer.pause();
            if (!this.mEnableCoreStartPauseListen) {
                callbackOnPause();
            }
        }
        if (isReuseTextureDisable()) {
            saveLastValidFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release(boolean z, boolean z2) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "release player.clear.cleartargetstate:" + z);
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            if (z) {
                mgtvMediaPlayer.stop();
            }
            resetDataBefore(z2 ? MgtvAbstractVideoView.ReleaseReason.DEFAULT_INNER : MgtvAbstractVideoView.ReleaseReason.OUT);
            releaseNoStatus();
            changeCurrentState(0);
            if (z) {
                this.mTargetState = 0;
            }
            resetDataAfter(z2 ? MgtvAbstractVideoView.ReleaseReason.DEFAULT_INNER : MgtvAbstractVideoView.ReleaseReason.OUT);
        }
        if (z2) {
            return;
        }
        abandonAudioFocus();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void resetVideoPath() {
        Uri uri = this.mCurrentUri;
        if (uri == null) {
            DebugLog.e(getLogTag(), "resetVideoPath mCurrentUri == null return");
            return;
        }
        String uri2 = uri.toString();
        IP2pTask iP2pTask = this.mMainP2pTask;
        Uri uri3 = this.mProxyUri;
        resetVideoPath(uri2, iP2pTask, uri3 != null ? uri3.toString() : null);
    }

    private void resetVideoPathNormalImpl(String str, IP2pTask iP2pTask, String str2) {
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
            this.mRenderView.setVideoSize(this.mMediaPlayer.getVideoWidth(), this.mMediaPlayer.getVideoHeight());
        }
        setRenderView(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0073 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setRenderView(int r12) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvLoopVideoView.setRenderView(int):void");
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
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setSkipLoopFilter(this.mSkipLoopFilterType);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void changeSourceAsync(IVideoView.MediaSource mediaSource, int i, int i2, int i3) {
        String str;
        IP2pTask iP2pTask;
        IVideoView.OnChangeSourceListener onChangeSourceListener;
        int i4;
        if (mediaSource == null) {
            IVideoView.OnChangeSourceListener onChangeSourceListener2 = this.mOnChangeSourceListener;
            if (onChangeSourceListener2 != null) {
                onChangeSourceListener2.onChangeSourceFailed(null, IVideoView.MEDIA_ERROR_ILLEGAL_ARGUMENT, 0);
                return;
            }
            return;
        }
        int i5 = mediaSource.readType;
        String str2 = mediaSource.url;
        IP2pTask iP2pTask2 = mediaSource.p2pTask;
        String str3 = mediaSource.proxyUrl;
        if (this.mMediaPlayer != null) {
            if (i5 != 0) {
                if (iP2pTask2 == null) {
                    try {
                        if (StringUtil.isEmpty(str3)) {
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        onChangeSourceListener = this.mOnChangeSourceListener;
                        if (onChangeSourceListener != null) {
                            i4 = IVideoView.MEDIA_ERROR_ILLEGAL_ARGUMENT;
                            onChangeSourceListener.onChangeSourceFailed(str2, i4, 0);
                            return;
                        }
                        return;
                    } catch (Exception unused) {
                        onChangeSourceListener = this.mOnChangeSourceListener;
                        if (onChangeSourceListener != null) {
                            i4 = IVideoView.MEDIA_ERROR_OPENVIDEO_FAILED;
                            onChangeSourceListener.onChangeSourceFailed(str2, i4, 0);
                            return;
                        }
                        return;
                    }
                }
                iP2pTask = iP2pTask2;
                this.mMediaPlayer.switchP2pVideoSource(i5, str2, iP2pTask2, str3, i, i2, i3);
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
        IVideoView.OnChangeSourceListener onChangeSourceListener;
        int i4;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            try {
                mgtvMediaPlayer.switchVideoSource(str, i, i2, i3);
                String logTag = getLogTag();
                DebugLog.e(logTag, "changeSourceAsync url:" + str);
                String logTag2 = getLogTag();
                DebugLog.e(logTag2, "changeSourceAsync src:" + i2 + ",dst:" + i3);
            } catch (IOException e) {
                e.printStackTrace();
                onChangeSourceListener = this.mOnChangeSourceListener;
                if (onChangeSourceListener != null) {
                    i4 = IVideoView.MEDIA_ERROR_ILLEGAL_ARGUMENT;
                    onChangeSourceListener.onChangeSourceFailed(str, i4, 0);
                }
            } catch (Exception unused) {
                onChangeSourceListener = this.mOnChangeSourceListener;
                if (onChangeSourceListener != null) {
                    i4 = IVideoView.MEDIA_ERROR_OPENVIDEO_FAILED;
                    onChangeSourceListener.onChangeSourceFailed(str, i4, 0);
                }
            }
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void cleanUri() {
        DebugLog.i(getLogTag(), "cleanUri");
        this.mCurrentUri = null;
        this.mProxyUri = null;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void configDataCacheSizeKB(int i) {
        this.mDataCacheSizeKB = i;
        updateDataCacheSizeKB();
    }

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView
    public void configImgoPlayer() {
        super.configImgoPlayer();
        this.mOpenVideoWhenSurfaceCreate = false;
        ReportParams reportParams = this.mReportParams;
        if (reportParams != null) {
            reportParams.setAddrInfoInt(this.mAddrInfoTypeInt);
        }
        if (this.mDnsFamilyType != 1) {
            setNetAddrinfo(0, -1);
        }
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            MgtvRenderView mgtvRenderView = this.mRenderView;
            mgtvMediaPlayer.bindRenderView(mgtvRenderView != null ? mgtvRenderView.getRenderView() : null);
            this.mMediaPlayer.setTimeout(this.mConnectTimeOut, this.mReciveDataTimeOut, this.mBufferTimeoutMs);
            this.mMediaPlayer.setDataSourceType(this.mDataSourceType);
            this.mMediaPlayer.setAccurateSeekEnable(this.mAccurateSeekEnable);
            this.mMediaPlayer.setNetAddrinfo(this.mAddrInfoType, this.mAddrInfoTimeoutMs, this.mJavaDnsEnable, this.mJavaDnsType, this.mNativeDnsAsyncEnable);
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
            this.mMediaPlayer.enableM3u8Cache(this.mCacheEnable);
            this.mMediaPlayer.setM3u8Caches(this.mCacheM3u8Path, this.mCacheTsPaths);
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
            this.mMediaPlayer.configForceHW(this.mForceDecodeMode);
            this.mMediaPlayer.bindGifRecorder(this.mGifRecorder);
            this.mMediaPlayer.setPlaybackSpeed(this.mPlaySpeed);
            this.mMediaPlayer.setLiveStartIndex(this.mLiveStartIndex);
            int i4 = this.mStartPosMs;
            if (i4 > 0) {
                this.mMediaPlayer.setPlayerPrepareStartPosMs(i4);
                String logTag = getLogTag();
                DebugLog.i(logTag, "configImgoPlayer mLoopStartPosMs:" + this.mStartPosMs);
            }
            this.mMediaPlayer.setReadDataSourceType(this.mReadDataSourceTypeConfig);
            updateDataCacheSizeKB();
            updateSkipLoopFilter();
            this.mMediaPlayer.enableTsSkipError(this.mEnableTsSkipError);
            this.mMediaPlayer.enableMgtvMediaCodec(this.mEnableMgtvMediaCodec);
            String logTag2 = getLogTag();
            DebugLog.i(logTag2, "configImgoPlayer mConnectTimeOut:" + this.mConnectTimeOut + ",mReciveDataTimeOut:" + this.mReciveDataTimeOut + ",mBufferTimeoutMs:" + this.mBufferTimeoutMs + ",mDataSourceType:" + this.mDataSourceType + ",mAccurateSeekEnable:" + this.mAccurateSeekEnable + ",mAddrInfoType:" + this.mAddrInfoType + ",mAddrInfoTimeoutMs:" + this.mAddrInfoTimeoutMs + ",mJavaDnsEnable:" + this.mJavaDnsEnable + ",mJavaDnsType:" + this.mJavaDnsType + ",mPlaySpeed:" + this.mPlaySpeed + ",mLiveStartIndex:" + this.mLiveStartIndex + ",mEnableLiveMode:" + this.mEnableLiveMode + ",mReadDataSourceTypeConfig:" + this.mReadDataSourceTypeConfig + ",mNativeDnsAsyncEnable:" + this.mNativeDnsAsyncEnable + ",mEnableTsSkipError:" + this.mEnableTsSkipError + ",mEnableMgtvMediaCodec:" + this.mEnableMgtvMediaCodec);
            int i5 = (this.mNonSurfaceHolderPVTimestamp > 0L ? 1 : (this.mNonSurfaceHolderPVTimestamp == 0L ? 0 : -1));
            MgtvMediaPlayer mgtvMediaPlayer2 = this.mMediaPlayer;
            if (i5 > 0) {
                mgtvMediaPlayer2.setNetdSVCTimeMs(System.currentTimeMillis() - this.mNonSurfaceHolderPVTimestamp);
            } else {
                mgtvMediaPlayer2.setNetdSVCTimeMs(0L);
            }
        }
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

    @Override // com.hunantv.media.widget.IVideoView
    public void enableCoreStartPauseListen(boolean z) {
        this.mUserEnableCoreStartPauseListen = z;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableM3u8Cache(boolean z) {
        this.mCacheEnable = z;
    }

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView, com.hunantv.media.widget.ISubtitle
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
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer == null) {
            DebugLog.d(getLogTag(), "getCurrentPosition mMediaPlayer is null");
            return 0;
        }
        int i = this.mCurrentState;
        if (i == 0 || i == 1) {
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
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(getLogTagKey());
        sb.append("][");
        sb.append(getClass().getSimpleName());
        sb.append("-");
        sb.append(this.mIsLoopMode ? "1" : MLog.a.b);
        sb.append("]");
        return sb.toString();
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
        return this.mIsDataLoaderPaused;
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

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView, com.hunantv.media.widget.IVideoView
    public boolean isOnlyAudioMode() {
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

    public boolean isTextureView() {
        MgtvRenderView mgtvRenderView = this.mRenderView;
        return mgtvRenderView != null && mgtvRenderView.getRenderViewType() == 1;
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

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView
    public void onVideoRenderStart() {
        super.onVideoRenderStart();
        MgtvRenderView mgtvRenderView = this.mRenderView;
        if (mgtvRenderView != null) {
            mgtvRenderView.setDisplayFloatRect(this.mDisplayFloatRect);
        }
    }

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView, com.hunantv.media.widget.IVideoView
    public void openImgoDSModule(boolean z) {
        if (this.mTargetIsLoopMode) {
            return;
        }
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
        DebugLog.i(getLogTag(), "pauseLoadData");
        if (this.mMediaPlayer != null) {
            DebugLog.i(getLogTag(), "pauseLoadData in");
            this.mIsDataLoaderPaused = true;
            this.mMediaPlayer.pauseLoadData();
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
        this.mIsDataLoaderPaused = false;
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
        this.mOpenVideoWhenSurfaceCreate = false;
        this.mNeedResetLoopPlay = false;
        this.mSeekWhenPrepared = 0;
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
        String logTag = getLogTag();
        DebugLog.i(logTag, "resetVideoPath path " + str + ",proxyPath:" + str2);
        this.mNonSurfaceHolderPVTimestamp = 0L;
        boolean z = false;
        this.mNeedResetLoopPlay = false;
        if (str == null) {
            this.mErrorListener.onError(IVideoView.MEDIA_ERROR_INVALID_URL, 12);
        } else {
            this.mCurrentUri = Uri.parse(str.trim());
        }
        this.mMainP2pTask = iP2pTask;
        this.mProxyUri = StringUtil.isEmpty(str2) ? null : Uri.parse(str2.trim());
        if (this.mMediaPlayer == null) {
            setVideoPath(str, iP2pTask, str2);
            return;
        }
        if (Build.VERSION.SDK_INT <= 22) {
            DebugLog.i(getLogTag(), "resetVideoPath need rebindTexture");
            z = true;
        }
        this.mRebindTexture = z;
        if (this.mHasSurfaceHolderDestroy) {
            convertRender(this.mRenderViewType);
        } else if (isInLoopValidState() && this.mIsLoopMode && !this.mMediaPlayer.isLoopSwitching()) {
            DebugLog.i(getLogTag(), "resetVideoPathLoopImpl in");
            resetVideoPathLoopImpl(str, iP2pTask, str2);
            DebugLog.i(getLogTag(), "resetVideoPathLoopImpl out");
        } else {
            if (this.mMediaPlayer.isLoopSwitching()) {
                DebugLog.i(getLogTag(), "isLoopSwitching change to resetVideoPathNormalImpl");
            }
            DebugLog.i(getLogTag(), "resetVideoPathNormalImpl in");
            resetVideoPathNormalImpl(str, iP2pTask, str2);
            DebugLog.i(getLogTag(), "resetVideoPathNormalImpl in");
        }
    }

    public void resetVideoPathLoopImpl(String str, IP2pTask iP2pTask, String str2) {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer == null) {
            DebugLog.e(getLogTag(), "resetVideoPathLoopImpl mMediaPlayer == null return");
            return;
        }
        mgtvMediaPlayer.setReportParams(this.mReportParams);
        this.mFromSurfaceDestroyToPlay = false;
        this.mHasSurfaceHolderDestroy = false;
        this.mMediaPlayer.resetLoopPlay();
        resumeLoadData();
        configImgoPlayer();
        if (this.mSurfaceHolder == null && (!this.mEnableTexture || !isTextureView())) {
            DebugLog.i(getLogTag(), "resetVideoPathLoopImpl mSurfaceHolder == null wait surface attach to window");
            this.mNeedResetLoopPlay = true;
            return;
        }
        int i = this.mStartPosMs;
        if (i <= 0) {
            this.mMediaPlayer.switchLoopSource(this.mReadDataSourceTypeConfig, str, iP2pTask, str2, 0);
            return;
        }
        this.mMediaPlayer.switchLoopSource(this.mReadDataSourceTypeConfig, str, iP2pTask, str2, i);
        this.mStartPosMs = 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void resume() {
        openVideo();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void resumeLoadData() {
        DebugLog.i(getLogTag(), "resumeLoadData");
        if (this.mMediaPlayer == null || !this.mIsDataLoaderPaused) {
            return;
        }
        DebugLog.i(getLogTag(), "resumeLoadData in");
        this.mIsDataLoaderPaused = false;
        this.mMediaPlayer.resumeLoadData();
    }

    public void saveLastValidFrame() {
        MgtvRenderView mgtvRenderView = this.mRenderView;
        if (mgtvRenderView != null) {
            mgtvRenderView.saveLastValidFrame();
        }
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
        if (isInPlaybackState()) {
            if (i >= 0) {
                if (this.mFromSurfaceDestroyToPlay) {
                    this.mFromSurfaceDestroyPlayPosition = i;
                }
                String logTag = getLogTag();
                DebugLog.i(logTag, "seekTo msec:" + i);
                if (this.mMediaPlayer.isLoadDataPaused()) {
                    DebugLog.i(getLogTag(), "seekTo resumeLoadData");
                    this.mMediaPlayer.resumeLoadData();
                }
                this.mMediaPlayer.seekTo(i, z);
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
    }

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView, com.hunantv.media.widget.IVideoView
    public void setBufferTimeout(int i) {
        this.mBufferTimeoutMs = i;
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
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setNetAddrinfo(int i, int i2) {
        setNetAddrinfo(i, i2, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008a  */
    @Override // com.hunantv.media.widget.IVideoView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setNetAddrinfo(int r5, int r6, boolean r7) {
        /*
            r4 = this;
            r7 = 1
            r4.mNativeDnsAsyncEnable = r7
            com.hunantv.media.report.ReportParams r0 = r4.mReportParams
            r1 = 3
            if (r0 == 0) goto L27
            com.hunantv.media.report.ReportParams$VideoType r0 = r0.getVideoType()
            com.hunantv.media.report.ReportParams$VideoType r2 = com.hunantv.media.report.ReportParams.VideoType.AD_PRE
            if (r0 == r2) goto L24
            com.hunantv.media.report.ReportParams r0 = r4.mReportParams
            com.hunantv.media.report.ReportParams$VideoType r0 = r0.getVideoType()
            com.hunantv.media.report.ReportParams$VideoType r2 = com.hunantv.media.report.ReportParams.VideoType.AD_MID
            if (r0 == r2) goto L24
            com.hunantv.media.report.ReportParams r0 = r4.mReportParams
            com.hunantv.media.report.ReportParams$VideoType r0 = r0.getVideoType()
            com.hunantv.media.report.ReportParams$VideoType r2 = com.hunantv.media.report.ReportParams.VideoType.AD_BOOT
            if (r0 != r2) goto L27
        L24:
            if (r5 <= r1) goto L27
            r5 = 3
        L27:
            java.lang.String r0 = r4.getLogTag()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "setNetAddrinfo "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r3 = ",timeout:"
            r2.append(r3)
            r2.append(r6)
            java.lang.String r3 = ",enablePreDns:"
            r2.append(r3)
            r3 = 0
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.hunantv.media.player.pragma.DebugLog.i(r0, r2)
            r4.mAddrInfoTypeInt = r5
            r4.mEnableMgtvMediaCodec = r3
            int r0 = r4.mDnsFamilyType
            if (r0 != r7) goto L83
            r0 = 9
            if (r5 == r0) goto L80
            r0 = 20
            if (r5 == r0) goto L7d
            if (r5 == r7) goto L7a
            r0 = 2
            if (r5 == r0) goto L77
            if (r5 == r1) goto L74
            r0 = 4
            if (r5 == r0) goto L6b
            goto L83
        L6b:
            com.hunantv.media.player.MgtvMediaPlayer$AddrinfoType r5 = com.hunantv.media.player.MgtvMediaPlayer.AddrinfoType.TYPE_DNS_CACHE
            r4.mAddrInfoType = r5
            a.a.a.a.n.a$d r5 = a.a.a.a.n.a.d.b
            r4.mJavaDnsType = r5
            goto L88
        L74:
            com.hunantv.media.player.MgtvMediaPlayer$AddrinfoType r5 = com.hunantv.media.player.MgtvMediaPlayer.AddrinfoType.TYPE_DNS_CACHE
            goto L85
        L77:
            com.hunantv.media.player.MgtvMediaPlayer$AddrinfoType r5 = com.hunantv.media.player.MgtvMediaPlayer.AddrinfoType.TYPE_ADDRINFO_ONE_BY_ONE
            goto L85
        L7a:
            com.hunantv.media.player.MgtvMediaPlayer$AddrinfoType r5 = com.hunantv.media.player.MgtvMediaPlayer.AddrinfoType.TYPE_ADDRINFO_THREAD
            goto L85
        L7d:
            r4.mEnableMgtvMediaCodec = r7
            goto L87
        L80:
            r4.mNativeDnsAsyncEnable = r3
            goto L87
        L83:
            com.hunantv.media.player.MgtvMediaPlayer$AddrinfoType r5 = com.hunantv.media.player.MgtvMediaPlayer.AddrinfoType.TYPE_ADDRINFO_DEFAULT
        L85:
            r4.mAddrInfoType = r5
        L87:
            r7 = 0
        L88:
            if (r6 <= 0) goto L8e
            int r6 = r6 * 1000
            r4.mAddrInfoTimeoutMs = r6
        L8e:
            r4.mJavaDnsEnable = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvLoopVideoView.setNetAddrinfo(int, int, boolean):void");
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

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView, com.hunantv.media.widget.IVideoView
    public void setOnSwitchSmoothSourceListener(IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener) {
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

    public MgtvLoopVideoView setTargetIsLoopMode(boolean z) {
        this.mTargetIsLoopMode = z;
        return this;
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
        String logTag = getLogTag();
        DebugLog.i(logTag, "setVideoPath path " + str + ",proxyPath:" + str2);
        boolean z = false;
        this.mNeedResetLoopPlay = false;
        if (this.mEnableTexture && Build.VERSION.SDK_INT <= 22) {
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

    @Override // com.hunantv.media.widget.MgtvAbstractVideoView
    public void stopInner() {
        if (this.mIsLoopMode) {
            MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
            if (mgtvMediaPlayer != null) {
                mgtvMediaPlayer.pause();
                return;
            }
            return;
        }
        MgtvMediaPlayer mgtvMediaPlayer2 = this.mMediaPlayer;
        if (mgtvMediaPlayer2 != null) {
            mgtvMediaPlayer2.stop();
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
        setRender(i);
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void useSystemPlayer(boolean z) {
        this.mUseSystemPlayer = z;
    }
}
