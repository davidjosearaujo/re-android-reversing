package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import androidx.appcompat.widget.q0;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j {

    /* renamed from: b */
    public static final PorterDuff.Mode f939b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c */
    public static j f940c;

    /* renamed from: a */
    public q0 f941a;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements q0.b {

        /* renamed from: a */
        public final int[] f942a = {2131165301, 2131165299, 2131165225};

        /* renamed from: b */
        public final int[] f943b = {2131165249, 2131165284, 2131165256, 2131165251, 2131165252, 2131165255, 2131165254};

        /* renamed from: c */
        public final int[] f944c = {2131165298, 2131165300, 2131165242, 2131165294, 2131165295, 2131165296, 2131165297};

        /* renamed from: d */
        public final int[] f945d = {2131165274, 2131165240, 2131165273};
        public final int[] e = {2131165292, 2131165302};

        /* renamed from: f */
        public final int[] f946f = {2131165228, 2131165234, 2131165229, 2131165235};

        public static boolean a(int[] iArr, int i7) {
            for (int i8 : iArr) {
                if (i8 == i7) {
                    return true;
                }
            }
            return false;
        }

        public static ColorStateList b(Context context, int i7) {
            int c7 = v0.c(context, 2130903290);
            return new ColorStateList(new int[][]{v0.f1058b, v0.f1060d, v0.f1059c, v0.f1061f}, new int[]{v0.b(context, 2130903287), i1.a.b(c7, i7), i1.a.b(c7, i7), i7});
        }

        public static LayerDrawable c(q0 q0Var, Context context, int i7) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i7);
            Drawable e = q0Var.e(context, 2131165288);
            Drawable e7 = q0Var.e(context, 2131165289);
            if ((e instanceof BitmapDrawable) && e.getIntrinsicWidth() == dimensionPixelSize && e.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable2 = (BitmapDrawable) e;
                bitmapDrawable = new BitmapDrawable(bitmapDrawable2.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                e.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                e.draw(canvas);
                bitmapDrawable2 = new BitmapDrawable(createBitmap);
                bitmapDrawable = new BitmapDrawable(createBitmap);
            }
            bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
            if ((e7 instanceof BitmapDrawable) && e7.getIntrinsicWidth() == dimensionPixelSize && e7.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) e7;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                e7.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                e7.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable2, bitmapDrawable3, bitmapDrawable});
            layerDrawable.setId(0, 16908288);
            layerDrawable.setId(1, 16908303);
            layerDrawable.setId(2, 16908301);
            return layerDrawable;
        }

        public static void e(Drawable drawable, int i7, PorterDuff.Mode mode) {
            int[] iArr = h0.f914a;
            Drawable mutate = drawable.mutate();
            if (mode == null) {
                mode = j.f939b;
            }
            mutate.setColorFilter(j.c(i7, mode));
        }

        public final ColorStateList d(Context context, int i7) {
            if (i7 == 2131165245) {
                return g1.a.c(context, 2131034133);
            }
            if (i7 == 2131165291) {
                return g1.a.c(context, 2131034136);
            }
            if (i7 == 2131165290) {
                int[][] iArr = new int[3];
                int[] iArr2 = new int[3];
                ColorStateList d7 = v0.d(context, 2130903340);
                if (d7 == null || !d7.isStateful()) {
                    iArr[0] = v0.f1058b;
                    iArr2[0] = v0.b(context, 2130903340);
                    iArr[1] = v0.e;
                    iArr2[1] = v0.c(context, 2130903289);
                    iArr[2] = v0.f1061f;
                    iArr2[2] = v0.c(context, 2130903340);
                } else {
                    int[] iArr3 = v0.f1058b;
                    iArr[0] = iArr3;
                    iArr2[0] = d7.getColorForState(iArr3, 0);
                    iArr[1] = v0.e;
                    iArr2[1] = v0.c(context, 2130903289);
                    iArr[2] = v0.f1061f;
                    iArr2[2] = d7.getDefaultColor();
                }
                return new ColorStateList(iArr, iArr2);
            } else if (i7 == 2131165233) {
                return b(context, v0.c(context, 2130903287));
            } else {
                if (i7 == 2131165227) {
                    return b(context, 0);
                }
                if (i7 == 2131165232) {
                    return b(context, v0.c(context, 2130903285));
                }
                if (i7 == 2131165286 || i7 == 2131165287) {
                    return g1.a.c(context, 2131034135);
                }
                if (a(this.f943b, i7)) {
                    return v0.d(context, 2130903291);
                }
                if (a(this.e, i7)) {
                    return g1.a.c(context, 2131034132);
                }
                if (a(this.f946f, i7)) {
                    return g1.a.c(context, 2131034131);
                }
                if (i7 == 2131165283) {
                    return g1.a.c(context, 2131034134);
                }
                return null;
            }
        }
    }

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (f940c == null) {
                d();
            }
            jVar = f940c;
        }
        return jVar;
    }

    public static synchronized PorterDuffColorFilter c(int i7, PorterDuff.Mode mode) {
        PorterDuffColorFilter g2;
        synchronized (j.class) {
            g2 = q0.g(i7, mode);
        }
        return g2;
    }

    public static synchronized void d() {
        synchronized (j.class) {
            if (f940c == null) {
                j jVar = new j();
                f940c = jVar;
                jVar.f941a = q0.c();
                q0 q0Var = f940c.f941a;
                a aVar = new a();
                synchronized (q0Var) {
                    q0Var.e = aVar;
                }
            }
        }
    }

    public static void e(Drawable drawable, y0 y0Var, int[] iArr) {
        PorterDuff.Mode mode = q0.f1021f;
        int[] state = drawable.getState();
        int[] iArr2 = h0.f914a;
        if (!(drawable.mutate() == drawable)) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z6 = y0Var.f1075d;
        if (z6 || y0Var.f1074c) {
            PorterDuffColorFilter porterDuffColorFilter = null;
            ColorStateList colorStateList = z6 ? y0Var.f1072a : null;
            PorterDuff.Mode mode2 = y0Var.f1074c ? y0Var.f1073b : q0.f1021f;
            if (!(colorStateList == null || mode2 == null)) {
                porterDuffColorFilter = q0.g(colorStateList.getColorForState(iArr, 0), mode2);
            }
            drawable.setColorFilter(porterDuffColorFilter);
            return;
        }
        drawable.clearColorFilter();
    }

    public final synchronized Drawable b(Context context, int i7) {
        return this.f941a.e(context, i7);
    }
}
