package com.hunantv.media.alpha;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface Renderer {
    void onDrawFrame(GL10 gl10);

    void onSurfaceChanged(GL10 gl10, int i, int i2);

    void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);

    void onSurfaceDestroyed(GL10 gl10);
}
