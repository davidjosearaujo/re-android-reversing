package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.fragment.app.s0;
import g1.a;
import j1.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import p1.k0;
import p1.m;
import p1.n;
import p1.o;
import p1.p;
import p1.p0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class CoordinatorLayout extends ViewGroup implements m, n {
    public static final ThreadLocal<Map<String, Constructor<c>>> A;
    public static final i B;
    public static final o1.f C;

    /* renamed from: y */
    public static final String f1421y;

    /* renamed from: z */
    public static final Class<?>[] f1422z;

    /* renamed from: l */
    public boolean f1429l;
    public boolean m;

    /* renamed from: n */
    public int[] f1430n;

    /* renamed from: o */
    public View f1431o;

    /* renamed from: p */
    public View f1432p;

    /* renamed from: q */
    public g f1433q;

    /* renamed from: r */
    public boolean f1434r;
    public p0 s;

    /* renamed from: t */
    public boolean f1435t;

    /* renamed from: u */
    public Drawable f1436u;

    /* renamed from: v */
    public ViewGroup.OnHierarchyChangeListener f1437v;

    /* renamed from: w */
    public a f1438w;

    /* renamed from: f */
    public final ArrayList f1423f = new ArrayList();

    /* renamed from: g */
    public final w0.c f1424g = new w0.c(1);

    /* renamed from: h */
    public final ArrayList f1425h = new ArrayList();

    /* renamed from: i */
    public final ArrayList f1426i = new ArrayList();

    /* renamed from: j */
    public final int[] f1427j = new int[2];

    /* renamed from: k */
    public final int[] f1428k = new int[2];

    /* renamed from: x */
    public final o f1439x = new o();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements p {
        public a() {
            CoordinatorLayout.this = r1;
        }

        @Override // p1.p
        public final p0 a(View view, p0 p0Var) {
            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
            if (!o1.b.a(coordinatorLayout.s, p0Var)) {
                coordinatorLayout.s = p0Var;
                boolean z6 = true;
                boolean z7 = p0Var.e() > 0;
                coordinatorLayout.f1435t = z7;
                if (z7 || coordinatorLayout.getBackground() != null) {
                    z6 = false;
                }
                coordinatorLayout.setWillNotDraw(z6);
                if (!p0Var.f5510a.m()) {
                    int childCount = coordinatorLayout.getChildCount();
                    for (int i7 = 0; i7 < childCount; i7++) {
                        View childAt = coordinatorLayout.getChildAt(i7);
                        WeakHashMap<View, k0> weakHashMap = y.f5540a;
                        if (y.d.b(childAt) && ((f) childAt.getLayoutParams()).f1442a != null && p0Var.f5510a.m()) {
                            break;
                        }
                    }
                }
                coordinatorLayout.requestLayout();
            }
            return p0Var;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface b {
        c getBehavior();
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class c<V extends View> {
        public c() {
        }

        public c(Context context, AttributeSet attributeSet) {
        }

        public boolean e(View view) {
            return false;
        }

        public boolean f(View view, View view2) {
            return false;
        }

        public void g(f fVar) {
        }

        public boolean h(CoordinatorLayout coordinatorLayout, V v6, View view) {
            return false;
        }

        public void i(CoordinatorLayout coordinatorLayout, View view) {
        }

        public void j() {
        }

        public boolean k(CoordinatorLayout coordinatorLayout, V v6, MotionEvent motionEvent) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, V v6, int i7) {
            return false;
        }

        public boolean m(CoordinatorLayout coordinatorLayout, View view, int i7, int i8, int i9) {
            return false;
        }

        public boolean n(View view) {
            return false;
        }

        public void o(CoordinatorLayout coordinatorLayout, V v6, View view, int i7, int i8, int[] iArr, int i9) {
        }

        public void p(CoordinatorLayout coordinatorLayout, View view, int i7, int i8, int i9, int[] iArr) {
            iArr[0] = iArr[0] + i8;
            iArr[1] = iArr[1] + i9;
        }

        public boolean q(CoordinatorLayout coordinatorLayout, V v6, Rect rect, boolean z6) {
            return false;
        }

        public void r(View view, Parcelable parcelable) {
        }

        public Parcelable s(View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean t(CoordinatorLayout coordinatorLayout, V v6, View view, View view2, int i7, int i8) {
            return false;
        }

        public void u(CoordinatorLayout coordinatorLayout, V v6, View view, int i7) {
        }

        public boolean v(CoordinatorLayout coordinatorLayout, V v6, MotionEvent motionEvent) {
            return false;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public @interface d {
        Class<? extends c> value();
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class e implements ViewGroup.OnHierarchyChangeListener {
        public e() {
            CoordinatorLayout.this = r1;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f1437v;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.p(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f1437v;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public c f1442a;

        /* renamed from: b */
        public boolean f1443b;

        /* renamed from: c */
        public int f1444c;

        /* renamed from: d */
        public int f1445d;
        public int e;

        /* renamed from: f */
        public int f1446f;

        /* renamed from: g */
        public int f1447g;

        /* renamed from: h */
        public int f1448h;

        /* renamed from: i */
        public int f1449i;

        /* renamed from: j */
        public int f1450j;

        /* renamed from: k */
        public View f1451k;

        /* renamed from: l */
        public View f1452l;
        public boolean m;

        /* renamed from: n */
        public boolean f1453n;

        /* renamed from: o */
        public boolean f1454o;

        /* renamed from: p */
        public boolean f1455p;

        /* renamed from: q */
        public final Rect f1456q;

        public f() {
            super(-2, -2);
            this.f1443b = false;
            this.f1444c = 0;
            this.f1445d = 0;
            this.e = -1;
            this.f1446f = -1;
            this.f1447g = 0;
            this.f1448h = 0;
            this.f1456q = new Rect();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            c cVar;
            this.f1443b = false;
            this.f1444c = 0;
            this.f1445d = 0;
            this.e = -1;
            this.f1446f = -1;
            this.f1447g = 0;
            this.f1448h = 0;
            this.f1456q = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a0.b.f17q);
            this.f1444c = obtainStyledAttributes.getInteger(0, 0);
            this.f1446f = obtainStyledAttributes.getResourceId(1, -1);
            this.f1445d = obtainStyledAttributes.getInteger(2, 0);
            this.e = obtainStyledAttributes.getInteger(6, -1);
            this.f1447g = obtainStyledAttributes.getInt(5, 0);
            this.f1448h = obtainStyledAttributes.getInt(4, 0);
            boolean hasValue = obtainStyledAttributes.hasValue(3);
            this.f1443b = hasValue;
            if (hasValue) {
                String string = obtainStyledAttributes.getString(3);
                String str = CoordinatorLayout.f1421y;
                if (TextUtils.isEmpty(string)) {
                    cVar = null;
                } else {
                    if (string.startsWith(".")) {
                        string = context.getPackageName() + string;
                    } else if (string.indexOf(46) < 0) {
                        String str2 = CoordinatorLayout.f1421y;
                        if (!TextUtils.isEmpty(str2)) {
                            string = str2 + '.' + string;
                        }
                    }
                    try {
                        ThreadLocal<Map<String, Constructor<c>>> threadLocal = CoordinatorLayout.A;
                        Map<String, Constructor<c>> map = threadLocal.get();
                        if (map == null) {
                            map = new HashMap<>();
                            threadLocal.set(map);
                        }
                        Constructor<c> constructor = map.get(string);
                        if (constructor == null) {
                            constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.f1422z);
                            constructor.setAccessible(true);
                            map.put(string, constructor);
                        }
                        cVar = constructor.newInstance(context, attributeSet);
                    } catch (Exception e) {
                        throw new RuntimeException(s0.h("Could not inflate Behavior subclass ", string), e);
                    }
                }
                this.f1442a = cVar;
            }
            obtainStyledAttributes.recycle();
            c cVar2 = this.f1442a;
            if (cVar2 != null) {
                cVar2.g(this);
            }
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1443b = false;
            this.f1444c = 0;
            this.f1445d = 0;
            this.e = -1;
            this.f1446f = -1;
            this.f1447g = 0;
            this.f1448h = 0;
            this.f1456q = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1443b = false;
            this.f1444c = 0;
            this.f1445d = 0;
            this.e = -1;
            this.f1446f = -1;
            this.f1447g = 0;
            this.f1448h = 0;
            this.f1456q = new Rect();
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f1443b = false;
            this.f1444c = 0;
            this.f1445d = 0;
            this.e = -1;
            this.f1446f = -1;
            this.f1447g = 0;
            this.f1448h = 0;
            this.f1456q = new Rect();
        }

        public final boolean a(int i7) {
            if (i7 == 0) {
                return this.f1453n;
            }
            if (i7 != 1) {
                return false;
            }
            return this.f1454o;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class g implements ViewTreeObserver.OnPreDrawListener {
        public g() {
            CoordinatorLayout.this = r1;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            CoordinatorLayout.this.p(0);
            return true;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class h extends w1.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: h */
        public SparseArray<Parcelable> f1458h;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<h> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i7) {
                return new h[i7];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f1458h = new SparseArray<>(readInt);
            for (int i7 = 0; i7 < readInt; i7++) {
                this.f1458h.append(iArr[i7], readParcelableArray[i7]);
            }
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // w1.a, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i7) {
            parcel.writeParcelable(this.f6374f, i7);
            SparseArray<Parcelable> sparseArray = this.f1458h;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i8 = 0; i8 < size; i8++) {
                iArr[i8] = this.f1458h.keyAt(i8);
                parcelableArr[i8] = this.f1458h.valueAt(i8);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i7);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class i implements Comparator<View> {
        @Override // java.util.Comparator
        public final int compare(View view, View view2) {
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            float m = y.i.m(view);
            float m3 = y.i.m(view2);
            if (m > m3) {
                return -1;
            }
            return m < m3 ? 1 : 0;
        }
    }

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f1421y = r02 != null ? r02.getName() : null;
        B = new i();
        f1422z = new Class[]{Context.class, AttributeSet.class};
        A = new ThreadLocal<>();
        C = new o1.f(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130903372);
        int[] iArr = a0.b.f16p;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 2130903372, 0);
        saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 2130903372, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f1430n = resources.getIntArray(resourceId);
            float f7 = resources.getDisplayMetrics().density;
            int length = this.f1430n.length;
            for (int i7 = 0; i7 < length; i7++) {
                int[] iArr2 = this.f1430n;
                iArr2[i7] = (int) (((float) iArr2[i7]) * f7);
            }
        }
        this.f1436u = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        x();
        super.setOnHierarchyChangeListener(new e());
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        if (y.d.c(this) == 0) {
            y.d.s(this, 1);
        }
    }

    public static Rect b() {
        Rect rect = (Rect) C.b();
        return rect == null ? new Rect() : rect;
    }

    public static void g(int i7, Rect rect, Rect rect2, f fVar, int i8, int i9) {
        int i10 = fVar.f1444c;
        if (i10 == 0) {
            i10 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i10, i7);
        int i11 = fVar.f1445d;
        if ((i11 & 7) == 0) {
            i11 |= 8388611;
        }
        if ((i11 & 112) == 0) {
            i11 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i11, i7);
        int i12 = absoluteGravity & 7;
        int i13 = absoluteGravity & 112;
        int i14 = absoluteGravity2 & 7;
        int i15 = absoluteGravity2 & 112;
        int width = i14 != 1 ? i14 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int height = i15 != 16 ? i15 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i12 == 1) {
            width -= i8 / 2;
        } else if (i12 != 5) {
            width -= i8;
        }
        if (i13 == 16) {
            height -= i9 / 2;
        } else if (i13 != 80) {
            height -= i9;
        }
        rect2.set(width, height, i8 + width, i9 + height);
    }

    public static f k(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f1443b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                c cVar = fVar.f1442a;
                if (cVar != behavior) {
                    if (cVar != null) {
                        cVar.j();
                    }
                    fVar.f1442a = behavior;
                    fVar.f1443b = true;
                    if (behavior != null) {
                        behavior.g(fVar);
                    }
                }
            } else {
                d dVar = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    dVar = (d) cls.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        c cVar2 = (c) dVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        c cVar3 = fVar.f1442a;
                        if (cVar3 != cVar2) {
                            if (cVar3 != null) {
                                cVar3.j();
                            }
                            fVar.f1442a = cVar2;
                            fVar.f1443b = true;
                            if (cVar2 != null) {
                                cVar2.g(fVar);
                            }
                        }
                    } catch (Exception e7) {
                        StringBuilder d7 = androidx.activity.h.d("Default behavior class ");
                        d7.append(dVar.value().getName());
                        d7.append(" could not be instantiated. Did you forget a default constructor?");
                        Log.e("CoordinatorLayout", d7.toString(), e7);
                    }
                }
            }
            fVar.f1443b = true;
        }
        return fVar;
    }

    public static void v(View view, int i7) {
        f fVar = (f) view.getLayoutParams();
        int i8 = fVar.f1449i;
        if (i8 != i7) {
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            view.offsetLeftAndRight(i7 - i8);
            fVar.f1449i = i7;
        }
    }

    public static void w(View view, int i7) {
        f fVar = (f) view.getLayoutParams();
        int i8 = fVar.f1450j;
        if (i8 != i7) {
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            view.offsetTopAndBottom(i7 - i8);
            fVar.f1450j = i7;
        }
    }

    @Override // p1.m
    public final void a(View view, View view2, int i7, int i8) {
        o oVar = this.f1439x;
        if (i8 == 1) {
            oVar.f5501b = i7;
        } else {
            oVar.f5500a = i7;
        }
        this.f1432p = view2;
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            ((f) getChildAt(i9).getLayoutParams()).getClass();
        }
    }

    public final void c(f fVar, Rect rect, int i7, int i8) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i7) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i8) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(max, max2, i7 + max, i8 + max2);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    public final void d(View view, Rect rect, boolean z6) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z6) {
            f(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j7) {
        c cVar = ((f) view.getLayoutParams()).f1442a;
        if (cVar != null) {
            cVar.getClass();
        }
        return super.drawChild(canvas, view, j7);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1436u;
        boolean z6 = false;
        if (drawable != null && drawable.isStateful()) {
            z6 = false | drawable.setState(drawableState);
        }
        if (z6) {
            invalidate();
        }
    }

    public final ArrayList e(View view) {
        w0.c cVar = this.f1424g;
        int i7 = ((o.h) cVar.f6338b).f5221h;
        ArrayList arrayList = null;
        for (int i8 = 0; i8 < i7; i8++) {
            ArrayList arrayList2 = (ArrayList) ((o.h) cVar.f6338b).l(i8);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(((o.h) cVar.f6338b).h(i8));
            }
        }
        this.f1426i.clear();
        if (arrayList != null) {
            this.f1426i.addAll(arrayList);
        }
        return this.f1426i;
    }

    public final void f(View view, Rect rect) {
        ThreadLocal<Matrix> threadLocal = d1.a.f3553a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal<Matrix> threadLocal2 = d1.a.f3553a;
        Matrix matrix = threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        d1.a.a(this, view, matrix);
        ThreadLocal<RectF> threadLocal3 = d1.a.f3554b;
        RectF rectF = threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    public final List<View> getDependencySortedChildren() {
        t();
        return Collections.unmodifiableList(this.f1423f);
    }

    public final p0 getLastWindowInsets() {
        return this.s;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        o oVar = this.f1439x;
        return oVar.f5501b | oVar.f5500a;
    }

    public Drawable getStatusBarBackground() {
        return this.f1436u;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public final int h(int i7) {
        StringBuilder sb;
        int[] iArr = this.f1430n;
        if (iArr == null) {
            sb = new StringBuilder();
            sb.append("No keylines defined for ");
            sb.append(this);
            sb.append(" - attempted index lookup ");
            sb.append(i7);
        } else if (i7 >= 0 && i7 < iArr.length) {
            return iArr[i7];
        } else {
            sb = new StringBuilder();
            sb.append("Keyline index ");
            sb.append(i7);
            sb.append(" out of range for ");
            sb.append(this);
        }
        Log.e("CoordinatorLayout", sb.toString());
        return 0;
    }

    @Override // p1.m
    public final void i(View view, int i7) {
        o oVar = this.f1439x;
        if (i7 == 1) {
            oVar.f5501b = 0;
        } else {
            oVar.f5500a = 0;
        }
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.a(i7)) {
                c cVar = fVar.f1442a;
                if (cVar != null) {
                    cVar.u(this, childAt, view, i7);
                }
                if (i7 == 0) {
                    fVar.f1453n = false;
                } else if (i7 == 1) {
                    fVar.f1454o = false;
                }
                fVar.f1455p = false;
            }
        }
        this.f1432p = null;
    }

    @Override // p1.m
    public final void j(View view, int i7, int i8, int[] iArr, int i9) {
        c cVar;
        int childCount = getChildCount();
        boolean z6 = false;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i9) && (cVar = fVar.f1442a) != null) {
                    int[] iArr2 = this.f1427j;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVar.o(this, childAt, view, i7, i8, iArr2, i9);
                    int[] iArr3 = this.f1427j;
                    i10 = i7 > 0 ? Math.max(i10, iArr3[0]) : Math.min(i10, iArr3[0]);
                    int[] iArr4 = this.f1427j;
                    i11 = i8 > 0 ? Math.max(i11, iArr4[1]) : Math.min(i11, iArr4[1]);
                    z6 = true;
                }
            }
        }
        iArr[0] = i10;
        iArr[1] = i11;
        if (z6) {
            p(1);
        }
    }

    public final boolean l(View view, int i7, int i8) {
        Rect b2 = b();
        f(view, b2);
        try {
            return b2.contains(i7, i8);
        } finally {
            b2.setEmpty();
            C.a(b2);
        }
    }

    @Override // p1.n
    public final void m(View view, int i7, int i8, int i9, int i10, int i11, int[] iArr) {
        c cVar;
        int childCount = getChildCount();
        boolean z6 = false;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i11) && (cVar = fVar.f1442a) != null) {
                    int[] iArr2 = this.f1427j;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVar.p(this, childAt, i8, i9, i10, iArr2);
                    int[] iArr3 = this.f1427j;
                    i12 = i9 > 0 ? Math.max(i12, iArr3[0]) : Math.min(i12, iArr3[0]);
                    int[] iArr4 = this.f1427j;
                    i13 = i10 > 0 ? Math.max(i13, iArr4[1]) : Math.min(i13, iArr4[1]);
                    z6 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i12;
        iArr[1] = iArr[1] + i13;
        if (z6) {
            p(1);
        }
    }

    @Override // p1.m
    public final void n(View view, int i7, int i8, int i9, int i10, int i11) {
        m(view, i7, i8, i9, i10, 0, this.f1428k);
    }

    @Override // p1.m
    public final boolean o(View view, View view2, int i7, int i8) {
        int childCount = getChildCount();
        boolean z6 = false;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c cVar = fVar.f1442a;
                if (cVar != null) {
                    boolean t5 = cVar.t(this, childAt, view, view2, i7, i8);
                    z6 |= t5;
                    if (i8 == 0) {
                        fVar.f1453n = t5;
                    } else if (i8 == 1) {
                        fVar.f1454o = t5;
                    }
                } else if (i8 == 0) {
                    fVar.f1453n = false;
                } else if (i8 == 1) {
                    fVar.f1454o = false;
                }
            }
        }
        return z6;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        u(false);
        if (this.f1434r) {
            if (this.f1433q == null) {
                this.f1433q = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f1433q);
        }
        if (this.s == null) {
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            if (y.d.b(this)) {
                y.h.c(this);
            }
        }
        this.m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u(false);
        if (this.f1434r && this.f1433q != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f1433q);
        }
        View view = this.f1432p;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.m = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1435t && this.f1436u != null) {
            p0 p0Var = this.s;
            int e7 = p0Var != null ? p0Var.e() : 0;
            if (e7 > 0) {
                this.f1436u.setBounds(0, 0, getWidth(), e7);
                this.f1436u.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            u(true);
        }
        boolean s = s(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            u(true);
        }
        return s;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        c cVar;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        int d7 = y.e.d(this);
        int size = this.f1423f.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = (View) this.f1423f.get(i11);
            if (view.getVisibility() != 8 && ((cVar = ((f) view.getLayoutParams()).f1442a) == null || !cVar.l(this, view, d7))) {
                q(view, d7);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0190, code lost:
        if (r0.m(r30, r19, r24, r20, r25) == false) goto L_0x01a5;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0193  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f7, float f8, boolean z6) {
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(0)) {
                    c cVar = fVar.f1442a;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f7, float f8) {
        c cVar;
        int childCount = getChildCount();
        boolean z6 = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(0) && (cVar = fVar.f1442a) != null) {
                    z6 |= cVar.n(view);
                }
            }
        }
        return z6;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i7, int i8, int[] iArr) {
        j(view, i7, i8, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i7, int i8, int i9, int i10) {
        n(view, i7, i8, i9, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i7) {
        a(view, view2, i7, 0);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.f6374f);
        SparseArray<Parcelable> sparseArray = hVar.f1458h;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            int id = childAt.getId();
            c cVar = k(childAt).f1442a;
            if (!(id == -1 || cVar == null || (parcelable2 = sparseArray.get(id)) == null)) {
                cVar.r(childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable s;
        h hVar = new h(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            int id = childAt.getId();
            c cVar = ((f) childAt.getLayoutParams()).f1442a;
            if (!(id == -1 || cVar == null || (s = cVar.s(childAt)) == null)) {
                sparseArray.append(id, s);
            }
        }
        hVar.f1458h = sparseArray;
        return hVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i7) {
        return o(view, view2, i7, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        i(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r3 != false) goto L_0x0016;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f1431o
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0015
            boolean r3 = r0.s(r1, r4)
            if (r3 == 0) goto L_0x0029
            goto L_0x0016
        L_0x0015:
            r3 = r5
        L_0x0016:
            android.view.View r6 = r0.f1431o
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r6 = r6.f1442a
            if (r6 == 0) goto L_0x0029
            android.view.View r7 = r0.f1431o
            boolean r6 = r6.v(r0, r7, r1)
            goto L_0x002a
        L_0x0029:
            r6 = r5
        L_0x002a:
            android.view.View r7 = r0.f1431o
            r8 = 0
            if (r7 != 0) goto L_0x0035
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L_0x0048
        L_0x0035:
            if (r3 == 0) goto L_0x0048
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L_0x0048:
            if (r8 == 0) goto L_0x004d
            r8.recycle()
        L_0x004d:
            if (r2 == r4) goto L_0x0052
            r1 = 3
            if (r2 != r1) goto L_0x0055
        L_0x0052:
            r0.u(r5)
        L_0x0055:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(int i7) {
        int i8;
        boolean z6;
        boolean z7;
        boolean z8;
        int width;
        int i9;
        int i10;
        int i11;
        int height;
        int i12;
        int i13;
        int i14;
        int i15;
        c cVar;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        int d7 = y.e.d(this);
        int size = this.f1423f.size();
        Rect b2 = b();
        Rect b7 = b();
        Rect b8 = b();
        int i16 = 0;
        int i17 = i7;
        while (i16 < size) {
            View view = (View) this.f1423f.get(i16);
            f fVar = (f) view.getLayoutParams();
            if (i17 == 0 && view.getVisibility() == 8) {
                size = size;
                b8 = b8;
                i8 = i16;
            } else {
                int i18 = 0;
                while (i18 < i16) {
                    if (fVar.f1452l == ((View) this.f1423f.get(i18))) {
                        f fVar2 = (f) view.getLayoutParams();
                        if (fVar2.f1451k != null) {
                            Rect b9 = b();
                            Rect b10 = b();
                            Rect b11 = b();
                            f(fVar2.f1451k, b9);
                            d(view, b10, false);
                            int measuredWidth = view.getMeasuredWidth();
                            size = size;
                            int measuredHeight = view.getMeasuredHeight();
                            boolean z9 = true;
                            i16 = i16;
                            b8 = b8;
                            i15 = i18;
                            g(d7, b9, b11, fVar2, measuredWidth, measuredHeight);
                            if (b11.left == b10.left && b11.top == b10.top) {
                                z9 = false;
                            }
                            c(fVar2, b11, measuredWidth, measuredHeight);
                            int i19 = b11.left - b10.left;
                            int i20 = b11.top - b10.top;
                            if (i19 != 0) {
                                WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
                                view.offsetLeftAndRight(i19);
                            }
                            if (i20 != 0) {
                                WeakHashMap<View, k0> weakHashMap3 = y.f5540a;
                                view.offsetTopAndBottom(i20);
                            }
                            if (z9 && (cVar = fVar2.f1442a) != null) {
                                cVar.h(this, view, fVar2.f1451k);
                            }
                            b9.setEmpty();
                            o1.f fVar3 = C;
                            fVar3.a(b9);
                            b10.setEmpty();
                            fVar3.a(b10);
                            b11.setEmpty();
                            fVar3.a(b11);
                            i18 = i15 + 1;
                        }
                    }
                    i15 = i18;
                    size = size;
                    b8 = b8;
                    i16 = i16;
                    i18 = i15 + 1;
                }
                i8 = i16;
                d(view, b7, true);
                if (fVar.f1447g != 0 && !b7.isEmpty()) {
                    int absoluteGravity = Gravity.getAbsoluteGravity(fVar.f1447g, d7);
                    int i21 = absoluteGravity & 112;
                    if (i21 == 48) {
                        b2.top = Math.max(b2.top, b7.bottom);
                    } else if (i21 == 80) {
                        b2.bottom = Math.max(b2.bottom, getHeight() - b7.top);
                    }
                    int i22 = absoluteGravity & 7;
                    if (i22 == 3) {
                        b2.left = Math.max(b2.left, b7.right);
                    } else if (i22 == 5) {
                        b2.right = Math.max(b2.right, getWidth() - b7.left);
                    }
                }
                if (fVar.f1448h != 0 && view.getVisibility() == 0) {
                    WeakHashMap<View, k0> weakHashMap4 = y.f5540a;
                    if (y.g.c(view) && view.getWidth() > 0 && view.getHeight() > 0) {
                        f fVar4 = (f) view.getLayoutParams();
                        c cVar2 = fVar4.f1442a;
                        Rect b12 = b();
                        Rect b13 = b();
                        b13.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                        if (cVar2 == null || !cVar2.e(view)) {
                            b12.set(b13);
                        } else if (!b13.contains(b12)) {
                            StringBuilder d8 = androidx.activity.h.d("Rect should be within the child's bounds. Rect:");
                            d8.append(b12.toShortString());
                            d8.append(" | Bounds:");
                            d8.append(b13.toShortString());
                            throw new IllegalArgumentException(d8.toString());
                        }
                        b13.setEmpty();
                        o1.f fVar5 = C;
                        fVar5.a(b13);
                        if (!b12.isEmpty()) {
                            int absoluteGravity2 = Gravity.getAbsoluteGravity(fVar4.f1448h, d7);
                            if ((absoluteGravity2 & 48) != 48 || (i13 = (b12.top - ((ViewGroup.MarginLayoutParams) fVar4).topMargin) - fVar4.f1450j) >= (i14 = b2.top)) {
                                z7 = false;
                            } else {
                                w(view, i14 - i13);
                                z7 = true;
                            }
                            if ((absoluteGravity2 & 80) == 80 && (height = ((getHeight() - b12.bottom) - ((ViewGroup.MarginLayoutParams) fVar4).bottomMargin) + fVar4.f1450j) < (i12 = b2.bottom)) {
                                w(view, height - i12);
                                z7 = true;
                            }
                            if (!z7) {
                                w(view, 0);
                            }
                            if ((absoluteGravity2 & 3) != 3 || (i10 = (b12.left - ((ViewGroup.MarginLayoutParams) fVar4).leftMargin) - fVar4.f1449i) >= (i11 = b2.left)) {
                                z8 = false;
                            } else {
                                v(view, i11 - i10);
                                z8 = true;
                            }
                            if ((absoluteGravity2 & 5) == 5 && (width = ((getWidth() - b12.right) - ((ViewGroup.MarginLayoutParams) fVar4).rightMargin) + fVar4.f1449i) < (i9 = b2.right)) {
                                v(view, width - i9);
                                z8 = true;
                            }
                            if (!z8) {
                                v(view, 0);
                            }
                        }
                        b12.setEmpty();
                        fVar5.a(b12);
                    }
                }
                if (i7 != 2) {
                    b8 = b8;
                    b8.set(((f) view.getLayoutParams()).f1456q);
                    if (b8.equals(b7)) {
                        size = size;
                        i17 = i7;
                    } else {
                        ((f) view.getLayoutParams()).f1456q.set(b7);
                    }
                } else {
                    b8 = b8;
                }
                size = size;
                for (int i23 = i8 + 1; i23 < size; i23++) {
                    View view2 = (View) this.f1423f.get(i23);
                    f fVar6 = (f) view2.getLayoutParams();
                    c cVar3 = fVar6.f1442a;
                    if (cVar3 != null && cVar3.f(view2, view)) {
                        if (i7 != 0 || !fVar6.f1455p) {
                            if (i7 != 2) {
                                z6 = cVar3.h(this, view2, view);
                            } else {
                                cVar3.i(this, view);
                                z6 = true;
                            }
                            if (i7 == 1) {
                                fVar6.f1455p = z6;
                            }
                        } else {
                            fVar6.f1455p = false;
                        }
                    }
                }
                i17 = i7;
            }
            i16 = i8 + 1;
        }
        b2.setEmpty();
        o1.f fVar7 = C;
        fVar7.a(b2);
        b7.setEmpty();
        fVar7.a(b7);
        b8.setEmpty();
        fVar7.a(b8);
    }

    public final void q(View view, int i7) {
        Rect b2;
        Rect b7;
        o1.f fVar;
        f fVar2 = (f) view.getLayoutParams();
        View view2 = fVar2.f1451k;
        int i8 = 0;
        if (view2 == null && fVar2.f1446f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (view2 != null) {
            b2 = b();
            b7 = b();
            try {
                f(view2, b2);
                f fVar3 = (f) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                g(i7, b2, b7, fVar3, measuredWidth, measuredHeight);
                c(fVar3, b7, measuredWidth, measuredHeight);
                view.layout(b7.left, b7.top, b7.right, b7.bottom);
            } finally {
                b2.setEmpty();
                fVar = C;
                fVar.a(b2);
                b7.setEmpty();
                fVar.a(b7);
            }
        } else {
            int i9 = fVar2.e;
            if (i9 >= 0) {
                f fVar4 = (f) view.getLayoutParams();
                int i10 = fVar4.f1444c;
                if (i10 == 0) {
                    i10 = 8388661;
                }
                int absoluteGravity = Gravity.getAbsoluteGravity(i10, i7);
                int i11 = absoluteGravity & 7;
                int i12 = absoluteGravity & 112;
                int width = getWidth();
                int height = getHeight();
                int measuredWidth2 = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                if (i7 == 1) {
                    i9 = width - i9;
                }
                int h7 = h(i9) - measuredWidth2;
                if (i11 == 1) {
                    h7 += measuredWidth2 / 2;
                } else if (i11 == 5) {
                    h7 += measuredWidth2;
                }
                if (i12 == 16) {
                    i8 = 0 + (measuredHeight2 / 2);
                } else if (i12 == 80) {
                    i8 = measuredHeight2 + 0;
                }
                int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar4).leftMargin, Math.min(h7, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) fVar4).rightMargin));
                int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar4).topMargin, Math.min(i8, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) fVar4).bottomMargin));
                view.layout(max, max2, measuredWidth2 + max, measuredHeight2 + max2);
                return;
            }
            f fVar5 = (f) view.getLayoutParams();
            b2 = b();
            b2.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar5).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar5).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar5).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar5).bottomMargin);
            if (this.s != null) {
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                if (y.d.b(this) && !y.d.b(view)) {
                    b2.left = this.s.c() + b2.left;
                    b2.top = this.s.e() + b2.top;
                    b2.right -= this.s.d();
                    b2.bottom -= this.s.b();
                }
            }
            b7 = b();
            int i13 = fVar5.f1444c;
            if ((i13 & 7) == 0) {
                i13 |= 8388611;
            }
            if ((i13 & 112) == 0) {
                i13 |= 48;
            }
            p1.e.b(i13, view.getMeasuredWidth(), view.getMeasuredHeight(), b2, b7, i7);
            view.layout(b7.left, b7.top, b7.right, b7.bottom);
        }
    }

    public final void r(View view, int i7, int i8, int i9) {
        measureChildWithMargins(view, i7, i8, i9, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z6) {
        c cVar = ((f) view.getLayoutParams()).f1442a;
        if (cVar == null || !cVar.q(this, view, rect, z6)) {
            return super.requestChildRectangleOnScreen(view, rect, z6);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z6) {
        super.requestDisallowInterceptTouchEvent(z6);
        if (z6 && !this.f1429l) {
            u(false);
            this.f1429l = true;
        }
    }

    public final boolean s(MotionEvent motionEvent, int i7) {
        boolean z6;
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f1425h;
        arrayList.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i8 = childCount - 1; i8 >= 0; i8--) {
            arrayList.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i8) : i8));
        }
        i iVar = B;
        if (iVar != null) {
            Collections.sort(arrayList, iVar);
        }
        int size = arrayList.size();
        MotionEvent motionEvent2 = null;
        boolean z7 = false;
        boolean z8 = false;
        for (int i9 = 0; i9 < size; i9++) {
            View view = (View) arrayList.get(i9);
            f fVar = (f) view.getLayoutParams();
            c cVar = fVar.f1442a;
            if (!(z7 || z8) || actionMasked == 0) {
                if (!z7 && cVar != null) {
                    if (i7 == 0) {
                        z7 = cVar.k(this, view, motionEvent);
                    } else if (i7 == 1) {
                        z7 = cVar.v(this, view, motionEvent);
                    }
                    if (z7) {
                        this.f1431o = view;
                    }
                }
                if (fVar.f1442a == null) {
                    fVar.m = false;
                }
                boolean z9 = fVar.m;
                if (z9) {
                    z6 = true;
                } else {
                    z6 = z9 | false;
                    fVar.m = z6;
                }
                z8 = z6 && !z9;
                if (z6 && !z8) {
                    break;
                }
            } else if (cVar != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i7 == 0) {
                    cVar.k(this, view, motionEvent2);
                } else if (i7 == 1) {
                    cVar.v(this, view, motionEvent2);
                }
            }
        }
        arrayList.clear();
        return z7;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z6) {
        super.setFitsSystemWindows(z6);
        x();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f1437v = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f1436u;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f1436u = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f1436u.setState(getDrawableState());
                }
                Drawable drawable4 = this.f1436u;
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                a.c.b(drawable4, y.e.d(this));
                this.f1436u.setVisible(getVisibility() == 0, false);
                this.f1436u.setCallback(this);
            }
            WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
            y.d.k(this);
        }
    }

    public void setStatusBarBackgroundColor(int i7) {
        setStatusBarBackground(new ColorDrawable(i7));
    }

    public void setStatusBarBackgroundResource(int i7) {
        Drawable drawable;
        if (i7 != 0) {
            Context context = getContext();
            Object obj = g1.a.f4192a;
            drawable = a.c.b(context, i7);
        } else {
            drawable = null;
        }
        setStatusBarBackground(drawable);
    }

    @Override // android.view.View
    public void setVisibility(int i7) {
        super.setVisibility(i7);
        boolean z6 = i7 == 0;
        Drawable drawable = this.f1436u;
        if (drawable != null && drawable.isVisible() != z6) {
            this.f1436u.setVisible(z6, false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x007c, code lost:
        if (r5 != false) goto L_0x00cb;
     */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0184 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t() {
        /*
            Method dump skipped, instructions count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.t():void");
    }

    public final void u(boolean z6) {
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            c cVar = ((f) childAt.getLayoutParams()).f1442a;
            if (cVar != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z6) {
                    cVar.k(this, childAt, obtain);
                } else {
                    cVar.v(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            ((f) getChildAt(i8).getLayoutParams()).m = false;
        }
        this.f1431o = null;
        this.f1429l = false;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1436u;
    }

    public final void x() {
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        if (y.d.b(this)) {
            if (this.f1438w == null) {
                this.f1438w = new a();
            }
            y.i.u(this, this.f1438w);
            setSystemUiVisibility(1280);
            return;
        }
        y.i.u(this, null);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }
}
