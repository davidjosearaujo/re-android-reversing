package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;

/* loaded from: classes.dex */
public abstract class u<E> extends androidx.activity.result.c {

    /* renamed from: f */
    public final Activity f1764f;

    /* renamed from: g */
    public final Context f1765g;

    /* renamed from: h */
    public final Handler f1766h;

    /* renamed from: i */
    public final y f1767i;

    public u(q qVar) {
        Handler handler = new Handler();
        this.f1767i = new y();
        this.f1764f = qVar;
        if (qVar == null) {
            throw new NullPointerException("context == null");
        }
        this.f1765g = qVar;
        this.f1766h = handler;
    }

    public abstract q p();

    public abstract LayoutInflater q();

    public abstract void r();
}
