package com.rajat.pdfviewer;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import c0.l;
import com.rajat.pdfviewer.PdfRendererView;
import f.r;
import f5.g;
import g1.a;
import j1.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import l0.z;
import r5.h;
import r5.t;
import v4.m;
import v4.n;

/* loaded from: classes.dex */
public final class PdfViewerActivity extends f.d {
    public static boolean U;
    public static boolean V;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public String L;
    public String M;
    public String N;
    public String O;
    public v4.a P;
    public w4.a Q;
    public String R;
    public final androidx.activity.result.d S;
    public final androidx.activity.result.d T;

    /* loaded from: classes.dex */
    public static final class a implements PdfRendererView.a {
        public a() {
            PdfViewerActivity.this = r1;
        }

        @Override // com.rajat.pdfviewer.PdfRendererView.a
        public final void a(String str) {
            PdfViewerActivity pdfViewerActivity = PdfViewerActivity.this;
            pdfViewerActivity.runOnUiThread(new r(pdfViewerActivity, 2, str));
        }

        @Override // com.rajat.pdfviewer.PdfRendererView.a
        public final void b(Exception exc) {
            h.f(exc, "error");
            PdfViewerActivity pdfViewerActivity = PdfViewerActivity.this;
            pdfViewerActivity.runOnUiThread(new f2.c(pdfViewerActivity, 1, exc));
        }

        @Override // com.rajat.pdfviewer.PdfRendererView.a
        public final void c() {
            PdfViewerActivity pdfViewerActivity = PdfViewerActivity.this;
            pdfViewerActivity.runOnUiThread(new m(pdfViewerActivity, 1));
        }

        @Override // com.rajat.pdfviewer.PdfRendererView.a
        public final void d() {
        }

        @Override // com.rajat.pdfviewer.PdfRendererView.a
        public final void e() {
        }
    }

    static {
        x4.b[] bVarArr = x4.b.f6470g;
        V = true;
    }

    public PdfViewerActivity() {
        t.a(n.class);
        this.S = p(new l(this), new d.c());
        this.T = p(new c0.m(this), new d.d());
    }

    public static void v(PdfViewerActivity pdfViewerActivity) {
        h.f(pdfViewerActivity, "this$0");
        pdfViewerActivity.x();
    }

