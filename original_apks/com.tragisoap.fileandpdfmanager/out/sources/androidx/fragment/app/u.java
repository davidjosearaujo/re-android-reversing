package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import androidx.activity.result.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class u<E> extends c {

    /* renamed from: f */
    public final Activity f1764f;

    /* renamed from: g */
    public final Context f1765g;

    /* renamed from: h */
    public final Handler f1766h;

    /* renamed from: i */
    public final y f1767i = new y();

    public u(q qVar) {
        Handler handler = new Handler();
        this.f1764f = qVar;
        if (qVar != null) {
            this.f1765g = qVar;
            this.f1766h = handler;
            return;
        }
        throw new NullPointerException("context == null");
    }

    public abstract q p();

    public abstract LayoutInflater q();

    public abstract void r();
}
