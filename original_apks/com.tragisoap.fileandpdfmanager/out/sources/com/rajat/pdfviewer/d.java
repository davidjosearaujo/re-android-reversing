package com.rajat.pdfviewer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.c;
import androidx.recyclerview.widget.i;
import com.rajat.pdfviewer.PdfRendererView;
import com.rajat.pdfviewer.b;
import java.io.File;
import r5.h;
import v4.k;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d implements b.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PdfRendererView f3493a;

    public d(PdfRendererView pdfRendererView) {
        this.f3493a = pdfRendererView;
    }

    @Override // com.rajat.pdfviewer.b.a
    public final Context a() {
        Context context = this.f3493a.getContext();
        h.e(context, "getContext(...)");
        return context;
    }

    @Override // com.rajat.pdfviewer.b.a
    public final void b(Exception exc) {
        h.f(exc, "error");
        exc.printStackTrace();
        PdfRendererView.a statusListener = this.f3493a.getStatusListener();
        if (statusListener != null) {
            statusListener.b(exc);
        }
    }

    @Override // com.rajat.pdfviewer.b.a
    public final void c(long j7, long j8) {
        PdfRendererView.a statusListener = this.f3493a.getStatusListener();
        if (statusListener != null) {
            statusListener.d();
        }
    }

    @Override // com.rajat.pdfviewer.b.a
    public final void d(String str) {
        PdfRendererView pdfRendererView = this.f3493a;
        File file = new File(str);
        Context context = pdfRendererView.getContext();
        h.e(context, "getContext(...)");
        pdfRendererView.f3455h = new v4.d(context, file);
        pdfRendererView.f3460n = true;
        Context context2 = pdfRendererView.getContext();
        h.e(context2, "getContext(...)");
        v4.d dVar = pdfRendererView.f3455h;
        if (dVar != null) {
            pdfRendererView.f3456i = new k(context2, dVar, pdfRendererView.f3461o, pdfRendererView.m);
            pdfRendererView.addView(LayoutInflater.from(pdfRendererView.getContext()).inflate(2131492982, (ViewGroup) pdfRendererView, false));
            View findViewById = pdfRendererView.findViewById(2131296742);
            h.e(findViewById, "findViewById(...)");
            pdfRendererView.setRecyclerView((RecyclerView) findViewById);
            View findViewById2 = pdfRendererView.findViewById(2131296697);
            h.e(findViewById2, "findViewById(...)");
            pdfRendererView.f3454g = (TextView) findViewById2;
            RecyclerView recyclerView = pdfRendererView.getRecyclerView();
            k kVar = pdfRendererView.f3456i;
            if (kVar != null) {
                recyclerView.setAdapter(kVar);
                recyclerView.getContext();
                recyclerView.setLayoutManager(new LinearLayoutManager(1));
                recyclerView.setItemAnimator(new c());
                if (pdfRendererView.f3457j) {
                    i iVar = new i(recyclerView.getContext());
                    Drawable drawable = pdfRendererView.f3458k;
                    if (drawable != null) {
                        iVar.f2208a = drawable;
                    }
                    recyclerView.i(iVar);
                }
                recyclerView.j(pdfRendererView.s);
                new Handler(Looper.getMainLooper()).postDelayed(new v4.h(pdfRendererView, 0), 300);
                pdfRendererView.f3459l = new androidx.activity.d(13, pdfRendererView);
                PdfRendererView.a statusListener = this.f3493a.getStatusListener();
                if (statusListener != null) {
                    statusListener.a(str);
                    return;
                }
                return;
            }
            h.k("pdfViewAdapter");
            throw null;
        }
        h.k("pdfRendererCore");
        throw null;
    }

    @Override // com.rajat.pdfviewer.b.a
    public final void e() {
        PdfRendererView.a statusListener = this.f3493a.getStatusListener();
        if (statusListener != null) {
            statusListener.c();
        }
    }
}
