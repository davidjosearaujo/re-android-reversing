package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuView;
import f.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.WeakHashMap;
import p1.y;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    public int A;
    public int B;
    public CharSequence C;
    public CharSequence D;
    public ColorStateList E;
    public ColorStateList F;
    public boolean G;
    public boolean H;
    public final ArrayList I;
    public final ArrayList J;
    public final int[] K;
    public final p1.h L;
    public ArrayList M;
    public h N;
    public final a O;
    public c1 P;
    public androidx.appcompat.widget.c Q;
    public f R;
    public j.a S;
    public f.a T;
    public boolean U;
    public OnBackInvokedCallback V;
    public OnBackInvokedDispatcher W;

    /* renamed from: a0 */
    public boolean f770a0;

    /* renamed from: b0 */
    public final b f771b0;

    /* renamed from: f */
    public ActionMenuView f772f;

    /* renamed from: g */
    public c0 f773g;

    /* renamed from: h */
    public c0 f774h;

    /* renamed from: i */
    public n f775i;

    /* renamed from: j */
    public p f776j;

    /* renamed from: k */
    public Drawable f777k;

    /* renamed from: l */
    public CharSequence f778l;
    public n m;

    /* renamed from: n */
    public View f779n;

    /* renamed from: o */
    public Context f780o;

    /* renamed from: p */
    public int f781p;

    /* renamed from: q */
    public int f782q;

    /* renamed from: r */
    public int f783r;
    public int s;

    /* renamed from: t */
    public int f784t;

    /* renamed from: u */
    public int f785u;

    /* renamed from: v */
    public int f786v;

    /* renamed from: w */
    public int f787w;

    /* renamed from: x */
    public int f788x;

    /* renamed from: y */
    public s0 f789y;

    /* renamed from: z */
    public int f790z;

    /* loaded from: classes.dex */
    public class a implements ActionMenuView.e {
        public a() {
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        public final void run() {
            androidx.appcompat.widget.c cVar;
            ActionMenuView actionMenuView = Toolbar.this.f772f;
            if (actionMenuView == null || (cVar = actionMenuView.f707y) == null) {
                return;
            }
            cVar.l();
        }
    }

    /* loaded from: classes.dex */
    public class c implements f.a {
        public c() {
        }

        public final boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
            f.a aVar = Toolbar.this.T;
            return aVar != null && aVar.a(fVar, menuItem);
        }

        public final void b(androidx.appcompat.view.menu.f fVar) {
            androidx.appcompat.widget.c cVar = Toolbar.this.f772f.f707y;
            if (!(cVar != null && cVar.g())) {
                Iterator<p1.j> it = Toolbar.this.L.f5491a.iterator();
                while (it.hasNext()) {
                    it.next().getClass();
                }
            }
            f.a aVar = Toolbar.this.T;
            if (aVar != null) {
                aVar.b(fVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        public final void onClick(View view) {
            f fVar = Toolbar.this.R;
            androidx.appcompat.view.menu.h hVar = fVar == null ? null : fVar.f796g;
            if (hVar != null) {
                hVar.collapseActionView();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public static OnBackInvokedDispatcher a(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback b(Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new androidx.activity.t(2, runnable);
        }

        public static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        public static void d(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* loaded from: classes.dex */
    public class f implements androidx.appcompat.view.menu.j {

        /* renamed from: f */
        public androidx.appcompat.view.menu.f f795f;

        /* renamed from: g */
        public androidx.appcompat.view.menu.h f796g;

        public f() {
        }

        public final void a(androidx.appcompat.view.menu.f fVar, boolean z6) {
        }

        public final boolean c(androidx.appcompat.view.menu.h hVar) {
            View view = Toolbar.this.f779n;
            if (view instanceof i.b) {
                ((i.b) view).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f779n);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.m);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f779n = null;
            int size = toolbar3.J.size();
            while (true) {
                size--;
                if (size < 0) {
                    toolbar3.J.clear();
                    this.f796g = null;
                    Toolbar.this.requestLayout();
                    hVar.C = false;
                    hVar.f614n.p(false);
                    Toolbar.this.s();
                    return true;
                }
                toolbar3.addView((View) toolbar3.J.get(size));
            }
        }

        public final void e(Context context, androidx.appcompat.view.menu.f fVar) {
            androidx.appcompat.view.menu.h hVar;
            androidx.appcompat.view.menu.f fVar2 = this.f795f;
            if (fVar2 != null && (hVar = this.f796g) != null) {
                fVar2.d(hVar);
            }
            this.f795f = fVar;
        }

        public final void f() {
            if (this.f796g != null) {
                androidx.appcompat.view.menu.f fVar = this.f795f;
                boolean z6 = false;
                if (fVar != null) {
                    int size = fVar.size();
                    int i7 = 0;
                    while (true) {
                        if (i7 >= size) {
                            break;
                        } else if (this.f795f.getItem(i7) == this.f796g) {
                            z6 = true;
                            break;
                        } else {
                            i7++;
                        }
                    }
                }
                if (z6) {
                    return;
                }
                c(this.f796g);
            }
        }

        public final boolean h(androidx.appcompat.view.menu.m mVar) {
            return false;
        }

        public final boolean i() {
            return false;
        }

        public final boolean k(androidx.appcompat.view.menu.h hVar) {
            Toolbar.this.c();
            ViewParent parent = Toolbar.this.m.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.m);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.m);
            }
            Toolbar.this.f779n = hVar.getActionView();
            this.f796g = hVar;
            ViewParent parent2 = Toolbar.this.f779n.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f779n);
                }
                Toolbar.this.getClass();
                g gVar = new g();
                Toolbar toolbar4 = Toolbar.this;
                gVar.f3924a = 8388611 | (toolbar4.s & 112);
                gVar.f798b = 2;
                toolbar4.f779n.setLayoutParams(gVar);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f779n);
            }
            Toolbar toolbar6 = Toolbar.this;
            int childCount = toolbar6.getChildCount();
            while (true) {
                childCount--;
                if (childCount < 0) {
                    break;
                }
                View childAt = toolbar6.getChildAt(childCount);
                if (((g) childAt.getLayoutParams()).f798b != 2 && childAt != toolbar6.f772f) {
                    toolbar6.removeViewAt(childCount);
                    toolbar6.J.add(childAt);
                }
            }
            Toolbar.this.requestLayout();
            hVar.C = true;
            hVar.f614n.p(false);
            View view = Toolbar.this.f779n;
            if (view instanceof i.b) {
                ((i.b) view).onActionViewExpanded();
            }
            Toolbar.this.s();
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class g extends a.C0053a {

        /* renamed from: b */
        public int f798b;

        public g() {
            this.f798b = 0;
            this.f3924a = 8388627;
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f798b = 0;
        }

        public g(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f798b = 0;
        }

        public g(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f798b = 0;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public g(g gVar) {
            super((a.C0053a) gVar);
            this.f798b = 0;
            this.f798b = gVar.f798b;
        }

        public g(a.C0053a c0053a) {
            super(c0053a);
            this.f798b = 0;
        }
    }

    /* loaded from: classes.dex */
    public interface h {
    }

    /* loaded from: classes.dex */
    public static class i extends Kotlin_2.a {
        public static final Parcelable.Creator CREATOR = new a();

        /* renamed from: h */
        public int f799h;

        /* renamed from: i */
        public boolean f800i;

        /* loaded from: classes.dex */
        public class a implements Parcelable.ClassLoaderCreator {
            public final Object createFromParcel(Parcel parcel) {
                return new i(parcel, null);
            }

            public final Object[] newArray(int i7) {
                return new i[i7];
            }

            public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new i(parcel, classLoader);
            }
        }

        public i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f799h = parcel.readInt();
            this.f800i = parcel.readInt() != 0;
        }

        public i(Parcelable parcelable) {
            super(parcelable);
        }

        public final void writeToParcel(Parcel parcel, int i7) {
            parcel.writeParcelable(this.f6374f, i7);
            parcel.writeInt(this.f799h);
            parcel.writeInt(this.f800i ? 1 : 0);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, 2130904272);
        this.B = 8388627;
        this.I = new ArrayList();
        this.J = new ArrayList();
        this.K = new int[2];
        this.L = new p1.h();
        this.M = new ArrayList();
        this.O = new a();
        this.f771b0 = new b();
        Context context2 = getContext();
        int[] iArr = a0.e.T;
        a1 m = a1.m(context2, attributeSet, iArr, 2130904272);
        TypedArray typedArray = m.f831b;
        WeakHashMap<View, p1.k0> weakHashMap = p1.y.f5540a;
        y.m.d(this, context, iArr, attributeSet, typedArray, 2130904272, 0);
        this.f782q = m.i(28, 0);
        this.f783r = m.i(19, 0);
        this.B = m.f831b.getInteger(0, this.B);
        this.s = m.f831b.getInteger(2, 48);
        int c7 = m.c(22, 0);
        c7 = m.l(27) ? m.c(27, c7) : c7;
        this.f788x = c7;
        this.f787w = c7;
        this.f786v = c7;
        this.f785u = c7;
        int c8 = m.c(25, -1);
        if (c8 >= 0) {
            this.f785u = c8;
        }
        int c9 = m.c(24, -1);
        if (c9 >= 0) {
            this.f786v = c9;
        }
        int c10 = m.c(26, -1);
        if (c10 >= 0) {
            this.f787w = c10;
        }
        int c11 = m.c(23, -1);
        if (c11 >= 0) {
            this.f788x = c11;
        }
        this.f784t = m.d(13, -1);
        int c12 = m.c(9, Integer.MIN_VALUE);
        int c13 = m.c(5, Integer.MIN_VALUE);
        int d7 = m.d(7, 0);
        int d8 = m.d(8, 0);
        if (this.f789y == null) {
            this.f789y = new s0();
        }
        s0 s0Var = this.f789y;
        s0Var.f1037h = false;
        if (d7 != Integer.MIN_VALUE) {
            s0Var.e = d7;
            s0Var.f1031a = d7;
        }
        if (d8 != Integer.MIN_VALUE) {
            s0Var.f1035f = d8;
            s0Var.f1032b = d8;
        }
        if (c12 != Integer.MIN_VALUE || c13 != Integer.MIN_VALUE) {
            s0Var.a(c12, c13);
        }
        this.f790z = m.c(10, Integer.MIN_VALUE);
        this.A = m.c(6, Integer.MIN_VALUE);
        this.f777k = m.e(4);
        this.f778l = m.k(3);
        CharSequence k6 = m.k(21);
        if (!TextUtils.isEmpty(k6)) {
            setTitle(k6);
        }
        CharSequence k7 = m.k(18);
        if (!TextUtils.isEmpty(k7)) {
            setSubtitle(k7);
        }
        this.f780o = getContext();
        setPopupTheme(m.i(17, 0));
        Drawable e7 = m.e(16);
        if (e7 != null) {
            setNavigationIcon(e7);
        }
        CharSequence k8 = m.k(15);
        if (!TextUtils.isEmpty(k8)) {
            setNavigationContentDescription(k8);
        }
        Drawable e8 = m.e(11);
        if (e8 != null) {
            setLogo(e8);
        }
        CharSequence k9 = m.k(12);
        if (!TextUtils.isEmpty(k9)) {
            setLogoDescription(k9);
        }
        if (m.l(29)) {
            setTitleTextColor(m.b(29));
        }
        if (m.l(20)) {
            setSubtitleTextColor(m.b(20));
        }
        if (m.l(14)) {
            k(m.i(14, 0));
        }
        m.n();
    }

    public static g g(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof g ? new g((g) layoutParams) : layoutParams instanceof a.C0053a ? new g((a.C0053a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new g((ViewGroup.MarginLayoutParams) layoutParams) : new g(layoutParams);
    }

    private ArrayList getCurrentMenuItems() {
        ArrayList arrayList = new ArrayList();
        Menu menu = getMenu();
        for (int i7 = 0; i7 < menu.size(); i7++) {
            arrayList.add(menu.getItem(i7));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new i.f(getContext());
    }

    public static int i(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return p1.g.b(marginLayoutParams) + p1.g.c(marginLayoutParams);
    }

    public static int j(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(int i7, ArrayList arrayList) {
        WeakHashMap<View, p1.k0> weakHashMap = p1.y.f5540a;
        boolean z6 = y.e.d(this) == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i7, y.e.d(this));
        arrayList.clear();
        if (!z6) {
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f798b == 0 && r(childAt)) {
                    int i9 = gVar.f3924a;
                    WeakHashMap<View, p1.k0> weakHashMap2 = p1.y.f5540a;
                    int d7 = y.e.d(this);
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i9, d7) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = d7 == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i10 = childCount - 1; i10 >= 0; i10--) {
            View childAt2 = getChildAt(i10);
            g gVar2 = (g) childAt2.getLayoutParams();
            if (gVar2.f798b == 0 && r(childAt2)) {
                int i11 = gVar2.f3924a;
                WeakHashMap<View, p1.k0> weakHashMap3 = p1.y.f5540a;
                int d8 = y.e.d(this);
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i11, d8) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = d8 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    public final void b(View view, boolean z6) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        g gVar = layoutParams == null ? new g() : !checkLayoutParams(layoutParams) ? g(layoutParams) : (g) layoutParams;
        gVar.f798b = 1;
        if (!z6 || this.f779n == null) {
            addView(view, gVar);
            return;
        }
        view.setLayoutParams(gVar);
        this.J.add(view);
    }

    public final void c() {
        if (this.m == null) {
            n nVar = new n(getContext(), null, 2130904271);
            this.m = nVar;
            nVar.setImageDrawable(this.f777k);
            this.m.setContentDescription(this.f778l);
            g gVar = new g();
            gVar.f3924a = 8388611 | (this.s & 112);
            gVar.f798b = 2;
            this.m.setLayoutParams(gVar);
            this.m.setOnClickListener(new d());
        }
    }

    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof g);
    }

    public final void d() {
        e();
        ActionMenuView actionMenuView = this.f772f;
        if (actionMenuView.f703u == null) {
            androidx.appcompat.view.menu.f fVar = (androidx.appcompat.view.menu.f) actionMenuView.getMenu();
            if (this.R == null) {
                this.R = new f();
            }
            this.f772f.setExpandedActionViewsExclusive(true);
            fVar.b(this.R, this.f780o);
            s();
        }
    }

    public final void e() {
        if (this.f772f == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f772f = actionMenuView;
            actionMenuView.setPopupTheme(this.f781p);
            this.f772f.setOnMenuItemClickListener(this.O);
            ActionMenuView actionMenuView2 = this.f772f;
            j.a aVar = this.S;
            c cVar = new c();
            actionMenuView2.f708z = aVar;
            actionMenuView2.A = cVar;
            g gVar = new g();
            gVar.f3924a = 8388613 | (this.s & 112);
            this.f772f.setLayoutParams(gVar);
            b(this.f772f, false);
        }
    }

    public final void f() {
        if (this.f775i == null) {
            this.f775i = new n(getContext(), null, 2130904271);
            g gVar = new g();
            gVar.f3924a = 8388611 | (this.s & 112);
            this.f775i.setLayoutParams(gVar);
        }
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return g(layoutParams);
    }

    public CharSequence getCollapseContentDescription() {
        n nVar = this.m;
        if (nVar != null) {
            return nVar.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        n nVar = this.m;
        if (nVar != null) {
            return nVar.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        s0 s0Var = this.f789y;
        if (s0Var != null) {
            return s0Var.f1036g ? s0Var.f1031a : s0Var.f1032b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i7 = this.A;
        return i7 != Integer.MIN_VALUE ? i7 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        s0 s0Var = this.f789y;
        if (s0Var != null) {
            return s0Var.f1031a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        s0 s0Var = this.f789y;
        if (s0Var != null) {
            return s0Var.f1032b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        s0 s0Var = this.f789y;
        if (s0Var != null) {
            return s0Var.f1036g ? s0Var.f1032b : s0Var.f1031a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i7 = this.f790z;
        return i7 != Integer.MIN_VALUE ? i7 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.f fVar;
        ActionMenuView actionMenuView = this.f772f;
        return actionMenuView != null && (fVar = actionMenuView.f703u) != null && fVar.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.A, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        WeakHashMap<View, p1.k0> weakHashMap = p1.y.f5540a;
        return y.e.d(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        WeakHashMap<View, p1.k0> weakHashMap = p1.y.f5540a;
        return y.e.d(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f790z, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        p pVar = this.f776j;
        if (pVar != null) {
            return pVar.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        p pVar = this.f776j;
        if (pVar != null) {
            return pVar.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        d();
        return this.f772f.getMenu();
    }

    public View getNavButtonView() {
        return this.f775i;
    }

    public CharSequence getNavigationContentDescription() {
        n nVar = this.f775i;
        if (nVar != null) {
            return nVar.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        n nVar = this.f775i;
        if (nVar != null) {
            return nVar.getDrawable();
        }
        return null;
    }

    public androidx.appcompat.widget.c getOuterActionMenuPresenter() {
        return this.Q;
    }

    public Drawable getOverflowIcon() {
        d();
        return this.f772f.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f780o;
    }

    public int getPopupTheme() {
        return this.f781p;
    }

    public CharSequence getSubtitle() {
        return this.D;
    }

    public final TextView getSubtitleTextView() {
        return this.f774h;
    }

    public CharSequence getTitle() {
        return this.C;
    }

    public int getTitleMarginBottom() {
        return this.f788x;
    }

    public int getTitleMarginEnd() {
        return this.f786v;
    }

    public int getTitleMarginStart() {
        return this.f785u;
    }

    public int getTitleMarginTop() {
        return this.f787w;
    }

    public final TextView getTitleTextView() {
        return this.f773g;
    }

    public g0 getWrapper() {
        if (this.P == null) {
            this.P = new c1(this, true);
        }
        return this.P;
    }

    public final int h(View view, int i7) {
        g gVar = (g) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i8 = i7 > 0 ? (measuredHeight - i7) / 2 : 0;
        int i9 = gVar.f3924a & 112;
        if (i9 != 16 && i9 != 48 && i9 != 80) {
            i9 = this.B & 112;
        }
        if (i9 != 48) {
            if (i9 != 80) {
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i10 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                int i11 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
                if (i10 < i11) {
                    i10 = i11;
                } else {
                    int i12 = (((height - paddingBottom) - measuredHeight) - i10) - paddingTop;
                    int i13 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
                    if (i12 < i13) {
                        i10 = Math.max(0, i10 - (i13 - i12));
                    }
                }
                return paddingTop + i10;
            }
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin) - i8;
        }
        return getPaddingTop() - i8;
    }

    public void k(int i7) {
        getMenuInflater().inflate(i7, getMenu());
    }

    public final void l() {
        Iterator it = this.M.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        getMenu();
        ArrayList currentMenuItems = getCurrentMenuItems();
        p1.h hVar = this.L;
        getMenuInflater();
        Iterator<p1.j> it2 = hVar.f5491a.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
        ArrayList currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.M = currentMenuItems2;
    }

    public final boolean m(View view) {
        return view.getParent() == this || this.J.contains(view);
    }

    public final int n(View view, int i7, int i8, int[] iArr) {
        g gVar = (g) view.getLayoutParams();
        int i9 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - iArr[0];
        int max = Math.max(0, i9) + i7;
        iArr[0] = Math.max(0, -i9);
        int h7 = h(view, i8);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, h7, max + measuredWidth, view.getMeasuredHeight() + h7);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).rightMargin + max;
    }

    public final int o(View view, int i7, int i8, int[] iArr) {
        g gVar = (g) view.getLayoutParams();
        int i9 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - iArr[1];
        int max = i7 - Math.max(0, i9);
        iArr[1] = Math.max(0, -i9);
        int h7 = h(view, i8);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, h7, max, view.getMeasuredHeight() + h7);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).leftMargin);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        s();
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f771b0);
        s();
    }

    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.H = false;
        }
        if (!this.H) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.H = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.H = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x028a A[LOOP:0: B:107:0x0288->B:108:0x028a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02ac A[LOOP:1: B:110:0x02aa->B:111:0x02ac, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02d1 A[LOOP:2: B:113:0x02cf->B:114:0x02d1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0326 A[LOOP:3: B:122:0x0324->B:123:0x0326, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0213  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r21, int r22, int r23, int r24, int r25) {
        /*
            Method dump skipped, instructions count: 827
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0284  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 649
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onMeasure(int, int):void");
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof i)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.f6374f);
        ActionMenuView actionMenuView = this.f772f;
        androidx.appcompat.view.menu.f fVar = actionMenuView != null ? actionMenuView.f703u : null;
        int i7 = iVar.f799h;
        if (i7 != 0 && this.R != null && fVar != null && (findItem = fVar.findItem(i7)) != null) {
            findItem.expandActionView();
        }
        if (iVar.f800i) {
            removeCallbacks(this.f771b0);
            post(this.f771b0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002f, code lost:
        if (r0 != Integer.MIN_VALUE) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
        if (r0 != Integer.MIN_VALUE) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onRtlPropertiesChanged(int r2) {
        /*
            r1 = this;
            super.onRtlPropertiesChanged(r2)
            androidx.appcompat.widget.s0 r0 = r1.f789y
            if (r0 != 0) goto Le
            androidx.appcompat.widget.s0 r0 = new androidx.appcompat.widget.s0
            r0.<init>()
            r1.f789y = r0
        Le:
            androidx.appcompat.widget.s0 r1 = r1.f789y
            r0 = 1
            if (r2 != r0) goto L14
            goto L15
        L14:
            r0 = 0
        L15:
            boolean r2 = r1.f1036g
            if (r0 != r2) goto L1a
            goto L48
        L1a:
            r1.f1036g = r0
            boolean r2 = r1.f1037h
            if (r2 == 0) goto L40
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == 0) goto L32
            int r0 = r1.f1034d
            if (r0 == r2) goto L29
            goto L2b
        L29:
            int r0 = r1.e
        L2b:
            r1.f1031a = r0
            int r0 = r1.f1033c
            if (r0 == r2) goto L44
            goto L46
        L32:
            int r0 = r1.f1033c
            if (r0 == r2) goto L37
            goto L39
        L37:
            int r0 = r1.e
        L39:
            r1.f1031a = r0
            int r0 = r1.f1034d
            if (r0 == r2) goto L44
            goto L46
        L40:
            int r2 = r1.e
            r1.f1031a = r2
        L44:
            int r0 = r1.f1035f
        L46:
            r1.f1032b = r0
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onRtlPropertiesChanged(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
        if ((r3 != null && r3.g()) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.os.Parcelable onSaveInstanceState() {
        /*
            r3 = this;
            androidx.appcompat.widget.Toolbar$i r0 = new androidx.appcompat.widget.Toolbar$i
            android.os.Parcelable r1 = super.onSaveInstanceState()
            r0.<init>(r1)
            androidx.appcompat.widget.Toolbar$f r1 = r3.R
            if (r1 == 0) goto L15
            androidx.appcompat.view.menu.h r1 = r1.f796g
            if (r1 == 0) goto L15
            int r1 = r1.f603a
            r0.f799h = r1
        L15:
            androidx.appcompat.widget.ActionMenuView r3 = r3.f772f
            r1 = 1
            r2 = 0
            if (r3 == 0) goto L2b
            androidx.appcompat.widget.c r3 = r3.f707y
            if (r3 == 0) goto L27
            boolean r3 = r3.g()
            if (r3 == 0) goto L27
            r3 = r1
            goto L28
        L27:
            r3 = r2
        L28:
            if (r3 == 0) goto L2b
            goto L2c
        L2b:
            r1 = r2
        L2c:
            r0.f800i = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onSaveInstanceState():android.os.Parcelable");
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.G = false;
        }
        if (!this.G) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.G = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.G = false;
        }
        return true;
    }

    public final int p(View view, int i7, int i8, int i9, int i10, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i11 = marginLayoutParams.leftMargin - iArr[0];
        int i12 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i12) + Math.max(0, i11);
        iArr[0] = Math.max(0, -i11);
        iArr[1] = Math.max(0, -i12);
        view.measure(ViewGroup.getChildMeasureSpec(i7, getPaddingRight() + getPaddingLeft() + max + i8, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i9, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i10, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    public final void q(View view, int i7, int i8, int i9, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i7, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i8, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i9, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + 0, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i10 >= 0) {
            if (mode != 0) {
                i10 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i10);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final boolean r(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void s() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher a7 = e.a(this);
            f fVar = this.R;
            boolean z6 = false;
            if (((fVar == null || fVar.f796g == null) ? false : true) && a7 != null) {
                WeakHashMap<View, p1.k0> weakHashMap = p1.y.f5540a;
                if (y.g.b(this) && this.f770a0) {
                    z6 = true;
                }
            }
            if (z6 && this.W == null) {
                if (this.V == null) {
                    this.V = e.b(new androidx.activity.k(1, this));
                }
                e.c(a7, this.V);
            } else if (z6 || (onBackInvokedDispatcher = this.W) == null) {
                return;
            } else {
                e.d(onBackInvokedDispatcher, this.V);
                a7 = null;
            }
            this.W = a7;
        }
    }

    public void setBackInvokedCallbackEnabled(boolean z6) {
        if (this.f770a0 != z6) {
            this.f770a0 = z6;
            s();
        }
    }

    public void setCollapseContentDescription(int i7) {
        setCollapseContentDescription(i7 != 0 ? getContext().getText(i7) : null);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        n nVar = this.m;
        if (nVar != null) {
            nVar.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(int i7) {
        setCollapseIcon(g.a.a(getContext(), i7));
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.m.setImageDrawable(drawable);
            return;
        }
        n nVar = this.m;
        if (nVar != null) {
            nVar.setImageDrawable(this.f777k);
        }
    }

    public void setCollapsible(boolean z6) {
        this.U = z6;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i7) {
        if (i7 < 0) {
            i7 = Integer.MIN_VALUE;
        }
        if (i7 != this.A) {
            this.A = i7;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i7) {
        if (i7 < 0) {
            i7 = Integer.MIN_VALUE;
        }
        if (i7 != this.f790z) {
            this.f790z = i7;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i7) {
        setLogo(g.a.a(getContext(), i7));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f776j == null) {
                this.f776j = new p(getContext(), null);
            }
            if (!m(this.f776j)) {
                b(this.f776j, true);
            }
        } else {
            p pVar = this.f776j;
            if (pVar != null && m(pVar)) {
                removeView(this.f776j);
                this.J.remove(this.f776j);
            }
        }
        p pVar2 = this.f776j;
        if (pVar2 != null) {
            pVar2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i7) {
        setLogoDescription(getContext().getText(i7));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f776j == null) {
            this.f776j = new p(getContext(), null);
        }
        p pVar = this.f776j;
        if (pVar != null) {
            pVar.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i7) {
        setNavigationContentDescription(i7 != 0 ? getContext().getText(i7) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            f();
        }
        n nVar = this.f775i;
        if (nVar != null) {
            nVar.setContentDescription(charSequence);
            d1.a(this.f775i, charSequence);
        }
    }

    public void setNavigationIcon(int i7) {
        setNavigationIcon(g.a.a(getContext(), i7));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            f();
            if (!m(this.f775i)) {
                b(this.f775i, true);
            }
        } else {
            n nVar = this.f775i;
            if (nVar != null && m(nVar)) {
                removeView(this.f775i);
                this.J.remove(this.f775i);
            }
        }
        n nVar2 = this.f775i;
        if (nVar2 != null) {
            nVar2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        f();
        this.f775i.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(h hVar) {
        this.N = hVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        d();
        this.f772f.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i7) {
        if (this.f781p != i7) {
            this.f781p = i7;
            if (i7 == 0) {
                this.f780o = getContext();
            } else {
                this.f780o = new ContextThemeWrapper(getContext(), i7);
            }
        }
    }

    public void setSubtitle(int i7) {
        setSubtitle(getContext().getText(i7));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            c0 c0Var = this.f774h;
            if (c0Var != null && m(c0Var)) {
                removeView(this.f774h);
                this.J.remove(this.f774h);
            }
        } else {
            if (this.f774h == null) {
                Context context = getContext();
                c0 c0Var2 = new c0(context, null);
                this.f774h = c0Var2;
                c0Var2.setSingleLine();
                this.f774h.setEllipsize(TextUtils.TruncateAt.END);
                int i7 = this.f783r;
                if (i7 != 0) {
                    this.f774h.setTextAppearance(context, i7);
                }
                ColorStateList colorStateList = this.F;
                if (colorStateList != null) {
                    this.f774h.setTextColor(colorStateList);
                }
            }
            if (!m(this.f774h)) {
                b(this.f774h, true);
            }
        }
        c0 c0Var3 = this.f774h;
        if (c0Var3 != null) {
            c0Var3.setText(charSequence);
        }
        this.D = charSequence;
    }

    public void setSubtitleTextColor(int i7) {
        setSubtitleTextColor(ColorStateList.valueOf(i7));
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.F = colorStateList;
        c0 c0Var = this.f774h;
        if (c0Var != null) {
            c0Var.setTextColor(colorStateList);
        }
    }

    public void setTitle(int i7) {
        setTitle(getContext().getText(i7));
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            c0 c0Var = this.f773g;
            if (c0Var != null && m(c0Var)) {
                removeView(this.f773g);
                this.J.remove(this.f773g);
            }
        } else {
            if (this.f773g == null) {
                Context context = getContext();
                c0 c0Var2 = new c0(context, null);
                this.f773g = c0Var2;
                c0Var2.setSingleLine();
                this.f773g.setEllipsize(TextUtils.TruncateAt.END);
                int i7 = this.f782q;
                if (i7 != 0) {
                    this.f773g.setTextAppearance(context, i7);
                }
                ColorStateList colorStateList = this.E;
                if (colorStateList != null) {
                    this.f773g.setTextColor(colorStateList);
                }
            }
            if (!m(this.f773g)) {
                b(this.f773g, true);
            }
        }
        c0 c0Var3 = this.f773g;
        if (c0Var3 != null) {
            c0Var3.setText(charSequence);
        }
        this.C = charSequence;
    }

    public void setTitleMarginBottom(int i7) {
        this.f788x = i7;
        requestLayout();
    }

    public void setTitleMarginEnd(int i7) {
        this.f786v = i7;
        requestLayout();
    }

    public void setTitleMarginStart(int i7) {
        this.f785u = i7;
        requestLayout();
    }

    public void setTitleMarginTop(int i7) {
        this.f787w = i7;
        requestLayout();
    }

    public void setTitleTextColor(int i7) {
        setTitleTextColor(ColorStateList.valueOf(i7));
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.E = colorStateList;
        c0 c0Var = this.f773g;
        if (c0Var != null) {
            c0Var.setTextColor(colorStateList);
        }
    }
}
