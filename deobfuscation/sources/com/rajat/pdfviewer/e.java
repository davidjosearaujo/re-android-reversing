package com.rajat.pdfviewer;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.rajat.pdfviewer.PdfRendererView;
import r5.h;

/* loaded from: classes.dex */
public final class e extends RecyclerView.p {

    /* renamed from: a */
    public int f3494a = -1;

    /* renamed from: b */
    public int f3495b = -1;

    /* renamed from: c */
    public final /* synthetic */ PdfRendererView f3496c;

    /* renamed from: d */
    public final /* synthetic */ Context f3497d;

    public e(PdfRendererView pdfRendererView, Context context) {
        this.f3496c = pdfRendererView;
        this.f3497d = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public final void a(RecyclerView recyclerView, int i7) {
        h.f(recyclerView, "recyclerView");
        PdfRendererView pdfRendererView = this.f3496c;
        if (i7 == 0) {
            TextView textView = pdfRendererView.f3454g;
            if (textView != null) {
                textView.postDelayed(pdfRendererView.f3459l, 3000L);
                return;
            } else {
                h.k("pageNo");
                throw null;
            }
        }
        TextView textView2 = pdfRendererView.f3454g;
        if (textView2 != null) {
            textView2.removeCallbacks(pdfRendererView.f3459l);
        } else {
            h.k("pageNo");
            throw null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public final void b(RecyclerView recyclerView, int i7, int i8) {
        h.f(recyclerView, "recyclerView");
        RecyclerView.l layoutManager = recyclerView.getLayoutManager();
        h.d(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int L0 = linearLayoutManager.L0();
        View O0 = linearLayoutManager.O0(0, linearLayoutManager.w(), true, false);
        int G = O0 == null ? -1 : RecyclerView.l.G(O0);
        if (!((L0 == this.f3494a && G == this.f3495b) ? false : true)) {
            this.f3496c.f3463q = L0;
            return;
        }
        int i9 = G != -1 ? G : L0;
        PdfRendererView pdfRendererView = this.f3496c;
        pdfRendererView.f3463q = i9;
        if (i9 != -1) {
            TextView textView = pdfRendererView.f3454g;
            if (textView == null) {
                h.k("pageNo");
                throw null;
            }
            textView.setText(this.f3497d.getString(2131820725, Integer.valueOf(i9 + 1), Integer.valueOf(this.f3496c.getTotalPageCount())));
            TextView textView2 = this.f3496c.f3454g;
            if (textView2 == null) {
                h.k("pageNo");
                throw null;
            }
            textView2.setVisibility(0);
            if (i9 == 0) {
                PdfRendererView pdfRendererView2 = this.f3496c;
                TextView textView3 = pdfRendererView2.f3454g;
                if (textView3 == null) {
                    h.k("pageNo");
                    throw null;
                }
                textView3.postDelayed(new v4.h(pdfRendererView2, 1), 3000L);
            }
            PdfRendererView.a statusListener = this.f3496c.getStatusListener();
            if (statusListener != null) {
                this.f3496c.getTotalPageCount();
                statusListener.e();
            }
        }
        this.f3494a = L0;
        this.f3495b = G;
    }
}
