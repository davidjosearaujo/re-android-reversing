package com.alibaba.android.arouter.facade.template;

import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface IInterceptorGroup {
    void loadInto(Map<Integer, Class<? extends IInterceptor>> map);
}
