package f6;

/* loaded from: classes.dex */
public final class e extends RuntimeException {

    /* renamed from: f */
    public final transient i5.f f4147f;

    public e(i5.f fVar) {
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
