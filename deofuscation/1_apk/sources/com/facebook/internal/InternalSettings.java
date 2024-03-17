package com.facebook.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import n.b0;
import n.l2.k;
import n.l2.v.f0;
import n.u2.u;
import r.e.a.d;
import r.e.a.e;

/* compiled from: InternalSettings.kt */
@b0(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\u0006\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/facebook/internal/InternalSettings;", "", "()V", "UNITY_PREFIX", "", "customUserAgent", "isUnityApp", "", "isUnityApp$annotations", "()Z", "getCustomUserAgent", "setCustomUserAgent", "", SDKConstants.PARAM_VALUE, "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class InternalSettings {
    @d
    public static final InternalSettings INSTANCE = new InternalSettings();
    private static final String UNITY_PREFIX = "Unity.";
    private static volatile String customUserAgent;

    private InternalSettings() {
    }

    @k
    @e
    public static final String getCustomUserAgent() {
        return customUserAgent;
    }

    public static final boolean isUnityApp() {
        String str = customUserAgent;
        return str != null && u.u2(str, UNITY_PREFIX, false, 2, (Object) null);
    }

    @k
    public static /* synthetic */ void isUnityApp$annotations() {
    }

    @k
    public static final void setCustomUserAgent(@d String str) {
        f0.p(str, SDKConstants.PARAM_VALUE);
        customUserAgent = str;
    }
}
