package b1;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f2358a;

    /* renamed from: b  reason: collision with root package name */
    public int f2359b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f2360c = -1;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<a> f2361d = new SparseArray<>();
    public SparseArray<c> e = new SparseArray<>();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f2362a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<C0026b> f2363b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        public int f2364c;

        /* renamed from: d  reason: collision with root package name */
        public c f2365d;

        public a(Context context, XmlResourceParser xmlResourceParser) {
            this.f2364c = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), a0.b.m);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = obtainStyledAttributes.getIndex(i7);
                if (index == 0) {
                    this.f2362a = obtainStyledAttributes.getResourceId(index, this.f2362a);
                } else if (index == 1) {
                    this.f2364c = obtainStyledAttributes.getResourceId(index, this.f2364c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2364c);
                    context.getResources().getResourceName(this.f2364c);
                    if ("layout".equals(resourceTypeName)) {
                        c cVar = new c();
                        this.f2365d = cVar;
                        cVar.b((ConstraintLayout) LayoutInflater.from(context).inflate(this.f2364c, (ViewGroup) null));
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public final int a(float f7, float f8) {
            for (int i7 = 0; i7 < this.f2363b.size(); i7++) {
                if (this.f2363b.get(i7).a(f7, f8)) {
                    return i7;
                }
            }
            return -1;
        }
    }

    /* renamed from: b1.b$b  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0026b {

        /* renamed from: a  reason: collision with root package name */
        public float f2366a;

        /* renamed from: b  reason: collision with root package name */
        public float f2367b;

        /* renamed from: c  reason: collision with root package name */
        public float f2368c;

        /* renamed from: d  reason: collision with root package name */
        public float f2369d;
        public int e;

        /* renamed from: f  reason: collision with root package name */
        public c f2370f;

        public C0026b(Context context, XmlResourceParser xmlResourceParser) {
            this.f2366a = Float.NaN;
            this.f2367b = Float.NaN;
            this.f2368c = Float.NaN;
            this.f2369d = Float.NaN;
            this.e = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), a0.b.f15o);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = obtainStyledAttributes.getIndex(i7);
                if (index == 0) {
                    this.e = obtainStyledAttributes.getResourceId(index, this.e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    if ("layout".equals(resourceTypeName)) {
                        c cVar = new c();
                        this.f2370f = cVar;
                        cVar.b((ConstraintLayout) LayoutInflater.from(context).inflate(this.e, (ViewGroup) null));
                    }
                } else if (index == 1) {
                    this.f2369d = obtainStyledAttributes.getDimension(index, this.f2369d);
                } else if (index == 2) {
                    this.f2367b = obtainStyledAttributes.getDimension(index, this.f2367b);
                } else if (index == 3) {
                    this.f2368c = obtainStyledAttributes.getDimension(index, this.f2368c);
                } else if (index == 4) {
                    this.f2366a = obtainStyledAttributes.getDimension(index, this.f2366a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        public final boolean a(float f7, float f8) {
            if (!Float.isNaN(this.f2366a) && f7 < this.f2366a) {
                return false;
            }
            if (!Float.isNaN(this.f2367b) && f8 < this.f2367b) {
                return false;
            }
            if (Float.isNaN(this.f2368c) || f7 <= this.f2368c) {
                return Float.isNaN(this.f2369d) || f8 <= this.f2369d;
            }
            return false;
        }
    }

    public b(Context context, ConstraintLayout constraintLayout, int i7) {
        this.f2358a = constraintLayout;
        XmlResourceParser xml = context.getResources().getXml(i7);
        try {
            int eventType = xml.getEventType();
            a aVar = null;
            while (true) {
                boolean z6 = true;
                if (eventType != 1) {
                    if (eventType == 0) {
                        xml.getName();
                    } else if (eventType == 2) {
                        String name = xml.getName();
                        switch (name.hashCode()) {
                            case -1349929691:
                                if (name.equals("ConstraintSet")) {
                                    z6 = true;
                                    break;
                                }
                                z6 = true;
                                break;
                            case 80204913:
                                if (name.equals("State")) {
                                    z6 = true;
                                    break;
                                }
                                z6 = true;
                                break;
                            case 1382829617:
                                if (name.equals("StateSet")) {
                                    break;
                                }
                                z6 = true;
                                break;
                            case 1657696882:
                                if (name.equals("layoutDescription")) {
                                    z6 = false;
                                    break;
                                }
                                z6 = true;
                                break;
                            case 1901439077:
                                if (name.equals("Variant")) {
                                    z6 = true;
                                    break;
                                }
                                z6 = true;
                                break;
                            default:
                                z6 = true;
                                break;
                        }
                        if (z6) {
                            a aVar2 = new a(context, xml);
                            this.f2361d.put(aVar2.f2362a, aVar2);
                            aVar = aVar2;
                        } else if (z6) {
                            C0026b bVar = new C0026b(context, xml);
                            if (aVar != null) {
                                aVar.f2363b.add(bVar);
                            }
                        } else if (z6) {
                            a(context, xml);
                        }
                    }
                    eventType = xml.next();
                } else {
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e7) {
            e7.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:140:0x0226, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.content.Context r12, android.content.res.XmlResourceParser r13) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.b.a(android.content.Context, android.content.res.XmlResourceParser):void");
    }
}
