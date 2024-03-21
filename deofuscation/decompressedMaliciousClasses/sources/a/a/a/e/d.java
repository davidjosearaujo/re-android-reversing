package a.a.a.e;

import a.a.a.e.c;
import android.annotation.TargetApi;
import android.view.LayoutInflater;
@TargetApi(21)
/* loaded from: /home/remnux/decompressedMalicious.dex */
class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LayoutInflater layoutInflater, e eVar) {
        layoutInflater.setFactory2(eVar != null ? new c.a(eVar) : null);
    }
}
