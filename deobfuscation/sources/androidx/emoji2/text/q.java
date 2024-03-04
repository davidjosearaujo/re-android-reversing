package androidx.emoji2.text;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* loaded from: classes.dex */
public final class q implements Spannable {

    /* renamed from: f */
    public boolean f1564f = false;

    /* renamed from: g */
    public Spannable f1565g;

    public q(Spannable spannable) {
        this.f1565g = spannable;
    }

    public q(CharSequence charSequence) {
        this.f1565g = new SpannableString(charSequence);
    }

    public final void a() {
        Spannable spannable = this.f1565g;
        if (!this.f1564f) {
            if ((spannable instanceof PrecomputedText) || (spannable instanceof n1.c)) {
                this.f1565g = new SpannableString(spannable);
            }
        }
        this.f1564f = true;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i7) {
        return this.f1565g.charAt(i7);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.f1565g.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.f1565g.codePoints();
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f1565g.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f1565g.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f1565g.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final <T> T[] getSpans(int i7, int i8, Class<T> cls) {
        return (T[]) this.f1565g.getSpans(i7, i8, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f1565g.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i7, int i8, Class cls) {
        return this.f1565g.nextSpanTransition(i7, i8, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        a();
        this.f1565g.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i7, int i8, int i9) {
        a();
        this.f1565g.setSpan(obj, i7, i8, i9);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i7, int i8) {
        return this.f1565g.subSequence(i7, i8);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f1565g.toString();
    }
}
