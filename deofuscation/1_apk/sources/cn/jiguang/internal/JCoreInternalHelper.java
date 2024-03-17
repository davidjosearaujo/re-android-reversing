package cn.jiguang.internal;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.a.a;
import cn.jiguang.ar.c;
import cn.jiguang.be.b;
import cn.jiguang.be.d;
import cn.jiguang.dy.JDynamicLoadBase;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class JCoreInternalHelper {
    private static final String TAG = "JCoreInternalHelper";
    private static JCoreHelperAction jCoreHelperAction;
    private static final Object locker = new Object();
    private static volatile JCoreInternalHelper mJCoreBridge;

    private JCoreInternalHelper() {
    }

    public static JCoreInternalHelper getInstance() {
        if (mJCoreBridge == null) {
            synchronized (locker) {
                if (mJCoreBridge == null) {
                    mJCoreBridge = new JCoreInternalHelper();
                }
            }
        }
        return mJCoreBridge;
    }

    public Object commonMethod(final Context context, final String str, final Object obj) {
        JCoreHelperAction jCoreHelperAction2 = jCoreHelperAction;
        if (jCoreHelperAction2 != null) {
            return jCoreHelperAction2.onCommonMethod(context, str, obj);
        }
        d.a("ONCE_TASK", new b("JCoreInternalHelper#commonMethod") { // from class: cn.jiguang.internal.JCoreInternalHelper.3
            {
                JCoreInternalHelper.this = this;
            }

            @Override // cn.jiguang.be.b
            public void a() {
                try {
                    JCoreInternalHelper.this.initLoad(context);
                    JCoreInternalHelper.jCoreHelperAction.onCommonMethod(context, str, obj);
                } catch (Throwable th) {
                    c.g(JCoreInternalHelper.TAG, "commonMethod e:" + th);
                }
            }
        });
        return null;
    }

    public Bundle directHandle(final Context context, final String str, final String str2, final Bundle bundle) {
        JCoreHelperAction jCoreHelperAction2 = jCoreHelperAction;
        if (jCoreHelperAction2 != null) {
            return jCoreHelperAction2.directHandle(context, str, str2, bundle);
        }
        d.a("ONCE_TASK", new b("JCoreInternalHelper#directHandle") { // from class: cn.jiguang.internal.JCoreInternalHelper.2
            {
                JCoreInternalHelper.this = this;
            }

            @Override // cn.jiguang.be.b
            public void a() {
                try {
                    JCoreInternalHelper.this.initLoad(context);
                    JCoreInternalHelper.jCoreHelperAction.directHandle(context, str, str2, bundle);
                } catch (Throwable th) {
                    c.g(JCoreInternalHelper.TAG, "directHandle e:" + th);
                }
            }
        });
        return new Bundle();
    }

    public synchronized void initLoad(Context context) {
        if (jCoreHelperAction != null) {
            return;
        }
        if (context == null) {
            return;
        }
        if (a.a()) {
            JDynamicLoadBase.getInstance().loadPlugin(context, 1);
        }
        if (jCoreHelperAction == null) {
            c.c(TAG, "load action by local");
            jCoreHelperAction = new cn.jiguang.c.b();
        }
    }

    public Object onEvent(final Context context, final String str, final int i, boolean z, final String str2, final Bundle bundle, final Object... objArr) {
        JCoreHelperAction jCoreHelperAction2 = jCoreHelperAction;
        if (jCoreHelperAction2 != null) {
            return jCoreHelperAction2.onEvent(context, str, i, str2, bundle, objArr);
        }
        if (z) {
            d.a("ONCE_TASK", new b("JCoreInternalHelper#onEvent") { // from class: cn.jiguang.internal.JCoreInternalHelper.1
                {
                    JCoreInternalHelper.this = this;
                }

                @Override // cn.jiguang.be.b
                public void a() {
                    try {
                        JCoreInternalHelper.this.initLoad(context);
                        JCoreInternalHelper.jCoreHelperAction.onEvent(context, str, i, str2, bundle, objArr);
                    } catch (Throwable th) {
                        c.g(JCoreInternalHelper.TAG, "onEvent e:" + th);
                    }
                }
            });
            return null;
        }
        return new cn.jiguang.c.b().onEvent(context, str, i, str2, bundle, objArr);
    }
}
