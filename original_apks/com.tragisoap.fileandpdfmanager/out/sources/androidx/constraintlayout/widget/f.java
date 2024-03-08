package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f extends View {

    /* renamed from: f  reason: collision with root package name */
    public int f1418f;

    /* renamed from: g  reason: collision with root package name */
    public View f1419g;

    /* renamed from: h  reason: collision with root package name */
    public int f1420h;

    public View getContent() {
        return this.f1419g;
    }

    public int getEmptyVisibility() {
        return this.f1420h;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) rect.height()) / 2.0f) + (((float) height) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    public void setContentId(int i7) {
        View findViewById;
        if (this.f1418f != i7) {
            View view = this.f1419g;
            if (view != null) {
                view.setVisibility(0);
                ((ConstraintLayout.a) this.f1419g.getLayoutParams()).f1273f0 = false;
                this.f1419g = null;
            }
            this.f1418f = i7;
            if (i7 != -1 && (findViewById = ((View) getParent()).findViewById(i7)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public void setEmptyVisibility(int i7) {
        this.f1420h = i7;
    }
}
