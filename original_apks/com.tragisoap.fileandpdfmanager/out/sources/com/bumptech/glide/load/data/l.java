package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import java.io.IOException;
import p2.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class l<T> implements d<T> {

    /* renamed from: f */
    public final Uri f2685f;

    /* renamed from: g */
    public final ContentResolver f2686g;

    /* renamed from: h */
    public T f2687h;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f2686g = contentResolver;
        this.f2685f = uri;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        T t5 = this.f2687h;
        if (t5 != null) {
            try {
                c(t5);
            } catch (IOException unused) {
            }
        }
    }

    public abstract void c(T t5);

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
    }

    public abstract Object d(ContentResolver contentResolver, Uri uri);

    @Override // com.bumptech.glide.load.data.d
    public final a e() {
        return a.LOCAL;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [T, java.lang.Object] */
    /* JADX WARN: Unknown variable types count: 1 */
    @Override // com.bumptech.glide.load.data.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(com.bumptech.glide.i r2, com.bumptech.glide.load.data.d.a<? super T> r3) {
        /*
            r1 = this;
            android.net.Uri r2 = r1.f2685f     // Catch: FileNotFoundException -> 0x000e
            android.content.ContentResolver r0 = r1.f2686g     // Catch: FileNotFoundException -> 0x000e
            java.lang.Object r2 = r1.d(r0, r2)     // Catch: FileNotFoundException -> 0x000e
            r1.f2687h = r2     // Catch: FileNotFoundException -> 0x000e
            r3.d(r2)     // Catch: FileNotFoundException -> 0x000e
            goto L_0x0020
        L_0x000e:
            r1 = move-exception
            r2 = 3
            java.lang.String r0 = "LocalUriFetcher"
            boolean r2 = android.util.Log.isLoggable(r0, r2)
            if (r2 == 0) goto L_0x001d
            java.lang.String r2 = "Failed to open Uri"
            android.util.Log.d(r0, r2, r1)
        L_0x001d:
            r3.c(r1)
        L_0x0020:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.l.f(com.bumptech.glide.i, com.bumptech.glide.load.data.d$a):void");
    }
}
