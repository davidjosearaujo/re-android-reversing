package cn.jiguang.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.jiguang.ar.c;
import cn.jiguang.be.d;
import cn.jiguang.internal.JConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    private static final Map<String, SharedPreferences> a = new ConcurrentHashMap();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a {
        private static Handler a;
        private static final Object b = new Object();
        private static final LinkedList<Runnable> c = new LinkedList<>();
        private static boolean d = true;
        private static final Object e = new Object();

        /* renamed from: cn.jiguang.g.b$a$a */
        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class HandlerC0008a extends Handler {
            public HandlerC0008a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    d.a("FUTURE_TASK", new cn.jiguang.be.b() { // from class: cn.jiguang.g.b.a.a.1
                        {
                            HandlerC0008a.this = this;
                        }

                        @Override // cn.jiguang.be.b
                        public void a() {
                            a.c();
                        }
                    });
                }
            }
        }

        public static void a(Runnable runnable, boolean z) {
            try {
                Handler b2 = b();
                if (b2 != null) {
                    synchronized (b) {
                        c.add(runnable);
                        if (z && d) {
                            b2.sendEmptyMessageDelayed(1, 100L);
                        } else {
                            b2.sendEmptyMessage(1);
                        }
                    }
                }
            } catch (Throwable th) {
                c.g("Sp", "sp task add queue failed, " + th.getMessage());
            }
        }

        private static Handler b() {
            if (a == null) {
                synchronized (b) {
                    if (a == null) {
                        a = new HandlerC0008a(Looper.getMainLooper());
                    }
                }
            }
            return a;
        }

        public static void c() {
            LinkedList linkedList;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (e) {
                    synchronized (b) {
                        LinkedList<Runnable> linkedList2 = c;
                        linkedList = (LinkedList) linkedList2.clone();
                        linkedList2.clear();
                        Handler b2 = b();
                        if (b2 != null) {
                            b2.removeMessages(1);
                        }
                    }
                    if (linkedList.size() > 0) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            ((Runnable) it.next()).run();
                        }
                        if (JConstants.INTERNAL_USE && JConstants.DEBUG_MODE) {
                            c.c("Sp", "sp processing " + linkedList.size() + " items took " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                        }
                    }
                }
            } catch (Throwable th) {
                c.g("Sp", "sp commit task error, " + th.getMessage());
            }
        }
    }

    public static <T> T a(Context context, cn.jiguang.g.a<T> aVar) {
        T t = (T) b(context, aVar);
        return t != null ? t : aVar.e;
    }

    private static <T> T a(SharedPreferences sharedPreferences, String str, T t) {
        if (sharedPreferences != null && sharedPreferences.contains(str)) {
            try {
                if (t instanceof Boolean) {
                    return (T) Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) t).booleanValue()));
                }
                if (t instanceof String) {
                    return (T) sharedPreferences.getString(str, (String) t);
                }
                if (t instanceof Integer) {
                    return (T) Integer.valueOf(sharedPreferences.getInt(str, ((Integer) t).intValue()));
                }
                if (t instanceof Long) {
                    return (T) Long.valueOf(sharedPreferences.getLong(str, ((Long) t).longValue()));
                }
                if (t instanceof Float) {
                    return (T) Float.valueOf(sharedPreferences.getFloat(str, ((Float) t).floatValue()));
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(Context context, cn.jiguang.g.a<T> aVar, cn.jiguang.g.a<T> aVar2) {
        Object b;
        if (b(context, aVar) != null || (b = b(context, aVar2)) == null) {
            return;
        }
        a(context, aVar.a((cn.jiguang.g.a<T>) b));
        a(context, aVar2.a((cn.jiguang.g.a<T>) null));
    }

    public static void a(Context context, String str) {
        SharedPreferences e = e(context, str);
        if (e != null) {
            e.edit().clear().apply();
        }
    }

    private static void a(final Context context, boolean z, final cn.jiguang.g.a<?>... aVarArr) {
        try {
            cn.jiguang.be.b bVar = new cn.jiguang.be.b() { // from class: cn.jiguang.g.b.1
                @Override // cn.jiguang.be.b
                public void a() {
                    cn.jiguang.g.a[] aVarArr2;
                    SharedPreferences e;
                    try {
                        HashMap hashMap = new HashMap();
                        for (cn.jiguang.g.a aVar : aVarArr) {
                            SharedPreferences.Editor editor = (SharedPreferences.Editor) hashMap.get(aVar.c);
                            if (editor == null && (e = b.e(context, aVar.c)) != null) {
                                editor = e.edit();
                                hashMap.put(aVar.c, editor);
                            }
                            b.b(editor, aVar.d, aVar.e, aVar.g);
                        }
                        for (String str : hashMap.keySet()) {
                            SharedPreferences.Editor editor2 = (SharedPreferences.Editor) hashMap.get(str);
                            if (editor2 != null && !editor2.commit()) {
                                c.g("Sp", "sp commit failed, sp_file: " + str);
                            }
                        }
                    } catch (Throwable th) {
                        c.g("Sp", "sp commit failed, " + th.getMessage());
                    }
                }
            };
            if (z) {
                a.a(bVar, false);
            } else {
                bVar.run();
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, cn.jiguang.g.a<?>... aVarArr) {
        if (aVarArr == null || aVarArr.length <= 0) {
            return;
        }
        if (!a()) {
            b(context, aVarArr);
            return;
        }
        c.c("Sp", "main thread, async sp set");
        a(context, true, aVarArr);
    }

    private static boolean a() {
        try {
            return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
        } catch (Throwable th) {
            c.g("Sp", "[isMainThread] failed:" + th.getMessage());
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T b(Context context, cn.jiguang.g.a<T> aVar) {
        Object a2 = a(e(context, aVar.c), aVar.d, aVar.e);
        if (a2 == null && aVar.f) {
            a2 = (T) a(d(context, aVar.c), aVar.d, aVar.e);
        }
        if (a2 != null) {
            if (aVar.g && (a2 instanceof String)) {
                String str = a2;
                if (str.length() > 0) {
                    a2 = (T) cn.jiguang.bf.d.b(str);
                }
            }
            aVar.a((cn.jiguang.g.a<T>) a2);
            return (T) a2;
        }
        return null;
    }

    public static void b(Context context, cn.jiguang.g.a<?>... aVarArr) {
        if (aVarArr == null || aVarArr.length <= 0) {
            return;
        }
        a(context, false, aVarArr);
    }

    public static <T> void b(SharedPreferences.Editor editor, String str, T t, boolean z) {
        if (editor != null) {
            if (t == null) {
                editor.remove(str);
            } else if (t instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) t).booleanValue());
            } else if (t instanceof String) {
                if (z) {
                    String str2 = (String) t;
                    if (str2.length() > 0) {
                        t = (T) cn.jiguang.bf.d.a(str2);
                    }
                }
                editor.putString(str, (String) t);
            } else if (t instanceof Integer) {
                editor.putInt(str, ((Integer) t).intValue());
            } else if (t instanceof Long) {
                editor.putLong(str, ((Long) t).longValue());
            } else if (t instanceof Float) {
                editor.putFloat(str, ((Float) t).floatValue());
            }
        }
    }

    private static void c(Context context, String str) {
        cn.jiguang.g.a D;
        cn.jiguang.g.a<String> D2;
        String str2;
        cn.jiguang.g.a<String> i;
        String str3 = (String) a(context, cn.jiguang.g.a.w());
        if (TextUtils.isEmpty(str3) || str3.startsWith("1.")) {
            if (str.equals(cn.jiguang.g.a.a)) {
                a(context, cn.jiguang.g.a.i(), cn.jiguang.g.a.i().h("cn.jpush.android.user.profile"));
                a(context, cn.jiguang.g.a.j(), cn.jiguang.g.a.j().h("cn.jpush.android.user.profile"));
                D = cn.jiguang.g.a.k();
                i = cn.jiguang.g.a.k().h("cn.jpush.android.user.profile");
            } else if (str.equals("cn.jiguang.sdk.user.set.profile")) {
                a(context, cn.jiguang.g.a.l(), cn.jiguang.g.a.l().h("cn.jpush.preferences.v2"));
                D = cn.jiguang.g.a.m();
                i = cn.jiguang.g.a.m().a((cn.jiguang.g.a<String>) "cn.jpush.android.user.profile");
            } else {
                if (str.equals("cn.jiguang.sdk.user.profile")) {
                    a(context, cn.jiguang.g.a.c(), cn.jiguang.g.a.c().h("cn.jpush.android.user.profile").i("device_uid"));
                    a(context, cn.jiguang.g.a.d(), cn.jiguang.g.a.d().h("cn.jpush.android.user.profile").i("device_registration_id"));
                    D = cn.jiguang.g.a.e();
                    D2 = cn.jiguang.g.a.e().h("cn.jpush.android.user.profile");
                    str2 = "device_password";
                } else if (str.equals("cn.jiguang.sdk.address")) {
                    a(context, cn.jiguang.g.a.P(), cn.jiguang.g.a.P().h("cn.jpush.android.user.profile").i("conn"));
                    D = cn.jiguang.g.a.Q();
                    D2 = cn.jiguang.g.a.Q().h("cn.jpush.android.user.profile");
                    str2 = "srv";
                } else if (!str.equals(cn.jiguang.g.a.b)) {
                    return;
                } else {
                    a(context, cn.jiguang.g.a.C(), cn.jiguang.g.a.C().i("device_registered_appkey"));
                    D = cn.jiguang.g.a.D();
                    D2 = cn.jiguang.g.a.D();
                    str2 = "imei";
                }
                i = D2.i(str2);
            }
            a(context, D, i);
        }
    }

    private static SharedPreferences d(Context context, String str) {
        Context appContext = JConstants.getAppContext(context);
        if (appContext != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                appContext.getSharedPreferences(str, 4);
            }
            return appContext.getSharedPreferences(str, 0);
        }
        return null;
    }

    public static SharedPreferences e(Context context, String str) {
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, SharedPreferences> map = a;
        SharedPreferences sharedPreferences = map.get(str);
        if (sharedPreferences != null || (appContext = JConstants.getAppContext(context)) == null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = appContext.getSharedPreferences(str, 0);
        map.put(str, sharedPreferences2);
        c(appContext, str);
        return sharedPreferences2;
    }
}
