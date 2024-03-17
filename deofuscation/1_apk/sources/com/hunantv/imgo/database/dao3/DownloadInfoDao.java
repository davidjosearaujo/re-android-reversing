package com.hunantv.imgo.database.dao3;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.facebook.share.internal.ShareConstants;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import j.l.a.i.e.e;
import j.l.a.i.e.f;
import r.c.b.a;
import r.c.b.h;
import r.c.b.l.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DownloadInfoDao extends a<f, Long> {
    public static final String TABLENAME = "DOWNLOAD_INFO";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Properties {
        public static final h a = new h(0, Long.class, "id", true, "_id");
        public static final h b = new h(1, Integer.class, "videoId", false, "VIDEO_ID");
        public static final h c = new h(2, String.class, "image", false, ShareConstants.IMAGE_URL);
        public static final h d = new h(3, String.class, "name", false, "NAME");
        public static final h e = new h(4, String.class, "videoUrl", false, "VIDEO_URL");
        public static final h f = new h(5, String.class, "filePath", false, "FILE_PATH");
        public static final h g = new h(6, Long.class, "completeSize", false, "COMPLETE_SIZE");
        public static final h h = new h(7, Long.class, "totalSize", false, "TOTAL_SIZE");
        public static final h i = new h(8, Integer.class, "status", false, CommonConstant.RETKEY.STATUS);
        public static final h j = new h(9, Long.class, "operateTime", false, "OPERATE_TIME");
        public static final h k = new h(10, Integer.class, "speed", false, "SPEED");
        public static final h l = new h(11, String.class, "idc", false, "IDC");
        public static final h m = new h(12, String.class, "nid", false, "NID");
        public static final h n = new h(13, String.class, "domains", false, "DOMAINS");
        public static final h o = new h(14, Integer.class, "rootId", false, "ROOT_ID");
        public static final h p = new h(15, Integer.class, "collectionId", false, "COLLECTION_ID");
        public static final h q = new h(16, String.class, "collectionName", false, "COLLECTION_NAME");
        public static final h r = new h(17, String.class, "collectionImage", false, "COLLECTION_IMAGE");
        public static final h s = new h(18, String.class, "clipId", false, "CLIP_ID");
        public static final h t = new h(19, String.class, "plId", false, "PL_ID");
        public static final h u = new h(20, Integer.class, "dataType", false, "DATA_TYPE");
        public static final h v = new h(21, Integer.class, "videoIndex", false, "VIDEO_INDEX");
        public static final h w = new h(22, Integer.class, "definition", false, "DEFINITION");
        public static final h x = new h(23, String.class, "freeUrl", false, "FREEURL");
        public static final h y = new h(24, String.class, "seriesId", false, "SERIESID");
        public static final h z = new h(25, String.class, "fileSize", false, "FILE_SIZE");
        public static final h A = new h(26, String.class, "playPriority", false, "PLAY_PRIORITY");
        public static final h B = new h(27, String.class, "fileMD5", false, "FILE_MD5");
        public static final h C = new h(28, String.class, "nname", false, "NNAME");
        public static final h D = new h(29, String.class, "ntitle", false, "NTITLE");
        public static final h E = new h(30, String.class, "fname", false, "FNAME");
        public static final h F = new h(31, String.class, "ndesc", false, "NDESC");
        public static final h G = new h(32, Integer.class, "mediaType", false, "MEDIA_TYPE");
        public static final h H = new h(33, String.class, "fileID", false, "FILE_ID");
        public static final h I = new h(34, Integer.class, "duration", false, "DURATION");
        public static final h J = new h(35, Integer.class, "watchTime", false, "WATCH_TIME");
        public static final h K = new h(36, String.class, "fileMD5Calc", false, "FILE_MD5_CAL");
        public static final h L = new h(37, String.class, "sdkVersion", false, "SDK_VERSION");
        public static final h M = new h(38, String.class, "definitionName", false, "DEFINITION_NAME");
        public static final h N = new h(39, Integer.class, "screenMode", false, "SCREEN_MODE");
    }

    public DownloadInfoDao(r.c.b.n.a aVar) {
        super(aVar);
    }

    public static void x0(r.c.b.l.a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        aVar.b("CREATE TABLE " + str + "\"DOWNLOAD_INFO\" (\"_id\" INTEGER PRIMARY KEY ,\"VIDEO_ID\" INTEGER,\"IMAGE\" TEXT,\"NAME\" TEXT,\"VIDEO_URL\" TEXT,\"FILE_PATH\" TEXT,\"COMPLETE_SIZE\" INTEGER,\"TOTAL_SIZE\" INTEGER,\"STATUS\" INTEGER,\"OPERATE_TIME\" INTEGER,\"SPEED\" INTEGER,\"IDC\" TEXT,\"NID\" TEXT,\"DOMAINS\" TEXT,\"ROOT_ID\" INTEGER,\"COLLECTION_ID\" INTEGER,\"COLLECTION_NAME\" TEXT,\"COLLECTION_IMAGE\" TEXT,\"CLIP_ID\" TEXT,\"PL_ID\" TEXT,\"DATA_TYPE\" INTEGER,\"VIDEO_INDEX\" INTEGER,\"DEFINITION\" INTEGER,\"FREEURL\" TEXT,\"SERIESID\" TEXT,\"FILE_SIZE\" TEXT,\"PLAY_PRIORITY\" TEXT,\"FILE_MD5\" TEXT,\"NNAME\" TEXT,\"NTITLE\" TEXT,\"FNAME\" TEXT,\"NDESC\" TEXT,\"MEDIA_TYPE\" INTEGER,\"FILE_ID\" TEXT,\"DURATION\" INTEGER,\"WATCH_TIME\" INTEGER,\"FILE_MD5_CAL\" TEXT,\"SDK_VERSION\" TEXT,\"DEFINITION_NAME\" TEXT,\"SCREEN_MODE\" INTEGER);");
    }

    public static void y0(r.c.b.l.a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"DOWNLOAD_INFO\"");
        aVar.b(sb.toString());
    }

    /* renamed from: A0 */
    public boolean E(f fVar) {
        return fVar.r() != null;
    }

    /* renamed from: B0 */
    public f f0(Cursor cursor, int i) {
        int i2 = i + 0;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        Integer valueOf2 = cursor.isNull(i3) ? null : Integer.valueOf(cursor.getInt(i3));
        int i4 = i + 2;
        String string = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 3;
        String string2 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 4;
        String string3 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 5;
        String string4 = cursor.isNull(i7) ? null : cursor.getString(i7);
        int i8 = i + 6;
        Long valueOf3 = cursor.isNull(i8) ? null : Long.valueOf(cursor.getLong(i8));
        int i9 = i + 7;
        Long valueOf4 = cursor.isNull(i9) ? null : Long.valueOf(cursor.getLong(i9));
        int i10 = i + 8;
        Integer valueOf5 = cursor.isNull(i10) ? null : Integer.valueOf(cursor.getInt(i10));
        int i11 = i + 9;
        Long valueOf6 = cursor.isNull(i11) ? null : Long.valueOf(cursor.getLong(i11));
        int i12 = i + 10;
        Integer valueOf7 = cursor.isNull(i12) ? null : Integer.valueOf(cursor.getInt(i12));
        int i13 = i + 11;
        String string5 = cursor.isNull(i13) ? null : cursor.getString(i13);
        int i14 = i + 12;
        String string6 = cursor.isNull(i14) ? null : cursor.getString(i14);
        int i15 = i + 13;
        String string7 = cursor.isNull(i15) ? null : cursor.getString(i15);
        int i16 = i + 14;
        Integer valueOf8 = cursor.isNull(i16) ? null : Integer.valueOf(cursor.getInt(i16));
        int i17 = i + 15;
        Integer valueOf9 = cursor.isNull(i17) ? null : Integer.valueOf(cursor.getInt(i17));
        int i18 = i + 16;
        String string8 = cursor.isNull(i18) ? null : cursor.getString(i18);
        int i19 = i + 17;
        String string9 = cursor.isNull(i19) ? null : cursor.getString(i19);
        int i20 = i + 18;
        String string10 = cursor.isNull(i20) ? null : cursor.getString(i20);
        int i21 = i + 19;
        String string11 = cursor.isNull(i21) ? null : cursor.getString(i21);
        int i22 = i + 20;
        Integer valueOf10 = cursor.isNull(i22) ? null : Integer.valueOf(cursor.getInt(i22));
        int i23 = i + 21;
        Integer valueOf11 = cursor.isNull(i23) ? null : Integer.valueOf(cursor.getInt(i23));
        int i24 = i + 22;
        Integer valueOf12 = cursor.isNull(i24) ? null : Integer.valueOf(cursor.getInt(i24));
        int i25 = i + 23;
        String string12 = cursor.isNull(i25) ? null : cursor.getString(i25);
        int i26 = i + 24;
        String string13 = cursor.isNull(i26) ? null : cursor.getString(i26);
        int i27 = i + 25;
        String string14 = cursor.isNull(i27) ? null : cursor.getString(i27);
        int i28 = i + 26;
        String string15 = cursor.isNull(i28) ? null : cursor.getString(i28);
        int i29 = i + 27;
        String string16 = cursor.isNull(i29) ? null : cursor.getString(i29);
        int i30 = i + 28;
        String string17 = cursor.isNull(i30) ? null : cursor.getString(i30);
        int i31 = i + 29;
        String string18 = cursor.isNull(i31) ? null : cursor.getString(i31);
        int i32 = i + 30;
        String string19 = cursor.isNull(i32) ? null : cursor.getString(i32);
        int i33 = i + 31;
        String string20 = cursor.isNull(i33) ? null : cursor.getString(i33);
        int i34 = i + 32;
        Integer valueOf13 = cursor.isNull(i34) ? null : Integer.valueOf(cursor.getInt(i34));
        int i35 = i + 33;
        String string21 = cursor.isNull(i35) ? null : cursor.getString(i35);
        int i36 = i + 34;
        Integer valueOf14 = cursor.isNull(i36) ? null : Integer.valueOf(cursor.getInt(i36));
        int i37 = i + 35;
        Integer valueOf15 = cursor.isNull(i37) ? null : Integer.valueOf(cursor.getInt(i37));
        int i38 = i + 36;
        String string22 = cursor.isNull(i38) ? null : cursor.getString(i38);
        int i39 = i + 37;
        String string23 = cursor.isNull(i39) ? null : cursor.getString(i39);
        int i40 = i + 38;
        String string24 = cursor.isNull(i40) ? null : cursor.getString(i40);
        int i41 = i + 39;
        return new f(valueOf, valueOf2, string, string2, string3, string4, valueOf3, valueOf4, valueOf5, valueOf6, valueOf7, string5, string6, string7, valueOf8, valueOf9, string8, string9, string10, string11, valueOf10, valueOf11, valueOf12, string12, string13, string14, string15, string16, string17, string18, string19, string20, valueOf13, string21, valueOf14, valueOf15, string22, string23, string24, cursor.isNull(i41) ? null : Integer.valueOf(cursor.getInt(i41)));
    }

    /* renamed from: C0 */
    public void g0(Cursor cursor, f fVar, int i) {
        int i2 = i + 0;
        fVar.k0(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        fVar.D0(cursor.isNull(i3) ? null : Integer.valueOf(cursor.getInt(i3)));
        int i4 = i + 2;
        fVar.m0(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 3;
        fVar.o0(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 4;
        fVar.F0(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 5;
        fVar.g0(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 6;
        fVar.X(cursor.isNull(i8) ? null : Long.valueOf(cursor.getLong(i8)));
        int i9 = i + 7;
        fVar.C0(cursor.isNull(i9) ? null : Long.valueOf(cursor.getLong(i9)));
        int i10 = i + 8;
        fVar.B0(cursor.isNull(i10) ? null : Integer.valueOf(cursor.getInt(i10)));
        int i11 = i + 9;
        fVar.t0(cursor.isNull(i11) ? null : Long.valueOf(cursor.getLong(i11)));
        int i12 = i + 10;
        fVar.A0(cursor.isNull(i12) ? null : Integer.valueOf(cursor.getInt(i12)));
        int i13 = i + 11;
        fVar.l0(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i + 12;
        fVar.q0(cursor.isNull(i14) ? null : cursor.getString(i14));
        int i15 = i + 13;
        fVar.b0(cursor.isNull(i15) ? null : cursor.getString(i15));
        int i16 = i + 14;
        fVar.w0(cursor.isNull(i16) ? null : Integer.valueOf(cursor.getInt(i16)));
        int i17 = i + 15;
        fVar.U(cursor.isNull(i17) ? null : Integer.valueOf(cursor.getInt(i17)));
        int i18 = i + 16;
        fVar.W(cursor.isNull(i18) ? null : cursor.getString(i18));
        int i19 = i + 17;
        fVar.V(cursor.isNull(i19) ? null : cursor.getString(i19));
        int i20 = i + 18;
        fVar.T(cursor.isNull(i20) ? null : cursor.getString(i20));
        int i21 = i + 19;
        fVar.u0(cursor.isNull(i21) ? null : cursor.getString(i21));
        int i22 = i + 20;
        fVar.Y(cursor.isNull(i22) ? null : Integer.valueOf(cursor.getInt(i22)));
        int i23 = i + 21;
        fVar.E0(cursor.isNull(i23) ? null : Integer.valueOf(cursor.getInt(i23)));
        int i24 = i + 22;
        fVar.Z(cursor.isNull(i24) ? null : Integer.valueOf(cursor.getInt(i24)));
        int i25 = i + 23;
        fVar.j0(cursor.isNull(i25) ? null : cursor.getString(i25));
        int i26 = i + 24;
        fVar.z0(cursor.isNull(i26) ? null : cursor.getString(i26));
        int i27 = i + 25;
        fVar.h0(cursor.isNull(i27) ? null : cursor.getString(i27));
        int i28 = i + 26;
        fVar.v0(cursor.isNull(i28) ? null : cursor.getString(i28));
        int i29 = i + 27;
        fVar.e0(cursor.isNull(i29) ? null : cursor.getString(i29));
        int i30 = i + 28;
        fVar.r0(cursor.isNull(i30) ? null : cursor.getString(i30));
        int i31 = i + 29;
        fVar.s0(cursor.isNull(i31) ? null : cursor.getString(i31));
        int i32 = i + 30;
        fVar.i0(cursor.isNull(i32) ? null : cursor.getString(i32));
        int i33 = i + 31;
        fVar.p0(cursor.isNull(i33) ? null : cursor.getString(i33));
        int i34 = i + 32;
        fVar.n0(cursor.isNull(i34) ? null : Integer.valueOf(cursor.getInt(i34)));
        int i35 = i + 33;
        fVar.d0(cursor.isNull(i35) ? null : cursor.getString(i35));
        int i36 = i + 34;
        fVar.c0(cursor.isNull(i36) ? null : Integer.valueOf(cursor.getInt(i36)));
        int i37 = i + 35;
        fVar.H0(cursor.isNull(i37) ? null : Integer.valueOf(cursor.getInt(i37)));
        int i38 = i + 36;
        fVar.f0(cursor.isNull(i38) ? null : cursor.getString(i38));
        int i39 = i + 37;
        fVar.y0(cursor.isNull(i39) ? null : cursor.getString(i39));
        int i40 = i + 38;
        fVar.a0(cursor.isNull(i40) ? null : cursor.getString(i40));
        int i41 = i + 39;
        fVar.x0(cursor.isNull(i41) ? null : Integer.valueOf(cursor.getInt(i41)));
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
    public final Long t0(f fVar, long j) {
        fVar.k0(Long.valueOf(j));
        return Long.valueOf(j);
    }

    public final boolean P() {
        return true;
    }

    /* renamed from: v0 */
    public final void d(SQLiteStatement sQLiteStatement, f fVar) {
        sQLiteStatement.clearBindings();
        Long r = fVar.r();
        if (r != null) {
            sQLiteStatement.bindLong(1, r.longValue());
        }
        Integer L = fVar.L();
        if (L != null) {
            sQLiteStatement.bindLong(2, L.intValue());
        }
        String t = fVar.t();
        if (t != null) {
            sQLiteStatement.bindString(3, t);
        }
        String v = fVar.v();
        if (v != null) {
            sQLiteStatement.bindString(4, v);
        }
        String N = fVar.N();
        if (N != null) {
            sQLiteStatement.bindString(5, N);
        }
        String n = fVar.n();
        if (n != null) {
            sQLiteStatement.bindString(6, n);
        }
        Long e = fVar.e();
        if (e != null) {
            sQLiteStatement.bindLong(7, e.longValue());
        }
        Long K = fVar.K();
        if (K != null) {
            sQLiteStatement.bindLong(8, K.longValue());
        }
        Integer J = fVar.J();
        if (J != null) {
            sQLiteStatement.bindLong(9, J.intValue());
        }
        Long A = fVar.A();
        if (A != null) {
            sQLiteStatement.bindLong(10, A.longValue());
        }
        Integer H = fVar.H();
        if (H != null) {
            sQLiteStatement.bindLong(11, H.intValue());
        }
        String s = fVar.s();
        if (s != null) {
            sQLiteStatement.bindString(12, s);
        }
        String x = fVar.x();
        if (x != null) {
            sQLiteStatement.bindString(13, x);
        }
        String i = fVar.i();
        if (i != null) {
            sQLiteStatement.bindString(14, i);
        }
        Integer D = fVar.D();
        if (D != null) {
            sQLiteStatement.bindLong(15, D.intValue());
        }
        Integer b = fVar.b();
        if (b != null) {
            sQLiteStatement.bindLong(16, b.intValue());
        }
        String d = fVar.d();
        if (d != null) {
            sQLiteStatement.bindString(17, d);
        }
        String c = fVar.c();
        if (c != null) {
            sQLiteStatement.bindString(18, c);
        }
        String a = fVar.a();
        if (a != null) {
            sQLiteStatement.bindString(19, a);
        }
        String B = fVar.B();
        if (B != null) {
            sQLiteStatement.bindString(20, B);
        }
        Integer f = fVar.f();
        if (f != null) {
            sQLiteStatement.bindLong(21, f.intValue());
        }
        Integer M = fVar.M();
        if (M != null) {
            sQLiteStatement.bindLong(22, M.intValue());
        }
        Integer g = fVar.g();
        if (g != null) {
            sQLiteStatement.bindLong(23, g.intValue());
        }
        String q = fVar.q();
        if (q != null) {
            sQLiteStatement.bindString(24, q);
        }
        String G = fVar.G();
        if (G != null) {
            sQLiteStatement.bindString(25, G);
        }
        String o = fVar.o();
        if (o != null) {
            sQLiteStatement.bindString(26, o);
        }
        String C = fVar.C();
        if (C != null) {
            sQLiteStatement.bindString(27, C);
        }
        String l = fVar.l();
        if (l != null) {
            sQLiteStatement.bindString(28, l);
        }
        String y = fVar.y();
        if (y != null) {
            sQLiteStatement.bindString(29, y);
        }
        String z = fVar.z();
        if (z != null) {
            sQLiteStatement.bindString(30, z);
        }
        String p = fVar.p();
        if (p != null) {
            sQLiteStatement.bindString(31, p);
        }
        String w = fVar.w();
        if (w != null) {
            sQLiteStatement.bindString(32, w);
        }
        Integer u = fVar.u();
        if (u != null) {
            sQLiteStatement.bindLong(33, u.intValue());
        }
        String k = fVar.k();
        if (k != null) {
            sQLiteStatement.bindString(34, k);
        }
        Integer j = fVar.j();
        if (j != null) {
            sQLiteStatement.bindLong(35, j.intValue());
        }
        Integer P = fVar.P();
        if (P != null) {
            sQLiteStatement.bindLong(36, P.intValue());
        }
        String m = fVar.m();
        if (m != null) {
            sQLiteStatement.bindString(37, m);
        }
        String F = fVar.F();
        if (F != null) {
            sQLiteStatement.bindString(38, F);
        }
        String h = fVar.h();
        if (h != null) {
            sQLiteStatement.bindString(39, h);
        }
        Integer E = fVar.E();
        if (E != null) {
            sQLiteStatement.bindLong(40, E.intValue());
        }
    }

    /* renamed from: w0 */
    public final void e(c cVar, f fVar) {
        cVar.i();
        Long r = fVar.r();
        if (r != null) {
            cVar.f(1, r.longValue());
        }
        Integer L = fVar.L();
        if (L != null) {
            cVar.f(2, L.intValue());
        }
        String t = fVar.t();
        if (t != null) {
            cVar.e(3, t);
        }
        String v = fVar.v();
        if (v != null) {
            cVar.e(4, v);
        }
        String N = fVar.N();
        if (N != null) {
            cVar.e(5, N);
        }
        String n = fVar.n();
        if (n != null) {
            cVar.e(6, n);
        }
        Long e = fVar.e();
        if (e != null) {
            cVar.f(7, e.longValue());
        }
        Long K = fVar.K();
        if (K != null) {
            cVar.f(8, K.longValue());
        }
        Integer J = fVar.J();
        if (J != null) {
            cVar.f(9, J.intValue());
        }
        Long A = fVar.A();
        if (A != null) {
            cVar.f(10, A.longValue());
        }
        Integer H = fVar.H();
        if (H != null) {
            cVar.f(11, H.intValue());
        }
        String s = fVar.s();
        if (s != null) {
            cVar.e(12, s);
        }
        String x = fVar.x();
        if (x != null) {
            cVar.e(13, x);
        }
        String i = fVar.i();
        if (i != null) {
            cVar.e(14, i);
        }
        Integer D = fVar.D();
        if (D != null) {
            cVar.f(15, D.intValue());
        }
        Integer b = fVar.b();
        if (b != null) {
            cVar.f(16, b.intValue());
        }
        String d = fVar.d();
        if (d != null) {
            cVar.e(17, d);
        }
        String c = fVar.c();
        if (c != null) {
            cVar.e(18, c);
        }
        String a = fVar.a();
        if (a != null) {
            cVar.e(19, a);
        }
        String B = fVar.B();
        if (B != null) {
            cVar.e(20, B);
        }
        Integer f = fVar.f();
        if (f != null) {
            cVar.f(21, f.intValue());
        }
        Integer M = fVar.M();
        if (M != null) {
            cVar.f(22, M.intValue());
        }
        Integer g = fVar.g();
        if (g != null) {
            cVar.f(23, g.intValue());
        }
        String q = fVar.q();
        if (q != null) {
            cVar.e(24, q);
        }
        String G = fVar.G();
        if (G != null) {
            cVar.e(25, G);
        }
        String o = fVar.o();
        if (o != null) {
            cVar.e(26, o);
        }
        String C = fVar.C();
        if (C != null) {
            cVar.e(27, C);
        }
        String l = fVar.l();
        if (l != null) {
            cVar.e(28, l);
        }
        String y = fVar.y();
        if (y != null) {
            cVar.e(29, y);
        }
        String z = fVar.z();
        if (z != null) {
            cVar.e(30, z);
        }
        String p = fVar.p();
        if (p != null) {
            cVar.e(31, p);
        }
        String w = fVar.w();
        if (w != null) {
            cVar.e(32, w);
        }
        Integer u = fVar.u();
        if (u != null) {
            cVar.f(33, u.intValue());
        }
        String k = fVar.k();
        if (k != null) {
            cVar.e(34, k);
        }
        Integer j = fVar.j();
        if (j != null) {
            cVar.f(35, j.intValue());
        }
        Integer P = fVar.P();
        if (P != null) {
            cVar.f(36, P.intValue());
        }
        String m = fVar.m();
        if (m != null) {
            cVar.e(37, m);
        }
        String F = fVar.F();
        if (F != null) {
            cVar.e(38, F);
        }
        String h = fVar.h();
        if (h != null) {
            cVar.e(39, h);
        }
        Integer E = fVar.E();
        if (E != null) {
            cVar.f(40, E.intValue());
        }
    }

    /* renamed from: z0 */
    public Long v(f fVar) {
        if (fVar != null) {
            return fVar.r();
        }
        return null;
    }

    public DownloadInfoDao(r.c.b.n.a aVar, e eVar) {
        super(aVar, eVar);
    }
}
