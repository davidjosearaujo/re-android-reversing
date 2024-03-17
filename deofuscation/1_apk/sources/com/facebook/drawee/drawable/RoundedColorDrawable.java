package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imageutils.JfifUtil;
import java.util.Arrays;
import javax.annotation.Nullable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class RoundedColorDrawable extends Drawable implements Rounded {
    private int mAlpha;
    private int mBorderColor;
    @VisibleForTesting
    public final Path mBorderPath;
    @VisibleForTesting
    public final float[] mBorderRadii;
    private float mBorderWidth;
    private int mColor;
    @VisibleForTesting
    @Nullable
    public float[] mInsideBorderRadii;
    private boolean mIsCircle;
    private float mPadding;
    @VisibleForTesting
    public final Paint mPaint;
    @VisibleForTesting
    public final Path mPath;
    private final float[] mRadii;
    private boolean mScaleDownInsideBorders;
    private final RectF mTempRect;

    public RoundedColorDrawable(int i) {
        this.mRadii = new float[8];
        this.mBorderRadii = new float[8];
        this.mPaint = new Paint(1);
        this.mIsCircle = false;
        this.mBorderWidth = 0.0f;
        this.mPadding = 0.0f;
        this.mBorderColor = 0;
        this.mScaleDownInsideBorders = false;
        this.mPath = new Path();
        this.mBorderPath = new Path();
        this.mColor = 0;
        this.mTempRect = new RectF();
        this.mAlpha = JfifUtil.MARKER_FIRST_BYTE;
        setColor(i);
    }

    @TargetApi(11)
    public static RoundedColorDrawable fromColorDrawable(ColorDrawable colorDrawable) {
        return new RoundedColorDrawable(colorDrawable.getColor());
    }

    private void updatePath() {
        float[] fArr;
        float[] fArr2;
        this.mPath.reset();
        this.mBorderPath.reset();
        this.mTempRect.set(getBounds());
        RectF rectF = this.mTempRect;
        float f = this.mBorderWidth;
        rectF.inset(f / 2.0f, f / 2.0f);
        int i = 0;
        if (this.mIsCircle) {
            this.mBorderPath.addCircle(this.mTempRect.centerX(), this.mTempRect.centerY(), Math.min(this.mTempRect.width(), this.mTempRect.height()) / 2.0f, Path.Direction.CW);
        } else {
            int i2 = 0;
            while (true) {
                fArr = this.mBorderRadii;
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = (this.mRadii[i2] + this.mPadding) - (this.mBorderWidth / 2.0f);
                i2++;
            }
            this.mBorderPath.addRoundRect(this.mTempRect, fArr, Path.Direction.CW);
        }
        RectF rectF2 = this.mTempRect;
        float f2 = this.mBorderWidth;
        rectF2.inset((-f2) / 2.0f, (-f2) / 2.0f);
        float f3 = this.mPadding + (this.mScaleDownInsideBorders ? this.mBorderWidth : 0.0f);
        this.mTempRect.inset(f3, f3);
        if (this.mIsCircle) {
            this.mPath.addCircle(this.mTempRect.centerX(), this.mTempRect.centerY(), Math.min(this.mTempRect.width(), this.mTempRect.height()) / 2.0f, Path.Direction.CW);
        } else if (this.mScaleDownInsideBorders) {
            if (this.mInsideBorderRadii == null) {
                this.mInsideBorderRadii = new float[8];
            }
            while (true) {
                fArr2 = this.mInsideBorderRadii;
                if (i >= fArr2.length) {
                    break;
                }
                fArr2[i] = this.mRadii[i] - this.mBorderWidth;
                i++;
            }
            this.mPath.addRoundRect(this.mTempRect, fArr2, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.mTempRect, this.mRadii, Path.Direction.CW);
        }
        float f4 = -f3;
        this.mTempRect.inset(f4, f4);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.mBorderPath, this.mPaint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public int getBorderColor() {
        return this.mBorderColor;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public int getColor() {
        return this.mColor;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return DrawableUtils.getOpacityFromColor(DrawableUtils.multiplyColorAlpha(this.mColor, this.mAlpha));
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getPadding() {
        return this.mPadding;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float[] getRadii() {
        return this.mRadii;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean getScaleDownInsideBorders() {
        return this.mScaleDownInsideBorders;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean isCircle() {
        return this.mIsCircle;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        updatePath();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.mAlpha) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setBorder(int i, float f) {
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
            invalidateSelf();
        }
        if (this.mBorderWidth != f) {
            this.mBorderWidth = f;
            updatePath();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setCircle(boolean z) {
        this.mIsCircle = z;
        updatePath();
        invalidateSelf();
    }

    public void setColor(int i) {
        if (this.mColor != i) {
            this.mColor = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setPadding(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            updatePath();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadii(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.mRadii, 0.0f);
        } else {
            Preconditions.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.mRadii, 0, 8);
        }
        updatePath();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadius(float f) {
        Preconditions.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.mRadii, f);
        updatePath();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setScaleDownInsideBorders(boolean z) {
        if (this.mScaleDownInsideBorders != z) {
            this.mScaleDownInsideBorders = z;
            updatePath();
            invalidateSelf();
        }
    }

    public RoundedColorDrawable(float[] fArr, int i) {
        this(i);
        setRadii(fArr);
    }

    public RoundedColorDrawable(float f, int i) {
        this(i);
        setRadius(f);
    }
}