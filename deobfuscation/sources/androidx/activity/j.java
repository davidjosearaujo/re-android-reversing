package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import androidx.activity.ComponentActivity;

/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: f */
    public final /* synthetic */ int f416f;

    /* renamed from: g */
    public final /* synthetic */ IntentSender.SendIntentException f417g;

    /* renamed from: h */
    public final /* synthetic */ ComponentActivity.a f418h;

    public j(ComponentActivity.a aVar, int i7, IntentSender.SendIntentException sendIntentException) {
        this.f418h = aVar;
        this.f416f = i7;
        this.f417g = sendIntentException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f418h.a(this.f416f, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f417g));
    }
}
