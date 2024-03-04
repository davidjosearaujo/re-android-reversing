package i;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
import l0.z;
import p1.k0;
import p1.l0;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: c */
    public Interpolator f4454c;

    /* renamed from: d */
    public l0 f4455d;
    public boolean e;

    /* renamed from: b */
    public long f4453b = -1;

    /* renamed from: f */
    public final a f4456f = new a();

    /* renamed from: a */
    public final ArrayList<k0> f4452a = new ArrayList<>();

    /* loaded from: classes.dex */
    public class a extends z {
        public boolean L = false;
        public int M = 0;

        public a() {
            g.this = r1;
        }

        @Override // p1.l0
        public final void a() {
            int i7 = this.M + 1;
            this.M = i7;
            if (i7 == g.this.f4452a.size()) {
                l0 l0Var = g.this.f4455d;
                if (l0Var != null) {
                    l0Var.a();
                }
                this.M = 0;
                this.L = false;
                g.this.e = false;
            }
        }

        @Override // l0.z, p1.l0
        public final void c() {
            if (this.L) {
                return;
            }
            this.L = true;
            l0 l0Var = g.this.f4455d;
            if (l0Var != null) {
                l0Var.c();
            }
        }
    }

    public final void a() {
        if (this.e) {
            Iterator<k0> it = this.f4452a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.e = false;
        }
    }

    public final void b() {
        View view;
        if (this.e) {
            return;
        }
        Iterator<k0> it = this.f4452a.iterator();
        while (it.hasNext()) {
            k0 next = it.next();
            long j5 = this.f4453b;
            if (j5 >= 0) {
                next.c(j5);
            }
            Interpolator interpolator = this.f4454c;
            if (interpolator != null && (view = next.f5495a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.f4455d != null) {
                next.d(this.f4456f);
            }
            View view2 = next.f5495a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.e = true;
    }
}
