package com.facebook.login;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public enum LoginBehavior {
    NATIVE_WITH_FALLBACK(true, true, true, false, true, true, true),
    NATIVE_ONLY(true, true, false, false, false, true, true),
    KATANA_ONLY(false, true, false, false, false, false, false),
    WEB_ONLY(false, false, true, false, true, false, false),
    WEB_VIEW_ONLY(false, false, true, false, false, false, false),
    DIALOG_ONLY(false, true, true, false, true, true, true),
    DEVICE_AUTH(false, false, false, true, false, false, false);
    
    private final boolean allowsCustomTabAuth;
    private final boolean allowsDeviceAuth;
    private final boolean allowsFacebookLiteAuth;
    private final boolean allowsGetTokenAuth;
    private final boolean allowsInstagramAppAuth;
    private final boolean allowsKatanaAuth;
    private final boolean allowsWebViewAuth;

    LoginBehavior(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.allowsGetTokenAuth = z;
        this.allowsKatanaAuth = z2;
        this.allowsWebViewAuth = z3;
        this.allowsDeviceAuth = z4;
        this.allowsCustomTabAuth = z5;
        this.allowsFacebookLiteAuth = z6;
        this.allowsInstagramAppAuth = z7;
    }

    public boolean allowsCustomTabAuth() {
        return this.allowsCustomTabAuth;
    }

    public boolean allowsDeviceAuth() {
        return this.allowsDeviceAuth;
    }

    public boolean allowsFacebookLiteAuth() {
        return this.allowsFacebookLiteAuth;
    }

    public boolean allowsGetTokenAuth() {
        return this.allowsGetTokenAuth;
    }

    public boolean allowsInstagramAppAuth() {
        return this.allowsInstagramAppAuth;
    }

    public boolean allowsKatanaAuth() {
        return this.allowsKatanaAuth;
    }

    public boolean allowsWebViewAuth() {
        return this.allowsWebViewAuth;
    }
}
