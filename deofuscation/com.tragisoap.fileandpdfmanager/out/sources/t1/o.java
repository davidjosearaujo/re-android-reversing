package t1;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import p1.c;
import p1.q;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class o implements q {
    @Override // p1.q
    public final c a(View view, c cVar) {
        CharSequence charSequence;
        if (Log.isLoggable("ReceiveContent", 3)) {
            Log.d("ReceiveContent", "onReceive: " + cVar);
        }
        if (cVar.f5470a.d() == 2) {
            return cVar;
        }
        ClipData a7 = cVar.f5470a.a();
        int b2 = cVar.f5470a.b();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z6 = false;
        for (int i7 = 0; i7 < a7.getItemCount(); i7++) {
            ClipData.Item itemAt = a7.getItemAt(i7);
            z6 = true;
            if ((b2 & 1) != 0) {
                charSequence = itemAt.coerceToText(context);
                if (charSequence instanceof Spanned) {
                    charSequence = charSequence.toString();
                }
            } else {
                charSequence = itemAt.coerceToStyledText(context);
            }
            if (charSequence != null) {
                if (!z6) {
                    int selectionStart = Selection.getSelectionStart(editable);
                    int selectionEnd = Selection.getSelectionEnd(editable);
                    int max = Math.max(0, Math.min(selectionStart, selectionEnd));
                    int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
                    Selection.setSelection(editable, max2);
                    editable.replace(max, max2, charSequence);
                } else {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), charSequence);
                }
            }
        }
        return null;
    }
}
