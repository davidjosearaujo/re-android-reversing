package cn.jpush.android.x;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.facebook.login.LoginStatusClient;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class i {
    public static boolean a(ArrayList<String> arrayList, Context context, String str, String str2, boolean z) {
        String str3;
        Logger.v("RichHelper", "action:loadHtmlImageResources - urlPrefix:" + str);
        if (!cn.jpush.android.ac.a.c(str) || context == null || arrayList.size() <= 0 || TextUtils.isEmpty(str2)) {
            return true;
        }
        Iterator<String> it = arrayList.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            String next = it.next();
            if (next == null || next.startsWith(JPushConstants.HTTP_PRE) || next.startsWith(JPushConstants.HTTPS_PRE)) {
                str3 = next;
            } else {
                str3 = str + next;
            }
            byte[] b = cn.jpush.android.w.a.b(str3, 5, LoginStatusClient.DEFAULT_TOAST_DURATION_MS);
            if (b != null) {
                try {
                    String str4 = "";
                    if (next.startsWith(JPushConstants.HTTP_PRE) || next.startsWith(JPushConstants.HTTPS_PRE)) {
                        str4 = next.substring(0, next.lastIndexOf("/") + 1);
                        next = cn.jpush.android.ac.c.b(next);
                    }
                    String b2 = !z ? cn.jpush.android.ac.c.b(context, str2) : cn.jpush.android.ac.c.c(context, str2);
                    if (!TextUtils.isEmpty(str4)) {
                        b2 = str4.replaceAll(str, b2);
                    }
                    String str5 = b2 + next;
                    cn.jpush.android.ac.c.a(str5, b);
                    Logger.v("RichHelper", "Succeed to load image - " + str5);
                } catch (Exception e) {
                    Logger.ww("RichHelper", "Write storage error,  create img file fail.", e);
                }
            } else {
                cn.jpush.android.helper.c.a(str2, 1020, (String) null, context);
            }
            z2 = false;
        }
        return z2;
    }
}
