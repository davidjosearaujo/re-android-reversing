package com.facebook.bolts;

import android.net.Uri;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.util.Collections;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import n.b0;
import n.l2.v.f0;
import r.e.a.d;
import r.e.a.e;

/* compiled from: AppLink.kt */
@b0(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u000eB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/facebook/bolts/AppLink;", "", "sourceUrl", "Landroid/net/Uri;", "targets", "", "Lcom/facebook/bolts/AppLink$Target;", "webUrl", "(Landroid/net/Uri;Ljava/util/List;Landroid/net/Uri;)V", "getSourceUrl", "()Landroid/net/Uri;", "getTargets", "()Ljava/util/List;", "getWebUrl", "Target", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class AppLink {
    @d
    private final Uri sourceUrl;
    @d
    private final List<Target> targets;
    @d
    private final Uri webUrl;

    /* compiled from: AppLink.kt */
    @b0(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/facebook/bolts/AppLink$Target;", "", CommonConstant.ReqAccessTokenParam.PACKAGE_NAME, "", "className", "url", "Landroid/net/Uri;", "appName", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "getClassName", "getPackageName", "getUrl", "()Landroid/net/Uri;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class Target {
        @d
        private final String appName;
        @d
        private final String className;
        @d
        private final String packageName;
        @d
        private final Uri url;

        public Target(@d String str, @d String str2, @d Uri uri, @d String str3) {
            f0.p(str, CommonConstant.ReqAccessTokenParam.PACKAGE_NAME);
            f0.p(str2, "className");
            f0.p(uri, "url");
            f0.p(str3, "appName");
            this.packageName = str;
            this.className = str2;
            this.url = uri;
            this.appName = str3;
        }

        @d
        public final String getAppName() {
            return this.appName;
        }

        @d
        public final String getClassName() {
            return this.className;
        }

        @d
        public final String getPackageName() {
            return this.packageName;
        }

        @d
        public final Uri getUrl() {
            return this.url;
        }
    }

    public AppLink(@d Uri uri, @e List<Target> list, @d Uri uri2) {
        f0.p(uri, "sourceUrl");
        f0.p(uri2, "webUrl");
        this.sourceUrl = uri;
        this.webUrl = uri2;
        this.targets = list == null ? CollectionsKt__CollectionsKt.E() : list;
    }

    @d
    public final Uri getSourceUrl() {
        return this.sourceUrl;
    }

    @d
    public final List<Target> getTargets() {
        List<Target> unmodifiableList = Collections.unmodifiableList(this.targets);
        f0.o(unmodifiableList, "Collections.unmodifiableList(field)");
        return unmodifiableList;
    }

    @d
    public final Uri getWebUrl() {
        return this.webUrl;
    }
}
