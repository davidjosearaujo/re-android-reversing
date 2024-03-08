package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import java.io.InputStream;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h extends b {

    /* renamed from: i */
    public final /* synthetic */ int f2677i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(AssetManager assetManager, String str, int i7) {
        super(assetManager, str);
        this.f2677i = i7;
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        switch (this.f2677i) {
            case 0:
                return AssetFileDescriptor.class;
            default:
                return InputStream.class;
        }
    }
}
