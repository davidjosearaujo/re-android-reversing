package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.j;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a */
    public final Context f627a;

    /* renamed from: b */
    public final f f628b;

    /* renamed from: c */
    public final boolean f629c;

    /* renamed from: d */
    public final int f630d;
    public final int e;

    /* renamed from: f */
    public View f631f;

    /* renamed from: g */
    public int f632g;

    /* renamed from: h */
    public boolean f633h;

    /* renamed from: i */
    public j.a f634i;

    /* renamed from: j */
    public j.d f635j;

    /* renamed from: k */
    public PopupWindow.OnDismissListener f636k;

    /* renamed from: l */
    public final a f637l;

    /* loaded from: classes.dex */
    public class a implements PopupWindow.OnDismissListener {
        public a() {
            i.this = r1;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            i.this.c();
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static void a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    public i(int i7, int i8, Context context, View view, f fVar, boolean z6) {
        this.f632g = 8388611;
        this.f637l = new a();
        this.f627a = context;
        this.f628b = fVar;
        this.f631f = view;
        this.f629c = z6;
        this.f630d = i7;
        this.e = i8;
    }

    public i(Context context, f fVar, View view, boolean z6) {
        this(2130903074, 0, context, view, fVar, z6);
    }

    public final j.d a() {
        j.d lVar;
        if (this.f635j == null) {
            Display defaultDisplay = ((WindowManager) this.f627a.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            b.a(defaultDisplay, point);
            if (Math.min(point.x, point.y) >= this.f627a.getResources().getDimensionPixelSize(2131099670)) {
                lVar = new androidx.appcompat.view.menu.b(this.f627a, this.f631f, this.f630d, this.e, this.f629c);
            } else {
                lVar = new l(this.f630d, this.e, this.f627a, this.f631f, this.f628b, this.f629c);
            }
            lVar.l(this.f628b);
            lVar.r(this.f637l);
            lVar.n(this.f631f);
            lVar.j(this.f634i);
            lVar.o(this.f633h);
            lVar.p(this.f632g);
            this.f635j = lVar;
        }
        return this.f635j;
    }

    public final boolean b() {
        j.d dVar = this.f635j;
        return dVar != null && dVar.b();
    }

    public void c() {
        this.f635j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f636k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i7, int i8, boolean z6, boolean z7) {
        j.d a7 = a();
        a7.s(z7);
        if (z6) {
            int i9 = this.f632g;
            View view = this.f631f;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            if ((Gravity.getAbsoluteGravity(i9, y.e.d(view)) & 7) == 5) {
                i7 -= this.f631f.getWidth();
            }
            a7.q(i7);
            a7.t(i8);
            int i10 = (int) ((this.f627a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            a7.f4568f = new Rect(i7 - i10, i8 - i10, i7 + i10, i8 + i10);
        }
        a7.d();
    }
}
