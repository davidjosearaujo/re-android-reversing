package o2;

import android.graphics.Bitmap;
import android.util.Log;
import c3.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import o2.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e implements a {

    /* renamed from: a  reason: collision with root package name */
    public int[] f5298a;

    /* renamed from: c  reason: collision with root package name */
    public final a.AbstractC0086a f5300c;

    /* renamed from: d  reason: collision with root package name */
    public ByteBuffer f5301d;
    public byte[] e;

    /* renamed from: f  reason: collision with root package name */
    public short[] f5302f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f5303g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f5304h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f5305i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f5306j;

    /* renamed from: k  reason: collision with root package name */
    public int f5307k;

    /* renamed from: l  reason: collision with root package name */
    public c f5308l;
    public Bitmap m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f5309n;

    /* renamed from: o  reason: collision with root package name */
    public int f5310o;

    /* renamed from: p  reason: collision with root package name */
    public int f5311p;

    /* renamed from: q  reason: collision with root package name */
    public int f5312q;

    /* renamed from: r  reason: collision with root package name */
    public int f5313r;
    public Boolean s;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f5299b = new int[256];

    /* renamed from: t  reason: collision with root package name */
    public Bitmap.Config f5314t = Bitmap.Config.ARGB_8888;

    public e(b bVar, c cVar, ByteBuffer byteBuffer, int i7) {
        this.f5300c = bVar;
        this.f5308l = new c();
        synchronized (this) {
            if (i7 > 0) {
                int highestOneBit = Integer.highestOneBit(i7);
                this.f5310o = 0;
                this.f5308l = cVar;
                this.f5307k = -1;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.f5301d = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.f5301d.order(ByteOrder.LITTLE_ENDIAN);
                this.f5309n = false;
                Iterator it = cVar.e.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((b) it.next()).f5279g == 3) {
                            this.f5309n = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.f5311p = highestOneBit;
                int i8 = cVar.f5288f;
                this.f5313r = i8 / highestOneBit;
                int i9 = cVar.f5289g;
                this.f5312q = i9 / highestOneBit;
                int i10 = i8 * i9;
                s2.b bVar2 = ((b) this.f5300c).f2526b;
                this.f5305i = bVar2 == null ? new byte[i10] : (byte[]) bVar2.c(i10, byte[].class);
                a.AbstractC0086a aVar = this.f5300c;
                int i11 = this.f5313r * this.f5312q;
                s2.b bVar3 = ((b) aVar).f2526b;
                this.f5306j = bVar3 == null ? new int[i11] : (int[]) bVar3.c(i11, int[].class);
            } else {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i7);
            }
        }
    }

    @Override // o2.a
    public final int a() {
        return this.f5307k;
    }

    @Override // o2.a
    public final synchronized Bitmap b() {
        if (this.f5308l.f5286c <= 0 || this.f5307k < 0) {
            if (Log.isLoggable("e", 3)) {
                Log.d("e", "Unable to decode frame, frameCount=" + this.f5308l.f5286c + ", framePointer=" + this.f5307k);
            }
            this.f5310o = 1;
        }
        int i7 = this.f5310o;
        if (!(i7 == 1 || i7 == 2)) {
            this.f5310o = 0;
            if (this.e == null) {
                s2.b bVar = ((b) this.f5300c).f2526b;
                this.e = bVar == null ? new byte[255] : (byte[]) bVar.c(255, byte[].class);
            }
            b bVar2 = (b) this.f5308l.e.get(this.f5307k);
            int i8 = this.f5307k - 1;
            b bVar3 = i8 >= 0 ? (b) this.f5308l.e.get(i8) : null;
            int[] iArr = bVar2.f5283k;
            if (iArr == null) {
                iArr = this.f5308l.f5284a;
            }
            this.f5298a = iArr;
            if (iArr == null) {
                if (Log.isLoggable("e", 3)) {
                    Log.d("e", "No valid color table found for frame #" + this.f5307k);
                }
                this.f5310o = 1;
                return null;
            }
            if (bVar2.f5278f) {
                System.arraycopy(iArr, 0, this.f5299b, 0, iArr.length);
                int[] iArr2 = this.f5299b;
                this.f5298a = iArr2;
                iArr2[bVar2.f5280h] = 0;
                if (bVar2.f5279g == 2 && this.f5307k == 0) {
                    this.s = Boolean.TRUE;
                }
            }
            return j(bVar2, bVar3);
        }
        if (Log.isLoggable("e", 3)) {
            Log.d("e", "Unable to decode frame, status=" + this.f5310o);
        }
        return null;
    }

    @Override // o2.a
    public final void c() {
        this.f5307k = (this.f5307k + 1) % this.f5308l.f5286c;
    }

    @Override // o2.a
    public final void clear() {
        s2.b bVar;
        s2.b bVar2;
        s2.b bVar3;
        this.f5308l = null;
        byte[] bArr = this.f5305i;
        if (!(bArr == null || (bVar3 = ((b) this.f5300c).f2526b) == null)) {
            bVar3.put(bArr);
        }
        int[] iArr = this.f5306j;
        if (!(iArr == null || (bVar2 = ((b) this.f5300c).f2526b) == null)) {
            bVar2.put(iArr);
        }
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            ((b) this.f5300c).f2525a.e(bitmap);
        }
        this.m = null;
        this.f5301d = null;
        this.s = null;
        byte[] bArr2 = this.e;
        if (bArr2 != null && (bVar = ((b) this.f5300c).f2526b) != null) {
            bVar.put(bArr2);
        }
    }

    @Override // o2.a
    public final int d() {
        return this.f5308l.f5286c;
    }

    @Override // o2.a
    public final int e() {
        int i7;
        c cVar = this.f5308l;
        int i8 = cVar.f5286c;
        if (i8 <= 0 || (i7 = this.f5307k) < 0) {
            return 0;
        }
        if (i7 < 0 || i7 >= i8) {
            return -1;
        }
        return ((b) cVar.e.get(i7)).f5281i;
    }

    @Override // o2.a
    public final int f() {
        return (this.f5306j.length * 4) + this.f5301d.limit() + this.f5305i.length;
    }

    @Override // o2.a
    public final ByteBuffer g() {
        return this.f5301d;
    }

    public final Bitmap h() {
        Boolean bool = this.s;
        Bitmap.Config config = (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f5314t;
        Bitmap c7 = ((b) this.f5300c).f2525a.c(this.f5313r, this.f5312q, config);
        c7.setHasAlpha(true);
        return c7;
    }

    public final void i(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.f5314t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
        if (r3.f5292j == r36.f5280h) goto L_0x0047;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap j(o2.b r36, o2.b r37) {
        /*
            Method dump skipped, instructions count: 1084
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.e.j(o2.b, o2.b):android.graphics.Bitmap");
    }
}
