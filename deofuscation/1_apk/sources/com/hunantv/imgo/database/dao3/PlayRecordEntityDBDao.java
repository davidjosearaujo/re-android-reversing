package com.hunantv.imgo.database.dao3;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import cn.com.custommma.mobile.tracking.util.SharedPreferencedUtil;
import j.l.a.i.e.e;
import j.l.a.i.e.n;
import r.c.b.a;
import r.c.b.h;
import r.c.b.l.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PlayRecordEntityDBDao extends a<n, Long> {
    public static final String TABLENAME = "PLAY_RECORD_DB";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Properties {
        public static final h a = new h(0, Long.class, "_id", true, "_id");
        public static final h b;
        public static final h c;
        public static final h d;
        public static final h e;
        public static final h f;
        public static final h g;
        public static final h h;
        public static final h i;
        public static final h j;
        public static final h k;
        public static final h l;
        public static final h m;
        public static final h n;

        static {
            Class cls = Integer.TYPE;
            b = new h(1, cls, "vid", false, "VID");
            c = new h(2, String.class, "vname", false, "VNAME");
            d = new h(3, String.class, "vimage", false, "VIMAGE");
            e = new h(4, cls, "watchTime", false, "WATCH_TIME");
            f = new h(5, cls, "duration", false, "DURATION");
            g = new h(6, Long.TYPE, SharedPreferencedUtil.SP_OTHER_KEY_UPDATE_TIME, false, "UPDATE_TIME");
            h = new h(7, cls, "pid", false, "PID");
            i = new h(8, cls, "cid", false, "CID");
            j = new h(9, cls, "sid", false, "SID");
            k = new h(10, cls, "isNewData", false, "ISNEWDATA");
            l = new h(11, cls, "type", false, "TYPE");
            m = new h(12, String.class, "releaseTime", false, "RELEASE_TIME");
            n = new h(13, cls, "serialNo", false, "SERIAL_NO");
        }
    }

    public PlayRecordEntityDBDao(r.c.b.n.a aVar) {
        super(aVar);
    }

    public static void x0(r.c.b.l.a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        aVar.b("CREATE TABLE " + str + "\"PLAY_RECORD_DB\" (\"_id\" INTEGER PRIMARY KEY ,\"VID\" INTEGER NOT NULL ,\"VNAME\" TEXT,\"VIMAGE\" TEXT,\"WATCH_TIME\" INTEGER NOT NULL ,\"DURATION\" INTEGER NOT NULL ,\"UPDATE_TIME\" INTEGER NOT NULL ,\"PID\" INTEGER NOT NULL ,\"CID\" INTEGER NOT NULL ,\"SID\" INTEGER NOT NULL ,\"ISNEWDATA\" INTEGER NOT NULL ,\"TYPE\" INTEGER NOT NULL ,\"RELEASE_TIME\" TEXT,\"SERIAL_NO\" INTEGER NOT NULL );");
    }

    public static void y0(r.c.b.l.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"PLAY_RECORD_DB\"");
        aVar.b(sb.toString());
    }

    /* renamed from: A0 */
    public boolean E(n nVar) {
        return nVar.n() != null;
    }

    /* renamed from: B0 */
    public n f0(Cursor cursor, int i) {
        int i2 = i + 0;
        int i3 = i + 2;
        int i4 = i + 3;
        int i5 = i + 12;
        return new n(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)), cursor.getInt(i + 1), cursor.isNull(i3) ? null : cursor.getString(i3), cursor.isNull(i4) ? null : cursor.getString(i4), cursor.getInt(i + 4), cursor.getInt(i + 5), cursor.getLong(i + 6), cursor.getInt(i + 7), cursor.getInt(i + 8), cursor.getInt(i + 9), cursor.getInt(i + 10), cursor.getInt(i + 11), cursor.isNull(i5) ? null : cursor.getString(i5), cursor.getInt(i + 13));
    }

    /* renamed from: C0 */
    public void g0(Cursor cursor, n nVar, int i) {
        int i2 = i + 0;
        nVar.B(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        nVar.x(cursor.getInt(i + 1));
        int i3 = i + 2;
        nVar.z(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 3;
        nVar.y(cursor.isNull(i4) ? null : cursor.getString(i4));
        nVar.A(cursor.getInt(i + 4));
        nVar.p(cursor.getInt(i + 5));
        nVar.w(cursor.getLong(i + 6));
        nVar.r(cursor.getInt(i + 7));
        nVar.o(cursor.getInt(i + 8));
        nVar.u(cursor.getInt(i + 9));
        nVar.q(cursor.getInt(i + 10));
        nVar.v(cursor.getInt(i + 11));
        int i5 = i + 12;
        nVar.s(cursor.isNull(i5) ? null : cursor.getString(i5));
        nVar.t(cursor.getInt(i + 13));
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
    public final Long t0(n nVar, long j) {
        nVar.B(Long.valueOf(j));
        return Long.valueOf(j);
    }

    public final boolean P() {
        return true;
    }

    /* renamed from: v0 */
    public final void d(SQLiteStatement sQLiteStatement, n nVar) {
        sQLiteStatement.clearBindings();
        Long n = nVar.n();
        if (n != null) {
            sQLiteStatement.bindLong(1, n.longValue());
        }
        sQLiteStatement.bindLong(2, nVar.j());
        String l = nVar.l();
        if (l != null) {
            sQLiteStatement.bindString(3, l);
        }
        String k = nVar.k();
        if (k != null) {
            sQLiteStatement.bindString(4, k);
        }
        sQLiteStatement.bindLong(5, nVar.m());
        sQLiteStatement.bindLong(6, nVar.b());
        sQLiteStatement.bindLong(7, nVar.i());
        sQLiteStatement.bindLong(8, nVar.d());
        sQLiteStatement.bindLong(9, nVar.a());
        sQLiteStatement.bindLong(10, nVar.g());
        sQLiteStatement.bindLong(11, nVar.c());
        sQLiteStatement.bindLong(12, nVar.h());
        String e = nVar.e();
        if (e != null) {
            sQLiteStatement.bindString(13, e);
        }
        sQLiteStatement.bindLong(14, nVar.f());
    }

    /* renamed from: w0 */
    public final void e(c cVar, n nVar) {
        cVar.i();
        Long n = nVar.n();
        if (n != null) {
            cVar.f(1, n.longValue());
        }
        cVar.f(2, nVar.j());
        String l = nVar.l();
        if (l != null) {
            cVar.e(3, l);
        }
        String k = nVar.k();
        if (k != null) {
            cVar.e(4, k);
        }
        cVar.f(5, nVar.m());
        cVar.f(6, nVar.b());
        cVar.f(7, nVar.i());
        cVar.f(8, nVar.d());
        cVar.f(9, nVar.a());
        cVar.f(10, nVar.g());
        cVar.f(11, nVar.c());
        cVar.f(12, nVar.h());
        String e = nVar.e();
        if (e != null) {
            cVar.e(13, e);
        }
        cVar.f(14, nVar.f());
    }

    /* renamed from: z0 */
    public Long v(n nVar) {
        if (nVar != null) {
            return nVar.n();
        }
        return null;
    }

    public PlayRecordEntityDBDao(r.c.b.n.a aVar, e eVar) {
        super(aVar, eVar);
    }
}
