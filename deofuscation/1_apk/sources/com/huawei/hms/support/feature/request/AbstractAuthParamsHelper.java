package com.huawei.hms.support.feature.request;

import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class AbstractAuthParamsHelper {
    public Set<Scope> signInScopes = new HashSet();
    public Set<PermissionInfo> permissionSet = new HashSet();

    public AbstractAuthParamsHelper() {
    }

    public AbstractAuthParamsHelper(AbstractAuthParams abstractAuthParams) {
        this.signInScopes.addAll(abstractAuthParams.getRequestScopeList());
        this.permissionSet.addAll(abstractAuthParams.getPermissionInfos());
    }
}
