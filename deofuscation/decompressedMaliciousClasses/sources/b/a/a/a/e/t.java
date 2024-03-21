package b.a.a.a.e;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import b.a.a.a.c.c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.util.a;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class t implements Handler.Callback {
    private static short[] $ = {5235, 5193, 5191, 5198, 5133, 5199, 5205, 5204, 5120, 5199, 5187, 5187, 5205, 5202, 5202, 5189, 5188, 5120, 5207, 5192, 5193, 5196, 5189, 5120, 5204, 5192, 5193, 5203, 5120, 5217, 5232, 5225, 5120, 5187, 5185, 5196, 5196, 5120, 5207, 5185, 5203, 5120, 5193, 5198, 5120, 5200, 5202, 5199, 5191, 5202, 5189, 5203, 5203, 5134, 6384, 6348, 6337, 6276, 6353, 6359, 6337, 6358, 6276, 6345, 6353, 6359, 6352, 6276, 6342, 6337, 6276, 6359, 6349, 6339, 6346, 6337, 6336, 6276, 6349, 6346, 6276, 6352, 6347, 6276, 6345, 6341, 6351, 6337, 6276, 6352, 6348, 6349, 6359, 6276, 6373, 6388, 6381, 6276, 6343, 6341, 6344, 6344, 6282, 8791, 8831, 8831, 8823, 8828, 8821, 8785, 8800, 8825, 8792, 8817, 8830, 8820, 8828, 8821, 8802, 24986, 25010, 25010, 25018, 25009, 25016, 24988, 25005, 25012, 24976, 25020, 25011, 25020, 25018, 25016, 25007, 32003, 32056, 32061, 32056, 32057, 32033, 32056, 32118, 32059, 32051, 32037, 32037, 32055, 32049, 32051, 32118, 32063, 32050, 32108, 32118, 27080, 27135, 27135, 27106, 27135, 27053, 27135, 27112, 27134, 27106, 27105, 27128, 27129, 27108, 27106, 27107, 27053, 27130, 27116, 27134, 27053, 27118, 27116, 27107, 27118, 27112, 27105, 27112, 27113, 27053, 27119, 27124, 27053, 27129, 27109, 27112, 27053, 27128, 27134, 27112, 27135, 27041, 27053, 27106, 27135, 27108, 27114, 27108, 27107, 27116, 27105, 27053, 27112, 27135, 27135, 27106, 27135, 27053, 27104, 27112, 27134, 27134, 27116, 27114, 27112, 27063, 27053, 29659, 29633, 27872, 27852, 27862, 27855, 27847, 27779, 27853, 27852, 27863, 27779, 27845, 27850, 27853, 27847, 27779, 27874, 27891, 27882, 27779, 27850, 27853, 27856, 27863, 27842, 27853, 27840, 27846, 27779, 19581, 19498, 19509, 19508, 19505, 19512, 19581, 19497, 19503, 19492, 19508, 19507, 19514, 19581, 19497, 19506, 19581, 19515, 19516, 19508, 19505, 19581, 19512, 19507, 19500, 19496, 19512, 19496, 19512, 19513, 19581, 19518, 19516, 19505, 19505, 19502, 19571};
    public static final Status n = new Status(4, $(0, 54, 5152));
    private static final Status o = new Status(4, $(54, 103, 6308));
    private static final Object p = new Object();
    private static t q;
    private final Context d;
    private final c e;
    private final Handler m;

    /* renamed from: a */
    private long f177a = 5000;

    /* renamed from: b */
    private long f178b = 120000;
    private long c = 10000;
    private int f = -1;
    private final AtomicInteger g = new AtomicInteger(1);
    private final AtomicInteger h = new AtomicInteger(0);
    private final Map<f<?>, v<?>> i = new ConcurrentHashMap(5, 0.75f, 1);
    private r j = null;
    private final Set<f<?>> k = new a();
    private final Set<f<?>> l = new a();

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    private t(Context context, Looper looper, c cVar) {
        this.d = context;
        Handler handler = new Handler(looper, this);
        this.m = handler;
        this.e = cVar;
        handler.sendMessage(handler.obtainMessage(6));
    }

    public static t e(Context context) {
        t tVar;
        synchronized (p) {
            if (q == null) {
                HandlerThread handlerThread = new HandlerThread($(103, 119, 8720), 9);
                handlerThread.start();
                q = new t(context.getApplicationContext(), handlerThread.getLooper(), c.j());
            }
            tVar = q;
        }
        return tVar;
    }

    private final void i(d<?> dVar) {
        f<?> g = dVar.g();
        v<?> vVar = this.i.get(g);
        if (vVar == null) {
            vVar = new v<>(this, dVar);
            this.i.put(g, vVar);
        }
        if (vVar.p()) {
            this.l.add(g);
        }
        vVar.d();
    }

    private final void t() {
        for (f<?> fVar : this.l) {
            this.i.remove(fVar).h();
        }
        this.l.clear();
    }

    public final void c(b.a.a.a.c.a aVar, int i) {
        if (!j(aVar, i)) {
            Handler handler = this.m;
            handler.sendMessage(handler.obtainMessage(5, i, 0, aVar));
        }
    }

    public final <O extends a.AbstractC0005a> void d(d<O> dVar, int i, j<? extends j, a.c> jVar) {
        c cVar = new c(i, jVar);
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(4, new d0(cVar, this.h.get(), dVar)));
    }

    public final void g(d<?> dVar) {
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(7, dVar));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        b.a.a.a.c.a aVar;
        int i = message.what;
        long j = 300000;
        String $2 = $(119, 135, 25053);
        switch (i) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j = 10000;
                }
                this.c = j;
                this.m.removeMessages(12);
                for (f<?> fVar : this.i.keySet()) {
                    Handler handler = this.m;
                    handler.sendMessageDelayed(handler.obtainMessage(12, fVar), this.c);
                }
                break;
            case ModuleDescriptor.MODULE_VERSION /* 2 */:
                g gVar = (g) message.obj;
                Iterator<f<?>> it = gVar.b().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        f<?> next = it.next();
                        v<?> vVar = this.i.get(next);
                        if (vVar == null) {
                            gVar.a(next, new b.a.a.a.c.a(13));
                            break;
                        } else {
                            if (vVar.f()) {
                                aVar = b.a.a.a.c.a.e;
                            } else if (vVar.w() != null) {
                                aVar = vVar.w();
                            } else {
                                vVar.j(gVar);
                            }
                            gVar.a(next, aVar);
                        }
                    }
                }
            case 3:
                for (v<?> vVar2 : this.i.values()) {
                    vVar2.v();
                    vVar2.d();
                }
                break;
            case 4:
            case 8:
            case 13:
                d0 d0Var = (d0) message.obj;
                v<?> vVar3 = this.i.get(d0Var.c.g());
                if (vVar3 == null) {
                    i(d0Var.c);
                    vVar3 = this.i.get(d0Var.c.g());
                }
                if (!vVar3.p() || this.h.get() == d0Var.f144b) {
                    vVar3.i(d0Var.f143a);
                    break;
                } else {
                    d0Var.f143a.e(n);
                    vVar3.h();
                    break;
                }
                break;
            case 5:
                int i2 = message.arg1;
                b.a.a.a.c.a aVar2 = (b.a.a.a.c.a) message.obj;
                v<?> vVar4 = null;
                Iterator<v<?>> it2 = this.i.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        v<?> next2 = it2.next();
                        if (next2.e() == i2) {
                            vVar4 = next2;
                        }
                    }
                }
                if (vVar4 != null) {
                    String valueOf = String.valueOf(this.e.b(aVar2.c()));
                    String valueOf2 = String.valueOf(aVar2.d());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 69 + String.valueOf(valueOf2).length());
                    sb.append($(155, 222, 27021));
                    sb.append(valueOf);
                    sb.append($(222, 224, 29665));
                    sb.append(valueOf2);
                    vVar4.A(new Status(17, sb.toString()));
                    break;
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append($(224, 252, 27811));
                    sb2.append(i2);
                    sb2.append($(252, 289, 19549));
                    Log.wtf($2, sb2.toString(), new Exception());
                    break;
                }
            case 6:
                if (this.d.getApplicationContext() instanceof Application) {
                    h.a((Application) this.d.getApplicationContext());
                    h.e().b(new u(this));
                    if (!h.e().c(true)) {
                        this.c = 300000;
                        break;
                    }
                }
                break;
            case 7:
                i((d) message.obj);
                break;
            case 9:
                if (this.i.containsKey(message.obj)) {
                    this.i.get(message.obj).g();
                    break;
                }
                break;
            case 10:
                t();
                break;
            case 11:
                if (this.i.containsKey(message.obj)) {
                    this.i.get(message.obj).r();
                    break;
                }
                break;
            case 12:
                if (this.i.containsKey(message.obj)) {
                    this.i.get(message.obj).z();
                    break;
                }
                break;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append($(135, 155, 32086));
                sb3.append(i);
                Log.w($2, sb3.toString());
                return false;
        }
        return true;
    }

    public final boolean j(b.a.a.a.c.a aVar, int i) {
        return this.e.p(this.d, aVar, i);
    }

    public final void r() {
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final int s() {
        return this.g.getAndIncrement();
    }
}
