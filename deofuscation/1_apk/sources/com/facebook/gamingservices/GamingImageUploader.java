package com.facebook.gamingservices;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest$Callback;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class GamingImageUploader {
    private static final String photoUploadEdge = "me/photos";
    private Context context;

    public GamingImageUploader(Context context) {
        this.context = context;
    }

    public void uploadToMediaLibrary(String str, Bitmap bitmap, boolean z) {
        uploadToMediaLibrary(str, bitmap, z, (GraphRequest$Callback) null);
    }

    public void uploadToMediaLibrary(String str, Bitmap bitmap, boolean z, GraphRequest$Callback graphRequest$Callback) {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), "me/photos", bitmap, str, (Bundle) null, z ? new OpenGamingMediaDialog(this.context, graphRequest$Callback) : graphRequest$Callback).executeAsync();
    }

    public void uploadToMediaLibrary(String str, File file, boolean z) throws FileNotFoundException {
        uploadToMediaLibrary(str, file, z, (GraphRequest$Callback) null);
    }

    public void uploadToMediaLibrary(String str, File file, boolean z, GraphRequest$Callback graphRequest$Callback) throws FileNotFoundException {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), "me/photos", file, str, (Bundle) null, z ? new OpenGamingMediaDialog(this.context, graphRequest$Callback) : graphRequest$Callback).executeAsync();
    }

    public void uploadToMediaLibrary(String str, Uri uri, boolean z) throws FileNotFoundException {
        uploadToMediaLibrary(str, uri, z, (GraphRequest$Callback) null);
    }

    public void uploadToMediaLibrary(String str, Uri uri, boolean z, GraphRequest$Callback graphRequest$Callback) throws FileNotFoundException {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), "me/photos", uri, str, (Bundle) null, z ? new OpenGamingMediaDialog(this.context, graphRequest$Callback) : graphRequest$Callback).executeAsync();
    }
}
