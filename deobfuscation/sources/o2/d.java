package o2;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: b */
    public ByteBuffer f5295b;

    /* renamed from: c */
    public c f5296c;

    /* renamed from: a */
    public final byte[] f5294a = new byte[256];

    /* renamed from: d */
    public int f5297d = 0;

    public final boolean a() {
        return this.f5296c.f5285b != 0;
    }

    public final c b() {
        if (this.f5295b != null) {
            if (a()) {
                return this.f5296c;
            }
            StringBuilder sb = new StringBuilder();
            for (int i7 = 0; i7 < 6; i7++) {
                sb.append((char) c());
            }
            if (sb.toString().startsWith("GIF")) {
                this.f5296c.f5288f = f();
                this.f5296c.f5289g = f();
                int c7 = c();
                c cVar = this.f5296c;
                cVar.f5290h = (c7 & 128) != 0;
                cVar.f5291i = (int) Math.pow(2.0d, (c7 & 7) + 1);
                this.f5296c.f5292j = c();
                c cVar2 = this.f5296c;
                c();
                cVar2.getClass();
                if (this.f5296c.f5290h && !a()) {
                    c cVar3 = this.f5296c;
                    cVar3.f5284a = e(cVar3.f5291i);
                    c cVar4 = this.f5296c;
                    cVar4.f5293k = cVar4.f5284a[cVar4.f5292j];
                }
            } else {
                this.f5296c.f5285b = 1;
            }
            if (!a()) {
                boolean z6 = false;
                while (!z6 && !a() && this.f5296c.f5286c <= Integer.MAX_VALUE) {
                    int c8 = c();
                    if (c8 == 33) {
                        int c9 = c();
                        if (c9 != 1) {
                            if (c9 == 249) {
                                this.f5296c.f5287d = new b();
                                c();
                                int c10 = c();
                                b bVar = this.f5296c.f5287d;
                                int i8 = (c10 & 28) >> 2;
                                bVar.f5279g = i8;
                                if (i8 == 0) {
                                    bVar.f5279g = 1;
                                }
                                bVar.f5278f = (c10 & 1) != 0;
                                int f7 = f();
                                if (f7 < 2) {
                                    f7 = 10;
                                }
                                b bVar2 = this.f5296c.f5287d;
                                bVar2.f5281i = f7 * 10;
                                bVar2.f5280h = c();
                                c();
                            } else if (c9 != 254 && c9 == 255) {
                                d();
                                StringBuilder sb2 = new StringBuilder();
                                for (int i9 = 0; i9 < 11; i9++) {
                                    sb2.append((char) this.f5294a[i9]);
                                }
                                if (sb2.toString().equals("NETSCAPE2.0")) {
                                    do {
                                        d();
                                        byte[] bArr = this.f5294a;
                                        if (bArr[0] == 1) {
                                            byte b2 = bArr[1];
                                            byte b7 = bArr[2];
                                            this.f5296c.getClass();
                                        }
                                        if (this.f5297d > 0) {
                                        }
                                    } while (!a());
                                }
                            }
                        }
                        g();
                    } else if (c8 == 44) {
                        c cVar5 = this.f5296c;
                        if (cVar5.f5287d == null) {
                            cVar5.f5287d = new b();
                        }
                        this.f5296c.f5287d.f5274a = f();
                        this.f5296c.f5287d.f5275b = f();
                        this.f5296c.f5287d.f5276c = f();
                        this.f5296c.f5287d.f5277d = f();
                        int c11 = c();
                        boolean z7 = (c11 & 128) != 0;
                        int pow = (int) Math.pow(2.0d, (c11 & 7) + 1);
                        b bVar3 = this.f5296c.f5287d;
                        bVar3.e = (c11 & 64) != 0;
                        if (z7) {
                            bVar3.f5283k = e(pow);
                        } else {
                            bVar3.f5283k = null;
                        }
                        this.f5296c.f5287d.f5282j = this.f5295b.position();
                        c();
                        g();
                        if (!a()) {
                            c cVar6 = this.f5296c;
                            cVar6.f5286c++;
                            cVar6.e.add(cVar6.f5287d);
                        }
                    } else if (c8 != 59) {
                        this.f5296c.f5285b = 1;
                    } else {
                        z6 = true;
                    }
                }
                c cVar7 = this.f5296c;
                if (cVar7.f5286c < 0) {
                    cVar7.f5285b = 1;
                }
            }
            return this.f5296c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public final int c() {
        try {
            return this.f5295b.get() & 255;
        } catch (Exception unused) {
            this.f5296c.f5285b = 1;
            return 0;
        }
    }

    public final void d() {
        int c7 = c();
        this.f5297d = c7;
        if (c7 <= 0) {
            return;
        }
        int i7 = 0;
        int i8 = 0;
        while (true) {
            try {
                i8 = this.f5297d;
                if (i7 >= i8) {
                    return;
                }
                i8 -= i7;
                this.f5295b.get(this.f5294a, i7, i8);
                i7 += i8;
            } catch (Exception e) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    Log.d("GifHeaderParser", "Error Reading Block n: " + i7 + " count: " + i8 + " blockSize: " + this.f5297d, e);
                }
                this.f5296c.f5285b = 1;
                return;
            }
        }
    }

    public final int[] e(int i7) {
        byte[] bArr = new byte[i7 * 3];
        int[] iArr = null;
        try {
            this.f5295b.get(bArr);
            iArr = new int[256];
            int i8 = 0;
            int i9 = 0;
            while (i8 < i7) {
                int i10 = i9 + 1;
                int i11 = i10 + 1;
                int i12 = i11 + 1;
                int i13 = i8 + 1;
                iArr[i8] = ((bArr[i9] & 255) << 16) | (-16777216) | ((bArr[i10] & 255) << 8) | (bArr[i11] & 255);
                i9 = i12;
                i8 = i13;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.f5296c.f5285b = 1;
        }
        return iArr;
    }

    public final int f() {
        return this.f5295b.getShort();
    }

    public final void g() {
        int c7;
        do {
            c7 = c();
            this.f5295b.position(Math.min(this.f5295b.position() + c7, this.f5295b.limit()));
        } while (c7 > 0);
    }
}
