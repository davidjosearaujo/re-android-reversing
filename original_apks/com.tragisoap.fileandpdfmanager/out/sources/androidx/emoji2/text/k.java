package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import y1.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class k extends ReplacementSpan {

    /* renamed from: g */
    public final i f1543g;

    /* renamed from: f */
    public final Paint.FontMetricsInt f1542f = new Paint.FontMetricsInt();

    /* renamed from: h */
    public float f1544h = 1.0f;

    public k(i iVar) {
        if (iVar != null) {
            this.f1543g = iVar;
            return;
        }
        throw new NullPointerException("metadata cannot be null");
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i7, int i8, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f1542f);
        Paint.FontMetricsInt fontMetricsInt2 = this.f1542f;
        float abs = ((float) Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent)) * 1.0f;
        a c7 = this.f1543g.c();
        int a7 = c7.a(14);
        short s = 0;
        this.f1544h = abs / ((float) (a7 != 0 ? c7.f6593b.getShort(a7 + c7.f6592a) : 0));
        a c8 = this.f1543g.c();
        int a8 = c8.a(14);
        if (a8 != 0) {
            c8.f6593b.getShort(a8 + c8.f6592a);
        }
        a c9 = this.f1543g.c();
        int a9 = c9.a(12);
        if (a9 != 0) {
            s = c9.f6593b.getShort(a9 + c9.f6592a);
        }
        short s6 = (short) ((int) (((float) s) * this.f1544h));
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f1542f;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return s6;
    }
}
