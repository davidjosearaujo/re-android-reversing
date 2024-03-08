package com.masoudss.lib;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.MimeTypeMap;
import e5.e;
import f5.g;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import l0.z;
import linc.com.amplituda.Amplituda;
import linc.com.amplituda.AmplitudaProcessingOutput;
import q5.l;
import r5.h;
import r5.i;
import w5.c;
import w5.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class WaveformSeekBar extends View {
    public int A;
    public int B;
    public int C;
    public int D;
    public float E;
    public float F;
    public float G;
    public HashMap<Float, String> I;
    public float J;
    public float M;
    public float N;
    public float O;

    /* renamed from: f */
    public int f3401f;

    /* renamed from: g */
    public int f3402g;
    public int m;

    /* renamed from: n */
    public float f3408n;

    /* renamed from: o */
    public float f3409o;

    /* renamed from: p */
    public int f3410p;

    /* renamed from: q */
    public boolean f3411q;

    /* renamed from: r */
    public Bitmap f3412r;
    public BitmapShader s;

    /* renamed from: t */
    public s4.a f3413t;

    /* renamed from: u */
    public int[] f3414u;

    /* renamed from: v */
    public float f3415v;

    /* renamed from: z */
    public float f3419z;

    /* renamed from: h */
    public final Paint f3403h = new Paint(1);

    /* renamed from: i */
    public final RectF f3404i = new RectF();

    /* renamed from: j */
    public final Paint f3405j = new Paint(1);

    /* renamed from: k */
    public final RectF f3406k = new RectF();

    /* renamed from: l */
    public final Canvas f3407l = new Canvas();

    /* renamed from: w */
    public float f3416w = 100.0f;

    /* renamed from: x */
    public int f3417x = -3355444;

    /* renamed from: y */
    public int f3418y = -1;
    public t4.a H = t4.a.CENTER;
    public int K = -16711936;
    public int L = -65536;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends i implements l<int[], g> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super(1);
            WaveformSeekBar.this = r1;
        }

        @Override // q5.l
        public final g k(int[] iArr) {
            int[] iArr2 = iArr;
            h.f(iArr2, "it");
            WaveformSeekBar.this.setSample(iArr2);
            return g.f4141a;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b extends i implements l<int[], g> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b() {
            super(1);
            WaveformSeekBar.this = r1;
        }

        @Override // q5.l
        public final g k(int[] iArr) {
            int[] iArr2 = iArr;
            h.f(iArr2, "it");
            WaveformSeekBar.this.setSample(iArr2);
            return g.f4141a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WaveformSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        h.f(context, "context");
        this.m = (int) z.n(context, 2);
        this.f3410p = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f3419z = z.n(context, 2);
        float n6 = z.n(context, 5);
        this.E = n6;
        this.F = n6;
        this.G = z.n(context, 2);
        this.J = z.n(context, 1);
        this.M = z.n(context, 12);
        this.N = z.n(context, 2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q2.a.f5642b);
        h.e(obtainStyledAttributes, "context.obtainStyledAttr…tyleable.WaveformSeekBar)");
        setWaveWidth(obtainStyledAttributes.getDimension(18, this.E));
        setWaveGap(obtainStyledAttributes.getDimension(7, this.f3419z));
        setWavePaddingTop((int) obtainStyledAttributes.getDimension(14, 0.0f));
        setWavePaddingBottom((int) obtainStyledAttributes.getDimension(11, 0.0f));
        setWavePaddingLeft((int) obtainStyledAttributes.getDimension(12, 0.0f));
        setWavePaddingRight((int) obtainStyledAttributes.getDimension(13, 0.0f));
        setWaveCornerRadius(obtainStyledAttributes.getDimension(6, this.G));
        setWaveMinHeight(obtainStyledAttributes.getDimension(10, this.F));
        setWaveBackgroundColor(obtainStyledAttributes.getColor(5, this.f3417x));
        setWaveProgressColor(obtainStyledAttributes.getColor(16, this.f3418y));
        setProgress(obtainStyledAttributes.getFloat(15, this.f3415v));
        setMaxProgress(obtainStyledAttributes.getFloat(9, this.f3416w));
        setVisibleProgress(obtainStyledAttributes.getFloat(17, this.O));
        String string = obtainStyledAttributes.getString(8);
        setWaveGravity(t4.a.values()[string != null ? Integer.parseInt(string) : 1]);
        setMarkerWidth(obtainStyledAttributes.getDimension(4, this.J));
        setMarkerColor(obtainStyledAttributes.getColor(0, this.K));
        setMarkerTextColor(obtainStyledAttributes.getColor(1, this.L));
        setMarkerTextSize(obtainStyledAttributes.getDimension(3, this.M));
        setMarkerTextPadding(obtainStyledAttributes.getDimension(2, this.N));
        obtainStyledAttributes.recycle();
    }

    private final int getAvailableHeight() {
        int paddingTop = (this.f3402g - getPaddingTop()) - getPaddingBottom();
        if (paddingTop <= 0) {
            return 1;
        }
        return paddingTop;
    }

    private final int getAvailableWidth() {
        int paddingLeft = (this.f3401f - getPaddingLeft()) - getPaddingRight();
        if (paddingLeft <= 0) {
            return 1;
        }
        return paddingLeft;
    }

    public final void a(MotionEvent motionEvent) {
        MediaPlayer mediaPlayer;
        float f7 = this.O;
        setProgress(f7 > 0.0f ? d.W(this.f3409o - (((motionEvent.getX() - this.f3408n) * f7) / ((float) getAvailableWidth())), 0.0f, this.f3416w) : (motionEvent.getX() * this.f3416w) / ((float) getAvailableWidth()));
        s4.a aVar = this.f3413t;
        if (aVar != null) {
            float f8 = this.f3415v;
            e5.g gVar = ((e) aVar).f3793a;
            if (this == gVar.f3801h && (mediaPlayer = gVar.e) != null) {
                mediaPlayer.seekTo(Math.round(f8));
            }
        }
    }

    public final HashMap<Float, String> getMarker() {
        return this.I;
    }

    public final int getMarkerColor() {
        return this.K;
    }

    public final int getMarkerTextColor() {
        return this.L;
    }

    public final float getMarkerTextPadding() {
        return this.N;
    }

    public final float getMarkerTextSize() {
        return this.M;
    }

    public final float getMarkerWidth() {
        return this.J;
    }

    public final float getMaxProgress() {
        return this.f3416w;
    }

    public final s4.a getOnProgressChanged() {
        return this.f3413t;
    }

    public final float getProgress() {
        return this.f3415v;
    }

    public final int[] getSample() {
        return this.f3414u;
    }

    public final float getVisibleProgress() {
        return this.O;
    }

    public final int getWaveBackgroundColor() {
        return this.f3417x;
    }

    public final float getWaveCornerRadius() {
        return this.G;
    }

    public final float getWaveGap() {
        return this.f3419z;
    }

    public final t4.a getWaveGravity() {
        return this.H;
    }

    public final float getWaveMinHeight() {
        return this.F;
    }

    public final int getWavePaddingBottom() {
        return this.B;
    }

    public final int getWavePaddingLeft() {
        return this.C;
    }

    public final int getWavePaddingRight() {
        return this.D;
    }

    public final int getWavePaddingTop() {
        return this.A;
    }

    public final int getWaveProgressColor() {
        return this.f3418y;
    }

    public final float getWaveWidth() {
        return this.E;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f7;
        int i7;
        HashMap<Float, String> hashMap;
        float f8;
        int i8;
        Paint paint;
        h.f(canvas, "canvas");
        super.onDraw(canvas);
        int[] iArr = this.f3414u;
        if (iArr != null) {
            int i9 = 1;
            if (!(iArr.length == 0)) {
                canvas.clipRect(getPaddingLeft(), getPaddingTop(), this.f3401f - getPaddingRight(), this.f3402g - getPaddingBottom());
                float f9 = this.f3419z + this.E;
                float length = ((float) iArr.length) / (((float) getAvailableWidth()) / f9);
                float paddingLeft = ((float) getPaddingLeft()) + ((float) this.C);
                int availableWidth = (int) (((float) getAvailableWidth()) / f9);
                float f10 = this.O;
                if (f10 > 0.0f) {
                    length *= f10 / this.f3416w;
                    int i10 = availableWidth + 1;
                    float availableWidth2 = ((((float) getAvailableWidth()) * 0.5f) % f9) + paddingLeft;
                    float f11 = (float) ((i10 + 1) % 2);
                    float f12 = (((f11 * 0.5f) * f9) - f9) + availableWidth2;
                    float f13 = this.f3415v;
                    float f14 = this.O;
                    float f15 = (float) i10;
                    float f16 = f14 / f15;
                    paddingLeft = f12 - (((((((f11 * f14) / f15) * 0.5f) + f13) % f16) / f16) * f9);
                    i7 = q2.a.K(((f13 * f15) / f14) - (f15 / 2.0f)) - 1;
                    f7 = ((float) getAvailableWidth()) * 0.5f;
                } else {
                    f7 = (((float) getAvailableWidth()) * this.f3415v) / this.f3416w;
                    i7 = 0;
                }
                int i11 = availableWidth + i7 + 3;
                while (i7 < i11) {
                    int K = q2.a.K((float) Math.floor((double) (((float) i7) * length)));
                    float availableHeight = (((K < 0 || K >= iArr.length) ? 0 : i9) == 0 || this.m == 0) ? 0.0f : (((float) iArr[K]) / ((float) this.m)) * ((float) ((getAvailableHeight() - this.A) - this.B));
                    float f17 = this.F;
                    if (availableHeight < f17) {
                        availableHeight = f17;
                    }
                    int ordinal = this.H.ordinal();
                    if (ordinal == 0) {
                        f8 = ((float) getPaddingTop()) + ((float) this.A);
                    } else if (ordinal == i9) {
                        f8 = (((float) ((getPaddingTop() + this.A) + getAvailableHeight())) / 2.0f) - (availableHeight / 2.0f);
                    } else if (ordinal == 2) {
                        f8 = ((float) ((this.f3402g - getPaddingBottom()) - this.B)) - availableHeight;
                    } else {
                        throw new f5.b();
                    }
                    this.f3404i.set(paddingLeft, f8, this.E + paddingLeft, availableHeight + f8);
                    RectF rectF = this.f3404i;
                    if (rectF.contains(f7, rectF.centerY())) {
                        Canvas canvas2 = this.f3407l;
                        Bitmap bitmap = this.f3412r;
                        if (bitmap != null) {
                            canvas2.setBitmap(bitmap);
                            this.f3403h.setColor(this.f3418y);
                            this.f3407l.drawRect(0.0f, 0.0f, f7, this.f3404i.bottom, this.f3403h);
                            this.f3403h.setColor(this.f3417x);
                            this.f3407l.drawRect(f7, 0.0f, (float) getAvailableWidth(), this.f3404i.bottom, this.f3403h);
                            Paint paint2 = this.f3403h;
                            BitmapShader bitmapShader = this.s;
                            if (bitmapShader != null) {
                                paint2.setShader(bitmapShader);
                            } else {
                                h.k("progressShader");
                                throw null;
                            }
                        } else {
                            h.k("progressBitmap");
                            throw null;
                        }
                    } else {
                        if (this.f3404i.right <= f7) {
                            paint = this.f3403h;
                            i8 = this.f3418y;
                        } else {
                            paint = this.f3403h;
                            i8 = this.f3417x;
                        }
                        paint.setColor(i8);
                        this.f3403h.setShader(null);
                    }
                    RectF rectF2 = this.f3404i;
                    float f18 = this.G;
                    canvas.drawRoundRect(rectF2, f18, f18, this.f3403h);
                    paddingLeft = this.f3419z + this.f3404i.right;
                    i7++;
                    i9 = 1;
                }
                if (this.O <= 0.0f && (hashMap = this.I) != null) {
                    for (Map.Entry<Float, String> entry : hashMap.entrySet()) {
                        if (entry.getKey().floatValue() >= 0.0f && entry.getKey().floatValue() <= this.f3416w) {
                            float floatValue = (entry.getKey().floatValue() / this.f3416w) * ((float) getAvailableWidth());
                            RectF rectF3 = this.f3406k;
                            float f19 = (float) 2;
                            float f20 = this.J / f19;
                            rectF3.set(floatValue - f20, 0.0f, f20 + floatValue, (float) getAvailableHeight());
                            this.f3405j.setColor(this.K);
                            canvas.drawRect(this.f3406k, this.f3405j);
                            float f21 = this.N;
                            this.f3405j.setTextSize(this.M);
                            this.f3405j.setColor(this.L);
                            canvas.rotate(90.0f);
                            canvas.drawText(entry.getValue(), f21, ((-floatValue) - (this.J / f19)) - f21, this.f3405j);
                            canvas.rotate(-90.0f);
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i7, int i8, int i9, int i10) {
        super.onSizeChanged(i7, i8, i9, i10);
        this.f3401f = i7;
        this.f3402g = i8;
        Bitmap createBitmap = Bitmap.createBitmap(getAvailableWidth(), getAvailableHeight(), Bitmap.Config.ARGB_8888);
        h.e(createBitmap, "createBitmap(getAvailabl… Bitmap.Config.ARGB_8888)");
        this.f3412r = createBitmap;
        Bitmap bitmap = this.f3412r;
        if (bitmap != null) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.s = new BitmapShader(bitmap, tileMode, tileMode);
            return;
        }
        h.k("progressBitmap");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
        if (r3.intValue() != 1) goto L_0x00f9;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.masoudss.lib.WaveformSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final boolean performClick() {
        super.performClick();
        return true;
    }

    public final void setMarker(HashMap<Float, String> hashMap) {
        this.I = hashMap;
        invalidate();
    }

    public final void setMarkerColor(int i7) {
        this.K = i7;
        invalidate();
    }

    public final void setMarkerTextColor(int i7) {
        this.L = i7;
        invalidate();
    }

    public final void setMarkerTextPadding(float f7) {
        this.N = f7;
        invalidate();
    }

    public final void setMarkerTextSize(float f7) {
        this.M = f7;
        invalidate();
    }

    public final void setMarkerWidth(float f7) {
        this.J = f7;
        invalidate();
    }

    public final void setMaxProgress(float f7) {
        this.f3416w = f7;
        invalidate();
    }

    public final void setOnProgressChanged(s4.a aVar) {
        this.f3413t = aVar;
    }

    public final void setProgress(float f7) {
        this.f3415v = f7;
        invalidate();
    }

    public final void setSample(int[] iArr) {
        Integer num;
        this.f3414u = iArr;
        int i7 = 0;
        if (iArr != null) {
            if (iArr.length == 0) {
                num = null;
            } else {
                int i8 = iArr[0];
                c cVar = new c(1, iArr.length - 1);
                w5.b bVar = new w5.b(1, cVar.f6412g, cVar.f6413h);
                while (bVar.f6416h) {
                    int i9 = iArr[bVar.nextInt()];
                    if (i8 < i9) {
                        i8 = i9;
                    }
                }
                num = Integer.valueOf(i8);
            }
            if (num != null) {
                i7 = num.intValue();
            }
        }
        this.m = i7;
        invalidate();
    }

    public final void setSampleFrom(int i7) {
        Context context = getContext();
        h.e(context, "context");
        b bVar = new b();
        AmplitudaProcessingOutput<Integer> processAudio = new Amplituda(context).processAudio(i7);
        h.e(processAudio, "Amplituda(context).processAudio(resource)");
        List<Integer> amplitudesAsList = processAudio.get(new c0.e(3)).amplitudesAsList();
        h.e(amplitudesAsList, "result.amplitudesAsList()");
        Object[] array = amplitudesAsList.toArray(new Integer[0]);
        if (array != null) {
            Integer[] numArr = (Integer[]) array;
            int length = numArr.length;
            int[] iArr = new int[length];
            for (int i8 = 0; i8 < length; i8++) {
                iArr[i8] = numArr[i8].intValue();
            }
            bVar.k(iArr);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public final void setSampleFrom(File file) {
        h.f(file, "audio");
        String path = file.getPath();
        h.e(path, "audio.path");
        setSampleFrom(path);
    }

    public final void setSampleFrom(int[] iArr) {
        h.f(iArr, "samples");
        setSample(iArr);
    }

    public final void setVisibleProgress(float f7) {
        this.O = f7;
        invalidate();
    }

    public final void setWaveBackgroundColor(int i7) {
        this.f3417x = i7;
        invalidate();
    }

    public final void setWaveCornerRadius(float f7) {
        this.G = f7;
        invalidate();
    }

    public final void setWaveGap(float f7) {
        this.f3419z = f7;
        invalidate();
    }

    public final void setWaveGravity(t4.a aVar) {
        h.f(aVar, "value");
        this.H = aVar;
        invalidate();
    }

    public final void setWaveMinHeight(float f7) {
        this.F = f7;
        invalidate();
    }

    public final void setWavePaddingBottom(int i7) {
        this.B = i7;
        invalidate();
    }

    public final void setWavePaddingLeft(int i7) {
        this.C = i7;
        invalidate();
    }

    public final void setWavePaddingRight(int i7) {
        this.D = i7;
        invalidate();
    }

    public final void setWavePaddingTop(int i7) {
        this.A = i7;
        invalidate();
    }

    public final void setWaveProgressColor(int i7) {
        this.f3418y = i7;
        invalidate();
    }

    public final void setWaveWidth(float f7) {
        this.E = f7;
        invalidate();
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    public final void setSampleFrom(Uri uri) {
        byte[] bArr;
        File file;
        BufferedInputStream fileOutputStream;
        h.f(uri, "audio");
        Context context = getContext();
        h.e(context, "context");
        Amplituda amplituda = new Amplituda(context);
        ContentResolver contentResolver = context.getContentResolver();
        h.e(contentResolver, "");
        InputStream openInputStream = contentResolver.openInputStream(uri);
        th = 0;
        if (openInputStream != null) {
            fileOutputStream = openInputStream instanceof BufferedInputStream ? (BufferedInputStream) openInputStream : new BufferedInputStream(openInputStream, 8192);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, fileOutputStream.available()));
                byte[] bArr2 = new byte[8192];
                while (true) {
                    int read = fileOutputStream.read(bArr2);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                bArr = byteArrayOutputStream.toByteArray();
                h.e(bArr, "toByteArray(...)");
            } finally {
                try {
                    throw th;
                } catch (Throwable th) {
                }
            }
        } else {
            bArr = null;
        }
        if (bArr != null) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(contentResolver.getType(uri));
            File file2 = new File(context.getCacheDir().getPath(), UUID.randomUUID() + '.' + mimeTypeFromExtension);
            fileOutputStream = new FileOutputStream(file2);
            try {
                fileOutputStream.write(bArr);
                g gVar = g.f4141a;
                q2.a.l(fileOutputStream, null);
                file = file2;
            } finally {
                try {
                    throw th;
                } finally {
                    q2.a.l(fileOutputStream, th);
                }
            }
        }
        AmplitudaProcessingOutput<File> processAudio = amplituda.processAudio(file);
        h.e(processAudio, "Amplituda(context).proce…o(context.uriToFile(uri))");
        List<Integer> amplitudesAsList = processAudio.get(new c0.e(3)).amplitudesAsList();
        h.e(amplitudesAsList, "result.amplitudesAsList()");
        Object[] array = amplitudesAsList.toArray(new Integer[0]);
        if (array != null) {
            Integer[] numArr = (Integer[]) array;
            int length = numArr.length;
            int[] iArr = new int[length];
            for (int i7 = 0; i7 < length; i7++) {
                iArr[i7] = numArr[i7].intValue();
            }
            setSample(iArr);
            g gVar2 = g.f4141a;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public final void setSampleFrom(String str) {
        h.f(str, "audio");
        Context context = getContext();
        h.e(context, "context");
        a aVar = new a();
        AmplitudaProcessingOutput<String> processAudio = new Amplituda(context).processAudio(str);
        h.e(processAudio, "Amplituda(context).processAudio(pathOrUrl)");
        List<Integer> amplitudesAsList = processAudio.get(new c0.e(3)).amplitudesAsList();
        h.e(amplitudesAsList, "result.amplitudesAsList()");
        Object[] array = amplitudesAsList.toArray(new Integer[0]);
        if (array != null) {
            Integer[] numArr = (Integer[]) array;
            int length = numArr.length;
            int[] iArr = new int[length];
            for (int i7 = 0; i7 < length; i7++) {
                iArr[i7] = numArr[i7].intValue();
            }
            aVar.k(iArr);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
