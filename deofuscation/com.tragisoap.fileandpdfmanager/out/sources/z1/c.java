package z1;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import android.widget.TextView;
import androidx.emoji2.text.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f6909a;

    /* renamed from: b  reason: collision with root package name */
    public final a f6910b;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
            if (java.lang.Character.isHighSurrogate(r5) != false) goto L_0x0053;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0080, code lost:
            if (r11 != false) goto L_0x00ab;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x008d, code lost:
            if (java.lang.Character.isLowSurrogate(r5) != false) goto L_0x0090;
         */
        /* JADX WARN: Removed duplicated region for block: B:44:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00ae A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x007c A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:93:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static boolean a(android.view.inputmethod.InputConnection r7, android.text.Editable r8, int r9, int r10, boolean r11) {
            /*
                Method dump skipped, instructions count: 252
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: z1.c.a.a(android.view.inputmethod.InputConnection, android.text.Editable, int, int, boolean):boolean");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        super(inputConnection, false);
        a aVar = new a();
        boolean z6 = false;
        this.f6909a = editText;
        this.f6910b = aVar;
        if (f.f1509j != null ? true : z6) {
            f.a().h(editorInfo);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i7, int i8) {
        a aVar = this.f6910b;
        Editable editableText = this.f6909a.getEditableText();
        aVar.getClass();
        return a.a(this, editableText, i7, i8, false) || super.deleteSurroundingText(i7, i8);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i7, int i8) {
        a aVar = this.f6910b;
        Editable editableText = this.f6909a.getEditableText();
        aVar.getClass();
        return a.a(this, editableText, i7, i8, true) || super.deleteSurroundingTextInCodePoints(i7, i8);
    }
}
