package l3;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class d {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends d {

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f5029a;

        public final void a() {
            if (this.f5029a) {
                throw new IllegalStateException("Already released");
            }
        }
    }
}
