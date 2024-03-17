package com.hunantv.oversea.channel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.mgtv.widget.MGRefreshLayout;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChannelRefreshLayout extends MGRefreshLayout {
    private boolean p3;

    public ChannelRefreshLayout(Context context) {
        super(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.p3) {
                return false;
            }
            return super/*com.scwang.smartrefresh.layout.SmartRefreshLayout*/.dispatchTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setAutoRefresh(boolean z) {
        this.p3 = z;
    }

    public ChannelRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChannelRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
