package com.facebook.common.internal;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class Throwables {
    private Throwables() {
    }

    public static List<Throwable> getCausalChain(Throwable th) {
        Preconditions.checkNotNull(th);
        ArrayList arrayList = new ArrayList(4);
        while (th != null) {
            arrayList.add(th);
            th = th.getCause();
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static Throwable getRootCause(Throwable th) {
        while (true) {
            Throwable cause = th.getCause();
            if (cause == null) {
                return th;
            }
            th = cause;
        }
    }

    public static String getStackTraceAsString(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static RuntimeException propagate(Throwable th) {
        propagateIfPossible((Throwable) Preconditions.checkNotNull(th));
        throw new RuntimeException(th);
    }

    public static <X extends Throwable> void propagateIfInstanceOf(@Nullable Throwable th, Class<X> cls) throws Throwable {
        if (th != null && cls.isInstance(th)) {
            throw cls.cast(th);
        }
    }

    public static void propagateIfPossible(@Nullable Throwable th) {
        propagateIfInstanceOf(th, Error.class);
        propagateIfInstanceOf(th, RuntimeException.class);
    }

    public static <X extends Throwable> void propagateIfPossible(@Nullable Throwable th, Class<X> cls) throws Throwable {
        propagateIfInstanceOf(th, cls);
        propagateIfPossible(th);
    }

    public static <X1 extends Throwable, X2 extends Throwable> void propagateIfPossible(@Nullable Throwable th, Class<X1> cls, Class<X2> cls2) throws Throwable, Throwable {
        Preconditions.checkNotNull(cls2);
        propagateIfInstanceOf(th, cls);
        propagateIfPossible(th, cls2);
    }
}
