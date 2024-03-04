package com.bumptech.glide;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.e;
import d3.c;
import f3.c;
import f3.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import l3.a;
import p.a0;
import p.n0;
import v2.p;
import v2.r;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a */
    public final p f2647a;

    /* renamed from: b */
    public final f3.a f2648b;

    /* renamed from: c */
    public final f3.c f2649c;

    /* renamed from: d */
    public final f3.d f2650d;
    public final com.bumptech.glide.load.data.f e;

    /* renamed from: f */
    public final d3.c f2651f;

    /* renamed from: g */
    public final a0 f2652g;

    /* renamed from: h */
    public final n0 f2653h = new n0(4);

    /* renamed from: i */
    public final f3.b f2654i = new f3.b();

    /* renamed from: j */
    public final a.c f2655j;

    /* loaded from: classes.dex */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    /* loaded from: classes.dex */
    public static class c extends a {
        public c(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public c(java.lang.Object r2) {
            /*
                r1 = this;
                java.lang.String r0 = "Failed to find any ModelLoaders registered for model class: "
                java.lang.StringBuilder r0 = androidx.activity.h.d(r0)
                java.lang.Class r2 = r2.getClass()
                r0.append(r2)
                java.lang.String r2 = r0.toString()
                r1.<init>(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.j.c.<init>(java.lang.Object):void");
        }

        public <M> c(M m, List<v2.n<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }
    }

    /* loaded from: classes.dex */
    public static class d extends a {
        public d(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* loaded from: classes.dex */
    public static class e extends a {
        public e(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public j() {
        a.c cVar = new a.c(new o1.f(20), new l3.b(), new l3.c());
        this.f2655j = cVar;
        this.f2647a = new p(cVar);
        this.f2648b = new f3.a();
        this.f2649c = new f3.c();
        this.f2650d = new f3.d();
        this.e = new com.bumptech.glide.load.data.f();
        this.f2651f = new d3.c();
        this.f2652g = new a0();
        List<String> asList = Arrays.asList("Animation", "Bitmap", "BitmapDrawable");
        ArrayList arrayList = new ArrayList(asList.size());
        arrayList.add("legacy_prepend_all");
        for (String str : asList) {
            arrayList.add(str);
        }
        arrayList.add("legacy_append");
        f3.c cVar2 = this.f2649c;
        synchronized (cVar2) {
            ArrayList arrayList2 = new ArrayList(cVar2.f4124a);
            cVar2.f4124a.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                cVar2.f4124a.add((String) it.next());
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                String str2 = (String) it2.next();
                if (!arrayList.contains(str2)) {
                    cVar2.f4124a.add(str2);
                }
            }
        }
    }

    public final void a(Class cls, Class cls2, v2.o oVar) {
        p pVar = this.f2647a;
        synchronized (pVar) {
            r rVar = pVar.f6226a;
            synchronized (rVar) {
                r.b bVar = new r.b(cls, cls2, oVar);
                ArrayList arrayList = rVar.f6240a;
                arrayList.add(arrayList.size(), bVar);
            }
            pVar.f6227b.f6228a.clear();
        }
    }

    public final void b(Class cls, p2.k kVar) {
        f3.d dVar = this.f2650d;
        synchronized (dVar) {
            dVar.f4129a.add(new d.a(cls, kVar));
        }
    }

    public final void c(p2.j jVar, Class cls, Class cls2, String str) {
        f3.c cVar = this.f2649c;
        synchronized (cVar) {
            cVar.a(str).add(new c.a<>(cls, cls2, jVar));
        }
    }

    public final List<ImageHeaderParser> d() {
        List<ImageHeaderParser> list;
        a0 a0Var = this.f2652g;
        synchronized (a0Var) {
            list = a0Var.f5422a;
        }
        if (list.isEmpty()) {
            throw new b();
        }
        return list;
    }

    public final <Model> List<v2.n<Model, ?>> e(Model model) {
        List<v2.n<Model, ?>> list;
        p pVar = this.f2647a;
        pVar.getClass();
        Class<?> cls = model.getClass();
        synchronized (pVar) {
            p.a.C0121a c0121a = (p.a.C0121a) pVar.f6227b.f6228a.get(cls);
            list = c0121a == null ? null : c0121a.f6229a;
            if (list == null) {
                list = Collections.unmodifiableList(pVar.f6226a.a(cls));
                pVar.f6227b.a(cls, list);
            }
        }
        if (list.isEmpty()) {
            throw new c(model);
        }
        int size = list.size();
        List<v2.n<Model, ?>> emptyList = Collections.emptyList();
        boolean z6 = true;
        for (int i7 = 0; i7 < size; i7++) {
            v2.n<Model, ?> nVar = list.get(i7);
            if (nVar.b(model)) {
                if (z6) {
                    emptyList = new ArrayList<>(size - i7);
                    z6 = false;
                }
                emptyList.add(nVar);
            }
        }
        if (emptyList.isEmpty()) {
            throw new c(model, list);
        }
        return emptyList;
    }

    public final <X> com.bumptech.glide.load.data.e<X> f(X x3) {
        com.bumptech.glide.load.data.e<X> b2;
        com.bumptech.glide.load.data.f fVar = this.e;
        synchronized (fVar) {
            q2.a.i(x3);
            e.a aVar = (e.a) fVar.f2671a.get(x3.getClass());
            if (aVar == null) {
                Iterator it = fVar.f2671a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    e.a aVar2 = (e.a) it.next();
                    if (aVar2.a().isAssignableFrom(x3.getClass())) {
                        aVar = aVar2;
                        break;
                    }
                }
            }
            if (aVar == null) {
                aVar = com.bumptech.glide.load.data.f.f2670b;
            }
            b2 = aVar.b(x3);
        }
        return b2;
    }

    public final void g(e.a aVar) {
        com.bumptech.glide.load.data.f fVar = this.e;
        synchronized (fVar) {
            fVar.f2671a.put(aVar.a(), aVar);
        }
    }

    public final void h(Class cls, Class cls2, d3.b bVar) {
        d3.c cVar = this.f2651f;
        synchronized (cVar) {
            cVar.f3562a.add(new c.a(cls, cls2, bVar));
        }
    }
}
