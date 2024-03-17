package com.hunantv.imgo.database.dao3;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import j.l.a.i.e.e;
import j.l.a.i.e.m;
import r.c.b.a;
import r.c.b.h;
import r.c.b.l.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PlayRecordClickDataDBDao extends a<m, Long> {
    public static final String TABLENAME = "PLAY_RECORD_CLICK_DB";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Properties {
        public static final h a = new h(0, Long.class, "_id", true, "_id");
        public static final h b = new h(1, String.class, "vid", false, "VID");
    }

    public PlayRecordClickDataDBDao(r.c.b.n.a aVar) {
        super(aVar);
    }

    public static void x0(r.c.b.l.a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        aVar.b("CREATE TABLE " + str + "\"PLAY_RECORD_CLICK_DB\" (\"_id\" INTEGER PRIMARY KEY ,\"VID\" TEXT);");
    }

    public static void y0(r.c.b.l.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"PLAY_RECORD_CLICK_DB\"");
        aVar.b(sb.toString());
    }

    /* renamed from: A0 */
    public boolean E(m mVar) {
        return mVar.b() != null;
    }

    /* renamed from: B0 */
    public m f0(Cursor cursor, int i) {
        int i2 = i + 0;
        int i3 = i + 1;
        return new m(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)), cursor.isNull(i3) ? null : cursor.getString(i3));
    }

    /* renamed from: C0 */
    public void g0(Cursor cursor, m mVar, int i) {
        int i2 = i + 0;
        mVar.d(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        mVar.c(cursor.isNull(i3) ? null : cursor.getString(i3));
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
    public final Long t0(m mVar, long j) {
        mVar.d(Long.valueOf(j));
        return Long.valueOf(j);
    }

    public final boolean P() {
        return true;
    }

    /* renamed from: v0 */
    public final void d(SQLiteStatement sQLiteStatement, m mVar) {
        sQLiteStatement.clearBindings();
        Long b = mVar.b();
        if (b != null) {
            sQLiteStatement.bindLong(1, b.longValue());
        }
        String a = mVar.a();
        if (a != null) {
            sQLiteStatement.bindString(2, a);
        }
    }

    /* renamed from: w0 */
    public final void e(c cVar, m mVar) {
        cVar.i();
        Long b = mVar.b();
        if (b != null) {
            cVar.f(1, b.longValue());
        }
        String a = mVar.a();
        if (a != null) {
            cVar.e(2, a);
        }
    }

    /* renamed from: z0 */
    public Long v(m mVar) {
        if (mVar != null) {
            return mVar.b();
        }
        return null;
    }

    public PlayRecordClickDataDBDao(r.c.b.n.a aVar, e eVar) {
        super(aVar, eVar);
    }
}
