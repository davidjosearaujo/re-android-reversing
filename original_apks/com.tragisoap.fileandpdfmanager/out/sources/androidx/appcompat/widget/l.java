package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.emoji2.text.f;
import java.io.File;
import java.util.HashMap;
import p2.c;
import p2.h;
import p2.k;
import r2.v;
import y2.d;
import z1.a;
import z1.e;
import z1.g;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l implements k {

    /* renamed from: f */
    public final Object f963f;

    /* renamed from: g */
    public final Object f964g;

    public /* synthetic */ l() {
        this.f963f = new HashMap();
        this.f964g = new HashMap();
    }

    public /* synthetic */ l(EditText editText) {
        this.f963f = editText;
        this.f964g = new a(editText);
    }

    public /* synthetic */ l(Object obj, Object obj2) {
        this.f963f = obj;
        this.f964g = obj2;
    }

    public final KeyListener a(KeyListener keyListener) {
        if (!(!(keyListener instanceof NumberKeyListener))) {
            return keyListener;
        }
        ((a) this.f964g).f6903a.getClass();
        if (keyListener instanceof e) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new e(keyListener);
    }

    /* JADX WARN: Finally extract failed */
    public final void b(AttributeSet attributeSet, int i7) {
        TypedArray obtainStyledAttributes = ((EditText) this.f963f).getContext().obtainStyledAttributes(attributeSet, a0.e.E, i7, 0);
        try {
            boolean z6 = true;
            if (obtainStyledAttributes.hasValue(14)) {
                z6 = obtainStyledAttributes.getBoolean(14, true);
            }
            obtainStyledAttributes.recycle();
            f(z6);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // p2.d
    public final boolean c(Object obj, File file, h hVar) {
        return ((k) this.f964g).c(new d(((BitmapDrawable) ((v) obj).get()).getBitmap(), (s2.d) this.f963f), file, hVar);
    }

    @Override // p2.k
    public final c d(h hVar) {
        return ((k) this.f964g).d(hVar);
    }

    public final InputConnection e(InputConnection inputConnection, EditorInfo editorInfo) {
        a aVar = (a) this.f964g;
        if (inputConnection == null) {
            aVar.getClass();
            return null;
        }
        a.C0137a aVar2 = aVar.f6903a;
        aVar2.getClass();
        if (!(inputConnection instanceof z1.c)) {
            inputConnection = new z1.c(aVar2.f6904a, inputConnection, editorInfo);
        }
        return inputConnection;
    }

    public final void f(boolean z6) {
        g gVar = ((a) this.f964g).f6903a.f6905b;
        if (gVar.f6925i != z6) {
            if (gVar.f6924h != null) {
                f a7 = f.a();
                g.a aVar = gVar.f6924h;
                a7.getClass();
                a0.e.i(aVar, "initCallback cannot be null");
                a7.f1510a.writeLock().lock();
                try {
                    a7.f1511b.remove(aVar);
                } finally {
                    a7.f1510a.writeLock().unlock();
                }
            }
            gVar.f6925i = z6;
            if (z6) {
                g.a(gVar.f6922f, f.a().b());
            }
        }
    }
}
