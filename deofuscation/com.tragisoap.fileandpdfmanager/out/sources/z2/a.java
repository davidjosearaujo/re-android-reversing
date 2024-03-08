package z2;

import com.bumptech.glide.load.data.e;
import java.nio.ByteBuffer;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a implements e<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f6928a;

    /* renamed from: z2.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0138a implements e.a<ByteBuffer> {
        @Override // com.bumptech.glide.load.data.e.a
        public final Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.e.a
        public final e<ByteBuffer> b(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.f6928a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.data.e
    public final ByteBuffer a() {
        this.f6928a.position(0);
        return this.f6928a;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
    }
}
