package com.hunantv.media.player.flow;

import com.google.gson.Gson;
import com.hunantv.imgo.entity.JumpAction;
import com.hunantv.media.config.NetPlayConfig;
import com.hunantv.media.player.flow.entity.FlowReportEntity;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.player.statistic.FlowDataStatistic;
import com.hunantv.media.player.utils.ExTicker;
import com.hunantv.media.player.utils.StringUtil;
import com.hunantv.media.player.utils.UrlUtil;
import com.hunantv.media.report.ReportParams;
import com.mgtv.easydatasource.FlowReporter;
import java.text.DecimalFormat;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class FlowReportProcessor {
    private static final int STATUS_IDLE = 0;
    private static final int STATUS_START = 1;
    private static final int STATUS_STOP = 2;
    private static final String TAG = "FlowReportProcessor";
    public int def;
    public int duration;
    public String encodeInfo;
    public int file_size;
    public String flag;
    public int h;
    public boolean isP2p;
    public FlowReporter reporter;
    public String suuid;
    public String url;
    public String vid;
    public int w;
    public int stream_type = 1;
    public volatile int status = 0;
    public ExTicker pushInfo2Ticker = null;
    public FlowDataStatistic flowStatistic = new FlowDataStatistic();
    public Object locker = new Object();

    public FlowReportProcessor(String str, String str2, int i, String str3, boolean z, String str4) {
        this.url = str;
        this.vid = str2;
        this.def = i;
        this.suuid = str3;
        this.isP2p = z;
        this.flag = str4;
        this.reporter = new FlowReporter(str2, i, str3);
        String logTag = getLogTag();
        DebugLog.i(logTag, "FlowReporter version: " + FlowReporter.getVersion());
        String logTag2 = getLogTag();
        DebugLog.i(logTag2, "vid:" + str2 + ",def:" + i + ",suuid:" + str3 + ", isP2p:" + z);
    }

    private String getLogTag() {
        return "FlowReportProcessor-" + hashCode() + "-" + this.flag + "-" + (this.isP2p ? 1 : 0);
    }

    public static boolean isEnable() {
        return FlowReporter.isInited() && NetPlayConfig.getFlowReportMode() != 0;
    }

    public static boolean isInvalidVideoType(ReportParams reportParams) {
        return (reportParams == null || reportParams.getVideoType() == null || (reportParams.getVideoType() != ReportParams.VideoType.AD_BOOT && reportParams.getVideoType() != ReportParams.VideoType.AD_PRE && reportParams.getVideoType() != ReportParams.VideoType.AD_MID && reportParams.getVideoType() != ReportParams.VideoType.LIVE && reportParams.getVideoType() != ReportParams.VideoType.LOCAL && reportParams.getVideoType() != ReportParams.VideoType.STAR_ROOM_LIVE && reportParams.getVideoType() != ReportParams.VideoType.GIF_PREVIEW_VIDEO && reportParams.getVideoType() != ReportParams.VideoType.GIF_PREVIEW_IMAGE && reportParams.getVideoType() != ReportParams.VideoType.GIF_CREATOR && reportParams.getVideoType() != ReportParams.VideoType.SOCIAL_AUDIO_CHAT)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushCurrentPlayerFlowInfo2() {
        if (isHls()) {
            return;
        }
        FlowReportEntity flowReportEntity = new FlowReportEntity();
        flowReportEntity.url = this.url;
        flowReportEntity.file_size = this.file_size;
        flowReportEntity.down_size = this.flowStatistic.getDynamicIntervalBytes();
        flowReportEntity.error_type = 0;
        flowReportEntity.error_code = 0;
        flowReportEntity.file_dur = new DecimalFormat("0.000000").format(this.duration / 1000.0f) + "";
        flowReportEntity.file_seq = "0";
        pushPlayerFlowInfo2(flowReportEntity);
    }

    public static String replaceUrlSftc(String str, ReportParams reportParams) {
        String str2;
        StringBuilder sb;
        StringBuilder sb2;
        try {
            DebugLog.i(TAG, "replaceUrlSftc in. url=" + str);
            if (StringUtil.isEmpty(str)) {
                sb2 = new StringBuilder();
            } else {
                String str3 = ReportParams.GlobalSet.getsAppVersionName();
                if (StringUtil.isEmpty(str3)) {
                    str2 = "vn";
                } else {
                    str2 = "v" + str3;
                }
                String str4 = "";
                String str5 = str.contains("drmFlag=1") ? "_drm1" : "";
                String str6 = str.contains("sftc=free") ? "_free" : "";
                String str7 = "_vtp";
                if (reportParams != null) {
                    str7 = "_vtp" + ReportParams.getVideoTypeStr(reportParams.getVideoType());
                }
                String str8 = str2 + "ds1" + str5 + str6 + str7;
                if (str.contains("sftc=")) {
                    String urlParamsValue = UrlUtil.getUrlParamsValue(str, "sftc");
                    if (!StringUtil.isEmpty(urlParamsValue)) {
                        str4 = urlParamsValue;
                    }
                    str = str.replace("sftc=" + str4, "sftc=" + str8);
                    sb2 = new StringBuilder();
                } else {
                    if (str.indexOf(JumpAction.STR_ACTION_SPLIT) >= 0) {
                        sb = new StringBuilder();
                        sb.append(str);
                        sb.append("&sftc=");
                    } else {
                        sb = new StringBuilder();
                        sb.append(str);
                        sb.append("?sftc=");
                    }
                    sb.append(str8);
                    str = sb.toString();
                    sb2 = new StringBuilder();
                }
            }
            sb2.append("replaceUrlSftc out. url=");
            sb2.append(str);
            DebugLog.i(TAG, sb2.toString());
            return str;
        } catch (Throwable th) {
            DebugLog.i(TAG, "replaceUrlSftc out. url=" + str);
            throw th;
        }
    }

    public static String replaceUrlSftcNoP2p(String str, ReportParams reportParams) {
        return !UrlUtil.isLocal(str) ? (reportParams == null || !reportParams.isP2p()) ? replaceUrlSftc(str, reportParams) : str : str;
    }

    public void forceTrigger() {
        synchronized (this.locker) {
            DebugLog.i(getLogTag(), "forceTrigger");
            this.reporter.forceTrigger();
        }
    }

    public FlowDataStatistic getFlowStatistic() {
        return this.flowStatistic;
    }

    public boolean isHls() {
        boolean z;
        synchronized (this.locker) {
            z = true;
            if (this.stream_type != 1) {
                z = false;
            }
        }
        return z;
    }

    public boolean isP2p() {
        return this.isP2p;
    }

    public void pushP2pFlowInfo(String str) {
        synchronized (this.locker) {
            if (this.isP2p) {
                if (!StringUtil.isEmpty(str)) {
                    String logTag = getLogTag();
                    DebugLog.d(logTag, "pushP2pFlowInfo json " + str);
                    this.reporter.pushFlowInfo(str, 2, 1);
                }
            }
        }
    }

    public void pushPlayerFlowInfo(FlowReportEntity flowReportEntity) {
        synchronized (this.locker) {
            if (this.isP2p) {
                return;
            }
            if (isHls()) {
                if (flowReportEntity != null) {
                    String json = new Gson().toJson(flowReportEntity);
                    String logTag = getLogTag();
                    DebugLog.d(logTag, "pushPlayerFlowInfo json " + json);
                    this.reporter.pushFlowInfo(json, 1, 1);
                }
            }
        }
    }

    public void pushPlayerFlowInfo2(FlowReportEntity flowReportEntity) {
        synchronized (this.locker) {
            if (this.isP2p) {
                return;
            }
            if (isHls()) {
                return;
            }
            if (flowReportEntity != null) {
                String json = new Gson().toJson(flowReportEntity);
                String logTag = getLogTag();
                DebugLog.d(logTag, "pushPlayerFlowInfo2 json " + json);
                this.reporter.pushFlowInfo(json, 1, 1);
            }
        }
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void start(int i, int i2, int i3, String str, int i4) {
        start(i, i2, i3, str, i4, null, null);
    }

    public void start(int i, int i2, int i3, String str, int i4, String str2, String str3) {
        synchronized (this.locker) {
            this.stream_type = i;
            this.w = i2;
            this.h = i3;
            this.encodeInfo = str;
            this.file_size = i4;
            if (this.status != 0) {
                String logTag = getLogTag();
                DebugLog.i(logTag, "start return cause current status :" + this.status);
                return;
            }
            String logTag2 = getLogTag();
            DebugLog.i(logTag2, "start stream_type:" + i + ",w:" + i2 + ",h:" + i3 + ",encodeInfo:" + str + ",url:" + this.url);
            this.reporter.setPlayerSuuid(str2);
            this.reporter.setBusinessSuuid(str3);
            this.reporter.setVideoMetadata(i2, i3, str);
            this.reporter.start(this.url);
            if (!isHls()) {
                ExTicker exTicker = this.pushInfo2Ticker;
                if (exTicker != null) {
                    exTicker.stop();
                    this.pushInfo2Ticker = null;
                }
                ExTicker exTicker2 = new ExTicker(10000);
                this.pushInfo2Ticker = exTicker2;
                exTicker2.setCallback(new ExTicker.onTickListener() { // from class: com.hunantv.media.player.flow.FlowReportProcessor.1
                    @Override // com.hunantv.media.player.utils.ExTicker.onTickListener
                    public void onTick(int i5) {
                        if (i5 == 1) {
                            return;
                        }
                        FlowReportProcessor.this.pushCurrentPlayerFlowInfo2();
                    }
                });
                this.pushInfo2Ticker.start();
            }
            this.status = 1;
        }
    }

    public void stop() {
        synchronized (this.locker) {
            if (this.status == 2) {
                DebugLog.i(getLogTag(), "stop return cause already stopped");
                return;
            }
            pushCurrentPlayerFlowInfo2();
            String logTag = getLogTag();
            DebugLog.i(logTag, "stop url:" + this.url);
            this.reporter.start(this.url);
            this.reporter.stop();
            ExTicker exTicker = this.pushInfo2Ticker;
            if (exTicker != null) {
                exTicker.stop();
                this.pushInfo2Ticker = null;
            }
            this.status = 2;
        }
    }
}
