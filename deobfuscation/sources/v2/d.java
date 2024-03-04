package v2;

import android.util.Base64;
import com.bumptech.glide.load.data.d;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import v2.n;

/* loaded from: classes.dex */
public final class d<Model, Data> implements n<Model, Data> {

    /* renamed from: a */
    public final a<Data> f6191a;

    /* loaded from: classes.dex */
    public interface a<Data> {
    }

    /* loaded from: classes.dex */
    public static final class b<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* renamed from: f */
        public final String f6192f;

        /* renamed from: g */
        public final a<Data> f6193g;

        /* renamed from: h */
        public ByteArrayInputStream f6194h;

        public b(String str, a<Data> aVar) {
            this.f6192f = str;
            this.f6193g = aVar;
        }

        @Override // com.bumptech.glide.load.data.d
        public final Class<Data> a() {
            ((c.a) this.f6193g).getClass();
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.d
        public final void b() {
            try {
                a<Data> aVar = this.f6193g;
                ByteArrayInputStream byteArrayInputStream = this.f6194h;
                ((c.a) aVar).getClass();
                byteArrayInputStream.close();
            } catch (IOException unused) {
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public final void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        public final p2.a e() {
            return p2.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public final void f(com.bumptech.glide.i iVar, d.a<? super Data> aVar) {
            try {
                ByteArrayInputStream a7 = ((c.a) this.f6193g).a(this.f6192f);
                this.f6194h = a7;
                aVar.d(a7);
            } catch (IllegalArgumentException e) {
                aVar.c(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c<Model> implements o<Model, InputStream> {

        /* renamed from: a */
        public final a f6195a = new a();

        /* loaded from: classes.dex */
        public class a implements a<InputStream> {
            public final ByteArrayInputStream a(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf != -1) {
                        if (str.substring(0, indexOf).endsWith(";base64")) {
                            return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                        }
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                throw new IllegalArgumentException("Not a valid image data URL.");
            }
        }

        @Override // v2.o
        public final n<Model, InputStream> b(r rVar) {
            return new d(this.f6195a);
        }
    }

    public d(c.a aVar) {
        this.f6191a = aVar;
    }

    @Override // v2.n
    public final n.a<Data> a(Model model, int i7, int i8, p2.h hVar) {
        return new n.a<>(new j3.d(model), new b(model.toString(), this.f6191a));
    }

    @Override // v2.n
    public final boolean b(Model model) {
        return model.toString().startsWith("data:image");
    }
}
