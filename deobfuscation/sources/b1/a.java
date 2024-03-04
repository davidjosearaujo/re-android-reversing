package b1;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.fragment.app.s0;
import com.davemorrissey.labs.subscaleview.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import p.p;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public boolean f2351a;

    /* renamed from: b */
    public String f2352b;

    /* renamed from: c */
    public int f2353c;

    /* renamed from: d */
    public int f2354d;
    public float e;

    /* renamed from: f */
    public String f2355f;

    /* renamed from: g */
    public boolean f2356g;

    /* renamed from: h */
    public int f2357h;

    public a(a aVar, Object obj) {
        this.f2351a = false;
        this.f2352b = aVar.f2352b;
        this.f2353c = aVar.f2353c;
        c(obj);
    }

    public a(String str, int i7, Object obj, boolean z6) {
        this.f2352b = str;
        this.f2353c = i7;
        this.f2351a = z6;
        c(obj);
    }

    public static void a(Context context, XmlResourceParser xmlResourceParser, HashMap hashMap) {
        int resourceId;
        float dimension;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), a0.b.f9h);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        int i7 = 0;
        boolean z6 = false;
        Object obj = null;
        for (int i8 = 0; i8 < indexCount; i8++) {
            int index = obtainStyledAttributes.getIndex(i8);
            int i9 = 1;
            if (index == 0) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == 10) {
                str = obtainStyledAttributes.getString(index);
                z6 = true;
            } else if (index == 1) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                i7 = 6;
            } else {
                if (index == 3) {
                    i9 = 3;
                } else if (index == 2) {
                    i9 = 4;
                } else {
                    if (index == 7) {
                        dimension = TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics());
                    } else if (index == 4) {
                        dimension = obtainStyledAttributes.getDimension(index, 0.0f);
                    } else if (index == 5) {
                        obj = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                        i7 = 2;
                    } else {
                        if (index == 6) {
                            resourceId = obtainStyledAttributes.getInteger(index, -1);
                        } else if (index == 9) {
                            obj = obtainStyledAttributes.getString(index);
                            i7 = 5;
                        } else if (index == 8) {
                            resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            if (resourceId == -1) {
                                resourceId = obtainStyledAttributes.getInt(index, -1);
                            }
                            i9 = 8;
                        }
                        obj = Integer.valueOf(resourceId);
                        i7 = i9;
                    }
                    obj = Float.valueOf(dimension);
                    i7 = 7;
                }
                resourceId = obtainStyledAttributes.getColor(index, 0);
                obj = Integer.valueOf(resourceId);
                i7 = i9;
            }
        }
        if (str != null && obj != null) {
            hashMap.put(str, new a(str, i7, obj, z6));
        }
        obtainStyledAttributes.recycle();
    }

    public static void b(View view, HashMap<String, a> hashMap) {
        StringBuilder sb;
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            a aVar = hashMap.get(str);
            String h7 = !aVar.f2351a ? s0.h("set", str) : str;
            try {
            } catch (IllegalAccessException e) {
                e = e;
                sb = new StringBuilder();
                sb.append(" Custom Attribute \"");
                sb.append(str);
                sb.append("\" not found on ");
                sb.append(cls.getName());
                Log.e("TransitionLayout", sb.toString());
                e.printStackTrace();
            } catch (NoSuchMethodException e7) {
                Log.e("TransitionLayout", e7.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(cls.getName());
                sb2.append(" must have a method ");
                sb2.append(h7);
                Log.e("TransitionLayout", sb2.toString());
            } catch (InvocationTargetException e8) {
                e = e8;
                sb = new StringBuilder();
                sb.append(" Custom Attribute \"");
                sb.append(str);
                sb.append("\" not found on ");
                sb.append(cls.getName());
                Log.e("TransitionLayout", sb.toString());
                e.printStackTrace();
            }
            switch (p.a(aVar.f2353c)) {
                case 0:
                    cls.getMethod(h7, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f2354d));
                    continue;
                case 1:
                    cls.getMethod(h7, Float.TYPE).invoke(view, Float.valueOf(aVar.e));
                    continue;
                case 2:
                    cls.getMethod(h7, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f2357h));
                    continue;
                case 3:
                    Method method = cls.getMethod(h7, Drawable.class);
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(aVar.f2357h);
                    method.invoke(view, colorDrawable);
                    continue;
                case 4:
                    cls.getMethod(h7, CharSequence.class).invoke(view, aVar.f2355f);
                    continue;
                case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                    cls.getMethod(h7, Boolean.TYPE).invoke(view, Boolean.valueOf(aVar.f2356g));
                    continue;
                case 6:
                    cls.getMethod(h7, Float.TYPE).invoke(view, Float.valueOf(aVar.e));
                    continue;
                case 7:
                    cls.getMethod(h7, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f2354d));
                    continue;
                default:
                    continue;
            }
            Log.e("TransitionLayout", e7.getMessage());
            Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
            StringBuilder sb22 = new StringBuilder();
            sb22.append(cls.getName());
            sb22.append(" must have a method ");
            sb22.append(h7);
            Log.e("TransitionLayout", sb22.toString());
        }
    }

    public final void c(Object obj) {
        switch (p.a(this.f2353c)) {
            case 0:
            case 7:
                this.f2354d = ((Integer) obj).intValue();
                return;
            case 1:
            case 6:
                this.e = ((Float) obj).floatValue();
                return;
            case 2:
            case 3:
                this.f2357h = ((Integer) obj).intValue();
                return;
            case 4:
                this.f2355f = (String) obj;
                return;
            case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                this.f2356g = ((Boolean) obj).booleanValue();
                return;
            default:
                return;
        }
    }
}
