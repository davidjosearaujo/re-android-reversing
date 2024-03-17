package com.facebook.gamingservices.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest$Callback;
import com.facebook.HttpMethod;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.io.FileNotFoundException;

@AutoHandleExceptions
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class GamingMediaUploader {
    private static final String photoUploadEdge = "me/photos";

    public static void uploadToGamingServices(String str, Bitmap bitmap, Bundle bundle, GraphRequest$Callback graphRequest$Callback) {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), "me/photos", bitmap, str, bundle, graphRequest$Callback).executeAsync();
    }

    public static void uploadToGamingServices(String str, File file, Bundle bundle, GraphRequest$Callback graphRequest$Callback) throws FileNotFoundException {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), "me/photos", file, str, bundle, graphRequest$Callback).executeAsync();
    }

    public static void uploadToGamingServices(String str, Uri uri, Bundle bundle, GraphRequest$Callback graphRequest$Callback) throws FileNotFoundException {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (!Utility.isFileUri(uri) && !Utility.isContentUri(uri)) {
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            bundle2.putString("url", uri.toString());
            if (str != null && !str.isEmpty()) {
                bundle2.putString(ShareConstants.FEED_CAPTION_PARAM, str);
            }
            new GraphRequest(currentAccessToken, "me/photos", bundle2, HttpMethod.POST, graphRequest$Callback).executeAsync();
            return;
        }
        GraphRequest.newUploadPhotoRequest(currentAccessToken, "me/photos", uri, str, bundle, graphRequest$Callback).executeAsync();
    }
}
