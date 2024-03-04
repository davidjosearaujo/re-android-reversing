package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import j1.a;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a */
    public final CompoundButton f916a;

    /* renamed from: b */
    public ColorStateList f917b = null;

    /* renamed from: c */
    public PorterDuff.Mode f918c = null;

    /* renamed from: d */
    public boolean f919d = false;
    public boolean e = false;

    /* renamed from: f */
    public boolean f920f;

    public i(CompoundButton compoundButton) {
        this.f916a = compoundButton;
    }

    public final void a() {
        Drawable a7 = t1.c.a(this.f916a);
        if (a7 != null) {
            if (this.f919d || this.e) {
                Drawable mutate = a7.mutate();
                if (this.f919d) {
                    a.b.h(mutate, this.f917b);
                }
                if (this.e) {
                    a.b.i(mutate, this.f918c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f916a.getDrawableState());
                }
                this.f916a.setButtonDrawable(mutate);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x005b A[Catch: all -> 0x007e, TryCatch #1 {all -> 0x007e, blocks: (B:99:0x001d, B:101:0x0024, B:103:0x002a, B:107:0x003b, B:109:0x0041, B:111:0x0047, B:112:0x0054, B:114:0x005b, B:115:0x0064, B:117:0x006b), top: B:126:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x006b A[Catch: all -> 0x007e, TRY_LEAVE, TryCatch #1 {all -> 0x007e, blocks: (B:99:0x001d, B:101:0x0024, B:103:0x002a, B:107:0x003b, B:109:0x0041, B:111:0x0047, B:112:0x0054, B:114:0x005b, B:115:0x0064, B:117:0x006b), top: B:126:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(android.util.AttributeSet r9, int r10) {
        /*
            r8 = this;
            android.widget.CompoundButton r0 = r8.f916a
            android.content.Context r0 = r0.getContext()
            int[] r3 = a0.e.I
            androidx.appcompat.widget.a1 r0 = androidx.appcompat.widget.a1.m(r0, r9, r3, r10)
            android.widget.CompoundButton r1 = r8.f916a
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r0.f831b
            java.util.WeakHashMap<android.view.View, p1.k0> r4 = p1.y.f5540a
            r7 = 0
            r4 = r9
            r6 = r10
            p1.y.m.d(r1, r2, r3, r4, r5, r6, r7)
            r9 = 1
            boolean r10 = r0.l(r9)     // Catch: java.lang.Throwable -> L7e
            r1 = 0
            if (r10 == 0) goto L38
            int r10 = r0.i(r9, r1)     // Catch: java.lang.Throwable -> L7e
            if (r10 == 0) goto L38
            android.widget.CompoundButton r2 = r8.f916a     // Catch: android.content.res.Resources.NotFoundException -> L38 java.lang.Throwable -> L7e
            android.content.Context r3 = r2.getContext()     // Catch: android.content.res.Resources.NotFoundException -> L38 java.lang.Throwable -> L7e
            android.graphics.drawable.Drawable r10 = g.a.a(r3, r10)     // Catch: android.content.res.Resources.NotFoundException -> L38 java.lang.Throwable -> L7e
            r2.setButtonDrawable(r10)     // Catch: android.content.res.Resources.NotFoundException -> L38 java.lang.Throwable -> L7e
            goto L39
        L38:
            r9 = r1
        L39:
            if (r9 != 0) goto L54
            boolean r9 = r0.l(r1)     // Catch: java.lang.Throwable -> L7e
            if (r9 == 0) goto L54
            int r9 = r0.i(r1, r1)     // Catch: java.lang.Throwable -> L7e
            if (r9 == 0) goto L54
            android.widget.CompoundButton r10 = r8.f916a     // Catch: java.lang.Throwable -> L7e
            android.content.Context r1 = r10.getContext()     // Catch: java.lang.Throwable -> L7e
            android.graphics.drawable.Drawable r9 = g.a.a(r1, r9)     // Catch: java.lang.Throwable -> L7e
            r10.setButtonDrawable(r9)     // Catch: java.lang.Throwable -> L7e
        L54:
            r9 = 2
            boolean r10 = r0.l(r9)     // Catch: java.lang.Throwable -> L7e
            if (r10 == 0) goto L64
            android.widget.CompoundButton r10 = r8.f916a     // Catch: java.lang.Throwable -> L7e
            android.content.res.ColorStateList r9 = r0.b(r9)     // Catch: java.lang.Throwable -> L7e
            t1.b.c(r10, r9)     // Catch: java.lang.Throwable -> L7e
        L64:
            r9 = 3
            boolean r10 = r0.l(r9)     // Catch: java.lang.Throwable -> L7e
            if (r10 == 0) goto L7a
            android.widget.CompoundButton r8 = r8.f916a     // Catch: java.lang.Throwable -> L7e
            r10 = -1
            int r9 = r0.h(r9, r10)     // Catch: java.lang.Throwable -> L7e
            r10 = 0
            android.graphics.PorterDuff$Mode r9 = androidx.appcompat.widget.h0.b(r9, r10)     // Catch: java.lang.Throwable -> L7e
            t1.b.d(r8, r9)     // Catch: java.lang.Throwable -> L7e
        L7a:
            r0.n()
            return
        L7e:
            r8 = move-exception
            r0.n()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i.b(android.util.AttributeSet, int):void");
    }
}
