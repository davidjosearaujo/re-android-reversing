package c3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import c3.f;

/* loaded from: classes.dex */
public final class c extends Drawable implements f.b, Animatable {

    /* renamed from: f */
    public final a f2527f;

    /* renamed from: g */
    public boolean f2528g;

    /* renamed from: h */
    public boolean f2529h;

    /* renamed from: i */
    public boolean f2530i;

    /* renamed from: j */
    public boolean f2531j;

    /* renamed from: k */
    public int f2532k;

    /* renamed from: l */
    public int f2533l;
    public boolean m;

    /* renamed from: n */
    public Paint f2534n;

    /* renamed from: o */
    public Rect f2535o;

    /* loaded from: classes.dex */
    public static final class a extends Drawable.ConstantState {

        /* renamed from: a */
        public final f f2536a;

        public a(f fVar) {
            this.f2536a = fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new c(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return new c(this);
        }
    }

    public c() {
        throw null;
    }

    public c(a aVar) {
        this.f2531j = true;
        this.f2533l = -1;
        q2.a.i(aVar);
        this.f2527f = aVar;
    }

    @Override // c3.f.b
    public final void a() {
        Drawable.Callback callback;
        f fVar;
        Drawable drawable = this;
        while (true) {
            callback = drawable.getCallback();
            if (!(callback instanceof Drawable)) {
                break;
            }
            drawable = (Drawable) callback;
        }
        if (callback == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        f.a aVar = this.f2527f.f2536a.f2545i;
        if ((aVar != null ? aVar.f2554j : -1) == fVar.f2538a.d() - 1) {
            this.f2532k++;
        }
        int i7 = this.f2533l;
        if (i7 == -1 || this.f2532k < i7) {
            return;
        }
        stop();
    }

    public final void b() {
        q2.a.h("You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.", !this.f2530i);
        if (this.f2527f.f2536a.f2538a.d() != 1) {
            if (this.f2528g) {
                return;
            }
            this.f2528g = true;
            f fVar = this.f2527f.f2536a;
            if (fVar.f2546j) {
                throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
            }
            if (fVar.f2540c.contains(this)) {
                throw new IllegalStateException("Cannot subscribe twice in a row");
            }
            boolean isEmpty = fVar.f2540c.isEmpty();
            fVar.f2540c.add(this);
            if (isEmpty && !fVar.f2542f) {
                fVar.f2542f = true;
                fVar.f2546j = false;
                fVar.a();
            }
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.f2530i) {
            return;
        }
        if (this.m) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Rect bounds = getBounds();
            if (this.f2535o == null) {
                this.f2535o = new Rect();
            }
            Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.f2535o);
            this.m = false;
        }
        f fVar = this.f2527f.f2536a;
        f.a aVar = fVar.f2545i;
        Bitmap bitmap = aVar != null ? aVar.f2556l : fVar.f2548l;
        if (this.f2535o == null) {
            this.f2535o = new Rect();
        }
        Rect rect = this.f2535o;
        if (this.f2534n == null) {
            this.f2534n = new Paint(2);
        }
        canvas.drawBitmap(bitmap, (Rect) null, rect, this.f2534n);
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f2527f;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f2527f.f2536a.f2552q;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f2527f.f2536a.f2551p;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f2528g;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.m = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i7) {
        if (this.f2534n == null) {
            this.f2534n = new Paint(2);
        }
        this.f2534n.setAlpha(i7);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f2534n == null) {
            this.f2534n = new Paint(2);
        }
        this.f2534n.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z6, boolean z7) {
        q2.a.h("Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.", !this.f2530i);
        this.f2531j = z6;
        if (!z6) {
            this.f2528g = false;
            f fVar = this.f2527f.f2536a;
            fVar.f2540c.remove(this);
            if (fVar.f2540c.isEmpty()) {
                fVar.f2542f = false;
            }
        } else if (this.f2529h) {
            b();
        }
        return super.setVisible(z6, z7);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f2529h = true;
        this.f2532k = 0;
        if (this.f2531j) {
            b();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f2529h = false;
        this.f2528g = false;
        f fVar = this.f2527f.f2536a;
        fVar.f2540c.remove(this);
        if (fVar.f2540c.isEmpty()) {
            fVar.f2542f = false;
        }
    }
}
