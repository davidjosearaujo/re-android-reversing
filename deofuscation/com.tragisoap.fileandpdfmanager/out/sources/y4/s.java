package y4;

import androidx.activity.h;
import androidx.fragment.app.s0;
import b5.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import y4.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class s {

    /* renamed from: a */
    public final r f6799a;

    /* renamed from: b */
    public final q f6800b;

    /* renamed from: c */
    public final int f6801c;

    /* renamed from: d */
    public final String f6802d;
    public final k e;

    /* renamed from: f */
    public final l f6803f;

    /* renamed from: g */
    public final t f6804g;

    /* renamed from: h */
    public s f6805h;

    /* renamed from: i */
    public s f6806i;

    /* renamed from: j */
    public final s f6807j;

    /* renamed from: k */
    public volatile c f6808k;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {

        /* renamed from: a */
        public r f6809a;

        /* renamed from: b */
        public q f6810b;

        /* renamed from: c */
        public int f6811c;

        /* renamed from: d */
        public String f6812d;
        public k e;

        /* renamed from: f */
        public l.a f6813f;

        /* renamed from: g */
        public t f6814g;

        /* renamed from: h */
        public s f6815h;

        /* renamed from: i */
        public s f6816i;

        /* renamed from: j */
        public s f6817j;

        public a() {
            this.f6811c = -1;
            this.f6813f = new l.a();
        }

        public a(s sVar) {
            this.f6811c = -1;
            this.f6809a = sVar.f6799a;
            this.f6810b = sVar.f6800b;
            this.f6811c = sVar.f6801c;
            this.f6812d = sVar.f6802d;
            this.e = sVar.e;
            this.f6813f = sVar.f6803f.c();
            this.f6814g = sVar.f6804g;
            this.f6815h = sVar.f6805h;
            this.f6816i = sVar.f6806i;
            this.f6817j = sVar.f6807j;
        }

        public static void b(String str, s sVar) {
            if (sVar.f6804g != null) {
                throw new IllegalArgumentException(s0.h(str, ".body != null"));
            } else if (sVar.f6805h != null) {
                throw new IllegalArgumentException(s0.h(str, ".networkResponse != null"));
            } else if (sVar.f6806i != null) {
                throw new IllegalArgumentException(s0.h(str, ".cacheResponse != null"));
            } else if (sVar.f6807j != null) {
                throw new IllegalArgumentException(s0.h(str, ".priorResponse != null"));
            }
        }

        public final s a() {
            if (this.f6809a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f6810b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f6811c >= 0) {
                return new s(this);
            } else {
                StringBuilder d7 = h.d("code < 0: ");
                d7.append(this.f6811c);
                throw new IllegalStateException(d7.toString());
            }
        }

        public final void c(s sVar) {
            if (sVar == null || sVar.f6804g == null) {
                this.f6817j = sVar;
                return;
            }
            throw new IllegalArgumentException("priorResponse.body != null");
        }
    }

    public s(a aVar) {
        this.f6799a = aVar.f6809a;
        this.f6800b = aVar.f6810b;
        this.f6801c = aVar.f6811c;
        this.f6802d = aVar.f6812d;
        this.e = aVar.e;
        l.a aVar2 = aVar.f6813f;
        aVar2.getClass();
        this.f6803f = new l(aVar2);
        this.f6804g = aVar.f6814g;
        this.f6805h = aVar.f6815h;
        this.f6806i = aVar.f6816i;
        this.f6807j = aVar.f6817j;
    }

    public final c a() {
        c cVar = this.f6808k;
        if (cVar != null) {
            return cVar;
        }
        c a7 = c.a(this.f6803f);
        this.f6808k = a7;
        return a7;
    }

    public final List<f> b() {
        String str;
        int i7 = this.f6801c;
        if (i7 == 401) {
            str = "WWW-Authenticate";
        } else if (i7 != 407) {
            return Collections.emptyList();
        } else {
            str = "Proxy-Authenticate";
        }
        l lVar = this.f6803f;
        j.a aVar = j.f2428a;
        ArrayList arrayList = new ArrayList();
        int length = lVar.f6744a.length / 2;
        for (int i8 = 0; i8 < length; i8++) {
            if (str.equalsIgnoreCase(lVar.b(i8))) {
                String d7 = lVar.d(i8);
                int i9 = 0;
                while (i9 < d7.length()) {
                    int M = q2.a.M(i9, d7, " ");
                    String trim = d7.substring(i9, M).trim();
                    int N = q2.a.N(M, d7);
                    if (!d7.regionMatches(true, N, "realm=\"", 0, 7)) {
                        break;
                    }
                    int i10 = N + 7;
                    int M2 = q2.a.M(i10, d7, "\"");
                    String substring = d7.substring(i10, M2);
                    i9 = q2.a.N(q2.a.M(M2 + 1, d7, ",") + 1, d7);
                    arrayList.add(new f(trim, substring));
                }
            }
        }
        return arrayList;
    }

    public final String c(String str) {
        String a7 = this.f6803f.a(str);
        if (a7 != null) {
            return a7;
        }
        return null;
    }

    public final a d() {
        return new a(this);
    }

    public final String toString() {
        StringBuilder d7 = h.d("Response{protocol=");
        d7.append(this.f6800b);
        d7.append(", code=");
        d7.append(this.f6801c);
        d7.append(", message=");
        d7.append(this.f6802d);
        d7.append(", url=");
        d7.append(this.f6799a.f6790a.f6753h);
        d7.append('}');
        return d7.toString();
    }
}
