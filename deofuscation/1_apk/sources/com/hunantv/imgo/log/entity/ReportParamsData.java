package com.hunantv.imgo.log.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.hunantv.mpdt.data.EventClickData;
import com.mgtv.task.http.MultiParts;
import j.l.a.n.k.b;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ReportParamsData implements Parcelable {
    public static Parcelable.Creator<ReportParamsData> CREATOR = new a();
    private String account;
    private String appVersion;
    private String boxBrands;
    private String boxModel;
    private String chip;
    private String company;
    private String contactInfo;
    private String country;
    private String cpuInfo;
    private String decoder_type;
    private String deviceId;
    private String filePath;
    private String images;
    private String is_soft;
    private String model;
    private String mp_type;
    private String mp_version;
    private String networkType;
    private String patver;
    private String platformType;
    private String platformVersion;
    private String playHistory;
    private String questionDesc;
    private String questionInfo;
    private int retryTime;
    private String sdk_version;
    private String src;
    private String subType;
    private String uid;
    private String videos;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a implements Parcelable.Creator<ReportParamsData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ReportParamsData createFromParcel(Parcel parcel) {
            return new ReportParamsData(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ReportParamsData[] newArray(int i) {
            return new ReportParamsData[i];
        }
    }

    public /* synthetic */ ReportParamsData(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static ReportParamsData unmarshall(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        ReportParamsData createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAccount() {
        return this.account;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getBoxBrands() {
        return this.boxBrands;
    }

    public String getBoxModel() {
        return this.boxModel;
    }

    public String getChip() {
        return this.chip;
    }

    public String getCompany() {
        return this.company;
    }

    public String getContactInfo() {
        return this.contactInfo;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCpuInfo() {
        return this.cpuInfo;
    }

    public String getDecoder_type() {
        return this.decoder_type;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getIs_soft() {
        return this.is_soft;
    }

    public String getModel() {
        return this.model;
    }

    public String getMp_type() {
        return this.mp_type;
    }

    public String getMp_version() {
        return this.mp_version;
    }

    public MultiParts getMultiParts() {
        MultiParts multiParts = new MultiParts();
        if (!TextUtils.isEmpty(this.appVersion)) {
            multiParts.put("appVersion", this.appVersion);
        }
        if (!TextUtils.isEmpty(this.patver)) {
            multiParts.put("patver", this.patver);
        }
        if (!TextUtils.isEmpty(this.deviceId)) {
            multiParts.put("deviceId", this.deviceId);
        }
        if (!TextUtils.isEmpty(this.company)) {
            multiParts.put("company", this.company);
        }
        if (!TextUtils.isEmpty(this.platformType)) {
            multiParts.put("platformType", this.platformType);
        }
        if (!TextUtils.isEmpty(this.platformVersion)) {
            multiParts.put("platformVersion", this.platformVersion);
        }
        if (!TextUtils.isEmpty(this.account)) {
            multiParts.put("account", this.account);
        }
        if (!TextUtils.isEmpty(this.uid)) {
            multiParts.put(CommonConstant.KEY_UID, this.uid);
        }
        if (!TextUtils.isEmpty(this.cpuInfo)) {
            multiParts.put("cpuInfo", this.cpuInfo);
        }
        if (!TextUtils.isEmpty(this.model)) {
            multiParts.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, this.model);
        }
        if (!TextUtils.isEmpty(this.networkType)) {
            multiParts.put("networkType", this.networkType);
        }
        if (!TextUtils.isEmpty(this.playHistory)) {
            multiParts.put(EventClickData.a.x, this.playHistory);
        }
        if (!TextUtils.isEmpty(this.questionInfo)) {
            multiParts.put("questionInfo", this.questionInfo);
        }
        if (!TextUtils.isEmpty(this.questionDesc)) {
            multiParts.put("questionDesc", this.questionDesc);
        }
        if (!TextUtils.isEmpty(this.contactInfo)) {
            multiParts.put("contactInfo", this.contactInfo);
        }
        if (!TextUtils.isEmpty(this.sdk_version)) {
            multiParts.put(HianalyticsBaseData.SDK_VERSION, this.sdk_version);
        }
        if (!TextUtils.isEmpty(this.mp_type)) {
            multiParts.put("mp_type", this.mp_type);
        }
        if (!TextUtils.isEmpty(this.mp_version)) {
            multiParts.put("mp_version", this.mp_version);
        }
        if (!TextUtils.isEmpty(this.decoder_type)) {
            multiParts.put("decoder_type", this.decoder_type);
        }
        multiParts.put("is_soft", this.is_soft);
        if (!TextUtils.isEmpty(this.chip)) {
            multiParts.put("chip", this.chip);
        }
        if (!TextUtils.isEmpty(this.subType)) {
            multiParts.put("subType", this.subType);
        }
        if (!TextUtils.isEmpty(this.src)) {
            multiParts.put("src", this.src);
        }
        if (!TextUtils.isEmpty(this.videos)) {
            multiParts.put("videos", this.videos);
        }
        if (!TextUtils.isEmpty(this.images)) {
            multiParts.put("images", this.images);
        }
        if (!TextUtils.isEmpty(this.country)) {
            multiParts.put(UserDataStore.COUNTRY, this.country);
        }
        if (!TextUtils.isEmpty(this.boxBrands)) {
            multiParts.put("boxBrands", this.boxBrands);
        }
        if (!TextUtils.isEmpty(this.boxModel)) {
            multiParts.put("boxModel", this.boxModel);
        }
        return multiParts;
    }

    public String getNetworkType() {
        return this.networkType;
    }

    public String getPlatformType() {
        return this.platformType;
    }

    public String getPlatformVersion() {
        return this.platformVersion;
    }

    public String getPlayHistory() {
        return this.playHistory;
    }

    public b getProtocolStruct() {
        return new b((byte) 10, toByteArray().length);
    }

    public String getQuestionDesc() {
        return this.questionDesc;
    }

    public String getQuestionInfo() {
        return this.questionInfo;
    }

    public int getRetryTime() {
        return this.retryTime;
    }

    public String getSdk_version() {
        return this.sdk_version;
    }

    public String getSrc() {
        return this.src;
    }

    public String getSubType() {
        return this.subType;
    }

    public String getUid() {
        return this.uid;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setBoxBrands(String str) {
        this.boxBrands = str;
    }

    public void setBoxModel(String str) {
        this.boxModel = str;
    }

    public void setChip(String str) {
        this.chip = str;
    }

    public void setCompany(String str) {
        this.company = str;
    }

    public void setContactInfo(String str) {
        this.contactInfo = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCpuInfo(String str) {
        this.cpuInfo = str;
    }

    public void setDecoder_type(String str) {
        this.decoder_type = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setImages(String str) {
        this.images = str;
    }

    public void setIs_soft(String str) {
        this.is_soft = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setMp_type(String str) {
        this.mp_type = str;
    }

    public void setMp_version(String str) {
        this.mp_version = str;
    }

    public void setNetworkType(String str) {
        this.networkType = str;
    }

    public void setPatver(String str) {
        this.patver = str;
    }

    public void setPlatformType(String str) {
        this.platformType = str;
    }

    public void setPlatformVersion(String str) {
        this.platformVersion = str;
    }

    public void setPlayHistory(String str) {
        this.playHistory = str;
    }

    public void setQuestionDesc(String str) {
        this.questionDesc = str;
    }

    public void setQuestionInfo(String str) {
        this.questionInfo = str;
    }

    public void setRetryTime(int i) {
        this.retryTime = i;
    }

    public void setSdk_version(String str) {
        this.sdk_version = str;
    }

    public void setSrc(String str) {
        this.src = str;
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setVideos(String str) {
        this.videos = str;
    }

    public byte[] toByteArray() {
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        writeToParcel(obtain, 1);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public String toString() {
        return "ReportParamsData{appVersion='" + this.appVersion + "', deviceId='" + this.deviceId + "', company='" + this.company + "', platformType='" + this.platformType + "', platformVersion='" + this.platformVersion + "', account='" + this.account + "', uid='" + this.uid + "', cpuInfo='" + this.cpuInfo + "', model='" + this.model + "', networkType='" + this.networkType + "', playHistory='" + this.playHistory + "', questionInfo='" + this.questionInfo + "', questionDesc='" + this.questionDesc + "', contactInfo='" + this.contactInfo + "', filePath='" + this.filePath + "', retryTime=" + this.retryTime + ", sdk_version='" + this.sdk_version + "', mp_type='" + this.mp_type + "', mp_version='" + this.mp_version + "', is_soft='" + this.is_soft + "', decoder_type='" + this.decoder_type + "', chip='" + this.chip + "', subType='" + this.subType + "', src='" + this.src + "', country='" + this.country + "', boxBrands='" + this.boxBrands + "', boxModel='" + this.boxModel + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appVersion);
        parcel.writeString(this.patver);
        parcel.writeString(this.deviceId);
        parcel.writeString(this.company);
        parcel.writeString(this.platformType);
        parcel.writeString(this.platformVersion);
        parcel.writeString(this.account);
        parcel.writeString(this.uid);
        parcel.writeString(this.cpuInfo);
        parcel.writeString(this.model);
        parcel.writeString(this.networkType);
        parcel.writeString(this.playHistory);
        parcel.writeString(this.questionInfo);
        parcel.writeString(this.questionDesc);
        parcel.writeString(this.contactInfo);
        parcel.writeString(this.filePath);
        parcel.writeInt(this.retryTime);
        parcel.writeString(this.sdk_version);
        parcel.writeString(this.mp_type);
        parcel.writeString(this.mp_version);
        parcel.writeString(this.is_soft);
        parcel.writeString(this.decoder_type);
        parcel.writeString(this.chip);
        parcel.writeString(this.subType);
        parcel.writeString(this.src);
        parcel.writeString(this.videos);
        parcel.writeString(this.images);
        parcel.writeString(this.country);
        parcel.writeString(this.boxBrands);
        parcel.writeString(this.boxModel);
    }

    private ReportParamsData(Parcel parcel) {
        this.appVersion = parcel.readString();
        this.patver = parcel.readString();
        this.deviceId = parcel.readString();
        this.company = parcel.readString();
        this.platformType = parcel.readString();
        this.platformVersion = parcel.readString();
        this.account = parcel.readString();
        this.uid = parcel.readString();
        this.cpuInfo = parcel.readString();
        this.model = parcel.readString();
        this.networkType = parcel.readString();
        this.playHistory = parcel.readString();
        this.questionInfo = parcel.readString();
        this.questionDesc = parcel.readString();
        this.contactInfo = parcel.readString();
        this.filePath = parcel.readString();
        this.retryTime = parcel.readInt();
        this.sdk_version = parcel.readString();
        this.mp_type = parcel.readString();
        this.mp_version = parcel.readString();
        this.is_soft = parcel.readString();
        this.decoder_type = parcel.readString();
        this.chip = parcel.readString();
        this.subType = parcel.readString();
        this.src = parcel.readString();
        this.videos = parcel.readString();
        this.images = parcel.readString();
        this.country = parcel.readString();
        this.boxBrands = parcel.readString();
        this.boxModel = parcel.readString();
    }

    public ReportParamsData() {
    }
}
