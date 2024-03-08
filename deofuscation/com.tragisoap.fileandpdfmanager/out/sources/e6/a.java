package e6;

import d6.d;
import d6.m;
import java.util.concurrent.CancellationException;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a extends CancellationException {

    /* renamed from: f  reason: collision with root package name */
    public final transient d<?> f3869f;

    public a(m mVar) {
        super("Flow was aborted, no more elements needed");
        this.f3869f = mVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
