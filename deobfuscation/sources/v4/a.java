package v4;

import android.os.Parcel;
import android.os.Parcelable;
import g5.q;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0123a();

    /* renamed from: f */
    public final Map<String, String> f6268f;

    /* renamed from: v4.a$a */
    /* loaded from: classes.dex */
    public static final class C0123a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        public final a createFromParcel(Parcel parcel) {
            r5.h.f(parcel, "parcel");
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i7 = 0; i7 != readInt; i7++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            return new a(linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        public final a[] newArray(int i7) {
            return new a[i7];
        }
    }

    public a() {
        this(0);
    }

    public /* synthetic */ a(int i7) {
        this(q.f4285f);
    }

    public a(Map<String, String> map) {
        r5.h.f(map, "headers");
        this.f6268f = map;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && r5.h.a(this.f6268f, ((a) obj).f6268f);
    }

    public final int hashCode() {
        return this.f6268f.hashCode();
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("HeaderData(headers=");
        d7.append(this.f6268f);
        d7.append(')');
        return d7.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        r5.h.f(parcel, "out");
        Map<String, String> map = this.f6268f;
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }
}
