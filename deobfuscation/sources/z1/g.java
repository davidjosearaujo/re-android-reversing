package z1;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.f;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class g implements TextWatcher {

    /* renamed from: f */
    public final EditText f6922f;

    /* renamed from: h */
    public a f6924h;

    /* renamed from: g */
    public final boolean f6923g = false;

    /* renamed from: i */
    public boolean f6925i = true;

    /* loaded from: classes.dex */
    public static class a extends f.e {

        /* renamed from: a */
        public final WeakReference f6926a;

        public a(EditText editText) {
            this.f6926a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.f.e
        public final void a() {
            g.a((EditText) this.f6926a.get(), 1);
        }
    }

    public g(EditText editText) {
        this.f6922f = editText;
    }

    public static void a(EditText editText, int i7) {
        int length;
        if (i7 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.f a7 = androidx.emoji2.text.f.a();
            if (editableText == null) {
                length = 0;
            } else {
                a7.getClass();
                length = editableText.length();
            }
            a7.f(0, length, editableText);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x0019, code lost:
        if ((androidx.emoji2.text.f.f1509j != null) == false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:132:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0048  */
    @Override // android.text.TextWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onTextChanged(java.lang.CharSequence r4, int r5, int r6, int r7) {
        /*
            r3 = this;
            android.widget.EditText r0 = r3.f6922f
            boolean r0 = r0.isInEditMode()
            if (r0 != 0) goto L56
            boolean r0 = r3.f6925i
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1b
            boolean r0 = r3.f6923g
            if (r0 != 0) goto L1c
            androidx.emoji2.text.f r0 = androidx.emoji2.text.f.f1509j
            if (r0 == 0) goto L18
            r0 = r2
            goto L19
        L18:
            r0 = r1
        L19:
            if (r0 != 0) goto L1c
        L1b:
            r1 = r2
        L1c:
            if (r1 == 0) goto L1f
            goto L56
        L1f:
            if (r6 > r7) goto L56
            boolean r6 = r4 instanceof android.text.Spannable
            if (r6 == 0) goto L56
            androidx.emoji2.text.f r6 = androidx.emoji2.text.f.a()
            int r6 = r6.b()
            if (r6 == 0) goto L40
            if (r6 == r2) goto L35
            r4 = 3
            if (r6 == r4) goto L40
            goto L56
        L35:
            android.text.Spannable r4 = (android.text.Spannable) r4
            androidx.emoji2.text.f r3 = androidx.emoji2.text.f.a()
            int r7 = r7 + r5
            r3.f(r5, r7, r4)
            goto L56
        L40:
            androidx.emoji2.text.f r4 = androidx.emoji2.text.f.a()
            z1.g$a r5 = r3.f6924h
            if (r5 != 0) goto L51
            z1.g$a r5 = new z1.g$a
            android.widget.EditText r6 = r3.f6922f
            r5.<init>(r6)
            r3.f6924h = r5
        L51:
            z1.g$a r3 = r3.f6924h
            r4.g(r3)
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.g.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }
}
