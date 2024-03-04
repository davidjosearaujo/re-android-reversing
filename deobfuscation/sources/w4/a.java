package w4;

import a0.e;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.rajat.pdfviewer.PdfRendererView;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public final LinearLayout f6407a;

    /* renamed from: b */
    public final Toolbar f6408b;

    /* renamed from: c */
    public final LinearLayout f6409c;

    /* renamed from: d */
    public final PdfRendererView f6410d;
    public final ProgressBar e;

    public a(LinearLayout linearLayout, Toolbar toolbar, LinearLayout linearLayout2, PdfRendererView pdfRendererView, ProgressBar progressBar) {
        this.f6407a = linearLayout;
        this.f6408b = toolbar;
        this.f6409c = linearLayout2;
        this.f6410d = pdfRendererView;
        this.e = progressBar;
    }

    public static a b(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(2131492896, (ViewGroup) null, false);
        int i7 = 2131296593;
        if (((FrameLayout) e.n(inflate, 2131296593)) != null) {
            i7 = 2131296653;
            Toolbar toolbar = (Toolbar) e.n(inflate, 2131296653);
            if (toolbar != null) {
                LinearLayout linearLayout = (LinearLayout) inflate;
                i7 = 2131296709;
                PdfRendererView pdfRendererView = (PdfRendererView) e.n(inflate, 2131296709);
                if (pdfRendererView != null) {
                    i7 = 2131296726;
                    ProgressBar progressBar = (ProgressBar) e.n(inflate, 2131296726);
                    if (progressBar != null) {
                        i7 = 2131296893;
                        if (((TextView) e.n(inflate, 2131296893)) != null) {
                            return new a(linearLayout, toolbar, linearLayout, pdfRendererView, progressBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i7)));
    }

    public final LinearLayout a() {
        return this.f6407a;
    }
}
