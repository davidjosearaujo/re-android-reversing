package v2;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.InputStream;
import p2.h;
import v2.n;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class s<Data> implements n<Integer, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final n<Uri, Data> f6247a;

    /* renamed from: b  reason: collision with root package name */
    public final Resources f6248b;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f6249a;

        public a(Resources resources) {
            this.f6249a = resources;
        }

        @Override // v2.o
        public final n<Integer, AssetFileDescriptor> b(r rVar) {
            return new s(this.f6249a, rVar.b(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f6250a;

        public b(Resources resources) {
            this.f6250a = resources;
        }

        @Override // v2.o
        public final n<Integer, ParcelFileDescriptor> b(r rVar) {
            return new s(this.f6250a, rVar.b(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c implements o<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f6251a;

        public c(Resources resources) {
            this.f6251a = resources;
        }

        @Override // v2.o
        public final n<Integer, InputStream> b(r rVar) {
            return new s(this.f6251a, rVar.b(Uri.class, InputStream.class));
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class d implements o<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f6252a;

        public d(Resources resources) {
            this.f6252a = resources;
        }

        @Override // v2.o
        public final n<Integer, Uri> b(r rVar) {
            return new s(this.f6252a, u.f6254a);
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f6248b = resources;
        this.f6247a = nVar;
    }

    @Override // v2.n
    public final n.a a(Integer num, int i7, int i8, h hVar) {
        Uri uri;
        Integer num2 = num;
        try {
            uri = Uri.parse("android.resource://" + this.f6248b.getResourcePackageName(num2.intValue()) + '/' + this.f6248b.getResourceTypeName(num2.intValue()) + '/' + this.f6248b.getResourceEntryName(num2.intValue()));
        } catch (Resources.NotFoundException e) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num2, e);
            }
            uri = null;
        }
        if (uri == null) {
            return null;
        }
        return this.f6247a.a(uri, i7, i8, hVar);
    }

    @Override // v2.n
    public final /* bridge */ /* synthetic */ boolean b(Integer num) {
        return true;
    }
}
