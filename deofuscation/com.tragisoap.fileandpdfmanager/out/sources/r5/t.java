package r5;

import x5.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class t {

    /* renamed from: a */
    public static final u f5928a;

    /* renamed from: b */
    public static final b[] f5929b;

    static {
        u uVar = null;
        try {
            uVar = (u) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (uVar == null) {
            uVar = new u();
        }
        f5928a = uVar;
        f5929b = new b[0];
    }

    public static d a(Class cls) {
        f5928a.getClass();
        return new d(cls);
    }
}
