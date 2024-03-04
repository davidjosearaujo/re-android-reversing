package q;

import androidx.fragment.app.s0;
import java.io.Serializable;
import java.net.ProtocolException;
import y4.q;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public final /* synthetic */ int f5589a = 1;

    /* renamed from: b */
    public int f5590b;

    /* renamed from: c */
    public Serializable f5591c;

    /* renamed from: d */
    public Serializable f5592d;

    public a(q qVar, int i7, String str) {
        this.f5591c = qVar;
        this.f5590b = i7;
        this.f5592d = str;
    }

    public static a a(String str) {
        String str2;
        q qVar = q.f6784g;
        int i7 = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException(s0.h("Unexpected status line: ", str));
            }
            int charAt = str.charAt(7) - '0';
            if (charAt != 0) {
                if (charAt != 1) {
                    throw new ProtocolException(s0.h("Unexpected status line: ", str));
                }
                qVar = q.f6785h;
            }
        } else if (!str.startsWith("ICY ")) {
            throw new ProtocolException(s0.h("Unexpected status line: ", str));
        } else {
            i7 = 4;
        }
        int i8 = i7 + 3;
        if (str.length() >= i8) {
            try {
                int parseInt = Integer.parseInt(str.substring(i7, i8));
                if (str.length() <= i8) {
                    str2 = "";
                } else if (str.charAt(i8) != ' ') {
                    throw new ProtocolException(s0.h("Unexpected status line: ", str));
                } else {
                    str2 = str.substring(i7 + 4);
                }
                return new a(qVar, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException(s0.h("Unexpected status line: ", str));
            }
        }
        throw new ProtocolException(s0.h("Unexpected status line: ", str));
    }

    public final String toString() {
        switch (this.f5589a) {
            case 1:
                StringBuilder sb = new StringBuilder();
                sb.append(((q) this.f5591c) == q.f6784g ? "HTTP/1.0" : "HTTP/1.1");
                sb.append(' ');
                sb.append(this.f5590b);
                if (((String) this.f5592d) != null) {
                    sb.append(' ');
                    sb.append((String) this.f5592d);
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }
}
