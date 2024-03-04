package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public final class e extends View {

    /* renamed from: f */
    public boolean f1417f;

    public e(Context context) {
        super(context);
        this.f1417f = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public final void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void onMeasure(int i7, int i8) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z6) {
        this.f1417f = z6;
    }

    public void setGuidelineBegin(int i7) {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        if (this.f1417f && aVar.f1263a == i7) {
            return;
        }
        aVar.f1263a = i7;
        setLayoutParams(aVar);
    }

    public void setGuidelineEnd(int i7) {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        if (this.f1417f && aVar.f1265b == i7) {
            return;
        }
        aVar.f1265b = i7;
        setLayoutParams(aVar);
    }

    public void setGuidelinePercent(float f7) {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        if (this.f1417f && aVar.f1267c == f7) {
            return;
        }
        aVar.f1267c = f7;
        setLayoutParams(aVar);
    }

    @Override // android.view.View
    public void setVisibility(int i7) {
    }
}
