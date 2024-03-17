package com.huawei.hms.support.api.hwid;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.hwid.ShippingAddressInfo;
import java.util.ArrayList;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AddressResult extends Result {
    private ArrayList<ShippingAddressInfo> shippingAddressInfoList;

    public AddressResult() {
    }

    public ArrayList<ShippingAddressInfo> getShippingAddressInfoList() {
        return this.shippingAddressInfoList;
    }

    public void setShippingAddressInfoList(ArrayList<ShippingAddressInfo> arrayList) {
        this.shippingAddressInfoList = arrayList;
    }

    public AddressResult(Status status) {
        setStatus(status);
    }
}
