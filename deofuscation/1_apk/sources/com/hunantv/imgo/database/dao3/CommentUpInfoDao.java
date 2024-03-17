package com.hunantv.imgo.database.dao3;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.huawei.hms.support.feature.result.CommonConstant;
import j.l.a.i.e.b;
import j.l.a.i.e.e;
import r.c.b.a;
import r.c.b.h;
import r.c.b.l.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CommentUpInfoDao extends a<b, Long> {
    public static final String TABLENAME = "COMMENT_UP_DB";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Properties {
        public static final h a = new h(0, Long.class, "_id", true, "_id");
        public static final h b = new h(1, String.class, CommonConstant.KEY_UID, false, "UID");
        public static final h c = new h(2, String.class, "commentId", false, "COMMENTID");
    }

    public CommentUpInfoDao(r.c.b.n.a aVar) {
        super(aVar);
    }

    public static void x0(r.c.b.l.a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        aVar.b("CREATE TABLE " + str + "\"COMMENT_UP_DB\" (\"_id\" INTEGER PRIMARY KEY ,\"UID\" TEXT,\"COMMENTID\" TEXT);");
    }

    public static void y0(r.c.b.l.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"COMMENT_UP_DB\"");
        aVar.b(sb.toString());
    }

    /* renamed from: A0 */
    public boolean E(b bVar) {
        return bVar.c() != null;
    }

    /* renamed from: B0 */
    public b f0(Cursor cursor, int i) {
        int i2 = i + 0;
        int i3 = i + 1;
        int i4 = i + 2;
        return new b(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)), cursor.isNull(i3) ? null : cursor.getString(i3), cursor.isNull(i4) ? null : cursor.getString(i4));
    }

    /* renamed from: C0 */
    public void g0(Cursor cursor, b bVar, int i) {
        int i2 = i + 0;
        bVar.f(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        bVar.e(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        bVar.d(cursor.isNull(i4) ? null : cursor.getString(i4));
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
    public final Long t0(b bVar, long j) {
        bVar.f(Long.valueOf(j));
        return Long.valueOf(j);
    }

    public final boolean P() {
        return true;
    }

    /* renamed from: v0 */
    public final void d(SQLiteStatement sQLiteStatement, b bVar) {
        sQLiteStatement.clearBindings();
        Long c = bVar.c();
        if (c != null) {
            sQLiteStatement.bindLong(1, c.longValue());
        }
        String b = bVar.b();
        if (b != null) {
            sQLiteStatement.bindString(2, b);
        }
        String a = bVar.a();
        if (a != null) {
            sQLiteStatement.bindString(3, a);
        }
    }

    /* renamed from: w0 */
    public final void e(c cVar, b bVar) {
        cVar.i();
        Long c = bVar.c();
        if (c != null) {
            cVar.f(1, c.longValue());
        }
        String b = bVar.b();
        if (b != null) {
            cVar.e(2, b);
        }
        String a = bVar.a();
        if (a != null) {
            cVar.e(3, a);
        }
    }

    /* renamed from: z0 */
    public Long v(b bVar) {
        if (bVar != null) {
            return bVar.c();
        }
        return null;
    }

    public CommentUpInfoDao(r.c.b.n.a aVar, e eVar) {
        super(aVar, eVar);
    }
}
