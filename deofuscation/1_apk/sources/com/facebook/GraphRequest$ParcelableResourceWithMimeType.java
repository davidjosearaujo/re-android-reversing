package com.facebook;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import n.b0;
import n.l2.v.f0;
import n.l2.v.u;
import r.e.a.d;
import r.e.a.e;

/* compiled from: GraphRequest.kt */
@b0(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u0015*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0002:\u0001\u0015B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0012\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/facebook/GraphRequest$ParcelableResourceWithMimeType;", "RESOURCE", "Landroid/os/Parcelable;", "resource", "mimeType", "", "(Landroid/os/Parcelable;Ljava/lang/String;)V", ShareConstants.FEED_SOURCE_PARAM, "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getMimeType", "()Ljava/lang/String;", "getResource", "()Landroid/os/Parcelable;", "Landroid/os/Parcelable;", "describeContents", "", "writeToParcel", "", "out", "flags", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class GraphRequest$ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {
    @e
    private final String mimeType;
    @e
    private final RESOURCE resource;
    @d
    public static final Companion Companion = new Companion(null);
    @n.l2.d
    @d
    public static final Parcelable.Creator<GraphRequest$ParcelableResourceWithMimeType<?>> CREATOR = new Parcelable.Creator<GraphRequest$ParcelableResourceWithMimeType<?>>() { // from class: com.facebook.GraphRequest$ParcelableResourceWithMimeType$Companion$CREATOR$1
        @Override // android.os.Parcelable.Creator
        @d
        public GraphRequest$ParcelableResourceWithMimeType<?> createFromParcel(@d Parcel parcel) {
            f0.p(parcel, ShareConstants.FEED_SOURCE_PARAM);
            return new GraphRequest$ParcelableResourceWithMimeType<>(parcel, (u) null);
        }

        @Override // android.os.Parcelable.Creator
        @d
        public GraphRequest$ParcelableResourceWithMimeType<?>[] newArray(int i) {
            return new GraphRequest$ParcelableResourceWithMimeType[i];
        }
    };

    /* compiled from: GraphRequest.kt */
    @b0(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/GraphRequest$ParcelableResourceWithMimeType$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/GraphRequest$ParcelableResourceWithMimeType;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    public /* synthetic */ GraphRequest$ParcelableResourceWithMimeType(Parcel parcel, u uVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    @e
    public final String getMimeType() {
        return this.mimeType;
    }

    @e
    public final RESOURCE getResource() {
        return this.resource;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i) {
        f0.p(parcel, "out");
        parcel.writeString(this.mimeType);
        parcel.writeParcelable(this.resource, i);
    }

    public GraphRequest$ParcelableResourceWithMimeType(RESOURCE resource, @e String str) {
        this.mimeType = str;
        this.resource = resource;
    }

    private GraphRequest$ParcelableResourceWithMimeType(Parcel parcel) {
        this.mimeType = parcel.readString();
        Context applicationContext = FacebookSdk.getApplicationContext();
        f0.o(applicationContext, "FacebookSdk.getApplicationContext()");
        this.resource = (RESOURCE) parcel.readParcelable(applicationContext.getClassLoader());
    }
}
