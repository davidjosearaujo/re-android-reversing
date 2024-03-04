package v4;

import a6.x;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import q5.p;
import v4.k;

@k5.e(c = "com.rajat.pdfviewer.PdfViewAdapter$PdfPageViewHolder$bind$1$2$1", f = "PdfViewAdapter.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class j extends k5.i implements p {

    /* renamed from: j */
    public final /* synthetic */ k.a f6304j;

    /* renamed from: k */
    public final /* synthetic */ Bitmap f6305k;

    /* renamed from: l */
    public final /* synthetic */ Bitmap f6306l;
    public final /* synthetic */ w0.c m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k.a aVar, Bitmap bitmap, Bitmap bitmap2, w0.c cVar, i5.d dVar) {
        super(2, dVar);
        this.f6304j = aVar;
        this.f6305k = bitmap;
        this.f6306l = bitmap2;
        this.m = cVar;
    }

    public final Object i(Object obj, Object obj2) {
        return ((j) p((x) obj, (i5.d) obj2)).s(f5.g.f4141a);
    }

    public final i5.d p(Object obj, i5.d dVar) {
        return new j(this.f6304j, this.f6305k, this.f6306l, this.m, dVar);
    }

    public final Object s(Object obj) {
        Kotlin_1.a aVar = Kotlin_1.a.f4591f;
        f5.e.b(obj);
        ((ImageView) this.f6304j.f6310u.f6340d).setScaleType(ImageView.ScaleType.FIT_CENTER);
        Bitmap bitmap = this.f6305k;
        if (bitmap != null) {
            StringBuilder d7 = androidx.activity.h.d("renderedBitmap Width: ");
            d7.append(bitmap.getWidth());
            d7.append(", Bitmap Height: ");
            d7.append(bitmap.getHeight());
            new Integer(Log.d("PdfViewAdapter", d7.toString()));
        }
        Bitmap bitmap2 = this.f6306l;
        if (bitmap2 != null) {
            StringBuilder d8 = androidx.activity.h.d("Bitmap Width: ");
            d8.append(bitmap2.getWidth());
            d8.append(", Bitmap Height: ");
            d8.append(bitmap2.getHeight());
            new Integer(Log.d("PdfViewAdapter", d8.toString()));
        }
        ImageView imageView = (ImageView) this.f6304j.f6310u.f6340d;
        Bitmap bitmap3 = this.f6305k;
        Bitmap bitmap4 = this.f6306l;
        if (bitmap3 == null) {
            bitmap3 = bitmap4;
        }
        imageView.setImageBitmap(bitmap3);
        k.a aVar2 = this.f6304j;
        ImageView imageView2 = (ImageView) this.m.f6340d;
        r5.h.e(imageView2, "pageView");
        aVar2.getClass();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setDuration(300L);
        alphaAnimation.start();
        imageView2.setAnimation(alphaAnimation);
        ProgressBar progressBar = (ProgressBar) ((androidx.appcompat.widget.l) this.m.f6339c).f964g;
        r5.h.e(progressBar, "pdfViewPageLoadingProgress");
        progressBar.setVisibility(8);
        return f5.g.f4141a;
    }
}
