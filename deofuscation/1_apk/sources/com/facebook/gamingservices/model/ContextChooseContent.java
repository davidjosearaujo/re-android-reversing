package com.facebook.gamingservices.model;

import android.os.Parcel;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ContextChooseContent implements ShareModel {
    @Nullable
    private final List<String> filters;
    @Nullable
    private final Integer maxSize;
    @Nullable
    private final Integer minSize;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Builder implements ShareModelBuilder<ContextChooseContent, Builder> {
        @Nullable
        private List<String> filters;
        @Nullable
        private Integer maxSize;
        @Nullable
        private Integer minSize;

        public Builder setFilters(@Nullable List<String> list) {
            this.filters = list;
            return this;
        }

        public Builder setMaxSize(@Nullable Integer num) {
            this.maxSize = num;
            return this;
        }

        public Builder setMinSize(@Nullable Integer num) {
            this.minSize = num;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ContextChooseContent build() {
            return new ContextChooseContent(this);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(ContextChooseContent contextChooseContent) {
            return contextChooseContent == null ? this : setFilters(contextChooseContent.getFilters()).setMaxSize(contextChooseContent.getMaxSize()).setMinSize(contextChooseContent.getMinSize());
        }

        public Builder readFrom(Parcel parcel) {
            return readFrom((ContextChooseContent) parcel.readParcelable(ContextChooseContent.class.getClassLoader()));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public List<String> getFilters() {
        List<String> list = this.filters;
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return null;
    }

    @Nullable
    public Integer getMaxSize() {
        return this.maxSize;
    }

    @Nullable
    public Integer getMinSize() {
        return this.minSize;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.filters);
        parcel.writeInt(this.maxSize.intValue());
        parcel.writeInt(this.minSize.intValue());
    }

    private ContextChooseContent(Builder builder) {
        this.filters = builder.filters;
        this.maxSize = builder.maxSize;
        this.minSize = builder.minSize;
    }

    public ContextChooseContent(Parcel parcel) {
        this.filters = parcel.createStringArrayList();
        this.maxSize = Integer.valueOf(parcel.readInt());
        this.minSize = Integer.valueOf(parcel.readInt());
    }
}
