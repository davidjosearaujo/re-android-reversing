package e5;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tragisoap.fileandpdfmanager.FileManagerItemActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ozaydin.serkan.com.image_zoom_view.ImageViewZoom;

/* loaded from: classes.dex */
public final class p extends RecyclerView.d<a> {
    public static List<HashMap<String, String>> e;

    /* renamed from: f */
    public static ArrayList f3844f = new ArrayList();

    /* renamed from: g */
    public static ArrayList f3845g = new ArrayList();

    /* renamed from: d */
    public Context f3846d;

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
        public TextView f3847u;

        /* renamed from: v */
        public TextView f3848v;

        /* renamed from: w */
        public TextView f3849w;

        /* renamed from: x */
        public TextView f3850x;

        /* renamed from: y */
        public TextView f3851y;

        /* renamed from: z */
        public TextView f3852z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            p.this = r3;
            this.f3847u = (TextView) view.findViewById(2131296416);
            this.f3848v = (TextView) view.findViewById(2131296417);
            this.f3849w = (TextView) view.findViewById(2131296654);
            this.f3850x = (TextView) view.findViewById(2131296655);
            this.f3851y = (TextView) view.findViewById(2131296787);
            this.f3852z = (TextView) view.findViewById(2131296788);
            this.A = (ImageViewZoom) view.findViewById(2131296518);
            this.B = (ImageViewZoom) view.findViewById(2131296519);
            this.C = (CheckBox) view.findViewById(2131296382);
            this.D = (CheckBox) view.findViewById(2131296383);
            this.E = (LinearLayout) view.findViewById(2131296260);
            this.F = (LinearLayout) view.findViewById(2131296261);
            this.G = (ImageView) view.findViewById(2131296901);
            this.H = (ImageView) view.findViewById(2131296902);
            this.E.setSoundEffectsEnabled(false);
            this.F.setSoundEffectsEnabled(false);
            this.G.setVisibility(8);
            this.H.setVisibility(8);
            this.E.setBackgroundTintList(ColorStateList.valueOf(r3.f3846d.getColor(2131034141)));
            this.F.setBackgroundTintList(ColorStateList.valueOf(r3.f3846d.getColor(2131034141)));
        }

        public final void q(CheckBox checkBox, CheckBox checkBox2, HashMap<String, String> hashMap, int i7) {
            HashMap hashMap2;
            Boolean bool;
            HashMap hashMap3;
            Boolean bool2;
            if (i7 == 1) {
                if (!checkBox.isChecked()) {
                    if (Boolean.TRUE.equals(((Map) p.f3845g.get(p.f3844f.indexOf(hashMap))).get("col2"))) {
                        ArrayList arrayList = p.f3844f;
                        arrayList.set(arrayList.indexOf(hashMap), hashMap);
                        hashMap2 = new HashMap();
                        bool2 = Boolean.FALSE;
                    }
                    p.f3845g.remove(p.f3844f.indexOf(hashMap));
                    p.f3844f.remove(hashMap);
                } else if (p.f3844f.contains(hashMap)) {
                    ArrayList arrayList2 = p.f3844f;
                    arrayList2.set(arrayList2.indexOf(hashMap), hashMap);
                    hashMap2 = new HashMap();
                    bool2 = Boolean.TRUE;
                } else {
                    p.f3844f.add(hashMap);
                    hashMap3 = new HashMap();
                    hashMap3.put("col1", Boolean.TRUE);
                    hashMap3.put("col2", Boolean.FALSE);
                    p.f3845g.add(hashMap3);
                }
                hashMap2.put("col1", bool2);
                hashMap2.put("col2", (Boolean) ((Map) p.f3845g.get(p.f3844f.indexOf(hashMap))).get("col2"));
                p.f3845g.set(p.f3844f.indexOf(hashMap), hashMap2);
            } else {
                if (!checkBox2.isChecked()) {
                    if (Boolean.TRUE.equals(((Map) p.f3845g.get(p.f3844f.indexOf(hashMap))).get("col1"))) {
                        ArrayList arrayList3 = p.f3844f;
                        arrayList3.set(arrayList3.indexOf(hashMap), hashMap);
                        hashMap2 = new HashMap();
                        bool = Boolean.FALSE;
                    }
                    p.f3845g.remove(p.f3844f.indexOf(hashMap));
                    p.f3844f.remove(hashMap);
                } else if (p.f3844f.contains(hashMap)) {
                    ArrayList arrayList4 = p.f3844f;
                    arrayList4.set(arrayList4.indexOf(hashMap), hashMap);
                    hashMap2 = new HashMap();
                    bool = Boolean.TRUE;
                } else {
                    p.f3844f.add(hashMap);
                    hashMap3 = new HashMap();
                    hashMap3.put("col2", Boolean.TRUE);
                    hashMap3.put("col1", Boolean.FALSE);
                    p.f3845g.add(hashMap3);
                }
                hashMap2.put("col2", bool);
                hashMap2.put("col1", (Boolean) ((Map) p.f3845g.get(p.f3844f.indexOf(hashMap))).get("col1"));
                p.f3845g.set(p.f3844f.indexOf(hashMap), hashMap2);
            }
            TextView textView = FileManagerItemActivity.N;
            StringBuilder sb = new StringBuilder();
            p.this.getClass();
            int i8 = 0;
            for (int i9 = 0; i9 < p.f3845g.size(); i9++) {
                Boolean bool3 = Boolean.TRUE;
                if (bool3.equals(((Map) p.f3845g.get(i9)).get("col1"))) {
                    i8++;
                }
                if (bool3.equals(((Map) p.f3845g.get(i9)).get("col2"))) {
                    i8++;
                }
            }
            FileManagerItemActivity.O.setVisibility(i8 != 0 ? 0 : 8);
            sb.append(i8);
            sb.append("");
            textView.setText(sb.toString());
            for (int i10 = 0; i10 < p.f3844f.size(); i10++) {
                Log.d("Check", ((String) ((HashMap) p.f3844f.get(i10)).get("col1Name")) + " - " + ((Map) p.f3845g.get(i10)).get("col1") + " | " + ((String) ((HashMap) p.f3844f.get(i10)).get("col2Name")) + " - " + ((Map) p.f3845g.get(i10)).get("col2"));
            }
        }
    }

    public p(Context context, ArrayList arrayList) {
        this.f3846d = context;
        e = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final int a() {
        return e.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ae, code lost:
        if (r6.equals(((java.util.Map) e5.p.f3845g.get(e5.p.f3844f.indexOf(r4))).get("col2")) != false) goto L18;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(e5.p.a r5, int r6) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e5.p.d(androidx.recyclerview.widget.RecyclerView$a0, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final RecyclerView.a0 e(RecyclerView recyclerView) {
        return new a(LayoutInflater.from(this.f3846d).inflate(2131492918, (ViewGroup) recyclerView, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final void f(a aVar) {
        aVar.F.setVisibility(0);
    }
}
