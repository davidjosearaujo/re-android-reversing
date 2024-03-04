package s1;

import android.view.inputmethod.InputContentInfo;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    public final b f5931a;

    /* loaded from: classes.dex */
    public static final class a implements b {

        /* renamed from: a */
        public final InputContentInfo f5932a;

        public a(Object obj) {
            this.f5932a = (InputContentInfo) obj;
        }

        public final Object a() {
            return this.f5932a;
        }

        public final void b() {
            this.f5932a.requestPermission();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    public c(a aVar) {
        this.f5931a = aVar;
    }
}