    public static final void w(PdfViewerActivity pdfViewerActivity, boolean z6) {
        w4.a aVar = pdfViewerActivity.Q;
        if (aVar != null) {
            aVar.e.setVisibility(z6 ? 0 : 8);
        } else {
            h.k("binding");
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:164:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void x() {
        /*
            r8 = this;
            android.content.Intent r0 = r8.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            r5.h.c(r0)
            java.lang.String r1 = "pdf_file_url"
            boolean r0 = r0.containsKey(r1)
            r2 = 0
            java.lang.String r3 = "binding"
            if (r0 == 0) goto Lab
            android.content.Intent r0 = r8.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            r5.h.c(r0)
            java.lang.String r0 = r0.getString(r1)
            r8.O = r0
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r8.getSystemService(r0)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            r1 = 1
            r4 = 0
            if (r0 == 0) goto L56
            android.net.Network r5 = r0.getActiveNetwork()
            android.net.NetworkCapabilities r0 = r0.getNetworkCapabilities(r5)
            if (r0 == 0) goto L56
            boolean r5 = r0.hasTransport(r1)
            if (r5 == 0) goto L45
            r0 = 2
            goto L57
        L45:
            boolean r5 = r0.hasTransport(r4)
            if (r5 == 0) goto L4d
            r0 = r1
            goto L57
        L4d:
            r5 = 4
            boolean r0 = r0.hasTransport(r5)
            if (r0 == 0) goto L56
            r0 = 3
            goto L57
        L56:
            r0 = r4
        L57:
            if (r0 == 0) goto L5a
            goto L5b
        L5a:
            r1 = r4
        L5b:
            if (r1 == 0) goto L99
            java.lang.String r0 = r8.O
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L6a
            java.lang.String r1 = ""
            r8.y(r1)
        L6a:
            w4.a r1 = r8.Q     // Catch: java.lang.Exception -> L90
            if (r1 == 0) goto L8c
            com.rajat.pdfviewer.PdfRendererView r1 = r1.f6410d     // Catch: java.lang.Exception -> L90
            r5.h.c(r0)     // Catch: java.lang.Exception -> L90
            v4.a r4 = r8.P     // Catch: java.lang.Exception -> L90
            if (r4 == 0) goto L86
            androidx.lifecycle.LifecycleCoroutineScopeImpl r5 = a0.e.p(r8)     // Catch: java.lang.Exception -> L90
            androidx.lifecycle.o r6 = r8.f358i     // Catch: java.lang.Exception -> L90
            java.lang.String r7 = "<get-lifecycle>(...)"
            r5.h.e(r6, r7)     // Catch: java.lang.Exception -> L90
            r1.a(r0, r4, r5, r6)     // Catch: java.lang.Exception -> L90
            goto Lab
        L86:
            java.lang.String r0 = "headers"
            r5.h.k(r0)     // Catch: java.lang.Exception -> L90
            throw r2     // Catch: java.lang.Exception -> L90
        L8c:
            r5.h.k(r3)     // Catch: java.lang.Exception -> L90
            throw r2     // Catch: java.lang.Exception -> L90
        L90:
            r0 = move-exception
            java.lang.String r0 = r0.toString()
            r8.y(r0)
            goto Lab
        L99:
            java.lang.String r0 = r8.G
            if (r0 == 0) goto La5
            android.widget.Toast r0 = android.widget.Toast.makeText(r8, r0, r4)
            r0.show()
            goto Lab
        La5:
            java.lang.String r8 = "error_no_internet_connection"
            r5.h.k(r8)
            throw r2
        Lab:
            w4.a r0 = r8.Q
            if (r0 == 0) goto Lba
            com.rajat.pdfviewer.PdfRendererView r0 = r0.f6410d
            com.rajat.pdfviewer.PdfViewerActivity$a r1 = new com.rajat.pdfviewer.PdfViewerActivity$a
            r1.<init>()
            r0.setStatusListener(r1)
            return
        Lba:
            r5.h.k(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rajat.pdfviewer.PdfViewerActivity.x():void");
    }

    @Override // androidx.fragment.app.q, androidx.activity.ComponentActivity, f1.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w4.a b2 = w4.a.b(getLayoutInflater());
        this.Q = b2;
        setContentView(b2.a());
        TypedArray obtainStyledAttributes = getTheme().obtainStyledAttributes(z.J);
        h.e(obtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            boolean z6 = obtainStyledAttributes.getBoolean(4, true);
            Drawable drawable = obtainStyledAttributes.getDrawable(1);
            obtainStyledAttributes.getColor(3, -1);
            int color = obtainStyledAttributes.getColor(0, -1);
            int resourceId = obtainStyledAttributes.getResourceId(5, -1);
            w4.a aVar = this.Q;
            if (aVar == null) {
                h.k("binding");
                throw null;
            }
            aVar.f6408b.setVisibility(z6 ? 0 : 8);
            w4.a aVar2 = this.Q;
            if (aVar2 == null) {
                h.k("binding");
                throw null;
            }
            aVar2.f6408b.setNavigationIcon(drawable);
            if (resourceId != -1) {
                w4.a aVar3 = this.Q;
                if (aVar3 == null) {
                    h.k("binding");
                    throw null;
                }
                View findViewById = aVar3.f6408b.findViewById(2131296893);
                h.d(findViewById, "null cannot be cast to non-null type android.widget.TextView");
                ((TextView) findViewById).setTextAppearance(this, resourceId);
            }
            if (color != -1) {
                w4.a aVar4 = this.Q;
                if (aVar4 == null) {
                    h.k("binding");
                    throw null;
                }
                aVar4.f6408b.setBackgroundColor(color);
            }
            obtainStyledAttributes.recycle();
            Bundle extras = getIntent().getExtras();
            h.c(extras);
            String string = extras.getString("pdf_file_title", "PDF");
            h.e(string, "getString(...)");
            w4.a aVar5 = this.Q;
            if (aVar5 == null) {
                h.k("binding");
                throw null;
            }
            s().x(aVar5.f6408b);
            f.a t5 = t();
            if (t5 != null) {
                t5.m(true);
                t5.n();
                w4.a aVar6 = this.Q;
                if (aVar6 == null) {
                    h.k("binding");
                    throw null;
                }
                View findViewById2 = aVar6.f6408b.findViewById(2131296893);
                h.d(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
                ((TextView) findViewById2).setText(string);
                t5.o();
            }
            obtainStyledAttributes = getTheme().obtainStyledAttributes(z.H);
            h.e(obtainStyledAttributes, "obtainStyledAttributes(...)");
            try {
                int color2 = obtainStyledAttributes.getColor(0, g1.a.b(getApplicationContext()));
                w4.a aVar7 = this.Q;
                if (aVar7 == null) {
                    h.k("binding");
                    throw null;
                }
                aVar7.f6409c.setBackgroundColor(color2);
                int resourceId2 = obtainStyledAttributes.getResourceId(10, -1);
                if (resourceId2 != -1) {
                    Drawable d7 = g1.a.d(this, resourceId2);
                    w4.a aVar8 = this.Q;
                    if (aVar8 == null) {
                        h.k("binding");
                        throw null;
                    }
                    aVar8.e.setIndeterminateDrawable(d7);
                }
                obtainStyledAttributes.recycle();
                Bundle extras2 = getIntent().getExtras();
                h.c(extras2);
                U = extras2.getBoolean("enable_download", false);
                v4.a aVar9 = (v4.a) (Build.VERSION.SDK_INT >= 33 ? getIntent().getParcelableExtra("headers", v4.a.class) : getIntent().getParcelableExtra("headers"));
                if (aVar9 != null) {
                    this.P = aVar9;
                }
                Bundle extras3 = getIntent().getExtras();
                h.c(extras3);
                extras3.getBoolean("from_assests", false);
                x4.b[] bVarArr = x4.b.f6470g;
                TypedArray obtainStyledAttributes2 = obtainStyledAttributes(z.I);
                h.e(obtainStyledAttributes2, "obtainStyledAttributes(...)");
                String string2 = obtainStyledAttributes2.getString(1);
                if (string2 == null) {
                    string2 = getString(2131820603);
                    h.e(string2, "getString(...)");
                }
                this.J = string2;
                String string3 = obtainStyledAttributes2.getString(0);
                if (string3 == null) {
                    string3 = getString(2131820602);
                    h.e(string3, "getString(...)");
                }
                this.G = string3;
                String string4 = obtainStyledAttributes2.getString(3);
                if (string4 == null) {
                    string4 = getString(2131820608);
                    h.e(string4, "getString(...)");
                }
                this.F = string4;
                String string5 = obtainStyledAttributes2.getString(4);
                if (string5 == null) {
                    string5 = getString(2131820609);
                    h.e(string5, "getString(...)");
                }
                this.E = string5;
                String string6 = obtainStyledAttributes2.getString(2);
                if (string6 == null) {
                    string6 = getString(2131820607);
                    h.e(string6, "getString(...)");
                }
                this.D = string6;
                String string7 = obtainStyledAttributes2.getString(9);
                if (string7 == null) {
                    string7 = getString(2131820730);
                    h.e(string7, "getString(...)");
                }
                this.H = string7;
                String string8 = obtainStyledAttributes2.getString(10);
                if (string8 == null) {
                    string8 = getString(2131820731);
                    h.e(string8, "getString(...)");
                }
                this.I = string8;
                String string9 = obtainStyledAttributes2.getString(6);
                if (string9 == null) {
                    string9 = getString(2131820727);
                    h.e(string9, "getString(...)");
                }
                this.N = string9;
                String string10 = obtainStyledAttributes2.getString(8);
                if (string10 == null) {
                    string10 = getString(2131820729);
                    h.e(string10, "getString(...)");
                }
                this.K = string10;
                String string11 = obtainStyledAttributes2.getString(5);
                if (string11 == null) {
                    string11 = getString(2131820726);
                    h.e(string11, "getString(...)");
                }
                this.M = string11;
                String string12 = obtainStyledAttributes2.getString(7);
                if (string12 == null) {
                    string12 = getString(2131820728);
                    h.e(string12, "getString(...)");
                }
                this.L = string12;
                x();
            } finally {
            }
        } finally {
        }
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        h.f(menu, "menu");
        MenuInflater menuInflater = getMenuInflater();
        h.e(menuInflater, "getMenuInflater(...)");
        menuInflater.inflate(2131623936, menu);
        MenuItem findItem = menu.findItem(2131296444);
        TypedArray obtainStyledAttributes = getTheme().obtainStyledAttributes(z.J);
        h.e(obtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            Context applicationContext = getApplicationContext();
            Object obj = g1.a.f4192a;
            int color = obtainStyledAttributes.getColor(3, a.d.a(applicationContext, 17170443));
            Drawable icon = findItem.getIcon();
            if (icon != null) {
                Drawable mutate = icon.mutate();
                h.e(mutate, "mutate(...)");
                a.b.g(mutate, color);
                findItem.setIcon(mutate);
            }
            obtainStyledAttributes.recycle();
            findItem.setVisible(U);
            return true;
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // f.d, androidx.fragment.app.q, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        w4.a aVar = this.Q;
        if (aVar == null) {
            h.k("binding");
            throw null;
        }
        PdfRendererView pdfRendererView = aVar.f6410d;
        if (pdfRendererView.f3460n) {
            v4.d dVar = pdfRendererView.f3455h;
            if (dVar == null) {
                h.k("pdfRendererCore");
                throw null;
            }
            PdfRenderer pdfRenderer = dVar.f6275b;
            if (pdfRenderer != null) {
                pdfRenderer.close();
            }
            File file = new File(dVar.f6274a.getCacheDir(), "___pdf___cache___");
            if (file.exists()) {
                p5.c.O(file);
            }
            pdfRendererView.f3460n = false;
        }
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        h.f(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == 2131296444) {
            z();
            return true;
        } else if (itemId == 16908332) {
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(menuItem);
        }
    }

    public final void y(String str) {
        Log.e("Pdf render error", str);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String str2 = this.N;
        if (str2 == null) {
            h.k("pdf_viewer_error");
            throw null;
        }
        AlertDialog.Builder title = builder.setTitle(str2);
        String str3 = this.J;
        if (str3 == null) {
            h.k("error_pdf_corrupted");
            throw null;
        }
        AlertDialog.Builder message = title.setMessage(str3);
        String str4 = this.K;
        if (str4 == null) {
            h.k("pdf_viewer_retry");
            throw null;
        }
        AlertDialog.Builder positiveButton = message.setPositiveButton(str4, new v4.l(this, 0));
        String str5 = this.M;
        if (str5 != null) {
            positiveButton.setNegativeButton(str5, (DialogInterface.OnClickListener) null).show();
        } else {
            h.k("pdf_viewer_cancel");
            throw null;
        }
    }

    public final void z() {
        g gVar;
        String stringExtra = getIntent().getStringExtra("pdf_file_title");
        if (stringExtra == null) {
            stringExtra = "downloaded_file.pdf";
        }
        String str = this.R;
        if (str != null) {
            if (V) {
                ContentResolver contentResolver = getApplicationContext().getContentResolver();
                h.c(contentResolver);
                ContentValues contentValues = new ContentValues();
                contentValues.put("_display_name", stringExtra);
                contentValues.put("mime_type", "application/pdf");
                contentValues.put("relative_path", Environment.DIRECTORY_DOCUMENTS);
                Uri insert = contentResolver.insert(MediaStore.Files.getContentUri("external"), contentValues);
                if (insert == null) {
                    throw new IOException("Failed to create new MediaStore record.");
                }
                OutputStream openOutputStream = contentResolver.openOutputStream(insert);
                if (openOutputStream != null) {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(new File(str));
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read < 0) {
                                break;
                            }
                            openOutputStream.write(bArr, 0, read);
                        }
                        q2.a.l(openOutputStream, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            q2.a.l(openOutputStream, th);
                            throw th2;
                        }
                    }
                }
                String str2 = this.E;
                if (str2 == null) {
                    h.k("file_saved_to_downloads");
                    throw null;
                }
                Toast.makeText(this, str2, 0).show();
            } else {
                Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("application/pdf");
                intent.putExtra("android.intent.extra.TITLE", stringExtra);
                this.T.p(intent);
            }
            gVar = g.f4141a;
        } else {
            gVar = null;
        }
        if (gVar == null) {
            String str3 = this.D;
            if (str3 != null) {
                Toast.makeText(this, str3, 0).show();
            } else {
                h.k("file_not_downloaded_yet");
                throw null;
            }
        }
    }
}
