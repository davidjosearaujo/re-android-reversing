package l3;

/* loaded from: classes.dex */
public abstract class d {

    /* loaded from: classes.dex */
    public static class a extends d {

        /* renamed from: a */
        public volatile boolean f5029a;

        public final void a() {
            if (this.f5029a) {
                throw new IllegalStateException("Already released");
            }
        }
    }
}
