package com.google.android.material.carousel;

import a0.e;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.s0;
import androidx.recyclerview.widget.RecyclerView;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.material.carousel.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;
import l0.z;
import p1.k0;
import p1.y;
import u3.d;
import u3.f;
import u3.g;
import u3.h;
import u3.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class CarouselLayoutManager extends RecyclerView.l implements u3.b, RecyclerView.v.b {
    public int A;
    public int B;
    public int C;

    /* renamed from: p */
    public int f2933p;

    /* renamed from: q */
    public int f2934q;

    /* renamed from: r */
    public int f2935r;
    public final b s;

    /* renamed from: t */
    public androidx.activity.result.c f2936t;

    /* renamed from: u */
    public c f2937u;

    /* renamed from: v */
    public b f2938v;

    /* renamed from: w */
    public int f2939w;

    /* renamed from: x */
    public HashMap f2940x;

    /* renamed from: y */
    public g f2941y;

    /* renamed from: z */
    public final View.OnLayoutChangeListener f2942z;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {

        /* renamed from: a */
        public final View f2943a;

        /* renamed from: b */
        public final float f2944b;

        /* renamed from: c */
        public final float f2945c;

        /* renamed from: d */
        public final c f2946d;

        public a(View view, float f7, float f8, c cVar) {
            this.f2943a = view;
            this.f2944b = f7;
            this.f2945c = f8;
            this.f2946d = cVar;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b extends RecyclerView.k {

        /* renamed from: a */
        public final Paint f2947a;

        /* renamed from: b */
        public List<b.C0032b> f2948b = Collections.unmodifiableList(new ArrayList());

        public b() {
            Paint paint = new Paint();
            this.f2947a = paint;
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.k
        public final void f(Canvas canvas, RecyclerView recyclerView) {
            float f7;
            float f8;
            float f9;
            float f10;
            this.f2947a.setStrokeWidth(recyclerView.getResources().getDimension(2131099887));
            for (b.C0032b bVar : this.f2948b) {
                Paint paint = this.f2947a;
                float f11 = bVar.f2965c;
                ThreadLocal<double[]> threadLocal = i1.a.f4461a;
                float f12 = 1.0f - f11;
                paint.setColor(Color.argb((int) ((((float) Color.alpha(-16776961)) * f11) + (((float) Color.alpha(-65281)) * f12)), (int) ((((float) Color.red(-16776961)) * f11) + (((float) Color.red(-65281)) * f12)), (int) ((((float) Color.green(-16776961)) * f11) + (((float) Color.green(-65281)) * f12)), (int) ((((float) Color.blue(-16776961)) * f11) + (((float) Color.blue(-65281)) * f12))));
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).P0()) {
                    f10 = bVar.f2964b;
                    f9 = (float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).f2941y.i();
                    f8 = bVar.f2964b;
                    f7 = (float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).f2941y.d();
                } else {
                    f10 = (float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).f2941y.f();
                    f9 = bVar.f2964b;
                    f8 = (float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).f2941y.g();
                    f7 = bVar.f2964b;
                }
                canvas.drawLine(f10, f9, f8, f7, this.f2947a);
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c {

        /* renamed from: a */
        public final b.C0032b f2949a;

        /* renamed from: b */
        public final b.C0032b f2950b;

        public c(b.C0032b bVar, b.C0032b bVar2) {
            if (bVar.f2963a <= bVar2.f2963a) {
                this.f2949a = bVar;
                this.f2950b = bVar2;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public CarouselLayoutManager() {
        i iVar = new i();
        this.s = new b();
        this.f2939w = 0;
        this.f2942z = new u3.c(this);
        this.B = -1;
        this.C = 0;
        this.f2936t = iVar;
        W0();
        Y0(0);
    }

    public static float L0(float f7, c cVar) {
        b.C0032b bVar = cVar.f2949a;
        float f8 = bVar.f2966d;
        b.C0032b bVar2 = cVar.f2950b;
        return n3.a.a(f8, bVar2.f2966d, bVar.f2964b, bVar2.f2964b, f7);
    }

    public static c O0(float f7, List list, boolean z6) {
        float f8 = Float.MAX_VALUE;
        float f9 = -3.4028235E38f;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        int i10 = -1;
        float f10 = Float.MAX_VALUE;
        float f11 = Float.MAX_VALUE;
        for (int i11 = 0; i11 < list.size(); i11++) {
            b.C0032b bVar = (b.C0032b) list.get(i11);
            float f12 = z6 ? bVar.f2964b : bVar.f2963a;
            float abs = Math.abs(f12 - f7);
            if (f12 <= f7 && abs <= f8) {
                i7 = i11;
                f8 = abs;
            }
            if (f12 > f7 && abs <= f10) {
                i9 = i11;
                f10 = abs;
            }
            if (f12 <= f11) {
                i8 = i11;
                f11 = f12;
            }
            if (f12 > f9) {
                i10 = i11;
                f9 = f12;
            }
        }
        if (i7 == -1) {
            i7 = i8;
        }
        if (i9 == -1) {
            i9 = i10;
        }
        return new c((b.C0032b) list.get(i7), (b.C0032b) list.get(i9));
    }

    public final void B0(View view, int i7, a aVar) {
        float f7 = this.f2938v.f2951a / 2.0f;
        b(view, i7, false);
        float f8 = aVar.f2945c;
        this.f2941y.j(view, (int) (f8 - f7), (int) (f8 + f7));
        Z0(view, aVar.f2944b, aVar.f2946d);
    }

    public final float C0(float f7, float f8) {
        return Q0() ? f7 - f8 : f7 + f8;
    }

    public final void D0(int i7, RecyclerView.r rVar, RecyclerView.w wVar) {
        float G0 = G0(i7);
        while (i7 < wVar.b()) {
            a T0 = T0(rVar, G0, i7);
            if (!R0(T0.f2945c, T0.f2946d)) {
                G0 = C0(G0, this.f2938v.f2951a);
                if (!S0(T0.f2945c, T0.f2946d)) {
                    B0(T0.f2943a, -1, T0);
                }
                i7++;
            } else {
                return;
            }
        }
    }

    public final void E0(int i7, RecyclerView.r rVar) {
        float G0 = G0(i7);
        while (i7 >= 0) {
            a T0 = T0(rVar, G0, i7);
            if (!S0(T0.f2945c, T0.f2946d)) {
                float f7 = this.f2938v.f2951a;
                G0 = Q0() ? G0 + f7 : G0 - f7;
                if (!R0(T0.f2945c, T0.f2946d)) {
                    B0(T0.f2943a, 0, T0);
                }
                i7--;
            } else {
                return;
            }
        }
    }

    public final float F0(View view, float f7, c cVar) {
        b.C0032b bVar = cVar.f2949a;
        float f8 = bVar.f2964b;
        b.C0032b bVar2 = cVar.f2950b;
        float a7 = n3.a.a(f8, bVar2.f2964b, bVar.f2963a, bVar2.f2963a, f7);
        if (cVar.f2950b != this.f2938v.b() && cVar.f2949a != this.f2938v.d()) {
            return a7;
        }
        float b2 = this.f2941y.b((RecyclerView.m) view.getLayoutParams()) / this.f2938v.f2951a;
        b.C0032b bVar3 = cVar.f2950b;
        return a7 + (((1.0f - bVar3.f2965c) + b2) * (f7 - bVar3.f2963a));
    }

    public final float G0(int i7) {
        return C0((float) (this.f2941y.h() - this.f2933p), this.f2938v.f2951a * ((float) i7));
    }

    public final void H0(RecyclerView.r rVar, RecyclerView.w wVar) {
        while (w() > 0) {
            View v6 = v(0);
            float J0 = J0(v6);
            if (!S0(J0, O0(J0, this.f2938v.f2952b, true))) {
                break;
            }
            j0(v6, rVar);
        }
        while (w() - 1 >= 0) {
            View v7 = v(w() - 1);
            float J02 = J0(v7);
            if (!R0(J02, O0(J02, this.f2938v.f2952b, true))) {
                break;
            }
            j0(v7, rVar);
        }
        if (w() == 0) {
            E0(this.f2939w - 1, rVar);
            D0(this.f2939w, rVar, wVar);
            return;
        }
        int G = RecyclerView.l.G(v(0));
        int G2 = RecyclerView.l.G(v(w() - 1));
        E0(G - 1, rVar);
        D0(G2 + 1, rVar, wVar);
    }

    public final int I0() {
        return P0() ? this.f2044n : this.f2045o;
    }

    public final float J0(View view) {
        Rect rect = new Rect();
        RecyclerView.M(view, rect);
        return (float) (P0() ? rect.centerX() : rect.centerY());
    }

    public final b K0(int i7) {
        b bVar;
        HashMap hashMap = this.f2940x;
        return (hashMap == null || (bVar = (b) hashMap.get(Integer.valueOf(e.k(i7, 0, Math.max(0, A() + -1))))) == null) ? this.f2937u.f2968a : bVar;
    }

    public final int M0(int i7, b bVar) {
        if (Q0()) {
            float f7 = bVar.f2951a;
            return (int) (((((float) I0()) - bVar.c().f2963a) - (((float) i7) * f7)) - (f7 / 2.0f));
        }
        return (int) ((bVar.f2951a / 2.0f) + ((((float) i7) * bVar.f2951a) - bVar.a().f2963a));
    }

    public final int N0(int i7, b bVar) {
        int i8 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        for (b.C0032b bVar2 : bVar.f2952b.subList(bVar.f2953c, bVar.f2954d + 1)) {
            float f7 = bVar.f2951a;
            float f8 = (f7 / 2.0f) + (((float) i7) * f7);
            int I0 = (Q0() ? (int) ((((float) I0()) - bVar2.f2963a) - f8) : (int) (f8 - bVar2.f2963a)) - this.f2933p;
            if (Math.abs(i8) > Math.abs(I0)) {
                i8 = I0;
            }
        }
        return i8;
    }

    public final boolean P0() {
        return this.f2941y.f6113a == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void Q(RecyclerView recyclerView) {
        W0();
        recyclerView.addOnLayoutChangeListener(this.f2942z);
    }

    public final boolean Q0() {
        return P0() && B() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void R(RecyclerView recyclerView) {
        recyclerView.removeOnLayoutChangeListener(this.f2942z);
    }

    public final boolean R0(float f7, c cVar) {
        float L0 = L0(f7, cVar) / 2.0f;
        float f8 = Q0() ? f7 + L0 : f7 - L0;
        if (Q0()) {
            if (f8 < 0.0f) {
                return true;
            }
        } else if (f8 > ((float) I0())) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
        if (r9 == 1) goto L_0x0056;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
        if (Q0() != false) goto L_0x0058;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
        if (r9 == 1) goto L_0x0058;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
        if (Q0() != false) goto L_0x0056;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005c  */
    @Override // androidx.recyclerview.widget.RecyclerView.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View S(android.view.View r6, int r7, androidx.recyclerview.widget.RecyclerView.r r8, androidx.recyclerview.widget.RecyclerView.w r9) {
        /*
            r5 = this;
            int r9 = r5.w()
            r0 = 0
            if (r9 != 0) goto L_0x0008
            return r0
        L_0x0008:
            u3.g r9 = r5.f2941y
            int r9 = r9.f6113a
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 1
            r3 = -1
            if (r7 == r2) goto L_0x0058
            r4 = 2
            if (r7 == r4) goto L_0x0056
            r4 = 17
            if (r7 == r4) goto L_0x004b
            r4 = 33
            if (r7 == r4) goto L_0x0048
            r4 = 66
            if (r7 == r4) goto L_0x003f
            r4 = 130(0x82, float:1.82E-43)
            if (r7 == r4) goto L_0x003c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r4 = "Unknown focus request:"
            r9.append(r4)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            java.lang.String r9 = "CarouselLayoutManager"
            android.util.Log.d(r9, r7)
            goto L_0x0054
        L_0x003c:
            if (r9 != r2) goto L_0x0054
            goto L_0x0056
        L_0x003f:
            if (r9 != 0) goto L_0x0054
            boolean r7 = r5.Q0()
            if (r7 == 0) goto L_0x0056
            goto L_0x0058
        L_0x0048:
            if (r9 != r2) goto L_0x0054
            goto L_0x0058
        L_0x004b:
            if (r9 != 0) goto L_0x0054
            boolean r7 = r5.Q0()
            if (r7 == 0) goto L_0x0058
            goto L_0x0056
        L_0x0054:
            r7 = r1
            goto L_0x0059
        L_0x0056:
            r7 = r2
            goto L_0x0059
        L_0x0058:
            r7 = r3
        L_0x0059:
            if (r7 != r1) goto L_0x005c
            return r0
        L_0x005c:
            r9 = 0
            int r6 = androidx.recyclerview.widget.RecyclerView.l.G(r6)
            if (r7 != r3) goto L_0x0096
            if (r6 != 0) goto L_0x0066
            return r0
        L_0x0066:
            android.view.View r6 = r5.v(r9)
            int r6 = androidx.recyclerview.widget.RecyclerView.l.G(r6)
            int r6 = r6 - r2
            if (r6 < 0) goto L_0x0085
            int r7 = r5.A()
            if (r6 < r7) goto L_0x0078
            goto L_0x0085
        L_0x0078:
            float r7 = r5.G0(r6)
            com.google.android.material.carousel.CarouselLayoutManager$a r6 = r5.T0(r8, r7, r6)
            android.view.View r7 = r6.f2943a
            r5.B0(r7, r9, r6)
        L_0x0085:
            boolean r6 = r5.Q0()
            if (r6 == 0) goto L_0x0091
            int r6 = r5.w()
            int r9 = r6 + -1
        L_0x0091:
            android.view.View r5 = r5.v(r9)
            goto L_0x00d3
        L_0x0096:
            int r7 = r5.A()
            int r7 = r7 - r2
            if (r6 != r7) goto L_0x009e
            return r0
        L_0x009e:
            int r6 = r5.w()
            int r6 = r6 - r2
            android.view.View r6 = r5.v(r6)
            int r6 = androidx.recyclerview.widget.RecyclerView.l.G(r6)
            int r6 = r6 + r2
            if (r6 < 0) goto L_0x00c2
            int r7 = r5.A()
            if (r6 < r7) goto L_0x00b5
            goto L_0x00c2
        L_0x00b5:
            float r7 = r5.G0(r6)
            com.google.android.material.carousel.CarouselLayoutManager$a r6 = r5.T0(r8, r7, r6)
            android.view.View r7 = r6.f2943a
            r5.B0(r7, r3, r6)
        L_0x00c2:
            boolean r6 = r5.Q0()
            if (r6 == 0) goto L_0x00c9
            goto L_0x00cf
        L_0x00c9:
            int r6 = r5.w()
            int r9 = r6 + -1
        L_0x00cf:
            android.view.View r5 = r5.v(r9)
        L_0x00d3:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.S(android.view.View, int, androidx.recyclerview.widget.RecyclerView$r, androidx.recyclerview.widget.RecyclerView$w):android.view.View");
    }

    public final boolean S0(float f7, c cVar) {
        float C0 = C0(f7, L0(f7, cVar) / 2.0f);
        return !Q0() ? C0 < 0.0f : C0 > ((float) I0());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void T(AccessibilityEvent accessibilityEvent) {
        super.T(accessibilityEvent);
        if (w() > 0) {
            accessibilityEvent.setFromIndex(RecyclerView.l.G(v(0)));
            accessibilityEvent.setToIndex(RecyclerView.l.G(v(w() - 1)));
        }
    }

    public final a T0(RecyclerView.r rVar, float f7, int i7) {
        View d7 = rVar.d(i7);
        U0(d7);
        float C0 = C0(f7, this.f2938v.f2951a / 2.0f);
        c O0 = O0(C0, this.f2938v.f2952b, false);
        return new a(d7, C0, F0(d7, C0, O0), O0);
    }

    public final void U0(View view) {
        if (view instanceof h) {
            RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
            Rect rect = new Rect();
            d(view, rect);
            int i7 = rect.left + rect.right + 0;
            int i8 = rect.top + rect.bottom + 0;
            c cVar = this.f2937u;
            view.measure(RecyclerView.l.x(this.f2044n, this.f2043l, E() + D() + ((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin + i7, (int) ((cVar == null || this.f2941y.f6113a != 0) ? (float) ((ViewGroup.MarginLayoutParams) mVar).width : cVar.f2968a.f2951a), P0()), RecyclerView.l.x(this.f2045o, this.m, C() + F() + ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin + i8, (int) ((cVar == null || this.f2941y.f6113a != 1) ? (float) ((ViewGroup.MarginLayoutParams) mVar).height : cVar.f2968a.f2951a), f()));
            return;
        }
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x01ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ec A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0236  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void V0(androidx.recyclerview.widget.RecyclerView.r r25) {
        /*
            Method dump skipped, instructions count: 678
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.V0(androidx.recyclerview.widget.RecyclerView$r):void");
    }

    public final void W0() {
        this.f2937u = null;
        m0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void X(int i7, int i8) {
        int A = A();
        int i9 = this.A;
        if (A != i9 && this.f2937u != null) {
            if (this.f2936t.o(this, i9)) {
                W0();
            }
            this.A = A;
        }
    }

    public final int X0(int i7, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (w() == 0 || i7 == 0) {
            return 0;
        }
        if (this.f2937u == null) {
            V0(rVar);
        }
        int i8 = this.f2933p;
        int i9 = this.f2934q;
        int i10 = this.f2935r;
        int i11 = i8 + i7;
        if (i11 < i9) {
            i7 = i9 - i8;
        } else if (i11 > i10) {
            i7 = i10 - i8;
        }
        this.f2933p = i8 + i7;
        a1(this.f2937u);
        float f7 = this.f2938v.f2951a / 2.0f;
        float G0 = G0(RecyclerView.l.G(v(0)));
        Rect rect = new Rect();
        float f8 = (Q0() ? this.f2938v.c() : this.f2938v.a()).f2964b;
        float f9 = Float.MAX_VALUE;
        for (int i12 = 0; i12 < w(); i12++) {
            View v6 = v(i12);
            float C0 = C0(G0, f7);
            c O0 = O0(C0, this.f2938v.f2952b, false);
            float F0 = F0(v6, C0, O0);
            RecyclerView.M(v6, rect);
            Z0(v6, C0, O0);
            this.f2941y.l(f7, F0, rect, v6);
            float abs = Math.abs(f8 - F0);
            if (abs < f9) {
                this.B = RecyclerView.l.G(v6);
                f9 = abs;
            }
            G0 = C0(G0, this.f2938v.f2951a);
        }
        H0(rVar, wVar);
        return i7;
    }

    public final void Y0(int i7) {
        g gVar;
        if (i7 == 0 || i7 == 1) {
            c(null);
            g gVar2 = this.f2941y;
            if (gVar2 == null || i7 != gVar2.f6113a) {
                if (i7 == 0) {
                    gVar = new f(this);
                } else if (i7 == 1) {
                    gVar = new u3.e(this);
                } else {
                    throw new IllegalArgumentException("invalid orientation");
                }
                this.f2941y = gVar;
                W0();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(s0.g("invalid orientation:", i7));
    }

    public final void Z0(View view, float f7, c cVar) {
        if (view instanceof h) {
            b.C0032b bVar = cVar.f2949a;
            float f8 = bVar.f2965c;
            b.C0032b bVar2 = cVar.f2950b;
            float a7 = n3.a.a(f8, bVar2.f2965c, bVar.f2963a, bVar2.f2963a, f7);
            float height = (float) view.getHeight();
            float width = (float) view.getWidth();
            float a8 = n3.a.a(0.0f, width / 2.0f, 0.0f, 1.0f, a7);
            RectF c7 = this.f2941y.c(height, width, n3.a.a(0.0f, height / 2.0f, 0.0f, 1.0f, a7), a8);
            float F0 = F0(view, f7, cVar);
            RectF rectF = new RectF(F0 - (c7.width() / 2.0f), F0 - (c7.height() / 2.0f), (c7.width() / 2.0f) + F0, (c7.height() / 2.0f) + F0);
            RectF rectF2 = new RectF((float) this.f2941y.f(), (float) this.f2941y.i(), (float) this.f2941y.g(), (float) this.f2941y.d());
            this.f2936t.getClass();
            this.f2941y.a(c7, rectF, rectF2);
            this.f2941y.k(c7, rectF, rectF2);
            ((h) view).a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v.b
    public final PointF a(int i7) {
        if (this.f2937u == null) {
            return null;
        }
        int M0 = M0(i7, K0(i7)) - this.f2933p;
        return P0() ? new PointF((float) M0, 0.0f) : new PointF(0.0f, (float) M0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void a0(int i7, int i8) {
        int A = A();
        int i9 = this.A;
        if (A != i9 && this.f2937u != null) {
            if (this.f2936t.o(this, i9)) {
                W0();
            }
            this.A = A;
        }
    }

    public final void a1(c cVar) {
        b bVar;
        int i7 = this.f2935r;
        int i8 = this.f2934q;
        if (i7 > i8) {
            bVar = cVar.a((float) this.f2933p, (float) i8, (float) i7);
        } else if (Q0()) {
            List<b> list = cVar.f2970c;
            bVar = list.get(list.size() - 1);
        } else {
            List<b> list2 = cVar.f2969b;
            bVar = list2.get(list2.size() - 1);
        }
        this.f2938v = bVar;
        b bVar2 = this.s;
        List<b.C0032b> list3 = bVar.f2952b;
        bVar2.getClass();
        bVar2.f2948b = Collections.unmodifiableList(list3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void c0(RecyclerView.r rVar, RecyclerView.w wVar) {
        b bVar;
        int i7;
        b bVar2;
        int i8;
        if (wVar.b() <= 0 || ((float) I0()) <= 0.0f) {
            h0(rVar);
            this.f2939w = 0;
            return;
        }
        boolean Q0 = Q0();
        boolean z6 = this.f2937u == null;
        if (z6) {
            V0(rVar);
        }
        c cVar = this.f2937u;
        boolean Q02 = Q0();
        int i9 = -1;
        if (Q02) {
            List<b> list = cVar.f2970c;
            bVar = list.get(list.size() - 1);
        } else {
            List<b> list2 = cVar.f2969b;
            bVar = list2.get(list2.size() - 1);
        }
        b.C0032b c7 = Q02 ? bVar.c() : bVar.a();
        RecyclerView recyclerView = this.f2034b;
        if (recyclerView != null) {
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            i7 = y.e.f(recyclerView);
        } else {
            i7 = 0;
        }
        float f7 = (float) (i7 * (Q02 ? 1 : -1));
        float f8 = c7.f2963a;
        float f9 = bVar.f2951a / 2.0f;
        int h7 = (int) ((f7 + ((float) this.f2941y.h())) - (Q0() ? f8 + f9 : f8 - f9));
        c cVar2 = this.f2937u;
        boolean Q03 = Q0();
        if (Q03) {
            List<b> list3 = cVar2.f2969b;
            bVar2 = list3.get(list3.size() - 1);
        } else {
            List<b> list4 = cVar2.f2970c;
            bVar2 = list4.get(list4.size() - 1);
        }
        b.C0032b a7 = Q03 ? bVar2.a() : bVar2.c();
        float b2 = ((float) (wVar.b() - 1)) * bVar2.f2951a;
        RecyclerView recyclerView2 = this.f2034b;
        if (recyclerView2 != null) {
            WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
            i8 = y.e.e(recyclerView2);
        } else {
            i8 = 0;
        }
        int h8 = (int) ((((b2 + ((float) i8)) * (Q03 ? -1.0f : 1.0f)) - (a7.f2963a - ((float) this.f2941y.h()))) + (((float) this.f2941y.e()) - a7.f2963a));
        int min = Q03 ? Math.min(0, h8) : Math.max(0, h8);
        this.f2934q = Q0 ? min : h7;
        if (Q0) {
            min = h7;
        }
        this.f2935r = min;
        if (z6) {
            this.f2933p = h7;
            c cVar3 = this.f2937u;
            int A = A();
            int i10 = this.f2934q;
            int i11 = this.f2935r;
            boolean Q04 = Q0();
            float f10 = cVar3.f2968a.f2951a;
            HashMap hashMap = new HashMap();
            int i12 = 0;
            int i13 = 0;
            while (i12 < A) {
                int i14 = Q04 ? (A - i12) - 1 : i12;
                float f11 = ((float) i14) * f10;
                if (!Q04) {
                    i9 = 1;
                }
                if (f11 * ((float) i9) > ((float) i11) - cVar3.f2973g || i12 >= A - cVar3.f2970c.size()) {
                    Integer valueOf = Integer.valueOf(i14);
                    List<b> list5 = cVar3.f2970c;
                    hashMap.put(valueOf, list5.get(e.k(i13, 0, list5.size() - 1)));
                    i13++;
                }
                i12++;
                i9 = -1;
            }
            int i15 = 0;
            for (int i16 = A - 1; i16 >= 0; i16--) {
                int i17 = Q04 ? (A - i16) - 1 : i16;
                if (((float) i17) * f10 * ((float) (Q04 ? -1 : 1)) < ((float) i10) + cVar3.f2972f || i16 < cVar3.f2969b.size()) {
                    Integer valueOf2 = Integer.valueOf(i17);
                    List<b> list6 = cVar3.f2969b;
                    hashMap.put(valueOf2, list6.get(e.k(i15, 0, list6.size() - 1)));
                    i15++;
                }
            }
            this.f2940x = hashMap;
            int i18 = this.B;
            if (i18 != -1) {
                this.f2933p = M0(i18, K0(i18));
            }
        }
        int i19 = this.f2933p;
        int i20 = this.f2934q;
        int i21 = this.f2935r;
        int i22 = i19 + 0;
        this.f2933p = (i22 < i20 ? i20 - i19 : i22 > i21 ? i21 - i19 : 0) + i19;
        this.f2939w = e.k(this.f2939w, 0, wVar.b());
        a1(this.f2937u);
        q(rVar);
        H0(rVar, wVar);
        this.A = A();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void d0(RecyclerView.w wVar) {
        if (w() == 0) {
            this.f2939w = 0;
        } else {
            this.f2939w = RecyclerView.l.G(v(0));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean e() {
        return P0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean f() {
        return !P0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int k(RecyclerView.w wVar) {
        if (w() == 0 || this.f2937u == null || A() <= 1) {
            return 0;
        }
        return (int) (((float) this.f2044n) * (this.f2937u.f2968a.f2951a / ((float) (this.f2935r - this.f2934q))));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int l(RecyclerView.w wVar) {
        return this.f2933p;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean l0(RecyclerView recyclerView, View view, Rect rect, boolean z6, boolean z7) {
        int N0;
        if (this.f2937u == null || (N0 = N0(RecyclerView.l.G(view), K0(RecyclerView.l.G(view)))) == 0) {
            return false;
        }
        int i7 = this.f2933p;
        int i8 = this.f2934q;
        int i9 = this.f2935r;
        int i10 = i7 + N0;
        if (i10 < i8) {
            N0 = i8 - i7;
        } else if (i10 > i9) {
            N0 = i9 - i7;
        }
        int N02 = N0(RecyclerView.l.G(view), this.f2937u.a((float) (i7 + N0), (float) i8, (float) i9));
        if (P0()) {
            recyclerView.scrollBy(N02, 0);
            return true;
        }
        recyclerView.scrollBy(0, N02);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int m(RecyclerView.w wVar) {
        return this.f2935r - this.f2934q;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int n(RecyclerView.w wVar) {
        if (w() == 0 || this.f2937u == null || A() <= 1) {
            return 0;
        }
        return (int) (((float) this.f2045o) * (this.f2937u.f2968a.f2951a / ((float) (this.f2935r - this.f2934q))));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int n0(int i7, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (P0()) {
            return X0(i7, rVar, wVar);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int o(RecyclerView.w wVar) {
        return this.f2933p;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void o0(int i7) {
        this.B = i7;
        if (this.f2937u != null) {
            this.f2933p = M0(i7, K0(i7));
            this.f2939w = e.k(i7, 0, Math.max(0, A() - 1));
            a1(this.f2937u);
            m0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int p(RecyclerView.w wVar) {
        return this.f2935r - this.f2934q;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int p0(int i7, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (f()) {
            return X0(i7, rVar, wVar);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final RecyclerView.m s() {
        return new RecyclerView.m(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void y0(RecyclerView recyclerView, int i7) {
        d dVar = new d(this, recyclerView.getContext());
        dVar.f2072a = i7;
        z0(dVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void z(View view, Rect rect) {
        RecyclerView.M(view, rect);
        float centerY = (float) rect.centerY();
        if (P0()) {
            centerY = (float) rect.centerX();
        }
        float L0 = L0(centerY, O0(centerY, this.f2938v.f2952b, true));
        float f7 = 0.0f;
        float width = P0() ? (((float) rect.width()) - L0) / 2.0f : 0.0f;
        if (!P0()) {
            f7 = (((float) rect.height()) - L0) / 2.0f;
        }
        rect.set((int) (((float) rect.left) + width), (int) (((float) rect.top) + f7), (int) (((float) rect.right) - width), (int) (((float) rect.bottom) - f7));
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i7, int i8) {
        this.s = new b();
        this.f2939w = 0;
        this.f2942z = new u3.c(this);
        this.B = -1;
        this.C = 0;
        this.f2936t = new i();
        W0();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.f4918c);
            this.C = obtainStyledAttributes.getInt(0, 0);
            W0();
            Y0(obtainStyledAttributes.getInt(0, 0));
            obtainStyledAttributes.recycle();
        }
    }
}
