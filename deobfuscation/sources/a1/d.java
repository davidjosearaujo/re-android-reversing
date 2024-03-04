package a1;

import a1.e;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import b1.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import p1.n;

/* loaded from: classes.dex */
public final class d extends ConstraintLayout implements n {
    public static final /* synthetic */ int P = 0;
    public float A;
    public long B;
    public float C;
    public c D;
    public a1.b E;
    public boolean F;
    public ArrayList<a1.c> G;
    public ArrayList<a1.c> H;
    public CopyOnWriteArrayList<c> I;
    public int J;
    public float K;
    public boolean L;
    public b M;
    public boolean N;
    public EnumC0000d O;

    /* renamed from: v */
    public float f64v;

    /* renamed from: w */
    public int f65w;

    /* renamed from: x */
    public int f66x;

    /* renamed from: y */
    public int f67y;

    /* renamed from: z */
    public float f68z;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
            d.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.this.M.a();
        }
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a */
        public float f70a = Float.NaN;

        /* renamed from: b */
        public float f71b = Float.NaN;

        /* renamed from: c */
        public int f72c = -1;

        /* renamed from: d */
        public int f73d = -1;

        public b() {
            d.this = r1;
        }

        public final void a() {
            ConstraintLayout constraintLayout;
            int a7;
            EnumC0000d enumC0000d = EnumC0000d.SETUP;
            int i7 = this.f72c;
            if (i7 != -1 || this.f73d != -1) {
                if (i7 == -1) {
                    d.this.r(this.f73d);
                } else {
                    int i8 = this.f73d;
                    if (i8 == -1) {
                        d dVar = d.this;
                        dVar.setState(enumC0000d);
                        dVar.f66x = i7;
                        dVar.f65w = -1;
                        dVar.f67y = -1;
                        b1.b bVar = dVar.f1259p;
                        if (bVar != null) {
                            float f7 = -1;
                            int i9 = bVar.f2359b;
                            if (i9 == i7) {
                                b.a valueAt = i7 == -1 ? bVar.f2361d.valueAt(0) : bVar.f2361d.get(i9);
                                int i10 = bVar.f2360c;
                                if ((i10 == -1 || !valueAt.f2363b.get(i10).a(f7, f7)) && bVar.f2360c != (a7 = valueAt.a(f7, f7))) {
                                    androidx.constraintlayout.widget.c cVar = a7 == -1 ? null : valueAt.f2363b.get(a7).f2370f;
                                    if (a7 != -1) {
                                        int i11 = valueAt.f2363b.get(a7).e;
                                    }
                                    if (cVar != null) {
                                        bVar.f2360c = a7;
                                        constraintLayout = bVar.f2358a;
                                        cVar.a(constraintLayout);
                                        constraintLayout.setConstraintSet(null);
                                        constraintLayout.requestLayout();
                                    }
                                }
                            } else {
                                bVar.f2359b = i7;
                                b.a aVar = bVar.f2361d.get(i7);
                                int a8 = aVar.a(f7, f7);
                                androidx.constraintlayout.widget.c cVar2 = a8 == -1 ? aVar.f2365d : aVar.f2363b.get(a8).f2370f;
                                if (a8 != -1) {
                                    int i12 = aVar.f2363b.get(a8).e;
                                }
                                if (cVar2 == null) {
                                    Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i7 + ", dim =" + f7 + ", " + f7);
                                } else {
                                    bVar.f2360c = a8;
                                    constraintLayout = bVar.f2358a;
                                    cVar2.a(constraintLayout);
                                    constraintLayout.setConstraintSet(null);
                                    constraintLayout.requestLayout();
                                }
                            }
                        }
                    } else {
                        d.this.q(i7, i8);
                    }
                }
                d.this.setState(enumC0000d);
            }
            if (Float.isNaN(this.f71b)) {
                if (Float.isNaN(this.f70a)) {
                    return;
                }
                d.this.setProgress(this.f70a);
                return;
            }
            d.this.p(this.f70a, this.f71b);
            this.f70a = Float.NaN;
            this.f71b = Float.NaN;
            this.f72c = -1;
            this.f73d = -1;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a();

        void b();
    }

    /* renamed from: a1.d$d */
    /* loaded from: classes.dex */
    public enum EnumC0000d {
        /* JADX INFO: Fake field, exist only in values array */
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    @Override // p1.m
    public final void a(View view, View view2, int i7, int i8) {
        getNanoTime();
    }

    /* JADX WARN: Code restructure failed: missing block: B:375:0x0100, code lost:
        if (r1 != r2) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x010b, code lost:
        if (r1 != r2) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x010e, code lost:
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x010f, code lost:
        r17.f66x = r2;
        r8 = r7;
     */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void dispatchDraw(android.graphics.Canvas r18) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.d.dispatchDraw(android.graphics.Canvas):void");
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public final void f(int i7) {
        this.f1259p = null;
    }

    public int[] getConstraintSetIds() {
        return null;
    }

    public int getCurrentState() {
        return this.f66x;
    }

    public ArrayList<e.a> getDefinedTransitions() {
        return null;
    }

    public a1.b getDesignTool() {
        if (this.E == null) {
            this.E = new a1.b();
        }
        return this.E;
    }

    public int getEndState() {
        return this.f67y;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.A;
    }

    public e getScene() {
        return null;
    }

    public int getStartState() {
        return this.f65w;
    }

    public float getTargetPosition() {
        return this.C;
    }

    public Bundle getTransitionState() {
        if (this.M == null) {
            this.M = new b();
        }
        b bVar = this.M;
        d dVar = d.this;
        bVar.f73d = dVar.f67y;
        bVar.f72c = dVar.f65w;
        bVar.f71b = dVar.getVelocity();
        bVar.f70a = d.this.getProgress();
        b bVar2 = this.M;
        bVar2.getClass();
        Bundle bundle = new Bundle();
        bundle.putFloat("motion.progress", bVar2.f70a);
        bundle.putFloat("motion.velocity", bVar2.f71b);
        bundle.putInt("motion.StartState", bVar2.f72c);
        bundle.putInt("motion.EndState", bVar2.f73d);
        return bundle;
    }

    public long getTransitionTimeMs() {
        return 0.0f;
    }

    public float getVelocity() {
        return this.f64v;
    }

    @Override // p1.m
    public final void i(View view, int i7) {
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    @Override // p1.m
    public final void j(View view, int i7, int i8, int[] iArr, int i9) {
    }

    public final void k() {
        CopyOnWriteArrayList<c> copyOnWriteArrayList;
        if ((this.D == null && ((copyOnWriteArrayList = this.I) == null || copyOnWriteArrayList.isEmpty())) || this.K == this.f68z) {
            return;
        }
        if (this.J != -1) {
            c cVar = this.D;
            if (cVar != null) {
                cVar.b();
            }
            CopyOnWriteArrayList<c> copyOnWriteArrayList2 = this.I;
            if (copyOnWriteArrayList2 != null) {
                Iterator<c> it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    it.next().b();
                }
            }
        }
        this.J = -1;
        this.K = this.f68z;
        c cVar2 = this.D;
        if (cVar2 != null) {
            cVar2.a();
        }
        CopyOnWriteArrayList<c> copyOnWriteArrayList3 = this.I;
        if (copyOnWriteArrayList3 != null) {
            Iterator<c> it2 = copyOnWriteArrayList3.iterator();
            while (it2.hasNext()) {
                it2.next().a();
            }
        }
    }

    public final void l() {
        CopyOnWriteArrayList<c> copyOnWriteArrayList;
        CopyOnWriteArrayList<c> copyOnWriteArrayList2;
        if (!(this.D == null && ((copyOnWriteArrayList2 = this.I) == null || copyOnWriteArrayList2.isEmpty())) && this.J == -1) {
            this.J = this.f66x;
            throw null;
        } else if (this.D != null || ((copyOnWriteArrayList = this.I) != null && !copyOnWriteArrayList.isEmpty())) {
            throw null;
        }
    }

    @Override // p1.n
    public final void m(View view, int i7, int i8, int i9, int i10, int i11, int[] iArr) {
        if (i7 == 0 && i8 == 0) {
            return;
        }
        iArr[0] = iArr[0] + i9;
        iArr[1] = iArr[1] + i10;
    }

    @Override // p1.m
    public final void n(View view, int i7, int i8, int i9, int i10, int i11) {
    }

    @Override // p1.m
    public final boolean o(View view, View view2, int i7, int i8) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            display.getRotation();
        }
        b bVar = this.M;
        if (bVar != null) {
            if (this.N) {
                post(new a());
            } else {
                bVar.a();
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        this.L = true;
        try {
            super.onLayout(z6, i7, i8, i9, i10);
        } finally {
            this.L = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f7, float f8, boolean z6) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f7, float f8) {
        return false;
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i7) {
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof a1.c) {
            a1.c cVar = (a1.c) view;
            if (this.I == null) {
                this.I = new CopyOnWriteArrayList<>();
            }
            this.I.add(cVar);
            if (cVar.f60n) {
                if (this.G == null) {
                    this.G = new ArrayList<>();
                }
                this.G.add(cVar);
            }
            if (cVar.f61o) {
                if (this.H == null) {
                    this.H = new ArrayList<>();
                }
                this.H.add(cVar);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<a1.c> arrayList = this.G;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<a1.c> arrayList2 = this.H;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public final void p(float f7, float f8) {
        if (super.isAttachedToWindow()) {
            setProgress(f7);
            setState(EnumC0000d.MOVING);
            this.f64v = f8;
            return;
        }
        if (this.M == null) {
            this.M = new b();
        }
        b bVar = this.M;
        bVar.f70a = f7;
        bVar.f71b = f8;
    }

    public final void q(int i7, int i8) {
        if (super.isAttachedToWindow()) {
            return;
        }
        if (this.M == null) {
            this.M = new b();
        }
        b bVar = this.M;
        bVar.f72c = i7;
        bVar.f73d = i8;
    }

    public final void r(int i7) {
        if (!super.isAttachedToWindow()) {
            if (this.M == null) {
                this.M = new b();
            }
            this.M.f73d = i7;
            return;
        }
        int i8 = this.f66x;
        if (i8 == i7 || this.f65w == i7 || this.f67y == i7) {
            return;
        }
        this.f67y = i7;
        if (i8 != -1) {
            q(i8, i7);
            this.A = 0.0f;
            return;
        }
        this.C = 1.0f;
        this.f68z = 0.0f;
        this.A = 0.0f;
        this.B = getNanoTime();
        getNanoTime();
        throw null;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public final void requestLayout() {
        int i7 = this.f66x;
        super.requestLayout();
    }

    public void setDebugMode(int i7) {
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z6) {
        this.N = z6;
    }

    public void setInteractionEnabled(boolean z6) {
    }

    public void setInterpolatedProgress(float f7) {
        setProgress(f7);
    }

    public void setOnHide(float f7) {
        ArrayList<a1.c> arrayList = this.H;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.H.get(i7).setProgress(f7);
            }
        }
    }

    public void setOnShow(float f7) {
        ArrayList<a1.c> arrayList = this.G;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.G.get(i7).setProgress(f7);
            }
        }
    }

    public void setProgress(float f7) {
        EnumC0000d enumC0000d = EnumC0000d.FINISHED;
        EnumC0000d enumC0000d2 = EnumC0000d.MOVING;
        int i7 = (f7 > 0.0f ? 1 : (f7 == 0.0f ? 0 : -1));
        if (i7 < 0 || f7 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!super.isAttachedToWindow()) {
            if (this.M == null) {
                this.M = new b();
            }
            this.M.f70a = f7;
            return;
        }
        if (i7 <= 0) {
            if (this.A == 1.0f && this.f66x == this.f67y) {
                setState(enumC0000d2);
            }
            this.f66x = this.f65w;
            if (this.A != 0.0f) {
                return;
            }
        } else if (f7 < 1.0f) {
            this.f66x = -1;
            setState(enumC0000d2);
            return;
        } else {
            if (this.A == 0.0f && this.f66x == this.f65w) {
                setState(enumC0000d2);
            }
            this.f66x = this.f67y;
            if (this.A != 1.0f) {
                return;
            }
        }
        setState(enumC0000d);
    }

    public void setScene(e eVar) {
        e();
        throw null;
    }

    public void setStartState(int i7) {
        if (super.isAttachedToWindow()) {
            this.f66x = i7;
            return;
        }
        if (this.M == null) {
            this.M = new b();
        }
        b bVar = this.M;
        bVar.f72c = i7;
        bVar.f73d = i7;
    }

    public void setState(EnumC0000d enumC0000d) {
        EnumC0000d enumC0000d2 = EnumC0000d.FINISHED;
        if (enumC0000d == enumC0000d2 && this.f66x == -1) {
            return;
        }
        EnumC0000d enumC0000d3 = this.O;
        this.O = enumC0000d;
        EnumC0000d enumC0000d4 = EnumC0000d.MOVING;
        if (enumC0000d3 == enumC0000d4 && enumC0000d == enumC0000d4) {
            k();
        }
        int ordinal = enumC0000d3.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            if (enumC0000d == enumC0000d4) {
                k();
            }
            if (enumC0000d != enumC0000d2) {
                return;
            }
        } else if (ordinal != 2 || enumC0000d != enumC0000d2) {
            return;
        }
        l();
    }

    public void setTransition(int i7) {
    }

    public void setTransition(e.a aVar) {
        throw null;
    }

    public void setTransitionDuration(int i7) {
        Log.e("MotionLayout", "MotionScene not defined");
    }

    public void setTransitionListener(c cVar) {
        this.D = cVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.M == null) {
            this.M = new b();
        }
        b bVar = this.M;
        bVar.getClass();
        bVar.f70a = bundle.getFloat("motion.progress");
        bVar.f71b = bundle.getFloat("motion.velocity");
        bVar.f72c = bundle.getInt("motion.StartState");
        bVar.f73d = bundle.getInt("motion.EndState");
        if (super.isAttachedToWindow()) {
            this.M.a();
        }
    }

    @Override // android.view.View
    public final String toString() {
        Context context = getContext();
        return a1.a.a(context, this.f65w) + "->" + a1.a.a(context, this.f67y) + " (pos:" + this.A + " Dpos/Dt:" + this.f64v;
    }
}
