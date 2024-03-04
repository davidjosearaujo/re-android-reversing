package y3;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public final class a implements View.OnTouchListener {

    /* renamed from: f */
    public final Dialog f6674f;

    /* renamed from: g */
    public final int f6675g;

    /* renamed from: h */
    public final int f6676h;

    public a(Dialog dialog, Rect rect) {
        this.f6674f = dialog;
        this.f6675g = rect.left;
        this.f6676h = rect.top;
        ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = findViewById.getLeft() + this.f6675g;
        int width = findViewById.getWidth() + left;
        int top = findViewById.getTop() + this.f6676h;
        if (new RectF(left, top, width, findViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        view.performClick();
        return this.f6674f.onTouchEvent(obtain);
    }
}
