package com.hunantv.imgo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.hunantv.imgo.nightmode.view.SkinableSimpleDraweeView;
import j.l.a.a0.b;
import j.l.a.c0.g;
import java.lang.ref.WeakReference;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgFrescoImageView extends SkinableSimpleDraweeView {
    private final j.l.a.t.a a;
    @ColorRes
    public int b;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class b extends BaseControllerListener<ImageInfo> {
        private final WeakReference<SimpleDraweeView> a;
        private final g b;
        private final Uri c;

        public void a(@Nullable ImageInfo imageInfo) {
            SimpleDraweeView simpleDraweeView = this.a.get();
            if (simpleDraweeView == null || imageInfo == null) {
                return;
            }
            if (simpleDraweeView.getLayoutParams().width == -2 && simpleDraweeView.getLayoutParams().height == -2) {
                simpleDraweeView.getLayoutParams().width = imageInfo.getWidth() + simpleDraweeView.getPaddingLeft() + simpleDraweeView.getPaddingRight();
                simpleDraweeView.getLayoutParams().height = imageInfo.getHeight() + simpleDraweeView.getPaddingTop() + simpleDraweeView.getPaddingBottom();
                simpleDraweeView.setLayoutParams(simpleDraweeView.getLayoutParams());
            } else if (simpleDraweeView.getAspectRatio() == 0.0f) {
                if (simpleDraweeView.getLayoutParams().width == -2 || simpleDraweeView.getLayoutParams().height == -2) {
                    simpleDraweeView.setAspectRatio((imageInfo.getWidth() * 1.0f) / imageInfo.getHeight());
                }
            }
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFailure(String str, Throwable th) {
            super.onFailure(str, th);
            g gVar = this.b;
            if (gVar != null) {
                gVar.onError();
            }
        }

        private b(SimpleDraweeView simpleDraweeView, g gVar, Uri uri) {
            this.a = new WeakReference<>(simpleDraweeView);
            this.b = gVar;
            this.c = uri;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
            super.onFinalImageSet(str, (String) imageInfo, animatable);
            a(imageInfo);
            g gVar = this.b;
            if (gVar == null) {
                return;
            }
            gVar.onSuccess();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class c implements g {
        private final WeakReference<MgFrescoImageView> a;
        private final int b;

        public void onError() {
            MgFrescoImageView mgFrescoImageView = this.a.get();
            int i = this.b;
            if (i <= 0 || mgFrescoImageView == null) {
                return;
            }
            mgFrescoImageView.setOriginalImageResource(i);
        }

        public void onSuccess() {
        }

        private c(MgFrescoImageView mgFrescoImageView, @DrawableRes int i) {
            this.a = new WeakReference<>(mgFrescoImageView);
            this.b = i;
        }
    }

    public MgFrescoImageView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
        this.a = new j.l.a.t.a();
        b(context, null, 0);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        int[] iArr = b.r.SkinnableView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        this.a.d(obtainStyledAttributes, iArr);
        obtainStyledAttributes.recycle();
        int[] iArr2 = b.r.SkinnableImageView;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i, 0);
        this.a.d(obtainStyledAttributes2, iArr2);
        obtainStyledAttributes2.recycle();
        int a2 = this.a.a(iArr2[b.r.SkinnableImageView_android_src]);
        c(this, a2, null, new c(a2));
    }

    private void c(MgFrescoImageView mgFrescoImageView, int i, Object obj, c cVar) {
        Context context = mgFrescoImageView.getContext();
        g(context, mgFrescoImageView, Uri.parse("res:///" + i), cVar);
    }

    private static void g(Context context, SimpleDraweeView simpleDraweeView, Uri uri, g gVar) {
        GenericDraweeHierarchyBuilder newInstance = GenericDraweeHierarchyBuilder.newInstance(context.getResources());
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(uri);
        PipelineDraweeControllerBuilder oldController = Fresco.newDraweeControllerBuilder().setOldController(simpleDraweeView.getController());
        try {
            ScalingUtils.ScaleType scaleType = ScalingUtils.ScaleType.CENTER_CROP;
            newInstance.setActualImageScaleType(scaleType);
            newInstance.setPlaceholderImageScaleType(scaleType);
            newInstance.setFailureImageScaleType(scaleType);
            oldController.setAutoPlayAnimations(true);
            newBuilderWithSource.setRequestPriority(Priority.HIGH);
            oldController.setControllerListener(new b(simpleDraweeView, gVar, uri));
            oldController.setImageRequest(newBuilderWithSource.build());
            simpleDraweeView.setHierarchy(newInstance.build());
            simpleDraweeView.setController(oldController.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOriginalImageResource(@DrawableRes int i) {
        if (i > 0) {
            super.setImageResource(i);
        }
        addAttributeResource(b.r.SkinnableImageView[b.r.SkinnableImageView_android_src], i);
    }

    @Override // com.hunantv.imgo.nightmode.view.SkinableSimpleDraweeView
    public void addAttributeResource(int i, int i2) {
        this.a.c(i, i2);
        super.addAttributeResource(i, i2);
    }

    @Override // com.hunantv.imgo.nightmode.view.SkinableSimpleDraweeView
    public void applyDayNight() {
        Context context = getContext();
        int a2 = this.a.a(b.r.SkinnableView[b.r.SkinnableView_android_background]);
        if (a2 > 0) {
            Drawable drawable = ContextCompat.getDrawable(context, a2);
            if (Build.VERSION.SDK_INT < 16) {
                setBackgroundDrawable(drawable);
            } else {
                setBackground(drawable);
            }
        }
        int a3 = this.a.a(b.r.SkinnableImageView[b.r.SkinnableImageView_android_src]);
        if (a3 > 0) {
            setImageResource(a3);
        }
        if (getHierarchy() != null && getHierarchy().getRoundingParams() != null && this.b != 0) {
            RoundingParams roundingParams = getHierarchy().getRoundingParams();
            roundingParams.setOverlayColor(getResources().getColor(this.b));
            getHierarchy().setRoundingParams(roundingParams);
        }
        super.applyDayNight();
    }

    @Override // com.facebook.drawee.view.SimpleDraweeView, com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageResource(@DrawableRes int i) {
        if (i > 0) {
            c(this, i, null, new c(i));
        }
        addAttributeResource(b.r.SkinnableImageView[b.r.SkinnableImageView_android_src], i);
    }

    public void setOverlayColor(@ColorRes int i) {
        this.b = i;
    }

    public MgFrescoImageView(Context context) {
        super(context);
        this.a = new j.l.a.t.a();
        b(context, null, 0);
    }

    public MgFrescoImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new j.l.a.t.a();
        b(context, attributeSet, 0);
    }

    public MgFrescoImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new j.l.a.t.a();
        b(context, attributeSet, i);
    }

    public MgFrescoImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = new j.l.a.t.a();
        b(context, attributeSet, i);
    }
}
