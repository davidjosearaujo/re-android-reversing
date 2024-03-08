package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
@Deprecated
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* renamed from: f  reason: collision with root package name */
    public int f3376f = 0;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f3377f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3378g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b4.a f3379h;

        public a(View view, int i7, b4.a aVar) {
            this.f3377f = view;
            this.f3378g = i7;
            this.f3379h = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.f3377f.getViewTreeObserver().removeOnPreDrawListener(this);
            ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
            if (expandableBehavior.f3376f == this.f3378g) {
                b4.a aVar = this.f3379h;
                expandableBehavior.w((View) aVar, this.f3377f, aVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public abstract boolean f(View view, View view2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        b4.a aVar = (b4.a) view2;
        boolean a7 = aVar.a();
        int i7 = this.f3376f;
        int i8 = 2;
        if (!(!a7 ? i7 == 1 : i7 == 0 || i7 == 2)) {
            return false;
        }
        if (aVar.a()) {
            i8 = 1;
        }
        this.f3376f = i8;
        w((View) aVar, view, aVar.a(), true);
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i7) {
        b4.a aVar;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        if (!y.g.c(view)) {
            ArrayList e = coordinatorLayout.e(view);
            int size = e.size();
            int i8 = 0;
            while (true) {
                if (i8 >= size) {
                    aVar = null;
                    break;
                }
                View view2 = (View) e.get(i8);
                if (f(view, view2)) {
                    aVar = (b4.a) view2;
                    break;
                }
                i8++;
            }
            if (aVar != null) {
                boolean a7 = aVar.a();
                int i9 = this.f3376f;
                int i10 = 2;
                if (!a7 ? i9 == 1 : i9 == 0 || i9 == 2) {
                    if (aVar.a()) {
                        i10 = 1;
                    }
                    this.f3376f = i10;
                    view.getViewTreeObserver().addOnPreDrawListener(new a(view, i10, aVar));
                }
            }
        }
        return false;
    }

    public abstract void w(View view, View view2, boolean z6, boolean z7);
}
