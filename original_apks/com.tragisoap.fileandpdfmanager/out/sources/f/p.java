package f;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.c0;
import androidx.appcompat.widget.d;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.t;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import o.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class p {

    /* renamed from: b  reason: collision with root package name */
    public static final Class<?>[] f4003b = {Context.class, AttributeSet.class};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f4004c = {16843375};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f4005d = {"android.widget.", "android.view.", "android.webkit."};
    public static final h<String, Constructor<? extends View>> e = new h<>();

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f4006a = new Object[2];

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: f  reason: collision with root package name */
        public final View f4007f;

        /* renamed from: g  reason: collision with root package name */
        public final String f4008g;

        /* renamed from: h  reason: collision with root package name */
        public Method f4009h;

        /* renamed from: i  reason: collision with root package name */
        public Context f4010i;

        public a(View view, String str) {
            this.f4007f = view;
            this.f4008g = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String str;
            Method method;
            if (this.f4009h == null) {
                Context context = this.f4007f.getContext();
                while (context != null) {
                    try {
                        if (!context.isRestricted() && (method = context.getClass().getMethod(this.f4008g, View.class)) != null) {
                            this.f4009h = method;
                            this.f4010i = context;
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                    context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
                }
                int id = this.f4007f.getId();
                if (id == -1) {
                    str = "";
                } else {
                    StringBuilder d7 = androidx.activity.h.d(" with id '");
                    d7.append(this.f4007f.getContext().getResources().getResourceEntryName(id));
                    d7.append("'");
                    str = d7.toString();
                }
                StringBuilder d8 = androidx.activity.h.d("Could not find method ");
                d8.append(this.f4008g);
                d8.append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                d8.append(this.f4007f.getClass());
                d8.append(str);
                throw new IllegalStateException(d8.toString());
            }
            try {
                this.f4009h.invoke(this.f4010i, view);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e7) {
                throw new IllegalStateException("Could not execute method for android:onClick", e7);
            }
        }
    }

    public d a(Context context, AttributeSet attributeSet) {
        return new d(context, attributeSet);
    }

    public AppCompatButton b(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    public f c(Context context, AttributeSet attributeSet) {
        return new f(context, attributeSet);
    }

    public t d(Context context, AttributeSet attributeSet) {
        return new t(context, attributeSet);
    }

    public c0 e(Context context, AttributeSet attributeSet) {
        return new c0(context, attributeSet);
    }

    public final View f(Context context, String str, String str2) {
        String str3;
        h<String, Constructor<? extends View>> hVar = e;
        Constructor<? extends View> orDefault = hVar.getOrDefault(str, null);
        if (orDefault == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            orDefault = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f4003b);
            hVar.put(str, orDefault);
        }
        orDefault.setAccessible(true);
        return (View) orDefault.newInstance(this.f4006a);
    }
}
