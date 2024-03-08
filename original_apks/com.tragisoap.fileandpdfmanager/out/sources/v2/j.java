package v2;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.activity.h;
import com.bumptech.glide.i;
import com.bumptech.glide.load.data.d;
import java.io.File;
import java.io.FileNotFoundException;
import v2.n;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j implements n<Uri, File> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6213a;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a implements o<Uri, File> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f6214a;

        public a(Context context) {
            this.f6214a = context;
        }

        @Override // v2.o
        public final n<Uri, File> b(r rVar) {
            return new j(this.f6214a);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b implements d<File> {

        /* renamed from: h  reason: collision with root package name */
        public static final String[] f6215h = {"_data"};

        /* renamed from: f  reason: collision with root package name */
        public final Context f6216f;

        /* renamed from: g  reason: collision with root package name */
        public final Uri f6217g;

        public b(Context context, Uri uri) {
            this.f6216f = context;
            this.f6217g = uri;
        }

        @Override // com.bumptech.glide.load.data.d
        public final Class<File> a() {
            return File.class;
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
        public final void f(i iVar, d.a<? super File> aVar) {
            Cursor query = this.f6216f.getContentResolver().query(this.f6217g, f6215h, null, null, null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                StringBuilder d7 = h.d("Failed to find file path for: ");
                d7.append(this.f6217g);
                aVar.c(new FileNotFoundException(d7.toString()));
                return;
            }
            aVar.d(new File(str));
        }
    }

    public j(Context context) {
        this.f6213a = context;
    }

    @Override // v2.n
    public final n.a<File> a(Uri uri, int i7, int i8, p2.h hVar) {
        Uri uri2 = uri;
        return new n.a<>(new j3.d(uri2), new b(this.f6213a, uri2));
    }

    @Override // v2.n
    public final boolean b(Uri uri) {
        return q2.a.D(uri);
    }
}
