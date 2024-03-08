package w2;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.i;
import com.bumptech.glide.load.data.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import p2.h;
import v2.n;
import v2.o;
import v2.r;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d<DataT> implements n<Uri, DataT> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6382a;

    /* renamed from: b  reason: collision with root package name */
    public final n<File, DataT> f6383b;

    /* renamed from: c  reason: collision with root package name */
    public final n<Uri, DataT> f6384c;

    /* renamed from: d  reason: collision with root package name */
    public final Class<DataT> f6385d;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class a<DataT> implements o<Uri, DataT> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f6386a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<DataT> f6387b;

        public a(Context context, Class<DataT> cls) {
            this.f6386a = context;
            this.f6387b = cls;
        }

        @Override // v2.o
        public final n<Uri, DataT> b(r rVar) {
            return new d(this.f6386a, rVar.b(File.class, this.f6387b), rVar.b(Uri.class, this.f6387b), this.f6387b);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    /* renamed from: w2.d$d  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class C0129d<DataT> implements com.bumptech.glide.load.data.d<DataT> {

        /* renamed from: p  reason: collision with root package name */
        public static final String[] f6388p = {"_data"};

        /* renamed from: f  reason: collision with root package name */
        public final Context f6389f;

        /* renamed from: g  reason: collision with root package name */
        public final n<File, DataT> f6390g;

        /* renamed from: h  reason: collision with root package name */
        public final n<Uri, DataT> f6391h;

        /* renamed from: i  reason: collision with root package name */
        public final Uri f6392i;

        /* renamed from: j  reason: collision with root package name */
        public final int f6393j;

        /* renamed from: k  reason: collision with root package name */
        public final int f6394k;

        /* renamed from: l  reason: collision with root package name */
        public final h f6395l;
        public final Class<DataT> m;

        /* renamed from: n  reason: collision with root package name */
        public volatile boolean f6396n;

        /* renamed from: o  reason: collision with root package name */
        public volatile com.bumptech.glide.load.data.d<DataT> f6397o;

        public C0129d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Uri uri, int i7, int i8, h hVar, Class<DataT> cls) {
            this.f6389f = context.getApplicationContext();
            this.f6390g = nVar;
            this.f6391h = nVar2;
            this.f6392i = uri;
            this.f6393j = i7;
            this.f6394k = i8;
            this.f6395l = hVar;
            this.m = cls;
        }

        @Override // com.bumptech.glide.load.data.d
        public final Class<DataT> a() {
            return this.m;
        }

        @Override // com.bumptech.glide.load.data.d
        public final void b() {
            com.bumptech.glide.load.data.d<DataT> dVar = this.f6397o;
            if (dVar != null) {
                dVar.b();
            }
        }

        public final com.bumptech.glide.load.data.d<DataT> c() {
            n.a<DataT> aVar;
            Throwable th;
            Cursor cursor = null;
            if (Environment.isExternalStorageLegacy()) {
                n<File, DataT> nVar = this.f6390g;
                Uri uri = this.f6392i;
                try {
                    Cursor query = this.f6389f.getContentResolver().query(uri, f6388p, null, null, null);
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                String string = query.getString(query.getColumnIndexOrThrow("_data"));
                                if (!TextUtils.isEmpty(string)) {
                                    File file = new File(string);
                                    query.close();
                                    aVar = nVar.a(file, this.f6393j, this.f6394k, this.f6395l);
                                } else {
                                    throw new FileNotFoundException("File path was empty in media store for: " + uri);
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = query;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                } catch (Throwable th3) {
                    th = th3;
                }
            } else {
                aVar = this.f6391h.a(this.f6389f.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0 ? MediaStore.setRequireOriginal(this.f6392i) : this.f6392i, this.f6393j, this.f6394k, this.f6395l);
            }
            if (aVar != null) {
                return aVar.f6225c;
            }
            return null;
        }

        @Override // com.bumptech.glide.load.data.d
        public final void cancel() {
            this.f6396n = true;
            com.bumptech.glide.load.data.d<DataT> dVar = this.f6397o;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public final p2.a e() {
            return p2.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public final void f(i iVar, d.a<? super DataT> aVar) {
            try {
                com.bumptech.glide.load.data.d<DataT> c7 = c();
                if (c7 == null) {
                    aVar.c(new IllegalArgumentException("Failed to build fetcher for: " + this.f6392i));
                    return;
                }
                this.f6397o = c7;
                if (this.f6396n) {
                    cancel();
                } else {
                    c7.f(iVar, aVar);
                }
            } catch (FileNotFoundException e) {
                aVar.c(e);
            }
        }
    }

    public d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Class<DataT> cls) {
        this.f6382a = context.getApplicationContext();
        this.f6383b = nVar;
        this.f6384c = nVar2;
        this.f6385d = cls;
    }

    @Override // v2.n
    public final n.a a(Uri uri, int i7, int i8, h hVar) {
        Uri uri2 = uri;
        return new n.a(new j3.d(uri2), new C0129d(this.f6382a, this.f6383b, this.f6384c, uri2, i7, i8, hVar, this.f6385d));
    }

    @Override // v2.n
    public final boolean b(Uri uri) {
        return q2.a.D(uri);
    }
}
