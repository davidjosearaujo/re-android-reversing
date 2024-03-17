package rjg.ugogehh.gxwrstviq.khhf;

import android.content.Context;
import java.io.File;

/* compiled from: ScopedStorage.java */
/* renamed from: rjg.ugogehh.gxwrstviq.khhf.guwjfornolnug */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DexDirHandler {
    /* renamed from: uppjkthuu */
    public static File getDexDir(Context context) {
        File dexDir = context.getDir("app_dex", 0);
        if (!dexDir.exists()) {
            dexDir.mkdir();
        }
        return dexDir;
    }
}
