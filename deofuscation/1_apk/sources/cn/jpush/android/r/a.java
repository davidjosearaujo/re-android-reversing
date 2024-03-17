package cn.jpush.android.r;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JPushMessageReceiver;
import com.alibaba.fastjson.JSONStreamContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a extends k implements f {
    private static HashMap<Integer, Integer> f = new HashMap<>();
    private static HashMap<Integer, Integer> g = new HashMap<>();
    private g a;
    private b b;
    private List<cn.jpush.android.d.d> c;
    private int d;
    private cn.jpush.android.d.d e;
    private int h = 0;

    /* renamed from: cn.jpush.android.r.a$a  reason: collision with other inner class name */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class C0016a extends cn.jpush.android.ac.e {
        public Context a;
        public int b;
        public cn.jpush.android.u.e c;
        public Object[] d;

        public C0016a(Context context, int i, cn.jpush.android.u.e eVar, Object... objArr) {
            this.a = context;
            this.b = i;
            this.c = eVar;
            this.d = objArr;
        }

        private boolean a(Context context, int i, cn.jpush.android.u.e eVar, Object... objArr) {
            a aVar;
            boolean z = false;
            if (context == null || eVar == null) {
                Logger.ww("AdInAppHelper", "unexpected error, context is " + context + ", message is " + eVar);
                String n = eVar != null ? eVar.n() : "";
                if (!TextUtils.isEmpty(n)) {
                    h.a(JPushConstants.mApplicationContext, "nullParam", n);
                }
                return false;
            }
            Integer num = null;
            try {
                String n2 = eVar.n();
                int i2 = eVar.u().bn;
                switch (i) {
                    case 1000:
                    case 1018:
                    case 1020:
                        h.a(context, "onDisplayEvent", n2);
                        if (i == 1000) {
                            aVar = a.this;
                            aVar.b(context, 0);
                            break;
                        }
                        break;
                    case 1001:
                    case 1002:
                    case 1015:
                        Integer valueOf = Integer.valueOf(a.this.a(i));
                        Logger.d("AdInAppHelper", "eventType: " + i + ", reportCode: " + valueOf);
                        if (valueOf.intValue() > 0) {
                            cn.jpush.android.helper.c.a(n2, valueOf.intValue(), context);
                        } else {
                            a.this.a(context, eVar);
                        }
                        aVar = a.this;
                        aVar.b(context, 0);
                        break;
                    case JSONStreamContext.PropertyValue /* 1003 */:
                    case 1011:
                    case 1016:
                    case 1022:
                        break;
                    case JSONStreamContext.StartArray /* 1004 */:
                    case 1006:
                    case 1007:
                    case 1008:
                    case 1009:
                    case com.alipay.sdk.app.d.a /* 1010 */:
                    case 1017:
                    case 1021:
                    default:
                        Integer valueOf2 = Integer.valueOf(a.this.a(i));
                        Logger.d("AdInAppHelper", "eventType: " + i + ", reportCode: " + valueOf2);
                        if (valueOf2.intValue() > 0) {
                            cn.jpush.android.helper.c.a(n2, valueOf2.intValue(), context);
                            break;
                        }
                        break;
                    case JSONStreamContext.ArrayValue /* 1005 */:
                        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Integer)) {
                            cn.jpush.android.helper.c.a(eVar.n(), Integer.valueOf(((Integer) objArr[0]).intValue() == 2 ? 1303 : 1236).intValue(), context);
                        }
                        aVar = a.this;
                        aVar.b(context, 0);
                        break;
                    case 1012:
                        return false;
                    case 1013:
                        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Integer)) {
                            num = (Integer) a.g.get(Integer.valueOf(((Integer) objArr[0]).intValue()));
                        }
                        a.this.a(context, eVar, num);
                        break;
                    case 1014:
                        JSONObject jSONObject = new JSONObject();
                        if (objArr != null && objArr.length > 1 && (objArr[0] instanceof Boolean) && (objArr[1] instanceof JSONObject)) {
                            z = ((Boolean) objArr[0]).booleanValue();
                            jSONObject = (JSONObject) objArr[1];
                        }
                        a.this.a(context, eVar, z, jSONObject.toString());
                        break;
                    case 1019:
                        if (objArr != null && objArr.length > 1 && (objArr[0] instanceof Integer) && (objArr[1] instanceof String)) {
                            cn.jpush.android.helper.c.a(eVar.n(), ((Integer) objArr[0]).intValue() == 0 ? 1249 : 1219, context);
                            String str = (String) objArr[1];
                            int a = eVar.a(context, str);
                            if (a == 0) {
                                h.a(context, eVar);
                                break;
                            } else {
                                Logger.w("AdInAppHelper", "click action jump failed, not found action key. actionKey: " + str);
                                cn.jpush.android.helper.c.a(eVar.n(), a, context);
                                break;
                            }
                        }
                        break;
                }
                a.this.a(context, eVar, i, objArr);
            } catch (Throwable th) {
                Logger.w("AdInAppHelper", "onDisplayEvent error, " + th.getMessage());
            }
            return true;
        }

        @Override // cn.jpush.android.ac.e
        public void a() {
            a(this.a, this.b, this.c, this.d);
        }
    }

    static {
        f.put(1015, 0);
        f.put(1001, 1292);
        f.put(1002, 1284);
        f.put(1006, 1262);
        f.put(1008, 1254);
        f.put(1009, 1200);
        f.put(Integer.valueOf((int) com.alipay.sdk.app.d.a), 1201);
        f.put(1007, 1229);
        f.put(Integer.valueOf((int) JSONStreamContext.StartArray), 1271);
        f.put(1017, 1235);
        f.put(1021, 1249);
        f.put(1023, 1319);
        f.put(1024, 1320);
        f.put(1025, 1321);
        f.put(1027, 1322);
        f.put(1026, 1322);
        f.put(1028, 1324);
        g.put(100, 1253);
        g.put(101, 1296);
        g.put(102, 1297);
        g.put(103, 1254);
        g.put(104, 1326);
    }

    public a(g gVar, b bVar) {
        this.b = bVar;
        this.a = gVar;
        gVar.a(200, this);
        this.d = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i) {
        Integer num = f.get(Integer.valueOf(i));
        if (num == null || num.intValue() <= 0) {
            return 0;
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, cn.jpush.android.u.e eVar) {
        int i = eVar.u;
        int i2 = i != 1 ? i != 2 ? i != 3 ? i != 4 ? 0 : 1318 : 1317 : 1316 : 1315;
        if (i2 > 0) {
            cn.jpush.android.helper.c.a(eVar.n(), i2, context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, cn.jpush.android.u.e eVar, int i, Object... objArr) {
        if (a(eVar, i)) {
            cn.jpush.android.d.a a = eVar.u().a();
            if (i == 1017 && objArr != null && objArr.length > 0 && (objArr[0] instanceof String)) {
                cn.jpush.android.d.d dVar = new cn.jpush.android.d.d();
                dVar.c = (String) objArr[0];
                dVar.g = "";
                a = dVar.a();
            }
            m.a(context, a, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, cn.jpush.android.u.e eVar, Integer num) {
        String n = eVar.n();
        int i = eVar.u().bn;
        if (num != null) {
            cn.jpush.android.helper.c.a(n, num.intValue(), context);
        }
        cn.jpush.android.helper.c.a(n, 1211, context);
        b(context, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, cn.jpush.android.u.e eVar, boolean z, String str) {
        cn.jpush.android.o.b.d(context);
        if (eVar.o() == 1) {
            h.a(context, eVar.u());
        }
        String n = eVar.n();
        if (z) {
            cn.jpush.android.helper.c.a(n, 1295, context);
        }
        cn.jpush.android.helper.c.a(n, 1210, str, context);
        b(context, 2);
        m.a(context, eVar.u().a(), true);
    }

    private boolean a(cn.jpush.android.u.e eVar, int i) {
        int i2;
        return i == 1017 || i == 1019 || i == 1021 || i == 1029 || i == 1027 || i == 1026 || (i == 1015 && ((i2 = eVar.u) == 1 || i2 == 2 || i2 == 3 || i2 == 4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, int i) {
        this.h = i;
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(context, 200, i);
        }
    }

    private static boolean e(Context context, cn.jpush.android.d.d dVar) {
        int i = dVar.aA;
        if (i == 1 || i == 2 || i == 3) {
            return true;
        }
        Logger.ww("AdInAppHelper", "unsupported in app message type. type: " + dVar.aA);
        cn.jpush.android.helper.c.a(dVar.c, 1226, context);
        return false;
    }

    public static byte g(Context context) {
        String messageReceiverClass;
        if (context == null) {
            return (byte) 0;
        }
        try {
            messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
        } catch (Throwable th) {
            Logger.w("AdInAppHelper", "[onCheckInAppMessageState]  error. " + th.getMessage());
        }
        if (Class.forName(messageReceiverClass).getMethod("onCheckInAppMessageState", Context.class, String.class) == null) {
            Logger.d("AdInAppHelper", "not found onCheckInAppMessageState method");
            return (byte) 0;
        }
        if (!TextUtils.isEmpty(messageReceiverClass)) {
            byte onCheckInAppMessageState = ((JPushMessageReceiver) Class.forName(messageReceiverClass).newInstance()).onCheckInAppMessageState(context, cn.jpush.android.ac.a.d(context));
            Logger.d("AdInAppHelper", "check InAppMessageState:" + ((int) onCheckInAppMessageState));
            return onCheckInAppMessageState;
        }
        return (byte) 0;
    }

    @Override // cn.jpush.android.r.k
    public int a(Context context) {
        return this.d;
    }

    @Override // cn.jpush.android.r.f
    public Boolean a(Context context, int i, cn.jpush.android.u.e eVar, Object... objArr) {
        JCoreHelper.normalExecutor(context, "AdInAppHelper", new C0016a(context, i, eVar, objArr));
        return Boolean.valueOf(i != 1012);
    }

    @Override // cn.jpush.android.r.k
    public void a(Context context, int i) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.a(context, i);
        }
    }

    @Override // cn.jpush.android.r.k
    public void a(Context context, cn.jpush.android.d.d dVar) {
        if (dVar != null) {
            boolean e = e(context, dVar);
            if (e) {
                this.d = dVar.bo;
                this.e = dVar;
                JCoreHelper.normalExecutor(context, JPushConstants.SDK_TYPE, new j(context, dVar, this.b));
            }
            if (e) {
                return;
            }
            b(context, 0);
        }
    }

    @Override // cn.jpush.android.r.k
    public void a(Context context, cn.jpush.android.u.e eVar, int i) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.a(context, eVar, i);
        }
    }

    @Override // cn.jpush.android.r.k
    public void a(Context context, cn.jpush.android.u.e eVar, String str) {
        if (TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        cn.jpush.android.helper.c.a(eVar.n(), 1234, str, context);
    }

    @Override // cn.jpush.android.r.k
    public void a(Context context, String str) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.a(context, str);
        }
    }

    @Override // cn.jpush.android.r.k
    public void a(cn.jpush.android.u.e eVar, int i, String str) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.a(eVar, i, str);
        }
    }

    @Override // cn.jpush.android.r.k
    public boolean a(Context context, boolean z, cn.jpush.android.d.d dVar) {
        return z;
    }

    @Override // cn.jpush.android.r.k
    public cn.jpush.android.d.d b(Context context) {
        List<cn.jpush.android.d.d> list = this.c;
        if (list == null || list.isEmpty()) {
            return null;
        }
        int size = this.c.size() - 1;
        cn.jpush.android.d.d dVar = this.c.get(size);
        this.c.remove(size);
        Logger.d("AdInAppHelper", "get in app message, current size is " + this.c.size());
        return dVar;
    }

    @Override // cn.jpush.android.r.k
    public void b(Context context, cn.jpush.android.d.d dVar) {
        try {
            if (dVar == null) {
                Logger.w("AdInAppHelper", "cache ad in app, message is null");
                return;
            }
            if (this.c == null) {
                this.c = new LinkedList();
            }
            if (this.c.contains(dVar)) {
                Logger.w("AdInAppHelper", "the ad message cache already, messageId: " + dVar.c);
                return;
            }
            if (this.c.size() >= 5) {
                this.c.remove(0);
                Logger.d("AdInAppHelper", "cache in app size large 5");
            }
            this.c.add(dVar);
            this.d = dVar.bo;
            Logger.d("AdInAppHelper", "in app message cache, current size is " + this.c.size());
            cn.jpush.android.helper.c.a(dVar.c, 1310, context);
        } catch (Throwable th) {
            Logger.w("AdInAppHelper", "cache in app data failed, " + th.getMessage());
        }
    }

    @Override // cn.jpush.android.r.k
    public void b(Context context, String str) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.b(context, str);
        }
    }

    @Override // cn.jpush.android.r.k
    public void c(Context context, String str) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.c(context, str);
        }
    }

    @Override // cn.jpush.android.r.k
    public boolean c(Context context) {
        List<cn.jpush.android.d.d> list = this.c;
        return list != null && list.size() > 0;
    }

    @Override // cn.jpush.android.r.k
    public boolean c(Context context, cn.jpush.android.d.d dVar) {
        g gVar = this.a;
        if (gVar != null) {
            this.e = dVar;
            return gVar.a(context, dVar);
        }
        return false;
    }

    @Override // cn.jpush.android.r.k
    public void d(Context context) {
        g gVar = this.a;
        if (gVar == null || this.h != 2) {
            return;
        }
        gVar.a(context);
    }

    @Override // cn.jpush.android.r.k
    public boolean e(Context context) {
        String messageReceiverClass;
        try {
            messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
        } catch (Throwable th) {
            Logger.w("AdInAppHelper", "check user intercept in app display failed, " + th.getMessage());
        }
        if (Class.forName(messageReceiverClass).getMethod("onInAppMessageUnShow", Context.class, NotificationMessage.class) == null) {
            Logger.dd("AdInAppHelper", "not found onInAppMessageUnShow method");
            return false;
        }
        if (!TextUtils.isEmpty(messageReceiverClass) && !((JPushMessageReceiver) Class.forName(messageReceiverClass).newInstance()).isNeedShowInAppMessage(context, new NotificationMessage(), cn.jpush.android.ac.a.d(context))) {
            Logger.dd("AdInAppHelper", "user intercept in app display");
            return true;
        }
        return false;
    }

    @Override // cn.jpush.android.r.k
    public void f(Context context) {
        ArrayList<cn.jpush.android.d.a> a = m.a(context);
        if (a == null || a.size() <= 0) {
            return;
        }
        Iterator<cn.jpush.android.d.a> it = a.iterator();
        while (it.hasNext()) {
            cn.jpush.android.d.a next = it.next();
            if (!TextUtils.isEmpty(next.a)) {
                cn.jpush.android.helper.c.a(next.a, 1323, context);
            }
        }
    }
}
