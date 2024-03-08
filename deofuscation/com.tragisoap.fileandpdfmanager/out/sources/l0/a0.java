package l0;

import k0.b;
import r5.h;
import x.a;
import z.c;
import z.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a0 {
    public static final int a(a.b bVar) {
        h.f(bVar, "node");
        bVar.getClass();
        int i7 = 1;
        if (bVar instanceof l) {
            i7 = 3;
        }
        if (bVar instanceof e) {
            i7 |= 4;
        }
        if (bVar instanceof i0) {
            i7 |= 8;
        }
        if (bVar instanceof g0) {
            i7 |= 16;
        }
        if (bVar instanceof b) {
            i7 |= 32;
        }
        if (bVar instanceof f0) {
            i7 |= 64;
        }
        if (bVar instanceof k) {
            i7 |= 128;
        }
        if (bVar instanceof f) {
            i7 |= 256;
        }
        if (bVar instanceof j0.a) {
            i7 |= 512;
        }
        if (bVar instanceof d) {
            i7 |= 1024;
        }
        if (bVar instanceof c) {
            i7 |= 2048;
        }
        if (bVar instanceof z.a) {
            i7 |= 4096;
        }
        if (bVar instanceof g0.a) {
            i7 |= 8192;
        }
        if (bVar instanceof i0.a) {
            i7 |= 16384;
        }
        return bVar instanceof g0.b ? i7 | 131072 : i7;
    }

    public static final boolean b(int i7) {
        return (i7 & 128) != 0;
    }
}
