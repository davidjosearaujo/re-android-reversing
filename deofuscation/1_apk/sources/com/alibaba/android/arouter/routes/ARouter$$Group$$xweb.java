package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.hunantv.oversea.xweb.XWebActivity;
import j.l.c.i0.x.b;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ARouter$$Group$$xweb implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/xweb/XWebActivity", RouteMeta.build(RouteType.ACTIVITY, XWebActivity.class, "/xweb/xwebactivity", "xweb", null, -1, Integer.MIN_VALUE));
        map.put("/xweb/provider", RouteMeta.build(RouteType.PROVIDER, b.class, "/xweb/provider", "xweb", null, -1, Integer.MIN_VALUE));
    }
}
