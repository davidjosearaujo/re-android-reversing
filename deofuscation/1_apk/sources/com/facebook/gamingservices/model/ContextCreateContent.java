package com.facebook.gamingservices.model;

import android.os.Parcel;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ContextCreateContent implements ShareModel {
    @Nullable
    private final String suggestedPlayerIDs;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Builder implements ShareModelBuilder<ContextCreateContent, Builder> {
        @Nullable
        private String suggestedPlayerIDs;

        public Builder setSuggestedPlayerIDs(@Nullable String str) {
            this.suggestedPlayerIDs = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ContextCreateContent build() {
            return new ContextCreateContent(this);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(ContextCreateContent contextCreateContent) {
            return contextCreateContent == null ? this : setSuggestedPlayerIDs(contextCreateContent.getSuggestedPlayerIDs());
        }

        public Builder readFrom(Parcel parcel) {
            return readFrom((ContextCreateContent) parcel.readParcelable(ContextCreateContent.class.getClassLoader()));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getSuggestedPlayerIDs() {
        return this.suggestedPlayerIDs;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.suggestedPlayerIDs);
    }

    private ContextCreateContent(Builder builder) {
        this.suggestedPlayerIDs = builder.suggestedPlayerIDs;
    }

    public ContextCreateContent(Parcel parcel) {
        this.suggestedPlayerIDs = parcel.readString();
    }
}
