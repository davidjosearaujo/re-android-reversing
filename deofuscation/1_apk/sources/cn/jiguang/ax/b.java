package cn.jiguang.ax;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.JPushInterface;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    private static volatile b b;
    private static final Object c = new Object();
    public static HashMap<String, JDispatchAction> a = new HashMap<>();

    private b() {
        Object a2 = cn.jiguang.d.a.a();
        if (a2 instanceof HashMap) {
            StringBuilder sb = new StringBuilder();
            sb.append("actiom map size:");
            HashMap<String, String> hashMap = (HashMap) a2;
            sb.append(hashMap.size());
            cn.jiguang.ar.c.c("DispatchActionManager", sb.toString());
            a(hashMap);
            a(JConstants.SDK_TYPE, cn.jiguang.c.a.class.getCanonicalName());
        }
    }

    private static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String[] split = str.split("\\.");
        return (Integer.parseInt(split[0]) << 16) + (Integer.parseInt(split[1]) << 8) + Integer.parseInt(split[2]);
    }

    public static b a() {
        if (b == null) {
            synchronized (c) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    private void b(Context context, int i, int i2, String str) {
        Intent intent = null;
        try {
            if (i == 0 && i2 == 0) {
                intent = new Intent(JPushInterface.ACTION_REGISTRATION_ID);
                intent.putExtra(JPushInterface.EXTRA_REGISTRATION_ID, str);
            } else if (i == -1 || i == 1) {
                intent = new Intent(JPushInterface.ACTION_CONNECTION_CHANGE);
                if (i == -1) {
                    intent.putExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false);
                } else {
                    intent.putExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, true);
                }
            }
            if (intent != null) {
                String packageName = context.getPackageName();
                intent.addCategory(packageName);
                intent.setPackage(packageName);
                cn.jiguang.f.a.a(context, intent);
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("DispatchActionManager", "sendToOldPushUser failed:" + th.getMessage());
        }
    }

    public byte a(Context context) {
        for (Map.Entry<String, JDispatchAction> entry : a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                Object beforLogin = value.beforLogin(context, entry.getKey(), 24, "platformtype");
                if (beforLogin instanceof Byte) {
                    return ((Byte) beforLogin).byteValue();
                }
            }
        }
        return (byte) 0;
    }

    public void a(Context context, int i, int i2, String str) {
        for (Map.Entry<String, JDispatchAction> entry : a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                value.onEvent(context, entry.getKey(), i, i2, str);
            }
        }
        b(context, i, i2, str);
    }

    public void a(Context context, cn.jiguang.az.c cVar, ByteBuffer byteBuffer) {
        if (cVar == null) {
            cn.jiguang.ar.c.g("DispatchActionManager", "Action - dispatchMessage unexcepted - head was null");
            return;
        }
        d a2 = j.a().a(cVar.e);
        if (a2 == null) {
            for (Map.Entry<String, JDispatchAction> entry : a.entrySet()) {
                JDispatchAction value = entry.getValue();
                if (value != null && value.isSupportedCMD(entry.getKey(), cVar.c)) {
                    value.dispatchMessage(context, entry.getKey(), cVar.c, cVar.b, cVar.e, -1L, byteBuffer);
                }
            }
            return;
        }
        cn.jiguang.ar.c.c("DispatchActionManager", "dispacth msg with reuqest :" + a2);
        JDispatchAction jDispatchAction = a.get(a2.c);
        if (jDispatchAction != null) {
            jDispatchAction.dispatchMessage(context, a2.c, cVar.c, cVar.b, cVar.e, a2.b, byteBuffer);
        }
        Bundle bundle = new Bundle();
        bundle.putLong("rid", cVar.e);
        h.a().a(context, "tcp_a7", bundle);
    }

    public void a(Context context, String str, long j, int i) {
        if (!TextUtils.isEmpty(str) && str.equals(JConstants.SDK_TYPE)) {
            if (i == 26) {
                k.a().b(context, j);
                return;
            } else if (i == 30 || i == 32) {
                cn.jiguang.e.a.b().a(context, i);
                return;
            } else {
                return;
            }
        }
        JDispatchAction jDispatchAction = a.get(str);
        if (jDispatchAction != null) {
            jDispatchAction.dispatchTimeOutMessage(context, str, j, i);
            return;
        }
        cn.jiguang.ar.c.g("DispatchActionManager", "not found dispatch action by sdktype:" + str);
    }

    public void a(Context context, String str, Bundle bundle) {
        if (bundle == null) {
            cn.jiguang.ar.c.h("DispatchActionManager", "run action bundle is null");
        } else if (TextUtils.isEmpty(str)) {
            cn.jiguang.ar.c.h("DispatchActionManager", "run action sdktype is empty");
        } else {
            if (JConstants.SDK_TYPE.contains(str)) {
                str = JConstants.SDK_TYPE;
            }
            JDispatchAction jDispatchAction = a.get(str);
            if (jDispatchAction != null) {
                jDispatchAction.onActionRun(context, str, bundle.getString("internal_action"), bundle);
                return;
            }
            cn.jiguang.ar.c.h("DispatchActionManager", "dispacth action is null by sdktype:" + str);
        }
    }

    public void a(String str, String str2) {
        cn.jiguang.ar.c.c("DispatchActionManager", "addAction type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (a.containsKey(str)) {
            cn.jiguang.ar.c.c("DispatchActionManager", "has same type action");
            return;
        }
        try {
            Object newInstance = Class.forName(str2).newInstance();
            if (newInstance instanceof JDispatchAction) {
                a.put(str, (JDispatchAction) newInstance);
                cn.jiguang.ar.c.c("DispatchActionManager", "action init:" + newInstance.getClass().getName());
            } else {
                cn.jiguang.ar.c.g("DispatchActionManager", "this action is not a JDispatchAction,please check and extends JDispatchAction");
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.h("DispatchActionManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }

    public void a(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            cn.jiguang.ar.c.g("DispatchActionManager", "init map is empty");
            return;
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }

    public boolean a(int i) {
        for (Map.Entry<String, JDispatchAction> entry : a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                try {
                    cn.jiguang.ar.c.d("DispatchActionManager", "isAllowAction actionType:" + i + ",sdktype:" + entry.getKey() + ",action:" + value.checkAction(entry.getKey(), i));
                    if (!value.checkAction(entry.getKey(), i)) {
                        return false;
                    }
                } catch (Throwable th) {
                    cn.jiguang.ar.c.g("DispatchActionManager", "isAllowAction error:" + th.getMessage());
                }
            }
        }
        return true;
    }

    public String b(int i) {
        for (Map.Entry<String, JDispatchAction> entry : a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null && value.getRegPriority(entry.getKey()) == i) {
                return value.getSdkVersion(entry.getKey());
            }
        }
        return "";
    }

    public String b(Context context) {
        for (Map.Entry<String, JDispatchAction> entry : a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                Object beforLogin = value.beforLogin(context, entry.getKey(), 24, "platformregid");
                if (beforLogin instanceof String) {
                    return (String) beforLogin;
                }
            }
        }
        return "";
    }

    public String b(String str, String str2) {
        String str3;
        JDispatchAction jDispatchAction = a.get(str);
        if (jDispatchAction != null) {
            String sdkVersion = jDispatchAction.getSdkVersion(str);
            if (!TextUtils.isEmpty(sdkVersion)) {
                return sdkVersion;
            }
            str3 = str + " sdk action sdkversion:" + sdkVersion;
        } else {
            str3 = str + " sdk action is null";
        }
        cn.jiguang.ar.c.a("DispatchActionManager", str3);
        return str2;
    }

    public short b() {
        short regFlag;
        short s = 0;
        for (Map.Entry<String, JDispatchAction> entry : a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null && (regFlag = value.getRegFlag(entry.getKey())) != 0) {
                s = (short) (s | regFlag);
            }
        }
        return s;
    }

    public short c() {
        short loginFlag;
        short s = 0;
        for (Map.Entry<String, JDispatchAction> entry : a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null && (loginFlag = value.getLoginFlag(entry.getKey())) != 0) {
                s = (short) (s | loginFlag);
            }
        }
        return s;
    }

    public Map<Integer, Bundle> d() {
        int i;
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, JDispatchAction> entry : a.entrySet()) {
            Bundle pInfo = entry.getValue().getPInfo(entry.getKey());
            if (pInfo != null && (i = pInfo.getInt("pid", 0)) > 0) {
                hashMap.put(Integer.valueOf(i), pInfo);
            }
        }
        return hashMap;
    }

    public String e() {
        StringBuilder sb;
        JDispatchAction value;
        short s = 3;
        for (Map.Entry<String, JDispatchAction> entry : a.entrySet()) {
            short regPriority = entry.getValue().getRegPriority(entry.getKey());
            if (s < regPriority) {
                s = regPriority;
            }
        }
        cn.jiguang.ar.c.c("DispatchActionManager", "max reg priority:" + ((int) s));
        String str = "";
        for (int i = 0; i <= s; i++) {
            if (i == 3) {
                sb = new StringBuilder();
                sb.append(str);
                str = cn.jiguang.a.a.b;
            } else {
                Iterator<Map.Entry<String, JDispatchAction>> it = a.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, JDispatchAction> next = it.next();
                    if (next.getValue().getRegPriority(next.getKey()) == i) {
                        str = str + value.getSdkVersion(next.getKey());
                        break;
                    }
                }
                sb = new StringBuilder();
            }
            sb.append(str);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            str = sb.toString();
        }
        return str.substring(0, str.length() - 1);
    }

    public String f() {
        JDispatchAction value;
        String str = a(cn.jiguang.a.a.b) + HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
        short s = 0;
        for (Map.Entry<String, JDispatchAction> entry : a.entrySet()) {
            short logPriority = entry.getValue().getLogPriority(entry.getKey());
            if (s < logPriority) {
                s = logPriority;
            }
        }
        cn.jiguang.ar.c.c("DispatchActionManager", "max login priority:" + ((int) s));
        for (int i = 1; i <= s; i++) {
            Iterator<Map.Entry<String, JDispatchAction>> it = a.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<String, JDispatchAction> next = it.next();
                    if (next.getValue().getLogPriority(next.getKey()) == i) {
                        str = str + a(value.getSdkVersion(next.getKey()));
                        break;
                    }
                }
            }
            str = str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
        }
        return str.substring(0, str.length() - 1);
    }
}
