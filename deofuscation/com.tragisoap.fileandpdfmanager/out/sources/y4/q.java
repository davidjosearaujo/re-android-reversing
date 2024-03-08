package y4;

import androidx.fragment.app.s0;
import java.io.IOException;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public enum q {
    f6784g("http/1.0"),
    f6785h("http/1.1"),
    f6786i("spdy/3.1"),
    f6787j("h2");
    

    /* renamed from: f  reason: collision with root package name */
    public final String f6789f;

    q(String str) {
        this.f6789f = str;
    }

    public static q a(String str) {
        q qVar = f6784g;
        if (str.equals("http/1.0")) {
            return qVar;
        }
        q qVar2 = f6785h;
        if (str.equals("http/1.1")) {
            return qVar2;
        }
        q qVar3 = f6787j;
        if (str.equals("h2")) {
            return qVar3;
        }
        q qVar4 = f6786i;
        if (str.equals("spdy/3.1")) {
            return qVar4;
        }
        throw new IOException(s0.h("Unexpected protocol: ", str));
    }

    @Override // java.lang.Enum, java.lang.Object
    public final String toString() {
        return this.f6789f;
    }
}
