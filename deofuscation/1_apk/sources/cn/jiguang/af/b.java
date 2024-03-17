package cn.jiguang.af;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import cn.jiguang.af.c;
import cn.jiguang.n.d;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    public Context a;
    public String b = d.g("7vqR3nNqKoDAlUrx74tE1g==");
    public final LinkedBlockingQueue<IBinder> c = new LinkedBlockingQueue<>(1);
    public ServiceConnection d = new ServiceConnection() { // from class: cn.jiguang.af.b.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b.this.c.put(iBinder);
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("MsaOpenIDHelper", "linkedBlockingQueue error: " + th.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public b(Context context) {
        this.a = context;
    }

    private void a(String str) {
        Intent intent = new Intent();
        intent.setClassName(this.b, d.g("dYE0CPNDFJTaYbJHvdYTELPkLL9xmlHysh4O1rCwUiLYHLJ6VxirNHcrSo3Xn2UJ"));
        intent.setAction(d.g("AdKS/+o+CvOMDbvCnPWRYS8wCU0Ooy6tyMT0tXjLMUvWRKeDq6D985Ar35mAOPu+"));
        intent.putExtra(d.g("iCmt493CpcicRY98bz8pUhEUlhy7cl4p/yoqnN2nlNM="), str);
        try {
            intent.putExtra(d.g("iCmt493CpcicRY98bz8pUjI+wbDT5u8oLPJxFa2B2Zg="), true);
            if (this.a.startService(intent) != null) {
            }
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("MsaOpenIDHelper", "startMsaklServer error: " + th.getMessage());
        }
    }

    public String a() {
        try {
            this.a.getPackageManager().getPackageInfo(this.b, 0);
            String packageName = this.a.getPackageName();
            a(packageName);
            Intent intent = new Intent();
            intent.setClassName(this.b, d.g("dYE0CPNDFJTaYbJHvdYTEBK/MhYfAvKlbba3ZFsuZ+on9OG47ABUmhfzcQhqhJOU"));
            intent.setAction(d.g("AdKS/+o+CvOMDbvCnPWRYUnA2ZKRLZpCerAAd95VliYNvOuVTnj4/o7GUNhJXhWl"));
            intent.putExtra(d.g("iCmt493CpcicRY98bz8pUhEUlhy7cl4p/yoqnN2nlNM="), packageName);
            if (this.a.bindService(intent, this.d, 1)) {
                try {
                    c.a.C0002a c0002a = new c.a.C0002a(this.c.take());
                    String a = c0002a.a();
                    c0002a.b();
                    this.a.unbindService(this.d);
                    return a;
                } catch (Throwable th) {
                    try {
                        cn.jiguang.ak.a.d("MsaOpenIDHelper", "getOAID error: " + th.getMessage());
                    } finally {
                        this.a.unbindService(this.d);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }
}
