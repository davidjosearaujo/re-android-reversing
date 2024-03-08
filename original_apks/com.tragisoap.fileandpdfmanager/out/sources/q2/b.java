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
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b implements d<InputStream> {

    /* renamed from: f  reason: collision with root package name */
    public final Uri f5645f;

    /* renamed from: g  reason: collision with root package name */
    public final d f5646g;

    /* renamed from: h  reason: collision with root package name */
    public InputStream f5647h;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a implements c {

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f5648b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        public final ContentResolver f5649a;

        public a(ContentResolver contentResolver) {
            this.f5649a = contentResolver;
        }

        @Override // q2.c
        public final Cursor a(Uri uri) {
            return this.f5649a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f5648b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* renamed from: q2.b$b  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0099b implements c {

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f5650b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
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

    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 6, insn: 0x0023: MOVE  (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:10:0x0023
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVarsInBlock(SSATransform.java:171)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:143)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    public final java.io.InputStream d() {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
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
