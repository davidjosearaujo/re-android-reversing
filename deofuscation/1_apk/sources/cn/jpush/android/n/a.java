package cn.jpush.android.n;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    public static void a(Context context, String str) {
        Logger.dd("GeoCallbackHelper", "onGeofenceReceived,geos:" + str);
        a(context, "cn.jpush.android.intent.GEO_RECEIVED", str, 0.0d, 0.0d);
    }

    public static void a(Context context, String str, double d, double d2) {
        Logger.dd("GeoCallbackHelper", "onGeofenceRegion,geo:" + str + ",lat:" + d + ",lng:" + d2);
        a(context, "cn.jpush.android.intent.GEO_REGION", str, d, d2);
    }

    public static void a(Context context, String str, String str2, double d, double d2) {
        if (context == null) {
            return;
        }
        try {
            String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
            if (TextUtils.isEmpty(messageReceiverClass)) {
                Logger.d("GeoCallbackHelper", "not found messageReceiver");
            } else {
                Intent intent = new Intent(context, Class.forName(messageReceiverClass));
                intent.setAction(str);
                intent.putExtra("geo", str2);
                intent.putExtra("geoLat", d);
                intent.putExtra("geoLng", d2);
                context.sendBroadcast(intent);
            }
        } catch (Throwable th) {
            Logger.ww("GeoCallbackHelper", "onResult error:" + th);
        }
    }
}
