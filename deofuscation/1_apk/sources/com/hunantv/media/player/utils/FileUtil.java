package com.hunantv.media.player.utils;

import android.content.Context;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class FileUtil {
    public static void close(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static boolean copyAssertThrow(Context context, String str, String str2) throws IOException {
        Throwable th;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        if (context == null || StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            inputStream = context.getAssets().open(str);
            try {
                File file = new File(str2);
                deleteFile(file);
                mkdirs(file.getParentFile());
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    close(inputStream);
                    close(fileOutputStream);
                    return true;
                }
                fileOutputStream.write(bArr, 0, read);
                fileOutputStream.flush();
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream2 = fileOutputStream;
            close(inputStream);
            close(fileOutputStream2);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.Closeable, java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.Closeable] */
    private static boolean copyFile(File file, File file2) {
        ?? name;
        Throwable th;
        FileOutputStream fileOutputStream;
        IOException e;
        Object obj;
        FileNotFoundException e2;
        Object obj2;
        if (file2.exists()) {
            if (file2.isDirectory()) {
                name = file.getName();
                file2 = new File(file2, (String) name);
            }
        } else if (!mkdirs(file2.getParentFile()) || !createNewFile(file2)) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                name = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (FileNotFoundException e3) {
                    e2 = e3;
                    obj2 = name;
                } catch (IOException e4) {
                    e = e4;
                    obj = name;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    fileOutputStream2 = name;
                    close(fileOutputStream);
                    close(fileOutputStream2);
                    throw th;
                }
                try {
                    FileChannel channel = name.getChannel();
                    FileChannel channel2 = fileOutputStream.getChannel();
                    channel2.transferFrom(channel, 0L, channel.size());
                    close(channel);
                    close(channel2);
                    close(fileOutputStream);
                    close(name);
                    return true;
                } catch (FileNotFoundException e5) {
                    e2 = e5;
                    fileOutputStream2 = fileOutputStream;
                    obj2 = name;
                    e2.printStackTrace();
                    name = obj2;
                    close(fileOutputStream2);
                    close(name);
                    return false;
                } catch (IOException e6) {
                    e = e6;
                    fileOutputStream2 = fileOutputStream;
                    obj = name;
                    e.printStackTrace();
                    name = obj;
                    close(fileOutputStream2);
                    close(name);
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream2 = name;
                    close(fileOutputStream);
                    close(fileOutputStream2);
                    throw th;
                }
            } catch (FileNotFoundException e7) {
                e2 = e7;
                obj2 = null;
            } catch (IOException e8) {
                e = e8;
                obj = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                close(fileOutputStream);
                close(fileOutputStream2);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static boolean createNewFile(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (!file.createNewFile()) {
                if (!file.isFile()) {
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteDir(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!deleteDir(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean deleteDir(String str) {
        if (StringUtil.isEmpty(str)) {
            return false;
        }
        try {
            return deleteDir(new File(str));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteFile(File file) {
        if (file == null) {
            return false;
        }
        return file.delete();
    }

    public static boolean exist(String str) {
        if (str == null) {
            return false;
        }
        try {
            return new File(str).exists();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String[] list(File file, final String str) {
        if (file == null) {
            return null;
        }
        try {
            return str == null ? file.list() : file.list(new FilenameFilter() { // from class: com.hunantv.media.player.utils.FileUtil.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str2) {
                    if (str2 != null) {
                        return str2.endsWith(str);
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int listCount(File file, String str) {
        String[] list = list(file, str);
        if (list != null) {
            return list.length;
        }
        return 0;
    }

    public static boolean mkdirs(File file) {
        if (file == null) {
            return false;
        }
        return file.mkdirs() || file.isDirectory();
    }

    public static boolean mkdirs(String str) {
        return mkdirs(new File(str));
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0035: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:20:0x0035 */
    public static String read(String str) {
        InputStreamReader inputStreamReader;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                char[] cArr = new char[1024];
                StringBuffer stringBuffer = new StringBuffer();
                inputStreamReader = new InputStreamReader(new FileInputStream(str));
                while (true) {
                    try {
                        int read = inputStreamReader.read(cArr);
                        if (read < 0) {
                            String stringBuffer2 = stringBuffer.toString();
                            close(inputStreamReader);
                            return stringBuffer2;
                        }
                        stringBuffer.append(cArr, 0, read);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        close(inputStreamReader);
                        return null;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                inputStreamReader = null;
            } catch (Throwable th) {
                th = th;
                close(closeable2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            close(closeable2);
            throw th;
        }
    }

    public static String readAssert(Context context, String str) {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2 = null;
        if (context == null) {
            return null;
        }
        try {
            char[] cArr = new char[1024];
            StringBuffer stringBuffer = new StringBuffer();
            inputStreamReader = new InputStreamReader(context.getAssets().open(str));
            while (true) {
                try {
                    try {
                        int read = inputStreamReader.read(cArr);
                        if (read < 0) {
                            String stringBuffer2 = stringBuffer.toString();
                            close(inputStreamReader);
                            return stringBuffer2;
                        }
                        stringBuffer.append(cArr, 0, read);
                    } catch (Throwable th) {
                        th = th;
                        inputStreamReader2 = inputStreamReader;
                        close(inputStreamReader2);
                        throw th;
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    close(inputStreamReader);
                    return null;
                }
            }
        } catch (Exception e2) {
            e = e2;
            inputStreamReader = null;
        } catch (Throwable th2) {
            th = th2;
            close(inputStreamReader2);
            throw th;
        }
    }

    public static byte[] readBytes(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (inputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            close(byteArrayOutputStream2);
            throw th;
        }
        try {
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read < 0) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        close(byteArrayOutputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream2 = byteArrayOutputStream;
                close(byteArrayOutputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            close(byteArrayOutputStream);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    public static byte[] readBytes(String str) {
        Exception e;
        FileInputStream fileInputStream;
        ?? r0 = 0;
        try {
            try {
                File file = new File(str);
                if (file.length() >= 2147483647L) {
                    close(null);
                    return null;
                }
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] readBytes = readBytes(fileInputStream);
                    close(fileInputStream);
                    return readBytes;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    close(fileInputStream);
                    return null;
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                close(r0);
                throw th;
            }
        } catch (Throwable th2) {
            r0 = str;
            th = th2;
            close(r0);
            throw th;
        }
    }

    public static boolean remkdirs(String str) {
        deleteDir(str);
        return mkdirs(str) && exist(str);
    }
}
