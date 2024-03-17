package com.hunantv.imgo.database.dao3;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import j.l.a.i.e.e;
import j.l.a.i.e.k;
import r.c.b.a;
import r.c.b.h;
import r.c.b.l.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class GrayModeEntityDBDao extends a<k, String> {
    public static final String TABLENAME = "GRAY_MODE_DB";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Properties {
        public static final h a = new h(0, String.class, "id", true, "ID");
        public static final h b = new h(1, Boolean.class, "isAll", false, "IS_ALL");
        public static final h c = new h(2, Boolean.class, "isSingle", false, "IS_SINGLE");
    }

    public GrayModeEntityDBDao(r.c.b.n.a aVar) {
        super(aVar);
    }

    public static void x0(r.c.b.l.a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        aVar.b("CREATE TABLE " + str + "\"GRAY_MODE_DB\" (\"ID\" TEXT PRIMARY KEY NOT NULL ,\"IS_ALL\" INTEGER,\"IS_SINGLE\" INTEGER);");
    }

    public static void y0(r.c.b.l.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"GRAY_MODE_DB\"");
        aVar.b(sb.toString());
    }

    /* renamed from: A0 */
    public boolean E(k kVar) {
        return kVar.b() != null;
    }

    /* renamed from: B0 */
    public k f0(Cursor cursor, int i) {
        Boolean valueOf;
        int i2 = i + 0;
        Boolean bool = null;
        String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 1;
        if (cursor.isNull(i3)) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(cursor.getShort(i3) != 0);
        }
        int i4 = i + 2;
        if (!cursor.isNull(i4)) {
            bool = Boolean.valueOf(cursor.getShort(i4) != 0);
        }
        return new k(string, valueOf, bool);
    }

    /* renamed from: C0 */
    public void g0(Cursor cursor, k kVar, int i) {
        Boolean valueOf;
        int i2 = i + 0;
        Boolean bool = null;
        kVar.g(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 1;
        if (cursor.isNull(i3)) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(cursor.getShort(i3) != 0);
        }
        kVar.h(valueOf);
        int i4 = i + 2;
        if (!cursor.isNull(i4)) {
            bool = Boolean.valueOf(cursor.getShort(i4) != 0);
        }
        kVar.i(bool);
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
    public final String t0(k kVar, long j) {
        return kVar.b();
    }

    public final boolean P() {
        return true;
    }

    /* renamed from: v0 */
    public final void d(SQLiteStatement sQLiteStatement, k kVar) {
        sQLiteStatement.clearBindings();
        String b = kVar.b();
        if (b != null) {
            sQLiteStatement.bindString(1, b);
        }
        Boolean c = kVar.c();
        if (c != null) {
            sQLiteStatement.bindLong(2, c.booleanValue() ? 1L : 0L);
        }
        Boolean d = kVar.d();
        if (d != null) {
            sQLiteStatement.bindLong(3, d.booleanValue() ? 1L : 0L);
        }
    }

    /* renamed from: w0 */
    public final void e(c cVar, k kVar) {
        cVar.i();
        String b = kVar.b();
        if (b != null) {
            cVar.e(1, b);
        }
        Boolean c = kVar.c();
        if (c != null) {
            cVar.f(2, c.booleanValue() ? 1L : 0L);
        }
        Boolean d = kVar.d();
        if (d != null) {
            cVar.f(3, d.booleanValue() ? 1L : 0L);
        }
    }

    /* renamed from: z0 */
    public String v(k kVar) {
        if (kVar != null) {
            return kVar.b();
        }
        return null;
    }

    public GrayModeEntityDBDao(r.c.b.n.a aVar, e eVar) {
        super(aVar, eVar);
    }
}
