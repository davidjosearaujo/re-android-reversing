package com.hunantv.imgo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.hunantv.imgo.nightmode.view.SkinnableTextView;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class BeautifyTextView extends SkinnableTextView {
    public static final String c = "  ";
    private int a;
    private int b;

    public BeautifyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(Canvas canvas, int i, String str, float f) {
        float f2 = 0.0f;
        if (c(i, str)) {
            canvas.drawText(c, 0.0f, this.a, getPaint());
            f2 = 0.0f + StaticLayout.getDesiredWidth(c, getPaint());
            str = str.substring(3);
        }
        int length = str.length() - 1;
        int i2 = 2;
        if (str.length() > 2 && str.charAt(0) == 12288 && str.charAt(1) == 12288) {
            String substring = str.substring(0, 2);
            float desiredWidth = StaticLayout.getDesiredWidth(substring, getPaint());
            canvas.drawText(substring, f2, this.a, getPaint());
            f2 += desiredWidth;
        } else {
            i2 = 0;
        }
        float f3 = (this.b - f) / length;
        while (i2 < str.length()) {
            String valueOf = String.valueOf(str.charAt(i2));
            float desiredWidth2 = StaticLayout.getDesiredWidth(valueOf, getPaint());
            canvas.drawText(valueOf, f2, this.a, getPaint());
            f2 += desiredWidth2 + f3;
            i2++;
        }
    }

    private float b(Paint paint, String str) {
        float f = 0.0f;
        if (str != null && str.length() > 0) {
            int length = str.length();
            float[] fArr = new float[length];
            paint.getTextWidths(str, fArr);
            for (int i = 0; i < length; i++) {
                f += fArr[i];
            }
        }
        return f;
    }

    private boolean c(int i, String str) {
        return str.length() > 3 && str.charAt(0) == ' ' && str.charAt(1) == ' ';
    }

    private boolean d(String str) {
        return (str == null || str.length() == 0 || str.charAt(str.length() - 1) == '\n') ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas canvas) {
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();
        this.b = getMeasuredWidth();
        String charSequence = getText().toString();
        this.a = 0;
        this.a = (int) (0 + getTextSize());
        Layout layout = getLayout();
        if (layout == null) {
            return;
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int ceil = (int) ((((int) Math.ceil(fontMetrics.descent - fontMetrics.ascent)) * layout.getSpacingMultiplier()) + layout.getSpacingAdd());
        if (layout.getLineCount() == 1) {
            canvas.drawText(charSequence, (this.b - b(paint, charSequence)) / 2.0f, this.a, paint);
            return;
        }
        for (int i = 0; i < layout.getLineCount(); i++) {
            int lineStart = layout.getLineStart(i);
            int lineEnd = layout.getLineEnd(i);
            float desiredWidth = StaticLayout.getDesiredWidth(charSequence, lineStart, lineEnd, getPaint());
            String substring = charSequence.substring(lineStart, lineEnd);
            if (i < layout.getLineCount() - 1) {
                if (d(substring)) {
                    a(canvas, lineStart, substring, desiredWidth);
                } else {
                    canvas.drawText(substring, 0.0f, this.a, paint);
                }
            } else {
                canvas.drawText(substring, 0.0f, this.a, paint);
            }
            this.a += ceil;
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }
}
