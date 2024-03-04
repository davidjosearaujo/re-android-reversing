package d4;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import l0.z;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a */
    public static final int[] f3630a = {2130903317};

    /* renamed from: b */
    public static final int[] f3631b = {2130903324};

    public static void a(Context context, AttributeSet attributeSet, int i7, int i8) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.C, i7, i8);
        boolean z6 = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
        if (z6) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(2130903640, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                c(context, f3631b, "Theme.MaterialComponents");
            }
        }
        c(context, f3630a, "Theme.AppCompat");
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x001a, code lost:
        if (r0.getResourceId(0, -1) != (-1)) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.content.Context r4, android.util.AttributeSet r5, int[] r6, int r7, int r8, int... r9) {
        /*
            int[] r0 = l0.z.C
            android.content.res.TypedArray r0 = r4.obtainStyledAttributes(r5, r0, r7, r8)
            r1 = 2
            r2 = 0
            boolean r1 = r0.getBoolean(r1, r2)
            if (r1 != 0) goto L12
            r0.recycle()
            return
        L12:
            r1 = -1
            int r3 = r9.length
            if (r3 != 0) goto L1d
            int r4 = r0.getResourceId(r2, r1)
            if (r4 == r1) goto L38
            goto L37
        L1d:
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r6, r7, r8)
            int r5 = r9.length
            r6 = r2
        L23:
            if (r6 >= r5) goto L34
            r7 = r9[r6]
            int r7 = r4.getResourceId(r7, r1)
            if (r7 != r1) goto L31
            r4.recycle()
            goto L38
        L31:
            int r6 = r6 + 1
            goto L23
        L34:
            r4.recycle()
        L37:
            r2 = 1
        L38:
            r0.recycle()
            if (r2 == 0) goto L3e
            return
        L3e:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant)."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.n.b(android.content.Context, android.util.AttributeSet, int[], int, int, int[]):void");
    }

    public static void c(Context context, int[] iArr, String str) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        boolean z6 = false;
        int i7 = 0;
        while (true) {
            if (i7 >= iArr.length) {
                obtainStyledAttributes.recycle();
                z6 = true;
                break;
            } else if (!obtainStyledAttributes.hasValue(i7)) {
                obtainStyledAttributes.recycle();
                break;
            } else {
                i7++;
            }
        }
        if (z6) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    public static TypedArray d(Context context, AttributeSet attributeSet, int[] iArr, int i7, int i8, int... iArr2) {
        a(context, attributeSet, i7, i8);
        b(context, attributeSet, iArr, i7, i8, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i7, i8);
    }
}
