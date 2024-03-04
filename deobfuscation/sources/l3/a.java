package l3;

import android.util.Log;
import androidx.activity.h;
import l3.d;
import o1.f;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public static final C0078a f5025a = new C0078a();

    /* renamed from: l3.a$a */
    /* loaded from: classes.dex */
    public class C0078a implements e<Object> {
        @Override // l3.a.e
        public final void a(Object obj) {
        }
    }

    /* loaded from: classes.dex */
    public interface b<T> {
        T a();
    }

    /* loaded from: classes.dex */
    public static final class c<T> implements o1.d<T> {

        /* renamed from: a */
        public final b<T> f5026a;

        /* renamed from: b */
        public final e<T> f5027b;

        /* renamed from: c */
        public final o1.d<T> f5028c;

        public c(f fVar, b bVar, e eVar) {
            this.f5028c = fVar;
            this.f5026a = bVar;
            this.f5027b = eVar;
        }

        @Override // o1.d
        public final boolean a(T t5) {
            if (t5 instanceof d) {
                ((d) t5).d().f5029a = true;
            }
            this.f5027b.a(t5);
            return this.f5028c.a(t5);
        }

        @Override // o1.d
        public final T b() {
            T b2 = this.f5028c.b();
            if (b2 == null) {
                b2 = this.f5026a.a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    StringBuilder d7 = h.d("Created new ");
                    d7.append(b2.getClass());
                    Log.v("FactoryPools", d7.toString());
                }
            }
            if (b2 instanceof d) {
                ((d) b2).d().f5029a = false;
            }
            return b2;
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        d.a d();
    }

    /* loaded from: classes.dex */
    public interface e<T> {
        void a(T t5);
    }

    public static c a(int i7, b bVar) {
        return new c(new f(i7), bVar, f5025a);
    }
}
