package com.hunantv.media.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hunantv.imgo.nightmode.view.SkinnableFrameLayout;
import com.hunantv.media.config.NetPlayConfig;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.media.drm.MgtvDrmParams;
import com.hunantv.media.p2p.IP2pTask;
import com.hunantv.media.player.IMgtvRenderView;
import com.hunantv.media.player.MgtvMediaPlayer;
import com.hunantv.media.player.MgtvPlayerDataSource;
import com.hunantv.media.player.MgtvPlayerListener;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.player.smooth.SmoothMediaSource;
import com.hunantv.media.player.statistic.FlowDataStatistic;
import com.hunantv.media.player.subtitle.SubtitleSource;
import com.hunantv.media.player.utils.ExTicker;
import com.hunantv.media.player.utils.ThreadUtil;
import com.hunantv.media.recoder.GifRecorder;
import com.hunantv.media.report.ReportParams;
import com.hunantv.media.widget.ISubtitle;
import com.hunantv.media.widget.IVideoView;
import com.hunantv.media.widget.MgtvAbstractVideoView;
import com.hunantv.media.widget.debug.DebugPanel;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class FakeVideoView extends SkinnableFrameLayout implements IVideoView {
    private static final String TAG = "FakeVideoView";
    public int duration;
    public ExTicker exTicker;
    public boolean isPlaying;
    public boolean isPrepared;
    public boolean isRendered;
    private int mCurrentState;
    public IVideoView.OnInfoListener onInfoListener;
    public IVideoView.OnPauseListener onPauseListener;
    public IVideoView.OnPreparedListener onPreparedListener;
    public IVideoView.OnSeekCompleteListener onSeekCompleteListener;
    public IVideoView.OnStartListener onStartListener;
    public IVideoView.OnUpdateStatusListener onUpdateStatusListener;

    public FakeVideoView(Context context) {
        super(context);
        this.exTicker = new ExTicker(1000);
        this.duration = 10800000;
        this.mCurrentState = 0;
    }

    public FakeVideoView(Context context, int i) {
        super(context);
        this.exTicker = new ExTicker(1000);
        this.duration = 10800000;
        this.mCurrentState = 0;
    }

    public FakeVideoView(Context context, int i, boolean z) {
        super(context);
        this.exTicker = new ExTicker(1000);
        this.duration = 10800000;
        this.mCurrentState = 0;
    }

    public FakeVideoView(Context context, int i, boolean z, boolean z2) {
        super(context);
        this.exTicker = new ExTicker(1000);
        this.duration = 10800000;
        this.mCurrentState = 0;
    }

    public FakeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.exTicker = new ExTicker(1000);
        this.duration = 10800000;
        this.mCurrentState = 0;
    }

    public FakeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.exTicker = new ExTicker(1000);
        this.duration = 10800000;
        this.mCurrentState = 0;
    }

    public FakeVideoView(Context context, IVideoView.Configuration configuration) {
        super(context);
        this.exTicker = new ExTicker(1000);
        this.duration = 10800000;
        this.mCurrentState = 0;
    }

    private void resetData() {
        setCurrentState(0);
        this.isPrepared = false;
        this.isPlaying = false;
        this.isRendered = false;
        this.exTicker.stop();
    }

    private void sendPrepared() {
        DebugLog.i(TAG, "sendPrepared in");
        setCurrentState(2);
        this.isPrepared = true;
        if (this.onPreparedListener != null) {
            DebugLog.i(TAG, "sendPrepared");
            this.onPreparedListener.onPrepared();
        }
    }

    private void sendRenderStart() {
        this.isRendered = true;
        ThreadUtil.postOnUiThread(new Runnable() { // from class: com.hunantv.media.widget.FakeVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                FakeVideoView.this.exTicker.start();
                FakeVideoView.this.exTicker.setCallback(new ExTicker.onTickListener() { // from class: com.hunantv.media.widget.FakeVideoView.1.1
                    @Override // com.hunantv.media.player.utils.ExTicker.onTickListener
                    public void onTick(int i) {
                    }
                });
                if (FakeVideoView.this.onInfoListener != null) {
                    DebugLog.i(FakeVideoView.TAG, "sendRenderStart in");
                    FakeVideoView.this.onInfoListener.onInfo(900, 0);
                }
            }
        });
    }

    private void sendUpdateStatus() {
        IVideoView.OnUpdateStatusListener onUpdateStatusListener = this.onUpdateStatusListener;
        if (onUpdateStatusListener != null) {
            onUpdateStatusListener.onUpdateStatus();
        }
    }

    private void setCurrentState(int i) {
        this.mCurrentState = i;
        sendUpdateStatus();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void addVideoPTSListener(MgtvPlayerListener.OnVideoPTSListener onVideoPTSListener) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void bindDrmSession(IDrmSession iDrmSession) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void changeSourceAsync(IVideoView.MediaSource mediaSource, int i, int i2, int i3) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void changeSourceAsync(String str, int i, int i2, int i3) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void cleanUri() {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void configDataCacheSizeKB(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void configLoadMaxRetryTime(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void configTsNotSkip(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void configWeakBufferTimeout(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void configWeakNetSpeed(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void convertRender(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableCoreStartPauseListen(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableFramePTSNotify(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableImgoAIQE(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableImgoVSR(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableLiveLowLatency(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableM3u8Cache(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableMediaCodecSW(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableOppoFunc(int i, boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableSpatializer(boolean z) {
    }

    @Override // com.hunantv.media.widget.ISubtitle
    public void enableSubtitle(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void enableTsSkipError(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public MgtvAbstractVideoView.ABRegion getABRegion() {
        return null;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getAMCKeyFrameBackMode() {
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getAddrInfoTypeInt() {
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public IDrmSession getBindDrmSession() {
        return null;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getBitRate() {
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public long getBufferedPositionMs() {
        return 0L;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getBufferingPercentage() {
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getCurrentPosition() {
        return this.exTicker.getTickCount() * 1000;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getCurrentPositionUnsafe() {
        return this.exTicker.getTickCount() * 1000;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getCurrentStatus() {
        return this.mCurrentState;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public Uri getCurrentUri() {
        return null;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getDLSpeedB() {
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public String getDLSpeedFormat() {
        return null;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public MgtvMediaPlayer.DataSourceType getDataSourceType() {
        return null;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public IMgtvRenderView.FloatRect getDisplayFloatRect() {
        return new IMgtvRenderView.FloatRect();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getDnsFamilyType() {
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getDuration() {
        return this.duration;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public String getErrorMsg() {
        return "";
    }

    @Override // com.hunantv.media.widget.IVideoView
    public String getErrorUrl() {
        return "";
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getFPS() {
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public float getFileStartTimeFloatS() {
        return 0.0f;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public FlowDataStatistic getFlowDataStatistic() {
        return new FlowDataStatistic();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public GifRecorder getGifRecorder() {
        return new GifRecorder();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public byte[] getKeyInfoData() {
        return new byte[0];
    }

    @Override // com.hunantv.media.widget.IVideoView
    public String getLastErrorTypeCode() {
        return "";
    }

    @Override // com.hunantv.media.widget.IVideoView
    public String getLastIP() {
        return null;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public float getLeftVolume() {
        return 0.0f;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public String getLogTag() {
        return "[" + getLogTagKey() + "][" + getClass().getSimpleName() + "]";
    }

    @Override // com.hunantv.media.widget.IVideoView
    public String getLogTagKey() {
        return hashCode() + "";
    }

    @Override // com.hunantv.media.widget.IVideoView
    public MgtvMediaPlayer getMediaPlayer() {
        return null;
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
    public int getMgtvFastMode() {
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public float getPlaybackSpeed() {
        return 0.0f;
    }

    @Override // com.hunantv.media.widget.IVideoView
    @Nullable
    public MgtvMediaPlayer.PlayerExtraInfo getPlayerExtraInfo() {
        return new MgtvMediaPlayer.PlayerExtraInfo();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public String getPlayerVersion() {
        return "Fake1.0";
    }

    @Override // com.hunantv.media.widget.IVideoView
    public MgtvMediaPlayer.Prepared4StartMode getPrepared4StartMode() {
        return MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_LOADDATA;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public long getPropertyLong(int i, long j) {
        return 0L;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getReadDataSourceType() {
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public IVideoView.RenderFilter getRenderFilter() {
        return null;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public View getRenderView() {
        return null;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public IVideoView.Size getRenderViewSize() {
        return new IVideoView.Size();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getRenderViewType() {
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public ReportParams getReportParams() {
        return null;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public float getRightVolume() {
        return 0.0f;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public Bitmap getSnapshot(int i, int i2) {
        return null;
    }

    @Override // com.hunantv.media.widget.ISubtitle
    @Nullable
    public SubtitleSource getSubtitleSource() {
        return null;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getTotalBuffering() {
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getVideoHeight() {
        return 1080;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public String getVideoPath() {
        return "";
    }

    @Override // com.hunantv.media.widget.IVideoView
    public String getVideoProxyPath() {
        return "";
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int getVideoWidth() {
        return 1920;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isAccurateSeekEnable() {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isAntiViewShake() {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isBackPlayEnable() {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isBackground() {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isCompletion() {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isDataLoadPaused() {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isForceHttpDns() {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isHardware() {
        return true;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isImgoSourceModuleOpen() {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isKeyInfoDataSet() {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isMediaCodecSWEnable() {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isMgtvAudioEffectValid() {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isOnlyAudioMode() {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isPlaying() {
        return this.isPlaying;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isPrepared() {
        return this.isPrepared;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isRecording() {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isRendered() {
        return this.isRendered;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isSmoothSwitchOpen() {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isSupportAMCKeyFrameBackup() {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isSupportedSnapshot() {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean isTsSkipErrorEnable() {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void nativeCrashTest(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void openImgoDSModule(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void pause() {
        DebugLog.i(TAG, "pause");
        setCurrentState(4);
        this.isPlaying = false;
        this.exTicker.pause();
        IVideoView.OnPauseListener onPauseListener = this.onPauseListener;
        if (onPauseListener != null) {
            onPauseListener.onPause();
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void pauseLoadData() {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void reBindTexture() {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void release() {
        DebugLog.i(TAG, "release");
        resetData();
    }

    @Override // com.hunantv.media.widget.ISubtitle
    public void removeSubtitleSource() {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void removeVideoPTSListener(MgtvPlayerListener.OnVideoPTSListener onVideoPTSListener) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void reset() {
        DebugLog.i(TAG, "reset");
        resetData();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void resetRender() {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void resetVideoPath(@NonNull String str) {
        DebugLog.i(TAG, "resetVideoPath path:" + str);
        sendPrepared();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void resetVideoPath(@NonNull String str, @Nullable IP2pTask iP2pTask, @Nullable String str2) {
        DebugLog.i(TAG, "resetVideoPath path:" + str);
        sendPrepared();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void resume() {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void resumeLoadData() {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void seekTo(int i) {
        this.exTicker.seekto(i / 1000);
        IVideoView.OnSeekCompleteListener onSeekCompleteListener = this.onSeekCompleteListener;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete();
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void seekTo(int i, boolean z) {
        this.exTicker.seekto(i / 1000);
        IVideoView.OnSeekCompleteListener onSeekCompleteListener = this.onSeekCompleteListener;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete();
        }
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setAMCKeyFrameBackMode(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setAccurateSeekEnable(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setAntiViewShake(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setAspectRatio(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setAudioPath(@NonNull String str) {
        setCurrentState(1);
        sendPrepared();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setBackPlayEnable(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setBackground(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setBufferTimeout(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setConnectTimeOut(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setDataSourceInfo(MgtvMediaPlayer.DataSourceInfo dataSourceInfo) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setDisableAudioFocus(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setDisplayFloatRect(IMgtvRenderView.FloatRect floatRect) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setDnsFamilyType(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setDrmInfoList(List<MgtvDrmParams.DrmInfo> list) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setDrmLicensePrepared() {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setEnableVideoStartTime(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setFileStartTimeFloatS(float f) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setFlowDataStatistic(FlowDataStatistic flowDataStatistic) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setForceDecodeMode(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setForceHttpDns(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int setKeyInfoData(String str) {
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int setKeyInfoData(byte[] bArr, int i, int i2) {
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setLastFrameRecovery(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setLiveMode(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setLiveReopen() {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setLiveStartIndex(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean setLoopABPlay(boolean z, MgtvAbstractVideoView.ABRegion aBRegion) {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setLoopSeekPlay(boolean z, int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setM3u8Caches(String str, String[] strArr) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setMediacodecRecreateformat(boolean z, boolean z2) {
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
    public void setMgtvFastMode(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setNETIsBroken(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setNetAddrinfo(int i, int i2) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setNetAddrinfo(int i, int i2, boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setNetAddrinfo(String str, int i, boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setNetPlayConfig(NetPlayConfig netPlayConfig) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnAVPlayListener(IVideoView.OnAVPlayListener onAVPlayListener) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnBufferingUpdateListener(IVideoView.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnChangeSourceListener(IVideoView.OnChangeSourceListener onChangeSourceListener) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnCompletionListener(IVideoView.OnCompletionListener onCompletionListener) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnErrorListener(IVideoView.OnErrorListener onErrorListener) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnEventInfoListener(IVideoView.OnEventInfoListener onEventInfoListener) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnFrameListener(IVideoView.OnFrameListener onFrameListener) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnInfoListener(IVideoView.OnInfoListener onInfoListener) {
        this.onInfoListener = onInfoListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnInfoStringListener(IVideoView.OnInfoStringListener onInfoStringListener) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnLoadDataListener(IVideoView.OnLoadDataListener onLoadDataListener) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnPauseListener(IVideoView.OnPauseListener onPauseListener) {
        this.onPauseListener = onPauseListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnPreparedListener(IVideoView.OnPreparedListener onPreparedListener) {
        this.onPreparedListener = onPreparedListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnRecordListener(IVideoView.OnRecordListener onRecordListener) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnSeekCompleteListener(IVideoView.OnSeekCompleteListener onSeekCompleteListener) {
        this.onSeekCompleteListener = onSeekCompleteListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnSpatializerInfoListener(IVideoView.OnSpatializerInfoListener onSpatializerInfoListener) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnStartListener(IVideoView.OnStartListener onStartListener) {
        this.onStartListener = onStartListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnSwitchSmoothSourceListener(IVideoView.OnSwitchSmoothSourceListener onSwitchSmoothSourceListener) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnUpdateStatusListener(IVideoView.OnUpdateStatusListener onUpdateStatusListener) {
        this.onUpdateStatusListener = onUpdateStatusListener;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnVideoSizeChangedListener(IVideoView.OnVideoSizeChangedListener onVideoSizeChangedListener) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setOnWarningListener(MgtvPlayerListener.OnWarningListener onWarningListener) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setPlaybackSpeed(float f) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setPlayerDebug(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setPlayerHardwareMode(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setPreBufferTimeoutMs(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setPrepared4StartMode(MgtvMediaPlayer.Prepared4StartMode prepared4StartMode) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setReadDataSourceType(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setReciveDataTimeOut(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setRenderFilter(IVideoView.RenderFilter renderFilter) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setRenderViewVisible(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setReportParams(ReportParams reportParams) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setScreenOnWhilePlaying(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setSecure(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setSeekAutoStartAfterComplete(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setSkipLoopFilter(MgtvMediaPlayer.SkipLoopFilterType skipLoopFilterType) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public int setSmoothKeyFrameInfo(byte[] bArr, String str, String str2) {
        return 0;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setSmoothSwitchMode(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setStartPosMs(int i) {
        this.exTicker.seekto(i / 1000);
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setStreamKey(int i) {
    }

    @Override // com.hunantv.media.widget.ISubtitle
    public void setSubtitleCallback(ISubtitle.SubtitleCallback subtitleCallback) {
    }

    @Override // com.hunantv.media.widget.ISubtitle
    public void setSubtitleSource(SubtitleSource subtitleSource) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setSurfaceHolderListener(IVideoView.SurfaceHolderListener surfaceHolderListener) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setTimeout(int i, int i2) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setTsFlowTag(String str) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setVideoDataSource(MgtvPlayerDataSource mgtvPlayerDataSource) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setVideoFrameClockNotifyMs(int i) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setVideoFrameClockNotifyPts(long j, long j2) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setVideoIntroduction(String str) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setVideoPath(@NonNull String str) {
        DebugLog.i(TAG, "setVideoPath path:" + str);
        setCurrentState(1);
        sendPrepared();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setVideoPath(@NonNull String str, @Nullable IP2pTask iP2pTask, @Nullable String str2) {
        DebugLog.i(TAG, "setVideoPath path:" + str);
        sendPrepared();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setVolume(float f, float f2) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void setZOrderMediaOverlay(boolean z) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public DebugPanel showDebugPanel(boolean z) {
        return null;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void start() {
        DebugLog.i(TAG, "start");
        setCurrentState(3);
        this.isPlaying = true;
        this.exTicker.resume();
        IVideoView.OnStartListener onStartListener = this.onStartListener;
        if (onStartListener != null) {
            onStartListener.onStart();
        }
        if (this.isRendered) {
            return;
        }
        sendRenderStart();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void startAVDecoder() {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void startRecord(String str) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void stepPlaybackNextFrame() {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void stop() {
        DebugLog.i(TAG, "stop");
        resetData();
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void stopRecord() {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean support3X() {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public boolean supportImgoAIQE(MgtvMediaPlayer.ImgoAIQE imgoAIQE) {
        return false;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public float supportMaxSpeed() {
        return 0.0f;
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void switchSmoothSource(SmoothMediaSource smoothMediaSource) {
    }

    @Override // com.hunantv.media.widget.IVideoView
    public void useSystemPlayer(boolean z) {
    }
}
