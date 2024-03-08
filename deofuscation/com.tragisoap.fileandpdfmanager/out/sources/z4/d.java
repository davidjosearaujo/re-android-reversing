package z4;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class d implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public final String f6936f;

    public d(String str, Object... objArr) {
        this.f6936f = String.format(str, objArr);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f6936f);
        try {
            a();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
