package com.hunantv.media.alpha;

import a.a.a.a.c;
import a.a.a.a.l;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.hunantv.imgo.nightmode.view.SkinnableFrameLayout;
import com.hunantv.media.config.NetPlayConfig;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.media.global.PlayerReferenceObserver;
import com.hunantv.media.p2p.IP2pTask;
import com.hunantv.media.player.IMgtvRenderView;
import com.hunantv.media.player.MgtvMediaPlayer;
import com.hunantv.media.player.MgtvPlayerListener;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.player.smooth.SmoothMediaSource;
import com.hunantv.media.player.utils.StringUtil;
import com.hunantv.media.report.ReportParams;
import com.hunantv.media.utils.AudioUtil;
import com.hunantv.media.utils.FileUtil;
import com.hunantv.media.utils.KeyFrameInfoUtils;
import com.hunantv.media.utils.ViewUtil;
import com.hunantv.media.widget.IVideoView;
import com.hunantv.media.widget.MgtvAbstractVideoView;
import com.hunantv.media.widget.debug.DebugPanel;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class MgtvAlphaAbstractVideoView extends SkinnableFrameLayout implements IVideoView {
    public static final int INVALID_FILE_START_TIME_VALUE = -1;
    public static final int MODE_NORMAL = 0;
    public static final int MODE_ONLY_AUDIO = 1;
    public static boolean sAutoNativeStack = true;
    public boolean isBackground;
    public boolean isRequestAudioFocus;
    public MgtvAbstractVideoView.ABRegion mABRegion;
    public int mAMCKeyFrameBackMode;
    private MgtvPlayerListener.OnAVPlayListener mAVPlayListener;
    public int mAddrInfoTimeoutMs;
    public boolean mAntiViewShake;
    public volatile boolean mAudioFocusObtained;
    public boolean mBackPlayEnable;
    public IVideoView.Configuration mConfiguration;
    public int mConnectTimeOut;
    public Context mContext;
    public Uri mCurrentUri;
    public MgtvMediaPlayer.DataSourceInfo mDataSourceInfo;
    public MgtvMediaPlayer.DataSourceType mDataSourceType;
    public DebugPanel mDebugPanel;
    public IMgtvRenderView.FloatRect mDisplayFloatRect;
    public int mDnsFamilyType;
    public IDrmSession mDrmSession;
    public boolean mEnableDefaultFileStartTime;
    public boolean mEnableMediacodecSW;
    public boolean mEnableTexture;
    public boolean mEnableVideoStartTime;
    public c mFakeFrameView;
    public float mFileStartTimeFloatS;
    public boolean mForceHttpDns;
    public boolean mForceReuseTexture;
    private MgtvPlayerListener.OnFrameListener mFrameListener;
    public IAlphaRenderView mGLView;
    public boolean mIsDrmPrepared;
    public boolean mJavaDnsEnable;
    public byte[] mKeyInfoData;
    public int mKeyInfoRet;
    public boolean mKeyInfoSet;
    public boolean mKeyInfoSetEnable;
    public int mKeyInfoSetLayer;
    public int mLastMediaMode;
    private boolean mLiveLowLatencyEnable;
    public boolean mLoopABPlayEnable;
    public IP2pTask mMainP2pTask;
    public MgtvMediaPlayer mMediaPlayer;
    public boolean mMediacodecRecreateformat;
    public boolean mMediacodecRecreateformatOnly4K;
    public int mMgtvFastMode;
    public NetPlayConfig mNetPlayConfig;
    public IVideoView.OnAVPlayListener mOnAVPlayListener;
    public IVideoView.OnFrameListener mOnFrameListener;
    public IDrmSession.OnProvisionSuccessListener mOnProvisionSuccessListener;
    public IVideoView.OnSwitchSmoothSourceListener mOnSwitchSmoothSourceListener;
    private int mPreBufferTimeoutMs;
    public MgtvMediaPlayer.Prepared4StartMode mPrepared4StartMode;
    public Uri mProxyUri;
    public int mReciveDataTimeOut;
    public ReportParams mReportParams;
    public l mResizableFrameView;
    public boolean mSeekAutoStartAfterCompleteEnable;
    public boolean mSmoothModeOpen;
    public boolean mSmoothModeSwitch;
    public int mSmoothSwitchMode;
    private MgtvPlayerListener.OnSwitchSmoothSourceListener mSwitchSmoothSourceListener;
    private String mVideoIntroduction;
    public Set<MgtvPlayerListener.OnVideoPTSListener> ptsListeners;
    public Object ptsLocker;
    public String tsFlowTag;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum ReleaseReason {
        OUT,
        DEFAULT_INNER,
        PAUSE_DATA_BEFORE_PREPEAD
    }

    public MgtvAlphaAbstractVideoView(Context context) {
        super(context);
        this.mMediaPlayer = null;
        this.mPrepared4StartMode = MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_DEFAULT;
        this.mFileStartTimeFloatS = -1.0f;
        this.mDnsFamilyType = 1;
        this.mKeyInfoSetEnable = true;
        this.mKeyInfoSetLayer = 0;
        this.mCurrentUri = null;
        this.mOnProvisionSuccessListener = new IDrmSession.OnProvisionSuccessListener() { // from class: com.hunantv.media.alpha.MgtvAlphaAbstractVideoView.1
            @Override // com.hunantv.media.drm.IDrmSession.OnProvisionSuccessListener
            public void onSuccess(IDrmSession iDrmSession) {
                MgtvAlphaAbstractVideoView.this.setDrmLicensePrepared();
            }
        };
        this.mForceReuseTexture = false;
        this.mEnableTexture = false;
        this.mAMCKeyFrameBackMode = -1;
        this.mEnableMediacodecSW = false;
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
        this.isRequestAudioFocus = true;
        this.mVideoIntroduction = "";
        this.mLiveLowLatencyEnable = false;
        this.mAVPlayListener = new MgtvPlayerListener.OnAVPlayListener() { // from class: com.hunantv.media.alpha.MgtvAlphaAbstractVideoView.2
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnAVPlayListener
            public void onAVPauseOrPlay(boolean z) {
                IVideoView.OnAVPlayListener onAVPlayListener = MgtvAlphaAbstractVideoView.this.mOnAVPlayListener;
                if (onAVPlayListener != null) {
                    onAVPlayListener.onAVPauseOrPlay(z);
                }
            }
        };
        this.mFrameListener = new MgtvPlayerListener.OnFrameListener() { // from class: com.hunantv.media.alpha.MgtvAlphaAbstractVideoView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnFrameListener
            public void onVFrameClockCome(MgtvPlayerListener.FrameClock frameClock) {
                IVideoView.OnFrameListener onFrameListener = MgtvAlphaAbstractVideoView.this.mOnFrameListener;
                if (onFrameListener != null) {
                    onFrameListener.onVFrameClockCome(frameClock);
                }
            }
        };
        this.mSwitchSmoothSourceListener = new MgtvPlayerListener.OnSwitchSmoothSourceListener() { // from class: com.hunantv.media.alpha.MgtvAlphaAbstractVideoView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceError(SmoothMediaSource smoothMediaSource, int i, int i2) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAlphaAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceError(smoothMediaSource, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceFail(SmoothMediaSource smoothMediaSource, int i, int i2) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAlphaAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceFail(smoothMediaSource, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceInfo(SmoothMediaSource smoothMediaSource, int i) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAlphaAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceInfo(smoothMediaSource, i);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceSuccess(SmoothMediaSource smoothMediaSource) {
                MgtvAlphaAbstractVideoView mgtvAlphaAbstractVideoView;
                if (smoothMediaSource != null) {
                    Uri uri = null;
                    if (StringUtil.isEmpty(smoothMediaSource.getUrl())) {
                        MgtvAlphaAbstractVideoView.this.mCurrentUri = null;
                    } else {
                        MgtvAlphaAbstractVideoView.this.mCurrentUri = Uri.parse(smoothMediaSource.getUrl().trim());
                    }
                    if (StringUtil.isEmpty(smoothMediaSource.getProxyUrl())) {
                        mgtvAlphaAbstractVideoView = MgtvAlphaAbstractVideoView.this;
                    } else {
                        mgtvAlphaAbstractVideoView = MgtvAlphaAbstractVideoView.this;
                        uri = Uri.parse(smoothMediaSource.getProxyUrl().trim());
                    }
                    mgtvAlphaAbstractVideoView.mProxyUri = uri;
                    MgtvAlphaAbstractVideoView.this.mMainP2pTask = smoothMediaSource.getP2pTask();
                }
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAlphaAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceSuccess(smoothMediaSource);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public boolean onSwitchSmoothSourceWillUpdate(SmoothMediaSource smoothMediaSource) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAlphaAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    return onSwitchSmoothSourceListener.onSwitchSmoothSourceWillUpdate(smoothMediaSource);
                }
                return false;
            }
        };
        this.ptsListeners = new HashSet();
        this.ptsLocker = new Object();
        this.isBackground = false;
    }

    public MgtvAlphaAbstractVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMediaPlayer = null;
        this.mPrepared4StartMode = MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_DEFAULT;
        this.mFileStartTimeFloatS = -1.0f;
        this.mDnsFamilyType = 1;
        this.mKeyInfoSetEnable = true;
        this.mKeyInfoSetLayer = 0;
        this.mCurrentUri = null;
        this.mOnProvisionSuccessListener = new IDrmSession.OnProvisionSuccessListener() { // from class: com.hunantv.media.alpha.MgtvAlphaAbstractVideoView.1
            @Override // com.hunantv.media.drm.IDrmSession.OnProvisionSuccessListener
            public void onSuccess(IDrmSession iDrmSession) {
                MgtvAlphaAbstractVideoView.this.setDrmLicensePrepared();
            }
        };
        this.mForceReuseTexture = false;
        this.mEnableTexture = false;
        this.mAMCKeyFrameBackMode = -1;
        this.mEnableMediacodecSW = false;
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
        this.isRequestAudioFocus = true;
        this.mVideoIntroduction = "";
        this.mLiveLowLatencyEnable = false;
        this.mAVPlayListener = new MgtvPlayerListener.OnAVPlayListener() { // from class: com.hunantv.media.alpha.MgtvAlphaAbstractVideoView.2
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnAVPlayListener
            public void onAVPauseOrPlay(boolean z) {
                IVideoView.OnAVPlayListener onAVPlayListener = MgtvAlphaAbstractVideoView.this.mOnAVPlayListener;
                if (onAVPlayListener != null) {
                    onAVPlayListener.onAVPauseOrPlay(z);
                }
            }
        };
        this.mFrameListener = new MgtvPlayerListener.OnFrameListener() { // from class: com.hunantv.media.alpha.MgtvAlphaAbstractVideoView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnFrameListener
            public void onVFrameClockCome(MgtvPlayerListener.FrameClock frameClock) {
                IVideoView.OnFrameListener onFrameListener = MgtvAlphaAbstractVideoView.this.mOnFrameListener;
                if (onFrameListener != null) {
                    onFrameListener.onVFrameClockCome(frameClock);
                }
            }
        };
        this.mSwitchSmoothSourceListener = new MgtvPlayerListener.OnSwitchSmoothSourceListener() { // from class: com.hunantv.media.alpha.MgtvAlphaAbstractVideoView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceError(SmoothMediaSource smoothMediaSource, int i, int i2) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAlphaAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceError(smoothMediaSource, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceFail(SmoothMediaSource smoothMediaSource, int i, int i2) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAlphaAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceFail(smoothMediaSource, i, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceInfo(SmoothMediaSource smoothMediaSource, int i) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAlphaAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceInfo(smoothMediaSource, i);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceSuccess(SmoothMediaSource smoothMediaSource) {
                MgtvAlphaAbstractVideoView mgtvAlphaAbstractVideoView;
                if (smoothMediaSource != null) {
                    Uri uri = null;
                    if (StringUtil.isEmpty(smoothMediaSource.getUrl())) {
                        MgtvAlphaAbstractVideoView.this.mCurrentUri = null;
                    } else {
                        MgtvAlphaAbstractVideoView.this.mCurrentUri = Uri.parse(smoothMediaSource.getUrl().trim());
                    }
                    if (StringUtil.isEmpty(smoothMediaSource.getProxyUrl())) {
                        mgtvAlphaAbstractVideoView = MgtvAlphaAbstractVideoView.this;
                    } else {
                        mgtvAlphaAbstractVideoView = MgtvAlphaAbstractVideoView.this;
                        uri = Uri.parse(smoothMediaSource.getProxyUrl().trim());
                    }
                    mgtvAlphaAbstractVideoView.mProxyUri = uri;
                    MgtvAlphaAbstractVideoView.this.mMainP2pTask = smoothMediaSource.getP2pTask();
                }
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAlphaAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceSuccess(smoothMediaSource);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public boolean onSwitchSmoothSourceWillUpdate(SmoothMediaSource smoothMediaSource) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAlphaAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    return onSwitchSmoothSourceListener.onSwitchSmoothSourceWillUpdate(smoothMediaSource);
                }
                return false;
            }
        };
        this.ptsListeners = new HashSet();
        this.ptsLocker = new Object();
        this.isBackground = false;
    }

    public MgtvAlphaAbstractVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMediaPlayer = null;
        this.mPrepared4StartMode = MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_DEFAULT;
        this.mFileStartTimeFloatS = -1.0f;
        this.mDnsFamilyType = 1;
        this.mKeyInfoSetEnable = true;
        this.mKeyInfoSetLayer = 0;
        this.mCurrentUri = null;
        this.mOnProvisionSuccessListener = new IDrmSession.OnProvisionSuccessListener() { // from class: com.hunantv.media.alpha.MgtvAlphaAbstractVideoView.1
            @Override // com.hunantv.media.drm.IDrmSession.OnProvisionSuccessListener
            public void onSuccess(IDrmSession iDrmSession) {
                MgtvAlphaAbstractVideoView.this.setDrmLicensePrepared();
            }
        };
        this.mForceReuseTexture = false;
        this.mEnableTexture = false;
        this.mAMCKeyFrameBackMode = -1;
        this.mEnableMediacodecSW = false;
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
        this.isRequestAudioFocus = true;
        this.mVideoIntroduction = "";
        this.mLiveLowLatencyEnable = false;
        this.mAVPlayListener = new MgtvPlayerListener.OnAVPlayListener() { // from class: com.hunantv.media.alpha.MgtvAlphaAbstractVideoView.2
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnAVPlayListener
            public void onAVPauseOrPlay(boolean z) {
                IVideoView.OnAVPlayListener onAVPlayListener = MgtvAlphaAbstractVideoView.this.mOnAVPlayListener;
                if (onAVPlayListener != null) {
                    onAVPlayListener.onAVPauseOrPlay(z);
                }
            }
        };
        this.mFrameListener = new MgtvPlayerListener.OnFrameListener() { // from class: com.hunantv.media.alpha.MgtvAlphaAbstractVideoView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnFrameListener
            public void onVFrameClockCome(MgtvPlayerListener.FrameClock frameClock) {
                IVideoView.OnFrameListener onFrameListener = MgtvAlphaAbstractVideoView.this.mOnFrameListener;
                if (onFrameListener != null) {
                    onFrameListener.onVFrameClockCome(frameClock);
                }
            }
        };
        this.mSwitchSmoothSourceListener = new MgtvPlayerListener.OnSwitchSmoothSourceListener() { // from class: com.hunantv.media.alpha.MgtvAlphaAbstractVideoView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceError(SmoothMediaSource smoothMediaSource, int i2, int i22) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAlphaAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceError(smoothMediaSource, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceFail(SmoothMediaSource smoothMediaSource, int i2, int i22) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAlphaAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceFail(smoothMediaSource, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceInfo(SmoothMediaSource smoothMediaSource, int i2) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAlphaAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceInfo(smoothMediaSource, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceSuccess(SmoothMediaSource smoothMediaSource) {
                MgtvAlphaAbstractVideoView mgtvAlphaAbstractVideoView;
                if (smoothMediaSource != null) {
                    Uri uri = null;
                    if (StringUtil.isEmpty(smoothMediaSource.getUrl())) {
                        MgtvAlphaAbstractVideoView.this.mCurrentUri = null;
                    } else {
                        MgtvAlphaAbstractVideoView.this.mCurrentUri = Uri.parse(smoothMediaSource.getUrl().trim());
                    }
                    if (StringUtil.isEmpty(smoothMediaSource.getProxyUrl())) {
                        mgtvAlphaAbstractVideoView = MgtvAlphaAbstractVideoView.this;
                    } else {
                        mgtvAlphaAbstractVideoView = MgtvAlphaAbstractVideoView.this;
                        uri = Uri.parse(smoothMediaSource.getProxyUrl().trim());
                    }
                    mgtvAlphaAbstractVideoView.mProxyUri = uri;
                    MgtvAlphaAbstractVideoView.this.mMainP2pTask = smoothMediaSource.getP2pTask();
                }
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAlphaAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceSuccess(smoothMediaSource);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public boolean onSwitchSmoothSourceWillUpdate(SmoothMediaSource smoothMediaSource) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAlphaAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    return onSwitchSmoothSourceListener.onSwitchSmoothSourceWillUpdate(smoothMediaSource);
                }
                return false;
            }
        };
        this.ptsListeners = new HashSet();
        this.ptsLocker = new Object();
        this.isBackground = false;
    }

    public MgtvAlphaAbstractVideoView(Context context, IVideoView.Configuration configuration) {
        super(context);
        this.mMediaPlayer = null;
        this.mPrepared4StartMode = MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_DEFAULT;
        this.mFileStartTimeFloatS = -1.0f;
        this.mDnsFamilyType = 1;
        this.mKeyInfoSetEnable = true;
        this.mKeyInfoSetLayer = 0;
        this.mCurrentUri = null;
        this.mOnProvisionSuccessListener = new IDrmSession.OnProvisionSuccessListener() { // from class: com.hunantv.media.alpha.MgtvAlphaAbstractVideoView.1
            @Override // com.hunantv.media.drm.IDrmSession.OnProvisionSuccessListener
            public void onSuccess(IDrmSession iDrmSession) {
                MgtvAlphaAbstractVideoView.this.setDrmLicensePrepared();
            }
        };
        this.mForceReuseTexture = false;
        this.mEnableTexture = false;
        this.mAMCKeyFrameBackMode = -1;
        this.mEnableMediacodecSW = false;
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
        this.isRequestAudioFocus = true;
        this.mVideoIntroduction = "";
        this.mLiveLowLatencyEnable = false;
        this.mAVPlayListener = new MgtvPlayerListener.OnAVPlayListener() { // from class: com.hunantv.media.alpha.MgtvAlphaAbstractVideoView.2
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnAVPlayListener
            public void onAVPauseOrPlay(boolean z) {
                IVideoView.OnAVPlayListener onAVPlayListener = MgtvAlphaAbstractVideoView.this.mOnAVPlayListener;
                if (onAVPlayListener != null) {
                    onAVPlayListener.onAVPauseOrPlay(z);
                }
            }
        };
        this.mFrameListener = new MgtvPlayerListener.OnFrameListener() { // from class: com.hunantv.media.alpha.MgtvAlphaAbstractVideoView.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnFrameListener
            public void onVFrameClockCome(MgtvPlayerListener.FrameClock frameClock) {
                IVideoView.OnFrameListener onFrameListener = MgtvAlphaAbstractVideoView.this.mOnFrameListener;
                if (onFrameListener != null) {
                    onFrameListener.onVFrameClockCome(frameClock);
                }
            }
        };
        this.mSwitchSmoothSourceListener = new MgtvPlayerListener.OnSwitchSmoothSourceListener() { // from class: com.hunantv.media.alpha.MgtvAlphaAbstractVideoView.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceError(SmoothMediaSource smoothMediaSource, int i2, int i22) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAlphaAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceError(smoothMediaSource, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceFail(SmoothMediaSource smoothMediaSource, int i2, int i22) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAlphaAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceFail(smoothMediaSource, i2, i22);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceInfo(SmoothMediaSource smoothMediaSource, int i2) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAlphaAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceInfo(smoothMediaSource, i2);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public void onSwitchSmoothSourceSuccess(SmoothMediaSource smoothMediaSource) {
                MgtvAlphaAbstractVideoView mgtvAlphaAbstractVideoView;
                if (smoothMediaSource != null) {
                    Uri uri = null;
                    if (StringUtil.isEmpty(smoothMediaSource.getUrl())) {
                        MgtvAlphaAbstractVideoView.this.mCurrentUri = null;
                    } else {
                        MgtvAlphaAbstractVideoView.this.mCurrentUri = Uri.parse(smoothMediaSource.getUrl().trim());
                    }
                    if (StringUtil.isEmpty(smoothMediaSource.getProxyUrl())) {
                        mgtvAlphaAbstractVideoView = MgtvAlphaAbstractVideoView.this;
                    } else {
                        mgtvAlphaAbstractVideoView = MgtvAlphaAbstractVideoView.this;
                        uri = Uri.parse(smoothMediaSource.getProxyUrl().trim());
                    }
                    mgtvAlphaAbstractVideoView.mProxyUri = uri;
                    MgtvAlphaAbstractVideoView.this.mMainP2pTask = smoothMediaSource.getP2pTask();
                }
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAlphaAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    onSwitchSmoothSourceListener.onSwitchSmoothSourceSuccess(smoothMediaSource);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnSwitchSmoothSourceListener
            public boolean onSwitchSmoothSourceWillUpdate(SmoothMediaSource smoothMediaSource) {
                IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener = MgtvAlphaAbstractVideoView.this.mOnSwitchSmoothSourceListener;
                if (onSwitchSmoothSourceListener != null) {
                    return onSwitchSmoothSourceListener.onSwitchSmoothSourceWillUpdate(smoothMediaSource);
                }
                return false;
            }
        };
        this.ptsListeners = new HashSet();
        this.ptsLocker = new Object();
        this.isBackground = false;
        this.mConfiguration = configuration;
        if (configuration != null) {
            this.mForceReuseTexture = configuration.forceReuseTexture;
        }
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
                setDrmLicensePrepared();
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
            setBackground(this.isBackground);
            String logTag = getLogTag();
            DebugLog.i(logTag, "configImgoPlayer -mPrepared4StartMode:" + this.mPrepared4StartMode + "-mForceHttpDns:" + this.mForceHttpDns + "-mEnableVideoStartTime:" + this.mEnableVideoStartTime + "-mDnsFamilyType:" + this.mDnsFamilyType + "-mAMCKeyFrameBackMode:" + this.mAMCKeyFrameBackMode + "-mFileStartTimeFloatS:" + this.mFileStartTimeFloatS + "-mMgtvFastMode:" + this.mMgtvFastMode + "-mDataSourceInfo:" + this.mDataSourceInfo + "-mPreBufferTimeoutMs:" + this.mPreBufferTimeoutMs + "-isBackground:" + this.isBackground);
        }
    }

    public void configImgoPlayer() {
        MgtvMediaPlayer.DataSourceInfo dataSourceInfo;
        float f;
        if (isReuseTextureDisable()) {
            this.mAMCKeyFrameBackMode = 2;
        }
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setPreBufferTimeoutMs(this.mPreBufferTimeoutMs);
            this.mMediaPlayer.setPrepared4StartMode(this.mPrepared4StartMode);
            this.mMediaPlayer.setForceHttpDns(this.mForceHttpDns);
            this.mMediaPlayer.setEnableVideoStartTime(this.mEnableVideoStartTime);
            this.mMediaPlayer.setDnsFamilyType(this.mDnsFamilyType);
            int i = this.mAMCKeyFrameBackMode;
            if (i >= 0) {
                this.mMediaPlayer.setAMCKeyFrameBackMode(i);
            }
            ReportParams reportParams = this.mReportParams;
            if (reportParams != null && reportParams.getVideoType() == ReportParams.VideoType.TRY_WATCHING && !StringUtil.isEmpty(this.mReportParams.getPlayPreviewType()) && (this.mReportParams.getPlayPreviewType().equals("1") || this.mReportParams.getPlayPreviewType().equals("2"))) {
                this.mMediaPlayer.setConfig(2016021706, 2);
            }
            this.mMediaPlayer.setEnableMediacodecSWRender(this.mEnableMediacodecSW);
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
            if (this.mIsDrmPrepared) {
                setDrmLicensePrepared();
            }
            setLoopABPlay(this.mLoopABPlayEnable, this.mABRegion);
            this.mMediaPlayer.setSeekAutoStartAfterComplete(this.mSeekAutoStartAfterCompleteEnable);
            enableLiveLowLatency(this.mLiveLowLatencyEnable);
            setBackground(this.isBackground);
            String logTag = getLogTag();
            DebugLog.i(logTag, "configImgoPlayer -mPrepared4StartMode:" + this.mPrepared4StartMode + "-mForceHttpDns:" + this.mForceHttpDns + "-mEnableVideoStartTime:" + this.mEnableVideoStartTime + "-mDnsFamilyType:" + this.mDnsFamilyType + "-mAMCKeyFrameBackMode:" + this.mAMCKeyFrameBackMode + "-mFileStartTimeFloatS:" + this.mFileStartTimeFloatS + "-mMgtvFastMode:" + this.mMgtvFastMode + "-mMediacodecRecreateformat:" + this.mMediacodecRecreateformat + "-mMediacodecRecreateformatOnly4K:" + this.mMediacodecRecreateformatOnly4K + "-mDataSourceInfo:" + this.mDataSourceInfo + "-mPreBufferTimeoutMs:" + this.mPreBufferTimeoutMs + "-mLiveLowlantacyEnable:" + this.mLiveLowLatencyEnable + "-isBackground:" + this.isBackground);
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
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.enableFramePTSNotify(z);
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableImgoAIQE(boolean z) {
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
    public MgtvAbstractVideoView.ABRegion getABRegion() {
        return this.mABRegion;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getAMCKeyFrameBackMode() {
        return this.mAMCKeyFrameBackMode;
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
        return 0.0f;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public MgtvMediaPlayer getMediaPlayer() {
        return this.mMediaPlayer;
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
    public IVideoView.Size getRenderViewSize() {
        if (this.mDisplayFloatRect != null && this.mResizableFrameView != null) {
            IVideoView.Size size = new IVideoView.Size();
            size.width = this.mResizableFrameView.getCenterDisplayW();
            size.height = this.mResizableFrameView.getCenterDisplayH();
            return size;
        }
        IVideoView.Size size2 = new IVideoView.Size();
        IAlphaRenderView iAlphaRenderView = this.mGLView;
        if (iAlphaRenderView != null && iAlphaRenderView != null) {
            size2.width = iAlphaRenderView.getWidth();
            size2.height = this.mGLView.getHeight();
        }
        return size2;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public float getRightVolume() {
        return 0.0f;
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
            mgtvMediaPlayer.setOnFrameListener(this.mFrameListener);
            mgtvMediaPlayer.setOnAVPlayListener(this.mAVPlayListener);
            mgtvMediaPlayer.setOnSwitchSmoothSourceListener(this.mSwitchSmoothSourceListener);
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
        }
    }

    public void resetDataBefore(ReleaseReason releaseReason) {
        if (releaseReason == ReleaseReason.OUT) {
            this.mFileStartTimeFloatS = -1.0f;
            this.mSmoothModeOpen = false;
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
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setBackPlayEnable(boolean z) {
        MgtvMediaPlayer mgtvMediaPlayer;
        String logTag = getLogTag();
        DebugLog.i(logTag, "setBackPlayEnable:" + z);
        this.mBackPlayEnable = z;
        if (z || (mgtvMediaPlayer = this.mMediaPlayer) == null || !mgtvMediaPlayer.isLoadDataPaused()) {
            return;
        }
        this.mMediaPlayer.resumeLoadData();
        DebugLog.i(getLogTag(), "setBackPlayEnable:resumeLoadData");
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setBackground(boolean z) {
        this.isBackground = z;
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.setBackground(z);
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
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setDnsFamilyType(int i) {
        this.mDnsFamilyType = i;
    }

    @Override // com.hunantv.media.widget.IVideoView
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
        this.mLastMediaMode = i;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean setLoopABPlay(boolean z, MgtvAbstractVideoView.ABRegion aBRegion) {
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
            int i = netPlayConfig.accurate_seek;
            if (i >= 0) {
                setAccurateSeekEnable(i == 1);
            }
            int i2 = netPlayConfig.ts_not_skip;
            if (i2 >= 0) {
                configTsNotSkip(i2 == 1);
            }
            int i3 = netPlayConfig.load_retry_time;
            if (i3 >= 0) {
                configLoadMaxRetryTime(i3);
            }
            int i4 = netPlayConfig.weak_net_speed;
            if (i4 >= 0) {
                configWeakNetSpeed(i4);
            }
            int i5 = netPlayConfig.open_timeout * 1000;
            int i6 = netPlayConfig.rw_timeout * 1000;
            int i7 = netPlayConfig.buffer_timeout * 1000;
            if (i5 > 0) {
                setConnectTimeOut(i5);
            }
            if (i6 > 0) {
                setReciveDataTimeOut(i6);
            }
            if (i7 > 0) {
                setBufferTimeout(i7);
            }
            int i8 = netPlayConfig.datasource_async;
            if (i8 >= 0) {
                openImgoDSModule(i8 == 1);
            }
            if (netPlayConfig.getAddrinfo_type() != null) {
                setNetAddrinfo(netPlayConfig.getAddrinfo_type(), netPlayConfig.getAddrinfo_timeout(), false);
            }
            int i9 = netPlayConfig.dns_family_type;
            if (i9 == 0 || i9 == 1) {
                setDnsFamilyType(i9 == 0 ? 1 : 0);
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
    public void setOnFrameListener(IVideoView.OnFrameListener onFrameListener) {
        this.mOnFrameListener = onFrameListener;
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
        this.mVideoIntroduction = str;
        ReportParams reportParams = this.mReportParams;
        if (reportParams != null) {
            reportParams.setSvds(str);
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
}
