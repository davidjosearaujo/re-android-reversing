package com.hunantv.imgo.database.dao3;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import j.l.a.i.e.e;
import j.l.a.i.e.j;
import r.c.b.a;
import r.c.b.h;
import r.c.b.l.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class FrameRecordInfoDao extends a<j, Long> {
    public static final String TABLENAME = "FRAME_RECORD_DB";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Properties {
        public static final h a = new h(0, Long.class, "id", true, "_id");
        public static final h b = new h(1, String.class, "pageName", false, "PAGE_NAME");
        public static final h c = new h(2, String.class, "pageId", false, "PAGE_ID");
        public static final h d;
        public static final h e;
        public static final h f;
        public static final h g;
        public static final h h;
        public static final h i;
        public static final h j;

        static {
            Class cls = Integer.TYPE;
            d = new h(3, cls, "frameRate", false, "FRAME_RATE");
            e = new h(4, cls, "blockCount", false, "BLOCK_COUNT");
            f = new h(5, cls, "pageTime", false, "PAGE_TIME");
            g = new h(6, Long.TYPE, "recordTime", false, "RECORD_TIME");
            h = new h(7, cls, "webLoadDuration", false, "WEB_LOAD_DURATION");
            i = new h(8, cls, "webLoadResult", false, "WEB_LOAD_RESULT");
            j = new h(9, String.class, "tag", false, "TAG");
        }
    }

    public FrameRecordInfoDao(r.c.b.n.a aVar) {
        super(aVar);
    }

    public static void x0(r.c.b.l.a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        aVar.b("CREATE TABLE " + str + "\"FRAME_RECORD_DB\" (\"_id\" INTEGER PRIMARY KEY ,\"PAGE_NAME\" TEXT,\"PAGE_ID\" TEXT,\"FRAME_RATE\" INTEGER NOT NULL ,\"BLOCK_COUNT\" INTEGER NOT NULL ,\"PAGE_TIME\" INTEGER NOT NULL ,\"RECORD_TIME\" INTEGER NOT NULL ,\"WEB_LOAD_DURATION\" INTEGER NOT NULL ,\"WEB_LOAD_RESULT\" INTEGER NOT NULL ,\"TAG\" TEXT);");
    }

    public static void y0(r.c.b.l.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"FRAME_RECORD_DB\"");
        aVar.b(sb.toString());
    }

    /* renamed from: A0 */
    public boolean E(j jVar) {
        return jVar.d() != null;
    }

    /* renamed from: B0 */
    public j f0(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 2;
        String string2 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = cursor.getInt(i + 3);
        int i6 = cursor.getInt(i + 4);
        int i7 = cursor.getInt(i + 5);
        long j = cursor.getLong(i + 6);
        int i8 = cursor.getInt(i + 7);
        int i9 = cursor.getInt(i + 8);
        int i10 = i + 9;
        return new j(valueOf, string, string2, i5, i6, i7, j, i8, i9, cursor.isNull(i10) ? null : cursor.getString(i10));
    }

    /* renamed from: C0 */
    public void g0(Cursor cursor, j jVar, int i) {
        int i2 = i + 0;
        jVar.p(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        jVar.r(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        jVar.q(cursor.isNull(i4) ? null : cursor.getString(i4));
        jVar.o(cursor.getInt(i + 3));
        jVar.m(cursor.getInt(i + 4));
        jVar.s(cursor.getInt(i + 5));
        jVar.t(cursor.getLong(i + 6));
        jVar.v(cursor.getInt(i + 7));
        jVar.w(cursor.getInt(i + 8));
        int i5 = i + 9;
        jVar.u(cursor.isNull(i5) ? null : cursor.getString(i5));
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
    public final Long t0(j jVar, long j) {
        jVar.p(Long.valueOf(j));
        return Long.valueOf(j);
    }

    public final boolean P() {
        return true;
    }

    /* renamed from: v0 */
    public final void d(SQLiteStatement sQLiteStatement, j jVar) {
        sQLiteStatement.clearBindings();
        Long d = jVar.d();
        if (d != null) {
            sQLiteStatement.bindLong(1, d.longValue());
        }
        String f = jVar.f();
        if (f != null) {
            sQLiteStatement.bindString(2, f);
        }
        String e = jVar.e();
        if (e != null) {
            sQLiteStatement.bindString(3, e);
        }
        sQLiteStatement.bindLong(4, jVar.c());
        sQLiteStatement.bindLong(5, jVar.a());
        sQLiteStatement.bindLong(6, jVar.g());
        sQLiteStatement.bindLong(7, jVar.h());
        sQLiteStatement.bindLong(8, jVar.j());
        sQLiteStatement.bindLong(9, jVar.k());
        String i = jVar.i();
        if (i != null) {
            sQLiteStatement.bindString(10, i);
        }
    }

    /* renamed from: w0 */
    public final void e(c cVar, j jVar) {
        cVar.i();
        Long d = jVar.d();
        if (d != null) {
            cVar.f(1, d.longValue());
        }
        String f = jVar.f();
        if (f != null) {
            cVar.e(2, f);
        }
        String e = jVar.e();
        if (e != null) {
            cVar.e(3, e);
        }
        cVar.f(4, jVar.c());
        cVar.f(5, jVar.a());
        cVar.f(6, jVar.g());
        cVar.f(7, jVar.h());
        cVar.f(8, jVar.j());
        cVar.f(9, jVar.k());
        String i = jVar.i();
        if (i != null) {
            cVar.e(10, i);
        }
    }

    /* renamed from: z0 */
    public Long v(j jVar) {
        if (jVar != null) {
            return jVar.d();
        }
        return null;
    }

    public FrameRecordInfoDao(r.c.b.n.a aVar, e eVar) {
        super(aVar, eVar);
    }
}
