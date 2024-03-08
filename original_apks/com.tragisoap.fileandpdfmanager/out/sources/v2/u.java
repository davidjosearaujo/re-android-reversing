package v2;

import com.bumptech.glide.i;
import com.bumptech.glide.load.data.d;
import p2.h;
import v2.n;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class u<Model> implements n<Model, Model> {

    /* renamed from: a  reason: collision with root package name */
    public static final u<?> f6254a = new u<>();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a<Model> implements o<Model, Model> {

        /* renamed from: a  reason: collision with root package name */
        public static final a<?> f6255a = new a<>();

        @Override // v2.o
        public final n<Model, Model> b(r rVar) {
            return u.f6254a;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b<Model> implements d<Model> {

        /* renamed from: f  reason: collision with root package name */
        public final Model f6256f;

        public b(Model model) {
            this.f6256f = model;
        }

        @Override // com.bumptech.glide.load.data.d
        public final Class<Model> a() {
            return (Class<Model>) this.f6256f.getClass();
        }

        @Override // com.bumptech.glide.load.data.d
        public final void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public final void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        public final p2.a e() {
            return p2.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public final void f(i iVar, d.a<? super Model> aVar) {
            aVar.d((Model) this.f6256f);
        }
    }

    @Override // v2.n
    public final n.a<Model> a(Model model, int i7, int i8, h hVar) {
        return new n.a<>(new j3.d(model), new b(model));
    }

    @Override // v2.n
    public final boolean b(Model model) {
        return true;
    }
}
