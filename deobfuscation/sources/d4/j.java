package d4;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a */
    public CharSequence f3613a;

    /* renamed from: b */
    public final TextPaint f3614b;

    /* renamed from: c */
    public final int f3615c;

    /* renamed from: d */
    public int f3616d;

    /* renamed from: k */
    public boolean f3622k;
    public Layout.Alignment e = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: f */
    public int f3617f = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* renamed from: g */
    public float f3618g = 0.0f;

    /* renamed from: h */
    public float f3619h = 1.0f;

    /* renamed from: i */
    public int f3620i = 1;

    /* renamed from: j */
    public boolean f3621j = true;

    /* renamed from: l */
    public TextUtils.TruncateAt f3623l = null;

    /* loaded from: classes.dex */
    public static class a extends Exception {
    }

    public j(CharSequence charSequence, TextPaint textPaint, int i7) {
        this.f3613a = charSequence;
        this.f3614b = textPaint;
        this.f3615c = i7;
        this.f3616d = charSequence.length();
    }

    public final StaticLayout a() {
        if (this.f3613a == null) {
            this.f3613a = "";
        }
        int max = Math.max(0, this.f3615c);
        CharSequence charSequence = this.f3613a;
        if (this.f3617f == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f3614b, max, this.f3623l);
        }
        int min = Math.min(charSequence.length(), this.f3616d);
        this.f3616d = min;
        if (this.f3622k && this.f3617f == 1) {
            this.e = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, min, this.f3614b, max);
        obtain.setAlignment(this.e);
        obtain.setIncludePad(this.f3621j);
        obtain.setTextDirection(this.f3622k ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f3623l;
        if (truncateAt != null) {
            obtain.setEllipsize(truncateAt);
        }
        obtain.setMaxLines(this.f3617f);
        float f7 = this.f3618g;
        if (f7 != 0.0f || this.f3619h != 1.0f) {
            obtain.setLineSpacing(f7, this.f3619h);
        }
        if (this.f3617f > 1) {
            obtain.setHyphenationFrequency(this.f3620i);
        }
        return obtain.build();
    }
}
