package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.c;

/* loaded from: classes.dex */
public abstract class x extends RecyclerView.i {

    /* renamed from: g */
    public boolean f2279g = true;

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public final boolean a(RecyclerView.a0 a0Var, RecyclerView.i.c cVar, RecyclerView.i.c cVar2) {
        int i7;
        int i8;
        if (cVar == null || ((i7 = cVar.f2030a) == (i8 = cVar2.f2030a) && cVar.f2031b == cVar2.f2031b)) {
            c cVar3 = (c) this;
            cVar3.s(a0Var);
            a0Var.f2005a.setAlpha(0.0f);
            cVar3.f2162i.add(a0Var);
            return true;
        }
        return m(a0Var, i7, cVar.f2031b, i8, cVar2.f2031b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public final boolean b(RecyclerView.a0 a0Var, RecyclerView.a0 a0Var2, RecyclerView.i.c cVar, RecyclerView.i.c cVar2) {
        int i7;
        int i8;
        int i9 = cVar.f2030a;
        int i10 = cVar.f2031b;
        if (a0Var2.o()) {
            int i11 = cVar.f2030a;
            i8 = cVar.f2031b;
            i7 = i11;
        } else {
            i7 = cVar2.f2030a;
            i8 = cVar2.f2031b;
        }
        c cVar3 = (c) this;
        if (a0Var == a0Var2) {
            return cVar3.m(a0Var, i9, i10, i7, i8);
        }
        float translationX = a0Var.f2005a.getTranslationX();
        float translationY = a0Var.f2005a.getTranslationY();
        float alpha = a0Var.f2005a.getAlpha();
        cVar3.s(a0Var);
        a0Var.f2005a.setTranslationX(translationX);
        a0Var.f2005a.setTranslationY(translationY);
        a0Var.f2005a.setAlpha(alpha);
        cVar3.s(a0Var2);
        a0Var2.f2005a.setTranslationX(-((int) ((i7 - i9) - translationX)));
        a0Var2.f2005a.setTranslationY(-((int) ((i8 - i10) - translationY)));
        a0Var2.f2005a.setAlpha(0.0f);
        cVar3.f2164k.add(new c.d(a0Var, a0Var2, i9, i10, i7, i8));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public final boolean c(RecyclerView.a0 a0Var, RecyclerView.i.c cVar, RecyclerView.i.c cVar2) {
        int i7 = cVar.f2030a;
        int i8 = cVar.f2031b;
        View view = a0Var.f2005a;
        int left = cVar2 == null ? view.getLeft() : cVar2.f2030a;
        int top = cVar2 == null ? view.getTop() : cVar2.f2031b;
        if (!a0Var.i() && (i7 != left || i8 != top)) {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            return m(a0Var, i7, i8, left, top);
        }
        c cVar3 = (c) this;
        cVar3.s(a0Var);
        cVar3.f2161h.add(a0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public final boolean d(RecyclerView.a0 a0Var, RecyclerView.i.c cVar, RecyclerView.i.c cVar2) {
        int i7 = cVar.f2030a;
        int i8 = cVar2.f2030a;
        if (i7 == i8 && cVar.f2031b == cVar2.f2031b) {
            g(a0Var);
            return false;
        }
        return m(a0Var, i7, cVar.f2031b, i8, cVar2.f2031b);
    }

    @SuppressLint({"UnknownNullness"})
    public abstract boolean m(RecyclerView.a0 a0Var, int i7, int i8, int i9, int i10);

    public final boolean n(RecyclerView.a0 a0Var) {
        return !this.f2279g || a0Var.g();
    }
}
