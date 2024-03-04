package q2;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.i;
import com.bumptech.glide.load.data.d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class b implements com.bumptech.glide.load.data.d<InputStream> {

    /* renamed from: f */
    public final Uri f5645f;

    /* renamed from: g */
    public final d f5646g;

    /* renamed from: h */
    public InputStream f5647h;

    /* loaded from: classes.dex */
    public static class a implements c {

        /* renamed from: b */
        public static final String[] f5648b = {"_data"};

        /* renamed from: a */
        public final ContentResolver f5649a;

        public a(ContentResolver contentResolver) {
            this.f5649a = contentResolver;
        }

        @Override // q2.c
        public final Cursor a(Uri uri) {
            return this.f5649a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f5648b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* renamed from: q2.b$b */
    /* loaded from: classes.dex */
    public static class C0099b implements c {

        /* renamed from: b */
        public static final String[] f5650b = {"_data"};

        /* renamed from: a */
        public final ContentResolver f5651a;

        public C0099b(ContentResolver contentResolver) {
            this.f5651a = contentResolver;
        }

        @Override // q2.c
        public final Cursor a(Uri uri) {
            return this.f5651a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f5650b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    public b(Uri uri, d dVar) {
        this.f5645f = uri;
        this.f5646g = dVar;
    }

    public static b c(Context context, Uri uri, c cVar) {
        return new b(uri, new d(com.bumptech.glide.b.b(context).f2625h.a().d(), cVar, com.bumptech.glide.b.b(context).f2626i, context.getContentResolver()));
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        InputStream inputStream = this.f5647h;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:265:0x0028, code lost:
        if (r6 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x004b, code lost:
        if (r6 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x004d, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0050, code lost:
        r7 = null;
     */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0023: MOVE  (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:262:0x0023 */
    /* JADX WARN: Removed duplicated region for block: B:291:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:335:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.InputStream d() {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.b.d():java.io.InputStream");
    }

    @Override // com.bumptech.glide.load.data.d
    public final p2.a e() {
        return p2.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(i iVar, d.a<? super InputStream> aVar) {
        try {
            InputStream d7 = d();
            this.f5647h = d7;
            aVar.d(d7);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e);
            }
            aVar.c(e);
        }
    }
}
