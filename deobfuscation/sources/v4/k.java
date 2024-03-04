package v4;

import a6.h0;
import a6.y;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.pdf.PdfRenderer;
import android.util.Log;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import g5.s;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import q5.q;
import v4.k;

/* loaded from: classes.dex */
public final class k extends RecyclerView.d<a> {

    /* renamed from: d */
    public final Context f6307d;
    public final d e;

    /* renamed from: f */
    public final Rect f6308f;

    /* renamed from: g */
    public final boolean f6309g;

    /* loaded from: classes.dex */
    public final class a extends RecyclerView.a0 {

        /* renamed from: u */
        public final w0.c f6310u;

        /* renamed from: v4.k$a$a */
        /* loaded from: classes.dex */
        public static final class C0125a extends r5.i implements q<Boolean, Integer, Bitmap, f5.g> {

            /* renamed from: g */
            public final /* synthetic */ int f6312g;

            /* renamed from: h */
            public final /* synthetic */ k f6313h;

            /* renamed from: i */
            public final /* synthetic */ int f6314i;

            /* renamed from: j */
            public final /* synthetic */ int f6315j;

            /* renamed from: k */
            public final /* synthetic */ Bitmap f6316k;

            /* renamed from: l */
            public final /* synthetic */ a f6317l;
            public final /* synthetic */ w0.c m;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0125a(int i7, k kVar, int i8, int i9, Bitmap bitmap, a aVar, w0.c cVar) {
                super(3);
                this.f6312g = i7;
                this.f6313h = kVar;
                this.f6314i = i8;
                this.f6315j = i9;
                this.f6316k = bitmap;
                this.f6317l = aVar;
                this.m = cVar;
            }

