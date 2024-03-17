package cn.jiguang.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.LinkedList;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a implements FileFilter {
        public static final a a = new a(true, false);
        public static final a b = new a(false, true);
        private final boolean c;
        private final boolean d;
        private final String e;
        private final int f;

        public a(boolean z, boolean z2) {
            this.c = z;
            this.d = z2;
            this.e = null;
            this.f = 0;
        }

        public a(boolean z, boolean z2, String str, int i) {
            this.e = str;
            this.f = i;
            this.c = z;
            this.d = z2;
        }

        public static a a(String str) {
            return new a(false, true, str, 3);
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (!this.c || file.isFile()) {
                if (!this.d || file.isDirectory()) {
                    if (TextUtils.isEmpty(this.e)) {
                        return true;
                    }
                    int i = this.f;
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i != 4) {
                                    return false;
                                }
                                return file.getName().contains(this.e);
                            }
                            return file.getName().equals(this.e);
                        }
                        return file.getName().endsWith(this.e);
                    }
                    return file.getName().startsWith(this.e);
                }
                return false;
            }
            return false;
        }
    }

    public static File a(Context context, String str) {
        File filesDir;
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            cn.jiguang.ar.c.g("FileUtils", "can't get file :" + str);
            return null;
        }
        return new File(filesDir, str);
    }

    public static File a(File[] fileArr) {
        File file = null;
        if (fileArr != null && fileArr.length != 0) {
            for (File file2 : fileArr) {
                if (file2.lastModified() > (file != null ? file.lastModified() : 0L)) {
                    file = file2;
                }
            }
        }
        return file;
    }

    public static String a(InputStream inputStream) {
        byte[] b = b(inputStream);
        if (b == null) {
            return null;
        }
        try {
            return new String(b, "UTF-8");
        } catch (Throwable th) {
            Log.d("FileUtils", "can't encoding, give up read :" + th);
            return null;
        }
    }

    public static void a(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    file.delete();
                    cn.jiguang.ar.c.c("FileUtils", "delete File:" + file.getPath());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        return a(a(context, str), str2);
    }

    public static boolean a(File file, String str) {
        String str2;
        FileWriter fileWriter;
        if (file == null || file.isDirectory()) {
            str2 = "file should not be null or a directory";
        } else if (!TextUtils.isEmpty(str)) {
            FileWriter fileWriter2 = null;
            try {
                b(file);
                fileWriter = new FileWriter(file, true);
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileWriter.write(str);
                i.a(fileWriter);
                return true;
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                try {
                    cn.jiguang.ar.c.g("FileUtils", "append to file exception:" + th + " path = " + file.getAbsolutePath());
                    return false;
                } finally {
                    i.a(fileWriter2);
                }
            }
        } else {
            str2 = "append data should not be empty";
        }
        cn.jiguang.ar.c.g("FileUtils", str2);
        return false;
    }

    public static boolean a(File file, byte[] bArr) {
        if (file == null || file.isDirectory()) {
            cn.jiguang.ar.c.g("FileUtils", "file should not be null or a directory");
            return false;
        }
        FileOutputStream fileOutputStream = null;
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th) {
                th = th;
                try {
                    cn.jiguang.ar.c.g("FileUtils", "save to file exception:" + th + " path = " + file.getAbsolutePath());
                    return false;
                } finally {
                    i.a(fileOutputStream);
                }
            }
        }
        b(file);
        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
        try {
            fileOutputStream2.write(bArr);
            i.a(fileOutputStream2);
            return true;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = fileOutputStream2;
            cn.jiguang.ar.c.g("FileUtils", "save to file exception:" + th + " path = " + file.getAbsolutePath());
            return false;
        }
    }

    public static File[] a(File file, FileFilter... fileFilterArr) {
        if (file != null && file.exists() && file.isDirectory()) {
            if (fileFilterArr == null || fileFilterArr.length == 0 || (fileFilterArr.length == 1 && fileFilterArr[0] == null)) {
                return file.listFiles();
            }
            if (fileFilterArr.length == 1) {
                return file.listFiles(fileFilterArr[0]);
            }
            LinkedList<File> linkedList = new LinkedList();
            linkedList.add(file);
            int length = fileFilterArr.length;
            int i = 0;
            while (i < length) {
                FileFilter fileFilter = fileFilterArr[i];
                LinkedList linkedList2 = new LinkedList();
                for (File file2 : linkedList) {
                    File[] listFiles = fileFilter != null ? file2.listFiles(fileFilter) : file2.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        Collections.addAll(linkedList2, listFiles);
                    }
                }
                if (linkedList2.isEmpty()) {
                    return null;
                }
                i++;
                linkedList = linkedList2;
            }
            return (File[]) linkedList.toArray(new File[0]);
        }
        return null;
    }

    public static File[] a(String str, FileFilter... fileFilterArr) {
        try {
            return a(new File(str), fileFilterArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void b(File file) {
        if (file == null || file.exists()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    public static boolean b(File file, String str) {
        byte[] bytes;
        if (str != null) {
            try {
                bytes = str.getBytes("UTF-8");
            } catch (Throwable th) {
                cn.jiguang.ar.c.g("FileUtils", "getBytes exception:" + th);
                return false;
            }
        } else {
            bytes = null;
        }
        return a(file, bytes);
    }

    public static byte[] b(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            return i.a(inputStream);
        } catch (Throwable th) {
            Log.d("FileUtils", "can't read, give up read. e:" + th);
            return null;
        }
    }

    public static byte[] c(File file) {
        FileInputStream fileInputStream;
        if (file == null || !file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            return i.a((InputStream) fileInputStream);
        } catch (Throwable th2) {
            th = th2;
            try {
                cn.jiguang.ar.c.c("FileUtils", "can't read, give up read. e:" + th);
                return null;
            } finally {
                i.a((Closeable) fileInputStream);
            }
        }
    }

    public static String d(File file) {
        byte[] c = c(file);
        if (c == null) {
            return null;
        }
        try {
            return new String(c, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            cn.jiguang.ar.c.c("FileUtils", "can't encoding, give up read :" + e);
            return null;
        }
    }

    public static void e(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                e(file2);
                file2.delete();
            }
        }
        file.delete();
    }
}
