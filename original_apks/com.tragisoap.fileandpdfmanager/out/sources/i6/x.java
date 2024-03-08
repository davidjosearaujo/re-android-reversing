package i6;

import java.nio.charset.Charset;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f4541a = Charset.forName("UTF-8");

    public static void a(long j7, long j8, long j9) {
        if ((j8 | j9) < 0 || j8 > j7 || j7 - j8 < j9) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j7), Long.valueOf(j8), Long.valueOf(j9)));
        }
    }
}
