package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.RectF;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    public int f883a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f884b = false;

    /* renamed from: c  reason: collision with root package name */
    public float f885c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f886d = -1.0f;
    public float e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    public int[] f887f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public boolean f888g = false;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f889h;

    /* renamed from: i  reason: collision with root package name */
    public final Context f890i;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends c {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b extends a {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c {
    }

    static {
        new RectF();
        new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    public d0(TextView textView) {
        this.f889h = textView;
        this.f890i = textView.getContext();
        new b();
    }

    public static int[] a(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i7 : iArr) {
            if (i7 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i7)) < 0) {
                arrayList.add(Integer.valueOf(i7));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i8 = 0; i8 < size; i8++) {
            iArr2[i8] = ((Integer) arrayList.get(i8)).intValue();
        }
        return iArr2;
    }

    public final boolean b() {
        if (!d() || this.f883a != 1) {
            this.f884b = false;
        } else {
            if (!this.f888g || this.f887f.length == 0) {
                int floor = ((int) Math.floor((double) ((this.e - this.f886d) / this.f885c))) + 1;
                int[] iArr = new int[floor];
                for (int i7 = 0; i7 < floor; i7++) {
                    iArr[i7] = Math.round((((float) i7) * this.f885c) + this.f886d);
                }
                this.f887f = a(iArr);
            }
            this.f884b = true;
        }
        return this.f884b;
    }

    public final boolean c() {
        int[] iArr = this.f887f;
        int length = iArr.length;
        boolean z6 = length > 0;
        this.f888g = z6;
        if (z6) {
            this.f883a = 1;
            this.f886d = (float) iArr[0];
            this.e = (float) iArr[length - 1];
            this.f885c = -1.0f;
        }
        return z6;
    }

    public final boolean d() {
        return !(this.f889h instanceof k);
    }

    public final void e(float f7, float f8, float f9) {
        if (f7 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f7 + "px) is less or equal to (0px)");
        } else if (f8 <= f7) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f8 + "px) is less or equal to minimum auto-size text size (" + f7 + "px)");
        } else if (f9 > 0.0f) {
            this.f883a = 1;
            this.f886d = f7;
            this.e = f8;
            this.f885c = f9;
            this.f888g = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f9 + "px) is less or equal to (0px)");
        }
    }
}
