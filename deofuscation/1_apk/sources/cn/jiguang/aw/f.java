package cn.jiguang.aw;

import java.util.HashMap;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class f {
    private static Integer[] a = new Integer[64];
    private String d;
    private int e;
    private String f;
    private boolean h;
    private HashMap b = new HashMap();
    private HashMap c = new HashMap();
    private int g = Integer.MAX_VALUE;

    static {
        int i = 0;
        while (true) {
            Integer[] numArr = a;
            if (i >= numArr.length) {
                return;
            }
            numArr[i] = Integer.valueOf(i);
            i++;
        }
    }

    public f(String str, int i) {
        this.d = str;
        this.e = i;
    }

    private String a(String str) {
        int i = this.e;
        return i == 2 ? str.toUpperCase() : i == 3 ? str.toLowerCase() : str;
    }

    public static Integer b(int i) {
        if (i >= 0) {
            Integer[] numArr = a;
            if (i < numArr.length) {
                return numArr[i];
            }
        }
        return Integer.valueOf(i);
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(int i, String str) {
        c(i);
        Integer b = b(i);
        String a2 = a(str);
        this.b.put(a2, b);
        this.c.put(b, a2);
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void c(int i) {
        if (i < 0 || i > this.g) {
            throw new IllegalArgumentException(this.d + " " + i + "is out of range");
        }
    }

    public String d(int i) {
        c(i);
        String str = (String) this.c.get(b(i));
        if (str != null) {
            return str;
        }
        String num = Integer.toString(i);
        if (this.f != null) {
            return this.f + num;
        }
        return num;
    }
}
