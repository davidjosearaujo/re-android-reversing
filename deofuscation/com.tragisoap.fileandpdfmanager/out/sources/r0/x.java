package r0;

import p.o0;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public interface x extends o0<Object> {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a implements x {

        /* renamed from: f  reason: collision with root package name */
        public final Object f5715f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f5716g;

        public a(Object obj, boolean z6) {
            h.f(obj, "value");
            this.f5715f = obj;
            this.f5716g = z6;
        }

        @Override // r0.x
        public final boolean f() {
            return this.f5716g;
        }

        @Override // p.o0
        public final Object getValue() {
            return this.f5715f;
        }
    }

    boolean f();
}
