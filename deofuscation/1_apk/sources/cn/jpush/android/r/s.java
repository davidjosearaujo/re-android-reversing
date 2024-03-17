package cn.jpush.android.r;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class s {
    private static List<cn.jpush.android.d.d> a = null;
    private static int b = 10;

    public static synchronized int a(Context context) {
        int size;
        synchronized (s.class) {
            if (a == null) {
                a = new LinkedList();
                ArrayList<cn.jpush.android.d.d> b2 = b(context, "notify_inapp_data");
                if (b2 != null && !b2.isEmpty()) {
                    a.addAll(b2);
                }
            }
            size = a.size();
        }
        return size;
    }

    public static synchronized void a(Context context, cn.jpush.android.d.d dVar) {
        ArrayList<cn.jpush.android.d.d> arrayList;
        boolean z;
        synchronized (s.class) {
            try {
            } finally {
            }
            if (dVar == null) {
                Logger.ww("NotifyInAppListUtils", "#unexcepted -  message is null");
                return;
            }
            int i = dVar.au;
            if (i <= 0) {
                i = 10;
            }
            b = i;
            if (a == null) {
                a = new LinkedList();
                z = true;
                arrayList = b(context, "notify_inapp_data");
                if (arrayList != null && !arrayList.isEmpty()) {
                    a.addAll(arrayList);
                }
            } else {
                arrayList = null;
                z = false;
            }
            if (a(dVar)) {
                Logger.d("NotifyInAppListUtils", "the notify message cache already, messageId: " + dVar.c);
                return;
            }
            if (a.size() >= b) {
                for (List<cn.jpush.android.d.d> list = a; list.size() >= b; list = a) {
                    a.remove(0);
                }
            }
            a.add(dVar);
            Logger.d("NotifyInAppListUtils", "notify in app cache, current size is " + a.size() + ", cache max size: " + b);
            if (!z) {
                arrayList = b(context, "notify_inapp_data");
            }
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (arrayList.size() >= b) {
                arrayList.remove(0);
            }
            arrayList.add(dVar);
            a(context, "notify_inapp_data", arrayList);
        }
    }

    private static void a(Context context, String str, ArrayList<cn.jpush.android.d.d> arrayList) {
        String str2;
        Logger.v("NotifyInAppListUtils", "Action - saveObjects");
        if (context == null) {
            str2 = "unexcepted , context is null";
        } else if (arrayList != null && arrayList.size() > 0) {
            try {
                File a2 = cn.jpush.android.ac.c.a(context, str);
                if (a2 == null) {
                    Logger.w("NotifyInAppListUtils", "file is null");
                    return;
                }
                new JSONArray();
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    cn.jpush.android.d.d dVar = arrayList.get(size);
                    if (dVar != null) {
                        if (TextUtils.isEmpty(dVar.at) || cn.jpush.android.ac.b.b(dVar.at) > System.currentTimeMillis()) {
                            arrayList2.add(0, dVar.c());
                            if (arrayList2.size() == b) {
                                Logger.d("NotifyInAppListUtils", "[saveObjects] reach max cache message count: " + b + ", drop message count: " + (arrayList.size() - b));
                                break;
                            }
                        } else {
                            Logger.dd("NotifyInAppListUtils", "message out of date, endTime: " + dVar.at);
                            cn.jpush.android.helper.c.a(dVar.c, 1603, context);
                        }
                    }
                    size--;
                }
                JSONArray jSONArray = new JSONArray((Collection) arrayList2);
                Logger.d("NotifyInAppListUtils", "save object to file, size: " + jSONArray.length());
                cn.jpush.android.ac.c.a(a2.getAbsolutePath(), jSONArray.toString());
                return;
            } catch (Throwable th) {
                Logger.ww("NotifyInAppListUtils", "save Objects  error:" + th.getMessage());
                return;
            }
        } else {
            str2 = "mObjectList is null or size is 0";
        }
        Logger.w("NotifyInAppListUtils", str2);
    }

    public static synchronized boolean a(Context context, String str) {
        boolean z;
        String str2;
        synchronized (s.class) {
            ArrayList<cn.jpush.android.d.d> arrayList = null;
            try {
                if (a == null) {
                    a = new LinkedList();
                    arrayList = b(context, "notify_inapp_data");
                    if (arrayList != null && !arrayList.isEmpty()) {
                        a.addAll(arrayList);
                    }
                    z = true;
                } else {
                    z = false;
                }
                if (a.size() <= 0) {
                    return false;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= a.size()) {
                        break;
                    }
                    cn.jpush.android.d.d dVar = a.get(i2);
                    if (dVar != null && dVar.c.equals(str)) {
                        a.remove(i2);
                        Logger.d("NotifyInAppListUtils", "cancel notify in app, delete from cache msgId: " + str);
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return false;
                }
                if (a.size() != 0) {
                    if (!z) {
                        arrayList = b(context, "notify_inapp_data");
                    }
                    if (arrayList != null && arrayList.size() >= i + 1) {
                        arrayList.remove(i);
                        if (arrayList.size() > 0) {
                            a(context, "notify_inapp_data", arrayList);
                        } else {
                            str2 = "notify_inapp_data";
                        }
                    }
                    return true;
                }
                str2 = "notify_inapp_data";
                c(context, str2);
                return true;
            } catch (Throwable th) {
                Logger.w("NotifyInAppListUtils", "get notify inapp message failed, " + th.getMessage());
                return false;
            }
        }
    }

    private static boolean a(cn.jpush.android.d.d dVar) {
        if (a.size() <= 0) {
            return false;
        }
        if (dVar == null) {
            return true;
        }
        for (cn.jpush.android.d.d dVar2 : a) {
            if (dVar2.c.equals(dVar.c)) {
                return true;
            }
        }
        return false;
    }

    public static synchronized cn.jpush.android.d.d b(Context context) {
        ArrayList<cn.jpush.android.d.d> arrayList;
        int size;
        String str;
        synchronized (s.class) {
            boolean z = false;
            cn.jpush.android.d.d dVar = null;
            try {
                if (a == null) {
                    a = new LinkedList();
                    ArrayList<cn.jpush.android.d.d> b2 = b(context, "notify_inapp_data");
                    if (b2 != null && !b2.isEmpty()) {
                        a.addAll(b2);
                    }
                    arrayList = b2;
                    z = true;
                } else {
                    arrayList = null;
                }
                size = a.size();
            } catch (Throwable th) {
                th = th;
            }
            if (size <= 0) {
                return null;
            }
            int i = size - 1;
            cn.jpush.android.d.d dVar2 = a.get(i);
            try {
                a.remove(i);
            } catch (Throwable th2) {
                th = th2;
                dVar = dVar2;
                Logger.w("NotifyInAppListUtils", "get notify inapp message failed, " + th.getMessage());
                dVar2 = dVar;
                Logger.d("NotifyInAppListUtils", "get notify in app, current size is " + a.size());
                return dVar2;
            }
            if (a.size() != 0) {
                if (!z) {
                    arrayList = b(context, "notify_inapp_data");
                }
                if (arrayList != null && arrayList.size() > 0) {
                    arrayList.remove(arrayList.size() - 1);
                    if (arrayList.size() > 0) {
                        a(context, "notify_inapp_data", arrayList);
                    } else {
                        str = "notify_inapp_data";
                    }
                }
                Logger.d("NotifyInAppListUtils", "get notify in app, current size is " + a.size());
                return dVar2;
            }
            str = "notify_inapp_data";
            c(context, str);
            Logger.d("NotifyInAppListUtils", "get notify in app, current size is " + a.size());
            return dVar2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0085, code lost:
        cn.jpush.android.helper.Logger.d("NotifyInAppListUtils", "[loadObjects] reach max cache message count: " + cn.jpush.android.r.s.b + ", drop message count: " + (r3.length() - cn.jpush.android.r.s.b));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ArrayList<cn.jpush.android.d.d> b(android.content.Context r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.r.s.b(android.content.Context, java.lang.String):java.util.ArrayList");
    }

    private static void c(Context context, String str) {
        String str2;
        if (context == null) {
            str2 = "unexcepted , context is null";
        } else {
            File a2 = cn.jpush.android.ac.c.a(context, str);
            if (a2 != null) {
                if (a2.exists()) {
                    a2.delete();
                    return;
                }
                return;
            }
            str2 = "can't get files dir";
        }
        Logger.w("NotifyInAppListUtils", str2);
    }
}
