package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class k implements Runnable {

    /* renamed from: j */
    public static final ThreadLocal<k> f2239j = new ThreadLocal<>();

    /* renamed from: k */
    public static a f2240k = new a();

    /* renamed from: g */
    public long f2242g;

    /* renamed from: h */
    public long f2243h;

    /* renamed from: f */
    public ArrayList<RecyclerView> f2241f = new ArrayList<>();

    /* renamed from: i */
    public ArrayList<c> f2244i = new ArrayList<>();

    /* loaded from: classes.dex */
    public class a implements Comparator<c> {
        /* JADX WARN: Code restructure failed: missing block: B:104:0x0023, code lost:
            if (r5 != false) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:112:0x0037, code lost:
            return 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:113:?, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x0017, code lost:
            if (r5 == null) goto L10;
         */
        @Override // java.util.Comparator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int compare(androidx.recyclerview.widget.k.c r6, androidx.recyclerview.widget.k.c r7) {
            /*
                r5 = this;
                androidx.recyclerview.widget.k$c r6 = (androidx.recyclerview.widget.k.c) r6
                androidx.recyclerview.widget.k$c r7 = (androidx.recyclerview.widget.k.c) r7
                androidx.recyclerview.widget.RecyclerView r5 = r6.f2252d
                r0 = 0
                r1 = 1
                if (r5 != 0) goto Lc
                r2 = r1
                goto Ld
            Lc:
                r2 = r0
            Ld:
                androidx.recyclerview.widget.RecyclerView r3 = r7.f2252d
                if (r3 != 0) goto L13
                r3 = r1
                goto L14
            L13:
                r3 = r0
            L14:
                r4 = -1
                if (r2 == r3) goto L1d
                if (r5 != 0) goto L1b
            L19:
                r0 = r1
                goto L37
            L1b:
                r0 = r4
                goto L37
            L1d:
                boolean r5 = r6.f2249a
                boolean r2 = r7.f2249a
                if (r5 == r2) goto L26
                if (r5 == 0) goto L19
                goto L1b
            L26:
                int r5 = r7.f2250b
                int r1 = r6.f2250b
                int r5 = r5 - r1
                if (r5 == 0) goto L2f
            L2d:
                r0 = r5
                goto L37
            L2f:
                int r5 = r6.f2251c
                int r6 = r7.f2251c
                int r5 = r5 - r6
                if (r5 == 0) goto L37
                goto L2d
            L37:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.k.a.compare(java.lang.Object, java.lang.Object):int");
        }
    }

    @SuppressLint({"VisibleForTests"})
    /* loaded from: classes.dex */
    public static class b implements RecyclerView.l.c {

        /* renamed from: a */
        public int f2245a;

        /* renamed from: b */
        public int f2246b;

        /* renamed from: c */
        public int[] f2247c;

        /* renamed from: d */
        public int f2248d;

        public final void a(int i7, int i8) {
            if (i7 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i8 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i9 = this.f2248d * 2;
            int[] iArr = this.f2247c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f2247c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i9 >= iArr.length) {
                int[] iArr3 = new int[i9 * 2];
                this.f2247c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f2247c;
            iArr4[i9] = i7;
            iArr4[i9 + 1] = i8;
            this.f2248d++;
        }

        public final void b(RecyclerView recyclerView, boolean z6) {
            boolean z7 = false;
            this.f2248d = 0;
            int[] iArr = this.f2247c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.l lVar = recyclerView.f1986r;
            if (recyclerView.f1984q == null || lVar == null || !lVar.f2040i) {
                return;
            }
            if (!z6) {
                if (!((!recyclerView.f2001z || recyclerView.G || recyclerView.f1971j.g()) ? true : true)) {
                    lVar.i(this.f2245a, this.f2246b, recyclerView.f1974k0, this);
                }
            } else if (!recyclerView.f1971j.g()) {
                lVar.j(recyclerView.f1984q.a(), this);
            }
            int i7 = this.f2248d;
            if (i7 > lVar.f2041j) {
                lVar.f2041j = i7;
                lVar.f2042k = z6;
                recyclerView.f1967h.n();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a */
        public boolean f2249a;

        /* renamed from: b */
        public int f2250b;

        /* renamed from: c */
        public int f2251c;

        /* renamed from: d */
        public RecyclerView f2252d;
        public int e;
    }

    public static RecyclerView.a0 c(RecyclerView recyclerView, int i7, long j5) {
        boolean z6;
        int h7 = recyclerView.f1973k.h();
        int i8 = 0;
        while (true) {
            if (i8 >= h7) {
                z6 = false;
                break;
            }
            RecyclerView.a0 L = RecyclerView.L(recyclerView.f1973k.g(i8));
            if (L.f2007c == i7 && !L.g()) {
                z6 = true;
                break;
            }
            i8++;
        }
        if (z6) {
            return null;
        }
        RecyclerView.r rVar = recyclerView.f1967h;
        try {
            recyclerView.S();
            RecyclerView.a0 l6 = rVar.l(i7, j5);
            if (l6 != null) {
                if (!l6.f() || l6.g()) {
                    rVar.a(l6, false);
                } else {
                    rVar.i(l6.f2005a);
                }
            }
            return l6;
        } finally {
            recyclerView.T(false);
        }
    }

    public final void a(RecyclerView recyclerView, int i7, int i8) {
        if (recyclerView.isAttachedToWindow()) {
            if (RecyclerView.D0 && !this.f2241f.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            }
            if (this.f2242g == 0) {
                this.f2242g = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        b bVar = recyclerView.f1972j0;
        bVar.f2245a = i7;
        bVar.f2246b = i8;
    }

    public final void b(long j5) {
        c cVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        c cVar2;
        int size = this.f2241f.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            RecyclerView recyclerView3 = this.f2241f.get(i8);
            if (recyclerView3.getWindowVisibility() == 0) {
                recyclerView3.f1972j0.b(recyclerView3, false);
                i7 += recyclerView3.f1972j0.f2248d;
            }
        }
        this.f2244i.ensureCapacity(i7);
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            RecyclerView recyclerView4 = this.f2241f.get(i10);
            if (recyclerView4.getWindowVisibility() == 0) {
                b bVar = recyclerView4.f1972j0;
                int abs = Math.abs(bVar.f2246b) + Math.abs(bVar.f2245a);
                for (int i11 = 0; i11 < bVar.f2248d * 2; i11 += 2) {
                    if (i9 >= this.f2244i.size()) {
                        cVar2 = new c();
                        this.f2244i.add(cVar2);
                    } else {
                        cVar2 = this.f2244i.get(i9);
                    }
                    int[] iArr = bVar.f2247c;
                    int i12 = iArr[i11 + 1];
                    cVar2.f2249a = i12 <= abs;
                    cVar2.f2250b = abs;
                    cVar2.f2251c = i12;
                    cVar2.f2252d = recyclerView4;
                    cVar2.e = iArr[i11];
                    i9++;
                }
            }
        }
        Collections.sort(this.f2244i, f2240k);
        for (int i13 = 0; i13 < this.f2244i.size() && (recyclerView = (cVar = this.f2244i.get(i13)).f2252d) != null; i13++) {
            RecyclerView.a0 c7 = c(recyclerView, cVar.e, cVar.f2249a ? Long.MAX_VALUE : j5);
            if (c7 != null && c7.f2006b != null && c7.f() && !c7.g() && (recyclerView2 = c7.f2006b.get()) != null) {
                if (recyclerView2.G && recyclerView2.f1973k.h() != 0) {
                    recyclerView2.b0();
                }
                b bVar2 = recyclerView2.f1972j0;
                bVar2.b(recyclerView2, true);
                if (bVar2.f2248d != 0) {
                    try {
                        l1.h.a("RV Nested Prefetch");
                        RecyclerView.w wVar = recyclerView2.f1974k0;
                        RecyclerView.d dVar = recyclerView2.f1984q;
                        wVar.f2088d = 1;
                        wVar.e = dVar.a();
                        wVar.f2090g = false;
                        wVar.f2091h = false;
                        wVar.f2092i = false;
                        for (int i14 = 0; i14 < bVar2.f2248d * 2; i14 += 2) {
                            c(recyclerView2, bVar2.f2247c[i14], j5);
                        }
                    } finally {
                        l1.h.b();
                    }
                } else {
                    continue;
                }
            }
            cVar.f2249a = false;
            cVar.f2250b = 0;
            cVar.f2251c = 0;
            cVar.f2252d = null;
            cVar.e = 0;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            l1.h.a("RV Prefetch");
            if (this.f2241f.isEmpty()) {
                return;
            }
            int size = this.f2241f.size();
            long j5 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                RecyclerView recyclerView = this.f2241f.get(i7);
                if (recyclerView.getWindowVisibility() == 0) {
                    j5 = Math.max(recyclerView.getDrawingTime(), j5);
                }
            }
            if (j5 == 0) {
                return;
            }
            b(TimeUnit.MILLISECONDS.toNanos(j5) + this.f2243h);
        } finally {
            this.f2242g = 0L;
            l1.h.b();
        }
    }
}