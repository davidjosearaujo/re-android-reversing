package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import n.b0;
import n.l2.v.f0;
import r.e.a.d;
import r.e.a.e;

/* compiled from: ProgressNoopOutputStream.kt */
@b0(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u0016J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J \u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u000bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/facebook/ProgressNoopOutputStream;", "Ljava/io/OutputStream;", "Lcom/facebook/RequestOutputStream;", "callbackHandler", "Landroid/os/Handler;", "(Landroid/os/Handler;)V", "currentRequest", "Lcom/facebook/GraphRequest;", "currentRequestProgress", "Lcom/facebook/RequestProgress;", "<set-?>", "", "maxProgress", "getMaxProgress", "()I", "progressMap", "", "addProgress", "", "size", "", "getProgressMap", "", "setCurrentRequest", "write", "buffer", "", "offset", "length", "oneByte", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class ProgressNoopOutputStream extends OutputStream implements RequestOutputStream {
    private final Handler callbackHandler;
    private GraphRequest currentRequest;
    private RequestProgress currentRequestProgress;
    private int maxProgress;
    private final Map<GraphRequest, RequestProgress> progressMap = new HashMap();

    public ProgressNoopOutputStream(@e Handler handler) {
        this.callbackHandler = handler;
    }

    public final void addProgress(long j) {
        GraphRequest graphRequest = this.currentRequest;
        if (graphRequest != null) {
            if (this.currentRequestProgress == null) {
                RequestProgress requestProgress = new RequestProgress(this.callbackHandler, graphRequest);
                this.currentRequestProgress = requestProgress;
                this.progressMap.put(graphRequest, requestProgress);
            }
            RequestProgress requestProgress2 = this.currentRequestProgress;
            if (requestProgress2 != null) {
                requestProgress2.addToMax(j);
            }
            this.maxProgress += (int) j;
        }
    }

    public final int getMaxProgress() {
        return this.maxProgress;
    }

    @d
    public final Map<GraphRequest, RequestProgress> getProgressMap() {
        return this.progressMap;
    }

    @Override // com.facebook.RequestOutputStream
    public void setCurrentRequest(@e GraphRequest graphRequest) {
        this.currentRequest = graphRequest;
        this.currentRequestProgress = graphRequest != null ? this.progressMap.get(graphRequest) : null;
    }

    @Override // java.io.OutputStream
    public void write(@d byte[] bArr) {
        f0.p(bArr, "buffer");
        addProgress(bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@d byte[] bArr, int i, int i2) {
        f0.p(bArr, "buffer");
        addProgress(i2);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        addProgress(1L);
    }
}
