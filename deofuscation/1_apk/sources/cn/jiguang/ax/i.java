package cn.jiguang.ax;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.analytics.page.PushSA;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.internal.JConstants;
import java.io.Closeable;
import java.io.File;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class i {
    private static i a;
    private static int e;
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final Map<cn.jiguang.av.g, Pair<Integer, cn.jiguang.ba.a>> c = new ConcurrentHashMap();
    private final Map<cn.jiguang.av.g, ConcurrentHashMap<Integer, b>> d = new ConcurrentHashMap();
    private Map<String, Set<cn.jiguang.av.g>> f = new HashMap();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a extends cn.jiguang.bb.a implements Runnable {
        private Context a;
        private int d;
        private final Object e;
        private int f;

        public a(Context context, int i, Object obj) {
            this.a = context;
            this.d = i;
            this.e = obj;
        }

        public a(Context context, Object obj) {
            this.a = context;
            this.e = obj;
        }

        @Override // cn.jiguang.bb.a
        public void a(Message message) {
            int i = message.what;
            if (i >= 60000) {
                if (this.e instanceof cn.jiguang.av.g) {
                    cn.jiguang.ar.c.c("TcpReporter", "time to idle=" + this.e);
                    i.a().a(this.a, (cn.jiguang.av.g) this.e, 0);
                }
            } else if (i >= 50000) {
                Object obj = this.e;
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    cn.jiguang.ar.c.c("TcpReporter", "onTimeout=" + bVar);
                    i.a().a(bVar.g, bVar.f);
                    i.a().a(this.a, bVar);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int i = this.d;
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            Object obj = this.e;
                            if (obj instanceof b) {
                                b bVar = (b) obj;
                                cn.jiguang.ar.c.c("TcpReporter", "onResult, data=" + bVar + " code=" + this.f);
                                JCoreManager.onEvent(this.a, JConstants.SDK_TYPE, 61, "", null, Integer.valueOf(this.f), bVar.b, bVar.c, Integer.valueOf(bVar.a), bVar.d, bVar.e, bVar.j);
                            }
                        }
                    } else if (this.e instanceof cn.jiguang.av.g) {
                        i.a().b(this.a, (cn.jiguang.av.g) this.e);
                    }
                } else if (this.e instanceof cn.jiguang.av.g) {
                    i.a().a(this.a, (cn.jiguang.av.g) this.e);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class b {
        public int a;
        public JSONObject b;
        public byte[] c;
        public File d;
        public Set<String> e;
        public int f = -1;
        public cn.jiguang.av.g g;
        public LinkedHashSet<cn.jiguang.av.g> h;
        public boolean i;
        public transient ReportCallBack j;

        public String toString() {
            return "TcpReportData{types=" + this.e + ", seqId=" + this.f + ", ipPort=" + this.g + ", restUrls=" + this.h + '}';
        }
    }

    private i() {
    }

    public static synchronized int a(Context context) {
        int intValue;
        synchronized (i.class) {
            Integer num = (Integer) cn.jiguang.g.b.b(context, cn.jiguang.g.a.I());
            if (num == null) {
                num = Integer.valueOf(Math.abs(new SecureRandom().nextInt(10000)));
            }
            Integer valueOf = Integer.valueOf((num.intValue() + 1) % 10000);
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.I().a((cn.jiguang.g.a<Integer>) valueOf));
            intValue = valueOf.intValue();
        }
        return intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b a(cn.jiguang.av.g gVar, int i) {
        ConcurrentHashMap<Integer, b> concurrentHashMap;
        if (gVar == null || (concurrentHashMap = this.d.get(gVar)) == null) {
            return null;
        }
        b bVar = concurrentHashMap.get(Integer.valueOf(i));
        concurrentHashMap.remove(Integer.valueOf(i));
        return bVar;
    }

    public static i a() {
        if (a == null) {
            synchronized (i.class) {
                if (a == null) {
                    a = new i();
                }
            }
        }
        return a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "normal";
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1245458676:
                if (str.equals(PushSA.REPORT_ACTIVE_LAUNCH)) {
                    c = 0;
                    break;
                }
                break;
            case -1177318867:
                if (str.equals("account")) {
                    c = 1;
                    break;
                }
                break;
            case -1091230153:
                if (str.equals("android_awake_target2")) {
                    c = 2;
                    break;
                }
                break;
            case -1051289244:
                if (str.equals("active_user")) {
                    c = 3;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals("normal")) {
                    c = 4;
                    break;
                }
                break;
            case -820729752:
                if (str.equals(PushSA.REPORT_ACTIVE_TERMINATE)) {
                    c = 5;
                    break;
                }
                break;
            case -693746763:
                if (str.equals("android_awake")) {
                    c = 6;
                    break;
                }
                break;
            case -295020531:
                if (str.equals("android_notification_state")) {
                    c = 7;
                    break;
                }
                break;
            case -31313123:
                if (str.equals("android_awake2")) {
                    c = '\b';
                    break;
                }
                break;
            case 96275:
                if (str.equals("aa3")) {
                    c = '\t';
                    break;
                }
                break;
            case 2986591:
                if (str.equals("aat3")) {
                    c = '\n';
                    break;
                }
                break;
            case 93223301:
                if (str.equals("awake")) {
                    c = 11;
                    break;
                }
                break;
            case 907150721:
                if (str.equals("detach_account")) {
                    c = '\f';
                    break;
                }
                break;
            case 1350272347:
                if (str.equals("android_awake_target")) {
                    c = '\r';
                    break;
                }
                break;
            case 1973539834:
                if (str.equals("identify_account")) {
                    c = 14;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 3:
            case 5:
                return "active_user";
            case 1:
            case '\f':
            case 14:
                return "account";
            case 2:
            case 6:
            case '\b':
            case '\t':
            case '\n':
            case 11:
            case '\r':
                return "awake";
            case 4:
                break;
            case 7:
                return "android_notification_state";
            default:
                if (this.f.containsKey(str)) {
                    return str;
                }
                break;
        }
        return "normal";
    }

    private LinkedHashSet<cn.jiguang.av.g> a(Context context, Set<String> set) {
        LinkedHashSet<cn.jiguang.av.g> linkedHashSet = new LinkedHashSet<>();
        cn.jiguang.av.g a2 = cn.jiguang.av.g.a(cn.jiguang.au.a.d());
        if (a2 == null || !a2.a()) {
            Set<cn.jiguang.av.g> b2 = b(context, set);
            if (b2 != null) {
                for (cn.jiguang.av.g gVar : b2) {
                    if (gVar != null && gVar.a()) {
                        linkedHashSet.add(gVar);
                    }
                }
            }
        } else {
            linkedHashSet.add(a2);
        }
        cn.jiguang.ar.c.c("TcpReporter", "tcp report find urls=" + linkedHashSet);
        return linkedHashSet;
    }

    private void a(Context context, int i, cn.jiguang.ba.a aVar, cn.jiguang.av.g gVar, b bVar) {
        byte[] a2 = a(context, bVar.c, bVar.a, bVar.f);
        if (a2 == null || a2.length == 0) {
            cn.jiguang.ar.c.c("TcpReporter", "package data failed, give up, data=" + bVar);
            a(context, bVar, -1);
            return;
        }
        cn.jiguang.ar.c.c("TcpReporter", "send tcp data, len=" + a2.length + ", data=" + bVar);
        bVar.i = true;
        aVar.a(a2);
        cn.jiguang.bb.b.a().b(i + 60000, 31000L, new a(context, gVar));
        cn.jiguang.bb.b.a().b(bVar.f + 50000, 15000L, new a(context, bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, cn.jiguang.av.g gVar) {
        cn.jiguang.ba.a aVar;
        if (gVar == null) {
            return;
        }
        try {
            Pair<Integer, cn.jiguang.ba.a> pair = this.c.get(gVar);
            if (pair != null && (aVar = (cn.jiguang.ba.a) pair.second) != null && !aVar.b()) {
                cn.jiguang.ar.c.c("TcpReporter", "start tcp socket(" + pair.first + "):" + gVar);
                if (aVar.a(gVar.a, gVar.b) != 0) {
                    a(context, gVar, 0);
                } else {
                    cn.jiguang.at.b.c(new a(context, 2, gVar), new int[0]);
                    a aVar2 = new a(context, gVar);
                    while (!this.b.get()) {
                        try {
                            a(context, aVar.a(), gVar);
                            cn.jiguang.bb.b.a().b(((Integer) pair.first).intValue() + 60000, 31000L, aVar2);
                        } catch (f e2) {
                            if (e2.a != -997) {
                                cn.jiguang.ar.c.g("TcpReporter", "recv failed with error:" + e2);
                            }
                        }
                    }
                }
                a(context, gVar, 0);
                cn.jiguang.ar.c.g("TcpReporter", this.b.get() ? "Break receiving by wantStop" : "disconnected");
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.a("TcpReporter", "socket exception", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, cn.jiguang.av.g gVar, int i) {
        int i2;
        StringBuilder sb;
        Pair<Integer, cn.jiguang.ba.a> remove = this.c.remove(gVar);
        if (remove != null) {
            i2 = ((Integer) remove.first).intValue();
            cn.jiguang.f.i.a((Closeable) remove.second);
        } else {
            i2 = 0;
        }
        ConcurrentHashMap<Integer, b> remove2 = this.d.remove(gVar);
        if (i == 0 && !cn.jiguang.f.a.d(context)) {
            i = -2;
        }
        if (remove2 == null || remove2.size() <= 0) {
            if (i2 > 0) {
                cn.jiguang.ar.c.c("TcpReporter", "socket(" + i2 + ") at " + gVar + " is disconnected, no task left");
                return;
            }
            return;
        }
        if (i == 0) {
            sb = new StringBuilder();
            sb.append("socket(");
            sb.append(i2);
            sb.append(") at ");
            sb.append(gVar);
            sb.append(" is disconnected, go on send waiting request");
        } else {
            sb = new StringBuilder();
            sb.append("socket(");
            sb.append(i2);
            sb.append(") at ");
            sb.append(gVar);
            sb.append(" is disconnected, finish waiting request, code=");
            sb.append(i);
        }
        cn.jiguang.ar.c.c("TcpReporter", sb.toString());
        for (b bVar : remove2.values()) {
            if (bVar != null) {
                cn.jiguang.bb.b.a().b(bVar.f + 50000);
                if (i == 0) {
                    a(context, bVar);
                } else {
                    a aVar = new a(context, 3, bVar);
                    aVar.f = i;
                    cn.jiguang.at.b.c(aVar, new int[0]);
                }
            }
        }
    }

    private synchronized void a(Context context, cn.jiguang.av.g gVar, b bVar) {
        Pair<Integer, cn.jiguang.ba.a> pair = this.c.get(gVar);
        cn.jiguang.ba.a aVar = pair != null ? (cn.jiguang.ba.a) pair.second : null;
        if (aVar == null) {
            this.c.put(gVar, new Pair<>(Integer.valueOf(b()), new cn.jiguang.ba.b(30720, 19)));
            cn.jiguang.be.d.a("ONCE_TASK", new a(context, 1, gVar));
        } else if (aVar.b()) {
            a(context, ((Integer) pair.first).intValue(), aVar, gVar, bVar);
        }
    }

    private void a(Context context, b bVar, int i) {
        ConcurrentHashMap<Integer, b> concurrentHashMap;
        cn.jiguang.av.g gVar = bVar.g;
        if (gVar != null && (concurrentHashMap = this.d.get(gVar)) != null) {
            concurrentHashMap.remove(Integer.valueOf(bVar.f));
        }
        cn.jiguang.bb.b.a().b(bVar.f + 50000);
        a aVar = new a(context, 3, bVar);
        aVar.f = i;
        cn.jiguang.at.b.c(aVar, new int[0]);
    }

    private void a(Context context, ByteBuffer byteBuffer, cn.jiguang.av.g gVar) {
        try {
            cn.jiguang.ar.c.c("TcpReporter", "Received bytes - len:" + byteBuffer.array().length);
            byte b2 = byteBuffer.get(2);
            if (b2 != 1 && b2 != 0) {
                cn.jiguang.ar.c.g("TcpReporter", "wrong version");
            }
            short s = byteBuffer.getShort(15);
            short s2 = byteBuffer.getShort(17);
            cn.jiguang.ar.c.c("TcpReporter", "onResult seqId=" + ((int) s) + " code=" + ((int) s2));
            cn.jiguang.bb.b.a().b(50000 + s);
            b a2 = a(gVar, s);
            if (a2 != null) {
                if (s2 == 0) {
                    a aVar = new a(context, 3, a2);
                    aVar.f = s2;
                    cn.jiguang.at.b.c(aVar, new int[0]);
                } else if (s2 == 401) {
                    a(context, gVar, s2);
                } else {
                    a(context, a2);
                }
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("TcpReporter", "tcp reporter onReceive err:" + th);
        }
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray optJSONArray = jSONObject.optJSONArray(next);
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            cn.jiguang.av.g a2 = cn.jiguang.av.g.a(optJSONArray.getString(i));
                            if (a2 != null && a2.a()) {
                                linkedHashSet.add(a2);
                            }
                        }
                    }
                    hashMap.put(next, linkedHashSet);
                }
                if (hashMap.isEmpty()) {
                    return;
                }
                this.f = hashMap;
            } catch (JSONException unused) {
            }
        }
    }

    private static byte[] a(Context context, long j, byte[] bArr) {
        String e2 = cn.jiguang.f.g.e((String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.e()));
        String b2 = cn.jiguang.f.g.b(bArr);
        byte[] c = cn.jiguang.f.g.c(j + e2 + b2);
        if (c == null) {
            return new byte[16];
        }
        if (c.length == 16) {
            return c;
        }
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, Math.min(c.length, 16));
        return bArr2;
    }

    private byte[] a(Context context, byte[] bArr, int i, int i2) {
        if (bArr == null || bArr.length == 0 || bArr.length > 30683) {
            return null;
        }
        cn.jiguang.bc.b bVar = new cn.jiguang.bc.b(bArr.length + 37);
        bVar.b(0);
        bVar.a(1);
        bVar.a(cn.jiguang.ax.b.a().b());
        long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.c())).longValue();
        bVar.b(longValue);
        bVar.a(a(context, longValue, bArr));
        bVar.a(i);
        bVar.b(i2);
        bVar.a(bArr);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    private static synchronized int b() {
        int i;
        synchronized (i.class) {
            i = (e + 1) % 10000;
            e = i;
        }
        return i;
    }

    private Set<cn.jiguang.av.g> b(Context context, Set<String> set) {
        b(context);
        if (set != null && !set.isEmpty()) {
            Set<cn.jiguang.av.g> set2 = null;
            for (String str : set) {
                Set<cn.jiguang.av.g> set3 = this.f.get(a(str));
                if (set3 != null && !set3.isEmpty()) {
                    if (set2 == null) {
                        set2 = set3;
                    } else {
                        set2.retainAll(set3);
                    }
                    if (set2.isEmpty()) {
                    }
                }
            }
            return set2;
        }
        return this.f.get("normal");
    }

    private void b(Context context) {
        Map<String, Set<cn.jiguang.av.g>> map = this.f;
        if (map == null || map.isEmpty()) {
            String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.R());
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                a(new JSONObject(str));
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, cn.jiguang.av.g gVar) {
        cn.jiguang.ba.a aVar;
        cn.jiguang.ar.c.c("TcpReporter", "socket at " + gVar + " is connected, deal with waiting request");
        ConcurrentHashMap<Integer, b> concurrentHashMap = this.d.get(gVar);
        Pair<Integer, cn.jiguang.ba.a> pair = this.c.get(gVar);
        if (pair == null) {
            return;
        }
        if (concurrentHashMap != null && (aVar = (cn.jiguang.ba.a) pair.second) != null && aVar.b()) {
            for (b bVar : concurrentHashMap.values()) {
                if (bVar != null && !bVar.i) {
                    a(context, ((Integer) pair.first).intValue(), aVar, gVar, bVar);
                }
            }
        }
        cn.jiguang.bb.b.a().b(((Integer) pair.first).intValue() + 60000, 31000L, new a(context, gVar));
    }

    public b a(Context context, JSONObject jSONObject, byte[] bArr, int i, File file, Set<String> set, ReportCallBack reportCallBack) {
        b bVar = new b();
        bVar.b = jSONObject;
        bVar.a = i;
        bVar.c = bArr;
        bVar.d = file;
        bVar.e = set;
        bVar.f = a(context);
        bVar.j = reportCallBack;
        return bVar;
    }

    public void a(Context context, b bVar) {
        try {
            boolean z = bVar.h == null;
            if (z) {
                cn.jiguang.bb.b.a().a(context);
                bVar.h = a(context, bVar.e);
                cn.jiguang.ar.c.c("TcpReporter", "tcp report begin=" + bVar);
            }
            if (!cn.jiguang.f.a.d(context)) {
                a(context, bVar, -2);
                return;
            }
            LinkedHashSet<cn.jiguang.av.g> linkedHashSet = bVar.h;
            if (linkedHashSet != null && !linkedHashSet.isEmpty()) {
                cn.jiguang.av.g gVar = null;
                Iterator<cn.jiguang.av.g> it = this.c.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    cn.jiguang.av.g next = it.next();
                    if (bVar.h.contains(next)) {
                        cn.jiguang.ar.c.c("TcpReporter", "use exist ipPort=" + next);
                        gVar = next;
                        break;
                    }
                }
                if (gVar == null) {
                    gVar = bVar.h.iterator().next();
                    cn.jiguang.ar.c.c("TcpReporter", "use next ipPort=" + gVar);
                }
                bVar.g = gVar;
                bVar.h.remove(gVar);
                if (z) {
                    cn.jiguang.bb.b.a().b(bVar.f + 50000, 15000L, new a(context, bVar));
                }
                ConcurrentHashMap<Integer, b> concurrentHashMap = this.d.get(gVar);
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                    this.d.put(gVar, concurrentHashMap);
                }
                bVar.i = false;
                concurrentHashMap.put(Integer.valueOf(bVar.f), bVar);
                a(context, gVar, bVar);
                return;
            }
            a(context, bVar, -1);
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("TcpReporter", "tcp upload e:" + th);
        }
    }
}
