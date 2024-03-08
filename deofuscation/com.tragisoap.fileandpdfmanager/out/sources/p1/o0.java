package p1;

import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import r3.g;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class o0 {

    /* renamed from: a */
    public b f5502a;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class a {

        /* renamed from: a */
        public final int f5503a = 0;

        public abstract p0 a(p0 p0Var, List<o0> list);
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b extends c {

        /* renamed from: a */
        public final WindowInsetsAnimation f5504a;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static class a extends WindowInsetsAnimation.Callback {

            /* renamed from: a */
            public final a f5505a;

            /* renamed from: b */
            public List<o0> f5506b;

            /* renamed from: c */
            public ArrayList<o0> f5507c;

            /* renamed from: d */
            public final HashMap<WindowInsetsAnimation, o0> f5508d = new HashMap<>();

            public a(g gVar) {
                super(gVar.f5503a);
                this.f5505a = gVar;
            }

            public final o0 a(WindowInsetsAnimation windowInsetsAnimation) {
                o0 o0Var = this.f5508d.get(windowInsetsAnimation);
                if (o0Var != null) {
                    return o0Var;
                }
                o0 o0Var2 = new o0(0, null, 0);
                o0Var2.f5502a = new b(windowInsetsAnimation);
                this.f5508d.put(windowInsetsAnimation, o0Var2);
                return o0Var2;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                a aVar = this.f5505a;
                a(windowInsetsAnimation);
                ((g) aVar).f5904b.setTranslationY(0.0f);
                this.f5508d.remove(windowInsetsAnimation);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                a aVar = this.f5505a;
                a(windowInsetsAnimation);
                g gVar = (g) aVar;
                gVar.f5904b.getLocationOnScreen(gVar.e);
                gVar.f5905c = gVar.e[1];
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final WindowInsets onProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list) {
                ArrayList<o0> arrayList = this.f5507c;
                if (arrayList == null) {
                    ArrayList<o0> arrayList2 = new ArrayList<>(list.size());
                    this.f5507c = arrayList2;
                    this.f5506b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                int size = list.size();
                while (true) {
                    size--;
                    if (size >= 0) {
                        WindowInsetsAnimation windowInsetsAnimation = list.get(size);
                        o0 a7 = a(windowInsetsAnimation);
                        a7.f5502a.c(windowInsetsAnimation.getFraction());
                        this.f5507c.add(a7);
                    } else {
                        a aVar = this.f5505a;
                        p0 h7 = p0.h(null, windowInsets);
                        aVar.a(h7, this.f5506b);
                        return h7.g();
                    }
                }
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                a aVar = this.f5505a;
                a(windowInsetsAnimation);
                i1.b c7 = i1.b.c(bounds.getLowerBound());
                i1.b c8 = i1.b.c(bounds.getUpperBound());
                g gVar = (g) aVar;
                gVar.f5904b.getLocationOnScreen(gVar.e);
                int i7 = gVar.f5905c - gVar.e[1];
                gVar.f5906d = i7;
                gVar.f5904b.setTranslationY((float) i7);
                return new WindowInsetsAnimation.Bounds(c7.d(), c8.d());
            }
        }

        public b(WindowInsetsAnimation windowInsetsAnimation) {
            this.f5504a = windowInsetsAnimation;
        }

        public final float a() {
            return this.f5504a.getInterpolatedFraction();
        }

        public final int b() {
            return this.f5504a.getTypeMask();
        }

        public final void c(float f7) {
            this.f5504a.setFraction(f7);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c {
    }

    public o0(int i7, Interpolator interpolator, long j7) {
        this.f5502a = new b(new WindowInsetsAnimation(i7, interpolator, j7));
    }
}
