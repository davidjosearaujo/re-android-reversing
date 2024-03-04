package e5;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.recyclerview.widget.RecyclerView;
import com.tragisoap.fileandpdfmanager.FileManagerItemActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ozaydin.serkan.com.image_zoom_view.ImageViewZoom;

/* loaded from: classes.dex */
public final class v extends RecyclerView.d<a> {
    public static List<HashMap<String, String>> e;

    /* renamed from: f */
    public static ArrayList f3860f = new ArrayList();

    /* renamed from: g */
    public static ArrayList f3861g = new ArrayList();

    /* renamed from: d */
    public Context f3862d;

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
        public TextView f3863u;

        /* renamed from: v */
        public TextView f3864v;

        /* renamed from: w */
        public TextView f3865w;

        /* renamed from: x */
        public TextView f3866x;

        /* renamed from: y */
        public TextView f3867y;

        /* renamed from: z */
        public TextView f3868z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            v.this = r3;
            this.f3863u = (TextView) view.findViewById(2131296416);
            this.f3864v = (TextView) view.findViewById(2131296417);
            this.f3865w = (TextView) view.findViewById(2131296654);
            this.f3866x = (TextView) view.findViewById(2131296655);
            this.f3867y = (TextView) view.findViewById(2131296787);
            this.f3868z = (TextView) view.findViewById(2131296788);
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
            this.G.setVisibility(0);
            this.H.setVisibility(0);
            this.E.setBackgroundTintList(ColorStateList.valueOf(r3.f3862d.getColor(2131034141)));
            this.F.setBackgroundTintList(ColorStateList.valueOf(r3.f3862d.getColor(2131034141)));
        }

        public static void q(a aVar, String str) {
            aVar.getClass();
            Dialog dialog = new Dialog(v.this.f3862d);
            dialog.getWindow().setBackgroundDrawableResource(17170445);
            View inflate = LayoutInflater.from(v.this.f3862d).inflate(2131492985, (ViewGroup) null);
            inflate.setVisibility(4);
            dialog.setContentView(inflate);
            dialog.getWindow().getAttributes().windowAnimations = 2131886371;
            ((Button) inflate.findViewById(2131296364)).setOnClickListener(new t(dialog));
            dialog.create();
            VideoView videoView = (VideoView) inflate.findViewById(2131296903);
            videoView.setVideoPath(str);
            MediaController mediaController = new MediaController(v.this.f3862d);
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);
            videoView.start();
            new Handler().postDelayed(new u(inflate), 300L);
            dialog.show();
        }

        public final void r(CheckBox checkBox, CheckBox checkBox2, HashMap<String, String> hashMap, int i7) {
            HashMap hashMap2;
            Boolean bool;
            HashMap hashMap3;
            Boolean bool2;
            if (i7 == 1) {
                if (!checkBox.isChecked()) {
                    if (Boolean.TRUE.equals(((Map) v.f3861g.get(v.f3860f.indexOf(hashMap))).get("col2"))) {
                        ArrayList arrayList = v.f3860f;
                        arrayList.set(arrayList.indexOf(hashMap), hashMap);
                        hashMap2 = new HashMap();
                        bool2 = Boolean.FALSE;
                    }
                    v.f3861g.remove(v.f3860f.indexOf(hashMap));
                    v.f3860f.remove(hashMap);
                } else if (v.f3860f.contains(hashMap)) {
                    ArrayList arrayList2 = v.f3860f;
                    arrayList2.set(arrayList2.indexOf(hashMap), hashMap);
                    hashMap2 = new HashMap();
                    bool2 = Boolean.TRUE;
                } else {
                    v.f3860f.add(hashMap);
                    hashMap3 = new HashMap();
                    hashMap3.put("col1", Boolean.TRUE);
                    hashMap3.put("col2", Boolean.FALSE);
                    v.f3861g.add(hashMap3);
                }
                hashMap2.put("col1", bool2);
                hashMap2.put("col2", (Boolean) ((Map) v.f3861g.get(v.f3860f.indexOf(hashMap))).get("col2"));
                v.f3861g.set(v.f3860f.indexOf(hashMap), hashMap2);
            } else {
                if (!checkBox2.isChecked()) {
                    if (Boolean.TRUE.equals(((Map) v.f3861g.get(v.f3860f.indexOf(hashMap))).get("col1"))) {
                        ArrayList arrayList3 = v.f3860f;
                        arrayList3.set(arrayList3.indexOf(hashMap), hashMap);
                        hashMap2 = new HashMap();
                        bool = Boolean.FALSE;
                    }
                    v.f3861g.remove(v.f3860f.indexOf(hashMap));
                    v.f3860f.remove(hashMap);
                } else if (v.f3860f.contains(hashMap)) {
                    ArrayList arrayList4 = v.f3860f;
                    arrayList4.set(arrayList4.indexOf(hashMap), hashMap);
                    hashMap2 = new HashMap();
                    bool = Boolean.TRUE;
                } else {
                    v.f3860f.add(hashMap);
                    hashMap3 = new HashMap();
                    hashMap3.put("col2", Boolean.TRUE);
                    hashMap3.put("col1", Boolean.FALSE);
                    v.f3861g.add(hashMap3);
                }
                hashMap2.put("col2", bool);
                hashMap2.put("col1", (Boolean) ((Map) v.f3861g.get(v.f3860f.indexOf(hashMap))).get("col1"));
                v.f3861g.set(v.f3860f.indexOf(hashMap), hashMap2);
            }
            TextView textView = FileManagerItemActivity.N;
            StringBuilder sb = new StringBuilder();
            v.this.getClass();
            int i8 = 0;
            for (int i9 = 0; i9 < v.f3861g.size(); i9++) {
                Boolean bool3 = Boolean.TRUE;
                if (bool3.equals(((Map) v.f3861g.get(i9)).get("col1"))) {
                    i8++;
                }
                if (bool3.equals(((Map) v.f3861g.get(i9)).get("col2"))) {
                    i8++;
                }
            }
            FileManagerItemActivity.O.setVisibility(i8 != 0 ? 0 : 8);
            sb.append(i8);
            sb.append("");
            textView.setText(sb.toString());
            for (int i10 = 0; i10 < v.f3860f.size(); i10++) {
                Log.d("Check", ((String) ((HashMap) v.f3860f.get(i10)).get("col1Name")) + " - " + ((Map) v.f3861g.get(i10)).get("col1") + " | " + ((String) ((HashMap) v.f3860f.get(i10)).get("col2Name")) + " - " + ((Map) v.f3861g.get(i10)).get("col2"));
            }
        }
    }

    public v(Context context, ArrayList arrayList) {
        this.f3862d = context;
        e = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final int a() {
        return e.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ae, code lost:
        if (r6.equals(((java.util.Map) e5.v.f3861g.get(e5.v.f3860f.indexOf(r4))).get("col2")) != false) goto L13;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(e5.v.a r5, int r6) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e5.v.d(androidx.recyclerview.widget.RecyclerView$a0, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final RecyclerView.a0 e(RecyclerView recyclerView) {
        return new a(LayoutInflater.from(this.f3862d).inflate(2131492918, (ViewGroup) recyclerView, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final void f(a aVar) {
        aVar.F.setVisibility(0);
    }
}
