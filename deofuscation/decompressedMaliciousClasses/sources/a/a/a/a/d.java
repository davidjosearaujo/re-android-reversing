package a.a.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(9)
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class d extends p0 {
    private static short[] $ = {3848, 3882, 3877, 3947, 3876, 3877, 3879, 3890, 3947, 3902, 3896, 3886, 3947, 3879, 3876, 3900, 3886, 3897, 3947, 3962, 3965, 3947, 3881, 3874, 3903, 3896, 3947, 3885, 3876, 3897, 3947, 3897, 3886, 3898, 3902, 3886, 3896, 3903, 3848, 3876, 3887, 3886};

    /* renamed from: a */
    boolean f11a;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a(int i) {
        if ((i & -65536) != 0) {
            throw new IllegalArgumentException($(0, 42, 3915));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract View b(View view, String str, Context context, AttributeSet attributeSet);

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT < 11 && getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View b2 = b(null, str, context, attributeSet);
        return b2 == null ? super.onCreateView(str, context, attributeSet) : b2;
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        if (!this.f11a && i != -1) {
            a(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }
}
