package cn.jpush.android.r;

import android.os.CountDownTimer;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class n {
    private CountDownTimer a;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface a {
        void a();
    }

    public void a() {
        CountDownTimer countDownTimer = this.a;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.a = null;
        }
    }

    public void a(final a aVar, long j, long j2) {
        this.a = new CountDownTimer(j, j2) { // from class: cn.jpush.android.r.n.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
            }
        }.start();
    }
}
