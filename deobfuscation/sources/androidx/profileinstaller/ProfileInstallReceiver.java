package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import androidx.profileinstaller.c;
import java.io.File;

/* loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {

    /* loaded from: classes.dex */
    public class a implements c.InterfaceC0019c {
        public a() {
            ProfileInstallReceiver.this = r1;
        }

        @Override // androidx.profileinstaller.c.InterfaceC0019c
        public final void a() {
            Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
        }

        @Override // androidx.profileinstaller.c.InterfaceC0019c
        public final void b(int i7, Object obj) {
            c.f1915b.b(i7, obj);
            ProfileInstallReceiver.this.setResultCode(i7);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            c.b(context, new k.a(1), new a(), true);
        } else if (!"androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
                Process.sendSignal(Process.myPid(), 10);
                c.f1915b.b(12, null);
                setResultCode(12);
            } else if (!"androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
            } else {
                if (!"DROP_SHADER_CACHE".equals(extras.getString("EXTRA_BENCHMARK_OPERATION"))) {
                    c.f1915b.b(16, null);
                    setResultCode(16);
                    return;
                }
                int i7 = androidx.profileinstaller.a.a(context.createDeviceProtectedStorageContext().getCodeCacheDir()) ? 14 : 15;
                c.f1915b.b(i7, null);
                setResultCode(i7);
            }
        } else {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if (!"WRITE_SKIP_FILE".equals(string)) {
                    if ("DELETE_SKIP_FILE".equals(string)) {
                        a aVar = new a();
                        new File(context.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                        new f2.a(11, 1, aVar, null).run();
                        return;
                    }
                    return;
                }
                a aVar2 = new a();
                try {
                    c.a(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                    aVar2.b(10, null);
                } catch (PackageManager.NameNotFoundException e) {
                    aVar2.b(7, e);
                }
            }
        }
    }
}
