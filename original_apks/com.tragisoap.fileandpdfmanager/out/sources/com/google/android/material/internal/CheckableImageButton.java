package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.n;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class CheckableImageButton extends n implements Checkable {

    /* renamed from: l */
    public static final int[] f3206l = {16842912};

    /* renamed from: i */
    public boolean f3207i;

    /* renamed from: j */
    public boolean f3208j = true;

    /* renamed from: k */
    public boolean f3209k = true;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends w1.a {
        public static final Parcelable.Creator<a> CREATOR = new C0036a();

        /* renamed from: h */
        public boolean f3210h;

        /* renamed from: com.google.android.material.internal.CheckableImageButton$a$a */
        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class C0036a implements Parcelable.ClassLoaderCreator<a> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new a(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i7) {
                return new a[i7];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final a createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new a(parcel, classLoader);
            }
        }

        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3210h = parcel.readInt() != 1 ? false : true;
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // w1.a, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i7) {
            parcel.writeParcelable(this.f6374f, i7);
            parcel.writeInt(this.f3210h ? 1 : 0);
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130903623);
        y.i(this, new d4.a(this));
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f3207i;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i7) {
        if (!this.f3207i) {
            return super.onCreateDrawableState(i7);
        }
        return View.mergeDrawableStates(super.onCreateDrawableState(i7 + 1), f3206l);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.f6374f);
        setChecked(aVar.f3210h);
    }

    @Override // android.view.View
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

    @Override // android.widget.Checkable
    public void setChecked(boolean z6) {
        if (this.f3208j && this.f3207i != z6) {
            this.f3207i = z6;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public void setPressable(boolean z6) {
        this.f3209k = z6;
    }

    @Override // android.view.View
    public void setPressed(boolean z6) {
        if (this.f3209k) {
            super.setPressed(z6);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f3207i);
    }
}
