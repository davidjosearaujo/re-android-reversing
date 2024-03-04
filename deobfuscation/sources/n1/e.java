package n1;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a */
    public static final d f5122a = new d(null, false);

    /* renamed from: b */
    public static final d f5123b = new d(null, true);

    /* renamed from: c */
    public static final d f5124c;

    /* renamed from: d */
    public static final d f5125d;

    /* loaded from: classes.dex */
    public static class a implements b {

        /* renamed from: a */
        public static final a f5126a = new a();

        @Override // n1.e.b
        public final int a(CharSequence charSequence, int i7) {
            int i8 = i7 + 0;
            int i9 = 2;
            for (int i10 = 0; i10 < i8 && i9 == 2; i10++) {
                byte directionality = Character.getDirectionality(charSequence.charAt(i10));
                d dVar = e.f5122a;
                if (directionality != 0) {
                    if (directionality != 1 && directionality != 2) {
                        switch (directionality) {
                            case 14:
                            case 15:
                                break;
                            case 16:
                            case 17:
                                break;
                            default:
                                i9 = 2;
                                break;
                        }
                    }
                    i9 = 0;
                }
                i9 = 1;
            }
            return i9;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        int a(CharSequence charSequence, int i7);
    }

    /* loaded from: classes.dex */
    public static abstract class c implements n1.d {

        /* renamed from: a */
        public final b f5127a;

        public c(a aVar) {
            this.f5127a = aVar;
        }

        public abstract boolean a();

        public final boolean b(CharSequence charSequence, int i7) {
            if (charSequence == null || i7 < 0 || charSequence.length() - i7 < 0) {
                throw new IllegalArgumentException();
            }
            b bVar = this.f5127a;
            if (bVar == null) {
                return a();
            }
            int a7 = bVar.a(charSequence, i7);
            if (a7 != 0) {
                if (a7 != 1) {
                    return a();
                }
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends c {

        /* renamed from: b */
        public final boolean f5128b;

        public d(a aVar, boolean z6) {
            super(aVar);
            this.f5128b = z6;
        }

        @Override // n1.e.c
        public final boolean a() {
            return this.f5128b;
        }
    }

    static {
        a aVar = a.f5126a;
        f5124c = new d(aVar, false);
        f5125d = new d(aVar, true);
    }
}
