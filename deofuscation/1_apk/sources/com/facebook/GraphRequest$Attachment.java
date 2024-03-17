package com.facebook;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import n.b0;
import n.l2.v.f0;
import r.e.a.d;
import r.e.a.e;

/* compiled from: GraphRequest.kt */
@b0(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/facebook/GraphRequest$Attachment;", "", "request", "Lcom/facebook/GraphRequest;", SDKConstants.PARAM_VALUE, "(Lcom/facebook/GraphRequest;Ljava/lang/Object;)V", "getRequest", "()Lcom/facebook/GraphRequest;", "getValue", "()Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class GraphRequest$Attachment {
    @d
    private final GraphRequest request;
    @e
    private final Object value;

    public GraphRequest$Attachment(@d GraphRequest graphRequest, @e Object obj) {
        f0.p(graphRequest, "request");
        this.request = graphRequest;
        this.value = obj;
    }

    @d
    public final GraphRequest getRequest() {
        return this.request;
    }

    @e
    public final Object getValue() {
        return this.value;
    }
}
