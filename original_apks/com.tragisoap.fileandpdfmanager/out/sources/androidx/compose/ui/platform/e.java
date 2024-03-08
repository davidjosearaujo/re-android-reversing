package androidx.compose.ui.platform;

import android.view.accessibility.AccessibilityEvent;
import f5.g;
import i5.d;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import l0.o;
import o0.f;
import o0.j;
import o0.m;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e extends p1.a {
    public static final /* synthetic */ int e = 0;

    /* renamed from: d  reason: collision with root package name */
    public a f1146d;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final j f1147a;

        /* renamed from: b  reason: collision with root package name */
        public final f f1148b;

        /* renamed from: c  reason: collision with root package name */
        public final LinkedHashSet f1149c = new LinkedHashSet();

        public a(j jVar, Map<Integer, z> map) {
            h.f(jVar, "semanticsNode");
            h.f(map, "currentSemanticsNodes");
            this.f1147a = jVar;
            this.f1148b = jVar.f5240d;
            List<j> h7 = jVar.h();
            int size = h7.size();
            for (int i7 = 0; i7 < size; i7++) {
                j jVar2 = h7.get(i7);
                if (map.containsKey(Integer.valueOf(jVar2.f5242g))) {
                    this.f1149c.add(Integer.valueOf(jVar2.f5242g));
                }
            }
        }
    }

    public static p0.a o(f fVar) {
        return (p0.a) a0.e.r(fVar, m.f5255k);
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
        h.d(subSequence, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
        return subSequence;
    }

    public final Object j(d<? super g> dVar) {
        throw null;
    }

    public final void k(long j7, boolean z6) {
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

    public final void p(o oVar) {
        throw null;
    }

    public final int q(int i7) {
        throw null;
    }

    public final void r(j jVar, a aVar) {
        throw null;
    }

    public final void s(j jVar, a aVar) {
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
