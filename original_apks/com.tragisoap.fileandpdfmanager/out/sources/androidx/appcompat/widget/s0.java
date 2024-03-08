package androidx.appcompat.widget;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class s0 {

    /* renamed from: a  reason: collision with root package name */
    public int f1031a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f1032b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f1033c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public int f1034d = Integer.MIN_VALUE;
    public int e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f1035f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1036g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1037h = false;

    public final void a(int i7, int i8) {
        this.f1033c = i7;
        this.f1034d = i8;
        this.f1037h = true;
        if (this.f1036g) {
            if (i8 != Integer.MIN_VALUE) {
                this.f1031a = i8;
            }
            if (i7 != Integer.MIN_VALUE) {
                this.f1032b = i7;
                return;
            }
            return;
        }
        if (i7 != Integer.MIN_VALUE) {
            this.f1031a = i7;
        }
        if (i8 != Integer.MIN_VALUE) {
            this.f1032b = i8;
        }
    }
}
