package com.huawei.hms.support.feature.request;

import android.os.Bundle;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface AuthExtendedParams {
    public static final int FITNESS = 1;
    public static final int GAMES = 3;

    Bundle getExtendedBundle();

    int getExtendedParamType();

    List<Scope> getExtendedScopes();
}
