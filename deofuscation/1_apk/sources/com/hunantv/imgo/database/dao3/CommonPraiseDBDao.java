package com.hunantv.imgo.database.dao3;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import j.l.a.i.e.c;
import j.l.a.i.e.e;
import r.c.b.a;
import r.c.b.h;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CommonPraiseDBDao extends a<c, Long> {
    public static final String TABLENAME = "PERSONAL_HOMEPAGE_COMMONPRAISE_DB";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Properties {
        public static final h a = new h(0, Long.class, "_id", true, "_id");
        public static final h b = new h(1, String.class, "itemId", false, "ITEM_ID");
        public static final h c = new h(2, Long.class, CrashHianalyticsData.TIME, false, "TIME");
        public static final h d = new h(3, Long.class, "keepTime", false, "KEEP_TIME");
        public static final h e = new h(4, String.class, "modelName", false, "MODEL_NAME");
        public static final h f = new h(5, String.class, "uuid", false, "UUID");
    }

    public CommonPraiseDBDao(r.c.b.n.a aVar) {
        super(aVar);
    }

    public static void x0(r.c.b.l.a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        aVar.b("CREATE TABLE " + str + "\"PERSONAL_HOMEPAGE_COMMONPRAISE_DB\" (\"_id\" INTEGER PRIMARY KEY ,\"ITEM_ID\" TEXT,\"TIME\" INTEGER,\"KEEP_TIME\" INTEGER,\"MODEL_NAME\" TEXT,\"UUID\" TEXT);");
    }

    public static void y0(r.c.b.l.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"PERSONAL_HOMEPAGE_COMMONPRAISE_DB\"");
        aVar.b(sb.toString());
    }

    /* renamed from: A0 */
    public boolean E(c cVar) {
        return cVar.f() != null;
    }

    /* renamed from: B0 */
    public c f0(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 2;
        Long valueOf2 = cursor.isNull(i4) ? null : Long.valueOf(cursor.getLong(i4));
        int i5 = i + 3;
        Long valueOf3 = cursor.isNull(i5) ? null : Long.valueOf(cursor.getLong(i5));
        int i6 = i + 4;
        int i7 = i + 5;
        return new c(valueOf, string, valueOf2, valueOf3, cursor.isNull(i6) ? null : cursor.getString(i6), cursor.isNull(i7) ? null : cursor.getString(i7));
    }

    /* renamed from: C0 */
    public void g0(Cursor cursor, c cVar, int i) {
        int i2 = i + 0;
        cVar.l(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        cVar.g(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        cVar.j(cursor.isNull(i4) ? null : Long.valueOf(cursor.getLong(i4)));
        int i5 = i + 3;
        cVar.h(cursor.isNull(i5) ? null : Long.valueOf(cursor.getLong(i5)));
        int i6 = i + 4;
        cVar.i(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 5;
        cVar.k(cursor.isNull(i7) ? null : cursor.getString(i7));
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
    public final Long t0(c cVar, long j) {
        cVar.l(Long.valueOf(j));
        return Long.valueOf(j);
    }

    public final boolean P() {
        return true;
    }

    /* renamed from: v0 */
    public final void d(SQLiteStatement sQLiteStatement, c cVar) {
        sQLiteStatement.clearBindings();
        Long f = cVar.f();
        if (f != null) {
            sQLiteStatement.bindLong(1, f.longValue());
        }
        String a = cVar.a();
        if (a != null) {
            sQLiteStatement.bindString(2, a);
        }
        Long d = cVar.d();
        if (d != null) {
            sQLiteStatement.bindLong(3, d.longValue());
        }
        Long b = cVar.b();
        if (b != null) {
            sQLiteStatement.bindLong(4, b.longValue());
        }
        String c = cVar.c();
        if (c != null) {
            sQLiteStatement.bindString(5, c);
        }
        String e = cVar.e();
        if (e != null) {
            sQLiteStatement.bindString(6, e);
        }
    }

    /* renamed from: w0 */
    public final void e(r.c.b.l.c cVar, c cVar2) {
        cVar.i();
        Long f = cVar2.f();
        if (f != null) {
            cVar.f(1, f.longValue());
        }
        String a = cVar2.a();
        if (a != null) {
            cVar.e(2, a);
        }
        Long d = cVar2.d();
        if (d != null) {
            cVar.f(3, d.longValue());
        }
        Long b = cVar2.b();
        if (b != null) {
            cVar.f(4, b.longValue());
        }
        String c = cVar2.c();
        if (c != null) {
            cVar.e(5, c);
        }
        String e = cVar2.e();
        if (e != null) {
            cVar.e(6, e);
        }
    }

    /* renamed from: z0 */
    public Long v(c cVar) {
        if (cVar != null) {
            return cVar.f();
        }
        return null;
    }

    public CommonPraiseDBDao(r.c.b.n.a aVar, e eVar) {
        super(aVar, eVar);
    }
}
