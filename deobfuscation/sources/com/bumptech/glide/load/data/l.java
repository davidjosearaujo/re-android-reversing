package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.load.data.d;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
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
    public final p2.a e() {
        return p2.a.LOCAL;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [T, java.lang.Object] */
    @Override // com.bumptech.glide.load.data.d
    public final void f(com.bumptech.glide.i iVar, d.a<? super T> aVar) {
        try {
            ?? r22 = (T) d(this.f2686g, this.f2685f);
            this.f2687h = r22;
            aVar.d(r22);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e);
            }
            aVar.c(e);
        }
    }
}
