package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* loaded from: classes.dex */
public abstract class k extends ReplacementSpan {

    /* renamed from: g */
    public final i f1543g;

    /* renamed from: f */
    public final Paint.FontMetricsInt f1542f = new Paint.FontMetricsInt();

    /* renamed from: h */
    public float f1544h = 1.0f;

    public k(i iVar) {
        if (iVar == null) {
            throw new NullPointerException("metadata cannot be null");
        }
        this.f1543g = iVar;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i7, int i8, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f1542f);
        Paint.FontMetricsInt fontMetricsInt2 = this.f1542f;
        float abs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        y1.a c7 = this.f1543g.c();
        int a7 = c7.a(14);
        this.f1544h = abs / (a7 != 0 ? c7.f6593b.getShort(a7 + c7.f6592a) : (short) 0);
        y1.a c8 = this.f1543g.c();
        int a8 = c8.a(14);
        if (a8 != 0) {
            c8.f6593b.getShort(a8 + c8.f6592a);
        }
        y1.a c9 = this.f1543g.c();
        int a9 = c9.a(12);
        short s = (short) ((a9 != 0 ? c9.f6593b.getShort(a9 + c9.f6592a) : (short) 0) * this.f1544h);
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f1542f;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return s;
    }
}
