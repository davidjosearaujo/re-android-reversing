package d4;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.l0;
import l0.z;
import linc.com.amplituda.ErrorCode;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class g extends l0 {

    /* renamed from: u  reason: collision with root package name */
    public Drawable f3603u;

    /* renamed from: v  reason: collision with root package name */
    public final Rect f3604v;

    /* renamed from: w  reason: collision with root package name */
    public final Rect f3605w;

    /* renamed from: x  reason: collision with root package name */
    public int f3606x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f3607y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f3608z;

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public g(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, 0);
        this.f3604v = new Rect();
        this.f3605w = new Rect();
        this.f3606x = 119;
        this.f3607y = true;
        this.f3608z = false;
        TypedArray d7 = n.d(context, attributeSet, z.f4923i, 0, 0, new int[0]);
        this.f3606x = d7.getInt(1, this.f3606x);
        Drawable drawable = d7.getDrawable(0);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f3607y = d7.getBoolean(2, true);
        d7.recycle();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f3603u;
        if (drawable != null) {
            if (this.f3608z) {
                this.f3608z = false;
                Rect rect = this.f3604v;
                Rect rect2 = this.f3605w;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f3607y) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f3606x, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @TargetApi(ErrorCode.FILE_NOT_FOUND_IO_CODE)
    public final void drawableHotspotChanged(float f7, float f8) {
        super.drawableHotspotChanged(f7, f8);
        Drawable drawable = this.f3603u;
        if (drawable != null) {
            drawable.setHotspot(f7, f8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f3603u;
        if (drawable != null && drawable.isStateful()) {
            this.f3603u.setState(getDrawableState());
        }
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f3603u;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f3606x;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f3603u;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.l0, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        super.onLayout(z6, i7, i8, i9, i10);
        this.f3608z = z6 | this.f3608z;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i7, int i8, int i9, int i10) {
        super.onSizeChanged(i7, i8, i9, i10);
        this.f3608z = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f3603u;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f3603u);
            }
            this.f3603u = drawable;
            this.f3608z = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f3606x == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i7) {
        if (this.f3606x != i7) {
            if ((8388615 & i7) == 0) {
                i7 |= 8388611;
            }
            if ((i7 & 112) == 0) {
                i7 |= 48;
            }
            this.f3606x = i7;
            if (i7 == 119 && this.f3603u != null) {
                this.f3603u.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3603u;
    }
}
