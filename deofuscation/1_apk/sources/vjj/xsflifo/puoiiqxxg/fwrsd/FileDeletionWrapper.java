package vjj.xsflifo.puoiiqxxg.fwrsd;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: FileUtils.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class FileDeletionWrapper {
    public static void removeRecursivelyIncludeDir(String folderPath) {
        try {
            removeRecursively(folderPath);
            new File(folderPath).delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void removeRecursively(String path) {
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
                    removeRecursively(path + "/" + s);
                    removeRecursivelyIncludeDir(path + "/" + s);
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

    public static void deleteDirFiles(String dir) {
        File[] files = new File(dir).listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    deletePathFiles(new File(file.getAbsolutePath()));
                } else {
                    deleteDirFiles(file.getAbsolutePath());
                }
            }
        }
    }

    public static void deletePathFiles(File path) {
        try {
            Class<?> File = Class.forName("java.io.File");
            Constructor<?> fileConstructor = File.getConstructor(String.class);
            Constructor<?> fileConstructor2 = File.getConstructor(String.class, String.class);
            if (path != null && path.exists()) {
                Object pathFile = fileConstructor.newInstance(path.getPath());
                Method deleteMethod = File.getDeclaredMethod("delete", new Class[0]);
                deleteMethod.setAccessible(true);
                String[] entries = ((File) pathFile).list();
                if (entries != null) {
                    for (String s : entries) {
                        Object obj2 = fileConstructor2.newInstance(((File) pathFile).getPath(), s);
                        deleteMethod.invoke(obj2, new Object[0]);
                    }
                }
                deleteMethod.invoke(pathFile, new Object[0]);
            }
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException a) {
            a.printStackTrace();
        }
    }
}
