package com.huawei.hms.adapter;

import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CoreBaseRequest implements IMessageEntity {
    @Packed
    private String jsonHeader;
    @Packed
    private String jsonObject;
    @Packed
    private Parcelable parcelable;

    public String getJsonHeader() {
        return this.jsonHeader;
    }

    public String getJsonObject() {
        return this.jsonObject;
    }

    public Parcelable getParcelable() {
        return this.parcelable;
    }

    public void setJsonHeader(String str) {
        this.jsonHeader = str;
    }

    public void setJsonObject(String str) {
        this.jsonObject = str;
    }

    public void setParcelable(Parcelable parcelable) {
        this.parcelable = parcelable;
    }
}
