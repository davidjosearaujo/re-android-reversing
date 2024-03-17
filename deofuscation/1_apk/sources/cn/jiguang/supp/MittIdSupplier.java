package cn.jiguang.supp;

import cn.jiguang.y.a;
import com.bun.miitmdid.core.IIdentifierListener;
import com.bun.miitmdid.supplier.IdSupplier;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MittIdSupplier implements IIdentifierListener {
    private a mittCall;

    public MittIdSupplier(a aVar) {
        this.mittCall = aVar;
    }

    public void OnSupport(boolean z, IdSupplier idSupplier) {
        try {
            try {
                this.mittCall.a(z, idSupplier);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            this.mittCall.a.put("");
        }
    }
}
