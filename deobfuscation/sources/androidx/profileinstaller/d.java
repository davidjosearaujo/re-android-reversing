package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    public static final v0.b<c> f1916a = new v0.b<>();

    /* renamed from: b */
    public static final Object f1917b = new Object();

    /* renamed from: c */
    public static c f1918c = null;

    /* loaded from: classes.dex */
    public static class a {
        public static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public final int f1919a;

        /* renamed from: b */
        public final int f1920b;

        /* renamed from: c */
        public final long f1921c;

        /* renamed from: d */
        public final long f1922d;

        public b(int i7, int i8, long j5, long j7) {
            this.f1919a = i7;
            this.f1920b = i8;
            this.f1921c = j5;
            this.f1922d = j7;
        }

        public static b a(File file) {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public final void b(File file) {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f1919a);
                dataOutputStream.writeInt(this.f1920b);
                dataOutputStream.writeLong(this.f1921c);
                dataOutputStream.writeLong(this.f1922d);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f1920b == bVar.f1920b && this.f1921c == bVar.f1921c && this.f1919a == bVar.f1919a && this.f1922d == bVar.f1922d;
        }

        public final int hashCode() {
            return Objects.hash(Integer.valueOf(this.f1920b), Long.valueOf(this.f1921c), Integer.valueOf(this.f1919a), Long.valueOf(this.f1922d));
        }
    }

    /* loaded from: classes.dex */
    public static class c {
    }

    public static c a(int i7, boolean z6, boolean z7) {
        c cVar = new c();
        f1918c = cVar;
        v0.b<c> bVar = f1916a;
        bVar.getClass();
        if (v0.a.f6162k.b(bVar, null, cVar)) {
            v0.a.b(bVar);
        }
        return f1918c;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:14|(1:81)(1:18)|19|(1:80)(1:23)|24|25|(1:27)(1:73)|28|29|(2:65|66)|31|(8:38|(1:42)|(1:49)|50|(2:57|58)|54|55|56)|(1:64)|(1:42)|(3:44|47|49)|50|(1:52)|57|58|54|55|56) */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x00b8, code lost:
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x00e8, code lost:
        r3 = 196608;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.content.Context r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.d.b(android.content.Context, boolean):void");
    }
}
