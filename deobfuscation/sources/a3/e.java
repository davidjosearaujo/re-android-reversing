package a3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import p2.g;
import p2.h;
import p2.j;
import r2.v;

/* loaded from: classes.dex */
public final class e implements j<Uri, Drawable> {

    /* renamed from: b */
    public static final g<Resources.Theme> f126b = new g<>("com.bumptech.glide.load.resource.bitmap.Downsampler.Theme", null, g.e);

    /* renamed from: a */
    public final Context f127a;

    public e(Context context) {
        this.f127a = context.getApplicationContext();
    }

    @Override // p2.j
    public final boolean a(Uri uri, h hVar) {
        return uri.getScheme().equals("android.resource");
    }

    @Override // p2.j
    public final /* bridge */ /* synthetic */ v<Drawable> b(Uri uri, int i7, int i8, h hVar) {
        return c(uri, hVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:154:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final r2.v c(android.net.Uri r9, p2.h r10) {
        /*
            r8 = this;
            java.lang.String r0 = r9.getAuthority()
            android.content.Context r1 = r8.f127a
            java.lang.String r1 = r1.getPackageName()
            boolean r1 = r0.equals(r1)
            r2 = 0
            if (r1 == 0) goto L12
            goto L26
        L12:
            android.content.Context r1 = r8.f127a     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L19
            android.content.Context r1 = r1.createPackageContext(r0, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L19
            goto L28
        L19:
            r1 = move-exception
            android.content.Context r3 = r8.f127a
            java.lang.String r3 = r3.getPackageName()
            boolean r3 = r0.contains(r3)
            if (r3 == 0) goto Le7
        L26:
            android.content.Context r1 = r8.f127a
        L28:
            java.util.List r3 = r9.getPathSegments()
            int r4 = r3.size()
            r5 = 2
            r6 = 1
            if (r4 != r5) goto L76
            java.util.List r3 = r9.getPathSegments()
            java.lang.String r4 = r9.getAuthority()
            java.lang.Object r5 = r3.get(r2)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r3 = r3.get(r6)
            java.lang.String r3 = (java.lang.String) r3
            android.content.res.Resources r7 = r1.getResources()
            int r4 = r7.getIdentifier(r3, r5, r4)
            if (r4 != 0) goto L5c
            android.content.res.Resources r4 = android.content.res.Resources.getSystem()
            java.lang.String r7 = "android"
            int r4 = r4.getIdentifier(r3, r5, r7)
        L5c:
            if (r4 == 0) goto L5f
            goto L8c
        L5f:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Failed to find resource id for: "
            r10.append(r0)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        L76:
            int r3 = r3.size()
            java.lang.String r4 = "Unrecognized Uri format: "
            if (r3 != r6) goto Ld2
            java.util.List r3 = r9.getPathSegments()
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.NumberFormatException -> Lbc
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.NumberFormatException -> Lbc
            int r4 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.NumberFormatException -> Lbc
        L8c:
            p2.g<android.content.res.Resources$Theme> r9 = a3.e.f126b
            java.lang.Object r9 = r10.c(r9)
            android.content.res.Resources$Theme r9 = (android.content.res.Resources.Theme) r9
            java.lang.String r10 = r1.getPackageName()
            boolean r10 = r10.equals(r0)
            if (r10 != 0) goto La0
            if (r9 != 0) goto La1
        La0:
            r2 = r6
        La1:
            java.lang.String r10 = "Can't get a theme from another package"
            q2.a.h(r10, r2)
            android.content.Context r8 = r8.f127a
            r10 = 0
            if (r9 != 0) goto Lb0
            android.graphics.drawable.Drawable r8 = a3.b.a(r8, r1, r4, r10)
            goto Lb4
        Lb0:
            android.graphics.drawable.Drawable r8 = a3.b.a(r8, r8, r4, r9)
        Lb4:
            if (r8 == 0) goto Lbb
            a3.d r10 = new a3.d
            r10.<init>(r8)
        Lbb:
            return r10
        Lbc:
            r8 = move-exception
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r10.<init>(r9, r8)
            throw r10
        Ld2:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r4)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        Le7:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Failed to obtain context or unrecognized Uri format for: "
            r10.append(r0)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9, r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.e.c(android.net.Uri, p2.h):r2.v");
    }
}
