package cn.jiguang.internal;

import android.content.Context;
import android.os.Bundle;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class JCoreHelperAction {
    public abstract Bundle directHandle(Context context, String str, String str2, Bundle bundle);

    public abstract Object onCommonMethod(Context context, String str, Object obj);

    public abstract Object onEvent(Context context, String str, int i, String str2, Bundle bundle, Object... objArr);
}
