package r2;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public static final b f5793a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final c f5794b = new c();

    /* renamed from: c  reason: collision with root package name */
    public static final e f5795c = new e();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends l {
        @Override // r2.l
        public final boolean a() {
            return true;
        }

        @Override // r2.l
        public final boolean b() {
            return true;
        }

        @Override // r2.l
        public final boolean c(p2.a aVar) {
            return aVar == p2.a.REMOTE;
        }

        @Override // r2.l
        public final boolean d(boolean z6, p2.a aVar, p2.c cVar) {
            return (aVar == p2.a.RESOURCE_DISK_CACHE || aVar == p2.a.MEMORY_CACHE) ? false : true;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b extends l {
        @Override // r2.l
        public final boolean a() {
            return false;
        }

        @Override // r2.l
        public final boolean b() {
            return false;
        }

        @Override // r2.l
        public final boolean c(p2.a aVar) {
            return false;
        }

        @Override // r2.l
        public final boolean d(boolean z6, p2.a aVar, p2.c cVar) {
            return false;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class c extends l {
        @Override // r2.l
        public final boolean a() {
            return true;
        }

        @Override // r2.l
        public final boolean b() {
            return false;
        }

        @Override // r2.l
        public final boolean c(p2.a aVar) {
            return (aVar == p2.a.DATA_DISK_CACHE || aVar == p2.a.MEMORY_CACHE) ? false : true;
        }

        @Override // r2.l
        public final boolean d(boolean z6, p2.a aVar, p2.c cVar) {
            return false;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class d extends l {
        @Override // r2.l
        public final boolean a() {
            return false;
        }

        @Override // r2.l
        public final boolean b() {
            return true;
        }

        @Override // r2.l
        public final boolean c(p2.a aVar) {
            return false;
        }

        @Override // r2.l
        public final boolean d(boolean z6, p2.a aVar, p2.c cVar) {
            return (aVar == p2.a.RESOURCE_DISK_CACHE || aVar == p2.a.MEMORY_CACHE) ? false : true;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class e extends l {
        @Override // r2.l
        public final boolean a() {
            return true;
        }

        @Override // r2.l
        public final boolean b() {
            return true;
        }

        @Override // r2.l
        public final boolean c(p2.a aVar) {
            return aVar == p2.a.REMOTE;
        }

        @Override // r2.l
        public final boolean d(boolean z6, p2.a aVar, p2.c cVar) {
            return ((z6 && aVar == p2.a.DATA_DISK_CACHE) || aVar == p2.a.LOCAL) && cVar == p2.c.TRANSFORMED;
        }
    }

    static {
        new a();
        new d();
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(p2.a aVar);

    public abstract boolean d(boolean z6, p2.a aVar, p2.c cVar);
}