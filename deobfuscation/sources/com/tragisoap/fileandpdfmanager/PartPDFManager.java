package com.tragisoap.fileandpdfmanager;

import a0.e;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import androidx.lifecycle.o;
import com.rajat.pdfviewer.PdfRendererView;
import f.d;
import g1.a;
import java.io.File;
import r5.h;

/* loaded from: classes.dex */
public final class PartPDFManager extends d {
    public PdfRendererView D;
    public TextView E;

    @Override // androidx.fragment.app.q, androidx.activity.ComponentActivity, f1.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(2131492895);
        this.D = (PdfRendererView) findViewById(2131296709);
        View findViewById = findViewById(2131296847);
        h.e(findViewById, "findViewById(...)");
        this.E = (TextView) findViewById;
        Window window = getWindow();
        Object obj = a.f4192a;
        window.setStatusBarColor(a.d.a(this, 2131034224));
        if (this.D != null) {
            String stringExtra = getIntent().getStringExtra("pdfPath");
            File file = new File(stringExtra);
            TextView textView = this.E;
            if (textView == null) {
                h.k("header");
                throw null;
            }
            textView.setText(file.getName());
            if (file.exists()) {
                String uri = file.toURI().toString();
                h.e(uri, "toString(...)");
                if (stringExtra == null) {
                    Log.e("Error", "File does not exist");
                    return;
                }
                PdfRendererView pdfRendererView = this.D;
                h.c(pdfRendererView);
                LifecycleCoroutineScopeImpl p6 = e.p(this);
                o oVar = this.f358i;
                h.e(oVar, "<get-lifecycle>(...)");
                int i7 = PdfRendererView.f3452t;
                pdfRendererView.a(uri, new v4.a(0), p6, oVar);
                return;
            }
            str = "PDF path is null";
        } else {
            str = "PdfRendererView not found in layout";
        }
        Toast.makeText(this, str, 0).show();
    }
}
