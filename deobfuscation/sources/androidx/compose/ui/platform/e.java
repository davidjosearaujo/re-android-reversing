package androidx.compose.ui.platform;

import android.view.accessibility.AccessibilityEvent;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class e extends p1.a {
    public static final /* synthetic */ int e = 0;

    /* renamed from: d */
    public a f1146d;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        public final o0.j f1147a;

        /* renamed from: b */
        public final o0.f f1148b;

        /* renamed from: c */
        public final LinkedHashSet f1149c;

        public a(o0.j jVar, Map<Integer, z> map) {
            r5.h.f(jVar, "semanticsNode");
            r5.h.f(map, "currentSemanticsNodes");
            this.f1147a = jVar;
            this.f1148b = jVar.f5240d;
            this.f1149c = new LinkedHashSet();
            List<o0.j> h7 = jVar.h();
            int size = h7.size();
            for (int i7 = 0; i7 < size; i7++) {
                o0.j jVar2 = h7.get(i7);
                if (map.containsKey(Integer.valueOf(jVar2.f5242g))) {
                    this.f1149c.add(Integer.valueOf(jVar2.f5242g));
                }
            }
        }
    }

    public static p0.a o(o0.f fVar) {
        return (p0.a) a0.e.r(fVar, o0.m.f5255k);
    }

    public static /* synthetic */ void v(e eVar, int i7, int i8, Integer num, int i9) {
        if ((i9 & 4) != 0) {
            num = null;
        }
        eVar.u(i7, i8, num, null);
    }

    public static CharSequence y(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return charSequence;
        }
        int i7 = 100000;
        if (charSequence.length() <= 100000) {
            return charSequence;
        }
        if (Character.isHighSurrogate(charSequence.charAt(99999)) && Character.isLowSurrogate(charSequence.charAt(100000))) {
            i7 = 99999;
        }
        CharSequence subSequence = charSequence.subSequence(0, i7);
        r5.h.d(subSequence, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
        return subSequence;
    }

    public final Object j(i5.d<? super f5.g> dVar) {
        throw null;
    }

    public final void k(long j5, boolean z6) {
        throw null;
    }

    public final AccessibilityEvent l(int i7, int i8) {
        throw null;
    }

    public final AccessibilityEvent m(int i7, Integer num, Integer num2, Integer num3, CharSequence charSequence) {
        throw null;
    }

    public final Map<Integer, z> n() {
        throw null;
    }

    public final void p(l0.o oVar) {
        throw null;
    }

    public final int q(int i7) {
        throw null;
    }

    public final void r(o0.j jVar, a aVar) {
        throw null;
    }

    public final void s(o0.j jVar, a aVar) {
        throw null;
    }

    public final boolean t(AccessibilityEvent accessibilityEvent) {
        throw null;
    }

    public final boolean u(int i7, int i8, Integer num, List<String> list) {
        throw null;
    }

    public final void w(int i7, int i8, String str) {
        throw null;
    }

    public final void x(int i7) {
        throw null;
    }

    public final void z(int i7) {
        throw null;
    }
}
