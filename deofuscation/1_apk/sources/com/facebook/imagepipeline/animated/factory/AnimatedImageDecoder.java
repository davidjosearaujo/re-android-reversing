package com.facebook.imagepipeline.animated.factory;

import com.facebook.imagepipeline.animated.base.AnimatedImage;
import java.nio.ByteBuffer;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface AnimatedImageDecoder {
    AnimatedImage decode(long j, int i);

    AnimatedImage decode(ByteBuffer byteBuffer);
}
