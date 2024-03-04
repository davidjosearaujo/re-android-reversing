package g6;

import a6.o0;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* loaded from: classes.dex */
public class f extends o0 {

    /* renamed from: h */
    public a f4314h;

    public f(int i7, int i8, long j5, String str) {
        this.f4314h = new a(i7, i8, j5, str);
    }

    @Override // a6.u
    public final void U(i5.f fVar, Runnable runnable) {
        a aVar = this.f4314h;
        AtomicLongFieldUpdater atomicLongFieldUpdater = a.m;
        aVar.d(runnable, k.f4324g, false);
    }
}
