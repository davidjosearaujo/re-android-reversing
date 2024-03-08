package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class u extends RatingBar {

    /* renamed from: f  reason: collision with root package name */
    public final s f1042f;

    public u(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130904006);
        v0.a(this, getContext());
        s sVar = new s(this);
        this.f1042f = sVar;
        sVar.a(attributeSet, 2130904006);
    }

    @Override // android.widget.RatingBar, android.widget.ProgressBar, android.widget.AbsSeekBar, android.view.View
    public final synchronized void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        Bitmap bitmap = this.f1042f.f1030b;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i7, 0), getMeasuredHeight());
        }
    }
}
