package v2;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class f implements p2.f {

    /* renamed from: b */
    public final g f6201b;

    /* renamed from: c */
    public final URL f6202c;

    /* renamed from: d */
    public final String f6203d;
    public String e;

    /* renamed from: f */
    public URL f6204f;

    /* renamed from: g */
    public volatile byte[] f6205g;

    /* renamed from: h */
    public int f6206h;

    public f(String str) {
        i iVar = g.f6207a;
        this.f6202c = null;
        if (!TextUtils.isEmpty(str)) {
            this.f6203d = str;
            q2.a.i(iVar);
            this.f6201b = iVar;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    @Override // p2.f
    public final void a(MessageDigest messageDigest) {
        if (this.f6205g == null) {
            this.f6205g = c().getBytes(p2.f.f5564a);
        }
        messageDigest.update(this.f6205g);
    }

    public final String c() {
        String str = this.f6203d;
        if (str != null) {
            return str;
        }
        URL url = this.f6202c;
        q2.a.i(url);
        return url.toString();
    }

    public final URL d() {
        if (this.f6204f == null) {
            if (TextUtils.isEmpty(this.e)) {
                String str = this.f6203d;
                if (TextUtils.isEmpty(str)) {
                    URL url = this.f6202c;
                    q2.a.i(url);
                    str = url.toString();
                }
                this.e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
            }
            this.f6204f = new URL(this.e);
        }
        return this.f6204f;
    }

    @Override // p2.f
    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            return c().equals(fVar.c()) && this.f6201b.equals(fVar.f6201b);
        }
        return false;
    }

    @Override // p2.f
    public final int hashCode() {
        if (this.f6206h == 0) {
            int hashCode = c().hashCode();
            this.f6206h = hashCode;
            this.f6206h = this.f6201b.hashCode() + (hashCode * 31);
        }
        return this.f6206h;
    }

    public final String toString() {
        return c();
    }

    public f(URL url) {
        i iVar = g.f6207a;
        q2.a.i(url);
        this.f6202c = url;
        this.f6203d = null;
        q2.a.i(iVar);
        this.f6201b = iVar;
    }
}
