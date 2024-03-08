package n3;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public long f5174a;

    /* renamed from: b  reason: collision with root package name */
    public long f5175b;

    /* renamed from: c  reason: collision with root package name */
    public TimeInterpolator f5176c;

    /* renamed from: d  reason: collision with root package name */
    public int f5177d;
    public int e;

    public h(long j7) {
        this.f5176c = null;
        this.f5177d = 0;
        this.e = 1;
        this.f5174a = j7;
        this.f5175b = 150;
    }

    public h(long j7, long j8, TimeInterpolator timeInterpolator) {
        this.f5177d = 0;
        this.e = 1;
        this.f5174a = j7;
        this.f5175b = j8;
        this.f5176c = timeInterpolator;
    }

    public final void a(Animator animator) {
        animator.setStartDelay(this.f5174a);
        animator.setDuration(this.f5175b);
        animator.setInterpolator(b());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(this.f5177d);
            valueAnimator.setRepeatMode(this.e);
        }
    }

    public final TimeInterpolator b() {
        TimeInterpolator timeInterpolator = this.f5176c;
        return timeInterpolator != null ? timeInterpolator : a.f5162b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f5174a == hVar.f5174a && this.f5175b == hVar.f5175b && this.f5177d == hVar.f5177d && this.e == hVar.e) {
            return b().getClass().equals(hVar.b().getClass());
        }
        return false;
    }

    public final int hashCode() {
        long j7 = this.f5174a;
        long j8 = this.f5175b;
        return ((((b().getClass().hashCode() + (((((int) (j7 ^ (j7 >>> 32))) * 31) + ((int) ((j8 >>> 32) ^ j8))) * 31)) * 31) + this.f5177d) * 31) + this.e;
    }

    public final String toString() {
        return '\n' + h.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + this.f5174a + " duration: " + this.f5175b + " interpolator: " + b().getClass() + " repeatCount: " + this.f5177d + " repeatMode: " + this.e + "}\n";
    }
}
