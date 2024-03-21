package com.google.android.gms.common.api;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.a.AbstractC0005a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.e0;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.common.internal.q0;
import com.google.android.gms.common.internal.w0;
import java.util.Set;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class a<O extends AbstractC0005a> {
    private static short[] $ = {7184, 7218, 7229, 7229, 7228, 7207, 7283, 7216, 7228, 7229, 7200, 7207, 7201, 7206, 7216, 7207, 7283, 7218, 7229, 7283, 7186, 7203, 7226, 7283, 7204, 7226, 7207, 7227, 7283, 7218, 7283, 7229, 7206, 7231, 7231, 7283, 7184, 7231, 7226, 7222, 7229, 7207, 7185, 7206, 7226, 7231, 7223, 7222, 7201, 6075, 6041, 6038, 6038, 6039, 6028, 6104, 6043, 6039, 6038, 6027, 6028, 6026, 6029, 6043, 6028, 6104, 6041, 6038, 6104, 6073, 6024, 6033, 6104, 6031, 6033, 6028, 6032, 6104, 6041, 6104, 6038, 6029, 6036, 6036, 6104, 6075, 6036, 6033, 6045, 6038, 6028, 6067, 6045, 6017, 477, 481, 480, 506, 425, 456, 473, 448, 425, 510, 488, 506, 425, 490, 486, 487, 506, 509, 507, 508, 490, 509, 492, 493, 425, 510, 480, 509, 481, 425, 488, 425, 474, 480, 484, 505, 485, 492, 458, 485, 480, 492, 487, 509, 459, 508, 480, 485, 493, 492, 507, 423, 425, 476, 506, 492, 425, 494, 492, 509, 474, 480, 484, 505, 485, 492, 458, 485, 480, 492, 487, 509, 459, 508, 480, 485, 493, 492, 507, 1428, 1448, 1449, 1459, 1504, 1409, 1424, 1417, 1504, 1463, 1441, 1459, 1504, 1443, 1455, 1454, 1459, 1460, 1458, 1461, 1443, 1460, 1445, 1444, 1504, 1463, 1449, 1460, 1448, 1504, 1454, 1461, 1452, 1452, 1504, 1443, 1452, 1449, 1445, 1454, 1460, 1504, 1451, 1445, 1465, 1459, 1518, 1504, 1428, 1448, 1449, 1459, 1504, 1459, 1448, 1455, 1461, 1452, 1444, 1504, 1454, 1455, 1460, 1504, 1442, 1445, 1504, 1456, 1455, 1459, 1459, 1449, 1442, 1452, 1445, 1518};

    /* renamed from: a */
    private final b<?, O> f230a;

    /* renamed from: b */
    private final g<?> f231b;
    private final String c;

    /* renamed from: com.google.android.gms.common.api.a$a */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public interface AbstractC0005a {
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static abstract class b<T extends f, O> extends e<T, O> {
        public abstract T a(Context context, Looper looper, w0 w0Var, O o, e.b bVar, e.c cVar);
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public interface c {
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class d<C extends c> {
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static abstract class e<T extends c, O> {
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public interface f extends c {
        boolean a();

        void b(k kVar, Set<Scope> set);

        boolean c();

        boolean d();

        void e();

        void h(q0 q0Var);

        boolean i();
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static final class g<C extends f> extends d<C> {
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public interface h<T extends IInterface> extends c {
        String g();

        String j();

        T l(IBinder iBinder);
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends f> a(String str, b<C, O> bVar, g<C> gVar) {
        e0.e(bVar, $(0, 49, 7251));
        e0.e(gVar, $(49, 94, 6136));
        this.c = str;
        this.f230a = bVar;
        this.f231b = gVar;
    }

    public final String a() {
        return this.c;
    }

    public final b<?, O> b() {
        e0.b(this.f230a != null, $(94, 173, 393));
        return this.f230a;
    }

    public final d<?> c() {
        g<?> gVar = this.f231b;
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalStateException($(173, 249, 1472));
    }
}
