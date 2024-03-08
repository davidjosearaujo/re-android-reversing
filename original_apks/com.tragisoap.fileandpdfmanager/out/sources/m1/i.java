package m1;

import android.content.Context;
import java.util.concurrent.Callable;
import m1.k;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i implements Callable<k.a> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5055a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f5056b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ f f5057c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f5058d;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public i(String str, Context context, f fVar, int i7) {
        this.f5055a = str;
        this.f5056b = context;
        this.f5057c = fVar;
        this.f5058d = i7;
    }

    @Override // java.util.concurrent.Callable
    public final k.a call() {
        try {
            return k.a(this.f5055a, this.f5056b, this.f5057c, this.f5058d);
        } catch (Throwable unused) {
            return new k.a(-3);
        }
    }
}
