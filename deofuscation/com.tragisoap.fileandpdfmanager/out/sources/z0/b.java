package z0;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import y0.d;
import y0.e;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b {

    /* renamed from: a */
    public final ArrayList<d> f6851a = new ArrayList<>();

    /* renamed from: b */
    public a f6852b = new a();

    /* renamed from: c */
    public e f6853c;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {

        /* renamed from: a */
        public int f6854a;

        /* renamed from: b */
        public int f6855b;

        /* renamed from: c */
        public int f6856c;

        /* renamed from: d */
        public int f6857d;
        public int e;

        /* renamed from: f */
        public int f6858f;

        /* renamed from: g */
        public int f6859g;

        /* renamed from: h */
        public boolean f6860h;

        /* renamed from: i */
        public boolean f6861i;

        /* renamed from: j */
        public int f6862j;
    }

    /* renamed from: z0.b$b */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface AbstractC0136b {
    }

    public b(e eVar) {
        this.f6853c = eVar;
    }

    public final boolean a(int i7, d dVar, AbstractC0136b bVar) {
        a aVar = this.f6852b;
        int[] iArr = dVar.V;
        aVar.f6854a = iArr[0];
        boolean z6 = true;
        aVar.f6855b = iArr[1];
        aVar.f6856c = dVar.r();
        this.f6852b.f6857d = dVar.l();
        a aVar2 = this.f6852b;
        aVar2.f6861i = false;
        aVar2.f6862j = i7;
        boolean z7 = aVar2.f6854a == 3;
        boolean z8 = aVar2.f6855b == 3;
        boolean z9 = z7 && dVar.Z > 0.0f;
        boolean z10 = z8 && dVar.Z > 0.0f;
        if (z9 && dVar.f6545u[0] == 4) {
            aVar2.f6854a = 1;
        }
        if (z10 && dVar.f6545u[1] == 4) {
            aVar2.f6855b = 1;
        }
        ((ConstraintLayout.b) bVar).b(dVar, aVar2);
        dVar.O(this.f6852b.e);
        dVar.L(this.f6852b.f6858f);
        a aVar3 = this.f6852b;
        dVar.F = aVar3.f6860h;
        int i8 = aVar3.f6859g;
        dVar.f6517d0 = i8;
        if (i8 <= 0) {
            z6 = false;
        }
        dVar.F = z6;
        aVar3.f6862j = 0;
        return aVar3.f6861i;
    }

    public final void b(e eVar, int i7, int i8, int i9) {
        int i10 = eVar.f6518e0;
        int i11 = eVar.f6520f0;
        eVar.f6518e0 = 0;
        eVar.f6520f0 = 0;
        eVar.O(i8);
        eVar.L(i9);
        if (i10 < 0) {
            i10 = 0;
        }
        eVar.f6518e0 = i10;
        if (i11 < 0) {
            i11 = 0;
        }
        eVar.f6520f0 = i11;
        e eVar2 = this.f6853c;
        eVar2.f6553v0 = i7;
        eVar2.R();
    }

    public final void c(e eVar) {
        this.f6851a.clear();
        int size = eVar.f6591s0.size();
        for (int i7 = 0; i7 < size; i7++) {
            d dVar = eVar.f6591s0.get(i7);
            int[] iArr = dVar.V;
            if (iArr[0] == 3 || iArr[1] == 3) {
                this.f6851a.add(dVar);
            }
        }
        eVar.f6552u0.f6866b = true;
    }
}
