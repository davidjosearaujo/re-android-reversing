package y4;

import a0.e;
import androidx.activity.h;
import java.net.URI;
import y4.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class r {

    /* renamed from: a */
    public final m f6790a;

    /* renamed from: b */
    public final String f6791b;

    /* renamed from: c */
    public final l f6792c;

    /* renamed from: d */
    public final Object f6793d;
    public volatile URI e;

    /* renamed from: f */
    public volatile c f6794f;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {

        /* renamed from: a */
        public m f6795a;

        /* renamed from: b */
        public String f6796b;

        /* renamed from: c */
        public l.a f6797c;

        /* renamed from: d */
        public Object f6798d;

        public a() {
            this.f6796b = "GET";
            this.f6797c = new l.a();
        }

        public a(r rVar) {
            this.f6795a = rVar.f6790a;
            this.f6796b = rVar.f6791b;
            this.f6798d = rVar.f6793d;
            this.f6797c = rVar.f6792c.c();
        }

        public final r a() {
            if (this.f6795a != null) {
                return new r(this);
            }
            throw new IllegalStateException("url == null");
        }

        public final void b(String str) {
            if (str.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            } else if (!e.C(str)) {
                this.f6796b = str;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void c(java.lang.String r9) {
            /*
                r8 = this;
                r1 = 1
                r2 = 0
                r4 = 0
                r5 = 3
                java.lang.String r3 = "ws:"
                r0 = r9
                boolean r0 = r0.regionMatches(r1, r2, r3, r4, r5)
                if (r0 == 0) goto L_0x0015
                java.lang.String r0 = "http:"
                java.lang.StringBuilder r0 = androidx.activity.h.d(r0)
                r1 = 3
                goto L_0x0029
            L_0x0015:
                r3 = 1
                r4 = 0
                r6 = 0
                r7 = 4
                java.lang.String r5 = "wss:"
                r2 = r9
                boolean r0 = r2.regionMatches(r3, r4, r5, r6, r7)
                if (r0 == 0) goto L_0x0034
                java.lang.String r0 = "https:"
                java.lang.StringBuilder r0 = androidx.activity.h.d(r0)
                r1 = 4
            L_0x0029:
                java.lang.String r9 = r9.substring(r1)
                r0.append(r9)
                java.lang.String r9 = r0.toString()
            L_0x0034:
                y4.m$a r0 = new y4.m$a
                r0.<init>()
                r1 = 0
                int r2 = r0.c(r1, r9)
                r3 = 1
                if (r2 != r3) goto L_0x0045
                y4.m r1 = r0.a()
            L_0x0045:
                if (r1 == 0) goto L_0x004a
                r8.f6795a = r1
                return
            L_0x004a:
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "unexpected url: "
                java.lang.String r9 = androidx.fragment.app.s0.h(r0, r9)
                r8.<init>(r9)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: y4.r.a.c(java.lang.String):void");
        }
    }

    public r(a aVar) {
        this.f6790a = aVar.f6795a;
        this.f6791b = aVar.f6796b;
        l.a aVar2 = aVar.f6797c;
        aVar2.getClass();
        this.f6792c = new l(aVar2);
        Object obj = aVar.f6798d;
        this.f6793d = obj == null ? this : obj;
    }

    public final String a(String str) {
        return this.f6792c.a(str);
    }

    public final String toString() {
        StringBuilder d7 = h.d("Request{method=");
        d7.append(this.f6791b);
        d7.append(", url=");
        d7.append(this.f6790a);
        d7.append(", tag=");
        Object obj = this.f6793d;
        if (obj == this) {
            obj = null;
        }
        d7.append(obj);
        d7.append('}');
        return d7.toString();
    }
}
