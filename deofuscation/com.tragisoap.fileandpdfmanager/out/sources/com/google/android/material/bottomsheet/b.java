package com.google.android.material.bottomsheet;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import d4.e;
import e4.d;
import f.n;
import java.util.WeakHashMap;
import k4.f;
import p1.k0;
import p1.n0;
import p1.p0;
import p1.q0;
import p1.u;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b extends n {

    /* renamed from: k */
    public BottomSheetBehavior<FrameLayout> f2887k;

    /* renamed from: l */
    public FrameLayout f2888l;
    public CoordinatorLayout m;

    /* renamed from: n */
    public FrameLayout f2889n;

    /* renamed from: o */
    public boolean f2890o;

    /* renamed from: p */
    public boolean f2891p;

    /* renamed from: q */
    public boolean f2892q;

    /* renamed from: r */
    public C0031b f2893r;
    public boolean s;

    /* renamed from: t */
    public d f2894t;

    /* renamed from: u */
    public a f2895u;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends BottomSheetBehavior.d {
        public a() {
            b.this = r1;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public final void b(View view) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public final void c(View view, int i7) {
            if (i7 == 5) {
                b.this.cancel();
            }
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.b$b */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0031b extends BottomSheetBehavior.d {

        /* renamed from: a */
        public final Boolean f2897a;

        /* renamed from: b */
        public final p0 f2898b;

        /* renamed from: c */
        public Window f2899c;

        /* renamed from: d */
        public boolean f2900d;

        public C0031b(FrameLayout frameLayout, p0 p0Var) {
            ColorStateList colorStateList;
            int intValue;
            this.f2898b = p0Var;
            f fVar = BottomSheetBehavior.B(frameLayout).f2859n;
            if (fVar != null) {
                colorStateList = fVar.f4720f.f4742c;
            } else {
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                colorStateList = y.i.g(frameLayout);
            }
            Boolean bool = null;
            if (colorStateList != null) {
                colorStateList.getDefaultColor();
            } else {
                ColorStateList a7 = z3.a.a(frameLayout.getBackground());
                Integer valueOf = a7 != null ? Integer.valueOf(a7.getDefaultColor()) : null;
                intValue = valueOf != null ? valueOf.intValue() : intValue;
                this.f2897a = bool;
            }
            bool = Boolean.valueOf(q2.a.C(intValue));
            this.f2897a = bool;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public final void a(View view) {
            d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public final void b(View view) {
            d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public final void c(View view, int i7) {
            d(view);
        }

        public final void d(View view) {
            if (view.getTop() < this.f2898b.e()) {
                Window window = this.f2899c;
                if (window != null) {
                    Boolean bool = this.f2897a;
                    e.a(window, bool == null ? this.f2900d : bool.booleanValue());
                }
                view.setPadding(view.getPaddingLeft(), this.f2898b.e() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                Window window2 = this.f2899c;
                if (window2 != null) {
                    e.a(window2, this.f2900d);
                }
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        public final void e(Window window) {
            if (this.f2899c != window) {
                this.f2899c = window;
                if (window != null) {
                    q0.a aVar = new q0.a(window.getInsetsController(), new u(window.getDecorView()));
                    aVar.f5531c = window;
                    this.f2900d = aVar.a();
                }
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(android.content.Context r4, int r5) {
        /*
            r3 = this;
            r0 = 1
            if (r5 != 0) goto L_0x001b
            android.util.TypedValue r5 = new android.util.TypedValue
            r5.<init>()
            android.content.res.Resources$Theme r1 = r4.getTheme()
            r2 = 2130903164(0x7f03007c, float:1.7413138E38)
            boolean r1 = r1.resolveAttribute(r2, r5, r0)
            if (r1 == 0) goto L_0x0018
            int r5 = r5.resourceId
            goto L_0x001b
        L_0x0018:
            r5 = 2131886634(0x7f12022a, float:1.9407852E38)
        L_0x001b:
            r3.<init>(r4, r5)
            r3.f2890o = r0
            r3.f2891p = r0
            com.google.android.material.bottomsheet.b$a r4 = new com.google.android.material.bottomsheet.b$a
            r4.<init>()
            r3.f2895u = r4
            f.g r4 = r3.f()
            r4.t(r0)
            android.content.Context r4 = r3.getContext()
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int[] r5 = new int[r0]
            r0 = 2130903475(0x7f0301b3, float:1.741377E38)
            r1 = 0
            r5[r1] = r0
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5)
            boolean r4 = r4.getBoolean(r1, r1)
            r3.s = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.b.<init>(android.content.Context, int):void");
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        if (this.f2887k == null) {
            i();
        }
        super.cancel();
    }

    public final void i() {
        if (this.f2888l == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), 2131492901, null);
            this.f2888l = frameLayout;
            this.m = (CoordinatorLayout) frameLayout.findViewById(2131296408);
            FrameLayout frameLayout2 = (FrameLayout) this.f2888l.findViewById(2131296425);
            this.f2889n = frameLayout2;
            BottomSheetBehavior<FrameLayout> B = BottomSheetBehavior.B(frameLayout2);
            this.f2887k = B;
            a aVar = this.f2895u;
            if (!B.f2843b0.contains(aVar)) {
                B.f2843b0.add(aVar);
            }
            this.f2887k.I(this.f2890o);
            this.f2894t = new d(this.f2887k, this.f2889n);
        }
    }

    public final FrameLayout l(View view, int i7, ViewGroup.LayoutParams layoutParams) {
        i();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f2888l.findViewById(2131296408);
        if (i7 != 0 && view == null) {
            view = getLayoutInflater().inflate(i7, (ViewGroup) coordinatorLayout, false);
        }
        if (this.s) {
            FrameLayout frameLayout = this.f2889n;
            a aVar = new a(this);
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.i.u(frameLayout, aVar);
        }
        this.f2889n.removeAllViews();
        FrameLayout frameLayout2 = this.f2889n;
        if (layoutParams == null) {
            frameLayout2.addView(view);
        } else {
            frameLayout2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(2131296884).setOnClickListener(new r3.d(this));
        y.i(this.f2889n, new r3.e(this));
        this.f2889n.setOnTouchListener(new r3.f());
        return this.f2888l;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z6 = this.s && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.f2888l;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z6);
            }
            CoordinatorLayout coordinatorLayout = this.m;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z6);
            }
            n0.a(window, !z6);
            C0031b bVar = this.f2893r;
            if (bVar != null) {
                bVar.e(window);
            }
        }
        d dVar = this.f2894t;
        if (dVar != null) {
            if (this.f2890o) {
                d.a aVar = dVar.f3768a;
                if (aVar != null) {
                    aVar.b(dVar.f3769b, dVar.f3770c, false);
                    return;
                }
                return;
            }
            d.a aVar2 = dVar.f3768a;
            if (aVar2 != null) {
                aVar2.c(dVar.f3770c);
            }
        }
    }

    @Override // f.n, androidx.activity.l, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        d.a aVar;
        C0031b bVar = this.f2893r;
        if (bVar != null) {
            bVar.e(null);
        }
        d dVar = this.f2894t;
        if (dVar != null && (aVar = dVar.f3768a) != null) {
            aVar.c(dVar.f3770c);
        }
    }

    @Override // androidx.activity.l, android.app.Dialog
    public final void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f2887k;
        if (bottomSheetBehavior != null && bottomSheetBehavior.Q == 5) {
            bottomSheetBehavior.K(4);
        }
    }

    @Override // android.app.Dialog
    public final void setCancelable(boolean z6) {
        d dVar;
        super.setCancelable(z6);
        if (this.f2890o != z6) {
            this.f2890o = z6;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f2887k;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.I(z6);
            }
            if (getWindow() != null && (dVar = this.f2894t) != null) {
                if (this.f2890o) {
                    d.a aVar = dVar.f3768a;
                    if (aVar != null) {
                        aVar.b(dVar.f3769b, dVar.f3770c, false);
                        return;
                    }
                    return;
                }
                d.a aVar2 = dVar.f3768a;
                if (aVar2 != null) {
                    aVar2.c(dVar.f3770c);
                }
            }
        }
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean z6) {
        super.setCanceledOnTouchOutside(z6);
        if (z6 && !this.f2890o) {
            this.f2890o = true;
        }
        this.f2891p = z6;
        this.f2892q = true;
    }

    @Override // f.n, android.app.Dialog
    public final void setContentView(int i7) {
        super.setContentView(l(null, i7, null));
    }

    @Override // f.n, android.app.Dialog
    public final void setContentView(View view) {
        super.setContentView(l(view, 0, null));
    }

    @Override // f.n, android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(l(view, 0, layoutParams));
    }
}
