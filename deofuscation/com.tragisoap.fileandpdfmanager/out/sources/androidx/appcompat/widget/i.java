package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import j1.a;
import t1.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final CompoundButton f916a;

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f917b = null;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuff.Mode f918c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f919d = false;
    public boolean e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f920f;

    public i(CompoundButton compoundButton) {
        this.f916a = compoundButton;
    }

    public final void a() {
        Drawable a7 = c.a(this.f916a);
        if (a7 == null) {
            return;
        }
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

    /* JADX WARN: Removed duplicated region for block: B:17:0x005b A[Catch: all -> 0x007e, TryCatch #1 {all -> 0x007e, blocks: (B:3:0x001d, B:5:0x0024, B:7:0x002a, B:10:0x003b, B:12:0x0041, B:14:0x0047, B:15:0x0054, B:17:0x005b, B:18:0x0064, B:20:0x006b), top: B:29:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b A[Catch: all -> 0x007e, TRY_LEAVE, TryCatch #1 {all -> 0x007e, blocks: (B:3:0x001d, B:5:0x0024, B:7:0x002a, B:10:0x003b, B:12:0x0041, B:14:0x0047, B:15:0x0054, B:17:0x005b, B:18:0x0064, B:20:0x006b), top: B:29:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
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
            boolean r10 = r0.l(r9)     // Catch: all -> 0x007e
            r1 = 0
            if (r10 == 0) goto L_0x0038
            int r10 = r0.i(r9, r1)     // Catch: all -> 0x007e
            if (r10 == 0) goto L_0x0038
            android.widget.CompoundButton r2 = r8.f916a     // Catch: NotFoundException -> 0x0038, all -> 0x007e
            android.content.Context r3 = r2.getContext()     // Catch: NotFoundException -> 0x0038, all -> 0x007e
            android.graphics.drawable.Drawable r10 = g.a.a(r3, r10)     // Catch: NotFoundException -> 0x0038, all -> 0x007e
            r2.setButtonDrawable(r10)     // Catch: NotFoundException -> 0x0038, all -> 0x007e
            goto L_0x0039
        L_0x0038:
            r9 = r1
        L_0x0039:
            if (r9 != 0) goto L_0x0054
            boolean r9 = r0.l(r1)     // Catch: all -> 0x007e
            if (r9 == 0) goto L_0x0054
            int r9 = r0.i(r1, r1)     // Catch: all -> 0x007e
            if (r9 == 0) goto L_0x0054
            android.widget.CompoundButton r10 = r8.f916a     // Catch: all -> 0x007e
            android.content.Context r1 = r10.getContext()     // Catch: all -> 0x007e
            android.graphics.drawable.Drawable r9 = g.a.a(r1, r9)     // Catch: all -> 0x007e
            r10.setButtonDrawable(r9)     // Catch: all -> 0x007e
        L_0x0054:
            r9 = 2
            boolean r10 = r0.l(r9)     // Catch: all -> 0x007e
            if (r10 == 0) goto L_0x0064
            android.widget.CompoundButton r10 = r8.f916a     // Catch: all -> 0x007e
            android.content.res.ColorStateList r9 = r0.b(r9)     // Catch: all -> 0x007e
            t1.b.c(r10, r9)     // Catch: all -> 0x007e
        L_0x0064:
            r9 = 3
            boolean r10 = r0.l(r9)     // Catch: all -> 0x007e
            if (r10 == 0) goto L_0x007a
            android.widget.CompoundButton r8 = r8.f916a     // Catch: all -> 0x007e
            r10 = -1
            int r9 = r0.h(r9, r10)     // Catch: all -> 0x007e
            r10 = 0
            android.graphics.PorterDuff$Mode r9 = androidx.appcompat.widget.h0.b(r9, r10)     // Catch: all -> 0x007e
            t1.b.d(r8, r9)     // Catch: all -> 0x007e
        L_0x007a:
            r0.n()
            return
        L_0x007e:
            r8 = move-exception
            r0.n()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i.b(android.util.AttributeSet, int):void");
    }
}
