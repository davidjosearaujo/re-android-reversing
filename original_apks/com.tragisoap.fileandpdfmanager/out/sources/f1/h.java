package f1;

import android.app.NotificationManager;
import android.content.Context;
import java.util.HashSet;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final NotificationManager f4090a;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {
        public static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }

        public static int b(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }
    }

    static {
        new HashSet();
    }

    public h(Context context) {
        this.f4090a = (NotificationManager) context.getSystemService("notification");
    }
}
