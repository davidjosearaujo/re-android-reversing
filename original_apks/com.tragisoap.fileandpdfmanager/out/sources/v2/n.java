package v2;

import com.bumptech.glide.load.data.d;
import java.util.Collections;
import java.util.List;
import p2.f;
import p2.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public interface n<Model, Data> {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a<Data> {

        /* renamed from: a */
        public final f f6223a;

        /* renamed from: b */
        public final List<f> f6224b;

        /* renamed from: c */
        public final d<Data> f6225c;

        public a() {
            throw null;
        }

        public a(f fVar, d<Data> dVar) {
            List<f> emptyList = Collections.emptyList();
            q2.a.i(fVar);
            this.f6223a = fVar;
            q2.a.i(emptyList);
            this.f6224b = emptyList;
            q2.a.i(dVar);
            this.f6225c = dVar;
        }
    }

    a<Data> a(Model model, int i7, int i8, h hVar);

    boolean b(Model model);
}
