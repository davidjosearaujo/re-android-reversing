package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import j1.a;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c extends androidx.appcompat.view.menu.a {
    public b A;
    public final f B;

    /* renamed from: n */
    public d f839n;

    /* renamed from: o */
    public Drawable f840o;

    /* renamed from: p */
    public boolean f841p;

    /* renamed from: q */
    public boolean f842q;

    /* renamed from: r */
    public boolean f843r;
    public int s;

    /* renamed from: t */
    public int f844t;

    /* renamed from: u */
    public int f845u;

    /* renamed from: v */
    public boolean f846v;

    /* renamed from: w */
    public final SparseBooleanArray f847w;

    /* renamed from: x */
    public e f848x;

    /* renamed from: y */
    public a f849y;

    /* renamed from: z */
    public RunnableC0009c f850z;

    /* loaded from: classes.dex */
    public class a extends androidx.appcompat.view.menu.i {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, androidx.appcompat.view.menu.m mVar, View view) {
            super(context, mVar, view, false);
            c.this = r2;
            if (!((mVar.A.f623x & 32) == 32)) {
                View view2 = r2.f839n;
                this.f631f = view2 == null ? (View) r2.m : view2;
            }
            f fVar = r2.B;
            this.f634i = fVar;
            j.d dVar = this.f635j;
            if (dVar != null) {
                dVar.j(fVar);
            }
        }

        @Override // androidx.appcompat.view.menu.i
        public final void c() {
            c.this.f849y = null;
            super.c();
        }
    }

    /* loaded from: classes.dex */
    public class b extends ActionMenuItemView.b {
        public b() {
            c.this = r1;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$c */
    /* loaded from: classes.dex */
    public class RunnableC0009c implements Runnable {

        /* renamed from: f */
        public e f852f;

        public RunnableC0009c(e eVar) {
            c.this = r1;
            this.f852f = eVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f.a aVar;
            androidx.appcompat.view.menu.f fVar = c.this.f531h;
            if (fVar != null && (aVar = fVar.e) != null) {
                aVar.b(fVar);
            }
            View view = (View) c.this.m;
            if (view != null && view.getWindowToken() != null) {
                e eVar = this.f852f;
                boolean z6 = true;
                if (!eVar.b()) {
                    if (eVar.f631f == null) {
                        z6 = false;
                    } else {
                        eVar.d(0, 0, false, false);
                    }
                }
                if (z6) {
                    c.this.f848x = this.f852f;
                }
            }
            c.this.f850z = null;
        }
    }

    /* loaded from: classes.dex */
    public class d extends p implements ActionMenuView.a {

        /* loaded from: classes.dex */
        public class a extends k0 {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(View view) {
                super(view);
                d.this = r1;
            }

            @Override // androidx.appcompat.widget.k0
            public final j.f b() {
                e eVar = c.this.f848x;
                if (eVar == null) {
                    return null;
                }
                return eVar.a();
            }

            @Override // androidx.appcompat.widget.k0
            public final boolean c() {
                c.this.l();
                return true;
            }

            @Override // androidx.appcompat.widget.k0
            public final boolean d() {
                c cVar = c.this;
                if (cVar.f850z != null) {
                    return false;
                }
                cVar.d();
                return true;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context) {
            super(context, null, 2130903073);
            c.this = r2;
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            d1.a(this, getContentDescription());
            setOnTouchListener(new a(this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public final boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public final boolean b() {
            return false;
        }

        @Override // android.view.View
        public final boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.l();
            return true;
        }

        @Override // android.widget.ImageView
        public final boolean setFrame(int i7, int i8, int i9, int i10) {
            boolean frame = super.setFrame(i7, i8, i9, i10);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                a.b.f(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* loaded from: classes.dex */
    public class e extends androidx.appcompat.view.menu.i {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context, androidx.appcompat.view.menu.f fVar, d dVar) {
            super(context, fVar, dVar, true);
            c.this = r2;
            this.f632g = 8388613;
            f fVar2 = r2.B;
            this.f634i = fVar2;
            j.d dVar2 = this.f635j;
            if (dVar2 != null) {
                dVar2.j(fVar2);
            }
        }

        @Override // androidx.appcompat.view.menu.i
        public final void c() {
            androidx.appcompat.view.menu.f fVar = c.this.f531h;
            if (fVar != null) {
                fVar.c(true);
            }
            c.this.f848x = null;
            super.c();
        }
    }

    /* loaded from: classes.dex */
    public class f implements j.a {
        public f() {
            c.this = r1;
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final void a(androidx.appcompat.view.menu.f fVar, boolean z6) {
            if (fVar instanceof androidx.appcompat.view.menu.m) {
                fVar.k().c(false);
            }
            j.a aVar = c.this.f533j;
            if (aVar != null) {
                aVar.a(fVar, z6);
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final boolean b(androidx.appcompat.view.menu.f fVar) {
            c cVar = c.this;
            if (fVar == cVar.f531h) {
                return false;
            }
            ((androidx.appcompat.view.menu.m) fVar).A.getClass();
            cVar.getClass();
            j.a aVar = c.this.f533j;
            if (aVar != null) {
                return aVar.b(fVar);
            }
            return false;
        }
    }

    public c(Context context) {
        super(context);
        this.f847w = new SparseBooleanArray();
        this.B = new f();
    }

    @Override // androidx.appcompat.view.menu.j
    public final void a(androidx.appcompat.view.menu.f fVar, boolean z6) {
        d();
        a aVar = this.f849y;
        if (aVar != null && aVar.b()) {
            aVar.f635j.dismiss();
        }
        j.a aVar2 = this.f533j;
        if (aVar2 != null) {
            aVar2.a(fVar, z6);
        }
    }

    public final View b(androidx.appcompat.view.menu.h hVar, View view, ViewGroup viewGroup) {
        View actionView = hVar.getActionView();
        if (actionView == null || hVar.e()) {
            k.a aVar = view instanceof k.a ? (k.a) view : (k.a) this.f532i.inflate(this.f535l, viewGroup, false);
            aVar.c(hVar);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
            actionMenuItemView.setItemInvoker((ActionMenuView) this.m);
            if (this.A == null) {
                this.A = new b();
            }
            actionMenuItemView.setPopupCallback(this.A);
            actionView = (View) aVar;
        }
        actionView.setVisibility(hVar.C ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!((ActionMenuView) viewGroup).checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.j(layoutParams));
        }
        return actionView;
    }

    public final boolean d() {
        androidx.appcompat.view.menu.k kVar;
        RunnableC0009c runnableC0009c = this.f850z;
        if (runnableC0009c != null && (kVar = this.m) != null) {
            ((View) kVar).removeCallbacks(runnableC0009c);
            this.f850z = null;
            return true;
        }
        e eVar = this.f848x;
        if (eVar != null) {
            if (eVar.b()) {
                eVar.f635j.dismiss();
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void e(Context context, androidx.appcompat.view.menu.f fVar) {
        this.f530g = context;
        LayoutInflater.from(context);
        this.f531h = fVar;
        Resources resources = context.getResources();
        if (!this.f843r) {
            this.f842q = true;
        }
        int i7 = 2;
        this.s = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i8 = configuration.screenWidthDp;
        int i9 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i8 > 600 || ((i8 > 960 && i9 > 720) || (i8 > 720 && i9 > 960))) {
            i7 = 5;
        } else if (i8 >= 500 || ((i8 > 640 && i9 > 480) || (i8 > 480 && i9 > 640))) {
            i7 = 4;
        } else if (i8 >= 360) {
            i7 = 3;
        }
        this.f845u = i7;
        int i10 = this.s;
        if (this.f842q) {
            if (this.f839n == null) {
                d dVar = new d(this.f529f);
                this.f839n = dVar;
                if (this.f841p) {
                    dVar.setImageDrawable(this.f840o);
                    this.f840o = null;
                    this.f841p = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f839n.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i10 -= this.f839n.getMeasuredWidth();
        } else {
            this.f839n = null;
        }
        this.f844t = i10;
        float f7 = resources.getDisplayMetrics().density;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void f() {
        int i7;
        boolean z6;
        ViewGroup viewGroup = (ViewGroup) this.m;
        boolean z7 = false;
        ArrayList<androidx.appcompat.view.menu.h> arrayList = null;
        if (viewGroup != null) {
            androidx.appcompat.view.menu.f fVar = this.f531h;
            if (fVar != null) {
                fVar.i();
                ArrayList<androidx.appcompat.view.menu.h> l6 = this.f531h.l();
                int size = l6.size();
                i7 = 0;
                for (int i8 = 0; i8 < size; i8++) {
                    androidx.appcompat.view.menu.h hVar = l6.get(i8);
                    if ((hVar.f623x & 32) == 32) {
                        View childAt = viewGroup.getChildAt(i7);
                        androidx.appcompat.view.menu.h itemData = childAt instanceof k.a ? ((k.a) childAt).getItemData() : null;
                        View b2 = b(hVar, childAt, viewGroup);
                        if (hVar != itemData) {
                            b2.setPressed(false);
                            b2.jumpDrawablesToCurrentState();
                        }
                        if (b2 != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) b2.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(b2);
                            }
                            ((ViewGroup) this.m).addView(b2, i7);
                        }
                        i7++;
                    }
                }
            } else {
                i7 = 0;
            }
            while (i7 < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i7) == this.f839n) {
                    z6 = false;
                } else {
                    viewGroup.removeViewAt(i7);
                    z6 = true;
                }
                if (!z6) {
                    i7++;
                }
            }
        }
        ((View) this.m).requestLayout();
        androidx.appcompat.view.menu.f fVar2 = this.f531h;
        if (fVar2 != null) {
            fVar2.i();
            ArrayList<androidx.appcompat.view.menu.h> arrayList2 = fVar2.f586i;
            int size2 = arrayList2.size();
            for (int i9 = 0; i9 < size2; i9++) {
                p1.b bVar = arrayList2.get(i9).A;
            }
        }
        androidx.appcompat.view.menu.f fVar3 = this.f531h;
        if (fVar3 != null) {
            fVar3.i();
            arrayList = fVar3.f587j;
        }
        if (this.f842q && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z7 = !arrayList.get(0).C;
            } else if (size3 > 0) {
                z7 = true;
            }
        }
        d dVar = this.f839n;
        if (z7) {
            if (dVar == null) {
                this.f839n = new d(this.f529f);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f839n.getParent();
            if (viewGroup3 != this.m) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.f839n);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.m;
                d dVar2 = this.f839n;
                actionMenuView.getClass();
                ActionMenuView.c cVar = new ActionMenuView.c();
                ((LinearLayout.LayoutParams) cVar).gravity = 16;
                cVar.f709a = true;
                actionMenuView.addView(dVar2, cVar);
            }
        } else if (dVar != null) {
            ViewParent parent = dVar.getParent();
            androidx.appcompat.view.menu.k kVar = this.m;
            if (parent == kVar) {
                ((ViewGroup) kVar).removeView(this.f839n);
            }
        }
        ((ActionMenuView) this.m).setOverflowReserved(this.f842q);
    }

    public final boolean g() {
        e eVar = this.f848x;
        return eVar != null && eVar.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:217:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x008f  */
    @Override // androidx.appcompat.view.menu.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean h(androidx.appcompat.view.menu.m r9) {
        /*
            r8 = this;
            boolean r0 = r9.hasVisibleItems()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            r0 = r9
        L9:
            androidx.appcompat.view.menu.f r2 = r0.f659z
            androidx.appcompat.view.menu.f r3 = r8.f531h
            if (r2 == r3) goto L13
            r0 = r2
            androidx.appcompat.view.menu.m r0 = (androidx.appcompat.view.menu.m) r0
            goto L9
        L13:
            androidx.appcompat.view.menu.h r0 = r0.A
            androidx.appcompat.view.menu.k r2 = r8.m
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r3 = 0
            if (r2 != 0) goto L1d
            goto L3a
        L1d:
            int r4 = r2.getChildCount()
            r5 = r1
        L22:
            if (r5 >= r4) goto L3a
            android.view.View r6 = r2.getChildAt(r5)
            boolean r7 = r6 instanceof androidx.appcompat.view.menu.k.a
            if (r7 == 0) goto L37
            r7 = r6
            androidx.appcompat.view.menu.k$a r7 = (androidx.appcompat.view.menu.k.a) r7
            androidx.appcompat.view.menu.h r7 = r7.getItemData()
            if (r7 != r0) goto L37
            r3 = r6
            goto L3a
        L37:
            int r5 = r5 + 1
            goto L22
        L3a:
            if (r3 != 0) goto L3d
            return r1
        L3d:
            androidx.appcompat.view.menu.h r0 = r9.A
            r0.getClass()
            int r0 = r9.size()
            r2 = r1
        L47:
            r4 = 1
            if (r2 >= r0) goto L5f
            android.view.MenuItem r5 = r9.getItem(r2)
            boolean r6 = r5.isVisible()
            if (r6 == 0) goto L5c
            android.graphics.drawable.Drawable r5 = r5.getIcon()
            if (r5 == 0) goto L5c
            r0 = r4
            goto L60
        L5c:
            int r2 = r2 + 1
            goto L47
        L5f:
            r0 = r1
        L60:
            androidx.appcompat.widget.c$a r2 = new androidx.appcompat.widget.c$a
            android.content.Context r5 = r8.f530g
            r2.<init>(r5, r9, r3)
            r8.f849y = r2
            r2.f633h = r0
            j.d r2 = r2.f635j
            if (r2 == 0) goto L72
            r2.o(r0)
        L72:
            androidx.appcompat.widget.c$a r0 = r8.f849y
            boolean r2 = r0.b()
            if (r2 == 0) goto L7c
        L7a:
            r1 = r4
            goto L85
        L7c:
            android.view.View r2 = r0.f631f
            if (r2 != 0) goto L81
            goto L85
        L81:
            r0.d(r1, r1, r1, r1)
            goto L7a
        L85:
            if (r1 == 0) goto L8f
            androidx.appcompat.view.menu.j$a r8 = r8.f533j
            if (r8 == 0) goto L8e
            r8.b(r9)
        L8e:
            return r4
        L8f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "MenuPopupHelper cannot be used without an anchor"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.c.h(androidx.appcompat.view.menu.m):boolean");
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean i() {
        int i7;
        ArrayList<androidx.appcompat.view.menu.h> arrayList;
        int i8;
        boolean z6;
        c cVar = this;
        androidx.appcompat.view.menu.f fVar = cVar.f531h;
        if (fVar != null) {
            arrayList = fVar.l();
            i7 = arrayList.size();
        } else {
            i7 = 0;
            arrayList = null;
        }
        int i9 = cVar.f845u;
        int i10 = cVar.f844t;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.m;
        int i11 = 0;
        boolean z7 = false;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            i8 = 2;
            z6 = true;
            if (i11 >= i7) {
                break;
            }
            androidx.appcompat.view.menu.h hVar = arrayList.get(i11);
            int i14 = hVar.f624y;
            if ((i14 & 2) == 2) {
                i12++;
            } else if ((i14 & 1) == 1) {
                i13++;
            } else {
                z7 = true;
            }
            if (cVar.f846v && hVar.C) {
                i9 = 0;
            }
            i11++;
        }
        if (cVar.f842q && (z7 || i13 + i12 > i9)) {
            i9--;
        }
        int i15 = i9 - i12;
        SparseBooleanArray sparseBooleanArray = cVar.f847w;
        sparseBooleanArray.clear();
        int i16 = 0;
        int i17 = 0;
        while (i16 < i7) {
            androidx.appcompat.view.menu.h hVar2 = arrayList.get(i16);
            int i18 = hVar2.f624y;
            if ((i18 & 2) == i8 ? z6 : false) {
                View b2 = cVar.b(hVar2, null, viewGroup);
                b2.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = b2.getMeasuredWidth();
                i10 -= measuredWidth;
                if (i17 == 0) {
                    i17 = measuredWidth;
                }
                int i19 = hVar2.f604b;
                if (i19 != 0) {
                    sparseBooleanArray.put(i19, z6);
                }
                hVar2.f(z6);
            } else if ((i18 & 1) == z6 ? z6 : false) {
                int i20 = hVar2.f604b;
                boolean z8 = sparseBooleanArray.get(i20);
                boolean z9 = ((i15 > 0 || z8) && i10 > 0) ? z6 : false;
                if (z9) {
                    View b7 = cVar.b(hVar2, null, viewGroup);
                    b7.measure(makeMeasureSpec, makeMeasureSpec);
                    int measuredWidth2 = b7.getMeasuredWidth();
                    i10 -= measuredWidth2;
                    if (i17 == 0) {
                        i17 = measuredWidth2;
                    }
                    z9 &= i10 + i17 > 0;
                }
                if (z9 && i20 != 0) {
                    sparseBooleanArray.put(i20, true);
                } else if (z8) {
                    sparseBooleanArray.put(i20, false);
                    for (int i21 = 0; i21 < i16; i21++) {
                        androidx.appcompat.view.menu.h hVar3 = arrayList.get(i21);
                        if (hVar3.f604b == i20) {
                            if ((hVar3.f623x & 32) == 32) {
                                i15++;
                            }
                            hVar3.f(false);
                        }
                    }
                }
                if (z9) {
                    i15--;
                }
                hVar2.f(z9);
            } else {
                hVar2.f(false);
                i16++;
                i8 = 2;
                cVar = this;
                z6 = true;
            }
            i16++;
            i8 = 2;
            cVar = this;
            z6 = true;
        }
        return z6;
    }

    public final boolean l() {
        androidx.appcompat.view.menu.f fVar;
        if (!this.f842q || g() || (fVar = this.f531h) == null || this.m == null || this.f850z != null) {
            return false;
        }
        fVar.i();
        if (fVar.f587j.isEmpty()) {
            return false;
        }
        RunnableC0009c runnableC0009c = new RunnableC0009c(new e(this.f530g, this.f531h, this.f839n));
        this.f850z = runnableC0009c;
        ((View) this.m).post(runnableC0009c);
        return true;
    }
}
