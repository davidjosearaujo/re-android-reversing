package a5;

import androidx.activity.h;
import androidx.fragment.app.s0;
import i6.d;
import i6.f;
import i6.g;
import i6.i;
import i6.l;
import i6.p;
import i6.r;
import i6.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.Inflater;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    public final l f261a;

    /* renamed from: b  reason: collision with root package name */
    public int f262b;

    /* renamed from: c  reason: collision with root package name */
    public final r f263c;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends i {
        public a(v vVar) {
            super(vVar);
        }

        @Override // i6.i, i6.v
        public final long B(d dVar, long j7) {
            int i7 = q.this.f262b;
            if (i7 == 0) {
                return -1;
            }
            long B = super.B(dVar, Math.min(j7, (long) i7));
            if (B == -1) {
                return -1;
            }
            q qVar = q.this;
            qVar.f262b = (int) (((long) qVar.f262b) - B);
            return B;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b extends Inflater {
        @Override // java.util.zip.Inflater
        public final int inflate(byte[] bArr, int i7, int i8) {
            int inflate = super.inflate(bArr, i7, i8);
            if (inflate != 0 || !needsDictionary()) {
                return inflate;
            }
            setDictionary(u.f271a);
            return super.inflate(bArr, i7, i8);
        }
    }

    public q(f fVar) {
        a aVar = new a(fVar);
        l lVar = new l(p.a(aVar), new b());
        this.f261a = lVar;
        this.f263c = p.a(lVar);
    }

    public final ArrayList a(int i7) {
        this.f262b += i7;
        int readInt = this.f263c.readInt();
        if (readInt < 0) {
            throw new IOException(s0.g("numberOfPairs < 0: ", readInt));
        } else if (readInt <= 1024) {
            ArrayList arrayList = new ArrayList(readInt);
            for (int i8 = 0; i8 < readInt; i8++) {
                g e = this.f263c.j((long) this.f263c.readInt()).e();
                g j7 = this.f263c.j((long) this.f263c.readInt());
                if (e.f4501f.length != 0) {
                    arrayList.add(new m(e, j7));
                } else {
                    throw new IOException("name.size == 0");
                }
            }
            if (this.f262b > 0) {
                this.f261a.b();
                if (this.f262b != 0) {
                    StringBuilder d7 = h.d("compressedLimit > 0: ");
                    d7.append(this.f262b);
                    throw new IOException(d7.toString());
                }
            }
            return arrayList;
        } else {
            throw new IOException(s0.g("numberOfPairs > 1024: ", readInt));
        }
    }
}
