package com.facebook.fresco.animation.drawable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface AnimationListener {
    void onAnimationFrame(AnimatedDrawable2 animatedDrawable2, int i);

    void onAnimationRepeat(AnimatedDrawable2 animatedDrawable2);

    void onAnimationReset(AnimatedDrawable2 animatedDrawable2);

    void onAnimationStart(AnimatedDrawable2 animatedDrawable2);

    void onAnimationStop(AnimatedDrawable2 animatedDrawable2);
}
