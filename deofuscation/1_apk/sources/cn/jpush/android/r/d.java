package cn.jpush.android.r;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.u.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    private static int a = -1;
    private static int b = -1;
    private static cn.jpush.android.u.a c;

    private static float a(List<List<a.b.C0019a>> list) {
        float f = 0.0f;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                for (a.b.C0019a c0019a : list.get(i)) {
                    if ("translationY".equals(c0019a.a)) {
                        for (Float f2 : c0019a.b) {
                            if (f2.floatValue() > f) {
                                f = f2.floatValue();
                            }
                        }
                    }
                }
            }
        }
        return f;
    }

    private static int a(Context context, float f) {
        d(context);
        int i = (int) ((a * f) / 100.0f);
        Logger.d("InAppAniConfigUtils", "getW proportion:" + f + ",w:" + i);
        return i;
    }

    private static cn.jpush.android.u.a a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            Logger.d("InAppAniConfigUtils", "dataJson: " + jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("in_app_banner");
            if (optJSONObject != null) {
                return cn.jpush.android.u.a.a().a(optJSONObject.optString("shake")).b(optJSONObject.optString("animator")).c(optJSONObject.optString("container")).d(optJSONObject.optString("h5_extras")).a();
            }
            return null;
        } catch (Throwable th) {
            Logger.w("InAppAniConfigUtils", "build animator config failed, " + th.getMessage());
            return null;
        }
    }

    public static List<Long> a(Context context) {
        cn.jpush.android.u.a e = e(context);
        return e == null ? new ArrayList() : e.b;
    }

    public static List<List<a.b.C0019a>> a(Context context, boolean z) {
        a.b bVar;
        List<List<a.b.C0019a>> arrayList = new ArrayList<>();
        cn.jpush.android.u.a e = e(context);
        if (e != null && (bVar = e.c) != null) {
            if (z) {
                a.b.C0020b c0020b = bVar.a;
                if (c0020b != null) {
                    arrayList = c0020b.a;
                }
            } else {
                a.b.C0020b c0020b2 = bVar.b;
                if (c0020b2 != null) {
                    arrayList = c0020b2.a;
                }
            }
        }
        Logger.d("InAppAniConfigUtils", "landscape:" + z);
        Logger.d("InAppAniConfigUtils", "getAnimatorShow:" + arrayList);
        return arrayList == null ? new ArrayList() : arrayList;
    }

    private static float b(List<List<a.b.C0019a>> list) {
        List<Float> list2;
        float f = 0.0f;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                for (a.b.C0019a c0019a : list.get(i)) {
                    if ("translationY".equals(c0019a.a) && (list2 = c0019a.b) != null && list2.size() > 0) {
                        f = list2.get(list2.size() - 1).floatValue();
                    }
                }
            }
        }
        return f;
    }

    public static List<List<a.b.C0019a>> b(Context context, boolean z) {
        a.b bVar;
        List<List<a.b.C0019a>> arrayList = new ArrayList<>();
        cn.jpush.android.u.a e = e(context);
        if (e != null && (bVar = e.c) != null) {
            if (z) {
                a.b.C0020b c0020b = bVar.a;
                if (c0020b != null) {
                    arrayList = c0020b.b;
                }
            } else {
                a.b.C0020b c0020b2 = bVar.b;
                if (c0020b2 != null) {
                    arrayList = c0020b2.b;
                }
            }
        }
        Logger.d("InAppAniConfigUtils", "landscape:" + z);
        Logger.d("InAppAniConfigUtils", "getAnimatorHide:" + arrayList);
        return arrayList == null ? new ArrayList() : arrayList;
    }

    public static JSONObject b(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (e(context) != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("w", g(context, true));
                jSONObject2.put("h", h(context, true));
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("w", g(context, false));
                jSONObject3.put("h", h(context, false));
                jSONObject.put("landscape", jSONObject2);
                jSONObject.put("portrait", jSONObject3);
            }
            Logger.d("InAppAniConfigUtils", "containerJSON:" + jSONObject.toString());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static int c(Context context, boolean z) {
        return h(context, z) + a(context, a(a(context, z)));
    }

    public static String c(Context context) {
        cn.jpush.android.u.a e = e(context);
        return e == null ? "" : e.e;
    }

    public static int d(Context context, boolean z) {
        return h(context, z) + a(context, a(b(context, z)));
    }

    private static void d(Context context) {
        DisplayMetrics a2 = cn.jpush.android.ac.i.a(context);
        a = a2.widthPixels;
        b = a2.heightPixels;
        Logger.d("InAppAniConfigUtils", "initScreen screenW:" + a + ",screenH:" + b);
        StringBuilder sb = new StringBuilder();
        sb.append("initScreen metrics:");
        sb.append(a2);
        Logger.d("InAppAniConfigUtils", sb.toString());
    }

    public static int e(Context context, boolean z) {
        return h(context, z) + a(context, b(a(context, z)));
    }

    private static cn.jpush.android.u.a e(Context context) {
        if (c == null) {
            cn.jpush.android.u.a a2 = a(cn.jpush.android.t.a.a().a(context));
            if (a2 == null) {
                a2 = a(cn.jpush.android.u.a.a);
            }
            c = a2;
        }
        return c;
    }

    public static int f(Context context, boolean z) {
        return h(context, z) + a(context, b(b(context, z)));
    }

    public static int g(Context context, boolean z) {
        a.c cVar;
        cn.jpush.android.u.a e = e(context);
        float f = 0.0f;
        if (e != null && (cVar = e.d) != null) {
            if (z) {
                a.c.C0021a c0021a = cVar.a;
                if (c0021a != null) {
                    f = c0021a.a;
                }
            } else {
                a.c.C0021a c0021a2 = cVar.b;
                if (c0021a2 != null) {
                    f = c0021a2.a;
                }
            }
        }
        return a(context, f);
    }

    public static int h(Context context, boolean z) {
        a.c cVar;
        cn.jpush.android.u.a e = e(context);
        float f = 0.0f;
        if (e != null && (cVar = e.d) != null) {
            if (z) {
                a.c.C0021a c0021a = cVar.a;
                if (c0021a != null) {
                    f = c0021a.b;
                }
            } else {
                a.c.C0021a c0021a2 = cVar.b;
                if (c0021a2 != null) {
                    f = c0021a2.b;
                }
            }
        }
        Logger.e("InAppAniConfigUtils", "getContainerHeight proportionH:" + f);
        return a(context, f);
    }
}
