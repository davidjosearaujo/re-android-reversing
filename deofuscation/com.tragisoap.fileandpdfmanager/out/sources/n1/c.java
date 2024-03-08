package n1;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.activity.h;
import o1.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c implements Spannable {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextPaint f5118a;

        /* renamed from: b  reason: collision with root package name */
        public final TextDirectionHeuristic f5119b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5120c;

        /* renamed from: d  reason: collision with root package name */
        public final int f5121d;

        public a(PrecomputedText.Params params) {
            this.f5118a = params.getTextPaint();
            this.f5119b = params.getTextDirection();
            this.f5120c = params.getBreakStrategy();
            this.f5121d = params.getHyphenationFrequency();
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return (this.f5120c == aVar.f5120c && this.f5121d == aVar.f5121d && (this.f5118a.getTextSize() > aVar.f5118a.getTextSize() ? 1 : (this.f5118a.getTextSize() == aVar.f5118a.getTextSize() ? 0 : -1)) == 0 && (this.f5118a.getTextScaleX() > aVar.f5118a.getTextScaleX() ? 1 : (this.f5118a.getTextScaleX() == aVar.f5118a.getTextScaleX() ? 0 : -1)) == 0 && (this.f5118a.getTextSkewX() > aVar.f5118a.getTextSkewX() ? 1 : (this.f5118a.getTextSkewX() == aVar.f5118a.getTextSkewX() ? 0 : -1)) == 0 && (this.f5118a.getLetterSpacing() > aVar.f5118a.getLetterSpacing() ? 1 : (this.f5118a.getLetterSpacing() == aVar.f5118a.getLetterSpacing() ? 0 : -1)) == 0 && TextUtils.equals(this.f5118a.getFontFeatureSettings(), aVar.f5118a.getFontFeatureSettings()) && this.f5118a.getFlags() == aVar.f5118a.getFlags() && this.f5118a.getTextLocales().equals(aVar.f5118a.getTextLocales()) && (this.f5118a.getTypeface() != null ? this.f5118a.getTypeface().equals(aVar.f5118a.getTypeface()) : aVar.f5118a.getTypeface() == null)) && this.f5119b == aVar.f5119b;
        }

        public final int hashCode() {
            return b.b(Float.valueOf(this.f5118a.getTextSize()), Float.valueOf(this.f5118a.getTextScaleX()), Float.valueOf(this.f5118a.getTextSkewX()), Float.valueOf(this.f5118a.getLetterSpacing()), Integer.valueOf(this.f5118a.getFlags()), this.f5118a.getTextLocales(), this.f5118a.getTypeface(), Boolean.valueOf(this.f5118a.isElegantTextHeight()), this.f5119b, Integer.valueOf(this.f5120c), Integer.valueOf(this.f5121d));
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("{");
            StringBuilder d7 = h.d("textSize=");
            d7.append(this.f5118a.getTextSize());
            sb.append(d7.toString());
            sb.append(", textScaleX=" + this.f5118a.getTextScaleX());
            sb.append(", textSkewX=" + this.f5118a.getTextSkewX());
            sb.append(", letterSpacing=" + this.f5118a.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.f5118a.isElegantTextHeight());
            sb.append(", textLocale=" + this.f5118a.getTextLocales());
            sb.append(", typeface=" + this.f5118a.getTypeface());
            sb.append(", variationSettings=" + this.f5118a.getFontVariationSettings());
            sb.append(", textDir=" + this.f5119b);
            sb.append(", breakStrategy=" + this.f5120c);
            sb.append(", hyphenationFrequency=" + this.f5121d);
            sb.append("}");
            return sb.toString();
        }
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i7) {
        throw null;
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public final <T> T[] getSpans(int i7, int i8, Class<T> cls) {
        throw null;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        throw null;
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i7, int i8, Class cls) {
        throw null;
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            throw null;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i7, int i8, int i9) {
        if (!(obj instanceof MetricAffectingSpan)) {
            throw null;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i7, int i8) {
        throw null;
    }

    @Override // java.lang.CharSequence, java.lang.Object
    public final String toString() {
        throw null;
    }
}
