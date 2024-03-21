package a.a.a.e;

import a.a.a.e.b;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Field;
@TargetApi(11)
/* loaded from: /home/remnux/decompressedMalicious.dex */
class c {
    private static short[] $ = {1157, 1182, 1239, 1232, 1240, 1234, 1247, 1226, 1239, 1233, 1232, 1182, 1235, 1247, 1223, 1182, 1238, 1247, 1224, 1243, 1182, 1227, 1232, 1243, 1222, 1230, 1243, 1245, 1226, 1243, 1242, 1182, 1228, 1243, 1229, 1227, 1234, 1226, 1229, 1168, 3557, 3528, 3536, 3526, 3548, 3549, 3552, 3527, 3535, 3525, 3528, 3549, 3532, 3547, 3562, 3526, 3524, 3545, 3528, 3549, 3553, 3562, 518, 557, 522, 520, 543, 516, 537, 530, 601, 7894, 7903, 7874, 7891, 7893, 7907, 7893, 7876, 7926, 7889, 7891, 7876, 7903, 7874, 7881, 7810, 7824, 7923, 7903, 7877, 7900, 7892, 7824, 7902, 7903, 7876, 7824, 7894, 7897, 7902, 7892, 7824, 7894, 7897, 7893, 7900, 7892, 7824, 7831, 7901, 7926, 7889, 7891, 7876, 7903, 7874, 7881, 7810, 7831, 7824, 7903, 7902, 7824, 7891, 7900, 7889, 7875, 7875, 7824, 2698, 2691, 2718, 2703, 2697, 2751, 2697, 2712, 2730, 2701, 2703, 2712, 2691, 2718, 2709, 2782, 2764, 2703, 2691, 2713, 2688, 2696, 2764, 2690, 2691, 2712, 2764, 2719, 2697, 2712, 2764, 2712, 2692, 2697, 2764, 2730, 2701, 2703, 2712, 2691, 2718, 2709, 2782, 2764, 2691, 2690, 2764, 2720, 2701, 2709, 2691, 2713, 2712, 2725, 2690, 2698, 2688, 2701, 2712, 2697, 2718, 2764};

    /* renamed from: a */
    private static Field f110a;

    /* renamed from: b */
    private static boolean f111b;

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class a extends b.a implements LayoutInflater.Factory2 {
        public a(e eVar) {
            super(eVar);
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.f109a.onCreateView(view, str, context, attributeSet);
        }
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        boolean z = f111b;
        String $2 = $(0, 40, 1214);
        String $3 = $(40, 62, 3497);
        if (!z) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField($(62, 71, 619));
                f110a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e($3, $(71, 130, 7856) + LayoutInflater.class.getName() + $2, e);
            }
            f111b = true;
        }
        Field field = f110a;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.e($3, $(130, 192, 2796) + layoutInflater + $2, e2);
            }
        }
    }

    public static void b(LayoutInflater layoutInflater, e eVar) {
        a aVar = eVar != null ? new a(eVar) : null;
        layoutInflater.setFactory2(aVar);
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof LayoutInflater.Factory2) {
            a(layoutInflater, (LayoutInflater.Factory2) factory);
        } else {
            a(layoutInflater, aVar);
        }
    }
}
