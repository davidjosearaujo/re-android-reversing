package v2;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import v2.n;

/* loaded from: classes.dex */
public final class v<Data> implements n<Uri, Data> {

    /* renamed from: b */
    public static final Set<String> f6257b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));

    /* renamed from: a */
    public final c<Data> f6258a;

    /* loaded from: classes.dex */
    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a */
        public final ContentResolver f6259a;

        public a(ContentResolver contentResolver) {
            this.f6259a = contentResolver;
        }

        @Override // v2.v.c
        public final com.bumptech.glide.load.data.d<AssetFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.data.a(this.f6259a, uri);
        }

        @Override // v2.o
        public final n<Uri, AssetFileDescriptor> b(r rVar) {
            return new v(this);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a */
        public final ContentResolver f6260a;

        public b(ContentResolver contentResolver) {
            this.f6260a = contentResolver;
        }

        @Override // v2.v.c
        public final com.bumptech.glide.load.data.d<ParcelFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.data.i(this.f6260a, uri);
        }

        @Override // v2.o
        public final n<Uri, ParcelFileDescriptor> b(r rVar) {
            return new v(this);
        }
    }

    /* loaded from: classes.dex */
    public interface c<Data> {
        com.bumptech.glide.load.data.d<Data> a(Uri uri);
    }

    /* loaded from: classes.dex */
    public static class d implements o<Uri, InputStream>, c<InputStream> {

        /* renamed from: a */
        public final ContentResolver f6261a;

        public d(ContentResolver contentResolver) {
            this.f6261a = contentResolver;
        }

        @Override // v2.v.c
        public final com.bumptech.glide.load.data.d<InputStream> a(Uri uri) {
            return new com.bumptech.glide.load.data.m(this.f6261a, uri);
        }

        @Override // v2.o
        public final n<Uri, InputStream> b(r rVar) {
            return new v(this);
        }
    }

    public v(c<Data> cVar) {
        this.f6258a = cVar;
    }

    @Override // v2.n
    public final n.a a(Uri uri, int i7, int i8, p2.h hVar) {
        Uri uri2 = uri;
        return new n.a(new j3.d(uri2), this.f6258a.a(uri2));
    }

    @Override // v2.n
    public final boolean b(Uri uri) {
        return f6257b.contains(uri.getScheme());
    }
}
