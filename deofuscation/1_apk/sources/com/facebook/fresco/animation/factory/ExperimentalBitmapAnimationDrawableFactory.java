package com.facebook.fresco.animation.factory;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.fresco.animation.bitmap.BitmapAnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.fresco.animation.bitmap.cache.FrescoFrameCache;
import com.facebook.fresco.animation.bitmap.cache.KeepLastFrameCache;
import com.facebook.fresco.animation.bitmap.cache.NoOpCache;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.DefaultBitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.FixedNumberBitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendAnimationInformation;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ExperimentalBitmapAnimationDrawableFactory implements DrawableFactory {
    public static final int CACHING_STRATEGY_FRESCO_CACHE = 1;
    public static final int CACHING_STRATEGY_FRESCO_CACHE_NO_REUSING = 2;
    public static final int CACHING_STRATEGY_KEEP_LAST_CACHE = 3;
    public static final int CACHING_STRATEGY_NO_CACHE = 0;
    private final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    private final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    private final Supplier<Integer> mCachingStrategySupplier;
    private final ExecutorService mExecutorServiceForFramePreparing;
    private final MonotonicClock mMonotonicClock;
    private final Supplier<Integer> mNumberOfFramesToPrepareSupplier;
    private final PlatformBitmapFactory mPlatformBitmapFactory;
    private final ScheduledExecutorService mScheduledExecutorServiceForUiThread;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class AnimationFrameCacheKey implements CacheKey {
        private static final String URI_PREFIX = "anim://";
        private final String mAnimationUriString;

        public AnimationFrameCacheKey(int i) {
            this.mAnimationUriString = URI_PREFIX + i;
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean containsUri(Uri uri) {
            return uri.toString().startsWith(this.mAnimationUriString);
        }

        @Override // com.facebook.cache.common.CacheKey
        public String getUriString() {
            return this.mAnimationUriString;
        }
    }

    public ExperimentalBitmapAnimationDrawableFactory(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, MonotonicClock monotonicClock, PlatformBitmapFactory platformBitmapFactory, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, Supplier<Integer> supplier, Supplier<Integer> supplier2) {
        this.mAnimatedDrawableBackendProvider = animatedDrawableBackendProvider;
        this.mScheduledExecutorServiceForUiThread = scheduledExecutorService;
        this.mExecutorServiceForFramePreparing = executorService;
        this.mMonotonicClock = monotonicClock;
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBackingCache = countingMemoryCache;
        this.mCachingStrategySupplier = supplier;
        this.mNumberOfFramesToPrepareSupplier = supplier2;
    }

    private AnimatedDrawableBackend createAnimatedDrawableBackend(AnimatedImageResult animatedImageResult) {
        AnimatedImage image = animatedImageResult.getImage();
        return this.mAnimatedDrawableBackendProvider.get(animatedImageResult, new Rect(0, 0, image.getWidth(), image.getHeight()));
    }

    private AnimatedFrameCache createAnimatedFrameCache(AnimatedImageResult animatedImageResult) {
        return new AnimatedFrameCache(new AnimationFrameCacheKey(animatedImageResult.hashCode()), this.mBackingCache);
    }

    private AnimationBackend createAnimationBackend(AnimatedImageResult animatedImageResult) {
        FixedNumberBitmapFramePreparationStrategy fixedNumberBitmapFramePreparationStrategy;
        BitmapFramePreparer bitmapFramePreparer;
        AnimatedDrawableBackend createAnimatedDrawableBackend = createAnimatedDrawableBackend(animatedImageResult);
        BitmapFrameCache createBitmapFrameCache = createBitmapFrameCache(animatedImageResult);
        AnimatedDrawableBackendFrameRenderer animatedDrawableBackendFrameRenderer = new AnimatedDrawableBackendFrameRenderer(createBitmapFrameCache, createAnimatedDrawableBackend);
        int intValue = this.mNumberOfFramesToPrepareSupplier.get().intValue();
        if (intValue > 0) {
            FixedNumberBitmapFramePreparationStrategy fixedNumberBitmapFramePreparationStrategy2 = new FixedNumberBitmapFramePreparationStrategy(intValue);
            bitmapFramePreparer = createBitmapFramePreparer(animatedDrawableBackendFrameRenderer);
            fixedNumberBitmapFramePreparationStrategy = fixedNumberBitmapFramePreparationStrategy2;
        } else {
            fixedNumberBitmapFramePreparationStrategy = null;
            bitmapFramePreparer = null;
        }
        return AnimationBackendDelegateWithInactivityCheck.createForBackend(new BitmapAnimationBackend(this.mPlatformBitmapFactory, createBitmapFrameCache, new AnimatedDrawableBackendAnimationInformation(createAnimatedDrawableBackend), animatedDrawableBackendFrameRenderer, fixedNumberBitmapFramePreparationStrategy, bitmapFramePreparer), this.mMonotonicClock, this.mScheduledExecutorServiceForUiThread);
    }

    private BitmapFrameCache createBitmapFrameCache(AnimatedImageResult animatedImageResult) {
        int intValue = this.mCachingStrategySupplier.get().intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return new NoOpCache();
                }
                return new KeepLastFrameCache();
            }
            return new FrescoFrameCache(createAnimatedFrameCache(animatedImageResult), false);
        }
        return new FrescoFrameCache(createAnimatedFrameCache(animatedImageResult), true);
    }

    private BitmapFramePreparer createBitmapFramePreparer(BitmapFrameRenderer bitmapFrameRenderer) {
        return new DefaultBitmapFramePreparer(this.mPlatformBitmapFactory, bitmapFrameRenderer, Bitmap.Config.ARGB_8888, this.mExecutorServiceForFramePreparing);
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public boolean supportsImageType(CloseableImage closeableImage) {
        return closeableImage instanceof CloseableAnimatedImage;
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public AnimatedDrawable2 createDrawable(CloseableImage closeableImage) {
        return new AnimatedDrawable2(createAnimationBackend(((CloseableAnimatedImage) closeableImage).getImageResult()));
    }
}
