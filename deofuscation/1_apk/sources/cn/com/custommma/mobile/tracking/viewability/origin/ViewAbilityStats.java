package cn.com.custommma.mobile.tracking.viewability.origin;

import android.text.TextUtils;
import cn.com.custommma.mobile.tracking.bean.Argument;
import cn.com.custommma.mobile.tracking.viewability.origin.sniffer.AbilityVideoProgress;
import cn.com.custommma.mobile.tracking.viewability.origin.sniffer.ViewFrameSlice;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ViewAbilityStats implements Serializable {
    public static final String ADMEASURABILITY = "AdMeasurability";
    public static final String ADPLACEMENT = "Adplacement";
    public static final String ADVIEWABILITY = "Adviewability";
    public static final String ADVIEWABILITYEVENTS = "AdviewabilityEvents";
    public static final String ADVIEWABILITY_ALPHA = "AdviewabilityAlpha";
    public static final String ADVIEWABILITY_CONFIG_AREA = "AdviewabilityConfigArea";
    public static final String ADVIEWABILITY_CONFIG_THRESHOLD = "AdviewabilityConfigThreshold";
    public static final String ADVIEWABILITY_COVERRATE = "AdviewabilityCoverRate";
    public static final String ADVIEWABILITY_ENABLE = "AdviewabilityEnable";
    public static final String ADVIEWABILITY_FORGROUND = "AdviewabilityForground";
    public static final String ADVIEWABILITY_FRAME = "AdviewabilityFrame";
    public static final String ADVIEWABILITY_LIGHT = "AdviewabilityLight";
    public static final String ADVIEWABILITY_POINT = "AdviewabilityPoint";
    public static final String ADVIEWABILITY_RECORD = "AdviewabilityRecord";
    public static final String ADVIEWABILITY_RENDER = "ImpressionType";
    public static final String ADVIEWABILITY_RESULT = "AdviewabilityResult";
    public static final String ADVIEWABILITY_SHOWFRAME = "AdviewabilityShowFrame";
    public static final String ADVIEWABILITY_SHOWN = "AdviewabilityShown";
    public static final String ADVIEWABILITY_STRONG_INTERACT = "AdviewabilityStrongInteract";
    public static final String ADVIEWABILITY_TIME = "AdviewabilityTime";
    public static final String ADVIEWABILITY_VIDEO_DURATION = "AdviewabilityVideoDuration";
    public static final String ADVIEWABILITY_VIDEO_PLAYTYPE = "AdviewabilityVideoPlayType";
    public static final String ADVIEWABILITY_VIDEO_PROGRESS = "AdviewabilityVideoProgress";
    public static final String ADVIEWABILITY_VIDEO_PROGRESSPOINT = "AdviewabilityVideoProgressPoint";
    public static final String IMPRESSIONID = "ImpressionID";
    private static final long serialVersionUID = 1;
    private String equalizer;
    private boolean isVideoExpose;
    private String separator;
    private int urlExposeDuration;
    private float urlShowCoverRate;
    private int urlVideoDuration;
    private int videoPlayType;
    private List<AbilityVideoProgress> videoTrackList;
    private int viewabilityTrackPolicy;
    private HashMap<String, String> viewabilityarguments;

    private String getValueFromURL(String str, String str2) throws Exception {
        String[] split;
        String str3 = str + this.equalizer;
        for (String str4 : str2.split(this.separator)) {
            if (str4.startsWith(str3)) {
                return str4.replaceFirst(str3, "");
            }
        }
        return "";
    }

    public String get(String str) {
        return this.viewabilityarguments.get(str);
    }

    public HashMap<String, Object> getAbilitySliceTrackEvents(ViewFrameSlice viewFrameSlice) {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            String str = this.viewabilityarguments.get(ADVIEWABILITY_TIME);
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(str, Long.valueOf(viewFrameSlice.getCaptureTime()));
            }
            String str2 = this.viewabilityarguments.get(ADVIEWABILITY_FRAME);
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put(str2, viewFrameSlice.getAdSize());
            }
            String str3 = this.viewabilityarguments.get(ADVIEWABILITY_POINT);
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put(str3, viewFrameSlice.getVisiblePoint());
            }
            String str4 = this.viewabilityarguments.get(ADVIEWABILITY_ALPHA);
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put(str4, Float.valueOf(viewFrameSlice.getAlpha()));
            }
            String str5 = this.viewabilityarguments.get(ADVIEWABILITY_SHOWN);
            if (!TextUtils.isEmpty(str5)) {
                hashMap.put(str5, Integer.valueOf(viewFrameSlice.getShown()));
            }
            String str6 = this.viewabilityarguments.get(ADVIEWABILITY_COVERRATE);
            if (!TextUtils.isEmpty(str6)) {
                hashMap.put(str6, Double.valueOf(viewFrameSlice.getCoverRate()));
            }
            String str7 = this.viewabilityarguments.get(ADVIEWABILITY_SHOWFRAME);
            if (!TextUtils.isEmpty(str7)) {
                hashMap.put(str7, viewFrameSlice.getVisibleSize());
            }
            String str8 = this.viewabilityarguments.get(ADVIEWABILITY_LIGHT);
            if (!TextUtils.isEmpty(str8)) {
                hashMap.put(str8, Integer.valueOf(viewFrameSlice.getScreenOn()));
            }
            String str9 = this.viewabilityarguments.get(ADVIEWABILITY_FORGROUND);
            if (!TextUtils.isEmpty(str9)) {
                hashMap.put(str9, Integer.valueOf(viewFrameSlice.getIsForGround()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public String getEqualizer() {
        return this.equalizer;
    }

    public String getFailedViewabilityParams() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = this.viewabilityarguments.get(ADVIEWABILITYEVENTS);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(this.separator);
            try {
                str = URLEncoder.encode("[]", "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                str = "";
            }
            sb.append(str2);
            sb.append(this.equalizer);
            sb.append(str);
        }
        String str3 = this.viewabilityarguments.get(ADVIEWABILITY);
        if (!TextUtils.isEmpty(str3)) {
            sb.append(this.separator);
            sb.append(str3);
            sb.append(this.equalizer);
            sb.append("0");
        }
        String str4 = this.viewabilityarguments.get(ADVIEWABILITY_RESULT);
        if (!TextUtils.isEmpty(str4)) {
            sb.append(this.separator);
            sb.append(str4);
            sb.append(this.equalizer);
            sb.append("2");
        }
        String str5 = this.viewabilityarguments.get(ADMEASURABILITY);
        if (!TextUtils.isEmpty(str5)) {
            sb.append(this.separator);
            sb.append(str5);
            sb.append(this.equalizer);
            sb.append("0");
        }
        return sb.toString();
    }

    public String getSeparator() {
        return this.separator;
    }

    public int getURLExposeDuration() {
        return this.urlExposeDuration;
    }

    public float getURLShowCoverRate() {
        return this.urlShowCoverRate;
    }

    public int getURLVideoDuration() {
        return this.urlVideoDuration;
    }

    public List<AbilityVideoProgress> getURLVideoProcessTrackList() {
        return this.videoTrackList;
    }

    public int getVideoPlayType() {
        return this.videoPlayType;
    }

    public int getViewabilityTrackPolicy() {
        return this.viewabilityTrackPolicy;
    }

    public boolean isVideoExpose() {
        return this.isVideoExpose;
    }

    public boolean isVideoProgressTrack() {
        List<AbilityVideoProgress> list = this.videoTrackList;
        return list != null && list.size() > 0;
    }

    public void setEqualizer(String str) {
        this.equalizer = str;
    }

    public void setSeparator(String str) {
        this.separator = str;
    }

    public void setURLExposeDuration(String str) {
        try {
            String str2 = get(ADVIEWABILITY_CONFIG_THRESHOLD);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String valueFromURL = getValueFromURL(str2, str);
            if (TextUtils.isEmpty(valueFromURL)) {
                return;
            }
            this.urlExposeDuration = Integer.valueOf(valueFromURL).intValue() * 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setURLShowCoverRate(String str) {
        try {
            String str2 = get(ADVIEWABILITY_CONFIG_AREA);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String valueFromURL = getValueFromURL(str2, str);
            if (TextUtils.isEmpty(valueFromURL)) {
                return;
            }
            float intValue = Integer.valueOf(valueFromURL).intValue() / 100.0f;
            if (intValue <= 0.0f || intValue >= 1.0f) {
                return;
            }
            this.urlShowCoverRate = intValue;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setURLVideoDuration(String str) {
        try {
            String str2 = get(ADVIEWABILITY_VIDEO_DURATION);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String valueFromURL = getValueFromURL(str2, str);
            if (TextUtils.isEmpty(valueFromURL)) {
                return;
            }
            this.urlVideoDuration = Integer.valueOf(valueFromURL).intValue() * 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setURLVideoProgressTracks(String str) {
        try {
            String str2 = get(ADVIEWABILITY_VIDEO_PROGRESSPOINT);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String valueFromURL = getValueFromURL(str2, str);
            if (TextUtils.isEmpty(valueFromURL) || valueFromURL.length() != 4) {
                return;
            }
            this.videoTrackList = new ArrayList();
            if (Integer.parseInt(valueFromURL.substring(0, 1)) == 1) {
                this.videoTrackList.add(AbilityVideoProgress.TRACK1_4);
            }
            if (Integer.parseInt(valueFromURL.substring(1, 2)) == 1) {
                this.videoTrackList.add(AbilityVideoProgress.TRACK2_4);
            }
            if (Integer.parseInt(valueFromURL.substring(2, 3)) == 1) {
                this.videoTrackList.add(AbilityVideoProgress.TRACK3_4);
            }
            if (Integer.parseInt(valueFromURL.substring(3, 4)) == 1) {
                this.videoTrackList.add(AbilityVideoProgress.TRACK4_4);
            }
        } catch (Exception e) {
            this.videoTrackList.clear();
            e.printStackTrace();
        }
    }

    public void setVideoExpose(boolean z) {
        this.isVideoExpose = z;
    }

    public void setVideoPlayType(int i) {
        this.videoPlayType = i;
    }

    public void setViewabilityTrackPolicy(int i) {
        this.viewabilityTrackPolicy = (i < 0 || i > 1) ? 0 : 0;
    }

    public void setViewabilityarguments(HashMap<String, Argument> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        if (hashMap != null && hashMap.size() > 0) {
            for (String str : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    String str2 = hashMap.get(str).value;
                    if (!TextUtils.isEmpty(str2)) {
                        hashMap2.put(str, str2);
                    }
                }
            }
        }
        this.viewabilityarguments = hashMap2;
    }
}
