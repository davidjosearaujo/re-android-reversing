package cn.jpush.android.v;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.jpush.android.helper.Logger;
import com.huawei.hms.framework.common.ContainerUtils;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b extends e {
    private static volatile b b;
    private static final String[] a = {"_id", "ln_id", "ln_count", "ln_remove", "ln_type", "ln_extra", "ln_trigger_time", "ln_add_time"};
    private static final Object c = new Object();

    private b(Context context) {
        super(context, "jpush_local_notification.db", null, 1);
    }

    public static b a(Context context) {
        if (b == null) {
            synchronized (c) {
                if (b == null) {
                    b = new b(context.getApplicationContext());
                }
            }
        }
        return b;
    }

    public static c a(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            Logger.d("LocalNotificationDb", "cursor is null");
            return null;
        }
        try {
            c cVar = new c();
            cVar.a(cursor.getLong(1));
            cVar.a(cursor.getInt(2));
            cVar.b(cursor.getInt(3));
            cVar.c(cursor.getInt(4));
            cVar.a(cursor.getString(5));
            cVar.c(cursor.getLong(6));
            cVar.b(cursor.getLong(7));
            Logger.i("LocalNotificationDb", cVar.toString());
            return cVar;
        } catch (Exception e) {
            e.getStackTrace();
            Logger.w("LocalNotificationDb", "initLocalNotificationDBData exception:" + e.getMessage());
            return null;
        }
    }

    public int a(long j) {
        if (a(true)) {
            try {
                return getWritableDatabase().delete("t_localnotification", "ln_id=" + j, null);
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            } finally {
                b(true);
            }
        }
        return 0;
    }

    public long a(long j, int i, int i2, int i3, String str, long j2, long j3) {
        if (a(true)) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("ln_id", Long.valueOf(j));
                contentValues.put("ln_count", Integer.valueOf(i));
                contentValues.put("ln_remove", Integer.valueOf(i2));
                contentValues.put("ln_type", Integer.valueOf(i3));
                contentValues.put("ln_extra", str);
                contentValues.put("ln_trigger_time", Long.valueOf(j2));
                contentValues.put("ln_add_time", Long.valueOf(j3));
                return getWritableDatabase().insert("t_localnotification", null, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                b(true);
            }
        }
        return 0L;
    }

    public Cursor a(int i, long j) {
        try {
            return getReadableDatabase().query(true, "t_localnotification", a, "ln_count=" + i + " and ln_trigger_time<" + j, null, null, null, null, null);
        } catch (Exception e) {
            Logger.w("LocalNotificationDb", "getOutDatas exception:" + e.getMessage());
            return null;
        }
    }

    public Cursor a(long j, long j2) {
        try {
            return getReadableDatabase().query(true, "t_localnotification", a, "ln_count>0 and ln_trigger_time<" + (j2 + j) + " and ln_trigger_time>" + j, null, null, null, null, null);
        } catch (Exception e) {
            Logger.w("LocalNotificationDb", "getRtcDatas exception:" + e.getMessage());
            return null;
        }
    }

    public c a(long j, int i) {
        if (a(false)) {
            Cursor cursor = null;
            try {
                cursor = getReadableDatabase().query(true, "t_localnotification", a, "ln_id=" + j + " and ln_type" + ContainerUtils.KEY_VALUE_DELIMITER + i, null, null, null, null, null);
                if (cursor != null) {
                    cursor.moveToFirst();
                }
                return a(cursor);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
                b(false);
            }
        }
        throw new Exception("open database failed");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int[] a() {
        /*
            r13 = this;
            java.lang.String r4 = "1"
            r10 = 0
            boolean r0 = r13.a(r10)
            r11 = 0
            if (r0 == 0) goto L9d
            r12 = 1
            java.lang.String r0 = "ln_id"
            java.lang.String[] r3 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L79
            android.database.sqlite.SQLiteDatabase r0 = r13.getReadableDatabase()     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L79
            r1 = 1
            java.lang.String r2 = "t_localnotification"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L79
            if (r0 == 0) goto L46
            int r1 = r0.getCount()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            if (r1 <= 0) goto L46
            int r1 = r0.getCount()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            int[] r1 = new int[r1]     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            r0.moveToFirst()     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L6f
            r2 = 0
        L34:
            int r3 = r0.getInt(r10)     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L6f
            r1[r2] = r3     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L6f
            int r2 = r2 + 1
            boolean r3 = r0.moveToNext()     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L6f
            if (r3 != 0) goto L34
            r11 = r1
            goto L46
        L44:
            r2 = move-exception
            goto L74
        L46:
            boolean r1 = r13.a(r12)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            if (r1 == 0) goto L60
            java.lang.String r1 = "delete from t_localnotification"
            android.database.sqlite.SQLiteDatabase r2 = r13.getWritableDatabase()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5b
            r2.execSQL(r1)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5b
            r1 = 1
            goto L61
        L57:
            r1 = move-exception
            r11 = r0
            r0 = 1
            goto L8f
        L5b:
            r2 = move-exception
            r1 = r11
            r11 = r0
            r0 = 1
            goto L7c
        L60:
            r1 = 0
        L61:
            if (r0 == 0) goto L66
            r0.close()
        L66:
            r13.b(r10)
            if (r1 == 0) goto L9d
            r13.b(r12)
            goto L9d
        L6f:
            r1 = move-exception
            r11 = r0
            goto L77
        L72:
            r2 = move-exception
            r1 = r11
        L74:
            r11 = r0
            goto L7b
        L76:
            r1 = move-exception
        L77:
            r0 = 0
            goto L8f
        L79:
            r2 = move-exception
            r1 = r11
        L7b:
            r0 = 0
        L7c:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L8e
            if (r11 == 0) goto L84
            r11.close()
        L84:
            r13.b(r10)
            if (r0 == 0) goto L8c
            r13.b(r12)
        L8c:
            r11 = r1
            goto L9d
        L8e:
            r1 = move-exception
        L8f:
            if (r11 == 0) goto L94
            r11.close()
        L94:
            r13.b(r10)
            if (r0 == 0) goto L9c
            r13.b(r12)
        L9c:
            throw r1
        L9d:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.v.b.a():int[]");
    }

    public long b(long j, int i, int i2, int i3, String str, long j2, long j3) {
        if (a(true)) {
            try {
                String str2 = "ln_id=" + j;
                ContentValues contentValues = new ContentValues();
                contentValues.put("ln_id", Long.valueOf(j));
                contentValues.put("ln_count", Integer.valueOf(i));
                contentValues.put("ln_remove", Integer.valueOf(i2));
                contentValues.put("ln_type", Integer.valueOf(i3));
                contentValues.put("ln_extra", str);
                contentValues.put("ln_trigger_time", Long.valueOf(j2));
                contentValues.put("ln_add_time", Long.valueOf(j3));
                return getWritableDatabase().update("t_localnotification", contentValues, str2, null);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                b(true);
            }
        }
        return 0L;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE t_localnotification (_id INTEGER PRIMARY KEY AUTOINCREMENT ,ln_id long not null,ln_count integer not null,ln_remove integer not null,ln_type integer not null,ln_extra text ,ln_trigger_time long ,ln_add_time long );");
        } catch (Exception unused) {
            Logger.v("LocalNotificationDb", "表已经存在");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_localnotification");
        onCreate(sQLiteDatabase);
    }
}
