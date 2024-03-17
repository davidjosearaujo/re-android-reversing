package com.huawei.hms.support.hwid.result;

import android.accounts.Account;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.hwid.ap;
import com.huawei.hms.hwid.as;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.feature.result.AbstractAuthAccount;
import com.huawei.hms.utils.HMSPackageManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AuthHuaweiId extends AbstractAuthAccount {
    public static final Parcelable.Creator<AuthHuaweiId> CREATOR = new Parcelable.Creator<AuthHuaweiId>() { // from class: com.huawei.hms.support.hwid.result.AuthHuaweiId.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AuthHuaweiId createFromParcel(Parcel parcel) {
            return new AuthHuaweiId(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AuthHuaweiId[] newArray(int i) {
            return new AuthHuaweiId[i];
        }
    };

    public AuthHuaweiId(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, Set<Scope> set, String str7, String str8, String str9) {
        this.openId = str;
        this.uid = str2;
        this.displayName = str3;
        this.photoUriString = str4;
        this.accessToken = str5;
        this.serviceCountryCode = str6;
        this.status = i;
        this.gender = i2;
        this.grantedScopes = set;
        this.serverAuthCode = str7;
        this.unionId = str8;
        this.countryCode = str9;
    }

    public static AuthHuaweiId build(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, Set<Scope> set, String str7, String str8, String str9) {
        return new AuthHuaweiId(str, str2, str3, str4, str5, str6, i, i2, set, str7, str8, str9);
    }

    public static AuthHuaweiId createDefault() {
        return build(null, null, null, null, null, null, 0, -1, new HashSet(), null, null, null);
    }

    public static AuthHuaweiId fromJson(String str) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            return fromJson(new JSONObject(str));
        }
        throw new JSONException("invalid json format");
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AuthHuaweiId) {
            return getAuthorizedScopes().equals(((AuthHuaweiId) obj).getAuthorizedScopes());
        }
        return false;
    }

    public int getAgeRangeFlag() {
        try {
            return Integer.parseInt(this.ageRange);
        } catch (NumberFormatException unused) {
            as.b("AuthHuaweiId", "Invalid ageRange NumberFormatException", true);
            return -1;
        }
    }

    public Account getHuaweiAccount(Context context) {
        if (TextUtils.isEmpty(this.email)) {
            return null;
        }
        return new Account(this.email, HMSPackageManager.getInstance(context).getHMSPackageName());
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public int hashCode() {
        return getRequestedScopes().hashCode();
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public /* bridge */ /* synthetic */ AbstractAuthAccount requestExtraScopes(List list) {
        return requestExtraScopes((List<Scope>) list);
    }

    @Override // com.huawei.hms.support.feature.result.AbstractAuthAccount
    public AuthHuaweiId requestExtraScopes(List<Scope> list) {
        if (ap.b(list).booleanValue()) {
            this.extensionScopes.addAll(list);
        }
        return this;
    }

    public static AuthHuaweiId fromJson(JSONObject jSONObject) throws JSONException {
        AuthHuaweiId authHuaweiId = new AuthHuaweiId();
        authHuaweiId.parserJson(jSONObject);
        return authHuaweiId;
    }

    public AuthHuaweiId(Parcel parcel) {
        readFromParcel(parcel);
    }

    public AuthHuaweiId() {
        this.gender = -1;
        this.status = 0;
        this.grantedScopes = new HashSet();
    }
}
