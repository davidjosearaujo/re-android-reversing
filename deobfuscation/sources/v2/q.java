package v2;

import com.bumptech.glide.load.data.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import v2.n;

/* loaded from: classes.dex */
public final class q<Model, Data> implements n<Model, Data> {

    /* renamed from: a */
    public final List<n<Model, Data>> f6230a;

    /* renamed from: b */
    public final o1.d<List<Throwable>> f6231b;

    /* loaded from: classes.dex */
    public static class a<Data> implements com.bumptech.glide.load.data.d<Data>, d.a<Data> {

        /* renamed from: f */
        public final List<com.bumptech.glide.load.data.d<Data>> f6232f;

        /* renamed from: g */
        public final o1.d<List<Throwable>> f6233g;

        /* renamed from: h */
        public int f6234h;

        /* renamed from: i */
        public com.bumptech.glide.i f6235i;

        /* renamed from: j */
        public d.a<? super Data> f6236j;

        /* renamed from: k */
        public List<Throwable> f6237k;

        /* renamed from: l */
        public boolean f6238l;

        public a(ArrayList arrayList, o1.d dVar) {
            this.f6233g = dVar;
            if (arrayList.isEmpty()) {
                throw new IllegalArgumentException("Must not be empty.");
            }
            this.f6232f = arrayList;
            this.f6234h = 0;
        }

        @Override // com.bumptech.glide.load.data.d
        public final Class<Data> a() {
            return this.f6232f.get(0).a();
        }

        @Override // com.bumptech.glide.load.data.d
        public final void b() {
            List<Throwable> list = this.f6237k;
            if (list != null) {
                this.f6233g.a(list);
            }
            this.f6237k = null;
            for (com.bumptech.glide.load.data.d<Data> dVar : this.f6232f) {
                dVar.b();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public final void c(Exception exc) {
            List<Throwable> list = this.f6237k;
            q2.a.i(list);
            list.add(exc);
            g();
        }

        @Override // com.bumptech.glide.load.data.d
        public final void cancel() {
            this.f6238l = true;
            for (com.bumptech.glide.load.data.d<Data> dVar : this.f6232f) {
                dVar.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public final void d(Data data) {
            if (data != null) {
                this.f6236j.d(data);
            } else {
                g();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public final p2.a e() {
            return this.f6232f.get(0).e();
        }

        @Override // com.bumptech.glide.load.data.d
        public final void f(com.bumptech.glide.i iVar, d.a<? super Data> aVar) {
            this.f6235i = iVar;
            this.f6236j = aVar;
            this.f6237k = this.f6233g.b();
            this.f6232f.get(this.f6234h).f(iVar, this);
            if (this.f6238l) {
                cancel();
            }
        }

        public final void g() {
            if (this.f6238l) {
                return;
            }
            if (this.f6234h < this.f6232f.size() - 1) {
                this.f6234h++;
                f(this.f6235i, this.f6236j);
                return;
            }
            q2.a.i(this.f6237k);
            this.f6236j.c(new r2.r("Fetch failed", new ArrayList(this.f6237k)));
        }
    }

    public q(ArrayList arrayList, o1.d dVar) {
        this.f6230a = arrayList;
        this.f6231b = dVar;
    }

    @Override // v2.n
    public final n.a<Data> a(Model model, int i7, int i8, p2.h hVar) {
        n.a<Data> a7;
        int size = this.f6230a.size();
        ArrayList arrayList = new ArrayList(size);
        p2.f fVar = null;
        for (int i9 = 0; i9 < size; i9++) {
            n<Model, Data> nVar = this.f6230a.get(i9);
            if (nVar.b(model) && (a7 = nVar.a(model, i7, i8, hVar)) != null) {
                fVar = a7.f6223a;
                arrayList.add(a7.f6225c);
            }
        }
        if (arrayList.isEmpty() || fVar == null) {
            return null;
        }
        return new n.a<>(fVar, new a(arrayList, this.f6231b));
    }

    @Override // v2.n
    public final boolean b(Model model) {
        for (n<Model, Data> nVar : this.f6230a) {
            if (nVar.b(model)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("MultiModelLoader{modelLoaders=");
        d7.append(Arrays.toString(this.f6230a.toArray()));
        d7.append('}');
        return d7.toString();
    }
}
