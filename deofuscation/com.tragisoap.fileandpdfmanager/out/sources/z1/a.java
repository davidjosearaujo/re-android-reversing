package z1;

import android.widget.EditText;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final C0137a f6903a;

    /* renamed from: z1.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0137a extends b {

        /* renamed from: a  reason: collision with root package name */
        public final EditText f6904a;

        /* renamed from: b  reason: collision with root package name */
        public final g f6905b;

        public C0137a(EditText editText) {
            this.f6904a = editText;
            g gVar = new g(editText);
            this.f6905b = gVar;
            editText.addTextChangedListener(gVar);
            if (b.f6907b == null) {
                synchronized (b.f6906a) {
                    if (b.f6907b == null) {
                        b.f6907b = new b();
                    }
                }
            }
            editText.setEditableFactory(b.f6907b);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {
    }

    public a(EditText editText) {
        if (editText != null) {
            this.f6903a = new C0137a(editText);
            return;
        }
        throw new NullPointerException("editText cannot be null");
    }
}
