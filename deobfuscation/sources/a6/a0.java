package a6;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import k3.a;

/* loaded from: classes.dex */
public final class a0 implements d3.b, com.bumptech.glide.manager.f, com.bumptech.glide.manager.m {
    public static final String c(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String e(i5.d dVar) {
        String str;
        if (dVar instanceof f6.f) {
            return dVar.toString();
        }
        try {
            str = dVar + '@' + c(dVar);
        } catch (Throwable th) {
            str = f5.e.a(th);
        }
        Throwable a7 = f5.d.a(str);
        String str2 = str;
        if (a7 != null) {
            str2 = dVar.getClass().getName() + '@' + c(dVar);
        }
        return (String) str2;
    }

    @Override // com.bumptech.glide.manager.f
    public final void a(com.bumptech.glide.manager.g gVar) {
        gVar.a();
    }

    @Override // d3.b
    public final r2.v b(r2.v vVar, p2.h hVar) {
        byte[] bArr;
        ByteBuffer asReadOnlyBuffer = ((c3.c) vVar.get()).f2527f.f2536a.f2538a.g().asReadOnlyBuffer();
        AtomicReference<byte[]> atomicReference = k3.a.f4685a;
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
    public final void d(com.bumptech.glide.manager.g gVar) {
    }
}
