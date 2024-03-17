package com.hunantv.imgo.nightmode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.LayoutInflaterFactory;
import androidx.core.view.ViewCompat;
import j.l.a.a0.b;
import j.l.a.g.a;
import j.l.a.g.b;
import j.l.a.t.e;
import j.l.a.t.i;
import j.v.q.c;
import j.v.q.i.d;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SkinnableActivity extends AppCompatActivity implements LayoutInflaterFactory {
    private i mSkinnableViewInflater;
    public d mStatusBarSupport;

    /* JADX WARN: Multi-variable type inference failed */
    private boolean shouldInheritContext(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = getWindow().getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ViewCompat.isAttachedToWindow((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private void updateNavigationBarFlag(@NonNull Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
            window.getDecorView().setSystemUiVisibility(z ? systemUiVisibility & (-17) : systemUiVisibility | 16);
        }
    }

    public boolean needNightModeChangeState() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(@Nullable Bundle bundle) {
        if (needNightModeChangeState()) {
            LayoutInflaterCompat.setFactory(LayoutInflater.from(this), this);
        }
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        this.mStatusBarSupport = c.a(this, 2);
        if ("samsung".equalsIgnoreCase(Build.MANUFACTURER) && Build.VERSION.SDK_INT == 26) {
            try {
                refreshStatusBar();
                refreshNavigationBar();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        refreshStatusBar();
        refreshNavigationBar();
    }

    @SuppressLint({"RestrictedApi"})
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (!needNightModeChangeState()) {
            return super/*androidx.fragment.app.FragmentActivity*/.onCreateView(view, str, context, attributeSet);
        }
        if (this.mSkinnableViewInflater == null) {
            this.mSkinnableViewInflater = new i();
        }
        boolean z = Build.VERSION.SDK_INT < 21;
        return this.mSkinnableViewInflater.c(view, str, context, attributeSet, z && shouldInheritContext((ViewParent) view), z, true, VectorEnabledTintResources.shouldBeUsed());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onGrayModeChange() {
        if (getWindow() != null && getWindow().getDecorView() != null) {
            a.a(getWindow().getDecorView());
        }
        refreshStatusBar();
        refreshNavigationBar();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onNightModeChange(SkinModel skinModel) {
        if (getWindow() != null && getWindow().getDecorView() != null) {
            b.a(getWindow().getDecorView());
        }
        refreshStatusBar();
        refreshNavigationBar();
    }

    public void refreshNavigationBar() {
        if (e.m().t()) {
            setNavigationBarColor(getResources().getColor(b.e.skin_color_content_bg_primary), true);
        } else {
            setNavigationBarColor(getResources().getColor(b.e.color_EFEFEF), false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void refreshStatusBar() {
        this.mStatusBarSupport.d(this, getResources().getColor(b.e.color_v60_bg_primary));
        if (e.m().t()) {
            this.mStatusBarSupport.b(this, true);
        } else {
            this.mStatusBarSupport.b(this, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setNavigationBarColor(@ColorInt int i, boolean z) {
        Window window = getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.setNavigationBarColor(i);
            }
            updateNavigationBarFlag(window, z);
        }
    }
}
