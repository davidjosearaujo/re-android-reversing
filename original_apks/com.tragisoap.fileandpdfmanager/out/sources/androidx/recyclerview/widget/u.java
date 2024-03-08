package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class u implements a.AbstractC0021a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f2276a;

    public u(RecyclerView recyclerView) {
        this.f2276a = recyclerView;
    }

    public final void a(a.b bVar) {
        int i7 = bVar.f2145a;
        if (i7 == 1) {
            this.f2276a.f1986r.X(bVar.f2146b, bVar.f2148d);
        } else if (i7 == 2) {
            this.f2276a.f1986r.a0(bVar.f2146b, bVar.f2148d);
        } else if (i7 == 4) {
            this.f2276a.f1986r.b0(bVar.f2146b, bVar.f2148d);
        } else if (i7 == 8) {
            this.f2276a.f1986r.Z(bVar.f2146b, bVar.f2148d);
        }
    }

    public final RecyclerView.a0 b(int i7) {
        RecyclerView recyclerView = this.f2276a;
        int h7 = recyclerView.f1973k.h();
        int i8 = 0;
        RecyclerView.a0 a0Var = null;
        while (true) {
            if (i8 >= h7) {
                break;
            }
            RecyclerView.a0 L = RecyclerView.L(recyclerView.f1973k.g(i8));
            if (L != null && !L.i() && L.f2007c == i7) {
                if (!recyclerView.f1973k.k(L.f2005a)) {
                    a0Var = L;
                    break;
                }
                a0Var = L;
            }
            i8++;
        }
        if (a0Var == null) {
            return null;
        }
        if (!this.f2276a.f1973k.k(a0Var.f2005a)) {
            return a0Var;
        }
        if (RecyclerView.E0) {
            Log.d("RecyclerView", "assuming view holder cannot be find because it is hidden");
        }
        return null;
    }

    public final void c(int i7, int i8, Object obj) {
        int i9;
        int i10;
        RecyclerView recyclerView = this.f2276a;
        int h7 = recyclerView.f1973k.h();
        int i11 = i8 + i7;
        for (int i12 = 0; i12 < h7; i12++) {
            View g2 = recyclerView.f1973k.g(i12);
            RecyclerView.a0 L = RecyclerView.L(g2);
            if (L != null && !L.o() && (i10 = L.f2007c) >= i7 && i10 < i11) {
                L.b(2);
                L.a(obj);
                ((RecyclerView.m) g2.getLayoutParams()).f2054c = true;
            }
        }
        RecyclerView.r rVar = recyclerView.f1967h;
        int size = rVar.f2065c.size();
        while (true) {
            size--;
            if (size >= 0) {
                RecyclerView.a0 a0Var = rVar.f2065c.get(size);
                if (a0Var != null && (i9 = a0Var.f2007c) >= i7 && i9 < i11) {
                    a0Var.b(2);
                    rVar.h(size);
                }
            } else {
                this.f2276a.f1981o0 = true;
                return;
            }
        }
    }

    public final void d(int i7, int i8) {
        RecyclerView recyclerView = this.f2276a;
        int h7 = recyclerView.f1973k.h();
        for (int i9 = 0; i9 < h7; i9++) {
            RecyclerView.a0 L = RecyclerView.L(recyclerView.f1973k.g(i9));
            if (L != null && !L.o() && L.f2007c >= i7) {
                if (RecyclerView.E0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert attached child " + i9 + " holder " + L + " now at position " + (L.f2007c + i8));
                }
                L.l(i8, false);
                recyclerView.f1974k0.f2089f = true;
            }
        }
        RecyclerView.r rVar = recyclerView.f1967h;
        int size = rVar.f2065c.size();
        for (int i10 = 0; i10 < size; i10++) {
            RecyclerView.a0 a0Var = rVar.f2065c.get(i10);
            if (a0Var != null && a0Var.f2007c >= i7) {
                if (RecyclerView.E0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert cached " + i10 + " holder " + a0Var + " now at position " + (a0Var.f2007c + i8));
                }
                a0Var.l(i8, false);
            }
        }
        recyclerView.requestLayout();
        this.f2276a.f1979n0 = true;
    }

    public final void e(int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        RecyclerView recyclerView = this.f2276a;
        int h7 = recyclerView.f1973k.h();
        if (i7 < i8) {
            i11 = i7;
            i10 = i8;
            i9 = -1;
        } else {
            i10 = i7;
            i11 = i8;
            i9 = 1;
        }
        boolean z6 = false;
        for (int i17 = 0; i17 < h7; i17++) {
            RecyclerView.a0 L = RecyclerView.L(recyclerView.f1973k.g(i17));
            if (L != null && (i16 = L.f2007c) >= i11 && i16 <= i10) {
                if (RecyclerView.E0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove attached child " + i17 + " holder " + L);
                }
                if (L.f2007c == i7) {
                    L.l(i8 - i7, false);
                } else {
                    L.l(i9, false);
                }
                recyclerView.f1974k0.f2089f = true;
            }
        }
        RecyclerView.r rVar = recyclerView.f1967h;
        if (i7 < i8) {
            i13 = i7;
            i12 = i8;
            i14 = -1;
        } else {
            i12 = i7;
            i13 = i8;
            i14 = 1;
        }
        int size = rVar.f2065c.size();
        int i18 = 0;
        while (i18 < size) {
            RecyclerView.a0 a0Var = rVar.f2065c.get(i18);
            if (a0Var != null && (i15 = a0Var.f2007c) >= i13 && i15 <= i12) {
                if (i15 == i7) {
                    a0Var.l(i8 - i7, z6);
                } else {
                    a0Var.l(i14, z6);
                }
                if (RecyclerView.E0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove cached child " + i18 + " holder " + a0Var);
                }
            }
            i18++;
            z6 = false;
        }
        recyclerView.requestLayout();
        this.f2276a.f1979n0 = true;
    }
}
