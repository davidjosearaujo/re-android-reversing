package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.hunantv.oversea.playcommonbus.MyCollectionActivity;
import com.hunantv.oversea.playcommonbus.MyDownloadActivity;
import com.hunantv.oversea.playcommonbus.PlayRecordActivity;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ARouter$$Group$$playCommonBus implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/playCommonBus/MyCollectionActivity", RouteMeta.build(routeType, MyCollectionActivity.class, "/playcommonbus/mycollectionactivity", "playcommonbus", null, -1, Integer.MIN_VALUE));
        map.put("/playCommonBus/MyDownloadActivity", RouteMeta.build(routeType, MyDownloadActivity.class, "/playcommonbus/mydownloadactivity", "playcommonbus", null, -1, Integer.MIN_VALUE));
        map.put("/playCommonBus/PlayRecordActivity", RouteMeta.build(routeType, PlayRecordActivity.class, "/playcommonbus/playrecordactivity", "playcommonbus", null, -1, Integer.MIN_VALUE));
    }
}
