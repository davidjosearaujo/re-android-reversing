package com.hunantv.media.alpha;

import android.view.View;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface IAlphaRenderView {
    int getHeight();

    View getView();

    int getWidth();

    void setAspectRatio(int i);

    void setEGLConfigChooser(int i, int i2, int i3, int i4, int i5, int i6);

    void setEGLContextClientVersion(int i);

    void setOpaque(boolean z);

    void setPreserveEGLContextOnPause(boolean z);

    void setRenderer(Renderer renderer);

    void setVideoSize(int i, int i2);

    void setVisibility(int i);
}
