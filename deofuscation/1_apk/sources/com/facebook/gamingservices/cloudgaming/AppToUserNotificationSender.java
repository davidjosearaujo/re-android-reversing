package com.facebook.gamingservices.cloudgaming;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.facebook.GraphRequest$Callback;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.internal.GamingMediaUploader;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class AppToUserNotificationSender {
    private static Bundle getParameters() {
        Bundle bundle = new Bundle();
        bundle.putString("upload_source", "A2U");
        return bundle;
    }

    public static void scheduleAppToUserNotification(String str, String str2, Bitmap bitmap, int i, @Nullable String str3, GraphRequest$Callback graphRequest$Callback) throws FileNotFoundException {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, bitmap, getParameters(), new MediaUploadCallback(str, str2, i, str3, graphRequest$Callback));
    }

    public static void scheduleAppToUserNotification(String str, String str2, File file, int i, @Nullable String str3, GraphRequest$Callback graphRequest$Callback) throws FileNotFoundException {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, file, getParameters(), new MediaUploadCallback(str, str2, i, str3, graphRequest$Callback));
    }

    public static void scheduleAppToUserNotification(String str, String str2, Uri uri, int i, @Nullable String str3, GraphRequest$Callback graphRequest$Callback) throws FileNotFoundException {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, uri, getParameters(), new MediaUploadCallback(str, str2, i, str3, graphRequest$Callback));
    }
}
