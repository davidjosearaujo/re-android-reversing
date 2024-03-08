package n4;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import o.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a extends w1.a {
    public static final Parcelable.Creator<a> CREATOR = new C0084a();

    /* renamed from: h  reason: collision with root package name */
    public final h<String, Bundle> f5178h;

    /* renamed from: n4.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class C0084a implements Parcelable.ClassLoaderCreator<a> {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            return new a(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i7) {
            return new a[i7];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader);
        }
    }

    public a() {
        throw null;
    }

    public a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f5178h = new h<>(readInt);
        for (int i7 = 0; i7 < readInt; i7++) {
            this.f5178h.put(strArr[i7], bundleArr[i7]);
        }
    }

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("ExtendableSavedState{");
        d7.append(Integer.toHexString(System.identityHashCode(this)));
        d7.append(" states=");
        d7.append(this.f5178h);
        d7.append("}");
        return d7.toString();
    }

    @Override // w1.a, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        parcel.writeParcelable(this.f6374f, i7);
        int i8 = this.f5178h.f5221h;
        parcel.writeInt(i8);
        String[] strArr = new String[i8];
        Bundle[] bundleArr = new Bundle[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            strArr[i9] = this.f5178h.h(i9);
            bundleArr[i9] = this.f5178h.l(i9);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }
}
