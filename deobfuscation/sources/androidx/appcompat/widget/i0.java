package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class i0 extends ListView {

    /* renamed from: f */
    public final Rect f921f;

    /* renamed from: g */
    public int f922g;

    /* renamed from: h */
    public int f923h;

    /* renamed from: i */
    public int f924i;

    /* renamed from: j */
    public int f925j;

    /* renamed from: k */
    public int f926k;

    /* renamed from: l */
    public d f927l;
    public boolean m;

    /* renamed from: n */
    public boolean f928n;

    /* renamed from: o */
    public boolean f929o;

    /* renamed from: p */
    public t1.f f930p;

    /* renamed from: q */
    public f f931q;

    /* loaded from: classes.dex */
    public static class a {
        public static void a(View view, float f7, float f8) {
            view.drawableHotspotChanged(f7, f8);
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public static Method f932a;

        /* renamed from: b */
        public static Method f933b;

        /* renamed from: c */
        public static Method f934c;

        /* renamed from: d */
        public static boolean f935d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
                f932a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f933b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f934c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f935d = true;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        public static void b(AbsListView absListView, boolean z6) {
            absListView.setSelectedChildViewEnabled(z6);
        }
    }

    /* loaded from: classes.dex */
    public static class d extends h.a {

        /* renamed from: g */
        public boolean f936g;

        public d(Drawable drawable) {
            super(drawable);
            this.f936g = true;
        }

        @Override // h.a, android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            if (this.f936g) {
                super.draw(canvas);
            }
        }

        @Override // h.a, android.graphics.drawable.Drawable
        public final void setHotspot(float f7, float f8) {
            if (this.f936g) {
                super.setHotspot(f7, f8);
            }
        }

        @Override // h.a, android.graphics.drawable.Drawable
        public final void setHotspotBounds(int i7, int i8, int i9, int i10) {
            if (this.f936g) {
                super.setHotspotBounds(i7, i8, i9, i10);
            }
        }

        @Override // h.a, android.graphics.drawable.Drawable
        public final boolean setState(int[] iArr) {
            if (this.f936g) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // h.a, android.graphics.drawable.Drawable
        public final boolean setVisible(boolean z6, boolean z7) {
            if (this.f936g) {
                return super.setVisible(z6, z7);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a */
        public static final Field f937a;

        static {
            Field field = null;
            try {
                field = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                field.setAccessible(true);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            f937a = field;
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public f() {
            i0.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i0 i0Var = i0.this;
            i0Var.f931q = null;
            i0Var.drawableStateChanged();
        }
    }

    public i0(Context context, boolean z6) {
        super(context, null, 2130903463);
        this.f921f = new Rect();
        this.f922g = 0;
        this.f923h = 0;
        this.f924i = 0;
        this.f925j = 0;
        this.f928n = z6;
        setCacheColorHint(0);
    }

    private void setSelectorEnabled(boolean z6) {
        d dVar = this.f927l;
        if (dVar != null) {
            dVar.f936g = z6;
        }
    }

    public final int a(int i7, int i8) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        int i9 = listPaddingTop + listPaddingBottom;
        if (adapter == null) {
            return i9;
        }
        dividerHeight = (dividerHeight <= 0 || divider == null) ? 0 : 0;
        int count = adapter.getCount();
        int i10 = 0;
        View view = null;
        for (int i11 = 0; i11 < count; i11++) {
            int itemViewType = adapter.getItemViewType(i11);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = adapter.getView(i11, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i12 = layoutParams.height;
            view.measure(i7, i12 > 0 ? View.MeasureSpec.makeMeasureSpec(i12, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i11 > 0) {
                i9 += dividerHeight;
            }
            i9 += view.getMeasuredHeight();
            if (i9 >= i8) {
                return i8;
            }
        }
        return i9;
    }

    /* JADX WARN: Removed duplicated region for block: B:368:0x0145 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:371:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0177  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(android.view.MotionEvent r17, int r18) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i0.b(android.view.MotionEvent, int):boolean");
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        if (!this.f921f.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f921f);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        if (this.f931q != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        Drawable selector = getSelector();
        if (selector != null && this.f929o && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasFocus() {
        return this.f928n || super.hasFocus();
    }

    @Override // android.view.View
    public final boolean hasWindowFocus() {
        return this.f928n || super.hasWindowFocus();
    }

    @Override // android.view.View
    public final boolean isFocused() {
        return this.f928n || super.isFocused();
    }

    @Override // android.view.View
    public final boolean isInTouchMode() {
        return (this.f928n && this.m) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f931q = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f931q == null) {
            f fVar = new f();
            this.f931q = fVar;
            post(fVar);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (b.f935d) {
                        try {
                            b.f932a.invoke(this, Integer.valueOf(pointToPosition), childAt, Boolean.FALSE, -1, -1);
                            b.f933b.invoke(this, Integer.valueOf(pointToPosition));
                            b.f934c.invoke(this, Integer.valueOf(pointToPosition));
                        } catch (IllegalAccessException | InvocationTargetException e7) {
                            e7.printStackTrace();
                        }
                    } else {
                        setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                    }
                }
                Drawable selector = getSelector();
                if (selector != null && this.f929o && isPressed()) {
                    selector.setState(getDrawableState());
                }
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f926k = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        f fVar = this.f931q;
        if (fVar != null) {
            i0 i0Var = i0.this;
            i0Var.f931q = null;
            i0Var.removeCallbacks(fVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z6) {
        this.m = z6;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        d dVar = drawable != null ? new d(drawable) : null;
        this.f927l = dVar;
        super.setSelector(dVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f922g = rect.left;
        this.f923h = rect.top;
        this.f924i = rect.right;
        this.f925j = rect.bottom;
    }
}
