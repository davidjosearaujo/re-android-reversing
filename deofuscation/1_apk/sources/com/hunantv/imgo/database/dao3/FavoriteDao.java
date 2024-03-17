package com.hunantv.imgo.database.dao3;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.facebook.share.internal.ShareConstants;
import j.l.a.i.e.e;
import j.l.a.i.e.i;
import r.c.b.a;
import r.c.b.h;
import r.c.b.l.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class FavoriteDao extends a<i, Long> {
    public static final String TABLENAME = "FAVORITE_DB";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Properties {
        public static final h a = new h(0, Long.class, "id", true, "_id");
        public static final h b = new h(1, String.class, "image", false, ShareConstants.IMAGE_URL);
        public static final h c = new h(2, String.class, "title", false, ShareConstants.TITLE);
        public static final h d = new h(3, Long.class, "createTime", false, "CREATE_TIME");
        public static final h e = new h(4, Integer.class, "videoId", false, "VIDEO_ID");
    }

    public FavoriteDao(r.c.b.n.a aVar) {
        super(aVar);
    }

    public static void x0(r.c.b.l.a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        aVar.b("CREATE TABLE " + str + "\"FAVORITE_DB\" (\"_id\" INTEGER PRIMARY KEY ,\"IMAGE\" TEXT,\"TITLE\" TEXT,\"CREATE_TIME\" INTEGER,\"VIDEO_ID\" INTEGER);");
    }

    public static void y0(r.c.b.l.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"FAVORITE_DB\"");
        aVar.b(sb.toString());
    }

    /* renamed from: A0 */
    public boolean E(i iVar) {
        return iVar.b() != null;
    }

    /* renamed from: B0 */
    public i f0(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        String string = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 2;
        String string2 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 3;
        int i6 = i + 4;
        return new i(valueOf, string, string2, cursor.isNull(i5) ? null : Long.valueOf(cursor.getLong(i5)), cursor.isNull(i6) ? null : Integer.valueOf(cursor.getInt(i6)));
    }

    /* renamed from: C0 */
    public void g0(Cursor cursor, i iVar, int i) {
        int i2 = i + 0;
        iVar.g(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        iVar.h(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        iVar.i(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 3;
        iVar.f(cursor.isNull(i5) ? null : Long.valueOf(cursor.getLong(i5)));
        int i6 = i + 4;
        iVar.j(cursor.isNull(i6) ? null : Integer.valueOf(cursor.getInt(i6)));
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
    public final Long t0(i iVar, long j) {
        iVar.g(Long.valueOf(j));
        return Long.valueOf(j);
    }

    public final boolean P() {
        return true;
    }

    /* renamed from: v0 */
    public final void d(SQLiteStatement sQLiteStatement, i iVar) {
        sQLiteStatement.clearBindings();
        Long b = iVar.b();
        if (b != null) {
            sQLiteStatement.bindLong(1, b.longValue());
        }
        String c = iVar.c();
        if (c != null) {
            sQLiteStatement.bindString(2, c);
        }
        String d = iVar.d();
        if (d != null) {
            sQLiteStatement.bindString(3, d);
        }
        Long a = iVar.a();
        if (a != null) {
            sQLiteStatement.bindLong(4, a.longValue());
        }
        Integer e = iVar.e();
        if (e != null) {
            sQLiteStatement.bindLong(5, e.intValue());
        }
    }

    /* renamed from: w0 */
    public final void e(c cVar, i iVar) {
        cVar.i();
        Long b = iVar.b();
        if (b != null) {
            cVar.f(1, b.longValue());
        }
        String c = iVar.c();
        if (c != null) {
            cVar.e(2, c);
        }
        String d = iVar.d();
        if (d != null) {
            cVar.e(3, d);
        }
        Long a = iVar.a();
        if (a != null) {
            cVar.f(4, a.longValue());
        }
        Integer e = iVar.e();
        if (e != null) {
            cVar.f(5, e.intValue());
        }
    }

    /* renamed from: z0 */
    public Long v(i iVar) {
        if (iVar != null) {
            return iVar.b();
        }
        return null;
    }

    public FavoriteDao(r.c.b.n.a aVar, e eVar) {
        super(aVar, eVar);
    }
}
