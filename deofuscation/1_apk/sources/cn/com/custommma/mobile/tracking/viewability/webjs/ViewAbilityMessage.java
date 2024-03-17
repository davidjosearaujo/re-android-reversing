package cn.com.custommma.mobile.tracking.viewability.webjs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import cn.com.custommma.mobile.tracking.viewability.common.ViewHelper;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ViewAbilityMessage {
    private static final String ADVIEWABILITY_ALPHA = "AdviewabilityAlpha";
    private static final String ADVIEWABILITY_COVERRATE = "AdviewabilityCoverRate";
    private static final String ADVIEWABILITY_FORGROUND = "AdviewabilityForground";
    private static final String ADVIEWABILITY_FRAME = "AdviewabilityFrame";
    private static final String ADVIEWABILITY_LIGHT = "AdviewabilityLight";
    private static final String ADVIEWABILITY_POINT = "AdviewabilityPoint";
    private static final String ADVIEWABILITY_SHOWFRAME = "AdviewabilityShowFrame";
    private static final String ADVIEWABILITY_SHOWN = "AdviewabilityShown";
    private static final String ADVIEWABILITY_TIME = "AdviewabilityTime";
    public static final String ADVIEWABILITY_TYPE = "AdviewabilityType";

    private static boolean checkFrameBounds(View view) {
        Rect rect;
        try {
            rect = new Rect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view.getGlobalVisibleRect(rect, new Point()) && (rect.bottom - rect.top >= view.getMeasuredHeight()) && (rect.right - rect.left >= view.getMeasuredWidth());
    }

    public static JSONObject getEmptyViewAbilityEvents(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            int i = ViewHelper.isScreenOn(context) ? 1 : 0;
            jSONObject.put("AdviewabilityTime", String.valueOf(System.currentTimeMillis()));
            jSONObject.put("AdviewabilityLight", String.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject getViewAbilityEvents(android.content.Context r12, android.view.View r13) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.custommma.mobile.tracking.viewability.webjs.ViewAbilityMessage.getViewAbilityEvents(android.content.Context, android.view.View):org.json.JSONObject");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.view.ViewGroup] */
    @SuppressLint({"NewApi"})
    private static Rect traverseParent(View view, Rect rect) {
        while (view.getParent() instanceof ViewGroup) {
            try {
                view = (ViewGroup) view.getParent();
                Rect rect2 = new Rect();
                view.getGlobalVisibleRect(rect2);
                ViewGroup viewGroup = view.getParent() instanceof ViewGroup ? (ViewGroup) view.getParent() : null;
                boolean z = false;
                if (viewGroup != null && Build.VERSION.SDK_INT > 18) {
                    z = viewGroup.getClipChildren();
                }
                if (z) {
                    Rect rect3 = new Rect();
                    rect3.setIntersect(rect, rect2);
                    rect = rect3;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rect;
    }
}
