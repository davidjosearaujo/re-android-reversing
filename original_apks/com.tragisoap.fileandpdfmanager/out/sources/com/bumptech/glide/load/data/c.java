package com.bumptech.glide.load.data;

import java.io.FileOutputStream;
import java.io.OutputStream;
import s2.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c extends OutputStream {

    /* renamed from: f  reason: collision with root package name */
    public final OutputStream f2666f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f2667g;

    /* renamed from: h  reason: collision with root package name */
    public b f2668h;

    /* renamed from: i  reason: collision with root package name */
    public int f2669i;

    public c(FileOutputStream fileOutputStream, b bVar) {
        this.f2666f = fileOutputStream;
        this.f2668h = bVar;
        this.f2667g = (byte[]) bVar.c(65536, byte[].class);
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            flush();
            this.f2666f.close();
            byte[] bArr = this.f2667g;
            if (bArr != null) {
                this.f2668h.put(bArr);
                this.f2667g = null;
            }
        } catch (Throwable th) {
            this.f2666f.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        int i7 = this.f2669i;
        if (i7 > 0) {
            this.f2666f.write(this.f2667g, 0, i7);
            this.f2669i = 0;
        }
        this.f2666f.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i7) {
        byte[] bArr = this.f2667g;
        int i8 = this.f2669i;
        int i9 = i8 + 1;
        this.f2669i = i9;
        bArr[i8] = (byte) i7;
        if (i9 == bArr.length && i9 > 0) {
            this.f2666f.write(bArr, 0, i9);
            this.f2669i = 0;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i7, int i8) {
        int i9 = 0;
        do {
            int i10 = i8 - i9;
            int i11 = i7 + i9;
            int i12 = this.f2669i;
            if (i12 != 0 || i10 < this.f2667g.length) {
                int min = Math.min(i10, this.f2667g.length - i12);
                System.arraycopy(bArr, i11, this.f2667g, this.f2669i, min);
                int i13 = this.f2669i + min;
                this.f2669i = i13;
                i9 += min;
                byte[] bArr2 = this.f2667g;
                if (i13 == bArr2.length && i13 > 0) {
                    this.f2666f.write(bArr2, 0, i13);
                    this.f2669i = 0;
                    continue;
                }
            } else {
                this.f2666f.write(bArr, i11, i10);
                return;
            }
        } while (i9 < i8);
    }
}
