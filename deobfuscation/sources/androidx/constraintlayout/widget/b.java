package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.h;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;
import y0.i;

/* loaded from: classes.dex */
public abstract class b extends View {

    /* renamed from: f */
    public int[] f1314f;

    /* renamed from: g */
    public int f1315g;

    /* renamed from: h */
    public Context f1316h;

    /* renamed from: i */
    public i f1317i;

    /* renamed from: j */
    public String f1318j;

    /* renamed from: k */
    public String f1319k;

    /* renamed from: l */
    public View[] f1320l;
    public HashMap<Integer, String> m;

    public b(Context context) {
        super(context);
        this.f1314f = new int[32];
        this.f1320l = null;
        this.m = new HashMap<>();
        this.f1316h = context;
        i(null);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1314f = new int[32];
        this.f1320l = null;
        this.m = new HashMap<>();
        this.f1316h = context;
        i(attributeSet);
    }

    public final void c(String str) {
        HashMap<String, Integer> hashMap;
        if (str == null || str.length() == 0 || this.f1316h == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
            ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
        }
        ConstraintLayout constraintLayout2 = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i7 = 0;
        if (isInEditMode() && constraintLayout2 != null) {
            Integer num = ((trim instanceof String) && (hashMap = constraintLayout2.f1261r) != null && hashMap.containsKey(trim)) ? constraintLayout2.f1261r.get(trim) : null;
            if (num instanceof Integer) {
                i7 = num.intValue();
            }
        }
        if (i7 == 0 && constraintLayout2 != null) {
            i7 = h(constraintLayout2, trim);
        }
        if (i7 == 0) {
            try {
                i7 = b1.d.class.getField(trim).getInt(null);
            } catch (Exception unused) {
            }
        }
        if (i7 == 0) {
            i7 = this.f1316h.getResources().getIdentifier(trim, "id", this.f1316h.getPackageName());
        }
        if (i7 != 0) {
            this.m.put(Integer.valueOf(i7), trim);
            d(i7);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    public final void d(int i7) {
        if (i7 == getId()) {
            return;
        }
        int i8 = this.f1315g + 1;
        int[] iArr = this.f1314f;
        if (i8 > iArr.length) {
            this.f1314f = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f1314f;
        int i9 = this.f1315g;
        iArr2[i9] = i7;
        this.f1315g = i9 + 1;
    }

    public final void e(String str) {
        if (str == null || str.length() == 0 || this.f1316h == null) {
            return;
        }
        String trim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = constraintLayout.getChildAt(i7);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.a) && trim.equals(((ConstraintLayout.a) layoutParams).Y)) {
                if (childAt.getId() == -1) {
                    StringBuilder d7 = h.d("to use ConstraintTag view ");
                    d7.append(childAt.getClass().getSimpleName());
                    d7.append(" must have an ID");
                    Log.w("ConstraintHelper", d7.toString());
                } else {
                    d(childAt.getId());
                }
            }
        }
    }

    public final void f(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i7 = 0; i7 < this.f1315g; i7++) {
            View view = constraintLayout.f1250f.get(this.f1314f[i7]);
            if (view != null) {
                view.setVisibility(visibility);
                if (elevation > 0.0f) {
                    view.setTranslationZ(view.getTranslationZ() + elevation);
                }
            }
        }
    }

    public void g(ConstraintLayout constraintLayout) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1314f, this.f1315g);
    }

    public final int h(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = this.f1316h.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = constraintLayout.getChildAt(i7);
            if (childAt.getId() != -1) {
                String str2 = null;
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public void i(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a0.b.e);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = obtainStyledAttributes.getIndex(i7);
                if (index == 35) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f1318j = string;
                    setIds(string);
                } else if (index == 36) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f1319k = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void j(y0.d dVar, boolean z6) {
    }

    public final void k() {
        if (this.f1317i == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.a) {
            ((ConstraintLayout.a) layoutParams).f1294q0 = this.f1317i;
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f1318j;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f1319k;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i7, int i8) {
        setMeasuredDimension(0, 0);
    }

    public void setIds(String str) {
        this.f1318j = str;
        if (str == null) {
            return;
        }
        int i7 = 0;
        this.f1315g = 0;
        while (true) {
            int indexOf = str.indexOf(44, i7);
            if (indexOf == -1) {
                c(str.substring(i7));
                return;
            } else {
                c(str.substring(i7, indexOf));
                i7 = indexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        this.f1319k = str;
        if (str == null) {
            return;
        }
        int i7 = 0;
        this.f1315g = 0;
        while (true) {
            int indexOf = str.indexOf(44, i7);
            if (indexOf == -1) {
                e(str.substring(i7));
                return;
            } else {
                e(str.substring(i7, indexOf));
                i7 = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f1318j = null;
        this.f1315g = 0;
        for (int i7 : iArr) {
            d(i7);
        }
    }

    @Override // android.view.View
    public final void setTag(int i7, Object obj) {
        super.setTag(i7, obj);
        if (obj == null && this.f1318j == null) {
            d(i7);
        }
    }
}
