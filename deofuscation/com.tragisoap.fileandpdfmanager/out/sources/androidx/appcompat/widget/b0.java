package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.widget.TextView;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b0 implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ TextView f834f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Typeface f835g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f836h;

    public b0(TextView textView, Typeface typeface, int i7) {
        this.f834f = textView;
        this.f835g = typeface;
        this.f836h = i7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f834f.setTypeface(this.f835g, this.f836h);
    }
}
