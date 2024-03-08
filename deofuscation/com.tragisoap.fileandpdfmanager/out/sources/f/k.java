package f;

import l0.z;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ h f3999f;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends z {
        public a() {
        }

        @Override // p1.l0
        public final void a() {
            k.this.f3999f.A.setAlpha(1.0f);
            k.this.f3999f.D.d(null);
            k.this.f3999f.D = null;
        }

        @Override // l0.z, p1.l0
        public final void c() {
            k.this.f3999f.A.setVisibility(0);
        }
    }

    public k(h hVar) {
        this.f3999f = hVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r4 = this;
            f.h r0 = r4.f3999f
            android.widget.PopupWindow r1 = r0.B
            androidx.appcompat.widget.ActionBarContextView r0 = r0.A
            r2 = 55
            r3 = 0
            r1.showAtLocation(r0, r2, r3, r3)
            f.h r0 = r4.f3999f
            p1.k0 r0 = r0.D
            if (r0 == 0) goto L_0x0015
            r0.b()
        L_0x0015:
            f.h r0 = r4.f3999f
            boolean r1 = r0.F
            if (r1 == 0) goto L_0x0029
            android.view.ViewGroup r0 = r0.G
            if (r0 == 0) goto L_0x0029
            java.util.WeakHashMap<android.view.View, p1.k0> r1 = p1.y.f5540a
            boolean r0 = p1.y.g.c(r0)
            if (r0 == 0) goto L_0x0029
            r0 = 1
            goto L_0x002a
        L_0x0029:
            r0 = r3
        L_0x002a:
            r1 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L_0x0050
            f.h r0 = r4.f3999f
            androidx.appcompat.widget.ActionBarContextView r0 = r0.A
            r2 = 0
            r0.setAlpha(r2)
            f.h r0 = r4.f3999f
            androidx.appcompat.widget.ActionBarContextView r2 = r0.A
            p1.k0 r2 = p1.y.a(r2)
            r2.a(r1)
            r0.D = r2
            f.h r0 = r4.f3999f
            p1.k0 r0 = r0.D
            f.k$a r1 = new f.k$a
            r1.<init>()
            r0.d(r1)
            goto L_0x005e
        L_0x0050:
            f.h r0 = r4.f3999f
            androidx.appcompat.widget.ActionBarContextView r0 = r0.A
            r0.setAlpha(r1)
            f.h r4 = r4.f3999f
            androidx.appcompat.widget.ActionBarContextView r4 = r4.A
            r4.setVisibility(r3)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.k.run():void");
    }
}
