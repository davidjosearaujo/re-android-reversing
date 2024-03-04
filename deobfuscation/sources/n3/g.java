package n3;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a */
    public final o.h<String, h> f5172a = new o.h<>();

    /* renamed from: b */
    public final o.h<String, PropertyValuesHolder[]> f5173b = new o.h<>();

    public static g a(Context context, int i7) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i7);
            if (loadAnimator instanceof AnimatorSet) {
                return b(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(loadAnimator);
                return b(arrayList);
            }
            return null;
        } catch (Exception e) {
            StringBuilder d7 = androidx.activity.h.d("Can't load animation resource ID #0x");
            d7.append(Integer.toHexString(i7));
            Log.w("MotionSpec", d7.toString(), e);
            return null;
        }
    }

    public static g b(ArrayList arrayList) {
        g gVar = new g();
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            Animator animator = (Animator) arrayList.get(i7);
            if (!(animator instanceof ObjectAnimator)) {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            gVar.f5173b.put(objectAnimator.getPropertyName(), objectAnimator.getValues());
            String propertyName = objectAnimator.getPropertyName();
            long startDelay = objectAnimator.getStartDelay();
            long duration = objectAnimator.getDuration();
            TimeInterpolator interpolator = objectAnimator.getInterpolator();
            if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                interpolator = a.f5162b;
            } else if (interpolator instanceof AccelerateInterpolator) {
                interpolator = a.f5163c;
            } else if (interpolator instanceof DecelerateInterpolator) {
                interpolator = a.f5164d;
            }
            h hVar = new h(startDelay, duration, interpolator);
            hVar.f5177d = objectAnimator.getRepeatCount();
            hVar.e = objectAnimator.getRepeatMode();
            gVar.f5172a.put(propertyName, hVar);
        }
        return gVar;
    }

    public final h c(String str) {
        if (this.f5172a.getOrDefault(str, null) != null) {
            return this.f5172a.getOrDefault(str, null);
        }
        throw new IllegalArgumentException();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            return this.f5172a.equals(((g) obj).f5172a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5172a.hashCode();
    }

    public final String toString() {
        return '\n' + g.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f5172a + "}\n";
    }
}
