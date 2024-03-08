package p1;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public ViewParent f5496a;

    /* renamed from: b  reason: collision with root package name */
    public ViewParent f5497b;

    /* renamed from: c  reason: collision with root package name */
    public final View f5498c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5499d;
    public int[] e;

    public l(View view) {
        this.f5498c = view;
    }

    public final boolean a(float f7, float f8, boolean z6) {
        ViewParent f9;
        if (!this.f5499d || (f9 = f(0)) == null) {
            return false;
        }
        try {
            return h0.a(f9, this.f5498c, f7, f8, z6);
        } catch (AbstractMethodError e) {
            Log.e("ViewParentCompat", "ViewParent " + f9 + " does not implement interface method onNestedFling", e);
            return false;
        }
    }

    public final boolean b(float f7, float f8) {
        ViewParent f9;
        if (!this.f5499d || (f9 = f(0)) == null) {
            return false;
        }
        try {
            return h0.b(f9, this.f5498c, f7, f8);
        } catch (AbstractMethodError e) {
            Log.e("ViewParentCompat", "ViewParent " + f9 + " does not implement interface method onNestedPreFling", e);
            return false;
        }
    }

    public final boolean c(int i7, int i8, int i9, int[] iArr, int[] iArr2) {
        ViewParent f7;
        int i10;
        int i11;
        int[] iArr3;
        if (!this.f5499d || (f7 = f(i9)) == null) {
            return false;
        }
        if (i7 != 0 || i8 != 0) {
            if (iArr2 != null) {
                this.f5498c.getLocationInWindow(iArr2);
                i11 = iArr2[0];
                i10 = iArr2[1];
            } else {
                i11 = 0;
                i10 = 0;
            }
            if (iArr == null) {
                if (this.e == null) {
                    this.e = new int[2];
                }
                iArr3 = this.e;
            } else {
                iArr3 = iArr;
            }
            iArr3[0] = 0;
            iArr3[1] = 0;
            View view = this.f5498c;
            if (f7 instanceof m) {
                ((m) f7).j(view, i7, i8, iArr3, i9);
            } else if (i9 == 0) {
                try {
                    h0.c(f7, view, i7, i8, iArr3);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + f7 + " does not implement interface method onNestedPreScroll", e);
                }
            }
            if (iArr2 != null) {
                this.f5498c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i11;
                iArr2[1] = iArr2[1] - i10;
            }
            return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public final void d(int i7, int i8, int i9, int[] iArr) {
        e(0, i7, 0, i8, null, i9, iArr);
    }

    public final boolean e(int i7, int i8, int i9, int i10, int[] iArr, int i11, int[] iArr2) {
        ViewParent f7;
        int i12;
        int i13;
        int[] iArr3;
        if (!this.f5499d || (f7 = f(i11)) == null) {
            return false;
        }
        if (i7 == 0 && i8 == 0 && i9 == 0 && i10 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f5498c.getLocationInWindow(iArr);
            i13 = iArr[0];
            i12 = iArr[1];
        } else {
            i13 = 0;
            i12 = 0;
        }
        if (iArr2 == null) {
            if (this.e == null) {
                this.e = new int[2];
            }
            int[] iArr4 = this.e;
            iArr4[0] = 0;
            iArr4[1] = 0;
            iArr3 = iArr4;
        } else {
            iArr3 = iArr2;
        }
        View view = this.f5498c;
        if (f7 instanceof n) {
            ((n) f7).m(view, i7, i8, i9, i10, i11, iArr3);
        } else {
            iArr3[0] = iArr3[0] + i9;
            iArr3[1] = iArr3[1] + i10;
            if (f7 instanceof m) {
                ((m) f7).n(view, i7, i8, i9, i10, i11);
            } else if (i11 == 0) {
                try {
                    h0.d(f7, view, i7, i8, i9, i10);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + f7 + " does not implement interface method onNestedScroll", e);
                }
            }
        }
        if (iArr != null) {
            this.f5498c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i13;
            iArr[1] = iArr[1] - i12;
        }
        return true;
    }

    public final ViewParent f(int i7) {
        if (i7 == 0) {
            return this.f5496a;
        }
        if (i7 != 1) {
            return null;
        }
        return this.f5497b;
    }

    public final boolean g(int i7, int i8) {
        boolean z6;
        if (f(i8) != null) {
            return true;
        }
        if (this.f5499d) {
            View view = this.f5498c;
            for (ViewParent parent = this.f5498c.getParent(); parent != null; parent = parent.getParent()) {
                View view2 = this.f5498c;
                boolean z7 = parent instanceof m;
                if (z7) {
                    z6 = ((m) parent).o(view, view2, i7, i8);
                } else {
                    if (i8 == 0) {
                        try {
                            z6 = h0.f(parent, view, view2, i7);
                        } catch (AbstractMethodError e) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e);
                        }
                    }
                    z6 = false;
                }
                if (z6) {
                    if (i8 == 0) {
                        this.f5496a = parent;
                    } else if (i8 == 1) {
                        this.f5497b = parent;
                    }
                    View view3 = this.f5498c;
                    if (z7) {
                        ((m) parent).a(view, view3, i7, i8);
                    } else if (i8 == 0) {
                        try {
                            h0.e(parent, view, view3, i7);
                        } catch (AbstractMethodError e7) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e7);
                        }
                    }
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public final void h(int i7) {
        ViewParent f7 = f(i7);
        if (f7 != null) {
            View view = this.f5498c;
            if (f7 instanceof m) {
                ((m) f7).i(view, i7);
            } else if (i7 == 0) {
                try {
                    h0.g(f7, view);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + f7 + " does not implement interface method onStopNestedScroll", e);
                }
            }
            if (i7 == 0) {
                this.f5496a = null;
            } else if (i7 == 1) {
                this.f5497b = null;
            }
        }
    }
}
