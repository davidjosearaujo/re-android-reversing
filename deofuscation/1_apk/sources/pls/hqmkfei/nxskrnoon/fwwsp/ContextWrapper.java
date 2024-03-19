package pls.hqmkfei.nxskrnoon.fwwsp;

import android.content.Context;
import com.alibaba.android.arouter.utils.Consts;
import iml.ompdvmx.uqixiejqr.eedej.tfmrwohgt;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import juw.khdqwmf.xftkgphgq.fhyu.mapChineseStringToObject;
import wfu.tjudfot.tetdyxomh.vrqdh.AssetManagerBuilder;

/* compiled from: mhvxmsyeuggr.java */
/* renamed from: pls.hqmkfei.nxskrnoon.fwwsp.rprujshngmry */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ContextWrapper {

    /* renamed from: fnjkjldn */
    private final Context context;

    public ContextWrapper(Context context) {
        this.context = context;
    }

    public void nppijhnxmrmur() {
        try {
            Context context = this.context;
            ArrayList<String> patchAssetPath = new ArrayList<>();
            patchAssetPath.add(context.getPackageResourcePath());
            String assetsName = "rxrjiy" + Consts.DOT + "tjp";
            File assets = new File(context.getFilesDir(), assetsName);
            tfmrwohgt.pnnsiggosunnh(context.getAssets().open(assetsName), new FileOutputStream(assets));
            patchAssetPath.add(assets.getPath());
            Iterator<String> it = patchAssetPath.iterator();
            while (it.hasNext()) {
                String assetsPath = it.next();
                AssetManagerBuilder.setAssetPathToGivenAssetManager(context.getAssets(), assetsPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
