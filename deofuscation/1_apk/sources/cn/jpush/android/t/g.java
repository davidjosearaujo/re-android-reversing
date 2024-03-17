package cn.jpush.android.t;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.jpush.android.helper.Logger;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class g {
    private static volatile g a;
    private static final Object b = new Object();
    private boolean c = false;
    private ConcurrentHashMap<Integer, f> d = new ConcurrentHashMap<>();
    private Handler e;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends Handler {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper) {
            super(looper);
            g.this = r1;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                f fVar = (f) g.this.d.get(Integer.valueOf(message.what));
                if (fVar == null) {
                    Logger.w("InAppTaskHandlerManager", "miss task:" + message.what);
                    return;
                }
                if (fVar.c != 1) {
                    g.this.d.remove(Integer.valueOf(message.what));
                }
                fVar.a(message);
                Logger.d("InAppTaskHandlerManager", "delay message task time up, action: " + message.what + ", actionType: " + fVar.c + ", hbTime: " + c.a().d());
                if (fVar.c == 1) {
                    Logger.d("InAppTaskHandlerManager", "delay message task time up, send next delay task, hbTime: " + c.a().d());
                    sendEmptyMessageDelayed(message.what, ((long) c.a().d()) * 1000);
                }
            } catch (Throwable th) {
                Logger.w("InAppTaskHandlerManager", "handleMessage,e:" + th);
            }
        }
    }

    private g() {
    }

    public static g a() {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new g();
                }
            }
        }
        return a;
    }

    public void a(int i, long j, f fVar) {
        if (this.e == null) {
            return;
        }
        Logger.d("InAppTaskHandlerManager", "send delay hb message task, action: " + i + ", time: " + j + ", type: 1");
        fVar.b = j;
        fVar.c = 1;
        this.d.put(Integer.valueOf(i), fVar);
        if (this.e.hasMessages(i)) {
            Logger.w("InAppTaskHandlerManager", "registerFixedAction,same action in handler,will replace");
            this.e.removeMessages(i);
        }
        this.e.sendEmptyMessageDelayed(i, j);
    }

    public boolean a(int i) {
        Handler handler = this.e;
        if (handler == null) {
            return false;
        }
        return handler.hasMessages(i);
    }

    public synchronized void b() {
        if (this.c) {
            return;
        }
        Logger.d("InAppTaskHandlerManager", "init task manager...");
        try {
            this.e = new a(Looper.getMainLooper());
        } catch (Exception unused) {
            this.e = new a(Looper.getMainLooper());
        }
        this.c = true;
    }

    public void b(int i) {
        if (this.e == null) {
            return;
        }
        this.d.remove(Integer.valueOf(i));
        this.e.removeMessages(i);
    }

    public void b(int i, long j, f fVar) {
        if (this.e == null) {
            return;
        }
        fVar.c = 2;
        this.d.put(Integer.valueOf(i), fVar);
        if (this.e.hasMessages(i)) {
            Logger.d("InAppTaskHandlerManager", "sendMsg,replace:" + i);
            this.e.removeMessages(i);
        } else {
            Logger.d("InAppTaskHandlerManager", "sendMsg,action=" + i);
        }
        this.e.sendEmptyMessageDelayed(i, j);
    }
}
