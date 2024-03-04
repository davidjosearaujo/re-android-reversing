package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.load.data.d;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class b<T> implements d<T> {

    /* renamed from: f */
    public final String f2663f;

    /* renamed from: g */
    public final AssetManager f2664g;

    /* renamed from: h */
    public Closeable f2665h;

    public b(AssetManager assetManager, String str) {
        this.f2664g = assetManager;
        this.f2663f = str;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        Closeable closeable = this.f2665h;
        if (closeable == null) {
            return;
        }
        try {
            switch (((h) this).f2677i) {
                case 0:
                    ((AssetFileDescriptor) closeable).close();
                    break;
                default:
                    ((InputStream) closeable).close();
                    break;
            }
        } catch (IOException unused) {
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
    }

    @Override // com.bumptech.glide.load.data.d
    public final p2.a e() {
        return p2.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(com.bumptech.glide.i iVar, d.a<? super T> aVar) {
        Closeable openFd;
        try {
            AssetManager assetManager = this.f2664g;
            String str = this.f2663f;
            switch (((h) this).f2677i) {
                case 0:
                    openFd = assetManager.openFd(str);
                    break;
                default:
                    openFd = assetManager.open(str);
                    break;
            }
            this.f2665h = openFd;
            aVar.d(openFd);
        } catch (IOException e) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            aVar.c(e);
        }
    }
}
