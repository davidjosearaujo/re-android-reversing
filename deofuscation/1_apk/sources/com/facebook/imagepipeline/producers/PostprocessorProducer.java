package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessorRunner;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PostprocessorProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String NAME = "PostprocessorProducer";
    @VisibleForTesting
    public static final String POSTPROCESSOR = "Postprocessor";
    private final PlatformBitmapFactory mBitmapFactory;
    private final Executor mExecutor;
    private final Producer<CloseableReference<CloseableImage>> mInputProducer;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class PostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        @GuardedBy("PostprocessorConsumer.this")
        private boolean mIsClosed;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean mIsDirty;
        @GuardedBy("PostprocessorConsumer.this")
        private boolean mIsPostProcessingRunning;
        private final ProducerListener mListener;
        private final Postprocessor mPostprocessor;
        private final String mRequestId;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        private CloseableReference<CloseableImage> mSourceImageRef;
        @GuardedBy("PostprocessorConsumer.this")
        private int mStatus;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> consumer, ProducerListener producerListener, String str, Postprocessor postprocessor, ProducerContext producerContext) {
            super(consumer);
            PostprocessorProducer.this = r1;
            this.mSourceImageRef = null;
            this.mStatus = 0;
            this.mIsDirty = false;
            this.mIsPostProcessingRunning = false;
            this.mListener = producerListener;
            this.mRequestId = str;
            this.mPostprocessor = postprocessor;
            producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.1
                {
                    PostprocessorConsumer.this = this;
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    PostprocessorConsumer.this.maybeNotifyOnCancellation();
                }
            });
        }

        public void clearRunningAndStartIfDirty() {
            boolean runningIfDirtyAndNotRunning;
            synchronized (this) {
                this.mIsPostProcessingRunning = false;
                runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
            }
            if (runningIfDirtyAndNotRunning) {
                submitPostprocessing();
            }
        }

        private boolean close() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.mSourceImageRef;
                this.mSourceImageRef = null;
                this.mIsClosed = true;
                CloseableReference.closeSafely(closeableReference);
                return true;
            }
        }

        public void doPostprocessing(CloseableReference<CloseableImage> closeableReference, int i) {
            Preconditions.checkArgument(CloseableReference.isValid(closeableReference));
            if (!shouldPostprocess(closeableReference.get())) {
                maybeNotifyOnNewResult(closeableReference, i);
                return;
            }
            this.mListener.onProducerStart(this.mRequestId, PostprocessorProducer.NAME);
            try {
                try {
                    CloseableReference<CloseableImage> postprocessInternal = postprocessInternal(closeableReference.get());
                    ProducerListener producerListener = this.mListener;
                    String str = this.mRequestId;
                    producerListener.onProducerFinishWithSuccess(str, PostprocessorProducer.NAME, getExtraMap(producerListener, str, this.mPostprocessor));
                    maybeNotifyOnNewResult(postprocessInternal, i);
                    CloseableReference.closeSafely(postprocessInternal);
                } catch (Exception e) {
                    ProducerListener producerListener2 = this.mListener;
                    String str2 = this.mRequestId;
                    producerListener2.onProducerFinishWithFailure(str2, PostprocessorProducer.NAME, e, getExtraMap(producerListener2, str2, this.mPostprocessor));
                    maybeNotifyOnFailure(e);
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                }
            } catch (Throwable th) {
                CloseableReference.closeSafely((CloseableReference<?>) null);
                throw th;
            }
        }

        @Nullable
        private Map<String, String> getExtraMap(ProducerListener producerListener, String str, Postprocessor postprocessor) {
            if (producerListener.requiresExtraMap(str)) {
                return ImmutableMap.of(PostprocessorProducer.POSTPROCESSOR, postprocessor.getName());
            }
            return null;
        }

        private synchronized boolean isClosed() {
            return this.mIsClosed;
        }

        public void maybeNotifyOnCancellation() {
            if (close()) {
                getConsumer().onCancellation();
            }
        }

        private void maybeNotifyOnFailure(Throwable th) {
            if (close()) {
                getConsumer().onFailure(th);
            }
        }

        private void maybeNotifyOnNewResult(CloseableReference<CloseableImage> closeableReference, int i) {
            boolean isLast = BaseConsumer.isLast(i);
            if ((isLast || isClosed()) && !(isLast && close())) {
                return;
            }
            getConsumer().onNewResult(closeableReference, i);
        }

        private CloseableReference<CloseableImage> postprocessInternal(CloseableImage closeableImage) {
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
            CloseableReference<Bitmap> process = this.mPostprocessor.process(closeableStaticBitmap.getUnderlyingBitmap(), PostprocessorProducer.this.mBitmapFactory);
            try {
                return CloseableReference.of(new CloseableStaticBitmap(process, closeableImage.getQualityInfo(), closeableStaticBitmap.getRotationAngle(), closeableStaticBitmap.getExifOrientation()));
            } finally {
                CloseableReference.closeSafely(process);
            }
        }

        private synchronized boolean setRunningIfDirtyAndNotRunning() {
            if (this.mIsClosed || !this.mIsDirty || this.mIsPostProcessingRunning || !CloseableReference.isValid(this.mSourceImageRef)) {
                return false;
            }
            this.mIsPostProcessingRunning = true;
            return true;
        }

        private boolean shouldPostprocess(CloseableImage closeableImage) {
            return closeableImage instanceof CloseableStaticBitmap;
        }

        private void submitPostprocessing() {
            PostprocessorProducer.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.2
                {
                    PostprocessorConsumer.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    CloseableReference closeableReference;
                    int i;
                    synchronized (PostprocessorConsumer.this) {
                        closeableReference = PostprocessorConsumer.this.mSourceImageRef;
                        i = PostprocessorConsumer.this.mStatus;
                        PostprocessorConsumer.this.mSourceImageRef = null;
                        PostprocessorConsumer.this.mIsDirty = false;
                    }
                    if (CloseableReference.isValid(closeableReference)) {
                        try {
                            PostprocessorConsumer.this.doPostprocessing(closeableReference, i);
                        } finally {
                            CloseableReference.closeSafely(closeableReference);
                        }
                    }
                    PostprocessorConsumer.this.clearRunningAndStartIfDirty();
                }
            });
        }

        private void updateSourceImageRef(@Nullable CloseableReference<CloseableImage> closeableReference, int i) {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                CloseableReference<CloseableImage> closeableReference2 = this.mSourceImageRef;
                this.mSourceImageRef = CloseableReference.cloneOrNull(closeableReference);
                this.mStatus = i;
                this.mIsDirty = true;
                boolean runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
                CloseableReference.closeSafely(closeableReference2);
                if (runningIfDirtyAndNotRunning) {
                    submitPostprocessing();
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            maybeNotifyOnCancellation();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            maybeNotifyOnFailure(th);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            if (!CloseableReference.isValid(closeableReference)) {
                if (BaseConsumer.isLast(i)) {
                    maybeNotifyOnNewResult(null, i);
                    return;
                }
                return;
            }
            updateSourceImageRef(closeableReference, i);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class RepeatedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> implements RepeatedPostprocessorRunner {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean mIsClosed;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        private CloseableReference<CloseableImage> mSourceImageRef;

        public boolean close() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.mSourceImageRef;
                this.mSourceImageRef = null;
                this.mIsClosed = true;
                CloseableReference.closeSafely(closeableReference);
                return true;
            }
        }

        private void setSourceImageRef(CloseableReference<CloseableImage> closeableReference) {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                CloseableReference<CloseableImage> closeableReference2 = this.mSourceImageRef;
                this.mSourceImageRef = CloseableReference.cloneOrNull(closeableReference);
                CloseableReference.closeSafely(closeableReference2);
            }
        }

        private void updateInternal() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                CloseableReference<CloseableImage> cloneOrNull = CloseableReference.cloneOrNull(this.mSourceImageRef);
                try {
                    getConsumer().onNewResult(cloneOrNull, 0);
                } finally {
                    CloseableReference.closeSafely(cloneOrNull);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            if (close()) {
                getConsumer().onCancellation();
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            if (close()) {
                getConsumer().onFailure(th);
            }
        }

        @Override // com.facebook.imagepipeline.request.RepeatedPostprocessorRunner
        public synchronized void update() {
            updateInternal();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private RepeatedPostprocessorConsumer(PostprocessorConsumer postprocessorConsumer, RepeatedPostprocessor repeatedPostprocessor, ProducerContext producerContext) {
            super(postprocessorConsumer);
            PostprocessorProducer.this = r1;
            this.mIsClosed = false;
            this.mSourceImageRef = null;
            repeatedPostprocessor.setCallback(this);
            producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.RepeatedPostprocessorConsumer.1
                {
                    RepeatedPostprocessorConsumer.this = this;
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    if (RepeatedPostprocessorConsumer.this.close()) {
                        RepeatedPostprocessorConsumer.this.getConsumer().onCancellation();
                    }
                }
            });
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            if (BaseConsumer.isNotLast(i)) {
                return;
            }
            setSourceImageRef(closeableReference);
            updateInternal();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class SingleUsePostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private SingleUsePostprocessorConsumer(PostprocessorConsumer postprocessorConsumer) {
            super(postprocessorConsumer);
            PostprocessorProducer.this = r1;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            if (BaseConsumer.isNotLast(i)) {
                return;
            }
            getConsumer().onNewResult(closeableReference, i);
        }
    }

    public PostprocessorProducer(Producer<CloseableReference<CloseableImage>> producer, PlatformBitmapFactory platformBitmapFactory, Executor executor) {
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mBitmapFactory = platformBitmapFactory;
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        Consumer<CloseableReference<CloseableImage>> singleUsePostprocessorConsumer;
        ProducerListener listener = producerContext.getListener();
        Postprocessor postprocessor = producerContext.getImageRequest().getPostprocessor();
        PostprocessorConsumer postprocessorConsumer = new PostprocessorConsumer(consumer, listener, producerContext.getId(), postprocessor, producerContext);
        if (postprocessor instanceof RepeatedPostprocessor) {
            singleUsePostprocessorConsumer = new RepeatedPostprocessorConsumer(postprocessorConsumer, (RepeatedPostprocessor) postprocessor, producerContext);
        } else {
            singleUsePostprocessorConsumer = new SingleUsePostprocessorConsumer(postprocessorConsumer);
        }
        this.mInputProducer.produceResults(singleUsePostprocessorConsumer, producerContext);
    }
}
