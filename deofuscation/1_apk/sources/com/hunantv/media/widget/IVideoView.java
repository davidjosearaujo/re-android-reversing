package com.hunantv.media.widget;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hunantv.media.config.NetPlayConfig;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.media.drm.MgtvDrmParams;
import com.hunantv.media.p2p.IP2pTask;
import com.hunantv.media.player.IMgtvRenderView;
import com.hunantv.media.player.MgtvMediaPlayer;
import com.hunantv.media.player.MgtvPlayerDataSource;
import com.hunantv.media.player.MgtvPlayerListener;
import com.hunantv.media.player.smooth.SmoothMediaSource;
import com.hunantv.media.player.statistic.FlowDataStatistic;
import com.hunantv.media.recoder.GifRecorder;
import com.hunantv.media.report.ReportParams;
import com.hunantv.media.widget.MgtvAbstractVideoView;
import com.hunantv.media.widget.debug.DebugPanel;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface IVideoView extends ISubtitle {
    public static final int IMGOMEDIA_ERROR_500005 = 500005;
    public static final int INFO_EXTRA_BUFFER_ACCSEEK = 5;
    public static final int INFO_EXTRA_BUFFER_FIRST_LOAD = 0;
    public static final int INFO_EXTRA_BUFFER_NORMAL = 1;
    public static final int INFO_EXTRA_BUFFER_SEEK = 2;
    public static final int INFO_EXTRA_BUFFER_SPEED = 3;
    public static final int INFO_EXTRA_BUFFER_SWITCH = 4;
    public static final int MEDIA_ERROR_ASYNC_INVALID_FORMAT_SOURCE = 7000013;
    public static final int MEDIA_ERROR_GIF = 7001999;
    public static final int MEDIA_ERROR_GIF_PREVIEW_IMAGE = 7001998;
    public static final int MEDIA_ERROR_ILLEGAL_ARGUMENT = 7000001;
    public static final int MEDIA_ERROR_ILLEGAL_STATE = 7000002;
    public static final int MEDIA_ERROR_INVALID_URL = 7000011;
    public static final int MEDIA_ERROR_IO = 7001004;
    public static final int MEDIA_ERROR_LIB_NOTLOAD = 7000010;
    public static final int MEDIA_ERROR_NULLPOINT = 7000005;
    public static final int MEDIA_ERROR_OPENGL = 7000110;
    public static final int MEDIA_ERROR_OPENVIDEO_FAILED = 7000003;
    public static final int MEDIA_ERROR_OUTOFMEM = 7000006;
    public static final int MEDIA_ERROR_SECURITY = 7000004;
    public static final int MEDIA_ERROR_SETSOURCE_FAILED = 7000012;
    public static final int MEDIA_ERROR_SURFACE_FAILED = 7000009;
    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_DECODER_TYPE_CHANGED = 5;
    public static final int MEDIA_INFO_DOWNLOAD_SPEED = 700001;
    public static final int MEDIA_INFO_INNER_BASE = 700000;
    public static final int MEDIA_INFO_LOOPSEEK_POS_ZERO = 2892;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
    public static final int MEDIA_INFO_NONET_BUFFER_NOENOUGH = 2893;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_RENDERING_START = 900;
    public static final int MEDIA_INFO_SPEED_RENDER_WARNING = 10011;
    public static final int MEDIA_INFO_UNKNOWN = 1;
    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    public static final int MEDIA_WARNING_HW_DECODE_FAILED = 80000001;
    public static final int MEDIA_WARNING_UNSUPPORT_HW_RENDER_FAILED = 80000002;
    public static final int MGTV_AR_16_9_FIT_PARENT = 4;
    public static final int MGTV_AR_4_3_FIT_PARENT = 5;
    public static final int MGTV_AR_ASPECT_FILL_PARENT = 1;
    public static final int MGTV_AR_ASPECT_FIT_PARENT = 0;
    public static final int MGTV_AR_ASPECT_WRAP_CONTENT = 2;
    public static final int MGTV_AR_MATCH_PARENT = 3;
    public static final int MODE_SMOOTHSWITCH_CLOSE = 0;
    public static final int MODE_SMOOTHSWITCH_OPEN = 1;
    public static final int MSG_SWITCH_VQ_COMPLETE_OK = 0;
    public static final int MSG_SWITCH_VQ_INFO_DATA_PREPARED = 2;
    public static final int READ_DATASOURCE_TYPE_DATA_SOURCE = 3;
    public static final int READ_DATASOURCE_TYPE_NORMAL = 0;
    public static final int READ_DATASOURCE_TYPE_P2P_DIRECT = 2;
    public static final int READ_DATASOURCE_TYPE_PROXY = 1;
    public static final int STATE_ERROR = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAYBACK_COMPLETED = 5;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_PREPARED = 2;
    public static final int STATE_PREPARING = 1;
    public static final int TYPE_NORMAL_MEMORY_PLAY = 1;
    public static final int TYPE_NO_MEMORY_PLAY = 0;
    public static final int TYPE_QUICK_MEMORY_PLAY = 2;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Configuration {
        public static final int MGTV_RENDER_SURFACE_VIEW = 0;
        public static final int MGTV_RENDER_TEXTURE_VIEW = 1;
        public int renderViewType = 0;
        public boolean enableTexture = true;
        public boolean opengl = false;
        public boolean isLiveMode = false;
        public boolean isLoopMode = false;
        public boolean forceReuseTexture = false;

        public Configuration setEnableTexture(boolean z) {
            this.enableTexture = z;
            return this;
        }

        public Configuration setForceReuseTexture(boolean z) {
            this.forceReuseTexture = z;
            return this;
        }

        public Configuration setLiveMode(boolean z) {
            this.isLiveMode = z;
            return this;
        }

        public Configuration setLoopMode(boolean z) {
            this.isLoopMode = z;
            return this;
        }

        public Configuration setOpengl(boolean z) {
            this.opengl = z;
            return this;
        }

        public Configuration setRenderViewType(int i) {
            this.renderViewType = i;
            return this;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class MediaSource {
        public IP2pTask p2pTask;
        public String proxyUrl;
        public int readType = 0;
        public String url;

        public MediaSource setP2pTask(IP2pTask iP2pTask) {
            this.p2pTask = iP2pTask;
            return this;
        }

        public MediaSource setProxyUrl(String str) {
            this.proxyUrl = str;
            return this;
        }

        public MediaSource setReadType(int i) {
            this.readType = i;
            return this;
        }

        public MediaSource setUrl(String str) {
            this.url = str;
            return this;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnAVPlayListener {
        void onAVPauseOrPlay(boolean z);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(int i);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnChangeSourceListener {
        void onChangeSourceFailed(String str, int i, int i2);

        void onChangeSourceInfo(String str, int i, int i2);

        void onChangeSourceSuccess(String str, int i, int i2);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnCompletionListener {
        public static final int COMPLETED_CONTEXT_MODIFY = 30012;
        public static final int COMPLETED_ERR_EOF = 30020;
        public static final int COMPLETED_ERR_SKIPTS = 30010;
        public static final int COMPLETED_ERR_SKIPTS_NUM = 30011;
        public static final int COMPLETED_HW_DISABLE = 30032;
        public static final int COMPLETED_HW_FAIL = 30031;
        public static final int COMPLETED_HW_UNSUPPORT = 30030;
        public static final int COMPLETED_OK = 0;

        void onCompletion(int i, int i2);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnErrorListener {
        boolean onError(int i, int i2);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnEventInfoListener {
        void onInfo(int i, int i2);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnFrameListener {
        void onVFrameClockCome(MgtvPlayerListener.FrameClock frameClock);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnInfoListener {
        boolean onInfo(int i, int i2);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnInfoStringListener {
        boolean onInfo(int i, String str);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnLoadDataListener {
        void onAfterLoadDataPaused();

        void onBeforeLoadDataResume();
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnPauseListener {
        void onPause();
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnPreparedListener {
        void onPrepared();
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnRecordListener {
        void onRecordError(int i, int i2);

        void onRecordInfo(int i, int i2);

        void onRecordStart(String str);

        void onRecordStop();
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnSeekCompleteListener {
        void onSeekComplete();
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnSpatializerInfoListener {
        void onSpatializerStateChanged(boolean z);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnStartListener {
        void onStart();
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnSwitchSmoothSourceListener {
        public static final int SMOOTH_SWITCH_INFO_SWITCHING = 3;

        void onSwitchSmoothSourceError(SmoothMediaSource smoothMediaSource, int i, int i2);

        void onSwitchSmoothSourceFail(SmoothMediaSource smoothMediaSource, int i, int i2);

        void onSwitchSmoothSourceInfo(SmoothMediaSource smoothMediaSource, int i);

        void onSwitchSmoothSourceSuccess(SmoothMediaSource smoothMediaSource);

        boolean onSwitchSmoothSourceWillUpdate(SmoothMediaSource smoothMediaSource);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnUpdateStatusListener {
        void onUpdateStatus();
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(int i, int i2);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum RenderFilter {
        NORMAL,
        UNSHARP_EDGE,
        UNSHARP_EDGE_COMPARE
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Size {
        public int height;
        public int width;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface SurfaceHolderListener {
        void surfaceChanged();

        void surfaceCreated();

        void surfaceDestroyed();
    }

    void addVideoPTSListener(MgtvPlayerListener.OnVideoPTSListener onVideoPTSListener);

    void bindDrmSession(IDrmSession iDrmSession);

    void changeSourceAsync(MediaSource mediaSource, int i, int i2, int i3);

    void changeSourceAsync(String str, int i, int i2, int i3);

    void cleanUri();

    void configDataCacheSizeKB(int i);

    void configLoadMaxRetryTime(int i);

    void configTsNotSkip(boolean z);

    void configWeakBufferTimeout(int i);

    void configWeakNetSpeed(int i);

    @Deprecated
    void convertRender(int i);

    void enableCoreStartPauseListen(boolean z);

    void enableFramePTSNotify(boolean z);

    void enableImgoAIQE(boolean z);

    void enableImgoVSR(boolean z);

    void enableLiveLowLatency(boolean z);

    void enableM3u8Cache(boolean z);

    void enableMediaCodecSW(boolean z);

    void enableOppoFunc(int i, boolean z);

    void enableSpatializer(boolean z);

    void enableTsSkipError(boolean z);

    MgtvAbstractVideoView.ABRegion getABRegion();

    int getAMCKeyFrameBackMode();

    int getAddrInfoTypeInt();

    IDrmSession getBindDrmSession();

    int getBitRate();

    long getBufferedPositionMs();

    int getBufferingPercentage();

    int getCurrentPosition();

    int getCurrentPositionUnsafe();

    int getCurrentStatus();

    Uri getCurrentUri();

    int getDLSpeedB();

    String getDLSpeedFormat();

    MgtvMediaPlayer.DataSourceType getDataSourceType();

    IMgtvRenderView.FloatRect getDisplayFloatRect();

    int getDnsFamilyType();

    int getDuration();

    String getErrorMsg();

    String getErrorUrl();

    int getFPS();

    float getFileStartTimeFloatS();

    FlowDataStatistic getFlowDataStatistic();

    GifRecorder getGifRecorder();

    byte[] getKeyInfoData();

    String getLastErrorTypeCode();

    String getLastIP();

    float getLeftVolume();

    String getLogTag();

    String getLogTagKey();

    MgtvMediaPlayer getMediaPlayer();

    int getMemoryPlayType();

    int getMgtvAudioEffectChoice();

    int getMgtvFastMode();

    float getPlaybackSpeed();

    @Nullable
    MgtvMediaPlayer.PlayerExtraInfo getPlayerExtraInfo();

    String getPlayerVersion();

    MgtvMediaPlayer.Prepared4StartMode getPrepared4StartMode();

    long getPropertyLong(int i, long j);

    int getReadDataSourceType();

    RenderFilter getRenderFilter();

    View getRenderView();

    Size getRenderViewSize();

    int getRenderViewType();

    ReportParams getReportParams();

    float getRightVolume();

    Bitmap getSnapshot(int i, int i2);

    int getTotalBuffering();

    int getVideoHeight();

    String getVideoPath();

    String getVideoProxyPath();

    int getVideoWidth();

    boolean isAccurateSeekEnable();

    boolean isAntiViewShake();

    boolean isBackPlayEnable();

    boolean isBackground();

    boolean isCompletion();

    boolean isDataLoadPaused();

    boolean isForceHttpDns();

    boolean isHardware();

    boolean isImgoSourceModuleOpen();

    boolean isKeyInfoDataSet();

    boolean isMediaCodecSWEnable();

    boolean isMgtvAudioEffectValid();

    boolean isOnlyAudioMode();

    boolean isPlaying();

    boolean isPrepared();

    boolean isRecording();

    boolean isRendered();

    boolean isSmoothSwitchOpen();

    boolean isSupportAMCKeyFrameBackup();

    boolean isSupportedSnapshot();

    boolean isTsSkipErrorEnable();

    void nativeCrashTest(int i);

    void openImgoDSModule(boolean z);

    void pause();

    void pauseLoadData();

    void reBindTexture();

    void release();

    void removeVideoPTSListener(MgtvPlayerListener.OnVideoPTSListener onVideoPTSListener);

    void reset();

    void resetRender();

    void resetVideoPath(@NonNull String str);

    void resetVideoPath(@NonNull String str, @Nullable IP2pTask iP2pTask, @Nullable String str2);

    void resume();

    void resumeLoadData();

    void seekTo(int i);

    void seekTo(int i, boolean z);

    void setAMCKeyFrameBackMode(int i);

    @Deprecated
    void setAccurateSeekEnable(boolean z);

    void setAntiViewShake(boolean z);

    void setAspectRatio(int i);

    void setAudioPath(@NonNull String str);

    void setBackPlayEnable(boolean z);

    void setBackground(boolean z);

    void setBufferTimeout(int i);

    void setConnectTimeOut(int i);

    void setDataSourceInfo(MgtvMediaPlayer.DataSourceInfo dataSourceInfo);

    void setDisableAudioFocus(boolean z);

    void setDisplayFloatRect(IMgtvRenderView.FloatRect floatRect);

    void setDnsFamilyType(int i);

    void setDrmInfoList(List<MgtvDrmParams.DrmInfo> list);

    void setDrmLicensePrepared();

    void setEnableVideoStartTime(boolean z);

    void setFileStartTimeFloatS(float f);

    void setFlowDataStatistic(FlowDataStatistic flowDataStatistic);

    void setForceDecodeMode(boolean z);

    void setForceHttpDns(boolean z);

    int setKeyInfoData(String str);

    int setKeyInfoData(byte[] bArr, int i, int i2);

    void setLastFrameRecovery(boolean z);

    void setLiveMode(boolean z);

    void setLiveReopen();

    void setLiveStartIndex(int i);

    boolean setLoopABPlay(boolean z, MgtvAbstractVideoView.ABRegion aBRegion);

    void setLoopSeekPlay(boolean z, int i);

    void setM3u8Caches(String str, String[] strArr);

    void setMediacodecRecreateformat(boolean z, boolean z2);

    void setMgtvAudioEffectChoice(int i);

    int setMgtvAudioEffectConfig(byte[] bArr);

    void setMgtvAudioEffectEnable(boolean z);

    void setMgtvFastMode(int i);

    void setNETIsBroken(boolean z);

    void setNetAddrinfo(int i, int i2);

    void setNetAddrinfo(int i, int i2, boolean z);

    void setNetAddrinfo(String str, int i, boolean z);

    void setNetPlayConfig(NetPlayConfig netPlayConfig);

    void setOnAVPlayListener(OnAVPlayListener onAVPlayListener);

    void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnChangeSourceListener(OnChangeSourceListener onChangeSourceListener);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnEventInfoListener(OnEventInfoListener onEventInfoListener);

    void setOnFrameListener(OnFrameListener onFrameListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnInfoStringListener(OnInfoStringListener onInfoStringListener);

    void setOnLoadDataListener(OnLoadDataListener onLoadDataListener);

    void setOnPauseListener(OnPauseListener onPauseListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnRecordListener(OnRecordListener onRecordListener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setOnSpatializerInfoListener(OnSpatializerInfoListener onSpatializerInfoListener);

    void setOnStartListener(OnStartListener onStartListener);

    void setOnSwitchSmoothSourceListener(OnSwitchSmoothSourceListener onSwitchSmoothSourceListener);

    void setOnUpdateStatusListener(OnUpdateStatusListener onUpdateStatusListener);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setOnWarningListener(MgtvPlayerListener.OnWarningListener onWarningListener);

    void setPlaybackSpeed(float f);

    void setPlayerDebug(boolean z);

    void setPlayerHardwareMode(boolean z);

    void setPreBufferTimeoutMs(int i);

    void setPrepared4StartMode(MgtvMediaPlayer.Prepared4StartMode prepared4StartMode);

    void setReadDataSourceType(int i);

    void setReciveDataTimeOut(int i);

    void setRenderFilter(RenderFilter renderFilter);

    void setRenderViewVisible(int i);

    void setReportParams(ReportParams reportParams);

    void setScreenOnWhilePlaying(boolean z);

    void setSecure(boolean z);

    void setSeekAutoStartAfterComplete(boolean z);

    void setSkipLoopFilter(MgtvMediaPlayer.SkipLoopFilterType skipLoopFilterType);

    int setSmoothKeyFrameInfo(byte[] bArr, String str, String str2);

    void setSmoothSwitchMode(int i);

    void setStartPosMs(int i);

    void setStreamKey(int i);

    void setSurfaceHolderListener(SurfaceHolderListener surfaceHolderListener);

    void setTimeout(int i, int i2);

    void setTsFlowTag(String str);

    void setVideoDataSource(MgtvPlayerDataSource mgtvPlayerDataSource);

    void setVideoFrameClockNotifyMs(int i);

    void setVideoFrameClockNotifyPts(long j, long j2);

    void setVideoIntroduction(String str);

    void setVideoPath(@NonNull String str);

    void setVideoPath(@NonNull String str, @Nullable IP2pTask iP2pTask, @Nullable String str2);

    void setVolume(float f, float f2);

    void setZOrderMediaOverlay(boolean z);

    DebugPanel showDebugPanel(boolean z);

    void start();

    void startAVDecoder();

    void startRecord(String str);

    void stepPlaybackNextFrame();

    void stop();

    void stopRecord();

    boolean support3X();

    boolean supportImgoAIQE(MgtvMediaPlayer.ImgoAIQE imgoAIQE);

    float supportMaxSpeed();

    void switchSmoothSource(SmoothMediaSource smoothMediaSource);

    void useSystemPlayer(boolean z);
}
