package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import n.b0;
import n.l2.v.f0;
import r.e.a.d;

/* compiled from: FacebookBroadcastReceiver.kt */
@b0(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0014J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0014¨\u0006\u0010"}, d2 = {"Lcom/facebook/FacebookBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onFailedAppCall", "", "appCallId", "", "action", "extras", "Landroid/os/Bundle;", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "onSuccessfulAppCall", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class FacebookBroadcastReceiver extends BroadcastReceiver {
    public void onFailedAppCall(@d String str, @d String str2, @d Bundle bundle) {
        f0.p(str, "appCallId");
        f0.p(str2, "action");
        f0.p(bundle, "extras");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@d Context context, @d Intent intent) {
        f0.p(context, "context");
        f0.p(intent, "intent");
        String stringExtra = intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_CALL_ID);
        String stringExtra2 = intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_ACTION);
        Bundle extras = intent.getExtras();
        if (stringExtra == null || stringExtra2 == null || extras == null) {
            return;
        }
        if (NativeProtocol.isErrorResult(intent)) {
            onFailedAppCall(stringExtra, stringExtra2, extras);
        } else {
            onSuccessfulAppCall(stringExtra, stringExtra2, extras);
        }
    }

    public void onSuccessfulAppCall(@d String str, @d String str2, @d Bundle bundle) {
        f0.p(str, "appCallId");
        f0.p(str2, "action");
        f0.p(bundle, "extras");
    }
}
