package com.facebook.gamingservices;

import android.content.Context;
import android.net.Uri;
import com.facebook.GraphRequest$OnProgressCallback;
import com.facebook.share.internal.VideoUploader;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.io.FileNotFoundException;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class GamingVideoUploader {
    private Context context;

    public GamingVideoUploader(Context context) {
        this.context = context;
    }

    public void uploadToMediaLibrary(String str, Uri uri) throws FileNotFoundException {
        uploadToMediaLibrary(str, uri, null);
    }

    public void uploadToMediaLibrary(String str, Uri uri, GraphRequest$OnProgressCallback graphRequest$OnProgressCallback) throws FileNotFoundException {
        uploadToMediaLibrary(str, uri, false, graphRequest$OnProgressCallback);
    }

    public void uploadToMediaLibrary(String str, Uri uri, boolean z, GraphRequest$OnProgressCallback graphRequest$OnProgressCallback) throws FileNotFoundException {
        ShareVideoContent build = new ShareVideoContent.Builder().setVideo(new ShareVideo.Builder().setLocalUrl(uri).build()).setContentDescription(str).build();
        if (z) {
            graphRequest$OnProgressCallback = new OpenGamingMediaDialog(this.context, graphRequest$OnProgressCallback);
        }
        VideoUploader.uploadAsyncWithProgressCallback(build, graphRequest$OnProgressCallback);
    }
}
