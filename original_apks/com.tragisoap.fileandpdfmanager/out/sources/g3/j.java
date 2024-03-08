package g3;

import androidx.fragment.app.s0;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j implements e, d {

    /* renamed from: a  reason: collision with root package name */
    public final e f4240a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f4241b;

    /* renamed from: c  reason: collision with root package name */
    public volatile d f4242c;

    /* renamed from: d  reason: collision with root package name */
    public volatile d f4243d;
    public int e = 3;

    /* renamed from: f  reason: collision with root package name */
    public int f4244f = 3;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4245g;

    public j(Object obj, e eVar) {
        this.f4241b = obj;
        this.f4240a = eVar;
    }

    @Override // g3.e, g3.d
    public final boolean a() {
        boolean z6;
        synchronized (this.f4241b) {
            if (!this.f4243d.a() && !this.f4242c.a()) {
                z6 = false;
            }
            z6 = true;
        }
        return z6;
    }

    @Override // g3.e
    public final void b(d dVar) {
        synchronized (this.f4241b) {
            if (dVar.equals(this.f4243d)) {
                this.f4244f = 4;
                return;
            }
            this.e = 4;
            e eVar = this.f4240a;
            if (eVar != null) {
                eVar.b(this);
            }
            if (!s0.e(this.f4244f)) {
                this.f4243d.clear();
            }
        }
    }

    @Override // g3.d
    public final boolean c() {
        boolean z6;
        synchronized (this.f4241b) {
            z6 = this.e == 3;
        }
        return z6;
    }

    @Override // g3.d
    public final void clear() {
        synchronized (this.f4241b) {
            this.f4245g = false;
            this.e = 3;
            this.f4244f = 3;
            this.f4243d.clear();
            this.f4242c.clear();
        }
    }

    @Override // g3.e
    public final boolean d(d dVar) {
        boolean z6;
        boolean z7;
        synchronized (this.f4241b) {
            e eVar = this.f4240a;
            z6 = false;
            if (eVar != null && !eVar.d(this)) {
                z7 = false;
                if (z7 && dVar.equals(this.f4242c) && !a()) {
                    z6 = true;
                }
            }
            z7 = true;
            if (z7) {
                z6 = true;
            }
        }
        return z6;
    }

    @Override // g3.e
    public final boolean e(d dVar) {
        boolean z6;
        boolean z7;
        synchronized (this.f4241b) {
            e eVar = this.f4240a;
            z6 = false;
            if (eVar != null && !eVar.e(this)) {
                z7 = false;
                if (z7 && dVar.equals(this.f4242c) && this.e != 2) {
                    z6 = true;
                }
            }
            z7 = true;
            if (z7) {
                z6 = true;
            }
        }
        return z6;
    }

    @Override // g3.d
    public final void f() {
        synchronized (this.f4241b) {
            this.f4245g = true;
            if (!(this.e == 4 || this.f4244f == 1)) {
                this.f4244f = 1;
                this.f4243d.f();
            }
            if (this.f4245g && this.e != 1) {
                this.e = 1;
                this.f4242c.f();
            }
            this.f4245g = false;
        }
    }

    @Override // g3.d
    public final boolean g(d dVar) {
        if (!(dVar instanceof j)) {
            return false;
        }
        j jVar = (j) dVar;
        if (this.f4242c == null) {
            if (jVar.f4242c != null) {
                return false;
            }
        } else if (!this.f4242c.g(jVar.f4242c)) {
            return false;
        }
        if (this.f4243d == null) {
            if (jVar.f4243d != null) {
                return false;
            }
        } else if (!this.f4243d.g(jVar.f4243d)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [g3.e] */
    /* JADX WARN: Type inference failed for: r2v4 */
    @Override // g3.e
    public final e getRoot() {
        ?? r22;
        synchronized (this.f4241b) {
            e eVar = this.f4240a;
            this = this;
            if (eVar != null) {
                r22 = eVar.getRoot();
            }
        }
        return r22;
    }

    @Override // g3.e
    public final void h(d dVar) {
        synchronized (this.f4241b) {
            if (!dVar.equals(this.f4242c)) {
                this.f4244f = 5;
                return;
            }
            this.e = 5;
            e eVar = this.f4240a;
            if (eVar != null) {
                eVar.h(this);
            }
        }
    }

    @Override // g3.d
    public final boolean i() {
        boolean z6;
        synchronized (this.f4241b) {
            z6 = this.e == 4;
        }
        return z6;
    }

    @Override // g3.d
    public final boolean isRunning() {
        boolean z6;
        synchronized (this.f4241b) {
            z6 = true;
            if (this.e != 1) {
                z6 = false;
            }
        }
        return z6;
    }

    @Override // g3.e
    public final boolean j(d dVar) {
        boolean z6;
        boolean z7;
        synchronized (this.f4241b) {
            e eVar = this.f4240a;
            z6 = false;
            if (eVar != null && !eVar.j(this)) {
                z7 = false;
                if (z7 && (dVar.equals(this.f4242c) || this.e != 4)) {
                    z6 = true;
                }
            }
            z7 = true;
            if (z7) {
                z6 = true;
            }
        }
        return z6;
    }

    @Override // g3.d
    public final void pause() {
        synchronized (this.f4241b) {
            if (!s0.e(this.f4244f)) {
                this.f4244f = 2;
                this.f4243d.pause();
            }
            if (!s0.e(this.e)) {
                this.e = 2;
                this.f4242c.pause();
            }
        }
    }
}
