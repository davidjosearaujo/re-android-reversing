package cn.jiguang.aw;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    private C0005a[] a = new C0005a[17];

    /* renamed from: cn.jiguang.aw.a$a  reason: collision with other inner class name */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class C0005a {
        public g a;
        public int b;
        public C0005a c;

        private C0005a() {
        }
    }

    public int a(g gVar) {
        int i = -1;
        for (C0005a c0005a = this.a[(gVar.hashCode() & Integer.MAX_VALUE) % 17]; c0005a != null; c0005a = c0005a.c) {
            if (c0005a.a.equals(gVar)) {
                i = c0005a.b;
            }
        }
        return i;
    }

    public void a(int i, g gVar) {
        if (i > 16383) {
            return;
        }
        int hashCode = (gVar.hashCode() & Integer.MAX_VALUE) % 17;
        C0005a c0005a = new C0005a();
        c0005a.a = gVar;
        c0005a.b = i;
        C0005a[] c0005aArr = this.a;
        c0005a.c = c0005aArr[hashCode];
        c0005aArr[hashCode] = c0005a;
    }
}
