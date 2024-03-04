package z1;

import android.widget.EditText;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public final C0137a f6903a;

    /* renamed from: z1.a$a */
    /* loaded from: classes.dex */
    public static class C0137a extends b {

        /* renamed from: a */
        public final EditText f6904a;

        /* renamed from: b */
        public final g f6905b;

        public C0137a(EditText editText) {
            this.f6904a = editText;
            g gVar = new g(editText);
            this.f6905b = gVar;
            editText.addTextChangedListener(gVar);
            if (z1.b.f6907b == null) {
                synchronized (z1.b.f6906a) {
                    if (z1.b.f6907b == null) {
                        z1.b.f6907b = new z1.b();
                    }
                }
            }
            editText.setEditableFactory(z1.b.f6907b);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
    }

    public a(EditText editText) {
        if (editText == null) {
            throw new NullPointerException("editText cannot be null");
        }
        this.f6903a = new C0137a(editText);
    }
}
