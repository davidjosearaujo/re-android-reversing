package a.a.a.a;

import a.a.a.a.a0;
import a.a.a.a.c0;
import a.a.a.a.d0;
import a.a.a.a.g0;
import a.a.a.a.h0;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    static final h f78a;

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class a extends d0.a {

        /* renamed from: a  reason: collision with root package name */
        final Bundle f79a;

        /* renamed from: b  reason: collision with root package name */
        private final j0[] f80b;
        private boolean c;
        public int d;
        public CharSequence e;
        public PendingIntent f;

        @Override // a.a.a.a.d0.a
        public PendingIntent a() {
            return this.f;
        }

        @Override // a.a.a.a.d0.a
        public boolean b() {
            return this.c;
        }

        @Override // a.a.a.a.d0.a
        public Bundle c() {
            return this.f79a;
        }

        @Override // a.a.a.a.d0.a
        public int d() {
            return this.d;
        }

        @Override // a.a.a.a.d0.a
        public CharSequence f() {
            return this.e;
        }

        /* renamed from: g */
        public j0[] e() {
            return this.f80b;
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class b extends q {
        Bitmap e;
        Bitmap f;
        boolean g;
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class c extends q {
        CharSequence e;

        public c c(CharSequence charSequence) {
            this.e = d.c(charSequence);
            return this;
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class d {
        Notification B;
        RemoteViews C;
        RemoteViews D;
        RemoteViews E;
        public Notification F;

        /* renamed from: a  reason: collision with root package name */
        public Context f81a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f82b;
        public CharSequence c;
        PendingIntent d;
        PendingIntent e;
        RemoteViews f;
        public Bitmap g;
        public CharSequence h;
        public int i;
        public boolean l;
        public q m;
        public CharSequence n;
        public CharSequence[] o;
        int p;
        int q;
        boolean r;
        String s;
        boolean t;
        String u;
        String x;
        Bundle y;
        boolean k = true;
        public ArrayList<a> v = new ArrayList<>();
        boolean w = false;
        int z = 0;
        int A = 0;
        int j = 0;
        public ArrayList<String> G = new ArrayList<>();

        public d(Context context) {
            Notification notification = new Notification();
            this.F = notification;
            this.f81a = context;
            notification.when = System.currentTimeMillis();
            this.F.audioStreamType = -1;
        }

        protected static CharSequence c(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private void j(int i, boolean z) {
            Notification notification;
            int i2;
            if (z) {
                notification = this.F;
                i2 = i | notification.flags;
            } else {
                notification = this.F;
                i2 = (~i) & notification.flags;
            }
            notification.flags = i2;
        }

        public Notification a() {
            return z.f78a.a(this, b());
        }

        protected e b() {
            return new e();
        }

        protected CharSequence d() {
            return this.c;
        }

        protected CharSequence e() {
            return this.f82b;
        }

        public d f(boolean z) {
            j(16, z);
            return this;
        }

        public d g(PendingIntent pendingIntent) {
            this.d = pendingIntent;
            return this;
        }

        public d h(CharSequence charSequence) {
            this.c = c(charSequence);
            return this;
        }

        public d i(CharSequence charSequence) {
            this.f82b = c(charSequence);
            return this;
        }

        public d k(boolean z) {
            this.w = z;
            return this;
        }

        public d l(int i) {
            this.F.icon = i;
            return this;
        }

        public d m(q qVar) {
            if (this.m != qVar) {
                this.m = qVar;
                if (qVar != null) {
                    qVar.b(this);
                }
            }
            return this;
        }

        public d n(CharSequence charSequence) {
            this.F.tickerText = c(charSequence);
            return this;
        }

        public d o(long j) {
            this.F.when = j;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class e {
        protected e() {
        }

        public Notification a(d dVar, y yVar) {
            Notification b2 = yVar.b();
            RemoteViews remoteViews = dVar.C;
            if (remoteViews != null) {
                b2.contentView = remoteViews;
            }
            return b2;
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class f extends q {
        ArrayList<CharSequence> e = new ArrayList<>();
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class g extends q {
        private static short[] $ = {2077, 2066, 2072, 2062, 2067, 2069, 2072, 2130, 2063, 2073, 2064, 2074, 2104, 2069, 2063, 2060, 2064, 2077, 2053, 2098, 2077, 2065, 2073, 3660, 3651, 3657, 3679, 3650, 3652, 3657, 3587, 3662, 3650, 3651, 3675, 3656, 3679, 3678, 3660, 3673, 3652, 3650, 3651, 3705, 3652, 3673, 3649, 3656, 1730, 1741, 1735, 1745, 1740, 1738, 1735, 1677, 1742, 1734, 1744, 1744, 1730, 1732, 1734, 1744};
        CharSequence e;
        CharSequence f;
        List<a> g = new ArrayList();

        /* loaded from: /home/remnux/decompressedMalicious.dex */
        public static final class a {
            private static short[] $ = {266, 283, 262, 266, 5565, 5536, 5540, 5548, 4220, 4202, 4193, 4203, 4202, 4221, 3607, 3610, 3603, 3590, 5724, 5723, 5696};

            /* renamed from: a  reason: collision with root package name */
            private final CharSequence f83a;

            /* renamed from: b  reason: collision with root package name */
            private final long f84b;
            private final CharSequence c;
            private String d;
            private Uri e;

            private static String $(int i, int i2, int i3) {
                char[] cArr = new char[i2 - i];
                for (int i4 = 0; i4 < i2 - i; i4++) {
                    cArr[i4] = (char) ($[i + i4] ^ i3);
                }
                return new String(cArr);
            }

            static Bundle[] a(List<a> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bundleArr[i] = list.get(i).g();
                }
                return bundleArr;
            }

            private Bundle g() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.f83a;
                if (charSequence != null) {
                    bundle.putCharSequence($(0, 4, 382), charSequence);
                }
                bundle.putLong($(4, 8, 5577), this.f84b);
                CharSequence charSequence2 = this.c;
                if (charSequence2 != null) {
                    bundle.putCharSequence($(8, 14, 4111), charSequence2);
                }
                String str = this.d;
                if (str != null) {
                    bundle.putString($(14, 18, 3683), str);
                }
                Uri uri = this.e;
                if (uri != null) {
                    bundle.putParcelable($(18, 21, 5673), uri);
                }
                return bundle;
            }

            public String b() {
                return this.d;
            }

            public Uri c() {
                return this.e;
            }

            public CharSequence d() {
                return this.c;
            }

            public CharSequence e() {
                return this.f83a;
            }

            public long f() {
                return this.f84b;
            }
        }

        private static String $(int i, int i2, int i3) {
            char[] cArr = new char[i2 - i];
            for (int i4 = 0; i4 < i2 - i; i4++) {
                cArr[i4] = (char) ($[i + i4] ^ i3);
            }
            return new String(cArr);
        }

        g() {
        }

        @Override // a.a.a.a.z.q
        public void a(Bundle bundle) {
            super.a(bundle);
            CharSequence charSequence = this.e;
            if (charSequence != null) {
                bundle.putCharSequence($(0, 23, 2172), charSequence);
            }
            CharSequence charSequence2 = this.f;
            if (charSequence2 != null) {
                bundle.putCharSequence($(23, 48, 3629), charSequence2);
            }
            if (!this.g.isEmpty()) {
                bundle.putParcelableArray($(48, 64, 1699), a.a(this.g));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public interface h {
        Notification a(d dVar, e eVar);
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class i extends p {
        i() {
        }

        @Override // a.a.a.a.z.p, a.a.a.a.z.o, a.a.a.a.z.l, a.a.a.a.z.h
        public Notification a(d dVar, e eVar) {
            a0.a aVar = new a0.a(dVar.f81a, dVar.F, dVar.e(), dVar.d(), dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.p, dVar.q, dVar.r, dVar.k, dVar.l, dVar.j, dVar.n, dVar.w, dVar.G, dVar.y, dVar.s, dVar.t, dVar.u, dVar.C, dVar.D);
            z.a(aVar, dVar.v);
            z.c(aVar, dVar.m);
            Notification a2 = eVar.a(dVar, aVar);
            q qVar = dVar.m;
            if (qVar != null) {
                qVar.a(b(a2));
            }
            return a2;
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class j extends i {
        j() {
        }

        @Override // a.a.a.a.z.i, a.a.a.a.z.p, a.a.a.a.z.o, a.a.a.a.z.l, a.a.a.a.z.h
        public Notification a(d dVar, e eVar) {
            b0 b0Var = new b0(dVar.f81a, dVar.F, dVar.e(), dVar.d(), dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.p, dVar.q, dVar.r, dVar.k, dVar.l, dVar.j, dVar.n, dVar.w, dVar.x, dVar.G, dVar.y, dVar.z, dVar.A, dVar.B, dVar.s, dVar.t, dVar.u, dVar.C, dVar.D, dVar.E);
            z.a(b0Var, dVar.v);
            z.c(b0Var, dVar.m);
            Notification a2 = eVar.a(dVar, b0Var);
            q qVar = dVar.m;
            if (qVar != null) {
                qVar.a(b(a2));
            }
            return a2;
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class k extends j {
        k() {
        }

        @Override // a.a.a.a.z.j, a.a.a.a.z.i, a.a.a.a.z.p, a.a.a.a.z.o, a.a.a.a.z.l, a.a.a.a.z.h
        public Notification a(d dVar, e eVar) {
            c0.a aVar = new c0.a(dVar.f81a, dVar.F, dVar.f82b, dVar.c, dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.p, dVar.q, dVar.r, dVar.k, dVar.l, dVar.j, dVar.n, dVar.w, dVar.x, dVar.G, dVar.y, dVar.z, dVar.A, dVar.B, dVar.s, dVar.t, dVar.u, dVar.o, dVar.C, dVar.D, dVar.E);
            z.a(aVar, dVar.v);
            z.b(aVar, dVar.m);
            Notification a2 = eVar.a(dVar, aVar);
            q qVar = dVar.m;
            if (qVar != null) {
                qVar.a(b(a2));
            }
            return a2;
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class l implements h {
        l() {
        }

        @Override // a.a.a.a.z.h
        public Notification a(d dVar, e eVar) {
            Notification notification = dVar.F;
            d0.a(notification, dVar.f81a, dVar.e(), dVar.d(), dVar.d, dVar.e);
            if (dVar.j > 0) {
                notification.flags |= 128;
            }
            RemoteViews remoteViews = dVar.C;
            if (remoteViews != null) {
                notification.contentView = remoteViews;
            }
            return notification;
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class m extends l {
        m() {
        }

        @Override // a.a.a.a.z.l, a.a.a.a.z.h
        public Notification a(d dVar, e eVar) {
            Notification a2 = e0.a(dVar.f81a, dVar.F, dVar.e(), dVar.d(), dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g);
            RemoteViews remoteViews = dVar.C;
            if (remoteViews != null) {
                a2.contentView = remoteViews;
            }
            return a2;
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class n extends l {
        n() {
        }

        @Override // a.a.a.a.z.l, a.a.a.a.z.h
        public Notification a(d dVar, e eVar) {
            return eVar.a(dVar, new f0(dVar.f81a, dVar.F, dVar.e(), dVar.d(), dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.p, dVar.q, dVar.r));
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class o extends l {
        o() {
        }

        @Override // a.a.a.a.z.l, a.a.a.a.z.h
        public Notification a(d dVar, e eVar) {
            Bundle b2;
            g0.a aVar = new g0.a(dVar.f81a, dVar.F, dVar.e(), dVar.d(), dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.p, dVar.q, dVar.r, dVar.l, dVar.j, dVar.n, dVar.w, dVar.y, dVar.s, dVar.t, dVar.u, dVar.C, dVar.D);
            z.a(aVar, dVar.v);
            z.c(aVar, dVar.m);
            Notification a2 = eVar.a(dVar, aVar);
            if (!(dVar.m == null || (b2 = b(a2)) == null)) {
                dVar.m.a(b2);
            }
            return a2;
        }

        public Bundle b(Notification notification) {
            return g0.e(notification);
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class p extends o {
        p() {
        }

        @Override // a.a.a.a.z.o, a.a.a.a.z.l, a.a.a.a.z.h
        public Notification a(d dVar, e eVar) {
            h0.a aVar = new h0.a(dVar.f81a, dVar.F, dVar.e(), dVar.d(), dVar.h, dVar.f, dVar.i, dVar.d, dVar.e, dVar.g, dVar.p, dVar.q, dVar.r, dVar.k, dVar.l, dVar.j, dVar.n, dVar.w, dVar.G, dVar.y, dVar.s, dVar.t, dVar.u, dVar.C, dVar.D);
            z.a(aVar, dVar.v);
            z.c(aVar, dVar.m);
            return eVar.a(dVar, aVar);
        }

        @Override // a.a.a.a.z.o
        public Bundle b(Notification notification) {
            return h0.a(notification);
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static abstract class q {

        /* renamed from: a  reason: collision with root package name */
        d f85a;

        /* renamed from: b  reason: collision with root package name */
        CharSequence f86b;
        CharSequence c;
        boolean d = false;

        public void a(Bundle bundle) {
        }

        public void b(d dVar) {
            if (this.f85a != dVar) {
                this.f85a = dVar;
                if (dVar != null) {
                    dVar.m(this);
                }
            }
        }
    }

    static {
        h jVar;
        if (a.a.a.c.a.a()) {
            jVar = new k();
        } else {
            int i2 = Build.VERSION.SDK_INT;
            jVar = i2 >= 21 ? new j() : i2 >= 20 ? new i() : i2 >= 19 ? new p() : i2 >= 16 ? new o() : i2 >= 14 ? new n() : i2 >= 11 ? new m() : new l();
        }
        f78a = jVar;
    }

    static void a(x xVar, ArrayList<a> arrayList) {
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            xVar.c(it.next());
        }
    }

    static void b(y yVar, q qVar) {
        if (qVar == null) {
            return;
        }
        if (qVar instanceof g) {
            g gVar = (g) qVar;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            for (g.a aVar : gVar.g) {
                arrayList.add(aVar.e());
                arrayList2.add(Long.valueOf(aVar.f()));
                arrayList3.add(aVar.d());
                arrayList4.add(aVar.b());
                arrayList5.add(aVar.c());
            }
            c0.a(yVar, gVar.e, gVar.f, arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
            return;
        }
        c(yVar, qVar);
    }

    static void c(y yVar, q qVar) {
        if (qVar == null) {
            return;
        }
        if (qVar instanceof c) {
            c cVar = (c) qVar;
            g0.b(yVar, cVar.f86b, cVar.d, cVar.c, cVar.e);
        } else if (qVar instanceof f) {
            f fVar = (f) qVar;
            g0.c(yVar, fVar.f86b, fVar.d, fVar.c, fVar.e);
        } else if (qVar instanceof b) {
            b bVar = (b) qVar;
            g0.a(yVar, bVar.f86b, bVar.d, bVar.c, bVar.e, bVar.f, bVar.g);
        }
    }
}
