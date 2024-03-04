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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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

    public static String g(long j5) {
        long j7 = j5 / 3600000;
        long j8 = (j5 % 3600000) / 60000;
        long j9 = (j5 % 60000) / 1000;
        return j7 > 0 ? String.format("%02d:%02d:%02d", Long.valueOf(j7), Long.valueOf(j8), Long.valueOf(j9)) : String.format("%02d:%02d", Long.valueOf(j8), Long.valueOf(j9));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final int a() {
        TextView textView = FileManagerItemActivity.M;
        textView.setText(f3796i.size() + "");
        return f3796i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public final void d(a aVar, final int i7) {
        String str;
        String extractMetadata;
        final a aVar2 = aVar;
        final HashMap<String, String> hashMap = f3796i.get(i7);
        aVar2.f3803v.setText(hashMap.get("col1Size"));
        aVar2.f3804w.setText(hashMap.get("col1Date"));
        aVar2.f3805x.setText(hashMap.get("col1Name"));
        TextView textView = aVar2.f3806y;
        Context context = this.f3798d;
        Uri parse = Uri.parse(hashMap.get("col1Path"));
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
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
                    aVar2.f3802u.setOnClickListener(new View.OnClickListener() { // from class: e5.a
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            MediaPlayer mediaPlayer;
                            final g gVar = g.this;
                            int i8 = i7;
                            HashMap hashMap2 = hashMap;
                            g.a aVar3 = aVar2;
                            gVar.getClass();
                            ImageView imageView = aVar3.f3802u;
                            final WaveformSeekBar waveformSeekBar = aVar3.f3807z;
                            if (i8 == gVar.f3799f && (mediaPlayer = gVar.e) != null) {
                                if (mediaPlayer.isPlaying()) {
                                    MediaPlayer mediaPlayer2 = gVar.e;
                                    if (mediaPlayer2 == null || !mediaPlayer2.isPlaying()) {
                                        return;
                                    }
                                    gVar.e.pause();
                                    gVar.f3800g.setImageResource(2131165460);
                                    return;
                                }
                                MediaPlayer mediaPlayer3 = gVar.e;
                                if (mediaPlayer3 != null) {
                                    mediaPlayer3.start();
                                    gVar.f3800g.setImageResource(2131165451);
                                    gVar.i(gVar.f3801h);
                                    return;
                                }
                                return;
                            }
                            String str2 = (String) hashMap2.get("col1Path");
                            gVar.h();
                            MediaPlayer mediaPlayer4 = new MediaPlayer();
                            gVar.e = mediaPlayer4;
                            try {
                                mediaPlayer4.setDataSource(gVar.f3798d, Uri.parse(str2));
                                gVar.e.prepare();
                                gVar.e.start();
                                gVar.e.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: e5.c
                                    @Override // android.media.MediaPlayer.OnCompletionListener
                                    public final void onCompletion(MediaPlayer mediaPlayer5) {
                                        g.this.h();
                                    }
                                });
                                gVar.f3799f = i8;
                                gVar.f3800g = imageView;
                                waveformSeekBar.setMaxProgress(gVar.e.getDuration());
                                gVar.f3801h = waveformSeekBar;
                                imageView.setImageResource(2131165451);
                                gVar.i(waveformSeekBar);
                                gVar.e.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: e5.d
                                    @Override // android.media.MediaPlayer.OnSeekCompleteListener
                                    public final void onSeekComplete(MediaPlayer mediaPlayer5) {
                                        g gVar2 = g.this;
                                        WaveformSeekBar waveformSeekBar2 = waveformSeekBar;
                                        if (gVar2.e.isPlaying()) {
                                            gVar2.i(waveformSeekBar2);
                                        }
                                    }
                                });
                            } catch (IOException e82) {
                                e82.printStackTrace();
                            }
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
            }
            try {
                mediaMetadataRetriever.release();
                str = "Unknown";
                textView.setText(str);
                aVar2.f3807z.setSampleFrom(hashMap.get("col1Path"));
                aVar2.f3802u.setOnClickListener(new View.OnClickListener() { // from class: e5.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MediaPlayer mediaPlayer;
                        final g gVar = g.this;
                        int i8 = i7;
                        HashMap hashMap2 = hashMap;
                        g.a aVar3 = aVar2;
                        gVar.getClass();
                        ImageView imageView = aVar3.f3802u;
                        final WaveformSeekBar waveformSeekBar = aVar3.f3807z;
                        if (i8 == gVar.f3799f && (mediaPlayer = gVar.e) != null) {
                            if (mediaPlayer.isPlaying()) {
                                MediaPlayer mediaPlayer2 = gVar.e;
                                if (mediaPlayer2 == null || !mediaPlayer2.isPlaying()) {
                                    return;
                                }
                                gVar.e.pause();
                                gVar.f3800g.setImageResource(2131165460);
                                return;
                            }
                            MediaPlayer mediaPlayer3 = gVar.e;
                            if (mediaPlayer3 != null) {
                                mediaPlayer3.start();
                                gVar.f3800g.setImageResource(2131165451);
                                gVar.i(gVar.f3801h);
                                return;
                            }
                            return;
                        }
                        String str2 = (String) hashMap2.get("col1Path");
                        gVar.h();
                        MediaPlayer mediaPlayer4 = new MediaPlayer();
                        gVar.e = mediaPlayer4;
                        try {
                            mediaPlayer4.setDataSource(gVar.f3798d, Uri.parse(str2));
                            gVar.e.prepare();
                            gVar.e.start();
                            gVar.e.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: e5.c
                                @Override // android.media.MediaPlayer.OnCompletionListener
                                public final void onCompletion(MediaPlayer mediaPlayer5) {
                                    g.this.h();
                                }
                            });
                            gVar.f3799f = i8;
                            gVar.f3800g = imageView;
                            waveformSeekBar.setMaxProgress(gVar.e.getDuration());
                            gVar.f3801h = waveformSeekBar;
                            imageView.setImageResource(2131165451);
                            gVar.i(waveformSeekBar);
                            gVar.e.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: e5.d
                                @Override // android.media.MediaPlayer.OnSeekCompleteListener
                                public final void onSeekComplete(MediaPlayer mediaPlayer5) {
                                    g gVar2 = g.this;
                                    WaveformSeekBar waveformSeekBar2 = waveformSeekBar;
                                    if (gVar2.e.isPlaying()) {
                                        gVar2.i(waveformSeekBar2);
                                    }
                                }
                            });
                        } catch (IOException e82) {
                            e82.printStackTrace();
                        }
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
            waveformSeekBar.setProgress(mediaPlayer.getCurrentPosition());
            if (this.f3801h == waveformSeekBar && this.e.isPlaying()) {
                new Handler(Looper.getMainLooper()).postDelayed(new f2.c(this, 2, waveformSeekBar), 100L);
            }
        }
    }
}
