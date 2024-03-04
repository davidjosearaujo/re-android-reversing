package f;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.g1;
import g1.a;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import p1.k0;
import p1.p0;
import p1.y;

/* loaded from: classes.dex */
public final class i implements p1.p {

    /* renamed from: a */
    public final /* synthetic */ h f3997a;

    public i(h hVar) {
        this.f3997a = hVar;
    }

    @Override // p1.p
    public final p0 a(View view, p0 p0Var) {
        boolean z6;
        boolean z7;
        int e = p0Var.e();
        h hVar = this.f3997a;
        hVar.getClass();
        int e7 = p0Var.e();
        ActionBarContextView actionBarContextView = hVar.A;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z6 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) hVar.A.getLayoutParams();
            if (hVar.A.isShown()) {
                if (hVar.f3949i0 == null) {
                    hVar.f3949i0 = new Rect();
                    hVar.f3950j0 = new Rect();
                }
                Rect rect = hVar.f3949i0;
                Rect rect2 = hVar.f3950j0;
                rect.set(p0Var.c(), p0Var.e(), p0Var.d(), p0Var.b());
                ViewGroup viewGroup = hVar.G;
                Method method = g1.f908a;
                if (method != null) {
                    try {
                        method.invoke(viewGroup, rect, rect2);
                    } catch (Exception e8) {
                        Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e8);
                    }
                }
                int i7 = rect.top;
                int i8 = rect.left;
                int i9 = rect.right;
                ViewGroup viewGroup2 = hVar.G;
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                p0 a7 = y.j.a(viewGroup2);
                int c7 = a7 == null ? 0 : a7.c();
                int d7 = a7 == null ? 0 : a7.d();
                if (marginLayoutParams.topMargin == i7 && marginLayoutParams.leftMargin == i8 && marginLayoutParams.rightMargin == i9) {
                    z7 = false;
                } else {
                    marginLayoutParams.topMargin = i7;
                    marginLayoutParams.leftMargin = i8;
                    marginLayoutParams.rightMargin = i9;
                    z7 = true;
                }
                if (i7 <= 0 || hVar.I != null) {
                    View view2 = hVar.I;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i10 = marginLayoutParams2.height;
                        int i11 = marginLayoutParams.topMargin;
                        if (i10 != i11 || marginLayoutParams2.leftMargin != c7 || marginLayoutParams2.rightMargin != d7) {
                            marginLayoutParams2.height = i11;
                            marginLayoutParams2.leftMargin = c7;
                            marginLayoutParams2.rightMargin = d7;
                            hVar.I.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view3 = new View(hVar.f3955p);
                    hVar.I = view3;
                    view3.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = c7;
                    layoutParams.rightMargin = d7;
                    hVar.G.addView(hVar.I, -1, layoutParams);
                }
                View view4 = hVar.I;
                z6 = view4 != null;
                if (z6 && view4.getVisibility() != 0) {
                    View view5 = hVar.I;
                    r6 = (y.d.g(view5) & 8192) != 0;
                    Context context = hVar.f3955p;
                    int i12 = r6 ? 2131034118 : 2131034117;
                    Object obj = g1.a.f4192a;
                    view5.setBackgroundColor(a.d.a(context, i12));
                }
                if (!hVar.N && z6) {
                    e7 = 0;
                }
                r6 = z7;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z6 = false;
            } else {
                r6 = false;
                z6 = false;
            }
            if (r6) {
                hVar.A.setLayoutParams(marginLayoutParams);
            }
        }
        View view6 = hVar.I;
        if (view6 != null) {
            view6.setVisibility(z6 ? 0 : 8);
        }
        if (e != e7) {
            int c8 = p0Var.c();
            int d8 = p0Var.d();
            int b2 = p0Var.b();
            p0.c cVar = new p0.c(p0Var);
            cVar.f(i1.b.b(c8, e7, d8, b2));
            p0Var = cVar.b();
        }
        WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
        WindowInsets g2 = p0Var.g();
        if (g2 != null) {
            WindowInsets b7 = y.h.b(view, g2);
            return !b7.equals(g2) ? p0.h(view, b7) : p0Var;
        }
        return p0Var;
    }
}
