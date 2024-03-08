package androidx.emoji2.text;

import java.nio.ByteBuffer;
import y1.a;
import y1.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i {

    /* renamed from: d */
    public static final ThreadLocal<a> f1530d = new ThreadLocal<>();

    /* renamed from: a */
    public final int f1531a;

    /* renamed from: b */
    public final n f1532b;

    /* renamed from: c */
    public volatile int f1533c = 0;

    public i(n nVar, int i7) {
        this.f1532b = nVar;
        this.f1531a = i7;
    }

    public final int a(int i7) {
        a c7 = c();
        int a7 = c7.a(16);
        if (a7 == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = c7.f6593b;
        int i8 = a7 + c7.f6592a;
        return byteBuffer.getInt((i7 * 4) + byteBuffer.getInt(i8) + i8 + 4);
    }

    public final int b() {
        a c7 = c();
        int a7 = c7.a(16);
        if (a7 == 0) {
            return 0;
        }
        int i7 = a7 + c7.f6592a;
        return c7.f6593b.getInt(c7.f6593b.getInt(i7) + i7);
    }

    public final a c() {
        short s;
        ThreadLocal<a> threadLocal = f1530d;
        a aVar = threadLocal.get();
        if (aVar == null) {
            aVar = new a();
            threadLocal.set(aVar);
        }
        b bVar = this.f1532b.f1554a;
        int i7 = this.f1531a;
        int a7 = bVar.a(6);
        if (a7 != 0) {
            int i8 = a7 + bVar.f6592a;
            int i9 = (i7 * 4) + bVar.f6593b.getInt(i8) + i8 + 4;
            int i10 = bVar.f6593b.getInt(i9) + i9;
            ByteBuffer byteBuffer = bVar.f6593b;
            aVar.f6593b = byteBuffer;
            if (byteBuffer != null) {
                aVar.f6592a = i10;
                int i11 = i10 - byteBuffer.getInt(i10);
                aVar.f6594c = i11;
                s = aVar.f6593b.getShort(i11);
            } else {
                s = 0;
                aVar.f6592a = 0;
                aVar.f6594c = 0;
            }
            aVar.f6595d = s;
        }
        return aVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        a c7 = c();
        int a7 = c7.a(4);
        sb.append(Integer.toHexString(a7 != 0 ? c7.f6593b.getInt(a7 + c7.f6592a) : 0));
        sb.append(", codepoints:");
        int b2 = b();
        for (int i7 = 0; i7 < b2; i7++) {
            sb.append(Integer.toHexString(a(i7)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
