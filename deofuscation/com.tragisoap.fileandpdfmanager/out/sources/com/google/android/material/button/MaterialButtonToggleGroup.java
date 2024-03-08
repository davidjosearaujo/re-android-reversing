package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import com.google.android.material.button.MaterialButton;
import d4.n;
import d4.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import k4.i;
import l0.z;
import p1.g;
import p1.k0;
import p1.y;
import q1.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: p */
    public static final /* synthetic */ int f2916p = 0;

    /* renamed from: j */
    public Integer[] f2921j;

    /* renamed from: l */
    public boolean f2923l;
    public boolean m;

    /* renamed from: n */
    public final int f2924n;

    /* renamed from: f */
    public final ArrayList f2917f = new ArrayList();

    /* renamed from: g */
    public final e f2918g = new e();

    /* renamed from: h */
    public final LinkedHashSet<d> f2919h = new LinkedHashSet<>();

    /* renamed from: i */
    public final a f2920i = new a();

    /* renamed from: k */
    public boolean f2922k = false;

    /* renamed from: o */
    public HashSet f2925o = new HashSet();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements Comparator<MaterialButton> {
        public a() {
            MaterialButtonToggleGroup.this = r1;
        }

        @Override // java.util.Comparator
        public final int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            MaterialButton materialButton3 = materialButton;
            MaterialButton materialButton4 = materialButton2;
            int compareTo = Boolean.valueOf(materialButton3.isChecked()).compareTo(Boolean.valueOf(materialButton4.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton3.isPressed()).compareTo(Boolean.valueOf(materialButton4.isPressed()));
            return compareTo2 != 0 ? compareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton3)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton4)));
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b extends p1.a {
        public b() {
            MaterialButtonToggleGroup.this = r1;
        }

        @Override // p1.a
        public final void d(View view, f fVar) {
            int i7;
            this.f5466a.onInitializeAccessibilityNodeInfo(view, fVar.f5624a);
            MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
            int i8 = MaterialButtonToggleGroup.f2916p;
            materialButtonToggleGroup.getClass();
            if (view instanceof MaterialButton) {
                i7 = 0;
                for (int i9 = 0; i9 < materialButtonToggleGroup.getChildCount(); i9++) {
                    if (materialButtonToggleGroup.getChildAt(i9) == view) {
                        break;
                    }
                    if ((materialButtonToggleGroup.getChildAt(i9) instanceof MaterialButton) && materialButtonToggleGroup.d(i9)) {
                        i7++;
                    }
                }
            }
            i7 = -1;
            fVar.j(f.g.a(0, 1, i7, 1, ((MaterialButton) view).isChecked()));
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c {
        public static final k4.a e = new k4.a(0.0f);

        /* renamed from: a */
        public k4.c f2928a;

        /* renamed from: b */
        public k4.c f2929b;

        /* renamed from: c */
        public k4.c f2930c;

        /* renamed from: d */
        public k4.c f2931d;

        public c(k4.c cVar, k4.c cVar2, k4.c cVar3, k4.c cVar4) {
            this.f2928a = cVar;
            this.f2929b = cVar3;
            this.f2930c = cVar4;
            this.f2931d = cVar2;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface d {
        void a();
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class e implements MaterialButton.b {
        public e() {
            MaterialButtonToggleGroup.this = r1;
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        super(q4.a.a(context, attributeSet, 2130903797, 2131887132), attributeSet, 2130903797);
        TypedArray d7 = n.d(getContext(), attributeSet, z.f4926l, 2130903797, 2131887132, new int[0]);
        setSingleSelection(d7.getBoolean(3, false));
        this.f2924n = d7.getResourceId(1, -1);
        this.m = d7.getBoolean(2, false);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(d7.getBoolean(0, true));
        d7.recycle();
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        y.d.s(this, 1);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            if (d(i7)) {
                return i7;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (d(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i7 = 0;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            if ((getChildAt(i8) instanceof MaterialButton) && d(i8)) {
                i7++;
            }
        }
        return i7;
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            materialButton.setId(y.e.a());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f2918g);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public final void a() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex != -1) {
            for (int i7 = firstVisibleChildIndex + 1; i7 < getChildCount(); i7++) {
                MaterialButton c7 = c(i7);
                int min = Math.min(c7.getStrokeWidth(), c(i7 - 1).getStrokeWidth());
                ViewGroup.LayoutParams layoutParams = c7.getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
                if (getOrientation() == 0) {
                    g.g(layoutParams2, 0);
                    g.h(layoutParams2, -min);
                    layoutParams2.topMargin = 0;
                } else {
                    layoutParams2.bottomMargin = 0;
                    layoutParams2.topMargin = -min;
                    g.h(layoutParams2, 0);
                }
                c7.setLayoutParams(layoutParams2);
            }
            if (!(getChildCount() == 0 || firstVisibleChildIndex == -1)) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c(firstVisibleChildIndex).getLayoutParams();
                if (getOrientation() == 1) {
                    layoutParams3.topMargin = 0;
                    layoutParams3.bottomMargin = 0;
                    return;
                }
                g.g(layoutParams3, 0);
                g.h(layoutParams3, 0);
                layoutParams3.leftMargin = 0;
                layoutParams3.rightMargin = 0;
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i7, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i7, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        b(materialButton.getId(), materialButton.isChecked());
        i shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f2917f.add(new c(shapeAppearanceModel.e, shapeAppearanceModel.f4766h, shapeAppearanceModel.f4764f, shapeAppearanceModel.f4765g));
        materialButton.setEnabled(isEnabled());
        y.i(materialButton, new b());
    }

    public final void b(int i7, boolean z6) {
        if (i7 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i7);
            return;
        }
        HashSet hashSet = new HashSet(this.f2925o);
        if (z6 && !hashSet.contains(Integer.valueOf(i7))) {
            if (this.f2923l && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i7));
        } else if (!z6 && hashSet.contains(Integer.valueOf(i7))) {
            if (!this.m || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i7));
            }
        } else {
            return;
        }
        e(hashSet);
    }

    public final MaterialButton c(int i7) {
        return (MaterialButton) getChildAt(i7);
    }

    public final boolean d(int i7) {
        return getChildAt(i7).getVisibility() != 8;
    }

    @Override // android.view.View, android.view.ViewGroup
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f2920i);
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            treeMap.put(c(i7), Integer.valueOf(i7));
        }
        this.f2921j = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void e(Set<Integer> set) {
        HashSet hashSet = this.f2925o;
        this.f2925o = new HashSet(set);
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            int id = c(i7).getId();
            boolean contains = set.contains(Integer.valueOf(id));
            View findViewById = findViewById(id);
            if (findViewById instanceof MaterialButton) {
                this.f2922k = true;
                ((MaterialButton) findViewById).setChecked(contains);
                this.f2922k = false;
            }
            if (hashSet.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                set.contains(Integer.valueOf(id));
                Iterator<d> it = this.f2919h.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
            }
        }
        invalidate();
    }

    public final void f() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i7 = 0; i7 < childCount; i7++) {
            MaterialButton c7 = c(i7);
            if (c7.getVisibility() != 8) {
                i shapeAppearanceModel = c7.getShapeAppearanceModel();
                shapeAppearanceModel.getClass();
                i.a aVar = new i.a(shapeAppearanceModel);
                c cVar = (c) this.f2917f.get(i7);
                if (firstVisibleChildIndex != lastVisibleChildIndex) {
                    boolean z6 = getOrientation() == 0;
                    if (i7 == firstVisibleChildIndex) {
                        if (!z6) {
                            k4.c cVar2 = cVar.f2928a;
                            k4.a aVar2 = c.e;
                            cVar = new c(cVar2, aVar2, cVar.f2929b, aVar2);
                        } else if (s.a(this)) {
                            k4.a aVar3 = c.e;
                            cVar = new c(aVar3, aVar3, cVar.f2929b, cVar.f2930c);
                        } else {
                            k4.c cVar3 = cVar.f2928a;
                            k4.c cVar4 = cVar.f2931d;
                            k4.a aVar4 = c.e;
                            cVar = new c(cVar3, cVar4, aVar4, aVar4);
                        }
                    } else if (i7 != lastVisibleChildIndex) {
                        cVar = null;
                    } else if (!z6) {
                        k4.a aVar5 = c.e;
                        cVar = new c(aVar5, cVar.f2931d, aVar5, cVar.f2930c);
                    } else if (s.a(this)) {
                        k4.c cVar5 = cVar.f2928a;
                        k4.c cVar6 = cVar.f2931d;
                        k4.a aVar6 = c.e;
                        cVar = new c(cVar5, cVar6, aVar6, aVar6);
                    } else {
                        k4.a aVar7 = c.e;
                        cVar = new c(aVar7, aVar7, cVar.f2929b, cVar.f2930c);
                    }
                }
                if (cVar == null) {
                    aVar.e(0.0f);
                    aVar.f(0.0f);
                    aVar.d(0.0f);
                    aVar.c(0.0f);
                } else {
                    aVar.e = cVar.f2928a;
                    aVar.f4777h = cVar.f2931d;
                    aVar.f4775f = cVar.f2929b;
                    aVar.f4776g = cVar.f2930c;
                }
                c7.setShapeAppearanceModel(new i(aVar));
            }
        }
    }

    public int getCheckedButtonId() {
        if (!this.f2923l || this.f2925o.isEmpty()) {
            return -1;
        }
        return ((Integer) this.f2925o.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            int id = c(i7).getId();
            if (this.f2925o.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i7, int i8) {
        Integer[] numArr = this.f2921j;
        if (numArr != null && i8 < numArr.length) {
            return numArr[i8].intValue();
        }
        Log.w("MButtonToggleGroup", "Child order wasn't updated");
        return i8;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i7 = this.f2924n;
        if (i7 != -1) {
            e(Collections.singleton(Integer.valueOf(i7)));
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, getVisibleButtonCount(), false, this.f2923l ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i7, int i8) {
        f();
        a();
        super.onMeasure(i7, i8);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f2917f.remove(indexOfChild);
        }
        f();
        a();
    }

    @Override // android.view.View
    public void setEnabled(boolean z6) {
        super.setEnabled(z6);
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            c(i7).setEnabled(z6);
        }
    }

    public void setSelectionRequired(boolean z6) {
        this.m = z6;
    }

    public void setSingleSelection(int i7) {
        setSingleSelection(getResources().getBoolean(i7));
    }

    public void setSingleSelection(boolean z6) {
        if (this.f2923l != z6) {
            this.f2923l = z6;
            e(new HashSet());
        }
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            c(i7).setA11yClassName((this.f2923l ? RadioButton.class : ToggleButton.class).getName());
        }
    }
}
