package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.h;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;
import com.davemorrissey.labs.subscaleview.R;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import linc.com.amplituda.ErrorCode;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c {

    /* renamed from: d */
    public static final int[] f1321d = {0, 4, 8};
    public static SparseIntArray e = new SparseIntArray();

    /* renamed from: f */
    public static SparseIntArray f1322f = new SparseIntArray();

    /* renamed from: a */
    public HashMap<String, b1.a> f1323a = new HashMap<>();

    /* renamed from: b */
    public boolean f1324b = true;

    /* renamed from: c */
    public HashMap<Integer, a> f1325c = new HashMap<>();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {

        /* renamed from: a */
        public int f1326a;

        /* renamed from: b */
        public final d f1327b = new d();

        /* renamed from: c */
        public final C0015c f1328c = new C0015c();

        /* renamed from: d */
        public final b f1329d = new b();
        public final e e = new e();

        /* renamed from: f */
        public HashMap<String, b1.a> f1330f = new HashMap<>();

        /* renamed from: androidx.constraintlayout.widget.c$a$a */
        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static class C0014a {

            /* renamed from: a */
            public int[] f1331a = new int[10];

            /* renamed from: b */
            public int[] f1332b = new int[10];

            /* renamed from: c */
            public int f1333c = 0;

            /* renamed from: d */
            public int[] f1334d = new int[10];
            public float[] e = new float[10];

            /* renamed from: f */
            public int f1335f = 0;

            /* renamed from: g */
            public int[] f1336g = new int[5];

            /* renamed from: h */
            public String[] f1337h = new String[5];

            /* renamed from: i */
            public int f1338i = 0;

            /* renamed from: j */
            public int[] f1339j = new int[4];

            /* renamed from: k */
            public boolean[] f1340k = new boolean[4];

            /* renamed from: l */
            public int f1341l = 0;

            public final void a(float f7, int i7) {
                int i8 = this.f1335f;
                int[] iArr = this.f1334d;
                if (i8 >= iArr.length) {
                    this.f1334d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.e;
                    this.e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f1334d;
                int i9 = this.f1335f;
                iArr2[i9] = i7;
                float[] fArr2 = this.e;
                this.f1335f = i9 + 1;
                fArr2[i9] = f7;
            }

            public final void b(int i7, int i8) {
                int i9 = this.f1333c;
                int[] iArr = this.f1331a;
                if (i9 >= iArr.length) {
                    this.f1331a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f1332b;
                    this.f1332b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f1331a;
                int i10 = this.f1333c;
                iArr3[i10] = i7;
                int[] iArr4 = this.f1332b;
                this.f1333c = i10 + 1;
                iArr4[i10] = i8;
            }

            public final void c(int i7, String str) {
                int i8 = this.f1338i;
                int[] iArr = this.f1336g;
                if (i8 >= iArr.length) {
                    this.f1336g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f1337h;
                    this.f1337h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f1336g;
                int i9 = this.f1338i;
                iArr2[i9] = i7;
                String[] strArr2 = this.f1337h;
                this.f1338i = i9 + 1;
                strArr2[i9] = str;
            }

            public final void d(int i7, boolean z6) {
                int i8 = this.f1341l;
                int[] iArr = this.f1339j;
                if (i8 >= iArr.length) {
                    this.f1339j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f1340k;
                    this.f1340k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f1339j;
                int i9 = this.f1341l;
                iArr2[i9] = i7;
                boolean[] zArr2 = this.f1340k;
                this.f1341l = i9 + 1;
                zArr2[i9] = z6;
            }
        }

        public final void a(ConstraintLayout.a aVar) {
            b bVar = this.f1329d;
            aVar.e = bVar.f1356h;
            aVar.f1272f = bVar.f1358i;
            aVar.f1274g = bVar.f1360j;
            aVar.f1276h = bVar.f1362k;
            aVar.f1278i = bVar.f1364l;
            aVar.f1280j = bVar.m;
            aVar.f1282k = bVar.f1367n;
            aVar.f1284l = bVar.f1369o;
            aVar.m = bVar.f1371p;
            aVar.f1287n = bVar.f1372q;
            aVar.f1289o = bVar.f1373r;
            aVar.s = bVar.s;
            aVar.f1296t = bVar.f1374t;
            aVar.f1297u = bVar.f1375u;
            aVar.f1298v = bVar.f1376v;
            ((ViewGroup.MarginLayoutParams) aVar).leftMargin = bVar.F;
            ((ViewGroup.MarginLayoutParams) aVar).rightMargin = bVar.G;
            ((ViewGroup.MarginLayoutParams) aVar).topMargin = bVar.H;
            ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = bVar.I;
            aVar.A = bVar.R;
            aVar.B = bVar.Q;
            aVar.f1300x = bVar.N;
            aVar.f1302z = bVar.P;
            aVar.E = bVar.f1377w;
            aVar.F = bVar.f1378x;
            aVar.f1291p = bVar.f1380z;
            aVar.f1293q = bVar.A;
            aVar.f1295r = bVar.B;
            aVar.G = bVar.f1379y;
            aVar.T = bVar.C;
            aVar.U = bVar.D;
            aVar.I = bVar.T;
            aVar.H = bVar.U;
            aVar.K = bVar.W;
            aVar.J = bVar.V;
            aVar.W = bVar.f1365l0;
            aVar.X = bVar.f1366m0;
            aVar.L = bVar.X;
            aVar.M = bVar.Y;
            aVar.P = bVar.Z;
            aVar.Q = bVar.f1344a0;
            aVar.N = bVar.f1346b0;
            aVar.O = bVar.f1348c0;
            aVar.R = bVar.f1350d0;
            aVar.S = bVar.f1351e0;
            aVar.V = bVar.E;
            aVar.f1267c = bVar.f1352f;
            aVar.f1263a = bVar.f1349d;
            aVar.f1265b = bVar.e;
            ((ViewGroup.MarginLayoutParams) aVar).width = bVar.f1345b;
            ((ViewGroup.MarginLayoutParams) aVar).height = bVar.f1347c;
            String str = bVar.f1363k0;
            if (str != null) {
                aVar.Y = str;
            }
            aVar.Z = bVar.f1370o0;
            aVar.setMarginStart(bVar.K);
            aVar.setMarginEnd(this.f1329d.J);
            aVar.a();
        }

        public final void b(int i7, ConstraintLayout.a aVar) {
            this.f1326a = i7;
            b bVar = this.f1329d;
            bVar.f1356h = aVar.e;
            bVar.f1358i = aVar.f1272f;
            bVar.f1360j = aVar.f1274g;
            bVar.f1362k = aVar.f1276h;
            bVar.f1364l = aVar.f1278i;
            bVar.m = aVar.f1280j;
            bVar.f1367n = aVar.f1282k;
            bVar.f1369o = aVar.f1284l;
            bVar.f1371p = aVar.m;
            bVar.f1372q = aVar.f1287n;
            bVar.f1373r = aVar.f1289o;
            bVar.s = aVar.s;
            bVar.f1374t = aVar.f1296t;
            bVar.f1375u = aVar.f1297u;
            bVar.f1376v = aVar.f1298v;
            bVar.f1377w = aVar.E;
            bVar.f1378x = aVar.F;
            bVar.f1379y = aVar.G;
            bVar.f1380z = aVar.f1291p;
            bVar.A = aVar.f1293q;
            bVar.B = aVar.f1295r;
            bVar.C = aVar.T;
            bVar.D = aVar.U;
            bVar.E = aVar.V;
            bVar.f1352f = aVar.f1267c;
            bVar.f1349d = aVar.f1263a;
            bVar.e = aVar.f1265b;
            bVar.f1345b = ((ViewGroup.MarginLayoutParams) aVar).width;
            bVar.f1347c = ((ViewGroup.MarginLayoutParams) aVar).height;
            bVar.F = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
            bVar.G = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
            bVar.H = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
            bVar.I = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
            bVar.L = aVar.D;
            bVar.T = aVar.I;
            bVar.U = aVar.H;
            bVar.W = aVar.K;
            bVar.V = aVar.J;
            bVar.f1365l0 = aVar.W;
            bVar.f1366m0 = aVar.X;
            bVar.X = aVar.L;
            bVar.Y = aVar.M;
            bVar.Z = aVar.P;
            bVar.f1344a0 = aVar.Q;
            bVar.f1346b0 = aVar.N;
            bVar.f1348c0 = aVar.O;
            bVar.f1350d0 = aVar.R;
            bVar.f1351e0 = aVar.S;
            bVar.f1363k0 = aVar.Y;
            bVar.N = aVar.f1300x;
            bVar.P = aVar.f1302z;
            bVar.M = aVar.f1299w;
            bVar.O = aVar.f1301y;
            bVar.R = aVar.A;
            bVar.Q = aVar.B;
            bVar.S = aVar.C;
            bVar.f1370o0 = aVar.Z;
            bVar.J = aVar.getMarginEnd();
            this.f1329d.K = aVar.getMarginStart();
        }

        public final void c(int i7, d.a aVar) {
            b(i7, aVar);
            this.f1327b.f1393c = aVar.f1408r0;
            e eVar = this.e;
            eVar.f1396a = aVar.f1411u0;
            eVar.f1397b = aVar.f1412v0;
            eVar.f1398c = aVar.f1413w0;
            eVar.f1399d = aVar.f1414x0;
            eVar.e = aVar.f1415y0;
            eVar.f1400f = aVar.f1416z0;
            eVar.f1401g = aVar.A0;
            eVar.f1403i = aVar.B0;
            eVar.f1404j = aVar.C0;
            eVar.f1405k = aVar.D0;
            eVar.m = aVar.f1410t0;
            eVar.f1406l = aVar.f1409s0;
        }

        public final Object clone() {
            a aVar = new a();
            b bVar = aVar.f1329d;
            b bVar2 = this.f1329d;
            bVar.getClass();
            bVar.f1343a = bVar2.f1343a;
            bVar.f1345b = bVar2.f1345b;
            bVar.f1347c = bVar2.f1347c;
            bVar.f1349d = bVar2.f1349d;
            bVar.e = bVar2.e;
            bVar.f1352f = bVar2.f1352f;
            bVar.f1354g = bVar2.f1354g;
            bVar.f1356h = bVar2.f1356h;
            bVar.f1358i = bVar2.f1358i;
            bVar.f1360j = bVar2.f1360j;
            bVar.f1362k = bVar2.f1362k;
            bVar.f1364l = bVar2.f1364l;
            bVar.m = bVar2.m;
            bVar.f1367n = bVar2.f1367n;
            bVar.f1369o = bVar2.f1369o;
            bVar.f1371p = bVar2.f1371p;
            bVar.f1372q = bVar2.f1372q;
            bVar.f1373r = bVar2.f1373r;
            bVar.s = bVar2.s;
            bVar.f1374t = bVar2.f1374t;
            bVar.f1375u = bVar2.f1375u;
            bVar.f1376v = bVar2.f1376v;
            bVar.f1377w = bVar2.f1377w;
            bVar.f1378x = bVar2.f1378x;
            bVar.f1379y = bVar2.f1379y;
            bVar.f1380z = bVar2.f1380z;
            bVar.A = bVar2.A;
            bVar.B = bVar2.B;
            bVar.C = bVar2.C;
            bVar.D = bVar2.D;
            bVar.E = bVar2.E;
            bVar.F = bVar2.F;
            bVar.G = bVar2.G;
            bVar.H = bVar2.H;
            bVar.I = bVar2.I;
            bVar.J = bVar2.J;
            bVar.K = bVar2.K;
            bVar.L = bVar2.L;
            bVar.M = bVar2.M;
            bVar.N = bVar2.N;
            bVar.O = bVar2.O;
            bVar.P = bVar2.P;
            bVar.Q = bVar2.Q;
            bVar.R = bVar2.R;
            bVar.S = bVar2.S;
            bVar.T = bVar2.T;
            bVar.U = bVar2.U;
            bVar.V = bVar2.V;
            bVar.W = bVar2.W;
            bVar.X = bVar2.X;
            bVar.Y = bVar2.Y;
            bVar.Z = bVar2.Z;
            bVar.f1344a0 = bVar2.f1344a0;
            bVar.f1346b0 = bVar2.f1346b0;
            bVar.f1348c0 = bVar2.f1348c0;
            bVar.f1350d0 = bVar2.f1350d0;
            bVar.f1351e0 = bVar2.f1351e0;
            bVar.f1353f0 = bVar2.f1353f0;
            bVar.f1355g0 = bVar2.f1355g0;
            bVar.f1357h0 = bVar2.f1357h0;
            bVar.f1363k0 = bVar2.f1363k0;
            int[] iArr = bVar2.f1359i0;
            if (iArr == null || bVar2.f1361j0 != null) {
                bVar.f1359i0 = null;
            } else {
                bVar.f1359i0 = Arrays.copyOf(iArr, iArr.length);
            }
            bVar.f1361j0 = bVar2.f1361j0;
            bVar.f1365l0 = bVar2.f1365l0;
            bVar.f1366m0 = bVar2.f1366m0;
            bVar.f1368n0 = bVar2.f1368n0;
            bVar.f1370o0 = bVar2.f1370o0;
            C0015c cVar = aVar.f1328c;
            C0015c cVar2 = this.f1328c;
            cVar.getClass();
            cVar2.getClass();
            cVar.f1382a = cVar2.f1382a;
            cVar.f1384c = cVar2.f1384c;
            cVar.e = cVar2.e;
            cVar.f1385d = cVar2.f1385d;
            d dVar = aVar.f1327b;
            d dVar2 = this.f1327b;
            dVar.getClass();
            dVar2.getClass();
            dVar.f1391a = dVar2.f1391a;
            dVar.f1393c = dVar2.f1393c;
            dVar.f1394d = dVar2.f1394d;
            dVar.f1392b = dVar2.f1392b;
            e eVar = aVar.e;
            e eVar2 = this.e;
            eVar.getClass();
            eVar2.getClass();
            eVar.f1396a = eVar2.f1396a;
            eVar.f1397b = eVar2.f1397b;
            eVar.f1398c = eVar2.f1398c;
            eVar.f1399d = eVar2.f1399d;
            eVar.e = eVar2.e;
            eVar.f1400f = eVar2.f1400f;
            eVar.f1401g = eVar2.f1401g;
            eVar.f1402h = eVar2.f1402h;
            eVar.f1403i = eVar2.f1403i;
            eVar.f1404j = eVar2.f1404j;
            eVar.f1405k = eVar2.f1405k;
            eVar.f1406l = eVar2.f1406l;
            eVar.m = eVar2.m;
            aVar.f1326a = this.f1326a;
            return aVar;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {

        /* renamed from: p0 */
        public static SparseIntArray f1342p0;

        /* renamed from: b */
        public int f1345b;

        /* renamed from: c */
        public int f1347c;

        /* renamed from: i0 */
        public int[] f1359i0;

        /* renamed from: j0 */
        public String f1361j0;

        /* renamed from: k0 */
        public String f1363k0;

        /* renamed from: a */
        public boolean f1343a = false;

        /* renamed from: d */
        public int f1349d = -1;
        public int e = -1;

        /* renamed from: f */
        public float f1352f = -1.0f;

        /* renamed from: g */
        public boolean f1354g = true;

        /* renamed from: h */
        public int f1356h = -1;

        /* renamed from: i */
        public int f1358i = -1;

        /* renamed from: j */
        public int f1360j = -1;

        /* renamed from: k */
        public int f1362k = -1;

        /* renamed from: l */
        public int f1364l = -1;
        public int m = -1;

        /* renamed from: n */
        public int f1367n = -1;

        /* renamed from: o */
        public int f1369o = -1;

        /* renamed from: p */
        public int f1371p = -1;

        /* renamed from: q */
        public int f1372q = -1;

        /* renamed from: r */
        public int f1373r = -1;
        public int s = -1;

        /* renamed from: t */
        public int f1374t = -1;

        /* renamed from: u */
        public int f1375u = -1;

        /* renamed from: v */
        public int f1376v = -1;

        /* renamed from: w */
        public float f1377w = 0.5f;

        /* renamed from: x */
        public float f1378x = 0.5f;

        /* renamed from: y */
        public String f1379y = null;

        /* renamed from: z */
        public int f1380z = -1;
        public int A = 0;
        public float B = 0.0f;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = 0;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = Integer.MIN_VALUE;
        public int N = Integer.MIN_VALUE;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public float T = -1.0f;
        public float U = -1.0f;
        public int V = 0;
        public int W = 0;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;

        /* renamed from: a0 */
        public int f1344a0 = 0;

        /* renamed from: b0 */
        public int f1346b0 = 0;

        /* renamed from: c0 */
        public int f1348c0 = 0;

        /* renamed from: d0 */
        public float f1350d0 = 1.0f;

        /* renamed from: e0 */
        public float f1351e0 = 1.0f;

        /* renamed from: f0 */
        public int f1353f0 = -1;

        /* renamed from: g0 */
        public int f1355g0 = 0;

        /* renamed from: h0 */
        public int f1357h0 = -1;

        /* renamed from: l0 */
        public boolean f1365l0 = false;

        /* renamed from: m0 */
        public boolean f1366m0 = false;

        /* renamed from: n0 */
        public boolean f1368n0 = true;

        /* renamed from: o0 */
        public int f1370o0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1342p0 = sparseIntArray;
            sparseIntArray.append(43, 24);
            f1342p0.append(44, 25);
            f1342p0.append(46, 28);
            f1342p0.append(47, 29);
            f1342p0.append(52, 35);
            f1342p0.append(51, 34);
            f1342p0.append(24, 4);
            f1342p0.append(23, 3);
            f1342p0.append(19, 1);
            f1342p0.append(61, 6);
            f1342p0.append(62, 7);
            f1342p0.append(31, 17);
            f1342p0.append(32, 18);
            f1342p0.append(33, 19);
            f1342p0.append(15, 90);
            f1342p0.append(0, 26);
            f1342p0.append(48, 31);
            f1342p0.append(49, 32);
            f1342p0.append(30, 10);
            f1342p0.append(29, 9);
            f1342p0.append(66, 13);
            f1342p0.append(69, 16);
            f1342p0.append(67, 14);
            f1342p0.append(64, 11);
            f1342p0.append(68, 15);
            f1342p0.append(65, 12);
            f1342p0.append(55, 38);
            f1342p0.append(41, 37);
            f1342p0.append(40, 39);
            f1342p0.append(54, 40);
            f1342p0.append(39, 20);
            f1342p0.append(53, 36);
            f1342p0.append(28, 5);
            f1342p0.append(42, 91);
            f1342p0.append(50, 91);
            f1342p0.append(45, 91);
            f1342p0.append(22, 91);
            f1342p0.append(18, 91);
            f1342p0.append(3, 23);
            f1342p0.append(5, 27);
            f1342p0.append(7, 30);
            f1342p0.append(8, 8);
            f1342p0.append(4, 33);
            f1342p0.append(6, 2);
            f1342p0.append(1, 22);
            f1342p0.append(2, 21);
            f1342p0.append(56, 41);
            f1342p0.append(34, 42);
            f1342p0.append(17, 41);
            f1342p0.append(16, 42);
            f1342p0.append(71, 76);
            f1342p0.append(25, 61);
            f1342p0.append(27, 62);
            f1342p0.append(26, 63);
            f1342p0.append(60, 69);
            f1342p0.append(38, 70);
            f1342p0.append(12, 71);
            f1342p0.append(10, 72);
            f1342p0.append(11, 73);
            f1342p0.append(13, 74);
            f1342p0.append(9, 75);
        }

        public final void a(Context context, AttributeSet attributeSet) {
            String str;
            StringBuilder sb;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a0.b.f10i);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = obtainStyledAttributes.getIndex(i7);
                int i8 = f1342p0.get(index);
                switch (i8) {
                    case 1:
                        this.f1371p = c.f(obtainStyledAttributes, index, this.f1371p);
                        break;
                    case 2:
                        this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 3:
                        this.f1369o = c.f(obtainStyledAttributes, index, this.f1369o);
                        break;
                    case 4:
                        this.f1367n = c.f(obtainStyledAttributes, index, this.f1367n);
                        break;
                    case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                        this.f1379y = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.C = obtainStyledAttributes.getDimensionPixelOffset(index, this.C);
                        break;
                    case 7:
                        this.D = obtainStyledAttributes.getDimensionPixelOffset(index, this.D);
                        break;
                    case 8:
                        this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 9:
                        this.f1376v = c.f(obtainStyledAttributes, index, this.f1376v);
                        break;
                    case ErrorCode.FRAME_ALLOC_CODE /* 10 */:
                        this.f1375u = c.f(obtainStyledAttributes, index, this.f1375u);
                        break;
                    case ErrorCode.PACKET_ALLOC_CODE /* 11 */:
                        this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case ErrorCode.CODEC_CONTEXT_ALLOC_CODE /* 12 */:
                        this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 13:
                        this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    case 14:
                        this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 15:
                        this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 16:
                        this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                        break;
                    case 17:
                        this.f1349d = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1349d);
                        break;
                    case 18:
                        this.e = obtainStyledAttributes.getDimensionPixelOffset(index, this.e);
                        break;
                    case 19:
                        this.f1352f = obtainStyledAttributes.getFloat(index, this.f1352f);
                        break;
                    case ErrorCode.FILE_OPEN_IO_CODE /* 20 */:
                        this.f1377w = obtainStyledAttributes.getFloat(index, this.f1377w);
                        break;
                    case ErrorCode.FILE_NOT_FOUND_IO_CODE /* 21 */:
                        this.f1347c = obtainStyledAttributes.getLayoutDimension(index, this.f1347c);
                        break;
                    case ErrorCode.INVALID_RAW_RESOURCE_IO_CODE /* 22 */:
                        this.f1345b = obtainStyledAttributes.getLayoutDimension(index, this.f1345b);
                        break;
                    case ErrorCode.NO_INPUT_FILE_IO_CODE /* 23 */:
                        this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                        break;
                    case ErrorCode.INVALID_AUDIO_URL_IO_CODE /* 24 */:
                        this.f1356h = c.f(obtainStyledAttributes, index, this.f1356h);
                        break;
                    case ErrorCode.EXTENDED_PROCESSING_DISABLED_IO_CODE /* 25 */:
                        this.f1358i = c.f(obtainStyledAttributes, index, this.f1358i);
                        break;
                    case ErrorCode.INVALID_AUDIO_INPUT_STREAM_IO_CODE /* 26 */:
                        this.E = obtainStyledAttributes.getInt(index, this.E);
                        break;
                    case ErrorCode.INVALID_AUDIO_BYTE_ARRAY_IO_CODE /* 27 */:
                        this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                        break;
                    case 28:
                        this.f1360j = c.f(obtainStyledAttributes, index, this.f1360j);
                        break;
                    case 29:
                        this.f1362k = c.f(obtainStyledAttributes, index, this.f1362k);
                        break;
                    case ErrorCode.CODEC_NOT_FOUND_PROC_CODE /* 30 */:
                        this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    case ErrorCode.STREAM_NOT_FOUND_PROC_CODE /* 31 */:
                        this.s = c.f(obtainStyledAttributes, index, this.s);
                        break;
                    case ErrorCode.STREAM_INFO_NOT_FOUND_PROC_CODE /* 32 */:
                        this.f1374t = c.f(obtainStyledAttributes, index, this.f1374t);
                        break;
                    case ErrorCode.CODEC_PARAMETERS_COPY_PROC_CODE /* 33 */:
                        this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case ErrorCode.PACKET_SUBMITTING_PROC_CODE /* 34 */:
                        this.m = c.f(obtainStyledAttributes, index, this.m);
                        break;
                    case ErrorCode.CODEC_OPEN_PROC_CODE /* 35 */:
                        this.f1364l = c.f(obtainStyledAttributes, index, this.f1364l);
                        break;
                    case ErrorCode.UNSUPPORTED_SAMPLE_FMT_PROC_CODE /* 36 */:
                        this.f1378x = obtainStyledAttributes.getFloat(index, this.f1378x);
                        break;
                    case ErrorCode.DECODING_PROC_CODE /* 37 */:
                        this.U = obtainStyledAttributes.getFloat(index, this.U);
                        break;
                    case ErrorCode.INVALID_PARAMETER_FLAG_PROC_CODE /* 38 */:
                        this.T = obtainStyledAttributes.getFloat(index, this.T);
                        break;
                    case ErrorCode.SECOND_OUT_OF_BOUNDS_PROC_CODE /* 39 */:
                        this.V = obtainStyledAttributes.getInt(index, this.V);
                        break;
                    case ErrorCode.SAMPLE_OUT_OF_BOUNDS_PROC_CODE /* 40 */:
                        this.W = obtainStyledAttributes.getInt(index, this.W);
                        break;
                    case 41:
                        c.g(this, obtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        c.g(this, obtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i8) {
                            case 61:
                                this.f1380z = c.f(obtainStyledAttributes, index, this.f1380z);
                                continue;
                            case 62:
                                this.A = obtainStyledAttributes.getDimensionPixelSize(index, this.A);
                                continue;
                            case 63:
                                this.B = obtainStyledAttributes.getFloat(index, this.B);
                                continue;
                            default:
                                switch (i8) {
                                    case 69:
                                        this.f1350d0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.f1351e0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        break;
                                    case 72:
                                        this.f1353f0 = obtainStyledAttributes.getInt(index, this.f1353f0);
                                        break;
                                    case 73:
                                        this.f1355g0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1355g0);
                                        break;
                                    case 74:
                                        this.f1361j0 = obtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.f1368n0 = obtainStyledAttributes.getBoolean(index, this.f1368n0);
                                        break;
                                    case 76:
                                        this.f1370o0 = obtainStyledAttributes.getInt(index, this.f1370o0);
                                        break;
                                    case 77:
                                        this.f1372q = c.f(obtainStyledAttributes, index, this.f1372q);
                                        break;
                                    case 78:
                                        this.f1373r = c.f(obtainStyledAttributes, index, this.f1373r);
                                        break;
                                    case 79:
                                        this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                                        break;
                                    case 80:
                                        this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                                        break;
                                    case 81:
                                        this.X = obtainStyledAttributes.getInt(index, this.X);
                                        break;
                                    case 82:
                                        this.Y = obtainStyledAttributes.getInt(index, this.Y);
                                        break;
                                    case 83:
                                        this.f1344a0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1344a0);
                                        break;
                                    case 84:
                                        this.Z = obtainStyledAttributes.getDimensionPixelSize(index, this.Z);
                                        break;
                                    case 85:
                                        this.f1348c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1348c0);
                                        break;
                                    case 86:
                                        this.f1346b0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f1346b0);
                                        break;
                                    case 87:
                                        this.f1365l0 = obtainStyledAttributes.getBoolean(index, this.f1365l0);
                                        break;
                                    case 88:
                                        this.f1366m0 = obtainStyledAttributes.getBoolean(index, this.f1366m0);
                                        break;
                                    case 89:
                                        this.f1363k0 = obtainStyledAttributes.getString(index);
                                        break;
                                    case SubsamplingScaleImageView.ORIENTATION_90 /* 90 */:
                                        this.f1354g = obtainStyledAttributes.getBoolean(index, this.f1354g);
                                        break;
                                    case 91:
                                        sb = new StringBuilder();
                                        str = "unused attribute 0x";
                                        sb.append(str);
                                        sb.append(Integer.toHexString(index));
                                        sb.append("   ");
                                        sb.append(f1342p0.get(index));
                                        Log.w("ConstraintSet", sb.toString());
                                        continue;
                                    default:
                                        sb = new StringBuilder();
                                        str = "Unknown attribute 0x";
                                        sb.append(str);
                                        sb.append(Integer.toHexString(index));
                                        sb.append("   ");
                                        sb.append(f1342p0.get(index));
                                        Log.w("ConstraintSet", sb.toString());
                                        continue;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.constraintlayout.widget.c$c */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0015c {

        /* renamed from: k */
        public static SparseIntArray f1381k;

        /* renamed from: a */
        public int f1382a = -1;

        /* renamed from: b */
        public int f1383b = 0;

        /* renamed from: c */
        public int f1384c = -1;

        /* renamed from: d */
        public float f1385d = Float.NaN;
        public float e = Float.NaN;

        /* renamed from: f */
        public float f1386f = Float.NaN;

        /* renamed from: g */
        public int f1387g = -1;

        /* renamed from: h */
        public String f1388h = null;

        /* renamed from: i */
        public int f1389i = -3;

        /* renamed from: j */
        public int f1390j = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1381k = sparseIntArray;
            sparseIntArray.append(3, 1);
            f1381k.append(5, 2);
            f1381k.append(9, 3);
            f1381k.append(2, 4);
            f1381k.append(1, 5);
            f1381k.append(0, 6);
            f1381k.append(4, 7);
            f1381k.append(8, 8);
            f1381k.append(7, 9);
            f1381k.append(6, 10);
        }

        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a0.b.f11j);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = obtainStyledAttributes.getIndex(i7);
                switch (f1381k.get(index)) {
                    case 1:
                        this.e = obtainStyledAttributes.getFloat(index, this.e);
                        break;
                    case 2:
                        this.f1384c = obtainStyledAttributes.getInt(index, this.f1384c);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            String str = x0.a.f6424b[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        obtainStyledAttributes.getInt(index, 0);
                        break;
                    case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                        this.f1382a = c.f(obtainStyledAttributes, index, this.f1382a);
                        break;
                    case 6:
                        this.f1383b = obtainStyledAttributes.getInteger(index, this.f1383b);
                        break;
                    case 7:
                        this.f1385d = obtainStyledAttributes.getFloat(index, this.f1385d);
                        break;
                    case 8:
                        this.f1387g = obtainStyledAttributes.getInteger(index, this.f1387g);
                        break;
                    case 9:
                        this.f1386f = obtainStyledAttributes.getFloat(index, this.f1386f);
                        break;
                    case ErrorCode.FRAME_ALLOC_CODE /* 10 */:
                        int i8 = obtainStyledAttributes.peekValue(index).type;
                        if (i8 == 1) {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.f1390j = resourceId;
                            if (resourceId == -1) {
                                break;
                            }
                            this.f1389i = -2;
                            break;
                        } else if (i8 != 3) {
                            this.f1389i = obtainStyledAttributes.getInteger(index, this.f1390j);
                            break;
                        } else {
                            String string = obtainStyledAttributes.getString(index);
                            this.f1388h = string;
                            if (string.indexOf("/") <= 0) {
                                this.f1389i = -1;
                                break;
                            } else {
                                this.f1390j = obtainStyledAttributes.getResourceId(index, -1);
                                this.f1389i = -2;
                            }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class d {

        /* renamed from: a */
        public int f1391a = 0;

        /* renamed from: b */
        public int f1392b = 0;

        /* renamed from: c */
        public float f1393c = 1.0f;

        /* renamed from: d */
        public float f1394d = Float.NaN;

        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a0.b.f13l);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = obtainStyledAttributes.getIndex(i7);
                if (index == 1) {
                    this.f1393c = obtainStyledAttributes.getFloat(index, this.f1393c);
                } else if (index == 0) {
                    int i8 = obtainStyledAttributes.getInt(index, this.f1391a);
                    this.f1391a = i8;
                    this.f1391a = c.f1321d[i8];
                } else if (index == 4) {
                    this.f1392b = obtainStyledAttributes.getInt(index, this.f1392b);
                } else if (index == 3) {
                    this.f1394d = obtainStyledAttributes.getFloat(index, this.f1394d);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class e {

        /* renamed from: n */
        public static SparseIntArray f1395n;

        /* renamed from: a */
        public float f1396a = 0.0f;

        /* renamed from: b */
        public float f1397b = 0.0f;

        /* renamed from: c */
        public float f1398c = 0.0f;

        /* renamed from: d */
        public float f1399d = 1.0f;
        public float e = 1.0f;

        /* renamed from: f */
        public float f1400f = Float.NaN;

        /* renamed from: g */
        public float f1401g = Float.NaN;

        /* renamed from: h */
        public int f1402h = -1;

        /* renamed from: i */
        public float f1403i = 0.0f;

        /* renamed from: j */
        public float f1404j = 0.0f;

        /* renamed from: k */
        public float f1405k = 0.0f;

        /* renamed from: l */
        public boolean f1406l = false;
        public float m = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1395n = sparseIntArray;
            sparseIntArray.append(6, 1);
            f1395n.append(7, 2);
            f1395n.append(8, 3);
            f1395n.append(4, 4);
            f1395n.append(5, 5);
            f1395n.append(0, 6);
            f1395n.append(1, 7);
            f1395n.append(2, 8);
            f1395n.append(3, 9);
            f1395n.append(9, 10);
            f1395n.append(10, 11);
            f1395n.append(11, 12);
        }

        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a0.b.f14n);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = obtainStyledAttributes.getIndex(i7);
                switch (f1395n.get(index)) {
                    case 1:
                        this.f1396a = obtainStyledAttributes.getFloat(index, this.f1396a);
                        break;
                    case 2:
                        this.f1397b = obtainStyledAttributes.getFloat(index, this.f1397b);
                        break;
                    case 3:
                        this.f1398c = obtainStyledAttributes.getFloat(index, this.f1398c);
                        break;
                    case 4:
                        this.f1399d = obtainStyledAttributes.getFloat(index, this.f1399d);
                        break;
                    case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                        this.e = obtainStyledAttributes.getFloat(index, this.e);
                        break;
                    case 6:
                        this.f1400f = obtainStyledAttributes.getDimension(index, this.f1400f);
                        break;
                    case 7:
                        this.f1401g = obtainStyledAttributes.getDimension(index, this.f1401g);
                        break;
                    case 8:
                        this.f1403i = obtainStyledAttributes.getDimension(index, this.f1403i);
                        break;
                    case 9:
                        this.f1404j = obtainStyledAttributes.getDimension(index, this.f1404j);
                        break;
                    case ErrorCode.FRAME_ALLOC_CODE /* 10 */:
                        this.f1405k = obtainStyledAttributes.getDimension(index, this.f1405k);
                        break;
                    case ErrorCode.PACKET_ALLOC_CODE /* 11 */:
                        this.f1406l = true;
                        this.m = obtainStyledAttributes.getDimension(index, this.m);
                        break;
                    case ErrorCode.CODEC_CONTEXT_ALLOC_CODE /* 12 */:
                        this.f1402h = c.f(obtainStyledAttributes, index, this.f1402h);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        e.append(82, 25);
        e.append(83, 26);
        e.append(85, 29);
        e.append(86, 30);
        e.append(92, 36);
        e.append(91, 35);
        e.append(63, 4);
        e.append(62, 3);
        e.append(58, 1);
        e.append(60, 91);
        e.append(59, 92);
        e.append(101, 6);
        e.append(102, 7);
        e.append(70, 17);
        e.append(71, 18);
        e.append(72, 19);
        e.append(54, 99);
        e.append(0, 27);
        e.append(87, 32);
        e.append(88, 33);
        e.append(69, 10);
        e.append(68, 9);
        e.append(106, 13);
        e.append(109, 16);
        e.append(107, 14);
        e.append(104, 11);
        e.append(108, 15);
        e.append(105, 12);
        e.append(95, 40);
        e.append(80, 39);
        e.append(79, 41);
        e.append(94, 42);
        e.append(78, 20);
        e.append(93, 37);
        e.append(67, 5);
        e.append(81, 87);
        e.append(90, 87);
        e.append(84, 87);
        e.append(61, 87);
        e.append(57, 87);
        e.append(5, 24);
        e.append(7, 28);
        e.append(23, 31);
        e.append(24, 8);
        e.append(6, 34);
        e.append(8, 2);
        e.append(3, 23);
        e.append(4, 21);
        e.append(96, 95);
        e.append(73, 96);
        e.append(2, 22);
        e.append(13, 43);
        e.append(26, 44);
        e.append(21, 45);
        e.append(22, 46);
        e.append(20, 60);
        e.append(18, 47);
        e.append(19, 48);
        e.append(14, 49);
        e.append(15, 50);
        e.append(16, 51);
        e.append(17, 52);
        e.append(25, 53);
        e.append(97, 54);
        e.append(74, 55);
        e.append(98, 56);
        e.append(75, 57);
        e.append(99, 58);
        e.append(76, 59);
        e.append(64, 61);
        e.append(66, 62);
        e.append(65, 63);
        e.append(28, 64);
        e.append(121, 65);
        e.append(35, 66);
        e.append(122, 67);
        e.append(113, 79);
        e.append(1, 38);
        e.append(112, 68);
        e.append(100, 69);
        e.append(77, 70);
        e.append(111, 97);
        e.append(32, 71);
        e.append(30, 72);
        e.append(31, 73);
        e.append(33, 74);
        e.append(29, 75);
        e.append(114, 76);
        e.append(89, 77);
        e.append(123, 78);
        e.append(56, 80);
        e.append(55, 81);
        e.append(116, 82);
        e.append(120, 83);
        e.append(119, 84);
        e.append(118, 85);
        e.append(117, 86);
        f1322f.append(85, 6);
        f1322f.append(85, 7);
        f1322f.append(0, 27);
        f1322f.append(89, 13);
        f1322f.append(92, 16);
        f1322f.append(90, 14);
        f1322f.append(87, 11);
        f1322f.append(91, 15);
        f1322f.append(88, 12);
        f1322f.append(78, 40);
        f1322f.append(71, 39);
        f1322f.append(70, 41);
        f1322f.append(77, 42);
        f1322f.append(69, 20);
        f1322f.append(76, 37);
        f1322f.append(60, 5);
        f1322f.append(72, 87);
        f1322f.append(75, 87);
        f1322f.append(73, 87);
        f1322f.append(57, 87);
        f1322f.append(56, 87);
        f1322f.append(5, 24);
        f1322f.append(7, 28);
        f1322f.append(23, 31);
        f1322f.append(24, 8);
        f1322f.append(6, 34);
        f1322f.append(8, 2);
        f1322f.append(3, 23);
        f1322f.append(4, 21);
        f1322f.append(79, 95);
        f1322f.append(64, 96);
        f1322f.append(2, 22);
        f1322f.append(13, 43);
        f1322f.append(26, 44);
        f1322f.append(21, 45);
        f1322f.append(22, 46);
        f1322f.append(20, 60);
        f1322f.append(18, 47);
        f1322f.append(19, 48);
        f1322f.append(14, 49);
        f1322f.append(15, 50);
        f1322f.append(16, 51);
        f1322f.append(17, 52);
        f1322f.append(25, 53);
        f1322f.append(80, 54);
        f1322f.append(65, 55);
        f1322f.append(81, 56);
        f1322f.append(66, 57);
        f1322f.append(82, 58);
        f1322f.append(67, 59);
        f1322f.append(59, 62);
        f1322f.append(58, 63);
        f1322f.append(28, 64);
        f1322f.append(105, 65);
        f1322f.append(34, 66);
        f1322f.append(106, 67);
        f1322f.append(96, 79);
        f1322f.append(1, 38);
        f1322f.append(97, 98);
        f1322f.append(95, 68);
        f1322f.append(83, 69);
        f1322f.append(68, 70);
        f1322f.append(32, 71);
        f1322f.append(30, 72);
        f1322f.append(31, 73);
        f1322f.append(33, 74);
        f1322f.append(29, 75);
        f1322f.append(98, 76);
        f1322f.append(74, 77);
        f1322f.append(107, 78);
        f1322f.append(55, 80);
        f1322f.append(54, 81);
        f1322f.append(100, 82);
        f1322f.append(104, 83);
        f1322f.append(103, 84);
        f1322f.append(102, 85);
        f1322f.append(101, 86);
        f1322f.append(94, 97);
    }

    public static int[] c(a aVar, String str) {
        int i7;
        HashMap<String, Integer> hashMap;
        String[] split = str.split(",");
        Context context = aVar.getContext();
        int[] iArr = new int[split.length];
        int i8 = 0;
        for (String str2 : split) {
            String trim = str2.trim();
            Integer num = null;
            try {
                i7 = b1.d.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i7 = 0;
            }
            if (i7 == 0) {
                i7 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i7 == 0 && aVar.isInEditMode() && (aVar.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) aVar.getParent();
                constraintLayout.getClass();
                if ((trim instanceof String) && (hashMap = constraintLayout.f1261r) != null && hashMap.containsKey(trim)) {
                    num = constraintLayout.f1261r.get(trim);
                }
                if (num != null && (num instanceof Integer)) {
                    i7 = num.intValue();
                }
            }
            i8++;
            iArr[i8] = i7;
        }
        return i8 != split.length ? Arrays.copyOf(iArr, i8) : iArr;
    }

    public static a d(Context context, AttributeSet attributeSet, boolean z6) {
        C0015c cVar;
        C0015c cVar2;
        int i7;
        C0015c cVar3;
        StringBuilder d7;
        int i8;
        b bVar;
        String str;
        StringBuilder sb;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        float f7;
        int i14;
        float f8;
        int i15;
        int i16;
        float f9;
        int i17;
        int i18;
        boolean z7;
        int i19;
        C0015c cVar4;
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z6 ? a0.b.f7f : a0.b.f6d);
        int i20 = 3;
        int i21 = 1;
        int i22 = 0;
        if (z6) {
            int indexCount = obtainStyledAttributes.getIndexCount();
            a.C0014a aVar2 = new a.C0014a();
            aVar.f1328c.getClass();
            aVar.f1329d.getClass();
            aVar.f1327b.getClass();
            aVar.e.getClass();
            int i23 = 0;
            while (i22 < indexCount) {
                int index = obtainStyledAttributes.getIndex(i22);
                switch (f1322f.get(index)) {
                    case 2:
                        i9 = 2;
                        i11 = aVar.f1329d.I;
                        i10 = obtainStyledAttributes.getDimensionPixelSize(index, i11);
                        aVar2.b(i9, i10);
                        break;
                    case 3:
                    case 4:
                    case 9:
                    case ErrorCode.FRAME_ALLOC_CODE /* 10 */:
                    case ErrorCode.EXTENDED_PROCESSING_DISABLED_IO_CODE /* 25 */:
                    case ErrorCode.INVALID_AUDIO_INPUT_STREAM_IO_CODE /* 26 */:
                    case 29:
                    case ErrorCode.CODEC_NOT_FOUND_PROC_CODE /* 30 */:
                    case ErrorCode.STREAM_INFO_NOT_FOUND_PROC_CODE /* 32 */:
                    case ErrorCode.CODEC_PARAMETERS_COPY_PROC_CODE /* 33 */:
                    case ErrorCode.CODEC_OPEN_PROC_CODE /* 35 */:
                    case ErrorCode.UNSUPPORTED_SAMPLE_FMT_PROC_CODE /* 36 */:
                    case 61:
                    case 88:
                    case 89:
                    case SubsamplingScaleImageView.ORIENTATION_90 /* 90 */:
                    case 91:
                    case 92:
                    default:
                        sb = new StringBuilder();
                        str = "Unknown attribute 0x";
                        sb.append(str);
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(e.get(index));
                        Log.w("ConstraintSet", sb.toString());
                        break;
                    case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                        i12 = 5;
                        aVar2.c(i12, obtainStyledAttributes.getString(index));
                        break;
                    case 6:
                        i9 = 6;
                        i13 = aVar.f1329d.C;
                        i10 = obtainStyledAttributes.getDimensionPixelOffset(index, i13);
                        aVar2.b(i9, i10);
                        break;
                    case 7:
                        i9 = 7;
                        i13 = aVar.f1329d.D;
                        i10 = obtainStyledAttributes.getDimensionPixelOffset(index, i13);
                        aVar2.b(i9, i10);
                        break;
                    case 8:
                        i9 = 8;
                        i11 = aVar.f1329d.J;
                        i10 = obtainStyledAttributes.getDimensionPixelSize(index, i11);
                        aVar2.b(i9, i10);
                        break;
                    case ErrorCode.PACKET_ALLOC_CODE /* 11 */:
                        i9 = 11;
                        i11 = aVar.f1329d.P;
                        i10 = obtainStyledAttributes.getDimensionPixelSize(index, i11);
                        aVar2.b(i9, i10);
                        break;
                    case ErrorCode.CODEC_CONTEXT_ALLOC_CODE /* 12 */:
                        i9 = 12;
                        i11 = aVar.f1329d.Q;
                        i10 = obtainStyledAttributes.getDimensionPixelSize(index, i11);
                        aVar2.b(i9, i10);
                        break;
                    case 13:
                        i9 = 13;
                        i11 = aVar.f1329d.M;
                        i10 = obtainStyledAttributes.getDimensionPixelSize(index, i11);
                        aVar2.b(i9, i10);
                        break;
                    case 14:
                        i9 = 14;
                        i11 = aVar.f1329d.O;
                        i10 = obtainStyledAttributes.getDimensionPixelSize(index, i11);
                        aVar2.b(i9, i10);
                        break;
                    case 15:
                        i9 = 15;
                        i11 = aVar.f1329d.R;
                        i10 = obtainStyledAttributes.getDimensionPixelSize(index, i11);
                        aVar2.b(i9, i10);
                        break;
                    case 16:
                        i9 = 16;
                        i11 = aVar.f1329d.N;
                        i10 = obtainStyledAttributes.getDimensionPixelSize(index, i11);
                        aVar2.b(i9, i10);
                        break;
                    case 17:
                        i9 = 17;
                        i13 = aVar.f1329d.f1349d;
                        i10 = obtainStyledAttributes.getDimensionPixelOffset(index, i13);
                        aVar2.b(i9, i10);
                        break;
                    case 18:
                        i9 = 18;
                        i13 = aVar.f1329d.e;
                        i10 = obtainStyledAttributes.getDimensionPixelOffset(index, i13);
                        aVar2.b(i9, i10);
                        break;
                    case 19:
                        i14 = 19;
                        f8 = aVar.f1329d.f1352f;
                        f7 = obtainStyledAttributes.getFloat(index, f8);
                        aVar2.a(f7, i14);
                        break;
                    case ErrorCode.FILE_OPEN_IO_CODE /* 20 */:
                        i14 = 20;
                        f8 = aVar.f1329d.f1377w;
                        f7 = obtainStyledAttributes.getFloat(index, f8);
                        aVar2.a(f7, i14);
                        break;
                    case ErrorCode.FILE_NOT_FOUND_IO_CODE /* 21 */:
                        i9 = 21;
                        i15 = aVar.f1329d.f1347c;
                        i10 = obtainStyledAttributes.getLayoutDimension(index, i15);
                        aVar2.b(i9, i10);
                        break;
                    case ErrorCode.INVALID_RAW_RESOURCE_IO_CODE /* 22 */:
                        i9 = 22;
                        i10 = f1321d[obtainStyledAttributes.getInt(index, aVar.f1327b.f1391a)];
                        aVar2.b(i9, i10);
                        break;
                    case ErrorCode.NO_INPUT_FILE_IO_CODE /* 23 */:
                        i15 = aVar.f1329d.f1345b;
                        i9 = 23;
                        i10 = obtainStyledAttributes.getLayoutDimension(index, i15);
                        aVar2.b(i9, i10);
                        break;
                    case ErrorCode.INVALID_AUDIO_URL_IO_CODE /* 24 */:
                        i11 = aVar.f1329d.F;
                        i9 = 24;
                        i10 = obtainStyledAttributes.getDimensionPixelSize(index, i11);
                        aVar2.b(i9, i10);
                        break;
                    case ErrorCode.INVALID_AUDIO_BYTE_ARRAY_IO_CODE /* 27 */:
                        i9 = 27;
                        i16 = aVar.f1329d.E;
                        i10 = obtainStyledAttributes.getInt(index, i16);
                        aVar2.b(i9, i10);
                        break;
                    case 28:
                        i9 = 28;
                        i11 = aVar.f1329d.G;
                        i10 = obtainStyledAttributes.getDimensionPixelSize(index, i11);
                        aVar2.b(i9, i10);
                        break;
                    case ErrorCode.STREAM_NOT_FOUND_PROC_CODE /* 31 */:
                        i9 = 31;
                        i11 = aVar.f1329d.K;
                        i10 = obtainStyledAttributes.getDimensionPixelSize(index, i11);
                        aVar2.b(i9, i10);
                        break;
                    case ErrorCode.PACKET_SUBMITTING_PROC_CODE /* 34 */:
                        i9 = 34;
                        i11 = aVar.f1329d.H;
                        i10 = obtainStyledAttributes.getDimensionPixelSize(index, i11);
                        aVar2.b(i9, i10);
                        break;
                    case ErrorCode.DECODING_PROC_CODE /* 37 */:
                        i14 = 37;
                        f8 = aVar.f1329d.f1378x;
                        f7 = obtainStyledAttributes.getFloat(index, f8);
                        aVar2.a(f7, i14);
                        break;
                    case ErrorCode.INVALID_PARAMETER_FLAG_PROC_CODE /* 38 */:
                        i10 = obtainStyledAttributes.getResourceId(index, aVar.f1326a);
                        aVar.f1326a = i10;
                        i9 = 38;
                        aVar2.b(i9, i10);
                        break;
                    case ErrorCode.SECOND_OUT_OF_BOUNDS_PROC_CODE /* 39 */:
                        i14 = 39;
                        f8 = aVar.f1329d.U;
                        f7 = obtainStyledAttributes.getFloat(index, f8);
                        aVar2.a(f7, i14);
                        break;
                    case ErrorCode.SAMPLE_OUT_OF_BOUNDS_PROC_CODE /* 40 */:
                        i14 = 40;
                        f8 = aVar.f1329d.T;
                        f7 = obtainStyledAttributes.getFloat(index, f8);
                        aVar2.a(f7, i14);
                        break;
                    case 41:
                        i9 = 41;
                        i16 = aVar.f1329d.V;
                        i10 = obtainStyledAttributes.getInt(index, i16);
                        aVar2.b(i9, i10);
                        break;
                    case 42:
                        i9 = 42;
                        i16 = aVar.f1329d.W;
                        i10 = obtainStyledAttributes.getInt(index, i16);
                        aVar2.b(i9, i10);
                        break;
                    case 43:
                        i14 = 43;
                        f8 = aVar.f1327b.f1393c;
                        f7 = obtainStyledAttributes.getFloat(index, f8);
                        aVar2.a(f7, i14);
                        break;
                    case 44:
                        i14 = 44;
                        aVar2.d(44, true);
                        f9 = aVar.e.m;
                        f7 = obtainStyledAttributes.getDimension(index, f9);
                        aVar2.a(f7, i14);
                        break;
                    case 45:
                        i14 = 45;
                        f8 = aVar.e.f1397b;
                        f7 = obtainStyledAttributes.getFloat(index, f8);
                        aVar2.a(f7, i14);
                        break;
                    case 46:
                        i14 = 46;
                        f8 = aVar.e.f1398c;
                        f7 = obtainStyledAttributes.getFloat(index, f8);
                        aVar2.a(f7, i14);
                        break;
                    case 47:
                        i14 = 47;
                        f8 = aVar.e.f1399d;
                        f7 = obtainStyledAttributes.getFloat(index, f8);
                        aVar2.a(f7, i14);
                        break;
                    case 48:
                        i14 = 48;
                        f8 = aVar.e.e;
                        f7 = obtainStyledAttributes.getFloat(index, f8);
                        aVar2.a(f7, i14);
                        break;
                    case 49:
                        i14 = 49;
                        f9 = aVar.e.f1400f;
                        f7 = obtainStyledAttributes.getDimension(index, f9);
                        aVar2.a(f7, i14);
                        break;
                    case 50:
                        i14 = 50;
                        f9 = aVar.e.f1401g;
                        f7 = obtainStyledAttributes.getDimension(index, f9);
                        aVar2.a(f7, i14);
                        break;
                    case 51:
                        i14 = 51;
                        f9 = aVar.e.f1403i;
                        f7 = obtainStyledAttributes.getDimension(index, f9);
                        aVar2.a(f7, i14);
                        break;
                    case 52:
                        i14 = 52;
                        f9 = aVar.e.f1404j;
                        f7 = obtainStyledAttributes.getDimension(index, f9);
                        aVar2.a(f7, i14);
                        break;
                    case 53:
                        i14 = 53;
                        f9 = aVar.e.f1405k;
                        f7 = obtainStyledAttributes.getDimension(index, f9);
                        aVar2.a(f7, i14);
                        break;
                    case 54:
                        i9 = 54;
                        i16 = aVar.f1329d.X;
                        i10 = obtainStyledAttributes.getInt(index, i16);
                        aVar2.b(i9, i10);
                        break;
                    case 55:
                        i9 = 55;
                        i16 = aVar.f1329d.Y;
                        i10 = obtainStyledAttributes.getInt(index, i16);
                        aVar2.b(i9, i10);
                        break;
                    case 56:
                        i9 = 56;
                        i11 = aVar.f1329d.Z;
                        i10 = obtainStyledAttributes.getDimensionPixelSize(index, i11);
                        aVar2.b(i9, i10);
                        break;
                    case 57:
                        i9 = 57;
                        i11 = aVar.f1329d.f1344a0;
                        i10 = obtainStyledAttributes.getDimensionPixelSize(index, i11);
                        aVar2.b(i9, i10);
                        break;
                    case 58:
                        i9 = 58;
                        i11 = aVar.f1329d.f1346b0;
                        i10 = obtainStyledAttributes.getDimensionPixelSize(index, i11);
                        aVar2.b(i9, i10);
                        break;
                    case 59:
                        i9 = 59;
                        i11 = aVar.f1329d.f1348c0;
                        i10 = obtainStyledAttributes.getDimensionPixelSize(index, i11);
                        aVar2.b(i9, i10);
                        break;
                    case 60:
                        i14 = 60;
                        f8 = aVar.e.f1396a;
                        f7 = obtainStyledAttributes.getFloat(index, f8);
                        aVar2.a(f7, i14);
                        break;
                    case 62:
                        i9 = 62;
                        i11 = aVar.f1329d.A;
                        i10 = obtainStyledAttributes.getDimensionPixelSize(index, i11);
                        aVar2.b(i9, i10);
                        break;
                    case 63:
                        i14 = 63;
                        f8 = aVar.f1329d.B;
                        f7 = obtainStyledAttributes.getFloat(index, f8);
                        aVar2.a(f7, i14);
                        break;
                    case 64:
                        i9 = 64;
                        i17 = aVar.f1328c.f1382a;
                        i10 = f(obtainStyledAttributes, index, i17);
                        aVar2.b(i9, i10);
                        break;
                    case 65:
                        aVar2.c(65, obtainStyledAttributes.peekValue(index).type == 3 ? obtainStyledAttributes.getString(index) : x0.a.f6424b[obtainStyledAttributes.getInteger(index, 0)]);
                        break;
                    case 66:
                        i9 = 66;
                        i16 = 0;
                        i10 = obtainStyledAttributes.getInt(index, i16);
                        aVar2.b(i9, i10);
                        break;
                    case 67:
                        i14 = 67;
                        f8 = aVar.f1328c.e;
                        f7 = obtainStyledAttributes.getFloat(index, f8);
                        aVar2.a(f7, i14);
                        break;
                    case 68:
                        i14 = 68;
                        f8 = aVar.f1327b.f1394d;
                        f7 = obtainStyledAttributes.getFloat(index, f8);
                        aVar2.a(f7, i14);
                        break;
                    case 69:
                        i14 = 69;
                        f8 = 1.0f;
                        f7 = obtainStyledAttributes.getFloat(index, f8);
                        aVar2.a(f7, i14);
                        break;
                    case 70:
                        i14 = 70;
                        f8 = 1.0f;
                        f7 = obtainStyledAttributes.getFloat(index, f8);
                        aVar2.a(f7, i14);
                        break;
                    case 71:
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        i9 = 72;
                        i16 = aVar.f1329d.f1353f0;
                        i10 = obtainStyledAttributes.getInt(index, i16);
                        aVar2.b(i9, i10);
                        break;
                    case 73:
                        i9 = 73;
                        i11 = aVar.f1329d.f1355g0;
                        i10 = obtainStyledAttributes.getDimensionPixelSize(index, i11);
                        aVar2.b(i9, i10);
                        break;
                    case 74:
                        i12 = 74;
                        aVar2.c(i12, obtainStyledAttributes.getString(index));
                        break;
                    case 75:
                        i18 = 75;
                        z7 = aVar.f1329d.f1368n0;
                        aVar2.d(i18, obtainStyledAttributes.getBoolean(index, z7));
                        break;
                    case 76:
                        i9 = 76;
                        i16 = aVar.f1328c.f1384c;
                        i10 = obtainStyledAttributes.getInt(index, i16);
                        aVar2.b(i9, i10);
                        break;
                    case 77:
                        i12 = 77;
                        aVar2.c(i12, obtainStyledAttributes.getString(index));
                        break;
                    case 78:
                        i9 = 78;
                        i16 = aVar.f1327b.f1392b;
                        i10 = obtainStyledAttributes.getInt(index, i16);
                        aVar2.b(i9, i10);
                        break;
                    case 79:
                        i14 = 79;
                        f8 = aVar.f1328c.f1385d;
                        f7 = obtainStyledAttributes.getFloat(index, f8);
                        aVar2.a(f7, i14);
                        break;
                    case 80:
                        i18 = 80;
                        z7 = aVar.f1329d.f1365l0;
                        aVar2.d(i18, obtainStyledAttributes.getBoolean(index, z7));
                        break;
                    case 81:
                        i18 = 81;
                        z7 = aVar.f1329d.f1366m0;
                        aVar2.d(i18, obtainStyledAttributes.getBoolean(index, z7));
                        break;
                    case 82:
                        i9 = 82;
                        i19 = aVar.f1328c.f1383b;
                        i10 = obtainStyledAttributes.getInteger(index, i19);
                        aVar2.b(i9, i10);
                        break;
                    case 83:
                        i9 = 83;
                        i17 = aVar.e.f1402h;
                        i10 = f(obtainStyledAttributes, index, i17);
                        aVar2.b(i9, i10);
                        break;
                    case 84:
                        i9 = 84;
                        i19 = aVar.f1328c.f1387g;
                        i10 = obtainStyledAttributes.getInteger(index, i19);
                        aVar2.b(i9, i10);
                        break;
                    case 85:
                        i14 = 85;
                        f8 = aVar.f1328c.f1386f;
                        f7 = obtainStyledAttributes.getFloat(index, f8);
                        aVar2.a(f7, i14);
                        break;
                    case 86:
                        int i24 = obtainStyledAttributes.peekValue(index).type;
                        i9 = 88;
                        if (i24 == i21) {
                            aVar.f1328c.f1390j = obtainStyledAttributes.getResourceId(index, -1);
                            aVar2.b(89, aVar.f1328c.f1390j);
                            cVar4 = aVar.f1328c;
                            if (cVar4.f1390j == -1) {
                                break;
                            }
                        } else if (i24 == 3) {
                            aVar.f1328c.f1388h = obtainStyledAttributes.getString(index);
                            aVar2.c(90, aVar.f1328c.f1388h);
                            if (aVar.f1328c.f1388h.indexOf("/") <= 0) {
                                cVar4 = aVar.f1328c;
                                i10 = -1;
                                cVar4.f1389i = i10;
                                aVar2.b(i9, i10);
                                break;
                            } else {
                                aVar.f1328c.f1390j = obtainStyledAttributes.getResourceId(index, -1);
                                aVar2.b(89, aVar.f1328c.f1390j);
                                cVar4 = aVar.f1328c;
                            }
                        } else {
                            C0015c cVar5 = aVar.f1328c;
                            cVar5.f1389i = obtainStyledAttributes.getInteger(index, cVar5.f1390j);
                            i10 = aVar.f1328c.f1389i;
                            aVar2.b(i9, i10);
                        }
                        i10 = -2;
                        cVar4.f1389i = i10;
                        aVar2.b(i9, i10);
                    case 87:
                        sb = new StringBuilder();
                        str = "unused attribute 0x";
                        sb.append(str);
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(e.get(index));
                        Log.w("ConstraintSet", sb.toString());
                        break;
                    case 93:
                        i11 = aVar.f1329d.L;
                        i9 = 93;
                        i10 = obtainStyledAttributes.getDimensionPixelSize(index, i11);
                        aVar2.b(i9, i10);
                        break;
                    case 94:
                        i11 = aVar.f1329d.S;
                        i9 = 94;
                        i10 = obtainStyledAttributes.getDimensionPixelSize(index, i11);
                        aVar2.b(i9, i10);
                        break;
                    case 95:
                        g(aVar2, obtainStyledAttributes, index, i23);
                        break;
                    case 96:
                        g(aVar2, obtainStyledAttributes, index, i21);
                        break;
                    case 97:
                        i16 = aVar.f1329d.f1370o0;
                        i9 = 97;
                        i10 = obtainStyledAttributes.getInt(index, i16);
                        aVar2.b(i9, i10);
                        break;
                    case 98:
                        int i25 = a1.d.P;
                        if (obtainStyledAttributes.peekValue(index).type == i20) {
                            obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            aVar.f1326a = obtainStyledAttributes.getResourceId(index, aVar.f1326a);
                            break;
                        }
                    case 99:
                        z7 = aVar.f1329d.f1354g;
                        i18 = 99;
                        aVar2.d(i18, obtainStyledAttributes.getBoolean(index, z7));
                        break;
                }
                i22++;
                i20 = 3;
                i21 = 1;
                i23 = 0;
            }
        } else {
            int indexCount2 = obtainStyledAttributes.getIndexCount();
            for (int i26 = 0; i26 < indexCount2; i26++) {
                int index2 = obtainStyledAttributes.getIndex(i26);
                if (!(index2 == 1 || 23 == index2 || 24 == index2)) {
                    aVar.f1328c.getClass();
                    aVar.f1329d.getClass();
                    aVar.f1327b.getClass();
                    aVar.e.getClass();
                }
                switch (e.get(index2)) {
                    case 1:
                        b bVar2 = aVar.f1329d;
                        bVar2.f1371p = f(obtainStyledAttributes, index2, bVar2.f1371p);
                        break;
                    case 2:
                        b bVar3 = aVar.f1329d;
                        bVar3.I = obtainStyledAttributes.getDimensionPixelSize(index2, bVar3.I);
                        break;
                    case 3:
                        b bVar4 = aVar.f1329d;
                        bVar4.f1369o = f(obtainStyledAttributes, index2, bVar4.f1369o);
                        break;
                    case 4:
                        b bVar5 = aVar.f1329d;
                        bVar5.f1367n = f(obtainStyledAttributes, index2, bVar5.f1367n);
                        break;
                    case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                        aVar.f1329d.f1379y = obtainStyledAttributes.getString(index2);
                        break;
                    case 6:
                        b bVar6 = aVar.f1329d;
                        bVar6.C = obtainStyledAttributes.getDimensionPixelOffset(index2, bVar6.C);
                        break;
                    case 7:
                        b bVar7 = aVar.f1329d;
                        bVar7.D = obtainStyledAttributes.getDimensionPixelOffset(index2, bVar7.D);
                        break;
                    case 8:
                        b bVar8 = aVar.f1329d;
                        bVar8.J = obtainStyledAttributes.getDimensionPixelSize(index2, bVar8.J);
                        break;
                    case 9:
                        b bVar9 = aVar.f1329d;
                        bVar9.f1376v = f(obtainStyledAttributes, index2, bVar9.f1376v);
                        break;
                    case ErrorCode.FRAME_ALLOC_CODE /* 10 */:
                        b bVar10 = aVar.f1329d;
                        bVar10.f1375u = f(obtainStyledAttributes, index2, bVar10.f1375u);
                        break;
                    case ErrorCode.PACKET_ALLOC_CODE /* 11 */:
                        b bVar11 = aVar.f1329d;
                        bVar11.P = obtainStyledAttributes.getDimensionPixelSize(index2, bVar11.P);
                        break;
                    case ErrorCode.CODEC_CONTEXT_ALLOC_CODE /* 12 */:
                        b bVar12 = aVar.f1329d;
                        bVar12.Q = obtainStyledAttributes.getDimensionPixelSize(index2, bVar12.Q);
                        break;
                    case 13:
                        b bVar13 = aVar.f1329d;
                        bVar13.M = obtainStyledAttributes.getDimensionPixelSize(index2, bVar13.M);
                        break;
                    case 14:
                        b bVar14 = aVar.f1329d;
                        bVar14.O = obtainStyledAttributes.getDimensionPixelSize(index2, bVar14.O);
                        break;
                    case 15:
                        b bVar15 = aVar.f1329d;
                        bVar15.R = obtainStyledAttributes.getDimensionPixelSize(index2, bVar15.R);
                        break;
                    case 16:
                        b bVar16 = aVar.f1329d;
                        bVar16.N = obtainStyledAttributes.getDimensionPixelSize(index2, bVar16.N);
                        break;
                    case 17:
                        b bVar17 = aVar.f1329d;
                        bVar17.f1349d = obtainStyledAttributes.getDimensionPixelOffset(index2, bVar17.f1349d);
                        break;
                    case 18:
                        b bVar18 = aVar.f1329d;
                        bVar18.e = obtainStyledAttributes.getDimensionPixelOffset(index2, bVar18.e);
                        break;
                    case 19:
                        b bVar19 = aVar.f1329d;
                        bVar19.f1352f = obtainStyledAttributes.getFloat(index2, bVar19.f1352f);
                        break;
                    case ErrorCode.FILE_OPEN_IO_CODE /* 20 */:
                        b bVar20 = aVar.f1329d;
                        bVar20.f1377w = obtainStyledAttributes.getFloat(index2, bVar20.f1377w);
                        break;
                    case ErrorCode.FILE_NOT_FOUND_IO_CODE /* 21 */:
                        b bVar21 = aVar.f1329d;
                        bVar21.f1347c = obtainStyledAttributes.getLayoutDimension(index2, bVar21.f1347c);
                        break;
                    case ErrorCode.INVALID_RAW_RESOURCE_IO_CODE /* 22 */:
                        d dVar = aVar.f1327b;
                        dVar.f1391a = obtainStyledAttributes.getInt(index2, dVar.f1391a);
                        d dVar2 = aVar.f1327b;
                        dVar2.f1391a = f1321d[dVar2.f1391a];
                        break;
                    case ErrorCode.NO_INPUT_FILE_IO_CODE /* 23 */:
                        b bVar22 = aVar.f1329d;
                        bVar22.f1345b = obtainStyledAttributes.getLayoutDimension(index2, bVar22.f1345b);
                        break;
                    case ErrorCode.INVALID_AUDIO_URL_IO_CODE /* 24 */:
                        b bVar23 = aVar.f1329d;
                        bVar23.F = obtainStyledAttributes.getDimensionPixelSize(index2, bVar23.F);
                        break;
                    case ErrorCode.EXTENDED_PROCESSING_DISABLED_IO_CODE /* 25 */:
                        b bVar24 = aVar.f1329d;
                        bVar24.f1356h = f(obtainStyledAttributes, index2, bVar24.f1356h);
                        break;
                    case ErrorCode.INVALID_AUDIO_INPUT_STREAM_IO_CODE /* 26 */:
                        b bVar25 = aVar.f1329d;
                        bVar25.f1358i = f(obtainStyledAttributes, index2, bVar25.f1358i);
                        break;
                    case ErrorCode.INVALID_AUDIO_BYTE_ARRAY_IO_CODE /* 27 */:
                        b bVar26 = aVar.f1329d;
                        bVar26.E = obtainStyledAttributes.getInt(index2, bVar26.E);
                        break;
                    case 28:
                        b bVar27 = aVar.f1329d;
                        bVar27.G = obtainStyledAttributes.getDimensionPixelSize(index2, bVar27.G);
                        break;
                    case 29:
                        b bVar28 = aVar.f1329d;
                        bVar28.f1360j = f(obtainStyledAttributes, index2, bVar28.f1360j);
                        break;
                    case ErrorCode.CODEC_NOT_FOUND_PROC_CODE /* 30 */:
                        b bVar29 = aVar.f1329d;
                        bVar29.f1362k = f(obtainStyledAttributes, index2, bVar29.f1362k);
                        break;
                    case ErrorCode.STREAM_NOT_FOUND_PROC_CODE /* 31 */:
                        b bVar30 = aVar.f1329d;
                        bVar30.K = obtainStyledAttributes.getDimensionPixelSize(index2, bVar30.K);
                        break;
                    case ErrorCode.STREAM_INFO_NOT_FOUND_PROC_CODE /* 32 */:
                        b bVar31 = aVar.f1329d;
                        bVar31.s = f(obtainStyledAttributes, index2, bVar31.s);
                        break;
                    case ErrorCode.CODEC_PARAMETERS_COPY_PROC_CODE /* 33 */:
                        b bVar32 = aVar.f1329d;
                        bVar32.f1374t = f(obtainStyledAttributes, index2, bVar32.f1374t);
                        break;
                    case ErrorCode.PACKET_SUBMITTING_PROC_CODE /* 34 */:
                        b bVar33 = aVar.f1329d;
                        bVar33.H = obtainStyledAttributes.getDimensionPixelSize(index2, bVar33.H);
                        break;
                    case ErrorCode.CODEC_OPEN_PROC_CODE /* 35 */:
                        b bVar34 = aVar.f1329d;
                        bVar34.m = f(obtainStyledAttributes, index2, bVar34.m);
                        break;
                    case ErrorCode.UNSUPPORTED_SAMPLE_FMT_PROC_CODE /* 36 */:
                        b bVar35 = aVar.f1329d;
                        bVar35.f1364l = f(obtainStyledAttributes, index2, bVar35.f1364l);
                        break;
                    case ErrorCode.DECODING_PROC_CODE /* 37 */:
                        b bVar36 = aVar.f1329d;
                        bVar36.f1378x = obtainStyledAttributes.getFloat(index2, bVar36.f1378x);
                        break;
                    case ErrorCode.INVALID_PARAMETER_FLAG_PROC_CODE /* 38 */:
                        aVar.f1326a = obtainStyledAttributes.getResourceId(index2, aVar.f1326a);
                        break;
                    case ErrorCode.SECOND_OUT_OF_BOUNDS_PROC_CODE /* 39 */:
                        b bVar37 = aVar.f1329d;
                        bVar37.U = obtainStyledAttributes.getFloat(index2, bVar37.U);
                        break;
                    case ErrorCode.SAMPLE_OUT_OF_BOUNDS_PROC_CODE /* 40 */:
                        b bVar38 = aVar.f1329d;
                        bVar38.T = obtainStyledAttributes.getFloat(index2, bVar38.T);
                        break;
                    case 41:
                        b bVar39 = aVar.f1329d;
                        bVar39.V = obtainStyledAttributes.getInt(index2, bVar39.V);
                        break;
                    case 42:
                        b bVar40 = aVar.f1329d;
                        bVar40.W = obtainStyledAttributes.getInt(index2, bVar40.W);
                        break;
                    case 43:
                        d dVar3 = aVar.f1327b;
                        dVar3.f1393c = obtainStyledAttributes.getFloat(index2, dVar3.f1393c);
                        break;
                    case 44:
                        e eVar = aVar.e;
                        eVar.f1406l = true;
                        eVar.m = obtainStyledAttributes.getDimension(index2, eVar.m);
                        break;
                    case 45:
                        e eVar2 = aVar.e;
                        eVar2.f1397b = obtainStyledAttributes.getFloat(index2, eVar2.f1397b);
                        break;
                    case 46:
                        e eVar3 = aVar.e;
                        eVar3.f1398c = obtainStyledAttributes.getFloat(index2, eVar3.f1398c);
                        break;
                    case 47:
                        e eVar4 = aVar.e;
                        eVar4.f1399d = obtainStyledAttributes.getFloat(index2, eVar4.f1399d);
                        break;
                    case 48:
                        e eVar5 = aVar.e;
                        eVar5.e = obtainStyledAttributes.getFloat(index2, eVar5.e);
                        break;
                    case 49:
                        e eVar6 = aVar.e;
                        eVar6.f1400f = obtainStyledAttributes.getDimension(index2, eVar6.f1400f);
                        break;
                    case 50:
                        e eVar7 = aVar.e;
                        eVar7.f1401g = obtainStyledAttributes.getDimension(index2, eVar7.f1401g);
                        break;
                    case 51:
                        e eVar8 = aVar.e;
                        eVar8.f1403i = obtainStyledAttributes.getDimension(index2, eVar8.f1403i);
                        break;
                    case 52:
                        e eVar9 = aVar.e;
                        eVar9.f1404j = obtainStyledAttributes.getDimension(index2, eVar9.f1404j);
                        break;
                    case 53:
                        e eVar10 = aVar.e;
                        eVar10.f1405k = obtainStyledAttributes.getDimension(index2, eVar10.f1405k);
                        break;
                    case 54:
                        b bVar41 = aVar.f1329d;
                        bVar41.X = obtainStyledAttributes.getInt(index2, bVar41.X);
                        break;
                    case 55:
                        b bVar42 = aVar.f1329d;
                        bVar42.Y = obtainStyledAttributes.getInt(index2, bVar42.Y);
                        break;
                    case 56:
                        b bVar43 = aVar.f1329d;
                        bVar43.Z = obtainStyledAttributes.getDimensionPixelSize(index2, bVar43.Z);
                        break;
                    case 57:
                        b bVar44 = aVar.f1329d;
                        bVar44.f1344a0 = obtainStyledAttributes.getDimensionPixelSize(index2, bVar44.f1344a0);
                        break;
                    case 58:
                        b bVar45 = aVar.f1329d;
                        bVar45.f1346b0 = obtainStyledAttributes.getDimensionPixelSize(index2, bVar45.f1346b0);
                        break;
                    case 59:
                        b bVar46 = aVar.f1329d;
                        bVar46.f1348c0 = obtainStyledAttributes.getDimensionPixelSize(index2, bVar46.f1348c0);
                        break;
                    case 60:
                        e eVar11 = aVar.e;
                        eVar11.f1396a = obtainStyledAttributes.getFloat(index2, eVar11.f1396a);
                        break;
                    case 61:
                        b bVar47 = aVar.f1329d;
                        bVar47.f1380z = f(obtainStyledAttributes, index2, bVar47.f1380z);
                        break;
                    case 62:
                        b bVar48 = aVar.f1329d;
                        bVar48.A = obtainStyledAttributes.getDimensionPixelSize(index2, bVar48.A);
                        break;
                    case 63:
                        b bVar49 = aVar.f1329d;
                        bVar49.B = obtainStyledAttributes.getFloat(index2, bVar49.B);
                        break;
                    case 64:
                        C0015c cVar6 = aVar.f1328c;
                        cVar6.f1382a = f(obtainStyledAttributes, index2, cVar6.f1382a);
                        break;
                    case 65:
                        if (obtainStyledAttributes.peekValue(index2).type == 3) {
                            cVar = aVar.f1328c;
                            obtainStyledAttributes.getString(index2);
                        } else {
                            cVar = aVar.f1328c;
                            String str2 = x0.a.f6424b[obtainStyledAttributes.getInteger(index2, 0)];
                        }
                        cVar.getClass();
                        break;
                    case 66:
                        cVar = aVar.f1328c;
                        obtainStyledAttributes.getInt(index2, 0);
                        cVar.getClass();
                        break;
                    case 67:
                        C0015c cVar7 = aVar.f1328c;
                        cVar7.e = obtainStyledAttributes.getFloat(index2, cVar7.e);
                        break;
                    case 68:
                        d dVar4 = aVar.f1327b;
                        dVar4.f1394d = obtainStyledAttributes.getFloat(index2, dVar4.f1394d);
                        break;
                    case 69:
                        aVar.f1329d.f1350d0 = obtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 70:
                        aVar.f1329d.f1351e0 = obtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 71:
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        b bVar50 = aVar.f1329d;
                        bVar50.f1353f0 = obtainStyledAttributes.getInt(index2, bVar50.f1353f0);
                        break;
                    case 73:
                        b bVar51 = aVar.f1329d;
                        bVar51.f1355g0 = obtainStyledAttributes.getDimensionPixelSize(index2, bVar51.f1355g0);
                        break;
                    case 74:
                        aVar.f1329d.f1361j0 = obtainStyledAttributes.getString(index2);
                        break;
                    case 75:
                        b bVar52 = aVar.f1329d;
                        bVar52.f1368n0 = obtainStyledAttributes.getBoolean(index2, bVar52.f1368n0);
                        break;
                    case 76:
                        C0015c cVar8 = aVar.f1328c;
                        cVar8.f1384c = obtainStyledAttributes.getInt(index2, cVar8.f1384c);
                        break;
                    case 77:
                        aVar.f1329d.f1363k0 = obtainStyledAttributes.getString(index2);
                        break;
                    case 78:
                        d dVar5 = aVar.f1327b;
                        dVar5.f1392b = obtainStyledAttributes.getInt(index2, dVar5.f1392b);
                        break;
                    case 79:
                        C0015c cVar9 = aVar.f1328c;
                        cVar9.f1385d = obtainStyledAttributes.getFloat(index2, cVar9.f1385d);
                        break;
                    case 80:
                        b bVar53 = aVar.f1329d;
                        bVar53.f1365l0 = obtainStyledAttributes.getBoolean(index2, bVar53.f1365l0);
                        break;
                    case 81:
                        b bVar54 = aVar.f1329d;
                        bVar54.f1366m0 = obtainStyledAttributes.getBoolean(index2, bVar54.f1366m0);
                        break;
                    case 82:
                        C0015c cVar10 = aVar.f1328c;
                        cVar10.f1383b = obtainStyledAttributes.getInteger(index2, cVar10.f1383b);
                        break;
                    case 83:
                        e eVar12 = aVar.e;
                        eVar12.f1402h = f(obtainStyledAttributes, index2, eVar12.f1402h);
                        break;
                    case 84:
                        C0015c cVar11 = aVar.f1328c;
                        cVar11.f1387g = obtainStyledAttributes.getInteger(index2, cVar11.f1387g);
                        break;
                    case 85:
                        C0015c cVar12 = aVar.f1328c;
                        cVar12.f1386f = obtainStyledAttributes.getFloat(index2, cVar12.f1386f);
                        break;
                    case 86:
                        int i27 = obtainStyledAttributes.peekValue(index2).type;
                        if (i27 == 1) {
                            aVar.f1328c.f1390j = obtainStyledAttributes.getResourceId(index2, -1);
                            cVar3 = aVar.f1328c;
                            if (cVar3.f1390j == -1) {
                                break;
                            }
                            cVar3.f1389i = -2;
                            break;
                        } else {
                            if (i27 == 3) {
                                aVar.f1328c.f1388h = obtainStyledAttributes.getString(index2);
                                if (aVar.f1328c.f1388h.indexOf("/") > 0) {
                                    aVar.f1328c.f1390j = obtainStyledAttributes.getResourceId(index2, -1);
                                    cVar3 = aVar.f1328c;
                                    cVar3.f1389i = -2;
                                } else {
                                    i7 = -1;
                                    cVar2 = aVar.f1328c;
                                }
                            } else {
                                cVar2 = aVar.f1328c;
                                i7 = obtainStyledAttributes.getInteger(index2, cVar2.f1390j);
                            }
                            cVar2.f1389i = i7;
                            break;
                        }
                    case 87:
                        d7 = h.d("unused attribute 0x");
                        d7.append(Integer.toHexString(index2));
                        d7.append("   ");
                        d7.append(e.get(index2));
                        Log.w("ConstraintSet", d7.toString());
                        break;
                    case 88:
                    case 89:
                    case SubsamplingScaleImageView.ORIENTATION_90 /* 90 */:
                    default:
                        d7 = h.d("Unknown attribute 0x");
                        d7.append(Integer.toHexString(index2));
                        d7.append("   ");
                        d7.append(e.get(index2));
                        Log.w("ConstraintSet", d7.toString());
                        break;
                    case 91:
                        b bVar55 = aVar.f1329d;
                        bVar55.f1372q = f(obtainStyledAttributes, index2, bVar55.f1372q);
                        break;
                    case 92:
                        b bVar56 = aVar.f1329d;
                        bVar56.f1373r = f(obtainStyledAttributes, index2, bVar56.f1373r);
                        break;
                    case 93:
                        b bVar57 = aVar.f1329d;
                        bVar57.L = obtainStyledAttributes.getDimensionPixelSize(index2, bVar57.L);
                        break;
                    case 94:
                        b bVar58 = aVar.f1329d;
                        bVar58.S = obtainStyledAttributes.getDimensionPixelSize(index2, bVar58.S);
                        break;
                    case 95:
                        bVar = aVar.f1329d;
                        i8 = 0;
                        g(bVar, obtainStyledAttributes, index2, i8);
                        break;
                    case 96:
                        bVar = aVar.f1329d;
                        i8 = 1;
                        g(bVar, obtainStyledAttributes, index2, i8);
                        break;
                    case 97:
                        b bVar59 = aVar.f1329d;
                        bVar59.f1370o0 = obtainStyledAttributes.getInt(index2, bVar59.f1370o0);
                        break;
                }
            }
            b bVar60 = aVar.f1329d;
            if (bVar60.f1361j0 != null) {
                bVar60.f1359i0 = null;
            }
        }
        obtainStyledAttributes.recycle();
        return aVar;
    }

    public static int f(TypedArray typedArray, int i7, int i8) {
        int resourceId = typedArray.getResourceId(i7, i8);
        return resourceId == -1 ? typedArray.getInt(i7, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g(java.lang.Object r8, android.content.res.TypedArray r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.c.g(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void h(ConstraintLayout.a aVar, String str) {
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i7 = 0;
            i7 = -1;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (!substring.equalsIgnoreCase("W")) {
                    i7 = substring.equalsIgnoreCase("H") ? 1 : -1;
                }
                i7 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            try {
                if (indexOf2 < 0 || indexOf2 >= length - 1) {
                    String substring2 = str.substring(i7);
                    if (substring2.length() > 0) {
                        Float.parseFloat(substring2);
                    }
                } else {
                    String substring3 = str.substring(i7, indexOf2);
                    String substring4 = str.substring(indexOf2 + 1);
                    if (substring3.length() > 0 && substring4.length() > 0) {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            if (i7 == 1) {
                                Math.abs(parseFloat2 / parseFloat);
                            } else {
                                Math.abs(parseFloat / parseFloat2);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        aVar.G = str;
    }

    public final void a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f1325c.keySet());
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = constraintLayout.getChildAt(i7);
            int id = childAt.getId();
            if (!this.f1325c.containsKey(Integer.valueOf(id))) {
                StringBuilder d7 = h.d("id unknown ");
                d7.append(a1.a.b(childAt));
                Log.w("ConstraintSet", d7.toString());
            } else if (this.f1324b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id != -1) {
                if (this.f1325c.containsKey(Integer.valueOf(id))) {
                    hashSet.remove(Integer.valueOf(id));
                    a aVar = this.f1325c.get(Integer.valueOf(id));
                    if (aVar != null) {
                        if (childAt instanceof a) {
                            aVar.f1329d.f1357h0 = 1;
                            a aVar2 = (a) childAt;
                            aVar2.setId(id);
                            aVar2.setType(aVar.f1329d.f1353f0);
                            aVar2.setMargin(aVar.f1329d.f1355g0);
                            aVar2.setAllowsGoneWidget(aVar.f1329d.f1368n0);
                            b bVar = aVar.f1329d;
                            int[] iArr = bVar.f1359i0;
                            if (iArr != null) {
                                aVar2.setReferencedIds(iArr);
                            } else {
                                String str = bVar.f1361j0;
                                if (str != null) {
                                    bVar.f1359i0 = c(aVar2, str);
                                    aVar2.setReferencedIds(aVar.f1329d.f1359i0);
                                }
                            }
                        }
                        ConstraintLayout.a aVar3 = (ConstraintLayout.a) childAt.getLayoutParams();
                        aVar3.a();
                        aVar.a(aVar3);
                        b1.a.b(childAt, aVar.f1330f);
                        childAt.setLayoutParams(aVar3);
                        d dVar = aVar.f1327b;
                        if (dVar.f1392b == 0) {
                            childAt.setVisibility(dVar.f1391a);
                        }
                        childAt.setAlpha(aVar.f1327b.f1393c);
                        childAt.setRotation(aVar.e.f1396a);
                        childAt.setRotationX(aVar.e.f1397b);
                        childAt.setRotationY(aVar.e.f1398c);
                        childAt.setScaleX(aVar.e.f1399d);
                        childAt.setScaleY(aVar.e.e);
                        e eVar = aVar.e;
                        if (eVar.f1402h != -1) {
                            View findViewById = ((View) childAt.getParent()).findViewById(aVar.e.f1402h);
                            if (findViewById != null) {
                                float bottom = ((float) (findViewById.getBottom() + findViewById.getTop())) / 2.0f;
                                float right = ((float) (findViewById.getRight() + findViewById.getLeft())) / 2.0f;
                                if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                    childAt.setPivotX(right - ((float) childAt.getLeft()));
                                    childAt.setPivotY(bottom - ((float) childAt.getTop()));
                                }
                            }
                        } else {
                            if (!Float.isNaN(eVar.f1400f)) {
                                childAt.setPivotX(aVar.e.f1400f);
                            }
                            if (!Float.isNaN(aVar.e.f1401g)) {
                                childAt.setPivotY(aVar.e.f1401g);
                            }
                        }
                        childAt.setTranslationX(aVar.e.f1403i);
                        childAt.setTranslationY(aVar.e.f1404j);
                        childAt.setTranslationZ(aVar.e.f1405k);
                        e eVar2 = aVar.e;
                        if (eVar2.f1406l) {
                            childAt.setElevation(eVar2.m);
                        }
                    }
                } else {
                    Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar4 = this.f1325c.get(num);
            if (aVar4 != null) {
                if (aVar4.f1329d.f1357h0 == 1) {
                    a aVar5 = new a(constraintLayout.getContext());
                    aVar5.setId(num.intValue());
                    b bVar2 = aVar4.f1329d;
                    int[] iArr2 = bVar2.f1359i0;
                    if (iArr2 != null) {
                        aVar5.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar2.f1361j0;
                        if (str2 != null) {
                            bVar2.f1359i0 = c(aVar5, str2);
                            aVar5.setReferencedIds(aVar4.f1329d.f1359i0);
                        }
                    }
                    aVar5.setType(aVar4.f1329d.f1353f0);
                    aVar5.setMargin(aVar4.f1329d.f1355g0);
                    b1.e eVar3 = ConstraintLayout.f1249u;
                    ConstraintLayout.a aVar6 = new ConstraintLayout.a();
                    aVar5.k();
                    aVar4.a(aVar6);
                    constraintLayout.addView(aVar5, aVar6);
                }
                if (aVar4.f1329d.f1343a) {
                    View eVar4 = new e(constraintLayout.getContext());
                    eVar4.setId(num.intValue());
                    b1.e eVar5 = ConstraintLayout.f1249u;
                    ConstraintLayout.a aVar7 = new ConstraintLayout.a();
                    aVar4.a(aVar7);
                    constraintLayout.addView(eVar4, aVar7);
                }
            }
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt2 = constraintLayout.getChildAt(i8);
            if (childAt2 instanceof b) {
                ((b) childAt2).g(constraintLayout);
            }
        }
    }

    public final void b(ConstraintLayout constraintLayout) {
        Throwable e7;
        b1.a aVar;
        c cVar = this;
        int childCount = constraintLayout.getChildCount();
        cVar.f1325c.clear();
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = constraintLayout.getChildAt(i7);
            ConstraintLayout.a aVar2 = (ConstraintLayout.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!cVar.f1324b || id != -1) {
                if (!cVar.f1325c.containsKey(Integer.valueOf(id))) {
                    cVar.f1325c.put(Integer.valueOf(id), new a());
                }
                a aVar3 = cVar.f1325c.get(Integer.valueOf(id));
                if (aVar3 != null) {
                    HashMap<String, b1.a> hashMap = cVar.f1323a;
                    HashMap<String, b1.a> hashMap2 = new HashMap<>();
                    Class<?> cls = childAt.getClass();
                    for (String str : hashMap.keySet()) {
                        b1.a aVar4 = hashMap.get(str);
                        try {
                            if (str.equals("BackgroundColor")) {
                                aVar = new b1.a(aVar4, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor()));
                            } else {
                                try {
                                    aVar = new b1.a(aVar4, cls.getMethod("getMap" + str, new Class[0]).invoke(childAt, new Object[0]));
                                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e8) {
                                    e7 = e8;
                                    e7.printStackTrace();
                                }
                            }
                            hashMap2.put(str, aVar);
                        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e9) {
                            e7 = e9;
                        }
                    }
                    aVar3.f1330f = hashMap2;
                    aVar3.b(id, aVar2);
                    aVar3.f1327b.f1391a = childAt.getVisibility();
                    aVar3.f1327b.f1393c = childAt.getAlpha();
                    aVar3.e.f1396a = childAt.getRotation();
                    aVar3.e.f1397b = childAt.getRotationX();
                    aVar3.e.f1398c = childAt.getRotationY();
                    aVar3.e.f1399d = childAt.getScaleX();
                    aVar3.e.e = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                        e eVar = aVar3.e;
                        eVar.f1400f = pivotX;
                        eVar.f1401g = pivotY;
                    }
                    aVar3.e.f1403i = childAt.getTranslationX();
                    aVar3.e.f1404j = childAt.getTranslationY();
                    aVar3.e.f1405k = childAt.getTranslationZ();
                    e eVar2 = aVar3.e;
                    if (eVar2.f1406l) {
                        eVar2.m = childAt.getElevation();
                    }
                    if (childAt instanceof a) {
                        a aVar5 = (a) childAt;
                        aVar3.f1329d.f1368n0 = aVar5.getAllowsGoneWidget();
                        aVar3.f1329d.f1359i0 = aVar5.getReferencedIds();
                        aVar3.f1329d.f1353f0 = aVar5.getType();
                        aVar3.f1329d.f1355g0 = aVar5.getMargin();
                    }
                }
                i7++;
                cVar = this;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public final void e(Context context, int i7) {
        XmlResourceParser xml = context.getResources().getXml(i7);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a d7 = d(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        d7.f1329d.f1343a = true;
                    }
                    this.f1325c.put(Integer.valueOf(d7.f1326a), d7);
                }
            }
        } catch (IOException e7) {
            e7.printStackTrace();
        } catch (XmlPullParserException e8) {
            e8.printStackTrace();
        }
    }
}
