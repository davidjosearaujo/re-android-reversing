package com.hunantv.imgo.rv2vp;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.hunantv.imgo.nightmode.view.SkinnableRecyclerView;
import com.hunantv.media.player.MgtvMediaPlayer;
import j.l.a.a0.b;
import j.l.a.y.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AutoPlayRecyclerView extends SkinnableRecyclerView {
    private boolean a;
    private a b;

    public AutoPlayRecyclerView(Context context) {
        this(context, null);
    }

    public void d() {
        this.a = false;
        this.b.i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar;
        boolean dispatchTouchEvent = super/*android.view.ViewGroup*/.dispatchTouchEvent(motionEvent);
        if (this.a) {
            int action = motionEvent.getAction();
            if (action == 0) {
                a aVar2 = this.b;
                if (aVar2 != null) {
                    aVar2.i();
                }
            } else if (action == 1 && (aVar = this.b) != null) {
                aVar.l();
            }
            return dispatchTouchEvent;
        }
        return dispatchTouchEvent;
    }

    public void g() {
        this.a = true;
        this.b.l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void measureChild(View view, int i, int i2) {
        try {
            super/*android.view.ViewGroup*/.measureChild(view, i, i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void measureChildren(int i, int i2) {
        try {
            super/*android.view.ViewGroup*/.measureChildren(i, i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.destroyCallbacks();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            super.onLayout(z, i, i2, i3, i4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        this.b.attachToRecyclerView(this);
    }

    public AutoPlayRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoPlayRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.r.AutoPlayRecyclerView);
        int i2 = obtainStyledAttributes.getInt(b.r.AutoPlayRecyclerView_timeInterval, MgtvMediaPlayer.MainNotifyHandler.MSG_HTTPDNS_REPORT_PV);
        int i3 = obtainStyledAttributes.getInt(b.r.AutoPlayRecyclerView_direction, 2);
        obtainStyledAttributes.recycle();
        this.b = new a(i2, i3);
    }
}
