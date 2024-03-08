package v2;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import com.bumptech.glide.load.data.h;
import j3.d;
import java.io.InputStream;
import v2.n;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final AssetManager f6183a;

    /* renamed from: b  reason: collision with root package name */
    public final AbstractC0117a<Data> f6184b;

    /* renamed from: v2.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface AbstractC0117a<Data> {
        h a(AssetManager assetManager, String str);
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b implements o<Uri, AssetFileDescriptor>, AbstractC0117a<AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final AssetManager f6185a;

        public b(AssetManager assetManager) {
            this.f6185a = assetManager;
        }

        @Override // v2.a.AbstractC0117a
        public final h a(AssetManager assetManager, String str) {
            return new h(assetManager, str, 0);
        }

        @Override // v2.o
        public final n<Uri, AssetFileDescriptor> b(r rVar) {
            return new a(this.f6185a, this);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c implements o<Uri, InputStream>, AbstractC0117a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final AssetManager f6186a;

        public c(AssetManager assetManager) {
            this.f6186a = assetManager;
        }

        @Override // v2.a.AbstractC0117a
        public final h a(AssetManager assetManager, String str) {
            return new h(assetManager, str, 1);
        }

        @Override // v2.o
        public final n<Uri, InputStream> b(r rVar) {
            return new a(this.f6186a, this);
        }
    }

    public a(AssetManager assetManager, AbstractC0117a<Data> aVar) {
        this.f6183a = assetManager;
        this.f6184b = aVar;
    }

    @Override // v2.n
    public final n.a a(Uri uri, int i7, int i8, p2.h hVar) {
        Uri uri2 = uri;
        return new n.a(new d(uri2), this.f6184b.a(this.f6183a, uri2.toString().substring(22)));
    }

    @Override // v2.n
    public final boolean b(Uri uri) {
        Uri uri2 = uri;
        return "file".equals(uri2.getScheme()) && !uri2.getPathSegments().isEmpty() && "android_asset".equals(uri2.getPathSegments().get(0));
    }
}
