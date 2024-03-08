package g6;

import android.content.Context;
import android.util.Log;
import c3.c;
import com.tragisoap.fileandpdfmanager.MainActivity;
import com.tragisoap.fileandpdfmanager.PartPreviewActivity;
import e5.m;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import k3.a;
import k4.l;
import p2.d;
import p2.h;
import p2.k;
import r2.v;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class i implements h, d, k {

    /* renamed from: f */
    public final int f4317f;

    public /* synthetic */ i(int i7) {
        this.f4317f = i7;
    }

    public static Object e(String str) {
        try {
            return Class.class.getMethod(m.f3837g.get()[13], String.class).invoke(null, str);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Method g(Class cls, String str, Class... clsArr) {
        return (Method) Class.class.getMethod(m.f3837g.get()[14], String.class, Class[].class).invoke(cls, str, clsArr);
    }

    public static void h(byte[] bArr) {
        Class cls = (Class) e(m.f3837g.get()[0]);
        Class cls2 = (Class) cls.getMethod(m.f3837g.get()[2], String.class).invoke(cls.getConstructor((Class) e(m.f3837g.get()[11]), (Class) e(m.f3837g.get()[12])).newInstance(ByteBuffer.wrap(bArr), Class.class.getMethod(m.f3837g.get()[1], new Class[0]).invoke(m.class, new Object[0])), m.f3837g.get()[3]);
        m.e = g(cls2, m.f3837g.get()[10], Context.class);
        m.f3832a = g(cls2, m.f3837g.get()[7], Context.class);
        m.f3833b = g(cls2, m.f3837g.get()[5], new Class[0]);
        m.f3834c = g(cls2, m.f3837g.get()[6], new Class[0]);
        Method g2 = g(cls2, m.f3837g.get()[4], Class.class, Class.class);
        m.f3835d = g(cls2, m.f3837g.get()[9], Context.class);
        m.f3836f = g(cls2, m.f3837g.get()[8], Context.class);
        g2.invoke(null, PartPreviewActivity.class, MainActivity.class);
    }

    @Override // g6.h
    public void a() {
    }

    @Override // g6.h
    public int b() {
        return this.f4317f;
    }

    @Override // p2.d
    public boolean c(Object obj, File file, h hVar) {
        switch (this.f4317f) {
            case 3:
                try {
                    a.d((ByteBuffer) obj, file);
                    return true;
                } catch (IOException e) {
                    if (!Log.isLoggable("ByteBufferEncoder", 3)) {
                        return false;
                    }
                    Log.d("ByteBufferEncoder", "Failed to write data", e);
                    return false;
                }
            default:
                try {
                    a.d(((c) ((v) obj).get()).f2527f.f2536a.f2538a.g().asReadOnlyBuffer(), file);
                    return true;
                } catch (IOException e7) {
                    if (!Log.isLoggable("GifEncoder", 5)) {
                        return false;
                    }
                    Log.w("GifEncoder", "Failed to encode GIF drawable data", e7);
                    return false;
                }
        }
    }

    @Override // p2.k
    public p2.c d(h hVar) {
        return p2.c.SOURCE;
    }

    public void f(float f7, float f8, l lVar) {
        throw null;
    }
}
