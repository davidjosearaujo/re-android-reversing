package cn.jpush.android.u;

import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    private List<a> a;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a {
        private int a;
        private String b;
        private String c;
        private String d;
        private int e;
        private int f;
        private String g;

        public int a() {
            return this.a;
        }

        public void a(int i) {
            this.a = i;
        }

        public void a(String str) {
            this.b = str;
        }

        public String b() {
            return this.c;
        }

        public void b(int i) {
            this.e = i;
        }

        public void b(String str) {
            this.c = str;
        }

        public String c() {
            return this.d;
        }

        public void c(int i) {
            this.f = i;
        }

        public void c(String str) {
            this.d = str;
        }

        public int d() {
            return this.e;
        }

        public void d(String str) {
            this.g = str;
        }

        public int e() {
            return this.f;
        }

        public String f() {
            return this.g;
        }

        public String toString() {
            return "InMatches{version=" + this.a + ", manufacturer='" + this.b + "', model='" + this.c + "', rom='" + this.d + "', android_min=" + this.e + ", android_max=" + this.f + ", file_path='" + this.g + "'}";
        }
    }

    public List<a> a() {
        return this.a;
    }

    public void a(List<a> list) {
        this.a = list;
    }

    public String toString() {
        return "InAppMatchesConfig{inMatchesList=" + this.a + '}';
    }
}
