package n;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class b extends Drawable {

    /* renamed from: a */
    public float f5095a;

    /* renamed from: c */
    public final RectF f5097c;

    /* renamed from: d */
    public final Rect f5098d;
    public float e;

    /* renamed from: h */
    public ColorStateList f5101h;

    /* renamed from: i */
    public PorterDuffColorFilter f5102i;

    /* renamed from: j */
    public ColorStateList f5103j;

    /* renamed from: f */
    public boolean f5099f = false;

    /* renamed from: g */
    public boolean f5100g = true;

    /* renamed from: k */
    public PorterDuff.Mode f5104k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    public final Paint f5096b = new Paint(5);

    public b(float f7, ColorStateList colorStateList) {
        this.f5095a = f7;
        b(colorStateList);
        this.f5097c = new RectF();
        this.f5098d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f5101h = colorStateList;
        this.f5096b.setColor(colorStateList.getColorForState(getState(), this.f5101h.getDefaultColor()));
    }

    public final void c(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f5097c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f5098d.set(rect);
        if (this.f5099f) {
            float f7 = this.e;
            float f8 = this.f5095a;
            boolean z6 = this.f5100g;
            float f9 = 1.5f * f7;
            if (z6) {
                f9 = (float) (((1.0d - c.f5105a) * f8) + f9);
            } else {
                int i7 = c.f5106b;
            }
            if (z6) {
                f7 = (float) (((1.0d - c.f5105a) * f8) + f7);
            }
            this.f5098d.inset((int) Math.ceil(f7), (int) Math.ceil(f9));
            this.f5097c.set(this.f5098d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z6;
        Paint paint = this.f5096b;
        if (this.f5102i == null || paint.getColorFilter() != null) {
            z6 = false;
        } else {
            paint.setColorFilter(this.f5102i);
            z6 = true;
        }
        RectF rectF = this.f5097c;
        float f7 = this.f5095a;
        canvas.drawRoundRect(rectF, f7, f7, paint);
        if (z6) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.f5098d, this.f5095a);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f5103j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f5101h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        c(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f5101h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z6 = colorForState != this.f5096b.getColor();
        if (z6) {
            this.f5096b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f5103j;
        if (colorStateList2 == null || (mode = this.f5104k) == null) {
            return z6;
        }
        this.f5102i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i7) {
        this.f5096b.setAlpha(i7);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f5096b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.f5103j = colorStateList;
        this.f5102i = a(colorStateList, this.f5104k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.f5104k = mode;
        this.f5102i = a(this.f5103j, mode);
        invalidateSelf();
    }
}
