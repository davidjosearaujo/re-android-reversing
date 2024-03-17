package com.hunantv.imgo.yaml;

import com.alibaba.android.arouter.utils.Consts;
import com.hunantv.imgo.yaml.error.YAMLException;
import j.l.a.d0.s.a;
import j.l.a.d0.s.b;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DumperOptions {
    private ScalarStyle a = ScalarStyle.PLAIN;
    private FlowStyle b = FlowStyle.AUTO;
    private boolean c = false;
    private boolean d = true;
    private boolean e = false;
    private int f = 2;
    private int g = 0;
    private int h = 80;
    private boolean i = true;
    private LineBreak j = LineBreak.UNIX;
    private boolean k = false;
    private boolean l = false;
    private TimeZone m = null;
    private Version n = null;
    private Map<String, String> o = null;
    private Boolean p = Boolean.FALSE;
    private a q = new b(0);

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum FlowStyle {
        FLOW(Boolean.TRUE),
        BLOCK(Boolean.FALSE),
        AUTO(null);
        
        private Boolean styleBoolean;

        FlowStyle(Boolean bool) {
            this.styleBoolean = bool;
        }

        public Boolean getStyleBoolean() {
            return this.styleBoolean;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Flow style: '" + this.styleBoolean + "'";
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum LineBreak {
        WIN("\r\n"),
        MAC("\r"),
        UNIX("\n");
        
        private String lineBreak;

        LineBreak(String str) {
            this.lineBreak = str;
        }

        public static LineBreak getPlatformLineBreak() {
            LineBreak[] values;
            String property = System.getProperty("line.separator");
            for (LineBreak lineBreak : values()) {
                if (lineBreak.lineBreak.equals(property)) {
                    return lineBreak;
                }
            }
            return UNIX;
        }

        public String getString() {
            return this.lineBreak;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Line break: " + name();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum ScalarStyle {
        DOUBLE_QUOTED('\"'),
        SINGLE_QUOTED('\''),
        LITERAL('|'),
        FOLDED('>'),
        PLAIN(null);
        
        private Character styleChar;

        ScalarStyle(Character ch) {
            this.styleChar = ch;
        }

        public static ScalarStyle createStyle(Character ch) {
            if (ch == null) {
                return PLAIN;
            }
            char charValue = ch.charValue();
            if (charValue != '\"') {
                if (charValue != '\'') {
                    if (charValue != '>') {
                        if (charValue == '|') {
                            return LITERAL;
                        }
                        throw new YAMLException("Unknown scalar style character: " + ch);
                    }
                    return FOLDED;
                }
                return SINGLE_QUOTED;
            }
            return DOUBLE_QUOTED;
        }

        public Character getChar() {
            return this.styleChar;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Scalar style: '" + this.styleChar + "'";
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum Version {
        V1_0(new Integer[]{1, 0}),
        V1_1(new Integer[]{1, 1});
        
        private Integer[] version;

        Version(Integer[] numArr) {
            this.version = numArr;
        }

        public String getRepresentation() {
            return this.version[0] + Consts.DOT + this.version[1];
        }

        public int major() {
            return this.version[0].intValue();
        }

        public int minor() {
            return this.version[1].intValue();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Version: " + getRepresentation();
        }
    }

    public void A(int i) {
        if (i < 0) {
            throw new YAMLException("Indicator indent must be non-negative.");
        }
        if (i <= 9) {
            this.g = i;
            return;
        }
        throw new YAMLException("Indicator indent must be at most Emitter.MAX_INDENT-1: 9");
    }

    public void B(LineBreak lineBreak) {
        Objects.requireNonNull(lineBreak, "Specify line break.");
        this.j = lineBreak;
    }

    public void C(boolean z) {
        this.p = Boolean.valueOf(z);
    }

    public void D(boolean z) {
        this.i = z;
    }

    public void E(Map<String, String> map) {
        this.o = map;
    }

    public void F(TimeZone timeZone) {
        this.m = timeZone;
    }

    public void G(Version version) {
        this.n = version;
    }

    public void H(int i) {
        this.h = i;
    }

    public a a() {
        return this.q;
    }

    public FlowStyle b() {
        return this.b;
    }

    public ScalarStyle c() {
        return this.a;
    }

    public int d() {
        return this.f;
    }

    public int e() {
        return this.g;
    }

    public LineBreak f() {
        return this.j;
    }

    public boolean g() {
        return this.i;
    }

    public Map<String, String> h() {
        return this.o;
    }

    public TimeZone i() {
        return this.m;
    }

    public Version j() {
        return this.n;
    }

    public int k() {
        return this.h;
    }

    public boolean l() {
        return this.e;
    }

    public boolean m() {
        return this.d;
    }

    public boolean n() {
        return this.c;
    }

    public boolean o() {
        return this.l;
    }

    public boolean p() {
        return this.k;
    }

    public boolean q() {
        return this.p.booleanValue();
    }

    public void r(boolean z) {
        this.e = z;
    }

    public void s(boolean z) {
        this.d = z;
    }

    public void t(a aVar) {
        this.q = aVar;
    }

    public void u(boolean z) {
        this.c = z;
    }

    public void v(FlowStyle flowStyle) {
        Objects.requireNonNull(flowStyle, "Use FlowStyle enum.");
        this.b = flowStyle;
    }

    public void w(ScalarStyle scalarStyle) {
        Objects.requireNonNull(scalarStyle, "Use ScalarStyle enum.");
        this.a = scalarStyle;
    }

    public void x(boolean z) {
        this.l = z;
    }

    public void y(boolean z) {
        this.k = z;
    }

    public void z(int i) {
        if (i < 1) {
            throw new YAMLException("Indent must be at least 1");
        }
        if (i <= 10) {
            this.f = i;
            return;
        }
        throw new YAMLException("Indent must be at most 10");
    }
}
