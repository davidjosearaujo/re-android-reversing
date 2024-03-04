package androidx.lifecycle;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class j extends CancellationException {

    /* renamed from: f */
    public final /* synthetic */ int f1872f = 1;

    public j() {
        super("Child of the scoped flow was cancelled");
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        switch (this.f1872f) {
            case 1:
                setStackTrace(new StackTraceElement[0]);
                return this;
            default:
                return super.fillInStackTrace();
        }
    }
}
