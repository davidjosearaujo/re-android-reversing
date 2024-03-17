package com.hunantv.imgo.database.dao3;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import j.l.a.i.e.e;
import j.l.a.i.e.p;
import r.c.b.a;
import r.c.b.h;
import r.c.b.l.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class XAppInfoDBDao extends a<p, String> {
    public static final String TABLENAME = "XAPP_INFO_DB";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Properties {
        public static final h a = new h(0, String.class, "appId", true, HiAnalyticsConstant.HaKey.BI_KEY_APPID);
        public static final h b = new h(1, String.class, "appName", false, "APP_NAME");
        public static final h c = new h(2, String.class, "exInfo", false, "EX_INFO");
        public static final h d = new h(3, String.class, "maxNative", false, "MAX_NATIVE");
        public static final h e = new h(4, String.class, "md5", false, "MD5");
        public static final h f = new h(5, String.class, "minNative", false, "MIN_NATIVE");
        public static final h g = new h(6, String.class, "originUrl", false, "ORIGIN_URL");
        public static final h h = new h(7, String.class, "packageUrl", false, "PACKAGE_URL");
        public static final h i = new h(8, String.class, JThirdPlatFormInterface.KEY_PLATFORM, false, "PLATFORM");
        public static final h j = new h(9, Integer.TYPE, "priority", false, "PRIORITY");
        public static final h k = new h(10, String.class, "version", false, "VERSION");
        public static final h l = new h(11, Boolean.TYPE, "usePackage", false, "USE_PACKAGE");
        public static final h m = new h(12, String.class, "xAppIndexPath", false, "XAPP_INDEX_PATH");
        public static final h n = new h(13, String.class, "xAppBasePath", false, "XAPP_BASE_PATH");
    }

    public XAppInfoDBDao(r.c.b.n.a aVar) {
        super(aVar);
    }

    public static void x0(r.c.b.l.a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        aVar.b("CREATE TABLE " + str + "\"XAPP_INFO_DB\" (\"appid\" TEXT PRIMARY KEY NOT NULL ,\"APP_NAME\" TEXT,\"EX_INFO\" TEXT,\"MAX_NATIVE\" TEXT,\"MD5\" TEXT,\"MIN_NATIVE\" TEXT,\"ORIGIN_URL\" TEXT,\"PACKAGE_URL\" TEXT,\"PLATFORM\" TEXT,\"PRIORITY\" INTEGER NOT NULL ,\"VERSION\" TEXT,\"USE_PACKAGE\" INTEGER NOT NULL ,\"XAPP_INDEX_PATH\" TEXT,\"XAPP_BASE_PATH\" TEXT);");
    }

    public static void y0(r.c.b.l.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"XAPP_INFO_DB\"");
        aVar.b(sb.toString());
    }

    /* renamed from: A0 */
    public boolean E(p pVar) {
        return pVar.a() != null;
    }

    /* renamed from: B0 */
    public p f0(Cursor cursor, int i) {
        int i2 = i + 0;
        int i3 = i + 1;
        int i4 = i + 2;
        int i5 = i + 3;
        int i6 = i + 4;
        int i7 = i + 5;
        int i8 = i + 6;
        int i9 = i + 7;
        int i10 = i + 8;
        int i11 = i + 10;
        int i12 = i + 12;
        int i13 = i + 13;
        return new p(cursor.isNull(i2) ? null : cursor.getString(i2), cursor.isNull(i3) ? null : cursor.getString(i3), cursor.isNull(i4) ? null : cursor.getString(i4), cursor.isNull(i5) ? null : cursor.getString(i5), cursor.isNull(i6) ? null : cursor.getString(i6), cursor.isNull(i7) ? null : cursor.getString(i7), cursor.isNull(i8) ? null : cursor.getString(i8), cursor.isNull(i9) ? null : cursor.getString(i9), cursor.isNull(i10) ? null : cursor.getString(i10), cursor.getInt(i + 9), cursor.isNull(i11) ? null : cursor.getString(i11), cursor.getShort(i + 11) != 0, cursor.isNull(i12) ? null : cursor.getString(i12), cursor.isNull(i13) ? null : cursor.getString(i13));
    }

    /* renamed from: C0 */
    public void g0(Cursor cursor, p pVar, int i) {
        int i2 = i + 0;
        pVar.o(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 1;
        pVar.p(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        pVar.q(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 3;
        pVar.r(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 4;
        pVar.s(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 5;
        pVar.t(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 6;
        pVar.u(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 7;
        pVar.v(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i + 8;
        pVar.w(cursor.isNull(i10) ? null : cursor.getString(i10));
        pVar.x(cursor.getInt(i + 9));
        int i11 = i + 10;
        pVar.z(cursor.isNull(i11) ? null : cursor.getString(i11));
        pVar.y(cursor.getShort(i + 11) != 0);
        int i12 = i + 12;
        pVar.B(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i + 13;
        pVar.A(cursor.isNull(i13) ? null : cursor.getString(i13));
    }

    /* renamed from: D0 */
    public String h0(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return cursor.getString(i2);
    }

    /* renamed from: E0 */
    public final String t0(p pVar, long j) {
        return pVar.a();
    }

    public final boolean P() {
        return true;
    }

    /* renamed from: v0 */
    public final void d(SQLiteStatement sQLiteStatement, p pVar) {
        sQLiteStatement.clearBindings();
        String a = pVar.a();
        if (a != null) {
            sQLiteStatement.bindString(1, a);
        }
        String b = pVar.b();
        if (b != null) {
            sQLiteStatement.bindString(2, b);
        }
        String c = pVar.c();
        if (c != null) {
            sQLiteStatement.bindString(3, c);
        }
        String d = pVar.d();
        if (d != null) {
            sQLiteStatement.bindString(4, d);
        }
        String e = pVar.e();
        if (e != null) {
            sQLiteStatement.bindString(5, e);
        }
        String f = pVar.f();
        if (f != null) {
            sQLiteStatement.bindString(6, f);
        }
        String g = pVar.g();
        if (g != null) {
            sQLiteStatement.bindString(7, g);
        }
        String h = pVar.h();
        if (h != null) {
            sQLiteStatement.bindString(8, h);
        }
        String i = pVar.i();
        if (i != null) {
            sQLiteStatement.bindString(9, i);
        }
        sQLiteStatement.bindLong(10, pVar.j());
        String l = pVar.l();
        if (l != null) {
            sQLiteStatement.bindString(11, l);
        }
        sQLiteStatement.bindLong(12, pVar.k() ? 1L : 0L);
        String n = pVar.n();
        if (n != null) {
            sQLiteStatement.bindString(13, n);
        }
        String m = pVar.m();
        if (m != null) {
            sQLiteStatement.bindString(14, m);
        }
    }

    /* renamed from: w0 */
    public final void e(c cVar, p pVar) {
        cVar.i();
        String a = pVar.a();
        if (a != null) {
            cVar.e(1, a);
        }
        String b = pVar.b();
        if (b != null) {
            cVar.e(2, b);
        }
        String c = pVar.c();
        if (c != null) {
            cVar.e(3, c);
        }
        String d = pVar.d();
        if (d != null) {
            cVar.e(4, d);
        }
        String e = pVar.e();
        if (e != null) {
            cVar.e(5, e);
        }
        String f = pVar.f();
        if (f != null) {
            cVar.e(6, f);
        }
        String g = pVar.g();
        if (g != null) {
            cVar.e(7, g);
        }
        String h = pVar.h();
        if (h != null) {
            cVar.e(8, h);
        }
        String i = pVar.i();
        if (i != null) {
            cVar.e(9, i);
        }
        cVar.f(10, pVar.j());
        String l = pVar.l();
        if (l != null) {
            cVar.e(11, l);
        }
        cVar.f(12, pVar.k() ? 1L : 0L);
        String n = pVar.n();
        if (n != null) {
            cVar.e(13, n);
        }
        String m = pVar.m();
        if (m != null) {
            cVar.e(14, m);
        }
    }

    /* renamed from: z0 */
    public String v(p pVar) {
        if (pVar != null) {
            return pVar.a();
        }
        return null;
    }

    public XAppInfoDBDao(r.c.b.n.a aVar, e eVar) {
        super(aVar, eVar);
    }
}
