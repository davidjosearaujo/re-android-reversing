package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class o extends SpannableStringBuilder {

    /* renamed from: f */
    public final Class<?> f1560f;

    /* renamed from: g */
    public final ArrayList f1561g = new ArrayList();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a implements TextWatcher, SpanWatcher {

        /* renamed from: f */
        public final Object f1562f;

        /* renamed from: g */
        public final AtomicInteger f1563g = new AtomicInteger(0);

        public a(Object obj) {
            this.f1562f = obj;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f1562f).afterTextChanged(editable);
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            ((TextWatcher) this.f1562f).beforeTextChanged(charSequence, i7, i8, i9);
        }

        @Override // android.text.SpanWatcher
        public final void onSpanAdded(Spannable spannable, Object obj, int i7, int i8) {
            if (this.f1563g.get() <= 0 || !(obj instanceof k)) {
                ((SpanWatcher) this.f1562f).onSpanAdded(spannable, obj, i7, i8);
            }
        }

        @Override // android.text.SpanWatcher
        public final void onSpanChanged(Spannable spannable, Object obj, int i7, int i8, int i9, int i10) {
            if (this.f1563g.get() <= 0 || !(obj instanceof k)) {
                ((SpanWatcher) this.f1562f).onSpanChanged(spannable, obj, i7, i8, i9, i10);
            }
        }

        @Override // android.text.SpanWatcher
        public final void onSpanRemoved(Spannable spannable, Object obj, int i7, int i8) {
            if (this.f1563g.get() <= 0 || !(obj instanceof k)) {
                ((SpanWatcher) this.f1562f).onSpanRemoved(spannable, obj, i7, i8);
            }
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            ((TextWatcher) this.f1562f).onTextChanged(charSequence, i7, i8, i9);
        }
    }

    public o(Class<?> cls, CharSequence charSequence) {
        super(charSequence);
        if (cls != null) {
            this.f1560f = cls;
            return;
        }
        throw new NullPointerException("watcherClass cannot be null");
    }

    public final void a() {
        for (int i7 = 0; i7 < this.f1561g.size(); i7++) {
            ((a) this.f1561g.get(i7)).f1563g.incrementAndGet();
        }
    }

    @Override // android.text.SpannableStringBuilder, java.lang.Appendable, android.text.Editable
    public final Editable append(char c7) {
        super.append(c7);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, java.lang.Appendable, android.text.Editable
    /* renamed from: append */
    public final SpannableStringBuilder mo0append(char c7) {
        super.append(c7);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, java.lang.Appendable, android.text.Editable
    /* renamed from: append */
    public final SpannableStringBuilder mo1append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, java.lang.Appendable, android.text.Editable
    /* renamed from: append */
    public final SpannableStringBuilder mo2append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i7, int i8) {
        super.append(charSequence, i7, i8);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder append(CharSequence charSequence, Object obj, int i7) {
        super.append(charSequence, obj, i7);
        return this;
    }

    public final void b() {
        e();
        for (int i7 = 0; i7 < this.f1561g.size(); i7++) {
            ((a) this.f1561g.get(i7)).onTextChanged(this, 0, length(), length());
        }
    }

    public final a c(Object obj) {
        for (int i7 = 0; i7 < this.f1561g.size(); i7++) {
            a aVar = (a) this.f1561g.get(i7);
            if (aVar.f1562f == obj) {
                return aVar;
            }
        }
        return null;
    }

    public final boolean d(Object obj) {
        if (obj != null) {
            if (this.f1560f == obj.getClass()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final Editable delete(int i7, int i8) {
        super.delete(i7, i8);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    /* renamed from: delete */
    public final SpannableStringBuilder mo6delete(int i7, int i8) {
        super.delete(i7, i8);
        return this;
    }

    public final void e() {
        for (int i7 = 0; i7 < this.f1561g.size(); i7++) {
            ((a) this.f1561g.get(i7)).f1563g.decrementAndGet();
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanEnd(Object obj) {
        a c7;
        if (d(obj) && (c7 = c(obj)) != null) {
            obj = c7;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanFlags(Object obj) {
        a c7;
        if (d(obj) && (c7 = c(obj)) != null) {
            obj = c7;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanStart(Object obj) {
        a c7;
        if (d(obj) && (c7 = c(obj)) != null) {
            obj = c7;
        }
        return super.getSpanStart(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    @SuppressLint({"UnknownNullness"})
    public final <T> T[] getSpans(int i7, int i8, Class<T> cls) {
        if (!(this.f1560f == cls)) {
            return (T[]) super.getSpans(i7, i8, cls);
        }
        a[] aVarArr = (a[]) super.getSpans(i7, i8, a.class);
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, aVarArr.length));
        for (int i9 = 0; i9 < aVarArr.length; i9++) {
            tArr[i9] = aVarArr[i9].f1562f;
        }
        return tArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final Editable insert(int i7, CharSequence charSequence) {
        super.insert(i7, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    /* renamed from: insert */
    public final SpannableStringBuilder mo7insert(int i7, CharSequence charSequence) {
        super.insert(i7, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    /* renamed from: insert */
    public final SpannableStringBuilder mo8insert(int i7, CharSequence charSequence, int i8, int i9) {
        super.insert(i7, charSequence, i8, i9);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0009, code lost:
        if ((r1.f1560f == r4) != false) goto L_0x000b;
     */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int nextSpanTransition(int r2, int r3, java.lang.Class r4) {
        /*
            r1 = this;
            if (r4 == 0) goto L_0x000b
            java.lang.Class<?> r0 = r1.f1560f
            if (r0 != r4) goto L_0x0008
            r0 = 1
            goto L_0x0009
        L_0x0008:
            r0 = 0
        L_0x0009:
            if (r0 == 0) goto L_0x000d
        L_0x000b:
            java.lang.Class<androidx.emoji2.text.o$a> r4 = androidx.emoji2.text.o.a.class
        L_0x000d:
            int r1 = super.nextSpanTransition(r2, r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.o.nextSpanTransition(int, int, java.lang.Class):int");
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void removeSpan(Object obj) {
        a aVar;
        if (d(obj)) {
            aVar = c(obj);
            if (aVar != null) {
                obj = aVar;
            }
        } else {
            aVar = null;
        }
        super.removeSpan(obj);
        if (aVar != null) {
            this.f1561g.remove(aVar);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder replace(int i7, int i8, CharSequence charSequence) {
        a();
        super.replace(i7, i8, charSequence);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder replace(int i7, int i8, CharSequence charSequence, int i9, int i10) {
        a();
        super.replace(i7, i8, charSequence, i9, i10);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i7, int i8, int i9) {
        if (d(obj)) {
            a aVar = new a(obj);
            this.f1561g.add(aVar);
            obj = aVar;
        }
        super.setSpan(obj, i7, i8, i9);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    @SuppressLint({"UnknownNullness"})
    public final CharSequence subSequence(int i7, int i8) {
        return new o(this.f1560f, this, i7, i8);
    }

    public o(Class<?> cls, CharSequence charSequence, int i7, int i8) {
        super(charSequence, i7, i8);
        if (cls != null) {
            this.f1560f = cls;
            return;
        }
        throw new NullPointerException("watcherClass cannot be null");
    }

    @Override // android.text.SpannableStringBuilder, java.lang.Appendable, android.text.Editable
    public final Editable append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final Editable insert(int i7, CharSequence charSequence, int i8, int i9) {
        super.insert(i7, charSequence, i8, i9);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, java.lang.Appendable, android.text.Editable
    public final Editable append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i7, int i8) {
        super.append(charSequence, i7, i8);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, java.lang.Appendable, android.text.Editable
    /* renamed from: append */
    public final Appendable mo3append(char c7) {
        super.append(c7);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, java.lang.Appendable, android.text.Editable
    /* renamed from: append */
    public final Appendable mo4append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, java.lang.Appendable, android.text.Editable
    /* renamed from: append */
    public final Appendable mo5append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i7, int i8) {
        super.append(charSequence, i7, i8);
        return this;
    }
}
