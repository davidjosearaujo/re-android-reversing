package cn.jpush.android.x;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.SchedulerReceiver;
import cn.jpush.android.x.c;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class f {
    private static volatile f a;
    private LinkedList<a> b;
    private LinkedList<a> c;
    private final Comparator<a> d = new Comparator<a>() { // from class: cn.jpush.android.x.f.1
        {
            f.this = this;
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            if (aVar.a < aVar2.a) {
                return -1;
            }
            return aVar.a == aVar2.a ? 0 : 1;
        }
    };

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a {
        private long a;
        private boolean b;
        private cn.jpush.android.d.d c;
        private int d;
        private boolean e;

        public a(long j, int i) {
            this.a = j;
            this.b = false;
            this.d = i;
        }

        public a(long j, cn.jpush.android.d.d dVar, boolean z) {
            this.a = j;
            this.b = true;
            this.c = dVar;
            this.e = z;
        }

        public a(JSONObject jSONObject) {
            try {
                this.a = jSONObject.getLong("operationTime");
                this.b = jSONObject.optBoolean("showOrDismiss");
                String optString = jSONObject.optString("pushEntity");
                if (!TextUtils.isEmpty(optString)) {
                    this.c = cn.jpush.android.d.d.a(optString);
                }
                this.d = jSONObject.optInt(RemoteMessageConst.Notification.NOTIFY_ID);
            } catch (Throwable unused) {
            }
        }

        public JSONObject a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("operationTime", this.a);
                jSONObject.put("showOrDismiss", this.b);
                if (this.b) {
                    cn.jpush.android.d.d dVar = this.c;
                    jSONObject.put("pushEntity", dVar != null ? dVar.c() : null);
                } else {
                    jSONObject.put(RemoteMessageConst.Notification.NOTIFY_ID, this.d);
                }
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }

        public String toString() {
            return "Item{operationTime=" + this.a + ", showOrDismiss=" + this.b + ", pushEntity=" + this.c + ", notifyId=" + this.d + ", isDelayByInapp=" + this.e + '}';
        }
    }

    private f() {
    }

    public static f a() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        return a;
    }

    private static void a(Context context, LinkedList<a> linkedList, long j, a aVar) {
        if (aVar == null) {
            return;
        }
        if (aVar.a > j) {
            linkedList.add(aVar);
        } else if (!aVar.b) {
            Logger.d("NotificationScheduler", "cancelNotification:" + aVar);
            c.d(context, aVar.d);
        } else if (aVar.c != null && e.a(context, aVar.c.c, aVar.c.g)) {
            Logger.d("NotificationScheduler", "item: " + aVar + " already cancel");
        } else {
            long b = cn.jpush.android.ac.b.b(aVar.c.as);
            int a2 = c.a(aVar.c);
            if (b <= 0) {
                Logger.d("NotificationScheduler", "handleNotification:" + aVar);
                c.a.a(context, aVar.c);
            } else if (b <= j) {
                Logger.d("NotificationScheduler", "cancelNotification:" + aVar);
                c.d(context, a2);
            } else {
                Logger.d("NotificationScheduler", "handleNotification:" + aVar);
                c.a.a(context, aVar.c);
                linkedList.add(new a(b, a2));
            }
        }
    }

    private void b(Context context, a aVar) {
        try {
            Logger.d("NotificationScheduler", "schedule item=" + aVar);
            Intent intent = new Intent(context, SchedulerReceiver.class);
            intent.setAction(SchedulerReceiver.DELAY_NOTIFY);
            PendingIntent b = j.l.c.e0.a.a.d.b(context, 1000, intent, 67108864);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager != null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    alarmManager.setWindow(0, aVar.a, 300L, b);
                } else {
                    alarmManager.set(0, aVar.a, b);
                }
                Logger.d("NotificationScheduler", "setAlarm at=" + cn.jpush.android.ac.b.a("yyyy-MM-dd HH:mm:ss").format(new Date(aVar.a)));
            }
        } catch (Throwable th) {
            Logger.ww("NotificationScheduler", "can't trigger alarm cause by exception:" + th);
        }
    }

    public void a(Context context) {
        this.b = new LinkedList<>();
        if (this.c == null) {
            this.c = new LinkedList<>();
        }
        String str = (String) Sp.get(context, Key.NotiSchedule());
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.b.add(new a(jSONArray.getJSONObject(i)));
                }
            } catch (Throwable unused) {
            }
        }
        if (this.c.size() > 0) {
            this.b.addAll(this.c);
            this.c.clear();
            Collections.sort(this.b, this.d);
        }
    }

    public synchronized void a(Context context, a aVar) {
        a(context);
        LinkedList<a> linkedList = new LinkedList<>();
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = aVar != null;
        Iterator<a> it = this.b.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (z && next.a > aVar.a) {
                a(context, linkedList, currentTimeMillis, aVar);
                z = false;
            }
            a(context, linkedList, currentTimeMillis, next);
        }
        if (z) {
            a(context, linkedList, currentTimeMillis, aVar);
        }
        this.b = linkedList;
        b(context);
        if (!linkedList.isEmpty()) {
            b(context, linkedList.getFirst());
        }
    }

    public void b(Context context) {
        LinkedList<a> linkedList = this.b;
        if (linkedList == null || linkedList.isEmpty()) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<a> it = this.b.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.e) {
                this.c.add(next);
            } else {
                jSONArray.put(next.a());
            }
        }
        String jSONArray2 = jSONArray.toString();
        Collections.sort(this.b, this.d);
        Sp.set(context, Key.NotiSchedule().set(jSONArray2));
    }
}
