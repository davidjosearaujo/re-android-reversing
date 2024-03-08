package v4;

import android.os.Parcel;
import android.os.Parcelable;
import g5.q;
import java.util.LinkedHashMap;
import java.util.Map;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0123a();

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, String> f6268f;

    /* renamed from: v4.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class C0123a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        public final a createFromParcel(Parcel parcel) {
            h.f(parcel, "parcel");
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
        h.f(map, "headers");
        this.f6268f = map;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && h.a(this.f6268f, ((a) obj).f6268f);
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.f6268f.hashCode();
    }

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("HeaderData(headers=");
        d7.append(this.f6268f);
        d7.append(')');
        return d7.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        h.f(parcel, "out");
        Map<String, String> map = this.f6268f;
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }
}
