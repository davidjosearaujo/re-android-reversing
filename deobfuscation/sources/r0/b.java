package r0;

import android.content.Context;
import android.os.Build;

/* loaded from: classes.dex */
public final class b {
    public static final a a(Context context) {
        return new a(Build.VERSION.SDK_INT >= 31 ? context.getResources().getConfiguration().fontWeightAdjustment : 0);
    }
}
