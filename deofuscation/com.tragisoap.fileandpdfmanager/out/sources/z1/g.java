package z1;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.f;
import java.lang.ref.WeakReference;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g implements TextWatcher {

    /* renamed from: f  reason: collision with root package name */
    public final EditText f6922f;

    /* renamed from: h  reason: collision with root package name */
    public a f6924h;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f6923g = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6925i = true;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends f.e {

        /* renamed from: a  reason: collision with root package name */
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
        int i8;
        if (i7 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            f a7 = f.a();
            if (editableText == null) {
                i8 = 0;
            } else {
                a7.getClass();
                i8 = editableText.length();
            }
            a7.f(0, i8, editableText);
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

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0019, code lost:
        if ((androidx.emoji2.text.f.f1509j != null) == false) goto L_0x001b;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    @Override // android.text.TextWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onTextChanged(java.lang.CharSequence r4, int r5, int r6, int r7) {
        /*
            r3 = this;
            android.widget.EditText r0 = r3.f6922f
            boolean r0 = r0.isInEditMode()
            if (r0 != 0) goto L_0x0056
            boolean r0 = r3.f6925i
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001b
            boolean r0 = r3.f6923g
            if (r0 != 0) goto L_0x001c
            androidx.emoji2.text.f r0 = androidx.emoji2.text.f.f1509j
            if (r0 == 0) goto L_0x0018
            r0 = r2
            goto L_0x0019
        L_0x0018:
            r0 = r1
        L_0x0019:
            if (r0 != 0) goto L_0x001c
        L_0x001b:
            r1 = r2
        L_0x001c:
            if (r1 == 0) goto L_0x001f
            goto L_0x0056
        L_0x001f:
            if (r6 > r7) goto L_0x0056
            boolean r6 = r4 instanceof android.text.Spannable
            if (r6 == 0) goto L_0x0056
            androidx.emoji2.text.f r6 = androidx.emoji2.text.f.a()
            int r6 = r6.b()
            if (r6 == 0) goto L_0x0040
            if (r6 == r2) goto L_0x0035
            r4 = 3
            if (r6 == r4) goto L_0x0040
            goto L_0x0056
        L_0x0035:
            android.text.Spannable r4 = (android.text.Spannable) r4
            androidx.emoji2.text.f r3 = androidx.emoji2.text.f.a()
            int r7 = r7 + r5
            r3.f(r5, r7, r4)
            goto L_0x0056
        L_0x0040:
            androidx.emoji2.text.f r4 = androidx.emoji2.text.f.a()
            z1.g$a r5 = r3.f6924h
            if (r5 != 0) goto L_0x0051
            z1.g$a r5 = new z1.g$a
            android.widget.EditText r6 = r3.f6922f
            r5.<init>(r6)
            r3.f6924h = r5
        L_0x0051:
            z1.g$a r3 = r3.f6924h
            r4.g(r3)
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.g.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }
}
