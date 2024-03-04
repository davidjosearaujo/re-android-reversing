package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: f */
    public final /* synthetic */ ClockFaceView f3367f;

    public a(ClockFaceView clockFaceView) {
        this.f3367f = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (this.f3367f.isShown()) {
            this.f3367f.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView clockFaceView = this.f3367f;
            int height = ((this.f3367f.getHeight() / 2) - clockFaceView.f3350y.f3355i) - clockFaceView.G;
            if (height != clockFaceView.f3371w) {
                clockFaceView.f3371w = height;
                clockFaceView.k();
                ClockHandView clockHandView = clockFaceView.f3350y;
                clockHandView.f3362q = clockFaceView.f3371w;
                clockHandView.invalidate();
            }
            return true;
        }
        return true;
    }
}
