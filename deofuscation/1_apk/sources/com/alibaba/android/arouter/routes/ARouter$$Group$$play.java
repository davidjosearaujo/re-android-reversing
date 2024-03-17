package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.hunantv.oversea.play.VodActivity;
import j.l.c.r.t.a;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ARouter$$Group$$play implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/play/VodActivity", RouteMeta.build(RouteType.ACTIVITY, VodActivity.class, "/play/vodactivity", "play", null, -1, Integer.MIN_VALUE));
        map.put("/play/provider", RouteMeta.build(RouteType.PROVIDER, a.class, "/play/provider", "play", null, -1, Integer.MIN_VALUE));
    }
}
