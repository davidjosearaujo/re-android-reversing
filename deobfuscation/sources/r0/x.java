package r0;

import p.o0;

/* loaded from: classes.dex */
public interface x extends o0<Object> {

    /* loaded from: classes.dex */
    public static final class a implements x {

        /* renamed from: f */
        public final Object f5715f;

        /* renamed from: g */
        public final boolean f5716g;

        public a(Object obj, boolean z6) {
            r5.h.f(obj, "value");
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
