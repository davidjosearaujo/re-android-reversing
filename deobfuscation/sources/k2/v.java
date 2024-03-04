package k2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import k2.h;
import k2.o;

/* loaded from: classes.dex */
public abstract class v extends h {
    public static final String[] D = {"android:visibility:visibility", "android:visibility:parent"};
    public int C = 3;

    /* loaded from: classes.dex */
    public static class a extends AnimatorListenerAdapter implements h.d {

        /* renamed from: a */
        public final View f4674a;

        /* renamed from: b */
        public final int f4675b;

        /* renamed from: c */
        public final ViewGroup f4676c;
        public boolean e;

        /* renamed from: f */
        public boolean f4678f = false;

        /* renamed from: d */
        public final boolean f4677d = true;

        public a(View view, int i7) {
            this.f4674a = view;
            this.f4675b = i7;
            this.f4676c = (ViewGroup) view.getParent();
            f(true);
        }

        @Override // k2.h.d
        public final void a() {
        }

        @Override // k2.h.d
        public final void b() {
            f(false);
        }

        @Override // k2.h.d
        public final void c(h hVar) {
            if (!this.f4678f) {
                View view = this.f4674a;
                int i7 = this.f4675b;
                o.a aVar = o.f4669a;
                view.setTransitionVisibility(i7);
                ViewGroup viewGroup = this.f4676c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            f(false);
            hVar.v(this);
        }

        @Override // k2.h.d
        public final void d() {
            f(true);
        }

        @Override // k2.h.d
        public final void e() {
        }

        public final void f(boolean z6) {
            ViewGroup viewGroup;
            if (!this.f4677d || this.e == z6 || (viewGroup = this.f4676c) == null) {
                return;
            }
            this.e = z6;
            viewGroup.suppressLayout(z6);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            this.f4678f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (!this.f4678f) {
                View view = this.f4674a;
                int i7 = this.f4675b;
                o.a aVar = o.f4669a;
                view.setTransitionVisibility(i7);
                ViewGroup viewGroup = this.f4676c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            f(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public final void onAnimationPause(Animator animator) {
            if (this.f4678f) {
                return;
            }
            View view = this.f4674a;
            int i7 = this.f4675b;
            o.a aVar = o.f4669a;
            view.setTransitionVisibility(i7);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public final void onAnimationResume(Animator animator) {
            if (this.f4678f) {
                return;
            }
            View view = this.f4674a;
            o.a aVar = o.f4669a;
            view.setTransitionVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public boolean f4679a;

        /* renamed from: b */
        public boolean f4680b;

        /* renamed from: c */
        public int f4681c;

        /* renamed from: d */
        public int f4682d;
        public ViewGroup e;

        /* renamed from: f */
        public ViewGroup f4683f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:150:0x0075, code lost:
        if (r8 == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x007f, code lost:
        if (r0.e == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x008f, code lost:
        if (r0.f4681c == 0) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static k2.v.b I(k2.n r7, k2.n r8) {
        /*
            k2.v$b r0 = new k2.v$b
            r0.<init>()
            r1 = 0
            r0.f4679a = r1
            r0.f4680b = r1
            java.lang.String r2 = "android:visibility:parent"
            r3 = 0
            r4 = -1
            java.lang.String r5 = "android:visibility:visibility"
            if (r7 == 0) goto L33
            java.util.HashMap r6 = r7.f4666a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L33
            java.util.HashMap r6 = r7.f4666a
            java.lang.Object r6 = r6.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r0.f4681c = r6
            java.util.HashMap r6 = r7.f4666a
            java.lang.Object r6 = r6.get(r2)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.e = r6
            goto L37
        L33:
            r0.f4681c = r4
            r0.e = r3
        L37:
            if (r8 == 0) goto L5a
            java.util.HashMap r6 = r8.f4666a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L5a
            java.util.HashMap r3 = r8.f4666a
            java.lang.Object r3 = r3.get(r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0.f4682d = r3
            java.util.HashMap r3 = r8.f4666a
            java.lang.Object r2 = r3.get(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f4683f = r2
            goto L5e
        L5a:
            r0.f4682d = r4
            r0.f4683f = r3
        L5e:
            r2 = 1
            if (r7 == 0) goto L82
            if (r8 == 0) goto L82
            int r7 = r0.f4681c
            int r8 = r0.f4682d
            if (r7 != r8) goto L70
            android.view.ViewGroup r3 = r0.e
            android.view.ViewGroup r4 = r0.f4683f
            if (r3 != r4) goto L70
            return r0
        L70:
            if (r7 == r8) goto L78
            if (r7 != 0) goto L75
            goto L91
        L75:
            if (r8 != 0) goto L95
            goto L88
        L78:
            android.view.ViewGroup r7 = r0.f4683f
            if (r7 != 0) goto L7d
            goto L91
        L7d:
            android.view.ViewGroup r7 = r0.e
            if (r7 != 0) goto L95
            goto L88
        L82:
            if (r7 != 0) goto L8b
            int r7 = r0.f4682d
            if (r7 != 0) goto L8b
        L88:
            r0.f4680b = r2
            goto L93
        L8b:
            if (r8 != 0) goto L95
            int r7 = r0.f4681c
            if (r7 != 0) goto L95
        L91:
            r0.f4680b = r1
        L93:
            r0.f4679a = r2
        L95:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.v.I(k2.n, k2.n):k2.v$b");
    }

    public final void H(n nVar) {
        nVar.f4666a.put("android:visibility:visibility", Integer.valueOf(nVar.f4667b.getVisibility()));
        nVar.f4666a.put("android:visibility:parent", nVar.f4667b.getParent());
        int[] iArr = new int[2];
        nVar.f4667b.getLocationOnScreen(iArr);
        nVar.f4666a.put("android:visibility:screenLocation", iArr);
    }

    @Override // k2.h
    public final void d(n nVar) {
        H(nVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:379:0x0043, code lost:
        if (I(n(r1, false), q(r1, false)).f4679a != false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:420:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x01c3  */
    @Override // k2.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.animation.Animator k(android.view.ViewGroup r21, k2.n r22, k2.n r23) {
        /*
            Method dump skipped, instructions count: 692
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.v.k(android.view.ViewGroup, k2.n, k2.n):android.animation.Animator");
    }

    @Override // k2.h
    public final String[] p() {
        return D;
    }

    @Override // k2.h
    public final boolean r(n nVar, n nVar2) {
        if (nVar == null && nVar2 == null) {
            return false;
        }
        if (nVar == null || nVar2 == null || nVar2.f4666a.containsKey("android:visibility:visibility") == nVar.f4666a.containsKey("android:visibility:visibility")) {
            b I = I(nVar, nVar2);
            if (I.f4679a) {
                return I.f4681c == 0 || I.f4682d == 0;
            }
            return false;
        }
        return false;
    }
}
