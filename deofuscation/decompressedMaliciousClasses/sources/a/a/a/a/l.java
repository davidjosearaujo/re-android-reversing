package a.a.a.a;

import a.a.a.d.h;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class l<E> extends j {
    private static short[] $ = {7745, 7707, 7686, 7686, 7709, 7744, 9260, 9229, 9262, 9248, 9253, 9252, 9267, 9266, 9234, 9269, 9248, 9267, 9269, 9252, 9253, 9340, 5316, 5351, 5353, 5356, 5357, 5370, 5288, 5317, 5353, 5350, 5353, 5359, 5357, 5370, 5288, 8599, 7926, 7926};

    /* renamed from: a */
    private final Activity f33a;

    /* renamed from: b */
    final Context f34b;
    private final Handler c;
    final n d;
    private h<String, u> e;
    private boolean f;
    private v g;
    private boolean h;
    private boolean i;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public l(i iVar) {
        this(iVar, iVar, iVar.c, 0);
    }

    l(Activity activity, Context context, Handler handler, int i) {
        this.d = new n();
        this.f33a = activity;
        this.f34b = context;
        this.c = handler;
    }

    public void c() {
        v vVar = this.g;
        if (vVar != null) {
            vVar.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (r1.d == false) goto L_0x000e;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            r7 = this;
            r3 = r7
            boolean r0 = r3.i
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 1
            r3.i = r0
            a.a.a.a.v r1 = r3.g
            if (r1 == 0) goto L_0x0012
        L_0x000e:
            r1.e()
            goto L_0x0031
        L_0x0012:
            boolean r1 = r3.h
            if (r1 != 0) goto L_0x0031
            r1 = 0
            r5 = 0
            r6 = 6
            r7 = 7785(0x1e69, float:1.0909E-41)
            java.lang.String r2 = $(r5, r6, r7)
            a.a.a.a.v r1 = r3.k(r2, r0, r1)
            r3.g = r1
            if (r1 == 0) goto L_0x0031
            boolean r2 = r1.d
            if (r2 != 0) goto L_0x0031
            goto L_0x000e
        L_0x0031:
            r3.h = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.l.d():void");
    }

    public void e(boolean z) {
        this.f = z;
        v vVar = this.g;
        if (vVar != null && this.i) {
            this.i = false;
            if (z) {
                vVar.d();
            } else {
                vVar.f();
            }
        }
    }

    public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print($(6, 22, 9281));
        printWriter.println(this.i);
        if (this.g != null) {
            printWriter.print(str);
            printWriter.print($(22, 37, 5256));
            printWriter.print(Integer.toHexString(System.identityHashCode(this.g)));
            printWriter.println($(37, 38, 8621));
            v vVar = this.g;
            vVar.g(str + $(38, 40, 7894), fileDescriptor, printWriter, strArr);
        }
    }

    public Activity g() {
        return this.f33a;
    }

    public Context h() {
        return this.f34b;
    }

    public n i() {
        return this.d;
    }

    public Handler j() {
        return this.c;
    }

    public v k(String str, boolean z, boolean z2) {
        if (this.e == null) {
            this.e = new h<>();
        }
        v vVar = (v) this.e.get(str);
        if (vVar != null) {
            vVar.j(this);
            return vVar;
        } else if (!z2) {
            return vVar;
        } else {
            v vVar2 = new v(str, this, z);
            this.e.put(str, vVar2);
            return vVar2;
        }
    }

    public boolean l() {
        return this.f;
    }

    public void m(String str) {
        v vVar;
        h<String, u> hVar = this.e;
        if (hVar != null && (vVar = (v) hVar.get(str)) != null && !vVar.e) {
            vVar.a();
            this.e.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n(h hVar);

    public abstract void o(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract LayoutInflater p();

    public abstract int q();

    public abstract boolean r();

    public abstract boolean s(h hVar);

    public abstract void t();

    public void u() {
        h<String, u> hVar = this.e;
        if (hVar != null) {
            int size = hVar.size();
            v[] vVarArr = new v[size];
            for (int i = size - 1; i >= 0; i--) {
                vVarArr[i] = (v) this.e.l(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                v vVar = vVarArr[i2];
                vVar.h();
                vVar.c();
            }
        }
    }

    public void v(h<String, u> hVar) {
        this.e = hVar;
    }

    public h<String, u> w() {
        h<String, u> hVar = this.e;
        int i = 0;
        if (hVar != null) {
            int size = hVar.size();
            v[] vVarArr = new v[size];
            for (int i2 = size - 1; i2 >= 0; i2--) {
                vVarArr[i2] = (v) this.e.l(i2);
            }
            boolean l = l();
            int i3 = 0;
            while (i < size) {
                v vVar = vVarArr[i];
                if (!vVar.e && l) {
                    if (!vVar.d) {
                        vVar.e();
                    }
                    vVar.d();
                }
                if (vVar.e) {
                    i3 = 1;
                } else {
                    vVar.a();
                    this.e.remove(vVar.c);
                }
                i++;
            }
            i = i3;
        }
        if (i != 0) {
            return this.e;
        }
        return null;
    }
}
