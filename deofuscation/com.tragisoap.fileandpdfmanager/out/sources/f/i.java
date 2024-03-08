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
import i1.b;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import p1.k0;
import p1.p;
import p1.p0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f3997a;

    public i(h hVar) {
        this.f3997a = hVar;
    }

    @Override // p1.p
    public final p0 a(View view, p0 p0Var) {
        boolean z6;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i7;
        int e = p0Var.e();
        h hVar = this.f3997a;
        hVar.getClass();
        int e7 = p0Var.e();
        ActionBarContextView actionBarContextView = hVar.A;
        int i8 = 8;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z6 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) hVar.A.getLayoutParams();
            boolean z7 = true;
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
                int i9 = rect.top;
                int i10 = rect.left;
                int i11 = rect.right;
                ViewGroup viewGroup2 = hVar.G;
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                p0 a7 = y.j.a(viewGroup2);
                int c7 = a7 == null ? 0 : a7.c();
                int d7 = a7 == null ? 0 : a7.d();
                if (marginLayoutParams2.topMargin == i9 && marginLayoutParams2.leftMargin == i10 && marginLayoutParams2.rightMargin == i11) {
                    z7 = false;
                } else {
                    marginLayoutParams2.topMargin = i9;
                    marginLayoutParams2.leftMargin = i10;
                    marginLayoutParams2.rightMargin = i11;
                    z7 = true;
                }
                if (i9 <= 0 || hVar.I != null) {
                    View view2 = hVar.I;
                    if (!(view2 == null || ((marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()).height == (i7 = marginLayoutParams2.topMargin) && marginLayoutParams.leftMargin == c7 && marginLayoutParams.rightMargin == d7))) {
                        marginLayoutParams.height = i7;
                        marginLayoutParams.leftMargin = c7;
                        marginLayoutParams.rightMargin = d7;
                        hVar.I.setLayoutParams(marginLayoutParams);
                    }
                } else {
                    View view3 = new View(hVar.f3955p);
                    hVar.I = view3;
                    view3.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams2.topMargin, 51);
                    layoutParams.leftMargin = c7;
                    layoutParams.rightMargin = d7;
                    hVar.G.addView(hVar.I, -1, layoutParams);
                }
                View view4 = hVar.I;
                z6 = view4 != null;
                if (z6 && view4.getVisibility() != 0) {
                    View view5 = hVar.I;
                    if ((y.d.g(view5) & 8192) == 0) {
                        z7 = false;
                    }
                    Context context = hVar.f3955p;
                    int i12 = z7 ? 2131034118 : 2131034117;
                    Object obj = a.f4192a;
                    view5.setBackgroundColor(a.d.a(context, i12));
                }
                if (!hVar.N && z6) {
                    e7 = 0;
                }
            } else if (marginLayoutParams2.topMargin != 0) {
                marginLayoutParams2.topMargin = 0;
                z6 = false;
            } else {
                z7 = false;
                z6 = false;
            }
            if (z7) {
                hVar.A.setLayoutParams(marginLayoutParams2);
            }
        }
        View view6 = hVar.I;
        if (view6 != null) {
            if (z6) {
                i8 = 0;
            }
            view6.setVisibility(i8);
        }
        if (e != e7) {
            int c8 = p0Var.c();
            int d8 = p0Var.d();
            int b2 = p0Var.b();
            p0.c cVar = new p0.c(p0Var);
            cVar.f(b.b(c8, e7, d8, b2));
            p0Var = cVar.b();
        }
        WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
        WindowInsets g2 = p0Var.g();
        if (g2 == null) {
            return p0Var;
        }
        WindowInsets b7 = y.h.b(view, g2);
        return !b7.equals(g2) ? p0.h(view, b7) : p0Var;
    }
}
