package i;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
import l0.z;
import p1.k0;
import p1.l0;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g {

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f4454c;

    /* renamed from: d  reason: collision with root package name */
    public l0 f4455d;
    public boolean e;

    /* renamed from: b  reason: collision with root package name */
    public long f4453b = -1;

    /* renamed from: f  reason: collision with root package name */
    public final a f4456f = new a();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<k0> f4452a = new ArrayList<>();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends z {
        public boolean L = false;
        public int M = 0;

        public a() {
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
            if (!this.L) {
                this.L = true;
                l0 l0Var = g.this.f4455d;
                if (l0Var != null) {
                    l0Var.c();
                }
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
        if (!this.e) {
            Iterator<k0> it = this.f4452a.iterator();
            while (it.hasNext()) {
                k0 next = it.next();
                long j7 = this.f4453b;
                if (j7 >= 0) {
                    next.c(j7);
                }
                Interpolator interpolator = this.f4454c;
                if (!(interpolator == null || (view = next.f5495a.get()) == null)) {
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
}
