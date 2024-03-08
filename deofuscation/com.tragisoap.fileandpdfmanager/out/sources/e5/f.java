package e5;

import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;
import com.masoudss.lib.WaveformSeekBar;
import e5.g;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f implements View.OnTouchListener {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ g.a f3794f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ g f3795g;

    public f(g gVar, g.a aVar) {
        this.f3795g = gVar;
        this.f3794f = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        MediaPlayer mediaPlayer;
        g gVar;
        MediaPlayer mediaPlayer2;
        g gVar2 = this.f3795g;
        WaveformSeekBar waveformSeekBar = gVar2.f3801h;
        if (waveformSeekBar == null || waveformSeekBar != this.f3794f.f3807z || (mediaPlayer = gVar2.e) == null || !mediaPlayer.isPlaying() || (mediaPlayer2 = (gVar = this.f3795g).e) == null || !mediaPlayer2.isPlaying()) {
            return false;
        }
        gVar.e.pause();
        gVar.f3800g.setImageResource(2131165460);
        return false;
    }
}
