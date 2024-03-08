package com.google.android.material.timepicker;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g implements View.OnTouchListener {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ GestureDetector f3375f;

    public g(GestureDetector gestureDetector) {
        this.f3375f = gestureDetector;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (((Checkable) view).isChecked()) {
            return this.f3375f.onTouchEvent(motionEvent);
        }
        return false;
    }
}
