package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h implements Parcelable {
    public static final Parcelable.Creator<h> CREATOR = new a();

    /* renamed from: f  reason: collision with root package name */
    public final IntentSender f456f;

    /* renamed from: g  reason: collision with root package name */
    public final Intent f457g;

    /* renamed from: h  reason: collision with root package name */
    public final int f458h;

    /* renamed from: i  reason: collision with root package name */
    public final int f459i;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a implements Parcelable.Creator<h> {
        @Override // android.os.Parcelable.Creator
        public final h createFromParcel(Parcel parcel) {
            r5.h.f(parcel, "inParcel");
            Parcelable readParcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
            r5.h.c(readParcelable);
            return new h((IntentSender) readParcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final h[] newArray(int i7) {
            return new h[i7];
        }
    }

    public h(IntentSender intentSender, Intent intent, int i7, int i8) {
        r5.h.f(intentSender, "intentSender");
        this.f456f = intentSender;
        this.f457g = intent;
        this.f458h = i7;
        this.f459i = i8;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        r5.h.f(parcel, "dest");
        parcel.writeParcelable(this.f456f, i7);
        parcel.writeParcelable(this.f457g, i7);
        parcel.writeInt(this.f458h);
        parcel.writeInt(this.f459i);
    }
}
