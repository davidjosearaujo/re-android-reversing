package androidx.activity;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final /* synthetic */ class h {
    public static /* synthetic */ long a(int i7) {
        if (i7 == 1) {
            return 0L;
        }
        if (i7 == 2) {
            return 1L;
        }
        if (i7 == 3) {
            return 2L;
        }
        if (i7 == 4) {
            return 3L;
        }
        if (i7 == 5) {
            return 4L;
        }
        throw null;
    }

    public static String b(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.B());
        return sb.toString();
    }

    public static String c(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder d(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static /* synthetic */ String e(int i7) {
        return i7 == 1 ? "NONE" : i7 == 2 ? "ADDING" : i7 == 3 ? "REMOVING" : "null";
    }

    public static /* synthetic */ String f(int i7) {
        return i7 == 1 ? "INITIALIZE" : i7 == 2 ? "RESOURCE_CACHE" : i7 == 3 ? "DATA_CACHE" : i7 == 4 ? "SOURCE" : i7 == 5 ? "ENCODE" : i7 == 6 ? "FINISHED" : "null";
    }
}
