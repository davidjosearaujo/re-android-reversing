package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.hunantv.oversea.me.ui.area.MeAreaActivity;
import com.hunantv.oversea.me.ui.scan.ui.CaptureActivity;
import com.hunantv.oversea.me.ui.setting.MePrivacySettingActivity;
import com.hunantv.oversea.me.ui.setting.MeSettingActivity;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ARouter$$Group$$mgtv implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/mgtv/MeAreaActivity", RouteMeta.build(routeType, MeAreaActivity.class, "/mgtv/meareaactivity", "mgtv", null, -1, Integer.MIN_VALUE));
        map.put("/mgtv/MeLoginCaptureActivity", RouteMeta.build(routeType, CaptureActivity.class, "/mgtv/melogincaptureactivity", "mgtv", null, -1, Integer.MIN_VALUE));
        map.put("/mgtv/MePrivacySettingActivity", RouteMeta.build(routeType, MePrivacySettingActivity.class, "/mgtv/meprivacysettingactivity", "mgtv", null, -1, Integer.MIN_VALUE));
        map.put("/mgtv/MeSettingActivity", RouteMeta.build(routeType, MeSettingActivity.class, "/mgtv/mesettingactivity", "mgtv", null, -1, Integer.MIN_VALUE));
    }
}
