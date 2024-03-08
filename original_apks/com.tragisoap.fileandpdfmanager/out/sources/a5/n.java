package a5;

import a5.o;
import a5.p;
import androidx.activity.h;
import i6.d;
import i6.g;
import i6.p;
import i6.r;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final m[] f223a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<g, Integer> f224b;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {

        /* renamed from: b  reason: collision with root package name */
        public final r f226b;

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList f225a = new ArrayList();
        public m[] e = new m[8];

        /* renamed from: f  reason: collision with root package name */
        public int f229f = 7;

        /* renamed from: g  reason: collision with root package name */
        public int f230g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f231h = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f227c = 4096;

        /* renamed from: d  reason: collision with root package name */
        public int f228d = 4096;

        public a(o.a aVar) {
            this.f226b = p.a(aVar);
        }

        public final int a(int i7) {
            int i8;
            int i9 = 0;
            if (i7 > 0) {
                int length = this.e.length;
                while (true) {
                    length--;
                    i8 = this.f229f;
                    if (length < i8 || i7 <= 0) {
                        break;
                    }
                    int i10 = this.e[length].f222c;
                    i7 -= i10;
                    this.f231h -= i10;
                    this.f230g--;
                    i9++;
                }
                m[] mVarArr = this.e;
                System.arraycopy(mVarArr, i8 + 1, mVarArr, i8 + 1 + i9, this.f230g);
                this.f229f += i9;
            }
            return i9;
        }

        public final void b(m mVar) {
            this.f225a.add(mVar);
            int i7 = mVar.f222c;
            int i8 = this.f228d;
            if (i7 > i8) {
                this.f225a.clear();
                Arrays.fill(this.e, (Object) null);
                this.f229f = this.e.length - 1;
                this.f230g = 0;
                this.f231h = 0;
                return;
            }
            a((this.f231h + i7) - i8);
            int i9 = this.f230g + 1;
            m[] mVarArr = this.e;
            if (i9 > mVarArr.length) {
                m[] mVarArr2 = new m[mVarArr.length * 2];
                System.arraycopy(mVarArr, 0, mVarArr2, mVarArr.length, mVarArr.length);
                this.f229f = this.e.length - 1;
                this.e = mVarArr2;
            }
            int i10 = this.f229f;
            this.f229f = i10 - 1;
            this.e[i10] = mVar;
            this.f230g++;
            this.f231h += i7;
        }

        public final g c() {
            int readByte = this.f226b.readByte() & 255;
            boolean z6 = (readByte & 128) == 128;
            int d7 = d(readByte, 127);
            if (!z6) {
                return this.f226b.j((long) d7);
            }
            p pVar = p.f256d;
            r rVar = this.f226b;
            long j7 = (long) d7;
            rVar.P(j7);
            byte[] i7 = rVar.f4526f.i(j7);
            pVar.getClass();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            p.a aVar = pVar.f257a;
            int i8 = 0;
            int i9 = 0;
            for (byte b2 : i7) {
                i9 = (i9 << 8) | (b2 & 255);
                i8 += 8;
                while (i8 >= 8) {
                    int i10 = i8 - 8;
                    aVar = aVar.f258a[(i9 >>> i10) & 255];
                    if (aVar.f258a == null) {
                        byteArrayOutputStream.write(aVar.f259b);
                        i8 -= aVar.f260c;
                        aVar = pVar.f257a;
                    } else {
                        i8 = i10;
                    }
                }
            }
            while (i8 > 0) {
                p.a aVar2 = aVar.f258a[(i9 << (8 - i8)) & 255];
                if (aVar2.f258a != null || aVar2.f260c > i8) {
                    break;
                }
                byteArrayOutputStream.write(aVar2.f259b);
                i8 -= aVar2.f260c;
                aVar = pVar.f257a;
            }
            return g.d(byteArrayOutputStream.toByteArray());
        }

        public final int d(int i7, int i8) {
            int i9 = i7 & i8;
            if (i9 < i8) {
                return i9;
            }
            int i10 = 0;
            while (true) {
                int readByte = this.f226b.readByte() & 255;
                if ((readByte & 128) == 0) {
                    return i8 + (readByte << i10);
                }
                i8 += (readByte & 127) << i10;
                i10 += 7;
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final d f232a;

        public b(d dVar) {
            this.f232a = dVar;
        }

        public final void a(g gVar) {
            c(gVar.f4501f.length, 127);
            this.f232a.q(gVar);
        }

        public final void b(ArrayList arrayList) {
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                g e = ((m) arrayList.get(i7)).f220a.e();
                Integer num = n.f224b.get(e);
                if (num != null) {
                    c(num.intValue() + 1, 15);
                } else {
                    this.f232a.z(0);
                    a(e);
                }
                a(((m) arrayList.get(i7)).f221b);
            }
        }

        public final void c(int i7, int i8) {
            int i9;
            d dVar;
            if (i7 < i8) {
                dVar = this.f232a;
                i9 = i7 | 0;
            } else {
                this.f232a.z(0 | i8);
                i9 = i7 - i8;
                while (i9 >= 128) {
                    this.f232a.z(128 | (i9 & 127));
                    i9 >>>= 7;
                }
                dVar = this.f232a;
            }
            dVar.z(i9);
        }
    }

    static {
        m mVar = new m(m.f217h, "");
        int i7 = 0;
        g gVar = m.e;
        g gVar2 = m.f215f;
        g gVar3 = m.f216g;
        g gVar4 = m.f214d;
        m[] mVarArr = {mVar, new m(gVar, "GET"), new m(gVar, "POST"), new m(gVar2, "/"), new m(gVar2, "/index.html"), new m(gVar3, "http"), new m(gVar3, "https"), new m(gVar4, "200"), new m(gVar4, "204"), new m(gVar4, "206"), new m(gVar4, "304"), new m(gVar4, "400"), new m(gVar4, "404"), new m(gVar4, "500"), new m("accept-charset", ""), new m("accept-encoding", "gzip, deflate"), new m("accept-language", ""), new m("accept-ranges", ""), new m("accept", ""), new m("access-control-allow-origin", ""), new m("age", ""), new m("allow", ""), new m("authorization", ""), new m("cache-control", ""), new m("content-disposition", ""), new m("content-encoding", ""), new m("content-language", ""), new m("content-length", ""), new m("content-location", ""), new m("content-range", ""), new m("content-type", ""), new m("cookie", ""), new m("date", ""), new m("etag", ""), new m("expect", ""), new m("expires", ""), new m("from", ""), new m("host", ""), new m("if-match", ""), new m("if-modified-since", ""), new m("if-none-match", ""), new m("if-range", ""), new m("if-unmodified-since", ""), new m("last-modified", ""), new m("link", ""), new m("location", ""), new m("max-forwards", ""), new m("proxy-authenticate", ""), new m("proxy-authorization", ""), new m("range", ""), new m("referer", ""), new m("refresh", ""), new m("retry-after", ""), new m("server", ""), new m("set-cookie", ""), new m("strict-transport-security", ""), new m("transfer-encoding", ""), new m("user-agent", ""), new m("vary", ""), new m("via", ""), new m("www-authenticate", "")};
        f223a = mVarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(mVarArr.length);
        while (true) {
            m[] mVarArr2 = f223a;
            if (i7 < mVarArr2.length) {
                if (!linkedHashMap.containsKey(mVarArr2[i7].f220a)) {
                    linkedHashMap.put(mVarArr2[i7].f220a, Integer.valueOf(i7));
                }
                i7++;
            } else {
                f224b = Collections.unmodifiableMap(linkedHashMap);
                return;
            }
        }
    }

    public static void a(g gVar) {
        int length = gVar.f4501f.length;
        for (int i7 = 0; i7 < length; i7++) {
            byte b2 = gVar.f4501f[i7];
            if (b2 >= 65 && b2 <= 90) {
                StringBuilder d7 = h.d("PROTOCOL_ERROR response malformed: mixed case name: ");
                d7.append(gVar.f());
                throw new IOException(d7.toString());
            }
        }
    }
}
