package v2;

import com.bumptech.glide.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import l3.a;
import v2.n;

/* loaded from: classes.dex */
public final class r {
    public static final c e = new c();

    /* renamed from: f */
    public static final a f6239f = new a();

    /* renamed from: a */
    public final ArrayList f6240a;

    /* renamed from: b */
    public final c f6241b;

    /* renamed from: c */
    public final HashSet f6242c;

    /* renamed from: d */
    public final o1.d<List<Throwable>> f6243d;

    /* loaded from: classes.dex */
    public static class a implements n<Object, Object> {
        @Override // v2.n
        public final n.a<Object> a(Object obj, int i7, int i8, p2.h hVar) {
            return null;
        }

        @Override // v2.n
        public final boolean b(Object obj) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class b<Model, Data> {

        /* renamed from: a */
        public final Class<Model> f6244a;

        /* renamed from: b */
        public final Class<Data> f6245b;

        /* renamed from: c */
        public final o<? extends Model, ? extends Data> f6246c;

        public b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
            this.f6244a = cls;
            this.f6245b = cls2;
            this.f6246c = oVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
    }

    public r(a.c cVar) {
        c cVar2 = e;
        this.f6240a = new ArrayList();
        this.f6242c = new HashSet();
        this.f6243d = cVar;
        this.f6241b = cVar2;
    }

    public final synchronized ArrayList a(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator it = this.f6240a.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (!this.f6242c.contains(bVar) && bVar.f6244a.isAssignableFrom(cls)) {
                    this.f6242c.add(bVar);
                    n b2 = bVar.f6246c.b(this);
                    q2.a.i(b2);
                    arrayList.add(b2);
                    this.f6242c.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.f6242c.clear();
            throw th;
        }
        return arrayList;
    }

    public final synchronized <Model, Data> n<Model, Data> b(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f6240a.iterator();
            boolean z6 = false;
            while (it.hasNext()) {
                b<?, ?> bVar = (b) it.next();
                if (this.f6242c.contains(bVar)) {
                    z6 = true;
                } else {
                    if (bVar.f6244a.isAssignableFrom(cls) && bVar.f6245b.isAssignableFrom(cls2)) {
                        this.f6242c.add(bVar);
                        arrayList.add(c(bVar));
                        this.f6242c.remove(bVar);
                    }
                }
            }
            if (arrayList.size() > 1) {
                c cVar = this.f6241b;
                o1.d<List<Throwable>> dVar = this.f6243d;
                cVar.getClass();
                return new q(arrayList, dVar);
            } else if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            } else if (z6) {
                return f6239f;
            } else {
                throw new j.c((Class<?>) cls, (Class<?>) cls2);
            }
        } catch (Throwable th) {
            this.f6242c.clear();
            throw th;
        }
    }

    public final <Model, Data> n<Model, Data> c(b<?, ?> bVar) {
        n<Model, Data> nVar = (n<Model, Data>) bVar.f6246c.b(this);
        q2.a.i(nVar);
        return nVar;
    }

    public final synchronized ArrayList d(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f6240a.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (!arrayList.contains(bVar.f6245b) && bVar.f6244a.isAssignableFrom(cls)) {
                arrayList.add(bVar.f6245b);
            }
        }
        return arrayList;
    }
}
