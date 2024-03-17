package cn.jiguang.f;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@TargetApi(19)
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class e {
    private static String a;

    private static Uri a(Context context, String str, boolean z) {
        Uri uri;
        Cursor cursor = null;
        r1 = null;
        r1 = null;
        Uri uri2 = null;
        try {
            Cursor query = context.getApplicationContext().getContentResolver().query(MediaStore.Downloads.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_display_name=?", new String[]{str + ".txt"}, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        query.moveToFirst();
                        uri2 = Uri.withAppendedPath(MediaStore.Downloads.EXTERNAL_CONTENT_URI, String.valueOf(query.getInt(query.getColumnIndex("_id"))));
                        cn.jiguang.ar.c.c("MediaStoreUtils", "getUriByDownloadsMediaStore uri is " + uri2.toString());
                    } else if (z) {
                        uri2 = d(context, str);
                    }
                } catch (Throwable unused) {
                    uri = uri2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return uri;
                }
            }
            if (query != null) {
                query.close();
                return uri2;
            }
            return uri2;
        } catch (Throwable unused2) {
            uri = null;
        }
    }

    public static String a(Context context, String str) {
        Uri uri;
        InputStream inputStream;
        String str2 = "";
        if (context == null || TextUtils.isEmpty(str)) {
            cn.jiguang.ar.c.c("MediaStoreUtils", "context or fileName or content is null");
            return "";
        }
        a(context);
        String b = b(context, str);
        try {
            uri = (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) ? e(context, b) : f(context, b);
            try {
            } catch (Throwable unused) {
                inputStream = null;
            }
        } catch (Throwable unused2) {
            uri = null;
            inputStream = null;
        }
        if (uri != null) {
            inputStream = context.getApplicationContext().getContentResolver().openInputStream(uri);
            try {
            } catch (Throwable unused3) {
                if (uri != null) {
                    try {
                        cn.jiguang.ar.c.c("MediaStoreUtils", "readContentByMediaStore delete uri result is " + context.getApplicationContext().getContentResolver().delete(uri, null, null));
                    } finally {
                        i.a((Closeable) inputStream);
                    }
                }
                return str2;
            }
            if (inputStream != null) {
                str2 = c.a(inputStream);
                cn.jiguang.ar.c.c("MediaStoreUtils", "readContentByMediaStore data is " + str2);
                return str2;
            }
            throw new IOException("Failed to get input stream.");
        }
        throw new IOException("Failed to read a MediaStore record.");
    }

    private static String a(String str) {
        try {
            File file = new File(a + File.separator + str);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            return file.getAbsolutePath();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static void a(Context context) {
        StringBuilder sb;
        String str;
        if (context == null) {
            cn.jiguang.ar.c.c("MediaStoreUtils", "context is null");
        } else if (TextUtils.isEmpty(a)) {
            if (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) {
                sb = new StringBuilder();
                j.l.c.e0.a.a.b.a();
                sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
                sb.append(File.separator);
                str = ".jpush";
            } else {
                sb = new StringBuilder();
                sb.append(Environment.DIRECTORY_DOWNLOADS);
                sb.append(File.separator);
                str = "jpush";
            }
            sb.append(str);
            a = sb.toString();
        }
    }

    private static void a(Context context, Uri uri) {
        cn.jiguang.ar.c.c("MediaStoreUtils", "updatePending uri is " + uri.toString());
        try {
            ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_pending", (Integer) 0);
            contentResolver.update(uri, contentValues, null, null);
        } catch (Throwable unused) {
        }
    }

    public static boolean a(Context context, String str, String str2) {
        Uri uri;
        OutputStream outputStream;
        int i;
        boolean z = false;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            cn.jiguang.ar.c.c("MediaStoreUtils", "context or fileName or content is null");
            return false;
        }
        a(context);
        String b = b(context, str);
        try {
            i = Build.VERSION.SDK_INT;
            uri = (i < 29 || context.getApplicationInfo().targetSdkVersion < 29) ? e(context, b) : f(context, b);
            try {
            } catch (Throwable unused) {
                outputStream = null;
            }
        } catch (Throwable unused2) {
            uri = null;
            outputStream = null;
        }
        if (uri != null) {
            outputStream = context.getApplicationContext().getContentResolver().openOutputStream(uri);
            try {
            } catch (Throwable unused3) {
                if (uri != null) {
                    try {
                        cn.jiguang.ar.c.c("MediaStoreUtils", "saveFile delete uri result is " + context.getApplicationContext().getContentResolver().delete(uri, null, null));
                    } finally {
                        i.a(outputStream);
                    }
                }
                return z;
            }
            if (outputStream != null) {
                outputStream.write(str2.getBytes());
                outputStream.flush();
                cn.jiguang.ar.c.c("MediaStoreUtils", "saveFile file is " + b + " success!");
                z = true;
                if (i >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 && uri != null) {
                    a(context, uri);
                }
                return z;
            }
            throw new IOException("Failed to get output stream.");
        }
        throw new IOException("Failed to create new MediaStore record.");
    }

    private static String b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            cn.jiguang.ar.c.c("MediaStoreUtils", "context or fileName is null");
            return "";
        } else if (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) {
            return Consts.DOT + str + ".bat";
        } else {
            return str;
        }
    }

    private static Uri c(Context context, String str) {
        Uri uri = null;
        try {
            String a2 = a(str);
            ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", str);
            contentValues.put("_data", a2);
            contentValues.put("mime_type", "text/plain");
            uri = contentResolver.insert(MediaStore.Files.getContentUri("external"), contentValues);
            cn.jiguang.ar.c.c("MediaStoreUtils", "createFileByMediaFile uri is " + uri.toString());
            return uri;
        } catch (Throwable unused) {
            return uri;
        }
    }

    private static Uri d(Context context, String str) {
        Uri uri = null;
        try {
            ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", str);
            contentValues.put("mime_type", "text/plain");
            contentValues.put("relative_path", a);
            contentValues.put("is_pending", (Integer) 1);
            uri = contentResolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues);
            cn.jiguang.ar.c.c("MediaStoreUtils", "createDownloadFileByMediaStore uri is " + uri.toString());
            return uri;
        } catch (Throwable unused) {
            return uri;
        }
    }

    private static Uri e(Context context, String str) {
        Uri uri;
        Cursor cursor = null;
        r1 = null;
        Uri uri2 = null;
        try {
            Cursor query = context.getApplicationContext().getContentResolver().query(MediaStore.Files.getContentUri("external"), null, "_display_name=?", new String[]{str}, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        query.moveToFirst();
                        uri2 = Uri.withAppendedPath(MediaStore.Files.getContentUri("external"), String.valueOf(query.getInt(query.getColumnIndex("_id"))));
                        cn.jiguang.ar.c.c("MediaStoreUtils", "getUriByFileMediaStore uri is " + uri2.toString());
                    } else {
                        uri2 = c(context, str);
                    }
                } catch (Throwable unused) {
                    uri = uri2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return uri;
                }
            }
            if (query != null) {
                query.close();
                return uri2;
            }
            return uri2;
        } catch (Throwable unused2) {
            uri = null;
        }
    }

    private static Uri f(Context context, String str) {
        return a(context, str, true);
    }
}
