package m1;

import android.content.Context;
import java.util.concurrent.Callable;
import m1.k;

/* loaded from: classes.dex */
public final class g implements Callable<k.a> {

    /* renamed from: a */
    public final /* synthetic */ String f5050a;

    /* renamed from: b */
    public final /* synthetic */ Context f5051b;

    /* renamed from: c */
    public final /* synthetic */ f f5052c;

    /* renamed from: d */
    public final /* synthetic */ int f5053d;

    public g(String str, Context context, f fVar, int i7) {
        this.f5050a = str;
        this.f5051b = context;
        this.f5052c = fVar;
        this.f5053d = i7;
    }

    @Override // java.util.concurrent.Callable
    public final k.a call() {
        return k.a(this.f5050a, this.f5051b, this.f5052c, this.f5053d);
    }
}
