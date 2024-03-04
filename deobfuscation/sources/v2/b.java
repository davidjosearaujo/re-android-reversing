package v2;

import com.bumptech.glide.load.data.d;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import v2.n;

/* loaded from: classes.dex */
public final class b<Data> implements n<byte[], Data> {

    /* renamed from: a */
    public final InterfaceC0119b<Data> f6187a;

    /* loaded from: classes.dex */
    public static class a implements o<byte[], ByteBuffer> {

        /* renamed from: v2.b$a$a */
        /* loaded from: classes.dex */
        public class C0118a implements InterfaceC0119b<ByteBuffer> {
            @Override // v2.b.InterfaceC0119b
            public final Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }

            @Override // v2.b.InterfaceC0119b
            public final ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // v2.o
        public final n<byte[], ByteBuffer> b(r rVar) {
            return new b(new C0118a());
        }
    }

    /* renamed from: v2.b$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0119b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    /* loaded from: classes.dex */
    public static class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* renamed from: f */
        public final byte[] f6188f;

        /* renamed from: g */
        public final InterfaceC0119b<Data> f6189g;

        public c(byte[] bArr, InterfaceC0119b<Data> interfaceC0119b) {
            this.f6188f = bArr;
            this.f6189g = interfaceC0119b;
        }

        @Override // com.bumptech.glide.load.data.d
        public final Class<Data> a() {
            return this.f6189g.a();
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
        public final void f(com.bumptech.glide.i iVar, d.a<? super Data> aVar) {
            aVar.d((Data) this.f6189g.b(this.f6188f));
        }
    }

    /* loaded from: classes.dex */
    public static class d implements o<byte[], InputStream> {

        /* loaded from: classes.dex */
        public class a implements InterfaceC0119b<InputStream> {
            @Override // v2.b.InterfaceC0119b
            public final Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // v2.b.InterfaceC0119b
            public final InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // v2.o
        public final n<byte[], InputStream> b(r rVar) {
            return new b(new a());
        }
    }

    public b(InterfaceC0119b<Data> interfaceC0119b) {
        this.f6187a = interfaceC0119b;
    }

    @Override // v2.n
    public final n.a a(byte[] bArr, int i7, int i8, p2.h hVar) {
        byte[] bArr2 = bArr;
        return new n.a(new j3.d(bArr2), new c(bArr2, this.f6187a));
    }

    @Override // v2.n
    public final /* bridge */ /* synthetic */ boolean b(byte[] bArr) {
        return true;
    }
}
