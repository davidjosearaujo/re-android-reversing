package com.facebook.imagepipeline.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import androidx.annotation.RequiresApi;
import com.facebook.common.internal.Preconditions;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class RenderScriptBlurFilter {
    public static final int BLUR_MAX_RADIUS = 25;

    @RequiresApi(17)
    public static void blurBitmap(Bitmap bitmap, Bitmap bitmap2, Context context, int i) {
        Preconditions.checkNotNull(bitmap);
        Preconditions.checkNotNull(bitmap2);
        Preconditions.checkNotNull(context);
        Preconditions.checkArgument(i > 0 && i <= 25);
        RenderScript renderScript = null;
        try {
            renderScript = RenderScript.create(context);
            ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            Allocation createFromBitmap = Allocation.createFromBitmap(renderScript, bitmap2);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(renderScript, bitmap);
            create.setRadius(i);
            create.setInput(createFromBitmap);
            create.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(bitmap);
        } finally {
            if (renderScript != null) {
                renderScript.destroy();
            }
        }
    }

    public static boolean canUseRenderScript() {
        return Build.VERSION.SDK_INT >= 17;
    }
}
