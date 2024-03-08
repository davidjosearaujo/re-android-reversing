package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import p1.c;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class v {
    /* JADX WARN: Finally extract failed */
    public static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ClipData clipData = dragEvent.getClipData();
            y.f(textView, (Build.VERSION.SDK_INT >= 31 ? new c.a(clipData, 3) : new c.C0093c(clipData, 3)).build());
            textView.endBatchEdit();
            return true;
        } catch (Throwable th) {
            textView.endBatchEdit();
            throw th;
        }
    }

    public static boolean b(DragEvent dragEvent, View view, Activity activity) {
        activity.requestDragAndDropPermissions(dragEvent);
        ClipData clipData = dragEvent.getClipData();
        y.f(view, (Build.VERSION.SDK_INT >= 31 ? new c.a(clipData, 3) : new c.C0093c(clipData, 3)).build());
        return true;
    }
}
