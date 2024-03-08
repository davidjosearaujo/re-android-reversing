package v4;

import a6.x;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.activity.h;
import androidx.appcompat.widget.l;
import f5.g;
import i5.d;
import j5.a;
import k5.e;
import k5.i;
import q5.p;
import v4.k;
import w0.c;
@e(c = "com.rajat.pdfviewer.PdfViewAdapter$PdfPageViewHolder$bind$1$2$1", f = "PdfViewAdapter.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j extends i implements p<x, d<? super g>, Object> {

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ k.a f6304j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Bitmap f6305k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Bitmap f6306l;
    public final /* synthetic */ c m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k.a aVar, Bitmap bitmap, Bitmap bitmap2, c cVar, d<? super j> dVar) {
        super(2, dVar);
        this.f6304j = aVar;
        this.f6305k = bitmap;
        this.f6306l = bitmap2;
        this.m = cVar;
    }

    @Override // q5.p
    public final Object i(x xVar, d<? super g> dVar) {
        return ((j) p(xVar, dVar)).s(g.f4141a);
    }

    @Override // k5.a
    public final d<g> p(Object obj, d<?> dVar) {
        return new j(this.f6304j, this.f6305k, this.f6306l, this.m, dVar);
    }

    @Override // k5.a
    public final Object s(Object obj) {
        a aVar = a.f4591f;
        f5.e.b(obj);
        ((ImageView) this.f6304j.f6310u.f6340d).setScaleType(ImageView.ScaleType.FIT_CENTER);
        Bitmap bitmap = this.f6305k;
        if (bitmap != null) {
            StringBuilder d7 = h.d("renderedBitmap Width: ");
            d7.append(bitmap.getWidth());
            d7.append(", Bitmap Height: ");
            d7.append(bitmap.getHeight());
            new Integer(Log.d("PdfViewAdapter", d7.toString()));
        }
        Bitmap bitmap2 = this.f6306l;
        if (bitmap2 != null) {
            StringBuilder d8 = h.d("Bitmap Width: ");
            d8.append(bitmap2.getWidth());
            d8.append(", Bitmap Height: ");
            d8.append(bitmap2.getHeight());
            new Integer(Log.d("PdfViewAdapter", d8.toString()));
        }
        ImageView imageView = (ImageView) this.f6304j.f6310u.f6340d;
        Bitmap bitmap3 = this.f6305k;
        bitmap3 = this.f6306l;
        if (bitmap3 == null) {
        }
        imageView.setImageBitmap(bitmap3);
        k.a aVar2 = this.f6304j;
        ImageView imageView2 = (ImageView) this.m.f6340d;
        r5.h.e(imageView2, "pageView");
        aVar2.getClass();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setDuration(300);
        alphaAnimation.start();
        imageView2.setAnimation(alphaAnimation);
        ProgressBar progressBar = (ProgressBar) ((l) this.m.f6339c).f964g;
        r5.h.e(progressBar, "pdfViewPageLoadingProgress");
        progressBar.setVisibility(8);
        return g.f4141a;
    }
}
