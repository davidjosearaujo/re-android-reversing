package f6;

import i5.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e extends RuntimeException {

    /* renamed from: f  reason: collision with root package name */
    public final transient f f4147f;

    public e(f fVar) {
        this.f4147f = fVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return this.f4147f.toString();
    }
}
