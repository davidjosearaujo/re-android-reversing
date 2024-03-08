package com.davemorrissey.labs.subscaleview.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public interface ImageRegionDecoder {
    Bitmap decodeRegion(Rect rect, int i7);

    Point init(Context context, Uri uri);

    boolean isReady();

    void recycle();
}
