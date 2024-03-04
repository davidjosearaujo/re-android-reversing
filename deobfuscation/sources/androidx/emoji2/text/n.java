package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a */
    public final y1.b f1554a;

    /* renamed from: b */
    public final char[] f1555b;

    /* renamed from: c */
    public final a f1556c = new a(1024);

    /* renamed from: d */
    public final Typeface f1557d;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public final SparseArray<a> f1558a;

        /* renamed from: b */
        public i f1559b;

        public a() {
            this(1);
        }

        public a(int i7) {
            this.f1558a = new SparseArray<>(i7);
        }

        public final void a(i iVar, int i7, int i8) {
            int a7 = iVar.a(i7);
            SparseArray<a> sparseArray = this.f1558a;
            a aVar = sparseArray == null ? null : sparseArray.get(a7);
            if (aVar == null) {
                aVar = new a();
                this.f1558a.put(iVar.a(i7), aVar);
            }
            if (i8 > i7) {
                aVar.a(iVar, i7 + 1, i8);
            } else {
                aVar.f1559b = iVar;
            }
        }
    }

    public n(Typeface typeface, y1.b bVar) {
        int i7;
        int i8;
        this.f1557d = typeface;
        this.f1554a = bVar;
        int a7 = bVar.a(6);
        if (a7 != 0) {
            int i9 = a7 + bVar.f6592a;
            i7 = bVar.f6593b.getInt(bVar.f6593b.getInt(i9) + i9);
        } else {
            i7 = 0;
        }
        this.f1555b = new char[i7 * 2];
        int a8 = bVar.a(6);
        if (a8 != 0) {
            int i10 = a8 + bVar.f6592a;
            i8 = bVar.f6593b.getInt(bVar.f6593b.getInt(i10) + i10);
        } else {
            i8 = 0;
        }
        for (int i11 = 0; i11 < i8; i11++) {
            i iVar = new i(this, i11);
            y1.a c7 = iVar.c();
            int a9 = c7.a(4);
            Character.toChars(a9 != 0 ? c7.f6593b.getInt(a9 + c7.f6592a) : 0, this.f1555b, i11 * 2);
            a0.e.g("invalid metadata codepoint length", iVar.b() > 0);
            this.f1556c.a(iVar, 0, iVar.b() - 1);
        }
    }
}
