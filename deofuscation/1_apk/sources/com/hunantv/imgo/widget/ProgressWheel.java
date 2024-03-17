package com.hunantv.imgo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.hunantv.imgo.nightmode.view.SkinnableView;
import j.l.a.a0.b;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ProgressWheel extends SkinnableView {
    private static final int v = 16;
    private static final int w = 270;
    private static final long x = 200;
    private int a;
    private int b;
    private int c;
    private boolean d;
    private double e;
    private double f;
    private float g;
    private boolean h;
    private long i;
    private int j;
    private int k;
    private Paint l;
    private Paint m;
    private RectF n;
    private float o;
    private long p;
    private boolean q;
    private float r;
    private float s;
    private boolean t;
    private b u;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class WheelSavedState implements Parcelable {
        public static final Parcelable.Creator<WheelSavedState> CREATOR = new a();
        public int barColor;
        public int barWidth;
        public int circleRadius;
        public boolean fillRadius;
        public boolean isSpinning;
        public boolean linearProgress;
        public float mProgress;
        private final Parcelable mSuperState;
        public float mTargetProgress;
        public int rimColor;
        public int rimWidth;
        public float spinSpeed;

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class a implements Parcelable.Creator<WheelSavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public WheelSavedState createFromParcel(Parcel parcel) {
                return new WheelSavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public WheelSavedState[] newArray(int i) {
                return new WheelSavedState[i];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final Parcelable getSuperState() {
            return this.mSuperState;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.mSuperState, i);
            parcel.writeFloat(this.mProgress);
            parcel.writeFloat(this.mTargetProgress);
            parcel.writeByte(this.isSpinning ? (byte) 1 : (byte) 0);
            parcel.writeFloat(this.spinSpeed);
            parcel.writeInt(this.barWidth);
            parcel.writeInt(this.barColor);
            parcel.writeInt(this.rimWidth);
            parcel.writeInt(this.rimColor);
            parcel.writeInt(this.circleRadius);
            parcel.writeByte(this.linearProgress ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.fillRadius ? (byte) 1 : (byte) 0);
        }

        public WheelSavedState(Parcelable parcelable) {
            if (parcelable != null) {
                this.mSuperState = parcelable == View.BaseSavedState.EMPTY_STATE ? null : parcelable;
                return;
            }
            throw new IllegalArgumentException("superState must not be null");
        }

        private WheelSavedState(Parcel parcel) {
            Parcelable readParcelable = parcel.readParcelable(getClass().getClassLoader());
            this.mSuperState = readParcelable == null ? View.BaseSavedState.EMPTY_STATE : readParcelable;
            this.mProgress = parcel.readFloat();
            this.mTargetProgress = parcel.readFloat();
            this.isSpinning = parcel.readByte() != 0;
            this.spinSpeed = parcel.readFloat();
            this.barWidth = parcel.readInt();
            this.barColor = parcel.readInt();
            this.rimWidth = parcel.readInt();
            this.rimColor = parcel.readInt();
            this.circleRadius = parcel.readInt();
            this.linearProgress = parcel.readByte() != 0;
            this.fillRadius = parcel.readByte() != 0;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface b {
        void onProgressUpdate(float f);
    }

    public ProgressWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 28;
        this.b = 4;
        this.c = 4;
        this.d = false;
        this.e = 0.0d;
        this.f = 460.0d;
        this.g = 0.0f;
        this.h = true;
        this.i = 0L;
        this.j = -1442840576;
        this.k = 16777215;
        this.l = new Paint();
        this.m = new Paint();
        this.n = new RectF();
        this.o = 230.0f;
        this.p = 0L;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = false;
        d(context.obtainStyledAttributes(attributeSet, b.r.ProgressWheel));
    }

    private void d(TypedArray typedArray) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.b = (int) TypedValue.applyDimension(1, this.b, displayMetrics);
        this.c = (int) TypedValue.applyDimension(1, this.c, displayMetrics);
        int applyDimension = (int) TypedValue.applyDimension(1, this.a, displayMetrics);
        this.a = applyDimension;
        this.a = (int) typedArray.getDimension(b.r.ProgressWheel_matProg_circleRadius, applyDimension);
        this.d = typedArray.getBoolean(b.r.ProgressWheel_matProg_fillRadius, false);
        this.b = (int) typedArray.getDimension(b.r.ProgressWheel_matProg_barWidth, this.b);
        this.c = (int) typedArray.getDimension(b.r.ProgressWheel_matProg_rimWidth, this.c);
        this.o = typedArray.getFloat(b.r.ProgressWheel_matProg_spinSpeed, this.o / 360.0f) * 360.0f;
        this.f = typedArray.getInt(b.r.ProgressWheel_matProg_barSpinCycleTime, (int) this.f);
        this.j = typedArray.getColor(b.r.ProgressWheel_matProg_barColor, this.j);
        this.k = typedArray.getColor(b.r.ProgressWheel_matProg_rimColor, this.k);
        this.q = typedArray.getBoolean(b.r.ProgressWheel_matProg_linearProgress, false);
        if (typedArray.getBoolean(b.r.ProgressWheel_matProg_progressIndeterminate, false)) {
            i();
        }
        typedArray.recycle();
    }

    private void f() {
        if (this.u != null) {
            this.u.onProgressUpdate(Math.round((this.r * 100.0f) / 360.0f) / 100.0f);
        }
    }

    private void g(int i, int i2) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (!this.d) {
            int i3 = (i - paddingLeft) - paddingRight;
            int min = Math.min(Math.min(i3, (i2 - paddingBottom) - paddingTop), (this.a * 2) - (this.b * 2));
            int i4 = ((i3 - min) / 2) + paddingLeft;
            int i5 = ((((i2 - paddingTop) - paddingBottom) - min) / 2) + paddingTop;
            int i6 = this.b;
            this.n = new RectF(i4 + i6, i5 + i6, (i4 + min) - i6, (i5 + min) - i6);
            return;
        }
        int i7 = this.b;
        this.n = new RectF(paddingLeft + i7, paddingTop + i7, (i - paddingRight) - i7, (i2 - paddingBottom) - i7);
    }

    private void h() {
        this.l.setColor(this.j);
        this.l.setAntiAlias(true);
        this.l.setStyle(Paint.Style.STROKE);
        this.l.setStrokeWidth(this.b);
        this.m.setColor(this.k);
        this.m.setAntiAlias(true);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setStrokeWidth(this.c);
    }

    private void k(long j) {
        long j2 = this.i;
        if (j2 >= x) {
            double d = this.e;
            double d2 = j;
            Double.isNaN(d2);
            double d3 = d + d2;
            this.e = d3;
            double d4 = this.f;
            if (d3 > d4) {
                this.e = d3 - d4;
                this.i = 0L;
                this.h = !this.h;
            }
            float cos = (((float) Math.cos(((this.e / d4) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
            if (this.h) {
                this.g = cos * 254.0f;
                return;
            }
            float f = (1.0f - cos) * 254.0f;
            this.r += this.g - f;
            this.g = f;
            return;
        }
        this.i = j2 + j;
    }

    public boolean c() {
        return this.t;
    }

    public void e() {
        this.r = 0.0f;
        this.s = 0.0f;
        invalidate();
    }

    public int getBarColor() {
        return this.j;
    }

    public int getBarWidth() {
        return this.b;
    }

    public int getCircleRadius() {
        return this.a;
    }

    public float getProgress() {
        if (this.t) {
            return -1.0f;
        }
        return this.r / 360.0f;
    }

    public int getRimColor() {
        return this.k;
    }

    public int getRimWidth() {
        return this.c;
    }

    public float getSpinSpeed() {
        return this.o / 360.0f;
    }

    public void i() {
        this.p = SystemClock.uptimeMillis();
        this.t = true;
        invalidate();
    }

    public void j() {
        this.t = false;
        this.r = 0.0f;
        this.s = 0.0f;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        super.onDraw(canvas);
        canvas.drawArc(this.n, 360.0f, 360.0f, false, this.m);
        float f3 = 0.0f;
        boolean z = true;
        if (this.t) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.p;
            k(uptimeMillis);
            float f4 = this.r + ((((float) uptimeMillis) * this.o) / 1000.0f);
            this.r = f4;
            if (Float.compare(f4, 360.0f) > 0) {
                this.r -= 360.0f;
            }
            this.p = SystemClock.uptimeMillis();
            float f5 = this.r - 90.0f;
            float f6 = this.g + 16.0f;
            if (isInEditMode()) {
                f = 0.0f;
                f2 = 135.0f;
            } else {
                f = f5;
                f2 = f6;
            }
            canvas.drawArc(this.n, f, f2, false, this.l);
        } else {
            float f7 = this.r;
            if (Float.compare(f7, this.s) != 0) {
                this.r = Math.min(this.r + ((((float) (SystemClock.uptimeMillis() - this.p)) / 1000.0f) * this.o), this.s);
                this.p = SystemClock.uptimeMillis();
            } else {
                z = false;
            }
            if (Float.compare(f7, this.r) != 0) {
                f();
            }
            float f8 = this.r;
            if (!this.q) {
                float pow = ((float) (1.0d - Math.pow(1.0f - (this.r / 360.0f), 2.0f))) * 360.0f;
                f3 = ((float) (1.0d - Math.pow(1.0f - (f8 / 360.0f), 4.0f))) * 360.0f;
                f8 = pow;
            }
            canvas.drawArc(this.n, f3 - 90.0f, isInEditMode() ? 360.0f : f8, false, this.l);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingLeft = this.a + getPaddingLeft() + getPaddingRight();
        int paddingTop = this.a + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            paddingLeft = size;
        } else if (mode == Integer.MIN_VALUE) {
            paddingLeft = Math.min(paddingLeft, size);
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            paddingTop = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            paddingTop = Math.min(paddingTop, size2);
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        g(i, i2);
        h();
        invalidate();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.p = SystemClock.uptimeMillis();
        }
    }

    public void setBarColor(int i) {
        this.j = i;
        h();
        if (this.t) {
            return;
        }
        invalidate();
    }

    public void setBarWidth(int i) {
        this.b = i;
        if (this.t) {
            return;
        }
        invalidate();
    }

    public void setCallback(b bVar) {
        this.u = bVar;
        if (this.t) {
            return;
        }
        f();
    }

    public void setCircleRadius(int i) {
        this.a = i;
        if (this.t) {
            return;
        }
        invalidate();
    }

    public void setInstantProgress(float f) {
        if (this.t) {
            this.r = 0.0f;
            this.t = false;
        }
        if (Float.compare(f, 1.0f) > 0) {
            f -= 1.0f;
        } else if (Float.compare(f, 0.0f) < 0) {
            f = 0.0f;
        }
        if (Float.compare(f, this.s) == 0) {
            return;
        }
        float min = Math.min(f * 360.0f, 360.0f);
        this.s = min;
        this.r = min;
        this.p = SystemClock.uptimeMillis();
        invalidate();
    }

    public void setLinearProgress(boolean z) {
        this.q = z;
        if (this.t) {
            return;
        }
        invalidate();
    }

    public void setProgress(float f) {
        if (this.t) {
            this.r = 0.0f;
            this.t = false;
            f();
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (Float.compare(f, this.s) == 0) {
            return;
        }
        if (Float.compare(this.r, this.s) == 0) {
            this.p = SystemClock.uptimeMillis();
        }
        this.s = Math.min(f * 360.0f, 360.0f);
        invalidate();
    }

    public void setRimColor(int i) {
        this.k = i;
        h();
        if (this.t) {
            return;
        }
        invalidate();
    }

    public void setRimWidth(int i) {
        this.c = i;
        if (this.t) {
            return;
        }
        invalidate();
    }

    public void setSpinSpeed(float f) {
        this.o = f * 360.0f;
    }

    public ProgressWheel(Context context) {
        super(context);
        this.a = 28;
        this.b = 4;
        this.c = 4;
        this.d = false;
        this.e = 0.0d;
        this.f = 460.0d;
        this.g = 0.0f;
        this.h = true;
        this.i = 0L;
        this.j = -1442840576;
        this.k = 16777215;
        this.l = new Paint();
        this.m = new Paint();
        this.n = new RectF();
        this.o = 230.0f;
        this.p = 0L;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = false;
    }
}
