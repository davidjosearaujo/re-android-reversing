package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* loaded from: classes.dex */
public final class w extends SeekBar {

    /* renamed from: f */
    public final x f1063f;

    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130904033);
        v0.a(this, getContext());
        x xVar = new x(this);
        this.f1063f = xVar;
        xVar.a(attributeSet, 2130904033);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        x xVar = this.f1063f;
        Drawable drawable = xVar.e;
        if (drawable != null && drawable.isStateful() && drawable.setState(xVar.f1064d.getDrawableState())) {
            xVar.f1064d.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1063f.e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1063f.d(canvas);
    }
}
