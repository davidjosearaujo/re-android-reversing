package android.view;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class ContentInfo implements Parcelable {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public final /* synthetic */ class Builder {
        static {
            throw new NoClassDefFoundError();
        }

        public /* synthetic */ Builder(@NonNull ClipData clipData, int i7) {
        }

        @NonNull
        public native /* synthetic */ ContentInfo build();

        @NonNull
        public native /* synthetic */ Builder setExtras(@Nullable Bundle bundle);

        @NonNull
        public native /* synthetic */ Builder setFlags(int i7);

        @NonNull
        public native /* synthetic */ Builder setLinkUri(@Nullable Uri uri);
    }

    static {
        throw new NoClassDefFoundError();
    }

    @NonNull
    public native /* synthetic */ ClipData getClip();

    public native /* synthetic */ int getFlags();

    public native /* synthetic */ int getSource();
}
