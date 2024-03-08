package com.tragisoap.fileandpdfmanager;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.davemorrissey.labs.subscaleview.R;
import e5.p;
import e5.q;
import e5.v;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class FileManagerItemActivity extends f.d {
    public static TextView M;
    public static TextView N;
    public static LinearLayout O;
    public ImageView D;
    public TextView E;
    public RecyclerView F;
    public LinearLayout G;
    public p H;
    public v I;
    public e5.g J;
    public e5.k K;
    public List<HashMap<String, String>> L = new ArrayList();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: f */
        public final /* synthetic */ Dialog f3498f;

        public a(Dialog dialog) {
            FileManagerItemActivity.this = r1;
            this.f3498f = dialog;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            char c7;
            RecyclerView.d dVar;
            boolean z6;
            String str;
            boolean z7;
            String str2;
            boolean z8;
            String str3;
            this.f3498f.cancel();
            String str4 = FileManagerItemActivity.this.getIntent().getStringExtra("file").toString();
            str4.getClass();
            switch (str4.hashCode()) {
                case -599266462:
                    if (str4.equals("compress")) {
                        c7 = 0;
                        break;
                    }
                    c7 = 65535;
                    break;
                case 96796:
                    if (str4.equals("apk")) {
                        c7 = 1;
                        break;
                    }
                    c7 = 65535;
                    break;
                case 110834:
                    if (str4.equals("pdf")) {
                        c7 = 2;
                        break;
                    }
                    c7 = 65535;
                    break;
                case 93166550:
                    if (str4.equals("audio")) {
                        c7 = 3;
                        break;
                    }
                    c7 = 65535;
                    break;
                case 100313435:
                    if (str4.equals("image")) {
                        c7 = 4;
                        break;
                    }
                    c7 = 65535;
                    break;
                case 112202875:
                    if (str4.equals("video")) {
                        c7 = 5;
                        break;
                    }
                    c7 = 65535;
                    break;
                case 943542968:
                    if (str4.equals("documents")) {
                        c7 = 6;
                        break;
                    }
                    c7 = 65535;
                    break;
                case 1312704747:
                    if (str4.equals("downloads")) {
                        c7 = 7;
                        break;
                    }
                    c7 = 65535;
                    break;
                case 1616759419:
                    if (str4.equals("pdfmanager")) {
                        c7 = '\b';
                        break;
                    }
                    c7 = 65535;
                    break;
                default:
                    c7 = 65535;
                    break;
            }
            String str5 = "col2Date";
            String str6 = "col2Size";
            String str7 = "col2Name";
            String str8 = "col1";
            String str9 = "";
            String str10 = "mediaPath";
            switch (c7) {
                case 0:
                case 1:
                case 2:
                case 6:
                case 7:
                case '\b':
                    String str11 = str5;
                    String str12 = str7;
                    String str13 = str8;
                    String str14 = str9;
                    boolean z9 = true;
                    for (int i7 = 0; i7 < e5.k.f3817f.size(); i7++) {
                        HashMap hashMap = new HashMap();
                        boolean z10 = z9;
                        if (Boolean.TRUE.equals(((Map) e5.k.f3818g.get(i7)).get(str13))) {
                            str13 = str13;
                            Path path = Paths.get((String) ((HashMap) e5.k.f3817f.get(i7)).get("col1Path"), new String[0]);
                            hashMap.put("mediaName", (String) ((HashMap) e5.k.f3817f.get(i7)).get("col1Name"));
                            hashMap.put(str10, (String) ((HashMap) e5.k.f3817f.get(i7)).get("col1Path"));
                            hashMap.put("mediaSize", (String) ((HashMap) e5.k.f3817f.get(i7)).get("col1Size"));
                            hashMap.put("mediaDate", (String) ((HashMap) e5.k.f3817f.get(i7)).get("col1Date"));
                            try {
                                Files.delete(path);
                            } catch (IOException unused) {
                            }
                            PartFileManager.S.remove(hashMap);
                            PartFileManager.T.remove(hashMap);
                            PartFileManager.U.remove(hashMap);
                            PartFileManager.V.remove(hashMap);
                            PartFileManager.W.remove(hashMap);
                            z6 = true;
                        } else {
                            str13 = str13;
                            z6 = false;
                            z10 = false;
                        }
                        if (Boolean.TRUE.equals(((Map) e5.k.f3818g.get(i7)).get("col2"))) {
                            Path path2 = Paths.get((String) ((HashMap) e5.k.f3817f.get(i7)).get("col2Path"), new String[0]);
                            str12 = str12;
                            hashMap.put("mediaName", (String) ((HashMap) e5.k.f3817f.get(i7)).get(str12));
                            hashMap.put(str10, (String) ((HashMap) e5.k.f3817f.get(i7)).get("col2Path"));
                            str10 = str10;
                            hashMap.put("mediaSize", (String) ((HashMap) e5.k.f3817f.get(i7)).get(str6));
                            str11 = str11;
                            hashMap.put("mediaDate", (String) ((HashMap) e5.k.f3817f.get(i7)).get(str11));
                            try {
                                Files.delete(path2);
                            } catch (IOException unused2) {
                            }
                            PartFileManager.S.remove(hashMap);
                            PartFileManager.T.remove(hashMap);
                            PartFileManager.U.remove(hashMap);
                            PartFileManager.V.remove(hashMap);
                            PartFileManager.W.remove(hashMap);
                        } else {
                            str12 = str12;
                            str10 = str10;
                            str11 = str11;
                            z10 = false;
                            z6 = false;
                        }
                        if (z6) {
                            e5.k.e.remove(e5.k.f3817f.get(i7));
                            FileManagerItemActivity.this.K.c();
                            TextView textView = FileManagerItemActivity.M;
                            StringBuilder sb = new StringBuilder();
                            z9 = z10;
                            sb.append(Integer.parseInt(FileManagerItemActivity.M.getText().toString()) - 2);
                            str14 = str14;
                            sb.append(str14);
                            textView.setText(sb.toString());
                        } else {
                            z9 = z10;
                            str14 = str14;
                        }
                    }
                    if (!z9) {
                        FileManagerItemActivity.this.v();
                    }
                    FileManagerItemActivity.this.cancelButtonClick(null);
                    dVar = FileManagerItemActivity.this.K;
                    break;
                case 3:
                    for (int i8 = 0; i8 < e5.g.f3797j.size(); i8++) {
                        HashMap hashMap2 = new HashMap();
                        try {
                            Files.delete(Paths.get((String) ((HashMap) e5.g.f3797j.get(i8)).get("col1Path"), new String[0]));
                        } catch (IOException unused3) {
                        }
                        hashMap2.put("mediaName", (String) ((HashMap) e5.g.f3797j.get(i8)).get("col1Name"));
                        hashMap2.put(str10, (String) ((HashMap) e5.g.f3797j.get(i8)).get("col1Path"));
                        hashMap2.put("mediaSize", (String) ((HashMap) e5.g.f3797j.get(i8)).get("col1Size"));
                        hashMap2.put("mediaDate", (String) ((HashMap) e5.g.f3797j.get(i8)).get("col1Date"));
                        e5.g.f3796i.remove(e5.g.f3797j.get(i8));
                        PartFileManager.R.remove(hashMap2);
                    }
                    FileManagerItemActivity.this.cancelButtonClick(null);
                    FileManagerItemActivity.this.J.c();
                    TextView textView2 = FileManagerItemActivity.M;
                    textView2.setText((Integer.parseInt(FileManagerItemActivity.M.getText().toString()) - 1) + str9);
                    return;
                case 4:
                    a aVar = this;
                    String str15 = str5;
                    String str16 = str8;
                    String str17 = str9;
                    boolean z11 = true;
                    for (int i9 = 0; i9 < p.f3844f.size(); i9++) {
                        HashMap hashMap3 = new HashMap();
                        boolean z12 = z11;
                        if (Boolean.TRUE.equals(((Map) p.f3845g.get(i9)).get(str16))) {
                            str = str16;
                            Path path3 = Paths.get((String) ((HashMap) p.f3844f.get(i9)).get("col1Path"), new String[0]);
                            hashMap3.put("mediaName", (String) ((HashMap) p.f3844f.get(i9)).get("col1Name"));
                            hashMap3.put(str10, (String) ((HashMap) p.f3844f.get(i9)).get("col1Path"));
                            hashMap3.put("mediaSize", (String) ((HashMap) p.f3844f.get(i9)).get("col1Size"));
                            hashMap3.put("mediaDate", (String) ((HashMap) p.f3844f.get(i9)).get("col1Date"));
                            try {
                                Files.delete(path3);
                            } catch (IOException unused4) {
                            }
                            PartFileManager.P.remove(hashMap3);
                            z7 = true;
                        } else {
                            str = str16;
                            z7 = false;
                            z12 = false;
                        }
                        if (Boolean.TRUE.equals(((Map) p.f3845g.get(i9)).get("col2"))) {
                            Path path4 = Paths.get((String) ((HashMap) p.f3844f.get(i9)).get("col2Path"), new String[0]);
                            hashMap3.put("mediaName", (String) ((HashMap) p.f3844f.get(i9)).get(str7));
                            hashMap3.put(str10, (String) ((HashMap) p.f3844f.get(i9)).get("col2Path"));
                            hashMap3.put("mediaSize", (String) ((HashMap) p.f3844f.get(i9)).get(str6));
                            str2 = str15;
                            hashMap3.put("mediaDate", (String) ((HashMap) p.f3844f.get(i9)).get(str2));
                            try {
                                Files.delete(path4);
                            } catch (IOException unused5) {
                            }
                            PartFileManager.P.remove(hashMap3);
                        } else {
                            str2 = str15;
                            z12 = false;
                            z7 = false;
                        }
                        if (z7) {
                            p.e.remove(p.f3844f.get(i9));
                            aVar = this;
                            z11 = z12;
                            str16 = str;
                            FileManagerItemActivity.this.H.c();
                            TextView textView3 = FileManagerItemActivity.M;
                            str15 = str2;
                            StringBuilder sb2 = new StringBuilder();
                            str7 = str7;
                            sb2.append(Integer.parseInt(FileManagerItemActivity.M.getText().toString()) - 2);
                            str17 = str17;
                            sb2.append(str17);
                            textView3.setText(sb2.toString());
                        } else {
                            aVar = this;
                            z11 = z12;
                            str7 = str7;
                            str15 = str2;
                            str17 = str17;
                            str16 = str;
                        }
                    }
                    if (!z11) {
                        FileManagerItemActivity.this.v();
                    }
                    FileManagerItemActivity.this.cancelButtonClick(null);
                    dVar = FileManagerItemActivity.this.H;
                    break;
                case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                    int i10 = 0;
                    boolean z13 = true;
                    while (i10 < v.f3860f.size()) {
                        HashMap hashMap4 = new HashMap();
                        if (Boolean.TRUE.equals(((Map) v.f3861g.get(i10)).get(str8))) {
                            str8 = str8;
                            Path path5 = Paths.get((String) ((HashMap) v.f3860f.get(i10)).get("col1Path"), new String[0]);
                            hashMap4.put("mediaName", (String) ((HashMap) v.f3860f.get(i10)).get("col1Name"));
                            hashMap4.put(str10, (String) ((HashMap) v.f3860f.get(i10)).get("col1Path"));
                            hashMap4.put("mediaSize", (String) ((HashMap) v.f3860f.get(i10)).get("col1Size"));
                            hashMap4.put("mediaDate", (String) ((HashMap) v.f3860f.get(i10)).get("col1Date"));
                            try {
                                Files.delete(path5);
                            } catch (IOException unused6) {
                            }
                            PartFileManager.Q.remove(hashMap4);
                            z8 = true;
                        } else {
                            str8 = str8;
                            z8 = false;
                            z13 = false;
                        }
                        if (Boolean.TRUE.equals(((Map) v.f3861g.get(i10)).get("col2"))) {
                            Path path6 = Paths.get((String) ((HashMap) v.f3860f.get(i10)).get("col2Path"), new String[0]);
                            hashMap4.put("mediaName", (String) ((HashMap) v.f3860f.get(i10)).get(str7));
                            hashMap4.put(str10, (String) ((HashMap) v.f3860f.get(i10)).get("col2Path"));
                            hashMap4.put("mediaSize", (String) ((HashMap) v.f3860f.get(i10)).get(str6));
                            str3 = str5;
                            hashMap4.put("mediaDate", (String) ((HashMap) v.f3860f.get(i10)).get(str3));
                            try {
                                Files.delete(path6);
                            } catch (IOException unused7) {
                            }
                            PartFileManager.Q.remove(hashMap4);
                        } else {
                            str3 = str5;
                            z13 = false;
                            z8 = false;
                        }
                        if (z8) {
                            v.e.remove(v.f3860f.get(i10));
                            FileManagerItemActivity.this.I.c();
                            TextView textView4 = FileManagerItemActivity.M;
                            StringBuilder sb3 = new StringBuilder();
                            str5 = str3;
                            sb3.append(Integer.parseInt(FileManagerItemActivity.M.getText().toString()) - 2);
                            str9 = str9;
                            sb3.append(str9);
                            textView4.setText(sb3.toString());
                        } else {
                            str5 = str3;
                            str9 = str9;
                        }
                        i10++;
                        str6 = str6;
                    }
                    if (!z13) {
                        FileManagerItemActivity.this.v();
                    }
                    FileManagerItemActivity.this.cancelButtonClick(null);
                    dVar = FileManagerItemActivity.this.I;
                    break;
                default:
                    return;
            }
            dVar.c();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b implements View.OnClickListener {

        /* renamed from: f */
        public final /* synthetic */ Dialog f3500f;

        public b(Dialog dialog) {
            this.f3500f = dialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f3500f.cancel();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class c implements Runnable {
        public c() {
            FileManagerItemActivity.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FileManagerItemActivity fileManagerItemActivity = FileManagerItemActivity.this;
            fileManagerItemActivity.F.setAdapter(fileManagerItemActivity.H);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class d implements Runnable {
        public d() {
            FileManagerItemActivity.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FileManagerItemActivity fileManagerItemActivity = FileManagerItemActivity.this;
            fileManagerItemActivity.F.setAdapter(fileManagerItemActivity.I);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class e implements Runnable {
        public e() {
            FileManagerItemActivity.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FileManagerItemActivity fileManagerItemActivity = FileManagerItemActivity.this;
            fileManagerItemActivity.F.setAdapter(fileManagerItemActivity.J);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class f implements Runnable {
        public f() {
            FileManagerItemActivity.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FileManagerItemActivity fileManagerItemActivity = FileManagerItemActivity.this;
            fileManagerItemActivity.F.setAdapter(fileManagerItemActivity.K);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class g implements Runnable {
        public g() {
            FileManagerItemActivity.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FileManagerItemActivity fileManagerItemActivity = FileManagerItemActivity.this;
            fileManagerItemActivity.F.setAdapter(fileManagerItemActivity.K);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class h implements Runnable {
        public h() {
            FileManagerItemActivity.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FileManagerItemActivity fileManagerItemActivity = FileManagerItemActivity.this;
            fileManagerItemActivity.F.setAdapter(fileManagerItemActivity.K);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class i implements Runnable {
        public i() {
            FileManagerItemActivity.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FileManagerItemActivity fileManagerItemActivity = FileManagerItemActivity.this;
            fileManagerItemActivity.F.setAdapter(fileManagerItemActivity.K);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class j implements Runnable {
        public j() {
            FileManagerItemActivity.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FileManagerItemActivity fileManagerItemActivity = FileManagerItemActivity.this;
            fileManagerItemActivity.F.setAdapter(fileManagerItemActivity.K);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class k implements Runnable {

        /* renamed from: f */
        public final /* synthetic */ List f3509f;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements Runnable {

            /* renamed from: com.tragisoap.fileandpdfmanager.FileManagerItemActivity$k$a$a */
            /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
            public class RunnableC0041a implements Runnable {
                public RunnableC0041a() {
                    a.this = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    FileManagerItemActivity fileManagerItemActivity = FileManagerItemActivity.this;
                    fileManagerItemActivity.F.setAdapter(fileManagerItemActivity.K);
                }
            }

            public a() {
                k.this = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i7 = 0;
                for (int i8 = 0; i8 < FileManagerItemActivity.this.L.size(); i8 += 2) {
                    HashMap hashMap = new HashMap();
                    HashMap<String, String> hashMap2 = FileManagerItemActivity.this.L.get(i8);
                    hashMap.put("col1Name", hashMap2.getOrDefault("mediaName", ""));
                    hashMap.put("col1Path", hashMap2.getOrDefault("mediaPath", ""));
                    hashMap.put("col1Size", hashMap2.getOrDefault("mediaSize", ""));
                    hashMap.put("col1Date", hashMap2.getOrDefault("mediaDate", ""));
                    i7++;
                    int i9 = i8 + 1;
                    if (i9 < FileManagerItemActivity.this.L.size()) {
                        HashMap<String, String> hashMap3 = FileManagerItemActivity.this.L.get(i9);
                        hashMap.put("col2Name", hashMap3.getOrDefault("mediaName", ""));
                        hashMap.put("col2Path", hashMap3.getOrDefault("mediaPath", ""));
                        hashMap.put("col2Size", hashMap3.getOrDefault("mediaSize", ""));
                        hashMap.put("col2Date", hashMap3.getOrDefault("mediaDate", ""));
                        i7++;
                    } else {
                        hashMap.put("col2Name", "");
                        hashMap.put("col2Path", "");
                        hashMap.put("col2Size", "");
                        hashMap.put("col2Date", "");
                    }
                    k.this.f3509f.add(hashMap);
                }
                FileManagerItemActivity.this.F.setLayoutManager(new LinearLayoutManager(1));
                FileManagerItemActivity.M.setText(i7 + "");
                FileManagerItemActivity fileManagerItemActivity = FileManagerItemActivity.this;
                k kVar = k.this;
                fileManagerItemActivity.K = new e5.k(FileManagerItemActivity.this, kVar.f3509f);
                FileManagerItemActivity.this.runOnUiThread(new RunnableC0041a());
            }
        }

        public k(ArrayList arrayList) {
            FileManagerItemActivity.this = r1;
            this.f3509f = arrayList;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q qVar = new q(FileManagerItemActivity.this);
            try {
                FileManagerItemActivity.this.L = qVar.execute(new Void[0]).get();
                FileManagerItemActivity.this.runOnUiThread(new a());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e7) {
                throw new RuntimeException(e7);
            }
        }
    }

    public void cancelButtonClick(View view) {
        RecyclerView.d dVar;
        N.setText("0");
        String str = getIntent().getStringExtra("file").toString();
        str.getClass();
        char c7 = 65535;
        switch (str.hashCode()) {
            case -599266462:
                if (str.equals("compress")) {
                    c7 = 0;
                    break;
                }
                break;
            case 96796:
                if (str.equals("apk")) {
                    c7 = 1;
                    break;
                }
                break;
            case 110834:
                if (str.equals("pdf")) {
                    c7 = 2;
                    break;
                }
                break;
            case 93166550:
                if (str.equals("audio")) {
                    c7 = 3;
                    break;
                }
                break;
            case 100313435:
                if (str.equals("image")) {
                    c7 = 4;
                    break;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    c7 = 5;
                    break;
                }
                break;
            case 943542968:
                if (str.equals("documents")) {
                    c7 = 6;
                    break;
                }
                break;
            case 1312704747:
                if (str.equals("downloads")) {
                    c7 = 7;
                    break;
                }
                break;
            case 1616759419:
                if (str.equals("pdfmanager")) {
                    c7 = '\b';
                    break;
                }
                break;
        }
        switch (c7) {
            case 0:
            case 1:
            case 2:
            case 6:
            case 7:
            case '\b':
                e5.k.f3817f.clear();
                e5.k.f3818g.clear();
                dVar = this.K;
                break;
            case 3:
                e5.g.f3797j.clear();
                dVar = this.J;
                break;
            case 4:
                p.f3844f.clear();
                p.f3845g.clear();
                dVar = this.H;
                break;
            case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                v.f3860f.clear();
                v.f3861g.clear();
                dVar = this.I;
                break;
            default:
                O.setVisibility(8);
        }
        dVar.c();
        O.setVisibility(8);
    }

    public void deleteButtonClick(View view) {
        Dialog dialog = new Dialog(this);
        Window window = dialog.getWindow();
        Objects.requireNonNull(window);
        window.setBackgroundDrawableResource(17170445);
        View inflate = getLayoutInflater().inflate(2131492986, (ViewGroup) null);
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(false);
        ((Button) inflate.findViewById(2131296744)).setOnClickListener(new a(dialog));
        ((Button) inflate.findViewById(2131296743)).setOnClickListener(new b(dialog));
        dialog.show();
    }

    public void nullClick(View view) {
    }

    @Override // androidx.fragment.app.q, androidx.activity.ComponentActivity, f1.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492892);
        M = (TextView) findViewById(2131296333);
        N = (TextView) findViewById(2131296778);
        this.D = (ImageView) findViewById(2131296525);
        this.E = (TextView) findViewById(2131296839);
        this.F = (RecyclerView) findViewById(2131296741);
        O = (LinearLayout) findViewById(2131296575);
        this.G = (LinearLayout) findViewById(2131296880);
        v();
    }

    @Override // androidx.fragment.app.q, android.app.Activity
    public final void onResume() {
        super.onResume();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x04ec  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x053a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v() {
        /*
            Method dump skipped, instructions count: 1546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tragisoap.fileandpdfmanager.FileManagerItemActivity.v():void");
    }
}
