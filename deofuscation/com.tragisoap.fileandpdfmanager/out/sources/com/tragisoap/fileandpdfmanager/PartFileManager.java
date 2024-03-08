package com.tragisoap.fileandpdfmanager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import e5.l;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class PartFileManager extends f.d {
    public static List<HashMap<String, String>> P;
    public static List<HashMap<String, String>> Q;
    public static List<HashMap<String, String>> R;
    public static List<HashMap<String, String>> S;
    public static List<HashMap<String, String>> T;
    public static List<HashMap<String, String>> U;
    public static List<HashMap<String, String>> V;
    public static List<HashMap<String, String>> W;
    public static ProgressBar X;
    public TextView D;
    public TextView E;
    public ProgressBar F;
    public TextView G;
    public ConstraintLayout H;
    public ConstraintLayout I;
    public ConstraintLayout J;
    public ConstraintLayout K;
    public ConstraintLayout L;
    public ConstraintLayout M;
    public ConstraintLayout N;
    public ConstraintLayout O;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements Runnable {

        /* renamed from: f */
        public final /* synthetic */ View f3524f;

        /* renamed from: com.tragisoap.fileandpdfmanager.PartFileManager$a$a */
        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class RunnableC0042a implements Runnable {
            public RunnableC0042a() {
                a.this = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PartFileManager.this.startActivity(new Intent(PartFileManager.this, FileManagerItemActivity.class).putExtra("file", "image"));
            }
        }

        public a(View view) {
            PartFileManager.this = r1;
            this.f3524f = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f3524f.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150);
            new Handler().postDelayed(new RunnableC0042a(), 140);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b implements Runnable {

        /* renamed from: f */
        public final /* synthetic */ View f3527f;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements Runnable {
            public a() {
                b.this = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PartFileManager.this.startActivity(new Intent(PartFileManager.this, FileManagerItemActivity.class).putExtra("file", "video"));
            }
        }

        public b(View view) {
            PartFileManager.this = r1;
            this.f3527f = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f3527f.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150);
            new Handler().postDelayed(new a(), 140);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class c implements Runnable {

        /* renamed from: f */
        public final /* synthetic */ View f3530f;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements Runnable {
            public a() {
                c.this = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PartFileManager.this.startActivity(new Intent(PartFileManager.this, FileManagerItemActivity.class).putExtra("file", "audio"));
            }
        }

        public c(View view) {
            PartFileManager.this = r1;
            this.f3530f = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f3530f.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150);
            new Handler().postDelayed(new a(), 140);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class d implements Runnable {

        /* renamed from: f */
        public final /* synthetic */ View f3533f;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements Runnable {
            public a() {
                d.this = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PartFileManager.this.startActivity(new Intent(PartFileManager.this, FileManagerItemActivity.class).putExtra("file", "documents"));
            }
        }

        public d(View view) {
            PartFileManager.this = r1;
            this.f3533f = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f3533f.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150);
            new Handler().postDelayed(new a(), 140);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class e implements Runnable {

        /* renamed from: f */
        public final /* synthetic */ View f3536f;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements Runnable {
            public a() {
                e.this = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PartFileManager.this.startActivity(new Intent(PartFileManager.this, FileManagerItemActivity.class).putExtra("file", "apk"));
            }
        }

        public e(View view) {
            PartFileManager.this = r1;
            this.f3536f = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f3536f.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150);
            new Handler().postDelayed(new a(), 140);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class f implements Runnable {

        /* renamed from: f */
        public final /* synthetic */ View f3539f;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements Runnable {
            public a() {
                f.this = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PartFileManager.this.startActivity(new Intent(PartFileManager.this, FileManagerItemActivity.class).putExtra("file", "compress"));
            }
        }

        public f(View view) {
            PartFileManager.this = r1;
            this.f3539f = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f3539f.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150);
            new Handler().postDelayed(new a(), 140);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class g implements Runnable {

        /* renamed from: f */
        public final /* synthetic */ View f3542f;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements Runnable {
            public a() {
                g.this = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PartFileManager.this.startActivity(new Intent(PartFileManager.this, FileManagerItemActivity.class).putExtra("file", "pdf"));
            }
        }

        public g(View view) {
            PartFileManager.this = r1;
            this.f3542f = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f3542f.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150);
            new Handler().postDelayed(new a(), 140);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class h implements Runnable {

        /* renamed from: f */
        public final /* synthetic */ View f3545f;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements Runnable {
            public a() {
                h.this = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PartFileManager.this.startActivity(new Intent(PartFileManager.this, FileManagerItemActivity.class).putExtra("file", "downloads"));
            }
        }

        public h(View view) {
            PartFileManager.this = r1;
            this.f3545f = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f3545f.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150);
            new Handler().postDelayed(new a(), 140);
        }
    }

    public static String v(long j7) {
        if (j7 <= 0) {
            return "0";
        }
        double d7 = (double) j7;
        int log10 = (int) (Math.log10(d7) / Math.log10(1024.0d));
        return String.format(Locale.US, "%.2f %s", Double.valueOf(d7 / Math.pow(1024.0d, (double) log10)), new String[]{"B", "KB", "MB", "GB", "TB"}[log10]);
    }

    public void fileApk(View view) {
        if (view.getAlpha() == 1.0f) {
            view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(150).withEndAction(new e(view));
        }
    }

    public void fileAudio(View view) {
        if (view.getAlpha() == 1.0f) {
            view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(150).withEndAction(new c(view));
        }
    }

    public void fileCompress(View view) {
        if (view.getAlpha() == 1.0f) {
            view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(150).withEndAction(new f(view));
        }
    }

    public void fileDocument(View view) {
        if (view.getAlpha() == 1.0f) {
            view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(150).withEndAction(new d(view));
        }
    }

    public void fileImage(View view) {
        if (view.getAlpha() == 1.0f) {
            view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(150).withEndAction(new a(view));
        }
    }

    public void filePDF(View view) {
        if (view.getAlpha() == 1.0f) {
            view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(150).withEndAction(new g(view));
        }
    }

    public void fileVideo(View view) {
        if (view.getAlpha() == 1.0f) {
            view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(150).withEndAction(new b(view));
        }
    }

    public void folderDownload(View view) {
        if (view.getAlpha() == 1.0f) {
            view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(150).withEndAction(new h(view));
        }
    }

    @Override // androidx.fragment.app.q, androidx.activity.ComponentActivity, f1.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492894);
        this.D = (TextView) findViewById(2131296883);
        this.E = (TextView) findViewById(2131296479);
        X = (ProgressBar) findViewById(2131296726);
        this.H = (ConstraintLayout) findViewById(2131296522);
        this.I = (ConstraintLayout) findViewById(2131296900);
        this.J = (ConstraintLayout) findViewById(2131296345);
        this.K = (ConstraintLayout) findViewById(2131296443);
        this.L = (ConstraintLayout) findViewById(2131296341);
        this.M = (ConstraintLayout) findViewById(2131296396);
        this.N = (ConstraintLayout) findViewById(2131296708);
        this.O = (ConstraintLayout) findViewById(2131296445);
        this.F = (ProgressBar) findViewById(2131296732);
        this.G = (TextView) findViewById(2131296718);
        new l(this, "Images", this.F, this.G, this.H).execute(new Void[0]);
        this.F = (ProgressBar) findViewById(2131296734);
        this.G = (TextView) findViewById(2131296720);
        new l(this, "Videos", this.F, this.G, this.I).execute(new Void[0]);
        this.F = (ProgressBar) findViewById(2131296728);
        this.G = (TextView) findViewById(2131296714);
        new l(this, "Audios", this.F, this.G, this.J).execute(new Void[0]);
        this.F = (ProgressBar) findViewById(2131296730);
        this.G = (TextView) findViewById(2131296716);
        new l(this, "Documents", this.F, this.G, this.K).execute(new Void[0]);
        this.F = (ProgressBar) findViewById(2131296727);
        this.G = (TextView) findViewById(2131296713);
        new l(this, "Apk", this.F, this.G, this.L).execute(new Void[0]);
        this.F = (ProgressBar) findViewById(2131296729);
        this.G = (TextView) findViewById(2131296715);
        new l(this, "Compress", this.F, this.G, this.M).execute(new Void[0]);
        this.F = (ProgressBar) findViewById(2131296733);
        this.G = (TextView) findViewById(2131296719);
        new l(this, "PDF", this.F, this.G, this.N).execute(new Void[0]);
        this.F = (ProgressBar) findViewById(2131296731);
        this.G = (TextView) findViewById(2131296717);
        new l(this, "Downloads", this.F, this.G, this.O).execute(new Void[0]);
    }

    @Override // androidx.fragment.app.q, android.app.Activity
    public final void onResume() {
        super.onResume();
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long blockSizeLong = statFs.getBlockSizeLong();
        long availableBlocksLong = statFs.getAvailableBlocksLong();
        long blockCountLong = statFs.getBlockCountLong() * blockSizeLong;
        this.D.setText(v(blockCountLong));
        this.E.setText(v(blockCountLong - (availableBlocksLong * blockSizeLong)));
    }
}
