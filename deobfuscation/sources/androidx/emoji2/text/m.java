package androidx.emoji2.text;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;

/* loaded from: classes.dex */
public final class m {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public final ByteBuffer f1553a;

        public a(ByteBuffer byteBuffer) {
            this.f1553a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public final long a() {
            return this.f1553a.getInt() & 4294967295L;
        }

        public final void b(int i7) {
            ByteBuffer byteBuffer = this.f1553a;
            byteBuffer.position(byteBuffer.position() + i7);
        }
    }

    public static y1.b a(MappedByteBuffer mappedByteBuffer) {
        long j5;
        ByteBuffer duplicate = mappedByteBuffer.duplicate();
        a aVar = new a(duplicate);
        aVar.b(4);
        int i7 = duplicate.getShort() & 65535;
        if (i7 <= 100) {
            aVar.b(6);
            int i8 = 0;
            while (true) {
                if (i8 >= i7) {
                    j5 = -1;
                    break;
                }
                int i9 = aVar.f1553a.getInt();
                aVar.b(4);
                j5 = aVar.a();
                aVar.b(4);
                if (1835365473 == i9) {
                    break;
                }
                i8++;
            }
            if (j5 != -1) {
                aVar.b((int) (j5 - aVar.f1553a.position()));
                aVar.b(12);
                long a7 = aVar.a();
                for (int i10 = 0; i10 < a7; i10++) {
                    int i11 = aVar.f1553a.getInt();
                    long a8 = aVar.a();
                    aVar.a();
                    if (1164798569 == i11 || 1701669481 == i11) {
                        duplicate.position((int) (a8 + j5));
                        y1.b bVar = new y1.b();
                        duplicate.order(ByteOrder.LITTLE_ENDIAN);
                        int position = duplicate.position() + duplicate.getInt(duplicate.position());
                        bVar.f6593b = duplicate;
                        bVar.f6592a = position;
                        int i12 = position - duplicate.getInt(position);
                        bVar.f6594c = i12;
                        bVar.f6595d = bVar.f6593b.getShort(i12);
                        return bVar;
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }
}
