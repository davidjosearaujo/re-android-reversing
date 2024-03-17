package com.hunantv.media.widget;

import a.a.a.a.c;
import a.a.a.a.l;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import c.a.a.b.d.g;
import c.a.a.c.a;
import com.hunantv.imgo.nightmode.view.SkinnableFrameLayout;
import com.hunantv.media.config.NetPlayConfig;
import com.hunantv.media.config.NetPlayConfigHelper;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.media.drm.MgtvDrmParams;
import com.hunantv.media.global.Constants;
import com.hunantv.media.global.PlayerReferenceObserver;
import com.hunantv.media.p2p.IP2pTask;
import com.hunantv.media.player.IMgtvRenderView;
import com.hunantv.media.player.MgtvMediaPlayer;
import com.hunantv.media.player.MgtvPlayerDataSource;
import com.hunantv.media.player.MgtvPlayerListener;
import com.hunantv.media.player.MgtvRenderView;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.player.smooth.SmoothMediaSource;
import com.hunantv.media.player.subtitle.SubtitleSource;
import com.hunantv.media.player.utils.StringUtil;
import com.hunantv.media.report.ReportParams;
import com.hunantv.media.utils.AndroidOSUtils;
import com.hunantv.media.utils.AudioUtil;
import com.hunantv.media.utils.FileUtil;
import com.hunantv.media.utils.KeyFrameInfoUtils;
import com.hunantv.media.utils.ViewUtil;
import com.hunantv.media.widget.ISubtitle;
import com.hunantv.media.widget.IVideoView;
import com.hunantv.media.widget.debug.DebugPanel;
import com.hunantv.media.widget.extra.SubtitleView;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class MgtvAbstractVideoView extends SkinnableFrameLayout implements IVideoView {
    public static final int INVALID_FILE_START_TIME_VALUE = -1;
    public static final int MODE_NORMAL = 0;
    public static final int MODE_ONLY_AUDIO = 1;
    public static boolean sAutoNativeStack = true;
    public boolean isBackground;
    public boolean isRequestAudioFocus;
    public ABRegion mABRegion;
    public int mAMCKeyFrameBackMode;
    private MgtvPlayerListener.OnAVPlayListener mAVPlayListener;
    public int mAddrInfoTimeoutMs;
    public boolean mAntiViewShake;
    private byte[] mAudioEffectConfig;
    public volatile boolean mAudioFocusObtained;
    public boolean mBackPlayEnable;
    public IVideoView.Configuration mConfiguration;
    public int mConnectTimeOut;
    public Context mContext;
    public Uri mCurrentUri;
    public MgtvPlayerDataSource mDataSource;
    public MgtvMediaPlayer.DataSourceInfo mDataSourceInfo;
    public MgtvMediaPlayer.DataSourceType mDataSourceType;
    public DebugPanel mDebugPanel;
    public FrameLayout mDecorateLayout;
    public IMgtvRenderView.FloatRect mDisplayFloatRect;
    public int mDnsFamilyType;
    public List<MgtvDrmParams.DrmInfo> mDrmInfoList;
    public IDrmSession mDrmSession;
    public boolean mEnableDefaultFileStartTime;
    private boolean mEnableFramePTSNotify;
    public boolean mEnableImgoVsr;
    public boolean mEnableMediacodecSW;
    public boolean mEnableSpaceAudio;
    public boolean mEnableTexture;
    public boolean mEnableVideoStartTime;
    public c mFakeFrameView;
    public float mFileStartTimeFloatS;
    public boolean mForceHttpDns;
    public boolean mForceReuseTexture;
    private MgtvPlayerListener.OnFrameListener mFrameListener;
    private MgtvPlayerListener.OnInfoStringListener mInfoStringListener;
    public int mInitRenderViewType;
    public boolean mIsDrmPrepared;
    public boolean mIsSubtitleEnable;
    public boolean mJavaDnsEnable;
    public byte[] mKeyInfoData;
    public int mKeyInfoRet;
    public boolean mKeyInfoSet;
    public boolean mKeyInfoSetEnable;
    public int mKeyInfoSetLayer;
    public int mLastMediaMode;
    public float mLeftVolume;
    private boolean mLiveLowLatencyEnable;
    public boolean mLoopABPlayEnable;
    public IP2pTask mMainP2pTask;
    public MgtvMediaPlayer mMediaPlayer;
    public boolean mMediacodecRecreateformat;
    public boolean mMediacodecRecreateformatOnly4K;
    public int mMgtvFastMode;
    public NetPlayConfig mNetPlayConfig;
    public IVideoView.OnAVPlayListener mOnAVPlayListener;
    public IVideoView.OnEventInfoListener mOnEventInfoListener;
    public IVideoView.OnFrameListener mOnFrameListener;
    public IVideoView.OnInfoStringListener mOnInfoStringListener;
    public IDrmSession.OnProvisionSuccessListener mOnProvisionSuccessListener;
    public ISubtitle.SubtitleCallback mOnSubtitleCallback;
    public IVideoView.OnSwitchSmoothSourceListener mOnSwitchSmoothSourceListener;
    private MgtvPlayerListener.OnPlayerEventListener mPlayerEventListener;
    private int mPreBufferTimeoutMs;
    public MgtvMediaPlayer.Prepared4StartMode mPrepared4StartMode;
    public Uri mProxyUri;
    public int mReadDataSourceTypeConfig;
    public int mReciveDataTimeOut;
    public MgtvRenderView mRenderView;
    public int mRenderViewType;
    public ReportParams mReportParams;
    public l mResizableFrameView;
    public float mRightVolume;
    public boolean mSeekAutoStartAfterCompleteEnable;
    public boolean mSmoothModeOpen;
    public boolean mSmoothModeSwitch;
    public int mSmoothSwitchMode;
    private ISubtitle.SubtitleCallback mSubtitleCallback;
    public SubtitleSource mSubtitleSource;
    public SubtitleView mSubtitleView;
    public IMgtvRenderView.ISurfaceHolder mSurfaceHolder;
    public AtomicInteger mSurfaceKeyGen;
    private MgtvPlayerListener.OnSwitchSmoothSourceListener mSwitchSmoothSourceListener;
    public String mVideoIntroduction;
    public Set<MgtvPlayerListener.OnVideoPTSListener> ptsListeners;
    public Object ptsLocker;
    public String tsFlowTag;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class ABRegion {
        public int aPosMs;
        public int bPosMs;

        public ABRegion(int i, int i2) {
            this.aPosMs = i;
            this.bPosMs = i2;
        }

        public String toString() {
            return "Region{startMs=" + this.aPosMs + ", endMs=" + this.bPosMs + '}';
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum ReleaseReason {
        OUT,
        DEFAULT_INNER,
        PAUSE_DATA_BEFORE_PREPEAD
    }

    public MgtvAbstractVideoView(Context context) {
        super(context);
        this.mMediaPlayer = null;
        this.mRenderViewType = 0;
        this.mPrepared4StartMode = MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_DEFAULT;
        this.mFileStartTimeFloatS = -1.0f;
        this.mDnsFamilyType = 1;
        this.mKeyInfoSetEnable = true;
        this.mKeyInfoSetLayer = 0;
        this.mCurrentUri = null;
        this.mOnProvisionSuccessListener = new IDrmSession.OnProvisionSuccessListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.1
            @Override // com.hunantv.media.drm.IDrmSession.OnProvisionSuccessListener
            public void onSuccess(IDrmSession iDrmSession) {
                MgtvAbstractVideoView.this.mIsDrmPrepared = true;
                if (iDrmSession != null) {
                    iDrmSession.setDrmLicensePrepared();
                }
            }
        };
        this.mSurfaceHolder = null;
        this.mForceReuseTexture = false;
        this.mEnableTexture = true;
        this.mAMCKeyFrameBackMode = -1;
        this.mEnableMediacodecSW = false;
        this.mEnableImgoVsr = false;
        this.mAudioFocusObtained = false;
        this.mDataSourceType = MgtvMediaPlayer.DataSourceType.TYPE_DATASOUCE_DEFAULT;
        this.mMgtvFastMode = 1;
        this.mMediacodecRecreateformat = false;
        this.mMediacodecRecreateformatOnly4K = false;
        this.mEnableDefaultFileStartTime = true;
        this.mDataSourceInfo = new MgtvMediaPlayer.DataSourceInfo().setVideoFormat(MgtvMediaPlayer.DataSourceInfo.INIT_VALUE).setFileFormat(MgtvMediaPlayer.DataSourceInfo.INIT_VALUE).setBitRate("0");
        this.mSeekAutoStartAfterCompleteEnable = false;
        this.mJavaDnsEnable = false;
        this.mLastMediaMode = 0;
        this.mBackPlayEnable = false;
        this.mVideoIntroduction = "";
        this.mLiveLowLatencyEnable = false;
        this.mLeftVolume = -1.0f;
        this.mRightVolume = -1.0f;
        this.mReadDataSourceTypeConfig = 0;
        this.mAVPlayListener = new MgtvPlayerListener.OnAVPlayListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.2
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnAVPlayListener
            public void onAVPauseOrPlay(boolean z) {
                IVideoView.OnAVPlayListener onAVPlayListener = MgtvAbstractVideoView.this.mOnAVPlayListener;
                if (onAVPlayListener != null) {
                    onAVPlayListener.onAVPauseOrPlay(z);
                }
            }
        };
        this.mFrameListener = new MgtvPlayerListener.OnFrameListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnFrameListener
            public void onVFrameClockCome(MgtvPlayerListener.FrameClock frameClock) {
                IVideoView.OnFrameListener onFrameListener = MgtvAbstractVideoView.this.mOnFrameListener;
                if (onFrameListener != null) {
                    onFrameListener.onVFrameClockCome(frameClock);
                }
            }
        };
        this.mSwitchSmoothSourceListener = new MgtvPlayerListener.OnSwitchSmoothSourceListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceError(SmoothMediaSource smoothMediaSource, int i, int i2) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceError(smoothMediaSource, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceFail(SmoothMediaSource smoothMediaSource, int i, int i2) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceFail(smoothMediaSource, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceInfo(SmoothMediaSource smoothMediaSource, int i) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceInfo(smoothMediaSource, i);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceSuccess(SmoothMediaSource smoothMediaSource) {
                MgtvAbstractVideoView mgtvAbstractVideoView;
                MgtvAbstractVideoView mgtvAbstractVideoView2;
                if (smoothMediaSource != null) {
                    Uri uri = null;
                    if (StringUtil.isEmpty(smoothMediaSource.getUrl())) {
                        MgtvAbstractVideoView.this.mCurrentUri = null;
                    } else {
                        MgtvAbstractVideoView.this.mCurrentUri = Uri.parse(smoothMediaSource.getUrl().trim());
                    }
                    if (StringUtil.isEmpty(smoothMediaSource.getProxyUrl())) {
                        mgtvAbstractVideoView2 = MgtvAbstractVideoView.this;
                    } else {
                        mgtvAbstractVideoView2 = MgtvAbstractVideoView.this;
                        uri = Uri.parse(smoothMediaSource.getProxyUrl().trim());
                    }
                    mgtvAbstractVideoView2.mProxyUri = uri;
                    MgtvAbstractVideoView.this.mMainP2pTask = smoothMediaSource.getP2pTask();
                }
                DebugLog.i(MgtvAbstractVideoView.this.getLogTag(), "onSwitchSmoothSourceSuccess then change media mode");
                int i = 1;
                if (smoothMediaSource.getSwitchMod() == 1) {
                    mgtvAbstractVideoView = MgtvAbstractVideoView.this;
                } else {
                    mgtvAbstractVideoView = MgtvAbstractVideoView.this;
                    i = 0;
                }
                mgtvAbstractVideoView.setLastMediaMode(i);
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceSuccess(smoothMediaSource);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public boolean onSwitchSmoothSourceWillUpdate(SmoothMediaSource smoothMediaSource) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    return onSwitchSmoothSourceListener.onSwitchSmoothSourceWillUpdate(smoothMediaSource);
                }
                return false;
            }
        };
        this.mInfoStringListener = new MgtvPlayerListener.OnInfoStringListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.5
            /* JADX WARN: Removed duplicated region for block: B:18:0x007c  */
            /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnInfoStringListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onInfo(int r4, java.lang.String r5) {
                /*
                    r3 = this;
                    r0 = 2860(0xb2c, float:4.008E-42)
                    if (r4 == r0) goto L5c
                    r0 = 2870(0xb36, float:4.022E-42)
                    if (r4 == r0) goto L1e
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    java.lang.String r0 = r0.getLogTag()
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "OnInfoStringListener what: "
                    r1.append(r2)
                    r1.append(r4)
                    java.lang.String r2 = ", extra is "
                    goto L69
                L1e:
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    java.lang.String r0 = r0.getLogTag()
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "MEDIA_INFO_VIDEO_STREAM_CODEC_INFO: "
                    r1.append(r2)
                    r1.append(r5)
                    java.lang.String r1 = r1.toString()
                    com.hunantv.media.player.pragma.DebugLog.i(r0, r1)
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    com.hunantv.media.player.MgtvMediaPlayer r0 = r0.mMediaPlayer
                    if (r0 == 0) goto L76
                    boolean r0 = r0.isHDR()
                    if (r0 == 0) goto L76
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    int r1 = r0.mRenderViewType
                    if (r1 == 0) goto L76
                    java.lang.String r0 = r0.getLogTag()
                    java.lang.String r1 = "MEDIA_INFO_VIDEO_STREAM_CODEC_INFO check the source is HDR. try to change to surfaceview"
                    com.hunantv.media.player.pragma.DebugLog.i(r0, r1)
                    com.hunantv.media.widget.MgtvAbstractVideoView$5$1 r0 = new com.hunantv.media.widget.MgtvAbstractVideoView$5$1
                    r0.<init>()
                    com.hunantv.media.player.utils.ThreadUtil.postOnUiThread(r0)
                    goto L76
                L5c:
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    java.lang.String r0 = r0.getLogTag()
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "MEDIA_INFO_SEI_SYS_TIMESTAMP: "
                L69:
                    r1.append(r2)
                    r1.append(r5)
                    java.lang.String r1 = r1.toString()
                    com.hunantv.media.player.pragma.DebugLog.i(r0, r1)
                L76:
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    com.hunantv.media.widget.IVideoView$OnInfoStringListener r0 = r0.mOnInfoStringListener
                    if (r0 == 0) goto L7f
                    r0.onInfo(r4, r5)
                L7f:
                    r4 = 0
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvAbstractVideoView.AnonymousClass5.onInfo(int, java.lang.String):boolean");
            }
        };
        this.mSubtitleCallback = new ISubtitle.SubtitleCallback() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.6
            @Override // com.hunantv.media.widget.ISubtitle.SubtitleCallback
            public void onError(SubtitleSource subtitleSource) {
                if (MgtvAbstractVideoView.this.mOnSubtitleCallback != null) {
                    if (subtitleSource.getErrorResult().code == 0) {
                        subtitleSource.getErrorResult().code = -1;
                    }
                    MgtvAbstractVideoView.this.mOnSubtitleCallback.onError(subtitleSource);
                }
            }

            @Override // com.hunantv.media.widget.ISubtitle.SubtitleCallback
            public void onSuccess(SubtitleSource subtitleSource) {
                ISubtitle.SubtitleCallback subtitleCallback = MgtvAbstractVideoView.this.mOnSubtitleCallback;
                if (subtitleCallback != null) {
                    subtitleCallback.onSuccess(subtitleSource);
                }
            }
        };
        this.mPlayerEventListener = new MgtvPlayerListener.OnPlayerEventListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.7
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPlayerEventListener
            public void onInfo(int i, int i2) {
                String logTag = MgtvAbstractVideoView.this.getLogTag();
                DebugLog.d(logTag, "OnPlayerEventListener what:" + i + "-extra:" + i2);
                IVideoView.OnEventInfoListener onEventInfoListener = MgtvAbstractVideoView.this.mOnEventInfoListener;
                if (onEventInfoListener != null) {
                    onEventInfoListener.onInfo(i, i2);
                }
            }
        };
        this.mInitRenderViewType = 0;
        this.ptsListeners = new HashSet();
        this.ptsLocker = new Object();
        this.isBackground = false;
        this.mSurfaceKeyGen = new AtomicInteger(10);
        this.isRequestAudioFocus = true;
        init(context);
    }

    public MgtvAbstractVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMediaPlayer = null;
        this.mRenderViewType = 0;
        this.mPrepared4StartMode = MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_DEFAULT;
        this.mFileStartTimeFloatS = -1.0f;
        this.mDnsFamilyType = 1;
        this.mKeyInfoSetEnable = true;
        this.mKeyInfoSetLayer = 0;
        this.mCurrentUri = null;
        this.mOnProvisionSuccessListener = new IDrmSession.OnProvisionSuccessListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.1
            @Override // com.hunantv.media.drm.IDrmSession.OnProvisionSuccessListener
            public void onSuccess(IDrmSession iDrmSession) {
                MgtvAbstractVideoView.this.mIsDrmPrepared = true;
                if (iDrmSession != null) {
                    iDrmSession.setDrmLicensePrepared();
                }
            }
        };
        this.mSurfaceHolder = null;
        this.mForceReuseTexture = false;
        this.mEnableTexture = true;
        this.mAMCKeyFrameBackMode = -1;
        this.mEnableMediacodecSW = false;
        this.mEnableImgoVsr = false;
        this.mAudioFocusObtained = false;
        this.mDataSourceType = MgtvMediaPlayer.DataSourceType.TYPE_DATASOUCE_DEFAULT;
        this.mMgtvFastMode = 1;
        this.mMediacodecRecreateformat = false;
        this.mMediacodecRecreateformatOnly4K = false;
        this.mEnableDefaultFileStartTime = true;
        this.mDataSourceInfo = new MgtvMediaPlayer.DataSourceInfo().setVideoFormat(MgtvMediaPlayer.DataSourceInfo.INIT_VALUE).setFileFormat(MgtvMediaPlayer.DataSourceInfo.INIT_VALUE).setBitRate("0");
        this.mSeekAutoStartAfterCompleteEnable = false;
        this.mJavaDnsEnable = false;
        this.mLastMediaMode = 0;
        this.mBackPlayEnable = false;
        this.mVideoIntroduction = "";
        this.mLiveLowLatencyEnable = false;
        this.mLeftVolume = -1.0f;
        this.mRightVolume = -1.0f;
        this.mReadDataSourceTypeConfig = 0;
        this.mAVPlayListener = new MgtvPlayerListener.OnAVPlayListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.2
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnAVPlayListener
            public void onAVPauseOrPlay(boolean z) {
                IVideoView.OnAVPlayListener onAVPlayListener = MgtvAbstractVideoView.this.mOnAVPlayListener;
                if (onAVPlayListener != null) {
                    onAVPlayListener.onAVPauseOrPlay(z);
                }
            }
        };
        this.mFrameListener = new MgtvPlayerListener.OnFrameListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnFrameListener
            public void onVFrameClockCome(MgtvPlayerListener.FrameClock frameClock) {
                IVideoView.OnFrameListener onFrameListener = MgtvAbstractVideoView.this.mOnFrameListener;
                if (onFrameListener != null) {
                    onFrameListener.onVFrameClockCome(frameClock);
                }
            }
        };
        this.mSwitchSmoothSourceListener = new MgtvPlayerListener.OnSwitchSmoothSourceListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceError(SmoothMediaSource smoothMediaSource, int i, int i2) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceError(smoothMediaSource, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceFail(SmoothMediaSource smoothMediaSource, int i, int i2) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceFail(smoothMediaSource, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceInfo(SmoothMediaSource smoothMediaSource, int i) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceInfo(smoothMediaSource, i);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceSuccess(SmoothMediaSource smoothMediaSource) {
                MgtvAbstractVideoView mgtvAbstractVideoView;
                MgtvAbstractVideoView mgtvAbstractVideoView2;
                if (smoothMediaSource != null) {
                    Uri uri = null;
                    if (StringUtil.isEmpty(smoothMediaSource.getUrl())) {
                        MgtvAbstractVideoView.this.mCurrentUri = null;
                    } else {
                        MgtvAbstractVideoView.this.mCurrentUri = Uri.parse(smoothMediaSource.getUrl().trim());
                    }
                    if (StringUtil.isEmpty(smoothMediaSource.getProxyUrl())) {
                        mgtvAbstractVideoView2 = MgtvAbstractVideoView.this;
                    } else {
                        mgtvAbstractVideoView2 = MgtvAbstractVideoView.this;
                        uri = Uri.parse(smoothMediaSource.getProxyUrl().trim());
                    }
                    mgtvAbstractVideoView2.mProxyUri = uri;
                    MgtvAbstractVideoView.this.mMainP2pTask = smoothMediaSource.getP2pTask();
                }
                DebugLog.i(MgtvAbstractVideoView.this.getLogTag(), "onSwitchSmoothSourceSuccess then change media mode");
                int i = 1;
                if (smoothMediaSource.getSwitchMod() == 1) {
                    mgtvAbstractVideoView = MgtvAbstractVideoView.this;
                } else {
                    mgtvAbstractVideoView = MgtvAbstractVideoView.this;
                    i = 0;
                }
                mgtvAbstractVideoView.setLastMediaMode(i);
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceSuccess(smoothMediaSource);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public boolean onSwitchSmoothSourceWillUpdate(SmoothMediaSource smoothMediaSource) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    return onSwitchSmoothSourceListener.onSwitchSmoothSourceWillUpdate(smoothMediaSource);
                }
                return false;
            }
        };
        this.mInfoStringListener = new MgtvPlayerListener.OnInfoStringListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.5
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnInfoStringListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onInfo(int r4, java.lang.String r5) {
                /*
                    r3 = this;
                    r0 = 2860(0xb2c, float:4.008E-42)
                    if (r4 == r0) goto L5c
                    r0 = 2870(0xb36, float:4.022E-42)
                    if (r4 == r0) goto L1e
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    java.lang.String r0 = r0.getLogTag()
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "OnInfoStringListener what: "
                    r1.append(r2)
                    r1.append(r4)
                    java.lang.String r2 = ", extra is "
                    goto L69
                L1e:
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    java.lang.String r0 = r0.getLogTag()
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "MEDIA_INFO_VIDEO_STREAM_CODEC_INFO: "
                    r1.append(r2)
                    r1.append(r5)
                    java.lang.String r1 = r1.toString()
                    com.hunantv.media.player.pragma.DebugLog.i(r0, r1)
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    com.hunantv.media.player.MgtvMediaPlayer r0 = r0.mMediaPlayer
                    if (r0 == 0) goto L76
                    boolean r0 = r0.isHDR()
                    if (r0 == 0) goto L76
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    int r1 = r0.mRenderViewType
                    if (r1 == 0) goto L76
                    java.lang.String r0 = r0.getLogTag()
                    java.lang.String r1 = "MEDIA_INFO_VIDEO_STREAM_CODEC_INFO check the source is HDR. try to change to surfaceview"
                    com.hunantv.media.player.pragma.DebugLog.i(r0, r1)
                    com.hunantv.media.widget.MgtvAbstractVideoView$5$1 r0 = new com.hunantv.media.widget.MgtvAbstractVideoView$5$1
                    r0.<init>()
                    com.hunantv.media.player.utils.ThreadUtil.postOnUiThread(r0)
                    goto L76
                L5c:
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    java.lang.String r0 = r0.getLogTag()
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "MEDIA_INFO_SEI_SYS_TIMESTAMP: "
                L69:
                    r1.append(r2)
                    r1.append(r5)
                    java.lang.String r1 = r1.toString()
                    com.hunantv.media.player.pragma.DebugLog.i(r0, r1)
                L76:
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    com.hunantv.media.widget.IVideoView$OnInfoStringListener r0 = r0.mOnInfoStringListener
                    if (r0 == 0) goto L7f
                    r0.onInfo(r4, r5)
                L7f:
                    r4 = 0
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvAbstractVideoView.AnonymousClass5.onInfo(int, java.lang.String):boolean");
            }
        };
        this.mSubtitleCallback = new ISubtitle.SubtitleCallback() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.6
            @Override // com.hunantv.media.widget.ISubtitle.SubtitleCallback
            public void onError(SubtitleSource subtitleSource) {
                if (MgtvAbstractVideoView.this.mOnSubtitleCallback != null) {
                    if (subtitleSource.getErrorResult().code == 0) {
                        subtitleSource.getErrorResult().code = -1;
                    }
                    MgtvAbstractVideoView.this.mOnSubtitleCallback.onError(subtitleSource);
                }
            }

            @Override // com.hunantv.media.widget.ISubtitle.SubtitleCallback
            public void onSuccess(SubtitleSource subtitleSource) {
                ISubtitle.SubtitleCallback subtitleCallback = MgtvAbstractVideoView.this.mOnSubtitleCallback;
                if (subtitleCallback != null) {
                    subtitleCallback.onSuccess(subtitleSource);
                }
            }
        };
        this.mPlayerEventListener = new MgtvPlayerListener.OnPlayerEventListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.7
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPlayerEventListener
            public void onInfo(int i, int i2) {
                String logTag = MgtvAbstractVideoView.this.getLogTag();
                DebugLog.d(logTag, "OnPlayerEventListener what:" + i + "-extra:" + i2);
                IVideoView.OnEventInfoListener onEventInfoListener = MgtvAbstractVideoView.this.mOnEventInfoListener;
                if (onEventInfoListener != null) {
                    onEventInfoListener.onInfo(i, i2);
                }
            }
        };
        this.mInitRenderViewType = 0;
        this.ptsListeners = new HashSet();
        this.ptsLocker = new Object();
        this.isBackground = false;
        this.mSurfaceKeyGen = new AtomicInteger(10);
        this.isRequestAudioFocus = true;
        init(context);
    }

    public MgtvAbstractVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMediaPlayer = null;
        this.mRenderViewType = 0;
        this.mPrepared4StartMode = MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_DEFAULT;
        this.mFileStartTimeFloatS = -1.0f;
        this.mDnsFamilyType = 1;
        this.mKeyInfoSetEnable = true;
        this.mKeyInfoSetLayer = 0;
        this.mCurrentUri = null;
        this.mOnProvisionSuccessListener = new IDrmSession.OnProvisionSuccessListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.1
            @Override // com.hunantv.media.drm.IDrmSession.OnProvisionSuccessListener
            public void onSuccess(IDrmSession iDrmSession) {
                MgtvAbstractVideoView.this.mIsDrmPrepared = true;
                if (iDrmSession != null) {
                    iDrmSession.setDrmLicensePrepared();
                }
            }
        };
        this.mSurfaceHolder = null;
        this.mForceReuseTexture = false;
        this.mEnableTexture = true;
        this.mAMCKeyFrameBackMode = -1;
        this.mEnableMediacodecSW = false;
        this.mEnableImgoVsr = false;
        this.mAudioFocusObtained = false;
        this.mDataSourceType = MgtvMediaPlayer.DataSourceType.TYPE_DATASOUCE_DEFAULT;
        this.mMgtvFastMode = 1;
        this.mMediacodecRecreateformat = false;
        this.mMediacodecRecreateformatOnly4K = false;
        this.mEnableDefaultFileStartTime = true;
        this.mDataSourceInfo = new MgtvMediaPlayer.DataSourceInfo().setVideoFormat(MgtvMediaPlayer.DataSourceInfo.INIT_VALUE).setFileFormat(MgtvMediaPlayer.DataSourceInfo.INIT_VALUE).setBitRate("0");
        this.mSeekAutoStartAfterCompleteEnable = false;
        this.mJavaDnsEnable = false;
        this.mLastMediaMode = 0;
        this.mBackPlayEnable = false;
        this.mVideoIntroduction = "";
        this.mLiveLowLatencyEnable = false;
        this.mLeftVolume = -1.0f;
        this.mRightVolume = -1.0f;
        this.mReadDataSourceTypeConfig = 0;
        this.mAVPlayListener = new MgtvPlayerListener.OnAVPlayListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.2
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnAVPlayListener
            public void onAVPauseOrPlay(boolean z) {
                IVideoView.OnAVPlayListener onAVPlayListener = MgtvAbstractVideoView.this.mOnAVPlayListener;
                if (onAVPlayListener != null) {
                    onAVPlayListener.onAVPauseOrPlay(z);
                }
            }
        };
        this.mFrameListener = new MgtvPlayerListener.OnFrameListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnFrameListener
            public void onVFrameClockCome(MgtvPlayerListener.FrameClock frameClock) {
                IVideoView.OnFrameListener onFrameListener = MgtvAbstractVideoView.this.mOnFrameListener;
                if (onFrameListener != null) {
                    onFrameListener.onVFrameClockCome(frameClock);
                }
            }
        };
        this.mSwitchSmoothSourceListener = new MgtvPlayerListener.OnSwitchSmoothSourceListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceError(SmoothMediaSource smoothMediaSource, int i2, int i22) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceError(smoothMediaSource, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceFail(SmoothMediaSource smoothMediaSource, int i2, int i22) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceFail(smoothMediaSource, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceInfo(SmoothMediaSource smoothMediaSource, int i2) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceInfo(smoothMediaSource, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceSuccess(SmoothMediaSource smoothMediaSource) {
                MgtvAbstractVideoView mgtvAbstractVideoView;
                MgtvAbstractVideoView mgtvAbstractVideoView2;
                if (smoothMediaSource != null) {
                    Uri uri = null;
                    if (StringUtil.isEmpty(smoothMediaSource.getUrl())) {
                        MgtvAbstractVideoView.this.mCurrentUri = null;
                    } else {
                        MgtvAbstractVideoView.this.mCurrentUri = Uri.parse(smoothMediaSource.getUrl().trim());
                    }
                    if (StringUtil.isEmpty(smoothMediaSource.getProxyUrl())) {
                        mgtvAbstractVideoView2 = MgtvAbstractVideoView.this;
                    } else {
                        mgtvAbstractVideoView2 = MgtvAbstractVideoView.this;
                        uri = Uri.parse(smoothMediaSource.getProxyUrl().trim());
                    }
                    mgtvAbstractVideoView2.mProxyUri = uri;
                    MgtvAbstractVideoView.this.mMainP2pTask = smoothMediaSource.getP2pTask();
                }
                DebugLog.i(MgtvAbstractVideoView.this.getLogTag(), "onSwitchSmoothSourceSuccess then change media mode");
                int i2 = 1;
                if (smoothMediaSource.getSwitchMod() == 1) {
                    mgtvAbstractVideoView = MgtvAbstractVideoView.this;
                } else {
                    mgtvAbstractVideoView = MgtvAbstractVideoView.this;
                    i2 = 0;
                }
                mgtvAbstractVideoView.setLastMediaMode(i2);
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceSuccess(smoothMediaSource);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public boolean onSwitchSmoothSourceWillUpdate(SmoothMediaSource smoothMediaSource) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    return onSwitchSmoothSourceListener.onSwitchSmoothSourceWillUpdate(smoothMediaSource);
                }
                return false;
            }
        };
        this.mInfoStringListener = new MgtvPlayerListener.OnInfoStringListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.5
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnInfoStringListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onInfo(int r4, java.lang.String r5) {
                /*
                    r3 = this;
                    r0 = 2860(0xb2c, float:4.008E-42)
                    if (r4 == r0) goto L5c
                    r0 = 2870(0xb36, float:4.022E-42)
                    if (r4 == r0) goto L1e
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    java.lang.String r0 = r0.getLogTag()
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "OnInfoStringListener what: "
                    r1.append(r2)
                    r1.append(r4)
                    java.lang.String r2 = ", extra is "
                    goto L69
                L1e:
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    java.lang.String r0 = r0.getLogTag()
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "MEDIA_INFO_VIDEO_STREAM_CODEC_INFO: "
                    r1.append(r2)
                    r1.append(r5)
                    java.lang.String r1 = r1.toString()
                    com.hunantv.media.player.pragma.DebugLog.i(r0, r1)
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    com.hunantv.media.player.MgtvMediaPlayer r0 = r0.mMediaPlayer
                    if (r0 == 0) goto L76
                    boolean r0 = r0.isHDR()
                    if (r0 == 0) goto L76
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    int r1 = r0.mRenderViewType
                    if (r1 == 0) goto L76
                    java.lang.String r0 = r0.getLogTag()
                    java.lang.String r1 = "MEDIA_INFO_VIDEO_STREAM_CODEC_INFO check the source is HDR. try to change to surfaceview"
                    com.hunantv.media.player.pragma.DebugLog.i(r0, r1)
                    com.hunantv.media.widget.MgtvAbstractVideoView$5$1 r0 = new com.hunantv.media.widget.MgtvAbstractVideoView$5$1
                    r0.<init>()
                    com.hunantv.media.player.utils.ThreadUtil.postOnUiThread(r0)
                    goto L76
                L5c:
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    java.lang.String r0 = r0.getLogTag()
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "MEDIA_INFO_SEI_SYS_TIMESTAMP: "
                L69:
                    r1.append(r2)
                    r1.append(r5)
                    java.lang.String r1 = r1.toString()
                    com.hunantv.media.player.pragma.DebugLog.i(r0, r1)
                L76:
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    com.hunantv.media.widget.IVideoView$OnInfoStringListener r0 = r0.mOnInfoStringListener
                    if (r0 == 0) goto L7f
                    r0.onInfo(r4, r5)
                L7f:
                    r4 = 0
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvAbstractVideoView.AnonymousClass5.onInfo(int, java.lang.String):boolean");
            }
        };
        this.mSubtitleCallback = new ISubtitle.SubtitleCallback() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.6
            @Override // com.hunantv.media.widget.ISubtitle.SubtitleCallback
            public void onError(SubtitleSource subtitleSource) {
                if (MgtvAbstractVideoView.this.mOnSubtitleCallback != null) {
                    if (subtitleSource.getErrorResult().code == 0) {
                        subtitleSource.getErrorResult().code = -1;
                    }
                    MgtvAbstractVideoView.this.mOnSubtitleCallback.onError(subtitleSource);
                }
            }

            @Override // com.hunantv.media.widget.ISubtitle.SubtitleCallback
            public void onSuccess(SubtitleSource subtitleSource) {
                ISubtitle.SubtitleCallback subtitleCallback = MgtvAbstractVideoView.this.mOnSubtitleCallback;
                if (subtitleCallback != null) {
                    subtitleCallback.onSuccess(subtitleSource);
                }
            }
        };
        this.mPlayerEventListener = new MgtvPlayerListener.OnPlayerEventListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.7
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPlayerEventListener
            public void onInfo(int i2, int i22) {
                String logTag = MgtvAbstractVideoView.this.getLogTag();
                DebugLog.d(logTag, "OnPlayerEventListener what:" + i2 + "-extra:" + i22);
                IVideoView.OnEventInfoListener onEventInfoListener = MgtvAbstractVideoView.this.mOnEventInfoListener;
                if (onEventInfoListener != null) {
                    onEventInfoListener.onInfo(i2, i22);
                }
            }
        };
        this.mInitRenderViewType = 0;
        this.ptsListeners = new HashSet();
        this.ptsLocker = new Object();
        this.isBackground = false;
        this.mSurfaceKeyGen = new AtomicInteger(10);
        this.isRequestAudioFocus = true;
        init(context);
    }

    public MgtvAbstractVideoView(Context context, IVideoView.Configuration configuration) {
        super(context);
        this.mMediaPlayer = null;
        this.mRenderViewType = 0;
        this.mPrepared4StartMode = MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_DEFAULT;
        this.mFileStartTimeFloatS = -1.0f;
        this.mDnsFamilyType = 1;
        this.mKeyInfoSetEnable = true;
        this.mKeyInfoSetLayer = 0;
        this.mCurrentUri = null;
        this.mOnProvisionSuccessListener = new IDrmSession.OnProvisionSuccessListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.1
            @Override // com.hunantv.media.drm.IDrmSession.OnProvisionSuccessListener
            public void onSuccess(IDrmSession iDrmSession) {
                MgtvAbstractVideoView.this.mIsDrmPrepared = true;
                if (iDrmSession != null) {
                    iDrmSession.setDrmLicensePrepared();
                }
            }
        };
        this.mSurfaceHolder = null;
        this.mForceReuseTexture = false;
        this.mEnableTexture = true;
        this.mAMCKeyFrameBackMode = -1;
        this.mEnableMediacodecSW = false;
        this.mEnableImgoVsr = false;
        this.mAudioFocusObtained = false;
        this.mDataSourceType = MgtvMediaPlayer.DataSourceType.TYPE_DATASOUCE_DEFAULT;
        this.mMgtvFastMode = 1;
        this.mMediacodecRecreateformat = false;
        this.mMediacodecRecreateformatOnly4K = false;
        this.mEnableDefaultFileStartTime = true;
        this.mDataSourceInfo = new MgtvMediaPlayer.DataSourceInfo().setVideoFormat(MgtvMediaPlayer.DataSourceInfo.INIT_VALUE).setFileFormat(MgtvMediaPlayer.DataSourceInfo.INIT_VALUE).setBitRate("0");
        this.mSeekAutoStartAfterCompleteEnable = false;
        this.mJavaDnsEnable = false;
        this.mLastMediaMode = 0;
        this.mBackPlayEnable = false;
        this.mVideoIntroduction = "";
        this.mLiveLowLatencyEnable = false;
        this.mLeftVolume = -1.0f;
        this.mRightVolume = -1.0f;
        this.mReadDataSourceTypeConfig = 0;
        this.mAVPlayListener = new MgtvPlayerListener.OnAVPlayListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.2
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnAVPlayListener
            public void onAVPauseOrPlay(boolean z) {
                IVideoView.OnAVPlayListener onAVPlayListener = MgtvAbstractVideoView.this.mOnAVPlayListener;
                if (onAVPlayListener != null) {
                    onAVPlayListener.onAVPauseOrPlay(z);
                }
            }
        };
        this.mFrameListener = new MgtvPlayerListener.OnFrameListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnFrameListener
            public void onVFrameClockCome(MgtvPlayerListener.FrameClock frameClock) {
                IVideoView.OnFrameListener onFrameListener = MgtvAbstractVideoView.this.mOnFrameListener;
                if (onFrameListener != null) {
                    onFrameListener.onVFrameClockCome(frameClock);
                }
            }
        };
        this.mSwitchSmoothSourceListener = new MgtvPlayerListener.OnSwitchSmoothSourceListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceError(SmoothMediaSource smoothMediaSource, int i2, int i22) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceError(smoothMediaSource, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceFail(SmoothMediaSource smoothMediaSource, int i2, int i22) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceFail(smoothMediaSource, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceInfo(SmoothMediaSource smoothMediaSource, int i2) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceInfo(smoothMediaSource, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceSuccess(SmoothMediaSource smoothMediaSource) {
                MgtvAbstractVideoView mgtvAbstractVideoView;
                MgtvAbstractVideoView mgtvAbstractVideoView2;
                if (smoothMediaSource != null) {
                    Uri uri = null;
                    if (StringUtil.isEmpty(smoothMediaSource.getUrl())) {
                        MgtvAbstractVideoView.this.mCurrentUri = null;
                    } else {
                        MgtvAbstractVideoView.this.mCurrentUri = Uri.parse(smoothMediaSource.getUrl().trim());
                    }
                    if (StringUtil.isEmpty(smoothMediaSource.getProxyUrl())) {
                        mgtvAbstractVideoView2 = MgtvAbstractVideoView.this;
                    } else {
                        mgtvAbstractVideoView2 = MgtvAbstractVideoView.this;
                        uri = Uri.parse(smoothMediaSource.getProxyUrl().trim());
                    }
                    mgtvAbstractVideoView2.mProxyUri = uri;
                    MgtvAbstractVideoView.this.mMainP2pTask = smoothMediaSource.getP2pTask();
                }
                DebugLog.i(MgtvAbstractVideoView.this.getLogTag(), "onSwitchSmoothSourceSuccess then change media mode");
                int i2 = 1;
                if (smoothMediaSource.getSwitchMod() == 1) {
                    mgtvAbstractVideoView = MgtvAbstractVideoView.this;
                } else {
                    mgtvAbstractVideoView = MgtvAbstractVideoView.this;
                    i2 = 0;
                }
                mgtvAbstractVideoView.setLastMediaMode(i2);
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceSuccess(smoothMediaSource);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public boolean onSwitchSmoothSourceWillUpdate(SmoothMediaSource smoothMediaSource) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    return onSwitchSmoothSourceListener.onSwitchSmoothSourceWillUpdate(smoothMediaSource);
                }
                return false;
            }
        };
        this.mInfoStringListener = new MgtvPlayerListener.OnInfoStringListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.5
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnInfoStringListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onInfo(int r4, java.lang.String r5) {
                /*
                    r3 = this;
                    r0 = 2860(0xb2c, float:4.008E-42)
                    if (r4 == r0) goto L5c
                    r0 = 2870(0xb36, float:4.022E-42)
                    if (r4 == r0) goto L1e
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    java.lang.String r0 = r0.getLogTag()
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "OnInfoStringListener what: "
                    r1.append(r2)
                    r1.append(r4)
                    java.lang.String r2 = ", extra is "
                    goto L69
                L1e:
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    java.lang.String r0 = r0.getLogTag()
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "MEDIA_INFO_VIDEO_STREAM_CODEC_INFO: "
                    r1.append(r2)
                    r1.append(r5)
                    java.lang.String r1 = r1.toString()
                    com.hunantv.media.player.pragma.DebugLog.i(r0, r1)
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    com.hunantv.media.player.MgtvMediaPlayer r0 = r0.mMediaPlayer
                    if (r0 == 0) goto L76
                    boolean r0 = r0.isHDR()
                    if (r0 == 0) goto L76
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    int r1 = r0.mRenderViewType
                    if (r1 == 0) goto L76
                    java.lang.String r0 = r0.getLogTag()
                    java.lang.String r1 = "MEDIA_INFO_VIDEO_STREAM_CODEC_INFO check the source is HDR. try to change to surfaceview"
                    com.hunantv.media.player.pragma.DebugLog.i(r0, r1)
                    com.hunantv.media.widget.MgtvAbstractVideoView$5$1 r0 = new com.hunantv.media.widget.MgtvAbstractVideoView$5$1
                    r0.<init>()
                    com.hunantv.media.player.utils.ThreadUtil.postOnUiThread(r0)
                    goto L76
                L5c:
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    java.lang.String r0 = r0.getLogTag()
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "MEDIA_INFO_SEI_SYS_TIMESTAMP: "
                L69:
                    r1.append(r2)
                    r1.append(r5)
                    java.lang.String r1 = r1.toString()
                    com.hunantv.media.player.pragma.DebugLog.i(r0, r1)
                L76:
                    com.hunantv.media.widget.MgtvAbstractVideoView r0 = com.hunantv.media.widget.MgtvAbstractVideoView.this
                    com.hunantv.media.widget.IVideoView$OnInfoStringListener r0 = r0.mOnInfoStringListener
                    if (r0 == 0) goto L7f
                    r0.onInfo(r4, r5)
                L7f:
                    r4 = 0
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.widget.MgtvAbstractVideoView.AnonymousClass5.onInfo(int, java.lang.String):boolean");
            }
        };
        this.mSubtitleCallback = new ISubtitle.SubtitleCallback() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.6
            @Override // com.hunantv.media.widget.ISubtitle.SubtitleCallback
            public void onError(SubtitleSource subtitleSource) {
                if (MgtvAbstractVideoView.this.mOnSubtitleCallback != null) {
                    if (subtitleSource.getErrorResult().code == 0) {
                        subtitleSource.getErrorResult().code = -1;
                    }
                    MgtvAbstractVideoView.this.mOnSubtitleCallback.onError(subtitleSource);
                }
            }

            @Override // com.hunantv.media.widget.ISubtitle.SubtitleCallback
            public void onSuccess(SubtitleSource subtitleSource) {
                ISubtitle.SubtitleCallback subtitleCallback = MgtvAbstractVideoView.this.mOnSubtitleCallback;
                if (subtitleCallback != null) {
                    subtitleCallback.onSuccess(subtitleSource);
                }
            }
        };
        this.mPlayerEventListener = new MgtvPlayerListener.OnPlayerEventListener() { // from class: com.hunantv.media.widget.MgtvAbstractVideoView.7
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPlayerEventListener
            public void onInfo(int i2, int i22) {
                String logTag = MgtvAbstractVideoView.this.getLogTag();
                DebugLog.d(logTag, "OnPlayerEventListener what:" + i2 + "-extra:" + i22);
                IVideoView.OnEventInfoListener onEventInfoListener = MgtvAbstractVideoView.this.mOnEventInfoListener;
                if (onEventInfoListener != null) {
                    onEventInfoListener.onInfo(i2, i22);
                }
            }
        };
        this.mInitRenderViewType = 0;
        this.ptsListeners = new HashSet();
        this.ptsLocker = new Object();
        this.isBackground = false;
        this.mSurfaceKeyGen = new AtomicInteger(10);
        this.isRequestAudioFocus = true;
        init(context);
        this.mConfiguration = configuration;
        if (configuration != null) {
            this.mForceReuseTexture = configuration.forceReuseTexture;
        }
    }

    private boolean disableMediaCodecSW(boolean z) {
        String cputy = NetPlayConfigHelper.getCputy();
        boolean z2 = !enalbeCodecSWForvivo() || (cputy.contains("sm8250") && g.z());
        if (z && cputy.contains("kirin659")) {
            return true;
        }
        return z2;
    }

    private boolean enalbeCodecSWForvivo() {
        if (g.C()) {
            String cputy = NetPlayConfigHelper.getCputy();
            String mod = NetPlayConfigHelper.getMod();
            String funtouchOSVersion = AndroidOSUtils.getFuntouchOSVersion();
            int i = Build.VERSION.SDK_INT;
            String[] split = funtouchOSVersion.split("_");
            String str = "0";
            if (split != null && split.length == 4) {
                String str2 = split[3];
                if (str2 != null) {
                    String logTag = getLogTag();
                    DebugLog.i(logTag, "enalbeCodecSWForvivo ver:" + str2 + ", " + str2.compareTo("0"));
                }
                str = str2;
            }
            if (cputy.contains("sm8250") && i == 33) {
                if (str != null && !str.contains("unknown")) {
                    if (mod.equalsIgnoreCase("V2244A") && str.compareTo("13.0.8.4") >= 0) {
                        return true;
                    }
                    if (mod.equalsIgnoreCase("V2199A") && str.compareTo("13.1.5.2.W10.V000L1") >= 0) {
                        return true;
                    }
                    if (mod.equalsIgnoreCase("V2157A") && str.compareTo("8.6.0") >= 0) {
                        return true;
                    }
                    if (mod.equalsIgnoreCase("V2118A") && str.compareTo("8.5.0") >= 0) {
                        return true;
                    }
                    if (mod.equalsIgnoreCase("V2055A") && str.compareTo("8.11.5") >= 0) {
                        return true;
                    }
                    if (mod.equalsIgnoreCase("V2203A") && str.compareTo("13.1.12.5.W10.V000L1") >= 0) {
                        return true;
                    }
                    if (mod.equalsIgnoreCase("V2073A") && str.compareTo("8.1.12") >= 0) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    private void init(Context context) {
        this.mContext = context;
        this.mDecorateLayout = new FrameLayout(context);
        this.mDecorateLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        this.mDecorateLayout.setVisibility(8);
    }

    private void setKeyInfoDataInner(byte[] bArr) {
        DebugLog.i(getLogTag(), "setKeyInfoDataInner in");
        if (this.mMediaPlayer != null) {
            ReportParams reportParams = this.mReportParams;
            int isKeyFrameDataValid = KeyFrameInfoUtils.isKeyFrameDataValid(bArr, reportParams != null ? reportParams.getVideoFileHash() : null);
            this.mKeyInfoRet = isKeyFrameDataValid;
            if (isKeyFrameDataValid == 0) {
                this.mKeyInfoSetLayer = 2;
                this.mKeyInfoRet = this.mMediaPlayer.setKeyFrameInfoFileBuf(this.mKeyInfoData);
            }
            updateKeyInfoReport();
        }
        DebugLog.i(getLogTag(), "setKeyInfoDataInner out");
    }

    private void updateKeyInfoReport() {
        ReportParams reportParams = this.mReportParams;
        if (reportParams != null) {
            reportParams.getKeyInfo().keyInfoSet = this.mKeyInfoSet;
            this.mReportParams.getKeyInfo().keyInfoRet = this.mKeyInfoRet;
            this.mReportParams.getKeyInfo().keyInfoSetLayer = this.mKeyInfoSetLayer;
        }
    }

    public void abandonAudioFocus() {
        if (this.mAudioFocusObtained) {
            AudioUtil.abandonAudioFocus(this.mContext);
            this.mAudioFocusObtained = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addDecorateLayout() {
        FrameLayout frameLayout = this.mDecorateLayout;
        if (frameLayout == null || ViewUtil.isViewExsit(this, frameLayout)) {
            return;
        }
        addView(this.mDecorateLayout);
    }

    public void addSubtitleView() {
        if (this.mIsSubtitleEnable) {
            if (this.mSubtitleView == null) {
                this.mSubtitleView = new SubtitleView(this.mContext);
                if (Build.VERSION.SDK_INT >= 19) {
                    CaptioningManager captioningManager = (CaptioningManager) this.mContext.getSystemService("captioning");
                    a a = a.a(captioningManager.getUserStyle());
                    if (captioningManager.isEnabled()) {
                        this.mSubtitleView.setStyle(a);
                        this.mSubtitleView.setUserDefaultTextSize();
                    }
                }
            }
            this.mSubtitleView.setVisible(this.mIsSubtitleEnable);
            FrameLayout frameLayout = this.mDecorateLayout;
            if (frameLayout == null || ViewUtil.isViewExsit(frameLayout, this.mSubtitleView)) {
                return;
            }
            this.mDecorateLayout.addView(this.mSubtitleView);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void addVideoPTSListener(MgtvPlayerListener.OnVideoPTSListener onVideoPTSListener) {
        synchronized (this.ptsLocker) {
            this.ptsListeners.add(onVideoPTSListener);
            MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
            if (mgtvMediaPlayer != null) {
                mgtvMediaPlayer.addVideoPTSListener(onVideoPTSListener);
            }
        }
    }

    public void afterRelease() {
        DebugPanel debugPanel = this.mDebugPanel;
        if (debugPanel != null) {
            debugPanel.release();
        }
    }

    public void beforeOpenVideo() {
        ReportParams reportParams;
        try {
            String str = this.mVideoIntroduction;
            int i = 1;
            boolean z = (str != null && str.matches("FFF2[0-9]222")) || !((reportParams = this.mReportParams) == null || reportParams.getSvds() == null || !this.mReportParams.getSvds().matches("FFF2[0-9]222"));
            int i2 = this.mRenderViewType;
            if (i2 != 0 && z) {
                DebugLog.i(getLogTag(), "beforeOpenVideo check the source is HDR. try to change to surfaceview");
                toggleRenders(0);
            } else if (!z && this.mInitRenderViewType != i2) {
                String logTag = getLogTag();
                DebugLog.i(logTag, "beforeOpenVideo check the source is not HDR. recovery renderview to " + this.mInitRenderViewType);
                toggleRenders(this.mInitRenderViewType);
            }
            ReportParams reportParams2 = this.mReportParams;
            if (reportParams2 != null) {
                if (this.mRenderViewType != 1) {
                    i = 0;
                }
                reportParams2.setRenvtp(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void bindDrmSession(IDrmSession iDrmSession) {
        this.mDrmSession = iDrmSession;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.bindDrmSession(iDrmSession);
        }
        IDrmSession iDrmSession2 = this.mDrmSession;
        if (iDrmSession2 != null) {
            if (iDrmSession2.getCurrentStatus() == 2) {
                this.mIsDrmPrepared = true;
                this.mDrmSession.setDrmLicensePrepared();
            }
            this.mDrmSession.addOnProvisionSuccessListener(this.mOnProvisionSuccessListener);
        }
    }

    public void configAudioImgoPlayer() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setPreBufferTimeoutMs(this.mPreBufferTimeoutMs);
            this.mMediaPlayer.setPrepared4StartMode(this.mPrepared4StartMode);
            this.mMediaPlayer.setForceHttpDns(this.mForceHttpDns);
            this.mMediaPlayer.setDnsFamilyType(this.mDnsFamilyType);
            this.mMediaPlayer.setNetPlayConfig(this.mNetPlayConfig);
            this.mMediaPlayer.setMgtvFastMode(this.mMgtvFastMode);
            this.mMediaPlayer.setDataSourceInfo(this.mDataSourceInfo);
            setLoopABPlay(this.mLoopABPlayEnable, this.mABRegion);
            this.mMediaPlayer.setTsFlowTag(this.tsFlowTag);
            setBackground(this.isBackground);
            this.mMediaPlayer.setWanosAudioEffectConfig(this.mAudioEffectConfig);
            this.mMediaPlayer.setDrmInfoList(this.mDrmInfoList);
            this.mMediaPlayer.enableFramePTSNotify(this.mEnableFramePTSNotify);
            String logTag = getLogTag();
            DebugLog.i(logTag, "configImgoPlayer -mPrepared4StartMode:" + this.mPrepared4StartMode + "-mForceHttpDns:" + this.mForceHttpDns + "-mEnableVideoStartTime:" + this.mEnableVideoStartTime + "-mDnsFamilyType:" + this.mDnsFamilyType + "-mAMCKeyFrameBackMode:" + this.mAMCKeyFrameBackMode + "-mFileStartTimeFloatS:" + this.mFileStartTimeFloatS + "-mMgtvFastMode:" + this.mMgtvFastMode + "-mDataSourceInfo:" + this.mDataSourceInfo + "-mPreBufferTimeoutMs:" + this.mPreBufferTimeoutMs + "-isBackground:" + this.isBackground + "-mEnableFramePTSNotify:" + this.mEnableFramePTSNotify);
        }
    }

    public void configImgoPlayer() {
        IDrmSession iDrmSession;
        MgtvMediaPlayer.DataSourceInfo dataSourceInfo;
        float f;
        ReportParams reportParams;
        SubtitleSource subtitleSource;
        if (isReuseTextureDisable()) {
            this.mAMCKeyFrameBackMode = 2;
        }
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setPreBufferTimeoutMs(this.mPreBufferTimeoutMs);
            if (this.mIsSubtitleEnable && (subtitleSource = this.mSubtitleSource) != null) {
                try {
                    this.mMediaPlayer.addSubtitleSource(this.mSubtitleView, subtitleSource);
                } catch (Exception unused) {
                    this.mSubtitleCallback.onError(this.mSubtitleSource);
                }
            }
            this.mMediaPlayer.setPrepared4StartMode(this.mPrepared4StartMode);
            boolean z = false;
            if (this.mPrepared4StartMode == MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_LOADDATA_DISAV) {
                this.mMediaPlayer.setDisableAVDecoderStart(true);
            } else {
                this.mMediaPlayer.setDisableAVDecoderStart(false);
            }
            this.mMediaPlayer.setForceHttpDns(this.mForceHttpDns);
            this.mMediaPlayer.setEnableVideoStartTime(this.mEnableVideoStartTime);
            this.mMediaPlayer.setDnsFamilyType(this.mDnsFamilyType);
            int i = this.mAMCKeyFrameBackMode;
            if (i >= 0) {
                this.mMediaPlayer.setAMCKeyFrameBackMode(i);
            }
            if (!Constants.FOR_OTT) {
                ReportParams reportParams2 = this.mReportParams;
                boolean z2 = reportParams2 != null && (reportParams2.getVideoType() == ReportParams.VideoType.IMMERSIVE || this.mReportParams.getVideoType() == ReportParams.VideoType.VOD);
                if (g.g() && !disableMediaCodecSW(z2)) {
                    z = true;
                }
                if (NetPlayConfig.isCodecSWRenderOpen() && z2 && z && (!NetPlayConfig.isOppoSrOpen() || (!g.p(this.mContext) && !g.n(this.mContext)))) {
                    this.mEnableMediacodecSW = true;
                }
                if (NetPlayConfig.isImgoVsrEnable() && (reportParams = this.mReportParams) != null && reportParams.getVideoType() == ReportParams.VideoType.VOD && z) {
                    this.mEnableImgoVsr = true;
                }
                ReportParams reportParams3 = this.mReportParams;
                if (reportParams3 != null && reportParams3.getVideoType() == ReportParams.VideoType.TRY_WATCHING && !StringUtil.isEmpty(this.mReportParams.getPlayPreviewType()) && (this.mReportParams.getPlayPreviewType().equals("1") || this.mReportParams.getPlayPreviewType().equals("2"))) {
                    this.mMediaPlayer.setConfig(2016021706, 2);
                }
            }
            this.mMediaPlayer.setEnableMediacodecSWRender(this.mEnableMediacodecSW);
            this.mMediaPlayer.setMarkMediacodecSWRender(NetPlayConfig.isCodecSWRenderMark());
            this.mMediaPlayer.setEnableImgoVsr(this.mEnableImgoVsr);
            this.mMediaPlayer.setNetPlayConfig(this.mNetPlayConfig);
            this.mMediaPlayer.setMgtvFastMode(this.mMgtvFastMode);
            this.mMediaPlayer.setMediacodecRecreateformat(this.mMediacodecRecreateformat, this.mMediacodecRecreateformatOnly4K);
            if (this.mFileStartTimeFloatS == -1.0f && this.mEnableDefaultFileStartTime && (dataSourceInfo = this.mDataSourceInfo) != null) {
                if (MgtvMediaPlayer.DataSourceInfo.H265.equalsIgnoreCase(dataSourceInfo.getVideoFormat())) {
                    f = 0.08f;
                } else {
                    f = MgtvMediaPlayer.DataSourceInfo.H264.equalsIgnoreCase(this.mDataSourceInfo.getVideoFormat()) ? 1.48f : 1.48f;
                }
                this.mFileStartTimeFloatS = f;
            }
            this.mMediaPlayer.setPlayerFileStartTimeFloatS(this.mFileStartTimeFloatS);
            if (this.mKeyInfoSet && this.mKeyInfoRet == 0) {
                setKeyInfoDataInner(this.mKeyInfoData);
            }
            this.mMediaPlayer.setDataSourceInfo(this.mDataSourceInfo);
            this.mMediaPlayer.bindDrmSession(this.mDrmSession);
            if (this.mIsDrmPrepared && (iDrmSession = this.mDrmSession) != null) {
                iDrmSession.setDrmLicensePrepared();
            }
            setLoopABPlay(this.mLoopABPlayEnable, this.mABRegion);
            this.mMediaPlayer.setSeekAutoStartAfterComplete(this.mSeekAutoStartAfterCompleteEnable);
            enableLiveLowLatency(this.mLiveLowLatencyEnable);
            this.mMediaPlayer.setTsFlowTag(this.tsFlowTag);
            setBackground(this.isBackground);
            this.mMediaPlayer.setWanosAudioEffectConfig(this.mAudioEffectConfig);
            this.mMediaPlayer.setDrmInfoList(this.mDrmInfoList);
            String logTag = getLogTag();
            DebugLog.i(logTag, "configImgoPlayer -mPrepared4StartMode:" + this.mPrepared4StartMode + "-mForceHttpDns:" + this.mForceHttpDns + "-mEnableVideoStartTime:" + this.mEnableVideoStartTime + "-mDnsFamilyType:" + this.mDnsFamilyType + "-mAMCKeyFrameBackMode:" + this.mAMCKeyFrameBackMode + "-mFileStartTimeFloatS:" + this.mFileStartTimeFloatS + "-mMgtvFastMode:" + this.mMgtvFastMode + "-mMediacodecRecreateformat:" + this.mMediacodecRecreateformat + "-mMediacodecRecreateformatOnly4K:" + this.mMediacodecRecreateformatOnly4K + "-mDataSourceInfo:" + this.mDataSourceInfo + "-mPreBufferTimeoutMs:" + this.mPreBufferTimeoutMs + "-mLiveLowlantacyEnable:" + this.mLiveLowLatencyEnable + "-tsFlowTag:" + this.tsFlowTag + "-isBackground:" + this.isBackground);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void configLoadMaxRetryTime(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void configTsNotSkip(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void configWeakNetSpeed(int i) {
    }

    public void defaultNetAddr() {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableFramePTSNotify(boolean z) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "enableFramePTSNotify " + z);
        this.mEnableFramePTSNotify = z;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.enableFramePTSNotify(z);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableImgoAIQE(boolean z) {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.enableImgoAIQE(z);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableImgoVSR(boolean z) {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.enableImgoVSR(z);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableLiveLowLatency(boolean z) {
        this.mLiveLowLatencyEnable = z;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.enableLiveLowLatency(z);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableMediaCodecSW(boolean z) {
        this.mEnableMediacodecSW = z;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableOppoFunc(int i, boolean z) {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.enableOppoFunc(i, z);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableSpatializer(boolean z) {
        this.mEnableSpaceAudio = z;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.enableSpatializer(z);
        }
    }

    @Override // com.hunantv.media.widget.ISubtitle
    public void enableSubtitle(boolean z) {
        this.mIsSubtitleEnable = z;
        if (z) {
            addSubtitleView();
            FrameLayout frameLayout = this.mDecorateLayout;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
        } else {
            removeSubtitleSource();
            removeSubtitleView();
        }
        SubtitleView subtitleView = this.mSubtitleView;
        if (subtitleView != null) {
            subtitleView.setVisible(this.mIsSubtitleEnable);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public ABRegion getABRegion() {
        return this.mABRegion;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getAMCKeyFrameBackMode() {
        return this.mAMCKeyFrameBackMode;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public IDrmSession getBindDrmSession() {
        return this.mDrmSession;
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
    public Uri getCurrentUri() {
        return this.mCurrentUri;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public MgtvMediaPlayer.DataSourceType getDataSourceType() {
        return this.mDataSourceType;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public IMgtvRenderView.FloatRect getDisplayFloatRect() {
        return this.mDisplayFloatRect;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getDnsFamilyType() {
        return this.mDnsFamilyType;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public float getFileStartTimeFloatS() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        return mgtvMediaPlayer != null ? mgtvMediaPlayer.getFileStartTimeFloatS() : this.mFileStartTimeFloatS;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public byte[] getKeyInfoData() {
        return this.mKeyInfoData;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public String getLastIP() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.getLastIP();
        }
        return null;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public float getLeftVolume() {
        return this.mLeftVolume;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public MgtvMediaPlayer getMediaPlayer() {
        return this.mMediaPlayer;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getMemoryPlayType() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.getMemoryPlayType();
        }
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getMgtvAudioEffectChoice() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.getWanosAudioEffectChoice();
        }
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getMgtvFastMode() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        return mgtvMediaPlayer != null ? mgtvMediaPlayer.getMgtvFastMode() : this.mMgtvFastMode;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public MgtvMediaPlayer.Prepared4StartMode getPrepared4StartMode() {
        return this.mPrepared4StartMode;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public long getPropertyLong(int i, long j) {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        return mgtvMediaPlayer != null ? mgtvMediaPlayer.getPropertyLong(i, j) : j;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getReadDataSourceType() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        return mgtvMediaPlayer != null ? mgtvMediaPlayer.getReadDataSourceType() : this.mReadDataSourceTypeConfig;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public IVideoView.Size getRenderViewSize() {
        if (this.mDisplayFloatRect != null && this.mResizableFrameView != null) {
            IVideoView.Size size = new IVideoView.Size();
            size.width = this.mResizableFrameView.getCenterDisplayW();
            size.height = this.mResizableFrameView.getCenterDisplayH();
            return size;
        }
        IVideoView.Size size2 = new IVideoView.Size();
        MgtvRenderView mgtvRenderView = this.mRenderView;
        if (mgtvRenderView != null && mgtvRenderView.getView() != null) {
            size2.width = this.mRenderView.getView().getWidth();
            size2.height = this.mRenderView.getView().getHeight();
        }
        return size2;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public ReportParams getReportParams() {
        return this.mReportParams;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public float getRightVolume() {
        return this.mRightVolume;
    }

    @Override // com.hunantv.media.widget.ISubtitle
    @Nullable
    public SubtitleSource getSubtitleSource() {
        return this.mSubtitleSource;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public String getVideoPath() {
        Uri uri = this.mCurrentUri;
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public String getVideoProxyPath() {
        Uri uri = this.mProxyUri;
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    public void initListener(MgtvMediaPlayer mgtvMediaPlayer) {
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.clearVideoPTSListener();
            for (MgtvPlayerListener.OnVideoPTSListener onVideoPTSListener : this.ptsListeners) {
                mgtvMediaPlayer.addVideoPTSListener(onVideoPTSListener);
            }
            mgtvMediaPlayer.setSubtitleCallback(this.mSubtitleCallback);
            mgtvMediaPlayer.setOnFrameListener(this.mFrameListener);
            mgtvMediaPlayer.setOnAVPlayListener(this.mAVPlayListener);
            mgtvMediaPlayer.setOnSwitchSmoothSourceListener(this.mSwitchSmoothSourceListener);
            mgtvMediaPlayer.setOnInfoStringListener(this.mInfoStringListener);
            mgtvMediaPlayer.setOnPlayerEventListener(this.mPlayerEventListener);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isAntiViewShake() {
        return this.mAntiViewShake;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isBackPlayEnable() {
        return this.mBackPlayEnable;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isBackground() {
        return this.isBackground;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isForceHttpDns() {
        return this.mForceHttpDns;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isKeyInfoDataSet() {
        return this.mKeyInfoSet;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isMediaCodecSWEnable() {
        return this.mEnableMediacodecSW;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isMgtvAudioEffectValid() {
        MgtvMediaPlayer mgtvMediaPlayer;
        if ((!isOnlyAudioMode() || NetPlayConfig.isMgtvAudioEffectEnable()) && (mgtvMediaPlayer = this.mMediaPlayer) != null) {
            return mgtvMediaPlayer.isWanosAudioEffectValid();
        }
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isOnlyAudioMode() {
        return this.mLastMediaMode == 1;
    }

    public boolean isReuseTextureDisable() {
        return this.mForceReuseTexture && !this.mEnableTexture;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isSmoothSwitchOpen() {
        return this.mSmoothModeOpen;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isSupportAMCKeyFrameBackup() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.isSupportAMCKeyFrameBackup();
        }
        return false;
    }

    public void onVideoRenderStart() {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void openImgoDSModule(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void release() {
    }

    public void releaseNoStatus() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.release();
            PlayerReferenceObserver.remove(this.mMediaPlayer.hashCode() + "");
            this.mMediaPlayer = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void removeDecorateLayout() {
        FrameLayout frameLayout = this.mDecorateLayout;
        if (frameLayout == null || !ViewUtil.isViewExsit(this, frameLayout)) {
            return;
        }
        removeView(this.mDecorateLayout);
    }

    @Override // com.hunantv.media.widget.ISubtitle
    public void removeSubtitleSource() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.removeSubtitleSources();
        }
        SubtitleSource subtitleSource = this.mSubtitleSource;
        if (subtitleSource != null) {
            subtitleSource.release();
            this.mSubtitleSource = null;
        }
    }

    public void removeSubtitleView() {
        SubtitleView subtitleView;
        FrameLayout frameLayout = this.mDecorateLayout;
        if (frameLayout == null || (subtitleView = this.mSubtitleView) == null || !ViewUtil.isViewExsit(frameLayout, subtitleView)) {
            return;
        }
        this.mDecorateLayout.removeView(this.mSubtitleView);
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void removeVideoPTSListener(MgtvPlayerListener.OnVideoPTSListener onVideoPTSListener) {
        synchronized (this.ptsLocker) {
            this.ptsListeners.remove(onVideoPTSListener);
            MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
            if (mgtvMediaPlayer != null) {
                mgtvMediaPlayer.removeVideoPTSListener(onVideoPTSListener);
            }
        }
    }

    public void requestAudioFocus() {
        if (this.mAudioFocusObtained) {
            return;
        }
        AudioUtil.requestAudioFocus(this.mContext);
        this.mAudioFocusObtained = true;
    }

    public void resetDataAfter(ReleaseReason releaseReason) {
        if (releaseReason == ReleaseReason.OUT) {
            MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
            if (mgtvMediaPlayer != null) {
                mgtvMediaPlayer.resetSpatializerSwitchOn();
            }
            this.mKeyInfoSet = false;
            this.mKeyInfoData = null;
            this.mKeyInfoRet = 0;
            this.mKeyInfoSetLayer = 0;
            ReportParams reportParams = this.mReportParams;
            if (reportParams != null) {
                reportParams.getKeyInfo().reset();
            }
            this.mIsDrmPrepared = false;
            IDrmSession iDrmSession = this.mDrmSession;
            if (iDrmSession != null) {
                iDrmSession.removeOnProvisionSuccessListener(this.mOnProvisionSuccessListener);
                this.mDrmSession = null;
            }
            this.mDrmInfoList = null;
        }
    }

    public void resetDataBefore(ReleaseReason releaseReason) {
        SubtitleView subtitleView = this.mSubtitleView;
        if (subtitleView != null) {
            subtitleView.clear();
        }
        if (releaseReason == ReleaseReason.OUT) {
            this.mFileStartTimeFloatS = -1.0f;
            this.mSmoothModeOpen = false;
            removeSubtitleSource();
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setAMCKeyFrameBackMode(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    @Deprecated
    public void setAccurateSeekEnable(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setAntiViewShake(boolean z) {
        this.mAntiViewShake = z;
        MgtvRenderView mgtvRenderView = this.mRenderView;
        if (mgtvRenderView != null) {
            mgtvRenderView.setAntiShake(z);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setBackPlayEnable(boolean z) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "setBackPlayEnable:" + z);
        this.mBackPlayEnable = z;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setBackground(boolean z) {
        this.isBackground = z;
        String logTag = getLogTag();
        DebugLog.i(logTag, "setBackground " + z + ",threadId:" + Thread.currentThread().getId());
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setBackground(z);
            if (z || !this.mMediaPlayer.isLoadDataPaused()) {
                return;
            }
            this.mMediaPlayer.resumeLoadData();
            DebugLog.i(getLogTag(), "setBackPlayEnable:resumeLoadData");
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setBufferTimeout(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setConnectTimeOut(int i) {
        this.mConnectTimeOut = i;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setDataSourceInfo(MgtvMediaPlayer.DataSourceInfo dataSourceInfo) {
        this.mDataSourceInfo = dataSourceInfo;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setDataSourceInfo(dataSourceInfo);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setDisableAudioFocus(boolean z) {
        this.isRequestAudioFocus = !z;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setDisplayFloatRect(IMgtvRenderView.FloatRect floatRect) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "setDisplayFloatRect " + floatRect);
        this.mDisplayFloatRect = floatRect;
        if (this.mRenderView == null || !isRendered()) {
            return;
        }
        this.mRenderView.setDisplayFloatRect(this.mDisplayFloatRect);
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setDnsFamilyType(int i) {
        this.mDnsFamilyType = i;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setDrmInfoList(List<MgtvDrmParams.DrmInfo> list) {
        this.mDrmInfoList = list;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setDrmInfoList(list);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    @Deprecated
    public void setDrmLicensePrepared() {
        this.mIsDrmPrepared = true;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setDrmLicensePrepared();
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setEnableVideoStartTime(boolean z) {
        this.mEnableVideoStartTime = z;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setEnableVideoStartTime(z);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setFileStartTimeFloatS(float f) {
        this.mFileStartTimeFloatS = f;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setPlayerFileStartTimeFloatS(f);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setForceHttpDns(boolean z) {
        this.mForceHttpDns = z;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setForceHttpDns(z);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int setKeyInfoData(String str) {
        DebugLog.i(getLogTag(), "setKeyInfoData(String fileStr) in");
        if (this.mKeyInfoSetEnable) {
            this.mKeyInfoSet = true;
            this.mKeyInfoSetLayer = 1;
            try {
                if (StringUtil.isEmpty(str)) {
                    this.mKeyInfoRet = -21;
                    return -21;
                }
                File file = new File(str);
                if (!file.exists()) {
                    this.mKeyInfoRet = -22;
                    return -22;
                } else if (file.length() <= 0) {
                    this.mKeyInfoRet = -23;
                    return -23;
                } else {
                    return setKeyInfoData(FileUtil.readFile(file));
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.mKeyInfoRet = -20;
                return -20;
            } finally {
                updateKeyInfoReport();
                String logTag = getLogTag();
                DebugLog.i(logTag, "setKeyInfoData(String fileStr) out." + this.mKeyInfoRet);
            }
        }
        return 0;
    }

    public int setKeyInfoData(byte[] bArr) {
        int i;
        String logTag;
        StringBuilder sb;
        DebugLog.i(getLogTag(), "setKeyInfoData(byte[] data) in");
        if (this.mKeyInfoSetEnable) {
            try {
                this.mKeyInfoData = bArr;
                this.mKeyInfoSet = true;
                this.mKeyInfoSetLayer = 1;
                if (this.mMediaPlayer != null) {
                    setKeyInfoDataInner(bArr);
                    i = this.mKeyInfoRet;
                    updateKeyInfoReport();
                    logTag = getLogTag();
                    sb = new StringBuilder();
                } else {
                    i = this.mKeyInfoRet;
                    updateKeyInfoReport();
                    logTag = getLogTag();
                    sb = new StringBuilder();
                }
                sb.append("setKeyInfoData(byte[] data) out. mKeyInfoRet:");
                sb.append(this.mKeyInfoRet);
                DebugLog.i(logTag, sb.toString());
                return i;
            } catch (Throwable th) {
                updateKeyInfoReport();
                String logTag2 = getLogTag();
                DebugLog.i(logTag2, "setKeyInfoData(byte[] data) out. mKeyInfoRet:" + this.mKeyInfoRet);
                throw th;
            }
        }
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int setKeyInfoData(byte[] bArr, int i, int i2) {
        int i3;
        String logTag;
        StringBuilder sb;
        String logTag2 = getLogTag();
        DebugLog.i(logTag2, "setKeyInfoData(byte[] data) vid:" + i + " def:" + i2 + " in");
        if (this.mKeyInfoSetEnable) {
            try {
                this.mKeyInfoData = bArr;
                this.mKeyInfoSet = true;
                this.mKeyInfoSetLayer = 1;
                if (this.mMediaPlayer != null) {
                    setKeyInfoDataInner(bArr);
                    i3 = this.mKeyInfoRet;
                    updateKeyInfoReport();
                    logTag = getLogTag();
                    sb = new StringBuilder();
                } else {
                    i3 = this.mKeyInfoRet;
                    updateKeyInfoReport();
                    logTag = getLogTag();
                    sb = new StringBuilder();
                }
                sb.append("setKeyInfoData(byte[] data) out. mKeyInfoRet:");
                sb.append(this.mKeyInfoRet);
                DebugLog.i(logTag, sb.toString());
                return i3;
            } catch (Throwable th) {
                updateKeyInfoReport();
                String logTag3 = getLogTag();
                DebugLog.i(logTag3, "setKeyInfoData(byte[] data) out. mKeyInfoRet:" + this.mKeyInfoRet);
                throw th;
            }
        }
        return 0;
    }

    public void setLastMediaMode(int i) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "setLastMediaMode:" + i);
        this.mLastMediaMode = i;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean setLoopABPlay(boolean z, ABRegion aBRegion) {
        long j;
        String logTag;
        String str;
        DebugLog.i(getLogTag(), "setLoopABPlay in enable:" + z + " " + aBRegion);
        if (!z || aBRegion == null || aBRegion.bPosMs > aBRegion.aPosMs) {
            this.mLoopABPlayEnable = z;
            this.mABRegion = aBRegion;
            long j2 = -1;
            if (aBRegion != null) {
                j2 = aBRegion.aPosMs;
                j = aBRegion.bPosMs;
            } else {
                j = -1;
            }
            MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
            if (mgtvMediaPlayer != null) {
                mgtvMediaPlayer.setLoopABPlay(z, j2, j);
                if (z && j2 >= 0 && j >= 0) {
                    start();
                    DebugLog.e(getLogTag(), "setLoopABPlay out success");
                    return true;
                }
            }
            logTag = getLogTag();
            str = "setLoopABPlay out failed";
        } else {
            logTag = getLogTag();
            str = "setLoopABPlay error b <= a";
        }
        DebugLog.e(logTag, str);
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setLoopSeekPlay(boolean z, int i) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "setLoopSeekPlay enable:" + z + ",loop_step_s:" + i);
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setLoopSeekPlay(z, i);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setMediacodecRecreateformat(boolean z, boolean z2) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "setMediacodecRecreateformat:" + z + ",only_4k:" + z2);
        this.mMediacodecRecreateformat = z;
        this.mMediacodecRecreateformatOnly4K = z2;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setMediacodecRecreateformat(z, z2);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setMgtvAudioEffectChoice(int i) {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setWanosAudioEffectChoice(i);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int setMgtvAudioEffectConfig(byte[] bArr) {
        this.mAudioEffectConfig = bArr;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.setWanosAudioEffectConfig(bArr);
        }
        return -999;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setMgtvFastMode(int i) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "setMgtvFastMode mode:" + i);
        this.mMgtvFastMode = i;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setMgtvFastMode(i);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setNETIsBroken(boolean z) {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setNETIsBroken(z);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setNetAddrinfo(String str, int i, boolean z) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "setNetAddrinfo " + str + ",timeout:" + i + ",enablePreDns:" + z);
        defaultNetAddr();
        if (i > 0) {
            this.mAddrInfoTimeoutMs = i * 1000;
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setNetPlayConfig(NetPlayConfig netPlayConfig) {
        this.mNetPlayConfig = netPlayConfig;
        String logTag = getLogTag();
        DebugLog.i(logTag, "setNetPlayConfig " + netPlayConfig);
        if (netPlayConfig != null) {
            int i = netPlayConfig.is_soft;
            if (i >= 0) {
                setPlayerHardwareMode(i != 1);
            }
            int i2 = netPlayConfig.accurate_seek;
            if (i2 >= 0) {
                setAccurateSeekEnable(i2 == 1);
            }
            int i3 = netPlayConfig.ts_not_skip;
            if (i3 >= 0) {
                configTsNotSkip(i3 == 1);
            }
            int i4 = netPlayConfig.load_retry_time;
            if (i4 >= 0) {
                configLoadMaxRetryTime(i4);
            }
            int i5 = netPlayConfig.weak_net_speed;
            if (i5 >= 0) {
                configWeakNetSpeed(i5);
            }
            int i6 = netPlayConfig.open_timeout * 1000;
            int i7 = netPlayConfig.rw_timeout * 1000;
            int i8 = netPlayConfig.buffer_timeout * 1000;
            if (i6 > 0) {
                setConnectTimeOut(i6);
            }
            if (i7 > 0) {
                setReciveDataTimeOut(i7);
            }
            if (i8 > 0) {
                setBufferTimeout(i8);
            }
            int i9 = netPlayConfig.datasource_async;
            if (i9 >= 0) {
                openImgoDSModule(i9 == 1);
            }
            if (netPlayConfig.getAddrinfo_type() != null) {
                setNetAddrinfo(netPlayConfig.getAddrinfo_type(), netPlayConfig.getAddrinfo_timeout(), false);
            }
            int i10 = netPlayConfig.dns_family_type;
            if (i10 == 0 || i10 == 1) {
                setDnsFamilyType(i10 == 0 ? 1 : 0);
            }
        }
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setNetPlayConfig(netPlayConfig);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnAVPlayListener(IVideoView.OnAVPlayListener onAVPlayListener) {
        this.mOnAVPlayListener = onAVPlayListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnEventInfoListener(IVideoView.OnEventInfoListener onEventInfoListener) {
        this.mOnEventInfoListener = onEventInfoListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnFrameListener(IVideoView.OnFrameListener onFrameListener) {
        this.mOnFrameListener = onFrameListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnInfoStringListener(IVideoView.OnInfoStringListener onInfoStringListener) {
        this.mOnInfoStringListener = onInfoStringListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnSwitchSmoothSourceListener(IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener) {
        this.mOnSwitchSmoothSourceListener = onSwitchSmoothSourceListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setPreBufferTimeoutMs(int i) {
        this.mPreBufferTimeoutMs = i;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setPreBufferTimeoutMs(i);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setPrepared4StartMode(MgtvMediaPlayer.Prepared4StartMode prepared4StartMode) {
        this.mPrepared4StartMode = prepared4StartMode;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setPrepared4StartMode(prepared4StartMode);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setReadDataSourceType(int i) {
        this.mReadDataSourceTypeConfig = i;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setReciveDataTimeOut(int i) {
        this.mReciveDataTimeOut = i;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setSeekAutoStartAfterComplete(boolean z) {
        this.mSeekAutoStartAfterCompleteEnable = z;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setSeekAutoStartAfterComplete(z);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int setSmoothKeyFrameInfo(byte[] bArr, String str, String str2) {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.setSmoothKeyFrameInfo(bArr, str, str2);
        }
        return -1;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setSmoothSwitchMode(int i) {
        this.mSmoothSwitchMode = i;
    }

    @Override // com.hunantv.media.widget.ISubtitle
    public void setSubtitleCallback(ISubtitle.SubtitleCallback subtitleCallback) {
        this.mOnSubtitleCallback = subtitleCallback;
    }

    @Override // com.hunantv.media.widget.ISubtitle
    public void setSubtitleSource(SubtitleSource subtitleSource) {
        if (!this.mIsSubtitleEnable) {
            this.mSubtitleSource.getErrorResult().setCode(-2);
            this.mSubtitleCallback.onError(this.mSubtitleSource);
            return;
        }
        removeSubtitleSource();
        this.mSubtitleSource = subtitleSource;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer == null || subtitleSource == null) {
            return;
        }
        try {
            mgtvMediaPlayer.addSubtitleSource(this.mSubtitleView, subtitleSource);
        } catch (Exception unused) {
            this.mSubtitleCallback.onError(this.mSubtitleSource);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setTimeout(int i, int i2) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setTsFlowTag(String str) {
        this.tsFlowTag = str;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setTsFlowTag(str);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setVideoDataSource(MgtvPlayerDataSource mgtvPlayerDataSource) {
        this.mDataSource = mgtvPlayerDataSource;
        setReadDataSourceType(3);
        setVideoPath(this.mDataSource.getPath());
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setVideoFrameClockNotifyMs(int i) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "setVideoFrameClockNotifyMs " + i);
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setVideoFrameClockNotifyMs(i);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setVideoFrameClockNotifyPts(long j, long j2) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "setVideoFrameClockNotify clockTimeStart:" + j + ",clockTimeEnd:" + j2);
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setVideoFrameClockNotifyPts(j, j2);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setVideoIntroduction(String str) {
        String logTag = getLogTag();
        DebugLog.i(logTag, "setVideoIntroduction:" + str);
        this.mVideoIntroduction = str;
        ReportParams reportParams = this.mReportParams;
        if (reportParams != null) {
            reportParams.setSvds(str);
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hunantv.media.widget.IVideoView
    public DebugPanel showDebugPanel(boolean z) {
        if (z) {
            if (this.mDebugPanel == null) {
                this.mDebugPanel = new DebugPanel(this.mContext, this);
            }
            ViewUtil.addView(this, this.mDebugPanel, new FrameLayout.LayoutParams(-1, -1, 17));
        } else {
            ViewUtil.removeView(this, this.mDebugPanel);
        }
        return this.mDebugPanel;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void startAVDecoder() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.startAVDecoder();
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void stepPlaybackNextFrame() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setPlaybackStep(1);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void stop() {
        stopInner();
    }

    public void stopInner() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.stop();
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean support3X() {
        return supportMaxSpeed() >= 3.0f;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean supportImgoAIQE(MgtvMediaPlayer.ImgoAIQE imgoAIQE) {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.supportImgoAIQE(imgoAIQE);
        }
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public float supportMaxSpeed() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            return mgtvMediaPlayer.supportMaxSpeed(isOnlyAudioMode());
        }
        return 2.0f;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void switchSmoothSource(SmoothMediaSource smoothMediaSource) {
        if (this.mMediaPlayer != null) {
            if (smoothMediaSource == null || smoothMediaSource.getSwitchMod() != 1) {
                setLastMediaMode(0);
            } else {
                setLastMediaMode(1);
            }
            this.mMediaPlayer.switchSmoothSource(smoothMediaSource);
        }
    }

    public void toggleRenders(int i) {
        this.mRenderViewType = i;
    }
}
