package com.hunantv.imgo.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class GridLayoutManagerWrapper extends GridLayoutManager {
    public GridLayoutManagerWrapper(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        try {
            super/*androidx.recyclerview.widget.LinearLayoutManager*/.onInitializeAccessibilityEvent(accessibilityEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        try {
            super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GridLayoutManagerWrapper(Context context, int i) {
        super(context, i);
    }

    public GridLayoutManagerWrapper(Context context, int i, int i2, boolean z) {
        super(context, i, i2, z);
    }

    public void onInitializeAccessibilityEvent(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityEvent accessibilityEvent) {
        try {
            super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.onInitializeAccessibilityEvent(recycler, state, accessibilityEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
