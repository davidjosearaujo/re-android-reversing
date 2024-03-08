package y4;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.concurrent.TimeUnit;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f6687a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f6688b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6689c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6690d;
    public final boolean e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f6691f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f6692g;

    /* renamed from: h  reason: collision with root package name */
    public final int f6693h;

    /* renamed from: i  reason: collision with root package name */
    public final int f6694i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f6695j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f6696k;

    /* renamed from: l  reason: collision with root package name */
    public String f6697l;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f6698a;

        /* renamed from: b  reason: collision with root package name */
        public int f6699b = -1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f6700c;
    }

    static {
        a aVar = new a();
        aVar.f6698a = true;
        new c(aVar);
        a aVar2 = new a();
        aVar2.f6700c = true;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        int i7 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        long seconds = timeUnit.toSeconds((long) SubsamplingScaleImageView.TILE_SIZE_AUTO);
        if (seconds <= 2147483647L) {
            i7 = (int) seconds;
        }
        aVar2.f6699b = i7;
        new c(aVar2);
    }

    public c(a aVar) {
        this.f6687a = aVar.f6698a;
        this.f6688b = false;
        this.f6689c = -1;
        this.f6690d = -1;
        this.e = false;
        this.f6691f = false;
        this.f6692g = false;
        this.f6693h = aVar.f6699b;
        this.f6694i = -1;
        this.f6695j = aVar.f6700c;
        this.f6696k = false;
    }

    public c(boolean z6, boolean z7, int i7, int i8, boolean z8, boolean z9, boolean z10, int i9, int i10, boolean z11, boolean z12, String str) {
        this.f6687a = z6;
        this.f6688b = z7;
        this.f6689c = i7;
        this.f6690d = i8;
        this.e = z8;
        this.f6691f = z9;
        this.f6692g = z10;
        this.f6693h = i9;
        this.f6694i = i10;
        this.f6695j = z11;
        this.f6696k = z12;
        this.f6697l = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static y4.c a(y4.l r21) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.c.a(y4.l):y4.c");
    }

    public final String toString() {
        String str = this.f6697l;
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            if (this.f6687a) {
                sb.append("no-cache, ");
            }
            if (this.f6688b) {
                sb.append("no-store, ");
            }
            if (this.f6689c != -1) {
                sb.append("max-age=");
                sb.append(this.f6689c);
                sb.append(", ");
            }
            if (this.f6690d != -1) {
                sb.append("s-maxage=");
                sb.append(this.f6690d);
                sb.append(", ");
            }
            if (this.e) {
                sb.append("private, ");
            }
            if (this.f6691f) {
                sb.append("public, ");
            }
            if (this.f6692g) {
                sb.append("must-revalidate, ");
            }
            if (this.f6693h != -1) {
                sb.append("max-stale=");
                sb.append(this.f6693h);
                sb.append(", ");
            }
            if (this.f6694i != -1) {
                sb.append("min-fresh=");
                sb.append(this.f6694i);
                sb.append(", ");
            }
            if (this.f6695j) {
                sb.append("only-if-cached, ");
            }
            if (this.f6696k) {
                sb.append("no-transform, ");
            }
            if (sb.length() == 0) {
                str = "";
            } else {
                sb.delete(sb.length() - 2, sb.length());
                str = sb.toString();
            }
            this.f6697l = str;
        }
        return str;
    }
}
