package com.google.android.material.timepicker;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import p1.a;
import q1.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b extends a {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f3368d;

    public b(ClockFaceView clockFaceView) {
        this.f3368d = clockFaceView;
    }

    @Override // p1.a
    public final void d(View view, f fVar) {
        this.f5466a.onInitializeAccessibilityNodeInfo(view, fVar.f5624a);
        int intValue = ((Integer) view.getTag(2131296617)).intValue();
        if (intValue > 0) {
            fVar.f5624a.setTraversalAfter(this.f3368d.C.get(intValue - 1));
        }
        fVar.j(f.g.a(0, 1, intValue, 1, view.isSelected()));
        fVar.f5624a.setClickable(true);
        fVar.b(f.a.e);
    }

    @Override // p1.a
    public final boolean g(View view, int i7, Bundle bundle) {
        if (i7 != 16) {
            return super.g(view, i7, bundle);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        view.getHitRect(this.f3368d.f3351z);
        float centerX = (float) this.f3368d.f3351z.centerX();
        float centerY = (float) this.f3368d.f3351z.centerY();
        this.f3368d.f3350y.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, centerX, centerY, 0));
        this.f3368d.f3350y.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 1, centerX, centerY, 0));
        return true;
    }
}
