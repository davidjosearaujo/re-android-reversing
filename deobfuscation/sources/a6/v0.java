package a6;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class v0 extends CancellationException {

    /* renamed from: f */
    public final transient u0 f343f;

    public v0(String str, Throwable th, u0 u0Var) {
        super(str);
        this.f343f = u0Var;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof v0) {
                v0 v0Var = (v0) obj;
                if (!r5.h.a(v0Var.getMessage(), getMessage()) || !r5.h.a(v0Var.f343f, this.f343f) || !r5.h.a(v0Var.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        r5.h.c(message);
        int hashCode = (this.f343f.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return hashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.f343f;
    }
}
