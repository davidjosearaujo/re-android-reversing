package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class y extends RecyclerView.n {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f2280a;

    /* renamed from: b  reason: collision with root package name */
    public final a f2281b = new a();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends RecyclerView.p {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2282a = false;

        public a() {
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
            if (i7 != 0 || i8 != 0) {
                this.f2282a = true;
            }
        }
    }

    public abstract int[] a(RecyclerView.l lVar, View view);

    /* JADX WARN: Removed duplicated region for block: B:23:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            r11 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r11.f2280a
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            androidx.recyclerview.widget.RecyclerView$l r0 = r0.getLayoutManager()
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            r1 = r11
            androidx.recyclerview.widget.s r1 = (androidx.recyclerview.widget.s) r1
            boolean r2 = r0.f()
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L_0x001c
            androidx.recyclerview.widget.q r1 = r1.e(r0)
            goto L_0x0026
        L_0x001c:
            boolean r2 = r0.e()
            if (r2 == 0) goto L_0x0059
            androidx.recyclerview.widget.q r1 = r1.d(r0)
        L_0x0026:
            int r2 = r0.w()
            if (r2 != 0) goto L_0x002d
            goto L_0x0059
        L_0x002d:
            int r5 = r1.k()
            int r6 = r1.l()
            int r6 = r6 / 2
            int r6 = r6 + r5
            r5 = 2147483647(0x7fffffff, float:NaN)
            r7 = r4
        L_0x003c:
            if (r7 >= r2) goto L_0x0059
            android.view.View r8 = r0.v(r7)
            int r9 = r1.e(r8)
            int r10 = r1.c(r8)
            int r10 = r10 / 2
            int r10 = r10 + r9
            int r10 = r10 - r6
            int r9 = java.lang.Math.abs(r10)
            if (r9 >= r5) goto L_0x0056
            r3 = r8
            r5 = r9
        L_0x0056:
            int r7 = r7 + 1
            goto L_0x003c
        L_0x0059:
            if (r3 != 0) goto L_0x005c
            return
        L_0x005c:
            int[] r0 = r11.a(r0, r3)
            r1 = r0[r4]
            r2 = 1
            if (r1 != 0) goto L_0x0069
            r3 = r0[r2]
            if (r3 == 0) goto L_0x0070
        L_0x0069:
            androidx.recyclerview.widget.RecyclerView r11 = r11.f2280a
            r0 = r0[r2]
            r11.i0(r1, r0, r4)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.y.b():void");
    }
}
