package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.i0;
import androidx.appcompat.widget.o0;
import androidx.appcompat.widget.p0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b extends j.d implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public boolean B;
    public j.a C;
    public ViewTreeObserver D;
    public PopupWindow.OnDismissListener E;
    public boolean F;

    /* renamed from: g */
    public final Context f536g;

    /* renamed from: h */
    public final int f537h;

    /* renamed from: i */
    public final int f538i;

    /* renamed from: j */
    public final int f539j;

    /* renamed from: k */
    public final boolean f540k;

    /* renamed from: l */
    public final Handler f541l;

    /* renamed from: t */
    public View f547t;

    /* renamed from: u */
    public View f548u;

    /* renamed from: v */
    public int f549v;

    /* renamed from: w */
    public boolean f550w;

    /* renamed from: x */
    public boolean f551x;

    /* renamed from: y */
    public int f552y;

    /* renamed from: z */
    public int f553z;
    public final ArrayList m = new ArrayList();

    /* renamed from: n */
    public final ArrayList f542n = new ArrayList();

    /* renamed from: o */
    public final a f543o = new a();

    /* renamed from: p */
    public final View$OnAttachStateChangeListenerC0007b f544p = new View$OnAttachStateChangeListenerC0007b();

    /* renamed from: q */
    public final c f545q = new c();

    /* renamed from: r */
    public int f546r = 0;
    public int s = 0;
    public boolean A = false;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
            b.this = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (b.this.b() && b.this.f542n.size() > 0 && !((d) b.this.f542n.get(0)).f557a.D) {
                View view = b.this.f548u;
                if (view == null || !view.isShown()) {
                    b.this.dismiss();
                    return;
                }
                Iterator it = b.this.f542n.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).f557a.d();
                }
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.b$b */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class View$OnAttachStateChangeListenerC0007b implements View.OnAttachStateChangeListener {
        public View$OnAttachStateChangeListenerC0007b() {
            b.this = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = b.this.D;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    b.this.D = view.getViewTreeObserver();
                }
                b bVar = b.this;
                bVar.D.removeGlobalOnLayoutListener(bVar.f543o);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class c implements o0 {
        public c() {
            b.this = r1;
        }

        @Override // androidx.appcompat.widget.o0
        public final void a(f fVar, MenuItem menuItem) {
            b.this.f541l.removeCallbacksAndMessages(fVar);
        }

        @Override // androidx.appcompat.widget.o0
        public final void e(f fVar, h hVar) {
            d dVar = null;
            b.this.f541l.removeCallbacksAndMessages(null);
            int size = b.this.f542n.size();
            int i7 = 0;
            while (true) {
                if (i7 >= size) {
                    i7 = -1;
                    break;
                } else if (fVar == ((d) b.this.f542n.get(i7)).f558b) {
                    break;
                } else {
                    i7++;
                }
            }
            if (i7 != -1) {
                int i8 = i7 + 1;
                if (i8 < b.this.f542n.size()) {
                    dVar = (d) b.this.f542n.get(i8);
                }
                b.this.f541l.postAtTime(new c(this, dVar, hVar, fVar), fVar, SystemClock.uptimeMillis() + 200);
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class d {

        /* renamed from: a */
        public final p0 f557a;

        /* renamed from: b */
        public final f f558b;

        /* renamed from: c */
        public final int f559c;

        public d(p0 p0Var, f fVar, int i7) {
            this.f557a = p0Var;
            this.f558b = fVar;
            this.f559c = i7;
        }
    }

    public b(Context context, View view, int i7, int i8, boolean z6) {
        int i9 = 0;
        this.f536g = context;
        this.f547t = view;
        this.f538i = i7;
        this.f539j = i8;
        this.f540k = z6;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        this.f549v = y.e.d(view) != 1 ? 1 : i9;
        Resources resources = context.getResources();
        this.f537h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(2131099671));
        this.f541l = new Handler();
    }

    @Override // androidx.appcompat.view.menu.j
    public final void a(f fVar, boolean z6) {
        int i7;
        int size = this.f542n.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size) {
                i8 = -1;
                break;
            } else if (fVar == ((d) this.f542n.get(i8)).f558b) {
                break;
            } else {
                i8++;
            }
        }
        if (i8 >= 0) {
            int i9 = i8 + 1;
            if (i9 < this.f542n.size()) {
                ((d) this.f542n.get(i9)).f558b.c(false);
            }
            d dVar = (d) this.f542n.remove(i8);
            dVar.f558b.r(this);
            if (this.F) {
                p0.a.b(dVar.f557a.E, null);
                dVar.f557a.E.setAnimationStyle(0);
            }
            dVar.f557a.dismiss();
            int size2 = this.f542n.size();
            if (size2 > 0) {
                i7 = ((d) this.f542n.get(size2 - 1)).f559c;
            } else {
                View view = this.f547t;
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                i7 = y.e.d(view) == 1 ? 0 : 1;
            }
            this.f549v = i7;
            if (size2 == 0) {
                dismiss();
                j.a aVar = this.C;
                if (aVar != null) {
                    aVar.a(fVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.D;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.D.removeGlobalOnLayoutListener(this.f543o);
                    }
                    this.D = null;
                }
                this.f548u.removeOnAttachStateChangeListener(this.f544p);
                this.E.onDismiss();
            } else if (z6) {
                ((d) this.f542n.get(0)).f558b.c(false);
            }
        }
    }

    @Override // j.f
    public final boolean b() {
        return this.f542n.size() > 0 && ((d) this.f542n.get(0)).f557a.b();
    }

    @Override // j.f
    public final void d() {
        if (!b()) {
            Iterator it = this.m.iterator();
            while (it.hasNext()) {
                v((f) it.next());
            }
            this.m.clear();
            View view = this.f547t;
            this.f548u = view;
            if (view != null) {
                boolean z6 = this.D == null;
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.D = viewTreeObserver;
                if (z6) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f543o);
                }
                this.f548u.addOnAttachStateChangeListener(this.f544p);
            }
        }
    }

    @Override // j.f
    public final void dismiss() {
        int size = this.f542n.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f542n.toArray(new d[size]);
            while (true) {
                size--;
                if (size >= 0) {
                    d dVar = dVarArr[size];
                    if (dVar.f557a.b()) {
                        dVar.f557a.dismiss();
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final void f() {
        Iterator it = this.f542n.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((d) it.next()).f557a.f986h.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((e) adapter).notifyDataSetChanged();
        }
    }

    @Override // j.f
    public final i0 g() {
        if (this.f542n.isEmpty()) {
            return null;
        }
        ArrayList arrayList = this.f542n;
        return ((d) arrayList.get(arrayList.size() - 1)).f557a.f986h;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean h(m mVar) {
        Iterator it = this.f542n.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (mVar == dVar.f558b) {
                dVar.f557a.f986h.requestFocus();
                return true;
            }
        }
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        l(mVar);
        j.a aVar = this.C;
        if (aVar != null) {
            aVar.b(mVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void j(j.a aVar) {
        this.C = aVar;
    }

    @Override // j.d
    public final void l(f fVar) {
        fVar.b(this, this.f536g);
        if (b()) {
            v(fVar);
        } else {
            this.m.add(fVar);
        }
    }

    @Override // j.d
    public final void n(View view) {
        if (this.f547t != view) {
            this.f547t = view;
            int i7 = this.f546r;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            this.s = Gravity.getAbsoluteGravity(i7, y.e.d(view));
        }
    }

    @Override // j.d
    public final void o(boolean z6) {
        this.A = z6;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        d dVar;
        int size = this.f542n.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size) {
                dVar = null;
                break;
            }
            dVar = (d) this.f542n.get(i7);
            if (!dVar.f557a.b()) {
                break;
            }
            i7++;
        }
        if (dVar != null) {
            dVar.f558b.c(false);
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
        if (this.f546r != i7) {
            this.f546r = i7;
            View view = this.f547t;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            this.s = Gravity.getAbsoluteGravity(i7, y.e.d(view));
        }
    }

    @Override // j.d
    public final void q(int i7) {
        this.f550w = true;
        this.f552y = i7;
    }

    @Override // j.d
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.E = onDismissListener;
    }

    @Override // j.d
    public final void s(boolean z6) {
        this.B = z6;
    }

    @Override // j.d
    public final void t(int i7) {
        this.f551x = true;
        this.f553z = i7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x012b, code lost:
        if (((r8.getWidth() + r10[0]) + r4) > r11.right) goto L_0x0136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0131, code lost:
        if ((r10[0] - r4) < 0) goto L_0x0133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0133, code lost:
        r8 = 1;
        r11 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0136, code lost:
        r11 = 0;
        r8 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(androidx.appcompat.view.menu.f r17) {
        /*
            Method dump skipped, instructions count: 449
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.b.v(androidx.appcompat.view.menu.f):void");
    }
}
