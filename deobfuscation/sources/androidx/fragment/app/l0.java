package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import p1.y;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public abstract class l0 {
    public static void d(View view, List list) {
        boolean z6;
        boolean z7;
        int size = list.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size) {
                z6 = false;
                break;
            } else if (list.get(i7) == view) {
                z6 = true;
                break;
            } else {
                i7++;
            }
        }
        if (z6) {
            return;
        }
        WeakHashMap<View, p1.k0> weakHashMap = p1.y.f5540a;
        if (y.i.k(view) != null) {
            list.add(view);
        }
        for (int i8 = size; i8 < list.size(); i8++) {
            View view2 = (View) list.get(i8);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i9 = 0; i9 < childCount; i9++) {
                    View childAt = viewGroup.getChildAt(i9);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= size) {
                            z7 = false;
                            break;
                        } else if (list.get(i10) == childAt) {
                            z7 = true;
                            break;
                        } else {
                            i10++;
                        }
                    }
                    if (!z7 && y.i.k(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    public static void g(View view, Rect rect) {
        WeakHashMap<View, p1.k0> weakHashMap = p1.y.f5540a;
        if (y.g.b(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            ViewParent parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            int[] iArr = new int[2];
            view.getRootView().getLocationOnScreen(iArr);
            rectF.offset(iArr[0], iArr[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public static boolean h(List list) {
        return list == null || list.isEmpty();
    }

    public static ArrayList k(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view = (View) arrayList.get(i7);
            WeakHashMap<View, p1.k0> weakHashMap = p1.y.f5540a;
            arrayList2.add(y.i.k(view));
            y.i.v(view, null);
        }
        return arrayList2;
    }

    public static void q(ViewGroup viewGroup, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, o.b bVar) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i7 = 0; i7 < size; i7++) {
            View view = (View) arrayList.get(i7);
            WeakHashMap<View, p1.k0> weakHashMap = p1.y.f5540a;
            String k6 = y.i.k(view);
            arrayList4.add(k6);
            if (k6 != null) {
                y.i.v(view, null);
                String str = (String) bVar.getOrDefault(k6, null);
                int i8 = 0;
                while (true) {
                    if (i8 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i8))) {
                        y.i.v((View) arrayList2.get(i8), k6);
                        break;
                    } else {
                        i8++;
                    }
                }
            }
        }
        p1.s.a(viewGroup, new k0(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void a(View view, Object obj);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    public abstract Object f(Object obj);

    public abstract Object i(Object obj, Object obj2, Object obj3);

    public abstract Object j(Object obj, Object obj2, Object obj3);

    public abstract void l(Object obj, View view, ArrayList<View> arrayList);

    public abstract void m(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void n(View view, Object obj);

    public abstract void o(Object obj, Rect rect);

    public void p(Object obj, Runnable runnable) {
        runnable.run();
    }

    public abstract void r(Object obj, View view, ArrayList<View> arrayList);

    public abstract void s(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object t(Object obj);
}
