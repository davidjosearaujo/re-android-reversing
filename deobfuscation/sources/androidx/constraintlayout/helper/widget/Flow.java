package androidx.constraintlayout.helper.widget;

import a0.b;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import b1.f;
import y0.d;
import y0.j;

/* loaded from: classes.dex */
public class Flow extends f {

    /* renamed from: p */
    public y0.f f1248p;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // b1.f, androidx.constraintlayout.widget.b
    public final void i(AttributeSet attributeSet) {
        super.i(attributeSet);
        this.f1248p = new y0.f();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, b.e);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = obtainStyledAttributes.getIndex(i7);
                if (index == 0) {
                    this.f1248p.X0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 1) {
                    y0.f fVar = this.f1248p;
                    int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    fVar.f6585u0 = dimensionPixelSize;
                    fVar.f6586v0 = dimensionPixelSize;
                    fVar.f6587w0 = dimensionPixelSize;
                    fVar.f6588x0 = dimensionPixelSize;
                } else if (index == 18) {
                    y0.f fVar2 = this.f1248p;
                    int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    fVar2.f6587w0 = dimensionPixelSize2;
                    fVar2.f6589y0 = dimensionPixelSize2;
                    fVar2.f6590z0 = dimensionPixelSize2;
                } else if (index == 19) {
                    this.f1248p.f6588x0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 2) {
                    this.f1248p.f6589y0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 3) {
                    this.f1248p.f6585u0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 4) {
                    this.f1248p.f6590z0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 5) {
                    this.f1248p.f6586v0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 54) {
                    this.f1248p.V0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 44) {
                    this.f1248p.F0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 53) {
                    this.f1248p.G0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 38) {
                    this.f1248p.H0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 46) {
                    this.f1248p.J0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 40) {
                    this.f1248p.I0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 48) {
                    this.f1248p.K0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 42) {
                    this.f1248p.L0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 37) {
                    this.f1248p.N0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 45) {
                    this.f1248p.P0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 39) {
                    this.f1248p.O0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 47) {
                    this.f1248p.Q0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 51) {
                    this.f1248p.M0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 41) {
                    this.f1248p.T0 = obtainStyledAttributes.getInt(index, 2);
                } else if (index == 50) {
                    this.f1248p.U0 = obtainStyledAttributes.getInt(index, 2);
                } else if (index == 43) {
                    this.f1248p.R0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 52) {
                    this.f1248p.S0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 49) {
                    this.f1248p.W0 = obtainStyledAttributes.getInt(index, -1);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1317i = this.f1248p;
        k();
    }

    @Override // androidx.constraintlayout.widget.b
    public final void j(d dVar, boolean z6) {
        y0.f fVar = this.f1248p;
        int i7 = fVar.f6587w0;
        if (i7 > 0 || fVar.f6588x0 > 0) {
            if (z6) {
                fVar.f6589y0 = fVar.f6588x0;
            } else {
                fVar.f6589y0 = i7;
                i7 = fVar.f6588x0;
            }
            fVar.f6590z0 = i7;
        }
    }

    @Override // b1.f
    public final void l(j jVar, int i7, int i8) {
        int mode = View.MeasureSpec.getMode(i7);
        int size = View.MeasureSpec.getSize(i7);
        int mode2 = View.MeasureSpec.getMode(i8);
        int size2 = View.MeasureSpec.getSize(i8);
        if (jVar == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        jVar.S(mode, size, mode2, size2);
        setMeasuredDimension(jVar.B0, jVar.C0);
    }

    @Override // androidx.constraintlayout.widget.b, android.view.View
    @SuppressLint({"WrongCall"})
    public final void onMeasure(int i7, int i8) {
        l(this.f1248p, i7, i8);
    }

    public void setFirstHorizontalBias(float f7) {
        this.f1248p.N0 = f7;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i7) {
        this.f1248p.H0 = i7;
        requestLayout();
    }

    public void setFirstVerticalBias(float f7) {
        this.f1248p.O0 = f7;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i7) {
        this.f1248p.I0 = i7;
        requestLayout();
    }

    public void setHorizontalAlign(int i7) {
        this.f1248p.T0 = i7;
        requestLayout();
    }

    public void setHorizontalBias(float f7) {
        this.f1248p.L0 = f7;
        requestLayout();
    }

    public void setHorizontalGap(int i7) {
        this.f1248p.R0 = i7;
        requestLayout();
    }

    public void setHorizontalStyle(int i7) {
        this.f1248p.F0 = i7;
        requestLayout();
    }

    public void setLastHorizontalBias(float f7) {
        this.f1248p.P0 = f7;
        requestLayout();
    }

    public void setLastHorizontalStyle(int i7) {
        this.f1248p.J0 = i7;
        requestLayout();
    }

    public void setLastVerticalBias(float f7) {
        this.f1248p.Q0 = f7;
        requestLayout();
    }

    public void setLastVerticalStyle(int i7) {
        this.f1248p.K0 = i7;
        requestLayout();
    }

    public void setMaxElementsWrap(int i7) {
        this.f1248p.W0 = i7;
        requestLayout();
    }

    public void setOrientation(int i7) {
        this.f1248p.X0 = i7;
        requestLayout();
    }

    public void setPadding(int i7) {
        y0.f fVar = this.f1248p;
        fVar.f6585u0 = i7;
        fVar.f6586v0 = i7;
        fVar.f6587w0 = i7;
        fVar.f6588x0 = i7;
        requestLayout();
    }

    public void setPaddingBottom(int i7) {
        this.f1248p.f6586v0 = i7;
        requestLayout();
    }

    public void setPaddingLeft(int i7) {
        this.f1248p.f6589y0 = i7;
        requestLayout();
    }

    public void setPaddingRight(int i7) {
        this.f1248p.f6590z0 = i7;
        requestLayout();
    }

    public void setPaddingTop(int i7) {
        this.f1248p.f6585u0 = i7;
        requestLayout();
    }

    public void setVerticalAlign(int i7) {
        this.f1248p.U0 = i7;
        requestLayout();
    }

    public void setVerticalBias(float f7) {
        this.f1248p.M0 = f7;
        requestLayout();
    }

    public void setVerticalGap(int i7) {
        this.f1248p.S0 = i7;
        requestLayout();
    }

    public void setVerticalStyle(int i7) {
        this.f1248p.G0 = i7;
        requestLayout();
    }

    public void setWrapMode(int i7) {
        this.f1248p.V0 = i7;
        requestLayout();
    }
}
