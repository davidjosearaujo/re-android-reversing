package com.davemorrissey.labs.subscaleview;

import android.graphics.PointF;
import java.io.Serializable;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class ImageViewState implements Serializable {
    private final float centerX;
    private final float centerY;
    private final int orientation;
    private final float scale;

    public ImageViewState(float f7, PointF pointF, int i7) {
        this.scale = f7;
        this.centerX = pointF.x;
        this.centerY = pointF.y;
        this.orientation = i7;
    }

    public PointF getCenter() {
        return new PointF(this.centerX, this.centerY);
    }

    public int getOrientation() {
        return this.orientation;
    }

    public float getScale() {
        return this.scale;
    }
}
