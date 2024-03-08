package w2;

import com.bumptech.glide.load.data.j;
import java.io.InputStream;
import java.util.ArrayDeque;
import p2.g;
import p2.h;
import v2.f;
import v2.m;
import v2.n;
import v2.o;
import v2.r;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a implements n<f, InputStream> {

    /* renamed from: b  reason: collision with root package name */
    public static final g<Integer> f6375b = g.a(2500, "com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout");

    /* renamed from: a  reason: collision with root package name */
    public final m<f, f> f6376a;

    /* renamed from: w2.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0128a implements o<f, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final m<f, f> f6377a = new m<>();

        @Override // v2.o
        public final n<f, InputStream> b(r rVar) {
            return new a(this.f6377a);
        }
    }

    public a(m<f, f> mVar) {
        this.f6376a = mVar;
    }

    @Override // v2.n
    public final n.a<InputStream> a(f fVar, int i7, int i8, h hVar) {
        f fVar2 = fVar;
        m<f, f> mVar = this.f6376a;
        if (mVar != null) {
            m.a a7 = m.a.a(fVar2);
            Object a8 = mVar.f6218a.a(a7);
            ArrayDeque arrayDeque = m.a.f6219d;
            synchronized (arrayDeque) {
                arrayDeque.offer(a7);
            }
            f fVar3 = (f) a8;
            if (fVar3 == null) {
                m<f, f> mVar2 = this.f6376a;
                mVar2.getClass();
                mVar2.f6218a.d(m.a.a(fVar2), fVar2);
            } else {
                fVar2 = fVar3;
            }
        }
        return new n.a<>(fVar2, new j(fVar2, ((Integer) hVar.c(f6375b)).intValue()));
    }

    @Override // v2.n
    public final /* bridge */ /* synthetic */ boolean b(f fVar) {
        return true;
    }
}
