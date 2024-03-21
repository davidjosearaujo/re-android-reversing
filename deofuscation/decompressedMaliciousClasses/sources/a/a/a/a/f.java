package a.a.a.a;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
/* loaded from: /home/remnux/decompressedMalicious.dex */
abstract class f extends e {

    /* renamed from: b  reason: collision with root package name */
    boolean f13b;

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!this.f13b && i != -1) {
            d.a(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!this.f11a && i != -1) {
            d.a(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
