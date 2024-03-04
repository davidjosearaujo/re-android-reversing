package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import java.io.File;
import java.util.HashMap;
import z1.a;
import z1.g;

/* loaded from: classes.dex */
public final class l implements p2.k {

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
        this.f964g = new z1.a(editText);
    }

    public /* synthetic */ l(Object obj, Object obj2) {
        this.f963f = obj;
        this.f964g = obj2;
    }

    public final KeyListener a(KeyListener keyListener) {
        if (!(keyListener instanceof NumberKeyListener)) {
            ((z1.a) this.f964g).f6903a.getClass();
            if (keyListener instanceof z1.e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new z1.e(keyListener);
        }
        return keyListener;
    }

    public final void b(AttributeSet attributeSet, int i7) {
        TypedArray obtainStyledAttributes = ((EditText) this.f963f).getContext().obtainStyledAttributes(attributeSet, a0.e.E, i7, 0);
        try {
            boolean z6 = obtainStyledAttributes.hasValue(14) ? obtainStyledAttributes.getBoolean(14, true) : true;
            obtainStyledAttributes.recycle();
            f(z6);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // p2.d
    public final boolean c(Object obj, File file, p2.h hVar) {
        return ((p2.k) this.f964g).c(new y2.d(((BitmapDrawable) ((r2.v) obj).get()).getBitmap(), (s2.d) this.f963f), file, hVar);
    }

    @Override // p2.k
    public final p2.c d(p2.h hVar) {
        return ((p2.k) this.f964g).d(hVar);
    }

    public final InputConnection e(InputConnection inputConnection, EditorInfo editorInfo) {
        z1.a aVar = (z1.a) this.f964g;
        if (inputConnection == null) {
            aVar.getClass();
            return null;
        }
        a.C0137a c0137a = aVar.f6903a;
        c0137a.getClass();
        if (!(inputConnection instanceof z1.c)) {
            inputConnection = new z1.c(c0137a.f6904a, inputConnection, editorInfo);
        }
        return inputConnection;
    }

    public final void f(boolean z6) {
        z1.g gVar = ((z1.a) this.f964g).f6903a.f6905b;
        if (gVar.f6925i != z6) {
            if (gVar.f6924h != null) {
                androidx.emoji2.text.f a7 = androidx.emoji2.text.f.a();
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
                z1.g.a(gVar.f6922f, androidx.emoji2.text.f.a().b());
            }
        }
    }
}
