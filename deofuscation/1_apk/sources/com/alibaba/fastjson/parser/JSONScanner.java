package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import com.facebook.soloader.MinElf;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class JSONScanner extends JSONLexerBase {
    private final int len;
    private final String text;

    public JSONScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public static boolean charArrayCompare(String str, int i, char[] cArr) {
        int length = cArr.length;
        if (length + i > str.length()) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (cArr[i2] != str.charAt(i + i2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDate(char c, char c2, char c3, char c4, char c5, char c6, int i, int i2) {
        if (c >= '0' && c <= '9' && c2 >= '0' && c2 <= '9' && c3 >= '0' && c3 <= '9' && c4 >= '0' && c4 <= '9') {
            if (c5 == '0') {
                if (c6 < '1' || c6 > '9') {
                    return false;
                }
            } else if (c5 != '1' || (c6 != '0' && c6 != '1' && c6 != '2')) {
                return false;
            }
            if (i == 48) {
                return i2 >= 49 && i2 <= 57;
            } else if (i != 49 && i != 50) {
                return i == 51 && (i2 == 48 || i2 == 49);
            } else if (i2 >= 48 && i2 <= 57) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x001d, code lost:
        if (r6 <= '4') goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean checkTime(char r5, char r6, char r7, char r8, char r9, char r10) {
        /*
            r4 = this;
            r0 = 57
            r1 = 0
            r2 = 48
            if (r5 != r2) goto Lc
            if (r6 < r2) goto Lb
            if (r6 <= r0) goto L20
        Lb:
            return r1
        Lc:
            r3 = 49
            if (r5 != r3) goto L15
            if (r6 < r2) goto L14
            if (r6 <= r0) goto L20
        L14:
            return r1
        L15:
            r3 = 50
            if (r5 != r3) goto L42
            if (r6 < r2) goto L42
            r5 = 52
            if (r6 <= r5) goto L20
            goto L42
        L20:
            r5 = 53
            r6 = 54
            if (r7 < r2) goto L2d
            if (r7 > r5) goto L2d
            if (r8 < r2) goto L2c
            if (r8 <= r0) goto L32
        L2c:
            return r1
        L2d:
            if (r7 != r6) goto L42
            if (r8 == r2) goto L32
            return r1
        L32:
            if (r9 < r2) goto L3b
            if (r9 > r5) goto L3b
            if (r10 < r2) goto L3a
            if (r10 <= r0) goto L40
        L3a:
            return r1
        L3b:
            if (r9 != r6) goto L42
            if (r10 == r2) goto L40
            return r1
        L40:
            r5 = 1
            return r5
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.checkTime(char, char, char, char, char, char):boolean");
    }

    private void setCalendar(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = calendar;
        calendar.set(1, ((c - '0') * 1000) + ((c2 - '0') * 100) + ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(2, (((c5 - '0') * 10) + (c6 - '0')) - 1);
        this.calendar.set(5, ((c7 - '0') * 10) + (c8 - '0'));
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i, int i2, int i3, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.text, i, i2, i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void arrayCopy(int i, char[] cArr, int i2, int i3) {
        this.text.getChars(i, i3 + i, cArr, i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        if (this.token == 26) {
            int i = this.np + 1;
            int i2 = this.sp;
            if (i2 % 2 == 0) {
                int i3 = i2 / 2;
                byte[] bArr = new byte[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = (i4 * 2) + i;
                    char charAt = this.text.charAt(i5);
                    char charAt2 = this.text.charAt(i5 + 1);
                    char c = '0';
                    int i6 = charAt - (charAt <= '9' ? '0' : '7');
                    if (charAt2 > '9') {
                        c = '7';
                    }
                    bArr[i4] = (byte) ((i6 << 4) | (charAt2 - c));
                }
                return bArr;
            }
            throw new JSONException("illegal state. " + i2);
        } else if (!this.hasSpecial) {
            return IOUtils.decodeBase64(this.text, this.np + 1, this.sp);
        } else {
            return IOUtils.decodeBase64(new String(this.sbuf, 0, this.sp));
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i) {
        return i >= this.len ? JSONLexer.EOI : this.text.charAt(i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void copyTo(int i, int i2, char[] cArr) {
        this.text.getChars(i, i2 + i, cArr, 0);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        char charAt = charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        int i2 = this.np;
        char[] cArr = this.sbuf;
        if (i < cArr.length) {
            this.text.getChars(i2, i2 + i, cArr, 0);
            return new BigDecimal(this.sbuf, 0, i);
        }
        char[] cArr2 = new char[i];
        this.text.getChars(i2, i + i2, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c, int i) {
        return this.text.indexOf(c, i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        while (i < this.bp) {
            if (this.text.charAt(i) == '\n') {
                i2++;
                i3 = 1;
            }
            i++;
            i3++;
        }
        sb.append("pos ");
        sb.append(this.bp);
        sb.append(", line ");
        sb.append(i2);
        sb.append(", column ");
        sb.append(i3);
        if (this.text.length() < 65535) {
            sb.append(this.text);
        } else {
            sb.append(this.text.substring(0, MinElf.PN_XNUM));
        }
        return sb.toString();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        int i = this.bp;
        int i2 = this.len;
        if (i != i2) {
            return this.ch == 26 && i + 1 >= i2;
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean matchField2(char[] cArr) {
        while (JSONLexerBase.isWhitespace(this.ch)) {
            next();
        }
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = this.bp + cArr.length;
        int i = length + 1;
        char charAt = this.text.charAt(length);
        while (JSONLexerBase.isWhitespace(charAt)) {
            charAt = this.text.charAt(i);
            i++;
        }
        if (charAt == ':') {
            this.bp = i;
            this.ch = charAt(i);
            return true;
        }
        this.matchStat = -2;
        return false;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int i = this.bp + 1;
        this.bp = i;
        char charAt = i >= this.len ? JSONLexer.EOI : this.text.charAt(i);
        this.ch = charAt;
        return charAt;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        char charAt = charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        return subString(this.np, i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanDate(char c) {
        char c2;
        long j;
        Date date;
        int i;
        boolean z = false;
        this.matchStat = 0;
        int i2 = this.bp;
        char c3 = this.ch;
        int i3 = i2 + 1;
        char charAt = charAt(i2);
        if (charAt == '\"') {
            int indexOf = indexOf('\"', i3);
            if (indexOf != -1) {
                this.bp = i3;
                if (scanISO8601DateIfMatch(false, indexOf - i3)) {
                    date = this.calendar.getTime();
                    c2 = charAt(indexOf + 1);
                    this.bp = i2;
                    while (c2 != ',' && c2 != ']') {
                        if (JSONLexerBase.isWhitespace(c2)) {
                            indexOf++;
                            c2 = charAt(indexOf + 1);
                        } else {
                            this.bp = i2;
                            this.ch = c3;
                            this.matchStat = -1;
                            return null;
                        }
                    }
                    this.bp = indexOf + 1;
                    this.ch = c2;
                } else {
                    this.bp = i2;
                    this.ch = c3;
                    this.matchStat = -1;
                    return null;
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            char c4 = '9';
            char c5 = '0';
            if (charAt != '-' && (charAt < '0' || charAt > '9')) {
                if (charAt == 'n') {
                    int i4 = i3 + 1;
                    if (charAt(i3) == 'u') {
                        int i5 = i4 + 1;
                        if (charAt(i4) == 'l') {
                            int i6 = i5 + 1;
                            if (charAt(i5) == 'l') {
                                c2 = charAt(i6);
                                this.bp = i6;
                                date = null;
                            }
                        }
                    }
                }
                this.bp = i2;
                this.ch = c3;
                this.matchStat = -1;
                return null;
            }
            if (charAt == '-') {
                charAt = charAt(i3);
                i3++;
                z = true;
            }
            if (charAt < '0' || charAt > '9') {
                c2 = charAt;
                j = 0;
            } else {
                j = charAt - '0';
                while (true) {
                    i = i3 + 1;
                    c2 = charAt(i3);
                    if (c2 < c5 || c2 > c4) {
                        break;
                    }
                    j = (j * 10) + (c2 - '0');
                    i3 = i;
                    c4 = '9';
                    c5 = '0';
                }
                if (c2 == ',' || c2 == ']') {
                    this.bp = i - 1;
                }
            }
            if (j < 0) {
                this.bp = i2;
                this.ch = c3;
                this.matchStat = -1;
                return null;
            }
            if (z) {
                j = -j;
            }
            date = new Date(j);
        }
        if (c2 == ',') {
            int i7 = this.bp + 1;
            this.bp = i7;
            this.ch = charAt(i7);
            this.matchStat = 3;
            return date;
        }
        int i8 = this.bp + 1;
        this.bp = i8;
        char charAt2 = charAt(i8);
        if (charAt2 == ',') {
            this.token = 16;
            int i9 = this.bp + 1;
            this.bp = i9;
            this.ch = charAt(i9);
        } else if (charAt2 == ']') {
            this.token = 15;
            int i10 = this.bp + 1;
            this.bp = i10;
            this.ch = charAt(i10);
        } else if (charAt2 == '}') {
            this.token = 13;
            int i11 = this.bp + 1;
            this.bp = i11;
            this.ch = charAt(i11);
        } else if (charAt2 == 26) {
            this.ch = JSONLexer.EOI;
            this.token = 20;
        } else {
            this.bp = i2;
            this.ch = c3;
            this.matchStat = -1;
            return null;
        }
        this.matchStat = 4;
        return date;
    }

    /* JADX WARN: Removed duplicated region for block: B:171:0x00c0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:173:0x00c4 -> B:168:0x00b4). Please submit an issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double scanDouble(char r22) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanDouble(char):double");
    }

    /* JADX WARN: Code restructure failed: missing block: B:212:0x0152, code lost:
        return r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00f3 A[SYNTHETIC] */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean scanFieldBoolean(char[] r11) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldBoolean(char[]):boolean");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanFieldDate(char[] cArr) {
        char c;
        long j;
        char c2;
        Date date;
        int i;
        boolean z = false;
        this.matchStat = 0;
        int i2 = this.bp;
        char c3 = this.ch;
        if (!charArrayCompare(this.text, i2, cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = this.bp + cArr.length;
        int i3 = length + 1;
        char charAt = charAt(length);
        if (charAt == '\"') {
            int indexOf = indexOf('\"', i3);
            if (indexOf != -1) {
                this.bp = i3;
                if (scanISO8601DateIfMatch(false, indexOf - i3)) {
                    date = this.calendar.getTime();
                    c2 = charAt(indexOf + 1);
                    this.bp = i2;
                    while (c2 != ',' && c2 != '}') {
                        if (JSONLexerBase.isWhitespace(c2)) {
                            indexOf++;
                            c2 = charAt(indexOf + 1);
                        } else {
                            this.matchStat = -1;
                            return null;
                        }
                    }
                    this.bp = indexOf + 1;
                    this.ch = c2;
                } else {
                    this.bp = i2;
                    this.matchStat = -1;
                    return null;
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            char c4 = '9';
            char c5 = '0';
            if (charAt != '-' && (charAt < '0' || charAt > '9')) {
                this.matchStat = -1;
                return null;
            }
            if (charAt == '-') {
                charAt = charAt(i3);
                i3++;
                z = true;
            }
            if (charAt < '0' || charAt > '9') {
                c = charAt;
                j = 0;
            } else {
                j = charAt - '0';
                while (true) {
                    i = i3 + 1;
                    c = charAt(i3);
                    if (c < c5 || c > c4) {
                        break;
                    }
                    j = (j * 10) + (c - '0');
                    i3 = i;
                    c4 = '9';
                    c5 = '0';
                }
                if (c == ',' || c == '}') {
                    this.bp = i - 1;
                }
            }
            if (j < 0) {
                this.matchStat = -1;
                return null;
            }
            if (z) {
                j = -j;
            }
            c2 = c;
            date = new Date(j);
        }
        if (c2 == ',') {
            int i4 = this.bp + 1;
            this.bp = i4;
            this.ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            return date;
        }
        int i5 = this.bp + 1;
        this.bp = i5;
        char charAt2 = charAt(i5);
        if (charAt2 == ',') {
            this.token = 16;
            int i6 = this.bp + 1;
            this.bp = i6;
            this.ch = charAt(i6);
        } else if (charAt2 == ']') {
            this.token = 15;
            int i7 = this.bp + 1;
            this.bp = i7;
            this.ch = charAt(i7);
        } else if (charAt2 == '}') {
            this.token = 13;
            int i8 = this.bp + 1;
            this.bp = i8;
            this.ch = charAt(i8);
        } else if (charAt2 == 26) {
            this.token = 20;
        } else {
            this.bp = i2;
            this.ch = c3;
            this.matchStat = -1;
            return null;
        }
        this.matchStat = 4;
        return date;
    }

    /* JADX WARN: Code restructure failed: missing block: B:129:0x0065, code lost:
        if (r15 != '.') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0067, code lost:
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0069, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x006a, code lost:
        if (r3 >= 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x006c, code lost:
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x006e, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x006f, code lost:
        if (r6 == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0071, code lost:
        if (r15 == '\"') goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0073, code lost:
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0075, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0076, code lost:
        r15 = r11 + 1;
        r4 = charAt(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x007c, code lost:
        r11 = r15;
        r15 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0082, code lost:
        if (r15 == ',') goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0084, code lost:
        if (r15 != '}') goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x008b, code lost:
        if (com.alibaba.fastjson.parser.JSONLexerBase.isWhitespace(r15) == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x008d, code lost:
        r15 = r11 + 1;
        r4 = charAt(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0094, code lost:
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0096, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0097, code lost:
        r11 = r11 - 1;
        r14.bp = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x009c, code lost:
        if (r15 != ',') goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x009e, code lost:
        r11 = r11 + 1;
        r14.bp = r11;
        r14.ch = charAt(r11);
        r14.matchStat = 3;
        r14.token = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x00ac, code lost:
        if (r7 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x00af, code lost:
        return -r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x00b0, code lost:
        if (r15 != '}') goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x00b2, code lost:
        r14.bp = r11;
        r11 = r11 + 1;
        r14.bp = r11;
        r15 = charAt(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x00bb, code lost:
        if (r15 != ',') goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x00bd, code lost:
        r14.token = 16;
        r15 = r14.bp + 1;
        r14.bp = r15;
        r14.ch = charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x00cd, code lost:
        if (r15 != ']') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x00cf, code lost:
        r14.token = 15;
        r15 = r14.bp + 1;
        r14.bp = r15;
        r14.ch = charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x00df, code lost:
        if (r15 != '}') goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x00e1, code lost:
        r14.token = 13;
        r15 = r14.bp + 1;
        r14.bp = r15;
        r14.ch = charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x00f3, code lost:
        if (r15 != 26) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x00f5, code lost:
        r14.token = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x00f9, code lost:
        r14.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0101, code lost:
        if (com.alibaba.fastjson.parser.JSONLexerBase.isWhitespace(r15) == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0103, code lost:
        r15 = r14.bp + 1;
        r14.bp = r15;
        r15 = charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x010d, code lost:
        r14.bp = r1;
        r14.ch = r2;
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0113, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0114, code lost:
        if (r7 == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0117, code lost:
        return -r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x007c, code lost:
        r11 = r15;
        r15 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:?, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:?, code lost:
        return r3;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int scanFieldInt(char[] r15) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldInt(char[]):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:164:0x0112, code lost:
        r20.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0115, code lost:
        if (r11 == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0118, code lost:
        return -r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:?, code lost:
        return r2;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long scanFieldLong(char[] r21) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldLong(char[]):long");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        int i = this.bp;
        char c = this.ch;
        while (!charArrayCompare(this.text, this.bp, cArr)) {
            if (JSONLexerBase.isWhitespace(this.ch)) {
                next();
            } else {
                this.matchStat = -2;
                return stringDefaultValue();
            }
        }
        int length = this.bp + cArr.length;
        int i2 = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', i2);
        if (indexOf != -1) {
            String subString = subString(i2, indexOf - i2);
            if (subString.indexOf(92) != -1) {
                while (true) {
                    int i3 = 0;
                    for (int i4 = indexOf - 1; i4 >= 0 && charAt(i4) == '\\'; i4--) {
                        i3++;
                    }
                    if (i3 % 2 == 0) {
                        break;
                    }
                    indexOf = indexOf('\"', indexOf + 1);
                }
                int i5 = this.bp;
                int length2 = indexOf - ((cArr.length + i5) + 1);
                subString = JSONLexerBase.readString(sub_chars(i5 + cArr.length + 1, length2), length2);
            }
            char charAt = charAt(indexOf + 1);
            while (charAt != ',' && charAt != '}') {
                if (JSONLexerBase.isWhitespace(charAt)) {
                    indexOf++;
                    charAt = charAt(indexOf + 1);
                } else {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
            }
            int i6 = indexOf + 1;
            this.bp = i6;
            this.ch = charAt;
            if (charAt == ',') {
                int i7 = i6 + 1;
                this.bp = i7;
                this.ch = charAt(i7);
                this.matchStat = 3;
                return subString;
            }
            int i8 = i6 + 1;
            this.bp = i8;
            char charAt2 = charAt(i8);
            if (charAt2 == ',') {
                this.token = 16;
                int i9 = this.bp + 1;
                this.bp = i9;
                this.ch = charAt(i9);
            } else if (charAt2 == ']') {
                this.token = 15;
                int i10 = this.bp + 1;
                this.bp = i10;
                this.ch = charAt(i10);
            } else if (charAt2 == '}') {
                this.token = 13;
                int i11 = this.bp + 1;
                this.bp = i11;
                this.ch = charAt(i11);
            } else if (charAt2 == 26) {
                this.token = 20;
            } else {
                this.bp = i;
                this.ch = c;
                this.matchStat = -1;
                return stringDefaultValue();
            }
            this.matchStat = 4;
            return subString;
        }
        throw new JSONException("unclosed str");
    }

    /* JADX WARN: Code restructure failed: missing block: B:156:0x00dd, code lost:
        if (r9 != ']') goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x00e3, code lost:
        if (r3.size() != 0) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x00e5, code lost:
        r2 = r1 + 1;
        r1 = charAt(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x00ef, code lost:
        r17.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x00f2, code lost:
        return null;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r18, java.lang.Class<?> r19) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldStringArray(char[], java.lang.Class):java.util.Collection");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = this.bp + cArr.length;
        int i = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j = -3750763034362895579L;
        while (true) {
            int i2 = i + 1;
            char charAt = charAt(i);
            if (charAt == '\"') {
                this.bp = i2;
                char charAt2 = charAt(i2);
                this.ch = charAt2;
                while (charAt2 != ',') {
                    if (charAt2 == '}') {
                        next();
                        skipWhitespace();
                        char current = getCurrent();
                        if (current == ',') {
                            this.token = 16;
                            int i3 = this.bp + 1;
                            this.bp = i3;
                            this.ch = charAt(i3);
                        } else if (current == ']') {
                            this.token = 15;
                            int i4 = this.bp + 1;
                            this.bp = i4;
                            this.ch = charAt(i4);
                        } else if (current == '}') {
                            this.token = 13;
                            int i5 = this.bp + 1;
                            this.bp = i5;
                            this.ch = charAt(i5);
                        } else if (current == 26) {
                            this.token = 20;
                        } else {
                            this.matchStat = -1;
                            return 0L;
                        }
                        this.matchStat = 4;
                        return j;
                    } else if (JSONLexerBase.isWhitespace(charAt2)) {
                        int i6 = this.bp + 1;
                        this.bp = i6;
                        charAt2 = charAt(i6);
                    } else {
                        this.matchStat = -1;
                        return 0L;
                    }
                }
                int i7 = this.bp + 1;
                this.bp = i7;
                this.ch = charAt(i7);
                this.matchStat = 3;
                return j;
            } else if (i2 > this.len) {
                this.matchStat = -1;
                return 0L;
            } else {
                j = (j ^ charAt) * 1099511628211L;
                i = i2;
            }
        }
    }

    public boolean scanISO8601DateIfMatch() {
        return scanISO8601DateIfMatch(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:129:0x0080, code lost:
        if (r3 != '.') goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0082, code lost:
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0084, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0085, code lost:
        if (r7 == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0087, code lost:
        if (r3 == '\"') goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0089, code lost:
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x008b, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x008c, code lost:
        r3 = charAt(r13);
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0093, code lost:
        if (r4 >= 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0095, code lost:
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0097, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x009a, code lost:
        if (r3 != r17) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x009c, code lost:
        r16.bp = r13;
        r16.ch = charAt(r13);
        r16.matchStat = 3;
        r16.token = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x00a9, code lost:
        if (r8 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x00ac, code lost:
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x00b1, code lost:
        if (com.alibaba.fastjson.parser.JSONLexerBase.isWhitespace(r3) == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x00b3, code lost:
        r3 = charAt(r13);
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x00bb, code lost:
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x00bd, code lost:
        if (r8 == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x00c0, code lost:
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:?, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:?, code lost:
        return r4;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int scanInt(char r17) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanInt(char):int");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c) {
        int i;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        int i2 = this.bp;
        int i3 = i2 + 1;
        char charAt2 = charAt(i2);
        boolean z2 = charAt2 == '\"';
        if (z2) {
            int i4 = i3 + 1;
            char charAt3 = charAt(i3);
            i3 = i4;
            charAt2 = charAt3;
        }
        boolean z3 = charAt2 == '-';
        if (z3) {
            int i5 = i3 + 1;
            char charAt4 = charAt(i3);
            i3 = i5;
            charAt2 = charAt4;
        }
        char c2 = '0';
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j = charAt2 - '0';
            while (true) {
                i = i3 + 1;
                charAt = charAt(i3);
                if (charAt < c2 || charAt > '9') {
                    break;
                }
                j = (j * 10) + (charAt - '0');
                i3 = i;
                c2 = '0';
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0L;
            }
            if (z2) {
                if (charAt != '\"') {
                    this.matchStat = -1;
                    return 0L;
                }
                charAt = charAt(i);
                i++;
            }
            if (j >= 0 || (j == Long.MIN_VALUE && z3)) {
                z = true;
            }
            if (!z) {
                this.matchStat = -1;
                return 0L;
            }
            while (charAt != c) {
                if (JSONLexerBase.isWhitespace(charAt)) {
                    charAt = charAt(i);
                    i++;
                } else {
                    this.matchStat = -1;
                    return j;
                }
            }
            this.bp = i;
            this.ch = charAt(i);
            this.matchStat = 3;
            this.token = 16;
            return z3 ? -j : j;
        }
        if (charAt2 == 'n') {
            int i6 = i3 + 1;
            if (charAt(i3) == 'u') {
                int i7 = i6 + 1;
                if (charAt(i6) == 'l') {
                    int i8 = i7 + 1;
                    if (charAt(i7) == 'l') {
                        this.matchStat = 5;
                        int i9 = i8 + 1;
                        char charAt5 = charAt(i8);
                        if (z2 && charAt5 == '\"') {
                            int i10 = i9 + 1;
                            char charAt6 = charAt(i9);
                            i9 = i10;
                            charAt5 = charAt6;
                        }
                        while (charAt5 != ',') {
                            if (charAt5 == ']') {
                                this.bp = i9;
                                this.ch = charAt(i9);
                                this.matchStat = 5;
                                this.token = 15;
                                return 0L;
                            } else if (JSONLexerBase.isWhitespace(charAt5)) {
                                int i11 = i9 + 1;
                                char charAt7 = charAt(i9);
                                i9 = i11;
                                charAt5 = charAt7;
                            } else {
                                this.matchStat = -1;
                                return 0L;
                            }
                        }
                        this.bp = i9;
                        this.ch = charAt(i9);
                        this.matchStat = 5;
                        this.token = 16;
                        return 0L;
                    }
                }
            }
        }
        this.matchStat = -1;
        return 0L;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public String scanTypeName(SymbolTable symbolTable) {
        int indexOf;
        if (!this.text.startsWith("\"@type\":\"", this.bp) || (indexOf = this.text.indexOf(34, this.bp + 9)) == -1) {
            return null;
        }
        int i = this.bp + 9;
        this.bp = i;
        int i2 = 0;
        while (i < indexOf) {
            i2 = (i2 * 31) + this.text.charAt(i);
            i++;
        }
        int i3 = this.bp;
        String addSymbol = addSymbol(i3, indexOf - i3, i2, symbolTable);
        char charAt = this.text.charAt(indexOf + 1);
        if (charAt == ',' || charAt == ']') {
            int i4 = indexOf + 2;
            this.bp = i4;
            this.ch = this.text.charAt(i4);
            return addSymbol;
        }
        return null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean seekArrayToItem(int i) {
        if (i >= 0) {
            int i2 = this.token;
            if (i2 == 20) {
                return false;
            }
            if (i2 != 14) {
                throw new UnsupportedOperationException();
            }
            int i3 = 0;
            while (true) {
                boolean z = true;
                if (i3 < i) {
                    skipWhitespace();
                    char c = this.ch;
                    if (c != '\"' && c != '\'') {
                        if (c == '{') {
                            next();
                            this.token = 12;
                            skipObject(false);
                        } else if (c == '[') {
                            next();
                            this.token = 14;
                            skipArray(false);
                        } else {
                            int i4 = this.bp + 1;
                            while (true) {
                                if (i4 >= this.text.length()) {
                                    z = false;
                                    break;
                                }
                                char charAt = this.text.charAt(i4);
                                if (charAt == ',') {
                                    int i5 = i4 + 1;
                                    this.bp = i5;
                                    this.ch = charAt(i5);
                                    break;
                                } else if (charAt == ']') {
                                    int i6 = i4 + 1;
                                    this.bp = i6;
                                    this.ch = charAt(i6);
                                    nextToken();
                                    return false;
                                } else {
                                    i4++;
                                }
                            }
                            if (!z) {
                                throw new JSONException("illegal json.");
                            }
                        }
                        int i7 = this.token;
                        if (i7 != 16) {
                            if (i7 == 15) {
                                return false;
                            }
                            throw new UnsupportedOperationException();
                        }
                    } else {
                        skipString();
                        char c2 = this.ch;
                        if (c2 != ',') {
                            if (c2 == ']') {
                                next();
                                nextToken(16);
                                return false;
                            }
                            throw new JSONException("illegal json.");
                        }
                        next();
                    }
                    i3++;
                } else {
                    nextToken();
                    return true;
                }
            }
        } else {
            throw new IllegalArgumentException("index must > 0, but " + i);
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int seekObjectToField(long j, boolean z) {
        char c;
        int i = this.token;
        int i2 = -1;
        if (i == 20) {
            return -1;
        }
        if (i != 13) {
            int i3 = 15;
            if (i != 15) {
                int i4 = 16;
                if (i != 12 && i != 16) {
                    throw new UnsupportedOperationException(JSONToken.name(this.token));
                }
                while (true) {
                    char c2 = this.ch;
                    if (c2 == '}') {
                        next();
                        nextToken();
                        return i2;
                    } else if (c2 == 26) {
                        return i2;
                    } else {
                        if (c2 != '\"') {
                            skipWhitespace();
                        }
                        if (this.ch == '\"') {
                            long j2 = -3750763034362895579L;
                            int i5 = this.bp + 1;
                            while (true) {
                                if (i5 >= this.text.length()) {
                                    break;
                                }
                                char charAt = this.text.charAt(i5);
                                if (charAt == '\\') {
                                    i5++;
                                    if (i5 != this.text.length()) {
                                        charAt = this.text.charAt(i5);
                                    } else {
                                        throw new JSONException("unclosed str, " + info());
                                    }
                                }
                                if (charAt == '\"') {
                                    int i6 = i5 + 1;
                                    this.bp = i6;
                                    this.ch = i6 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(this.bp);
                                } else {
                                    j2 = (j2 ^ charAt) * 1099511628211L;
                                    i5++;
                                }
                            }
                            if (j2 == j) {
                                if (this.ch != ':') {
                                    skipWhitespace();
                                }
                                if (this.ch == ':') {
                                    int i7 = this.bp + 1;
                                    this.bp = i7;
                                    char charAt2 = i7 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i7);
                                    this.ch = charAt2;
                                    if (charAt2 == ',') {
                                        int i8 = this.bp + 1;
                                        this.bp = i8;
                                        this.ch = i8 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i8);
                                        this.token = i4;
                                        return 3;
                                    } else if (charAt2 == ']') {
                                        int i9 = this.bp + 1;
                                        this.bp = i9;
                                        this.ch = i9 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i9);
                                        this.token = i3;
                                        return 3;
                                    } else if (charAt2 == '}') {
                                        int i10 = this.bp + 1;
                                        this.bp = i10;
                                        this.ch = i10 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i10);
                                        this.token = 13;
                                        return 3;
                                    } else if (charAt2 >= '0' && charAt2 <= '9') {
                                        this.sp = 0;
                                        this.pos = this.bp;
                                        scanNumber();
                                        return 3;
                                    } else {
                                        nextToken(2);
                                        return 3;
                                    }
                                }
                                return 3;
                            }
                            if (this.ch != ':') {
                                skipWhitespace();
                            }
                            if (this.ch == ':') {
                                int i11 = this.bp + 1;
                                this.bp = i11;
                                char charAt3 = i11 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i11);
                                this.ch = charAt3;
                                if (charAt3 != '\"' && charAt3 != '\'' && charAt3 != '{' && charAt3 != '[' && charAt3 != '0' && charAt3 != '1' && charAt3 != '2' && charAt3 != '3' && charAt3 != '4' && charAt3 != '5' && charAt3 != '6' && charAt3 != '7' && charAt3 != '8' && charAt3 != '9' && charAt3 != '+' && charAt3 != '-') {
                                    skipWhitespace();
                                }
                                char c3 = this.ch;
                                if (c3 == '-' || c3 == '+' || (c3 >= '0' && c3 <= '9')) {
                                    next();
                                    while (true) {
                                        c = this.ch;
                                        if (c < '0' || c > '9') {
                                            break;
                                        }
                                        next();
                                    }
                                    if (c == '.') {
                                        next();
                                        while (true) {
                                            char c4 = this.ch;
                                            if (c4 < '0' || c4 > '9') {
                                                break;
                                            }
                                            next();
                                        }
                                    }
                                    char c5 = this.ch;
                                    if (c5 == 'E' || c5 == 'e') {
                                        next();
                                        char c6 = this.ch;
                                        if (c6 == '-' || c6 == '+') {
                                            next();
                                        }
                                        while (true) {
                                            char c7 = this.ch;
                                            if (c7 < '0' || c7 > '9') {
                                                break;
                                            }
                                            next();
                                        }
                                    }
                                    if (this.ch != ',') {
                                        skipWhitespace();
                                    }
                                    if (this.ch == ',') {
                                        next();
                                    }
                                } else if (c3 == '\"') {
                                    skipString();
                                    char c8 = this.ch;
                                    if (c8 != ',' && c8 != '}') {
                                        skipWhitespace();
                                    }
                                    if (this.ch == ',') {
                                        next();
                                    }
                                } else if (c3 == 't') {
                                    next();
                                    if (this.ch == 'r') {
                                        next();
                                        if (this.ch == 'u') {
                                            next();
                                            if (this.ch == 'e') {
                                                next();
                                            }
                                        }
                                    }
                                    char c9 = this.ch;
                                    if (c9 != ',' && c9 != '}') {
                                        skipWhitespace();
                                    }
                                    if (this.ch == ',') {
                                        next();
                                    }
                                } else if (c3 == 'n') {
                                    next();
                                    if (this.ch == 'u') {
                                        next();
                                        if (this.ch == 'l') {
                                            next();
                                            if (this.ch == 'l') {
                                                next();
                                            }
                                        }
                                    }
                                    char c10 = this.ch;
                                    if (c10 != ',' && c10 != '}') {
                                        skipWhitespace();
                                    }
                                    if (this.ch == ',') {
                                        next();
                                    }
                                } else if (c3 == 'f') {
                                    next();
                                    if (this.ch == 'a') {
                                        next();
                                        if (this.ch == 'l') {
                                            next();
                                            if (this.ch == 's') {
                                                next();
                                                if (this.ch == 'e') {
                                                    next();
                                                }
                                            }
                                        }
                                    }
                                    char c11 = this.ch;
                                    if (c11 != ',' && c11 != '}') {
                                        skipWhitespace();
                                    }
                                    if (this.ch == ',') {
                                        next();
                                    }
                                } else if (c3 == '{') {
                                    int i12 = this.bp + 1;
                                    this.bp = i12;
                                    this.ch = i12 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i12);
                                    if (z) {
                                        this.token = 12;
                                        return 1;
                                    }
                                    skipObject(false);
                                    if (this.token == 13) {
                                        return -1;
                                    }
                                } else if (c3 == '[') {
                                    next();
                                    if (z) {
                                        this.token = 14;
                                        return 2;
                                    }
                                    skipArray(false);
                                    if (this.token == 13) {
                                        return -1;
                                    }
                                } else {
                                    throw new UnsupportedOperationException();
                                }
                                i2 = -1;
                                i3 = 15;
                                i4 = 16;
                            } else {
                                throw new JSONException("illegal json, " + info());
                            }
                        } else {
                            throw new UnsupportedOperationException();
                        }
                    }
                }
            }
        }
        nextToken();
        return -1;
    }

    public void setTime(char c, char c2, char c3, char c4, char c5, char c6) {
        this.calendar.set(11, ((c - '0') * 10) + (c2 - '0'));
        this.calendar.set(12, ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(13, ((c5 - '0') * 10) + (c6 - '0'));
    }

    public void setTimeZone(char c, char c2, char c3) {
        setTimeZone(c, c2, c3, '0', '0');
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipArray() {
        skipArray(false);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipObject() {
        skipObject(false);
    }

    public final void skipString() {
        if (this.ch == '\"') {
            int i = this.bp;
            while (true) {
                i++;
                if (i < this.text.length()) {
                    char charAt = this.text.charAt(i);
                    if (charAt == '\\') {
                        if (i < this.len - 1) {
                            i++;
                        }
                    } else if (charAt == '\"') {
                        String str = this.text;
                        int i2 = i + 1;
                        this.bp = i2;
                        this.ch = str.charAt(i2);
                        return;
                    }
                } else {
                    throw new JSONException("unclosed str");
                }
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        if (!this.hasSpecial) {
            return subString(this.np + 1, this.sp);
        }
        return new String(this.sbuf, 0, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i, int i2) {
        if (ASMUtils.IS_ANDROID) {
            char[] cArr = this.sbuf;
            if (i2 < cArr.length) {
                this.text.getChars(i, i + i2, cArr, 0);
                return new String(this.sbuf, 0, i2);
            }
            char[] cArr2 = new char[i2];
            this.text.getChars(i, i2 + i, cArr2, 0);
            return new String(cArr2);
        }
        return this.text.substring(i, i2 + i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i, int i2) {
        if (ASMUtils.IS_ANDROID) {
            char[] cArr = this.sbuf;
            if (i2 < cArr.length) {
                this.text.getChars(i, i2 + i, cArr, 0);
                return this.sbuf;
            }
        }
        char[] cArr2 = new char[i2];
        this.text.getChars(i, i2 + i, cArr2, 0);
        return cArr2;
    }

    public JSONScanner(String str, int i) {
        super(i);
        this.text = str;
        this.len = str.length();
        this.bp = -1;
        next();
        if (this.ch == 65279) {
            next();
        }
    }

    public boolean scanISO8601DateIfMatch(boolean z) {
        return scanISO8601DateIfMatch(z, this.len - this.bp);
    }

    public void setTimeZone(char c, char c2, char c3, char c4, char c5) {
        int i = ((((c2 - '0') * 10) + (c3 - '0')) * 3600 * 1000) + ((((c4 - '0') * 10) + (c5 - '0')) * 60 * 1000);
        if (c == '-') {
            i = -i;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i) {
            this.calendar.setTimeZone(new SimpleTimeZone(i, Integer.toString(i)));
        }
    }

    public final void skipArray(boolean z) {
        int i = this.bp;
        boolean z2 = false;
        int i2 = 0;
        while (i < this.text.length()) {
            char charAt = this.text.charAt(i);
            if (charAt == '\\') {
                if (i >= this.len - 1) {
                    this.ch = charAt;
                    this.bp = i;
                    throw new JSONException("illegal str, " + info());
                }
                i++;
            } else if (charAt == '\"') {
                z2 = !z2;
            } else if (charAt != '[') {
                char c = JSONLexer.EOI;
                if (charAt == '{' && z) {
                    int i3 = this.bp + 1;
                    this.bp = i3;
                    if (i3 < this.text.length()) {
                        c = this.text.charAt(i3);
                    }
                    this.ch = c;
                    skipObject(z);
                } else if (charAt == ']' && !z2 && i2 - 1 == -1) {
                    int i4 = i + 1;
                    this.bp = i4;
                    if (i4 == this.text.length()) {
                        this.ch = JSONLexer.EOI;
                        this.token = 20;
                        return;
                    }
                    this.ch = this.text.charAt(this.bp);
                    nextToken(16);
                    return;
                }
            } else if (!z2) {
                i2++;
            }
            i++;
        }
        if (i != this.text.length()) {
            return;
        }
        throw new JSONException("illegal str, " + info());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipObject(boolean z) {
        int i = this.bp;
        boolean z2 = false;
        int i2 = 0;
        while (i < this.text.length()) {
            char charAt = this.text.charAt(i);
            if (charAt == '\\') {
                if (i >= this.len - 1) {
                    this.ch = charAt;
                    this.bp = i;
                    throw new JSONException("illegal str, " + info());
                }
                i++;
            } else if (charAt == '\"') {
                z2 = !z2;
            } else if (charAt == '{') {
                if (!z2) {
                    i2++;
                }
            } else if (charAt == '}' && !z2 && i2 - 1 == -1) {
                int i3 = i + 1;
                this.bp = i3;
                int length = this.text.length();
                char c = JSONLexer.EOI;
                if (i3 == length) {
                    this.ch = JSONLexer.EOI;
                    this.token = 20;
                    return;
                }
                char charAt2 = this.text.charAt(this.bp);
                this.ch = charAt2;
                if (charAt2 == ',') {
                    this.token = 16;
                    int i4 = this.bp + 1;
                    this.bp = i4;
                    if (i4 < this.text.length()) {
                        c = this.text.charAt(i4);
                    }
                    this.ch = c;
                    return;
                } else if (charAt2 == '}') {
                    this.token = 13;
                    next();
                    return;
                } else if (charAt2 == ']') {
                    this.token = 15;
                    next();
                    return;
                } else {
                    nextToken(16);
                    return;
                }
            }
            i++;
        }
        for (int i5 = 0; i5 < this.bp; i5++) {
            if (i5 < this.text.length() && this.text.charAt(i5) == ' ') {
                i++;
            }
        }
        if (i != this.text.length()) {
            return;
        }
        throw new JSONException("illegal str, " + info());
    }

    /* JADX WARN: Removed duplicated region for block: B:551:0x0210 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:553:0x0212  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean scanISO8601DateIfMatch(boolean r35, int r36) {
        /*
            Method dump skipped, instructions count: 1811
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanISO8601DateIfMatch(boolean, int):boolean");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        return charArrayCompare(this.text, this.bp, cArr);
    }

    public JSONScanner(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(char[] cArr, int i, int i2) {
        this(new String(cArr, 0, i), i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String[] scanFieldStringArray(char[] cArr, int i, SymbolTable symbolTable) {
        int i2;
        char c;
        int i3 = this.bp;
        char c2 = this.ch;
        while (JSONLexerBase.isWhitespace(this.ch)) {
            next();
        }
        if (cArr != null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return null;
            }
            int length = this.bp + cArr.length;
            int i4 = length + 1;
            char charAt = this.text.charAt(length);
            while (JSONLexerBase.isWhitespace(charAt)) {
                charAt = this.text.charAt(i4);
                i4++;
            }
            if (charAt == ':') {
                i2 = i4 + 1;
                c = this.text.charAt(i4);
                while (JSONLexerBase.isWhitespace(c)) {
                    c = this.text.charAt(i2);
                    i2++;
                }
            } else {
                this.matchStat = -1;
                return null;
            }
        } else {
            i2 = this.bp + 1;
            c = this.ch;
        }
        if (c == '[') {
            this.bp = i2;
            this.ch = this.text.charAt(i2);
            String[] strArr = i >= 0 ? new String[i] : new String[4];
            int i5 = 0;
            while (true) {
                if (JSONLexerBase.isWhitespace(this.ch)) {
                    next();
                } else if (this.ch != '\"') {
                    this.bp = i3;
                    this.ch = c2;
                    this.matchStat = -1;
                    return null;
                } else {
                    String scanSymbol = scanSymbol(symbolTable, '\"');
                    if (i5 == strArr.length) {
                        String[] strArr2 = new String[strArr.length + (strArr.length >> 1) + 1];
                        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                        strArr = strArr2;
                    }
                    int i6 = i5 + 1;
                    strArr[i5] = scanSymbol;
                    while (JSONLexerBase.isWhitespace(this.ch)) {
                        next();
                    }
                    if (this.ch == ',') {
                        next();
                        i5 = i6;
                    } else {
                        if (strArr.length != i6) {
                            String[] strArr3 = new String[i6];
                            System.arraycopy(strArr, 0, strArr3, 0, i6);
                            strArr = strArr3;
                        }
                        while (JSONLexerBase.isWhitespace(this.ch)) {
                            next();
                        }
                        if (this.ch == ']') {
                            next();
                            return strArr;
                        }
                        this.bp = i3;
                        this.ch = c2;
                        this.matchStat = -1;
                        return null;
                    }
                }
            }
        } else if (c == 'n' && this.text.startsWith("ull", this.bp + 1)) {
            int i7 = this.bp + 4;
            this.bp = i7;
            this.ch = this.text.charAt(i7);
            return null;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int seekObjectToField(long[] jArr) {
        char c;
        int i = this.token;
        if (i != 12 && i != 16) {
            throw new UnsupportedOperationException();
        }
        while (true) {
            char c2 = this.ch;
            if (c2 == '}') {
                next();
                nextToken();
                this.matchStat = -1;
                return -1;
            }
            char c3 = JSONLexer.EOI;
            if (c2 == 26) {
                this.matchStat = -1;
                return -1;
            }
            if (c2 != '\"') {
                skipWhitespace();
            }
            if (this.ch == '\"') {
                long j = -3750763034362895579L;
                int i2 = this.bp;
                while (true) {
                    i2++;
                    if (i2 >= this.text.length()) {
                        break;
                    }
                    char charAt = this.text.charAt(i2);
                    if (charAt == '\\') {
                        i2++;
                        if (i2 != this.text.length()) {
                            charAt = this.text.charAt(i2);
                        } else {
                            throw new JSONException("unclosed str, " + info());
                        }
                    }
                    if (charAt == '\"') {
                        int i3 = i2 + 1;
                        this.bp = i3;
                        this.ch = i3 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(this.bp);
                    } else {
                        j = (j ^ charAt) * 1099511628211L;
                    }
                }
                int i4 = 0;
                while (true) {
                    if (i4 >= jArr.length) {
                        i4 = -1;
                        break;
                    } else if (j == jArr[i4]) {
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i4 != -1) {
                    if (this.ch != ':') {
                        skipWhitespace();
                    }
                    if (this.ch == ':') {
                        int i5 = this.bp + 1;
                        this.bp = i5;
                        char charAt2 = i5 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i5);
                        this.ch = charAt2;
                        if (charAt2 == ',') {
                            int i6 = this.bp + 1;
                            this.bp = i6;
                            if (i6 < this.text.length()) {
                                c3 = this.text.charAt(i6);
                            }
                            this.ch = c3;
                            this.token = 16;
                        } else if (charAt2 == ']') {
                            int i7 = this.bp + 1;
                            this.bp = i7;
                            if (i7 < this.text.length()) {
                                c3 = this.text.charAt(i7);
                            }
                            this.ch = c3;
                            this.token = 15;
                        } else if (charAt2 == '}') {
                            int i8 = this.bp + 1;
                            this.bp = i8;
                            if (i8 < this.text.length()) {
                                c3 = this.text.charAt(i8);
                            }
                            this.ch = c3;
                            this.token = 13;
                        } else if (charAt2 >= '0' && charAt2 <= '9') {
                            this.sp = 0;
                            this.pos = this.bp;
                            scanNumber();
                        } else {
                            nextToken(2);
                        }
                    }
                    this.matchStat = 3;
                    return i4;
                }
                if (this.ch != ':') {
                    skipWhitespace();
                }
                if (this.ch == ':') {
                    int i9 = this.bp + 1;
                    this.bp = i9;
                    char charAt3 = i9 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i9);
                    this.ch = charAt3;
                    if (charAt3 != '\"' && charAt3 != '\'' && charAt3 != '{' && charAt3 != '[' && charAt3 != '0' && charAt3 != '1' && charAt3 != '2' && charAt3 != '3' && charAt3 != '4' && charAt3 != '5' && charAt3 != '6' && charAt3 != '7' && charAt3 != '8' && charAt3 != '9' && charAt3 != '+' && charAt3 != '-') {
                        skipWhitespace();
                    }
                    char c4 = this.ch;
                    if (c4 == '-' || c4 == '+' || (c4 >= '0' && c4 <= '9')) {
                        next();
                        while (true) {
                            c = this.ch;
                            if (c < '0' || c > '9') {
                                break;
                            }
                            next();
                        }
                        if (c == '.') {
                            next();
                            while (true) {
                                char c5 = this.ch;
                                if (c5 < '0' || c5 > '9') {
                                    break;
                                }
                                next();
                            }
                        }
                        char c6 = this.ch;
                        if (c6 == 'E' || c6 == 'e') {
                            next();
                            char c7 = this.ch;
                            if (c7 == '-' || c7 == '+') {
                                next();
                            }
                            while (true) {
                                char c8 = this.ch;
                                if (c8 < '0' || c8 > '9') {
                                    break;
                                }
                                next();
                            }
                        }
                        if (this.ch != ',') {
                            skipWhitespace();
                        }
                        if (this.ch == ',') {
                            next();
                        }
                    } else if (c4 == '\"') {
                        skipString();
                        char c9 = this.ch;
                        if (c9 != ',' && c9 != '}') {
                            skipWhitespace();
                        }
                        if (this.ch == ',') {
                            next();
                        }
                    } else if (c4 == '{') {
                        int i10 = this.bp + 1;
                        this.bp = i10;
                        if (i10 < this.text.length()) {
                            c3 = this.text.charAt(i10);
                        }
                        this.ch = c3;
                        skipObject(false);
                    } else if (c4 == '[') {
                        next();
                        skipArray(false);
                    } else {
                        throw new UnsupportedOperationException();
                    }
                } else {
                    throw new JSONException("illegal json, " + info());
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }
}
