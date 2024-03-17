package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;
import javax.annotation.Nullable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface ImageTranscoderFactory {
    @Nullable
    ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z);
}
