package com.hunantv.media.player;

import android.os.Bundle;
import com.hunantv.media.player.smooth.SmoothMediaSource;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgtvPlayerListener {

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class FrameClock {
        public static final int CLOCK_TYPE_DEBUG = 0;
        public static final int CLOCK_TYPE_NORMAL_MS = 1;
        public static final int CLOCK_TYPE_PKT_PTS_ABORT_END = 5;
        public static final int CLOCK_TYPE_PKT_PTS_NORMAL = 2;
        public static final int CLOCK_TYPE_PKT_PTS_NORMAL_END = 4;
        public static final int CLOCK_TYPE_PKT_PTS_SEEK = 3;
        public static final int CLOCK_TYPE_PKT_PTS_VV_START = 6;
        public long cTimeMs;
        public int clock_type;
        public long endPts;
        public long pkt_pts;
        public long ptsMs;
        public long seekSerial;
        public long startPts;
        public long tTimeMs;
        public long vframe_time;

        public boolean checkValid(int i) {
            return (i == 2 || i == 4 || i == 5) ? this.startPts >= 0 && this.endPts >= 0 && this.pkt_pts >= 0 : i == 3 ? this.seekSerial >= 0 && this.pkt_pts >= 0 : i == 6 ? this.pkt_pts >= 0 : i >= 0 && this.tTimeMs >= 0 && this.ptsMs >= 0 && this.cTimeMs >= 0 && this.pkt_pts >= 0;
        }

        public String toString() {
            StringBuilder sb;
            long j;
            int i = this.clock_type;
            if (i == 2 || i == 4 || i == 5) {
                sb = new StringBuilder();
                sb.append("FrameClock{clock_type=");
                sb.append(this.clock_type);
                sb.append(", pkt_pts=");
                sb.append(this.pkt_pts);
                sb.append(", startPts=");
                sb.append(this.startPts);
                sb.append(", endPts=");
                j = this.endPts;
            } else if (i == 3) {
                sb = new StringBuilder();
                sb.append("FrameClock{clock_type=");
                sb.append(this.clock_type);
                sb.append(", pkt_pts=");
                sb.append(this.pkt_pts);
                sb.append(", vframe_time=");
                sb.append(this.vframe_time);
                sb.append(", seekSerial=");
                j = this.seekSerial;
            } else {
                if (i == 0) {
                    sb = new StringBuilder();
                } else if (i == 6) {
                    sb = new StringBuilder();
                } else {
                    sb = new StringBuilder();
                    sb.append("FrameClock{clock_type=");
                    sb.append(this.clock_type);
                    sb.append(", tTimeMs=");
                    sb.append(this.tTimeMs);
                    sb.append(", ptsMs=");
                    sb.append(this.ptsMs);
                    sb.append(", cTimeMs=");
                    j = this.cTimeMs;
                }
                sb.append("FrameClock{clock_type=");
                sb.append(this.clock_type);
                sb.append(", pkt_pts=");
                sb.append(this.pkt_pts);
                sb.append(", vframe_time=");
                j = this.vframe_time;
            }
            sb.append(j);
            sb.append('}');
            return sb.toString();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnAVPlayListener {
        void onAVPauseOrPlay(boolean z);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnAudioEffectListener {
        void onAudioEffectChanged(int i);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnBufferingTimeoutListener {
        boolean onBufferingTimeout(int i, int i2);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(int i);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnCompletionListener {
        public static final int COMPLETED_ERR_EOF = 30020;
        public static final int COMPLETED_ERR_SKIPTS = 30010;
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
    public interface OnFrameListener {
        void onVFrameClockCome(FrameClock frameClock);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnGetFrameImageListener {
        public static final int GET_FRAME_IMAGE_ERROR = 2;
        public static final int GET_FRAME_IMAGE_FAIL = 3;
        public static final int GET_FRAME_IMAGE_START = 0;
        public static final int GET_FRAME_IMAGE_SUCCESS = 1;

        void onGetFrameImageInfo(int i, int i2, String str);

        void onGetFrameImageStatus(int i, int i2);
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
    public interface OnLoopSwitchSourceListener {
        public static final int LOOPSWITCH_EXEC_FAIL_FERR = 23;
        public static final int LOOPSWITCH_EXEC_FAIL_MERR = 22;
        public static final int LOOPSWITCH_EXEC_FAIL_PTR = 21;
        public static final int LOOPSWITCH_EXEC_QUICK_FAIL = 30;
        public static final int LOOPSWITCH_INFO_ADATA_DECODER = 4;
        public static final int LOOPSWITCH_INFO_ADATA_PREPARED = 2;
        public static final int LOOPSWITCH_INFO_AUDIO_FPRAPARE = 6;
        public static final int LOOPSWITCH_INFO_AUDIO_RENDER = 8;
        public static final int LOOPSWITCH_INFO_EXEC_SUCCESS = 20;
        public static final int LOOPSWITCH_INFO_START = 0;
        public static final int LOOPSWITCH_INFO_STARTED = 10;
        public static final int LOOPSWITCH_INFO_SWITCHING = 1;
        public static final int LOOPSWITCH_INFO_VDATA_DECODER = 5;
        public static final int LOOPSWITCH_INFO_VDATA_PREPARED = 3;
        public static final int LOOPSWITCH_INFO_VIDEO_FPRAPARE = 7;
        public static final int LOOPSWITCH_INFO_VIDEO_RENDER = 9;

        void onLoopSwitchSourceComplete(String str, int i, int i2);

        void onLoopSwitchSourceFail(String str, int i, int i2);

        void onLoopSwitchSourceInfo(String str, int i, int i2);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnPauseListener {
        void onPause();
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnPlayerEventListener {
        void onInfo(int i, int i2);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnPreparedListener {
        void onPrepared();
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnRecordVideoListener {
        public static final int REC_VIDEO_ERROR_APEND_FRAME_ERR = 20;
        public static final int REC_VIDEO_ERROR_BASE_ERR = 10000;
        public static final int REC_VIDEO_ERROR_DEINIT_ERR = 30;
        public static final int REC_VIDEO_ERROR_ILLEGAL_ARGUMENT_ERR = 10002;
        public static final int REC_VIDEO_ERROR_ILLEGAL_STATUS_ERR = 10003;
        public static final int REC_VIDEO_ERROR_INIT_ERR = 10;
        public static final int REC_VIDEO_ERROR_IO_ERR = 10001;
        public static final int REC_VIDEO_INFO_ASTART = 21;
        public static final int REC_VIDEO_INFO_END = 30;
        public static final int REC_VIDEO_INFO_PREPARED = 10;
        public static final int REC_VIDEO_INFO_VSTART = 20;

        void onRecordVideoErr(int i, int i2);

        void onRecordVideoInfo(int i, int i2);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnSeekCompleteListener {
        void onSeekComplete(int i, int i2);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnSourceFlowHandledListener {
        public static final String ARG_FLOW_CUR_DL_SIZE_LONG = "flow_cur_dl_size";
        public static final String ARG_FLOW_ERROR_CODE_INT = "flow_error_code";
        public static final String ARG_FLOW_ERROR_TYPE_INT = "flow_error_type";
        public static final String ARG_FLOW_FILE_SIZE_LONG = "flow_file_size";
        public static final String ARG_FLOW_SEG_DUR_LONG = "flow_seg_dur";
        public static final String ARG_FLOW_SEG_INDEX_LONG = "flow_seg_index";
        public static final String ARG_FLOW_SEG_NUMS_LONG = "flow_seg_nums";
        public static final String ARG_FLOW_SEG_STARTTIME_LONG = "flow_seg_starttime";
        public static final String ARG_FLOW_STREAM_TYPE_INT = "flow_stream_type";
        public static final String ARG_FLOW_SWITCH_KEY_LONG = "flow_switch_key";
        public static final String ARG_FLOW_SWITCH_URL_STRING = "flow_switch_url";
        public static final int EVENT_FLOW_INFO_REPORT = 78593;

        void onSourceFlowInfoEvent(int i, Bundle bundle);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnSourceNetHandledListener {
        public static final String ARG_COMPAR_PLAYER_HASH_STRING = "player_hash";
        public static final String ARG_COMPAR_RETRY_COUNTER_INT = "retry_counter";
        public static final String ARG_COMPAR_SWITCH_KEY_LONG = "switch_key";
        public static final String ARG_COMPAR_USER_MSG_STRING = "user_msg";
        public static final String ARG_CRTL_LIVE_RETRY_COUNTER_INT = "live_retry_counter";
        public static final String ARG_CRTL_LIVE_RETRY_ERROR_EXTRA_INT = "live_error_code";
        public static final String ARG_CRTL_LIVE_RETRY_ERROR_WHAT_INT = "live_error_type";
        public static final String ARG_CRTL_LIVE_RETRY_ERR_IO_TYPE_INT = "live_io_type";
        public static final String ARG_CRTL_LIVE_RETRY_IS_LAST_INT = "live_is_last";
        public static final String ARG_CRTL_LIVE_RETRY_SEGMENT_INDEX_INT = "live_segment_index";
        public static final String ARG_CRTL_LIVE_RETRY_SRC_URL_STRING = "live_src_url";
        public static final String ARG_CRTL_LIVE_RETRY_URL_STRING = "live_url";
        public static final String ARG_CRTL_LOOP_RETRY_COUNTER_INT = "loop_retry_counter";
        public static final String ARG_CRTL_LOOP_RETRY_ERROR_EXTRA_INT = "loop_error_code";
        public static final String ARG_CRTL_LOOP_RETRY_ERROR_WHAT_INT = "loop_error_type";
        public static final String ARG_CRTL_LOOP_RETRY_ERR_IO_TYPE_INT = "loop_io_type";
        public static final String ARG_CRTL_LOOP_RETRY_IS_LAST_INT = "loop_is_last";
        public static final String ARG_CRTL_LOOP_RETRY_SEGMENT_INDEX_INT = "loop_segment_index";
        public static final String ARG_CRTL_LOOP_RETRY_SRC_URL_STRING = "loop_src_url";
        public static final String ARG_CRTL_LOOP_RETRY_URL_STRING = "loop_url";
        public static final String ARG_CRTL_RESET_IPLIST_INT = "reset_iplist";
        public static final String ARG_CRTL_RETRY_COUNTER_INT = "retry_counter";
        public static final String ARG_CRTL_RETRY_CUR_DL_SIZE = "cur_dl_dize";
        public static final String ARG_CRTL_RETRY_ERROR_EXTRA_INT = "error_code";
        public static final String ARG_CRTL_RETRY_ERROR_WHAT_INT = "error_type";
        public static final String ARG_CRTL_RETRY_ERR_IO_TYPE_INT = "io_type";
        public static final String ARG_CRTL_RETRY_IS_LAST_INT = "is_last";
        public static final String ARG_CRTL_RETRY_SEGMENT_INDEX_INT = "segment_index";
        public static final String ARG_CRTL_RETRY_SRC_URL_STRING = "src_url";
        public static final String ARG_CRTL_RETRY_URL_STRING = "url";
        public static final String ARG_CTRL_ADDR_ERROR_INT = "addr_error";
        public static final String ARG_CTRL_ADDR_HANDLE_INT = "addr_handle";
        public static final String ARG_CTRL_ADDR_HOSTNAME_STRING = "addr_hostname";
        public static final String ARG_CTRL_ADDR_IP_STRING = "addr_ip";
        public static final String ARG_CTRL_ADDR_URI_STRING = "addr_uri";
        public static final String ARG_CTRL_ARRR_DNS_TYPE_INT = "addr_dns_type";
        public static final String ARG_CTRL_GET_ENV_KEY = "env_key";
        public static final String ARG_CTRL_GET_ENV_VALUE = "env_value";
        public static final String ARG_EVENT_TIME_CONSUME_LONG = "time_consume";
        public static final String ARG_HOST_ARRR_DNS_TIME_INT = "host_dns_time";
        public static final String ARG_HOST_ARRR_DNS_TYPE_INT = "host_dns_type";
        public static final String ARG_HOST_ARRR_ERROR_INT = "host_error";
        public static final String ARG_HOST_ARRR_FAMILY_INT = "host_family";
        public static final String ARG_HOST_ARRR_HOSTNAME_STRING = "host_hostname";
        public static final String ARG_HOST_ARRR_IP_STRING = "host_ip";
        public static final String ARG_HOST_ARRR_PORT_INT = "host_port";
        public static final String ARG_HTTP_CODE_INT = "http_code";
        public static final String ARG_HTTP_ERROR_INT = "http_error";
        public static final String ARG_HTTP_FILESIZE_LONG = "http_filesize";
        public static final String ARG_HTTP_OFFSET_LONG = "http_offset";
        public static final String ARG_HTTP_URL_STRING = "http_url";
        public static final String ARG_SMOOTH_SWITCH_KEY_LONG = "smooth_switch_key";
        public static final String ARG_SMOOTH_SWITCH_MODE_INT = "smooth_switch_mode";
        public static final String ARG_SMOOTH_SWITCH_NEED_RETRY_INT = "smooth_switch_need_retry";
        public static final String ARG_SMOOTH_SWITCH_RETRY_KEY_LONG = "smooth_switch_retry_key";
        public static final String ARG_SMOOTH_SWITCH_SMOOTH_LEVEL_INT = "smooth_switch_smooth_level";
        public static final String ARG_SMOOTH_SWITCH_STREAM_AUDIO_INT = "smooth_switch_stream_audio";
        public static final String ARG_SMOOTH_SWITCH_URL_STRING = "smooth_switch_url";
        public static final String ARG_SMOOTH_SWITCH_VID_INT = "smooth_switch_vid";
        public static final String ARG_TCP_ERROR_INT = "error";
        public static final String ARG_TCP_FAMILY_INT = "family";
        public static final String ARG_TCP_FD_INT = "fd";
        public static final String ARG_TCP_HOSTNAME_STRING = "tcp_hostname";
        public static final String ARG_TCP_IP_STRING = "ip";
        public static final String ARG_TCP_PORT_INT = "port";
        public static final int CTRL_DID_TCP_CLOSE = 131076;
        public static final int CTRL_DID_TCP_OPEN = 131074;
        public static final int CTRL_WILL_ADDRESS_BYNAME = 131078;
        public static final int CTRL_WILL_CHECK_PAUSE_LOAD = 131120;
        public static final int CTRL_WILL_CONCAT_RESOLVE_SEGMENT = 131079;
        public static final int CTRL_WILL_GET_ENV = 131104;
        public static final int CTRL_WILL_HDJ_URL_SWITCH = 131090;
        public static final int CTRL_WILL_HTTP_OPEN = 131075;
        public static final int CTRL_WILL_LIVE_OPEN = 131077;
        public static final int CTRL_WILL_LIVE_RESET = 131081;
        public static final int CTRL_WILL_LOOP_OPEN = 131088;
        public static final int CTRL_WILL_LOOP_RESET = 131089;
        public static final int CTRL_WILL_SMOOTH_SWITCH = 131184;
        public static final int CTRL_WILL_TCP_OPEN = 131073;
        public static final int EVENT_DID_HOST_ADDR = 78338;
        public static final int EVENT_DID_HTTP_CLOSE = 6;
        public static final int EVENT_DID_HTTP_OPEN = 2;
        public static final int EVENT_DID_HTTP_SEEK = 4;
        public static final int EVENT_TIME_CONSUME_DNS_ANALYZE = 16;
        public static final int EVENT_TIME_CONSUME_FIND_STREAM = 19;
        public static final int EVENT_TIME_CONSUME_FIRST_BUFFER = 20;
        public static final int EVENT_TIME_CONSUME_HTTP_RESPONSE = 18;
        public static final int EVENT_TIME_CONSUME_PAUSE_NOTIFY = 22;
        public static final int EVENT_TIME_CONSUME_TCP_CONNECT = 17;
        public static final int EVENT_WILL_HOST_ADDR = 78337;
        public static final int EVENT_WILL_HTTP_CLOSE = 5;
        public static final int EVENT_WILL_HTTP_OPEN = 1;
        public static final int EVENT_WILL_HTTP_SEEK = 3;
        public static final int MEDIA_ERROR_ENETUNREACH = 300005;
        public static final int MEDIA_ERROR_HTTP_BAD_REQUEST_400 = 300400;
        public static final int MEDIA_ERROR_HTTP_OTHER_4XX = 300499;
        public static final int MEDIA_ERROR_HTTP_SERVER_INTERNAL_ERROR_500 = 300500;
        public static final int MEDIA_ERROR_HTTP_SERVER_OTHER_5XX = 300599;
        public static final int MEDIA_ERROR_TCP_HOSTNAME_RESOLVE_ERROR = 300600;
        public static final int MGTVMEDIA_WHAT_ERROR_400400 = 400400;
        public static final int MGTVMEDIA_WHAT_ERROR_4004XX = 400499;
        public static final int MGTVMEDIA_WHAT_ERROR_400500 = 400500;
        public static final int MGTVMEDIA_WHAT_ERROR_4005XX = 400599;

        boolean onSourceNetCtrl(int i, Bundle bundle);

        void onSourceNetEvent(int i, Bundle bundle);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnSpatializerInfoListener {
        void onSpatializerEnabledChanged(boolean z);

        void onSpatializerStateChanged(boolean z);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnStartListener {
        void onStart();
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnSwitchSmoothSourceListener {
        public static final int MSG_SMOOTH_SWITCH_INFO_SWITCHED_DELAY = 20;
        public static final int SMOOTH_SWITCH_INFO_ADATA_DECODER = 6;
        public static final int SMOOTH_SWITCH_INFO_ADATA_PREPARED = 4;
        public static final int SMOOTH_SWITCH_INFO_AUDIO_FPRAPARE = 8;
        public static final int SMOOTH_SWITCH_INFO_AUDIO_RENDER = 10;
        public static final int SMOOTH_SWITCH_INFO_DID_START = 2;
        public static final int SMOOTH_SWITCH_INFO_EXEC_SUCCESS = 1;
        public static final int SMOOTH_SWITCH_INFO_SWITCHING = 3;
        public static final int SMOOTH_SWITCH_INFO_VDATA_DECODER = 7;
        public static final int SMOOTH_SWITCH_INFO_VDATA_PREPARED = 5;
        public static final int SMOOTH_SWITCH_INFO_VIDEO_FPRAPARE = 9;
        public static final int SMOOTH_SWITCH_INFO_VIDEO_RENDER = 11;
        public static final int SMOOTH_SWITCH_INFO_WILL_START = 0;

        void onSwitchSmoothSourceError(SmoothMediaSource smoothMediaSource, int i, int i2);

        void onSwitchSmoothSourceFail(SmoothMediaSource smoothMediaSource, int i, int i2);

        void onSwitchSmoothSourceInfo(SmoothMediaSource smoothMediaSource, int i);

        void onSwitchSmoothSourceSuccess(SmoothMediaSource smoothMediaSource);

        boolean onSwitchSmoothSourceWillUpdate(SmoothMediaSource smoothMediaSource);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnSwitchSourceListener {
        public static final int MEDIA_SWITCH_SOURCE_INFO_START = 0;
        public static final int MEDIA_SWITCH_SOURCE_INFO_SWITCHING = 1;
        public static final int MSG_SWITCH_VQ_COMPLETE_FAIL_END = 1;
        public static final int MSG_SWITCH_VQ_COMPLETE_FAIL_ESAME = 2;
        public static final int MSG_SWITCH_VQ_COMPLETE_FAIL_ISAME = 3;
        public static final int MSG_SWITCH_VQ_COMPLETE_OK = 0;
        public static final int MSG_SWITCH_VQ_INFO_DATA_PREPARED = 2;

        void onSwitchSourceComplete(String str, int i, int i2);

        void onSwitchSourceFailed(String str, int i, int i2);

        void onSwitchSourceInfo(String str, int i, int i2);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnVideoPTSListener {
        void onVideoPTS(FrameClock frameClock);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(int i, int i2);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnWarningListener {
        void onTsSkip(String str, int i, int i2);

        void onWarning(int i, String str, String str2, Object obj);
    }
}
