package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class y extends RecyclerView.n {

    /* renamed from: a */
    public RecyclerView f2280a;

    /* renamed from: b */
    public final a f2281b = new a();

    /* loaded from: classes.dex */
    public class a extends RecyclerView.p {

        /* renamed from: a */
        public boolean f2282a = false;

        public a() {
            y.this = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public final void a(RecyclerView recyclerView, int i7) {
            if (i7 == 0 && this.f2282a) {
                this.f2282a = false;
                y.this.b();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public final void b(RecyclerView recyclerView, int i7, int i8) {
            if (i7 == 0 && i8 == 0) {
                return;
            }
            this.f2282a = true;
        }
    }

    public abstract int[] a(RecyclerView.l lVar, View view);

    /* JADX WARN: Removed duplicated region for block: B:129:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b() {
        /*
            r11 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r11.f2280a
            if (r0 != 0) goto L5
            return
        L5:
            androidx.recyclerview.widget.RecyclerView$l r0 = r0.getLayoutManager()
            if (r0 != 0) goto Lc
            return
        Lc:
            r1 = r11
            androidx.recyclerview.widget.s r1 = (androidx.recyclerview.widget.s) r1
            boolean r2 = r0.f()
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L1c
            androidx.recyclerview.widget.q r1 = r1.e(r0)
            goto L26
        L1c:
            boolean r2 = r0.e()
            if (r2 == 0) goto L59
            androidx.recyclerview.widget.q r1 = r1.d(r0)
        L26:
            int r2 = r0.w()
            if (r2 != 0) goto L2d
            goto L59
        L2d:
            int r5 = r1.k()
            int r6 = r1.l()
            int r6 = r6 / 2
            int r6 = r6 + r5
            r5 = 2147483647(0x7fffffff, float:NaN)
            r7 = r4
        L3c:
            if (r7 >= r2) goto L59
            android.view.View r8 = r0.v(r7)
            int r9 = r1.e(r8)
            int r10 = r1.c(r8)
            int r10 = r10 / 2
            int r10 = r10 + r9
            int r10 = r10 - r6
            int r9 = java.lang.Math.abs(r10)
            if (r9 >= r5) goto L56
            r3 = r8
            r5 = r9
        L56:
            int r7 = r7 + 1
            goto L3c
        L59:
            if (r3 != 0) goto L5c
            return
        L5c:
            int[] r0 = r11.a(r0, r3)
            r1 = r0[r4]
            r2 = 1
            if (r1 != 0) goto L69
            r3 = r0[r2]
            if (r3 == 0) goto L70
        L69:
            androidx.recyclerview.widget.RecyclerView r11 = r11.f2280a
            r0 = r0[r2]
            r11.i0(r1, r0, r4)
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.y.b():void");
    }
}
