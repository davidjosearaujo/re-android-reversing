package y2;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public final class b implements p2.k<Bitmap> {

    /* renamed from: g */
    public static final p2.g<Integer> f6599g = p2.g.a(90, "com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality");

    /* renamed from: h */
    public static final p2.g<Bitmap.CompressFormat> f6600h = new p2.g<>("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, p2.g.e);

    /* renamed from: f */
    public final s2.b f6601f;

    public b(s2.b bVar) {
        this.f6601f = bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:196:0x006a, code lost:
        if (r6 != null) goto L20;
     */
    @Override // p2.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean c(java.lang.Object r9, java.io.File r10, p2.h r11) {
        /*
            r8 = this;
            r2.v r9 = (r2.v) r9
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r9 = r9.get()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            p2.g<android.graphics.Bitmap$CompressFormat> r1 = y2.b.f6600h
            java.lang.Object r1 = r11.c(r1)
            android.graphics.Bitmap$CompressFormat r1 = (android.graphics.Bitmap.CompressFormat) r1
            if (r1 == 0) goto L15
            goto L20
        L15:
            boolean r1 = r9.hasAlpha()
            if (r1 == 0) goto L1e
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG
            goto L20
        L1e:
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG
        L20:
            r9.getWidth()
            r9.getHeight()
            int r2 = k3.h.f4702b     // Catch: java.lang.Throwable -> Lc4
            long r2 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch: java.lang.Throwable -> Lc4
            p2.g<java.lang.Integer> r4 = y2.b.f6599g     // Catch: java.lang.Throwable -> Lc4
            java.lang.Object r4 = r11.c(r4)     // Catch: java.lang.Throwable -> Lc4
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> Lc4
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> Lc4
            r5 = 0
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r7.<init>(r10)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            s2.b r10 = r8.f6601f     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L58
            if (r10 == 0) goto L4f
            com.bumptech.glide.load.data.c r10 = new com.bumptech.glide.load.data.c     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L58
            s2.b r8 = r8.f6601f     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L58
            r10.<init>(r7, r8)     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L58
            r6 = r10
            goto L50
        L4c:
            r8 = move-exception
            goto Lbe
        L4f:
            r6 = r7
        L50:
            r9.compress(r1, r4, r6)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r6.close()     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d
            r5 = 1
            goto L6c
        L58:
            r8 = move-exception
            r6 = r7
            goto L5e
        L5b:
            r8 = move-exception
            goto Lbd
        L5d:
            r8 = move-exception
        L5e:
            r10 = 3
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch: java.lang.Throwable -> L5b
            if (r10 == 0) goto L6a
            java.lang.String r10 = "Failed to encode Bitmap"
            android.util.Log.d(r0, r10, r8)     // Catch: java.lang.Throwable -> L5b
        L6a:
            if (r6 == 0) goto L6f
        L6c:
            r6.close()     // Catch: java.io.IOException -> L6f java.lang.Throwable -> Lc4
        L6f:
            r8 = 2
            boolean r8 = android.util.Log.isLoggable(r0, r8)     // Catch: java.lang.Throwable -> Lc4
            if (r8 == 0) goto Lbc
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc4
            r8.<init>()     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r10 = "Compressed with type: "
            r8.append(r10)     // Catch: java.lang.Throwable -> Lc4
            r8.append(r1)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r10 = " of size "
            r8.append(r10)     // Catch: java.lang.Throwable -> Lc4
            int r10 = k3.l.c(r9)     // Catch: java.lang.Throwable -> Lc4
            r8.append(r10)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r10 = " in "
            r8.append(r10)     // Catch: java.lang.Throwable -> Lc4
            double r1 = k3.h.a(r2)     // Catch: java.lang.Throwable -> Lc4
            r8.append(r1)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r10 = ", options format: "
            r8.append(r10)     // Catch: java.lang.Throwable -> Lc4
            p2.g<android.graphics.Bitmap$CompressFormat> r10 = y2.b.f6600h     // Catch: java.lang.Throwable -> Lc4
            java.lang.Object r10 = r11.c(r10)     // Catch: java.lang.Throwable -> Lc4
            r8.append(r10)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r10 = ", hasAlpha: "
            r8.append(r10)     // Catch: java.lang.Throwable -> Lc4
            boolean r9 = r9.hasAlpha()     // Catch: java.lang.Throwable -> Lc4
            r8.append(r9)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> Lc4
            android.util.Log.v(r0, r8)     // Catch: java.lang.Throwable -> Lc4
        Lbc:
            return r5
        Lbd:
            r7 = r6
        Lbe:
            if (r7 == 0) goto Lc3
            r7.close()     // Catch: java.io.IOException -> Lc3 java.lang.Throwable -> Lc4
        Lc3:
            throw r8     // Catch: java.lang.Throwable -> Lc4
        Lc4:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.b.c(java.lang.Object, java.io.File, p2.h):boolean");
    }

    @Override // p2.k
    public final p2.c d(p2.h hVar) {
        return p2.c.TRANSFORMED;
    }
}
