package androidx.appcompat.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes.dex */
public class s {

    /* renamed from: c */
    public static final int[] f1028c = {16843067, 16843068};

    /* renamed from: a */
    public final ProgressBar f1029a;

    /* renamed from: b */
    public Bitmap f1030b;

    public s(ProgressBar progressBar) {
        this.f1029a = progressBar;
    }

    public void a(AttributeSet attributeSet, int i7) {
        a1 m = a1.m(this.f1029a.getContext(), attributeSet, f1028c, i7);
        Drawable f7 = m.f(0);
        if (f7 != null) {
            ProgressBar progressBar = this.f1029a;
            if (f7 instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) f7;
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                AnimationDrawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int i8 = 0; i8 < numberOfFrames; i8++) {
                    Drawable b2 = b(animationDrawable.getFrame(i8), true);
                    b2.setLevel(10000);
                    animationDrawable2.addFrame(b2, animationDrawable.getDuration(i8));
                }
                animationDrawable2.setLevel(10000);
                f7 = animationDrawable2;
            }
            progressBar.setIndeterminateDrawable(f7);
        }
        Drawable f8 = m.f(1);
        if (f8 != null) {
            this.f1029a.setProgressDrawable(b(f8, false));
        }
        m.n();
    }

    public final Drawable b(Drawable drawable, boolean z6) {
        if (drawable instanceof j1.b) {
            j1.b bVar = (j1.b) drawable;
            Drawable b2 = bVar.b();
            if (b2 != null) {
                bVar.a(b(b2, z6));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i7 = 0; i7 < numberOfLayers; i7++) {
                int id = layerDrawable.getId(i7);
                drawableArr[i7] = b(layerDrawable.getDrawable(i7), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i8 = 0; i8 < numberOfLayers; i8++) {
                layerDrawable2.setId(i8, layerDrawable.getId(i8));
                layerDrawable2.setLayerGravity(i8, layerDrawable.getLayerGravity(i8));
                layerDrawable2.setLayerWidth(i8, layerDrawable.getLayerWidth(i8));
                layerDrawable2.setLayerHeight(i8, layerDrawable.getLayerHeight(i8));
                layerDrawable2.setLayerInsetLeft(i8, layerDrawable.getLayerInsetLeft(i8));
                layerDrawable2.setLayerInsetRight(i8, layerDrawable.getLayerInsetRight(i8));
                layerDrawable2.setLayerInsetTop(i8, layerDrawable.getLayerInsetTop(i8));
                layerDrawable2.setLayerInsetBottom(i8, layerDrawable.getLayerInsetBottom(i8));
                layerDrawable2.setLayerInsetStart(i8, layerDrawable.getLayerInsetStart(i8));
                layerDrawable2.setLayerInsetEnd(i8, layerDrawable.getLayerInsetEnd(i8));
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f1030b == null) {
                this.f1030b = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z6 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }
}
