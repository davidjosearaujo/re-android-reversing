package f2;

import androidx.profileinstaller.b;
import androidx.profileinstaller.c;
import java.io.Serializable;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f4091f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f4092g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f4093h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f4094i;

    public /* synthetic */ a(int i7, int i8, Object obj, Serializable serializable) {
        this.f4091f = i8;
        this.f4094i = obj;
        this.f4092g = i7;
        this.f4093h = serializable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4091f) {
            case 0:
                ((b) this.f4094i).f1908c.b(this.f4092g, this.f4093h);
                return;
            default:
                ((c.AbstractC0019c) this.f4094i).b(this.f4092g, this.f4093h);
                return;
        }
    }
}
