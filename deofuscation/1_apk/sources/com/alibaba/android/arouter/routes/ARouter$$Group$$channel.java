package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.hunantv.oversea.channel.dynamic.business.preview.ChannelPreviewActivity;
import com.hunantv.oversea.channel.dynamic.business.second.ChannelDynamicSecondActivity;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ARouter$$Group$$channel implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/channel/ChannelDynamicSecondActivity", RouteMeta.build(routeType, ChannelDynamicSecondActivity.class, "/channel/channeldynamicsecondactivity", "channel", null, -1, Integer.MIN_VALUE));
        map.put("/channel/ChannelPreviewActivity", RouteMeta.build(routeType, ChannelPreviewActivity.class, "/channel/channelpreviewactivity", "channel", null, -1, Integer.MIN_VALUE));
    }
}
