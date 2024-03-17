package com.hunantv.media.report.entity;

import com.hunantv.media.player.libnative.ImgovsrDeviceInfo;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class VVEntity {
    public String act = "pvv";
    public String cdtp;
    public String cip;
    public CommonEntity common;
    public String dectp;
    public String dlpt;
    public String hddc;
    public String ltst;
    public String mp;
    public String netd;
    public String t1;
    public String t2;
    public String t3;
    public String t4;
    public String t5;
    public String t6;
    public String vsinfo;
    public String vsraver;
    public String vsrbugft;
    public String vsrdid;
    public String vsrdn;
    public String vsrdt;
    public String vsrdver;
    public String vsrfp16int8ft;
    public String vsrhardlt;
    public String vsrnpuver;
    public String vsrsubg;
    public String vsrver;
    public String vsrvid;
    public String vsrvkver;
    public String vvbt;
    public String vvs;
    public String vvt;

    public void setImgovsrDeviceInfo(ImgovsrDeviceInfo imgovsrDeviceInfo) {
        if (imgovsrDeviceInfo == null) {
            return;
        }
        this.vsraver = imgovsrDeviceInfo.vsr_api_version;
        this.vsrdver = imgovsrDeviceInfo.vsr_driver_version;
        this.vsrvid = imgovsrDeviceInfo.vsr_vendor_id;
        this.vsrdid = imgovsrDeviceInfo.vsr_device_id;
        this.vsrdn = imgovsrDeviceInfo.vsr_device_name;
        this.vsrdt = imgovsrDeviceInfo.vsr_gpu_type;
        this.vsrhardlt = imgovsrDeviceInfo.vsr_hard_limit;
        this.vsrsubg = imgovsrDeviceInfo.vsr_support_subgroup;
        this.vsrbugft = imgovsrDeviceInfo.vsr_bug_feature;
        this.vsrfp16int8ft = imgovsrDeviceInfo.vsr_fp16_int8_feature;
    }
}
