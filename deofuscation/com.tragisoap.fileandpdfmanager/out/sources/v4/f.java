package v4;

import a6.x;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.activity.h;
import f5.g;
import i5.d;
import j5.a;
import java.io.File;
import java.io.FileOutputStream;
import k5.e;
import k5.i;
import q5.p;
@e(c = "com.rajat.pdfviewer.PdfRendererCore$writeBitmapToCache$1", f = "PdfRendererCore.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f extends i implements p<x, d<? super g>, Object> {

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ d f6297j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f6298k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Bitmap f6299l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i7, Bitmap bitmap, d<? super f> dVar2) {
        super(2, dVar2);
        this.f6297j = dVar;
        this.f6298k = i7;
        this.f6299l = bitmap;
    }

    @Override // q5.p
    public final Object i(x xVar, d<? super g> dVar) {
        return ((f) p(xVar, dVar)).s(g.f4141a);
    }

    @Override // k5.a
    public final d<g> p(Object obj, d<?> dVar) {
        return new f(this.f6297j, this.f6298k, this.f6299l, dVar);
    }

    @Override // k5.a
    public final Object s(Object obj) {
        a aVar = a.f4591f;
        f5.e.b(obj);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(new File(this.f6297j.f6274a.getCacheDir(), "___pdf___cache___"), String.valueOf(this.f6298k)));
            this.f6299l.compress(Bitmap.CompressFormat.JPEG, 75, fileOutputStream);
            q2.a.l(fileOutputStream, null);
        } catch (Exception e) {
            StringBuilder d7 = h.d("Error writing bitmap to cache: ");
            d7.append(e.getMessage());
            Log.e("PdfRendererCore", d7.toString());
        }
        return g.f4141a;
    }
}
