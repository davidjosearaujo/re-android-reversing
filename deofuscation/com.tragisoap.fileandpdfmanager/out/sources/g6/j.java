package g6;

import a6.a0;
import androidx.activity.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j extends g {

    /* renamed from: h  reason: collision with root package name */
    public final Runnable f4318h;

    public j(Runnable runnable, long j7, h hVar) {
        super(j7, hVar);
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

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder d7 = h.d("Task[");
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
