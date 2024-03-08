package com.google.android.material.search;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import e4.g;
import java.util.HashMap;
import k4.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class SearchView extends FrameLayout implements CoordinatorLayout.b, e4.b {

    /* renamed from: f  reason: collision with root package name */
    public SearchBar f3218f;

    /* renamed from: g  reason: collision with root package name */
    public int f3219g;

    /* renamed from: h  reason: collision with root package name */
    public c f3220h;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class Behavior extends CoordinatorLayout.c<SearchView> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean h(CoordinatorLayout coordinatorLayout, SearchView searchView, View view) {
            SearchView searchView2 = searchView;
            if (!(searchView2.f3218f != null) && (view instanceof SearchBar)) {
                searchView2.setupWithSearchBar((SearchBar) view);
            }
            return false;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends w1.a {
        public static final Parcelable.Creator<a> CREATOR = new C0038a();

        /* renamed from: h  reason: collision with root package name */
        public String f3221h;

        /* renamed from: i  reason: collision with root package name */
        public int f3222i;

        public a() {
            throw null;
        }

        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3221h = parcel.readString();
            this.f3222i = parcel.readInt();
        }

        @Override // w1.a, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i7) {
            parcel.writeParcelable(this.f6374f, i7);
            parcel.writeString(this.f3221h);
            parcel.writeInt(this.f3222i);
        }

        /* renamed from: com.google.android.material.search.SearchView$a$a  reason: collision with other inner class name */
        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class C0038a implements Parcelable.ClassLoaderCreator<a> {
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
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface b {
        void a();
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public enum c {
        HIDING,
        HIDDEN,
        /* JADX INFO: Fake field, exist only in values array */
        SHOWING,
        SHOWN
    }

    private Window getActivityWindow() {
        Activity activity;
        Context context = getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                activity = null;
                break;
            } else if (context instanceof Activity) {
                activity = (Activity) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        if (activity == null) {
            return null;
        }
        return activity.getWindow();
    }

    private float getOverlayElevation() {
        SearchBar searchBar = this.f3218f;
        return searchBar != null ? searchBar.getCompatElevation() : getResources().getDimension(2131100126);
    }

    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private void setStatusBarSpacerEnabledInternal(boolean z6) {
        throw null;
    }

    private void setUpBackgroundViewElevationOverlay(float f7) {
    }

    private void setUpHeaderLayout(int i7) {
        if (i7 != -1) {
            LayoutInflater.from(getContext()).inflate(i7, (ViewGroup) null, false);
            throw null;
        }
    }

    private void setUpStatusBarSpacer(int i7) {
        throw null;
    }

    @Override // e4.b
    public final void a() {
        if (!e()) {
            throw null;
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i7, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i7, layoutParams);
    }

    @Override // e4.b
    public final void b(androidx.activity.b bVar) {
        if (!e() && this.f3218f != null) {
            throw null;
        }
    }

    @Override // e4.b
    public final void c(androidx.activity.b bVar) {
        if (!e() && this.f3218f != null && Build.VERSION.SDK_INT >= 34) {
            throw null;
        }
    }

    @Override // e4.b
    public final void d() {
        if (!e() && this.f3218f != null && Build.VERSION.SDK_INT >= 34) {
            throw null;
        }
    }

    public final boolean e() {
        return this.f3220h.equals(c.HIDDEN) || this.f3220h.equals(c.HIDING);
    }

    public g getBackHelper() {
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<SearchView> getBehavior() {
        return new Behavior();
    }

    public c getCurrentTransitionState() {
        return this.f3220h;
    }

    public int getDefaultNavigationIconResource() {
        return 2131165344;
    }

    public EditText getEditText() {
        return null;
    }

    public CharSequence getHint() {
        throw null;
    }

    public TextView getSearchPrefix() {
        return null;
    }

    public CharSequence getSearchPrefixText() {
        throw null;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getSoftInputMode() {
        return this.f3219g;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public Editable getText() {
        throw null;
    }

    public Toolbar getToolbar() {
        return null;
    }

    @Override // android.view.View, android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof f) {
            q2.a.L(this, (f) background);
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        Window activityWindow = getActivityWindow();
        if (activityWindow != null) {
            this.f3219g = activityWindow.getAttributes().softInputMode;
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.f6374f);
        setText(aVar.f3221h);
        setVisible(aVar.f3222i == 0);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        if (super.onSaveInstanceState() != null) {
            Editable text = getText();
            if (text != null) {
                text.toString();
            }
            throw null;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public void setAnimatedNavigationIcon(boolean z6) {
    }

    public void setAutoShowKeyboard(boolean z6) {
    }

    @Override // android.view.View
    public void setElevation(float f7) {
        super.setElevation(f7);
        setUpBackgroundViewElevationOverlay(f7);
    }

    public void setHint(int i7) {
        throw null;
    }

    public void setHint(CharSequence charSequence) {
        throw null;
    }

    public void setMenuItemsAnimated(boolean z6) {
    }

    public void setModalForAccessibility(boolean z6) {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (z6) {
            new HashMap(viewGroup.getChildCount());
        }
        for (int i7 = 0; i7 < viewGroup.getChildCount(); i7++) {
            if (viewGroup.getChildAt(i7) != this) {
                throw null;
            }
        }
    }

    public void setOnMenuItemClickListener(Toolbar.h hVar) {
        throw null;
    }

    public void setSearchPrefixText(CharSequence charSequence) {
        throw null;
    }

    public void setStatusBarSpacerEnabled(boolean z6) {
        setStatusBarSpacerEnabledInternal(z6);
    }

    public void setText(int i7) {
        throw null;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setText(CharSequence charSequence) {
        throw null;
    }

    public void setToolbarTouchscreenBlocksFocus(boolean z6) {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0029 A[LOOP:0: B:12:0x0023->B:14:0x0029, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setTransitionState(com.google.android.material.search.SearchView.c r2) {
        /*
            r1 = this;
            com.google.android.material.search.SearchView$c r0 = r1.f3220h
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0009
            goto L_0x0033
        L_0x0009:
            com.google.android.material.search.SearchView$c r0 = com.google.android.material.search.SearchView.c.SHOWN
            if (r2 != r0) goto L_0x000f
            r0 = 1
            goto L_0x0014
        L_0x000f:
            com.google.android.material.search.SearchView$c r0 = com.google.android.material.search.SearchView.c.HIDDEN
            if (r2 != r0) goto L_0x0017
            r0 = 0
        L_0x0014:
            r1.setModalForAccessibility(r0)
        L_0x0017:
            r1.f3220h = r2
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r2 = 0
            r1.<init>(r2)
            java.util.Iterator r1 = r1.iterator()
        L_0x0023:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0033
            java.lang.Object r2 = r1.next()
            com.google.android.material.search.SearchView$b r2 = (com.google.android.material.search.SearchView.b) r2
            r2.a()
            goto L_0x0023
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.search.SearchView.setTransitionState(com.google.android.material.search.SearchView$c):void");
    }

    public void setUseWindowInsetsController(boolean z6) {
    }

    public void setVisible(boolean z6) {
        throw null;
    }

    public void setupWithSearchBar(SearchBar searchBar) {
        this.f3218f = searchBar;
        throw null;
    }
}
