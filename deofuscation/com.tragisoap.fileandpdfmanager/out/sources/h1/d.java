package h1;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Base64;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import m1.f;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {
        public static int a(TypedArray typedArray, int i7) {
            return typedArray.getType(i7);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface b {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class c implements b {

        /* renamed from: a  reason: collision with root package name */
        public final C0063d[] f4342a;

        public c(C0063d[] dVarArr) {
            this.f4342a = dVarArr;
        }
    }

    /* renamed from: h1.d$d  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class C0063d {

        /* renamed from: a  reason: collision with root package name */
        public final int f4343a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f4344b;

        /* renamed from: c  reason: collision with root package name */
        public final String f4345c;

        /* renamed from: d  reason: collision with root package name */
        public final int f4346d;
        public final int e;

        public C0063d(int i7, int i8, int i9, String str, String str2, boolean z6) {
            this.f4343a = i7;
            this.f4344b = z6;
            this.f4345c = str2;
            this.f4346d = i8;
            this.e = i9;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class e implements b {

        /* renamed from: a  reason: collision with root package name */
        public final f f4347a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4348b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4349c;

        /* renamed from: d  reason: collision with root package name */
        public final String f4350d;

        public e(f fVar, int i7, int i8, String str) {
            this.f4347a = fVar;
            this.f4349c = i7;
            this.f4348b = i8;
            this.f4350d = str;
        }
    }

    public static b a(XmlResourceParser xmlResourceParser, Resources resources) {
        int next;
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            xmlResourceParser.require(2, null, "font-family");
            if (xmlResourceParser.getName().equals("font-family")) {
                TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), a0.b.f21v);
                String string = obtainAttributes.getString(0);
                String string2 = obtainAttributes.getString(4);
                String string3 = obtainAttributes.getString(5);
                int resourceId = obtainAttributes.getResourceId(1, 0);
                int integer = obtainAttributes.getInteger(2, 1);
                int integer2 = obtainAttributes.getInteger(3, 500);
                String string4 = obtainAttributes.getString(6);
                obtainAttributes.recycle();
                if (string == null || string2 == null || string3 == null) {
                    ArrayList arrayList = new ArrayList();
                    while (xmlResourceParser.next() != 3) {
                        if (xmlResourceParser.getEventType() == 2) {
                            if (xmlResourceParser.getName().equals("font")) {
                                TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), a0.b.f22w);
                                int i7 = 8;
                                if (!obtainAttributes2.hasValue(8)) {
                                    i7 = 1;
                                }
                                int i8 = obtainAttributes2.getInt(i7, 400);
                                boolean z6 = 1 == obtainAttributes2.getInt(obtainAttributes2.hasValue(6) ? 6 : 2, 0);
                                int i9 = 9;
                                if (!obtainAttributes2.hasValue(9)) {
                                    i9 = 3;
                                }
                                int i10 = 7;
                                if (!obtainAttributes2.hasValue(7)) {
                                    i10 = 4;
                                }
                                String string5 = obtainAttributes2.getString(i10);
                                int i11 = obtainAttributes2.getInt(i9, 0);
                                int i12 = obtainAttributes2.hasValue(5) ? 5 : 0;
                                int resourceId2 = obtainAttributes2.getResourceId(i12, 0);
                                String string6 = obtainAttributes2.getString(i12);
                                obtainAttributes2.recycle();
                                while (xmlResourceParser.next() != 3) {
                                    c(xmlResourceParser);
                                }
                                arrayList.add(new C0063d(i8, i11, resourceId2, string6, string5, z6));
                            } else {
                                c(xmlResourceParser);
                            }
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        return new c((C0063d[]) arrayList.toArray(new C0063d[0]));
                    }
                } else {
                    while (xmlResourceParser.next() != 3) {
                        c(xmlResourceParser);
                    }
                    return new e(new f(string, string2, string3, b(resourceId, resources)), integer, integer2, string4);
                }
            } else {
                c(xmlResourceParser);
            }
            return null;
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List b(int i7, Resources resources) {
        if (i7 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i7);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a.a(obtainTypedArray, 0) == 1) {
                for (int i8 = 0; i8 < obtainTypedArray.length(); i8++) {
                    int resourceId = obtainTypedArray.getResourceId(i8, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i7);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    public static void c(XmlResourceParser xmlResourceParser) {
        int i7 = 1;
        while (i7 > 0) {
            int next = xmlResourceParser.next();
            if (next == 2) {
                i7++;
            } else if (next == 3) {
                i7--;
            }
        }
    }
}
