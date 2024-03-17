package cn.jpush.android.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.u.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class e {

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface a {
        void a();
    }

    private static Point a(Context context, int i, View view) {
        if (view != null) {
            view.measure(-2, -2);
            Logger.d("InAppAnimator", "animation getPoint, viewWidth: 290, viewHeight: 420, startPos: " + i);
            if (i == 0) {
                return new Point(0, 420);
            }
            if (i == 1) {
                return new Point(-290, 0);
            }
            if (i == 2) {
                return new Point(290, 0);
            }
            if (i == 3) {
                return new Point(0, -420);
            }
        }
        return new Point(0, -420);
    }

    public static void a(Context context, final View view, int i, final long j, final a aVar) {
        if (context == null || view == null) {
            return;
        }
        try {
            view.setAlpha(0.0f);
            Point a2 = a(context, i, view);
            Logger.i("InAppAnimator", "[slideIntoView] start position, point: " + a2.toString() + ", showElapseTime: " + j);
            view.animate().translationX((float) a2.x).translationY((float) a2.y).setDuration(10L).setListener(new AnimatorListenerAdapter() { // from class: cn.jpush.android.r.e.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    view.animate().translationX(0.0f).translationY(0.0f).alpha(1.0f).setDuration(j).setListener(null);
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            });
        } catch (Throwable th) {
            Logger.w("InAppAnimator", "in-app message slideIntoView error. " + th.getMessage());
        }
    }

    private static void a(Context context, View view, int i, WindowManager windowManager) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i;
            Logger.d("InAppAnimator", "setViewGroupHeigthStart:" + layoutParams.height);
            view.setLayoutParams(layoutParams);
            windowManager.updateViewLayout(view, layoutParams);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void a(Context context, final View view, AnimatorListenerAdapter animatorListenerAdapter, List<List<a.b.C0019a>> list) {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        int i = cn.jpush.android.ac.i.a(context).widthPixels;
        int i2 = 0;
        while (i2 < list.size()) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            ArrayList arrayList2 = new ArrayList();
            List<a.b.C0019a> list2 = list.get(i2);
            Logger.d("InAppAnimator", "inAnimatorVals.size():" + list2.size());
            int i3 = 0;
            while (i3 < list2.size()) {
                a.b.C0019a c0019a = list2.get(i3);
                String trim = c0019a.a.trim();
                List<Float> list3 = c0019a.b;
                int size = list3.size();
                float[] fArr = new float[size];
                List<a.b.C0019a> list4 = list2;
                for (int i4 = 0; i4 < list3.size(); i4++) {
                    fArr[i4] = list3.get(i4).floatValue();
                }
                if ("translationY".equals(trim) || "translationX".equals(trim) || "width".equals(trim) || "height".equals(trim)) {
                    int i5 = 0;
                    while (i5 < size) {
                        fArr[i5] = (fArr[i5] * i) / 100.0f;
                        i5++;
                        size = size;
                    }
                }
                AnimatorSet animatorSet3 = animatorSet;
                ArrayList arrayList3 = arrayList;
                long j = c0019a.c;
                StringBuilder sb = new StringBuilder();
                int i6 = i;
                sb.append("type:");
                sb.append(trim);
                Logger.d("InAppAnimator", sb.toString());
                Logger.d("InAppAnimator", "duration:" + j);
                Logger.d("InAppAnimator", "valuesP:" + Arrays.toString(fArr));
                if ("width".equals(trim)) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
                    ofFloat.setDuration(j);
                    animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: cn.jpush.android.r.e.5
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            layoutParams.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            view.setLayoutParams(layoutParams);
                        }
                    };
                    objectAnimator2 = ofFloat;
                } else if ("height".equals(trim)) {
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(fArr);
                    ofFloat2.setDuration(j);
                    animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: cn.jpush.android.r.e.6
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            view.setLayoutParams(layoutParams);
                        }
                    };
                    objectAnimator2 = ofFloat2;
                } else {
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, trim, fArr);
                    ofFloat3.setDuration(j);
                    objectAnimator = ofFloat3;
                    arrayList2.add(objectAnimator);
                    i3++;
                    animatorSet = animatorSet3;
                    arrayList = arrayList3;
                    list2 = list4;
                    i = i6;
                }
                objectAnimator2.addUpdateListener(animatorUpdateListener);
                objectAnimator = objectAnimator2;
                arrayList2.add(objectAnimator);
                i3++;
                animatorSet = animatorSet3;
                arrayList = arrayList3;
                list2 = list4;
                i = i6;
            }
            ArrayList arrayList4 = arrayList;
            animatorSet2.playTogether(arrayList2);
            arrayList4.add(animatorSet2);
            i2++;
            arrayList = arrayList4;
            animatorSet = animatorSet;
        }
        AnimatorSet animatorSet4 = animatorSet;
        animatorSet4.addListener(animatorListenerAdapter);
        animatorSet4.playSequentially(arrayList);
        animatorSet4.start();
    }

    public static void a(final Context context, View view, final View view2, final a aVar, final WindowManager windowManager) {
        if (context == null || view == null) {
            return;
        }
        try {
            final boolean z = context.getResources().getConfiguration().orientation == 2;
            List<List<a.b.C0019a>> b = d.b(context, z);
            a(context, view2, d.d(context, z), windowManager);
            a(context, view, new AnimatorListenerAdapter() { // from class: cn.jpush.android.r.e.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    Logger.d("InAppAnimator", "slideOutOfViewNotification onAnimationEnd:");
                    a aVar2 = a.this;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                    e.b(context, view2, d.f(context, z), windowManager, true);
                }
            }, b);
        } catch (Throwable th) {
            Logger.w("InAppAnimator", "in-app message slideOutOfViewNotification error. " + th.getMessage());
        }
    }

    public static void a(final Context context, View view, final View view2, final a aVar, final WindowManager windowManager, boolean z) {
        try {
            Logger.d("InAppAnimator", "slideIntoViewNotification");
            if (context == null || view == null) {
                return;
            }
            boolean z2 = context.getResources().getConfiguration().orientation == 2;
            List<List<a.b.C0019a>> a2 = d.a(context, z2);
            final boolean z3 = z2;
            AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: cn.jpush.android.r.e.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Logger.d("InAppAnimator", "slideIntoViewNotification onAnimationEnd:");
                    super.onAnimationEnd(animator);
                    a aVar2 = a.this;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                    e.b(context, view2, d.e(context, z3), windowManager, false);
                }
            };
            a(context, view2, d.c(context, z2), windowManager);
            a(context, view, animatorListenerAdapter, a2);
            List<Long> a3 = d.a(context);
            if (z) {
                a(context, a3);
            }
        } catch (Throwable th) {
            Logger.w("InAppAnimator", "in-app message slideIntoViewNotification error. " + th.getMessage());
        }
    }

    @SuppressLint({"MissingPermission"})
    private static void a(Context context, List<Long> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        long[] jArr = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            jArr[i] = list.get(i).longValue();
        }
        vibrator.vibrate(jArr, -1);
    }

    public static void b(Context context, View view, int i, long j, final a aVar) {
        if (context == null || view == null) {
            return;
        }
        try {
            Point a2 = a(context, i, view);
            view.animate().translationX(a2.x).translationY(a2.y).setDuration(j).setListener(new AnimatorListenerAdapter() { // from class: cn.jpush.android.r.e.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a aVar2 = a.this;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            });
        } catch (Throwable th) {
            Logger.w("InAppAnimator", "in-app message slideOutOfView error. " + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, View view, int i, WindowManager windowManager, boolean z) {
        if (view == null || z) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        Logger.d("InAppAnimator", "setViewGroupHeigthLast:" + layoutParams.height);
        view.setLayoutParams(layoutParams);
        windowManager.updateViewLayout(view, layoutParams);
    }
}
