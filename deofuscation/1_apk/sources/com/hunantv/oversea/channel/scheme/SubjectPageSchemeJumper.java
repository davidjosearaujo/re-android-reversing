package com.hunantv.oversea.channel.scheme;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.auto.service.AutoService;
import com.hunantv.oversea.scheme.core.SchemeJumper;
import com.hunantv.oversea.scheme.core.config.ComponentConfigEntity;
import j.l.c.z.c.c;
import j.l.c.z.c.h.a;
import j.l.d.d;

@AutoService({SchemeJumper.class})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SubjectPageSchemeJumper implements SchemeJumper {
    private static final String ACTION_SUBJECTPAGE = "subjectpage";
    private static final String KEY_SUBJECT_ID = "subjectId";
    private ComponentConfigEntity mComponentConfigEntity;
    private String[] mHosts;

    private String getComponentPath(String str) {
        ComponentConfigEntity componentConfigEntity = this.mComponentConfigEntity;
        if (componentConfigEntity != null) {
            return componentConfigEntity.getComponentPath(str);
        }
        return null;
    }

    public String[] hosts() {
        if (this.mHosts == null) {
            if (this.mComponentConfigEntity == null) {
                this.mComponentConfigEntity = a.c(j.l.a.a.a(), "schema/MGChannelRouterConfig.yaml", true);
            }
            ComponentConfigEntity componentConfigEntity = this.mComponentConfigEntity;
            if (componentConfigEntity != null) {
                this.mHosts = componentConfigEntity.getPaths();
            }
        }
        return this.mHosts;
    }

    public boolean jump(Context context, Uri uri, Bundle bundle, c cVar) {
        if (uri == null || TextUtils.isEmpty(uri.getHost())) {
            return false;
        }
        String host = uri.getHost();
        host.hashCode();
        if (host.equals(ACTION_SUBJECTPAGE)) {
            String queryParameter = uri.getQueryParameter(KEY_SUBJECT_ID);
            if (TextUtils.isEmpty(queryParameter)) {
                queryParameter = uri.getQueryParameter(KEY_SUBJECT_ID.toLowerCase());
            }
            Log.w("Schema", "jump: subjectId=" + queryParameter + ", host = " + uri.getHost());
            if (TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            String componentPath = getComponentPath(host);
            if (!TextUtils.isEmpty(componentPath)) {
                new d.c().a(componentPath).h(bundle).p("bundle_channel_id", queryParameter).g().g(context);
            }
            return true;
        }
        return false;
    }
}
