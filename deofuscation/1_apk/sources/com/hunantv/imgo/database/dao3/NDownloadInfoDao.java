package com.hunantv.imgo.database.dao3;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import cn.com.custommma.mobile.tracking.api.Constant;
import com.facebook.share.internal.ShareConstants;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import j.l.a.i.e.e;
import j.l.a.i.e.l;
import r.c.b.a;
import r.c.b.h;
import r.c.b.l.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class NDownloadInfoDao extends a<l, Long> {
    public static final String TABLENAME = "DOWNLOAD_INFO";
    private e k;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Properties {
        public static final h a = new h(0, String.class, "domains", false, "DOMAINS");
        public static final h b = new h(1, Long.class, "id", true, "_id");
        public static final h c = new h(2, Integer.class, "videoId", false, "VIDEO_ID");
        public static final h d = new h(3, String.class, "image", false, ShareConstants.IMAGE_URL);
        public static final h e = new h(4, String.class, "name", false, "NAME");
        public static final h f = new h(5, String.class, "url", false, Constant.TRACKING_URL);
        public static final h g = new h(6, String.class, "videoUrl", false, "VIDEO_URL");
        public static final h h = new h(7, String.class, "filePath", false, "FILE_PATH");
        public static final h i = new h(8, Integer.class, "completeSize", false, "COMPLETE_SIZE");
        public static final h j = new h(9, Integer.class, "totalSize", false, "TOTAL_SIZE");
        public static final h k = new h(10, Integer.class, "status", false, CommonConstant.RETKEY.STATUS);
        public static final h l = new h(11, Long.class, "operateTime", false, "OPERATE_TIME");
        public static final h m = new h(12, Integer.class, "speed", false, "SPEED");
        public static final h n = new h(13, String.class, "idc", false, "IDC");
        public static final h o = new h(14, String.class, "nid", false, "NID");
        public static final h p = new h(15, Integer.class, "rootId", false, "ROOT_ID");
        public static final h q = new h(16, Integer.class, "collectionId", false, "COLLECTION_ID");
        public static final h r = new h(17, String.class, "collectionName", false, "COLLECTION_NAME");
        public static final h s = new h(18, String.class, "collectionImage", false, "COLLECTION_IMAGE");
        public static final h t = new h(19, Integer.class, "dataType", false, "DATA_TYPE");
        public static final h u = new h(20, Integer.class, "videoIndex", false, "VIDEO_INDEX");
        public static final h v = new h(21, Integer.class, "definition", false, "DEFINITION");
        public static final h w = new h(22, String.class, "freeUrl", false, "FREEURL");
        public static final h x = new h(23, String.class, "seriesId", false, "SERIESID");
    }

    public NDownloadInfoDao(r.c.b.n.a aVar) {
        super(aVar);
    }

    /* renamed from: A0 */
    public l f0(Cursor cursor, int i) {
        int i2 = i + 0;
        String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 1;
        Long valueOf = cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3));
        int i4 = i + 2;
        Integer valueOf2 = cursor.isNull(i4) ? null : Integer.valueOf(cursor.getInt(i4));
        int i5 = i + 3;
        String string2 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 4;
        String string3 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 5;
        String string4 = cursor.isNull(i7) ? null : cursor.getString(i7);
        int i8 = i + 6;
        String string5 = cursor.isNull(i8) ? null : cursor.getString(i8);
        int i9 = i + 7;
        String string6 = cursor.isNull(i9) ? null : cursor.getString(i9);
        int i10 = i + 8;
        Integer valueOf3 = cursor.isNull(i10) ? null : Integer.valueOf(cursor.getInt(i10));
        int i11 = i + 9;
        Integer valueOf4 = cursor.isNull(i11) ? null : Integer.valueOf(cursor.getInt(i11));
        int i12 = i + 10;
        Integer valueOf5 = cursor.isNull(i12) ? null : Integer.valueOf(cursor.getInt(i12));
        int i13 = i + 11;
        Long valueOf6 = cursor.isNull(i13) ? null : Long.valueOf(cursor.getLong(i13));
        int i14 = i + 12;
        Integer valueOf7 = cursor.isNull(i14) ? null : Integer.valueOf(cursor.getInt(i14));
        int i15 = i + 13;
        String string7 = cursor.isNull(i15) ? null : cursor.getString(i15);
        int i16 = i + 14;
        String string8 = cursor.isNull(i16) ? null : cursor.getString(i16);
        int i17 = i + 15;
        Integer valueOf8 = cursor.isNull(i17) ? null : Integer.valueOf(cursor.getInt(i17));
        int i18 = i + 16;
        Integer valueOf9 = cursor.isNull(i18) ? null : Integer.valueOf(cursor.getInt(i18));
        int i19 = i + 17;
        String string9 = cursor.isNull(i19) ? null : cursor.getString(i19);
        int i20 = i + 18;
        String string10 = cursor.isNull(i20) ? null : cursor.getString(i20);
        int i21 = i + 19;
        Integer valueOf10 = cursor.isNull(i21) ? null : Integer.valueOf(cursor.getInt(i21));
        int i22 = i + 20;
        Integer valueOf11 = cursor.isNull(i22) ? null : Integer.valueOf(cursor.getInt(i22));
        int i23 = i + 21;
        Integer valueOf12 = cursor.isNull(i23) ? null : Integer.valueOf(cursor.getInt(i23));
        int i24 = i + 22;
        String string11 = cursor.isNull(i24) ? null : cursor.getString(i24);
        int i25 = i + 23;
        return new l(string, valueOf, valueOf2, string2, string3, string4, string5, string6, valueOf3, valueOf4, valueOf5, valueOf6, valueOf7, string7, string8, valueOf8, valueOf9, string9, string10, valueOf10, valueOf11, valueOf12, string11, cursor.isNull(i25) ? null : cursor.getString(i25));
    }

    /* renamed from: B0 */
    public void g0(Cursor cursor, l lVar, int i) {
        int i2 = i + 0;
        lVar.I(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 1;
        lVar.L(cursor.isNull(i3) ? null : Long.valueOf(cursor.getLong(i3)));
        int i4 = i + 2;
        lVar.X(cursor.isNull(i4) ? null : Integer.valueOf(cursor.getInt(i4)));
        int i5 = i + 3;
        lVar.N(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 4;
        lVar.O(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 5;
        lVar.W(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 6;
        lVar.Z(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 7;
        lVar.J(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i + 8;
        lVar.F(cursor.isNull(i10) ? null : Integer.valueOf(cursor.getInt(i10)));
        int i11 = i + 9;
        lVar.V(cursor.isNull(i11) ? null : Integer.valueOf(cursor.getInt(i11)));
        int i12 = i + 10;
        lVar.U(cursor.isNull(i12) ? null : Integer.valueOf(cursor.getInt(i12)));
        int i13 = i + 11;
        lVar.Q(cursor.isNull(i13) ? null : Long.valueOf(cursor.getLong(i13)));
        int i14 = i + 12;
        lVar.T(cursor.isNull(i14) ? null : Integer.valueOf(cursor.getInt(i14)));
        int i15 = i + 13;
        lVar.M(cursor.isNull(i15) ? null : cursor.getString(i15));
        int i16 = i + 14;
        lVar.P(cursor.isNull(i16) ? null : cursor.getString(i16));
        int i17 = i + 15;
        lVar.R(cursor.isNull(i17) ? null : Integer.valueOf(cursor.getInt(i17)));
        int i18 = i + 16;
        lVar.C(cursor.isNull(i18) ? null : Integer.valueOf(cursor.getInt(i18)));
        int i19 = i + 17;
        lVar.E(cursor.isNull(i19) ? null : cursor.getString(i19));
        int i20 = i + 18;
        lVar.D(cursor.isNull(i20) ? null : cursor.getString(i20));
        int i21 = i + 19;
        lVar.G(cursor.isNull(i21) ? null : Integer.valueOf(cursor.getInt(i21)));
        int i22 = i + 20;
        lVar.Y(cursor.isNull(i22) ? null : Integer.valueOf(cursor.getInt(i22)));
        int i23 = i + 21;
        lVar.H(cursor.isNull(i23) ? null : Integer.valueOf(cursor.getInt(i23)));
        int i24 = i + 22;
        lVar.K(cursor.isNull(i24) ? null : cursor.getString(i24));
        int i25 = i + 23;
        lVar.S(cursor.isNull(i25) ? null : cursor.getString(i25));
    }

    /* renamed from: C0 */
    public Long h0(Cursor cursor, int i) {
        int i2 = i + 1;
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    /* renamed from: D0 */
    public final Long t0(l lVar, long j) {
        lVar.L(Long.valueOf(j));
        return Long.valueOf(j);
    }

    public final boolean P() {
        return true;
    }

    /* renamed from: v0 */
    public final void b(l lVar) {
        super.b(lVar);
        lVar.a(this.k);
    }

    /* renamed from: w0 */
    public final void d(SQLiteStatement sQLiteStatement, l lVar) {
        sQLiteStatement.clearBindings();
        String i = lVar.i();
        if (i != null) {
            sQLiteStatement.bindString(1, i);
        }
        Long m = lVar.m();
        if (m != null) {
            sQLiteStatement.bindLong(2, m.longValue());
        }
        Integer y = lVar.y();
        if (y != null) {
            sQLiteStatement.bindLong(3, y.intValue());
        }
        String o = lVar.o();
        if (o != null) {
            sQLiteStatement.bindString(4, o);
        }
        String p = lVar.p();
        if (p != null) {
            sQLiteStatement.bindString(5, p);
        }
        String x = lVar.x();
        if (x != null) {
            sQLiteStatement.bindString(6, x);
        }
        String A = lVar.A();
        if (A != null) {
            sQLiteStatement.bindString(7, A);
        }
        String k = lVar.k();
        if (k != null) {
            sQLiteStatement.bindString(8, k);
        }
        Integer f = lVar.f();
        if (f != null) {
            sQLiteStatement.bindLong(9, f.intValue());
        }
        Integer w = lVar.w();
        if (w != null) {
            sQLiteStatement.bindLong(10, w.intValue());
        }
        Integer v = lVar.v();
        if (v != null) {
            sQLiteStatement.bindLong(11, v.intValue());
        }
        Long r = lVar.r();
        if (r != null) {
            sQLiteStatement.bindLong(12, r.longValue());
        }
        Integer u = lVar.u();
        if (u != null) {
            sQLiteStatement.bindLong(13, u.intValue());
        }
        String n = lVar.n();
        if (n != null) {
            sQLiteStatement.bindString(14, n);
        }
        String q = lVar.q();
        if (q != null) {
            sQLiteStatement.bindString(15, q);
        }
        Integer s = lVar.s();
        if (s != null) {
            sQLiteStatement.bindLong(16, s.intValue());
        }
        Integer c = lVar.c();
        if (c != null) {
            sQLiteStatement.bindLong(17, c.intValue());
        }
        String e = lVar.e();
        if (e != null) {
            sQLiteStatement.bindString(18, e);
        }
        String d = lVar.d();
        if (d != null) {
            sQLiteStatement.bindString(19, d);
        }
        Integer g = lVar.g();
        if (g != null) {
            sQLiteStatement.bindLong(20, g.intValue());
        }
        Integer z = lVar.z();
        if (z != null) {
            sQLiteStatement.bindLong(21, z.intValue());
        }
        Integer h = lVar.h();
        if (h != null) {
            sQLiteStatement.bindLong(22, h.intValue());
        }
        String l = lVar.l();
        if (l != null) {
            sQLiteStatement.bindString(23, l);
        }
        String t = lVar.t();
        if (t != null) {
            sQLiteStatement.bindString(24, t);
        }
    }

    /* renamed from: x0 */
    public final void e(c cVar, l lVar) {
        cVar.i();
        String i = lVar.i();
        if (i != null) {
            cVar.e(1, i);
        }
        Long m = lVar.m();
        if (m != null) {
            cVar.f(2, m.longValue());
        }
        Integer y = lVar.y();
        if (y != null) {
            cVar.f(3, y.intValue());
        }
        String o = lVar.o();
        if (o != null) {
            cVar.e(4, o);
        }
        String p = lVar.p();
        if (p != null) {
            cVar.e(5, p);
        }
        String x = lVar.x();
        if (x != null) {
            cVar.e(6, x);
        }
        String A = lVar.A();
        if (A != null) {
            cVar.e(7, A);
        }
        String k = lVar.k();
        if (k != null) {
            cVar.e(8, k);
        }
        Integer f = lVar.f();
        if (f != null) {
            cVar.f(9, f.intValue());
        }
        Integer w = lVar.w();
        if (w != null) {
            cVar.f(10, w.intValue());
        }
        Integer v = lVar.v();
        if (v != null) {
            cVar.f(11, v.intValue());
        }
        Long r = lVar.r();
        if (r != null) {
            cVar.f(12, r.longValue());
        }
        Integer u = lVar.u();
        if (u != null) {
            cVar.f(13, u.intValue());
        }
        String n = lVar.n();
        if (n != null) {
            cVar.e(14, n);
        }
        String q = lVar.q();
        if (q != null) {
            cVar.e(15, q);
        }
        Integer s = lVar.s();
        if (s != null) {
            cVar.f(16, s.intValue());
        }
        Integer c = lVar.c();
        if (c != null) {
            cVar.f(17, c.intValue());
        }
        String e = lVar.e();
        if (e != null) {
            cVar.e(18, e);
        }
        String d = lVar.d();
        if (d != null) {
            cVar.e(19, d);
        }
        Integer g = lVar.g();
        if (g != null) {
            cVar.f(20, g.intValue());
        }
        Integer z = lVar.z();
        if (z != null) {
            cVar.f(21, z.intValue());
        }
        Integer h = lVar.h();
        if (h != null) {
            cVar.f(22, h.intValue());
        }
        String l = lVar.l();
        if (l != null) {
            cVar.e(23, l);
        }
        String t = lVar.t();
        if (t != null) {
            cVar.e(24, t);
        }
    }

    /* renamed from: y0 */
    public Long v(l lVar) {
        if (lVar != null) {
            return lVar.m();
        }
        return null;
    }

    /* renamed from: z0 */
    public boolean E(l lVar) {
        return lVar.m() != null;
    }

    public NDownloadInfoDao(r.c.b.n.a aVar, e eVar) {
        super(aVar, eVar);
        this.k = eVar;
    }
}
