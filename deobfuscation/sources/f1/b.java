package f1;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import com.tragisoap.fileandpdfmanager.MainActivity;

/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    public static class a extends b {

        /* renamed from: a */
        public final ActivityOptions f4074a;

        public a(ActivityOptions activityOptions) {
            this.f4074a = activityOptions;
        }

        public final Bundle b() {
            return this.f4074a.toBundle();
        }
    }

    /* renamed from: f1.b$b */
    /* loaded from: classes.dex */
    public static class C0056b {
        public static ActivityOptions a(Activity activity, View view, String str) {
            return ActivityOptions.makeSceneTransitionAnimation(activity, view, str);
        }

        @SafeVarargs
        public static ActivityOptions b(Activity activity, Pair<View, String>... pairArr) {
            return ActivityOptions.makeSceneTransitionAnimation(activity, pairArr);
        }

        public static ActivityOptions c() {
            return ActivityOptions.makeTaskLaunchBehind();
        }
    }

    public static a a(MainActivity mainActivity, o1.c... cVarArr) {
        Pair[] pairArr = new Pair[cVarArr.length];
        for (int i7 = 0; i7 < cVarArr.length; i7++) {
            o1.c cVar = cVarArr[i7];
            cVar.getClass();
            cVar.getClass();
            pairArr[i7] = Pair.create(null, null);
        }
        return new a(C0056b.b(mainActivity, pairArr));
    }
}
