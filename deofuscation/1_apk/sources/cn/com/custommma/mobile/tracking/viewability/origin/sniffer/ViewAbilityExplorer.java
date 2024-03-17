package cn.com.custommma.mobile.tracking.viewability.origin.sniffer;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import cn.com.custommma.mobile.tracking.api.Countly;
import cn.com.custommma.mobile.tracking.util.klog.KLog;
import cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityStats;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ViewAbilityExplorer implements Serializable {
    private static final long serialVersionUID = 1;
    private String adURL;
    private transient View adView;
    private ViewAbilityConfig config;
    private String explorerID;
    private int exposeValidDuration;
    private String impressionID;
    private List<AbilityVideoProgress> videoProgressList;
    private ViewAbilityStats viewAbilityStats;
    public ViewFrameBlock viewFrameBlock;
    private boolean viewabilityState = false;
    private boolean isVideoProcessMonitor = false;
    private boolean isNeedRecord = true;
    private String videoProcessIdentifier = null;
    private boolean isVideoProcessTracking = false;
    private boolean isViewabilityTrackFinished = false;
    private transient AbilityCallback abilityCallback = null;
    private boolean isStrongInteract = false;
    private AbilityStatus abilityStatus = AbilityStatus.EXPLORERING;

    public ViewAbilityExplorer(String str, String str2, View view, String str3, ViewAbilityConfig viewAbilityConfig, ViewAbilityStats viewAbilityStats) {
        float coverRateScale;
        this.viewFrameBlock = null;
        this.explorerID = str;
        this.adURL = str2;
        this.adView = view;
        this.impressionID = str3;
        this.config = viewAbilityConfig;
        this.viewAbilityStats = viewAbilityStats;
        if (viewAbilityStats.getURLShowCoverRate() > 0.0f) {
            coverRateScale = 1.0f - this.viewAbilityStats.getURLShowCoverRate();
        } else {
            coverRateScale = viewAbilityConfig.getCoverRateScale();
        }
        this.viewFrameBlock = new ViewFrameBlock(viewAbilityStats.getViewabilityTrackPolicy(), viewAbilityConfig.getMaxUploadAmount(), coverRateScale);
        initConfigParams();
    }

    private void initConfigParams() {
        try {
            if (this.viewAbilityStats.getURLExposeDuration() > 0) {
                this.exposeValidDuration = this.viewAbilityStats.getURLExposeDuration();
            } else {
                this.exposeValidDuration = this.viewAbilityStats.isVideoExpose() ? this.config.getVideoExposeValidDuration() : this.config.getExposeValidDuration();
            }
            String str = this.viewAbilityStats.get(ViewAbilityStats.ADVIEWABILITY_VIDEO_PROGRESS);
            if (this.viewAbilityStats.isVideoExpose() && this.viewAbilityStats.getURLVideoDuration() > 0 && this.viewAbilityStats.isVideoProgressTrack() && !TextUtils.isEmpty(str)) {
                this.isVideoProcessMonitor = true;
                this.videoProgressList = this.viewAbilityStats.getURLVideoProcessTrackList();
                this.videoProcessIdentifier = str;
            } else {
                this.isVideoProcessMonitor = false;
            }
            String str2 = this.viewAbilityStats.get(ViewAbilityStats.ADVIEWABILITY_RECORD);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if (this.adURL.contains(this.viewAbilityStats.getSeparator() + str2 + this.viewAbilityStats.getEqualizer() + "0")) {
                this.isNeedRecord = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x003e A[Catch: all -> 0x0099, TryCatch #0 {, blocks: (B:46:0x0004, B:48:0x001d, B:58:0x0034, B:60:0x003e, B:62:0x0042, B:63:0x0073, B:64:0x0078, B:66:0x0080, B:73:0x0097, B:68:0x0084, B:70:0x008a, B:72:0x008e, B:49:0x001f, B:51:0x0023, B:52:0x0026, B:54:0x002a, B:55:0x002d, B:57:0x0031), top: B:80:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void trackVideoProgress() {
        /*
            r8 = this;
            java.lang.Class<cn.com.custommma.mobile.tracking.viewability.origin.sniffer.ViewAbilityExplorer> r0 = cn.com.custommma.mobile.tracking.viewability.origin.sniffer.ViewAbilityExplorer.class
            monitor-enter(r0)
            r1 = 1
            r8.isVideoProcessTracking = r1     // Catch: java.lang.Throwable -> L99
            java.util.List<cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityVideoProgress> r1 = r8.videoProgressList     // Catch: java.lang.Throwable -> L99
            r2 = 0
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L99
            cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityVideoProgress r1 = (cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityVideoProgress) r1     // Catch: java.lang.Throwable -> L99
            r3 = 0
            cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityStats r5 = r8.viewAbilityStats     // Catch: java.lang.Throwable -> L99
            int r5 = r5.getURLVideoDuration()     // Catch: java.lang.Throwable -> L99
            int r5 = r5 / 4
            cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityVideoProgress r6 = cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityVideoProgress.TRACK1_4     // Catch: java.lang.Throwable -> L99
            if (r1 != r6) goto L1f
        L1d:
            long r3 = (long) r5     // Catch: java.lang.Throwable -> L99
            goto L34
        L1f:
            cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityVideoProgress r6 = cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityVideoProgress.TRACK2_4     // Catch: java.lang.Throwable -> L99
            if (r1 != r6) goto L26
            int r5 = r5 * 2
            goto L1d
        L26:
            cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityVideoProgress r6 = cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityVideoProgress.TRACK3_4     // Catch: java.lang.Throwable -> L99
            if (r1 != r6) goto L2d
            int r5 = r5 * 3
            goto L1d
        L2d:
            cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityVideoProgress r6 = cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityVideoProgress.TRACK4_4     // Catch: java.lang.Throwable -> L99
            if (r1 != r6) goto L34
            int r5 = r5 * 4
            goto L1d
        L34:
            cn.com.custommma.mobile.tracking.viewability.origin.sniffer.ViewFrameBlock r5 = r8.viewFrameBlock     // Catch: java.lang.Throwable -> L99
            long r5 = r5.getMaxDuration()     // Catch: java.lang.Throwable -> L99
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 < 0) goto L78
            cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityCallback r3 = r8.abilityCallback     // Catch: java.lang.Throwable -> L99
            if (r3 == 0) goto L73
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            r3.<init>()     // Catch: java.lang.Throwable -> L99
            java.lang.String r4 = r8.adURL     // Catch: java.lang.Throwable -> L99
            r3.append(r4)     // Catch: java.lang.Throwable -> L99
            cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityStats r4 = r8.viewAbilityStats     // Catch: java.lang.Throwable -> L99
            java.lang.String r4 = r4.getSeparator()     // Catch: java.lang.Throwable -> L99
            r3.append(r4)     // Catch: java.lang.Throwable -> L99
            java.lang.String r4 = r8.videoProcessIdentifier     // Catch: java.lang.Throwable -> L99
            r3.append(r4)     // Catch: java.lang.Throwable -> L99
            cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityStats r4 = r8.viewAbilityStats     // Catch: java.lang.Throwable -> L99
            java.lang.String r4 = r4.getEqualizer()     // Catch: java.lang.Throwable -> L99
            r3.append(r4)     // Catch: java.lang.Throwable -> L99
            java.lang.String r4 = r1.value()     // Catch: java.lang.Throwable -> L99
            r3.append(r4)     // Catch: java.lang.Throwable -> L99
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L99
            cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityCallback r4 = r8.abilityCallback     // Catch: java.lang.Throwable -> L99
            r4.onSend(r3)     // Catch: java.lang.Throwable -> L99
        L73:
            java.util.List<cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityVideoProgress> r3 = r8.videoProgressList     // Catch: java.lang.Throwable -> L99
            r3.remove(r1)     // Catch: java.lang.Throwable -> L99
        L78:
            java.util.List<cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityVideoProgress> r1 = r8.videoProgressList     // Catch: java.lang.Throwable -> L99
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L99
            if (r1 == 0) goto L84
            android.view.View r1 = r8.adView     // Catch: java.lang.Throwable -> L99
            if (r1 != 0) goto L97
        L84:
            r8.isVideoProcessTracking = r2     // Catch: java.lang.Throwable -> L99
            boolean r1 = r8.isViewabilityTrackFinished     // Catch: java.lang.Throwable -> L99
            if (r1 == 0) goto L97
            cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityCallback r1 = r8.abilityCallback     // Catch: java.lang.Throwable -> L99
            if (r1 == 0) goto L97
            cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityStatus r2 = cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityStatus.UPLOADED     // Catch: java.lang.Throwable -> L99
            r8.abilityStatus = r2     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = r8.explorerID     // Catch: java.lang.Throwable -> L99
            r1.onFinished(r2)     // Catch: java.lang.Throwable -> L99
        L97:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L99
            return
        L99:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L99
            goto L9d
        L9c:
            throw r1
        L9d:
            goto L9c
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.custommma.mobile.tracking.viewability.origin.sniffer.ViewAbilityExplorer.trackVideoProgress():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void verifyBreakCondition() throws java.lang.Exception {
        /*
            r8 = this;
            boolean r0 = r8.isViewabilityTrackFinished
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 0
            cn.com.custommma.mobile.tracking.viewability.origin.sniffer.ViewFrameBlock r1 = r8.viewFrameBlock
            long r1 = r1.getMaxDuration()
            cn.com.custommma.mobile.tracking.viewability.origin.sniffer.ViewAbilityConfig r3 = r8.config
            int r3 = r3.getMaxDuration()
            long r3 = (long) r3
            java.lang.String r5 = "ID:"
            r6 = 1
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 < 0) goto L5b
            cn.com.custommma.mobile.tracking.viewability.origin.sniffer.ViewFrameBlock r1 = r8.viewFrameBlock
            long r1 = r1.getExposeDuration()
            double r1 = (double) r1
            r3 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 >= 0) goto L5b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r1 = r8.impressionID
            r0.append(r1)
            java.lang.String r1 = " 已经达到最大监测时长,且当前无曝光,终止定时任务,等待数据上报,max duration:"
            r0.append(r1)
            cn.com.custommma.mobile.tracking.viewability.origin.sniffer.ViewFrameBlock r1 = r8.viewFrameBlock
            long r1 = r1.getMaxDuration()
            r0.append(r1)
            java.lang.String r1 = "  config duration:"
            r0.append(r1)
            cn.com.custommma.mobile.tracking.viewability.origin.sniffer.ViewAbilityConfig r1 = r8.config
            int r1 = r1.getInspectInterval()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            cn.com.custommma.mobile.tracking.util.klog.KLog.w(r0)
            goto L83
        L5b:
            cn.com.custommma.mobile.tracking.viewability.origin.sniffer.ViewFrameBlock r1 = r8.viewFrameBlock
            long r1 = r1.getExposeDuration()
            int r3 = r8.exposeValidDuration
            long r3 = (long) r3
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 < 0) goto L85
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r1 = r8.impressionID
            r0.append(r1)
            java.lang.String r1 = " 已满足可视曝光时长,终止定时任务,等待数据上报"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            cn.com.custommma.mobile.tracking.util.klog.KLog.w(r0)
            r8.viewabilityState = r6
        L83:
            r0 = 1
            goto La3
        L85:
            android.view.View r1 = r8.adView
            if (r1 != 0) goto La3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r1 = r8.impressionID
            r0.append(r1)
            java.lang.String r1 = " AdView 已被释放,终止定时任务,等待数据上报"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            cn.com.custommma.mobile.tracking.util.klog.KLog.w(r0)
            goto L83
        La3:
            if (r0 == 0) goto La8
            r8.breakToUpload()
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.custommma.mobile.tracking.viewability.origin.sniffer.ViewAbilityExplorer.verifyBreakCondition():void");
    }

    public void breakToUpload() throws Exception {
        List<HashMap<String, Object>> generateUploadEvents = this.viewFrameBlock.generateUploadEvents(this.viewAbilityStats);
        if (Countly.LOCAL_TEST) {
            HashMap hashMap = new HashMap();
            hashMap.put(ViewAbilityStats.IMPRESSIONID, this.impressionID);
            hashMap.put(ViewAbilityStats.ADVIEWABILITYEVENTS, generateUploadEvents);
            hashMap.put(ViewAbilityStats.ADVIEWABILITY, Integer.valueOf(this.viewabilityState ? 1 : 0));
            hashMap.put(ViewAbilityStats.ADVIEWABILITY_RESULT, Integer.valueOf(this.viewabilityState ? 1 : 4));
            hashMap.put(ViewAbilityStats.ADMEASURABILITY, 1);
            JSONObject jSONObject = new JSONObject(hashMap);
            KLog.e("<-------------------------------------------------------------------------------->");
            KLog.d("ID:" + this.impressionID + " 原始数据帧长度:" + this.viewFrameBlock.blockLength() + " 准备生成MMA监测链接");
            KLog.json(jSONObject.toString());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.adURL);
        try {
            String replace = new JSONArray((Collection) generateUploadEvents).toString().replace("\"", "");
            String separator = this.viewAbilityStats.getSeparator();
            String equalizer = this.viewAbilityStats.getEqualizer();
            String str = this.viewAbilityStats.get(ViewAbilityStats.ADVIEWABILITYEVENTS);
            if (!TextUtils.isEmpty(str) && this.isNeedRecord) {
                sb.append(separator);
                sb.append(str);
                sb.append(equalizer);
                sb.append(URLEncoder.encode(replace, "utf-8"));
            }
            String str2 = this.viewAbilityStats.get(ViewAbilityStats.ADVIEWABILITY);
            if (!TextUtils.isEmpty(str2)) {
                sb.append(separator);
                sb.append(str2);
                sb.append(equalizer);
                sb.append(String.valueOf(this.viewabilityState ? 1 : 0));
            }
            String str3 = this.viewAbilityStats.get(ViewAbilityStats.ADVIEWABILITY_RESULT);
            if (!TextUtils.isEmpty(str3)) {
                sb.append(separator);
                sb.append(str3);
                sb.append(equalizer);
                sb.append(String.valueOf(this.viewabilityState ? 1 : 4));
            }
            String str4 = this.viewAbilityStats.get(ViewAbilityStats.ADMEASURABILITY);
            if (!TextUtils.isEmpty(str4)) {
                sb.append(separator);
                sb.append(str4);
                sb.append(equalizer);
                sb.append("1");
            }
            String str5 = this.viewAbilityStats.get(ViewAbilityStats.ADVIEWABILITY_VIDEO_PLAYTYPE);
            if (!TextUtils.isEmpty(str5) && this.viewAbilityStats.isVideoExpose()) {
                sb.append(separator);
                sb.append(str5);
                sb.append(equalizer);
                sb.append(String.valueOf(this.viewAbilityStats.getVideoPlayType()));
            }
            if (this.isStrongInteract) {
                String str6 = this.viewAbilityStats.get(ViewAbilityStats.ADVIEWABILITY_STRONG_INTERACT);
                if (!TextUtils.isEmpty(str6)) {
                    sb.append(separator);
                    sb.append(str6);
                    sb.append(equalizer);
                    sb.append("1");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sb2 = sb.toString();
        KLog.d("最终监测链接:" + sb2);
        this.isViewabilityTrackFinished = true;
        AbilityCallback abilityCallback = this.abilityCallback;
        if (abilityCallback != null) {
            abilityCallback.onSend(sb2);
        }
        if (!this.isVideoProcessMonitor || !this.isVideoProcessTracking) {
            this.abilityCallback.onFinished(this.explorerID);
            this.abilityStatus = AbilityStatus.UPLOADED;
        }
        KLog.e("<-------------------------------------------------------------------------------->");
    }

    public AbilityStatus getAbilityStatus() {
        return this.abilityStatus;
    }

    public void onExplore(Context context) {
        try {
            synchronized (ViewAbilityExplorer.class) {
                View view = this.adView;
                if (view != null) {
                    ViewFrameSlice viewFrameSlice = new ViewFrameSlice(view, context);
                    viewFrameSlice.getCoverRate();
                    this.viewFrameBlock.onPush(viewFrameSlice);
                }
                if (this.isVideoProcessMonitor && this.videoProgressList.size() > 0) {
                    trackVideoProgress();
                }
                verifyBreakCondition();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAbilityCallback(AbilityCallback abilityCallback) {
        this.abilityCallback = abilityCallback;
    }

    public void setStrongInteract(boolean z) {
        this.isStrongInteract = z;
        this.viewabilityState = true;
    }

    public void stop() {
        this.isVideoProcessTracking = false;
        try {
            breakToUpload();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return "[ impressionID=" + this.impressionID + ",explorerID=" + this.explorerID + ",adURL=" + this.adURL + ",view=" + this.adView + " block=" + this.viewFrameBlock.toString() + " ]";
    }

    public void breakToUpload(AbilityCallback abilityCallback) throws Exception {
        if (this.abilityCallback == null) {
            this.abilityCallback = abilityCallback;
        }
        breakToUpload();
    }
}
