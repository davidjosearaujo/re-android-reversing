package o3;

import a0.e;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;

/* loaded from: classes.dex */
public abstract class a<V extends View> extends c<V> {

    /* renamed from: h */
    public RunnableC0087a f5315h;

    /* renamed from: i */
    public OverScroller f5316i;

    /* renamed from: j */
    public boolean f5317j;

    /* renamed from: k */
    public int f5318k;

    /* renamed from: l */
    public int f5319l;
    public int m;

    /* renamed from: n */
    public VelocityTracker f5320n;

    /* renamed from: o3.a$a */
    /* loaded from: classes.dex */
    public class RunnableC0087a implements Runnable {

        /* renamed from: f */
        public final CoordinatorLayout f5321f;

        /* renamed from: g */
        public final V f5322g;

        public RunnableC0087a(CoordinatorLayout coordinatorLayout, V v6) {
            a.this = r1;
            this.f5321f = coordinatorLayout;
            this.f5322g = v6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OverScroller overScroller;
            if (this.f5322g == null || (overScroller = a.this.f5316i) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                a.this.C(this.f5322g, this.f5321f);
                return;
            }
            a aVar = a.this;
            aVar.E(this.f5321f, this.f5322g, aVar.f5316i.getCurrY());
            V v6 = this.f5322g;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.d.m(v6, this);
        }
    }

    public a() {
        this.f5318k = -1;
        this.m = -1;
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5318k = -1;
        this.m = -1;
    }

    public int A(V v6) {
        return v6.getHeight();
    }

    public int B() {
        return w();
    }

    public void C(View view, CoordinatorLayout coordinatorLayout) {
    }

    public int D(CoordinatorLayout coordinatorLayout, V v6, int i7, int i8, int i9) {
        int k6;
        int w6 = w();
        if (i8 == 0 || w6 < i8 || w6 > i9 || w6 == (k6 = e.k(i7, i8, i9))) {
            return 0;
        }
        d dVar = this.f5328f;
        if (dVar == null) {
            this.f5329g = k6;
        } else if (dVar.f5333d != k6) {
            dVar.f5333d = k6;
            dVar.a();
        }
        return w6 - k6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E(CoordinatorLayout coordinatorLayout, View view, int i7) {
        D(coordinatorLayout, view, i7, Integer.MIN_VALUE, SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean k(CoordinatorLayout coordinatorLayout, V v6, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.m < 0) {
            this.m = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f5317j) {
            int i7 = this.f5318k;
            if (i7 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i7)) == -1) {
                return false;
            }
            int y6 = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y6 - this.f5319l) > this.m) {
                this.f5319l = y6;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f5318k = -1;
            int x3 = (int) motionEvent.getX();
            int y7 = (int) motionEvent.getY();
            boolean z6 = y(v6) && coordinatorLayout.l(v6, x3, y7);
            this.f5317j = z6;
            if (z6) {
                this.f5319l = y7;
                this.f5318k = motionEvent.getPointerId(0);
                if (this.f5320n == null) {
                    this.f5320n = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.f5316i;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f5316i.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f5320n;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:184:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x00dc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:194:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean v(androidx.coordinatorlayout.widget.CoordinatorLayout r20, V r21, android.view.MotionEvent r22) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.a.v(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public boolean y(V v6) {
        return false;
    }

    public int z(V v6) {
        return -v6.getHeight();
    }
}
