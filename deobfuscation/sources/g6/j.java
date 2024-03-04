package g6;

import a6.a0;

/* loaded from: classes.dex */
public final class j extends g {

    /* renamed from: h */
    public final Runnable f4318h;

    public j(Runnable runnable, long j5, h hVar) {
        super(j5, hVar);
        this.f4318h = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f4318h.run();
        } finally {
            this.f4316g.a();
        }
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("Task[");
        d7.append(this.f4318h.getClass().getSimpleName());
        d7.append('@');
        d7.append(a0.c(this.f4318h));
        d7.append(", ");
        d7.append(this.f4315f);
        d7.append(", ");
        d7.append(this.f4316g);
        d7.append(']');
        return d7.toString();
    }
}
