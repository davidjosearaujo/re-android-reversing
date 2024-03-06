package pls.hqmkfei.nxskrnoon.fwwsp;

import android.content.Context;
import com.alibaba.android.arouter.utils.Consts;
import iml.ompdvmx.uqixiejqr.eedej.tfmrwohgt;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import juw.khdqwmf.xftkgphgq.fhyu.ChineseObfuscatedPackageNames;
import wfu.tjudfot.tetdyxomh.vrqdh.AssetManager;

/* compiled from: mhvxmsyeuggr.java */
/* renamed from: pls.hqmkfei.nxskrnoon.fwwsp.rprujshngmry */
/* loaded from: /home/tiago/Downloads/PDF_Reader_File_Manager/other/1/classes.dex */
public class setContext {

    /* renamed from: fnjkjldn */
    private final Context context;

    public setContext(Context context) {
        this.context = context;
    }

    public void nppijhnxmrmur() {
        try {
            Context context = this.context;
            ArrayList<String> patchAssetPath = new ArrayList<>();
            patchAssetPath.add(context.getPackageResourcePath());
            String assetsName = ChineseObfuscatedPackageNames.ifqsrmoxkldsotk + Consts.DOT + ChineseObfuscatedPackageNames.rytluexmqwrmyvnlrle;
            File assets = new File(context.getFilesDir(), assetsName);
            tfmrwohgt.pnnsiggosunnh(context.getAssets().open(assetsName), new FileOutputStream(assets));
            patchAssetPath.add(assets.getPath());
            Iterator<String> it = patchAssetPath.iterator();
            while (it.hasNext()) {
                String assetsPath = it.next();
                AssetManager.kivrflkqjwpdouen(context.getAssets(), assetsPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
