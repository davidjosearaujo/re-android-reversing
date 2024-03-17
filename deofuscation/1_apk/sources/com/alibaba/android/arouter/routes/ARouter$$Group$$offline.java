package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.hunantv.oversea.offline.ui.DownloadCachedActivity;
import com.hunantv.oversea.offline.ui.DownloadCachingActivity;
import com.hunantv.oversea.offline.ui.DownloadSubCachedActivity;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ARouter$$Group$$offline implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/offline/DownloadCachedActivity", RouteMeta.build(routeType, DownloadCachedActivity.class, "/offline/downloadcachedactivity", "offline", null, -1, Integer.MIN_VALUE));
        map.put("/offline/DownloadCachingActivity", RouteMeta.build(routeType, DownloadCachingActivity.class, "/offline/downloadcachingactivity", "offline", null, -1, Integer.MIN_VALUE));
        map.put("/offline/DownloadSubCachedActivity", RouteMeta.build(routeType, DownloadSubCachedActivity.class, "/offline/downloadsubcachedactivity", "offline", null, -1, Integer.MIN_VALUE));
    }
}
