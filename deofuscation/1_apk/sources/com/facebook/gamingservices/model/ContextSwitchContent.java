package com.facebook.gamingservices.model;

import android.os.Parcel;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class ContextSwitchContent implements ShareModel {
    @Nullable
    private final String contextID;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Builder implements ShareModelBuilder<ContextSwitchContent, Builder> {
        @Nullable
        private String contextID;

        public Builder setContextID(@Nullable String str) {
            this.contextID = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ContextSwitchContent build() {
            return new ContextSwitchContent(this);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(ContextSwitchContent contextSwitchContent) {
            return contextSwitchContent == null ? this : setContextID(contextSwitchContent.getContextID());
        }

        public Builder readFrom(Parcel parcel) {
            return readFrom((ContextSwitchContent) parcel.readParcelable(ContextSwitchContent.class.getClassLoader()));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getContextID() {
        return this.contextID;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.contextID);
    }

    private ContextSwitchContent(Builder builder) {
        this.contextID = builder.contextID;
    }

    public ContextSwitchContent(Parcel parcel) {
        this.contextID = parcel.readString();
    }
}
