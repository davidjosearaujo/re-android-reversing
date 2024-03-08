package vie.dwhyiud.voxxndgyo.sooyh;

import android.content.Context;
import android.os.Build;
import com.alibaba.android.arouter.utils.Consts;
import eeu.wuekite.ptluwwjmt.ypxjt.MethodClassWrapper;
import iml.ompdvmx.uqixiejqr.eedej.tfmrwohgt;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import juw.khdqwmf.xftkgphgq.fhyu.ChineseObfuscatedPackageNames;
import rjg.ugogehh.gxwrstviq.khhf.CreateAppDir;
import vjj.xsflifo.puoiiqxxg.fwrsd.FileOperations;

/* compiled from: DexLoader.java */
/* loaded from: /home/tiago/Downloads/PDF_Reader_File_Manager/other/1/classes.dex */
public class ojomviuts {
    private static Context fnjkjldn;
    private static final List<File> qrdokyjoi = new ArrayList();

    public ojomviuts(Context context) {
        fnjkjldn = context;
        File dexDir = CreateAppDir.createAppDir(context);
        FileOperations.eflsjgjvfon(dexDir.getAbsolutePath());
        FileOperations.mkdir(dexDir.getAbsolutePath());
    }

    public void ylnvvxuduw() {
        try {
            Context context = fnjkjldn;
            String[] fileList = context.getAssets().list(ChineseObfuscatedPackageNames.erslvlhdhwyiqi);
            File dexDir = CreateAppDir.createAppDir(context);
            for (String dexName : fileList) {
                if (dexName.endsWith(Consts.DOT + ChineseObfuscatedPackageNames.odvoepqvervhrhwpxpun)) {
                    File file = new File(dexDir, dexName);
                    try {
                        tfmrwohgt.pnnsiggosunnh(context.getAssets().open(ChineseObfuscatedPackageNames.erslvlhdhwyiqi + "/" + dexName), new FileOutputStream(file));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    qrdokyjoi.add(file);
                }
            }
            oirwivs(dexDir);
            FileOperations.ugdltjshfkm(dexDir);
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

    private void oirwivs(File versionDir) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method makeDexElements;
        Class<?> componentType;
        Context context = fnjkjldn;
        ClassLoader classLoader = context.getClassLoader();
        Field pathListField = MethodClassWrapper.wvtnrjvsu(classLoader, "pathList");
        Object pathList = pathListField.get(classLoader);
        if (pathList != null) {
            Field dexElementsField = MethodClassWrapper.wvtnrjvsu(pathList, "dexElements");
            Object[] dexElements = (Object[]) dexElementsField.get(pathList);
            if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 23) {
                makeDexElements = MethodClassWrapper.setBaseMethodAcessible(pathList, "makeDexElements", ArrayList.class, File.class, ArrayList.class);
            } else if (Build.VERSION.SDK_INT < 23) {
                return;
            } else {
                makeDexElements = MethodClassWrapper.setBaseMethodAcessible(pathList, "makePathElements", List.class, File.class, List.class);
            }
            ArrayList<IOException> suppressedExceptions = new ArrayList<>();
            Object[] addElements = (Object[]) makeDexElements.invoke(pathList, qrdokyjoi, versionDir, suppressedExceptions);
            if (dexElements != null && addElements != null && (componentType = dexElements.getClass().getComponentType()) != null) {
                Object[] newElements = (Object[]) Array.newInstance(componentType, dexElements.length + addElements.length);
                System.arraycopy(dexElements, 0, newElements, 0, dexElements.length);
                System.arraycopy(addElements, 0, newElements, dexElements.length, addElements.length);
                dexElementsField.set(pathList, newElements);
            }
        }
    }
}
