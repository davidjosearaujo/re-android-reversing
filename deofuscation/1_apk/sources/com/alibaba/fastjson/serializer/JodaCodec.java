package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.TimeZone;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.joda.time.ReadablePartial;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class JodaCodec implements ObjectSerializer, ContextObjectSerializer, ObjectDeserializer {
    private static final String formatter_iso8601_pattern_23 = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    private static final String formatter_iso8601_pattern_29 = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
    public static final JodaCodec instance = new JodaCodec();
    private static final String defaultPatttern = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter defaultFormatter = DateTimeFormat.forPattern(defaultPatttern);
    private static final DateTimeFormatter defaultFormatter_23 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private static final DateTimeFormatter formatter_dt19_tw = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_cn = DateTimeFormat.forPattern("yyyy年M月d日 HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_cn_1 = DateTimeFormat.forPattern("yyyy年M月d日 H时m分s秒");
    private static final DateTimeFormatter formatter_dt19_kr = DateTimeFormat.forPattern("yyyy년M월d일 HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_us = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_eur = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_de = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_in = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss");
    private static final DateTimeFormatter formatter_d8 = DateTimeFormat.forPattern("yyyyMMdd");
    private static final DateTimeFormatter formatter_d10_tw = DateTimeFormat.forPattern("yyyy/MM/dd");
    private static final DateTimeFormatter formatter_d10_cn = DateTimeFormat.forPattern("yyyy年M月d日");
    private static final DateTimeFormatter formatter_d10_kr = DateTimeFormat.forPattern("yyyy년M월d일");
    private static final DateTimeFormatter formatter_d10_us = DateTimeFormat.forPattern("MM/dd/yyyy");
    private static final DateTimeFormatter formatter_d10_eur = DateTimeFormat.forPattern("dd/MM/yyyy");
    private static final DateTimeFormatter formatter_d10_de = DateTimeFormat.forPattern("dd.MM.yyyy");
    private static final DateTimeFormatter formatter_d10_in = DateTimeFormat.forPattern("dd-MM-yyyy");
    private static final DateTimeFormatter ISO_FIXED_FORMAT = DateTimeFormat.forPattern(defaultPatttern).withZone(DateTimeZone.getDefault());
    private static final String formatter_iso8601_pattern = "yyyy-MM-dd'T'HH:mm:ss";
    private static final DateTimeFormatter formatter_iso8601 = DateTimeFormat.forPattern(formatter_iso8601_pattern);

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null, 0);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x012b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.joda.time.LocalDateTime parseDateTime(java.lang.String r17, org.joda.time.format.DateTimeFormatter r18) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JodaCodec.parseDateTime(java.lang.String, org.joda.time.format.DateTimeFormatter):org.joda.time.LocalDateTime");
    }

    public LocalDate parseLocalDate(String str, String str2, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        DateTimeFormatter dateTimeFormatter3;
        if (dateTimeFormatter == null) {
            if (str.length() == 8) {
                dateTimeFormatter = formatter_d8;
            }
            boolean z = false;
            if (str.length() == 10) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                if (charAt == '/' && charAt2 == '/') {
                    dateTimeFormatter = formatter_d10_tw;
                }
                char charAt3 = str.charAt(0);
                char charAt4 = str.charAt(1);
                char charAt5 = str.charAt(2);
                char charAt6 = str.charAt(3);
                char charAt7 = str.charAt(5);
                if (charAt5 == '/' && charAt7 == '/') {
                    int i = ((charAt6 - '0') * 10) + (charAt - '0');
                    if (((charAt3 - '0') * 10) + (charAt4 - '0') > 12) {
                        dateTimeFormatter3 = formatter_d10_eur;
                    } else if (i > 12) {
                        dateTimeFormatter3 = formatter_d10_us;
                    } else {
                        String country = Locale.getDefault().getCountry();
                        if (country.equals("US")) {
                            dateTimeFormatter3 = formatter_d10_us;
                        } else if (country.equals("BR") || country.equals("AU")) {
                            dateTimeFormatter3 = formatter_d10_eur;
                        }
                    }
                    dateTimeFormatter = dateTimeFormatter3;
                } else if (charAt5 == '.' && charAt7 == '.') {
                    dateTimeFormatter = formatter_d10_de;
                } else if (charAt5 == '-' && charAt7 == '-') {
                    dateTimeFormatter = formatter_d10_in;
                }
            }
            if (str.length() >= 9) {
                char charAt8 = str.charAt(4);
                if (charAt8 == 24180) {
                    dateTimeFormatter2 = formatter_d10_cn;
                } else if (charAt8 == 45380) {
                    dateTimeFormatter2 = formatter_d10_kr;
                }
                dateTimeFormatter = dateTimeFormatter2;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= str.length()) {
                    z = true;
                    break;
                }
                char charAt9 = str.charAt(i2);
                if (charAt9 < '0' || charAt9 > '9') {
                    break;
                }
                i2++;
            }
            if (z && str.length() > 8 && str.length() < 19) {
                return new LocalDateTime(Long.parseLong(str), DateTimeZone.forTimeZone(JSON.defaultTimeZone)).toLocalDate();
            }
        }
        if (dateTimeFormatter == null) {
            return LocalDate.parse(str);
        }
        return LocalDate.parse(str, dateTimeFormatter);
    }

    public DateTime parseZonedDateTime(String str, DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter == null) {
            if (str.length() == 19) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                char charAt3 = str.charAt(10);
                char charAt4 = str.charAt(13);
                char charAt5 = str.charAt(16);
                if (charAt4 == ':' && charAt5 == ':') {
                    if (charAt == '-' && charAt2 == '-') {
                        if (charAt3 == 'T') {
                            dateTimeFormatter = formatter_iso8601;
                        } else if (charAt3 == ' ') {
                            dateTimeFormatter = defaultFormatter;
                        }
                    } else if (charAt == '/' && charAt2 == '/') {
                        dateTimeFormatter = formatter_dt19_tw;
                    } else {
                        char charAt6 = str.charAt(0);
                        char charAt7 = str.charAt(1);
                        char charAt8 = str.charAt(2);
                        char charAt9 = str.charAt(3);
                        char charAt10 = str.charAt(5);
                        if (charAt8 == '/' && charAt10 == '/') {
                            int i = ((charAt9 - '0') * 10) + (charAt - '0');
                            if (((charAt6 - '0') * 10) + (charAt7 - '0') > 12) {
                                dateTimeFormatter = formatter_dt19_eur;
                            } else if (i > 12) {
                                dateTimeFormatter = formatter_dt19_us;
                            } else {
                                String country = Locale.getDefault().getCountry();
                                if (country.equals("US")) {
                                    dateTimeFormatter = formatter_dt19_us;
                                } else if (country.equals("BR") || country.equals("AU")) {
                                    dateTimeFormatter = formatter_dt19_eur;
                                }
                            }
                        } else if (charAt8 == '.' && charAt10 == '.') {
                            dateTimeFormatter = formatter_dt19_de;
                        } else if (charAt8 == '-' && charAt10 == '-') {
                            dateTimeFormatter = formatter_dt19_in;
                        }
                    }
                }
            }
            if (str.length() >= 17) {
                char charAt11 = str.charAt(4);
                if (charAt11 == 24180) {
                    if (str.charAt(str.length() - 1) == 31186) {
                        dateTimeFormatter = formatter_dt19_cn_1;
                    } else {
                        dateTimeFormatter = formatter_dt19_cn;
                    }
                } else if (charAt11 == 45380) {
                    dateTimeFormatter = formatter_dt19_kr;
                }
            }
        }
        if (dateTimeFormatter == null) {
            return DateTime.parse(str);
        }
        return DateTime.parse(str, dateTimeFormatter);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if (type == null) {
            type = obj.getClass();
        }
        if (type == LocalDateTime.class) {
            SerializerFeature serializerFeature = SerializerFeature.UseISO8601DateFormat;
            int mask = serializerFeature.getMask();
            LocalDateTime localDateTime = (LocalDateTime) obj;
            String dateFormatPattern = jSONSerializer.getDateFormatPattern();
            if (dateFormatPattern == null) {
                if ((i & mask) != 0 || jSONSerializer.isEnabled(serializerFeature)) {
                    dateFormatPattern = formatter_iso8601_pattern;
                } else {
                    dateFormatPattern = localDateTime.getMillisOfSecond() == 0 ? formatter_iso8601_pattern_23 : formatter_iso8601_pattern_29;
                }
            }
            if (dateFormatPattern != null) {
                write(serializeWriter, (ReadablePartial) localDateTime, dateFormatPattern);
                return;
            } else if (serializeWriter.isEnabled(SerializerFeature.WriteDateUseDateFormat)) {
                write(serializeWriter, (ReadablePartial) localDateTime, JSON.DEFFAULT_DATE_FORMAT);
                return;
            } else {
                serializeWriter.writeLong(localDateTime.toDateTime(DateTimeZone.forTimeZone(JSON.defaultTimeZone)).toInstant().getMillis());
                return;
            }
        }
        serializeWriter.writeString(obj.toString());
    }

    /* JADX WARN: Type inference failed for: r8v3, types: [T, org.joda.time.LocalDateTime] */
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str, int i) {
        DateTimeFormatter dateTimeFormatter;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        } else if (jSONLexer.token() == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken();
            if (str == null) {
                dateTimeFormatter = null;
            } else if (defaultPatttern.equals(str)) {
                dateTimeFormatter = defaultFormatter;
            } else {
                dateTimeFormatter = DateTimeFormat.forPattern(str);
            }
            if ("".equals(stringVal)) {
                return null;
            }
            if (type == LocalDateTime.class) {
                if (stringVal.length() != 10 && stringVal.length() != 8) {
                    return (T) parseDateTime(stringVal, dateTimeFormatter);
                }
                return (T) parseLocalDate(stringVal, str, dateTimeFormatter).toLocalDateTime(LocalTime.MIDNIGHT);
            } else if (type == LocalDate.class) {
                if (stringVal.length() == 23) {
                    return (T) LocalDateTime.parse(stringVal).toLocalDate();
                }
                return (T) parseLocalDate(stringVal, str, dateTimeFormatter);
            } else if (type == LocalTime.class) {
                if (stringVal.length() == 23) {
                    return (T) LocalDateTime.parse(stringVal).toLocalTime();
                }
                return (T) LocalTime.parse(stringVal);
            } else if (type == DateTime.class) {
                if (dateTimeFormatter == defaultFormatter) {
                    dateTimeFormatter = ISO_FIXED_FORMAT;
                }
                return (T) parseZonedDateTime(stringVal, dateTimeFormatter);
            } else if (type == DateTimeZone.class) {
                return (T) DateTimeZone.forID(stringVal);
            } else {
                if (type == Period.class) {
                    return (T) Period.parse(stringVal);
                }
                if (type == Duration.class) {
                    return (T) Duration.parse(stringVal);
                }
                if (type == Instant.class) {
                    boolean z = false;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= stringVal.length()) {
                            z = true;
                            break;
                        }
                        char charAt = stringVal.charAt(i2);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i2++;
                    }
                    if (z && stringVal.length() > 8 && stringVal.length() < 19) {
                        return (T) new Instant(Long.parseLong(stringVal));
                    }
                    return (T) Instant.parse(stringVal);
                } else if (type == DateTimeFormatter.class) {
                    return (T) DateTimeFormat.forPattern(stringVal);
                } else {
                    return null;
                }
            }
        } else if (jSONLexer.token() == 2) {
            long longValue = jSONLexer.longValue();
            jSONLexer.nextToken();
            TimeZone timeZone = JSON.defaultTimeZone;
            if (timeZone == null) {
                timeZone = TimeZone.getDefault();
            }
            if (type == DateTime.class) {
                return (T) new DateTime(longValue, DateTimeZone.forTimeZone(timeZone));
            }
            ?? r8 = (T) new LocalDateTime(longValue, DateTimeZone.forTimeZone(timeZone));
            if (type == LocalDateTime.class) {
                return r8;
            }
            if (type == LocalDate.class) {
                return (T) r8.toLocalDate();
            }
            if (type == LocalTime.class) {
                return (T) r8.toLocalTime();
            }
            if (type == Instant.class) {
                return (T) new Instant(longValue);
            }
            throw new UnsupportedOperationException();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.alibaba.fastjson.serializer.ContextObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, BeanContext beanContext) throws IOException {
        write(jSONSerializer.out, (ReadablePartial) obj, beanContext.getFormat());
    }

    private void write(SerializeWriter serializeWriter, ReadablePartial readablePartial, String str) {
        DateTimeFormatter forPattern;
        if (str.equals(formatter_iso8601_pattern)) {
            forPattern = formatter_iso8601;
        } else {
            forPattern = DateTimeFormat.forPattern(str);
        }
        serializeWriter.writeString(forPattern.print(readablePartial));
    }
}