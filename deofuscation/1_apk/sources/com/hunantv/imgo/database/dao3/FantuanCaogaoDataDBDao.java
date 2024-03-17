package com.hunantv.imgo.database.dao3;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.facebook.share.internal.ShareConstants;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.hunantv.imgo.database.dao3.FantuanCaogaoDataDB;
import j.l.a.i.e.e;
import r.c.b.a;
import r.c.b.h;
import r.c.b.l.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class FantuanCaogaoDataDBDao extends a<FantuanCaogaoDataDB, Long> {
    public static final String TABLENAME = "FANTUAN_CAOGAO_DB";
    private final FantuanCaogaoDataDB.a k;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Properties {
        public static final h a = new h(0, Long.class, "_id", true, "_id");
        public static final h b = new h(1, String.class, "uuid", false, "UUID");
        public static final h c = new h(2, Long.class, CrashHianalyticsData.TIME, false, "TIME");
        public static final h d = new h(3, String.class, "title", false, ShareConstants.TITLE);
        public static final h e = new h(4, String.class, "desc", false, "DESC");
        public static final h f;
        public static final h g;
        public static final h h;
        public static final h i;
        public static final h j;
        public static final h k;

        static {
            Class cls = Integer.TYPE;
            f = new h(5, cls, "type", false, "TYPE");
            g = new h(6, String.class, "pathlist", false, "PATHLIST");
            h = new h(7, String.class, "fantuanname", false, "FANTUANNAME");
            i = new h(8, String.class, "fantuanid", false, "FANTUANID");
            j = new h(9, cls, "uniqueid", false, "FANTUANUNIQUE");
            k = new h(10, byte[].class, "fantuandesc", false, "FANTUANDESC");
        }
    }

    public FantuanCaogaoDataDBDao(r.c.b.n.a aVar) {
        super(aVar);
        this.k = new FantuanCaogaoDataDB.a();
    }

    public static void x0(r.c.b.l.a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        aVar.b("CREATE TABLE " + str + "\"FANTUAN_CAOGAO_DB\" (\"_id\" INTEGER PRIMARY KEY ,\"UUID\" TEXT,\"TIME\" INTEGER,\"TITLE\" TEXT,\"DESC\" TEXT,\"TYPE\" INTEGER NOT NULL ,\"PATHLIST\" TEXT,\"FANTUANNAME\" TEXT,\"FANTUANID\" TEXT,\"FANTUANUNIQUE\" INTEGER NOT NULL ,\"FANTUANDESC\" BLOB);");
    }

    public static void y0(r.c.b.l.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"FANTUAN_CAOGAO_DB\"");
        aVar.b(sb.toString());
    }

    /* renamed from: A0 */
    public boolean E(FantuanCaogaoDataDB fantuanCaogaoDataDB) {
        return fantuanCaogaoDataDB.k() != null;
    }

    /* renamed from: B0 */
    public FantuanCaogaoDataDB f0(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 2;
        Long valueOf2 = cursor.isNull(i4) ? null : Long.valueOf(cursor.getLong(i4));
        int i5 = i + 3;
        String string2 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 4;
        String string3 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = cursor.getInt(i + 5);
        int i8 = i + 6;
        String string4 = cursor.isNull(i8) ? null : cursor.getString(i8);
        int i9 = i + 7;
        String string5 = cursor.isNull(i9) ? null : cursor.getString(i9);
        int i10 = i + 8;
        String string6 = cursor.isNull(i10) ? null : cursor.getString(i10);
        int i11 = cursor.getInt(i + 9);
        int i12 = i + 10;
        return new FantuanCaogaoDataDB(valueOf, string, valueOf2, string2, string3, i7, string4, string5, string6, i11, cursor.isNull(i12) ? null : this.k.a(cursor.getBlob(i12)));
    }

    /* renamed from: C0 */
    public void g0(Cursor cursor, FantuanCaogaoDataDB fantuanCaogaoDataDB, int i) {
        int i2 = i + 0;
        fantuanCaogaoDataDB.v(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        fantuanCaogaoDataDB.u(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        fantuanCaogaoDataDB.q(cursor.isNull(i4) ? null : Long.valueOf(cursor.getLong(i4)));
        int i5 = i + 3;
        fantuanCaogaoDataDB.r(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 4;
        fantuanCaogaoDataDB.l(cursor.isNull(i6) ? null : cursor.getString(i6));
        fantuanCaogaoDataDB.s(cursor.getInt(i + 5));
        int i7 = i + 6;
        fantuanCaogaoDataDB.p(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 7;
        fantuanCaogaoDataDB.o(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 8;
        fantuanCaogaoDataDB.n(cursor.isNull(i9) ? null : cursor.getString(i9));
        fantuanCaogaoDataDB.t(cursor.getInt(i + 9));
        int i10 = i + 10;
        fantuanCaogaoDataDB.m(cursor.isNull(i10) ? null : this.k.a(cursor.getBlob(i10)));
    }

    /* renamed from: D0 */
    public Long h0(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    /* renamed from: E0 */
    public final Long t0(FantuanCaogaoDataDB fantuanCaogaoDataDB, long j) {
        fantuanCaogaoDataDB.v(Long.valueOf(j));
        return Long.valueOf(j);
    }

    public final boolean P() {
        return true;
    }

    /* renamed from: v0 */
    public final void d(SQLiteStatement sQLiteStatement, FantuanCaogaoDataDB fantuanCaogaoDataDB) {
        sQLiteStatement.clearBindings();
        Long k = fantuanCaogaoDataDB.k();
        if (k != null) {
            sQLiteStatement.bindLong(1, k.longValue());
        }
        String j = fantuanCaogaoDataDB.j();
        if (j != null) {
            sQLiteStatement.bindString(2, j);
        }
        Long f = fantuanCaogaoDataDB.f();
        if (f != null) {
            sQLiteStatement.bindLong(3, f.longValue());
        }
        String g = fantuanCaogaoDataDB.g();
        if (g != null) {
            sQLiteStatement.bindString(4, g);
        }
        String a = fantuanCaogaoDataDB.a();
        if (a != null) {
            sQLiteStatement.bindString(5, a);
        }
        sQLiteStatement.bindLong(6, fantuanCaogaoDataDB.h());
        String e = fantuanCaogaoDataDB.e();
        if (e != null) {
            sQLiteStatement.bindString(7, e);
        }
        String d = fantuanCaogaoDataDB.d();
        if (d != null) {
            sQLiteStatement.bindString(8, d);
        }
        String c = fantuanCaogaoDataDB.c();
        if (c != null) {
            sQLiteStatement.bindString(9, c);
        }
        sQLiteStatement.bindLong(10, fantuanCaogaoDataDB.i());
        FantuanCaogaoDataDB.FantuanDescription b = fantuanCaogaoDataDB.b();
        if (b != null) {
            sQLiteStatement.bindBlob(11, this.k.b(b));
        }
    }

    /* renamed from: w0 */
    public final void e(c cVar, FantuanCaogaoDataDB fantuanCaogaoDataDB) {
        cVar.i();
        Long k = fantuanCaogaoDataDB.k();
        if (k != null) {
            cVar.f(1, k.longValue());
        }
        String j = fantuanCaogaoDataDB.j();
        if (j != null) {
            cVar.e(2, j);
        }
        Long f = fantuanCaogaoDataDB.f();
        if (f != null) {
            cVar.f(3, f.longValue());
        }
        String g = fantuanCaogaoDataDB.g();
        if (g != null) {
            cVar.e(4, g);
        }
        String a = fantuanCaogaoDataDB.a();
        if (a != null) {
            cVar.e(5, a);
        }
        cVar.f(6, fantuanCaogaoDataDB.h());
        String e = fantuanCaogaoDataDB.e();
        if (e != null) {
            cVar.e(7, e);
        }
        String d = fantuanCaogaoDataDB.d();
        if (d != null) {
            cVar.e(8, d);
        }
        String c = fantuanCaogaoDataDB.c();
        if (c != null) {
            cVar.e(9, c);
        }
        cVar.f(10, fantuanCaogaoDataDB.i());
        FantuanCaogaoDataDB.FantuanDescription b = fantuanCaogaoDataDB.b();
        if (b != null) {
            cVar.g(11, this.k.b(b));
        }
    }

    /* renamed from: z0 */
    public Long v(FantuanCaogaoDataDB fantuanCaogaoDataDB) {
        if (fantuanCaogaoDataDB != null) {
            return fantuanCaogaoDataDB.k();
        }
        return null;
    }

    public FantuanCaogaoDataDBDao(r.c.b.n.a aVar, e eVar) {
        super(aVar, eVar);
        this.k = new FantuanCaogaoDataDB.a();
    }
}
