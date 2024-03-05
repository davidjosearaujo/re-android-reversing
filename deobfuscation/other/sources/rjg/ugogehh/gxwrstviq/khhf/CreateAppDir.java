package rjg.ugogehh.gxwrstviq.khhf;

import android.content.Context;
import java.io.File;

/* compiled from: ScopedStorage.java */
/* renamed from: rjg.ugogehh.gxwrstviq.khhf.guwjfornolnug */
/* loaded from: /home/tiago/Downloads/PDF_Reader_File_Manager/other/1/classes.dex */
public class CreateAppDir {
    /* renamed from: uppjkthuu */
    public static File createAppDir(Context context) {
        File dexDir = context.getDir("app_dex", 0);
        if (!dexDir.exists()) {
            dexDir.mkdir();
        }
        return dexDir;
    }
}
