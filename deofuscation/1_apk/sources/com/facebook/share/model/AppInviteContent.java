package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.AccessToken;

@Deprecated
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class AppInviteContent implements ShareModel {
    @Deprecated
    public static final Parcelable.Creator<AppInviteContent> CREATOR = new Parcelable.Creator<AppInviteContent>() { // from class: com.facebook.share.model.AppInviteContent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppInviteContent createFromParcel(Parcel parcel) {
            return new AppInviteContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppInviteContent[] newArray(int i) {
            return new AppInviteContent[i];
        }
    };
    private final String applinkUrl;
    private final Builder.Destination destination;
    private final String previewImageUrl;
    private final String promoCode;
    private final String promoText;

    @Deprecated
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Builder implements ShareModelBuilder<AppInviteContent, Builder> {
        private String applinkUrl;
        private Destination destination;
        private String previewImageUrl;
        private String promoCode;
        private String promoText;

        @Deprecated
        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public enum Destination {
            FACEBOOK(AccessToken.DEFAULT_GRAPH_DOMAIN),
            MESSENGER("messenger");
            
            private final String name;

            Destination(String str) {
                this.name = str;
            }

            public boolean equalsName(String str) {
                if (str == null) {
                    return false;
                }
                return this.name.equals(str);
            }

            @Override // java.lang.Enum
            public String toString() {
                return this.name;
            }
        }

        private boolean isAlphanumericWithSpaces(String str) {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (!Character.isDigit(charAt) && !Character.isLetter(charAt) && !Character.isSpaceChar(charAt)) {
                    return false;
                }
            }
            return true;
        }

        @Deprecated
        public Builder setApplinkUrl(String str) {
            this.applinkUrl = str;
            return this;
        }

        @Deprecated
        public Builder setDestination(Destination destination) {
            this.destination = destination;
            return this;
        }

        @Deprecated
        public Builder setPreviewImageUrl(String str) {
            this.previewImageUrl = str;
            return this;
        }

        @Deprecated
        public Builder setPromotionDetails(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (str.length() <= 80) {
                    if (isAlphanumericWithSpaces(str)) {
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.length() <= 10) {
                                if (!isAlphanumericWithSpaces(str2)) {
                                    throw new IllegalArgumentException("Invalid promotion code, promotionCode can only contain alphanumeric characters and spaces.");
                                }
                            } else {
                                throw new IllegalArgumentException("Invalid promotion code, promotionCode can be between1 and 10 characters long");
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid promotion text, promotionText can only contain alphanumericcharacters and spaces.");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid promotion text, promotionText needs to be between1 and 80 characters long");
                }
            } else if (!TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("promotionCode cannot be specified without a valid promotionText");
            }
            this.promoCode = str2;
            this.promoText = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        @Deprecated
        public AppInviteContent build() {
            return new AppInviteContent(this);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        @Deprecated
        public Builder readFrom(AppInviteContent appInviteContent) {
            return appInviteContent == null ? this : setApplinkUrl(appInviteContent.getApplinkUrl()).setPreviewImageUrl(appInviteContent.getPreviewImageUrl()).setPromotionDetails(appInviteContent.getPromotionText(), appInviteContent.getPromotionCode()).setDestination(appInviteContent.getDestination());
        }
    }

    @Override // android.os.Parcelable
    @Deprecated
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getApplinkUrl() {
        return this.applinkUrl;
    }

    @Deprecated
    public Builder.Destination getDestination() {
        Builder.Destination destination = this.destination;
        return destination != null ? destination : Builder.Destination.FACEBOOK;
    }

    @Deprecated
    public String getPreviewImageUrl() {
        return this.previewImageUrl;
    }

    @Deprecated
    public String getPromotionCode() {
        return this.promoCode;
    }

    @Deprecated
    public String getPromotionText() {
        return this.promoText;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.applinkUrl);
        parcel.writeString(this.previewImageUrl);
        parcel.writeString(this.promoText);
        parcel.writeString(this.promoCode);
        parcel.writeString(this.destination.toString());
    }

    private AppInviteContent(Builder builder) {
        this.applinkUrl = builder.applinkUrl;
        this.previewImageUrl = builder.previewImageUrl;
        this.promoCode = builder.promoCode;
        this.promoText = builder.promoText;
        this.destination = builder.destination;
    }

    @Deprecated
    public AppInviteContent(Parcel parcel) {
        this.applinkUrl = parcel.readString();
        this.previewImageUrl = parcel.readString();
        this.promoText = parcel.readString();
        this.promoCode = parcel.readString();
        String readString = parcel.readString();
        if (readString.length() > 0) {
            this.destination = Builder.Destination.valueOf(readString);
        } else {
            this.destination = Builder.Destination.FACEBOOK;
        }
    }
}
