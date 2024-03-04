package i6;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a */
    public static final Charset f4541a = Charset.forName("UTF-8");

    public static void a(long j5, long j7, long j8) {
        if ((j7 | j8) < 0 || j7 > j5 || j5 - j7 < j8) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j5), Long.valueOf(j7), Long.valueOf(j8)));
        }
    }
}
