package p;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import r5.h;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class y extends k0 implements Parcelable {
    public static final Parcelable.Creator<y> CREATOR = new a();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a implements Parcelable.Creator<y> {
        @Override // android.os.Parcelable.Creator
        public final y createFromParcel(Parcel parcel) {
            h.f(parcel, "parcel");
            return new y(parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public final y[] newArray(int i7) {
            return new y[i7];
        }
    }

    public y(float f7) {
        super(f7);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        h.f(parcel, "parcel");
        parcel.writeFloat(n());
    }
}
