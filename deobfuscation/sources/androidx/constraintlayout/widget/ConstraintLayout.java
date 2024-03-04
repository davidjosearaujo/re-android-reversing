package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.h;
import com.davemorrissey.labs.subscaleview.R;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import linc.com.amplituda.ErrorCode;
import y0.g;
import z0.b;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: u */
    public static b1.e f1249u;

    /* renamed from: f */
    public SparseArray<View> f1250f;

    /* renamed from: g */
    public ArrayList<androidx.constraintlayout.widget.b> f1251g;

    /* renamed from: h */
    public y0.e f1252h;

    /* renamed from: i */
    public int f1253i;

    /* renamed from: j */
    public int f1254j;

    /* renamed from: k */
    public int f1255k;

    /* renamed from: l */
    public int f1256l;
    public boolean m;

    /* renamed from: n */
    public int f1257n;

    /* renamed from: o */
    public c f1258o;

    /* renamed from: p */
    public b1.b f1259p;

    /* renamed from: q */
    public int f1260q;

    /* renamed from: r */
    public HashMap<String, Integer> f1261r;
    public SparseArray<y0.d> s;

    /* renamed from: t */
    public b f1262t;

    /* loaded from: classes.dex */
    public static class a extends ViewGroup.MarginLayoutParams {
        public int A;
        public int B;
        public int C;
        public int D;
        public float E;
        public float F;
        public String G;
        public float H;
        public float I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public float R;
        public float S;
        public int T;
        public int U;
        public int V;
        public boolean W;
        public boolean X;
        public String Y;
        public int Z;

        /* renamed from: a */
        public int f1263a;

        /* renamed from: a0 */
        public boolean f1264a0;

        /* renamed from: b */
        public int f1265b;

        /* renamed from: b0 */
        public boolean f1266b0;

        /* renamed from: c */
        public float f1267c;

        /* renamed from: c0 */
        public boolean f1268c0;

        /* renamed from: d */
        public boolean f1269d;

        /* renamed from: d0 */
        public boolean f1270d0;
        public int e;

        /* renamed from: e0 */
        public boolean f1271e0;

        /* renamed from: f */
        public int f1272f;

        /* renamed from: f0 */
        public boolean f1273f0;

        /* renamed from: g */
        public int f1274g;

        /* renamed from: g0 */
        public int f1275g0;

        /* renamed from: h */
        public int f1276h;

        /* renamed from: h0 */
        public int f1277h0;

        /* renamed from: i */
        public int f1278i;

        /* renamed from: i0 */
        public int f1279i0;

        /* renamed from: j */
        public int f1280j;

        /* renamed from: j0 */
        public int f1281j0;

        /* renamed from: k */
        public int f1282k;

        /* renamed from: k0 */
        public int f1283k0;

        /* renamed from: l */
        public int f1284l;

        /* renamed from: l0 */
        public int f1285l0;
        public int m;

        /* renamed from: m0 */
        public float f1286m0;

        /* renamed from: n */
        public int f1287n;

        /* renamed from: n0 */
        public int f1288n0;

        /* renamed from: o */
        public int f1289o;

        /* renamed from: o0 */
        public int f1290o0;

        /* renamed from: p */
        public int f1291p;

        /* renamed from: p0 */
        public float f1292p0;

        /* renamed from: q */
        public int f1293q;

        /* renamed from: q0 */
        public y0.d f1294q0;

        /* renamed from: r */
        public float f1295r;
        public int s;

        /* renamed from: t */
        public int f1296t;

        /* renamed from: u */
        public int f1297u;

        /* renamed from: v */
        public int f1298v;

        /* renamed from: w */
        public int f1299w;

        /* renamed from: x */
        public int f1300x;

        /* renamed from: y */
        public int f1301y;

        /* renamed from: z */
        public int f1302z;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a */
        /* loaded from: classes.dex */
        public static class C0013a {

            /* renamed from: a */
            public static final SparseIntArray f1303a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f1303a = sparseIntArray;
                sparseIntArray.append(98, 64);
                sparseIntArray.append(75, 65);
                sparseIntArray.append(84, 8);
                sparseIntArray.append(85, 9);
                sparseIntArray.append(87, 10);
                sparseIntArray.append(88, 11);
                sparseIntArray.append(94, 12);
                sparseIntArray.append(93, 13);
                sparseIntArray.append(65, 14);
                sparseIntArray.append(64, 15);
                sparseIntArray.append(60, 16);
                sparseIntArray.append(62, 52);
                sparseIntArray.append(61, 53);
                sparseIntArray.append(66, 2);
                sparseIntArray.append(68, 3);
                sparseIntArray.append(67, 4);
                sparseIntArray.append(103, 49);
                sparseIntArray.append(104, 50);
                sparseIntArray.append(72, 5);
                sparseIntArray.append(73, 6);
                sparseIntArray.append(74, 7);
                sparseIntArray.append(55, 67);
                sparseIntArray.append(0, 1);
                sparseIntArray.append(89, 17);
                sparseIntArray.append(90, 18);
                sparseIntArray.append(71, 19);
                sparseIntArray.append(70, 20);
                sparseIntArray.append(108, 21);
                sparseIntArray.append(111, 22);
                sparseIntArray.append(109, 23);
                sparseIntArray.append(106, 24);
                sparseIntArray.append(110, 25);
                sparseIntArray.append(107, 26);
                sparseIntArray.append(105, 55);
                sparseIntArray.append(112, 54);
                sparseIntArray.append(80, 29);
                sparseIntArray.append(95, 30);
                sparseIntArray.append(69, 44);
                sparseIntArray.append(82, 45);
                sparseIntArray.append(97, 46);
                sparseIntArray.append(81, 47);
                sparseIntArray.append(96, 48);
                sparseIntArray.append(58, 27);
                sparseIntArray.append(57, 28);
                sparseIntArray.append(99, 31);
                sparseIntArray.append(76, 32);
                sparseIntArray.append(101, 33);
                sparseIntArray.append(100, 34);
                sparseIntArray.append(102, 35);
                sparseIntArray.append(78, 36);
                sparseIntArray.append(77, 37);
                sparseIntArray.append(79, 38);
                sparseIntArray.append(83, 39);
                sparseIntArray.append(92, 40);
                sparseIntArray.append(86, 41);
                sparseIntArray.append(63, 42);
                sparseIntArray.append(59, 43);
                sparseIntArray.append(91, 51);
                sparseIntArray.append(114, 66);
            }
        }

        public a() {
            super(-2, -2);
            this.f1263a = -1;
            this.f1265b = -1;
            this.f1267c = -1.0f;
            this.f1269d = true;
            this.e = -1;
            this.f1272f = -1;
            this.f1274g = -1;
            this.f1276h = -1;
            this.f1278i = -1;
            this.f1280j = -1;
            this.f1282k = -1;
            this.f1284l = -1;
            this.m = -1;
            this.f1287n = -1;
            this.f1289o = -1;
            this.f1291p = -1;
            this.f1293q = 0;
            this.f1295r = 0.0f;
            this.s = -1;
            this.f1296t = -1;
            this.f1297u = -1;
            this.f1298v = -1;
            this.f1299w = Integer.MIN_VALUE;
            this.f1300x = Integer.MIN_VALUE;
            this.f1301y = Integer.MIN_VALUE;
            this.f1302z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.f1264a0 = true;
            this.f1266b0 = true;
            this.f1268c0 = false;
            this.f1270d0 = false;
            this.f1271e0 = false;
            this.f1273f0 = false;
            this.f1275g0 = -1;
            this.f1277h0 = -1;
            this.f1279i0 = -1;
            this.f1281j0 = -1;
            this.f1283k0 = Integer.MIN_VALUE;
            this.f1285l0 = Integer.MIN_VALUE;
            this.f1286m0 = 0.5f;
            this.f1294q0 = new y0.d();
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            String str;
            this.f1263a = -1;
            this.f1265b = -1;
            this.f1267c = -1.0f;
            this.f1269d = true;
            this.e = -1;
            this.f1272f = -1;
            this.f1274g = -1;
            this.f1276h = -1;
            this.f1278i = -1;
            this.f1280j = -1;
            this.f1282k = -1;
            this.f1284l = -1;
            this.m = -1;
            this.f1287n = -1;
            this.f1289o = -1;
            this.f1291p = -1;
            this.f1293q = 0;
            this.f1295r = 0.0f;
            this.s = -1;
            this.f1296t = -1;
            this.f1297u = -1;
            this.f1298v = -1;
            this.f1299w = Integer.MIN_VALUE;
            this.f1300x = Integer.MIN_VALUE;
            this.f1301y = Integer.MIN_VALUE;
            this.f1302z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.f1264a0 = true;
            this.f1266b0 = true;
            this.f1268c0 = false;
            this.f1270d0 = false;
            this.f1271e0 = false;
            this.f1273f0 = false;
            this.f1275g0 = -1;
            this.f1277h0 = -1;
            this.f1279i0 = -1;
            this.f1281j0 = -1;
            this.f1283k0 = Integer.MIN_VALUE;
            this.f1285l0 = Integer.MIN_VALUE;
            this.f1286m0 = 0.5f;
            this.f1294q0 = new y0.d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a0.b.e);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = obtainStyledAttributes.getIndex(i7);
                int i8 = C0013a.f1303a.get(index);
                switch (i8) {
                    case 1:
                        this.V = obtainStyledAttributes.getInt(index, this.V);
                        continue;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.f1291p);
                        this.f1291p = resourceId;
                        if (resourceId == -1) {
                            this.f1291p = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 3:
                        this.f1293q = obtainStyledAttributes.getDimensionPixelSize(index, this.f1293q);
                        continue;
                    case 4:
                        float f7 = obtainStyledAttributes.getFloat(index, this.f1295r) % 360.0f;
                        this.f1295r = f7;
                        if (f7 < 0.0f) {
                            this.f1295r = (360.0f - f7) % 360.0f;
                        } else {
                            continue;
                        }
                    case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                        this.f1263a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1263a);
                        continue;
                    case 6:
                        this.f1265b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1265b);
                        continue;
                    case 7:
                        this.f1267c = obtainStyledAttributes.getFloat(index, this.f1267c);
                        continue;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.e);
                        this.e = resourceId2;
                        if (resourceId2 == -1) {
                            this.e = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f1272f);
                        this.f1272f = resourceId3;
                        if (resourceId3 == -1) {
                            this.f1272f = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case ErrorCode.FRAME_ALLOC_CODE /* 10 */:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f1274g);
                        this.f1274g = resourceId4;
                        if (resourceId4 == -1) {
                            this.f1274g = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case ErrorCode.PACKET_ALLOC_CODE /* 11 */:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f1276h);
                        this.f1276h = resourceId5;
                        if (resourceId5 == -1) {
                            this.f1276h = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case ErrorCode.CODEC_CONTEXT_ALLOC_CODE /* 12 */:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f1278i);
                        this.f1278i = resourceId6;
                        if (resourceId6 == -1) {
                            this.f1278i = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f1280j);
                        this.f1280j = resourceId7;
                        if (resourceId7 == -1) {
                            this.f1280j = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f1282k);
                        this.f1282k = resourceId8;
                        if (resourceId8 == -1) {
                            this.f1282k = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f1284l);
                        this.f1284l = resourceId9;
                        if (resourceId9 == -1) {
                            this.f1284l = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.m);
                        this.m = resourceId10;
                        if (resourceId10 == -1) {
                            this.m = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.s);
                        this.s = resourceId11;
                        if (resourceId11 == -1) {
                            this.s = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.f1296t);
                        this.f1296t = resourceId12;
                        if (resourceId12 == -1) {
                            this.f1296t = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.f1297u);
                        this.f1297u = resourceId13;
                        if (resourceId13 == -1) {
                            this.f1297u = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case ErrorCode.FILE_OPEN_IO_CODE /* 20 */:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.f1298v);
                        this.f1298v = resourceId14;
                        if (resourceId14 == -1) {
                            this.f1298v = obtainStyledAttributes.getInt(index, -1);
                        } else {
                            continue;
                        }
                    case ErrorCode.FILE_NOT_FOUND_IO_CODE /* 21 */:
                        this.f1299w = obtainStyledAttributes.getDimensionPixelSize(index, this.f1299w);
                        continue;
                    case ErrorCode.INVALID_RAW_RESOURCE_IO_CODE /* 22 */:
                        this.f1300x = obtainStyledAttributes.getDimensionPixelSize(index, this.f1300x);
                        continue;
                    case ErrorCode.NO_INPUT_FILE_IO_CODE /* 23 */:
                        this.f1301y = obtainStyledAttributes.getDimensionPixelSize(index, this.f1301y);
                        continue;
                    case ErrorCode.INVALID_AUDIO_URL_IO_CODE /* 24 */:
                        this.f1302z = obtainStyledAttributes.getDimensionPixelSize(index, this.f1302z);
                        continue;
                    case ErrorCode.EXTENDED_PROCESSING_DISABLED_IO_CODE /* 25 */:
                        this.A = obtainStyledAttributes.getDimensionPixelSize(index, this.A);
                        continue;
                    case ErrorCode.INVALID_AUDIO_INPUT_STREAM_IO_CODE /* 26 */:
                        this.B = obtainStyledAttributes.getDimensionPixelSize(index, this.B);
                        continue;
                    case ErrorCode.INVALID_AUDIO_BYTE_ARRAY_IO_CODE /* 27 */:
                        this.W = obtainStyledAttributes.getBoolean(index, this.W);
                        continue;
                    case 28:
                        this.X = obtainStyledAttributes.getBoolean(index, this.X);
                        continue;
                    case 29:
                        this.E = obtainStyledAttributes.getFloat(index, this.E);
                        continue;
                    case ErrorCode.CODEC_NOT_FOUND_PROC_CODE /* 30 */:
                        this.F = obtainStyledAttributes.getFloat(index, this.F);
                        continue;
                    case ErrorCode.STREAM_NOT_FOUND_PROC_CODE /* 31 */:
                        int i9 = obtainStyledAttributes.getInt(index, 0);
                        this.L = i9;
                        if (i9 == 1) {
                            str = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.";
                            break;
                        } else {
                            continue;
                        }
                    case ErrorCode.STREAM_INFO_NOT_FOUND_PROC_CODE /* 32 */:
                        int i10 = obtainStyledAttributes.getInt(index, 0);
                        this.M = i10;
                        if (i10 == 1) {
                            str = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.";
                            break;
                        } else {
                            continue;
                        }
                    case ErrorCode.CODEC_PARAMETERS_COPY_PROC_CODE /* 33 */:
                        try {
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            continue;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.N) == -2) {
                                this.N = -2;
                            }
                        }
                    case ErrorCode.PACKET_SUBMITTING_PROC_CODE /* 34 */:
                        try {
                            this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                            continue;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.P) == -2) {
                                this.P = -2;
                            }
                        }
                    case ErrorCode.CODEC_OPEN_PROC_CODE /* 35 */:
                        this.R = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.R));
                        this.L = 2;
                        continue;
                    case ErrorCode.UNSUPPORTED_SAMPLE_FMT_PROC_CODE /* 36 */:
                        try {
                            this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            continue;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.O) == -2) {
                                this.O = -2;
                            }
                        }
                    case ErrorCode.DECODING_PROC_CODE /* 37 */:
                        try {
                            this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                            continue;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.Q) == -2) {
                                this.Q = -2;
                            }
                        }
                    case ErrorCode.INVALID_PARAMETER_FLAG_PROC_CODE /* 38 */:
                        this.S = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.S));
                        this.M = 2;
                        continue;
                    default:
                        switch (i8) {
                            case 44:
                                c.h(this, obtainStyledAttributes.getString(index));
                                continue;
                            case 45:
                                this.H = obtainStyledAttributes.getFloat(index, this.H);
                                continue;
                            case 46:
                                this.I = obtainStyledAttributes.getFloat(index, this.I);
                                continue;
                            case 47:
                                this.J = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 48:
                                this.K = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 49:
                                this.T = obtainStyledAttributes.getDimensionPixelOffset(index, this.T);
                                continue;
                            case 50:
                                this.U = obtainStyledAttributes.getDimensionPixelOffset(index, this.U);
                                continue;
                            case 51:
                                this.Y = obtainStyledAttributes.getString(index);
                                continue;
                            case 52:
                                int resourceId15 = obtainStyledAttributes.getResourceId(index, this.f1287n);
                                this.f1287n = resourceId15;
                                if (resourceId15 == -1) {
                                    this.f1287n = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    continue;
                                }
                            case 53:
                                int resourceId16 = obtainStyledAttributes.getResourceId(index, this.f1289o);
                                this.f1289o = resourceId16;
                                if (resourceId16 == -1) {
                                    this.f1289o = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    continue;
                                }
                            case 54:
                                this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                                continue;
                            case 55:
                                this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                continue;
                            default:
                                switch (i8) {
                                    case 64:
                                        c.g(this, obtainStyledAttributes, index, 0);
                                        continue;
                                        continue;
                                        continue;
                                    case 65:
                                        c.g(this, obtainStyledAttributes, index, 1);
                                        continue;
                                    case 66:
                                        this.Z = obtainStyledAttributes.getInt(index, this.Z);
                                        continue;
                                    case 67:
                                        this.f1269d = obtainStyledAttributes.getBoolean(index, this.f1269d);
                                        continue;
                                }
                        }
                        break;
                }
                Log.e("ConstraintLayout", str);
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1263a = -1;
            this.f1265b = -1;
            this.f1267c = -1.0f;
            this.f1269d = true;
            this.e = -1;
            this.f1272f = -1;
            this.f1274g = -1;
            this.f1276h = -1;
            this.f1278i = -1;
            this.f1280j = -1;
            this.f1282k = -1;
            this.f1284l = -1;
            this.m = -1;
            this.f1287n = -1;
            this.f1289o = -1;
            this.f1291p = -1;
            this.f1293q = 0;
            this.f1295r = 0.0f;
            this.s = -1;
            this.f1296t = -1;
            this.f1297u = -1;
            this.f1298v = -1;
            this.f1299w = Integer.MIN_VALUE;
            this.f1300x = Integer.MIN_VALUE;
            this.f1301y = Integer.MIN_VALUE;
            this.f1302z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.f1264a0 = true;
            this.f1266b0 = true;
            this.f1268c0 = false;
            this.f1270d0 = false;
            this.f1271e0 = false;
            this.f1273f0 = false;
            this.f1275g0 = -1;
            this.f1277h0 = -1;
            this.f1279i0 = -1;
            this.f1281j0 = -1;
            this.f1283k0 = Integer.MIN_VALUE;
            this.f1285l0 = Integer.MIN_VALUE;
            this.f1286m0 = 0.5f;
            this.f1294q0 = new y0.d();
        }

        public final void a() {
            this.f1270d0 = false;
            this.f1264a0 = true;
            this.f1266b0 = true;
            int i7 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i7 == -2 && this.W) {
                this.f1264a0 = false;
                if (this.L == 0) {
                    this.L = 1;
                }
            }
            int i8 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i8 == -2 && this.X) {
                this.f1266b0 = false;
                if (this.M == 0) {
                    this.M = 1;
                }
            }
            if (i7 == 0 || i7 == -1) {
                this.f1264a0 = false;
                if (i7 == 0 && this.L == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.W = true;
                }
            }
            if (i8 == 0 || i8 == -1) {
                this.f1266b0 = false;
                if (i8 == 0 && this.M == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.X = true;
                }
            }
            if (this.f1267c == -1.0f && this.f1263a == -1 && this.f1265b == -1) {
                return;
            }
            this.f1270d0 = true;
            this.f1264a0 = true;
            this.f1266b0 = true;
            if (!(this.f1294q0 instanceof g)) {
                this.f1294q0 = new g();
            }
            ((g) this.f1294q0).R(this.V);
        }

        /* JADX WARN: Code restructure failed: missing block: B:386:0x00d0, code lost:
            if (r1 > 0) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:387:0x00d2, code lost:
            ((android.view.ViewGroup.MarginLayoutParams) r10).rightMargin = r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:392:0x00df, code lost:
            if (r1 > 0) goto L52;
         */
        /* JADX WARN: Removed duplicated region for block: B:329:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:332:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:335:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:338:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:341:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:350:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:351:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:396:0x00e6  */
        /* JADX WARN: Removed duplicated region for block: B:400:0x00f1  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @android.annotation.TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void resolveLayoutDirection(int r11) {
            /*
                Method dump skipped, instructions count: 255
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a.resolveLayoutDirection(int):void");
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.InterfaceC0136b {

        /* renamed from: a */
        public ConstraintLayout f1304a;

        /* renamed from: b */
        public int f1305b;

        /* renamed from: c */
        public int f1306c;

        /* renamed from: d */
        public int f1307d;
        public int e;

        /* renamed from: f */
        public int f1308f;

        /* renamed from: g */
        public int f1309g;

        public b(ConstraintLayout constraintLayout) {
            ConstraintLayout.this = r1;
            this.f1304a = constraintLayout;
        }

        public static boolean a(int i7, int i8, int i9) {
            if (i7 == i8) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i7);
            View.MeasureSpec.getSize(i7);
            int mode2 = View.MeasureSpec.getMode(i8);
            int size = View.MeasureSpec.getSize(i8);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i9 == size;
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:811:0x01a3  */
        /* JADX WARN: Removed duplicated region for block: B:814:0x01b6  */
        /* JADX WARN: Removed duplicated region for block: B:815:0x01b8  */
        /* JADX WARN: Removed duplicated region for block: B:817:0x01bb  */
        /* JADX WARN: Removed duplicated region for block: B:818:0x01bd  */
        /* JADX WARN: Removed duplicated region for block: B:842:0x01e8 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:843:0x01e9  */
        @android.annotation.SuppressLint({"WrongCall"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void b(y0.d r18, z0.b.a r19) {
            /*
                Method dump skipped, instructions count: 735
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b.b(y0.d, z0.b$a):void");
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1250f = new SparseArray<>();
        this.f1251g = new ArrayList<>(4);
        this.f1252h = new y0.e();
        this.f1253i = 0;
        this.f1254j = 0;
        this.f1255k = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.f1256l = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.m = true;
        this.f1257n = 257;
        this.f1258o = null;
        this.f1259p = null;
        this.f1260q = -1;
        this.f1261r = new HashMap<>();
        this.s = new SparseArray<>();
        this.f1262t = new b(this);
        d(attributeSet, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f1250f = new SparseArray<>();
        this.f1251g = new ArrayList<>(4);
        this.f1252h = new y0.e();
        this.f1253i = 0;
        this.f1254j = 0;
        this.f1255k = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.f1256l = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.m = true;
        this.f1257n = 257;
        this.f1258o = null;
        this.f1259p = null;
        this.f1260q = -1;
        this.f1261r = new HashMap<>();
        this.s = new SparseArray<>();
        this.f1262t = new b(this);
        d(attributeSet, i7);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int max2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return max2 > 0 ? max2 : max;
    }

    public static b1.e getSharedValues() {
        if (f1249u == null) {
            f1249u = new b1.e();
        }
        return f1249u;
    }

    public final y0.d c(View view) {
        if (view == this) {
            return this.f1252h;
        }
        if (view != null) {
            if (!(view.getLayoutParams() instanceof a)) {
                view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
                if (!(view.getLayoutParams() instanceof a)) {
                    return null;
                }
            }
            return ((a) view.getLayoutParams()).f1294q0;
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public final void d(AttributeSet attributeSet, int i7) {
        y0.e eVar = this.f1252h;
        eVar.f6526i0 = this;
        b bVar = this.f1262t;
        eVar.f6554w0 = bVar;
        eVar.f6552u0.f6869f = bVar;
        this.f1250f.put(getId(), this);
        this.f1258o = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a0.b.e, i7, 0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = obtainStyledAttributes.getIndex(i8);
                if (index == 16) {
                    this.f1253i = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1253i);
                } else if (index == 17) {
                    this.f1254j = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1254j);
                } else if (index == 14) {
                    this.f1255k = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1255k);
                } else if (index == 15) {
                    this.f1256l = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1256l);
                } else if (index == 113) {
                    this.f1257n = obtainStyledAttributes.getInt(index, this.f1257n);
                } else if (index == 56) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            f(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f1259p = null;
                        }
                    }
                } else if (index == 34) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        c cVar = new c();
                        this.f1258o = cVar;
                        cVar.e(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f1258o = null;
                    }
                    this.f1260q = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        y0.e eVar2 = this.f1252h;
        eVar2.F0 = this.f1257n;
        w0.d.f6341p = eVar2.W(512);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<androidx.constraintlayout.widget.b> arrayList = this.f1251g;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                this.f1251g.get(i7).getClass();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i9 = (int) ((parseInt / 1080.0f) * width);
                        int i10 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f7 = i9;
                        float f8 = i10;
                        float f9 = i9 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f7, f8, f9, f8, paint);
                        float parseInt4 = i10 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f9, f8, f9, parseInt4, paint);
                        canvas.drawLine(f9, parseInt4, f7, parseInt4, paint);
                        canvas.drawLine(f7, parseInt4, f7, f8, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f7, f8, f9, parseInt4, paint);
                        canvas.drawLine(f7, parseInt4, f9, f8, paint);
                    }
                }
            }
        }
    }

    public final boolean e() {
        return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
    }

    public void f(int i7) {
        this.f1259p = new b1.b(getContext(), this, i7);
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.m = true;
        super.forceLayout();
    }

    public final void g(String str, Integer num) {
        if ((str instanceof String) && (num instanceof Integer)) {
            if (this.f1261r == null) {
                this.f1261r = new HashMap<>();
            }
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.f1261r.put(str, Integer.valueOf(num.intValue()));
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public int getMaxHeight() {
        return this.f1256l;
    }

    public int getMaxWidth() {
        return this.f1255k;
    }

    public int getMinHeight() {
        return this.f1254j;
    }

    public int getMinWidth() {
        return this.f1253i;
    }

    public int getOptimizationLevel() {
        return this.f1252h.F0;
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        if (this.f1252h.f6529k == null) {
            int id2 = getId();
            if (id2 != -1) {
                this.f1252h.f6529k = getContext().getResources().getResourceEntryName(id2);
            } else {
                this.f1252h.f6529k = "parent";
            }
        }
        y0.e eVar = this.f1252h;
        if (eVar.f6530k0 == null) {
            eVar.f6530k0 = eVar.f6529k;
            StringBuilder d7 = h.d(" setDebugName ");
            d7.append(this.f1252h.f6530k0);
            Log.v("ConstraintLayout", d7.toString());
        }
        Iterator<y0.d> it = this.f1252h.f6591s0.iterator();
        while (it.hasNext()) {
            y0.d next = it.next();
            View view = (View) next.f6526i0;
            if (view != null) {
                if (next.f6529k == null && (id = view.getId()) != -1) {
                    next.f6529k = getContext().getResources().getResourceEntryName(id);
                }
                if (next.f6530k0 == null) {
                    next.f6530k0 = next.f6529k;
                    StringBuilder d8 = h.d(" setDebugName ");
                    d8.append(next.f6530k0);
                    Log.v("ConstraintLayout", d8.toString());
                }
            }
        }
        this.f1252h.o(sb);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:1189:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:1192:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:1199:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:1202:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:1210:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:1213:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:1221:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:1222:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:1235:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:1240:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:1243:0x040f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean h() {
        /*
            Method dump skipped, instructions count: 1463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.h():boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            a aVar = (a) childAt.getLayoutParams();
            y0.d dVar = aVar.f1294q0;
            if ((childAt.getVisibility() != 8 || aVar.f1270d0 || aVar.f1271e0 || isInEditMode) && !aVar.f1273f0) {
                int s = dVar.s();
                int t5 = dVar.t();
                int r6 = dVar.r() + s;
                int l6 = dVar.l() + t5;
                childAt.layout(s, t5, r6, l6);
                if ((childAt instanceof f) && (content = ((f) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(s, t5, r6, l6);
                }
            }
        }
        int size = this.f1251g.size();
        if (size > 0) {
            for (int i12 = 0; i12 < size; i12++) {
                this.f1251g.get(i12).getClass();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:1443:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:1452:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:1458:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:1465:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:1468:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:1471:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:1477:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:1513:0x01ea A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:1519:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:1638:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:1640:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:1644:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:1725:0x05d4  */
    /* JADX WARN: Removed duplicated region for block: B:1727:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:1812:0x079d  */
    /* JADX WARN: Removed duplicated region for block: B:1817:0x07ea  */
    /* JADX WARN: Removed duplicated region for block: B:1819:0x07ed  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r25, int r26) {
        /*
            Method dump skipped, instructions count: 2034
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        y0.d c7 = c(view);
        if ((view instanceof e) && !(c7 instanceof g)) {
            a aVar = (a) view.getLayoutParams();
            g gVar = new g();
            aVar.f1294q0 = gVar;
            aVar.f1270d0 = true;
            gVar.R(aVar.V);
        }
        if (view instanceof androidx.constraintlayout.widget.b) {
            androidx.constraintlayout.widget.b bVar = (androidx.constraintlayout.widget.b) view;
            bVar.k();
            ((a) view.getLayoutParams()).f1271e0 = true;
            if (!this.f1251g.contains(bVar)) {
                this.f1251g.add(bVar);
            }
        }
        this.f1250f.put(view.getId(), view);
        this.m = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f1250f.remove(view.getId());
        y0.d c7 = c(view);
        this.f1252h.f6591s0.remove(c7);
        c7.D();
        this.f1251g.remove(view);
        this.m = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.m = true;
        super.requestLayout();
    }

    public void setConstraintSet(c cVar) {
        this.f1258o = cVar;
    }

    @Override // android.view.View
    public void setId(int i7) {
        this.f1250f.remove(getId());
        super.setId(i7);
        this.f1250f.put(getId(), this);
    }

    public void setMaxHeight(int i7) {
        if (i7 == this.f1256l) {
            return;
        }
        this.f1256l = i7;
        requestLayout();
    }

    public void setMaxWidth(int i7) {
        if (i7 == this.f1255k) {
            return;
        }
        this.f1255k = i7;
        requestLayout();
    }

    public void setMinHeight(int i7) {
        if (i7 == this.f1254j) {
            return;
        }
        this.f1254j = i7;
        requestLayout();
    }

    public void setMinWidth(int i7) {
        if (i7 == this.f1253i) {
            return;
        }
        this.f1253i = i7;
        requestLayout();
    }

    public void setOnConstraintsChanged(b1.c cVar) {
        b1.b bVar = this.f1259p;
        if (bVar != null) {
            bVar.getClass();
        }
    }

    public void setOptimizationLevel(int i7) {
        this.f1257n = i7;
        y0.e eVar = this.f1252h;
        eVar.F0 = i7;
        w0.d.f6341p = eVar.W(512);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
