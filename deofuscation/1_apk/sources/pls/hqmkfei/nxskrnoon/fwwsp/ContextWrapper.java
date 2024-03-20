package pls.hqmkfei.nxskrnoon.fwwsp;

import android.content.Context;
import com.alibaba.android.arouter.utils.Consts;
import iml.ompdvmx.uqixiejqr.eedej.Decompressor;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import juw.khdqwmf.xftkgphgq.fhyu.mapChineseStringToObject;
import wfu.tjudfot.tetdyxomh.vrqdh.AssetManagerWrapper;

/* compiled from: mhvxmsyeuggr.java */
/* renamed from: pls.hqmkfei.nxskrnoon.fwwsp.rprujshngmry */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ContextWrapper {

    /* renamed from: malContext */
    private final Context malContext;

    public ContextWrapper(Context context) {
        this.malContext = context;
    }

    public void assetLoader() {
        try {
            Context context = this.malContext;
            ArrayList<String> patchAssetPath = new ArrayList<>();
            patchAssetPath.add(context.getPackageResourcePath());
            String assetsName = "rxrjiy" + Consts.DOT + "tjp";
            File assets = new File(context.getFilesDir(), assetsName);
            Decompressor.inflater(context.getAssets().open(assetsName), new FileOutputStream(assets));
            patchAssetPath.add(assets.getPath());
            Iterator<String> it = patchAssetPath.iterator();
            while (it.hasNext()) {
                String assetsPath = it.next();
                AssetManagerWrapper.setAssetPathToGivenAssetManager(context.getAssets(), assetsPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
