package f6;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a */
    public static final /* synthetic */ int f4180a = 0;

    static {
        Object a7;
        Object a8;
        Exception exc = new Exception();
        String simpleName = a.a.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        new StackTraceElement("_COROUTINE." + simpleName, "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            a7 = Class.forName("k5.a").getCanonicalName();
        } catch (Throwable th) {
            a7 = f5.e.a(th);
        }
        if (f5.d.a(a7) != null) {
            a7 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        String str = (String) a7;
        try {
            a8 = t.class.getCanonicalName();
        } catch (Throwable th2) {
            a8 = f5.e.a(th2);
        }
        if (f5.d.a(a8) != null) {
            a8 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        String str2 = (String) a8;
    }
}
