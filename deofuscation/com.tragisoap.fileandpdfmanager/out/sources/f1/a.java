package f1;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a extends g1.a {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f4073b = 0;

    /* renamed from: f1.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0055a {
        public static void a(Activity activity) {
            activity.finishAffinity();
        }

        public static void b(Activity activity, Intent intent, int i7, Bundle bundle) {
            activity.startActivityForResult(intent, i7, bundle);
        }

        public static void c(Activity activity, IntentSender intentSender, int i7, Intent intent, int i8, int i9, int i10, Bundle bundle) {
            activity.startIntentSenderForResult(intentSender, i7, intent, i8, i9, i10, bundle);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {
        public static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        public static void b(Activity activity, String[] strArr, int i7) {
            activity.requestPermissions(strArr, i7);
        }

        public static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface c {
        void e();
    }
}
