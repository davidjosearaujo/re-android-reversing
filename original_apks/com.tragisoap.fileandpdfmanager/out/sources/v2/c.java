package v2;

import android.util.Log;
import com.bumptech.glide.i;
import com.bumptech.glide.load.data.d;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import p2.h;
import v2.n;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c implements n<File, ByteBuffer> {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a implements d<ByteBuffer> {

        /* renamed from: f  reason: collision with root package name */
        public final File f6190f;

        public a(File file) {
            this.f6190f = file;
        }

        @Override // com.bumptech.glide.load.data.d
        public final Class<ByteBuffer> a() {
            return ByteBuffer.class;
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
        public final void f(i iVar, d.a<? super ByteBuffer> aVar) {
            try {
                aVar.d(k3.a.a(this.f6190f));
            } catch (IOException e) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e);
                }
                aVar.c(e);
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b implements o<File, ByteBuffer> {
        @Override // v2.o
        public final n<File, ByteBuffer> b(r rVar) {
            return new c();
        }
    }

    @Override // v2.n
    public final n.a<ByteBuffer> a(File file, int i7, int i8, h hVar) {
        File file2 = file;
        return new n.a<>(new j3.d(file2), new a(file2));
    }

    @Override // v2.n
    public final /* bridge */ /* synthetic */ boolean b(File file) {
        return true;
    }
}
