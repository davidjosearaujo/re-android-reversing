package v2;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class t<Data> implements n<String, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final n<Uri, Data> f6253a;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a implements o<String, AssetFileDescriptor> {
        @Override // v2.o
        public final n<String, AssetFileDescriptor> b(r rVar) {
            return new t(rVar.b(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b implements o<String, ParcelFileDescriptor> {
        @Override // v2.o
        public final n<String, ParcelFileDescriptor> b(r rVar) {
            return new t(rVar.b(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c implements o<String, InputStream> {
        @Override // v2.o
        public final n<String, InputStream> b(r rVar) {
            return new t(rVar.b(Uri.class, InputStream.class));
        }
    }

    public t(n<Uri, Data> nVar) {
        this.f6253a = nVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r0.getScheme() == null) goto L_0x001f;
     */
    @Override // v2.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final v2.n.a a(java.lang.String r4, int r5, int r6, p2.h r7) {
        /*
            r3 = this;
            java.lang.String r4 = (java.lang.String) r4
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L_0x000b
            r0 = r1
            goto L_0x0028
        L_0x000b:
            r0 = 0
            char r0 = r4.charAt(r0)
            r2 = 47
            if (r0 != r2) goto L_0x0015
            goto L_0x001f
        L_0x0015:
            android.net.Uri r0 = android.net.Uri.parse(r4)
            java.lang.String r2 = r0.getScheme()
            if (r2 != 0) goto L_0x0028
        L_0x001f:
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            android.net.Uri r0 = android.net.Uri.fromFile(r0)
        L_0x0028:
            if (r0 == 0) goto L_0x0039
            v2.n<android.net.Uri, Data> r4 = r3.f6253a
            boolean r4 = r4.b(r0)
            if (r4 != 0) goto L_0x0033
            goto L_0x0039
        L_0x0033:
            v2.n<android.net.Uri, Data> r3 = r3.f6253a
            v2.n$a r1 = r3.a(r0, r5, r6, r7)
        L_0x0039:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: v2.t.a(java.lang.Object, int, int, p2.h):v2.n$a");
    }

    @Override // v2.n
    public final /* bridge */ /* synthetic */ boolean b(String str) {
        return true;
    }
}
