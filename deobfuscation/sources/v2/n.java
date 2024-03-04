package v2;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public interface n<Model, Data> {

    /* loaded from: classes.dex */
    public static class a<Data> {

        /* renamed from: a */
        public final p2.f f6223a;

        /* renamed from: b */
        public final List<p2.f> f6224b;

        /* renamed from: c */
        public final com.bumptech.glide.load.data.d<Data> f6225c;

        public a() {
            throw null;
        }

        public a(p2.f fVar, com.bumptech.glide.load.data.d<Data> dVar) {
            List<p2.f> emptyList = Collections.emptyList();
            q2.a.i(fVar);
            this.f6223a = fVar;
            q2.a.i(emptyList);
            this.f6224b = emptyList;
            q2.a.i(dVar);
            this.f6225c = dVar;
        }
    }

    a<Data> a(Model model, int i7, int i8, p2.h hVar);

    boolean b(Model model);
}
