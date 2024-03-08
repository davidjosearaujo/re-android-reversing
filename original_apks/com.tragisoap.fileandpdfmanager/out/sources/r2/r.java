package r2;

import android.util.Log;
import androidx.activity.h;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p2.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class r extends Exception {

    /* renamed from: k  reason: collision with root package name */
    public static final StackTraceElement[] f5860k = new StackTraceElement[0];

    /* renamed from: f  reason: collision with root package name */
    public final List<Throwable> f5861f;

    /* renamed from: g  reason: collision with root package name */
    public f f5862g;

    /* renamed from: h  reason: collision with root package name */
    public p2.a f5863h;

    /* renamed from: i  reason: collision with root package name */
    public Class<?> f5864i;

    /* renamed from: j  reason: collision with root package name */
    public String f5865j;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a implements Appendable {

        /* renamed from: f  reason: collision with root package name */
        public final Appendable f5866f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f5867g = true;

        public a(Appendable appendable) {
            this.f5866f = appendable;
        }

        @Override // java.lang.Appendable
        public final Appendable append(char c7) {
            boolean z6 = false;
            if (this.f5867g) {
                this.f5867g = false;
                this.f5866f.append("  ");
            }
            if (c7 == '\n') {
                z6 = true;
            }
            this.f5867g = z6;
            this.f5866f.append(c7);
            return this;
        }

        @Override // java.lang.Appendable
        public final Appendable append(CharSequence charSequence) {
            if (charSequence == null) {
                charSequence = "";
            }
            append(charSequence, 0, charSequence.length());
            return this;
        }

        @Override // java.lang.Appendable
        public final Appendable append(CharSequence charSequence, int i7, int i8) {
            if (charSequence == null) {
                charSequence = "";
            }
            boolean z6 = false;
            if (this.f5867g) {
                this.f5867g = false;
                this.f5866f.append("  ");
            }
            if (charSequence.length() > 0 && charSequence.charAt(i8 - 1) == '\n') {
                z6 = true;
            }
            this.f5867g = z6;
            this.f5866f.append(charSequence, i7, i8);
            return this;
        }
    }

    public r(String str) {
        this(str, Collections.emptyList());
    }

    public r(String str, List<Throwable> list) {
        this.f5865j = str;
        setStackTrace(f5860k);
        this.f5861f = list;
    }

    public static void a(Throwable th, ArrayList arrayList) {
        if (th instanceof r) {
            for (Throwable th2 : ((r) th).f5861f) {
                a(th2, arrayList);
            }
            return;
        }
        arrayList.add(th);
    }

    public static void b(List list, a aVar) {
        try {
            c(list, aVar);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void c(List list, a aVar) {
        int size = list.size();
        int i7 = 0;
        while (i7 < size) {
            aVar.append("Cause (");
            int i8 = i7 + 1;
            aVar.append(String.valueOf(i8));
            aVar.append(" of ");
            aVar.append(String.valueOf(size));
            aVar.append("): ");
            Throwable th = (Throwable) list.get(i7);
            if (th instanceof r) {
                ((r) th).f(aVar);
            } else {
                d(th, aVar);
            }
            i7 = i8;
        }
    }

    public static void d(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    public final void e() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size) {
            StringBuilder d7 = h.d("Root cause (");
            int i8 = i7 + 1;
            d7.append(i8);
            d7.append(" of ");
            d7.append(size);
            d7.append(")");
            Log.i("Glide", d7.toString(), (Throwable) arrayList.get(i7));
            i7 = i8;
        }
    }

    public final void f(Appendable appendable) {
        d(this, appendable);
        b(this.f5861f, new a(appendable));
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String str;
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f5865j);
        String str4 = "";
        if (this.f5864i != null) {
            StringBuilder d7 = h.d(", ");
            d7.append(this.f5864i);
            str = d7.toString();
        } else {
            str = str4;
        }
        sb.append(str);
        if (this.f5863h != null) {
            StringBuilder d8 = h.d(", ");
            d8.append(this.f5863h);
            str2 = d8.toString();
        } else {
            str2 = str4;
        }
        sb.append(str2);
        if (this.f5862g != null) {
            StringBuilder d9 = h.d(", ");
            d9.append(this.f5862g);
            str4 = d9.toString();
        }
        sb.append(str4);
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        if (arrayList.isEmpty()) {
            return sb.toString();
        }
        if (arrayList.size() == 1) {
            str3 = "\nThere was 1 root cause:";
        } else {
            sb.append("\nThere were ");
            sb.append(arrayList.size());
            str3 = " root causes:";
        }
        sb.append(str3);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Throwable th = (Throwable) it.next();
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() {
        f(System.err);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) {
        f(printStream);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) {
        f(printWriter);
    }
}
