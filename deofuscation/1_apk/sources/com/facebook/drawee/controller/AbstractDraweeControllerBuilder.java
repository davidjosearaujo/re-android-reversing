package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements SimpleDraweeControllerBuilder {
    private boolean mAutoPlayAnimations;
    private final Set<ControllerListener> mBoundControllerListeners;
    @Nullable
    private Object mCallerContext;
    private String mContentDescription;
    private final Context mContext;
    @Nullable
    private ControllerListener<? super INFO> mControllerListener;
    @Nullable
    private ControllerViewportVisibilityListener mControllerViewportVisibilityListener;
    @Nullable
    private Supplier<DataSource<IMAGE>> mDataSourceSupplier;
    @Nullable
    private REQUEST mImageRequest;
    @Nullable
    private REQUEST mLowResImageRequest;
    @Nullable
    private REQUEST[] mMultiImageRequests;
    @Nullable
    private DraweeController mOldController;
    private boolean mRetainImageOnFailure;
    private boolean mTapToRetryEnabled;
    private boolean mTryCacheOnlyFirst;
    private static final ControllerListener<Object> sAutoPlayAnimationsListener = new BaseControllerListener<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final NullPointerException NO_REQUEST_EXCEPTION = new NullPointerException("No image request was specified!");
    private static final AtomicLong sIdCounter = new AtomicLong();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    public AbstractDraweeControllerBuilder(Context context, Set<ControllerListener> set) {
        this.mContext = context;
        this.mBoundControllerListeners = set;
        init();
    }

    public static String generateUniqueControllerId() {
        return String.valueOf(sIdCounter.getAndIncrement());
    }

    private void init() {
        this.mCallerContext = null;
        this.mImageRequest = null;
        this.mLowResImageRequest = null;
        this.mMultiImageRequests = null;
        this.mTryCacheOnlyFirst = true;
        this.mControllerListener = null;
        this.mControllerViewportVisibilityListener = null;
        this.mTapToRetryEnabled = false;
        this.mAutoPlayAnimations = false;
        this.mOldController = null;
        this.mContentDescription = null;
    }

    public AbstractDraweeController buildController() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeControllerBuilder#buildController");
        }
        AbstractDraweeController obtainController = obtainController();
        obtainController.setRetainImageOnFailure(getRetainImageOnFailure());
        obtainController.setContentDescription(getContentDescription());
        obtainController.setControllerViewportVisibilityListener(getControllerViewportVisibilityListener());
        maybeBuildAndSetRetryManager(obtainController);
        maybeAttachListeners(obtainController);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return obtainController;
    }

    public boolean getAutoPlayAnimations() {
        return this.mAutoPlayAnimations;
    }

    @Nullable
    public Object getCallerContext() {
        return this.mCallerContext;
    }

    @Nullable
    public String getContentDescription() {
        return this.mContentDescription;
    }

    public Context getContext() {
        return this.mContext;
    }

    @Nullable
    public ControllerListener<? super INFO> getControllerListener() {
        return this.mControllerListener;
    }

    @Nullable
    public ControllerViewportVisibilityListener getControllerViewportVisibilityListener() {
        return this.mControllerViewportVisibilityListener;
    }

    public abstract DataSource<IMAGE> getDataSourceForRequest(DraweeController draweeController, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @Nullable
    public Supplier<DataSource<IMAGE>> getDataSourceSupplier() {
        return this.mDataSourceSupplier;
    }

    public Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(DraweeController draweeController, String str, REQUEST request) {
        return getDataSourceSupplierForRequest(draweeController, str, request, CacheLevel.FULL_FETCH);
    }

    public Supplier<DataSource<IMAGE>> getFirstAvailableDataSourceSupplier(DraweeController draweeController, String str, REQUEST[] requestArr, boolean z) {
        ArrayList arrayList = new ArrayList(requestArr.length * 2);
        if (z) {
            for (REQUEST request : requestArr) {
                arrayList.add(getDataSourceSupplierForRequest(draweeController, str, request, CacheLevel.BITMAP_MEMORY_CACHE));
            }
        }
        for (REQUEST request2 : requestArr) {
            arrayList.add(getDataSourceSupplierForRequest(draweeController, str, request2));
        }
        return FirstAvailableDataSourceSupplier.create(arrayList);
    }

    @Nullable
    public REQUEST[] getFirstAvailableImageRequests() {
        return this.mMultiImageRequests;
    }

    @Nullable
    public REQUEST getImageRequest() {
        return this.mImageRequest;
    }

    @Nullable
    public REQUEST getLowResImageRequest() {
        return this.mLowResImageRequest;
    }

    @Nullable
    public DraweeController getOldController() {
        return this.mOldController;
    }

    public boolean getRetainImageOnFailure() {
        return this.mRetainImageOnFailure;
    }

    public boolean getTapToRetryEnabled() {
        return this.mTapToRetryEnabled;
    }

    public final BUILDER getThis() {
        return this;
    }

    public void maybeAttachListeners(AbstractDraweeController abstractDraweeController) {
        Set<ControllerListener> set = this.mBoundControllerListeners;
        if (set != null) {
            for (ControllerListener controllerListener : set) {
                abstractDraweeController.addControllerListener(controllerListener);
            }
        }
        ControllerListener<? super INFO> controllerListener2 = this.mControllerListener;
        if (controllerListener2 != null) {
            abstractDraweeController.addControllerListener(controllerListener2);
        }
        if (this.mAutoPlayAnimations) {
            abstractDraweeController.addControllerListener(sAutoPlayAnimationsListener);
        }
    }

    public void maybeBuildAndSetGestureDetector(AbstractDraweeController abstractDraweeController) {
        if (abstractDraweeController.getGestureDetector() == null) {
            abstractDraweeController.setGestureDetector(GestureDetector.newInstance(this.mContext));
        }
    }

    public void maybeBuildAndSetRetryManager(AbstractDraweeController abstractDraweeController) {
        if (this.mTapToRetryEnabled) {
            abstractDraweeController.getRetryManager().setTapToRetryEnabled(this.mTapToRetryEnabled);
            maybeBuildAndSetGestureDetector(abstractDraweeController);
        }
    }

    @ReturnsOwnership
    public abstract AbstractDraweeController obtainController();

    public Supplier<DataSource<IMAGE>> obtainDataSourceSupplier(DraweeController draweeController, String str) {
        Supplier<DataSource<IMAGE>> supplier = this.mDataSourceSupplier;
        if (supplier != null) {
            return supplier;
        }
        Supplier<DataSource<IMAGE>> supplier2 = null;
        REQUEST request = this.mImageRequest;
        if (request != null) {
            supplier2 = getDataSourceSupplierForRequest(draweeController, str, request);
        } else {
            REQUEST[] requestArr = this.mMultiImageRequests;
            if (requestArr != null) {
                supplier2 = getFirstAvailableDataSourceSupplier(draweeController, str, requestArr, this.mTryCacheOnlyFirst);
            }
        }
        if (supplier2 != null && this.mLowResImageRequest != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(supplier2);
            arrayList.add(getDataSourceSupplierForRequest(draweeController, str, this.mLowResImageRequest));
            supplier2 = IncreasingQualityDataSourceSupplier.create(arrayList, false);
        }
        return supplier2 == null ? DataSources.getFailedDataSourceSupplier(NO_REQUEST_EXCEPTION) : supplier2;
    }

    public BUILDER reset() {
        init();
        return getThis();
    }

    public BUILDER setAutoPlayAnimations(boolean z) {
        this.mAutoPlayAnimations = z;
        return getThis();
    }

    public BUILDER setContentDescription(String str) {
        this.mContentDescription = str;
        return getThis();
    }

    public BUILDER setControllerListener(@Nullable ControllerListener<? super INFO> controllerListener) {
        this.mControllerListener = controllerListener;
        return getThis();
    }

    public BUILDER setControllerViewportVisibilityListener(@Nullable ControllerViewportVisibilityListener controllerViewportVisibilityListener) {
        this.mControllerViewportVisibilityListener = controllerViewportVisibilityListener;
        return getThis();
    }

    public BUILDER setDataSourceSupplier(@Nullable Supplier<DataSource<IMAGE>> supplier) {
        this.mDataSourceSupplier = supplier;
        return getThis();
    }

    public BUILDER setFirstAvailableImageRequests(REQUEST[] requestArr) {
        return setFirstAvailableImageRequests(requestArr, true);
    }

    public BUILDER setImageRequest(REQUEST request) {
        this.mImageRequest = request;
        return getThis();
    }

    public BUILDER setLowResImageRequest(REQUEST request) {
        this.mLowResImageRequest = request;
        return getThis();
    }

    public BUILDER setRetainImageOnFailure(boolean z) {
        this.mRetainImageOnFailure = z;
        return getThis();
    }

    public BUILDER setTapToRetryEnabled(boolean z) {
        this.mTapToRetryEnabled = z;
        return getThis();
    }

    public void validate() {
        boolean z = false;
        Preconditions.checkState(this.mMultiImageRequests == null || this.mImageRequest == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.mDataSourceSupplier == null || (this.mMultiImageRequests == null && this.mImageRequest == null && this.mLowResImageRequest == null)) {
            z = true;
        }
        Preconditions.checkState(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public AbstractDraweeController build() {
        REQUEST request;
        validate();
        if (this.mImageRequest == null && this.mMultiImageRequests == null && (request = this.mLowResImageRequest) != null) {
            this.mImageRequest = request;
            this.mLowResImageRequest = null;
        }
        return buildController();
    }

    public Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(final DraweeController draweeController, final String str, final REQUEST request, final CacheLevel cacheLevel) {
        final Object callerContext = getCallerContext();
        return new Supplier<DataSource<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            public String toString() {
                return Objects.toStringHelper(this).add("request", request.toString()).toString();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.getDataSourceForRequest(draweeController, str, request, callerContext, cacheLevel);
            }
        };
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public BUILDER setCallerContext(Object obj) {
        this.mCallerContext = obj;
        return getThis();
    }

    public BUILDER setFirstAvailableImageRequests(REQUEST[] requestArr, boolean z) {
        Preconditions.checkArgument(requestArr == null || requestArr.length > 0, "No requests specified!");
        this.mMultiImageRequests = requestArr;
        this.mTryCacheOnlyFirst = z;
        return getThis();
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public BUILDER setOldController(@Nullable DraweeController draweeController) {
        this.mOldController = draweeController;
        return getThis();
    }
}
