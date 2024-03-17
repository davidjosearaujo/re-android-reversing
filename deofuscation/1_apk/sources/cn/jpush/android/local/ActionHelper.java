package cn.jpush.android.local;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.ac.e;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.api.TagAliasCallback;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.JPushMessageReceiver;
import java.util.Set;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ActionHelper {
    private static final String TAG = "ActionHelper";
    private static volatile ActionHelper actionHelper;
    private static final Object locker = new Object();
    private JPushAction jPushAction;
    private cn.jpush.android.y.a loadedResource;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends e {
        private Context b;
        private String c;
        private Object d;

        public a(Context context, String str, Object obj) {
            ActionHelper.this = r1;
            this.b = context;
            this.c = str;
            this.d = obj;
            this.f = "ActionHelper#Action";
        }

        @Override // cn.jpush.android.ac.e
        public void a() {
            try {
                ActionHelper.this.initLoad(this.b);
                ActionHelper.this.jPushAction.handleAction(this.b, this.c, this.d);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b extends e {
        private Context b;
        private String c;
        private int d;
        private Set<String> e;
        private CallBackParams g;

        public b(Context context, String str, Set<String> set, int i, CallBackParams callBackParams) {
            ActionHelper.this = r1;
            this.g = callBackParams;
            this.c = str;
            this.d = i;
            this.b = context;
            this.e = set;
            this.f = "ActionHelper#TagAliasAction";
        }

        @Override // cn.jpush.android.ac.e
        public void a() {
            try {
                ActionHelper.this.initLoad(this.b);
                ActionHelper.this.jPushAction.setAliasAndTags(this.b, this.c, this.e, this.g);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private ActionHelper() {
        JCoreManager.onEvent(null, JPushConstants.SDK_TYPE, 13, TAG, null, new Object[0]);
    }

    public static ActionHelper getInstance() {
        if (actionHelper == null) {
            synchronized (locker) {
                if (actionHelper == null) {
                    actionHelper = new ActionHelper();
                }
            }
        }
        return actionHelper;
    }

    public synchronized void initLoad(Context context) {
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            return;
        }
        if (jPushAction == null) {
            Logger.d(TAG, "load from local");
            this.jPushAction = new cn.jpush.android.l.a();
        }
    }

    public Object beforLogin(Context context, String str, int i, String str2) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            return jPushAction.beforLogin(context, str, i, str2);
        }
        return null;
    }

    public void doAction(Context context, String str, Object obj) {
        Logger.dd(TAG, "doAction:" + str);
        JCoreHelper.majorExecutor(context, TAG, new a(context, str, obj));
    }

    public void doSingleAction(Context context, String str, Object obj) {
        Logger.dd(TAG, "doSingleAction: " + str);
        JCoreHelper.futureExecutor(context, TAG, new a(context, str, obj));
    }

    public Class getClassInPlugin(String str) {
        return null;
    }

    public ProxyActivityAction getPopWinActivity(Context context) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            return jPushAction.getPopWinActivity(context);
        }
        return null;
    }

    public ProxyActivityAction getPushActivity(Context context) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            return jPushAction.getPushActivity(context);
        }
        return null;
    }

    public int getResourceID(Context context, String str, String str2, String str3) {
        return 0;
    }

    public String getSdkVersion(String str) {
        JPushAction jPushAction = this.jPushAction;
        return jPushAction != null ? jPushAction.getSdkVersion(str) : JPushConstants.SDK_VERSION_NAME;
    }

    public void handleNotificationIntent(Context context, Intent intent) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.handleNotificationIntent(context, intent);
        }
    }

    public boolean isSupportedCMD(String str, int i) {
        JPushAction jPushAction = this.jPushAction;
        return jPushAction != null ? jPushAction.isSupportedCMD(str, i) : i == 3 || i == 29 || i == 28 || i == 27 || i == 10 || i == 26 || i == 25 || i == 34 || i == 36 || i == 37;
    }

    public void onActivityLifeCallback(Activity activity, String str) {
        if (activity != null) {
            initLoad(activity.getApplicationContext());
            JPushAction jPushAction = this.jPushAction;
            if (jPushAction != null) {
                jPushAction.onActivityLifeCallback(activity, str);
            }
        }
    }

    public void onInAppMessageArrived(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onInAppMessageArrived(context, notificationMessage);
        }
    }

    public void onInAppMessageClick(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onInAppMessageClick(context, notificationMessage);
        }
    }

    public void onJPushMessageReceive(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onJPushMessageReceive(context, jPushMessageReceiver, intent);
        }
    }

    public void onMessage(Context context, CustomMessage customMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onMessage(context, customMessage);
        }
    }

    public void onMultiAction(Context context, Intent intent) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onMultiAction(context, intent);
        }
    }

    public void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onNotifyMessageArrived(context, notificationMessage);
        }
    }

    public void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onNotifyMessageOpened(context, notificationMessage);
        }
    }

    public void onTagAliasResponse(Context context, long j, int i, Intent intent) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onTagAliasResponse(context, j, i, intent);
        }
    }

    public void setAliasAndTagsWithCallBack(Context context, String str, Set<String> set, TagAliasCallback tagAliasCallback, int i, int i2) {
        JCoreHelper.majorExecutor(context, TAG, new b(context, str, set, 0, new CallBackParams(str, set, tagAliasCallback, System.currentTimeMillis(), i, i2)));
    }

    public void setAliasWithCallBack(Context context, int i, String str, int i2, int i3) {
        JCoreHelper.majorExecutor(context, TAG, new b(context, str, null, i, new CallBackParams(i, str, System.currentTimeMillis(), i2, i3)));
    }

    public void setTagsWithCallBack(Context context, int i, Set<String> set, int i2, int i3) {
        JCoreHelper.majorExecutor(context, TAG, new b(context, null, set, i, new CallBackParams(i, set, System.currentTimeMillis(), i2, i3)));
    }
}
