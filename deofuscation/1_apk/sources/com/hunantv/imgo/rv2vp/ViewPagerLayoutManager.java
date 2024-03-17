package com.hunantv.imgo.rv2vp;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import j.l.a.y.c;
import j.l.a.y.d;
import java.util.ArrayList;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class ViewPagerLayoutManager extends LinearLayoutManager {
    public static final int A = 1;
    public static final int B = Integer.MAX_VALUE;
    private static final int C = -1;
    private static final int D = 0;
    private static final int E = 1;
    public static final int y = -1;
    public static final int z = 0;
    public int a;
    public int b;
    public int c;
    public int d;
    public float e;
    public c f;
    public float g;
    public int h;
    public a i;
    private SparseArray<View> j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private SavedState o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private Interpolator v;
    private int w;
    private View x;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public boolean isReverseLayout;
        public float offset;
        public int position;

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.position);
            parcel.writeFloat(this.offset);
            parcel.writeInt(this.isReverseLayout ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.position = parcel.readInt();
            this.offset = parcel.readFloat();
            this.isReverseLayout = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.position = savedState.position;
            this.offset = savedState.offset;
            this.isReverseLayout = savedState.isReverseLayout;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface a {
        void onPageScrollStateChanged(int i);

        void onPageSelected(int i);
    }

    public ViewPagerLayoutManager(Context context) {
        this(context, 0, false);
    }

    private boolean A(float f) {
        return f > y() || f < z();
    }

    private void B(View view) {
        view.setRotation(0.0f);
        view.setRotationY(0.0f);
        view.setRotationX(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setAlpha(1.0f);
    }

    private boolean M() {
        return this.u != -1;
    }

    private int c() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (this.m) {
            return (int) this.g;
        }
        return 1;
    }

    private int d() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (!this.m) {
            return !this.l ? f() : (getItemCount() - f()) - 1;
        }
        float r = r();
        return !this.l ? (int) r : (int) (((getItemCount() - 1) * this.g) + r);
    }

    private int e() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (!this.m) {
            return getItemCount();
        }
        return (int) (getItemCount() * this.g);
    }

    private View o(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (i >= state.getItemCount() || i < 0) {
            return null;
        }
        try {
            return recycler.getViewForPosition(i);
        } catch (Exception unused) {
            return o(recycler, state, i + 1);
        }
    }

    private int q(int i) {
        if (this.h == 1) {
            if (i == 33) {
                return !this.l ? 1 : 0;
            }
            if (i == 130) {
                return this.l ? 1 : 0;
            }
            return -1;
        } else if (i == 17) {
            return !this.l ? 1 : 0;
        } else {
            if (i == 66) {
                return this.l ? 1 : 0;
            }
            return -1;
        }
    }

    private float r() {
        if (this.l) {
            if (this.q) {
                float f = this.e;
                if (f <= 0.0f) {
                    return f % (this.g * getItemCount());
                }
                float f2 = this.g;
                return (getItemCount() * (-f2)) + (this.e % (f2 * getItemCount()));
            }
            return this.e;
        } else if (this.q) {
            float f3 = this.e;
            if (f3 >= 0.0f) {
                return f3 % (this.g * getItemCount());
            }
            float f4 = this.g;
            return (getItemCount() * f4) + (this.e % (f4 * getItemCount()));
        } else {
            return this.e;
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.h != 1 && isLayoutRTL()) {
            this.l = !this.k;
        } else {
            this.l = this.k;
        }
    }

    private int scrollBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        ensureLayoutState();
        float f = i;
        float h = f / h();
        if (Math.abs(h) < 1.0E-8f) {
            return 0;
        }
        float f2 = this.e + h;
        if (!this.q && f2 < p()) {
            i = (int) (f - ((f2 - p()) * h()));
        } else if (!this.q && f2 > m()) {
            i = (int) ((m() - this.e) * h());
        }
        this.e += i / h();
        w(recycler);
        return i;
    }

    private float u(int i) {
        return i * (this.l ? -this.g : this.g);
    }

    private void w(RecyclerView.Recycler recycler) {
        int i;
        int i2;
        int i3;
        detachAndScrapAttachedViews(recycler);
        this.j.clear();
        int itemCount = getItemCount();
        if (itemCount == 0) {
            return;
        }
        int g = this.l ? -g() : g();
        int i4 = g - this.s;
        int i5 = this.t + g;
        if (M()) {
            int i6 = this.u;
            if (i6 % 2 == 0) {
                i2 = i6 / 2;
                i3 = (g - i2) + 1;
            } else {
                i2 = (i6 - 1) / 2;
                i3 = g - i2;
            }
            int i7 = i3;
            i5 = i2 + g + 1;
            i4 = i7;
        }
        if (!this.q) {
            if (i4 < 0) {
                if (M()) {
                    i5 = this.u;
                }
                i4 = 0;
            }
            if (i5 > itemCount) {
                i5 = itemCount;
            }
        }
        float f = Float.MIN_VALUE;
        while (i4 < i5) {
            if (M() || !A(u(i4) - this.e)) {
                if (i4 >= itemCount) {
                    i = i4 % itemCount;
                } else if (i4 < 0) {
                    int i8 = (-i4) % itemCount;
                    if (i8 == 0) {
                        i8 = itemCount;
                    }
                    i = itemCount - i8;
                } else {
                    i = i4;
                }
                View viewForPosition = recycler.getViewForPosition(i);
                measureChildWithMargins(viewForPosition, 0, 0);
                B(viewForPosition);
                float u = u(i4) - this.e;
                x(viewForPosition, u);
                float L = this.r ? L(viewForPosition, u) : i;
                if (L > f) {
                    addView(viewForPosition);
                } else {
                    addView(viewForPosition, 0);
                }
                if (i4 == g) {
                    this.x = viewForPosition;
                }
                this.j.put(i4, viewForPosition);
                f = L;
            }
            i4++;
        }
        this.x.requestFocus();
    }

    private void x(View view, float f) {
        int a2 = a(view, f);
        int b = b(view, f);
        if (this.h == 1) {
            int i = this.d;
            int i2 = this.c;
            layoutDecorated(view, i + a2, i2 + b, i + a2 + this.b, i2 + b + this.a);
        } else {
            int i3 = this.c;
            int i4 = this.d;
            layoutDecorated(view, i3 + a2, i4 + b, i3 + a2 + this.a, i4 + b + this.b);
        }
        G(view, f);
    }

    public void C(int i) {
        assertNotInLayoutOrScroll((String) null);
        if (this.w == i) {
            return;
        }
        this.w = i;
        removeAllViews();
    }

    public void D(boolean z2) {
        assertNotInLayoutOrScroll((String) null);
        if (this.r == z2) {
            return;
        }
        this.r = z2;
        requestLayout();
    }

    public void E(boolean z2) {
        assertNotInLayoutOrScroll((String) null);
        if (z2 == this.q) {
            return;
        }
        this.q = z2;
        requestLayout();
    }

    public abstract float F();

    public abstract void G(View view, float f);

    public void H(int i) {
        assertNotInLayoutOrScroll((String) null);
        if (this.u == i) {
            return;
        }
        this.u = i;
        removeAllViews();
    }

    public void I(a aVar) {
        this.i = aVar;
    }

    public void J(Interpolator interpolator) {
        this.v = interpolator;
    }

    public void K() {
    }

    public float L(View view, float f) {
        return 0.0f;
    }

    public int a(View view, float f) {
        if (this.h == 1) {
            return 0;
        }
        return (int) f;
    }

    public int b(View view, float f) {
        if (this.h == 1) {
            return (int) f;
        }
        return 0;
    }

    public boolean canScrollHorizontally() {
        return this.h == 0;
    }

    public boolean canScrollVertically() {
        return this.h == 1;
    }

    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return c();
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return d();
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return e();
    }

    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return c();
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return d();
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        return e();
    }

    public void ensureLayoutState() {
        if (this.f == null) {
            this.f = c.b(this, this.h);
        }
    }

    public int f() {
        int itemCount;
        if (getItemCount() == 0) {
            return 0;
        }
        int g = g();
        if (!this.q) {
            return Math.abs(g);
        }
        if (this.l) {
            if (g > 0) {
                itemCount = getItemCount() - (g % getItemCount());
            } else {
                itemCount = (-g) % getItemCount();
            }
        } else if (g >= 0) {
            itemCount = g % getItemCount();
        } else {
            itemCount = (g % getItemCount()) + getItemCount();
        }
        if (itemCount == getItemCount()) {
            return 0;
        }
        return itemCount;
    }

    public View findViewByPosition(int i) {
        int itemCount = getItemCount();
        if (itemCount == 0) {
            return null;
        }
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            int keyAt = this.j.keyAt(i2);
            if (keyAt >= 0) {
                if (i == keyAt % itemCount) {
                    return this.j.valueAt(i2);
                }
            } else {
                int i3 = keyAt % itemCount;
                if (i3 == 0) {
                    i3 = -itemCount;
                }
                if (i3 + itemCount == i) {
                    return this.j.valueAt(i2);
                }
            }
        }
        return null;
    }

    public int g() {
        float f = this.g;
        if (f == 0.0f) {
            return 0;
        }
        return Math.round(this.e / f);
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public int getOrientation() {
        return this.h;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.p;
    }

    public boolean getReverseLayout() {
        return this.k;
    }

    public float h() {
        return 1.0f;
    }

    public int i() {
        int i = this.w;
        return i == Integer.MAX_VALUE ? (this.f.p() - this.b) / 2 : i;
    }

    public boolean j() {
        return this.r;
    }

    public boolean k() {
        return this.q;
    }

    public int l(View view) {
        for (int i = 0; i < this.j.size(); i++) {
            int keyAt = this.j.keyAt(i);
            if (this.j.get(keyAt) == view) {
                return keyAt;
            }
        }
        return -1;
    }

    public float m() {
        if (this.l) {
            return 0.0f;
        }
        return (getItemCount() - 1) * this.g;
    }

    public int n() {
        return this.u;
    }

    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
        this.e = 0.0f;
    }

    public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
        int f = f();
        View findViewByPosition = findViewByPosition(f);
        if (findViewByPosition == null) {
            return true;
        }
        if (recyclerView.hasFocus()) {
            int q = q(i);
            if (q != -1) {
                d.a(recyclerView, this, q == 1 ? f - 1 : f + 1);
            }
        } else {
            findViewByPosition.addFocusables(arrayList, i, i2);
        }
        return true;
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.p) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return null;
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            this.e = 0.0f;
            return;
        }
        ensureLayoutState();
        resolveShouldLayoutReverse();
        View o = o(recycler, state, 0);
        if (o == null) {
            removeAndRecycleAllViews(recycler);
            this.e = 0.0f;
            return;
        }
        measureChildWithMargins(o, 0, 0);
        this.a = this.f.e(o);
        this.b = this.f.f(o);
        this.c = (this.f.n() - this.a) / 2;
        if (this.w == Integer.MAX_VALUE) {
            this.d = (this.f.p() - this.b) / 2;
        } else {
            this.d = (this.f.p() - this.b) - this.w;
        }
        this.g = F();
        K();
        if (this.g == 0.0f) {
            this.s = 1;
            this.t = 1;
        } else {
            this.s = ((int) Math.abs(z() / this.g)) + 1;
            this.t = ((int) Math.abs(y() / this.g)) + 1;
        }
        SavedState savedState = this.o;
        if (savedState != null) {
            this.l = savedState.isReverseLayout;
            this.n = savedState.position;
            this.e = savedState.offset;
        }
        int i = this.n;
        if (i != -1) {
            this.e = i * (this.l ? -this.g : this.g);
        }
        w(recycler);
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.o = null;
        this.n = -1;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.o = new SavedState((SavedState) parcelable);
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.o != null) {
            return new SavedState(this.o);
        }
        SavedState savedState = new SavedState();
        savedState.position = this.n;
        savedState.offset = this.e;
        savedState.isReverseLayout = this.l;
        return savedState;
    }

    public float p() {
        if (this.l) {
            return (-(getItemCount() - 1)) * this.g;
        }
        return 0.0f;
    }

    public int s() {
        float f;
        float h;
        if (this.q) {
            f = (g() * this.g) - this.e;
            h = h();
        } else {
            f = (f() * (!this.l ? this.g : -this.g)) - this.e;
            h = h();
        }
        return (int) (f * h);
    }

    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.h == 1) {
            return 0;
        }
        return scrollBy(i, recycler, state);
    }

    public void scrollToPosition(int i) {
        if (this.q || (i >= 0 && i < getItemCount())) {
            this.n = i;
            this.e = i * (this.l ? -this.g : this.g);
            requestLayout();
        }
    }

    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.h == 0) {
            return 0;
        }
        return scrollBy(i, recycler, state);
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        assertNotInLayoutOrScroll((String) null);
        if (i == this.h) {
            return;
        }
        this.h = i;
        this.f = null;
        this.w = Integer.MAX_VALUE;
        removeAllViews();
    }

    public void setRecycleChildrenOnDetach(boolean z2) {
        this.p = z2;
    }

    public void setReverseLayout(boolean z2) {
        assertNotInLayoutOrScroll((String) null);
        if (z2 == this.k) {
            return;
        }
        this.k = z2;
        removeAllViews();
    }

    public void setSmoothScrollbarEnabled(boolean z2) {
        this.m = z2;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        int t;
        int i2;
        if (this.q) {
            int f = f();
            int itemCount = getItemCount();
            if (i < f) {
                int i3 = f - i;
                int i4 = (itemCount - f) + i;
                i2 = i3 < i4 ? f - i3 : f + i4;
            } else {
                int i5 = i - f;
                int i6 = (itemCount + f) - i;
                i2 = i5 < i6 ? f + i5 : f - i6;
            }
            t = t(i2);
        } else {
            t = t(i);
        }
        if (this.h == 1) {
            recyclerView.smoothScrollBy(0, t, this.v);
        } else {
            recyclerView.smoothScrollBy(t, 0, this.v);
        }
    }

    public int t(int i) {
        float f;
        float h;
        if (this.q) {
            f = ((g() + (!this.l ? i - g() : (-g()) - i)) * this.g) - this.e;
            h = h();
        } else {
            f = (i * (!this.l ? this.g : -this.g)) - this.e;
            h = h();
        }
        return (int) (f * h);
    }

    public boolean v() {
        return this.m;
    }

    public float y() {
        return this.f.n() - this.c;
    }

    public float z() {
        return ((-this.a) - this.f.m()) - this.c;
    }

    public ViewPagerLayoutManager(Context context, int i, boolean z2) {
        super(context);
        this.j = new SparseArray<>();
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = -1;
        this.o = null;
        this.q = false;
        this.u = -1;
        this.w = Integer.MAX_VALUE;
        setOrientation(i);
        setReverseLayout(z2);
        setAutoMeasureEnabled(true);
        setItemPrefetchEnabled(false);
    }
}
