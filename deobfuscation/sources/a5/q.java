package a5;

import androidx.fragment.app.s0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a */
    public final i6.l f261a;

    /* renamed from: b */
    public int f262b;

    /* renamed from: c */
    public final i6.r f263c;

    /* loaded from: classes.dex */
    public class a extends i6.i {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i6.v vVar) {
            super(vVar);
            q.this = r1;
        }

        @Override // i6.i, i6.v
        public final long B(i6.d dVar, long j5) {
            int i7 = q.this.f262b;
            if (i7 == 0) {
                return -1L;
            }
            long B = super.B(dVar, Math.min(j5, i7));
            if (B == -1) {
                return -1L;
            }
            q qVar = q.this;
            qVar.f262b = (int) (qVar.f262b - B);
            return B;
        }
    }

    /* loaded from: classes.dex */
    public class b extends Inflater {
        @Override // java.util.zip.Inflater
        public final int inflate(byte[] bArr, int i7, int i8) {
            int inflate = super.inflate(bArr, i7, i8);
            if (inflate == 0 && needsDictionary()) {
                setDictionary(u.f271a);
                return super.inflate(bArr, i7, i8);
            }
            return inflate;
        }
    }

    public q(i6.f fVar) {
        a aVar = new a(fVar);
        i6.l lVar = new i6.l(i6.p.a(aVar), new b());
        this.f261a = lVar;
        this.f263c = i6.p.a(lVar);
    }

    public final ArrayList a(int i7) {
        this.f262b += i7;
        int readInt = this.f263c.readInt();
        if (readInt >= 0) {
            if (readInt <= 1024) {
                ArrayList arrayList = new ArrayList(readInt);
                for (int i8 = 0; i8 < readInt; i8++) {
                    i6.g e = this.f263c.j(this.f263c.readInt()).e();
                    i6.g j5 = this.f263c.j(this.f263c.readInt());
                    if (e.f4501f.length == 0) {
                        throw new IOException("name.size == 0");
                    }
                    arrayList.add(new m(e, j5));
                }
                if (this.f262b > 0) {
                    this.f261a.b();
                    if (this.f262b != 0) {
                        StringBuilder d7 = androidx.activity.h.d("compressedLimit > 0: ");
                        d7.append(this.f262b);
                        throw new IOException(d7.toString());
                    }
                }
                return arrayList;
            }
            throw new IOException(s0.g("numberOfPairs > 1024: ", readInt));
        }
        throw new IOException(s0.g("numberOfPairs < 0: ", readInt));
    }
}
