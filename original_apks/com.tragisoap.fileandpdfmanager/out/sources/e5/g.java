package e5;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.masoudss.lib.WaveformSeekBar;
import com.tragisoap.fileandpdfmanager.FileManagerItemActivity;
import e5.g;
import f2.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g extends RecyclerView.d<a> {

    /* renamed from: i */
    public static List<HashMap<String, String>> f3796i;

    /* renamed from: j */
    public static ArrayList f3797j = new ArrayList();

    /* renamed from: d */
    public Context f3798d;
    public MediaPlayer e;

    /* renamed from: f */
    public int f3799f = -1;

    /* renamed from: g */
    public ImageView f3800g;

    /* renamed from: h */
    public WaveformSeekBar f3801h;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends RecyclerView.a0 {
        public CheckBox A;

        /* renamed from: u */
        public ImageView f3802u;

        /* renamed from: v */
        public TextView f3803v;

        /* renamed from: w */
        public TextView f3804w;

        /* renamed from: x */
        public TextView f3805x;

        /* renamed from: y */
        public TextView f3806y;

        /* renamed from: z */
        public WaveformSeekBar f3807z;

        public a(View view) {
            super(view);
            this.f3802u = (ImageView) view.findViewById(2131296536);
            this.f3805x = (TextView) view.findViewById(2131296654);
            this.f3803v = (TextView) view.findViewById(2131296787);
            this.f3804w = (TextView) view.findViewById(2131296416);
            this.f3806y = (TextView) view.findViewById(2131296859);
            this.f3807z = (WaveformSeekBar) view.findViewById(2131296921);
            this.A = (CheckBox) view.findViewById(2131296382);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(2131296260);
        }
    }

    public g(Context context, ArrayList arrayList) {
        this.f3798d = context;
        f3796i = arrayList;
    }

    public static String g(long j7) {
        long j8 = j7 / 3600000;
        long j9 = (j7 % 3600000) / 60000;
        long j10 = (j7 % 60000) / 1000;
        return j8 > 0 ? String.format("%02d:%02d:%02d", Long.valueOf(j8), Long.valueOf(j9), Long.valueOf(j10)) : String.format("%02d:%02d", Long.valueOf(j9), Long.valueOf(j10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final int a() {
        TextView textView = FileManagerItemActivity.M;
        textView.setText(f3796i.size() + "");
        return f3796i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final void d(a aVar, int i7) {
        MediaMetadataRetriever mediaMetadataRetriever;
        String str;
        String extractMetadata;
        try {
            a aVar2 = aVar;
            HashMap<String, String> hashMap = f3796i.get(i7);
            aVar2.f3803v.setText(hashMap.get("col1Size"));
            aVar2.f3804w.setText(hashMap.get("col1Date"));
            aVar2.f3805x.setText(hashMap.get("col1Name"));
            TextView textView = aVar2.f3806y;
            Context context = this.f3798d;
            Uri parse = Uri.parse(hashMap.get("col1Path"));
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(context, parse);
                extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    mediaMetadataRetriever.release();
                } catch (IOException e7) {
                    throw new RuntimeException(e7);
                }
            }
            if (extractMetadata != null) {
                str = g(Long.parseLong(extractMetadata));
                try {
                    mediaMetadataRetriever.release();
                    textView.setText(str);
                    aVar2.f3807z.setSampleFrom(hashMap.get("col1Path"));
                    aVar2.f3802u.setOnClickListener(new View.OnClickListener(i7, hashMap, aVar2) { // from class: e5.a

                        /* renamed from: g  reason: collision with root package name */
                        public final /* synthetic */ int f3784g;

                        /* renamed from: h  reason: collision with root package name */
                        public final /* synthetic */ HashMap f3785h;

                        /* renamed from: i  reason: collision with root package name */
                        public final /* synthetic */ g.a f3786i;

                        {
                            this.f3784g = r2;
                            this.f3785h = r3;
                            this.f3786i = r4;
                        }

                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0076: INVOKE  
                              (wrap: android.media.MediaPlayer : 0x006f: IGET  (r1v6 android.media.MediaPlayer A[REMOVE]) = (r7v1 'gVar' e5.g) e5.g.e android.media.MediaPlayer)
                              (wrap: e5.c : 0x0073: CONSTRUCTOR  (r3v3 e5.c A[REMOVE]) = (r7v1 'gVar' e5.g) call: e5.c.<init>(e5.g):void type: CONSTRUCTOR)
                             type: VIRTUAL call: android.media.MediaPlayer.setOnCompletionListener(android.media.MediaPlayer$OnCompletionListener):void in method: e5.a.onClick(android.view.View):void, file: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:301)
                            	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:122)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:266)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:259)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: e5.c, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:290)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:987)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:798)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                            	... 21 more
                            */
                        @Override // android.view.View.OnClickListener
                        public final void onClick(android.view.View r7) {
                            /*
                                r6 = this;
                                e5.g r7 = e5.g.this
                                int r0 = r6.f3784g
                                java.util.HashMap r1 = r6.f3785h
                                e5.g$a r6 = r6.f3786i
                                r7.getClass()
                                android.widget.ImageView r2 = r6.f3802u
                                com.masoudss.lib.WaveformSeekBar r6 = r6.f3807z
                                int r3 = r7.f3799f
                                r4 = 2131165451(0x7f07010b, float:1.794512E38)
                                if (r0 != r3) goto L_0x004a
                                android.media.MediaPlayer r3 = r7.e
                                if (r3 == 0) goto L_0x004a
                                boolean r6 = r3.isPlaying()
                                if (r6 == 0) goto L_0x0038
                                android.media.MediaPlayer r6 = r7.e
                                if (r6 == 0) goto L_0x009e
                                boolean r6 = r6.isPlaying()
                                if (r6 == 0) goto L_0x009e
                                android.media.MediaPlayer r6 = r7.e
                                r6.pause()
                                android.widget.ImageView r6 = r7.f3800g
                                r7 = 2131165460(0x7f070114, float:1.7945138E38)
                                r6.setImageResource(r7)
                                goto L_0x009e
                            L_0x0038:
                                android.media.MediaPlayer r6 = r7.e
                                if (r6 == 0) goto L_0x009e
                                r6.start()
                                android.widget.ImageView r6 = r7.f3800g
                                r6.setImageResource(r4)
                                com.masoudss.lib.WaveformSeekBar r6 = r7.f3801h
                                r7.i(r6)
                                goto L_0x009e
                            L_0x004a:
                                java.lang.String r3 = "col1Path"
                                java.lang.Object r1 = r1.get(r3)
                                java.lang.String r1 = (java.lang.String) r1
                                r7.h()
                                android.media.MediaPlayer r3 = new android.media.MediaPlayer
                                r3.<init>()
                                r7.e = r3
                                android.content.Context r5 = r7.f3798d     // Catch: IOException -> 0x009a
                                android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: IOException -> 0x009a
                                r3.setDataSource(r5, r1)     // Catch: IOException -> 0x009a
                                android.media.MediaPlayer r1 = r7.e     // Catch: IOException -> 0x009a
                                r1.prepare()     // Catch: IOException -> 0x009a
                                android.media.MediaPlayer r1 = r7.e     // Catch: IOException -> 0x009a
                                r1.start()     // Catch: IOException -> 0x009a
                                android.media.MediaPlayer r1 = r7.e     // Catch: IOException -> 0x009a
                                e5.c r3 = new e5.c     // Catch: IOException -> 0x009a
                                r3.<init>(r7)     // Catch: IOException -> 0x009a
                                r1.setOnCompletionListener(r3)     // Catch: IOException -> 0x009a
                                r7.f3799f = r0     // Catch: IOException -> 0x009a
                                r7.f3800g = r2     // Catch: IOException -> 0x009a
                                android.media.MediaPlayer r0 = r7.e     // Catch: IOException -> 0x009a
                                int r0 = r0.getDuration()     // Catch: IOException -> 0x009a
                                float r0 = (float) r0     // Catch: IOException -> 0x009a
                                r6.setMaxProgress(r0)     // Catch: IOException -> 0x009a
                                r7.f3801h = r6     // Catch: IOException -> 0x009a
                                r2.setImageResource(r4)     // Catch: IOException -> 0x009a
                                r7.i(r6)     // Catch: IOException -> 0x009a
                                android.media.MediaPlayer r0 = r7.e     // Catch: IOException -> 0x009a
                                e5.d r1 = new e5.d     // Catch: IOException -> 0x009a
                                r1.<init>(r7, r6)     // Catch: IOException -> 0x009a
                                r0.setOnSeekCompleteListener(r1)     // Catch: IOException -> 0x009a
                                goto L_0x009e
                            L_0x009a:
                                r6 = move-exception
                                r6.printStackTrace()
                            L_0x009e:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: e5.a.onClick(android.view.View):void");
                        }
                    });
                    aVar2.f3807z.setOnProgressChanged(new e(this));
                    aVar2.f3807z.setOnTouchListener(new f(this, aVar2));
                    aVar2.A.setOnClickListener(new b(hashMap, aVar2));
                    aVar2.A.setChecked(f3797j.contains(hashMap));
                    aVar2.f2005a.setOnClickListener(new i4.a(3, aVar2));
                } catch (IOException e8) {
                    throw new RuntimeException(e8);
                }
            } else {
                try {
                    mediaMetadataRetriever.release();
                    str = "Unknown";
                    textView.setText(str);
                    aVar2.f3807z.setSampleFrom(hashMap.get("col1Path"));
                    aVar2.f3802u.setOnClickListener(new View.OnClickListener(i7, hashMap, aVar2) { // from class: e5.a

                        /* renamed from: g  reason: collision with root package name */
                        public final /* synthetic */ int f3784g;

                        /* renamed from: h  reason: collision with root package name */
                        public final /* synthetic */ HashMap f3785h;

                        /* renamed from: i  reason: collision with root package name */
                        public final /* synthetic */ g.a f3786i;

                        {
                            this.f3784g = r2;
                            this.f3785h = r3;
                            this.f3786i = r4;
                        }

                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0076: INVOKE  
                              (wrap: android.media.MediaPlayer : 0x006f: IGET  (r1v6 android.media.MediaPlayer A[REMOVE]) = (r7v1 'gVar' e5.g) e5.g.e android.media.MediaPlayer)
                              (wrap: e5.c : 0x0073: CONSTRUCTOR  (r3v3 e5.c A[REMOVE]) = (r7v1 'gVar' e5.g) call: e5.c.<init>(e5.g):void type: CONSTRUCTOR)
                             type: VIRTUAL call: android.media.MediaPlayer.setOnCompletionListener(android.media.MediaPlayer$OnCompletionListener):void in method: e5.a.onClick(android.view.View):void, file: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:301)
                            	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:122)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:266)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:259)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: e5.c, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:290)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:987)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:798)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                            	... 20 more
                            */
                        @Override // android.view.View.OnClickListener
                        public final void onClick(android.view.View r7) {
                            /*
                                r6 = this;
                                e5.g r7 = e5.g.this
                                int r0 = r6.f3784g
                                java.util.HashMap r1 = r6.f3785h
                                e5.g$a r6 = r6.f3786i
                                r7.getClass()
                                android.widget.ImageView r2 = r6.f3802u
                                com.masoudss.lib.WaveformSeekBar r6 = r6.f3807z
                                int r3 = r7.f3799f
                                r4 = 2131165451(0x7f07010b, float:1.794512E38)
                                if (r0 != r3) goto L_0x004a
                                android.media.MediaPlayer r3 = r7.e
                                if (r3 == 0) goto L_0x004a
                                boolean r6 = r3.isPlaying()
                                if (r6 == 0) goto L_0x0038
                                android.media.MediaPlayer r6 = r7.e
                                if (r6 == 0) goto L_0x009e
                                boolean r6 = r6.isPlaying()
                                if (r6 == 0) goto L_0x009e
                                android.media.MediaPlayer r6 = r7.e
                                r6.pause()
                                android.widget.ImageView r6 = r7.f3800g
                                r7 = 2131165460(0x7f070114, float:1.7945138E38)
                                r6.setImageResource(r7)
                                goto L_0x009e
                            L_0x0038:
                                android.media.MediaPlayer r6 = r7.e
                                if (r6 == 0) goto L_0x009e
                                r6.start()
                                android.widget.ImageView r6 = r7.f3800g
                                r6.setImageResource(r4)
                                com.masoudss.lib.WaveformSeekBar r6 = r7.f3801h
                                r7.i(r6)
                                goto L_0x009e
                            L_0x004a:
                                java.lang.String r3 = "col1Path"
                                java.lang.Object r1 = r1.get(r3)
                                java.lang.String r1 = (java.lang.String) r1
                                r7.h()
                                android.media.MediaPlayer r3 = new android.media.MediaPlayer
                                r3.<init>()
                                r7.e = r3
                                android.content.Context r5 = r7.f3798d     // Catch: IOException -> 0x009a
                                android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: IOException -> 0x009a
                                r3.setDataSource(r5, r1)     // Catch: IOException -> 0x009a
                                android.media.MediaPlayer r1 = r7.e     // Catch: IOException -> 0x009a
                                r1.prepare()     // Catch: IOException -> 0x009a
                                android.media.MediaPlayer r1 = r7.e     // Catch: IOException -> 0x009a
                                r1.start()     // Catch: IOException -> 0x009a
                                android.media.MediaPlayer r1 = r7.e     // Catch: IOException -> 0x009a
                                e5.c r3 = new e5.c     // Catch: IOException -> 0x009a
                                r3.<init>(r7)     // Catch: IOException -> 0x009a
                                r1.setOnCompletionListener(r3)     // Catch: IOException -> 0x009a
                                r7.f3799f = r0     // Catch: IOException -> 0x009a
                                r7.f3800g = r2     // Catch: IOException -> 0x009a
                                android.media.MediaPlayer r0 = r7.e     // Catch: IOException -> 0x009a
                                int r0 = r0.getDuration()     // Catch: IOException -> 0x009a
                                float r0 = (float) r0     // Catch: IOException -> 0x009a
                                r6.setMaxProgress(r0)     // Catch: IOException -> 0x009a
                                r7.f3801h = r6     // Catch: IOException -> 0x009a
                                r2.setImageResource(r4)     // Catch: IOException -> 0x009a
                                r7.i(r6)     // Catch: IOException -> 0x009a
                                android.media.MediaPlayer r0 = r7.e     // Catch: IOException -> 0x009a
                                e5.d r1 = new e5.d     // Catch: IOException -> 0x009a
                                r1.<init>(r7, r6)     // Catch: IOException -> 0x009a
                                r0.setOnSeekCompleteListener(r1)     // Catch: IOException -> 0x009a
                                goto L_0x009e
                            L_0x009a:
                                r6 = move-exception
                                r6.printStackTrace()
                            L_0x009e:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: e5.a.onClick(android.view.View):void");
                        }
                    });
                    aVar2.f3807z.setOnProgressChanged(new e(this));
                    aVar2.f3807z.setOnTouchListener(new f(this, aVar2));
                    aVar2.A.setOnClickListener(new b(hashMap, aVar2));
                    aVar2.A.setChecked(f3797j.contains(hashMap));
                    aVar2.f2005a.setOnClickListener(new i4.a(3, aVar2));
                } catch (IOException e9) {
                    throw new RuntimeException(e9);
                }
            }
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
                throw th;
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final RecyclerView.a0 e(RecyclerView recyclerView) {
        return new a(LayoutInflater.from(recyclerView.getContext()).inflate(2131492917, (ViewGroup) recyclerView, false));
    }

    public final void h() {
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.e = null;
            ImageView imageView = this.f3800g;
            if (imageView != null) {
                imageView.setImageResource(2131165460);
            }
            WaveformSeekBar waveformSeekBar = this.f3801h;
            if (waveformSeekBar != null) {
                waveformSeekBar.setProgress(0.0f);
            }
            this.f3799f = -1;
        }
    }

    public final void i(WaveformSeekBar waveformSeekBar) {
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer != null) {
            waveformSeekBar.setProgress((float) mediaPlayer.getCurrentPosition());
            if (this.f3801h == waveformSeekBar && this.e.isPlaying()) {
                new Handler(Looper.getMainLooper()).postDelayed(new c(this, 2, waveformSeekBar), 100);
            }
        }
    }
}
