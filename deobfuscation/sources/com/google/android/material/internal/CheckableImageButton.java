package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.n;
import p1.y;

/* loaded from: classes.dex */
public class CheckableImageButton extends n implements Checkable {

    /* renamed from: l */
    public static final int[] f3206l = {16842912};

    /* renamed from: i */
    public boolean f3207i;

    /* renamed from: j */
    public boolean f3208j;

    /* renamed from: k */
    public boolean f3209k;

    /* loaded from: classes.dex */
    public static class a extends Kotlin_2.a {
        public static final Parcelable.Creator CREATOR = new C0036a();

        /* renamed from: h */
        public boolean f3210h;

        /* renamed from: com.google.android.material.internal.CheckableImageButton$a$a */
        /* loaded from: classes.dex */
        public class C0036a implements Parcelable.ClassLoaderCreator {
            public final Object createFromParcel(Parcel parcel) {
                return new a(parcel, null);
            }

            public final Object[] newArray(int i7) {
                return new a[i7];
            }

            public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new a(parcel, classLoader);
            }
        }

        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3210h = parcel.readInt() == 1;
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        public final void writeToParcel(Parcel parcel, int i7) {
            parcel.writeParcelable(this.f6374f, i7);
            parcel.writeInt(this.f3210h ? 1 : 0);
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130903623);
        this.f3208j = true;
        this.f3209k = true;
        y.i(this, new d4.a(this));
    }

    public final boolean isChecked() {
        return this.f3207i;
    }

    public final int[] onCreateDrawableState(int i7) {
        if (this.f3207i) {
            return View.mergeDrawableStates(super.onCreateDrawableState(i7 + 1), f3206l);
        }
        return super.onCreateDrawableState(i7);
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.f6374f);
        setChecked(aVar.f3210h);
    }

    public final Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f3210h = this.f3207i;
        return aVar;
    }

    public void setCheckable(boolean z6) {
        if (this.f3208j != z6) {
            this.f3208j = z6;
            sendAccessibilityEvent(0);
        }
    }

    public void setChecked(boolean z6) {
        if (!this.f3208j || this.f3207i == z6) {
            return;
        }
        this.f3207i = z6;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z6) {
        this.f3209k = z6;
    }

    public void setPressed(boolean z6) {
        if (this.f3209k) {
            super.setPressed(z6);
        }
    }

    public final void toggle() {
        setChecked(!this.f3207i);
    }
}
