package com.davemorrissey.labs.subscaleview.decoder;

import android.graphics.Bitmap;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class CompatDecoderFactory<T> implements DecoderFactory<T> {
    private final Bitmap.Config bitmapConfig;
    private final Class<? extends T> clazz;

    public CompatDecoderFactory(Class<? extends T> cls) {
        this(cls, null);
    }

    public CompatDecoderFactory(Class<? extends T> cls, Bitmap.Config config) {
        this.clazz = cls;
        this.bitmapConfig = config;
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.DecoderFactory
    public T make() {
        return this.bitmapConfig == null ? (T) this.clazz.newInstance() : (T) this.clazz.getConstructor(Bitmap.Config.class).newInstance(this.bitmapConfig);
    }
}
