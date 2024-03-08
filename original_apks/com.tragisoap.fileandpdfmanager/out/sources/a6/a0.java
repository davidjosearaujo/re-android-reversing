package a6;

import c3.c;
import com.bumptech.glide.manager.f;
import com.bumptech.glide.manager.g;
import com.bumptech.glide.manager.m;
import d3.b;
import f5.e;
import i5.d;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import k3.a;
import p2.h;
import r2.v;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a0 implements b, f, m {
    public static final String c(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String e(d dVar) {
        Object obj;
        if (dVar instanceof f6.f) {
            return dVar.toString();
        }
        try {
            obj = dVar + '@' + c(dVar);
        } catch (Throwable th) {
            obj = e.a(th);
        }
        if (f5.d.a(obj) != null) {
            obj = dVar.getClass().getName() + '@' + c(dVar);
        }
        return (String) obj;
    }

    @Override // com.bumptech.glide.manager.f
    public final void a(g gVar) {
        gVar.a();
    }

    @Override // d3.b
    public final v b(v vVar, h hVar) {
        byte[] bArr;
        ByteBuffer asReadOnlyBuffer = ((c) vVar.get()).f2527f.f2536a.f2538a.g().asReadOnlyBuffer();
        AtomicReference<byte[]> atomicReference = a.f4685a;
        a.b bVar = (asReadOnlyBuffer.isReadOnly() || !asReadOnlyBuffer.hasArray()) ? null : new a.b(asReadOnlyBuffer.array(), asReadOnlyBuffer.arrayOffset(), asReadOnlyBuffer.limit());
        if (bVar != null && bVar.f4688a == 0 && bVar.f4689b == bVar.f4690c.length) {
            bArr = asReadOnlyBuffer.array();
        } else {
            ByteBuffer asReadOnlyBuffer2 = asReadOnlyBuffer.asReadOnlyBuffer();
            byte[] bArr2 = new byte[asReadOnlyBuffer2.limit()];
            ByteBuffer byteBuffer = (ByteBuffer) asReadOnlyBuffer2.position(0);
            asReadOnlyBuffer2.get(bArr2);
            bArr = bArr2;
        }
        return new z2.b(bArr);
    }

    @Override // com.bumptech.glide.manager.f
    public final void d(g gVar) {
    }
}
