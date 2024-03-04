package p;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class z<T> extends l0<T> implements Parcelable {
    public static final Parcelable.Creator<z<Object>> CREATOR = new a();

    /* loaded from: classes.dex */
    public static final class a implements Parcelable.ClassLoaderCreator<z<Object>> {
        public static z a(Parcel parcel, ClassLoader classLoader) {
            m0 m0Var;
            r5.h.f(parcel, "parcel");
            if (classLoader == null) {
                classLoader = a.class.getClassLoader();
            }
            Object readValue = parcel.readValue(classLoader);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                m0Var = w.f5454a;
            } else if (readInt == 1) {
                m0Var = p0.f5447a;
            } else if (readInt != 2) {
                throw new IllegalStateException("Unsupported MutableState policy " + readInt + " was restored");
            } else {
                m0Var = h0.f5433a;
            }
            return new z(readValue, m0Var);
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            r5.h.f(parcel, "parcel");
            return a(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final /* bridge */ /* synthetic */ z<Object> createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return a(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i7) {
            return new z[i7];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(T t5, m0<T> m0Var) {
        super(t5, m0Var);
        r5.h.f(m0Var, "policy");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int i8;
        r5.h.f(parcel, "parcel");
        parcel.writeValue(getValue());
        m0<T> m0Var = this.f5439f;
        if (r5.h.a(m0Var, w.f5454a)) {
            i8 = 0;
        } else if (r5.h.a(m0Var, p0.f5447a)) {
            i8 = 1;
        } else if (!r5.h.a(m0Var, h0.f5433a)) {
            throw new IllegalStateException("Only known types of MutableState's SnapshotMutationPolicy are supported");
        } else {
            i8 = 2;
        }
        parcel.writeInt(i8);
    }
}
