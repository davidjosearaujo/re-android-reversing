package p2;

import java.nio.charset.Charset;
import java.security.MessageDigest;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f5564a = Charset.forName("UTF-8");

    void a(MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
