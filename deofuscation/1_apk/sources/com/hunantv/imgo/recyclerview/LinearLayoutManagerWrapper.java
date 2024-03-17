package com.hunantv.imgo.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class LinearLayoutManagerWrapper extends LinearLayoutManager {
    private static final String b = "LinearLayoutManagerWrap";
    public volatile boolean a;

    public LinearLayoutManagerWrapper(Context context) {
        super(context);
        this.a = true;
    }

    public boolean canScrollVertically() {
        return this.a && super.canScrollVertically();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        try {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
        } catch (Exception e) {
            Log.e(b, "onInitializeAccessibilityEvent: ", e);
        }
    }

    public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        try {
            super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
        } catch (Exception e) {
            Log.e(b, "onInitializeAccessibilityNodeInfo: ", e);
        }
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e) {
            Log.e(b, "onLayoutChildren: ", e);
        }
    }

    public void onMeasure(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i, int i2) {
        try {
            super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.onMeasure(recycler, state, i, i2);
        } catch (Exception e) {
            Log.e(b, "onMeasure: ", e);
        }
    }

    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            return super.scrollHorizontallyBy(i, recycler, state);
        } catch (Exception e) {
            Log.e(b, "scrollHorizontallyBy: ", e);
            return 0;
        }
    }

    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            return super.scrollVerticallyBy(i, recycler, state);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(b, "scrollVerticallyBy: ", e);
            return 0;
        }
    }

    public LinearLayoutManagerWrapper(Context context, int i, boolean z) {
        super(context, i, z);
        this.a = true;
    }

    public void onInitializeAccessibilityEvent(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityEvent accessibilityEvent) {
        try {
            super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.onInitializeAccessibilityEvent(recycler, state, accessibilityEvent);
        } catch (Exception e) {
            Log.e(b, "onInitializeAccessibilityEvent: ", e);
        }
    }

    public LinearLayoutManagerWrapper(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = true;
    }
}
