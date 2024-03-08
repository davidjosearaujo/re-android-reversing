package z1;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.f;
import java.lang.ref.WeakReference;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f6911a;

    /* renamed from: b  reason: collision with root package name */
    public a f6912b;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends f.e {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference f6913a;

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference f6914b;

        public a(TextView textView, d dVar) {
            this.f6913a = new WeakReference(textView);
            this.f6914b = new WeakReference(dVar);
        }

        @Override // androidx.emoji2.text.f.e
        public final void a() {
            boolean z6;
            int i7;
            InputFilter[] filters;
            TextView textView = (TextView) this.f6913a.get();
            InputFilter inputFilter = (InputFilter) this.f6914b.get();
            if (!(inputFilter == null || textView == null || (filters = textView.getFilters()) == null)) {
                for (InputFilter inputFilter2 : filters) {
                    if (inputFilter2 == inputFilter) {
                        z6 = true;
                        break;
                    }
                }
            }
            z6 = false;
            if (z6 && textView.isAttachedToWindow()) {
                CharSequence text = textView.getText();
                f a7 = f.a();
                if (text == null) {
                    i7 = 0;
                } else {
                    a7.getClass();
                    i7 = text.length();
                }
                CharSequence f7 = a7.f(0, i7, text);
                if (text != f7) {
                    int selectionStart = Selection.getSelectionStart(f7);
                    int selectionEnd = Selection.getSelectionEnd(f7);
                    textView.setText(f7);
                    if (f7 instanceof Spannable) {
                        Spannable spannable = (Spannable) f7;
                        if (selectionStart >= 0 && selectionEnd >= 0) {
                            Selection.setSelection(spannable, selectionStart, selectionEnd);
                        } else if (selectionStart >= 0) {
                            Selection.setSelection(spannable, selectionStart);
                        } else if (selectionEnd >= 0) {
                            Selection.setSelection(spannable, selectionEnd);
                        }
                    }
                }
            }
        }
    }

    public d(TextView textView) {
        this.f6911a = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i7, int i8, Spanned spanned, int i9, int i10) {
        if (this.f6911a.isInEditMode()) {
            return charSequence;
        }
        int b2 = f.a().b();
        if (b2 != 0) {
            boolean z6 = true;
            if (b2 == 1) {
                if (i10 == 0 && i9 == 0 && spanned.length() == 0 && charSequence == this.f6911a.getText()) {
                    z6 = false;
                }
                if (!z6 || charSequence == null) {
                    return charSequence;
                }
                if (!(i7 == 0 && i8 == charSequence.length())) {
                    charSequence = charSequence.subSequence(i7, i8);
                }
                return f.a().f(0, charSequence.length(), charSequence);
            } else if (b2 != 3) {
                return charSequence;
            }
        }
        f a7 = f.a();
        if (this.f6912b == null) {
            this.f6912b = new a(this.f6911a, this);
        }
        a7.g(this.f6912b);
        return charSequence;
    }
}
