package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
import t1.h;
import t1.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class n0 implements j.f {
    public final Handler A;
    public Rect C;
    public boolean D;
    public r E;

    /* renamed from: f */
    public Context f984f;

    /* renamed from: g */
    public ListAdapter f985g;

    /* renamed from: h */
    public i0 f986h;

    /* renamed from: k */
    public int f989k;

    /* renamed from: l */
    public int f990l;

    /* renamed from: n */
    public boolean f991n;

    /* renamed from: o */
    public boolean f992o;

    /* renamed from: p */
    public boolean f993p;
    public d s;

    /* renamed from: t */
    public View f996t;

    /* renamed from: u */
    public AdapterView.OnItemClickListener f997u;

    /* renamed from: v */
    public AdapterView.OnItemSelectedListener f998v;

    /* renamed from: i */
    public int f987i = -2;

    /* renamed from: j */
    public int f988j = -2;
    public int m = 1002;

    /* renamed from: q */
    public int f994q = 0;

    /* renamed from: r */
    public int f995r = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* renamed from: w */
    public final g f999w = new g();

    /* renamed from: x */
    public final f f1000x = new f();

    /* renamed from: y */
    public final e f1001y = new e();

    /* renamed from: z */
    public final c f1002z = new c();
    public final Rect B = new Rect();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {
        public static int a(PopupWindow popupWindow, View view, int i7, boolean z6) {
            return popupWindow.getMaxAvailableHeight(view, i7, z6);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {
        public static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        public static void b(PopupWindow popupWindow, boolean z6) {
            popupWindow.setIsClippedToScreen(z6);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class c implements Runnable {
        public c() {
            n0.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i0 i0Var = n0.this.f986h;
            if (i0Var != null) {
                i0Var.setListSelectionHidden(true);
                i0Var.requestLayout();
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class d extends DataSetObserver {
        public d() {
            n0.this = r1;
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            if (n0.this.b()) {
                n0.this.d();
            }
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            n0.this.dismiss();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class e implements AbsListView.OnScrollListener {
        public e() {
            n0.this = r1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScroll(AbsListView absListView, int i7, int i8, int i9) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScrollStateChanged(AbsListView absListView, int i7) {
            boolean z6 = true;
            if (i7 == 1) {
                if (n0.this.E.getInputMethodMode() != 2) {
                    z6 = false;
                }
                if (!z6 && n0.this.E.getContentView() != null) {
                    n0 n0Var = n0.this;
                    n0Var.A.removeCallbacks(n0Var.f999w);
                    n0.this.f999w.run();
                }
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class f implements View.OnTouchListener {
        public f() {
            n0.this = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            r rVar;
            int action = motionEvent.getAction();
            int x6 = (int) motionEvent.getX();
            int y6 = (int) motionEvent.getY();
            if (action == 0 && (rVar = n0.this.E) != null && rVar.isShowing() && x6 >= 0 && x6 < n0.this.E.getWidth() && y6 >= 0 && y6 < n0.this.E.getHeight()) {
                n0 n0Var = n0.this;
                n0Var.A.postDelayed(n0Var.f999w, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                n0 n0Var2 = n0.this;
                n0Var2.A.removeCallbacks(n0Var2.f999w);
                return false;
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class g implements Runnable {
        public g() {
            n0.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i0 i0Var = n0.this.f986h;
            if (i0Var != null) {
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                if (y.g.b(i0Var) && n0.this.f986h.getCount() > n0.this.f986h.getChildCount()) {
                    int childCount = n0.this.f986h.getChildCount();
                    n0 n0Var = n0.this;
                    if (childCount <= n0Var.f995r) {
                        n0Var.E.setInputMethodMode(2);
                        n0.this.d();
                    }
                }
            }
        }
    }

    public n0(Context context, AttributeSet attributeSet, int i7, int i8) {
        this.f984f = context;
        this.A = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a0.e.K, i7, i8);
        this.f989k = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f990l = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f991n = true;
        }
        obtainStyledAttributes.recycle();
        r rVar = new r(context, attributeSet, i7, i8);
        this.E = rVar;
        rVar.setInputMethodMode(1);
    }

    @Override // j.f
    public final boolean b() {
        return this.E.isShowing();
    }

    public final int c() {
        return this.f989k;
    }

    @Override // j.f
    public final void d() {
        int i7;
        int i8;
        i0 i0Var;
        int i9;
        if (this.f986h == null) {
            i0 q6 = q(this.f984f, !this.D);
            this.f986h = q6;
            q6.setAdapter(this.f985g);
            this.f986h.setOnItemClickListener(this.f997u);
            this.f986h.setFocusable(true);
            this.f986h.setFocusableInTouchMode(true);
            this.f986h.setOnItemSelectedListener(new m0(this));
            this.f986h.setOnScrollListener(this.f1001y);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f998v;
            if (onItemSelectedListener != null) {
                this.f986h.setOnItemSelectedListener(onItemSelectedListener);
            }
            this.E.setContentView(this.f986h);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.E.getContentView();
        }
        Drawable background = this.E.getBackground();
        int i10 = 0;
        if (background != null) {
            background.getPadding(this.B);
            Rect rect = this.B;
            int i11 = rect.top;
            i7 = rect.bottom + i11;
            if (!this.f991n) {
                this.f990l = -i11;
            }
        } else {
            this.B.setEmpty();
            i7 = 0;
        }
        int a7 = a.a(this.E, this.f996t, this.f990l, this.E.getInputMethodMode() == 2);
        if (this.f987i == -1) {
            i8 = a7 + i7;
        } else {
            int i12 = this.f988j;
            if (i12 != -2) {
                i9 = 1073741824;
                if (i12 == -1) {
                    int i13 = this.f984f.getResources().getDisplayMetrics().widthPixels;
                    Rect rect2 = this.B;
                    i12 = i13 - (rect2.left + rect2.right);
                }
            } else {
                int i14 = this.f984f.getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = this.B;
                i12 = i14 - (rect3.left + rect3.right);
                i9 = Integer.MIN_VALUE;
            }
            int a8 = this.f986h.a(View.MeasureSpec.makeMeasureSpec(i12, i9), a7 + 0);
            i8 = a8 + (a8 > 0 ? this.f986h.getPaddingBottom() + this.f986h.getPaddingTop() + i7 + 0 : 0);
        }
        boolean z6 = this.E.getInputMethodMode() == 2;
        i.d(this.E, this.m);
        if (this.E.isShowing()) {
            View view = this.f996t;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            if (y.g.b(view)) {
                int i15 = this.f988j;
                if (i15 == -1) {
                    i15 = -1;
                } else if (i15 == -2) {
                    i15 = this.f996t.getWidth();
                }
                int i16 = this.f987i;
                if (i16 == -1) {
                    if (!z6) {
                        i8 = -1;
                    }
                    if (z6) {
                        this.E.setWidth(this.f988j == -1 ? -1 : 0);
                        this.E.setHeight(0);
                    } else {
                        r rVar = this.E;
                        if (this.f988j == -1) {
                            i10 = -1;
                        }
                        rVar.setWidth(i10);
                        this.E.setHeight(-1);
                    }
                } else if (i16 != -2) {
                    i8 = i16;
                }
                this.E.setOutsideTouchable(true);
                this.E.update(this.f996t, this.f989k, this.f990l, i15 < 0 ? -1 : i15, i8 < 0 ? -1 : i8);
                return;
            }
            return;
        }
        int i17 = this.f988j;
        if (i17 == -1) {
            i17 = -1;
        } else if (i17 == -2) {
            i17 = this.f996t.getWidth();
        }
        int i18 = this.f987i;
        if (i18 == -1) {
            i8 = -1;
        } else if (i18 != -2) {
            i8 = i18;
        }
        this.E.setWidth(i17);
        this.E.setHeight(i8);
        b.b(this.E, true);
        this.E.setOutsideTouchable(true);
        this.E.setTouchInterceptor(this.f1000x);
        if (this.f993p) {
            i.c(this.E, this.f992o);
        }
        b.a(this.E, this.C);
        h.a(this.E, this.f996t, this.f989k, this.f990l, this.f994q);
        this.f986h.setSelection(-1);
        if ((!this.D || this.f986h.isInTouchMode()) && (i0Var = this.f986h) != null) {
            i0Var.setListSelectionHidden(true);
            i0Var.requestLayout();
        }
        if (!this.D) {
            this.A.post(this.f1002z);
        }
    }

    @Override // j.f
    public final void dismiss() {
        this.E.dismiss();
        this.E.setContentView(null);
        this.f986h = null;
        this.A.removeCallbacks(this.f999w);
    }

    public final Drawable f() {
        return this.E.getBackground();
    }

    @Override // j.f
    public final i0 g() {
        return this.f986h;
    }

    public final void i(Drawable drawable) {
        this.E.setBackgroundDrawable(drawable);
    }

    public final void j(int i7) {
        this.f990l = i7;
        this.f991n = true;
    }

    public final void l(int i7) {
        this.f989k = i7;
    }

    public final int n() {
        if (!this.f991n) {
            return 0;
        }
        return this.f990l;
    }

    @Override // androidx.appcompat.widget.z.i
    public void p(ListAdapter listAdapter) {
        d dVar = this.s;
        if (dVar == null) {
            this.s = new d();
        } else {
            ListAdapter listAdapter2 = this.f985g;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dVar);
            }
        }
        this.f985g = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.s);
        }
        i0 i0Var = this.f986h;
        if (i0Var != null) {
            i0Var.setAdapter(this.f985g);
        }
    }

    public i0 q(Context context, boolean z6) {
        return new i0(context, z6);
    }

    public final void r(int i7) {
        Drawable background = this.E.getBackground();
        if (background != null) {
            background.getPadding(this.B);
            Rect rect = this.B;
            this.f988j = rect.left + rect.right + i7;
            return;
        }
        this.f988j = i7;
    }
}
