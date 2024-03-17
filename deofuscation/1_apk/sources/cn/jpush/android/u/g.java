package cn.jpush.android.u;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import cn.jpush.android.ac.i;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.r.l;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class g {
    public static int a = 327938;
    private int b = 65824;

    public static int a(Context context) {
        int i = 48;
        if (context != null) {
            try {
                Resources resources = context.getResources();
                i = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
            } catch (Throwable th) {
                Logger.w("InflaterConfigModule", "get status bar height error, " + th.getMessage());
            }
        }
        Logger.d("InflaterConfigModule", "status bar height: " + i);
        return i;
    }

    public static String a(int i, int i2) {
        if (i2 == 1) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return "FLOAT_PORTRAIT";
                    }
                    return "MODAL_PORTRAIT";
                }
                return "BANNER_PORTRAIT";
            }
            return "FULL_SCREEN_PORTRAIT";
        } else if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return "FLOAT_LANDSCAPE";
                }
                return "MODAL_LANDSCAPE";
            }
            return "BANNER_LANDSCAPE";
        } else {
            return "FULL_SCREEN_LANDSCAPE";
        }
    }

    public l a(Context context, DisplayMetrics displayMetrics, e eVar) {
        if (displayMetrics == null || eVar == null) {
            Logger.d("InflaterConfigModule", "provide portrait banner layout param is null, displayMetrics: " + displayMetrics + ", appMsg: " + eVar);
            return null;
        }
        b bVar = eVar instanceof b ? (b) eVar : null;
        if (bVar == null) {
            Logger.w("InflaterConfigModule", "not banner in app message instance");
            return null;
        }
        return l.a().a(Float.valueOf(0.3f)).b(Float.valueOf(0.3f)).a(Integer.valueOf((int) (displayMetrics.heightPixels * 0.5f))).b(Integer.valueOf((int) (displayMetrics.widthPixels * 0.9f))).c(Integer.valueOf(bVar.e() == 0 ? 48 : 80)).d(Integer.valueOf(this.b)).e((Integer) (-1)).f((Integer) (-2)).e(2).f(2).a(Boolean.TRUE).b(Boolean.valueOf(bVar.c() != -1)).d(0).c(a(context)).c(Boolean.valueOf(bVar.f())).a(true).a(bVar.g()).b(bVar.h()).c(bVar.i()).a(bVar.c()).b(bVar.d()).a();
    }

    public l b(Context context, DisplayMetrics displayMetrics, e eVar) {
        if (displayMetrics == null || eVar == null) {
            Logger.d("InflaterConfigModule", "provide landscape banner layout param is null, displayMetrics: " + displayMetrics + ", appMsg: " + eVar);
            return null;
        }
        b bVar = eVar instanceof b ? (b) eVar : null;
        if (bVar == null) {
            Logger.w("InflaterConfigModule", "not banner in app message instance");
            return null;
        }
        return l.a().a(Float.valueOf(0.3f)).b(Float.valueOf(0.3f)).a(Integer.valueOf((int) (displayMetrics.heightPixels * 0.5f))).b(Integer.valueOf((int) (displayMetrics.widthPixels * 0.9f))).c(Integer.valueOf(bVar.e() == 0 ? 48 : 80)).d(Integer.valueOf(this.b)).e(Integer.valueOf(displayMetrics.heightPixels)).f((Integer) (-2)).e(20).f(20).d(0).c(a(context)).a(Boolean.TRUE).b(Boolean.valueOf(bVar.c() != -1)).c(Boolean.valueOf(bVar.f())).a(true).a(bVar.g()).b(bVar.h()).c(bVar.i()).a(bVar.c()).b(bVar.d()).a();
    }

    public l c(Context context, DisplayMetrics displayMetrics, e eVar) {
        if (displayMetrics == null || eVar == null || context == null) {
            Logger.d("InflaterConfigModule", "provide portrait float layout param is null, displayMetrics: " + displayMetrics + ", appMsg: " + eVar + ", context: " + context);
            return null;
        }
        c cVar = eVar instanceof c ? (c) eVar : null;
        if (cVar == null) {
            Logger.w("InflaterConfigModule", "not float message instance");
            return null;
        }
        int a2 = cVar.a();
        double b = cVar.b();
        int a3 = a(context);
        if (b != 0.0d) {
            double d = displayMetrics.heightPixels - a3;
            Double.isNaN(d);
            a3 = (int) (d * b);
        }
        int l = cVar.l();
        int a4 = i.a(context, l);
        int a5 = i.a(context, 6);
        Logger.d("InflaterConfigModule", "portrait float, orientation: " + a2 + ", heightPixels: " + displayMetrics.heightPixels + ", marginY: " + a3 + ", marginYPer: " + b + ", webwidth: " + l + ", pxWebWidth: " + a4 + ", marginX: " + a5);
        l.a a6 = l.a().a(Integer.valueOf((int) (((float) displayMetrics.heightPixels) * 0.2f))).b(Integer.valueOf((int) (((float) displayMetrics.widthPixels) * 0.2f))).b(Float.valueOf(0.4f)).a(Float.valueOf(0.4f)).c(Integer.valueOf(a2)).d(a5).c(a3).d(Integer.valueOf(this.b)).e(Integer.valueOf(a4)).f((Integer) (-2)).a(Boolean.TRUE);
        Boolean bool = Boolean.FALSE;
        return a6.b(bool).c(bool).a(cVar.c()).a();
    }

    public l d(Context context, DisplayMetrics displayMetrics, e eVar) {
        if (displayMetrics == null || eVar == null || context == null) {
            Logger.d("InflaterConfigModule", "provide portrait float layout param is null, displayMetrics: " + displayMetrics + ", appMsg: " + eVar + ", context: " + context);
            return null;
        }
        c cVar = eVar instanceof c ? (c) eVar : null;
        if (cVar == null) {
            Logger.w("InflaterConfigModule", "not float message instance");
            return null;
        }
        int a2 = cVar.a();
        double b = cVar.b();
        int a3 = a(context);
        if (b != 0.0d) {
            double d = displayMetrics.heightPixels - a3;
            Double.isNaN(d);
            a3 = (int) (d * b);
        }
        int l = cVar.l();
        int a4 = i.a(context, l);
        int a5 = i.a(context, 6);
        Logger.d("InflaterConfigModule", "landscape float, orientation: " + a2 + ", heightPixels: " + displayMetrics.heightPixels + ", marginY: " + a3 + ", marginYPer: " + b + ", webwidth: " + l + ", pxWebWidth: " + a4 + ", marginX: " + a5);
        l.a f = l.a().a(Integer.valueOf((int) (((float) displayMetrics.heightPixels) * 0.9f))).b(Integer.valueOf((int) (((float) displayMetrics.widthPixels) * 0.9f))).b(Float.valueOf(0.8f)).a(Float.valueOf(0.8f)).c(Integer.valueOf(a2)).d(a5).c(a3).d(Integer.valueOf(this.b)).e(Integer.valueOf(a4)).f((Integer) (-2));
        Boolean bool = Boolean.FALSE;
        return f.a(bool).b(bool).c(bool).a(cVar.c()).a();
    }

    public l e(Context context, DisplayMetrics displayMetrics, e eVar) {
        if (displayMetrics == null) {
            Logger.d("InflaterConfigModule", "provide portrait modal config displayMetrics is null");
            return null;
        }
        l.a a2 = l.a();
        double d = displayMetrics.heightPixels;
        Double.isNaN(d);
        l.a f = a2.a(Integer.valueOf((int) (d * 0.8d))).b(Integer.valueOf((int) (displayMetrics.widthPixels * 0.7f))).a(Float.valueOf(0.6f)).c(Float.valueOf(0.1f)).b(Float.valueOf(0.9f)).d(Float.valueOf(0.9f)).c((Integer) 17).d(0).c(a(context)).d(Integer.valueOf(a)).e((Integer) (-1)).f((Integer) (-1));
        Boolean bool = Boolean.FALSE;
        return f.a(bool).b(bool).c(bool).a();
    }

    public l f(Context context, DisplayMetrics displayMetrics, e eVar) {
        if (displayMetrics == null) {
            Logger.d("InflaterConfigModule", "provide landscape modal config displayMetrics is null");
            return null;
        }
        l.a a2 = l.a();
        double d = displayMetrics.heightPixels;
        Double.isNaN(d);
        l.a f = a2.a(Integer.valueOf((int) (d * 0.8d))).b(Integer.valueOf(displayMetrics.widthPixels)).a(Float.valueOf(1.0f)).b(Float.valueOf(0.4f)).c(Float.valueOf(0.6f)).d(Float.valueOf(0.4f)).c((Integer) 17).d(0).c(a(context)).d(Integer.valueOf(a)).e((Integer) (-1)).f((Integer) (-1));
        Boolean bool = Boolean.FALSE;
        return f.a(bool).b(bool).c(bool).a();
    }
}
