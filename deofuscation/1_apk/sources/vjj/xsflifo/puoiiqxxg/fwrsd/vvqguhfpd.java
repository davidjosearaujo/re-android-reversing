package vjj.xsflifo.puoiiqxxg.fwrsd;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: FileUtils.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class vvqguhfpd {
    public static void ywmjritlewen(String folderPath) {
        try {
            pxuwnuwhlslgt(folderPath);
            new File(folderPath).delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void pxuwnuwhlslgt(String path) {
        File temp;
        String[] tempList = new File(path).list();
        if (tempList != null) {
            for (String s : tempList) {
                if (path.endsWith(File.separator)) {
                    temp = new File(path + s);
                } else {
                    temp = new File(path + File.separator + s);
                }
                if (temp.isFile()) {
                    temp.delete();
                }
                if (temp.isDirectory()) {
                    pxuwnuwhlslgt(path + "/" + s);
                    ywmjritlewen(path + "/" + s);
                }
            }
        }
    }

    public static void mkdir(String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void eflsjgjvfon(String dir) {
        File[] files = new File(dir).listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    ugdltjshfkm(new File(file.getAbsolutePath()));
                } else {
                    eflsjgjvfon(file.getAbsolutePath());
                }
            }
        }
    }

    public static void ugdltjshfkm(File path) {
        try {
            Class<?> main = Class.forName("java.io.File");
            Constructor<?> constructor = main.getConstructor(String.class);
            Constructor<?> constructor2 = main.getConstructor(String.class, String.class);
            if (path != null && path.exists()) {
                Object obj = constructor.newInstance(path.getPath());
                Method method = main.getDeclaredMethod("delete", new Class[0]);
                method.setAccessible(true);
                String[] entries = ((File) obj).list();
                if (entries != null) {
                    for (String s : entries) {
                        Object obj2 = constructor2.newInstance(((File) obj).getPath(), s);
                        method.invoke(obj2, new Object[0]);
                    }
                }
                method.invoke(obj, new Object[0]);
            }
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException a) {
            a.printStackTrace();
        }
    }
}
