package z5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import q5.p;
import r5.h;
import w5.c;
import y5.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a implements d<c> {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f6958a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6959b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6960c;

    /* renamed from: d  reason: collision with root package name */
    public final p<CharSequence, Integer, f5.c<Integer, Integer>> f6961d;

    /* renamed from: z5.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class C0139a implements Iterator<c>, s5.a {

        /* renamed from: f  reason: collision with root package name */
        public int f6962f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f6963g;

        /* renamed from: h  reason: collision with root package name */
        public int f6964h;

        /* renamed from: i  reason: collision with root package name */
        public c f6965i;

        /* renamed from: j  reason: collision with root package name */
        public int f6966j;

        public C0139a() {
            int X = w5.d.X(a.this.f6959b, 0, a.this.f6958a.length());
            this.f6963g = X;
            this.f6964h = X;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
            if (r6 < r3) goto L_0x001b;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a() {
            /*
                r7 = this;
                int r0 = r7.f6964h
                r1 = 0
                if (r0 >= 0) goto L_0x000c
                r7.f6962f = r1
                r0 = 0
                r7.f6965i = r0
                goto L_0x007e
            L_0x000c:
                z5.a r2 = z5.a.this
                int r3 = r2.f6960c
                r4 = -1
                r5 = 1
                if (r3 <= 0) goto L_0x001b
                int r6 = r7.f6966j
                int r6 = r6 + r5
                r7.f6966j = r6
                if (r6 >= r3) goto L_0x0023
            L_0x001b:
                java.lang.CharSequence r2 = r2.f6958a
                int r2 = r2.length()
                if (r0 <= r2) goto L_0x0037
            L_0x0023:
                w5.c r0 = new w5.c
                int r1 = r7.f6963g
                z5.a r2 = z5.a.this
                java.lang.CharSequence r2 = r2.f6958a
                int r2 = z5.i.X(r2)
                r0.<init>(r1, r2)
            L_0x0032:
                r7.f6965i = r0
                r7.f6964h = r4
                goto L_0x007c
            L_0x0037:
                z5.a r0 = z5.a.this
                q5.p<java.lang.CharSequence, java.lang.Integer, f5.c<java.lang.Integer, java.lang.Integer>> r2 = r0.f6961d
                java.lang.CharSequence r0 = r0.f6958a
                int r3 = r7.f6964h
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                java.lang.Object r0 = r2.i(r0, r3)
                f5.c r0 = (f5.c) r0
                if (r0 != 0) goto L_0x005b
                w5.c r0 = new w5.c
                int r1 = r7.f6963g
                z5.a r2 = z5.a.this
                java.lang.CharSequence r2 = r2.f6958a
                int r2 = z5.i.X(r2)
                r0.<init>(r1, r2)
                goto L_0x0032
            L_0x005b:
                A r2 = r0.f4135f
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                B r0 = r0.f4136g
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r3 = r7.f6963g
                w5.c r3 = w5.d.Z(r3, r2)
                r7.f6965i = r3
                int r2 = r2 + r0
                r7.f6963g = r2
                if (r0 != 0) goto L_0x0079
                r1 = r5
            L_0x0079:
                int r2 = r2 + r1
                r7.f6964h = r2
            L_0x007c:
                r7.f6962f = r5
            L_0x007e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: z5.a.C0139a.a():void");
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f6962f == -1) {
                a();
            }
            return this.f6962f == 1;
        }

        @Override // java.util.Iterator
        public final c next() {
            if (this.f6962f == -1) {
                a();
            }
            if (this.f6962f != 0) {
                c cVar = this.f6965i;
                h.d(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f6965i = null;
                this.f6962f = -1;
                return cVar;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public a(String str, int i7, int i8, g gVar) {
        this.f6958a = str;
        this.f6959b = i7;
        this.f6960c = i8;
        this.f6961d = gVar;
    }

    @Override // y5.d
    public final Iterator<c> iterator() {
        return new C0139a();
    }
}
