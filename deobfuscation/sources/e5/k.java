package e5;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.tragisoap.fileandpdfmanager.FileManagerItemActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ozaydin.serkan.com.image_zoom_view.ImageViewZoom;

/* loaded from: classes.dex */
public final class k extends RecyclerView.d<a> {
    public static List<HashMap<String, String>> e;

    /* renamed from: f */
    public static ArrayList f3817f = new ArrayList();

    /* renamed from: g */
    public static ArrayList f3818g = new ArrayList();

    /* renamed from: d */
    public Context f3819d;

    /* loaded from: classes.dex */
    public class a extends RecyclerView.a0 {
        public ImageViewZoom A;
        public ImageViewZoom B;
        public CheckBox C;
        public CheckBox D;
        public LinearLayout E;
        public LinearLayout F;
        public ImageView G;
        public ImageView H;

        /* renamed from: u */
        public TextView f3820u;

        /* renamed from: v */
        public TextView f3821v;

        /* renamed from: w */
        public TextView f3822w;

        /* renamed from: x */
        public TextView f3823x;

        /* renamed from: y */
        public TextView f3824y;

        /* renamed from: z */
        public TextView f3825z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.this = r3;
            this.f3820u = (TextView) view.findViewById(2131296416);
            this.f3821v = (TextView) view.findViewById(2131296417);
            this.f3822w = (TextView) view.findViewById(2131296654);
            this.f3823x = (TextView) view.findViewById(2131296655);
            this.f3824y = (TextView) view.findViewById(2131296787);
            this.f3825z = (TextView) view.findViewById(2131296788);
            this.A = (ImageViewZoom) view.findViewById(2131296518);
            this.B = (ImageViewZoom) view.findViewById(2131296519);
            this.C = (CheckBox) view.findViewById(2131296382);
            this.D = (CheckBox) view.findViewById(2131296383);
            this.E = (LinearLayout) view.findViewById(2131296260);
            this.F = (LinearLayout) view.findViewById(2131296261);
            this.G = (ImageView) view.findViewById(2131296901);
            this.H = (ImageView) view.findViewById(2131296902);
            CardView cardView = (CardView) view.findViewById(2131296371);
            CardView cardView2 = (CardView) view.findViewById(2131296372);
            this.E.setSoundEffectsEnabled(false);
            this.F.setSoundEffectsEnabled(false);
            this.G.setVisibility(8);
            this.H.setVisibility(8);
            this.E.setBackgroundTintList(ColorStateList.valueOf(r3.f3819d.getColor(2131034141)));
            this.F.setBackgroundTintList(ColorStateList.valueOf(r3.f3819d.getColor(2131034141)));
        }

