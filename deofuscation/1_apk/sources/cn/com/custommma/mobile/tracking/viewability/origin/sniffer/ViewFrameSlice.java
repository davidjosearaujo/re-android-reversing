package cn.com.custommma.mobile.tracking.viewability.origin.sniffer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import cn.com.custommma.mobile.tracking.api.Constant;
import cn.com.custommma.mobile.tracking.util.klog.KLog;
import cn.com.custommma.mobile.tracking.viewability.common.ViewHelper;
import cn.com.custommma.mobile.tracking.viewability.origin.support.AtlantisUtil;
import cn.com.custommma.mobile.tracking.viewability.origin.support.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ViewFrameSlice implements Serializable {
    private static final long serialVersionUID = 1;
    private String adSize;
    private float alpha;
    private long captureTime;
    private List<Rectangle> coverAreaList;
    public Set<String> coverFrameSet;
    private double coverRate;
    private int isForground;
    private boolean isWindowShowed;
    private int screenOn;
    private int shown;
    private int visibleAbility;
    private String visiblePoint;
    private String visibleSize;

    public ViewFrameSlice(View view, Context context) {
        Rect traverseParent;
        this.isWindowShowed = false;
        this.coverAreaList = null;
        this.coverFrameSet = null;
        try {
            this.captureTime = System.currentTimeMillis();
            this.coverAreaList = new ArrayList();
            this.coverFrameSet = new HashSet();
            this.adSize = view.getWidth() + "x" + view.getHeight();
            Rect viewInWindowRect = ViewHelper.getViewInWindowRect(view);
            Point point = new Point();
            point.x = viewInWindowRect.left;
            point.y = viewInWindowRect.top;
            this.visiblePoint = point.x + "x" + point.y;
            boolean checkFrameBounds = checkFrameBounds(view);
            if (!checkFrameBounds && (traverseParent = traverseParent(view, viewInWindowRect)) != null) {
                viewInWindowRect = traverseParent;
            }
            if (Build.VERSION.SDK_INT >= 11) {
                this.alpha = view.getAlpha();
            }
            this.shown = view.isShown() ? 1 : 0;
            Rect screenRect = ViewHelper.getScreenRect(context);
            Rect rect = new Rect();
            boolean intersect = rect.setIntersect(viewInWindowRect, screenRect);
            this.visibleSize = Math.abs(rect.right - rect.left) + "x" + Math.abs(rect.bottom - rect.top);
            boolean isShowing = isShowing(view);
            this.isWindowShowed = isShowing;
            if (!isShowing) {
                this.coverRate = 1.0d;
            } else {
                traverseParent(view);
                double calOverlapArea = this.coverAreaList.size() > 0 ? new AtlantisUtil().calOverlapArea(this.coverAreaList) : 0.0d;
                Rect rect2 = new Rect();
                view.getGlobalVisibleRect(rect2);
                double width = view.getWidth() * view.getHeight();
                double d = (rect2.right - rect2.left) * (rect2.bottom - rect2.top);
                Double.isNaN(width);
                Double.isNaN(d);
                Double.isNaN(width);
                double round = Math.round(((calOverlapArea + (width - d)) / width) * 100.0d);
                Double.isNaN(round);
                this.coverRate = round / 100.0d;
            }
            this.screenOn = ViewHelper.isScreenOn(view) ? 1 : 0;
            this.isForground = view.hasWindowFocus() ? 1 : 0;
            Rect rect3 = new Rect();
            view.getLocalVisibleRect(rect3);
            this.coverAreaList = null;
            this.coverFrameSet = null;
            KLog.i("=================ViewFrameSlice Constructor begin ======================");
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            KLog.i("density:" + displayMetrics.density + "  api:" + displayMetrics.densityDpi);
            StringBuilder sb = new StringBuilder();
            sb.append("screenRect:");
            sb.append(screenRect);
            KLog.i(sb.toString());
            KLog.i("adView local visible Rect:" + rect3);
            KLog.i("[2t] captureTime:" + this.captureTime);
            KLog.i("[2k] adView Size:" + this.adSize);
            KLog.i("[2d] adView visible left top Point:" + point);
            KLog.i("[2l] adView alpha:" + this.alpha);
            KLog.i("[2m] adView isShown:" + this.shown);
            KLog.i("[2o] adView visible Size:" + this.visibleSize);
            KLog.i("[2n] adView cover rate:" + this.coverRate);
            KLog.i("[2r] current Screen is Light:" + this.screenOn);
            KLog.i("[2s] adView is forground:" + this.isForground);
            KLog.i("[2f] current adView visible ability:" + this.visibleAbility);
            KLog.i("checkFrameBounds:" + checkFrameBounds);
            KLog.i("adView isIntersets :" + intersect + "    overlapRect:" + rect);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("adView window origin Rect:");
            sb2.append(viewInWindowRect);
            KLog.i(sb2.toString());
            KLog.i("=================ViewFrameSlice Constructor end ======================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean checkFrameBounds(View view) {
        Rect rect;
        try {
            rect = new Rect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view.getGlobalVisibleRect(rect, new Point()) && (rect.bottom - rect.top >= view.getMeasuredHeight()) && (rect.right - rect.left >= view.getMeasuredWidth());
    }

    @SuppressLint({"NewApi"})
    private void checkIntersects(View view, View view2) {
        int i;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        Point point = new Point();
        view2.getGlobalVisibleRect(rect2, point);
        if (!((Build.VERSION.SDK_INT < 18 || !(view2.getParent() instanceof ViewGroup) || (viewGroup = (ViewGroup) view2.getParent()) == null || !(viewGroup.getParent() instanceof ViewGroup) || (viewGroup2 = (ViewGroup) viewGroup.getParent()) == null) ? true : viewGroup2.getClipChildren())) {
            rect2.left = point.x;
            rect2.top = point.y;
        }
        int i2 = 0;
        if (view2.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup3 = (ViewGroup) view2.getParent();
            i2 = viewGroup3.getPaddingLeft();
            i = viewGroup3.getPaddingTop();
        } else {
            i = 0;
        }
        if (i2 != 0 || i != 0) {
            Rect rect3 = new Rect();
            view2.getLocalVisibleRect(rect3);
            rect2.left += rect3.left + i2;
            rect2.top += rect3.top + i;
        }
        if (Rect.intersects(rect, rect2)) {
            valOverlapRect(rect, rect2);
        }
    }

    private boolean checkVisibled(View view) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (view.getVisibility() != 0) {
            return false;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getBackground() == null || viewGroup.getChildCount() < 1) {
                return false;
            }
        }
        return view.getAlpha() > 0.1f;
    }

    private int indexOfViewInParent(View view, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (i < childCount && viewGroup.getChildAt(i) != view) {
            i++;
        }
        return i;
    }

    private boolean isShowing(View view) {
        return view.getGlobalVisibleRect(new Rect(), new Point());
    }

    private boolean isSubViewNormal(View view) {
        return view.getGlobalVisibleRect(new Rect()) && checkVisibled(view);
    }

    private void traverseParent(View view) {
        View view2 = view;
        while (view2.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int indexOfViewInParent = indexOfViewInParent(view2, viewGroup);
            int childCount = viewGroup.getChildCount();
            while (true) {
                indexOfViewInParent++;
                if (indexOfViewInParent < childCount) {
                    View childAt = viewGroup.getChildAt(indexOfViewInParent);
                    boolean isSubViewNormal = isSubViewNormal(childAt);
                    if (!isSubViewNormal) {
                        this.isWindowShowed = isSubViewNormal;
                    } else {
                        checkIntersects(view, childAt);
                        if (childAt instanceof ViewGroup) {
                            traverseSubviews(view, (ViewGroup) childAt, this.coverFrameSet);
                        }
                    }
                }
            }
            view2 = viewGroup;
        }
    }

    @SuppressLint({"NewApi"})
    private Rect traverseRootView(View view, Rect rect) {
        int i;
        ArrayList arrayList = new ArrayList();
        while (view.getParent() instanceof ViewGroup) {
            try {
                view = (ViewGroup) view.getParent();
                arrayList.add(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ViewGroup viewGroup = (ViewGroup) arrayList.get(size);
            viewGroup.getGlobalVisibleRect(new Rect());
            if ((Build.VERSION.SDK_INT > 18 ? viewGroup.getClipChildren() : true) && size - 1 >= 0) {
                Rect rect2 = new Rect();
                ((ViewGroup) arrayList.get(i)).getGlobalVisibleRect(rect2);
                Rect rect3 = new Rect();
                rect3.setIntersect(rect, rect2);
                Math.abs(rect3.right - rect3.left);
                Math.abs(rect3.bottom - rect3.top);
                rect = rect3;
            }
        }
        return rect;
    }

    private void valOverlapRect(Rect rect, Rect rect2) {
        int max = Math.max(rect.left, rect2.left);
        int max2 = Math.max(rect.top, rect2.top);
        int min = Math.min(rect.right, rect2.right);
        int min2 = Math.min(rect.bottom, rect2.bottom);
        int abs = Math.abs(min - max);
        int abs2 = Math.abs(min2 - max2);
        this.coverFrameSet.add(max + Constant.DIVIDE_MULT + max2 + Constant.DIVIDE_MULT + abs + Constant.DIVIDE_MULT + abs2);
        Rect rect3 = new Rect();
        rect3.setIntersect(rect, rect2);
        Rectangle rectangle = new Rectangle();
        rectangle.x1 = (double) rect3.left;
        rectangle.y1 = (double) rect3.top;
        rectangle.x2 = (double) rect3.right;
        rectangle.y2 = (double) rect3.bottom;
        this.coverAreaList.add(rectangle);
    }

    public String getAdSize() {
        return this.adSize;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public long getCaptureTime() {
        return this.captureTime;
    }

    public double getCoverRate() {
        return this.coverRate;
    }

    public int getIsForGround() {
        return this.isForground;
    }

    public int getScreenOn() {
        return this.screenOn;
    }

    public int getShown() {
        return this.shown;
    }

    public String getVisiblePoint() {
        return this.visiblePoint;
    }

    public String getVisibleSize() {
        return this.visibleSize;
    }

    public boolean isSameAs(ViewFrameSlice viewFrameSlice) {
        try {
            if (this.adSize.equals(viewFrameSlice.adSize) && this.visiblePoint.equals(viewFrameSlice.visiblePoint) && this.visibleSize.equals(viewFrameSlice.visibleSize) && Math.abs(this.alpha - viewFrameSlice.alpha) < 0.001d && this.shown == viewFrameSlice.shown && this.screenOn == viewFrameSlice.screenOn && this.isForground == viewFrameSlice.isForground) {
                return this.coverRate == viewFrameSlice.coverRate;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String toString() {
        return "[ 2t=" + this.captureTime + ",2k=" + this.adSize + ",2d=" + this.visiblePoint + ",2o=" + this.visibleSize + ",2n=" + this.coverRate + ",2l=" + this.alpha + ",2m=" + this.shown + ",2r=" + this.screenOn + ",2s=" + this.isForground + "]";
    }

    public void traverseSubviews(View view, ViewGroup viewGroup, Set<String> set) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (isSubViewNormal(childAt)) {
                checkIntersects(view, childAt);
                if (childAt instanceof ViewGroup) {
                    traverseSubviews(view, (ViewGroup) childAt, set);
                }
            }
        }
    }

    public boolean validateAdVisible(float f) {
        if (this.coverRate <= f && this.shown == 1 && this.alpha > 0.001d && this.screenOn == 1 && this.isForground == 1) {
            this.visibleAbility = 1;
        } else {
            this.visibleAbility = 0;
        }
        return this.visibleAbility == 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.view.ViewGroup] */
    @SuppressLint({"NewApi"})
    private Rect traverseParent(View view, Rect rect) {
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
