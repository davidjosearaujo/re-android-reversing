package androidx.profileinstaller;

import java.io.File;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {
    public static boolean a(File file) {
        if (file.isDirectory()) {
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
        file.delete();
        return true;
    }
}
