package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
    public SerializeBeanInfo beanInfo;
    public final FieldSerializer[] getters;
    private volatile transient long[] hashArray;
    private volatile transient short[] hashArrayMapping;
    public final FieldSerializer[] sortedGetters;

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (Map<String, String>) null);
    }

    public static Map<String, String> createAliasMap(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public boolean applyLabel(JSONSerializer jSONSerializer, String str) {
        List<LabelFilter> list = jSONSerializer.labelFilters;
        if (list != null) {
            for (LabelFilter labelFilter : list) {
                if (!labelFilter.apply(str)) {
                    return false;
                }
            }
        }
        List<LabelFilter> list2 = this.labelFilters;
        if (list2 != null) {
            for (LabelFilter labelFilter2 : list2) {
                if (!labelFilter2.apply(str)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public BeanContext getBeanContext(int i) {
        return this.sortedGetters[i].fieldContext;
    }

    public Set<String> getFieldNames(Object obj) throws Exception {
        FieldSerializer[] fieldSerializerArr;
        HashSet hashSet = new HashSet();
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                hashSet.add(fieldSerializer.fieldInfo.name);
            }
        }
        return hashSet;
    }

    public FieldSerializer getFieldSerializer(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        int length = this.sortedGetters.length - 1;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = this.sortedGetters[i2].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else if (compareTo <= 0) {
                return this.sortedGetters[i2];
            } else {
                length = i2 - 1;
            }
        }
        return null;
    }

    public Type getFieldType(int i) {
        return this.sortedGetters[i].fieldInfo.fieldType;
    }

    public Object getFieldValue(Object obj, String str) {
        FieldSerializer fieldSerializer = getFieldSerializer(str);
        if (fieldSerializer != null) {
            try {
                return fieldSerializer.getPropertyValue(obj);
            } catch (IllegalAccessException e) {
                throw new JSONException("getFieldValue error." + str, e);
            } catch (InvocationTargetException e2) {
                throw new JSONException("getFieldValue error." + str, e2);
            }
        }
        throw new JSONException("field not found. " + str);
    }

    public List<Object> getFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            arrayList.add(fieldSerializer.getPropertyValue(obj));
        }
        return arrayList;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        FieldSerializer[] fieldSerializerArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            boolean isEnabled = SerializerFeature.isEnabled(fieldSerializer.features, SerializerFeature.SkipTransientField);
            FieldInfo fieldInfo = fieldSerializer.fieldInfo;
            if (!isEnabled || fieldInfo == null || !fieldInfo.fieldTransient) {
                if (fieldInfo.unwrapped) {
                    Object json = JSON.toJSON(fieldSerializer.getPropertyValue(obj));
                    if (json instanceof Map) {
                        linkedHashMap.putAll((Map) json);
                    } else {
                        linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
                    }
                } else {
                    linkedHashMap.put(fieldInfo.name, fieldSerializer.getPropertyValue(obj));
                }
            }
        }
        return linkedHashMap;
    }

    public List<Object> getObjectFieldValues(Object obj) throws Exception {
        FieldSerializer[] fieldSerializerArr;
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            Class<?> cls = fieldSerializer.fieldInfo.fieldClass;
            if (!cls.isPrimitive() && !cls.getName().startsWith("java.lang.")) {
                arrayList.add(fieldSerializer.getPropertyValue(obj));
            }
        }
        return arrayList;
    }

    public int getSize(Object obj) throws Exception {
        int i = 0;
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                i++;
            }
        }
        return i;
    }

    public Class<?> getType() {
        return this.beanInfo.beanType;
    }

    public boolean isWriteAsArray(JSONSerializer jSONSerializer) {
        return isWriteAsArray(jSONSerializer, 0);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    public char writeAfter(JSONSerializer jSONSerializer, Object obj, char c) {
        List<AfterFilter> list = jSONSerializer.afterFilters;
        if (list != null) {
            for (AfterFilter afterFilter : list) {
                c = afterFilter.writeAfter(jSONSerializer, obj, c);
            }
        }
        List<AfterFilter> list2 = this.afterFilters;
        if (list2 != null) {
            for (AfterFilter afterFilter2 : list2) {
                c = afterFilter2.writeAfter(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    public void writeAsArray(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArrayNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public char writeBefore(JSONSerializer jSONSerializer, Object obj, char c) {
        List<BeforeFilter> list = jSONSerializer.beforeFilters;
        if (list != null) {
            for (BeforeFilter beforeFilter : list) {
                c = beforeFilter.writeBefore(jSONSerializer, obj, c);
            }
        }
        List<BeforeFilter> list2 = this.beforeFilters;
        if (list2 != null) {
            for (BeforeFilter beforeFilter2 : list2) {
                c = beforeFilter2.writeBefore(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    public void writeClassName(JSONSerializer jSONSerializer, String str, Object obj) {
        if (str == null) {
            str = jSONSerializer.config.typeKey;
        }
        jSONSerializer.out.writeFieldName(str, false);
        String str2 = this.beanInfo.typeName;
        if (str2 == null) {
            Class<?> cls = obj.getClass();
            if (TypeUtils.isProxy(cls)) {
                cls = cls.getSuperclass();
            }
            str2 = cls.getName();
        }
        jSONSerializer.write(str2);
    }

    public void writeDirectNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeNoneASM(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    public boolean writeReference(JSONSerializer jSONSerializer, Object obj, int i) {
        IdentityHashMap<Object, SerialContext> identityHashMap;
        SerialContext serialContext = jSONSerializer.context;
        int i2 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (serialContext != null && (serialContext.features & i2) == 0 && (i & i2) == 0 && (identityHashMap = jSONSerializer.references) != null && identityHashMap.containsKey(obj)) {
            jSONSerializer.writeReference(obj);
            return true;
        }
        return false;
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, createAliasMap(strArr));
    }

    public boolean isWriteAsArray(JSONSerializer jSONSerializer, int i) {
        int i2 = SerializerFeature.BeanToArray.mask;
        return ((this.beanInfo.features & i2) == 0 && !jSONSerializer.out.beanToArray && (i & i2) == 0) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:518:0x00f9, code lost:
        if (r11.fieldTransient != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:653:0x02ba, code lost:
        if ((r33.beanInfo.features & r4) == 0) goto L265;
     */
    /* JADX WARN: Code restructure failed: missing block: B:793:0x046a, code lost:
        if (r0 == false) goto L287;
     */
    /* JADX WARN: Removed duplicated region for block: B:498:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:499:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:552:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:554:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:746:0x03cd A[Catch: Exception -> 0x0478, all -> 0x0497, TryCatch #2 {Exception -> 0x0478, blocks: (B:550:0x0152, B:562:0x017e, B:565:0x01a6, B:567:0x01b2, B:569:0x01bd, B:571:0x01c7, B:574:0x01d1, B:576:0x01dd, B:578:0x01e1, B:581:0x01e8, B:583:0x01ec, B:584:0x01f0, B:586:0x01f5, B:588:0x01f8, B:590:0x01fe, B:592:0x020a, B:594:0x020e, B:597:0x0215, B:600:0x021c, B:602:0x0221, B:605:0x0225, B:607:0x022d, B:609:0x0239, B:611:0x023d, B:614:0x0244, B:616:0x0248, B:617:0x024d, B:619:0x0252, B:621:0x0255, B:622:0x025a, B:624:0x0262, B:626:0x026e, B:628:0x0272, B:631:0x0279, B:633:0x027d, B:634:0x0282, B:636:0x0287, B:638:0x028a, B:640:0x0291, B:642:0x0295, B:644:0x029f, B:648:0x02a8, B:650:0x02ac, B:652:0x02b5, B:654:0x02bc, B:656:0x02c2, B:658:0x02c6, B:661:0x02d1, B:663:0x02d5, B:665:0x02d9, B:668:0x02e4, B:670:0x02e8, B:672:0x02ec, B:675:0x02f7, B:677:0x02fb, B:679:0x02ff, B:682:0x030d, B:684:0x0311, B:686:0x0315, B:689:0x0322, B:691:0x0326, B:693:0x032a, B:696:0x0338, B:698:0x033c, B:700:0x0340, B:704:0x034c, B:706:0x0350, B:708:0x0354, B:711:0x035f, B:713:0x036c, B:718:0x0378, B:720:0x037e, B:777:0x0439, B:779:0x043d, B:781:0x0441, B:784:0x044b, B:786:0x0453, B:787:0x045b, B:789:0x0461, B:725:0x0389, B:726:0x038c, B:728:0x0392, B:730:0x039e, B:737:0x03b3, B:742:0x03bd, B:746:0x03cd, B:749:0x03d5, B:752:0x03df, B:754:0x03e7, B:755:0x03f0, B:757:0x03f9, B:759:0x0400, B:760:0x0404, B:762:0x0407, B:763:0x040b, B:764:0x040f, B:766:0x0414, B:767:0x0418, B:768:0x041c, B:770:0x0420, B:772:0x0424, B:775:0x0432, B:776:0x0436, B:743:0x03c5), top: B:870:0x0152 }] */
    /* JADX WARN: Removed duplicated region for block: B:776:0x0436 A[Catch: Exception -> 0x0478, all -> 0x0497, TryCatch #2 {Exception -> 0x0478, blocks: (B:550:0x0152, B:562:0x017e, B:565:0x01a6, B:567:0x01b2, B:569:0x01bd, B:571:0x01c7, B:574:0x01d1, B:576:0x01dd, B:578:0x01e1, B:581:0x01e8, B:583:0x01ec, B:584:0x01f0, B:586:0x01f5, B:588:0x01f8, B:590:0x01fe, B:592:0x020a, B:594:0x020e, B:597:0x0215, B:600:0x021c, B:602:0x0221, B:605:0x0225, B:607:0x022d, B:609:0x0239, B:611:0x023d, B:614:0x0244, B:616:0x0248, B:617:0x024d, B:619:0x0252, B:621:0x0255, B:622:0x025a, B:624:0x0262, B:626:0x026e, B:628:0x0272, B:631:0x0279, B:633:0x027d, B:634:0x0282, B:636:0x0287, B:638:0x028a, B:640:0x0291, B:642:0x0295, B:644:0x029f, B:648:0x02a8, B:650:0x02ac, B:652:0x02b5, B:654:0x02bc, B:656:0x02c2, B:658:0x02c6, B:661:0x02d1, B:663:0x02d5, B:665:0x02d9, B:668:0x02e4, B:670:0x02e8, B:672:0x02ec, B:675:0x02f7, B:677:0x02fb, B:679:0x02ff, B:682:0x030d, B:684:0x0311, B:686:0x0315, B:689:0x0322, B:691:0x0326, B:693:0x032a, B:696:0x0338, B:698:0x033c, B:700:0x0340, B:704:0x034c, B:706:0x0350, B:708:0x0354, B:711:0x035f, B:713:0x036c, B:718:0x0378, B:720:0x037e, B:777:0x0439, B:779:0x043d, B:781:0x0441, B:784:0x044b, B:786:0x0453, B:787:0x045b, B:789:0x0461, B:725:0x0389, B:726:0x038c, B:728:0x0392, B:730:0x039e, B:737:0x03b3, B:742:0x03bd, B:746:0x03cd, B:749:0x03d5, B:752:0x03df, B:754:0x03e7, B:755:0x03f0, B:757:0x03f9, B:759:0x0400, B:760:0x0404, B:762:0x0407, B:763:0x040b, B:764:0x040f, B:766:0x0414, B:767:0x0418, B:768:0x041c, B:770:0x0420, B:772:0x0424, B:775:0x0432, B:776:0x0436, B:743:0x03c5), top: B:870:0x0152 }] */
    /* JADX WARN: Removed duplicated region for block: B:779:0x043d A[Catch: Exception -> 0x0478, all -> 0x0497, TryCatch #2 {Exception -> 0x0478, blocks: (B:550:0x0152, B:562:0x017e, B:565:0x01a6, B:567:0x01b2, B:569:0x01bd, B:571:0x01c7, B:574:0x01d1, B:576:0x01dd, B:578:0x01e1, B:581:0x01e8, B:583:0x01ec, B:584:0x01f0, B:586:0x01f5, B:588:0x01f8, B:590:0x01fe, B:592:0x020a, B:594:0x020e, B:597:0x0215, B:600:0x021c, B:602:0x0221, B:605:0x0225, B:607:0x022d, B:609:0x0239, B:611:0x023d, B:614:0x0244, B:616:0x0248, B:617:0x024d, B:619:0x0252, B:621:0x0255, B:622:0x025a, B:624:0x0262, B:626:0x026e, B:628:0x0272, B:631:0x0279, B:633:0x027d, B:634:0x0282, B:636:0x0287, B:638:0x028a, B:640:0x0291, B:642:0x0295, B:644:0x029f, B:648:0x02a8, B:650:0x02ac, B:652:0x02b5, B:654:0x02bc, B:656:0x02c2, B:658:0x02c6, B:661:0x02d1, B:663:0x02d5, B:665:0x02d9, B:668:0x02e4, B:670:0x02e8, B:672:0x02ec, B:675:0x02f7, B:677:0x02fb, B:679:0x02ff, B:682:0x030d, B:684:0x0311, B:686:0x0315, B:689:0x0322, B:691:0x0326, B:693:0x032a, B:696:0x0338, B:698:0x033c, B:700:0x0340, B:704:0x034c, B:706:0x0350, B:708:0x0354, B:711:0x035f, B:713:0x036c, B:718:0x0378, B:720:0x037e, B:777:0x0439, B:779:0x043d, B:781:0x0441, B:784:0x044b, B:786:0x0453, B:787:0x045b, B:789:0x0461, B:725:0x0389, B:726:0x038c, B:728:0x0392, B:730:0x039e, B:737:0x03b3, B:742:0x03bd, B:746:0x03cd, B:749:0x03d5, B:752:0x03df, B:754:0x03e7, B:755:0x03f0, B:757:0x03f9, B:759:0x0400, B:760:0x0404, B:762:0x0407, B:763:0x040b, B:764:0x040f, B:766:0x0414, B:767:0x0418, B:768:0x041c, B:770:0x0420, B:772:0x0424, B:775:0x0432, B:776:0x0436, B:743:0x03c5), top: B:870:0x0152 }] */
    /* JADX WARN: Removed duplicated region for block: B:784:0x044b A[Catch: Exception -> 0x0478, all -> 0x0497, TryCatch #2 {Exception -> 0x0478, blocks: (B:550:0x0152, B:562:0x017e, B:565:0x01a6, B:567:0x01b2, B:569:0x01bd, B:571:0x01c7, B:574:0x01d1, B:576:0x01dd, B:578:0x01e1, B:581:0x01e8, B:583:0x01ec, B:584:0x01f0, B:586:0x01f5, B:588:0x01f8, B:590:0x01fe, B:592:0x020a, B:594:0x020e, B:597:0x0215, B:600:0x021c, B:602:0x0221, B:605:0x0225, B:607:0x022d, B:609:0x0239, B:611:0x023d, B:614:0x0244, B:616:0x0248, B:617:0x024d, B:619:0x0252, B:621:0x0255, B:622:0x025a, B:624:0x0262, B:626:0x026e, B:628:0x0272, B:631:0x0279, B:633:0x027d, B:634:0x0282, B:636:0x0287, B:638:0x028a, B:640:0x0291, B:642:0x0295, B:644:0x029f, B:648:0x02a8, B:650:0x02ac, B:652:0x02b5, B:654:0x02bc, B:656:0x02c2, B:658:0x02c6, B:661:0x02d1, B:663:0x02d5, B:665:0x02d9, B:668:0x02e4, B:670:0x02e8, B:672:0x02ec, B:675:0x02f7, B:677:0x02fb, B:679:0x02ff, B:682:0x030d, B:684:0x0311, B:686:0x0315, B:689:0x0322, B:691:0x0326, B:693:0x032a, B:696:0x0338, B:698:0x033c, B:700:0x0340, B:704:0x034c, B:706:0x0350, B:708:0x0354, B:711:0x035f, B:713:0x036c, B:718:0x0378, B:720:0x037e, B:777:0x0439, B:779:0x043d, B:781:0x0441, B:784:0x044b, B:786:0x0453, B:787:0x045b, B:789:0x0461, B:725:0x0389, B:726:0x038c, B:728:0x0392, B:730:0x039e, B:737:0x03b3, B:742:0x03bd, B:746:0x03cd, B:749:0x03d5, B:752:0x03df, B:754:0x03e7, B:755:0x03f0, B:757:0x03f9, B:759:0x0400, B:760:0x0404, B:762:0x0407, B:763:0x040b, B:764:0x040f, B:766:0x0414, B:767:0x0418, B:768:0x041c, B:770:0x0420, B:772:0x0424, B:775:0x0432, B:776:0x0436, B:743:0x03c5), top: B:870:0x0152 }] */
    /* JADX WARN: Removed duplicated region for block: B:797:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:815:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:816:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:823:0x04cd A[Catch: all -> 0x0497, Exception -> 0x04d7, TRY_LEAVE, TryCatch #3 {Exception -> 0x04d7, blocks: (B:817:0x04b5, B:819:0x04bd, B:821:0x04c5, B:823:0x04cd), top: B:872:0x04b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:840:0x050e A[Catch: all -> 0x0521, TRY_ENTER, TryCatch #0 {all -> 0x0521, blocks: (B:840:0x050e, B:850:0x055e, B:852:0x0564, B:853:0x057c, B:855:0x0580, B:859:0x0589, B:860:0x058e, B:844:0x0525, B:846:0x0529, B:848:0x052d, B:849:0x0548), top: B:866:0x050c }] */
    /* JADX WARN: Removed duplicated region for block: B:843:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:852:0x0564 A[Catch: all -> 0x0521, TryCatch #0 {all -> 0x0521, blocks: (B:840:0x050e, B:850:0x055e, B:852:0x0564, B:853:0x057c, B:855:0x0580, B:859:0x0589, B:860:0x058e, B:844:0x0525, B:846:0x0529, B:848:0x052d, B:849:0x0548), top: B:866:0x050c }] */
    /* JADX WARN: Removed duplicated region for block: B:855:0x0580 A[Catch: all -> 0x0521, TryCatch #0 {all -> 0x0521, blocks: (B:840:0x050e, B:850:0x055e, B:852:0x0564, B:853:0x057c, B:855:0x0580, B:859:0x0589, B:860:0x058e, B:844:0x0525, B:846:0x0529, B:848:0x052d, B:849:0x0548), top: B:866:0x050c }] */
    /* JADX WARN: Removed duplicated region for block: B:857:0x0586  */
    /* JADX WARN: Removed duplicated region for block: B:858:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:874:0x04eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:887:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r34, java.lang.Object r35, java.lang.Object r36, java.lang.reflect.Type r37, int r38, boolean r39) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }

    public JavaBeanSerializer(Class<?> cls, Map<String, String> map) {
        this(TypeUtils.buildBeanInfo(cls, map, null));
    }

    public JavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        FieldSerializer[] fieldSerializerArr;
        boolean z;
        this.beanInfo = serializeBeanInfo;
        this.sortedGetters = new FieldSerializer[serializeBeanInfo.sortedFields.length];
        int i = 0;
        while (true) {
            fieldSerializerArr = this.sortedGetters;
            if (i >= fieldSerializerArr.length) {
                break;
            }
            fieldSerializerArr[i] = new FieldSerializer(serializeBeanInfo.beanType, serializeBeanInfo.sortedFields[i]);
            i++;
        }
        FieldInfo[] fieldInfoArr = serializeBeanInfo.fields;
        if (fieldInfoArr == serializeBeanInfo.sortedFields) {
            this.getters = fieldSerializerArr;
        } else {
            this.getters = new FieldSerializer[fieldInfoArr.length];
            int i2 = 0;
            while (true) {
                if (i2 >= this.getters.length) {
                    z = false;
                    break;
                }
                FieldSerializer fieldSerializer = getFieldSerializer(serializeBeanInfo.fields[i2].name);
                if (fieldSerializer == null) {
                    z = true;
                    break;
                } else {
                    this.getters[i2] = fieldSerializer;
                    i2++;
                }
            }
            if (z) {
                FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                System.arraycopy(fieldSerializerArr2, 0, this.getters, 0, fieldSerializerArr2.length);
            }
        }
        JSONType jSONType = serializeBeanInfo.jsonType;
        if (jSONType != null) {
            for (Class<? extends SerializeFilter> cls : jSONType.serialzeFilters()) {
                try {
                    addFilter(cls.getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                }
            }
        }
    }

    public FieldSerializer getFieldSerializer(long j) {
        PropertyNamingStrategy[] propertyNamingStrategyArr;
        int binarySearch;
        if (this.hashArray == null) {
            propertyNamingStrategyArr = PropertyNamingStrategy.values();
            long[] jArr = new long[this.sortedGetters.length * propertyNamingStrategyArr.length];
            int i = 0;
            int i2 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr = this.sortedGetters;
                if (i >= fieldSerializerArr.length) {
                    break;
                }
                String str = fieldSerializerArr[i].fieldInfo.name;
                jArr[i2] = TypeUtils.fnv1a_64(str);
                i2++;
                for (PropertyNamingStrategy propertyNamingStrategy : propertyNamingStrategyArr) {
                    String translate = propertyNamingStrategy.translate(str);
                    if (!str.equals(translate)) {
                        jArr[i2] = TypeUtils.fnv1a_64(translate);
                        i2++;
                    }
                }
                i++;
            }
            Arrays.sort(jArr, 0, i2);
            this.hashArray = new long[i2];
            System.arraycopy(jArr, 0, this.hashArray, 0, i2);
        } else {
            propertyNamingStrategyArr = null;
        }
        int binarySearch2 = Arrays.binarySearch(this.hashArray, j);
        if (binarySearch2 < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            if (propertyNamingStrategyArr == null) {
                propertyNamingStrategyArr = PropertyNamingStrategy.values();
            }
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, (short) -1);
            int i3 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                if (i3 >= fieldSerializerArr2.length) {
                    break;
                }
                String str2 = fieldSerializerArr2[i3].fieldInfo.name;
                int binarySearch3 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(str2));
                if (binarySearch3 >= 0) {
                    sArr[binarySearch3] = (short) i3;
                }
                for (PropertyNamingStrategy propertyNamingStrategy2 : propertyNamingStrategyArr) {
                    String translate2 = propertyNamingStrategy2.translate(str2);
                    if (!str2.equals(translate2) && (binarySearch = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(translate2))) >= 0) {
                        sArr[binarySearch] = (short) i3;
                    }
                }
                i3++;
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[binarySearch2];
        if (s != -1) {
            return this.sortedGetters[s];
        }
        return null;
    }

    public Object getFieldValue(Object obj, String str, long j, boolean z) {
        FieldSerializer fieldSerializer = getFieldSerializer(j);
        if (fieldSerializer == null) {
            if (z) {
                throw new JSONException("field not found. " + str);
            }
            return null;
        }
        try {
            return fieldSerializer.getPropertyValue(obj);
        } catch (IllegalAccessException e) {
            throw new JSONException("getFieldValue error." + str, e);
        } catch (InvocationTargetException e2) {
            throw new JSONException("getFieldValue error." + str, e2);
        }
    }
}
