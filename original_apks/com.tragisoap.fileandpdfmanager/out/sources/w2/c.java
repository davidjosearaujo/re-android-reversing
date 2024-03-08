package w2;

import android.content.Context;
import android.net.Uri;
import j3.d;
import java.io.InputStream;
import p2.h;
import q2.b;
import v2.n;
import v2.o;
import v2.r;
import y2.x;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6380a;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f6381a;

        public a(Context context) {
            this.f6381a = context;
        }

        @Override // v2.o
        public final n<Uri, InputStream> b(r rVar) {
            return new c(this.f6381a);
        }
    }

    public c(Context context) {
        this.f6380a = context.getApplicationContext();
    }

    @Override // v2.n
    public final n.a<InputStream> a(Uri uri, int i7, int i8, h hVar) {
        Uri uri2 = uri;
        boolean z6 = true;
        if (i7 != Integer.MIN_VALUE && i8 != Integer.MIN_VALUE && i7 <= 512 && i8 <= 384) {
            Long l6 = (Long) hVar.c(x.f6665d);
            if (l6 == null || l6.longValue() != -1) {
                z6 = false;
            }
            if (z6) {
                d dVar = new d(uri2);
                Context context = this.f6380a;
                return new n.a<>(dVar, b.c(context, uri2, new b.C0099b(context.getContentResolver())));
            }
        }
        return null;
    }

    @Override // v2.n
    public final boolean b(Uri uri) {
        Uri uri2 = uri;
        return q2.a.D(uri2) && uri2.getPathSegments().contains("video");
    }
}
