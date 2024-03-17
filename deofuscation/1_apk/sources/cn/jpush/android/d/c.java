package cn.jpush.android.d;

import android.content.Context;
import cn.jpush.android.ac.i;
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
public class c {
    private static Queue<a> a;

    public static synchronized void a(Context context, String str) {
        synchronized (c.class) {
            if (context == null) {
                Logger.w("MsgQueueUtils", "unexcepted , context is null");
                return;
            }
            File filesDir = context.getFilesDir();
            if (filesDir == null) {
                Logger.w("MsgQueueUtils", "can't get files dir");
                return;
            }
            File file = new File(filesDir, str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    private static synchronized void a(Context context, String str, ArrayList<a> arrayList) {
        synchronized (c.class) {
            Logger.v("MsgQueueUtils", "Action - saveObjects");
            if (context == null) {
                Logger.w("MsgQueueUtils", "unexcepted , context is null");
            } else if (arrayList == null) {
                Logger.w("MsgQueueUtils", "mObjectList is null");
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

    public static boolean a(Context context, a aVar) {
        if (a == null) {
            a = new ConcurrentLinkedQueue();
            try {
                ArrayList<a> b = b(context, "msg_queue_v350");
                if (b != null && !b.isEmpty()) {
                    Iterator<a> it = b.iterator();
                    while (it.hasNext()) {
                        a.offer(it.next());
                    }
                }
            } catch (Exception e) {
                Logger.ww("MsgQueueUtils", "init lastMsgQueue failed:" + e.getMessage());
            }
        }
        if (context == null) {
            Logger.ww("MsgQueueUtils", "#unexcepted - context was null");
            return false;
        }
        if (aVar == null) {
            Logger.ww("MsgQueueUtils", "#unexcepted - entityKey was null");
        }
        if (a.contains(aVar)) {
            Logger.e("MsgQueueUtils", "Duplicated msg. Give up processing - " + aVar);
            return true;
        }
        if (a.size() >= 200) {
            a.poll();
        }
        a.offer(aVar);
        try {
            ArrayList<a> b2 = b(context, "msg_queue_v350");
            if (b2 == null) {
                b2 = new ArrayList<>();
            }
            if (b2.size() >= 50) {
                b2.remove(0);
            }
            b2.add(aVar);
            a(context, "msg_queue_v350", b2);
        } catch (Exception e2) {
            Logger.ww("MsgQueueUtils", "msg save in sp failed:" + e2.getMessage());
        }
        return false;
    }

    private static synchronized ArrayList<a> b(Context context, String str) {
        FileInputStream fileInputStream;
        Throwable th;
        synchronized (c.class) {
            FileInputStream fileInputStream2 = null;
            if (context == null) {
                Logger.w("MsgQueueUtils", "unexcepted , context is null");
                return null;
            }
            ArrayList<a> arrayList = new ArrayList<>();
            try {
                File file = new File(context.getFilesDir(), str);
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        JSONArray jSONArray = new JSONArray(new String(i.a((InputStream) fileInputStream)));
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(a.a(jSONArray.getJSONObject(i)));
                        }
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        Logger.w("MsgQueueUtils", "load objects error:" + th.getMessage());
                        a(context, str);
                        i.a((Closeable) fileInputStream);
                        return arrayList;
                    }
                }
                i.a((Closeable) fileInputStream2);
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
            return arrayList;
        }
    }
}
