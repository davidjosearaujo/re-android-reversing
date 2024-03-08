package g4;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.activity.result.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e extends c {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f4263f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextPaint f4264g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ c f4265h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ d f4266i;

    public e(d dVar, Context context, TextPaint textPaint, c cVar) {
        this.f4266i = dVar;
        this.f4263f = context;
        this.f4264g = textPaint;
        this.f4265h = cVar;
    }

    @Override // androidx.activity.result.c
    public final void l(int i7) {
        this.f4265h.l(i7);
    }

    @Override // androidx.activity.result.c
    public final void m(Typeface typeface, boolean z6) {
        this.f4266i.g(this.f4263f, this.f4264g, typeface);
        this.f4265h.m(typeface, z6);
    }
}