        public static void q(a aVar, String str) {
            aVar.getClass();
            File file = new File(str);
            Uri b2 = FileProvider.b(k.this.f3819d, "com.tragisoap.fileandpdfmanager").b(file);
            String str2 = null;
            if (file.exists()) {
                try {
                    str2 = URLConnection.guessContentTypeFromStream(new FileInputStream(file));
                    if (str2 == null) {
                        str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(b2, str2);
            intent.addFlags(1);
            intent.addFlags(268435456);
            try {
                k.this.f3819d.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(k.this.f3819d, "Not app to open file", 0).show();
            }
        }

        public final void r(CheckBox checkBox, CheckBox checkBox2, HashMap<String, String> hashMap, int i7) {
            HashMap hashMap2;
            Boolean bool;
            HashMap hashMap3;
            Boolean bool2;
            if (i7 == 1) {
                if (!checkBox.isChecked()) {
                    if (Boolean.TRUE.equals(((Map) k.f3818g.get(k.f3817f.indexOf(hashMap))).get("col2"))) {
                        ArrayList arrayList = k.f3817f;
                        arrayList.set(arrayList.indexOf(hashMap), hashMap);
                        hashMap2 = new HashMap();
                        bool2 = Boolean.FALSE;
                    }
                    k.f3818g.remove(k.f3817f.indexOf(hashMap));
                    k.f3817f.remove(hashMap);
                } else if (k.f3817f.contains(hashMap)) {
                    ArrayList arrayList2 = k.f3817f;
                    arrayList2.set(arrayList2.indexOf(hashMap), hashMap);
                    hashMap2 = new HashMap();
                    bool2 = Boolean.TRUE;
                } else {
                    k.f3817f.add(hashMap);
                    hashMap3 = new HashMap();
                    hashMap3.put("col1", Boolean.TRUE);
                    hashMap3.put("col2", Boolean.FALSE);
                    k.f3818g.add(hashMap3);
                }
                hashMap2.put("col1", bool2);
                hashMap2.put("col2", (Boolean) ((Map) k.f3818g.get(k.f3817f.indexOf(hashMap))).get("col2"));
                k.f3818g.set(k.f3817f.indexOf(hashMap), hashMap2);
            } else {
                if (!checkBox2.isChecked()) {
                    if (Boolean.TRUE.equals(((Map) k.f3818g.get(k.f3817f.indexOf(hashMap))).get("col1"))) {
                        ArrayList arrayList3 = k.f3817f;
                        arrayList3.set(arrayList3.indexOf(hashMap), hashMap);
                        hashMap2 = new HashMap();
                        bool = Boolean.FALSE;
                    }
                    k.f3818g.remove(k.f3817f.indexOf(hashMap));
                    k.f3817f.remove(hashMap);
                } else if (k.f3817f.contains(hashMap)) {
                    ArrayList arrayList4 = k.f3817f;
                    arrayList4.set(arrayList4.indexOf(hashMap), hashMap);
                    hashMap2 = new HashMap();
                    bool = Boolean.TRUE;
                } else {
                    k.f3817f.add(hashMap);
                    hashMap3 = new HashMap();
                    hashMap3.put("col2", Boolean.TRUE);
                    hashMap3.put("col1", Boolean.FALSE);
                    k.f3818g.add(hashMap3);
                }
                hashMap2.put("col2", bool);
                hashMap2.put("col1", (Boolean) ((Map) k.f3818g.get(k.f3817f.indexOf(hashMap))).get("col1"));
                k.f3818g.set(k.f3817f.indexOf(hashMap), hashMap2);
            }
            TextView textView = FileManagerItemActivity.N;
            StringBuilder sb = new StringBuilder();
            k.this.getClass();
            int i8 = 0;
            for (int i9 = 0; i9 < k.f3818g.size(); i9++) {
                Boolean bool3 = Boolean.TRUE;
                if (bool3.equals(((Map) k.f3818g.get(i9)).get("col1"))) {
                    i8++;
                }
                if (bool3.equals(((Map) k.f3818g.get(i9)).get("col2"))) {
                    i8++;
                }
            }
            FileManagerItemActivity.O.setVisibility(i8 != 0 ? 0 : 8);
            sb.append(i8);
            sb.append("");
            textView.setText(sb.toString());
            for (int i10 = 0; i10 < k.f3817f.size(); i10++) {
                Log.d("Check", ((String) ((HashMap) k.f3817f.get(i10)).get("col1Name")) + " - " + ((Map) k.f3818g.get(i10)).get("col1") + " | " + ((String) ((HashMap) k.f3817f.get(i10)).get("col2Name")) + " - " + ((Map) k.f3818g.get(i10)).get("col2"));
            }
        }
    }

    public k(Context context, List<HashMap<String, String>> list) {
        this.f3819d = context;
        e = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final int a() {
        return e.size();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:790:0x009f, code lost:
        if (r2.equals(((java.util.Map) e5.k.f3818g.get(e5.k.f3817f.indexOf(r1))).get("col2")) != false) goto L210;
     */
    /* JADX WARN: Removed duplicated region for block: B:1001:0x05c6  */
    /* JADX WARN: Removed duplicated region for block: B:1005:0x05d3  */
    /* JADX WARN: Removed duplicated region for block: B:1009:0x05df  */
    /* JADX WARN: Removed duplicated region for block: B:1013:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:1018:0x05f9  */
    /* JADX WARN: Removed duplicated region for block: B:1019:0x0606  */
    /* JADX WARN: Removed duplicated region for block: B:1020:0x0614  */
    /* JADX WARN: Removed duplicated region for block: B:1021:0x0621  */
    /* JADX WARN: Removed duplicated region for block: B:1022:0x062e  */
    /* JADX WARN: Removed duplicated region for block: B:1023:0x063b  */
    /* JADX WARN: Removed duplicated region for block: B:1024:0x0648  */
    /* JADX WARN: Removed duplicated region for block: B:1025:0x0655  */
    /* JADX WARN: Removed duplicated region for block: B:1026:0x0662  */
    /* JADX WARN: Removed duplicated region for block: B:1027:0x0683  */
    /* JADX WARN: Removed duplicated region for block: B:1028:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:1029:0x06b2  */
    /* JADX WARN: Removed duplicated region for block: B:1035:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:1041:0x076b  */
    /* JADX WARN: Removed duplicated region for block: B:1043:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:920:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:921:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:925:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:929:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:933:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:937:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:941:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:945:0x051e  */
    /* JADX WARN: Removed duplicated region for block: B:949:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:953:0x0538  */
    /* JADX WARN: Removed duplicated region for block: B:957:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:961:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:965:0x055f  */
    /* JADX WARN: Removed duplicated region for block: B:969:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:973:0x0577  */
    /* JADX WARN: Removed duplicated region for block: B:977:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:981:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:985:0x059a  */
    /* JADX WARN: Removed duplicated region for block: B:989:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:993:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:997:0x05ba  */
    @Override // androidx.recyclerview.widget.RecyclerView.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(e5.k.a r29, int r30) {
        /*
            Method dump skipped, instructions count: 2206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e5.k.d(androidx.recyclerview.widget.RecyclerView$a0, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final RecyclerView.a0 e(RecyclerView recyclerView) {
        return new a(LayoutInflater.from(this.f3819d).inflate(2131492974, (ViewGroup) recyclerView, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final void f(a aVar) {
        aVar.F.setVisibility(0);
    }
}
