package a6;

import e6.j;
import i5.f;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public interface u0 extends f.b {

    /* renamed from: a */
    public static final /* synthetic */ int f340a = 0;

    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ i0 a(u0 u0Var, boolean z6, y0 y0Var, int i7) {
            if ((i7 & 1) != 0) {
                z6 = false;
            }
            return u0Var.R(z6, (i7 & 2) != 0, y0Var);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements f.c<u0> {

        /* renamed from: f */
        public static final /* synthetic */ b f341f = new b();
    }

    Object D(j.a.C0051a.b bVar);

    CancellationException G();

    i0 R(boolean z6, boolean z7, q5.l<? super Throwable, f5.g> lVar);

    boolean b();

    void d(CancellationException cancellationException);

    u0 getParent();

    k n(z0 z0Var);

    boolean start();
}
