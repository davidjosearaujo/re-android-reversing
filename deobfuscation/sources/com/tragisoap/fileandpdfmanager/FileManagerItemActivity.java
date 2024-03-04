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

/* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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
            Object obj;
            boolean z6;
            Object obj2;
            String str;
            Object obj3;
            boolean z7;
            boolean z8;
            boolean z9;
            String str2;
            Object obj4;
            boolean z10;
            Object obj5;
            boolean z11;
            boolean z12;
            boolean z13;
            String str3;
            Object obj6;
            String str4;
            Object obj7;
            String str5;
            boolean z14;
            String str6;
            boolean z15;
            String str7;
            String str8;
            this.f3498f.cancel();
            String str9 = FileManagerItemActivity.this.getIntent().getStringExtra("file").toString();
            str9.getClass();
            switch (str9.hashCode()) {
                case -599266462:
                    if (str9.equals("compress")) {
                        c7 = 0;
                        break;
                    }
                    c7 = 65535;
                    break;
                case 96796:
                    if (str9.equals("apk")) {
                        c7 = 1;
                        break;
                    }
                    c7 = 65535;
                    break;
                case 110834:
                    if (str9.equals("pdf")) {
                        c7 = 2;
                        break;
                    }
                    c7 = 65535;
                    break;
                case 93166550:
                    if (str9.equals("audio")) {
                        c7 = 3;
                        break;
                    }
                    c7 = 65535;
                    break;
                case 100313435:
                    if (str9.equals("image")) {
                        c7 = 4;
                        break;
                    }
                    c7 = 65535;
                    break;
                case 112202875:
                    if (str9.equals("video")) {
                        c7 = 5;
                        break;
                    }
                    c7 = 65535;
                    break;
                case 943542968:
                    if (str9.equals("documents")) {
                        c7 = 6;
                        break;
                    }
                    c7 = 65535;
                    break;
                case 1312704747:
                    if (str9.equals("downloads")) {
                        c7 = 7;
                        break;
                    }
                    c7 = 65535;
                    break;
                case 1616759419:
                    if (str9.equals("pdfmanager")) {
                        c7 = '\b';
                        break;
                    }
                    c7 = 65535;
                    break;
                default:
                    c7 = 65535;
                    break;
            }
            String str10 = "col2Date";
            String str11 = "col2Size";
            String str12 = "col2Name";
            String str13 = "col1";
            String str14 = "mediaPath";
            String str15 = "";
            switch (c7) {
                case 0:
                case 1:
                case 2:
                case 6:
                case 7:
                case '\b':
                    Object obj8 = "col2Date";
                    Object obj9 = "col2Name";
                    Object obj10 = "col1";
                    String str16 = str15;
                    boolean z16 = true;
                    int i7 = 0;
                    while (i7 < e5.k.f3817f.size()) {
                        HashMap hashMap = new HashMap();
                        boolean z17 = z16;
                        String str17 = str16;
                        if (Boolean.TRUE.equals(((Map) e5.k.f3818g.get(i7)).get(obj10))) {
                            obj = obj10;
                            Path path = Paths.get((String) ((HashMap) e5.k.f3817f.get(i7)).get("col1Path"), new String[0]);
                            hashMap.put("mediaName", (String) ((HashMap) e5.k.f3817f.get(i7)).get("col1Name"));
                            hashMap.put(str14, (String) ((HashMap) e5.k.f3817f.get(i7)).get("col1Path"));
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
                            obj = obj10;
                            z6 = false;
                            z17 = false;
                        }
                        if (Boolean.TRUE.equals(((Map) e5.k.f3818g.get(i7)).get("col2"))) {
                            boolean z18 = z6;
                            Path path2 = Paths.get((String) ((HashMap) e5.k.f3817f.get(i7)).get("col2Path"), new String[0]);
                            obj2 = obj9;
                            hashMap.put("mediaName", (String) ((HashMap) e5.k.f3817f.get(i7)).get(obj2));
                            hashMap.put(str14, (String) ((HashMap) e5.k.f3817f.get(i7)).get("col2Path"));
                            str = str14;
                            hashMap.put("mediaSize", (String) ((HashMap) e5.k.f3817f.get(i7)).get("col2Size"));
                            obj3 = obj8;
                            hashMap.put("mediaDate", (String) ((HashMap) e5.k.f3817f.get(i7)).get(obj3));
                            try {
                                Files.delete(path2);
                            } catch (IOException unused2) {
                            }
                            PartFileManager.S.remove(hashMap);
                            PartFileManager.T.remove(hashMap);
                            PartFileManager.U.remove(hashMap);
                            PartFileManager.V.remove(hashMap);
                            PartFileManager.W.remove(hashMap);
                            z8 = z18;
                            z7 = z17;
                        } else {
                            obj2 = obj9;
                            str = str14;
                            obj3 = obj8;
                            z7 = false;
                            z8 = false;
                        }
                        if (z8) {
                            e5.k.e.remove(e5.k.f3817f.get(i7));
                            FileManagerItemActivity.this.K.c();
                            TextView textView = FileManagerItemActivity.M;
                            StringBuilder sb = new StringBuilder();
                            z9 = z7;
                            sb.append(Integer.parseInt(FileManagerItemActivity.M.getText().toString()) - 2);
                            str2 = str17;
                            sb.append(str2);
                            textView.setText(sb.toString());
                        } else {
                            z9 = z7;
                            str2 = str17;
                        }
                        i7++;
                        obj8 = obj3;
                        obj10 = obj;
                        str14 = str;
                        obj9 = obj2;
                        str16 = str2;
                        z16 = z9;
                    }
                    if (!z16) {
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
                        hashMap2.put("mediaPath", (String) ((HashMap) e5.g.f3797j.get(i8)).get("col1Path"));
                        hashMap2.put("mediaSize", (String) ((HashMap) e5.g.f3797j.get(i8)).get("col1Size"));
                        hashMap2.put("mediaDate", (String) ((HashMap) e5.g.f3797j.get(i8)).get("col1Date"));
                        e5.g.f3796i.remove(e5.g.f3797j.get(i8));
                        PartFileManager.R.remove(hashMap2);
                    }
                    FileManagerItemActivity.this.cancelButtonClick(null);
                    FileManagerItemActivity.this.J.c();
                    FileManagerItemActivity.M.setText((Integer.parseInt(FileManagerItemActivity.M.getText().toString()) - 1) + str15);
                    return;
                case 4:
                    a aVar = this;
                    Object obj11 = "col2Date";
                    Object obj12 = "col1";
                    String str18 = str15;
                    int i9 = 0;
                    boolean z19 = true;
                    while (i9 < p.f3844f.size()) {
                        HashMap hashMap3 = new HashMap();
                        boolean z20 = z19;
                        String str19 = str18;
                        Object obj13 = obj12;
                        if (Boolean.TRUE.equals(((Map) p.f3845g.get(i9)).get(obj13))) {
                            obj4 = obj13;
                            Path path3 = Paths.get((String) ((HashMap) p.f3844f.get(i9)).get("col1Path"), new String[0]);
                            hashMap3.put("mediaName", (String) ((HashMap) p.f3844f.get(i9)).get("col1Name"));
                            hashMap3.put("mediaPath", (String) ((HashMap) p.f3844f.get(i9)).get("col1Path"));
                            hashMap3.put("mediaSize", (String) ((HashMap) p.f3844f.get(i9)).get("col1Size"));
                            hashMap3.put("mediaDate", (String) ((HashMap) p.f3844f.get(i9)).get("col1Date"));
                            try {
                                Files.delete(path3);
                            } catch (IOException unused4) {
                            }
                            PartFileManager.P.remove(hashMap3);
                            z10 = true;
                        } else {
                            obj4 = obj13;
                            z10 = false;
                            z20 = false;
                        }
                        if (Boolean.TRUE.equals(((Map) p.f3845g.get(i9)).get("col2"))) {
                            z12 = z10;
                            Path path4 = Paths.get((String) ((HashMap) p.f3844f.get(i9)).get("col2Path"), new String[0]);
                            hashMap3.put("mediaName", (String) ((HashMap) p.f3844f.get(i9)).get(str12));
                            hashMap3.put("mediaPath", (String) ((HashMap) p.f3844f.get(i9)).get("col2Path"));
                            hashMap3.put("mediaSize", (String) ((HashMap) p.f3844f.get(i9)).get("col2Size"));
                            obj5 = obj11;
                            hashMap3.put("mediaDate", (String) ((HashMap) p.f3844f.get(i9)).get(obj5));
                            try {
                                Files.delete(path4);
                            } catch (IOException unused5) {
                            }
                            PartFileManager.P.remove(hashMap3);
                            z11 = z20;
                        } else {
                            obj5 = obj11;
                            z11 = false;
                            z12 = false;
                        }
                        if (z12) {
                            p.e.remove(p.f3844f.get(i9));
                            aVar = this;
                            z13 = z11;
                            obj7 = obj4;
                            FileManagerItemActivity.this.H.c();
                            TextView textView2 = FileManagerItemActivity.M;
                            obj6 = obj5;
                            StringBuilder sb2 = new StringBuilder();
                            str3 = str12;
                            sb2.append(Integer.parseInt(FileManagerItemActivity.M.getText().toString()) - 2);
                            str4 = str19;
                            sb2.append(str4);
                            textView2.setText(sb2.toString());
                        } else {
                            aVar = this;
                            z13 = z11;
                            str3 = str12;
                            obj6 = obj5;
                            str4 = str19;
                            obj7 = obj4;
                        }
                        i9++;
                        obj12 = obj7;
                        str18 = str4;
                        z19 = z13;
                        str12 = str3;
                        obj11 = obj6;
                    }
                    if (!z19) {
                        FileManagerItemActivity.this.v();
                    }
                    FileManagerItemActivity.this.cancelButtonClick(null);
                    dVar = FileManagerItemActivity.this.H;
                    break;
                case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                    int i10 = 0;
                    boolean z21 = true;
                    while (i10 < v.f3860f.size()) {
                        HashMap hashMap4 = new HashMap();
                        String str20 = str10;
                        String str21 = str11;
                        if (Boolean.TRUE.equals(((Map) v.f3861g.get(i10)).get(str13))) {
                            str5 = str13;
                            Path path5 = Paths.get((String) ((HashMap) v.f3860f.get(i10)).get("col1Path"), new String[0]);
                            hashMap4.put("mediaName", (String) ((HashMap) v.f3860f.get(i10)).get("col1Name"));
                            hashMap4.put("mediaPath", (String) ((HashMap) v.f3860f.get(i10)).get("col1Path"));
                            hashMap4.put("mediaSize", (String) ((HashMap) v.f3860f.get(i10)).get("col1Size"));
                            hashMap4.put("mediaDate", (String) ((HashMap) v.f3860f.get(i10)).get("col1Date"));
                            try {
                                Files.delete(path5);
                            } catch (IOException unused6) {
                            }
                            PartFileManager.Q.remove(hashMap4);
                            z14 = true;
                        } else {
                            str5 = str13;
                            z14 = false;
                            z21 = false;
                        }
                        if (Boolean.TRUE.equals(((Map) v.f3861g.get(i10)).get("col2"))) {
                            z15 = z14;
                            Path path6 = Paths.get((String) ((HashMap) v.f3860f.get(i10)).get("col2Path"), new String[0]);
                            hashMap4.put("mediaName", (String) ((HashMap) v.f3860f.get(i10)).get("col2Name"));
                            hashMap4.put("mediaPath", (String) ((HashMap) v.f3860f.get(i10)).get("col2Path"));
                            hashMap4.put("mediaSize", (String) ((HashMap) v.f3860f.get(i10)).get(str21));
                            str6 = str20;
                            hashMap4.put("mediaDate", (String) ((HashMap) v.f3860f.get(i10)).get(str6));
                            try {
                                Files.delete(path6);
                            } catch (IOException unused7) {
                            }
                            PartFileManager.Q.remove(hashMap4);
                        } else {
                            str6 = str20;
                            z21 = false;
                            z15 = false;
                        }
                        if (z15) {
                            v.e.remove(v.f3860f.get(i10));
                            FileManagerItemActivity.this.I.c();
                            TextView textView3 = FileManagerItemActivity.M;
                            StringBuilder sb3 = new StringBuilder();
                            str7 = str6;
                            sb3.append(Integer.parseInt(FileManagerItemActivity.M.getText().toString()) - 2);
                            str8 = str15;
                            sb3.append(str8);
                            textView3.setText(sb3.toString());
                        } else {
                            str7 = str6;
                            str8 = str15;
                        }
                        i10++;
                        str15 = str8;
                        str11 = str21;
                        str13 = str5;
                        str10 = str7;
                    }
                    if (!z21) {
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public class k implements Runnable {

        /* renamed from: f */
        public final /* synthetic */ List f3509f;

        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: com.tragisoap.fileandpdfmanager.FileManagerItemActivity$k$a$a */
            /* loaded from: classes.dex */
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
    /* JADX WARN: Removed duplicated region for block: B:416:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:456:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:464:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x04ec  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:470:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:473:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x053a  */
    /* JADX WARN: Removed duplicated region for block: B:483:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void v() {
        /*
            Method dump skipped, instructions count: 1546
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tragisoap.fileandpdfmanager.FileManagerItemActivity.v():void");
    }
}
