package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.internal.ServerProtocol;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class BitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "BitmapMemoryCacheProducer";
    private final CacheKeyFactory mCacheKeyFactory;
    private final Producer<CloseableReference<CloseableImage>> mInputProducer;
    private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

    public BitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    public String getProducerName() {
        return PRODUCER_NAME;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        boolean isTracing;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("BitmapMemoryCacheProducer#produceResults");
            }
            ProducerListener listener = producerContext.getListener();
            String id = producerContext.getId();
            listener.onProducerStart(id, getProducerName());
            CacheKey bitmapCacheKey = this.mCacheKeyFactory.getBitmapCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext());
            CloseableReference<CloseableImage> closeableReference = this.mMemoryCache.get(bitmapCacheKey);
            if (closeableReference != null) {
                boolean isOfFullQuality = closeableReference.get().getQualityInfo().isOfFullQuality();
                if (isOfFullQuality) {
                    listener.onProducerFinishWithSuccess(id, getProducerName(), listener.requiresExtraMap(id) ? ImmutableMap.of("cached_value_found", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) : null);
                    listener.onUltimateProducerReached(id, getProducerName(), true);
                    consumer.onProgressUpdate(1.0f);
                }
                consumer.onNewResult(closeableReference, BaseConsumer.simpleStatusForIsLast(isOfFullQuality));
                closeableReference.close();
                if (isOfFullQuality) {
                    if (isTracing) {
                        return;
                    }
                    return;
                }
            }
            if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
                listener.onProducerFinishWithSuccess(id, getProducerName(), listener.requiresExtraMap(id) ? ImmutableMap.of("cached_value_found", "false") : null);
                listener.onUltimateProducerReached(id, getProducerName(), false);
                consumer.onNewResult(null, 1);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                    return;
                }
                return;
            }
            Consumer<CloseableReference<CloseableImage>> wrapConsumer = wrapConsumer(consumer, bitmapCacheKey, producerContext.getImageRequest().isMemoryCacheEnabled());
            listener.onProducerFinishWithSuccess(id, getProducerName(), listener.requiresExtraMap(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("mInputProducer.produceResult");
            }
            this.mInputProducer.produceResults(wrapConsumer, producerContext);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public Consumer<CloseableReference<CloseableImage>> wrapConsumer(Consumer<CloseableReference<CloseableImage>> consumer, final CacheKey cacheKey, final boolean z) {
        return new DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>(consumer) { // from class: com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer.1
            {
                BitmapMemoryCacheProducer.this = this;
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
                CloseableReference<CloseableImage> closeableReference2;
                boolean isTracing;
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("BitmapMemoryCacheProducer#onNewResultImpl");
                    }
                    boolean isLast = BaseConsumer.isLast(i);
                    if (closeableReference == null) {
                        if (isLast) {
                            getConsumer().onNewResult(null, i);
                        }
                        if (isTracing) {
                            return;
                        }
                        return;
                    }
                    if (!closeableReference.get().isStateful() && !BaseConsumer.statusHasFlag(i, 8)) {
                        if (!isLast && (closeableReference2 = BitmapMemoryCacheProducer.this.mMemoryCache.get(cacheKey)) != null) {
                            QualityInfo qualityInfo = closeableReference.get().getQualityInfo();
                            QualityInfo qualityInfo2 = closeableReference2.get().getQualityInfo();
                            if (!qualityInfo2.isOfFullQuality() && qualityInfo2.getQuality() < qualityInfo.getQuality()) {
                                CloseableReference.closeSafely(closeableReference2);
                            } else {
                                getConsumer().onNewResult(closeableReference2, i);
                                CloseableReference.closeSafely(closeableReference2);
                                if (FrescoSystrace.isTracing()) {
                                    FrescoSystrace.endSection();
                                    return;
                                }
                                return;
                            }
                        }
                        CloseableReference<CloseableImage> cache = z ? BitmapMemoryCacheProducer.this.mMemoryCache.cache(cacheKey, closeableReference) : null;
                        if (isLast) {
                            getConsumer().onProgressUpdate(1.0f);
                        }
                        Consumer<CloseableReference<CloseableImage>> consumer2 = getConsumer();
                        if (cache != null) {
                            closeableReference = cache;
                        }
                        consumer2.onNewResult(closeableReference, i);
                        CloseableReference.closeSafely(cache);
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                            return;
                        }
                        return;
                    }
                    getConsumer().onNewResult(closeableReference, i);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                } finally {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
            }
        };
    }
}