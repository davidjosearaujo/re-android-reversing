package y4;

import java.util.regex.Pattern;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class o {

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f6761c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f6762d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a  reason: collision with root package name */
    public final String f6763a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6764b;

    public o(String str, String str2) {
        this.f6763a = str;
        this.f6764b = str2;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof o) && ((o) obj).f6763a.equals(this.f6763a);
    }

    public final int hashCode() {
        return this.f6763a.hashCode();
    }

    public final String toString() {
        return this.f6763a;
    }
}
