package com.facebook.messenger;

import android.net.Uri;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ShareToMessengerParamsBuilder {
    private Uri mExternalUri;
    private String mMetaData;
    private final String mMimeType;
    private final Uri mUri;

    public ShareToMessengerParamsBuilder(Uri uri, String str) {
        this.mUri = uri;
        this.mMimeType = str;
    }

    public ShareToMessengerParams build() {
        return new ShareToMessengerParams(this);
    }

    public Uri getExternalUri() {
        return this.mExternalUri;
    }

    public String getMetaData() {
        return this.mMetaData;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public ShareToMessengerParamsBuilder setExternalUri(Uri uri) {
        this.mExternalUri = uri;
        return this;
    }

    public ShareToMessengerParamsBuilder setMetaData(String str) {
        this.mMetaData = str;
        return this;
    }
}
