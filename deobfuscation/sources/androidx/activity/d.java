package androidx.activity;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Environment;
import android.os.StatFs;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.e1;
import androidx.emoji2.text.f;
import androidx.emoji2.text.l;
import com.davemorrissey.labs.subscaleview.R;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import com.rajat.pdfviewer.PdfRendererView;
import com.tragisoap.fileandpdfmanager.PartFileManager;
import java.nio.MappedByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import linc.com.amplituda.ErrorCode;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: f */
    public final /* synthetic */ int f407f;

    /* renamed from: g */
    public final /* synthetic */ Object f408g;

    public /* synthetic */ d(int i7, Object obj) {
        this.f407f = i7;
        this.f408g = obj;
    }

    private final void a() {
        l.b bVar = (l.b) this.f408g;
        synchronized (bVar.f1549d) {
            if (bVar.f1552h == null) {
                return;
            }
            try {
                m1.m d7 = bVar.d();
                int i7 = d7.e;
                if (i7 == 2) {
                    synchronized (bVar.f1549d) {
                    }
                }
                if (i7 != 0) {
                    throw new RuntimeException("fetchFonts result is not OK. (" + i7 + ")");
                }
                l1.h.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                l.a aVar = bVar.f1548c;
                Context context = bVar.f1546a;
                aVar.getClass();
                Typeface a7 = i1.e.a(context, new m1.m[]{d7}, 0);
                MappedByteBuffer a8 = i1.h.a(bVar.f1546a, d7.f5068a);
                if (a8 == null || a7 == null) {
                    throw new RuntimeException("Unable to open file.");
                }
                l1.h.a("EmojiCompat.MetadataRepo.create");
                androidx.emoji2.text.n nVar = new androidx.emoji2.text.n(a7, androidx.emoji2.text.m.a(a8));
                l1.h.b();
                l1.h.b();
                synchronized (bVar.f1549d) {
                    f.h hVar = bVar.f1552h;
                    if (hVar != null) {
                        hVar.b(nVar);
                    }
                }
                bVar.b();
            } catch (Throwable th) {
                synchronized (bVar.f1549d) {
                    f.h hVar2 = bVar.f1552h;
                    if (hVar2 != null) {
                        hVar2.a(th);
                    }
                    bVar.b();
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f407f) {
            case 0:
                ((ComponentActivity) this.f408g).invalidateOptionsMenu();
                return;
            case 1:
                ComponentActivity.e eVar = (ComponentActivity.e) this.f408g;
                Runnable runnable = eVar.f379g;
                if (runnable != null) {
                    runnable.run();
                    eVar.f379g = null;
                    return;
                }
                return;
            case 2:
            case 6:
            default:
                e5.l lVar = (e5.l) this.f408g;
                int i7 = e5.l.f3826g;
                lVar.getClass();
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                double totalBytes = (lVar.f3829c / (statFs.getTotalBytes() - statFs.getFreeBytes())) * 100.0d;
                lVar.f3830d.setAlpha(1.0f);
                TextView textView = lVar.f3831f;
                textView.setText(Math.round(totalBytes) + "%");
                lVar.e.setProgress((int) Math.round(totalBytes), true);
                PartFileManager.X.setVisibility(8);
                return;
            case 3:
                ((Toolbar) this.f408g).l();
                return;
            case 4:
                ((e1) this.f408g).a();
                throw null;
            case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                q5.a aVar = (q5.a) this.f408g;
                r5.h.f(aVar, "$tmp0");
                aVar.d();
                return;
            case 7:
                a();
                return;
            case 8:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new f.f((Context) this.f408g, 1));
                return;
            case 9:
                ((CarouselLayoutManager) this.f408g).W0();
                return;
            case ErrorCode.FRAME_ALLOC_CODE /* 10 */:
                SideSheetBehavior.d dVar = (SideSheetBehavior.d) this.f408g;
                dVar.f3250b = false;
                x1.c cVar = dVar.f3252d.f3234n;
                if (cVar != null && cVar.g()) {
                    dVar.a(dVar.f3249a);
                    return;
                }
                SideSheetBehavior sideSheetBehavior = dVar.f3252d;
                if (sideSheetBehavior.m == 2) {
                    sideSheetBehavior.y(dVar.f3249a);
                    return;
                }
                return;
            case ErrorCode.PACKET_ALLOC_CODE /* 11 */:
                o4.l lVar2 = (o4.l) this.f408g;
                boolean isPopupShowing = lVar2.f5354h.isPopupShowing();
                lVar2.t(isPopupShowing);
                lVar2.m = isPopupShowing;
                return;
            case ErrorCode.CODEC_CONTEXT_ALLOC_CODE /* 12 */:
                ((TextInputLayout) this.f408g).f3280i.requestLayout();
                return;
            case 13:
                PdfRendererView pdfRendererView = (PdfRendererView) this.f408g;
                int i8 = PdfRendererView.f3452t;
                r5.h.f(pdfRendererView, "this$0");
                TextView textView2 = pdfRendererView.f3454g;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    return;
                } else {
                    r5.h.k("pageNo");
                    throw null;
                }
        }
    }
}
