package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.i0;
import androidx.appcompat.widget.p0;
import j.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l extends d implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: g  reason: collision with root package name */
    public final Context f639g;

    /* renamed from: h  reason: collision with root package name */
    public final f f640h;

    /* renamed from: i  reason: collision with root package name */
    public final e f641i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f642j;

    /* renamed from: k  reason: collision with root package name */
    public final int f643k;

    /* renamed from: l  reason: collision with root package name */
    public final int f644l;
    public final int m;

    /* renamed from: n  reason: collision with root package name */
    public final p0 f645n;

    /* renamed from: q  reason: collision with root package name */
    public PopupWindow.OnDismissListener f648q;

    /* renamed from: r  reason: collision with root package name */
    public View f649r;
    public View s;

    /* renamed from: t  reason: collision with root package name */
    public j.a f650t;

    /* renamed from: u  reason: collision with root package name */
    public ViewTreeObserver f651u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f652v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f653w;

    /* renamed from: x  reason: collision with root package name */
    public int f654x;

    /* renamed from: z  reason: collision with root package name */
    public boolean f656z;

    /* renamed from: o  reason: collision with root package name */
    public final a f646o = new a();

    /* renamed from: p  reason: collision with root package name */
    public final b f647p = new b();

    /* renamed from: y  reason: collision with root package name */
    public int f655y = 0;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (l.this.b()) {
                l lVar = l.this;
                if (!lVar.f645n.D) {
                    View view = lVar.s;
                    if (view == null || !view.isShown()) {
                        l.this.dismiss();
                    } else {
                        l.this.f645n.d();
                    }
                }
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = l.this.f651u;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    l.this.f651u = view.getViewTreeObserver();
                }
                l lVar = l.this;
                lVar.f651u.removeGlobalOnLayoutListener(lVar.f646o);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public l(int i7, int i8, Context context, View view, f fVar, boolean z6) {
        this.f639g = context;
        this.f640h = fVar;
        this.f642j = z6;
        this.f641i = new e(fVar, LayoutInflater.from(context), z6, 2131492883);
        this.f644l = i7;
        this.m = i8;
        Resources resources = context.getResources();
        this.f643k = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(2131099671));
        this.f649r = view;
        this.f645n = new p0(context, i7, i8);
        fVar.b(this, context);
    }

    @Override // androidx.appcompat.view.menu.j
    public final void a(f fVar, boolean z6) {
        if (fVar == this.f640h) {
            dismiss();
            j.a aVar = this.f650t;
            if (aVar != null) {
                aVar.a(fVar, z6);
            }
        }
    }

    @Override // j.f
    public final boolean b() {
        return !this.f652v && this.f645n.b();
    }

    @Override // j.f
    public final void d() {
        View view;
        Rect rect;
        boolean z6 = true;
        if (!b()) {
            if (this.f652v || (view = this.f649r) == null) {
                z6 = false;
            } else {
                this.s = view;
                this.f645n.E.setOnDismissListener(this);
                p0 p0Var = this.f645n;
                p0Var.f997u = this;
                p0Var.D = true;
                p0Var.E.setFocusable(true);
                View view2 = this.s;
                boolean z7 = this.f651u == null;
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                this.f651u = viewTreeObserver;
                if (z7) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f646o);
                }
                view2.addOnAttachStateChangeListener(this.f647p);
                p0 p0Var2 = this.f645n;
                p0Var2.f996t = view2;
                p0Var2.f994q = this.f655y;
                if (!this.f653w) {
                    this.f654x = d.m(this.f641i, this.f639g, this.f643k);
                    this.f653w = true;
                }
                this.f645n.r(this.f654x);
                this.f645n.E.setInputMethodMode(2);
                p0 p0Var3 = this.f645n;
                Rect rect2 = this.f4568f;
                if (rect2 != null) {
                    p0Var3.getClass();
                    rect = new Rect(rect2);
                } else {
                    rect = null;
                }
                p0Var3.C = rect;
                this.f645n.d();
                i0 i0Var = this.f645n.f986h;
                i0Var.setOnKeyListener(this);
                if (this.f656z && this.f640h.m != null) {
                    FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f639g).inflate(2131492882, (ViewGroup) i0Var, false);
                    TextView textView = (TextView) frameLayout.findViewById(16908310);
                    if (textView != null) {
                        textView.setText(this.f640h.m);
                    }
                    frameLayout.setEnabled(false);
                    i0Var.addHeaderView(frameLayout, null, false);
                }
                this.f645n.p(this.f641i);
                this.f645n.d();
            }
        }
        if (!z6) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // j.f
    public final void dismiss() {
        if (b()) {
            this.f645n.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final void f() {
        this.f653w = false;
        e eVar = this.f641i;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        }
    }

    @Override // j.f
    public final i0 g() {
        return this.f645n.f986h;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0072  */
    @Override // androidx.appcompat.view.menu.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(androidx.appcompat.view.menu.m r10) {
        /*
            r9 = this;
            boolean r0 = r10.hasVisibleItems()
            r1 = 0
            if (r0 == 0) goto L_0x007a
            androidx.appcompat.view.menu.i r0 = new androidx.appcompat.view.menu.i
            android.content.Context r5 = r9.f639g
            android.view.View r6 = r9.s
            boolean r8 = r9.f642j
            int r3 = r9.f644l
            int r4 = r9.m
            r2 = r0
            r7 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            androidx.appcompat.view.menu.j$a r2 = r9.f650t
            r0.f634i = r2
            j.d r3 = r0.f635j
            if (r3 == 0) goto L_0x0023
            r3.j(r2)
        L_0x0023:
            boolean r2 = j.d.u(r10)
            r0.f633h = r2
            j.d r3 = r0.f635j
            if (r3 == 0) goto L_0x0030
            r3.o(r2)
        L_0x0030:
            android.widget.PopupWindow$OnDismissListener r2 = r9.f648q
            r0.f636k = r2
            r2 = 0
            r9.f648q = r2
            androidx.appcompat.view.menu.f r2 = r9.f640h
            r2.c(r1)
            androidx.appcompat.widget.p0 r2 = r9.f645n
            int r3 = r2.f989k
            int r2 = r2.n()
            int r4 = r9.f655y
            android.view.View r5 = r9.f649r
            java.util.WeakHashMap<android.view.View, p1.k0> r6 = p1.y.f5540a
            int r5 = p1.y.e.d(r5)
            int r4 = android.view.Gravity.getAbsoluteGravity(r4, r5)
            r4 = r4 & 7
            r5 = 5
            if (r4 != r5) goto L_0x005e
            android.view.View r4 = r9.f649r
            int r4 = r4.getWidth()
            int r3 = r3 + r4
        L_0x005e:
            boolean r4 = r0.b()
            r5 = 1
            if (r4 == 0) goto L_0x0066
            goto L_0x006f
        L_0x0066:
            android.view.View r4 = r0.f631f
            if (r4 != 0) goto L_0x006c
            r0 = r1
            goto L_0x0070
        L_0x006c:
            r0.d(r3, r2, r5, r5)
        L_0x006f:
            r0 = r5
        L_0x0070:
            if (r0 == 0) goto L_0x007a
            androidx.appcompat.view.menu.j$a r9 = r9.f650t
            if (r9 == 0) goto L_0x0079
            r9.b(r10)
        L_0x0079:
            return r5
        L_0x007a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.l.h(androidx.appcompat.view.menu.m):boolean");
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void j(j.a aVar) {
        this.f650t = aVar;
    }

    @Override // j.d
    public final void l(f fVar) {
    }

    @Override // j.d
    public final void n(View view) {
        this.f649r = view;
    }

    @Override // j.d
    public final void o(boolean z6) {
        this.f641i.f574h = z6;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f652v = true;
        this.f640h.c(true);
        ViewTreeObserver viewTreeObserver = this.f651u;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f651u = this.s.getViewTreeObserver();
            }
            this.f651u.removeGlobalOnLayoutListener(this.f646o);
            this.f651u = null;
        }
        this.s.removeOnAttachStateChangeListener(this.f647p);
        PopupWindow.OnDismissListener onDismissListener = this.f648q;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i7, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i7 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // j.d
    public final void p(int i7) {
        this.f655y = i7;
    }

    @Override // j.d
    public final void q(int i7) {
        this.f645n.f989k = i7;
    }

    @Override // j.d
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.f648q = onDismissListener;
    }

    @Override // j.d
    public final void s(boolean z6) {
        this.f656z = z6;
    }

    @Override // j.d
    public final void t(int i7) {
        this.f645n.j(i7);
    }
}
