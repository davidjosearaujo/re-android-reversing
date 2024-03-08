package h1;

import java.util.ArrayList;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f4351a;

    /* renamed from: b  reason: collision with root package name */
    public final float[] f4352b;

    public e(int i7, int i8) {
        this.f4351a = new int[]{i7, i8};
        this.f4352b = new float[]{0.0f, 1.0f};
    }

    public e(int i7, int i8, int i9) {
        this.f4351a = new int[]{i7, i8, i9};
        this.f4352b = new float[]{0.0f, 0.5f, 1.0f};
    }

    public e(ArrayList arrayList, ArrayList arrayList2) {
        int size = arrayList.size();
        this.f4351a = new int[size];
        this.f4352b = new float[size];
        for (int i7 = 0; i7 < size; i7++) {
            this.f4351a[i7] = ((Integer) arrayList.get(i7)).intValue();
            this.f4352b[i7] = ((Float) arrayList2.get(i7)).floatValue();
        }
    }
}
