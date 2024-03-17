package cn.jiguang.supp;

import cn.jiguang.z.a;
import com.bun.supplier.IIdentifierListener;
import com.bun.supplier.IdSupplier;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MittIdSupplierv2 implements IIdentifierListener {
    private a mittCall;

    public MittIdSupplierv2(a aVar) {
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
