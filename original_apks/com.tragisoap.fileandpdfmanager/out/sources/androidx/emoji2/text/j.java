package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.util.SparseArray;
import android.view.KeyEvent;
import androidx.emoji2.text.f;
import androidx.emoji2.text.n;
import i1.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j {

    /* renamed from: a */
    public final f.i f1534a;

    /* renamed from: b */
    public final n f1535b;

    /* renamed from: c */
    public f.d f1536c;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {

        /* renamed from: a */
        public int f1537a = 1;

        /* renamed from: b */
        public final n.a f1538b;

        /* renamed from: c */
        public n.a f1539c;

        /* renamed from: d */
        public n.a f1540d;
        public int e;

        /* renamed from: f */
        public int f1541f;

        public a(n.a aVar) {
            this.f1538b = aVar;
            this.f1539c = aVar;
        }

        public final int a(int i7) {
            SparseArray<n.a> sparseArray = this.f1539c.f1558a;
            n.a aVar = sparseArray == null ? null : sparseArray.get(i7);
            int i8 = 3;
            if (this.f1537a != 2) {
                if (aVar != null) {
                    this.f1537a = 2;
                    this.f1539c = aVar;
                    this.f1541f = 1;
                    i8 = 2;
                }
                b();
                i8 = 1;
            } else {
                if (aVar != null) {
                    this.f1539c = aVar;
                    this.f1541f++;
                } else {
                    boolean z6 = false;
                    if (!(i7 == 65038)) {
                        if (i7 == 65039) {
                            z6 = true;
                        }
                        if (!z6) {
                            n.a aVar2 = this.f1539c;
                            if (aVar2.f1559b != null) {
                                if (this.f1541f == 1) {
                                    if (c()) {
                                        aVar2 = this.f1539c;
                                    }
                                }
                                this.f1540d = aVar2;
                                b();
                            }
                        }
                    }
                    b();
                    i8 = 1;
                }
                i8 = 2;
            }
            this.e = i7;
            return i8;
        }

        public final void b() {
            this.f1537a = 1;
            this.f1539c = this.f1538b;
            this.f1541f = 0;
        }

        public final boolean c() {
            y1.a c7 = this.f1539c.f1559b.c();
            int a7 = c7.a(6);
            if ((a7 == 0 || c7.f6593b.get(a7 + c7.f6592a) == 0) ? false : true) {
                return true;
            }
            return this.e == 65039;
        }
    }

    public j(n nVar, f.i iVar, d dVar) {
        this.f1534a = iVar;
        this.f1535b = nVar;
        this.f1536c = dVar;
    }

    public static boolean a(Editable editable, KeyEvent keyEvent, boolean z6) {
        k[] kVarArr;
        if (!KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!(selectionStart == -1 || selectionEnd == -1 || selectionStart != selectionEnd) && (kVarArr = (k[]) editable.getSpans(selectionStart, selectionEnd, k.class)) != null && kVarArr.length > 0) {
            for (k kVar : kVarArr) {
                int spanStart = editable.getSpanStart(kVar);
                int spanEnd = editable.getSpanEnd(kVar);
                if ((z6 && spanStart == selectionStart) || ((!z6 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean b(CharSequence charSequence, int i7, int i8, i iVar) {
        if (iVar.f1533c == 0) {
            f.d dVar = this.f1536c;
            y1.a c7 = iVar.c();
            int a7 = c7.a(8);
            if (a7 != 0) {
                c7.f6593b.getShort(a7 + c7.f6592a);
            }
            d dVar2 = (d) dVar;
            dVar2.getClass();
            ThreadLocal<StringBuilder> threadLocal = d.f1505b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = threadLocal.get();
            sb.setLength(0);
            while (i7 < i8) {
                sb.append(charSequence.charAt(i7));
                i7++;
            }
            TextPaint textPaint = dVar2.f1506a;
            String sb2 = sb.toString();
            int i9 = c.f4466a;
            iVar.f1533c = c.a.a(textPaint, sb2) ? 2 : 1;
        }
        return iVar.f1533c == 2;
    }
}
