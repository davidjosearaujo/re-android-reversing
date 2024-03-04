package v4;

import a6.x;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import q5.p;

@k5.e(c = "com.rajat.pdfviewer.PdfRendererCore$writeBitmapToCache$1", f = "PdfRendererCore.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class f extends k5.i implements p {

    /* renamed from: j */
    public final /* synthetic */ d f6297j;

    /* renamed from: k */
    public final /* synthetic */ int f6298k;

    /* renamed from: l */
    public final /* synthetic */ Bitmap f6299l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i7, Bitmap bitmap, i5.d dVar2) {
        super(2, dVar2);
        this.f6297j = dVar;
        this.f6298k = i7;
        this.f6299l = bitmap;
    }

    public final Object i(Object obj, Object obj2) {
        return ((f) p((x) obj, (i5.d) obj2)).s(f5.g.f4141a);
    }

    public final i5.d p(Object obj, i5.d dVar) {
        return new f(this.f6297j, this.f6298k, this.f6299l, dVar);
    }

    public final Object s(Object obj) {
        Kotlin_1.a aVar = Kotlin_1.a.f4591f;
        f5.e.b(obj);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(new File(this.f6297j.f6274a.getCacheDir(), "___pdf___cache___"), String.valueOf(this.f6298k)));
            this.f6299l.compress(Bitmap.CompressFormat.JPEG, 75, fileOutputStream);
            q2.a.l(fileOutputStream, null);
        } catch (Exception e) {
            StringBuilder d7 = androidx.activity.h.d("Error writing bitmap to cache: ");
            d7.append(e.getMessage());
            Log.e("PdfRendererCore", d7.toString());
        }
        return f5.g.f4141a;
    }
}
