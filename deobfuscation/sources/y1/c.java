package y1;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    public int f6592a;

    /* renamed from: b */
    public ByteBuffer f6593b;

    /* renamed from: c */
    public int f6594c;

    /* renamed from: d */
    public int f6595d;

    public c() {
        if (q2.a.f5644d == null) {
            q2.a.f5644d = new q2.a();
        }
    }

    public final int a(int i7) {
        if (i7 < this.f6595d) {
            return this.f6593b.getShort(this.f6594c + i7);
        }
        return 0;
    }
}
