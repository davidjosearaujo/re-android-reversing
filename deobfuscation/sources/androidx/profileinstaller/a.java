package androidx.profileinstaller;

import java.io.File;

/* loaded from: classes.dex */
public final class a {
    public static boolean a(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        boolean z6 = true;
        for (File file2 : listFiles) {
            z6 = a(file2) && z6;
        }
        return z6;
    }
}
