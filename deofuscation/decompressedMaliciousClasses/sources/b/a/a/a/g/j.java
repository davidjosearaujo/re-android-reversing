package b.a.a.a.g;

import com.google.android.gms.common.internal.e0;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class j<TResult> extends c<TResult> {
    private static short[] $ = {9497, 9516, 9534, 9510, 9581, 9508, 9534, 9581, 9507, 9506, 9529, 9581, 9524, 9512, 9529, 9581, 9518, 9506, 9504, 9533, 9505, 9512, 9529, 9512, 995, 982, 964, 988, 919, 990, 964, 919, 982, 987, 965, 978, 982, 979, 974, 919, 980, 984, 986, 967, 987, 978, 963, 978, 1498, 1511, 1532, 1530, 1519, 1515, 1526, 1520, 1521, 1471, 1522, 1514, 1516, 1515, 1471, 1521, 1520, 1515, 1471, 1533, 1530, 1471, 1521, 1514, 1523, 1523, 3081, 3124, 3119, 3113, 3132, 3128, 3109, 3107, 3106, 3180, 3105, 3129, 3135, 3128, 3180, 3106, 3107, 3128, 3180, 3118, 3113, 3180, 3106, 3129, 3104, 3104};

    /* renamed from: a  reason: collision with root package name */
    private final Object f211a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final i<TResult> f212b = new i<>();
    private boolean c;
    private TResult d;
    private Exception e;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    private final void h() {
        e0.b(this.c, $(0, 24, 9549));
    }

    private final void i() {
        e0.b(!this.c, $(24, 48, 951));
    }

    private final void j() {
        synchronized (this.f211a) {
            if (this.c) {
                this.f212b.a(this);
            }
        }
    }

    @Override // b.a.a.a.g.c
    public final c<TResult> a(a<TResult> aVar) {
        d(e.f203a, aVar);
        return this;
    }

    @Override // b.a.a.a.g.c
    public final TResult b() {
        TResult tresult;
        synchronized (this.f211a) {
            h();
            if (this.e == null) {
                tresult = this.d;
            } else {
                throw new b(this.e);
            }
        }
        return tresult;
    }

    @Override // b.a.a.a.g.c
    public final boolean c() {
        boolean z;
        synchronized (this.f211a) {
            z = this.c && this.e == null;
        }
        return z;
    }

    public final c<TResult> d(Executor executor, a<TResult> aVar) {
        this.f212b.b(new f(executor, aVar));
        j();
        return this;
    }

    public final void e(Exception exc) {
        e0.e(exc, $(48, 74, 1439));
        synchronized (this.f211a) {
            i();
            this.c = true;
            this.e = exc;
        }
        this.f212b.a(this);
    }

    public final void f(TResult tresult) {
        synchronized (this.f211a) {
            i();
            this.c = true;
            this.d = tresult;
        }
        this.f212b.a(this);
    }

    public final boolean g(Exception exc) {
        e0.e(exc, $(74, 100, 3148));
        synchronized (this.f211a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.e = exc;
            this.f212b.a(this);
            return true;
        }
    }
}
