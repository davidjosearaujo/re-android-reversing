package cn.jiguang.av;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import com.facebook.internal.security.CertificateUtil;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class k {
    private static k c;
    public Context a;
    public final LinkedList<m> b;
    private int d = 0;
    private byte[] e;
    private int f;

    public k(Context context) {
        this.a = context;
        this.b = m.a((String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.G()));
    }

    public static k a(Context context) {
        if (c == null) {
            synchronized (k.class) {
                if (c == null) {
                    c = new k(context);
                }
            }
        }
        return c;
    }

    private n a(int i) {
        double d;
        long j;
        Bundle bundle;
        double d2;
        String e = cn.jiguang.d.a.e(this.a);
        long f = cn.jiguang.d.a.f(this.a);
        String b = cn.jiguang.f.h.b(this.a);
        long currentTimeMillis = System.currentTimeMillis();
        Object a = cn.jiguang.ax.e.a(this.a, "get_loc_info", null);
        double d3 = 200.0d;
        if (a instanceof Bundle) {
            try {
                bundle = (Bundle) a;
                d2 = bundle.getDouble("lat");
            } catch (Throwable unused) {
                d = 200.0d;
            }
            try {
                d3 = bundle.getDouble("lot");
                j = bundle.getLong(CrashHianalyticsData.TIME);
                d3 = d2;
                d = d3;
            } catch (Throwable unused2) {
                double d4 = d3;
                d3 = d2;
                d = d4;
                j = currentTimeMillis;
                return new n(i, e, cn.jiguang.a.a.b, f, b, d3, d, j);
            }
        } else {
            j = currentTimeMillis;
            d = 200.0d;
        }
        return new n(i, e, cn.jiguang.a.a.b, f, b, d3, d, j);
    }

    private synchronized void a(m mVar) {
        this.b.add(mVar);
        cn.jiguang.ar.c.c("SisConnContext", "addSisReportInfo:" + mVar.a().toString());
        while (this.b.size() > 30) {
            this.b.removeFirst();
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<m> it = this.b.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        cn.jiguang.g.b.a(this.a, cn.jiguang.g.a.G().a((cn.jiguang.g.a<String>) jSONArray.toString()));
    }

    public boolean a(InetAddress inetAddress, int i, DatagramSocket datagramSocket, byte[] bArr) {
        try {
            return cn.jiguang.f.i.c(c.a(c.a(datagramSocket, new DatagramPacket(bArr, bArr.length, inetAddress, i)))) == 0;
        } catch (Throwable th) {
            cn.jiguang.ar.c.i("SisConnContext", "report failed : " + th);
            return false;
        }
    }

    public l a(long j) {
        FutureTask futureTask = new FutureTask(new i(this));
        this.d = 0;
        cn.jiguang.at.b.d(futureTask, new int[0]);
        if (j < 10) {
            j = 10;
        }
        try {
            return (l) futureTask.get(j, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            return null;
        }
    }

    public void a(int i, String str, int i2, long j, long j2, int i3) {
        if (g.a(str, i2)) {
            m mVar = new m();
            mVar.a = cn.jiguang.d.a.e(this.a);
            mVar.b = i;
            mVar.c = new g(str, i2);
            mVar.e = j;
            mVar.f = j2;
            mVar.k = i3;
            mVar.g = cn.jiguang.f.h.a(this.a);
            mVar.d = cn.jiguang.d.a.f(this.a);
            mVar.h = 200.0d;
            mVar.i = 200.0d;
            mVar.j = System.currentTimeMillis();
            Object a = cn.jiguang.ax.e.a(this.a, "get_loc_info", null);
            if (a instanceof Bundle) {
                try {
                    Bundle bundle = (Bundle) a;
                    mVar.h = bundle.getDouble("lat");
                    mVar.i = bundle.getDouble("lot");
                    mVar.j = bundle.getLong(CrashHianalyticsData.TIME);
                } catch (Throwable unused) {
                }
            }
            a(mVar);
        }
    }

    public void a(final g gVar) {
        if (((Boolean) cn.jiguang.g.b.a(this.a, cn.jiguang.g.a.L())).booleanValue()) {
            if (cn.jiguang.f.i.a(((Long) cn.jiguang.g.b.a(this.a, cn.jiguang.g.a.N())).longValue(), JConstants.HOUR)) {
                cn.jiguang.at.b.b(new cn.jiguang.be.b("SisConnContext#asyncSisReportIfNeed") { // from class: cn.jiguang.av.k.1
                    {
                        k.this = this;
                    }

                    @Override // cn.jiguang.be.b
                    public void a() {
                        DatagramSocket datagramSocket;
                        Object th;
                        StringBuilder sb;
                        try {
                            datagramSocket = new DatagramSocket();
                        } catch (Throwable th2) {
                            datagramSocket = null;
                            th = th2;
                        }
                        try {
                            String str = (String) cn.jiguang.g.b.a(k.this.a, cn.jiguang.g.a.G());
                            if (TextUtils.isEmpty(str)) {
                                cn.jiguang.ar.c.c("SisConnContext", "reportInfo is Empty, quit report");
                                try {
                                    datagramSocket.close();
                                    return;
                                } catch (Throwable th3) {
                                    cn.jiguang.ar.c.g("SisConnContext", "sisReport ,close udpsocket error:" + th3.getMessage());
                                    return;
                                }
                            }
                            byte[] a = c.a("DG", str);
                            cn.jiguang.ar.c.c("SisConnContext", "sis report data(" + a.length + ") at " + gVar.c + CertificateUtil.DELIMITER + gVar.b);
                            k kVar = k.this;
                            g gVar2 = gVar;
                            if (kVar.a(gVar2.c, gVar2.b, datagramSocket, a)) {
                                cn.jiguang.ar.c.c("SisConnContext", "report succeed : " + str);
                                cn.jiguang.g.b.a(k.this.a, cn.jiguang.g.a.N().a((cn.jiguang.g.a<Long>) Long.valueOf(SystemClock.elapsedRealtime())));
                                cn.jiguang.g.b.a(k.this.a, cn.jiguang.g.a.G().a((cn.jiguang.g.a<String>) null));
                            } else {
                                cn.jiguang.ar.c.g("SisConnContext", "report failed" + str);
                            }
                            try {
                                datagramSocket.close();
                            } catch (Throwable th4) {
                                th = th4;
                                sb = new StringBuilder();
                                sb.append("sisReport ,close udpsocket error:");
                                sb.append(th.getMessage());
                                cn.jiguang.ar.c.g("SisConnContext", sb.toString());
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            try {
                                cn.jiguang.ar.c.g("SisConnContext", "sisReport failed, error:" + th);
                                if (datagramSocket != null) {
                                    try {
                                        datagramSocket.close();
                                    } catch (Throwable th6) {
                                        th = th6;
                                        sb = new StringBuilder();
                                        sb.append("sisReport ,close udpsocket error:");
                                        sb.append(th.getMessage());
                                        cn.jiguang.ar.c.g("SisConnContext", sb.toString());
                                    }
                                }
                            } catch (Throwable th7) {
                                if (datagramSocket != null) {
                                    try {
                                        datagramSocket.close();
                                    } catch (Throwable th8) {
                                        cn.jiguang.ar.c.g("SisConnContext", "sisReport ,close udpsocket error:" + th8.getMessage());
                                    }
                                }
                                throw th7;
                            }
                        }
                    }
                }, new int[0]);
            } else {
                cn.jiguang.ar.c.c("SisConnContext", "sis report: not yet");
            }
        }
    }

    public void a(boolean z) {
        this.d = (z ? 1 : 2) | this.d;
        cn.jiguang.ay.c.a().a(this.a, this.d);
    }

    public boolean a() {
        return false;
    }

    public byte[] a(Set<String> set) {
        int a = cn.jiguang.f.h.a(this.a);
        if (this.e == null || a != this.f) {
            this.f = a;
            try {
                this.e = c.a("UG", a(a).a(set).toString());
            } catch (Exception e) {
                throw new cn.jiguang.ax.f(2, "Failed to package data - " + e);
            }
        }
        return this.e;
    }

    public int b() {
        if (this.d == 0) {
            this.d = cn.jiguang.ay.c.a().a(this.a);
        }
        int b = cn.jiguang.ay.c.a().b(this.d);
        cn.jiguang.ar.c.c("SisConnContext", "ipvsupport=" + this.d + ", prefer=" + b);
        return b;
    }
}
