package vjj.xsflifo.puoiiqxxg.fwrsd;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: FileUtils.java */
/* renamed from: vjj.xsflifo.puoiiqxxg.fwrsd.vvqguhfpd */
/* loaded from: /home/tiago/Downloads/PDF_Reader_File_Manager/other/1/classes.dex */
public class FileOperations {
    /* renamed from: ywmjritlewen */
    public static void deleteDirectoryAndSubFiles(String folderPath) {
        try {
            deleteFilesRecursively(folderPath);
            new File(folderPath).delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: pxuwnuwhlslgt */
    private static void deleteFilesRecursively(String path) {
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
                    deleteFilesRecursively(path + "/" + s);
                    deleteDirectoryAndSubFiles(path + "/" + s);
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
            Class<?> fileClass = Class.forName("java.io.File");
            Constructor<?> constructor = fileClass.getConstructor(String.class);
            Constructor<?> constructor2 = fileClass.getConstructor(String.class, String.class);
            if (path != null && path.exists()) {
                Object obj = constructor.newInstance(path.getPath());
                Method deleteMethod = fileClass.getDeclaredMethod("delete", new Class[0]);
                deleteMethod.setAccessible(true);
                String[] entries = ((File) obj).list();
                if (entries != null) {
                    for (String s : entries) {
                        Object obj2 = constructor2.newInstance(((File) obj).getPath(), s);
                        deleteMethod.invoke(obj2, new Object[0]);
                    }
                }
                deleteMethod.invoke(obj, new Object[0]);
            }
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException a) {
            a.printStackTrace();
        }
    }
}
