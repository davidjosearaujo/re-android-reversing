package androidx.lifecycle;

import androidx.lifecycle.g;
import com.davemorrissey.labs.subscaleview.R;

/* loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements l {

    /* renamed from: f */
    public final b f1816f;

    /* renamed from: g */
    public final l f1817g;

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f1818a;

        static {
            int[] iArr = new int[g.a.values().length];
            try {
                iArr[g.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[g.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[g.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[g.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[g.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[g.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[g.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f1818a = iArr;
        }
    }

    public DefaultLifecycleObserverAdapter(b bVar, l lVar) {
        r5.h.f(bVar, "defaultLifecycleObserver");
        this.f1816f = bVar;
        this.f1817g = lVar;
    }

    @Override // androidx.lifecycle.l
    public final void c(n nVar, g.a aVar) {
        switch (a.f1818a[aVar.ordinal()]) {
            case 1:
            case 4:
                this.f1816f.getClass();
                break;
            case 2:
                this.f1816f.onStart(nVar);
                break;
            case 3:
                this.f1816f.b(nVar);
                break;
            case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                this.f1816f.onStop(nVar);
                break;
            case 6:
                this.f1816f.onDestroy(nVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        l lVar = this.f1817g;
        if (lVar != null) {
            lVar.c(nVar, aVar);
        }
    }
}
