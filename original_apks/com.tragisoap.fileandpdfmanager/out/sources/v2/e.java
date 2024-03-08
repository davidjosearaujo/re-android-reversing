package v2;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.i;
import com.bumptech.glide.load.data.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import p2.h;
import v2.n;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e<Data> implements n<File, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final d<Data> f6196a;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a<Data> implements o<File, Data> {

        /* renamed from: a  reason: collision with root package name */
        public final d<Data> f6197a;

        public a(d<Data> dVar) {
            this.f6197a = dVar;
        }

        @Override // v2.o
        public final n<File, Data> b(r rVar) {
            return new e(this.f6197a);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b extends a<ParcelFileDescriptor> {

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements d<ParcelFileDescriptor> {
            @Override // v2.e.d
            public final Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }

            @Override // v2.e.d
            public final ParcelFileDescriptor b(File file) {
                return ParcelFileDescriptor.open(file, 268435456);
            }

            @Override // v2.e.d
            public final void c(ParcelFileDescriptor parcelFileDescriptor) {
                parcelFileDescriptor.close();
            }
        }

        public b() {
            super(new a());
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* renamed from: f  reason: collision with root package name */
        public final File f6198f;

        /* renamed from: g  reason: collision with root package name */
        public final d<Data> f6199g;

        /* renamed from: h  reason: collision with root package name */
        public Data f6200h;

        public c(File file, d<Data> dVar) {
            this.f6198f = file;
            this.f6199g = dVar;
        }

        @Override // com.bumptech.glide.load.data.d
        public final Class<Data> a() {
            return this.f6199g.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public final void b() {
            Data data = this.f6200h;
            if (data != null) {
                try {
                    this.f6199g.c(data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public final void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        public final p2.a e() {
            return p2.a.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, Data] */
        @Override // com.bumptech.glide.load.data.d
        public final void f(i iVar, d.a<? super Data> aVar) {
            try {
                Data b2 = this.f6199g.b(this.f6198f);
                this.f6200h = b2;
                aVar.d(b2);
            } catch (FileNotFoundException e) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e);
                }
                aVar.c(e);
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface d<Data> {
        Class<Data> a();

        Data b(File file);

        void c(Data data);
    }

    /* renamed from: v2.e$e  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0120e extends a<InputStream> {

        /* renamed from: v2.e$e$a */
        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements d<InputStream> {
            @Override // v2.e.d
            public final Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // v2.e.d
            public final InputStream b(File file) {
                return new FileInputStream(file);
            }

            @Override // v2.e.d
            public final void c(InputStream inputStream) {
                inputStream.close();
            }
        }

        public C0120e() {
            super(new a());
        }
    }

    public e(d<Data> dVar) {
        this.f6196a = dVar;
    }

    @Override // v2.n
    public final n.a a(File file, int i7, int i8, h hVar) {
        File file2 = file;
        return new n.a(new j3.d(file2), new c(file2, this.f6196a));
    }

    @Override // v2.n
    public final /* bridge */ /* synthetic */ boolean b(File file) {
        return true;
    }
}
