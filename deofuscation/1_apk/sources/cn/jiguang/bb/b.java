package cn.jiguang.bb;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import cn.jiguang.ar.c;
import cn.jiguang.ax.h;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    private static volatile b a;
    private static final Object b = new Object();
    private boolean c = false;
    private ConcurrentHashMap<Integer, cn.jiguang.bb.a> d = new ConcurrentHashMap<>();
    private Handler e;
    private HandlerThread f;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends Handler {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper) {
            super(looper);
            b.this = r1;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                cn.jiguang.bb.a aVar = (cn.jiguang.bb.a) b.this.d.get(Integer.valueOf(message.what));
                if (aVar != null) {
                    aVar.a(message);
                    if (aVar.c == 1) {
                        sendEmptyMessageDelayed(message.what, h.a().f() * 1000);
                    } else {
                        b.this.d.remove(Integer.valueOf(message.what));
                    }
                } else {
                    c.g("TaskHandlerManager_xxx", "miss task:" + message.what);
                }
            } catch (Throwable th) {
                c.g("TaskHandlerManager_xxx", "handleMessage,e:" + th);
            }
        }
    }

    private b() {
    }

    public static b a() {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public void a(int i, long j, cn.jiguang.bb.a aVar) {
        if (this.e == null) {
            return;
        }
        aVar.b = j;
        aVar.c = 1;
        this.d.put(Integer.valueOf(i), aVar);
        if (this.e.hasMessages(i)) {
            c.g("TaskHandlerManager_xxx", "registerFixedAction,same action in handler,will replace");
            this.e.removeMessages(i);
        }
        this.e.sendEmptyMessageDelayed(i, j);
    }

    public synchronized void a(Context context) {
        if (this.c) {
            return;
        }
        if (context == null) {
            c.c("TaskHandlerManager_xxx", "init context is null");
            return;
        }
        c.c("TaskHandlerManager_xxx", "init task manager...");
        try {
            HandlerThread handlerThread = this.f;
            if (handlerThread == null || !handlerThread.isAlive()) {
                HandlerThread handlerThread2 = new HandlerThread("jg_tsk_thread") { // from class: cn.jiguang.bb.b.1
                    {
                        b.this = this;
                    }

                    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            super.run();
                        } catch (RuntimeException e) {
                            c.i("TaskHandlerManager_xxx", "handler thread run e:" + e + "  t=" + Thread.currentThread().getName() + "_" + Thread.currentThread().getId());
                        }
                    }
                };
                this.f = handlerThread2;
                handlerThread2.start();
            }
            this.e = new a(this.f.getLooper() == null ? Looper.getMainLooper() : this.f.getLooper());
        } catch (Exception unused) {
            this.e = new a(Looper.getMainLooper());
        }
        this.c = true;
    }

    public boolean a(int i) {
        Handler handler = this.e;
        if (handler == null) {
            return false;
        }
        return handler.hasMessages(i);
    }

    public void b(int i) {
        if (this.e == null) {
            return;
        }
        this.d.remove(Integer.valueOf(i));
        this.e.removeMessages(i);
    }

    public void b(int i, long j, cn.jiguang.bb.a aVar) {
        if (this.e == null) {
            return;
        }
        aVar.c = 2;
        this.d.put(Integer.valueOf(i), aVar);
        if (this.e.hasMessages(i)) {
            c.c("TaskHandlerManager_xxx", "sendMsg,replace:" + i);
            this.e.removeMessages(i);
        } else {
            c.c("TaskHandlerManager_xxx", "sendMsg,action=" + i);
        }
        this.e.sendEmptyMessageDelayed(i, j);
    }
}
