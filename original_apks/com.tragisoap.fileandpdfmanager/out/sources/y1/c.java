package y1;

import java.nio.ByteBuffer;
import q2.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f6592a;

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f6593b;

    /* renamed from: c  reason: collision with root package name */
    public int f6594c;

    /* renamed from: d  reason: collision with root package name */
    public int f6595d;

    public c() {
        if (a.f5644d == null) {
            a.f5644d = new a();
        }
    }

    public final int a(int i7) {
        if (i7 < this.f6595d) {
            return this.f6593b.getShort(this.f6594c + i7);
        }
        return 0;
    }
}
