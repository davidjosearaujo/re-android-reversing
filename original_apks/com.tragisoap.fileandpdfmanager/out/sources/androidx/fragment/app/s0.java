package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import b6.a;
import b6.b;
import c0.i;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class s0 implements i {
    public static final void a(int i7, View view) {
        int i8;
        if (i7 != 0) {
            int i9 = i7 - 1;
            if (i9 != 0) {
                if (i9 == 1) {
                    if (x.K(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    i8 = 0;
                } else if (i9 == 2) {
                    if (x.K(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    i8 = 8;
                } else if (i9 == 3) {
                    if (x.K(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                    }
                    i8 = 4;
                } else {
                    return;
                }
                view.setVisibility(i8);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                if (x.K(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                }
                viewGroup.removeView(view);
                return;
            }
            return;
        }
        throw null;
    }

    public static int c(int i7) {
        if (i7 == 0) {
            return 2;
        }
        if (i7 == 4) {
            return 4;
        }
        if (i7 == 8) {
            return 3;
        }
        throw new IllegalArgumentException(g("Unknown visibility ", i7));
    }

    public static int d(View view) {
        if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
            return 4;
        }
        return c(view.getVisibility());
    }

    public static /* synthetic */ boolean e(int i7) {
        if (i7 == 1 || i7 == 2 || i7 == 3) {
            return false;
        }
        if (i7 == 4 || i7 == 5) {
            return true;
        }
        throw null;
    }

    public static float f(float f7, float f8, float f9, float f10) {
        return ((f7 - f8) * f9) + f10;
    }

    public static String g(String str, int i7) {
        return str + i7;
    }

    public static String h(String str, String str2) {
        return str + str2;
    }

    public static /* synthetic */ Iterator i() {
        try {
            return Arrays.asList(new b()).iterator();
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }

    public static /* synthetic */ void j(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static /* synthetic */ Iterator k() {
        try {
            return Arrays.asList(new a()).iterator();
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }

    public static /* synthetic */ String l(int i7) {
        return i7 == 1 ? "REMOVED" : i7 == 2 ? "VISIBLE" : i7 == 3 ? "GONE" : i7 == 4 ? "INVISIBLE" : "null";
    }

    public static /* synthetic */ String m(int i7) {
        return i7 == 1 ? "INITIALIZE" : i7 == 2 ? "SWITCH_TO_SOURCE_SERVICE" : i7 == 3 ? "DECODE_DATA" : "null";
    }

    public static /* synthetic */ String n(int i7) {
        return i7 == 1 ? "UNKNOWN" : i7 == 2 ? "HORIZONTAL_DIMENSION" : i7 == 3 ? "VERTICAL_DIMENSION" : i7 == 4 ? "LEFT" : i7 == 5 ? "RIGHT" : i7 == 6 ? "TOP" : i7 == 7 ? "BOTTOM" : i7 == 8 ? "BASELINE" : "null";
    }

    @Override // c0.i
    public double b(double d7) {
        double d8 = d7 < 0.0d ? -d7 : d7;
        return Math.copySign(d8 >= 0.04045d ? Math.pow((0.9478672985781991d * d8) + 0.05213270142180095d, 2.4d) : d8 * 0.07739938080495357d, d7);
    }
}
