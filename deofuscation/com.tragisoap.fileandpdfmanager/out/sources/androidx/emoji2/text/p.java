package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class p extends k {
    public p(i iVar) {
        super(iVar);
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i7, int i8, float f7, int i9, int i10, int i11, Paint paint) {
        f.a().getClass();
        i iVar = this.f1543g;
        Typeface typeface = iVar.f1532b.f1557d;
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        int i12 = iVar.f1531a * 2;
        canvas.drawText(iVar.f1532b.f1555b, i12, 2, f7, (float) i10, paint);
        paint.setTypeface(typeface2);
    }
}
