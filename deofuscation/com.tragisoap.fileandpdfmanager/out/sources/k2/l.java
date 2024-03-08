package k2;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import o.b;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static a f4657a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static ThreadLocal<WeakReference<b<ViewGroup, ArrayList<h>>>> f4658b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList<ViewGroup> f4659c = new ArrayList<>();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: f  reason: collision with root package name */
        public h f4660f;

        /* renamed from: g  reason: collision with root package name */
        public ViewGroup f4661g;

        /* renamed from: k2.l$a$a  reason: collision with other inner class name */
        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class C0073a extends k {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f4662a;

            public C0073a(b bVar) {
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

        /* JADX WARN: Removed duplicated region for block: B:104:0x0221  */
        /* JADX WARN: Removed duplicated region for block: B:110:0x024d  */
        /* JADX WARN: Removed duplicated region for block: B:146:0x01fb A[EDGE_INSN: B:146:0x01fb->B:94:0x01fb ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x0200  */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean onPreDraw() {
            /*
                Method dump skipped, instructions count: 723
                To view this dump add '--comments-level debug' option
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
        if (!f4659c.contains(viewGroup)) {
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            if (y.g.c(viewGroup)) {
                f4659c.add(viewGroup);
                if (hVar == null) {
                    hVar = f4657a;
                }
                h j7 = hVar.clone();
                ArrayList<h> orDefault = b().getOrDefault(viewGroup, null);
                if (orDefault != null && orDefault.size() > 0) {
                    Iterator<h> it = orDefault.iterator();
                    while (it.hasNext()) {
                        it.next().u(viewGroup);
                    }
                }
                if (j7 != null) {
                    j7.h(viewGroup, true);
                }
                if (((g) viewGroup.getTag(2131296887)) == null) {
                    viewGroup.setTag(2131296887, null);
                    if (j7 != null) {
                        a aVar = new a(viewGroup, j7);
                        viewGroup.addOnAttachStateChangeListener(aVar);
                        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
                        return;
                    }
                    return;
                }
                throw null;
            }
        }
    }

    public static b<ViewGroup, ArrayList<h>> b() {
        b<ViewGroup, ArrayList<h>> bVar;
        WeakReference<b<ViewGroup, ArrayList<h>>> weakReference = f4658b.get();
        if (weakReference != null && (bVar = weakReference.get()) != null) {
            return bVar;
        }
        b<ViewGroup, ArrayList<h>> bVar2 = new b<>();
        f4658b.set(new WeakReference<>(bVar2));
        return bVar2;
    }
}
