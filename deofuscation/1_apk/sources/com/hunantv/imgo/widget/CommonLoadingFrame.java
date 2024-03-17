package com.hunantv.imgo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hunantv.imgo.nightmode.view.SkinnableFrameLayout;
import j.l.a.a0.b;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class CommonLoadingFrame extends SkinnableFrameLayout implements View.OnClickListener {
    public CommonLoadingFrame(@NonNull Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachedToWindow() {
        super/*android.widget.FrameLayout*/.onAttachedToWindow();
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachedFromWindow() {
        setOnClickListener((View.OnClickListener) null);
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
    }

    public CommonLoadingFrame(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonLoadingFrame(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(b.l.layout_common_loading, (ViewGroup) this);
    }
}
