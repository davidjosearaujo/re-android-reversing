package com.rajat.pdfviewer;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.pdf.PdfRenderer;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import androidx.lifecycle.m;
import androidx.lifecycle.o;
import androidx.recyclerview.widget.RecyclerView;
import com.rajat.pdfviewer.PdfRendererView;
import java.util.NoSuchElementException;
import l0.z;
import r5.h;
import v4.k;

/* loaded from: classes.dex */
public final class PdfRendererView extends FrameLayout implements m {

    /* renamed from: t */
    public static final /* synthetic */ int f3452t = 0;

    /* renamed from: f */
    public RecyclerView f3453f;

    /* renamed from: g */
    public TextView f3454g;

    /* renamed from: h */
    public v4.d f3455h;

    /* renamed from: i */
    public k f3456i;

    /* renamed from: j */
    public boolean f3457j;

    /* renamed from: k */
    public Drawable f3458k;

    /* renamed from: l */
    public Runnable f3459l;
    public boolean m;

    /* renamed from: n */
    public boolean f3460n;

    /* renamed from: o */
    public Rect f3461o;

    /* renamed from: p */
    public a f3462p;

    /* renamed from: q */
    public int f3463q;

    /* renamed from: r */
    public int f3464r;
    public final e s;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str);

        void b(Exception exc);

        void c();

        void d();

        void e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PdfRendererView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        h.f(context, "context");
        x4.b[] bVarArr = x4.b.f6470g;
        this.f3457j = true;
        this.f3459l = new Runnable() { // from class: v4.g
            @Override // java.lang.Runnable
            public final void run() {
                int i7 = PdfRendererView.f3452t;
            }
        };
        this.f3461o = new Rect(0, 0, 0, 0);
        this.f3464r = -1;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, z.H, 0, 0);
        h.e(obtainStyledAttributes, "obtainStyledAttributes(...)");
        setTypeArray(obtainStyledAttributes);
        this.s = new e(this, context);
    }

    private final void setTypeArray(TypedArray typedArray) {
        Window window;
        x4.b[] bVarArr = x4.b.f6470g;
        int i7 = typedArray.getInt(4, 100);
        for (x4.b bVar : x4.b.values()) {
            if (bVar.f6471f == i7) {
                this.f3457j = typedArray.getBoolean(12, true);
                this.f3458k = typedArray.getDrawable(2);
                this.m = typedArray.getBoolean(3, this.m);
                int dimensionPixelSize = typedArray.getDimensionPixelSize(5, 0);
                Rect rect = new Rect(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                rect.top = typedArray.getDimensionPixelSize(9, rect.top);
                rect.left = typedArray.getDimensionPixelSize(7, rect.left);
                rect.right = typedArray.getDimensionPixelSize(8, rect.right);
                rect.bottom = typedArray.getDimensionPixelSize(6, rect.bottom);
                this.f3461o = rect;
                if (typedArray.getBoolean(1, false)) {
                    Context context = getContext();
                    Activity activity = context instanceof Activity ? (Activity) context : null;
                    if (activity != null && (window = activity.getWindow()) != null) {
                        window.addFlags(8192);
                    }
                }
                typedArray.recycle();
                return;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public final void a(String str, v4.a aVar, LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, o oVar) {
        h.f(aVar, "headers");
        oVar.a(this);
        new b(lifecycleCoroutineScopeImpl, aVar, str, new d(this));
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView = this.f3453f;
        if (recyclerView != null) {
            return recyclerView;
        }
        h.k("recyclerView");
        throw null;
    }

    public final a getStatusListener() {
        return this.f3462p;
    }

    public final int getTotalPageCount() {
        v4.d dVar = this.f3455h;
        if (dVar == null) {
            h.k("pdfRendererCore");
            throw null;
        }
        PdfRenderer pdfRenderer = dVar.f6275b;
        if (pdfRenderer != null) {
            return pdfRenderer.getPageCount();
        }
        return 0;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        super.onRestoreInstanceState(Build.VERSION.SDK_INT >= 33 ? (Parcelable) ((Bundle) parcelable).getParcelable("superState", Parcelable.class) : ((Bundle) parcelable).getParcelable("superState"));
        this.f3464r = ((Bundle) parcelable).getInt("scrollPosition", this.f3463q);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", onSaveInstanceState);
        if (this.f3453f != null) {
            bundle.putInt("scrollPosition", this.f3463q);
        }
        return bundle;
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        h.f(recyclerView, "<set-?>");
        this.f3453f = recyclerView;
    }

    public final void setStatusListener(a aVar) {
        this.f3462p = aVar;
    }
}
