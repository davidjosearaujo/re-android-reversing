package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;

@Deprecated
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class LikeContent implements ShareModel {
    @Deprecated
    public static final Parcelable.Creator<LikeContent> CREATOR = new Parcelable.Creator<LikeContent>() { // from class: com.facebook.share.internal.LikeContent.1
        @Override // android.os.Parcelable.Creator
        public LikeContent createFromParcel(Parcel parcel) {
            return new LikeContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LikeContent[] newArray(int i) {
            return new LikeContent[i];
        }
    };
    private final String objectId;
    private final String objectType;

    @Deprecated
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Builder implements ShareModelBuilder<LikeContent, Builder> {
        private String objectId;
        private String objectType;

        @Deprecated
        public Builder setObjectId(String str) {
            this.objectId = str;
            return this;
        }

        @Deprecated
        public Builder setObjectType(String str) {
            this.objectType = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        @Deprecated
        public LikeContent build() {
            return new LikeContent(this);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        @Deprecated
        public Builder readFrom(LikeContent likeContent) {
            return likeContent == null ? this : setObjectId(likeContent.getObjectId()).setObjectType(likeContent.getObjectType());
        }
    }

    @Override // android.os.Parcelable
    @Deprecated
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getObjectId() {
        return this.objectId;
    }

    @Deprecated
    public String getObjectType() {
        return this.objectType;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.objectId);
        parcel.writeString(this.objectType);
    }

    private LikeContent(Builder builder) {
        this.objectId = builder.objectId;
        this.objectType = builder.objectType;
    }

    @Deprecated
    public LikeContent(Parcel parcel) {
        this.objectId = parcel.readString();
        this.objectType = parcel.readString();
    }
}
