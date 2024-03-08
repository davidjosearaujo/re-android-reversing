package androidx.lifecycle;

import com.davemorrissey.labs.subscaleview.R;
import java.util.concurrent.atomic.AtomicReference;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class g {

    /* renamed from: a */
    public AtomicReference<Object> f1860a = new AtomicReference<>();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;
        
        public static final C0018a Companion = new C0018a();

        /* renamed from: androidx.lifecycle.g$a$a */
        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static final class C0018a {
            public static a a(b bVar) {
                h.f(bVar, "state");
                int ordinal = bVar.ordinal();
                if (ordinal == 1) {
                    return a.ON_CREATE;
                }
                if (ordinal == 2) {
                    return a.ON_START;
                }
                if (ordinal != 3) {
                    return null;
                }
                return a.ON_RESUME;
            }
        }

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public /* synthetic */ class b {

            /* renamed from: a */
            public static final /* synthetic */ int[] f1861a;

            static {
                int[] iArr = new int[a.values().length];
                try {
                    iArr[a.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[a.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[a.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[a.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[a.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[a.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[a.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f1861a = iArr;
            }
        }

        public final b a() {
            switch (b.f1861a[ordinal()]) {
                case 1:
                case 2:
                    return b.CREATED;
                case 3:
                case 4:
                    return b.STARTED;
                case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                    return b.RESUMED;
                case 6:
                    return b.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED
    }

    public abstract void a(m mVar);

    public abstract b b();

    public abstract void c(m mVar);
}
