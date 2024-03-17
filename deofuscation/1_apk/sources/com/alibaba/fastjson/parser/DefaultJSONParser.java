package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONPathException;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.hunantv.oversea.channel.dynamic.data.ParamParser;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    private static final Set<Class<?>> primitiveClasses = new HashSet();
    private String[] autoTypeAccept;
    private boolean autoTypeEnable;
    public ParserConfig config;
    public ParseContext context;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private List<ExtraProcessor> extraProcessors;
    private List<ExtraTypeProvider> extraTypeProviders;
    public FieldTypeResolver fieldTypeResolver;
    public final Object input;
    public transient BeanContext lastBeanContext;
    public final JSONLexer lexer;
    private int objectKeyLevel;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class ResolveTask {
        public final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        public final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    static {
        Class<?>[] clsArr = {Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class};
        for (int i = 0; i < 17; i++) {
            primitiveClasses.add(clsArr[i]);
        }
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
    }

    private void addContext(ParseContext parseContext) {
        int i = this.contextArrayIndex;
        this.contextArrayIndex = i + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new ParseContext[8];
        } else if (i >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[(parseContextArr.length * 3) / 2];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        this.contextArray[i] = parseContext;
    }

    public final void accept(int i) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(jSONLexer.token()));
    }

    public void acceptType(String str) {
        JSONLexer jSONLexer = this.lexer;
        jSONLexer.nextTokenWithColon();
        if (jSONLexer.token() == 4) {
            if (str.equals(jSONLexer.stringVal())) {
                jSONLexer.nextToken();
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken();
                    return;
                }
                return;
            }
            throw new JSONException("type not match error");
        }
        throw new JSONException("type not match error");
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public void checkListResolve(Collection collection) {
        if (this.resolveStatus == 1) {
            if (collection instanceof List) {
                ResolveTask lastResolveTask = getLastResolveTask();
                lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, collection.size() - 1);
                lastResolveTask.ownerContext = this.context;
                setResolveStatus(0);
                return;
            }
            ResolveTask lastResolveTask2 = getLastResolveTask();
            lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(collection);
            lastResolveTask2.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    public void checkMapResolve(Map map, Object obj) {
        if (this.resolveStatus == 1) {
            ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
            lastResolveTask.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        JSONLexer jSONLexer = this.lexer;
        try {
            if (jSONLexer.isEnabled(Feature.AutoCloseSource) && jSONLexer.token() != 20) {
                throw new JSONException("not close json text, token : " + JSONToken.name(jSONLexer.token()));
            }
        } finally {
            jSONLexer.close();
        }
    }

    public void config(Feature feature, boolean z) {
        this.lexer.config(feature, z);
    }

    public ParserConfig getConfig() {
        return this.config;
    }

    public ParseContext getContext() {
        return this.context;
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.getLocale());
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.getTimeZone());
        }
        return this.dateFormat;
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public FieldTypeResolver getFieldTypeResolver() {
        return this.fieldTypeResolver;
    }

    public String getInput() {
        Object obj = this.input;
        if (obj instanceof char[]) {
            return new String((char[]) this.input);
        }
        return obj.toString();
    }

    public ResolveTask getLastResolveTask() {
        List<ResolveTask> list = this.resolveTaskList;
        return list.get(list.size() - 1);
    }

    public JSONLexer getLexer() {
        return this.lexer;
    }

    public Object getObject(String str) {
        for (int i = 0; i < this.contextArrayIndex; i++) {
            if (str.equals(this.contextArray[i].toString())) {
                return this.contextArray[i].object;
            }
        }
        return null;
    }

    public int getResolveStatus() {
        return this.resolveStatus;
    }

    public List<ResolveTask> getResolveTaskList() {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        return this.resolveTaskList;
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public void handleResovleTask(Object obj) {
        Object obj2;
        FieldInfo fieldInfo;
        List<ResolveTask> list = this.resolveTaskList;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ResolveTask resolveTask = this.resolveTaskList.get(i);
            String str = resolveTask.referenceValue;
            ParseContext parseContext = resolveTask.ownerContext;
            Object obj3 = parseContext != null ? parseContext.object : null;
            if (str.startsWith(ParamParser.m)) {
                obj2 = getObject(str);
                if (obj2 == null) {
                    try {
                        JSONPath compile = JSONPath.compile(str);
                        if (compile.isRef()) {
                            obj2 = compile.eval(obj);
                        }
                    } catch (JSONPathException unused) {
                    }
                }
            } else {
                obj2 = resolveTask.context.object;
            }
            FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
            if (fieldDeserializer != null) {
                if (obj2 != null && obj2.getClass() == JSONObject.class && (fieldInfo = fieldDeserializer.fieldInfo) != null && !Map.class.isAssignableFrom(fieldInfo.fieldClass)) {
                    Object obj4 = this.contextArray[0].object;
                    JSONPath compile2 = JSONPath.compile(str);
                    if (compile2.isRef()) {
                        obj2 = compile2.eval(obj4);
                    }
                }
                fieldDeserializer.setValue(obj3, obj2);
            }
        }
    }

    public boolean isEnabled(Feature feature) {
        return this.lexer.isEnabled(feature);
    }

    public Object parse() {
        return parse(null);
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public Object parseArrayWithType(Type type) {
        if (this.lexer.token() == 8) {
            this.lexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length == 1) {
            Type type2 = actualTypeArguments[0];
            if (type2 instanceof Class) {
                ArrayList arrayList = new ArrayList();
                parseArray((Class) type2, (Collection) arrayList);
                return arrayList;
            } else if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type2;
                Type type3 = wildcardType.getUpperBounds()[0];
                if (Object.class.equals(type3)) {
                    if (wildcardType.getLowerBounds().length == 0) {
                        return parse();
                    }
                    throw new JSONException("not support type : " + type);
                }
                ArrayList arrayList2 = new ArrayList();
                parseArray((Class) type3, (Collection) arrayList2);
                return arrayList2;
            } else {
                if (type2 instanceof TypeVariable) {
                    TypeVariable typeVariable = (TypeVariable) type2;
                    Type[] bounds = typeVariable.getBounds();
                    if (bounds.length == 1) {
                        Type type4 = bounds[0];
                        if (type4 instanceof Class) {
                            ArrayList arrayList3 = new ArrayList();
                            parseArray((Class) type4, (Collection) arrayList3);
                            return arrayList3;
                        }
                    } else {
                        throw new JSONException("not support : " + typeVariable);
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ArrayList arrayList4 = new ArrayList();
                    parseArray((ParameterizedType) type2, arrayList4);
                    return arrayList4;
                }
                throw new JSONException("TODO : " + type);
            }
        }
        throw new JSONException("not support type " + type);
    }

    public void parseExtra(Object obj, String str) {
        Object parseObject;
        this.lexer.nextTokenWithColon();
        List<ExtraTypeProvider> list = this.extraTypeProviders;
        Type type = null;
        if (list != null) {
            for (ExtraTypeProvider extraTypeProvider : list) {
                type = extraTypeProvider.getExtraType(obj, str);
            }
        }
        if (type == null) {
            parseObject = parse();
        } else {
            parseObject = parseObject(type);
        }
        if (obj instanceof ExtraProcessable) {
            ((ExtraProcessable) obj).processExtra(str, parseObject);
            return;
        }
        List<ExtraProcessor> list2 = this.extraProcessors;
        if (list2 != null) {
            for (ExtraProcessor extraProcessor : list2) {
                extraProcessor.processExtra(obj, str, parseObject);
            }
        }
        if (this.resolveStatus == 1) {
            this.resolveStatus = 0;
        }
    }

    public Object parseKey() {
        if (this.lexer.token() == 18) {
            String stringVal = this.lexer.stringVal();
            this.lexer.nextToken(16);
            return stringVal;
        }
        return parse(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:565:0x0294, code lost:
        r5.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:566:0x029f, code lost:
        if (r5.token() != 13) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:567:0x02a1, code lost:
        r5.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:569:0x02ac, code lost:
        if ((r18.config.getDeserializer(r8) instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:570:0x02ae, code lost:
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r19, (java.lang.Class<java.lang.Object>) r8, r18.config);
     */
    /* JADX WARN: Code restructure failed: missing block: B:571:0x02b5, code lost:
        r0 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:572:0x02b6, code lost:
        if (r0 != null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:574:0x02ba, code lost:
        if (r8 != java.lang.Cloneable.class) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:575:0x02bc, code lost:
        r0 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:577:0x02c8, code lost:
        if ("java.util.Collections$EmptyMap".equals(r7) == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:578:0x02ca, code lost:
        r0 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:580:0x02d5, code lost:
        if ("java.util.Collections$UnmodifiableMap".equals(r7) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:581:0x02d7, code lost:
        r0 = java.util.Collections.unmodifiableMap(new java.util.HashMap());
     */
    /* JADX WARN: Code restructure failed: missing block: B:582:0x02e1, code lost:
        r0 = r8.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:584:0x02e8, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:585:0x02e9, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:587:0x02f1, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:588:0x02f2, code lost:
        setResolveStatus(2);
        r3 = r18.context;
     */
    /* JADX WARN: Code restructure failed: missing block: B:589:0x02f8, code lost:
        if (r3 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:590:0x02fa, code lost:
        if (r20 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:592:0x02fe, code lost:
        if ((r20 instanceof java.lang.Integer) != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:594:0x0304, code lost:
        if ((r3.fieldName instanceof java.lang.Integer) != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:595:0x0306, code lost:
        popContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:597:0x030d, code lost:
        if (r19.size() <= 0) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:598:0x030f, code lost:
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r19, (java.lang.Class<java.lang.Object>) r8, r18.config);
        setResolveStatus(0);
        parseObject(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:600:0x031f, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:601:0x0320, code lost:
        r0 = r18.config.getDeserializer(r8);
        r3 = r0.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:602:0x0330, code lost:
        if (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class.isAssignableFrom(r3) == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:604:0x0334, code lost:
        if (r3 == com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:606:0x0338, code lost:
        if (r3 == com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer.class) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:607:0x033a, code lost:
        setResolveStatus(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:609:0x0341, code lost:
        if ((r0 instanceof com.alibaba.fastjson.parser.deserializer.MapDeserializer) == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:610:0x0343, code lost:
        setResolveStatus(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:613:0x034e, code lost:
        return r0.deserialze(r18, r8, r20);
     */
    /* JADX WARN: Removed duplicated region for block: B:514:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:537:0x021d A[Catch: all -> 0x067f, TryCatch #2 {all -> 0x067f, blocks: (B:446:0x0075, B:448:0x0079, B:451:0x0083, B:454:0x0096, B:458:0x00ac, B:537:0x021d, B:538:0x0223, B:540:0x022e, B:542:0x0236, B:546:0x024c, B:548:0x025a, B:564:0x028e, B:565:0x0294, B:567:0x02a1, B:568:0x02a4, B:570:0x02ae, B:575:0x02bc, B:576:0x02c2, B:578:0x02ca, B:579:0x02cf, B:581:0x02d7, B:582:0x02e1, B:586:0x02ea, B:587:0x02f1, B:588:0x02f2, B:591:0x02fc, B:593:0x0300, B:595:0x0306, B:596:0x0309, B:598:0x030f, B:601:0x0320, B:607:0x033a, B:611:0x0347, B:608:0x033f, B:610:0x0343, B:550:0x0261, B:552:0x0267, B:557:0x0274, B:561:0x027e, B:619:0x0358, B:621:0x035e, B:623:0x0366, B:625:0x0370, B:627:0x0381, B:629:0x038c, B:631:0x0394, B:633:0x0398, B:635:0x039e, B:638:0x03a3, B:640:0x03a7, B:660:0x03f5, B:662:0x03fd, B:665:0x0406, B:666:0x0421, B:642:0x03ac, B:644:0x03b4, B:647:0x03ba, B:648:0x03c7, B:651:0x03d0, B:654:0x03d6, B:657:0x03db, B:658:0x03e8, B:667:0x0422, B:668:0x0440, B:671:0x0446, B:673:0x044a, B:675:0x044e, B:678:0x0454, B:682:0x045c, B:688:0x046c, B:690:0x047b, B:692:0x0486, B:693:0x048e, B:694:0x0491, B:706:0x04bd, B:708:0x04c8, B:712:0x04d5, B:715:0x04e5, B:716:0x0506, B:701:0x04a1, B:703:0x04ab, B:705:0x04ba, B:704:0x04b0, B:719:0x050b, B:721:0x0515, B:723:0x051b, B:724:0x051e, B:726:0x0529, B:727:0x052d, B:729:0x0538, B:732:0x053f, B:735:0x0548, B:736:0x054d, B:739:0x0552, B:741:0x0557, B:745:0x0560, B:747:0x0568, B:749:0x057d, B:753:0x059c, B:755:0x05a2, B:758:0x05a8, B:760:0x05ae, B:762:0x05b6, B:765:0x05c7, B:768:0x05cf, B:770:0x05d3, B:771:0x05da, B:773:0x05df, B:774:0x05e2, B:776:0x05ea, B:779:0x05f4, B:782:0x05fe, B:783:0x0603, B:784:0x0608, B:785:0x0623, B:750:0x0588, B:751:0x058f, B:786:0x0624, B:788:0x0636, B:791:0x063d, B:794:0x0649, B:795:0x066a, B:461:0x00c0, B:462:0x00de, B:465:0x00e3, B:467:0x00ee, B:469:0x00f2, B:471:0x00f6, B:474:0x00fc, B:481:0x010b, B:483:0x0113, B:486:0x0125, B:487:0x013d, B:488:0x013e, B:489:0x0143, B:500:0x0158, B:501:0x015e, B:503:0x0165, B:505:0x0170, B:512:0x0182, B:515:0x018c, B:516:0x01a4, B:510:0x017d, B:504:0x016a, B:517:0x01a5, B:518:0x01bd, B:524:0x01c7, B:526:0x01cf, B:529:0x01e2, B:530:0x0202, B:531:0x0203, B:532:0x0208, B:533:0x0209, B:535:0x0213, B:796:0x066b, B:797:0x0672, B:798:0x0673, B:799:0x0678, B:800:0x0679, B:801:0x067e), top: B:809:0x0075, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:671:0x0446 A[Catch: all -> 0x067f, TryCatch #2 {all -> 0x067f, blocks: (B:446:0x0075, B:448:0x0079, B:451:0x0083, B:454:0x0096, B:458:0x00ac, B:537:0x021d, B:538:0x0223, B:540:0x022e, B:542:0x0236, B:546:0x024c, B:548:0x025a, B:564:0x028e, B:565:0x0294, B:567:0x02a1, B:568:0x02a4, B:570:0x02ae, B:575:0x02bc, B:576:0x02c2, B:578:0x02ca, B:579:0x02cf, B:581:0x02d7, B:582:0x02e1, B:586:0x02ea, B:587:0x02f1, B:588:0x02f2, B:591:0x02fc, B:593:0x0300, B:595:0x0306, B:596:0x0309, B:598:0x030f, B:601:0x0320, B:607:0x033a, B:611:0x0347, B:608:0x033f, B:610:0x0343, B:550:0x0261, B:552:0x0267, B:557:0x0274, B:561:0x027e, B:619:0x0358, B:621:0x035e, B:623:0x0366, B:625:0x0370, B:627:0x0381, B:629:0x038c, B:631:0x0394, B:633:0x0398, B:635:0x039e, B:638:0x03a3, B:640:0x03a7, B:660:0x03f5, B:662:0x03fd, B:665:0x0406, B:666:0x0421, B:642:0x03ac, B:644:0x03b4, B:647:0x03ba, B:648:0x03c7, B:651:0x03d0, B:654:0x03d6, B:657:0x03db, B:658:0x03e8, B:667:0x0422, B:668:0x0440, B:671:0x0446, B:673:0x044a, B:675:0x044e, B:678:0x0454, B:682:0x045c, B:688:0x046c, B:690:0x047b, B:692:0x0486, B:693:0x048e, B:694:0x0491, B:706:0x04bd, B:708:0x04c8, B:712:0x04d5, B:715:0x04e5, B:716:0x0506, B:701:0x04a1, B:703:0x04ab, B:705:0x04ba, B:704:0x04b0, B:719:0x050b, B:721:0x0515, B:723:0x051b, B:724:0x051e, B:726:0x0529, B:727:0x052d, B:729:0x0538, B:732:0x053f, B:735:0x0548, B:736:0x054d, B:739:0x0552, B:741:0x0557, B:745:0x0560, B:747:0x0568, B:749:0x057d, B:753:0x059c, B:755:0x05a2, B:758:0x05a8, B:760:0x05ae, B:762:0x05b6, B:765:0x05c7, B:768:0x05cf, B:770:0x05d3, B:771:0x05da, B:773:0x05df, B:774:0x05e2, B:776:0x05ea, B:779:0x05f4, B:782:0x05fe, B:783:0x0603, B:784:0x0608, B:785:0x0623, B:750:0x0588, B:751:0x058f, B:786:0x0624, B:788:0x0636, B:791:0x063d, B:794:0x0649, B:795:0x066a, B:461:0x00c0, B:462:0x00de, B:465:0x00e3, B:467:0x00ee, B:469:0x00f2, B:471:0x00f6, B:474:0x00fc, B:481:0x010b, B:483:0x0113, B:486:0x0125, B:487:0x013d, B:488:0x013e, B:489:0x0143, B:500:0x0158, B:501:0x015e, B:503:0x0165, B:505:0x0170, B:512:0x0182, B:515:0x018c, B:516:0x01a4, B:510:0x017d, B:504:0x016a, B:517:0x01a5, B:518:0x01bd, B:524:0x01c7, B:526:0x01cf, B:529:0x01e2, B:530:0x0202, B:531:0x0203, B:532:0x0208, B:533:0x0209, B:535:0x0213, B:796:0x066b, B:797:0x0672, B:798:0x0673, B:799:0x0678, B:800:0x0679, B:801:0x067e), top: B:809:0x0075, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:688:0x046c A[Catch: all -> 0x067f, TryCatch #2 {all -> 0x067f, blocks: (B:446:0x0075, B:448:0x0079, B:451:0x0083, B:454:0x0096, B:458:0x00ac, B:537:0x021d, B:538:0x0223, B:540:0x022e, B:542:0x0236, B:546:0x024c, B:548:0x025a, B:564:0x028e, B:565:0x0294, B:567:0x02a1, B:568:0x02a4, B:570:0x02ae, B:575:0x02bc, B:576:0x02c2, B:578:0x02ca, B:579:0x02cf, B:581:0x02d7, B:582:0x02e1, B:586:0x02ea, B:587:0x02f1, B:588:0x02f2, B:591:0x02fc, B:593:0x0300, B:595:0x0306, B:596:0x0309, B:598:0x030f, B:601:0x0320, B:607:0x033a, B:611:0x0347, B:608:0x033f, B:610:0x0343, B:550:0x0261, B:552:0x0267, B:557:0x0274, B:561:0x027e, B:619:0x0358, B:621:0x035e, B:623:0x0366, B:625:0x0370, B:627:0x0381, B:629:0x038c, B:631:0x0394, B:633:0x0398, B:635:0x039e, B:638:0x03a3, B:640:0x03a7, B:660:0x03f5, B:662:0x03fd, B:665:0x0406, B:666:0x0421, B:642:0x03ac, B:644:0x03b4, B:647:0x03ba, B:648:0x03c7, B:651:0x03d0, B:654:0x03d6, B:657:0x03db, B:658:0x03e8, B:667:0x0422, B:668:0x0440, B:671:0x0446, B:673:0x044a, B:675:0x044e, B:678:0x0454, B:682:0x045c, B:688:0x046c, B:690:0x047b, B:692:0x0486, B:693:0x048e, B:694:0x0491, B:706:0x04bd, B:708:0x04c8, B:712:0x04d5, B:715:0x04e5, B:716:0x0506, B:701:0x04a1, B:703:0x04ab, B:705:0x04ba, B:704:0x04b0, B:719:0x050b, B:721:0x0515, B:723:0x051b, B:724:0x051e, B:726:0x0529, B:727:0x052d, B:729:0x0538, B:732:0x053f, B:735:0x0548, B:736:0x054d, B:739:0x0552, B:741:0x0557, B:745:0x0560, B:747:0x0568, B:749:0x057d, B:753:0x059c, B:755:0x05a2, B:758:0x05a8, B:760:0x05ae, B:762:0x05b6, B:765:0x05c7, B:768:0x05cf, B:770:0x05d3, B:771:0x05da, B:773:0x05df, B:774:0x05e2, B:776:0x05ea, B:779:0x05f4, B:782:0x05fe, B:783:0x0603, B:784:0x0608, B:785:0x0623, B:750:0x0588, B:751:0x058f, B:786:0x0624, B:788:0x0636, B:791:0x063d, B:794:0x0649, B:795:0x066a, B:461:0x00c0, B:462:0x00de, B:465:0x00e3, B:467:0x00ee, B:469:0x00f2, B:471:0x00f6, B:474:0x00fc, B:481:0x010b, B:483:0x0113, B:486:0x0125, B:487:0x013d, B:488:0x013e, B:489:0x0143, B:500:0x0158, B:501:0x015e, B:503:0x0165, B:505:0x0170, B:512:0x0182, B:515:0x018c, B:516:0x01a4, B:510:0x017d, B:504:0x016a, B:517:0x01a5, B:518:0x01bd, B:524:0x01c7, B:526:0x01cf, B:529:0x01e2, B:530:0x0202, B:531:0x0203, B:532:0x0208, B:533:0x0209, B:535:0x0213, B:796:0x066b, B:797:0x0672, B:798:0x0673, B:799:0x0678, B:800:0x0679, B:801:0x067e), top: B:809:0x0075, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:695:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:708:0x04c8 A[Catch: all -> 0x067f, TryCatch #2 {all -> 0x067f, blocks: (B:446:0x0075, B:448:0x0079, B:451:0x0083, B:454:0x0096, B:458:0x00ac, B:537:0x021d, B:538:0x0223, B:540:0x022e, B:542:0x0236, B:546:0x024c, B:548:0x025a, B:564:0x028e, B:565:0x0294, B:567:0x02a1, B:568:0x02a4, B:570:0x02ae, B:575:0x02bc, B:576:0x02c2, B:578:0x02ca, B:579:0x02cf, B:581:0x02d7, B:582:0x02e1, B:586:0x02ea, B:587:0x02f1, B:588:0x02f2, B:591:0x02fc, B:593:0x0300, B:595:0x0306, B:596:0x0309, B:598:0x030f, B:601:0x0320, B:607:0x033a, B:611:0x0347, B:608:0x033f, B:610:0x0343, B:550:0x0261, B:552:0x0267, B:557:0x0274, B:561:0x027e, B:619:0x0358, B:621:0x035e, B:623:0x0366, B:625:0x0370, B:627:0x0381, B:629:0x038c, B:631:0x0394, B:633:0x0398, B:635:0x039e, B:638:0x03a3, B:640:0x03a7, B:660:0x03f5, B:662:0x03fd, B:665:0x0406, B:666:0x0421, B:642:0x03ac, B:644:0x03b4, B:647:0x03ba, B:648:0x03c7, B:651:0x03d0, B:654:0x03d6, B:657:0x03db, B:658:0x03e8, B:667:0x0422, B:668:0x0440, B:671:0x0446, B:673:0x044a, B:675:0x044e, B:678:0x0454, B:682:0x045c, B:688:0x046c, B:690:0x047b, B:692:0x0486, B:693:0x048e, B:694:0x0491, B:706:0x04bd, B:708:0x04c8, B:712:0x04d5, B:715:0x04e5, B:716:0x0506, B:701:0x04a1, B:703:0x04ab, B:705:0x04ba, B:704:0x04b0, B:719:0x050b, B:721:0x0515, B:723:0x051b, B:724:0x051e, B:726:0x0529, B:727:0x052d, B:729:0x0538, B:732:0x053f, B:735:0x0548, B:736:0x054d, B:739:0x0552, B:741:0x0557, B:745:0x0560, B:747:0x0568, B:749:0x057d, B:753:0x059c, B:755:0x05a2, B:758:0x05a8, B:760:0x05ae, B:762:0x05b6, B:765:0x05c7, B:768:0x05cf, B:770:0x05d3, B:771:0x05da, B:773:0x05df, B:774:0x05e2, B:776:0x05ea, B:779:0x05f4, B:782:0x05fe, B:783:0x0603, B:784:0x0608, B:785:0x0623, B:750:0x0588, B:751:0x058f, B:786:0x0624, B:788:0x0636, B:791:0x063d, B:794:0x0649, B:795:0x066a, B:461:0x00c0, B:462:0x00de, B:465:0x00e3, B:467:0x00ee, B:469:0x00f2, B:471:0x00f6, B:474:0x00fc, B:481:0x010b, B:483:0x0113, B:486:0x0125, B:487:0x013d, B:488:0x013e, B:489:0x0143, B:500:0x0158, B:501:0x015e, B:503:0x0165, B:505:0x0170, B:512:0x0182, B:515:0x018c, B:516:0x01a4, B:510:0x017d, B:504:0x016a, B:517:0x01a5, B:518:0x01bd, B:524:0x01c7, B:526:0x01cf, B:529:0x01e2, B:530:0x0202, B:531:0x0203, B:532:0x0208, B:533:0x0209, B:535:0x0213, B:796:0x066b, B:797:0x0672, B:798:0x0673, B:799:0x0678, B:800:0x0679, B:801:0x067e), top: B:809:0x0075, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:765:0x05c7 A[Catch: all -> 0x067f, TryCatch #2 {all -> 0x067f, blocks: (B:446:0x0075, B:448:0x0079, B:451:0x0083, B:454:0x0096, B:458:0x00ac, B:537:0x021d, B:538:0x0223, B:540:0x022e, B:542:0x0236, B:546:0x024c, B:548:0x025a, B:564:0x028e, B:565:0x0294, B:567:0x02a1, B:568:0x02a4, B:570:0x02ae, B:575:0x02bc, B:576:0x02c2, B:578:0x02ca, B:579:0x02cf, B:581:0x02d7, B:582:0x02e1, B:586:0x02ea, B:587:0x02f1, B:588:0x02f2, B:591:0x02fc, B:593:0x0300, B:595:0x0306, B:596:0x0309, B:598:0x030f, B:601:0x0320, B:607:0x033a, B:611:0x0347, B:608:0x033f, B:610:0x0343, B:550:0x0261, B:552:0x0267, B:557:0x0274, B:561:0x027e, B:619:0x0358, B:621:0x035e, B:623:0x0366, B:625:0x0370, B:627:0x0381, B:629:0x038c, B:631:0x0394, B:633:0x0398, B:635:0x039e, B:638:0x03a3, B:640:0x03a7, B:660:0x03f5, B:662:0x03fd, B:665:0x0406, B:666:0x0421, B:642:0x03ac, B:644:0x03b4, B:647:0x03ba, B:648:0x03c7, B:651:0x03d0, B:654:0x03d6, B:657:0x03db, B:658:0x03e8, B:667:0x0422, B:668:0x0440, B:671:0x0446, B:673:0x044a, B:675:0x044e, B:678:0x0454, B:682:0x045c, B:688:0x046c, B:690:0x047b, B:692:0x0486, B:693:0x048e, B:694:0x0491, B:706:0x04bd, B:708:0x04c8, B:712:0x04d5, B:715:0x04e5, B:716:0x0506, B:701:0x04a1, B:703:0x04ab, B:705:0x04ba, B:704:0x04b0, B:719:0x050b, B:721:0x0515, B:723:0x051b, B:724:0x051e, B:726:0x0529, B:727:0x052d, B:729:0x0538, B:732:0x053f, B:735:0x0548, B:736:0x054d, B:739:0x0552, B:741:0x0557, B:745:0x0560, B:747:0x0568, B:749:0x057d, B:753:0x059c, B:755:0x05a2, B:758:0x05a8, B:760:0x05ae, B:762:0x05b6, B:765:0x05c7, B:768:0x05cf, B:770:0x05d3, B:771:0x05da, B:773:0x05df, B:774:0x05e2, B:776:0x05ea, B:779:0x05f4, B:782:0x05fe, B:783:0x0603, B:784:0x0608, B:785:0x0623, B:750:0x0588, B:751:0x058f, B:786:0x0624, B:788:0x0636, B:791:0x063d, B:794:0x0649, B:795:0x066a, B:461:0x00c0, B:462:0x00de, B:465:0x00e3, B:467:0x00ee, B:469:0x00f2, B:471:0x00f6, B:474:0x00fc, B:481:0x010b, B:483:0x0113, B:486:0x0125, B:487:0x013d, B:488:0x013e, B:489:0x0143, B:500:0x0158, B:501:0x015e, B:503:0x0165, B:505:0x0170, B:512:0x0182, B:515:0x018c, B:516:0x01a4, B:510:0x017d, B:504:0x016a, B:517:0x01a5, B:518:0x01bd, B:524:0x01c7, B:526:0x01cf, B:529:0x01e2, B:530:0x0202, B:531:0x0203, B:532:0x0208, B:533:0x0209, B:535:0x0213, B:796:0x066b, B:797:0x0672, B:798:0x0673, B:799:0x0678, B:800:0x0679, B:801:0x067e), top: B:809:0x0075, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:770:0x05d3 A[Catch: all -> 0x067f, TryCatch #2 {all -> 0x067f, blocks: (B:446:0x0075, B:448:0x0079, B:451:0x0083, B:454:0x0096, B:458:0x00ac, B:537:0x021d, B:538:0x0223, B:540:0x022e, B:542:0x0236, B:546:0x024c, B:548:0x025a, B:564:0x028e, B:565:0x0294, B:567:0x02a1, B:568:0x02a4, B:570:0x02ae, B:575:0x02bc, B:576:0x02c2, B:578:0x02ca, B:579:0x02cf, B:581:0x02d7, B:582:0x02e1, B:586:0x02ea, B:587:0x02f1, B:588:0x02f2, B:591:0x02fc, B:593:0x0300, B:595:0x0306, B:596:0x0309, B:598:0x030f, B:601:0x0320, B:607:0x033a, B:611:0x0347, B:608:0x033f, B:610:0x0343, B:550:0x0261, B:552:0x0267, B:557:0x0274, B:561:0x027e, B:619:0x0358, B:621:0x035e, B:623:0x0366, B:625:0x0370, B:627:0x0381, B:629:0x038c, B:631:0x0394, B:633:0x0398, B:635:0x039e, B:638:0x03a3, B:640:0x03a7, B:660:0x03f5, B:662:0x03fd, B:665:0x0406, B:666:0x0421, B:642:0x03ac, B:644:0x03b4, B:647:0x03ba, B:648:0x03c7, B:651:0x03d0, B:654:0x03d6, B:657:0x03db, B:658:0x03e8, B:667:0x0422, B:668:0x0440, B:671:0x0446, B:673:0x044a, B:675:0x044e, B:678:0x0454, B:682:0x045c, B:688:0x046c, B:690:0x047b, B:692:0x0486, B:693:0x048e, B:694:0x0491, B:706:0x04bd, B:708:0x04c8, B:712:0x04d5, B:715:0x04e5, B:716:0x0506, B:701:0x04a1, B:703:0x04ab, B:705:0x04ba, B:704:0x04b0, B:719:0x050b, B:721:0x0515, B:723:0x051b, B:724:0x051e, B:726:0x0529, B:727:0x052d, B:729:0x0538, B:732:0x053f, B:735:0x0548, B:736:0x054d, B:739:0x0552, B:741:0x0557, B:745:0x0560, B:747:0x0568, B:749:0x057d, B:753:0x059c, B:755:0x05a2, B:758:0x05a8, B:760:0x05ae, B:762:0x05b6, B:765:0x05c7, B:768:0x05cf, B:770:0x05d3, B:771:0x05da, B:773:0x05df, B:774:0x05e2, B:776:0x05ea, B:779:0x05f4, B:782:0x05fe, B:783:0x0603, B:784:0x0608, B:785:0x0623, B:750:0x0588, B:751:0x058f, B:786:0x0624, B:788:0x0636, B:791:0x063d, B:794:0x0649, B:795:0x066a, B:461:0x00c0, B:462:0x00de, B:465:0x00e3, B:467:0x00ee, B:469:0x00f2, B:471:0x00f6, B:474:0x00fc, B:481:0x010b, B:483:0x0113, B:486:0x0125, B:487:0x013d, B:488:0x013e, B:489:0x0143, B:500:0x0158, B:501:0x015e, B:503:0x0165, B:505:0x0170, B:512:0x0182, B:515:0x018c, B:516:0x01a4, B:510:0x017d, B:504:0x016a, B:517:0x01a5, B:518:0x01bd, B:524:0x01c7, B:526:0x01cf, B:529:0x01e2, B:530:0x0202, B:531:0x0203, B:532:0x0208, B:533:0x0209, B:535:0x0213, B:796:0x066b, B:797:0x0672, B:798:0x0673, B:799:0x0678, B:800:0x0679, B:801:0x067e), top: B:809:0x0075, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:773:0x05df A[Catch: all -> 0x067f, TryCatch #2 {all -> 0x067f, blocks: (B:446:0x0075, B:448:0x0079, B:451:0x0083, B:454:0x0096, B:458:0x00ac, B:537:0x021d, B:538:0x0223, B:540:0x022e, B:542:0x0236, B:546:0x024c, B:548:0x025a, B:564:0x028e, B:565:0x0294, B:567:0x02a1, B:568:0x02a4, B:570:0x02ae, B:575:0x02bc, B:576:0x02c2, B:578:0x02ca, B:579:0x02cf, B:581:0x02d7, B:582:0x02e1, B:586:0x02ea, B:587:0x02f1, B:588:0x02f2, B:591:0x02fc, B:593:0x0300, B:595:0x0306, B:596:0x0309, B:598:0x030f, B:601:0x0320, B:607:0x033a, B:611:0x0347, B:608:0x033f, B:610:0x0343, B:550:0x0261, B:552:0x0267, B:557:0x0274, B:561:0x027e, B:619:0x0358, B:621:0x035e, B:623:0x0366, B:625:0x0370, B:627:0x0381, B:629:0x038c, B:631:0x0394, B:633:0x0398, B:635:0x039e, B:638:0x03a3, B:640:0x03a7, B:660:0x03f5, B:662:0x03fd, B:665:0x0406, B:666:0x0421, B:642:0x03ac, B:644:0x03b4, B:647:0x03ba, B:648:0x03c7, B:651:0x03d0, B:654:0x03d6, B:657:0x03db, B:658:0x03e8, B:667:0x0422, B:668:0x0440, B:671:0x0446, B:673:0x044a, B:675:0x044e, B:678:0x0454, B:682:0x045c, B:688:0x046c, B:690:0x047b, B:692:0x0486, B:693:0x048e, B:694:0x0491, B:706:0x04bd, B:708:0x04c8, B:712:0x04d5, B:715:0x04e5, B:716:0x0506, B:701:0x04a1, B:703:0x04ab, B:705:0x04ba, B:704:0x04b0, B:719:0x050b, B:721:0x0515, B:723:0x051b, B:724:0x051e, B:726:0x0529, B:727:0x052d, B:729:0x0538, B:732:0x053f, B:735:0x0548, B:736:0x054d, B:739:0x0552, B:741:0x0557, B:745:0x0560, B:747:0x0568, B:749:0x057d, B:753:0x059c, B:755:0x05a2, B:758:0x05a8, B:760:0x05ae, B:762:0x05b6, B:765:0x05c7, B:768:0x05cf, B:770:0x05d3, B:771:0x05da, B:773:0x05df, B:774:0x05e2, B:776:0x05ea, B:779:0x05f4, B:782:0x05fe, B:783:0x0603, B:784:0x0608, B:785:0x0623, B:750:0x0588, B:751:0x058f, B:786:0x0624, B:788:0x0636, B:791:0x063d, B:794:0x0649, B:795:0x066a, B:461:0x00c0, B:462:0x00de, B:465:0x00e3, B:467:0x00ee, B:469:0x00f2, B:471:0x00f6, B:474:0x00fc, B:481:0x010b, B:483:0x0113, B:486:0x0125, B:487:0x013d, B:488:0x013e, B:489:0x0143, B:500:0x0158, B:501:0x015e, B:503:0x0165, B:505:0x0170, B:512:0x0182, B:515:0x018c, B:516:0x01a4, B:510:0x017d, B:504:0x016a, B:517:0x01a5, B:518:0x01bd, B:524:0x01c7, B:526:0x01cf, B:529:0x01e2, B:530:0x0202, B:531:0x0203, B:532:0x0208, B:533:0x0209, B:535:0x0213, B:796:0x066b, B:797:0x0672, B:798:0x0673, B:799:0x0678, B:800:0x0679, B:801:0x067e), top: B:809:0x0075, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:779:0x05f4 A[Catch: all -> 0x067f, TRY_ENTER, TryCatch #2 {all -> 0x067f, blocks: (B:446:0x0075, B:448:0x0079, B:451:0x0083, B:454:0x0096, B:458:0x00ac, B:537:0x021d, B:538:0x0223, B:540:0x022e, B:542:0x0236, B:546:0x024c, B:548:0x025a, B:564:0x028e, B:565:0x0294, B:567:0x02a1, B:568:0x02a4, B:570:0x02ae, B:575:0x02bc, B:576:0x02c2, B:578:0x02ca, B:579:0x02cf, B:581:0x02d7, B:582:0x02e1, B:586:0x02ea, B:587:0x02f1, B:588:0x02f2, B:591:0x02fc, B:593:0x0300, B:595:0x0306, B:596:0x0309, B:598:0x030f, B:601:0x0320, B:607:0x033a, B:611:0x0347, B:608:0x033f, B:610:0x0343, B:550:0x0261, B:552:0x0267, B:557:0x0274, B:561:0x027e, B:619:0x0358, B:621:0x035e, B:623:0x0366, B:625:0x0370, B:627:0x0381, B:629:0x038c, B:631:0x0394, B:633:0x0398, B:635:0x039e, B:638:0x03a3, B:640:0x03a7, B:660:0x03f5, B:662:0x03fd, B:665:0x0406, B:666:0x0421, B:642:0x03ac, B:644:0x03b4, B:647:0x03ba, B:648:0x03c7, B:651:0x03d0, B:654:0x03d6, B:657:0x03db, B:658:0x03e8, B:667:0x0422, B:668:0x0440, B:671:0x0446, B:673:0x044a, B:675:0x044e, B:678:0x0454, B:682:0x045c, B:688:0x046c, B:690:0x047b, B:692:0x0486, B:693:0x048e, B:694:0x0491, B:706:0x04bd, B:708:0x04c8, B:712:0x04d5, B:715:0x04e5, B:716:0x0506, B:701:0x04a1, B:703:0x04ab, B:705:0x04ba, B:704:0x04b0, B:719:0x050b, B:721:0x0515, B:723:0x051b, B:724:0x051e, B:726:0x0529, B:727:0x052d, B:729:0x0538, B:732:0x053f, B:735:0x0548, B:736:0x054d, B:739:0x0552, B:741:0x0557, B:745:0x0560, B:747:0x0568, B:749:0x057d, B:753:0x059c, B:755:0x05a2, B:758:0x05a8, B:760:0x05ae, B:762:0x05b6, B:765:0x05c7, B:768:0x05cf, B:770:0x05d3, B:771:0x05da, B:773:0x05df, B:774:0x05e2, B:776:0x05ea, B:779:0x05f4, B:782:0x05fe, B:783:0x0603, B:784:0x0608, B:785:0x0623, B:750:0x0588, B:751:0x058f, B:786:0x0624, B:788:0x0636, B:791:0x063d, B:794:0x0649, B:795:0x066a, B:461:0x00c0, B:462:0x00de, B:465:0x00e3, B:467:0x00ee, B:469:0x00f2, B:471:0x00f6, B:474:0x00fc, B:481:0x010b, B:483:0x0113, B:486:0x0125, B:487:0x013d, B:488:0x013e, B:489:0x0143, B:500:0x0158, B:501:0x015e, B:503:0x0165, B:505:0x0170, B:512:0x0182, B:515:0x018c, B:516:0x01a4, B:510:0x017d, B:504:0x016a, B:517:0x01a5, B:518:0x01bd, B:524:0x01c7, B:526:0x01cf, B:529:0x01e2, B:530:0x0202, B:531:0x0203, B:532:0x0208, B:533:0x0209, B:535:0x0213, B:796:0x066b, B:797:0x0672, B:798:0x0673, B:799:0x0678, B:800:0x0679, B:801:0x067e), top: B:809:0x0075, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:821:0x018c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:833:0x04d1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:834:0x05ea A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object parseObject(java.util.Map r19, java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 1670
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public void popContext() {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = this.context.parent;
        int i = this.contextArrayIndex;
        if (i <= 0) {
            return;
        }
        int i2 = i - 1;
        this.contextArrayIndex = i2;
        this.contextArray[i2] = null;
    }

    public Object resolveReference(String str) {
        if (this.contextArray == null) {
            return null;
        }
        int i = 0;
        while (true) {
            ParseContext[] parseContextArr = this.contextArray;
            if (i >= parseContextArr.length || i >= this.contextArrayIndex) {
                break;
            }
            ParseContext parseContext = parseContextArr[i];
            if (parseContext.toString().equals(str)) {
                return parseContext.object;
            }
            i++;
        }
        return null;
    }

    public void setConfig(ParserConfig parserConfig) {
        this.config = parserConfig;
    }

    public void setContext(ParseContext parseContext) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = parseContext;
    }

    public void setDateFomrat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public void setFieldTypeResolver(FieldTypeResolver fieldTypeResolver) {
        this.fieldTypeResolver = fieldTypeResolver;
    }

    public void setResolveStatus(int i) {
        this.resolveStatus = i;
    }

    public void throwException(int i) {
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(this.lexer.token()));
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(str, new JSONScanner(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public Object parse(Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token();
        if (i == 2) {
            Number integerValue = jSONLexer.integerValue();
            jSONLexer.nextToken();
            return integerValue;
        } else if (i == 3) {
            Number decimalValue = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
            jSONLexer.nextToken();
            return decimalValue;
        } else if (i == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                JSONScanner jSONScanner = new JSONScanner(stringVal);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch()) {
                        return jSONScanner.getCalendar().getTime();
                    }
                } finally {
                    jSONScanner.close();
                }
            }
            return stringVal;
        } else if (i != 12) {
            if (i == 14) {
                JSONArray jSONArray = new JSONArray();
                parseArray(jSONArray, obj);
                return jSONLexer.isEnabled(Feature.UseObjectArray) ? jSONArray.toArray() : jSONArray;
            } else if (i == 18) {
                if ("NaN".equals(jSONLexer.stringVal())) {
                    jSONLexer.nextToken();
                    return null;
                }
                throw new JSONException("syntax error, " + jSONLexer.info());
            } else if (i != 26) {
                switch (i) {
                    case 6:
                        jSONLexer.nextToken();
                        return Boolean.TRUE;
                    case 7:
                        jSONLexer.nextToken();
                        return Boolean.FALSE;
                    case 8:
                        jSONLexer.nextToken();
                        return null;
                    case 9:
                        jSONLexer.nextToken(18);
                        if (jSONLexer.token() == 18) {
                            jSONLexer.nextToken(10);
                            accept(10);
                            long longValue = jSONLexer.integerValue().longValue();
                            accept(2);
                            accept(11);
                            return new Date(longValue);
                        }
                        throw new JSONException("syntax error");
                    default:
                        switch (i) {
                            case 20:
                                if (jSONLexer.isBlankInput()) {
                                    return null;
                                }
                                throw new JSONException("unterminated json string, " + jSONLexer.info());
                            case 21:
                                jSONLexer.nextToken();
                                HashSet hashSet = new HashSet();
                                parseArray(hashSet, obj);
                                return hashSet;
                            case 22:
                                jSONLexer.nextToken();
                                TreeSet treeSet = new TreeSet();
                                parseArray(treeSet, obj);
                                return treeSet;
                            case 23:
                                jSONLexer.nextToken();
                                return null;
                            default:
                                throw new JSONException("syntax error, " + jSONLexer.info());
                        }
                }
            } else {
                byte[] bytesValue = jSONLexer.bytesValue();
                jSONLexer.nextToken();
                return bytesValue;
            }
        } else {
            return parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), obj);
        }
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i) {
        this(str, new JSONScanner(str, i), parserConfig);
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public ParseContext setContext(Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return setContext(this.context, obj, obj2);
    }

    public DefaultJSONParser(char[] cArr, int i, ParserConfig parserConfig, int i2) {
        this(cArr, new JSONScanner(cArr, i, i2), parserConfig);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.getGlobalInstance());
    }

    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer deserializer;
        int i = this.lexer.token();
        if (i == 21 || i == 22) {
            this.lexer.nextToken();
            i = this.lexer.token();
        }
        if (i == 14) {
            if (Integer.TYPE != type) {
                if (String.class == type) {
                    deserializer = StringCodec.instance;
                    this.lexer.nextToken(4);
                } else {
                    deserializer = this.config.getDeserializer(type);
                    this.lexer.nextToken(deserializer.getFastMatchToken());
                }
            } else {
                deserializer = IntegerCodec.instance;
                this.lexer.nextToken(2);
            }
            ParseContext parseContext = this.context;
            setContext(collection, obj);
            int i2 = 0;
            while (true) {
                try {
                    if (this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (this.lexer.token() == 16) {
                            this.lexer.nextToken();
                        }
                    }
                    if (this.lexer.token() == 15) {
                        setContext(parseContext);
                        this.lexer.nextToken(16);
                        return;
                    }
                    Object obj2 = null;
                    if (Integer.TYPE != type) {
                        if (String.class == type) {
                            if (this.lexer.token() == 4) {
                                obj2 = this.lexer.stringVal();
                                this.lexer.nextToken(16);
                            } else {
                                Object parse = parse();
                                if (parse != null) {
                                    obj2 = parse.toString();
                                }
                            }
                            collection.add(obj2);
                        } else {
                            if (this.lexer.token() == 8) {
                                this.lexer.nextToken();
                            } else {
                                obj2 = deserializer.deserialze(this, type, Integer.valueOf(i2));
                            }
                            collection.add(obj2);
                            checkListResolve(collection);
                        }
                    } else {
                        collection.add(IntegerCodec.instance.deserialze(this, null, null));
                    }
                    if (this.lexer.token() == 16) {
                        this.lexer.nextToken(deserializer.getFastMatchToken());
                    }
                    i2++;
                } catch (Throwable th) {
                    setContext(parseContext);
                    throw th;
                }
            }
        } else {
            throw new JSONException("expect '[', but " + JSONToken.name(i) + ", " + this.lexer.info());
        }
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        ParseContext parseContext2 = new ParseContext(parseContext, obj, obj2);
        this.context = parseContext2;
        addContext(parseContext2);
        return this.context;
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this((Object) null, jSONLexer, parserConfig);
    }

    public final void accept(int i, int i2) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken(i2);
        } else {
            throwException(i);
        }
    }

    public DefaultJSONParser(Object obj, JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.objectKeyLevel = 0;
        this.autoTypeAccept = null;
        this.lexer = jSONLexer;
        this.input = obj;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char current = jSONLexer.getCurrent();
        if (current == '{') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 12;
        } else if (current == '[') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 14;
        } else {
            jSONLexer.nextToken();
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        Object cast;
        Class<?> cls;
        boolean z;
        Class cls2;
        int i = 8;
        if (this.lexer.token() == 8) {
            this.lexer.nextToken(16);
            return null;
        }
        int i2 = 14;
        if (this.lexer.token() == 14) {
            Object[] objArr = new Object[typeArr.length];
            if (typeArr.length == 0) {
                this.lexer.nextToken(15);
                if (this.lexer.token() == 15) {
                    this.lexer.nextToken(16);
                    return new Object[0];
                }
                throw new JSONException("syntax error");
            }
            this.lexer.nextToken(2);
            int i3 = 0;
            while (i3 < typeArr.length) {
                if (this.lexer.token() == i) {
                    this.lexer.nextToken(16);
                    cast = null;
                } else {
                    Type type = typeArr[i3];
                    if (type != Integer.TYPE && type != Integer.class) {
                        if (type == String.class) {
                            if (this.lexer.token() == 4) {
                                cast = this.lexer.stringVal();
                                this.lexer.nextToken(16);
                            } else {
                                cast = TypeUtils.cast(parse(), type, this.config);
                            }
                        } else {
                            if (i3 == typeArr.length - 1 && (type instanceof Class) && (((cls2 = (Class) type) != byte[].class && cls2 != char[].class) || this.lexer.token() != 4)) {
                                z = cls2.isArray();
                                cls = cls2.getComponentType();
                            } else {
                                cls = null;
                                z = false;
                            }
                            if (z && this.lexer.token() != i2) {
                                ArrayList arrayList = new ArrayList();
                                ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                                int fastMatchToken = deserializer.getFastMatchToken();
                                if (this.lexer.token() != 15) {
                                    while (true) {
                                        arrayList.add(deserializer.deserialze(this, type, null));
                                        if (this.lexer.token() != 16) {
                                            break;
                                        }
                                        this.lexer.nextToken(fastMatchToken);
                                    }
                                    if (this.lexer.token() != 15) {
                                        throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                                    }
                                }
                                cast = TypeUtils.cast(arrayList, type, this.config);
                            } else {
                                cast = this.config.getDeserializer(type).deserialze(this, type, Integer.valueOf(i3));
                            }
                        }
                    } else if (this.lexer.token() == 2) {
                        cast = Integer.valueOf(this.lexer.intValue());
                        this.lexer.nextToken(16);
                    } else {
                        cast = TypeUtils.cast(parse(), type, this.config);
                    }
                }
                objArr[i3] = cast;
                if (this.lexer.token() == 15) {
                    break;
                } else if (this.lexer.token() == 16) {
                    if (i3 == typeArr.length - 1) {
                        this.lexer.nextToken(15);
                    } else {
                        this.lexer.nextToken(2);
                    }
                    i3++;
                    i = 8;
                    i2 = 14;
                } else {
                    throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                }
            }
            if (this.lexer.token() == 15) {
                this.lexer.nextToken(16);
                return objArr;
            }
            throw new JSONException("syntax error");
        }
        throw new JSONException("syntax error : " + this.lexer.tokenName());
    }

    /* JADX WARN: Code restructure failed: missing block: B:196:0x0238, code lost:
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object parse(com.alibaba.fastjson.parser.deserializer.PropertyProcessable r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 617
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parse(com.alibaba.fastjson.parser.deserializer.PropertyProcessable, java.lang.Object):java.lang.Object");
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    public final void parseArray(Collection collection, Object obj) {
        Number decimalValue;
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 21 || jSONLexer.token() == 22) {
            jSONLexer.nextToken();
        }
        if (jSONLexer.token() == 14) {
            jSONLexer.nextToken(4);
            ParseContext parseContext = this.context;
            if (parseContext != null && parseContext.level > 512) {
                throw new JSONException("array level > 512");
            }
            setContext(collection, obj);
            int i = 0;
            while (true) {
                try {
                    if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (jSONLexer.token() == 16) {
                            jSONLexer.nextToken();
                        }
                    }
                    int i2 = jSONLexer.token();
                    Number number = null;
                    number = null;
                    if (i2 == 2) {
                        Number integerValue = jSONLexer.integerValue();
                        jSONLexer.nextToken(16);
                        number = integerValue;
                    } else if (i2 == 3) {
                        if (jSONLexer.isEnabled(Feature.UseBigDecimal)) {
                            decimalValue = jSONLexer.decimalValue(true);
                        } else {
                            decimalValue = jSONLexer.decimalValue(false);
                        }
                        number = decimalValue;
                        jSONLexer.nextToken(16);
                    } else if (i2 == 4) {
                        String stringVal = jSONLexer.stringVal();
                        jSONLexer.nextToken(16);
                        number = stringVal;
                        if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                            JSONScanner jSONScanner = new JSONScanner(stringVal);
                            Date date = stringVal;
                            if (jSONScanner.scanISO8601DateIfMatch()) {
                                date = jSONScanner.getCalendar().getTime();
                            }
                            jSONScanner.close();
                            number = date;
                        }
                    } else if (i2 == 6) {
                        Boolean bool = Boolean.TRUE;
                        jSONLexer.nextToken(16);
                        number = bool;
                    } else if (i2 == 7) {
                        Boolean bool2 = Boolean.FALSE;
                        jSONLexer.nextToken(16);
                        number = bool2;
                    } else if (i2 == 8) {
                        jSONLexer.nextToken(4);
                    } else if (i2 == 12) {
                        number = parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), Integer.valueOf(i));
                    } else if (i2 == 20) {
                        throw new JSONException("unclosed jsonArray");
                    } else {
                        if (i2 == 23) {
                            jSONLexer.nextToken(4);
                        } else if (i2 == 14) {
                            JSONArray jSONArray = new JSONArray();
                            parseArray(jSONArray, Integer.valueOf(i));
                            number = jSONArray;
                            if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                                number = jSONArray.toArray();
                            }
                        } else if (i2 != 15) {
                            number = parse();
                        } else {
                            jSONLexer.nextToken(16);
                            return;
                        }
                    }
                    collection.add(number);
                    checkListResolve(collection);
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(4);
                    }
                    i++;
                } finally {
                    setContext(parseContext);
                }
            }
        } else {
            throw new JSONException("syntax error, expect [, actual " + JSONToken.name(jSONLexer.token()) + ", pos " + jSONLexer.pos() + ", fieldName " + obj);
        }
    }

    public <T> T parseObject(Class<T> cls) {
        return (T) parseObject(cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return (T) parseObject(type, (Object) null);
    }

    public <T> T parseObject(Type type, Object obj) {
        int i = this.lexer.token();
        if (i == 8) {
            this.lexer.nextToken();
            return null;
        }
        if (i == 4) {
            if (type == byte[].class) {
                T t = (T) this.lexer.bytesValue();
                this.lexer.nextToken();
                return t;
            } else if (type == char[].class) {
                String stringVal = this.lexer.stringVal();
                this.lexer.nextToken();
                return (T) stringVal.toCharArray();
            }
        }
        ObjectDeserializer deserializer = this.config.getDeserializer(type);
        try {
            if (deserializer.getClass() == JavaBeanDeserializer.class) {
                if (this.lexer.token() != 12 && this.lexer.token() != 14) {
                    throw new JSONException("syntax error,except start with { or [,but actually start with " + this.lexer.tokenName());
                }
                return (T) ((JavaBeanDeserializer) deserializer).deserialze(this, type, obj, 0);
            }
            return (T) deserializer.deserialze(this, type, obj);
        } catch (JSONException e) {
            throw e;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    public void parseObject(Object obj) {
        Object deserialze;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (this.lexer.token() != 12 && this.lexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + this.lexer.tokenName());
        }
        while (true) {
            String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
            if (scanSymbol == null) {
                if (this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                } else if (this.lexer.token() == 16 && this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                }
            }
            FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(scanSymbol) : null;
            if (fieldDeserializer == null) {
                if (this.lexer.isEnabled(Feature.IgnoreNotMatch)) {
                    this.lexer.nextTokenWithColon();
                    parse();
                    if (this.lexer.token() == 13) {
                        this.lexer.nextToken();
                        return;
                    }
                } else {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + scanSymbol);
                }
            } else {
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                Class<?> cls2 = fieldInfo.fieldClass;
                Type type = fieldInfo.fieldType;
                if (cls2 == Integer.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    deserialze = IntegerCodec.instance.deserialze(this, type, null);
                } else if (cls2 == String.class) {
                    this.lexer.nextTokenWithColon(4);
                    deserialze = StringCodec.deserialze(this);
                } else if (cls2 == Long.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    deserialze = LongCodec.instance.deserialze(this, type, null);
                } else {
                    ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                    this.lexer.nextTokenWithColon(deserializer2.getFastMatchToken());
                    deserialze = deserializer2.deserialze(this, type, null);
                }
                fieldDeserializer.setValue(obj, deserialze);
                if (this.lexer.token() != 16 && this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                }
            }
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    public JSONObject parseObject() {
        Object parseObject = parseObject((Map) new JSONObject(this.lexer.isEnabled(Feature.OrderedField)));
        if (parseObject instanceof JSONObject) {
            return (JSONObject) parseObject;
        }
        if (parseObject == null) {
            return null;
        }
        return new JSONObject((Map) parseObject);
    }
}
