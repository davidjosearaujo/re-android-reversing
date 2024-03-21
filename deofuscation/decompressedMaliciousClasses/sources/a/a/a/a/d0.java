package a.a.a.a;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@TargetApi(9)
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class d0 {
    private static short[] $ = {4039, 4049, 4032, 4088, 4053, 4032, 4049, 4039, 4032, 4081, 4034, 4049, 4058, 4032, 4093, 4058, 4050, 4059};

    /* renamed from: a */
    private static Method f12a;

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static abstract class a {
        public abstract PendingIntent a();

        public abstract boolean b();

        public abstract Bundle c();

        public abstract int d();

        public abstract l0[] e();

        public abstract CharSequence f();
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static Notification a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        if (f12a == null) {
            try {
                f12a = Notification.class.getMethod($(0, 18, 4020), Context.class, CharSequence.class, CharSequence.class, PendingIntent.class);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            f12a.invoke(notification, context, charSequence, charSequence2, pendingIntent);
            notification.fullScreenIntent = pendingIntent2;
            return notification;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }
}
