package cn.jiguang.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import cn.jiguang.a.a;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.aq.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ActionManager {
    private static final String TAG = "ActionManager";
    private static volatile ActionManager detachDataManager;
    private static final Object lock = new Object();
    private static HashMap<String, JDispatchAction> actionMap = new HashMap<>();
    private static HashMap<String, String> actionStringMap = new HashMap<>();

    public ActionManager() {
        c.a();
    }

    public static void addAction(String str, String str2) {
        Log.d(TAG, "addAction type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (actionMap.containsKey(str)) {
            cn.jiguang.ar.c.c(TAG, "has same type action");
            return;
        }
        try {
            Object newInstance = Class.forName(str2).newInstance();
            if (newInstance instanceof JDispatchAction) {
                actionStringMap.put(str, str2);
                actionMap.put(str, (JDispatchAction) newInstance);
            } else {
                cn.jiguang.ar.c.g(TAG, "this action is not a JDispatchAction,please check and extends JDispatchAction");
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.h(TAG, "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }

    public static HashMap<String, String> getActionMap() {
        return actionStringMap;
    }

    public static ActionManager getInstance() {
        if (detachDataManager == null) {
            synchronized (lock) {
                if (detachDataManager == null) {
                    detachDataManager = new ActionManager();
                }
            }
        }
        return detachDataManager;
    }

    public void handleMessage(Context context, String str, Object obj) {
        cn.jiguang.ar.c.a(TAG, "onSended type:" + str + ",actionMap size:" + actionMap.size());
        if (TextUtils.isEmpty(str)) {
            for (Map.Entry<String, JDispatchAction> entry : actionMap.entrySet()) {
                entry.getValue().handleMessage(context, entry.getKey(), obj);
            }
            return;
        }
        JDispatchAction jDispatchAction = actionMap.get(str);
        if (jDispatchAction != null) {
            jDispatchAction.handleMessage(context, str, obj);
        }
    }

    public Map<Integer, Bundle> loadPInfo() {
        int i;
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, JDispatchAction> entry : actionMap.entrySet()) {
            Bundle pInfo = entry.getValue().getPInfo(entry.getKey());
            if (pInfo != null && (i = pInfo.getInt("pid", 0)) > 0) {
                hashMap.put(Integer.valueOf(i), pInfo);
            }
        }
        return hashMap;
    }

    public boolean wrapSdkVersionInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            cn.jiguang.ar.c.g(TAG, "wrapSdkVersionInfo failed ,container is null");
            return false;
        }
        try {
            jSONObject.put("core_sdk_ver", a.b);
            for (Map.Entry<String, JDispatchAction> entry : actionMap.entrySet()) {
                JDispatchAction value = entry.getValue();
                jSONObject.put(value.getReportVersionKey(entry.getKey()), value.getSdkVersion(entry.getKey()));
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return true;
        }
    }
}