            @Override // q5.q
            public final f5.g f(Boolean bool, Integer num, Bitmap bitmap) {
                boolean z6;
                boolean booleanValue = bool.booleanValue();
                int intValue = num.intValue();
                Bitmap bitmap2 = bitmap;
                if (booleanValue && intValue == this.f6312g) {
                    g6.c cVar = h0.f297a;
                    a0.e.u(y.a(f6.m.f4172a), null, 0, new j(this.f6317l, bitmap2, this.f6316k, this.m, null), 3);
                    d dVar = this.f6313h.e;
                    int i7 = this.f6312g;
                    int i8 = this.f6314i;
                    int i9 = this.f6315j;
                    Context context = dVar.f6274a;
                    PdfRenderer pdfRenderer = dVar.f6275b;
                    r5.h.c(pdfRenderer);
                    r5.h.f(context, "context");
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    Object systemService = context.getSystemService("activity");
                    r5.h.d(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                    ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
                    long j5 = memoryInfo.availMem;
                    float pageCount = pdfRenderer.getPageCount();
                    int i10 = (j5 <= 1073741824 || pageCount >= 100.0f) ? (j5 <= 536870912 || pageCount >= 200.0f) ? 3 : 5 : 10;
                    Iterator<Integer> it = new w5.c(i7 - i10, i7 + i10).iterator();
                    while (((w5.b) it).f6416h) {
                        int nextInt = ((s) it).nextInt();
                        if (nextInt >= 0) {
                            PdfRenderer pdfRenderer2 = dVar.f6275b;
                            if (nextInt < (pdfRenderer2 != null ? pdfRenderer2.getPageCount() : 0)) {
                                z6 = true;
                                if (z6 && !new File(new File(dVar.f6274a.getCacheDir(), "___pdf___cache___"), String.valueOf(nextInt)).exists()) {
                                    a0.e.u(y.a(h0.f298b), null, 0, new e(i8, i9, dVar, nextInt, null), 3);
                                }
                            }
                        }
                        z6 = false;
                        if (z6) {
                            a0.e.u(y.a(h0.f298b), null, 0, new e(i8, i9, dVar, nextInt, null), 3);
                        }
                    }
                } else {
                    LinkedList<Bitmap> linkedList = x4.a.f6469a;
                    x4.a.b(this.f6316k);
                }
                return f5.g.f4141a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w0.c cVar) {
            super((FrameLayout) cVar.f6337a);
            k.this = r1;
            this.f6310u = cVar;
        }

        public final void q(final int i7) {
            w0.c cVar = this.f6310u;
            k kVar = k.this;
            if (kVar.f6309g) {
                d dVar = kVar.e;
                dVar.getClass();
                if (!new File(new File(dVar.f6274a.getCacheDir(), "___pdf___cache___"), String.valueOf(i7)).exists()) {
                    ProgressBar progressBar = (ProgressBar) ((androidx.appcompat.widget.l) cVar.f6339c).f964g;
                    r5.h.e(progressBar, "pdfViewPageLoadingProgress");
                    progressBar.setVisibility(0);
                    if (((ImageView) cVar.f6340d).getWidth() != 0 || ((ImageView) cVar.f6340d).getHeight() == 0) {
                        ((ImageView) cVar.f6340d).post(new Runnable() { // from class: v4.i
                            @Override // java.lang.Runnable
                            public final void run() {
                                k.a aVar = k.a.this;
                                int i8 = i7;
                                r5.h.f(aVar, "this$0");
                                aVar.q(i8);
                            }
                        });
                    }
                    int width = ((ImageView) cVar.f6340d).getWidth();
                    int r6 = r(width, i7);
                    Bitmap a7 = x4.a.a(width, r6);
                    int r7 = r(((FrameLayout) this.f6310u.f6337a).getWidth(), i7);
                    ViewGroup.LayoutParams layoutParams = ((FrameLayout) this.f6310u.f6337a).getLayoutParams();
                    r5.h.d(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    StringBuilder sb = new StringBuilder();
                    sb.append(width);
                    sb.append('-');
                    sb.append(r6);
                    sb.append('-');
                    sb.append(r7);
                    sb.append('-');
                    sb.append(marginLayoutParams.height);
                    Log.i("Item height", sb.toString());
                    marginLayoutParams.height = r7;
                    Rect rect = kVar.f6308f;
                    marginLayoutParams.setMargins(rect.left, rect.top, rect.right, rect.bottom);
                    ((FrameLayout) this.f6310u.f6337a).setLayoutParams(marginLayoutParams);
                    Log.d("PdfViewAdapter", "BEFORE    Bitmap Width: " + width + ", Device Width: " + kVar.f6307d.getResources().getDisplayMetrics().widthPixels);
                    kVar.e.a(i7, a7, new C0125a(i7, kVar, width, r6, a7, this, cVar));
                    return;
                }
            }
            ProgressBar progressBar2 = (ProgressBar) ((androidx.appcompat.widget.l) cVar.f6339c).f964g;
            r5.h.e(progressBar2, "pdfViewPageLoadingProgress");
            progressBar2.setVisibility(8);
            if (((ImageView) cVar.f6340d).getWidth() != 0) {
            }
            ((ImageView) cVar.f6340d).post(new Runnable() { // from class: v4.i
                @Override // java.lang.Runnable
                public final void run() {
                    k.a aVar = k.a.this;
                    int i8 = i7;
                    r5.h.f(aVar, "this$0");
                    aVar.q(i8);
                }
            });
        }

        public final int r(int i7, int i8) {
            Size size;
            d dVar = k.this.e;
            synchronized (dVar) {
                PdfRenderer pdfRenderer = dVar.f6275b;
                r5.h.c(pdfRenderer);
                PdfRenderer.Page openPage = pdfRenderer.openPage(i8);
                size = new Size(openPage.getWidth(), openPage.getHeight());
                openPage.close();
            }
            return (int) (i7 / (size.getWidth() / size.getHeight()));
        }
    }

    public k(Context context, d dVar, Rect rect, boolean z6) {
        r5.h.f(rect, "pageSpacing");
        this.f6307d = context;
        this.e = dVar;
        this.f6308f = rect;
        this.f6309g = z6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final int a() {
        PdfRenderer pdfRenderer = this.e.f6275b;
        if (pdfRenderer != null) {
            return pdfRenderer.getPageCount();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final void d(a aVar, int i7) {
        aVar.q(i7);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final RecyclerView.a0 e(RecyclerView recyclerView) {
        r5.h.f(recyclerView, "parent");
        View inflate = LayoutInflater.from(recyclerView.getContext()).inflate(2131492922, (ViewGroup) recyclerView, false);
        FrameLayout frameLayout = (FrameLayout) inflate;
        int i7 = 2131296695;
        View n6 = a0.e.n(inflate, 2131296695);
        if (n6 != null) {
            ProgressBar progressBar = (ProgressBar) a0.e.n(n6, 2131296710);
            if (progressBar == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(n6.getResources().getResourceName(2131296710)));
            }
            androidx.appcompat.widget.l lVar = new androidx.appcompat.widget.l((FrameLayout) n6, progressBar);
            ImageView imageView = (ImageView) a0.e.n(inflate, 2131296698);
            if (imageView != null) {
                return new a(new w0.c(frameLayout, frameLayout, lVar, imageView));
            }
            i7 = 2131296698;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i7)));
    }
}
