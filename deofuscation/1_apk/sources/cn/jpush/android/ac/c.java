package cn.jpush.android.ac;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import com.hunantv.imgo.entity.JumpAction;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    public static File a(Context context, String str) {
        File filesDir;
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            Logger.w("FileUtils", "can't get file :" + str);
            return null;
        }
        return new File(filesDir, str);
    }

    public static Object a(File file) {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        if (file == null || !file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
        } catch (Throwable th) {
            th = th;
        }
        try {
            Object readObject = objectInputStream.readObject();
            i.a((Closeable) objectInputStream);
            return readObject;
        } catch (Throwable th2) {
            th = th2;
            objectInputStream2 = objectInputStream;
            i.a((Closeable) objectInputStream2);
            throw th;
        }
    }

    public static String a(Context context, String str, int i) {
        return a(context, str, i, true);
    }

    public static String a(Context context, String str, int i, boolean z) {
        String b;
        File file = null;
        if (context == null) {
            return null;
        }
        try {
            if (a.a()) {
                String str2 = Environment.DIRECTORY_PICTURES;
                j.l.c.e0.a.a.a.c(str2);
                String absolutePath = context.getExternalFilesDir(str2).getAbsolutePath();
                StringBuilder sb = new StringBuilder();
                sb.append(absolutePath);
                String str3 = File.separator;
                sb.append(str3);
                sb.append(str);
                sb.append(str3);
                String sb2 = sb.toString();
                File file2 = new File(sb2);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                b = sb2;
                file = file2;
            } else {
                b = b(context, str + File.separator);
            }
            if (z) {
                a(context, str, i, file);
            }
            return b;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static void a(Context context, String str, int i, File file) {
        File[] listFiles;
        if (file == null) {
            file = a(context, str);
        }
        if (file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > i) {
            Arrays.sort(listFiles, new Comparator<File>() { // from class: cn.jpush.android.ac.c.1
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(File file2, File file3) {
                    if (file2.lastModified() > file3.lastModified()) {
                        return -1;
                    }
                    return file2.lastModified() < file3.lastModified() ? 1 : 0;
                }
            });
            c(listFiles[listFiles.length - 1]);
        }
    }

    public static boolean a(File file, Object obj) {
        ObjectOutputStream objectOutputStream;
        if (file == null || file.isDirectory()) {
            Logger.w("FileUtils", "file should not be null or a directory");
            return false;
        }
        ObjectOutputStream objectOutputStream2 = null;
        try {
            b(file);
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        } catch (Throwable th) {
            th = th;
        }
        try {
            objectOutputStream.writeObject(obj);
            i.a(objectOutputStream);
            return true;
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            try {
                Logger.w("FileUtils", "save to file exception:" + th + " path = " + file.getAbsolutePath());
                return false;
            } finally {
                i.a(objectOutputStream2);
            }
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new File(str).exists();
        } catch (Throwable th) {
            Logger.w("FileUtils", "FileUtils e:" + th);
            return false;
        }
    }

    public static boolean a(String str, String str2) {
        byte[] bytes;
        if (str2 != null) {
            try {
                bytes = str2.getBytes("UTF-8");
            } catch (Exception e) {
                Logger.w("FileUtils", "getBytes exception:" + e);
                return false;
            }
        } else {
            bytes = null;
        }
        return b(str, bytes);
    }

    public static boolean a(String str, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        return b(str, bArr);
    }

    public static String b(Context context, String str) {
        try {
            File a = a(context, str);
            if (a == null) {
                Logger.w("FileUtils", str + " can't be null");
                return "";
            }
            if (a.isFile()) {
                a.delete();
            }
            if (!a.exists()) {
                a.mkdirs();
            }
            return a.getAbsolutePath() + File.separator;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(JumpAction.STR_ACTION_SPLIT);
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
        }
        return str.substring(str.lastIndexOf("/") + 1);
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

    public static boolean b(String str, String str2) {
        Logger.v("FileUtils", "action:createHtmlFile - filePath:" + str + ", content:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return a(str, str2);
    }

    private static boolean b(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                b(file);
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    i.a(fileOutputStream2);
                    return true;
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    Logger.w("FileUtils", "save to file exception:" + e + " path = " + str);
                    i.a(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    i.a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static String c(Context context, String str) {
        try {
            if (!a.a()) {
                a(context, "rich", 10, (File) null);
                return b(context, "rich" + File.separator + str);
            }
            String str2 = Environment.DIRECTORY_PICTURES;
            j.l.c.e0.a.a.a.c(str2);
            String absolutePath = context.getExternalFilesDir(str2).getAbsolutePath();
            StringBuilder sb = new StringBuilder();
            sb.append(absolutePath);
            String str3 = File.separator;
            sb.append(str3);
            sb.append(str);
            sb.append(str3);
            String sb2 = sb.toString();
            File file = new File(sb2);
            if (!file.exists()) {
                file.mkdirs();
            }
            return sb2;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean c(File file) {
        try {
            if (file.exists()) {
                if (file.isFile()) {
                    return file.delete();
                }
                String[] list = file.list();
                if (list != null) {
                    for (String str : list) {
                        File file2 = new File(file, str);
                        if (file2.isDirectory()) {
                            c(file2);
                        } else {
                            file2.delete();
                        }
                    }
                }
                return file.delete();
            }
            return false;
        } catch (Exception unused) {
            Logger.e("FileUtils", "Delete dir error");
            return false;
        }
    }

    public static String d(Context context, String str) {
        try {
            if (a.a()) {
                String str2 = Environment.DIRECTORY_PICTURES;
                j.l.c.e0.a.a.a.c(str2);
                String str3 = context.getExternalFilesDir(str2).getAbsolutePath() + File.separator + str;
                if (new File(str3).exists()) {
                    return str3;
                }
                Logger.ww("FileUtils", "Can't find developer picture resource in SDCard.");
                return "";
            }
            return "";
        } catch (Throwable th) {
            Logger.ww("FileUtils", "Get developer picture resource failed.");
            th.printStackTrace();
            return "";
        }
    }
}
