package m1;

import android.util.Base64;
import androidx.activity.h;
import java.util.List;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final String f5046a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5047b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5048c;

    /* renamed from: d  reason: collision with root package name */
    public final List<List<byte[]>> f5049d;
    public final String e;

    public f(String str, String str2, String str3, List<List<byte[]>> list) {
        str.getClass();
        this.f5046a = str;
        str2.getClass();
        this.f5047b = str2;
        this.f5048c = str3;
        list.getClass();
        this.f5049d = list;
        this.e = str + "-" + str2 + "-" + str3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder d7 = h.d("FontRequest {mProviderAuthority: ");
        d7.append(this.f5046a);
        d7.append(", mProviderPackage: ");
        d7.append(this.f5047b);
        d7.append(", mQuery: ");
        d7.append(this.f5048c);
        d7.append(", mCertificates:");
        sb.append(d7.toString());
        for (int i7 = 0; i7 < this.f5049d.size(); i7++) {
            sb.append(" [");
            List<byte[]> list = this.f5049d.get(i7);
            for (int i8 = 0; i8 < list.size(); i8++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i8), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        return h.c(sb, "}", "mCertificatesArray: 0");
    }
}
