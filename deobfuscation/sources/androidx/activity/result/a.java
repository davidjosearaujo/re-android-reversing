package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0006a();

    /* renamed from: f */
    public final int f439f;

    /* renamed from: g */
    public final Intent f440g;

    /* renamed from: androidx.activity.result.a$a */
    /* loaded from: classes.dex */
    public class C0006a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        public final a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final a[] newArray(int i7) {
            return new a[i7];
        }
    }

    public a(Intent intent, int i7) {
        this.f439f = i7;
        this.f440g = intent;
    }

    public a(Parcel parcel) {
        this.f439f = parcel.readInt();
        this.f440g = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("ActivityResult{resultCode=");
        int i7 = this.f439f;
        d7.append(i7 != -1 ? i7 != 0 ? String.valueOf(i7) : "RESULT_CANCELED" : "RESULT_OK");
        d7.append(", data=");
        d7.append(this.f440g);
        d7.append('}');
        return d7.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f439f);
        parcel.writeInt(this.f440g == null ? 0 : 1);
        Intent intent = this.f440g;
        if (intent != null) {
            intent.writeToParcel(parcel, i7);
        }
    }
}
