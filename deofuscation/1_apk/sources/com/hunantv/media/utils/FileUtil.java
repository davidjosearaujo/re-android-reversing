package com.hunantv.media.utils;

import c.a.a.b.d.e;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class FileUtil {
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
            return str == null ? file.list() : file.list(new FilenameFilter() { // from class: com.hunantv.media.utils.FileUtil.1
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
        if (StringUtil.isSpace(str)) {
            return false;
        }
        return mkdirs(new File(str));
    }

    public static byte[] readFile(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file != null) {
            try {
                if (file.length() > 0) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        try {
                            int length = (int) file.length();
                            byte[] bArr = new byte[length];
                            int i = 0;
                            while (true) {
                                int read = fileInputStream.read(bArr, i, length - i);
                                if (read == -1 || i >= length) {
                                    break;
                                }
                                i += read;
                            }
                            e.a(fileInputStream);
                            return bArr;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream2 = fileInputStream;
                            e.a(fileInputStream2);
                            throw th;
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        e.a(fileInputStream);
                        return null;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                e.a(fileInputStream2);
                throw th;
            }
        }
        e.a((Closeable) null);
        return null;
    }

    public static boolean remkdirs(String str) {
        deleteDir(str);
        return mkdirs(str) && exist(str);
    }
}
