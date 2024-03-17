package com.hunantv.imgo.rv2vp;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CarouselLayoutManager extends ViewPagerLayoutManager {
    private int F;
    private float G;
    private float H;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a {
        private static final float i = 1.0f;
        private static final float j = 0.5f;
        private Context a;
        private int b;
        private int c = 0;
        private float d = j;
        private float e = 1.0f;
        private boolean g = false;
        private int f = -1;
        private int h = Integer.MAX_VALUE;

        public a(Context context, int i2) {
            this.b = i2;
            this.a = context;
        }

        public CarouselLayoutManager i() {
            return new CarouselLayoutManager(this);
        }

        public a j(int i2) {
            this.h = i2;
            return this;
        }

        public a k(int i2) {
            this.f = i2;
            return this;
        }

        public a l(float f) {
            this.d = f;
            return this;
        }

        public a m(float f) {
            this.e = f;
            return this;
        }

        public a n(int i2) {
            this.c = i2;
            return this;
        }

        public a o(boolean z) {
            this.g = z;
            return this;
        }
    }

    public CarouselLayoutManager(Context context, int i) {
        this(new a(context, i));
    }

    private float N(float f) {
        return (((this.G - 1.0f) * Math.abs(f - ((this.f.n() - this.a) / 2.0f))) / (this.f.n() / 2.0f)) + 1.0f;
    }

    @Override // com.hunantv.imgo.rv2vp.ViewPagerLayoutManager
    public float F() {
        return this.a - this.F;
    }

    @Override // com.hunantv.imgo.rv2vp.ViewPagerLayoutManager
    public void G(View view, float f) {
        float N = N(f + this.c);
        view.setScaleX(N);
        view.setScaleY(N);
    }

    @Override // com.hunantv.imgo.rv2vp.ViewPagerLayoutManager
    public float L(View view, float f) {
        return view.getScaleX() * 5.0f;
    }

    public int O() {
        return this.F;
    }

    public float P() {
        return this.G;
    }

    public float Q() {
        return this.H;
    }

    public void R(int i) {
        assertNotInLayoutOrScroll((String) null);
        if (this.F == i) {
            return;
        }
        this.F = i;
        removeAllViews();
    }

    public void S(float f) {
        assertNotInLayoutOrScroll((String) null);
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (this.G == f) {
            return;
        }
        this.G = f;
        requestLayout();
    }

    public void T(float f) {
        assertNotInLayoutOrScroll((String) null);
        if (this.H == f) {
            return;
        }
        this.H = f;
    }

    @Override // com.hunantv.imgo.rv2vp.ViewPagerLayoutManager
    public float h() {
        float f = this.H;
        if (f == 0.0f) {
            return Float.MAX_VALUE;
        }
        return 1.0f / f;
    }

    public void measureChild(@NonNull View view, int i, int i2) {
        try {
            super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.measureChild(view, i, i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.hunantv.imgo.rv2vp.ViewPagerLayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onMeasure(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i, int i2) {
        try {
            super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.onMeasure(recycler, state, i, i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CarouselLayoutManager(Context context, int i, int i2) {
        this(new a(context, i).n(i2));
    }

    public CarouselLayoutManager(Context context, int i, int i2, boolean z) {
        this(new a(context, i).n(i2).o(z));
    }

    public CarouselLayoutManager(a aVar) {
        this(aVar.a, aVar.b, aVar.d, aVar.c, aVar.f, aVar.e, aVar.h, aVar.g);
    }

    private CarouselLayoutManager(Context context, int i, float f, int i2, int i3, float f2, int i4, boolean z) {
        super(context, i2, z);
        D(true);
        C(i4);
        H(i3);
        this.F = i;
        this.G = f;
        this.H = f2;
    }
}
