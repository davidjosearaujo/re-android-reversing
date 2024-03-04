package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.emoji2.text.f;

/* loaded from: classes.dex */
public final class d implements f.d {

    /* renamed from: b */
    public static final ThreadLocal<StringBuilder> f1505b = new ThreadLocal<>();

    /* renamed from: a */
    public final TextPaint f1506a;

    public d() {
        TextPaint textPaint = new TextPaint();
        this.f1506a = textPaint;
        textPaint.setTextSize(10.0f);
    }
}
