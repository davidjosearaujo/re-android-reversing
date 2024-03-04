package com.tragisoap.fileandpdfmanager;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import g1.a;
import java.util.Objects;

/* loaded from: classes.dex */
public class MainActivity extends f.d {

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: f */
        public final /* synthetic */ Dialog f3514f;

        public a(Dialog dialog) {
            MainActivity.this = r1;
            this.f3514f = dialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f3514f.cancel();
            MainActivity mainActivity = MainActivity.this;
            try {
                Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(String.format("package:%s", mainActivity.getPackageName())));
                mainActivity.startActivityForResult(intent, 15);
            } catch (Exception unused) {
                Intent intent2 = new Intent();
                intent2.setAction("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
                mainActivity.startActivityForResult(intent2, 15);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {

        /* renamed from: f */
        public final /* synthetic */ Dialog f3516f;

        public b(Dialog dialog) {
            MainActivity.this = r1;
            this.f3516f = dialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f3516f.cancel();
            MainActivity.this.finishAffinity();
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: f */
        public final /* synthetic */ View f3518f;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
                c.this = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.startActivity(new Intent(MainActivity.this, PartFileManager.class), f1.b.a(MainActivity.this, new o1.c[0]).b());
            }
        }

        public c(View view) {
            MainActivity.this = r1;
            this.f3518f = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f3518f.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150L);
            new Handler().postDelayed(new a(), 140L);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: f */
        public final /* synthetic */ View f3521f;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
                d.this = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.startActivity(new Intent(MainActivity.this, FileManagerItemActivity.class).putExtra("file", "pdfmanager"), f1.b.a(MainActivity.this, new o1.c[0]).b());
            }
        }

        public d(View view) {
            MainActivity.this = r1;
            this.f3521f = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f3521f.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150L);
            new Handler().postDelayed(new a(), 140L);
        }
    }

    @Override // androidx.fragment.app.q, androidx.activity.ComponentActivity, f1.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492893);
        if (!Environment.isExternalStorageManager()) {
            Dialog dialog = new Dialog(this);
            Window window = dialog.getWindow();
            Objects.requireNonNull(window);
            window.setBackgroundDrawableResource(17170445);
            View inflate = getLayoutInflater().inflate(2131492916, (ViewGroup) null);
            dialog.setContentView(inflate);
            dialog.setCanceledOnTouchOutside(false);
            ((Button) inflate.findViewById(2131296368)).setOnClickListener(new a(dialog));
            ((Button) inflate.findViewById(2131296469)).setOnClickListener(new b(dialog));
            dialog.show();
        }
        Window window2 = getWindow();
        Object obj = g1.a.f4192a;
        window2.setStatusBarColor(a.d.a(this, 2131034146));
        CircularProgressBar circularProgressBar = (CircularProgressBar) findViewById(2131296736);
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long blockSizeLong = statFs.getBlockSizeLong();
        long availableBlocksLong = statFs.getAvailableBlocksLong();
        long blockCountLong = statFs.getBlockCountLong() * blockSizeLong;
        int i7 = (int) (((blockCountLong - (availableBlocksLong * blockSizeLong)) * 100) / blockCountLong);
        ((TextView) findViewById(2131296844)).setText(i7 + "%");
        circularProgressBar.getClass();
        CircularProgressBar.h(circularProgressBar, (float) i7, 1300L, 12);
    }

    public void partFileManager(View view) {
        view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(150L).withEndAction(new c(view));
    }

    public void partPDFManager(View view) {
        view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(150L).withEndAction(new d(view));
    }
}
