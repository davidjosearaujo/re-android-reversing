package cn.jiguang.aa;

import android.annotation.TargetApi;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.n.d;
import cn.jpush.android.api.JThirdPlatFormInterface;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    @TargetApi(11)
    public static String a(Context context, Uri uri) {
        Bundle call;
        try {
            String g = d.g("Oi3ZFT8+schQHSyFZbsdUg==");
            if (TextUtils.isEmpty(g)) {
                return "";
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
                call = acquireUnstableContentProviderClient.call(g, null, null);
                if (acquireUnstableContentProviderClient != null) {
                    if (i >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                call = context.getContentResolver().call(uri, g, (String) null, (Bundle) null);
            }
            if (call.getInt(JThirdPlatFormInterface.KEY_CODE, -1) == 0) {
                String string = call.getString("id");
                cn.jiguang.ak.a.a("NubiaIdManager", "succeed:" + string);
                return string;
            }
            return call.getString("message");
        } catch (Exception e) {
            cn.jiguang.ak.a.d("NubiaIdManager", "get ids-o err:" + e.getMessage());
            return null;
        }
    }

    @TargetApi(11)
    public static String a(Context context, String str, Uri uri) {
        Bundle call;
        try {
            String g = d.g("cBEuCuv+AtdlTcgTe9OgSQ==");
            if (TextUtils.isEmpty(g)) {
                return "";
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
                call = acquireUnstableContentProviderClient.call(g, str, null);
                if (acquireUnstableContentProviderClient != null) {
                    if (i >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                call = context.getContentResolver().call(uri, g, str, (Bundle) null);
            }
            if (call.getInt(JThirdPlatFormInterface.KEY_CODE, -1) == 0) {
                String string = call.getString("id");
                cn.jiguang.ak.a.a("NubiaIdManager", "succeed:" + string);
                return string;
            }
            return call.getString("message");
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("NubiaIdManager", "get ids-aa err:" + th.getMessage());
            return null;
        }
    }

    @TargetApi(11)
    public static String b(Context context, String str, Uri uri) {
        Bundle bundle;
        try {
            String g = d.g("fIdCW1auJ/CZh7w78TbJVQ==");
            if (TextUtils.isEmpty(g)) {
                return "";
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
                bundle = acquireUnstableContentProviderClient.call(g, str, null);
                if (acquireUnstableContentProviderClient != null) {
                    if (i >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                context.getContentResolver().call(uri, g, str, (Bundle) null);
                bundle = null;
            }
            if (bundle.getInt(JThirdPlatFormInterface.KEY_CODE, -1) == 0) {
                String string = bundle.getString("id");
                cn.jiguang.ak.a.a("NubiaIdManager", "succeed:" + string);
                return string;
            }
            return bundle.getString("message");
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("NubiaIdManager", "get ids-va err:" + th.getMessage());
            return null;
        }
    }
}
