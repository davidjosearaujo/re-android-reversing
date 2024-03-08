package f;

import android.content.Context;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f3927f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Context f3928g;

    public /* synthetic */ f(Context context, int i7) {
        this.f3927f = i7;
        this.f3928g = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0065, code lost:
        if (r4 != null) goto L_0x006a;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r6 = this;
            int r0 = r6.f3927f
            switch(r0) {
                case 0: goto L_0x0007;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x008d
        L_0x0007:
            android.content.Context r6 = r6.f3928g
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            r2 = 1
            if (r0 < r1) goto L_0x008a
            android.content.ComponentName r0 = new android.content.ComponentName
            java.lang.String r1 = "androidx.appcompat.app.AppLocalesMetadataHolderService"
            r0.<init>(r6, r1)
            android.content.pm.PackageManager r1 = r6.getPackageManager()
            int r1 = r1.getComponentEnabledSetting(r0)
            if (r1 == r2) goto L_0x008a
            boolean r1 = l1.a.a()
            java.lang.String r3 = "locale"
            if (r1 == 0) goto L_0x0063
            o.d<java.lang.ref.WeakReference<f.g>> r1 = f.g.f3935l
            java.util.Iterator r1 = r1.iterator()
        L_0x002f:
            r4 = r1
            o.g$a r4 = (o.g.a) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0051
            java.lang.Object r4 = r4.next()
            java.lang.ref.WeakReference r4 = (java.lang.ref.WeakReference) r4
            java.lang.Object r4 = r4.get()
            f.g r4 = (f.g) r4
            if (r4 == 0) goto L_0x002f
            android.content.Context r4 = r4.f()
            if (r4 == 0) goto L_0x002f
            java.lang.Object r1 = r4.getSystemService(r3)
            goto L_0x0052
        L_0x0051:
            r1 = 0
        L_0x0052:
            if (r1 == 0) goto L_0x0068
            android.os.LocaleList r1 = f.g.b.a(r1)
            l1.e r4 = new l1.e
            l1.g r5 = new l1.g
            r5.<init>(r1)
            r4.<init>(r5)
            goto L_0x006a
        L_0x0063:
            l1.e r4 = f.g.f3931h
            if (r4 == 0) goto L_0x0068
            goto L_0x006a
        L_0x0068:
            l1.e r4 = l1.e.f4943b
        L_0x006a:
            l1.f r1 = r4.f4944a
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0083
            java.lang.String r1 = f.s.b(r6)
            java.lang.Object r3 = r6.getSystemService(r3)
            if (r3 == 0) goto L_0x0083
            android.os.LocaleList r1 = f.g.a.a(r1)
            f.g.b.b(r3, r1)
        L_0x0083:
            android.content.pm.PackageManager r6 = r6.getPackageManager()
            r6.setComponentEnabledSetting(r0, r2, r2)
        L_0x008a:
            f.g.f3934k = r2
            return
        L_0x008d:
            android.content.Context r6 = r6.f3928g
            k.a r0 = new k.a
            r1 = 3
            r0.<init>(r1)
            androidx.profileinstaller.c$a r1 = androidx.profileinstaller.c.f1914a
            r2 = 0
            androidx.profileinstaller.c.b(r6, r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.f.run():void");
    }
}
