package com.facebook.fresco.animation.bitmap.preparation;

import com.facebook.common.logging.FLog;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class FixedNumberBitmapFramePreparationStrategy implements BitmapFramePreparationStrategy {
    private static final int DEFAULT_FRAMES_TO_PREPARE = 3;
    private static final Class<?> TAG = FixedNumberBitmapFramePreparationStrategy.class;
    private final int mFramesToPrepare;

    public FixedNumberBitmapFramePreparationStrategy() {
        this(3);
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy
    public void prepareFrames(BitmapFramePreparer bitmapFramePreparer, BitmapFrameCache bitmapFrameCache, AnimationBackend animationBackend, int i) {
        for (int i2 = 1; i2 <= this.mFramesToPrepare; i2++) {
            int frameCount = (i + i2) % animationBackend.getFrameCount();
            if (FLog.isLoggable(2)) {
                FLog.v(TAG, "Preparing frame %d, last drawn: %d", Integer.valueOf(frameCount), Integer.valueOf(i));
            }
            if (!bitmapFramePreparer.prepareFrame(bitmapFrameCache, animationBackend, frameCount)) {
                return;
            }
        }
    }

    public FixedNumberBitmapFramePreparationStrategy(int i) {
        this.mFramesToPrepare = i;
    }
}
