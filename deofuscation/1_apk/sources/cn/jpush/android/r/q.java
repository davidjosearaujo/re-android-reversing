package cn.jpush.android.r;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import cn.jpush.android.helper.Logger;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class q {
    private boolean a = false;
    private boolean b = false;
    private String c = "";

    private WindowManager a(Context context) {
        if (context != null) {
            return (WindowManager) context.getSystemService("window");
        }
        return null;
    }

    public int a(Context context, cn.jpush.android.s.c cVar, boolean z) {
        try {
            this.c = "";
            this.b = z;
            l f = cVar.f();
            View d = cVar.d();
            if (d != null) {
                WindowManager a = a(context);
                if (context instanceof Activity) {
                    this.c = context.getClass().getCanonicalName();
                    context = context.getApplicationContext();
                }
                if (a != null) {
                    if (!cVar.c(context)) {
                        Logger.d("InAppWindowManager", "isSameOrientation is false");
                        return 104;
                    }
                    cVar.a(context, f, z, a, d);
                    cVar.b(context);
                    cVar.a(a, context);
                    this.a = true;
                    return 0;
                }
                return 102;
            }
            return 101;
        } catch (Throwable th) {
            Logger.w("InAppWindowManager", "window manage add view failed. " + th.getMessage());
            return 103;
        }
    }

    public void a(Context context, cn.jpush.android.s.c cVar) {
        if (cVar == null || context == null) {
            return;
        }
        try {
            View d = cVar.d();
            View b = cVar.b();
            if (b != null) {
                d = b;
            }
            if (d != null) {
                WindowManager a = a(context);
                if (a(cVar) && a != null) {
                    a.removeViewImmediate(d);
                    this.a = false;
                }
                cVar.a();
            }
            this.c = "";
        } catch (Throwable th) {
            Logger.w("InAppWindowManager", "[destroy]  removeViewImmediate view from window error. " + th.getMessage());
        }
    }

    public boolean a() {
        return this.b;
    }

    public boolean a(cn.jpush.android.s.c cVar) {
        if (cVar == null || cVar.d() == null) {
            return false;
        }
        boolean isShown = cVar.d().isShown();
        Logger.d("InAppWindowManager", "webview is displayed, status: " + isShown + ", isDisplayed: " + this.a);
        return isShown && this.a;
    }

    public boolean a(String str) {
        Logger.d("InAppWindowManager", "[checkShouldDestroy] drawlay: " + this.b + ", showActivityName: " + this.c + ", curActivityName: " + str);
        return !this.b && b(str);
    }

    public boolean b(cn.jpush.android.s.c cVar) {
        return (cVar == null || cVar.d() == null) ? false : true;
    }

    public boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.equals(this.c);
    }
}
