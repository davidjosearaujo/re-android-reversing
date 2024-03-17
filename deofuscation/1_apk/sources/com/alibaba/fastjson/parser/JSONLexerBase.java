package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class JSONLexerBase implements JSONLexer, Closeable {
    public static final int INT_MULTMIN_RADIX_TEN = -214748364;
    public static final long MULTMIN_RADIX_TEN = -922337203685477580L;
    public int bp;
    public char ch;
    public int eofPos;
    public int features;
    public boolean hasSpecial;
    public int np;
    public int pos;
    public char[] sbuf;
    public int sp;
    public String stringDefaultValue;
    public int token;
    private static final ThreadLocal<char[]> SBUF_LOCAL = new ThreadLocal<>();
    public static final char[] typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
    public static final int[] digits = new int[103];
    public Calendar calendar = null;
    public TimeZone timeZone = JSON.defaultTimeZone;
    public Locale locale = JSON.defaultLocale;
    public int matchStat = 0;
    public int nanos = 0;

    static {
        for (int i = 48; i <= 57; i++) {
            digits[i] = i - 48;
        }
        for (int i2 = 97; i2 <= 102; i2++) {
            digits[i2] = (i2 - 97) + 10;
        }
        for (int i3 = 65; i3 <= 70; i3++) {
            digits[i3] = (i3 - 65) + 10;
        }
    }

    public JSONLexerBase(int i) {
        this.stringDefaultValue = null;
        this.features = i;
        if ((i & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
        char[] cArr = SBUF_LOCAL.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
    }

    public static boolean isWhitespace(char c) {
        return c <= ' ' && (c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b');
    }

    public static String readString(char[] cArr, int i) {
        int i2;
        char[] cArr2 = new char[i];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            char c = cArr[i3];
            if (c != '\\') {
                cArr2[i4] = c;
                i4++;
            } else {
                i3++;
                char c2 = cArr[i3];
                if (c2 == '\"') {
                    i2 = i4 + 1;
                    cArr2[i4] = '\"';
                } else if (c2 != '\'') {
                    if (c2 != 'F') {
                        if (c2 == '\\') {
                            i2 = i4 + 1;
                            cArr2[i4] = '\\';
                        } else if (c2 == 'b') {
                            i2 = i4 + 1;
                            cArr2[i4] = '\b';
                        } else if (c2 != 'f') {
                            if (c2 == 'n') {
                                i2 = i4 + 1;
                                cArr2[i4] = '\n';
                            } else if (c2 == 'r') {
                                i2 = i4 + 1;
                                cArr2[i4] = '\r';
                            } else if (c2 != 'x') {
                                switch (c2) {
                                    case '/':
                                        i2 = i4 + 1;
                                        cArr2[i4] = '/';
                                        break;
                                    case '0':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 0;
                                        break;
                                    case '1':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 1;
                                        break;
                                    case '2':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 2;
                                        break;
                                    case '3':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 3;
                                        break;
                                    case '4':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 4;
                                        break;
                                    case '5':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 5;
                                        break;
                                    case '6':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 6;
                                        break;
                                    case '7':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 7;
                                        break;
                                    default:
                                        switch (c2) {
                                            case 't':
                                                i2 = i4 + 1;
                                                cArr2[i4] = '\t';
                                                break;
                                            case 'u':
                                                i2 = i4 + 1;
                                                int i5 = i3 + 1;
                                                int i6 = i5 + 1;
                                                int i7 = i6 + 1;
                                                i3 = i7 + 1;
                                                cArr2[i4] = (char) Integer.parseInt(new String(new char[]{cArr[i5], cArr[i6], cArr[i7], cArr[i3]}), 16);
                                                break;
                                            case 'v':
                                                i2 = i4 + 1;
                                                cArr2[i4] = 11;
                                                break;
                                            default:
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                i2 = i4 + 1;
                                int[] iArr = digits;
                                int i8 = i3 + 1;
                                i3 = i8 + 1;
                                cArr2[i4] = (char) ((iArr[cArr[i8]] * 16) + iArr[cArr[i3]]);
                            }
                        }
                    }
                    i2 = i4 + 1;
                    cArr2[i4] = '\f';
                } else {
                    i2 = i4 + 1;
                    cArr2[i4] = '\'';
                }
                i4 = i2;
            }
            i3++;
        }
        return new String(cArr2, 0, i4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:235:0x014b, code lost:
        throw new com.alibaba.fastjson.JSONException("invalid escape character \\x" + r1 + r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void scanStringSingleQuote() {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanStringSingleQuote():void");
    }

    public abstract String addSymbol(int i, int i2, int i3, SymbolTable symbolTable);

    public abstract void arrayCopy(int i, char[] cArr, int i2, int i3);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract byte[] bytesValue();

    public abstract boolean charArrayCompare(char[] cArr);

    public abstract char charAt(int i);

    @Override // com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8192) {
            SBUF_LOCAL.set(cArr);
        }
        this.sbuf = null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void config(Feature feature, boolean z) {
        int config = Feature.config(this.features, feature, z);
        this.features = config;
        if ((config & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
    }

    public abstract void copyTo(int i, int i2, char[] cArr);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number decimalValue(boolean z) {
        char charAt = charAt((this.np + this.sp) - 1);
        try {
            if (charAt == 'F') {
                return Float.valueOf(Float.parseFloat(numberString()));
            }
            if (charAt == 'D') {
                return Double.valueOf(Double.parseDouble(numberString()));
            }
            if (z) {
                return decimalValue();
            }
            return Double.valueOf(doubleValue());
        } catch (NumberFormatException e) {
            throw new JSONException(e.getMessage() + ", " + info());
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract BigDecimal decimalValue();

    public double doubleValue() {
        return Double.parseDouble(numberString());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public float floatValue() {
        char charAt;
        String numberString = numberString();
        float parseFloat = Float.parseFloat(numberString);
        if ((parseFloat == 0.0f || parseFloat == Float.POSITIVE_INFINITY) && (charAt = numberString.charAt(0)) > '0' && charAt <= '9') {
            throw new JSONException("float overflow : " + numberString);
        }
        return parseFloat;
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final char getCurrent() {
        return this.ch;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int getFeatures() {
        return this.features;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Locale getLocale() {
        return this.locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public abstract int indexOf(char c, int i);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        return "";
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int intValue() {
        int i;
        boolean z;
        int i2 = 0;
        if (this.np == -1) {
            this.np = 0;
        }
        int i3 = this.np;
        int i4 = this.sp + i3;
        if (charAt(i3) == '-') {
            i = Integer.MIN_VALUE;
            i3++;
            z = true;
        } else {
            i = -2147483647;
            z = false;
        }
        if (i3 < i4) {
            i2 = -(charAt(i3) - '0');
            i3++;
        }
        while (i3 < i4) {
            int i5 = i3 + 1;
            char charAt = charAt(i3);
            if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                i3 = i5;
                break;
            }
            int i6 = charAt - '0';
            if (i2 < -214748364) {
                throw new NumberFormatException(numberString());
            }
            int i7 = i2 * 10;
            if (i7 < i + i6) {
                throw new NumberFormatException(numberString());
            }
            i2 = i7 - i6;
            i3 = i5;
        }
        if (z) {
            if (i3 > this.np + 1) {
                return i2;
            }
            throw new NumberFormatException(numberString());
        }
        return -i2;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number integerValue() throws NumberFormatException {
        long j;
        long j2;
        boolean z = false;
        if (this.np == -1) {
            this.np = 0;
        }
        int i = this.np;
        int i2 = this.sp + i;
        char c = ' ';
        char charAt = charAt(i2 - 1);
        if (charAt == 'B') {
            i2--;
            c = 'B';
        } else if (charAt == 'L') {
            i2--;
            c = 'L';
        } else if (charAt == 'S') {
            i2--;
            c = 'S';
        }
        if (charAt(this.np) == '-') {
            j = Long.MIN_VALUE;
            i++;
            z = true;
        } else {
            j = -9223372036854775807L;
        }
        long j3 = MULTMIN_RADIX_TEN;
        if (i < i2) {
            j2 = -(charAt(i) - '0');
            i++;
        } else {
            j2 = 0;
        }
        while (i < i2) {
            int i3 = i + 1;
            int charAt2 = charAt(i) - '0';
            if (j2 < j3) {
                return new BigInteger(numberString());
            }
            long j4 = j2 * 10;
            long j5 = charAt2;
            if (j4 < j + j5) {
                return new BigInteger(numberString());
            }
            j2 = j4 - j5;
            i = i3;
            j3 = MULTMIN_RADIX_TEN;
        }
        if (!z) {
            long j6 = -j2;
            if (j6 > 2147483647L || c == 'L') {
                return Long.valueOf(j6);
            }
            if (c == 'S') {
                return Short.valueOf((short) j6);
            }
            if (c == 'B') {
                return Byte.valueOf((byte) j6);
            }
            return Integer.valueOf((int) j6);
        } else if (i > this.np + 1) {
            if (j2 < -2147483648L || c == 'L') {
                return Long.valueOf(j2);
            }
            if (c == 'S') {
                return Short.valueOf((short) j2);
            }
            if (c == 'B') {
                return Byte.valueOf((byte) j2);
            }
            return Integer.valueOf((int) j2);
        } else {
            throw new NumberFormatException(numberString());
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean isBlankInput() {
        int i = 0;
        while (true) {
            char charAt = charAt(i);
            if (charAt == 26) {
                this.token = 20;
                return true;
            } else if (!isWhitespace(charAt)) {
                return false;
            } else {
                i++;
            }
        }
    }

    public abstract boolean isEOF();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(Feature feature) {
        return isEnabled(feature.mask);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isRef() {
        return this.sp == 4 && charAt(this.np + 1) == '$' && charAt(this.np + 2) == 'r' && charAt(this.np + 3) == 'e' && charAt(this.np + 4) == 'f';
    }

    public void lexError(String str, Object... objArr) {
        this.token = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0085  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x005c -> B:52:0x0032). Please submit an issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long longValue() throws java.lang.NumberFormatException {
        /*
            r15 = this;
            int r0 = r15.np
            r1 = 0
            r2 = -1
            if (r0 != r2) goto L8
            r15.np = r1
        L8:
            int r0 = r15.np
            int r2 = r15.sp
            int r2 = r2 + r0
            char r3 = r15.charAt(r0)
            r4 = 45
            r5 = 1
            if (r3 != r4) goto L1c
            r3 = -9223372036854775808
            int r0 = r0 + 1
            r1 = 1
            goto L21
        L1c:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L21:
            r6 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            if (r0 >= r2) goto L34
            int r8 = r0 + 1
            char r0 = r15.charAt(r0)
            int r0 = r0 + (-48)
            int r0 = -r0
            long r9 = (long) r0
        L32:
            r0 = r8
            goto L36
        L34:
            r9 = 0
        L36:
            if (r0 >= r2) goto L73
            int r8 = r0 + 1
            char r0 = r15.charAt(r0)
            r11 = 76
            if (r0 == r11) goto L72
            r11 = 83
            if (r0 == r11) goto L72
            r11 = 66
            if (r0 != r11) goto L4b
            goto L72
        L4b:
            int r0 = r0 + (-48)
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 < 0) goto L68
            r11 = 10
            long r9 = r9 * r11
            long r11 = (long) r0
            long r13 = r3 + r11
            int r0 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r0 < 0) goto L5e
            long r9 = r9 - r11
            goto L32
        L5e:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r15.numberString()
            r0.<init>(r1)
            throw r0
        L68:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r15.numberString()
            r0.<init>(r1)
            throw r0
        L72:
            r0 = r8
        L73:
            if (r1 == 0) goto L85
            int r1 = r15.np
            int r1 = r1 + r5
            if (r0 <= r1) goto L7b
            return r9
        L7b:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r15.numberString()
            r0.<init>(r1)
            throw r0
        L85:
            long r0 = -r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.longValue():long");
    }

    public final boolean matchField(char[] cArr) {
        while (!charArrayCompare(cArr)) {
            if (!isWhitespace(this.ch)) {
                return false;
            }
            next();
        }
        int length = this.bp + cArr.length;
        this.bp = length;
        char charAt = charAt(length);
        this.ch = charAt;
        if (charAt == '{') {
            next();
            this.token = 12;
        } else if (charAt == '[') {
            next();
            this.token = 14;
        } else if (charAt == 'S' && charAt(this.bp + 1) == 'e' && charAt(this.bp + 2) == 't' && charAt(this.bp + 3) == '[') {
            int i = this.bp + 3;
            this.bp = i;
            this.ch = charAt(i);
            this.token = 21;
        } else {
            nextToken();
        }
        return true;
    }

    public boolean matchField2(char[] cArr) {
        throw new UnsupportedOperationException();
    }

    public final int matchStat() {
        return this.matchStat;
    }

    public Collection<String> newCollectionByType(Class<?> cls) {
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (cls.isAssignableFrom(LinkedList.class)) {
            return new LinkedList();
        }
        try {
            return (Collection) cls.newInstance();
        } catch (Exception e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract char next();

    public final void nextIdent() {
        while (isWhitespace(this.ch)) {
            next();
        }
        char c = this.ch;
        if (c != '_' && c != '$' && !Character.isLetter(c)) {
            nextToken();
        } else {
            scanIdent();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken() {
        this.sp = 0;
        while (true) {
            this.pos = this.bp;
            char c = this.ch;
            if (c == '/') {
                skipComment();
            } else if (c == '\"') {
                scanString();
                return;
            } else if (c == ',') {
                next();
                this.token = 16;
                return;
            } else if (c >= '0' && c <= '9') {
                scanNumber();
                return;
            } else if (c == '-') {
                scanNumber();
                return;
            } else {
                switch (c) {
                    case '\b':
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        next();
                        continue;
                    case '\'':
                        if (isEnabled(Feature.AllowSingleQuotes)) {
                            scanStringSingleQuote();
                            return;
                        }
                        throw new JSONException("Feature.AllowSingleQuotes is false");
                    case '(':
                        next();
                        this.token = 10;
                        return;
                    case ')':
                        next();
                        this.token = 11;
                        return;
                    case '+':
                        next();
                        scanNumber();
                        return;
                    case '.':
                        next();
                        this.token = 25;
                        return;
                    case ':':
                        next();
                        this.token = 17;
                        return;
                    case ';':
                        next();
                        this.token = 24;
                        return;
                    case 'N':
                    case 'S':
                    case 'T':
                    case 'u':
                        scanIdent();
                        return;
                    case '[':
                        next();
                        this.token = 14;
                        return;
                    case ']':
                        next();
                        this.token = 15;
                        return;
                    case 'f':
                        scanFalse();
                        return;
                    case 'n':
                        scanNullOrNew();
                        return;
                    case 't':
                        scanTrue();
                        return;
                    case 'x':
                        scanHex();
                        return;
                    case '{':
                        next();
                        this.token = 12;
                        return;
                    case '}':
                        next();
                        this.token = 13;
                        return;
                    default:
                        if (isEOF()) {
                            if (this.token != 20) {
                                this.token = 20;
                                int i = this.bp;
                                this.pos = i;
                                this.eofPos = i;
                                return;
                            }
                            throw new JSONException("EOF error");
                        }
                        char c2 = this.ch;
                        if (c2 > 31 && c2 != 127) {
                            lexError("illegal.char", String.valueOf((int) c2));
                            next();
                            return;
                        }
                        next();
                        continue;
                }
            }
        }
    }

    public final void nextTokenWithChar(char c) {
        this.sp = 0;
        while (true) {
            char c2 = this.ch;
            if (c2 == c) {
                next();
                nextToken();
                return;
            } else if (c2 != ' ' && c2 != '\n' && c2 != '\r' && c2 != '\t' && c2 != '\f' && c2 != '\b') {
                throw new JSONException("not match " + c + " - " + this.ch + ", info : " + info());
            } else {
                next();
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon() {
        nextTokenWithChar(':');
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String numberString();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int pos() {
        return this.pos;
    }

    public final void putChar(char c) {
        int i = this.sp;
        char[] cArr = this.sbuf;
        if (i == cArr.length) {
            char[] cArr2 = new char[cArr.length * 2];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.sbuf = cArr2;
        }
        char[] cArr3 = this.sbuf;
        int i2 = this.sp;
        this.sp = i2 + 1;
        cArr3[i2] = c;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void resetStringPosition() {
        this.sp = 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean scanBoolean(char c) {
        boolean z = false;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        int i = 5;
        if (charAt == 't') {
            if (charAt(this.bp + 1) == 'r' && charAt(this.bp + 1 + 1) == 'u' && charAt(this.bp + 1 + 2) == 'e') {
                charAt = charAt(this.bp + 4);
                z = true;
            } else {
                this.matchStat = -1;
                return false;
            }
        } else if (charAt != 'f') {
            if (charAt == '1') {
                charAt = charAt(this.bp + 1);
                z = true;
            } else if (charAt == '0') {
                charAt = charAt(this.bp + 1);
            } else {
                i = 1;
            }
            i = 2;
        } else if (charAt(this.bp + 1) == 'a' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 's' && charAt(this.bp + 1 + 3) == 'e') {
            charAt = charAt(this.bp + 5);
            i = 6;
        } else {
            this.matchStat = -1;
            return false;
        }
        while (charAt != c) {
            if (isWhitespace(charAt)) {
                charAt = charAt(this.bp + i);
                i++;
            } else {
                this.matchStat = -1;
                return z;
            }
        }
        int i2 = this.bp + i;
        this.bp = i2;
        this.ch = charAt(i2);
        this.matchStat = 3;
        return z;
    }

    public Date scanDate(char c) {
        long j;
        int i;
        Date date;
        boolean z = false;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        int i2 = 5;
        if (charAt == '\"') {
            int indexOf = indexOf('\"', this.bp + 1);
            if (indexOf != -1) {
                int i3 = this.bp + 1;
                String subString = subString(i3, indexOf - i3);
                if (subString.indexOf(92) != -1) {
                    while (true) {
                        int i4 = 0;
                        for (int i5 = indexOf - 1; i5 >= 0 && charAt(i5) == '\\'; i5--) {
                            i4++;
                        }
                        if (i4 % 2 == 0) {
                            break;
                        }
                        indexOf = indexOf('\"', indexOf + 1);
                    }
                    int i6 = this.bp;
                    int i7 = indexOf - (i6 + 1);
                    subString = readString(sub_chars(i6 + 1, i7), i7);
                }
                int i8 = this.bp;
                int i9 = (indexOf - (i8 + 1)) + 1 + 1;
                int i10 = i9 + 1;
                charAt = charAt(i8 + i9);
                JSONScanner jSONScanner = new JSONScanner(subString);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch(false)) {
                        date = jSONScanner.getCalendar().getTime();
                        jSONScanner.close();
                        i2 = i10;
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                } finally {
                    jSONScanner.close();
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            char c2 = '9';
            int i11 = 2;
            if (charAt != '-' && (charAt < '0' || charAt > '9')) {
                if (charAt == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
                    this.matchStat = 5;
                    charAt = charAt(this.bp + 4);
                    date = null;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            } else {
                if (charAt == '-') {
                    charAt = charAt(this.bp + 1);
                    z = true;
                } else {
                    i11 = 1;
                }
                if (charAt >= '0' && charAt <= '9') {
                    j = charAt - '0';
                    while (true) {
                        i = i11 + 1;
                        charAt = charAt(this.bp + i11);
                        if (charAt < '0' || charAt > c2) {
                            break;
                        }
                        j = (j * 10) + (charAt - '0');
                        i11 = i;
                        c2 = '9';
                    }
                } else {
                    j = 0;
                    i = i11;
                }
                if (j < 0) {
                    this.matchStat = -1;
                    return null;
                }
                if (z) {
                    j = -j;
                }
                date = new Date(j);
                i2 = i;
            }
        }
        if (charAt == ',') {
            int i12 = this.bp + i2;
            this.bp = i12;
            this.ch = charAt(i12);
            this.matchStat = 3;
            this.token = 16;
            return date;
        } else if (charAt == ']') {
            int i13 = i2 + 1;
            char charAt2 = charAt(this.bp + i2);
            if (charAt2 == ',') {
                this.token = 16;
                int i14 = this.bp + i13;
                this.bp = i14;
                this.ch = charAt(i14);
            } else if (charAt2 == ']') {
                this.token = 15;
                int i15 = this.bp + i13;
                this.bp = i15;
                this.ch = charAt(i15);
            } else if (charAt2 == '}') {
                this.token = 13;
                int i16 = this.bp + i13;
                this.bp = i16;
                this.ch = charAt(i16);
            } else if (charAt2 == 26) {
                this.token = 20;
                this.bp += i13 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return date;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x00af A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:170:0x00b1 -> B:166:0x009f). Please submit an issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.math.BigDecimal scanDecimal(char r19) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanDecimal(char):java.math.BigDecimal");
    }

    /* JADX WARN: Removed duplicated region for block: B:170:0x00c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:171:0x00c9 -> B:167:0x00b7). Please submit an issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double scanDouble(char r21) {
        /*
            Method dump skipped, instructions count: 443
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanDouble(char):double");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Enum<?> scanEnum(Class<?> cls, SymbolTable symbolTable, char c) {
        String scanSymbolWithSeperator = scanSymbolWithSeperator(symbolTable, c);
        if (scanSymbolWithSeperator == null) {
            return null;
        }
        return Enum.valueOf(cls, scanSymbolWithSeperator);
    }

    public long scanEnumSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j = -3750763034362895579L;
        while (true) {
            int i2 = i + 1;
            char charAt = charAt(this.bp + i);
            if (charAt == '\"') {
                int i3 = i2 + 1;
                char charAt2 = charAt(this.bp + i2);
                if (charAt2 == ',') {
                    int i4 = this.bp + i3;
                    this.bp = i4;
                    this.ch = charAt(i4);
                    this.matchStat = 3;
                    return j;
                } else if (charAt2 == '}') {
                    int i5 = i3 + 1;
                    char charAt3 = charAt(this.bp + i3);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i6 = this.bp + i5;
                        this.bp = i6;
                        this.ch = charAt(i6);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i7 = this.bp + i5;
                        this.bp = i7;
                        this.ch = charAt(i7);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i8 = this.bp + i5;
                        this.bp = i8;
                        this.ch = charAt(i8);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i5 - 1;
                        this.ch = JSONLexer.EOI;
                    } else {
                        this.matchStat = -1;
                        return 0L;
                    }
                    this.matchStat = 4;
                    return j;
                } else {
                    this.matchStat = -1;
                    return 0L;
                }
            }
            j = (j ^ ((charAt < 'A' || charAt > 'Z') ? charAt : charAt + ' ')) * 1099511628211L;
            if (charAt == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i = i2;
        }
    }

    public final void scanFalse() {
        if (this.ch == 'f') {
            next();
            if (this.ch == 'a') {
                next();
                if (this.ch == 'l') {
                    next();
                    if (this.ch == 's') {
                        next();
                        if (this.ch == 'e') {
                            next();
                            char c = this.ch;
                            if (c != ' ' && c != ',' && c != '}' && c != ']' && c != '\n' && c != '\r' && c != '\t' && c != 26 && c != '\f' && c != '\b' && c != ':' && c != '/') {
                                throw new JSONException("scan false error");
                            }
                            this.token = 7;
                            return;
                        }
                        throw new JSONException("error parse false");
                    }
                    throw new JSONException("error parse false");
                }
                throw new JSONException("error parse false");
            }
            throw new JSONException("error parse false");
        }
        throw new JSONException("error parse false");
    }

    public BigInteger scanFieldBigInteger(char[] cArr) {
        int i;
        char charAt;
        boolean z;
        int length;
        int i2;
        BigInteger bigInteger;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length2 = cArr.length;
        int i3 = length2 + 1;
        char charAt2 = charAt(this.bp + length2);
        boolean z2 = charAt2 == '\"';
        if (z2) {
            charAt2 = charAt(this.bp + i3);
            i3++;
        }
        boolean z3 = charAt2 == '-';
        if (z3) {
            charAt2 = charAt(this.bp + i3);
            i3++;
        }
        if (charAt2 >= '0') {
            char c = '9';
            if (charAt2 <= '9') {
                long j = charAt2 - '0';
                while (true) {
                    i = i3 + 1;
                    charAt = charAt(this.bp + i3);
                    if (charAt < '0' || charAt > c) {
                        break;
                    }
                    long j2 = (10 * j) + (charAt - '0');
                    if (j2 < j) {
                        z = true;
                        break;
                    }
                    j = j2;
                    i3 = i;
                    c = '9';
                }
                z = false;
                if (!z2) {
                    int i4 = this.bp;
                    length = cArr.length + i4;
                    i2 = ((i4 + i) - length) - 1;
                } else if (charAt != '\"') {
                    this.matchStat = -1;
                    return null;
                } else {
                    int i5 = i + 1;
                    charAt = charAt(this.bp + i);
                    int i6 = this.bp;
                    length = cArr.length + i6 + 1;
                    i2 = ((i6 + i5) - length) - 2;
                    i = i5;
                }
                if (!z && (i2 < 20 || (z3 && i2 < 21))) {
                    if (z3) {
                        j = -j;
                    }
                    bigInteger = BigInteger.valueOf(j);
                } else {
                    bigInteger = new BigInteger(subString(length, i2));
                }
                if (charAt == ',') {
                    int i7 = this.bp + i;
                    this.bp = i7;
                    this.ch = charAt(i7);
                    this.matchStat = 3;
                    this.token = 16;
                    return bigInteger;
                } else if (charAt == '}') {
                    int i8 = i + 1;
                    char charAt3 = charAt(this.bp + i);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i9 = this.bp + i8;
                        this.bp = i9;
                        this.ch = charAt(i9);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i10 = this.bp + i8;
                        this.bp = i10;
                        this.ch = charAt(i10);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i11 = this.bp + i8;
                        this.bp = i11;
                        this.ch = charAt(i11);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i8 - 1;
                        this.ch = JSONLexer.EOI;
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                    this.matchStat = 4;
                    return bigInteger;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
        }
        if (charAt2 == 'n' && charAt(this.bp + i3) == 'u' && charAt(this.bp + i3 + 1) == 'l' && charAt(this.bp + i3 + 2) == 'l') {
            this.matchStat = 5;
            int i12 = i3 + 3;
            int i13 = i12 + 1;
            char charAt4 = charAt(this.bp + i12);
            if (z2 && charAt4 == '\"') {
                charAt4 = charAt(this.bp + i13);
                i13++;
            }
            while (charAt4 != ',') {
                if (charAt4 == '}') {
                    int i14 = this.bp + i13;
                    this.bp = i14;
                    this.ch = charAt(i14);
                    this.matchStat = 5;
                    this.token = 13;
                    return null;
                } else if (isWhitespace(charAt4)) {
                    charAt4 = charAt(this.bp + i13);
                    i13++;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            int i15 = this.bp + i13;
            this.bp = i15;
            this.ch = charAt(i15);
            this.matchStat = 5;
            this.token = 16;
            return null;
        }
        this.matchStat = -1;
        return null;
    }

    public boolean scanFieldBoolean(char[] cArr) {
        int i;
        boolean z;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt = charAt(this.bp + length);
        if (charAt == 't') {
            int i3 = i2 + 1;
            if (charAt(this.bp + i2) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i4 = i3 + 1;
            if (charAt(this.bp + i3) != 'u') {
                this.matchStat = -1;
                return false;
            }
            i = i4 + 1;
            if (charAt(this.bp + i4) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z = true;
        } else if (charAt == 'f') {
            int i5 = i2 + 1;
            if (charAt(this.bp + i2) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int i6 = i5 + 1;
            if (charAt(this.bp + i5) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int i7 = i6 + 1;
            if (charAt(this.bp + i6) != 's') {
                this.matchStat = -1;
                return false;
            }
            int i8 = i7 + 1;
            if (charAt(this.bp + i7) != 'e') {
                this.matchStat = -1;
                return false;
            }
            i = i8;
            z = false;
        } else {
            this.matchStat = -1;
            return false;
        }
        int i9 = i + 1;
        char charAt2 = charAt(this.bp + i);
        if (charAt2 == ',') {
            int i10 = this.bp + i9;
            this.bp = i10;
            this.ch = charAt(i10);
            this.matchStat = 3;
            this.token = 16;
            return z;
        } else if (charAt2 == '}') {
            int i11 = i9 + 1;
            char charAt3 = charAt(this.bp + i9);
            if (charAt3 == ',') {
                this.token = 16;
                int i12 = this.bp + i11;
                this.bp = i12;
                this.ch = charAt(i12);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i13 = this.bp + i11;
                this.bp = i13;
                this.ch = charAt(i13);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i14 = this.bp + i11;
                this.bp = i14;
                this.ch = charAt(i14);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i11 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return false;
            }
            this.matchStat = 4;
            return z;
        } else {
            this.matchStat = -1;
            return false;
        }
    }

    public Date scanFieldDate(char[] cArr) {
        int i;
        long j;
        Date date;
        int i2;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i3 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 == '\"') {
            int indexOf = indexOf('\"', this.bp + cArr.length + 1);
            if (indexOf != -1) {
                int length2 = this.bp + cArr.length + 1;
                String subString = subString(length2, indexOf - length2);
                if (subString.indexOf(92) != -1) {
                    while (true) {
                        int i4 = 0;
                        for (int i5 = indexOf - 1; i5 >= 0 && charAt(i5) == '\\'; i5--) {
                            i4++;
                        }
                        if (i4 % 2 == 0) {
                            break;
                        }
                        indexOf = indexOf('\"', indexOf + 1);
                    }
                    int i6 = this.bp;
                    int length3 = indexOf - ((cArr.length + i6) + 1);
                    subString = readString(sub_chars(i6 + cArr.length + 1, length3), length3);
                }
                int i7 = this.bp;
                int length4 = i3 + (indexOf - ((cArr.length + i7) + 1)) + 1;
                i = length4 + 1;
                charAt2 = charAt(i7 + length4);
                JSONScanner jSONScanner = new JSONScanner(subString);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch(false)) {
                        date = jSONScanner.getCalendar().getTime();
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                } finally {
                    jSONScanner.close();
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else if (charAt2 != '-' && (charAt2 < '0' || charAt2 > '9')) {
            this.matchStat = -1;
            return null;
        } else {
            if (charAt2 == '-') {
                charAt2 = charAt(this.bp + i3);
                i3++;
                z = true;
            }
            if (charAt2 < '0' || charAt2 > '9') {
                i = i3;
                j = 0;
            } else {
                j = charAt2 - '0';
                while (true) {
                    i2 = i3 + 1;
                    charAt = charAt(this.bp + i3);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    j = (j * 10) + (charAt - '0');
                    i3 = i2;
                }
                charAt2 = charAt;
                i = i2;
            }
            if (j < 0) {
                this.matchStat = -1;
                return null;
            }
            if (z) {
                j = -j;
            }
            date = new Date(j);
        }
        if (charAt2 == ',') {
            int i8 = this.bp + i;
            this.bp = i8;
            this.ch = charAt(i8);
            this.matchStat = 3;
            return date;
        } else if (charAt2 == '}') {
            int i9 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                int i10 = this.bp + i9;
                this.bp = i10;
                this.ch = charAt(i10);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i11 = this.bp + i9;
                this.bp = i11;
                this.ch = charAt(i11);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i12 = this.bp + i9;
                this.bp = i12;
                this.ch = charAt(i12);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i9 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return date;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x00bc A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:177:0x00be -> B:173:0x00ac). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.math.BigDecimal scanFieldDecimal(char[] r19) {
        /*
            Method dump skipped, instructions count: 493
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldDecimal(char[]):java.math.BigDecimal");
    }

    /* JADX WARN: Removed duplicated region for block: B:191:0x00dc A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:192:0x00de -> B:188:0x00ca). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final double scanFieldDouble(char[] r24) {
        /*
            Method dump skipped, instructions count: 570
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldDouble(char[]):double");
    }

    /* JADX WARN: Removed duplicated region for block: B:194:0x00d9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:192:0x00d5 -> B:193:0x00d7). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float scanFieldFloat(char[] r22) {
        /*
            Method dump skipped, instructions count: 569
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloat(char[]):float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:157:0x00a9, code lost:
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x00ab, code lost:
        return r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:176:0x00dd A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:174:0x00d9 -> B:175:0x00db). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float[] scanFieldFloatArray(char[] r20) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloatArray(char[]):float[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:177:0x00b1, code lost:
        r21.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x00b3, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0136, code lost:
        r4 = r18 + 1;
        r1 = charAt(r21.bp + r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0141, code lost:
        if (r2 == r3.length) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0143, code lost:
        r5 = new float[r2];
        r6 = 0;
        java.lang.System.arraycopy(r3, 0, r5, 0, r2);
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x014b, code lost:
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x014d, code lost:
        if (r8 < r7.length) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x014f, code lost:
        r5 = new float[(r7.length * 3) / 2];
        java.lang.System.arraycopy(r3, r6, r5, r6, r2);
        r7 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x015b, code lost:
        r5 = r8 + 1;
        r7[r8] = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0161, code lost:
        if (r1 != ',') goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0163, code lost:
        r3 = r4 + 1;
        r2 = charAt(r21.bp + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0171, code lost:
        if (r1 != ']') goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x0173, code lost:
        r3 = r4 + 1;
        r2 = charAt(r21.bp + r4);
        r8 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x017e, code lost:
        r2 = r1;
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0193, code lost:
        r21.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0196, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:196:0x00e6 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:194:0x00e2 -> B:195:0x00e4). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float[][] scanFieldFloatArray2(char[] r22) {
        /*
            Method dump skipped, instructions count: 531
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloatArray2(char[]):float[][]");
    }

    public int scanFieldInt(char[] cArr) {
        int i;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt2 = charAt(this.bp + length);
        boolean z = charAt2 == '-';
        if (z) {
            charAt2 = charAt(this.bp + i2);
            i2++;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i3 = charAt2 - '0';
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.bp + i2);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i3 = (i3 * 10) + (charAt - '0');
            i2 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if ((i3 < 0 || i > cArr.length + 14) && !(i3 == Integer.MIN_VALUE && i == 17 && z)) {
            this.matchStat = -1;
            return 0;
        } else if (charAt == ',') {
            int i4 = this.bp + i;
            this.bp = i4;
            this.ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            return z ? -i3 : i3;
        } else if (charAt == '}') {
            int i5 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                int i6 = this.bp + i5;
                this.bp = i6;
                this.ch = charAt(i6);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i7 = this.bp + i5;
                this.bp = i7;
                this.ch = charAt(i7);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i8 = this.bp + i5;
                this.bp = i8;
                this.ch = charAt(i8);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i5 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return 0;
            }
            this.matchStat = 4;
            return z ? -i3 : i3;
        } else {
            this.matchStat = -1;
            return 0;
        }
    }

    public final int[] scanFieldIntArray(char[] cArr) {
        boolean z;
        int i;
        char charAt;
        int i2;
        int i3;
        char charAt2;
        this.matchStat = 0;
        int[] iArr = null;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i4 = length + 1;
        if (charAt(this.bp + length) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i5 = i4 + 1;
        char charAt3 = charAt(this.bp + i4);
        int[] iArr2 = new int[16];
        if (charAt3 == ']') {
            i3 = i5 + 1;
            charAt2 = charAt(this.bp + i5);
            i2 = 0;
        } else {
            int i6 = 0;
            while (true) {
                if (charAt3 == '-') {
                    charAt3 = charAt(this.bp + i5);
                    i5++;
                    z = true;
                } else {
                    z = false;
                }
                if (charAt3 < '0' || charAt3 > '9') {
                    break;
                }
                int i7 = charAt3 - '0';
                while (true) {
                    i = i5 + 1;
                    charAt = charAt(this.bp + i5);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i7 = (i7 * 10) + (charAt - '0');
                    i5 = i;
                }
                if (i6 >= iArr2.length) {
                    int[] iArr3 = new int[(iArr2.length * 3) / 2];
                    System.arraycopy(iArr2, 0, iArr3, 0, i6);
                    iArr2 = iArr3;
                }
                i2 = i6 + 1;
                if (z) {
                    i7 = -i7;
                }
                iArr2[i6] = i7;
                if (charAt == ',') {
                    i++;
                    charAt = charAt(this.bp + i);
                } else if (charAt == ']') {
                    i3 = i + 1;
                    charAt2 = charAt(this.bp + i);
                    break;
                }
                i6 = i2;
                iArr = null;
                charAt3 = charAt;
                i5 = i;
            }
            int[] iArr4 = iArr;
            this.matchStat = -1;
            return iArr4;
        }
        if (i2 != iArr2.length) {
            int[] iArr5 = new int[i2];
            System.arraycopy(iArr2, 0, iArr5, 0, i2);
            iArr2 = iArr5;
        }
        if (charAt2 == ',') {
            this.bp += i3 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr2;
        } else if (charAt2 == '}') {
            int i8 = i3 + 1;
            char charAt4 = charAt(this.bp + i3);
            if (charAt4 == ',') {
                this.token = 16;
                this.bp += i8 - 1;
                next();
            } else if (charAt4 == ']') {
                this.token = 15;
                this.bp += i8 - 1;
                next();
            } else if (charAt4 == '}') {
                this.token = 13;
                this.bp += i8 - 1;
                next();
            } else if (charAt4 == 26) {
                this.bp += i8 - 1;
                this.token = 20;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return iArr2;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public long scanFieldLong(char[] cArr) {
        boolean z;
        int i;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 == '-') {
            charAt2 = charAt(this.bp + i2);
            i2++;
            z = true;
        } else {
            z = false;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j = charAt2 - '0';
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.bp + i2);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j = (j * 10) + (charAt - '0');
            i2 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (!(i - cArr.length < 21 && (j >= 0 || (j == Long.MIN_VALUE && z)))) {
            this.matchStat = -1;
            return 0L;
        } else if (charAt == ',') {
            int i3 = this.bp + i;
            this.bp = i3;
            this.ch = charAt(i3);
            this.matchStat = 3;
            this.token = 16;
            return z ? -j : j;
        } else if (charAt == '}') {
            int i4 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                int i5 = this.bp + i4;
                this.bp = i5;
                this.ch = charAt(i5);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i6 = this.bp + i4;
                this.bp = i6;
                this.ch = charAt(i6);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i7 = this.bp + i4;
                this.bp = i7;
                this.ch = charAt(i7);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i4 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return 0L;
            }
            this.matchStat = 4;
            return z ? -j : j;
        } else {
            this.matchStat = -1;
            return 0L;
        }
    }

    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int length = cArr.length;
        int i = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', this.bp + cArr.length + 1);
        if (indexOf != -1) {
            int length2 = this.bp + cArr.length + 1;
            String subString = subString(length2, indexOf - length2);
            if (subString.indexOf(92) != -1) {
                while (true) {
                    int i2 = 0;
                    for (int i3 = indexOf - 1; i3 >= 0 && charAt(i3) == '\\'; i3--) {
                        i2++;
                    }
                    if (i2 % 2 == 0) {
                        break;
                    }
                    indexOf = indexOf('\"', indexOf + 1);
                }
                int i4 = this.bp;
                int length3 = indexOf - ((cArr.length + i4) + 1);
                subString = readString(sub_chars(i4 + cArr.length + 1, length3), length3);
            }
            int i5 = this.bp;
            int length4 = i + (indexOf - ((cArr.length + i5) + 1)) + 1;
            int i6 = length4 + 1;
            char charAt = charAt(i5 + length4);
            if (charAt == ',') {
                int i7 = this.bp + i6;
                this.bp = i7;
                this.ch = charAt(i7);
                this.matchStat = 3;
                return subString;
            } else if (charAt == '}') {
                int i8 = i6 + 1;
                char charAt2 = charAt(this.bp + i6);
                if (charAt2 == ',') {
                    this.token = 16;
                    int i9 = this.bp + i8;
                    this.bp = i9;
                    this.ch = charAt(i9);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    int i10 = this.bp + i8;
                    this.bp = i10;
                    this.ch = charAt(i10);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    int i11 = this.bp + i8;
                    this.bp = i11;
                    this.ch = charAt(i11);
                } else if (charAt2 == 26) {
                    this.token = 20;
                    this.bp += i8 - 1;
                    this.ch = JSONLexer.EOI;
                } else {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
                this.matchStat = 4;
                return subString;
            } else {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        }
        throw new JSONException("unclosed str");
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x00ef, code lost:
        if (r13.size() != 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x00f1, code lost:
        r12 = charAt(r11.bp + r1);
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x00fb, code lost:
        if (r12 != ',') goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x00fd, code lost:
        r12 = r11.bp + r1;
        r11.bp = r12;
        r11.ch = charAt(r12);
        r11.matchStat = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x010b, code lost:
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x010e, code lost:
        if (r12 != '}') goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0110, code lost:
        r6 = r1 + 1;
        r12 = charAt(r11.bp + r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0119, code lost:
        if (r12 != ',') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x011b, code lost:
        r11.token = 16;
        r12 = r11.bp + r6;
        r11.bp = r12;
        r11.ch = charAt(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x012b, code lost:
        if (r12 != ']') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x012d, code lost:
        r11.token = 15;
        r12 = r11.bp + r6;
        r11.bp = r12;
        r11.ch = charAt(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x013d, code lost:
        if (r12 != '}') goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x013f, code lost:
        r11.token = 13;
        r12 = r11.bp + r6;
        r11.bp = r12;
        r11.ch = charAt(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0151, code lost:
        if (r12 != 26) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0153, code lost:
        r11.bp += r6 - 1;
        r11.token = 20;
        r11.ch = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0160, code lost:
        r11.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0163, code lost:
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0164, code lost:
        r11.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0166, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0167, code lost:
        r11.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0169, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0172, code lost:
        throw new com.alibaba.fastjson.JSONException("illega str");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r12, java.lang.Class<?> r13) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldStringArray(char[], java.lang.Class):java.util.Collection");
    }

    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j = -3750763034362895579L;
        while (true) {
            int i2 = i + 1;
            char charAt = charAt(this.bp + i);
            if (charAt == '\"') {
                int i3 = i2 + 1;
                char charAt2 = charAt(this.bp + i2);
                if (charAt2 == ',') {
                    int i4 = this.bp + i3;
                    this.bp = i4;
                    this.ch = charAt(i4);
                    this.matchStat = 3;
                    return j;
                } else if (charAt2 == '}') {
                    int i5 = i3 + 1;
                    char charAt3 = charAt(this.bp + i3);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i6 = this.bp + i5;
                        this.bp = i6;
                        this.ch = charAt(i6);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i7 = this.bp + i5;
                        this.bp = i7;
                        this.ch = charAt(i7);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i8 = this.bp + i5;
                        this.bp = i8;
                        this.ch = charAt(i8);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i5 - 1;
                        this.ch = JSONLexer.EOI;
                    } else {
                        this.matchStat = -1;
                        return 0L;
                    }
                    this.matchStat = 4;
                    return j;
                } else {
                    this.matchStat = -1;
                    return 0L;
                }
            }
            j = (j ^ charAt) * 1099511628211L;
            if (charAt == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i = i2;
        }
    }

    public UUID scanFieldUUID(char[] cArr) {
        char charAt;
        int i;
        UUID uuid;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i15 = length + 1;
        char charAt2 = charAt(this.bp + length);
        char c = 4;
        if (charAt2 == '\"') {
            int indexOf = indexOf('\"', this.bp + cArr.length + 1);
            if (indexOf != -1) {
                int length2 = this.bp + cArr.length + 1;
                int i16 = indexOf - length2;
                char c2 = 'F';
                char c3 = 'f';
                char c4 = 'A';
                char c5 = '0';
                if (i16 == 36) {
                    int i17 = 0;
                    long j = 0;
                    while (i17 < 8) {
                        char charAt3 = charAt(length2 + i17);
                        if (charAt3 < '0' || charAt3 > '9') {
                            if (charAt3 >= 'a' && charAt3 <= 'f') {
                                i13 = charAt3 - 'a';
                            } else if (charAt3 < 'A' || charAt3 > c2) {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i13 = charAt3 - 'A';
                            }
                            i14 = i13 + 10;
                        } else {
                            i14 = charAt3 - '0';
                        }
                        j = (j << 4) | i14;
                        i17++;
                        indexOf = indexOf;
                        c2 = 'F';
                    }
                    int i18 = indexOf;
                    int i19 = 9;
                    int i20 = 13;
                    while (i19 < i20) {
                        char charAt4 = charAt(length2 + i19);
                        if (charAt4 < '0' || charAt4 > '9') {
                            if (charAt4 >= 'a' && charAt4 <= 'f') {
                                i11 = charAt4 - 'a';
                            } else if (charAt4 < c4 || charAt4 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i11 = charAt4 - 'A';
                            }
                            i12 = i11 + 10;
                        } else {
                            i12 = charAt4 - '0';
                        }
                        j = (j << c) | i12;
                        i19++;
                        i20 = 13;
                        c4 = 'A';
                        c = 4;
                    }
                    long j2 = j;
                    for (int i21 = 14; i21 < 18; i21++) {
                        char charAt5 = charAt(length2 + i21);
                        if (charAt5 < '0' || charAt5 > '9') {
                            if (charAt5 >= 'a' && charAt5 <= 'f') {
                                i9 = charAt5 - 'a';
                            } else if (charAt5 < 'A' || charAt5 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i9 = charAt5 - 'A';
                            }
                            i10 = i9 + 10;
                        } else {
                            i10 = charAt5 - '0';
                        }
                        j2 = (j2 << 4) | i10;
                    }
                    int i22 = 19;
                    long j3 = 0;
                    while (i22 < 23) {
                        char charAt6 = charAt(length2 + i22);
                        if (charAt6 < '0' || charAt6 > '9') {
                            if (charAt6 >= 'a' && charAt6 <= 'f') {
                                i7 = charAt6 - 'a';
                            } else if (charAt6 < 'A' || charAt6 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i7 = charAt6 - 'A';
                            }
                            i8 = i7 + 10;
                        } else {
                            i8 = charAt6 - '0';
                        }
                        i22++;
                        j3 = (j3 << 4) | i8;
                    }
                    int i23 = 24;
                    long j4 = j3;
                    int i24 = 36;
                    while (i23 < i24) {
                        char charAt7 = charAt(length2 + i23);
                        if (charAt7 < c5 || charAt7 > '9') {
                            if (charAt7 >= 'a' && charAt7 <= c3) {
                                i5 = charAt7 - 'a';
                            } else if (charAt7 < 'A' || charAt7 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i5 = charAt7 - 'A';
                            }
                            i6 = i5 + 10;
                        } else {
                            i6 = charAt7 - '0';
                        }
                        j4 = (j4 << 4) | i6;
                        i23++;
                        i15 = i15;
                        i24 = 36;
                        c5 = '0';
                        c3 = 'f';
                    }
                    uuid = new UUID(j2, j4);
                    int i25 = this.bp;
                    int length3 = i15 + (i18 - ((cArr.length + i25) + 1)) + 1;
                    i = length3 + 1;
                    charAt = charAt(i25 + length3);
                } else {
                    if (i16 == 32) {
                        long j5 = 0;
                        for (int i26 = 0; i26 < 16; i26++) {
                            char charAt8 = charAt(length2 + i26);
                            if (charAt8 < '0' || charAt8 > '9') {
                                if (charAt8 >= 'a' && charAt8 <= 'f') {
                                    i3 = charAt8 - 'a';
                                } else if (charAt8 < 'A' || charAt8 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                } else {
                                    i3 = charAt8 - 'A';
                                }
                                i4 = i3 + 10;
                            } else {
                                i4 = charAt8 - '0';
                            }
                            j5 = (j5 << 4) | i4;
                        }
                        int i27 = 16;
                        long j6 = 0;
                        for (int i28 = 32; i27 < i28; i28 = 32) {
                            char charAt9 = charAt(length2 + i27);
                            if (charAt9 >= '0' && charAt9 <= '9') {
                                i2 = charAt9 - '0';
                            } else if (charAt9 >= 'a' && charAt9 <= 'f') {
                                i2 = (charAt9 - 'a') + 10;
                            } else if (charAt9 < 'A' || charAt9 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i2 = (charAt9 - 'A') + 10;
                                j6 = (j6 << 4) | i2;
                                i27++;
                            }
                            j6 = (j6 << 4) | i2;
                            i27++;
                        }
                        uuid = new UUID(j5, j6);
                        int i29 = this.bp;
                        int length4 = i15 + (indexOf - ((cArr.length + i29) + 1)) + 1;
                        i = length4 + 1;
                        charAt = charAt(i29 + length4);
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            if (charAt2 == 'n') {
                int i30 = i15 + 1;
                if (charAt(this.bp + i15) == 'u') {
                    int i31 = i30 + 1;
                    if (charAt(this.bp + i30) == 'l') {
                        int i32 = i31 + 1;
                        if (charAt(this.bp + i31) == 'l') {
                            charAt = charAt(this.bp + i32);
                            i = i32 + 1;
                            uuid = null;
                        }
                    }
                }
            }
            this.matchStat = -1;
            return null;
        }
        if (charAt == ',') {
            int i33 = this.bp + i;
            this.bp = i33;
            this.ch = charAt(i33);
            this.matchStat = 3;
            return uuid;
        } else if (charAt == '}') {
            int i34 = i + 1;
            char charAt10 = charAt(this.bp + i);
            if (charAt10 == ',') {
                this.token = 16;
                int i35 = this.bp + i34;
                this.bp = i35;
                this.ch = charAt(i35);
            } else if (charAt10 == ']') {
                this.token = 15;
                int i36 = this.bp + i34;
                this.bp = i36;
                this.ch = charAt(i36);
            } else if (charAt10 == '}') {
                this.token = 13;
                int i37 = this.bp + i34;
                this.bp = i37;
                this.ch = charAt(i37);
            } else if (charAt10 == 26) {
                this.token = 20;
                this.bp += i34 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return uuid;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:166:0x00c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:164:0x00c3 -> B:165:0x00c5). Please submit an issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float scanFloat(char r23) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFloat(char):float");
    }

    public final void scanHex() {
        char next;
        if (this.ch == 'x') {
            next();
            if (this.ch == '\'') {
                this.np = this.bp;
                next();
                if (this.ch == '\'') {
                    next();
                    this.token = 26;
                    return;
                }
                while (true) {
                    next = next();
                    if ((next < '0' || next > '9') && (next < 'A' || next > 'F')) {
                        break;
                    }
                    this.sp++;
                }
                if (next == '\'') {
                    this.sp++;
                    next();
                    this.token = 26;
                    return;
                }
                throw new JSONException("illegal state. " + next);
            }
            throw new JSONException("illegal state. " + this.ch);
        }
        throw new JSONException("illegal state. " + this.ch);
    }

    public final void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.ch));
        String stringVal = stringVal();
        if ("null".equalsIgnoreCase(stringVal)) {
            this.token = 8;
        } else if ("new".equals(stringVal)) {
            this.token = 9;
        } else if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(stringVal)) {
            this.token = 6;
        } else if ("false".equals(stringVal)) {
            this.token = 7;
        } else if ("undefined".equals(stringVal)) {
            this.token = 23;
        } else if ("Set".equals(stringVal)) {
            this.token = 21;
        } else if ("TreeSet".equals(stringVal)) {
            this.token = 22;
        } else {
            this.token = 18;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int scanInt(char c) {
        int i;
        int i2;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        boolean z = charAt2 == '\"';
        if (z) {
            charAt2 = charAt(this.bp + 1);
            i = 2;
        } else {
            i = 1;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            charAt2 = charAt(this.bp + i);
            i++;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            int i3 = charAt2 - '0';
            while (true) {
                i2 = i + 1;
                charAt = charAt(this.bp + i);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i3 = (i3 * 10) + (charAt - '0');
                i = i2;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0;
            } else if (i3 < 0) {
                this.matchStat = -1;
                return 0;
            } else {
                while (charAt != c) {
                    if (isWhitespace(charAt)) {
                        i2++;
                        charAt = charAt(this.bp + i2);
                    } else {
                        this.matchStat = -1;
                        return z2 ? -i3 : i3;
                    }
                }
                int i4 = this.bp + i2;
                this.bp = i4;
                this.ch = charAt(i4);
                this.matchStat = 3;
                this.token = 16;
                return z2 ? -i3 : i3;
            }
        } else if (charAt2 == 'n' && charAt(this.bp + i) == 'u' && charAt(this.bp + i + 1) == 'l' && charAt(this.bp + i + 2) == 'l') {
            this.matchStat = 5;
            int i5 = i + 3;
            int i6 = i5 + 1;
            char charAt3 = charAt(this.bp + i5);
            if (z && charAt3 == '\"') {
                int i7 = i6 + 1;
                charAt3 = charAt(this.bp + i6);
                i6 = i7;
            }
            while (charAt3 != ',') {
                if (charAt3 == ']') {
                    int i8 = this.bp + i6;
                    this.bp = i8;
                    this.ch = charAt(i8);
                    this.matchStat = 5;
                    this.token = 15;
                    return 0;
                } else if (isWhitespace(charAt3)) {
                    int i9 = i6 + 1;
                    charAt3 = charAt(this.bp + i6);
                    i6 = i9;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
            }
            int i10 = this.bp + i6;
            this.bp = i10;
            this.ch = charAt(i10);
            this.matchStat = 5;
            this.token = 16;
            return 0;
        } else {
            this.matchStat = -1;
            return 0;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c) {
        int i;
        int i2;
        char charAt;
        char c2;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        boolean z = charAt2 == '\"';
        if (z) {
            charAt2 = charAt(this.bp + 1);
            i = 2;
        } else {
            i = 1;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            charAt2 = charAt(this.bp + i);
            i++;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j = charAt2 - '0';
            while (true) {
                i2 = i + 1;
                charAt = charAt(this.bp + i);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j = (j * 10) + (charAt - '0');
                i = i2;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0L;
            }
            if (j >= 0 || (j == Long.MIN_VALUE && z2)) {
                if (!z) {
                    c2 = c;
                } else if (charAt != '\"') {
                    this.matchStat = -1;
                    return 0L;
                } else {
                    charAt = charAt(this.bp + i2);
                    c2 = c;
                    i2++;
                }
                while (charAt != c2) {
                    if (isWhitespace(charAt)) {
                        charAt = charAt(this.bp + i2);
                        i2++;
                    } else {
                        this.matchStat = -1;
                        return j;
                    }
                }
                int i3 = this.bp + i2;
                this.bp = i3;
                this.ch = charAt(i3);
                this.matchStat = 3;
                this.token = 16;
                return z2 ? -j : j;
            }
            throw new NumberFormatException(subString(this.bp, i2 - 1));
        } else if (charAt2 == 'n' && charAt(this.bp + i) == 'u' && charAt(this.bp + i + 1) == 'l' && charAt(this.bp + i + 2) == 'l') {
            this.matchStat = 5;
            int i4 = i + 3;
            int i5 = i4 + 1;
            char charAt3 = charAt(this.bp + i4);
            if (z && charAt3 == '\"') {
                int i6 = i5 + 1;
                charAt3 = charAt(this.bp + i5);
                i5 = i6;
            }
            while (charAt3 != ',') {
                if (charAt3 == ']') {
                    int i7 = this.bp + i5;
                    this.bp = i7;
                    this.ch = charAt(i7);
                    this.matchStat = 5;
                    this.token = 15;
                    return 0L;
                } else if (isWhitespace(charAt3)) {
                    int i8 = i5 + 1;
                    charAt3 = charAt(this.bp + i5);
                    i5 = i8;
                } else {
                    this.matchStat = -1;
                    return 0L;
                }
            }
            int i9 = this.bp + i5;
            this.bp = i9;
            this.ch = charAt(i9);
            this.matchStat = 5;
            this.token = 16;
            return 0L;
        } else {
            this.matchStat = -1;
            return 0L;
        }
    }

    public final void scanNullOrNew() {
        scanNullOrNew(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00ca  */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void scanNumber() {
        /*
            Method dump skipped, instructions count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanNumber():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:245:0x0171, code lost:
        throw new com.alibaba.fastjson.JSONException("invalid escape character \\x" + r1 + r2);
     */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void scanString() {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanString():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x012b, code lost:
        if (r1 != r18) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x012d, code lost:
        r1 = r16.bp + r3;
        r16.bp = r1;
        r16.ch = charAt(r1);
        r16.matchStat = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x013a, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x013b, code lost:
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x013d, code lost:
        return;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void scanStringArray(java.util.Collection<java.lang.String> r17, char r18) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanStringArray(java.util.Collection, char):void");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable) {
        skipWhitespace();
        char c = this.ch;
        if (c == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (c == '\'') {
            if (isEnabled(Feature.AllowSingleQuotes)) {
                return scanSymbol(symbolTable, '\'');
            }
            throw new JSONException("syntax error");
        } else if (c == '}') {
            next();
            this.token = 13;
            return null;
        } else if (c == ',') {
            next();
            this.token = 16;
            return null;
        } else if (c == 26) {
            this.token = 20;
            return null;
        } else if (isEnabled(Feature.AllowUnQuotedFieldNames)) {
            return scanSymbolUnQuoted(symbolTable);
        } else {
            throw new JSONException("syntax error");
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        boolean z = false;
        if (this.token == 1 && this.pos == 0 && this.bp == 1) {
            this.bp = 0;
        }
        boolean[] zArr = IOUtils.firstIdentifierFlags;
        int i = this.ch;
        if ((i >= zArr.length || zArr[i]) ? true : true) {
            boolean[] zArr2 = IOUtils.identifierFlags;
            this.np = this.bp;
            this.sp = 1;
            while (true) {
                char next = next();
                if (next < zArr2.length && !zArr2[next]) {
                    break;
                }
                i = (i * 31) + next;
                this.sp++;
            }
            this.ch = charAt(this.bp);
            this.token = 18;
            if (this.sp == 4 && i == 3392903 && charAt(this.np) == 'n' && charAt(this.np + 1) == 'u' && charAt(this.np + 2) == 'l' && charAt(this.np + 3) == 'l') {
                return null;
            }
            if (symbolTable == null) {
                return subString(this.np, this.sp);
            }
            return addSymbol(this.np, this.sp, i, symbolTable);
        }
        throw new JSONException("illegal identifier : " + this.ch + info());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanSymbolWithSeperator(SymbolTable symbolTable, char c) {
        int i = 0;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        if (charAt == 'n') {
            if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
                if (charAt(this.bp + 4) == c) {
                    int i2 = this.bp + 5;
                    this.bp = i2;
                    this.ch = charAt(i2);
                    this.matchStat = 3;
                    return null;
                }
                this.matchStat = -1;
                return null;
            }
            this.matchStat = -1;
            return null;
        } else if (charAt != '\"') {
            this.matchStat = -1;
            return null;
        } else {
            int i3 = 1;
            while (true) {
                int i4 = i3 + 1;
                char charAt2 = charAt(this.bp + i3);
                if (charAt2 == '\"') {
                    int i5 = this.bp;
                    int i6 = i5 + 0 + 1;
                    String addSymbol = addSymbol(i6, ((i5 + i4) - i6) - 1, i, symbolTable);
                    int i7 = i4 + 1;
                    char charAt3 = charAt(this.bp + i4);
                    while (charAt3 != c) {
                        if (isWhitespace(charAt3)) {
                            charAt3 = charAt(this.bp + i7);
                            i7++;
                        } else {
                            this.matchStat = -1;
                            return addSymbol;
                        }
                    }
                    int i8 = this.bp + i7;
                    this.bp = i8;
                    this.ch = charAt(i8);
                    this.matchStat = 3;
                    return addSymbol;
                }
                i = (i * 31) + charAt2;
                if (charAt2 == '\\') {
                    this.matchStat = -1;
                    return null;
                }
                i3 = i4;
            }
        }
    }

    public final void scanTrue() {
        if (this.ch == 't') {
            next();
            if (this.ch == 'r') {
                next();
                if (this.ch == 'u') {
                    next();
                    if (this.ch == 'e') {
                        next();
                        char c = this.ch;
                        if (c != ' ' && c != ',' && c != '}' && c != ']' && c != '\n' && c != '\r' && c != '\t' && c != 26 && c != '\f' && c != '\b' && c != ':' && c != '/') {
                            throw new JSONException("scan true error");
                        }
                        this.token = 6;
                        return;
                    }
                    throw new JSONException("error parse true");
                }
                throw new JSONException("error parse true");
            }
            throw new JSONException("error parse true");
        }
        throw new JSONException("error parse true");
    }

    public final int scanType(String str) {
        this.matchStat = 0;
        char[] cArr = typeFieldName;
        if (charArrayCompare(cArr)) {
            int length = this.bp + cArr.length;
            int length2 = str.length();
            for (int i = 0; i < length2; i++) {
                if (str.charAt(i) != charAt(length + i)) {
                    return -1;
                }
            }
            int i2 = length + length2;
            if (charAt(i2) != '\"') {
                return -1;
            }
            int i3 = i2 + 1;
            char charAt = charAt(i3);
            this.ch = charAt;
            if (charAt == ',') {
                int i4 = i3 + 1;
                this.ch = charAt(i4);
                this.bp = i4;
                this.token = 16;
                return 3;
            }
            if (charAt == '}') {
                i3++;
                char charAt2 = charAt(i3);
                this.ch = charAt2;
                if (charAt2 == ',') {
                    this.token = 16;
                    i3++;
                    this.ch = charAt(i3);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    i3++;
                    this.ch = charAt(i3);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    i3++;
                    this.ch = charAt(i3);
                } else if (charAt2 != 26) {
                    return -1;
                } else {
                    this.token = 20;
                }
                this.matchStat = 4;
            }
            this.bp = i3;
            return this.matchStat;
        }
        return -2;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanTypeName(SymbolTable symbolTable) {
        return null;
    }

    public UUID scanUUID(char c) {
        int i;
        char charAt;
        UUID uuid;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        int i15 = 13;
        char c2 = 4;
        if (charAt2 == '\"') {
            int indexOf = indexOf('\"', this.bp + 1);
            if (indexOf != -1) {
                int i16 = this.bp + 1;
                int i17 = indexOf - i16;
                char c3 = 'f';
                char c4 = 'A';
                char c5 = 'a';
                if (i17 == 36) {
                    int i18 = 0;
                    long j = 0;
                    while (i18 < 8) {
                        char charAt3 = charAt(i16 + i18);
                        if (charAt3 < '0' || charAt3 > '9') {
                            if (charAt3 >= 'a' && charAt3 <= c3) {
                                i13 = charAt3 - 'a';
                            } else if (charAt3 < 'A' || charAt3 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i13 = charAt3 - 'A';
                            }
                            i14 = i13 + 10;
                        } else {
                            i14 = charAt3 - '0';
                        }
                        j = (j << 4) | i14;
                        i18++;
                        c3 = 'f';
                    }
                    int i19 = 9;
                    while (i19 < i15) {
                        char charAt4 = charAt(i16 + i19);
                        if (charAt4 < '0' || charAt4 > '9') {
                            if (charAt4 >= 'a' && charAt4 <= 'f') {
                                i11 = charAt4 - 'a';
                            } else if (charAt4 < c4 || charAt4 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i11 = charAt4 - 'A';
                            }
                            i12 = i11 + 10;
                        } else {
                            i12 = charAt4 - '0';
                        }
                        j = (j << 4) | i12;
                        i19++;
                        i15 = 13;
                        c4 = 'A';
                    }
                    long j2 = j;
                    for (int i20 = 14; i20 < 18; i20++) {
                        char charAt5 = charAt(i16 + i20);
                        if (charAt5 < '0' || charAt5 > '9') {
                            if (charAt5 >= 'a' && charAt5 <= 'f') {
                                i9 = charAt5 - 'a';
                            } else if (charAt5 < 'A' || charAt5 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i9 = charAt5 - 'A';
                            }
                            i10 = i9 + 10;
                        } else {
                            i10 = charAt5 - '0';
                        }
                        j2 = (j2 << 4) | i10;
                    }
                    int i21 = 19;
                    long j3 = 0;
                    while (i21 < 23) {
                        char charAt6 = charAt(i16 + i21);
                        if (charAt6 < '0' || charAt6 > '9') {
                            if (charAt6 >= c5 && charAt6 <= 'f') {
                                i7 = charAt6 - 'a';
                            } else if (charAt6 < 'A' || charAt6 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i7 = charAt6 - 'A';
                            }
                            i8 = i7 + 10;
                        } else {
                            i8 = charAt6 - '0';
                        }
                        j3 = (j3 << c2) | i8;
                        i21++;
                        c5 = 'a';
                        c2 = 4;
                    }
                    long j4 = j3;
                    for (int i22 = 24; i22 < 36; i22++) {
                        char charAt7 = charAt(i16 + i22);
                        if (charAt7 < '0' || charAt7 > '9') {
                            if (charAt7 >= 'a' && charAt7 <= 'f') {
                                i5 = charAt7 - 'a';
                            } else if (charAt7 < 'A' || charAt7 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i5 = charAt7 - 'A';
                            }
                            i6 = i5 + 10;
                        } else {
                            i6 = charAt7 - '0';
                        }
                        j4 = (j4 << 4) | i6;
                    }
                    uuid = new UUID(j2, j4);
                    int i23 = this.bp;
                    int i24 = 1 + (indexOf - (i23 + 1)) + 1;
                    i = i24 + 1;
                    charAt = charAt(i23 + i24);
                } else {
                    if (i17 == 32) {
                        long j5 = 0;
                        for (int i25 = 0; i25 < 16; i25++) {
                            char charAt8 = charAt(i16 + i25);
                            if (charAt8 < '0' || charAt8 > '9') {
                                if (charAt8 >= 'a' && charAt8 <= 'f') {
                                    i3 = charAt8 - 'a';
                                } else if (charAt8 < 'A' || charAt8 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                } else {
                                    i3 = charAt8 - 'A';
                                }
                                i4 = i3 + 10;
                            } else {
                                i4 = charAt8 - '0';
                            }
                            j5 = (j5 << 4) | i4;
                        }
                        int i26 = 16;
                        long j6 = 0;
                        for (int i27 = 32; i26 < i27; i27 = 32) {
                            char charAt9 = charAt(i16 + i26);
                            if (charAt9 >= '0' && charAt9 <= '9') {
                                i2 = charAt9 - '0';
                            } else if (charAt9 >= 'a' && charAt9 <= 'f') {
                                i2 = (charAt9 - 'a') + 10;
                            } else if (charAt9 < 'A' || charAt9 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i2 = (charAt9 - 'A') + 10;
                            }
                            j6 = (j6 << 4) | i2;
                            i26++;
                        }
                        uuid = new UUID(j5, j6);
                        int i28 = this.bp;
                        int i29 = 1 + (indexOf - (i28 + 1)) + 1;
                        i = i29 + 1;
                        charAt = charAt(i28 + i29);
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else if (charAt2 == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 'l') {
            i = 5;
            charAt = charAt(this.bp + 4);
            uuid = null;
        } else {
            this.matchStat = -1;
            return null;
        }
        if (charAt == ',') {
            int i30 = this.bp + i;
            this.bp = i30;
            this.ch = charAt(i30);
            this.matchStat = 3;
            return uuid;
        } else if (charAt == ']') {
            int i31 = i + 1;
            char charAt10 = charAt(this.bp + i);
            if (charAt10 == ',') {
                this.token = 16;
                int i32 = this.bp + i31;
                this.bp = i32;
                this.ch = charAt(i32);
            } else if (charAt10 == ']') {
                this.token = 15;
                int i33 = this.bp + i31;
                this.bp = i33;
                this.ch = charAt(i33);
            } else if (charAt10 == '}') {
                this.token = 13;
                int i34 = this.bp + i31;
                this.bp = i34;
                this.ch = charAt(i34);
            } else if (charAt10 == 26) {
                this.token = 20;
                this.bp += i31 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return uuid;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public boolean seekArrayToItem(int i) {
        throw new UnsupportedOperationException();
    }

    public int seekObjectToField(long j, boolean z) {
        throw new UnsupportedOperationException();
    }

    public int seekObjectToFieldDeepScan(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public void setToken(int i) {
        this.token = i;
    }

    public void skipArray() {
        throw new UnsupportedOperationException();
    }

    public void skipComment() {
        char c;
        next();
        char c2 = this.ch;
        if (c2 == '/') {
            do {
                next();
                c = this.ch;
                if (c == '\n') {
                    next();
                    return;
                }
            } while (c != 26);
        } else if (c2 == '*') {
            next();
            while (true) {
                char c3 = this.ch;
                if (c3 == 26) {
                    return;
                }
                if (c3 == '*') {
                    next();
                    if (this.ch == '/') {
                        next();
                        return;
                    }
                } else {
                    next();
                }
            }
        } else {
            throw new JSONException("invalid comment");
        }
    }

    public void skipObject() {
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void skipWhitespace() {
        while (true) {
            char c = this.ch;
            if (c > '/') {
                return;
            }
            if (c == ' ' || c == '\r' || c == '\n' || c == '\t' || c == '\f' || c == '\b') {
                next();
            } else if (c != '/') {
                return;
            } else {
                skipComment();
            }
        }
    }

    public final String stringDefaultValue() {
        return this.stringDefaultValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String stringVal();

    public abstract String subString(int i, int i2);

    public abstract char[] sub_chars(int i, int i2);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int token() {
        return this.token;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String tokenName() {
        return JSONToken.name(this.token);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(int i) {
        return (i & this.features) != 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon(int i) {
        nextTokenWithChar(':');
    }

    public final void scanNullOrNew(boolean z) {
        if (this.ch == 'n') {
            next();
            char c = this.ch;
            if (c != 'u') {
                if (c == 'e') {
                    next();
                    if (this.ch == 'w') {
                        next();
                        char c2 = this.ch;
                        if (c2 != ' ' && c2 != ',' && c2 != '}' && c2 != ']' && c2 != '\n' && c2 != '\r' && c2 != '\t' && c2 != 26 && c2 != '\f' && c2 != '\b') {
                            throw new JSONException("scan new error");
                        }
                        this.token = 9;
                        return;
                    }
                    throw new JSONException("error parse new");
                }
                throw new JSONException("error parse new");
            }
            next();
            if (this.ch == 'l') {
                next();
                if (this.ch == 'l') {
                    next();
                    char c3 = this.ch;
                    if (c3 != ' ' && c3 != ',' && c3 != '}' && c3 != ']' && c3 != '\n' && c3 != '\r' && c3 != '\t' && c3 != 26 && ((c3 != ':' || !z) && c3 != '\f' && c3 != '\b')) {
                        throw new JSONException("scan null error");
                    }
                    this.token = 8;
                    return;
                }
                throw new JSONException("error parse null");
            }
            throw new JSONException("error parse null");
        }
        throw new JSONException("error parse null or new");
    }

    public int seekObjectToField(long[] jArr) {
        throw new UnsupportedOperationException();
    }

    public void skipObject(boolean z) {
        throw new UnsupportedOperationException();
    }

    public final boolean isEnabled(int i, int i2) {
        return ((this.features & i2) == 0 && (i & i2) == 0) ? false : true;
    }

    public int matchField(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable, char c) {
        String addSymbol;
        this.np = this.bp;
        this.sp = 0;
        boolean z = false;
        int i = 0;
        while (true) {
            char next = next();
            if (next == c) {
                this.token = 4;
                if (!z) {
                    int i2 = this.np;
                    addSymbol = addSymbol(i2 == -1 ? 0 : i2 + 1, this.sp, i, symbolTable);
                } else {
                    addSymbol = symbolTable.addSymbol(this.sbuf, 0, this.sp, i);
                }
                this.sp = 0;
                next();
                return addSymbol;
            } else if (next == 26) {
                throw new JSONException("unclosed.str");
            } else {
                if (next == '\\') {
                    if (!z) {
                        int i3 = this.sp;
                        char[] cArr = this.sbuf;
                        if (i3 >= cArr.length) {
                            int length = cArr.length * 2;
                            if (i3 <= length) {
                                i3 = length;
                            }
                            char[] cArr2 = new char[i3];
                            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                            this.sbuf = cArr2;
                        }
                        arrayCopy(this.np + 1, this.sbuf, 0, this.sp);
                        z = true;
                    }
                    char next2 = next();
                    if (next2 == '\"') {
                        i = (i * 31) + 34;
                        putChar('\"');
                    } else if (next2 != '\'') {
                        if (next2 != 'F') {
                            if (next2 == '\\') {
                                i = (i * 31) + 92;
                                putChar('\\');
                            } else if (next2 == 'b') {
                                i = (i * 31) + 8;
                                putChar('\b');
                            } else if (next2 != 'f') {
                                if (next2 == 'n') {
                                    i = (i * 31) + 10;
                                    putChar('\n');
                                } else if (next2 == 'r') {
                                    i = (i * 31) + 13;
                                    putChar('\r');
                                } else if (next2 != 'x') {
                                    switch (next2) {
                                        case '/':
                                            i = (i * 31) + 47;
                                            putChar('/');
                                            continue;
                                        case '0':
                                            i = (i * 31) + next2;
                                            putChar((char) 0);
                                            continue;
                                        case '1':
                                            i = (i * 31) + next2;
                                            putChar((char) 1);
                                            continue;
                                        case '2':
                                            i = (i * 31) + next2;
                                            putChar((char) 2);
                                            continue;
                                        case '3':
                                            i = (i * 31) + next2;
                                            putChar((char) 3);
                                            continue;
                                        case '4':
                                            i = (i * 31) + next2;
                                            putChar((char) 4);
                                            continue;
                                        case '5':
                                            i = (i * 31) + next2;
                                            putChar((char) 5);
                                            continue;
                                        case '6':
                                            i = (i * 31) + next2;
                                            putChar((char) 6);
                                            continue;
                                        case '7':
                                            i = (i * 31) + next2;
                                            putChar((char) 7);
                                            continue;
                                        default:
                                            switch (next2) {
                                                case 't':
                                                    i = (i * 31) + 9;
                                                    putChar('\t');
                                                    continue;
                                                case 'u':
                                                    int parseInt = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                    i = (i * 31) + parseInt;
                                                    putChar((char) parseInt);
                                                    continue;
                                                    continue;
                                                case 'v':
                                                    i = (i * 31) + 11;
                                                    putChar((char) 11);
                                                    continue;
                                                default:
                                                    this.ch = next2;
                                                    throw new JSONException("unclosed.str.lit");
                                            }
                                    }
                                } else {
                                    char next3 = next();
                                    this.ch = next3;
                                    char next4 = next();
                                    this.ch = next4;
                                    int[] iArr = digits;
                                    char c2 = (char) ((iArr[next3] * 16) + iArr[next4]);
                                    i = (i * 31) + c2;
                                    putChar(c2);
                                }
                            }
                        }
                        i = (i * 31) + 12;
                        putChar('\f');
                    } else {
                        i = (i * 31) + 39;
                        putChar('\'');
                    }
                } else {
                    i = (i * 31) + next;
                    if (!z) {
                        this.sp++;
                    } else {
                        int i4 = this.sp;
                        char[] cArr3 = this.sbuf;
                        if (i4 == cArr3.length) {
                            putChar(next);
                        } else {
                            this.sp = i4 + 1;
                            cArr3[i4] = next;
                        }
                    }
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken(int i) {
        this.sp = 0;
        while (true) {
            if (i == 2) {
                char c = this.ch;
                if (c >= '0' && c <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else if (c == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i == 4) {
                char c2 = this.ch;
                if (c2 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c2 >= '0' && c2 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else if (c2 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c2 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i == 12) {
                char c3 = this.ch;
                if (c3 == '{') {
                    this.token = 12;
                    next();
                    return;
                } else if (c3 == '[') {
                    this.token = 14;
                    next();
                    return;
                }
            } else if (i != 18) {
                if (i != 20) {
                    switch (i) {
                        case 14:
                            char c4 = this.ch;
                            if (c4 == '[') {
                                this.token = 14;
                                next();
                                return;
                            } else if (c4 == '{') {
                                this.token = 12;
                                next();
                                return;
                            }
                            break;
                        case 15:
                            if (this.ch == ']') {
                                this.token = 15;
                                next();
                                return;
                            }
                            break;
                        case 16:
                            char c5 = this.ch;
                            if (c5 == ',') {
                                this.token = 16;
                                next();
                                return;
                            } else if (c5 == '}') {
                                this.token = 13;
                                next();
                                return;
                            } else if (c5 == ']') {
                                this.token = 15;
                                next();
                                return;
                            } else if (c5 == 26) {
                                this.token = 20;
                                return;
                            } else if (c5 == 'n') {
                                scanNullOrNew(false);
                                return;
                            }
                            break;
                    }
                }
                if (this.ch == 26) {
                    this.token = 20;
                    return;
                }
            } else {
                nextIdent();
                return;
            }
            char c6 = this.ch;
            if (c6 != ' ' && c6 != '\n' && c6 != '\r' && c6 != '\t' && c6 != '\f' && c6 != '\b') {
                nextToken();
                return;
            }
            next();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanString(char c) {
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        if (charAt == 'n') {
            if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
                if (charAt(this.bp + 4) == c) {
                    int i = this.bp + 5;
                    this.bp = i;
                    this.ch = charAt(i);
                    this.matchStat = 3;
                    return null;
                }
                this.matchStat = -1;
                return null;
            }
            this.matchStat = -1;
            return null;
        }
        int i2 = 1;
        while (charAt != '\"') {
            if (isWhitespace(charAt)) {
                charAt = charAt(this.bp + i2);
                i2++;
            } else {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        }
        int i3 = this.bp + i2;
        int indexOf = indexOf('\"', i3);
        if (indexOf != -1) {
            String subString = subString(this.bp + i2, indexOf - i3);
            if (subString.indexOf(92) != -1) {
                while (true) {
                    int i4 = 0;
                    for (int i5 = indexOf - 1; i5 >= 0 && charAt(i5) == '\\'; i5--) {
                        i4++;
                    }
                    if (i4 % 2 == 0) {
                        break;
                    }
                    indexOf = indexOf('\"', indexOf + 1);
                }
                int i6 = indexOf - i3;
                subString = readString(sub_chars(this.bp + 1, i6), i6);
            }
            int i7 = i2 + (indexOf - i3) + 1;
            int i8 = i7 + 1;
            char charAt2 = charAt(this.bp + i7);
            while (charAt2 != c) {
                if (!isWhitespace(charAt2)) {
                    if (charAt2 == ']') {
                        int i9 = this.bp + i8;
                        this.bp = i9;
                        this.ch = charAt(i9);
                        this.matchStat = -1;
                    }
                    return subString;
                }
                charAt2 = charAt(this.bp + i8);
                i8++;
            }
            int i10 = this.bp + i8;
            this.bp = i10;
            this.ch = charAt(i10);
            this.matchStat = 3;
            this.token = 16;
            return subString;
        }
        throw new JSONException("unclosed str");
    }

    public String[] scanFieldStringArray(char[] cArr, int i, SymbolTable symbolTable) {
        throw new UnsupportedOperationException();
    }
}