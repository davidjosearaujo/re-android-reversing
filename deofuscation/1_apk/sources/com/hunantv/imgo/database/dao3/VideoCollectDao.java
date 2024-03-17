package com.hunantv.imgo.database.dao3;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import j.l.a.i.e.e;
import j.l.a.i.e.o;
import r.c.b.a;
import r.c.b.h;
import r.c.b.l.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class VideoCollectDao extends a<o, Long> {
    public static final String TABLENAME = "VIDEO_COLLECT_DB";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Properties {
        public static final h a = new h(0, Long.class, "id", true, "_id");
        public static final h b = new h(1, String.class, "pid", false, "PID");
        public static final h c = new h(2, String.class, "createTime", false, "CREATE_TIME");
        public static final h d = new h(3, Integer.class, "type", false, "TYPE");
        public static final h e = new h(4, Integer.class, "vType", false, "V_TYPE");
        public static final h f = new h(5, String.class, "vid", false, "VID");
    }

    public VideoCollectDao(r.c.b.n.a aVar) {
        super(aVar);
    }

    public static void x0(r.c.b.l.a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        aVar.b("CREATE TABLE " + str + "\"VIDEO_COLLECT_DB\" (\"_id\" INTEGER PRIMARY KEY ,\"PID\" TEXT,\"CREATE_TIME\" TEXT,\"TYPE\" INTEGER,\"V_TYPE\" INTEGER,\"VID\" TEXT);");
    }

    public static void y0(r.c.b.l.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"VIDEO_COLLECT_DB\"");
        aVar.b(sb.toString());
    }

    /* renamed from: A0 */
    public boolean E(o oVar) {
        return oVar.b() != null;
    }

    /* renamed from: B0 */
    public o f0(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 2;
        String string2 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 3;
        Integer valueOf2 = cursor.isNull(i5) ? null : Integer.valueOf(cursor.getInt(i5));
        int i6 = i + 4;
        int i7 = i + 5;
        return new o(valueOf, string, string2, valueOf2, cursor.isNull(i6) ? null : Integer.valueOf(cursor.getInt(i6)), cursor.isNull(i7) ? null : cursor.getString(i7));
    }

    /* renamed from: C0 */
    public void g0(Cursor cursor, o oVar, int i) {
        int i2 = i + 0;
        oVar.i(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        oVar.j(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        oVar.h(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 3;
        oVar.k(cursor.isNull(i5) ? null : Integer.valueOf(cursor.getInt(i5)));
        int i6 = i + 4;
        oVar.l(cursor.isNull(i6) ? null : Integer.valueOf(cursor.getInt(i6)));
        int i7 = i + 5;
        oVar.m(cursor.isNull(i7) ? null : cursor.getString(i7));
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
    public final Long t0(o oVar, long j) {
        oVar.i(Long.valueOf(j));
        return Long.valueOf(j);
    }

    public final boolean P() {
        return true;
    }

    /* renamed from: v0 */
    public final void d(SQLiteStatement sQLiteStatement, o oVar) {
        sQLiteStatement.clearBindings();
        Long b = oVar.b();
        if (b != null) {
            sQLiteStatement.bindLong(1, b.longValue());
        }
        String c = oVar.c();
        if (c != null) {
            sQLiteStatement.bindString(2, c);
        }
        String a = oVar.a();
        if (a != null) {
            sQLiteStatement.bindString(3, a);
        }
        Integer d = oVar.d();
        if (d != null) {
            sQLiteStatement.bindLong(4, d.intValue());
        }
        Integer e = oVar.e();
        if (e != null) {
            sQLiteStatement.bindLong(5, e.intValue());
        }
        String f = oVar.f();
        if (f != null) {
            sQLiteStatement.bindString(6, f);
        }
    }

    /* renamed from: w0 */
    public final void e(c cVar, o oVar) {
        cVar.i();
        Long b = oVar.b();
        if (b != null) {
            cVar.f(1, b.longValue());
        }
        String c = oVar.c();
        if (c != null) {
            cVar.e(2, c);
        }
        String a = oVar.a();
        if (a != null) {
            cVar.e(3, a);
        }
        Integer d = oVar.d();
        if (d != null) {
            cVar.f(4, d.intValue());
        }
        Integer e = oVar.e();
        if (e != null) {
            cVar.f(5, e.intValue());
        }
        String f = oVar.f();
        if (f != null) {
            cVar.e(6, f);
        }
    }

    /* renamed from: z0 */
    public Long v(o oVar) {
        if (oVar != null) {
            return oVar.b();
        }
        return null;
    }

    public VideoCollectDao(r.c.b.n.a aVar, e eVar) {
        super(aVar, eVar);
    }
}
