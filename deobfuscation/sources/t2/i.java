package t2;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a */
    public final int f6051a;

    /* renamed from: b */
    public final int f6052b;

    /* renamed from: c */
    public final int f6053c;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        public final Context f6054a;

        /* renamed from: b */
        public ActivityManager f6055b;

        /* renamed from: c */
        public b f6056c;

        /* renamed from: d */
        public float f6057d;

        public a(Context context) {
            this.f6057d = 1;
            this.f6054a = context;
            this.f6055b = (ActivityManager) context.getSystemService("activity");
            this.f6056c = new b(context.getResources().getDisplayMetrics());
            if (this.f6055b.isLowRamDevice()) {
                this.f6057d = 0.0f;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a */
        public final DisplayMetrics f6058a;

        public b(DisplayMetrics displayMetrics) {
            this.f6058a = displayMetrics;
        }
    }

    public i(a aVar) {
        ActivityManager activityManager;
        Context context = aVar.f6054a;
        int i7 = aVar.f6055b.isLowRamDevice() ? 2097152 : 4194304;
        this.f6053c = i7;
        int round = Math.round(activityManager.getMemoryClass() * 1024 * 1024 * (aVar.f6055b.isLowRamDevice() ? 0.33f : 0.4f));
        DisplayMetrics displayMetrics = aVar.f6056c.f6058a;
        float f7 = displayMetrics.widthPixels * displayMetrics.heightPixels * 4;
        int round2 = Math.round(aVar.f6057d * f7);
        int round3 = Math.round(f7 * 2.0f);
        int i8 = round - i7;
        int i9 = round3 + round2;
        if (i9 <= i8) {
            this.f6052b = round3;
            this.f6051a = round2;
        } else {
            float f8 = i8 / (aVar.f6057d + 2.0f);
            this.f6052b = Math.round(2.0f * f8);
            this.f6051a = Math.round(f8 * aVar.f6057d);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder d7 = androidx.activity.h.d("Calculation complete, Calculated memory cache size: ");
            d7.append(Formatter.formatFileSize(context, this.f6052b));
            d7.append(", pool size: ");
            d7.append(Formatter.formatFileSize(context, this.f6051a));
            d7.append(", byte array size: ");
            d7.append(Formatter.formatFileSize(context, i7));
            d7.append(", memory class limited? ");
            d7.append(i9 > round);
            d7.append(", max size: ");
            d7.append(Formatter.formatFileSize(context, round));
            d7.append(", memoryClass: ");
            d7.append(aVar.f6055b.getMemoryClass());
            d7.append(", isLowMemoryDevice: ");
            d7.append(aVar.f6055b.isLowRamDevice());
            Log.d("MemorySizeCalculator", d7.toString());
        }
    }
}
