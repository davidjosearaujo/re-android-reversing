package com.facebook.imagepipeline.animated.factory;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface AnimatedFactory {
    @Nullable
    DrawableFactory getAnimatedDrawableFactory(Context context);

    @Nullable
    ImageDecoder getGifDecoder(Bitmap.Config config);

    @Nullable
    ImageDecoder getWebPDecoder(Bitmap.Config config);
}
