package com.huawei.hms.support.api.entity.hwid;

import com.huawei.hms.support.api.entity.common.CommonConstant;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class QueryShippingAddressResp extends IHwIDRespEntity {
    @Checked(permission = CommonConstant.PERMISSION.SHIPPING_ADDRESS, scope = CommonConstant.SCOPE.SCOPE_ACCOUNT_SHIPPING_ADDRESS, value = CommonConstant.RETKEY.SHIPPING_ADDRESS)
    private ShippingAddressParcelable shippingAddressParcelable;

    public ShippingAddressParcelable getShippingAddressParcelable() {
        return this.shippingAddressParcelable;
    }
}
