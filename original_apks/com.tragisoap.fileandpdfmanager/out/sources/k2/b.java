package k2;

import android.animation.AnimatorListenerAdapter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.WeakHashMap;
import k2.o;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b extends h {
    public static final String[] C = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final C0072b D = new C0072b(PointF.class);
    public static final c E = new c(PointF.class);
    public static final d F = new d(PointF.class);
    public static final e G = new e(PointF.class);
    public static final f H = new f(PointF.class);

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends Property<Drawable, PointF> {

        /* renamed from: a  reason: collision with root package name */
        public Rect f4611a = new Rect();

        public a(Class cls) {
            super(cls, "boundsOrigin");
        }

        @Override // android.util.Property
        public final PointF get(Drawable drawable) {
            drawable.copyBounds(this.f4611a);
            Rect rect = this.f4611a;
            return new PointF((float) rect.left, (float) rect.top);
        }

        @Override // android.util.Property
        public final void set(Drawable drawable, PointF pointF) {
            Drawable drawable2 = drawable;
            PointF pointF2 = pointF;
            drawable2.copyBounds(this.f4611a);
            this.f4611a.offsetTo(Math.round(pointF2.x), Math.round(pointF2.y));
            drawable2.setBounds(this.f4611a);
        }
    }

    /* renamed from: k2.b$b  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0072b extends Property<i, PointF> {
        public C0072b(Class cls) {
            super(cls, "topLeft");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        public final void set(i iVar, PointF pointF) {
            i iVar2 = iVar;
            PointF pointF2 = pointF;
            iVar2.getClass();
            iVar2.f4614a = Math.round(pointF2.x);
            int round = Math.round(pointF2.y);
            iVar2.f4615b = round;
            int i7 = iVar2.f4618f + 1;
            iVar2.f4618f = i7;
            if (i7 == iVar2.f4619g) {
                View view = iVar2.e;
                int i8 = iVar2.f4614a;
                int i9 = iVar2.f4616c;
                int i10 = iVar2.f4617d;
                o.a aVar = o.f4669a;
                view.setLeftTopRightBottom(i8, round, i9, i10);
                iVar2.f4618f = 0;
                iVar2.f4619g = 0;
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c extends Property<i, PointF> {
        public c(Class cls) {
            super(cls, "bottomRight");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        public final void set(i iVar, PointF pointF) {
            i iVar2 = iVar;
            PointF pointF2 = pointF;
            iVar2.getClass();
            iVar2.f4616c = Math.round(pointF2.x);
            int round = Math.round(pointF2.y);
            iVar2.f4617d = round;
            int i7 = iVar2.f4619g + 1;
            iVar2.f4619g = i7;
            if (iVar2.f4618f == i7) {
                View view = iVar2.e;
                int i8 = iVar2.f4614a;
                int i9 = iVar2.f4615b;
                int i10 = iVar2.f4616c;
                o.a aVar = o.f4669a;
                view.setLeftTopRightBottom(i8, i9, i10, round);
                iVar2.f4618f = 0;
                iVar2.f4619g = 0;
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class d extends Property<View, PointF> {
        public d(Class cls) {
            super(cls, "bottomRight");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public final void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            int left = view2.getLeft();
            int top = view2.getTop();
            int round = Math.round(pointF2.x);
            int round2 = Math.round(pointF2.y);
            o.a aVar = o.f4669a;
            view2.setLeftTopRightBottom(left, top, round, round2);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class e extends Property<View, PointF> {
        public e(Class cls) {
            super(cls, "topLeft");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public final void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            int round = Math.round(pointF2.x);
            int round2 = Math.round(pointF2.y);
            int right = view2.getRight();
            int bottom = view2.getBottom();
            o.a aVar = o.f4669a;
            view2.setLeftTopRightBottom(round, round2, right, bottom);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class f extends Property<View, PointF> {
        public f(Class cls) {
            super(cls, "position");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public final void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            int round = Math.round(pointF2.x);
            int round2 = Math.round(pointF2.y);
            o.a aVar = o.f4669a;
            view2.setLeftTopRightBottom(round, round2, view2.getWidth() + round, view2.getHeight() + round2);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class g extends AnimatorListenerAdapter {
        private i mViewBounds;

        public g(i iVar) {
            this.mViewBounds = iVar;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class h extends k {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4612a = false;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f4613b;

        public h(ViewGroup viewGroup) {
            this.f4613b = viewGroup;
        }

        @Override // k2.k, k2.h.d
        public final void b() {
            this.f4613b.suppressLayout(false);
        }

        @Override // k2.h.d
        public final void c(h hVar) {
            if (!this.f4612a) {
                this.f4613b.suppressLayout(false);
            }
            hVar.v(this);
        }

        @Override // k2.k, k2.h.d
        public final void d() {
            this.f4613b.suppressLayout(true);
        }

        @Override // k2.k, k2.h.d
        public final void e() {
            this.f4613b.suppressLayout(false);
            this.f4612a = true;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public int f4614a;

        /* renamed from: b  reason: collision with root package name */
        public int f4615b;

        /* renamed from: c  reason: collision with root package name */
        public int f4616c;

        /* renamed from: d  reason: collision with root package name */
        public int f4617d;
        public View e;

        /* renamed from: f  reason: collision with root package name */
        public int f4618f;

        /* renamed from: g  reason: collision with root package name */
        public int f4619g;

        public i(View view) {
            this.e = view;
        }
    }

    static {
        new a(PointF.class);
    }

    public final void H(n nVar) {
        View view = nVar.f4667b;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        if (y.g.c(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            nVar.f4666a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            nVar.f4666a.put("android:changeBounds:parent", nVar.f4667b.getParent());
        }
    }

    @Override // k2.h
    public final void d(n nVar) {
        H(nVar);
    }

    @Override // k2.h
    public final void g(n nVar) {
        H(nVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0118  */
    @Override // k2.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator k(android.view.ViewGroup r19, k2.n r20, k2.n r21) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.b.k(android.view.ViewGroup, k2.n, k2.n):android.animation.Animator");
    }

    @Override // k2.h
    public final String[] p() {
        return C;
    }
}
