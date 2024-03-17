package cn.jiguang.ax;

import android.content.Context;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class e {
    public static Object a(Context context, String str, Object obj) {
        try {
            return cn.jiguang.i.b.a(context, str, obj);
        } catch (Throwable th) {
            cn.jiguang.ar.c.h("JCommonPresenter", "jcommon call failed:" + th.getMessage());
            return null;
        }
    }
}
