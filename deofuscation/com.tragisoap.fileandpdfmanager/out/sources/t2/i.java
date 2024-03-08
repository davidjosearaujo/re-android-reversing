package t2;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.activity.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final int f6051a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6052b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6053c;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Context f6054a;

        /* renamed from: b  reason: collision with root package name */
        public ActivityManager f6055b;

        /* renamed from: c  reason: collision with root package name */
        public b f6056c;

        /* renamed from: d  reason: collision with root package name */
        public float f6057d;

        public a(Context context) {
            this.f6057d = (float) 1;
            this.f6054a = context;
            this.f6055b = (ActivityManager) context.getSystemService("activity");
            this.f6056c = new b(context.getResources().getDisplayMetrics());
            if (this.f6055b.isLowRamDevice()) {
                this.f6057d = 0.0f;
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final DisplayMetrics f6058a;

        public b(DisplayMetrics displayMetrics) {
            this.f6058a = displayMetrics;
        }
    }

    public i(a aVar) {
        Context context = aVar.f6054a;
        int i7 = aVar.f6055b.isLowRamDevice() ? 2097152 : 4194304;
        this.f6053c = i7;
        ActivityManager activityManager = aVar.f6055b;
        float f7 = 0.4f;
        f7 = 0.33f;
        boolean isLowRamDevice = activityManager.isLowRamDevice();
        float memoryClass = (float) (activityManager.getMemoryClass() * 1024 * 1024);
        if (isLowRamDevice) {
        }
        int round = Math.round(memoryClass * f7);
        DisplayMetrics displayMetrics = aVar.f6056c.f6058a;
        float f8 = (float) (displayMetrics.widthPixels * displayMetrics.heightPixels * 4);
        int round2 = Math.round(aVar.f6057d * f8);
        int round3 = Math.round(f8 * 2.0f);
        int i8 = round - i7;
        int i9 = round3 + round2;
        if (i9 <= i8) {
            this.f6052b = round3;
            this.f6051a = round2;
        } else {
            float f9 = ((float) i8) / (aVar.f6057d + 2.0f);
            this.f6052b = Math.round(2.0f * f9);
            this.f6051a = Math.round(f9 * aVar.f6057d);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder d7 = h.d("Calculation complete, Calculated memory cache size: ");
            d7.append(Formatter.formatFileSize(context, (long) this.f6052b));
            d7.append(", pool size: ");
            d7.append(Formatter.formatFileSize(context, (long) this.f6051a));
            d7.append(", byte array size: ");
            d7.append(Formatter.formatFileSize(context, (long) i7));
            d7.append(", memory class limited? ");
            d7.append(i9 > round);
            d7.append(", max size: ");
            d7.append(Formatter.formatFileSize(context, (long) round));
            d7.append(", memoryClass: ");
            d7.append(aVar.f6055b.getMemoryClass());
            d7.append(", isLowMemoryDevice: ");
            d7.append(aVar.f6055b.isLowRamDevice());
            Log.d("MemorySizeCalculator", d7.toString());
        }
    }
}
