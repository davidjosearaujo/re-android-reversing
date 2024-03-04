package a1;

import a1.d;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public final class c extends androidx.constraintlayout.widget.b implements d.c {

    /* renamed from: n */
    public boolean f60n;

    /* renamed from: o */
    public boolean f61o;

    /* renamed from: p */
    public float f62p;

    /* renamed from: q */
    public View[] f63q;

    @Override // a1.d.c
    public final void a() {
    }

    @Override // a1.d.c
    public final void b() {
    }

    public float getProgress() {
        return this.f62p;
    }

    @Override // androidx.constraintlayout.widget.b
    public final void i(AttributeSet attributeSet) {
        super.i(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a0.b.f12k);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = obtainStyledAttributes.getIndex(i7);
                if (index == 1) {
                    this.f60n = obtainStyledAttributes.getBoolean(index, this.f60n);
                } else if (index == 0) {
                    this.f61o = obtainStyledAttributes.getBoolean(index, this.f61o);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setProgress(float f7) {
        this.f62p = f7;
        int i7 = 0;
        if (this.f1315g <= 0) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            int childCount = viewGroup.getChildCount();
            while (i7 < childCount) {
                boolean z6 = viewGroup.getChildAt(i7) instanceof c;
                i7++;
            }
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
        View[] viewArr = this.f1320l;
        if (viewArr == null || viewArr.length != this.f1315g) {
            this.f1320l = new View[this.f1315g];
        }
        for (int i8 = 0; i8 < this.f1315g; i8++) {
            this.f1320l[i8] = constraintLayout.f1250f.get(this.f1314f[i8]);
        }
        this.f63q = this.f1320l;
        while (i7 < this.f1315g) {
            View view = this.f63q[i7];
            i7++;
        }
    }
}
