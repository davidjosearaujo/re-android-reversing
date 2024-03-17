package com.hunantv.media.player.smooth;

import a.a.a.b.a;
import com.hunantv.media.p2p.IP2pTask;
import com.hunantv.media.player.MgtvMediaPlayer;
import com.hunantv.media.player.MgtvMediaSource;
import com.hunantv.media.player.datasource.p2p.MGTVP2pDirectMediaDataSource;
import com.hunantv.media.player.flow.FlowReportProcessor;
import com.hunantv.media.player.utils.UrlUtil;
import com.hunantv.media.report.ReportParams;
import com.hunantv.media.utils.NumericUtil;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SmoothMediaSource extends MgtvMediaSource {
    public static final int SMOOTH_LEVEL1 = 0;
    public static final int SMOOTH_LEVEL2 = 1;
    public static final int SMOOTH_LEVEL3 = 2;
    public static final int SWITCHMOD_NORMAL = 0;
    public static final int SWITCHMOD_ONLY_AUDIO = 1;
    public String backupUrlJson;
    private MgtvMediaPlayer bindPlayer;
    private Object data;
    private boolean enableImgoAIQE;
    public volatile FlowReportProcessor flowReportProcessor;
    private Object flowReporterLocker;
    public boolean isp2p;
    public boolean lastRetry;
    private int level;
    private MGTVP2pDirectMediaDataSource p2pDirectSource;
    private ReportParams reportParams;
    private a reporter;
    public int retry;
    public volatile long s_event_0_timestamp;
    public volatile long s_event_11_timestamp;
    public volatile long s_event_2_timestamp;
    public volatile long s_event_3_timestamp;
    public int switchMod;
    public boolean throwErrorIfSwitchFailed;
    public String tsFlowTag;
    private String updateUrl;
    private String vfps;
    public String videoFileHash;

    public SmoothMediaSource(int i, String str) {
        super(i, str);
        this.level = 1;
        this.vfps = "0";
        this.enableImgoAIQE = false;
        this.flowReporterLocker = new Object();
    }

    public SmoothMediaSource(int i, String str, String str2) {
        super(i, str, str2);
        this.level = 1;
        this.vfps = "0";
        this.enableImgoAIQE = false;
        this.flowReporterLocker = new Object();
    }

    public SmoothMediaSource(int i, String str, String str2, int i2) {
        super(i, str, str2);
        this.level = 1;
        this.vfps = "0";
        this.enableImgoAIQE = false;
        this.flowReporterLocker = new Object();
        this.switchMod = i2;
    }

    public SmoothMediaSource(String str) {
        super(str);
        this.level = 1;
        this.vfps = "0";
        this.enableImgoAIQE = false;
        this.flowReporterLocker = new Object();
    }

    private boolean isFileFormat(String str) {
        return str != null && str.equalsIgnoreCase(this.fileFormat);
    }

    public void bind(MgtvMediaPlayer mgtvMediaPlayer) {
        if (this.bindPlayer != mgtvMediaPlayer) {
            this.bindPlayer = mgtvMediaPlayer;
            this.reporter = new a(mgtvMediaPlayer, true);
            if (this.reportParams == null) {
                MgtvMediaPlayer mgtvMediaPlayer2 = this.bindPlayer;
                if (mgtvMediaPlayer2 != null) {
                    this.reportParams = new ReportParams(mgtvMediaPlayer2.getReportParams());
                } else {
                    this.reportParams = new ReportParams();
                }
            }
            this.url = FlowReportProcessor.replaceUrlSftcNoP2p(this.url, this.reportParams);
            String replaceUrlSftcNoP2p = FlowReportProcessor.replaceUrlSftcNoP2p(this.proxyUrl, this.reportParams);
            this.proxyUrl = replaceUrlSftcNoP2p;
            if (this.readType == 0) {
                replaceUrlSftcNoP2p = this.url;
            }
            this.playingUrl = replaceUrlSftcNoP2p;
            if (this.reportParams.getVideoType() == ReportParams.VideoType.VOD && this.switchMod == 1) {
                this.reportParams.setVideoType(ReportParams.VideoType.VOD_AUDIO);
            }
            this.reportParams.setDef(this.def);
            this.reportParams.setUrl(UrlUtil.getHostName(this.url));
            this.reportParams.setVideoFileHash(this.videoFileHash);
            this.reporter.m(this);
            this.reporter.n(this.reportParams);
        }
    }

    public void genFlowReporter() {
        ReportParams reportParams;
        synchronized (this.flowReporterLocker) {
            if (this.flowReportProcessor == null && (reportParams = this.reportParams) != null) {
                this.flowReportProcessor = new FlowReportProcessor(this.url, this.reportParams.getVid(), NumericUtil.parseInt(this.reportParams.getDef()), this.reportParams.getVideoSession(), this.p2pTask != null && (reportParams.getProxyType() == ReportParams.ProxyType.ONLY_P2P || this.reportParams.getProxyType() == ReportParams.ProxyType.P2P_DRM), "smooth");
            }
        }
    }

    public int getArg() {
        if (isFileFormat(MgtvMediaSource.HLS_TS)) {
            return 1;
        }
        if (isFileFormat(MgtvMediaSource.HLS_FMP4)) {
            return 2;
        }
        if (isFileFormat(MgtvMediaSource.MPEG_TS)) {
            return 3;
        }
        if (isFileFormat(MgtvMediaSource.MPEG_4)) {
            return 4;
        }
        return isFileFormat(MgtvMediaSource.FLV) ? 5 : 0;
    }

    public String getBackupUrlJson() {
        return this.backupUrlJson;
    }

    public Object getData() {
        return this.data;
    }

    @Override // com.hunantv.media.player.MgtvMediaSource
    public String getDef() {
        return super.getDef();
    }

    public boolean getEnableImgoAIQE() {
        return this.enableImgoAIQE;
    }

    public FlowReportProcessor getFlowReportProcessor() {
        FlowReportProcessor flowReportProcessor;
        synchronized (this.flowReporterLocker) {
            flowReportProcessor = this.flowReportProcessor;
        }
        return flowReportProcessor;
    }

    public int getLevel() {
        return this.level;
    }

    public MGTVP2pDirectMediaDataSource getP2pDirectSource() {
        return this.p2pDirectSource;
    }

    public ReportParams getReportParams() {
        return this.reportParams;
    }

    public a getReporter() {
        return this.reporter;
    }

    public int getRetry() {
        return this.retry;
    }

    public int getSwitchMod() {
        return this.switchMod;
    }

    public String getTsFlowTag() {
        return this.tsFlowTag;
    }

    public String getUpdateUrl() {
        return this.updateUrl;
    }

    public long getVVTimeT1() {
        if (this.s_event_0_timestamp <= 0 || this.s_event_2_timestamp <= 0) {
            return -1L;
        }
        return this.s_event_2_timestamp - this.s_event_0_timestamp;
    }

    public long getVVTimeT4() {
        if (this.s_event_2_timestamp <= 0 || this.s_event_3_timestamp <= 0) {
            return -1L;
        }
        return this.s_event_3_timestamp - this.s_event_2_timestamp;
    }

    public long getVVTimeT6() {
        if (this.s_event_3_timestamp <= 0 || this.s_event_11_timestamp <= 0) {
            return -1L;
        }
        return this.s_event_11_timestamp - this.s_event_3_timestamp;
    }

    public long getVVTimeVVT() {
        if (this.s_event_0_timestamp <= 0 || this.s_event_11_timestamp <= 0) {
            return -1L;
        }
        return this.s_event_11_timestamp - this.s_event_0_timestamp;
    }

    public String getVfps() {
        return this.vfps;
    }

    @Override // com.hunantv.media.player.MgtvMediaSource
    public String getVid() {
        return super.getVid();
    }

    @Override // com.hunantv.media.player.MgtvMediaSource
    public String getVsri() {
        return super.getVsri();
    }

    public boolean isIsp2p() {
        return this.isp2p;
    }

    public boolean isLastRetry() {
        return this.lastRetry;
    }

    public boolean isThrowErrorIfSwitchFailed() {
        return this.throwErrorIfSwitchFailed;
    }

    @Override // com.hunantv.media.player.MgtvMediaSource
    public synchronized void release() {
        super.release();
        MGTVP2pDirectMediaDataSource mGTVP2pDirectMediaDataSource = this.p2pDirectSource;
        if (mGTVP2pDirectMediaDataSource != null) {
            mGTVP2pDirectMediaDataSource.release();
        }
    }

    @Override // com.hunantv.media.player.MgtvMediaSource
    public SmoothMediaSource setAudioFormat(String str) {
        super.setAudioFormat(str);
        return this;
    }

    public SmoothMediaSource setBackupUrlJson(String str) {
        this.backupUrlJson = str;
        return this;
    }

    public SmoothMediaSource setData(Object obj) {
        this.data = obj;
        return this;
    }

    @Override // com.hunantv.media.player.MgtvMediaSource
    public SmoothMediaSource setDef(String str) {
        super.setDef(str);
        return this;
    }

    public SmoothMediaSource setEnableImgoAIQE(boolean z) {
        this.enableImgoAIQE = z;
        return this;
    }

    @Override // com.hunantv.media.player.MgtvMediaSource
    public SmoothMediaSource setFileFormat(String str) {
        super.setFileFormat(str);
        return this;
    }

    public SmoothMediaSource setIsp2p(boolean z) {
        this.isp2p = z;
        return this;
    }

    public SmoothMediaSource setLastRetry(boolean z) {
        this.lastRetry = z;
        return this;
    }

    public SmoothMediaSource setLevel(int i) {
        this.level = i;
        return this;
    }

    public SmoothMediaSource setP2pDirectSource(MGTVP2pDirectMediaDataSource mGTVP2pDirectMediaDataSource) {
        this.p2pDirectSource = mGTVP2pDirectMediaDataSource;
        IP2pTask iP2pTask = this.p2pTask;
        if (iP2pTask != null) {
            mGTVP2pDirectMediaDataSource.setP2pTask(iP2pTask.getImgoTask());
        }
        return this;
    }

    @Override // com.hunantv.media.player.MgtvMediaSource
    public SmoothMediaSource setP2pTask(IP2pTask iP2pTask) {
        super.setP2pTask(iP2pTask);
        MGTVP2pDirectMediaDataSource mGTVP2pDirectMediaDataSource = this.p2pDirectSource;
        if (mGTVP2pDirectMediaDataSource != null && iP2pTask != null) {
            mGTVP2pDirectMediaDataSource.setP2pTask(iP2pTask.getImgoTask());
        }
        return this;
    }

    @Override // com.hunantv.media.player.MgtvMediaSource
    public SmoothMediaSource setReadType(int i) {
        super.setReadType(i);
        return this;
    }

    public SmoothMediaSource setReportParams(ReportParams reportParams) {
        this.reportParams = reportParams;
        a aVar = this.reporter;
        if (aVar != null) {
            aVar.n(reportParams);
        }
        return this;
    }

    public SmoothMediaSource setRetry(int i) {
        this.retry = i;
        return this;
    }

    public SmoothMediaSource setSwitchMod(int i) {
        this.switchMod = i;
        return this;
    }

    public SmoothMediaSource setThrowErrorIfSwitchFailed(boolean z) {
        this.throwErrorIfSwitchFailed = z;
        return this;
    }

    public SmoothMediaSource setTsFlowTag(String str) {
        this.tsFlowTag = str;
        ReportParams reportParams = this.reportParams;
        if (reportParams != null) {
            reportParams.setFlowt(str);
        }
        return this;
    }

    public SmoothMediaSource setUpdateUrl(String str) {
        this.updateUrl = str;
        return this;
    }

    public SmoothMediaSource setVfps(String str) {
        this.vfps = str;
        return this;
    }

    @Override // com.hunantv.media.player.MgtvMediaSource
    public SmoothMediaSource setVid(String str) {
        super.setVid(str);
        return this;
    }

    public SmoothMediaSource setVideoFileHash(String str) {
        this.videoFileHash = str;
        ReportParams reportParams = this.reportParams;
        if (reportParams != null) {
            reportParams.setVideoFileHash(str);
        }
        return this;
    }

    @Override // com.hunantv.media.player.MgtvMediaSource
    public SmoothMediaSource setVideoFormat(String str) {
        super.setVideoFormat(str);
        return this;
    }

    @Override // com.hunantv.media.player.MgtvMediaSource
    public SmoothMediaSource setVsri(String str) {
        super.setVsri(str);
        return this;
    }

    @Override // com.hunantv.media.player.MgtvMediaSource
    public String toString() {
        return "SmoothMediaSource{level=" + this.level + ", data=" + this.data + ", updateUrl='" + this.updateUrl + "', bindPlayer=" + this.bindPlayer + ", reporter=" + this.reporter + ", reportParams=" + this.reportParams + ", retry=" + this.retry + ", lastRetry=" + this.lastRetry + ", isp2p=" + this.isp2p + ", readType=" + this.readType + ", url='" + this.url + "', proxyUrl='" + this.proxyUrl + "', playingUrl='" + this.playingUrl + "', videoFormat='" + this.videoFormat + "', fileFormat='" + this.fileFormat + "', vid='" + this.vid + "', def='" + this.def + "', throwErrorIfSwitchFailed='" + this.throwErrorIfSwitchFailed + "', switchMod='" + this.switchMod + "', tsFlowTag='" + this.tsFlowTag + "'}";
    }

    public String useUpdateUrl() {
        String str = this.updateUrl;
        this.playingUrl = str;
        return str;
    }
}
