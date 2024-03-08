package f6;

import a.a;
import f5.d;
import f5.e;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f4180a = 0;

    static {
        Object obj;
        Object obj2;
        Exception exc = new Exception();
        String simpleName = a.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        new StackTraceElement("_COROUTINE." + simpleName, "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            obj = Class.forName("k5.a").getCanonicalName();
        } catch (Throwable th) {
            obj = e.a(th);
        }
        if (d.a(obj) != null) {
            obj = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        String str = (String) obj;
        try {
            obj2 = t.class.getCanonicalName();
        } catch (Throwable th2) {
            obj2 = e.a(th2);
        }
        if (d.a(obj2) != null) {
            obj2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        String str2 = (String) obj2;
    }
}
