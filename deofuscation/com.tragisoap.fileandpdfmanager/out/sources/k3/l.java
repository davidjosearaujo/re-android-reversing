package k3;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f4712a = "0123456789abcdef".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f4713b = new char[64];

    /* renamed from: c  reason: collision with root package name */
    public static volatile Handler f4714c;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f4715a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f4715a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4715a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4715a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4715a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4715a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void a() {
        if (!(Looper.myLooper() == Looper.getMainLooper())) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @TargetApi(19)
    public static int c(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        } else {
            throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
        }
    }

    public static int d(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i7 = a.f4715a[config.ordinal()];
        if (i7 == 1) {
            return 1;
        }
        if (i7 == 2 || i7 == 3) {
            return 2;
        }
        return i7 != 4 ? 4 : 8;
    }

    public static ArrayList e(Set set) {
        ArrayList arrayList = new ArrayList(set.size());
        for (Object obj : set) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Handler f() {
        if (f4714c == null) {
            synchronized (l.class) {
                if (f4714c == null) {
                    f4714c = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f4714c;
    }

    public static int g(int i7, Object obj) {
        return (i7 * 31) + (obj == null ? 0 : obj.hashCode());
    }

    public static int h(int i7, boolean z6) {
        return (i7 * 31) + (z6 ? 1 : 0);
    }

    public static boolean i(int i7, int i8) {
        if (!(i7 > 0 || i7 == Integer.MIN_VALUE)) {
            return false;
        }
        return i8 > 0 || i8 == Integer.MIN_VALUE;
    }
}
