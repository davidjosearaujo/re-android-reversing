package cn.jpush.android.aa;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.TagAliasCallback;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.TagAliasReceiver;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    private static volatile c a;
    private static final Object d = new Object();
    private TagAliasReceiver b;
    private ConcurrentHashMap<Long, CallBackParams> c = new ConcurrentHashMap<>();
    private AtomicBoolean e = new AtomicBoolean(false);

    private c() {
    }

    public static c a() {
        if (a == null) {
            synchronized (d) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    private String a(CallBackParams callBackParams) {
        if (callBackParams == null) {
            Logger.w("TagAliasOperator", "callBack was null");
            return null;
        }
        try {
            Set<String> set = callBackParams.tags;
            if (set != null && set.size() > 0) {
                return (String) callBackParams.tags.toArray()[0];
            }
        } catch (Throwable th) {
            Logger.d("TagAliasOperator", "get origin check tag failed, error:" + th);
        }
        return null;
    }

    private void a(Context context, int i, long j) {
        String str;
        if (i == JPushInterface.ErrorCode.TIMEOUT) {
            str = "action - onTimeout rid:" + j;
        } else {
            str = "action - on send data over limit";
        }
        Logger.v("TagAliasOperator", str);
        CallBackParams a2 = a(j);
        if (a2 != null) {
            b(j);
            a(context, a2, i, false);
            return;
        }
        Logger.w("TagAliasOperator", "tagalias callback is null; rid=" + j);
    }

    private void a(Context context, int i, long j, Intent intent) {
        String str;
        Logger.v("TagAliasOperator", "SetAliasAndTags finish : errorCode:" + i + " rid:" + j);
        CallBackParams a2 = a(j);
        if (a2 == null) {
            Logger.w("TagAliasOperator", "tagalias callback is null; rid=" + j);
            return;
        }
        a().b(j);
        boolean z = false;
        if (intent != null) {
            try {
                int i2 = a2.action;
                if (i2 == 5) {
                    int i3 = a2.protoType;
                    if (i3 == 1) {
                        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tags");
                        if (stringArrayListExtra != null) {
                            a2.tags = new HashSet(stringArrayListExtra);
                            str = "all tags was loaded, value:" + a2.tags;
                        }
                    } else if (i3 == 2) {
                        a2.alias = intent.getStringExtra("alias");
                        str = "alias was loaded, value:" + a2.tags;
                    }
                    Logger.d("TagAliasOperator", str);
                } else if (i2 == 6) {
                    z = intent.getBooleanExtra("validated", false);
                }
            } catch (Throwable th) {
                Logger.d("TagAliasOperator", "get tag or alias failed - error:" + th);
            }
        }
        a(context, a2, i, z);
    }

    private void a(Context context, CallBackParams callBackParams, int i, boolean z) {
        Logger.d("TagAliasOperator", "action - invokeUserCallback, errorCode:" + i + ",callBack:" + callBackParams);
        if (callBackParams.protoType != 0) {
            Logger.w("TagAliasOperator", "new proto type do not call user callback");
            return;
        }
        TagAliasCallback tagAliasCallback = callBackParams.tagAliasCallBack;
        if (tagAliasCallback != null) {
            tagAliasCallback.gotResult(i, callBackParams.alias, callBackParams.tags);
        }
    }

    private void c(Context context) {
        ConcurrentHashMap<Long, CallBackParams> concurrentHashMap = this.c;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Long, CallBackParams> entry : this.c.entrySet()) {
            if (entry.getValue().isTimeOut(20000L)) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Long l = (Long) it.next();
            Logger.w("TagAliasOperator", "cleanTimeOutCallback timeout rid:" + l);
            a(context, JPushInterface.ErrorCode.TIMEOUT, l.longValue());
        }
    }

    public CallBackParams a(long j) {
        return this.c.get(Long.valueOf(j));
    }

    public JPushMessage a(Context context, Intent intent) {
        String str;
        long longExtra = intent.getLongExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_SEQID, -1L);
        boolean z = false;
        int intExtra = intent.getIntExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_CALLBACKCODE, 0);
        Logger.v("TagAliasOperator", "parseTagAliasResponse2JPushMessage, errorCode:" + intExtra + " rid:" + longExtra);
        CallBackParams a2 = a(longExtra);
        if (a2 == null) {
            Logger.w("TagAliasOperator", "tagalias callback is null; rid=" + longExtra);
            return null;
        }
        a().b(longExtra);
        if (intExtra == 0) {
            try {
                int i = a2.action;
                if (i == 5) {
                    int i2 = a2.protoType;
                    if (i2 == 1) {
                        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tags");
                        if (stringArrayListExtra != null) {
                            a2.tags = new HashSet(stringArrayListExtra);
                            str = "all tags was loaded, value:" + a2.tags;
                        }
                    } else if (i2 == 2) {
                        a2.alias = intent.getStringExtra("alias");
                        str = "alias was loaded, value:" + a2.tags;
                    }
                    Logger.d("TagAliasOperator", str);
                } else if (i == 6) {
                    z = intent.getBooleanExtra("validated", false);
                }
            } catch (Throwable th) {
                Logger.d("TagAliasOperator", "get tag or alias failed - error:" + th);
            }
        }
        JPushMessage jPushMessage = new JPushMessage();
        jPushMessage.setErrorCode(intExtra);
        jPushMessage.setSequence(a2.sequence);
        if (a2.protoType != 1) {
            jPushMessage.setAlias(a2.alias);
        } else if (a2.action == 6) {
            jPushMessage.setCheckTag(a(a2));
            jPushMessage.setTagCheckStateResult(z);
            jPushMessage.setTagCheckOperator(true);
        } else {
            jPushMessage.setTags(a2.tags);
        }
        return jPushMessage;
    }

    public synchronized void a(Context context) {
        if (this.e.get()) {
            Logger.d("TagAliasOperator", "tag alias callback register is called");
        } else {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addCategory(context.getPackageName());
                intentFilter.addAction(TagAliasReceiver.ACTION_TAG_ALIAS_TIMEOUT);
                intentFilter.addAction(TagAliasReceiver.ACTION_TAG_ALIAS_CALLBACK);
                if (this.b == null) {
                    this.b = new TagAliasReceiver();
                }
                TagAliasReceiver tagAliasReceiver = this.b;
                context.registerReceiver(tagAliasReceiver, intentFilter, context.getPackageName() + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX, null);
                this.e.set(true);
            } catch (Exception e) {
                Logger.e("TagAliasOperator", "setTagAndAlias e:" + e.getMessage());
            }
        }
    }

    public void a(Context context, long j, int i, Intent intent) {
        Logger.v("TagAliasOperator", "action - onTagAliasResponse rid:" + j + " tagAliasCallbacks :" + a().b());
        if (TagAliasReceiver.ACTION_TAG_ALIAS_TIMEOUT.equals(intent.getAction())) {
            a(context, i, j);
        } else {
            a(context, i, j, intent);
        }
        b(context);
    }

    public void a(Context context, Long l, CallBackParams callBackParams) {
        c(context);
        this.c.put(l, callBackParams);
    }

    public ConcurrentHashMap<Long, CallBackParams> b() {
        return this.c;
    }

    public void b(long j) {
        this.c.remove(Long.valueOf(j));
    }

    public synchronized void b(Context context) {
        String str;
        String str2;
        ConcurrentHashMap<Long, CallBackParams> concurrentHashMap;
        String str3;
        String str4;
        c(context);
        if (this.e.get() && (concurrentHashMap = this.c) != null && concurrentHashMap.isEmpty()) {
            try {
                TagAliasReceiver tagAliasReceiver = this.b;
                if (tagAliasReceiver != null) {
                    context.unregisterReceiver(tagAliasReceiver);
                    this.b = null;
                }
            } catch (IllegalArgumentException e) {
                e = e;
                str3 = "TagAliasOperator";
                str4 = "Receiver not registered, cannot call unregisterReceiver";
                Logger.ww(str3, str4, e);
                this.e.set(false);
                str = "TagAliasOperator";
                str2 = "unRegister tag alias callback";
                Logger.v(str, str2);
            } catch (Exception e2) {
                e = e2;
                str3 = "TagAliasOperator";
                str4 = "other exception";
                Logger.ww(str3, str4, e);
                this.e.set(false);
                str = "TagAliasOperator";
                str2 = "unRegister tag alias callback";
                Logger.v(str, str2);
            }
            this.e.set(false);
            str = "TagAliasOperator";
            str2 = "unRegister tag alias callback";
        } else {
            str = "TagAliasOperator";
            str2 = "tagAliasCallbacks is not empty";
        }
        Logger.v(str, str2);
    }
}
