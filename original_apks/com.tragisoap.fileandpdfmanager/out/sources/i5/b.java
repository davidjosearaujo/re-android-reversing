package i5;

import i5.f;
import i5.f.b;
import q5.l;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class b<B extends f.b, E extends B> implements f.c<E> {

    /* renamed from: f  reason: collision with root package name */
    public final l<f.b, E> f4480f;

    /* renamed from: g  reason: collision with root package name */
    public final f.c<?> f4481g;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [q5.l<i5.f$b, E extends B>, q5.l<? super i5.f$b, ? extends E extends B>] */
    public b(f.c<B> cVar, l<? super f.b, ? extends E> lVar) {
        h.f(cVar, "baseKey");
        this.f4480f = lVar;
        this.f4481g = cVar instanceof b ? (f.c<B>) ((b) cVar).f4481g : cVar;
    }
}
