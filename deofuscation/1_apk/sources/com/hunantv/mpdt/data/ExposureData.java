package com.hunantv.mpdt.data;

import com.hunantv.imgo.net.RequestParams;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ExposureData extends CommonData {
    public static final String ACT_EXPOSURE = "show";
    public static final String EXPOSURE_HOME_PAGE_FLAG = "111";
    public static final String EXPOSURE_HOT_TOPIC_PAGE_FLAG = "121";
    public static final String EXPOSURE_IMMERSIVE_FLAG = "110";
    public static final String EXPOSURE_LIBRARY_FLAG = "109";
    public static final String EXPOSURE_SEARCHRESULT_FLAG = "108";
    public static final String EXPOSURE_SELECTED_FLAG = "100";
    public static final String EXPOSURE_STYPE_FIRST = "1";
    public static final String EXPOSURE_STYPE_PAGE_REBACK = "4";
    public static final String EXPOSURE_STYPE_REBACK = "3";
    public static final String EXPOSURE_STYPE_SCROLL = "2";
    public static final String EXPOSURE_USER_VIDEO_PRODUCT_FLAG = "105";
    public static final String EXPOSURE_VIP_SELECTED_FLAG = "102";
    private static final long serialVersionUID = 8396080732528423922L;
    private String act;
    private String body;
    private String cpid;
    private String cpn;
    private String flag;
    private String name;
    private String pos;
    private String suuid;
    private String type;
    private int uvip;
    private String value;

    public RequestParams createOldRequestParams() {
        RequestParams createBaseRequestParams = createBaseRequestParams();
        createBaseRequestParams.put("act", ACT_EXPOSURE);
        return createBaseRequestParams;
    }

    public RequestParams createRequestParams() {
        return createBaseRequestParams();
    }
}
