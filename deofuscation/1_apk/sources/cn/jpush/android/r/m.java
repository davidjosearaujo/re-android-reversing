package cn.jpush.android.r;

import android.content.Context;
import cn.jpush.android.helper.Logger;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class m {
    private static Queue<cn.jpush.android.d.a> a;

    public static ArrayList<cn.jpush.android.d.a> a(Context context) {
        ArrayList<cn.jpush.android.d.a> b = b(context, "inmsg_queue_v405");
        if (b != null && b.size() > 0) {
            a(context, "inmsg_queue_v405");
        }
        return b;
    }

    private static synchronized void a(Context context, String str) {
        synchronized (m.class) {
            if (context == null) {
                Logger.w("InAppMsgQueueUtils", "unexcepted , context is null");
                return;
            }
            File filesDir = context.getFilesDir();
            if (filesDir == null) {
                Logger.w("InAppMsgQueueUtils", "can't get files dir");
                return;
            }
            File file = new File(filesDir, str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    private static synchronized void a(Context context, String str, ArrayList<cn.jpush.android.d.a> arrayList) {
        synchronized (m.class) {
            Logger.v("InAppMsgQueueUtils", "Action - saveObjects");
            if (context == null) {
                Logger.w("InAppMsgQueueUtils", "unexcepted , context is null");
            } else if (arrayList == null) {
                Logger.w("InAppMsgQueueUtils", "mObjectList is null");
            } else {
                File file = new File(context.getFilesDir(), str);
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < arrayList.size(); i++) {
                    jSONArray.put(arrayList.get(i).a());
                }
                cn.jpush.android.ac.c.a(file.getAbsolutePath(), jSONArray.toString());
            }
        }
    }

    public static boolean a(Context context, cn.jpush.android.d.a aVar, boolean z) {
        if (a == null) {
            a = new ConcurrentLinkedQueue();
            try {
                ArrayList<cn.jpush.android.d.a> b = b(context, "inmsg_queue_v405");
                if (b != null && !b.isEmpty()) {
                    Iterator<cn.jpush.android.d.a> it = b.iterator();
                    while (it.hasNext()) {
                        a.offer(it.next());
                    }
                }
            } catch (Throwable th) {
                Logger.w("InAppMsgQueueUtils", "init exposeMsgQueue failed:" + th.getMessage());
            }
        }
        if (context == null) {
            Logger.w("InAppMsgQueueUtils", "#unexcepted - context was null");
            return false;
        }
        if (aVar == null) {
            Logger.w("InAppMsgQueueUtils", "#unexcepted - entityKey was null");
        }
        if (!a.contains(aVar)) {
            if (z) {
                a.offer(aVar);
                try {
                    ArrayList<cn.jpush.android.d.a> b2 = b(context, "inmsg_queue_v405");
                    if (b2 == null) {
                        b2 = new ArrayList<>();
                    }
                    b2.add(aVar);
                    a(context, "inmsg_queue_v405", b2);
                } catch (Throwable th2) {
                    Logger.w("InAppMsgQueueUtils", "msg save in sp failed:" + th2.getMessage());
                }
            }
            return true;
        }
        if (!z) {
            a.remove(aVar);
            try {
                ArrayList<cn.jpush.android.d.a> b3 = b(context, "inmsg_queue_v405");
                if (b3 == null) {
                    b3 = new ArrayList<>();
                }
                b3.remove(aVar);
                a(context, "inmsg_queue_v405", b3);
            } catch (Throwable th3) {
                Logger.w("InAppMsgQueueUtils", "msg save in sp failed:" + th3.getMessage());
            }
            Logger.d("InAppMsgQueueUtils", "Exposed msg. remove processing - " + aVar);
        }
        return true;
    }

    private static synchronized ArrayList<cn.jpush.android.d.a> b(Context context, String str) {
        FileInputStream fileInputStream;
        Throwable th;
        synchronized (m.class) {
            FileInputStream fileInputStream2 = null;
            if (context == null) {
                Logger.w("InAppMsgQueueUtils", "unexcepted , context is null");
                return null;
            }
            ArrayList<cn.jpush.android.d.a> arrayList = new ArrayList<>();
            try {
                File file = new File(context.getFilesDir(), str);
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        JSONArray jSONArray = new JSONArray(new String(cn.jpush.android.ac.i.a((InputStream) fileInputStream)));
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(cn.jpush.android.d.a.a(jSONArray.getJSONObject(i)));
                        }
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        Logger.w("InAppMsgQueueUtils", "load objects error:" + th.getMessage());
                        a(context, str);
                        cn.jpush.android.ac.i.a((Closeable) fileInputStream);
                        return arrayList;
                    }
                }
                cn.jpush.android.ac.i.a((Closeable) fileInputStream2);
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
            return arrayList;
        }
    }
}
