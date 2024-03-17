package cn.jiguang.y;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.supp.MittIdSupplier;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.supplier.IdSupplier;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a implements Callable<String> {
    public final LinkedBlockingQueue<String> a = new LinkedBlockingQueue<>(1);
    private Context b;

    public a(Context context) {
        this.b = context;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public String call() {
        try {
            int InitSdk = MdidSdkHelper.InitSdk(this.b, false, new MittIdSupplier(this));
            return (InitSdk == 0 || InitSdk == 1008614) ? this.a.take() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public void a(boolean z, IdSupplier idSupplier) {
        try {
            try {
                if (idSupplier == null) {
                    this.a.put("");
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                String oaid = idSupplier.getOAID();
                String vaid = idSupplier.getVAID();
                String aaid = idSupplier.getAAID();
                if (!TextUtils.isEmpty(oaid)) {
                    jSONObject.put("oaid", oaid);
                }
                if (!TextUtils.isEmpty(vaid)) {
                    jSONObject.put("vaid", vaid);
                }
                if (!TextUtils.isEmpty(aaid)) {
                    jSONObject.put("aaid", aaid);
                }
                this.a.put(jSONObject.toString());
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            this.a.put("");
        }
    }
}
