package com.google.android.material.timepicker;

import android.view.GestureDetector;
import android.view.MotionEvent;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimePickerView f3374a;

    public f(TimePickerView timePickerView) {
        this.f3374a = timePickerView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        TimePickerView timePickerView = this.f3374a;
        int i7 = TimePickerView.f3364w;
        timePickerView.getClass();
        return false;
    }
}
