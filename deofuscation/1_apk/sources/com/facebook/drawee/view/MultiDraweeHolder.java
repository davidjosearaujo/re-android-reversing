package com.facebook.drawee.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import java.util.ArrayList;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MultiDraweeHolder<DH extends DraweeHierarchy> {
    @VisibleForTesting
    public boolean mIsAttached = false;
    @VisibleForTesting
    public ArrayList<DraweeHolder<DH>> mHolders = new ArrayList<>();

    public void add(DraweeHolder<DH> draweeHolder) {
        add(this.mHolders.size(), draweeHolder);
    }

    public void clear() {
        if (this.mIsAttached) {
            for (int i = 0; i < this.mHolders.size(); i++) {
                this.mHolders.get(i).onDetach();
            }
        }
        this.mHolders.clear();
    }

    public void draw(Canvas canvas) {
        for (int i = 0; i < this.mHolders.size(); i++) {
            Drawable topLevelDrawable = get(i).getTopLevelDrawable();
            if (topLevelDrawable != null) {
                topLevelDrawable.draw(canvas);
            }
        }
    }

    public DraweeHolder<DH> get(int i) {
        return this.mHolders.get(i);
    }

    public void onAttach() {
        if (this.mIsAttached) {
            return;
        }
        this.mIsAttached = true;
        for (int i = 0; i < this.mHolders.size(); i++) {
            this.mHolders.get(i).onAttach();
        }
    }

    public void onDetach() {
        if (this.mIsAttached) {
            this.mIsAttached = false;
            for (int i = 0; i < this.mHolders.size(); i++) {
                this.mHolders.get(i).onDetach();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        for (int i = 0; i < this.mHolders.size(); i++) {
            if (this.mHolders.get(i).onTouchEvent(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    public void remove(int i) {
        DraweeHolder<DH> draweeHolder = this.mHolders.get(i);
        if (this.mIsAttached) {
            draweeHolder.onDetach();
        }
        this.mHolders.remove(i);
    }

    public int size() {
        return this.mHolders.size();
    }

    public boolean verifyDrawable(Drawable drawable) {
        for (int i = 0; i < this.mHolders.size(); i++) {
            if (drawable == get(i).getTopLevelDrawable()) {
                return true;
            }
        }
        return false;
    }

    public void add(int i, DraweeHolder<DH> draweeHolder) {
        Preconditions.checkNotNull(draweeHolder);
        Preconditions.checkElementIndex(i, this.mHolders.size() + 1);
        this.mHolders.add(i, draweeHolder);
        if (this.mIsAttached) {
            draweeHolder.onAttach();
        }
    }
}
