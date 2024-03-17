package com.facebook.bolts;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import n.b0;
import n.l2.v.f0;
import n.l2.v.s0;
import r.e.a.d;
import r.e.a.e;

/* compiled from: CancellationToken.kt */
@b0(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/bolts/CancellationToken;", "", "tokenSource", "Lcom/facebook/bolts/CancellationTokenSource;", "(Lcom/facebook/bolts/CancellationTokenSource;)V", "isCancellationRequested", "", "()Z", "register", "Lcom/facebook/bolts/CancellationTokenRegistration;", "action", "Ljava/lang/Runnable;", "throwIfCancellationRequested", "", "toString", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class CancellationToken {
    private final CancellationTokenSource tokenSource;

    public CancellationToken(@d CancellationTokenSource cancellationTokenSource) {
        f0.p(cancellationTokenSource, "tokenSource");
        this.tokenSource = cancellationTokenSource;
    }

    public final boolean isCancellationRequested() {
        return this.tokenSource.isCancellationRequested();
    }

    @d
    public final CancellationTokenRegistration register(@e Runnable runnable) {
        return this.tokenSource.register$facebook_core_release(runnable);
    }

    public final void throwIfCancellationRequested() throws CancellationException {
        this.tokenSource.throwIfCancellationRequested$facebook_core_release();
    }

    @d
    public String toString() {
        s0 s0Var = s0.a;
        String format = String.format(Locale.US, "%s@%s[cancellationRequested=%s]", Arrays.copyOf(new Object[]{CancellationToken.class.getName(), Integer.toHexString(hashCode()), Boolean.toString(this.tokenSource.isCancellationRequested())}, 3));
        f0.o(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }
}
