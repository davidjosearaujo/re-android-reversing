package d4;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public CharSequence f3613a;

    /* renamed from: b  reason: collision with root package name */
    public final TextPaint f3614b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3615c;

    /* renamed from: d  reason: collision with root package name */
    public int f3616d;

    /* renamed from: k  reason: collision with root package name */
    public boolean f3622k;
    public Layout.Alignment e = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: f  reason: collision with root package name */
    public int f3617f = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* renamed from: g  reason: collision with root package name */
    public float f3618g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f3619h = 1.0f;

    /* renamed from: i  reason: collision with root package name */
    public int f3620i = 1;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3621j = true;

    /* renamed from: l  reason: collision with root package name */
    public TextUtils.TruncateAt f3623l = null;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
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
            charSequence = TextUtils.ellipsize(charSequence, this.f3614b, (float) max, this.f3623l);
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
        if (!(f7 == 0.0f && this.f3619h == 1.0f)) {
            obtain.setLineSpacing(f7, this.f3619h);
        }
        if (this.f3617f > 1) {
            obtain.setHyphenationFrequency(this.f3620i);
        }
        return obtain.build();
    }
}
