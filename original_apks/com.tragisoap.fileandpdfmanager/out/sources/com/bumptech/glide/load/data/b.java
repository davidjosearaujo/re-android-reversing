package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.i;
import com.bumptech.glide.load.data.d;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import p2.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class b<T> implements d<T> {

    /* renamed from: f  reason: collision with root package name */
    public final String f2663f;

    /* renamed from: g  reason: collision with root package name */
    public final AssetManager f2664g;

    /* renamed from: h  reason: collision with root package name */
    public Closeable f2665h;

    public b(AssetManager assetManager, String str) {
        this.f2664g = assetManager;
        this.f2663f = str;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        Closeable closeable = this.f2665h;
        if (closeable != null) {
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
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
    }

    @Override // com.bumptech.glide.load.data.d
    public final a e() {
        return a.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(i iVar, d.a<? super T> aVar) {
        Closeable closeable;
        try {
            AssetManager assetManager = this.f2664g;
            String str = this.f2663f;
            switch (((h) this).f2677i) {
                case 0:
                    closeable = assetManager.openFd(str);
                    break;
                default:
                    closeable = assetManager.open(str);
                    break;
            }
            this.f2665h = closeable;
            aVar.d(closeable);
        } catch (IOException e) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            aVar.c(e);
        }
    }
}
