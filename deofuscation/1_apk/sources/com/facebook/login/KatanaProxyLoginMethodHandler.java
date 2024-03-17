package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.FacebookSdk;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginClient;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class KatanaProxyLoginMethodHandler extends NativeAppLoginMethodHandler {
    public static final Parcelable.Creator<KatanaProxyLoginMethodHandler> CREATOR = new Parcelable.Creator<KatanaProxyLoginMethodHandler>() { // from class: com.facebook.login.KatanaProxyLoginMethodHandler.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public KatanaProxyLoginMethodHandler createFromParcel(Parcel parcel) {
            return new KatanaProxyLoginMethodHandler(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public KatanaProxyLoginMethodHandler[] newArray(int i) {
            return new KatanaProxyLoginMethodHandler[i];
        }
    };

    public KatanaProxyLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public String getNameForLogging() {
        return "katana_proxy_auth";
    }

    @Override // com.facebook.login.LoginMethodHandler
    public boolean shouldKeepTrackOfMultipleIntents() {
        return true;
    }

    @Override // com.facebook.login.NativeAppLoginMethodHandler, com.facebook.login.LoginMethodHandler
    public int tryAuthorize(LoginClient.Request request) {
        boolean z = FacebookSdk.ignoreAppSwitchToLoggedOut && CustomTabUtils.getChromePackage() != null && request.getLoginBehavior().allowsCustomTabAuth();
        String e2e = LoginClient.getE2E();
        List<Intent> createProxyAuthIntents = NativeProtocol.createProxyAuthIntents(this.loginClient.getActivity(), request.getApplicationId(), request.getPermissions(), e2e, request.isRerequest(), request.hasPublishPermission(), request.getDefaultAudience(), getClientState(request.getAuthId()), request.getAuthType(), z, request.getMessengerPageId(), request.getResetMessengerState(), request.isFamilyLogin(), request.shouldSkipAccountDeduplication());
        addLoggingExtra("e2e", e2e);
        for (int i = 0; i < createProxyAuthIntents.size(); i++) {
            if (tryIntent(createProxyAuthIntents.get(i), LoginClient.getLoginRequestCode())) {
                return i + 1;
            }
        }
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public KatanaProxyLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }
}
