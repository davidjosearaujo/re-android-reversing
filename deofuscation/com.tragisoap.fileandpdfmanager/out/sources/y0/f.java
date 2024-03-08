package y0;

import java.util.ArrayList;
import w0.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f extends j {
    public d[] c1;
    public int F0 = -1;
    public int G0 = -1;
    public int H0 = -1;
    public int I0 = -1;
    public int J0 = -1;
    public int K0 = -1;
    public float L0 = 0.5f;
    public float M0 = 0.5f;
    public float N0 = 0.5f;
    public float O0 = 0.5f;
    public float P0 = 0.5f;
    public float Q0 = 0.5f;
    public int R0 = 0;
    public int S0 = 0;
    public int T0 = 2;
    public int U0 = 2;
    public int V0 = 0;
    public int W0 = -1;
    public int X0 = 0;
    public ArrayList<a> Y0 = new ArrayList<>();
    public d[] Z0 = null;

    /* renamed from: a1  reason: collision with root package name */
    public d[] f6558a1 = null;

    /* renamed from: b1  reason: collision with root package name */
    public int[] f6559b1 = null;

    /* renamed from: d1  reason: collision with root package name */
    public int f6560d1 = 0;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f6561a;

        /* renamed from: d  reason: collision with root package name */
        public c f6564d;
        public c e;

        /* renamed from: f  reason: collision with root package name */
        public c f6565f;

        /* renamed from: g  reason: collision with root package name */
        public c f6566g;

        /* renamed from: h  reason: collision with root package name */
        public int f6567h;

        /* renamed from: i  reason: collision with root package name */
        public int f6568i;

        /* renamed from: j  reason: collision with root package name */
        public int f6569j;

        /* renamed from: k  reason: collision with root package name */
        public int f6570k;

        /* renamed from: q  reason: collision with root package name */
        public int f6575q;

        /* renamed from: b  reason: collision with root package name */
        public d f6562b = null;

        /* renamed from: c  reason: collision with root package name */
        public int f6563c = 0;

        /* renamed from: l  reason: collision with root package name */
        public int f6571l = 0;
        public int m = 0;

        /* renamed from: n  reason: collision with root package name */
        public int f6572n = 0;

        /* renamed from: o  reason: collision with root package name */
        public int f6573o = 0;

        /* renamed from: p  reason: collision with root package name */
        public int f6574p = 0;

        public a(int i7, c cVar, c cVar2, c cVar3, c cVar4, int i8) {
            this.f6567h = 0;
            this.f6568i = 0;
            this.f6569j = 0;
            this.f6570k = 0;
            this.f6575q = 0;
            this.f6561a = i7;
            this.f6564d = cVar;
            this.e = cVar2;
            this.f6565f = cVar3;
            this.f6566g = cVar4;
            this.f6567h = f.this.f6589y0;
            this.f6568i = f.this.f6585u0;
            this.f6569j = f.this.f6590z0;
            this.f6570k = f.this.f6586v0;
            this.f6575q = i8;
        }

        public final void a(d dVar) {
            int i7 = 0;
            if (this.f6561a == 0) {
                int V = f.this.V(this.f6575q, dVar);
                if (dVar.V[0] == 3) {
                    this.f6574p++;
                    V = 0;
                }
                f fVar = f.this;
                i7 = fVar.R0;
                if (dVar.f6528j0 != 8) {
                }
                this.f6571l = V + i7 + this.f6571l;
                int U = fVar.U(this.f6575q, dVar);
                if (this.f6562b == null || this.f6563c < U) {
                    this.f6562b = dVar;
                    this.f6563c = U;
                    this.m = U;
                }
            } else {
                int V2 = f.this.V(this.f6575q, dVar);
                int U2 = f.this.U(this.f6575q, dVar);
                if (dVar.V[1] == 3) {
                    this.f6574p++;
                    U2 = 0;
                }
                i7 = f.this.S0;
                if (dVar.f6528j0 != 8) {
                }
                this.m = U2 + i7 + this.m;
                if (this.f6562b == null || this.f6563c < V2) {
                    this.f6562b = dVar;
                    this.f6563c = V2;
                    this.f6571l = V2;
                }
            }
            this.f6573o++;
        }

        /* JADX WARN: Removed duplicated region for block: B:144:0x01f2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void b(int r17, boolean r18, boolean r19) {
            /*
                Method dump skipped, instructions count: 732
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: y0.f.a.b(int, boolean, boolean):void");
        }

        public final int c() {
            return this.f6561a == 1 ? this.m - f.this.S0 : this.m;
        }

        public final int d() {
            return this.f6561a == 0 ? this.f6571l - f.this.R0 : this.f6571l;
        }

        public final void e(int i7) {
            int i8;
            int i9;
            int i10;
            int i11 = this.f6574p;
            if (i11 != 0) {
                int i12 = this.f6573o;
                int i13 = i7 / i11;
                for (int i14 = 0; i14 < i12; i14++) {
                    int i15 = this.f6572n + i14;
                    f fVar = f.this;
                    if (i15 >= fVar.f6560d1) {
                        break;
                    }
                    d dVar = fVar.c1[i15];
                    int i16 = 1;
                    if (this.f6561a == 0) {
                        if (dVar != null) {
                            int[] iArr = dVar.V;
                            if (iArr[0] == 3 && dVar.s == 0) {
                                i9 = iArr[1];
                                i8 = dVar.l();
                                i10 = i13;
                                fVar.T(dVar, i16, i10, i9, i8);
                            }
                        }
                    } else {
                        if (dVar != null) {
                            int[] iArr2 = dVar.V;
                            if (iArr2[1] == 3 && dVar.f6544t == 0) {
                                i16 = iArr2[0];
                                i10 = dVar.r();
                                i8 = i13;
                                i9 = 1;
                                fVar.T(dVar, i16, i10, i9, i8);
                            }
                        }
                    }
                }
                this.f6571l = 0;
                this.m = 0;
                this.f6562b = null;
                this.f6563c = 0;
                int i17 = this.f6573o;
                for (int i18 = 0; i18 < i17; i18++) {
                    int i19 = this.f6572n + i18;
                    f fVar2 = f.this;
                    if (i19 < fVar2.f6560d1) {
                        d dVar2 = fVar2.c1[i19];
                        if (this.f6561a == 0) {
                            int r6 = dVar2.r();
                            f fVar3 = f.this;
                            int i20 = fVar3.R0;
                            if (dVar2.f6528j0 == 8) {
                                i20 = 0;
                            }
                            this.f6571l = r6 + i20 + this.f6571l;
                            int U = fVar3.U(this.f6575q, dVar2);
                            if (this.f6562b == null || this.f6563c < U) {
                                this.f6562b = dVar2;
                                this.f6563c = U;
                                this.m = U;
                            }
                        } else {
                            int V = fVar2.V(this.f6575q, dVar2);
                            int U2 = f.this.U(this.f6575q, dVar2);
                            int i21 = f.this.S0;
                            if (dVar2.f6528j0 == 8) {
                                i21 = 0;
                            }
                            this.m = U2 + i21 + this.m;
                            if (this.f6562b == null || this.f6563c < V) {
                                this.f6562b = dVar2;
                                this.f6563c = V;
                                this.f6571l = V;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public final void f(int i7, c cVar, c cVar2, c cVar3, c cVar4, int i8, int i9, int i10, int i11, int i12) {
            this.f6561a = i7;
            this.f6564d = cVar;
            this.e = cVar2;
            this.f6565f = cVar3;
            this.f6566g = cVar4;
            this.f6567h = i8;
            this.f6568i = i9;
            this.f6569j = i10;
            this.f6570k = i11;
            this.f6575q = i12;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0183, code lost:
        if (r7 <= r1) goto L_0x0186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0185, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0186, code lost:
        if (r0 == false) goto L_0x01bf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0188, code lost:
        r29 = r9;
        r30 = r29;
        r31 = r14;
        r14 = r6;
        r4 = new y0.f.a(r34, r3, r8.K, r8.L, r8.M, r8.N, r30);
        r4.f6572n = r11;
        r8.Y0.add(r4);
        r2 = r4;
        r3 = r16;
        r0 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01bf, code lost:
        r30 = r29;
        r29 = r9;
        r31 = r14;
        r14 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01c6, code lost:
        if (r11 <= 0) goto L_0x01ce;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01c8, code lost:
        r16 = (r8.R0 + r16) + r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01ce, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01d1, code lost:
        r2.a(r14);
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01e0, code lost:
        r31 = r14;
        r29 = r9;
        r14 = r29;
        r30 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01ec, code lost:
        r31 = r14;
        r30 = r29;
        r29 = r9;
        r2 = r2;
        r0 = 0;
        r1 = 0;
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01f6, code lost:
        if (r9 >= r4) goto L_0x0261;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01f8, code lost:
        r11 = r0[r9];
        r16 = r8.U(r30, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0206, code lost:
        if (r11.V[1] != 3) goto L_0x020a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0208, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x020c, code lost:
        if (r1 == r30) goto L_0x0215;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0213, code lost:
        if (((r8.S0 + r1) + r16) <= r30) goto L_0x021b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0217, code lost:
        if (r2.f6562b == null) goto L_0x021b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0219, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x021b, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x021c, code lost:
        if (r0 != false) goto L_0x0227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x021e, code lost:
        if (r9 <= 0) goto L_0x0227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0220, code lost:
        r3 = r8.W0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0222, code lost:
        if (r3 <= 0) goto L_0x0227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0224, code lost:
        if (r3 >= 0) goto L_0x0227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0226, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0227, code lost:
        if (r0 == false) goto L_0x0248;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0229, code lost:
        r30 = r15;
        r7 = new y0.f.a(r34, r3, r8.K, r8.L, r8.M, r8.N, r30);
        r7.f6572n = r9;
        r8.Y0.add(r7);
        r2 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0248, code lost:
        r30 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x024a, code lost:
        if (r9 <= 0) goto L_0x0253;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x024c, code lost:
        r1 = (r8.S0 + r16) + r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0253, code lost:
        r1 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0255, code lost:
        r2.a(r11);
        r9 = r9 + 1;
        r30 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0261, code lost:
        r14 = r30;
        r30 = r15;
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0266, code lost:
        r0 = r8.Y0.size();
        r2 = r8.K;
        r3 = r8.L;
        r4 = r8.M;
        r5 = r8.N;
        r6 = r8.f6589y0;
        r7 = r8.f6585u0;
        r9 = r8.f6590z0;
        r11 = r8.f6586v0;
        r12 = r8.V;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0282, code lost:
        if (r12[0] == 2) goto L_0x028c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0287, code lost:
        if (r12[1] != 2) goto L_0x028a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x028a, code lost:
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x028c, code lost:
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x028d, code lost:
        if (r1 <= 0) goto L_0x02af;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x028f, code lost:
        if (r12 == false) goto L_0x02af;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0291, code lost:
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0292, code lost:
        if (r1 >= r0) goto L_0x02af;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0294, code lost:
        r12 = r8.Y0.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x029c, code lost:
        if (r3 != 0) goto L_0x02a3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x029e, code lost:
        r13 = r12.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02a3, code lost:
        r13 = r12.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02a7, code lost:
        r12.e(r14 - r13);
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x02af, code lost:
        r1 = 0;
        r12 = 0;
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x02b2, code lost:
        if (r1 >= r0) goto L_0x0361;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02b4, code lost:
        r15 = r8.Y0.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02bc, code lost:
        if (r3 != 0) goto L_0x030e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x02c0, code lost:
        if (r1 >= (r0 - 1)) goto L_0x02d4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x02c2, code lost:
        r5 = r8.Y0.get(r1 + 1).f6562b.L;
        r32 = r10;
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x02d4, code lost:
        r5 = r8.N;
        r11 = r8.f6586v0;
        r32 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x02da, code lost:
        r3 = r15.f6562b.N;
        r15.f(r3, r2, r3, r4, r5, r6, r7, r9, r11, r14);
        r12 = java.lang.Math.max(r12, r15.d());
        r7 = r15.c() + r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0304, code lost:
        if (r1 <= 0) goto L_0x0309;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0306, code lost:
        r7 = r7 + r8.S0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0309, code lost:
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x030e, code lost:
        r32 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0312, code lost:
        if (r1 >= (r0 - 1)) goto L_0x0324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0314, code lost:
        r4 = r8.Y0.get(r1 + 1).f6562b.K;
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0324, code lost:
        r4 = r8.M;
        r9 = r8.f6590z0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0328, code lost:
        r2 = r15.f6562b.M;
        r15.f(r3, r2, r3, r4, r5, r6, r7, r9, r11, r14);
        r2 = r15.d() + r12;
        r13 = java.lang.Math.max(r13, r15.c());
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0352, code lost:
        if (r1 <= 0) goto L_0x0357;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0354, code lost:
        r2 = r2 + r8.R0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0357, code lost:
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x035b, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0361, code lost:
        r32 = r10;
        r32[0] = r12;
        r32[1] = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x036b, code lost:
        r32 = r6;
        r31 = r14;
        r0 = r8.X0;
        r1 = r8.W0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x037b, code lost:
        if (r0 != 0) goto L_0x03a0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x037d, code lost:
        if (r1 > 0) goto L_0x039d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x037f, code lost:
        r1 = 0;
        r2 = 0;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0382, code lost:
        if (r1 >= r4) goto L_0x039c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0384, code lost:
        if (r1 <= 0) goto L_0x0389;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0386, code lost:
        r2 = r2 + r8.R0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0389, code lost:
        r4 = r0[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x038b, code lost:
        if (r4 != null) goto L_0x038e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x038e, code lost:
        r4 = r8.V(r0, r4) + r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0393, code lost:
        if (r4 <= r0) goto L_0x0396;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0396, code lost:
        r3 = r3 + 1;
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0399, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x039c, code lost:
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x039d, code lost:
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x03a0, code lost:
        if (r1 > 0) goto L_0x03c0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x03a2, code lost:
        r1 = 0;
        r2 = 0;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x03a5, code lost:
        if (r1 >= r4) goto L_0x03bf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x03a7, code lost:
        if (r1 <= 0) goto L_0x03ac;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x03a9, code lost:
        r2 = r2 + r8.S0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x03ac, code lost:
        r4 = r0[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x03ae, code lost:
        if (r4 != null) goto L_0x03b1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x03b1, code lost:
        r4 = r8.U(r0, r4) + r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x03b6, code lost:
        if (r4 <= r0) goto L_0x03b9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x03b9, code lost:
        r3 = r3 + 1;
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x03bc, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x03bf, code lost:
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x03c0, code lost:
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x03c3, code lost:
        if (r8.f6559b1 != null) goto L_0x03ca;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x03c5, code lost:
        r8.f6559b1 = new int[2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x03ca, code lost:
        if (r1 != 0) goto L_0x03cf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x03cd, code lost:
        if (r0 == 1) goto L_0x03d3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x03cf, code lost:
        if (r2 != 0) goto L_0x03e6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x03d1, code lost:
        if (r0 != 0) goto L_0x03e6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x03d3, code lost:
        r3 = r37;
        r4 = r38;
        r5 = r0;
        r6 = r1;
        r7 = r2;
        r9 = r8;
        r15 = r15;
        r10 = r32;
        r0 = true;
        r1 = r35;
        r2 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x03e6, code lost:
        r3 = r37;
        r4 = r38;
        r5 = r0;
        r6 = r1;
        r7 = r2;
        r0 = r8;
        r15 = r15;
        r9 = r32;
        r10 = false;
        r1 = r35;
        r2 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x03f7, code lost:
        if (r10 != false) goto L_0x04fa;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x03f9, code lost:
        if (r5 != 0) goto L_0x040a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x03fb, code lost:
        r34 = r0;
        r35 = r1;
        r6 = (int) java.lang.Math.ceil((double) (((float) r4) / ((float) r7)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x040a, code lost:
        r34 = r0;
        r35 = r1;
        r7 = (int) java.lang.Math.ceil((double) (((float) r4) / ((float) r6)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0418, code lost:
        r0 = r8.f6558a1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x041a, code lost:
        if (r0 == null) goto L_0x0425;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x041d, code lost:
        if (r0.length >= r7) goto L_0x0420;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x0420, code lost:
        r1 = null;
        java.util.Arrays.fill(r0, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0425, code lost:
        r1 = null;
        r8.f6558a1 = new y0.d[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x042a, code lost:
        r0 = r8.Z0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x042c, code lost:
        if (r0 == null) goto L_0x0436;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x042f, code lost:
        if (r0.length >= r6) goto L_0x0432;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x0432, code lost:
        java.util.Arrays.fill(r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0436, code lost:
        r8.Z0 = new y0.d[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x043a, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x043b, code lost:
        if (r0 >= r7) goto L_0x048f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x043d, code lost:
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x043e, code lost:
        if (r1 >= r6) goto L_0x0488;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0440, code lost:
        r11 = (r1 * r7) + r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0446, code lost:
        if (r5 != 1) goto L_0x044c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0448, code lost:
        r11 = (r0 * r6) + r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x044d, code lost:
        if (r11 < r0.length) goto L_0x0452;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x044f, code lost:
        r37 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0452, code lost:
        r2 = r0[r11];
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0454, code lost:
        if (r2 != null) goto L_0x0457;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0457, code lost:
        r11 = r8.V(r0, r2);
        r37 = r3;
        r3 = r8.f6558a1[r0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0461, code lost:
        if (r3 == null) goto L_0x0469;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0467, code lost:
        if (r3.r() >= r11) goto L_0x046d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0469, code lost:
        r8.f6558a1[r0] = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x046d, code lost:
        r3 = r8.U(r0, r2);
        r11 = r8.Z0[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x0475, code lost:
        if (r11 == null) goto L_0x047d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x047b, code lost:
        if (r11.l() >= r3) goto L_0x0481;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x047d, code lost:
        r8.Z0[r1] = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0481, code lost:
        r1 = r1 + 1;
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x0488, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x048f, code lost:
        r0 = 0;
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0495, code lost:
        if (r0 >= r7) goto L_0x04ab;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0497, code lost:
        r2 = r8.f6558a1[r0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x049b, code lost:
        if (r2 == null) goto L_0x04a8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x049d, code lost:
        if (r0 <= 0) goto L_0x04a2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x049f, code lost:
        r1 = r1 + r8.R0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x04a2, code lost:
        r1 = r8.V(r0, r2) + r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x04a8, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x04ab, code lost:
        r0 = 0;
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x04ad, code lost:
        if (r0 >= r6) goto L_0x04c3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x04af, code lost:
        r3 = r8.Z0[r0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x04b3, code lost:
        if (r3 == null) goto L_0x04c0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x04b5, code lost:
        if (r0 <= 0) goto L_0x04ba;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x04b7, code lost:
        r2 = r2 + r8.S0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x04ba, code lost:
        r2 = r8.U(r0, r3) + r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x04c0, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x04c3, code lost:
        r9[0] = r1;
        r0 = true;
        r9[1] = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x04c9, code lost:
        if (r5 != 0) goto L_0x04d2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x04cb, code lost:
        if (r1 <= r0) goto L_0x04e2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x04cd, code lost:
        if (r7 <= 1) goto L_0x04e2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x04cf, code lost:
        r7 = r7 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x04d2, code lost:
        if (r2 <= r0) goto L_0x04e2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x04d4, code lost:
        if (r6 <= 1) goto L_0x04e2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x04d6, code lost:
        r6 = r6 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x04d8, code lost:
        r0 = r34;
        r1 = r35;
        r2 = r2;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x04e2, code lost:
        r1 = r35;
        r2 = r2;
        r3 = r3;
        r10 = r32;
        r32 = r9;
        r9 = r8;
        r8 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x04fa, code lost:
        r1 = r8.f6559b1;
        r1[0] = r7;
        r1[1] = r6;
        r8 = r0;
        r0 = r1;
        r1 = r2;
        r2 = r3;
        r13 = r13;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x0518, code lost:
        r32 = r6;
        r29 = r7;
        r28 = r13;
        r31 = r14;
        r30 = r15;
        r9 = r8.X0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0526, code lost:
        if (r4 != 0) goto L_0x052a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x052a, code lost:
        r8.Y0.clear();
        r10 = new y0.f.a(r34, r9, r8.K, r8.L, r8.M, r8.N, r0);
        r8.Y0.add(r10);
        r0 = 0;
        r1 = 0;
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0549, code lost:
        if (r9 != 0) goto L_0x05ab;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x054b, code lost:
        if (r11 >= r4) goto L_0x060f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x054d, code lost:
        r15 = r0[r11];
        r16 = r8.V(r0, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x0559, code lost:
        if (r15.V[0] != 3) goto L_0x055d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x055b, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x055f, code lost:
        if (r1 == r0) goto L_0x0568;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x0566, code lost:
        if (((r8.R0 + r1) + r16) <= r0) goto L_0x056e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x056a, code lost:
        if (r10.f6562b == null) goto L_0x056e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x056c, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x056e, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x056f, code lost:
        if (r0 != false) goto L_0x057c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x0571, code lost:
        if (r11 <= 0) goto L_0x057c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x0573, code lost:
        r2 = r8.W0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x0575, code lost:
        if (r2 <= 0) goto L_0x057c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x0579, code lost:
        if ((r11 % r2) != 0) goto L_0x057c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x057b, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x057c, code lost:
        if (r0 == false) goto L_0x0598;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x057e, code lost:
        r10 = new y0.f.a(r34, r9, r8.K, r8.L, r8.M, r8.N, r0);
        r10.f6572n = r11;
        r8.Y0.add(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x0598, code lost:
        if (r11 <= 0) goto L_0x05a1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x059a, code lost:
        r1 = (r8.R0 + r16) + r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x05a1, code lost:
        r1 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x05a3, code lost:
        r10.a(r15);
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x05ab, code lost:
        if (r11 >= r4) goto L_0x060f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x05ad, code lost:
        r15 = r0[r11];
        r16 = r8.U(r0, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x05b9, code lost:
        if (r15.V[1] != 3) goto L_0x05bd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x05bb, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x05bf, code lost:
        if (r1 == r0) goto L_0x05c8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x05c6, code lost:
        if (((r8.S0 + r1) + r16) <= r0) goto L_0x05ce;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x05ca, code lost:
        if (r10.f6562b == null) goto L_0x05ce;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x05cc, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x05ce, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x05cf, code lost:
        if (r0 != false) goto L_0x05dc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x05d1, code lost:
        if (r11 <= 0) goto L_0x05dc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x05d3, code lost:
        r2 = r8.W0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x05d5, code lost:
        if (r2 <= 0) goto L_0x05dc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x05d9, code lost:
        if ((r11 % r2) != 0) goto L_0x05dc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x05db, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x05dc, code lost:
        if (r0 == false) goto L_0x05fa;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x05de, code lost:
        r10 = new y0.f.a(r34, r9, r8.K, r8.L, r8.M, r8.N, r0);
        r10.f6572n = r11;
        r8.Y0.add(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x05fc, code lost:
        if (r11 <= 0) goto L_0x0605;
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x05fe, code lost:
        r1 = (r8.S0 + r16) + r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x0605, code lost:
        r1 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x0607, code lost:
        r10.a(r15);
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x060f, code lost:
        r1 = r8.Y0.size();
        r2 = r8.K;
        r3 = r8.L;
        r4 = r8.M;
        r5 = r8.N;
        r6 = r8.f6589y0;
        r7 = r8.f6585u0;
        r10 = r8.f6590z0;
        r11 = r8.f6586v0;
        r12 = r8.V;
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x062b, code lost:
        if (r12[0] == 2) goto L_0x0635;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x0630, code lost:
        if (r12[1] != 2) goto L_0x0633;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x0633, code lost:
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x0635, code lost:
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x0636, code lost:
        if (r0 <= 0) goto L_0x0658;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x0638, code lost:
        if (r12 == false) goto L_0x0658;
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x063a, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x063b, code lost:
        if (r0 >= r1) goto L_0x0658;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x063d, code lost:
        r12 = r8.Y0.get(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x0645, code lost:
        if (r9 != 0) goto L_0x064c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x0647, code lost:
        r13 = r12.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x064c, code lost:
        r13 = r12.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x0650, code lost:
        r12.e(r0 - r13);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x0658, code lost:
        r0 = 0;
        r12 = 0;
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x065b, code lost:
        if (r0 >= r1) goto L_0x070c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x065d, code lost:
        r15 = r8.Y0.get(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x0665, code lost:
        if (r9 != 0) goto L_0x06b7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x0669, code lost:
        if (r0 >= (r1 - 1)) goto L_0x067d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x066b, code lost:
        r5 = r8.Y0.get(r0 + 1).f6562b.L;
        r27 = r1;
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x067d, code lost:
        r5 = r8.N;
        r11 = r8.f6586v0;
        r27 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x0683, code lost:
        r3 = r15.f6562b.N;
        r15.f(r9, r2, r3, r4, r5, r6, r7, r10, r11, r0);
        r12 = java.lang.Math.max(r12, r15.d());
        r7 = r15.c() + r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x06ad, code lost:
        if (r0 <= 0) goto L_0x06b2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x06af, code lost:
        r7 = r7 + r8.S0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x06b2, code lost:
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x06b7, code lost:
        r27 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x06bb, code lost:
        if (r0 >= (r27 - 1)) goto L_0x06cd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x06bd, code lost:
        r1 = r8.Y0.get(r0 + 1).f6562b.K;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x06cd, code lost:
        r1 = r8.M;
        r4 = r8.f6590z0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x06d1, code lost:
        r2 = r15.f6562b.M;
        r15.f(r9, r2, r3, r1, r5, r6, r7, r4, r11, r0);
        r2 = r15.d() + r12;
        r13 = java.lang.Math.max(r13, r15.c());
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x06fb, code lost:
        if (r0 <= 0) goto L_0x0700;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x06fd, code lost:
        r2 = r2 + r8.R0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x0700, code lost:
        r6 = 0;
        r10 = r4;
        r4 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x0706, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x070c, code lost:
        r32[0] = r12;
        r32[1] = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x0713, code lost:
        r32 = r6;
        r29 = r7;
        r28 = r13;
        r31 = r14;
        r30 = r15;
        r2 = r8.X0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x0721, code lost:
        if (r4 != 0) goto L_0x073c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x0723, code lost:
        r0 = r35;
        r1 = r36;
        r2 = r37;
        r4 = r38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x0731, code lost:
        r4 = 0;
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x0742, code lost:
        if (r8.Y0.size() != 0) goto L_0x075b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x0744, code lost:
        r9 = new y0.f.a(r34, r2, r8.K, r8.L, r8.M, r8.N, r0);
        r8.Y0.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x075b, code lost:
        r9 = r8.Y0.get(0);
        r9.f6563c = 0;
        r9.f6562b = null;
        r9.f6571l = 0;
        r9.m = 0;
        r9.f6572n = 0;
        r9.f6573o = 0;
        r9.f6574p = 0;
        r9.f(r2, r8.K, r8.L, r8.M, r8.N, r8.f6589y0, r8.f6585u0, r8.f6590z0, r8.f6586v0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x079d, code lost:
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x079e, code lost:
        if (r4 >= r4) goto L_0x07a8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x07a0, code lost:
        r9.a(r0[r4]);
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x07a8, code lost:
        r4 = 0;
        r32[0] = r9.d();
        r1 = 1;
        r32[1] = r9.c();
        r0 = r35;
        r2 = r36;
        r3 = r37;
        r5 = r38;
        r13 = r28;
        r7 = r29;
        r15 = r30;
        r14 = r31;
        r6 = r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x07c8, code lost:
        r9 = (r6[r4] + r13) + r14;
        r6 = (r6[r1] + r15) + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x07d4, code lost:
        if (r0 != 1073741824) goto L_0x07d8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x07d6, code lost:
        r0 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x07d8, code lost:
        if (r0 != Integer.MIN_VALUE) goto L_0x07df;
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x07da, code lost:
        r0 = java.lang.Math.min(r9, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x07df, code lost:
        if (r0 != 0) goto L_0x07e3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x07e1, code lost:
        r0 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x07e3, code lost:
        r0 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x07e4, code lost:
        if (r3 != 1073741824) goto L_0x07e8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x07e6, code lost:
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x07e8, code lost:
        if (r3 != Integer.MIN_VALUE) goto L_0x07ef;
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x07ea, code lost:
        r2 = java.lang.Math.min(r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x07ef, code lost:
        if (r3 != 0) goto L_0x07f3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x07f1, code lost:
        r2 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x07f3, code lost:
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x07f4, code lost:
        r8.B0 = r0;
        r8.C0 = r2;
        r8.O(r0);
        r8.L(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x0800, code lost:
        if (r8.f6584t0 <= 0) goto L_0x0804;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x0802, code lost:
        r11 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x0804, code lost:
        r11 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x0805, code lost:
        r8.A0 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x0807, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ae, code lost:
        if (r8.G0 == -1) goto L_0x00bb;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b9, code lost:
        if (r8.G0 == -1) goto L_0x00bb;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00bb, code lost:
        r8.G0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00bd, code lost:
        r0 = r8.f6583s0;
        r2 = 0;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c1, code lost:
        r4 = r8.f6584t0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c5, code lost:
        if (r2 >= r4) goto L_0x00d4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00cd, code lost:
        if (r8.f6583s0[r2].f6528j0 != 8) goto L_0x00d1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00cf, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00d1, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d4, code lost:
        if (r3 <= 0) goto L_0x00ef;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d6, code lost:
        r0 = new y0.d[r4 - r3];
        r2 = 0;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00dd, code lost:
        if (r2 >= r8.f6584t0) goto L_0x00ef;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00df, code lost:
        r3 = r8.f6583s0[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e5, code lost:
        if (r3.f6528j0 == 8) goto L_0x00eb;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00e7, code lost:
        r0[r4] = r3;
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00eb, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ef, code lost:
        r8.c1 = r0;
        r8.f6560d1 = r4;
        r0 = r8.V0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00f6, code lost:
        if (r0 == 0) goto L_0x0713;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f8, code lost:
        if (r0 == 1) goto L_0x0518;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00fa, code lost:
        if (r0 == 2) goto L_0x036b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00fc, code lost:
        if (r0 == 3) goto L_0x010a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00fe, code lost:
        r0 = r35;
        r2 = r36;
        r3 = r37;
        r5 = r38;
        r1 = 1;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x010a, code lost:
        r3 = r8.X0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x010c, code lost:
        if (r4 != 0) goto L_0x011a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x010e, code lost:
        r32 = r6;
        r29 = r7;
        r28 = r13;
        r31 = r14;
        r30 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x011a, code lost:
        r8.Y0.clear();
        r28 = r13;
        r29 = r0;
        r10 = r6;
        r9 = r7;
        r2 = new y0.f.a(r34, r3, r8.K, r8.L, r8.M, r8.N, r29);
        r8.Y0.add(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x014b, code lost:
        if (r3 != 0) goto L_0x01ec;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x014d, code lost:
        r2 = r2;
        r0 = 0;
        r1 = 0;
        r3 = 0;
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0152, code lost:
        if (r11 >= r4) goto L_0x01e0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0154, code lost:
        r7 = r0 + 1;
        r6 = r0[r11];
        r16 = r8.V(r29, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0165, code lost:
        if (r6.V[0] != 3) goto L_0x0169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0167, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x016b, code lost:
        if (r3 == r29) goto L_0x0174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0172, code lost:
        if (((r8.R0 + r3) + r16) <= r29) goto L_0x017a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0176, code lost:
        if (r2.f6562b == null) goto L_0x017a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0178, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x017a, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x017b, code lost:
        if (r0 != false) goto L_0x0186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x017d, code lost:
        if (r11 <= 0) goto L_0x0186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x017f, code lost:
        r1 = r8.W0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0181, code lost:
        if (r1 <= 0) goto L_0x0186;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // y0.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void S(int r35, int r36, int r37, int r38) {
        /*
            Method dump skipped, instructions count: 2056
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.f.S(int, int, int, int):void");
    }

    public final int U(int i7, d dVar) {
        if (dVar == null) {
            return 0;
        }
        if (dVar.V[1] == 3) {
            int i8 = dVar.f6544t;
            if (i8 == 0) {
                return 0;
            }
            if (i8 == 2) {
                int i9 = (int) (dVar.A * ((float) i7));
                if (i9 != dVar.l()) {
                    dVar.f6521g = true;
                    T(dVar, dVar.V[0], dVar.r(), 1, i9);
                }
                return i9;
            } else if (i8 == 1) {
                return dVar.l();
            } else {
                if (i8 == 3) {
                    return (int) ((((float) dVar.r()) * dVar.Z) + 0.5f);
                }
            }
        }
        return dVar.l();
    }

    public final int V(int i7, d dVar) {
        if (dVar == null) {
            return 0;
        }
        if (dVar.V[0] == 3) {
            int i8 = dVar.s;
            if (i8 == 0) {
                return 0;
            }
            if (i8 == 2) {
                int i9 = (int) (dVar.f6548x * ((float) i7));
                if (i9 != dVar.r()) {
                    dVar.f6521g = true;
                    T(dVar, 1, i9, dVar.V[1], dVar.l());
                }
                return i9;
            } else if (i8 == 1) {
                return dVar.r();
            } else {
                if (i8 == 3) {
                    return (int) ((((float) dVar.l()) * dVar.Z) + 0.5f);
                }
            }
        }
        return dVar.r();
    }

    @Override // y0.d
    public final void c(d dVar, boolean z6) {
        d dVar2;
        int i7;
        super.c(dVar, z6);
        d dVar3 = this.W;
        boolean z7 = dVar3 != null && ((e) dVar3).f6555x0;
        int i8 = this.V0;
        if (i8 != 0) {
            if (i8 == 1) {
                int size = this.Y0.size();
                int i9 = 0;
                while (i9 < size) {
                    this.Y0.get(i9).b(i9, z7, i9 == size + -1);
                    i9++;
                }
            } else if (i8 != 2) {
                if (i8 == 3) {
                    int size2 = this.Y0.size();
                    int i10 = 0;
                    while (i10 < size2) {
                        this.Y0.get(i10).b(i10, z7, i10 == size2 + -1);
                        i10++;
                    }
                }
            } else if (!(this.f6559b1 == null || this.f6558a1 == null || this.Z0 == null)) {
                for (int i11 = 0; i11 < this.f6560d1; i11++) {
                    this.c1[i11].E();
                }
                int[] iArr = this.f6559b1;
                int i12 = iArr[0];
                int i13 = iArr[1];
                d dVar4 = null;
                float f7 = this.L0;
                int i14 = 0;
                while (i14 < i12) {
                    if (z7) {
                        i7 = (i12 - i14) - 1;
                        f7 = 1.0f - this.L0;
                    } else {
                        i7 = i14;
                    }
                    d dVar5 = this.f6558a1[i7];
                    if (!(dVar5 == null || dVar5.f6528j0 == 8)) {
                        if (i14 == 0) {
                            dVar5.g(dVar5.K, this.K, this.f6589y0);
                            dVar5.f6532l0 = this.F0;
                            dVar5.f6522g0 = f7;
                        }
                        if (i14 == i12 - 1) {
                            dVar5.g(dVar5.M, this.M, this.f6590z0);
                        }
                        if (i14 > 0 && dVar4 != null) {
                            dVar5.g(dVar5.K, dVar4.M, this.R0);
                            dVar4.g(dVar4.M, dVar5.K, 0);
                        }
                        dVar4 = dVar5;
                    }
                    i14++;
                    f7 = f7;
                }
                for (int i15 = 0; i15 < i13; i15++) {
                    d dVar6 = this.Z0[i15];
                    if (!(dVar6 == null || dVar6.f6528j0 == 8)) {
                        if (i15 == 0) {
                            dVar6.g(dVar6.L, this.L, this.f6585u0);
                            dVar6.f6533m0 = this.G0;
                            dVar6.f6524h0 = this.M0;
                        }
                        if (i15 == i13 - 1) {
                            dVar6.g(dVar6.N, this.N, this.f6586v0);
                        }
                        if (i15 > 0 && dVar4 != null) {
                            dVar6.g(dVar6.L, dVar4.N, this.S0);
                            dVar4.g(dVar4.N, dVar6.L, 0);
                        }
                        dVar4 = dVar6;
                    }
                }
                for (int i16 = 0; i16 < i12; i16++) {
                    for (int i17 = 0; i17 < i13; i17++) {
                        int i18 = (i17 * i12) + i16;
                        if (this.X0 == 1) {
                            i18 = (i16 * i13) + i17;
                        }
                        d[] dVarArr = this.c1;
                        if (!(i18 >= dVarArr.length || (dVar2 = dVarArr[i18]) == null || dVar2.f6528j0 == 8)) {
                            d dVar7 = this.f6558a1[i16];
                            d dVar8 = this.Z0[i17];
                            if (dVar2 != dVar7) {
                                dVar2.g(dVar2.K, dVar7.K, 0);
                                dVar2.g(dVar2.M, dVar7.M, 0);
                            }
                            if (dVar2 != dVar8) {
                                dVar2.g(dVar2.L, dVar8.L, 0);
                                dVar2.g(dVar2.N, dVar8.N, 0);
                            }
                        }
                    }
                }
            }
        } else if (this.Y0.size() > 0) {
            this.Y0.get(0).b(0, z7, true);
        }
        this.A0 = false;
    }
}
