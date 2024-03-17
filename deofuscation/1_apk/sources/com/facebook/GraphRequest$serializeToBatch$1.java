package com.facebook;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import n.b0;
import n.l2.v.f0;
import n.l2.v.s0;
import r.e.a.d;

/* compiled from: GraphRequest.kt */
@b0(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/facebook/GraphRequest$serializeToBatch$1", "Lcom/facebook/GraphRequest$KeyValueSerializer;", "writeString", "", SDKConstants.PARAM_KEY, "", SDKConstants.PARAM_VALUE, "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class GraphRequest$serializeToBatch$1 implements GraphRequest$KeyValueSerializer {
    public final /* synthetic */ ArrayList $keysAndValues;

    public GraphRequest$serializeToBatch$1(ArrayList arrayList) {
        this.$keysAndValues = arrayList;
    }

    @Override // com.facebook.GraphRequest$KeyValueSerializer
    public void writeString(@d String str, @d String str2) throws IOException {
        f0.p(str, SDKConstants.PARAM_KEY);
        f0.p(str2, SDKConstants.PARAM_VALUE);
        ArrayList arrayList = this.$keysAndValues;
        s0 s0Var = s0.a;
        String format = String.format(Locale.US, "%s=%s", Arrays.copyOf(new Object[]{str, URLEncoder.encode(str2, "UTF-8")}, 2));
        f0.o(format, "java.lang.String.format(locale, format, *args)");
        arrayList.add(format);
    }
}
