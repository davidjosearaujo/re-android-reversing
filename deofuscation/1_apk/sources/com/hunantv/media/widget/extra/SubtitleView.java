package com.hunantv.media.widget.extra;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import c.a.a.a.p.c;
import c.a.a.a.p.d;
import c.a.a.c.a;
import c.a.a.c.b;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.hunantv.imgo.nightmode.view.SkinnableView;
import com.hunantv.media.utils.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class SubtitleView extends SkinnableView implements d.d {
    public static final float DEFAULT_BOTTOM_PADDING_FRACTION = 0.08f;
    public static final float DEFAULT_TEXT_SIZE_FRACTION = 0.0533f;
    private boolean applyEmbeddedFontSizes;
    private boolean applyEmbeddedStyles;
    private float bottomPaddingFraction;
    private List<b> cues;
    private final List<SubtitlePainter> painters;
    private a style;
    private float textSize;
    private int textSizeType;

    public SubtitleView(Context context) {
        this(context, null);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.painters = new ArrayList();
        this.textSizeType = 0;
        this.textSize = 0.0533f;
        this.applyEmbeddedStyles = true;
        this.applyEmbeddedFontSizes = true;
        this.style = a.g;
        this.bottomPaddingFraction = 0.08f;
    }

    @TargetApi(19)
    private float getUserCaptionFontScaleV19() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).getFontScale();
    }

    @TargetApi(19)
    private a getUserCaptionStyleV19() {
        return a.a(((CaptioningManager) getContext().getSystemService("captioning")).getUserStyle());
    }

    @TargetApi(19)
    private boolean isCaptionManagerEnabled() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).isEnabled();
    }

    private float resolveCueTextSize(b bVar, int i, int i2) {
        int i3 = bVar.m;
        if (i3 != Integer.MIN_VALUE) {
            float f = bVar.n;
            if (f != Float.MIN_VALUE) {
                return Math.max(resolveTextSize(i3, f, i, i2), 0.0f);
            }
        }
        return 0.0f;
    }

    private float resolveTextSize(int i, float f, int i2, int i3) {
        float f2;
        if (i == 0) {
            f2 = i3;
        } else if (i != 1) {
            if (i != 2) {
                return Float.MIN_VALUE;
            }
            return f;
        } else {
            f2 = i2;
        }
        return f * f2;
    }

    private void setTextSize(int i, float f) {
        if (this.textSizeType == i && this.textSize == f) {
            return;
        }
        this.textSizeType = i;
        this.textSize = f;
        invalidate();
    }

    public void clear() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(""));
        setCues(arrayList);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List<b> list = this.cues;
        int i = 0;
        int size = list == null ? 0 : list.size();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i2 = paddingBottom - paddingTop;
        float resolveTextSize = resolveTextSize(this.textSizeType, this.textSize, height, i2);
        if (resolveTextSize <= 0.0f) {
            return;
        }
        while (i < size) {
            b bVar = this.cues.get(i);
            int i3 = paddingBottom;
            int i4 = width;
            this.painters.get(i).draw(bVar, this.applyEmbeddedStyles, this.applyEmbeddedFontSizes, this.style, resolveTextSize, resolveCueTextSize(bVar, height, i2), this.bottomPaddingFraction, canvas, paddingLeft, paddingTop, i4, i3);
            i++;
            i2 = i2;
            paddingBottom = i3;
            width = i4;
            paddingLeft = paddingLeft;
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onCues(List<b> list) {
        setCues(list);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setActiveCues(Vector<d.b> vector) {
        String[] strArr;
        int size = vector.size();
        ArrayList arrayList = new ArrayList();
        String str = "";
        for (int i = 0; i < size; i++) {
            c.a.a.a.p.f.b bVar = vector.get(i);
            if (bVar != null && (strArr = bVar.p) != null) {
                for (String str2 : strArr) {
                    str = "".equals(str) ? str2 : str + "\n" + str2;
                }
            }
        }
        c.a(MessengerShareContentUtility.SUBTITLE, str);
        arrayList.add(new b(str));
        onCues(arrayList);
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        if (this.applyEmbeddedFontSizes == z) {
            return;
        }
        this.applyEmbeddedFontSizes = z;
        invalidate();
    }

    public void setApplyEmbeddedStyles(boolean z) {
        if (this.applyEmbeddedStyles == z && this.applyEmbeddedFontSizes == z) {
            return;
        }
        this.applyEmbeddedStyles = z;
        this.applyEmbeddedFontSizes = z;
        invalidate();
    }

    public void setBottomPaddingFraction(float f) {
        if (this.bottomPaddingFraction == f) {
            return;
        }
        this.bottomPaddingFraction = f;
        invalidate();
    }

    public void setCues(@Nullable List<b> list) {
        if (this.cues == list) {
            return;
        }
        this.cues = list;
        int size = list == null ? 0 : list.size();
        while (this.painters.size() < size) {
            this.painters.add(new SubtitlePainter(getContext()));
        }
        invalidate();
    }

    public void setFixedTextSize(int i, float f) {
        Context context = getContext();
        setTextSize(2, TypedValue.applyDimension(i, f, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    public void setFractionalTextSize(float f) {
        setFractionalTextSize(f, false);
    }

    public void setFractionalTextSize(float f, boolean z) {
        setTextSize(z ? 1 : 0, f);
    }

    public void setOnChangedListener(d.d.a aVar) {
    }

    public void setSize(int i, int i2) {
    }

    public void setStyle(a aVar) {
        if (this.style == aVar) {
            return;
        }
        this.style = aVar;
        invalidate();
    }

    public void setUserDefaultStyle() {
        setStyle((Util.SDK_INT < 19 || !isCaptionManagerEnabled() || isInEditMode()) ? a.g : getUserCaptionStyleV19());
    }

    public void setUserDefaultTextSize() {
        setFractionalTextSize(((Util.SDK_INT < 19 || isInEditMode()) ? 1.0f : getUserCaptionFontScaleV19()) * 0.0533f);
    }

    public void setVisible(boolean z) {
        setVisibility(z ? 0 : 4);
    }
}
