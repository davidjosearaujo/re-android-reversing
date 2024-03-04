package k2;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a */
    public static k2.a f4657a = new k2.a();

    /* renamed from: b */
    public static ThreadLocal<WeakReference<o.b<ViewGroup, ArrayList<h>>>> f4658b = new ThreadLocal<>();

    /* renamed from: c */
    public static ArrayList<ViewGroup> f4659c = new ArrayList<>();

    /* loaded from: classes.dex */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: f */
        public h f4660f;

        /* renamed from: g */
        public ViewGroup f4661g;

        /* renamed from: k2.l$a$a */
        /* loaded from: classes.dex */
        public class C0073a extends k {

            /* renamed from: a */
            public final /* synthetic */ o.b f4662a;

            public C0073a(o.b bVar) {
                a.this = r1;
                this.f4662a = bVar;
            }

            @Override // k2.h.d
            public final void c(h hVar) {
                ((ArrayList) this.f4662a.getOrDefault(a.this.f4661g, null)).remove(hVar);
                hVar.v(this);
            }
        }

        public a(ViewGroup viewGroup, h hVar) {
            this.f4660f = hVar;
            this.f4661g = viewGroup;
        }

        /* JADX WARN: Removed duplicated region for block: B:599:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:606:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:683:0x0200  */
        /* JADX WARN: Removed duplicated region for block: B:690:0x0221  */
        /* JADX WARN: Removed duplicated region for block: B:696:0x024d  */
        /* JADX WARN: Removed duplicated region for block: B:733:0x01fb A[EDGE_INSN: B:733:0x01fb->B:680:0x01fb ?: BREAK  , SYNTHETIC] */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean onPreDraw() {
            /*
                Method dump skipped, instructions count: 723
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: k2.l.a.onPreDraw():boolean");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            this.f4661g.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f4661g.removeOnAttachStateChangeListener(this);
            l.f4659c.remove(this.f4661g);
            ArrayList<h> orDefault = l.b().getOrDefault(this.f4661g, null);
            if (orDefault != null && orDefault.size() > 0) {
                Iterator<h> it = orDefault.iterator();
                while (it.hasNext()) {
                    it.next().x(this.f4661g);
                }
            }
            this.f4660f.i(true);
        }
    }

    public static void a(ViewGroup viewGroup, h hVar) {
        if (f4659c.contains(viewGroup)) {
            return;
        }
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        if (y.g.c(viewGroup)) {
            f4659c.add(viewGroup);
            if (hVar == null) {
                hVar = f4657a;
            }
            h clone = hVar.clone();
            ArrayList<h> orDefault = b().getOrDefault(viewGroup, null);
            if (orDefault != null && orDefault.size() > 0) {
                Iterator<h> it = orDefault.iterator();
                while (it.hasNext()) {
                    it.next().u(viewGroup);
                }
            }
            if (clone != null) {
                clone.h(viewGroup, true);
            }
            if (((g) viewGroup.getTag(2131296887)) != null) {
                throw null;
            }
            viewGroup.setTag(2131296887, null);
            if (clone != null) {
                a aVar = new a(viewGroup, clone);
                viewGroup.addOnAttachStateChangeListener(aVar);
                viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
            }
        }
    }

    public static o.b<ViewGroup, ArrayList<h>> b() {
        o.b<ViewGroup, ArrayList<h>> bVar;
        WeakReference<o.b<ViewGroup, ArrayList<h>>> weakReference = f4658b.get();
        if (weakReference == null || (bVar = weakReference.get()) == null) {
            o.b<ViewGroup, ArrayList<h>> bVar2 = new o.b<>();
            f4658b.set(new WeakReference<>(bVar2));
            return bVar2;
        }
        return bVar;
    }
}
