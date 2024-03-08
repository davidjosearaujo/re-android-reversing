package b6;

import a6.b1;
import android.os.Looper;
import f6.l;
import java.util.List;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a implements l {
    @Override // f6.l
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // f6.l
    public b1 b(List<? extends l> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new e(g.a(mainLooper));
        }
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // f6.l
    public int c() {
        return 1073741823;
    }
}
