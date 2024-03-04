package e6;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class a extends CancellationException {

    /* renamed from: f */
    public final transient d6.d<?> f3869f;

    public a(d6.m mVar) {
        super("Flow was aborted, no more elements needed");
        this.f3869f = mVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
